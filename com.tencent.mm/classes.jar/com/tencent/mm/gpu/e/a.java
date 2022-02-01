package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
  implements Runnable
{
  private static d mn(int paramInt)
  {
    AppMethodBeat.i(209662);
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
    AppMethodBeat.o(209662);
    return locald;
  }
  
  public final void run()
  {
    AppMethodBeat.i(209661);
    ae.e("Gpu.GpuRegionReportTask", "GpuRegionReportTask start");
    Object localObject1 = ak.getProcessName();
    int[] arrayOfInt = new int[3];
    if (com.tencent.mm.gpu.b.a.gwk.equals(localObject1))
    {
      arrayOfInt[0] = 30;
      arrayOfInt[1] = 30;
      arrayOfInt[2] = 50;
      localObject1 = new d[3];
      localObject1[0] = mn(arrayOfInt[0]);
      localObject1[1] = mn(arrayOfInt[1]);
      localObject1[2] = mn(arrayOfInt[2]);
      ae.i("Gpu.GpuRegionReportTask", "gfx region : " + localObject1[0].toString());
      ae.i("Gpu.GpuRegionReportTask", "egl region : " + localObject1[1].toString());
      ae.i("Gpu.GpuRegionReportTask", " gl region : " + localObject1[2].toString());
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label291;
      }
      ae.e("Gpu.GpuRegionReportTask", "regions == null, GpuRegionReportTask end");
      AppMethodBeat.o(209661);
      return;
      if (((String)localObject1).startsWith(com.tencent.mm.gpu.b.a.gwl))
      {
        arrayOfInt[0] = 30;
        arrayOfInt[1] = 20;
        arrayOfInt[2] = 50;
        break;
      }
      if (com.tencent.mm.gpu.b.a.gwm.equals(localObject1))
      {
        arrayOfInt[0] = 30;
        arrayOfInt[1] = 30;
        arrayOfInt[2] = 50;
        break;
      }
      if (com.tencent.mm.gpu.b.a.gwn.equals(localObject1))
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
    int i = locala.ahk();
    int j = locala.ahj();
    int k = locala.ahi();
    if (arrayOfInt.unit == 61166)
    {
      i /= 1024;
      ae.i("Gpu.GpuRegionReportTask", "gl size = " + i + "/mb");
      if (localObject2.unit != 61166) {
        break label620;
      }
      j /= 1024;
      ae.i("Gpu.GpuRegionReportTask", "egl size = " + j + "/mb");
      label420:
      if (((d)localObject1).unit != 61166) {
        break label649;
      }
      k /= 1024;
      ae.i("Gpu.GpuRegionReportTask", "gfx size = " + k + "/mb");
    }
    for (;;)
    {
      i = arrayOfInt.mo(i);
      j = localObject2.mo(j);
      k = ((d)localObject1).mo(k);
      ae.e("Gpu.GpuRegionReportTask", "indexGL = ".concat(String.valueOf(i)));
      ae.e("Gpu.GpuRegionReportTask", "indexEGL = ".concat(String.valueOf(j)));
      ae.e("Gpu.GpuRegionReportTask", "indexGfx = ".concat(String.valueOf(k)));
      localObject1 = ak.getProcessName();
      c.e(c.wU((String)localObject1), j + 150, 1L);
      c.e(c.wU((String)localObject1), i + 161, 1L);
      c.e(c.wU((String)localObject1), k + 139, 1L);
      ae.e("Gpu.GpuRegionReportTask", "GpuRegionReportTask end");
      AppMethodBeat.o(209661);
      return;
      ae.i("Gpu.GpuRegionReportTask", "gl size = " + i + "/kb");
      break;
      label620:
      ae.i("Gpu.GpuRegionReportTask", "egl size = " + j + "/kb");
      break label420;
      label649:
      ae.i("Gpu.GpuRegionReportTask", "gfx size = " + k + "/kb");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.e.a
 * JD-Core Version:    0.7.0.1
 */