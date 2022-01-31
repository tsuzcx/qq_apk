package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;

final class WelcomeActivity$9
  implements View.OnClickListener
{
  WelcomeActivity$9(WelcomeActivity paramWelcomeActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125645);
    if (d.whK)
    {
      WelcomeActivity.c(this.gKy);
      AppMethodBeat.o(125645);
      return;
    }
    paramView = new Intent(this.gKy, RegByMobileRegAIOUI.class);
    this.gKy.startActivity(paramView);
    AppMethodBeat.o(125645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity.9
 * JD-Core Version:    0.7.0.1
 */