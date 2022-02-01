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
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.dv;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.model.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;
import java.util.Map;

public final class o
  implements com.tencent.mm.al.g, MobileVerifyUI.b
{
  String fsw;
  dv iqH;
  g irj;
  MobileVerifyUI iuh;
  String iun;
  private boolean iuo;
  
  public o()
  {
    AppMethodBeat.i(128435);
    this.irj = null;
    this.iuo = true;
    this.iqH = new dv();
    AppMethodBeat.o(128435);
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.iuh = paramMobileVerifyUI;
  }
  
  public final boolean a(final MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128438);
    switch (8.iul[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128438);
      return false;
      h.d(this.iuh, this.iuh.getString(2131761297), "", this.iuh.getString(2131761298), this.iuh.getString(2131761299), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(128430);
          o.this.iuh.finish();
          com.tencent.mm.plugin.account.model.l.a(l.a.ios);
          AppMethodBeat.o(128430);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128438);
      return true;
      com.tencent.mm.kernel.g.aeS().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.iuh.dpO, 15, this.iuh.igP.getText().toString().trim(), 0, "");
      parama.xT(this.iuh.itd);
      com.tencent.mm.kernel.g.aeS().a(parama, 0);
      MobileVerifyUI localMobileVerifyUI1 = this.iuh;
      MobileVerifyUI localMobileVerifyUI2 = this.iuh;
      this.iuh.getString(2131755906);
      localMobileVerifyUI1.fpP = h.b(localMobileVerifyUI2, this.iuh.getString(2131756503), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128431);
          com.tencent.mm.kernel.g.aeS().a(parama);
          com.tencent.mm.kernel.g.aeS().b(145, o.this);
          AppMethodBeat.o(128431);
        }
      });
      continue;
      com.tencent.mm.kernel.g.aeS().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.iuh.dpO, 14, "", 0, "");
      parama.xT(this.iuh.itd);
      com.tencent.mm.kernel.g.aeS().a(parama, 0);
      com.tencent.mm.plugin.account.model.l.a(l.a.iot);
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.g.afz();
      parama = parama.append(com.tencent.mm.kernel.a.aeM()).append(",").append(getClass().getName()).append(",R200_350_auto,");
      com.tencent.mm.kernel.g.afz();
      com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_350_auto") + ",1");
      com.tencent.mm.kernel.g.aeS().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.iuh.dpO, 15, this.iuh.igP.getText().toString().trim(), 0, "");
      parama.xT(this.iuh.itd);
      com.tencent.mm.kernel.g.aeS().a(parama, 0);
      localMobileVerifyUI1 = this.iuh;
      localMobileVerifyUI2 = this.iuh;
      this.iuh.getString(2131755906);
      localMobileVerifyUI1.fpP = h.b(localMobileVerifyUI2, this.iuh.getString(2131756503), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128422);
          com.tencent.mm.kernel.g.aeS().a(parama);
          com.tencent.mm.kernel.g.aeS().b(145, o.this);
          AppMethodBeat.o(128422);
        }
      });
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(128439);
    ad.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iuh.fpP != null)
    {
      this.iuh.fpP.dismiss();
      this.iuh.fpP = null;
    }
    if (paramn.getType() == 255)
    {
      com.tencent.mm.kernel.g.aeS().b(255, this);
      if ((paramInt2 == -3) && (paramInt1 == 4)) {
        this.iuh.eY(this.iuo);
      }
      AppMethodBeat.o(128439);
      return;
    }
    Object localObject1;
    if (((paramn.getType() == 701) || (paramn.getType() == 701)) && (this.irj != null))
    {
      com.tencent.mm.kernel.g.aeS().b(701, this);
      com.tencent.mm.kernel.g.aeS().b(252, this);
      this.irj.a(this.iuh, paramInt1, paramInt2, paramString, paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramn instanceof s)) {
          this.iuo = ((s)paramn).aAT();
        }
        com.tencent.mm.kernel.g.aeS().a(255, this);
        paramString = new t(1);
        com.tencent.mm.kernel.g.aeS().a(paramString, 0);
        paramn = this.iuh;
        localObject1 = this.iuh;
        this.iuh.getString(2131755906);
        paramn.fpP = h.b((Context)localObject1, this.iuh.getString(2131755804), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128432);
            com.tencent.mm.kernel.g.aeS().a(paramString);
            AppMethodBeat.o(128432);
          }
        });
      }
      AppMethodBeat.o(128439);
      return;
    }
    int i;
    Object localObject2;
    final String str2;
    Object localObject4;
    final String str1;
    final int j;
    String str3;
    boolean bool2;
    final boolean bool1;
    Object localObject3;
    if (paramn.getType() == 145)
    {
      com.tencent.mm.kernel.g.aeS().b(145, this);
      i = ((com.tencent.mm.modelfriend.a)paramn).JJ();
      if (i != 15)
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 15)
        {
          if (this.iuh.itU == 1)
          {
            this.iun = ((com.tencent.mm.modelfriend.a)paramn).axz();
            com.tencent.mm.kernel.g.aeS().a(126, this);
            paramString = new u("", this.iuh.itM, this.iuh.bNK, 0, "", this.iuh.dpO, "", "", this.iun, this.iuh.hsv, "", "", "", true, this.iuh.iuH.booleanValue());
            paramString.zd(this.iuh.itd);
            paramString.ze(this.iuh.iuO);
            com.tencent.mm.kernel.g.aeS().a(paramString, 0);
            paramn = this.iuh;
            localObject1 = this.iuh;
            this.iuh.getString(2131755906);
            paramn.fpP = h.b((Context)localObject1, this.iuh.getString(2131762385), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(128428);
                com.tencent.mm.kernel.g.aeS().a(paramString);
                com.tencent.mm.kernel.g.aeS().b(126, o.this);
                AppMethodBeat.o(128428);
              }
            });
            AppMethodBeat.o(128439);
            return;
          }
          paramString = new Intent();
          paramString.putExtra("regsetinfo_ticket", ((com.tencent.mm.modelfriend.a)paramn).axz());
          paramString.putExtra("regsetinfo_user", this.iuh.dpO);
          paramString.putExtra("regsession_id", this.iuh.itd);
          paramString.putExtra("reg_3d_app_ticket", this.iuh.iuO);
          paramString.putExtra("reg_3d_app_type", this.iuh.itW);
          paramString.putExtra("regsetinfo_ismobile", 4);
          paramString.putExtra("regsetinfo_NextControl", ((com.tencent.mm.modelfriend.a)paramn).axG());
          paramString.putExtra("key_reg_style", this.iuh.itU);
          paramString.setClass(this.iuh, RegSetInfoUI.class);
          paramn = this.iuh;
          paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.adn(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramn.startActivity((Intent)paramString.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.account.model.l.a(l.a.iou);
        }
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -35)
      {
        paramString = com.tencent.mm.h.a.oG(paramString);
        this.iqH.dVG = this.iuh.itW;
        this.iqH.dFd = 7L;
        this.iqH.aBj();
        if (paramString != null)
        {
          paramString.a(this.iuh, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128433);
              com.tencent.mm.kernel.g.aeS().a(701, o.this);
              com.tencent.mm.kernel.g.aeS().a(252, o.this);
              o.this.irj = new g(new g.a()
              {
                public final void a(ProgressDialog paramAnonymous2ProgressDialog)
                {
                  o.this.iuh.fpP = paramAnonymous2ProgressDialog;
                }
              }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).axy(), o.this.iuh.dpO);
              o.this.irj.a(o.this.iuh);
              o.this.iqH.dVG = o.this.iuh.itW;
              o.this.iqH.dFd = 8L;
              o.this.iqH.aBj();
              AppMethodBeat.o(128433);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(128439);
          return;
        }
        h.a(this.iuh, this.iuh.getString(2131756444), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128434);
            com.tencent.mm.kernel.g.aeS().a(701, o.this);
            com.tencent.mm.kernel.g.aeS().a(252, o.this);
            o.this.irj = new g(new g.a()
            {
              public final void a(ProgressDialog paramAnonymous2ProgressDialog)
              {
                o.this.iuh.fpP = paramAnonymous2ProgressDialog;
              }
            }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).axy(), o.this.iuh.dpO);
            o.this.irj.a(o.this.iuh);
            o.this.iqH.dVG = o.this.iuh.itW;
            o.this.iqH.dFd = 8L;
            o.this.iqH.aBj();
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
        paramString = new Intent(this.iuh, MobileLoginOrForceReg.class);
        paramString.putExtra("ticket", ((com.tencent.mm.modelfriend.a)paramn).axz());
        paramString.putExtra("moble", this.iuh.dpO);
        paramString.putExtra("regsession_id", this.iuh.itd);
        paramString.putExtra("reg_3d_app_ticket", this.iuh.iuO);
        paramString.putExtra("reg_3d_app_type", this.iuh.itW);
        paramString.putExtra("next_controll", ((com.tencent.mm.modelfriend.a)paramn).axG());
        paramString.putExtra("username", ((com.tencent.mm.modelfriend.a)paramn).getUsername());
        paramString.putExtra("password", ((com.tencent.mm.modelfriend.a)paramn).axy());
        paramString.putExtra("nickname", ((com.tencent.mm.modelfriend.a)paramn).axM());
        paramString.putExtra("avatar_url", ((com.tencent.mm.modelfriend.a)paramn).axL());
        paramString.putExtra("key_reg_style", this.iuh.itU);
        if (this.iuh.itU == 1)
        {
          paramString.putExtra("kintent_nickname", this.iuh.bNK);
          paramString.putExtra("kintent_password", this.iuh.itM);
          paramString.putExtra("kintent_hasavatar", this.iuh.iuH);
        }
        paramn = this.iuh;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.adn(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramn.startActivity((Intent)paramString.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.oG(paramString);
        if (paramString != null)
        {
          paramString.a(this.iuh, null, null);
          AppMethodBeat.o(128439);
          return;
        }
        h.j(this.iuh, 2131756508, 2131756514);
        AppMethodBeat.o(128439);
      }
    }
    else if (paramn.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = this.iuh.iuH;
        localObject1 = this.iuh.itM;
        localObject2 = this.iuh.bNK;
        if (this.iuh.ijd == null)
        {
          this.iuh.ijd = SecurityImage.a.a(this.iuh, 0, ((u)paramn).aAL(), ((u)paramn).aAK(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128424);
              com.tencent.mm.kernel.g.aeS().a(126, o.this);
              paramAnonymousDialogInterface = new u("", this.itY, this.itZ, 0, "", o.this.iuh.dpO, "", "", o.this.iun, o.this.iuh.hsv, "", ((u)paramn).aAK(), o.this.iuh.ijd.getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.zd(o.this.iuh.itd);
              paramAnonymousDialogInterface.ze(o.this.iuh.iuO);
              com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI1 = o.this.iuh;
              MobileVerifyUI localMobileVerifyUI2 = o.this.iuh;
              o.this.iuh.getString(2131755906);
              localMobileVerifyUI1.fpP = h.b(localMobileVerifyUI2, o.this.iuh.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128423);
                  com.tencent.mm.kernel.g.aeS().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.aeS().b(126, o.this);
                  AppMethodBeat.o(128423);
                }
              });
              AppMethodBeat.o(128424);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              o.this.iuh.ijd = null;
            }
          }, new SecurityImage.b()
          {
            public final void aIs()
            {
              AppMethodBeat.i(128425);
              o.this.iuh.hideVKB();
              com.tencent.mm.kernel.g.aeS().a(126, o.this);
              u localu = new u("", this.itY, this.itZ, 0, "", o.this.iuh.dpO, "", "", o.this.iun, o.this.iuh.hsv, "", ((u)paramn).aAK(), "", true, paramString.booleanValue());
              localu.zd(o.this.iuh.itd);
              localu.ze(o.this.iuh.iuO);
              com.tencent.mm.kernel.g.aeS().a(localu, 0);
              AppMethodBeat.o(128425);
            }
          });
          AppMethodBeat.o(128439);
          return;
        }
        this.iuh.ijd.b(0, ((u)paramn).aAL(), ((u)paramn).aAK(), "");
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        str2 = this.iuh.dpO;
        localObject4 = this.iuh.iuH;
        this.iqH.dVG = this.iuh.itW;
        this.iqH.dFd = 6L;
        this.iqH.aBj();
        i = ((u)paramn).aAV();
        str1 = ((u)paramn).aAW();
        j = ((u)paramn).aAX();
        str3 = ((u)paramn).aAY();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = bw.K(str3, "wording");
        if (localMap == null) {
          break label2542;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!bt.isNullOrNil((String)localObject3)) {
          break label1976;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label2542;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!bt.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (bt.isNullOrNil((String)localObject3)) {
          break label2539;
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
      com.tencent.mm.kernel.a.dz(true);
      if (((Boolean)localObject4).booleanValue())
      {
        localObject3 = b.aio() + "temp.avatar";
        localObject4 = b.aio() + "temp.avatar.hd";
        i.lD((String)localObject3, (String)localObject4);
        i.deleteFile((String)localObject3);
        f.c((String)localObject4, 96, 96, Bitmap.CompressFormat.JPEG, 90, (String)localObject3);
        new com.tencent.mm.ak.n(this.iuh, b.aio() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128426);
            o.this.fsw = ((u)paramn).aAU();
            ay.gNa.aD("login_user_name", str2);
            i.deleteFile(b.aio() + "temp.avatar");
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.aUz("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(o.this.iuh, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", o.this.fsw);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
                localObject2 = com.tencent.mm.plugin.account.a.a.hYt.bA(o.this.iuh);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(o.this.iuh, (Intent)localObject1, (Intent)localObject2);
                o.this.iuh.finish();
                AppMethodBeat.o(128426);
                return;
                localObject1 = new Intent(o.this.iuh, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.iut);
                ((Intent)localObject1).putExtra("alert_message", this.iuu);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.hYt.bA(o.this.iuh);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = o.this.iuh;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.afz();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aeM()).append(",").append(o.this.iuh.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.g.afz();
            com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_900_phone") + ",4");
            o.this.iuh.finish();
            AppMethodBeat.o(128426);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128427);
            o.this.fsw = ((u)paramn).aAU();
            ay.gNa.aD("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.aUz("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(o.this.iuh, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", o.this.fsw);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
                localObject2 = com.tencent.mm.plugin.account.a.a.hYt.bA(o.this.iuh);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(o.this.iuh, (Intent)localObject1, (Intent)localObject2);
                o.this.iuh.finish();
                AppMethodBeat.o(128427);
                return;
                localObject1 = new Intent(o.this.iuh, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.iut);
                ((Intent)localObject1).putExtra("alert_message", this.iuu);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.hYt.bA(o.this.iuh);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = o.this.iuh;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.afz();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aeM()).append(",").append(o.this.iuh.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.g.afz();
            com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_900_phone") + ",4");
            o.this.iuh.finish();
            AppMethodBeat.o(128427);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.oG(paramString);
        if (localObject1 == null) {
          break label2417;
        }
        ((com.tencent.mm.h.a)localObject1).a(this.iuh, null, null);
        AppMethodBeat.o(128439);
        return;
        label1976:
        int k = bt.aGh((String)localObject3);
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
        this.fsw = ((u)paramn).aAU();
        ay.gNa.aD("login_user_name", str2);
        if ((str1 != null) && (str1.contains("0")))
        {
          com.tencent.mm.plugin.b.a.aUz("R300_100_phone");
          if (!bool1) {}
          for (localObject1 = new Intent(this.iuh, FindMContactIntroUI.class);; localObject1 = localObject3)
          {
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("regsetinfo_ticket", this.fsw);
            ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
            ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
            localObject2 = com.tencent.mm.plugin.account.a.a.hYt.bA(this.iuh);
            ((Intent)localObject2).addFlags(67108864);
            ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
            MMWizardActivity.b(this.iuh, (Intent)localObject1, (Intent)localObject2);
            this.iuh.finish();
            break;
            localObject3 = new Intent(this.iuh, FindMContactAlertUI.class);
            ((Intent)localObject3).putExtra("alert_title", (String)localObject1);
            ((Intent)localObject3).putExtra("alert_message", (String)localObject2);
          }
        }
        localObject2 = com.tencent.mm.plugin.account.a.a.hYt.bA(this.iuh);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = this.iuh;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.afz();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.aeM()).append(",").append(this.iuh.getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.g.afz();
        com.tencent.mm.plugin.b.a.pj(com.tencent.mm.kernel.a.qN("R200_900_phone") + ",4");
        this.iuh.finish();
      }
      label2417:
      if (this.iuh.n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramn.getType() == 252) || (paramn.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.oG(paramString);
        if ((paramString != null) && (paramString.a(this.iuh, null, null)))
        {
          AppMethodBeat.o(128439);
          return;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this.iuh, this.iuh.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(128439);
      return;
      label2539:
      continue;
      label2542:
      localObject1 = null;
      bool1 = bool2;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(128436);
    com.tencent.mm.kernel.g.aeS().a(126, this);
    AppMethodBeat.o(128436);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128437);
    com.tencent.mm.kernel.g.aeS().b(126, this);
    AppMethodBeat.o(128437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o
 * JD-Core Version:    0.7.0.1
 */