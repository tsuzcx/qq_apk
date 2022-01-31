package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.p;

public class MobileInputUI
  extends MMActivity
{
  protected String countryCode;
  protected String fHT;
  protected int fme;
  private com.tencent.mm.sdk.b.c gCZ;
  protected String gDF;
  protected EditText gDK;
  protected Button gDQ;
  protected Button gDR;
  private View gDS;
  protected Button gDT;
  protected MMFormInputView gEV;
  private ResizeLayout gEb;
  private Button gEk;
  protected int[] gEs;
  protected MMFormInputView gFJ;
  protected EditText gFK;
  protected MMFormVerifyCodeInputView gFL;
  protected View gFM;
  protected CheckBox gFN;
  protected TextView gFO;
  protected Button gFP;
  protected TextView gFQ;
  protected TextView gFR;
  protected TextView gFS;
  protected Button gFT;
  protected View gFU;
  protected boolean gFV;
  protected String gFW;
  protected String gFX;
  private int gFY;
  private MobileInputUI.b gFZ;
  protected boolean gFa;
  private MMKeyboardUperView gFb;
  protected boolean gFc;
  private final int gFe;
  protected boolean gGa;
  protected LinearLayout gtI;
  protected TextView gtK;
  protected String gtM;
  protected String guI;
  protected p gwe;
  
  public MobileInputUI()
  {
    AppMethodBeat.i(125183);
    this.gFV = true;
    this.gFW = null;
    this.gFX = null;
    this.gtM = null;
    this.fHT = null;
    this.countryCode = null;
    this.gDF = null;
    this.gFY = 0;
    this.gEs = new int[5];
    this.gFc = false;
    this.gCZ = new MobileInputUI.1(this);
    this.gFe = 128;
    AppMethodBeat.o(125183);
  }
  
  private static void R(Context paramContext, String paramString)
  {
    AppMethodBeat.i(125196);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
    com.tencent.mm.bq.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(125196);
  }
  
  private boolean arA()
  {
    return this.gFY == 1;
  }
  
  private void arC()
  {
    AppMethodBeat.i(125191);
    hideVKB();
    this.gFZ.a(MobileInputUI.a.gGe);
    AppMethodBeat.o(125191);
  }
  
  private void arD()
  {
    AppMethodBeat.i(125194);
    if ((!bo.isNullOrNil(this.fHT)) && (!bo.isNullOrNil(this.countryCode)))
    {
      this.gtK.setText(av.ig(this.fHT, this.countryCode));
      AppMethodBeat.o(125194);
      return;
    }
    this.gtK.setText(getString(2131301573));
    AppMethodBeat.o(125194);
  }
  
  private boolean arz()
  {
    return this.gFY == 2;
  }
  
  private void goBack()
  {
    AppMethodBeat.i(125192);
    if (this.gGa)
    {
      hideVKB();
      Intent localIntent = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
      localIntent.addFlags(67108864);
      localIntent.putExtra("can_finish", true);
      startActivity(localIntent);
      finish();
      com.tencent.mm.ui.base.b.ig(this);
      AppMethodBeat.o(125192);
      return;
    }
    this.gFZ.a(MobileInputUI.a.gGd);
    com.tencent.mm.plugin.b.a.xD(this.guI);
    hideVKB();
    finish();
    AppMethodBeat.o(125192);
  }
  
  public final boolean arB()
  {
    AppMethodBeat.i(152577);
    if ((this.gFK.getText() != null) && (!bo.isNullOrNil(this.gFK.getText().toString())) && (this.gFV)) {
      if (this.gFY == 2)
      {
        if ((this.gDK.getText() != null) && (!bo.isNullOrNil(this.gDK.getText().toString())))
        {
          AppMethodBeat.o(152577);
          return true;
        }
      }
      else
      {
        AppMethodBeat.o(152577);
        return true;
      }
    }
    AppMethodBeat.o(152577);
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(125187);
    super.finish();
    overridePendingTransition(2131034130, 2131034130);
    com.tencent.mm.plugin.report.service.h.qsU.e(14262, new Object[] { Integer.valueOf(this.gEs[0]), Integer.valueOf(this.gEs[1]), Integer.valueOf(this.gEs[2]), Integer.valueOf(this.gEs[3]), Integer.valueOf(this.gEs[4]) });
    AppMethodBeat.o(125187);
  }
  
  public int getLayoutId()
  {
    return 2130970291;
  }
  
  public void initView()
  {
    AppMethodBeat.i(125190);
    this.gEV = ((MMFormInputView)findViewById(2131826306));
    this.gDK = this.gEV.getContentEditText();
    com.tencent.mm.ui.tools.b.c.d(this.gDK).QS(16).a(null);
    this.gFJ = ((MMFormInputView)findViewById(2131826305));
    this.gFJ.setInputType(3);
    this.gFK = this.gFJ.getContentEditText();
    this.gFL = ((MMFormVerifyCodeInputView)findViewById(2131825464));
    this.gFL.setInputType(3);
    this.gtI = ((LinearLayout)findViewById(2131821765));
    this.gtK = ((TextView)findViewById(2131821767));
    this.gFM = findViewById(2131826307);
    this.gFN = ((CheckBox)findViewById(2131826308));
    this.gFO = ((TextView)findViewById(2131826309));
    this.gFP = ((Button)findViewById(2131822914));
    this.gFQ = ((TextView)findViewById(2131826303));
    this.gFR = ((TextView)findViewById(2131821153));
    this.gFS = ((TextView)findViewById(2131826304));
    this.gFT = ((Button)findViewById(2131825454));
    this.gEk = ((Button)findViewById(2131825456));
    this.gDQ = ((Button)findViewById(2131825458));
    this.gDR = ((Button)findViewById(2131825460));
    this.gDS = findViewById(2131825459);
    this.gDT = ((Button)findViewById(2131825461));
    this.gFU = findViewById(2131826310);
    this.gEb = ((ResizeLayout)findViewById(2131825451));
    this.gFb = ((MMKeyboardUperView)findViewById(2131820935));
    this.gtI.setVisibility(8);
    this.gEV.setVisibility(8);
    this.gFL.setVisibility(8);
    this.gFJ.setVisibility(8);
    this.gFQ.setVisibility(8);
    this.gFR.setVisibility(8);
    this.gFP.setVisibility(8);
    this.gFM.setVisibility(8);
    this.gFT.setVisibility(8);
    this.gEb.setOnSizeChanged(new MobileInputUI.15(this));
    this.gDQ.setOnClickListener(new MobileInputUI.16(this));
    this.gDR.setOnClickListener(new MobileInputUI.17(this));
    Object localObject = new com.tencent.mm.ui.widget.b.d(this, 1, false);
    ((com.tencent.mm.ui.widget.b.d)localObject).sao = new MobileInputUI.18(this);
    ((com.tencent.mm.ui.widget.b.d)localObject).sap = new MobileInputUI.19(this);
    ((com.tencent.mm.ui.widget.b.d)localObject).AGQ = new MobileInputUI.20(this);
    if (aa.dsD())
    {
      this.gDT.setOnClickListener(new MobileInputUI.2(this));
      localObject = new boolean[1];
      localObject[0] = 1;
      this.gFK.setOnFocusChangeListener(new MobileInputUI.4(this, (boolean[])localObject));
      this.gFK.addTextChangedListener(new MobileInputUI.5(this, (boolean[])localObject));
      this.gDK.addTextChangedListener(new MobileInputUI.6(this));
      this.gFK.setOnEditorActionListener(new MobileInputUI.7(this));
      this.gFK.setOnKeyListener(new MobileInputUI.8(this));
      localObject = new boolean[1];
      localObject[0] = 0;
      this.gFP.setEnabled(false);
      this.gFP.setOnTouchListener(new MobileInputUI.9(this, (boolean[])localObject));
      this.gFP.setOnClickListener(new MobileInputUI.10(this, (boolean[])localObject));
      if (!bo.isNullOrNil(this.countryCode)) {
        break label938;
      }
      this.fHT = getString(2131298873);
      this.countryCode = av.apz(getString(2131298872));
      label707:
      if ((bo.isNullOrNil(this.fHT)) || (bo.isNullOrNil(this.countryCode)))
      {
        this.gDF = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        ab.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + this.gDF);
        if (!bo.isNullOrNil(this.gDF)) {
          break label960;
        }
        ab.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
    }
    for (;;)
    {
      arD();
      if (bo.isNullOrNil(this.gtM)) {
        this.gFK.setText(this.gtM);
      }
      this.gtI.setOnClickListener(new MobileInputUI.11(this));
      localObject = "";
      if (com.tencent.mm.protocal.d.whK) {
        localObject = getString(2131297005) + getString(2131296529);
      }
      setMMTitle((String)localObject);
      setActionbarColor(getResources().getColor(2131690316));
      hideActionbarLine();
      AppMethodBeat.o(125190);
      return;
      this.gDS.setVisibility(8);
      this.gDT.setText(2131301124);
      this.gDT.setOnClickListener(new MobileInputUI.3(this, (com.tencent.mm.ui.widget.b.d)localObject));
      break;
      label938:
      this.fHT = com.tencent.mm.au.b.l(this, this.countryCode, getString(2131298871));
      break label707;
      label960:
      localObject = com.tencent.mm.au.b.k(this, this.gDF, getString(2131298871));
      if (localObject == null)
      {
        ab.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
      else
      {
        this.countryCode = av.apz(((b.a)localObject).fHS);
        this.fHT = ((b.a)localObject).fHT;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(125195);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 32047)
    {
      if (paramIntent != null) {
        localObject1 = paramIntent.getBundleExtra("result_data");
      }
      if ((localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("agree_privacy")))
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(712L, 2L, 1L, false);
        if ((this.gFZ instanceof k)) {
          ((k)this.gFZ).gFB = 0;
        }
        this.gFZ.a(MobileInputUI.a.gGe);
        AppMethodBeat.o(125195);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(712L, 1L, 1L, false);
      if ((this.gFZ instanceof k)) {
        ((k)this.gFZ).gFB = 1;
      }
      AppMethodBeat.o(125195);
      return;
    }
    if (paramInt1 == 32046)
    {
      localObject1 = localObject2;
      if (paramIntent != null) {
        localObject1 = paramIntent.getBundleExtra("result_data");
      }
      if ((paramInt2 == -1) && (localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("get_reg_verify_code")))
      {
        if ((this.gFZ instanceof k)) {
          ((k)this.gFZ).gFB = 2;
        }
        this.gFZ.a(MobileInputUI.a.gGe);
      }
      AppMethodBeat.o(125195);
      return;
    }
    if (paramInt1 == 32045)
    {
      localObject1 = localObject3;
      if (paramIntent != null) {
        localObject1 = paramIntent.getBundleExtra("result_data");
      }
      if ((paramInt2 == -1) && (localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("auth_again")) && ((this.gFZ instanceof l))) {
        this.gFZ.a(MobileInputUI.a.gGe);
      }
      AppMethodBeat.o(125195);
      return;
    }
    switch (paramInt2)
    {
    }
    do
    {
      AppMethodBeat.o(125195);
      return;
      this.fHT = bo.bf(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bo.bf(paramIntent.getStringExtra("couttry_code"), "");
      this.gDF = bo.bf(paramIntent.getStringExtra("iso_code"), "");
      if ((this.gFY == 2) && (!com.tencent.mm.au.b.tN(this.countryCode)))
      {
        paramIntent = new Intent(this, RegByMobileRegAIOUI.class);
        paramIntent.putExtra("couttry_code", this.countryCode);
        paramIntent.putExtra("country_name", this.fHT);
        paramIntent.putExtra("iso_code", this.gDF);
        startActivity(paramIntent);
        finish();
        AppMethodBeat.o(125195);
        return;
      }
      arD();
      AppMethodBeat.o(125195);
      return;
    } while ((paramInt1 != 1024) || (paramIntent == null));
    localObject1 = paramIntent.getStringExtra("VoiceLoginAuthPwd");
    paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
    boolean bool = bo.isNullOrNil((String)localObject1);
    if (bo.isNullOrNil((String)localObject1)) {}
    for (paramInt1 = i;; paramInt1 = ((String)localObject1).length())
    {
      ab.d("MicroMsg.MobileInputUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break;
      }
      arC();
      AppMethodBeat.o(125195);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(125184);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(getContext().getResources().getColor(2131690317));
    this.gFY = getIntent().getIntExtra("mobile_input_purpose", 0);
    this.fme = getIntent().getIntExtra("mobile_auth_type", 0);
    this.gGa = getIntent().getBooleanExtra("can_finish", false);
    setBackBtn(new MobileInputUI.12(this), 2131230735);
    setActionbarColor(getContext().getResources().getColor(2131690316));
    hideActionbarLine();
    switch (this.gFY)
    {
    case 0: 
    default: 
      ab.e("MicroMsg.MobileInputUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.gFY) });
      finish();
      AppMethodBeat.o(125184);
      return;
    case 1: 
      if (!bo.isNullOrNil(getIntent().getStringExtra("auth_ticket"))) {
        this.gFZ = new l();
      }
      break;
    }
    for (;;)
    {
      this.countryCode = av.apz(bo.bf(getIntent().getStringExtra("couttry_code"), ""));
      this.fHT = bo.bf(getIntent().getStringExtra("country_name"), "");
      this.gDF = bo.nullAsNil(getIntent().getStringExtra("iso_code"));
      this.gtM = bo.bf(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
      this.gFW = av.apA(this.countryCode);
      this.gFX = bo.bf(getIntent().getStringExtra("input_mobile_number"), "");
      this.guI = com.tencent.mm.plugin.b.a.awy();
      initView();
      this.gFc = getIntent().getBooleanExtra("from_deep_link", false);
      if ((this.gFc) && (!bo.isNullOrNil(this.gFW)) && (!bo.isNullOrNil(this.gFX))) {
        this.gFJ.setText(this.gFX);
      }
      this.gFZ.a(this);
      if (f.EX_DEVICE_LOGIN)
      {
        this.gEk.setVisibility(0);
        this.gEk.setOnClickListener(new MobileInputUI.14(this));
      }
      this.gFa = getIntent().getBooleanExtra("from_switch_account", false);
      AppMethodBeat.o(125184);
      return;
      paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
      if (paramBundle != null) {
        this.gEs = paramBundle;
      }
      this.gFZ = new i();
      continue;
      this.gFZ = new k();
      continue;
      this.gFZ = new h();
      continue;
      this.gFZ = new j();
      continue;
      this.gFZ = new l();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(125188);
    if (arz()) {
      com.tencent.mm.plugin.normsg.a.b.pgQ.VX("ie_reg_eu");
    }
    if (arA()) {
      com.tencent.mm.plugin.normsg.a.b.pgQ.VX("ie_login");
    }
    this.gFL.reset();
    super.onDestroy();
    AppMethodBeat.o(125188);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(125193);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(125193);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(125193);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(125186);
    super.onPause();
    com.tencent.mm.sdk.b.a.ymk.d(this.gCZ);
    this.gFZ.stop();
    AppMethodBeat.o(125186);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(125185);
    com.tencent.mm.sdk.b.a.ymk.c(this.gCZ);
    super.onResume();
    this.gFZ.start();
    AppMethodBeat.o(125185);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setRequestedOrientation(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI
 * JD-Core Version:    0.7.0.1
 */