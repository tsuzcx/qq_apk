package com.tencent.mm.plugin.finder.upload;

import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.car;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil;", "", "()V", "TAG", "", "checkThumbFileExist", "", "thumbFile", "convertMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "originMusic", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "genFeedPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "genLocalImageMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "filePath", "thumbUrl", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "genLocalTextCardMedia", "genLocalVideoMedia", "coverUrl", "getFakeVideoMedia", "info", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "fullThumbUrl", "halfRect", "Landroid/graphics/Rect;", "getThumbWidthHeight", "Landroid/graphics/Point;", "mediaType", "", "resize2Even", "value", "getUniqId", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "print", "", "Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "prefix", "plugin-finder_release"})
public final class i
{
  private static final String TAG = "Finder.FinderPostUtil";
  public static final i vSX;
  
  static
  {
    AppMethodBeat.i(167785);
    vSX = new i();
    TAG = "Finder.FinderPostUtil";
    AppMethodBeat.o(167785);
  }
  
  private static int Lt(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 2 != 0) {
      i = paramInt - 1;
    }
    return i;
  }
  
  public static azk a(clp paramclp)
  {
    AppMethodBeat.i(253110);
    if (paramclp == null)
    {
      AppMethodBeat.o(253110);
      return null;
    }
    azk localazk = new azk();
    localazk.wWb = String.valueOf(paramclp.MqO);
    localazk.LJh = paramclp.jTB;
    localazk.name = paramclp.MqW;
    Object localObject = paramclp.MqX;
    if (localObject != null) {}
    for (localObject = (String)j.kt((List)localObject);; localObject = null)
    {
      localazk.artist = ((String)localObject);
      localazk.LJi = paramclp.MqU;
      AppMethodBeat.o(253110);
      return localazk;
    }
  }
  
  public static cjl a(acn paramacn, String paramString1, String paramString2, String paramString3, Rect paramRect)
  {
    AppMethodBeat.i(253108);
    p.h(paramacn, "info");
    p.h(paramString1, "thumbUrl");
    p.h(paramString2, "fullThumbUrl");
    p.h(paramString3, "coverUrl");
    Log.i(TAG, "getFakeVideoMedia  info:" + paramacn + "  thumbUrl:" + paramString1);
    cjl localcjl = new cjl();
    localcjl.url = "";
    localcjl.mediaType = 4;
    localcjl.thumbUrl = paramString1;
    localcjl.MoR = paramString2;
    localcjl.coverUrl = paramString3;
    localcjl.mediaId = MD5Util.getMD5String(((ejf)paramacn.Lnd.get(0)).path);
    localcjl.width = paramacn.Gxw.targetWidth;
    localcjl.height = paramacn.Gxw.targetHeight;
    localcjl.MfU = paramacn;
    localcjl.MoO = false;
    localcjl.uOR = new cjx();
    if (paramRect == null)
    {
      localcjl.thumbUrl = paramString2;
      paramString1 = paramacn.Gxw.Lnm;
      int i = ((Number)paramString1.Msu.get(2)).intValue();
      paramString2 = paramString1.Msu.get(0);
      p.g(paramString2, "cropRect.values[0]");
      int j = ((Number)paramString2).intValue();
      int k = ((Number)paramString1.Msu.get(3)).intValue();
      paramString1 = paramString1.Msu.get(1);
      p.g(paramString1, "cropRect.values[1]");
      int m = ((Number)paramString1).intValue();
      paramacn.Gxw.targetHeight = Lt((k - m) * paramacn.Gxw.targetWidth / (i - j));
    }
    for (;;)
    {
      AppMethodBeat.o(253108);
      return localcjl;
      paramString2 = new aty();
      paramString2.left = paramRect.left;
      paramString2.top = paramRect.top;
      paramString2.right = paramRect.right;
      paramString2.bottom = paramRect.bottom;
      localcjl.MoU = paramString2;
      if (paramacn.Lnk)
      {
        paramString2 = new car();
        paramString2.thumbUrl = paramString1;
        paramString2.width = paramRect.width();
        paramString2.height = paramRect.height();
        paramString1 = new acn();
        paramString1.parseFrom(paramacn.toByteArray());
        paramString3 = paramString1.Gxw;
        paramRect = new StringBuilder();
        p.g(o.bhi(), "SubCoreVideo.getCore()");
        paramString3.rpE = (o.getAccVideoPath() + "vsg_half_output_" + System.currentTimeMillis() + ".mp4");
        paramString1.Gxw.targetWidth = Lt((int)(paramString2.width * paramString1.Gxw.Lnn));
        paramString1.Gxw.targetHeight = Lt((int)(paramString2.height * paramString1.Gxw.Lnn));
        paramString2.MfU = paramString1;
        localcjl.MoX = paramString2;
      }
      paramString1 = paramacn.Gxw.Lnm;
      paramString1.Msu.set(0, Integer.valueOf(0));
      paramString1.Msu.set(1, Integer.valueOf(0));
      paramString1.Msu.set(2, Integer.valueOf(paramacn.Gxw.xlg));
      paramString1.Msu.set(3, Integer.valueOf(paramacn.Gxw.xlh));
    }
  }
  
  public static cjl a(String paramString1, String paramString2, cjx paramcjx, String paramString3)
  {
    AppMethodBeat.i(253106);
    p.h(paramString1, "filePath");
    p.h(paramString2, "thumbUrl");
    p.h(paramString3, "coverUrl");
    Log.i(TAG, "gen video media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    cjl localcjl = new cjl();
    localcjl.mediaType = 4;
    localcjl.url = paramString1;
    localcjl.thumbUrl = paramString2;
    localcjl.mediaId = MD5Util.getMD5String(paramString1);
    localcjl.fileSize = ((int)s.boW(paramString1));
    localcjl.coverUrl = paramString3;
    paramString2 = y.vXH;
    paramString1 = y.awl(paramString1);
    if (paramString1 != null)
    {
      localcjl.width = paramString1.width;
      localcjl.height = paramString1.height;
      localcjl.bitrate = paramString1.videoBitrate;
      localcjl.videoDuration = paramString1.getVideoDuration();
      if ((paramcjx != null) && (paramcjx.iqg > 0)) {
        localcjl.videoDuration = (paramcjx.iqg / 1000);
      }
    }
    localcjl.MoL = 1;
    if (paramcjx == null) {
      localcjl.MoO = false;
    }
    for (;;)
    {
      AppMethodBeat.o(253106);
      return localcjl;
      localcjl.MoO = true;
      localcjl.width = paramcjx.width;
      localcjl.height = paramcjx.height;
      localcjl.uOR = paramcjx;
    }
  }
  
  public static void a(FinderFeedReportObject paramFinderFeedReportObject, String paramString)
  {
    AppMethodBeat.i(253103);
    p.h(paramFinderFeedReportObject, "$this$print");
    p.h(paramString, "prefix");
    Log.i("Finder.FinderFeedReportObject", paramString + " remux:" + paramFinderFeedReportObject.mediaProcessCost + ",upload:" + paramFinderFeedReportObject.uploadCost + ",uploadSize:" + paramFinderFeedReportObject.uploadMediaTotalSize / 1024L + "KB,taskTotal:" + paramFinderFeedReportObject.postTaskCost + ",repost:" + paramFinderFeedReportObject.clickRepostCount);
    AppMethodBeat.o(253103);
  }
  
  public static boolean avZ(String paramString)
  {
    AppMethodBeat.i(167780);
    p.h(paramString, "thumbFile");
    if (s.YS(paramString))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0))
      {
        AppMethodBeat.o(167780);
        return true;
      }
    }
    AppMethodBeat.o(167780);
    return false;
  }
  
  public static cjm dBh()
  {
    AppMethodBeat.i(167779);
    cjm localcjm = new cjm();
    localcjm.clientId = ("FinderLocal_" + System.nanoTime());
    AppMethodBeat.o(167779);
    return localcjm;
  }
  
  public static Point dK(String paramString, int paramInt)
  {
    AppMethodBeat.i(167784);
    Object localObject = c.vCb;
    int i = c.dqN();
    if (!Util.isNullOrNil(paramString)) {
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
      BitmapUtil.decodeFile(paramString, (BitmapFactory.Options)localObject);
      paramString = Exif.fromFile(paramString);
      p.g(paramString, "Exif.fromFile(filePath)");
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
      localObject = y.vXH;
      if (paramString == null) {
        p.hyc();
      }
      paramString = y.awl(paramString);
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
  
  public static cjl ha(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253104);
    p.h(paramString1, "filePath");
    p.h(paramString2, "thumbUrl");
    Log.i(TAG, "gen img media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    cjl localcjl = new cjl();
    localcjl.mediaType = 2;
    Object localObject2 = Exif.fromFile(paramString1);
    p.g(localObject2, "Exif.fromFile(filePath)");
    Object localObject1 = paramString1;
    if (((Exif)localObject2).getOrientationInDegree() != 0)
    {
      localObject1 = al.waC;
      localObject2 = al.awA(paramString1);
      localObject1 = paramString1;
      if (s.YS((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    localcjl.url = ((String)localObject1);
    localcjl.thumbUrl = paramString2;
    localcjl.MoR = paramString2;
    localcjl.mediaId = MD5Util.getMD5String(localcjl.url);
    paramString1 = y.vXH;
    paramString2 = localcjl.url;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString1 = y.awm(paramString1);
    localcjl.width = paramString1.x;
    localcjl.height = paramString1.y;
    localcjl.MoL = 1;
    localcjl.MoO = false;
    AppMethodBeat.o(253104);
    return localcjl;
  }
  
  public static cjl hc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167782);
    p.h(paramString1, "filePath");
    p.h(paramString2, "thumbUrl");
    Log.i(TAG, "gen img media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    cjl localcjl = new cjl();
    localcjl.mediaType = 7;
    Object localObject = paramString1;
    if (SightVideoJNI.getMp4RotateVFS(paramString1) != 0)
    {
      localObject = al.waC;
      String str = al.awA(paramString1);
      localObject = paramString1;
      if (s.YS(str)) {
        localObject = str;
      }
    }
    localcjl.url = ((String)localObject);
    localcjl.thumbUrl = paramString2;
    localcjl.mediaId = MD5Util.getMD5String(localcjl.url);
    paramString1 = y.vXH;
    paramString2 = localcjl.url;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString1 = y.awm(paramString1);
    localcjl.width = paramString1.x;
    localcjl.height = paramString1.y;
    localcjl.MoL = 1;
    AppMethodBeat.o(167782);
    return localcjl;
  }
  
  public static String v(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(253109);
    p.h(paramFinderItem, "$this$getUniqId");
    paramFinderItem = z.aTY() + "_" + paramFinderItem.getCreateTime() + "_" + paramFinderItem.getLocalId();
    AppMethodBeat.o(253109);
    return paramFinderItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.i
 * JD-Core Version:    0.7.0.1
 */