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
import com.tencent.mm.aw.b.a;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMobileUI
  extends MMWizardActivity
{
  private String countryCode = null;
  private String dAs;
  private TextView gqi;
  private String ihe = null;
  private i jcE;
  private EditText jcT;
  private LinearLayout jcU;
  private TextView jcW;
  private TextView jcX;
  private String jcY = null;
  private boolean jdA;
  private BindWordingContent jdm;
  private int jdn;
  private Button jdt;
  private TextView jdu;
  private TextView jdv;
  private CheckBox jdw;
  private CheckBox jdx;
  private LinearLayout jdy;
  private ImageView jdz;
  
  public int getLayoutId()
  {
    return 2131493173;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109946);
    this.jcT = ((EditText)findViewById(2131297244));
    this.jcU = ((LinearLayout)findViewById(2131298805));
    this.jcW = ((TextView)findViewById(2131298807));
    this.jcX = ((TextView)findViewById(2131298803));
    this.gqi = ((TextView)findViewById(2131297248));
    this.jdt = ((Button)findViewById(2131297232));
    this.jdu = ((TextView)findViewById(2131297245));
    this.gqi.setText(getString(2131756480));
    this.jdv = ((TextView)findViewById(2131297233));
    this.jdy = ((LinearLayout)findViewById(2131297247));
    this.jdx = ((CheckBox)findViewById(2131297242));
    this.jdw = ((CheckBox)findViewById(2131297241));
    this.jdz = ((ImageView)findViewById(2131297243));
    if (this.jdm != null)
    {
      if ((this.jdm.title != null) && (this.jdm.title.length() > 0)) {
        this.gqi.setText(this.jdm.title);
      }
      if ((this.jdm.content != null) && (this.jdm.content.length() > 0)) {
        this.jdv.setText(this.jdm.content);
      }
    }
    switch (this.jdm.inO.intValue())
    {
    default: 
      switch (this.jdn)
      {
      default: 
        label324:
        if ((bu.isNullOrNil(this.ihe)) && (bu.isNullOrNil(this.countryCode))) {}
        break;
      }
      break;
    }
    for (;;)
    {
      if ((this.ihe != null) && (!this.ihe.equals(""))) {
        this.jcW.setText(this.ihe);
      }
      if ((this.countryCode != null) && (!this.countryCode.equals(""))) {
        this.jcX.setText("+" + this.countryCode);
      }
      if ((this.jcY != null) && (!this.jcY.equals(""))) {
        this.jcT.setText(this.jcY);
      }
      this.jdt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109937);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((BindMobileUI.a(BindMobileUI.this).getText().toString() == null) || (BindMobileUI.a(BindMobileUI.this).getText().toString().length() == 0))
          {
            Toast.makeText(BindMobileUI.this, BindMobileUI.this.getString(2131756461), 0).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109937);
            return;
          }
          BindMobileUI.b(BindMobileUI.this, BindMobileUI.b(BindMobileUI.this).getText().toString().trim() + bu.apl(BindMobileUI.a(BindMobileUI.this).getText().toString()));
          ae.i("MicroMsg.BindMContactUI", "do next, send sms to self");
          BindMobileUI.c(BindMobileUI.this, BindMobileUI.c(BindMobileUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109937);
        }
      });
      this.jdu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109938);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          BindMobileUI.d(BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109938);
        }
      });
      if (this.jdA)
      {
        setMMTitle(2131756448);
        this.jdz.setVisibility(8);
        this.gqi.setText(2131756469);
        this.jdy.setVisibility(8);
        this.jdx.setVisibility(8);
        this.jdx.setChecked(false);
        this.jdw.setVisibility(0);
        this.jdw.setChecked(false);
        this.jdv.setVisibility(8);
        this.jdv.setText(getString(2131756450));
        this.jdu.setVisibility(8);
        this.jdt.setText(2131756448);
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
      this.jcU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109940);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          com.tencent.mm.plugin.account.a.a.iUz.b(paramAnonymousView, BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109940);
        }
      });
      this.jcU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109941);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          com.tencent.mm.plugin.account.a.a.iUz.b(paramAnonymousView, BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109941);
        }
      });
      AppMethodBeat.o(109946);
      return;
      this.jdz.setImageResource(2131231176);
      break;
      this.jdz.setImageResource(2131231179);
      break;
      this.jdz.setImageResource(2131231177);
      break;
      this.jdy.setVisibility(0);
      this.jdx.setVisibility(0);
      this.jdv.setVisibility(8);
      break label324;
      this.jdy.setVisibility(8);
      this.jdx.setVisibility(8);
      this.jdv.setVisibility(0);
      break label324;
      Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
      ae.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()".concat(String.valueOf(localObject)));
      if (bu.isNullOrNil((String)localObject))
      {
        ae.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
      }
      else
      {
        localObject = com.tencent.mm.aw.b.bq((String)localObject, getString(2131757950));
        if (localObject == null)
        {
          ae.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
        }
        else
        {
          this.ihe = ((b.a)localObject).ihe;
          this.countryCode = ((b.a)localObject).ihd;
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
      this.ihe = bu.bI(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bu.bI(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.ihe.equals("")) {
        this.jcW.setText(this.ihe);
      }
      if (!this.countryCode.equals("")) {
        this.jcX.setText("+" + this.countryCode);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109943);
    super.onCreate(paramBundle);
    setMMTitle(2131756484);
    this.ihe = bu.bI(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bu.bI(getIntent().getStringExtra("couttry_code"), "");
    this.jcY = bu.bI(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.jdm = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.jdn = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.jdA = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
    initView();
    AppMethodBeat.o(109943);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109944);
    super.onDestroy();
    if (this.jcE != null) {
      this.jcE.recycle();
    }
    AppMethodBeat.o(109944);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109945);
    if (paramInt == 4)
    {
      acs(1);
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