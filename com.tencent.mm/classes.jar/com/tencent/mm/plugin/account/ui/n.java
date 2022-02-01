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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.b;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.friend.model.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.k;

public final class n
  implements com.tencent.mm.am.h, MobileVerifyUI.b
{
  private SecurityImage pRw;
  private f pZh;
  private h qaG;
  private int qcR;
  private MobileVerifyUI qdA;
  
  public n(int paramInt)
  {
    AppMethodBeat.i(128410);
    this.qaG = null;
    this.pRw = null;
    this.pZh = null;
    this.qcR = paramInt;
    Log.i("MicroMsg.MobileVerifyForgetPwdLogic", "forget pwd, purpose %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(128410);
  }
  
  private void bYt()
  {
    AppMethodBeat.i(128414);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localObject = ((StringBuilder)localObject).append(b.aZR()).append(",").append(getClass().getName()).append(",R200_350_auto,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.Du(b.Fw("R200_350_auto") + ",1");
    com.tencent.mm.kernel.h.aZW().a(145, this);
    com.tencent.mm.kernel.h.aZW().a(132, this);
    localObject = null;
    if (this.qcR == 3) {
      localObject = new com.tencent.mm.modelfriend.a(this.qdA.hRk, 9, this.qdA.pPd.getText().toString().trim(), 0, "");
    }
    for (;;)
    {
      if (localObject != null)
      {
        com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
        MobileVerifyUI localMobileVerifyUI1 = this.qdA;
        MobileVerifyUI localMobileVerifyUI2 = this.qdA;
        this.qdA.getString(r.j.app_tip);
        localMobileVerifyUI1.lzP = k.a(localMobileVerifyUI2, this.qdA.getString(r.j.bind_mcontact_verifing), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128406);
            com.tencent.mm.kernel.h.aZW().a(this.qdB);
            com.tencent.mm.kernel.h.aZW().b(145, n.this);
            com.tencent.mm.kernel.h.aZW().b(132, n.this);
            AppMethodBeat.o(128406);
          }
        });
      }
      AppMethodBeat.o(128414);
      return;
      if (this.qcR == 5) {
        localObject = new w(this.qdA.hRk, 21, this.qdA.pPd.getText().toString().trim(), 0, "", "");
      }
    }
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.qdA = paramMobileVerifyUI;
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128413);
    switch (5.qdE[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128413);
      return false;
      bYt();
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      parama = parama.append(b.aZR()).append(",").append(getClass().getName()).append(",R200_400,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.Du(b.Fw("R200_400") + ",1");
      parama = null;
      if (this.qcR == 3) {
        parama = new com.tencent.mm.modelfriend.a(this.qdA.hRk, 8, "", 0, "");
      }
      while (parama != null)
      {
        com.tencent.mm.kernel.h.aZW().a(parama, 0);
        break;
        if (this.qcR == 5) {
          parama = new w(this.qdA.hRk, 20, "", 0, "", "");
        }
      }
      bYt();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(128415);
    Log.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.qdA.lzP != null)
    {
      this.qdA.lzP.dismiss();
      this.qdA.lzP = null;
    }
    if (this.pZh == null) {
      this.pZh = new f();
    }
    if (((paramp.getType() == 252) || (paramp.getType() == 701)) && (this.qaG != null))
    {
      com.tencent.mm.kernel.h.aZW().b(701, this);
      com.tencent.mm.kernel.h.aZW().b(252, this);
      this.pZh.pRz = ((u)paramp).bMi();
      this.pZh.pRy = ((u)paramp).bMj();
      this.pZh.pRA = ((u)paramp).bMk();
      this.pZh.qbo = ((u)paramp).getSecCodeType();
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        com.tencent.mm.kernel.h.aZW().a(701, this);
        com.tencent.mm.kernel.h.aZW().a(252, this);
        if (this.pRw == null)
        {
          this.pRw = SecurityImage.a.a(this.qdA, r.j.regbyqq_secimg_title, this.pZh.qbo, this.pZh.pRy, this.pZh.pRz, this.pZh.pRA, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128408);
              Log.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + n.a(n.this).pRz + " img len" + n.a(n.this).pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
              paramAnonymousDialogInterface = new u(n.a(n.this).account, n.a(n.this).qbn, n.a(n.this).qbo, n.b(n.this).getSecImgCode(), n.b(n.this).getSecImgSid(), n.b(n.this).getSecImgEncryptKey(), 1, "", false, true);
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI = n.c(n.this);
              n.c(n.this).getString(r.j.app_tip);
              k.a(localMobileVerifyUI, n.c(n.this).getString(r.j.login_logining), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128407);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.h.aZW().b(701, n.this);
                  com.tencent.mm.kernel.h.aZW().b(252, n.this);
                  AppMethodBeat.o(128407);
                }
              });
              AppMethodBeat.o(128408);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(304911);
              n.d(n.this);
              AppMethodBeat.o(304911);
            }
          }, this.pZh);
          AppMethodBeat.o(128415);
          return;
        }
        Log.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.pZh.pRz + " img len" + this.pZh.pRy.length + " " + com.tencent.mm.compatible.util.f.aPX());
        this.pRw.b(this.pZh.qbo, this.pZh.pRy, this.pZh.pRz, this.pZh.pRA);
        AppMethodBeat.o(128415);
        return;
      }
      this.qaG.a(this.qdA, paramInt1, paramInt2, paramString, paramp);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        boolean bool = true;
        if ((paramp instanceof u)) {
          bool = ((u)paramp).bMr();
        }
        this.qdA.hR(bool);
      }
      AppMethodBeat.o(128415);
      return;
    }
    if (paramp.getType() == 145)
    {
      this.pZh.account = ((com.tencent.mm.modelfriend.a)paramp).getUsername();
      this.pZh.qbn = ((com.tencent.mm.modelfriend.a)paramp).bIP();
      com.tencent.mm.kernel.h.aZW().b(145, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.qcR == 3)
        {
          com.tencent.mm.kernel.h.aZW().a(701, this);
          com.tencent.mm.kernel.h.aZW().a(252, this);
          this.qaG = new h(new h.a()
          {
            public final void b(ProgressDialog paramAnonymousProgressDialog)
            {
              AppMethodBeat.i(304910);
              n.c(n.this).lzP = paramAnonymousProgressDialog;
              AppMethodBeat.o(304910);
            }
          }, ((com.tencent.mm.modelfriend.a)paramp).getUsername(), ((com.tencent.mm.modelfriend.a)paramp).bIP(), this.qdA.hRk);
          this.qaG.d(this.qdA);
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        if (paramString != null)
        {
          paramString.a(this.qdA, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        k.s(this.qdA, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (paramp.getType() == 132)
    {
      com.tencent.mm.kernel.h.aZW().b(132, this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.qcR == 5)
        {
          paramString = ((w)paramp).bIQ();
          paramp = new Intent();
          paramp.putExtra("setpwd_ticket", paramString);
          this.qdA.setResult(-1, paramp);
          this.qdA.finish();
        }
        AppMethodBeat.o(128415);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        if (paramString != null)
        {
          paramString.a(this.qdA, null, null);
          AppMethodBeat.o(128415);
          return;
        }
        k.s(this.qdA, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip);
        AppMethodBeat.o(128415);
        return;
      }
    }
    if (this.qdA.p(paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128415);
      return;
    }
    if ((paramp.getType() == 252) || (paramp.getType() == 701))
    {
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
      if ((paramString != null) && (paramString.a(this.qdA, null, null)))
      {
        AppMethodBeat.o(128415);
        return;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      Toast.makeText(this.qdA, this.qdA.getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    }
    AppMethodBeat.o(128415);
  }
  
  public final void start()
  {
    AppMethodBeat.i(128411);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(b.aZR()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(true, b.Fw("F200_300") + ",1");
    com.tencent.mm.plugin.b.a.Tz("F200_300");
    AppMethodBeat.o(128411);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128412);
    int i = 2;
    if (this.qdA.qed != -1) {
      i = this.qdA.qed;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(b.aZR()).append(",").append(getClass().getName()).append(",F200_300,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(false, b.Fw("F200_300") + "," + i);
    com.tencent.mm.kernel.h.aZW().b(132, this);
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    com.tencent.mm.kernel.h.aZW().b(145, this);
    AppMethodBeat.o(128412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.n
 * JD-Core Version:    0.7.0.1
 */