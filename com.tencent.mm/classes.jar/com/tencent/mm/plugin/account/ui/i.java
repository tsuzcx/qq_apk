package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;

public final class i
  implements f, MobileInputUI.b
{
  private SecurityImage fex = null;
  private MobileInputUI fnW;
  private g foc = null;
  
  public final void a(MobileInputUI.a parama)
  {
    switch (i.3.fob[parama.ordinal()])
    {
    default: 
      return;
    }
    this.fnW.foC = ar.Zv(this.fnW.countryCode);
    this.fnW.foD = this.fnW.fop.getText().toString();
    parama = ar.Zt(this.fnW.foC + this.fnW.foD);
    MobileInputUI localMobileInputUI1 = this.fnW;
    MobileInputUI localMobileInputUI2 = this.fnW;
    this.fnW.getString(q.j.app_tip);
    localMobileInputUI1.fev = h.b(localMobileInputUI2, this.fnW.getString(q.j.regbyfacebook_reg_setpwd_exiting), true, new i.2(this));
    parama = new com.tencent.mm.modelfriend.a(parama, 13, "", 0, "");
    com.tencent.mm.kernel.g.Dk().a(parama, 0);
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    this.fnW = paramMobileInputUI;
    paramMobileInputUI.fbR.setVisibility(0);
    paramMobileInputUI.foo.setVisibility(0);
    paramMobileInputUI.fop.requestFocus();
    paramMobileInputUI.fou.setText(q.j.app_nextstep);
    paramMobileInputUI.fou.setVisibility(0);
    paramMobileInputUI.fox.setVisibility(0);
    paramMobileInputUI.foz.setText(q.j.login_by_other_account);
    paramMobileInputUI.foz.setVisibility(0);
    paramMobileInputUI.foz.setOnClickListener(new i.1(this, paramMobileInputUI));
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fnW.fev != null)
    {
      this.fnW.fev.dismiss();
      this.fnW.fev = null;
    }
    if ((paramm.getType() == 701) && (this.foc != null))
    {
      this.foc.fnK = this.fnW.fnK;
      this.foc.a(this.fnW, paramInt1, paramInt2, paramString, paramm);
    }
    while ((paramm.getType() != 145) || (((com.tencent.mm.modelfriend.a)paramm).rN() != 13)) {
      return;
    }
    if (paramInt2 == -41)
    {
      paramString = com.tencent.mm.i.a.eI(paramString);
      if (paramString != null)
      {
        paramString.a(this.fnW, null, null);
        return;
      }
      h.h(this.fnW, q.j.regbymobile_reg_mobile_format_err_msg, q.j.regbymobile_reg_mobile_format_err_title);
      return;
    }
    if (paramInt2 == -1)
    {
      Toast.makeText(this.fnW, this.fnW.getString(q.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      return;
    }
    if (paramInt2 == -34)
    {
      h.b(this.fnW, this.fnW.getString(q.j.bind_mcontact_err_freq_limit), "", true);
      return;
    }
    this.fnW.XM();
    paramString = new Intent(this.fnW, MobileInputUI.class);
    paramString.putExtra("mobile_input_purpose", -1);
    paramString.putExtra("mobile_auth_type", 7);
    paramString.putExtra("from_switch_account", this.fnW.fnH);
    paramString.putExtra("couttry_code", this.fnW.countryCode);
    paramString.putExtra("input_mobile_number", this.fnW.foD);
    this.fnW.startActivity(paramString);
  }
  
  public final void start()
  {
    com.tencent.mm.kernel.g.Dk().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.DN();
    com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.qi("L200_100");
  }
  
  public final void stop()
  {
    com.tencent.mm.kernel.g.Dk().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("L200_100") + ",2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i
 * JD-Core Version:    0.7.0.1
 */