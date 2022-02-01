package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.btt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.concurrent.TimeUnit;

public class g
  extends c<btt>
{
  public g()
  {
    AppMethodBeat.i(44677);
    Log.i("MicroMsg.Recommend.CgiGetRecallInfo", "CgiGetRecallInfo");
    d.a locala = new d.a();
    locala.iLN = new bts();
    locala.iLO = new btt();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getrecallinfo";
    locala.funcId = 2572;
    c(locala.aXF());
    AppMethodBeat.o(44677);
  }
  
  public static void gN(boolean paramBoolean)
  {
    AppMethodBeat.i(44678);
    int j = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rOo, 0);
    if (j == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.e("MicroMsg.Recommend.CgiGetRecallInfo", "ABTestShowRecommend is not open, labValue:%d", new Object[] { Integer.valueOf(j) });
      AppMethodBeat.o(44678);
      return;
    }
    long l1 = AppBrandGlobalSystemConfig.bzP().ldp;
    long l4 = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NYn, Long.valueOf(0L))).longValue();
    long l2 = Util.nowSecond();
    long l3 = TimeUnit.DAYS.toSeconds(1L);
    l4 = l2 - l4;
    Log.i("MicroMsg.Recommend.CgiGetRecallInfo", "weUseRecallInterval:%d, internalTime:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l4) });
    if ((paramBoolean) || ((l1 > 0L) && (l4 >= l1)) || ((l1 <= 0L) && (l4 >= l3)))
    {
      Log.i("MicroMsg.Recommend.CgiGetRecallInfo", "force or It's time to do getRecallInfo");
      f.bZn().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44676);
          new g() {}.aYI();
          AppMethodBeat.o(44676);
        }
      });
      AppMethodBeat.o(44678);
      return;
    }
    Log.i("MicroMsg.Recommend.CgiGetRecallInfo", "time is not exceed one day, not to getRecallInfo");
    AppMethodBeat.o(44678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.g
 * JD-Core Version:    0.7.0.1
 */