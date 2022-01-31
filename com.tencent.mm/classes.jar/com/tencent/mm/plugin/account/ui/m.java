package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public final class m
  implements com.tencent.mm.ai.f, MobileVerifyUI.b
{
  f gDU;
  private int gFY;
  private g gFw;
  MobileVerifyUI gGG;
  SecurityImage gwg;
  
  public m(int paramInt)
  {
    AppMethodBeat.i(125238);
    this.gFw = null;
    this.gwg = null;
    this.gDU = null;
    this.gFY = paramInt;
    ab.i("MicroMsg.MobileVerifyForgetPwdLogic", "forget pwd, purpose %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(125238);
  }
  
  private void arE()
  {
    AppMethodBeat.i(125242);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_350_auto,");
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R200_350_auto") + ",1");
    com.tencent.mm.kernel.g.Rc().a(145, this);
    com.tencent.mm.kernel.g.Rc().a(132, this);
    localObject = null;
    if (this.gFY == 3) {
      localObject = new com.tencent.mm.modelfriend.a(this.gGG.czF, 9, this.gGG.gtO.getText().toString().trim(), 0, "");
    }
    for (;;)
    {
      if (localObject != null)
      {
        com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
        MobileVerifyUI localMobileVerifyUI1 = this.gGG;
        MobileVerifyUI localMobileVerifyUI2 = this.gGG;
        this.gGG.getString(2131297087);
        localMobileVerifyUI1.eeN = h.b(localMobileVerifyUI2, this.gGG.getString(2131297610), true, new m.1(this, (com.tencent.mm.ai.m)localObject));
      }
      AppMethodBeat.o(125242);
      return;
      if (this.gFY == 5) {
        localObject = new x(this.gGG.czF, 21, this.gGG.gtO.getText().toString().trim(), 0, "");
      }
    }
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.gGG = paramMobileVerifyUI;
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(125241);
    switch (m.5.gGK[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125241);
      return false;
      arE();
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.g.RJ();
      parama = parama.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_400,");
      com.tencent.mm.kernel.g.RJ();
      com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R200_400") + ",1");
      parama = null;
      if (this.gFY == 3) {
        parama = new com.tencent.mm.modelfriend.a(this.gGG.czF, 8, "", 0, "");
      }
      while (parama != null)
      {
        com.tencent.mm.kernel.g.Rc().a(parama, 0);
        break;
        if (this.gFY == 5) {
          parama = new x(this.gGG.czF, 20, "", 0, "");
        }
      }
      arE();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125243);
    ab.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gGG.eeN != null)
    {
      this.gGG.eeN.dismiss();
      this.gGG.eeN = null;
    }
    if (this.gDU == null) {
      this.gDU = new f();
    }
    if (((paramm.getType() == 252) || (paramm.getType() == 701)) && (this.gFw != null))
    {
      com.tencent.mm.kernel.g.Rc().b(701, this);
      com.tencent.mm.kernel.g.Rc().b(252, this);
      this.gDU.gwj = ((s)paramm).ajG();
      this.gDU.gwi = ((s)paramm).ajH();
      this.gDU.gwk = ((s)paramm).ajI();
      this.gDU.gEL = ((s)paramm).getSecCodeType();
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.g.Rc().a(701, this);
        com.tencent.mm.kernel.g.Rc().a(252, this);
        if (this.gwg == null)
        {
          this.gwg = SecurityImage.a.a(this.gGG, this.gDU.gEL, this.gDU.gwi, this.gDU.gwj, this.gDU.gwk, new m.2(this), null, new m.3(this), this.gDU);
          AppMethodBeat.o(125243);
          return;
        }
        ab.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.gDU.gwj + " img len" + this.gDU.gwi.length + " " + com.tencent.mm.compatible.util.g.Ml());
        this.gwg.b(this.gDU.gEL, this.gDU.gwi, this.gDU.gwj, this.gDU.gwk);
        AppMethodBeat.o(125243);
        return;
      }
      this.gFw.a(this.gGG, paramInt1, paramInt2, paramString, paramm);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        boolean bool = true;
        if ((paramm instanceof s)) {
          bool = ((s)paramm).ajP();
        }
        this.gGG.dC(bool);
      }
      AppMethodBeat.o(125243);
      return;
    }
    if (paramm.getType() == 145)
    {
      this.gDU.account = ((com.tencent.mm.modelfriend.a)paramm).getUsername();
      this.gDU.gEK = ((com.tencent.mm.modelfriend.a)paramm).agw();
      com.tencent.mm.kernel.g.Rc().b(145, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.gFY == 3)
        {
          com.tencent.mm.kernel.g.Rc().a(701, this);
          com.tencent.mm.kernel.g.Rc().a(252, this);
          this.gFw = new g(new m.4(this), ((com.tencent.mm.modelfriend.a)paramm).getUsername(), ((com.tencent.mm.modelfriend.a)paramm).agw(), this.gGG.czF);
          this.gFw.a(this.gGG);
        }
        AppMethodBeat.o(125243);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.kO(paramString);
        if (paramString != null)
        {
          paramString.a(this.gGG, null, null);
          AppMethodBeat.o(125243);
          return;
        }
        h.h(this.gGG, 2131297615, 2131297621);
        AppMethodBeat.o(125243);
        return;
      }
    }
    if (paramm.getType() == 132)
    {
      com.tencent.mm.kernel.g.Rc().b(132, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.gFY == 5)
        {
          paramString = ((x)paramm).agx();
          paramm = new Intent();
          paramm.putExtra("setpwd_ticket", paramString);
          this.gGG.setResult(-1, paramm);
          this.gGG.finish();
        }
        AppMethodBeat.o(125243);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.kO(paramString);
        if (paramString != null)
        {
          paramString.a(this.gGG, null, null);
          AppMethodBeat.o(125243);
          return;
        }
        h.h(this.gGG, 2131297615, 2131297621);
        AppMethodBeat.o(125243);
        return;
      }
    }
    if (this.gGG.l(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(125243);
      return;
    }
    if ((paramm.getType() == 252) || (paramm.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.kO(paramString);
      if ((paramString != null) && (paramString.a(this.gGG, null, null)))
      {
        AppMethodBeat.o(125243);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.gGG, this.gGG.getString(2131297614, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(125243);
  }
  
  public final void start()
  {
    AppMethodBeat.i(125239);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("F200_300") + ",1");
    com.tencent.mm.plugin.b.a.xC("F200_300");
    AppMethodBeat.o(125239);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(125240);
    int i = 2;
    if (this.gGG.gHl != -1) {
      i = this.gGG.gHl;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("F200_300") + "," + i);
    AppMethodBeat.o(125240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m
 * JD-Core Version:    0.7.0.1
 */