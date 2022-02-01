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
import com.tencent.mm.ax.b.a;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
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
  protected int hGk;
  protected String iem;
  protected String jaZ;
  protected LinearLayout jab;
  protected TextView jad;
  protected String jaf;
  protected p jcr;
  private com.tencent.mm.sdk.b.c jjI;
  protected EditText jkK;
  protected Button jkQ;
  protected Button jkR;
  private View jkS;
  protected Button jkT;
  private ResizeLayout jkZ;
  protected String jko;
  protected boolean jkt;
  private x jlC;
  protected MMFormInputView jlO;
  private MMKeyboardUperView jlS;
  protected boolean jlT;
  private final int jlV;
  private Button jli;
  protected int[] jlo;
  protected View jmA;
  protected CheckBox jmB;
  protected TextView jmC;
  protected Button jmD;
  protected TextView jmE;
  protected TextView jmF;
  protected TextView jmG;
  protected Button jmH;
  protected View jmI;
  protected boolean jmJ;
  protected String jmK;
  protected String jmL;
  private int jmM;
  private b jmN;
  protected boolean jmO;
  protected MMFormInputView jmx;
  protected EditText jmy;
  protected MMFormVerifyCodeInputView jmz;
  
  public MobileInputUI()
  {
    AppMethodBeat.i(128356);
    this.jmJ = true;
    this.jmK = null;
    this.jmL = null;
    this.jaf = null;
    this.iem = null;
    this.countryCode = null;
    this.jko = null;
    this.jmM = 0;
    this.jlo = new int[5];
    this.jlT = false;
    this.jjI = new MobileInputUI.1(this);
    this.jlV = 128;
    this.jlC = new x();
    AppMethodBeat.o(128356);
  }
  
  private static void Q(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128369);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128369);
  }
  
  private boolean aUc()
  {
    return this.jmM == 2;
  }
  
  private boolean aUd()
  {
    return this.jmM == 1;
  }
  
  private void aUf()
  {
    AppMethodBeat.i(128364);
    hideVKB();
    this.jlC.b(this, new Runnable()
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
  
  private void aUg()
  {
    AppMethodBeat.i(128367);
    if ((!bt.isNullOrNil(this.iem)) && (!bt.isNullOrNil(this.countryCode)))
    {
      this.jad.setText(ba.lN(this.iem, this.countryCode));
      AppMethodBeat.o(128367);
      return;
    }
    this.jad.setText(getString(2131761245));
    AppMethodBeat.o(128367);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128365);
    if (this.jmO)
    {
      hideVKB();
      Object localObject = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.ke(this);
      AppMethodBeat.o(128365);
      return;
    }
    this.jmN.a(a.jmR);
    com.tencent.mm.plugin.b.a.Ma(this.jaZ);
    hideVKB();
    finish();
    AppMethodBeat.o(128365);
  }
  
  public final boolean aUe()
  {
    AppMethodBeat.i(128363);
    if ((this.jmy.getText() != null) && (!bt.isNullOrNil(this.jmy.getText().toString())) && (this.jmJ)) {
      if (this.jmM == 2)
      {
        if ((this.jkK.getText() != null) && (!bt.isNullOrNil(this.jkK.getText().toString())))
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
    com.tencent.mm.plugin.report.service.g.yhR.f(14262, new Object[] { Integer.valueOf(this.jlo[0]), Integer.valueOf(this.jlo[1]), Integer.valueOf(this.jlo[2]), Integer.valueOf(this.jlo[3]), Integer.valueOf(this.jlo[4]) });
    AppMethodBeat.o(128360);
  }
  
  public int getLayoutId()
  {
    return 2131494923;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128362);
    this.jlO = ((MMFormInputView)findViewById(2131304611));
    this.jkK = this.jlO.getContentEditText();
    com.tencent.mm.ui.tools.b.c.d(this.jkK).aeU(16).a(null);
    this.jmx = ((MMFormInputView)findViewById(2131302363));
    this.jmx.setInputType(3);
    this.jmy = this.jmx.getContentEditText();
    this.jmz = ((MMFormVerifyCodeInputView)findViewById(2131304879));
    this.jmz.setInputType(3);
    this.jab = ((LinearLayout)findViewById(2131298805));
    this.jad = ((TextView)findViewById(2131298807));
    this.jmA = findViewById(2131303937);
    this.jmB = ((CheckBox)findViewById(2131303944));
    this.jmC = ((TextView)findViewById(2131303943));
    this.jmD = ((Button)findViewById(2131302852));
    this.jmE = ((TextView)findViewById(2131303962));
    this.jmF = ((TextView)findViewById(2131301582));
    this.jmG = ((TextView)findViewById(2131302360));
    this.jmH = ((Button)findViewById(2131301569));
    this.jli = ((Button)findViewById(2131301559));
    this.jkQ = ((Button)findViewById(2131301572));
    this.jkR = ((Button)findViewById(2131301574));
    this.jkS = findViewById(2131300241);
    this.jkT = ((Button)findViewById(2131301575));
    this.jmI = findViewById(2131297439);
    this.jkZ = ((ResizeLayout)findViewById(2131304133));
    this.jlS = ((MMKeyboardUperView)findViewById(2131304370));
    this.jab.setVisibility(8);
    this.jlO.setVisibility(8);
    this.jmz.setVisibility(8);
    this.jmx.setVisibility(8);
    this.jmE.setVisibility(8);
    this.jmF.setVisibility(8);
    this.jmD.setVisibility(8);
    this.jmA.setVisibility(8);
    this.jmH.setVisibility(8);
    this.jkZ.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aTX()
      {
        AppMethodBeat.i(128348);
        MobileInputUI.c(MobileInputUI.this);
        AppMethodBeat.o(128348);
      }
    });
    this.jkQ.setOnClickListener(new MobileInputUI.17(this));
    this.jkR.setOnClickListener(new MobileInputUI.18(this));
    Object localObject = new e(this, 1, false);
    ((e)localObject).KJy = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(128351);
        if (paramAnonymousl.fyP())
        {
          paramAnonymousl.jI(5001, 2131766192);
          paramAnonymousl.jI(5002, 2131766189);
        }
        AppMethodBeat.o(128351);
      }
    };
    ((e)localObject).KJz = new MobileInputUI.20(this);
    ((e)localObject).JXC = new e.b()
    {
      public final void onDismiss() {}
    };
    if (ac.fkp())
    {
      this.jkT.setOnClickListener(new MobileInputUI.2(this));
      localObject = new boolean[1];
      localObject[0] = 1;
      this.jmy.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(128336);
          if (paramAnonymousBoolean)
          {
            this.jmQ[0] = true;
            AppMethodBeat.o(128336);
            return;
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.wtJ.atr("ie_reg_eu");
          }
          if (MobileInputUI.f(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.wtJ.atr("ie_login");
          }
          AppMethodBeat.o(128336);
        }
      });
      this.jmy.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128337);
          MobileInputUI.this.jmD.setEnabled(MobileInputUI.this.aUe());
          AppMethodBeat.o(128337);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(128338);
          if (this.jmQ[0] != 0)
          {
            this.jmQ[0] = false;
            if (MobileInputUI.e(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.b.wtJ.atp("ie_reg_eu");
            }
            if (MobileInputUI.f(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.b.wtJ.atp("ie_login");
            }
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.wtJ.atq("ie_reg_eu");
          }
          if (MobileInputUI.f(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.wtJ.atq("ie_login");
          }
          AppMethodBeat.o(128338);
        }
      });
      this.jkK.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128339);
          MobileInputUI.this.jmD.setEnabled(MobileInputUI.this.aUe());
          AppMethodBeat.o(128339);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.jmy.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128340);
          if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
          {
            boolean bool = MobileInputUI.this.aUe();
            AppMethodBeat.o(128340);
            return bool;
          }
          AppMethodBeat.o(128340);
          return false;
        }
      });
      this.jmy.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128341);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.bd(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$16", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            boolean bool = MobileInputUI.this.aUe();
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
      this.jmD.setEnabled(false);
      this.jmD.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(128342);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$17", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/MobileInputUI$17", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(128342);
            return false;
            this.jlX[0] = true;
            if (MobileInputUI.e(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.b.wtJ.io("ce_reg_eu", "<Reg>");
            }
            if (MobileInputUI.f(MobileInputUI.this))
            {
              com.tencent.mm.plugin.normsg.a.b.wtJ.io("ce_login", "<Login>");
              continue;
              if (MobileInputUI.e(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.b.wtJ.a("ce_reg_eu", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.b.wtJ.atu("ce_reg_eu");
              }
              if (MobileInputUI.f(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.b.wtJ.a("ce_login", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.b.wtJ.atu("ce_login");
              }
            }
          }
        }
      });
      this.jmD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128343);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (this.jlX[0] != 0) {
            this.jlX[0] = false;
          }
          for (;;)
          {
            MobileInputUI.g(MobileInputUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128343);
            return;
            if (MobileInputUI.e(MobileInputUI.this))
            {
              com.tencent.mm.plugin.normsg.a.b.wtJ.io("ce_reg_eu", "<Reg>");
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.wtJ.a("ce_reg_eu", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.b.wtJ.atu("ce_reg_eu");
            }
            if (MobileInputUI.f(MobileInputUI.this))
            {
              com.tencent.mm.plugin.normsg.a.b.wtJ.io("ce_login", "<Login>");
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.wtJ.a("ce_login", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.b.wtJ.atu("ce_login");
            }
          }
        }
      });
      if (!bt.isNullOrNil(this.countryCode)) {
        break label941;
      }
      this.iem = getString(2131757952);
      this.countryCode = ba.aQJ(getString(2131757951));
      label707:
      if ((bt.isNullOrNil(this.iem)) || (bt.isNullOrNil(this.countryCode)))
      {
        this.jko = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        ad.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + this.jko);
        if (!bt.isNullOrNil(this.jko)) {
          break label962;
        }
        ad.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
    }
    for (;;)
    {
      aUg();
      if (bt.isNullOrNil(this.jaf)) {
        this.jmy.setText(this.jaf);
      }
      this.jab.setOnClickListener(new MobileInputUI.11(this));
      localObject = "";
      if ((com.tencent.mm.protocal.d.Fnm) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_BLUE)) {
        localObject = getString(2131755822) + com.tencent.mm.cd.g.is(this);
      }
      setMMTitle((String)localObject);
      setActionbarColor(getResources().getColor(2131100705));
      hideActionbarLine();
      AppMethodBeat.o(128362);
      return;
      this.jkS.setVisibility(8);
      this.jkT.setText(2131760754);
      this.jkT.setOnClickListener(new MobileInputUI.3(this, (e)localObject));
      break;
      label941:
      this.iem = com.tencent.mm.ax.b.br(this.countryCode, getString(2131757950));
      break label707;
      label962:
      localObject = com.tencent.mm.ax.b.bq(this.jko, getString(2131757950));
      if (localObject == null)
      {
        ad.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
      else
      {
        this.countryCode = ba.aQJ(((b.a)localObject).iel);
        this.iem = ((b.a)localObject).iem;
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
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(712L, 2L, 1L, false);
        if ((this.jmN instanceof k)) {
          ((k)this.jmN).jmr = 0;
        }
        this.jmN.a(a.jmS);
        AppMethodBeat.o(128368);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(712L, 1L, 1L, false);
      if ((this.jmN instanceof k)) {
        ((k)this.jmN).jmr = 1;
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
        if ((this.jmN instanceof k)) {
          ((k)this.jmN).jmr = 2;
        }
        this.jmN.a(a.jmS);
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
      if ((paramInt2 == -1) && (localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("auth_again")) && ((this.jmN instanceof l))) {
        this.jmN.a(a.jmS);
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
      this.iem = bt.bI(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bt.bI(paramIntent.getStringExtra("couttry_code"), "");
      this.jko = bt.bI(paramIntent.getStringExtra("iso_code"), "");
      if ((this.jmM == 2) && (!com.tencent.mm.ax.b.FV(this.countryCode)))
      {
        paramIntent = new Intent(this, RegByMobileRegAIOUI.class);
        paramIntent.putExtra("couttry_code", this.countryCode);
        paramIntent.putExtra("country_name", this.iem);
        paramIntent.putExtra("iso_code", this.jko);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahp(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(128368);
        return;
      }
      aUg();
      AppMethodBeat.o(128368);
      return;
    } while ((paramInt1 != 1024) || (paramIntent == null));
    localObject1 = paramIntent.getStringExtra("VoiceLoginAuthPwd");
    paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
    boolean bool = bt.isNullOrNil((String)localObject1);
    if (bt.isNullOrNil((String)localObject1)) {}
    for (paramInt1 = i;; paramInt1 = ((String)localObject1).length())
    {
      ad.d("MicroMsg.MobileInputUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break;
      }
      aUf();
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
    this.jmM = getIntent().getIntExtra("mobile_input_purpose", 0);
    this.hGk = getIntent().getIntExtra("mobile_auth_type", 0);
    this.jmO = getIntent().getBooleanExtra("can_finish", false);
    setBackBtn(new MobileInputUI.12(this), 2131689488);
    setActionbarColor(getContext().getResources().getColor(2131100705));
    hideActionbarLine();
    switch (this.jmM)
    {
    case 0: 
    default: 
      ad.e("MicroMsg.MobileInputUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.jmM) });
      finish();
      AppMethodBeat.o(128357);
      return;
    case 1: 
      if (!bt.isNullOrNil(getIntent().getStringExtra("auth_ticket"))) {
        this.jmN = new l();
      }
      break;
    }
    for (;;)
    {
      this.countryCode = ba.aQJ(bt.bI(getIntent().getStringExtra("couttry_code"), ""));
      this.iem = bt.bI(getIntent().getStringExtra("country_name"), "");
      this.jko = bt.nullAsNil(getIntent().getStringExtra("iso_code"));
      this.jaf = bt.bI(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
      this.jmK = ba.aQK(this.countryCode);
      this.jmL = bt.bI(getIntent().getStringExtra("input_mobile_number"), "");
      this.jaZ = com.tencent.mm.plugin.b.a.Mp();
      initView();
      this.jlT = getIntent().getBooleanExtra("from_deep_link", false);
      if ((this.jlT) && (!bt.isNullOrNil(this.jmK)) && (!bt.isNullOrNil(this.jmL))) {
        this.jmx.setText(this.jmL);
      }
      this.jmN.a(this);
      if (com.tencent.mm.sdk.platformtools.i.EX_DEVICE_LOGIN)
      {
        this.jli.setVisibility(0);
        this.jli.setOnClickListener(new MobileInputUI.15(this));
      }
      this.jkt = getIntent().getBooleanExtra("from_switch_account", false);
      com.tencent.mm.cq.d.fSu();
      AppMethodBeat.o(128357);
      return;
      paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
      if (paramBundle != null) {
        this.jlo = paramBundle;
      }
      this.jmN = new i();
      continue;
      this.jmN = new k();
      continue;
      this.jmN = new h();
      continue;
      this.jmN = new j();
      continue;
      this.jmN = new l();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128361);
    if (aUc()) {
      com.tencent.mm.plugin.normsg.a.b.wtJ.atr("ie_reg_eu");
    }
    if (aUd()) {
      com.tencent.mm.plugin.normsg.a.b.wtJ.atr("ie_login");
    }
    if (this.jmz != null) {
      this.jmz.reset();
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
    com.tencent.mm.sdk.b.a.IbL.d(this.jjI);
    this.jmN.stop();
    AppMethodBeat.o(128359);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169142);
    this.jlC.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169142);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128358);
    com.tencent.mm.sdk.b.a.IbL.c(this.jjI);
    super.onResume();
    this.jmN.start();
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
      jmR = new a("GoBack", 0);
      jmS = new a("GoNext", 1);
      jmT = new a[] { jmR, jmS };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI
 * JD-Core Version:    0.7.0.1
 */