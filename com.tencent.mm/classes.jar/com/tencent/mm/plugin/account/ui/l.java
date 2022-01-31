package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

public final class l
  implements com.tencent.mm.ai.f, MobileInputUI.b
{
  String account;
  private String cJr;
  private String gBP;
  private String gEZ;
  private boolean gEn = true;
  private String gFE;
  MobileInputUI gFq;
  SecurityImage gwg = null;
  
  private void ary()
  {
    AppMethodBeat.i(125149);
    if (this.gFq.fme == 6)
    {
      this.gFq.gFL.reset();
      this.gFq.gFT.setText(2131301145);
      this.gFq.gEV.setVisibility(8);
      this.gFq.gFL.setVisibility(0);
      this.gFq.gFL.getContentEditText().requestFocus();
      this.gFq.gFL.setSendSmsBtnClickListener(new l.8(this));
      this.gFq.gFT.setOnClickListener(new l.9(this));
      AppMethodBeat.o(125149);
      return;
    }
    if (this.gFq.fme == 7)
    {
      this.gFq.gFT.setText(2131301146);
      this.gFq.gEV.setVisibility(0);
      this.gFq.gDK.requestFocus();
      this.gFq.gFL.setVisibility(8);
      this.gFq.gFT.setOnClickListener(new l.10(this));
    }
    AppMethodBeat.o(125149);
  }
  
  private void bn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(125153);
    if (bo.isNullOrNil(paramString1))
    {
      com.tencent.mm.ui.base.h.h(this.gFq, 2131304504, 2131301135);
      AppMethodBeat.o(125153);
      return;
    }
    if (bo.isNullOrNil(paramString2))
    {
      com.tencent.mm.ui.base.h.h(this.gFq, 2131304500, 2131301135);
      AppMethodBeat.o(125153);
      return;
    }
    this.gFq.gDK.setText(paramString2);
    this.gFq.hideVKB();
    paramString1 = new s(paramString1, paramString2, null, 1);
    com.tencent.mm.kernel.g.Rc().a(paramString1, 0);
    paramString2 = this.gFq;
    MobileInputUI localMobileInputUI = this.gFq;
    this.gFq.getString(2131297087);
    paramString2.gwe = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.gFq.getString(2131301149), true, new l.13(this, paramString1));
    AppMethodBeat.o(125153);
  }
  
  private boolean l(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(125155);
    if (com.tencent.mm.plugin.account.a.a.gmP.a(this.gFq, paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(125155);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(125155);
      return false;
    case -1: 
      if (com.tencent.mm.kernel.g.Rc().adt() == 5)
      {
        com.tencent.mm.ui.base.h.h(this.gFq, 2131301790, 2131301789);
        AppMethodBeat.o(125155);
        return true;
      }
      AppMethodBeat.o(125155);
      return false;
    case -3: 
      com.tencent.mm.ui.base.h.h(this.gFq, 2131299331, 2131301135);
      AppMethodBeat.o(125155);
      return true;
    case -9: 
      com.tencent.mm.ui.base.h.h(this.gFq, 2131301134, 2131301135);
      AppMethodBeat.o(125155);
      return true;
    case -100: 
      com.tencent.mm.kernel.g.RJ();
      com.tencent.mm.kernel.a.hold();
      MobileInputUI localMobileInputUI = this.gFq;
      com.tencent.mm.kernel.g.RJ();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.QD())) {}
      for (paramString = com.tencent.mm.cb.a.aq(this.gFq, 2131301416);; paramString = com.tencent.mm.kernel.a.QD())
      {
        com.tencent.mm.ui.base.h.a(localMobileInputUI, paramString, this.gFq.getString(2131297087), new DialogInterface.OnClickListener()new l.6
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new l.6(this));
        AppMethodBeat.o(125155);
        return true;
        com.tencent.mm.kernel.g.RJ();
      }
    case -140: 
      if (!bo.isNullOrNil(this.cJr)) {
        z.o(this.gFq, paramString, this.cJr);
      }
      AppMethodBeat.o(125155);
      return true;
    case -34: 
      Toast.makeText(this.gFq, 2131297570, 0).show();
      AppMethodBeat.o(125155);
      return true;
    case -32: 
      com.tencent.mm.ui.base.h.a(this.gFq, 2131297617, 2131297621, null);
      AppMethodBeat.o(125155);
      return true;
    }
    com.tencent.mm.ui.base.h.a(this.gFq, 2131297615, 2131297621, null);
    AppMethodBeat.o(125155);
    return true;
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(125152);
    switch (l.7.gFv[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125152);
      return;
      this.gFq.hideVKB();
      this.gFq.gFW = com.tencent.mm.sdk.platformtools.av.apA(this.gFq.countryCode);
      this.gFq.gFX = this.gFq.gFK.getText().toString();
      if ((bo.isNullOrNil(this.gFq.gFW)) || (bo.isNullOrNil(this.gFq.gFX)))
      {
        AppMethodBeat.o(125152);
        return;
      }
      if (this.gFq.fme == 7)
      {
        if (!bo.isNullOrNil(this.gFE))
        {
          bn(this.account, this.gFE);
          AppMethodBeat.o(125152);
          return;
        }
        bn(this.account, this.gFq.gDK.getText().toString());
        AppMethodBeat.o(125152);
        return;
      }
      if (this.gFq.fme == 6)
      {
        parama = this.gFq.gFL.getText().toString().trim();
        if (bo.isNullOrNil(parama))
        {
          com.tencent.mm.ui.base.h.h(this.gFq, 2131304503, 2131301135);
          AppMethodBeat.o(125152);
          return;
        }
        this.gFq.hideVKB();
        parama = new com.tencent.mm.modelfriend.a(this.account, 17, parama, 0, "");
        com.tencent.mm.kernel.g.Rc().a(parama, 0);
        MobileInputUI localMobileInputUI1 = this.gFq;
        MobileInputUI localMobileInputUI2 = this.gFq;
        this.gFq.getString(2131297087);
        localMobileInputUI1.gwe = com.tencent.mm.ui.base.h.b(localMobileInputUI2, this.gFq.getString(2131297610), true, new l.11(this, parama));
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(125148);
    this.gFq = paramMobileInputUI;
    paramMobileInputUI.gFR.setVisibility(0);
    this.account = paramMobileInputUI.getIntent().getStringExtra("binded_mobile");
    if (bo.isNullOrNil(this.account)) {
      this.account = com.tencent.mm.sdk.platformtools.av.apy(paramMobileInputUI.gFW + paramMobileInputUI.gFX);
    }
    paramMobileInputUI.gFK.setTextColor(paramMobileInputUI.getResources().getColor(2131690168));
    paramMobileInputUI.gFK.setEnabled(false);
    paramMobileInputUI.gFK.setFocusable(false);
    paramMobileInputUI.gFJ.setFocusable(false);
    paramMobileInputUI.gFJ.setText(com.tencent.mm.sdk.platformtools.av.apy(this.account));
    paramMobileInputUI.gFJ.setVisibility(0);
    ary();
    paramMobileInputUI.gFT.setVisibility(0);
    paramMobileInputUI.gFP.setText(2131301142);
    paramMobileInputUI.gFP.setVisibility(0);
    paramMobileInputUI.gFP.setEnabled(true);
    this.gEZ = com.tencent.mm.model.av.flM.Y("login_weixin_username", "");
    this.gBP = paramMobileInputUI.getIntent().getStringExtra("auth_ticket");
    if (!bo.isNullOrNil(this.gBP)) {
      new ak().postDelayed(new l.1(this), 500L);
    }
    AppMethodBeat.o(125148);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125154);
    ab.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gFq.gwe != null)
    {
      this.gFq.gwe.dismiss();
      this.gFq.gwe = null;
    }
    if (paramm.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramm).Ac();
      if (i == 16)
      {
        if (paramInt2 == -41)
        {
          this.gFq.gFL.reset();
          com.tencent.mm.ui.base.h.h(this.gFq, 2131302425, 2131302426);
          AppMethodBeat.o(125154);
          return;
        }
        if (paramInt2 == -75)
        {
          this.gFq.gFL.reset();
          com.tencent.mm.ui.base.h.b(this.gFq, this.gFq.getString(2131296531), "", true);
          AppMethodBeat.o(125154);
          return;
        }
        if (paramInt2 == -106)
        {
          this.gFq.gFL.reset();
          z.f(this.gFq, paramString, 32045);
          AppMethodBeat.o(125154);
        }
      }
      else if (i == 17)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          new g(new l.14(this), ((com.tencent.mm.modelfriend.a)paramm).getUsername(), ((com.tencent.mm.modelfriend.a)paramm).agw(), this.account).a(this.gFq);
          AppMethodBeat.o(125154);
          return;
        }
        if (l(paramInt1, paramInt2, paramString))
        {
          AppMethodBeat.o(125154);
          return;
        }
        paramm = com.tencent.mm.h.a.kO(paramString);
        if (paramm != null) {
          paramm.a(this.gFq, null, null);
        }
      }
    }
    while ((paramm.getType() != 252) && (paramm.getType() != 701))
    {
      paramString = com.tencent.mm.h.a.kO(paramString);
      if ((paramString == null) || (this.gFq == null) || (!paramString.a(this.gFq, null, null))) {
        break;
      }
      AppMethodBeat.o(125154);
      return;
    }
    this.cJr = ((s)paramm).ajF();
    Object localObject = new f();
    ((f)localObject).gwj = ((s)paramm).ajG();
    ((f)localObject).gwi = ((s)paramm).ajH();
    ((f)localObject).gwk = ((s)paramm).ajI();
    ((f)localObject).gEL = ((s)paramm).getSecCodeType();
    ((f)localObject).account = ((s)paramm).account;
    ((f)localObject).gwh = this.gFq.gDK.getText().toString();
    if (paramInt2 == -75)
    {
      z.cA(this.gFq);
      AppMethodBeat.o(125154);
      return;
    }
    if (paramInt2 == -106)
    {
      z.f(this.gFq, paramString, 32045);
      AppMethodBeat.o(125154);
      return;
    }
    if (paramInt2 == -217)
    {
      z.a(this.gFq, e.a((s)paramm), paramInt2);
      AppMethodBeat.o(125154);
      return;
    }
    if (paramInt2 == -205)
    {
      this.gBP = ((s)paramm).agy();
      paramString = ((s)paramm).ajK();
      paramm = ((s)paramm).ajN();
      ab.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bo.aqg(this.gBP), paramm });
      f.a((f)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("auth_ticket", this.gBP);
      ((Intent)localObject).putExtra("binded_mobile", paramString);
      ((Intent)localObject).putExtra("close_safe_device_style", paramm);
      ((Intent)localObject).putExtra("from_source", 6);
      com.tencent.mm.plugin.account.a.a.gmO.g(this.gFq, (Intent)localObject);
      AppMethodBeat.o(125154);
      return;
    }
    if (paramInt2 == -140)
    {
      if (!bo.isNullOrNil(this.cJr)) {
        z.o(this.gFq, paramString, this.cJr);
      }
      AppMethodBeat.o(125154);
      return;
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.Rc().a(new bk(new l.15(this)), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.gwg == null)
        {
          this.gwg = SecurityImage.a.a(this.gFq, ((f)localObject).gEL, ((f)localObject).gwi, ((f)localObject).gwj, ((f)localObject).gwk, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(125135);
              ab.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + this.gFG.gwj + " img len" + this.gFG.gwi.length + " " + com.tencent.mm.compatible.util.g.Ml());
              paramAnonymousDialogInterface = new s(this.gFG.account, this.gFG.gwh, this.gFG.gEL, l.this.gwg.getSecImgCode(), l.this.gwg.getSecImgSid(), l.this.gwg.getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.g.Rc().a(paramAnonymousDialogInterface, 0);
              MobileInputUI localMobileInputUI1 = l.this.gFq;
              MobileInputUI localMobileInputUI2 = l.this.gFq;
              l.this.gFq.getString(2131297087);
              localMobileInputUI1.gwe = com.tencent.mm.ui.base.h.b(localMobileInputUI2, l.this.gFq.getString(2131301149), true, new l.2.1(this, paramAnonymousDialogInterface));
              AppMethodBeat.o(125135);
            }
          }, null, new l.3(this), (SecurityImage.b)localObject);
          AppMethodBeat.o(125154);
          return;
        }
        ab.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + ((f)localObject).gwj + " img len" + ((f)localObject).gwi.length + " " + com.tencent.mm.compatible.util.g.Ml());
        this.gwg.b(((f)localObject).gEL, ((f)localObject).gwi, ((f)localObject).gwj, ((f)localObject).gwk);
        AppMethodBeat.o(125154);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.g.RJ();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.aqv();
        ab.i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", new Object[] { ((f)localObject).account });
        z.wz(((f)localObject).account);
        paramString = com.tencent.mm.model.av.flM.Y("login_weixin_username", "");
        w.cs(this.gFq);
        if (this.gFq.gFa)
        {
          bx.fnO.ar(this.gEZ, paramString);
          bx.fnO.g(r.Zn(), r.ZV());
          com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), bx.fnO.abg() });
        }
        z.showAddrBookUploadConfirm(this.gFq, new l.4(this), false, 2);
        if (this.gFq.fme == 6)
        {
          this.gEn = ((s)paramm).ajP();
          if (((s)paramm).ajJ())
          {
            paramString = this.gFq;
            boolean bool = this.gEn;
            paramm = new Intent(paramString, RegByMobileSetPwdUI.class);
            paramm.putExtra("kintent_hint", paramString.getString(2131303322));
            paramm.putExtra("kintent_cancelable", bool);
            paramString.startActivity(paramm);
          }
        }
        AppMethodBeat.o(125154);
        return;
      }
      if (l(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125154);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break;
      }
      Toast.makeText(this.gFq, this.gFq.getString(2131300023, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      break;
      AppMethodBeat.o(125154);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(125150);
    com.tencent.mm.kernel.g.Rc().a(252, this);
    com.tencent.mm.kernel.g.Rc().a(701, this);
    com.tencent.mm.kernel.g.Rc().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.xC("L200_100");
    AppMethodBeat.o(125150);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(125151);
    com.tencent.mm.kernel.g.Rc().b(701, this);
    com.tencent.mm.kernel.g.Rc().b(252, this);
    com.tencent.mm.kernel.g.Rc().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("L200_100") + ",2");
    AppMethodBeat.o(125151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l
 * JD-Core Version:    0.7.0.1
 */