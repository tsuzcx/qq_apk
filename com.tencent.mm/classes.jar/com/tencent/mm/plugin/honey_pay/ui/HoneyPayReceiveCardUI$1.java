package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.u;

final class HoneyPayReceiveCardUI$1
  implements com.tencent.mm.pluginsdk.ui.span.h
{
  HoneyPayReceiveCardUI$1(HoneyPayReceiveCardUI paramHoneyPayReceiveCardUI) {}
  
  public final Object a(u paramu)
  {
    return null;
  }
  
  public final Object b(u paramu)
  {
    AppMethodBeat.i(64824);
    if (paramu.type == 1)
    {
      paramu = paramu.data;
      if ((paramu != null) && ((paramu instanceof Bundle)) && (((Bundle)paramu).getBoolean("click_help", false))) {
        com.tencent.mm.plugin.report.service.h.vKh.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
    }
    AppMethodBeat.o(64824);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.1
 * JD-Core Version:    0.7.0.1
 */