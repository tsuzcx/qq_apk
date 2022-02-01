package com.tencent.mm.plugin.mediabase;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.recordvideo.background.c.a;
import com.tencent.mm.plugin.recordvideo.background.c.b;
import com.tencent.mm.plugin.recordvideo.background.c.d;
import com.tencent.mm.plugin.recordvideo.background.c.e;
import com.tencent.mm.plugin.vlog.remux.c;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/mediabase/PluginBgMixer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IPluginBgMixer;", "()V", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "Companion", "plugin-base_release"})
public final class PluginBgMixer
  extends f
  implements b
{
  public static final PluginBgMixer.a vIt;
  
  static
  {
    AppMethodBeat.i(62523);
    vIt = new PluginBgMixer.a((byte)0);
    AppMethodBeat.o(62523);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(62522);
    ad.i("MicroMsg.PluginBgMixer", "PluginBgMixer execute!");
    paramg = d.xwn;
    d.a(0, (a)new e());
    paramg = d.xwn;
    d.a(1, (a)new c());
    AppMethodBeat.o(62522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mediabase.PluginBgMixer
 * JD-Core Version:    0.7.0.1
 */