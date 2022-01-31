package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.ui.MMWizardActivity;

final class BakToPcUI$2
  implements View.OnClickListener
{
  BakToPcUI$2(BakToPcUI paramBakToPcUI) {}
  
  public final void onClick(View paramView)
  {
    if (BakToPcUI.b(this.hPh) == 0)
    {
      a.avr().avt().dVU = 1;
      a.avr().avs().nN(0);
      paramView = new Intent(this.hPh, BakWaitingUI.class);
      MMWizardActivity.C(this.hPh, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI.2
 * JD-Core Version:    0.7.0.1
 */