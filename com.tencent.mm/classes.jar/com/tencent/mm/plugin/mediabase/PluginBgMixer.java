package com.tencent.mm.plugin.mediabase;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.recordvideo.background.b.a;
import com.tencent.mm.plugin.recordvideo.background.b.b;
import com.tencent.mm.plugin.recordvideo.background.b.d;
import com.tencent.mm.plugin.recordvideo.background.b.e;
import com.tencent.mm.plugin.vlog.remux.c;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/mediabase/PluginBgMixer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IPluginBgMixer;", "()V", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "Companion", "plugin-base_release"})
public final class PluginBgMixer
  extends f
  implements b
{
  public static final a uFt;
  
  static
  {
    AppMethodBeat.i(62523);
    uFt = new a((byte)0);
    AppMethodBeat.o(62523);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(62522);
    ac.i("MicroMsg.PluginBgMixer", "PluginBgMixer execute!");
    paramg = d.wox;
    d.a(0, (a)new e());
    paramg = d.wox;
    d.a(1, (a)new c());
    AppMethodBeat.o(62522);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/mediabase/PluginBgMixer$Companion;", "", "()V", "TAG", "", "plugin-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mediabase.PluginBgMixer
 * JD-Core Version:    0.7.0.1
 */