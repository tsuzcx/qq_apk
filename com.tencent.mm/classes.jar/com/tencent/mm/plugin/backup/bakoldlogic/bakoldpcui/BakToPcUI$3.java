package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;

final class BakToPcUI$3
  implements View.OnClickListener
{
  BakToPcUI$3(BakToPcUI paramBakToPcUI) {}
  
  public final void onClick(View paramView)
  {
    if (BakToPcUI.b(this.hPh) == 0)
    {
      a.avr().avt().dVU = 2;
      a.avr().avt().Ig();
      a.avr().avs().nN(1);
      BakToPcUI.c(this.hPh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI.3
 * JD-Core Version:    0.7.0.1
 */