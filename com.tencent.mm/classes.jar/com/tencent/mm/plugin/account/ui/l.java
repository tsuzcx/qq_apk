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
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.network.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.p;

public final class l
  implements com.tencent.mm.al.g, MobileInputUI.b
{
  String account;
  private String dAl;
  private String dom;
  SecurityImage ijd = null;
  private String ipj;
  private boolean ire = true;
  private String irg;
  MobileInputUI isU;
  
  private void CF(final String paramString)
  {
    AppMethodBeat.i(128324);
    paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
    com.tencent.mm.kernel.g.aeS().a(paramString, 0);
    MobileInputUI localMobileInputUI1 = this.isU;
    MobileInputUI localMobileInputUI2 = this.isU;
    this.isU.getString(2131755906);
    localMobileInputUI1.ijb = com.tencent.mm.ui.base.h.b(localMobileInputUI2, this.isU.getString(2131755936), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128316);
        com.tencent.mm.kernel.g.aeS().a(paramString);
        AppMethodBeat.o(128316);
      }
    });
    AppMethodBeat.o(128324);
  }
  
  private void aJY()
  {
    AppMethodBeat.i(128320);
    if (this.isU.gNs == 6)
    {
      this.isU.itm.reset();
      this.isU.itu.setText(2131760777);
      this.isU.isB.setVisibility(8);
      this.isU.itm.setVisibility(0);
      this.isU.itm.getContentEditText().requestFocus();
      this.isU.itm.setSendSmsBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128311);
          l.a(l.this, l.this.account);
          AppMethodBeat.o(128311);
        }
      });
      this.isU.itu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128312);
          l.this.isU.isb[1] = 2;
          l.this.isU.gNs = 7;
          l.this.isU.itm.reset();
          com.tencent.mm.kernel.g.aeS().b(145, l.this);
          l.a(l.this);
          AppMethodBeat.o(128312);
        }
      });
      AppMethodBeat.o(128320);
      return;
    }
    if (this.isU.gNs == 7)
    {
      this.isU.itu.setText(2131760778);
      this.isU.isB.setVisibility(0);
      this.isU.irx.requestFocus();
      this.isU.itm.setVisibility(8);
      this.isU.itu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128313);
          l.this.isU.isb[1] = 1;
          l.this.isU.gNs = 6;
          com.tencent.mm.kernel.g.aeS().a(145, l.this);
          l.a(l.this);
          AppMethodBeat.o(128313);
        }
      });
    }
    AppMethodBeat.o(128320);
  }
  
  private void bJ(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(128325);
    if (bt.isNullOrNil(paramString1))
    {
      com.tencent.mm.ui.base.h.j(this.isU, 2131764665, 2131760766);
      AppMethodBeat.o(128325);
      return;
    }
    if (bt.isNullOrNil(paramString2))
    {
      com.tencent.mm.ui.base.h.j(this.isU, 2131764658, 2131760766);
      AppMethodBeat.o(128325);
      return;
    }
    this.isU.irx.setText(paramString2);
    this.isU.hideVKB();
    paramString1 = new s(paramString1, paramString2, null, 1);
    com.tencent.mm.kernel.g.aeS().a(paramString1, 0);
    paramString2 = this.isU;
    MobileInputUI localMobileInputUI = this.isU;
    this.isU.getString(2131755906);
    paramString2.ijb = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.isU.getString(2131760781), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128317);
        com.tencent.mm.kernel.g.aeS().a(paramString1);
        AppMethodBeat.o(128317);
      }
    });
    AppMethodBeat.o(128325);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128327);
    if (com.tencent.mm.plugin.account.a.a.hYu.a(this.isU, paramInt1, paramInt2, paramString))
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
      if (com.tencent.mm.kernel.g.aeS().auR() == 5)
      {
        com.tencent.mm.ui.base.h.j(this.isU, 2131761537, 2131761536);
        AppMethodBeat.o(128327);
        return true;
      }
      AppMethodBeat.o(128327);
      return false;
    case -3: 
      com.tencent.mm.ui.base.h.j(this.isU, 2131758459, 2131760766);
      AppMethodBeat.o(128327);
      return true;
    case -9: 
      com.tencent.mm.ui.base.h.j(this.isU, 2131760765, 2131760766);
      AppMethodBeat.o(128327);
      return true;
    case -100: 
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.kernel.a.hold();
      MobileInputUI localMobileInputUI = this.isU;
      com.tencent.mm.kernel.g.afz();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.aeq())) {}
      for (paramString = com.tencent.mm.cd.a.aq(this.isU, 2131761063);; paramString = com.tencent.mm.kernel.a.aeq())
      {
        com.tencent.mm.ui.base.h.a(localMobileInputUI, paramString, this.isU.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128327);
        return true;
        com.tencent.mm.kernel.g.afz();
      }
    case -140: 
      if (!bt.isNullOrNil(this.dAl)) {
        y.m(this.isU, paramString, this.dAl);
      }
      AppMethodBeat.o(128327);
      return true;
    case -34: 
      Toast.makeText(this.isU, 2131756462, 0).show();
      AppMethodBeat.o(128327);
      return true;
    case -32: 
      com.tencent.mm.ui.base.h.a(this.isU, 2131756510, 2131756514, null);
      AppMethodBeat.o(128327);
      return true;
    }
    com.tencent.mm.ui.base.h.a(this.isU, 2131756508, 2131756514, null);
    AppMethodBeat.o(128327);
    return true;
  }
  
  public final void a(final MobileInputUI.a parama)
  {
    AppMethodBeat.i(128323);
    switch (11.isZ[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128323);
      return;
      this.isU.hideVKB();
      this.isU.itx = ba.aFN(this.isU.countryCode);
      this.isU.ity = this.isU.itl.getText().toString();
      if ((bt.isNullOrNil(this.isU.itx)) || (bt.isNullOrNil(this.isU.ity)))
      {
        AppMethodBeat.o(128323);
        return;
      }
      if (this.isU.gNs == 7)
      {
        if (!bt.isNullOrNil(this.dom))
        {
          bJ(this.account, this.dom);
          AppMethodBeat.o(128323);
          return;
        }
        bJ(this.account, this.isU.irx.getText().toString());
        AppMethodBeat.o(128323);
        return;
      }
      if (this.isU.gNs == 6)
      {
        parama = this.isU.itm.getText().toString().trim();
        if (bt.isNullOrNil(parama))
        {
          com.tencent.mm.ui.base.h.j(this.isU, 2131764664, 2131760766);
          AppMethodBeat.o(128323);
          return;
        }
        this.isU.hideVKB();
        parama = new com.tencent.mm.modelfriend.a(this.account, 17, parama, 0, "");
        com.tencent.mm.kernel.g.aeS().a(parama, 0);
        MobileInputUI localMobileInputUI1 = this.isU;
        MobileInputUI localMobileInputUI2 = this.isU;
        this.isU.getString(2131755906);
        localMobileInputUI1.ijb = com.tencent.mm.ui.base.h.b(localMobileInputUI2, this.isU.getString(2131756503), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128315);
            com.tencent.mm.kernel.g.aeS().a(parama);
            AppMethodBeat.o(128315);
          }
        });
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128319);
    this.isU = paramMobileInputUI;
    paramMobileInputUI.its.setVisibility(0);
    this.account = paramMobileInputUI.getIntent().getStringExtra("binded_mobile");
    if (bt.isNullOrNil(this.account)) {
      this.account = ba.aFL(paramMobileInputUI.itx + paramMobileInputUI.ity);
    }
    paramMobileInputUI.itl.setTextColor(paramMobileInputUI.getResources().getColor(2131100490));
    paramMobileInputUI.itl.setEnabled(false);
    paramMobileInputUI.itl.setFocusable(false);
    paramMobileInputUI.itk.setFocusable(false);
    paramMobileInputUI.itk.setText(ba.aFL(this.account));
    paramMobileInputUI.itk.setVisibility(0);
    aJY();
    paramMobileInputUI.itu.setVisibility(0);
    paramMobileInputUI.itq.setText(2131760774);
    paramMobileInputUI.itq.setVisibility(0);
    paramMobileInputUI.itq.setEnabled(true);
    this.irg = ay.gNa.ao("login_weixin_username", "");
    this.ipj = paramMobileInputUI.getIntent().getStringExtra("auth_ticket");
    if (!bt.isNullOrNil(this.ipj)) {
      new ap().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128303);
          l.a(l.this, f.aJV(), f.aJW());
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
    if (this.isU.ijb != null)
    {
      this.isU.ijb.dismiss();
      this.isU.ijb = null;
    }
    if (paramn.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramn).JJ();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          localObject = com.tencent.mm.h.a.oG(paramString);
          if (((com.tencent.mm.modelfriend.a)paramn).axC() != 1) {
            break label234;
          }
          ad.i("MicroMsg.MobileInputIndepPassLoginLogic", "login check state, sms up");
          if (localObject != null)
          {
            ((com.tencent.mm.h.a)localObject).a(this.isU, new DialogInterface.OnClickListener()
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
          com.tencent.mm.ui.base.h.a(this.isU, this.isU.getString(2131760761), "", new DialogInterface.OnClickListener()
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
        paramString = com.tencent.mm.h.a.oG(paramString);
        if ((paramString == null) || (this.isU == null) || (!paramString.a(this.isU, null, null))) {
          break;
        }
        AppMethodBeat.o(128326);
        return;
        if (localObject != null)
        {
          ((com.tencent.mm.h.a)localObject).a(this.isU, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128305);
              l.this.isU.itm.blz();
              l.b(l.this, l.this.account);
              AppMethodBeat.o(128305);
            }
          }, null);
          AppMethodBeat.o(128326);
          return;
        }
        this.isU.itm.blz();
        CF(this.account);
        continue;
        if (i == 16)
        {
          if (paramInt2 == -41)
          {
            this.isU.itm.reset();
            com.tencent.mm.ui.base.h.j(this.isU, 2131762328, 2131762329);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -75)
          {
            this.isU.itm.reset();
            com.tencent.mm.ui.base.h.c(this.isU, this.isU.getString(2131755265), "", true);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -106)
          {
            this.isU.itm.reset();
            y.g(this.isU, paramString, 32045);
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
                l.this.isU.ijb = ((p)paramAnonymousProgressDialog);
              }
            }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).axy(), this.account).a(this.isU);
            AppMethodBeat.o(128326);
            return;
          }
          if (n(paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(128326);
            return;
          }
          paramn = com.tencent.mm.h.a.oG(paramString);
          if (paramn != null) {
            paramn.a(this.isU, null, null);
          }
        }
      }
    }
    this.dAl = ((s)paramn).aAJ();
    Object localObject = new f();
    ((f)localObject).ijg = ((s)paramn).aAK();
    ((f)localObject).ijf = ((s)paramn).aAL();
    ((f)localObject).ijh = ((s)paramn).aAM();
    ((f)localObject).iss = ((s)paramn).getSecCodeType();
    ((f)localObject).account = ((s)paramn).account;
    ((f)localObject).ije = this.isU.irx.getText().toString();
    if (paramInt2 == -75)
    {
      y.cV(this.isU);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -106)
    {
      y.g(this.isU, paramString, 32045);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -217)
    {
      y.a(this.isU, com.tencent.mm.platformtools.e.a((s)paramn), paramInt2);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -205)
    {
      this.ipj = ((s)paramn).axA();
      paramString = ((s)paramn).aAO();
      paramn = ((s)paramn).aAR();
      ad.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bt.aGs(this.ipj), paramn });
      f.a((f)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("auth_ticket", this.ipj);
      ((Intent)localObject).putExtra("binded_mobile", paramString);
      ((Intent)localObject).putExtra("close_safe_device_style", paramn);
      ((Intent)localObject).putExtra("from_source", 6);
      com.tencent.mm.plugin.account.a.a.hYt.g(this.isU, (Intent)localObject);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -140)
    {
      if (!bt.isNullOrNil(this.dAl)) {
        y.m(this.isU, paramString, this.dAl);
      }
      AppMethodBeat.o(128326);
      return;
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.aeS().a(new bn(new bn.a()
      {
        public final void a(com.tencent.mm.network.e paramAnonymouse)
        {
          AppMethodBeat.i(128306);
          if (paramAnonymouse == null)
          {
            AppMethodBeat.o(128306);
            return;
          }
          paramAnonymouse = paramAnonymouse.avg();
          com.tencent.mm.kernel.g.afz();
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
        if (this.ijd == null)
        {
          this.ijd = SecurityImage.a.a(this.isU, ((f)localObject).iss, ((f)localObject).ijf, ((f)localObject).ijg, ((f)localObject).ijh, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128308);
              ad.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + this.iti.ijg + " img len" + this.iti.ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
              paramAnonymousDialogInterface = new s(this.iti.account, this.iti.ije, this.iti.iss, l.this.ijd.getSecImgCode(), l.this.ijd.getSecImgSid(), l.this.ijd.getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface, 0);
              MobileInputUI localMobileInputUI1 = l.this.isU;
              MobileInputUI localMobileInputUI2 = l.this.isU;
              l.this.isU.getString(2131755906);
              localMobileInputUI1.ijb = com.tencent.mm.ui.base.h.b(localMobileInputUI2, l.this.isU.getString(2131760781), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128307);
                  com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(128307);
                }
              });
              AppMethodBeat.o(128308);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              l.this.ijd = null;
            }
          }, (SecurityImage.b)localObject);
          AppMethodBeat.o(128326);
          return;
        }
        ad.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + ((f)localObject).ijg + " img len" + ((f)localObject).ijf.length + " " + com.tencent.mm.compatible.util.f.XJ());
        this.ijd.b(((f)localObject).iss, ((f)localObject).ijf, ((f)localObject).ijg, ((f)localObject).ijh);
        AppMethodBeat.o(128326);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.g.afz();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.aIQ();
        ad.i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", new Object[] { ((f)localObject).account });
        y.BD(((f)localObject).account);
        paramString = ay.gNa.ao("login_weixin_username", "");
        t.cN(this.isU);
        if (this.isU.irf)
        {
          ca.gPq.aG(this.irg, paramString);
          ca.gPq.f(u.aqG(), u.arp());
          com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), ca.gPq.asH() });
        }
        y.showAddrBookUploadConfirm(this.isU, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128309);
            ad.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.a.a.hYt.bA(l.this.isU);
            ((Intent)localObject).addFlags(67108864);
            MobileInputUI localMobileInputUI = l.this.isU;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localMobileInputUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localMobileInputUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localMobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            l.this.isU.finish();
            AppMethodBeat.o(128309);
          }
        }, false, 2);
        if (this.isU.gNs == 6)
        {
          this.ire = ((s)paramn).aAT();
          if (((s)paramn).aAN())
          {
            paramString = this.isU;
            boolean bool = this.ire;
            paramn = new Intent(paramString, RegByMobileSetPwdUI.class);
            paramn.putExtra("kintent_hint", paramString.getString(2131763302));
            paramn.putExtra("kintent_cancelable", bool);
            paramn = new com.tencent.mm.hellhoundlib.b.a().bd(paramn);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.adn(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)paramn.lS(0));
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
      Toast.makeText(this.isU, this.isU.getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      break;
      AppMethodBeat.o(128326);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(128321);
    com.tencent.mm.kernel.g.aeS().a(252, this);
    com.tencent.mm.kernel.g.aeS().a(701, this);
    com.tencent.mm.kernel.g.aeS().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(true, com.tencent.mm.kernel.a.qN("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.aUy("L200_100");
    AppMethodBeat.o(128321);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128322);
    com.tencent.mm.kernel.g.aeS().b(701, this);
    com.tencent.mm.kernel.g.aeS().b(252, this);
    com.tencent.mm.kernel.g.aeS().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.afz();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.plugin.b.a.K(false, com.tencent.mm.kernel.a.qN("L200_100") + ",2");
    AppMethodBeat.o(128322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l
 * JD-Core Version:    0.7.0.1
 */