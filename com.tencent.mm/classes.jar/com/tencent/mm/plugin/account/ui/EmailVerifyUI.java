package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.friend.a.s.a;
import com.tencent.mm.plugin.account.friend.a.s.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.ajg;
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.a;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView.b;

public class EmailVerifyUI
  extends MMActivity
  implements i
{
  private ProgressDialog iXX = null;
  private String mTu;
  private TextView nch;
  private TextView nci;
  private MMAutoSwitchEditTextView ncj;
  private Button nck;
  private Button ncl;
  private String ncm;
  private String ncn;
  private String nco;
  private String ncp;
  private boolean ncq = false;
  
  private void goBack()
  {
    AppMethodBeat.i(127923);
    com.tencent.mm.plugin.b.a.bkD(this.mTu);
    finish();
    AppMethodBeat.o(127923);
  }
  
  public int getLayoutId()
  {
    return r.g.verify_email_address;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127921);
    setMMTitle(r.j.regby_email_verify_email);
    this.nch = ((TextView)findViewById(r.f.verify_email_hint));
    String str = getString(r.j.regby_email_input_verify_tip);
    this.nch.setText(Html.fromHtml(str));
    this.nci = ((TextView)findViewById(r.f.email_address));
    this.ncm = getIntent().getStringExtra("email_address");
    if (!Util.isNullOrNil(this.ncm))
    {
      this.nci.setText(this.ncm);
      this.nco = getIntent().getStringExtra("password");
      this.ncn = getIntent().getStringExtra("email_login_page");
      Log.i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", new Object[] { this.ncm, this.ncn });
      this.ncj = ((MMAutoSwitchEditTextView)findViewById(r.f.auto_switch_ll));
      this.ncj.setOnInputFinished(new MMAutoSwitchEditTextView.a()
      {
        public final void aaW(String paramAnonymousString)
        {
          AppMethodBeat.i(127909);
          EmailVerifyUI.this.enableOptionMenu(true);
          EmailVerifyUI.a(EmailVerifyUI.this, paramAnonymousString);
          AppMethodBeat.o(127909);
        }
      });
      this.ncj.setOnTextChanged(new MMAutoSwitchEditTextView.b()
      {
        public final void bzi()
        {
          AppMethodBeat.i(127910);
          EmailVerifyUI.this.enableOptionMenu(false);
          AppMethodBeat.o(127910);
        }
      });
      this.ncl = ((Button)findViewById(r.f.re_send_verify_code_btn));
      this.ncl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(127913);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/EmailVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new StringBuilder();
          com.tencent.mm.kernel.h.aHE();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R500_250,");
          com.tencent.mm.kernel.h.aHE();
          com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R500_250") + ",3");
          com.tencent.mm.ui.base.h.a(EmailVerifyUI.this, r.j.regby_email_resend_verify_code, r.j.regby_email_err_tip_title, r.j.app_ok, r.j.app_cancel, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(127912);
              paramAnonymous2DialogInterface = new ab(EmailVerifyUI.a(EmailVerifyUI.this), EmailVerifyUI.b(EmailVerifyUI.this));
              com.tencent.mm.kernel.h.aGY().a(paramAnonymous2DialogInterface, 0);
              EmailVerifyUI localEmailVerifyUI1 = EmailVerifyUI.this;
              EmailVerifyUI localEmailVerifyUI2 = EmailVerifyUI.this;
              EmailVerifyUI.this.getString(r.j.app_tip);
              EmailVerifyUI.a(localEmailVerifyUI1, com.tencent.mm.ui.base.h.a(localEmailVerifyUI2, EmailVerifyUI.this.getString(r.j.regby_email_verify_code_sending), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                {
                  AppMethodBeat.i(127911);
                  com.tencent.mm.kernel.h.aGY().a(paramAnonymous2DialogInterface);
                  AppMethodBeat.o(127911);
                }
              }));
              AppMethodBeat.o(127912);
            }
          }, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/EmailVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(127913);
        }
      });
      this.nck = ((Button)findViewById(r.f.open_browser_btn));
      if ((!Util.isNullOrNil(this.ncn)) && (!Util.isNullOrNil(this.ncm))) {
        break label314;
      }
      this.nck.setVisibility(8);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(127915);
          EmailVerifyUI.d(EmailVerifyUI.this);
          AppMethodBeat.o(127915);
          return true;
        }
      });
      addTextOptionMenu(0, getString(r.j.app_nextstep), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(127916);
          EmailVerifyUI.b(EmailVerifyUI.this, EmailVerifyUI.e(EmailVerifyUI.this).getText());
          if ((!Util.isNullOrNil(EmailVerifyUI.f(EmailVerifyUI.this))) && (EmailVerifyUI.f(EmailVerifyUI.this).length() == 12)) {
            EmailVerifyUI.a(EmailVerifyUI.this, EmailVerifyUI.f(EmailVerifyUI.this));
          }
          for (;;)
          {
            AppMethodBeat.o(127916);
            return true;
            EmailVerifyUI.this.enableOptionMenu(false);
          }
        }
      });
      enableOptionMenu(false);
      AppMethodBeat.o(127921);
      return;
      Log.w("MicroMsg.EmailVerifyUI", "email add is null or nill");
      break;
      label314:
      this.nck.setVisibility(0);
      this.nck.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(127914);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/EmailVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Util.jump(EmailVerifyUI.this, EmailVerifyUI.c(EmailVerifyUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/EmailVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(127914);
        }
      });
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127918);
    super.onCreate(paramBundle);
    initView();
    this.mTu = com.tencent.mm.plugin.b.a.bAt();
    AppMethodBeat.o(127918);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(127922);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(127922);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(127922);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127920);
    super.onPause();
    com.tencent.mm.kernel.h.aGY().b(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R500_200,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("R500_200") + ",2");
    AppMethodBeat.o(127920);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127919);
    super.onResume();
    com.tencent.mm.kernel.h.aGY().a(481, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R500_200,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("R500_200") + ",1");
    com.tencent.mm.plugin.b.a.bgi("R500_200");
    AppMethodBeat.o(127919);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127924);
    Log.i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    this.ncq = false;
    if ((this.iXX != null) && (this.iXX.isShowing()))
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if (paramq.getType() != 481)
    {
      Log.e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", new Object[] { Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(127924);
      return;
    }
    int j = ((s.a)((ab)paramq).lCW.getReqObj()).mWq.RNt;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (j == 2)
      {
        com.tencent.mm.plugin.b.a.bkD("R200_900_email");
        paramString = new Intent(this, RegSetInfoUI.class);
        paramString.putExtra("regsetinfo_ticket", ((s.b)((ab)paramq).lCW.getRespObj()).mWr.HlB);
        paramString.putExtra("regsetinfo_user", this.ncm);
        paramString.putExtra("regsetinfo_ismobile", 3);
        paramString.putExtra("regsetinfo_NextStyle", ((ab)paramq).boM());
        paramString.putExtra("regsetinfo_pwd", this.nco);
        paramString.putExtra("regsetinfo_bind_email", this.ncm);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/account/ui/EmailVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/EmailVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(127924);
        return;
      }
      if (j == 1)
      {
        paramString = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        paramString = paramString.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R22_resend_email_code_alert,");
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R22_resend_email_code_alert") + ",3");
        com.tencent.mm.ui.base.h.cO(this, getString(r.j.regby_email_send_verify_code_ok));
        AppMethodBeat.o(127924);
        return;
      }
      Log.e("MicroMsg.EmailVerifyUI", "err opcode");
      AppMethodBeat.o(127924);
      return;
    }
    int i;
    if (com.tencent.mm.plugin.account.sdk.a.mIH.a(this, paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(127924);
      return;
      switch (paramInt2)
      {
      default: 
        i = 0;
        break;
      case -32: 
        com.tencent.mm.ui.base.h.a(this, r.j.regby_email_err_unmatch_content, r.j.regby_email_err_tip_title, null);
        paramString = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        paramString = paramString.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R500_260,");
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R500_260") + ",3");
        i = 1;
        break;
      case -33: 
        com.tencent.mm.ui.base.h.a(this, r.j.regby_email_err_time_out_content, r.j.regby_email_err_tip_title, null);
        i = 1;
        break;
      case -34: 
        Toast.makeText(this, r.j.regby_email_err_freq_limit, 0).show();
        i = 1;
      }
    }
    if (j == 2)
    {
      Toast.makeText(this, getString(r.j.regby_email_verify_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(127924);
      return;
    }
    if (j == 1) {
      Toast.makeText(this, getString(r.j.regby_email_send_verify_code_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(127924);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.EmailVerifyUI
 * JD-Core Version:    0.7.0.1
 */