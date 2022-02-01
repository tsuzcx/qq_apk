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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class j
  implements com.tencent.mm.al.g, MobileInputUI.b
{
  protected String fsw = null;
  protected String ihB = "";
  protected int ihC = 2;
  private MobileInputUI isU;
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128290);
    switch (2.isZ[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128290);
      return;
      this.isU.itx = ba.aFN(this.isU.countryCode);
      this.isU.ity = this.isU.itk.getText().toString();
      parama = this.isU.itx + this.isU.ity;
      if (this.isU.ijb != null)
      {
        ad.d("MicroMsg.MobileInputRegLogic", "already checking ");
        AppMethodBeat.o(128290);
        return;
      }
      MobileInputUI localMobileInputUI1 = this.isU;
      MobileInputUI localMobileInputUI2 = this.isU;
      this.isU.getString(2131755906);
      localMobileInputUI1.ijb = h.b(localMobileInputUI2, this.isU.getString(2131762310), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      parama = new z(parama, 1, "", 0, "");
      com.tencent.mm.kernel.g.aeS().a(parama, 0);
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128287);
    this.isU = paramMobileInputUI;
    paramMobileInputUI.itl.requestFocus();
    paramMobileInputUI.showVKB();
    this.fsw = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.ihB = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.ihC = paramMobileInputUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    String str2 = paramMobileInputUI.getString(2131762371);
    String str1 = str2;
    if (d.CpN) {
      str1 = str2 + paramMobileInputUI.getString(2131755263);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.igJ.setVisibility(0);
    paramMobileInputUI.itk.setVisibility(0);
    paramMobileInputUI.itl.requestFocus();
    paramMobileInputUI.itn.setVisibility(0);
    paramMobileInputUI.itq.setVisibility(0);
    paramMobileInputUI.itq.setText(2131760798);
    AppMethodBeat.o(128287);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128291);
    ad.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.isU.ijb != null)
    {
      this.isU.ijb.dismiss();
      this.isU.ijb = null;
    }
    if (paramn.getType() == 132)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((z)paramn).JJ() == 1)
        {
          paramn = new Intent();
          paramn.putExtra("bindmcontact_mobile", this.isU.itx + " " + this.isU.itk.getText().toString());
          paramn.putExtra("bindmcontact_shortmobile", this.isU.itk.getText().toString());
          paramn.putExtra("country_name", this.isU.hkO);
          paramn.putExtra("couttry_code", this.isU.countryCode);
          paramn.putExtra("mobile_verify_purpose", 4);
          paramn.putExtra("regsetinfo_ticket", this.fsw);
          paramn.putExtra("regsetinfo_NextStep", this.ihB);
          paramn.putExtra("regsetinfo_NextStyle", this.ihC);
          paramn.setClass(this.isU, MobileVerifyUI.class);
          paramString = this.isU;
          paramn = new com.tencent.mm.hellhoundlib.b.a().bd(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.adn(), "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramn.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.isU.finish();
        }
        AppMethodBeat.o(128291);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.hYu.a(this.isU, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128291);
        return;
      }
      Toast.makeText(this.isU, this.isU.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128291);
      return;
    }
    AppMethodBeat.o(128291);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128288);
    com.tencent.mm.kernel.g.aeS().a(132, this);
    AppMethodBeat.o(128288);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128289);
    com.tencent.mm.kernel.g.aeS().b(132, this);
    AppMethodBeat.o(128289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.j
 * JD-Core Version:    0.7.0.1
 */