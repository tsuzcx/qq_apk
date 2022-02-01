package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public final class m
  implements com.tencent.mm.al.f, MobileVerifyUI.b
{
  SecurityImage jct;
  f jkr;
  private g jkx;
  private int jmM;
  MobileVerifyUI jnv;
  
  public m(int paramInt)
  {
    AppMethodBeat.i(128410);
    this.jkx = null;
    this.jct = null;
    this.jkr = null;
    this.jmM = paramInt;
    ad.i("MicroMsg.MobileVerifyForgetPwdLogic", "forget pwd, purpose %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(128410);
  }
  
  private void aUh()
  {
    AppMethodBeat.i(128414);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_350_auto,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_350_auto") + ",1");
    com.tencent.mm.kernel.g.aiU().a(145, this);
    com.tencent.mm.kernel.g.aiU().a(132, this);
    localObject = null;
    if (this.jmM == 3) {
      localObject = new com.tencent.mm.modelfriend.a(this.jnv.dzn, 9, this.jnv.jah.getText().toString().trim(), 0, "");
    }
    for (;;)
    {
      if (localObject != null)
      {
        com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
        MobileVerifyUI localMobileVerifyUI1 = this.jnv;
        MobileVerifyUI localMobileVerifyUI2 = this.jnv;
        this.jnv.getString(2131755906);
        localMobileVerifyUI1.fMu = h.b(localMobileVerifyUI2, this.jnv.getString(2131756503), true, new m.1(this, (n)localObject));
      }
      AppMethodBeat.o(128414);
      return;
      if (this.jmM == 5) {
        localObject = new z(this.jnv.dzn, 21, this.jnv.jah.getText().toString().trim(), 0, "");
      }
    }
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.jnv = paramMobileVerifyUI;
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128413);
    switch (5.jnz[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128413);
      return false;
      aUh();
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.g.ajA();
      parama = parama.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_400,");
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_400") + ",1");
      parama = null;
      if (this.jmM == 3) {
        parama = new com.tencent.mm.modelfriend.a(this.jnv.dzn, 8, "", 0, "");
      }
      while (parama != null)
      {
        com.tencent.mm.kernel.g.aiU().a(parama, 0);
        break;
        if (this.jmM == 5) {
          parama = new z(this.jnv.dzn, 20, "", 0, "");
        }
      }
      aUh();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128415);
    ad.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jnv.fMu != null)
    {
      this.jnv.fMu.dismiss();
      this.jnv.fMu = null;
    }
    if (this.jkr == null) {
      this.jkr = new f();
    }
    if (((paramn.getType() == 252) || (paramn.getType() == 701)) && (this.jkx != null))
    {
      com.tencent.mm.kernel.g.aiU().b(701, this);
      com.tencent.mm.kernel.g.aiU().b(252, this);
      this.jkr.jcw = ((s)paramn).aKL();
      this.jkr.jcv = ((s)paramn).aKM();
      this.jkr.jcx = ((s)paramn).aKN();
      this.jkr.jlF = ((s)paramn).getSecCodeType();
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.g.aiU().a(701, this);
        com.tencent.mm.kernel.g.aiU().a(252, this);
        if (this.jct == null)
        {
          this.jct = SecurityImage.a.a(this.jnv, this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128408);
              ad.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + m.this.jkr.jcw + " img len" + m.this.jkr.jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
              paramAnonymousDialogInterface = new s(m.this.jkr.account, m.this.jkr.jlE, m.this.jkr.jlF, m.this.jct.getSecImgCode(), m.this.jct.getSecImgSid(), m.this.jct.getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI = m.this.jnv;
              m.this.jnv.getString(2131755906);
              h.b(localMobileVerifyUI, m.this.jnv.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128407);
                  com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.aiU().b(701, m.this);
                  com.tencent.mm.kernel.g.aiU().b(252, m.this);
                  AppMethodBeat.o(128407);
                }
              });
              AppMethodBeat.o(128408);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              m.this.jct = null;
            }
          }, this.jkr);
          AppMethodBeat.o(128415);
          return;
        }
        ad.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.jkr.jcw + " img len" + this.jkr.jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
        this.jct.b(this.jkr.jlF, this.jkr.jcv, this.jkr.jcw, this.jkr.jcx);
        AppMethodBeat.o(128415);
        return;
      }
      this.jkx.a(this.jnv, paramInt1, paramInt2, paramString, paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        boolean bool = true;
        if ((paramn instanceof s)) {
          bool = ((s)paramn).aKU();
        }
        this.jnv.fw(bool);
      }
      AppMethodBeat.o(128415);
      return;
    }
    if (paramn.getType() == 145)
    {
      this.jkr.account = ((com.tencent.mm.modelfriend.a)paramn).getUsername();
      this.jkr.jlE = ((com.tencent.mm.modelfriend.a)paramn).aHv();
      com.tencent.mm.kernel.g.aiU().b(145, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.jmM == 3)
        {
          com.tencent.mm.kernel.g.aiU().a(701, this);
          com.tencent.mm.kernel.g.aiU().a(252, this);
          this.jkx = new g(new g.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              m.this.jnv.fMu = paramAnonymousProgressDialog;
            }
          }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aHv(), this.jnv.dzn);
          this.jkx.b(this.jnv);
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.uz(paramString);
        if (paramString != null)
        {
          paramString.a(this.jnv, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        h.l(this.jnv, 2131756508, 2131756514);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (paramn.getType() == 132)
    {
      com.tencent.mm.kernel.g.aiU().b(132, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.jmM == 5)
        {
          paramString = ((z)paramn).aHw();
          paramn = new Intent();
          paramn.putExtra("setpwd_ticket", paramString);
          this.jnv.setResult(-1, paramn);
          this.jnv.finish();
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.uz(paramString);
        if (paramString != null)
        {
          paramString.a(this.jnv, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        h.l(this.jnv, 2131756508, 2131756514);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (this.jnv.n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128415);
      return;
    }
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.uz(paramString);
      if ((paramString != null) && (paramString.a(this.jnv, null, null)))
      {
        AppMethodBeat.o(128415);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.jnv, this.jnv.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128415);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128411);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("F200_300") + ",1");
    com.tencent.mm.plugin.b.a.Kc("F200_300");
    AppMethodBeat.o(128411);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128412);
    int i = 2;
    if (this.jnv.jnZ != -1) {
      i = this.jnv.jnZ;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("F200_300") + "," + i);
    AppMethodBeat.o(128412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m
 * JD-Core Version:    0.7.0.1
 */