package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.model.l;
import com.tencent.mm.plugin.account.model.l.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class k
  implements com.tencent.mm.al.g, MobileInputUI.b
{
  private MobileInputUI isU;
  private String isV;
  private String isW;
  private int isX = 0;
  private String itd;
  int ite = 1;
  
  private void aJX()
  {
    AppMethodBeat.i(128301);
    Object localObject = this.isU;
    MobileInputUI localMobileInputUI = this.isU;
    this.isU.getString(2131755906);
    ((MobileInputUI)localObject).ijb = h.b(localMobileInputUI, this.isU.getString(2131762310), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = new com.tencent.mm.modelfriend.a(this.isU.itx + this.isU.ity, 14, "", 0, "");
    ((com.tencent.mm.modelfriend.a)localObject).xT(this.itd);
    com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
    AppMethodBeat.o(128301);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128299);
    switch (6.isZ[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128299);
      return;
    }
    this.isU.hideVKB();
    if (!this.isU.ito.isChecked())
    {
      parama = AnimationUtils.loadAnimation(this.isU, 2130771990);
      this.isU.itn.startAnimation(parama);
      AppMethodBeat.o(128299);
      return;
    }
    switch (this.ite)
    {
    default: 
      this.isU.itx = ba.aFN(this.isU.countryCode);
      this.isU.ity = this.isU.itk.getText().toString();
      parama = this.isU.itx + this.isU.ity;
      if (com.tencent.mm.plugin.account.a.b.a.N(this.isU, this.isU.irx.getText().toString()))
      {
        if ((this.isU.ijb == null) || (!this.isU.ijb.isShowing())) {
          break label324;
        }
        ad.d("MicroMsg.MobileInputRegLogic", "already checking ");
      }
      break;
    }
    for (;;)
    {
      this.ite = 0;
      break;
      aJX();
      continue;
      parama = this.isU.getString(2131760685, new Object[] { ac.eFu(), com.tencent.mm.ax.b.bj(this.isU.countryCode, this.isU.getString(2131757950)), "reg", Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.plugin.account.a.b.a.b(this.isU, parama, 32047, false);
    }
    label324:
    Object localObject = this.isU;
    MobileInputUI localMobileInputUI = this.isU;
    this.isU.getString(2131755906);
    ((MobileInputUI)localObject).ijb = h.b(localMobileInputUI, this.isU.getString(2131762310), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = this.isU.itk.getText().toString();
    int i;
    if ((this.isV != null) && (this.isW != null) && (!((String)localObject).equals(this.isV)) && (((String)localObject).equals(this.isW))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.nS(this.isX);
      parama.nT(i);
      if (com.tencent.mm.plugin.normsg.a.b.ufs.aju("ie_reg_eu")) {
        com.tencent.mm.plugin.normsg.a.b.ufs.ajt("ie_reg_eu");
      }
      localObject = new dow();
      ((dow)localObject).EFa = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.ajv("ie_reg_eu"));
      ((dow)localObject).EFb = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.ajy("ce_reg_eu"));
      i = 16;
      if (!com.tencent.mm.ax.b.yM(this.isU.countryCode)) {
        i = 30;
      }
      ((dow)localObject).EFc = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.Iw(i));
      ((dow)localObject).EFg = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.ufs.cWX());
      parama.a((dow)localObject);
      com.tencent.mm.kernel.g.aeS().a(parama, 0);
      this.isV = this.isU.itk.getText().toString();
      this.isX += 1;
      break;
      if ((this.isV != null) && (this.isW != null) && (!this.isW.equals(this.isV)) && (!((String)localObject).equals(this.isW))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128296);
    this.isU = paramMobileInputUI;
    String str = "";
    if (d.CpN) {
      str = "" + paramMobileInputUI.getString(2131755263);
    }
    paramMobileInputUI.setMMTitle(str);
    paramMobileInputUI.showOptionMenu(false);
    paramMobileInputUI.itr.setVisibility(0);
    paramMobileInputUI.itr.setVisibility(0);
    paramMobileInputUI.igJ.setVisibility(0);
    paramMobileInputUI.itk.setVisibility(0);
    paramMobileInputUI.itl.requestFocus();
    paramMobileInputUI.itn.setVisibility(0);
    paramMobileInputUI.isB.setVisibility(0);
    paramMobileInputUI.itv.setVisibility(8);
    paramMobileInputUI.itq.setVisibility(0);
    paramMobileInputUI.itq.setText(2131760798);
    paramMobileInputUI.itp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128292);
        paramAnonymousView = com.tencent.mm.ax.b.bj(paramMobileInputUI.countryCode, paramMobileInputUI.getString(2131757950));
        com.tencent.mm.plugin.account.a.b.a.b(paramMobileInputUI, paramMobileInputUI.getString(2131764600, new Object[] { ac.eFu(), paramAnonymousView }), 0, false);
        AppMethodBeat.o(128292);
      }
    });
    AppMethodBeat.o(128296);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128300);
    ad.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.isU.ijb != null)
    {
      this.isU.ijb.dismiss();
      this.isU.ijb = null;
    }
    if (paramInt2 == -75)
    {
      h.j(this.isU, 2131755266, 2131762275);
      AppMethodBeat.o(128300);
      return;
    }
    if (paramn.getType() == 145)
    {
      if ((paramInt2 == -41) || (paramInt2 == -59))
      {
        paramString = com.tencent.mm.h.a.oG(paramString);
        if (paramString != null)
        {
          paramString.a(this.isU, null, null);
          AppMethodBeat.o(128300);
          return;
        }
        h.j(this.isU, 2131762328, 2131762329);
        AppMethodBeat.o(128300);
        return;
      }
      int i = ((com.tencent.mm.modelfriend.a)paramn).JJ();
      if (i == 12)
      {
        this.isU.ity = ba.aFL(this.isU.ity);
        this.isW = (this.isU.itx + this.isU.ity);
        this.itd = ((com.tencent.mm.modelfriend.a)paramn).axN();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramn = ((com.tencent.mm.modelfriend.a)paramn).axB();
          if (!bt.isNullOrNil(paramn)) {
            this.isU.ity = paramn.trim();
          }
          paramn = new StringBuilder();
          com.tencent.mm.kernel.g.afz();
          paramn = paramn.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_200,");
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("R200_200") + ",1");
          paramString = com.tencent.mm.h.a.oG(paramString);
          if (paramString != null)
          {
            paramString.a(this.isU, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128293);
                k.a(k.this);
                AppMethodBeat.o(128293);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128294);
                paramAnonymousDialogInterface = new StringBuilder();
                com.tencent.mm.kernel.g.afz();
                paramAnonymousDialogInterface = paramAnonymousDialogInterface.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_200,");
                com.tencent.mm.kernel.g.afz();
                com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("R200_200") + ",2");
                AppMethodBeat.o(128294);
              }
            });
            AppMethodBeat.o(128300);
            return;
          }
          aJX();
          paramString = new StringBuilder();
          com.tencent.mm.kernel.g.afz();
          paramString = paramString.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_200,");
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("R200_200") + ",2");
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -355)
        {
          y.g(this.isU, paramString, 32046);
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -34)
        {
          h.c(this.isU, this.isU.getString(2131756462), "", true);
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
        if (((com.tencent.mm.modelfriend.a)paramn).axC() != 1) {
          break label849;
        }
        localObject = this.isU.itx + this.isU.ity;
        String str1 = ((com.tencent.mm.modelfriend.a)paramn).axE();
        String str2 = ((com.tencent.mm.modelfriend.a)paramn).axD();
        paramn = new Intent(this.isU, RegByMobileSendSmsUI.class);
        paramn.putExtra("from_mobile", (String)localObject);
        paramn.putExtra("to_mobile", str1);
        paramn.putExtra("verify_code", str2);
        paramn.putExtra("key_reg_style", 2);
        paramn.putExtra("kintent_password", this.isU.irx.getText().toString());
        paramn.putExtra("regsession_id", this.itd);
        localObject = this.isU;
        paramn = new com.tencent.mm.hellhoundlib.b.a().bd(paramn);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramn.adn(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileInputUI)localObject).startActivity((Intent)paramn.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      label849:
      do
      {
        for (;;)
        {
          paramString = com.tencent.mm.h.a.oG(paramString);
          if ((paramString == null) || (this.isU == null) || (!paramString.a(this.isU, null, null))) {
            break;
          }
          AppMethodBeat.o(128300);
          return;
          com.tencent.mm.plugin.b.a.aUz("R200_300");
          localObject = new Intent();
          ((Intent)localObject).putExtra("bindmcontact_mobile", this.isU.itx + " " + this.isU.itk.getText().toString());
          ((Intent)localObject).putExtra("bindmcontact_shortmobile", this.isU.ity);
          ((Intent)localObject).putExtra("country_name", this.isU.hkO);
          ((Intent)localObject).putExtra("couttry_code", this.isU.countryCode);
          ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramn).axH());
          ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramn).axI());
          ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramn).axJ());
          ((Intent)localObject).putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramn).axK());
          ((Intent)localObject).putExtra("key_reg_style", 2);
          ((Intent)localObject).putExtra("kintent_password", this.isU.irx.getText().toString());
          ((Intent)localObject).putExtra("mobile_verify_purpose", 2);
          ((Intent)localObject).putExtra("regsession_id", this.itd);
          ((Intent)localObject).setClass(this.isU, MobileVerifyUI.class);
          paramn = this.isU;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramn, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramn.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          l.a(l.a.iot);
        }
        if (paramInt2 == -34)
        {
          h.c(this.isU, this.isU.getString(2131756462), "", true);
          AppMethodBeat.o(128300);
          return;
        }
      } while (!com.tencent.mm.plugin.account.a.a.hYu.a(this.isU, paramInt1, paramInt2, paramString));
      label1193:
      AppMethodBeat.o(128300);
      return;
    }
    AppMethodBeat.o(128300);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128297);
    com.tencent.mm.kernel.g.aeS().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_100,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("R200_100") + ",1");
    com.tencent.mm.plugin.b.a.aUy("R200_100");
    this.isX = 0;
    AppMethodBeat.o(128297);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128298);
    com.tencent.mm.kernel.g.aeS().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_100,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("R200_100") + ",2");
    AppMethodBeat.o(128298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.k
 * JD-Core Version:    0.7.0.1
 */