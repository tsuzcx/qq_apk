package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bv;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

public final class l
  implements com.tencent.mm.ah.f, MobileInputUI.b
{
  String account;
  private String caS;
  SecurityImage fex = null;
  private String fky;
  private boolean fmT = true;
  private String fnG;
  MobileInputUI fnW;
  private String foj;
  
  private void XS()
  {
    if (this.fnW.dVU == 6)
    {
      this.fnW.foq.reset();
      this.fnW.foz.setText(q.j.login_login_by_password);
      this.fnW.fnC.setVisibility(8);
      this.fnW.foq.setVisibility(0);
      this.fnW.foq.getContentEditText().requestFocus();
      this.fnW.foq.setSendSmsBtnClickListener(new l.9(this));
      this.fnW.foz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          l.this.fnW.fmY[1] = 2;
          l.this.fnW.dVU = 7;
          l.this.fnW.foq.reset();
          com.tencent.mm.kernel.g.Dk().b(145, l.this);
          l.a(l.this);
        }
      });
    }
    while (this.fnW.dVU != 7) {
      return;
    }
    this.fnW.foz.setText(q.j.login_login_by_sms);
    this.fnW.fnC.setVisibility(0);
    this.fnW.fmq.requestFocus();
    this.fnW.foq.setVisibility(8);
    this.fnW.foz.setOnClickListener(new l.11(this));
  }
  
  private void aT(String paramString1, String paramString2)
  {
    if (bk.bl(paramString1))
    {
      com.tencent.mm.ui.base.h.h(this.fnW, q.j.verify_username_null_tip, q.j.login_err_title);
      return;
    }
    if (bk.bl(paramString2))
    {
      com.tencent.mm.ui.base.h.h(this.fnW, q.j.verify_password_null_tip, q.j.login_err_title);
      return;
    }
    this.fnW.fmq.setText(paramString2);
    this.fnW.XM();
    paramString1 = new com.tencent.mm.modelsimple.q(paramString1, paramString2, null, 1);
    com.tencent.mm.kernel.g.Dk().a(paramString1, 0);
    paramString2 = this.fnW;
    MobileInputUI localMobileInputUI = this.fnW;
    this.fnW.getString(q.j.app_tip);
    paramString2.fev = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.fnW.getString(q.j.login_logining), true, new l.14(this, paramString1));
  }
  
  private boolean h(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (com.tencent.mm.plugin.account.a.a.eUS.a(this.fnW, paramInt1, paramInt2, paramString)) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramInt1 != 4);
      switch (paramInt2)
      {
      default: 
        return false;
      case -140: 
        if (!bk.bl(this.caS)) {
          z.l(this.fnW, paramString, this.caS);
        }
        return true;
      case -1: 
        bool1 = bool2;
      }
    } while (com.tencent.mm.kernel.g.Dk().KG() != 5);
    com.tencent.mm.ui.base.h.h(this.fnW, q.j.net_warn_server_down_tip, q.j.net_warn_server_down);
    return true;
    com.tencent.mm.ui.base.h.h(this.fnW, q.j.errcode_password, q.j.login_err_title);
    return true;
    com.tencent.mm.ui.base.h.h(this.fnW, q.j.login_err_mailnotverify, q.j.login_err_title);
    return true;
    com.tencent.mm.kernel.g.DN();
    com.tencent.mm.kernel.a.hold();
    MobileInputUI localMobileInputUI = this.fnW;
    com.tencent.mm.kernel.g.DN();
    if (TextUtils.isEmpty(com.tencent.mm.kernel.a.CM())) {}
    for (paramString = com.tencent.mm.cb.a.ac(this.fnW, q.j.main_err_another_place);; paramString = com.tencent.mm.kernel.a.CM())
    {
      com.tencent.mm.ui.base.h.a(localMobileInputUI, paramString, this.fnW.getString(q.j.app_tip), new l.6(this), new l.7(this));
      return true;
      com.tencent.mm.kernel.g.DN();
    }
    Toast.makeText(this.fnW, q.j.bind_mcontact_err_freq_limit, 0).show();
    return true;
    com.tencent.mm.ui.base.h.a(this.fnW, q.j.bind_mcontact_verify_error, q.j.bind_mcontact_verify_tip, null);
    return true;
    com.tencent.mm.ui.base.h.a(this.fnW, q.j.bind_mcontact_verify_err_time_out_content, q.j.bind_mcontact_verify_tip, null);
    return true;
  }
  
  public final void a(MobileInputUI.a parama)
  {
    switch (l.8.fob[parama.ordinal()])
    {
    }
    do
    {
      do
      {
        return;
        this.fnW.XM();
        this.fnW.foC = ar.Zv(this.fnW.countryCode);
        this.fnW.foD = this.fnW.fop.getText().toString();
      } while ((bk.bl(this.fnW.foC)) || (bk.bl(this.fnW.foD)));
      if (this.fnW.dVU == 7)
      {
        if (!bk.bl(this.foj))
        {
          aT(this.account, this.foj);
          return;
        }
        aT(this.account, this.fnW.fmq.getText().toString());
        return;
      }
    } while (this.fnW.dVU != 6);
    parama = this.fnW.foq.getText().toString().trim();
    if (bk.bl(parama))
    {
      com.tencent.mm.ui.base.h.h(this.fnW, q.j.verify_seccode_tip, q.j.login_err_title);
      return;
    }
    this.fnW.XM();
    parama = new com.tencent.mm.modelfriend.a(this.account, 17, parama, 0, "");
    com.tencent.mm.kernel.g.Dk().a(parama, 0);
    MobileInputUI localMobileInputUI1 = this.fnW;
    MobileInputUI localMobileInputUI2 = this.fnW;
    this.fnW.getString(q.j.app_tip);
    localMobileInputUI1.fev = com.tencent.mm.ui.base.h.b(localMobileInputUI2, this.fnW.getString(q.j.bind_mcontact_verifing), true, new l.12(this, parama));
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    this.fnW = paramMobileInputUI;
    paramMobileInputUI.fox.setVisibility(0);
    this.account = paramMobileInputUI.getIntent().getStringExtra("binded_mobile");
    if (bk.bl(this.account)) {
      this.account = ar.Zt(paramMobileInputUI.foC + paramMobileInputUI.foD);
    }
    paramMobileInputUI.fop.setTextColor(paramMobileInputUI.getResources().getColor(q.c.hint_text_color));
    paramMobileInputUI.fop.setEnabled(false);
    paramMobileInputUI.fop.setFocusable(false);
    paramMobileInputUI.foo.setFocusable(false);
    paramMobileInputUI.foo.setText(ar.Zt(this.account));
    paramMobileInputUI.foo.setVisibility(0);
    XS();
    paramMobileInputUI.foz.setVisibility(0);
    paramMobileInputUI.fou.setText(q.j.login_login);
    paramMobileInputUI.fou.setVisibility(0);
    paramMobileInputUI.fou.setEnabled(true);
    this.fnG = at.dVC.L("login_weixin_username", "");
    this.fky = paramMobileInputUI.getIntent().getStringExtra("auth_ticket");
    if (!bk.bl(this.fky)) {
      new ah().postDelayed(new l.1(this), 500L);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fnW.fev != null)
    {
      this.fnW.fev.dismiss();
      this.fnW.fev = null;
    }
    if (paramm.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramm).rN();
      if (i == 16) {
        if (paramInt2 == -41)
        {
          this.fnW.foq.reset();
          com.tencent.mm.ui.base.h.h(this.fnW, q.j.regbymobile_reg_mobile_format_err_msg, q.j.regbymobile_reg_mobile_format_err_title);
        }
      }
    }
    label259:
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt2 != -75) {
            break;
          }
          this.fnW.foq.reset();
          com.tencent.mm.ui.base.h.b(this.fnW, this.fnW.getString(q.j.alpha_version_tip_login), "", true);
          return;
          if (i != 17) {
            break;
          }
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            new g(new l.15(this), ((com.tencent.mm.modelfriend.a)paramm).getUsername(), ((com.tencent.mm.modelfriend.a)paramm).NI(), this.account).a(this.fnW);
            return;
          }
        } while (h(paramInt1, paramInt2, paramString));
        paramm = com.tencent.mm.i.a.eI(paramString);
        if (paramm != null) {
          paramm.a(this.fnW, null, null);
        }
        paramString = com.tencent.mm.i.a.eI(paramString);
      } while ((paramString == null) || (this.fnW == null) || (!paramString.a(this.fnW, null, null)));
      return;
      if (paramm.getType() != 701) {
        break label1159;
      }
      this.caS = ((com.tencent.mm.modelsimple.q)paramm).Qy();
      localObject = new f();
      ((f)localObject).feA = ((com.tencent.mm.modelsimple.q)paramm).Qz();
      ((f)localObject).fez = ((com.tencent.mm.modelsimple.q)paramm).QA();
      ((f)localObject).feB = ((com.tencent.mm.modelsimple.q)paramm).QB();
      ((f)localObject).fns = ((com.tencent.mm.modelsimple.q)paramm).getSecCodeType();
      ((f)localObject).account = ((com.tencent.mm.modelsimple.q)paramm).account;
      ((f)localObject).fey = this.fnW.fmq.getText().toString();
      if (paramInt2 == -75)
      {
        z.bT(this.fnW);
        return;
      }
      if (paramInt2 == -106)
      {
        z.e(this.fnW, paramString, 32045);
        return;
      }
      if (paramInt2 == -217)
      {
        z.a(this.fnW, e.a((com.tencent.mm.modelsimple.q)paramm), paramInt2);
        return;
      }
      if (paramInt2 == -205)
      {
        this.fky = ((com.tencent.mm.modelsimple.q)paramm).NK();
        paramString = ((com.tencent.mm.modelsimple.q)paramm).QC();
        paramm = ((com.tencent.mm.modelsimple.q)paramm).QF();
        y.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bk.aac(this.fky), paramm });
        f.a((f)localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtra("auth_ticket", this.fky);
        ((Intent)localObject).putExtra("binded_mobile", paramString);
        ((Intent)localObject).putExtra("close_safe_device_style", paramm);
        ((Intent)localObject).putExtra("from_source", 6);
        com.tencent.mm.plugin.account.a.a.eUR.e(this.fnW, (Intent)localObject);
        return;
      }
      if (paramInt2 != -140) {
        break;
      }
    } while (bk.bl(this.caS));
    z.l(this.fnW, paramString, this.caS);
    return;
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.Dk().a(new bi(new l.16(this)), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.fex == null)
        {
          this.fex = SecurityImage.a.a(this.fnW, q.j.regbyqq_secimg_title, ((f)localObject).fns, ((f)localObject).fez, ((f)localObject).feA, ((f)localObject).feB, new l.2(this, (f)localObject), null, new l.3(this), (SecurityImage.b)localObject);
          return;
        }
        y.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + ((f)localObject).feA + " img len" + ((f)localObject).fez.length + " " + com.tencent.mm.compatible.util.g.zI());
        this.fex.a(((f)localObject).fns, ((f)localObject).fez, ((f)localObject).feA, ((f)localObject).feB);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.g.DN();
        com.tencent.mm.kernel.a.unhold();
        y.i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", new Object[] { ((f)localObject).account });
        z.pi(((f)localObject).account);
        paramString = at.dVC.L("login_weixin_username", "");
        w.bL(this.fnW);
        if (this.fnW.fnH)
        {
          bv.dXJ.ab(this.fnG, paramString);
          bv.dXJ.f(com.tencent.mm.model.q.Gj(), com.tencent.mm.model.q.GT());
          com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), bv.dXJ.Ij() });
        }
        z.showAddrBookUploadConfirm(this.fnW, new l.4(this), false, 2);
        if (this.fnW.dVU != 6) {
          break;
        }
        this.fmT = ((com.tencent.mm.modelsimple.q)paramm).QH();
        com.tencent.mm.kernel.g.Dk().a(255, this);
        paramString = new r(1);
        com.tencent.mm.kernel.g.Dk().a(paramString, 0);
        paramm = this.fnW;
        localObject = this.fnW;
        this.fnW.getString(q.j.app_tip);
        paramm.fev = com.tencent.mm.ui.base.h.b((Context)localObject, this.fnW.getString(q.j.app_loading), true, new l.5(this, paramString));
        return;
      }
      if (h(paramInt1, paramInt2, paramString)) {
        break;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label259;
      }
      Toast.makeText(this.fnW, this.fnW.getString(q.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      break label259;
      label1159:
      if (paramm.getType() != 255) {
        break label259;
      }
      com.tencent.mm.kernel.g.Dk().b(255, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break;
      }
      paramString = this.fnW;
      boolean bool = this.fmT;
      paramm = new Intent(paramString, RegByMobileSetPwdUI.class);
      paramm.putExtra("kintent_hint", paramString.getString(q.j.settings_modify_password_tip));
      paramm.putExtra("kintent_cancelable", bool);
      paramString.startActivity(paramm);
      return;
    }
  }
  
  public final void start()
  {
    com.tencent.mm.kernel.g.Dk().a(701, this);
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
    com.tencent.mm.kernel.g.Dk().b(701, this);
    com.tencent.mm.kernel.g.Dk().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("L200_100") + ",2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l
 * JD-Core Version:    0.7.0.1
 */