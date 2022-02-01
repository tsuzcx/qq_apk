package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;

public class RegByQQAuthUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String account;
  private String hFb;
  private String hVP;
  private ProgressDialog lzP = null;
  private String pRx;
  private EditText qgi = null;
  private int qgj;
  
  public int getLayoutId()
  {
    return r.g.regbyqq_auth;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128666);
    this.qgj = getIntent().getIntExtra("RegByQQ_BindUin", 0);
    this.pRx = getIntent().getStringExtra("RegByQQ_RawPsw");
    this.account = getIntent().getStringExtra("RegByQQ_Account");
    this.hFb = getIntent().getStringExtra("RegByQQ_Ticket");
    this.hVP = getIntent().getStringExtra("RegByQQ_Nick");
    Log.v("MicroMsg.RegByQQAuthUI", "values : bindUin:" + this.qgj + "  pass:" + this.pRx + "  ticket:" + this.hFb);
    this.qgi = ((EditText)findViewById(r.f.nick_et));
    if ((this.hVP != null) && (!this.hVP.equals(""))) {
      this.qgi.setText(this.hVP);
    }
    setMMTitle(r.j.regbyqq_auth_title);
    addTextOptionMenu(0, getString(r.j.app_nextstep), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128660);
        RegByQQAuthUI.a(RegByQQAuthUI.this, RegByQQAuthUI.a(RegByQQAuthUI.this).getText().toString().trim());
        if (RegByQQAuthUI.b(RegByQQAuthUI.this).equals(""))
        {
          k.s(RegByQQAuthUI.this, r.j.verify_account_null_tip, r.j.app_err_reg_title);
          AppMethodBeat.o(128660);
          return true;
        }
        paramAnonymousMenuItem = new w("", RegByQQAuthUI.c(RegByQQAuthUI.this), RegByQQAuthUI.b(RegByQQAuthUI.this), RegByQQAuthUI.d(RegByQQAuthUI.this), "", "", RegByQQAuthUI.e(RegByQQAuthUI.this));
        com.tencent.mm.kernel.h.aZW().a(paramAnonymousMenuItem, 0);
        RegByQQAuthUI localRegByQQAuthUI1 = RegByQQAuthUI.this;
        RegByQQAuthUI localRegByQQAuthUI2 = RegByQQAuthUI.this;
        RegByQQAuthUI.this.getString(r.j.app_tip);
        RegByQQAuthUI.a(localRegByQQAuthUI1, k.a(localRegByQQAuthUI2, RegByQQAuthUI.this.getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(128659);
            com.tencent.mm.kernel.h.aZW().a(paramAnonymousMenuItem);
            AppMethodBeat.o(128659);
          }
        }));
        AppMethodBeat.o(128660);
        return true;
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128661);
        RegByQQAuthUI.this.hideVKB();
        RegByQQAuthUI.this.finish();
        AppMethodBeat.o(128661);
        return true;
      }
    });
    AppMethodBeat.o(128666);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128662);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(128662);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128663);
    super.onDestroy();
    AppMethodBeat.o(128663);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128665);
    super.onPause();
    com.tencent.mm.kernel.h.aZW().b(126, this);
    AppMethodBeat.o(128665);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128664);
    super.onResume();
    com.tencent.mm.kernel.h.aZW().a(126, this);
    AppMethodBeat.o(128664);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128667);
    Log.i("MicroMsg.RegByQQAuthUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if (!Util.isTopActivity(this))
    {
      AppMethodBeat.o(128667);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramp.getType())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(128667);
        return;
        b.aZI();
        bg.okT.bc("login_user_name", this.account);
        paramString = new Intent(this, BindMContactIntroUI.class);
        paramString.putExtra("key_upload_scene", 1);
        paramString.putExtra("skip", true);
        paramp = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
        paramp.addFlags(67108864);
        paramp.putExtra("LauncherUI.enter_from_reg", true);
        MMWizardActivity.b(this, paramString, paramp);
      }
    }
    if (paramp.getType() == 126)
    {
      paramp = com.tencent.mm.broadcast.a.CH(paramString);
      if (paramp != null)
      {
        paramp.a(this, null, null);
        AppMethodBeat.o(128667);
        return;
      }
    }
    int i;
    if (com.tencent.mm.plugin.account.sdk.a.pFo.a(getContext(), paramInt1, paramInt2, paramString)) {
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(128667);
      return;
      if (paramInt1 == 4) {}
      switch (paramInt2)
      {
      default: 
        i = 0;
        break;
      case -1: 
        if (com.tencent.mm.kernel.h.aZW().bFQ() == 5)
        {
          k.s(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
          i = 1;
        }
        break;
      case -3: 
        k.s(this, r.j.app_err_password, r.j.regbyqq_auth_err_title);
        i = 1;
        break;
      case -4: 
        k.s(this, r.j.app_err_nouser, r.j.regbyqq_auth_err_title);
        i = 1;
        break;
      case -12: 
        k.s(this, r.j.regbyqq_auth_err_uinexsit, r.j.regbyqq_auth_err_title);
        i = 1;
        break;
      case -11: 
        k.s(this, r.j.regbyqq_auth_err_nickinvalid, r.j.regbyqq_auth_err_title);
        i = 1;
        break;
      case -72: 
        k.s(getContext(), r.j.regbyqq_auth_err_failed_niceqq, r.j.app_tip);
        i = 1;
        break;
      case -75: 
        k.s(getContext(), r.j.alpha_version_tip_reg, r.j.app_tip);
        i = 1;
      }
    }
    Toast.makeText(this, getString(r.j.fmt_reg_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(128667);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByQQAuthUI
 * JD-Core Version:    0.7.0.1
 */