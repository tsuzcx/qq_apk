package com.tencent.mm.plugin.finder.upload;

import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.bvp;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil;", "", "()V", "TAG", "", "checkThumbFileExist", "", "thumbFile", "genFeedPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "genLocalImageMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "filePath", "thumbUrl", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "genLocalTextCardMedia", "genLocalVideoMedia", "coverUrl", "getFakeVideoMedia", "info", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "getThumbWidthHeight", "Landroid/graphics/Point;", "mediaType", "", "getUniqId", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder_release"})
public final class i
{
  private static final String TAG = "Finder.FinderPostUtil";
  public static final i sJt;
  
  static
  {
    AppMethodBeat.i(167785);
    sJt = new i();
    TAG = "Finder.FinderPostUtil";
    AppMethodBeat.o(167785);
  }
  
  public static bvf a(aan paramaan, String paramString1, String paramString2)
  {
    AppMethodBeat.i(204343);
    d.g.b.p.h(paramaan, "info");
    d.g.b.p.h(paramString1, "thumbUrl");
    d.g.b.p.h(paramString2, "coverUrl");
    ad.i(TAG, "getFakeVideoMedia  info:" + paramaan + "  thumbUrl:" + paramString1);
    bvf localbvf = new bvf();
    localbvf.url = "";
    localbvf.mediaType = 4;
    localbvf.thumbUrl = paramString1;
    localbvf.coverUrl = paramString2;
    localbvf.mediaId = ai.ee(((dom)paramaan.FZu.get(0)).path);
    localbvf.width = paramaan.BEZ.targetWidth;
    localbvf.height = paramaan.BEZ.targetHeight;
    localbvf.GPu = paramaan;
    localbvf.GPt = false;
    localbvf.skC = new bvp();
    AppMethodBeat.o(204343);
    return localbvf;
  }
  
  public static bvf a(String paramString1, String paramString2, bvp parambvp, String paramString3)
  {
    AppMethodBeat.i(204341);
    d.g.b.p.h(paramString1, "filePath");
    d.g.b.p.h(paramString2, "thumbUrl");
    d.g.b.p.h(paramString3, "coverUrl");
    ad.i(TAG, "gen video media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    bvf localbvf = new bvf();
    localbvf.mediaType = 4;
    localbvf.url = paramString1;
    localbvf.thumbUrl = paramString2;
    localbvf.mediaId = ai.ee(paramString1);
    localbvf.fileSize = ((int)com.tencent.mm.vfs.i.aYo(paramString1));
    localbvf.coverUrl = paramString3;
    paramString2 = com.tencent.mm.plugin.finder.utils.p.sMo;
    paramString1 = com.tencent.mm.plugin.finder.utils.p.aiV(paramString1);
    if (paramString1 != null)
    {
      localbvf.width = paramString1.width;
      localbvf.height = paramString1.height;
      localbvf.bitrate = paramString1.videoBitrate;
      localbvf.videoDuration = paramString1.getVideoDuration();
      if ((parambvp != null) && (parambvp.htQ > 0)) {
        localbvf.videoDuration = (parambvp.htQ / 1000);
      }
    }
    localbvf.GPq = 1;
    if (parambvp == null) {
      localbvf.GPt = false;
    }
    for (;;)
    {
      AppMethodBeat.o(204341);
      return localbvf;
      localbvf.GPt = true;
      localbvf.width = parambvp.width;
      localbvf.height = parambvp.height;
      localbvf.skC = parambvp;
    }
  }
  
  public static boolean aiP(String paramString)
  {
    AppMethodBeat.i(167780);
    d.g.b.p.h(paramString, "thumbFile");
    if (com.tencent.mm.vfs.i.fv(paramString))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      g.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0))
      {
        AppMethodBeat.o(167780);
        return true;
      }
    }
    AppMethodBeat.o(167780);
    return false;
  }
  
  public static bvg cKO()
  {
    AppMethodBeat.i(167779);
    bvg localbvg = new bvg();
    localbvg.clientId = ("FinderLocal_" + System.nanoTime());
    AppMethodBeat.o(167779);
    return localbvg;
  }
  
  public static Point du(String paramString, int paramInt)
  {
    AppMethodBeat.i(167784);
    Object localObject = b.sxa;
    int i = b.cFg();
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
      g.decodeFile(paramString, (BitmapFactory.Options)localObject);
      paramString = Exif.fromFile(paramString);
      d.g.b.p.g(paramString, "Exif.fromFile(filePath)");
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
      localObject = com.tencent.mm.plugin.finder.utils.p.sMo;
      if (paramString == null) {
        d.g.b.p.gfZ();
      }
      paramString = com.tencent.mm.plugin.finder.utils.p.aiV(paramString);
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
  
  public static bvf gt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204339);
    d.g.b.p.h(paramString1, "filePath");
    d.g.b.p.h(paramString2, "thumbUrl");
    ad.i(TAG, "gen img media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    bvf localbvf = new bvf();
    localbvf.mediaType = 2;
    Object localObject2 = Exif.fromFile(paramString1);
    d.g.b.p.g(localObject2, "Exif.fromFile(filePath)");
    Object localObject1 = paramString1;
    if (((Exif)localObject2).getOrientationInDegree() != 0)
    {
      localObject1 = r.sNc;
      localObject2 = r.ajd(paramString1);
      localObject1 = paramString1;
      if (com.tencent.mm.vfs.i.fv((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    localbvf.url = ((String)localObject1);
    localbvf.thumbUrl = paramString2;
    localbvf.mediaId = ai.ee(localbvf.url);
    paramString1 = com.tencent.mm.plugin.finder.utils.p.sMo;
    paramString1 = localbvf.url;
    d.g.b.p.g(paramString1, "media.url");
    paramString1 = com.tencent.mm.plugin.finder.utils.p.aiW(paramString1);
    localbvf.width = paramString1.x;
    localbvf.height = paramString1.y;
    localbvf.GPq = 1;
    localbvf.GPt = false;
    AppMethodBeat.o(204339);
    return localbvf;
  }
  
  public static bvf gv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167782);
    d.g.b.p.h(paramString1, "filePath");
    d.g.b.p.h(paramString2, "thumbUrl");
    ad.i(TAG, "gen img media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    bvf localbvf = new bvf();
    localbvf.mediaType = 7;
    Object localObject = paramString1;
    if (SightVideoJNI.getMp4RotateVFS(paramString1) != 0)
    {
      localObject = r.sNc;
      String str = r.ajd(paramString1);
      localObject = paramString1;
      if (com.tencent.mm.vfs.i.fv(str)) {
        localObject = str;
      }
    }
    localbvf.url = ((String)localObject);
    localbvf.thumbUrl = paramString2;
    localbvf.mediaId = ai.ee(localbvf.url);
    paramString1 = com.tencent.mm.plugin.finder.utils.p.sMo;
    paramString1 = localbvf.url;
    d.g.b.p.g(paramString1, "media.url");
    paramString1 = com.tencent.mm.plugin.finder.utils.p.aiW(paramString1);
    localbvf.width = paramString1.x;
    localbvf.height = paramString1.y;
    localbvf.GPq = 1;
    AppMethodBeat.o(167782);
    return localbvf;
  }
  
  public static String m(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(204344);
    d.g.b.p.h(paramFinderItem, "$this$getUniqId");
    paramFinderItem = u.aAm() + "_" + paramFinderItem.getCreateTime() + "_" + paramFinderItem.getLocalId();
    AppMethodBeat.o(204344);
    return paramFinderItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.i
 * JD-Core Version:    0.7.0.1
 */