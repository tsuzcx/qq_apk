package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;

public class LoginSmsUI
  extends LoginHistoryUI
{
  private static String TAG = "LoginSmsUI";
  
  protected final void XJ()
  {
    super.XJ();
    if ((isFinishing()) || (getWindow() == null)) {
      y.e(TAG, "LoginHistoryUI is finishing");
    }
    while (bk.bl(this.fmC)) {
      return;
    }
    this.fmA.account = this.fmC;
    XM();
    XK();
    a locala = new a(this.fmC, 17, this.fmP.getText().toString().trim(), 0, "");
    g.Dk().a(locala, 0);
    getString(q.j.app_tip);
    this.dnm = h.b(this, getString(q.j.login_logining), true, new LoginSmsUI.5(this, locala));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.fmS) {
      return;
    }
    this.fhr = 3;
    if ((!bk.aaa(this.fmI).booleanValue()) && (bk.aaa(this.fmC).booleanValue())) {
      this.fmp.setText(qa(this.fmC));
    }
    this.fmP.setVisibility(0);
    this.fmP.setInputType(3);
    this.fmP.setSendSmsBtnClickListener(new LoginSmsUI.1(this));
    this.fmP.addTextChangedListener(new LoginSmsUI.2(this));
    if (this.fmP.getText().toString().length() > 0) {
      this.fmr.setEnabled(true);
    }
    for (;;)
    {
      this.fmr.setVisibility(0);
      this.fmr.setOnClickListener(new LoginSmsUI.3(this));
      return;
      this.fmr.setEnabled(false);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.fmP.reset();
  }
  
  public void onResume()
  {
    super.onResume();
    g.Dk().a(145, this);
  }
  
  protected void onStop()
  {
    super.onStop();
    g.Dk().b(145, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginSmsUI
 * JD-Core Version:    0.7.0.1
 */