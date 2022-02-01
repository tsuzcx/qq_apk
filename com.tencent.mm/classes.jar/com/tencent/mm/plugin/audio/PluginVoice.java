package com.tencent.mm.plugin.audio;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dc;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.plugin.audio.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.vfs.af;

public class PluginVoice
  extends com.tencent.mm.kernel.b.f
  implements b
{
  IListener<dc> lsH;
  
  public PluginVoice()
  {
    AppMethodBeat.i(263708);
    this.lsH = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(263708);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(177451);
    if (paramg.bbA())
    {
      af.aR("voice", "voice", 17);
      af.aR("voice2", "voice2", 17);
    }
    if (paramg.bbA()) {
      this.lsH.alive();
    }
    AppMethodBeat.o(177451);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(148651);
    if (paramg.bbA()) {
      pin(new y(o.class));
    }
    AppMethodBeat.o(148651);
  }
  
  public String name()
  {
    return "plugin-voice";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.PluginVoice
 * JD-Core Version:    0.7.0.1
 */