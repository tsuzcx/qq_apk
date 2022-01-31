package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends c
  implements b.a
{
  private a hJC;
  
  public d()
  {
    AppMethodBeat.i(130980);
    this.hJC = new a(this, "barcode|qrcode");
    AppMethodBeat.o(130980);
  }
  
  protected final b aCQ()
  {
    return this.hJC;
  }
  
  public final void c(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130981);
    this.hJB.b(paramInt, paramString, paramArrayOfByte);
    AppMethodBeat.o(130981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.a.d
 * JD-Core Version:    0.7.0.1
 */