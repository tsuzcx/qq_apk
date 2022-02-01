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
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

public final class m
  implements i, MobileInputUI.b
{
  String account;
  private String dQC;
  private String edo;
  SecurityImage kdp = null;
  private String kjv;
  private boolean klu = true;
  private String klw;
  MobileInputUI knl;
  
  private void Tu(final String paramString)
  {
    AppMethodBeat.i(128324);
    paramString = new com.tencent.mm.modelfriend.a(paramString, 16, "", 0, "");
    com.tencent.mm.kernel.g.azz().a(paramString, 0);
    MobileInputUI localMobileInputUI1 = this.knl;
    MobileInputUI localMobileInputUI2 = this.knl;
    this.knl.getString(2131755998);
    localMobileInputUI1.kdn = com.tencent.mm.ui.base.h.a(localMobileInputUI2, this.knl.getString(2131756029), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128316);
        com.tencent.mm.kernel.g.azz().a(paramString);
        AppMethodBeat.o(128316);
      }
    });
    AppMethodBeat.o(128324);
  }
  
  private void bpn()
  {
    AppMethodBeat.i(128320);
    if (this.knl.iDM == 6)
    {
      this.knl.knD.reset();
      this.knl.knL.setText(2131762528);
      this.knl.kmS.setVisibility(8);
      this.knl.knD.setVisibility(0);
      this.knl.knD.getContentEditText().requestFocus();
      this.knl.knD.setSendSmsBtnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128311);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          m.a(m.this, m.this.account);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128311);
        }
      });
      this.knl.knL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128312);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          m.this.knl.kmr[1] = 2;
          m.this.knl.iDM = 7;
          m.this.knl.knD.reset();
          com.tencent.mm.kernel.g.azz().b(145, m.this);
          m.a(m.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128312);
        }
      });
      AppMethodBeat.o(128320);
      return;
    }
    if (this.knl.iDM == 7)
    {
      this.knl.knL.setText(2131762529);
      this.knl.kmS.setVisibility(0);
      this.knl.klM.requestFocus();
      this.knl.knD.setVisibility(8);
      this.knl.knL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(128313);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          m.this.knl.kmr[1] = 1;
          m.this.knl.iDM = 6;
          com.tencent.mm.kernel.g.azz().a(145, m.this);
          m.a(m.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(128313);
        }
      });
    }
    AppMethodBeat.o(128320);
  }
  
  private void cc(final String paramString1, String paramString2)
  {
    AppMethodBeat.i(128325);
    if (Util.isNullOrNil(paramString1))
    {
      com.tencent.mm.ui.base.h.n(this.knl, 2131767037, 2131762516);
      AppMethodBeat.o(128325);
      return;
    }
    if (Util.isNullOrNil(paramString2))
    {
      com.tencent.mm.ui.base.h.n(this.knl, 2131767029, 2131762516);
      AppMethodBeat.o(128325);
      return;
    }
    this.knl.klM.setText(paramString2);
    this.knl.hideVKB();
    paramString1 = new com.tencent.mm.modelsimple.t(paramString1, paramString2, null, 1);
    com.tencent.mm.kernel.g.azz().a(paramString1, 0);
    paramString2 = this.knl;
    MobileInputUI localMobileInputUI = this.knl;
    this.knl.getString(2131755998);
    paramString2.kdn = com.tencent.mm.ui.base.h.a(localMobileInputUI, this.knl.getString(2131762532), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(128317);
        com.tencent.mm.kernel.g.azz().a(paramString1);
        AppMethodBeat.o(128317);
      }
    });
    AppMethodBeat.o(128325);
  }
  
  private boolean n(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(128327);
    if (com.tencent.mm.plugin.account.a.a.jRu.a(this.knl, paramInt1, paramInt2, paramString))
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
      if (com.tencent.mm.kernel.g.azz().aYS() == 5)
      {
        com.tencent.mm.ui.base.h.n(this.knl, 2131763503, 2131763502);
        AppMethodBeat.o(128327);
        return true;
      }
      AppMethodBeat.o(128327);
      return false;
    case -3: 
      com.tencent.mm.ui.base.h.n(this.knl, 2131758757, 2131762516);
      AppMethodBeat.o(128327);
      return true;
    case -9: 
      com.tencent.mm.ui.base.h.n(this.knl, 2131762515, 2131762516);
      AppMethodBeat.o(128327);
      return true;
    case -2023: 
    case -100: 
      com.tencent.mm.kernel.g.aAf();
      com.tencent.mm.kernel.a.hold();
      MobileInputUI localMobileInputUI = this.knl;
      com.tencent.mm.kernel.g.aAf();
      if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {}
      for (paramString = com.tencent.mm.cb.a.aI(this.knl, 2131762849);; paramString = com.tencent.mm.kernel.a.ayX())
      {
        com.tencent.mm.ui.base.h.a(localMobileInputUI, paramString, this.knl.getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        AppMethodBeat.o(128327);
        return true;
        com.tencent.mm.kernel.g.aAf();
      }
    case -140: 
      if (!Util.isNullOrNil(this.edo)) {
        y.m(this.knl, paramString, this.edo);
      }
      AppMethodBeat.o(128327);
      return true;
    case -34: 
      Toast.makeText(this.knl, 2131756598, 0).show();
      AppMethodBeat.o(128327);
      return true;
    case -32: 
      com.tencent.mm.ui.base.h.a(this.knl, 2131756646, 2131756650, null);
      AppMethodBeat.o(128327);
      return true;
    }
    com.tencent.mm.ui.base.h.a(this.knl, 2131756644, 2131756650, null);
    AppMethodBeat.o(128327);
    return true;
  }
  
  public final void a(final MobileInputUI.a parama)
  {
    AppMethodBeat.i(128323);
    switch (11.knq[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128323);
      return;
      this.knl.hideVKB();
      this.knl.knO = PhoneFormater.countryCodeWithPlus(this.knl.countryCode);
      this.knl.knP = this.knl.knC.getText().toString();
      if ((Util.isNullOrNil(this.knl.knO)) || (Util.isNullOrNil(this.knl.knP)))
      {
        AppMethodBeat.o(128323);
        return;
      }
      if (this.knl.iDM == 7)
      {
        if (!Util.isNullOrNil(this.dQC))
        {
          cc(this.account, this.dQC);
          AppMethodBeat.o(128323);
          return;
        }
        cc(this.account, this.knl.klM.getText().toString());
        AppMethodBeat.o(128323);
        return;
      }
      if (this.knl.iDM == 6)
      {
        parama = this.knl.knD.getText().toString().trim();
        if (Util.isNullOrNil(parama))
        {
          com.tencent.mm.ui.base.h.n(this.knl, 2131767036, 2131762516);
          AppMethodBeat.o(128323);
          return;
        }
        this.knl.hideVKB();
        parama = new com.tencent.mm.modelfriend.a(this.account, 17, parama, 0, "");
        com.tencent.mm.kernel.g.azz().a(parama, 0);
        MobileInputUI localMobileInputUI1 = this.knl;
        MobileInputUI localMobileInputUI2 = this.knl;
        this.knl.getString(2131755998);
        localMobileInputUI1.kdn = com.tencent.mm.ui.base.h.a(localMobileInputUI2, this.knl.getString(2131756639), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128315);
            com.tencent.mm.kernel.g.azz().a(parama);
            AppMethodBeat.o(128315);
          }
        });
      }
    }
  }
  
  public final void a(MobileInputUI paramMobileInputUI)
  {
    AppMethodBeat.i(128319);
    this.knl = paramMobileInputUI;
    paramMobileInputUI.knJ.setVisibility(0);
    this.account = paramMobileInputUI.getIntent().getStringExtra("binded_mobile");
    if (Util.isNullOrNil(this.account)) {
      this.account = PhoneFormater.pureNumber(paramMobileInputUI.knO + paramMobileInputUI.knP);
    }
    paramMobileInputUI.knC.setTextColor(paramMobileInputUI.getResources().getColor(2131100594));
    paramMobileInputUI.knC.setEnabled(false);
    paramMobileInputUI.knC.setFocusable(false);
    paramMobileInputUI.knB.setFocusable(false);
    paramMobileInputUI.knB.setText(PhoneFormater.pureNumber(this.account));
    paramMobileInputUI.knB.setVisibility(0);
    bpn();
    paramMobileInputUI.knL.setVisibility(0);
    paramMobileInputUI.knH.setText(2131762525);
    paramMobileInputUI.knH.setVisibility(0);
    paramMobileInputUI.knH.setEnabled(true);
    this.klw = bf.iDu.aA("login_weixin_username", "");
    this.kjv = paramMobileInputUI.getIntent().getStringExtra("auth_ticket");
    if (!Util.isNullOrNil(this.kjv)) {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(128303);
          m.a(m.this, g.bpk(), g.bpl());
          AppMethodBeat.o(128303);
        }
      }, 500L);
    }
    AppMethodBeat.o(128319);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128326);
    Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.knl.kdn != null)
    {
      this.knl.kdn.dismiss();
      this.knl.kdn = null;
    }
    if (paramq.getType() == 145)
    {
      i = ((com.tencent.mm.modelfriend.a)paramq).Vj();
      if (i == 13) {
        if (paramInt2 == -36)
        {
          localObject = com.tencent.mm.h.a.Dk(paramString);
          if (((com.tencent.mm.modelfriend.a)paramq).bbJ() != 1) {
            break label234;
          }
          Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "login check state, sms up");
          if (localObject != null)
          {
            ((com.tencent.mm.h.a)localObject).a(this.knl, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                AppMethodBeat.i(128318);
                m.b(m.this);
                AppMethodBeat.o(128318);
              }
            }, null);
            AppMethodBeat.o(128326);
            return;
          }
          com.tencent.mm.ui.base.h.a(this.knl, this.knl.getString(2131762511), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128304);
              m.b(m.this);
              AppMethodBeat.o(128304);
            }
          }, null);
        }
      }
    }
    label234:
    while ((paramq.getType() != 252) && (paramq.getType() != 701)) {
      for (;;)
      {
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if ((paramString == null) || (this.knl == null) || (!paramString.a(this.knl, null, null))) {
          break;
        }
        AppMethodBeat.o(128326);
        return;
        if (localObject != null)
        {
          ((com.tencent.mm.h.a)localObject).a(this.knl, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128305);
              m.this.knl.knD.bTu();
              m.b(m.this, m.this.account);
              AppMethodBeat.o(128305);
            }
          }, null);
          AppMethodBeat.o(128326);
          return;
        }
        this.knl.knD.bTu();
        Tu(this.account);
        continue;
        if (i == 16)
        {
          if (paramInt2 == -41)
          {
            this.knl.knD.reset();
            com.tencent.mm.ui.base.h.n(this.knl, 2131764394, 2131764395);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -75)
          {
            this.knl.knD.reset();
            com.tencent.mm.ui.base.h.c(this.knl, this.knl.getString(2131755300), "", true);
            AppMethodBeat.o(128326);
            return;
          }
          if (paramInt2 == -106)
          {
            this.knl.knD.reset();
            y.g(this.knl, paramString, 32045);
            AppMethodBeat.o(128326);
          }
        }
        else if (i == 17)
        {
          if ((paramInt1 == 0) && (paramInt2 == 0))
          {
            new h(new h.a()
            {
              public final void a(ProgressDialog paramAnonymousProgressDialog)
              {
                m.this.knl.kdn = ((com.tencent.mm.ui.base.q)paramAnonymousProgressDialog);
              }
            }, ((com.tencent.mm.modelfriend.a)paramq).getUsername(), ((com.tencent.mm.modelfriend.a)paramq).bbF(), this.account).b(this.knl);
            AppMethodBeat.o(128326);
            return;
          }
          if (n(paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(128326);
            return;
          }
          paramq = com.tencent.mm.h.a.Dk(paramString);
          if (paramq != null) {
            paramq.a(this.knl, null, null);
          }
        }
      }
    }
    this.edo = ((com.tencent.mm.modelsimple.t)paramq).bfk();
    Object localObject = new g();
    ((g)localObject).kds = ((com.tencent.mm.modelsimple.t)paramq).bfl();
    ((g)localObject).kdr = ((com.tencent.mm.modelsimple.t)paramq).bfm();
    ((g)localObject).kdt = ((com.tencent.mm.modelsimple.t)paramq).bfn();
    ((g)localObject).kmJ = ((com.tencent.mm.modelsimple.t)paramq).getSecCodeType();
    ((g)localObject).account = ((com.tencent.mm.modelsimple.t)paramq).account;
    ((g)localObject).kdq = this.knl.klM.getText().toString();
    if (paramInt2 == -75)
    {
      y.dz(this.knl);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -106)
    {
      y.g(this.knl, paramString, 32045);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -217)
    {
      y.a(this.knl, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramq), paramInt2);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -205)
    {
      this.kjv = ((com.tencent.mm.modelsimple.t)paramq).bbH();
      paramString = ((com.tencent.mm.modelsimple.t)paramq).bfp();
      paramq = ((com.tencent.mm.modelsimple.t)paramq).bfs();
      Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", new Object[] { Util.secPrint(this.kjv), paramq });
      g.a((g)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("auth_ticket", this.kjv);
      ((Intent)localObject).putExtra("binded_mobile", paramString);
      ((Intent)localObject).putExtra("close_safe_device_style", paramq);
      ((Intent)localObject).putExtra("from_source", 6);
      com.tencent.mm.plugin.account.a.a.jRt.g(this.knl, (Intent)localObject);
      AppMethodBeat.o(128326);
      return;
    }
    if (paramInt2 == -140)
    {
      if (!Util.isNullOrNil(this.edo)) {
        y.m(this.knl, paramString, this.edo);
      }
      AppMethodBeat.o(128326);
      return;
    }
    if ((paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      com.tencent.mm.kernel.g.azz().a(new bu(new bu.a()
      {
        public final void a(com.tencent.mm.network.g paramAnonymousg)
        {
          AppMethodBeat.i(128306);
          if (paramAnonymousg == null)
          {
            AppMethodBeat.o(128306);
            return;
          }
          paramAnonymousg = paramAnonymousg.aZh();
          com.tencent.mm.kernel.g.aAf();
          int i = com.tencent.mm.kernel.a.getUin();
          paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
          AppMethodBeat.o(128306);
        }
      }), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.kdp == null)
        {
          this.kdp = SecurityImage.a.a(this.knl, ((g)localObject).kmJ, ((g)localObject).kdr, ((g)localObject).kds, ((g)localObject).kdt, new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128308);
              Log.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + this.knz.kds + " img len" + this.knz.kdr.length + " " + f.apq());
              paramAnonymousDialogInterface = new com.tencent.mm.modelsimple.t(this.knz.account, this.knz.kdq, this.knz.kmJ, m.this.kdp.getSecImgCode(), m.this.kdp.getSecImgSid(), m.this.kdp.getSecImgEncryptKey(), 1, "", false, false);
              com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface, 0);
              MobileInputUI localMobileInputUI1 = m.this.knl;
              MobileInputUI localMobileInputUI2 = m.this.knl;
              m.this.knl.getString(2131755998);
              localMobileInputUI1.kdn = com.tencent.mm.ui.base.h.a(localMobileInputUI2, m.this.knl.getString(2131762532), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128307);
                  com.tencent.mm.kernel.g.azz().a(paramAnonymousDialogInterface);
                  AppMethodBeat.o(128307);
                }
              });
              AppMethodBeat.o(128308);
            }
          }, null, new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              m.this.kdp = null;
            }
          }, (SecurityImage.b)localObject);
          AppMethodBeat.o(128326);
          return;
        }
        Log.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + ((g)localObject).kds + " img len" + ((g)localObject).kdr.length + " " + f.apq());
        this.kdp.b(((g)localObject).kmJ, ((g)localObject).kdr, ((g)localObject).kds, ((g)localObject).kdt);
        AppMethodBeat.o(128326);
        return;
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.g.aAf();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.plugin.account.friend.a.l.boe();
        Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", new Object[] { ((g)localObject).account });
        y.St(((g)localObject).account);
        paramString = bf.iDu.aA("login_weixin_username", "");
        com.tencent.mm.platformtools.t.dr(this.knl);
        if (this.knl.klv)
        {
          ch.iFO.aR(this.klw, paramString);
          ch.iFO.h(z.aTY(), z.aUS());
          com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(9), ch.iFO.aWp() });
        }
        y.showAddrBookUploadConfirm(this.knl, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128309);
            Log.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
            Object localObject = com.tencent.mm.plugin.account.a.a.jRt.bZ(m.this.knl);
            ((Intent)localObject).addFlags(67108864);
            MobileInputUI localMobileInputUI = m.this.knl;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localMobileInputUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localMobileInputUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localMobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            m.this.knl.finish();
            AppMethodBeat.o(128309);
          }
        }, false, 2);
        if (this.knl.iDM == 6)
        {
          this.klu = ((com.tencent.mm.modelsimple.t)paramq).bfu();
          if (((com.tencent.mm.modelsimple.t)paramq).bfo())
          {
            paramString = this.knl;
            boolean bool = this.klu;
            paramq = new Intent(paramString, RegByMobileSetPwdUI.class);
            paramq.putExtra("kintent_hint", paramString.getString(2131765477));
            paramq.putExtra("kintent_cancelable", bool);
            paramq = new com.tencent.mm.hellhoundlib.b.a().bl(paramq);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, paramq.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)paramq.pG(0));
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
      Toast.makeText(this.knl, this.knl.getString(2131760805, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      break;
      AppMethodBeat.o(128326);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(128321);
    com.tencent.mm.kernel.g.azz().a(252, this);
    com.tencent.mm.kernel.g.azz().a(701, this);
    com.tencent.mm.kernel.g.azz().a(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.aAf();
    com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("L200_100") + ",1");
    com.tencent.mm.plugin.b.a.bwU("L200_100");
    AppMethodBeat.o(128321);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128322);
    com.tencent.mm.kernel.g.azz().b(701, this);
    com.tencent.mm.kernel.g.azz().b(252, this);
    com.tencent.mm.kernel.g.azz().b(145, this);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L200_100,");
    com.tencent.mm.kernel.g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("L200_100") + ",2");
    AppMethodBeat.o(128322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.m
 * JD-Core Version:    0.7.0.1
 */