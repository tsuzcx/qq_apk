package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.am.a;

final class a$7
  implements am.a
{
  private int kyu = 0;
  
  a$7(a parama) {}
  
  public final boolean tC()
  {
    PluginFTS localPluginFTS = (PluginFTS)g.t(PluginFTS.class);
    if ((localPluginFTS.isCharging()) || (!localPluginFTS.isInBackground())) {}
    for (int i = 1; i == 0; i = 0)
    {
      i = this.kyu + 1;
      this.kyu = i;
      if (i >= 6) {
        break;
      }
      return true;
    }
    a.e(this.kyt).a(131093, new a.u(this.kyt, (byte)0));
    this.kyu = 0;
    return true;
  }
  
  public final String toString()
  {
    return super.toString() + "|delayIndexTimer";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.7
 * JD-Core Version:    0.7.0.1
 */