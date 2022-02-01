package com.tencent.mm.plugin.finder.upload;

import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.report.ah.a;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.fyb;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager;", "Lcom/tencent/mm/plugin/finder/publish/IFinderPostFileManager;", "()V", "MARK_DEL_FILES", "", "TAG", "getTAG", "()Ljava/lang/String;", "fileLock", "Ljava/lang/Object;", "lastCheckPostingTime", "", "getLastCheckPostingTime", "()J", "setLastCheckPostingTime", "(J)V", "postingFileClaimers", "", "Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager$FileClaimer;", "getPostingFileClaimers", "()Ljava/util/List;", "_genImageThumbFile", "originFilePath", "thumbFile", "thumbRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "canCheckPostingFolder", "", "checkPostingFolder", "", "clearMarkFiles", "copyImageThumbToPost", "imagePath", "thumbOriginPath", "copyVideoThumbFileToPost", "videoFilePath", "genImageThumbFileForPost", "genImageThumbFileTmp", "genVideoOriginThumbFile", "Landroid/graphics/Bitmap;", "vfsPath", "genVideoThumbFile", "videoPath", "targetWidth", "", "targetHeight", "Landroid/graphics/Rect;", "dstPath", "genVideoThumbFileForPost", "input", "genVideoThumbFileTmp", "getTmpImageThumbPath", "getTmpVideoThumbPath", "suffix", "getVideoFirstBitmap", "isInPosting", "path", "markPostFileToDelete", "moveFileToPost", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "moveFileToPostForNormal", "moveFileToPostForVLog", "ownFinderItemFiles", "finderItem", "ret", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "parseIntentOwnership", "intentStr", "FileClaimer", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements com.tencent.mm.plugin.finder.publish.a
{
  public static final f GbE;
  private static final String GbF;
  private static final Object GbG;
  private static long GbH;
  private static final List<a> GbI;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(167748);
    GbE = new f();
    TAG = "finder.FinderPostFileManager";
    GbF = "MARK_DEL_FILES";
    GbG = new Object();
    List localList = (List)new ArrayList();
    localList.add(new f.b());
    localList.add(new f.c());
    GbI = localList;
    AppMethodBeat.o(167748);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(167739);
    s.u(paramString, "input");
    Log.i(TAG, "genVideoThumbFileTmp input:" + paramString + ", targetWidth:" + paramInt1 + ", targetHeight:" + paramInt2 + ", thumbRect:" + paramRect);
    paramString = a(paramString, paramInt1, paramInt2, paramRect, "");
    AppMethodBeat.o(167739);
    return paramString;
  }
  
  private static String a(String paramString1, int paramInt1, int paramInt2, Rect paramRect, String paramString2)
  {
    AppMethodBeat.i(167742);
    String str = paramString2;
    if (Util.isNullOrNil(paramString2)) {
      str = ik(paramString1, String.valueOf(System.currentTimeMillis()));
    }
    paramString2 = y.n(paramString1, false);
    Log.i(TAG, "genVideoThumbFile savepath:" + str + ", input:" + paramString2);
    paramString1 = com.tencent.mm.plugin.mmsight.d.Pf(paramString1);
    if (paramString1 == null)
    {
      paramString1 = i.Gcb;
      if (i.aBl(str))
      {
        Log.i(TAG, "genVideoThumbFile file exist");
        AppMethodBeat.o(167742);
        return str;
      }
      if (com.tencent.mm.plugin.sight.base.f.aVX(paramString2) != null)
      {
        paramString1 = i.Gcb;
        paramString1 = i.eT(paramString2, 4);
        paramInt1 = SightVideoJNI.getMp4RotateVFS(paramString2);
        paramString1 = com.tencent.mm.plugin.sight.base.f.aK(paramString2, paramString1.x, paramString1.y);
        Log.i(TAG, "genVideoThumbFile file %s rotate %d", new Object[] { paramString2, Integer.valueOf(paramInt1) });
        if (paramString1 != null) {
          BitmapUtil.saveBitmapToImage(paramString1, 70, Bitmap.CompressFormat.JPEG, str, false);
        }
      }
      if (!y.ZC(str)) {
        Log.e(TAG, "genVideoThumbFile failed.");
      }
      AppMethodBeat.o(167742);
      return str;
    }
    paramString2 = Bitmap.createBitmap(paramInt1, paramInt2, paramString1.getConfig());
    Canvas localCanvas = new Canvas(paramString2);
    if (paramRect != null)
    {
      Log.i(TAG, "genVideoThumbFile crop by rect");
      localCanvas.drawBitmap(paramString1, new Rect(paramRect.left, paramRect.bottom, paramRect.right, paramRect.top), new Rect(0, 0, paramString2.getWidth(), paramString2.getHeight()), new Paint());
    }
    for (;;)
    {
      BitmapUtil.saveBitmapToImage(paramString2, 80, Bitmap.CompressFormat.JPEG, str, false);
      break;
      Log.i(TAG, "genVideoThumbFile no rect");
      localCanvas.drawBitmap(paramString1, null, new Rect(0, 0, paramString2.getWidth(), paramString2.getHeight()), new Paint());
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(342990);
    s.u(paramString1, "input");
    s.u(paramString2, "dstPath");
    Log.i(TAG, "genVideoThumbFileForPost input:" + paramString1 + ", targetWidth:" + paramInt1 + ", targetHeight:" + paramInt2 + ", thumbRect:" + paramRect + ", dstPath:" + paramString2);
    paramString1 = a(paramString1, paramInt1, paramInt2, paramRect, paramString2);
    AppMethodBeat.o(342990);
    return paramString1;
  }
  
  private static String a(String paramString1, String paramString2, fyb paramfyb)
  {
    AppMethodBeat.i(343024);
    paramfyb = i.Gcb;
    if (i.aBl(paramString2))
    {
      AppMethodBeat.o(343024);
      return paramString2;
    }
    paramfyb = i.Gcb;
    paramfyb = i.eT(paramString1, 2);
    Bitmap localBitmap = BitmapUtil.createThumbCropBitmap(paramString1, paramfyb.x, paramfyb.y, true);
    int i = Exif.fromFile(paramString1).getOrientationInDegree();
    Log.i(TAG, "_genImageThumbFile, file %s rotate %d. originThumbWidth:%s, originThumbHeight:%s", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(paramfyb.x), Integer.valueOf(paramfyb.y) });
    if (localBitmap != null)
    {
      Log.i(TAG, "_genImageThumbFile, file %s cropThumbWidth:%s, cropThumbHeight:%s", new Object[] { paramString1, Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) });
      BitmapUtil.saveBitmapToImage(localBitmap, 70, Bitmap.CompressFormat.JPEG, paramString2, false);
    }
    AppMethodBeat.o(343024);
    return paramString2;
  }
  
  public static String aBj(String paramString)
  {
    AppMethodBeat.i(167740);
    s.u(paramString, "input");
    Object localObject = i.Gcb;
    localObject = i.eT(paramString, 4);
    Log.i(TAG, "genVideoThumbFileTmp input:" + paramString + ", targetWidth:" + ((Point)localObject).x + ", targetHeight:" + ((Point)localObject).y);
    paramString = a(paramString, ((Point)localObject).x, ((Point)localObject).y, null, "");
    AppMethodBeat.o(167740);
    return paramString;
  }
  
  public static void aBk(String paramString)
  {
    AppMethodBeat.i(167745);
    s.u(paramString, "path");
    synchronized (GbG)
    {
      Log.i(TAG, s.X("FinderFileTrack markPostFileToDelete ", paramString));
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
      Set localSet = localMultiProcessMMKV.getStringSet(GbF, (Set)new HashSet());
      s.checkNotNull(localSet);
      localSet.add(paramString);
      localMultiProcessMMKV.putStringSet(GbF, localSet).commit();
      AppMethodBeat.o(167745);
      return;
    }
  }
  
  public static void eLa()
  {
    AppMethodBeat.i(167746);
    Set localSet;
    synchronized (GbG)
    {
      l = Util.currentTicks();
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
      localSet = localMultiProcessMMKV.getStringSet(GbF, (Set)new HashSet());
      if (localSet != null)
      {
        Iterator localIterator = ((Iterable)localSet).iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Log.i(TAG, s.X("FinderFileTrack clearMarkFiles ", str));
          y.deleteFile(str);
        }
      }
    }
    localObject2.putStringSet(GbF, (Set)new HashSet());
    long l = Util.ticksToNow(l);
    if ((localSet != null) && (localSet.size() > 0))
    {
      localObject3 = ah.a.Fts;
      ah.a.pN(l);
    }
    Log.i(TAG, s.X("clearMarkFolder cost:", Long.valueOf(l)));
    Object localObject3 = ah.aiuX;
    AppMethodBeat.o(167746);
  }
  
  public static void fdU()
  {
    AppMethodBeat.i(343038);
    long l1 = cn.bDu();
    long l2 = GbH;
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (l1 - l2 > com.tencent.mm.plugin.finder.storage.d.eQJ()) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Boolean)com.tencent.mm.plugin.finder.storage.d.eSZ().bmg()).booleanValue()) {
        break;
      }
      AppMethodBeat.o(343038);
      return;
    }
    Log.i(TAG, "FinderFileTrack checkPostingFolder");
    GbH = cn.bDu();
    for (;;)
    {
      Set localSet;
      Object localObject3;
      Object localObject6;
      try
      {
        localObject1 = bm.GlZ;
        localObject1 = bm.fiu();
        localSet = (Set)new LinkedHashSet();
        localObject4 = y.eB((String)localObject1, false);
        if (localObject4 == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            break label375;
          }
          localObject1 = (Collection)ab.aivy;
          localSet.addAll((Collection)localObject1);
          localObject1 = ((Iterable)GbI).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label491;
          }
          localObject3 = (a)((Iterator)localObject1).next();
          localObject5 = (Iterable)((a)localObject3).fdV();
          localObject4 = (Collection)new ArrayList();
          localObject5 = ((Iterable)localObject5).iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break label385;
          }
          localObject6 = ((Iterator)localObject5).next();
          String str = (String)localObject6;
          if ((str == null) || (s.p(str, ""))) {
            break label536;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          ((Collection)localObject4).add(localObject6);
          continue;
        }
        localObject3 = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
      }
      finally
      {
        Log.printErrStackTrace(TAG, localThrowable, "checkPostingFolder", new Object[0]);
        AppMethodBeat.o(343038);
        return;
      }
      Object localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(s.X(localThrowable, ((j)((Iterator)localObject4).next()).name));
      }
      Object localObject2 = (List)localObject3;
      continue;
      label375:
      localObject2 = (Collection)localObject2;
      continue;
      label385:
      localObject4 = (List)localObject4;
      Object localObject5 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (String)((Iterator)localObject5).next();
        Log.i(TAG, "ownership, " + ((a)localObject3).name() + " owns:" + localObject6);
      }
      an.hA((Collection)localSet).removeAll((Collection)localObject4);
      continue;
      label491:
      localObject2 = ((Iterable)localSet).iterator();
      while (((Iterator)localObject2).hasNext()) {
        aBk((String)((Iterator)localObject2).next());
      }
      AppMethodBeat.o(343038);
      return;
      label536:
      i = 0;
    }
  }
  
  private static String ik(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167738);
    s.u(paramString1, "originFilePath");
    s.u(paramString2, "suffix");
    StringBuilder localStringBuilder = new StringBuilder();
    bm localbm = bm.GlZ;
    paramString1 = bm.fit() + "video_" + MD5Util.getMD5String(paramString1) + '_' + paramString2 + "_thumb";
    AppMethodBeat.o(167738);
    return paramString1;
  }
  
  public static String il(String paramString1, String paramString2)
  {
    AppMethodBeat.i(342985);
    s.u(paramString1, "videoFilePath");
    s.u(paramString2, "thumbOriginPath");
    Object localObject = bm.GlZ;
    localObject = bm.aCi(paramString1);
    Log.i(TAG, "copyVideoThumbFileToPost, videoFilePath:" + paramString1 + ", thumbOriginPath:" + paramString2 + ", thumbPostPath:" + (String)localObject);
    i locali = i.Gcb;
    if (i.aBl(paramString2))
    {
      Log.i(TAG, "copyImageThumbFromTmpToPost exist, copy");
      y.O(paramString2, (String)localObject, false);
    }
    for (;;)
    {
      AppMethodBeat.o(342985);
      return localObject;
      Log.i(TAG, "copyImageThumbFromTmpToPost not exist, generate");
      paramString2 = i.Gcb;
      paramString2 = i.eT(paramString1, 4);
      Log.i(TAG, "genVideoThumbFileTmp videoFilePath:" + paramString1 + ", targetWidth:" + paramString2.x + ", targetHeight:" + paramString2.y);
      a(paramString1, paramString2.x, paramString2.y, null, (String)localObject);
    }
  }
  
  public static String im(String paramString1, String paramString2)
  {
    AppMethodBeat.i(343017);
    s.u(paramString1, "imagePath");
    s.u(paramString2, "thumbOriginPath");
    Object localObject = bm.GlZ;
    s.u(paramString1, "imagePath");
    localObject = bm.fiu() + "image_" + MD5Util.getMD5String(paramString1) + '_' + y.bEm(paramString1) + "_thumb";
    Log.i(TAG, "copyImageThumbFromTmpToPost, imagePath:" + paramString1 + ", thumbOriginPath:" + paramString2 + ", thumbPostPath:" + (String)localObject);
    i locali = i.Gcb;
    if (i.aBl(paramString2))
    {
      Log.i(TAG, "copyImageThumbFromTmpToPost exist, copy");
      y.O(paramString2, (String)localObject, false);
    }
    for (;;)
    {
      AppMethodBeat.o(343017);
      return localObject;
      Log.i(TAG, "copyImageThumbFromTmpToPost not exist, generate");
      a(paramString1, (String)localObject, null);
    }
  }
  
  public final String a(String paramString, fyb paramfyb)
  {
    AppMethodBeat.i(167741);
    s.u(paramString, "input");
    s.u(paramfyb, "thumbRect");
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    int i = com.tencent.mm.plugin.finder.storage.d.ePU().oCa;
    paramString = a(paramString, i, (int)((paramfyb.top - paramfyb.bottom) / (paramfyb.right - paramfyb.left) * i), new Rect(paramfyb.left, paramfyb.top, paramfyb.right, paramfyb.bottom));
    AppMethodBeat.o(167741);
    return paramString;
  }
  
  public final String ao(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(343069);
    s.u(paramString, "input");
    bm localbm = bm.GlZ;
    paramString = a(paramString, bm.aCi(paramString), paramInt1, paramInt2, null);
    AppMethodBeat.o(343069);
    return paramString;
  }
  
  public final String azz(String paramString)
  {
    AppMethodBeat.i(343075);
    s.u(paramString, "originFilePath");
    s.u(paramString, "originFilePath");
    Object localObject = new StringBuilder();
    bm localbm = bm.GlZ;
    localObject = bm.fit() + "image_" + MD5Util.getMD5String(paramString) + '_' + y.bEm(paramString) + "_thumb";
    Log.i(TAG, "genImageThumbFileTmp " + paramString + ", " + (String)localObject + ", " + null);
    paramString = a(paramString, (String)localObject, null);
    AppMethodBeat.o(343075);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager$FileClaimer;", "", "listOwnFiles", "", "", "name", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract List<String> fdV();
    
    public abstract String name();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.f
 * JD-Core Version:    0.7.0.1
 */