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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.ui.base.MMFormInputView;

public final class k
  implements i, MobileInputUI.b
{
  protected String gwF = null;
  protected String kbO = "";
  protected int kbP = 2;
  private MobileInputUI knl;
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128290);
    switch (2.knq[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128290);
      return;
      this.knl.knO = PhoneFormater.countryCodeWithPlus(this.knl.countryCode);
      this.knl.knP = this.knl.knB.getText().toString();
      parama = this.knl.knO + this.knl.knP;
      if (this.knl.kdn != null)
      {
        Log.d("MicroMsg.MobileInputRegLogic", "already checking ");
        AppMethodBeat.o(128290);
        return;
      }
      MobileInputUI localMobileInputUI1 = this.knl;
      MobileInputUI localMobileInputUI2 = this.knl;
      this.knl.getString(2131755998);
      localMobileInputUI1.kdn = com.tencent.mm.ui.base.h.a(localMobileInputUI2, this.knl.getString(2131764376), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      parama = new z(parama, 1, "", 0, "");
      g.azz().a(parama, 0);
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128287);
    this.knl = paramMobileInputUI;
    paramMobileInputUI.knC.requestFocus();
    paramMobileInputUI.showVKB();
    this.gwF = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.kbO = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.kbP = paramMobileInputUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
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
    paramMobileInputUI.knE.setVisibility(0);
    paramMobileInputUI.knH.setVisibility(0);
    paramMobileInputUI.knH.setText(2131762551);
    AppMethodBeat.o(128287);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128291);
    Log.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.knl.kdn != null)
    {
      this.knl.kdn.dismiss();
      this.knl.kdn = null;
    }
    if (paramq.getType() == 132)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((z)paramq).Vj() == 1)
        {
          paramq = new Intent();
          paramq.putExtra("bindmcontact_mobile", this.knl.knO + " " + this.knl.knB.getText().toString());
          paramq.putExtra("bindmcontact_shortmobile", this.knl.knB.getText().toString());
          paramq.putExtra("country_name", this.knl.jbZ);
          paramq.putExtra("couttry_code", this.knl.countryCode);
          paramq.putExtra("mobile_verify_purpose", 4);
          paramq.putExtra("regsetinfo_ticket", this.gwF);
          paramq.putExtra("regsetinfo_NextStep", this.kbO);
          paramq.putExtra("regsetinfo_NextStyle", this.kbP);
          paramq.setClass(this.knl, MobileVerifyUI.class);
          paramString = this.knl;
          paramq = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramq.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramq.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.knl.finish();
        }
        AppMethodBeat.o(128291);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.jRu.a(this.knl, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128291);
        return;
      }
      Toast.makeText(this.knl, this.knl.getString(2131756643, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128291);
      return;
    }
    AppMethodBeat.o(128291);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128288);
    g.azz().a(132, this);
    AppMethodBeat.o(128288);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128289);
    g.azz().b(132, this);
    AppMethodBeat.o(128289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.k
 * JD-Core Version:    0.7.0.1
 */