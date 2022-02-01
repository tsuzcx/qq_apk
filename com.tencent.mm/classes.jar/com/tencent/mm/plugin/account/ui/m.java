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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public final class m
  implements com.tencent.mm.ak.f, MobileVerifyUI.b
{
  SecurityImage jfm;
  f jnl;
  private g jnr;
  private int jpG;
  MobileVerifyUI jqo;
  
  public m(int paramInt)
  {
    AppMethodBeat.i(128410);
    this.jnr = null;
    this.jfm = null;
    this.jnl = null;
    this.jpG = paramInt;
    ae.i("MicroMsg.MobileVerifyForgetPwdLogic", "forget pwd, purpose %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(128410);
  }
  
  private void aUG()
  {
    AppMethodBeat.i(128414);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_350_auto,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_350_auto") + ",1");
    com.tencent.mm.kernel.g.ajj().a(145, this);
    com.tencent.mm.kernel.g.ajj().a(132, this);
    localObject = null;
    if (this.jpG == 3) {
      localObject = new com.tencent.mm.modelfriend.a(this.jqo.dAs, 9, this.jqo.jda.getText().toString().trim(), 0, "");
    }
    for (;;)
    {
      if (localObject != null)
      {
        com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
        MobileVerifyUI localMobileVerifyUI1 = this.jqo;
        MobileVerifyUI localMobileVerifyUI2 = this.jqo;
        this.jqo.getString(2131755906);
        localMobileVerifyUI1.fOC = h.b(localMobileVerifyUI2, this.jqo.getString(2131756503), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128406);
            com.tencent.mm.kernel.g.ajj().a(this.jqp);
            com.tencent.mm.kernel.g.ajj().b(145, m.this);
            com.tencent.mm.kernel.g.ajj().b(132, m.this);
            AppMethodBeat.o(128406);
          }
        });
      }
      AppMethodBeat.o(128414);
      return;
      if (this.jpG == 5) {
        localObject = new z(this.jqo.dAs, 21, this.jqo.jda.getText().toString().trim(), 0, "");
      }
    }
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.jqo = paramMobileVerifyUI;
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128413);
    switch (5.jqs[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128413);
      return false;
      aUG();
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.g.ajP();
      parama = parama.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_400,");
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_400") + ",1");
      parama = null;
      if (this.jpG == 3) {
        parama = new com.tencent.mm.modelfriend.a(this.jqo.dAs, 8, "", 0, "");
      }
      while (parama != null)
      {
        com.tencent.mm.kernel.g.ajj().a(parama, 0);
        break;
        if (this.jpG == 5) {
          parama = new z(this.jqo.dAs, 20, "", 0, "");
        }
      }
      aUG();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128415);
    ae.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jqo.fOC != null)
    {
      this.jqo.fOC.dismiss();
      this.jqo.fOC = null;
    }
    if (this.jnl == null) {
      this.jnl = new f();
    }
    if (((paramn.getType() == 252) || (paramn.getType() == 701)) && (this.jnr != null))
    {
      com.tencent.mm.kernel.g.ajj().b(701, this);
      com.tencent.mm.kernel.g.ajj().b(252, this);
      this.jnl.jfp = ((t)paramn).aLi();
      this.jnl.jfo = ((t)paramn).aLj();
      this.jnl.jfq = ((t)paramn).aLk();
      this.jnl.joz = ((t)paramn).getSecCodeType();
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.g.ajj().a(701, this);
        com.tencent.mm.kernel.g.ajj().a(252, this);
        if (this.jfm == null)
        {
          this.jfm = SecurityImage.a.a(this.jqo, this.jnl.joz, this.jnl.jfo, this.jnl.jfp, this.jnl.jfq, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128408);
              ae.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + m.this.jnl.jfp + " img len" + m.this.jnl.jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
              paramAnonymousDialogInterface = new t(m.this.jnl.account, m.this.jnl.joy, m.this.jnl.joz, m.this.jfm.getSecImgCode(), m.this.jfm.getSecImgSid(), m.this.jfm.getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI = m.this.jqo;
              m.this.jqo.getString(2131755906);
              h.b(localMobileVerifyUI, m.this.jqo.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128407);
                  com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.ajj().b(701, m.this);
                  com.tencent.mm.kernel.g.ajj().b(252, m.this);
                  AppMethodBeat.o(128407);
                }
              });
              AppMethodBeat.o(128408);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              m.this.jfm = null;
            }
          }, this.jnl);
          AppMethodBeat.o(128415);
          return;
        }
        ae.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.jnl.jfp + " img len" + this.jnl.jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
        this.jfm.b(this.jnl.joz, this.jnl.jfo, this.jnl.jfp, this.jnl.jfq);
        AppMethodBeat.o(128415);
        return;
      }
      this.jnr.a(this.jqo, paramInt1, paramInt2, paramString, paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        boolean bool = true;
        if ((paramn instanceof t)) {
          bool = ((t)paramn).aLr();
        }
        this.jqo.fx(bool);
      }
      AppMethodBeat.o(128415);
      return;
    }
    if (paramn.getType() == 145)
    {
      this.jnl.account = ((com.tencent.mm.modelfriend.a)paramn).getUsername();
      this.jnl.joy = ((com.tencent.mm.modelfriend.a)paramn).aHM();
      com.tencent.mm.kernel.g.ajj().b(145, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.jpG == 3)
        {
          com.tencent.mm.kernel.g.ajj().a(701, this);
          com.tencent.mm.kernel.g.ajj().a(252, this);
          this.jnr = new g(new g.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              m.this.jqo.fOC = paramAnonymousProgressDialog;
            }
          }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aHM(), this.jqo.dAs);
          this.jnr.b(this.jqo);
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.uU(paramString);
        if (paramString != null)
        {
          paramString.a(this.jqo, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        h.l(this.jqo, 2131756508, 2131756514);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (paramn.getType() == 132)
    {
      com.tencent.mm.kernel.g.ajj().b(132, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.jpG == 5)
        {
          paramString = ((z)paramn).aHN();
          paramn = new Intent();
          paramn.putExtra("setpwd_ticket", paramString);
          this.jqo.setResult(-1, paramn);
          this.jqo.finish();
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.uU(paramString);
        if (paramString != null)
        {
          paramString.a(this.jqo, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        h.l(this.jqo, 2131756508, 2131756514);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (this.jqo.n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128415);
      return;
    }
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.uU(paramString);
      if ((paramString != null) && (paramString.a(this.jqo, null, null)))
      {
        AppMethodBeat.o(128415);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.jqo, this.jqo.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128415);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128411);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("F200_300") + ",1");
    com.tencent.mm.plugin.b.a.KA("F200_300");
    AppMethodBeat.o(128411);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128412);
    int i = 2;
    if (this.jqo.jqS != -1) {
      i = this.jqo.jqS;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("F200_300") + "," + i);
    AppMethodBeat.o(128412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m
 * JD-Core Version:    0.7.0.1
 */