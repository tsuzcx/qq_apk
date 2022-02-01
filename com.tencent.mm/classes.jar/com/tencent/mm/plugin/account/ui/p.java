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
import com.tencent.mm.am.o;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.ms;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.model.l;
import com.tencent.mm.plugin.account.model.l.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import java.util.Map;

public final class p
  implements i, MobileVerifyUI.b
{
  private String jaS;
  private ms ncO;
  private h ndp;
  private MobileVerifyUI ngs;
  private String ngy;
  private boolean ngz;
  
  public p()
  {
    AppMethodBeat.i(128435);
    this.ndp = null;
    this.ngz = true;
    this.ncO = new ms();
    AppMethodBeat.o(128435);
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.ngs = paramMobileVerifyUI;
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128438);
    switch (8.ngw[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128438);
      return false;
      com.tencent.mm.ui.base.h.c(this.ngs, this.ngs.getString(r.j.mobile_verify_cancel_tip), "", this.ngs.getString(r.j.mobile_verify_cancel_tip_back), this.ngs.getString(r.j.mobile_verify_cancel_tip_wait), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(128430);
          p.a(p.this).finish();
          l.a(l.a.nac);
          AppMethodBeat.o(128430);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128438);
      return true;
      com.tencent.mm.kernel.h.aGY().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.ngs.fLC, 15, this.ngs.mSy.getText().toString().trim(), 0, "");
      parama.VH(this.ngs.nfm);
      com.tencent.mm.kernel.h.aGY().a(parama, 0);
      MobileVerifyUI localMobileVerifyUI1 = this.ngs;
      MobileVerifyUI localMobileVerifyUI2 = this.ngs;
      this.ngs.getString(r.j.app_tip);
      localMobileVerifyUI1.iXX = com.tencent.mm.ui.base.h.a(localMobileVerifyUI2, this.ngs.getString(r.j.bind_mcontact_verifing), true, new p.11(this, parama));
      continue;
      com.tencent.mm.kernel.h.aGY().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.ngs.fLC, 14, "", 0, "");
      parama.VH(this.ngs.nfm);
      com.tencent.mm.kernel.h.aGY().a(parama, 0);
      l.a(l.a.nad);
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      parama = parama.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",R200_350_auto,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_350_auto") + ",1");
      com.tencent.mm.kernel.h.aGY().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.ngs.fLC, 15, this.ngs.mSy.getText().toString().trim(), 0, "");
      parama.VH(this.ngs.nfm);
      com.tencent.mm.kernel.h.aGY().a(parama, 0);
      localMobileVerifyUI1 = this.ngs;
      localMobileVerifyUI2 = this.ngs;
      this.ngs.getString(r.j.app_tip);
      localMobileVerifyUI1.iXX = com.tencent.mm.ui.base.h.a(localMobileVerifyUI2, this.ngs.getString(r.j.bind_mcontact_verifing), true, new p.1(this, parama));
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final q paramq)
  {
    AppMethodBeat.i(128439);
    Log.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.ngs.iXX != null)
    {
      this.ngs.iXX.dismiss();
      this.ngs.iXX = null;
    }
    if (paramq.getType() == 255)
    {
      com.tencent.mm.kernel.h.aGY().b(255, this);
      if ((paramInt2 == -3) && (paramInt1 == 4)) {
        this.ngs.hc(this.ngz);
      }
      AppMethodBeat.o(128439);
      return;
    }
    Object localObject1;
    if (((paramq.getType() == 701) || (paramq.getType() == 701)) && (this.ndp != null))
    {
      com.tencent.mm.kernel.h.aGY().b(701, this);
      com.tencent.mm.kernel.h.aGY().b(252, this);
      this.ndp.a(this.ngs, paramInt1, paramInt2, paramString, paramq);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramq instanceof com.tencent.mm.modelsimple.t)) {
          this.ngz = ((com.tencent.mm.modelsimple.t)paramq).boK();
        }
        com.tencent.mm.kernel.h.aGY().a(255, this);
        paramString = new com.tencent.mm.modelsimple.u(1);
        com.tencent.mm.kernel.h.aGY().a(paramString, 0);
        paramq = this.ngs;
        localObject1 = this.ngs;
        this.ngs.getString(r.j.app_tip);
        paramq.iXX = com.tencent.mm.ui.base.h.a((Context)localObject1, this.ngs.getString(r.j.app_loading), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128432);
            com.tencent.mm.kernel.h.aGY().a(paramString);
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
    if (paramq.getType() == 145)
    {
      com.tencent.mm.kernel.h.aGY().b(145, this);
      i = ((com.tencent.mm.modelfriend.a)paramq).ZB();
      if (i != 15)
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 15)
        {
          if (this.ngs.ngf == 1)
          {
            this.ngy = ((com.tencent.mm.modelfriend.a)paramq).bkW();
            com.tencent.mm.kernel.h.aGY().a(126, this);
            paramString = new v("", this.ngs.nfX, this.ngs.nickName, 0, "", this.ngs.fLC, "", "", this.ngy, this.ngs.mam, "", "", "", true, this.ngs.ngR.booleanValue());
            paramString.WZ(this.ngs.nfm);
            paramString.Xa(this.ngs.ngY);
            com.tencent.mm.kernel.h.aGY().a(paramString, 0);
            paramq = this.ngs;
            localObject1 = this.ngs;
            this.ngs.getString(r.j.app_tip);
            paramq.iXX = com.tencent.mm.ui.base.h.a((Context)localObject1, this.ngs.getString(r.j.regbyqq_reg_waiting), true, new p.7(this, paramString));
            AppMethodBeat.o(128439);
            return;
          }
          paramString = new Intent();
          paramString.putExtra("regsetinfo_ticket", ((com.tencent.mm.modelfriend.a)paramq).bkW());
          paramString.putExtra("regsetinfo_user", this.ngs.fLC);
          paramString.putExtra("regsession_id", this.ngs.nfm);
          paramString.putExtra("reg_3d_app_ticket", this.ngs.ngY);
          paramString.putExtra("reg_3d_app_type", this.ngs.ngh);
          paramString.putExtra("regsetinfo_ismobile", 4);
          paramString.putExtra("regsetinfo_NextControl", ((com.tencent.mm.modelfriend.a)paramq).bld());
          paramString.putExtra("key_reg_style", this.ngs.ngf);
          paramString.setClass(this.ngs, RegSetInfoUI.class);
          paramq = this.ngs;
          paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(paramq, paramString.aFh(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramq.startActivity((Intent)paramString.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramq, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          l.a(l.a.nae);
        }
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -35)
      {
        paramString = com.tencent.mm.h.a.Kb(paramString);
        this.ncO.gVr = this.ngs.ngh;
        this.ncO.gef = 7L;
        this.ncO.bpa();
        if (paramString != null)
        {
          paramString.a(this.ngs, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128433);
              com.tencent.mm.kernel.h.aGY().a(701, p.this);
              com.tencent.mm.kernel.h.aGY().a(252, p.this);
              p.a(p.this, new h(new h.a()
              {
                public final void a(ProgressDialog paramAnonymous2ProgressDialog)
                {
                  AppMethodBeat.i(218520);
                  p.a(p.this).iXX = paramAnonymous2ProgressDialog;
                  AppMethodBeat.o(218520);
                }
              }, ((com.tencent.mm.modelfriend.a)paramq).getUsername(), ((com.tencent.mm.modelfriend.a)paramq).bkV(), p.a(p.this).fLC));
              p.b(p.this).c(p.a(p.this));
              p.c(p.this).gVr = p.a(p.this).ngh;
              p.c(p.this).gef = 8L;
              p.c(p.this).bpa();
              AppMethodBeat.o(128433);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(128439);
          return;
        }
        com.tencent.mm.ui.base.h.a(this.ngs, this.ngs.getString(r.j.bind_mcontact_already_bind_relogin), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128434);
            com.tencent.mm.kernel.h.aGY().a(701, p.this);
            com.tencent.mm.kernel.h.aGY().a(252, p.this);
            p.a(p.this, new h(new h.a()
            {
              public final void a(ProgressDialog paramAnonymous2ProgressDialog)
              {
                AppMethodBeat.i(214222);
                p.a(p.this).iXX = paramAnonymous2ProgressDialog;
                AppMethodBeat.o(214222);
              }
            }, ((com.tencent.mm.modelfriend.a)paramq).getUsername(), ((com.tencent.mm.modelfriend.a)paramq).bkV(), p.a(p.this).fLC));
            p.b(p.this).c(p.a(p.this));
            p.c(p.this).gVr = p.a(p.this).ngh;
            p.c(p.this).gef = 8L;
            p.c(p.this).bpa();
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
        paramString = new Intent(this.ngs, MobileLoginOrForceReg.class);
        paramString.putExtra("ticket", ((com.tencent.mm.modelfriend.a)paramq).bkW());
        paramString.putExtra("moble", this.ngs.fLC);
        paramString.putExtra("regsession_id", this.ngs.nfm);
        paramString.putExtra("reg_3d_app_ticket", this.ngs.ngY);
        paramString.putExtra("reg_3d_app_type", this.ngs.ngh);
        paramString.putExtra("next_controll", ((com.tencent.mm.modelfriend.a)paramq).bld());
        paramString.putExtra("username", ((com.tencent.mm.modelfriend.a)paramq).getUsername());
        paramString.putExtra("password", ((com.tencent.mm.modelfriend.a)paramq).bkV());
        paramString.putExtra("nickname", ((com.tencent.mm.modelfriend.a)paramq).blj());
        paramString.putExtra("avatar_url", ((com.tencent.mm.modelfriend.a)paramq).bli());
        paramString.putExtra("key_reg_style", this.ngs.ngf);
        if (this.ngs.ngf == 1)
        {
          paramString.putExtra("kintent_nickname", this.ngs.nickName);
          paramString.putExtra("kintent_password", this.ngs.nfX);
          paramString.putExtra("kintent_hasavatar", this.ngs.ngR);
        }
        paramq = this.ngs;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(paramq, paramString.aFh(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramq.startActivity((Intent)paramString.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramq, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.Kb(paramString);
        if (paramString != null)
        {
          paramString.a(this.ngs, null, null);
          AppMethodBeat.o(128439);
          return;
        }
        com.tencent.mm.ui.base.h.p(this.ngs, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip);
        AppMethodBeat.o(128439);
      }
    }
    else if (paramq.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = this.ngs.ngR;
        localObject1 = this.ngs.nfX;
        localObject2 = this.ngs.nickName;
        if (this.ngs.mUP == null)
        {
          this.ngs.mUP = SecurityImage.a.a(this.ngs, r.j.regbyqq_secimg_title, 0, ((v)paramq).boC(), ((v)paramq).boB(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128424);
              com.tencent.mm.kernel.h.aGY().a(126, p.this);
              paramAnonymousDialogInterface = new v("", this.ngj, this.ngk, 0, "", p.a(p.this).fLC, "", "", p.d(p.this), p.a(p.this).mam, "", ((v)paramq).boB(), p.a(p.this).mUP.getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.WZ(p.a(p.this).nfm);
              paramAnonymousDialogInterface.Xa(p.a(p.this).ngY);
              com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI1 = p.a(p.this);
              MobileVerifyUI localMobileVerifyUI2 = p.a(p.this);
              p.a(p.this).getString(r.j.app_tip);
              localMobileVerifyUI1.iXX = com.tencent.mm.ui.base.h.a(localMobileVerifyUI2, p.a(p.this).getString(r.j.regbyqq_reg_waiting), true, new p.2.1(this, paramAnonymousDialogInterface));
              AppMethodBeat.o(128424);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(219584);
              p.a(p.this).mUP = null;
              AppMethodBeat.o(219584);
            }
          }, new SecurityImage.b()
          {
            public final void bxQ()
            {
              AppMethodBeat.i(128425);
              p.a(p.this).hideVKB();
              com.tencent.mm.kernel.h.aGY().a(126, p.this);
              v localv = new v("", this.ngj, this.ngk, 0, "", p.a(p.this).fLC, "", "", p.d(p.this), p.a(p.this).mam, "", ((v)paramq).boB(), "", true, paramString.booleanValue());
              localv.WZ(p.a(p.this).nfm);
              localv.Xa(p.a(p.this).ngY);
              com.tencent.mm.kernel.h.aGY().a(localv, 0);
              AppMethodBeat.o(128425);
            }
          });
          AppMethodBeat.o(128439);
          return;
        }
        this.ngs.mUP.b(0, ((v)paramq).boC(), ((v)paramq).boB(), "");
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        str2 = this.ngs.fLC;
        localObject4 = this.ngs.ngR;
        this.ncO.gVr = this.ngs.ngh;
        this.ncO.gef = 6L;
        this.ncO.bpa();
        i = ((v)paramq).boM();
        str1 = ((v)paramq).boN();
        j = ((v)paramq).boO();
        str3 = ((v)paramq).boP();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = XmlParser.parseXml(str3, "wording", null);
        if (localMap == null) {
          break label2577;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!Util.isNullOrNil((String)localObject3)) {
          break label2008;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label2577;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!Util.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (Util.isNullOrNil((String)localObject3)) {
          break label2574;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", new Object[] { localObject4 });
      Log.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", new Object[] { Integer.valueOf(i) });
      Log.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", new Object[] { str1 });
      Log.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", new Object[] { Integer.valueOf(j) });
      Log.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.b.aGG();
      com.tencent.mm.kernel.b.eQ(true);
      if (((Boolean)localObject4).booleanValue())
      {
        localObject3 = com.tencent.mm.loader.j.b.aST() + "temp.avatar";
        localObject4 = com.tencent.mm.loader.j.b.aST() + "temp.avatar.hd";
        com.tencent.mm.vfs.u.oo((String)localObject3, (String)localObject4);
        com.tencent.mm.vfs.u.deleteFile((String)localObject3);
        BitmapUtil.createThumbNail((String)localObject4, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject3, true);
        new o(this.ngs, com.tencent.mm.loader.j.b.aST() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128426);
            p.a(p.this, ((v)paramq).boL());
            bg.ltv.aS("login_user_name", str2);
            com.tencent.mm.vfs.u.deleteFile(com.tencent.mm.loader.j.b.aST() + "temp.avatar");
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.bkD("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(p.a(p.this), FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", p.e(p.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
                localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(p.a(p.this));
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(p.a(p.this), (Intent)localObject1, (Intent)localObject2);
                p.a(p.this).finish();
                AppMethodBeat.o(128426);
                return;
                localObject1 = new Intent(p.a(p.this), FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.ngE);
                ((Intent)localObject1).putExtra("alert_message", this.ngF);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(p.a(p.this));
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = p.a(p.this);
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.aHE();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aGR()).append(",").append(p.a(p.this).getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.h.aHE();
            com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_900_phone") + ",4");
            p.a(p.this).finish();
            AppMethodBeat.o(128426);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128427);
            p.a(p.this, ((v)paramq).boL());
            bg.ltv.aS("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.bkD("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(p.a(p.this), FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", p.e(p.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
                localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(p.a(p.this));
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(p.a(p.this), (Intent)localObject1, (Intent)localObject2);
                p.a(p.this).finish();
                AppMethodBeat.o(128427);
                return;
                localObject1 = new Intent(p.a(p.this), FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.ngE);
                ((Intent)localObject1).putExtra("alert_message", this.ngF);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(p.a(p.this));
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = p.a(p.this);
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.aHE();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aGR()).append(",").append(p.a(p.this).getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.h.aHE();
            com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_900_phone") + ",4");
            p.a(p.this).finish();
            AppMethodBeat.o(128427);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.Kb(paramString);
        if (localObject1 == null) {
          break label2449;
        }
        ((com.tencent.mm.h.a)localObject1).a(this.ngs, null, null);
        AppMethodBeat.o(128439);
        return;
        label2008:
        int k = Util.safeParseInt((String)localObject3);
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
        this.jaS = ((v)paramq).boL();
        bg.ltv.aS("login_user_name", str2);
        if ((str1 != null) && (str1.contains("0")))
        {
          com.tencent.mm.plugin.b.a.bkD("R300_100_phone");
          if (!bool1) {}
          for (localObject1 = new Intent(this.ngs, FindMContactIntroUI.class);; localObject1 = localObject3)
          {
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("regsetinfo_ticket", this.jaS);
            ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
            ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
            localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this.ngs);
            ((Intent)localObject2).addFlags(67108864);
            ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
            MMWizardActivity.b(this.ngs, (Intent)localObject1, (Intent)localObject2);
            this.ngs.finish();
            break;
            localObject3 = new Intent(this.ngs, FindMContactAlertUI.class);
            ((Intent)localObject3).putExtra("alert_title", (String)localObject1);
            ((Intent)localObject3).putExtra("alert_message", (String)localObject2);
          }
        }
        localObject2 = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this.ngs);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = this.ngs;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aGR()).append(",").append(this.ngs.getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("R200_900_phone") + ",4");
        this.ngs.finish();
      }
      label2449:
      if (this.ngs.n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramq.getType() == 252) || (paramq.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.Kb(paramString);
        if ((paramString != null) && (paramString.a(this.ngs, null, null)))
        {
          AppMethodBeat.o(128439);
          return;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this.ngs, this.ngs.getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(128439);
      return;
      label2574:
      continue;
      label2577:
      localObject1 = null;
      bool1 = bool2;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(128436);
    com.tencent.mm.kernel.h.aGY().a(126, this);
    AppMethodBeat.o(128436);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128437);
    com.tencent.mm.kernel.h.aGY().b(126, this);
    com.tencent.mm.kernel.h.aGY().b(145, this);
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    com.tencent.mm.kernel.h.aGY().b(255, this);
    AppMethodBeat.o(128437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.p
 * JD-Core Version:    0.7.0.1
 */