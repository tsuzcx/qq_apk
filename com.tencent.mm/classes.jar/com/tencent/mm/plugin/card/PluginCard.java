package com.tencent.mm.plugin.card;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.card.model.am;

public class PluginCard
  extends f
  implements com.tencent.mm.plugin.card.a.a
{
  public void dependency()
  {
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    dependsOn(com.tencent.mm.plugin.card.compat.a.b.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex())
    {
      com.tencent.mm.kernel.g.a(PluginCard.a.class, new e(new PluginCard.a()));
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.card.c.b.class, new e(new com.tencent.mm.plugin.card.c.a()));
    }
  }
  
  public am getCore()
  {
    return (am)p.B(am.class);
  }
  
  public void installed()
  {
    super.installed();
    alias(com.tencent.mm.plugin.card.a.a.class);
  }
  
  public String name()
  {
    return "plugin-card";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.PluginCard
 * JD-Core Version:    0.7.0.1
 */