package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ai.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t.a;
import com.tencent.mm.pointers.PInt;

final class PluginBigBallOfMud$13
  implements t.a
{
  PluginBigBallOfMud$13(PluginBigBallOfMud paramPluginBigBallOfMud) {}
  
  public final boolean a(String paramString1, String paramString2, PInt paramPInt)
  {
    boolean bool = false;
    if (s.hl(paramString1))
    {
      if (!f.eW(paramString1)) {
        break label43;
      }
      if (!e.lr(paramString2)) {
        break label35;
      }
      paramPInt.value = 5;
    }
    for (;;)
    {
      bool = true;
      return bool;
      label35:
      paramPInt.value = 4;
      continue;
      label43:
      if (f.lb(paramString1)) {
        paramPInt.value = 3;
      } else if (f.lc(paramString1)) {
        paramPInt.value = 0;
      } else if (f.kY(paramString1)) {
        paramPInt.value = 6;
      } else {
        paramPInt.value = 7;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMud.13
 * JD-Core Version:    0.7.0.1
 */