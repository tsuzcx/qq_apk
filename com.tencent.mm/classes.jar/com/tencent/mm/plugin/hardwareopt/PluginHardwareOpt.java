package com.tencent.mm.plugin.hardwareopt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.hardwareopt.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginHardwareOpt
  extends f
  implements c, b
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(55548);
    if (!paramg.aIE())
    {
      AppMethodBeat.o(55548);
      return;
    }
    Log.v("MicroMsg.PluginHardwareOpt", "hy: on config");
    h.b(com.tencent.mm.plugin.hardwareopt.a.a.a.class, new com.tencent.mm.plugin.hardwareopt.a.a());
    AppMethodBeat.o(55548);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(55547);
    dependsOn(v.class);
    AppMethodBeat.o(55547);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(55549);
    if (paramg.aIE()) {
      Log.i("MicroMsg.PluginHardwareOpt", "hy: on execute. ");
    }
    AppMethodBeat.o(55549);
  }
  
  public void installed()
  {
    AppMethodBeat.i(55546);
    alias(b.class);
    AppMethodBeat.o(55546);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(55550);
    Log.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountInitialized");
    ((com.tencent.mm.plugin.hardwareopt.a.a.a)h.ae(com.tencent.mm.plugin.hardwareopt.a.a.a.class)).sE(false);
    AppMethodBeat.o(55550);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(55551);
    Log.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountRelease");
    AppMethodBeat.o(55551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt
 * JD-Core Version:    0.7.0.1
 */