package com.tencent.mm.plugin.hardwareopt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hardwareopt.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.e;

public final class a
  implements com.tencent.mm.plugin.hardwareopt.a.a.a
{
  public final void wK(boolean paramBoolean)
  {
    AppMethodBeat.i(55554);
    new e().L(new Object[] { MMApplicationContext.getContext() }).e(new com.tencent.mm.plugin.hardwareopt.c.a()).d(new b(paramBoolean)).a(new d.a()
    {
      public final void onInterrupt(Object paramAnonymousObject)
      {
        AppMethodBeat.i(55553);
        Log.w("MicroMsg.HardwareProvider", "hy: on interrupt.");
        AppMethodBeat.o(55553);
      }
    }).a(new d.b() {});
    AppMethodBeat.o(55554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.a.a
 * JD-Core Version:    0.7.0.1
 */