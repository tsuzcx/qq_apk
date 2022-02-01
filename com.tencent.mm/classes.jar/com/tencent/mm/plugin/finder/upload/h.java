package com.tencent.mm.plugin.finder.upload;

import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.finder.utils.p;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil;", "", "()V", "TAG", "", "checkThumbFileExist", "", "thumbFile", "genFeedPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "genLocalImageMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "filePath", "thumbUrl", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "genLocalTextCardMedia", "genLocalVideoMedia", "coverUrl", "getFakeVideoMedia", "info", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "getThumbWidthHeight", "Landroid/graphics/Point;", "mediaType", "", "plugin-finder_release"})
public final class h
{
  private static final String TAG = "Finder.FinderPostUtil";
  public static final h rNr;
  
  static
  {
    AppMethodBeat.i(167785);
    rNr = new h();
    TAG = "Finder.FinderPostUtil";
    AppMethodBeat.o(167785);
  }
  
  public static bqs a(yo paramyo, String paramString1, String paramString2)
  {
    AppMethodBeat.i(203510);
    k.h(paramyo, "info");
    k.h(paramString1, "thumbUrl");
    k.h(paramString2, "coverUrl");
    ac.i(TAG, "getFakeVideoMedia  info:" + paramyo + "  thumbUrl:" + paramString1);
    bqs localbqs = new bqs();
    localbqs.url = "";
    localbqs.mediaType = 4;
    localbqs.thumbUrl = paramString1;
    localbqs.coverUrl = paramString2;
    localbqs.mediaId = ah.dg(((dix)paramyo.Esk.get(0)).path);
    localbqs.width = paramyo.AmP.gNU;
    localbqs.height = paramyo.AmP.gNV;
    localbqs.FfQ = paramyo;
    localbqs.FfP = false;
    localbqs.rvh = new brc();
    AppMethodBeat.o(203510);
    return localbqs;
  }
  
  public static bqs a(String paramString1, String paramString2, brc parambrc, String paramString3)
  {
    AppMethodBeat.i(203508);
    k.h(paramString1, "filePath");
    k.h(paramString2, "thumbUrl");
    k.h(paramString3, "coverUrl");
    ac.i(TAG, "gen video media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    bqs localbqs = new bqs();
    localbqs.mediaType = 4;
    localbqs.url = paramString1;
    localbqs.thumbUrl = paramString2;
    localbqs.mediaId = ah.dg(paramString1);
    localbqs.fileSize = ((int)i.aSp(paramString1));
    localbqs.coverUrl = paramString3;
    paramString2 = n.rPN;
    paramString1 = n.aeB(paramString1);
    if (paramString1 != null)
    {
      localbqs.width = paramString1.width;
      localbqs.height = paramString1.height;
      localbqs.bitrate = paramString1.videoBitrate;
      localbqs.videoDuration = paramString1.getVideoDuration();
      if ((parambrc != null) && (parambrc.hbI > 0)) {
        localbqs.videoDuration = (parambrc.hbI / 1000);
      }
    }
    localbqs.FfM = 1;
    if (parambrc == null) {
      localbqs.FfP = false;
    }
    for (;;)
    {
      AppMethodBeat.o(203508);
      return localbqs;
      localbqs.FfP = true;
      localbqs.width = parambrc.width;
      localbqs.height = parambrc.height;
      localbqs.rvh = parambrc;
    }
  }
  
  public static boolean aev(String paramString)
  {
    AppMethodBeat.i(167780);
    k.h(paramString, "thumbFile");
    if (i.eA(paramString))
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
  
  public static bqt cCA()
  {
    AppMethodBeat.i(167779);
    bqt localbqt = new bqt();
    localbqt.clientId = ("FinderLocal_" + System.nanoTime());
    AppMethodBeat.o(167779);
    return localbqt;
  }
  
  public static Point de(String paramString, int paramInt)
  {
    AppMethodBeat.i(167784);
    Object localObject = b.rCU;
    int i = b.cye();
    if (!bs.isNullOrNil(paramString)) {
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
      k.g(paramString, "Exif.fromFile(filePath)");
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
      localObject = n.rPN;
      if (paramString == null) {
        k.fOy();
      }
      paramString = n.aeB(paramString);
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
  
  public static bqs gi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203506);
    k.h(paramString1, "filePath");
    k.h(paramString2, "thumbUrl");
    ac.i(TAG, "gen img media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    bqs localbqs = new bqs();
    localbqs.mediaType = 2;
    Object localObject2 = Exif.fromFile(paramString1);
    k.g(localObject2, "Exif.fromFile(filePath)");
    Object localObject1 = paramString1;
    if (((Exif)localObject2).getOrientationInDegree() != 0)
    {
      localObject1 = p.rQw;
      localObject2 = p.aeJ(paramString1);
      localObject1 = paramString1;
      if (i.eA((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    localbqs.url = ((String)localObject1);
    localbqs.thumbUrl = paramString2;
    localbqs.mediaId = ah.dg(localbqs.url);
    paramString1 = n.rPN;
    paramString1 = localbqs.url;
    k.g(paramString1, "media.url");
    paramString1 = n.aeC(paramString1);
    localbqs.width = paramString1.x;
    localbqs.height = paramString1.y;
    localbqs.FfM = 1;
    localbqs.FfP = false;
    AppMethodBeat.o(203506);
    return localbqs;
  }
  
  public static bqs gk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167782);
    k.h(paramString1, "filePath");
    k.h(paramString2, "thumbUrl");
    ac.i(TAG, "gen img media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    bqs localbqs = new bqs();
    localbqs.mediaType = 7;
    Object localObject = paramString1;
    if (SightVideoJNI.getMp4RotateVFS(paramString1) != 0)
    {
      localObject = p.rQw;
      String str = p.aeJ(paramString1);
      localObject = paramString1;
      if (i.eA(str)) {
        localObject = str;
      }
    }
    localbqs.url = ((String)localObject);
    localbqs.thumbUrl = paramString2;
    localbqs.mediaId = ah.dg(localbqs.url);
    paramString1 = n.rPN;
    paramString1 = localbqs.url;
    k.g(paramString1, "media.url");
    paramString1 = n.aeC(paramString1);
    localbqs.width = paramString1.x;
    localbqs.height = paramString1.y;
    localbqs.FfM = 1;
    AppMethodBeat.o(167782);
    return localbqs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.h
 * JD-Core Version:    0.7.0.1
 */