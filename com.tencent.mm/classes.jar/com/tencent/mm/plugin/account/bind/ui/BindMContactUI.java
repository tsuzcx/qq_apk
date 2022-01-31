package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class BindMContactUI
  extends MMWizardActivity
{
  private String countryCode = null;
  private String czF;
  private String fHT = null;
  private int fromScene = 0;
  private boolean gsE = false;
  private EditText gtH;
  private LinearLayout gtI;
  private TextView gtJ;
  private TextView gtK;
  private TextView gtL;
  private String gtM = null;
  private i gtr;
  
  private void apD()
  {
    AppMethodBeat.i(13471);
    if ((this.fromScene != 0) && (this.fromScene != 3))
    {
      zcw.clear();
      Oi(1);
      AppMethodBeat.o(13471);
      return;
    }
    int i;
    if (this.fromScene == 3)
    {
      i = 2131297574;
      if (this.fromScene != 3) {
        break label92;
      }
    }
    label92:
    for (int j = 2131297576;; j = 2131297575)
    {
      h.a(this, i, j, new BindMContactUI.1(this), null);
      AppMethodBeat.o(13471);
      return;
      i = 2131297573;
      break;
    }
  }
  
  private void wP(String paramString)
  {
    AppMethodBeat.i(13474);
    if (this.gtr == null)
    {
      i.b localb = i.b.gAx;
      if (this.fromScene == 3) {
        localb = i.b.gAy;
      }
      this.gtr = new i(localb, this, new BindMContactUI.7(this, paramString));
    }
    this.gtr.xr(paramString);
    AppMethodBeat.o(13474);
  }
  
  public int getLayoutId()
  {
    return 2130968847;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13472);
    this.gsE = getIntent().getBooleanExtra("KEnterFromBanner", false);
    this.fromScene = getIntent().getIntExtra("bind_scene", 0);
    ab.i("MicroMsg.BindMContactUI", "bindScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    this.gtH = ((EditText)findViewById(2131821768));
    this.gtI = ((LinearLayout)findViewById(2131821765));
    this.gtK = ((TextView)findViewById(2131821767));
    this.gtL = ((TextView)findViewById(2131821766));
    this.gtJ = ((TextView)findViewById(2131821801));
    String str3;
    String str1;
    String str2;
    if (this.fromScene == 3)
    {
      str3 = (String)g.RL().Ru().get(6, null);
      if (!bo.isNullOrNil(str3))
      {
        if (!str3.startsWith("+")) {
          break label435;
        }
        String str4 = av.RC(str3);
        str1 = str3;
        str2 = str4;
        if (!bo.isNullOrNil(str4))
        {
          str1 = str3.substring(str4.length() + 1);
          str2 = str4;
        }
        new av();
        str1 = av.formatNumber(str2, str1);
        this.gtJ.setText(getString(2131297562, new Object[] { str1 }));
      }
    }
    if (!bo.isNullOrNil(this.fHT)) {
      this.gtK.setText(this.fHT);
    }
    if (bo.isNullOrNil(this.countryCode))
    {
      this.countryCode = getString(2131298872);
      if (this.countryCode.startsWith("+")) {
        this.countryCode = this.countryCode.substring(1);
      }
    }
    this.gtL.setText("+" + this.countryCode);
    if ((this.gtM != null) && (!this.gtM.equals("")))
    {
      this.gtH.setText(this.gtM);
      this.gtH.setSelection(this.gtM.length());
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(2131297013), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          int j = 0;
          int k = 0;
          int m = 0;
          int n = 0;
          int i = 0;
          AppMethodBeat.i(13463);
          BindMContactUI.a(BindMContactUI.this, BindMContactUI.d(BindMContactUI.this).getText().toString().trim() + bo.RK(BindMContactUI.b(BindMContactUI.this).getText().toString()));
          if ((!com.tencent.mm.pluginsdk.a.akS(BindMContactUI.e(BindMContactUI.this))) || (bo.RK(BindMContactUI.b(BindMContactUI.this).getText().toString()).length() <= 0))
          {
            h.h(BindMContactUI.this, 2131297586, 2131297087);
            AppMethodBeat.o(13463);
            return true;
          }
          int i1 = BindMContactUI.f(BindMContactUI.this);
          ab.i("MicroMsg.BindMContactUI", "nextStep %d", new Object[] { Integer.valueOf(i1) });
          switch (i1)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(13463);
            return true;
            h.b(BindMContactUI.this, BindMContactUI.this.getString(2131297599), "", true);
            continue;
            ab.i("MicroMsg.BindMContactUI", "do next, send sms to self");
            BindMContactUI.b(BindMContactUI.this, BindMContactUI.e(BindMContactUI.this));
            continue;
            paramAnonymousMenuItem = b.m(BindMContactUI.this, BindMContactUI.c(BindMContactUI.this), BindMContactUI.this.getString(2131298871));
            boolean bool = ((Boolean)g.RL().Ru().get(ac.a.yJX, Boolean.FALSE)).booleanValue();
            BindMContactUI localBindMContactUI = BindMContactUI.this;
            String str = aa.dsG();
            if (bool) {}
            for (i = 1;; i = 0)
            {
              paramAnonymousMenuItem = localBindMContactUI.getString(2131306182, new Object[] { str, paramAnonymousMenuItem, "setting", Integer.valueOf(1), Integer.valueOf(i) });
              com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
              break;
            }
            paramAnonymousMenuItem = b.m(BindMContactUI.this, BindMContactUI.c(BindMContactUI.this), BindMContactUI.this.getString(2131298871));
            bool = ((Boolean)g.RL().Ru().get(ac.a.yJX, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = aa.dsG();
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131306182, new Object[] { str, paramAnonymousMenuItem, "login", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30766, true);
            continue;
            paramAnonymousMenuItem = b.m(BindMContactUI.this, BindMContactUI.c(BindMContactUI.this), BindMContactUI.this.getString(2131298871));
            bool = ((Boolean)g.RL().Ru().get(ac.a.yJX, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = aa.dsG();
            i = j;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131306182, new Object[] { str, paramAnonymousMenuItem, "bindMobileA", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
            continue;
            paramAnonymousMenuItem = b.m(BindMContactUI.this, BindMContactUI.c(BindMContactUI.this), BindMContactUI.this.getString(2131298871));
            bool = ((Boolean)g.RL().Ru().get(ac.a.yJX, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = aa.dsG();
            i = k;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131306182, new Object[] { str, paramAnonymousMenuItem, "bindMobileB", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
            continue;
            paramAnonymousMenuItem = b.m(BindMContactUI.this, BindMContactUI.c(BindMContactUI.this), BindMContactUI.this.getString(2131298871));
            bool = ((Boolean)g.RL().Ru().get(ac.a.yJX, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = aa.dsG();
            i = m;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131306182, new Object[] { str, paramAnonymousMenuItem, "bindMobileC", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
            continue;
            paramAnonymousMenuItem = b.m(BindMContactUI.this, BindMContactUI.c(BindMContactUI.this), BindMContactUI.this.getString(2131298871));
            bool = ((Boolean)g.RL().Ru().get(ac.a.yJX, Boolean.FALSE)).booleanValue();
            localBindMContactUI = BindMContactUI.this;
            str = aa.dsG();
            i = n;
            if (bool) {
              i = 1;
            }
            paramAnonymousMenuItem = localBindMContactUI.getString(2131306182, new Object[] { str, paramAnonymousMenuItem, "bindMobileD", Integer.valueOf(1), Integer.valueOf(i) });
            com.tencent.mm.plugin.account.a.b.a.b(BindMContactUI.this, paramAnonymousMenuItem, 30767, true);
          }
        }
      });
      this.gtH.requestFocus();
      setBackBtn(new BindMContactUI.4(this));
      this.gtI.setOnClickListener(new BindMContactUI.5(this));
      AppMethodBeat.o(13472);
      return;
      label435:
      str2 = "86";
      str1 = str3;
      break;
      g.RO().a(new al.a()
      {
        String ehy;
        
        public final boolean acS()
        {
          AppMethodBeat.i(13461);
          this.ehy = ((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getPhoneNum(BindMContactUI.this, BindMContactUI.c(BindMContactUI.this));
          AppMethodBeat.o(13461);
          return true;
        }
        
        public final boolean acT()
        {
          AppMethodBeat.i(13460);
          if (bo.isNullOrNil(BindMContactUI.b(BindMContactUI.this).getText().trim()))
          {
            if (bo.isNullOrNil(this.ehy)) {
              break label87;
            }
            BindMContactUI.b(BindMContactUI.this).setText(this.ehy);
            BindMContactUI.b(BindMContactUI.this).setSelection(this.ehy.length());
          }
          for (;;)
          {
            AppMethodBeat.o(13460);
            return true;
            label87:
            BindMContactUI.b(BindMContactUI.this).setText("");
          }
        }
        
        public final String toString()
        {
          AppMethodBeat.i(13462);
          String str = super.toString() + "|initView";
          AppMethodBeat.o(13462);
          return str;
        }
      });
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(13473);
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
      AppMethodBeat.o(13473);
      return;
      this.fHT = bo.bf(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bo.bf(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.fHT.equals("")) {
        this.gtK.setText(this.fHT);
      }
      if (this.countryCode.equals("")) {
        break;
      }
      this.gtL.setText("+" + this.countryCode);
      break;
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("agree_privacy"))) {
          wP(this.czF);
        }
        AppMethodBeat.o(13473);
        return;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getBundleExtra("result_data");
          if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("agree_privacy"))) {
            al.p(new BindMContactUI.6(this), 100L);
          }
          AppMethodBeat.o(13473);
          return;
          if (paramIntent != null)
          {
            paramIntent = paramIntent.getBundleExtra("result_data");
            if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("birthdayComfirmOK"))) {
              wP(this.czF);
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13468);
    super.onCreate(paramBundle);
    setMMTitle(2131297595);
    this.fHT = bo.bf(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bo.bf(getIntent().getStringExtra("couttry_code"), "");
    this.gtM = bo.bf(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    initView();
    AppMethodBeat.o(13468);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13469);
    super.onDestroy();
    if (this.gtr != null) {
      this.gtr.recycle();
    }
    AppMethodBeat.o(13469);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(13470);
    if (paramInt == 4)
    {
      apD();
      AppMethodBeat.o(13470);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(13470);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI
 * JD-Core Version:    0.7.0.1
 */