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
import com.tencent.mm.az.b.a;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMobileUI
  extends MMWizardActivity
{
  private String countryCode = null;
  private String fLC;
  private TextView jMg;
  private String lSz = null;
  private BindWordingContent mSN;
  private int mSO;
  private Button mSU;
  private TextView mSV;
  private TextView mSW;
  private CheckBox mSX;
  private CheckBox mSY;
  private LinearLayout mSZ;
  private i mSa;
  private EditText mSr;
  private LinearLayout mSs;
  private TextView mSu;
  private TextView mSv;
  private String mSw = null;
  private ImageView mTa;
  private boolean mTb;
  
  public int getLayoutId()
  {
    return a.f.bind_mcontact_input_phonenum;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109946);
    this.mSr = ((EditText)findViewById(a.e.bind_mcontact_mobile));
    this.mSs = ((LinearLayout)findViewById(a.e.country_code_ll));
    this.mSu = ((TextView)findViewById(a.e.country_name));
    this.mSv = ((TextView)findViewById(a.e.country_code));
    this.jMg = ((TextView)findViewById(a.e.bind_mcontact_title_tv));
    this.mSU = ((Button)findViewById(a.e.bind_m_contact_bind_mobile));
    this.mSV = ((TextView)findViewById(a.e.bind_mcontact_skip_bind));
    this.jMg.setText(getString(a.i.bind_mcontact_security_bander_hint));
    this.mSW = ((TextView)findViewById(a.e.bind_m_contact_bind_mobile_hint));
    this.mSZ = ((LinearLayout)findViewById(a.e.bind_mcontact_sync_contact_cb_ll));
    this.mSY = ((CheckBox)findViewById(a.e.bind_mcontact_agree_cb_recom_friend));
    this.mSX = ((CheckBox)findViewById(a.e.bind_mcontact_agree_cb));
    this.mTa = ((ImageView)findViewById(a.e.bind_mcontact_icon));
    if (this.mSN != null)
    {
      if ((this.mSN.title != null) && (this.mSN.title.length() > 0)) {
        this.jMg.setText(this.mSN.title);
      }
      if ((this.mSN.content != null) && (this.mSN.content.length() > 0)) {
        this.mSW.setText(this.mSN.content);
      }
    }
    switch (this.mSN.type.intValue())
    {
    default: 
      switch (this.mSO)
      {
      default: 
        label332:
        if ((Util.isNullOrNil(this.lSz)) && (Util.isNullOrNil(this.countryCode))) {}
        break;
      }
      break;
    }
    for (;;)
    {
      if ((this.lSz != null) && (!this.lSz.equals(""))) {
        this.mSu.setText(this.lSz);
      }
      if ((this.countryCode != null) && (!this.countryCode.equals(""))) {
        this.mSv.setText("+" + this.countryCode);
      }
      if ((this.mSw != null) && (!this.mSw.equals(""))) {
        this.mSr.setText(this.mSw);
      }
      this.mSU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109937);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((BindMobileUI.a(BindMobileUI.this).getText().toString() == null) || (BindMobileUI.a(BindMobileUI.this).getText().toString().length() == 0))
          {
            Toast.makeText(BindMobileUI.this, BindMobileUI.this.getString(a.i.bind_mcontact_err_format), 0).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109937);
            return;
          }
          BindMobileUI.b(BindMobileUI.this, BindMobileUI.b(BindMobileUI.this).getText().toString().trim() + Util.trimPhoneNumber(BindMobileUI.a(BindMobileUI.this).getText().toString()));
          Log.i("MicroMsg.BindMContactUI", "do next, send sms to self");
          BindMobileUI.c(BindMobileUI.this, BindMobileUI.c(BindMobileUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109937);
        }
      });
      this.mSV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109938);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          BindMobileUI.d(BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109938);
        }
      });
      if (this.mTb)
      {
        setMMTitle(a.i.bind_mcontact_bind_for_chatroom_title);
        this.mTa.setVisibility(8);
        this.jMg.setText(a.i.bind_mcontact_for_chatroom_title);
        this.mSZ.setVisibility(8);
        this.mSY.setVisibility(8);
        this.mSY.setChecked(false);
        this.mSX.setVisibility(0);
        this.mSX.setChecked(false);
        this.mSW.setVisibility(8);
        this.mSW.setText(getString(a.i.bind_mcontact_bind_mobile_warnning_hint));
        this.mSV.setVisibility(8);
        this.mSU.setText(a.i.bind_mcontact_bind_for_chatroom_title);
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
      this.mSs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109940);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          com.tencent.mm.plugin.account.sdk.a.mIG.b(paramAnonymousView, BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109940);
        }
      });
      this.mSs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109941);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          com.tencent.mm.plugin.account.sdk.a.mIG.b(paramAnonymousView, BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109941);
        }
      });
      AppMethodBeat.o(109946);
      return;
      this.mTa.setImageResource(a.d.bind_mcontact_protect);
      break;
      this.mTa.setImageResource(a.d.bind_mcontact_warning);
      break;
      this.mTa.setImageResource(a.d.bind_mcontact_reco_friends);
      break;
      this.mSZ.setVisibility(0);
      this.mSY.setVisibility(0);
      this.mSW.setVisibility(8);
      break label332;
      this.mSZ.setVisibility(8);
      this.mSY.setVisibility(8);
      this.mSW.setVisibility(0);
      break label332;
      Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
      Log.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()".concat(String.valueOf(localObject)));
      if (Util.isNullOrNil((String)localObject))
      {
        Log.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
      }
      else
      {
        localObject = com.tencent.mm.az.b.bw((String)localObject, getString(a.i.country_code));
        if (localObject == null)
        {
          Log.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
        }
        else
        {
          this.lSz = ((b.a)localObject).lSz;
          this.countryCode = ((b.a)localObject).lSy;
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
      this.lSz = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.lSz.equals("")) {
        this.mSu.setText(this.lSz);
      }
      if (!this.countryCode.equals("")) {
        this.mSv.setText("+" + this.countryCode);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109943);
    super.onCreate(paramBundle);
    setMMTitle(a.i.bind_mcontact_security_title);
    this.lSz = Util.nullAs(getIntent().getStringExtra("country_name"), "");
    this.countryCode = Util.nullAs(getIntent().getStringExtra("couttry_code"), "");
    this.mSw = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.mSN = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.mSO = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.mTb = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
    initView();
    AppMethodBeat.o(109943);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109944);
    super.onDestroy();
    if (this.mSa != null) {
      this.mSa.recycle();
    }
    AppMethodBeat.o(109944);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109945);
    if (paramInt == 4)
    {
      atX(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileUI
 * JD-Core Version:    0.7.0.1
 */