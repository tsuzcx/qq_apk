package com.tencent.mm.plugin.mediabase;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.recordvideo.background.b.a;
import com.tencent.mm.plugin.recordvideo.background.b.b;
import com.tencent.mm.plugin.recordvideo.background.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/mediabase/PluginBgMixer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IPluginBgMixer;", "()V", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "Companion", "plugin-base_release"})
public final class PluginBgMixer
  extends f
  implements b
{
  public static final a txb;
  
  static
  {
    AppMethodBeat.i(62523);
    txb = new a((byte)0);
    AppMethodBeat.o(62523);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(62522);
    ad.i("MicroMsg.PluginBgMixer", "PluginBgMixer execute!");
    paramg = com.tencent.mm.plugin.recordvideo.background.b.d.vfL;
    com.tencent.mm.plugin.recordvideo.background.b.d.a(0, (a)new e());
    paramg = com.tencent.mm.plugin.recordvideo.background.b.d.vfL;
    com.tencent.mm.plugin.recordvideo.background.b.d.a(1, (a)new com.tencent.mm.plugin.vlog.remux.d());
    AppMethodBeat.o(62522);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/mediabase/PluginBgMixer$Companion;", "", "()V", "TAG", "", "plugin-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mediabase.PluginBgMixer
 * JD-Core Version:    0.7.0.1
 */