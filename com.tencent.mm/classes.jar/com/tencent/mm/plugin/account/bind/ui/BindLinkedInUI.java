package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class BindLinkedInUI
  extends MMActivity
  implements f
{
  private String dqV;
  private String dqW;
  private ProgressDialog fsw;
  private boolean gsM = false;
  private String gsN;
  private boolean gsO = false;
  private boolean gsP = false;
  private boolean gsQ = false;
  private Bundle gsR;
  private boolean gsS = false;
  private boolean gsT = false;
  private TextView gsU;
  private TextView gsV;
  private View gsW;
  private MMSwitchBtn gsX;
  private TextView gsY;
  private TextView gsZ;
  private TextView gta;
  private String gtb;
  private String gtc;
  private String gtd;
  private String gte;
  private String name;
  private int status;
  
  private void Kc()
  {
    boolean bool2 = true;
    AppMethodBeat.i(13405);
    this.gsN = ((String)g.RL().Ru().get(286721, null));
    if (!bo.isNullOrNil(this.gsN))
    {
      bool1 = true;
      this.gsM = bool1;
      this.name = ((String)g.RL().Ru().get(286722, null));
      this.status = r.Zr();
      if ((this.status & 0x400000) == 0) {
        break label99;
      }
    }
    label99:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.gsO = bool1;
      AppMethodBeat.o(13405);
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    AppMethodBeat.i(13411);
    this.gta.setVisibility(8);
    if (paramBoolean1)
    {
      this.gsV.setVisibility(8);
      this.gsU.setVisibility(0);
      wO(paramString);
      this.gsW.setVisibility(0);
      this.gsY.setVisibility(8);
      if (paramBoolean2) {
        this.gsZ.setVisibility(0);
      }
      this.gsX.setCheck(paramBoolean3);
      this.gsX.setSwitchListener(new BindLinkedInUI.3(this));
      AppMethodBeat.o(13411);
      return;
    }
    this.gsU.setVisibility(8);
    this.gsU.setText(getString(2131298641));
    this.gsV.setVisibility(0);
    this.gsW.setVisibility(8);
    this.gsY.setVisibility(0);
    this.gsZ.setVisibility(8);
    AppMethodBeat.o(13411);
  }
  
  private void bJ()
  {
    boolean bool = true;
    AppMethodBeat.i(13412);
    if ((this.gsP) && (this.gsR == null))
    {
      ab.e("MicroMsg.BindLinkedInUI", "bindBundle is null");
      AppMethodBeat.o(13412);
      return;
    }
    if (this.gsQ)
    {
      a(this.gsM, false, this.name, this.gsO);
      AppMethodBeat.o(13412);
      return;
    }
    if (this.gsP)
    {
      if ((this.gsM) && (this.gsN.equals(this.dqV))) {}
      for (;;)
      {
        d(bool, this.dqW, this.gsO);
        AppMethodBeat.o(13412);
        return;
        bool = false;
      }
    }
    a(this.gsM, true, this.name, this.gsO);
    AppMethodBeat.o(13412);
  }
  
  private void d(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(13410);
    this.gsU.setVisibility(0);
    wO(paramString);
    this.gsW.setVisibility(0);
    this.gsZ.setVisibility(8);
    if (paramBoolean1)
    {
      this.gsV.setVisibility(8);
      this.gsY.setVisibility(8);
      this.gta.setVisibility(8);
      this.gsX.setCheck(paramBoolean2);
      this.gsX.setSwitchListener(new MMSwitchBtn.a()
      {
        public final void onStatusChange(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(13400);
          BindLinkedInUI.a(BindLinkedInUI.this, paramAnonymousBoolean, true);
          AppMethodBeat.o(13400);
        }
      });
      AppMethodBeat.o(13410);
      return;
    }
    this.gsV.setVisibility(0);
    this.gsY.setVisibility(0);
    this.gta.setVisibility(0);
    this.gsX.setCheck(paramBoolean2);
    this.gsX.setSwitchListener(new BindLinkedInUI.2(this));
    AppMethodBeat.o(13410);
  }
  
  private void dt(boolean paramBoolean)
  {
    AppMethodBeat.i(13408);
    if (this.gsR == null)
    {
      ab.e("MicroMsg.BindLinkedInUI", "bindBundle is null !!");
      AppMethodBeat.o(13408);
      return;
    }
    if (this.gsX.ADA) {}
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.account.bind.a.a locala = new com.tencent.mm.plugin.account.bind.a.a(i, this.dqV, this.dqW, "", this.gtb, this.gtc, this.gtd, this.gte);
      if (!paramBoolean) {
        this.fsw = h.b(this, getString(2131301086), false, new BindLinkedInUI.11(this, locala));
      }
      g.Rc().a(locala, 0);
      AppMethodBeat.o(13408);
      return;
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(13407);
    if (this.gsP)
    {
      if (this.gsT)
      {
        Intent localIntent = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
        localIntent.addFlags(603979776);
        localIntent.putExtra("preferred_tab", 2);
        startActivity(localIntent);
        AppMethodBeat.o(13407);
        return;
      }
      setResult(-1);
      finish();
      AppMethodBeat.o(13407);
      return;
    }
    setResult(-1);
    finish();
    AppMethodBeat.o(13407);
  }
  
  private void m(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(13413);
    if (paramBoolean1)
    {
      this.status |= 0x400000;
      if (!paramBoolean1) {
        break label131;
      }
    }
    label131:
    for (int i = 1;; i = 2)
    {
      g.RL().Ru().set(7, Integer.valueOf(this.status));
      if (paramBoolean2)
      {
        aek localaek = new aek();
        localaek.wXn = 33;
        localaek.pKC = i;
        ((j)g.E(j.class)).Yz().c(new j.a(23, localaek));
        com.tencent.mm.plugin.account.a.a.gmP.BO();
      }
      AppMethodBeat.o(13413);
      return;
      this.status &= 0xFFBFFFFF;
      break;
    }
  }
  
  private void wO(String paramString)
  {
    AppMethodBeat.i(13409);
    int i = getString(2131298640).indexOf("%s");
    Object localObject = getString(2131298640, new Object[] { paramString });
    localObject = Spannable.Factory.getInstance().newSpannable((CharSequence)localObject);
    ((Spannable)localObject).setSpan(new BindLinkedInUI.12(this), i, paramString.length() + i, 33);
    this.gsU.setText((CharSequence)localObject);
    AppMethodBeat.o(13409);
  }
  
  private boolean y(Intent paramIntent)
  {
    AppMethodBeat.i(13414);
    Object localObject = paramIntent.getBundleExtra("result_data");
    paramIntent = ((Bundle)localObject).getString("ret");
    String str1 = ((Bundle)localObject).getString("limid");
    String str2 = ((Bundle)localObject).getString("liname");
    String str3 = ((Bundle)localObject).getString("liurl");
    localObject = ((Bundle)localObject).getString("liswitch");
    if (bo.isNullOrNil(paramIntent))
    {
      ab.e("MicroMsg.BindLinkedInUI", "linkedin oauth ret is null, maybe canceled");
      AppMethodBeat.o(13414);
      return false;
    }
    int i = bo.apV(paramIntent);
    if (i != 0)
    {
      ab.e("MicroMsg.BindLinkedInUI", "linkedin oauth bind failed ret %s ", new Object[] { Integer.valueOf(i) });
      if (i == 1) {}
      for (i = 2131298651;; i = 2131298650)
      {
        h.b(this, getString(i), null, true);
        AppMethodBeat.o(13414);
        return false;
      }
    }
    if (bo.isNullOrNil(str1))
    {
      ab.e("MicroMsg.BindLinkedInUI", "linkedin member id is null");
      AppMethodBeat.o(13414);
      return false;
    }
    ab.d("MicroMsg.BindLinkedInUI", "%s, %s, %s, %s", new Object[] { str1, str2, str3, localObject });
    g.RL().Ru().set(286722, str2);
    g.RL().Ru().set(286721, str1);
    g.RL().Ru().set(286723, str3);
    if (!bo.isNullOrNil((String)localObject)) {
      if (bo.apV((String)localObject) != 1) {
        break label311;
      }
    }
    label311:
    for (boolean bool = true;; bool = false)
    {
      m(bool, false);
      Kc();
      bJ();
      paramIntent = getString(2131298647);
      new BindLinkedInUI.4(this);
      h.bO(this, paramIntent);
      AppMethodBeat.o(13414);
      return true;
    }
  }
  
  public int getLayoutId()
  {
    return 2130968846;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13406);
    if (this.gsP) {
      setMMTitle(2131298653);
    }
    for (;;)
    {
      this.gsU = ((TextView)findViewById(2131821795));
      this.gsV = ((TextView)findViewById(2131821794));
      this.gsW = findViewById(2131821796);
      this.gsX = ((MMSwitchBtn)findViewById(2131821797));
      this.gsY = ((TextView)findViewById(2131821798));
      this.gsZ = ((TextView)findViewById(2131821799));
      this.gta = ((TextView)findViewById(2131821800));
      this.gsU.setOnClickListener(new BindLinkedInUI.6(this));
      this.gsY.setOnClickListener(new BindLinkedInUI.7(this));
      this.gsZ.setOnClickListener(new BindLinkedInUI.8(this));
      this.gta.setOnClickListener(new BindLinkedInUI.9(this));
      setBackBtn(new BindLinkedInUI.10(this));
      bJ();
      AppMethodBeat.o(13406);
      return;
      if (this.gsQ) {
        setMMTitle(2131298656);
      } else {
        setMMTitle(2131298646);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(13415);
    ab.d("MicroMsg.BindLinkedInUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    if (paramIntent == null)
    {
      AppMethodBeat.o(13415);
      return;
    }
    switch (paramInt1)
    {
    default: 
      ab.e("MicroMsg.BindLinkedInUI", "onActivityResult unknow request");
      AppMethodBeat.o(13415);
      return;
    }
    y(paramIntent);
    AppMethodBeat.o(13415);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13401);
    super.onCreate(paramBundle);
    g.Rc().a(549, this);
    g.Rc().a(550, this);
    this.gsR = getIntent().getBundleExtra("qrcode_bundle");
    if (this.gsR != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.gsP = bool;
      if (this.gsR != null)
      {
        this.dqV = this.gsR.getString("i");
        this.dqW = this.gsR.getString("n");
        this.gtb = this.gsR.getString("t");
        this.gtc = this.gsR.getString("o");
        this.gtd = this.gsR.getString("s");
        this.gte = this.gsR.getString("r");
        if ((this.dqV == null) || (this.dqW == null) || (this.gtb == null) || (this.gtd == null) || (this.gte == null)) {
          h.a(this, getString(2131298643), null, false, new BindLinkedInUI.1(this));
        }
      }
      this.gsQ = getIntent().getBooleanExtra("oversea_entry", false);
      Kc();
      if (this.gsP) {
        this.gsO = true;
      }
      initView();
      if ((this.gsR != null) && (this.gsM) && (this.gsN.equals(this.dqV)))
      {
        this.gsS = true;
        dt(true);
      }
      AppMethodBeat.o(13401);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13402);
    g.Rc().b(550, this);
    g.Rc().b(549, this);
    super.onDestroy();
    AppMethodBeat.o(13402);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(13417);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(13417);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(13417);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(13404);
    super.onPause();
    AppMethodBeat.o(13404);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13403);
    super.onResume();
    AppMethodBeat.o(13403);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(13416);
    if (this.fsw != null)
    {
      this.fsw.dismiss();
      this.fsw = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramm.getType() == 549) {
        if (paramInt2 == 1) {
          paramInt1 = 2131298651;
        }
      }
      for (;;)
      {
        h.b(this, getString(paramInt1), null, true);
        AppMethodBeat.o(13416);
        return;
        paramInt1 = 2131298650;
        continue;
        if (paramm.getType() != 550) {
          break;
        }
        paramInt1 = 2131298652;
      }
      AppMethodBeat.o(13416);
      return;
    }
    if (paramm.getType() == 549)
    {
      this.gsT = true;
      if (!this.gsS) {
        paramInt1 = 2131298647;
      }
    }
    for (;;)
    {
      paramString = getString(paramInt1);
      new BindLinkedInUI.5(this);
      h.bO(this, paramString);
      Kc();
      this.gsO = this.gsX.ADA;
      bJ();
      AppMethodBeat.o(13416);
      return;
      paramInt1 = 2131298648;
      continue;
      if (paramm.getType() != 550) {
        break;
      }
      paramInt1 = 2131298658;
    }
    AppMethodBeat.o(13416);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI
 * JD-Core Version:    0.7.0.1
 */