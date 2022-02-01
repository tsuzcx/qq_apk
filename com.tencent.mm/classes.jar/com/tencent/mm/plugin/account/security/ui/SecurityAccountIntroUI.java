package com.tencent.mm.plugin.account.security.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.lh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class SecurityAccountIntroUI
  extends MMWizardActivity
  implements com.tencent.mm.ak.g
{
  private String dnz;
  private ProgressDialog fts = null;
  private String iHQ;
  private String iPp;
  private String iPq;
  private boolean iPr = false;
  private Button iPs;
  private String jumpUrl;
  
  private void aOO()
  {
    AppMethodBeat.i(125594);
    com.tencent.mm.plugin.b.a.IL(this.iHQ);
    cancel();
    ZA(1);
    AppMethodBeat.o(125594);
  }
  
  public int getLayoutId()
  {
    return 2131495330;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125593);
    setMMTitle(2131762776);
    findViewById(2131303038).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(125586);
        if (!SecurityAccountIntroUI.a(SecurityAccountIntroUI.this)) {}
        for (paramAnonymousView = new com.tencent.mm.modelfriend.a(SecurityAccountIntroUI.b(SecurityAccountIntroUI.this), 10, "", "", SecurityAccountIntroUI.c(SecurityAccountIntroUI.this));; paramAnonymousView = new z(SecurityAccountIntroUI.b(SecurityAccountIntroUI.this), 10, "", 0, ""))
        {
          com.tencent.mm.kernel.g.agi().a(paramAnonymousView, 0);
          SecurityAccountIntroUI localSecurityAccountIntroUI1 = SecurityAccountIntroUI.this;
          SecurityAccountIntroUI localSecurityAccountIntroUI2 = SecurityAccountIntroUI.this;
          SecurityAccountIntroUI.this.getString(2131755906);
          SecurityAccountIntroUI.a(localSecurityAccountIntroUI1, h.b(localSecurityAccountIntroUI2, SecurityAccountIntroUI.this.getString(2131762772), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(125585);
              com.tencent.mm.kernel.g.agi().a(paramAnonymousView);
              AppMethodBeat.o(125585);
            }
          }));
          AppMethodBeat.o(125586);
          return;
        }
      }
    });
    if (!this.iPr)
    {
      this.iPs = ((Button)findViewById(2131298363));
      if (!bs.isNullOrNil(this.iPq)) {
        this.iPs.setText(this.iPq);
      }
      this.iPs.setVisibility(0);
      this.iPs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(125587);
          paramAnonymousView = ab.f(SecurityAccountIntroUI.this.getSharedPreferences(ai.eUX(), 0));
          Intent localIntent = new Intent();
          if (bs.isNullOrNil(SecurityAccountIntroUI.d(SecurityAccountIntroUI.this))) {
            localIntent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[] { paramAnonymousView }));
          }
          for (;;)
          {
            localIntent.putExtra("useJs", true);
            localIntent.putExtra("vertical_scroll", true);
            localIntent.putExtra("title", SecurityAccountIntroUI.this.getString(2131762767));
            localIntent.putExtra("show_bottom", false);
            localIntent.putExtra("showShare", false);
            localIntent.putExtra("neverGetA8Key", true);
            localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
            localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
            com.tencent.mm.plugin.account.a.a.iyx.i(localIntent, SecurityAccountIntroUI.this);
            AppMethodBeat.o(125587);
            return;
            localIntent.putExtra("rawUrl", SecurityAccountIntroUI.d(SecurityAccountIntroUI.this));
          }
        }
      });
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125588);
        SecurityAccountIntroUI.e(SecurityAccountIntroUI.this);
        AppMethodBeat.o(125588);
        return true;
      }
    });
    AppMethodBeat.o(125593);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125589);
    super.onCreate(paramBundle);
    this.iPp = getIntent().getStringExtra("auth_ticket");
    this.dnz = getIntent().getStringExtra("binded_mobile");
    this.iPr = getIntent().getBooleanExtra("re_open_verify", false);
    paramBundle = getIntent().getStringExtra("close_safe_device_style");
    ac.i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", new Object[] { bs.aLJ(this.iPp), paramBundle });
    if (!bs.isNullOrNil(paramBundle))
    {
      paramBundle = bv.L(paramBundle, "wording");
      if (paramBundle != null)
      {
        this.iPq = ((String)paramBundle.get(".wording.title"));
        this.jumpUrl = ((String)paramBundle.get(".wording.url"));
        ac.i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", new Object[] { this.iPq, this.jumpUrl });
      }
    }
    this.iHQ = com.tencent.mm.plugin.b.a.EL();
    initView();
    AppMethodBeat.o(125589);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125592);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aOO();
      AppMethodBeat.o(125592);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125592);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125591);
    super.onPause();
    com.tencent.mm.kernel.g.agi().b(145, this);
    com.tencent.mm.kernel.g.agi().b(132, this);
    if (!this.iPr)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L600_100,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("L600_100") + ",2");
    }
    AppMethodBeat.o(125591);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125590);
    super.onResume();
    com.tencent.mm.kernel.g.agi().a(145, this);
    com.tencent.mm.kernel.g.agi().a(132, this);
    if (!this.iPr)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L600_100,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("L600_100") + ",1");
      com.tencent.mm.plugin.b.a.IK("L600_100");
    }
    AppMethodBeat.o(125590);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(125595);
    if ((this.fts != null) && (this.fts.isShowing()))
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!this.iPr) {}
      for (paramString = ((com.tencent.mm.modelfriend.a)paramn).aEs();; paramString = ((lh)((z)paramn).rr.hvs.hvw).DTL)
      {
        ac.d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.iPp + "duanyi test authTicket_check = " + paramString);
        paramn = new Intent(this, SecurityAccountVerifyUI.class);
        paramn.putExtra("auth_ticket", paramString);
        paramn.putExtra("binded_mobile", this.dnz);
        paramn.putExtra("re_open_verify", this.iPr);
        paramn.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
        aj(this, paramn);
        if (getIntent().getIntExtra("from_source", 1) == 3) {
          finish();
        }
        AppMethodBeat.o(125595);
        return;
      }
    }
    int i;
    switch (paramInt2)
    {
    default: 
      i = 0;
    }
    while ((i != 0) || (com.tencent.mm.plugin.account.a.a.iyy.a(this, paramInt1, paramInt2, paramString)))
    {
      AppMethodBeat.o(125595);
      return;
      Toast.makeText(this, 2131755733, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131756462, 0).show();
      i = 1;
      continue;
      Toast.makeText(this, 2131756461, 0).show();
      i = 1;
      continue;
      h.a(this, 2131756458, 2131755906, null);
      i = 1;
    }
    Toast.makeText(this, getString(2131762770, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(125595);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI
 * JD-Core Version:    0.7.0.1
 */