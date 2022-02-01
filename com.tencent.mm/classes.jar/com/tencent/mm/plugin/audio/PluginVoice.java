package com.tencent.mm.plugin.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.plugin.audio.a.b;
import com.tencent.mm.vfs.ab;

public class PluginVoice
  extends f
  implements b
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(177451);
    if (paramg.aIE())
    {
      ab.aE("voice", "voice", 17);
      ab.aE("voice2", "voice2", 17);
    }
    AppMethodBeat.o(177451);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(148651);
    if (paramg.aIE()) {
      pin(new y(o.class));
    }
    AppMethodBeat.o(148651);
  }
  
  public String name()
  {
    return "plugin-voice";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.PluginVoice
 * JD-Core Version:    0.7.0.1
 */