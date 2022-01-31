package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;

final class BakToPcUI$3
  implements View.OnClickListener
{
  BakToPcUI$3(BakToPcUI paramBakToPcUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(17969);
    if (BakToPcUI.b(this.jIJ) == 0)
    {
      a.aUU().aUW().fme = 2;
      a.aUU().aUW().abd();
      a.aUU().aUV().rB(1);
      BakToPcUI.c(this.jIJ);
    }
    AppMethodBeat.o(17969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI.3
 * JD-Core Version:    0.7.0.1
 */