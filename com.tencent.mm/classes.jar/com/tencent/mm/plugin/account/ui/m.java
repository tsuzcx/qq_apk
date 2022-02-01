package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public final class m
  implements com.tencent.mm.ak.g, MobileVerifyUI.b
{
  SecurityImage iJk;
  f iRj;
  private g iRp;
  private int iTE;
  MobileVerifyUI iUm;
  
  public m(int paramInt)
  {
    AppMethodBeat.i(128410);
    this.iRp = null;
    this.iJk = null;
    this.iRj = null;
    this.iTE = paramInt;
    ac.i("MicroMsg.MobileVerifyForgetPwdLogic", "forget pwd, purpose %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(128410);
  }
  
  private void aQV()
  {
    AppMethodBeat.i(128414);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_350_auto,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_350_auto") + ",1");
    com.tencent.mm.kernel.g.agi().a(145, this);
    com.tencent.mm.kernel.g.agi().a(132, this);
    localObject = null;
    if (this.iTE == 3) {
      localObject = new com.tencent.mm.modelfriend.a(this.iUm.dnz, 9, this.iUm.iGY.getText().toString().trim(), 0, "");
    }
    for (;;)
    {
      if (localObject != null)
      {
        com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
        MobileVerifyUI localMobileVerifyUI1 = this.iUm;
        MobileVerifyUI localMobileVerifyUI2 = this.iUm;
        this.iUm.getString(2131755906);
        localMobileVerifyUI1.fts = h.b(localMobileVerifyUI2, this.iUm.getString(2131756503), true, new m.1(this, (n)localObject));
      }
      AppMethodBeat.o(128414);
      return;
      if (this.iTE == 5) {
        localObject = new z(this.iUm.dnz, 21, this.iUm.iGY.getText().toString().trim(), 0, "");
      }
    }
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.iUm = paramMobileVerifyUI;
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128413);
    switch (5.iUq[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128413);
      return false;
      aQV();
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      parama = parama.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_400,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_400") + ",1");
      parama = null;
      if (this.iTE == 3) {
        parama = new com.tencent.mm.modelfriend.a(this.iUm.dnz, 8, "", 0, "");
      }
      while (parama != null)
      {
        com.tencent.mm.kernel.g.agi().a(parama, 0);
        break;
        if (this.iTE == 5) {
          parama = new z(this.iUm.dnz, 20, "", 0, "");
        }
      }
      aQV();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128415);
    ac.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iUm.fts != null)
    {
      this.iUm.fts.dismiss();
      this.iUm.fts = null;
    }
    if (this.iRj == null) {
      this.iRj = new f();
    }
    if (((paramn.getType() == 252) || (paramn.getType() == 701)) && (this.iRp != null))
    {
      com.tencent.mm.kernel.g.agi().b(701, this);
      com.tencent.mm.kernel.g.agi().b(252, this);
      this.iRj.iJn = ((s)paramn).aHA();
      this.iRj.iJm = ((s)paramn).aHB();
      this.iRj.iJo = ((s)paramn).aHC();
      this.iRj.iSx = ((s)paramn).getSecCodeType();
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.g.agi().a(701, this);
        com.tencent.mm.kernel.g.agi().a(252, this);
        if (this.iJk == null)
        {
          this.iJk = SecurityImage.a.a(this.iUm, this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128408);
              ac.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + m.this.iRj.iJn + " img len" + m.this.iRj.iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
              paramAnonymousDialogInterface = new s(m.this.iRj.account, m.this.iRj.iSw, m.this.iRj.iSx, m.this.iJk.getSecImgCode(), m.this.iJk.getSecImgSid(), m.this.iJk.getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI = m.this.iUm;
              m.this.iUm.getString(2131755906);
              h.b(localMobileVerifyUI, m.this.iUm.getString(2131760781), true, new m.2.1(this, paramAnonymousDialogInterface));
              AppMethodBeat.o(128408);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              m.this.iJk = null;
            }
          }, this.iRj);
          AppMethodBeat.o(128415);
          return;
        }
        ac.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.iRj.iJn + " img len" + this.iRj.iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
        this.iJk.b(this.iRj.iSx, this.iRj.iJm, this.iRj.iJn, this.iRj.iJo);
        AppMethodBeat.o(128415);
        return;
      }
      this.iRp.a(this.iUm, paramInt1, paramInt2, paramString, paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        boolean bool = true;
        if ((paramn instanceof s)) {
          bool = ((s)paramn).aHJ();
        }
        this.iUm.fs(bool);
      }
      AppMethodBeat.o(128415);
      return;
    }
    if (paramn.getType() == 145)
    {
      this.iRj.account = ((com.tencent.mm.modelfriend.a)paramn).getUsername();
      this.iRj.iSw = ((com.tencent.mm.modelfriend.a)paramn).aEq();
      com.tencent.mm.kernel.g.agi().b(145, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.iTE == 3)
        {
          com.tencent.mm.kernel.g.agi().a(701, this);
          com.tencent.mm.kernel.g.agi().a(252, this);
          this.iRp = new g(new g.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              m.this.iUm.fts = paramAnonymousProgressDialog;
            }
          }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aEq(), this.iUm.dnz);
          this.iRp.a(this.iUm);
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.rM(paramString);
        if (paramString != null)
        {
          paramString.a(this.iUm, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        h.l(this.iUm, 2131756508, 2131756514);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (paramn.getType() == 132)
    {
      com.tencent.mm.kernel.g.agi().b(132, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.iTE == 5)
        {
          paramString = ((z)paramn).aEr();
          paramn = new Intent();
          paramn.putExtra("setpwd_ticket", paramString);
          this.iUm.setResult(-1, paramn);
          this.iUm.finish();
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.rM(paramString);
        if (paramString != null)
        {
          paramString.a(this.iUm, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        h.l(this.iUm, 2131756508, 2131756514);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (this.iUm.n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128415);
      return;
    }
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.rM(paramString);
      if ((paramString != null) && (paramString.a(this.iUm, null, null)))
      {
        AppMethodBeat.o(128415);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.iUm, this.iUm.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128415);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128411);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("F200_300") + ",1");
    com.tencent.mm.plugin.b.a.IK("F200_300");
    AppMethodBeat.o(128411);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128412);
    int i = 2;
    if (this.iUm.iUQ != -1) {
      i = this.iUm.iUQ;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("F200_300") + "," + i);
    AppMethodBeat.o(128412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m
 * JD-Core Version:    0.7.0.1
 */