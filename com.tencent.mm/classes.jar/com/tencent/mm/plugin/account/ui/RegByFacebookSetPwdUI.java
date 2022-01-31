package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.b.a.a;
import com.tencent.mm.plugin.account.friend.a.ak;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

public class RegByFacebookSetPwdUI
  extends SetPwdUI
{
  protected final m XZ()
  {
    return new ak(this.fsy);
  }
  
  protected final String Ya()
  {
    return ((EditText)findViewById(q.f.regbyfacebookreg_pass_et)).getText().toString();
  }
  
  protected final String Yb()
  {
    return ((EditText)findViewById(q.f.regbyfacebookreg_pass_again_et)).getText().toString();
  }
  
  protected final int Yc()
  {
    return 382;
  }
  
  protected final ProgressDialog a(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return h.b(paramContext, getString(q.j.regbyfacebook_reg_setpwd_exiting), true, paramOnCancelListener);
  }
  
  protected final void a(a.a parama)
  {
    switch (RegByFacebookSetPwdUI.2.fjL[parama.ordinal()])
    {
    default: 
      return;
    case 1: 
      h.h(this, q.j.regbyfacebook_reg_setpwd_alert_diff, q.j.regbyfacebook_reg_setpwd_alert_title);
      return;
    case 2: 
      h.h(this, q.j.regbyfacebook_reg_setpwd_alert_more_byte, q.j.regbyfacebook_reg_setpwd_alert_title);
      return;
    case 3: 
      h.h(this, q.j.verify_password_all_num_tip, q.j.app_err_reg_title);
      return;
    }
    h.h(this, q.j.verify_password_tip, q.j.app_err_reg_title);
  }
  
  protected final int getLayoutId()
  {
    return q.g.regbyfacebooksetpwd_reg;
  }
  
  protected final boolean i(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      g.DP().Dz().o(57, Integer.valueOf(0));
      paramString = (String)g.DP().Dz().get(5, null);
      h.a(this, getString(q.j.regbyfacebook_reg_setpwd_success, new Object[] { paramString }), getString(q.j.regbyfacebook_reg_setpwd_alert_title), new RegByFacebookSetPwdUI.1(this));
      return true;
    }
    return h(paramInt1, paramInt2, paramString);
  }
  
  protected final void initView()
  {
    setMMTitle(q.j.regbyfacebook_reg_setpwd_title);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(q.j.regbyfacebook_reg_setpwd_title);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI
 * JD-Core Version:    0.7.0.1
 */