package com.tencent.mm.plugin.finder.upload;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.r.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.video.LocalVideoCropInfoParcelable;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager;", "", "()V", "MARK_DEL_FILES", "", "TAG", "getTAG", "()Ljava/lang/String;", "fileLock", "Ljava/lang/Object;", "lastCheckPostingTime", "", "getLastCheckPostingTime", "()J", "setLastCheckPostingTime", "(J)V", "postingFileClaimers", "", "Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager$FileClaimer;", "getPostingFileClaimers", "()Ljava/util/List;", "_genImageThumbFile", "originFilePath", "thumbFile", "thumbRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "canCheckPostingFolder", "", "checkPostingFolder", "", "clearMarkFiles", "copyImageThumbToPost", "imagePath", "thumbOriginPath", "copyVideoThumbFileToPost", "videoFilePath", "genImageThumbFileForPost", "genImageThumbFileTmp", "genVideoOriginThumbFile", "Landroid/graphics/Bitmap;", "vfsPath", "genVideoThumbFile", "videoPath", "targetWidth", "", "targetHeight", "Landroid/graphics/Rect;", "dstPath", "genVideoThumbFileForPost", "input", "genVideoThumbFileTmp", "getTmpImageThumbPath", "getTmpVideoThumbPath", "suffix", "getVideoFirstBitmap", "markPostFileToDelete", "path", "FileClaimer", "plugin-finder_release"})
public final class f
{
  static final String TAG = "finder.FinderPostFileManager";
  private static final String vSv = "MARK_DEL_FILES";
  private static final Object vSw;
  static long vSx;
  static final List<a> vSy;
  public static final f vSz;
  
  static
  {
    AppMethodBeat.i(167748);
    vSz = new f();
    TAG = "finder.FinderPostFileManager";
    vSv = "MARK_DEL_FILES";
    vSw = new Object();
    List localList = (List)new ArrayList();
    localList.add(new b());
    localList.add(new c());
    vSy = localList;
    AppMethodBeat.o(167748);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(167739);
    p.h(paramString, "input");
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
      str = gW(paramString1, String.valueOf(System.currentTimeMillis()));
    }
    paramString2 = s.k(paramString1, false);
    Log.i(TAG, "genVideoThumbFile savepath:" + str + ", input:" + paramString2);
    paramString1 = d.PF(paramString1);
    if (paramString1 == null)
    {
      paramString1 = i.vSX;
      if (i.avZ(str))
      {
        Log.i(TAG, "genVideoThumbFile file exist");
        AppMethodBeat.o(167742);
        return str;
      }
      if (com.tencent.mm.plugin.sight.base.e.aNx(paramString2) != null)
      {
        paramString1 = i.vSX;
        paramString1 = i.dK(paramString2, 4);
        paramInt1 = SightVideoJNI.getMp4RotateVFS(paramString2);
        paramString1 = com.tencent.mm.plugin.sight.base.e.az(paramString2, paramString1.x, paramString1.y);
        Log.i(TAG, "genVideoThumbFile file %s rotate %d", new Object[] { paramString2, Integer.valueOf(paramInt1) });
        if (paramString1 != null) {
          BitmapUtil.saveBitmapToImage(paramString1, 70, Bitmap.CompressFormat.JPEG, str, false);
        }
      }
      if (!s.YS(str)) {
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
      paramRect = new Rect(paramRect.left, paramRect.bottom, paramRect.right, paramRect.top);
      p.g(paramString2, "cropThumb");
      localCanvas.drawBitmap(paramString1, paramRect, new Rect(0, 0, paramString2.getWidth(), paramString2.getHeight()), new Paint());
    }
    for (;;)
    {
      BitmapUtil.saveBitmapToImage(paramString2, 80, Bitmap.CompressFormat.JPEG, str, false);
      break;
      Log.i(TAG, "genVideoThumbFile no rect");
      p.g(paramString2, "cropThumb");
      localCanvas.drawBitmap(paramString1, null, new Rect(0, 0, paramString2.getWidth(), paramString2.getHeight()), new Paint());
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(253074);
    p.h(paramString1, "input");
    p.h(paramString2, "dstPath");
    Log.i(TAG, "genVideoThumbFileForPost input:" + paramString1 + ", targetWidth:" + paramInt1 + ", targetHeight:" + paramInt2 + ", thumbRect:" + paramRect + ", dstPath:" + paramString2);
    paramString1 = a(paramString1, paramInt1, paramInt2, paramRect, paramString2);
    AppMethodBeat.o(253074);
    return paramString1;
  }
  
  public static String avT(String paramString)
  {
    AppMethodBeat.i(167740);
    p.h(paramString, "input");
    Object localObject = i.vSX;
    localObject = i.dK(paramString, 4);
    Log.i(TAG, "genVideoThumbFileTmp input:" + paramString + ", targetWidth:" + ((Point)localObject).x + ", targetHeight:" + ((Point)localObject).y);
    paramString = a(paramString, ((Point)localObject).x, ((Point)localObject).y, null, "");
    AppMethodBeat.o(167740);
    return paramString;
  }
  
  public static void avV(String paramString)
  {
    AppMethodBeat.i(167745);
    p.h(paramString, "path");
    synchronized (vSw)
    {
      Log.i(TAG, "FinderFileTrack markPostFileToDelete ".concat(String.valueOf(paramString)));
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
      Set localSet = localMultiProcessMMKV.getStringSet(vSv, (Set)new HashSet());
      if (localSet == null) {
        p.hyc();
      }
      localSet.add(paramString);
      localMultiProcessMMKV.putStringSet(vSv, localSet).commit();
      AppMethodBeat.o(167745);
      return;
    }
  }
  
  public static void dAW()
  {
    AppMethodBeat.i(167746);
    Set localSet;
    synchronized (vSw)
    {
      l = Util.currentTicks();
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getSingleDefault();
      localSet = localMultiProcessMMKV.getStringSet(vSv, (Set)new HashSet());
      if (localSet != null)
      {
        Iterator localIterator = ((Iterable)localSet).iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Log.i(TAG, "FinderFileTrack clearMarkFiles ".concat(String.valueOf(str)));
          s.deleteFile(str);
        }
      }
    }
    localObject2.putStringSet(vSv, (Set)new HashSet());
    long l = Util.ticksToNow(l);
    if ((localSet != null) && (localSet.size() > 0))
    {
      localObject3 = r.a.vgH;
      r.a.Fl(l);
    }
    Log.i(TAG, "clearMarkFolder cost:".concat(String.valueOf(l)));
    Object localObject3 = x.SXb;
    AppMethodBeat.o(167746);
  }
  
  public static boolean dAX()
  {
    AppMethodBeat.i(167747);
    long l1 = cl.aWy();
    long l2 = vSx;
    c localc = c.vCb;
    if (l1 - l2 > c.drh())
    {
      AppMethodBeat.o(167747);
      return true;
    }
    AppMethodBeat.o(167747);
    return false;
  }
  
  private static String gW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167738);
    p.h(paramString1, "originFilePath");
    p.h(paramString2, "suffix");
    StringBuilder localStringBuilder = new StringBuilder();
    al localal = al.waC;
    paramString1 = al.dEG() + "video_" + MD5Util.getMD5String(paramString1) + "_" + paramString2 + "_thumb";
    AppMethodBeat.o(167738);
    return paramString1;
  }
  
  public static String gX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253072);
    p.h(paramString1, "videoFilePath");
    p.h(paramString2, "thumbOriginPath");
    Object localObject = al.waC;
    localObject = al.awD(paramString1);
    Log.i(TAG, "copyVideoThumbFileToPost, videoFilePath:" + paramString1 + ", thumbOriginPath:" + paramString2 + ", thumbPostPath:" + (String)localObject);
    i locali = i.vSX;
    if (i.avZ(paramString2))
    {
      Log.i(TAG, "copyImageThumbFromTmpToPost exist, copy");
      s.nw(paramString2, (String)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(253072);
      return localObject;
      Log.i(TAG, "copyImageThumbFromTmpToPost not exist, generate");
      paramString2 = i.vSX;
      paramString2 = i.dK(paramString1, 4);
      Log.i(TAG, "genVideoThumbFileTmp videoFilePath:" + paramString1 + ", targetWidth:" + paramString2.x + ", targetHeight:" + paramString2.y);
      a(paramString1, paramString2.x, paramString2.y, null, (String)localObject);
    }
  }
  
  public static String gY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253075);
    p.h(paramString1, "imagePath");
    p.h(paramString2, "thumbOriginPath");
    Object localObject = al.waC;
    p.h(paramString1, "imagePath");
    localObject = al.dEH() + "image_" + MD5Util.getMD5String(paramString1) + "_" + s.boX(paramString1) + "_thumb";
    Log.i(TAG, "copyImageThumbFromTmpToPost, imagePath:" + paramString1 + ", thumbOriginPath:" + paramString2 + ", thumbPostPath:" + (String)localObject);
    i locali = i.vSX;
    if (i.avZ(paramString2))
    {
      Log.i(TAG, "copyImageThumbFromTmpToPost exist, copy");
      s.nw(paramString2, (String)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(253075);
      return localObject;
      Log.i(TAG, "copyImageThumbFromTmpToPost not exist, generate");
      gZ(paramString1, (String)localObject);
    }
  }
  
  private static String gZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253077);
    Object localObject = i.vSX;
    if (i.avZ(paramString2))
    {
      AppMethodBeat.o(253077);
      return paramString2;
    }
    localObject = i.vSX;
    localObject = i.dK(paramString1, 2);
    Bitmap localBitmap = BitmapUtil.createThumbCropBitmap(paramString1, ((Point)localObject).x, ((Point)localObject).y, true);
    Exif localExif = Exif.fromFile(paramString1);
    p.g(localExif, "Exif.fromFile(originFilePath)");
    int i = localExif.getOrientationInDegree();
    Log.i(TAG, "_genImageThumbFile, file %s rotate %d. originThumbWidth:%s, originThumbHeight:%s", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(((Point)localObject).x), Integer.valueOf(((Point)localObject).y) });
    if (localBitmap != null)
    {
      Log.i(TAG, "_genImageThumbFile, file %s cropThumbWidth:%s, cropThumbHeight:%s", new Object[] { paramString1, Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) });
      BitmapUtil.saveBitmapToImage(localBitmap, 70, Bitmap.CompressFormat.JPEG, paramString2, false);
    }
    AppMethodBeat.o(253077);
    return paramString2;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public final String a(String paramString, erf paramerf)
  {
    AppMethodBeat.i(167741);
    p.h(paramString, "input");
    p.h(paramerf, "thumbRect");
    c localc = c.vCb;
    int i = c.dqw().iTf;
    paramString = a(paramString, i, (int)((paramerf.top - paramerf.bottom) / (paramerf.right - paramerf.left) * i), new Rect(paramerf.left, paramerf.top, paramerf.right, paramerf.bottom));
    AppMethodBeat.o(167741);
    return paramString;
  }
  
  public final String ag(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253073);
    p.h(paramString, "input");
    al localal = al.waC;
    paramString = a(paramString, al.awD(paramString), paramInt1, paramInt2, null);
    AppMethodBeat.o(253073);
    return paramString;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager$FileClaimer;", "", "listOwnFiles", "", "", "name", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract List<String> dAY();
    
    public abstract String name();
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderPostFileManager$postingFileClaimers$1$1", "Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager$FileClaimer;", "listOwnFiles", "", "", "name", "plugin-finder_release"})
  public static final class b
    implements f.a
  {
    public final List<String> dAY()
    {
      AppMethodBeat.i(253070);
      Object localObject1 = new ArrayList();
      Iterator localIterator1 = ((Iterable)((PluginFinder)g.ah(PluginFinder.class)).getFeedStorage().dxD()).iterator();
      while (localIterator1.hasNext())
      {
        Object localObject2 = (FinderItem)localIterator1.next();
        Iterator localIterator2 = ((Iterable)((FinderItem)localObject2).getMediaList()).iterator();
        Object localObject3;
        while (localIterator2.hasNext())
        {
          localObject3 = (cjl)localIterator2.next();
          ((ArrayList)localObject1).add(((cjl)localObject3).url);
          ((ArrayList)localObject1).add(((cjl)localObject3).thumbUrl);
          ((ArrayList)localObject1).add(((cjl)localObject3).coverUrl);
          ((ArrayList)localObject1).add(((cjl)localObject3).MoR);
          localObject3 = ((cjl)localObject3).MfU;
          if (localObject3 != null)
          {
            localObject3 = ((acn)localObject3).Lnd;
            if (localObject3 != null)
            {
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add(((ejf)((Iterator)localObject3).next()).path);
              }
            }
          }
        }
        localIterator2 = ((Iterable)((FinderItem)localObject2).getHalfVideoMediaExtList()).iterator();
        while (localIterator2.hasNext())
        {
          localObject3 = (cjl)localIterator2.next();
          ((ArrayList)localObject1).add(((cjl)localObject3).url);
          ((ArrayList)localObject1).add(((cjl)localObject3).thumbUrl);
          ((ArrayList)localObject1).add(((cjl)localObject3).coverUrl);
          ((ArrayList)localObject1).add(((cjl)localObject3).MoR);
          localObject3 = ((cjl)localObject3).MfU;
          if (localObject3 != null)
          {
            localObject3 = ((acn)localObject3).Lnd;
            if (localObject3 != null)
            {
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject1).add(((ejf)((Iterator)localObject3).next()).path);
              }
            }
          }
        }
        label353:
        localObject2 = ((Iterable)((FinderItem)localObject2).getClipListExt()).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localIterator2 = ((Iterable)((FinderItem)((Iterator)localObject2).next()).getMediaList()).iterator();
          while (localIterator2.hasNext())
          {
            localObject3 = (cjl)localIterator2.next();
            ((ArrayList)localObject1).add(((cjl)localObject3).url);
            ((ArrayList)localObject1).add(((cjl)localObject3).thumbUrl);
            ((ArrayList)localObject1).add(((cjl)localObject3).coverUrl);
            ((ArrayList)localObject1).add(((cjl)localObject3).MoR);
            localObject3 = ((cjl)localObject3).MfU;
            if (localObject3 == null) {
              break label353;
            }
            localObject3 = ((acn)localObject3).Lnd;
            if (localObject3 == null) {
              break label353;
            }
            localObject3 = ((Iterable)localObject3).iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((ArrayList)localObject1).add(((ejf)((Iterator)localObject3).next()).path);
            }
          }
        }
      }
      localObject1 = (List)localObject1;
      AppMethodBeat.o(253070);
      return localObject1;
    }
    
    public final String name()
    {
      return "unsentFileClaimer";
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/upload/FinderPostFileManager$postingFileClaimers$1$2", "Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager$FileClaimer;", "listOwnFiles", "", "", "name", "plugin-finder_release"})
  public static final class c
    implements f.a
  {
    public final List<String> dAY()
    {
      AppMethodBeat.i(253071);
      Object localObject1 = new ArrayList();
      Object localObject2 = g.aAh();
      p.g(localObject2, "MMKernel.storage()");
      localObject2 = ((com.tencent.mm.kernel.e)localObject2).azQ().get(ar.a.Oly, "").toString();
      if (!Util.isNullOrNil((String)localObject2)) {}
      try
      {
        localObject2 = com.tencent.e.f.e.bqe((String)localObject2);
        localObject3 = Parcel.obtain();
        p.g(localObject3, "Parcel.obtain()");
        ((Parcel)localObject3).unmarshall((byte[])localObject2, 0, localObject2.length);
        ((Parcel)localObject3).setDataPosition(0);
        localObject2 = (Intent)Intent.CREATOR.createFromParcel((Parcel)localObject3);
        ((Intent)localObject2).setExtrasClassLoader(LocalVideoCropInfoParcelable.CREATOR.getClass().getClassLoader());
        ((ArrayList)localObject1).add(((Intent)localObject2).getStringExtra("VIDEO_COVER_URL"));
        localObject1 = (List)localObject1;
        AppMethodBeat.o(253071);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject3 = f.vSz;
          Log.e(f.getTAG(), String.valueOf(localException));
        }
      }
    }
    
    public final String name()
    {
      return "draftFileClaimer";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.f
 * JD-Core Version:    0.7.0.1
 */