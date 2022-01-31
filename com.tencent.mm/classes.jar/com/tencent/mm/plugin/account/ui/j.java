package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;

public final class j
  implements f, MobileInputUI.b
{
  protected String dqS = null;
  protected String fcQ = "";
  protected int fcR = 2;
  private MobileInputUI fnW;
  
  public final void a(MobileInputUI.a parama)
  {
    switch (j.2.fob[parama.ordinal()])
    {
    default: 
      return;
    }
    this.fnW.foC = ar.Zv(this.fnW.countryCode);
    this.fnW.foD = this.fnW.foo.getText().toString();
    parama = this.fnW.foC + this.fnW.foD;
    if (this.fnW.fev != null)
    {
      y.d("MicroMsg.MobileInputRegLogic", "already checking ");
      return;
    }
    MobileInputUI localMobileInputUI1 = this.fnW;
    MobileInputUI localMobileInputUI2 = this.fnW;
    this.fnW.getString(q.j.app_tip);
    localMobileInputUI1.fev = h.b(localMobileInputUI2, this.fnW.getString(q.j.regbyfacebook_reg_setpwd_exiting), true, new j.1(this));
    parama = new x(parama, 1, "", 0, "");
    g.Dk().a(parama, 0);
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    this.fnW = paramMobileInputUI;
    paramMobileInputUI.fop.requestFocus();
    paramMobileInputUI.showVKB();
    this.dqS = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.fcQ = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.fcR = paramMobileInputUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    String str2 = paramMobileInputUI.getString(q.j.regbymoile_reg_title);
    String str1 = str2;
    if (d.spd) {
      str1 = str2 + paramMobileInputUI.getString(q.j.alpha_version_alpha);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.fbR.setVisibility(0);
    paramMobileInputUI.foo.setVisibility(0);
    paramMobileInputUI.fop.requestFocus();
    paramMobileInputUI.jdField_for.setVisibility(0);
    paramMobileInputUI.fou.setVisibility(0);
    paramMobileInputUI.fou.setText(q.j.loginby_new_mobile_reg_ok);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fnW.fev != null)
    {
      this.fnW.fev.dismiss();
      this.fnW.fev = null;
    }
    if (paramm.getType() == 132)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label275;
      }
      if (((x)paramm).rN() == 1)
      {
        paramString = new Intent();
        paramString.putExtra("bindmcontact_mobile", this.fnW.foC + " " + this.fnW.foo.getText().toString());
        paramString.putExtra("bindmcontact_shortmobile", this.fnW.foo.getText().toString());
        paramString.putExtra("country_name", this.fnW.esg);
        paramString.putExtra("couttry_code", this.fnW.countryCode);
        paramString.putExtra("mobile_verify_purpose", 4);
        paramString.putExtra("regsetinfo_ticket", this.dqS);
        paramString.putExtra("regsetinfo_NextStep", this.fcQ);
        paramString.putExtra("regsetinfo_NextStyle", this.fcR);
        paramString.setClass(this.fnW, MobileVerifyUI.class);
        this.fnW.startActivity(paramString);
        this.fnW.finish();
      }
    }
    label275:
    while (a.eUS.a(this.fnW, paramInt1, paramInt2, paramString)) {
      return;
    }
    Toast.makeText(this.fnW, this.fnW.getString(q.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
  }
  
  public final void start()
  {
    g.Dk().a(132, this);
  }
  
  public final void stop()
  {
    g.Dk().b(132, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.j
 * JD-Core Version:    0.7.0.1
 */