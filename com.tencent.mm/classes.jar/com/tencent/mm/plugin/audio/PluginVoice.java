package com.tencent.mm.plugin.audio;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.audio.a.a;

public class PluginVoice
  extends f
  implements a
{
  public void execute(g paramg)
  {
    if (paramg.Ex()) {
      pin(new p(m.class));
    }
  }
  
  public String name()
  {
    return "plugin-voice";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.PluginVoice
 * JD-Core Version:    0.7.0.1
 */