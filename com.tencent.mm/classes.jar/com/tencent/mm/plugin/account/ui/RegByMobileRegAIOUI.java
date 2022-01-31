package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.at.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.chk;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;

public class RegByMobileRegAIOUI
  extends MMActivity
  implements f
{
  private String countryCode = null;
  private ImageView doU;
  private String esg = null;
  private LinearLayout fbR;
  private TextView fbT;
  private String fbX = null;
  private String fcX;
  private com.tencent.mm.ui.base.p fev;
  private int fhr;
  private com.tencent.mm.ui.widget.a.c fiN = null;
  private ProgressBar fiX;
  private ah fjc = new RegByMobileRegAIOUI.15(this);
  private com.tencent.mm.sdk.b.c flH = new RegByMobileRegAIOUI.1(this);
  private ResizeLayout fmH;
  private String fml = null;
  private final int fnL = 128;
  private String fnX;
  private String fnY;
  private int fnZ = 0;
  private boolean foB = true;
  private String foD = null;
  private String fog;
  private TextView fos;
  private Button fou;
  private s.a fqA = new RegByMobileRegAIOUI.16(this);
  private int fqB;
  private int fqC;
  private boolean fqD;
  private boolean fqE;
  private EditText fqm;
  private MMFormInputView fqn;
  private String fqo = null;
  private MMFormInputView fqp;
  private boolean fqq = false;
  private ImageView fqr;
  private MMFormInputView fqs;
  private boolean fqt;
  private boolean fqu;
  private ScrollView fqv;
  private boolean fqw = false;
  private boolean fqx = true;
  private s fqy;
  private boolean fqz = false;
  private int progress = 0;
  
  private void Wc()
  {
    com.tencent.mm.plugin.b.a.qj(this.fcX);
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",RE200_100,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("RE200_100") + ",2");
    finish();
    overridePendingTransition(q.a.anim_not_change, q.a.anim_not_change);
  }
  
  private void XU()
  {
    if ((!bk.bl(this.esg)) && (!bk.bl(this.countryCode)))
    {
      this.fbT.setText(ar.gf(this.esg, this.countryCode));
      return;
    }
    this.fbT.setText(getString(q.j.mobile_code_error));
  }
  
  private void Yd()
  {
    getString(q.j.app_tip);
    this.fev = com.tencent.mm.ui.base.h.b(this, getString(q.j.regbyfacebook_reg_setpwd_exiting), true, new RegByMobileRegAIOUI.14(this));
    com.tencent.mm.modelfriend.a locala = new com.tencent.mm.modelfriend.a(this.fqo + this.foD, 14, "", 0, "");
    locala.lS(this.fog);
    g.Dk().a(locala, 0);
  }
  
  private boolean Ye()
  {
    if (bk.bl(this.countryCode)) {}
    for (int i = 0;; i = 1)
    {
      if (this.fqu) {}
      for (boolean bool = i & a(new Editable[] { this.fqm.getText(), this.fqp.getText(), this.fqs.getText() }); bool; bool = i & a(new Editable[] { this.fqm.getText(), this.fqs.getText() }))
      {
        this.fou.setEnabled(true);
        return bool;
      }
      this.fou.setEnabled(false);
      return bool;
    }
  }
  
  private boolean a(Editable... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      Editable localEditable = paramVarArgs[i];
      if ((localEditable != null) && (localEditable.toString().length() != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((i != 0) && (this.foB))
      {
        return true;
        i += 1;
        break;
      }
      return false;
    }
  }
  
  private void qc(String paramString)
  {
    if ((this.fqu) && (!com.tencent.mm.plugin.account.a.b.a.K(this, this.fqp.getText().toString()))) {
      return;
    }
    if (this.fev != null) {
      this.fev.dismiss();
    }
    getString(q.j.app_tip);
    this.fev = com.tencent.mm.ui.base.h.b(this, getString(q.j.regbyfacebook_reg_setpwd_exiting), true, new RegByMobileRegAIOUI.10(this));
    if (this.fhr == 0)
    {
      Object localObject = ar.Zt(this.fqm.getText().toString().trim());
      int i;
      if ((this.fnX != null) && (this.fnY != null) && (!((String)localObject).equals(this.fnX)) && (((String)localObject).equals(this.fnY))) {
        i = 1;
      }
      for (;;)
      {
        paramString = new com.tencent.mm.modelfriend.a(paramString, 12, "", 0, "");
        paramString.ix(this.fnZ);
        paramString.iy(i);
        if (com.tencent.mm.plugin.normsg.a.b.mGK.JY("ie_reg")) {
          com.tencent.mm.plugin.normsg.a.b.mGK.JX("ie_reg");
        }
        localObject = new chk();
        ((chk)localObject).tWg = new bmk().bs(com.tencent.mm.plugin.normsg.a.b.mGK.JZ("ie_reg"));
        ((chk)localObject).tWh = new bmk().bs(com.tencent.mm.plugin.normsg.a.b.mGK.Kc("ce_reg"));
        ((chk)localObject).tWi = new bmk().bs(com.tencent.mm.plugin.normsg.a.b.mGK.vq(6));
        paramString.a((chk)localObject);
        g.Dk().a(paramString, 0);
        this.fnX = ar.Zt(this.fqm.getText().toString().trim());
        this.fnZ += 1;
        return;
        if ((this.fnX != null) && (this.fnY != null) && (!this.fnY.equals(this.fnX)) && (!((String)localObject).equals(this.fnY))) {
          i = 2;
        } else {
          i = 0;
        }
      }
    }
    throw new IllegalArgumentException("NO IMPLEMENT");
  }
  
  private void qd(String paramString)
  {
    try
    {
      if (this.fqy != null)
      {
        this.fqy.Yy();
        this.fqy = null;
      }
      if (!this.fqz)
      {
        this.fqz = true;
        finish();
        Intent localIntent = new Intent();
        localIntent.putExtra("bindmcontact_mobile", this.fqo + " " + this.fqm.getText().toString());
        localIntent.putExtra("bindmcontact_shortmobile", this.foD);
        localIntent.putExtra("country_name", this.esg);
        localIntent.putExtra("couttry_code", this.countryCode);
        localIntent.putExtra("login_type", this.fhr);
        localIntent.putExtra("mobileverify_countdownsec", this.fqB);
        localIntent.putExtra("mobileverify_countdownstyle", this.fqC);
        localIntent.putExtra("mobileverify_fb", this.fqD);
        localIntent.putExtra("mobileverify_reg_qq", this.fqE);
        localIntent.putExtra("kintent_nickname", this.fqs.getText().toString());
        localIntent.putExtra("kintent_password", this.fqp.getText().toString());
        localIntent.putExtra("kintent_hasavatar", this.fqq);
        localIntent.putExtra("key_reg_style", 1);
        localIntent.putExtra("regsession_id", this.fog);
        localIntent.putExtra("mobile_verify_purpose", 2);
        if ((paramString != null) && (paramString.length() > 0)) {
          localIntent.putExtra("MicroMsg.MobileVerifyUIIntent_sms_code", paramString);
        }
        a(MobileVerifyUI.class, localIntent);
      }
      return;
    }
    finally {}
  }
  
  protected final int getLayoutId()
  {
    return q.g.regbymobile_reg_aio;
  }
  
  protected final void initView()
  {
    this.fbR = ((LinearLayout)findViewById(q.f.country_code_ll));
    this.fbT = ((TextView)findViewById(q.f.country_name));
    this.fqn = ((MMFormInputView)findViewById(q.f.regbymobilereg_mobile_input_view));
    this.fqn.setInputType(3);
    this.fqm = this.fqn.getContentEditText();
    this.fos = ((TextView)findViewById(q.f.agree_text));
    this.fou = ((Button)findViewById(q.f.reg_next));
    this.doU = ((ImageView)findViewById(q.f.setinfo_avatar));
    this.fqr = ((ImageView)findViewById(q.f.setinfo_camera));
    this.fqp = ((MMFormInputView)findViewById(q.f.regbymobile_setpassword_container));
    com.tencent.mm.ui.tools.a.c.d(this.fqp.getContentEditText()).Ig(16).a(null);
    this.fqv = ((ScrollView)findViewById(q.f.scrollView));
    this.fmH = ((ResizeLayout)findViewById(q.f.resize_lv));
    this.fqs = ((MMFormInputView)findViewById(q.f.reg_nick_input_view));
    this.fmH.setOnSizeChanged(new RegByMobileRegAIOUI.12(this));
    this.fqu = true;
    this.fqt = true;
    Object localObject = getString(q.j.license_agree_text);
    String str1;
    String str2;
    String str3;
    Spannable localSpannable;
    if (x.cqG())
    {
      str1 = getString(q.j.license_detail);
      str2 = getString(q.j.privacy_detail);
      str3 = getString(q.j.and);
      localSpannable = Spannable.Factory.getInstance().newSpannable((String)localObject + "  " + str1 + str3 + str2);
      localSpannable.setSpan(new RegByMobileRegAIOUI.18(this), ((String)localObject).length() + "  ".length(), ((String)localObject).length() + str1.length() + "  ".length(), 33);
      localSpannable.setSpan(new RegByMobileRegAIOUI.19(this), ((String)localObject).length() + "  ".length() + str1.length() + str3.length(), ((String)localObject).length() + "  ".length() + str1.length() + str3.length() + str2.length(), 33);
      this.fos.setText(localSpannable);
      this.fos.setMovementMethod(LinkMovementMethod.getInstance());
      localObject = new boolean[1];
      localObject[0] = 1;
      this.fqm.addTextChangedListener(new RegByMobileRegAIOUI.22(this, (boolean[])localObject));
      this.fqm.setOnFocusChangeListener(new RegByMobileRegAIOUI.23(this, (boolean[])localObject));
      this.fqp.addTextChangedListener(new RegByMobileRegAIOUI.24(this));
      this.fqs.addTextChangedListener(new RegByMobileRegAIOUI.2(this));
      this.fou.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            return false;
            com.tencent.mm.plugin.normsg.a.b.mGK.ei("ce_reg", "<Reg>");
            continue;
            com.tencent.mm.plugin.normsg.a.b.mGK.a("ce_reg", paramAnonymousMotionEvent);
            com.tencent.mm.plugin.normsg.a.b.mGK.Ka("ce_reg");
          }
        }
      });
      this.fou.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = com.tencent.mm.ui.tools.a.c.d(RegByMobileRegAIOUI.i(RegByMobileRegAIOUI.this).getContentEditText()).fJ(1, 32);
          paramAnonymousView.wfM = true;
          paramAnonymousView.a(new RegByMobileRegAIOUI.4.1(this));
        }
      });
      this.fou.setEnabled(false);
      if (!bk.bl(this.countryCode)) {
        break label1026;
      }
      this.esg = getString(q.j.country_normal_name);
      this.countryCode = ar.Zu(getString(q.j.country_normal_code));
      label569:
      if ((bk.bl(this.esg)) || (bk.bl(this.countryCode)))
      {
        this.fml = ((TelephonyManager)getSystemService("phone")).getSimCountryIso();
        y.i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + this.fml);
        if (!bk.bl(this.fml)) {
          break label1048;
        }
        y.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
      }
      label651:
      XU();
      if ((this.fbX == null) || (this.fbX.equals(""))) {
        break label1099;
      }
      this.fqm.setText(this.fbX);
    }
    for (;;)
    {
      this.fbR.setOnClickListener(new RegByMobileRegAIOUI.6(this));
      setBackBtn(new RegByMobileRegAIOUI.7(this), q.i.actionbar_icon_close_black);
      this.doU.setOnClickListener(new RegByMobileRegAIOUI.8(this));
      g.DS().a(new RegByMobileRegAIOUI.9(this));
      localObject = "";
      if (com.tencent.mm.protocal.d.spd) {
        localObject = getString(q.j.app_name) + getString(q.j.alpha_version_alpha);
      }
      setMMTitle((String)localObject);
      ta(getResources().getColor(q.c.normal_actionbar_color));
      czo();
      if (com.tencent.mm.compatible.util.d.gF(23))
      {
        getWindow().setStatusBarColor(getResources().getColor(q.c.navpage));
        czk();
      }
      return;
      str1 = getString(q.j.license_terms_of_service);
      str2 = getString(q.j.license_privacy_policy);
      str3 = getString(q.j.and);
      localSpannable = Spannable.Factory.getInstance().newSpannable((String)localObject + "  " + str1 + str3 + str2);
      localSpannable.setSpan(new RegByMobileRegAIOUI.20(this), ((String)localObject).length() + "  ".length(), ((String)localObject).length() + "  ".length() + str1.length(), 33);
      localSpannable.setSpan(new RegByMobileRegAIOUI.21(this), ((String)localObject).length() + str1.length() + "  ".length() + str3.length(), ((String)localObject).length() + str1.length() + "  ".length() + str3.length() + str2.length(), 33);
      this.fos.setText(localSpannable);
      break;
      label1026:
      this.esg = com.tencent.mm.at.b.j(this, this.countryCode, getString(q.j.country_code));
      break label569;
      label1048:
      localObject = com.tencent.mm.at.b.i(this, this.fml, getString(q.j.country_code));
      if (localObject == null)
      {
        y.e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
        break label651;
      }
      this.esg = ((b.a)localObject).esg;
      this.countryCode = ((b.a)localObject).esf;
      break label651;
      label1099:
      g.DS().a(new RegByMobileRegAIOUI.5(this));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 30846) {
      if ((paramInt2 == -1) && (Ye()))
      {
        Yd();
        com.tencent.mm.plugin.b.a.qj("RE200_250");
        this.fqw = false;
      }
    }
    do
    {
      return;
      if (paramInt1 == 30847)
      {
        Bundle localBundle = null;
        if (paramIntent != null) {
          localBundle = paramIntent.getBundleExtra("result_data");
        }
        if ((localBundle != null) && (localBundle.getString("go_next", "").equals("agree_privacy")))
        {
          com.tencent.mm.plugin.report.service.h.nFQ.a(712L, 2L, 1L, false);
          this.fqx = false;
          qc(this.fqo + this.foD);
          return;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.a(712L, 1L, 1L, false);
        return;
      }
      switch (paramInt2)
      {
      default: 
        paramIntent = com.tencent.mm.plugin.account.a.a.eUS.a(this, paramInt1, paramInt2, paramIntent);
      }
    } while (paramIntent == null);
    this.doU.setImageBitmap(paramIntent);
    this.fqq = true;
    this.fqr.setVisibility(8);
    return;
    this.esg = bk.aM(paramIntent.getStringExtra("country_name"), "");
    this.countryCode = bk.aM(paramIntent.getStringExtra("couttry_code"), "");
    this.fml = bk.aM(paramIntent.getStringExtra("iso_code"), "");
    if (com.tencent.mm.at.b.mD(this.countryCode))
    {
      paramIntent = new Intent(this, MobileInputUI.class);
      paramIntent.putExtra("mobile_input_purpose", 2);
      paramIntent.putExtra("couttry_code", this.countryCode);
      paramIntent.putExtra("country_name", this.esg);
      startActivity(paramIntent);
      finish();
      overridePendingTransition(q.a.anim_not_change, q.a.anim_not_change);
      return;
    }
    XU();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.esg = bk.aM(getIntent().getStringExtra("country_name"), "");
    this.countryCode = ar.Zu(bk.aM(getIntent().getStringExtra("couttry_code"), ""));
    this.fml = bk.pm(getIntent().getStringExtra("iso_code"));
    this.fbX = bk.aM(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
    this.fhr = getIntent().getIntExtra("login_type", 0);
    initView();
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.plugin.normsg.a.b.mGK.JX("ie_reg");
    if (this.fqy != null)
    {
      this.fqy.Yy();
      this.fqy = null;
    }
    if (this.fiN != null) {
      this.fiN.dismiss();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      Wc();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.fev != null) {
      this.fev.dismiss();
    }
    com.tencent.mm.sdk.b.a.udP.d(this.flH);
    g.Dk().b(701, this);
    g.Dk().b(145, this);
    g.Dk().b(132, this);
    com.tencent.mm.plugin.b.a.qi("RE200_100");
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i;
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      if (paramArrayOfInt == null)
      {
        i = -1;
        y.w("MicroMsg.RegByMobileRegAIOUI", "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), paramArrayOfString, bk.csb() });
      }
    }
    do
    {
      return;
      i = paramArrayOfInt.length;
      break;
      y.i("MicroMsg.RegByMobileRegAIOUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramArrayOfInt[0] != 0) || (this.fqy == null));
    this.fqy.Xt();
  }
  
  public void onResume()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.flH);
    super.onResume();
    g.Dk().a(701, this);
    g.Dk().a(145, this);
    g.Dk().a(132, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",RE200_100,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("RE200_100") + ",1");
    this.fnZ = 0;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fev != null)
    {
      this.fev.dismiss();
      this.fev = null;
    }
    if (paramInt2 == -75) {
      com.tencent.mm.ui.base.h.h(this, q.j.alpha_version_tip_reg, q.j.reg_username_exist_title);
    }
    label656:
    label934:
    label946:
    do
    {
      Object localObject1;
      Object localObject2;
      do
      {
        int i;
        do
        {
          return;
          if (paramm.getType() != 145) {
            break label656;
          }
          i = ((com.tencent.mm.modelfriend.a)paramm).rN();
          if (i != 12) {
            break;
          }
          if ((paramInt2 == -41) || (paramInt2 == -59))
          {
            paramString = com.tencent.mm.i.a.eI(paramString);
            if (paramString != null)
            {
              paramString.a(this, null, null);
              return;
            }
            com.tencent.mm.ui.base.h.h(this, q.j.regbymobile_reg_mobile_format_err_msg, q.j.regbymobile_reg_mobile_format_err_title);
            return;
          }
          this.foD = ar.Zt(this.foD);
          this.fnY = (this.fqo + this.foD);
          this.fog = ((com.tencent.mm.modelfriend.a)paramm).NW();
          if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
          {
            paramm = ((com.tencent.mm.modelfriend.a)paramm).NL();
            if (!bk.bl(paramm)) {
              this.foD = paramm.trim();
            }
            com.tencent.mm.plugin.b.a.qi("RE200_100");
            paramm = new StringBuilder();
            g.DN();
            paramm = paramm.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",RE200_200,");
            g.DN();
            com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("RE200_200") + ",1");
            paramString = com.tencent.mm.i.a.eI(paramString);
            if (paramString != null)
            {
              paramString.a(this, new RegByMobileRegAIOUI.11(this), new RegByMobileRegAIOUI.13(this));
              return;
            }
            Yd();
            com.tencent.mm.plugin.b.a.qj("RE200_250");
            this.fqw = false;
            return;
          }
          if (paramInt2 == -355)
          {
            z.e(this, paramString, 30846);
            return;
          }
          if (paramInt2 == -34)
          {
            com.tencent.mm.ui.base.h.b(this, getString(q.j.bind_mcontact_err_freq_limit), "", true);
            return;
          }
        } while (com.tencent.mm.plugin.account.a.a.eUS.a(this, paramInt1, paramInt2, paramString));
        Toast.makeText(this, getString(q.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        if (i == 14)
        {
          if ((paramInt2 != 0) && (paramString != null)) {
            break label946;
          }
          if (((com.tencent.mm.modelfriend.a)paramm).NM() != 1) {
            break;
          }
          localObject1 = this.fqo + this.foD;
          localObject2 = ((com.tencent.mm.modelfriend.a)paramm).NO();
          String str = ((com.tencent.mm.modelfriend.a)paramm).NN();
          Intent localIntent = new Intent(this, RegByMobileSendSmsUI.class);
          localIntent.putExtra("regsession_id", this.fog);
          localIntent.putExtra("key_reg_style", 1);
          localIntent.putExtra("from_mobile", (String)localObject1);
          localIntent.putExtra("to_mobile", (String)localObject2);
          localIntent.putExtra("verify_code", str);
          localIntent.putExtra("kintent_nickname", this.fqs.getText().toString());
          localIntent.putExtra("kintent_password", this.fqp.getText().toString());
          localIntent.putExtra("kintent_hasavatar", this.fqq);
          startActivity(localIntent);
        }
        if ((com.tencent.mm.plugin.account.a.a.eUS.a(this, paramInt1, paramInt2, paramString)) || (paramm.getType() != 701)) {
          break label934;
        }
        paramString = com.tencent.mm.i.a.eI(paramString);
      } while ((paramString == null) || (!paramString.a(this, null, null)));
      return;
      this.fqB = ((com.tencent.mm.modelfriend.a)paramm).NQ();
      this.fqC = ((com.tencent.mm.modelfriend.a)paramm).NR();
      this.fqD = ((com.tencent.mm.modelfriend.a)paramm).NS();
      this.fqE = ((com.tencent.mm.modelfriend.a)paramm).NT();
      if (this.fqy == null)
      {
        this.fqy = new s(this, this.fqA);
        this.fqy.Yx();
      }
      if (this.fiN == null)
      {
        localObject1 = ((LayoutInflater)getSystemService("layout_inflater")).inflate(q.g.reg_mobile_verify_progress_dialog_view, null);
        this.fiX = ((ProgressBar)((View)localObject1).findViewById(q.f.progress_dialog_bar));
        localObject2 = (TextView)((View)localObject1).findViewById(q.f.verify_mobile_number);
        this.fiN = com.tencent.mm.ui.base.h.a(this, false, getString(q.j.bind_mcontact_title_bind), (View)localObject1, "", "", null, null);
        this.fqo = ar.Zv(this.countryCode);
        ((TextView)localObject2).setText(this.fqo + " " + this.fqm.getText().toString());
      }
      for (;;)
      {
        this.progress = 0;
        this.fiX.setIndeterminate(false);
        this.fjc.sendEmptyMessage(10);
        break label656;
        break;
        this.fiN.show();
      }
      if (paramInt2 == -41)
      {
        com.tencent.mm.ui.base.h.h(this, q.j.regbymobile_reg_mobile_format_err_msg, q.j.regbymobile_reg_mobile_format_err_title);
        return;
      }
      if (paramInt2 == -34)
      {
        com.tencent.mm.ui.base.h.b(this, getString(q.j.bind_mcontact_err_freq_limit), "", true);
        return;
      }
    } while (com.tencent.mm.plugin.account.a.a.eUS.a(this, paramInt1, paramInt2, paramString));
    Toast.makeText(this, getString(q.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI
 * JD-Core Version:    0.7.0.1
 */