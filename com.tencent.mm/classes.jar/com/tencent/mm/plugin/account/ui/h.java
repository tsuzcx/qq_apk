package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.p;

public final class h
  implements com.tencent.mm.al.g, MobileInputUI.b
{
  private MobileInputUI isU;
  private String isV;
  private String isW;
  private int isX = 0;
  
  private void aJX()
  {
    AppMethodBeat.i(128272);
    Object localObject = this.isU;
    MobileInputUI localMobileInputUI = this.isU;
    this.isU.getString(2131755906);
    ((MobileInputUI)localObject).ijb = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.isU.getString(2131762310), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = new com.tencent.mm.modelfriend.a(this.isU.itx + this.isU.ity, 8, "", 0, "");
    com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
    AppMethodBeat.o(128272);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128270);
    switch (5.isZ[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128270);
      return;
    }
    this.isU.itx = ba.aFN(this.isU.countryCode);
    this.isU.ity = this.isU.itk.getText().toString();
    parama = this.isU.itx + this.isU.ity;
    if (this.isU.ijb != null)
    {
      ad.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
      AppMethodBeat.o(128270);
      return;
    }
    Object localObject = this.isU;
    MobileInputUI localMobileInputUI = this.isU;
    this.isU.getString(2131755906);
    ((MobileInputUI)localObject).ijb = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.isU.getString(2131762310), true, new DialogInterface.OnCancelListener()
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
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128267);
    this.isU = paramMobileInputUI;
    paramMobileInputUI.itl.requestFocus();
    paramMobileInputUI.showVKB();
    String str2 = paramMobileInputUI.getString(2131762371);
    String str1 = str2;
    if (d.CpN) {
      str1 = str2 + paramMobileInputUI.getString(2131755263);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.igJ.setVisibility(0);
    paramMobileInputUI.itk.setVisibility(0);
    paramMobileInputUI.itl.requestFocus();
    paramMobileInputUI.itq.setText(2131755830);
    paramMobileInputUI.itq.setVisibility(0);
    AppMethodBeat.o(128267);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128271);
    ad.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.isU.ijb != null)
    {
      this.isU.ijb.dismiss();
      this.isU.ijb = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.j(this.isU, 2131755266, 2131762275);
      AppMethodBeat.o(128271);
      return;
    }
    if ((paramInt2 == -41) || (paramInt2 == -59))
    {
      paramString = com.tencent.mm.h.a.oG(paramString);
      if (paramString != null)
      {
        paramString.a(this.isU, null, null);
        AppMethodBeat.o(128271);
        return;
      }
      com.tencent.mm.ui.base.h.j(this.isU, 2131762328, 2131762329);
      AppMethodBeat.o(128271);
      return;
    }
    if (paramn.getType() == 145)
    {
      int i = ((com.tencent.mm.modelfriend.a)paramn).JJ();
      if (i == 12)
      {
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramn = ((com.tencent.mm.modelfriend.a)paramn).axB();
          if (!bt.isNullOrNil(paramn)) {
            this.isU.ity = paramn.trim();
          }
          this.isU.ity = ba.aFL(this.isU.ity);
          this.isW = (this.isU.itx + this.isU.ity);
          paramn = new StringBuilder();
          com.tencent.mm.kernel.g.afz();
          paramn = paramn.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",F200_200,");
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("F200_200") + ",1");
          paramString = com.tencent.mm.h.a.oG(paramString);
          if (paramString != null)
          {
            paramString.a(this.isU, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128264);
                h.a(h.this);
                paramAnonymousDialogInterface = new StringBuilder();
                com.tencent.mm.kernel.g.afz();
                paramAnonymousDialogInterface = paramAnonymousDialogInterface.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",F200_200,");
                com.tencent.mm.kernel.g.afz();
                com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("F200_200") + ",2");
                AppMethodBeat.o(128264);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128265);
                paramAnonymousDialogInterface = new StringBuilder();
                com.tencent.mm.kernel.g.afz();
                paramAnonymousDialogInterface = paramAnonymousDialogInterface.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",F200_200,");
                com.tencent.mm.kernel.g.afz();
                com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("F200_200") + ",2");
                AppMethodBeat.o(128265);
              }
            });
            AppMethodBeat.o(128271);
            return;
          }
          aJX();
          paramString = new StringBuilder();
          com.tencent.mm.kernel.g.afz();
          paramString = paramString.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",F200_200,");
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("F200_200") + ",2");
          AppMethodBeat.o(128271);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.c(this.isU, this.isU.getString(2131756462), "", true);
          AppMethodBeat.o(128271);
          return;
        }
        Toast.makeText(this.isU, this.isU.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      if ((i == 8) && (paramInt2 == 0))
      {
        paramString = new Intent();
        paramString.putExtra("bindmcontact_mobile", this.isU.itx + " " + this.isU.itk.getText().toString());
        paramString.putExtra("bindmcontact_shortmobile", this.isU.ity);
        paramString.putExtra("country_name", this.isU.hkO);
        paramString.putExtra("couttry_code", this.isU.countryCode);
        paramString.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramn).axH());
        paramString.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramn).axI());
        paramString.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramn).axJ());
        paramString.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramn).axK());
        paramString.putExtra("mobile_verify_purpose", 3);
        paramString.setClass(this.isU, MobileVerifyUI.class);
        paramn = this.isU;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.adn(), "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramn.startActivity((Intent)paramString.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    AppMethodBeat.o(128271);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128268);
    com.tencent.mm.kernel.g.aeS().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",F200_100,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("F200_100") + ",1");
    com.tencent.mm.plugin.b.a.aUy("F200_100");
    this.isX = 0;
    AppMethodBeat.o(128268);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128269);
    com.tencent.mm.kernel.g.aeS().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",F200_100,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("F200_100") + ",2");
    AppMethodBeat.o(128269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.h
 * JD-Core Version:    0.7.0.1
 */