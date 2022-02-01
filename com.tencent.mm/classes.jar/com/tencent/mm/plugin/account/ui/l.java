package com.tencent.mm.plugin.account.ui;

import android.content.Context;
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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.model.m;
import com.tencent.mm.plugin.account.model.m.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFormInputView;

public final class l
  implements i, MobileInputUI.b
{
  private MobileInputUI knl;
  private String knm;
  private String knn;
  private int kno = 0;
  private String knu;
  int knv = 1;
  
  private void bpm()
  {
    AppMethodBeat.i(128301);
    Object localObject = this.knl;
    MobileInputUI localMobileInputUI = this.knl;
    this.knl.getString(2131755998);
    ((MobileInputUI)localObject).kdn = com.tencent.mm.ui.base.h.a(localMobileInputUI, this.knl.getString(2131764376), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    localObject = new com.tencent.mm.modelfriend.a(this.knl.knO + this.knl.knP, 14, "", 0, "");
    ((com.tencent.mm.modelfriend.a)localObject).Ok(this.knu);
    g.azz().a((com.tencent.mm.ak.q)localObject, 0);
    AppMethodBeat.o(128301);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128299);
    switch (6.knq[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(128299);
      return;
    }
    this.knl.hideVKB();
    if (!this.knl.knF.isChecked())
    {
      parama = AnimationUtils.loadAnimation(this.knl, 2130771995);
      this.knl.knE.startAnimation(parama);
      AppMethodBeat.o(128299);
      return;
    }
    switch (this.knv)
    {
    default: 
      this.knl.knO = PhoneFormater.countryCodeWithPlus(this.knl.countryCode);
      this.knl.knP = this.knl.knB.getText().toString();
      parama = this.knl.knO + this.knl.knP;
      if (com.tencent.mm.plugin.account.a.b.a.V(this.knl, this.knl.klM.getText().toString()))
      {
        if ((this.knl.kdn == null) || (!this.knl.kdn.isShowing())) {
          break label324;
        }
        Log.d("MicroMsg.MobileInputRegLogic", "already checking ");
      }
      break;
    }
    for (;;)
    {
      this.knv = 0;
      break;
      bpm();
      continue;
      parama = this.knl.getString(2131762219, new Object[] { LocaleUtil.getApplicationLanguage(), com.tencent.mm.aw.b.bu(this.knl.countryCode, this.knl.getString(2131758198)), "reg", Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.plugin.account.a.b.a.b(this.knl, parama, 32047, false);
    }
    label324:
    Object localObject1 = this.knl;
    Object localObject2 = this.knl;
    this.knl.getString(2131755998);
    ((MobileInputUI)localObject1).kdn = com.tencent.mm.ui.base.h.a((Context)localObject2, this.knl.getString(2131764376), true, new l.2(this));
    localObject1 = this.knl.knB.getText().toString();
    int i;
    if ((this.knm != null) && (this.knn != null) && (!((String)localObject1).equals(this.knm)) && (((String)localObject1).equals(this.knn))) {
      i = 1;
    }
    for (;;)
    {
      parama = new com.tencent.mm.modelfriend.a(parama, 12, "", 0, "");
      parama.sZ(this.kno);
      parama.ta(i);
      if (com.tencent.mm.plugin.normsg.a.d.AEF.aIO("ie_reg_eu")) {
        com.tencent.mm.plugin.normsg.a.d.AEF.aIN("ie_reg_eu");
      }
      localObject1 = new ewf();
      ((ewf)localObject1).NtO = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.aIP("ie_reg_eu"));
      ((ewf)localObject1).NtP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.aIS("ce_reg"));
      ((ewf)localObject1).NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exJ());
      ((ewf)localObject1).NtU = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exM());
      localObject2 = com.tencent.mm.plugin.normsg.a.d.AEF.aIT("ce_reg");
      if (localObject2 != null) {
        ((ewf)localObject1).NtV = new SKBuiltinBuffer_t().setBuffer(((String)localObject2).getBytes());
      }
      parama.a((ewf)localObject1);
      g.azz().a(parama, 0);
      this.knm = this.knl.knB.getText().toString();
      this.kno += 1;
      break;
      if ((this.knm != null) && (this.knn != null) && (!this.knn.equals(this.knm)) && (!((String)localObject1).equals(this.knn))) {
        i = 2;
      } else {
        i = 0;
      }
    }
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128296);
    this.knl = paramMobileInputUI;
    String str = "";
    if ((com.tencent.mm.protocal.d.KyR) || (BuildInfo.IS_FLAVOR_BLUE)) {
      str = "" + com.tencent.mm.cc.h.jr(paramMobileInputUI);
    }
    paramMobileInputUI.setMMTitle(str);
    paramMobileInputUI.showOptionMenu(false);
    paramMobileInputUI.knI.setVisibility(0);
    paramMobileInputUI.knI.setVisibility(0);
    paramMobileInputUI.kaX.setVisibility(0);
    paramMobileInputUI.knB.setVisibility(0);
    paramMobileInputUI.knC.requestFocus();
    paramMobileInputUI.knE.setVisibility(0);
    paramMobileInputUI.kmS.setVisibility(0);
    paramMobileInputUI.knM.setVisibility(8);
    paramMobileInputUI.knH.setVisibility(0);
    paramMobileInputUI.knH.setText(2131762551);
    paramMobileInputUI.knG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(128292);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputRegLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = com.tencent.mm.aw.b.bu(paramMobileInputUI.countryCode, paramMobileInputUI.getString(2131758198));
        com.tencent.mm.plugin.account.a.b.a.b(paramMobileInputUI, paramMobileInputUI.getString(2131766959, new Object[] { LocaleUtil.getApplicationLanguage(), paramAnonymousView }), 0, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(128292);
      }
    });
    AppMethodBeat.o(128296);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128300);
    Log.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.knl.kdn != null)
    {
      this.knl.kdn.dismiss();
      this.knl.kdn = null;
    }
    if (paramInt2 == -75)
    {
      com.tencent.mm.ui.base.h.n(this.knl, 2131755301, 2131764341);
      AppMethodBeat.o(128300);
      return;
    }
    if (paramq.getType() == 145)
    {
      if ((paramInt2 == -41) || (paramInt2 == -59))
      {
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if (paramString != null)
        {
          paramString.a(this.knl, null, null);
          AppMethodBeat.o(128300);
          return;
        }
        com.tencent.mm.ui.base.h.n(this.knl, 2131764394, 2131764395);
        AppMethodBeat.o(128300);
        return;
      }
      int i = ((com.tencent.mm.modelfriend.a)paramq).Vj();
      if (i == 12)
      {
        this.knl.knP = PhoneFormater.pureNumber(this.knl.knP);
        this.knn = (this.knl.knO + this.knl.knP);
        this.knu = ((com.tencent.mm.modelfriend.a)paramq).bbU();
        if ((paramInt2 == -36) || (paramInt2 == -35) || (paramInt2 == -3))
        {
          paramq = ((com.tencent.mm.modelfriend.a)paramq).bbI();
          if (!Util.isNullOrNil(paramq)) {
            this.knl.knP = paramq.trim();
          }
          paramq = new StringBuilder();
          g.aAf();
          paramq = paramq.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_200,");
          g.aAf();
          com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R200_200") + ",1");
          paramString = com.tencent.mm.h.a.Dk(paramString);
          if (paramString != null)
          {
            paramString.a(this.knl, new l.3(this), new l.4(this));
            AppMethodBeat.o(128300);
            return;
          }
          bpm();
          paramString = new StringBuilder();
          g.aAf();
          paramString = paramString.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_200,");
          g.aAf();
          com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R200_200") + ",2");
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -355)
        {
          y.g(this.knl, paramString, 32046);
          AppMethodBeat.o(128300);
          return;
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.c(this.knl, this.knl.getString(2131756598), "", true);
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
        if (((com.tencent.mm.modelfriend.a)paramq).bbJ() != 1) {
          break label849;
        }
        localObject = this.knl.knO + this.knl.knP;
        String str1 = ((com.tencent.mm.modelfriend.a)paramq).bbL();
        String str2 = ((com.tencent.mm.modelfriend.a)paramq).bbK();
        paramq = new Intent(this.knl, RegByMobileSendSmsUI.class);
        paramq.putExtra("from_mobile", (String)localObject);
        paramq.putExtra("to_mobile", str1);
        paramq.putExtra("verify_code", str2);
        paramq.putExtra("key_reg_style", 2);
        paramq.putExtra("kintent_password", this.knl.klM.getText().toString());
        paramq.putExtra("regsession_id", this.knu);
        localObject = this.knl;
        paramq = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramq.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileInputUI)localObject).startActivity((Intent)paramq.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      label849:
      do
      {
        for (;;)
        {
          paramString = com.tencent.mm.h.a.Dk(paramString);
          if ((paramString == null) || (this.knl == null) || (!paramString.a(this.knl, null, null))) {
            break;
          }
          AppMethodBeat.o(128300);
          return;
          com.tencent.mm.plugin.b.a.bwV("R200_300");
          localObject = new Intent();
          ((Intent)localObject).putExtra("bindmcontact_mobile", this.knl.knO + " " + this.knl.knB.getText().toString());
          ((Intent)localObject).putExtra("bindmcontact_shortmobile", this.knl.knP);
          ((Intent)localObject).putExtra("country_name", this.knl.jbZ);
          ((Intent)localObject).putExtra("couttry_code", this.knl.countryCode);
          ((Intent)localObject).putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a)paramq).bbO());
          ((Intent)localObject).putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a)paramq).bbP());
          ((Intent)localObject).putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a)paramq).bbQ());
          ((Intent)localObject).putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a)paramq).bbR());
          ((Intent)localObject).putExtra("key_reg_style", 2);
          ((Intent)localObject).putExtra("kintent_password", this.knl.klM.getText().toString());
          ((Intent)localObject).putExtra("mobile_verify_purpose", 2);
          ((Intent)localObject).putExtra("regsession_id", this.knu);
          ((Intent)localObject).setClass(this.knl, MobileVerifyUI.class);
          paramq = this.knl;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramq, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramq.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramq, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          m.a(m.a.kiE);
        }
        if (paramInt2 == -34)
        {
          com.tencent.mm.ui.base.h.c(this.knl, this.knl.getString(2131756598), "", true);
          AppMethodBeat.o(128300);
          return;
        }
      } while (!com.tencent.mm.plugin.account.a.a.jRu.a(this.knl, paramInt1, paramInt2, paramString));
      label1193:
      AppMethodBeat.o(128300);
      return;
    }
    AppMethodBeat.o(128300);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128297);
    g.azz().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_100,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("R200_100") + ",1");
    com.tencent.mm.plugin.b.a.bwU("R200_100");
    this.kno = 0;
    AppMethodBeat.o(128297);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128298);
    g.azz().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_100,");
    g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("R200_100") + ",2");
    AppMethodBeat.o(128298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l
 * JD-Core Version:    0.7.0.1
 */