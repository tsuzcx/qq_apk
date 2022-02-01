package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class j
  implements f, MobileInputUI.b
{
  protected String fPq = null;
  protected String jaS = "";
  protected int jaT = 2;
  private MobileInputUI jmh;
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128290);
    switch (2.jmm[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128290);
      return;
      this.jmh.jmK = ba.aQK(this.jmh.countryCode);
      this.jmh.jmL = this.jmh.jmx.getText().toString();
      parama = this.jmh.jmK + this.jmh.jmL;
      if (this.jmh.jcr != null)
      {
        ad.d("MicroMsg.MobileInputRegLogic", "already checking ");
        AppMethodBeat.o(128290);
        return;
      }
      MobileInputUI localMobileInputUI1 = this.jmh;
      MobileInputUI localMobileInputUI2 = this.jmh;
      this.jmh.getString(2131755906);
      localMobileInputUI1.jcr = h.b(localMobileInputUI2, this.jmh.getString(2131762310), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      parama = new z(parama, 1, "", 0, "");
      com.tencent.mm.kernel.g.aiU().a(parama, 0);
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128287);
    this.jmh = paramMobileInputUI;
    paramMobileInputUI.jmy.requestFocus();
    paramMobileInputUI.showVKB();
    this.fPq = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.jaS = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.jaT = paramMobileInputUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    String str2 = paramMobileInputUI.getString(2131762371);
    String str1;
    if (!d.Fnm)
    {
      str1 = str2;
      if (!i.IS_FLAVOR_BLUE) {}
    }
    else
    {
      str1 = str2 + com.tencent.mm.cd.g.is(paramMobileInputUI);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.jab.setVisibility(0);
    paramMobileInputUI.jmx.setVisibility(0);
    paramMobileInputUI.jmy.requestFocus();
    paramMobileInputUI.jmA.setVisibility(0);
    paramMobileInputUI.jmD.setVisibility(0);
    paramMobileInputUI.jmD.setText(2131760798);
    AppMethodBeat.o(128287);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128291);
    ad.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jmh.jcr != null)
    {
      this.jmh.jcr.dismiss();
      this.jmh.jcr = null;
    }
    if (paramn.getType() == 132)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((z)paramn).KR() == 1)
        {
          paramn = new Intent();
          paramn.putExtra("bindmcontact_mobile", this.jmh.jmK + " " + this.jmh.jmx.getText().toString());
          paramn.putExtra("bindmcontact_shortmobile", this.jmh.jmx.getText().toString());
          paramn.putExtra("country_name", this.jmh.iem);
          paramn.putExtra("couttry_code", this.jmh.countryCode);
          paramn.putExtra("mobile_verify_purpose", 4);
          paramn.putExtra("regsetinfo_ticket", this.fPq);
          paramn.putExtra("regsetinfo_NextStep", this.jaS);
          paramn.putExtra("regsetinfo_NextStyle", this.jaT);
          paramn.setClass(this.jmh, MobileVerifyUI.class);
          paramString = this.jmh;
          paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahp(), "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramn.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.jmh.finish();
        }
        AppMethodBeat.o(128291);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.iRH.a(this.jmh, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128291);
        return;
      }
      Toast.makeText(this.jmh, this.jmh.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128291);
      return;
    }
    AppMethodBeat.o(128291);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128288);
    com.tencent.mm.kernel.g.aiU().a(132, this);
    AppMethodBeat.o(128288);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128289);
    com.tencent.mm.kernel.g.aiU().b(132, this);
    AppMethodBeat.o(128289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.j
 * JD-Core Version:    0.7.0.1
 */