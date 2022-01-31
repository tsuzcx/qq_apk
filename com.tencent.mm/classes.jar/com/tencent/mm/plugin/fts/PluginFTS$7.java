package com.tencent.mm.plugin.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

final class PluginFTS$7
  implements f
{
  PluginFTS$7(PluginFTS paramPluginFTS) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(136588);
    g.RM();
    if (bo.g((Integer)g.RL().Ru().get(15, null)) != 0)
    {
      g.Rc().b(138, PluginFTS.access$1400(this.mQm));
      PluginFTS.access$1502(this.mQm, true);
      ab.i("MicroMsg.FTS.PluginFTS", "*** User has finished initializing.");
      PluginFTS.access$1200(this.mQm);
    }
    AppMethodBeat.o(136588);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.PluginFTS.7
 * JD-Core Version:    0.7.0.1
 */