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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.security.a.f;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class SecurityAccountVerifyUI
  extends MMWizardActivity
  implements i
{
  private static final String kju;
  private String dOX;
  private String dOZ;
  private String dSf;
  private ProgressDialog gtM = null;
  private String kbV;
  private EditText kjC;
  private TextView kjD;
  private TextView kjE;
  private Button kjF;
  private boolean kjG = false;
  private String kjv;
  private Button kjy;
  private MTimerHandler timer;
  
  static
  {
    AppMethodBeat.i(238822);
    kju = "https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android";
    AppMethodBeat.o(238822);
  }
  
  private void bnm()
  {
    AppMethodBeat.i(125611);
    cancel();
    ala(1);
    AppMethodBeat.o(125611);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(125613);
    if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), paramInt1, paramInt2, paramString))
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
      h.a(getContext(), 2131756645, 2131756650, null);
      continue;
      h.a(getContext(), 2131756644, 2131756650, null);
      continue;
      Toast.makeText(this, 2131756598, 0).show();
      continue;
      Toast.makeText(getContext(), 2131755804, 0).show();
      continue;
      Toast.makeText(getContext(), 2131756597, 0).show();
      continue;
      h.a(getContext(), 2131756594, 2131755998, null);
    }
  }
  
  public int getLayoutId()
  {
    return 2131496193;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125609);
    this.dSf = getIntent().getStringExtra("binded_mobile");
    this.kjv = getIntent().getStringExtra("auth_ticket");
    this.kjG = getIntent().getBooleanExtra("re_open_verify", false);
    this.kjC = ((EditText)findViewById(2131297407));
    this.kjD = ((TextView)findViewById(2131304761));
    this.kjE = ((TextView)findViewById(2131306977));
    this.kjF = ((Button)findViewById(2131306976));
    this.kjC.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(125597);
        if ((paramAnonymousEditable != null) && (!Util.isNullOrNil(paramAnonymousEditable.toString()))) {}
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
    this.kjD.setText(Util.getPrivacyPhoneNum(this.dSf));
    this.kjE.setTag(Integer.valueOf(60));
    this.timer = new MTimerHandler(new MTimerHandler.CallBack()
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
        SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).setText(SecurityAccountVerifyUI.this.getString(2131764854, new Object[] { Integer.valueOf(i) }));
        if (SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).getVisibility() != 0) {
          SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).setVisibility(0);
        }
        AppMethodBeat.o(125598);
        return true;
      }
    }, true);
    this.kjF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(125600);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        Log.v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
        SecurityAccountVerifyUI.b(SecurityAccountVerifyUI.this).setVisibility(8);
        SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).setTag(Integer.valueOf(60));
        SecurityAccountVerifyUI.c(SecurityAccountVerifyUI.this).stopTimer();
        SecurityAccountVerifyUI.c(SecurityAccountVerifyUI.this).startTimer(1000L);
        paramAnonymousView = new com.tencent.mm.modelfriend.a(SecurityAccountVerifyUI.d(SecurityAccountVerifyUI.this), 10, "", "", SecurityAccountVerifyUI.e(SecurityAccountVerifyUI.this));
        g.azz().a(paramAnonymousView, 0);
        localObject = SecurityAccountVerifyUI.this;
        AppCompatActivity localAppCompatActivity = SecurityAccountVerifyUI.this.getContext();
        SecurityAccountVerifyUI.this.getString(2131755998);
        SecurityAccountVerifyUI.a((SecurityAccountVerifyUI)localObject, h.a(localAppCompatActivity, SecurityAccountVerifyUI.this.getString(2131764857), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(125599);
            g.azz().a(paramAnonymousView);
            AppMethodBeat.o(125599);
          }
        }));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125600);
      }
    });
    if (!this.kjG)
    {
      this.kjy = ((Button)findViewById(2131298768));
      this.kjy.setVisibility(0);
      this.kjy.setOnClickListener(new SecurityAccountVerifyUI.4(this));
    }
    setBackBtn(new SecurityAccountVerifyUI.5(this));
    addTextOptionMenu(0, getString(2131755916), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125604);
        paramAnonymousMenuItem = SecurityAccountVerifyUI.g(SecurityAccountVerifyUI.this).getText().toString().trim();
        if (Util.isNullOrNil(paramAnonymousMenuItem))
        {
          h.n(SecurityAccountVerifyUI.this, 2131756651, 2131755998);
          AppMethodBeat.o(125604);
          return true;
        }
        SecurityAccountVerifyUI.this.hideVKB();
        SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this, f.dD(SecurityAccountVerifyUI.this));
        SecurityAccountVerifyUI.b(SecurityAccountVerifyUI.this, f.boP());
        if (!SecurityAccountVerifyUI.h(SecurityAccountVerifyUI.this)) {}
        for (paramAnonymousMenuItem = new com.tencent.mm.modelfriend.a(SecurityAccountVerifyUI.d(SecurityAccountVerifyUI.this), paramAnonymousMenuItem, "", SecurityAccountVerifyUI.e(SecurityAccountVerifyUI.this), SecurityAccountVerifyUI.i(SecurityAccountVerifyUI.this), SecurityAccountVerifyUI.j(SecurityAccountVerifyUI.this));; paramAnonymousMenuItem = new z(SecurityAccountVerifyUI.d(SecurityAccountVerifyUI.this), 11, paramAnonymousMenuItem, "", SecurityAccountVerifyUI.i(SecurityAccountVerifyUI.this), SecurityAccountVerifyUI.j(SecurityAccountVerifyUI.this)))
        {
          g.azz().a(paramAnonymousMenuItem, 0);
          SecurityAccountVerifyUI localSecurityAccountVerifyUI1 = SecurityAccountVerifyUI.this;
          SecurityAccountVerifyUI localSecurityAccountVerifyUI2 = SecurityAccountVerifyUI.this;
          SecurityAccountVerifyUI.this.getString(2131755998);
          SecurityAccountVerifyUI.a(localSecurityAccountVerifyUI1, h.a(localSecurityAccountVerifyUI2, SecurityAccountVerifyUI.this.getString(2131756639), true, new SecurityAccountVerifyUI.6.1(this, paramAnonymousMenuItem)));
          AppMethodBeat.o(125604);
          return true;
        }
      }
    });
    enableOptionMenu(false);
    setMMTitle(2131764846);
    this.timer.startTimer(1000L);
    AppMethodBeat.o(125609);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125605);
    super.onCreate(paramBundle);
    this.kbV = com.tencent.mm.plugin.b.a.bpZ();
    initView();
    AppMethodBeat.o(125605);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125608);
    super.onDestroy();
    this.timer.stopTimer();
    AppMethodBeat.o(125608);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125610);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      bnm();
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
    g.azz().b(145, this);
    g.azz().b(132, this);
    super.onPause();
    if (!this.kjG)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L600_200,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("L600_200") + ",2");
    }
    AppMethodBeat.o(125607);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125606);
    g.azz().a(145, this);
    g.azz().a(132, this);
    super.onResume();
    if (!this.kjG)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L600_200,");
      g.aAf();
      com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("L600_200") + ",1");
      com.tencent.mm.plugin.b.a.bwU("L600_200");
    }
    AppMethodBeat.o(125606);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(125612);
    if ((this.gtM != null) && (this.gtM.isShowing()))
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125612);
      return;
      paramq = (com.tencent.mm.modelfriend.a)paramq;
      if (paramq.Vj() == 10)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          Log.i("MicroMsg.SecurityAccountVerifyUI", "resend verify code successfully");
          AppMethodBeat.o(125612);
          return;
        }
        Log.w("MicroMsg.SecurityAccountVerifyUI", "resend verify code fail, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (n(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(125612);
          return;
        }
        Toast.makeText(getContext(), getString(2131764855, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(125612);
        return;
      }
      if (paramq.Vj() == 11)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.kjv = paramq.bbH();
          Log.d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.kjv);
          paramInt1 = getIntent().getIntExtra("from_source", 1);
          Intent localIntent = new Intent();
          localIntent.putExtra("from_source", paramInt1);
          localIntent.putExtra("binded_mobile", this.dSf);
          switch (paramInt1)
          {
          case 4: 
          default: 
            ala(1);
            AppMethodBeat.o(125612);
            return;
          case 3: 
            localIntent.addFlags(67108864);
            localIntent.putExtra("auth_ticket", this.kjv);
            paramq = getIntent().getStringExtra("WizardTransactionId");
            paramString = paramq;
            if (paramq == null) {
              paramString = "";
            }
            paramString = (Intent)OHY.get(paramString);
            OHY.clear();
            if (paramString != null) {
              com.tencent.mm.plugin.account.a.a.jRt.a(this, localIntent, paramString);
            }
            for (;;)
            {
              finish();
              AppMethodBeat.o(125612);
              return;
              com.tencent.mm.plugin.account.a.a.jRt.a(this, localIntent, null);
            }
          }
          localIntent.addFlags(67108864);
          localIntent.putExtra("auth_ticket", this.kjv);
          com.tencent.mm.plugin.account.a.a.jRt.a(this, localIntent, null);
          finish();
          AppMethodBeat.o(125612);
          return;
        }
        Log.w("MicroMsg.SecurityAccountVerifyUI", "verify verify-code fail, errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (n(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(125612);
          return;
        }
        Toast.makeText(getContext(), getString(2131764859, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(125612);
        return;
      }
      Log.w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", new Object[] { Integer.valueOf(paramq.Vj()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(125612);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        f.p(true, true);
        paramString = new Intent(this, MySafeDeviceListUI.class);
        paramString.addFlags(67108864);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.pG(0));
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
      Toast.makeText(this, getString(2131764859, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI
 * JD-Core Version:    0.7.0.1
 */