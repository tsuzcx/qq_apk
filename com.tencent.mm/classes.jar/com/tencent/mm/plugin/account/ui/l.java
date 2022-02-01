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
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.p;

public final class l
  implements com.tencent.mm.ak.g, MobileInputUI.b
{
  String account;
  private String dlV;
  private String dxX;
  SecurityImage iJk = null;
  private String iPp;
  private boolean iRk = true;
  private String iRm;
  MobileInputUI iSZ;
  
  private void GI(String paramString)
  {
    AppMethodBeat.i(128324);
    paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
    com.tencent.mm.kernel.g.agi().a(paramString, 0);
    MobileInputUI localMobileInputUI1 = this.iSZ;
    MobileInputUI localMobileInputUI2 = this.iSZ;
    this.iSZ.getString(2131755906);
    localMobileInputUI1.iJi = com.tencent.mm.ui.base.h.b(localMobileInputUI2, this.iSZ.getString(2131755936), true, new l.17(this, paramString));
    AppMethodBeat.o(128324);
  }
  
  private void aQP()
  {
    AppMethodBeat.i(128320);
    if (this.iSZ.hnS == 6)
    {
      this.iSZ.iTr.reset();
      this.iSZ.iTz.setText(2131760777);
      this.iSZ.iSG.setVisibility(8);
      this.iSZ.iTr.setVisibility(0);
      this.iSZ.iTr.getContentEditText().requestFocus();
      this.iSZ.iTr.setSendSmsBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128311);
          l.a(l.this, l.this.account);
          AppMethodBeat.o(128311);
        }
      });
      this.iSZ.iTz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128312);
          l.this.iSZ.iSg[1] = 2;
          l.this.iSZ.hnS = 7;
          l.this.iSZ.iTr.reset();
          com.tencent.mm.kernel.g.agi().b(145, l.this);
          l.a(l.this);
          AppMethodBeat.o(128312);
        }
      });
      AppMethodBeat.o(128320);
      return;
    }
    if (this.iSZ.hnS == 7)
    {
      this.iSZ.iTz.setText(2131760778);
      this.iSZ.iSG.setVisibility(0);
      this.iSZ.iRC.requestFocus();
      this.iSZ.iTr.setVisibility(8);
      this.iSZ.iTz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128313);
          l.this.iSZ.iSg[1] = 1;
          l.this.iSZ.hnS = 6;
          com.tencent.mm.kernel.g.agi().a(145, l.this);
          l.a(l.this);
          AppMethodBeat.o(128313);
        }
      });
    }
    AppMethodBeat.o(128320);
  }
  
  private void bR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128325);
    if (bs.isNullOrNil(paramString1))
    {
      com.tencent.mm.ui.base.h.l(this.iSZ, 2131764665, 2131760766);
      AppMethodBeat.o(128325);
      return;
    }
    if (bs.isNullOrNil(paramString2))
    {
      com.tencent.mm.ui.base.h.l(this.iSZ, 2131764658, 2131760766);
      AppMethodBeat.o(128325);
      return;
    }
    this.iSZ.iRC.setText(paramString2);
    this.iSZ.hideVKB();
    paramString1 = new s(paramString1, paramString2, null, 1);
    com.tencent.mm.kernel.g.agi().a(paramString1, 0);
    paramString2 = this.iSZ;
    MobileInputUI localMobileInputUI = this.iSZ;
    this.iSZ.getString(2131755906);
    paramString2.iJi = com.tencent.mm.ui.base.h.b(localMobileInputUI, this.iSZ.getString(2131760781), true, new l.18(this, paramString1));
    AppMethodBeat.o(128325);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128327);
    if (com.tencent.mm.plugin.account.a.a.iyy.a(this.iSZ, paramInt1, paramInt2, paramString))
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
      if (com.tencent.mm.kernel.g.agi().aBK() == 5)
      {
        com.tencent.mm.ui.base.h.l(this.iSZ, 2131761537, 2131761536);
        AppMethodBeat.o(128327);
        return true;
      }
      AppMethodBeat.o(128327);
      return false;
    case -3: 
      com.tencent.mm.ui.base.h.l(this.iSZ, 2131758459, 2131760766);
      AppMethodBeat.o(128327);
      return true;
    case -9: 
      com.tencent.mm.ui.base.h.l(this.iSZ, 2131760765, 2131760766);
      AppMethodBeat.o(128327);
      return true;
    case -100: 
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.kernel.a.hold();
      MobileInputUI localMobileInputUI = this.iSZ;
      com.tencent.mm.kernel.g.agP();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.afG())) {}
      for (paramString = com.tencent.mm.cc.a.aw(this.iSZ, 2131761063);; paramString = com.tencent.mm.kernel.a.afG())
      {
        com.tencent.mm.ui.base.h.a(localMobileInputUI, paramString, this.iSZ.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128327);
        return true;
        com.tencent.mm.kernel.g.agP();
      }
    case -140: 
      if (!bs.isNullOrNil(this.dxX)) {
        y.m(this.iSZ, paramString, this.dxX);
      }
      AppMethodBeat.o(128327);
      return true;
    case -34: 
      Toast.makeText(this.iSZ, 2131756462, 0).show();
      AppMethodBeat.o(128327);
      return true;
    case -32: 
      com.tencent.mm.ui.base.h.a(this.iSZ, 2131756510, 2131756514, null);
      AppMethodBeat.o(128327);
      return true;
    }
    com.tencent.mm.ui.base.h.a(this.iSZ, 2131756508, 2131756514, null);
    AppMethodBeat.o(128327);
    return true;
  }
  
  public final void a(MobileInputUI.a parama)
  {
    AppMethodBeat.i(128323);
    switch (11.iTe[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128323);
      return;
      this.iSZ.hideVKB();
      this.iSZ.iTC = az.aLe(this.iSZ.countryCode);
      this.iSZ.iTD = this.iSZ.iTq.getText().toString();
      if ((bs.isNullOrNil(this.iSZ.iTC)) || (bs.isNullOrNil(this.iSZ.iTD)))
      {
        AppMethodBeat.o(128323);
        return;
      }
      if (this.iSZ.hnS == 7)
      {
        if (!bs.isNullOrNil(this.dlV))
        {
          bR(this.account, this.dlV);
          AppMethodBeat.o(128323);
          return;
        }
        bR(this.account, this.iSZ.iRC.getText().toString());
        AppMethodBeat.o(128323);
        return;
      }
      if (this.iSZ.hnS == 6)
      {
        parama = this.iSZ.iTr.getText().toString().trim();
        if (bs.isNullOrNil(parama))
        {
          com.tencent.mm.ui.base.h.l(this.iSZ, 2131764664, 2131760766);
          AppMethodBeat.o(128323);
          return;
        }
        this.iSZ.hideVKB();
        parama = new com.tencent.mm.modelfriend.a(this.account, 17, parama, 0, "");
        com.tencent.mm.kernel.g.agi().a(parama, 0);
        MobileInputUI localMobileInputUI1 = this.iSZ;
        MobileInputUI localMobileInputUI2 = this.iSZ;
        this.iSZ.getString(2131755906);
        localMobileInputUI1.iJi = com.tencent.mm.ui.base.h.b(localMobileInputUI2, this.iSZ.getString(2131756503), true, new l.16(this, parama));
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128319);
    this.iSZ = paramMobileInputUI;
    paramMobileInputUI.iTx.setVisibility(0);
    this.account = paramMobileInputUI.getIntent().getStringExtra("binded_mobile");
    if (bs.isNullOrNil(this.account)) {
      this.account = az.aLc(paramMobileInputUI.iTC + paramMobileInputUI.iTD);
    }
    paramMobileInputUI.iTq.setTextColor(paramMobileInputUI.getResources().getColor(2131100490));
    paramMobileInputUI.iTq.setEnabled(false);
    paramMobileInputUI.iTq.setFocusable(false);
    paramMobileInputUI.iTp.setFocusable(false);
    paramMobileInputUI.iTp.setText(az.aLc(this.account));
    paramMobileInputUI.iTp.setVisibility(0);
    aQP();
    paramMobileInputUI.iTz.setVisibility(0);
    paramMobileInputUI.iTv.setText(2131760774);
    paramMobileInputUI.iTv.setVisibility(0);
    paramMobileInputUI.iTv.setEnabled(true);
    this.iRm = ay.hnA.aw("login_weixin_username", "");
    this.iPp = paramMobileInputUI.getIntent().getStringExtra("auth_ticket");
    if (!bs.isNullOrNil(this.iPp)) {
      new ao().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128303);
          l.a(l.this, f.aQM(), f.aQN());
          AppMethodBeat.o(128303);
        }
      }, 500L);
    }
    AppMethodBeat.o(128319);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128326);
    ac.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iSZ.iJi != null)
    {
      this.iSZ.iJi.dismiss();
      this.iSZ.iJi = null;
    }
    if (paramn.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramn).Js();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          localObject = com.tencent.mm.h.a.rM(paramString);
          if (((com.tencent.mm.modelfriend.a)paramn).aEu() != 1) {
            break label234;
          }
          ac.i("MicroMsg.MobileInputIndepPassLoginLogic", "login check state, sms up");
          if (localObject != null)
          {
            ((com.tencent.mm.h.a)localObject).a(this.iSZ, new DialogInterface.OnClickListener()
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
          com.tencent.mm.ui.base.h.a(this.iSZ, this.iSZ.getString(2131760761), "", new DialogInterface.OnClickListener()
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
        paramString = com.tencent.mm.h.a.rM(paramString);
        if ((paramString == null) || (this.iSZ == null) || (!paramString.a(this.iSZ, null, null))) {
          break;
        }
        AppMethodBeat.o(128326);
        return;
        if (localObject != null)
        {
          ((com.tencent.mm.h.a)localObject).a(this.iSZ, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128305);
              l.this.iSZ.iTr.bso();
              l.b(l.this, l.this.account);
              AppMethodBeat.o(128305);
            }
          }, null);
          AppMethodBeat.o(128326);
          return;
        }
        this.iSZ.iTr.bso();
        GI(this.account);
        continue;
        if (i == 16)
        {
          if (paramInt2 == -41)
          {
            this.iSZ.iTr.reset();
            com.tencent.mm.ui.base.h.l(this.iSZ, 2131762328, 2131762329);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -75)
          {
            this.iSZ.iTr.reset();
            com.tencent.mm.ui.base.h.c(this.iSZ, this.iSZ.getString(2131755265), "", true);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -106)
          {
            this.iSZ.iTr.reset();
            y.g(this.iSZ, paramString, 32045);
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
                l.this.iSZ.iJi = ((p)paramAnonymousProgressDialog);
              }
            }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aEq(), this.account).a(this.iSZ);
            AppMethodBeat.o(128326);
            return;
          }
          if (n(paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(128326);
            return;
          }
          paramn = com.tencent.mm.h.a.rM(paramString);
          if (paramn != null) {
            paramn.a(this.iSZ, null, null);
          }
        }
      }
    }
    this.dxX = ((s)paramn).aHz();
    Object localObject = new f();
    ((f)localObject).iJn = ((s)paramn).aHA();
    ((f)localObject).iJm = ((s)paramn).aHB();
    ((f)localObject).iJo = ((s)paramn).aHC();
    ((f)localObject).iSx = ((s)paramn).getSecCodeType();
    ((f)localObject).account = ((s)paramn).account;
    ((f)localObject).iJl = this.iSZ.iRC.getText().toString();
    if (paramInt2 == -75)
    {
      y.de(this.iSZ);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -106)
    {
      y.g(this.iSZ, paramString, 32045);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -217)
    {
      y.a(this.iSZ, e.a((s)paramn), paramInt2);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -205)
    {
      this.iPp = ((s)paramn).aEs();
      paramString = ((s)paramn).aHE();
      paramn = ((s)paramn).aHH();
      ac.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { bs.aLJ(this.iPp), paramn });
      f.a((f)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("auth_ticket", this.iPp);
      ((Intent)localObject).putExtra("binded_mobile", paramString);
      ((Intent)localObject).putExtra("close_safe_device_style", paramn);
      ((Intent)localObject).putExtra("from_source", 6);
      com.tencent.mm.plugin.account.a.a.iyx.g(this.iSZ, (Intent)localObject);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -140)
    {
      if (!bs.isNullOrNil(this.dxX)) {
        y.m(this.iSZ, paramString, this.dxX);
      }
      AppMethodBeat.o(128326);
      return;
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.agi().a(new bn(new l.5(this)), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.iJk == null)
        {
          this.iJk = SecurityImage.a.a(this.iSZ, ((f)localObject).iSx, ((f)localObject).iJm, ((f)localObject).iJn, ((f)localObject).iJo, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128308);
              ac.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + this.iTn.iJn + " img len" + this.iTn.iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
              paramAnonymousDialogInterface = new s(this.iTn.account, this.iTn.iJl, this.iTn.iSx, l.this.iJk.getSecImgCode(), l.this.iJk.getSecImgSid(), l.this.iJk.getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
              MobileInputUI localMobileInputUI1 = l.this.iSZ;
              MobileInputUI localMobileInputUI2 = l.this.iSZ;
              l.this.iSZ.getString(2131755906);
              localMobileInputUI1.iJi = com.tencent.mm.ui.base.h.b(localMobileInputUI2, l.this.iSZ.getString(2131760781), true, new l.6.1(this, paramAnonymousDialogInterface));
              AppMethodBeat.o(128308);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              l.this.iJk = null;
            }
          }, (SecurityImage.b)localObject);
          AppMethodBeat.o(128326);
          return;
        }
        ac.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + ((f)localObject).iJn + " img len" + ((f)localObject).iJm.length + " " + com.tencent.mm.compatible.util.f.YG());
        this.iJk.b(((f)localObject).iSx, ((f)localObject).iJm, ((f)localObject).iJn, ((f)localObject).iJo);
        AppMethodBeat.o(128326);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.aPH();
        ac.i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", new Object[] { ((f)localObject).account });
        y.FH(((f)localObject).account);
        paramString = ay.hnA.aw("login_weixin_username", "");
        t.cW(this.iSZ);
        if (this.iSZ.iRl)
        {
          ca.hpQ.aO(this.iRm, paramString);
          ca.hpQ.f(u.axw(), u.ayf());
          com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), ca.hpQ.azy() });
        }
        y.showAddrBookUploadConfirm(this.iSZ, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128309);
            ac.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.a.a.iyx.bD(l.this.iSZ);
            ((Intent)localObject).addFlags(67108864);
            MobileInputUI localMobileInputUI = l.this.iSZ;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localMobileInputUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localMobileInputUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localMobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            l.this.iSZ.finish();
            AppMethodBeat.o(128309);
          }
        }, false, 2);
        if (this.iSZ.hnS == 6)
        {
          this.iRk = ((s)paramn).aHJ();
          if (((s)paramn).aHD())
          {
            paramString = this.iSZ;
            boolean bool = this.iRk;
            paramn = new Intent(paramString, RegByMobileSetPwdUI.class);
            paramn.putExtra("kintent_hint", paramString.getString(2131763302));
            paramn.putExtra("kintent_cancelable", bool);
            paramn = new com.tencent.mm.hellhoundlib.b.a().ba(paramn);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, paramn.aeD(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)paramn.lR(0));
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
      Toast.makeText(this.iSZ, this.iSZ.getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      break;
      AppMethodBeat.o(128326);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(128321);
    com.tencent.mm.kernel.g.agi().a(252, this);
    com.tencent.mm.kernel.g.agi().a(701, this);
    com.tencent.mm.kernel.g.agi().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.IK("L200_100");
    AppMethodBeat.o(128321);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128322);
    com.tencent.mm.kernel.g.agi().b(701, this);
    com.tencent.mm.kernel.g.agi().b(252, this);
    com.tencent.mm.kernel.g.agi().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("L200_100") + ",2");
    AppMethodBeat.o(128322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l
 * JD-Core Version:    0.7.0.1
 */