package com.tencent.mm.plugin.account.security.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.security.a.f;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class SecurityAccountVerifyUI
  extends MMWizardActivity
  implements com.tencent.mm.al.g
{
  private av cOx;
  private String dmQ;
  private String dmS;
  private String dpO;
  private ProgressDialog fpP = null;
  private String ihI;
  private String ipj;
  private Button ipm;
  private EditText ipq;
  private TextView ipr;
  private TextView ips;
  private Button ipt;
  private boolean ipu = false;
  
  private void aHX()
  {
    AppMethodBeat.i(125611);
    cancel();
    Xo(1);
    AppMethodBeat.o(125611);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(125613);
    if (com.tencent.mm.plugin.account.a.a.hYu.a(getContext(), paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(125613);
      return true;
    }
    switch (paramInt2)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(125613);
      return bool;
      h.a(getContext(), 2131756509, 2131756514, null);
      continue;
      h.a(getContext(), 2131756508, 2131756514, null);
      continue;
      Toast.makeText(this, 2131756462, 0).show();
      continue;
      Toast.makeText(getContext(), 2131755733, 0).show();
      continue;
      Toast.makeText(getContext(), 2131756461, 0).show();
      continue;
      h.a(getContext(), 2131756458, 2131755906, null);
    }
  }
  
  public int getLayoutId()
  {
    return 2131495332;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125609);
    this.dpO = getIntent().getStringExtra("binded_mobile");
    this.ipj = getIntent().getStringExtra("auth_ticket");
    this.ipu = getIntent().getBooleanExtra("re_open_verify", false);
    this.ipq = ((EditText)findViewById(2131297252));
    this.ipr = ((TextView)findViewById(2131302364));
    this.ips = ((TextView)findViewById(2131304109));
    this.ipt = ((Button)findViewById(2131304108));
    this.ipq.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(125597);
        if ((paramAnonymousEditable != null) && (!bt.isNullOrNil(paramAnonymousEditable.toString()))) {}
        for (boolean bool = true;; bool = false)
        {
          SecurityAccountVerifyUI.this.enableOptionMenu(bool);
          AppMethodBeat.o(125597);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.ipr.setText(bt.aGp(this.dpO));
    this.ips.setTag(Integer.valueOf(60));
    this.cOx = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125598);
        int i = ((Integer)SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).getTag()).intValue();
        if (i <= 1)
        {
          SecurityAccountVerifyUI.b(SecurityAccountVerifyUI.this).setVisibility(0);
          SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).setVisibility(8);
          AppMethodBeat.o(125598);
          return false;
        }
        i -= 1;
        SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).setTag(Integer.valueOf(i));
        SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).setText(SecurityAccountVerifyUI.this.getString(2131762769, new Object[] { Integer.valueOf(i) }));
        if (SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).getVisibility() != 0) {
          SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).setVisibility(0);
        }
        AppMethodBeat.o(125598);
        return true;
      }
    }, true);
    this.ipt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(125600);
        ad.v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
        SecurityAccountVerifyUI.b(SecurityAccountVerifyUI.this).setVisibility(8);
        SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).setTag(Integer.valueOf(60));
        SecurityAccountVerifyUI.c(SecurityAccountVerifyUI.this).stopTimer();
        SecurityAccountVerifyUI.c(SecurityAccountVerifyUI.this).av(1000L, 1000L);
        paramAnonymousView = new com.tencent.mm.modelfriend.a(SecurityAccountVerifyUI.d(SecurityAccountVerifyUI.this), 10, "", "", SecurityAccountVerifyUI.e(SecurityAccountVerifyUI.this));
        com.tencent.mm.kernel.g.aeS().a(paramAnonymousView, 0);
        SecurityAccountVerifyUI localSecurityAccountVerifyUI = SecurityAccountVerifyUI.this;
        AppCompatActivity localAppCompatActivity = SecurityAccountVerifyUI.this.getContext();
        SecurityAccountVerifyUI.this.getString(2131755906);
        SecurityAccountVerifyUI.a(localSecurityAccountVerifyUI, h.b(localAppCompatActivity, SecurityAccountVerifyUI.this.getString(2131762772), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(125599);
            com.tencent.mm.kernel.g.aeS().a(paramAnonymousView);
            AppMethodBeat.o(125599);
          }
        }));
        AppMethodBeat.o(125600);
      }
    });
    if (!this.ipu)
    {
      this.ipm = ((Button)findViewById(2131298363));
      this.ipm.setVisibility(0);
      this.ipm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(125601);
          paramAnonymousView = new StringBuilder();
          com.tencent.mm.kernel.g.afz();
          paramAnonymousView = paramAnonymousView.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L600_300,");
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("L600_300") + ",1");
          paramAnonymousView = ac.f(SecurityAccountVerifyUI.this.getSharedPreferences(aj.eFD(), 0));
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", String.format("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android", new Object[] { paramAnonymousView }));
          localIntent.putExtra("useJs", true);
          localIntent.putExtra("vertical_scroll", true);
          localIntent.putExtra("title", SecurityAccountVerifyUI.this.getString(2131762767));
          localIntent.putExtra("show_bottom", false);
          localIntent.putExtra("showShare", false);
          localIntent.putExtra("neverGetA8Key", true);
          localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
          localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
          com.tencent.mm.plugin.account.a.a.hYt.i(localIntent, SecurityAccountVerifyUI.this);
          AppMethodBeat.o(125601);
        }
      });
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125602);
        SecurityAccountVerifyUI.f(SecurityAccountVerifyUI.this);
        AppMethodBeat.o(125602);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755830), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125604);
        paramAnonymousMenuItem = SecurityAccountVerifyUI.g(SecurityAccountVerifyUI.this).getText().toString().trim();
        if (bt.isNullOrNil(paramAnonymousMenuItem))
        {
          h.j(SecurityAccountVerifyUI.this, 2131756515, 2131755906);
          AppMethodBeat.o(125604);
          return true;
        }
        SecurityAccountVerifyUI.this.hideVKB();
        SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this, f.cZ(SecurityAccountVerifyUI.this));
        SecurityAccountVerifyUI.b(SecurityAccountVerifyUI.this, f.aJB());
        if (!SecurityAccountVerifyUI.h(SecurityAccountVerifyUI.this)) {}
        for (paramAnonymousMenuItem = new com.tencent.mm.modelfriend.a(SecurityAccountVerifyUI.d(SecurityAccountVerifyUI.this), paramAnonymousMenuItem, "", SecurityAccountVerifyUI.e(SecurityAccountVerifyUI.this), SecurityAccountVerifyUI.i(SecurityAccountVerifyUI.this), SecurityAccountVerifyUI.j(SecurityAccountVerifyUI.this));; paramAnonymousMenuItem = new z(SecurityAccountVerifyUI.d(SecurityAccountVerifyUI.this), 11, paramAnonymousMenuItem, "", SecurityAccountVerifyUI.i(SecurityAccountVerifyUI.this), SecurityAccountVerifyUI.j(SecurityAccountVerifyUI.this)))
        {
          com.tencent.mm.kernel.g.aeS().a(paramAnonymousMenuItem, 0);
          SecurityAccountVerifyUI localSecurityAccountVerifyUI1 = SecurityAccountVerifyUI.this;
          SecurityAccountVerifyUI localSecurityAccountVerifyUI2 = SecurityAccountVerifyUI.this;
          SecurityAccountVerifyUI.this.getString(2131755906);
          SecurityAccountVerifyUI.a(localSecurityAccountVerifyUI1, h.b(localSecurityAccountVerifyUI2, SecurityAccountVerifyUI.this.getString(2131756503), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(125603);
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousMenuItem);
              AppMethodBeat.o(125603);
            }
          }));
          AppMethodBeat.o(125604);
          return true;
        }
      }
    });
    enableOptionMenu(false);
    setMMTitle(2131762761);
    this.cOx.av(1000L, 1000L);
    AppMethodBeat.o(125609);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125605);
    super.onCreate(paramBundle);
    this.ihI = com.tencent.mm.plugin.b.a.fQQ();
    initView();
    AppMethodBeat.o(125605);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125608);
    super.onDestroy();
    this.cOx.stopTimer();
    AppMethodBeat.o(125608);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125610);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aHX();
      AppMethodBeat.o(125610);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125610);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125607);
    com.tencent.mm.kernel.g.aeS().b(145, this);
    com.tencent.mm.kernel.g.aeS().b(132, this);
    super.onPause();
    if (!this.ipu)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.afz();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L600_200,");
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("L600_200") + ",2");
    }
    AppMethodBeat.o(125607);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125606);
    com.tencent.mm.kernel.g.aeS().a(145, this);
    com.tencent.mm.kernel.g.aeS().a(132, this);
    super.onResume();
    if (!this.ipu)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.afz();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L600_200,");
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("L600_200") + ",1");
      com.tencent.mm.plugin.b.a.aUy("L600_200");
    }
    AppMethodBeat.o(125606);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(125612);
    if ((this.fpP != null) && (this.fpP.isShowing()))
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125612);
      return;
      paramn = (com.tencent.mm.modelfriend.a)paramn;
      if (paramn.JJ() == 10)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          ad.i("MicroMsg.SecurityAccountVerifyUI", "resend verify code successfully");
          AppMethodBeat.o(125612);
          return;
        }
        ad.w("MicroMsg.SecurityAccountVerifyUI", "resend verify code fail, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (n(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(125612);
          return;
        }
        Toast.makeText(getContext(), getString(2131762770, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(125612);
        return;
      }
      if (paramn.JJ() == 11)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.ipj = paramn.axA();
          ad.d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.ipj);
          paramInt1 = getIntent().getIntExtra("from_source", 1);
          Intent localIntent = new Intent();
          localIntent.putExtra("from_source", paramInt1);
          localIntent.putExtra("binded_mobile", this.dpO);
          switch (paramInt1)
          {
          case 4: 
          default: 
            Xo(1);
            AppMethodBeat.o(125612);
            return;
          case 3: 
            localIntent.addFlags(67108864);
            localIntent.putExtra("auth_ticket", this.ipj);
            paramn = getIntent().getStringExtra("WizardTransactionId");
            paramString = paramn;
            if (paramn == null) {
              paramString = "";
            }
            paramString = (Intent)FPD.get(paramString);
            FPD.clear();
            if (paramString != null) {
              com.tencent.mm.plugin.account.a.a.hYt.a(this, localIntent, paramString);
            }
            for (;;)
            {
              finish();
              AppMethodBeat.o(125612);
              return;
              com.tencent.mm.plugin.account.a.a.hYt.a(this, localIntent, null);
            }
          }
          localIntent.addFlags(67108864);
          localIntent.putExtra("auth_ticket", this.ipj);
          com.tencent.mm.plugin.account.a.a.hYt.a(this, localIntent, null);
          finish();
          AppMethodBeat.o(125612);
          return;
        }
        ad.w("MicroMsg.SecurityAccountVerifyUI", "verify verify-code fail, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (n(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(125612);
          return;
        }
        Toast.makeText(getContext(), getString(2131762774, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(125612);
        return;
      }
      ad.w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", new Object[] { Integer.valueOf(paramn.JJ()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(125612);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        f.o(true, true);
        paramString = new Intent(this, MySafeDeviceListUI.class);
        paramString.addFlags(67108864);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(125612);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125612);
        return;
      }
      Toast.makeText(this, getString(2131762774, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI
 * JD-Core Version:    0.7.0.1
 */