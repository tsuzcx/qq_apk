package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.model.i;
import com.tencent.mm.plugin.account.model.i.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.chk;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

public final class k
  implements f, MobileInputUI.b
{
  private MobileInputUI fnW;
  private String fnX;
  private String fnY;
  private int fnZ = 0;
  private String fog;
  int foh = 1;
  
  private void XR()
  {
    Object localObject = this.fnW;
    MobileInputUI localMobileInputUI = this.fnW;
    this.fnW.getString(q.j.app_tip);
    ((MobileInputUI)localObject).fev = h.b(localMobileInputUI, this.fnW.getString(q.j.regbyfacebook_reg_setpwd_exiting), true, new k.10(this));
    localObject = new com.tencent.mm.modelfriend.a(this.fnW.foC + this.fnW.foD, 14, "", 0, "");
    ((com.tencent.mm.modelfriend.a)localObject).lS(this.fog);
    g.Dk().a((m)localObject, 0);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    switch (k.2.fob[parama.ordinal()])
    {
    default: 
      return;
    }
    this.fnW.XM();
    switch (this.foh)
    {
    default: 
      this.fnW.foC = ar.Zv(this.fnW.countryCode);
      this.fnW.foD = this.fnW.foo.getText().toString();
      parama = this.fnW.foC + this.fnW.foD;
      if (com.tencent.mm.plugin.account.a.b.a.K(this.fnW, this.fnW.fmq.getText().toString()))
      {
        if ((this.fnW.fev == null) || (!this.fnW.fev.isShowing())) {
          break label280;
        }
        y.d("MicroMsg.MobileInputRegLogic", "already checking ");
      }
      break;
    }
    for (;;)
    {
      this.foh = 0;
      return;
      XR();
      continue;
      parama = this.fnW.getString(q.j.license_read_url, new Object[] { x.cqJ(), com.tencent.mm.at.b.k(this.fnW, this.fnW.countryCode, this.fnW.getString(q.j.country_code)), "reg", Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.plugin.account.a.b.a.b(this.fnW, parama, 32047, false);
    }
    label280:
    Object localObject = this.fnW;
    MobileInputUI localMobileInputUI = this.fnW;
    this.fnW.getString(q.j.app_tip);
    ((MobileInputUI)localObject).fev = h.b(localMobileInputUI, this.fnW.getString(q.j.regbyfacebook_reg_setpwd_exiting), true, new k.7(this));
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
      if (com.tencent.mm.plugin.normsg.a.b.mGK.JY("ie_reg_eu")) {
        com.tencent.mm.plugin.normsg.a.b.mGK.JX("ie_reg_eu");
      }
      localObject = new chk();
      ((chk)localObject).tWg = new bmk().bs(com.tencent.mm.plugin.normsg.a.b.mGK.JZ("ie_reg_eu"));
      ((chk)localObject).tWh = new bmk().bs(com.tencent.mm.plugin.normsg.a.b.mGK.Kc("ce_reg_eu"));
      ((chk)localObject).tWi = new bmk().bs(com.tencent.mm.plugin.normsg.a.b.mGK.vq(6));
      parama.a((chk)localObject);
      g.Dk().a(parama, 0);
      this.fnX = this.fnW.foo.getText().toString();
      this.fnZ += 1;
      break;
      if ((this.fnX != null) && (this.fnY != null) && (!this.fnY.equals(this.fnX)) && (!((String)localObject).equals(this.fnY))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    this.fnW = paramMobileInputUI;
    String str1 = "";
    if (d.spd) {
      str1 = "" + paramMobileInputUI.getString(q.j.alpha_version_alpha);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.showOptionMenu(false);
    paramMobileInputUI.fow.setVisibility(0);
    paramMobileInputUI.fow.setVisibility(0);
    paramMobileInputUI.fbR.setVisibility(0);
    paramMobileInputUI.foo.setVisibility(0);
    paramMobileInputUI.fop.requestFocus();
    paramMobileInputUI.jdField_for.setVisibility(0);
    paramMobileInputUI.fnC.setVisibility(0);
    paramMobileInputUI.foA.setVisibility(8);
    paramMobileInputUI.fou.setVisibility(0);
    paramMobileInputUI.fou.setText(q.j.loginby_new_mobile_reg_ok);
    if (paramMobileInputUI.fot != null) {
      paramMobileInputUI.fot.setOnClickListener(new k.1(this, paramMobileInputUI));
    }
    str1 = paramMobileInputUI.getString(q.j.license_agree_text);
    String str2;
    String str3;
    String str4;
    Spannable localSpannable;
    if (x.cqG())
    {
      str2 = paramMobileInputUI.getString(q.j.license_detail);
      str3 = paramMobileInputUI.getString(q.j.privacy_detail);
      str4 = paramMobileInputUI.getString(q.j.and);
      localSpannable = Spannable.Factory.getInstance().newSpannable(str1 + "  " + str2 + str4 + str3);
      localSpannable.setSpan(new k.3(this, paramMobileInputUI), str1.length() + "  ".length(), str1.length() + str2.length() + "  ".length(), 33);
      localSpannable.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          bk.I(paramMobileInputUI, ae.getResources().getString(q.j.license_read_url, new Object[] { x.fB(paramMobileInputUI), x.cqI(), "setting", Integer.valueOf(1), Integer.valueOf(0) }));
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          paramAnonymousTextPaint.setColor(paramMobileInputUI.getResources().getColor(q.c.link_color));
          paramAnonymousTextPaint.setUnderlineText(true);
        }
      }, str1.length() + "  ".length() + str2.length() + str4.length(), str1.length() + str2.length() + "  ".length() + str4.length() + str3.length(), 33);
      paramMobileInputUI.fos.setText(localSpannable);
    }
    for (;;)
    {
      paramMobileInputUI.fos.setMovementMethod(LinkMovementMethod.getInstance());
      return;
      str2 = paramMobileInputUI.getString(q.j.license_terms_of_service);
      str3 = paramMobileInputUI.getString(q.j.license_privacy_policy);
      str4 = paramMobileInputUI.getString(q.j.and);
      localSpannable = Spannable.Factory.getInstance().newSpannable(str1 + "  " + str2 + str4 + str3);
      localSpannable.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          bk.I(paramMobileInputUI.mController.uMN, paramMobileInputUI.getString(q.j.url_terms_of_service));
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          paramAnonymousTextPaint.setColor(paramMobileInputUI.getResources().getColor(q.c.link_color));
          paramAnonymousTextPaint.setUnderlineText(true);
        }
      }, str1.length() + "  ".length(), str1.length() + "  ".length() + str2.length(), 33);
      localSpannable.setSpan(new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          bk.I(paramMobileInputUI, ae.getResources().getString(q.j.license_read_url, new Object[] { x.fB(paramMobileInputUI), x.cqI(), "setting", Integer.valueOf(1), Integer.valueOf(0) }));
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          paramAnonymousTextPaint.setColor(paramMobileInputUI.getResources().getColor(q.c.link_color));
          paramAnonymousTextPaint.setUnderlineText(true);
        }
      }, str1.length() + str2.length() + "  ".length() + str4.length(), str1.length() + str2.length() + "  ".length() + str4.length() + str3.length(), 33);
      paramMobileInputUI.fos.setText(localSpannable);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fnW.fev != null)
    {
      this.fnW.fev.dismiss();
      this.fnW.fev = null;
    }
    if (paramInt2 == -75) {
      h.h(this.fnW, q.j.alpha_version_tip_reg, q.j.reg_username_exist_title);
    }
    while (paramm.getType() != 145) {
      return;
    }
    if ((paramInt2 == -41) || (paramInt2 == -59))
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
    int i = ((com.tencent.mm.modelfriend.a)paramm).rN();
    if (i == 12)
    {
      this.fnW.foD = ar.Zt(this.fnW.foD);
      this.fnY = (this.fnW.foC + this.fnW.foD);
      this.fog = ((com.tencent.mm.modelfriend.a)paramm).NW();
      if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
      {
        paramm = ((com.tencent.mm.modelfriend.a)paramm).NL();
        if (!bk.bl(paramm)) {
          this.fnW.foD = paramm.trim();
        }
        paramm = new StringBuilder();
        g.DN();
        paramm = paramm.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_200,");
        g.DN();
        com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R200_200") + ",1");
        paramString = com.tencent.mm.i.a.eI(paramString);
        if (paramString != null)
        {
          paramString.a(this.fnW, new DialogInterface.OnClickListener()new k.9
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              k.a(k.this);
            }
          }, new k.9(this));
          return;
        }
        XR();
        paramString = new StringBuilder();
        g.DN();
        paramString = paramString.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_200,");
        g.DN();
        com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R200_200") + ",2");
        return;
      }
      if (paramInt2 == -355)
      {
        z.e(this.fnW, paramString, 32046);
        return;
      }
      if (paramInt2 == -34)
      {
        h.b(this.fnW, this.fnW.getString(q.j.bind_mcontact_err_freq_limit), "", true);
        return;
      }
    }
    Object localObject;
    if (i == 14)
    {
      if ((paramInt2 != 0) && (paramString != null)) {
        break label987;
      }
      if (((com.tencent.mm.modelfriend.a)paramm).NM() != 1) {
        break label719;
      }
      localObject = this.fnW.foC + this.fnW.foD;
      String str = ((com.tencent.mm.modelfriend.a)paramm).NO();
      paramm = ((com.tencent.mm.modelfriend.a)paramm).NN();
      Intent localIntent = new Intent(this.fnW, RegByMobileSendSmsUI.class);
      localIntent.putExtra("from_mobile", (String)localObject);
      localIntent.putExtra("to_mobile", str);
      localIntent.putExtra("verify_code", paramm);
      localIntent.putExtra("key_reg_style", 2);
      localIntent.putExtra("kintent_password", this.fnW.fmq.getText().toString());
      localIntent.putExtra("regsession_id", this.fog);
      this.fnW.startActivity(localIntent);
    }
    label719:
    label987:
    do
    {
      for (;;)
      {
        paramString = com.tencent.mm.i.a.eI(paramString);
        if ((paramString == null) || (this.fnW == null) || (!paramString.a(this.fnW, null, null))) {
          break;
        }
        return;
        com.tencent.mm.plugin.b.a.qj("R200_300");
        localObject = new Intent();
        ((Intent)localObject).putExtra("bindmcontact_mobile", this.fnW.foC + " " + this.fnW.foo.getText().toString());
        ((Intent)localObject).putExtra("bindmcontact_shortmobile", this.fnW.foD);
        ((Intent)localObject).putExtra("country_name", this.fnW.esg);
        ((Intent)localObject).putExtra("couttry_code", this.fnW.countryCode);
        ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramm).NQ());
        ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramm).NR());
        ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramm).NS());
        ((Intent)localObject).putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramm).NT());
        ((Intent)localObject).putExtra("key_reg_style", 2);
        ((Intent)localObject).putExtra("kintent_password", this.fnW.fmq.getText().toString());
        ((Intent)localObject).putExtra("mobile_verify_purpose", 2);
        ((Intent)localObject).putExtra("regsession_id", this.fog);
        ((Intent)localObject).setClass(this.fnW, MobileVerifyUI.class);
        this.fnW.startActivity((Intent)localObject);
        i.a(i.a.fjI);
      }
      if (paramInt2 == -34)
      {
        h.b(this.fnW, this.fnW.getString(q.j.bind_mcontact_err_freq_limit), "", true);
        return;
      }
    } while (!com.tencent.mm.plugin.account.a.a.eUS.a(this.fnW, paramInt1, paramInt2, paramString));
  }
  
  public final void start()
  {
    g.Dk().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_100,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("R200_100") + ",1");
    com.tencent.mm.plugin.b.a.qi("R200_100");
    this.fnZ = 0;
  }
  
  public final void stop()
  {
    g.Dk().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_100,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R200_100") + ",2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.k
 * JD-Core Version:    0.7.0.1
 */