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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.security.a.a;
import com.tencent.mm.plugin.account.security.a.b;
import com.tencent.mm.plugin.account.security.a.d;
import com.tencent.mm.plugin.account.security.a.f;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.Map;

public class SecurityAccountVerifyUI
  extends MMWizardActivity
  implements i
{
  private static final String nbk;
  private String fIi;
  private String fIk;
  private String fLC;
  private ProgressDialog iXX = null;
  private String mTu;
  private String nbl;
  private Button nbo;
  private EditText nbs;
  private TextView nbt;
  private TextView nbu;
  private Button nbv;
  private boolean nbw = false;
  private MTimerHandler timer;
  
  static
  {
    AppMethodBeat.i(231159);
    nbk = "https://" + WeChatHosts.domainString(a.d.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android";
    AppMethodBeat.o(231159);
  }
  
  private void bxv()
  {
    AppMethodBeat.i(125611);
    cancel();
    atX(1);
    AppMethodBeat.o(125611);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(125613);
    if (com.tencent.mm.plugin.account.sdk.a.mIH.a(getContext(), paramInt1, paramInt2, paramString))
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
      com.tencent.mm.ui.base.h.a(getContext(), a.d.bind_mcontact_verify_err_unmatch_content, a.d.bind_mcontact_verify_tip, null);
      continue;
      com.tencent.mm.ui.base.h.a(getContext(), a.d.bind_mcontact_verify_err_time_out_content, a.d.bind_mcontact_verify_tip, null);
      continue;
      Toast.makeText(this, a.d.bind_mcontact_err_freq_limit, 0).show();
      continue;
      Toast.makeText(getContext(), a.d.app_err_system_busy_tip, 0).show();
      continue;
      Toast.makeText(getContext(), a.d.bind_mcontact_err_format, 0).show();
      continue;
      com.tencent.mm.ui.base.h.a(getContext(), a.d.bind_mcontact_err_BindPhone_NeedAdjust, a.d.app_tip, null);
    }
  }
  
  public int getLayoutId()
  {
    return a.b.security_account_verify;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125609);
    this.fLC = getIntent().getStringExtra("binded_mobile");
    this.nbl = getIntent().getStringExtra("auth_ticket");
    this.nbw = getIntent().getBooleanExtra("re_open_verify", false);
    this.nbs = ((EditText)findViewById(a.a.bind_mcontact_verify_num));
    this.nbt = ((TextView)findViewById(a.a.mobile_number_tv));
    this.nbu = ((TextView)findViewById(a.a.resend_verify_code_tips_tv));
    this.nbv = ((Button)findViewById(a.a.resend_verify_code_btn));
    this.nbs.addTextChangedListener(new SecurityAccountVerifyUI.1(this));
    this.nbt.setText(Util.getPrivacyPhoneNum(this.fLC));
    this.nbu.setTag(Integer.valueOf(60));
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
        SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).setText(SecurityAccountVerifyUI.this.getString(a.d.safe_device_resend_verify_code_tips, new Object[] { Integer.valueOf(i) }));
        if (SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).getVisibility() != 0) {
          SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).setVisibility(0);
        }
        AppMethodBeat.o(125598);
        return true;
      }
    }, true);
    this.nbv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(125600);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
        SecurityAccountVerifyUI.b(SecurityAccountVerifyUI.this).setVisibility(8);
        SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this).setTag(Integer.valueOf(60));
        SecurityAccountVerifyUI.c(SecurityAccountVerifyUI.this).stopTimer();
        SecurityAccountVerifyUI.c(SecurityAccountVerifyUI.this).startTimer(1000L);
        paramAnonymousView = new com.tencent.mm.modelfriend.a(SecurityAccountVerifyUI.d(SecurityAccountVerifyUI.this), 10, "", "", SecurityAccountVerifyUI.e(SecurityAccountVerifyUI.this));
        com.tencent.mm.kernel.h.aGY().a(paramAnonymousView, 0);
        localObject = SecurityAccountVerifyUI.this;
        AppCompatActivity localAppCompatActivity = SecurityAccountVerifyUI.this.getContext();
        SecurityAccountVerifyUI.this.getString(a.d.app_tip);
        SecurityAccountVerifyUI.a((SecurityAccountVerifyUI)localObject, com.tencent.mm.ui.base.h.a(localAppCompatActivity, SecurityAccountVerifyUI.this.getString(a.d.safe_device_sending_verify_code), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(125599);
            com.tencent.mm.kernel.h.aGY().a(paramAnonymousView);
            AppMethodBeat.o(125599);
          }
        }));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(125600);
      }
    });
    if (!this.nbw)
    {
      this.nbo = ((Button)findViewById(a.a.close_account_protect_btn));
      this.nbo.setVisibility(0);
      this.nbo.setOnClickListener(new SecurityAccountVerifyUI.4(this));
    }
    setBackBtn(new SecurityAccountVerifyUI.5(this));
    addTextOptionMenu(0, getString(a.d.app_nextstep), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(125604);
        paramAnonymousMenuItem = SecurityAccountVerifyUI.g(SecurityAccountVerifyUI.this).getText().toString().trim();
        if (Util.isNullOrNil(paramAnonymousMenuItem))
        {
          com.tencent.mm.ui.base.h.p(SecurityAccountVerifyUI.this, a.d.bind_mcontact_verifynull, a.d.app_tip);
          AppMethodBeat.o(125604);
          return true;
        }
        SecurityAccountVerifyUI.this.hideVKB();
        SecurityAccountVerifyUI.a(SecurityAccountVerifyUI.this, f.dB(SecurityAccountVerifyUI.this));
        SecurityAccountVerifyUI.b(SecurityAccountVerifyUI.this, f.bza());
        if (!SecurityAccountVerifyUI.h(SecurityAccountVerifyUI.this)) {}
        for (paramAnonymousMenuItem = new com.tencent.mm.modelfriend.a(SecurityAccountVerifyUI.d(SecurityAccountVerifyUI.this), paramAnonymousMenuItem, "", SecurityAccountVerifyUI.e(SecurityAccountVerifyUI.this), SecurityAccountVerifyUI.i(SecurityAccountVerifyUI.this), SecurityAccountVerifyUI.j(SecurityAccountVerifyUI.this));; paramAnonymousMenuItem = new z(SecurityAccountVerifyUI.d(SecurityAccountVerifyUI.this), 11, paramAnonymousMenuItem, "", SecurityAccountVerifyUI.i(SecurityAccountVerifyUI.this), SecurityAccountVerifyUI.j(SecurityAccountVerifyUI.this)))
        {
          com.tencent.mm.kernel.h.aGY().a(paramAnonymousMenuItem, 0);
          SecurityAccountVerifyUI localSecurityAccountVerifyUI1 = SecurityAccountVerifyUI.this;
          SecurityAccountVerifyUI localSecurityAccountVerifyUI2 = SecurityAccountVerifyUI.this;
          SecurityAccountVerifyUI.this.getString(a.d.app_tip);
          SecurityAccountVerifyUI.a(localSecurityAccountVerifyUI1, com.tencent.mm.ui.base.h.a(localSecurityAccountVerifyUI2, SecurityAccountVerifyUI.this.getString(a.d.bind_mcontact_verifing), true, new SecurityAccountVerifyUI.6.1(this, paramAnonymousMenuItem)));
          AppMethodBeat.o(125604);
          return true;
        }
      }
    });
    enableOptionMenu(false);
    setMMTitle(a.d.safe_device_input_verify_code);
    this.timer.startTimer(1000L);
    AppMethodBeat.o(125609);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125605);
    super.onCreate(paramBundle);
    this.mTu = com.tencent.mm.plugin.b.a.bAt();
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
      bxv();
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
    com.tencent.mm.kernel.h.aGY().b(145, this);
    com.tencent.mm.kernel.h.aGY().b(132, this);
    super.onPause();
    if (!this.nbw)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L600_200,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("L600_200") + ",2");
    }
    AppMethodBeat.o(125607);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125606);
    com.tencent.mm.kernel.h.aGY().a(145, this);
    com.tencent.mm.kernel.h.aGY().a(132, this);
    super.onResume();
    if (!this.nbw)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L600_200,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("L600_200") + ",1");
      com.tencent.mm.plugin.b.a.bgi("L600_200");
    }
    AppMethodBeat.o(125606);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(125612);
    if ((this.iXX != null) && (this.iXX.isShowing()))
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125612);
      return;
      paramq = (com.tencent.mm.modelfriend.a)paramq;
      if (paramq.ZB() == 10)
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
        Toast.makeText(getContext(), getString(a.d.safe_device_send_verify_code_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(125612);
        return;
      }
      if (paramq.ZB() == 11)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.nbl = paramq.bkX();
          Log.d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.nbl);
          paramInt1 = getIntent().getIntExtra("from_source", 1);
          Intent localIntent = new Intent();
          localIntent.putExtra("from_source", paramInt1);
          localIntent.putExtra("binded_mobile", this.fLC);
          switch (paramInt1)
          {
          case 4: 
          default: 
            atX(1);
            AppMethodBeat.o(125612);
            return;
          case 3: 
            localIntent.addFlags(67108864);
            localIntent.putExtra("auth_ticket", this.nbl);
            paramq = getIntent().getStringExtra("WizardTransactionId");
            paramString = paramq;
            if (paramq == null) {
              paramString = "";
            }
            paramString = (Intent)Wbt.get(paramString);
            Wbt.clear();
            if (paramString != null) {
              com.tencent.mm.plugin.account.sdk.a.mIG.a(this, localIntent, paramString);
            }
            for (;;)
            {
              finish();
              AppMethodBeat.o(125612);
              return;
              com.tencent.mm.plugin.account.sdk.a.mIG.a(this, localIntent, null);
            }
          }
          localIntent.addFlags(67108864);
          localIntent.putExtra("auth_ticket", this.nbl);
          com.tencent.mm.plugin.account.sdk.a.mIG.a(this, localIntent, null);
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
        Toast.makeText(getContext(), getString(a.d.safe_device_verify_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(125612);
        return;
      }
      Log.w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", new Object[] { Integer.valueOf(paramq.ZB()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(125612);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        f.t(true, true);
        paramString = new Intent(this, MySafeDeviceListUI.class);
        paramString.addFlags(67108864);
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(125612);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125612);
        return;
      }
      Toast.makeText(this, getString(a.d.safe_device_verify_failed, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI
 * JD-Core Version:    0.7.0.1
 */