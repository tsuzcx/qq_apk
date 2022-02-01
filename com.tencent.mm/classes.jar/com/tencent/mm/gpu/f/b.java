package com.tencent.mm.gpu.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.PluginGpuRes;
import com.tencent.mm.gpu.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(211048);
    Log.d("MicroMsg.GpuResReportTask", "GpuResReportTask run.");
    if (PluginGpuRes.isSkipModel())
    {
      Log.e("MicroMsg.GpuResReportTask", "skip current phone model");
      AppMethodBeat.o(211048);
      return;
    }
    Log.d("MicroMsg.GpuResReportTask", "do not skip current phone model");
    long l1 = System.currentTimeMillis();
    Object localObject = new a();
    long l2 = System.currentTimeMillis();
    String str = MMApplicationContext.getProcessName();
    e locale = new e();
    locale.pid = Process.myPid();
    locale.processName = str;
    locale.jVp = PluginGpuRes.getCurrSpend();
    locale.jVo = (l2 - l1);
    locale.jVn = ((a)localObject).aEQ();
    locale.jVl = ((a)localObject).aEP();
    locale.jVm = ((a)localObject).aER();
    Log.i("MicroMsg.GpuResReportTask", "processName = ".concat(String.valueOf(str)));
    Log.i("MicroMsg.GpuResReportTask", locale.toString());
    localObject = locale.processName;
    int i = locale.jVp;
    int j = c.Me((String)localObject);
    int k = locale.jVn;
    int m = locale.jVm;
    int n = locale.jVl;
    if ((k != 0) || (m != 0) || (n != 0))
    {
      if (i >= 360)
      {
        c.f(j, 76L, k);
        c.f(j, 78L, n);
        c.f(j, 77L, m);
        c.f(j, 96L, com.tencent.mm.gpu.e.b.aEL().dh(4352, 4369));
        c.f(j, 108L, com.tencent.mm.gpu.e.b.aEL().dh(4353, 4369));
        c.f(j, 119L, com.tencent.mm.gpu.e.b.aEL().dh(4354, 4369));
        c.f(j, 131L, com.tencent.mm.gpu.e.b.aEL().dh(4355, 4369));
        c.f(j, 75L, 1L);
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(211048);
      return;
      c.f(j, 4L, k);
      c.f(j, 6L, n);
      c.f(j, 5L, m);
      c.f(j, 88L, com.tencent.mm.gpu.e.b.aEL().dh(4352, 4369));
      c.f(j, 100L, com.tencent.mm.gpu.e.b.aEL().dh(4353, 4369));
      c.f(j, 111L, com.tencent.mm.gpu.e.b.aEL().dh(4354, 4369));
      c.f(j, 123L, com.tencent.mm.gpu.e.b.aEL().dh(4355, 4369));
      c.f(j, 3L, 1L);
      AppMethodBeat.o(211048);
      return;
      c.f(j, 13L, k);
      c.f(j, 15L, n);
      c.f(j, 14L, m);
      c.f(j, 89L, com.tencent.mm.gpu.e.b.aEL().dh(4352, 4369));
      c.f(j, 101L, com.tencent.mm.gpu.e.b.aEL().dh(4353, 4369));
      c.f(j, 112L, com.tencent.mm.gpu.e.b.aEL().dh(4354, 4369));
      c.f(j, 124L, com.tencent.mm.gpu.e.b.aEL().dh(4355, 4369));
      c.f(j, 12L, 1L);
      AppMethodBeat.o(211048);
      return;
      c.f(j, 22L, k);
      c.f(j, 24L, n);
      c.f(j, 23L, m);
      c.f(j, 90L, com.tencent.mm.gpu.e.b.aEL().dh(4352, 4369));
      c.f(j, 102L, com.tencent.mm.gpu.e.b.aEL().dh(4353, 4369));
      c.f(j, 113L, com.tencent.mm.gpu.e.b.aEL().dh(4354, 4369));
      c.f(j, 125L, com.tencent.mm.gpu.e.b.aEL().dh(4355, 4369));
      c.f(j, 21L, 1L);
      AppMethodBeat.o(211048);
      return;
      c.f(j, 31L, k);
      c.f(j, 33L, n);
      c.f(j, 32L, m);
      c.f(j, 91L, com.tencent.mm.gpu.e.b.aEL().dh(4352, 4369));
      c.f(j, 103L, com.tencent.mm.gpu.e.b.aEL().dh(4353, 4369));
      c.f(j, 114L, com.tencent.mm.gpu.e.b.aEL().dh(4354, 4369));
      c.f(j, 126L, com.tencent.mm.gpu.e.b.aEL().dh(4355, 4369));
      c.f(j, 30L, 1L);
      AppMethodBeat.o(211048);
      return;
      c.f(j, 40L, k);
      c.f(j, 42L, n);
      c.f(j, 41L, m);
      c.f(j, 92L, com.tencent.mm.gpu.e.b.aEL().dh(4352, 4369));
      c.f(j, 104L, com.tencent.mm.gpu.e.b.aEL().dh(4353, 4369));
      c.f(j, 115L, com.tencent.mm.gpu.e.b.aEL().dh(4354, 4369));
      c.f(j, 127L, com.tencent.mm.gpu.e.b.aEL().dh(4355, 4369));
      c.f(j, 39L, 1L);
      AppMethodBeat.o(211048);
      return;
      c.f(j, 49L, k);
      c.f(j, 51L, n);
      c.f(j, 50L, m);
      c.f(j, 93L, com.tencent.mm.gpu.e.b.aEL().dh(4352, 4369));
      c.f(j, 105L, com.tencent.mm.gpu.e.b.aEL().dh(4353, 4369));
      c.f(j, 116L, com.tencent.mm.gpu.e.b.aEL().dh(4354, 4369));
      c.f(j, 128L, com.tencent.mm.gpu.e.b.aEL().dh(4355, 4369));
      c.f(j, 48L, 1L);
      AppMethodBeat.o(211048);
      return;
      c.f(j, 58L, k);
      c.f(j, 60L, n);
      c.f(j, 59L, m);
      c.f(j, 94L, com.tencent.mm.gpu.e.b.aEL().dh(4352, 4369));
      c.f(j, 106L, com.tencent.mm.gpu.e.b.aEL().dh(4353, 4369));
      c.f(j, 117L, com.tencent.mm.gpu.e.b.aEL().dh(4354, 4369));
      c.f(j, 129L, com.tencent.mm.gpu.e.b.aEL().dh(4355, 4369));
      c.f(j, 57L, 1L);
      AppMethodBeat.o(211048);
      return;
      c.f(j, 67L, k);
      c.f(j, 69L, n);
      c.f(j, 68L, m);
      c.f(j, 95L, com.tencent.mm.gpu.e.b.aEL().dh(4352, 4369));
      c.f(j, 107L, com.tencent.mm.gpu.e.b.aEL().dh(4353, 4369));
      c.f(j, 118L, com.tencent.mm.gpu.e.b.aEL().dh(4354, 4369));
      c.f(j, 130L, com.tencent.mm.gpu.e.b.aEL().dh(4355, 4369));
      c.f(j, 66L, 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.gpu.f.b
 * JD-Core Version:    0.7.0.1
 */