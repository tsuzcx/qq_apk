package com.tencent.mm.plugin.account.ui;

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
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.au.b.a;
import com.tencent.mm.autogen.mmdata.rpt.pu;
import com.tencent.mm.ce.j;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.k.a;
import com.tencent.mm.protocal.protobuf.dtr;
import com.tencent.mm.protocal.protobuf.fmr;
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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.tools.b.c.a;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(1)
public class RegByMobileRegAIOUI
  extends MMSecDataActivity
  implements com.tencent.mm.am.h
{
  private String countryCode;
  private String hYq;
  private ImageView lBC;
  private String oLl;
  private LinearLayout pOX;
  private TextView pOZ;
  private String pPb;
  private String pQb;
  private w pRu;
  private IListener pZz;
  private String qaB;
  private pu qbY;
  private u qbk;
  private TextView qcG;
  private Button qcH;
  private boolean qcO;
  private String qcQ;
  private String qcm;
  private String qcn;
  private int qco;
  private String qcu;
  private int qdp;
  private String qeO;
  private boolean qeQ;
  private EditText qfb;
  private TextView qfc;
  private MMFormInputView qfd;
  private String qfe;
  private View qff;
  private CheckBox qfg;
  private MMFormInputView qfh;
  private ImageView qfi;
  private MMFormInputView qfj;
  private Bitmap qfk;
  private String qfl;
  private String qfm;
  private String qfn;
  private String qfo;
  private boolean qfp;
  private com.tencent.mm.ui.widget.a.e qfq;
  private boolean qfr;
  private int qfs;
  private int qft;
  private boolean qfu;
  private boolean qfv;
  
  public RegByMobileRegAIOUI()
  {
    AppMethodBeat.i(128538);
    this.pPb = null;
    this.oLl = null;
    this.countryCode = null;
    this.qaB = null;
    this.qcO = true;
    this.qfe = null;
    this.qcQ = null;
    this.qeQ = false;
    this.qco = 0;
    this.qfp = true;
    this.qbY = new pu();
    this.pZz = new RegByMobileRegAIOUI.1(this, f.hfK);
    this.hYq = "";
    this.qbk = new u();
    this.qfq = null;
    this.qfr = false;
    AppMethodBeat.o(128538);
  }
  
  private void Tv(final String paramString)
  {
    AppMethodBeat.i(128546);
    if (!com.tencent.mm.plugin.account.sdk.c.a.T(this, this.qfh.getText().toString()))
    {
      AppMethodBeat.o(128546);
      return;
    }
    if (this.pRu != null) {
      this.pRu.dismiss();
    }
    this.qbk.b(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(304924);
        RegByMobileRegAIOUI.f(RegByMobileRegAIOUI.this, paramString);
        AppMethodBeat.o(304924);
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
      if ((i != 0) && (this.qcO))
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
  
  private void bWj()
  {
    AppMethodBeat.i(128544);
    com.tencent.mm.plugin.b.a.TA(this.pQb);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",RE200_100,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("RE200_100") + ",2");
    finish();
    int i = r.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(128544);
  }
  
  private void bYE()
  {
    AppMethodBeat.i(128545);
    if (!Util.isNullOrNil(this.qfm))
    {
      if (this.pRu != null) {
        this.pRu.dismiss();
      }
      getString(r.j.app_tip);
      this.pRu = com.tencent.mm.ui.base.k.a(this, getString(r.j.app_waiting), true, null);
      com.tencent.mm.plugin.account.model.i locali = new com.tencent.mm.plugin.account.model.i(this.qfm);
      com.tencent.mm.kernel.h.aZW().a(locali, 0);
    }
    AppMethodBeat.o(128545);
  }
  
  private void bYF()
  {
    AppMethodBeat.i(128550);
    getString(r.j.app_tip);
    this.pRu = com.tencent.mm.ui.base.k.a(this, getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    int i = bYG();
    Log.i("MicroMsg.RegByMobileRegAIOUI", "select mobile check type %d", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.modelfriend.a locala = new com.tencent.mm.modelfriend.a(this.qfe + this.qcQ, 14, "", 0, "", i);
    locala.NH(this.qcu);
    com.tencent.mm.kernel.h.aZW().a(locala, 0);
    AppMethodBeat.o(128550);
  }
  
  private int bYG()
  {
    AppMethodBeat.i(305242);
    if (!Util.isNullOrNil(this.qfm))
    {
      AppMethodBeat.o(305242);
      return 1;
    }
    Log.i("MicroMsg.RegByMobileRegAIOUI", "isMobile:%s, isMobileOpen:%s, SIM iso:%s", new Object[] { Boolean.valueOf(NetStatusUtil.isMobile(this)), Boolean.valueOf(NetStatusUtil.isMobileNetworkOpen(this)), q.aPc() });
    if ((NetStatusUtil.isMobile(this)) || ((NetStatusUtil.isMobileNetworkOpen(this)) && (!Util.isNullOrNil(q.aPc()))))
    {
      AppMethodBeat.o(305242);
      return 2;
    }
    AppMethodBeat.o(305242);
    return 1;
  }
  
  private void bYH()
  {
    try
    {
      AppMethodBeat.i(128552);
      if (!this.qfr)
      {
        this.qfr = true;
        finish();
        Intent localIntent = new Intent();
        localIntent.putExtra("bindmcontact_mobile", this.qfe + " " + this.qfb.getText().toString());
        localIntent.putExtra("bindmcontact_shortmobile", this.qcQ);
        localIntent.putExtra("country_name", this.oLl);
        localIntent.putExtra("couttry_code", this.countryCode);
        localIntent.putExtra("mobileverify_countdownsec", this.qfs);
        localIntent.putExtra("mobileverify_countdownstyle", this.qft);
        localIntent.putExtra("mobileverify_fb", this.qfu);
        localIntent.putExtra("mobileverify_reg_qq", this.qfv);
        localIntent.putExtra("kintent_nickname", this.qfj.getText().toString());
        localIntent.putExtra("kintent_password", this.qfh.getText().toString());
        localIntent.putExtra("kintent_hasavatar", this.qeQ);
        localIntent.putExtra("key_reg_style", 1);
        localIntent.putExtra("regsession_id", this.qcu);
        localIntent.putExtra("reg_3d_app_ticket", this.qfn);
        localIntent.putExtra("reg_3d_app_type", this.qdp);
        localIntent.putExtra("mobile_verify_purpose", 2);
        startActivity(MobileVerifyUI.class, localIntent);
      }
      AppMethodBeat.o(128552);
      return;
    }
    finally {}
  }
  
  private boolean bYo()
  {
    AppMethodBeat.i(128553);
    if (Util.isNullOrNil(this.countryCode)) {}
    for (int i = 0;; i = 1)
    {
      boolean bool = i & a(new Editable[] { this.qfb.getText(), this.qfh.getText(), this.qfj.getText() });
      if (bool) {
        this.qcH.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(128553);
        return bool;
        this.qcH.setEnabled(false);
      }
    }
  }
  
  private void bYq()
  {
    AppMethodBeat.i(128547);
    if ((!Util.isNullOrNil(this.oLl)) && (!Util.isNullOrNil(this.countryCode)))
    {
      this.pOZ.setText(PhoneFormater.countryNameWithCode(this.oLl, this.countryCode));
      AppMethodBeat.o(128547);
      return;
    }
    this.pOZ.setText(getString(r.j.mobile_code_error));
    AppMethodBeat.o(128547);
  }
  
  public int getLayoutId()
  {
    return r.g.regbymobile_reg_aio;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128542);
    this.pOX = ((LinearLayout)findViewById(r.f.country_code_ll));
    this.pOZ = ((TextView)findViewById(r.f.country_name));
    this.qfc = ((TextView)findViewById(r.f.reg_title));
    this.qfd = ((MMFormInputView)findViewById(r.f.regbymobilereg_mobile_input_view));
    this.qfd.setInputType(3);
    this.qfb = this.qfd.getContentEditText();
    this.qff = findViewById(r.f.term_container);
    this.qfg = ((CheckBox)findViewById(r.f.reg_term_check));
    this.qcG = ((TextView)findViewById(r.f.reg_term));
    this.qcH = ((Button)findViewById(r.f.reg_next));
    this.lBC = ((ImageView)findViewById(r.f.setinfo_avatar));
    this.qfi = ((ImageView)findViewById(r.f.setinfo_camera));
    this.qfh = ((MMFormInputView)findViewById(r.f.regbymobile_setpassword_container));
    com.tencent.mm.ui.tools.b.c.i(this.qfh.getContentEditText()).aEg(16).a(null);
    this.qfj = ((MMFormInputView)findViewById(r.f.reg_nick_input_view));
    this.qfg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(305158);
        RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(305158);
      }
    });
    Object localObject2 = getString(r.j.license_agree);
    Object localObject1 = getString(r.j.license_detail);
    localObject1 = (String)localObject2 + (String)localObject1;
    Object localObject3 = new com.tencent.mm.pluginsdk.ui.span.i(localObject1, ((String)localObject2).length(), ((String)localObject1).length());
    ((com.tencent.mm.pluginsdk.ui.span.i)localObject3).Yob = new com.tencent.mm.pluginsdk.ui.span.h()
    {
      public final void bYI()
      {
        AppMethodBeat.i(305160);
        String str = com.tencent.mm.au.b.bJ(RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this), RegByMobileRegAIOUI.this.getString(r.j.country_code));
        com.tencent.mm.plugin.account.sdk.c.a.b(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.this.getString(r.j.url_agreement, new Object[] { LocaleUtil.getApplicationLanguage(), str }), 0, false);
        AppMethodBeat.o(305160);
      }
    };
    localObject2 = new LinkedList();
    ((LinkedList)localObject2).add(localObject3);
    localObject3 = com.tencent.mm.pluginsdk.ui.span.k.Yod;
    k.a.a(this.qcG, (String)localObject1, (List)localObject2);
    localObject1 = new boolean[1];
    localObject1[0] = 1;
    this.qfb.addTextChangedListener(new TextWatcher()
    {
      private PhoneFormater qfC;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(305127);
        RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(305127);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(305131);
        if (this.qfD[0] != 0)
        {
          this.qfD[0] = false;
          com.tencent.mm.plugin.normsg.a.d.MtP.aQh("ie_reg");
        }
        com.tencent.mm.plugin.normsg.a.d.MtP.aQi("ie_reg");
        AppMethodBeat.o(305131);
      }
    });
    this.qfb.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(305123);
        if (paramAnonymousBoolean) {
          this.qfD[0] = true;
        }
        for (;;)
        {
          paramAnonymousView = com.tencent.mm.ui.component.k.aeZF;
          ((com.tencent.mm.plugin.mvvmbase.b.a)com.tencent.mm.ui.component.k.d(RegByMobileRegAIOUI.this).q(com.tencent.mm.plugin.mvvmbase.b.a.class)).Aa(paramAnonymousBoolean);
          AppMethodBeat.o(305123);
          return;
          com.tencent.mm.plugin.normsg.a.d.MtP.aQj("ie_reg");
        }
      }
    });
    this.qfh.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(305121);
        RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(305121);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.qfh.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(305134);
        paramAnonymousView = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.mvvmbase.b.a)com.tencent.mm.ui.component.k.d(RegByMobileRegAIOUI.this).q(com.tencent.mm.plugin.mvvmbase.b.a.class)).Aa(paramAnonymousBoolean);
        AppMethodBeat.o(305134);
      }
    });
    this.qfj.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(128536);
        RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(128536);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.qfj.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(305100);
        paramAnonymousView = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.mvvmbase.b.a)com.tencent.mm.ui.component.k.d(RegByMobileRegAIOUI.this).q(com.tencent.mm.plugin.mvvmbase.b.a.class)).Aa(paramAnonymousBoolean);
        AppMethodBeat.o(305100);
      }
    });
    localObject1 = new boolean[1];
    localObject1[0] = 0;
    this.qcH.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(304912);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(304912);
          return false;
          this.qbm[0] = true;
          RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this, com.tencent.mm.plugin.normsg.a.c.aeT(1));
          com.tencent.mm.plugin.normsg.a.d.MtP.aJ("ce_reg", "<Reg>", RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this));
          continue;
          com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_reg", paramAnonymousMotionEvent);
          com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_reg");
        }
      }
    });
    this.qcH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(169146);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (this.qbm[0] != 0) {
          this.qbm[0] = false;
        }
        while (!RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this).isChecked())
        {
          paramAnonymousView = AnimationUtils.loadAnimation(RegByMobileRegAIOUI.this, r.a.anim_shake_horizontal);
          RegByMobileRegAIOUI.e(RegByMobileRegAIOUI.this).startAnimation(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(169146);
          return;
          RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this, com.tencent.mm.plugin.normsg.a.c.aeT(1));
          com.tencent.mm.plugin.normsg.a.d.MtP.aJ("ce_reg", "<Reg>", RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this));
          paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
          com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_reg", paramAnonymousView);
          com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_reg");
        }
        com.tencent.mm.ui.tools.b.c.i(RegByMobileRegAIOUI.m(RegByMobileRegAIOUI.this).getContentEditText()).oF(1, 32).Nc(true).a(new c.a()
        {
          public final void Tw(String paramAnonymous2String)
          {
            AppMethodBeat.i(305166);
            RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this, PhoneFormater.pureNumber(RegByMobileRegAIOUI.f(RegByMobileRegAIOUI.this).getText().toString()));
            RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this, PhoneFormater.countryCodeWithPlus(RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this)));
            paramAnonymous2String = RegByMobileRegAIOUI.g(RegByMobileRegAIOUI.this) + RegByMobileRegAIOUI.h(RegByMobileRegAIOUI.this);
            RegByMobileRegAIOUI.this.hideVKB();
            if (RegByMobileRegAIOUI.i(RegByMobileRegAIOUI.this))
            {
              if (Util.isNullOrNil(RegByMobileRegAIOUI.j(RegByMobileRegAIOUI.this))) {
                RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this, com.tencent.mm.au.b.bJ(RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this), RegByMobileRegAIOUI.this.getString(r.j.country_code)));
              }
              paramAnonymous2String = RegByMobileRegAIOUI.this.getString(r.j.license_read_url, new Object[] { LocaleUtil.getApplicationLanguage(), RegByMobileRegAIOUI.j(RegByMobileRegAIOUI.this), "reg", Integer.valueOf(1), Integer.valueOf(0) });
              com.tencent.mm.plugin.account.sdk.c.a.b(RegByMobileRegAIOUI.this, paramAnonymous2String, 30847, false);
              AppMethodBeat.o(305166);
              return;
            }
            if (!Util.isNullOrNil(RegByMobileRegAIOUI.k(RegByMobileRegAIOUI.this)))
            {
              RegByMobileRegAIOUI.l(RegByMobileRegAIOUI.this);
              AppMethodBeat.o(305166);
              return;
            }
            RegByMobileRegAIOUI.e(RegByMobileRegAIOUI.this, paramAnonymous2String);
            AppMethodBeat.o(305166);
          }
          
          public final void Tx(String paramAnonymous2String)
          {
            AppMethodBeat.i(305168);
            com.tencent.mm.ui.base.k.s(RegByMobileRegAIOUI.this, r.j.settings_modify_name_invalid_less, r.j.settings_modify_name_title);
            AppMethodBeat.o(305168);
          }
          
          public final void eY(String paramAnonymous2String)
          {
            AppMethodBeat.i(305171);
            com.tencent.mm.ui.base.k.s(RegByMobileRegAIOUI.this, r.j.settings_modify_name_invalid_more, r.j.settings_modify_name_title);
            AppMethodBeat.o(305171);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(169146);
      }
    });
    this.qcH.setEnabled(false);
    if (WeChatSomeFeatureSwitch.onlyUSMobile())
    {
      this.countryCode = "1";
      this.oLl = com.tencent.mm.au.b.bI(this.countryCode, getString(r.j.country_code));
    }
    if (Util.isNullOrNil(this.countryCode))
    {
      this.oLl = getString(r.j.country_normal_name);
      this.countryCode = PhoneFormater.pureCountryCode(getString(r.j.country_normal_code));
      if (!Util.isNullOrNil(this.qfl)) {
        this.qfc.setText(this.qfl);
      }
      if ((Util.isNullOrNil(this.oLl)) || (Util.isNullOrNil(this.countryCode)))
      {
        this.qaB = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        Log.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + this.qaB);
        if (!Util.isNullOrNil(this.qaB)) {
          break label862;
        }
        Log.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
      }
      label632:
      bYq();
      if ((this.pPb != null) && (!this.pPb.equals(""))) {
        this.qfb.setText(this.pPb);
      }
      this.pOX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128514);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", RegByMobileRegAIOUI.n(RegByMobileRegAIOUI.this));
          paramAnonymousView.putExtra("couttry_code", RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this));
          com.tencent.mm.plugin.account.sdk.a.pFn.b(paramAnonymousView, RegByMobileRegAIOUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128514);
        }
      });
      setBackBtn(new RegByMobileRegAIOUI.5(this), r.i.actionbar_icon_close_black);
      this.lBC.setOnClickListener(new RegByMobileRegAIOUI.6(this));
      if (!Util.isNullOrNil(this.qfm)) {
        break label912;
      }
      com.tencent.mm.kernel.h.baH().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
      {
        String nickname;
        
        public final boolean doInBackground()
        {
          AppMethodBeat.i(128518);
          AppMethodBeat.o(128518);
          return true;
        }
        
        public final boolean onPostExecute()
        {
          AppMethodBeat.i(128517);
          if ((!Util.isNullOrNil(this.nickname)) && (Util.isNullOrNil(RegByMobileRegAIOUI.m(RegByMobileRegAIOUI.this).getText().trim()))) {
            RegByMobileRegAIOUI.m(RegByMobileRegAIOUI.this).setText(this.nickname);
          }
          if (!com.tencent.mm.compatible.util.e.aPU())
          {
            Log.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
            AppMethodBeat.o(128517);
            return false;
          }
          if ((RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this) != null) && (!RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this).isRecycled()) && (!RegByMobileRegAIOUI.q(RegByMobileRegAIOUI.this)))
          {
            RegByMobileRegAIOUI.r(RegByMobileRegAIOUI.this).setImageBitmap(RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this));
            RegByMobileRegAIOUI.s(RegByMobileRegAIOUI.this).setVisibility(8);
            RegByMobileRegAIOUI.t(RegByMobileRegAIOUI.this);
          }
          AppMethodBeat.o(128517);
          return true;
        }
        
        public final String toString()
        {
          AppMethodBeat.i(128519);
          String str = super.toString() + "|initView2";
          AppMethodBeat.o(128519);
          return str;
        }
      });
    }
    for (;;)
    {
      localObject1 = "";
      if ((com.tencent.mm.protocal.d.Yxk) || (BuildInfo.IS_FLAVOR_BLUE)) {
        localObject1 = getString(r.j.app_name) + j.mx(this);
      }
      setMMTitle((String)localObject1);
      setActionbarColor(getResources().getColor(r.c.white));
      hideActionbarLine();
      if (com.tencent.mm.compatible.util.d.rb(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(r.c.white));
        updataStatusBarIcon(aw.isDarkMode());
      }
      AppMethodBeat.o(128542);
      return;
      this.oLl = com.tencent.mm.au.b.bI(this.countryCode, getString(r.j.country_code));
      break;
      label862:
      localObject1 = com.tencent.mm.au.b.bH(this.qaB, getString(r.j.country_code));
      if (localObject1 == null)
      {
        Log.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
        break label632;
      }
      this.oLl = ((b.a)localObject1).oLl;
      this.countryCode = ((b.a)localObject1).oLk;
      break label632;
      label912:
      this.qfj.setText(this.qeO);
      com.tencent.mm.kernel.h.baH().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread()
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
          //   10: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$8:qfw	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   13: invokestatic 37	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:u	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Ljava/lang/String;
          //   16: invokespecial 40	java/net/URL:<init>	(Ljava/lang/String;)V
          //   19: invokevirtual 44	java/net/URL:openConnection	()Ljava/net/URLConnection;
          //   22: checkcast 46	java/net/HttpURLConnection
          //   25: astore_1
          //   26: aload_1
          //   27: invokevirtual 50	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
          //   30: astore 4
          //   32: aload_0
          //   33: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$8:qfw	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   36: aload 4
          //   38: invokestatic 56	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
          //   41: invokestatic 60	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:a	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
          //   44: pop
          //   45: aload_0
          //   46: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$8:qfw	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   49: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:p	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
          //   52: ifnull +54 -> 106
          //   55: aload_0
          //   56: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$8:qfw	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   59: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:p	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
          //   62: invokevirtual 69	android/graphics/Bitmap:isRecycled	()Z
          //   65: ifne +41 -> 106
          //   68: aload_0
          //   69: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$8:qfw	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   72: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:p	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
          //   75: bipush 100
          //   77: getstatic 75	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
          //   80: new 77	java/lang/StringBuilder
          //   83: dup
          //   84: invokespecial 78	java/lang/StringBuilder:<init>	()V
          //   87: invokestatic 84	com/tencent/mm/loader/i/b:bmH	()Ljava/lang/String;
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
          //   0	225	0	this	8
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
          AppMethodBeat.i(128521);
          if ((!RegByMobileRegAIOUI.q(RegByMobileRegAIOUI.this)) && (RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this) != null) && (!RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this).isRecycled()))
          {
            RegByMobileRegAIOUI.r(RegByMobileRegAIOUI.this).setImageBitmap(RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this));
            RegByMobileRegAIOUI.s(RegByMobileRegAIOUI.this).setVisibility(8);
            RegByMobileRegAIOUI.t(RegByMobileRegAIOUI.this);
          }
          AppMethodBeat.o(128521);
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
      if ((paramInt2 == -1) && (bYo()))
      {
        bYF();
        com.tencent.mm.plugin.b.a.TA("RE200_250");
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
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(712L, 2L, 1L, false);
        this.qfp = false;
        if (!Util.isNullOrNil(this.qfm))
        {
          bYE();
          AppMethodBeat.o(128548);
          return;
        }
        Tv(this.qfe + this.qcQ);
        AppMethodBeat.o(128548);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(712L, 1L, 1L, false);
      AppMethodBeat.o(128548);
      return;
    }
    switch (paramInt2)
    {
    default: 
      this.qfk = com.tencent.mm.plugin.account.sdk.a.pFo.b(this, paramInt1, paramInt2, paramIntent);
      if (this.qfk != null)
      {
        this.lBC.setImageBitmap(this.qfk);
        this.qeQ = true;
        this.qfi.setVisibility(8);
      }
      AppMethodBeat.o(128548);
      return;
    }
    this.oLl = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
    this.countryCode = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
    this.qaB = Util.nullAs(paramIntent.getStringExtra("iso_code"), "");
    if (com.tencent.mm.au.b.OF(this.countryCode))
    {
      if ((!Util.isNullOrNil(this.qfm)) && (!Util.isNullOrNil(this.qeO)) && (!Util.isNullOrNil(this.qfo)))
      {
        bYq();
        AppMethodBeat.o(128548);
        return;
      }
      paramIntent = new Intent(this, MobileInputUI.class);
      paramIntent.putExtra("mobile_input_purpose", 2);
      paramIntent.putExtra("couttry_code", this.countryCode);
      paramIntent.putExtra("country_name", this.oLl);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      paramInt1 = r.a.anim_not_change;
      overridePendingTransition(paramInt1, paramInt1);
      AppMethodBeat.o(128548);
      return;
    }
    bYq();
    AppMethodBeat.o(128548);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128539);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    this.oLl = Util.nullAs(getIntent().getStringExtra("country_name"), "");
    this.countryCode = PhoneFormater.pureCountryCode(Util.nullAs(getIntent().getStringExtra("couttry_code"), ""));
    this.qaB = Util.nullAsNil(getIntent().getStringExtra("iso_code"));
    this.pPb = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.qfl = getIntent().getStringExtra("register_title");
    this.qeO = getIntent().getStringExtra("register_nick_name");
    this.qfo = getIntent().getStringExtra("register_avatar");
    this.qfm = getIntent().getStringExtra("third_app_token");
    this.qdp = getIntent().getIntExtra("reg_3d_app_type", 0);
    initView();
    AppMethodBeat.o(128539);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128551);
    com.tencent.mm.plugin.normsg.a.d.MtP.aQj("ie_reg");
    if (this.qfq != null) {
      this.qfq.dismiss();
    }
    this.qbY.bMH();
    super.onDestroy();
    AppMethodBeat.o(128551);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128543);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      bWj();
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
    if (this.pRu != null) {
      this.pRu.dismiss();
    }
    this.pZz.dead();
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    com.tencent.mm.kernel.h.aZW().b(145, this);
    com.tencent.mm.kernel.h.aZW().b(132, this);
    com.tencent.mm.kernel.h.aZW().b(755, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.plugin.b.a.Tz("RE200_100");
    AppMethodBeat.o(128541);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169153);
    if (paramInt == 34)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        com.tencent.mm.plugin.account.sdk.a.pFo.t(this);
        AppMethodBeat.o(169153);
      }
    }
    else {
      this.qbk.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(169153);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128540);
    this.pZz.alive();
    super.onResume();
    com.tencent.mm.kernel.h.aZW().a(701, this);
    com.tencent.mm.kernel.h.aZW().a(252, this);
    com.tencent.mm.kernel.h.aZW().a(145, this);
    com.tencent.mm.kernel.h.aZW().a(132, this);
    com.tencent.mm.kernel.h.aZW().a(755, this);
    com.tencent.mm.kernel.h.aZW().a(252, this);
    com.tencent.mm.kernel.h.aZW().a(701, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",RE200_100,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("RE200_100") + ",1");
    this.qco = 0;
    AppMethodBeat.o(128540);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128549);
    Log.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.pRu != null)
    {
      this.pRu.dismiss();
      this.pRu = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.k.s(this, r.j.alpha_version_tip_reg, r.j.reg_username_exist_title);
      AppMethodBeat.o(128549);
      return;
    }
    if (paramp.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramp).bIO();
      if (i == 12)
      {
        if ((paramInt2 == -41) || (paramInt2 == -59))
        {
          paramString = com.tencent.mm.broadcast.a.CH(paramString);
          if (paramString != null)
          {
            paramString.a(this, null, null);
            AppMethodBeat.o(128549);
            return;
          }
          com.tencent.mm.ui.base.k.s(this, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
          AppMethodBeat.o(128549);
          return;
        }
        this.qcQ = PhoneFormater.pureNumber(this.qcQ);
        this.qcn = (this.qfe + this.qcQ);
        this.qcu = ((com.tencent.mm.modelfriend.a)paramp).bJe();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramp = ((com.tencent.mm.modelfriend.a)paramp).bIS();
          if (!Util.isNullOrNil(paramp)) {
            this.qcQ = paramp.trim();
          }
          com.tencent.mm.plugin.b.a.Tz("RE200_100");
          paramp = new StringBuilder();
          com.tencent.mm.kernel.h.baC();
          paramp = paramp.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",RE200_200,");
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("RE200_200") + ",1");
          paramString = com.tencent.mm.broadcast.a.CH(paramString);
          if (paramString != null)
          {
            paramString.a(this, new RegByMobileRegAIOUI.13(this), new RegByMobileRegAIOUI.14(this));
            AppMethodBeat.o(128549);
            return;
          }
          bYF();
          com.tencent.mm.plugin.b.a.TA("RE200_250");
          AppMethodBeat.o(128549);
          return;
        }
        if (paramInt2 == -355)
        {
          v.f(this, paramString, 30846);
          this.qbY.joN = this.qdp;
          this.qbY.ikE = 5L;
          this.qbY.bMH();
          AppMethodBeat.o(128549);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.k.c(this, getString(r.j.bind_mcontact_err_freq_limit), "", true);
          AppMethodBeat.o(128549);
          return;
        }
        if (com.tencent.mm.plugin.account.sdk.a.pFo.a(this, paramInt1, paramInt2, paramString))
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
        i = ((com.tencent.mm.modelfriend.a)paramp).bIT();
        if (i != 2) {
          break label837;
        }
        localObject1 = ((com.tencent.mm.modelfriend.a)paramp).bIW();
        if (localObject1 != null)
        {
          Log.i("MicroMsg.RegByMobileRegAIOUI", "network check url %s", new Object[] { ((dtr)localObject1).url });
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Key_Seq", ((dtr)localObject1).seq);
          ((Intent)localObject2).putExtra("Key_Url", ((dtr)localObject1).url);
          ((Intent)localObject2).putExtra("Key_CountryCode", this.qfe);
          ((Intent)localObject2).putExtra("Key_Mobile", this.qcQ);
          ((Intent)localObject2).putExtra("Key_reg_sessionId", this.qcu);
          ((Intent)localObject2).putExtra("kintent_nickname", this.qfj.getText().toString());
          ((Intent)localObject2).putExtra("kintent_password", this.qfh.getText().toString());
          ((Intent)localObject2).putExtra("kintent_hasavatar", this.qeQ);
          ((Intent)localObject2).setClass(this, RegByMobileAutoVerifyUI.class);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      while (com.tencent.mm.plugin.account.sdk.a.pFo.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128549);
        return;
        label837:
        if (i == 1)
        {
          localObject1 = this.qfe + this.qcQ;
          localObject2 = ((com.tencent.mm.modelfriend.a)paramp).bIV();
          String str = ((com.tencent.mm.modelfriend.a)paramp).bIU();
          Intent localIntent = new Intent(this, RegByMobileSendSmsUI.class);
          localIntent.putExtra("regsession_id", this.qcu);
          localIntent.putExtra("key_reg_style", 1);
          localIntent.putExtra("from_mobile", (String)localObject1);
          localIntent.putExtra("to_mobile", (String)localObject2);
          localIntent.putExtra("verify_code", str);
          localIntent.putExtra("kintent_nickname", this.qfj.getText().toString());
          localIntent.putExtra("kintent_password", this.qfh.getText().toString());
          localIntent.putExtra("kintent_hasavatar", this.qeQ);
          localIntent.putExtra("reg_3d_app_type", this.qdp);
          localIntent.putExtra("reg_3d_app_ticket", this.qfn);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          this.qfs = ((com.tencent.mm.modelfriend.a)paramp).bIY();
          this.qft = ((com.tencent.mm.modelfriend.a)paramp).bIZ();
          this.qfu = ((com.tencent.mm.modelfriend.a)paramp).bJa();
          this.qfv = ((com.tencent.mm.modelfriend.a)paramp).bJb();
          bYH();
        }
      }
      label1169:
      if (paramInt2 == -41)
      {
        com.tencent.mm.ui.base.k.s(this, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
        AppMethodBeat.o(128549);
        return;
      }
      if (paramInt2 == -34)
      {
        com.tencent.mm.ui.base.k.c(this, getString(r.j.bind_mcontact_err_freq_limit), "", true);
        AppMethodBeat.o(128549);
        return;
      }
      if (com.tencent.mm.plugin.account.sdk.a.pFo.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128549);
        return;
      }
      Toast.makeText(this, getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128549);
      return;
    }
    if (paramp.getType() == 755) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = (com.tencent.mm.plugin.account.model.i)paramp;
        if (c.c.b(((com.tencent.mm.plugin.account.model.i)localObject1).rr.otC) == null) {
          break label1606;
        }
      }
    }
    label1606:
    for (Object localObject1 = ((fmr)c.c.b(((com.tencent.mm.plugin.account.model.i)localObject1).rr.otC)).aaZY;; localObject1 = "")
    {
      this.qfn = ((String)localObject1);
      Tv(this.qfe + this.qcQ);
      break;
      if (paramInt2 != -7) {
        break;
      }
      this.qbY.joN = this.qdp;
      this.qbY.ikE = 7L;
      this.qbY.bMH();
      com.tencent.mm.ui.base.k.a(this, getString(r.j.facebooklogin_user_bind_already), getString(r.j.app_tip), getString(r.j.go_to_login), getString(r.j.app_cancel), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(305159);
          RegByMobileRegAIOUI.x(RegByMobileRegAIOUI.this);
          RegByMobileRegAIOUI.z(RegByMobileRegAIOUI.this).joN = RegByMobileRegAIOUI.y(RegByMobileRegAIOUI.this);
          RegByMobileRegAIOUI.z(RegByMobileRegAIOUI.this).ikE = 8L;
          RegByMobileRegAIOUI.z(RegByMobileRegAIOUI.this).bMH();
          AppMethodBeat.o(305159);
        }
      }, null);
      break;
      if (((paramp.getType() != 701) && (paramp.getType() != 252)) || (paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
      this.qbY.joN = this.qdp;
      this.qbY.ikE = 12L;
      this.qbY.bMH();
      com.tencent.mm.plugin.account.friend.model.i.bXa();
      v.Sj(z.bAM());
      v.showAddrBookUploadConfirm(this, new RegByMobileRegAIOUI.16(this), false, 2);
      AppMethodBeat.o(128549);
      return;
      if ((paramp.getType() == 252) || (paramp.getType() == 701))
      {
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
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
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(305313);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.mvvmbase.b.a.class);
    paramHashSet.add(com.tencent.mm.plugin.account.ui.a.b.class);
    AppMethodBeat.o(305313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI
 * JD-Core Version:    0.7.0.1
 */