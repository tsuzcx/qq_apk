package com.tencent.mm.plugin.expt.hellhound.a.b.c;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cb;
import com.tencent.mm.g.b.a.hq;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a rff;
  
  static
  {
    AppMethodBeat.i(196533);
    rff = new a((byte)0);
    AppMethodBeat.o(196533);
  }
  
  public static final void a(b paramb)
  {
    AppMethodBeat.i(196534);
    a.a(paramb);
    AppMethodBeat.o(196534);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport$Companion;", "", "()V", "TAG", "", "report19943", "", "statistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "report19944", "feed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "report19945", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "plugin-expt_release"})
  public static final class a
  {
    public static void a(b paramb)
    {
      AppMethodBeat.i(196531);
      p.h(paramb, "statistics");
      cb localcb = new cb();
      localcb.lu(paramb.sessionId);
      localcb.lv(com.tencent.mm.plugin.expt.hellhound.core.b.aeI(paramb.duQ));
      localcb.hk(paramb.rfm);
      localcb.hl(paramb.rfn);
      localcb.hj(paramb.rfl);
      localcb.lw(paramb.rfo);
      localcb.ly(com.tencent.mm.plugin.expt.hellhound.core.b.cpk());
      Object localObject2;
      if (p.i(localcb.Sx(), "FinderTopicFeedUI"))
      {
        localObject1 = localcb.Sx();
        localObject2 = new StringBuilder().append((String)localObject1);
        if (!paramb.rfq) {
          break label249;
        }
      }
      label249:
      for (Object localObject1 = "_POI";; localObject1 = "")
      {
        localcb.lv((String)localObject1);
        localcb.lx(paramb.rfp);
        localcb.hm(paramb.dGC);
        localObject1 = paramb.extraInfo;
        if (localObject1 != null)
        {
          localObject2 = n.h((String)localObject1, ",", ";", false);
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localcb.lz((String)localObject1);
        paramb = paramb.rfr;
        if (paramb != null)
        {
          localObject1 = n.h(paramb, ",", ";", false);
          paramb = (b)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramb = "";
        }
        localcb.lA(paramb);
        h.MqF.aR((Runnable)new a(localcb));
        AppMethodBeat.o(196531);
        return;
      }
    }
    
    public static void a(final com.tencent.mm.plugin.expt.hellhound.a.b.d.i parami)
    {
      AppMethodBeat.i(196532);
      p.h(parami, "feed");
      hr localhr = new hr();
      localhr.qK(parami.sessionId);
      localhr.qL(parami.feedId);
      localhr.nn(parami.rfX);
      localhr.no(parami.rfY);
      localhr.iV(parami.rfZ);
      Object localObject;
      float f2;
      if (parami.rfv <= 0.0F)
      {
        f1 = 100.0F;
        localObject = ad.Njc;
        localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.g(localObject, "java.lang.String.format(format, *args)");
        localhr.qM((String)localObject);
        if (localhr.UX() == -1) {
          localhr.iV(0);
        }
        if (parami.rfw > 0.0F) {
          break label313;
        }
        f1 = parami.width;
        f2 = parami.height;
        localObject = c.rdX;
      }
      label313:
      for (float f1 = f1 * f2 * 100.0F / c.cqt();; f1 = parami.rfw)
      {
        localObject = ad.Njc;
        localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        p.g(localObject, "java.lang.String.format(format, *args)");
        localhr.qN((String)localObject);
        localhr.qO(parami.rfA);
        localhr.iW(parami.scene);
        localhr.np(parami.rft);
        localhr.nq(parami.rga);
        localhr.iX(parami.rgb);
        localhr.iY(parami.kd);
        localhr.qP(parami.rfB);
        h.MqF.aR((Runnable)new b(localhr, parami));
        AppMethodBeat.o(196532);
        return;
        f1 = parami.rfv;
        break;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(cb paramcb) {}
      
      public final void run()
      {
        AppMethodBeat.i(196528);
        this.rfg.aLH();
        ae.i("HABBYGE-MALI.HellFinderReport", "report[19943]: sessionId=" + this.rfg.getSessionId() + ", page=" + this.rfg.Sx() + ", enterTimeMs=" + this.rfg.Sz() + ", exitTimeMs=" + this.rfg.SA() + ", stayTimeMs=" + this.rfg.Sy() + ", sid=" + this.rfg.SC() + ", reportType=" + this.rfg.SD() + ", contextId=" + this.rfg.SB() + ", finderContextId=" + this.rfg.SE() + ", extraInfo=" + this.rfg.getExtraInfo() + ",  enterSourceInfo=" + this.rfg.SF());
        AppMethodBeat.o(196528);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(hr paramhr, com.tencent.mm.plugin.expt.hellhound.a.b.d.i parami) {}
      
      public final void run()
      {
        AppMethodBeat.i(196529);
        this.rfh.dNp();
        ae.i("HABBYGE-MALI.HellFinderReport", "report[19944]:\nsessionId=" + this.rfh.getSessionId() + '\n' + "feedId=" + this.rfh.UU() + '\n' + "name=" + parami.bVF + '\n' + "startExposureMs=" + this.rfh.UV() + '\n' + "endExposureMs=" + this.rfh.UW() + '\n' + "itemExposureTimeMs=" + this.rfh.UY() + '\n' + "screenExposureAreaWeigth=" + this.rfh.UN() + '\n' + "disAppearType=" + this.rfh.UX() + '\n' + "contextId=" + this.rfh.UR() + '\n' + "scene=" + this.rfh.getScene() + '\n' + "updataTimeMs=" + this.rfh.UK() + '\n' + "itemPos=" + this.rfh.UZ() + '\n' + "itemArrayIndex=" + this.rfh.UT() + '\n' + "itemBufffer=" + this.rfh.US() + '\n' + "itemExposureAreaWeigth=" + this.rfh.UM());
        AppMethodBeat.o(196529);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    public static final class c
      implements Runnable
    {
      public c(hq paramhq, com.tencent.mm.plugin.expt.hellhound.a.b.d.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(196530);
        this.rfj.dNp();
        ae.i("HABBYGE-MALI.HellFinderReport", "report[19945]:\nsessionId=" + this.rfj.getSessionId() + '\n' + "clickFeedId=" + this.rfj.UJ() + '\n' + "position=" + this.rfk.position + '\n' + "nickName=" + this.rfk.bVF + '\n' + "scene=" + this.rfj.getScene() + '\n' + "updateTimeMs=" + this.rfj.UK() + '\n' + "clickTimeMs=" + this.rfj.UL() + '\n' + "itemExposureAreaWeigth=" + this.rfj.UM() + '\n' + "screenExposureAreaWeigth=" + this.rfj.UN() + '\n' + "itemDirection=" + this.rfj.UO() + '\n' + "itemIndex=" + this.rfj.UP() + '\n' + "shotScreenJson=" + this.rfj.UQ() + '\n' + "contextId=" + this.rfj.UR() + '\n' + "itemBufffer=" + this.rfj.US() + '\n' + "itemArrayIndex=" + this.rfj.UT());
        AppMethodBeat.o(196530);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */