package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.ui.MMWizardActivity;

final class BakToPcUI$2
  implements View.OnClickListener
{
  BakToPcUI$2(BakToPcUI paramBakToPcUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17968);
    if (BakToPcUI.b(this.jIJ) == 0)
    {
      a.aUU().aUW().fme = 1;
      a.aUU().aUV().rB(0);
      paramView = new Intent(this.jIJ, BakWaitingUI.class);
      MMWizardActivity.J(this.jIJ, paramView);
    }
    AppMethodBeat.o(17968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI.2
 * JD-Core Version:    0.7.0.1
 */