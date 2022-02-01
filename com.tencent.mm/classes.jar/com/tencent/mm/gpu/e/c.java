package com.tencent.mm.gpu.e;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.PluginGpuRes;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class c
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(209432);
    ac.d("GpuResReportTask", "GpuResReportTask run.");
    if (PluginGpuRes.isSkipModel())
    {
      ac.e("GpuResReportTask", "skip current phone model");
      AppMethodBeat.o(209432);
      return;
    }
    ac.d("GpuResReportTask", "do not skip current phone model");
    long l1 = System.currentTimeMillis();
    Object localObject = new com.tencent.mm.gpu.f.a();
    long l2 = System.currentTimeMillis();
    String str = ai.getProcessName();
    f localf = new f();
    localf.pid = Process.myPid();
    localf.processName = str;
    localf.gaB = PluginGpuRes.getCurrSpend();
    localf.gaA = (l2 - l1);
    localf.gaz = ((com.tencent.mm.gpu.f.a)localObject).aen();
    localf.gax = ((com.tencent.mm.gpu.f.a)localObject).aem();
    localf.gay = ((com.tencent.mm.gpu.f.a)localObject).aeo();
    ac.i("GpuResReportTask", "processName = ".concat(String.valueOf(str)));
    ac.i("GpuResReportTask", localf.toString());
    localObject = localf.processName;
    int i = localf.gaB;
    int j = d.tv((String)localObject);
    int k = localf.gaz;
    int m = localf.gay;
    int n = localf.gax;
    if ((k != 0) || (m != 0) || (n != 0))
    {
      if (i >= 360)
      {
        d.e(j, 76L, k);
        d.e(j, 78L, n);
        d.e(j, 77L, m);
        d.e(j, 96L, com.tencent.mm.gpu.d.a.aef().lK(1));
        d.e(j, 108L, com.tencent.mm.gpu.d.a.aef().lK(2));
        d.e(j, 119L, com.tencent.mm.gpu.d.a.aef().lK(3));
        d.e(j, 131L, com.tencent.mm.gpu.d.a.aef().lK(4));
        d.e(j, 75L, 1L);
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(209432);
      return;
      d.e(j, 4L, k);
      d.e(j, 6L, n);
      d.e(j, 5L, m);
      d.e(j, 88L, com.tencent.mm.gpu.d.a.aef().lK(1));
      d.e(j, 100L, com.tencent.mm.gpu.d.a.aef().lK(2));
      d.e(j, 111L, com.tencent.mm.gpu.d.a.aef().lK(3));
      d.e(j, 123L, com.tencent.mm.gpu.d.a.aef().lK(4));
      d.e(j, 3L, 1L);
      AppMethodBeat.o(209432);
      return;
      d.e(j, 13L, k);
      d.e(j, 15L, n);
      d.e(j, 14L, m);
      d.e(j, 89L, com.tencent.mm.gpu.d.a.aef().lK(1));
      d.e(j, 101L, com.tencent.mm.gpu.d.a.aef().lK(2));
      d.e(j, 112L, com.tencent.mm.gpu.d.a.aef().lK(3));
      d.e(j, 124L, com.tencent.mm.gpu.d.a.aef().lK(4));
      d.e(j, 12L, 1L);
      AppMethodBeat.o(209432);
      return;
      d.e(j, 22L, k);
      d.e(j, 24L, n);
      d.e(j, 23L, m);
      d.e(j, 90L, com.tencent.mm.gpu.d.a.aef().lK(1));
      d.e(j, 102L, com.tencent.mm.gpu.d.a.aef().lK(2));
      d.e(j, 113L, com.tencent.mm.gpu.d.a.aef().lK(3));
      d.e(j, 125L, com.tencent.mm.gpu.d.a.aef().lK(4));
      d.e(j, 21L, 1L);
      AppMethodBeat.o(209432);
      return;
      d.e(j, 31L, k);
      d.e(j, 33L, n);
      d.e(j, 32L, m);
      d.e(j, 91L, com.tencent.mm.gpu.d.a.aef().lK(1));
      d.e(j, 103L, com.tencent.mm.gpu.d.a.aef().lK(2));
      d.e(j, 114L, com.tencent.mm.gpu.d.a.aef().lK(3));
      d.e(j, 126L, com.tencent.mm.gpu.d.a.aef().lK(4));
      d.e(j, 30L, 1L);
      AppMethodBeat.o(209432);
      return;
      d.e(j, 40L, k);
      d.e(j, 42L, n);
      d.e(j, 41L, m);
      d.e(j, 92L, com.tencent.mm.gpu.d.a.aef().lK(1));
      d.e(j, 104L, com.tencent.mm.gpu.d.a.aef().lK(2));
      d.e(j, 115L, com.tencent.mm.gpu.d.a.aef().lK(3));
      d.e(j, 127L, com.tencent.mm.gpu.d.a.aef().lK(4));
      d.e(j, 39L, 1L);
      AppMethodBeat.o(209432);
      return;
      d.e(j, 49L, k);
      d.e(j, 51L, n);
      d.e(j, 50L, m);
      d.e(j, 93L, com.tencent.mm.gpu.d.a.aef().lK(1));
      d.e(j, 105L, com.tencent.mm.gpu.d.a.aef().lK(2));
      d.e(j, 116L, com.tencent.mm.gpu.d.a.aef().lK(3));
      d.e(j, 128L, com.tencent.mm.gpu.d.a.aef().lK(4));
      d.e(j, 48L, 1L);
      AppMethodBeat.o(209432);
      return;
      d.e(j, 58L, k);
      d.e(j, 60L, n);
      d.e(j, 59L, m);
      d.e(j, 94L, com.tencent.mm.gpu.d.a.aef().lK(1));
      d.e(j, 106L, com.tencent.mm.gpu.d.a.aef().lK(2));
      d.e(j, 117L, com.tencent.mm.gpu.d.a.aef().lK(3));
      d.e(j, 129L, com.tencent.mm.gpu.d.a.aef().lK(4));
      d.e(j, 57L, 1L);
      AppMethodBeat.o(209432);
      return;
      d.e(j, 67L, k);
      d.e(j, 69L, n);
      d.e(j, 68L, m);
      d.e(j, 95L, com.tencent.mm.gpu.d.a.aef().lK(1));
      d.e(j, 107L, com.tencent.mm.gpu.d.a.aef().lK(2));
      d.e(j, 118L, com.tencent.mm.gpu.d.a.aef().lK(3));
      d.e(j, 130L, com.tencent.mm.gpu.d.a.aef().lK(4));
      d.e(j, 66L, 1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.e.c
 * JD-Core Version:    0.7.0.1
 */