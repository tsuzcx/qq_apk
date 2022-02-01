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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;

public final class n
  implements i, MobileVerifyUI.c
{
  SecurityImage kdp;
  g klt;
  private h klz;
  private int knQ;
  MobileVerifyUI koA;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(128410);
    this.klz = null;
    this.kdp = null;
    this.klt = null;
    this.knQ = paramInt;
    Log.i("MicroMsg.MobileVerifyForgetPwdLogic", "forget pwd, purpose %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(128410);
  }
  
  private void bpt()
  {
    AppMethodBeat.i(128414);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.aAf();
    localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_350_auto,");
    com.tencent.mm.kernel.g.aAf();
    com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_350_auto") + ",1");
    com.tencent.mm.kernel.g.azz().a(145, this);
    com.tencent.mm.kernel.g.azz().a(132, this);
    localObject = null;
    if (this.knQ == 3) {
      localObject = new com.tencent.mm.modelfriend.a(this.koA.dSf, 9, this.koA.kbd.getText().toString().trim(), 0, "");
    }
    for (;;)
    {
      if (localObject != null)
      {
        com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
        MobileVerifyUI localMobileVerifyUI1 = this.koA;
        MobileVerifyUI localMobileVerifyUI2 = this.koA;
        this.koA.getString(2131755998);
        localMobileVerifyUI1.gtM = com.tencent.mm.ui.base.h.a(localMobileVerifyUI2, this.koA.getString(2131756639), true, new n.1(this, (q)localObject));
      }
      AppMethodBeat.o(128414);
      return;
      if (this.knQ == 5) {
        localObject = new z(this.koA.dSf, 21, this.koA.kbd.getText().toString().trim(), 0, "");
      }
    }
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.koA = paramMobileVerifyUI;
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128413);
    switch (5.koE[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128413);
      return false;
      bpt();
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.g.aAf();
      parama = parama.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_400,");
      com.tencent.mm.kernel.g.aAf();
      com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_400") + ",1");
      parama = null;
      if (this.knQ == 3) {
        parama = new com.tencent.mm.modelfriend.a(this.koA.dSf, 8, "", 0, "");
      }
      while (parama != null)
      {
        com.tencent.mm.kernel.g.azz().a(parama, 0);
        break;
        if (this.knQ == 5) {
          parama = new z(this.koA.dSf, 20, "", 0, "");
        }
      }
      bpt();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128415);
    Log.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.koA.gtM != null)
    {
      this.koA.gtM.dismiss();
      this.koA.gtM = null;
    }
    if (this.klt == null) {
      this.klt = new g();
    }
    if (((paramq.getType() == 252) || (paramq.getType() == 701)) && (this.klz != null))
    {
      com.tencent.mm.kernel.g.azz().b(701, this);
      com.tencent.mm.kernel.g.azz().b(252, this);
      this.klt.kds = ((com.tencent.mm.modelsimple.t)paramq).bfl();
      this.klt.kdr = ((com.tencent.mm.modelsimple.t)paramq).bfm();
      this.klt.kdt = ((com.tencent.mm.modelsimple.t)paramq).bfn();
      this.klt.kmJ = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.g.azz().a(701, this);
        com.tencent.mm.kernel.g.azz().a(252, this);
        if (this.kdp == null)
        {
          this.kdp = SecurityImage.a.a(this.koA, this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128408);
              Log.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + n.this.klt.kds + " img len" + n.this.klt.kdr.length + " " + f.apq());
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(n.this.klt.account, n.this.klt.kmI, n.this.klt.kmJ, n.this.kdp.getSecImgCode(), n.this.kdp.getSecImgSid(), n.this.kdp.getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI = n.this.koA;
              n.this.koA.getString(2131755998);
              com.tencent.mm.ui.base.h.a(localMobileVerifyUI, n.this.koA.getString(2131762532), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128407);
                  com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.azz().b(701, n.this);
                  com.tencent.mm.kernel.g.azz().b(252, n.this);
                  AppMethodBeat.o(128407);
                }
              });
              AppMethodBeat.o(128408);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              n.this.kdp = null;
            }
          }, this.klt);
          AppMethodBeat.o(128415);
          return;
        }
        Log.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.klt.kds + " img len" + this.klt.kdr.length + " " + f.apq());
        this.kdp.b(this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt);
        AppMethodBeat.o(128415);
        return;
      }
      this.klz.a(this.koA, paramInt1, paramInt2, paramString, paramq);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        boolean bool = true;
        if ((paramq instanceof com.tencent.mm.modelsimple.t)) {
          bool = ((com.tencent.mm.modelsimple.t)paramq).bfu();
        }
        this.koA.gq(bool);
      }
      AppMethodBeat.o(128415);
      return;
    }
    if (paramq.getType() == 145)
    {
      this.klt.account = ((com.tencent.mm.modelfriend.a)paramq).getUsername();
      this.klt.kmI = ((com.tencent.mm.modelfriend.a)paramq).bbF();
      com.tencent.mm.kernel.g.azz().b(145, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.knQ == 3)
        {
          com.tencent.mm.kernel.g.azz().a(701, this);
          com.tencent.mm.kernel.g.azz().a(252, this);
          this.klz = new h(new h.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              n.this.koA.gtM = paramAnonymousProgressDialog;
            }
          }, ((com.tencent.mm.modelfriend.a)paramq).getUsername(), ((com.tencent.mm.modelfriend.a)paramq).bbF(), this.koA.dSf);
          this.klz.b(this.koA);
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if (paramString != null)
        {
          paramString.a(this.koA, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        com.tencent.mm.ui.base.h.n(this.koA, 2131756644, 2131756650);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (paramq.getType() == 132)
    {
      com.tencent.mm.kernel.g.azz().b(132, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.knQ == 5)
        {
          paramString = ((z)paramq).bbG();
          paramq = new Intent();
          paramq.putExtra("setpwd_ticket", paramString);
          this.koA.setResult(-1, paramq);
          this.koA.finish();
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if (paramString != null)
        {
          paramString.a(this.koA, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        com.tencent.mm.ui.base.h.n(this.koA, 2131756644, 2131756650);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (this.koA.n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128415);
      return;
    }
    if ((paramq.getType() == 252) || (paramq.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.Dk(paramString);
      if ((paramString != null) && (paramString.a(this.koA, null, null)))
      {
        AppMethodBeat.o(128415);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.koA, this.koA.getString(2131756643, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128415);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128411);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.aAf();
    com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("F200_300") + ",1");
    com.tencent.mm.plugin.b.a.bwU("F200_300");
    AppMethodBeat.o(128411);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128412);
    int i = 2;
    if (this.koA.kpe != -1) {
      i = this.koA.kpe;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("F200_300") + "," + i);
    AppMethodBeat.o(128412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.n
 * JD-Core Version:    0.7.0.1
 */