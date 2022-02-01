package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
  implements com.tencent.mm.am.h, MobileInputUI.b
{
  private SecurityImage pRw;
  private h qaG;
  private pu qbY;
  private MobileInputUI qcl;
  
  public j()
  {
    AppMethodBeat.i(128279);
    this.pRw = null;
    this.qaG = null;
    this.qbY = new pu();
    AppMethodBeat.o(128279);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128283);
    switch (7.qcq[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128283);
      return;
      this.qcl.qcP = PhoneFormater.countryCodeWithPlus(this.qcl.countryCode);
      this.qcl.qcQ = this.qcl.qcC.getText().toString();
      parama = PhoneFormater.pureNumber(this.qcl.qcP + this.qcl.qcQ);
      MobileInputUI localMobileInputUI1 = this.qcl;
      MobileInputUI localMobileInputUI2 = this.qcl;
      this.qcl.getString(r.j.app_tip);
      localMobileInputUI1.pRu = k.a(localMobileInputUI2, this.qcl.getString(r.j.regbyfacebook_reg_setpwd_exiting), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      parama = new com.tencent.mm.modelfriend.a(parama, 13, "", 0, "");
      com.tencent.mm.kernel.h.aZW().a(parama, 0);
    }
  }
  
  public final void a(final MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128280);
    this.qcl = paramMobileInputUI;
    paramMobileInputUI.pOX.setVisibility(0);
    paramMobileInputUI.qcB.setVisibility(0);
    paramMobileInputUI.qcC.requestFocus();
    paramMobileInputUI.qcH.setText(r.j.login_agree_next);
    paramMobileInputUI.qcH.setVisibility(0);
    paramMobileInputUI.qcI.setVisibility(0);
    paramMobileInputUI.qcK.setVisibility(0);
    paramMobileInputUI = new ArrayList();
    final t localt = new t(this.qcl, 2001, 0);
    if (WeChatBrands.AppInfo.current().isMainland()) {
      localt.setTitle(r.j.login_by_other_account);
    }
    for (;;)
    {
      paramMobileInputUI.add(localt);
      localt = new t(this.qcl, 2002, 0);
      if (com.tencent.mm.au.b.bKJ())
      {
        localt.setTitle(r.j.login_by_facebook);
        paramMobileInputUI.add(localt);
      }
      if (paramMobileInputUI.size() <= 1) {
        break;
      }
      final f localf = new f(this.qcl, 1, false);
      localf.Vtg = new u.g()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
        {
          AppMethodBeat.i(128274);
          if (paramAnonymouss.size() == 0)
          {
            Iterator localIterator = paramMobileInputUI.iterator();
            while (localIterator.hasNext()) {
              paramAnonymouss.j((t)localIterator.next());
            }
          }
          AppMethodBeat.o(128274);
        }
      };
      localf.GAC = new j.2(this);
      localf.aeLi = new f.b()
      {
        public final void onDismiss() {}
      };
      this.qcl.qcM.setText(r.j.login_by_other_account_more);
      this.qcl.qcM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128276);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          j.c(j.this).hideVKB();
          localf.dDn();
          if (paramMobileInputUI.contains(localt))
          {
            j.d(j.this).joN = 1L;
            j.d(j.this).ikE = 9L;
            j.d(j.this).bMH();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128276);
        }
      });
      this.qcl.qcM.setVisibility(0);
      AppMethodBeat.o(128280);
      return;
      localt.setTitle(r.j.login_by_other_account_oversea);
    }
    if (WeChatBrands.AppInfo.current().isMainland()) {
      this.qcl.qcM.setText(r.j.login_by_other_account);
    }
    for (;;)
    {
      this.qcl.qcM.setOnClickListener(new j.5(this));
      break;
      this.qcl.qcM.setText(r.j.login_by_other_account_oversea);
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128284);
    Log.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.qcl.pRu != null)
    {
      this.qcl.pRu.dismiss();
      this.qcl.pRu = null;
    }
    if (((paramp.getType() == 252) || (paramp.getType() == 701)) && (this.qaG != null))
    {
      this.qaG.qbB = this.qcl.qbB;
      this.qaG.a(this.qcl, paramInt1, paramInt2, paramString, paramp);
      AppMethodBeat.o(128284);
      return;
    }
    if ((paramp.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramp).bIO() == 13))
    {
      if (paramInt2 == -41)
      {
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        if (paramString != null)
        {
          paramString.a(this.qcl, null, null);
          AppMethodBeat.o(128284);
          return;
        }
        k.s(this.qcl, r.j.regbymobile_reg_mobile_format_err_msg, r.j.regbymobile_reg_mobile_format_err_title);
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -1)
      {
        Toast.makeText(this.qcl, this.qcl.getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(128284);
        return;
      }
      if (paramInt2 == -34)
      {
        k.c(this.qcl, this.qcl.getString(r.j.bind_mcontact_err_freq_limit), "", true);
        AppMethodBeat.o(128284);
        return;
      }
      this.qcl.hideVKB();
      paramp = new Intent(this.qcl, MobileInputUI.class);
      paramp.putExtra("mobile_input_purpose", -1);
      paramp.putExtra("mobile_auth_type", 7);
      paramp.putExtra("from_switch_account", this.qcl.qaE);
      paramp.putExtra("couttry_code", this.qcl.countryCode);
      paramp.putExtra("input_mobile_number", this.qcl.qcQ);
      paramString = this.qcl;
      paramp = new com.tencent.mm.hellhoundlib.b.a().cG(paramp);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, paramp.aYi(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)paramp.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(128284);
      return;
    }
    AppMethodBeat.o(128284);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128281);
    com.tencent.mm.kernel.h.aZW().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(true, com.tencent.mm.kernel.b.Fw("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.Tz("L200_100");
    AppMethodBeat.o(128281);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128282);
    com.tencent.mm.kernel.h.aZW().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(false, com.tencent.mm.kernel.b.Fw("L200_100") + ",2");
    AppMethodBeat.o(128282);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.j
 * JD-Core Version:    0.7.0.1
 */