package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMFormInputView;

public final class h
  implements f, MobileInputUI.b
{
  private MobileInputUI fnW;
  private String fnX;
  private String fnY;
  private int fnZ = 0;
  
  private void XR()
  {
    Object localObject = this.fnW;
    MobileInputUI localMobileInputUI = this.fnW;
    this.fnW.getString(q.j.app_tip);
    ((MobileInputUI)localObject).fev = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.fnW.getString(q.j.regbyfacebook_reg_setpwd_exiting), true, new h.4(this));
    localObject = new com.tencent.mm.modelfriend.a(this.fnW.foC + this.fnW.foD, 8, "", 0, "");
    g.Dk().a((m)localObject, 0);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    switch (h.5.fob[parama.ordinal()])
    {
    default: 
      return;
    }
    this.fnW.foC = ar.Zv(this.fnW.countryCode);
    this.fnW.foD = this.fnW.foo.getText().toString();
    parama = this.fnW.foC + this.fnW.foD;
    if (this.fnW.fev != null)
    {
      y.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
      return;
    }
    Object localObject = this.fnW;
    MobileInputUI localMobileInputUI = this.fnW;
    this.fnW.getString(q.j.app_tip);
    ((MobileInputUI)localObject).fev = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.fnW.getString(q.j.regbyfacebook_reg_setpwd_exiting), true, new h.1(this));
    localObject = this.fnW.foo.getText().toString();
    int i;
    if ((this.fnX != null) && (this.fnY != null) && (!((String)localObject).equals(this.fnX)) && (((String)localObject).equals(this.fnY))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.ix(this.fnZ);
      parama.iy(i);
      g.Dk().a(parama, 0);
      this.fnX = this.fnW.foo.getText().toString();
      this.fnZ += 1;
      return;
      if ((this.fnX != null) && (this.fnY != null) && (!this.fnY.equals(this.fnX)) && (!((String)localObject).equals(this.fnY))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    this.fnW = paramMobileInputUI;
    paramMobileInputUI.fop.requestFocus();
    paramMobileInputUI.showVKB();
    String str2 = paramMobileInputUI.getString(q.j.regbymoile_reg_title);
    String str1 = str2;
    if (d.spd) {
      str1 = str2 + paramMobileInputUI.getString(q.j.alpha_version_alpha);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.fbR.setVisibility(0);
    paramMobileInputUI.foo.setVisibility(0);
    paramMobileInputUI.fop.requestFocus();
    paramMobileInputUI.fou.setText(q.j.app_nextstep);
    paramMobileInputUI.fou.setVisibility(0);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fnW.fev != null)
    {
      this.fnW.fev.dismiss();
      this.fnW.fev = null;
    }
    if (paramInt2 == -75) {
      com.tencent.mm.ui.base.h.h(this.fnW, q.j.alpha_version_tip_reg, q.j.reg_username_exist_title);
    }
    int i;
    do
    {
      do
      {
        return;
        if ((paramInt2 == -41) || (paramInt2 == -59))
        {
          paramString = com.tencent.mm.i.a.eI(paramString);
          if (paramString != null)
          {
            paramString.a(this.fnW, null, null);
            return;
          }
          com.tencent.mm.ui.base.h.h(this.fnW, q.j.regbymobile_reg_mobile_format_err_msg, q.j.regbymobile_reg_mobile_format_err_title);
          return;
        }
      } while (paramm.getType() != 145);
      i = ((com.tencent.mm.modelfriend.a)paramm).rN();
      if (i == 12)
      {
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramm = ((com.tencent.mm.modelfriend.a)paramm).NL();
          if (!bk.bl(paramm)) {
            this.fnW.foD = paramm.trim();
          }
          this.fnW.foD = ar.Zt(this.fnW.foD);
          this.fnY = (this.fnW.foC + this.fnW.foD);
          paramm = new StringBuilder();
          g.DN();
          paramm = paramm.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",F200_200,");
          g.DN();
          com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("F200_200") + ",1");
          paramString = com.tencent.mm.i.a.eI(paramString);
          if (paramString != null)
          {
            paramString.a(this.fnW, new h.2(this), new h.3(this));
            return;
          }
          XR();
          paramString = new StringBuilder();
          g.DN();
          paramString = paramString.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",F200_200,");
          g.DN();
          com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("F200_200") + ",2");
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.b(this.fnW, this.fnW.getString(q.j.bind_mcontact_err_freq_limit), "", true);
          return;
        }
        Toast.makeText(this.fnW, this.fnW.getString(q.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
    } while ((i != 8) || (paramInt2 != 0));
    paramString = new Intent();
    paramString.putExtra("bindmcontact_mobile", this.fnW.foC + " " + this.fnW.foo.getText().toString());
    paramString.putExtra("bindmcontact_shortmobile", this.fnW.foD);
    paramString.putExtra("country_name", this.fnW.esg);
    paramString.putExtra("couttry_code", this.fnW.countryCode);
    paramString.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramm).NQ());
    paramString.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramm).NR());
    paramString.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramm).NS());
    paramString.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramm).NT());
    paramString.putExtra("mobile_verify_purpose", 3);
    paramString.setClass(this.fnW, MobileVerifyUI.class);
    this.fnW.startActivity(paramString);
  }
  
  public final void start()
  {
    g.Dk().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",F200_100,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("F200_100") + ",1");
    com.tencent.mm.plugin.b.a.qi("F200_100");
    this.fnZ = 0;
  }
  
  public final void stop()
  {
    g.Dk().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",F200_100,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("F200_100") + ",2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.h
 * JD-Core Version:    0.7.0.1
 */