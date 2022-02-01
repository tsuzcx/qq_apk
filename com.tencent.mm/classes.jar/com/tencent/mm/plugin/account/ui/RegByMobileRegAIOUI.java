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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.b.a.gm;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.model.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.protocal.protobuf.dnn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.b.c.a;

public class RegByMobileRegAIOUI
  extends MMActivity
  implements f
{
  private String countryCode;
  private ImageView fQl;
  private String ihe;
  private LinearLayout jcU;
  private TextView jcW;
  private String jcY;
  private String jdS;
  private p jfk;
  private com.tencent.mm.sdk.b.c jmB;
  private gm jmP;
  private ResizeLayout jnT;
  private String jnh;
  private final int joP;
  private x jow;
  private boolean jpD;
  private String jpF;
  private String jpc;
  private String jpd;
  private int jpe;
  private String jpk;
  private TextView jpw;
  private Button jpx;
  private int jqd;
  private EditText jrG;
  private TextView jrH;
  private MMFormInputView jrI;
  private String jrJ;
  private View jrK;
  private CheckBox jrL;
  private MMFormInputView jrM;
  private ImageView jrN;
  private MMFormInputView jrO;
  private Bitmap jrP;
  private ScrollView jrQ;
  private String jrR;
  private String jrS;
  private String jrT;
  private String jrU;
  private boolean jrV;
  private com.tencent.mm.ui.widget.a.d jrW;
  private boolean jrX;
  private int jrY;
  private int jrZ;
  private String jrt;
  private boolean jrv;
  private boolean jsa;
  private boolean jsb;
  
  public RegByMobileRegAIOUI()
  {
    AppMethodBeat.i(128538);
    this.jcY = null;
    this.ihe = null;
    this.countryCode = null;
    this.jnh = null;
    this.jpD = true;
    this.jrJ = null;
    this.jpF = null;
    this.jrv = false;
    this.jpe = 0;
    this.jrV = true;
    this.jmP = new gm();
    this.jmB = new RegByMobileRegAIOUI.1(this);
    this.jow = new x();
    this.jrW = null;
    this.jrX = false;
    this.joP = 128;
    AppMethodBeat.o(128538);
  }
  
  private void Kx(final String paramString)
  {
    AppMethodBeat.i(128546);
    if (!com.tencent.mm.plugin.account.a.b.a.O(this, this.jrM.getText().toString()))
    {
      AppMethodBeat.o(128546);
      return;
    }
    if (this.jfk != null) {
      this.jfk.dismiss();
    }
    this.jow.b(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169152);
        RegByMobileRegAIOUI.e(RegByMobileRegAIOUI.this, paramString);
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
      if ((i != 0) && (this.jpD))
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
  
  private void aSz()
  {
    AppMethodBeat.i(128544);
    com.tencent.mm.plugin.b.a.KB(this.jdS);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",RE200_100,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("RE200_100") + ",2");
    finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(128544);
  }
  
  private boolean aUD()
  {
    AppMethodBeat.i(128553);
    if (bu.isNullOrNil(this.countryCode)) {}
    for (int i = 0;; i = 1)
    {
      boolean bool = i & a(new Editable[] { this.jrG.getText(), this.jrM.getText(), this.jrO.getText() });
      if (bool) {
        this.jpx.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(128553);
        return bool;
        this.jpx.setEnabled(false);
      }
    }
  }
  
  private void aUF()
  {
    AppMethodBeat.i(128547);
    if ((!bu.isNullOrNil(this.ihe)) && (!bu.isNullOrNil(this.countryCode)))
    {
      this.jcW.setText(bb.lU(this.ihe, this.countryCode));
      AppMethodBeat.o(128547);
      return;
    }
    this.jcW.setText(getString(2131761245));
    AppMethodBeat.o(128547);
  }
  
  private void aUP()
  {
    AppMethodBeat.i(128545);
    if (!bu.isNullOrNil(this.jrS))
    {
      if (this.jfk != null) {
        this.jfk.dismiss();
      }
      getString(2131755906);
      this.jfk = h.b(this, getString(2131755936), true, null);
      i locali = new i(this.jrS);
      com.tencent.mm.kernel.g.ajj().a(locali, 0);
    }
    AppMethodBeat.o(128545);
  }
  
  private void aUQ()
  {
    AppMethodBeat.i(128550);
    getString(2131755906);
    this.jfk = h.b(this, getString(2131762310), true, new RegByMobileRegAIOUI.24(this));
    int i = aUR();
    ae.i("MicroMsg.RegByMobileRegAIOUI", "select mobile check type %d", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.modelfriend.a locala = new com.tencent.mm.modelfriend.a(this.jrJ + this.jpF, 14, "", 0, "", i);
    locala.Fz(this.jpk);
    com.tencent.mm.kernel.g.ajj().a(locala, 0);
    AppMethodBeat.o(128550);
  }
  
  private int aUR()
  {
    AppMethodBeat.i(188436);
    if (!bu.isNullOrNil(this.jrS))
    {
      AppMethodBeat.o(188436);
      return 1;
    }
    ae.i("MicroMsg.RegByMobileRegAIOUI", "isMobile:%s, isMobileOpen:%s, SIM iso:%s", new Object[] { Boolean.valueOf(az.isMobile(this)), Boolean.valueOf(az.iZ(this)), com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso() });
    if ((az.isMobile(this)) || ((az.iZ(this)) && (!bu.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso()))))
    {
      AppMethodBeat.o(188436);
      return 2;
    }
    AppMethodBeat.o(188436);
    return 1;
  }
  
  private void aUS()
  {
    try
    {
      AppMethodBeat.i(128552);
      if (!this.jrX)
      {
        this.jrX = true;
        finish();
        Intent localIntent = new Intent();
        localIntent.putExtra("bindmcontact_mobile", this.jrJ + " " + this.jrG.getText().toString());
        localIntent.putExtra("bindmcontact_shortmobile", this.jpF);
        localIntent.putExtra("country_name", this.ihe);
        localIntent.putExtra("couttry_code", this.countryCode);
        localIntent.putExtra("mobileverify_countdownsec", this.jrY);
        localIntent.putExtra("mobileverify_countdownstyle", this.jrZ);
        localIntent.putExtra("mobileverify_fb", this.jsa);
        localIntent.putExtra("mobileverify_reg_qq", this.jsb);
        localIntent.putExtra("kintent_nickname", this.jrO.getText().toString());
        localIntent.putExtra("kintent_password", this.jrM.getText().toString());
        localIntent.putExtra("kintent_hasavatar", this.jrv);
        localIntent.putExtra("key_reg_style", 1);
        localIntent.putExtra("regsession_id", this.jpk);
        localIntent.putExtra("reg_3d_app_ticket", this.jrT);
        localIntent.putExtra("reg_3d_app_type", this.jqd);
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
    return 2131495240;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128542);
    this.jcU = ((LinearLayout)findViewById(2131298805));
    this.jcW = ((TextView)findViewById(2131298807));
    this.jrH = ((TextView)findViewById(2131303945));
    this.jrI = ((MMFormInputView)findViewById(2131303953));
    this.jrI.setInputType(3);
    this.jrG = this.jrI.getContentEditText();
    this.jrK = findViewById(2131305699);
    this.jrL = ((CheckBox)findViewById(2131303944));
    this.jpw = ((TextView)findViewById(2131303943));
    this.jpx = ((Button)findViewById(2131303938));
    this.fQl = ((ImageView)findViewById(2131304607));
    this.jrN = ((ImageView)findViewById(2131304609));
    this.jrM = ((MMFormInputView)findViewById(2131303950));
    com.tencent.mm.ui.tools.b.c.d(this.jrM.getContentEditText()).afD(16).a(null);
    this.jrQ = ((ScrollView)findViewById(2131304370));
    this.jnT = ((ResizeLayout)findViewById(2131304133));
    this.jrO = ((MMFormInputView)findViewById(2131303940));
    this.jnT.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aUw()
      {
        AppMethodBeat.i(128525);
        RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(128525);
      }
    });
    this.jrL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(128529);
        RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(128529);
      }
    });
    this.jpw.setOnClickListener(new RegByMobileRegAIOUI.18(this));
    Object localObject = new boolean[1];
    localObject[0] = 1;
    this.jrG.addTextChangedListener(new TextWatcher()
    {
      private bb jsg;
      
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
        if (this.jsh[0] != 0)
        {
          this.jsh[0] = false;
          com.tencent.mm.plugin.normsg.a.b.wJt.auC("ie_reg");
        }
        com.tencent.mm.plugin.normsg.a.b.wJt.auD("ie_reg");
        AppMethodBeat.o(128533);
      }
    });
    this.jrG.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(128534);
        if (paramAnonymousBoolean)
        {
          this.jsh[0] = true;
          AppMethodBeat.o(128534);
          return;
        }
        com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_reg");
        AppMethodBeat.o(128534);
      }
    });
    this.jrM.addTextChangedListener(new TextWatcher()
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
    this.jrO.addTextChangedListener(new TextWatcher()
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
    this.jpx.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(128537);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$9", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(128537);
          return false;
          this.joR[0] = true;
          com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_reg", "<Reg>");
          continue;
          com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_reg", paramAnonymousMotionEvent);
          com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_reg");
        }
      }
    });
    this.jpx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128510);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (this.joR[0] != 0) {
          this.joR[0] = false;
        }
        while (!RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this).isChecked())
        {
          paramAnonymousView = AnimationUtils.loadAnimation(RegByMobileRegAIOUI.this, 2130771990);
          RegByMobileRegAIOUI.e(RegByMobileRegAIOUI.this).startAnimation(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128510);
          return;
          com.tencent.mm.plugin.normsg.a.b.wJt.iu("ce_reg", "<Reg>");
          paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
          com.tencent.mm.plugin.normsg.a.b.wJt.a("ce_reg", paramAnonymousView);
          com.tencent.mm.plugin.normsg.a.b.wJt.auH("ce_reg");
        }
        paramAnonymousView = com.tencent.mm.ui.tools.b.c.d(RegByMobileRegAIOUI.m(RegByMobileRegAIOUI.this).getContentEditText()).kj(1, 32);
        paramAnonymousView.LiL = true;
        paramAnonymousView.a(new c.a()
        {
          public final void Ky(String paramAnonymous2String)
          {
            AppMethodBeat.i(128507);
            RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this, bb.aSf(RegByMobileRegAIOUI.f(RegByMobileRegAIOUI.this).getText().toString()));
            RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this, bb.aSh(RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this)));
            paramAnonymous2String = RegByMobileRegAIOUI.g(RegByMobileRegAIOUI.this) + RegByMobileRegAIOUI.h(RegByMobileRegAIOUI.this);
            RegByMobileRegAIOUI.this.hideVKB();
            if (RegByMobileRegAIOUI.i(RegByMobileRegAIOUI.this))
            {
              if (bu.isNullOrNil(RegByMobileRegAIOUI.j(RegByMobileRegAIOUI.this))) {
                RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this, com.tencent.mm.aw.b.bs(RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this), RegByMobileRegAIOUI.this.getString(2131757950)));
              }
              paramAnonymous2String = RegByMobileRegAIOUI.this.getString(2131760685, new Object[] { ad.fom(), RegByMobileRegAIOUI.j(RegByMobileRegAIOUI.this), "reg", Integer.valueOf(1), Integer.valueOf(0) });
              com.tencent.mm.plugin.account.a.b.a.b(RegByMobileRegAIOUI.this, paramAnonymous2String, 30847, false);
              AppMethodBeat.o(128507);
              return;
            }
            if (!bu.isNullOrNil(RegByMobileRegAIOUI.k(RegByMobileRegAIOUI.this)))
            {
              RegByMobileRegAIOUI.l(RegByMobileRegAIOUI.this);
              AppMethodBeat.o(128507);
              return;
            }
            RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this, paramAnonymous2String);
            AppMethodBeat.o(128507);
          }
          
          public final void aUT()
          {
            AppMethodBeat.i(169144);
            h.l(RegByMobileRegAIOUI.this, 2131763296, 2131763299);
            AppMethodBeat.o(169144);
          }
          
          public final void cW(String paramAnonymous2String)
          {
            AppMethodBeat.i(169145);
            h.l(RegByMobileRegAIOUI.this, 2131763297, 2131763299);
            AppMethodBeat.o(169145);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128510);
      }
    });
    this.jpx.setEnabled(false);
    if (bu.isNullOrNil(this.countryCode))
    {
      this.ihe = getString(2131757952);
      this.countryCode = bb.aSg(getString(2131757951));
      if (!bu.isNullOrNil(this.jrR)) {
        this.jrH.setText(this.jrR);
      }
      if ((bu.isNullOrNil(this.ihe)) || (bu.isNullOrNil(this.countryCode)))
      {
        this.jnh = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        ae.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + this.jnh);
        if (!bu.isNullOrNil(this.jnh)) {
          break label770;
        }
        ae.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
      }
      label538:
      aUF();
      if ((this.jcY != null) && (!this.jcY.equals(""))) {
        this.jrG.setText(this.jcY);
      }
      this.jcU.setOnClickListener(new RegByMobileRegAIOUI.3(this));
      setBackBtn(new RegByMobileRegAIOUI.4(this), 2131689488);
      this.fQl.setOnClickListener(new RegByMobileRegAIOUI.5(this));
      if (!bu.isNullOrNil(this.jrS)) {
        break label820;
      }
      com.tencent.mm.kernel.g.ajU().a(new ar.a()
      {
        String nickname;
        
        public final boolean aEC()
        {
          AppMethodBeat.i(169150);
          AppMethodBeat.o(169150);
          return true;
        }
        
        public final boolean aED()
        {
          AppMethodBeat.i(169149);
          if ((!bu.isNullOrNil(this.nickname)) && (bu.isNullOrNil(RegByMobileRegAIOUI.m(RegByMobileRegAIOUI.this).getText().trim()))) {
            RegByMobileRegAIOUI.m(RegByMobileRegAIOUI.this).setText(this.nickname);
          }
          if (!e.abo())
          {
            ae.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
            AppMethodBeat.o(169149);
            return false;
          }
          if ((RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this) != null) && (!RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this).isRecycled()) && (!RegByMobileRegAIOUI.q(RegByMobileRegAIOUI.this)))
          {
            RegByMobileRegAIOUI.r(RegByMobileRegAIOUI.this).setImageBitmap(RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this));
            RegByMobileRegAIOUI.s(RegByMobileRegAIOUI.this).setVisibility(8);
            RegByMobileRegAIOUI.t(RegByMobileRegAIOUI.this);
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
      if ((com.tencent.mm.protocal.d.FFK) || (j.IS_FLAVOR_BLUE)) {
        localObject = getString(2131755822) + com.tencent.mm.cc.g.ix(this);
      }
      setMMTitle((String)localObject);
      setActionbarColor(getResources().getColor(2131101179));
      hideActionbarLine();
      if (com.tencent.mm.compatible.util.d.lA(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131101179));
        updataStatusBarIcon(al.isDarkMode());
      }
      AppMethodBeat.o(128542);
      return;
      this.ihe = com.tencent.mm.aw.b.br(this.countryCode, getString(2131757950));
      break;
      label770:
      localObject = com.tencent.mm.aw.b.bq(this.jnh, getString(2131757950));
      if (localObject == null)
      {
        ae.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
        break label538;
      }
      this.ihe = ((b.a)localObject).ihe;
      this.countryCode = ((b.a)localObject).ihd;
      break label538;
      label820:
      this.jrO.setText(this.jrt);
      com.tencent.mm.kernel.g.ajU().a(new ar.a()
      {
        /* Error */
        public final boolean aEC()
        {
          // Byte code:
          //   0: ldc 25
          //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: new 33	java/net/URL
          //   8: dup
          //   9: aload_0
          //   10: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:jsc	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   13: invokestatic 37	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:u	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Ljava/lang/String;
          //   16: invokespecial 40	java/net/URL:<init>	(Ljava/lang/String;)V
          //   19: invokevirtual 44	java/net/URL:openConnection	()Ljava/net/URLConnection;
          //   22: checkcast 46	java/net/HttpURLConnection
          //   25: astore_1
          //   26: aload_1
          //   27: invokevirtual 50	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
          //   30: astore 4
          //   32: aload_0
          //   33: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:jsc	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   36: aload 4
          //   38: invokestatic 56	com/tencent/mm/sdk/platformtools/h:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
          //   41: invokestatic 60	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:a	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
          //   44: pop
          //   45: aload_0
          //   46: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:jsc	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   49: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:p	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
          //   52: ifnull +54 -> 106
          //   55: aload_0
          //   56: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:jsc	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   59: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:p	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
          //   62: invokevirtual 69	android/graphics/Bitmap:isRecycled	()Z
          //   65: ifne +41 -> 106
          //   68: aload_0
          //   69: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:jsc	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   72: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:p	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
          //   75: bipush 100
          //   77: getstatic 75	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
          //   80: new 77	java/lang/StringBuilder
          //   83: dup
          //   84: invokespecial 78	java/lang/StringBuilder:<init>	()V
          //   87: invokestatic 84	com/tencent/mm/loader/j/b:asr	()Ljava/lang/String;
          //   90: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   93: ldc 90
          //   95: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   98: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   101: iconst_0
          //   102: invokestatic 96	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
          //   105: pop
          //   106: aload 4
          //   108: ifnull +8 -> 116
          //   111: aload 4
          //   113: invokevirtual 101	java/io/InputStream:close	()V
          //   116: aload_1
          //   117: ifnull +7 -> 124
          //   120: aload_1
          //   121: invokevirtual 104	java/net/HttpURLConnection:disconnect	()V
          //   124: ldc 25
          //   126: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
          //   146: invokevirtual 101	java/io/InputStream:close	()V
          //   149: aload_1
          //   150: astore_2
          //   151: ldc 25
          //   153: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   156: aload_1
          //   157: astore_2
          //   158: aload_3
          //   159: athrow
          //   160: astore_3
          //   161: aload_1
          //   162: astore_2
          //   163: ldc 109
          //   165: aload_3
          //   166: ldc 111
          //   168: iconst_0
          //   169: anewarray 4	java/lang/Object
          //   172: invokestatic 117	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   175: aload_1
          //   176: ifnull -52 -> 124
          //   179: aload_1
          //   180: invokevirtual 104	java/net/HttpURLConnection:disconnect	()V
          //   183: goto -59 -> 124
          //   186: astore_3
          //   187: aload_1
          //   188: astore_2
          //   189: aload_3
          //   190: astore_1
          //   191: aload_2
          //   192: ifnull +7 -> 199
          //   195: aload_2
          //   196: invokevirtual 104	java/net/HttpURLConnection:disconnect	()V
          //   199: ldc 25
          //   201: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
        
        public final boolean aED()
        {
          AppMethodBeat.i(128517);
          if ((!RegByMobileRegAIOUI.q(RegByMobileRegAIOUI.this)) && (RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this) != null) && (!RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this).isRecycled()))
          {
            RegByMobileRegAIOUI.r(RegByMobileRegAIOUI.this).setImageBitmap(RegByMobileRegAIOUI.p(RegByMobileRegAIOUI.this));
            RegByMobileRegAIOUI.s(RegByMobileRegAIOUI.this).setVisibility(8);
            RegByMobileRegAIOUI.t(RegByMobileRegAIOUI.this);
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
      if ((paramInt2 == -1) && (aUD()))
      {
        aUQ();
        com.tencent.mm.plugin.b.a.KB("RE200_250");
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
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(712L, 2L, 1L, false);
        this.jrV = false;
        if (!bu.isNullOrNil(this.jrS))
        {
          aUP();
          AppMethodBeat.o(128548);
          return;
        }
        Kx(this.jrJ + this.jpF);
        AppMethodBeat.o(128548);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(712L, 1L, 1L, false);
      AppMethodBeat.o(128548);
      return;
    }
    switch (paramInt2)
    {
    default: 
      this.jrP = com.tencent.mm.plugin.account.a.a.iUA.b(this, paramInt1, paramInt2, paramIntent);
      if (this.jrP != null)
      {
        this.fQl.setImageBitmap(this.jrP);
        this.jrv = true;
        this.jrN.setVisibility(8);
      }
      AppMethodBeat.o(128548);
      return;
    }
    this.ihe = bu.bI(paramIntent.getStringExtra("country_name"), "");
    this.countryCode = bu.bI(paramIntent.getStringExtra("couttry_code"), "");
    this.jnh = bu.bI(paramIntent.getStringExtra("iso_code"), "");
    if (com.tencent.mm.aw.b.Gx(this.countryCode))
    {
      if ((!bu.isNullOrNil(this.jrS)) && (!bu.isNullOrNil(this.jrt)) && (!bu.isNullOrNil(this.jrU)))
      {
        aUF();
        AppMethodBeat.o(128548);
        return;
      }
      paramIntent = new Intent(this, MobileInputUI.class);
      paramIntent.putExtra("mobile_input_purpose", 2);
      paramIntent.putExtra("couttry_code", this.countryCode);
      paramIntent.putExtra("country_name", this.ihe);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      overridePendingTransition(2130771986, 2130771986);
      AppMethodBeat.o(128548);
      return;
    }
    aUF();
    AppMethodBeat.o(128548);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128539);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    this.ihe = bu.bI(getIntent().getStringExtra("country_name"), "");
    this.countryCode = bb.aSg(bu.bI(getIntent().getStringExtra("couttry_code"), ""));
    this.jnh = bu.nullAsNil(getIntent().getStringExtra("iso_code"));
    this.jcY = bu.bI(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.jrR = getIntent().getStringExtra("register_title");
    this.jrt = getIntent().getStringExtra("register_nick_name");
    this.jrU = getIntent().getStringExtra("register_avatar");
    this.jrS = getIntent().getStringExtra("third_app_token");
    this.jqd = getIntent().getIntExtra("reg_3d_app_type", 0);
    initView();
    AppMethodBeat.o(128539);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128551);
    com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_reg");
    if (this.jrW != null) {
      this.jrW.dismiss();
    }
    this.jmP.aLH();
    super.onDestroy();
    AppMethodBeat.o(128551);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128543);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aSz();
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
    if (this.jfk != null) {
      this.jfk.dismiss();
    }
    com.tencent.mm.sdk.b.a.IvT.d(this.jmB);
    com.tencent.mm.kernel.g.ajj().b(701, this);
    com.tencent.mm.kernel.g.ajj().b(252, this);
    com.tencent.mm.kernel.g.ajj().b(145, this);
    com.tencent.mm.kernel.g.ajj().b(132, this);
    com.tencent.mm.kernel.g.ajj().b(755, this);
    com.tencent.mm.kernel.g.ajj().b(252, this);
    com.tencent.mm.kernel.g.ajj().b(701, this);
    com.tencent.mm.plugin.b.a.KA("RE200_100");
    AppMethodBeat.o(128541);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169153);
    if (paramInt == 34)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        com.tencent.mm.plugin.account.a.a.iUA.s(this);
        AppMethodBeat.o(169153);
      }
    }
    else {
      this.jow.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(169153);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128540);
    com.tencent.mm.sdk.b.a.IvT.c(this.jmB);
    super.onResume();
    com.tencent.mm.kernel.g.ajj().a(701, this);
    com.tencent.mm.kernel.g.ajj().a(252, this);
    com.tencent.mm.kernel.g.ajj().a(145, this);
    com.tencent.mm.kernel.g.ajj().a(132, this);
    com.tencent.mm.kernel.g.ajj().a(755, this);
    com.tencent.mm.kernel.g.ajj().a(252, this);
    com.tencent.mm.kernel.g.ajj().a(701, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",RE200_100,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("RE200_100") + ",1");
    this.jpe = 0;
    AppMethodBeat.o(128540);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128549);
    ae.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jfk != null)
    {
      this.jfk.dismiss();
      this.jfk = null;
    }
    if (paramInt2 == -75)
    {
      h.l(this, 2131755266, 2131762275);
      AppMethodBeat.o(128549);
      return;
    }
    if (paramn.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramn).KZ();
      if (i == 12)
      {
        if ((paramInt2 == -41) || (paramInt2 == -59))
        {
          paramString = com.tencent.mm.h.a.uU(paramString);
          if (paramString != null)
          {
            paramString.a(this, null, null);
            AppMethodBeat.o(128549);
            return;
          }
          h.l(this, 2131762328, 2131762329);
          AppMethodBeat.o(128549);
          return;
        }
        this.jpF = bb.aSf(this.jpF);
        this.jpd = (this.jrJ + this.jpF);
        this.jpk = ((com.tencent.mm.modelfriend.a)paramn).aIb();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramn = ((com.tencent.mm.modelfriend.a)paramn).aHP();
          if (!bu.isNullOrNil(paramn)) {
            this.jpF = paramn.trim();
          }
          com.tencent.mm.plugin.b.a.KA("RE200_100");
          paramn = new StringBuilder();
          com.tencent.mm.kernel.g.ajP();
          paramn = paramn.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",RE200_200,");
          com.tencent.mm.kernel.g.ajP();
          com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("RE200_200") + ",1");
          paramString = com.tencent.mm.h.a.uU(paramString);
          if (paramString != null)
          {
            paramString.a(this, new DialogInterface.OnClickListener()new RegByMobileRegAIOUI.13
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128524);
                RegByMobileRegAIOUI.w(RegByMobileRegAIOUI.this);
                com.tencent.mm.plugin.b.a.KB("RE200_250");
                AppMethodBeat.o(128524);
              }
            }, new RegByMobileRegAIOUI.13(this));
            AppMethodBeat.o(128549);
            return;
          }
          aUQ();
          com.tencent.mm.plugin.b.a.KB("RE200_250");
          AppMethodBeat.o(128549);
          return;
        }
        if (paramInt2 == -355)
        {
          y.g(this, paramString, 30846);
          this.jmP.epA = this.jqd;
          this.jmP.dQB = 5L;
          this.jmP.aLH();
          AppMethodBeat.o(128549);
          return;
        }
        if (paramInt2 == -34)
        {
          h.c(this, getString(2131756462), "", true);
          AppMethodBeat.o(128549);
          return;
        }
        if (com.tencent.mm.plugin.account.a.a.iUA.a(this, paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(128549);
          return;
        }
        Toast.makeText(this, getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      Object localObject2;
      if (i == 14)
      {
        if (paramInt2 != 0) {
          break label1170;
        }
        i = ((com.tencent.mm.modelfriend.a)paramn).aHQ();
        if (i != 2) {
          break label838;
        }
        localObject1 = ((com.tencent.mm.modelfriend.a)paramn).aHT();
        if (localObject1 != null)
        {
          ae.i("MicroMsg.RegByMobileRegAIOUI", "network check url %s", new Object[] { ((ccv)localObject1).url });
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Key_Seq", ((ccv)localObject1).jrr);
          ((Intent)localObject2).putExtra("Key_Url", ((ccv)localObject1).url);
          ((Intent)localObject2).putExtra("Key_CountryCode", this.jrJ);
          ((Intent)localObject2).putExtra("Key_Mobile", this.jpF);
          ((Intent)localObject2).putExtra("Key_reg_sessionId", this.jpk);
          ((Intent)localObject2).putExtra("kintent_nickname", this.jrO.getText().toString());
          ((Intent)localObject2).putExtra("kintent_password", this.jrM.getText().toString());
          ((Intent)localObject2).putExtra("kintent_hasavatar", this.jrv);
          ((Intent)localObject2).setClass(this, RegByMobileAutoVerifyUI.class);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      while (com.tencent.mm.plugin.account.a.a.iUA.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128549);
        return;
        label838:
        if (i == 1)
        {
          localObject1 = this.jrJ + this.jpF;
          localObject2 = ((com.tencent.mm.modelfriend.a)paramn).aHS();
          String str = ((com.tencent.mm.modelfriend.a)paramn).aHR();
          Intent localIntent = new Intent(this, RegByMobileSendSmsUI.class);
          localIntent.putExtra("regsession_id", this.jpk);
          localIntent.putExtra("key_reg_style", 1);
          localIntent.putExtra("from_mobile", (String)localObject1);
          localIntent.putExtra("to_mobile", (String)localObject2);
          localIntent.putExtra("verify_code", str);
          localIntent.putExtra("kintent_nickname", this.jrO.getText().toString());
          localIntent.putExtra("kintent_password", this.jrM.getText().toString());
          localIntent.putExtra("kintent_hasavatar", this.jrv);
          localIntent.putExtra("reg_3d_app_type", this.jqd);
          localIntent.putExtra("reg_3d_app_ticket", this.jrT);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          this.jrY = ((com.tencent.mm.modelfriend.a)paramn).aHV();
          this.jrZ = ((com.tencent.mm.modelfriend.a)paramn).aHW();
          this.jsa = ((com.tencent.mm.modelfriend.a)paramn).aHX();
          this.jsb = ((com.tencent.mm.modelfriend.a)paramn).aHY();
          aUS();
        }
      }
      label1170:
      if (paramInt2 == -41)
      {
        h.l(this, 2131762328, 2131762329);
        AppMethodBeat.o(128549);
        return;
      }
      if (paramInt2 == -34)
      {
        h.c(this, getString(2131756462), "", true);
        AppMethodBeat.o(128549);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.iUA.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128549);
        return;
      }
      Toast.makeText(this, getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128549);
      return;
    }
    if (paramn.getType() == 755) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = (i)paramn;
        if (((i)localObject1).rr.hQE.hQJ == null) {
          break label1612;
        }
      }
    }
    label1612:
    for (Object localObject1 = ((dnn)((i)localObject1).rr.hQE.hQJ).Hqd;; localObject1 = "")
    {
      this.jrT = ((String)localObject1);
      Kx(this.jrJ + this.jpF);
      break;
      if (paramInt2 != -7) {
        break;
      }
      this.jmP.epA = this.jqd;
      this.jmP.dQB = 7L;
      this.jmP.aLH();
      h.a(this, getString(2131758800), getString(2131755906), getString(2131760075), getString(2131755691), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(224319);
          RegByMobileRegAIOUI.x(RegByMobileRegAIOUI.this);
          RegByMobileRegAIOUI.z(RegByMobileRegAIOUI.this).epA = RegByMobileRegAIOUI.y(RegByMobileRegAIOUI.this);
          RegByMobileRegAIOUI.z(RegByMobileRegAIOUI.this).dQB = 8L;
          RegByMobileRegAIOUI.z(RegByMobileRegAIOUI.this).aLH();
          AppMethodBeat.o(224319);
        }
      }, null);
      break;
      if (((paramn.getType() != 701) && (paramn.getType() != 252)) || (paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
      this.jmP.epA = this.jqd;
      this.jmP.dQB = 12L;
      this.jmP.aLH();
      com.tencent.mm.plugin.account.friend.a.l.aTs();
      y.Jv(v.aAC());
      com.tencent.mm.platformtools.t.cW(this);
      y.showAddrBookUploadConfirm(this, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224320);
          Object localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(RegByMobileRegAIOUI.this);
          ((Intent)localObject2).addFlags(67108864);
          Object localObject1 = RegByMobileRegAIOUI.this;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$22", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((RegByMobileRegAIOUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$22", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = new StringBuilder();
          com.tencent.mm.kernel.g.ajP();
          localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(RegByMobileRegAIOUI.this.getClass().getName()).append(",L14,");
          com.tencent.mm.kernel.g.ajP();
          com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("L14") + ",4");
          RegByMobileRegAIOUI.this.finish();
          AppMethodBeat.o(224320);
        }
      }, false, 2);
      AppMethodBeat.o(128549);
      return;
      if ((paramn.getType() == 252) || (paramn.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.uU(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI
 * JD-Core Version:    0.7.0.1
 */