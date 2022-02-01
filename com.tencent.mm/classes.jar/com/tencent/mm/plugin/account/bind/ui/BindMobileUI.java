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
import com.tencent.mm.ax.b.a;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMobileUI
  extends MMWizardActivity
{
  private String countryCode = null;
  private String dzn;
  private TextView gnM;
  private i iZL;
  private String iem = null;
  private Button jaA;
  private TextView jaB;
  private TextView jaC;
  private CheckBox jaD;
  private CheckBox jaE;
  private LinearLayout jaF;
  private ImageView jaG;
  private boolean jaH;
  private EditText jaa;
  private LinearLayout jab;
  private TextView jad;
  private TextView jae;
  private String jaf = null;
  private BindWordingContent jat;
  private int jau;
  
  public int getLayoutId()
  {
    return 2131493173;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109946);
    this.jaa = ((EditText)findViewById(2131297244));
    this.jab = ((LinearLayout)findViewById(2131298805));
    this.jad = ((TextView)findViewById(2131298807));
    this.jae = ((TextView)findViewById(2131298803));
    this.gnM = ((TextView)findViewById(2131297248));
    this.jaA = ((Button)findViewById(2131297232));
    this.jaB = ((TextView)findViewById(2131297245));
    this.gnM.setText(getString(2131756480));
    this.jaC = ((TextView)findViewById(2131297233));
    this.jaF = ((LinearLayout)findViewById(2131297247));
    this.jaE = ((CheckBox)findViewById(2131297242));
    this.jaD = ((CheckBox)findViewById(2131297241));
    this.jaG = ((ImageView)findViewById(2131297243));
    if (this.jat != null)
    {
      if ((this.jat.title != null) && (this.jat.title.length() > 0)) {
        this.gnM.setText(this.jat.title);
      }
      if ((this.jat.content != null) && (this.jat.content.length() > 0)) {
        this.jaC.setText(this.jat.content);
      }
    }
    switch (this.jat.ikV.intValue())
    {
    default: 
      switch (this.jau)
      {
      default: 
        label324:
        if ((bt.isNullOrNil(this.iem)) && (bt.isNullOrNil(this.countryCode))) {}
        break;
      }
      break;
    }
    for (;;)
    {
      if ((this.iem != null) && (!this.iem.equals(""))) {
        this.jad.setText(this.iem);
      }
      if ((this.countryCode != null) && (!this.countryCode.equals(""))) {
        this.jae.setText("+" + this.countryCode);
      }
      if ((this.jaf != null) && (!this.jaf.equals(""))) {
        this.jaa.setText(this.jaf);
      }
      this.jaA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109937);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if ((BindMobileUI.a(BindMobileUI.this).getText().toString() == null) || (BindMobileUI.a(BindMobileUI.this).getText().toString().length() == 0))
          {
            Toast.makeText(BindMobileUI.this, BindMobileUI.this.getString(2131756461), 0).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(109937);
            return;
          }
          BindMobileUI.b(BindMobileUI.this, BindMobileUI.b(BindMobileUI.this).getText().toString().trim() + bt.aoj(BindMobileUI.a(BindMobileUI.this).getText().toString()));
          ad.i("MicroMsg.BindMContactUI", "do next, send sms to self");
          BindMobileUI.c(BindMobileUI.this, BindMobileUI.c(BindMobileUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109937);
        }
      });
      this.jaB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109938);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          BindMobileUI.d(BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109938);
        }
      });
      if (this.jaH)
      {
        setMMTitle(2131756448);
        this.jaG.setVisibility(8);
        this.gnM.setText(2131756469);
        this.jaF.setVisibility(8);
        this.jaE.setVisibility(8);
        this.jaE.setChecked(false);
        this.jaD.setVisibility(0);
        this.jaD.setChecked(false);
        this.jaC.setVisibility(8);
        this.jaC.setText(getString(2131756450));
        this.jaB.setVisibility(8);
        this.jaA.setText(2131756448);
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
      this.jab.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109940);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          com.tencent.mm.plugin.account.a.a.iRG.b(paramAnonymousView, BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109940);
        }
      });
      this.jab.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109941);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          com.tencent.mm.plugin.account.a.a.iRG.b(paramAnonymousView, BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109941);
        }
      });
      AppMethodBeat.o(109946);
      return;
      this.jaG.setImageResource(2131231176);
      break;
      this.jaG.setImageResource(2131231179);
      break;
      this.jaG.setImageResource(2131231177);
      break;
      this.jaF.setVisibility(0);
      this.jaE.setVisibility(0);
      this.jaC.setVisibility(8);
      break label324;
      this.jaF.setVisibility(8);
      this.jaE.setVisibility(8);
      this.jaC.setVisibility(0);
      break label324;
      Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
      ad.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()".concat(String.valueOf(localObject)));
      if (bt.isNullOrNil((String)localObject))
      {
        ad.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
      }
      else
      {
        localObject = com.tencent.mm.ax.b.bq((String)localObject, getString(2131757950));
        if (localObject == null)
        {
          ad.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
        }
        else
        {
          this.iem = ((b.a)localObject).iem;
          this.countryCode = ((b.a)localObject).iel;
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
      this.iem = bt.bI(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bt.bI(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.iem.equals("")) {
        this.jad.setText(this.iem);
      }
      if (!this.countryCode.equals("")) {
        this.jae.setText("+" + this.countryCode);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109943);
    super.onCreate(paramBundle);
    setMMTitle(2131756484);
    this.iem = bt.bI(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bt.bI(getIntent().getStringExtra("couttry_code"), "");
    this.jaf = bt.bI(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.jat = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.jau = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.jaH = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
    initView();
    AppMethodBeat.o(109943);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109944);
    super.onDestroy();
    if (this.iZL != null) {
      this.iZL.recycle();
    }
    AppMethodBeat.o(109944);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109945);
    if (paramInt == 4)
    {
      abK(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileUI
 * JD-Core Version:    0.7.0.1
 */