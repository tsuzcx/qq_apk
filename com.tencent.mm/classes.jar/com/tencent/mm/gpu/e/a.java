package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
  implements Runnable
{
  private static d mk(int paramInt)
  {
    AppMethodBeat.i(219540);
    d locald = new d();
    int j = 0;
    int i = paramInt;
    int k = 0;
    while (j < 5)
    {
      locald.J(j, k, i);
      k += paramInt;
      j += 1;
      i += paramInt;
    }
    AppMethodBeat.o(219540);
    return locald;
  }
  
  public final void run()
  {
    AppMethodBeat.i(219539);
    ad.e("Gpu.GpuRegionReportTask", "GpuRegionReportTask start");
    Object localObject1 = aj.getProcessName();
    int[] arrayOfInt = new int[3];
    if (com.tencent.mm.gpu.b.a.gtD.equals(localObject1))
    {
      arrayOfInt[0] = 30;
      arrayOfInt[1] = 30;
      arrayOfInt[2] = 50;
      localObject1 = new d[3];
      localObject1[0] = mk(arrayOfInt[0]);
      localObject1[1] = mk(arrayOfInt[1]);
      localObject1[2] = mk(arrayOfInt[2]);
      ad.i("Gpu.GpuRegionReportTask", "gfx region : " + localObject1[0].toString());
      ad.i("Gpu.GpuRegionReportTask", "egl region : " + localObject1[1].toString());
      ad.i("Gpu.GpuRegionReportTask", " gl region : " + localObject1[2].toString());
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label291;
      }
      ad.e("Gpu.GpuRegionReportTask", "regions == null, GpuRegionReportTask end");
      AppMethodBeat.o(219539);
      return;
      if (((String)localObject1).startsWith(com.tencent.mm.gpu.b.a.gtE))
      {
        arrayOfInt[0] = 30;
        arrayOfInt[1] = 20;
        arrayOfInt[2] = 50;
        break;
      }
      if (com.tencent.mm.gpu.b.a.gtF.equals(localObject1))
      {
        arrayOfInt[0] = 30;
        arrayOfInt[1] = 30;
        arrayOfInt[2] = 50;
        break;
      }
      if (com.tencent.mm.gpu.b.a.gtG.equals(localObject1))
      {
        arrayOfInt[0] = 15;
        arrayOfInt[1] = 15;
        arrayOfInt[2] = 40;
        break;
      }
      localObject1 = null;
    }
    label291:
    arrayOfInt = localObject1[2];
    Object localObject2 = localObject1[1];
    localObject1 = localObject1[0];
    com.tencent.mm.gpu.f.a locala = new com.tencent.mm.gpu.f.a();
    int i = locala.agV();
    int j = locala.agU();
    int k = locala.agT();
    if (arrayOfInt.unit == 61166)
    {
      i /= 1024;
      ad.i("Gpu.GpuRegionReportTask", "gl size = " + i + "/mb");
      if (localObject2.unit != 61166) {
        break label620;
      }
      j /= 1024;
      ad.i("Gpu.GpuRegionReportTask", "egl size = " + j + "/mb");
      label420:
      if (((d)localObject1).unit != 61166) {
        break label649;
      }
      k /= 1024;
      ad.i("Gpu.GpuRegionReportTask", "gfx size = " + k + "/mb");
    }
    for (;;)
    {
      i = arrayOfInt.ml(i);
      j = localObject2.ml(j);
      k = ((d)localObject1).ml(k);
      ad.e("Gpu.GpuRegionReportTask", "indexGL = ".concat(String.valueOf(i)));
      ad.e("Gpu.GpuRegionReportTask", "indexEGL = ".concat(String.valueOf(j)));
      ad.e("Gpu.GpuRegionReportTask", "indexGfx = ".concat(String.valueOf(k)));
      localObject1 = aj.getProcessName();
      c.e(c.wl((String)localObject1), j + 150, 1L);
      c.e(c.wl((String)localObject1), i + 161, 1L);
      c.e(c.wl((String)localObject1), k + 139, 1L);
      ad.e("Gpu.GpuRegionReportTask", "GpuRegionReportTask end");
      AppMethodBeat.o(219539);
      return;
      ad.i("Gpu.GpuRegionReportTask", "gl size = " + i + "/kb");
      break;
      label620:
      ad.i("Gpu.GpuRegionReportTask", "egl size = " + j + "/kb");
      break label420;
      label649:
      ad.i("Gpu.GpuRegionReportTask", "gfx size = " + k + "/kb");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.e.a
 * JD-Core Version:    0.7.0.1
 */