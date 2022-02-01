package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr;", "", "()V", "value", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "curSpeed", "getCurSpeed", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "setCurSpeed", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;)V", "lastSpeed", "getLastSpeed", "setLastSpeed", "resetCurSpeed", "", "MPVideoSpeed", "plugin-brandservice_release"})
public final class c
{
  private static c.a nnU;
  private static c.a nnV;
  public static final c nnW;
  
  static
  {
    AppMethodBeat.i(179028);
    nnW = new c();
    AppMethodBeat.o(179028);
  }
  
  public static void a(c.a parama)
  {
    if (nnV == null) {}
    for (c.a locala = c.a.nnZ;; locala = nnV)
    {
      nnU = locala;
      nnV = parama;
      return;
    }
  }
  
  public static c.a bGJ()
  {
    if (nnU == null) {
      return c.a.nnZ;
    }
    return nnU;
  }
  
  public static c.a bGK()
  {
    if (nnV == null) {
      return c.a.nnZ;
    }
    return nnV;
  }
  
  public static void bGL()
  {
    AppMethodBeat.i(179027);
    nnU = c.a.nnZ;
    a(c.a.nnZ);
    AppMethodBeat.o(179027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */