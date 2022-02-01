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
  implements com.tencent.mm.al.g, MobileVerifyUI.b
{
  SecurityImage ijd;
  f ird;
  private g irj;
  private int itz;
  MobileVerifyUI iuh;
  
  public m(int paramInt)
  {
    AppMethodBeat.i(128410);
    this.irj = null;
    this.ijd = null;
    this.ird = null;
    this.itz = paramInt;
    ad.i("MicroMsg.MobileVerifyForgetPwdLogic", "forget pwd, purpose %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(128410);
  }
  
  private void aKe()
  {
    AppMethodBeat.i(128414);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_350_auto,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_350_auto") + ",1");
    com.tencent.mm.kernel.g.aeS().a(145, this);
    com.tencent.mm.kernel.g.aeS().a(132, this);
    localObject = null;
    if (this.itz == 3) {
      localObject = new com.tencent.mm.modelfriend.a(this.iuh.dpO, 9, this.iuh.igP.getText().toString().trim(), 0, "");
    }
    for (;;)
    {
      if (localObject != null)
      {
        com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
        MobileVerifyUI localMobileVerifyUI1 = this.iuh;
        MobileVerifyUI localMobileVerifyUI2 = this.iuh;
        this.iuh.getString(2131755906);
        localMobileVerifyUI1.fpP = h.b(localMobileVerifyUI2, this.iuh.getString(2131756503), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128406);
            com.tencent.mm.kernel.g.aeS().a(this.iui);
            com.tencent.mm.kernel.g.aeS().b(145, m.this);
            com.tencent.mm.kernel.g.aeS().b(132, m.this);
            AppMethodBeat.o(128406);
          }
        });
      }
      AppMethodBeat.o(128414);
      return;
      if (this.itz == 5) {
        localObject = new z(this.iuh.dpO, 21, this.iuh.igP.getText().toString().trim(), 0, "");
      }
    }
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.iuh = paramMobileVerifyUI;
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128413);
    switch (5.iul[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128413);
      return false;
      aKe();
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.g.afz();
      parama = parama.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_400,");
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_400") + ",1");
      parama = null;
      if (this.itz == 3) {
        parama = new com.tencent.mm.modelfriend.a(this.iuh.dpO, 8, "", 0, "");
      }
      while (parama != null)
      {
        com.tencent.mm.kernel.g.aeS().a(parama, 0);
        break;
        if (this.itz == 5) {
          parama = new z(this.iuh.dpO, 20, "", 0, "");
        }
      }
      aKe();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128415);
    ad.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iuh.fpP != null)
    {
      this.iuh.fpP.dismiss();
      this.iuh.fpP = null;
    }
    if (this.ird == null) {
      this.ird = new f();
    }
    if (((paramn.getType() == 252) || (paramn.getType() == 701)) && (this.irj != null))
    {
      com.tencent.mm.kernel.g.aeS().b(701, this);
      com.tencent.mm.kernel.g.aeS().b(252, this);
      this.ird.ijg = ((s)paramn).aAK();
      this.ird.ijf = ((s)paramn).aAL();
      this.ird.ijh = ((s)paramn).aAM();
      this.ird.iss = ((s)paramn).getSecCodeType();
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.g.aeS().a(701, this);
        com.tencent.mm.kernel.g.aeS().a(252, this);
        if (this.ijd == null)
        {
          this.ijd = SecurityImage.a.a(this.iuh, this.ird.iss, this.ird.ijf, this.ird.ijg, this.ird.ijh, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128408);
              ad.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + m.this.ird.ijg + " img len" + m.this.ird.ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
              paramAnonymousDialogInterface = new s(m.this.ird.account, m.this.ird.isr, m.this.ird.iss, m.this.ijd.getSecImgCode(), m.this.ijd.getSecImgSid(), m.this.ijd.getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI = m.this.iuh;
              m.this.iuh.getString(2131755906);
              h.b(localMobileVerifyUI, m.this.iuh.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128407);
                  com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.aeS().b(701, m.this);
                  com.tencent.mm.kernel.g.aeS().b(252, m.this);
                  AppMethodBeat.o(128407);
                }
              });
              AppMethodBeat.o(128408);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              m.this.ijd = null;
            }
          }, this.ird);
          AppMethodBeat.o(128415);
          return;
        }
        ad.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.ird.ijg + " img len" + this.ird.ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
        this.ijd.b(this.ird.iss, this.ird.ijf, this.ird.ijg, this.ird.ijh);
        AppMethodBeat.o(128415);
        return;
      }
      this.irj.a(this.iuh, paramInt1, paramInt2, paramString, paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        boolean bool = true;
        if ((paramn instanceof s)) {
          bool = ((s)paramn).aAT();
        }
        this.iuh.eY(bool);
      }
      AppMethodBeat.o(128415);
      return;
    }
    if (paramn.getType() == 145)
    {
      this.ird.account = ((com.tencent.mm.modelfriend.a)paramn).getUsername();
      this.ird.isr = ((com.tencent.mm.modelfriend.a)paramn).axy();
      com.tencent.mm.kernel.g.aeS().b(145, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.itz == 3)
        {
          com.tencent.mm.kernel.g.aeS().a(701, this);
          com.tencent.mm.kernel.g.aeS().a(252, this);
          this.irj = new g(new g.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              m.this.iuh.fpP = paramAnonymousProgressDialog;
            }
          }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).axy(), this.iuh.dpO);
          this.irj.a(this.iuh);
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.oG(paramString);
        if (paramString != null)
        {
          paramString.a(this.iuh, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        h.j(this.iuh, 2131756508, 2131756514);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (paramn.getType() == 132)
    {
      com.tencent.mm.kernel.g.aeS().b(132, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.itz == 5)
        {
          paramString = ((z)paramn).axz();
          paramn = new Intent();
          paramn.putExtra("setpwd_ticket", paramString);
          this.iuh.setResult(-1, paramn);
          this.iuh.finish();
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.oG(paramString);
        if (paramString != null)
        {
          paramString.a(this.iuh, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        h.j(this.iuh, 2131756508, 2131756514);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (this.iuh.n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128415);
      return;
    }
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.oG(paramString);
      if ((paramString != null) && (paramString.a(this.iuh, null, null)))
      {
        AppMethodBeat.o(128415);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.iuh, this.iuh.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128415);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128411);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("F200_300") + ",1");
    com.tencent.mm.plugin.b.a.aUy("F200_300");
    AppMethodBeat.o(128411);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128412);
    int i = 2;
    if (this.iuh.iuL != -1) {
      i = this.iuh.iuL;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("F200_300") + "," + i);
    AppMethodBeat.o(128412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m
 * JD-Core Version:    0.7.0.1
 */