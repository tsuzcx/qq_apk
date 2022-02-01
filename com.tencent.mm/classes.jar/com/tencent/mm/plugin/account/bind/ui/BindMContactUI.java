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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class BindMContactUI
  extends MMWizardActivity
{
  private String countryCode = null;
  private String dAs;
  private int fromScene = 0;
  private String ihe = null;
  private boolean jbR = false;
  private i jcE;
  private EditText jcT;
  private LinearLayout jcU;
  private TextView jcV;
  private TextView jcW;
  private TextView jcX;
  private String jcY = null;
  
  private void JM(final String paramString)
  {
    AppMethodBeat.i(109901);
    if (this.jcE == null)
    {
      i.b localb = i.b.jjS;
      if (this.fromScene == 3) {
        localb = i.b.jjT;
      }
      this.jcE = new i(localb, this, new i.a()
      {
        public final void i(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(109894);
          if (paramAnonymousInt == 1)
          {
            ae.i("MicroMsg.BindMContactUI", "next to BindMContactVerifyUI for bind mobile");
            paramAnonymousBundle = new Intent(BindMContactUI.this, BindMContactVerifyUI.class);
            paramAnonymousBundle.putExtra("bindmcontact_mobile", paramString);
            paramAnonymousBundle.putExtra("KEnterFromBanner", BindMContactUI.i(BindMContactUI.this));
            paramAnonymousBundle.putExtra("bind_scene", BindMContactUI.j(BindMContactUI.this));
            MMWizardActivity.al(BindMContactUI.this, paramAnonymousBundle);
          }
          AppMethodBeat.o(109894);
        }
      });
    }
    this.jcE.Ko(paramString);
    AppMethodBeat.o(109901);
  }
  
  private void aSB()
  {
    AppMethodBeat.i(109898);
    if ((this.fromScene != 0) && (this.fromScene != 3))
    {
      JxE.clear();
      acs(1);
      AppMethodBeat.o(109898);
      return;
    }
    int i;
    if (this.fromScene == 3)
    {
      i = 2131756466;
      if (this.fromScene != 3) {
        break label89;
      }
    }
    label89:
    for (int j = 2131756468;; j = 2131756467)
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
      i = 2131756465;
      break;
    }
  }
  
  public int getLayoutId()
  {
    return 2131493179;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109899);
    this.jbR = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    ae.i("MicroMsg.BindMContactUI", "bindScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    this.jcT = ((EditText)findViewById(2131297244));
    this.jcU = ((LinearLayout)findViewById(2131298805));
    this.jcW = ((TextView)findViewById(2131298807));
    this.jcX = ((TextView)findViewById(2131298803));
    this.jcV = ((TextView)findViewById(2131304622));
    String str3;
    String str1;
    String str2;
    if (this.fromScene == 3)
    {
      str3 = (String)g.ajR().ajA().get(6, null);
      if (!bu.isNullOrNil(str3))
      {
        if (!str3.startsWith("+")) {
          break label435;
        }
        String str4 = bb.apd(str3);
        str1 = str3;
        str2 = str4;
        if (!bu.isNullOrNil(str4))
        {
          str1 = str3.substring(str4.length() + 1);
          str2 = str4;
        }
        new bb();
        str1 = bb.formatNumber(str2, str1);
        this.jcV.setText(getString(2131756454, new Object[] { str1 }));
      }
    }
    if (!bu.isNullOrNil(this.ihe)) {
      this.jcW.setText(this.ihe);
    }
    if (bu.isNullOrNil(this.countryCode))
    {
      this.countryCode = getString(2131757951);
      if (this.countryCode.startsWith("+")) {
        this.countryCode = this.countryCode.substring(1);
      }
    }
    this.jcX.setText("+" + this.countryCode);
    if ((this.jcY != null) && (!this.jcY.equals("")))
    {
      this.jcT.setText(this.jcY);
      this.jcT.setSelection(this.jcY.length());
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(2131755830), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          int j = 0;
          int k = 0;
          int m = 0;
          int n = 0;
          int i = 0;
          AppMethodBeat.i(109890);
          BindMContactUI.a(BindMContactUI.this, BindMContactUI.c(BindMContactUI.this).getText().toString().trim() + bu.apl(BindMContactUI.b(BindMContactUI.this).getText().toString()));
          if ((!com.tencent.mm.pluginsdk.b.aMA(BindMContactUI.d(BindMContactUI.this))) || (bu.apl(BindMContactUI.b(BindMContactUI.this).getText().toString()).length() <= 0))
          {
            h.l(BindMContactUI.this, 2131756478, 2131755906);
            AppMethodBeat.o(109890);
            return true;
          }
          int i1 = BindMContactUI.e(BindMContactUI.this);
          ae.i("MicroMsg.BindMContactUI", "nextStep %d", new Object[] { Integer.valueOf(i1) });
          switch (i1)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(109890);
            return true;
            h.c(BindMContactUI.this, BindMContactUI.this.getString(2131756491), "", true);
            continue;
            ae.i("MicroMsg.BindMContactUI", "do next, send sms to self");
            BindMContactUI.b(BindMContactUI.this, BindMContactUI.d(BindMContactUI.this));
            continue;
            paramAnonymousMenuItem = com.tencent.mm.aw.b.bs("86", BindMContactUI.this.getString(2131757950));
            boolean bool = ((Boolean)g.ajR().ajA().get(am.a.IXZ, Boolean.FALSE)).booleanValue();
            BindMContactUI localBindMContactUI = BindMContactUI.this;
            String str = ad.fom();
            if (bool) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousMenuItem = localBindMContactUI.getString(2131760685, new Object[] { str, paramAnonymousMenuItem, "login", Integer.valueOf(1), Integer.valueOf(i) });
              com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
              break;
            }
            paramAnonymousMenuItem = com.tencent.mm.aw.b.bs(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(2131757950));
            bool = ((Boolean)g.ajR().ajA().get(am.a.IXZ, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = ad.fom();
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131760685, new Object[] { str, paramAnonymousMenuItem, "login", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30766, true);
            continue;
            paramAnonymousMenuItem = com.tencent.mm.aw.b.bs(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(2131757950));
            bool = ((Boolean)g.ajR().ajA().get(am.a.IXZ, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = ad.fom();
            i = j;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131760685, new Object[] { str, paramAnonymousMenuItem, "bindMobileA", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
            continue;
            paramAnonymousMenuItem = com.tencent.mm.aw.b.bs(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(2131757950));
            bool = ((Boolean)g.ajR().ajA().get(am.a.IXZ, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = ad.fom();
            i = k;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131760685, new Object[] { str, paramAnonymousMenuItem, "bindMobileB", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
            continue;
            paramAnonymousMenuItem = com.tencent.mm.aw.b.bs(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(2131757950));
            bool = ((Boolean)g.ajR().ajA().get(am.a.IXZ, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = ad.fom();
            i = m;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131760685, new Object[] { str, paramAnonymousMenuItem, "bindMobileC", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
            continue;
            paramAnonymousMenuItem = com.tencent.mm.aw.b.bs(BindMContactUI.f(BindMContactUI.this), BindMContactUI.this.getString(2131757950));
            bool = ((Boolean)g.ajR().ajA().get(am.a.IXZ, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = ad.fom();
            i = n;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131760685, new Object[] { str, paramAnonymousMenuItem, "bindMobileD", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
          }
        }
      });
      this.jcT.requestFocus();
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
      this.jcU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109892);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMContactUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMContactUI.h(BindMContactUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMContactUI.f(BindMContactUI.this));
          com.tencent.mm.plugin.account.a.a.iUz.b(paramAnonymousView, BindMContactUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109892);
        }
      });
      AppMethodBeat.o(109899);
      return;
      label435:
      str2 = "86";
      str1 = str3;
      break;
      g.ajU().a(new ar.a()
      {
        String fTm;
        
        public final boolean aEC()
        {
          AppMethodBeat.i(109888);
          AppMethodBeat.o(109888);
          return true;
        }
        
        public final boolean aED()
        {
          AppMethodBeat.i(109887);
          if (bu.isNullOrNil(BindMContactUI.b(BindMContactUI.this).getText().trim()))
          {
            if (bu.isNullOrNil(this.fTm)) {
              break label85;
            }
            BindMContactUI.b(BindMContactUI.this).setText(this.fTm);
            BindMContactUI.b(BindMContactUI.this).setSelection(this.fTm.length());
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
      this.ihe = bu.bI(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bu.bI(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.ihe.equals("")) {
        this.jcW.setText(this.ihe);
      }
      if (this.countryCode.equals("")) {
        break;
      }
      this.jcX.setText("+" + this.countryCode);
      break;
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("agree_privacy"))) {
          JM(this.dAs);
        }
        AppMethodBeat.o(109900);
        return;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getBundleExtra("result_data");
          if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("agree_privacy"))) {
            ar.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(109893);
                String str = BindMContactUI.this.getString(2131760031, new Object[] { ad.fom() });
                com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, str, 30765, true);
                com.tencent.mm.ui.base.b.km(BindMContactUI.this);
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
              JM(this.dAs);
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
    setMMTitle(2131756487);
    this.ihe = bu.bI(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bu.bI(getIntent().getStringExtra("couttry_code"), "");
    this.jcY = bu.bI(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    initView();
    AppMethodBeat.o(109895);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109896);
    super.onDestroy();
    if (this.jcE != null) {
      this.jcE.recycle();
    }
    AppMethodBeat.o(109896);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109897);
    if (paramInt == 4)
    {
      aSB();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI
 * JD-Core Version:    0.7.0.1
 */