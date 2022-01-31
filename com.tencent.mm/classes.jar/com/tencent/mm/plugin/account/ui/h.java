package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMFormInputView;

public final class h
  implements f, MobileInputUI.b
{
  private MobileInputUI gFq;
  private String gFr;
  private String gFs;
  private int gFt = 0;
  
  private void arx()
  {
    AppMethodBeat.i(125094);
    Object localObject = this.gFq;
    MobileInputUI localMobileInputUI = this.gFq;
    this.gFq.getString(2131297087);
    ((MobileInputUI)localObject).gwe = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.gFq.getString(2131302413), true, new h.4(this));
    localObject = new com.tencent.mm.modelfriend.a(this.gFq.gFW + this.gFq.gFX, 8, "", 0, "");
    g.Rc().a((m)localObject, 0);
    AppMethodBeat.o(125094);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(125092);
    switch (h.5.gFv[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(125092);
      return;
    }
    this.gFq.gFW = av.apA(this.gFq.countryCode);
    this.gFq.gFX = this.gFq.gFJ.getText().toString();
    parama = this.gFq.gFW + this.gFq.gFX;
    if (this.gFq.gwe != null)
    {
      ab.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
      AppMethodBeat.o(125092);
      return;
    }
    Object localObject = this.gFq;
    MobileInputUI localMobileInputUI = this.gFq;
    this.gFq.getString(2131297087);
    ((MobileInputUI)localObject).gwe = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.gFq.getString(2131302413), true, new h.1(this));
    localObject = this.gFq.gFJ.getText().toString();
    int i;
    if ((this.gFr != null) && (this.gFs != null) && (!((String)localObject).equals(this.gFr)) && (((String)localObject).equals(this.gFs))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.ll(this.gFt);
      parama.lm(i);
      g.Rc().a(parama, 0);
      this.gFr = this.gFq.gFJ.getText().toString();
      this.gFt += 1;
      break;
      if ((this.gFr != null) && (this.gFs != null) && (!this.gFs.equals(this.gFr)) && (!((String)localObject).equals(this.gFs))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(125089);
    this.gFq = paramMobileInputUI;
    paramMobileInputUI.gFK.requestFocus();
    paramMobileInputUI.showVKB();
    String str2 = paramMobileInputUI.getString(2131302468);
    String str1 = str2;
    if (d.whK) {
      str1 = str2 + paramMobileInputUI.getString(2131296529);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.gtI.setVisibility(0);
    paramMobileInputUI.gFJ.setVisibility(0);
    paramMobileInputUI.gFK.requestFocus();
    paramMobileInputUI.gFP.setText(2131297013);
    paramMobileInputUI.gFP.setVisibility(0);
    AppMethodBeat.o(125089);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(125093);
    ab.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gFq.gwe != null)
    {
      this.gFq.gwe.dismiss();
      this.gFq.gwe = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.h(this.gFq, 2131296532, 2131302378);
      AppMethodBeat.o(125093);
      return;
    }
    if ((paramInt2 == -41) || (paramInt2 == -59))
    {
      paramString = com.tencent.mm.h.a.kO(paramString);
      if (paramString != null)
      {
        paramString.a(this.gFq, null, null);
        AppMethodBeat.o(125093);
        return;
      }
      com.tencent.mm.ui.base.h.h(this.gFq, 2131302425, 2131302426);
      AppMethodBeat.o(125093);
      return;
    }
    if (paramm.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramm).Ac();
      if (i == 12)
      {
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramm = ((com.tencent.mm.modelfriend.a)paramm).agz();
          if (!bo.isNullOrNil(paramm)) {
            this.gFq.gFX = paramm.trim();
          }
          this.gFq.gFX = av.apy(this.gFq.gFX);
          this.gFs = (this.gFq.gFW + this.gFq.gFX);
          paramm = new StringBuilder();
          g.RJ();
          paramm = paramm.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",F200_200,");
          g.RJ();
          com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("F200_200") + ",1");
          paramString = com.tencent.mm.h.a.kO(paramString);
          if (paramString != null)
          {
            paramString.a(this.gFq, new h.2(this), new h.3(this));
            AppMethodBeat.o(125093);
            return;
          }
          arx();
          paramString = new StringBuilder();
          g.RJ();
          paramString = paramString.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",F200_200,");
          g.RJ();
          com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("F200_200") + ",2");
          AppMethodBeat.o(125093);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.b(this.gFq, this.gFq.getString(2131297570), "", true);
          AppMethodBeat.o(125093);
          return;
        }
        Toast.makeText(this.gFq, this.gFq.getString(2131297614, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if ((i == 8) && (paramInt2 == 0))
      {
        paramString = new Intent();
        paramString.putExtra("bindmcontact_mobile", this.gFq.gFW + " " + this.gFq.gFJ.getText().toString());
        paramString.putExtra("bindmcontact_shortmobile", this.gFq.gFX);
        paramString.putExtra("country_name", this.gFq.fHT);
        paramString.putExtra("couttry_code", this.gFq.countryCode);
        paramString.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramm).agE());
        paramString.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramm).agF());
        paramString.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramm).agG());
        paramString.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramm).agH());
        paramString.putExtra("mobile_verify_purpose", 3);
        paramString.setClass(this.gFq, MobileVerifyUI.class);
        this.gFq.startActivity(paramString);
      }
    }
    AppMethodBeat.o(125093);
  }
  
  public final void start()
  {
    AppMethodBeat.i(125090);
    g.Rc().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",F200_100,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("F200_100") + ",1");
    com.tencent.mm.plugin.b.a.xC("F200_100");
    this.gFt = 0;
    AppMethodBeat.o(125090);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(125091);
    g.Rc().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",F200_100,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("F200_100") + ",2");
    AppMethodBeat.o(125091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.h
 * JD-Core Version:    0.7.0.1
 */