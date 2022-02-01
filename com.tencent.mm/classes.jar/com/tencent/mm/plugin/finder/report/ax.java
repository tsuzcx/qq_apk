package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.mmdata.rpt.dx;
import com.tencent.mm.autogen.mmdata.rpt.fn;
import com.tencent.mm.autogen.mmdata.rpt.jr;
import com.tencent.mm.autogen.mmdata.rpt.js;
import com.tencent.mm.autogen.mmdata.rpt.jt;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/MegaVideoReporter;", "", "()V", "TAG", "", "loadingDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/report/MegaVideoReporter$LoadingData;", "buildJson", "Lcom/tencent/mm/json/JSONObject;", "data", "isExit", "", "clearLoadingData", "", "notifyEnterMegaVideo", "mediaId", "commentScene", "", "notifyFirstFrame", "isFromSurface", "notifyMegaVideoSeek", "notifyMoovReady", "moovFirstDownloaded", "notifyViewInit", "type", "url", "urlToken", "report21149", "clickId", "postId", "actionType", "timeStamp", "", "clickTab", "report21150", "feedId", "megaVideoId", "megaVideoDuration", "bulletTextCount", "bulletTime", "outcome", "report21151", "sessionId", "contextId", "clickTabContextId", "report21152", "longVideoLen", "isHaveGuide", "currentPlayLen", "report21153", "report21154", "currTime", "generateType", "taskOrder", "miniSessionId", "report21155", "opType", "isPictureInPicture", "report21412", "report21680", "report21875", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "speedPlayResult", "LoadingData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
{
  public static final ax Fur;
  private static final ConcurrentHashMap<String, a> Fus;
  
  static
  {
    AppMethodBeat.i(331275);
    Fur = new ax();
    Fus = new ConcurrentHashMap();
    AppMethodBeat.o(331275);
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    long l = 1L;
    AppMethodBeat.i(331171);
    s.u(paramString1, "miniSessionId");
    s.u(paramString2, "megaVideoId");
    s.u(paramString3, "sessionId");
    s.u(paramString4, "contextId");
    s.u(paramString5, "clickTabContextId");
    js localjs = new js();
    localjs.iUz = paramInt1;
    localjs.iUA = 1L;
    localjs.iUB = localjs.F("MiniSessionId", paramString1, true);
    localjs.iUC = paramInt2;
    localjs.izY = localjs.F("LongVideoId", paramString2, true);
    localjs.inx = localjs.F("sessionid", paramString3, true);
    localjs.iny = localjs.F("contextid", paramString4, true);
    localjs.ipU = localjs.F("ClickTabContextId", paramString5, true);
    if (paramBoolean) {}
    for (;;)
    {
      localjs.iUD = l;
      localjs.bMH();
      paramString1 = z.FrZ;
      z.a((a)localjs);
      AppMethodBeat.o(331171);
      return;
      l = 0L;
    }
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(331160);
    s.u(paramString1, "megaVideoId");
    s.u(paramString2, "miniSessionId");
    s.u(paramString3, "sessionId");
    s.u(paramString4, "contextId");
    s.u(paramString5, "clickTabContextId");
    s.u(paramString6, "feedId");
    jt localjt = new jt();
    localjt.iUE = localjt.F("ClickTimeStamp", String.valueOf(paramLong), true);
    localjt.iUF = paramInt1;
    localjt.iUG = 1L;
    localjt.iUB = localjt.F("MiniSessionId", paramString2, true);
    localjt.iUC = paramInt2;
    localjt.izY = localjt.F("LongVideoId", paramString1, true);
    localjt.inx = localjt.F("sessionid", paramString3, true);
    localjt.iny = localjt.F("contextid", paramString4, true);
    localjt.ipU = localjt.F("ClickTabContextId", paramString5, true);
    localjt.iqk = localjt.F("Feedid", paramString6, true);
    localjt.bMH();
    paramString1 = z.FrZ;
    z.a((a)localjt);
    AppMethodBeat.o(331160);
  }
  
  private static void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(331240);
    dx localdx = new dx();
    localdx.aIM();
    localdx.ixD = 3L;
    parama = b(parama, paramBoolean).toString();
    s.s(parama, "buildJson(data, isExit).toString()");
    localdx.nZ(n.m(parama, ",", ";", false));
    localdx.bMH();
    Log.i("MegaVideoReporter", s.X("report21680 info:", localdx.aIF()));
    AppMethodBeat.o(331240);
  }
  
  public static void a(bui parambui, String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(331260);
    s.u(paramString, "action");
    Object localObject1 = new i();
    ((i)localObject1).m("feedid", d.hF(paramLong1));
    ((i)localObject1).m("LongVideoid", d.hF(paramLong2));
    if (paramInt >= 0) {
      ((i)localObject1).au("speedplay_click_result", paramInt);
    }
    localObject1 = ((i)localObject1).toString();
    s.s(localObject1, "JSONObject().apply {\n   …   }\n        }.toString()");
    String str2 = n.m((String)localObject1, ",", ";", false);
    h localh = h.OAn;
    Object localObject2;
    label115:
    Object localObject3;
    if (parambui == null)
    {
      localObject1 = "";
      if (parambui != null) {
        break label223;
      }
      localObject2 = "";
      if (parambui != null) {
        break label246;
      }
      localObject3 = "";
      label124:
      paramLong1 = cn.bDw();
      if (parambui != null) {
        break label258;
      }
      parambui = "";
    }
    for (;;)
    {
      localh.b(21875, new Object[] { localObject1, localObject2, localObject3, Integer.valueOf(1), String.valueOf(paramLong1), paramString, str2, parambui });
      AppMethodBeat.o(331260);
      return;
      localObject2 = parambui.sessionId;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label223:
      localObject3 = parambui.zIO;
      localObject2 = localObject3;
      if (localObject3 != null) {
        break label115;
      }
      localObject2 = "";
      break label115;
      label246:
      localObject3 = Integer.valueOf(parambui.AJo);
      break label124;
      label258:
      String str1 = parambui.zIB;
      parambui = str1;
      if (str1 == null) {
        parambui = "";
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(331152);
    s.u(paramString1, "feedId");
    s.u(paramString2, "megaVideoId");
    s.u(paramString3, "sessionId");
    s.u(paramString4, "contextId");
    s.u(paramString5, "clickTabContextId");
    jr localjr = new jr();
    localjr.iqk = localjr.F("Feedid", paramString1, true);
    localjr.izY = localjr.F("LongVideoId", paramString2, true);
    localjr.ioV = paramInt1;
    localjr.iyr = paramInt2;
    localjr.inx = localjr.F("sessionid", paramString3, true);
    localjr.iny = localjr.F("contextid", paramString4, true);
    localjr.ipU = localjr.F("ClickTabContextId", paramString5, true);
    localjr.bMH();
    paramString1 = z.FrZ;
    z.a((a)localjr);
    AppMethodBeat.o(331152);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(331138);
    s.u(paramString1, "clickId");
    s.u(paramString2, "postId");
    fn localfn = new fn();
    localfn.iHS = localfn.F("ClickId", paramString1, true);
    localfn.iHK = localfn.F("PostId", paramString2, true);
    localfn.ioV = paramInt1;
    localfn.izR = paramLong;
    localfn.iHT = paramInt2;
    localfn.bMH();
    paramString1 = z.FrZ;
    z.a((a)localfn);
    AppMethodBeat.o(331138);
  }
  
  public static void aAa(String paramString)
  {
    AppMethodBeat.i(331203);
    s.u(paramString, "mediaId");
    paramString = (a)Fus.get(paramString);
    if (paramString != null) {
      paramString.Fuu = cn.bDw();
    }
    AppMethodBeat.o(331203);
  }
  
  private static i b(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(331249);
    long l1;
    long l2;
    label48:
    long l3;
    label80:
    long l4;
    if ((paramBoolean) && (parama.Fuv == 0L))
    {
      l1 = cn.bDw() - parama.AxK;
      if (parama.Fut <= 0L) {
        break label304;
      }
      l2 = parama.Fut - parama.AxK;
      if ((parama.Fut <= 0L) || (parama.Fuw <= parama.Fut)) {
        break label310;
      }
      l3 = parama.Fuw - parama.Fut;
      if ((!paramBoolean) || (parama.Fuv != 0L)) {
        break label316;
      }
      l4 = cn.bDw() - parama.Fut;
      label103:
      if (parama.Fuu <= 0L) {
        break label330;
      }
    }
    label304:
    label310:
    label316:
    label330:
    for (long l5 = Math.max(parama.Fuv - parama.Fuu, 0L);; l5 = 0L)
    {
      i locali = new i();
      locali.au("commentScene", parama.AJo);
      locali.t("totalTime", l1);
      locali.A("isExit", paramBoolean);
      locali.t("enterToViewInit", l2);
      locali.A("isMoovReadyBeforeEnter", parama.Fux);
      locali.t("viewInitToMoovDownloaded", l3);
      locali.t("viewInitToFirstFrame", Math.max(l4, 0L));
      locali.t("seekToFirstFrame", l5);
      locali.m("mediaId", parama.mediaId);
      locali.m("type", parama.type);
      locali.m("url", parama.url);
      locali.m("urlToken", parama.msf);
      AppMethodBeat.o(331249);
      return locali;
      l1 = parama.Fuv - parama.AxK;
      break;
      l2 = 0L;
      break label48;
      l3 = 0L;
      break label80;
      l4 = parama.Fuv - parama.Fut;
      break label103;
    }
  }
  
  public static void bL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(331208);
    s.u(paramString, "mediaId");
    paramString = (a)Fus.get(paramString);
    if (paramString != null) {
      if (paramBoolean) {
        break label53;
      }
    }
    label53:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString.Fux = paramBoolean;
      paramString.Fuw = cn.bDw();
      AppMethodBeat.o(331208);
      return;
    }
  }
  
  public static void bM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(331221);
    s.u(paramString, "mediaId");
    a locala = (a)Fus.get(paramString);
    int i;
    if (locala != null)
    {
      if (locala.Fuv != 0L) {
        break label87;
      }
      i = 1;
      if (i == 0) {
        break label92;
      }
      label43:
      if (locala != null)
      {
        if (!paramBoolean) {
          break label97;
        }
        locala.Fuy = true;
      }
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        paramString = (a)Fus.remove(paramString);
        if (paramString != null) {
          a(paramString, false);
        }
      }
      AppMethodBeat.o(331221);
      return;
      label87:
      i = 0;
      break;
      label92:
      locala = null;
      break label43;
      label97:
      locala.Fuv = cn.bDw();
    }
  }
  
  public static void eNV()
  {
    AppMethodBeat.i(331234);
    Iterator localIterator = ((Map)Fus).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((a)localEntry.getValue()).Fuy) {
        a((a)localEntry.getValue(), true);
      }
    }
    Fus.clear();
    AppMethodBeat.o(331234);
  }
  
  public static void w(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(331187);
    s.u(paramString1, "feedId");
    s.u(paramString2, "sessionId");
    s.u(paramString3, "contextId");
    s.u(paramString4, "clickTabContextId");
    h.OAn.b(21412, new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(331187);
  }
  
  public static void x(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(331195);
    s.u(paramString1, "mediaId");
    s.u(paramString2, "type");
    s.u(paramString3, "url");
    s.u(paramString4, "urlToken");
    paramString1 = (a)Fus.get(paramString1);
    int i;
    if (paramString1 != null)
    {
      if (paramString1.Fut != 0L) {
        break label120;
      }
      i = 1;
      if (i == 0) {
        break label126;
      }
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString1.Fut = cn.bDw();
        s.u(paramString2, "<set-?>");
        paramString1.type = paramString2;
        s.u(paramString3, "<set-?>");
        paramString1.url = paramString3;
        s.u(paramString4, "<set-?>");
        paramString1.msf = paramString4;
      }
      AppMethodBeat.o(331195);
      return;
      label120:
      i = 0;
      break;
      label126:
      paramString1 = null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/MegaVideoReporter$LoadingData;", "", "()V", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "enterTimestamp", "", "getEnterTimestamp", "()J", "setEnterTimestamp", "(J)V", "firstFrameTimestamp", "getFirstFrameTimestamp", "setFirstFrameTimestamp", "hasFirstFrameUpdated", "", "getHasFirstFrameUpdated", "()Z", "setHasFirstFrameUpdated", "(Z)V", "hasMoovDownlaoded", "getHasMoovDownlaoded", "setHasMoovDownlaoded", "mediaId", "", "getMediaId", "()Ljava/lang/String;", "setMediaId", "(Ljava/lang/String;)V", "moovDownloadTimestamp", "getMoovDownloadTimestamp", "setMoovDownloadTimestamp", "seekTimestamp", "getSeekTimestamp", "setSeekTimestamp", "type", "getType", "setType", "url", "getUrl", "setUrl", "urlToken", "getUrlToken", "setUrlToken", "viewInitTimestamp", "getViewInitTimestamp", "setViewInitTimestamp", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    int AJo;
    long AxK;
    long Fut;
    long Fuu;
    long Fuv;
    long Fuw;
    boolean Fux = true;
    boolean Fuy;
    String mediaId = "";
    String msf = "";
    String type = "";
    String url = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ax
 * JD-Core Version:    0.7.0.1
 */