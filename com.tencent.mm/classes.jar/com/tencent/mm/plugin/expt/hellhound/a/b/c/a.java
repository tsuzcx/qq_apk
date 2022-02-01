package com.tencent.mm.plugin.expt.hellhound.a.b.c;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ia;
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.g.b.a.io;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a KHO;
  
  static
  {
    AppMethodBeat.i(205257);
    KHO = new a((byte)0);
    AppMethodBeat.o(205257);
  }
  
  public static final void a(b paramb)
  {
    AppMethodBeat.i(205258);
    a.a(paramb);
    AppMethodBeat.o(205258);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/HellFinderReport$Companion;", "", "()V", "TAG", "", "report19943", "", "statistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "report19944", "feed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "report19945", "clickFeed", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "plugin-expt_release"})
  public static final class a
  {
    public static void a(b paramb)
    {
      AppMethodBeat.i(205255);
      k.h(paramb, "statistics");
      ia localia = new ia();
      localia.aSI(paramb.sessionId);
      localia.aSJ(com.tencent.mm.plugin.expt.hellhound.core.b.aUP(paramb.DDP));
      localia.zy(paramb.KHU);
      localia.zz(paramb.KHV);
      localia.zx(paramb.xBr);
      localia.aSK(paramb.KHW);
      StringBuilder localStringBuilder;
      if (k.g(localia.aYS(), "FinderTopicFeedUI"))
      {
        str = localia.aYS();
        localStringBuilder = new StringBuilder().append(str);
        if (!paramb.KHX) {
          break label173;
        }
      }
      label173:
      for (String str = "_POI";; str = "")
      {
        localia.aSJ(str);
        localia.aSL(paramb.pZX);
        localia.zA(paramb.dvJ);
        h.Iye.aS((Runnable)new a(localia));
        AppMethodBeat.o(205255);
        return;
      }
    }
    
    public static void a(final com.tencent.mm.plugin.expt.hellhound.a.b.d.i parami)
    {
      AppMethodBeat.i(205256);
      k.h(parami, "feed");
      io localio = new io();
      localio.aTL(parami.sessionId);
      localio.aTM(parami.feedId);
      localio.AX(parami.KIA);
      localio.AY(parami.KIB);
      localio.AV(parami.KIC);
      Object localObject;
      float f2;
      if (parami.KIb <= 0.0F)
      {
        f1 = 100.0F;
        localObject = z.Jhz;
        localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        k.g(localObject, "java.lang.String.format(format, *args)");
        localio.aTN((String)localObject);
        if (localio.cci() == -1) {
          localio.AV(0);
        }
        if (parami.KIc > 0.0F) {
          break label311;
        }
        f1 = parami.width;
        f2 = parami.height;
        localObject = c.KGM;
      }
      label311:
      for (float f1 = f1 * f2 * 100.0F / c.fRz();; f1 = parami.KIc)
      {
        localObject = z.Jhz;
        localObject = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(f1 / 100.0F) }, 1));
        k.g(localObject, "java.lang.String.format(format, *args)");
        localio.aTO((String)localObject);
        localio.aTP(parami.qwV);
        localio.Bu(parami.scene);
        localio.AZ(parami.KHZ);
        localio.Ba(parami.KID);
        localio.Bv(parami.KIE);
        localio.Bw(parami.hj);
        localio.aTQ(parami.KIg);
        h.Iye.aS((Runnable)new b(localio, parami));
        AppMethodBeat.o(205256);
        return;
        f1 = parami.KIb;
        break;
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ia paramia) {}
      
      public final void run()
      {
        AppMethodBeat.i(205252);
        this.KHP.aBj();
        ad.i("HABBYGE-MALI.HellFinderReport", "report[19943]: sessionId=" + this.KHP.getSessionId() + ", page=" + this.KHP.aYS() + ", enterTimeMs=" + this.KHP.bqZ() + ", exitTimeMs=" + this.KHP.bsA() + ", stayTimeMs=" + this.KHP.baR() + ", sid=" + this.KHP.bsO() + ", reportType=" + this.KHP.bsX() + ", contextId=" + this.KHP.bsB());
        AppMethodBeat.o(205252);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(io paramio, com.tencent.mm.plugin.expt.hellhound.a.b.d.i parami) {}
      
      public final void run()
      {
        AppMethodBeat.i(205253);
        this.KHQ.fYy();
        ad.i("HABBYGE-MALI.HellFinderReport", "report[19944]:\nsessionId=" + this.KHQ.getSessionId() + '\n' + "feedId=" + this.KHQ.bYE() + '\n' + "name=" + parami.bNK + '\n' + "startExposureMs=" + this.KHQ.bYF() + '\n' + "endExposureMs=" + this.KHQ.bYQ() + '\n' + "itemExposureTimeMs=" + this.KHQ.ccj() + '\n' + "screenExposureAreaWeigth=" + this.KHQ.btg() + '\n' + "disAppearType=" + this.KHQ.cci() + '\n' + "contextId=" + this.KHQ.bQT() + '\n' + "scene=" + this.KHQ.getScene() + '\n' + "updataTimeMs=" + this.KHQ.btd() + '\n' + "itemPos=" + this.KHQ.cck() + '\n' + "itemArrayIndex=" + this.KHQ.bYB() + '\n' + "itemBufffer=" + this.KHQ.bUo() + '\n' + "itemExposureAreaWeigth=" + this.KHQ.btf());
        AppMethodBeat.o(205253);
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    public static final class c
      implements Runnable
    {
      public c(in paramin, com.tencent.mm.plugin.expt.hellhound.a.b.d.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(205254);
        this.KHS.fYy();
        ad.i("HABBYGE-MALI.HellFinderReport", "report[19945]:\nsessionId=" + this.KHS.getSessionId() + '\n' + "clickFeedId=" + this.KHS.btc() + '\n' + "position=" + this.KHT.position + '\n' + "nickName=" + this.KHT.bNK + '\n' + "scene=" + this.KHS.getScene() + '\n' + "updateTimeMs=" + this.KHS.btd() + '\n' + "clickTimeMs=" + this.KHS.bte() + '\n' + "itemExposureAreaWeigth=" + this.KHS.btf() + '\n' + "screenExposureAreaWeigth=" + this.KHS.btg() + '\n' + "itemDirection=" + this.KHS.bul() + '\n' + "itemIndex=" + this.KHS.bum() + '\n' + "shotScreenJson=" + this.KHS.bMv() + '\n' + "contextId=" + this.KHS.bQT() + '\n' + "itemBufffer=" + this.KHS.bUo() + '\n' + "itemArrayIndex=" + this.KHS.bYB());
        AppMethodBeat.o(205254);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */