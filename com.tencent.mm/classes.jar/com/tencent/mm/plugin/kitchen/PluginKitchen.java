package com.tencent.mm.plugin.kitchen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.q;

public class PluginKitchen
  extends f
  implements a
{
  public void dependency()
  {
    AppMethodBeat.i(153022);
    dependsOn(q.class);
    AppMethodBeat.o(153022);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(153023);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.kitchen.a.a.class, new com.tencent.mm.plugin.kitchen.b.a());
    AppMethodBeat.o(153023);
  }
  
  public void installed()
  {
    AppMethodBeat.i(153021);
    alias(a.class);
    AppMethodBeat.o(153021);
  }
  
  public String toString()
  {
    return "plugin-kitchen";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.PluginKitchen
 * JD-Core Version:    0.7.0.1
 */