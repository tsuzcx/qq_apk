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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class j
  implements f, MobileInputUI.b
{
  protected String fRw = null;
  protected String jdL = "";
  protected int jdM = 2;
  private MobileInputUI jpb;
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128290);
    switch (2.jpg[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128290);
      return;
      this.jpb.jpE = bb.aSh(this.jpb.countryCode);
      this.jpb.jpF = this.jpb.jpr.getText().toString();
      parama = this.jpb.jpE + this.jpb.jpF;
      if (this.jpb.jfk != null)
      {
        ae.d("MicroMsg.MobileInputRegLogic", "already checking ");
        AppMethodBeat.o(128290);
        return;
      }
      MobileInputUI localMobileInputUI1 = this.jpb;
      MobileInputUI localMobileInputUI2 = this.jpb;
      this.jpb.getString(2131755906);
      localMobileInputUI1.jfk = h.b(localMobileInputUI2, this.jpb.getString(2131762310), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      parama = new z(parama, 1, "", 0, "");
      com.tencent.mm.kernel.g.ajj().a(parama, 0);
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128287);
    this.jpb = paramMobileInputUI;
    paramMobileInputUI.jps.requestFocus();
    paramMobileInputUI.showVKB();
    this.fRw = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.jdL = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.jdM = paramMobileInputUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    String str2 = paramMobileInputUI.getString(2131762371);
    String str1;
    if (!d.FFK)
    {
      str1 = str2;
      if (!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_BLUE) {}
    }
    else
    {
      str1 = str2 + com.tencent.mm.cc.g.ix(paramMobileInputUI);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.jcU.setVisibility(0);
    paramMobileInputUI.jpr.setVisibility(0);
    paramMobileInputUI.jps.requestFocus();
    paramMobileInputUI.jpu.setVisibility(0);
    paramMobileInputUI.jpx.setVisibility(0);
    paramMobileInputUI.jpx.setText(2131760798);
    AppMethodBeat.o(128287);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128291);
    ae.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jpb.jfk != null)
    {
      this.jpb.jfk.dismiss();
      this.jpb.jfk = null;
    }
    if (paramn.getType() == 132)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((z)paramn).KZ() == 1)
        {
          paramn = new Intent();
          paramn.putExtra("bindmcontact_mobile", this.jpb.jpE + " " + this.jpb.jpr.getText().toString());
          paramn.putExtra("bindmcontact_shortmobile", this.jpb.jpr.getText().toString());
          paramn.putExtra("country_name", this.jpb.ihe);
          paramn.putExtra("couttry_code", this.jpb.countryCode);
          paramn.putExtra("mobile_verify_purpose", 4);
          paramn.putExtra("regsetinfo_ticket", this.fRw);
          paramn.putExtra("regsetinfo_NextStep", this.jdL);
          paramn.putExtra("regsetinfo_NextStyle", this.jdM);
          paramn.setClass(this.jpb, MobileVerifyUI.class);
          paramString = this.jpb;
          paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
          com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahE(), "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)paramn.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileInputQQRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          this.jpb.finish();
        }
        AppMethodBeat.o(128291);
        return;
      }
      if (com.tencent.mm.plugin.account.a.a.iUA.a(this.jpb, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128291);
        return;
      }
      Toast.makeText(this.jpb, this.jpb.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(128291);
      return;
    }
    AppMethodBeat.o(128291);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128288);
    com.tencent.mm.kernel.g.ajj().a(132, this);
    AppMethodBeat.o(128288);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128289);
    com.tencent.mm.kernel.g.ajj().b(132, this);
    AppMethodBeat.o(128289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.j
 * JD-Core Version:    0.7.0.1
 */