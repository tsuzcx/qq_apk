package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.a.e;
import com.tencent.mm.ao.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac.a;
import com.tencent.mm.pointers.PInt;

final class PluginBigBallOfMud$37
  implements ac.a
{
  PluginBigBallOfMud$37(PluginBigBallOfMud paramPluginBigBallOfMud) {}
  
  public final boolean a(String paramString1, String paramString2, PInt paramPInt)
  {
    AppMethodBeat.i(22410);
    if (ab.Qm(paramString1))
    {
      if (g.KI(paramString1)) {
        if (e.Vc(paramString2)) {
          paramPInt.value = 5;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(22410);
        return true;
        paramPInt.value = 4;
        continue;
        if (g.UB(paramString1)) {
          paramPInt.value = 3;
        } else if (g.UC(paramString1)) {
          paramPInt.value = 0;
        } else if (g.Ux(paramString1)) {
          paramPInt.value = 6;
        } else {
          paramPInt.value = 7;
        }
      }
    }
    AppMethodBeat.o(22410);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud.37
 * JD-Core Version:    0.7.0.1
 */