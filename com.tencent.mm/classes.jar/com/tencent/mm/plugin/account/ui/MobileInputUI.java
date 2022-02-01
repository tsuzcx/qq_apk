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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;

public class MobileInputUI
  extends MMActivity
{
  protected String countryCode;
  protected int gNs;
  protected String hkO;
  protected LinearLayout igJ;
  protected TextView igL;
  protected String igN;
  protected String ihI;
  protected p ijb;
  protected String iqZ;
  private com.tencent.mm.sdk.b.c iqt;
  protected Button irD;
  protected Button irE;
  private View irF;
  protected Button irG;
  private ResizeLayout irM;
  private Button irV;
  protected boolean irf;
  protected EditText irx;
  protected MMFormInputView isB;
  private MMKeyboardUperView isF;
  protected boolean isG;
  private final int isI;
  protected int[] isb;
  private x isp;
  private b itA;
  protected boolean itB;
  protected MMFormInputView itk;
  protected EditText itl;
  protected MMFormVerifyCodeInputView itm;
  protected View itn;
  protected CheckBox ito;
  protected TextView itp;
  protected Button itq;
  protected TextView itr;
  protected TextView its;
  protected TextView itt;
  protected Button itu;
  protected View itv;
  protected boolean itw;
  protected String itx;
  protected String ity;
  private int itz;
  
  public MobileInputUI()
  {
    AppMethodBeat.i(128356);
    this.itw = true;
    this.itx = null;
    this.ity = null;
    this.igN = null;
    this.hkO = null;
    this.countryCode = null;
    this.iqZ = null;
    this.itz = 0;
    this.isb = new int[5];
    this.isG = false;
    this.iqt = new MobileInputUI.1(this);
    this.isI = 128;
    this.isp = new x();
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
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
    com.tencent.mm.bs.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128369);
  }
  
  private boolean aJZ()
  {
    return this.itz == 2;
  }
  
  private boolean aKa()
  {
    return this.itz == 1;
  }
  
  private void aKc()
  {
    AppMethodBeat.i(128364);
    hideVKB();
    this.isp.b(this, new Runnable()
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
  
  private void aKd()
  {
    AppMethodBeat.i(128367);
    if ((!bt.isNullOrNil(this.hkO)) && (!bt.isNullOrNil(this.countryCode)))
    {
      this.igL.setText(ba.kR(this.hkO, this.countryCode));
      AppMethodBeat.o(128367);
      return;
    }
    this.igL.setText(getString(2131761245));
    AppMethodBeat.o(128367);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128365);
    if (this.itB)
    {
      hideVKB();
      Object localObject = com.tencent.mm.plugin.account.a.a.hYt.bA(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.jI(this);
      AppMethodBeat.o(128365);
      return;
    }
    this.itA.a(a.itE);
    com.tencent.mm.plugin.b.a.aUz(this.ihI);
    hideVKB();
    finish();
    AppMethodBeat.o(128365);
  }
  
  public final boolean aKb()
  {
    AppMethodBeat.i(128363);
    if ((this.itl.getText() != null) && (!bt.isNullOrNil(this.itl.getText().toString())) && (this.itw)) {
      if (this.itz == 2)
      {
        if ((this.irx.getText() != null) && (!bt.isNullOrNil(this.irx.getText().toString())))
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
    com.tencent.mm.plugin.report.service.h.vKh.f(14262, new Object[] { Integer.valueOf(this.isb[0]), Integer.valueOf(this.isb[1]), Integer.valueOf(this.isb[2]), Integer.valueOf(this.isb[3]), Integer.valueOf(this.isb[4]) });
    AppMethodBeat.o(128360);
  }
  
  public int getLayoutId()
  {
    return 2131494923;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128362);
    this.isB = ((MMFormInputView)findViewById(2131304611));
    this.irx = this.isB.getContentEditText();
    com.tencent.mm.ui.tools.b.c.d(this.irx).aaj(16).a(null);
    this.itk = ((MMFormInputView)findViewById(2131302363));
    this.itk.setInputType(3);
    this.itl = this.itk.getContentEditText();
    this.itm = ((MMFormVerifyCodeInputView)findViewById(2131304879));
    this.itm.setInputType(3);
    this.igJ = ((LinearLayout)findViewById(2131298805));
    this.igL = ((TextView)findViewById(2131298807));
    this.itn = findViewById(2131303937);
    this.ito = ((CheckBox)findViewById(2131303944));
    this.itp = ((TextView)findViewById(2131303943));
    this.itq = ((Button)findViewById(2131302852));
    this.itr = ((TextView)findViewById(2131303962));
    this.its = ((TextView)findViewById(2131301582));
    this.itt = ((TextView)findViewById(2131302360));
    this.itu = ((Button)findViewById(2131301569));
    this.irV = ((Button)findViewById(2131301559));
    this.irD = ((Button)findViewById(2131301572));
    this.irE = ((Button)findViewById(2131301574));
    this.irF = findViewById(2131300241);
    this.irG = ((Button)findViewById(2131301575));
    this.itv = findViewById(2131297439);
    this.irM = ((ResizeLayout)findViewById(2131304133));
    this.isF = ((MMKeyboardUperView)findViewById(2131304370));
    this.igJ.setVisibility(8);
    this.isB.setVisibility(8);
    this.itm.setVisibility(8);
    this.itk.setVisibility(8);
    this.itr.setVisibility(8);
    this.its.setVisibility(8);
    this.itq.setVisibility(8);
    this.itn.setVisibility(8);
    this.itu.setVisibility(8);
    this.irM.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aJU()
      {
        AppMethodBeat.i(128348);
        MobileInputUI.c(MobileInputUI.this);
        AppMethodBeat.o(128348);
      }
    });
    this.irD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128349);
        paramAnonymousView = MobileInputUI.this.getString(2131760769) + ac.eFu();
        MobileInputUI.R(MobileInputUI.this, paramAnonymousView);
        AppMethodBeat.o(128349);
      }
    });
    this.irE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128350);
        paramAnonymousView = MobileInputUI.this.getString(2131759660, new Object[] { ac.eFu() });
        MobileInputUI.R(MobileInputUI.this, paramAnonymousView);
        AppMethodBeat.o(128350);
      }
    });
    Object localObject = new e(this, 1, false);
    ((e)localObject).HrX = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(128351);
        if (paramAnonymousl.eSQ())
        {
          paramAnonymousl.jj(5001, 2131766192);
          paramAnonymousl.jj(5002, 2131766189);
        }
        AppMethodBeat.o(128351);
      }
    };
    ((e)localObject).HrY = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(128352);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(128352);
          return;
          MobileInputUI.d(MobileInputUI.this);
          AppMethodBeat.o(128352);
          return;
          MobileInputUI.R(MobileInputUI.this, MobileInputUI.this.getString(2131766190) + ac.eFu());
        }
      }
    };
    ((e)localObject).GHn = new e.b()
    {
      public final void onDismiss() {}
    };
    if (ac.eFr())
    {
      this.irG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128334);
          MobileInputUI.d(MobileInputUI.this);
          AppMethodBeat.o(128334);
        }
      });
      localObject = new boolean[1];
      localObject[0] = 1;
      this.itl.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(128336);
          if (paramAnonymousBoolean)
          {
            this.itD[0] = true;
            AppMethodBeat.o(128336);
            return;
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.ufs.ajt("ie_reg_eu");
          }
          if (MobileInputUI.f(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.ufs.ajt("ie_login");
          }
          AppMethodBeat.o(128336);
        }
      });
      this.itl.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128337);
          MobileInputUI.this.itq.setEnabled(MobileInputUI.this.aKb());
          AppMethodBeat.o(128337);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(128338);
          if (this.itD[0] != 0)
          {
            this.itD[0] = false;
            if (MobileInputUI.e(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.b.ufs.ajr("ie_reg_eu");
            }
            if (MobileInputUI.f(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.b.ufs.ajr("ie_login");
            }
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.ufs.ajs("ie_reg_eu");
          }
          if (MobileInputUI.f(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.ufs.ajs("ie_login");
          }
          AppMethodBeat.o(128338);
        }
      });
      this.irx.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128339);
          MobileInputUI.this.itq.setEnabled(MobileInputUI.this.aKb());
          AppMethodBeat.o(128339);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.itl.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128340);
          if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
          {
            boolean bool = MobileInputUI.this.aKb();
            AppMethodBeat.o(128340);
            return bool;
          }
          AppMethodBeat.o(128340);
          return false;
        }
      });
      this.itl.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128341);
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            boolean bool = MobileInputUI.this.aKb();
            AppMethodBeat.o(128341);
            return bool;
          }
          AppMethodBeat.o(128341);
          return false;
        }
      });
      localObject = new boolean[1];
      localObject[0] = 0;
      this.itq.setEnabled(false);
      this.itq.setOnTouchListener(new View.OnTouchListener()
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
            this.isK[0] = true;
            if (MobileInputUI.e(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.b.ufs.hK("ce_reg_eu", "<Reg>");
            }
            if (MobileInputUI.f(MobileInputUI.this))
            {
              com.tencent.mm.plugin.normsg.a.b.ufs.hK("ce_login", "<Login>");
              continue;
              if (MobileInputUI.e(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.b.ufs.a("ce_reg_eu", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.b.ufs.ajw("ce_reg_eu");
              }
              if (MobileInputUI.f(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.b.ufs.a("ce_login", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.b.ufs.ajw("ce_login");
              }
            }
          }
        }
      });
      this.itq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128343);
          if (this.isK[0] != 0) {
            this.isK[0] = false;
          }
          for (;;)
          {
            MobileInputUI.g(MobileInputUI.this);
            AppMethodBeat.o(128343);
            return;
            if (MobileInputUI.e(MobileInputUI.this))
            {
              com.tencent.mm.plugin.normsg.a.b.ufs.hK("ce_reg_eu", "<Reg>");
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.ufs.a("ce_reg_eu", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.b.ufs.ajw("ce_reg_eu");
            }
            if (MobileInputUI.f(MobileInputUI.this))
            {
              com.tencent.mm.plugin.normsg.a.b.ufs.hK("ce_login", "<Login>");
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.ufs.a("ce_login", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.b.ufs.ajw("ce_login");
            }
          }
        }
      });
      if (!bt.isNullOrNil(this.countryCode)) {
        break label938;
      }
      this.hkO = getString(2131757952);
      this.countryCode = ba.aFM(getString(2131757951));
      label707:
      if ((bt.isNullOrNil(this.hkO)) || (bt.isNullOrNil(this.countryCode)))
      {
        this.iqZ = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        ad.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + this.iqZ);
        if (!bt.isNullOrNil(this.iqZ)) {
          break label959;
        }
        ad.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
    }
    for (;;)
    {
      aKd();
      if (bt.isNullOrNil(this.igN)) {
        this.itl.setText(this.igN);
      }
      this.igJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128344);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", MobileInputUI.this.hkO);
          paramAnonymousView.putExtra("couttry_code", MobileInputUI.this.countryCode);
          paramAnonymousView.putExtra("iso_code", MobileInputUI.this.iqZ);
          com.tencent.mm.plugin.account.a.a.hYt.b(paramAnonymousView, MobileInputUI.this);
          AppMethodBeat.o(128344);
        }
      });
      localObject = "";
      if (com.tencent.mm.protocal.d.CpN) {
        localObject = getString(2131755822) + getString(2131755263);
      }
      setMMTitle((String)localObject);
      setActionbarColor(getResources().getColor(2131100705));
      hideActionbarLine();
      AppMethodBeat.o(128362);
      return;
      this.irF.setVisibility(8);
      this.irG.setText(2131760754);
      this.irG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128335);
          this.ise.csG();
          AppMethodBeat.o(128335);
        }
      });
      break;
      label938:
      this.hkO = com.tencent.mm.ax.b.bi(this.countryCode, getString(2131757950));
      break label707;
      label959:
      localObject = com.tencent.mm.ax.b.bh(this.iqZ, getString(2131757950));
      if (localObject == null)
      {
        ad.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
      else
      {
        this.countryCode = ba.aFM(((b.a)localObject).hkN);
        this.hkO = ((b.a)localObject).hkO;
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
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(712L, 2L, 1L, false);
        if ((this.itA instanceof k)) {
          ((k)this.itA).ite = 0;
        }
        this.itA.a(a.itF);
        AppMethodBeat.o(128368);
        return;
      }
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(712L, 1L, 1L, false);
      if ((this.itA instanceof k)) {
        ((k)this.itA).ite = 1;
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
        if ((this.itA instanceof k)) {
          ((k)this.itA).ite = 2;
        }
        this.itA.a(a.itF);
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
      if ((paramInt2 == -1) && (localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("auth_again")) && ((this.itA instanceof l))) {
        this.itA.a(a.itF);
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
      this.hkO = bt.by(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bt.by(paramIntent.getStringExtra("couttry_code"), "");
      this.iqZ = bt.by(paramIntent.getStringExtra("iso_code"), "");
      if ((this.itz == 2) && (!com.tencent.mm.ax.b.yM(this.countryCode)))
      {
        paramIntent = new Intent(this, RegByMobileRegAIOUI.class);
        paramIntent.putExtra("couttry_code", this.countryCode);
        paramIntent.putExtra("country_name", this.hkO);
        paramIntent.putExtra("iso_code", this.iqZ);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.adn(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(128368);
        return;
      }
      aKd();
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
      aKc();
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
    this.itz = getIntent().getIntExtra("mobile_input_purpose", 0);
    this.gNs = getIntent().getIntExtra("mobile_auth_type", 0);
    this.itB = getIntent().getBooleanExtra("can_finish", false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(128345);
        MobileInputUI.b(MobileInputUI.this);
        AppMethodBeat.o(128345);
        return true;
      }
    }, 2131689488);
    setActionbarColor(getContext().getResources().getColor(2131100705));
    hideActionbarLine();
    switch (this.itz)
    {
    case 0: 
    default: 
      ad.e("MicroMsg.MobileInputUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.itz) });
      finish();
      AppMethodBeat.o(128357);
      return;
    case 1: 
      if (!bt.isNullOrNil(getIntent().getStringExtra("auth_ticket"))) {
        this.itA = new l();
      }
      break;
    }
    for (;;)
    {
      this.countryCode = ba.aFM(bt.by(getIntent().getStringExtra("couttry_code"), ""));
      this.hkO = bt.by(getIntent().getStringExtra("country_name"), "");
      this.iqZ = bt.nullAsNil(getIntent().getStringExtra("iso_code"));
      this.igN = bt.by(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
      this.itx = ba.aFN(this.countryCode);
      this.ity = bt.by(getIntent().getStringExtra("input_mobile_number"), "");
      this.ihI = com.tencent.mm.plugin.b.a.fQQ();
      initView();
      this.isG = getIntent().getBooleanExtra("from_deep_link", false);
      if ((this.isG) && (!bt.isNullOrNil(this.itx)) && (!bt.isNullOrNil(this.ity))) {
        this.itk.setText(this.ity);
      }
      this.itA.a(this);
      if (com.tencent.mm.sdk.platformtools.h.EX_DEVICE_LOGIN)
      {
        this.irV.setVisibility(0);
        this.irV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(128347);
            com.tencent.mm.bs.d.O(MobileInputUI.this, "login_exdevice", ".ui.LoginAsExDeviceUI");
            MobileInputUI.this.overridePendingTransition(2130772105, 2130771986);
            AppMethodBeat.o(128347);
          }
        });
      }
      this.irf = getIntent().getBooleanExtra("from_switch_account", false);
      AppMethodBeat.o(128357);
      return;
      paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
      if (paramBundle != null) {
        this.isb = paramBundle;
      }
      this.itA = new i();
      continue;
      this.itA = new k();
      continue;
      this.itA = new h();
      continue;
      this.itA = new j();
      continue;
      this.itA = new l();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128361);
    if (aJZ()) {
      com.tencent.mm.plugin.normsg.a.b.ufs.ajt("ie_reg_eu");
    }
    if (aKa()) {
      com.tencent.mm.plugin.normsg.a.b.ufs.ajt("ie_login");
    }
    if (this.itm != null) {
      this.itm.reset();
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
    com.tencent.mm.sdk.b.a.ESL.d(this.iqt);
    this.itA.stop();
    AppMethodBeat.o(128359);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169142);
    this.isp.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169142);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128358);
    com.tencent.mm.sdk.b.a.ESL.c(this.iqt);
    super.onResume();
    this.itA.start();
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
      itE = new a("GoBack", 0);
      itF = new a("GoNext", 1);
      itG = new a[] { itE, itF };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI
 * JD-Core Version:    0.7.0.1
 */