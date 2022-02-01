package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.model.l;
import com.tencent.mm.plugin.account.model.l.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class k
  implements com.tencent.mm.ak.g, MobileInputUI.b
{
  private MobileInputUI iSZ;
  private String iTa;
  private String iTb;
  private int iTc = 0;
  private String iTi;
  int iTj = 1;
  
  private void aQO()
  {
    AppMethodBeat.i(128301);
    Object localObject = this.iSZ;
    MobileInputUI localMobileInputUI = this.iSZ;
    this.iSZ.getString(2131755906);
    ((MobileInputUI)localObject).iJi = h.b(localMobileInputUI, this.iSZ.getString(2131762310), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = new com.tencent.mm.modelfriend.a(this.iSZ.iTC + this.iSZ.iTD, 14, "", 0, "");
    ((com.tencent.mm.modelfriend.a)localObject).BY(this.iTi);
    com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
    AppMethodBeat.o(128301);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128299);
    switch (6.iTe[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128299);
      return;
    }
    this.iSZ.hideVKB();
    if (!this.iSZ.iTt.isChecked())
    {
      parama = AnimationUtils.loadAnimation(this.iSZ, 2130771990);
      this.iSZ.iTs.startAnimation(parama);
      AppMethodBeat.o(128299);
      return;
    }
    switch (this.iTj)
    {
    default: 
      this.iSZ.iTC = az.aLe(this.iSZ.countryCode);
      this.iSZ.iTD = this.iSZ.iTp.getText().toString();
      parama = this.iSZ.iTC + this.iSZ.iTD;
      if (com.tencent.mm.plugin.account.a.b.a.O(this.iSZ, this.iSZ.iRC.getText().toString()))
      {
        if ((this.iSZ.iJi == null) || (!this.iSZ.iJi.isShowing())) {
          break label324;
        }
        ac.d("MicroMsg.MobileInputRegLogic", "already checking ");
      }
      break;
    }
    for (;;)
    {
      this.iTj = 0;
      break;
      aQO();
      continue;
      parama = this.iSZ.getString(2131760685, new Object[] { ab.eUO(), com.tencent.mm.aw.b.br(this.iSZ.countryCode, this.iSZ.getString(2131757950)), "reg", Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.plugin.account.a.b.a.b(this.iSZ, parama, 32047, false);
    }
    label324:
    Object localObject = this.iSZ;
    MobileInputUI localMobileInputUI = this.iSZ;
    this.iSZ.getString(2131755906);
    ((MobileInputUI)localObject).iJi = h.b(localMobileInputUI, this.iSZ.getString(2131762310), true, new k.2(this));
    localObject = this.iSZ.iTp.getText().toString();
    int i;
    if ((this.iTa != null) && (this.iTb != null) && (!((String)localObject).equals(this.iTa)) && (((String)localObject).equals(this.iTb))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.oG(this.iTc);
      parama.oH(i);
      if (com.tencent.mm.plugin.normsg.a.b.vor.aos("ie_reg_eu")) {
        com.tencent.mm.plugin.normsg.a.b.vor.aor("ie_reg_eu");
      }
      localObject = new dun();
      ((dun)localObject).Gcm = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.aot("ie_reg_eu"));
      ((dun)localObject).Gcn = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.aow("ce_reg_eu"));
      i = 16;
      if (!com.tencent.mm.aw.b.CR(this.iSZ.countryCode)) {
        i = 30;
      }
      ((dun)localObject).Gco = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.Kv(i));
      ((dun)localObject).Gcs = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.vor.dkF());
      parama.a((dun)localObject);
      com.tencent.mm.kernel.g.agi().a(parama, 0);
      this.iTa = this.iSZ.iTp.getText().toString();
      this.iTc += 1;
      break;
      if ((this.iTa != null) && (this.iTb != null) && (!this.iTb.equals(this.iTa)) && (!((String)localObject).equals(this.iTb))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128296);
    this.iSZ = paramMobileInputUI;
    String str = "";
    if (d.DIf) {
      str = "" + paramMobileInputUI.getString(2131755263);
    }
    paramMobileInputUI.setMMTitle(str);
    paramMobileInputUI.showOptionMenu(false);
    paramMobileInputUI.iTw.setVisibility(0);
    paramMobileInputUI.iTw.setVisibility(0);
    paramMobileInputUI.iGS.setVisibility(0);
    paramMobileInputUI.iTp.setVisibility(0);
    paramMobileInputUI.iTq.requestFocus();
    paramMobileInputUI.iTs.setVisibility(0);
    paramMobileInputUI.iSG.setVisibility(0);
    paramMobileInputUI.iTA.setVisibility(8);
    paramMobileInputUI.iTv.setVisibility(0);
    paramMobileInputUI.iTv.setText(2131760798);
    paramMobileInputUI.iTu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128292);
        paramAnonymousView = com.tencent.mm.aw.b.br(paramMobileInputUI.countryCode, paramMobileInputUI.getString(2131757950));
        com.tencent.mm.plugin.account.a.b.a.b(paramMobileInputUI, paramMobileInputUI.getString(2131764600, new Object[] { ab.eUO(), paramAnonymousView }), 0, false);
        AppMethodBeat.o(128292);
      }
    });
    AppMethodBeat.o(128296);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128300);
    ac.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iSZ.iJi != null)
    {
      this.iSZ.iJi.dismiss();
      this.iSZ.iJi = null;
    }
    if (paramInt2 == -75)
    {
      h.l(this.iSZ, 2131755266, 2131762275);
      AppMethodBeat.o(128300);
      return;
    }
    if (paramn.getType() == 145)
    {
      if ((paramInt2 == -41) || (paramInt2 == -59))
      {
        paramString = com.tencent.mm.h.a.rM(paramString);
        if (paramString != null)
        {
          paramString.a(this.iSZ, null, null);
          AppMethodBeat.o(128300);
          return;
        }
        h.l(this.iSZ, 2131762328, 2131762329);
        AppMethodBeat.o(128300);
        return;
      }
      int i = ((com.tencent.mm.modelfriend.a)paramn).Js();
      if (i == 12)
      {
        this.iSZ.iTD = az.aLc(this.iSZ.iTD);
        this.iTb = (this.iSZ.iTC + this.iSZ.iTD);
        this.iTi = ((com.tencent.mm.modelfriend.a)paramn).aEF();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramn = ((com.tencent.mm.modelfriend.a)paramn).aEt();
          if (!bs.isNullOrNil(paramn)) {
            this.iSZ.iTD = paramn.trim();
          }
          paramn = new StringBuilder();
          com.tencent.mm.kernel.g.agP();
          paramn = paramn.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_200,");
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("R200_200") + ",1");
          paramString = com.tencent.mm.h.a.rM(paramString);
          if (paramString != null)
          {
            paramString.a(this.iSZ, new k.3(this), new k.4(this));
            AppMethodBeat.o(128300);
            return;
          }
          aQO();
          paramString = new StringBuilder();
          com.tencent.mm.kernel.g.agP();
          paramString = paramString.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_200,");
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("R200_200") + ",2");
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -355)
        {
          y.g(this.iSZ, paramString, 32046);
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -34)
        {
          h.c(this.iSZ, this.iSZ.getString(2131756462), "", true);
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
        if (((com.tencent.mm.modelfriend.a)paramn).aEu() != 1) {
          break label849;
        }
        localObject = this.iSZ.iTC + this.iSZ.iTD;
        String str1 = ((com.tencent.mm.modelfriend.a)paramn).aEw();
        String str2 = ((com.tencent.mm.modelfriend.a)paramn).aEv();
        paramn = new Intent(this.iSZ, RegByMobileSendSmsUI.class);
        paramn.putExtra("from_mobile", (String)localObject);
        paramn.putExtra("to_mobile", str1);
        paramn.putExtra("verify_code", str2);
        paramn.putExtra("key_reg_style", 2);
        paramn.putExtra("kintent_password", this.iSZ.iRC.getText().toString());
        paramn.putExtra("regsession_id", this.iTi);
        localObject = this.iSZ;
        paramn = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramn.aeD(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileInputUI)localObject).startActivity((Intent)paramn.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      label849:
      do
      {
        for (;;)
        {
          paramString = com.tencent.mm.h.a.rM(paramString);
          if ((paramString == null) || (this.iSZ == null) || (!paramString.a(this.iSZ, null, null))) {
            break;
          }
          AppMethodBeat.o(128300);
          return;
          com.tencent.mm.plugin.b.a.IL("R200_300");
          localObject = new Intent();
          ((Intent)localObject).putExtra("bindmcontact_mobile", this.iSZ.iTC + " " + this.iSZ.iTp.getText().toString());
          ((Intent)localObject).putExtra("bindmcontact_shortmobile", this.iSZ.iTD);
          ((Intent)localObject).putExtra("country_name", this.iSZ.hLr);
          ((Intent)localObject).putExtra("couttry_code", this.iSZ.countryCode);
          ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramn).aEz());
          ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramn).aEA());
          ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramn).aEB());
          ((Intent)localObject).putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramn).aEC());
          ((Intent)localObject).putExtra("key_reg_style", 2);
          ((Intent)localObject).putExtra("kintent_password", this.iSZ.iRC.getText().toString());
          ((Intent)localObject).putExtra("mobile_verify_purpose", 2);
          ((Intent)localObject).putExtra("regsession_id", this.iTi);
          ((Intent)localObject).setClass(this.iSZ, MobileVerifyUI.class);
          paramn = this.iSZ;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramn, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          l.a(l.a.iOz);
        }
        if (paramInt2 == -34)
        {
          h.c(this.iSZ, this.iSZ.getString(2131756462), "", true);
          AppMethodBeat.o(128300);
          return;
        }
      } while (!com.tencent.mm.plugin.account.a.a.iyy.a(this.iSZ, paramInt1, paramInt2, paramString));
      label1193:
      AppMethodBeat.o(128300);
      return;
    }
    AppMethodBeat.o(128300);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128297);
    com.tencent.mm.kernel.g.agi().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_100,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("R200_100") + ",1");
    com.tencent.mm.plugin.b.a.IK("R200_100");
    this.iTc = 0;
    AppMethodBeat.o(128297);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128298);
    com.tencent.mm.kernel.g.agi().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_100,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("R200_100") + ",2");
    AppMethodBeat.o(128298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.k
 * JD-Core Version:    0.7.0.1
 */