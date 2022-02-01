package com.tencent.mm.plugin.finder.upload;

import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.protocal.protobuf.ebw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil;", "", "()V", "TAG", "", "checkThumbFileExist", "", "thumbFile", "genFeedPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "genLocalImageMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "filePath", "thumbUrl", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "genLocalTextCardMedia", "genLocalVideoMedia", "coverUrl", "getFakeVideoMedia", "info", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "getThumbWidthHeight", "Landroid/graphics/Point;", "mediaType", "", "plugin-finder_release"})
public final class h
{
  private static final String TAG = "Finder.FinderPostUtil";
  public static final h qRq;
  
  static
  {
    AppMethodBeat.i(167785);
    qRq = new h();
    TAG = "Finder.FinderPostUtil";
    AppMethodBeat.o(167785);
  }
  
  public static boolean ZJ(String paramString)
  {
    AppMethodBeat.i(167780);
    d.g.b.k.h(paramString, "thumbFile");
    if (com.tencent.mm.vfs.i.eK(paramString))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      f.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0))
      {
        AppMethodBeat.o(167780);
        return true;
      }
    }
    AppMethodBeat.o(167780);
    return false;
  }
  
  public static bmd a(dxw paramdxw, String paramString1, String paramString2)
  {
    AppMethodBeat.i(199534);
    d.g.b.k.h(paramdxw, "info");
    d.g.b.k.h(paramString1, "thumbUrl");
    d.g.b.k.h(paramString2, "coverUrl");
    ad.i(TAG, "getFakeVideoMedia  info:" + paramdxw + "  thumbUrl:" + paramString1);
    bmd localbmd = new bmd();
    localbmd.url = "";
    localbmd.mediaType = 4;
    localbmd.thumbUrl = paramString1;
    localbmd.coverUrl = paramString2;
    localbmd.mediaId = ai.du(((ebw)paramdxw.LwS.get(0)).path);
    localbmd.width = paramdxw.Lqd.gnh;
    localbmd.height = paramdxw.Lqd.gni;
    localbmd.LzL = paramdxw;
    localbmd.DJD = false;
    localbmd.qDR = new bmm();
    AppMethodBeat.o(199534);
    return localbmd;
  }
  
  public static bmd a(String paramString1, String paramString2, bmm parambmm, String paramString3)
  {
    AppMethodBeat.i(199532);
    d.g.b.k.h(paramString1, "filePath");
    d.g.b.k.h(paramString2, "thumbUrl");
    d.g.b.k.h(paramString3, "coverUrl");
    ad.i(TAG, "gen video media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    bmd localbmd = new bmd();
    localbmd.mediaType = 4;
    localbmd.url = paramString1;
    localbmd.thumbUrl = paramString2;
    localbmd.mediaId = ai.du(paramString1);
    localbmd.fileSize = ((int)com.tencent.mm.vfs.i.aMN(paramString1));
    localbmd.coverUrl = paramString3;
    paramString2 = com.tencent.mm.plugin.finder.utils.i.qTa;
    paramString1 = com.tencent.mm.plugin.finder.utils.i.ZP(paramString1);
    if (paramString1 != null)
    {
      localbmd.width = paramString1.width;
      localbmd.height = paramString1.height;
      localbmd.bitrate = paramString1.videoBitrate;
      localbmd.videoDuration = paramString1.getVideoDuration();
      if ((parambmm != null) && (parambmm.gBm > 0)) {
        localbmd.videoDuration = (parambmm.gBm / 1000);
      }
    }
    localbmd.DJA = 1;
    if (parambmm == null) {
      localbmd.DJD = false;
    }
    for (;;)
    {
      AppMethodBeat.o(199532);
      return localbmd;
      localbmd.DJD = true;
      localbmd.width = parambmm.width;
      localbmd.height = parambmm.height;
      localbmd.qDR = parambmm;
    }
  }
  
  public static Point cY(String paramString, int paramInt)
  {
    AppMethodBeat.i(167784);
    Object localObject = b.qJA;
    int i = b.coG();
    if (!bt.isNullOrNil(paramString)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      paramString = new Point(i, i);
      AppMethodBeat.o(167784);
      return paramString;
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      f.decodeFile(paramString, (BitmapFactory.Options)localObject);
      paramString = Exif.fromFile(paramString);
      d.g.b.k.g(paramString, "Exif.fromFile(filePath)");
      if (paramString.getOrientationInDegree() % 180 != 0)
      {
        paramInt = ((BitmapFactory.Options)localObject).outHeight;
        ((BitmapFactory.Options)localObject).outHeight = ((BitmapFactory.Options)localObject).outWidth;
        ((BitmapFactory.Options)localObject).outWidth = paramInt;
      }
      paramInt = Math.min(((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight);
      i = Math.min(paramInt, i);
      if (paramInt == ((BitmapFactory.Options)localObject).outWidth)
      {
        f = i * 1.0F / ((BitmapFactory.Options)localObject).outWidth;
        paramString = new Point(i, (int)(((BitmapFactory.Options)localObject).outHeight * f));
        AppMethodBeat.o(167784);
        return paramString;
      }
      f = i * 1.0F / ((BitmapFactory.Options)localObject).outHeight;
      paramString = new Point((int)(((BitmapFactory.Options)localObject).outWidth * f), i);
      AppMethodBeat.o(167784);
      return paramString;
      localObject = com.tencent.mm.plugin.finder.utils.i.qTa;
      if (paramString == null) {
        d.g.b.k.fvU();
      }
      paramString = com.tencent.mm.plugin.finder.utils.i.ZP(paramString);
    } while (paramString == null);
    paramInt = Math.min(paramString.width, paramString.height);
    i = Math.min(paramInt, i);
    if (paramInt == paramString.width)
    {
      f = i * 1.0F / paramString.width;
      paramString = new Point(i, (int)(paramString.height * f));
      AppMethodBeat.o(167784);
      return paramString;
    }
    float f = i * 1.0F / paramString.height;
    paramString = new Point((int)(paramString.width * f), i);
    AppMethodBeat.o(167784);
    return paramString;
  }
  
  public static bme crF()
  {
    AppMethodBeat.i(167779);
    bme localbme = new bme();
    localbme.clientId = ("FinderLocal_" + System.nanoTime());
    AppMethodBeat.o(167779);
    return localbme;
  }
  
  public static bmd fV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167782);
    d.g.b.k.h(paramString1, "filePath");
    d.g.b.k.h(paramString2, "thumbUrl");
    ad.i(TAG, "gen img media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    bmd localbmd = new bmd();
    localbmd.mediaType = 7;
    Object localObject = paramString1;
    if (SightVideoJNI.getMp4RotateVFS(paramString1) != 0)
    {
      localObject = com.tencent.mm.plugin.finder.utils.k.qTp;
      String str = com.tencent.mm.plugin.finder.utils.k.ZX(paramString1);
      localObject = paramString1;
      if (com.tencent.mm.vfs.i.eK(str)) {
        localObject = str;
      }
    }
    localbmd.url = ((String)localObject);
    localbmd.thumbUrl = paramString2;
    localbmd.mediaId = ai.du(localbmd.url);
    paramString1 = com.tencent.mm.plugin.finder.utils.i.qTa;
    paramString1 = localbmd.url;
    d.g.b.k.g(paramString1, "media.url");
    paramString1 = com.tencent.mm.plugin.finder.utils.i.ZQ(paramString1);
    localbmd.width = paramString1.x;
    localbmd.height = paramString1.y;
    localbmd.DJA = 1;
    AppMethodBeat.o(167782);
    return localbmd;
  }
  
  public static bmd mQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199530);
    d.g.b.k.h(paramString1, "filePath");
    d.g.b.k.h(paramString2, "thumbUrl");
    ad.i(TAG, "gen img media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    bmd localbmd = new bmd();
    localbmd.mediaType = 2;
    Object localObject2 = Exif.fromFile(paramString1);
    d.g.b.k.g(localObject2, "Exif.fromFile(filePath)");
    Object localObject1 = paramString1;
    if (((Exif)localObject2).getOrientationInDegree() != 0)
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.k.qTp;
      localObject2 = com.tencent.mm.plugin.finder.utils.k.ZX(paramString1);
      localObject1 = paramString1;
      if (com.tencent.mm.vfs.i.eK((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    localbmd.url = ((String)localObject1);
    localbmd.thumbUrl = paramString2;
    localbmd.mediaId = ai.du(localbmd.url);
    paramString1 = com.tencent.mm.plugin.finder.utils.i.qTa;
    paramString1 = localbmd.url;
    d.g.b.k.g(paramString1, "media.url");
    paramString1 = com.tencent.mm.plugin.finder.utils.i.ZQ(paramString1);
    localbmd.width = paramString1.x;
    localbmd.height = paramString1.y;
    localbmd.DJA = 1;
    localbmd.DJD = false;
    AppMethodBeat.o(199530);
    return localbmd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.h
 * JD-Core Version:    0.7.0.1
 */