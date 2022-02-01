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
import com.tencent.mm.aw.b;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMobileUI
  extends MMWizardActivity
{
  private String countryCode = null;
  private String dnz;
  private TextView fUk;
  private String hLr = null;
  private i iGC;
  private EditText iGR;
  private LinearLayout iGS;
  private TextView iGU;
  private TextView iGV;
  private String iGW = null;
  private BindWordingContent iHk;
  private int iHl;
  private Button iHr;
  private TextView iHs;
  private TextView iHt;
  private CheckBox iHu;
  private CheckBox iHv;
  private LinearLayout iHw;
  private ImageView iHx;
  private boolean iHy;
  
  public int getLayoutId()
  {
    return 2131493173;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109946);
    this.iGR = ((EditText)findViewById(2131297244));
    this.iGS = ((LinearLayout)findViewById(2131298805));
    this.iGU = ((TextView)findViewById(2131298807));
    this.iGV = ((TextView)findViewById(2131298803));
    this.fUk = ((TextView)findViewById(2131297248));
    this.iHr = ((Button)findViewById(2131297232));
    this.iHs = ((TextView)findViewById(2131297245));
    this.fUk.setText(getString(2131756480));
    this.iHt = ((TextView)findViewById(2131297233));
    this.iHw = ((LinearLayout)findViewById(2131297247));
    this.iHv = ((CheckBox)findViewById(2131297242));
    this.iHu = ((CheckBox)findViewById(2131297241));
    this.iHx = ((ImageView)findViewById(2131297243));
    if (this.iHk != null)
    {
      if ((this.iHk.title != null) && (this.iHk.title.length() > 0)) {
        this.fUk.setText(this.iHk.title);
      }
      if ((this.iHk.content != null) && (this.iHk.content.length() > 0)) {
        this.iHt.setText(this.iHk.content);
      }
    }
    switch (this.iHk.hRH.intValue())
    {
    default: 
      switch (this.iHl)
      {
      default: 
        label324:
        if ((bs.isNullOrNil(this.hLr)) && (bs.isNullOrNil(this.countryCode))) {}
        break;
      }
      break;
    }
    for (;;)
    {
      if ((this.hLr != null) && (!this.hLr.equals(""))) {
        this.iGU.setText(this.hLr);
      }
      if ((this.countryCode != null) && (!this.countryCode.equals(""))) {
        this.iGV.setText("+" + this.countryCode);
      }
      if ((this.iGW != null) && (!this.iGW.equals(""))) {
        this.iGR.setText(this.iGW);
      }
      this.iHr.setOnClickListener(new View.OnClickListener()
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
          BindMobileUI.b(BindMobileUI.this, BindMobileUI.b(BindMobileUI.this).getText().toString().trim() + bs.ajw(BindMobileUI.a(BindMobileUI.this).getText().toString()));
          ac.i("MicroMsg.BindMContactUI", "do next, send sms to self");
          BindMobileUI.c(BindMobileUI.this, BindMobileUI.c(BindMobileUI.this));
          AppMethodBeat.o(109937);
        }
      });
      this.iHs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109938);
          BindMobileUI.d(BindMobileUI.this);
          AppMethodBeat.o(109938);
        }
      });
      if (this.iHy)
      {
        setMMTitle(2131756448);
        this.iHx.setVisibility(8);
        this.fUk.setText(2131756469);
        this.iHw.setVisibility(8);
        this.iHv.setVisibility(8);
        this.iHv.setChecked(false);
        this.iHu.setVisibility(0);
        this.iHu.setChecked(false);
        this.iHt.setVisibility(8);
        this.iHt.setText(getString(2131756450));
        this.iHs.setVisibility(8);
        this.iHr.setText(2131756448);
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
      this.iGS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109940);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          a.iyx.b(paramAnonymousView, BindMobileUI.this);
          AppMethodBeat.o(109940);
        }
      });
      this.iGS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109941);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          a.iyx.b(paramAnonymousView, BindMobileUI.this);
          AppMethodBeat.o(109941);
        }
      });
      AppMethodBeat.o(109946);
      return;
      this.iHx.setImageResource(2131231176);
      break;
      this.iHx.setImageResource(2131231179);
      break;
      this.iHx.setImageResource(2131231177);
      break;
      this.iHw.setVisibility(0);
      this.iHv.setVisibility(0);
      this.iHt.setVisibility(8);
      break label324;
      this.iHw.setVisibility(8);
      this.iHv.setVisibility(8);
      this.iHt.setVisibility(0);
      break label324;
      Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
      ac.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()".concat(String.valueOf(localObject)));
      if (bs.isNullOrNil((String)localObject))
      {
        ac.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
      }
      else
      {
        localObject = b.bp((String)localObject, getString(2131757950));
        if (localObject == null)
        {
          ac.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
        }
        else
        {
          this.hLr = ((b.a)localObject).hLr;
          this.countryCode = ((b.a)localObject).hLq;
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
      this.hLr = bs.bG(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bs.bG(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.hLr.equals("")) {
        this.iGU.setText(this.hLr);
      }
      if (!this.countryCode.equals("")) {
        this.iGV.setText("+" + this.countryCode);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109943);
    super.onCreate(paramBundle);
    setMMTitle(2131756484);
    this.hLr = bs.bG(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bs.bG(getIntent().getStringExtra("couttry_code"), "");
    this.iGW = bs.bG(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.iHk = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.iHl = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.iHy = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
    initView();
    AppMethodBeat.o(109943);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109944);
    super.onDestroy();
    if (this.iGC != null) {
      this.iGC.recycle();
    }
    AppMethodBeat.o(109944);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109945);
    if (paramInt == 4)
    {
      ZA(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileUI
 * JD-Core Version:    0.7.0.1
 */