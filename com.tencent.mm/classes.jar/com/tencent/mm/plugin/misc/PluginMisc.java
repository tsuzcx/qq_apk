package com.tencent.mm.plugin.misc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.misc.b.b;

public class PluginMisc
  extends f
  implements a
{
  public void dependency()
  {
    AppMethodBeat.i(127603);
    dependsOn(s.class);
    AppMethodBeat.o(127603);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(127604);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.misc.a.a.class, new b());
    pin(com.tencent.mm.plugin.misc.b.a.eiW());
    AppMethodBeat.o(127604);
  }
  
  public void installed()
  {
    AppMethodBeat.i(127602);
    alias(a.class);
    AppMethodBeat.o(127602);
  }
  
  public String toString()
  {
    return "plugin-misc";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.PluginMisc
 * JD-Core Version:    0.7.0.1
 */