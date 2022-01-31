package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class InviteRecommendChoiceUI$1
  implements MenuItem.OnMenuItemClickListener
{
  InviteRecommendChoiceUI$1(InviteRecommendChoiceUI paramInviteRecommendChoiceUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(124901);
    this.gDB.hideVKB();
    this.gDB.finish();
    AppMethodBeat.o(124901);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteRecommendChoiceUI.1
 * JD-Core Version:    0.7.0.1
 */