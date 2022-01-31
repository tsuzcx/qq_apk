package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.au.b;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.d;
import java.util.ArrayList;
import java.util.List;

public final class i
  implements f, MobileInputUI.b
{
  bj gDn;
  MobileInputUI gFq;
  private g gFw;
  private SecurityImage gwg;
  
  public i()
  {
    AppMethodBeat.i(125101);
    this.gwg = null;
    this.gFw = null;
    this.gDn = new bj();
    AppMethodBeat.o(125101);
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(125105);
    switch (i.7.gFv[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125105);
      return;
      this.gFq.gFW = av.apA(this.gFq.countryCode);
      this.gFq.gFX = this.gFq.gFK.getText().toString();
      parama = av.apy(this.gFq.gFW + this.gFq.gFX);
      MobileInputUI localMobileInputUI1 = this.gFq;
      MobileInputUI localMobileInputUI2 = this.gFq;
      this.gFq.getString(2131297087);
      localMobileInputUI1.gwe = h.b(localMobileInputUI2, this.gFq.getString(2131302413), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      parama = new com.tencent.mm.modelfriend.a(parama, 13, "", 0, "");
      com.tencent.mm.kernel.g.Rc().a(parama, 0);
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(125102);
    this.gFq = paramMobileInputUI;
    paramMobileInputUI.gtI.setVisibility(0);
    paramMobileInputUI.gFJ.setVisibility(0);
    paramMobileInputUI.gFK.requestFocus();
    paramMobileInputUI.gFP.setText(2131297013);
    paramMobileInputUI.gFP.setVisibility(0);
    paramMobileInputUI.gFR.setVisibility(0);
    paramMobileInputUI = new ArrayList();
    com.tencent.mm.ui.base.m localm = new com.tencent.mm.ui.base.m(this.gFq, 2001, 0);
    localm.setTitle(2131301125);
    paramMobileInputUI.add(localm);
    localm = new com.tencent.mm.ui.base.m(this.gFq, 2002, 0);
    if (b.aid())
    {
      localm.setTitle(2131301121);
      paramMobileInputUI.add(localm);
    }
    if (paramMobileInputUI.size() > 1)
    {
      d locald = new d(this.gFq, 1, false);
      locald.sao = new i.1(this, paramMobileInputUI);
      locald.sap = new i.2(this);
      locald.AGQ = new i.3(this);
      this.gFq.gFT.setText(2131301126);
      this.gFq.gFT.setOnClickListener(new i.4(this, locald, paramMobileInputUI, localm));
    }
    for (;;)
    {
      this.gFq.gFT.setVisibility(0);
      AppMethodBeat.o(125102);
      return;
      this.gFq.gFT.setText(2131301125);
      this.gFq.gFT.setOnClickListener(new i.5(this));
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125106);
    ab.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gFq.gwe != null)
    {
      this.gFq.gwe.dismiss();
      this.gFq.gwe = null;
    }
    if (((paramm.getType() == 252) || (paramm.getType() == 701)) && (this.gFw != null))
    {
      this.gFw.gFc = this.gFq.gFc;
      this.gFw.a(this.gFq, paramInt1, paramInt2, paramString, paramm);
      AppMethodBeat.o(125106);
      return;
    }
    if ((paramm.getType() == 145) && (((com.tencent.mm.modelfriend.a)paramm).Ac() == 13))
    {
      if (paramInt2 == -41)
      {
        paramString = com.tencent.mm.h.a.kO(paramString);
        if (paramString != null)
        {
          paramString.a(this.gFq, null, null);
          AppMethodBeat.o(125106);
          return;
        }
        h.h(this.gFq, 2131302425, 2131302426);
        AppMethodBeat.o(125106);
        return;
      }
      if (paramInt2 == -1)
      {
        Toast.makeText(this.gFq, this.gFq.getString(2131300023, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        AppMethodBeat.o(125106);
        return;
      }
      if (paramInt2 == -34)
      {
        h.b(this.gFq, this.gFq.getString(2131297570), "", true);
        AppMethodBeat.o(125106);
        return;
      }
      this.gFq.hideVKB();
      paramString = new Intent(this.gFq, MobileInputUI.class);
      paramString.putExtra("mobile_input_purpose", -1);
      paramString.putExtra("mobile_auth_type", 7);
      paramString.putExtra("from_switch_account", this.gFq.gFa);
      paramString.putExtra("couttry_code", this.gFq.countryCode);
      paramString.putExtra("input_mobile_number", this.gFq.gFX);
      this.gFq.startActivity(paramString);
      AppMethodBeat.o(125106);
      return;
    }
    AppMethodBeat.o(125106);
  }
  
  public final void start()
  {
    AppMethodBeat.i(125103);
    com.tencent.mm.kernel.g.Rc().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.xC("L200_100");
    AppMethodBeat.o(125103);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(125104);
    com.tencent.mm.kernel.g.Rc().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("L200_100") + ",2");
    AppMethodBeat.o(125104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i
 * JD-Core Version:    0.7.0.1
 */