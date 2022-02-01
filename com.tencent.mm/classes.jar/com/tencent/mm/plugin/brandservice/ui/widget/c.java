package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr;", "", "()V", "value", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "curSpeed", "getCurSpeed", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "setCurSpeed", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;)V", "lastSpeed", "getLastSpeed", "setLastSpeed", "resetCurSpeed", "", "MPVideoSpeed", "plugin-brandservice_release"})
public final class c
{
  private static c.a otB;
  private static c.a otC;
  public static final c otD;
  
  static
  {
    AppMethodBeat.i(179028);
    otD = new c();
    AppMethodBeat.o(179028);
  }
  
  public static void a(c.a parama)
  {
    if (otC == null) {}
    for (c.a locala = c.a.otG;; locala = otC)
    {
      otB = locala;
      otC = parama;
      return;
    }
  }
  
  public static c.a bSx()
  {
    if (otB == null) {
      return c.a.otG;
    }
    return otB;
  }
  
  public static c.a bSy()
  {
    if (otC == null) {
      return c.a.otG;
    }
    return otC;
  }
  
  public static void bSz()
  {
    AppMethodBeat.i(179027);
    otB = c.a.otG;
    a(c.a.otG);
    AppMethodBeat.o(179027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */