package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.ms;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.List;

public final class j
  implements i, MobileInputUI.b
{
  private SecurityImage mUP;
  private ms ncO;
  private h ndp;
  private MobileInputUI nfd;
  
  public j()
  {
    AppMethodBeat.i(128279);
    this.mUP = null;
    this.ndp = null;
    this.ncO = new ms();
    AppMethodBeat.o(128279);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128283);
    switch (7.nfi[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128283);
      return;
      this.nfd.nfG = PhoneFormater.countryCodeWithPlus(this.nfd.countryCode);
      this.nfd.nfH = this.nfd.nfu.getText().toString();
      parama = PhoneFormater.pureNumber(this.nfd.nfG + this.nfd.nfH);
      MobileInputUI localMobileInputUI1 = this.nfd;
      MobileInputUI localMobileInputUI2 = this.nfd;
      this.nfd.getString(r.j.app_tip);
      localMobileInputUI1.mUN = com.tencent.mm.ui.base.h.a(localMobileInputUI2, this.nfd.getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new j.6(this));
      parama = new com.tencent.mm.modelfriend.a(parama, 13, "", 0, "");
      com.tencent.mm.kernel.h.aGY().a(parama, 0);
    }
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128280);
    this.nfd = paramMobileInputUI;
    paramMobileInputUI.mSs.setVisibility(0);
    paramMobileInputUI.nft.setVisibility(0);
    paramMobileInputUI.nfu.requestFocus();
    paramMobileInputUI.nfz.setText(r.j.app_nextstep);
    paramMobileInputUI.nfz.setVisibility(0);
    paramMobileInputUI.nfB.setVisibility(0);
    paramMobileInputUI = new ArrayList();
    final p localp = new p(this.nfd, 2001, 0);
    if (WeChatBrands.AppInfo.current().isMainland()) {
      localp.setTitle(r.j.login_by_other_account);
    }
    for (;;)
    {
      paramMobileInputUI.add(localp);
      localp = new p(this.nfd, 2002, 0);
      if (com.tencent.mm.az.b.bmX())
      {
        localp.setTitle(r.j.login_by_facebook);
        paramMobileInputUI.add(localp);
      }
      if (paramMobileInputUI.size() <= 1) {
        break;
      }
      final e locale = new e(this.nfd, 1, false);
      locale.ODT = new j.1(this, paramMobileInputUI);
      locale.ODU = new j.2(this);
      locale.XbB = new j.3(this);
      this.nfd.nfD.setText(r.j.login_by_other_account_more);
      this.nfd.nfD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128276);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          j.c(j.this).hideVKB();
          locale.eik();
          if (paramMobileInputUI.contains(localp))
          {
            j.d(j.this).gVr = 1L;
            j.d(j.this).gef = 9L;
            j.d(j.this).bpa();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128276);
        }
      });
      this.nfd.nfD.setVisibility(0);
      AppMethodBeat.o(128280);
      return;
      localp.setTitle(r.j.login_by_other_account_oversea);
    }
    if (WeChatBrands.AppInfo.current().isMainland()) {
      this.nfd.nfD.setText(r.j.login_by_other_account);
    }
    for (;;)
    {
      this.nfd.nfD.setOnClickListener(new j.5(this));
      break;
      this.nfd.nfD.setText(r.j.login_by_other_account_oversea);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128284);
    Log.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.nfd.mUN != null)
    {
      this.nfd.mUN.dismiss();
      this.nfd.mUN = null;
    }
    if (((paramq.getType() == 252) || (paramq.getType() == 701)) && (this.ndp != null))
    {
      this.ndp.neP = this.nfd.neP;
      this.ndp.a(this.nfd, paramInt1, paramInt2, paramString, paramq);
      AppMethodBeat.o(128284);
      return;
    }
    if ((paramq.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramq).ZB() == 13))
    {
      if (paramInt2 == -41)
      {
        paramString = com.tencent.mm.h.a.Kb(paramString);
        if (paramString != null)
        {
          paramString.a(this.nfd, null, null);
          AppMethodBeat.o(128284);
          return;
        }
        com.tencent.mm.ui.base.h.p(this.nfd, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -1)
      {
        Toast.makeText(this.nfd, this.nfd.getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -34)
      {
        com.tencent.mm.ui.base.h.c(this.nfd, this.nfd.getString(r.j.bind_mcontact_err_freq_limit), "", true);
        AppMethodBeat.o(128284);
        return;
      }
      this.nfd.hideVKB();
      paramq = new Intent(this.nfd, MobileInputUI.class);
      paramq.putExtra("mobile_input_purpose", -1);
      paramq.putExtra("mobile_auth_type", 7);
      paramq.putExtra("from_switch_account", this.nfd.ndl);
      paramq.putExtra("couttry_code", this.nfd.countryCode);
      paramq.putExtra("input_mobile_number", this.nfd.nfH);
      paramString = this.nfd;
      paramq = new com.tencent.mm.hellhoundlib.b.a().bm(paramq);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, paramq.aFh(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)paramq.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(128284);
      return;
    }
    AppMethodBeat.o(128284);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128281);
    com.tencent.mm.kernel.h.aGY().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.bgi("L200_100");
    AppMethodBeat.o(128281);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128282);
    com.tencent.mm.kernel.h.aGY().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("L200_100") + ",2");
    AppMethodBeat.o(128282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.j
 * JD-Core Version:    0.7.0.1
 */