package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class BindGoogleContactIntroUI$1
  implements View.OnClickListener
{
  BindGoogleContactIntroUI$1(BindGoogleContactIntroUI paramBindGoogleContactIntroUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.faE, BindGoogleContactUI.class);
    paramView.putExtra("enter_scene", BindGoogleContactIntroUI.a(this.faE));
    this.faE.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindGoogleContactIntroUI.1
 * JD-Core Version:    0.7.0.1
 */