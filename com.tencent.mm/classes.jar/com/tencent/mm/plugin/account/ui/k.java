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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.model.l.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class k
  implements f, MobileInputUI.b
{
  private MobileInputUI jpb;
  private String jpc;
  private String jpd;
  private int jpe = 0;
  private String jpk;
  int jpl = 1;
  
  private void aUz()
  {
    AppMethodBeat.i(128301);
    Object localObject = this.jpb;
    MobileInputUI localMobileInputUI = this.jpb;
    this.jpb.getString(2131755906);
    ((MobileInputUI)localObject).jfk = h.b(localMobileInputUI, this.jpb.getString(2131762310), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = new com.tencent.mm.modelfriend.a(this.jpb.jpE + this.jpb.jpF, 14, "", 0, "");
    ((com.tencent.mm.modelfriend.a)localObject).Fz(this.jpk);
    com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
    AppMethodBeat.o(128301);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128299);
    switch (6.jpg[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128299);
      return;
    }
    this.jpb.hideVKB();
    if (!this.jpb.jpv.isChecked())
    {
      parama = AnimationUtils.loadAnimation(this.jpb, 2130771990);
      this.jpb.jpu.startAnimation(parama);
      AppMethodBeat.o(128299);
      return;
    }
    switch (this.jpl)
    {
    default: 
      this.jpb.jpE = bb.aSh(this.jpb.countryCode);
      this.jpb.jpF = this.jpb.jpr.getText().toString();
      parama = this.jpb.jpE + this.jpb.jpF;
      if (com.tencent.mm.plugin.account.a.b.a.O(this.jpb, this.jpb.jnE.getText().toString()))
      {
        if ((this.jpb.jfk == null) || (!this.jpb.jfk.isShowing())) {
          break label324;
        }
        ae.d("MicroMsg.MobileInputRegLogic", "already checking ");
      }
      break;
    }
    for (;;)
    {
      this.jpl = 0;
      break;
      aUz();
      continue;
      parama = this.jpb.getString(2131760685, new Object[] { ad.fom(), com.tencent.mm.aw.b.bs(this.jpb.countryCode, this.jpb.getString(2131757950)), "reg", Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.plugin.account.a.b.a.b(this.jpb, parama, 32047, false);
    }
    label324:
    Object localObject = this.jpb;
    MobileInputUI localMobileInputUI = this.jpb;
    this.jpb.getString(2131755906);
    ((MobileInputUI)localObject).jfk = h.b(localMobileInputUI, this.jpb.getString(2131762310), true, new k.2(this));
    localObject = this.jpb.jpr.getText().toString();
    int i;
    if ((this.jpc != null) && (this.jpd != null) && (!((String)localObject).equals(this.jpc)) && (((String)localObject).equals(this.jpd))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.pk(this.jpe);
      parama.pl(i);
      if (com.tencent.mm.plugin.normsg.a.b.wJt.auF("ie_reg_eu")) {
        com.tencent.mm.plugin.normsg.a.b.wJt.auE("ie_reg_eu");
      }
      localObject = new eby();
      ((eby)localObject).Ihq = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.auG("ie_reg_eu"));
      ((eby)localObject).Ihr = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.auJ("ce_reg_eu"));
      i = 16;
      if (!com.tencent.mm.aw.b.Gx(this.jpb.countryCode)) {
        i = 30;
      }
      ((eby)localObject).Ihs = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.MC(i));
      ((eby)localObject).Ihw = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.dyh());
      parama.a((eby)localObject);
      com.tencent.mm.kernel.g.ajj().a(parama, 0);
      this.jpc = this.jpb.jpr.getText().toString();
      this.jpe += 1;
      break;
      if ((this.jpc != null) && (this.jpd != null) && (!this.jpd.equals(this.jpc)) && (!((String)localObject).equals(this.jpd))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128296);
    this.jpb = paramMobileInputUI;
    String str = "";
    if ((d.FFK) || (j.IS_FLAVOR_BLUE)) {
      str = "" + com.tencent.mm.cc.g.ix(paramMobileInputUI);
    }
    paramMobileInputUI.setMMTitle(str);
    paramMobileInputUI.showOptionMenu(false);
    paramMobileInputUI.jpy.setVisibility(0);
    paramMobileInputUI.jpy.setVisibility(0);
    paramMobileInputUI.jcU.setVisibility(0);
    paramMobileInputUI.jpr.setVisibility(0);
    paramMobileInputUI.jps.requestFocus();
    paramMobileInputUI.jpu.setVisibility(0);
    paramMobileInputUI.joI.setVisibility(0);
    paramMobileInputUI.jpC.setVisibility(8);
    paramMobileInputUI.jpx.setVisibility(0);
    paramMobileInputUI.jpx.setText(2131760798);
    paramMobileInputUI.jpw.setOnClickListener(new k.1(this, paramMobileInputUI));
    AppMethodBeat.o(128296);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128300);
    ae.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jpb.jfk != null)
    {
      this.jpb.jfk.dismiss();
      this.jpb.jfk = null;
    }
    if (paramInt2 == -75)
    {
      h.l(this.jpb, 2131755266, 2131762275);
      AppMethodBeat.o(128300);
      return;
    }
    if (paramn.getType() == 145)
    {
      if ((paramInt2 == -41) || (paramInt2 == -59))
      {
        paramString = com.tencent.mm.h.a.uU(paramString);
        if (paramString != null)
        {
          paramString.a(this.jpb, null, null);
          AppMethodBeat.o(128300);
          return;
        }
        h.l(this.jpb, 2131762328, 2131762329);
        AppMethodBeat.o(128300);
        return;
      }
      int i = ((com.tencent.mm.modelfriend.a)paramn).KZ();
      if (i == 12)
      {
        this.jpb.jpF = bb.aSf(this.jpb.jpF);
        this.jpd = (this.jpb.jpE + this.jpb.jpF);
        this.jpk = ((com.tencent.mm.modelfriend.a)paramn).aIb();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramn = ((com.tencent.mm.modelfriend.a)paramn).aHP();
          if (!bu.isNullOrNil(paramn)) {
            this.jpb.jpF = paramn.trim();
          }
          paramn = new StringBuilder();
          com.tencent.mm.kernel.g.ajP();
          paramn = paramn.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_200,");
          com.tencent.mm.kernel.g.ajP();
          com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("R200_200") + ",1");
          paramString = com.tencent.mm.h.a.uU(paramString);
          if (paramString != null)
          {
            paramString.a(this.jpb, new k.3(this), new k.4(this));
            AppMethodBeat.o(128300);
            return;
          }
          aUz();
          paramString = new StringBuilder();
          com.tencent.mm.kernel.g.ajP();
          paramString = paramString.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_200,");
          com.tencent.mm.kernel.g.ajP();
          com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("R200_200") + ",2");
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -355)
        {
          y.g(this.jpb, paramString, 32046);
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -34)
        {
          h.c(this.jpb, this.jpb.getString(2131756462), "", true);
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
        if (((com.tencent.mm.modelfriend.a)paramn).aHQ() != 1) {
          break label849;
        }
        localObject = this.jpb.jpE + this.jpb.jpF;
        String str1 = ((com.tencent.mm.modelfriend.a)paramn).aHS();
        String str2 = ((com.tencent.mm.modelfriend.a)paramn).aHR();
        paramn = new Intent(this.jpb, RegByMobileSendSmsUI.class);
        paramn.putExtra("from_mobile", (String)localObject);
        paramn.putExtra("to_mobile", str1);
        paramn.putExtra("verify_code", str2);
        paramn.putExtra("key_reg_style", 2);
        paramn.putExtra("kintent_password", this.jpb.jnE.getText().toString());
        paramn.putExtra("regsession_id", this.jpk);
        localObject = this.jpb;
        paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramn.ahE(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileInputUI)localObject).startActivity((Intent)paramn.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      label849:
      do
      {
        for (;;)
        {
          paramString = com.tencent.mm.h.a.uU(paramString);
          if ((paramString == null) || (this.jpb == null) || (!paramString.a(this.jpb, null, null))) {
            break;
          }
          AppMethodBeat.o(128300);
          return;
          com.tencent.mm.plugin.b.a.KB("R200_300");
          localObject = new Intent();
          ((Intent)localObject).putExtra("bindmcontact_mobile", this.jpb.jpE + " " + this.jpb.jpr.getText().toString());
          ((Intent)localObject).putExtra("bindmcontact_shortmobile", this.jpb.jpF);
          ((Intent)localObject).putExtra("country_name", this.jpb.ihe);
          ((Intent)localObject).putExtra("couttry_code", this.jpb.countryCode);
          ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramn).aHV());
          ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramn).aHW());
          ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramn).aHX());
          ((Intent)localObject).putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramn).aHY());
          ((Intent)localObject).putExtra("key_reg_style", 2);
          ((Intent)localObject).putExtra("kintent_password", this.jpb.jnE.getText().toString());
          ((Intent)localObject).putExtra("mobile_verify_purpose", 2);
          ((Intent)localObject).putExtra("regsession_id", this.jpk);
          ((Intent)localObject).setClass(this.jpb, MobileVerifyUI.class);
          paramn = this.jpb;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramn, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.account.model.l.a(l.a.jkB);
        }
        if (paramInt2 == -34)
        {
          h.c(this.jpb, this.jpb.getString(2131756462), "", true);
          AppMethodBeat.o(128300);
          return;
        }
      } while (!com.tencent.mm.plugin.account.a.a.iUA.a(this.jpb, paramInt1, paramInt2, paramString));
      label1193:
      AppMethodBeat.o(128300);
      return;
    }
    AppMethodBeat.o(128300);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128297);
    com.tencent.mm.kernel.g.ajj().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_100,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("R200_100") + ",1");
    com.tencent.mm.plugin.b.a.KA("R200_100");
    this.jpe = 0;
    AppMethodBeat.o(128297);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128298);
    com.tencent.mm.kernel.g.ajj().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_100,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("R200_100") + ",2");
    AppMethodBeat.o(128298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.k
 * JD-Core Version:    0.7.0.1
 */