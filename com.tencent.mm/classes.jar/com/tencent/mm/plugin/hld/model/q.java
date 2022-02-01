package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.keyboard.selfdraw.c;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/WxImeKeyboardModeFactory;", "", "()V", "MODE_LAND_MASK", "", "MODE_NIGHT_MASK", "getModeInt", "modes", "", "Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardMode;", "([Lcom/tencent/mm/plugin/hld/keyboard/selfdraw/KeyboardMode;)I", "", "hasMask", "", "mode", "mask", "isLand", "modeInt", "isLandAndNight", "isNight", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final q Jwz;
  
  static
  {
    AppMethodBeat.i(311970);
    Jwz = new q();
    AppMethodBeat.o(311970);
  }
  
  public static boolean YD(int paramInt)
  {
    AppMethodBeat.i(311939);
    if ((jt(paramInt, 1)) && (jt(paramInt, 2)))
    {
      AppMethodBeat.o(311939);
      return true;
    }
    AppMethodBeat.o(311939);
    return false;
  }
  
  public static int iA(List<? extends c> paramList)
  {
    AppMethodBeat.i(311923);
    s.u(paramList, "modes");
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      c localc = (c)paramList.next();
      switch (a.$EnumSwitchMapping$0[localc.ordinal()])
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
    AppMethodBeat.o(311923);
    return i;
  }
  
  public static boolean jt(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.q
 * JD-Core Version:    0.7.0.1
 */