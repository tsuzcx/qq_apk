package com.tencent.mm.plugin.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.expansions.e;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.c;

public class PluginFace
  extends f
  implements a
{
  public static boolean isEnabled()
  {
    AppMethodBeat.i(103572);
    boolean bool = e.isInstalled();
    AppMethodBeat.o(103572);
    return bool;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(103571);
    Log.i("MicroMsg.PluginFace", "hy: starting execute.");
    if (paramg.bbA()) {
      com.tencent.mm.vending.g.g.jJU().d(new b()).a(new PluginFace.1(this));
    }
    AppMethodBeat.o(103571);
  }
  
  public String name()
  {
    return "plugin-facedetect";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.PluginFace
 * JD-Core Version:    0.7.0.1
 */