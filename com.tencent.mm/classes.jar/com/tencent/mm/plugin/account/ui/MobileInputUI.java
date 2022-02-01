package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;

public class MobileInputUI
  extends MMActivity
{
  protected String countryCode;
  protected int hJc;
  protected String ihe;
  protected LinearLayout jcU;
  protected TextView jcW;
  protected String jcY;
  protected String jdS;
  protected p jfk;
  private com.tencent.mm.sdk.b.c jmB;
  protected EditText jnE;
  protected Button jnK;
  protected Button jnL;
  private View jnM;
  protected Button jnN;
  private ResizeLayout jnT;
  protected String jnh;
  protected boolean jnn;
  protected MMFormInputView joI;
  private MMKeyboardUperView joM;
  protected boolean joN;
  private final int joP;
  private Button joc;
  protected int[] joi;
  private x jow;
  protected TextView jpA;
  protected Button jpB;
  protected View jpC;
  protected boolean jpD;
  protected String jpE;
  protected String jpF;
  private int jpG;
  private b jpH;
  protected boolean jpI;
  protected MMFormInputView jpr;
  protected EditText jps;
  protected MMFormVerifyCodeInputView jpt;
  protected View jpu;
  protected CheckBox jpv;
  protected TextView jpw;
  protected Button jpx;
  protected TextView jpy;
  protected TextView jpz;
  
  public MobileInputUI()
  {
    AppMethodBeat.i(128356);
    this.jpD = true;
    this.jpE = null;
    this.jpF = null;
    this.jcY = null;
    this.ihe = null;
    this.countryCode = null;
    this.jnh = null;
    this.jpG = 0;
    this.joi = new int[5];
    this.joN = false;
    this.jmB = new MobileInputUI.1(this);
    this.joP = 128;
    this.jow = new x();
    AppMethodBeat.o(128356);
  }
  
  private static void R(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128369);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128369);
  }
  
  private boolean aUB()
  {
    return this.jpG == 2;
  }
  
  private boolean aUC()
  {
    return this.jpG == 1;
  }
  
  private void aUE()
  {
    AppMethodBeat.i(128364);
    hideVKB();
    this.jow.b(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169141);
        MobileInputUI.i(MobileInputUI.this);
        AppMethodBeat.o(169141);
      }
    });
    AppMethodBeat.o(128364);
  }
  
  private void aUF()
  {
    AppMethodBeat.i(128367);
    if ((!bu.isNullOrNil(this.ihe)) && (!bu.isNullOrNil(this.countryCode)))
    {
      this.jcW.setText(bb.lU(this.ihe, this.countryCode));
      AppMethodBeat.o(128367);
      return;
    }
    this.jcW.setText(getString(2131761245));
    AppMethodBeat.o(128367);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128365);
    if (this.jpI)
    {
      hideVKB();
      Object localObject = com.tencent.mm.plugin.account.a.a.iUz.bE(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.kl(this);
      AppMethodBeat.o(128365);
      return;
    }
    this.jpH.a(a.jpL);
    com.tencent.mm.plugin.b.a.KB(this.jdS);
    hideVKB();
    finish();
    AppMethodBeat.o(128365);
  }
  
  public final boolean aUD()
  {
    AppMethodBeat.i(128363);
    if ((this.jps.getText() != null) && (!bu.isNullOrNil(this.jps.getText().toString())) && (this.jpD)) {
      if (this.jpG == 2)
      {
        if ((this.jnE.getText() != null) && (!bu.isNullOrNil(this.jnE.getText().toString())))
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
    overridePendingTransition(2130771986, 2130771986);
    com.tencent.mm.plugin.report.service.g.yxI.f(14262, new Object[] { Integer.valueOf(this.joi[0]), Integer.valueOf(this.joi[1]), Integer.valueOf(this.joi[2]), Integer.valueOf(this.joi[3]), Integer.valueOf(this.joi[4]) });
    AppMethodBeat.o(128360);
  }
  
  public int getLayoutId()
  {
    return 2131494923;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128362);
    this.joI = ((MMFormInputView)findViewById(2131304611));
    this.jnE = this.joI.getContentEditText();
    com.tencent.mm.ui.tools.b.c.d(this.jnE).afD(16).a(null);
    this.jpr = ((MMFormInputView)findViewById(2131302363));
    this.jpr.setInputType(3);
    this.jps = this.jpr.getContentEditText();
    this.jpt = ((MMFormVerifyCodeInputView)findViewById(2131304879));
    this.jpt.setInputType(3);
    this.jcU = ((LinearLayout)findViewById(2131298805));
    this.jcW = ((TextView)findViewById(2131298807));
    this.jpu = findViewById(2131303937);
    this.jpv = ((CheckBox)findViewById(2131303944));
    this.jpw = ((TextView)findViewById(2131303943));
    this.jpx = ((Button)findViewById(2131302852));
    this.jpy = ((TextView)findViewById(2131303962));
    this.jpz = ((TextView)findViewById(2131301582));
    this.jpA = ((TextView)findViewById(2131302360));
    this.jpB = ((Button)findViewById(2131301569));
    this.joc = ((Button)findViewById(2131301559));
    this.jnK = ((Button)findViewById(2131301572));
    this.jnL = ((Button)findViewById(2131301574));
    this.jnM = findViewById(2131300241);
    this.jnN = ((Button)findViewById(2131301575));
    this.jpC = findViewById(2131297439);
    this.jnT = ((ResizeLayout)findViewById(2131304133));
    this.joM = ((MMKeyboardUperView)findViewById(2131304370));
    this.jcU.setVisibility(8);
    this.joI.setVisibility(8);
    this.jpt.setVisibility(8);
    this.jpr.setVisibility(8);
    this.jpy.setVisibility(8);
    this.jpz.setVisibility(8);
    this.jpx.setVisibility(8);
    this.jpu.setVisibility(8);
    this.jpB.setVisibility(8);
    this.jnT.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aUw()
      {
        AppMethodBeat.i(128348);
        MobileInputUI.c(MobileInputUI.this);
        AppMethodBeat.o(128348);
      }
    });
    this.jnK.setOnClickListener(new MobileInputUI.17(this));
    this.jnL.setOnClickListener(new MobileInputUI.18(this));
    Object localObject = new e(this, 1, false);
    ((e)localObject).LfS = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(128351);
        if (paramAnonymousl.fCR())
        {
          paramAnonymousl.jM(5001, 2131766192);
          paramAnonymousl.jM(5002, 2131766189);
        }
        AppMethodBeat.o(128351);
      }
    };
    ((e)localObject).LfT = new MobileInputUI.20(this);
    ((e)localObject).KtV = new e.b()
    {
      public final void onDismiss() {}
    };
    if (ad.foj())
    {
      this.jnN.setOnClickListener(new MobileInputUI.2(this));
      localObject = new boolean[1];
      localObject[0] = 1;
      this.jps.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(128336);
          if (paramAnonymousBoolean)
          {
            this.jpK[0] = true;
            AppMethodBeat.o(128336);
            return;
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_reg_eu");
          }
          if (MobileInputUI.f(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_login");
          }
          AppMethodBeat.o(128336);
        }
      });
      this.jps.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128337);
          MobileInputUI.this.jpx.setEnabled(MobileInputUI.this.aUD());
          AppMethodBeat.o(128337);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(128338);
          if (this.jpK[0] != 0)
          {
            this.jpK[0] = false;
            if (MobileInputUI.e(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.b.wJt.auC("ie_reg_eu");
            }
            if (MobileInputUI.f(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.b.wJt.auC("ie_login");
            }
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.wJt.auD("ie_reg_eu");
          }
          if (MobileInputUI.f(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.wJt.auD("ie_login");
          }
          AppMethodBeat.o(128338);
        }
      });
      this.jnE.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128339);
          MobileInputUI.this.jpx.setEnabled(MobileInputUI.this.aUD());
          AppMethodBeat.o(128339);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.jps.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128340);
          if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
          {
            boolean bool = MobileInputUI.this.aUD();
            AppMethodBeat.o(128340);
            return bool;
          }
          AppMethodBeat.o(128340);
          return false;
        }
      });
      this.jps.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128341);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.bd(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$16", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            boolean bool = MobileInputUI.this.aUD();
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/account/ui/MobileInputUI$16", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
            AppMethodBeat.o(128341);
            return bool;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/MobileInputUI$16", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
          AppMethodBeat.o(128341);
          return false;
        }
      });
      localObject = new boolean[1];
      localObject[0] = 0;
      this.jpx.setEnabled(false);
      this.jpx.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(128342);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$17", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/MobileInputUI$17", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(128342);
            return false;
            this.joR[0] = true;
            if (MobileInputUI.e(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_reg_eu", "<Reg>");
            }
            if (MobileInputUI.f(MobileInputUI.this))
            {
              com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_login", "<Login>");
              continue;
              if (MobileInputUI.e(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_reg_eu", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_reg_eu");
              }
              if (MobileInputUI.f(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_login", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_login");
              }
            }
          }
        }
      });
      this.jpx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128343);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (this.joR[0] != 0) {
            this.joR[0] = false;
          }
          for (;;)
          {
            MobileInputUI.g(MobileInputUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128343);
            return;
            if (MobileInputUI.e(MobileInputUI.this))
            {
              com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_reg_eu", "<Reg>");
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_reg_eu", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_reg_eu");
            }
            if (MobileInputUI.f(MobileInputUI.this))
            {
              com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_login", "<Login>");
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_login", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_login");
            }
          }
        }
      });
      if (!bu.isNullOrNil(this.countryCode)) {
        break label941;
      }
      this.ihe = getString(2131757952);
      this.countryCode = bb.aSg(getString(2131757951));
      label707:
      if ((bu.isNullOrNil(this.ihe)) || (bu.isNullOrNil(this.countryCode)))
      {
        this.jnh = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        ae.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + this.jnh);
        if (!bu.isNullOrNil(this.jnh)) {
          break label962;
        }
        ae.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
    }
    for (;;)
    {
      aUF();
      if (bu.isNullOrNil(this.jcY)) {
        this.jps.setText(this.jcY);
      }
      this.jcU.setOnClickListener(new MobileInputUI.11(this));
      localObject = "";
      if ((com.tencent.mm.protocal.d.FFK) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_BLUE)) {
        localObject = getString(2131755822) + com.tencent.mm.cc.g.ix(this);
      }
      setMMTitle((String)localObject);
      setActionbarColor(getResources().getColor(2131100705));
      hideActionbarLine();
      AppMethodBeat.o(128362);
      return;
      this.jnM.setVisibility(8);
      this.jnN.setText(2131760754);
      this.jnN.setOnClickListener(new MobileInputUI.3(this, (e)localObject));
      break;
      label941:
      this.ihe = com.tencent.mm.aw.b.br(this.countryCode, getString(2131757950));
      break label707;
      label962:
      localObject = com.tencent.mm.aw.b.bq(this.jnh, getString(2131757950));
      if (localObject == null)
      {
        ae.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
      else
      {
        this.countryCode = bb.aSg(((b.a)localObject).ihd);
        this.ihe = ((b.a)localObject).ihe;
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
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(712L, 2L, 1L, false);
        if ((this.jpH instanceof k)) {
          ((k)this.jpH).jpl = 0;
        }
        this.jpH.a(a.jpM);
        AppMethodBeat.o(128368);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(712L, 1L, 1L, false);
      if ((this.jpH instanceof k)) {
        ((k)this.jpH).jpl = 1;
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
        if ((this.jpH instanceof k)) {
          ((k)this.jpH).jpl = 2;
        }
        this.jpH.a(a.jpM);
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
      if ((paramInt2 == -1) && (localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("auth_again")) && ((this.jpH instanceof l))) {
        this.jpH.a(a.jpM);
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
      this.ihe = bu.bI(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bu.bI(paramIntent.getStringExtra("couttry_code"), "");
      this.jnh = bu.bI(paramIntent.getStringExtra("iso_code"), "");
      if ((this.jpG == 2) && (!com.tencent.mm.aw.b.Gx(this.countryCode)))
      {
        paramIntent = new Intent(this, RegByMobileRegAIOUI.class);
        paramIntent.putExtra("couttry_code", this.countryCode);
        paramIntent.putExtra("country_name", this.ihe);
        paramIntent.putExtra("iso_code", this.jnh);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahE(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(128368);
        return;
      }
      aUF();
      AppMethodBeat.o(128368);
      return;
    } while ((paramInt1 != 1024) || (paramIntent == null));
    localObject1 = paramIntent.getStringExtra("VoiceLoginAuthPwd");
    paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
    boolean bool = bu.isNullOrNil((String)localObject1);
    if (bu.isNullOrNil((String)localObject1)) {}
    for (paramInt1 = i;; paramInt1 = ((String)localObject1).length())
    {
      ae.d("MicroMsg.MobileInputUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break;
      }
      aUE();
      AppMethodBeat.o(128368);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128357);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    getWindow().getDecorView().setBackgroundColor(getContext().getResources().getColor(2131100706));
    this.jpG = getIntent().getIntExtra("mobile_input_purpose", 0);
    this.hJc = getIntent().getIntExtra("mobile_auth_type", 0);
    this.jpI = getIntent().getBooleanExtra("can_finish", false);
    setBackBtn(new MobileInputUI.12(this), 2131689488);
    setActionbarColor(getContext().getResources().getColor(2131100705));
    hideActionbarLine();
    switch (this.jpG)
    {
    case 0: 
    default: 
      ae.e("MicroMsg.MobileInputUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.jpG) });
      finish();
      AppMethodBeat.o(128357);
      return;
    case 1: 
      if (!bu.isNullOrNil(getIntent().getStringExtra("auth_ticket"))) {
        this.jpH = new l();
      }
      break;
    }
    for (;;)
    {
      this.countryCode = bb.aSg(bu.bI(getIntent().getStringExtra("couttry_code"), ""));
      this.ihe = bu.bI(getIntent().getStringExtra("country_name"), "");
      this.jnh = bu.nullAsNil(getIntent().getStringExtra("iso_code"));
      this.jcY = bu.bI(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
      this.jpE = bb.aSh(this.countryCode);
      this.jpF = bu.bI(getIntent().getStringExtra("input_mobile_number"), "");
      this.jdS = com.tencent.mm.plugin.b.a.aVo();
      initView();
      this.joN = getIntent().getBooleanExtra("from_deep_link", false);
      if ((this.joN) && (!bu.isNullOrNil(this.jpE)) && (!bu.isNullOrNil(this.jpF))) {
        this.jpr.setText(this.jpF);
      }
      this.jpH.a(this);
      if (com.tencent.mm.sdk.platformtools.j.EX_DEVICE_LOGIN)
      {
        this.joc.setVisibility(0);
        this.joc.setOnClickListener(new MobileInputUI.15(this));
      }
      this.jnn = getIntent().getBooleanExtra("from_switch_account", false);
      com.tencent.mm.cp.d.fWU();
      AppMethodBeat.o(128357);
      return;
      paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
      if (paramBundle != null) {
        this.joi = paramBundle;
      }
      this.jpH = new i();
      continue;
      this.jpH = new k();
      continue;
      this.jpH = new h();
      continue;
      this.jpH = new j();
      continue;
      this.jpH = new l();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128361);
    if (aUB()) {
      com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_reg_eu");
    }
    if (aUC()) {
      com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_login");
    }
    if (this.jpt != null) {
      this.jpt.reset();
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
    com.tencent.mm.sdk.b.a.IvT.d(this.jmB);
    this.jpH.stop();
    AppMethodBeat.o(128359);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169142);
    this.jow.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169142);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128358);
    com.tencent.mm.sdk.b.a.IvT.c(this.jmB);
    super.onResume();
    this.jpH.start();
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
      jpL = new a("GoBack", 0);
      jpM = new a("GoNext", 1);
      jpN = new a[] { jpL, jpM };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI
 * JD-Core Version:    0.7.0.1
 */