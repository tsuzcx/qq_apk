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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;

public final class n
  implements i, MobileVerifyUI.b
{
  private SecurityImage mUP;
  private g ndj;
  private h ndp;
  private int nfI;
  private MobileVerifyUI ngs;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(128410);
    this.ndp = null;
    this.mUP = null;
    this.ndj = null;
    this.nfI = paramInt;
    Log.i("MicroMsg.MobileVerifyForgetPwdLogic", "forget pwd, purpose %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(128410);
  }
  
  private void bzF()
  {
    AppMethodBeat.i(128414);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localObject = ((StringBuilder)localObject).append(b.aGR()).append(",").append(getClass().getName()).append(",R200_350_auto,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.KP(b.MN("R200_350_auto") + ",1");
    com.tencent.mm.kernel.h.aGY().a(145, this);
    com.tencent.mm.kernel.h.aGY().a(132, this);
    localObject = null;
    if (this.nfI == 3) {
      localObject = new com.tencent.mm.modelfriend.a(this.ngs.fLC, 9, this.ngs.mSy.getText().toString().trim(), 0, "");
    }
    for (;;)
    {
      if (localObject != null)
      {
        com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
        MobileVerifyUI localMobileVerifyUI1 = this.ngs;
        MobileVerifyUI localMobileVerifyUI2 = this.ngs;
        this.ngs.getString(r.j.app_tip);
        localMobileVerifyUI1.iXX = com.tencent.mm.ui.base.h.a(localMobileVerifyUI2, this.ngs.getString(r.j.bind_mcontact_verifing), true, new n.1(this, (q)localObject));
      }
      AppMethodBeat.o(128414);
      return;
      if (this.nfI == 5) {
        localObject = new z(this.ngs.fLC, 21, this.ngs.mSy.getText().toString().trim(), 0, "");
      }
    }
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.ngs = paramMobileVerifyUI;
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128413);
    switch (5.ngw[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128413);
      return false;
      bzF();
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      parama = parama.append(b.aGR()).append(",").append(getClass().getName()).append(",R200_400,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.KP(b.MN("R200_400") + ",1");
      parama = null;
      if (this.nfI == 3) {
        parama = new com.tencent.mm.modelfriend.a(this.ngs.fLC, 8, "", 0, "");
      }
      while (parama != null)
      {
        com.tencent.mm.kernel.h.aGY().a(parama, 0);
        break;
        if (this.nfI == 5) {
          parama = new z(this.ngs.fLC, 20, "", 0, "");
        }
      }
      bzF();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128415);
    Log.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.ngs.iXX != null)
    {
      this.ngs.iXX.dismiss();
      this.ngs.iXX = null;
    }
    if (this.ndj == null) {
      this.ndj = new g();
    }
    if (((paramq.getType() == 252) || (paramq.getType() == 701)) && (this.ndp != null))
    {
      com.tencent.mm.kernel.h.aGY().b(701, this);
      com.tencent.mm.kernel.h.aGY().b(252, this);
      this.ndj.mUS = ((com.tencent.mm.modelsimple.t)paramq).boB();
      this.ndj.mUR = ((com.tencent.mm.modelsimple.t)paramq).boC();
      this.ndj.mUT = ((com.tencent.mm.modelsimple.t)paramq).boD();
      this.ndj.neB = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.h.aGY().a(701, this);
        com.tencent.mm.kernel.h.aGY().a(252, this);
        if (this.mUP == null)
        {
          this.mUP = SecurityImage.a.a(this.ngs, r.j.regbyqq_secimg_title, this.ndj.neB, this.ndj.mUR, this.ndj.mUS, this.ndj.mUT, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128408);
              Log.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + n.a(n.this).mUS + " img len" + n.a(n.this).mUR.length + " " + f.avD());
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(n.a(n.this).account, n.a(n.this).neA, n.a(n.this).neB, n.b(n.this).getSecImgCode(), n.b(n.this).getSecImgSid(), n.b(n.this).getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI = n.c(n.this);
              n.c(n.this).getString(r.j.app_tip);
              com.tencent.mm.ui.base.h.a(localMobileVerifyUI, n.c(n.this).getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128407);
                  com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.h.aGY().b(701, n.this);
                  com.tencent.mm.kernel.h.aGY().b(252, n.this);
                  AppMethodBeat.o(128407);
                }
              });
              AppMethodBeat.o(128408);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(214353);
              n.d(n.this);
              AppMethodBeat.o(214353);
            }
          }, this.ndj);
          AppMethodBeat.o(128415);
          return;
        }
        Log.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.ndj.mUS + " img len" + this.ndj.mUR.length + " " + f.avD());
        this.mUP.b(this.ndj.neB, this.ndj.mUR, this.ndj.mUS, this.ndj.mUT);
        AppMethodBeat.o(128415);
        return;
      }
      this.ndp.a(this.ngs, paramInt1, paramInt2, paramString, paramq);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        boolean bool = true;
        if ((paramq instanceof com.tencent.mm.modelsimple.t)) {
          bool = ((com.tencent.mm.modelsimple.t)paramq).boK();
        }
        this.ngs.hc(bool);
      }
      AppMethodBeat.o(128415);
      return;
    }
    if (paramq.getType() == 145)
    {
      this.ndj.account = ((com.tencent.mm.modelfriend.a)paramq).getUsername();
      this.ndj.neA = ((com.tencent.mm.modelfriend.a)paramq).bkV();
      com.tencent.mm.kernel.h.aGY().b(145, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.nfI == 3)
        {
          com.tencent.mm.kernel.h.aGY().a(701, this);
          com.tencent.mm.kernel.h.aGY().a(252, this);
          this.ndp = new h(new h.a()
          {
            public final void a(ProgressDialog paramAnonymousProgressDialog)
            {
              AppMethodBeat.i(219596);
              n.c(n.this).iXX = paramAnonymousProgressDialog;
              AppMethodBeat.o(219596);
            }
          }, ((com.tencent.mm.modelfriend.a)paramq).getUsername(), ((com.tencent.mm.modelfriend.a)paramq).bkV(), this.ngs.fLC);
          this.ndp.c(this.ngs);
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.Kb(paramString);
        if (paramString != null)
        {
          paramString.a(this.ngs, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        com.tencent.mm.ui.base.h.p(this.ngs, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (paramq.getType() == 132)
    {
      com.tencent.mm.kernel.h.aGY().b(132, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.nfI == 5)
        {
          paramString = ((z)paramq).bkW();
          paramq = new Intent();
          paramq.putExtra("setpwd_ticket", paramString);
          this.ngs.setResult(-1, paramq);
          this.ngs.finish();
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.Kb(paramString);
        if (paramString != null)
        {
          paramString.a(this.ngs, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        com.tencent.mm.ui.base.h.p(this.ngs, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (this.ngs.n(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128415);
      return;
    }
    if ((paramq.getType() == 252) || (paramq.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.Kb(paramString);
      if ((paramString != null) && (paramString.a(this.ngs, null, null)))
      {
        AppMethodBeat.o(128415);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.ngs, this.ngs.getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128415);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128411);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(b.aGR()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(true, b.MN("F200_300") + ",1");
    com.tencent.mm.plugin.b.a.bgi("F200_300");
    AppMethodBeat.o(128411);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128412);
    int i = 2;
    if (this.ngs.ngV != -1) {
      i = this.ngs.ngV;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(b.aGR()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(false, b.MN("F200_300") + "," + i);
    com.tencent.mm.kernel.h.aGY().b(132, this);
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    com.tencent.mm.kernel.h.aGY().b(145, this);
    AppMethodBeat.o(128412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.n
 * JD-Core Version:    0.7.0.1
 */