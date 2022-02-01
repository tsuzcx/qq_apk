package com.tencent.mm.plugin.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.g.d.a;

public class PluginFace
  extends f
  implements com.tencent.mm.plugin.facedetect.a.a
{
  public static boolean isEnabled()
  {
    AppMethodBeat.i(103572);
    boolean bool = com.tencent.mm.plugin.expansions.a.cbc();
    AppMethodBeat.o(103572);
    return bool;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(103571);
    ad.i("MicroMsg.PluginFace", "hy: starting execute.");
    if (paramg.agu()) {
      com.tencent.mm.vending.g.g.fhq().d(new a()).a(new d.a() {});
    }
    AppMethodBeat.o(103571);
  }
  
  public String name()
  {
    return "plugin-facedetect";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.PluginFace
 * JD-Core Version:    0.7.0.1
 */