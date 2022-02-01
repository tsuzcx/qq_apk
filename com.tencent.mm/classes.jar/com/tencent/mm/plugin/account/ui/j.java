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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class j
  implements com.tencent.mm.ak.g, MobileInputUI.b
{
  protected String fwd = null;
  protected String iHJ = "";
  protected int iHK = 2;
  private MobileInputUI iSZ;
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128290);
    switch (2.iTe[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128290);
      return;
      this.iSZ.iTC = az.aLe(this.iSZ.countryCode);
      this.iSZ.iTD = this.iSZ.iTp.getText().toString();
      parama = this.iSZ.iTC + this.iSZ.iTD;
      if (this.iSZ.iJi != null)
      {
        ac.d("MicroMsg.MobileInputRegLogic", "already checking ");
        AppMethodBeat.o(128290);
        return;
      }
      MobileInputUI localMobileInputUI1 = this.iSZ;
      MobileInputUI localMobileInputUI2 = this.iSZ;
      this.iSZ.getString(2131755906);
      localMobileInputUI1.iJi = h.b(localMobileInputUI2, this.iSZ.getString(2131762310), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      parama = new z(parama, 1, "", 0, "");
      com.tencent.mm.kernel.g.agi().a(parama, 0);
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128287);
    this.iSZ = paramMobileInputUI;
    paramMobileInputUI.iTq.requestFocus();
    paramMobileInputUI.showVKB();
    this.fwd = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.iHJ = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.iHK = paramMobileInputUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    String str2 = paramMobileInputUI.getString(2131762371);
    String str1 = str2;
    if (d.DIf) {
      str1 = str2 + paramMobileInputUI.getString(2131755263);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.iGS.setVisibility(0);
    paramMobileInputUI.iTp.setVisibility(0);
    paramMobileInputUI.iTq.requestFocus();
    paramMobileInputUI.iTs.setVisibility(0);
    paramMobileInputUI.iTv.setVisibility(0);
    paramMobileInputUI.iTv.setText(2131760798);
    AppMethodBeat.o(128287);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128291);
    ac.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iSZ.iJi != null)
    {
      this.iSZ.iJi.dismiss();
      this.iSZ.iJi = null;
    }
    if (paramn.getType() == 132)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((z)paramn).Js() == 1)
        {
          paramn = new Intent();
          paramn.putExtra("bindmcontact_mobile", this.iSZ.iTC + " " + this.iSZ.iTp.getText().toString());
          paramn.putExtra("bindmcontact_shortmobile", this.iSZ.iTp.getText().toString());
          paramn.putExtra("country_name", this.iSZ.hLr);
          paramn.putExtra("couttry_code", this.iSZ.countryCode);
          paramn.putExtra("mobile_verify_purpose", 4);
          paramn.putExtra("regsetinfo_ticket", this.fwd);
          paramn.putExtra("regsetinfo_NextStep", this.iHJ);
          paramn.putExtra("regsetinfo_NextStyle", this.iHK);
          paramn.setClass(this.iSZ, MobileVerifyUI.class);
          paramString = this.iSZ;
          paramn = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.aeD(), "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramn.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.iSZ.finish();
        }
        AppMethodBeat.o(128291);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.iyy.a(this.iSZ, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128291);
        return;
      }
      Toast.makeText(this.iSZ, this.iSZ.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128291);
      return;
    }
    AppMethodBeat.o(128291);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128288);
    com.tencent.mm.kernel.g.agi().a(132, this);
    AppMethodBeat.o(128288);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128289);
    com.tencent.mm.kernel.g.agi().b(132, this);
    AppMethodBeat.o(128289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.j
 * JD-Core Version:    0.7.0.1
 */