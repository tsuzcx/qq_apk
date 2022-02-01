package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.plugin.account.sdk.b.a.a;
import com.tencent.mm.storage.ao;

public class RegByFacebookSetPwdUI
  extends SetPwdUI
{
  protected final ProgressDialog a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(219672);
    paramContext = com.tencent.mm.ui.base.h.a(paramContext, getString(r.j.regbyfacebook_reg_setpwd_exiting), true, paramOnCancelListener);
    AppMethodBeat.o(219672);
    return paramContext;
  }
  
  protected final void a(a.a parama)
  {
    AppMethodBeat.i(128504);
    switch (2.nax[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128504);
      return;
      com.tencent.mm.ui.base.h.p(this, r.j.regbyfacebook_reg_setpwd_alert_diff, r.j.regbyfacebook_reg_setpwd_alert_title);
      AppMethodBeat.o(128504);
      return;
      com.tencent.mm.ui.base.h.p(this, r.j.regbyfacebook_reg_setpwd_alert_more_byte, r.j.regbyfacebook_reg_setpwd_alert_title);
      AppMethodBeat.o(128504);
      return;
      com.tencent.mm.ui.base.h.p(this, r.j.verify_password_all_num_tip, r.j.app_err_reg_title);
      AppMethodBeat.o(128504);
      return;
      com.tencent.mm.ui.base.h.p(this, r.j.verify_password_tip, r.j.app_err_reg_title);
    }
  }
  
  protected final q bzJ()
  {
    AppMethodBeat.i(128501);
    an localan = new an(this.njK);
    AppMethodBeat.o(128501);
    return localan;
  }
  
  protected final String bzK()
  {
    AppMethodBeat.i(128502);
    String str = ((EditText)findViewById(r.f.regbyfacebookreg_pass_et)).getText().toString();
    AppMethodBeat.o(128502);
    return str;
  }
  
  protected final String bzL()
  {
    AppMethodBeat.i(128503);
    String str = ((EditText)findViewById(r.f.regbyfacebookreg_pass_again_et)).getText().toString();
    AppMethodBeat.o(128503);
    return str;
  }
  
  protected final int bzM()
  {
    return 382;
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
  
  protected final boolean o(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128505);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.kernel.h.aHG().aHp().i(57, Integer.valueOf(0));
      paramString = (String)com.tencent.mm.kernel.h.aHG().aHp().b(5, null);
      com.tencent.mm.ui.base.h.d(this, getString(r.j.regbyfacebook_reg_setpwd_success, new Object[] { paramString }), getString(r.j.regbyfacebook_reg_setpwd_alert_title), new DialogInterface.OnClickListener()
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
    boolean bool = n(paramInt1, paramInt2, paramString);
    AppMethodBeat.o(128505);
    return bool;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI
 * JD-Core Version:    0.7.0.1
 */