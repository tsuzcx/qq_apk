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
import com.tencent.mm.model.ch;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.finder.report.o.a;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import d.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderPostFileManager;", "", "()V", "MARK_DEL_FILES", "", "TAG", "getTAG", "()Ljava/lang/String;", "fileLock", "Ljava/lang/Object;", "lastCheckPostingTime", "", "_genImageThumbFile", "originFilePath", "thumbFile", "thumbRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "canCheckPostingFolder", "", "checkPostingFolder", "", "unsentObjs", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "clearMarkFiles", "copyImageThumbToPost", "imagePath", "thumbOriginPath", "copyVideoThumbFileToPost", "videoFilePath", "genImageThumbFileForPost", "genImageThumbFileTmp", "genVideoOriginThumbFile", "Landroid/graphics/Bitmap;", "vfsPath", "genVideoThumbFile", "videoPath", "targetWidth", "", "targetHeight", "Landroid/graphics/Rect;", "dstPath", "genVideoThumbFileForPost", "input", "genVideoThumbFileTmp", "getTmpImageThumbPath", "getTmpVideoThumbPath", "suffix", "getVideoFirstBitmap", "markPostFileToDelete", "path", "plugin-finder_release"})
public final class f
{
  static final String TAG = "finder.FinderPostFileManager";
  private static final String sUm = "MARK_DEL_FILES";
  private static final Object sUn;
  static long sUo;
  public static final f sUp;
  
  static
  {
    AppMethodBeat.i(167748);
    sUp = new f();
    TAG = "finder.FinderPostFileManager";
    sUm = "MARK_DEL_FILES";
    sUn = new Object();
    AppMethodBeat.o(167748);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2, Rect paramRect)
  {
    AppMethodBeat.i(167739);
    p.h(paramString, "input");
    ae.i(TAG, "genVideoThumbFileTmp input:" + paramString + ", targetWidth:" + paramInt1 + ", targetHeight:" + paramInt2 + ", thumbRect:" + paramRect);
    paramString = a(paramString, paramInt1, paramInt2, paramRect, "");
    AppMethodBeat.o(167739);
    return paramString;
  }
  
  static String a(String paramString1, int paramInt1, int paramInt2, Rect paramRect, String paramString2)
  {
    AppMethodBeat.i(167742);
    String str = paramString2;
    if (bu.isNullOrNil(paramString2)) {
      str = gw(paramString1, String.valueOf(System.currentTimeMillis()));
    }
    paramString2 = o.k(paramString1, false);
    ae.i(TAG, "genVideoThumbFile savepath:" + str + ", input:" + paramString2);
    paramString1 = d.GS(paramString1);
    if (paramString1 == null)
    {
      paramString1 = i.sUG;
      if (i.ajM(str))
      {
        ae.i(TAG, "genVideoThumbFile file exist");
        AppMethodBeat.o(167742);
        return str;
      }
      if (e.ayN(paramString2) != null)
      {
        paramString1 = i.sUG;
        paramString1 = i.dz(paramString2, 4);
        paramInt1 = SightVideoJNI.getMp4RotateVFS(paramString2);
        paramString1 = e.aw(paramString2, paramString1.x, paramString1.y);
        ae.i(TAG, "genVideoThumbFile file %s rotate %d", new Object[] { paramString2, Integer.valueOf(paramInt1) });
        if (paramString1 != null) {
          h.a(paramString1, 70, Bitmap.CompressFormat.JPEG, str, false);
        }
      }
      if (!o.fB(str)) {
        ae.e(TAG, "genVideoThumbFile failed.");
      }
      AppMethodBeat.o(167742);
      return str;
    }
    paramString2 = Bitmap.createBitmap(paramInt1, paramInt2, paramString1.getConfig());
    Canvas localCanvas = new Canvas(paramString2);
    if (paramRect != null)
    {
      ae.i(TAG, "genVideoThumbFile crop by rect");
      paramRect = new Rect(paramRect.left, paramRect.bottom, paramRect.right, paramRect.top);
      p.g(paramString2, "cropThumb");
      localCanvas.drawBitmap(paramString1, paramRect, new Rect(0, 0, paramString2.getWidth(), paramString2.getHeight()), new Paint());
    }
    for (;;)
    {
      h.a(paramString2, 80, Bitmap.CompressFormat.JPEG, str, false);
      break;
      ae.i(TAG, "genVideoThumbFile no rect");
      p.g(paramString2, "cropThumb");
      localCanvas.drawBitmap(paramString1, null, new Rect(0, 0, paramString2.getWidth(), paramString2.getHeight()), new Paint());
    }
  }
  
  public static String a(String paramString, dwz paramdwz)
  {
    AppMethodBeat.i(167741);
    p.h(paramString, "input");
    p.h(paramdwz, "thumbRect");
    b localb = b.sHP;
    int i = b.cGT().hYh;
    paramString = a(paramString, i, (int)((paramdwz.top - paramdwz.bottom) / (paramdwz.right - paramdwz.left) * i), new Rect(paramdwz.left, paramdwz.top, paramdwz.right, paramdwz.bottom));
    AppMethodBeat.o(167741);
    return paramString;
  }
  
  public static String ajH(String paramString)
  {
    AppMethodBeat.i(167740);
    p.h(paramString, "input");
    Object localObject = i.sUG;
    localObject = i.dz(paramString, 4);
    ae.i(TAG, "genVideoThumbFileTmp input:" + paramString + ", targetWidth:" + ((Point)localObject).x + ", targetHeight:" + ((Point)localObject).y);
    paramString = a(paramString, ((Point)localObject).x, ((Point)localObject).y, null, "");
    AppMethodBeat.o(167740);
    return paramString;
  }
  
  public static void ajJ(String paramString)
  {
    AppMethodBeat.i(167745);
    p.h(paramString, "path");
    synchronized (sUn)
    {
      ae.i(TAG, "markPostFileToDelete ".concat(String.valueOf(paramString)));
      ay localay = ay.fpb();
      Set localSet = localay.getStringSet(sUm, (Set)new HashSet());
      if (localSet == null) {
        p.gkB();
      }
      localSet.add(paramString);
      localay.putStringSet(sUm, localSet).commit();
      AppMethodBeat.o(167745);
      return;
    }
  }
  
  public static void cNl()
  {
    AppMethodBeat.i(167746);
    Set localSet;
    synchronized (sUn)
    {
      l = bu.HQ();
      ay localay = ay.fpb();
      localSet = localay.getStringSet(sUm, (Set)new HashSet());
      if (localSet != null)
      {
        Iterator localIterator = ((Iterable)localSet).iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ae.i(TAG, "clearMarkFiles ".concat(String.valueOf(str)));
          o.deleteFile(str);
        }
      }
    }
    localObject2.putStringSet(sUm, (Set)new HashSet());
    long l = bu.aO(l);
    if ((localSet != null) && (localSet.size() > 0))
    {
      localObject3 = o.a.szY;
      o.a.wO(l);
    }
    ae.i(TAG, "clearMarkFolder cost:".concat(String.valueOf(l)));
    Object localObject3 = z.Nhr;
    AppMethodBeat.o(167746);
  }
  
  public static boolean cNm()
  {
    AppMethodBeat.i(167747);
    long l1 = ch.aDa();
    long l2 = sUo;
    b localb = b.sHP;
    if (l1 - l2 > b.cHw())
    {
      AppMethodBeat.o(167747);
      return true;
    }
    AppMethodBeat.o(167747);
    return false;
  }
  
  private static String gw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167738);
    p.h(paramString1, "originFilePath");
    p.h(paramString2, "suffix");
    StringBuilder localStringBuilder = new StringBuilder();
    r localr = r.sYn;
    paramString1 = r.cOx() + "video_" + aj.ej(paramString1) + "_" + paramString2 + "_thumb";
    AppMethodBeat.o(167738);
    return paramString1;
  }
  
  static String gx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204953);
    Object localObject = i.sUG;
    if (i.ajM(paramString2))
    {
      AppMethodBeat.o(204953);
      return paramString2;
    }
    localObject = i.sUG;
    localObject = i.dz(paramString1, 2);
    Bitmap localBitmap = h.aN(paramString1, ((Point)localObject).x, ((Point)localObject).y);
    Exif localExif = Exif.fromFile(paramString1);
    p.g(localExif, "Exif.fromFile(originFilePath)");
    int i = localExif.getOrientationInDegree();
    ae.i(TAG, "_genImageThumbFile, file %s rotate %d. originThumbWidth:%s, originThumbHeight:%s", new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(((Point)localObject).x), Integer.valueOf(((Point)localObject).y) });
    if (localBitmap != null)
    {
      ae.i(TAG, "_genImageThumbFile, file %s cropThumbWidth:%s, cropThumbHeight:%s", new Object[] { paramString1, Integer.valueOf(localBitmap.getWidth()), Integer.valueOf(localBitmap.getHeight()) });
      h.a(localBitmap, 70, Bitmap.CompressFormat.JPEG, paramString2, false);
    }
    AppMethodBeat.o(204953);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.f
 * JD-Core Version:    0.7.0.1
 */