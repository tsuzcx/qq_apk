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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class l
  implements com.tencent.mm.al.f, MobileInputUI.b
{
  String account;
  private String dKk;
  private String dxJ;
  SecurityImage jct = null;
  private String jiy;
  private boolean jks = true;
  private String jku;
  MobileInputUI jmh;
  
  private void JX(final String paramString)
  {
    AppMethodBeat.i(128324);
    paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
    com.tencent.mm.kernel.g.aiU().a(paramString, 0);
    MobileInputUI localMobileInputUI1 = this.jmh;
    MobileInputUI localMobileInputUI2 = this.jmh;
    this.jmh.getString(2131755906);
    localMobileInputUI1.jcr = h.b(localMobileInputUI2, this.jmh.getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128316);
        com.tencent.mm.kernel.g.aiU().a(paramString);
        AppMethodBeat.o(128316);
      }
    });
    AppMethodBeat.o(128324);
  }
  
  private void aUb()
  {
    AppMethodBeat.i(128320);
    if (this.jmh.hGk == 6)
    {
      this.jmh.jmz.reset();
      this.jmh.jmH.setText(2131760777);
      this.jmh.jlO.setVisibility(8);
      this.jmh.jmz.setVisibility(0);
      this.jmh.jmz.getContentEditText().requestFocus();
      this.jmh.jmz.setSendSmsBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128311);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          l.a(l.this, l.this.account);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128311);
        }
      });
      this.jmh.jmH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128312);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          l.this.jmh.jlo[1] = 2;
          l.this.jmh.hGk = 7;
          l.this.jmh.jmz.reset();
          com.tencent.mm.kernel.g.aiU().b(145, l.this);
          l.a(l.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128312);
        }
      });
      AppMethodBeat.o(128320);
      return;
    }
    if (this.jmh.hGk == 7)
    {
      this.jmh.jmH.setText(2131760778);
      this.jmh.jlO.setVisibility(0);
      this.jmh.jkK.requestFocus();
      this.jmh.jmz.setVisibility(8);
      this.jmh.jmH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128313);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          l.this.jmh.jlo[1] = 1;
          l.this.jmh.hGk = 6;
          com.tencent.mm.kernel.g.aiU().a(145, l.this);
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
    if (bt.isNullOrNil(paramString1))
    {
      h.l(this.jmh, 2131764665, 2131760766);
      AppMethodBeat.o(128325);
      return;
    }
    if (bt.isNullOrNil(paramString2))
    {
      h.l(this.jmh, 2131764658, 2131760766);
      AppMethodBeat.o(128325);
      return;
    }
    this.jmh.jkK.setText(paramString2);
    this.jmh.hideVKB();
    paramString1 = new s(paramString1, paramString2, null, 1);
    com.tencent.mm.kernel.g.aiU().a(paramString1, 0);
    paramString2 = this.jmh;
    MobileInputUI localMobileInputUI = this.jmh;
    this.jmh.getString(2131755906);
    paramString2.jcr = h.b(localMobileInputUI, this.jmh.getString(2131760781), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128317);
        com.tencent.mm.kernel.g.aiU().a(paramString1);
        AppMethodBeat.o(128317);
      }
    });
    AppMethodBeat.o(128325);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128327);
    if (com.tencent.mm.plugin.account.a.a.iRH.a(this.jmh, paramInt1, paramInt2, paramString))
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
      if (com.tencent.mm.kernel.g.aiU().aEN() == 5)
      {
        h.l(this.jmh, 2131761537, 2131761536);
        AppMethodBeat.o(128327);
        return true;
      }
      AppMethodBeat.o(128327);
      return false;
    case -3: 
      h.l(this.jmh, 2131758459, 2131760766);
      AppMethodBeat.o(128327);
      return true;
    case -9: 
      h.l(this.jmh, 2131760765, 2131760766);
      AppMethodBeat.o(128327);
      return true;
    case -100: 
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.kernel.a.hold();
      MobileInputUI localMobileInputUI = this.jmh;
      com.tencent.mm.kernel.g.ajA();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ais())) {}
      for (paramString = com.tencent.mm.cc.a.az(this.jmh, 2131761063);; paramString = com.tencent.mm.kernel.a.ais())
      {
        h.a(localMobileInputUI, paramString, this.jmh.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128327);
        return true;
        com.tencent.mm.kernel.g.ajA();
      }
    case -140: 
      if (!bt.isNullOrNil(this.dKk)) {
        y.n(this.jmh, paramString, this.dKk);
      }
      AppMethodBeat.o(128327);
      return true;
    case -34: 
      Toast.makeText(this.jmh, 2131756462, 0).show();
      AppMethodBeat.o(128327);
      return true;
    case -32: 
      h.a(this.jmh, 2131756510, 2131756514, null);
      AppMethodBeat.o(128327);
      return true;
    }
    h.a(this.jmh, 2131756508, 2131756514, null);
    AppMethodBeat.o(128327);
    return true;
  }
  
  public final void a(final MobileInputUI.a parama)
  {
    AppMethodBeat.i(128323);
    switch (11.jmm[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128323);
      return;
      this.jmh.hideVKB();
      this.jmh.jmK = ba.aQK(this.jmh.countryCode);
      this.jmh.jmL = this.jmh.jmy.getText().toString();
      if ((bt.isNullOrNil(this.jmh.jmK)) || (bt.isNullOrNil(this.jmh.jmL)))
      {
        AppMethodBeat.o(128323);
        return;
      }
      if (this.jmh.hGk == 7)
      {
        if (!bt.isNullOrNil(this.dxJ))
        {
          bT(this.account, this.dxJ);
          AppMethodBeat.o(128323);
          return;
        }
        bT(this.account, this.jmh.jkK.getText().toString());
        AppMethodBeat.o(128323);
        return;
      }
      if (this.jmh.hGk == 6)
      {
        parama = this.jmh.jmz.getText().toString().trim();
        if (bt.isNullOrNil(parama))
        {
          h.l(this.jmh, 2131764664, 2131760766);
          AppMethodBeat.o(128323);
          return;
        }
        this.jmh.hideVKB();
        parama = new com.tencent.mm.modelfriend.a(this.account, 17, parama, 0, "");
        com.tencent.mm.kernel.g.aiU().a(parama, 0);
        MobileInputUI localMobileInputUI1 = this.jmh;
        MobileInputUI localMobileInputUI2 = this.jmh;
        this.jmh.getString(2131755906);
        localMobileInputUI1.jcr = h.b(localMobileInputUI2, this.jmh.getString(2131756503), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128315);
            com.tencent.mm.kernel.g.aiU().a(parama);
            AppMethodBeat.o(128315);
          }
        });
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128319);
    this.jmh = paramMobileInputUI;
    paramMobileInputUI.jmF.setVisibility(0);
    this.account = paramMobileInputUI.getIntent().getStringExtra("binded_mobile");
    if (bt.isNullOrNil(this.account)) {
      this.account = ba.aQI(paramMobileInputUI.jmK + paramMobileInputUI.jmL);
    }
    paramMobileInputUI.jmy.setTextColor(paramMobileInputUI.getResources().getColor(2131100490));
    paramMobileInputUI.jmy.setEnabled(false);
    paramMobileInputUI.jmy.setFocusable(false);
    paramMobileInputUI.jmx.setFocusable(false);
    paramMobileInputUI.jmx.setText(ba.aQI(this.account));
    paramMobileInputUI.jmx.setVisibility(0);
    aUb();
    paramMobileInputUI.jmH.setVisibility(0);
    paramMobileInputUI.jmD.setText(2131760774);
    paramMobileInputUI.jmD.setVisibility(0);
    paramMobileInputUI.jmD.setEnabled(true);
    this.jku = az.hFS.ax("login_weixin_username", "");
    this.jiy = paramMobileInputUI.getIntent().getStringExtra("auth_ticket");
    if (!bt.isNullOrNil(this.jiy)) {
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128303);
          l.a(l.this, f.aTY(), f.aTZ());
          AppMethodBeat.o(128303);
        }
      }, 500L);
    }
    AppMethodBeat.o(128319);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128326);
    ad.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jmh.jcr != null)
    {
      this.jmh.jcr.dismiss();
      this.jmh.jcr = null;
    }
    if (paramn.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramn).KR();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          localObject = com.tencent.mm.h.a.uz(paramString);
          if (((com.tencent.mm.modelfriend.a)paramn).aHz() != 1) {
            break label234;
          }
          ad.i("MicroMsg.MobileInputIndepPassLoginLogic", "login check state, sms up");
          if (localObject != null)
          {
            ((com.tencent.mm.h.a)localObject).a(this.jmh, new DialogInterface.OnClickListener()
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
          h.a(this.jmh, this.jmh.getString(2131760761), "", new DialogInterface.OnClickListener()
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
        paramString = com.tencent.mm.h.a.uz(paramString);
        if ((paramString == null) || (this.jmh == null) || (!paramString.a(this.jmh, null, null))) {
          break;
        }
        AppMethodBeat.o(128326);
        return;
        if (localObject != null)
        {
          ((com.tencent.mm.h.a)localObject).a(this.jmh, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128305);
              l.this.jmh.jmz.bwt();
              l.b(l.this, l.this.account);
              AppMethodBeat.o(128305);
            }
          }, null);
          AppMethodBeat.o(128326);
          return;
        }
        this.jmh.jmz.bwt();
        JX(this.account);
        continue;
        if (i == 16)
        {
          if (paramInt2 == -41)
          {
            this.jmh.jmz.reset();
            h.l(this.jmh, 2131762328, 2131762329);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -75)
          {
            this.jmh.jmz.reset();
            h.c(this.jmh, this.jmh.getString(2131755265), "", true);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -106)
          {
            this.jmh.jmz.reset();
            y.g(this.jmh, paramString, 32045);
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
                l.this.jmh.jcr = ((p)paramAnonymousProgressDialog);
              }
            }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aHv(), this.account).b(this.jmh);
            AppMethodBeat.o(128326);
            return;
          }
          if (n(paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(128326);
            return;
          }
          paramn = com.tencent.mm.h.a.uz(paramString);
          if (paramn != null) {
            paramn.a(this.jmh, null, null);
          }
        }
      }
    }
    this.dKk = ((s)paramn).aKK();
    Object localObject = new f();
    ((f)localObject).jcw = ((s)paramn).aKL();
    ((f)localObject).jcv = ((s)paramn).aKM();
    ((f)localObject).jcx = ((s)paramn).aKN();
    ((f)localObject).jlF = ((s)paramn).getSecCodeType();
    ((f)localObject).account = ((s)paramn).account;
    ((f)localObject).jcu = this.jmh.jkK.getText().toString();
    if (paramInt2 == -75)
    {
      y.dc(this.jmh);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -106)
    {
      y.g(this.jmh, paramString, 32045);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -217)
    {
      y.a(this.jmh, com.tencent.mm.platformtools.e.a((s)paramn), paramInt2);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -205)
    {
      this.jiy = ((s)paramn).aHx();
      paramString = ((s)paramn).aKP();
      paramn = ((s)paramn).aKS();
      ad.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bt.aRp(this.jiy), paramn });
      f.a((f)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("auth_ticket", this.jiy);
      ((Intent)localObject).putExtra("binded_mobile", paramString);
      ((Intent)localObject).putExtra("close_safe_device_style", paramn);
      ((Intent)localObject).putExtra("from_source", 6);
      com.tencent.mm.plugin.account.a.a.iRG.g(this.jmh, (Intent)localObject);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -140)
    {
      if (!bt.isNullOrNil(this.dKk)) {
        y.n(this.jmh, paramString, this.dKk);
      }
      AppMethodBeat.o(128326);
      return;
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.aiU().a(new bo(new bo.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(128306);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(128306);
            return;
          }
          paramAnonymouse = paramAnonymouse.aFc();
          com.tencent.mm.kernel.g.ajA();
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
        if (this.jct == null)
        {
          this.jct = SecurityImage.a.a(this.jmh, ((f)localObject).jlF, ((f)localObject).jcv, ((f)localObject).jcw, ((f)localObject).jcx, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128308);
              ad.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + this.jmv.jcw + " img len" + this.jmv.jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
              paramAnonymousDialogInterface = new s(this.jmv.account, this.jmv.jcu, this.jmv.jlF, l.this.jct.getSecImgCode(), l.this.jct.getSecImgSid(), l.this.jct.getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
              MobileInputUI localMobileInputUI1 = l.this.jmh;
              MobileInputUI localMobileInputUI2 = l.this.jmh;
              l.this.jmh.getString(2131755906);
              localMobileInputUI1.jcr = h.b(localMobileInputUI2, l.this.jmh.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128307);
                  com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(128307);
                }
              });
              AppMethodBeat.o(128308);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              l.this.jct = null;
            }
          }, (SecurityImage.b)localObject);
          AppMethodBeat.o(128326);
          return;
        }
        ad.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + ((f)localObject).jcw + " img len" + ((f)localObject).jcv.length + " " + com.tencent.mm.compatible.util.f.abi());
        this.jct.b(((f)localObject).jlF, ((f)localObject).jcv, ((f)localObject).jcw, ((f)localObject).jcx);
        AppMethodBeat.o(128326);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.g.ajA();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.aST();
        ad.i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", new Object[] { ((f)localObject).account });
        y.IW(((f)localObject).account);
        paramString = az.hFS.ax("login_weixin_username", "");
        t.cU(this.jmh);
        if (this.jmh.jkt)
        {
          cb.hIi.aP(this.jku, paramString);
          cb.hIi.g(u.aAm(), u.aBf());
          com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), cb.hIi.aCB() });
        }
        y.showAddrBookUploadConfirm(this.jmh, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128309);
            ad.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.a.a.iRG.bC(l.this.jmh);
            ((Intent)localObject).addFlags(67108864);
            MobileInputUI localMobileInputUI = l.this.jmh;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localMobileInputUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localMobileInputUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localMobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            l.this.jmh.finish();
            AppMethodBeat.o(128309);
          }
        }, false, 2);
        if (this.jmh.hGk == 6)
        {
          this.jks = ((s)paramn).aKU();
          if (((s)paramn).aKO())
          {
            paramString = this.jmh;
            boolean bool = this.jks;
            paramn = new Intent(paramString, RegByMobileSetPwdUI.class);
            paramn.putExtra("kintent_hint", paramString.getString(2131763302));
            paramn.putExtra("kintent_cancelable", bool);
            paramn = new com.tencent.mm.hellhoundlib.b.a().bc(paramn);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.ahp(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)paramn.mq(0));
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
      Toast.makeText(this.jmh, this.jmh.getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      break;
      AppMethodBeat.o(128326);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(128321);
    com.tencent.mm.kernel.g.aiU().a(252, this);
    com.tencent.mm.kernel.g.aiU().a(701, this);
    com.tencent.mm.kernel.g.aiU().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(true, com.tencent.mm.kernel.a.wS("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.Kc("L200_100");
    AppMethodBeat.o(128321);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128322);
    com.tencent.mm.kernel.g.aiU().b(701, this);
    com.tencent.mm.kernel.g.aiU().b(252, this);
    com.tencent.mm.kernel.g.aiU().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.ajA();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.plugin.b.a.i(false, com.tencent.mm.kernel.a.wS("L200_100") + ",2");
    AppMethodBeat.o(128322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l
 * JD-Core Version:    0.7.0.1
 */