package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMWizardActivity;

final class BindQQUI$5
  implements View.OnClickListener
{
  BindQQUI$5(BindQQUI paramBindQQUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13548);
    MMWizardActivity.J(this.guz, new Intent(this.guz, VerifyQQUI.class));
    AppMethodBeat.o(13548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindQQUI.5
 * JD-Core Version:    0.7.0.1
 */