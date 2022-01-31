package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class y$a$1
  implements Runnable
{
  y$a$1(y.a parama, boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(123822);
    if (this.jnM) {
      this.jnQ.jnJ.z(this.jnN);
    }
    for (;;)
    {
      try
      {
        this.jnQ.jnJ.setSelection(Math.min(this.jnO + this.jnP, this.jnN.length()));
        AppMethodBeat.o(123822);
        return;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", new Object[] { localException });
        AppMethodBeat.o(123822);
      }
      this.jnQ.jnJ.setText(this.jnN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.y.a.1
 * JD-Core Version:    0.7.0.1
 */