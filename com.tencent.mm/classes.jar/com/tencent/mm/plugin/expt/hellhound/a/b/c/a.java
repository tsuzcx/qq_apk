package com.tencent.mm.plugin.expt.hellhound.a.b.c;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bm;
import com.tencent.mm.g.b.a.gl;
import com.tencent.mm.g.b.a.gm;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a qoc;
  
  static
  {
    AppMethodBeat.i(195516);
    qoc = new a((byte)0);
    AppMethodBeat.o(195516);
  }
  
  public static final void a(b paramb)
  {
    AppMethodBeat.i(195517);
    a.a(paramb);
    AppMethodBeat.o(195517);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport$Companion;", "", "()V", "TAG", "", "report19943", "", "statistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "report19944", "feed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "report19945", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "plugin-expt_release"})
  public static final class a
  {
    public static void a(b paramb)
    {
      AppMethodBeat.i(195514);
      k.h(paramb, "statistics");
      bm localbm = new bm();
      localbm.ju(paramb.sessionId);
      localbm.jv(com.tencent.mm.plugin.expt.hellhound.core.b.aab(paramb.qoi));
      localbm.fM(paramb.qok);
      localbm.fN(paramb.qol);
      localbm.fL(paramb.qoj);
      localbm.jw(paramb.qom);
      StringBuilder localStringBuilder;
      if (k.g(localbm.Qw(), "FinderTopicFeedUI"))
      {
        str = localbm.Qw();
        localStringBuilder = new StringBuilder().append(str);
        if (!paramb.qoo) {
          break label173;
        }
      }
      label173:
      for (String str = "_POI";; str = "")
      {
        localbm.jv(str);
        localbm.jx(paramb.qon);
        localbm.fO(paramb.dtw);
        h.JZN.aV((Runnable)new a(localbm));
        AppMethodBeat.o(195514);
        return;
      }
    }
    
    public static void a(final com.tencent.mm.plugin.expt.hellhound.a.b.d.i parami)
    {
      AppMethodBeat.i(195515);
      k.h(parami, "feed");
      gm localgm = new gm();
      localgm.nQ(parami.sessionId);
      localgm.nR(parami.feedId);
      localgm.lh(parami.qoS);
      localgm.li(parami.qoT);
      localgm.iA(parami.qoU);
      Object localObject;
      float f2;
      if (parami.qos <= 0.0F)
      {
        f1 = 100.0F;
        localObject = z.KUT;
        localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        k.g(localObject, "java.lang.String.format(format, *args)");
        localgm.nS((String)localObject);
        if (localgm.SD() == -1) {
          localgm.iA(0);
        }
        if (parami.qot > 0.0F) {
          break label311;
        }
        f1 = parami.width;
        f2 = parami.height;
        localObject = c.qna;
      }
      label311:
      for (float f1 = f1 * f2 * 100.0F / c.cjG();; f1 = parami.qot)
      {
        localObject = z.KUT;
        localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        k.g(localObject, "java.lang.String.format(format, *args)");
        localgm.nT((String)localObject);
        localgm.nU(parami.qox);
        localgm.iB(parami.scene);
        localgm.lj(parami.qoq);
        localgm.lk(parami.qoV);
        localgm.iC(parami.qoW);
        localgm.iD(parami.ij);
        localgm.nV(parami.qoy);
        h.JZN.aV((Runnable)new b(localgm, parami));
        AppMethodBeat.o(195515);
        return;
        f1 = parami.qos;
        break;
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(bm parambm) {}
      
      public final void run()
      {
        AppMethodBeat.i(195511);
        this.qod.aHZ();
        ac.i("HABBYGE-MALI.HellFinderReport", "report[19943]: sessionId=" + this.qod.getSessionId() + ", page=" + this.qod.Qw() + ", enterTimeMs=" + this.qod.Qy() + ", exitTimeMs=" + this.qod.Qz() + ", stayTimeMs=" + this.qod.Qx() + ", sid=" + this.qod.QB() + ", reportType=" + this.qod.QC() + ", contextId=" + this.qod.QA());
        AppMethodBeat.o(195511);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(gm paramgm, com.tencent.mm.plugin.expt.hellhound.a.b.d.i parami) {}
      
      public final void run()
      {
        AppMethodBeat.i(195512);
        this.qoe.dyF();
        ac.i("HABBYGE-MALI.HellFinderReport", "report[19944]:\nsessionId=" + this.qoe.getSessionId() + '\n' + "feedId=" + this.qoe.SA() + '\n' + "name=" + parami.bLs + '\n' + "startExposureMs=" + this.qoe.SB() + '\n' + "endExposureMs=" + this.qoe.SC() + '\n' + "itemExposureTimeMs=" + this.qoe.SE() + '\n' + "screenExposureAreaWeigth=" + this.qoe.St() + '\n' + "disAppearType=" + this.qoe.SD() + '\n' + "contextId=" + this.qoe.Sx() + '\n' + "scene=" + this.qoe.getScene() + '\n' + "updataTimeMs=" + this.qoe.Sq() + '\n' + "itemPos=" + this.qoe.SF() + '\n' + "itemArrayIndex=" + this.qoe.Sz() + '\n' + "itemBufffer=" + this.qoe.Sy() + '\n' + "itemExposureAreaWeigth=" + this.qoe.Ss());
        AppMethodBeat.o(195512);
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    public static final class c
      implements Runnable
    {
      public c(gl paramgl, com.tencent.mm.plugin.expt.hellhound.a.b.d.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(195513);
        this.qog.dyF();
        ac.i("HABBYGE-MALI.HellFinderReport", "report[19945]:\nsessionId=" + this.qog.getSessionId() + '\n' + "clickFeedId=" + this.qog.Sp() + '\n' + "position=" + this.qoh.position + '\n' + "nickName=" + this.qoh.bLs + '\n' + "scene=" + this.qog.getScene() + '\n' + "updateTimeMs=" + this.qog.Sq() + '\n' + "clickTimeMs=" + this.qog.Sr() + '\n' + "itemExposureAreaWeigth=" + this.qog.Ss() + '\n' + "screenExposureAreaWeigth=" + this.qog.St() + '\n' + "itemDirection=" + this.qog.Su() + '\n' + "itemIndex=" + this.qog.Sv() + '\n' + "shotScreenJson=" + this.qog.Sw() + '\n' + "contextId=" + this.qog.Sx() + '\n' + "itemBufffer=" + this.qog.Sy() + '\n' + "itemArrayIndex=" + this.qog.Sz());
        AppMethodBeat.o(195513);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */