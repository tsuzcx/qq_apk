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
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bs;
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
  protected String hLr;
  protected int hnS;
  protected LinearLayout iGS;
  protected TextView iGU;
  protected String iGW;
  protected String iHQ;
  protected p iJi;
  private com.tencent.mm.sdk.b.c iQA;
  protected EditText iRC;
  protected Button iRI;
  protected Button iRJ;
  private View iRK;
  protected Button iRL;
  private ResizeLayout iRR;
  protected String iRg;
  protected boolean iRl;
  protected MMFormInputView iSG;
  private MMKeyboardUperView iSK;
  protected boolean iSL;
  private final int iSN;
  private Button iSa;
  protected int[] iSg;
  private x iSu;
  protected View iTA;
  protected boolean iTB;
  protected String iTC;
  protected String iTD;
  private int iTE;
  private b iTF;
  protected boolean iTG;
  protected MMFormInputView iTp;
  protected EditText iTq;
  protected MMFormVerifyCodeInputView iTr;
  protected View iTs;
  protected CheckBox iTt;
  protected TextView iTu;
  protected Button iTv;
  protected TextView iTw;
  protected TextView iTx;
  protected TextView iTy;
  protected Button iTz;
  
  public MobileInputUI()
  {
    AppMethodBeat.i(128356);
    this.iTB = true;
    this.iTC = null;
    this.iTD = null;
    this.iGW = null;
    this.hLr = null;
    this.countryCode = null;
    this.iRg = null;
    this.iTE = 0;
    this.iSg = new int[5];
    this.iSL = false;
    this.iQA = new MobileInputUI.1(this);
    this.iSN = 128;
    this.iSu = new x();
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
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
    com.tencent.mm.br.d.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128369);
  }
  
  private boolean aQQ()
  {
    return this.iTE == 2;
  }
  
  private boolean aQR()
  {
    return this.iTE == 1;
  }
  
  private void aQT()
  {
    AppMethodBeat.i(128364);
    hideVKB();
    this.iSu.b(this, new Runnable()
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
  
  private void aQU()
  {
    AppMethodBeat.i(128367);
    if ((!bs.isNullOrNil(this.hLr)) && (!bs.isNullOrNil(this.countryCode)))
    {
      this.iGU.setText(az.lo(this.hLr, this.countryCode));
      AppMethodBeat.o(128367);
      return;
    }
    this.iGU.setText(getString(2131761245));
    AppMethodBeat.o(128367);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128365);
    if (this.iTG)
    {
      hideVKB();
      Object localObject = com.tencent.mm.plugin.account.a.a.iyx.bD(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.jT(this);
      AppMethodBeat.o(128365);
      return;
    }
    this.iTF.a(a.iTJ);
    com.tencent.mm.plugin.b.a.IL(this.iHQ);
    hideVKB();
    finish();
    AppMethodBeat.o(128365);
  }
  
  public final boolean aQS()
  {
    AppMethodBeat.i(128363);
    if ((this.iTq.getText() != null) && (!bs.isNullOrNil(this.iTq.getText().toString())) && (this.iTB)) {
      if (this.iTE == 2)
      {
        if ((this.iRC.getText() != null) && (!bs.isNullOrNil(this.iRC.getText().toString())))
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
    com.tencent.mm.plugin.report.service.h.wUl.f(14262, new Object[] { Integer.valueOf(this.iSg[0]), Integer.valueOf(this.iSg[1]), Integer.valueOf(this.iSg[2]), Integer.valueOf(this.iSg[3]), Integer.valueOf(this.iSg[4]) });
    AppMethodBeat.o(128360);
  }
  
  public int getLayoutId()
  {
    return 2131494923;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128362);
    this.iSG = ((MMFormInputView)findViewById(2131304611));
    this.iRC = this.iSG.getContentEditText();
    com.tencent.mm.ui.tools.b.c.d(this.iRC).acw(16).a(null);
    this.iTp = ((MMFormInputView)findViewById(2131302363));
    this.iTp.setInputType(3);
    this.iTq = this.iTp.getContentEditText();
    this.iTr = ((MMFormVerifyCodeInputView)findViewById(2131304879));
    this.iTr.setInputType(3);
    this.iGS = ((LinearLayout)findViewById(2131298805));
    this.iGU = ((TextView)findViewById(2131298807));
    this.iTs = findViewById(2131303937);
    this.iTt = ((CheckBox)findViewById(2131303944));
    this.iTu = ((TextView)findViewById(2131303943));
    this.iTv = ((Button)findViewById(2131302852));
    this.iTw = ((TextView)findViewById(2131303962));
    this.iTx = ((TextView)findViewById(2131301582));
    this.iTy = ((TextView)findViewById(2131302360));
    this.iTz = ((Button)findViewById(2131301569));
    this.iSa = ((Button)findViewById(2131301559));
    this.iRI = ((Button)findViewById(2131301572));
    this.iRJ = ((Button)findViewById(2131301574));
    this.iRK = findViewById(2131300241);
    this.iRL = ((Button)findViewById(2131301575));
    this.iTA = findViewById(2131297439);
    this.iRR = ((ResizeLayout)findViewById(2131304133));
    this.iSK = ((MMKeyboardUperView)findViewById(2131304370));
    this.iGS.setVisibility(8);
    this.iSG.setVisibility(8);
    this.iTr.setVisibility(8);
    this.iTp.setVisibility(8);
    this.iTw.setVisibility(8);
    this.iTx.setVisibility(8);
    this.iTv.setVisibility(8);
    this.iTs.setVisibility(8);
    this.iTz.setVisibility(8);
    this.iRR.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aQL()
      {
        AppMethodBeat.i(128348);
        MobileInputUI.c(MobileInputUI.this);
        AppMethodBeat.o(128348);
      }
    });
    this.iRI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128349);
        paramAnonymousView = MobileInputUI.this.getString(2131760769) + ab.eUO();
        MobileInputUI.S(MobileInputUI.this, paramAnonymousView);
        AppMethodBeat.o(128349);
      }
    });
    this.iRJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128350);
        paramAnonymousView = MobileInputUI.this.getString(2131759660, new Object[] { ab.eUO() });
        MobileInputUI.S(MobileInputUI.this, paramAnonymousView);
        AppMethodBeat.o(128350);
      }
    });
    Object localObject = new e(this, 1, false);
    ((e)localObject).ISu = new MobileInputUI.19(this);
    ((e)localObject).ISv = new n.d()
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
          MobileInputUI.S(MobileInputUI.this, MobileInputUI.this.getString(2131766190) + ab.eUO());
        }
      }
    };
    ((e)localObject).Ihj = new e.b()
    {
      public final void onDismiss() {}
    };
    if (ab.eUL())
    {
      this.iRL.setOnClickListener(new View.OnClickListener()
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
      this.iTq.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(128336);
          if (paramAnonymousBoolean)
          {
            this.iTI[0] = true;
            AppMethodBeat.o(128336);
            return;
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.vor.aor("ie_reg_eu");
          }
          if (MobileInputUI.f(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.vor.aor("ie_login");
          }
          AppMethodBeat.o(128336);
        }
      });
      this.iTq.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128337);
          MobileInputUI.this.iTv.setEnabled(MobileInputUI.this.aQS());
          AppMethodBeat.o(128337);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(128338);
          if (this.iTI[0] != 0)
          {
            this.iTI[0] = false;
            if (MobileInputUI.e(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.b.vor.aop("ie_reg_eu");
            }
            if (MobileInputUI.f(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.b.vor.aop("ie_login");
            }
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.vor.aoq("ie_reg_eu");
          }
          if (MobileInputUI.f(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.b.vor.aoq("ie_login");
          }
          AppMethodBeat.o(128338);
        }
      });
      this.iRC.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128339);
          MobileInputUI.this.iTv.setEnabled(MobileInputUI.this.aQS());
          AppMethodBeat.o(128339);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.iTq.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128340);
          if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
          {
            boolean bool = MobileInputUI.this.aQS();
            AppMethodBeat.o(128340);
            return bool;
          }
          AppMethodBeat.o(128340);
          return false;
        }
      });
      this.iTq.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128341);
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            boolean bool = MobileInputUI.this.aQS();
            AppMethodBeat.o(128341);
            return bool;
          }
          AppMethodBeat.o(128341);
          return false;
        }
      });
      localObject = new boolean[1];
      localObject[0] = 0;
      this.iTv.setEnabled(false);
      this.iTv.setOnTouchListener(new View.OnTouchListener()
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
            this.iSP[0] = true;
            if (MobileInputUI.e(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.b.vor.id("ce_reg_eu", "<Reg>");
            }
            if (MobileInputUI.f(MobileInputUI.this))
            {
              com.tencent.mm.plugin.normsg.a.b.vor.id("ce_login", "<Login>");
              continue;
              if (MobileInputUI.e(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.b.vor.a("ce_reg_eu", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.b.vor.aou("ce_reg_eu");
              }
              if (MobileInputUI.f(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.b.vor.a("ce_login", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.b.vor.aou("ce_login");
              }
            }
          }
        }
      });
      this.iTv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128343);
          if (this.iSP[0] != 0) {
            this.iSP[0] = false;
          }
          for (;;)
          {
            MobileInputUI.g(MobileInputUI.this);
            AppMethodBeat.o(128343);
            return;
            if (MobileInputUI.e(MobileInputUI.this))
            {
              com.tencent.mm.plugin.normsg.a.b.vor.id("ce_reg_eu", "<Reg>");
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.vor.a("ce_reg_eu", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.b.vor.aou("ce_reg_eu");
            }
            if (MobileInputUI.f(MobileInputUI.this))
            {
              com.tencent.mm.plugin.normsg.a.b.vor.id("ce_login", "<Login>");
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.b.vor.a("ce_login", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.b.vor.aou("ce_login");
            }
          }
        }
      });
      if (!bs.isNullOrNil(this.countryCode)) {
        break label938;
      }
      this.hLr = getString(2131757952);
      this.countryCode = az.aLd(getString(2131757951));
      label707:
      if ((bs.isNullOrNil(this.hLr)) || (bs.isNullOrNil(this.countryCode)))
      {
        this.iRg = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        ac.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + this.iRg);
        if (!bs.isNullOrNil(this.iRg)) {
          break label959;
        }
        ac.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
    }
    for (;;)
    {
      aQU();
      if (bs.isNullOrNil(this.iGW)) {
        this.iTq.setText(this.iGW);
      }
      this.iGS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128344);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", MobileInputUI.this.hLr);
          paramAnonymousView.putExtra("couttry_code", MobileInputUI.this.countryCode);
          paramAnonymousView.putExtra("iso_code", MobileInputUI.this.iRg);
          com.tencent.mm.plugin.account.a.a.iyx.b(paramAnonymousView, MobileInputUI.this);
          AppMethodBeat.o(128344);
        }
      });
      localObject = "";
      if (com.tencent.mm.protocal.d.DIf) {
        localObject = getString(2131755822) + getString(2131755263);
      }
      setMMTitle((String)localObject);
      setActionbarColor(getResources().getColor(2131100705));
      hideActionbarLine();
      AppMethodBeat.o(128362);
      return;
      this.iRK.setVisibility(8);
      this.iRL.setText(2131760754);
      this.iRL.setOnClickListener(new MobileInputUI.3(this, (e)localObject));
      break;
      label938:
      this.hLr = com.tencent.mm.aw.b.bq(this.countryCode, getString(2131757950));
      break label707;
      label959:
      localObject = com.tencent.mm.aw.b.bp(this.iRg, getString(2131757950));
      if (localObject == null)
      {
        ac.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
      else
      {
        this.countryCode = az.aLd(((b.a)localObject).hLq);
        this.hLr = ((b.a)localObject).hLr;
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
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(712L, 2L, 1L, false);
        if ((this.iTF instanceof k)) {
          ((k)this.iTF).iTj = 0;
        }
        this.iTF.a(a.iTK);
        AppMethodBeat.o(128368);
        return;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(712L, 1L, 1L, false);
      if ((this.iTF instanceof k)) {
        ((k)this.iTF).iTj = 1;
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
        if ((this.iTF instanceof k)) {
          ((k)this.iTF).iTj = 2;
        }
        this.iTF.a(a.iTK);
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
      if ((paramInt2 == -1) && (localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("auth_again")) && ((this.iTF instanceof l))) {
        this.iTF.a(a.iTK);
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
      this.hLr = bs.bG(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = bs.bG(paramIntent.getStringExtra("couttry_code"), "");
      this.iRg = bs.bG(paramIntent.getStringExtra("iso_code"), "");
      if ((this.iTE == 2) && (!com.tencent.mm.aw.b.CR(this.countryCode)))
      {
        paramIntent = new Intent(this, RegByMobileRegAIOUI.class);
        paramIntent.putExtra("couttry_code", this.countryCode);
        paramIntent.putExtra("country_name", this.hLr);
        paramIntent.putExtra("iso_code", this.iRg);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(128368);
        return;
      }
      aQU();
      AppMethodBeat.o(128368);
      return;
    } while ((paramInt1 != 1024) || (paramIntent == null));
    localObject1 = paramIntent.getStringExtra("VoiceLoginAuthPwd");
    paramInt2 = paramIntent.getIntExtra("KVoiceHelpCode", 0);
    boolean bool = bs.isNullOrNil((String)localObject1);
    if (bs.isNullOrNil((String)localObject1)) {}
    for (paramInt1 = i;; paramInt1 = ((String)localObject1).length())
    {
      ac.d("MicroMsg.MobileInputUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt2 != -217) {
        break;
      }
      aQT();
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
    this.iTE = getIntent().getIntExtra("mobile_input_purpose", 0);
    this.hnS = getIntent().getIntExtra("mobile_auth_type", 0);
    this.iTG = getIntent().getBooleanExtra("can_finish", false);
    setBackBtn(new MobileInputUI.12(this), 2131689488);
    setActionbarColor(getContext().getResources().getColor(2131100705));
    hideActionbarLine();
    switch (this.iTE)
    {
    case 0: 
    default: 
      ac.e("MicroMsg.MobileInputUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.iTE) });
      finish();
      AppMethodBeat.o(128357);
      return;
    case 1: 
      if (!bs.isNullOrNil(getIntent().getStringExtra("auth_ticket"))) {
        this.iTF = new l();
      }
      break;
    }
    for (;;)
    {
      this.countryCode = az.aLd(bs.bG(getIntent().getStringExtra("couttry_code"), ""));
      this.hLr = bs.bG(getIntent().getStringExtra("country_name"), "");
      this.iRg = bs.nullAsNil(getIntent().getStringExtra("iso_code"));
      this.iGW = bs.bG(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
      this.iTC = az.aLe(this.countryCode);
      this.iTD = bs.bG(getIntent().getStringExtra("input_mobile_number"), "");
      this.iHQ = com.tencent.mm.plugin.b.a.EL();
      initView();
      this.iSL = getIntent().getBooleanExtra("from_deep_link", false);
      if ((this.iSL) && (!bs.isNullOrNil(this.iTC)) && (!bs.isNullOrNil(this.iTD))) {
        this.iTp.setText(this.iTD);
      }
      this.iTF.a(this);
      if (com.tencent.mm.sdk.platformtools.h.EX_DEVICE_LOGIN)
      {
        this.iSa.setVisibility(0);
        this.iSa.setOnClickListener(new MobileInputUI.15(this));
      }
      this.iRl = getIntent().getBooleanExtra("from_switch_account", false);
      AppMethodBeat.o(128357);
      return;
      paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
      if (paramBundle != null) {
        this.iSg = paramBundle;
      }
      this.iTF = new i();
      continue;
      this.iTF = new k();
      continue;
      this.iTF = new h();
      continue;
      this.iTF = new j();
      continue;
      this.iTF = new l();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128361);
    if (aQQ()) {
      com.tencent.mm.plugin.normsg.a.b.vor.aor("ie_reg_eu");
    }
    if (aQR()) {
      com.tencent.mm.plugin.normsg.a.b.vor.aor("ie_login");
    }
    if (this.iTr != null) {
      this.iTr.reset();
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
    com.tencent.mm.sdk.b.a.GpY.d(this.iQA);
    this.iTF.stop();
    AppMethodBeat.o(128359);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169142);
    this.iSu.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169142);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128358);
    com.tencent.mm.sdk.b.a.GpY.c(this.iQA);
    super.onResume();
    this.iTF.start();
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
      iTJ = new a("GoBack", 0);
      iTK = new a("GoNext", 1);
      iTL = new a[] { iTJ, iTK };
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