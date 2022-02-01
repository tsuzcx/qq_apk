package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.concurrent.TimeUnit;

public class g
  extends c<azh>
{
  public g()
  {
    AppMethodBeat.i(44677);
    ad.i("MicroMsg.Recommend.CgiGetRecallInfo", "CgiGetRecallInfo");
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    locala.gUU = new azg();
    locala.gUV = new azh();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecallinfo";
    locala.funcId = 2572;
    this.rr = locala.atI();
    AppMethodBeat.o(44677);
  }
  
  public static void fr(boolean paramBoolean)
  {
    AppMethodBeat.i(44678);
    int j = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(com.tencent.mm.plugin.expt.a.b.a.piV, 0);
    if (j == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.e("MicroMsg.Recommend.CgiGetRecallInfo", "ABTestShowRecommend is not open, labValue:%d", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(44678);
      return;
    }
    long l1 = AppBrandGlobalSystemConfig.aTv().jcO;
    long l4 = ((Long)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FlH, Long.valueOf(0L))).longValue();
    long l2 = bt.aGK();
    long l3 = TimeUnit.DAYS.toSeconds(1L);
    l4 = l2 - l4;
    ad.i("MicroMsg.Recommend.CgiGetRecallInfo", "weUseRecallInterval:%d, internalTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l4) });
    if ((paramBoolean) || ((l1 > 0L) && (l4 >= l1)) || ((l1 <= 0L) && (l4 >= l3)))
    {
      ad.i("MicroMsg.Recommend.CgiGetRecallInfo", "force or It's time to do getRecallInfo");
      com.tencent.mm.plugin.appbrand.utils.e.bqm().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44676);
          new g() {}.auK();
          AppMethodBeat.o(44676);
        }
      });
      AppMethodBeat.o(44678);
      return;
    }
    ad.i("MicroMsg.Recommend.CgiGetRecallInfo", "time is not exceed one day, not to getRecallInfo");
    AppMethodBeat.o(44678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.g
 * JD-Core Version:    0.7.0.1
 */