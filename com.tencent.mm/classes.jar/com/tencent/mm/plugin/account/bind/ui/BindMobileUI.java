package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.b;
import com.tencent.mm.ax.b.a;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMobileUI
  extends MMWizardActivity
{
  private String countryCode = null;
  private String dpO;
  private TextView fQp;
  private String hkO = null;
  private EditText igI;
  private LinearLayout igJ;
  private TextView igL;
  private TextView igM;
  private String igN = null;
  private i igt;
  private BindWordingContent ihc;
  private int ihd;
  private Button ihj;
  private TextView ihk;
  private TextView ihl;
  private CheckBox ihm;
  private CheckBox ihn;
  private LinearLayout iho;
  private ImageView ihp;
  private boolean ihq;
  
  public int getLayoutId()
  {
    return 2131493173;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109946);
    this.igI = ((EditText)findViewById(2131297244));
    this.igJ = ((LinearLayout)findViewById(2131298805));
    this.igL = ((TextView)findViewById(2131298807));
    this.igM = ((TextView)findViewById(2131298803));
    this.fQp = ((TextView)findViewById(2131297248));
    this.ihj = ((Button)findViewById(2131297232));
    this.ihk = ((TextView)findViewById(2131297245));
    this.fQp.setText(getString(2131756480));
    this.ihl = ((TextView)findViewById(2131297233));
    this.iho = ((LinearLayout)findViewById(2131297247));
    this.ihn = ((CheckBox)findViewById(2131297242));
    this.ihm = ((CheckBox)findViewById(2131297241));
    this.ihp = ((ImageView)findViewById(2131297243));
    if (this.ihc != null)
    {
      if ((this.ihc.title != null) && (this.ihc.title.length() > 0)) {
        this.fQp.setText(this.ihc.title);
      }
      if ((this.ihc.content != null) && (this.ihc.content.length() > 0)) {
        this.ihl.setText(this.ihc.content);
      }
    }
    switch (this.ihc.hrf.intValue())
    {
    default: 
      switch (this.ihd)
      {
      default: 
        label324:
        if ((bt.isNullOrNil(this.hkO)) && (bt.isNullOrNil(this.countryCode))) {}
        break;
      }
      break;
    }
    for (;;)
    {
      if ((this.hkO != null) && (!this.hkO.equals(""))) {
        this.igL.setText(this.hkO);
      }
      if ((this.countryCode != null) && (!this.countryCode.equals(""))) {
        this.igM.setText("+" + this.countryCode);
      }
      if ((this.igN != null) && (!this.igN.equals(""))) {
        this.igI.setText(this.igN);
      }
      this.ihj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109937);
          if ((BindMobileUI.a(BindMobileUI.this).getText().toString() == null) || (BindMobileUI.a(BindMobileUI.this).getText().toString().length() == 0))
          {
            Toast.makeText(BindMobileUI.this, BindMobileUI.this.getString(2131756461), 0).show();
            AppMethodBeat.o(109937);
            return;
          }
          BindMobileUI.b(BindMobileUI.this, BindMobileUI.b(BindMobileUI.this).getText().toString().trim() + bt.aeE(BindMobileUI.a(BindMobileUI.this).getText().toString()));
          ad.i("MicroMsg.BindMContactUI", "do next, send sms to self");
          BindMobileUI.c(BindMobileUI.this, BindMobileUI.c(BindMobileUI.this));
          AppMethodBeat.o(109937);
        }
      });
      this.ihk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109938);
          BindMobileUI.d(BindMobileUI.this);
          AppMethodBeat.o(109938);
        }
      });
      if (this.ihq)
      {
        setMMTitle(2131756448);
        this.ihp.setVisibility(8);
        this.fQp.setText(2131756469);
        this.iho.setVisibility(8);
        this.ihn.setVisibility(8);
        this.ihn.setChecked(false);
        this.ihm.setVisibility(0);
        this.ihm.setChecked(false);
        this.ihl.setVisibility(8);
        this.ihl.setText(getString(2131756450));
        this.ihk.setVisibility(8);
        this.ihj.setText(2131756448);
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(109939);
            BindMobileUI.e(BindMobileUI.this);
            AppMethodBeat.o(109939);
            return true;
          }
        });
      }
      this.igJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109940);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          a.hYt.b(paramAnonymousView, BindMobileUI.this);
          AppMethodBeat.o(109940);
        }
      });
      this.igJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109941);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          a.hYt.b(paramAnonymousView, BindMobileUI.this);
          AppMethodBeat.o(109941);
        }
      });
      AppMethodBeat.o(109946);
      return;
      this.ihp.setImageResource(2131231176);
      break;
      this.ihp.setImageResource(2131231179);
      break;
      this.ihp.setImageResource(2131231177);
      break;
      this.iho.setVisibility(0);
      this.ihn.setVisibility(0);
      this.ihl.setVisibility(8);
      break label324;
      this.iho.setVisibility(8);
      this.ihn.setVisibility(8);
      this.ihl.setVisibility(0);
      break label324;
      Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
      ad.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()".concat(String.valueOf(localObject)));
      if (bt.isNullOrNil((String)localObject))
      {
        ad.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
      }
      else
      {
        localObject = b.bh((String)localObject, getString(2131757950));
        if (localObject == null)
        {
          ad.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
        }
        else
        {
          this.hkO = ((b.a)localObject).hkO;
          this.countryCode = ((b.a)localObject).hkN;
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(109947);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109947);
      return;
      this.hkO = bt.by(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bt.by(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.hkO.equals("")) {
        this.igL.setText(this.hkO);
      }
      if (!this.countryCode.equals("")) {
        this.igM.setText("+" + this.countryCode);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109943);
    super.onCreate(paramBundle);
    setMMTitle(2131756484);
    this.hkO = bt.by(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bt.by(getIntent().getStringExtra("couttry_code"), "");
    this.igN = bt.by(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.ihc = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.ihd = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.ihq = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
    initView();
    AppMethodBeat.o(109943);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109944);
    super.onDestroy();
    if (this.igt != null) {
      this.igt.recycle();
    }
    AppMethodBeat.o(109944);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109945);
    if (paramInt == 4)
    {
      Xo(1);
      AppMethodBeat.o(109945);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(109945);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileUI
 * JD-Core Version:    0.7.0.1
 */