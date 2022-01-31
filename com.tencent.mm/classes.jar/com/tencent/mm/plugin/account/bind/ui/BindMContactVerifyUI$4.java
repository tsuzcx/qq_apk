package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;

final class BindMContactVerifyUI$4
  implements View.OnClickListener
{
  BindMContactVerifyUI$4(BindMContactVerifyUI paramBindMContactVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    this.fch.XM();
    paramView = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("bindmcontact_mobile", BindMContactVerifyUI.c(this.fch));
    localBundle.putInt("voice_verify_type", 4);
    paramView.putExtras(localBundle);
    a.eUR.d(this.fch, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.4
 * JD-Core Version:    0.7.0.1
 */