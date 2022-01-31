package com.tencent.mm.plugin.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.c;

public class PluginFace
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.facedetect.a.a
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(51);
    ab.i("MicroMsg.PluginFace", "hy: starting execute.");
    if (paramg.SD()) {
      com.tencent.mm.vending.g.f.dQr().d(new a()).a(new PluginFace.1(this));
    }
    AppMethodBeat.o(51);
  }
  
  public String name()
  {
    return "plugin-facedetect";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.PluginFace
 * JD-Core Version:    0.7.0.1
 */