package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public final class m
  implements com.tencent.mm.ah.f, MobileVerifyUI.b
{
  SecurityImage fex = null;
  f fmA = null;
  private int foE;
  private g foc = null;
  MobileVerifyUI fpj;
  
  public m(int paramInt)
  {
    this.foE = paramInt;
    y.i("MicroMsg.MobileVerifyForgetPwdLogic", "forget pwd, purpose %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void XV()
  {
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_350_auto,");
    com.tencent.mm.kernel.g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R200_350_auto") + ",1");
    com.tencent.mm.kernel.g.Dk().a(145, this);
    com.tencent.mm.kernel.g.Dk().a(132, this);
    localObject = null;
    if (this.foE == 3) {
      localObject = new com.tencent.mm.modelfriend.a(this.fpj.bSe, 9, this.fpj.fcd.getText().toString().trim(), 0, "");
    }
    for (;;)
    {
      if (localObject != null)
      {
        com.tencent.mm.kernel.g.Dk().a((com.tencent.mm.ah.m)localObject, 0);
        MobileVerifyUI localMobileVerifyUI1 = this.fpj;
        MobileVerifyUI localMobileVerifyUI2 = this.fpj;
        this.fpj.getString(q.j.app_tip);
        localMobileVerifyUI1.dnm = h.b(localMobileVerifyUI2, this.fpj.getString(q.j.bind_mcontact_verifing), true, new m.1(this, (com.tencent.mm.ah.m)localObject));
      }
      return;
      if (this.foE == 5) {
        localObject = new x(this.fpj.bSe, 21, this.fpj.fcd.getText().toString().trim(), 0, "");
      }
    }
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.fpj = paramMobileVerifyUI;
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    switch (m.5.fpn[parama.ordinal()])
    {
    default: 
      return false;
    case 1: 
      XV();
      return false;
    case 2: 
      parama = new StringBuilder();
      com.tencent.mm.kernel.g.DN();
      parama = parama.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_400,");
      com.tencent.mm.kernel.g.DN();
      com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R200_400") + ",1");
      parama = null;
      if (this.foE == 3) {
        parama = new com.tencent.mm.modelfriend.a(this.fpj.bSe, 8, "", 0, "");
      }
      while (parama != null)
      {
        com.tencent.mm.kernel.g.Dk().a(parama, 0);
        return false;
        if (this.foE == 5) {
          parama = new x(this.fpj.bSe, 20, "", 0, "");
        }
      }
    }
    XV();
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fpj.dnm != null)
    {
      this.fpj.dnm.dismiss();
      this.fpj.dnm = null;
    }
    if (this.fmA == null) {
      this.fmA = new f();
    }
    if ((paramm.getType() == 701) && (this.foc != null))
    {
      com.tencent.mm.kernel.g.Dk().b(701, this);
      this.fmA.feA = ((q)paramm).Qz();
      this.fmA.fez = ((q)paramm).QA();
      this.fmA.feB = ((q)paramm).QB();
      this.fmA.fns = ((q)paramm).getSecCodeType();
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.g.Dk().a(701, this);
        if (this.fex == null) {
          this.fex = SecurityImage.a.a(this.fpj, q.j.regbyqq_secimg_title, this.fmA.fns, this.fmA.fez, this.fmA.feA, this.fmA.feB, new m.2(this), null, new m.3(this), this.fmA);
        }
      }
      do
      {
        return;
        y.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.fmA.feA + " img len" + this.fmA.fez.length + " " + com.tencent.mm.compatible.util.g.zI());
        this.fex.a(this.fmA.fns, this.fmA.fez, this.fmA.feA, this.fmA.feB);
        return;
        this.foc.a(this.fpj, paramInt1, paramInt2, paramString, paramm);
      } while ((paramInt1 != 0) || (paramInt2 != 0));
      if (!(paramm instanceof q)) {
        break label811;
      }
    }
    label811:
    for (boolean bool = ((q)paramm).QH();; bool = true)
    {
      this.fpj.cA(bool);
      return;
      if (paramm.getType() == 145)
      {
        this.fmA.account = ((com.tencent.mm.modelfriend.a)paramm).getUsername();
        this.fmA.fnr = ((com.tencent.mm.modelfriend.a)paramm).NI();
        com.tencent.mm.kernel.g.Dk().b(145, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.foE != 3) {
            break;
          }
          com.tencent.mm.kernel.g.Dk().a(701, this);
          this.foc = new g(new m.4(this), ((com.tencent.mm.modelfriend.a)paramm).getUsername(), ((com.tencent.mm.modelfriend.a)paramm).NI(), this.fpj.bSe);
          this.foc.a(this.fpj);
          return;
        }
        if (paramInt2 == -51)
        {
          paramString = com.tencent.mm.i.a.eI(paramString);
          if (paramString != null)
          {
            paramString.a(this.fpj, null, null);
            return;
          }
          h.h(this.fpj, q.j.bind_mcontact_verify_err_time_out_content, q.j.bind_mcontact_verify_tip);
          return;
        }
      }
      if (paramm.getType() == 132)
      {
        com.tencent.mm.kernel.g.Dk().b(132, this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.foE != 5) {
            break;
          }
          paramString = ((x)paramm).NJ();
          paramm = new Intent();
          paramm.putExtra("setpwd_ticket", paramString);
          this.fpj.setResult(-1, paramm);
          this.fpj.finish();
          return;
        }
        if (paramInt2 == -51)
        {
          paramString = com.tencent.mm.i.a.eI(paramString);
          if (paramString != null)
          {
            paramString.a(this.fpj, null, null);
            return;
          }
          h.h(this.fpj, q.j.bind_mcontact_verify_err_time_out_content, q.j.bind_mcontact_verify_tip);
          return;
        }
      }
      if (this.fpj.h(paramInt1, paramInt2, paramString)) {
        break;
      }
      if (paramm.getType() == 701)
      {
        paramString = com.tencent.mm.i.a.eI(paramString);
        if ((paramString != null) && (paramString.a(this.fpj, null, null))) {
          break;
        }
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break;
      }
      Toast.makeText(this.fpj, this.fpj.getString(q.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      return;
    }
  }
  
  public final void start()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.DN();
    com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("F200_300") + ",1");
    com.tencent.mm.plugin.b.a.qi("F200_300");
  }
  
  public final void stop()
  {
    int i = 2;
    if (this.fpj.fpP != -1) {
      i = this.fpj.fpP;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("F200_300") + "," + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m
 * JD-Core Version:    0.7.0.1
 */