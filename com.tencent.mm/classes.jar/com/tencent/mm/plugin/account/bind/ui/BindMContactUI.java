package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.plugin.account.friend.ui.i.b;
import com.tencent.mm.plugin.account.sdk.b.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.Map;

public class BindMContactUI
  extends MMWizardActivity
{
  private String countryCode = null;
  private String fLC;
  private int fromScene = 0;
  private String lSz = null;
  private boolean mRn = false;
  private i mSa;
  private EditText mSr;
  private LinearLayout mSs;
  private TextView mSt;
  private TextView mSu;
  private TextView mSv;
  private String mSw = null;
  
  private void aar(final String paramString)
  {
    AppMethodBeat.i(109901);
    if (this.mSa == null)
    {
      i.b localb = i.b.mZt;
      if (this.fromScene == 3) {
        localb = i.b.mZu;
      }
      this.mSa = new i(localb, this, new i.a()
      {
        public final void j(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(109894);
          if (paramAnonymousInt == 1)
          {
            Log.i("MicroMsg.BindMContactUI", "next to BindMContactVerifyUI for bind mobile");
            paramAnonymousBundle = new Intent(BindMContactUI.this, BindMContactVerifyUI.class);
            paramAnonymousBundle.putExtra("bindmcontact_mobile", paramString);
            paramAnonymousBundle.putExtra("KEnterFromBanner", BindMContactUI.i(BindMContactUI.this));
            paramAnonymousBundle.putExtra("bind_scene", BindMContactUI.j(BindMContactUI.this));
            MMWizardActivity.aH(BindMContactUI.this, paramAnonymousBundle);
          }
          AppMethodBeat.o(109894);
        }
      });
    }
    this.mSa.aaS(paramString);
    AppMethodBeat.o(109901);
  }
  
  private void bxx()
  {
    AppMethodBeat.i(109898);
    if ((this.fromScene != 0) && (this.fromScene != 3))
    {
      Wbt.clear();
      atX(1);
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
      com.tencent.mm.ui.base.h.a(this, i, j, new DialogInterface.OnClickListener()
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
    this.mRn = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    Log.i("MicroMsg.BindMContactUI", "bindScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    this.mSr = ((EditText)findViewById(a.e.bind_mcontact_mobile));
    this.mSs = ((LinearLayout)findViewById(a.e.country_code_ll));
    this.mSu = ((TextView)findViewById(a.e.country_name));
    this.mSv = ((TextView)findViewById(a.e.country_code));
    this.mSt = ((TextView)findViewById(a.e.setting_bind_mobile_binded_mobile));
    String str3;
    String str1;
    String str2;
    if (this.fromScene == 3)
    {
      str3 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(6, null);
      if (!Util.isNullOrNil(str3))
      {
        if (!str3.startsWith("+")) {
          break label466;
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
        this.mSt.setText(getString(a.i.bind_mcontact_change_mobile_hint, new Object[] { str1 }));
      }
    }
    if (WeChatSomeFeatureSwitch.onlyUSMobile())
    {
      this.countryCode = "1";
      this.lSz = com.tencent.mm.az.b.bx(this.countryCode, getString(a.i.country_code));
    }
    if (!Util.isNullOrNil(this.lSz)) {
      this.mSu.setText(this.lSz);
    }
    if (Util.isNullOrNil(this.countryCode))
    {
      this.countryCode = getString(a.i.country_normal_code);
      if (this.countryCode.startsWith("+")) {
        this.countryCode = this.countryCode.substring(1);
      }
    }
    this.mSv.setText("+" + this.countryCode);
    if ((this.mSw != null) && (!this.mSw.equals("")))
    {
      this.mSr.setText(this.mSw);
      this.mSr.setSelection(this.mSw.length());
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(a.i.app_nextstep), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          int j = 0;
          int k = 0;
          int m = 0;
          int n = 0;
          int i = 0;
          AppMethodBeat.i(109890);
          BindMContactUI.a(BindMContactUI.this, BindMContactUI.c(BindMContactUI.this).getText().toString().trim() + Util.trimPhoneNumber(BindMContactUI.b(BindMContactUI.this).getText().toString()));
          if ((!com.tencent.mm.pluginsdk.b.boT(BindMContactUI.d(BindMContactUI.this))) || (Util.trimPhoneNumber(BindMContactUI.b(BindMContactUI.this).getText().toString()).length() <= 0))
          {
            com.tencent.mm.ui.base.h.p(BindMContactUI.this, a.i.bind_mcontact_mobile_erro, a.i.app_tip);
            AppMethodBeat.o(109890);
            return true;
          }
          int i1 = BindMContactUI.e(BindMContactUI.this);
          Log.i("MicroMsg.BindMContactUI", "nextStep %d", new Object[] { Integer.valueOf(i1) });
          switch (i1)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(109890);
            return true;
            com.tencent.mm.ui.base.h.c(BindMContactUI.this, BindMContactUI.this.getString(a.i.bind_mcontact_unable_change_mobile), "", true);
            continue;
            Log.i("MicroMsg.BindMContactUI", "do next, send sms to self");
            BindMContactUI.b(BindMContactUI.this, BindMContactUI.d(BindMContactUI.this));
            continue;
            paramAnonymousMenuItem = com.tencent.mm.az.b.by("86", BindMContactUI.this.getString(a.i.country_code));
            boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VuM, Boolean.FALSE)).booleanValue();
            BindMContactUI localBindMContactUI = BindMContactUI.this;
            j = a.i.license_read_url;
            String str = LocaleUtil.getApplicationLanguage();
            if (bool) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousMenuItem = localBindMContactUI.getString(j, new Object[] { str, paramAnonymousMenuItem, "login", Integer.valueOf(1), Integer.valueOf(i) });
              a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
              break;
            }
            paramAnonymousMenuItem = com.tencent.mm.az.b.by(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(a.i.country_code));
            bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VuM, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            j = a.i.license_read_url;
            str = LocaleUtil.getApplicationLanguage();
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(j, new Object[] { str, paramAnonymousMenuItem, "login", Integer.valueOf(1), Integer.valueOf(i) });
            a.b(BindMContactUI.this, paramAnonymousMenuItem, 30766, true);
            continue;
            paramAnonymousMenuItem = com.tencent.mm.az.b.by(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(a.i.country_code));
            bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VuM, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            k = a.i.license_read_url;
            str = LocaleUtil.getApplicationLanguage();
            i = j;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(k, new Object[] { str, paramAnonymousMenuItem, "bindMobileA", Integer.valueOf(1), Integer.valueOf(i) });
            a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
            continue;
            paramAnonymousMenuItem = com.tencent.mm.az.b.by(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(a.i.country_code));
            bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VuM, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            j = a.i.license_read_url;
            str = LocaleUtil.getApplicationLanguage();
            i = k;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(j, new Object[] { str, paramAnonymousMenuItem, "bindMobileB", Integer.valueOf(1), Integer.valueOf(i) });
            a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
            continue;
            paramAnonymousMenuItem = com.tencent.mm.az.b.by(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(a.i.country_code));
            bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VuM, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            j = a.i.license_read_url;
            str = LocaleUtil.getApplicationLanguage();
            i = m;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(j, new Object[] { str, paramAnonymousMenuItem, "bindMobileC", Integer.valueOf(1), Integer.valueOf(i) });
            a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
            continue;
            paramAnonymousMenuItem = com.tencent.mm.az.b.by(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(a.i.country_code));
            bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VuM, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            j = a.i.license_read_url;
            str = LocaleUtil.getApplicationLanguage();
            i = n;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(j, new Object[] { str, paramAnonymousMenuItem, "bindMobileD", Integer.valueOf(1), Integer.valueOf(i) });
            a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
          }
        }
      });
      this.mSr.requestFocus();
      setBackBtn(new BindMContactUI.4(this));
      this.mSs.setOnClickListener(new BindMContactUI.5(this));
      AppMethodBeat.o(109899);
      return;
      label466:
      str2 = "86";
      str1 = str3;
      break;
      com.tencent.mm.kernel.h.aHJ().postAtFrontOfWorker(new BindMContactUI.2(this));
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
      this.lSz = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.lSz.equals("")) {
        this.mSu.setText(this.lSz);
      }
      if (this.countryCode.equals("")) {
        break;
      }
      this.mSv.setText("+" + this.countryCode);
      break;
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("agree_privacy"))) {
          aar(this.fLC);
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
                a.b(BindMContactUI.this, str, 30765, true);
                com.tencent.mm.ui.base.b.lc(BindMContactUI.this);
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
              aar(this.fLC);
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
    this.lSz = Util.nullAs(getIntent().getStringExtra("country_name"), "");
    this.countryCode = Util.nullAs(getIntent().getStringExtra("couttry_code"), "");
    this.mSw = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    initView();
    AppMethodBeat.o(109895);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109896);
    super.onDestroy();
    if (this.mSa != null) {
      this.mSa.recycle();
    }
    AppMethodBeat.o(109896);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109897);
    if (paramInt == 4)
    {
      bxx();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI
 * JD-Core Version:    0.7.0.1
 */