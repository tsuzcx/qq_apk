package com.tencent.mm.gpu.e;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.PluginGpuRes;
import com.tencent.mm.gpu.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(219541);
    ad.d("GpuResReportTask", "GpuResReportTask run.");
    if (PluginGpuRes.isSkipModel())
    {
      ad.e("GpuResReportTask", "skip current phone model");
      AppMethodBeat.o(219541);
      return;
    }
    ad.d("GpuResReportTask", "do not skip current phone model");
    long l1 = System.currentTimeMillis();
    Object localObject = new a();
    long l2 = System.currentTimeMillis();
    String str = aj.getProcessName();
    e locale = new e();
    locale.pid = Process.myPid();
    locale.processName = str;
    locale.gua = PluginGpuRes.getCurrSpend();
    locale.gtZ = (l2 - l1);
    locale.gtY = ((a)localObject).agU();
    locale.gtW = ((a)localObject).agT();
    locale.gtX = ((a)localObject).agV();
    ad.i("GpuResReportTask", "processName = ".concat(String.valueOf(str)));
    ad.i("GpuResReportTask", locale.toString());
    localObject = locale.processName;
    int i = locale.gua;
    int j = c.wl((String)localObject);
    int k = locale.gtY;
    int m = locale.gtX;
    int n = locale.gtW;
    if ((k != 0) || (m != 0) || (n != 0))
    {
      if (i >= 360)
      {
        c.e(j, 76L, k);
        c.e(j, 78L, n);
        c.e(j, 77L, m);
        c.e(j, 96L, com.tencent.mm.gpu.d.c.agM().mj(1));
        c.e(j, 108L, com.tencent.mm.gpu.d.c.agM().mj(2));
        c.e(j, 119L, com.tencent.mm.gpu.d.c.agM().mj(3));
        c.e(j, 131L, com.tencent.mm.gpu.d.c.agM().mj(4));
        c.e(j, 75L, 1L);
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(219541);
      return;
      c.e(j, 4L, k);
      c.e(j, 6L, n);
      c.e(j, 5L, m);
      c.e(j, 88L, com.tencent.mm.gpu.d.c.agM().mj(1));
      c.e(j, 100L, com.tencent.mm.gpu.d.c.agM().mj(2));
      c.e(j, 111L, com.tencent.mm.gpu.d.c.agM().mj(3));
      c.e(j, 123L, com.tencent.mm.gpu.d.c.agM().mj(4));
      c.e(j, 3L, 1L);
      AppMethodBeat.o(219541);
      return;
      c.e(j, 13L, k);
      c.e(j, 15L, n);
      c.e(j, 14L, m);
      c.e(j, 89L, com.tencent.mm.gpu.d.c.agM().mj(1));
      c.e(j, 101L, com.tencent.mm.gpu.d.c.agM().mj(2));
      c.e(j, 112L, com.tencent.mm.gpu.d.c.agM().mj(3));
      c.e(j, 124L, com.tencent.mm.gpu.d.c.agM().mj(4));
      c.e(j, 12L, 1L);
      AppMethodBeat.o(219541);
      return;
      c.e(j, 22L, k);
      c.e(j, 24L, n);
      c.e(j, 23L, m);
      c.e(j, 90L, com.tencent.mm.gpu.d.c.agM().mj(1));
      c.e(j, 102L, com.tencent.mm.gpu.d.c.agM().mj(2));
      c.e(j, 113L, com.tencent.mm.gpu.d.c.agM().mj(3));
      c.e(j, 125L, com.tencent.mm.gpu.d.c.agM().mj(4));
      c.e(j, 21L, 1L);
      AppMethodBeat.o(219541);
      return;
      c.e(j, 31L, k);
      c.e(j, 33L, n);
      c.e(j, 32L, m);
      c.e(j, 91L, com.tencent.mm.gpu.d.c.agM().mj(1));
      c.e(j, 103L, com.tencent.mm.gpu.d.c.agM().mj(2));
      c.e(j, 114L, com.tencent.mm.gpu.d.c.agM().mj(3));
      c.e(j, 126L, com.tencent.mm.gpu.d.c.agM().mj(4));
      c.e(j, 30L, 1L);
      AppMethodBeat.o(219541);
      return;
      c.e(j, 40L, k);
      c.e(j, 42L, n);
      c.e(j, 41L, m);
      c.e(j, 92L, com.tencent.mm.gpu.d.c.agM().mj(1));
      c.e(j, 104L, com.tencent.mm.gpu.d.c.agM().mj(2));
      c.e(j, 115L, com.tencent.mm.gpu.d.c.agM().mj(3));
      c.e(j, 127L, com.tencent.mm.gpu.d.c.agM().mj(4));
      c.e(j, 39L, 1L);
      AppMethodBeat.o(219541);
      return;
      c.e(j, 49L, k);
      c.e(j, 51L, n);
      c.e(j, 50L, m);
      c.e(j, 93L, com.tencent.mm.gpu.d.c.agM().mj(1));
      c.e(j, 105L, com.tencent.mm.gpu.d.c.agM().mj(2));
      c.e(j, 116L, com.tencent.mm.gpu.d.c.agM().mj(3));
      c.e(j, 128L, com.tencent.mm.gpu.d.c.agM().mj(4));
      c.e(j, 48L, 1L);
      AppMethodBeat.o(219541);
      return;
      c.e(j, 58L, k);
      c.e(j, 60L, n);
      c.e(j, 59L, m);
      c.e(j, 94L, com.tencent.mm.gpu.d.c.agM().mj(1));
      c.e(j, 106L, com.tencent.mm.gpu.d.c.agM().mj(2));
      c.e(j, 117L, com.tencent.mm.gpu.d.c.agM().mj(3));
      c.e(j, 129L, com.tencent.mm.gpu.d.c.agM().mj(4));
      c.e(j, 57L, 1L);
      AppMethodBeat.o(219541);
      return;
      c.e(j, 67L, k);
      c.e(j, 69L, n);
      c.e(j, 68L, m);
      c.e(j, 95L, com.tencent.mm.gpu.d.c.agM().mj(1));
      c.e(j, 107L, com.tencent.mm.gpu.d.c.agM().mj(2));
      c.e(j, 118L, com.tencent.mm.gpu.d.c.agM().mj(3));
      c.e(j, 130L, com.tencent.mm.gpu.d.c.agM().mj(4));
      c.e(j, 66L, 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.e.b
 * JD-Core Version:    0.7.0.1
 */