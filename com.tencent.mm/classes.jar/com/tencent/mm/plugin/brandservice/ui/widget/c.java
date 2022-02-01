package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr;", "", "()V", "value", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "curSpeed", "getCurSpeed", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "setCurSpeed", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;)V", "lastSpeed", "getLastSpeed", "setLastSpeed", "resetCurSpeed", "", "MPVideoSpeed", "plugin-brandservice_release"})
public final class c
{
  private static c.a nQU;
  private static c.a nQV;
  public static final c nQW;
  
  static
  {
    AppMethodBeat.i(179028);
    nQW = new c();
    AppMethodBeat.o(179028);
  }
  
  public static void a(c.a parama)
  {
    if (nQV == null) {}
    for (c.a locala = c.a.nQZ;; locala = nQV)
    {
      nQU = locala;
      nQV = parama;
      return;
    }
  }
  
  public static c.a bNW()
  {
    if (nQU == null) {
      return c.a.nQZ;
    }
    return nQU;
  }
  
  public static c.a bNX()
  {
    if (nQV == null) {
      return c.a.nQZ;
    }
    return nQV;
  }
  
  public static void bNY()
  {
    AppMethodBeat.i(179027);
    nQU = c.a.nQZ;
    a(c.a.nQZ);
    AppMethodBeat.o(179027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */