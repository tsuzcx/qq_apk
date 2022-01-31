package com.tencent.mm.plugin.appbrand.media.record.record_imp;

import com.tencent.mm.f.b.c.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements c.a
{
  a$1(a parama) {}
  
  public final void aU(int paramInt1, int paramInt2)
  {
    y.e("MicroMsg.Record.AppBrandRecorder", "state:%d, detailState:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.gOF.gOD != null) {
      this.gOF.gOD.aU(paramInt1, paramInt2);
    }
  }
  
  public final void r(byte[] paramArrayOfByte, int paramInt)
  {
    y.i("MicroMsg.Record.AppBrandRecorder", "onRecPcmDataReady()");
    if (this.gOF.gOD != null) {
      this.gOF.gOD.r(paramArrayOfByte, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.record.record_imp.a.1
 * JD-Core Version:    0.7.0.1
 */