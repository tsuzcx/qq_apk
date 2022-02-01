package com.tencent.mm.plugin.account.bind.ui;

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
import com.tencent.mm.au.b.a;
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
  private String hRk;
  private TextView mll;
  private String oLl = null;
  private i pOH;
  private EditText pOW;
  private LinearLayout pOX;
  private TextView pOZ;
  private Button pPB;
  private TextView pPC;
  private TextView pPD;
  private CheckBox pPE;
  private CheckBox pPF;
  private LinearLayout pPG;
  private ImageView pPH;
  private boolean pPI;
  private TextView pPa;
  private String pPb = null;
  private BindWordingContent pPu;
  private int pPv;
  
  public int getLayoutId()
  {
    return a.f.bind_mcontact_input_phonenum;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109946);
    this.pOW = ((EditText)findViewById(a.e.bind_mcontact_mobile));
    this.pOX = ((LinearLayout)findViewById(a.e.country_code_ll));
    this.pOZ = ((TextView)findViewById(a.e.country_name));
    this.pPa = ((TextView)findViewById(a.e.country_code));
    this.mll = ((TextView)findViewById(a.e.bind_mcontact_title_tv));
    this.pPB = ((Button)findViewById(a.e.bind_m_contact_bind_mobile));
    this.pPC = ((TextView)findViewById(a.e.bind_mcontact_skip_bind));
    this.mll.setText(getString(a.i.bind_mcontact_security_bander_hint));
    this.pPD = ((TextView)findViewById(a.e.bind_m_contact_bind_mobile_hint));
    this.pPG = ((LinearLayout)findViewById(a.e.bind_mcontact_sync_contact_cb_ll));
    this.pPF = ((CheckBox)findViewById(a.e.bind_mcontact_agree_cb_recom_friend));
    this.pPE = ((CheckBox)findViewById(a.e.bind_mcontact_agree_cb));
    this.pPH = ((ImageView)findViewById(a.e.bind_mcontact_icon));
    if (this.pPu != null)
    {
      if ((this.pPu.title != null) && (this.pPu.title.length() > 0)) {
        this.mll.setText(this.pPu.title);
      }
      if ((this.pPu.content != null) && (this.pPu.content.length() > 0)) {
        this.pPD.setText(this.pPu.content);
      }
    }
    switch (this.pPu.type.intValue())
    {
    default: 
      switch (this.pPv)
      {
      default: 
        label332:
        if ((Util.isNullOrNil(this.oLl)) && (Util.isNullOrNil(this.countryCode))) {}
        break;
      }
      break;
    }
    for (;;)
    {
      if ((this.oLl != null) && (!this.oLl.equals(""))) {
        this.pOZ.setText(this.oLl);
      }
      if ((this.countryCode != null) && (!this.countryCode.equals(""))) {
        this.pPa.setText("+" + this.countryCode);
      }
      if ((this.pPb != null) && (!this.pPb.equals(""))) {
        this.pOW.setText(this.pPb);
      }
      this.pPB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109937);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
      this.pPC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109938);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          BindMobileUI.d(BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109938);
        }
      });
      if (this.pPI)
      {
        setMMTitle(a.i.bind_mcontact_bind_for_chatroom_title);
        this.pPH.setVisibility(8);
        this.mll.setText(a.i.bind_mcontact_for_chatroom_title);
        this.pPG.setVisibility(8);
        this.pPF.setVisibility(8);
        this.pPF.setChecked(false);
        this.pPE.setVisibility(0);
        this.pPE.setChecked(false);
        this.pPD.setVisibility(8);
        this.pPD.setText(getString(a.i.bind_mcontact_bind_mobile_warnning_hint));
        this.pPC.setVisibility(8);
        this.pPB.setText(a.i.bind_mcontact_bind_for_chatroom_title);
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
      this.pOX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109940);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          com.tencent.mm.plugin.account.sdk.a.pFn.b(paramAnonymousView, BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109940);
        }
      });
      this.pOX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109941);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          com.tencent.mm.plugin.account.sdk.a.pFn.b(paramAnonymousView, BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109941);
        }
      });
      AppMethodBeat.o(109946);
      return;
      this.pPH.setImageResource(a.d.bind_mcontact_protect);
      break;
      this.pPH.setImageResource(a.d.bind_mcontact_warning);
      break;
      this.pPH.setImageResource(a.d.bind_mcontact_reco_friends);
      break;
      this.pPG.setVisibility(0);
      this.pPF.setVisibility(0);
      this.pPD.setVisibility(8);
      break label332;
      this.pPG.setVisibility(8);
      this.pPF.setVisibility(8);
      this.pPD.setVisibility(0);
      break label332;
      Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
      Log.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()".concat(String.valueOf(localObject)));
      if (Util.isNullOrNil((String)localObject))
      {
        Log.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
      }
      else
      {
        localObject = com.tencent.mm.au.b.bH((String)localObject, getString(a.i.country_code));
        if (localObject == null)
        {
          Log.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
        }
        else
        {
          this.oLl = ((b.a)localObject).oLl;
          this.countryCode = ((b.a)localObject).oLk;
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
      this.oLl = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.oLl.equals("")) {
        this.pOZ.setText(this.oLl);
      }
      if (!this.countryCode.equals("")) {
        this.pPa.setText("+" + this.countryCode);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109943);
    super.onCreate(paramBundle);
    setMMTitle(a.i.bind_mcontact_security_title);
    this.oLl = Util.nullAs(getIntent().getStringExtra("country_name"), "");
    this.countryCode = Util.nullAs(getIntent().getStringExtra("couttry_code"), "");
    this.pPb = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.pPu = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.pPv = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.pPI = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
    initView();
    AppMethodBeat.o(109943);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109944);
    super.onDestroy();
    if (this.pOH != null) {
      this.pOH.recycle();
    }
    AppMethodBeat.o(109944);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109945);
    if (paramInt == 4)
    {
      aAp(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileUI
 * JD-Core Version:    0.7.0.1
 */