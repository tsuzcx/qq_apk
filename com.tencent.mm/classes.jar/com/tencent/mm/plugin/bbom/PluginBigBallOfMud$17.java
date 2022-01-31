package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u.a;
import com.tencent.mm.pointers.PInt;

final class PluginBigBallOfMud$17
  implements u.a
{
  PluginBigBallOfMud$17(PluginBigBallOfMud paramPluginBigBallOfMud) {}
  
  public final boolean a(String paramString1, String paramString2, PInt paramPInt)
  {
    AppMethodBeat.i(18297);
    if (t.nU(paramString1))
    {
      if (f.lg(paramString1)) {
        if (e.sn(paramString2)) {
          paramPInt.value = 5;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(18297);
        return true;
        paramPInt.value = 4;
        continue;
        if (f.rW(paramString1)) {
          paramPInt.value = 3;
        } else if (f.rX(paramString1)) {
          paramPInt.value = 0;
        } else if (f.rT(paramString1)) {
          paramPInt.value = 6;
        } else {
          paramPInt.value = 7;
        }
      }
    }
    AppMethodBeat.o(18297);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud.17
 * JD-Core Version:    0.7.0.1
 */