package com.tencent.mm.gpu.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  implements Runnable
{
  private static d rZ(int paramInt)
  {
    AppMethodBeat.i(210746);
    d locald = new d(61166);
    int j = 0;
    int i = paramInt;
    int k = 0;
    while (j < 5)
    {
      locald.M(j, k, i);
      k += paramInt;
      j += 1;
      i += paramInt;
    }
    AppMethodBeat.o(210746);
    return locald;
  }
  
  public final void run()
  {
    AppMethodBeat.i(210744);
    Log.e("MicroMsg.GpuRegionReportTask", "GpuRegionReportTask start");
    Object localObject1 = MMApplicationContext.getProcessName();
    int[] arrayOfInt = new int[3];
    if (com.tencent.mm.gpu.b.a.jUS.equals(localObject1))
    {
      arrayOfInt[0] = 30;
      arrayOfInt[1] = 30;
      arrayOfInt[2] = 50;
      localObject1 = new d[3];
      localObject1[0] = rZ(arrayOfInt[0]);
      localObject1[1] = rZ(arrayOfInt[1]);
      localObject1[2] = rZ(arrayOfInt[2]);
      Log.i("MicroMsg.GpuRegionReportTask", "gfx region : " + localObject1[0].toString());
      Log.i("MicroMsg.GpuRegionReportTask", "egl region : " + localObject1[1].toString());
      Log.i("MicroMsg.GpuRegionReportTask", " gl region : " + localObject1[2].toString());
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label291;
      }
      Log.e("MicroMsg.GpuRegionReportTask", "regions == null, GpuRegionReportTask end");
      AppMethodBeat.o(210744);
      return;
      if (((String)localObject1).startsWith(com.tencent.mm.gpu.b.a.jUT))
      {
        arrayOfInt[0] = 30;
        arrayOfInt[1] = 20;
        arrayOfInt[2] = 50;
        break;
      }
      if (com.tencent.mm.gpu.b.a.jUU.equals(localObject1))
      {
        arrayOfInt[0] = 30;
        arrayOfInt[1] = 30;
        arrayOfInt[2] = 50;
        break;
      }
      if (com.tencent.mm.gpu.b.a.jUV.equals(localObject1))
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
    com.tencent.mm.gpu.g.a locala = new com.tencent.mm.gpu.g.a();
    int i = locala.aER();
    int j = locala.aEQ();
    int k = locala.aEP();
    if (arrayOfInt.unit == 61166)
    {
      i /= 1024;
      Log.i("MicroMsg.GpuRegionReportTask", "gl size = " + i + "/mb");
      if (localObject2.unit != 61166) {
        break label620;
      }
      j /= 1024;
      Log.i("MicroMsg.GpuRegionReportTask", "egl size = " + j + "/mb");
      label420:
      if (((d)localObject1).unit != 61166) {
        break label649;
      }
      k /= 1024;
      Log.i("MicroMsg.GpuRegionReportTask", "gfx size = " + k + "/mb");
    }
    for (;;)
    {
      i = arrayOfInt.sa(i);
      j = localObject2.sa(j);
      k = ((d)localObject1).sa(k);
      Log.e("MicroMsg.GpuRegionReportTask", "indexGL = ".concat(String.valueOf(i)));
      Log.e("MicroMsg.GpuRegionReportTask", "indexEGL = ".concat(String.valueOf(j)));
      Log.e("MicroMsg.GpuRegionReportTask", "indexGfx = ".concat(String.valueOf(k)));
      localObject1 = MMApplicationContext.getProcessName();
      c.f(c.Me((String)localObject1), j + 150, 1L);
      c.f(c.Me((String)localObject1), i + 161, 1L);
      c.f(c.Me((String)localObject1), k + 139, 1L);
      Log.e("MicroMsg.GpuRegionReportTask", "GpuRegionReportTask end");
      AppMethodBeat.o(210744);
      return;
      Log.i("MicroMsg.GpuRegionReportTask", "gl size = " + i + "/kb");
      break;
      label620:
      Log.i("MicroMsg.GpuRegionReportTask", "egl size = " + j + "/kb");
      break label420;
      label649:
      Log.i("MicroMsg.GpuRegionReportTask", "gfx size = " + k + "/kb");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.gpu.f.a
 * JD-Core Version:    0.7.0.1
 */