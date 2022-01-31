package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

final class HoneyPayReceiveCardUI$1
  implements g
{
  HoneyPayReceiveCardUI$1(HoneyPayReceiveCardUI paramHoneyPayReceiveCardUI) {}
  
  public final Object a(m paramm)
  {
    return null;
  }
  
  public final Object b(m paramm)
  {
    if (paramm.type == 1)
    {
      paramm = paramm.data;
      if ((paramm != null) && ((paramm instanceof Bundle)) && (((Bundle)paramm).getBoolean("click_help", false))) {
        h.nFQ.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.1
 * JD-Core Version:    0.7.0.1
 */