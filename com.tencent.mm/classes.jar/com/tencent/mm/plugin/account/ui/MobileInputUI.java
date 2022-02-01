package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b.a;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.pluginsdk.model.ad.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(1)
public class MobileInputUI
  extends MMSecDataActivity
{
  protected String countryCode;
  protected String oLl;
  protected int olm;
  protected LinearLayout pOX;
  protected TextView pOZ;
  protected String pPb;
  protected String pQb;
  protected w pRu;
  protected Button pZd;
  protected Button pZe;
  private View pZf;
  protected Button pZg;
  private Button pZs;
  protected int[] pZy;
  private IListener pZz;
  protected String qaB;
  protected boolean qaE;
  protected EditText qaR;
  protected boolean qbB;
  private u qbk;
  protected MMFormInputView qby;
  protected MMFormInputView qcB;
  protected EditText qcC;
  protected MMFormVerifyCodeInputView qcD;
  protected View qcE;
  protected CheckBox qcF;
  protected TextView qcG;
  protected Button qcH;
  protected TextView qcI;
  protected TextView qcJ;
  protected TextView qcK;
  protected TextView qcL;
  protected Button qcM;
  protected View qcN;
  protected boolean qcO;
  protected String qcP;
  protected String qcQ;
  private int qcR;
  private b qcS;
  protected boolean qcT;
  private String qcU;
  private String qcV;
  
  public MobileInputUI()
  {
    AppMethodBeat.i(128356);
    this.qcO = true;
    this.qcP = null;
    this.qcQ = null;
    this.pPb = null;
    this.oLl = null;
    this.countryCode = null;
    this.qaB = null;
    this.qcR = 0;
    this.pZy = new int[5];
    this.qbB = false;
    this.qcU = "";
    this.qcV = "";
    this.pZz = new MobileInputUI.1(this, com.tencent.mm.app.f.hfK);
    this.qbk = new u();
    AppMethodBeat.o(128356);
  }
  
  private static void U(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128369);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    com.tencent.mm.br.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128369);
  }
  
  private boolean bYm()
  {
    return this.qcR == 2;
  }
  
  private boolean bYn()
  {
    return (this.olm == 7) || (this.olm == 6);
  }
  
  private void bYp()
  {
    AppMethodBeat.i(128364);
    hideVKB();
    this.qbk.b(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128346);
        MobileInputUI.i(MobileInputUI.this);
        AppMethodBeat.o(128346);
      }
    });
    AppMethodBeat.o(128364);
  }
  
  private void bYq()
  {
    AppMethodBeat.i(128367);
    if ((!Util.isNullOrNil(this.oLl)) && (!Util.isNullOrNil(this.countryCode)))
    {
      this.pOZ.setText(PhoneFormater.countryNameWithCode(this.oLl, this.countryCode));
      AppMethodBeat.o(128367);
      return;
    }
    this.pOZ.setText(getString(r.j.mobile_code_error));
    AppMethodBeat.o(128367);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128365);
    if (this.qcT)
    {
      hideVKB();
      Object localObject = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.nf(this);
      AppMethodBeat.o(128365);
      return;
    }
    this.qcS.a(a.qcY);
    com.tencent.mm.plugin.b.a.TA(this.pQb);
    hideVKB();
    finish();
    AppMethodBeat.o(128365);
  }
  
  public final boolean bYo()
  {
    AppMethodBeat.i(128363);
    if ((this.qcC.getText() != null) && (!Util.isNullOrNil(this.qcC.getText().toString())) && (this.qcO)) {
      if (this.qcR == 2)
      {
        if ((this.qaR.getText() != null) && (!Util.isNullOrNil(this.qaR.getText().toString())))
        {
          AppMethodBeat.o(128363);
          return true;
        }
      }
      else
      {
        AppMethodBeat.o(128363);
        return true;
      }
    }
    AppMethodBeat.o(128363);
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(128360);
    super.finish();
    int i = r.a.anim_not_change;
    overridePendingTransition(i, i);
    h.OAn.b(14262, new Object[] { Integer.valueOf(this.pZy[0]), Integer.valueOf(this.pZy[1]), Integer.valueOf(this.pZy[2]), Integer.valueOf(this.pZy[3]), Integer.valueOf(this.pZy[4]) });
    AppMethodBeat.o(128360);
  }
  
  public int getLayoutId()
  {
    return r.g.mobile_input_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128362);
    this.qby = ((MMFormInputView)findViewById(r.f.setpassword_container));
    this.qaR = this.qby.getContentEditText();
    com.tencent.mm.ui.tools.b.c.i(this.qaR).aEg(16).a(null);
    this.qcB = ((MMFormInputView)findViewById(r.f.mobile_number_display));
    this.qcB.setInputType(3);
    this.qcC = this.qcB.getContentEditText();
    this.qcD = ((MMFormVerifyCodeInputView)findViewById(r.f.sms_verify_container));
    this.qcD.setInputType(3);
    this.pOX = ((LinearLayout)findViewById(r.f.country_code_ll));
    this.pOZ = ((TextView)findViewById(r.f.country_name));
    this.qcE = findViewById(r.f.reg_license);
    this.qcF = ((CheckBox)findViewById(r.f.reg_term_check));
    this.qcG = ((TextView)findViewById(r.f.reg_term));
    this.qcH = ((Button)findViewById(r.f.next_btn));
    this.qcI = ((TextView)findViewById(r.f.agree_term_tips_btn));
    this.qcJ = ((TextView)findViewById(r.f.register_title));
    this.qcK = ((TextView)findViewById(r.f.login_title));
    this.qcL = ((TextView)findViewById(r.f.mobile_input_hint));
    this.qcM = ((Button)findViewById(r.f.login_by_other));
    this.pZs = ((Button)findViewById(r.f.login_as_other_device_btn));
    this.pZd = ((Button)findViewById(r.f.login_find_password_btn));
    this.pZe = ((Button)findViewById(r.f.login_freeze_account_btn));
    this.pZf = findViewById(r.f.free_btn_container);
    this.pZg = ((Button)findViewById(r.f.login_more_btn));
    this.qcN = findViewById(r.f.bottom_btn_container);
    this.pOX.setVisibility(8);
    this.qby.setVisibility(8);
    this.qcD.setVisibility(8);
    this.qcB.setVisibility(8);
    this.qcJ.setVisibility(8);
    this.qcK.setVisibility(8);
    this.qcH.setVisibility(8);
    this.qcE.setVisibility(8);
    this.qcM.setVisibility(8);
    this.pZd.setOnClickListener(new MobileInputUI.15(this));
    this.pZe.setOnClickListener(new MobileInputUI.16(this));
    Object localObject = new com.tencent.mm.ui.widget.a.f(this, 1, false);
    ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(305081);
        if (paramAnonymouss.jmw())
        {
          paramAnonymouss.oh(5001, r.j.wechat_safe_center);
          paramAnonymouss.oh(5002, r.j.wechat_help_center);
        }
        AppMethodBeat.o(305081);
      }
    };
    ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new MobileInputUI.18(this);
    ((com.tencent.mm.ui.widget.a.f)localObject).aeLi = new f.b()
    {
      public final void onDismiss() {}
    };
    if (LocaleUtil.isSimplifiedChineseAppLang())
    {
      this.pZg.setOnClickListener(new MobileInputUI.20(this));
      localObject = new boolean[1];
      localObject[0] = 1;
      this.qcC.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(305177);
          if (paramAnonymousBoolean)
          {
            this.qcX[0] = true;
            AppMethodBeat.o(305177);
            return;
          }
          if (MobileInputUI.d(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.d.MtP.aQj("ie_reg_eu");
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.d.MtP.aQj("ie_login");
          }
          AppMethodBeat.o(305177);
        }
      });
      this.qcC.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(305173);
          MobileInputUI.this.qcH.setEnabled(true);
          AppMethodBeat.o(305173);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(305176);
          if (this.qcX[0] != 0)
          {
            this.qcX[0] = false;
            if (MobileInputUI.d(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.d.MtP.aQh("ie_reg_eu");
            }
            if (MobileInputUI.e(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.d.MtP.aQh("ie_login");
            }
          }
          if (MobileInputUI.d(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.d.MtP.aQi("ie_reg_eu");
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.d.MtP.aQi("ie_login");
          }
          AppMethodBeat.o(305176);
        }
      });
      this.qaR.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128337);
          MobileInputUI.this.qcH.setEnabled(true);
          AppMethodBeat.o(128337);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(128338);
          AppMethodBeat.o(128338);
        }
      });
      this.qcC.setOnEditorActionListener(new MobileInputUI.6(this));
      this.qcC.setOnKeyListener(new MobileInputUI.7(this));
      localObject = new boolean[1];
      localObject[0] = 0;
      this.qcH.setEnabled(true);
      this.qcH.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(305182);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(305182);
            return false;
            this.qbm[0] = true;
            if (MobileInputUI.d(MobileInputUI.this))
            {
              MobileInputUI.a(MobileInputUI.this, com.tencent.mm.plugin.normsg.a.c.aeT(1));
              com.tencent.mm.plugin.normsg.a.d.MtP.aJ("ce_reg", "<Reg>", MobileInputUI.f(MobileInputUI.this));
            }
            if (MobileInputUI.e(MobileInputUI.this))
            {
              MobileInputUI.b(MobileInputUI.this, com.tencent.mm.plugin.normsg.a.c.aeT(2));
              com.tencent.mm.plugin.normsg.a.d.MtP.aJ("ce_login_id", "<Login>", MobileInputUI.g(MobileInputUI.this));
              continue;
              if (MobileInputUI.d(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_reg", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_reg");
              }
              if (MobileInputUI.e(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_login_id", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_login_id");
              }
            }
          }
        }
      });
      this.qcH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305181);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (this.qbm[0] != 0) {
            this.qbm[0] = false;
          }
          for (;;)
          {
            MobileInputUI.h(MobileInputUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(305181);
            return;
            if (MobileInputUI.d(MobileInputUI.this))
            {
              MobileInputUI.a(MobileInputUI.this, com.tencent.mm.plugin.normsg.a.c.aeT(1));
              com.tencent.mm.plugin.normsg.a.d.MtP.aJ("ce_reg", "<Reg>", MobileInputUI.f(MobileInputUI.this));
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_reg", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_reg");
            }
            if (MobileInputUI.e(MobileInputUI.this))
            {
              MobileInputUI.b(MobileInputUI.this, com.tencent.mm.plugin.normsg.a.c.aeT(2));
              com.tencent.mm.plugin.normsg.a.d.MtP.aJ("ce_login_id", "<Login>", MobileInputUI.g(MobileInputUI.this));
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.d.MtP.a("ce_login_id", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.d.MtP.aQm("ce_login_id");
            }
          }
        }
      });
      if (WeChatSomeFeatureSwitch.onlyUSMobile())
      {
        this.countryCode = "1";
        this.oLl = com.tencent.mm.au.b.bI(this.countryCode, getString(r.j.country_code));
      }
      if (!Util.isNullOrNil(this.countryCode)) {
        break label993;
      }
      this.oLl = getString(r.j.country_normal_name);
      this.countryCode = PhoneFormater.pureCountryCode(getString(r.j.country_normal_code));
      label709:
      if ((Util.isNullOrNil(this.oLl)) || (Util.isNullOrNil(this.countryCode)))
      {
        this.qaB = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        Log.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + this.qaB);
        if (!Util.isNullOrNil(this.qaB)) {
          break label1014;
        }
        Log.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
    }
    for (;;)
    {
      bYq();
      if (Util.isNullOrNil(this.pPb)) {
        this.qcC.setText(this.pPb);
      }
      this.pOX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128343);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView.getContext();
          if (com.tencent.mm.au.b.OB(MobileInputUI.this.getString(r.j.country_code)).size() > 1)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("country_name", MobileInputUI.this.oLl);
            paramAnonymousView.putExtra("couttry_code", MobileInputUI.this.countryCode);
            paramAnonymousView.putExtra("iso_code", MobileInputUI.this.qaB);
            com.tencent.mm.plugin.account.sdk.a.pFn.b(paramAnonymousView, MobileInputUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128343);
        }
      });
      localObject = "";
      if ((com.tencent.mm.protocal.d.Yxk) || (BuildInfo.IS_FLAVOR_BLUE)) {
        localObject = getString(r.j.app_name) + com.tencent.mm.ce.j.mx(this);
      }
      setMMTitle((String)localObject);
      setActionbarColor(getResources().getColor(r.c.normal_actionbar_color));
      hideActionbarLine();
      if (WeChatBrands.Business.Entries.LoginPasswordReset.banned()) {
        this.pZd.setVisibility(8);
      }
      localObject = com.tencent.mm.util.d.agsY;
      if (com.tencent.mm.util.d.jJv()) {
        addIconOptionMenu(0, getString(r.j.app_repairer), r.i.icons_outlined_setting, new MobileInputUI.11(this));
      }
      AppMethodBeat.o(128362);
      return;
      this.pZf.setVisibility(8);
      this.pZg.setText(r.j.login_by_more);
      this.pZg.setOnClickListener(new MobileInputUI.2(this, (com.tencent.mm.ui.widget.a.f)localObject));
      break;
      label993:
      this.oLl = com.tencent.mm.au.b.bI(this.countryCode, getString(r.j.country_code));
      break label709;
      label1014:
      localObject = com.tencent.mm.au.b.bH(this.qaB, getString(r.j.country_code));
      if (localObject == null)
      {
        Log.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
      else
      {
        this.countryCode = PhoneFormater.pureCountryCode(((b.a)localObject).oLk);
        this.oLl = ((b.a)localObject).oLl;
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(128368);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 32047)
    {
      if (paramIntent != null) {
        localObject1 = paramIntent.getBundleExtra("result_data");
      }
      if ((localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("agree_privacy")))
      {
        h.OAn.idkeyStat(712L, 2L, 1L, false);
        if ((this.qcS instanceof l)) {
          ((l)this.qcS).qcv = 0;
        }
        this.qcS.a(a.qcZ);
        AppMethodBeat.o(128368);
        return;
      }
      h.OAn.idkeyStat(712L, 1L, 1L, false);
      if ((this.qcS instanceof l)) {
        ((l)this.qcS).qcv = 1;
      }
      AppMethodBeat.o(128368);
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
        if ((this.qcS instanceof l)) {
          ((l)this.qcS).qcv = 2;
        }
        this.qcS.a(a.qcZ);
      }
      AppMethodBeat.o(128368);
      return;
    }
    if (paramInt1 == 32045)
    {
      localObject1 = localObject3;
      if (paramIntent != null) {
        localObject1 = paramIntent.getBundleExtra("result_data");
      }
      if ((paramInt2 == -1) && (localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("auth_again")) && ((this.qcS instanceof m))) {
        this.qcS.a(a.qcZ);
      }
      AppMethodBeat.o(128368);
      return;
    }
    switch (paramInt2)
    {
    }
    do
    {
      AppMethodBeat.o(128368);
      return;
      this.oLl = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
      this.qaB = Util.nullAs(paramIntent.getStringExtra("iso_code"), "");
      if ((this.qcR == 2) && (!com.tencent.mm.au.b.OF(this.countryCode)))
      {
        paramIntent = new Intent(this, RegByMobileRegAIOUI.class);
        paramIntent.putExtra("couttry_code", this.countryCode);
        paramIntent.putExtra("country_name", this.oLl);
        paramIntent.putExtra("iso_code", this.qaB);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(128368);
        return;
      }
      bYq();
      AppMethodBeat.o(128368);
      return;
    } while ((paramInt1 != 1024) || (paramIntent == null));
    localObject1 = paramIntent.getStringExtra("VoiceLoginAuthPwd");
    paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
    boolean bool = Util.isNullOrNil((String)localObject1);
    if (Util.isNullOrNil((String)localObject1)) {}
    for (paramInt1 = i;; paramInt1 = ((String)localObject1).length())
    {
      Log.d("MicroMsg.MobileInputUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break;
      }
      bYp();
      AppMethodBeat.o(128368);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128357);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    getWindow().getDecorView().setBackgroundColor(getContext().getResources().getColor(r.c.normal_bg_color));
    this.qcR = getIntent().getIntExtra("mobile_input_purpose", 0);
    this.olm = getIntent().getIntExtra("mobile_auth_type", 0);
    this.qcT = getIntent().getBooleanExtra("can_finish", false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128345);
        MobileInputUI.b(MobileInputUI.this);
        AppMethodBeat.o(128345);
        return true;
      }
    }, r.i.actionbar_icon_close_black);
    setActionbarColor(getContext().getResources().getColor(r.c.normal_actionbar_color));
    hideActionbarLine();
    switch (this.qcR)
    {
    case 0: 
    default: 
      Log.e("MicroMsg.MobileInputUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.qcR) });
      finish();
      AppMethodBeat.o(128357);
      return;
    case 1: 
      if (!Util.isNullOrNil(getIntent().getStringExtra("auth_ticket")))
      {
        this.qcS = new m();
        this.countryCode = PhoneFormater.pureCountryCode(Util.nullAs(getIntent().getStringExtra("couttry_code"), ""));
        this.oLl = Util.nullAs(getIntent().getStringExtra("country_name"), "");
        this.qaB = Util.nullAsNil(getIntent().getStringExtra("iso_code"));
        this.pPb = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.qcP = PhoneFormater.countryCodeWithPlus(this.countryCode);
        this.qcQ = Util.nullAs(getIntent().getStringExtra("input_mobile_number"), "");
        this.pQb = com.tencent.mm.plugin.b.a.chY();
        initView();
        this.qbB = getIntent().getBooleanExtra("from_deep_link", false);
        if ((this.qbB) && (!Util.isNullOrNil(this.qcP)) && (!Util.isNullOrNil(this.qcQ))) {
          this.qcB.setText(this.qcQ);
        }
        this.qcS.a(this);
        if (!BuildInfo.EX_DEVICE_LOGIN)
        {
          if ((aw.jkP()) || (aw.ato())) {
            paramBundle = com.tencent.mm.plugin.account.model.d.pWz;
          }
        }
        else
        {
          this.pZs.setVisibility(0);
          if ((!aw.jkP()) || (aw.ato())) {
            break label600;
          }
          this.pZs.setText(getResources().getString(r.j.login_in_pad_and_phone));
        }
      }
      break;
    }
    for (;;)
    {
      this.pZs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128347);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.br.c.ai(MobileInputUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
          MobileInputUI.this.overridePendingTransition(r.a.push_down_in, r.a.anim_not_change);
          h.OAn.tJ(3L);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128347);
        }
      });
      this.qaE = getIntent().getBooleanExtra("from_switch_account", false);
      com.tencent.mm.xwebutil.c.jQG();
      ad.a.avN(6);
      AppMethodBeat.o(128357);
      return;
      paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
      if (paramBundle != null) {
        this.pZy = paramBundle;
      }
      this.qcS = new j();
      break;
      this.qcS = new l();
      break;
      this.qcS = new i();
      break;
      this.qcS = new k();
      break;
      this.qcS = new m();
      break;
      label600:
      if (aw.ato()) {
        this.pZs.setText(getResources().getString(r.j.fold_login_in_pad));
      } else {
        this.pZs.setText(getResources().getString(r.j.login_as_other_device));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128361);
    if (bYm()) {
      com.tencent.mm.plugin.normsg.a.d.MtP.aQj("ie_reg_eu");
    }
    if (bYn()) {
      com.tencent.mm.plugin.normsg.a.d.MtP.aQj("ie_login");
    }
    if (this.qcD != null) {
      this.qcD.reset();
    }
    super.onDestroy();
    AppMethodBeat.o(128361);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128366);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(128366);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128366);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128359);
    super.onPause();
    this.pZz.dead();
    this.qcS.stop();
    AppMethodBeat.o(128359);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169142);
    this.qbk.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169142);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128358);
    this.pZz.alive();
    super.onResume();
    this.qcS.start();
    AppMethodBeat.o(128358);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setRequestedOrientation(int paramInt) {}
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(305101);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.mvvmbase.b.a.class);
    AppMethodBeat.o(305101);
  }
  
  protected static enum a
  {
    static
    {
      AppMethodBeat.i(128355);
      qcY = new a("GoBack", 0);
      qcZ = new a("GoNext", 1);
      qda = new a[] { qcY, qcZ };
      AppMethodBeat.o(128355);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void a(MobileInputUI.a parama);
    
    public abstract void a(MobileInputUI paramMobileInputUI);
    
    public abstract void start();
    
    public abstract void stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI
 * JD-Core Version:    0.7.0.1
 */