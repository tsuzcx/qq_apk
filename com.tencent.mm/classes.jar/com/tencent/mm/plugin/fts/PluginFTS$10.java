package com.tencent.mm.plugin.fts;

import com.tencent.mm.h.a.sn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;

final class PluginFTS$10
  extends com.tencent.mm.plugin.fts.a.a.a
{
  boolean ahI = false;
  String kuB = x.fB(ae.getContext());
  
  PluginFTS$10(PluginFTS paramPluginFTS) {}
  
  public final String afJ()
  {
    return String.format("{changed: %b}", new Object[] { Boolean.valueOf(this.ahI) });
  }
  
  public final boolean execute()
  {
    if ((int)((n)g.t(n.class)).getFTSIndexDB().z(-3L, 0L) != this.kuB.hashCode()) {}
    for (boolean bool = true;; bool = false)
    {
      this.ahI = bool;
      if (this.ahI) {
        com.tencent.mm.sdk.b.a.udP.m(new sn());
      }
      return true;
    }
  }
  
  public final String getName()
  {
    return "CheckLanguageUpdate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.10
 * JD-Core Version:    0.7.0.1
 */