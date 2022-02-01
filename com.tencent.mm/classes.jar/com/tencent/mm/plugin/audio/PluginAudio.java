package com.tencent.mm.plugin.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/PluginAudio;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/audio/api/IPluginAudio;", "()V", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "name", "", "Companion", "plugin-audio_release"})
public final class PluginAudio
  extends f
  implements com.tencent.mm.plugin.audio.a.a
{
  public static final a oHB;
  
  static
  {
    AppMethodBeat.i(223933);
    oHB = new a((byte)0);
    AppMethodBeat.o(223933);
  }
  
  public final void configure(g paramg)
  {
    AppMethodBeat.i(223932);
    if ((paramg != null) && (paramg.aBb()))
    {
      Log.i("MicroMsg.PluginAudio", "PluginAudio configure");
      pin((c)new y(com.tencent.mm.plugin.audio.c.a.class));
    }
    AppMethodBeat.o(223932);
  }
  
  public final void execute(g paramg) {}
  
  public final String name()
  {
    return "plugin-audio";
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/PluginAudio$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.PluginAudio
 * JD-Core Version:    0.7.0.1
 */