package com.tencent.mm.plugin.card;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.card.model.am;

public class PluginCard
  extends f
  implements com.tencent.mm.plugin.card.a.a
{
  public void dependency()
  {
    AppMethodBeat.i(87616);
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    dependsOn(com.tencent.mm.plugin.card.compat.a.b.class);
    AppMethodBeat.o(87616);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(87615);
    if (paramg.SD()) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.card.c.b.class, new e(new com.tencent.mm.plugin.card.c.a()));
    }
    AppMethodBeat.o(87615);
  }
  
  public am getCore()
  {
    AppMethodBeat.i(87614);
    am localam = (am)q.S(am.class);
    AppMethodBeat.o(87614);
    return localam;
  }
  
  public void installed()
  {
    AppMethodBeat.i(87613);
    super.installed();
    alias(com.tencent.mm.plugin.card.a.a.class);
    AppMethodBeat.o(87613);
  }
  
  public String name()
  {
    return "plugin-card";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.PluginCard
 * JD-Core Version:    0.7.0.1
 */