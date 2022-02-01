package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.b.a.cx;
import com.tencent.mm.f.b.a.ec;
import com.tencent.mm.f.b.a.ho;
import com.tencent.mm.f.b.a.hp;
import com.tencent.mm.f.b.a.hq;
import com.tencent.mm.f.b.a.hr;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/MegaVideoReporter;", "", "()V", "TAG", "", "loadingDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/report/MegaVideoReporter$LoadingData;", "buildJson", "Lcom/tencent/mm/json/JSONObject;", "data", "isExit", "", "clearLoadingData", "", "notifyEnterMegaVideo", "mediaId", "commentScene", "", "notifyFirstFrame", "isFromSurface", "notifyMegaVideoSeek", "notifyMoovReady", "moovFirstDownloaded", "notifyViewInit", "type", "url", "urlToken", "report21149", "clickId", "postId", "actionType", "timeStamp", "", "clickTab", "report21150", "feedId", "megaVideoId", "megaVideoDuration", "bulletTextCount", "bulletTime", "outcome", "report21151", "sessionId", "contextId", "clickTabContextId", "report21152", "longVideoLen", "isHaveGuide", "currentPlayLen", "report21153", "report21154", "currTime", "generateType", "taskOrder", "miniSessionId", "report21155", "opType", "isPictureInPicture", "report21412", "report21680", "report21875", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "action", "speedPlayResult", "LoadingData", "plugin-finder_release"})
public final class ai
{
  private static final ConcurrentHashMap<String, a> zZs;
  public static final ai zZt;
  
  static
  {
    AppMethodBeat.i(286041);
    zZt = new ai();
    zZs = new ConcurrentHashMap();
    AppMethodBeat.o(286041);
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    AppMethodBeat.i(286016);
    p.k(paramString1, "miniSessionId");
    p.k(paramString2, "megaVideoId");
    p.k(paramString3, "sessionId");
    p.k(paramString4, "contextId");
    p.k(paramString5, "clickTabContextId");
    hq localhq = new hq();
    localhq.rU(paramInt1);
    localhq.alL();
    localhq.wM(paramString1);
    localhq.rV(paramInt2);
    localhq.wN(paramString2);
    localhq.wO(paramString3);
    localhq.wP(paramString4);
    localhq.wQ(paramString5);
    if (paramBoolean) {}
    for (long l = 1L;; l = 0L)
    {
      localhq.rW(l);
      localhq.bpa();
      paramString1 = n.zWF;
      n.a((a)localhq);
      AppMethodBeat.o(286016);
      return;
    }
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(286015);
    p.k(paramString1, "megaVideoId");
    p.k(paramString2, "miniSessionId");
    p.k(paramString3, "sessionId");
    p.k(paramString4, "contextId");
    p.k(paramString5, "clickTabContextId");
    p.k(paramString6, "feedId");
    hr localhr = new hr();
    localhr.wR(String.valueOf(paramLong));
    localhr.rX(paramInt1);
    localhr.alM();
    localhr.wS(paramString2);
    localhr.rY(paramInt2);
    localhr.wT(paramString1);
    localhr.wU(paramString3);
    localhr.wV(paramString4);
    localhr.wW(paramString5);
    localhr.wX(paramString6);
    localhr.bpa();
    paramString1 = n.zWF;
    n.a((a)localhr);
    AppMethodBeat.o(286015);
  }
  
  private static void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(286031);
    cx localcx = new cx();
    localcx.ahR();
    localcx.gK(3L);
    parama = b(parama, paramBoolean).toString();
    p.j(parama, "buildJson(data, isExit).toString()");
    localcx.nX(kotlin.n.n.l(parama, ",", ";", false));
    localcx.bpa();
    Log.i("MegaVideoReporter", "report21680 info:" + localcx.agI());
    AppMethodBeat.o(286031);
  }
  
  public static void a(bid parambid, String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(286037);
    p.k(paramString, "action");
    Object localObject1 = new i();
    ((i)localObject1).g("feedid", d.Fw(paramLong1));
    ((i)localObject1).g("LongVideoid", d.Fw(paramLong2));
    if (paramInt >= 0) {
      ((i)localObject1).al("speedplay_click_result", paramInt);
    }
    localObject1 = ((i)localObject1).toString();
    p.j(localObject1, "JSONObject().apply {\n   …   }\n        }.toString()");
    String str2 = kotlin.n.n.l((String)localObject1, ",", ";", false);
    h localh = h.IzE;
    Object localObject2;
    if (parambid != null)
    {
      localObject2 = parambid.sessionId;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    if (parambid != null)
    {
      localObject3 = parambid.wmL;
      localObject2 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject2 = "";
    }
    if (parambid != null) {}
    for (Object localObject3 = Integer.valueOf(parambid.xkX);; localObject3 = "")
    {
      paramLong1 = cm.bfE();
      if (parambid != null)
      {
        String str1 = parambid.wmz;
        parambid = str1;
        if (str1 != null) {}
      }
      else
      {
        parambid = "";
      }
      localh.a(21875, new Object[] { localObject1, localObject2, localObject3, Integer.valueOf(1), String.valueOf(paramLong1), paramString, str2, parambid });
      AppMethodBeat.o(286037);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(286013);
    p.k(paramString1, "feedId");
    p.k(paramString2, "megaVideoId");
    p.k(paramString3, "sessionId");
    p.k(paramString4, "contextId");
    p.k(paramString5, "clickTabContextId");
    hp localhp = new hp();
    localhp.wH(paramString1);
    localhp.wI(paramString2);
    localhp.rS(paramInt1);
    localhp.rT(paramInt2);
    localhp.wJ(paramString3);
    localhp.wK(paramString4);
    localhp.wL(paramString5);
    localhp.bpa();
    paramString1 = n.zWF;
    n.a((a)localhp);
    AppMethodBeat.o(286013);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(286011);
    p.k(paramString1, "clickId");
    p.k(paramString2, "postId");
    ec localec = new ec();
    localec.rr(paramString1);
    localec.rs(paramString2);
    localec.kE(paramInt1);
    localec.kF(paramLong);
    localec.kG(paramInt2);
    localec.bpa();
    paramString1 = n.zWF;
    n.a((a)localec);
    AppMethodBeat.o(286011);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    AppMethodBeat.i(286014);
    p.k(paramString1, "feedId");
    p.k(paramString2, "megaVideoId");
    p.k(paramString3, "sessionId");
    p.k(paramString4, "contextId");
    p.k(paramString5, "clickTabContextId");
    ho localho = new ho();
    localho.wC(paramString1);
    localho.wD(paramString2);
    localho.wE(paramString3);
    localho.wF(paramString4);
    localho.wG(paramString5);
    localho.alK();
    localho.rP(paramLong1);
    if (paramBoolean) {}
    for (paramLong1 = 1L;; paramLong1 = 2L)
    {
      localho.rQ(paramLong1);
      localho.rR(paramLong2);
      localho.bpa();
      paramString1 = n.zWF;
      n.a((a)localho);
      AppMethodBeat.o(286014);
      return;
    }
  }
  
  public static void aEg(String paramString)
  {
    AppMethodBeat.i(286021);
    p.k(paramString, "mediaId");
    paramString = (a)zZs.get(paramString);
    if (paramString != null)
    {
      paramString.zZw = cm.bfE();
      AppMethodBeat.o(286021);
      return;
    }
    AppMethodBeat.o(286021);
  }
  
  private static i b(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(286034);
    long l1;
    long l2;
    label48:
    long l3;
    label80:
    long l4;
    if ((paramBoolean) && (parama.zZx == 0L))
    {
      l1 = cm.bfE() - parama.zUF;
      if (parama.zZv <= 0L) {
        break label304;
      }
      l2 = parama.zZv - parama.zUF;
      if ((parama.zZv <= 0L) || (parama.zZy <= parama.zZv)) {
        break label310;
      }
      l3 = parama.zZy - parama.zZv;
      if ((!paramBoolean) || (parama.zZx != 0L)) {
        break label316;
      }
      l4 = cm.bfE() - parama.zZv;
      label103:
      if (parama.zZw <= 0L) {
        break label330;
      }
    }
    label304:
    label310:
    label316:
    label330:
    for (long l5 = Math.max(parama.zZx - parama.zZw, 0L);; l5 = 0L)
    {
      i locali = new i();
      locali.al("commentScene", parama.xkX);
      locali.s("totalTime", l1);
      locali.y("isExit", paramBoolean);
      locali.s("enterToViewInit", l2);
      locali.y("isMoovReadyBeforeEnter", parama.zZz);
      locali.s("viewInitToMoovDownloaded", l3);
      locali.s("viewInitToFirstFrame", Math.max(l4, 0L));
      locali.s("seekToFirstFrame", l5);
      locali.g("mediaId", parama.mediaId);
      locali.g("type", parama.type);
      locali.g("url", parama.url);
      locali.g("urlToken", parama.zZu);
      AppMethodBeat.o(286034);
      return locali;
      l1 = parama.zZx - parama.zUF;
      break;
      l2 = 0L;
      break label48;
      l3 = 0L;
      break label80;
      l4 = parama.zZx - parama.zZv;
      break label103;
    }
  }
  
  public static void bu(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(286023);
    p.k(paramString, "mediaId");
    paramString = (a)zZs.get(paramString);
    if (paramString != null)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramString.zZz = paramBoolean;
        paramString.zZy = cm.bfE();
        AppMethodBeat.o(286023);
        return;
      }
    }
    AppMethodBeat.o(286023);
  }
  
  public static void bv(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(286025);
    p.k(paramString, "mediaId");
    a locala = (a)zZs.get(paramString);
    int i;
    if (locala != null)
    {
      if (locala.zZx != 0L) {
        break label94;
      }
      i = 1;
      if (i == 0) {
        break label99;
      }
      label43:
      if (locala != null)
      {
        if (!paramBoolean) {
          break label104;
        }
        locala.zZA = true;
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        break label114;
      }
      paramString = (a)zZs.remove(paramString);
      if (paramString == null) {
        break label114;
      }
      p.j(paramString, "this");
      a(paramString, false);
      AppMethodBeat.o(286025);
      return;
      label94:
      i = 0;
      break;
      label99:
      locala = null;
      break label43;
      label104:
      locala.zZx = cm.bfE();
    }
    label114:
    AppMethodBeat.o(286025);
  }
  
  public static void dQx()
  {
    AppMethodBeat.i(286029);
    Iterator localIterator = ((Map)zZs).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((a)localEntry.getValue()).zZA) {
        a((a)localEntry.getValue(), true);
      }
    }
    zZs.clear();
    AppMethodBeat.o(286029);
  }
  
  public static void dV(String paramString, int paramInt)
  {
    AppMethodBeat.i(286019);
    p.k(paramString, "mediaId");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(286019);
      return;
    }
    a locala = new a();
    p.k(paramString, "<set-?>");
    locala.mediaId = paramString;
    ((Map)zZs).put(paramString, locala);
    locala.zUF = cm.bfE();
    locala.xkX = paramInt;
    AppMethodBeat.o(286019);
  }
  
  public static void t(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(286018);
    p.k(paramString1, "feedId");
    p.k(paramString2, "sessionId");
    p.k(paramString3, "contextId");
    p.k(paramString4, "clickTabContextId");
    h.IzE.a(21412, new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(286018);
  }
  
  public static void u(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(286020);
    p.k(paramString1, "mediaId");
    p.k(paramString2, "type");
    p.k(paramString3, "url");
    p.k(paramString4, "urlToken");
    paramString1 = (a)zZs.get(paramString1);
    if (paramString1 != null)
    {
      int i;
      if (paramString1.zZv == 0L)
      {
        i = 1;
        if (i == 0) {
          break label126;
        }
      }
      for (;;)
      {
        if (paramString1 == null) {
          break label131;
        }
        paramString1.zZv = cm.bfE();
        p.k(paramString2, "<set-?>");
        paramString1.type = paramString2;
        p.k(paramString3, "<set-?>");
        paramString1.url = paramString3;
        p.k(paramString4, "<set-?>");
        paramString1.zZu = paramString4;
        AppMethodBeat.o(286020);
        return;
        i = 0;
        break;
        label126:
        paramString1 = null;
      }
    }
    label131:
    AppMethodBeat.o(286020);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/MegaVideoReporter$LoadingData;", "", "()V", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "enterTimestamp", "", "getEnterTimestamp", "()J", "setEnterTimestamp", "(J)V", "firstFrameTimestamp", "getFirstFrameTimestamp", "setFirstFrameTimestamp", "hasFirstFrameUpdated", "", "getHasFirstFrameUpdated", "()Z", "setHasFirstFrameUpdated", "(Z)V", "hasMoovDownlaoded", "getHasMoovDownlaoded", "setHasMoovDownlaoded", "mediaId", "", "getMediaId", "()Ljava/lang/String;", "setMediaId", "(Ljava/lang/String;)V", "moovDownloadTimestamp", "getMoovDownloadTimestamp", "setMoovDownloadTimestamp", "seekTimestamp", "getSeekTimestamp", "setSeekTimestamp", "type", "getType", "setType", "url", "getUrl", "setUrl", "urlToken", "getUrlToken", "setUrlToken", "viewInitTimestamp", "getViewInitTimestamp", "setViewInitTimestamp", "plugin-finder_release"})
  public static final class a
  {
    String mediaId = "";
    String type = "";
    String url = "";
    int xkX;
    long zUF;
    boolean zZA;
    String zZu = "";
    long zZv;
    long zZw;
    long zZx;
    long zZy;
    boolean zZz = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ai
 * JD-Core Version:    0.7.0.1
 */