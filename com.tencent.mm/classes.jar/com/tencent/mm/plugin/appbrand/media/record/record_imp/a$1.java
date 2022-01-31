package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements c.a
{
  a$1(a parama) {}
  
  public final void bS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105657);
    ab.e("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.iqr.iqp != null) {
      this.iqr.iqp.bS(paramInt1, paramInt2);
    }
    AppMethodBeat.o(105657);
  }
  
  public final void s(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(105656);
    ab.i("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
    if (this.iqr.iqp != null) {
      this.iqr.iqp.s(paramArrayOfByte, paramInt);
    }
    AppMethodBeat.o(105656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.a.1
 * JD-Core Version:    0.7.0.1
 */