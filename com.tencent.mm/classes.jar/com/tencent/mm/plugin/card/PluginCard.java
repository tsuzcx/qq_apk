package com.tencent.mm.plugin.card;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.vfs.af;

public class PluginCard
  extends f
  implements com.tencent.mm.plugin.card.a.a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(293731);
    af.b("card", "card", 50331648L, 7776000000L, 5);
    AppMethodBeat.o(293731);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(112561);
    dependsOn(com.tencent.mm.plugin.comm.a.b.class);
    dependsOn(com.tencent.mm.plugin.card.compat.a.b.class);
    AppMethodBeat.o(112561);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(112560);
    if (paramg.bbA()) {
      h.a(com.tencent.mm.plugin.card.b.b.class, new e(new com.tencent.mm.plugin.card.b.a()));
    }
    AppMethodBeat.o(112560);
  }
  
  public am getCore()
  {
    AppMethodBeat.i(112559);
    am localam = (am)y.aL(am.class);
    AppMethodBeat.o(112559);
    return localam;
  }
  
  public void installed()
  {
    AppMethodBeat.i(112558);
    super.installed();
    alias(com.tencent.mm.plugin.card.a.a.class);
    AppMethodBeat.o(112558);
  }
  
  public String name()
  {
    return "plugin-card";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.PluginCard
 * JD-Core Version:    0.7.0.1
 */