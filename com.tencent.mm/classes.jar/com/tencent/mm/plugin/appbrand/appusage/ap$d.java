package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appusage/WxaDesktopHeaderEntranceLogic$ShowCaseType;", "", "(Ljava/lang/String;I)V", "TYPE_NULL", "TYPE_WORDING", "TYPE_ICON_WORDING", "TYPE_ICON_WORDING_ICON2", "TYPE_WORDING_ICON", "Companion", "plugin-appbrand-integration_release"})
public enum ap$d
{
  public static final ap.d.a nQN;
  
  static
  {
    AppMethodBeat.i(180439);
    d locald1 = new d("TYPE_NULL", 0);
    nQH = locald1;
    d locald2 = new d("TYPE_WORDING", 1);
    nQI = locald2;
    d locald3 = new d("TYPE_ICON_WORDING", 2);
    nQJ = locald3;
    d locald4 = new d("TYPE_ICON_WORDING_ICON2", 3);
    nQK = locald4;
    d locald5 = new d("TYPE_WORDING_ICON", 4);
    nQL = locald5;
    nQM = new d[] { locald1, locald2, locald3, locald4, locald5 };
    nQN = new ap.d.a((byte)0);
    AppMethodBeat.o(180439);
  }
  
  private ap$d() {}
  
  public static final d zm(int paramInt)
  {
    AppMethodBeat.i(180442);
    d[] arrayOfd = values();
    int j = arrayOfd.length;
    int i = 0;
    while (i < j)
    {
      d locald = arrayOfd[i];
      if (paramInt == locald.ordinal())
      {
        AppMethodBeat.o(180442);
        return locald;
      }
      i += 1;
    }
    AppMethodBeat.o(180442);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.ap.d
 * JD-Core Version:    0.7.0.1
 */