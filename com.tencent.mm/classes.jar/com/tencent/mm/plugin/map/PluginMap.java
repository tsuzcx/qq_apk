package com.tencent.mm.plugin.map;

import com.tencent.mm.br.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.map.a.a;

public class PluginMap
  extends f
  implements a
{
  public void configure(g paramg)
  {
    if (paramg.Ex()) {
      pin(new p(l.class));
    }
  }
  
  public void execute(g paramg)
  {
    if (paramg.Ex()) {
      c.Xg("location");
    }
  }
  
  public void installed()
  {
    alias(a.class);
  }
  
  public String name()
  {
    return "plugin-map";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.map.PluginMap
 * JD-Core Version:    0.7.0.1
 */