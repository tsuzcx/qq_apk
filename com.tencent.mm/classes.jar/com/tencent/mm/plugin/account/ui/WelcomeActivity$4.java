package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WelcomeActivity$4
  implements View.OnClickListener
{
  WelcomeActivity$4(WelcomeActivity paramWelcomeActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125641);
    paramView = new Intent(this.gKy, MobileInputUI.class);
    paramView.putExtra("mobile_input_purpose", 1);
    this.gKy.startActivity(paramView);
    AppMethodBeat.o(125641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity.4
 * JD-Core Version:    0.7.0.1
 */