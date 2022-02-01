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
import com.tencent.mm.plugin.finder.report.e.a;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.dkt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import d.l;
import d.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager;", "", "()V", "MARK_DEL_FILES", "", "TAG", "getTAG", "()Ljava/lang/String;", "fileLock", "Ljava/lang/Object;", "lastCheckPostingTime", "", "_genImageThumbFile", "originFilePath", "thumbFile", "thumbRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "canCheckPostingFolder", "", "checkPostingFolder", "", "unsentObjs", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "clearMarkFiles", "copyImageThumbToPost", "imagePath", "thumbOriginPath", "copyVideoThumbFileToPost", "videoFilePath", "genImageThumbFileForPost", "genImageThumbFileTmp", "genVideoOriginThumbFile", "Landroid/graphics/Bitmap;", "vfsPath", "genVideoThumbFile", "videoPath", "targetWidth", "", "targetHeight", "Landroid/graphics/Rect;", "dstPath", "genVideoThumbFileForPost", "input", "genVideoThumbFileTmp", "getTmpImageThumbPath", "getTmpVideoThumbPath", "suffix", "getVideoFirstBitmap", "markPostFileToDelete", "path", "plugin-finder_release"})
public final class e
{
  static final String TAG = "finder.FinderPostFileManager";
  private static final String qQT = "MARK_DEL_FILES";
  private static final Object qQU;
  static long qQV;
  public static final e qQW;
  
  static
  {
    AppMethodBeat.i(167748);
    qQW = new e();
    TAG = "finder.FinderPostFileManager";
    qQT = "MARK_DEL_FILES";
    qQU = new Object();
    AppMethodBeat.o(167748);
  }
  
  public static String ZE(String paramString)
  {
    AppMethodBeat.i(167740);
    d.g.b.k.h(paramString, "input");
    Object localObject = h.qRq;
    localObject = h.cY(paramString, 4);
    ad.i(TAG, "genVideoThumbFileTmp input:" + paramString + ", targetWidth:" + ((Point)localObject).x + ", targetHeight:" + ((Point)localObject).y);
    paramString = a(paramString, ((Point)localObject).x, ((Point)localObject).y, null, "");
    AppMethodBeat.o(167740);
    return paramString;
  }
  
  public static void ZG(String paramString)
  {
    AppMethodBeat.i(167745);
    d.g.b.k.h(paramString, "path");
    synchronized (qQU)
    {
      ad.i(TAG, "markPostFileToDelete ".concat(String.valueOf(paramString)));
      ax localax = ax.eGe();
      Set localSet = localax.getStringSet(qQT, (Set)new HashSet());
      if (localSet == null) {
        d.g.b.k.fvU();
      }
      localSet.add(paramString);
      localax.putStringSet(qQT, localSet).commit();
      AppMethodBeat.o(167745);
      return;
    }
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(167739);
    d.g.b.k.h(paramString, "input");
    ad.i(TAG, "genVideoThumbFileTmp input:" + paramString + ", targetWidth:" + paramInt1 + ", targetHeight:" + paramInt2 + ", thumbRect:" + paramRect);
    paramString = a(paramString, paramInt1, paramInt2, paramRect, "");
    AppMethodBeat.o(167739);
    return paramString;
  }
  
  static String a(String paramString1, int paramInt1, int paramInt2, Rect paramRect, String paramString2)
  {
    AppMethodBeat.i(167742);
    String str = paramString2;
    if (bt.isNullOrNil(paramString2)) {
      str = fS(paramString1, String.valueOf(System.currentTimeMillis()));
    }
    paramString2 = i.k(paramString1, false);
    ad.i(TAG, "genVideoThumbFile savepath:" + str + ", input:" + paramString2);
    paramString1 = d.zg(paramString1);
    if (paramString1 == null)
    {
      paramString1 = h.qRq;
      if (h.ZJ(str))
      {
        ad.i(TAG, "genVideoThumbFile file exist");
        AppMethodBeat.o(167742);
        return str;
      }
      if (com.tencent.mm.plugin.sight.base.e.ano(paramString2) != null)
      {
        paramString1 = h.qRq;
        paramString1 = h.cY(paramString2, 4);
        paramInt1 = SightVideoJNI.getMp4RotateVFS(paramString2);
        paramString1 = com.tencent.mm.plugin.sight.base.e.at(paramString2, paramString1.x, paramString1.y);
        ad.i(TAG, "genVideoThumbFile file %s rotate %d", new Object[] { paramString2, Integer.valueOf(paramInt1) });
        if (paramString1 != null) {
          f.a(paramString1, 70, Bitmap.CompressFormat.JPEG, str, false);
        }
      }
      if (!i.eK(str)) {
        ad.e(TAG, "genVideoThumbFile failed.");
      }
      AppMethodBeat.o(167742);
      return str;
    }
    paramString2 = Bitmap.createBitmap(paramInt1, paramInt2, paramString1.getConfig());
    Canvas localCanvas = new Canvas(paramString2);
    if (paramRect != null)
    {
      ad.i(TAG, "genVideoThumbFile crop by rect");
      paramRect = new Rect(paramRect.left, paramRect.bottom, paramRect.right, paramRect.top);
      d.g.b.k.g(paramString2, "cropThumb");
      localCanvas.drawBitmap(paramString1, paramRect, new Rect(0, 0, paramString2.getWidth(), paramString2.getHeight()), new Paint());
    }
    for (;;)
    {
      f.a(paramString2, 80, Bitmap.CompressFormat.JPEG, str, false);
      break;
      ad.i(TAG, "genVideoThumbFile no rect");
      d.g.b.k.g(paramString2, "cropThumb");
      localCanvas.drawBitmap(paramString1, null, new Rect(0, 0, paramString2.getWidth(), paramString2.getHeight()), new Paint());
    }
  }
  
  public static String a(String paramString, dkt paramdkt)
  {
    AppMethodBeat.i(167741);
    d.g.b.k.h(paramString, "input");
    d.g.b.k.h(paramdkt, "thumbRect");
    b localb = b.qJA;
    int i = b.coB().hci;
    paramString = a(paramString, i, (int)((paramdkt.top - paramdkt.bottom) / (paramdkt.right - paramdkt.left) * i), new Rect(paramdkt.left, paramdkt.top, paramdkt.right, paramdkt.bottom));
    AppMethodBeat.o(167741);
    return paramString;
  }
  
  public static void cry()
  {
    AppMethodBeat.i(167746);
    Set localSet;
    synchronized (qQU)
    {
      l = bt.GC();
      ax localax = ax.eGe();
      localSet = localax.getStringSet(qQT, (Set)new HashSet());
      if (localSet != null)
      {
        Iterator localIterator = ((Iterable)localSet).iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ad.i(TAG, "clearMarkFiles ".concat(String.valueOf(str)));
          i.deleteFile(str);
        }
      }
    }
    localObject2.putStringSet(qQT, (Set)new HashSet());
    long l = bt.aS(l);
    if ((localSet != null) && (localSet.size() > 0))
    {
      localObject3 = e.a.qFu;
      e.a.ql(l);
    }
    ad.i(TAG, "clearMarkFolder cost:".concat(String.valueOf(l)));
    Object localObject3 = y.JfV;
    AppMethodBeat.o(167746);
  }
  
  public static boolean crz()
  {
    AppMethodBeat.i(167747);
    long l1 = ce.asQ();
    long l2 = qQV;
    b localb = b.qJA;
    if (l1 - l2 > b.cpc())
    {
      AppMethodBeat.o(167747);
      return true;
    }
    AppMethodBeat.o(167747);
    return false;
  }
  
  private static String fS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167738);
    d.g.b.k.h(paramString1, "originFilePath");
    d.g.b.k.h(paramString2, "suffix");
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.plugin.finder.utils.k localk = com.tencent.mm.plugin.finder.utils.k.qTp;
    paramString1 = com.tencent.mm.plugin.finder.utils.k.csc() + "video_" + ai.du(paramString1) + "_" + paramString2 + "_thumb";
    AppMethodBeat.o(167738);
    return paramString1;
  }
  
  static String mC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199526);
    Object localObject = h.qRq;
    if (h.ZJ(paramString2))
    {
      AppMethodBeat.o(199526);
      return paramString2;
    }
    localObject = h.qRq;
    localObject = h.cY(paramString1, 2);
    Bitmap localBitmap = f.aE(paramString1, ((Point)localObject).x, ((Point)localObject).y);
    Exif localExif = Exif.fromFile(paramString1);
    d.g.b.k.g(localExif, "Exif.fromFile(originFilePath)");
    int i = localExif.getOrientationInDegree();
    ad.i(TAG, "_genImageThumbFile, file %s rotate %d. originThumbWidth:%s, originThumbHeight:%s", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(((Point)localObject).x), Integer.valueOf(((Point)localObject).y) });
    if (localBitmap != null)
    {
      ad.i(TAG, "_genImageThumbFile, file %s cropThumbWidth:%s, cropThumbHeight:%s", new Object[] { paramString1, Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) });
      f.a(localBitmap, 70, Bitmap.CompressFormat.JPEG, paramString2, false);
    }
    AppMethodBeat.o(199526);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.e
 * JD-Core Version:    0.7.0.1
 */