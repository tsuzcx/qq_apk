package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.au.b.a;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.model.r;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.protocal.n.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import java.io.IOException;
import java.util.TimeZone;

public class RegByMobileRegAIOUI
  extends MMActivity
  implements f
{
  private String countryCode;
  private ImageView egq;
  private String fHT;
  private com.tencent.mm.sdk.b.c gCZ;
  private String gDF;
  private bj gDn;
  private ResizeLayout gEb;
  private String gFA;
  private TextView gFO;
  private Button gFP;
  private boolean gFV;
  private String gFX;
  private final int gFe;
  private String gFr;
  private String gFs;
  private int gFt;
  private int gGv;
  private EditText gHJ;
  private TextView gHK;
  private MMFormInputView gHL;
  private String gHM;
  private View gHN;
  private CheckBox gHO;
  private MMFormInputView gHP;
  private boolean gHQ;
  private ImageView gHR;
  private MMFormInputView gHS;
  private Bitmap gHT;
  private ScrollView gHU;
  private String gHV;
  private String gHW;
  private String gHX;
  private String gHY;
  private String gHZ;
  private boolean gIa;
  private com.tencent.mm.ui.widget.b.c gIb;
  private boolean gIc;
  private int gId;
  private int gIe;
  private boolean gIf;
  private boolean gIg;
  private LinearLayout gtI;
  private TextView gtK;
  private String gtM;
  private String guI;
  private com.tencent.mm.ui.base.p gwe;
  
  public RegByMobileRegAIOUI()
  {
    AppMethodBeat.i(125373);
    this.gtM = null;
    this.fHT = null;
    this.countryCode = null;
    this.gDF = null;
    this.gFV = true;
    this.gHM = null;
    this.gFX = null;
    this.gHQ = false;
    this.gFt = 0;
    this.gIa = true;
    this.gDn = new bj();
    this.gCZ = new RegByMobileRegAIOUI.1(this);
    this.gIb = null;
    this.gIc = false;
    this.gFe = 128;
    AppMethodBeat.o(125373);
  }
  
  private boolean a(Editable... paramVarArgs)
  {
    AppMethodBeat.i(125390);
    int i = 0;
    if (i < 3)
    {
      Editable localEditable = paramVarArgs[i];
      if ((localEditable != null) && (localEditable.toString().length() != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((i != 0) && (this.gFV))
      {
        AppMethodBeat.o(125390);
        return true;
        i += 1;
        break;
      }
      AppMethodBeat.o(125390);
      return false;
    }
  }
  
  private void apB()
  {
    AppMethodBeat.i(125380);
    com.tencent.mm.plugin.b.a.xD(this.guI);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",RE200_100,");
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("RE200_100") + ",2");
    finish();
    overridePendingTransition(2131034130, 2131034130);
    AppMethodBeat.o(125380);
  }
  
  private boolean arB()
  {
    AppMethodBeat.i(125389);
    if (bo.isNullOrNil(this.countryCode)) {}
    for (int i = 0;; i = 1)
    {
      boolean bool = i & a(new Editable[] { this.gHJ.getText(), this.gHP.getText(), this.gHS.getText() });
      if (bool) {
        this.gFP.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(125389);
        return bool;
        this.gFP.setEnabled(false);
      }
    }
  }
  
  private void arD()
  {
    AppMethodBeat.i(125383);
    if ((!bo.isNullOrNil(this.fHT)) && (!bo.isNullOrNil(this.countryCode)))
    {
      this.gtK.setText(av.ig(this.fHT, this.countryCode));
      AppMethodBeat.o(125383);
      return;
    }
    this.gtK.setText(getString(2131301573));
    AppMethodBeat.o(125383);
  }
  
  private void arM()
  {
    AppMethodBeat.i(125381);
    if (!bo.isNullOrNil(this.gHW))
    {
      if (this.gwe != null) {
        this.gwe.dismiss();
      }
      getString(2131297087);
      this.gwe = com.tencent.mm.ui.base.h.b(this, getString(2131297112), true, null);
      com.tencent.mm.plugin.account.model.g localg = new com.tencent.mm.plugin.account.model.g(this.gHW);
      com.tencent.mm.kernel.g.Rc().a(localg, 0);
    }
    AppMethodBeat.o(125381);
  }
  
  private void arN()
  {
    AppMethodBeat.i(125386);
    getString(2131297087);
    this.gwe = com.tencent.mm.ui.base.h.b(this, getString(2131302413), true, new RegByMobileRegAIOUI.15(this));
    com.tencent.mm.modelfriend.a locala = new com.tencent.mm.modelfriend.a(this.gHM + this.gFX, 14, "", 0, "");
    locala.sQ(this.gFA);
    com.tencent.mm.kernel.g.Rc().a(locala, 0);
    AppMethodBeat.o(125386);
  }
  
  private void arO()
  {
    try
    {
      AppMethodBeat.i(125388);
      if (!this.gIc)
      {
        this.gIc = true;
        finish();
        Intent localIntent = new Intent();
        localIntent.putExtra("bindmcontact_mobile", this.gHM + " " + this.gHJ.getText().toString());
        localIntent.putExtra("bindmcontact_shortmobile", this.gFX);
        localIntent.putExtra("country_name", this.fHT);
        localIntent.putExtra("couttry_code", this.countryCode);
        localIntent.putExtra("mobileverify_countdownsec", this.gId);
        localIntent.putExtra("mobileverify_countdownstyle", this.gIe);
        localIntent.putExtra("mobileverify_fb", this.gIf);
        localIntent.putExtra("mobileverify_reg_qq", this.gIg);
        localIntent.putExtra("kintent_nickname", this.gHS.getText().toString());
        localIntent.putExtra("kintent_password", this.gHP.getText().toString());
        localIntent.putExtra("kintent_hasavatar", this.gHQ);
        localIntent.putExtra("key_reg_style", 1);
        localIntent.putExtra("regsession_id", this.gFA);
        localIntent.putExtra("reg_3d_app_ticket", this.gHX);
        localIntent.putExtra("reg_3d_app_type", this.gGv);
        localIntent.putExtra("mobile_verify_purpose", 2);
        startActivity(MobileVerifyUI.class, localIntent);
      }
      AppMethodBeat.o(125388);
      return;
    }
    finally {}
  }
  
  private void xy(String paramString)
  {
    AppMethodBeat.i(125382);
    if (!com.tencent.mm.plugin.account.a.b.a.O(this, this.gHP.getText().toString()))
    {
      AppMethodBeat.o(125382);
      return;
    }
    if (this.gwe != null) {
      this.gwe.dismiss();
    }
    getString(2131297087);
    this.gwe = com.tencent.mm.ui.base.h.b(this, getString(2131297112), true, null);
    Object localObject1 = av.apy(this.gHJ.getText().toString().trim());
    int i;
    if ((this.gFr != null) && (this.gFs != null) && (!((String)localObject1).equals(this.gFr)) && (((String)localObject1).equals(this.gFs))) {
      i = 1;
    }
    for (;;)
    {
      localObject1 = new com.tencent.mm.modelfriend.a(paramString, 12, "", 0, "");
      ((com.tencent.mm.modelfriend.a)localObject1).ll(this.gFt);
      ((com.tencent.mm.modelfriend.a)localObject1).lm(i);
      if (!bo.isNullOrNil(this.gHX))
      {
        localObject2 = this.gHX;
        ((n.a)((com.tencent.mm.modelfriend.a)localObject1).ftU.getReqObj()).wiw.wvT = ((String)localObject2);
      }
      if (com.tencent.mm.plugin.normsg.a.b.pgQ.VY("ie_reg")) {
        com.tencent.mm.plugin.normsg.a.b.pgQ.VX("ie_reg");
      }
      Object localObject2 = new btb();
      ((btb)localObject2).jKG = this.gHS.getText().toString();
      if ((this.gHQ) && (this.gHT != null) && (!this.gHT.isRecycled())) {
        ((btb)localObject2).xtt = ag.v(com.tencent.mm.sdk.platformtools.d.ai(this.gHT));
      }
      ((btb)localObject2).xGF = paramString;
      ((btb)localObject2).xGE = ag.cE(this.gHP.getText().toString());
      ((btb)localObject2).lGG = bo.dtS();
      ((btb)localObject2).xGG = TimeZone.getDefault().getID();
      ab.i("MicroMsg.RegByMobileRegAIOUI", "%s,%s", new Object[] { ((btb)localObject2).lGG, ((btb)localObject2).xGG });
      paramString = new cuv();
      paramString.ydw = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.VZ("ie_reg"));
      paramString.ydx = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.Wc("ce_reg"));
      paramString.ydy = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.AO(6));
      try
      {
        paramString.ydz = new SKBuiltinBuffer_t().setBuffer(((btb)localObject2).toByteArray());
        ((com.tencent.mm.modelfriend.a)localObject1).a(paramString);
        com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject1, 0);
        this.gFr = av.apy(this.gHJ.getText().toString().trim());
        this.gFt += 1;
        AppMethodBeat.o(125382);
        return;
        if ((this.gFr != null) && (this.gFs != null) && (!this.gFs.equals(this.gFr)) && (!((String)localObject1).equals(this.gFs)))
        {
          i = 2;
          continue;
        }
        i = 0;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", localIOException, "convert to byte error ! %s", new Object[] { localIOException.getMessage() });
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2130970556;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125377);
    this.gtI = ((LinearLayout)findViewById(2131821765));
    this.gtK = ((TextView)findViewById(2131821767));
    this.gHK = ((TextView)findViewById(2131827138));
    this.gHL = ((MMFormInputView)findViewById(2131827144));
    this.gHL.setInputType(3);
    this.gHJ = this.gHL.getContentEditText();
    this.gHN = findViewById(2131827146);
    this.gHO = ((CheckBox)findViewById(2131826308));
    this.gFO = ((TextView)findViewById(2131826309));
    this.gFP = ((Button)findViewById(2131827147));
    this.egq = ((ImageView)findViewById(2131827142));
    this.gHR = ((ImageView)findViewById(2131827143));
    this.gHP = ((MMFormInputView)findViewById(2131827145));
    com.tencent.mm.ui.tools.b.c.d(this.gHP.getContentEditText()).QS(16).a(null);
    this.gHU = ((ScrollView)findViewById(2131820935));
    this.gEb = ((ResizeLayout)findViewById(2131825451));
    this.gHS = ((MMFormInputView)findViewById(2131827140));
    this.gEb.setOnSizeChanged(new RegByMobileRegAIOUI.12(this));
    this.gHO.setOnCheckedChangeListener(new RegByMobileRegAIOUI.17(this));
    this.gFO.setOnClickListener(new RegByMobileRegAIOUI.18(this));
    Object localObject = new boolean[1];
    localObject[0] = 1;
    this.gHJ.addTextChangedListener(new RegByMobileRegAIOUI.19(this, (boolean[])localObject));
    this.gHJ.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(152602);
        if (paramAnonymousBoolean)
        {
          this.gIl[0] = true;
          AppMethodBeat.o(152602);
          return;
        }
        com.tencent.mm.plugin.normsg.a.b.pgQ.VX("ie_reg");
        AppMethodBeat.o(152602);
      }
    });
    this.gHP.addTextChangedListener(new RegByMobileRegAIOUI.21(this));
    this.gHS.addTextChangedListener(new RegByMobileRegAIOUI.22(this));
    localObject = new boolean[1];
    localObject[0] = 0;
    this.gFP.setOnTouchListener(new RegByMobileRegAIOUI.23(this, (boolean[])localObject));
    this.gFP.setOnClickListener(new RegByMobileRegAIOUI.2(this, (boolean[])localObject));
    this.gFP.setEnabled(false);
    if (bo.isNullOrNil(this.countryCode))
    {
      this.fHT = getString(2131298873);
      this.countryCode = av.apz(getString(2131298872));
      if (!bo.isNullOrNil(this.gHV)) {
        this.gHK.setText(this.gHV);
      }
      if ((bo.isNullOrNil(this.fHT)) || (bo.isNullOrNil(this.countryCode)))
      {
        this.gDF = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        ab.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + this.gDF);
        if (!bo.isNullOrNil(this.gDF)) {
          break label765;
        }
        ab.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
      }
      label538:
      arD();
      if ((this.gtM == null) || (this.gtM.equals(""))) {
        break label816;
      }
      this.gHJ.setText(this.gtM);
      label573:
      this.gtI.setOnClickListener(new RegByMobileRegAIOUI.4(this));
      setBackBtn(new RegByMobileRegAIOUI.5(this), 2131230735);
      this.egq.setOnClickListener(new RegByMobileRegAIOUI.6(this));
      if (!bo.isNullOrNil(this.gHW)) {
        break label834;
      }
      com.tencent.mm.kernel.g.RO().a(new RegByMobileRegAIOUI.7(this));
    }
    for (;;)
    {
      localObject = "";
      if (com.tencent.mm.protocal.d.whK) {
        localObject = getString(2131297005) + getString(2131296529);
      }
      setMMTitle((String)localObject);
      setActionbarColor(getResources().getColor(2131690316));
      hideActionbarLine();
      if (com.tencent.mm.compatible.util.d.fv(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131690310));
        supportLightStatusBar();
      }
      AppMethodBeat.o(125377);
      return;
      this.fHT = com.tencent.mm.au.b.l(this, this.countryCode, getString(2131298871));
      break;
      label765:
      localObject = com.tencent.mm.au.b.k(this, this.gDF, getString(2131298871));
      if (localObject == null)
      {
        ab.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
        break label538;
      }
      this.fHT = ((b.a)localObject).fHT;
      this.countryCode = ((b.a)localObject).fHS;
      break label538;
      label816:
      com.tencent.mm.kernel.g.RO().a(new RegByMobileRegAIOUI.3(this));
      break label573;
      label834:
      this.gHS.setText(this.gHY);
      com.tencent.mm.kernel.g.RO().a(new RegByMobileRegAIOUI.8(this));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(125384);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 30846)
    {
      if ((paramInt2 == -1) && (arB()))
      {
        arN();
        com.tencent.mm.plugin.b.a.xD("RE200_250");
        AppMethodBeat.o(125384);
      }
    }
    else if (paramInt1 == 30847)
    {
      Bundle localBundle = null;
      if (paramIntent != null) {
        localBundle = paramIntent.getBundleExtra("result_data");
      }
      if ((localBundle != null) && (localBundle.getString("go_next", "").equals("agree_privacy")))
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(712L, 2L, 1L, false);
        this.gIa = false;
        if (!bo.isNullOrNil(this.gHW))
        {
          arM();
          AppMethodBeat.o(125384);
          return;
        }
        xy(this.gHM + this.gFX);
        AppMethodBeat.o(125384);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(712L, 1L, 1L, false);
      AppMethodBeat.o(125384);
      return;
    }
    switch (paramInt2)
    {
    default: 
      this.gHT = com.tencent.mm.plugin.account.a.a.gmP.a(this, paramInt1, paramInt2, paramIntent);
      if (this.gHT != null)
      {
        this.egq.setImageBitmap(this.gHT);
        this.gHQ = true;
        this.gHR.setVisibility(8);
      }
      AppMethodBeat.o(125384);
      return;
    }
    this.fHT = bo.bf(paramIntent.getStringExtra("country_name"), "");
    this.countryCode = bo.bf(paramIntent.getStringExtra("couttry_code"), "");
    this.gDF = bo.bf(paramIntent.getStringExtra("iso_code"), "");
    if (com.tencent.mm.au.b.tN(this.countryCode))
    {
      if ((!bo.isNullOrNil(this.gHW)) && (!bo.isNullOrNil(this.gHY)) && (!bo.isNullOrNil(this.gHZ)))
      {
        arD();
        AppMethodBeat.o(125384);
        return;
      }
      paramIntent = new Intent(this, MobileInputUI.class);
      paramIntent.putExtra("mobile_input_purpose", 2);
      paramIntent.putExtra("couttry_code", this.countryCode);
      paramIntent.putExtra("country_name", this.fHT);
      startActivity(paramIntent);
      finish();
      overridePendingTransition(2131034130, 2131034130);
      AppMethodBeat.o(125384);
      return;
    }
    arD();
    AppMethodBeat.o(125384);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125374);
    super.onCreate(paramBundle);
    this.fHT = bo.bf(getIntent().getStringExtra("country_name"), "");
    this.countryCode = av.apz(bo.bf(getIntent().getStringExtra("couttry_code"), ""));
    this.gDF = bo.nullAsNil(getIntent().getStringExtra("iso_code"));
    this.gtM = bo.bf(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.gHV = getIntent().getStringExtra("register_title");
    this.gHY = getIntent().getStringExtra("register_nick_name");
    this.gHZ = getIntent().getStringExtra("register_avatar");
    this.gHW = getIntent().getStringExtra("third_app_token");
    this.gGv = getIntent().getIntExtra("reg_3d_app_type", 0);
    initView();
    AppMethodBeat.o(125374);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125387);
    com.tencent.mm.plugin.normsg.a.b.pgQ.VX("ie_reg");
    if (this.gIb != null) {
      this.gIb.dismiss();
    }
    this.gDn.ake();
    super.onDestroy();
    AppMethodBeat.o(125387);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125379);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      apB();
      AppMethodBeat.o(125379);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125379);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125376);
    super.onPause();
    if (this.gwe != null) {
      this.gwe.dismiss();
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.gCZ);
    com.tencent.mm.kernel.g.Rc().b(701, this);
    com.tencent.mm.kernel.g.Rc().b(252, this);
    com.tencent.mm.kernel.g.Rc().b(145, this);
    com.tencent.mm.kernel.g.Rc().b(132, this);
    com.tencent.mm.kernel.g.Rc().b(755, this);
    com.tencent.mm.kernel.g.Rc().b(252, this);
    com.tencent.mm.kernel.g.Rc().b(701, this);
    com.tencent.mm.plugin.b.a.xC("RE200_100");
    AppMethodBeat.o(125376);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125375);
    com.tencent.mm.sdk.b.a.ymk.c(this.gCZ);
    super.onResume();
    com.tencent.mm.kernel.g.Rc().a(701, this);
    com.tencent.mm.kernel.g.Rc().a(252, this);
    com.tencent.mm.kernel.g.Rc().a(145, this);
    com.tencent.mm.kernel.g.Rc().a(132, this);
    com.tencent.mm.kernel.g.Rc().a(755, this);
    com.tencent.mm.kernel.g.Rc().a(252, this);
    com.tencent.mm.kernel.g.Rc().a(701, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",RE200_100,");
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("RE200_100") + ",1");
    this.gFt = 0;
    AppMethodBeat.o(125375);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125385);
    ab.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gwe != null)
    {
      this.gwe.dismiss();
      this.gwe = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.h(this, 2131296532, 2131302378);
      AppMethodBeat.o(125385);
      return;
    }
    if (paramm.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramm).Ac();
      if (i == 12)
      {
        if ((paramInt2 == -41) || (paramInt2 == -59))
        {
          paramString = com.tencent.mm.h.a.kO(paramString);
          if (paramString != null)
          {
            paramString.a(this, null, null);
            AppMethodBeat.o(125385);
            return;
          }
          com.tencent.mm.ui.base.h.h(this, 2131302425, 2131302426);
          AppMethodBeat.o(125385);
          return;
        }
        this.gFX = av.apy(this.gFX);
        this.gFs = (this.gHM + this.gFX);
        this.gFA = ((com.tencent.mm.modelfriend.a)paramm).agK();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramm = ((com.tencent.mm.modelfriend.a)paramm).agz();
          if (!bo.isNullOrNil(paramm)) {
            this.gFX = paramm.trim();
          }
          com.tencent.mm.plugin.b.a.xC("RE200_100");
          paramm = new StringBuilder();
          com.tencent.mm.kernel.g.RJ();
          paramm = paramm.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",RE200_200,");
          com.tencent.mm.kernel.g.RJ();
          com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("RE200_200") + ",1");
          paramString = com.tencent.mm.h.a.kO(paramString);
          if (paramString != null)
          {
            paramString.a(this, new RegByMobileRegAIOUI.9(this), new RegByMobileRegAIOUI.10(this));
            AppMethodBeat.o(125385);
            return;
          }
          arN();
          com.tencent.mm.plugin.b.a.xD("RE200_250");
          AppMethodBeat.o(125385);
          return;
        }
        if (paramInt2 == -355)
        {
          z.f(this, paramString, 30846);
          this.gDn.cXw = this.gGv;
          this.gDn.cRH = 5L;
          this.gDn.ake();
          AppMethodBeat.o(125385);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.b(this, getString(2131297570), "", true);
          AppMethodBeat.o(125385);
          return;
        }
        if (com.tencent.mm.plugin.account.a.a.gmP.a(this, paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(125385);
          return;
        }
        Toast.makeText(this, getString(2131297614, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if (i == 14)
      {
        if ((paramInt2 != 0) && (paramString != null)) {
          break label840;
        }
        if (((com.tencent.mm.modelfriend.a)paramm).agA() != 1) {
          break label785;
        }
        localObject = this.gHM + this.gFX;
        String str1 = ((com.tencent.mm.modelfriend.a)paramm).agC();
        String str2 = ((com.tencent.mm.modelfriend.a)paramm).agB();
        Intent localIntent = new Intent(this, RegByMobileSendSmsUI.class);
        localIntent.putExtra("regsession_id", this.gFA);
        localIntent.putExtra("key_reg_style", 1);
        localIntent.putExtra("from_mobile", (String)localObject);
        localIntent.putExtra("to_mobile", str1);
        localIntent.putExtra("verify_code", str2);
        localIntent.putExtra("kintent_nickname", this.gHS.getText().toString());
        localIntent.putExtra("kintent_password", this.gHP.getText().toString());
        localIntent.putExtra("kintent_hasavatar", this.gHQ);
        localIntent.putExtra("reg_3d_app_type", this.gGv);
        localIntent.putExtra("reg_3d_app_ticket", this.gHX);
        startActivity(localIntent);
      }
      while (com.tencent.mm.plugin.account.a.a.gmP.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125385);
        return;
        label785:
        this.gId = ((com.tencent.mm.modelfriend.a)paramm).agE();
        this.gIe = ((com.tencent.mm.modelfriend.a)paramm).agF();
        this.gIf = ((com.tencent.mm.modelfriend.a)paramm).agG();
        this.gIg = ((com.tencent.mm.modelfriend.a)paramm).agH();
        arO();
      }
      label840:
      if (paramInt2 == -41)
      {
        com.tencent.mm.ui.base.h.h(this, 2131302425, 2131302426);
        AppMethodBeat.o(125385);
        return;
      }
      if (paramInt2 == -34)
      {
        com.tencent.mm.ui.base.h.b(this, getString(2131297570), "", true);
        AppMethodBeat.o(125385);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.gmP.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125385);
        return;
      }
      Toast.makeText(this, getString(2131297614, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(125385);
      return;
    }
    if (paramm.getType() == 755) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = (com.tencent.mm.plugin.account.model.g)paramm;
        if (((com.tencent.mm.plugin.account.model.g)localObject).rr.fsW.fta == null) {
          break label1282;
        }
      }
    }
    label1282:
    for (Object localObject = ((cjy)((com.tencent.mm.plugin.account.model.g)localObject).rr.fsW.fta).xvp;; localObject = "")
    {
      this.gHX = ((String)localObject);
      xy(this.gHM + this.gFX);
      break;
      if (paramInt2 != -7) {
        break;
      }
      this.gDn.cXw = this.gGv;
      this.gDn.cRH = 7L;
      this.gDn.ake();
      com.tencent.mm.ui.base.h.a(this, getString(2131299641), getString(2131297087), getString(2131300536), getString(2131296888), true, new RegByMobileRegAIOUI.11(this), null);
      break;
      if (((paramm.getType() != 701) && (paramm.getType() != 252)) || (paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
      this.gDn.cXw = this.gGv;
      this.gDn.cRH = 12L;
      this.gDn.ake();
      l.aqv();
      z.wz(r.Zn());
      w.cs(this);
      z.showAddrBookUploadConfirm(this, new RegByMobileRegAIOUI.13(this), false, 2);
      AppMethodBeat.o(125385);
      return;
      if ((paramm.getType() == 252) || (paramm.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.kO(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          AppMethodBeat.o(125385);
          return;
        }
      }
      AppMethodBeat.o(125385);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI
 * JD-Core Version:    0.7.0.1
 */