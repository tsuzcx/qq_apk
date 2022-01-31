package com.tencent.mm.plugin.fts;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class PluginFTS$3
  implements e
{
  PluginFTS$3(PluginFTS paramPluginFTS) {}
  
  public final void aVr()
  {
    com.tencent.mm.kernel.g.DQ();
    int i = ((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uxi, Integer.valueOf(3))).intValue();
    y.e("MicroMsg.FTS.PluginFTS", "DB onCorrupt dbCorruptRebuildTimes: %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uxi, Integer.valueOf(i - 1));
      PluginFTS.access$300(this.kuy);
      PluginFTS.access$400(this.kuy);
      PluginFTS.access$200(this.kuy).close();
      d.aVp();
      PluginFTS.access$500(this.kuy).a(-131072, new PluginFTS.b(this.kuy, (byte)0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.3
 * JD-Core Version:    0.7.0.1
 */