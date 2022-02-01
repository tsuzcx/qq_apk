package com.tencent.mm.plugin.expt.hellhound.a.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.fj;
import com.tencent.mm.f.b.a.oi;
import com.tencent.mm.f.b.a.oj;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a wmq;
  
  static
  {
    AppMethodBeat.i(252791);
    wmq = new a((byte)0);
    AppMethodBeat.o(252791);
  }
  
  public static final void a(b paramb)
  {
    AppMethodBeat.i(252794);
    a.a(paramb);
    AppMethodBeat.o(252794);
  }
  
  public static final void report21053OnClickOnSnsAd(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    AppMethodBeat.i(252797);
    ((ak)com.tencent.mm.kernel.h.ag(ak.class)).report21053OnClickOnSnsAd(paramLong1, paramLong2, paramString, paramLong3);
    AppMethodBeat.o(252797);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport$Companion;", "", "()V", "TAG", "", "report19943", "", "statistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "report19944", "feed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "report19945", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "report21053OnClickOnSnsAd", "feedId", "", "liveId", "userName", "pos", "reportGiftOnReturn", "plugin-expt_release"})
  public static final class a
  {
    public static void a(b paramb)
    {
      AppMethodBeat.i(254106);
      p.k(paramb, "statistics");
      fj localfj = new fj();
      localfj.ui(paramb.sessionId);
      localfj.uj(com.tencent.mm.plugin.expt.hellhound.core.b.awW(paramb.fFe));
      localfj.no(paramb.wmx);
      localfj.np(paramb.wmy);
      localfj.nn(paramb.wmw);
      localfj.uk(paramb.wmz);
      localfj.um(com.tencent.mm.plugin.expt.hellhound.core.b.dcv());
      Object localObject2;
      if (p.h(localfj.akA(), "FinderTopicFeedUI"))
      {
        localObject1 = localfj.akA();
        localObject2 = new StringBuilder().append((String)localObject1);
        if (!paramb.wmB) {
          break label249;
        }
      }
      label249:
      for (Object localObject1 = "_POI";; localObject1 = "")
      {
        localfj.uj((String)localObject1);
        localfj.ul(paramb.wmA);
        localfj.nq(paramb.fSe);
        localObject1 = paramb.extraInfo;
        if (localObject1 != null)
        {
          localObject2 = n.l((String)localObject1, ",", ";", false);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localfj.un((String)localObject1);
        paramb = paramb.wmC;
        if (paramb != null)
        {
          localObject1 = n.l(paramb, ",", ";", false);
          paramb = (b)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramb = "";
        }
        localfj.uo(paramb);
        com.tencent.e.h.ZvG.bh((Runnable)new a(localfj));
        AppMethodBeat.o(254106);
        return;
      }
    }
    
    public static void a(final com.tencent.mm.plugin.expt.hellhound.a.b.d.i parami)
    {
      AppMethodBeat.i(254109);
      p.k(parami, "feed");
      oj localoj = new oj();
      localoj.Fo(parami.sessionId);
      localoj.Fp(parami.feedId);
      localoj.AM(parami.wno);
      localoj.AN(parami.wnp);
      localoj.oi(parami.wnq);
      Object localObject;
      float f2;
      if (parami.wmG <= 0.0F)
      {
        f1 = 100.0F;
        localObject = af.aaBG;
        localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.j(localObject, "java.lang.String.format(format, *args)");
        localoj.Fq((String)localObject);
        if (localoj.aos() == -1) {
          localoj.oi(0);
        }
        if (parami.wmH > 0.0F) {
          break label313;
        }
        f1 = parami.width;
        f2 = parami.height;
        localObject = c.wkV;
      }
      label313:
      for (float f1 = f1 * f2 * 100.0F / c.ddO();; f1 = parami.wmH)
      {
        localObject = af.aaBG;
        localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.j(localObject, "java.lang.String.format(format, *args)");
        localoj.Fr((String)localObject);
        localoj.Fs(parami.wmL);
        localoj.oj(parami.scene);
        localoj.AO(parami.wmE);
        localoj.AP(parami.wnr);
        localoj.ok(parami.wns);
        localoj.ol(parami.bwM);
        localoj.Ft(parami.wmM);
        com.tencent.e.h.ZvG.bh((Runnable)new b(localoj, parami));
        AppMethodBeat.o(254109);
        return;
        f1 = parami.wmG;
        break;
      }
    }
    
    public static void reportGiftOnReturn()
    {
      AppMethodBeat.i(254111);
      c.a locala = c.wkV;
      if (!c.ddG())
      {
        AppMethodBeat.o(254111);
        return;
      }
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).reportGiftOnReturn();
      AppMethodBeat.o(254111);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(fj paramfj) {}
      
      public final void run()
      {
        AppMethodBeat.i(254826);
        this.wmr.bpa();
        Log.i("HABBYGE-MALI.HellFinderReport", "report[19943]: sessionId=" + this.wmr.getSessionId() + ", page=" + this.wmr.akA() + ", enterTimeMs=" + this.wmr.akB() + ", exitTimeMs=" + this.wmr.akC() + ", stayTimeMs=" + this.wmr.akl() + ", sid=" + this.wmr.akD() + ", reportType=" + this.wmr.akE() + ", contextId=" + this.wmr.agY() + ", finderContextId=" + this.wmr.akF() + ", extraInfo=" + this.wmr.ahJ() + ",  enterSourceInfo=" + this.wmr.akG());
        AppMethodBeat.o(254826);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(oj paramoj, com.tencent.mm.plugin.expt.hellhound.a.b.d.i parami) {}
      
      public final void run()
      {
        AppMethodBeat.i(252646);
        this.wms.fBl();
        Log.i("HABBYGE-MALI.HellFinderReport", "report[19944]:\nsessionId=" + this.wms.getSessionId() + '\n' + "feedId=" + this.wms.ahZ() + '\n' + "name=" + parami.nickName + '\n' + "startExposureMs=" + this.wms.aoq() + '\n' + "endExposureMs=" + this.wms.aor() + '\n' + "itemExposureTimeMs=" + this.wms.aot() + '\n' + "screenExposureAreaWeigth=" + this.wms.aok() + '\n' + "disAppearType=" + this.wms.aos() + '\n' + "contextId=" + this.wms.agX() + '\n' + "scene=" + this.wms.getScene() + '\n' + "updataTimeMs=" + this.wms.aoh() + '\n' + "itemPos=" + this.wms.aou() + '\n' + "itemArrayIndex=" + this.wms.aop() + '\n' + "itemBufffer=" + this.wms.aoo() + '\n' + "itemExposureAreaWeigth=" + this.wms.aoj());
        AppMethodBeat.o(252646);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    public static final class c
      implements Runnable
    {
      public c(oi paramoi, com.tencent.mm.plugin.expt.hellhound.a.b.d.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(253866);
        this.wmu.fBl();
        Log.i("HABBYGE-MALI.HellFinderReport", "report[19945]:\nsessionId=" + this.wmu.getSessionId() + '\n' + "clickFeedId=" + this.wmu.aog() + '\n' + "position=" + this.wmv.position + '\n' + "nickName=" + this.wmv.nickName + '\n' + "scene=" + this.wmu.getScene() + '\n' + "updateTimeMs=" + this.wmu.aoh() + '\n' + "clickTimeMs=" + this.wmu.aoi() + '\n' + "itemExposureAreaWeigth=" + this.wmu.aoj() + '\n' + "screenExposureAreaWeigth=" + this.wmu.aok() + '\n' + "itemDirection=" + this.wmu.aol() + '\n' + "itemIndex=" + this.wmu.aom() + '\n' + "shotScreenJson=" + this.wmu.aon() + '\n' + "contextId=" + this.wmu.agX() + '\n' + "itemBufffer=" + this.wmu.aoo() + '\n' + "itemArrayIndex=" + this.wmu.aop());
        AppMethodBeat.o(253866);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */