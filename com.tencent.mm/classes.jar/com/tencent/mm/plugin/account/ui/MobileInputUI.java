package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.b.a;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;

public class MobileInputUI
  extends MMActivity
{
  protected String countryCode;
  protected String lSz;
  protected int ltN;
  protected LinearLayout mSs;
  protected TextView mSu;
  protected String mSw;
  protected String mTu;
  protected s mUN;
  private IListener ncA;
  protected EditText ndD;
  protected Button ndJ;
  protected Button ndK;
  private View ndL;
  protected Button ndM;
  private ResizeLayout ndS;
  protected String ndg;
  protected boolean ndl;
  protected MMFormInputView neK;
  private MMKeyboardUperView neO;
  protected boolean neP;
  private final int neR;
  private Button nec;
  protected int[] nei;
  private x nex;
  protected TextView nfA;
  protected TextView nfB;
  protected TextView nfC;
  protected Button nfD;
  protected View nfE;
  protected boolean nfF;
  protected String nfG;
  protected String nfH;
  private int nfI;
  private b nfJ;
  protected boolean nfK;
  private String nfL;
  private String nfM;
  protected MMFormInputView nft;
  protected EditText nfu;
  protected MMFormVerifyCodeInputView nfv;
  protected View nfw;
  protected CheckBox nfx;
  protected TextView nfy;
  protected Button nfz;
  
  public MobileInputUI()
  {
    AppMethodBeat.i(128356);
    this.nfF = true;
    this.nfG = null;
    this.nfH = null;
    this.mSw = null;
    this.lSz = null;
    this.countryCode = null;
    this.ndg = null;
    this.nfI = 0;
    this.nei = new int[5];
    this.neP = false;
    this.nfL = "";
    this.nfM = "";
    this.ncA = new MobileInputUI.1(this);
    this.neR = 128;
    this.nex = new x();
    AppMethodBeat.o(128356);
  }
  
  private static void W(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128369);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
    com.tencent.mm.by.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128369);
  }
  
  private boolean bzA()
  {
    return this.nfI == 2;
  }
  
  private boolean bzB()
  {
    return (this.ltN == 7) || (this.ltN == 6);
  }
  
  private void bzD()
  {
    AppMethodBeat.i(128364);
    hideVKB();
    this.nex.b(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169141);
        MobileInputUI.k(MobileInputUI.this);
        AppMethodBeat.o(169141);
      }
    });
    AppMethodBeat.o(128364);
  }
  
  private void bzE()
  {
    AppMethodBeat.i(128367);
    if ((!Util.isNullOrNil(this.lSz)) && (!Util.isNullOrNil(this.countryCode)))
    {
      this.mSu.setText(PhoneFormater.countryNameWithCode(this.lSz, this.countryCode));
      AppMethodBeat.o(128367);
      return;
    }
    this.mSu.setText(getString(r.j.mobile_code_error));
    AppMethodBeat.o(128367);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128365);
    if (this.nfK)
    {
      hideVKB();
      Object localObject = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.lb(this);
      AppMethodBeat.o(128365);
      return;
    }
    this.nfJ.a(a.nfP);
    com.tencent.mm.plugin.b.a.bkD(this.mTu);
    hideVKB();
    finish();
    AppMethodBeat.o(128365);
  }
  
  public final boolean bzC()
  {
    AppMethodBeat.i(128363);
    if ((this.nfu.getText() != null) && (!Util.isNullOrNil(this.nfu.getText().toString())) && (this.nfF)) {
      if (this.nfI == 2)
      {
        if ((this.ndD.getText() != null) && (!Util.isNullOrNil(this.ndD.getText().toString())))
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
    com.tencent.mm.plugin.report.service.h.IzE.a(14262, new Object[] { Integer.valueOf(this.nei[0]), Integer.valueOf(this.nei[1]), Integer.valueOf(this.nei[2]), Integer.valueOf(this.nei[3]), Integer.valueOf(this.nei[4]) });
    AppMethodBeat.o(128360);
  }
  
  public int getLayoutId()
  {
    return r.g.mobile_input_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128362);
    this.neK = ((MMFormInputView)findViewById(r.f.setpassword_container));
    this.ndD = this.neK.getContentEditText();
    com.tencent.mm.ui.tools.b.c.i(this.ndD).axx(16).a(null);
    this.nft = ((MMFormInputView)findViewById(r.f.mobile_number_display));
    this.nft.setInputType(3);
    this.nfu = this.nft.getContentEditText();
    this.nfv = ((MMFormVerifyCodeInputView)findViewById(r.f.sms_verify_container));
    this.nfv.setInputType(3);
    this.mSs = ((LinearLayout)findViewById(r.f.country_code_ll));
    this.mSu = ((TextView)findViewById(r.f.country_name));
    this.nfw = findViewById(r.f.reg_license);
    this.nfx = ((CheckBox)findViewById(r.f.reg_term_check));
    this.nfy = ((TextView)findViewById(r.f.reg_term));
    this.nfz = ((Button)findViewById(r.f.next_btn));
    this.nfA = ((TextView)findViewById(r.f.register_title));
    this.nfB = ((TextView)findViewById(r.f.login_title));
    this.nfC = ((TextView)findViewById(r.f.mobile_input_hint));
    this.nfD = ((Button)findViewById(r.f.login_by_other));
    this.nec = ((Button)findViewById(r.f.login_as_other_device_btn));
    this.ndJ = ((Button)findViewById(r.f.login_find_password_btn));
    this.ndK = ((Button)findViewById(r.f.login_freeze_account_btn));
    this.ndL = findViewById(r.f.free_btn_container);
    this.ndM = ((Button)findViewById(r.f.login_more_btn));
    this.nfE = findViewById(r.f.bottom_btn_container);
    this.ndS = ((ResizeLayout)findViewById(r.f.resize_lv));
    this.neO = ((MMKeyboardUperView)findViewById(r.f.scrollView));
    this.mSs.setVisibility(8);
    this.neK.setVisibility(8);
    this.nfv.setVisibility(8);
    this.nft.setVisibility(8);
    this.nfA.setVisibility(8);
    this.nfB.setVisibility(8);
    this.nfz.setVisibility(8);
    this.nfw.setVisibility(8);
    this.nfD.setVisibility(8);
    this.ndS.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void bzv()
      {
        AppMethodBeat.i(128348);
        MobileInputUI.c(MobileInputUI.this);
        AppMethodBeat.o(128348);
      }
    });
    this.ndJ.setOnClickListener(new MobileInputUI.17(this));
    this.ndK.setOnClickListener(new MobileInputUI.18(this));
    Object localObject = new e(this, 1, false);
    ((e)localObject).ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(128351);
        if (paramAnonymouso.hJO())
        {
          paramAnonymouso.mn(5001, r.j.wechat_safe_center);
          paramAnonymouso.mn(5002, r.j.wechat_help_center);
        }
        AppMethodBeat.o(128351);
      }
    };
    ((e)localObject).ODU = new MobileInputUI.20(this);
    ((e)localObject).XbB = new e.b()
    {
      public final void onDismiss() {}
    };
    if (LocaleUtil.isSimplifiedChineseAppLang())
    {
      this.ndM.setOnClickListener(new MobileInputUI.2(this));
      localObject = new boolean[1];
      localObject[0] = 1;
      this.nfu.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(128336);
          if (paramAnonymousBoolean)
          {
            this.nfO[0] = true;
            AppMethodBeat.o(128336);
            return;
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.d.GxJ.aTj("ie_reg_eu");
          }
          if (MobileInputUI.f(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.d.GxJ.aTj("ie_login");
          }
          AppMethodBeat.o(128336);
        }
      });
      this.nfu.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128337);
          MobileInputUI.this.nfz.setEnabled(MobileInputUI.this.bzC());
          AppMethodBeat.o(128337);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(128338);
          if (this.nfO[0] != 0)
          {
            this.nfO[0] = false;
            if (MobileInputUI.e(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.d.GxJ.aTh("ie_reg_eu");
            }
            if (MobileInputUI.f(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.d.GxJ.aTh("ie_login");
            }
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.d.GxJ.aTi("ie_reg_eu");
          }
          if (MobileInputUI.f(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.d.GxJ.aTi("ie_login");
          }
          AppMethodBeat.o(128338);
        }
      });
      this.ndD.addTextChangedListener(new MobileInputUI.6(this));
      this.nfu.setOnEditorActionListener(new MobileInputUI.7(this));
      this.nfu.setOnKeyListener(new MobileInputUI.8(this));
      localObject = new boolean[1];
      localObject[0] = 0;
      this.nfz.setEnabled(false);
      this.nfz.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(128342);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(128342);
            return false;
            this.nez[0] = true;
            if (MobileInputUI.e(MobileInputUI.this))
            {
              MobileInputUI.a(MobileInputUI.this, com.tencent.mm.plugin.normsg.a.c.aaA(1));
              com.tencent.mm.plugin.normsg.a.d.GxJ.av("ce_reg", "<Reg>", MobileInputUI.g(MobileInputUI.this));
            }
            if (MobileInputUI.f(MobileInputUI.this))
            {
              MobileInputUI.b(MobileInputUI.this, com.tencent.mm.plugin.normsg.a.c.aaA(2));
              com.tencent.mm.plugin.normsg.a.d.GxJ.av("ce_login_id", "<Login>", MobileInputUI.h(MobileInputUI.this));
              continue;
              if (MobileInputUI.e(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.d.GxJ.a("ce_reg", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.d.GxJ.aTm("ce_reg");
              }
              if (MobileInputUI.f(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.d.GxJ.a("ce_login_id", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.d.GxJ.aTm("ce_login_id");
              }
            }
          }
        }
      });
      this.nfz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128343);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (this.nez[0] != 0) {
            this.nez[0] = false;
          }
          for (;;)
          {
            MobileInputUI.i(MobileInputUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128343);
            return;
            if (MobileInputUI.e(MobileInputUI.this))
            {
              MobileInputUI.a(MobileInputUI.this, com.tencent.mm.plugin.normsg.a.c.aaA(1));
              com.tencent.mm.plugin.normsg.a.d.GxJ.av("ce_reg", "<Reg>", MobileInputUI.g(MobileInputUI.this));
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.d.GxJ.a("ce_reg", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.d.GxJ.aTm("ce_reg");
            }
            if (MobileInputUI.f(MobileInputUI.this))
            {
              MobileInputUI.b(MobileInputUI.this, com.tencent.mm.plugin.normsg.a.c.aaA(2));
              com.tencent.mm.plugin.normsg.a.d.GxJ.av("ce_login_id", "<Login>", MobileInputUI.h(MobileInputUI.this));
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.d.GxJ.a("ce_login_id", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.d.GxJ.aTm("ce_login_id");
            }
          }
        }
      });
      if (WeChatSomeFeatureSwitch.onlyUSMobile())
      {
        this.countryCode = "1";
        this.lSz = com.tencent.mm.az.b.bx(this.countryCode, getString(r.j.country_code));
      }
      if (!Util.isNullOrNil(this.countryCode)) {
        break label989;
      }
      this.lSz = getString(r.j.country_normal_name);
      this.countryCode = PhoneFormater.pureCountryCode(getString(r.j.country_normal_code));
      label738:
      if ((Util.isNullOrNil(this.lSz)) || (Util.isNullOrNil(this.countryCode)))
      {
        this.ndg = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        Log.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + this.ndg);
        if (!Util.isNullOrNil(this.ndg)) {
          break label1010;
        }
        Log.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
    }
    for (;;)
    {
      bzE();
      if (Util.isNullOrNil(this.mSw)) {
        this.nfu.setText(this.mSw);
      }
      this.mSs.setOnClickListener(new MobileInputUI.11(this));
      localObject = "";
      if ((com.tencent.mm.protocal.d.RAG) || (BuildInfo.IS_FLAVOR_BLUE)) {
        localObject = getString(r.j.app_name) + com.tencent.mm.cj.h.kv(this);
      }
      setMMTitle((String)localObject);
      setActionbarColor(getResources().getColor(r.c.normal_actionbar_color));
      hideActionbarLine();
      if (WeChatBrands.Business.Entries.LoginPasswordReset.banned()) {
        this.ndJ.setVisibility(8);
      }
      AppMethodBeat.o(128362);
      return;
      this.ndL.setVisibility(8);
      this.ndM.setText(r.j.login_by_more);
      this.ndM.setOnClickListener(new MobileInputUI.3(this, (e)localObject));
      break;
      label989:
      this.lSz = com.tencent.mm.az.b.bx(this.countryCode, getString(r.j.country_code));
      break label738;
      label1010:
      localObject = com.tencent.mm.az.b.bw(this.ndg, getString(r.j.country_code));
      if (localObject == null)
      {
        Log.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
      else
      {
        this.countryCode = PhoneFormater.pureCountryCode(((b.a)localObject).lSy);
        this.lSz = ((b.a)localObject).lSz;
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
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(712L, 2L, 1L, false);
        if ((this.nfJ instanceof l)) {
          ((l)this.nfJ).nfn = 0;
        }
        this.nfJ.a(a.nfQ);
        AppMethodBeat.o(128368);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(712L, 1L, 1L, false);
      if ((this.nfJ instanceof l)) {
        ((l)this.nfJ).nfn = 1;
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
        if ((this.nfJ instanceof l)) {
          ((l)this.nfJ).nfn = 2;
        }
        this.nfJ.a(a.nfQ);
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
      if ((paramInt2 == -1) && (localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("auth_again")) && ((this.nfJ instanceof m))) {
        this.nfJ.a(a.nfQ);
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
      this.lSz = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
      this.ndg = Util.nullAs(paramIntent.getStringExtra("iso_code"), "");
      if ((this.nfI == 2) && (!com.tencent.mm.az.b.WG(this.countryCode)))
      {
        paramIntent = new Intent(this, RegByMobileRegAIOUI.class);
        paramIntent.putExtra("couttry_code", this.countryCode);
        paramIntent.putExtra("country_name", this.lSz);
        paramIntent.putExtra("iso_code", this.ndg);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aFh(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(128368);
        return;
      }
      bzE();
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
      bzD();
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
    this.nfI = getIntent().getIntExtra("mobile_input_purpose", 0);
    this.ltN = getIntent().getIntExtra("mobile_auth_type", 0);
    this.nfK = getIntent().getBooleanExtra("can_finish", false);
    setBackBtn(new MobileInputUI.12(this), r.i.actionbar_icon_close_black);
    setActionbarColor(getContext().getResources().getColor(r.c.normal_actionbar_color));
    hideActionbarLine();
    switch (this.nfI)
    {
    case 0: 
    default: 
      Log.e("MicroMsg.MobileInputUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.nfI) });
      finish();
      AppMethodBeat.o(128357);
      return;
    case 1: 
      if (!Util.isNullOrNil(getIntent().getStringExtra("auth_ticket")))
      {
        this.nfJ = new m();
        this.countryCode = PhoneFormater.pureCountryCode(Util.nullAs(getIntent().getStringExtra("couttry_code"), ""));
        this.lSz = Util.nullAs(getIntent().getStringExtra("country_name"), "");
        this.ndg = Util.nullAsNil(getIntent().getStringExtra("iso_code"));
        this.mSw = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.nfG = PhoneFormater.countryCodeWithPlus(this.countryCode);
        this.nfH = Util.nullAs(getIntent().getStringExtra("input_mobile_number"), "");
        this.mTu = com.tencent.mm.plugin.b.a.bAt();
        initView();
        this.neP = getIntent().getBooleanExtra("from_deep_link", false);
        if ((this.neP) && (!Util.isNullOrNil(this.nfG)) && (!Util.isNullOrNil(this.nfH))) {
          this.nft.setText(this.nfH);
        }
        this.nfJ.a(this);
        if (!BuildInfo.EX_DEVICE_LOGIN)
        {
          if ((ar.hIE()) && (!ar.hIM())) {
            paramBundle = com.tencent.mm.plugin.account.model.d.mZQ;
          }
        }
        else
        {
          this.nec.setVisibility(0);
          if ((!ar.hIE()) || (ar.hIM())) {
            break label595;
          }
          this.nec.setText(getResources().getString(r.j.login_in_pad_and_phone));
        }
      }
      break;
    }
    for (;;)
    {
      this.nec.setOnClickListener(new MobileInputUI.15(this));
      this.ndl = getIntent().getBooleanExtra("from_switch_account", false);
      com.tencent.mm.xwebutil.c.ikh();
      AppMethodBeat.o(128357);
      return;
      paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
      if (paramBundle != null) {
        this.nei = paramBundle;
      }
      this.nfJ = new j();
      break;
      this.nfJ = new l();
      break;
      this.nfJ = new i();
      break;
      this.nfJ = new k();
      break;
      this.nfJ = new m();
      break;
      label595:
      this.nec.setText(getResources().getString(r.j.login_as_other_device));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128361);
    if (bzA()) {
      com.tencent.mm.plugin.normsg.a.d.GxJ.aTj("ie_reg_eu");
    }
    if (bzB()) {
      com.tencent.mm.plugin.normsg.a.d.GxJ.aTj("ie_login");
    }
    if (this.nfv != null) {
      this.nfv.reset();
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
    EventCenter.instance.removeListener(this.ncA);
    this.nfJ.stop();
    AppMethodBeat.o(128359);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169142);
    this.nex.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169142);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128358);
    EventCenter.instance.addListener(this.ncA);
    super.onResume();
    this.nfJ.start();
    AppMethodBeat.o(128358);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setRequestedOrientation(int paramInt) {}
  
  protected static enum a
  {
    static
    {
      AppMethodBeat.i(128355);
      nfP = new a("GoBack", 0);
      nfQ = new a("GoNext", 1);
      nfR = new a[] { nfP, nfQ };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI
 * JD-Core Version:    0.7.0.1
 */