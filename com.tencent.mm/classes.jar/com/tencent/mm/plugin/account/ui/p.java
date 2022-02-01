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
import com.tencent.mm.aj.n;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.model.m.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.vfs.s;
import java.util.Map;

public final class p
  implements i, MobileVerifyUI.c
{
  String gwF;
  ka kkY;
  h klz;
  MobileVerifyUI koA;
  String koG;
  private boolean koH;
  
  public p()
  {
    AppMethodBeat.i(128435);
    this.klz = null;
    this.koH = true;
    this.kkY = new ka();
    AppMethodBeat.o(128435);
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.koA = paramMobileVerifyUI;
  }
  
  public final boolean a(final MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128438);
    switch (8.koE[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128438);
      return false;
      com.tencent.mm.ui.base.h.c(this.koA, this.koA.getString(2131763123), "", this.koA.getString(2131763124), this.koA.getString(2131763125), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(128430);
          p.this.koA.finish();
          com.tencent.mm.plugin.account.model.m.a(m.a.kiD);
          AppMethodBeat.o(128430);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128438);
      return true;
      g.azz().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.koA.dSf, 15, this.koA.kbd.getText().toString().trim(), 0, "");
      parama.Ok(this.koA.knu);
      g.azz().a(parama, 0);
      MobileVerifyUI localMobileVerifyUI1 = this.koA;
      MobileVerifyUI localMobileVerifyUI2 = this.koA;
      this.koA.getString(2131755998);
      localMobileVerifyUI1.gtM = com.tencent.mm.ui.base.h.a(localMobileVerifyUI2, this.koA.getString(2131756639), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128431);
          g.azz().a(parama);
          g.azz().b(145, p.this);
          AppMethodBeat.o(128431);
        }
      });
      continue;
      g.azz().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.koA.dSf, 14, "", 0, "");
      parama.Ok(this.koA.knu);
      g.azz().a(parama, 0);
      com.tencent.mm.plugin.account.model.m.a(m.a.kiE);
      continue;
      parama = new StringBuilder();
      g.aAf();
      parama = parama.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_350_auto,");
      g.aAf();
      com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_350_auto") + ",1");
      g.azz().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.koA.dSf, 15, this.koA.kbd.getText().toString().trim(), 0, "");
      parama.Ok(this.koA.knu);
      g.azz().a(parama, 0);
      localMobileVerifyUI1 = this.koA;
      localMobileVerifyUI2 = this.koA;
      this.koA.getString(2131755998);
      localMobileVerifyUI1.gtM = com.tencent.mm.ui.base.h.a(localMobileVerifyUI2, this.koA.getString(2131756639), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(128422);
          g.azz().a(parama);
          g.azz().b(145, p.this);
          AppMethodBeat.o(128422);
        }
      });
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final q paramq)
  {
    AppMethodBeat.i(128439);
    Log.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.koA.gtM != null)
    {
      this.koA.gtM.dismiss();
      this.koA.gtM = null;
    }
    if (paramq.getType() == 255)
    {
      g.azz().b(255, this);
      if ((paramInt2 == -3) && (paramInt1 == 4)) {
        this.koA.gq(this.koH);
      }
      AppMethodBeat.o(128439);
      return;
    }
    Object localObject1;
    if (((paramq.getType() == 701) || (paramq.getType() == 701)) && (this.klz != null))
    {
      g.azz().b(701, this);
      g.azz().b(252, this);
      this.klz.a(this.koA, paramInt1, paramInt2, paramString, paramq);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramq instanceof com.tencent.mm.modelsimple.t)) {
          this.koH = ((com.tencent.mm.modelsimple.t)paramq).bfu();
        }
        g.azz().a(255, this);
        paramString = new u(1);
        g.azz().a(paramString, 0);
        paramq = this.koA;
        localObject1 = this.koA;
        this.koA.getString(2131755998);
        paramq.gtM = com.tencent.mm.ui.base.h.a((Context)localObject1, this.koA.getString(2131755886), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128432);
            g.azz().a(paramString);
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
      g.azz().b(145, this);
      i = ((com.tencent.mm.modelfriend.a)paramq).Vj();
      if (i != 15)
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 15)
        {
          if (this.koA.kon == 1)
          {
            this.koG = ((com.tencent.mm.modelfriend.a)paramq).bbG();
            g.azz().a(126, this);
            paramString = new v("", this.koA.kof, this.koA.nickName, 0, "", this.koA.dSf, "", "", this.koG, this.koA.jkp, "", "", "", true, this.koA.kpa.booleanValue());
            paramString.PB(this.koA.knu);
            paramString.PC(this.koA.kph);
            g.azz().a(paramString, 0);
            paramq = this.koA;
            localObject1 = this.koA;
            this.koA.getString(2131755998);
            paramq.gtM = com.tencent.mm.ui.base.h.a((Context)localObject1, this.koA.getString(2131764451), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymousDialogInterface)
              {
                AppMethodBeat.i(128428);
                g.azz().a(paramString);
                g.azz().b(126, p.this);
                AppMethodBeat.o(128428);
              }
            });
            AppMethodBeat.o(128439);
            return;
          }
          paramString = new Intent();
          paramString.putExtra("regsetinfo_ticket", ((com.tencent.mm.modelfriend.a)paramq).bbG());
          paramString.putExtra("regsetinfo_user", this.koA.dSf);
          paramString.putExtra("regsession_id", this.koA.knu);
          paramString.putExtra("reg_3d_app_ticket", this.koA.kph);
          paramString.putExtra("reg_3d_app_type", this.koA.kop);
          paramString.putExtra("regsetinfo_ismobile", 4);
          paramString.putExtra("regsetinfo_NextControl", ((com.tencent.mm.modelfriend.a)paramq).bbN());
          paramString.putExtra("key_reg_style", this.koA.kon);
          paramString.setClass(this.koA, RegSetInfoUI.class);
          paramq = this.koA;
          paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(paramq, paramString.axQ(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramq.startActivity((Intent)paramString.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramq, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.account.model.m.a(m.a.kiF);
        }
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -35)
      {
        paramString = com.tencent.mm.h.a.Dk(paramString);
        this.kkY.eTd = this.koA.kop;
        this.kkY.ejA = 7L;
        this.kkY.bfK();
        if (paramString != null)
        {
          paramString.a(this.koA, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128433);
              g.azz().a(701, p.this);
              g.azz().a(252, p.this);
              p.this.klz = new h(new h.a()
              {
                public final void a(ProgressDialog paramAnonymous2ProgressDialog)
                {
                  p.this.koA.gtM = paramAnonymous2ProgressDialog;
                }
              }, ((com.tencent.mm.modelfriend.a)paramq).getUsername(), ((com.tencent.mm.modelfriend.a)paramq).bbF(), p.this.koA.dSf);
              p.this.klz.b(p.this.koA);
              p.this.kkY.eTd = p.this.koA.kop;
              p.this.kkY.ejA = 8L;
              p.this.kkY.bfK();
              AppMethodBeat.o(128433);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(128439);
          return;
        }
        com.tencent.mm.ui.base.h.a(this.koA, this.koA.getString(2131756580), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128434);
            g.azz().a(701, p.this);
            g.azz().a(252, p.this);
            p.this.klz = new h(new h.a()
            {
              public final void a(ProgressDialog paramAnonymous2ProgressDialog)
              {
                p.this.koA.gtM = paramAnonymous2ProgressDialog;
              }
            }, ((com.tencent.mm.modelfriend.a)paramq).getUsername(), ((com.tencent.mm.modelfriend.a)paramq).bbF(), p.this.koA.dSf);
            p.this.klz.b(p.this.koA);
            p.this.kkY.eTd = p.this.koA.kop;
            p.this.kkY.ejA = 8L;
            p.this.kkY.bfK();
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
        paramString = new Intent(this.koA, MobileLoginOrForceReg.class);
        paramString.putExtra("ticket", ((com.tencent.mm.modelfriend.a)paramq).bbG());
        paramString.putExtra("moble", this.koA.dSf);
        paramString.putExtra("regsession_id", this.koA.knu);
        paramString.putExtra("reg_3d_app_ticket", this.koA.kph);
        paramString.putExtra("reg_3d_app_type", this.koA.kop);
        paramString.putExtra("next_controll", ((com.tencent.mm.modelfriend.a)paramq).bbN());
        paramString.putExtra("username", ((com.tencent.mm.modelfriend.a)paramq).getUsername());
        paramString.putExtra("password", ((com.tencent.mm.modelfriend.a)paramq).bbF());
        paramString.putExtra("nickname", ((com.tencent.mm.modelfriend.a)paramq).bbT());
        paramString.putExtra("avatar_url", ((com.tencent.mm.modelfriend.a)paramq).bbS());
        paramString.putExtra("key_reg_style", this.koA.kon);
        if (this.koA.kon == 1)
        {
          paramString.putExtra("kintent_nickname", this.koA.nickName);
          paramString.putExtra("kintent_password", this.koA.kof);
          paramString.putExtra("kintent_hasavatar", this.koA.kpa);
        }
        paramq = this.koA;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramq, paramString.axQ(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramq.startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramq, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if (paramString != null)
        {
          paramString.a(this.koA, null, null);
          AppMethodBeat.o(128439);
          return;
        }
        com.tencent.mm.ui.base.h.n(this.koA, 2131756644, 2131756650);
        AppMethodBeat.o(128439);
      }
    }
    else if (paramq.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = this.koA.kpa;
        localObject1 = this.koA.kof;
        localObject2 = this.koA.nickName;
        if (this.koA.kdp == null)
        {
          this.koA.kdp = SecurityImage.a.a(this.koA, 0, ((v)paramq).bfm(), ((v)paramq).bfl(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128424);
              g.azz().a(126, p.this);
              paramAnonymousDialogInterface = new v("", this.kor, this.kos, 0, "", p.this.koA.dSf, "", "", p.this.koG, p.this.koA.jkp, "", ((v)paramq).bfl(), p.this.koA.kdp.getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.PB(p.this.koA.knu);
              paramAnonymousDialogInterface.PC(p.this.koA.kph);
              g.azz().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI1 = p.this.koA;
              MobileVerifyUI localMobileVerifyUI2 = p.this.koA;
              p.this.koA.getString(2131755998);
              localMobileVerifyUI1.gtM = com.tencent.mm.ui.base.h.a(localMobileVerifyUI2, p.this.koA.getString(2131764451), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128423);
                  g.azz().a(paramAnonymousDialogInterface);
                  g.azz().b(126, p.this);
                  AppMethodBeat.o(128423);
                }
              });
              AppMethodBeat.o(128424);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              p.this.koA.kdp = null;
            }
          }, new SecurityImage.b()
          {
            public final void bnH()
            {
              AppMethodBeat.i(128425);
              p.this.koA.hideVKB();
              g.azz().a(126, p.this);
              v localv = new v("", this.kor, this.kos, 0, "", p.this.koA.dSf, "", "", p.this.koG, p.this.koA.jkp, "", ((v)paramq).bfl(), "", true, paramString.booleanValue());
              localv.PB(p.this.koA.knu);
              localv.PC(p.this.koA.kph);
              g.azz().a(localv, 0);
              AppMethodBeat.o(128425);
            }
          });
          AppMethodBeat.o(128439);
          return;
        }
        this.koA.kdp.b(0, ((v)paramq).bfm(), ((v)paramq).bfl(), "");
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        str2 = this.koA.dSf;
        localObject4 = this.koA.kpa;
        this.kkY.eTd = this.koA.kop;
        this.kkY.ejA = 6L;
        this.kkY.bfK();
        i = ((v)paramq).bfw();
        str1 = ((v)paramq).bfx();
        j = ((v)paramq).bfy();
        str3 = ((v)paramq).bfz();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = XmlParser.parseXml(str3, "wording", null);
        if (localMap == null) {
          break label2546;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!Util.isNullOrNil((String)localObject3)) {
          break label1980;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label2546;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!Util.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (Util.isNullOrNil((String)localObject3)) {
          break label2543;
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
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.kernel.a.es(true);
      if (((Boolean)localObject4).booleanValue())
      {
        localObject3 = b.aKR() + "temp.avatar";
        localObject4 = b.aKR() + "temp.avatar.hd";
        s.nx((String)localObject3, (String)localObject4);
        s.deleteFile((String)localObject3);
        BitmapUtil.createThumbNail((String)localObject4, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject3, true);
        new n(this.koA, b.aKR() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128426);
            p.this.gwF = ((v)paramq).bfv();
            bf.iDu.aO("login_user_name", str2);
            s.deleteFile(b.aKR() + "temp.avatar");
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.bwV("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(p.this.koA, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", p.this.gwF);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
                localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(p.this.koA);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(p.this.koA, (Intent)localObject1, (Intent)localObject2);
                p.this.koA.finish();
                AppMethodBeat.o(128426);
                return;
                localObject1 = new Intent(p.this.koA, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.koM);
                ((Intent)localObject1).putExtra("alert_message", this.koN);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(p.this.koA);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = p.this.koA;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            g.aAf();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(p.this.koA.getClass().getName()).append(",R200_900_phone,");
            g.aAf();
            com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_900_phone") + ",4");
            p.this.koA.finish();
            AppMethodBeat.o(128426);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128427);
            p.this.gwF = ((v)paramq).bfv();
            bf.iDu.aO("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.bwV("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(p.this.koA, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", p.this.gwF);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
                localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(p.this.koA);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(p.this.koA, (Intent)localObject1, (Intent)localObject2);
                p.this.koA.finish();
                AppMethodBeat.o(128427);
                return;
                localObject1 = new Intent(p.this.koA, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.koM);
                ((Intent)localObject1).putExtra("alert_message", this.koN);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(p.this.koA);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = p.this.koA;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            g.aAf();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(p.this.koA.getClass().getName()).append(",R200_900_phone,");
            g.aAf();
            com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_900_phone") + ",4");
            p.this.koA.finish();
            AppMethodBeat.o(128427);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.Dk(paramString);
        if (localObject1 == null) {
          break label2421;
        }
        ((com.tencent.mm.h.a)localObject1).a(this.koA, null, null);
        AppMethodBeat.o(128439);
        return;
        label1980:
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
        this.gwF = ((v)paramq).bfv();
        bf.iDu.aO("login_user_name", str2);
        if ((str1 != null) && (str1.contains("0")))
        {
          com.tencent.mm.plugin.b.a.bwV("R300_100_phone");
          if (!bool1) {}
          for (localObject1 = new Intent(this.koA, FindMContactIntroUI.class);; localObject1 = localObject3)
          {
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("regsetinfo_ticket", this.gwF);
            ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
            ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
            localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(this.koA);
            ((Intent)localObject2).addFlags(67108864);
            ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
            MMWizardActivity.b(this.koA, (Intent)localObject1, (Intent)localObject2);
            this.koA.finish();
            break;
            localObject3 = new Intent(this.koA, FindMContactAlertUI.class);
            ((Intent)localObject3).putExtra("alert_title", (String)localObject1);
            ((Intent)localObject3).putExtra("alert_message", (String)localObject2);
          }
        }
        localObject2 = com.tencent.mm.plugin.account.a.a.jRt.bZ(this.koA);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = this.koA;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localObject1 = new StringBuilder();
        g.aAf();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.azt()).append(",").append(this.koA.getClass().getName()).append(",R200_900_phone,");
        g.aAf();
        com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("R200_900_phone") + ",4");
        this.koA.finish();
      }
      label2421:
      if (this.koA.n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramq.getType() == 252) || (paramq.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.Dk(paramString);
        if ((paramString != null) && (paramString.a(this.koA, null, null)))
        {
          AppMethodBeat.o(128439);
          return;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this.koA, this.koA.getString(2131756643, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(128439);
      return;
      label2543:
      continue;
      label2546:
      localObject1 = null;
      bool1 = bool2;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(128436);
    g.azz().a(126, this);
    AppMethodBeat.o(128436);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128437);
    g.azz().b(126, this);
    AppMethodBeat.o(128437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.p
 * JD-Core Version:    0.7.0.1
 */