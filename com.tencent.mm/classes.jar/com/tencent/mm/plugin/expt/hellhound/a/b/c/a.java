package com.tencent.mm.plugin.expt.hellhound.a.b.c;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cb;
import com.tencent.mm.g.b.a.ho;
import com.tencent.mm.g.b.a.hp;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a qXa;
  
  static
  {
    AppMethodBeat.i(210862);
    qXa = new a((byte)0);
    AppMethodBeat.o(210862);
  }
  
  public static final void a(b paramb)
  {
    AppMethodBeat.i(210863);
    a.a(paramb);
    AppMethodBeat.o(210863);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport$Companion;", "", "()V", "TAG", "", "report19943", "", "statistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "report19944", "feed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "report19945", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "plugin-expt_release"})
  public static final class a
  {
    public static void a(b paramb)
    {
      AppMethodBeat.i(210860);
      p.h(paramb, "statistics");
      cb localcb = new cb();
      localcb.lh(paramb.sessionId);
      localcb.li(com.tencent.mm.plugin.expt.hellhound.core.b.adO(paramb.dtL));
      localcb.hf(paramb.qXh);
      localcb.hg(paramb.qXi);
      localcb.he(paramb.qXg);
      localcb.lj(paramb.qXj);
      localcb.ll(com.tencent.mm.plugin.expt.hellhound.core.b.cnI());
      StringBuilder localStringBuilder;
      if (p.i(localcb.Sz(), "FinderTopicFeedUI"))
      {
        str = localcb.Sz();
        localStringBuilder = new StringBuilder().append(str);
        if (!paramb.qXl) {
          break label181;
        }
      }
      label181:
      for (String str = "_POI";; str = "")
      {
        localcb.li(str);
        localcb.lk(paramb.qXk);
        localcb.hh(paramb.dFx);
        h.LTJ.aU((Runnable)new a(localcb));
        AppMethodBeat.o(210860);
        return;
      }
    }
    
    public static void a(final com.tencent.mm.plugin.expt.hellhound.a.b.d.i parami)
    {
      AppMethodBeat.i(210861);
      p.h(parami, "feed");
      hp localhp = new hp();
      localhp.qp(parami.sessionId);
      localhp.qq(parami.feedId);
      localhp.nb(parami.qXR);
      localhp.nc(parami.qXS);
      localhp.iT(parami.qXT);
      Object localObject;
      float f2;
      if (parami.qXp <= 0.0F)
      {
        f1 = 100.0F;
        localObject = d.g.b.ad.MLZ;
        localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.g(localObject, "java.lang.String.format(format, *args)");
        localhp.qr((String)localObject);
        if (localhp.UR() == -1) {
          localhp.iT(0);
        }
        if (parami.qXq > 0.0F) {
          break label311;
        }
        f1 = parami.width;
        f2 = parami.height;
        localObject = c.qVY;
      }
      label311:
      for (float f1 = f1 * f2 * 100.0F / c.coR();; f1 = parami.qXq)
      {
        localObject = d.g.b.ad.MLZ;
        localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.g(localObject, "java.lang.String.format(format, *args)");
        localhp.qs((String)localObject);
        localhp.qt(parami.qXu);
        localhp.iU(parami.scene);
        localhp.nd(parami.qXn);
        localhp.ne(parami.qXU);
        localhp.iV(parami.qXV);
        localhp.iW(parami.kd);
        localhp.qu(parami.qXv);
        h.LTJ.aU((Runnable)new b(localhp, parami));
        AppMethodBeat.o(210861);
        return;
        f1 = parami.qXp;
        break;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(cb paramcb) {}
      
      public final void run()
      {
        AppMethodBeat.i(210857);
        this.qXb.aLk();
        com.tencent.mm.sdk.platformtools.ad.i("HABBYGE-MALI.HellFinderReport", "report[19943]: sessionId=" + this.qXb.getSessionId() + ", page=" + this.qXb.Sz() + ", enterTimeMs=" + this.qXb.SB() + ", exitTimeMs=" + this.qXb.SC() + ", stayTimeMs=" + this.qXb.SA() + ", sid=" + this.qXb.SE() + ", reportType=" + this.qXb.SF() + ", contextId=" + this.qXb.SD() + ", finderContextId=" + this.qXb.SG());
        AppMethodBeat.o(210857);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(hp paramhp, com.tencent.mm.plugin.expt.hellhound.a.b.d.i parami) {}
      
      public final void run()
      {
        AppMethodBeat.i(210858);
        this.qXc.dJX();
        com.tencent.mm.sdk.platformtools.ad.i("HABBYGE-MALI.HellFinderReport", "report[19944]:\nsessionId=" + this.qXc.getSessionId() + '\n' + "feedId=" + this.qXc.UO() + '\n' + "name=" + parami.bVF + '\n' + "startExposureMs=" + this.qXc.UP() + '\n' + "endExposureMs=" + this.qXc.UQ() + '\n' + "itemExposureTimeMs=" + this.qXc.US() + '\n' + "screenExposureAreaWeigth=" + this.qXc.UH() + '\n' + "disAppearType=" + this.qXc.UR() + '\n' + "contextId=" + this.qXc.UL() + '\n' + "scene=" + this.qXc.getScene() + '\n' + "updataTimeMs=" + this.qXc.UE() + '\n' + "itemPos=" + this.qXc.UT() + '\n' + "itemArrayIndex=" + this.qXc.UN() + '\n' + "itemBufffer=" + this.qXc.UM() + '\n' + "itemExposureAreaWeigth=" + this.qXc.UG());
        AppMethodBeat.o(210858);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    public static final class c
      implements Runnable
    {
      public c(ho paramho, com.tencent.mm.plugin.expt.hellhound.a.b.d.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(210859);
        this.qXe.dJX();
        com.tencent.mm.sdk.platformtools.ad.i("HABBYGE-MALI.HellFinderReport", "report[19945]:\nsessionId=" + this.qXe.getSessionId() + '\n' + "clickFeedId=" + this.qXe.UD() + '\n' + "position=" + this.qXf.position + '\n' + "nickName=" + this.qXf.bVF + '\n' + "scene=" + this.qXe.getScene() + '\n' + "updateTimeMs=" + this.qXe.UE() + '\n' + "clickTimeMs=" + this.qXe.UF() + '\n' + "itemExposureAreaWeigth=" + this.qXe.UG() + '\n' + "screenExposureAreaWeigth=" + this.qXe.UH() + '\n' + "itemDirection=" + this.qXe.UI() + '\n' + "itemIndex=" + this.qXe.UJ() + '\n' + "shotScreenJson=" + this.qXe.UK() + '\n' + "contextId=" + this.qXe.UL() + '\n' + "itemBufffer=" + this.qXe.UM() + '\n' + "itemArrayIndex=" + this.qXe.UN());
        AppMethodBeat.o(210859);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */