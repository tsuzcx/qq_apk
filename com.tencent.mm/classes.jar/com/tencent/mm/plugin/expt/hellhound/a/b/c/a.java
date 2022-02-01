package com.tencent.mm.plugin.expt.hellhound.a.b.c;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.el;
import com.tencent.mm.g.b.a.ll;
import com.tencent.mm.g.b.a.lm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a sGv;
  
  static
  {
    AppMethodBeat.i(221024);
    sGv = new a((byte)0);
    AppMethodBeat.o(221024);
  }
  
  public static final void a(b paramb)
  {
    AppMethodBeat.i(221025);
    a.a(paramb);
    AppMethodBeat.o(221025);
  }
  
  public static final void report21053OnClickOnSnsAd(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(221026);
    ((aj)g.ah(aj.class)).report21053OnClickOnSnsAd(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(221026);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport$Companion;", "", "()V", "TAG", "", "report19943", "", "statistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "report19944", "feed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "report19945", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "report21053OnClickOnSnsAd", "feedId", "", "liveId", "userName", "pos", "reportGiftOnReturn", "plugin-expt_release"})
  public static final class a
  {
    public static void a(b paramb)
    {
      AppMethodBeat.i(221021);
      p.h(paramb, "statistics");
      el localel = new el();
      localel.re(paramb.sessionId);
      localel.rf(com.tencent.mm.plugin.expt.hellhound.core.b.aoX(paramb.dMl));
      localel.mb(paramb.sGC);
      localel.mc(paramb.sGD);
      localel.ma(paramb.sGB);
      localel.rg(paramb.sGE);
      localel.ri(com.tencent.mm.plugin.expt.hellhound.core.b.cND());
      Object localObject2;
      if (p.j(localel.afB(), "FinderTopicFeedUI"))
      {
        localObject1 = localel.afB();
        localObject2 = new StringBuilder().append((String)localObject1);
        if (!paramb.sGG) {
          break label249;
        }
      }
      label249:
      for (Object localObject1 = "_POI";; localObject1 = "")
      {
        localel.rf((String)localObject1);
        localel.rh(paramb.sGF);
        localel.md(paramb.dYn);
        localObject1 = paramb.extraInfo;
        if (localObject1 != null)
        {
          localObject2 = n.j((String)localObject1, ",", ";", false);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localel.rj((String)localObject1);
        paramb = paramb.sGH;
        if (paramb != null)
        {
          localObject1 = n.j(paramb, ",", ";", false);
          paramb = (b)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramb = "";
        }
        localel.rk(paramb);
        h.RTc.ba((Runnable)new a(localel));
        AppMethodBeat.o(221021);
        return;
      }
    }
    
    public static void a(final com.tencent.mm.plugin.expt.hellhound.a.b.d.i parami)
    {
      AppMethodBeat.i(221022);
      p.h(parami, "feed");
      lm locallm = new lm();
      locallm.yN(parami.sessionId);
      locallm.yO(parami.feedId);
      locallm.uX(parami.sHt);
      locallm.uY(parami.sHu);
      locallm.lX(parami.sHv);
      Object localObject;
      float f2;
      if (parami.sGL <= 0.0F)
      {
        f1 = 100.0F;
        localObject = ae.SYK;
        localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.g(localObject, "java.lang.String.format(format, *args)");
        locallm.yP((String)localObject);
        if (locallm.aiO() == -1) {
          locallm.lX(0);
        }
        if (parami.sGM > 0.0F) {
          break label313;
        }
        f1 = parami.width;
        f2 = parami.height;
        localObject = c.sFa;
      }
      label313:
      for (float f1 = f1 * f2 * 100.0F / c.cOV();; f1 = parami.sGM)
      {
        localObject = ae.SYK;
        localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.g(localObject, "java.lang.String.format(format, *args)");
        locallm.yQ((String)localObject);
        locallm.yR(parami.sGQ);
        locallm.lY(parami.scene);
        locallm.uZ(parami.sGJ);
        locallm.va(parami.sHw);
        locallm.lZ(parami.sHx);
        locallm.ma(parami.kf);
        locallm.yS(parami.sGR);
        h.RTc.ba((Runnable)new b(locallm, parami));
        AppMethodBeat.o(221022);
        return;
        f1 = parami.sGL;
        break;
      }
    }
    
    public static void reportGiftOnReturn()
    {
      AppMethodBeat.i(221023);
      c.a locala = c.sFa;
      if (!c.cON())
      {
        AppMethodBeat.o(221023);
        return;
      }
      ((aj)g.ah(aj.class)).reportGiftOnReturn();
      AppMethodBeat.o(221023);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(el paramel) {}
      
      public final void run()
      {
        AppMethodBeat.i(221018);
        this.sGw.bfK();
        Log.i("HABBYGE-MALI.HellFinderReport", "report[19943]: sessionId=" + this.sGw.getSessionId() + ", page=" + this.sGw.afB() + ", enterTimeMs=" + this.sGw.afC() + ", exitTimeMs=" + this.sGw.afD() + ", stayTimeMs=" + this.sGw.afo() + ", sid=" + this.sGw.afE() + ", reportType=" + this.sGw.afF() + ", contextId=" + this.sGw.ack() + ", finderContextId=" + this.sGw.afG() + ", extraInfo=" + this.sGw.getExtraInfo() + ",  enterSourceInfo=" + this.sGw.afH());
        AppMethodBeat.o(221018);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(lm paramlm, com.tencent.mm.plugin.expt.hellhound.a.b.d.i parami) {}
      
      public final void run()
      {
        AppMethodBeat.i(221019);
        this.sGx.eOp();
        Log.i("HABBYGE-MALI.HellFinderReport", "report[19944]:\nsessionId=" + this.sGx.getSessionId() + '\n' + "feedId=" + this.sGx.adk() + '\n' + "name=" + parami.nickName + '\n' + "startExposureMs=" + this.sGx.aiM() + '\n' + "endExposureMs=" + this.sGx.aiN() + '\n' + "itemExposureTimeMs=" + this.sGx.aiP() + '\n' + "screenExposureAreaWeigth=" + this.sGx.aiG() + '\n' + "disAppearType=" + this.sGx.aiO() + '\n' + "contextId=" + this.sGx.acj() + '\n' + "scene=" + this.sGx.getScene() + '\n' + "updataTimeMs=" + this.sGx.aiD() + '\n' + "itemPos=" + this.sGx.aiQ() + '\n' + "itemArrayIndex=" + this.sGx.aiL() + '\n' + "itemBufffer=" + this.sGx.aiK() + '\n' + "itemExposureAreaWeigth=" + this.sGx.aiF());
        AppMethodBeat.o(221019);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    public static final class c
      implements Runnable
    {
      public c(ll paramll, com.tencent.mm.plugin.expt.hellhound.a.b.d.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(221020);
        this.sGz.eOp();
        Log.i("HABBYGE-MALI.HellFinderReport", "report[19945]:\nsessionId=" + this.sGz.getSessionId() + '\n' + "clickFeedId=" + this.sGz.aiC() + '\n' + "position=" + this.sGA.position + '\n' + "nickName=" + this.sGA.nickName + '\n' + "scene=" + this.sGz.getScene() + '\n' + "updateTimeMs=" + this.sGz.aiD() + '\n' + "clickTimeMs=" + this.sGz.aiE() + '\n' + "itemExposureAreaWeigth=" + this.sGz.aiF() + '\n' + "screenExposureAreaWeigth=" + this.sGz.aiG() + '\n' + "itemDirection=" + this.sGz.aiH() + '\n' + "itemIndex=" + this.sGz.aiI() + '\n' + "shotScreenJson=" + this.sGz.aiJ() + '\n' + "contextId=" + this.sGz.acj() + '\n' + "itemBufffer=" + this.sGz.aiK() + '\n' + "itemArrayIndex=" + this.sGz.aiL());
        AppMethodBeat.o(221020);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */