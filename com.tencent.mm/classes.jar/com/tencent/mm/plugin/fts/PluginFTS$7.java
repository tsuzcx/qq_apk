package com.tencent.mm.plugin.fts;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

final class PluginFTS$7
  implements f
{
  PluginFTS$7(PluginFTS paramPluginFTS) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    g.DQ();
    if (bk.g((Integer)g.DP().Dz().get(15, null)) != 0)
    {
      g.Dk().b(138, PluginFTS.access$1400(this.kuy));
      PluginFTS.access$1502(this.kuy, true);
      y.i("MicroMsg.FTS.PluginFTS", "*** User has finished initializing.");
      PluginFTS.access$1200(this.kuy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.7
 * JD-Core Version:    0.7.0.1
 */