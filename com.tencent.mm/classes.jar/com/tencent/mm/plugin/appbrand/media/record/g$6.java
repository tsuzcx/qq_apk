package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.appbrand.media.record.a.d;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.RecordParam;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a;
import com.tencent.mm.plugin.appbrand.media.record.record_imp.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class g$6
  implements a.a
{
  g$6(g paramg) {}
  
  public final void bS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141595);
    ab.i("MicroMsg.Record.AudioRecordMgr", "onRecError state:%d, detailState:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.ipI.onError(1);
    AppMethodBeat.o(141595);
  }
  
  public final void s(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(141594);
    if ((g.a(this.ipI) != null) && (g.b(this.ipI) != null))
    {
      g localg = this.ipI;
      int j = g.c(this.ipI);
      a locala = g.b(this.ipI);
      if (locala.ciR != null) {}
      for (int i = locala.ciR.cjn;; i = 20)
      {
        g.a(localg, i + j);
        try
        {
          if (!g.a(this.ipI).a(g.d(this.ipI), paramArrayOfByte, paramInt)) {
            ab.e("MicroMsg.Record.AudioRecordMgr", "encode pcm fail!");
          }
          AppMethodBeat.o(141594);
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          ab.printErrStackTrace("MicroMsg.Record.AudioRecordMgr", paramArrayOfByte, "onRecPcmDataReady", new Object[0]);
          if ((g.e(this.ipI) == null) || (!"mp3".equalsIgnoreCase(g.e(this.ipI).hCu))) {
            break;
          }
          j.oS(19);
          AppMethodBeat.o(141594);
          return;
          if ((g.e(this.ipI) == null) || (!"aac".equalsIgnoreCase(g.e(this.ipI).hCu))) {
            break label204;
          }
          j.oS(23);
        }
      }
    }
    label204:
    AppMethodBeat.o(141594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.g.6
 * JD-Core Version:    0.7.0.1
 */