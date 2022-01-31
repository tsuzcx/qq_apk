package com.tencent.mm.plugin.kitchen;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.p;

public class PluginKitchen
  extends f
  implements a
{
  public void dependency()
  {
    dependsOn(p.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.kitchen.a.a.class, new com.tencent.mm.plugin.kitchen.b.a());
  }
  
  public void installed()
  {
    alias(a.class);
  }
  
  public String toString()
  {
    return "plugin-kitchen";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.PluginKitchen
 * JD-Core Version:    0.7.0.1
 */