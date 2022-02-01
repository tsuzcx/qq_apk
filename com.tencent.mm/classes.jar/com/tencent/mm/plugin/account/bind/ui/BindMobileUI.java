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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMobileUI
  extends MMWizardActivity
{
  private String countryCode = null;
  private String dSf;
  private TextView hbb;
  private String jbZ = null;
  private i kaH;
  private EditText kaW;
  private LinearLayout kaX;
  private TextView kaZ;
  private CheckBox kbA;
  private LinearLayout kbB;
  private ImageView kbC;
  private boolean kbD;
  private TextView kba;
  private String kbb = null;
  private BindWordingContent kbp;
  private int kbq;
  private Button kbw;
  private TextView kbx;
  private TextView kby;
  private CheckBox kbz;
  
  public int getLayoutId()
  {
    return 2131493219;
  }
  
  public void initView()
  {
    AppMethodBeat.i(109946);
    this.kaW = ((EditText)findViewById(2131297399));
    this.kaX = ((LinearLayout)findViewById(2131299269));
    this.kaZ = ((TextView)findViewById(2131299271));
    this.kba = ((TextView)findViewById(2131299266));
    this.hbb = ((TextView)findViewById(2131297403));
    this.kbw = ((Button)findViewById(2131297387));
    this.kbx = ((TextView)findViewById(2131297400));
    this.hbb.setText(getString(2131756616));
    this.kby = ((TextView)findViewById(2131297388));
    this.kbB = ((LinearLayout)findViewById(2131297402));
    this.kbA = ((CheckBox)findViewById(2131297397));
    this.kbz = ((CheckBox)findViewById(2131297396));
    this.kbC = ((ImageView)findViewById(2131297398));
    if (this.kbp != null)
    {
      if ((this.kbp.title != null) && (this.kbp.title.length() > 0)) {
        this.hbb.setText(this.kbp.title);
      }
      if ((this.kbp.content != null) && (this.kbp.content.length() > 0)) {
        this.kby.setText(this.kbp.content);
      }
    }
    switch (this.kbp.jiW.intValue())
    {
    default: 
      switch (this.kbq)
      {
      default: 
        label324:
        if ((Util.isNullOrNil(this.jbZ)) && (Util.isNullOrNil(this.countryCode))) {}
        break;
      }
      break;
    }
    for (;;)
    {
      if ((this.jbZ != null) && (!this.jbZ.equals(""))) {
        this.kaZ.setText(this.jbZ);
      }
      if ((this.countryCode != null) && (!this.countryCode.equals(""))) {
        this.kba.setText("+" + this.countryCode);
      }
      if ((this.kbb != null) && (!this.kbb.equals(""))) {
        this.kaW.setText(this.kbb);
      }
      this.kbw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109937);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((BindMobileUI.a(BindMobileUI.this).getText().toString() == null) || (BindMobileUI.a(BindMobileUI.this).getText().toString().length() == 0))
          {
            Toast.makeText(BindMobileUI.this, BindMobileUI.this.getString(2131756597), 0).show();
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
      this.kbx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109938);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          BindMobileUI.d(BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109938);
        }
      });
      if (this.kbD)
      {
        setMMTitle(2131756584);
        this.kbC.setVisibility(8);
        this.hbb.setText(2131756605);
        this.kbB.setVisibility(8);
        this.kbA.setVisibility(8);
        this.kbA.setChecked(false);
        this.kbz.setVisibility(0);
        this.kbz.setChecked(false);
        this.kby.setVisibility(8);
        this.kby.setText(getString(2131756586));
        this.kbx.setVisibility(8);
        this.kbw.setText(2131756584);
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
      this.kaX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109940);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          com.tencent.mm.plugin.account.a.a.jRt.b(paramAnonymousView, BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109940);
        }
      });
      this.kaX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(109941);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMobileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", BindMobileUI.f(BindMobileUI.this));
          paramAnonymousView.putExtra("couttry_code", BindMobileUI.g(BindMobileUI.this));
          com.tencent.mm.plugin.account.a.a.jRt.b(paramAnonymousView, BindMobileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMobileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(109941);
        }
      });
      AppMethodBeat.o(109946);
      return;
      this.kbC.setImageResource(2131231227);
      break;
      this.kbC.setImageResource(2131231230);
      break;
      this.kbC.setImageResource(2131231228);
      break;
      this.kbB.setVisibility(0);
      this.kbA.setVisibility(0);
      this.kby.setVisibility(8);
      break label324;
      this.kbB.setVisibility(8);
      this.kbA.setVisibility(8);
      this.kby.setVisibility(0);
      break label324;
      Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
      Log.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()".concat(String.valueOf(localObject)));
      if (Util.isNullOrNil((String)localObject))
      {
        Log.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
      }
      else
      {
        localObject = com.tencent.mm.aw.b.bs((String)localObject, getString(2131758198));
        if (localObject == null)
        {
          Log.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
        }
        else
        {
          this.jbZ = ((b.a)localObject).jbZ;
          this.countryCode = ((b.a)localObject).jbY;
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
      this.jbZ = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.jbZ.equals("")) {
        this.kaZ.setText(this.jbZ);
      }
      if (!this.countryCode.equals("")) {
        this.kba.setText("+" + this.countryCode);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109943);
    super.onCreate(paramBundle);
    setMMTitle(2131756620);
    this.jbZ = Util.nullAs(getIntent().getStringExtra("country_name"), "");
    this.countryCode = Util.nullAs(getIntent().getStringExtra("couttry_code"), "");
    this.kbb = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.kbp = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.kbq = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.kbD = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
    initView();
    AppMethodBeat.o(109943);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109944);
    super.onDestroy();
    if (this.kaH != null) {
      this.kaH.recycle();
    }
    AppMethodBeat.o(109944);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(109945);
    if (paramInt == 4)
    {
      ala(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileUI
 * JD-Core Version:    0.7.0.1
 */