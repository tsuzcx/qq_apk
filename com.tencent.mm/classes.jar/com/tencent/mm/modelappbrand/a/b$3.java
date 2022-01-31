package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.al;

public final class b$3
  implements b.i
{
  public b$3(b paramb, String paramString, b.h paramh) {}
  
  public final void acG() {}
  
  public final void acH()
  {
    AppMethodBeat.i(77319);
    if (this.fqx != null) {
      this.fqx.P(null);
    }
    AppMethodBeat.o(77319);
  }
  
  public final String tX()
  {
    return "BytesLoadTarget";
  }
  
  public final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77318);
    m.aNS().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(77317);
        byte[] arrayOfByte = b.a(b.3.this.fqv, b.3.this.val$url);
        if (b.3.this.fqx != null) {
          b.3.this.fqx.P(arrayOfByte);
        }
        AppMethodBeat.o(77317);
      }
    });
    AppMethodBeat.o(77318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.3
 * JD-Core Version:    0.7.0.1
 */