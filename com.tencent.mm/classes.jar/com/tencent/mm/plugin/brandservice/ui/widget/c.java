package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr;", "", "()V", "value", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "curSpeed", "getCurSpeed", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "setCurSpeed", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;)V", "lastSpeed", "getLastSpeed", "setLastSpeed", "resetCurSpeed", "", "MPVideoSpeed", "plugin-brandservice_release"})
public final class c
{
  private static c.a oAc;
  private static c.a oAd;
  public static final c oAe;
  
  static
  {
    AppMethodBeat.i(179028);
    oAe = new c();
    AppMethodBeat.o(179028);
  }
  
  public static void a(c.a parama)
  {
    if (oAd == null) {}
    for (c.a locala = c.a.oAh;; locala = oAd)
    {
      oAc = locala;
      oAd = parama;
      return;
    }
  }
  
  public static c.a bTK()
  {
    if (oAc == null) {
      return c.a.oAh;
    }
    return oAc;
  }
  
  public static c.a bTL()
  {
    if (oAd == null) {
      return c.a.oAh;
    }
    return oAd;
  }
  
  public static void bTM()
  {
    AppMethodBeat.i(179027);
    oAc = c.a.oAh;
    a(c.a.oAh);
    AppMethodBeat.o(179027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */