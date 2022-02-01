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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.mm.ak.n;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.b.a.fl;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.model.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.b.c.a;

public class RegByMobileRegAIOUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String countryCode;
  private ImageView fuY;
  private String hLr;
  private LinearLayout iGS;
  private TextView iGU;
  private String iGW;
  private String iHQ;
  private p iJi;
  private com.tencent.mm.sdk.b.c iQA;
  private fl iQO;
  private ResizeLayout iRR;
  private String iRg;
  private final int iSN;
  private x iSu;
  private boolean iTB;
  private String iTD;
  private String iTa;
  private String iTb;
  private int iTc;
  private String iTi;
  private TextView iTu;
  private Button iTv;
  private int iUb;
  private EditText iVE;
  private TextView iVF;
  private MMFormInputView iVG;
  private String iVH;
  private View iVI;
  private CheckBox iVJ;
  private MMFormInputView iVK;
  private ImageView iVL;
  private MMFormInputView iVM;
  private Bitmap iVN;
  private ScrollView iVO;
  private String iVP;
  private String iVQ;
  private String iVR;
  private String iVS;
  private boolean iVT;
  private com.tencent.mm.ui.widget.a.d iVU;
  private boolean iVV;
  private int iVW;
  private int iVX;
  private boolean iVY;
  private boolean iVZ;
  private String iVr;
  private boolean iVt;
  
  public RegByMobileRegAIOUI()
  {
    AppMethodBeat.i(128538);
    this.iGW = null;
    this.hLr = null;
    this.countryCode = null;
    this.iRg = null;
    this.iTB = true;
    this.iVH = null;
    this.iTD = null;
    this.iVt = false;
    this.iTc = 0;
    this.iVT = true;
    this.iQO = new fl();
    this.iQA = new RegByMobileRegAIOUI.1(this);
    this.iSu = new x();
    this.iVU = null;
    this.iVV = false;
    this.iSN = 128;
    AppMethodBeat.o(128538);
  }
  
  private void GJ(final String paramString)
  {
    AppMethodBeat.i(128546);
    if (!com.tencent.mm.plugin.account.a.b.a.O(this, this.iVK.getText().toString()))
    {
      AppMethodBeat.o(128546);
      return;
    }
    if (this.iJi != null) {
      this.iJi.dismiss();
    }
    this.iSu.b(this, new Runnable()
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
      if ((i != 0) && (this.iTB))
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
  
  private void aOO()
  {
    AppMethodBeat.i(128544);
    com.tencent.mm.plugin.b.a.IL(this.iHQ);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",RE200_100,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("RE200_100") + ",2");
    finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(128544);
  }
  
  private boolean aQS()
  {
    AppMethodBeat.i(128553);
    if (bs.isNullOrNil(this.countryCode)) {}
    for (int i = 0;; i = 1)
    {
      boolean bool = i & a(new Editable[] { this.iVE.getText(), this.iVK.getText(), this.iVM.getText() });
      if (bool) {
        this.iTv.setEnabled(true);
      }
      for (;;)
      {
        AppMethodBeat.o(128553);
        return bool;
        this.iTv.setEnabled(false);
      }
    }
  }
  
  private void aQU()
  {
    AppMethodBeat.i(128547);
    if ((!bs.isNullOrNil(this.hLr)) && (!bs.isNullOrNil(this.countryCode)))
    {
      this.iGU.setText(az.lo(this.hLr, this.countryCode));
      AppMethodBeat.o(128547);
      return;
    }
    this.iGU.setText(getString(2131761245));
    AppMethodBeat.o(128547);
  }
  
  private void aRe()
  {
    AppMethodBeat.i(128545);
    if (!bs.isNullOrNil(this.iVQ))
    {
      if (this.iJi != null) {
        this.iJi.dismiss();
      }
      getString(2131755906);
      this.iJi = com.tencent.mm.ui.base.h.b(this, getString(2131755936), true, null);
      i locali = new i(this.iVQ);
      com.tencent.mm.kernel.g.agi().a(locali, 0);
    }
    AppMethodBeat.o(128545);
  }
  
  private void aRf()
  {
    AppMethodBeat.i(128550);
    getString(2131755906);
    this.iJi = com.tencent.mm.ui.base.h.b(this, getString(2131762310), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    int i = aRg();
    ac.i("MicroMsg.RegByMobileRegAIOUI", "select mobile check type %d", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.modelfriend.a locala = new com.tencent.mm.modelfriend.a(this.iVH + this.iTD, 14, "", 0, "", i);
    locala.BY(this.iTi);
    com.tencent.mm.kernel.g.agi().a(locala, 0);
    AppMethodBeat.o(128550);
  }
  
  private int aRg()
  {
    AppMethodBeat.i(193243);
    if (!bs.isNullOrNil(this.iVQ))
    {
      AppMethodBeat.o(193243);
      return 1;
    }
    ac.i("MicroMsg.RegByMobileRegAIOUI", "isMobile:%s, isMobileOpen:%s, SIM iso:%s", new Object[] { Boolean.valueOf(ax.isMobile(this)), Boolean.valueOf(ax.iK(this)), com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso() });
    if ((ax.isMobile(this)) || ((ax.iK(this)) && (!bs.isNullOrNil(com.tencent.mm.compatible.deviceinfo.q.getSimCountryIso()))))
    {
      AppMethodBeat.o(193243);
      return 2;
    }
    AppMethodBeat.o(193243);
    return 1;
  }
  
  private void aRh()
  {
    try
    {
      AppMethodBeat.i(128552);
      if (!this.iVV)
      {
        this.iVV = true;
        finish();
        Intent localIntent = new Intent();
        localIntent.putExtra("bindmcontact_mobile", this.iVH + " " + this.iVE.getText().toString());
        localIntent.putExtra("bindmcontact_shortmobile", this.iTD);
        localIntent.putExtra("country_name", this.hLr);
        localIntent.putExtra("couttry_code", this.countryCode);
        localIntent.putExtra("mobileverify_countdownsec", this.iVW);
        localIntent.putExtra("mobileverify_countdownstyle", this.iVX);
        localIntent.putExtra("mobileverify_fb", this.iVY);
        localIntent.putExtra("mobileverify_reg_qq", this.iVZ);
        localIntent.putExtra("kintent_nickname", this.iVM.getText().toString());
        localIntent.putExtra("kintent_password", this.iVK.getText().toString());
        localIntent.putExtra("kintent_hasavatar", this.iVt);
        localIntent.putExtra("key_reg_style", 1);
        localIntent.putExtra("regsession_id", this.iTi);
        localIntent.putExtra("reg_3d_app_ticket", this.iVR);
        localIntent.putExtra("reg_3d_app_type", this.iUb);
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
    this.iGS = ((LinearLayout)findViewById(2131298805));
    this.iGU = ((TextView)findViewById(2131298807));
    this.iVF = ((TextView)findViewById(2131303945));
    this.iVG = ((MMFormInputView)findViewById(2131303953));
    this.iVG.setInputType(3);
    this.iVE = this.iVG.getContentEditText();
    this.iVI = findViewById(2131305699);
    this.iVJ = ((CheckBox)findViewById(2131303944));
    this.iTu = ((TextView)findViewById(2131303943));
    this.iTv = ((Button)findViewById(2131303938));
    this.fuY = ((ImageView)findViewById(2131304607));
    this.iVL = ((ImageView)findViewById(2131304609));
    this.iVK = ((MMFormInputView)findViewById(2131303950));
    com.tencent.mm.ui.tools.b.c.d(this.iVK.getContentEditText()).acw(16).a(null);
    this.iVO = ((ScrollView)findViewById(2131304370));
    this.iRR = ((ResizeLayout)findViewById(2131304133));
    this.iVM = ((MMFormInputView)findViewById(2131303940));
    this.iRR.setOnSizeChanged(new ResizeLayout.a()
    {
      public final void aQL()
      {
        AppMethodBeat.i(128525);
        RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(128525);
      }
    });
    this.iVJ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(128529);
        RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this);
        AppMethodBeat.o(128529);
      }
    });
    this.iTu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128530);
        paramAnonymousView = com.tencent.mm.aw.b.br(RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this), RegByMobileRegAIOUI.this.getString(2131757950));
        com.tencent.mm.plugin.account.a.b.a.b(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.this.getString(2131764600, new Object[] { ab.eUO(), paramAnonymousView }), 0, false);
        AppMethodBeat.o(128530);
      }
    });
    Object localObject = new boolean[1];
    localObject[0] = 1;
    this.iVE.addTextChangedListener(new TextWatcher()
    {
      private az iWe;
      
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
        if (this.iWf[0] != 0)
        {
          this.iWf[0] = false;
          com.tencent.mm.plugin.normsg.a.b.vor.aop("ie_reg");
        }
        com.tencent.mm.plugin.normsg.a.b.vor.aoq("ie_reg");
        AppMethodBeat.o(128533);
      }
    });
    this.iVE.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(128534);
        if (paramAnonymousBoolean)
        {
          this.iWf[0] = true;
          AppMethodBeat.o(128534);
          return;
        }
        com.tencent.mm.plugin.normsg.a.b.vor.aor("ie_reg");
        AppMethodBeat.o(128534);
      }
    });
    this.iVK.addTextChangedListener(new TextWatcher()
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
    this.iVM.addTextChangedListener(new TextWatcher()
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
    this.iTv.setOnTouchListener(new View.OnTouchListener()
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
          this.iSP[0] = true;
          com.tencent.mm.plugin.normsg.a.b.vor.id("ce_reg", "<Reg>");
          continue;
          com.tencent.mm.plugin.normsg.a.b.vor.a("ce_reg", paramAnonymousMotionEvent);
          com.tencent.mm.plugin.normsg.a.b.vor.aou("ce_reg");
        }
      }
    });
    this.iTv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128510);
        if (this.iSP[0] != 0) {
          this.iSP[0] = false;
        }
        while (!RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this).isChecked())
        {
          paramAnonymousView = AnimationUtils.loadAnimation(RegByMobileRegAIOUI.this, 2130771990);
          RegByMobileRegAIOUI.e(RegByMobileRegAIOUI.this).startAnimation(paramAnonymousView);
          AppMethodBeat.o(128510);
          return;
          com.tencent.mm.plugin.normsg.a.b.vor.id("ce_reg", "<Reg>");
          paramAnonymousView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
          com.tencent.mm.plugin.normsg.a.b.vor.a("ce_reg", paramAnonymousView);
          com.tencent.mm.plugin.normsg.a.b.vor.aou("ce_reg");
        }
        paramAnonymousView = com.tencent.mm.ui.tools.b.c.d(RegByMobileRegAIOUI.m(RegByMobileRegAIOUI.this).getContentEditText()).jQ(1, 32);
        paramAnonymousView.IVj = true;
        paramAnonymousView.a(new c.a()
        {
          public final void GK(String paramAnonymous2String)
          {
            AppMethodBeat.i(128507);
            RegByMobileRegAIOUI.a(RegByMobileRegAIOUI.this, az.aLc(RegByMobileRegAIOUI.f(RegByMobileRegAIOUI.this).getText().toString()));
            RegByMobileRegAIOUI.b(RegByMobileRegAIOUI.this, az.aLe(RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this)));
            paramAnonymous2String = RegByMobileRegAIOUI.g(RegByMobileRegAIOUI.this) + RegByMobileRegAIOUI.h(RegByMobileRegAIOUI.this);
            RegByMobileRegAIOUI.this.hideVKB();
            if (RegByMobileRegAIOUI.i(RegByMobileRegAIOUI.this))
            {
              if (bs.isNullOrNil(RegByMobileRegAIOUI.j(RegByMobileRegAIOUI.this))) {
                RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this, com.tencent.mm.aw.b.br(RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this), RegByMobileRegAIOUI.this.getString(2131757950)));
              }
              paramAnonymous2String = RegByMobileRegAIOUI.this.getString(2131760685, new Object[] { ab.eUO(), RegByMobileRegAIOUI.j(RegByMobileRegAIOUI.this), "reg", Integer.valueOf(1), Integer.valueOf(0) });
              com.tencent.mm.plugin.account.a.b.a.b(RegByMobileRegAIOUI.this, paramAnonymous2String, 30847, false);
              AppMethodBeat.o(128507);
              return;
            }
            if (!bs.isNullOrNil(RegByMobileRegAIOUI.k(RegByMobileRegAIOUI.this)))
            {
              RegByMobileRegAIOUI.l(RegByMobileRegAIOUI.this);
              AppMethodBeat.o(128507);
              return;
            }
            RegByMobileRegAIOUI.d(RegByMobileRegAIOUI.this, paramAnonymous2String);
            AppMethodBeat.o(128507);
          }
          
          public final void aRi()
          {
            AppMethodBeat.i(169144);
            com.tencent.mm.ui.base.h.l(RegByMobileRegAIOUI.this, 2131763296, 2131763299);
            AppMethodBeat.o(169144);
          }
          
          public final void ca(String paramAnonymous2String)
          {
            AppMethodBeat.i(169145);
            com.tencent.mm.ui.base.h.l(RegByMobileRegAIOUI.this, 2131763297, 2131763299);
            AppMethodBeat.o(169145);
          }
        });
        AppMethodBeat.o(128510);
      }
    });
    this.iTv.setEnabled(false);
    if (bs.isNullOrNil(this.countryCode))
    {
      this.hLr = getString(2131757952);
      this.countryCode = az.aLd(getString(2131757951));
      if (!bs.isNullOrNil(this.iVP)) {
        this.iVF.setText(this.iVP);
      }
      if ((bs.isNullOrNil(this.hLr)) || (bs.isNullOrNil(this.countryCode)))
      {
        this.iRg = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        ac.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + this.iRg);
        if (!bs.isNullOrNil(this.iRg)) {
          break label767;
        }
        ac.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
      }
      label538:
      aQU();
      if ((this.iGW != null) && (!this.iGW.equals(""))) {
        this.iVE.setText(this.iGW);
      }
      this.iGS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169146);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("country_name", RegByMobileRegAIOUI.n(RegByMobileRegAIOUI.this));
          paramAnonymousView.putExtra("couttry_code", RegByMobileRegAIOUI.c(RegByMobileRegAIOUI.this));
          com.tencent.mm.plugin.account.a.a.iyx.b(paramAnonymousView, RegByMobileRegAIOUI.this);
          AppMethodBeat.o(169146);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(169147);
          RegByMobileRegAIOUI.this.hideVKB();
          RegByMobileRegAIOUI.o(RegByMobileRegAIOUI.this);
          RegByMobileRegAIOUI.this.finish();
          AppMethodBeat.o(169147);
          return true;
        }
      }, 2131689488);
      this.fuY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(169148);
          if (com.tencent.mm.pluginsdk.permission.b.a(RegByMobileRegAIOUI.this, "android.permission.WRITE_EXTERNAL_STORAGE", 34, "", "")) {
            com.tencent.mm.plugin.account.a.a.iyy.s(RegByMobileRegAIOUI.this);
          }
          AppMethodBeat.o(169148);
        }
      });
      if (!bs.isNullOrNil(this.iVQ)) {
        break label817;
      }
      com.tencent.mm.kernel.g.agU().a(new ap.a()
      {
        String nickname;
        
        public final boolean aBj()
        {
          AppMethodBeat.i(169150);
          AppMethodBeat.o(169150);
          return true;
        }
        
        public final boolean aBk()
        {
          AppMethodBeat.i(169149);
          if ((!bs.isNullOrNil(this.nickname)) && (bs.isNullOrNil(RegByMobileRegAIOUI.m(RegByMobileRegAIOUI.this).getText().trim()))) {
            RegByMobileRegAIOUI.m(RegByMobileRegAIOUI.this).setText(this.nickname);
          }
          if (!e.YD())
          {
            ac.e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
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
      if (com.tencent.mm.protocal.d.DIf) {
        localObject = getString(2131755822) + getString(2131755263);
      }
      setMMTitle((String)localObject);
      setActionbarColor(getResources().getColor(2131101179));
      hideActionbarLine();
      if (com.tencent.mm.compatible.util.d.kZ(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(2131101179));
        updataStatusBarIcon(aj.DT());
      }
      AppMethodBeat.o(128542);
      return;
      this.hLr = com.tencent.mm.aw.b.bq(this.countryCode, getString(2131757950));
      break;
      label767:
      localObject = com.tencent.mm.aw.b.bp(this.iRg, getString(2131757950));
      if (localObject == null)
      {
        ac.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
        break label538;
      }
      this.hLr = ((b.a)localObject).hLr;
      this.countryCode = ((b.a)localObject).hLq;
      break label538;
      label817:
      this.iVM.setText(this.iVr);
      com.tencent.mm.kernel.g.agU().a(new ap.a()
      {
        /* Error */
        public final boolean aBj()
        {
          // Byte code:
          //   0: ldc 25
          //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: new 33	java/net/URL
          //   8: dup
          //   9: aload_0
          //   10: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:iWa	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   13: invokestatic 37	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:u	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Ljava/lang/String;
          //   16: invokespecial 40	java/net/URL:<init>	(Ljava/lang/String;)V
          //   19: invokevirtual 44	java/net/URL:openConnection	()Ljava/net/URLConnection;
          //   22: checkcast 46	java/net/HttpURLConnection
          //   25: astore_1
          //   26: aload_1
          //   27: invokevirtual 50	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
          //   30: astore 4
          //   32: aload_0
          //   33: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:iWa	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   36: aload 4
          //   38: invokestatic 56	com/tencent/mm/sdk/platformtools/f:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
          //   41: invokestatic 60	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:a	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
          //   44: pop
          //   45: aload_0
          //   46: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:iWa	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   49: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:p	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
          //   52: ifnull +54 -> 106
          //   55: aload_0
          //   56: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:iWa	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   59: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:p	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
          //   62: invokevirtual 69	android/graphics/Bitmap:isRecycled	()Z
          //   65: ifne +41 -> 106
          //   68: aload_0
          //   69: getfield 17	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI$7:iWa	Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;
          //   72: invokestatic 64	com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI:p	(Lcom/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI;)Landroid/graphics/Bitmap;
          //   75: bipush 100
          //   77: getstatic 75	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
          //   80: new 77	java/lang/StringBuilder
          //   83: dup
          //   84: invokespecial 78	java/lang/StringBuilder:<init>	()V
          //   87: invokestatic 84	com/tencent/mm/loader/j/b:apo	()Ljava/lang/String;
          //   90: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   93: ldc 90
          //   95: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   98: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   101: iconst_0
          //   102: invokestatic 96	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
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
          //   172: invokestatic 117	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
        
        public final boolean aBk()
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
      if ((paramInt2 == -1) && (aQS()))
      {
        aRf();
        com.tencent.mm.plugin.b.a.IL("RE200_250");
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
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(712L, 2L, 1L, false);
        this.iVT = false;
        if (!bs.isNullOrNil(this.iVQ))
        {
          aRe();
          AppMethodBeat.o(128548);
          return;
        }
        GJ(this.iVH + this.iTD);
        AppMethodBeat.o(128548);
        return;
      }
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(712L, 1L, 1L, false);
      AppMethodBeat.o(128548);
      return;
    }
    switch (paramInt2)
    {
    default: 
      this.iVN = com.tencent.mm.plugin.account.a.a.iyy.a(this, paramInt1, paramInt2, paramIntent);
      if (this.iVN != null)
      {
        this.fuY.setImageBitmap(this.iVN);
        this.iVt = true;
        this.iVL.setVisibility(8);
      }
      AppMethodBeat.o(128548);
      return;
    }
    this.hLr = bs.bG(paramIntent.getStringExtra("country_name"), "");
    this.countryCode = bs.bG(paramIntent.getStringExtra("couttry_code"), "");
    this.iRg = bs.bG(paramIntent.getStringExtra("iso_code"), "");
    if (com.tencent.mm.aw.b.CR(this.countryCode))
    {
      if ((!bs.isNullOrNil(this.iVQ)) && (!bs.isNullOrNil(this.iVr)) && (!bs.isNullOrNil(this.iVS)))
      {
        aQU();
        AppMethodBeat.o(128548);
        return;
      }
      paramIntent = new Intent(this, MobileInputUI.class);
      paramIntent.putExtra("mobile_input_purpose", 2);
      paramIntent.putExtra("couttry_code", this.countryCode);
      paramIntent.putExtra("country_name", this.hLr);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      overridePendingTransition(2130771986, 2130771986);
      AppMethodBeat.o(128548);
      return;
    }
    aQU();
    AppMethodBeat.o(128548);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128539);
    super.onCreate(paramBundle);
    super.setRequestedOrientation(1);
    this.hLr = bs.bG(getIntent().getStringExtra("country_name"), "");
    this.countryCode = az.aLd(bs.bG(getIntent().getStringExtra("couttry_code"), ""));
    this.iRg = bs.nullAsNil(getIntent().getStringExtra("iso_code"));
    this.iGW = bs.bG(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.iVP = getIntent().getStringExtra("register_title");
    this.iVr = getIntent().getStringExtra("register_nick_name");
    this.iVS = getIntent().getStringExtra("register_avatar");
    this.iVQ = getIntent().getStringExtra("third_app_token");
    this.iUb = getIntent().getIntExtra("reg_3d_app_type", 0);
    initView();
    AppMethodBeat.o(128539);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128551);
    com.tencent.mm.plugin.normsg.a.b.vor.aor("ie_reg");
    if (this.iVU != null) {
      this.iVU.dismiss();
    }
    this.iQO.aHZ();
    super.onDestroy();
    AppMethodBeat.o(128551);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128543);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      aOO();
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
    if (this.iJi != null) {
      this.iJi.dismiss();
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.iQA);
    com.tencent.mm.kernel.g.agi().b(701, this);
    com.tencent.mm.kernel.g.agi().b(252, this);
    com.tencent.mm.kernel.g.agi().b(145, this);
    com.tencent.mm.kernel.g.agi().b(132, this);
    com.tencent.mm.kernel.g.agi().b(755, this);
    com.tencent.mm.kernel.g.agi().b(252, this);
    com.tencent.mm.kernel.g.agi().b(701, this);
    com.tencent.mm.plugin.b.a.IK("RE200_100");
    AppMethodBeat.o(128541);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(169153);
    if (paramInt == 34)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        com.tencent.mm.plugin.account.a.a.iyy.s(this);
        AppMethodBeat.o(169153);
      }
    }
    else {
      this.iSu.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(169153);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128540);
    com.tencent.mm.sdk.b.a.GpY.c(this.iQA);
    super.onResume();
    com.tencent.mm.kernel.g.agi().a(701, this);
    com.tencent.mm.kernel.g.agi().a(252, this);
    com.tencent.mm.kernel.g.agi().a(145, this);
    com.tencent.mm.kernel.g.agi().a(132, this);
    com.tencent.mm.kernel.g.agi().a(755, this);
    com.tencent.mm.kernel.g.agi().a(252, this);
    com.tencent.mm.kernel.g.agi().a(701, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",RE200_100,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("RE200_100") + ",1");
    this.iTc = 0;
    AppMethodBeat.o(128540);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128549);
    ac.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iJi != null)
    {
      this.iJi.dismiss();
      this.iJi = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.l(this, 2131755266, 2131762275);
      AppMethodBeat.o(128549);
      return;
    }
    if (paramn.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramn).Js();
      if (i == 12)
      {
        if ((paramInt2 == -41) || (paramInt2 == -59))
        {
          paramString = com.tencent.mm.h.a.rM(paramString);
          if (paramString != null)
          {
            paramString.a(this, null, null);
            AppMethodBeat.o(128549);
            return;
          }
          com.tencent.mm.ui.base.h.l(this, 2131762328, 2131762329);
          AppMethodBeat.o(128549);
          return;
        }
        this.iTD = az.aLc(this.iTD);
        this.iTb = (this.iVH + this.iTD);
        this.iTi = ((com.tencent.mm.modelfriend.a)paramn).aEF();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramn = ((com.tencent.mm.modelfriend.a)paramn).aEt();
          if (!bs.isNullOrNil(paramn)) {
            this.iTD = paramn.trim();
          }
          com.tencent.mm.plugin.b.a.IK("RE200_100");
          paramn = new StringBuilder();
          com.tencent.mm.kernel.g.agP();
          paramn = paramn.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",RE200_200,");
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("RE200_200") + ",1");
          paramString = com.tencent.mm.h.a.rM(paramString);
          if (paramString != null)
          {
            paramString.a(this, new RegByMobileRegAIOUI.9(this), new RegByMobileRegAIOUI.10(this));
            AppMethodBeat.o(128549);
            return;
          }
          aRf();
          com.tencent.mm.plugin.b.a.IL("RE200_250");
          AppMethodBeat.o(128549);
          return;
        }
        if (paramInt2 == -355)
        {
          y.g(this, paramString, 30846);
          this.iQO.dXB = this.iUb;
          this.iQO.dCQ = 5L;
          this.iQO.aHZ();
          AppMethodBeat.o(128549);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.c(this, getString(2131756462), "", true);
          AppMethodBeat.o(128549);
          return;
        }
        if (com.tencent.mm.plugin.account.a.a.iyy.a(this, paramInt1, paramInt2, paramString))
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
        i = ((com.tencent.mm.modelfriend.a)paramn).aEu();
        if (i != 2) {
          break label838;
        }
        localObject1 = ((com.tencent.mm.modelfriend.a)paramn).aEx();
        if (localObject1 != null)
        {
          ac.i("MicroMsg.RegByMobileRegAIOUI", "network check url %s", new Object[] { ((bxk)localObject1).url });
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Key_Seq", ((bxk)localObject1).iVp);
          ((Intent)localObject2).putExtra("Key_Url", ((bxk)localObject1).url);
          ((Intent)localObject2).putExtra("Key_CountryCode", this.iVH);
          ((Intent)localObject2).putExtra("Key_Mobile", this.iTD);
          ((Intent)localObject2).putExtra("Key_reg_sessionId", this.iTi);
          ((Intent)localObject2).putExtra("kintent_nickname", this.iVM.getText().toString());
          ((Intent)localObject2).putExtra("kintent_password", this.iVK.getText().toString());
          ((Intent)localObject2).putExtra("kintent_hasavatar", this.iVt);
          ((Intent)localObject2).setClass(this, RegByMobileAutoVerifyUI.class);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      while (com.tencent.mm.plugin.account.a.a.iyy.a(this, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128549);
        return;
        label838:
        if (i == 1)
        {
          localObject1 = this.iVH + this.iTD;
          localObject2 = ((com.tencent.mm.modelfriend.a)paramn).aEw();
          String str = ((com.tencent.mm.modelfriend.a)paramn).aEv();
          Intent localIntent = new Intent(this, RegByMobileSendSmsUI.class);
          localIntent.putExtra("regsession_id", this.iTi);
          localIntent.putExtra("key_reg_style", 1);
          localIntent.putExtra("from_mobile", (String)localObject1);
          localIntent.putExtra("to_mobile", (String)localObject2);
          localIntent.putExtra("verify_code", str);
          localIntent.putExtra("kintent_nickname", this.iVM.getText().toString());
          localIntent.putExtra("kintent_password", this.iVK.getText().toString());
          localIntent.putExtra("kintent_hasavatar", this.iVt);
          localIntent.putExtra("reg_3d_app_type", this.iUb);
          localIntent.putExtra("reg_3d_app_ticket", this.iVR);
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileRegAIOUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          this.iVW = ((com.tencent.mm.modelfriend.a)paramn).aEz();
          this.iVX = ((com.tencent.mm.modelfriend.a)paramn).aEA();
          this.iVY = ((com.tencent.mm.modelfriend.a)paramn).aEB();
          this.iVZ = ((com.tencent.mm.modelfriend.a)paramn).aEC();
          aRh();
        }
      }
      label1170:
      if (paramInt2 == -41)
      {
        com.tencent.mm.ui.base.h.l(this, 2131762328, 2131762329);
        AppMethodBeat.o(128549);
        return;
      }
      if (paramInt2 == -34)
      {
        com.tencent.mm.ui.base.h.c(this, getString(2131756462), "", true);
        AppMethodBeat.o(128549);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.iyy.a(this, paramInt1, paramInt2, paramString))
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
        if (((i)localObject1).rr.hvs.hvw == null) {
          break label1612;
        }
      }
    }
    label1612:
    for (Object localObject1 = ((dhd)((i)localObject1).rr.hvs.hvw).FmU;; localObject1 = "")
    {
      this.iVR = ((String)localObject1);
      GJ(this.iVH + this.iTD);
      break;
      if (paramInt2 != -7) {
        break;
      }
      this.iQO.dXB = this.iUb;
      this.iQO.dCQ = 7L;
      this.iQO.aHZ();
      com.tencent.mm.ui.base.h.a(this, getString(2131758800), getString(2131755906), getString(2131760075), getString(2131755691), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(128524);
          RegByMobileRegAIOUI.w(RegByMobileRegAIOUI.this);
          RegByMobileRegAIOUI.y(RegByMobileRegAIOUI.this).dXB = RegByMobileRegAIOUI.x(RegByMobileRegAIOUI.this);
          RegByMobileRegAIOUI.y(RegByMobileRegAIOUI.this).dCQ = 8L;
          RegByMobileRegAIOUI.y(RegByMobileRegAIOUI.this).aHZ();
          AppMethodBeat.o(128524);
        }
      }, null);
      break;
      if (((paramn.getType() != 701) && (paramn.getType() != 252)) || (paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
      this.iQO.dXB = this.iUb;
      this.iQO.dCQ = 12L;
      this.iQO.aHZ();
      com.tencent.mm.plugin.account.friend.a.l.aPH();
      y.FH(u.axw());
      t.cW(this);
      y.showAddrBookUploadConfirm(this, new RegByMobileRegAIOUI.13(this), false, 2);
      AppMethodBeat.o(128549);
      return;
      if ((paramn.getType() == 252) || (paramn.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.rM(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI
 * JD-Core Version:    0.7.0.1
 */