package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.friend.model.ak;
import com.tencent.mm.plugin.account.sdk.c.a.a;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.k;

public class RegByFacebookSetPwdUI
  extends SetPwdUI
{
  protected final ProgressDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(304908);
    paramContext = k.a(paramContext, getString(r.j.regbyfacebook_reg_setpwd_exiting), true, paramOnCancelListener);
    AppMethodBeat.o(304908);
    return paramContext;
  }
  
  protected final void a(a.a parama)
  {
    AppMethodBeat.i(128504);
    switch (2.pXF[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128504);
      return;
      k.s(this, r.j.regbyfacebook_reg_setpwd_alert_diff, r.j.regbyfacebook_reg_setpwd_alert_title);
      AppMethodBeat.o(128504);
      return;
      k.s(this, r.j.regbyfacebook_reg_setpwd_alert_more_byte, r.j.regbyfacebook_reg_setpwd_alert_title);
      AppMethodBeat.o(128504);
      return;
      k.s(this, r.j.verify_password_all_num_tip, r.j.app_err_reg_title);
      AppMethodBeat.o(128504);
      return;
      k.s(this, r.j.verify_password_tip, r.j.app_err_reg_title);
    }
  }
  
  protected final String bYA()
  {
    AppMethodBeat.i(128503);
    String str = ((EditText)findViewById(r.f.regbyfacebookreg_pass_again_et)).getText().toString();
    AppMethodBeat.o(128503);
    return str;
  }
  
  protected final int bYB()
  {
    return 382;
  }
  
  protected final p bYy()
  {
    AppMethodBeat.i(128501);
    ak localak = new ak(this.qgY);
    AppMethodBeat.o(128501);
    return localak;
  }
  
  protected final String bYz()
  {
    AppMethodBeat.i(128502);
    String str = ((EditText)findViewById(r.f.regbyfacebookreg_pass_et)).getText().toString();
    AppMethodBeat.o(128502);
    return str;
  }
  
  public int getLayoutId()
  {
    return r.g.regbyfacebooksetpwd_reg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128499);
    setMMTitle(r.j.regbyfacebook_reg_setpwd_title);
    AppMethodBeat.o(128499);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128497);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(128497);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128498);
    super.onDestroy();
    AppMethodBeat.o(128498);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final boolean q(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128505);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      h.baE().ban().B(57, Integer.valueOf(0));
      paramString = (String)h.baE().ban().d(5, null);
      k.d(this, getString(r.j.regbyfacebook_reg_setpwd_success, new Object[] { paramString }), getString(r.j.regbyfacebook_reg_setpwd_alert_title), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(128495);
          RegByFacebookSetPwdUI.this.finish();
          AppMethodBeat.o(128495);
        }
      });
      AppMethodBeat.o(128505);
      return true;
    }
    boolean bool = p(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(128505);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI
 * JD-Core Version:    0.7.0.1
 */