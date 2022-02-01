package com.tencent.mm.plugin.mediabase;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.recordvideo.background.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mediabase/PluginBgMixer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IPluginBgMixer;", "()V", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "Companion", "plugin-base_release"})
public final class PluginBgMixer
  extends f
  implements b
{
  public static final a ETU;
  
  static
  {
    AppMethodBeat.i(62523);
    ETU = new a((byte)0);
    AppMethodBeat.o(62523);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(62522);
    Log.i("MicroMsg.PluginBgMixer", "PluginBgMixer execute!");
    paramg = com.tencent.mm.plugin.recordvideo.background.c.d.HIC;
    com.tencent.mm.plugin.recordvideo.background.c.d.a(0, (com.tencent.mm.plugin.recordvideo.background.c.a)new com.tencent.mm.plugin.recordvideo.background.c.e());
    paramg = com.tencent.mm.plugin.recordvideo.background.c.d.HIC;
    com.tencent.mm.plugin.recordvideo.background.c.d.a(1, (com.tencent.mm.plugin.recordvideo.background.c.a)new com.tencent.mm.plugin.vlog.remux.d());
    paramg = com.tencent.mm.modelvideo.d.mfm;
    com.tencent.mm.modelvideo.d.a((com.tencent.mm.modelvideo.e)com.tencent.mm.plugin.vlog.api.a.Nkq);
    AppMethodBeat.o(62522);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mediabase/PluginBgMixer$Companion;", "", "()V", "TAG", "", "plugin-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mediabase.PluginBgMixer
 * JD-Core Version:    0.7.0.1
 */