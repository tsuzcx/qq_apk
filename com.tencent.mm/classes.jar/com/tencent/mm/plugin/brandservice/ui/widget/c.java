package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr;", "", "()V", "value", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "curSpeed", "getCurSpeed", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "setCurSpeed", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;)V", "lastSpeed", "getLastSpeed", "setLastSpeed", "resetCurSpeed", "", "MPVideoSpeed", "plugin-brandservice_release"})
public final class c
{
  private static c.a pNN;
  private static c.a pNO;
  public static final c pNP;
  
  static
  {
    AppMethodBeat.i(179028);
    pNP = new c();
    AppMethodBeat.o(179028);
  }
  
  public static void a(c.a parama)
  {
    if (pNO == null) {}
    for (c.a locala = c.a.pNS;; locala = pNO)
    {
      pNN = locala;
      pNO = parama;
      return;
    }
  }
  
  public static c.a crx()
  {
    if (pNN == null) {
      return c.a.pNS;
    }
    return pNN;
  }
  
  public static c.a cry()
  {
    if (pNO == null) {
      return c.a.pNS;
    }
    return pNO;
  }
  
  public static void crz()
  {
    AppMethodBeat.i(179027);
    pNN = c.a.pNS;
    a(c.a.pNS);
    AppMethodBeat.o(179027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */