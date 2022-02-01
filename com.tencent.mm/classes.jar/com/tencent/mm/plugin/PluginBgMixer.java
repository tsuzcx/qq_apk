package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.recordvideo.background.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/PluginBgMixer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IPluginBgMixer;", "()V", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginBgMixer
  extends f
  implements b
{
  public static final PluginBgMixer.a pFm;
  
  static
  {
    AppMethodBeat.i(260273);
    pFm = new PluginBgMixer.a((byte)0);
    AppMethodBeat.o(260273);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(260278);
    Log.i("MicroMsg.PluginBgMixer", "PluginBgMixer execute!");
    paramg = com.tencent.mm.plugin.recordvideo.background.c.d.NFT;
    com.tencent.mm.plugin.recordvideo.background.c.d.a(0, (com.tencent.mm.plugin.recordvideo.background.c.a)new com.tencent.mm.plugin.recordvideo.background.c.e());
    paramg = com.tencent.mm.plugin.recordvideo.background.c.d.NFT;
    com.tencent.mm.plugin.recordvideo.background.c.d.a(1, (com.tencent.mm.plugin.recordvideo.background.c.a)new com.tencent.mm.plugin.vlog.remux.d());
    paramg = com.tencent.mm.modelvideo.d.oYe;
    com.tencent.mm.modelvideo.d.a((com.tencent.mm.modelvideo.e)com.tencent.mm.plugin.vlog.api.a.TXf);
    AppMethodBeat.o(260278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.PluginBgMixer
 * JD-Core Version:    0.7.0.1
 */