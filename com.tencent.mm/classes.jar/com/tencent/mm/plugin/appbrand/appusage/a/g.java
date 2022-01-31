package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.concurrent.TimeUnit;

public class g
  extends com.tencent.mm.ai.a<apa>
{
  public g()
  {
    AppMethodBeat.i(129746);
    ab.i("MicroMsg.Recommend.CgiGetRecallInfo", "CgiGetRecallInfo");
    b.a locala = new b.a();
    locala.fsX = new aoz();
    locala.fsY = new apa();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecallinfo";
    locala.funcId = 2572;
    this.rr = locala.ado();
    AppMethodBeat.o(129746);
  }
  
  public static void dN(boolean paramBoolean)
  {
    AppMethodBeat.i(129747);
    int j = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRI, 0);
    if (j == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      ab.e("MicroMsg.Recommend.CgiGetRecallInfo", "ABTestShowRecommend is not open, labValue:%d", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(129747);
      return;
    }
    long l1 = AppBrandGlobalSystemConfig.ayt().hic;
    long l4 = ((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yDj, Long.valueOf(0L))).longValue();
    long l2 = bo.aox();
    long l3 = TimeUnit.DAYS.toSeconds(1L);
    l4 = l2 - l4;
    ab.i("MicroMsg.Recommend.CgiGetRecallInfo", "weUseRecallInterval:%d, internalTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l4) });
    if ((paramBoolean) || ((l1 > 0L) && (l4 >= l1)) || ((l1 <= 0L) && (l4 >= l3)))
    {
      ab.i("MicroMsg.Recommend.CgiGetRecallInfo", "force or It's time to do getRecallInfo");
      com.tencent.mm.plugin.appbrand.t.e.aNS().ac(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(129745);
          new g.1.1(this).adl();
          AppMethodBeat.o(129745);
        }
      });
      AppMethodBeat.o(129747);
      return;
    }
    ab.i("MicroMsg.Recommend.CgiGetRecallInfo", "time is not exceed one day, not to getRecallInfo");
    AppMethodBeat.o(129747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.g
 * JD-Core Version:    0.7.0.1
 */