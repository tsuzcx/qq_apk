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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class SecurityAccountVerifyUI
  extends MMWizardActivity
  implements com.tencent.mm.ak.f
{
  private aw cYd;
  private String dAs;
  private String dxq;
  private String dxs;
  private ProgressDialog fOC = null;
  private String jdS;
  private TextView jlA;
  private Button jlB;
  private boolean jlC = false;
  private String jlr;
  private Button jlu;
  private EditText jly;
  private TextView jlz;
  
  private void aSz()
  {
    AppMethodBeat.i(125611);
    cancel();
    acs(1);
    AppMethodBeat.o(125611);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(125613);
    if (com.tencent.mm.plugin.account.a.a.iUA.a(getContext(), paramInt1, paramInt2, paramString))
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
    this.dAs = getIntent().getStringExtra("binded_mobile");
    this.jlr = getIntent().getStringExtra("auth_ticket");
    this.jlC = getIntent().getBooleanExtra("re_open_verify", false);
    this.jly = ((EditText)findViewById(2131297252));
    this.jlz = ((TextView)findViewById(2131302364));
    this.jlA = ((TextView)findViewById(2131304109));
    this.jlB = ((Button)findViewById(2131304108));
    this.jly.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(125597);
        if ((paramAnonymousEditable != null) && (!bu.isNullOrNil(paramAnonymousEditable.toString()))) {}
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
    this.jlz.setText(bu.aSJ(this.dAs));
    this.jlA.setTag(Integer.valueOf(60));
    this.cYd = new aw(new aw.a()
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
    this.jlB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(125600);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        ae.v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
        SecurityAccountVerifyUI.b(SecurityAccountVerifyUI.this).setVisibility(8);
        SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).setTag(Integer.valueOf(60));
        SecurityAccountVerifyUI.c(SecurityAccountVerifyUI.this).stopTimer();
        SecurityAccountVerifyUI.c(SecurityAccountVerifyUI.this).ay(1000L, 1000L);
        paramAnonymousView = new com.tencent.mm.modelfriend.a(SecurityAccountVerifyUI.d(SecurityAccountVerifyUI.this), 10, "", "", SecurityAccountVerifyUI.e(SecurityAccountVerifyUI.this));
        g.ajj().a(paramAnonymousView, 0);
        localObject = SecurityAccountVerifyUI.this;
        AppCompatActivity localAppCompatActivity = SecurityAccountVerifyUI.this.getContext();
        SecurityAccountVerifyUI.this.getString(2131755906);
        SecurityAccountVerifyUI.a((SecurityAccountVerifyUI)localObject, h.b(localAppCompatActivity, SecurityAccountVerifyUI.this.getString(2131762772), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(125599);
            g.ajj().a(paramAnonymousView);
            AppMethodBeat.o(125599);
          }
        }));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125600);
      }
    });
    if (!this.jlC)
    {
      this.jlu = ((Button)findViewById(2131298363));
      this.jlu.setVisibility(0);
      this.jlu.setOnClickListener(new SecurityAccountVerifyUI.4(this));
    }
    setBackBtn(new SecurityAccountVerifyUI.5(this));
    addTextOptionMenu(0, getString(2131755830), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(final MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125604);
        paramAnonymousMenuItem = SecurityAccountVerifyUI.g(SecurityAccountVerifyUI.this).getText().toString().trim();
        if (bu.isNullOrNil(paramAnonymousMenuItem))
        {
          h.l(SecurityAccountVerifyUI.this, 2131756515, 2131755906);
          AppMethodBeat.o(125604);
          return true;
        }
        SecurityAccountVerifyUI.this.hideVKB();
        SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this, com.tencent.mm.plugin.account.security.a.f.di(SecurityAccountVerifyUI.this));
        SecurityAccountVerifyUI.b(SecurityAccountVerifyUI.this, com.tencent.mm.plugin.account.security.a.f.aUd());
        if (!SecurityAccountVerifyUI.h(SecurityAccountVerifyUI.this)) {}
        for (paramAnonymousMenuItem = new com.tencent.mm.modelfriend.a(SecurityAccountVerifyUI.d(SecurityAccountVerifyUI.this), paramAnonymousMenuItem, "", SecurityAccountVerifyUI.e(SecurityAccountVerifyUI.this), SecurityAccountVerifyUI.i(SecurityAccountVerifyUI.this), SecurityAccountVerifyUI.j(SecurityAccountVerifyUI.this));; paramAnonymousMenuItem = new z(SecurityAccountVerifyUI.d(SecurityAccountVerifyUI.this), 11, paramAnonymousMenuItem, "", SecurityAccountVerifyUI.i(SecurityAccountVerifyUI.this), SecurityAccountVerifyUI.j(SecurityAccountVerifyUI.this)))
        {
          g.ajj().a(paramAnonymousMenuItem, 0);
          SecurityAccountVerifyUI localSecurityAccountVerifyUI1 = SecurityAccountVerifyUI.this;
          SecurityAccountVerifyUI localSecurityAccountVerifyUI2 = SecurityAccountVerifyUI.this;
          SecurityAccountVerifyUI.this.getString(2131755906);
          SecurityAccountVerifyUI.a(localSecurityAccountVerifyUI1, h.b(localSecurityAccountVerifyUI2, SecurityAccountVerifyUI.this.getString(2131756503), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(125603);
              g.ajj().a(paramAnonymousMenuItem);
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
    this.cYd.ay(1000L, 1000L);
    AppMethodBeat.o(125609);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125605);
    super.onCreate(paramBundle);
    this.jdS = com.tencent.mm.plugin.b.a.aVo();
    initView();
    AppMethodBeat.o(125605);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125608);
    super.onDestroy();
    this.cYd.stopTimer();
    AppMethodBeat.o(125608);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125610);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aSz();
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
    g.ajj().b(145, this);
    g.ajj().b(132, this);
    super.onPause();
    if (!this.jlC)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.ajP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L600_200,");
      g.ajP();
      com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("L600_200") + ",2");
    }
    AppMethodBeat.o(125607);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125606);
    g.ajj().a(145, this);
    g.ajj().a(132, this);
    super.onResume();
    if (!this.jlC)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.ajP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L600_200,");
      g.ajP();
      com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("L600_200") + ",1");
      com.tencent.mm.plugin.b.a.KA("L600_200");
    }
    AppMethodBeat.o(125606);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(125612);
    if ((this.fOC != null) && (this.fOC.isShowing()))
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125612);
      return;
      paramn = (com.tencent.mm.modelfriend.a)paramn;
      if (paramn.KZ() == 10)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          ae.i("MicroMsg.SecurityAccountVerifyUI", "resend verify code successfully");
          AppMethodBeat.o(125612);
          return;
        }
        ae.w("MicroMsg.SecurityAccountVerifyUI", "resend verify code fail, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (n(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(125612);
          return;
        }
        Toast.makeText(getContext(), getString(2131762770, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(125612);
        return;
      }
      if (paramn.KZ() == 11)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.jlr = paramn.aHO();
          ae.d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.jlr);
          paramInt1 = getIntent().getIntExtra("from_source", 1);
          Intent localIntent = new Intent();
          localIntent.putExtra("from_source", paramInt1);
          localIntent.putExtra("binded_mobile", this.dAs);
          switch (paramInt1)
          {
          case 4: 
          default: 
            acs(1);
            AppMethodBeat.o(125612);
            return;
          case 3: 
            localIntent.addFlags(67108864);
            localIntent.putExtra("auth_ticket", this.jlr);
            paramn = getIntent().getStringExtra("WizardTransactionId");
            paramString = paramn;
            if (paramn == null) {
              paramString = "";
            }
            paramString = (Intent)JxE.get(paramString);
            JxE.clear();
            if (paramString != null) {
              com.tencent.mm.plugin.account.a.a.iUz.a(this, localIntent, paramString);
            }
            for (;;)
            {
              finish();
              AppMethodBeat.o(125612);
              return;
              com.tencent.mm.plugin.account.a.a.iUz.a(this, localIntent, null);
            }
          }
          localIntent.addFlags(67108864);
          localIntent.putExtra("auth_ticket", this.jlr);
          com.tencent.mm.plugin.account.a.a.iUz.a(this, localIntent, null);
          finish();
          AppMethodBeat.o(125612);
          return;
        }
        ae.w("MicroMsg.SecurityAccountVerifyUI", "verify verify-code fail, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (n(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(125612);
          return;
        }
        Toast.makeText(getContext(), getString(2131762774, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(125612);
        return;
      }
      ae.w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", new Object[] { Integer.valueOf(paramn.KZ()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(125612);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        com.tencent.mm.plugin.account.security.a.f.p(true, true);
        paramString = new Intent(this, MySafeDeviceListUI.class);
        paramString.addFlags(67108864);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.mt(0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI
 * JD-Core Version:    0.7.0.1
 */