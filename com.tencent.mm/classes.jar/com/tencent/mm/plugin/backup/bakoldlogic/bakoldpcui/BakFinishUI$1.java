package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;

final class BakFinishUI$1
  implements MenuItem.OnMenuItemClickListener
{
  BakFinishUI$1(BakFinishUI paramBakFinishUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(17921);
    a.aUU().aUV().jHK = -1;
    BakFinishUI.a(this.jIv);
    AppMethodBeat.o(17921);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakFinishUI.1
 * JD-Core Version:    0.7.0.1
 */