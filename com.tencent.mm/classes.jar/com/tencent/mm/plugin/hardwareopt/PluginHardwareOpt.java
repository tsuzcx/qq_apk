package com.tencent.mm.plugin.hardwareopt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.hardwareopt.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginHardwareOpt
  extends f
  implements c, b
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(55548);
    if (!paramg.aBb())
    {
      AppMethodBeat.o(55548);
      return;
    }
    Log.v("MicroMsg.PluginHardwareOpt", "hy: on config");
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.hardwareopt.a.a.a.class, new com.tencent.mm.plugin.hardwareopt.a.a());
    AppMethodBeat.o(55548);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(55547);
    dependsOn(s.class);
    AppMethodBeat.o(55547);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(55549);
    if (paramg.aBb()) {
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
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(55550);
    Log.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountInitialized");
    ((com.tencent.mm.plugin.hardwareopt.a.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.hardwareopt.a.a.a.class)).qe(false);
    AppMethodBeat.o(55550);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(55551);
    Log.v("MicroMsg.PluginHardwareOpt", "hy: on onAccountRelease");
    AppMethodBeat.o(55551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.PluginHardwareOpt
 * JD-Core Version:    0.7.0.1
 */