package com.tencent.mm.plugin.expt.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.expt.c.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.picker.b;
import java.util.ArrayList;

final class ExptDebugUI$4
  implements View.OnClickListener
{
  ExptDebugUI$4(ExptDebugUI paramExptDebugUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = com.tencent.mm.plugin.expt.b.a.aMZ();
    if (paramView.jIi != null) {
      paramView = paramView.jIi.aNm();
    }
    while ((paramView != null) && (paramView.size() > 0))
    {
      String[] arrayOfString = new String[paramView.size()];
      int i = 0;
      for (;;)
      {
        if (i < arrayOfString.length)
        {
          arrayOfString[i] = paramView.get(i);
          i += 1;
          continue;
          paramView = null;
          break;
        }
      }
      paramView = new b(this.jJl.mController.uMN, arrayOfString);
      paramView.IC(0);
      paramView.wov = new ExptDebugUI.4.1(this, paramView, arrayOfString);
      paramView.IB(com.tencent.mm.cb.a.fromDPToPix(this.jJl.mController.uMN, 288));
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI.4
 * JD-Core Version:    0.7.0.1
 */