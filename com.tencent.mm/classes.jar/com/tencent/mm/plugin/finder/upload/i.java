package com.tencent.mm.plugin.finder.upload;

import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil;", "", "()V", "TAG", "", "checkThumbFileExist", "", "thumbFile", "genFeedPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "genLocalImageMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "filePath", "thumbUrl", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "genLocalTextCardMedia", "genLocalVideoMedia", "coverUrl", "getFakeVideoMedia", "info", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "getThumbWidthHeight", "Landroid/graphics/Point;", "mediaType", "", "getUniqId", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "plugin-finder_release"})
public final class i
{
  private static final String TAG = "Finder.FinderPostUtil";
  public static final i sUG;
  
  static
  {
    AppMethodBeat.i(167785);
    sUG = new i();
    TAG = "Finder.FinderPostUtil";
    AppMethodBeat.o(167785);
  }
  
  public static bvz a(aaq paramaaq, String paramString1, String paramString2)
  {
    AppMethodBeat.i(204961);
    d.g.b.p.h(paramaaq, "info");
    d.g.b.p.h(paramString1, "thumbUrl");
    d.g.b.p.h(paramString2, "coverUrl");
    ae.i(TAG, "getFakeVideoMedia  info:" + paramaaq + "  thumbUrl:" + paramString1);
    bvz localbvz = new bvz();
    localbvz.url = "";
    localbvz.mediaType = 4;
    localbvz.thumbUrl = paramString1;
    localbvz.coverUrl = paramString2;
    localbvz.mediaId = aj.ej(((dpj)paramaaq.GrU.get(0)).path);
    localbvz.width = paramaaq.BWx.targetWidth;
    localbvz.height = paramaaq.BWx.targetHeight;
    localbvz.HiW = paramaaq;
    localbvz.HiV = false;
    localbvz.stz = new bwj();
    AppMethodBeat.o(204961);
    return localbvz;
  }
  
  public static bvz a(String paramString1, String paramString2, bwj parambwj, String paramString3)
  {
    AppMethodBeat.i(204959);
    d.g.b.p.h(paramString1, "filePath");
    d.g.b.p.h(paramString2, "thumbUrl");
    d.g.b.p.h(paramString3, "coverUrl");
    ae.i(TAG, "gen video media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    bvz localbvz = new bvz();
    localbvz.mediaType = 4;
    localbvz.url = paramString1;
    localbvz.thumbUrl = paramString2;
    localbvz.mediaId = aj.ej(paramString1);
    localbvz.fileSize = ((int)o.aZR(paramString1));
    localbvz.coverUrl = paramString3;
    paramString2 = com.tencent.mm.plugin.finder.utils.p.sXz;
    paramString1 = com.tencent.mm.plugin.finder.utils.p.ajS(paramString1);
    if (paramString1 != null)
    {
      localbvz.width = paramString1.width;
      localbvz.height = paramString1.height;
      localbvz.bitrate = paramString1.videoBitrate;
      localbvz.videoDuration = paramString1.getVideoDuration();
      if ((parambwj != null) && (parambwj.hwE > 0)) {
        localbvz.videoDuration = (parambwj.hwE / 1000);
      }
    }
    localbvz.HiS = 1;
    if (parambwj == null) {
      localbvz.HiV = false;
    }
    for (;;)
    {
      AppMethodBeat.o(204959);
      return localbvz;
      localbvz.HiV = true;
      localbvz.width = parambwj.width;
      localbvz.height = parambwj.height;
      localbvz.stz = parambwj;
    }
  }
  
  public static boolean ajM(String paramString)
  {
    AppMethodBeat.i(167780);
    d.g.b.p.h(paramString, "thumbFile");
    if (o.fB(paramString))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      h.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0))
      {
        AppMethodBeat.o(167780);
        return true;
      }
    }
    AppMethodBeat.o(167780);
    return false;
  }
  
  public static bwa cNs()
  {
    AppMethodBeat.i(167779);
    bwa localbwa = new bwa();
    localbwa.clientId = ("FinderLocal_" + System.nanoTime());
    AppMethodBeat.o(167779);
    return localbwa;
  }
  
  public static Point dz(String paramString, int paramInt)
  {
    AppMethodBeat.i(167784);
    Object localObject = b.sHP;
    int i = b.cHd();
    if (!bu.isNullOrNil(paramString)) {
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
      h.decodeFile(paramString, (BitmapFactory.Options)localObject);
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
      localObject = com.tencent.mm.plugin.finder.utils.p.sXz;
      if (paramString == null) {
        d.g.b.p.gkB();
      }
      paramString = com.tencent.mm.plugin.finder.utils.p.ajS(paramString);
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
  
  public static bvz gA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167782);
    d.g.b.p.h(paramString1, "filePath");
    d.g.b.p.h(paramString2, "thumbUrl");
    ae.i(TAG, "gen img media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    bvz localbvz = new bvz();
    localbvz.mediaType = 7;
    Object localObject = paramString1;
    if (SightVideoJNI.getMp4RotateVFS(paramString1) != 0)
    {
      localObject = r.sYn;
      String str = r.aka(paramString1);
      localObject = paramString1;
      if (o.fB(str)) {
        localObject = str;
      }
    }
    localbvz.url = ((String)localObject);
    localbvz.thumbUrl = paramString2;
    localbvz.mediaId = aj.ej(localbvz.url);
    paramString1 = com.tencent.mm.plugin.finder.utils.p.sXz;
    paramString2 = localbvz.url;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString1 = com.tencent.mm.plugin.finder.utils.p.ajT(paramString1);
    localbvz.width = paramString1.x;
    localbvz.height = paramString1.y;
    localbvz.HiS = 1;
    AppMethodBeat.o(167782);
    return localbvz;
  }
  
  public static bvz gy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204957);
    d.g.b.p.h(paramString1, "filePath");
    d.g.b.p.h(paramString2, "thumbUrl");
    ae.i(TAG, "gen img media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    bvz localbvz = new bvz();
    localbvz.mediaType = 2;
    Object localObject2 = Exif.fromFile(paramString1);
    d.g.b.p.g(localObject2, "Exif.fromFile(filePath)");
    Object localObject1 = paramString1;
    if (((Exif)localObject2).getOrientationInDegree() != 0)
    {
      localObject1 = r.sYn;
      localObject2 = r.aka(paramString1);
      localObject1 = paramString1;
      if (o.fB((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    localbvz.url = ((String)localObject1);
    localbvz.thumbUrl = paramString2;
    localbvz.mediaId = aj.ej(localbvz.url);
    paramString1 = com.tencent.mm.plugin.finder.utils.p.sXz;
    paramString2 = localbvz.url;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString1 = com.tencent.mm.plugin.finder.utils.p.ajT(paramString1);
    localbvz.width = paramString1.x;
    localbvz.height = paramString1.y;
    localbvz.HiS = 1;
    localbvz.HiV = false;
    AppMethodBeat.o(204957);
    return localbvz;
  }
  
  public static String m(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(204962);
    d.g.b.p.h(paramFinderItem, "$this$getUniqId");
    paramFinderItem = v.aAC() + "_" + paramFinderItem.getCreateTime() + "_" + paramFinderItem.getLocalId();
    AppMethodBeat.o(204962);
    return paramFinderItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.i
 * JD-Core Version:    0.7.0.1
 */