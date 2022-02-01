package com.tencent.mm.plugin.map;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.map.a.a;

public class PluginMap
  extends f
  implements a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(56242);
    if (paramg.akw()) {
      pin(new t(n.class));
    }
    AppMethodBeat.o(56242);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(56243);
    if (paramg.akw()) {
      c.aNQ("location");
    }
    AppMethodBeat.o(56243);
  }
  
  public void installed()
  {
    AppMethodBeat.i(56241);
    alias(a.class);
    AppMethodBeat.o(56241);
  }
  
  public String name()
  {
    return "plugin-map";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.map.PluginMap
 * JD-Core Version:    0.7.0.1
 */