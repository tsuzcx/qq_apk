package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.plugin.account.friend.ui.i.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.k;
import java.util.Map;

public class BindMContactUI
  extends MMWizardActivity
{
  private String countryCode = null;
  private int fromScene = 0;
  private String hRk;
  private String oLl = null;
  private boolean pNU = false;
  private i pOH;
  private EditText pOW;
  private LinearLayout pOX;
  private TextView pOY;
  private TextView pOZ;
  private TextView pPa;
  private String pPb = null;
  
  private void SL(final String paramString)
  {
    AppMethodBeat.i(109901);
    if (this.pOH == null)
    {
      i.b localb = i.b.pWc;
      if (this.fromScene == 3) {
        localb = i.b.pWd;
      }
      this.pOH = new i(localb, this, new i.a()
      {
        public final void k(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(109894);
          if (paramAnonymousInt == 1)
          {
            Log.i("MicroMsg.BindMContactUI", "next to BindMContactVerifyUI for bind mobile");
            Intent localIntent = new Intent(BindMContactUI.this, BindMContactVerifyUI.class);
            localIntent.putExtra("policy_ticket", paramAnonymousBundle.getString("policyTicket", ""));
            localIntent.putExtra("bindmcontact_mobile", paramString);
            localIntent.putExtra("KEnterFromBanner", BindMContactUI.h(BindMContactUI.this));
            localIntent.putExtra("bind_scene", BindMContactUI.i(BindMContactUI.this));
            MMWizardActivity.aQ(BindMContactUI.this, localIntent);
          }
          AppMethodBeat.o(109894);
        }
      });
    }
    this.pOH.Tl(paramString);
    AppMethodBeat.o(109901);
  }
  
  private void bWm()
  {
    AppMethodBeat.i(109898);
    if ((this.fromScene != 0) && (this.fromScene != 3))
    {
      adGP.clear();
      aAp(1);
      AppMethodBeat.o(109898);
      return;
    }
    int i;
    if (this.fromScene == 3)
    {
      i = a.i.bind_mcontact_exit_content_for_change_mobile;
      if (this.fromScene != 3) {
        break label92;
      }
    }
    label92:
    for (int j = a.i.bind_mcontact_exit_tip_for_change_mobile;; j = a.i.bind_mcontact_exit_tip)
    {
      k.a(this, i, j, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(109886);
          BindMContactUI.a(BindMContactUI.this);
          AppMethodBeat.o(109886);
        }
      }, null);
      AppMethodBeat.o(109898);
      return;
      i = a.i.bind_mcontact_exit_content;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return a.f.bindmcontact;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109899);
    this.pNU = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    Log.i("MicroMsg.BindMContactUI", "bindScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    this.pOW = ((EditText)findViewById(a.e.bind_mcontact_mobile));
    this.pOX = ((LinearLayout)findViewById(a.e.country_code_ll));
    this.pOZ = ((TextView)findViewById(a.e.country_name));
    this.pPa = ((TextView)findViewById(a.e.country_code));
    this.pOY = ((TextView)findViewById(a.e.setting_bind_mobile_binded_mobile));
    String str3;
    String str1;
    String str2;
    if (this.fromScene == 3)
    {
      str3 = (String)h.baE().ban().d(6, null);
      if (!Util.isNullOrNil(str3))
      {
        if (!str3.startsWith("+")) {
          break label462;
        }
        String str4 = PhoneFormater.extractCountryCode(str3);
        str1 = str3;
        str2 = str4;
        if (!Util.isNullOrNil(str4))
        {
          str1 = str3.substring(str4.length() + 1);
          str2 = str4;
        }
        str1 = new PhoneFormater().formatNumber(str2, str1);
        this.pOY.setText(getString(a.i.bind_mcontact_change_mobile_hint, new Object[] { str1 }));
      }
    }
    if (WeChatSomeFeatureSwitch.onlyUSMobile())
    {
      this.countryCode = "1";
      this.oLl = com.tencent.mm.au.b.bI(this.countryCode, getString(a.i.country_code));
    }
    if (!Util.isNullOrNil(this.oLl)) {
      this.pOZ.setText(this.oLl);
    }
    if (Util.isNullOrNil(this.countryCode))
    {
      this.countryCode = getString(a.i.country_normal_code);
      if (this.countryCode.startsWith("+")) {
        this.countryCode = this.countryCode.substring(1);
      }
    }
    this.pPa.setText("+" + this.countryCode);
    if ((this.pPb != null) && (!this.pPb.equals("")))
    {
      this.pOW.setText(this.pPb);
      this.pOW.setSelection(this.pPb.length());
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(a.i.app_nextstep), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109890);
          BindMContactUI.a(BindMContactUI.this, BindMContactUI.c(BindMContactUI.this).getText().toString().trim() + Util.trimPhoneNumber(BindMContactUI.b(BindMContactUI.this).getText().toString()));
          if ((!com.tencent.mm.pluginsdk.b.boN(BindMContactUI.d(BindMContactUI.this))) || (Util.trimPhoneNumber(BindMContactUI.b(BindMContactUI.this).getText().toString()).length() <= 0))
          {
            k.s(BindMContactUI.this, a.i.bind_mcontact_mobile_erro, a.i.app_tip);
            AppMethodBeat.o(109890);
            return true;
          }
          BindMContactUI.b(BindMContactUI.this, BindMContactUI.d(BindMContactUI.this));
          AppMethodBeat.o(109890);
          return true;
        }
      });
      this.pOW.requestFocus();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109891);
          BindMContactUI.e(BindMContactUI.this);
          AppMethodBeat.o(109891);
          return true;
        }
      });
      this.pOX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109892);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMContactUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMContactUI.f(BindMContactUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMContactUI.g(BindMContactUI.this));
          com.tencent.mm.plugin.account.sdk.a.pFn.b(paramAnonymousView, BindMContactUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109892);
        }
      });
      AppMethodBeat.o(109899);
      return;
      label462:
      str2 = "86";
      str1 = str3;
      break;
      h.baH().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
      {
        String num;
        
        public final boolean doInBackground()
        {
          AppMethodBeat.i(109888);
          AppMethodBeat.o(109888);
          return true;
        }
        
        public final boolean onPostExecute()
        {
          AppMethodBeat.i(109887);
          if (Util.isNullOrNil(BindMContactUI.b(BindMContactUI.this).getText().trim()))
          {
            if (Util.isNullOrNil(this.num)) {
              break label85;
            }
            BindMContactUI.b(BindMContactUI.this).setText(this.num);
            BindMContactUI.b(BindMContactUI.this).setSelection(this.num.length());
          }
          for (;;)
          {
            AppMethodBeat.o(109887);
            return true;
            label85:
            BindMContactUI.b(BindMContactUI.this).setText("");
          }
        }
        
        public final String toString()
        {
          AppMethodBeat.i(109889);
          String str = super.toString() + "|initView";
          AppMethodBeat.o(109889);
          return str;
        }
      });
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109900);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt2)
    {
    default: 
      switch (paramInt1)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(109900);
      return;
      this.oLl = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.oLl.equals("")) {
        this.pOZ.setText(this.oLl);
      }
      if (this.countryCode.equals("")) {
        break;
      }
      this.pPa.setText("+" + this.countryCode);
      break;
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("agree_privacy"))) {
          SL(this.hRk);
        }
        AppMethodBeat.o(109900);
        return;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getBundleExtra("result_data");
          if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("agree_privacy"))) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(109893);
                String str = BindMContactUI.this.getString(a.i.gdpr_login_verifybirthday_url, new Object[] { LocaleUtil.getApplicationLanguage() });
                com.tencent.mm.plugin.account.sdk.c.a.b(BindMContactUI.this, str, 30765, true);
                com.tencent.mm.ui.base.b.ng(BindMContactUI.this);
                AppMethodBeat.o(109893);
              }
            }, 100L);
          }
          AppMethodBeat.o(109900);
          return;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getBundleExtra("result_data");
            if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("birthdayComfirmOK"))) {
              SL(this.hRk);
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109895);
    super.onCreate(paramBundle);
    setMMTitle(a.i.bind_mcontact_title_bind);
    this.oLl = Util.nullAs(getIntent().getStringExtra("country_name"), "");
    this.countryCode = Util.nullAs(getIntent().getStringExtra("couttry_code"), "");
    this.pPb = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    initView();
    AppMethodBeat.o(109895);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109896);
    super.onDestroy();
    if (this.pOH != null) {
      this.pOH.recycle();
    }
    AppMethodBeat.o(109896);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109897);
    if (paramInt == 4)
    {
      bWm();
      AppMethodBeat.o(109897);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(109897);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI
 * JD-Core Version:    0.7.0.1
 */