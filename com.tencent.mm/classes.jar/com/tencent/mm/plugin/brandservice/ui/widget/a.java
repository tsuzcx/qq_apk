package com.tencent.mm.plugin.brandservice.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr;", "", "()V", "value", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "curSpeed", "getCurSpeed", "()Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;", "setCurSpeed", "(Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoSpeedMgr$MPVideoSpeed;)V", "lastSpeed", "getLastSpeed", "setLastSpeed", "resetCurSpeed", "", "MPVideoSpeed", "plugin-brandservice_release"})
public final class a
{
  private static a.a sUK;
  private static a.a sUL;
  public static final a sUM;
  
  static
  {
    AppMethodBeat.i(179028);
    sUM = new a();
    AppMethodBeat.o(179028);
  }
  
  public static void a(a.a parama)
  {
    if (sUL == null) {}
    for (a.a locala = a.a.sUP;; locala = sUL)
    {
      sUK = locala;
      sUL = parama;
      return;
    }
  }
  
  public static a.a cEG()
  {
    if (sUL == null) {
      return a.a.sUP;
    }
    return sUL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */