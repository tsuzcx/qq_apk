package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.gk;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.model.l;
import com.tencent.mm.plugin.account.model.l.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;
import java.util.Map;

public final class o
  implements f, MobileVerifyUI.b
{
  String fPq;
  gk jjW;
  g jkx;
  String jnB;
  private boolean jnC;
  MobileVerifyUI jnv;
  
  public o()
  {
    AppMethodBeat.i(128435);
    this.jkx = null;
    this.jnC = true;
    this.jjW = new gk();
    AppMethodBeat.o(128435);
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.jnv = paramMobileVerifyUI;
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128438);
    switch (8.jnz[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128438);
      return false;
      h.e(this.jnv, this.jnv.getString(2131761297), "", this.jnv.getString(2131761298), this.jnv.getString(2131761299), new o.9(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128438);
      return true;
      com.tencent.mm.kernel.g.aiU().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.jnv.dzn, 15, this.jnv.jah.getText().toString().trim(), 0, "");
      parama.EX(this.jnv.jmq);
      com.tencent.mm.kernel.g.aiU().a(parama, 0);
      MobileVerifyUI localMobileVerifyUI1 = this.jnv;
      MobileVerifyUI localMobileVerifyUI2 = this.jnv;
      this.jnv.getString(2131755906);
      localMobileVerifyUI1.fMu = h.b(localMobileVerifyUI2, this.jnv.getString(2131756503), true, new o.11(this, parama));
      continue;
      com.tencent.mm.kernel.g.aiU().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.jnv.dzn, 14, "", 0, "");
      parama.EX(this.jnv.jmq);
      com.tencent.mm.kernel.g.aiU().a(parama, 0);
      l.a(l.a.jhI);
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.g.ajA();
      parama = parama.append(com.tencent.mm.kernel.a.aiO()).append(",").append(getClass().getName()).append(",R200_350_auto,");
      com.tencent.mm.kernel.g.ajA();
      com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_350_auto") + ",1");
      com.tencent.mm.kernel.g.aiU().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.jnv.dzn, 15, this.jnv.jah.getText().toString().trim(), 0, "");
      parama.EX(this.jnv.jmq);
      com.tencent.mm.kernel.g.aiU().a(parama, 0);
      localMobileVerifyUI1 = this.jnv;
      localMobileVerifyUI2 = this.jnv;
      this.jnv.getString(2131755906);
      localMobileVerifyUI1.fMu = h.b(localMobileVerifyUI2, this.jnv.getString(2131756503), true, new o.1(this, parama));
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(128439);
    ad.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jnv.fMu != null)
    {
      this.jnv.fMu.dismiss();
      this.jnv.fMu = null;
    }
    if (paramn.getType() == 255)
    {
      com.tencent.mm.kernel.g.aiU().b(255, this);
      if ((paramInt2 == -3) && (paramInt1 == 4)) {
        this.jnv.fw(this.jnC);
      }
      AppMethodBeat.o(128439);
      return;
    }
    Object localObject1;
    if (((paramn.getType() == 701) || (paramn.getType() == 701)) && (this.jkx != null))
    {
      com.tencent.mm.kernel.g.aiU().b(701, this);
      com.tencent.mm.kernel.g.aiU().b(252, this);
      this.jkx.a(this.jnv, paramInt1, paramInt2, paramString, paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramn instanceof s)) {
          this.jnC = ((s)paramn).aKU();
        }
        com.tencent.mm.kernel.g.aiU().a(255, this);
        paramString = new t(1);
        com.tencent.mm.kernel.g.aiU().a(paramString, 0);
        paramn = this.jnv;
        localObject1 = this.jnv;
        this.jnv.getString(2131755906);
        paramn.fMu = h.b((Context)localObject1, this.jnv.getString(2131755804), true, new o.12(this, paramString));
      }
      AppMethodBeat.o(128439);
      return;
    }
    int i;
    Object localObject2;
    String str2;
    Object localObject4;
    String str1;
    int j;
    String str3;
    boolean bool2;
    boolean bool1;
    Object localObject3;
    if (paramn.getType() == 145)
    {
      com.tencent.mm.kernel.g.aiU().b(145, this);
      i = ((com.tencent.mm.modelfriend.a)paramn).KR();
      if (i != 15)
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 15)
        {
          if (this.jnv.jnh == 1)
          {
            this.jnB = ((com.tencent.mm.modelfriend.a)paramn).aHw();
            com.tencent.mm.kernel.g.aiU().a(126, this);
            paramString = new u("", this.jnv.jmZ, this.jnv.bVF, 0, "", this.jnv.dzn, "", "", this.jnB, this.jnv.imo, "", "", "", true, this.jnv.jnV.booleanValue());
            paramString.Gn(this.jnv.jmq);
            paramString.Go(this.jnv.joc);
            com.tencent.mm.kernel.g.aiU().a(paramString, 0);
            paramn = this.jnv;
            localObject1 = this.jnv;
            this.jnv.getString(2131755906);
            paramn.fMu = h.b((Context)localObject1, this.jnv.getString(2131762385), true, new o.7(this, paramString));
            AppMethodBeat.o(128439);
            return;
          }
          paramString = new Intent();
          paramString.putExtra("regsetinfo_ticket", ((com.tencent.mm.modelfriend.a)paramn).aHw());
          paramString.putExtra("regsetinfo_user", this.jnv.dzn);
          paramString.putExtra("regsession_id", this.jnv.jmq);
          paramString.putExtra("reg_3d_app_ticket", this.jnv.joc);
          paramString.putExtra("reg_3d_app_type", this.jnv.jnk);
          paramString.putExtra("regsetinfo_ismobile", 4);
          paramString.putExtra("regsetinfo_NextControl", ((com.tencent.mm.modelfriend.a)paramn).aHD());
          paramString.putExtra("key_reg_style", this.jnv.jnh);
          paramString.setClass(this.jnv, RegSetInfoUI.class);
          paramn = this.jnv;
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.ahp(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramn.startActivity((Intent)paramString.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          l.a(l.a.jhJ);
        }
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -35)
      {
        paramString = com.tencent.mm.h.a.uz(paramString);
        this.jjW.enS = this.jnv.jnk;
        this.jjW.dPl = 7L;
        this.jjW.aLk();
        if (paramString != null)
        {
          paramString.a(this.jnv, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128433);
              com.tencent.mm.kernel.g.aiU().a(701, o.this);
              com.tencent.mm.kernel.g.aiU().a(252, o.this);
              o.this.jkx = new g(new g.a()
              {
                public final void a(ProgressDialog paramAnonymous2ProgressDialog)
                {
                  o.this.jnv.fMu = paramAnonymous2ProgressDialog;
                }
              }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aHv(), o.this.jnv.dzn);
              o.this.jkx.b(o.this.jnv);
              o.this.jjW.enS = o.this.jnv.jnk;
              o.this.jjW.dPl = 8L;
              o.this.jjW.aLk();
              AppMethodBeat.o(128433);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(128439);
          return;
        }
        h.a(this.jnv, this.jnv.getString(2131756444), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128434);
            com.tencent.mm.kernel.g.aiU().a(701, o.this);
            com.tencent.mm.kernel.g.aiU().a(252, o.this);
            o.this.jkx = new g(new g.a()
            {
              public final void a(ProgressDialog paramAnonymous2ProgressDialog)
              {
                o.this.jnv.fMu = paramAnonymous2ProgressDialog;
              }
            }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aHv(), o.this.jnv.dzn);
            o.this.jkx.b(o.this.jnv);
            o.this.jjW.enS = o.this.jnv.jnk;
            o.this.jjW.dPl = 8L;
            o.this.jjW.aLk();
            AppMethodBeat.o(128434);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -212)
      {
        paramString = new Intent(this.jnv, MobileLoginOrForceReg.class);
        paramString.putExtra("ticket", ((com.tencent.mm.modelfriend.a)paramn).aHw());
        paramString.putExtra("moble", this.jnv.dzn);
        paramString.putExtra("regsession_id", this.jnv.jmq);
        paramString.putExtra("reg_3d_app_ticket", this.jnv.joc);
        paramString.putExtra("reg_3d_app_type", this.jnv.jnk);
        paramString.putExtra("next_controll", ((com.tencent.mm.modelfriend.a)paramn).aHD());
        paramString.putExtra("username", ((com.tencent.mm.modelfriend.a)paramn).getUsername());
        paramString.putExtra("password", ((com.tencent.mm.modelfriend.a)paramn).aHv());
        paramString.putExtra("nickname", ((com.tencent.mm.modelfriend.a)paramn).aHJ());
        paramString.putExtra("avatar_url", ((com.tencent.mm.modelfriend.a)paramn).aHI());
        paramString.putExtra("key_reg_style", this.jnv.jnh);
        if (this.jnv.jnh == 1)
        {
          paramString.putExtra("kintent_nickname", this.jnv.bVF);
          paramString.putExtra("kintent_password", this.jnv.jmZ);
          paramString.putExtra("kintent_hasavatar", this.jnv.jnV);
        }
        paramn = this.jnv;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.ahp(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramn.startActivity((Intent)paramString.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.uz(paramString);
        if (paramString != null)
        {
          paramString.a(this.jnv, null, null);
          AppMethodBeat.o(128439);
          return;
        }
        h.l(this.jnv, 2131756508, 2131756514);
        AppMethodBeat.o(128439);
      }
    }
    else if (paramn.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = this.jnv.jnV;
        localObject1 = this.jnv.jmZ;
        localObject2 = this.jnv.bVF;
        if (this.jnv.jct == null)
        {
          this.jnv.jct = SecurityImage.a.a(this.jnv, 0, ((u)paramn).aKM(), ((u)paramn).aKL(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128424);
              com.tencent.mm.kernel.g.aiU().a(126, o.this);
              paramAnonymousDialogInterface = new u("", this.jnm, this.jnn, 0, "", o.this.jnv.dzn, "", "", o.this.jnB, o.this.jnv.imo, "", ((u)paramn).aKL(), o.this.jnv.jct.getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.Gn(o.this.jnv.jmq);
              paramAnonymousDialogInterface.Go(o.this.jnv.joc);
              com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI1 = o.this.jnv;
              MobileVerifyUI localMobileVerifyUI2 = o.this.jnv;
              o.this.jnv.getString(2131755906);
              localMobileVerifyUI1.fMu = h.b(localMobileVerifyUI2, o.this.jnv.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128423);
                  com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.aiU().b(126, o.this);
                  AppMethodBeat.o(128423);
                }
              });
              AppMethodBeat.o(128424);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              o.this.jnv.jct = null;
            }
          }, new SecurityImage.b()
          {
            public final void aSv()
            {
              AppMethodBeat.i(128425);
              o.this.jnv.hideVKB();
              com.tencent.mm.kernel.g.aiU().a(126, o.this);
              u localu = new u("", this.jnm, this.jnn, 0, "", o.this.jnv.dzn, "", "", o.this.jnB, o.this.jnv.imo, "", ((u)paramn).aKL(), "", true, paramString.booleanValue());
              localu.Gn(o.this.jnv.jmq);
              localu.Go(o.this.jnv.joc);
              com.tencent.mm.kernel.g.aiU().a(localu, 0);
              AppMethodBeat.o(128425);
            }
          });
          AppMethodBeat.o(128439);
          return;
        }
        this.jnv.jct.b(0, ((u)paramn).aKM(), ((u)paramn).aKL(), "");
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        str2 = this.jnv.dzn;
        localObject4 = this.jnv.jnV;
        this.jjW.enS = this.jnv.jnk;
        this.jjW.dPl = 6L;
        this.jjW.aLk();
        i = ((u)paramn).aKW();
        str1 = ((u)paramn).aKX();
        j = ((u)paramn).aKY();
        str3 = ((u)paramn).aKZ();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = bw.M(str3, "wording");
        if (localMap == null) {
          break label2544;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!bt.isNullOrNil((String)localObject3)) {
          break label1978;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label2544;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!bt.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (bt.isNullOrNil((String)localObject3)) {
          break label2541;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", new Object[] { localObject4 });
      ad.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", new Object[] { Integer.valueOf(i) });
      ad.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", new Object[] { str1 });
      ad.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", new Object[] { Integer.valueOf(j) });
      ad.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.kernel.a.dB(true);
      if (((Boolean)localObject4).booleanValue())
      {
        localObject3 = b.asc() + "temp.avatar";
        localObject4 = b.asc() + "temp.avatar.hd";
        i.mA((String)localObject3, (String)localObject4);
        i.deleteFile((String)localObject3);
        com.tencent.mm.sdk.platformtools.g.c((String)localObject4, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject3);
        new com.tencent.mm.ak.n(this.jnv, b.asc() + "temp.avatar").a(new o.5(this, paramn, str2, str1, bool1, (String)localObject1, (String)localObject2, j), new o.6(this, paramn, str2, str1, bool1, (String)localObject1, (String)localObject2, j));
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.uz(paramString);
        if (localObject1 == null) {
          break label2419;
        }
        ((com.tencent.mm.h.a)localObject1).a(this.jnv, null, null);
        AppMethodBeat.o(128439);
        return;
        label1978:
        int k = bt.aRe((String)localObject3);
        if (k == 0)
        {
          bool1 = false;
          break;
        }
        if (k != 1) {
          break;
        }
        bool1 = true;
        break;
        this.fPq = ((u)paramn).aKV();
        az.hFS.aM("login_user_name", str2);
        if ((str1 != null) && (str1.contains("0")))
        {
          com.tencent.mm.plugin.b.a.Ma("R300_100_phone");
          if (!bool1) {}
          for (localObject1 = new Intent(this.jnv, FindMContactIntroUI.class);; localObject1 = localObject3)
          {
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("regsetinfo_ticket", this.fPq);
            ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
            ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
            localObject2 = com.tencent.mm.plugin.account.a.a.iRG.bC(this.jnv);
            ((Intent)localObject2).addFlags(67108864);
            ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
            MMWizardActivity.b(this.jnv, (Intent)localObject1, (Intent)localObject2);
            this.jnv.finish();
            break;
            localObject3 = new Intent(this.jnv, FindMContactAlertUI.class);
            ((Intent)localObject3).putExtra("alert_title", (String)localObject1);
            ((Intent)localObject3).putExtra("alert_message", (String)localObject2);
          }
        }
        localObject2 = com.tencent.mm.plugin.account.a.a.iRG.bC(this.jnv);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = this.jnv;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.ajA();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aiO()).append(",").append(this.jnv.getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.g.ajA();
        com.tencent.mm.plugin.b.a.vk(com.tencent.mm.kernel.a.wS("R200_900_phone") + ",4");
        this.jnv.finish();
      }
      label2419:
      if (this.jnv.n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramn.getType() == 252) || (paramn.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.uz(paramString);
        if ((paramString != null) && (paramString.a(this.jnv, null, null)))
        {
          AppMethodBeat.o(128439);
          return;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this.jnv, this.jnv.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(128439);
      return;
      label2541:
      continue;
      label2544:
      localObject1 = null;
      bool1 = bool2;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(128436);
    com.tencent.mm.kernel.g.aiU().a(126, this);
    AppMethodBeat.o(128436);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128437);
    com.tencent.mm.kernel.g.aiU().b(126, this);
    AppMethodBeat.o(128437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o
 * JD-Core Version:    0.7.0.1
 */