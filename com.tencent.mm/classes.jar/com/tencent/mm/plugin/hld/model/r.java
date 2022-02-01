package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.c;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/WxImeKeyboardModeFactory;", "", "()V", "MODE_LAND_MASK", "", "MODE_NIGHT_MASK", "getModeInt", "modes", "", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardMode;", "([Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardMode;)I", "", "hasMask", "", "mode", "mask", "isLand", "modeInt", "isLandAndNight", "isNight", "plugin-hld_release"})
public final class r
{
  public static final r DEQ;
  
  static
  {
    AppMethodBeat.i(216789);
    DEQ = new r();
    AppMethodBeat.o(216789);
  }
  
  public static boolean UF(int paramInt)
  {
    AppMethodBeat.i(216788);
    if ((hP(paramInt, 1)) && (hP(paramInt, 2)))
    {
      AppMethodBeat.o(216788);
      return true;
    }
    AppMethodBeat.o(216788);
    return false;
  }
  
  public static int fD(List<? extends c> paramList)
  {
    AppMethodBeat.i(216787);
    p.k(paramList, "modes");
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      c localc = (c)paramList.next();
      switch (s.jLJ[localc.ordinal()])
      {
      }
      for (;;)
      {
        break;
        i |= 0x1;
        break;
        i |= 0x2;
      }
    }
    AppMethodBeat.o(216787);
    return i;
  }
  
  public static boolean hP(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.r
 * JD-Core Version:    0.7.0.1
 */