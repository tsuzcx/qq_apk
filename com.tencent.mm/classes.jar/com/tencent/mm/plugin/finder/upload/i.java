package com.tencent.mm.plugin.finder.upload;

import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.enx;
import com.tencent.mm.protocal.protobuf.fos;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil;", "", "()V", "TAG", "", "checkDeviceIsConfiguration", "", "videoPath", "checkFinderVideoItemFormatValid", "item", "Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil$VideoMediaItem;", "checkMediaRatio", "width", "", "height", "checkSelectedVideo", "context", "Landroid/content/Context;", "checkThumbFileExist", "thumbFile", "convertMusicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "originMusic", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "genLocalImageMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "filePath", "thumbUrl", "genLocalTextCardMedia", "genLocalVideoMedia", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "coverUrl", "fullCoverUrl", "getFakeVideoMedia", "info", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "fullThumbUrl", "halfRect", "Landroid/graphics/Rect;", "getIntersectionRect", "fullRect", "cropRect", "getMediaInfo", "path", "getThumbWidthHeight", "Landroid/graphics/Point;", "mediaType", "isSameCentrePoint", "rectA", "rectB", "loadItemFromExtractor", "loadItemFromSimpleMP4Info", "refreshMegaVideo", "", "megaVideo", "Lcom/tencent/mm/protocal/protobuf/MegaVideo;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "resize2Even", "value", "searchEventInfo", "nickName", "eventName", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getUniqId", "print", "Lcom/tencent/mm/protocal/protobuf/FinderFeedReportObject;", "prefix", "VideoMediaItem", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i Gcb;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(167785);
    Gcb = new i();
    TAG = "Finder.FinderPostUtil";
    AppMethodBeat.o(167785);
  }
  
  private static int TM(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 2 != 0) {
      i = paramInt - 1;
    }
    return i;
  }
  
  public static bqj a(dls paramdls)
  {
    AppMethodBeat.i(343536);
    if (paramdls == null)
    {
      AppMethodBeat.o(343536);
      return null;
    }
    bqj localbqj = new bqj();
    localbqj.HsD = String.valueOf(Integer.valueOf(paramdls.aaRI));
    localbqj.ZYo = paramdls.pic_url;
    localbqj.name = paramdls.ZTw;
    Object localObject = paramdls.aaRQ;
    if (localObject == null) {}
    for (localObject = null;; localObject = (String)p.oL((List)localObject))
    {
      localbqj.artist = ((String)localObject);
      localbqj.ZYp = paramdls.aaRO;
      AppMethodBeat.o(343536);
      return localbqj;
    }
  }
  
  public static dji a(afb paramafb, String paramString1, String paramString2, String paramString3, String paramString4, Rect paramRect)
  {
    AppMethodBeat.i(343524);
    s.u(paramafb, "info");
    s.u(paramString1, "thumbUrl");
    s.u(paramString2, "fullThumbUrl");
    s.u(paramString3, "coverUrl");
    s.u(paramString4, "fullCoverUrl");
    Log.i(TAG, "getFakeVideoMedia  info:" + paramafb + "  thumbUrl:" + paramString1);
    dji localdji = new dji();
    localdji.url = "";
    localdji.mediaType = 4;
    localdji.thumbUrl = paramString1;
    localdji.aaPi = paramString2;
    localdji.coverUrl = paramString3;
    localdji.HaI = paramString4;
    localdji.mediaId = MD5Util.getMD5String(((fos)paramafb.Zng.get(0)).path);
    localdji.aaDI = paramafb;
    localdji.aaPf = false;
    localdji.EDC = new dju();
    int i;
    int j;
    int k;
    int m;
    if (paramafb.TYB.Znv != null)
    {
      paramString2 = new Rect();
      com.tencent.mm.plugin.vlog.model.h.a(paramafb.TYB.Znv.Zqq, paramString2);
      paramString3 = new Rect();
      com.tencent.mm.plugin.vlog.model.h.a(paramafb.TYB.Znw.Zqq, paramString3);
      localdji.width = paramString2.width();
      localdji.height = paramString2.height();
      if (paramString2.height() != paramString3.height())
      {
        s.u(paramString2, "fullRect");
        s.u(paramString3, "cropRect");
        i = k.qu(paramString2.left, paramString3.left);
        j = k.qu(paramString2.top, paramString3.top);
        k = k.qv(paramString2.right, paramString3.right);
        m = k.qv(paramString2.bottom, paramString3.bottom);
        paramRect = new Rect();
        paramRect.left = (i - paramString2.left);
        paramRect.right = (k - paramString2.left);
        paramRect.top = (j - paramString2.top);
        paramRect.bottom = (m - paramString2.top);
        paramString4 = new bbn();
        paramString4.left = paramRect.left;
        paramString4.top = paramRect.top;
        paramString4.right = paramRect.right;
        paramString4.bottom = paramRect.bottom;
        paramRect = ah.aiuX;
        localdji.aaPl = paramString4;
      }
      s.u(paramString2, "rectA");
      s.u(paramString3, "rectB");
      if (Math.abs((paramString2.left + paramString2.right) / 2 - (paramString3.left + paramString3.right) / 2) > 2)
      {
        i = 0;
        if (i == 0)
        {
          paramString2 = new cyv();
          paramString2.thumbUrl = paramString1;
          paramString2.width = paramString3.width();
          paramString2.height = paramString3.height();
          paramString1 = new afb();
          paramString1.parseFrom(paramafb.toByteArray());
          paramString3 = paramString1.TYB;
          paramString4 = new StringBuilder();
          v.bOg();
          paramString3.outputPath = (v.getAccVideoPath() + "vsg_half_output_" + System.currentTimeMillis() + ".mp4");
          paramString1.TYB.Znw = paramafb.TYB.Znw;
          paramafb = ah.aiuX;
          paramString2.aaDI = paramString1;
          paramafb = ah.aiuX;
          localdji.aaPo = paramString2;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(343524);
      return localdji;
      i = paramString2.top;
      if (Math.abs((paramString2.bottom + i) / 2 - (paramString3.top + paramString3.bottom) / 2) > 2)
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      localdji.width = paramafb.TYB.nxO;
      localdji.height = paramafb.TYB.nxP;
      if (paramRect == null)
      {
        localdji.thumbUrl = paramString2;
        paramString1 = paramafb.TYB.Znp;
        i = ((Number)paramString1.aaTg.get(2)).intValue();
        paramString2 = paramString1.aaTg.get(0);
        s.s(paramString2, "cropRect.values[0]");
        j = ((Number)paramString2).intValue();
        k = ((Number)paramString1.aaTg.get(3)).intValue();
        paramString1 = paramString1.aaTg.get(1);
        s.s(paramString1, "cropRect.values[1]");
        m = ((Number)paramString1).intValue();
        paramafb.TYB.nxP = TM((k - m) * paramafb.TYB.nxO / (i - j));
      }
      else
      {
        paramString2 = new bbn();
        paramString2.left = paramRect.left;
        paramString2.top = paramRect.top;
        paramString2.right = paramRect.right;
        paramString2.bottom = paramRect.bottom;
        paramString3 = ah.aiuX;
        localdji.aaPl = paramString2;
        if (paramafb.Znn)
        {
          paramString2 = new cyv();
          paramString2.thumbUrl = paramString1;
          paramString2.width = paramRect.width();
          paramString2.height = paramRect.height();
          paramString1 = new afb();
          paramString1.parseFrom(paramafb.toByteArray());
          paramString3 = paramString1.TYB;
          paramString4 = new StringBuilder();
          v.bOg();
          paramString3.outputPath = (v.getAccVideoPath() + "vsg_half_output_" + System.currentTimeMillis() + ".mp4");
          paramString1.TYB.nxO = TM((int)(paramString2.width * paramString1.TYB.Znq));
          paramString1.TYB.nxP = TM((int)(paramString2.height * paramString1.TYB.Znq));
          paramString3 = ah.aiuX;
          paramString2.aaDI = paramString1;
          paramString1 = ah.aiuX;
          localdji.aaPo = paramString2;
        }
        paramString1 = paramafb.TYB.Znp;
        paramString1.aaTg.set(0, Integer.valueOf(0));
        paramString1.aaTg.set(1, Integer.valueOf(0));
        paramString1.aaTg.set(2, Integer.valueOf(paramafb.TYB.HJN));
        paramString1.aaTg.set(3, Integer.valueOf(paramafb.TYB.HJO));
      }
    }
  }
  
  public static dji a(String paramString1, String paramString2, dju paramdju, String paramString3, String paramString4)
  {
    AppMethodBeat.i(343495);
    s.u(paramString1, "filePath");
    s.u(paramString2, "thumbUrl");
    s.u(paramString3, "coverUrl");
    s.u(paramString4, "fullCoverUrl");
    Log.i(TAG, "gen video media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    dji localdji = new dji();
    localdji.mediaType = 4;
    localdji.url = paramString1;
    localdji.thumbUrl = paramString2;
    localdji.mediaId = MD5Util.getMD5String(paramString1);
    localdji.fileSize = ((int)com.tencent.mm.vfs.y.bEl(paramString1));
    localdji.coverUrl = paramString3;
    localdji.HaI = paramString4;
    paramString2 = av.GiL;
    paramString1 = av.aBH(paramString1);
    if (paramString1 != null)
    {
      localdji.width = paramString1.width;
      localdji.height = paramString1.height;
      localdji.bitrate = paramString1.videoBitrate;
      localdji.videoDuration = paramString1.getVideoDuration();
      if ((paramdju != null) && (paramdju.endTime > 0)) {
        localdji.videoDuration = (paramdju.endTime / 1000);
      }
    }
    localdji.aaPc = 1;
    if (paramdju == null) {
      localdji.aaPf = false;
    }
    for (;;)
    {
      AppMethodBeat.o(343495);
      return localdji;
      localdji.aaPf = true;
      localdji.width = paramdju.width;
      localdji.height = paramdju.height;
      localdji.EDC = paramdju;
    }
  }
  
  public static void a(FinderFeedReportObject paramFinderFeedReportObject, String paramString)
  {
    AppMethodBeat.i(343466);
    s.u(paramFinderFeedReportObject, "<this>");
    s.u(paramString, "prefix");
    Log.i("Finder.FinderFeedReportObject", paramString + " remux:" + paramFinderFeedReportObject.mediaProcessCost + ",upload:" + paramFinderFeedReportObject.uploadCost + ",uploadSize:" + paramFinderFeedReportObject.uploadMediaTotalSize / 1024L + "KB,taskTotal:" + paramFinderFeedReportObject.postTaskCost + ",repost:" + paramFinderFeedReportObject.clickRepostCount);
    AppMethodBeat.o(343466);
  }
  
  public static void a(dne paramdne, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(343589);
    s.u(paramFinderItem, "finderObj");
    atr localatr = new atr();
    Object localObject2 = localatr.ZEi;
    Object localObject3 = new atq();
    ((atq)localObject3).type = 1;
    Object localObject4 = new byx();
    long l;
    label78:
    Object localObject1;
    if (paramdne == null)
    {
      l = 0L;
      ((byx)localObject4).id = l;
      ((byx)localObject4).ZXx = paramdne;
      if (paramdne != null) {
        break label174;
      }
      paramdne = "";
      ((byx)localObject4).aahV = paramdne;
      paramdne = ah.aiuX;
      ((atq)localObject3).ZEf = ((byx)localObject4);
      paramdne = ah.aiuX;
      ((LinkedList)localObject2).add(localObject3);
      localObject1 = localatr.ZEi;
      paramdne = paramFinderItem.getFeedObject().attachmentList;
      if (paramdne != null) {
        break label194;
      }
      paramdne = null;
      label128:
      if (paramdne != null) {
        break label312;
      }
    }
    label174:
    label302:
    label312:
    for (paramdne = (Collection)new LinkedList();; paramdne = (Collection)paramdne)
    {
      ((LinkedList)localObject1).addAll(paramdne);
      paramFinderItem.getFeedObject().attachmentList = localatr;
      AppMethodBeat.o(343589);
      return;
      l = paramdne.id;
      break;
      localObject1 = paramdne.aahV;
      paramdne = (dne)localObject1;
      if (localObject1 != null) {
        break label78;
      }
      paramdne = "";
      break label78;
      label194:
      paramdne = paramdne.ZEi;
      if (paramdne == null)
      {
        paramdne = null;
        break label128;
      }
      localObject2 = (Iterable)paramdne;
      paramdne = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        localObject4 = (atq)localObject3;
        av localav = av.GiL;
        s.s(localObject4, "it");
        if (!av.a((atq)localObject4)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label302;
          }
          paramdne.add(localObject3);
          break;
        }
      }
      paramdne = (List)paramdne;
      break label128;
    }
  }
  
  public static boolean a(a parama)
  {
    boolean bool3 = true;
    AppMethodBeat.i(343579);
    boolean bool1;
    if ((n.T("video/hevc", parama.oTL, true)) && (com.tencent.mm.plugin.u.f.gbA())) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (!Util.isNullOrNil(parama.oTM))
      {
        bool2 = bool1;
        if (!n.T("audio/mp4a-latm", parama.oTM, true))
        {
          Log.i(TAG, s.X("audioTrack invalid, ", parama.oTM));
          bool2 = false;
        }
      }
      if (com.tencent.mm.modelvideo.y.PK(parama.Gcc)) {
        if ((!Util.isNullOrNil(parama.oTL)) && (com.tencent.mm.plugin.u.f.aMo(parama.oTL)) && (!Util.isNullOrNil(parama.oTM)) && (com.tencent.mm.plugin.u.f.aMo(parama.oTM)))
        {
          Log.i(TAG, "qt video can decode");
          bool1 = bool3;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(343579);
        return bool1;
        if (!n.T("video/avc", parama.oTL, true)) {
          break label183;
        }
        bool1 = true;
        break;
        Log.i(TAG, "qt video cannot decode");
        bool1 = false;
        continue;
        bool1 = bool2;
      }
      label183:
      bool1 = false;
    }
  }
  
  public static boolean aBl(String paramString)
  {
    AppMethodBeat.i(167780);
    s.u(paramString, "thumbFile");
    if (com.tencent.mm.vfs.y.ZC(paramString))
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
  
  public static boolean aBm(String paramString)
  {
    AppMethodBeat.i(343545);
    Object localObject1 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoa, "");
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      AppMethodBeat.o(343545);
      return false;
    }
    Log.i(TAG, "devices configuration: %s", new Object[] { localObject1 });
    Log.i(TAG, "android version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, q.aPo() });
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      localObject2 = ((JSONObject)localObject1).optString("devices");
      k = ((JSONObject)localObject1).optInt("maxsize");
      localObject1 = new JSONArray((String)localObject2);
      m = ((JSONArray)localObject1).length();
      if (m <= 0) {
        break label387;
      }
      i = 0;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Object localObject2;
        int k;
        int m;
        int j;
        long l;
        Log.printErrStackTrace(TAG, (Throwable)paramString, "parse json error", new Object[0]);
        continue;
        int i = j;
      }
    }
    j = i + 1;
    localObject2 = ((JSONArray)localObject1).optJSONObject(i);
    if ((n.T(Build.MANUFACTURER, ((JSONObject)localObject2).optString("brand"), true)) && (n.T(q.aPo(), ((JSONObject)localObject2).optString("model"), true)))
    {
      l = com.tencent.mm.vfs.y.bEl(paramString);
      if ((k != 0) && (l > k * 1024 * 1024))
      {
        Log.i(TAG, "hit devices but it is too big, fileSize: %s, maxSize: %s, filePath: %s", new Object[] { Long.valueOf(l), Integer.valueOf(k), paramString });
        AppMethodBeat.o(343545);
        return false;
      }
      i = ((JSONObject)localObject2).optInt("androidVersion");
      if (-1 == i)
      {
        Log.i(TAG, "hit devices all version, manufacturer: %s, brand: %s, model: %s", new Object[] { Build.MANUFACTURER, Build.BRAND, q.aPo() });
        AppMethodBeat.o(343545);
        return true;
      }
      if (Build.VERSION.SDK_INT == i)
      {
        Log.i(TAG, "hit devices, version: %s, manufacturer: %s, brand: %s, model: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Build.MANUFACTURER, Build.BRAND, q.aPo() });
        AppMethodBeat.o(343545);
        return true;
      }
    }
    if (j >= m)
    {
      label387:
      AppMethodBeat.o(343545);
      return false;
    }
  }
  
  public static a aBn(String paramString)
  {
    AppMethodBeat.i(343558);
    try
    {
      Object localObject = SightVideoJNI.getSimpleMp4InfoVFS(paramString);
      Log.i(TAG, "get simple mp4 info %s", new Object[] { localObject });
      localObject = new JSONObject((String)localObject);
      a locala = new a();
      locala.aBp(paramString);
      locala.oTN = ((JSONObject)localObject).getInt("videoDuration");
      locala.videoHeight = ((JSONObject)localObject).getInt("videoHeight");
      locala.videoWidth = ((JSONObject)localObject).getInt("videoWidth");
      locala.videoBitRate = ((JSONObject)localObject).getInt("videoBitrate");
      locala.videoFrameRate = ((JSONObject)localObject).getInt("videoFPS");
      locala.nCg = SightVideoJNI.getMp4RotateVFS(paramString);
      locala.videoIFrameInterval = 0;
      locala.oTL = com.tencent.mm.plugin.gallery.b.f.aFg(((JSONObject)localObject).getString("videoType"));
      locala.oTM = com.tencent.mm.plugin.gallery.b.f.aFg(((JSONObject)localObject).getString("audioType"));
      AppMethodBeat.o(343558);
      return locala;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramString, "loadItemFromSimpleMP4Info fail", new Object[0]);
      AppMethodBeat.o(343558);
    }
    return null;
  }
  
  public static a aBo(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(343567);
    com.tencent.mm.compatible.i.c localc = new com.tencent.mm.compatible.i.c();
    int m;
    Object localObject5;
    Object localObject4;
    int k;
    Object localObject6;
    Object localObject7;
    label97:
    label228:
    label247:
    Object localObject3;
    try
    {
      localc.setDataSource(paramString);
      m = localc.lZm.getTrackCount();
      if (m > 0)
      {
        int i = 0;
        localObject5 = null;
        localObject4 = null;
        k = i + 1;
        MediaFormat localMediaFormat = localc.getTrackFormat(i);
        s.s(localMediaFormat, "extractor.getTrackFormat(i)");
        Object localObject1;
        if (!localMediaFormat.containsKey("mime"))
        {
          Log.d(TAG, "find video mime : not found.");
          localObject6 = localObject5;
          localObject7 = localObject4;
          break label652;
          localObject5 = new a();
          ((a)localObject5).aBp(paramString);
          if (localObject1 != null)
          {
            if (((MediaFormat)localObject1).containsKey("durationUs")) {
              break label467;
            }
            i = 0;
            ((a)localObject5).oTN = i;
            if (((MediaFormat)localObject1).containsKey("height")) {
              break label484;
            }
            i = 0;
            label149:
            ((a)localObject5).videoHeight = i;
            if (((MediaFormat)localObject1).containsKey("width")) {
              break label496;
            }
            i = 0;
            label168:
            ((a)localObject5).videoWidth = i;
            if (((MediaFormat)localObject1).containsKey("mime")) {
              break label508;
            }
            localObject4 = "";
            label189:
            ((a)localObject5).oTL = ((String)localObject4);
            if (((MediaFormat)localObject1).containsKey("bitrate")) {
              break label521;
            }
            i = 0;
            label209:
            ((a)localObject5).videoBitRate = i;
            if (((MediaFormat)localObject1).containsKey("i-frame-interval")) {
              break label533;
            }
            i = 0;
            ((a)localObject5).videoIFrameInterval = i;
            if (((MediaFormat)localObject1).containsKey("frame-rate")) {
              break label545;
            }
            i = j;
            ((a)localObject5).videoFrameRate = i;
            ((a)localObject5).nCg = SightVideoJNI.getMp4RotateVFS(paramString);
          }
          if (localObject3 != null) {
            if (((MediaFormat)localObject3).containsKey("mime")) {
              break label557;
            }
          }
        }
        label521:
        label533:
        label545:
        label557:
        for (localObject3 = "";; localObject3 = ((MediaFormat)localObject3).getString("mime"))
        {
          ((a)localObject5).oTM = ((String)localObject3);
          Log.i(TAG, "loadItemFromExtractor mediaItem: %s", new Object[] { localObject5 });
          Log.i(TAG, "mediaItem format:%s, videoPath:%s", new Object[] { localObject1, paramString });
          return localObject5;
          String str = localMediaFormat.getString("mime");
          Log.d(TAG, "find video mime : %s", new Object[] { str });
          localObject6 = localObject5;
          localObject7 = localObject4;
          if (str == null) {
            break label652;
          }
          if (n.U(str, "video/", false))
          {
            localObject1 = localObject5;
            localObject3 = localObject4;
            if (localObject4 != null) {
              break label669;
            }
            localObject3 = localMediaFormat;
            localObject1 = localObject5;
            break label669;
          }
          localObject1 = localObject5;
          localObject3 = localObject4;
          if (!n.U(str, "audio/", false)) {
            break label669;
          }
          localObject1 = localObject5;
          localObject3 = localObject4;
          if (localObject5 != null) {
            break label669;
          }
          localObject1 = localMediaFormat;
          localObject3 = localObject4;
          break label669;
          label467:
          i = (int)(((MediaFormat)localObject1).getLong("durationUs") / 1000L);
          break;
          label484:
          i = ((MediaFormat)localObject1).getInteger("height");
          break label149;
          label496:
          i = ((MediaFormat)localObject1).getInteger("width");
          break label168;
          label508:
          localObject4 = ((MediaFormat)localObject1).getString("mime");
          break label189;
          i = ((MediaFormat)localObject1).getInteger("bitrate");
          break label209;
          i = ((MediaFormat)localObject1).getInteger("i-frame-interval");
          break label228;
          i = ((MediaFormat)localObject1).getInteger("frame-rate");
          break label247;
        }
        i = k;
      }
    }
    catch (Exception localException)
    {
      Log.i(TAG, "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { paramString, localException.getMessage() });
      return null;
    }
    finally
    {
      localc.lZm.release();
      AppMethodBeat.o(343567);
    }
    label652:
    label669:
    label704:
    for (;;)
    {
      localObject5 = localObject6;
      localObject4 = localObject7;
      break;
      localObject3 = null;
      Object localObject2 = null;
      break label97;
      for (;;)
      {
        if (k < m) {
          break label704;
        }
        do
        {
          localObject3 = localObject6;
          localObject2 = localObject7;
          break;
          localObject6 = localObject2;
          localObject7 = localObject3;
          if (localObject2 == null) {
            break label652;
          }
          localObject6 = localObject2;
          localObject7 = localObject3;
        } while (localObject3 != null);
        localObject6 = localObject2;
        localObject7 = localObject3;
      }
    }
  }
  
  private static final ah b(kotlin.g.a.b paramb, b.a parama)
  {
    AppMethodBeat.i(343592);
    s.u(paramb, "$callback");
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      if (parama == null)
      {
        parama = null;
        Log.i(TAG, s.X("eventInfo = ", parama));
        if ((parama == null) || (parama.ZHK != 1)) {
          break label212;
        }
        i = 1;
        label60:
        if (i == 0) {
          break label217;
        }
        com.tencent.mm.plugin.report.service.h.OAn.p(1253L, 72L, 1L);
        paramb.invoke(null);
      }
    }
    for (;;)
    {
      paramb = ah.aiuX;
      AppMethodBeat.o(343592);
      return paramb;
      parama = (buq)parama.ott;
      if (parama == null)
      {
        parama = null;
        break;
      }
      parama = parama.aabt;
      if (parama == null)
      {
        parama = null;
        break;
      }
      parama = (awt)p.oL((List)parama);
      break;
      com.tencent.mm.plugin.report.service.h.OAn.p(1253L, 71L, 1L);
      Log.i(TAG, "errorType = " + parama.errType + " errorCode = " + parama.errCode + "  errorMsg = " + parama.errMsg);
      parama = null;
      break;
      label212:
      i = 0;
      break label60;
      label217:
      paramb.invoke(parama);
    }
  }
  
  public static void b(String paramString1, String paramString2, kotlin.g.a.b<? super awt, ah> paramb)
  {
    AppMethodBeat.i(343476);
    s.u(paramString1, "nickName");
    s.u(paramString2, "eventName");
    s.u(paramb, "callback");
    if (((CharSequence)paramString1).length() == 0)
    {
      i = 1;
      if (i != 0) {
        break label117;
      }
      if (((CharSequence)paramString2).length() != 0) {
        break label112;
      }
    }
    label112:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label117;
      }
      com.tencent.mm.plugin.report.service.h.OAn.p(1253L, 70L, 1L);
      new ao(paramString1, paramString2).bFJ().g(new i..ExternalSyntheticLambda0(paramb));
      AppMethodBeat.o(343476);
      return;
      i = 0;
      break;
    }
    label117:
    paramb.invoke(null);
    Log.i(TAG, "nickName or eventName is Empty");
    AppMethodBeat.o(343476);
  }
  
  public static Point eT(String paramString, int paramInt)
  {
    AppMethodBeat.i(167784);
    Object localObject = d.FAy;
    int i = d.eQn();
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
      if (Exif.fromFile(paramString).getOrientationInDegree() % 180 != 0)
      {
        paramInt = ((BitmapFactory.Options)localObject).outHeight;
        ((BitmapFactory.Options)localObject).outHeight = ((BitmapFactory.Options)localObject).outWidth;
        paramString = ah.aiuX;
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
      localObject = av.GiL;
      s.checkNotNull(paramString);
      paramString = av.aBH(paramString);
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
  
  public static dji in(String paramString1, String paramString2)
  {
    AppMethodBeat.i(167781);
    s.u(paramString1, "filePath");
    s.u(paramString2, "thumbUrl");
    Log.i(TAG, "gen img media url %s, thumbUrl %s", new Object[] { paramString1, paramString2 });
    dji localdji = new dji();
    localdji.mediaType = 2;
    Object localObject = paramString1;
    if (Exif.fromFile(paramString1).getOrientationInDegree() != 0)
    {
      localObject = bm.GlZ;
      String str = bm.aCf(paramString1);
      localObject = paramString1;
      if (com.tencent.mm.vfs.y.ZC(str)) {
        localObject = str;
      }
    }
    localdji.url = ((String)localObject);
    localdji.thumbUrl = paramString2;
    localdji.aaPi = paramString2;
    localdji.mediaId = MD5Util.getMD5String(localdji.url);
    paramString1 = aw.Gjk;
    paramString2 = localdji.url;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    paramString1 = aw.aBX(paramString1);
    localdji.width = paramString1.x;
    localdji.height = paramString1.y;
    localdji.aaPc = 1;
    localdji.aaPf = false;
    AppMethodBeat.o(167781);
    return localdji;
  }
  
  public static boolean in(int paramInt1, int paramInt2)
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/FinderPostUtil$VideoMediaItem;", "", "()V", "audioTrackMime", "", "getAudioTrackMime", "()Ljava/lang/String;", "setAudioTrackMime", "(Ljava/lang/String;)V", "durationMs", "", "getDurationMs", "()I", "setDurationMs", "(I)V", "mOriginalPath", "getMOriginalPath", "setMOriginalPath", "videoBitRate", "getVideoBitRate", "setVideoBitRate", "videoFrameRate", "getVideoFrameRate", "setVideoFrameRate", "videoHeight", "getVideoHeight", "setVideoHeight", "videoIFrameInterval", "getVideoIFrameInterval", "setVideoIFrameInterval", "videoRotate", "getVideoRotate", "setVideoRotate", "videoTrackMime", "getVideoTrackMime", "setVideoTrackMime", "videoWidth", "getVideoWidth", "setVideoWidth", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public String Gcc = "";
    int nCg = -1;
    public String oTL;
    public String oTM;
    int oTN = -1;
    int videoBitRate = -1;
    int videoFrameRate = -1;
    public int videoHeight = -1;
    int videoIFrameInterval = -1;
    public int videoWidth = -1;
    
    public final void aBp(String paramString)
    {
      AppMethodBeat.i(342966);
      s.u(paramString, "<set-?>");
      this.Gcc = paramString;
      AppMethodBeat.o(342966);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.i
 * JD-Core Version:    0.7.0.1
 */