package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.QbarNative.QBarPoint;

public final class d
  extends c
  implements b.a
{
  private a kIL;
  
  public d()
  {
    AppMethodBeat.i(46236);
    this.kIL = new a(this, "barcode|qrcode");
    AppMethodBeat.o(46236);
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, byte[] paramArrayOfByte, QbarNative.QBarPoint paramQBarPoint)
  {
    AppMethodBeat.i(188303);
    this.kIK.a(paramInt1, paramInt2, paramString, paramArrayOfByte, paramQBarPoint);
    AppMethodBeat.o(188303);
  }
  
  protected final b bjW()
  {
    return this.kIL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a.d
 * JD-Core Version:    0.7.0.1
 */