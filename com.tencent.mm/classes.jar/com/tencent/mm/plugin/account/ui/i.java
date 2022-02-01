package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormInputView;

public final class i
  implements com.tencent.mm.ak.i, MobileInputUI.b
{
  private MobileInputUI knl;
  private String knm;
  private String knn;
  private int kno = 0;
  
  private void bpm()
  {
    AppMethodBeat.i(128272);
    Object localObject = this.knl;
    MobileInputUI localMobileInputUI = this.knl;
    this.knl.getString(2131755998);
    ((MobileInputUI)localObject).kdn = com.tencent.mm.ui.base.h.a(localMobileInputUI, this.knl.getString(2131764376), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = new com.tencent.mm.modelfriend.a(this.knl.knO + this.knl.knP, 8, "", 0, "");
    g.azz().a((com.tencent.mm.ak.q)localObject, 0);
    AppMethodBeat.o(128272);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128270);
    switch (5.knq[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128270);
      return;
    }
    this.knl.knO = PhoneFormater.countryCodeWithPlus(this.knl.countryCode);
    this.knl.knP = this.knl.knB.getText().toString();
    parama = this.knl.knO + this.knl.knP;
    if (this.knl.kdn != null)
    {
      Log.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
      AppMethodBeat.o(128270);
      return;
    }
    Object localObject = this.knl;
    MobileInputUI localMobileInputUI = this.knl;
    this.knl.getString(2131755998);
    ((MobileInputUI)localObject).kdn = com.tencent.mm.ui.base.h.a(localMobileInputUI, this.knl.getString(2131764376), true, new i.1(this));
    localObject = this.knl.knB.getText().toString();
    int i;
    if ((this.knm != null) && (this.knn != null) && (!((String)localObject).equals(this.knm)) && (((String)localObject).equals(this.knn))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.sZ(this.kno);
      parama.ta(i);
      g.azz().a(parama, 0);
      this.knm = this.knl.knB.getText().toString();
      this.kno += 1;
      break;
      if ((this.knm != null) && (this.knn != null) && (!this.knn.equals(this.knm)) && (!((String)localObject).equals(this.knn))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128267);
    this.knl = paramMobileInputUI;
    paramMobileInputUI.knC.requestFocus();
    paramMobileInputUI.showVKB();
    String str2 = paramMobileInputUI.getString(2131764437);
    String str1;
    if (!d.KyR)
    {
      str1 = str2;
      if (!BuildInfo.IS_FLAVOR_BLUE) {}
    }
    else
    {
      str1 = str2 + com.tencent.mm.cc.h.jr(paramMobileInputUI);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.kaX.setVisibility(0);
    paramMobileInputUI.knB.setVisibility(0);
    paramMobileInputUI.knC.requestFocus();
    paramMobileInputUI.knH.setText(2131755916);
    paramMobileInputUI.knH.setVisibility(0);
    AppMethodBeat.o(128267);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128271);
    Log.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.knl.kdn != null)
    {
      this.knl.kdn.dismiss();
      this.knl.kdn = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.n(this.knl, 2131755301, 2131764341);
      AppMethodBeat.o(128271);
      return;
    }
    if ((paramInt2 == -41) || (paramInt2 == -59))
    {
      paramString = com.tencent.mm.h.a.Dk(paramString);
      if (paramString != null)
      {
        paramString.a(this.knl, null, null);
        AppMethodBeat.o(128271);
        return;
      }
      com.tencent.mm.ui.base.h.n(this.knl, 2131764394, 2131764395);
      AppMethodBeat.o(128271);
      return;
    }
    if (paramq.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramq).Vj();
      if (i == 12)
      {
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramq = ((com.tencent.mm.modelfriend.a)paramq).bbI();
          if (!Util.isNullOrNil(paramq)) {
            this.knl.knP = paramq.trim();
          }
          this.knl.knP = PhoneFormater.pureNumber(this.knl.knP);
          this.knn = (this.knl.knO + this.knl.knP);
          paramq = new StringBuilder();
          g.aAf();
          paramq = paramq.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",F200_200,");
          g.aAf();
          com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("F200_200") + ",1");
          paramString = com.tencent.mm.h.a.Dk(paramString);
          if (paramString != null)
          {
            paramString.a(this.knl, new i.2(this), new i.3(this));
            AppMethodBeat.o(128271);
            return;
          }
          bpm();
          paramString = new StringBuilder();
          g.aAf();
          paramString = paramString.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",F200_200,");
          g.aAf();
          com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("F200_200") + ",2");
          AppMethodBeat.o(128271);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.c(this.knl, this.knl.getString(2131756598), "", true);
          AppMethodBeat.o(128271);
          return;
        }
        Toast.makeText(this.knl, this.knl.getString(2131756643, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if ((i == 8) && (paramInt2 == 0))
      {
        paramString = new Intent();
        paramString.putExtra("bindmcontact_mobile", this.knl.knO + " " + this.knl.knB.getText().toString());
        paramString.putExtra("bindmcontact_shortmobile", this.knl.knP);
        paramString.putExtra("country_name", this.knl.jbZ);
        paramString.putExtra("couttry_code", this.knl.countryCode);
        paramString.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramq).bbO());
        paramString.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramq).bbP());
        paramString.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramq).bbQ());
        paramString.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramq).bbR());
        paramString.putExtra("mobile_verify_purpose", 3);
        paramString.setClass(this.knl, MobileVerifyUI.class);
        paramq = this.knl;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramq, paramString.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramq.startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramq, "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(128271);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128268);
    g.azz().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",F200_100,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("F200_100") + ",1");
    com.tencent.mm.plugin.b.a.bwU("F200_100");
    this.kno = 0;
    AppMethodBeat.o(128268);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128269);
    g.azz().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",F200_100,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("F200_100") + ",2");
    AppMethodBeat.o(128269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i
 * JD-Core Version:    0.7.0.1
 */