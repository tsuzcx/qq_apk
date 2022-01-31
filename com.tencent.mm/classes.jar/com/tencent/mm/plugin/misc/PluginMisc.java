package com.tencent.mm.plugin.misc;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.misc.b.b;

public class PluginMisc
  extends f
  implements a
{
  public void dependency()
  {
    dependsOn(p.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.misc.a.a.class, new b());
    pin(com.tencent.mm.plugin.misc.b.a.bij());
  }
  
  public void installed()
  {
    alias(a.class);
  }
  
  public String toString()
  {
    return "plugin-misc";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.misc.PluginMisc
 * JD-Core Version:    0.7.0.1
 */