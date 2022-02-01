package com.tencent.mm.plugin.appbrand.luggage;

import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.luggage.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
  extends com.tencent.luggage.bridge.impl.a
{
  private static e lmN;
  
  static
  {
    AppMethodBeat.i(47471);
    lmN = new c();
    AppMethodBeat.o(47471);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(47470);
    Log.i("MicroMsg.LuggageInitDelegateWxImpl", "onInitComponent %s", new Object[] { MMApplicationContext.getProcessName() });
    super.a(parama);
    AppMethodBeat.o(47470);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(47469);
    Log.i("MicroMsg.LuggageInitDelegateWxImpl", "onInitialize %s", new Object[] { MMApplicationContext.getProcessName() });
    super.a(paramc);
    paramc.a(e.class, lmN);
    AppMethodBeat.o(47469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.a
 * JD-Core Version:    0.7.0.1
 */