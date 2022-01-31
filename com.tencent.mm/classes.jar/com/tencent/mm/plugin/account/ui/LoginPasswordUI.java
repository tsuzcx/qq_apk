package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;

public class LoginPasswordUI
  extends LoginHistoryUI
{
  private static String TAG = "LoginPasswordUI";
  
  protected final void XJ()
  {
    super.XJ();
    if ((isFinishing()) || (getWindow() == null))
    {
      y.e(TAG, "LoginHistoryUI is finishing");
      return;
    }
    this.fmA.fey = this.fmq.getText().toString();
    if (this.fmA.account.equals(""))
    {
      h.h(this, q.j.verify_username_null_tip, q.j.login_err_title);
      return;
    }
    if (this.fmA.fey.equals(""))
    {
      h.h(this, q.j.verify_password_null_tip, q.j.login_err_title);
      return;
    }
    XM();
    XK();
    q localq = new q(this.fmA.account, this.fmA.fey, this.fky, 0);
    g.Dk().a(localq, 0);
    getString(q.j.app_tip);
    this.dnm = h.b(this, getString(q.j.login_logining), true, new LoginPasswordUI.6(this, localq));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.fmS) {
      return;
    }
    this.fhr = 2;
    this.fmO.setVisibility(0);
    this.fmr.setVisibility(0);
    this.fmq.setTypeface(Typeface.DEFAULT);
    this.fmq.setTransformationMethod(new PasswordTransformationMethod());
    this.fmq.setOnEditorActionListener(new LoginPasswordUI.1(this));
    this.fmq.setOnKeyListener(new LoginPasswordUI.2(this));
    this.fmq.addTextChangedListener(new LoginPasswordUI.3(this));
    if (this.fmq.getText().toString().length() > 0) {
      this.fmr.setEnabled(true);
    }
    for (;;)
    {
      this.fmr.setOnClickListener(new LoginPasswordUI.4(this));
      this.fky = getIntent().getStringExtra("auth_ticket");
      if (bk.bl(this.fky)) {
        break;
      }
      this.fmp.setText(bk.pm(f.XP()));
      this.fmq.setText(bk.pm(f.XQ()));
      new ah().postDelayed(new LoginPasswordUI.5(this), 500L);
      return;
      this.fmr.setEnabled(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginPasswordUI
 * JD-Core Version:    0.7.0.1
 */