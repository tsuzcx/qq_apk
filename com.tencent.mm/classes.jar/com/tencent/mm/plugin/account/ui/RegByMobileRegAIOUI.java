package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.az.b.a;
import com.tencent.mm.f.b.a.ms;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.protocal.protobuf.erj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.b.c.a;

public class RegByMobileRegAIOUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private String countryCode;
  private String fSt;
  private ImageView iZG;
  private String lSz;
  private LinearLayout mSs;
  private TextView mSu;
  private String mSw;
  private String mTu;
  private s mUN;
  private IListener ncA;
  private ms ncO;
  private ResizeLayout ndS;
  private String ndg;
  private final int neR;
  private x nex;
  private boolean nfF;
  private String nfH;
  private String nfe;
  private String nff;
  private int nfg;
  private String nfm;
  private TextView nfy;
  private Button nfz;
  private int ngh;
  private EditText nhG;
  private TextView nhH;
  private MMFormInputView nhI;
  private String nhJ;
  private View nhK;
  private CheckBox nhL;
  private MMFormInputView nhM;
  private ImageView nhN;
  private MMFormInputView nhO;
  private Bitmap nhP;
  private ScrollView nhQ;
  private String nhR;
  private String nhS;
  private String nhT;
  private String nhU;
  private boolean nhV;
  private com.tencent.mm.ui.widget.a.d nhW;
  private boolean nhX;
  private int nhY;
  private int nhZ;
  private String nht;
  private boolean nhv;
  private boolean nia;
  private boolean nib;
  
  public RegByMobileRegAIOUI()
  {
    AppMethodBeat.i(128538);
    this.mSw = null;
    this.lSz = null;
    this.countryCode = null;
    this.ndg = null;
    this.nfF = true;
    this.nhJ = null;
    this.nfH = null;
    this.nhv = false;
    this.nfg = 0;
    this.nhV = true;
    this.ncO = new ms();
    this.ncA = new RegByMobileRegAIOUI.1(this);
    this.fSt = "";
    this.nex = new x();
    this.nhW = null;
    this.nhX = false;
    this.neR = 128;
    AppMethodBeat.o(128538);
  }
  
  private boolean a(Editable... paramVarArgs)
  {
    AppMethodBeat.i(128554);
    int i = 0;
    if (i < 3)
    {
      Editable localEditable = paramVarArgs[i];
      if ((localEditable != null) && (localEditable.toString().length() != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((i != 0) && (this.nfF))
      {
        AppMethodBeat.o(128554);
        return true;
        i += 1;
        break;
      }
      AppMethodBeat.o(128554);
      return false;
    }
  }
  
  private void abb(final String paramString)
  {
    AppMethodBeat.i(128546);
    if (!com.tencent.mm.plugin.account.sdk.b.a.T(this, this.nhM.getText().toString()))
    {
      AppMethodBeat.o(128546);
      return;
    }
    if (this.mUN != null) {
      this.mUN.dismiss();
    }
    this.nex.b(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169152);
        RegByMobileRegAIOUI.f(RegByMobileRegAIOUI.this, paramString);
        AppMethodBeat.o(169152);
      }
    });
    AppMethodBeat.o(128546);
  }
  
  private void bxv()
  {
    AppMethodBeat.i(128544);
    com.tencent.mm.plugin.b.a.bkD(this.mTu);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",RE200_100,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("RE200_100") + ",2");
    finish();
    int i = r.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(128544);
  }
  
  private boolean bzC()
  {
    AppMethodBeat.i(128553);
    if (Util.isNullOrNil(this.countryCode)) {}
    for (int i = 0;; i = 1)
    {
      boolean bool = i & a(new Editable[] { this.nhG.getText(), this.nhM.getText(), this.nhO.getText() });
      if (bool) {
        this.nfz.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(128553);
        return bool;
        this.nfz.setEnabled(false);
      }
    }
  }
  
  private void bzE()
  {
    AppMethodBeat.i(128547);
    if ((!Util.isNullOrNil(this.lSz)) && (!Util.isNullOrNil(this.countryCode)))
    {
      this.mSu.setText(PhoneFormater.countryNameWithCode(this.lSz, this.countryCode));
      AppMethodBeat.o(128547);
      return;
    }
    this.mSu.setText(getString(r.j.mobile_code_error));
    AppMethodBeat.o(128547);
  }
  
  private void bzO()
  {
    AppMethodBeat.i(128545);
    if (!Util.isNullOrNil(this.nhS))
    {
      if (this.mUN != null) {
        this.mUN.dismiss();
      }
      getString(r.j.app_tip);
      this.mUN = com.tencent.mm.ui.base.h.a(this, getString(r.j.app_waiting), true, null);
      com.tencent.mm.plugin.account.model.i locali = new com.tencent.mm.plugin.account.model.i(this.nhS);
      com.tencent.mm.kernel.h.aGY().a(locali, 0);
    }
    AppMethodBeat.o(128545);
  }
  
  private void bzP()
  {
    AppMethodBeat.i(128550);
    getString(r.j.app_tip);
    this.mUN = com.tencent.mm.ui.base.h.a(this, getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    int i = bzQ();
    Log.i("MicroMsg.RegByMobileRegAIOUI", "select mobile check type %d", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.modelfriend.a locala = new com.tencent.mm.modelfriend.a(this.nhJ + this.nfH, 14, "", 0, "", i);
    locala.VH(this.nfm);
    com.tencent.mm.kernel.h.aGY().a(locala, 0);
    AppMethodBeat.o(128550);
  }
  
  private int bzQ()
  {
    AppMethodBeat.i(214028);
    if (!Util.isNullOrNil(this.nhS))
    {
      AppMethodBeat.o(214028);
      return 1;
    }
    Log.i("MicroMsg.RegByMobileRegAIOUI", "isMobile:%s, isMobileOpen:%s, SIM iso:%s", new Object[] { Boolean.valueOf(NetStatusUtil.isMobile(this)), Boolean.valueOf(NetStatusUtil.isMobileNetworkOpen(this)), com.tencent.mm.compatible.deviceinfo.q.auI() });
    if ((NetStatusUtil.isMobile(this)) || ((NetStatusUtil.isMobileNetworkOpen(this)) && (!Util.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.auI()))))
    {
      AppMethodBeat.o(214028);
      return 2;
    }
    AppMethodBeat.o(214028);
    return 1;
  }
  
  private void bzR()
  {
    try
    {
      AppMethodBeat.i(128552);
      if (!this.nhX)
      {
        this.nhX = true;
        finish();
        Intent localIntent = new Intent();
        localIntent.putExtra("bindmcontact_mobile", this.nhJ + " " + this.nhG.getText().toString());
        localIntent.putExtra("bindmcontact_shortmobile", this.nfH);
        localIntent.putExtra("country_name", this.lSz);
        localIntent.putExtra("couttry_code", this.countryCode);
        localIntent.putExtra("mobileverify_countdownsec", this.nhY);
        localIntent.putExtra("mobileverify_countdownstyle", this.nhZ);
        localIntent.putExtra("mobileverify_fb", this.nia);
        localIntent.putExtra("mobileverify_reg_qq", this.nib);
        localIntent.putExtra("kintent_nickname", this.nhO.getText().toString());
        localIntent.putExtra("kintent_password", this.nhM.getText().toString());
        localIntent.putExtra("kintent_hasavatar", this.nhv);
        localIntent.putExtra("key_reg_style", 1);
        localIntent.putExtra("regsession_id", this.nfm);
        localIntent.putExtra("reg_3d_app_ticket", this.nhT);
        localIntent.putExtra("reg_3d_app_type", this.ngh);
        localIntent.putExtra("mobile_verify_purpose", 2);
        startActivity(MobileVerifyUI.class, localIntent);
      }
      AppMethodBeat.o(128552);
      return;
    }
    finally {}
  }
  
  public int getLayoutId()
  {
    return r.g.regbymobile_reg_aio;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128542);
    this.mSs = ((LinearLayout)findViewById(r.f.country_code_ll));
    this.mSu = ((TextView)findViewById(r.f.country_name));
    this.nhH = ((TextView)findViewById(r.f.reg_title));
    this.nhI = ((MMFormInputView)findViewById(r.f.regbymobilereg_mobile_input_view));
    this.nhI.setInputType(3);
    this.nhG = this.nhI.getContentEditText();
    this.nhK = findViewById(r.f.term_container);
    this.nhL = ((CheckBox)findViewById(r.f.reg_term_check));
    this.nfy = ((TextView)findViewById(r.f.reg_term));
    this.nfz = ((Button)findViewById(r.f.reg_next));
    this.iZG = ((ImageView)findViewById(r.f.setinfo_avatar));
    this.nhN = ((ImageView)findViewById(r.f.setinfo_camera));
    this.nhM = ((MMFormInputView)findViewById(r.f.regbymobile_setpassword_container));
    com.tencent.mm.ui.tools.b.c.i(this.nhM.getContentEditText()).axx(16).a(null);
    this.nhQ = ((ScrollView)findViewById(r.f.scrollView));
    this.ndS = ((ResizeLayout)findViewById(r.f.resize_lv));
    this.nhO = ((MMFormInputView)findViewById(r.f.reg_nick_input_view));
    this.ndS.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void bzv()
      {
        AppMethodBeat.i(128525);
        RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(128525);
      }
    });
    this.nhL.setOnCheckedChangeListener(new RegByMobileRegAIOUI.19(this));
    this.nfy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128530);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = com.tencent.mm.az.b.by(RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this), RegByMobileRegAIOUI.this.getString(r.j.country_code));
        com.tencent.mm.plugin.account.sdk.b.a.b(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.this.getString(r.j.url_agreement, new Object[] { LocaleUtil.getApplicationLanguage(), paramAnonymousView }), 0, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128530);
      }
    });
    Object localObject = new boolean[1];
    localObject[0] = 1;
    this.nhG.addTextChangedListener(new RegByMobileRegAIOUI.21(this, (boolean[])localObject));
    this.nhG.setOnFocusChangeListener(new RegByMobileRegAIOUI.22(this, (boolean[])localObject));
    this.nhM.addTextChangedListener(new RegByMobileRegAIOUI.23(this));
    this.nhO.addTextChangedListener(new RegByMobileRegAIOUI.24(this));
    localObject = new boolean[1];
    localObject[0] = 0;
    this.nfz.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(128537);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(128537);
          return false;
          this.nez[0] = true;
          RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this, com.tencent.mm.plugin.normsg.a.c.aaA(1));
          com.tencent.mm.plugin.normsg.a.d.GxJ.av("ce_reg", "<Reg>", RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this));
          continue;
          com.tencent.mm.plugin.normsg.a.d.GxJ.a("ce_reg", paramAnonymousMotionEvent);
          com.tencent.mm.plugin.normsg.a.d.GxJ.aTm("ce_reg");
        }
      }
    });
    this.nfz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128510);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (this.nez[0] != 0) {
          this.nez[0] = false;
        }
        while (!RegByMobileRegAIOUI.e(RegByMobileRegAIOUI.this).isChecked())
        {
          paramAnonymousView = AnimationUtils.loadAnimation(RegByMobileRegAIOUI.this, r.a.anim_shake_horizontal);
          RegByMobileRegAIOUI.f(RegByMobileRegAIOUI.this).startAnimation(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128510);
          return;
          RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this, com.tencent.mm.plugin.normsg.a.c.aaA(1));
          com.tencent.mm.plugin.normsg.a.d.GxJ.av("ce_reg", "<Reg>", RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this));
          paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
          com.tencent.mm.plugin.normsg.a.d.GxJ.a("ce_reg", paramAnonymousView);
          com.tencent.mm.plugin.normsg.a.d.GxJ.aTm("ce_reg");
        }
        com.tencent.mm.ui.tools.b.c.i(RegByMobileRegAIOUI.n(RegByMobileRegAIOUI.this).getContentEditText()).mM(1, 32).Hh(true).a(new c.a()
        {
          public final void abc(String paramAnonymous2String)
          {
            AppMethodBeat.i(128507);
            RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this, PhoneFormater.pureNumber(RegByMobileRegAIOUI.g(RegByMobileRegAIOUI.this).getText().toString()));
            RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this, PhoneFormater.countryCodeWithPlus(RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this)));
            paramAnonymous2String = RegByMobileRegAIOUI.h(RegByMobileRegAIOUI.this) + RegByMobileRegAIOUI.i(RegByMobileRegAIOUI.this);
            RegByMobileRegAIOUI.this.hideVKB();
            if (RegByMobileRegAIOUI.j(RegByMobileRegAIOUI.this))
            {
              if (Util.isNullOrNil(RegByMobileRegAIOUI.k(RegByMobileRegAIOUI.this))) {
                RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this, com.tencent.mm.az.b.by(RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this), RegByMobileRegAIOUI.this.getString(r.j.country_code)));
              }
              paramAnonymous2String = RegByMobileRegAIOUI.this.getString(r.j.license_read_url, new Object[] { LocaleUtil.getApplicationLanguage(), RegByMobileRegAIOUI.k(RegByMobileRegAIOUI.this), "reg", Integer.valueOf(1), Integer.valueOf(0) });
              com.tencent.mm.plugin.account.sdk.b.a.b(RegByMobileRegAIOUI.this, paramAnonymous2String, 30847, false);
              AppMethodBeat.o(128507);
              return;
            }
            if (!Util.isNullOrNil(RegByMobileRegAIOUI.l(RegByMobileRegAIOUI.this)))
            {
              RegByMobileRegAIOUI.m(RegByMobileRegAIOUI.this);
              AppMethodBeat.o(128507);
              return;
            }
            RegByMobileRegAIOUI.e(RegByMobileRegAIOUI.this, paramAnonymous2String);
            AppMethodBeat.o(128507);
          }
          
          public final void abd(String paramAnonymous2String)
          {
            AppMethodBeat.i(216790);
            com.tencent.mm.ui.base.h.p(RegByMobileRegAIOUI.this, r.j.settings_modify_name_invalid_less, r.j.settings_modify_name_title);
            AppMethodBeat.o(216790);
          }
          
          public final void dN(String paramAnonymous2String)
          {
            AppMethodBeat.i(169145);
            com.tencent.mm.ui.base.h.p(RegByMobileRegAIOUI.this, r.j.settings_modify_name_invalid_more, r.j.settings_modify_name_title);
            AppMethodBeat.o(169145);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128510);
      }
    });
    this.nfz.setEnabled(false);
    if (WeChatSomeFeatureSwitch.onlyUSMobile())
    {
      this.countryCode = "1";
      this.lSz = com.tencent.mm.az.b.bx(this.countryCode, getString(r.j.country_code));
    }
    if (Util.isNullOrNil(this.countryCode))
    {
      this.lSz = getString(r.j.country_normal_name);
      this.countryCode = PhoneFormater.pureCountryCode(getString(r.j.country_normal_code));
      if (!Util.isNullOrNil(this.nhR)) {
        this.nhH.setText(this.nhR);
      }
      if ((Util.isNullOrNil(this.lSz)) || (Util.isNullOrNil(this.countryCode)))
      {
        this.ndg = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        Log.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + this.ndg);
        if (!Util.isNullOrNil(this.ndg)) {
          break label799;
        }
        Log.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
      }
      label569:
      bzE();
      if ((this.mSw != null) && (!this.mSw.equals(""))) {
        this.nhG.setText(this.mSw);
      }
      this.mSs.setOnClickListener(new RegByMobileRegAIOUI.3(this));
      setBackBtn(new RegByMobileRegAIOUI.4(this), r.i.actionbar_icon_close_black);
      this.iZG.setOnClickListener(new RegByMobileRegAIOUI.5(this));
      if (!Util.isNullOrNil(this.nhS)) {
        break label849;
      }
      com.tencent.mm.kernel.h.aHJ().postAtFrontOfWorker(new RegByMobileRegAIOUI.6(this));
    }
    for (;;)
    {
      localObject = "";
      if ((com.tencent.mm.protocal.d.RAG) || (BuildInfo.IS_FLAVOR_BLUE)) {
        localObject = getString(r.j.app_name) + com.tencent.mm.cj.h.kv(this);
      }
      setMMTitle((String)localObject);
      setActionbarColor(getResources().getColor(r.c.white));
      hideActionbarLine();
      if (com.tencent.mm.compatible.util.d.qV(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(r.c.white));
        updataStatusBarIcon(ar.isDarkMode());
      }
      AppMethodBeat.o(128542);
      return;
      this.lSz = com.tencent.mm.az.b.bx(this.countryCode, getString(r.j.country_code));
      break;
      label799:
      localObject = com.tencent.mm.az.b.bw(this.ndg, getString(r.j.country_code));
      if (localObject == null)
      {
        Log.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
        break label569;
      }
      this.lSz = ((b.a)localObject).lSz;
      this.countryCode = ((b.a)localObject).lSy;
      break label569;
      label849:
      this.nhO.setText(this.nht);
      com.tencent.mm.kernel.h.aHJ().postAtFrontOfWorker(new RegByMobileRegAIOUI.7(this));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(128548);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 30846)
    {
      if ((paramInt2 == -1) && (bzC()))
      {
        bzP();
        com.tencent.mm.plugin.b.a.bkD("RE200_250");
        AppMethodBeat.o(128548);
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
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(712L, 2L, 1L, false);
        this.nhV = false;
        if (!Util.isNullOrNil(this.nhS))
        {
          bzO();
          AppMethodBeat.o(128548);
          return;
        }
        abb(this.nhJ + this.nfH);
        AppMethodBeat.o(128548);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(712L, 1L, 1L, false);
      AppMethodBeat.o(128548);
      return;
    }
    switch (paramInt2)
    {
    default: 
      this.nhP = com.tencent.mm.plugin.account.sdk.a.mIH.b(this, paramInt1, paramInt2, paramIntent);
      if (this.nhP != null)
      {
        this.iZG.setImageBitmap(this.nhP);
        this.nhv = true;
        this.nhN.setVisibility(8);
      }
      AppMethodBeat.o(128548);
      return;
    }
    this.lSz = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
    this.countryCode = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
    this.ndg = Util.nullAs(paramIntent.getStringExtra("iso_code"), "");
    if (com.tencent.mm.az.b.WG(this.countryCode))
    {
      if ((!Util.isNullOrNil(this.nhS)) && (!Util.isNullOrNil(this.nht)) && (!Util.isNullOrNil(this.nhU)))
      {
        bzE();
        AppMethodBeat.o(128548);
        return;
      }
      paramIntent = new Intent(this, MobileInputUI.class);
      paramIntent.putExtra("mobile_input_purpose", 2);
      paramIntent.putExtra("couttry_code", this.countryCode);
      paramIntent.putExtra("country_name", this.lSz);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      paramInt1 = r.a.anim_not_change;
      overridePendingTransition(paramInt1, paramInt1);
      AppMethodBeat.o(128548);
      return;
    }
    bzE();
    AppMethodBeat.o(128548);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128539);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    this.lSz = Util.nullAs(getIntent().getStringExtra("country_name"), "");
    this.countryCode = PhoneFormater.pureCountryCode(Util.nullAs(getIntent().getStringExtra("couttry_code"), ""));
    this.ndg = Util.nullAsNil(getIntent().getStringExtra("iso_code"));
    this.mSw = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.nhR = getIntent().getStringExtra("register_title");
    this.nht = getIntent().getStringExtra("register_nick_name");
    this.nhU = getIntent().getStringExtra("register_avatar");
    this.nhS = getIntent().getStringExtra("third_app_token");
    this.ngh = getIntent().getIntExtra("reg_3d_app_type", 0);
    initView();
    AppMethodBeat.o(128539);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128551);
    com.tencent.mm.plugin.normsg.a.d.GxJ.aTj("ie_reg");
    if (this.nhW != null) {
      this.nhW.dismiss();
    }
    this.ncO.bpa();
    super.onDestroy();
    AppMethodBeat.o(128551);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128543);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      bxv();
      AppMethodBeat.o(128543);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128543);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128541);
    super.onPause();
    if (this.mUN != null) {
      this.mUN.dismiss();
    }
    EventCenter.instance.removeListener(this.ncA);
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    com.tencent.mm.kernel.h.aGY().b(145, this);
    com.tencent.mm.kernel.h.aGY().b(132, this);
    com.tencent.mm.kernel.h.aGY().b(755, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.plugin.b.a.bgi("RE200_100");
    AppMethodBeat.o(128541);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169153);
    if (paramInt == 34)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        com.tencent.mm.plugin.account.sdk.a.mIH.r(this);
        AppMethodBeat.o(169153);
      }
    }
    else {
      this.nex.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(169153);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128540);
    EventCenter.instance.addListener(this.ncA);
    super.onResume();
    com.tencent.mm.kernel.h.aGY().a(701, this);
    com.tencent.mm.kernel.h.aGY().a(252, this);
    com.tencent.mm.kernel.h.aGY().a(145, this);
    com.tencent.mm.kernel.h.aGY().a(132, this);
    com.tencent.mm.kernel.h.aGY().a(755, this);
    com.tencent.mm.kernel.h.aGY().a(252, this);
    com.tencent.mm.kernel.h.aGY().a(701, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",RE200_100,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("RE200_100") + ",1");
    this.nfg = 0;
    AppMethodBeat.o(128540);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(128549);
    Log.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.mUN != null)
    {
      this.mUN.dismiss();
      this.mUN = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.p(this, r.j.alpha_version_tip_reg, r.j.reg_username_exist_title);
      AppMethodBeat.o(128549);
      return;
    }
    if (paramq.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramq).ZB();
      if (i == 12)
      {
        if ((paramInt2 == -41) || (paramInt2 == -59))
        {
          paramString = com.tencent.mm.h.a.Kb(paramString);
          if (paramString != null)
          {
            paramString.a(this, null, null);
            AppMethodBeat.o(128549);
            return;
          }
          com.tencent.mm.ui.base.h.p(this, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
          AppMethodBeat.o(128549);
          return;
        }
        this.nfH = PhoneFormater.pureNumber(this.nfH);
        this.nff = (this.nhJ + this.nfH);
        this.nfm = ((com.tencent.mm.modelfriend.a)paramq).blk();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramq = ((com.tencent.mm.modelfriend.a)paramq).bkY();
          if (!Util.isNullOrNil(paramq)) {
            this.nfH = paramq.trim();
          }
          com.tencent.mm.plugin.b.a.bgi("RE200_100");
          paramq = new StringBuilder();
          com.tencent.mm.kernel.h.aHE();
          paramq = paramq.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",RE200_200,");
          com.tencent.mm.kernel.h.aHE();
          com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("RE200_200") + ",1");
          paramString = com.tencent.mm.h.a.Kb(paramString);
          if (paramString != null)
          {
            paramString.a(this, new RegByMobileRegAIOUI.11(this), new RegByMobileRegAIOUI.13(this));
            AppMethodBeat.o(128549);
            return;
          }
          bzP();
          com.tencent.mm.plugin.b.a.bkD("RE200_250");
          AppMethodBeat.o(128549);
          return;
        }
        if (paramInt2 == -355)
        {
          y.f(this, paramString, 30846);
          this.ncO.gVr = this.ngh;
          this.ncO.gef = 5L;
          this.ncO.bpa();
          AppMethodBeat.o(128549);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.c(this, getString(r.j.bind_mcontact_err_freq_limit), "", true);
          AppMethodBeat.o(128549);
          return;
        }
        if (com.tencent.mm.plugin.account.sdk.a.mIH.a(this, paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(128549);
          return;
        }
        Toast.makeText(this, getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      Object localObject2;
      if (i == 14)
      {
        if (paramInt2 != 0) {
          break label1169;
        }
        i = ((com.tencent.mm.modelfriend.a)paramq).bkZ();
        if (i != 2) {
          break label837;
        }
        localObject1 = ((com.tencent.mm.modelfriend.a)paramq).blc();
        if (localObject1 != null)
        {
          Log.i("MicroMsg.RegByMobileRegAIOUI", "network check url %s", new Object[] { ((dbz)localObject1).url });
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Key_Seq", ((dbz)localObject1).seq);
          ((Intent)localObject2).putExtra("Key_Url", ((dbz)localObject1).url);
          ((Intent)localObject2).putExtra("Key_CountryCode", this.nhJ);
          ((Intent)localObject2).putExtra("Key_Mobile", this.nfH);
          ((Intent)localObject2).putExtra("Key_reg_sessionId", this.nfm);
          ((Intent)localObject2).putExtra("kintent_nickname", this.nhO.getText().toString());
          ((Intent)localObject2).putExtra("kintent_password", this.nhM.getText().toString());
          ((Intent)localObject2).putExtra("kintent_hasavatar", this.nhv);
          ((Intent)localObject2).setClass(this, RegByMobileAutoVerifyUI.class);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      while (com.tencent.mm.plugin.account.sdk.a.mIH.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128549);
        return;
        label837:
        if (i == 1)
        {
          localObject1 = this.nhJ + this.nfH;
          localObject2 = ((com.tencent.mm.modelfriend.a)paramq).blb();
          String str = ((com.tencent.mm.modelfriend.a)paramq).bla();
          Intent localIntent = new Intent(this, RegByMobileSendSmsUI.class);
          localIntent.putExtra("regsession_id", this.nfm);
          localIntent.putExtra("key_reg_style", 1);
          localIntent.putExtra("from_mobile", (String)localObject1);
          localIntent.putExtra("to_mobile", (String)localObject2);
          localIntent.putExtra("verify_code", str);
          localIntent.putExtra("kintent_nickname", this.nhO.getText().toString());
          localIntent.putExtra("kintent_password", this.nhM.getText().toString());
          localIntent.putExtra("kintent_hasavatar", this.nhv);
          localIntent.putExtra("reg_3d_app_type", this.ngh);
          localIntent.putExtra("reg_3d_app_ticket", this.nhT);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          this.nhY = ((com.tencent.mm.modelfriend.a)paramq).ble();
          this.nhZ = ((com.tencent.mm.modelfriend.a)paramq).blf();
          this.nia = ((com.tencent.mm.modelfriend.a)paramq).blg();
          this.nib = ((com.tencent.mm.modelfriend.a)paramq).blh();
          bzR();
        }
      }
      label1169:
      if (paramInt2 == -41)
      {
        com.tencent.mm.ui.base.h.p(this, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
        AppMethodBeat.o(128549);
        return;
      }
      if (paramInt2 == -34)
      {
        com.tencent.mm.ui.base.h.c(this, getString(r.j.bind_mcontact_err_freq_limit), "", true);
        AppMethodBeat.o(128549);
        return;
      }
      if (com.tencent.mm.plugin.account.sdk.a.mIH.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128549);
        return;
      }
      Toast.makeText(this, getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128549);
      return;
    }
    if (paramq.getType() == 755) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = (com.tencent.mm.plugin.account.model.i)paramq;
        if (d.c.b(((com.tencent.mm.plugin.account.model.i)localObject1).rr.lBS) == null) {
          break label1610;
        }
      }
    }
    label1610:
    for (Object localObject1 = ((erj)d.c.b(((com.tencent.mm.plugin.account.model.i)localObject1).rr.lBS)).TKj;; localObject1 = "")
    {
      this.nhT = ((String)localObject1);
      abb(this.nhJ + this.nfH);
      break;
      if (paramInt2 != -7) {
        break;
      }
      this.ncO.gVr = this.ngh;
      this.ncO.gef = 7L;
      this.ncO.bpa();
      com.tencent.mm.ui.base.h.a(this, getString(r.j.facebooklogin_user_bind_already), getString(r.j.app_tip), getString(r.j.go_to_login), getString(r.j.app_cancel), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(221527);
          RegByMobileRegAIOUI.y(RegByMobileRegAIOUI.this);
          RegByMobileRegAIOUI.A(RegByMobileRegAIOUI.this).gVr = RegByMobileRegAIOUI.z(RegByMobileRegAIOUI.this);
          RegByMobileRegAIOUI.A(RegByMobileRegAIOUI.this).gef = 8L;
          RegByMobileRegAIOUI.A(RegByMobileRegAIOUI.this).bpa();
          AppMethodBeat.o(221527);
        }
      }, null);
      break;
      if (((paramq.getType() != 701) && (paramq.getType() != 252)) || (paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
      this.ncO.gVr = this.ngh;
      this.ncO.gef = 12L;
      this.ncO.bpa();
      com.tencent.mm.plugin.account.friend.a.l.byn();
      y.ZV(z.bcZ());
      com.tencent.mm.platformtools.t.jdMethod_do(this);
      y.showAddrBookUploadConfirm(this, new RegByMobileRegAIOUI.15(this), false, 2);
      AppMethodBeat.o(128549);
      return;
      if ((paramq.getType() == 252) || (paramq.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.Kb(paramString);
        if ((paramString != null) && (paramString.a(this, null, null)))
        {
          AppMethodBeat.o(128549);
          return;
        }
      }
      AppMethodBeat.o(128549);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI
 * JD-Core Version:    0.7.0.1
 */