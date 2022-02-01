package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class b
  implements Runnable
{
  private static e lL(int paramInt)
  {
    AppMethodBeat.i(209431);
    e locale = new e();
    locale.I(9, paramInt * 3, 2147483647);
    locale.I(8, paramInt * 2, paramInt * 3);
    int k = paramInt * 2 / 8;
    int i = 0;
    paramInt = k;
    int j = 0;
    while (i < 8)
    {
      locale.I(i, j, paramInt);
      j += k;
      i += 1;
      paramInt += k;
    }
    AppMethodBeat.o(209431);
    return locale;
  }
  
  public final void run()
  {
    AppMethodBeat.i(209430);
    ac.e("Gpu.GpuOOMReportTask", "GpuOOMReportTask start");
    Object localObject1 = ai.getProcessName();
    int[] arrayOfInt = new int[3];
    if (com.tencent.mm.gpu.b.a.gae.equals(localObject1))
    {
      arrayOfInt[0] = 1500;
      arrayOfInt[1] = 400;
      arrayOfInt[2] = 35000;
      localObject1 = new e[3];
      localObject1[0] = lL(arrayOfInt[0]);
      localObject1[1] = lL(arrayOfInt[1]);
      localObject1[2] = lL(arrayOfInt[2]);
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label221;
      }
      ac.e("Gpu.GpuOOMReportTask", "regions == null, GpuOOMReportTask end");
      AppMethodBeat.o(209430);
      return;
      if (((String)localObject1).startsWith(com.tencent.mm.gpu.b.a.gaf))
      {
        arrayOfInt[0] = 900;
        arrayOfInt[1] = 300;
        arrayOfInt[2] = 4000;
        break;
      }
      if (com.tencent.mm.gpu.b.a.gag.equals(localObject1))
      {
        arrayOfInt[0] = 900;
        arrayOfInt[1] = 400;
        arrayOfInt[2] = 6000;
        break;
      }
      if (com.tencent.mm.gpu.b.a.gah.equals(localObject1))
      {
        arrayOfInt[0] = 900;
        arrayOfInt[1] = 300;
        arrayOfInt[2] = 4000;
        break;
      }
      localObject1 = null;
    }
    label221:
    arrayOfInt = localObject1[2];
    Object localObject2 = localObject1[1];
    localObject1 = localObject1[0];
    com.tencent.mm.gpu.f.a locala = new com.tencent.mm.gpu.f.a();
    int j = locala.aeo();
    int k = locala.aen();
    int i = locala.aem();
    j = arrayOfInt.lM(j);
    k = localObject2.lM(k);
    i = ((e)localObject1).lM(i);
    ac.e("Gpu.GpuOOMReportTask", "indexGL = ".concat(String.valueOf(j)));
    ac.e("Gpu.GpuOOMReportTask", "indexEGL = ".concat(String.valueOf(k)));
    ac.e("Gpu.GpuOOMReportTask", "indexGfx = ".concat(String.valueOf(i)));
    localObject1 = ai.getProcessName();
    d.e(d.tv((String)localObject1), k + 150, 1L);
    d.e(d.tv((String)localObject1), j + 161, 1L);
    d.e(d.tv((String)localObject1), i + 139, 1L);
    ac.e("Gpu.GpuOOMReportTask", "GpuOOMReportTask end");
    AppMethodBeat.o(209430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.e.b
 * JD-Core Version:    0.7.0.1
 */