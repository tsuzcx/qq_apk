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
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.mmdata.rpt.pu;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.o;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
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
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;
import java.util.Map;

public final class p
  implements com.tencent.mm.am.h, MobileVerifyUI.b
{
  private String lCS;
  private h qaG;
  private pu qbY;
  private MobileVerifyUI qdA;
  private String qdG;
  private boolean qdH;
  
  public p()
  {
    AppMethodBeat.i(128435);
    this.qaG = null;
    this.qdH = true;
    this.qbY = new pu();
    AppMethodBeat.o(128435);
  }
  
  private static void bYr()
  {
    AppMethodBeat.i(304979);
    if (cj.onp)
    {
      cj.ono.Kc(z.bAM());
      cj.ono.g(z.bAM(), z.bBM());
      cj.onp = false;
    }
    AppMethodBeat.o(304979);
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.qdA = paramMobileVerifyUI;
  }
  
  public final boolean a(final MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128438);
    switch (8.qdE[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128438);
      return false;
      k.b(this.qdA, this.qdA.getString(r.j.mobile_verify_cancel_tip), "", this.qdA.getString(r.j.mobile_verify_cancel_tip_back), this.qdA.getString(r.j.mobile_verify_cancel_tip_wait), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(128430);
          p.a(p.this).finish();
          com.tencent.mm.plugin.account.model.l.a(l.a.pWL);
          AppMethodBeat.o(128430);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128438);
      return true;
      com.tencent.mm.kernel.h.aZW().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.qdA.hRk, 15, this.qdA.pPd.getText().toString().trim(), 0, "");
      parama.NH(this.qdA.qcu);
      com.tencent.mm.kernel.h.aZW().a(parama, 0);
      MobileVerifyUI localMobileVerifyUI1 = this.qdA;
      MobileVerifyUI localMobileVerifyUI2 = this.qdA;
      this.qdA.getString(r.j.app_tip);
      localMobileVerifyUI1.lzP = k.a(localMobileVerifyUI2, this.qdA.getString(r.j.bind_mcontact_verifing), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128431);
          com.tencent.mm.kernel.h.aZW().a(parama);
          com.tencent.mm.kernel.h.aZW().b(145, p.this);
          AppMethodBeat.o(128431);
        }
      });
      continue;
      com.tencent.mm.kernel.h.aZW().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.qdA.hRk, 14, "", 0, "");
      parama.NH(this.qdA.qcu);
      com.tencent.mm.kernel.h.aZW().a(parama, 0);
      com.tencent.mm.plugin.account.model.l.a(l.a.pWM);
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      parama = parama.append(com.tencent.mm.kernel.b.aZR()).append(",").append(getClass().getName()).append(",R200_350_auto,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_350_auto") + ",1");
      com.tencent.mm.kernel.h.aZW().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.qdA.hRk, 15, this.qdA.pPd.getText().toString().trim(), 0, "");
      parama.NH(this.qdA.qcu);
      com.tencent.mm.kernel.h.aZW().a(parama, 0);
      localMobileVerifyUI1 = this.qdA;
      localMobileVerifyUI2 = this.qdA;
      this.qdA.getString(r.j.app_tip);
      localMobileVerifyUI1.lzP = k.a(localMobileVerifyUI2, this.qdA.getString(r.j.bind_mcontact_verifing), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128422);
          com.tencent.mm.kernel.h.aZW().a(parama);
          com.tencent.mm.kernel.h.aZW().b(145, p.this);
          AppMethodBeat.o(128422);
        }
      });
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(128439);
    Log.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.qdA.lzP != null)
    {
      this.qdA.lzP.dismiss();
      this.qdA.lzP = null;
    }
    if (paramp.getType() == 255)
    {
      com.tencent.mm.kernel.h.aZW().b(255, this);
      if ((paramInt2 == -3) && (paramInt1 == 4)) {
        this.qdA.hR(this.qdH);
      }
      AppMethodBeat.o(128439);
      return;
    }
    Object localObject1;
    if (((paramp.getType() == 701) || (paramp.getType() == 701)) && (this.qaG != null))
    {
      com.tencent.mm.kernel.h.aZW().b(701, this);
      com.tencent.mm.kernel.h.aZW().b(252, this);
      this.qaG.a(this.qdA, paramInt1, paramInt2, paramString, paramp);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramp instanceof u)) {
          this.qdH = ((u)paramp).bMr();
        }
        com.tencent.mm.kernel.h.aZW().a(255, this);
        paramString = new v(1);
        com.tencent.mm.kernel.h.aZW().a(paramString, 0);
        paramp = this.qdA;
        localObject1 = this.qdA;
        this.qdA.getString(r.j.app_tip);
        paramp.lzP = k.a((Context)localObject1, this.qdA.getString(r.j.app_loading), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128432);
            com.tencent.mm.kernel.h.aZW().a(paramString);
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
    if (paramp.getType() == 145)
    {
      com.tencent.mm.kernel.h.aZW().b(145, this);
      i = ((com.tencent.mm.modelfriend.a)paramp).bIO();
      if (i != 15)
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 15)
        {
          if (this.qdA.qdn == 1)
          {
            this.qdG = ((com.tencent.mm.modelfriend.a)paramp).bIQ();
            com.tencent.mm.kernel.h.aZW().a(126, this);
            paramString = new w("", this.qdA.qdg, this.qdA.nickName, 0, "", this.qdA.hRk, "", "", this.qdG, this.qdA.oTc, "", "", "", true, this.qdA.qdZ.booleanValue());
            paramString.OZ(this.qdA.qcu);
            paramString.Pa(this.qdA.qeg);
            com.tencent.mm.kernel.h.aZW().a(paramString, 0);
            paramp = this.qdA;
            localObject1 = this.qdA;
            this.qdA.getString(r.j.app_tip);
            paramp.lzP = k.a((Context)localObject1, this.qdA.getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(128428);
                com.tencent.mm.kernel.h.aZW().a(paramString);
                com.tencent.mm.kernel.h.aZW().b(126, p.this);
                AppMethodBeat.o(128428);
              }
            });
            AppMethodBeat.o(128439);
            return;
          }
          paramString = new Intent();
          paramString.putExtra("regsetinfo_ticket", ((com.tencent.mm.modelfriend.a)paramp).bIQ());
          paramString.putExtra("regsetinfo_user", this.qdA.hRk);
          paramString.putExtra("regsession_id", this.qdA.qcu);
          paramString.putExtra("reg_3d_app_ticket", this.qdA.qeg);
          paramString.putExtra("reg_3d_app_type", this.qdA.qdp);
          paramString.putExtra("regsetinfo_ismobile", 4);
          paramString.putExtra("regsetinfo_NextControl", ((com.tencent.mm.modelfriend.a)paramp).bIX());
          paramString.putExtra("key_reg_style", this.qdA.qdn);
          paramString.setClass(this.qdA, RegSetInfoUI.class);
          paramp = this.qdA;
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(paramp, paramString.aYi(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramp.startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramp, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.account.model.l.a(l.a.pWN);
        }
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -35)
      {
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        this.qbY.joN = this.qdA.qdp;
        this.qbY.ikE = 7L;
        this.qbY.bMH();
        if (paramString != null)
        {
          paramString.a(this.qdA, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128433);
              com.tencent.mm.kernel.h.aZW().a(701, p.this);
              com.tencent.mm.kernel.h.aZW().a(252, p.this);
              p.a(p.this, new h(new h.a()
              {
                public final void b(ProgressDialog paramAnonymous2ProgressDialog)
                {
                  AppMethodBeat.i(305232);
                  p.a(p.this).lzP = paramAnonymous2ProgressDialog;
                  AppMethodBeat.o(305232);
                }
              }, ((com.tencent.mm.modelfriend.a)paramp).getUsername(), ((com.tencent.mm.modelfriend.a)paramp).bIP(), p.a(p.this).hRk));
              p.b(p.this).d(p.a(p.this));
              p.c(p.this).joN = p.a(p.this).qdp;
              p.c(p.this).ikE = 8L;
              p.c(p.this).bMH();
              AppMethodBeat.o(128433);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(128439);
          return;
        }
        k.a(this.qdA, this.qdA.getString(r.j.bind_mcontact_already_bind_relogin), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128434);
            com.tencent.mm.kernel.h.aZW().a(701, p.this);
            com.tencent.mm.kernel.h.aZW().a(252, p.this);
            p.a(p.this, new h(new h.a()
            {
              public final void b(ProgressDialog paramAnonymous2ProgressDialog)
              {
                AppMethodBeat.i(305097);
                p.a(p.this).lzP = paramAnonymous2ProgressDialog;
                AppMethodBeat.o(305097);
              }
            }, ((com.tencent.mm.modelfriend.a)paramp).getUsername(), ((com.tencent.mm.modelfriend.a)paramp).bIP(), p.a(p.this).hRk));
            p.b(p.this).d(p.a(p.this));
            p.c(p.this).joN = p.a(p.this).qdp;
            p.c(p.this).ikE = 8L;
            p.c(p.this).bMH();
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
        paramString = new Intent(this.qdA, MobileLoginOrForceReg.class);
        paramString.putExtra("ticket", ((com.tencent.mm.modelfriend.a)paramp).bIQ());
        paramString.putExtra("moble", this.qdA.hRk);
        paramString.putExtra("regsession_id", this.qdA.qcu);
        paramString.putExtra("reg_3d_app_ticket", this.qdA.qeg);
        paramString.putExtra("reg_3d_app_type", this.qdA.qdp);
        paramString.putExtra("next_controll", ((com.tencent.mm.modelfriend.a)paramp).bIX());
        paramString.putExtra("username", ((com.tencent.mm.modelfriend.a)paramp).getUsername());
        paramString.putExtra("password", ((com.tencent.mm.modelfriend.a)paramp).bIP());
        paramString.putExtra("nickname", ((com.tencent.mm.modelfriend.a)paramp).bJd());
        paramString.putExtra("avatar_url", ((com.tencent.mm.modelfriend.a)paramp).bJc());
        paramString.putExtra("key_reg_style", this.qdA.qdn);
        if (this.qdA.qdn == 1)
        {
          paramString.putExtra("kintent_nickname", this.qdA.nickName);
          paramString.putExtra("kintent_password", this.qdA.qdg);
          paramString.putExtra("kintent_hasavatar", this.qdA.qdZ);
        }
        paramp = this.qdA;
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        com.tencent.mm.hellhoundlib.a.a.b(paramp, paramString.aYi(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramp.startActivity((Intent)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramp, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        if (paramString != null)
        {
          paramString.a(this.qdA, null, null);
          AppMethodBeat.o(128439);
          return;
        }
        k.s(this.qdA, r.j.bind_mcontact_verify_err_time_out_content, r.j.bind_mcontact_verify_tip);
        AppMethodBeat.o(128439);
      }
    }
    else if (paramp.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = this.qdA.qdZ;
        localObject1 = this.qdA.qdg;
        localObject2 = this.qdA.nickName;
        if (this.qdA.pRw == null)
        {
          this.qdA.pRw = SecurityImage.a.a(this.qdA, r.j.regbyqq_secimg_title, 0, ((w)paramp).bMj(), ((w)paramp).bMi(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128424);
              com.tencent.mm.kernel.h.aZW().a(126, p.this);
              paramAnonymousDialogInterface = new w("", this.qdr, this.qds, 0, "", p.a(p.this).hRk, "", "", p.d(p.this), p.a(p.this).oTc, "", ((w)paramp).bMi(), p.a(p.this).pRw.getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.OZ(p.a(p.this).qcu);
              paramAnonymousDialogInterface.Pa(p.a(p.this).qeg);
              com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI1 = p.a(p.this);
              MobileVerifyUI localMobileVerifyUI2 = p.a(p.this);
              p.a(p.this).getString(r.j.app_tip);
              localMobileVerifyUI1.lzP = k.a(localMobileVerifyUI2, p.a(p.this).getString(r.j.regbyqq_reg_waiting), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128423);
                  com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.h.aZW().b(126, p.this);
                  AppMethodBeat.o(128423);
                }
              });
              AppMethodBeat.o(128424);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(304920);
              p.a(p.this).pRw = null;
              AppMethodBeat.o(304920);
            }
          }, new SecurityImage.b()
          {
            public final void bWF()
            {
              AppMethodBeat.i(128425);
              p.a(p.this).hideVKB();
              com.tencent.mm.kernel.h.aZW().a(126, p.this);
              w localw = new w("", this.qdr, this.qds, 0, "", p.a(p.this).hRk, "", "", p.d(p.this), p.a(p.this).oTc, "", ((w)paramp).bMi(), "", true, paramString.booleanValue());
              localw.OZ(p.a(p.this).qcu);
              localw.Pa(p.a(p.this).qeg);
              com.tencent.mm.kernel.h.aZW().a(localw, 0);
              AppMethodBeat.o(128425);
            }
          });
          AppMethodBeat.o(128439);
          return;
        }
        this.qdA.pRw.b(0, ((w)paramp).bMj(), ((w)paramp).bMi(), "");
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        str2 = this.qdA.hRk;
        localObject4 = this.qdA.qdZ;
        this.qbY.joN = this.qdA.qdp;
        this.qbY.ikE = 6L;
        this.qbY.bMH();
        i = ((w)paramp).bMt();
        str1 = ((w)paramp).bMu();
        j = ((w)paramp).bMv();
        str3 = ((w)paramp).bMw();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = XmlParser.parseXml(str3, "wording", null);
        if (localMap == null) {
          break label2601;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!Util.isNullOrNil((String)localObject3)) {
          break label2025;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label2601;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!Util.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (Util.isNullOrNil((String)localObject3)) {
          break label2598;
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
      com.tencent.mm.kernel.b.aZI();
      com.tencent.mm.kernel.b.fA(true);
      com.tencent.mm.plugin.report.service.l.kK(1, 8);
      com.tencent.mm.plugin.report.service.l.kK(1, 3);
      com.tencent.mm.plugin.report.service.l.kK(1, 1);
      if (((Boolean)localObject4).booleanValue())
      {
        localObject3 = com.tencent.mm.loader.i.b.bmH() + "temp.avatar";
        localObject4 = com.tencent.mm.loader.i.b.bmH() + "temp.avatar.hd";
        y.qn((String)localObject3, (String)localObject4);
        y.deleteFile((String)localObject3);
        BitmapUtil.createThumbNail((String)localObject4, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject3, true);
        new o(this.qdA, com.tencent.mm.loader.i.b.bmH() + "temp.avatar", true).a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128426);
            p.a(p.this, ((w)paramp).bMs());
            bg.okT.bc("login_user_name", str2);
            y.deleteFile(com.tencent.mm.loader.i.b.bmH() + "temp.avatar");
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.TA("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(p.a(p.this), FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", p.e(p.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
                localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(p.a(p.this));
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(p.a(p.this), (Intent)localObject1, (Intent)localObject2);
                p.bYu();
                p.a(p.this).finish();
                AppMethodBeat.o(128426);
                return;
                localObject1 = new Intent(p.a(p.this), FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.qdM);
                ((Intent)localObject1).putExtra("alert_message", this.qdN);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(p.a(p.this));
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = p.a(p.this);
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.baC();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aZR()).append(",").append(p.a(p.this).getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.h.baC();
            com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_900_phone") + ",4");
            p.bYu();
            p.a(p.this).finish();
            AppMethodBeat.o(128426);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128427);
            p.a(p.this, ((w)paramp).bMs());
            bg.okT.bc("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.TA("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(p.a(p.this), FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", p.e(p.this));
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
                localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(p.a(p.this));
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(p.a(p.this), (Intent)localObject1, (Intent)localObject2);
                p.bYu();
                p.a(p.this).finish();
                AppMethodBeat.o(128427);
                return;
                localObject1 = new Intent(p.a(p.this), FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.qdM);
                ((Intent)localObject1).putExtra("alert_message", this.qdN);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(p.a(p.this));
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = p.a(p.this);
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.h.baC();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aZR()).append(",").append(p.a(p.this).getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.h.baC();
            com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_900_phone") + ",4");
            p.bYu();
            p.a(p.this).finish();
            AppMethodBeat.o(128427);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.broadcast.a.CH(paramString);
        if (localObject1 == null) {
          break label2473;
        }
        ((com.tencent.mm.broadcast.a)localObject1).a(this.qdA, null, null);
        AppMethodBeat.o(128439);
        return;
        label2025:
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
        this.lCS = ((w)paramp).bMs();
        bg.okT.bc("login_user_name", str2);
        if ((str1 != null) && (str1.contains("0")))
        {
          com.tencent.mm.plugin.b.a.TA("R300_100_phone");
          if (!bool1) {}
          for (localObject1 = new Intent(this.qdA, FindMContactIntroUI.class);; localObject1 = localObject3)
          {
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("regsetinfo_ticket", this.lCS);
            ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
            ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
            localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this.qdA);
            ((Intent)localObject2).addFlags(67108864);
            ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
            MMWizardActivity.b(this.qdA, (Intent)localObject1, (Intent)localObject2);
            bYr();
            this.qdA.finish();
            break;
            localObject3 = new Intent(this.qdA, FindMContactAlertUI.class);
            ((Intent)localObject3).putExtra("alert_title", (String)localObject1);
            ((Intent)localObject3).putExtra("alert_message", (String)localObject2);
          }
        }
        localObject2 = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this.qdA);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = this.qdA;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.h.baC();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.b.aZR()).append(",").append(this.qdA.getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.h.baC();
        com.tencent.mm.plugin.b.a.Du(com.tencent.mm.kernel.b.Fw("R200_900_phone") + ",4");
        bYr();
        this.qdA.finish();
      }
      label2473:
      if (this.qdA.p(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramp.getType() == 252) || (paramp.getType() == 701))
      {
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        if ((paramString != null) && (paramString.a(this.qdA, null, null)))
        {
          AppMethodBeat.o(128439);
          return;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this.qdA, this.qdA.getString(r.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(128439);
      return;
      label2598:
      continue;
      label2601:
      localObject1 = null;
      bool1 = bool2;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(128436);
    com.tencent.mm.kernel.h.aZW().a(126, this);
    AppMethodBeat.o(128436);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128437);
    com.tencent.mm.kernel.h.aZW().b(126, this);
    com.tencent.mm.kernel.h.aZW().b(145, this);
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    com.tencent.mm.kernel.h.aZW().b(255, this);
    AppMethodBeat.o(128437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.p
 * JD-Core Version:    0.7.0.1
 */