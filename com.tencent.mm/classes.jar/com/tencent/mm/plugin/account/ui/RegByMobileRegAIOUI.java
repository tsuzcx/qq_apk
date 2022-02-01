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
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.protocal.protobuf.ehh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.tools.b.c.a;

public class RegByMobileRegAIOUI
  extends MMActivity
  implements i
{
  private String countryCode;
  private String dYB;
  private ImageView gvv;
  private String jbZ;
  private LinearLayout kaX;
  private TextView kaZ;
  private String kbV;
  private String kbb;
  private com.tencent.mm.ui.base.q kdn;
  private IListener kkK;
  private ka kkY;
  private String klq;
  private x kmF;
  private final int kmZ;
  private ResizeLayout kmb;
  private TextView knG;
  private Button knH;
  private boolean knN;
  private String knP;
  private String knm;
  private String knn;
  private int kno;
  private String knu;
  private int kop;
  private String kpG;
  private boolean kpI;
  private EditText kpT;
  private TextView kpU;
  private MMFormInputView kpV;
  private String kpW;
  private View kpX;
  private CheckBox kpY;
  private MMFormInputView kpZ;
  private ImageView kqa;
  private MMFormInputView kqb;
  private Bitmap kqc;
  private ScrollView kqd;
  private String kqe;
  private String kqf;
  private String kqg;
  private String kqh;
  private boolean kqi;
  private com.tencent.mm.ui.widget.a.d kqj;
  private boolean kqk;
  private int kql;
  private int kqm;
  private boolean kqn;
  private boolean kqo;
  
  public RegByMobileRegAIOUI()
  {
    AppMethodBeat.i(128538);
    this.kbb = null;
    this.jbZ = null;
    this.countryCode = null;
    this.klq = null;
    this.knN = true;
    this.kpW = null;
    this.knP = null;
    this.kpI = false;
    this.kno = 0;
    this.kqi = true;
    this.kkY = new ka();
    this.kkK = new RegByMobileRegAIOUI.1(this);
    this.dYB = "";
    this.kmF = new x();
    this.kqj = null;
    this.kqk = false;
    this.kmZ = 128;
    AppMethodBeat.o(128538);
  }
  
  private void Tv(final String paramString)
  {
    AppMethodBeat.i(128546);
    if (!com.tencent.mm.plugin.account.a.b.a.V(this, this.kpZ.getText().toString()))
    {
      AppMethodBeat.o(128546);
      return;
    }
    if (this.kdn != null) {
      this.kdn.dismiss();
    }
    this.kmF.b(this, new Runnable()
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
      if ((i != 0) && (this.knN))
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
  
  private void bnm()
  {
    AppMethodBeat.i(128544);
    com.tencent.mm.plugin.b.a.bwV(this.kbV);
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE200_100,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("RE200_100") + ",2");
    finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(128544);
  }
  
  private void bpC()
  {
    AppMethodBeat.i(128545);
    if (!Util.isNullOrNil(this.kqf))
    {
      if (this.kdn != null) {
        this.kdn.dismiss();
      }
      getString(2131755998);
      this.kdn = com.tencent.mm.ui.base.h.a(this, getString(2131756029), true, null);
      j localj = new j(this.kqf);
      g.azz().a(localj, 0);
    }
    AppMethodBeat.o(128545);
  }
  
  private void bpD()
  {
    AppMethodBeat.i(128550);
    getString(2131755998);
    this.kdn = com.tencent.mm.ui.base.h.a(this, getString(2131764376), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    int i = bpE();
    Log.i("MicroMsg.RegByMobileRegAIOUI", "select mobile check type %d", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.modelfriend.a locala = new com.tencent.mm.modelfriend.a(this.kpW + this.knP, 14, "", 0, "", i);
    locala.Ok(this.knu);
    g.azz().a(locala, 0);
    AppMethodBeat.o(128550);
  }
  
  private int bpE()
  {
    AppMethodBeat.i(196929);
    if (!Util.isNullOrNil(this.kqf))
    {
      AppMethodBeat.o(196929);
      return 1;
    }
    Log.i("MicroMsg.RegByMobileRegAIOUI", "isMobile:%s, isMobileOpen:%s, SIM iso:%s", new Object[] { Boolean.valueOf(NetStatusUtil.isMobile(this)), Boolean.valueOf(NetStatusUtil.isMobileNetworkOpen(this)), com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso() });
    if ((NetStatusUtil.isMobile(this)) || ((NetStatusUtil.isMobileNetworkOpen(this)) && (!Util.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso()))))
    {
      AppMethodBeat.o(196929);
      return 2;
    }
    AppMethodBeat.o(196929);
    return 1;
  }
  
  private void bpF()
  {
    try
    {
      AppMethodBeat.i(128552);
      if (!this.kqk)
      {
        this.kqk = true;
        finish();
        Intent localIntent = new Intent();
        localIntent.putExtra("bindmcontact_mobile", this.kpW + " " + this.kpT.getText().toString());
        localIntent.putExtra("bindmcontact_shortmobile", this.knP);
        localIntent.putExtra("country_name", this.jbZ);
        localIntent.putExtra("couttry_code", this.countryCode);
        localIntent.putExtra("mobileverify_countdownsec", this.kql);
        localIntent.putExtra("mobileverify_countdownstyle", this.kqm);
        localIntent.putExtra("mobileverify_fb", this.kqn);
        localIntent.putExtra("mobileverify_reg_qq", this.kqo);
        localIntent.putExtra("kintent_nickname", this.kqb.getText().toString());
        localIntent.putExtra("kintent_password", this.kpZ.getText().toString());
        localIntent.putExtra("kintent_hasavatar", this.kpI);
        localIntent.putExtra("key_reg_style", 1);
        localIntent.putExtra("regsession_id", this.knu);
        localIntent.putExtra("reg_3d_app_ticket", this.kqg);
        localIntent.putExtra("reg_3d_app_type", this.kop);
        localIntent.putExtra("mobile_verify_purpose", 2);
        startActivity(MobileVerifyUI.class, localIntent);
      }
      AppMethodBeat.o(128552);
      return;
    }
    finally {}
  }
  
  private boolean bpq()
  {
    AppMethodBeat.i(128553);
    if (Util.isNullOrNil(this.countryCode)) {}
    for (int i = 0;; i = 1)
    {
      boolean bool = i & a(new Editable[] { this.kpT.getText(), this.kpZ.getText(), this.kqb.getText() });
      if (bool) {
        this.knH.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(128553);
        return bool;
        this.knH.setEnabled(false);
      }
    }
  }
  
  private void bps()
  {
    AppMethodBeat.i(128547);
    if ((!Util.isNullOrNil(this.jbZ)) && (!Util.isNullOrNil(this.countryCode)))
    {
      this.kaZ.setText(PhoneFormater.countryNameWithCode(this.jbZ, this.countryCode));
      AppMethodBeat.o(128547);
      return;
    }
    this.kaZ.setText(getString(2131763071));
    AppMethodBeat.o(128547);
  }
  
  public int getLayoutId()
  {
    return 2131496086;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128542);
    this.kaX = ((LinearLayout)findViewById(2131299269));
    this.kaZ = ((TextView)findViewById(2131299271));
    this.kpU = ((TextView)findViewById(2131306799));
    this.kpV = ((MMFormInputView)findViewById(2131306807));
    this.kpV.setInputType(3);
    this.kpT = this.kpV.getContentEditText();
    this.kpX = findViewById(2131308966);
    this.kpY = ((CheckBox)findViewById(2131306798));
    this.knG = ((TextView)findViewById(2131306797));
    this.knH = ((Button)findViewById(2131306792));
    this.gvv = ((ImageView)findViewById(2131307659));
    this.kqa = ((ImageView)findViewById(2131307661));
    this.kpZ = ((MMFormInputView)findViewById(2131306804));
    com.tencent.mm.ui.tools.b.c.f(this.kpZ.getContentEditText()).aoq(16).a(null);
    this.kqd = ((ScrollView)findViewById(2131307332));
    this.kmb = ((ResizeLayout)findViewById(2131307029));
    this.kqb = ((MMFormInputView)findViewById(2131306794));
    this.kmb.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void bpj()
      {
        AppMethodBeat.i(128525);
        RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(128525);
      }
    });
    this.kpY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(128529);
        RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(128529);
      }
    });
    this.knG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128530);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = com.tencent.mm.aw.b.bu(RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this), RegByMobileRegAIOUI.this.getString(2131758198));
        com.tencent.mm.plugin.account.a.b.a.b(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.this.getString(2131766959, new Object[] { LocaleUtil.getApplicationLanguage(), paramAnonymousView }), 0, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128530);
      }
    });
    Object localObject = new boolean[1];
    localObject[0] = 1;
    this.kpT.addTextChangedListener(new TextWatcher()
    {
      private PhoneFormater kqv;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128532);
        RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(128532);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(128533);
        if (this.kqw[0] != 0)
        {
          this.kqw[0] = false;
          com.tencent.mm.plugin.normsg.a.d.AEF.aIL("ie_reg");
        }
        com.tencent.mm.plugin.normsg.a.d.AEF.aIM("ie_reg");
        AppMethodBeat.o(128533);
      }
    });
    this.kpT.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(128534);
        if (paramAnonymousBoolean)
        {
          this.kqw[0] = true;
          AppMethodBeat.o(128534);
          return;
        }
        com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_reg");
        AppMethodBeat.o(128534);
      }
    });
    this.kpZ.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128535);
        RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(128535);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.kqb.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128536);
        RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(128536);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    localObject = new boolean[1];
    localObject[0] = 0;
    this.knH.setOnTouchListener(new View.OnTouchListener()
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
          this.kmH[0] = true;
          RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this, com.tencent.mm.plugin.normsg.a.c.TN(1));
          com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_reg", "<Reg>", RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this));
          continue;
          com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_reg", paramAnonymousMotionEvent);
          com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_reg");
        }
      }
    });
    this.knH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128510);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (this.kmH[0] != 0) {
          this.kmH[0] = false;
        }
        while (!RegByMobileRegAIOUI.e(RegByMobileRegAIOUI.this).isChecked())
        {
          paramAnonymousView = AnimationUtils.loadAnimation(RegByMobileRegAIOUI.this, 2130771995);
          RegByMobileRegAIOUI.f(RegByMobileRegAIOUI.this).startAnimation(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128510);
          return;
          RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this, com.tencent.mm.plugin.normsg.a.c.TN(1));
          com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_reg", "<Reg>", RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this));
          paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
          com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_reg", paramAnonymousView);
          com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_reg");
        }
        com.tencent.mm.ui.tools.b.c.f(RegByMobileRegAIOUI.n(RegByMobileRegAIOUI.this).getContentEditText()).lv(1, 32).CN(true).a(new c.a()
        {
          public final void Tw(String paramAnonymous2String)
          {
            AppMethodBeat.i(128507);
            RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this, PhoneFormater.pureNumber(RegByMobileRegAIOUI.g(RegByMobileRegAIOUI.this).getText().toString()));
            RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this, PhoneFormater.countryCodeWithPlus(RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this)));
            paramAnonymous2String = RegByMobileRegAIOUI.h(RegByMobileRegAIOUI.this) + RegByMobileRegAIOUI.i(RegByMobileRegAIOUI.this);
            RegByMobileRegAIOUI.this.hideVKB();
            if (RegByMobileRegAIOUI.j(RegByMobileRegAIOUI.this))
            {
              if (Util.isNullOrNil(RegByMobileRegAIOUI.k(RegByMobileRegAIOUI.this))) {
                RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this, com.tencent.mm.aw.b.bu(RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this), RegByMobileRegAIOUI.this.getString(2131758198)));
              }
              paramAnonymous2String = RegByMobileRegAIOUI.this.getString(2131762219, new Object[] { LocaleUtil.getApplicationLanguage(), RegByMobileRegAIOUI.k(RegByMobileRegAIOUI.this), "reg", Integer.valueOf(1), Integer.valueOf(0) });
              com.tencent.mm.plugin.account.a.b.a.b(RegByMobileRegAIOUI.this, paramAnonymous2String, 30847, false);
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
          
          public final void Tx(String paramAnonymous2String)
          {
            AppMethodBeat.i(196921);
            com.tencent.mm.ui.base.h.n(RegByMobileRegAIOUI.this, 2131765471, 2131765474);
            AppMethodBeat.o(196921);
          }
          
          public final void dv(String paramAnonymous2String)
          {
            AppMethodBeat.i(169145);
            com.tencent.mm.ui.base.h.n(RegByMobileRegAIOUI.this, 2131765472, 2131765474);
            AppMethodBeat.o(169145);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128510);
      }
    });
    this.knH.setEnabled(false);
    if (WeChatSomeFeatureSwitch.onlyUSMobile())
    {
      this.countryCode = "1";
      this.jbZ = com.tencent.mm.aw.b.bt(this.countryCode, getString(2131758198));
    }
    if (Util.isNullOrNil(this.countryCode))
    {
      this.jbZ = getString(2131758200);
      this.countryCode = PhoneFormater.pureCountryCode(getString(2131758199));
      if (!Util.isNullOrNil(this.kqe)) {
        this.kpU.setText(this.kqe);
      }
      if ((Util.isNullOrNil(this.jbZ)) || (Util.isNullOrNil(this.countryCode)))
      {
        this.klq = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        Log.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + this.klq);
        if (!Util.isNullOrNil(this.klq)) {
          break label799;
        }
        Log.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
      }
      label569:
      bps();
      if ((this.kbb != null) && (!this.kbb.equals(""))) {
        this.kpT.setText(this.kbb);
      }
      this.kaX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169146);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", RegByMobileRegAIOUI.o(RegByMobileRegAIOUI.this));
          paramAnonymousView.putExtra("couttry_code", RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this));
          com.tencent.mm.plugin.account.a.a.jRt.b(paramAnonymousView, RegByMobileRegAIOUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169146);
        }
      });
      setBackBtn(new RegByMobileRegAIOUI.4(this), 2131689490);
      this.gvv.setOnClickListener(new RegByMobileRegAIOUI.5(this));
      if (!Util.isNullOrNil(this.kqf)) {
        break label849;
      }
      g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
      {
        String nickname;
        
        public final boolean doInBackground()
        {
          AppMethodBeat.i(169150);
          AppMethodBeat.o(169150);
          return true;
        }
        
        public final boolean onPostExecute()
        {
          AppMethodBeat.i(169149);
          if ((!Util.isNullOrNil(this.nickname)) && (Util.isNullOrNil(RegByMobileRegAIOUI.n(RegByMobileRegAIOUI.this).getText().trim()))) {
            RegByMobileRegAIOUI.n(RegByMobileRegAIOUI.this).setText(this.nickname);
          }
          if (!e.apn())
          {
            Log.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
            AppMethodBeat.o(169149);
            return false;
          }
          if ((RegByMobileRegAIOUI.q(RegByMobileRegAIOUI.this) != null) && (!RegByMobileRegAIOUI.q(RegByMobileRegAIOUI.this).isRecycled()) && (!RegByMobileRegAIOUI.r(RegByMobileRegAIOUI.this)))
          {
            RegByMobileRegAIOUI.s(RegByMobileRegAIOUI.this).setImageBitmap(RegByMobileRegAIOUI.q(RegByMobileRegAIOUI.this));
            RegByMobileRegAIOUI.t(RegByMobileRegAIOUI.this).setVisibility(8);
            RegByMobileRegAIOUI.u(RegByMobileRegAIOUI.this);
          }
          AppMethodBeat.o(169149);
          return true;
        }
        
        public final String toString()
        {
          AppMethodBeat.i(169151);
          String str = super.toString() + "|initView2";
          AppMethodBeat.o(169151);
          return str;
        }
      });
    }
    for (;;)
    {
      localObject = "";
      if ((com.tencent.mm.protocal.d.KyR) || (BuildInfo.IS_FLAVOR_BLUE)) {
        localObject = getString(2131755908) + com.tencent.mm.cc.h.jr(this);
      }
      setMMTitle((String)localObject);
      setActionbarColor(getResources().getColor(2131101424));
      hideActionbarLine();
      if (com.tencent.mm.compatible.util.d.oD(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131101424));
        updataStatusBarIcon(ao.isDarkMode());
      }
      AppMethodBeat.o(128542);
      return;
      this.jbZ = com.tencent.mm.aw.b.bt(this.countryCode, getString(2131758198));
      break;
      label799:
      localObject = com.tencent.mm.aw.b.bs(this.klq, getString(2131758198));
      if (localObject == null)
      {
        Log.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
        break label569;
      }
      this.jbZ = ((b.a)localObject).jbZ;
      this.countryCode = ((b.a)localObject).jbY;
      break label569;
      label849:
      this.kqb.setText(this.kpG);
      g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
      {
        /* Error */
        public final boolean doInBackground()
        {
          // Byte code:
          //   0: ldc 25
          //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: new 33	java/net/URL
          //   8: dup
          //   9: aload_0
          //   10: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:kqp	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   13: invokestatic 37	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:v	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Ljava/lang/String;
          //   16: invokespecial 40	java/net/URL:<init>	(Ljava/lang/String;)V
          //   19: invokevirtual 44	java/net/URL:openConnection	()Ljava/net/URLConnection;
          //   22: checkcast 46	java/net/HttpURLConnection
          //   25: astore_1
          //   26: aload_1
          //   27: invokevirtual 50	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
          //   30: astore 4
          //   32: aload_0
          //   33: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:kqp	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   36: aload 4
          //   38: invokestatic 56	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
          //   41: invokestatic 60	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:a	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
          //   44: pop
          //   45: aload_0
          //   46: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:kqp	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   49: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:q	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
          //   52: ifnull +54 -> 106
          //   55: aload_0
          //   56: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:kqp	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   59: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:q	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
          //   62: invokevirtual 69	android/graphics/Bitmap:isRecycled	()Z
          //   65: ifne +41 -> 106
          //   68: aload_0
          //   69: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:kqp	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   72: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:q	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
          //   75: bipush 100
          //   77: getstatic 75	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
          //   80: new 77	java/lang/StringBuilder
          //   83: dup
          //   84: invokespecial 78	java/lang/StringBuilder:<init>	()V
          //   87: invokestatic 84	com/tencent/mm/loader/j/b:aKR	()Ljava/lang/String;
          //   90: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   93: ldc 90
          //   95: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   98: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   101: iconst_0
          //   102: invokestatic 97	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
          //   105: pop
          //   106: aload 4
          //   108: ifnull +8 -> 116
          //   111: aload 4
          //   113: invokevirtual 102	java/io/InputStream:close	()V
          //   116: aload_1
          //   117: ifnull +7 -> 124
          //   120: aload_1
          //   121: invokevirtual 105	java/net/HttpURLConnection:disconnect	()V
          //   124: ldc 25
          //   126: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   129: iconst_1
          //   130: ireturn
          //   131: astore_3
          //   132: aconst_null
          //   133: astore 4
          //   135: aconst_null
          //   136: astore_1
          //   137: aload 4
          //   139: ifnull +10 -> 149
          //   142: aload_1
          //   143: astore_2
          //   144: aload 4
          //   146: invokevirtual 102	java/io/InputStream:close	()V
          //   149: aload_1
          //   150: astore_2
          //   151: ldc 25
          //   153: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   156: aload_1
          //   157: astore_2
          //   158: aload_3
          //   159: athrow
          //   160: astore_3
          //   161: aload_1
          //   162: astore_2
          //   163: ldc 110
          //   165: aload_3
          //   166: ldc 112
          //   168: iconst_0
          //   169: anewarray 4	java/lang/Object
          //   172: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   175: aload_1
          //   176: ifnull -52 -> 124
          //   179: aload_1
          //   180: invokevirtual 105	java/net/HttpURLConnection:disconnect	()V
          //   183: goto -59 -> 124
          //   186: astore_3
          //   187: aload_1
          //   188: astore_2
          //   189: aload_3
          //   190: astore_1
          //   191: aload_2
          //   192: ifnull +7 -> 199
          //   195: aload_2
          //   196: invokevirtual 105	java/net/HttpURLConnection:disconnect	()V
          //   199: ldc 25
          //   201: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   204: aload_1
          //   205: athrow
          //   206: astore_1
          //   207: goto -16 -> 191
          //   210: astore_3
          //   211: goto -50 -> 161
          //   214: astore_3
          //   215: aconst_null
          //   216: astore 4
          //   218: goto -81 -> 137
          //   221: astore_3
          //   222: goto -85 -> 137
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	225	0	this	7
          //   25	180	1	localObject1	Object
          //   206	1	1	localObject2	Object
          //   143	53	2	localObject3	Object
          //   131	28	3	localObject4	Object
          //   160	6	3	localException1	java.lang.Exception
          //   186	4	3	localObject5	Object
          //   210	1	3	localException2	java.lang.Exception
          //   214	1	3	localObject6	Object
          //   221	1	3	localObject7	Object
          //   30	187	4	localInputStream	java.io.InputStream
          // Exception table:
          //   from	to	target	type
          //   5	26	131	finally
          //   144	149	160	java/lang/Exception
          //   151	156	160	java/lang/Exception
          //   158	160	160	java/lang/Exception
          //   111	116	186	finally
          //   144	149	206	finally
          //   151	156	206	finally
          //   158	160	206	finally
          //   163	175	206	finally
          //   111	116	210	java/lang/Exception
          //   26	32	214	finally
          //   32	106	221	finally
        }
        
        public final boolean onPostExecute()
        {
          AppMethodBeat.i(128517);
          if ((!RegByMobileRegAIOUI.r(RegByMobileRegAIOUI.this)) && (RegByMobileRegAIOUI.q(RegByMobileRegAIOUI.this) != null) && (!RegByMobileRegAIOUI.q(RegByMobileRegAIOUI.this).isRecycled()))
          {
            RegByMobileRegAIOUI.s(RegByMobileRegAIOUI.this).setImageBitmap(RegByMobileRegAIOUI.q(RegByMobileRegAIOUI.this));
            RegByMobileRegAIOUI.t(RegByMobileRegAIOUI.this).setVisibility(8);
            RegByMobileRegAIOUI.u(RegByMobileRegAIOUI.this);
          }
          AppMethodBeat.o(128517);
          return true;
        }
      });
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(128548);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 30846)
    {
      if ((paramInt2 == -1) && (bpq()))
      {
        bpD();
        com.tencent.mm.plugin.b.a.bwV("RE200_250");
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
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(712L, 2L, 1L, false);
        this.kqi = false;
        if (!Util.isNullOrNil(this.kqf))
        {
          bpC();
          AppMethodBeat.o(128548);
          return;
        }
        Tv(this.kpW + this.knP);
        AppMethodBeat.o(128548);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(712L, 1L, 1L, false);
      AppMethodBeat.o(128548);
      return;
    }
    switch (paramInt2)
    {
    default: 
      this.kqc = com.tencent.mm.plugin.account.a.a.jRu.b(this, paramInt1, paramInt2, paramIntent);
      if (this.kqc != null)
      {
        this.gvv.setImageBitmap(this.kqc);
        this.kpI = true;
        this.kqa.setVisibility(8);
      }
      AppMethodBeat.o(128548);
      return;
    }
    this.jbZ = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
    this.countryCode = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
    this.klq = Util.nullAs(paramIntent.getStringExtra("iso_code"), "");
    if (com.tencent.mm.aw.b.Pj(this.countryCode))
    {
      if ((!Util.isNullOrNil(this.kqf)) && (!Util.isNullOrNil(this.kpG)) && (!Util.isNullOrNil(this.kqh)))
      {
        bps();
        AppMethodBeat.o(128548);
        return;
      }
      paramIntent = new Intent(this, MobileInputUI.class);
      paramIntent.putExtra("mobile_input_purpose", 2);
      paramIntent.putExtra("couttry_code", this.countryCode);
      paramIntent.putExtra("country_name", this.jbZ);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      overridePendingTransition(2130771986, 2130771986);
      AppMethodBeat.o(128548);
      return;
    }
    bps();
    AppMethodBeat.o(128548);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128539);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    this.jbZ = Util.nullAs(getIntent().getStringExtra("country_name"), "");
    this.countryCode = PhoneFormater.pureCountryCode(Util.nullAs(getIntent().getStringExtra("couttry_code"), ""));
    this.klq = Util.nullAsNil(getIntent().getStringExtra("iso_code"));
    this.kbb = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.kqe = getIntent().getStringExtra("register_title");
    this.kpG = getIntent().getStringExtra("register_nick_name");
    this.kqh = getIntent().getStringExtra("register_avatar");
    this.kqf = getIntent().getStringExtra("third_app_token");
    this.kop = getIntent().getIntExtra("reg_3d_app_type", 0);
    initView();
    AppMethodBeat.o(128539);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128551);
    com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_reg");
    if (this.kqj != null) {
      this.kqj.dismiss();
    }
    this.kkY.bfK();
    super.onDestroy();
    AppMethodBeat.o(128551);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128543);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      bnm();
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
    if (this.kdn != null) {
      this.kdn.dismiss();
    }
    EventCenter.instance.removeListener(this.kkK);
    g.azz().b(701, this);
    g.azz().b(252, this);
    g.azz().b(145, this);
    g.azz().b(132, this);
    g.azz().b(755, this);
    g.azz().b(252, this);
    g.azz().b(701, this);
    com.tencent.mm.plugin.b.a.bwU("RE200_100");
    AppMethodBeat.o(128541);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169153);
    if (paramInt == 34)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        com.tencent.mm.plugin.account.a.a.jRu.s(this);
        AppMethodBeat.o(169153);
      }
    }
    else {
      this.kmF.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(169153);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128540);
    EventCenter.instance.addListener(this.kkK);
    super.onResume();
    g.azz().a(701, this);
    g.azz().a(252, this);
    g.azz().a(145, this);
    g.azz().a(132, this);
    g.azz().a(755, this);
    g.azz().a(252, this);
    g.azz().a(701, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE200_100,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("RE200_100") + ",1");
    this.kno = 0;
    AppMethodBeat.o(128540);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128549);
    Log.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.kdn != null)
    {
      this.kdn.dismiss();
      this.kdn = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.n(this, 2131755301, 2131764341);
      AppMethodBeat.o(128549);
      return;
    }
    if (paramq.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramq).Vj();
      if (i == 12)
      {
        if ((paramInt2 == -41) || (paramInt2 == -59))
        {
          paramString = com.tencent.mm.h.a.Dk(paramString);
          if (paramString != null)
          {
            paramString.a(this, null, null);
            AppMethodBeat.o(128549);
            return;
          }
          com.tencent.mm.ui.base.h.n(this, 2131764394, 2131764395);
          AppMethodBeat.o(128549);
          return;
        }
        this.knP = PhoneFormater.pureNumber(this.knP);
        this.knn = (this.kpW + this.knP);
        this.knu = ((com.tencent.mm.modelfriend.a)paramq).bbU();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramq = ((com.tencent.mm.modelfriend.a)paramq).bbI();
          if (!Util.isNullOrNil(paramq)) {
            this.knP = paramq.trim();
          }
          com.tencent.mm.plugin.b.a.bwU("RE200_100");
          paramq = new StringBuilder();
          g.aAf();
          paramq = paramq.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",RE200_200,");
          g.aAf();
          com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("RE200_200") + ",1");
          paramString = com.tencent.mm.h.a.Dk(paramString);
          if (paramString != null)
          {
            paramString.a(this, new RegByMobileRegAIOUI.11(this), new RegByMobileRegAIOUI.13(this));
            AppMethodBeat.o(128549);
            return;
          }
          bpD();
          com.tencent.mm.plugin.b.a.bwV("RE200_250");
          AppMethodBeat.o(128549);
          return;
        }
        if (paramInt2 == -355)
        {
          y.g(this, paramString, 30846);
          this.kkY.eTd = this.kop;
          this.kkY.ejA = 5L;
          this.kkY.bfK();
          AppMethodBeat.o(128549);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.c(this, getString(2131756598), "", true);
          AppMethodBeat.o(128549);
          return;
        }
        if (com.tencent.mm.plugin.account.a.a.jRu.a(this, paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(128549);
          return;
        }
        Toast.makeText(this, getString(2131756643, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      Object localObject2;
      if (i == 14)
      {
        if (paramInt2 != 0) {
          break label1169;
        }
        i = ((com.tencent.mm.modelfriend.a)paramq).bbJ();
        if (i != 2) {
          break label837;
        }
        localObject1 = ((com.tencent.mm.modelfriend.a)paramq).bbM();
        if (localObject1 != null)
        {
          Log.i("MicroMsg.RegByMobileRegAIOUI", "network check url %s", new Object[] { ((cta)localObject1).url });
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Key_Seq", ((cta)localObject1).seq);
          ((Intent)localObject2).putExtra("Key_Url", ((cta)localObject1).url);
          ((Intent)localObject2).putExtra("Key_CountryCode", this.kpW);
          ((Intent)localObject2).putExtra("Key_Mobile", this.knP);
          ((Intent)localObject2).putExtra("Key_reg_sessionId", this.knu);
          ((Intent)localObject2).putExtra("kintent_nickname", this.kqb.getText().toString());
          ((Intent)localObject2).putExtra("kintent_password", this.kpZ.getText().toString());
          ((Intent)localObject2).putExtra("kintent_hasavatar", this.kpI);
          ((Intent)localObject2).setClass(this, RegByMobileAutoVerifyUI.class);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      while (com.tencent.mm.plugin.account.a.a.jRu.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128549);
        return;
        label837:
        if (i == 1)
        {
          localObject1 = this.kpW + this.knP;
          localObject2 = ((com.tencent.mm.modelfriend.a)paramq).bbL();
          String str = ((com.tencent.mm.modelfriend.a)paramq).bbK();
          Intent localIntent = new Intent(this, RegByMobileSendSmsUI.class);
          localIntent.putExtra("regsession_id", this.knu);
          localIntent.putExtra("key_reg_style", 1);
          localIntent.putExtra("from_mobile", (String)localObject1);
          localIntent.putExtra("to_mobile", (String)localObject2);
          localIntent.putExtra("verify_code", str);
          localIntent.putExtra("kintent_nickname", this.kqb.getText().toString());
          localIntent.putExtra("kintent_password", this.kpZ.getText().toString());
          localIntent.putExtra("kintent_hasavatar", this.kpI);
          localIntent.putExtra("reg_3d_app_type", this.kop);
          localIntent.putExtra("reg_3d_app_ticket", this.kqg);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          this.kql = ((com.tencent.mm.modelfriend.a)paramq).bbO();
          this.kqm = ((com.tencent.mm.modelfriend.a)paramq).bbP();
          this.kqn = ((com.tencent.mm.modelfriend.a)paramq).bbQ();
          this.kqo = ((com.tencent.mm.modelfriend.a)paramq).bbR();
          bpF();
        }
      }
      label1169:
      if (paramInt2 == -41)
      {
        com.tencent.mm.ui.base.h.n(this, 2131764394, 2131764395);
        AppMethodBeat.o(128549);
        return;
      }
      if (paramInt2 == -34)
      {
        com.tencent.mm.ui.base.h.c(this, getString(2131756598), "", true);
        AppMethodBeat.o(128549);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.jRu.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128549);
        return;
      }
      Toast.makeText(this, getString(2131756643, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128549);
      return;
    }
    if (paramq.getType() == 755) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = (j)paramq;
        if (((j)localObject1).rr.iLL.iLR == null) {
          break label1610;
        }
      }
    }
    label1610:
    for (Object localObject1 = ((ehh)((j)localObject1).rr.iLL.iLR).MyI;; localObject1 = "")
    {
      this.kqg = ((String)localObject1);
      Tv(this.kpW + this.knP);
      break;
      if (paramInt2 != -7) {
        break;
      }
      this.kkY.eTd = this.kop;
      this.kkY.ejA = 7L;
      this.kkY.bfK();
      com.tencent.mm.ui.base.h.a(this, getString(2131759121), getString(2131755998), getString(2131761454), getString(2131755761), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(196925);
          RegByMobileRegAIOUI.y(RegByMobileRegAIOUI.this);
          RegByMobileRegAIOUI.A(RegByMobileRegAIOUI.this).eTd = RegByMobileRegAIOUI.z(RegByMobileRegAIOUI.this);
          RegByMobileRegAIOUI.A(RegByMobileRegAIOUI.this).ejA = 8L;
          RegByMobileRegAIOUI.A(RegByMobileRegAIOUI.this).bfK();
          AppMethodBeat.o(196925);
        }
      }, null);
      break;
      if (((paramq.getType() != 701) && (paramq.getType() != 252)) || (paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
      this.kkY.eTd = this.kop;
      this.kkY.ejA = 12L;
      this.kkY.bfK();
      com.tencent.mm.plugin.account.friend.a.l.boe();
      y.St(z.aTY());
      com.tencent.mm.platformtools.t.dr(this);
      y.showAddrBookUploadConfirm(this, new RegByMobileRegAIOUI.15(this), false, 2);
      AppMethodBeat.o(128549);
      return;
      if ((paramq.getType() == 252) || (paramq.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.Dk(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI
 * JD-Core Version:    0.7.0.1
 */