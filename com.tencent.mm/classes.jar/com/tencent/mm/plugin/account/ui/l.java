package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.v;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class l
  implements com.tencent.mm.ak.f, MobileInputUI.b
{
  String account;
  private String dLz;
  private String dyO;
  SecurityImage jfm = null;
  private String jlr;
  private boolean jnm = true;
  private String jno;
  MobileInputUI jpb;
  
  private void Kw(final String paramString)
  {
    AppMethodBeat.i(128324);
    paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
    com.tencent.mm.kernel.g.ajj().a(paramString, 0);
    MobileInputUI localMobileInputUI1 = this.jpb;
    MobileInputUI localMobileInputUI2 = this.jpb;
    this.jpb.getString(2131755906);
    localMobileInputUI1.jfk = h.b(localMobileInputUI2, this.jpb.getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128316);
        com.tencent.mm.kernel.g.ajj().a(paramString);
        AppMethodBeat.o(128316);
      }
    });
    AppMethodBeat.o(128324);
  }
  
  private void aUA()
  {
    AppMethodBeat.i(128320);
    if (this.jpb.hJc == 6)
    {
      this.jpb.jpt.reset();
      this.jpb.jpB.setText(2131760777);
      this.jpb.joI.setVisibility(8);
      this.jpb.jpt.setVisibility(0);
      this.jpb.jpt.getContentEditText().requestFocus();
      this.jpb.jpt.setSendSmsBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128311);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          l.a(l.this, l.this.account);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128311);
        }
      });
      this.jpb.jpB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128312);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          l.this.jpb.joi[1] = 2;
          l.this.jpb.hJc = 7;
          l.this.jpb.jpt.reset();
          com.tencent.mm.kernel.g.ajj().b(145, l.this);
          l.a(l.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128312);
        }
      });
      AppMethodBeat.o(128320);
      return;
    }
    if (this.jpb.hJc == 7)
    {
      this.jpb.jpB.setText(2131760778);
      this.jpb.joI.setVisibility(0);
      this.jpb.jnE.requestFocus();
      this.jpb.jpt.setVisibility(8);
      this.jpb.jpB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128313);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          l.this.jpb.joi[1] = 1;
          l.this.jpb.hJc = 6;
          com.tencent.mm.kernel.g.ajj().a(145, l.this);
          l.a(l.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128313);
        }
      });
    }
    AppMethodBeat.o(128320);
  }
  
  private void bT(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(128325);
    if (bu.isNullOrNil(paramString1))
    {
      h.l(this.jpb, 2131764665, 2131760766);
      AppMethodBeat.o(128325);
      return;
    }
    if (bu.isNullOrNil(paramString2))
    {
      h.l(this.jpb, 2131764658, 2131760766);
      AppMethodBeat.o(128325);
      return;
    }
    this.jpb.jnE.setText(paramString2);
    this.jpb.hideVKB();
    paramString1 = new com.tencent.mm.modelsimple.t(paramString1, paramString2, null, 1);
    com.tencent.mm.kernel.g.ajj().a(paramString1, 0);
    paramString2 = this.jpb;
    MobileInputUI localMobileInputUI = this.jpb;
    this.jpb.getString(2131755906);
    paramString2.jfk = h.b(localMobileInputUI, this.jpb.getString(2131760781), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128317);
        com.tencent.mm.kernel.g.ajj().a(paramString1);
        AppMethodBeat.o(128317);
      }
    });
    AppMethodBeat.o(128325);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128327);
    if (com.tencent.mm.plugin.account.a.a.iUA.a(this.jpb, paramInt1, paramInt2, paramString))
    {
      AppMethodBeat.o(128327);
      return true;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(128327);
      return false;
    case -1: 
      if (com.tencent.mm.kernel.g.ajj().aFd() == 5)
      {
        h.l(this.jpb, 2131761537, 2131761536);
        AppMethodBeat.o(128327);
        return true;
      }
      AppMethodBeat.o(128327);
      return false;
    case -3: 
      h.l(this.jpb, 2131758459, 2131760766);
      AppMethodBeat.o(128327);
      return true;
    case -9: 
      h.l(this.jpb, 2131760765, 2131760766);
      AppMethodBeat.o(128327);
      return true;
    case -100: 
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.kernel.a.hold();
      MobileInputUI localMobileInputUI = this.jpb;
      com.tencent.mm.kernel.g.ajP();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aiH())) {}
      for (paramString = com.tencent.mm.cb.a.az(this.jpb, 2131761063);; paramString = com.tencent.mm.kernel.a.aiH())
      {
        h.a(localMobileInputUI, paramString, this.jpb.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128327);
        return true;
        com.tencent.mm.kernel.g.ajP();
      }
    case -140: 
      if (!bu.isNullOrNil(this.dLz)) {
        y.n(this.jpb, paramString, this.dLz);
      }
      AppMethodBeat.o(128327);
      return true;
    case -34: 
      Toast.makeText(this.jpb, 2131756462, 0).show();
      AppMethodBeat.o(128327);
      return true;
    case -32: 
      h.a(this.jpb, 2131756510, 2131756514, null);
      AppMethodBeat.o(128327);
      return true;
    }
    h.a(this.jpb, 2131756508, 2131756514, null);
    AppMethodBeat.o(128327);
    return true;
  }
  
  public final void a(final MobileInputUI.a parama)
  {
    AppMethodBeat.i(128323);
    switch (11.jpg[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128323);
      return;
      this.jpb.hideVKB();
      this.jpb.jpE = com.tencent.mm.sdk.platformtools.bb.aSh(this.jpb.countryCode);
      this.jpb.jpF = this.jpb.jps.getText().toString();
      if ((bu.isNullOrNil(this.jpb.jpE)) || (bu.isNullOrNil(this.jpb.jpF)))
      {
        AppMethodBeat.o(128323);
        return;
      }
      if (this.jpb.hJc == 7)
      {
        if (!bu.isNullOrNil(this.dyO))
        {
          bT(this.account, this.dyO);
          AppMethodBeat.o(128323);
          return;
        }
        bT(this.account, this.jpb.jnE.getText().toString());
        AppMethodBeat.o(128323);
        return;
      }
      if (this.jpb.hJc == 6)
      {
        parama = this.jpb.jpt.getText().toString().trim();
        if (bu.isNullOrNil(parama))
        {
          h.l(this.jpb, 2131764664, 2131760766);
          AppMethodBeat.o(128323);
          return;
        }
        this.jpb.hideVKB();
        parama = new com.tencent.mm.modelfriend.a(this.account, 17, parama, 0, "");
        com.tencent.mm.kernel.g.ajj().a(parama, 0);
        MobileInputUI localMobileInputUI1 = this.jpb;
        MobileInputUI localMobileInputUI2 = this.jpb;
        this.jpb.getString(2131755906);
        localMobileInputUI1.jfk = h.b(localMobileInputUI2, this.jpb.getString(2131756503), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128315);
            com.tencent.mm.kernel.g.ajj().a(parama);
            AppMethodBeat.o(128315);
          }
        });
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128319);
    this.jpb = paramMobileInputUI;
    paramMobileInputUI.jpz.setVisibility(0);
    this.account = paramMobileInputUI.getIntent().getStringExtra("binded_mobile");
    if (bu.isNullOrNil(this.account)) {
      this.account = com.tencent.mm.sdk.platformtools.bb.aSf(paramMobileInputUI.jpE + paramMobileInputUI.jpF);
    }
    paramMobileInputUI.jps.setTextColor(paramMobileInputUI.getResources().getColor(2131100490));
    paramMobileInputUI.jps.setEnabled(false);
    paramMobileInputUI.jps.setFocusable(false);
    paramMobileInputUI.jpr.setFocusable(false);
    paramMobileInputUI.jpr.setText(com.tencent.mm.sdk.platformtools.bb.aSf(this.account));
    paramMobileInputUI.jpr.setVisibility(0);
    aUA();
    paramMobileInputUI.jpB.setVisibility(0);
    paramMobileInputUI.jpx.setText(2131760774);
    paramMobileInputUI.jpx.setVisibility(0);
    paramMobileInputUI.jpx.setEnabled(true);
    this.jno = com.tencent.mm.model.bb.hIK.ay("login_weixin_username", "");
    this.jlr = paramMobileInputUI.getIntent().getStringExtra("auth_ticket");
    if (!bu.isNullOrNil(this.jlr)) {
      new aq().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128303);
          l.a(l.this, f.aUx(), f.aUy());
          AppMethodBeat.o(128303);
        }
      }, 500L);
    }
    AppMethodBeat.o(128319);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128326);
    ae.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jpb.jfk != null)
    {
      this.jpb.jfk.dismiss();
      this.jpb.jfk = null;
    }
    if (paramn.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramn).KZ();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          localObject = com.tencent.mm.h.a.uU(paramString);
          if (((com.tencent.mm.modelfriend.a)paramn).aHQ() != 1) {
            break label234;
          }
          ae.i("MicroMsg.MobileInputIndepPassLoginLogic", "login check state, sms up");
          if (localObject != null)
          {
            ((com.tencent.mm.h.a)localObject).a(this.jpb, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128318);
                l.b(l.this);
                AppMethodBeat.o(128318);
              }
            }, null);
            AppMethodBeat.o(128326);
            return;
          }
          h.a(this.jpb, this.jpb.getString(2131760761), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128304);
              l.b(l.this);
              AppMethodBeat.o(128304);
            }
          }, null);
        }
      }
    }
    label234:
    while ((paramn.getType() != 252) && (paramn.getType() != 701)) {
      for (;;)
      {
        paramString = com.tencent.mm.h.a.uU(paramString);
        if ((paramString == null) || (this.jpb == null) || (!paramString.a(this.jpb, null, null))) {
          break;
        }
        AppMethodBeat.o(128326);
        return;
        if (localObject != null)
        {
          ((com.tencent.mm.h.a)localObject).a(this.jpb, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128305);
              l.this.jpb.jpt.bxk();
              l.b(l.this, l.this.account);
              AppMethodBeat.o(128305);
            }
          }, null);
          AppMethodBeat.o(128326);
          return;
        }
        this.jpb.jpt.bxk();
        Kw(this.account);
        continue;
        if (i == 16)
        {
          if (paramInt2 == -41)
          {
            this.jpb.jpt.reset();
            h.l(this.jpb, 2131762328, 2131762329);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -75)
          {
            this.jpb.jpt.reset();
            h.c(this.jpb, this.jpb.getString(2131755265), "", true);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -106)
          {
            this.jpb.jpt.reset();
            y.g(this.jpb, paramString, 32045);
            AppMethodBeat.o(128326);
          }
        }
        else if (i == 17)
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            new g(new g.a()
            {
              public final void a(ProgressDialog paramAnonymousProgressDialog)
              {
                l.this.jpb.jfk = ((p)paramAnonymousProgressDialog);
              }
            }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aHM(), this.account).b(this.jpb);
            AppMethodBeat.o(128326);
            return;
          }
          if (n(paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(128326);
            return;
          }
          paramn = com.tencent.mm.h.a.uU(paramString);
          if (paramn != null) {
            paramn.a(this.jpb, null, null);
          }
        }
      }
    }
    this.dLz = ((com.tencent.mm.modelsimple.t)paramn).aLh();
    Object localObject = new f();
    ((f)localObject).jfp = ((com.tencent.mm.modelsimple.t)paramn).aLi();
    ((f)localObject).jfo = ((com.tencent.mm.modelsimple.t)paramn).aLj();
    ((f)localObject).jfq = ((com.tencent.mm.modelsimple.t)paramn).aLk();
    ((f)localObject).joz = ((com.tencent.mm.modelsimple.t)paramn).getSecCodeType();
    ((f)localObject).account = ((com.tencent.mm.modelsimple.t)paramn).account;
    ((f)localObject).jfn = this.jpb.jnE.getText().toString();
    if (paramInt2 == -75)
    {
      y.de(this.jpb);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -106)
    {
      y.g(this.jpb, paramString, 32045);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -217)
    {
      y.a(this.jpb, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramn), paramInt2);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -205)
    {
      this.jlr = ((com.tencent.mm.modelsimple.t)paramn).aHO();
      paramString = ((com.tencent.mm.modelsimple.t)paramn).aLm();
      paramn = ((com.tencent.mm.modelsimple.t)paramn).aLp();
      ae.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bu.aSM(this.jlr), paramn });
      f.a((f)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("auth_ticket", this.jlr);
      ((Intent)localObject).putExtra("binded_mobile", paramString);
      ((Intent)localObject).putExtra("close_safe_device_style", paramn);
      ((Intent)localObject).putExtra("from_source", 6);
      com.tencent.mm.plugin.account.a.a.iUz.g(this.jpb, (Intent)localObject);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -140)
    {
      if (!bu.isNullOrNil(this.dLz)) {
        y.n(this.jpb, paramString, this.dLz);
      }
      AppMethodBeat.o(128326);
      return;
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.ajj().a(new bq(new bq.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(128306);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(128306);
            return;
          }
          paramAnonymouse = paramAnonymouse.aFs();
          com.tencent.mm.kernel.g.ajP();
          int i = com.tencent.mm.kernel.a.getUin();
          paramAnonymouse.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128306);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.jfm == null)
        {
          this.jfm = SecurityImage.a.a(this.jpb, ((f)localObject).joz, ((f)localObject).jfo, ((f)localObject).jfp, ((f)localObject).jfq, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128308);
              ae.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + this.jpp.jfp + " img len" + this.jpp.jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(this.jpp.account, this.jpp.jfn, this.jpp.joz, l.this.jfm.getSecImgCode(), l.this.jfm.getSecImgSid(), l.this.jfm.getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
              MobileInputUI localMobileInputUI1 = l.this.jpb;
              MobileInputUI localMobileInputUI2 = l.this.jpb;
              l.this.jpb.getString(2131755906);
              localMobileInputUI1.jfk = h.b(localMobileInputUI2, l.this.jpb.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128307);
                  com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(128307);
                }
              });
              AppMethodBeat.o(128308);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              l.this.jfm = null;
            }
          }, (SecurityImage.b)localObject);
          AppMethodBeat.o(128326);
          return;
        }
        ae.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + ((f)localObject).jfp + " img len" + ((f)localObject).jfo.length + " " + com.tencent.mm.compatible.util.f.abr());
        this.jfm.b(((f)localObject).joz, ((f)localObject).jfo, ((f)localObject).jfp, ((f)localObject).jfq);
        AppMethodBeat.o(128326);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.g.ajP();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.aTs();
        ae.i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", new Object[] { ((f)localObject).account });
        y.Jv(((f)localObject).account);
        paramString = com.tencent.mm.model.bb.hIK.ay("login_weixin_username", "");
        com.tencent.mm.platformtools.t.cW(this.jpb);
        if (this.jpb.jnn)
        {
          cd.hLa.aP(this.jno, paramString);
          cd.hLa.h(v.aAC(), v.aBv());
          com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), cd.hLa.aCR() });
        }
        y.showAddrBookUploadConfirm(this.jpb, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128309);
            ae.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.a.a.iUz.bE(l.this.jpb);
            ((Intent)localObject).addFlags(67108864);
            MobileInputUI localMobileInputUI = l.this.jpb;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localMobileInputUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localMobileInputUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localMobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            l.this.jpb.finish();
            AppMethodBeat.o(128309);
          }
        }, false, 2);
        if (this.jpb.hJc == 6)
        {
          this.jnm = ((com.tencent.mm.modelsimple.t)paramn).aLr();
          if (((com.tencent.mm.modelsimple.t)paramn).aLl())
          {
            paramString = this.jpb;
            boolean bool = this.jnm;
            paramn = new Intent(paramString, RegByMobileSetPwdUI.class);
            paramn.putExtra("kintent_hint", paramString.getString(2131763302));
            paramn.putExtra("kintent_cancelable", bool);
            paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahE(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)paramn.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/account/ui/MobileInputUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        AppMethodBeat.o(128326);
        return;
      }
      if (n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128326);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break;
      }
      Toast.makeText(this.jpb, this.jpb.getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      break;
      AppMethodBeat.o(128326);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(128321);
    com.tencent.mm.kernel.g.ajj().a(252, this);
    com.tencent.mm.kernel.g.ajj().a(701, this);
    com.tencent.mm.kernel.g.ajj().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.xB("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.KA("L200_100");
    AppMethodBeat.o(128321);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128322);
    com.tencent.mm.kernel.g.ajj().b(701, this);
    com.tencent.mm.kernel.g.ajj().b(252, this);
    com.tencent.mm.kernel.g.ajj().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.xB("L200_100") + ",2");
    AppMethodBeat.o(128322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l
 * JD-Core Version:    0.7.0.1
 */