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
    AppMethodBeat.i(148768);
    paramg.aBb();
    AppMethodBeat.o(148768);
  }
  
  public void dependency() {}
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(148769);
    paramg.aBb();
    AppMethodBeat.o(148769);
  }
  
  public void installed()
  {
    AppMethodBeat.i(148767);
    alias(PluginFingerprint.class);
    AppMethodBeat.o(148767);
  }
  
  public String name()
  {
    return "plugin-fingerprint";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.PluginFingerprint
 * JD-Core Version:    0.7.0.1
 */