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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.gm;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bb;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.model.l;
import com.tencent.mm.plugin.account.model.l.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import java.util.Map;

public final class o
  implements f, MobileVerifyUI.b
{
  String fRw;
  gm jmP;
  g jnr;
  MobileVerifyUI jqo;
  String jqu;
  private boolean jqv;
  
  public o()
  {
    AppMethodBeat.i(128435);
    this.jnr = null;
    this.jqv = true;
    this.jmP = new gm();
    AppMethodBeat.o(128435);
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.jqo = paramMobileVerifyUI;
  }
  
  public final boolean a(final MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128438);
    switch (8.jqs[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128438);
      return false;
      com.tencent.mm.ui.base.h.e(this.jqo, this.jqo.getString(2131761297), "", this.jqo.getString(2131761298), this.jqo.getString(2131761299), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(128430);
          o.this.jqo.finish();
          l.a(l.a.jkA);
          AppMethodBeat.o(128430);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128438);
      return true;
      com.tencent.mm.kernel.g.ajj().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.jqo.dAs, 15, this.jqo.jda.getText().toString().trim(), 0, "");
      parama.Fz(this.jqo.jpk);
      com.tencent.mm.kernel.g.ajj().a(parama, 0);
      MobileVerifyUI localMobileVerifyUI1 = this.jqo;
      MobileVerifyUI localMobileVerifyUI2 = this.jqo;
      this.jqo.getString(2131755906);
      localMobileVerifyUI1.fOC = com.tencent.mm.ui.base.h.b(localMobileVerifyUI2, this.jqo.getString(2131756503), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128431);
          com.tencent.mm.kernel.g.ajj().a(parama);
          com.tencent.mm.kernel.g.ajj().b(145, o.this);
          AppMethodBeat.o(128431);
        }
      });
      continue;
      com.tencent.mm.kernel.g.ajj().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.jqo.dAs, 14, "", 0, "");
      parama.Fz(this.jqo.jpk);
      com.tencent.mm.kernel.g.ajj().a(parama, 0);
      l.a(l.a.jkB);
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.g.ajP();
      parama = parama.append(com.tencent.mm.kernel.a.ajd()).append(",").append(getClass().getName()).append(",R200_350_auto,");
      com.tencent.mm.kernel.g.ajP();
      com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_350_auto") + ",1");
      com.tencent.mm.kernel.g.ajj().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.jqo.dAs, 15, this.jqo.jda.getText().toString().trim(), 0, "");
      parama.Fz(this.jqo.jpk);
      com.tencent.mm.kernel.g.ajj().a(parama, 0);
      localMobileVerifyUI1 = this.jqo;
      localMobileVerifyUI2 = this.jqo;
      this.jqo.getString(2131755906);
      localMobileVerifyUI1.fOC = com.tencent.mm.ui.base.h.b(localMobileVerifyUI2, this.jqo.getString(2131756503), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128422);
          com.tencent.mm.kernel.g.ajj().a(parama);
          com.tencent.mm.kernel.g.ajj().b(145, o.this);
          AppMethodBeat.o(128422);
        }
      });
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(128439);
    ae.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.jqo.fOC != null)
    {
      this.jqo.fOC.dismiss();
      this.jqo.fOC = null;
    }
    if (paramn.getType() == 255)
    {
      com.tencent.mm.kernel.g.ajj().b(255, this);
      if ((paramInt2 == -3) && (paramInt1 == 4)) {
        this.jqo.fx(this.jqv);
      }
      AppMethodBeat.o(128439);
      return;
    }
    Object localObject1;
    if (((paramn.getType() == 701) || (paramn.getType() == 701)) && (this.jnr != null))
    {
      com.tencent.mm.kernel.g.ajj().b(701, this);
      com.tencent.mm.kernel.g.ajj().b(252, this);
      this.jnr.a(this.jqo, paramInt1, paramInt2, paramString, paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramn instanceof t)) {
          this.jqv = ((t)paramn).aLr();
        }
        com.tencent.mm.kernel.g.ajj().a(255, this);
        paramString = new u(1);
        com.tencent.mm.kernel.g.ajj().a(paramString, 0);
        paramn = this.jqo;
        localObject1 = this.jqo;
        this.jqo.getString(2131755906);
        paramn.fOC = com.tencent.mm.ui.base.h.b((Context)localObject1, this.jqo.getString(2131755804), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128432);
            com.tencent.mm.kernel.g.ajj().a(paramString);
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
      com.tencent.mm.kernel.g.ajj().b(145, this);
      i = ((com.tencent.mm.modelfriend.a)paramn).KZ();
      if (i != 15)
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 15)
        {
          if (this.jqo.jqb == 1)
          {
            this.jqu = ((com.tencent.mm.modelfriend.a)paramn).aHN();
            com.tencent.mm.kernel.g.ajj().a(126, this);
            paramString = new v("", this.jqo.jpT, this.jqo.bVF, 0, "", this.jqo.dAs, "", "", this.jqu, this.jqo.ipi, "", "", "", true, this.jqo.jqO.booleanValue());
            paramString.GP(this.jqo.jpk);
            paramString.GQ(this.jqo.jqV);
            com.tencent.mm.kernel.g.ajj().a(paramString, 0);
            paramn = this.jqo;
            localObject1 = this.jqo;
            this.jqo.getString(2131755906);
            paramn.fOC = com.tencent.mm.ui.base.h.b((Context)localObject1, this.jqo.getString(2131762385), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(128428);
                com.tencent.mm.kernel.g.ajj().a(paramString);
                com.tencent.mm.kernel.g.ajj().b(126, o.this);
                AppMethodBeat.o(128428);
              }
            });
            AppMethodBeat.o(128439);
            return;
          }
          paramString = new Intent();
          paramString.putExtra("regsetinfo_ticket", ((com.tencent.mm.modelfriend.a)paramn).aHN());
          paramString.putExtra("regsetinfo_user", this.jqo.dAs);
          paramString.putExtra("regsession_id", this.jqo.jpk);
          paramString.putExtra("reg_3d_app_ticket", this.jqo.jqV);
          paramString.putExtra("reg_3d_app_type", this.jqo.jqd);
          paramString.putExtra("regsetinfo_ismobile", 4);
          paramString.putExtra("regsetinfo_NextControl", ((com.tencent.mm.modelfriend.a)paramn).aHU());
          paramString.putExtra("key_reg_style", this.jqo.jqb);
          paramString.setClass(this.jqo, RegSetInfoUI.class);
          paramn = this.jqo;
          paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.ahE(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramn.startActivity((Intent)paramString.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          l.a(l.a.jkC);
        }
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -35)
      {
        paramString = com.tencent.mm.h.a.uU(paramString);
        this.jmP.epA = this.jqo.jqd;
        this.jmP.dQB = 7L;
        this.jmP.aLH();
        if (paramString != null)
        {
          paramString.a(this.jqo, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128433);
              com.tencent.mm.kernel.g.ajj().a(701, o.this);
              com.tencent.mm.kernel.g.ajj().a(252, o.this);
              o.this.jnr = new g(new g.a()
              {
                public final void a(ProgressDialog paramAnonymous2ProgressDialog)
                {
                  o.this.jqo.fOC = paramAnonymous2ProgressDialog;
                }
              }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aHM(), o.this.jqo.dAs);
              o.this.jnr.b(o.this.jqo);
              o.this.jmP.epA = o.this.jqo.jqd;
              o.this.jmP.dQB = 8L;
              o.this.jmP.aLH();
              AppMethodBeat.o(128433);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(128439);
          return;
        }
        com.tencent.mm.ui.base.h.a(this.jqo, this.jqo.getString(2131756444), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128434);
            com.tencent.mm.kernel.g.ajj().a(701, o.this);
            com.tencent.mm.kernel.g.ajj().a(252, o.this);
            o.this.jnr = new g(new g.a()
            {
              public final void a(ProgressDialog paramAnonymous2ProgressDialog)
              {
                o.this.jqo.fOC = paramAnonymous2ProgressDialog;
              }
            }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aHM(), o.this.jqo.dAs);
            o.this.jnr.b(o.this.jqo);
            o.this.jmP.epA = o.this.jqo.jqd;
            o.this.jmP.dQB = 8L;
            o.this.jmP.aLH();
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
        paramString = new Intent(this.jqo, MobileLoginOrForceReg.class);
        paramString.putExtra("ticket", ((com.tencent.mm.modelfriend.a)paramn).aHN());
        paramString.putExtra("moble", this.jqo.dAs);
        paramString.putExtra("regsession_id", this.jqo.jpk);
        paramString.putExtra("reg_3d_app_ticket", this.jqo.jqV);
        paramString.putExtra("reg_3d_app_type", this.jqo.jqd);
        paramString.putExtra("next_controll", ((com.tencent.mm.modelfriend.a)paramn).aHU());
        paramString.putExtra("username", ((com.tencent.mm.modelfriend.a)paramn).getUsername());
        paramString.putExtra("password", ((com.tencent.mm.modelfriend.a)paramn).aHM());
        paramString.putExtra("nickname", ((com.tencent.mm.modelfriend.a)paramn).aIa());
        paramString.putExtra("avatar_url", ((com.tencent.mm.modelfriend.a)paramn).aHZ());
        paramString.putExtra("key_reg_style", this.jqo.jqb);
        if (this.jqo.jqb == 1)
        {
          paramString.putExtra("kintent_nickname", this.jqo.bVF);
          paramString.putExtra("kintent_password", this.jqo.jpT);
          paramString.putExtra("kintent_hasavatar", this.jqo.jqO);
        }
        paramn = this.jqo;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.ahE(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramn.startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.uU(paramString);
        if (paramString != null)
        {
          paramString.a(this.jqo, null, null);
          AppMethodBeat.o(128439);
          return;
        }
        com.tencent.mm.ui.base.h.l(this.jqo, 2131756508, 2131756514);
        AppMethodBeat.o(128439);
      }
    }
    else if (paramn.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = this.jqo.jqO;
        localObject1 = this.jqo.jpT;
        localObject2 = this.jqo.bVF;
        if (this.jqo.jfm == null)
        {
          this.jqo.jfm = SecurityImage.a.a(this.jqo, 0, ((v)paramn).aLj(), ((v)paramn).aLi(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128424);
              com.tencent.mm.kernel.g.ajj().a(126, o.this);
              paramAnonymousDialogInterface = new v("", this.jqf, this.jqg, 0, "", o.this.jqo.dAs, "", "", o.this.jqu, o.this.jqo.ipi, "", ((v)paramn).aLi(), o.this.jqo.jfm.getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.GP(o.this.jqo.jpk);
              paramAnonymousDialogInterface.GQ(o.this.jqo.jqV);
              com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI1 = o.this.jqo;
              MobileVerifyUI localMobileVerifyUI2 = o.this.jqo;
              o.this.jqo.getString(2131755906);
              localMobileVerifyUI1.fOC = com.tencent.mm.ui.base.h.b(localMobileVerifyUI2, o.this.jqo.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128423);
                  com.tencent.mm.kernel.g.ajj().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.ajj().b(126, o.this);
                  AppMethodBeat.o(128423);
                }
              });
              AppMethodBeat.o(128424);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              o.this.jqo.jfm = null;
            }
          }, new SecurityImage.b()
          {
            public final void aSU()
            {
              AppMethodBeat.i(128425);
              o.this.jqo.hideVKB();
              com.tencent.mm.kernel.g.ajj().a(126, o.this);
              v localv = new v("", this.jqf, this.jqg, 0, "", o.this.jqo.dAs, "", "", o.this.jqu, o.this.jqo.ipi, "", ((v)paramn).aLi(), "", true, paramString.booleanValue());
              localv.GP(o.this.jqo.jpk);
              localv.GQ(o.this.jqo.jqV);
              com.tencent.mm.kernel.g.ajj().a(localv, 0);
              AppMethodBeat.o(128425);
            }
          });
          AppMethodBeat.o(128439);
          return;
        }
        this.jqo.jfm.b(0, ((v)paramn).aLj(), ((v)paramn).aLi(), "");
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        str2 = this.jqo.dAs;
        localObject4 = this.jqo.jqO;
        this.jmP.epA = this.jqo.jqd;
        this.jmP.dQB = 6L;
        this.jmP.aLH();
        i = ((v)paramn).aLt();
        str1 = ((v)paramn).aLu();
        j = ((v)paramn).aLv();
        str3 = ((v)paramn).aLw();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = bx.M(str3, "wording");
        if (localMap == null) {
          break label2544;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!bu.isNullOrNil((String)localObject3)) {
          break label1978;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label2544;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!bu.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (bu.isNullOrNil((String)localObject3)) {
          break label2541;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", new Object[] { localObject4 });
      ae.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", new Object[] { Integer.valueOf(i) });
      ae.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", new Object[] { str1 });
      ae.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", new Object[] { Integer.valueOf(j) });
      ae.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.kernel.a.dC(true);
      if (((Boolean)localObject4).booleanValue())
      {
        localObject3 = b.asr() + "temp.avatar";
        localObject4 = b.asr() + "temp.avatar.hd";
        com.tencent.mm.vfs.o.mG((String)localObject3, (String)localObject4);
        com.tencent.mm.vfs.o.deleteFile((String)localObject3);
        com.tencent.mm.sdk.platformtools.h.c((String)localObject4, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject3);
        new com.tencent.mm.aj.n(this.jqo, b.asr() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128426);
            o.this.fRw = ((v)paramn).aLs();
            bb.hIK.aM("login_user_name", str2);
            com.tencent.mm.vfs.o.deleteFile(b.asr() + "temp.avatar");
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.KB("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(o.this.jqo, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", o.this.fRw);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
                localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(o.this.jqo);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(o.this.jqo, (Intent)localObject1, (Intent)localObject2);
                o.this.jqo.finish();
                AppMethodBeat.o(128426);
                return;
                localObject1 = new Intent(o.this.jqo, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.jqA);
                ((Intent)localObject1).putExtra("alert_message", this.jqB);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(o.this.jqo);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = o.this.jqo;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.ajP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(o.this.jqo.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.g.ajP();
            com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_900_phone") + ",4");
            o.this.jqo.finish();
            AppMethodBeat.o(128426);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128427);
            o.this.fRw = ((v)paramn).aLs();
            bb.hIK.aM("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.KB("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(o.this.jqo, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", o.this.fRw);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
                localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(o.this.jqo);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(o.this.jqo, (Intent)localObject1, (Intent)localObject2);
                o.this.jqo.finish();
                AppMethodBeat.o(128427);
                return;
                localObject1 = new Intent(o.this.jqo, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.jqA);
                ((Intent)localObject1).putExtra("alert_message", this.jqB);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(o.this.jqo);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = o.this.jqo;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.ajP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(o.this.jqo.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.g.ajP();
            com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_900_phone") + ",4");
            o.this.jqo.finish();
            AppMethodBeat.o(128427);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.uU(paramString);
        if (localObject1 == null) {
          break label2419;
        }
        ((com.tencent.mm.h.a)localObject1).a(this.jqo, null, null);
        AppMethodBeat.o(128439);
        return;
        label1978:
        int k = bu.aSB((String)localObject3);
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
        this.fRw = ((v)paramn).aLs();
        bb.hIK.aM("login_user_name", str2);
        if ((str1 != null) && (str1.contains("0")))
        {
          com.tencent.mm.plugin.b.a.KB("R300_100_phone");
          if (!bool1) {}
          for (localObject1 = new Intent(this.jqo, FindMContactIntroUI.class);; localObject1 = localObject3)
          {
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("regsetinfo_ticket", this.fRw);
            ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
            ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
            localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(this.jqo);
            ((Intent)localObject2).addFlags(67108864);
            ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
            MMWizardActivity.b(this.jqo, (Intent)localObject1, (Intent)localObject2);
            this.jqo.finish();
            break;
            localObject3 = new Intent(this.jqo, FindMContactAlertUI.class);
            ((Intent)localObject3).putExtra("alert_title", (String)localObject1);
            ((Intent)localObject3).putExtra("alert_message", (String)localObject2);
          }
        }
        localObject2 = com.tencent.mm.plugin.account.a.a.iUz.bE(this.jqo);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = this.jqo;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.ajP();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.ajd()).append(",").append(this.jqo.getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.g.ajP();
        com.tencent.mm.plugin.b.a.vG(com.tencent.mm.kernel.a.xB("R200_900_phone") + ",4");
        this.jqo.finish();
      }
      label2419:
      if (this.jqo.n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramn.getType() == 252) || (paramn.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.uU(paramString);
        if ((paramString != null) && (paramString.a(this.jqo, null, null)))
        {
          AppMethodBeat.o(128439);
          return;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this.jqo, this.jqo.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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
    com.tencent.mm.kernel.g.ajj().a(126, this);
    AppMethodBeat.o(128436);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128437);
    com.tencent.mm.kernel.g.ajj().b(126, this);
    AppMethodBeat.o(128437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o
 * JD-Core Version:    0.7.0.1
 */