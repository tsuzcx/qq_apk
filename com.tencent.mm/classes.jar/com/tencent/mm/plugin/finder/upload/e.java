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
import com.tencent.mm.model.ce;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.report.i.a;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.dqk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager;", "", "()V", "MARK_DEL_FILES", "", "TAG", "getTAG", "()Ljava/lang/String;", "fileLock", "Ljava/lang/Object;", "lastCheckPostingTime", "", "_genImageThumbFile", "originFilePath", "thumbFile", "thumbRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "canCheckPostingFolder", "", "checkPostingFolder", "", "unsentObjs", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "clearMarkFiles", "copyImageThumbToPost", "imagePath", "thumbOriginPath", "copyVideoThumbFileToPost", "videoFilePath", "genImageThumbFileForPost", "genImageThumbFileTmp", "genVideoOriginThumbFile", "Landroid/graphics/Bitmap;", "vfsPath", "genVideoThumbFile", "videoPath", "targetWidth", "", "targetHeight", "Landroid/graphics/Rect;", "dstPath", "genVideoThumbFileForPost", "input", "genVideoThumbFileTmp", "getTmpImageThumbPath", "getTmpVideoThumbPath", "suffix", "getVideoFirstBitmap", "markPostFileToDelete", "path", "plugin-finder_release"})
public final class e
{
  static final String TAG = "finder.FinderPostFileManager";
  private static final String rMU = "MARK_DEL_FILES";
  private static final Object rMV;
  static long rMW;
  public static final e rMX;
  
  static
  {
    AppMethodBeat.i(167748);
    rMX = new e();
    TAG = "finder.FinderPostFileManager";
    rMU = "MARK_DEL_FILES";
    rMV = new Object();
    AppMethodBeat.o(167748);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(167739);
    k.h(paramString, "input");
    ac.i(TAG, "genVideoThumbFileTmp input:" + paramString + ", targetWidth:" + paramInt1 + ", targetHeight:" + paramInt2 + ", thumbRect:" + paramRect);
    paramString = a(paramString, paramInt1, paramInt2, paramRect, "");
    AppMethodBeat.o(167739);
    return paramString;
  }
  
  static String a(String paramString1, int paramInt1, int paramInt2, Rect paramRect, String paramString2)
  {
    AppMethodBeat.i(167742);
    String str = paramString2;
    if (bs.isNullOrNil(paramString2)) {
      str = gg(paramString1, String.valueOf(System.currentTimeMillis()));
    }
    paramString2 = i.k(paramString1, false);
    ac.i(TAG, "genVideoThumbFile savepath:" + str + ", input:" + paramString2);
    paramString1 = d.Dl(paramString1);
    if (paramString1 == null)
    {
      paramString1 = h.rNr;
      if (h.aev(str))
      {
        ac.i(TAG, "genVideoThumbFile file exist");
        AppMethodBeat.o(167742);
        return str;
      }
      if (com.tencent.mm.plugin.sight.base.e.asx(paramString2) != null)
      {
        paramString1 = h.rNr;
        paramString1 = h.de(paramString2, 4);
        paramInt1 = SightVideoJNI.getMp4RotateVFS(paramString2);
        paramString1 = com.tencent.mm.plugin.sight.base.e.as(paramString2, paramString1.x, paramString1.y);
        ac.i(TAG, "genVideoThumbFile file %s rotate %d", new Object[] { paramString2, Integer.valueOf(paramInt1) });
        if (paramString1 != null) {
          f.a(paramString1, 70, Bitmap.CompressFormat.JPEG, str, false);
        }
      }
      if (!i.eA(str)) {
        ac.e(TAG, "genVideoThumbFile failed.");
      }
      AppMethodBeat.o(167742);
      return str;
    }
    paramString2 = Bitmap.createBitmap(paramInt1, paramInt2, paramString1.getConfig());
    Canvas localCanvas = new Canvas(paramString2);
    if (paramRect != null)
    {
      ac.i(TAG, "genVideoThumbFile crop by rect");
      paramRect = new Rect(paramRect.left, paramRect.bottom, paramRect.right, paramRect.top);
      k.g(paramString2, "cropThumb");
      localCanvas.drawBitmap(paramString1, paramRect, new Rect(0, 0, paramString2.getWidth(), paramString2.getHeight()), new Paint());
    }
    for (;;)
    {
      f.a(paramString2, 80, Bitmap.CompressFormat.JPEG, str, false);
      break;
      ac.i(TAG, "genVideoThumbFile no rect");
      k.g(paramString2, "cropThumb");
      localCanvas.drawBitmap(paramString1, null, new Rect(0, 0, paramString2.getWidth(), paramString2.getHeight()), new Paint());
    }
  }
  
  public static String a(String paramString, dqk paramdqk)
  {
    AppMethodBeat.i(167741);
    k.h(paramString, "input");
    k.h(paramdqk, "thumbRect");
    b localb = b.rCU;
    int i = b.cxY().hCK;
    paramString = a(paramString, i, (int)((paramdqk.top - paramdqk.bottom) / (paramdqk.right - paramdqk.left) * i), new Rect(paramdqk.left, paramdqk.top, paramdqk.right, paramdqk.bottom));
    AppMethodBeat.o(167741);
    return paramString;
  }
  
  public static String aeq(String paramString)
  {
    AppMethodBeat.i(167740);
    k.h(paramString, "input");
    Object localObject = h.rNr;
    localObject = h.de(paramString, 4);
    ac.i(TAG, "genVideoThumbFileTmp input:" + paramString + ", targetWidth:" + ((Point)localObject).x + ", targetHeight:" + ((Point)localObject).y);
    paramString = a(paramString, ((Point)localObject).x, ((Point)localObject).y, null, "");
    AppMethodBeat.o(167740);
    return paramString;
  }
  
  public static void aes(String paramString)
  {
    AppMethodBeat.i(167745);
    k.h(paramString, "path");
    synchronized (rMV)
    {
      ac.i(TAG, "markPostFileToDelete ".concat(String.valueOf(paramString)));
      aw localaw = aw.eVz();
      Set localSet = localaw.getStringSet(rMU, (Set)new HashSet());
      if (localSet == null) {
        k.fOy();
      }
      localSet.add(paramString);
      localaw.putStringSet(rMU, localSet).commit();
      AppMethodBeat.o(167745);
      return;
    }
  }
  
  public static void cCs()
  {
    AppMethodBeat.i(167746);
    Set localSet;
    synchronized (rMV)
    {
      l = bs.Gn();
      aw localaw = aw.eVz();
      localSet = localaw.getStringSet(rMU, (Set)new HashSet());
      if (localSet != null)
      {
        Iterator localIterator = ((Iterable)localSet).iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ac.i(TAG, "clearMarkFiles ".concat(String.valueOf(str)));
          i.deleteFile(str);
        }
      }
    }
    localObject2.putStringSet(rMU, (Set)new HashSet());
    long l = bs.aO(l);
    if ((localSet != null) && (localSet.size() > 0))
    {
      localObject3 = i.a.ryn;
      i.a.uw(l);
    }
    ac.i(TAG, "clearMarkFolder cost:".concat(String.valueOf(l)));
    Object localObject3 = y.KTp;
    AppMethodBeat.o(167746);
  }
  
  public static boolean cCt()
  {
    AppMethodBeat.i(167747);
    long l1 = ce.azH();
    long l2 = rMW;
    b localb = b.rCU;
    if (l1 - l2 > b.cyz())
    {
      AppMethodBeat.o(167747);
      return true;
    }
    AppMethodBeat.o(167747);
    return false;
  }
  
  private static String gg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167738);
    k.h(paramString1, "originFilePath");
    k.h(paramString2, "suffix");
    StringBuilder localStringBuilder = new StringBuilder();
    p localp = p.rQw;
    paramString1 = p.cDv() + "video_" + ah.dg(paramString1) + "_" + paramString2 + "_thumb";
    AppMethodBeat.o(167738);
    return paramString1;
  }
  
  static String gh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203502);
    Object localObject = h.rNr;
    if (h.aev(paramString2))
    {
      AppMethodBeat.o(203502);
      return paramString2;
    }
    localObject = h.rNr;
    localObject = h.de(paramString1, 2);
    Bitmap localBitmap = f.aH(paramString1, ((Point)localObject).x, ((Point)localObject).y);
    Exif localExif = Exif.fromFile(paramString1);
    k.g(localExif, "Exif.fromFile(originFilePath)");
    int i = localExif.getOrientationInDegree();
    ac.i(TAG, "_genImageThumbFile, file %s rotate %d. originThumbWidth:%s, originThumbHeight:%s", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(((Point)localObject).x), Integer.valueOf(((Point)localObject).y) });
    if (localBitmap != null)
    {
      ac.i(TAG, "_genImageThumbFile, file %s cropThumbWidth:%s, cropThumbHeight:%s", new Object[] { paramString1, Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) });
      f.a(localBitmap, 70, Bitmap.CompressFormat.JPEG, paramString2, false);
    }
    AppMethodBeat.o(203502);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.e
 * JD-Core Version:    0.7.0.1
 */