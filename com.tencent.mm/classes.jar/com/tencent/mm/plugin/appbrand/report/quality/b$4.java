package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gln;
import com.tencent.mm.sdk.platformtools.Log;

final class b$4
  implements Runnable
{
  b$4(String paramString, com.tencent.mm.plugin.appbrand.report.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(48187);
    QualitySessionRuntime localQualitySessionRuntime = b.afZ(this.qyB);
    if ((localQualitySessionRuntime != null) && (this.tRp != null))
    {
      if ((this.tRp.tMV != null) && (this.tRp.tMV.acgZ != 0))
      {
        Log.i("MicroMsg.AppBrandQualitySystem", "hy: need do sample, type: %d, sampleInterval: %d", new Object[] { Integer.valueOf(this.tRp.tMV.acgZ), Integer.valueOf(this.tRp.tMV.acha) });
        e.a locala = null;
        switch (this.tRp.tMV.acgZ)
        {
        default: 
          Log.e("MicroMsg.AppBrandQualitySystem", "hy: invalid type!!");
        }
        for (;;)
        {
          if (locala != null) {
            localQualitySessionRuntime.tSt.a(localQualitySessionRuntime, this.tRp.tMV.acha, locala, true);
          }
          AppMethodBeat.o(48187);
          return;
          locala = e.a.tRA;
          continue;
          locala = e.a.tRB;
        }
      }
    }
    else {
      Log.i("MicroMsg.AppBrandQualitySystem", "hy: not need do sample");
    }
    AppMethodBeat.o(48187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b.4
 * JD-Core Version:    0.7.0.1
 */