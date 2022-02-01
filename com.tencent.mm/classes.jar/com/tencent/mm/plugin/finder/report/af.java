package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.b.a.cg;
import com.tencent.mm.g.b.a.dk;
import com.tencent.mm.g.b.a.fv;
import com.tencent.mm.g.b.a.fw;
import com.tencent.mm.g.b.a.fx;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.g.b.a.fz;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/MegaVideoReporter;", "", "()V", "TAG", "", "loadingDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/report/MegaVideoReporter$LoadingData;", "buildJson", "Lcom/tencent/mm/json/JSONObject;", "data", "isExit", "", "clearLoadingData", "", "notifyEnterMegaVideo", "mediaId", "commentScene", "", "notifyFirstFrame", "isFromSurface", "notifyMegaVideoSeek", "notifyMoovReady", "moovFirstDownloaded", "notifyViewInit", "type", "url", "urlToken", "report21149", "clickId", "postId", "actionType", "timeStamp", "", "clickTab", "report21150", "feedId", "megaVideoId", "megaVideoDuration", "bulletTextCount", "bulletTime", "outcome", "report21151", "sessionId", "contextId", "clickTabContextId", "report21152", "longVideoLen", "isHaveGuide", "currentPlayLen", "report21153", "report21154", "currTime", "generateType", "taskOrder", "miniSessionId", "report21155", "opType", "report21412", "report21680", "LoadingData", "plugin-finder_release"})
public final class af
{
  public static final af viA;
  private static final ConcurrentHashMap<String, a> viz;
  
  static
  {
    AppMethodBeat.i(250865);
    viA = new af();
    viz = new ConcurrentHashMap();
    AppMethodBeat.o(250865);
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(250853);
    p.h(paramString1, "megaVideoId");
    p.h(paramString2, "miniSessionId");
    p.h(paramString3, "sessionId");
    p.h(paramString4, "contextId");
    p.h(paramString5, "clickTabContextId");
    p.h(paramString6, "feedId");
    fz localfz = new fz();
    localfz.tf(String.valueOf(paramLong));
    localfz.pJ(paramInt1);
    localfz.agK();
    localfz.tg(paramString2);
    localfz.pK(paramInt2);
    localfz.th(paramString1);
    localfz.ti(paramString3);
    localfz.tj(paramString4);
    localfz.tk(paramString5);
    localfz.tl(paramString6);
    localfz.bfK();
    paramString1 = k.vfA;
    k.a((a)localfz);
    AppMethodBeat.o(250853);
  }
  
  private static void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(250863);
    cg localcg = new cg();
    localcg.adb();
    localcg.fS(3L);
    parama = b(parama, paramBoolean).toString();
    p.g(parama, "buildJson(data, isExit).toString()");
    localcg.lH(n.j(parama, ",", ";", false));
    localcg.bfK();
    Log.i("MegaVideoReporter", "report21680 info:" + localcg.abW());
    AppMethodBeat.o(250863);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(250854);
    p.h(paramString1, "miniSessionId");
    p.h(paramString2, "megaVideoId");
    p.h(paramString3, "sessionId");
    p.h(paramString4, "contextId");
    p.h(paramString5, "clickTabContextId");
    fy localfy = new fy();
    localfy.agI();
    localfy.agJ();
    localfy.ta(paramString1);
    localfy.pI(paramInt);
    localfy.tb(paramString2);
    localfy.tc(paramString3);
    localfy.td(paramString4);
    localfy.te(paramString5);
    localfy.bfK();
    paramString1 = k.vfA;
    k.a((a)localfy);
    AppMethodBeat.o(250854);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(250850);
    p.h(paramString1, "feedId");
    p.h(paramString2, "megaVideoId");
    fv localfv = new fv();
    localfv.sO(paramString1);
    localfv.sP(paramString2);
    localfv.pz(paramInt1);
    localfv.pA(paramInt2);
    localfv.pB(paramLong);
    localfv.pC(paramInt3);
    localfv.bfK();
    paramString1 = k.vfA;
    k.a((a)localfv);
    AppMethodBeat.o(250850);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(250851);
    p.h(paramString1, "feedId");
    p.h(paramString2, "megaVideoId");
    p.h(paramString3, "sessionId");
    p.h(paramString4, "contextId");
    p.h(paramString5, "clickTabContextId");
    fx localfx = new fx();
    localfx.sV(paramString1);
    localfx.sW(paramString2);
    localfx.pG(paramInt1);
    localfx.pH(paramInt2);
    localfx.sX(paramString3);
    localfx.sY(paramString4);
    localfx.sZ(paramString5);
    localfx.bfK();
    paramString1 = k.vfA;
    k.a((a)localfx);
    AppMethodBeat.o(250851);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(250848);
    p.h(paramString1, "clickId");
    p.h(paramString2, "postId");
    dk localdk = new dk();
    localdk.oK(paramString1);
    localdk.oL(paramString2);
    localdk.jG(paramInt1);
    localdk.jH(paramLong);
    localdk.jI(paramInt2);
    localdk.bfK();
    paramString1 = k.vfA;
    k.a((a)localdk);
    AppMethodBeat.o(250848);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    AppMethodBeat.i(250852);
    p.h(paramString1, "feedId");
    p.h(paramString2, "megaVideoId");
    p.h(paramString3, "sessionId");
    p.h(paramString4, "contextId");
    p.h(paramString5, "clickTabContextId");
    fw localfw = new fw();
    localfw.sQ(paramString1);
    localfw.sR(paramString2);
    localfw.sS(paramString3);
    localfw.sT(paramString4);
    localfw.sU(paramString5);
    localfw.agH();
    localfw.pD(paramLong1);
    if (paramBoolean) {}
    for (paramLong1 = 1L;; paramLong1 = 2L)
    {
      localfw.pE(paramLong1);
      localfw.pF(paramLong2);
      localfw.bfK();
      paramString1 = k.vfA;
      k.a((a)localfw);
      AppMethodBeat.o(250852);
      return;
    }
  }
  
  public static void auN(String paramString)
  {
    AppMethodBeat.i(250858);
    p.h(paramString, "mediaId");
    paramString = (a)viz.get(paramString);
    if (paramString != null)
    {
      paramString.viE = cl.aWA();
      AppMethodBeat.o(250858);
      return;
    }
    AppMethodBeat.o(250858);
  }
  
  private static i b(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(250864);
    long l1;
    long l2;
    label48:
    long l3;
    label80:
    long l4;
    if ((paramBoolean) && (parama.viF == 0L))
    {
      l1 = cl.aWA() - parama.viC;
      if (parama.viD <= 0L) {
        break label304;
      }
      l2 = parama.viD - parama.viC;
      if ((parama.viD <= 0L) || (parama.viG <= parama.viD)) {
        break label310;
      }
      l3 = parama.viG - parama.viD;
      if ((!paramBoolean) || (parama.viF != 0L)) {
        break label316;
      }
      l4 = cl.aWA() - parama.viD;
      label103:
      if (parama.viE <= 0L) {
        break label330;
      }
    }
    label304:
    label310:
    label316:
    label330:
    for (long l5 = Math.max(parama.viF - parama.viE, 0L);; l5 = 0L)
    {
      i locali = new i();
      locali.U("commentScene", parama.tCE);
      locali.v("totalTime", l1);
      locali.w("isExit", paramBoolean);
      locali.v("enterToViewInit", l2);
      locali.w("isMoovReadyBeforeEnter", parama.viH);
      locali.v("viewInitToMoovDownloaded", l3);
      locali.v("viewInitToFirstFrame", Math.max(l4, 0L));
      locali.v("seekToFirstFrame", l5);
      locali.h("mediaId", parama.mediaId);
      locali.h("type", parama.type);
      locali.h("url", parama.url);
      locali.h("urlToken", parama.viB);
      AppMethodBeat.o(250864);
      return locali;
      l1 = parama.viF - parama.viC;
      break;
      l2 = 0L;
      break label48;
      l3 = 0L;
      break label80;
      l4 = parama.viF - parama.viD;
      break label103;
    }
  }
  
  public static void bp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(250859);
    p.h(paramString, "mediaId");
    paramString = (a)viz.get(paramString);
    if (paramString != null)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramString.viH = paramBoolean;
        paramString.viG = cl.aWA();
        AppMethodBeat.o(250859);
        return;
      }
    }
    AppMethodBeat.o(250859);
  }
  
  public static void bq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(250860);
    p.h(paramString, "mediaId");
    a locala = (a)viz.get(paramString);
    int i;
    if (locala != null)
    {
      if (locala.viF != 0L) {
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
        locala.viI = true;
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        break label114;
      }
      paramString = (a)viz.remove(paramString);
      if (paramString == null) {
        break label114;
      }
      p.g(paramString, "this");
      a(paramString, false);
      AppMethodBeat.o(250860);
      return;
      label94:
      i = 0;
      break;
      label99:
      locala = null;
      break label43;
      label104:
      locala.viF = cl.aWA();
    }
    label114:
    AppMethodBeat.o(250860);
  }
  
  public static void dB(String paramString, int paramInt)
  {
    AppMethodBeat.i(250856);
    p.h(paramString, "mediaId");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(250856);
      return;
    }
    a locala = new a();
    p.h(paramString, "<set-?>");
    locala.mediaId = paramString;
    ((Map)viz).put(paramString, locala);
    locala.viC = cl.aWA();
    locala.tCE = paramInt;
    AppMethodBeat.o(250856);
  }
  
  public static void doU()
  {
    AppMethodBeat.i(250862);
    Iterator localIterator = ((Map)viz).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((a)localEntry.getValue()).viI) {
        a((a)localEntry.getValue(), true);
      }
    }
    viz.clear();
    AppMethodBeat.o(250862);
  }
  
  public static void p(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(250855);
    p.h(paramString1, "feedId");
    p.h(paramString2, "sessionId");
    p.h(paramString3, "contextId");
    p.h(paramString4, "clickTabContextId");
    h.CyF.a(21412, new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(250855);
  }
  
  public static void q(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(250857);
    p.h(paramString1, "mediaId");
    p.h(paramString2, "type");
    p.h(paramString3, "url");
    p.h(paramString4, "urlToken");
    paramString1 = (a)viz.get(paramString1);
    if (paramString1 != null)
    {
      int i;
      if (paramString1.viD == 0L)
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
        paramString1.viD = cl.aWA();
        p.h(paramString2, "<set-?>");
        paramString1.type = paramString2;
        p.h(paramString3, "<set-?>");
        paramString1.url = paramString3;
        p.h(paramString4, "<set-?>");
        paramString1.viB = paramString4;
        AppMethodBeat.o(250857);
        return;
        i = 0;
        break;
        label126:
        paramString1 = null;
      }
    }
    label131:
    AppMethodBeat.o(250857);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/MegaVideoReporter$LoadingData;", "", "()V", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "enterTimestamp", "", "getEnterTimestamp", "()J", "setEnterTimestamp", "(J)V", "firstFrameTimestamp", "getFirstFrameTimestamp", "setFirstFrameTimestamp", "hasFirstFrameUpdated", "", "getHasFirstFrameUpdated", "()Z", "setHasFirstFrameUpdated", "(Z)V", "hasMoovDownlaoded", "getHasMoovDownlaoded", "setHasMoovDownlaoded", "mediaId", "", "getMediaId", "()Ljava/lang/String;", "setMediaId", "(Ljava/lang/String;)V", "moovDownloadTimestamp", "getMoovDownloadTimestamp", "setMoovDownloadTimestamp", "seekTimestamp", "getSeekTimestamp", "setSeekTimestamp", "type", "getType", "setType", "url", "getUrl", "setUrl", "urlToken", "getUrlToken", "setUrlToken", "viewInitTimestamp", "getViewInitTimestamp", "setViewInitTimestamp", "plugin-finder_release"})
  public static final class a
  {
    String mediaId = "";
    int tCE;
    String type = "";
    String url = "";
    String viB = "";
    long viC;
    long viD;
    long viE;
    long viF;
    long viG;
    boolean viH = true;
    boolean viI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.af
 * JD-Core Version:    0.7.0.1
 */