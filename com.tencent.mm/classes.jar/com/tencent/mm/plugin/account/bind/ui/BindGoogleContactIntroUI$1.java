package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BindGoogleContactIntroUI$1
  implements View.OnClickListener
{
  BindGoogleContactIntroUI$1(BindGoogleContactIntroUI paramBindGoogleContactIntroUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13332);
    paramView = new Intent(this.gsw, BindGoogleContactUI.class);
    paramView.putExtra("enter_scene", BindGoogleContactIntroUI.a(this.gsw));
    this.gsw.startActivity(paramView);
    AppMethodBeat.o(13332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI.1
 * JD-Core Version:    0.7.0.1
 */