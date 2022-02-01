package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class BindMContactUI
  extends MMWizardActivity
{
  private String countryCode = null;
  private String dSf;
  private int fromScene = 0;
  private boolean jZU = false;
  private String jbZ = null;
  private i kaH;
  private EditText kaW;
  private LinearLayout kaX;
  private TextView kaY;
  private TextView kaZ;
  private TextView kba;
  private String kbb = null;
  
  private void SL(final String paramString)
  {
    AppMethodBeat.i(109901);
    if (this.kaH == null)
    {
      i.b localb = i.b.khU;
      if (this.fromScene == 3) {
        localb = i.b.khV;
      }
      this.kaH = new i(localb, this, new i.a()
      {
        public final void h(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(109894);
          if (paramAnonymousInt == 1)
          {
            Log.i("MicroMsg.BindMContactUI", "next to BindMContactVerifyUI for bind mobile");
            paramAnonymousBundle = new Intent(BindMContactUI.this, BindMContactVerifyUI.class);
            paramAnonymousBundle.putExtra("bindmcontact_mobile", paramString);
            paramAnonymousBundle.putExtra("KEnterFromBanner", BindMContactUI.i(BindMContactUI.this));
            paramAnonymousBundle.putExtra("bind_scene", BindMContactUI.j(BindMContactUI.this));
            MMWizardActivity.ay(BindMContactUI.this, paramAnonymousBundle);
          }
          AppMethodBeat.o(109894);
        }
      });
    }
    this.kaH.Tm(paramString);
    AppMethodBeat.o(109901);
  }
  
  private void bno()
  {
    AppMethodBeat.i(109898);
    if ((this.fromScene != 0) && (this.fromScene != 3))
    {
      OHY.clear();
      ala(1);
      AppMethodBeat.o(109898);
      return;
    }
    int i;
    if (this.fromScene == 3)
    {
      i = 2131756602;
      if (this.fromScene != 3) {
        break label89;
      }
    }
    label89:
    for (int j = 2131756604;; j = 2131756603)
    {
      h.a(this, i, j, new DialogInterface.OnClickListener()
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
      i = 2131756601;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493225;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109899);
    this.jZU = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    Log.i("MicroMsg.BindMContactUI", "bindScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    this.kaW = ((EditText)findViewById(2131297399));
    this.kaX = ((LinearLayout)findViewById(2131299269));
    this.kaZ = ((TextView)findViewById(2131299271));
    this.kba = ((TextView)findViewById(2131299266));
    this.kaY = ((TextView)findViewById(2131307674));
    String str3;
    String str1;
    String str2;
    if (this.fromScene == 3)
    {
      str3 = (String)g.aAh().azQ().get(6, null);
      if (!Util.isNullOrNil(str3))
      {
        if (!str3.startsWith("+")) {
          break label464;
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
        this.kaY.setText(getString(2131756590, new Object[] { str1 }));
      }
    }
    if (WeChatSomeFeatureSwitch.onlyUSMobile())
    {
      this.countryCode = "1";
      this.jbZ = com.tencent.mm.aw.b.bt(this.countryCode, getString(2131758198));
    }
    if (!Util.isNullOrNil(this.jbZ)) {
      this.kaZ.setText(this.jbZ);
    }
    if (Util.isNullOrNil(this.countryCode))
    {
      this.countryCode = getString(2131758199);
      if (this.countryCode.startsWith("+")) {
        this.countryCode = this.countryCode.substring(1);
      }
    }
    this.kba.setText("+" + this.countryCode);
    if ((this.kbb != null) && (!this.kbb.equals("")))
    {
      this.kaW.setText(this.kbb);
      this.kaW.setSelection(this.kbb.length());
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(2131755916), new MenuItem.OnMenuItemClickListener()
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
          if ((!com.tencent.mm.pluginsdk.b.bcT(BindMContactUI.d(BindMContactUI.this))) || (Util.trimPhoneNumber(BindMContactUI.b(BindMContactUI.this).getText().toString()).length() <= 0))
          {
            h.n(BindMContactUI.this, 2131756614, 2131755998);
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
            h.c(BindMContactUI.this, BindMContactUI.this.getString(2131756627), "", true);
            continue;
            Log.i("MicroMsg.BindMContactUI", "do next, send sms to self");
            BindMContactUI.b(BindMContactUI.this, BindMContactUI.d(BindMContactUI.this));
            continue;
            paramAnonymousMenuItem = com.tencent.mm.aw.b.bu("86", BindMContactUI.this.getString(2131758198));
            boolean bool = ((Boolean)g.aAh().azQ().get(ar.a.Ogw, Boolean.FALSE)).booleanValue();
            BindMContactUI localBindMContactUI = BindMContactUI.this;
            String str = LocaleUtil.getApplicationLanguage();
            if (bool) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousMenuItem = localBindMContactUI.getString(2131762219, new Object[] { str, paramAnonymousMenuItem, "login", Integer.valueOf(1), Integer.valueOf(i) });
              com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
              break;
            }
            paramAnonymousMenuItem = com.tencent.mm.aw.b.bu(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(2131758198));
            bool = ((Boolean)g.aAh().azQ().get(ar.a.Ogw, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = LocaleUtil.getApplicationLanguage();
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131762219, new Object[] { str, paramAnonymousMenuItem, "login", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30766, true);
            continue;
            paramAnonymousMenuItem = com.tencent.mm.aw.b.bu(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(2131758198));
            bool = ((Boolean)g.aAh().azQ().get(ar.a.Ogw, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = LocaleUtil.getApplicationLanguage();
            i = j;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131762219, new Object[] { str, paramAnonymousMenuItem, "bindMobileA", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
            continue;
            paramAnonymousMenuItem = com.tencent.mm.aw.b.bu(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(2131758198));
            bool = ((Boolean)g.aAh().azQ().get(ar.a.Ogw, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = LocaleUtil.getApplicationLanguage();
            i = k;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131762219, new Object[] { str, paramAnonymousMenuItem, "bindMobileB", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
            continue;
            paramAnonymousMenuItem = com.tencent.mm.aw.b.bu(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(2131758198));
            bool = ((Boolean)g.aAh().azQ().get(ar.a.Ogw, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = LocaleUtil.getApplicationLanguage();
            i = m;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131762219, new Object[] { str, paramAnonymousMenuItem, "bindMobileC", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
            continue;
            paramAnonymousMenuItem = com.tencent.mm.aw.b.bu(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(2131758198));
            bool = ((Boolean)g.aAh().azQ().get(ar.a.Ogw, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = LocaleUtil.getApplicationLanguage();
            i = n;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131762219, new Object[] { str, paramAnonymousMenuItem, "bindMobileD", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
          }
        }
      });
      this.kaW.requestFocus();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(109891);
          BindMContactUI.g(BindMContactUI.this);
          AppMethodBeat.o(109891);
          return true;
        }
      });
      this.kaX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109892);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMContactUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMContactUI.h(BindMContactUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMContactUI.f(BindMContactUI.this));
          com.tencent.mm.plugin.account.a.a.jRt.b(paramAnonymousView, BindMContactUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109892);
        }
      });
      AppMethodBeat.o(109899);
      return;
      label464:
      str2 = "86";
      str1 = str3;
      break;
      g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
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
      this.jbZ = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.jbZ.equals("")) {
        this.kaZ.setText(this.jbZ);
      }
      if (this.countryCode.equals("")) {
        break;
      }
      this.kba.setText("+" + this.countryCode);
      break;
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("agree_privacy"))) {
          SL(this.dSf);
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
                String str = BindMContactUI.this.getString(2131761409, new Object[] { LocaleUtil.getApplicationLanguage() });
                com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, str, 30765, true);
                com.tencent.mm.ui.base.b.ke(BindMContactUI.this);
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
              SL(this.dSf);
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
    setMMTitle(2131756623);
    this.jbZ = Util.nullAs(getIntent().getStringExtra("country_name"), "");
    this.countryCode = Util.nullAs(getIntent().getStringExtra("couttry_code"), "");
    this.kbb = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    initView();
    AppMethodBeat.o(109895);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109896);
    super.onDestroy();
    if (this.kaH != null) {
      this.kaH.recycle();
    }
    AppMethodBeat.o(109896);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109897);
    if (paramInt == 4)
    {
      bno();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI
 * JD-Core Version:    0.7.0.1
 */