package com.tencent.mm.plugin.finder.upload;

import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.u.f;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.eth;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil;", "", "()V", "TAG", "", "checkDeviceIsConfiguration", "", "videoPath", "checkFinderVideoItemFormatValid", "item", "Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil$VideoMediaItem;", "checkMediaRatio", "width", "", "height", "checkSelectedVideo", "context", "Landroid/content/Context;", "checkThumbFileExist", "thumbFile", "convertMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "originMusic", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "genFeedPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "genLocalImageMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "filePath", "thumbUrl", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "genLocalTextCardMedia", "genLocalVideoMedia", "coverUrl", "getFakeVideoMedia", "info", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "fullThumbUrl", "halfRect", "Landroid/graphics/Rect;", "getIntersectionRect", "fullRect", "cropRect", "getMediaInfo", "path", "getThumbWidthHeight", "Landroid/graphics/Point;", "mediaType", "isSameCentrePoint", "rectA", "rectB", "loadItemFromExtractor", "loadItemFromSimpleMP4Info", "resize2Even", "value", "getUniqId", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "print", "", "Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "prefix", "VideoMediaItem", "plugin-finder_release"})
public final class i
{
  public static final i AAy;
  private static final String TAG = "Finder.FinderPostUtil";
  
  static
  {
    AppMethodBeat.i(167785);
    AAy = new i();
    TAG = "Finder.FinderPostUtil";
    AppMethodBeat.o(167785);
  }
  
  private static int QC(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 2 != 0) {
      i = paramInt - 1;
    }
    return i;
  }
  
  public static bfg a(cum paramcum)
  {
    AppMethodBeat.i(267353);
    if (paramcum == null)
    {
      AppMethodBeat.o(267353);
      return null;
    }
    bfg localbfg = new bfg();
    localbfg.BHW = String.valueOf(paramcum.TCc);
    localbfg.SPU = paramcum.mKO;
    localbfg.name = paramcum.SMU;
    Object localObject = paramcum.TCk;
    if (localObject != null) {}
    for (localObject = (String)j.lp((List)localObject);; localObject = null)
    {
      localbfg.artist = ((String)localObject);
      localbfg.SPV = paramcum.TCi;
      AppMethodBeat.o(267353);
      return localbfg;
    }
  }
  
  public static csg a(acu paramacu, String paramString1, String paramString2, String paramString3, Rect paramRect)
  {
    AppMethodBeat.i(267351);
    p.k(paramacu, "info");
    p.k(paramString1, "thumbUrl");
    p.k(paramString2, "fullThumbUrl");
    p.k(paramString3, "coverUrl");
    Log.i(TAG, "getFakeVideoMedia  info:" + paramacu + "  thumbUrl:" + paramString1);
    csg localcsg = new csg();
    localcsg.url = "";
    localcsg.mediaType = 4;
    localcsg.thumbUrl = paramString1;
    localcsg.TzX = paramString2;
    localcsg.coverUrl = paramString3;
    localcsg.mediaId = MD5Util.getMD5String(((eth)paramacu.Sou.get(0)).path);
    localcsg.TpG = paramacu;
    localcsg.TzU = false;
    localcsg.zBo = new css();
    int i;
    int j;
    int k;
    int m;
    if (paramacu.NkX.SoJ != null)
    {
      paramString2 = new Rect();
      paramString3 = paramacu.NkX.SoJ.Sro;
      p.j(paramString3, "info.outputConfig.fullScreenConfig.cropRect");
      com.tencent.mm.plugin.vlog.model.i.a(paramString3, paramString2);
      paramString3 = new Rect();
      paramRect = paramacu.NkX.SoK.Sro;
      p.j(paramRect, "info.outputConfig.cropConfig.cropRect");
      com.tencent.mm.plugin.vlog.model.i.a(paramRect, paramString3);
      localcsg.width = paramString2.width();
      localcsg.height = paramString2.height();
      if (paramString2.height() != paramString3.height())
      {
        p.k(paramString2, "fullRect");
        p.k(paramString3, "cropRect");
        i = kotlin.k.i.ov(paramString2.left, paramString3.left);
        j = kotlin.k.i.ov(paramString2.top, paramString3.top);
        k = kotlin.k.i.ow(paramString2.right, paramString3.right);
        m = kotlin.k.i.ow(paramString2.bottom, paramString3.bottom);
        paramRect = new Rect();
        paramRect.left = (i - paramString2.left);
        paramRect.right = (k - paramString2.left);
        paramRect.top = (j - paramString2.top);
        paramRect.bottom = (m - paramString2.top);
        awc localawc = new awc();
        localawc.left = paramRect.left;
        localawc.top = paramRect.top;
        localawc.right = paramRect.right;
        localawc.bottom = paramRect.bottom;
        localcsg.TAa = localawc;
      }
      p.k(paramString2, "rectA");
      p.k(paramString3, "rectB");
      if (Math.abs((paramString2.left + paramString2.right) / 2 - (paramString3.left + paramString3.right) / 2) > 2)
      {
        i = 0;
        if (i == 0)
        {
          paramString2 = new cis();
          paramString2.thumbUrl = paramString1;
          paramString2.width = paramString3.width();
          paramString2.height = paramString3.height();
          paramString1 = new acu();
          paramString1.parseFrom(paramacu.toByteArray());
          paramString3 = paramString1.NkX;
          paramRect = new StringBuilder();
          p.j(s.bqA(), "SubCoreVideo.getCore()");
          paramString3.uVk = (s.getAccVideoPath() + "vsg_half_output_" + System.currentTimeMillis() + ".mp4");
          paramString1.NkX.SoK = paramacu.NkX.SoK;
          paramString2.TpG = paramString1;
          localcsg.TAd = paramString2;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(267351);
      return localcsg;
      i = paramString2.top;
      if (Math.abs((paramString2.bottom + i) / 2 - (paramString3.top + paramString3.bottom) / 2) > 2)
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      localcsg.width = paramacu.NkX.targetWidth;
      localcsg.height = paramacu.NkX.targetHeight;
      if (paramRect == null)
      {
        localcsg.thumbUrl = paramString2;
        paramString1 = paramacu.NkX.SoD;
        i = ((Number)paramString1.TDA.get(2)).intValue();
        paramString2 = paramString1.TDA.get(0);
        p.j(paramString2, "cropRect.values[0]");
        j = ((Number)paramString2).intValue();
        k = ((Number)paramString1.TDA.get(3)).intValue();
        paramString1 = paramString1.TDA.get(1);
        p.j(paramString1, "cropRect.values[1]");
        m = ((Number)paramString1).intValue();
        paramacu.NkX.targetHeight = QC((k - m) * paramacu.NkX.targetWidth / (i - j));
      }
      else
      {
        paramString2 = new awc();
        paramString2.left = paramRect.left;
        paramString2.top = paramRect.top;
        paramString2.right = paramRect.right;
        paramString2.bottom = paramRect.bottom;
        localcsg.TAa = paramString2;
        if (paramacu.SoB)
        {
          paramString2 = new cis();
          paramString2.thumbUrl = paramString1;
          paramString2.width = paramRect.width();
          paramString2.height = paramRect.height();
          paramString1 = new acu();
          paramString1.parseFrom(paramacu.toByteArray());
          paramString3 = paramString1.NkX;
          paramRect = new StringBuilder();
          p.j(s.bqA(), "SubCoreVideo.getCore()");
          paramString3.uVk = (s.getAccVideoPath() + "vsg_half_output_" + System.currentTimeMillis() + ".mp4");
          paramString1.NkX.targetWidth = QC((int)(paramString2.width * paramString1.NkX.SoE));
          paramString1.NkX.targetHeight = QC((int)(paramString2.height * paramString1.NkX.SoE));
          paramString2.TpG = paramString1;
          localcsg.TAd = paramString2;
        }
        paramString1 = paramacu.NkX.SoD;
        paramString1.TDA.set(0, Integer.valueOf(0));
        paramString1.TDA.set(1, Integer.valueOf(0));
        paramString1.TDA.set(2, Integer.valueOf(paramacu.NkX.BXA));
        paramString1.TDA.set(3, Integer.valueOf(paramacu.NkX.BXB));
      }
    }
  }
  
  public static csg a(String paramString1, String paramString2, css paramcss, String paramString3)
  {
    AppMethodBeat.i(267349);
    p.k(paramString1, "filePath");
    p.k(paramString2, "thumbUrl");
    p.k(paramString3, "coverUrl");
    Log.i(TAG, "gen video media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    csg localcsg = new csg();
    localcsg.mediaType = 4;
    localcsg.url = paramString1;
    localcsg.thumbUrl = paramString2;
    localcsg.mediaId = MD5Util.getMD5String(paramString1);
    localcsg.fileSize = ((int)u.bBQ(paramString1));
    localcsg.coverUrl = paramString3;
    paramString2 = aj.AGc;
    paramString1 = aj.aFG(paramString1);
    if (paramString1 != null)
    {
      localcsg.width = paramString1.width;
      localcsg.height = paramString1.height;
      localcsg.bitrate = paramString1.videoBitrate;
      localcsg.videoDuration = paramString1.getVideoDuration();
      if ((paramcss != null) && (paramcss.endTime > 0)) {
        localcsg.videoDuration = (paramcss.endTime / 1000);
      }
    }
    localcsg.TzR = 1;
    if (paramcss == null) {
      localcsg.TzU = false;
    }
    for (;;)
    {
      AppMethodBeat.o(267349);
      return localcsg;
      localcsg.TzU = true;
      localcsg.width = paramcss.width;
      localcsg.height = paramcss.height;
      localcsg.zBo = paramcss;
    }
  }
  
  public static void a(FinderFeedReportObject paramFinderFeedReportObject, String paramString)
  {
    AppMethodBeat.i(267346);
    p.k(paramFinderFeedReportObject, "$this$print");
    p.k(paramString, "prefix");
    Log.i("Finder.FinderFeedReportObject", paramString + " remux:" + paramFinderFeedReportObject.mediaProcessCost + ",upload:" + paramFinderFeedReportObject.uploadCost + ",uploadSize:" + paramFinderFeedReportObject.uploadMediaTotalSize / 1024L + "KB,taskTotal:" + paramFinderFeedReportObject.postTaskCost + ",repost:" + paramFinderFeedReportObject.clickRepostCount);
    AppMethodBeat.o(267346);
  }
  
  public static boolean a(a parama)
  {
    boolean bool3 = true;
    AppMethodBeat.i(267357);
    boolean bool1;
    if ((n.L("video/hevc", parama.maR, true)) && (f.eSH())) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (!Util.isNullOrNil(parama.maS))
      {
        bool2 = bool1;
        if (!n.L("audio/mp4a-latm", parama.maS, true))
        {
          Log.i(TAG, "audioTrack invalid, " + parama.maS);
          bool2 = false;
        }
      }
      if (v.XI(parama.AAz)) {
        if ((!Util.isNullOrNil(parama.maR)) && (f.aPq(parama.maR)) && (!Util.isNullOrNil(parama.maS)) && (f.aPq(parama.maS)))
        {
          Log.i(TAG, "qt video can decode");
          bool1 = bool3;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(267357);
        return bool1;
        if (!n.L("video/avc", parama.maR, true)) {
          break label193;
        }
        bool1 = true;
        break;
        Log.i(TAG, "qt video cannot decode");
        bool1 = false;
        continue;
        bool1 = bool2;
      }
      label193:
      bool1 = false;
    }
  }
  
  public static boolean aFo(String paramString)
  {
    AppMethodBeat.i(167780);
    p.k(paramString, "thumbFile");
    if (u.agG(paramString))
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
  
  public static boolean aFp(String paramString)
  {
    AppMethodBeat.i(267354);
    Object localObject1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vVw, "");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(267354);
      return false;
    }
    Log.i(TAG, "devices configuration: %s", new Object[] { localObject1 });
    Log.i(TAG, "android version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      Object localObject2 = ((JSONObject)localObject1).optString("devices");
      int j = ((JSONObject)localObject1).optInt("maxsize");
      localObject1 = new JSONArray((String)localObject2);
      int k = ((JSONArray)localObject1).length();
      int i = 0;
      while (i < k)
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        if ((n.L(Build.MANUFACTURER, ((JSONObject)localObject2).optString("brand"), true)) && (n.L(Build.MODEL, ((JSONObject)localObject2).optString("model"), true)))
        {
          long l = u.bBQ(paramString);
          if ((j != 0) && (l > j * 1024 * 1024))
          {
            Log.i(TAG, "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", new Object[] { Long.valueOf(l), Integer.valueOf(j), paramString });
            AppMethodBeat.o(267354);
            return false;
          }
          int m = ((JSONObject)localObject2).optInt("androidVersion");
          if (-1 == m)
          {
            Log.i(TAG, "hit devices all version, manufacturer: %s, brand: %s, model: %s", new Object[] { Build.MANUFACTURER, Build.BRAND, Build.MODEL });
            AppMethodBeat.o(267354);
            return true;
          }
          if (Build.VERSION.SDK_INT == m)
          {
            Log.i(TAG, "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, Build.MODEL });
            AppMethodBeat.o(267354);
            return true;
          }
        }
        i += 1;
      }
      return false;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramString, "parse json error", new Object[0]);
      AppMethodBeat.o(267354);
    }
  }
  
  public static a aFq(String paramString)
  {
    AppMethodBeat.i(267355);
    try
    {
      Object localObject = SightVideoJNI.getSimpleMp4InfoVFS(paramString);
      Log.i(TAG, "get simple mp4 info %s", new Object[] { localObject });
      localObject = new JSONObject((String)localObject);
      a locala = new a();
      locala.aFs(paramString);
      locala.maT = ((JSONObject)localObject).getInt("videoDuration");
      locala.videoHeight = ((JSONObject)localObject).getInt("videoHeight");
      locala.videoWidth = ((JSONObject)localObject).getInt("videoWidth");
      locala.videoBitRate = ((JSONObject)localObject).getInt("videoBitrate");
      locala.videoFrameRate = ((JSONObject)localObject).getInt("videoFPS");
      locala.kWG = SightVideoJNI.getMp4RotateVFS(paramString);
      locala.videoIFrameInterval = 0;
      locala.maR = com.tencent.mm.plugin.gallery.a.c.aIG(((JSONObject)localObject).getString("videoType"));
      locala.maS = com.tencent.mm.plugin.gallery.a.c.aIG(((JSONObject)localObject).getString("audioType"));
      AppMethodBeat.o(267355);
      return locala;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramString, "loadItemFromSimpleMP4Info fail", new Object[0]);
      AppMethodBeat.o(267355);
    }
    return null;
  }
  
  public static a aFr(String paramString)
  {
    AppMethodBeat.i(267356);
    com.tencent.mm.compatible.i.c localc = new com.tencent.mm.compatible.i.c();
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      try
      {
        localc.setDataSource(paramString);
        int j = localc.getTrackCount();
        int i = 0;
        localObject2 = null;
        String str1 = null;
        localObject3 = localObject2;
        localObject4 = str1;
        MediaFormat localMediaFormat;
        String str2;
        if (i < j)
        {
          localMediaFormat = localc.getTrackFormat(i);
          p.j(localMediaFormat, "extractor.getTrackFormat(i)");
          if (!localMediaFormat.containsKey("mime"))
          {
            Log.d(TAG, "find video mime : not found.");
            localObject5 = localObject2;
            localObject6 = str1;
            break label602;
          }
          str2 = localMediaFormat.getString("mime");
          Log.d(TAG, "find video mime : %s", new Object[] { str2 });
          localObject5 = localObject2;
          localObject6 = str1;
          if (str2 == null) {
            break label602;
          }
          if (n.M(str2, "video/", false))
          {
            localObject3 = localObject2;
            localObject4 = str1;
            if (str1 != null) {
              break label616;
            }
            localObject4 = localMediaFormat;
            localObject3 = localObject2;
            break label616;
          }
        }
        else
        {
          localObject2 = new a();
          ((a)localObject2).aFs(paramString);
          if (localObject4 != null)
          {
            if (((MediaFormat)localObject4).containsKey("durationUs")) {
              continue;
            }
            i = 0;
            ((a)localObject2).maT = i;
            if (((MediaFormat)localObject4).containsKey("height")) {
              continue;
            }
            i = 0;
            ((a)localObject2).videoHeight = i;
            if (((MediaFormat)localObject4).containsKey("width")) {
              continue;
            }
            i = 0;
            ((a)localObject2).videoWidth = i;
            if (((MediaFormat)localObject4).containsKey("mime")) {
              continue;
            }
            str1 = "";
            ((a)localObject2).maR = str1;
            if (((MediaFormat)localObject4).containsKey("bitrate")) {
              continue;
            }
            i = 0;
            ((a)localObject2).videoBitRate = i;
            if (((MediaFormat)localObject4).containsKey("i-frame-interval")) {
              continue;
            }
            i = 0;
            ((a)localObject2).videoIFrameInterval = i;
            if (((MediaFormat)localObject4).containsKey("frame-rate")) {
              continue;
            }
            i = 0;
            ((a)localObject2).videoFrameRate = i;
            ((a)localObject2).kWG = SightVideoJNI.getMp4RotateVFS(paramString);
          }
          if (localObject3 != null)
          {
            if (localObject3.containsKey("mime")) {
              continue;
            }
            str1 = "";
            ((a)localObject2).maS = str1;
          }
          Log.i(TAG, "loadItemFromExtractor mediaItem: %s", new Object[] { localObject2 });
          Log.i(TAG, "mediaItem format:%s, videoPath:%s", new Object[] { localObject4, paramString });
          return localObject2;
        }
        localObject3 = localObject2;
        localObject4 = str1;
        if (n.M(str2, "audio/", false))
        {
          localObject3 = localObject2;
          localObject4 = str1;
          if (localObject2 == null)
          {
            localObject3 = localMediaFormat;
            localObject4 = str1;
            break label616;
            i = (int)(((MediaFormat)localObject4).getLong("durationUs") / 1000L);
            continue;
            i = ((MediaFormat)localObject4).getInteger("height");
            continue;
            i = ((MediaFormat)localObject4).getInteger("width");
            continue;
            str1 = ((MediaFormat)localObject4).getString("mime");
            continue;
            i = ((MediaFormat)localObject4).getInteger("bitrate");
            continue;
            i = ((MediaFormat)localObject4).getInteger("i-frame-interval");
            continue;
            i = ((MediaFormat)localObject4).getInteger("frame-rate");
            continue;
            str1 = localObject3.getString("mime");
            continue;
            i += 1;
          }
        }
      }
      catch (Exception localException)
      {
        Log.i(TAG, "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { paramString, localException.getMessage() });
        return null;
      }
      finally
      {
        localc.release();
        AppMethodBeat.o(267356);
      }
      label602:
      label616:
      do
      {
        do
        {
          localObject2 = localObject5;
          Object localObject1 = localObject6;
          break;
          localObject5 = localObject3;
          localObject6 = localObject4;
        } while (localObject3 == null);
        localObject5 = localObject3;
        localObject6 = localObject4;
      } while (localObject4 == null);
    }
  }
  
  public static csh ecp()
  {
    AppMethodBeat.i(167779);
    csh localcsh = new csh();
    localcsh.clientId = ("FinderLocal_" + System.nanoTime());
    AppMethodBeat.o(167779);
    return localcsh;
  }
  
  public static Point eh(String paramString, int paramInt)
  {
    AppMethodBeat.i(167784);
    Object localObject = d.AjH;
    int i = d.dSa();
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
      p.j(paramString, "Exif.fromFile(filePath)");
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
      localObject = aj.AGc;
      if (paramString == null) {
        p.iCn();
      }
      paramString = aj.aFG(paramString);
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
  
  public static boolean gW(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    float f;
    do
    {
      return false;
      f = paramInt1 / paramInt2;
    } while ((f > 3.0F) || (f < 0.3333333F));
    return true;
  }
  
  public static csg hp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267347);
    p.k(paramString1, "filePath");
    p.k(paramString2, "thumbUrl");
    Log.i(TAG, "gen img media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    csg localcsg = new csg();
    localcsg.mediaType = 2;
    Object localObject2 = Exif.fromFile(paramString1);
    p.j(localObject2, "Exif.fromFile(filePath)");
    Object localObject1 = paramString1;
    if (((Exif)localObject2).getOrientationInDegree() != 0)
    {
      localObject1 = av.AJz;
      localObject2 = av.aGc(paramString1);
      localObject1 = paramString1;
      if (u.agG((String)localObject2)) {
        localObject1 = localObject2;
      }
    }
    localcsg.url = ((String)localObject1);
    localcsg.thumbUrl = paramString2;
    localcsg.TzX = paramString2;
    localcsg.mediaId = MD5Util.getMD5String(localcsg.url);
    paramString1 = aj.AGc;
    paramString2 = localcsg.url;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString1 = aj.aFH(paramString1);
    localcsg.width = paramString1.x;
    localcsg.height = paramString1.y;
    localcsg.TzR = 1;
    localcsg.TzU = false;
    AppMethodBeat.o(267347);
    return localcsg;
  }
  
  public static csg hr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167782);
    p.k(paramString1, "filePath");
    p.k(paramString2, "thumbUrl");
    Log.i(TAG, "gen img media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    csg localcsg = new csg();
    localcsg.mediaType = 7;
    Object localObject = paramString1;
    if (SightVideoJNI.getMp4RotateVFS(paramString1) != 0)
    {
      localObject = av.AJz;
      String str = av.aGc(paramString1);
      localObject = paramString1;
      if (u.agG(str)) {
        localObject = str;
      }
    }
    localcsg.url = ((String)localObject);
    localcsg.thumbUrl = paramString2;
    localcsg.mediaId = MD5Util.getMD5String(localcsg.url);
    paramString1 = aj.AGc;
    paramString2 = localcsg.url;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString1 = aj.aFH(paramString1);
    localcsg.width = paramString1.x;
    localcsg.height = paramString1.y;
    localcsg.TzR = 1;
    AppMethodBeat.o(167782);
    return localcsg;
  }
  
  public static String x(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(267352);
    p.k(paramFinderItem, "$this$getUniqId");
    paramFinderItem = z.bcZ() + "_" + paramFinderItem.getCreateTime() + "_" + paramFinderItem.getLocalId();
    AppMethodBeat.o(267352);
    return paramFinderItem;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil$VideoMediaItem;", "", "()V", "audioTrackMime", "", "getAudioTrackMime", "()Ljava/lang/String;", "setAudioTrackMime", "(Ljava/lang/String;)V", "durationMs", "", "getDurationMs", "()I", "setDurationMs", "(I)V", "mOriginalPath", "getMOriginalPath", "setMOriginalPath", "videoBitRate", "getVideoBitRate", "setVideoBitRate", "videoFrameRate", "getVideoFrameRate", "setVideoFrameRate", "videoHeight", "getVideoHeight", "setVideoHeight", "videoIFrameInterval", "getVideoIFrameInterval", "setVideoIFrameInterval", "videoRotate", "getVideoRotate", "setVideoRotate", "videoTrackMime", "getVideoTrackMime", "setVideoTrackMime", "videoWidth", "getVideoWidth", "setVideoWidth", "plugin-finder_release"})
  public static final class a
  {
    public String AAz = "";
    int kWG = -1;
    public String maR;
    public String maS;
    int maT = -1;
    int videoBitRate = -1;
    int videoFrameRate = -1;
    public int videoHeight = -1;
    int videoIFrameInterval = -1;
    public int videoWidth = -1;
    
    public final void aFs(String paramString)
    {
      AppMethodBeat.i(272538);
      p.k(paramString, "<set-?>");
      this.AAz = paramString;
      AppMethodBeat.o(272538);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.i
 * JD-Core Version:    0.7.0.1
 */