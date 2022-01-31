package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b;
import com.tencent.mm.au.b.a;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.plugin.account.friend.ui.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMobileUI
  extends MMWizardActivity
{
  private String countryCode = null;
  private String czF;
  private String fHT = null;
  private EditText gtH;
  private LinearLayout gtI;
  private TextView gtK;
  private TextView gtL;
  private String gtM = null;
  private i gtr;
  private BindWordingContent gub;
  private int guc;
  private TextView gui;
  private Button guj;
  private TextView guk;
  private TextView gul;
  private CheckBox gum;
  private CheckBox gun;
  private LinearLayout guo;
  private ImageView gup;
  private boolean guq;
  
  public int getLayoutId()
  {
    return 2130968841;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13519);
    this.gtH = ((EditText)findViewById(2131821768));
    this.gtI = ((LinearLayout)findViewById(2131821765));
    this.gtK = ((TextView)findViewById(2131821767));
    this.gtL = ((TextView)findViewById(2131821766));
    this.gui = ((TextView)findViewById(2131821764));
    this.guj = ((Button)findViewById(2131821769));
    this.guk = ((TextView)findViewById(2131821775));
    this.gui.setText(getString(2131297588));
    this.gul = ((TextView)findViewById(2131821773));
    this.guo = ((LinearLayout)findViewById(2131821770));
    this.gun = ((CheckBox)findViewById(2131821772));
    this.gum = ((CheckBox)findViewById(2131821771));
    this.gup = ((ImageView)findViewById(2131821763));
    if (this.gub != null)
    {
      if ((this.gub.title != null) && (this.gub.title.length() > 0)) {
        this.gui.setText(this.gub.title);
      }
      if ((this.gub.content != null) && (this.gub.content.length() > 0)) {
        this.gul.setText(this.gub.content);
      }
    }
    switch (this.gub.bOw.intValue())
    {
    default: 
      switch (this.guc)
      {
      default: 
        label320:
        if ((bo.isNullOrNil(this.fHT)) && (bo.isNullOrNil(this.countryCode))) {}
        break;
      }
      break;
    }
    for (;;)
    {
      if ((this.fHT != null) && (!this.fHT.equals(""))) {
        this.gtK.setText(this.fHT);
      }
      if ((this.countryCode != null) && (!this.countryCode.equals(""))) {
        this.gtL.setText("+" + this.countryCode);
      }
      if ((this.gtM != null) && (!this.gtM.equals(""))) {
        this.gtH.setText(this.gtM);
      }
      this.guj.setOnClickListener(new BindMobileUI.2(this));
      this.guk.setOnClickListener(new BindMobileUI.3(this));
      if (this.guq)
      {
        setMMTitle(2131297556);
        this.gup.setVisibility(8);
        this.gui.setText(2131297577);
        this.guo.setVisibility(8);
        this.gun.setVisibility(8);
        this.gun.setChecked(false);
        this.gum.setVisibility(0);
        this.gum.setChecked(false);
        this.gul.setVisibility(8);
        this.gul.setText(getString(2131297558));
        this.guk.setVisibility(8);
        this.guj.setText(2131297556);
        setBackBtn(new BindMobileUI.4(this));
      }
      this.gtI.setOnClickListener(new BindMobileUI.5(this));
      this.gtI.setOnClickListener(new BindMobileUI.6(this));
      AppMethodBeat.o(13519);
      return;
      this.gup.setImageResource(2130837902);
      break;
      this.gup.setImageResource(2130837905);
      break;
      this.gup.setImageResource(2130837903);
      break;
      this.guo.setVisibility(0);
      this.gun.setVisibility(0);
      this.gul.setVisibility(8);
      break label320;
      this.guo.setVisibility(8);
      this.gun.setVisibility(8);
      this.gul.setVisibility(0);
      break label320;
      Object localObject = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
      ab.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()".concat(String.valueOf(localObject)));
      if (bo.isNullOrNil((String)localObject))
      {
        ab.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
      }
      else
      {
        localObject = b.k(this, (String)localObject, getString(2131298871));
        if (localObject == null)
        {
          ab.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
        }
        else
        {
          this.fHT = ((b.a)localObject).fHT;
          this.countryCode = ((b.a)localObject).fHS;
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(13520);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(13520);
      return;
      this.fHT = bo.bf(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bo.bf(paramIntent.getStringExtra("couttry_code"), "");
      if (!this.fHT.equals("")) {
        this.gtK.setText(this.fHT);
      }
      if (!this.countryCode.equals("")) {
        this.gtL.setText("+" + this.countryCode);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13516);
    super.onCreate(paramBundle);
    setMMTitle(2131297592);
    this.fHT = bo.bf(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bo.bf(getIntent().getStringExtra("couttry_code"), "");
    this.gtM = bo.bf(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.gub = ((BindWordingContent)getIntent().getParcelableExtra("kstyle_bind_wording"));
    this.guc = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
    this.guq = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
    initView();
    AppMethodBeat.o(13516);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13517);
    super.onDestroy();
    if (this.gtr != null) {
      this.gtr.recycle();
    }
    AppMethodBeat.o(13517);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(13518);
    if (paramInt == 4)
    {
      Oi(1);
      AppMethodBeat.o(13518);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(13518);
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