package com.tencent.mm.model.gdpr.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MPGdprPolicyUI$3
  implements MenuItem.OnMenuItemClickListener
{
  MPGdprPolicyUI$3(MPGdprPolicyUI paramMPGdprPolicyUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(1504);
    this.foM.finish();
    AppMethodBeat.o(1504);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI.3
 * JD-Core Version:    0.7.0.1
 */