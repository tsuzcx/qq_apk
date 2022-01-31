package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.model.j.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;

public final class k
  implements f, MobileInputUI.b
{
  private String gFA;
  int gFB = 1;
  private MobileInputUI gFq;
  private String gFr;
  private String gFs;
  private int gFt = 0;
  
  private void arx()
  {
    AppMethodBeat.i(125131);
    Object localObject = this.gFq;
    MobileInputUI localMobileInputUI = this.gFq;
    this.gFq.getString(2131297087);
    ((MobileInputUI)localObject).gwe = h.b(localMobileInputUI, this.gFq.getString(2131302413), true, new k.5(this));
    localObject = new com.tencent.mm.modelfriend.a(this.gFq.gFW + this.gFq.gFX, 14, "", 0, "");
    ((com.tencent.mm.modelfriend.a)localObject).sQ(this.gFA);
    g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
    AppMethodBeat.o(125131);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(125129);
    switch (k.6.gFv[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(125129);
      return;
    }
    this.gFq.hideVKB();
    if (!this.gFq.gFN.isChecked())
    {
      parama = AnimationUtils.loadAnimation(this.gFq, 2131034133);
      this.gFq.gFM.startAnimation(parama);
      AppMethodBeat.o(125129);
      return;
    }
    switch (this.gFB)
    {
    default: 
      this.gFq.gFW = av.apA(this.gFq.countryCode);
      this.gFq.gFX = this.gFq.gFJ.getText().toString();
      parama = this.gFq.gFW + this.gFq.gFX;
      if (com.tencent.mm.plugin.account.a.b.a.O(this.gFq, this.gFq.gDK.getText().toString()))
      {
        if ((this.gFq.gwe == null) || (!this.gFq.gwe.isShowing())) {
          break label328;
        }
        ab.d("MicroMsg.MobileInputRegLogic", "already checking ");
      }
      break;
    }
    for (;;)
    {
      this.gFB = 0;
      break;
      arx();
      continue;
      parama = this.gFq.getString(2131306182, new Object[] { aa.dsG(), com.tencent.mm.au.b.m(this.gFq, this.gFq.countryCode, this.gFq.getString(2131298871)), "reg", Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.plugin.account.a.b.a.b(this.gFq, parama, 32047, false);
    }
    label328:
    Object localObject = this.gFq;
    MobileInputUI localMobileInputUI = this.gFq;
    this.gFq.getString(2131297087);
    ((MobileInputUI)localObject).gwe = h.b(localMobileInputUI, this.gFq.getString(2131302413), true, new k.2(this));
    localObject = this.gFq.gFJ.getText().toString();
    if ((this.gFr != null) && (this.gFs != null) && (!((String)localObject).equals(this.gFr)) && (((String)localObject).equals(this.gFs)))
    {
      i = 1;
      label428:
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.ll(this.gFt);
      parama.lm(i);
      if (com.tencent.mm.plugin.normsg.a.b.pgQ.VY("ie_reg_eu")) {
        com.tencent.mm.plugin.normsg.a.b.pgQ.VX("ie_reg_eu");
      }
      localObject = new cuv();
      ((cuv)localObject).ydw = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.VZ("ie_reg_eu"));
      ((cuv)localObject).ydx = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.Wc("ce_reg_eu"));
      if (com.tencent.mm.au.b.tN(this.gFq.countryCode)) {
        break label659;
      }
    }
    label659:
    for (int i = 6;; i = 4)
    {
      ((cuv)localObject).ydy = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.pgQ.AO(i));
      parama.a((cuv)localObject);
      g.Rc().a(parama, 0);
      this.gFr = this.gFq.gFJ.getText().toString();
      this.gFt += 1;
      break;
      if ((this.gFr != null) && (this.gFs != null) && (!this.gFs.equals(this.gFr)) && (!((String)localObject).equals(this.gFs)))
      {
        i = 2;
        break label428;
      }
      i = 0;
      break label428;
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(125126);
    this.gFq = paramMobileInputUI;
    String str = "";
    if (d.whK) {
      str = "" + paramMobileInputUI.getString(2131296529);
    }
    paramMobileInputUI.setMMTitle(str);
    paramMobileInputUI.showOptionMenu(false);
    paramMobileInputUI.gFQ.setVisibility(0);
    paramMobileInputUI.gFQ.setVisibility(0);
    paramMobileInputUI.gtI.setVisibility(0);
    paramMobileInputUI.gFJ.setVisibility(0);
    paramMobileInputUI.gFK.requestFocus();
    paramMobileInputUI.gFM.setVisibility(0);
    paramMobileInputUI.gEV.setVisibility(0);
    paramMobileInputUI.gFU.setVisibility(8);
    paramMobileInputUI.gFP.setVisibility(0);
    paramMobileInputUI.gFP.setText(2131301166);
    paramMobileInputUI.gFO.setOnClickListener(new k.1(this, paramMobileInputUI));
    AppMethodBeat.o(125126);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125130);
    ab.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gFq.gwe != null)
    {
      this.gFq.gwe.dismiss();
      this.gFq.gwe = null;
    }
    if (paramInt2 == -75)
    {
      h.h(this.gFq, 2131296532, 2131302378);
      AppMethodBeat.o(125130);
      return;
    }
    if (paramm.getType() == 145)
    {
      if ((paramInt2 == -41) || (paramInt2 == -59))
      {
        paramString = com.tencent.mm.h.a.kO(paramString);
        if (paramString != null)
        {
          paramString.a(this.gFq, null, null);
          AppMethodBeat.o(125130);
          return;
        }
        h.h(this.gFq, 2131302425, 2131302426);
        AppMethodBeat.o(125130);
        return;
      }
      int i = ((com.tencent.mm.modelfriend.a)paramm).Ac();
      if (i == 12)
      {
        this.gFq.gFX = av.apy(this.gFq.gFX);
        this.gFs = (this.gFq.gFW + this.gFq.gFX);
        this.gFA = ((com.tencent.mm.modelfriend.a)paramm).agK();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramm = ((com.tencent.mm.modelfriend.a)paramm).agz();
          if (!bo.isNullOrNil(paramm)) {
            this.gFq.gFX = paramm.trim();
          }
          paramm = new StringBuilder();
          g.RJ();
          paramm = paramm.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_200,");
          g.RJ();
          com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R200_200") + ",1");
          paramString = com.tencent.mm.h.a.kO(paramString);
          if (paramString != null)
          {
            paramString.a(this.gFq, new k.3(this), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(152573);
                paramAnonymousDialogInterface = new StringBuilder();
                g.RJ();
                paramAnonymousDialogInterface = paramAnonymousDialogInterface.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_200,");
                g.RJ();
                com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R200_200") + ",2");
                AppMethodBeat.o(152573);
              }
            });
            AppMethodBeat.o(125130);
            return;
          }
          arx();
          paramString = new StringBuilder();
          g.RJ();
          paramString = paramString.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_200,");
          g.RJ();
          com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R200_200") + ",2");
          AppMethodBeat.o(125130);
          return;
        }
        if (paramInt2 == -355)
        {
          z.f(this.gFq, paramString, 32046);
          AppMethodBeat.o(125130);
          return;
        }
        if (paramInt2 == -34)
        {
          h.b(this.gFq, this.gFq.getString(2131297570), "", true);
          AppMethodBeat.o(125130);
          return;
        }
      }
      Object localObject;
      if (i == 14)
      {
        if ((paramInt2 != 0) && (paramString != null)) {
          break label1041;
        }
        if (((com.tencent.mm.modelfriend.a)paramm).agA() != 1) {
          break label773;
        }
        localObject = this.gFq.gFW + this.gFq.gFX;
        String str = ((com.tencent.mm.modelfriend.a)paramm).agC();
        paramm = ((com.tencent.mm.modelfriend.a)paramm).agB();
        Intent localIntent = new Intent(this.gFq, RegByMobileSendSmsUI.class);
        localIntent.putExtra("from_mobile", (String)localObject);
        localIntent.putExtra("to_mobile", str);
        localIntent.putExtra("verify_code", paramm);
        localIntent.putExtra("key_reg_style", 2);
        localIntent.putExtra("kintent_password", this.gFq.gDK.getText().toString());
        localIntent.putExtra("regsession_id", this.gFA);
        this.gFq.startActivity(localIntent);
      }
      label773:
      label1041:
      do
      {
        for (;;)
        {
          paramString = com.tencent.mm.h.a.kO(paramString);
          if ((paramString == null) || (this.gFq == null) || (!paramString.a(this.gFq, null, null))) {
            break;
          }
          AppMethodBeat.o(125130);
          return;
          com.tencent.mm.plugin.b.a.xD("R200_300");
          localObject = new Intent();
          ((Intent)localObject).putExtra("bindmcontact_mobile", this.gFq.gFW + " " + this.gFq.gFJ.getText().toString());
          ((Intent)localObject).putExtra("bindmcontact_shortmobile", this.gFq.gFX);
          ((Intent)localObject).putExtra("country_name", this.gFq.fHT);
          ((Intent)localObject).putExtra("couttry_code", this.gFq.countryCode);
          ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramm).agE());
          ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramm).agF());
          ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramm).agG());
          ((Intent)localObject).putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramm).agH());
          ((Intent)localObject).putExtra("key_reg_style", 2);
          ((Intent)localObject).putExtra("kintent_password", this.gFq.gDK.getText().toString());
          ((Intent)localObject).putExtra("mobile_verify_purpose", 2);
          ((Intent)localObject).putExtra("regsession_id", this.gFA);
          ((Intent)localObject).setClass(this.gFq, MobileVerifyUI.class);
          this.gFq.startActivity((Intent)localObject);
          j.a(j.a.gAZ);
        }
        if (paramInt2 == -34)
        {
          h.b(this.gFq, this.gFq.getString(2131297570), "", true);
          AppMethodBeat.o(125130);
          return;
        }
      } while (!com.tencent.mm.plugin.account.a.a.gmP.a(this.gFq, paramInt1, paramInt2, paramString));
      AppMethodBeat.o(125130);
      return;
    }
    AppMethodBeat.o(125130);
  }
  
  public final void start()
  {
    AppMethodBeat.i(125127);
    g.Rc().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_100,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("R200_100") + ",1");
    com.tencent.mm.plugin.b.a.xC("R200_100");
    this.gFt = 0;
    AppMethodBeat.o(125127);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(125128);
    g.Rc().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_100,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("R200_100") + ",2");
    AppMethodBeat.o(125128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.k
 * JD-Core Version:    0.7.0.1
 */