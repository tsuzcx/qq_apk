package com.tencent.mm.plugin.misc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.misc.b.b;

public class PluginMisc
  extends f
  implements a
{
  public void dependency()
  {
    AppMethodBeat.i(50502);
    dependsOn(p.class);
    AppMethodBeat.o(50502);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(50503);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.misc.a.a.class, new b());
    pin(com.tencent.mm.plugin.misc.b.a.bQk());
    AppMethodBeat.o(50503);
  }
  
  public void installed()
  {
    AppMethodBeat.i(50501);
    alias(a.class);
    AppMethodBeat.o(50501);
  }
  
  public String toString()
  {
    return "plugin-misc";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.PluginMisc
 * JD-Core Version:    0.7.0.1
 */