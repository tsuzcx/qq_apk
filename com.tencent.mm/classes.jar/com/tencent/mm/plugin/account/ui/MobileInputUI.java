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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;

public class MobileInputUI
  extends MMActivity
{
  protected String countryCode;
  protected int iDM;
  protected String jbZ;
  protected LinearLayout kaX;
  protected TextView kaZ;
  protected String kbV;
  protected String kbb;
  protected q kdn;
  private IListener kkK;
  protected EditText klM;
  protected Button klS;
  protected Button klT;
  private View klU;
  protected Button klV;
  protected String klq;
  protected boolean klv;
  private x kmF;
  protected MMFormInputView kmS;
  private MMKeyboardUperView kmW;
  protected boolean kmX;
  private final int kmZ;
  private ResizeLayout kmb;
  private Button kml;
  protected int[] kmr;
  protected MMFormInputView knB;
  protected EditText knC;
  protected MMFormVerifyCodeInputView knD;
  protected View knE;
  protected CheckBox knF;
  protected TextView knG;
  protected Button knH;
  protected TextView knI;
  protected TextView knJ;
  protected TextView knK;
  protected Button knL;
  protected View knM;
  protected boolean knN;
  protected String knO;
  protected String knP;
  private int knQ;
  private b knR;
  protected boolean knS;
  private String knT;
  private String knU;
  
  public MobileInputUI()
  {
    AppMethodBeat.i(128356);
    this.knN = true;
    this.knO = null;
    this.knP = null;
    this.kbb = null;
    this.jbZ = null;
    this.countryCode = null;
    this.klq = null;
    this.knQ = 0;
    this.kmr = new int[5];
    this.kmX = false;
    this.knT = "";
    this.knU = "";
    this.kkK = new MobileInputUI.1(this);
    this.kmZ = 128;
    this.kmF = new x();
    AppMethodBeat.o(128356);
  }
  
  private static void Y(Context paramContext, String paramString)
  {
    AppMethodBeat.i(128369);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
    com.tencent.mm.br.c.b(paramContext, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(128369);
  }
  
  private boolean bpo()
  {
    return this.knQ == 2;
  }
  
  private boolean bpp()
  {
    return (this.iDM == 7) || (this.iDM == 6);
  }
  
  private void bpr()
  {
    AppMethodBeat.i(128364);
    hideVKB();
    this.kmF.b(this, new Runnable()
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
  
  private void bps()
  {
    AppMethodBeat.i(128367);
    if ((!Util.isNullOrNil(this.jbZ)) && (!Util.isNullOrNil(this.countryCode)))
    {
      this.kaZ.setText(PhoneFormater.countryNameWithCode(this.jbZ, this.countryCode));
      AppMethodBeat.o(128367);
      return;
    }
    this.kaZ.setText(getString(2131763071));
    AppMethodBeat.o(128367);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128365);
    if (this.knS)
    {
      hideVKB();
      Object localObject = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.kd(this);
      AppMethodBeat.o(128365);
      return;
    }
    this.knR.a(a.knX);
    com.tencent.mm.plugin.b.a.bwV(this.kbV);
    hideVKB();
    finish();
    AppMethodBeat.o(128365);
  }
  
  public final boolean bpq()
  {
    AppMethodBeat.i(128363);
    if ((this.knC.getText() != null) && (!Util.isNullOrNil(this.knC.getText().toString())) && (this.knN)) {
      if (this.knQ == 2)
      {
        if ((this.klM.getText() != null) && (!Util.isNullOrNil(this.klM.getText().toString())))
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
    com.tencent.mm.plugin.report.service.h.CyF.a(14262, new Object[] { Integer.valueOf(this.kmr[0]), Integer.valueOf(this.kmr[1]), Integer.valueOf(this.kmr[2]), Integer.valueOf(this.kmr[3]), Integer.valueOf(this.kmr[4]) });
    AppMethodBeat.o(128360);
  }
  
  public int getLayoutId()
  {
    return 2131495663;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128362);
    this.kmS = ((MMFormInputView)findViewById(2131307663));
    this.klM = this.kmS.getContentEditText();
    com.tencent.mm.ui.tools.b.c.f(this.klM).aoq(16).a(null);
    this.knB = ((MMFormInputView)findViewById(2131304760));
    this.knB.setInputType(3);
    this.knC = this.knB.getContentEditText();
    this.knD = ((MMFormVerifyCodeInputView)findViewById(2131307965));
    this.knD.setInputType(3);
    this.kaX = ((LinearLayout)findViewById(2131299269));
    this.kaZ = ((TextView)findViewById(2131299271));
    this.knE = findViewById(2131306791);
    this.knF = ((CheckBox)findViewById(2131306798));
    this.knG = ((TextView)findViewById(2131306797));
    this.knH = ((Button)findViewById(2131305423));
    this.knI = ((TextView)findViewById(2131306816));
    this.knJ = ((TextView)findViewById(2131303812));
    this.knK = ((TextView)findViewById(2131304757));
    this.knL = ((Button)findViewById(2131303791));
    this.kml = ((Button)findViewById(2131303779));
    this.klS = ((Button)findViewById(2131303796));
    this.klT = ((Button)findViewById(2131303798));
    this.klU = findViewById(2131301720);
    this.klV = ((Button)findViewById(2131303803));
    this.knM = findViewById(2131297668);
    this.kmb = ((ResizeLayout)findViewById(2131307029));
    this.kmW = ((MMKeyboardUperView)findViewById(2131307332));
    this.kaX.setVisibility(8);
    this.kmS.setVisibility(8);
    this.knD.setVisibility(8);
    this.knB.setVisibility(8);
    this.knI.setVisibility(8);
    this.knJ.setVisibility(8);
    this.knH.setVisibility(8);
    this.knE.setVisibility(8);
    this.knL.setVisibility(8);
    this.kmb.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void bpj()
      {
        AppMethodBeat.i(128348);
        MobileInputUI.c(MobileInputUI.this);
        AppMethodBeat.o(128348);
      }
    });
    this.klS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128349);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = MobileInputUI.this.getString(2131762519) + LocaleUtil.getApplicationLanguage();
        MobileInputUI.Z(MobileInputUI.this, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128349);
      }
    });
    this.klT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128350);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = MobileInputUI.this.getString(2131760981, new Object[] { LocaleUtil.getApplicationLanguage() });
        MobileInputUI.Z(MobileInputUI.this, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128350);
      }
    });
    Object localObject = new e(this, 1, false);
    ((e)localObject).HLX = new o.f()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
      {
        AppMethodBeat.i(128351);
        if (paramAnonymousm.gKQ())
        {
          paramAnonymousm.kV(5001, 2131768668);
          paramAnonymousm.kV(5002, 2131768665);
        }
        AppMethodBeat.o(128351);
      }
    };
    ((e)localObject).HLY = new o.g()
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
          MobileInputUI.Z(MobileInputUI.this, MobileInputUI.this.getString(2131768666) + LocaleUtil.getApplicationLanguage());
        }
      }
    };
    ((e)localObject).PGl = new e.b()
    {
      public final void onDismiss() {}
    };
    if (LocaleUtil.isSimplifiedChineseAppLang())
    {
      this.klV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128334);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          MobileInputUI.d(MobileInputUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128334);
        }
      });
      localObject = new boolean[1];
      localObject[0] = 1;
      this.knC.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(128336);
          if (paramAnonymousBoolean)
          {
            this.knW[0] = true;
            AppMethodBeat.o(128336);
            return;
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_reg_eu");
          }
          if (MobileInputUI.f(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_login");
          }
          AppMethodBeat.o(128336);
        }
      });
      this.knC.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128337);
          MobileInputUI.this.knH.setEnabled(MobileInputUI.this.bpq());
          AppMethodBeat.o(128337);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(128338);
          if (this.knW[0] != 0)
          {
            this.knW[0] = false;
            if (MobileInputUI.e(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.d.AEF.aIL("ie_reg_eu");
            }
            if (MobileInputUI.f(MobileInputUI.this)) {
              com.tencent.mm.plugin.normsg.a.d.AEF.aIL("ie_login");
            }
          }
          if (MobileInputUI.e(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.d.AEF.aIM("ie_reg_eu");
          }
          if (MobileInputUI.f(MobileInputUI.this)) {
            com.tencent.mm.plugin.normsg.a.d.AEF.aIM("ie_login");
          }
          AppMethodBeat.o(128338);
        }
      });
      this.klM.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(128339);
          MobileInputUI.this.knH.setEnabled(MobileInputUI.this.bpq());
          AppMethodBeat.o(128339);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.knC.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128340);
          if ((paramAnonymousInt == 6) || (paramAnonymousInt == 5))
          {
            boolean bool = MobileInputUI.this.bpq();
            AppMethodBeat.o(128340);
            return bool;
          }
          AppMethodBeat.o(128340);
          return false;
        }
      });
      this.knC.setOnKeyListener(new View.OnKeyListener()
      {
        public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          AppMethodBeat.i(128341);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.bm(paramAnonymousKeyEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$16", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
          if ((66 == paramAnonymousInt) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            boolean bool = MobileInputUI.this.bpq();
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
      this.knH.setEnabled(false);
      this.knH.setOnTouchListener(new View.OnTouchListener()
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
            this.kmH[0] = true;
            if (MobileInputUI.e(MobileInputUI.this))
            {
              MobileInputUI.a(MobileInputUI.this, com.tencent.mm.plugin.normsg.a.c.TN(1));
              com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_reg", "<Reg>", MobileInputUI.g(MobileInputUI.this));
            }
            if (MobileInputUI.f(MobileInputUI.this))
            {
              MobileInputUI.b(MobileInputUI.this, com.tencent.mm.plugin.normsg.a.c.TN(2));
              com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_login_id", "<Login>", MobileInputUI.h(MobileInputUI.this));
              continue;
              if (MobileInputUI.e(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_reg", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_reg");
              }
              if (MobileInputUI.f(MobileInputUI.this))
              {
                com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_login_id", paramAnonymousMotionEvent);
                com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_login_id");
              }
            }
          }
        }
      });
      this.knH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128343);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (this.kmH[0] != 0) {
            this.kmH[0] = false;
          }
          for (;;)
          {
            MobileInputUI.i(MobileInputUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(128343);
            return;
            if (MobileInputUI.e(MobileInputUI.this))
            {
              MobileInputUI.a(MobileInputUI.this, com.tencent.mm.plugin.normsg.a.c.TN(1));
              com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_reg", "<Reg>", MobileInputUI.g(MobileInputUI.this));
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_reg", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_reg");
            }
            if (MobileInputUI.f(MobileInputUI.this))
            {
              MobileInputUI.b(MobileInputUI.this, com.tencent.mm.plugin.normsg.a.c.TN(2));
              com.tencent.mm.plugin.normsg.a.d.AEF.aA("ce_login_id", "<Login>", MobileInputUI.h(MobileInputUI.this));
              paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
              com.tencent.mm.plugin.normsg.a.d.AEF.a("ce_login_id", paramAnonymousView);
              com.tencent.mm.plugin.normsg.a.d.AEF.aIQ("ce_login_id");
            }
          }
        }
      });
      if (WeChatSomeFeatureSwitch.onlyUSMobile())
      {
        this.countryCode = "1";
        this.jbZ = com.tencent.mm.aw.b.bt(this.countryCode, getString(2131758198));
      }
      if (!Util.isNullOrNil(this.countryCode)) {
        break label989;
      }
      this.jbZ = getString(2131758200);
      this.countryCode = PhoneFormater.pureCountryCode(getString(2131758199));
      label738:
      if ((Util.isNullOrNil(this.jbZ)) || (Util.isNullOrNil(this.countryCode)))
      {
        this.klq = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        Log.d("MicroMsg.MobileInputUI", "tm.getSimCountryIso()" + this.klq);
        if (!Util.isNullOrNil(this.klq)) {
          break label1010;
        }
        Log.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
    }
    for (;;)
    {
      bps();
      if (Util.isNullOrNil(this.kbb)) {
        this.knC.setText(this.kbb);
      }
      this.kaX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128344);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView.getContext();
          if (com.tencent.mm.aw.b.Pf(MobileInputUI.this.getString(2131758198)).size() > 1)
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("country_name", MobileInputUI.this.jbZ);
            paramAnonymousView.putExtra("couttry_code", MobileInputUI.this.countryCode);
            paramAnonymousView.putExtra("iso_code", MobileInputUI.this.klq);
            com.tencent.mm.plugin.account.a.a.jRt.b(paramAnonymousView, MobileInputUI.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128344);
        }
      });
      localObject = "";
      if ((com.tencent.mm.protocal.d.KyR) || (BuildInfo.IS_FLAVOR_BLUE)) {
        localObject = getString(2131755908) + com.tencent.mm.cc.h.jr(this);
      }
      setMMTitle((String)localObject);
      setActionbarColor(getResources().getColor(2131100898));
      hideActionbarLine();
      if (WeChatBrands.Business.Entries.LoginPasswordReset.banned()) {
        this.klS.setVisibility(8);
      }
      AppMethodBeat.o(128362);
      return;
      this.klU.setVisibility(8);
      this.klV.setText(2131762500);
      this.klV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128335);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          this.kmu.dGm();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128335);
        }
      });
      break;
      label989:
      this.jbZ = com.tencent.mm.aw.b.bt(this.countryCode, getString(2131758198));
      break label738;
      label1010:
      localObject = com.tencent.mm.aw.b.bs(this.klq, getString(2131758198));
      if (localObject == null)
      {
        Log.e("MicroMsg.MobileInputUI", "getDefaultCountryInfo error");
      }
      else
      {
        this.countryCode = PhoneFormater.pureCountryCode(((b.a)localObject).jbY);
        this.jbZ = ((b.a)localObject).jbZ;
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
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(712L, 2L, 1L, false);
        if ((this.knR instanceof l)) {
          ((l)this.knR).knv = 0;
        }
        this.knR.a(a.knY);
        AppMethodBeat.o(128368);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(712L, 1L, 1L, false);
      if ((this.knR instanceof l)) {
        ((l)this.knR).knv = 1;
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
        if ((this.knR instanceof l)) {
          ((l)this.knR).knv = 2;
        }
        this.knR.a(a.knY);
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
      if ((paramInt2 == -1) && (localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("auth_again")) && ((this.knR instanceof m))) {
        this.knR.a(a.knY);
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
      this.jbZ = Util.nullAs(paramIntent.getStringExtra("country_name"), "");
      this.countryCode = Util.nullAs(paramIntent.getStringExtra("couttry_code"), "");
      this.klq = Util.nullAs(paramIntent.getStringExtra("iso_code"), "");
      if ((this.knQ == 2) && (!com.tencent.mm.aw.b.Pj(this.countryCode)))
      {
        paramIntent = new Intent(this, RegByMobileRegAIOUI.class);
        paramIntent.putExtra("couttry_code", this.countryCode);
        paramIntent.putExtra("country_name", this.jbZ);
        paramIntent.putExtra("iso_code", this.klq);
        paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramIntent.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(128368);
        return;
      }
      bps();
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
      bpr();
      AppMethodBeat.o(128368);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128357);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    getWindow().getDecorView().setBackgroundColor(getContext().getResources().getColor(2131100899));
    this.knQ = getIntent().getIntExtra("mobile_input_purpose", 0);
    this.iDM = getIntent().getIntExtra("mobile_auth_type", 0);
    this.knS = getIntent().getBooleanExtra("can_finish", false);
    setBackBtn(new MobileInputUI.12(this), 2131689490);
    setActionbarColor(getContext().getResources().getColor(2131100898));
    hideActionbarLine();
    switch (this.knQ)
    {
    case 0: 
    default: 
      Log.e("MicroMsg.MobileInputUI", "wrong purpose %s", new Object[] { Integer.valueOf(this.knQ) });
      finish();
      AppMethodBeat.o(128357);
      return;
    case 1: 
      if (!Util.isNullOrNil(getIntent().getStringExtra("auth_ticket"))) {
        this.knR = new m();
      }
      break;
    }
    for (;;)
    {
      this.countryCode = PhoneFormater.pureCountryCode(Util.nullAs(getIntent().getStringExtra("couttry_code"), ""));
      this.jbZ = Util.nullAs(getIntent().getStringExtra("country_name"), "");
      this.klq = Util.nullAsNil(getIntent().getStringExtra("iso_code"));
      this.kbb = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
      this.knO = PhoneFormater.countryCodeWithPlus(this.countryCode);
      this.knP = Util.nullAs(getIntent().getStringExtra("input_mobile_number"), "");
      this.kbV = com.tencent.mm.plugin.b.a.bpZ();
      initView();
      this.kmX = getIntent().getBooleanExtra("from_deep_link", false);
      if ((this.kmX) && (!Util.isNullOrNil(this.knO)) && (!Util.isNullOrNil(this.knP))) {
        this.knB.setText(this.knP);
      }
      this.knR.a(this);
      if (!BuildInfo.EX_DEVICE_LOGIN)
      {
        if ((ao.gJH()) && (!ao.gJL())) {
          paramBundle = com.tencent.mm.plugin.account.model.d.kiq;
        }
      }
      else
      {
        this.kml.setVisibility(0);
        this.kml.setOnClickListener(new MobileInputUI.15(this));
      }
      this.klv = getIntent().getBooleanExtra("from_switch_account", false);
      com.tencent.mm.cr.d.hiy();
      AppMethodBeat.o(128357);
      return;
      paramBundle = getIntent().getIntArrayExtra("kv_report_login_method_data");
      if (paramBundle != null) {
        this.kmr = paramBundle;
      }
      this.knR = new j();
      continue;
      this.knR = new l();
      continue;
      this.knR = new i();
      continue;
      this.knR = new k();
      continue;
      this.knR = new m();
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128361);
    if (bpo()) {
      com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_reg_eu");
    }
    if (bpp()) {
      com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_login");
    }
    if (this.knD != null) {
      this.knD.reset();
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
    EventCenter.instance.removeListener(this.kkK);
    this.knR.stop();
    AppMethodBeat.o(128359);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169142);
    this.kmF.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(169142);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128358);
    EventCenter.instance.addListener(this.kkK);
    super.onResume();
    this.knR.start();
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
      knX = new a("GoBack", 0);
      knY = new a("GoNext", 1);
      knZ = new a[] { knX, knY };
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI
 * JD-Core Version:    0.7.0.1
 */