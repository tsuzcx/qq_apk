package com.tencent.mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.fingerprint.a.a;

public class PluginFingerprint
  extends f
  implements a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(3228);
    paramg.SD();
    AppMethodBeat.o(3228);
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(3229);
    paramg.SD();
    AppMethodBeat.o(3229);
  }
  
  public void installed()
  {
    AppMethodBeat.i(3227);
    alias(PluginFingerprint.class);
    AppMethodBeat.o(3227);
  }
  
  public String name()
  {
    return "plugin-fingerprint";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.PluginFingerprint
 * JD-Core Version:    0.7.0.1
 */