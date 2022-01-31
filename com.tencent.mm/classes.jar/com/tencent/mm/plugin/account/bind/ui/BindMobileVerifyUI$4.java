package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;

final class BindMobileVerifyUI$4
  implements View.OnClickListener
{
  BindMobileVerifyUI$4(BindMobileVerifyUI paramBindMobileVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    this.fcM.XM();
    paramView = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("bindmcontact_mobile", BindMobileVerifyUI.b(this.fcM));
    localBundle.putInt("voice_verify_type", 4);
    paramView.putExtras(localBundle);
    a.eUR.d(this.fcM, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.4
 * JD-Core Version:    0.7.0.1
 */