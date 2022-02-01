package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.model.l.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class k
  implements f, MobileInputUI.b
{
  private MobileInputUI jmh;
  private String jmi;
  private String jmj;
  private int jmk = 0;
  private String jmq;
  int jmr = 1;
  
  private void aUa()
  {
    AppMethodBeat.i(128301);
    Object localObject = this.jmh;
    MobileInputUI localMobileInputUI = this.jmh;
    this.jmh.getString(2131755906);
    ((MobileInputUI)localObject).jcr = h.b(localMobileInputUI, this.jmh.getString(2131762310), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = new com.tencent.mm.modelfriend.a(this.jmh.jmK + this.jmh.jmL, 14, "", 0, "");
    ((com.tencent.mm.modelfriend.a)localObject).EX(this.jmq);
    com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
    AppMethodBeat.o(128301);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128299);
    switch (6.jmm[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128299);
      return;
    }
    this.jmh.hideVKB();
    if (!this.jmh.jmB.isChecked())
    {
      parama = AnimationUtils.loadAnimation(this.jmh, 2130771990);
      this.jmh.jmA.startAnimation(parama);
      AppMethodBeat.o(128299);
      return;
    }
    switch (this.jmr)
    {
    default: 
      this.jmh.jmK = ba.aQK(this.jmh.countryCode);
      this.jmh.jmL = this.jmh.jmx.getText().toString();
      parama = this.jmh.jmK + this.jmh.jmL;
      if (com.tencent.mm.plugin.account.a.b.a.N(this.jmh, this.jmh.jkK.getText().toString()))
      {
        if ((this.jmh.jcr == null) || (!this.jmh.jcr.isShowing())) {
          break label324;
        }
        ad.d("MicroMsg.MobileInputRegLogic", "already checking ");
      }
      break;
    }
    for (;;)
    {
      this.jmr = 0;
      break;
      aUa();
      continue;
      parama = this.jmh.getString(2131760685, new Object[] { ac.fks(), com.tencent.mm.ax.b.bs(this.jmh.countryCode, this.jmh.getString(2131757950)), "reg", Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.plugin.account.a.b.a.b(this.jmh, parama, 32047, false);
    }
    label324:
    Object localObject = this.jmh;
    MobileInputUI localMobileInputUI = this.jmh;
    this.jmh.getString(2131755906);
    ((MobileInputUI)localObject).jcr = h.b(localMobileInputUI, this.jmh.getString(2131762310), true, new k.2(this));
    localObject = this.jmh.jmx.getText().toString();
    int i;
    if ((this.jmi != null) && (this.jmj != null) && (!((String)localObject).equals(this.jmi)) && (((String)localObject).equals(this.jmj))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.ph(this.jmk);
      parama.pi(i);
      if (com.tencent.mm.plugin.normsg.a.b.wtJ.ats("ie_reg_eu")) {
        com.tencent.mm.plugin.normsg.a.b.wtJ.atr("ie_reg_eu");
      }
      localObject = new eah();
      ((eah)localObject).HNj = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.att("ie_reg_eu"));
      ((eah)localObject).HNk = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.atw("ce_reg_eu"));
      i = 16;
      if (!com.tencent.mm.ax.b.FV(this.jmh.countryCode)) {
        i = 30;
      }
      ((eah)localObject).HNl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.LX(i));
      ((eah)localObject).HNp = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wtJ.duR());
      parama.a((eah)localObject);
      com.tencent.mm.kernel.g.aiU().a(parama, 0);
      this.jmi = this.jmh.jmx.getText().toString();
      this.jmk += 1;
      break;
      if ((this.jmi != null) && (this.jmj != null) && (!this.jmj.equals(this.jmi)) && (!((String)localObject).equals(this.jmj))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128296);
    this.jmh = paramMobileInputUI;
    String str = "";
    if ((d.Fnm) || (i.IS_FLAVOR_BLUE)) {
      str = "" + com.tencent.mm.cd.g.is(paramMobileInputUI);
    }
    paramMobileInputUI.setMMTitle(str);
    paramMobileInputUI.showOptionMenu(false);
    paramMobileInputUI.jmE.setVisibility(0);
    paramMobileInputUI.jmE.setVisibility(0);
    paramMobileInputUI.jab.setVisibility(0);
    paramMobileInputUI.jmx.setVisibility(0);
    paramMobileInputUI.jmy.requestFocus();
    paramMobileInputUI.jmA.setVisibility(0);
    paramMobileInputUI.jlO.setVisibility(0);
    paramMobileInputUI.jmI.setVisibility(8);
    paramMobileInputUI.jmD.setVisibility(0);
    paramMobileInputUI.jmD.setText(2131760798);
    paramMobileInputUI.jmC.setOnClickListener(new k.1(this, paramMobileInputUI));
    AppMethodBeat.o(128296);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128300);
    ad.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jmh.jcr != null)
    {
      this.jmh.jcr.dismiss();
      this.jmh.jcr = null;
    }
    if (paramInt2 == -75)
    {
      h.l(this.jmh, 2131755266, 2131762275);
      AppMethodBeat.o(128300);
      return;
    }
    if (paramn.getType() == 145)
    {
      if ((paramInt2 == -41) || (paramInt2 == -59))
      {
        paramString = com.tencent.mm.h.a.uz(paramString);
        if (paramString != null)
        {
          paramString.a(this.jmh, null, null);
          AppMethodBeat.o(128300);
          return;
        }
        h.l(this.jmh, 2131762328, 2131762329);
        AppMethodBeat.o(128300);
        return;
      }
      int i = ((com.tencent.mm.modelfriend.a)paramn).KR();
      if (i == 12)
      {
        this.jmh.jmL = ba.aQI(this.jmh.jmL);
        this.jmj = (this.jmh.jmK + this.jmh.jmL);
        this.jmq = ((com.tencent.mm.modelfriend.a)paramn).aHK();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramn = ((com.tencent.mm.modelfriend.a)paramn).aHy();
          if (!bt.isNullOrNil(paramn)) {
            this.jmh.jmL = paramn.trim();
          }
          paramn = new StringBuilder();
          com.tencent.mm.kernel.g.ajA();
          paramn = paramn.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_200,");
          com.tencent.mm.kernel.g.ajA();
          com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("R200_200") + ",1");
          paramString = com.tencent.mm.h.a.uz(paramString);
          if (paramString != null)
          {
            paramString.a(this.jmh, new k.3(this), new k.4(this));
            AppMethodBeat.o(128300);
            return;
          }
          aUa();
          paramString = new StringBuilder();
          com.tencent.mm.kernel.g.ajA();
          paramString = paramString.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_200,");
          com.tencent.mm.kernel.g.ajA();
          com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("R200_200") + ",2");
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -355)
        {
          y.g(this.jmh, paramString, 32046);
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -34)
        {
          h.c(this.jmh, this.jmh.getString(2131756462), "", true);
          AppMethodBeat.o(128300);
          return;
        }
      }
      Object localObject;
      if (i == 14)
      {
        if ((paramInt2 != 0) && (paramString != null)) {
          break label1193;
        }
        if (((com.tencent.mm.modelfriend.a)paramn).aHz() != 1) {
          break label849;
        }
        localObject = this.jmh.jmK + this.jmh.jmL;
        String str1 = ((com.tencent.mm.modelfriend.a)paramn).aHB();
        String str2 = ((com.tencent.mm.modelfriend.a)paramn).aHA();
        paramn = new Intent(this.jmh, RegByMobileSendSmsUI.class);
        paramn.putExtra("from_mobile", (String)localObject);
        paramn.putExtra("to_mobile", str1);
        paramn.putExtra("verify_code", str2);
        paramn.putExtra("key_reg_style", 2);
        paramn.putExtra("kintent_password", this.jmh.jkK.getText().toString());
        paramn.putExtra("regsession_id", this.jmq);
        localObject = this.jmh;
        paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramn.ahp(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileInputUI)localObject).startActivity((Intent)paramn.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      label849:
      do
      {
        for (;;)
        {
          paramString = com.tencent.mm.h.a.uz(paramString);
          if ((paramString == null) || (this.jmh == null) || (!paramString.a(this.jmh, null, null))) {
            break;
          }
          AppMethodBeat.o(128300);
          return;
          com.tencent.mm.plugin.b.a.Ma("R200_300");
          localObject = new Intent();
          ((Intent)localObject).putExtra("bindmcontact_mobile", this.jmh.jmK + " " + this.jmh.jmx.getText().toString());
          ((Intent)localObject).putExtra("bindmcontact_shortmobile", this.jmh.jmL);
          ((Intent)localObject).putExtra("country_name", this.jmh.iem);
          ((Intent)localObject).putExtra("couttry_code", this.jmh.countryCode);
          ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramn).aHE());
          ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramn).aHF());
          ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramn).aHG());
          ((Intent)localObject).putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramn).aHH());
          ((Intent)localObject).putExtra("key_reg_style", 2);
          ((Intent)localObject).putExtra("kintent_password", this.jmh.jkK.getText().toString());
          ((Intent)localObject).putExtra("mobile_verify_purpose", 2);
          ((Intent)localObject).putExtra("regsession_id", this.jmq);
          ((Intent)localObject).setClass(this.jmh, MobileVerifyUI.class);
          paramn = this.jmh;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramn, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.account.model.l.a(l.a.jhI);
        }
        if (paramInt2 == -34)
        {
          h.c(this.jmh, this.jmh.getString(2131756462), "", true);
          AppMethodBeat.o(128300);
          return;
        }
      } while (!com.tencent.mm.plugin.account.a.a.iRH.a(this.jmh, paramInt1, paramInt2, paramString));
      label1193:
      AppMethodBeat.o(128300);
      return;
    }
    AppMethodBeat.o(128300);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128297);
    com.tencent.mm.kernel.g.aiU().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_100,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("R200_100") + ",1");
    com.tencent.mm.plugin.b.a.Kc("R200_100");
    this.jmk = 0;
    AppMethodBeat.o(128297);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128298);
    com.tencent.mm.kernel.g.aiU().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_100,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("R200_100") + ",2");
    AppMethodBeat.o(128298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.k
 * JD-Core Version:    0.7.0.1
 */