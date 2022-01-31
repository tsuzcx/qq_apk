package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;

public final class j
  implements f, MobileInputUI.b
{
  protected String eiu = null;
  private MobileInputUI gFq;
  protected String guB = "";
  protected int guC = 2;
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(125112);
    switch (j.2.gFv[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125112);
      return;
      this.gFq.gFW = av.apA(this.gFq.countryCode);
      this.gFq.gFX = this.gFq.gFJ.getText().toString();
      parama = this.gFq.gFW + this.gFq.gFX;
      if (this.gFq.gwe != null)
      {
        ab.d("MicroMsg.MobileInputRegLogic", "already checking ");
        AppMethodBeat.o(125112);
        return;
      }
      MobileInputUI localMobileInputUI1 = this.gFq;
      MobileInputUI localMobileInputUI2 = this.gFq;
      this.gFq.getString(2131297087);
      localMobileInputUI1.gwe = h.b(localMobileInputUI2, this.gFq.getString(2131302413), true, new j.1(this));
      parama = new x(parama, 1, "", 0, "");
      g.Rc().a(parama, 0);
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(125109);
    this.gFq = paramMobileInputUI;
    paramMobileInputUI.gFK.requestFocus();
    paramMobileInputUI.showVKB();
    this.eiu = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_ticket");
    this.guB = paramMobileInputUI.getIntent().getStringExtra("regsetinfo_NextStep");
    this.guC = paramMobileInputUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    String str2 = paramMobileInputUI.getString(2131302468);
    String str1 = str2;
    if (d.whK) {
      str1 = str2 + paramMobileInputUI.getString(2131296529);
    }
    paramMobileInputUI.setMMTitle(str1);
    paramMobileInputUI.gtI.setVisibility(0);
    paramMobileInputUI.gFJ.setVisibility(0);
    paramMobileInputUI.gFK.requestFocus();
    paramMobileInputUI.gFM.setVisibility(0);
    paramMobileInputUI.gFP.setVisibility(0);
    paramMobileInputUI.gFP.setText(2131301166);
    AppMethodBeat.o(125109);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125113);
    ab.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gFq.gwe != null)
    {
      this.gFq.gwe.dismiss();
      this.gFq.gwe = null;
    }
    if (paramm.getType() == 132)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((x)paramm).Ac() == 1)
        {
          paramString = new Intent();
          paramString.putExtra("bindmcontact_mobile", this.gFq.gFW + " " + this.gFq.gFJ.getText().toString());
          paramString.putExtra("bindmcontact_shortmobile", this.gFq.gFJ.getText().toString());
          paramString.putExtra("country_name", this.gFq.fHT);
          paramString.putExtra("couttry_code", this.gFq.countryCode);
          paramString.putExtra("mobile_verify_purpose", 4);
          paramString.putExtra("regsetinfo_ticket", this.eiu);
          paramString.putExtra("regsetinfo_NextStep", this.guB);
          paramString.putExtra("regsetinfo_NextStyle", this.guC);
          paramString.setClass(this.gFq, MobileVerifyUI.class);
          this.gFq.startActivity(paramString);
          this.gFq.finish();
        }
        AppMethodBeat.o(125113);
        return;
      }
      if (a.gmP.a(this.gFq, paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125113);
        return;
      }
      Toast.makeText(this.gFq, this.gFq.getString(2131297614, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      AppMethodBeat.o(125113);
      return;
    }
    AppMethodBeat.o(125113);
  }
  
  public final void start()
  {
    AppMethodBeat.i(125110);
    g.Rc().a(132, this);
    AppMethodBeat.o(125110);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(125111);
    g.Rc().b(132, this);
    AppMethodBeat.o(125111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.j
 * JD-Core Version:    0.7.0.1
 */