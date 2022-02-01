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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.fl;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.model.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;
import java.util.Map;

public final class o
  implements com.tencent.mm.ak.g, MobileVerifyUI.b
{
  String fwd;
  fl iQO;
  g iRp;
  MobileVerifyUI iUm;
  String iUs;
  private boolean iUt;
  
  public o()
  {
    AppMethodBeat.i(128435);
    this.iRp = null;
    this.iUt = true;
    this.iQO = new fl();
    AppMethodBeat.o(128435);
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.iUm = paramMobileVerifyUI;
  }
  
  public final boolean a(MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(128438);
    switch (8.iUq[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(128438);
      return false;
      h.d(this.iUm, this.iUm.getString(2131761297), "", this.iUm.getString(2131761298), this.iUm.getString(2131761299), new o.9(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(128438);
      return true;
      com.tencent.mm.kernel.g.agi().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.iUm.dnz, 15, this.iUm.iGY.getText().toString().trim(), 0, "");
      parama.BY(this.iUm.iTi);
      com.tencent.mm.kernel.g.agi().a(parama, 0);
      MobileVerifyUI localMobileVerifyUI1 = this.iUm;
      MobileVerifyUI localMobileVerifyUI2 = this.iUm;
      this.iUm.getString(2131755906);
      localMobileVerifyUI1.fts = h.b(localMobileVerifyUI2, this.iUm.getString(2131756503), true, new o.11(this, parama));
      continue;
      com.tencent.mm.kernel.g.agi().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.iUm.dnz, 14, "", 0, "");
      parama.BY(this.iUm.iTi);
      com.tencent.mm.kernel.g.agi().a(parama, 0);
      com.tencent.mm.plugin.account.model.l.a(l.a.iOz);
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      parama = parama.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",R200_350_auto,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_350_auto") + ",1");
      com.tencent.mm.kernel.g.agi().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.iUm.dnz, 15, this.iUm.iGY.getText().toString().trim(), 0, "");
      parama.BY(this.iUm.iTi);
      com.tencent.mm.kernel.g.agi().a(parama, 0);
      localMobileVerifyUI1 = this.iUm;
      localMobileVerifyUI2 = this.iUm;
      this.iUm.getString(2131755906);
      localMobileVerifyUI1.fts = h.b(localMobileVerifyUI2, this.iUm.getString(2131756503), true, new o.1(this, parama));
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(128439);
    ac.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iUm.fts != null)
    {
      this.iUm.fts.dismiss();
      this.iUm.fts = null;
    }
    if (paramn.getType() == 255)
    {
      com.tencent.mm.kernel.g.agi().b(255, this);
      if ((paramInt2 == -3) && (paramInt1 == 4)) {
        this.iUm.fs(this.iUt);
      }
      AppMethodBeat.o(128439);
      return;
    }
    Object localObject1;
    if (((paramn.getType() == 701) || (paramn.getType() == 701)) && (this.iRp != null))
    {
      com.tencent.mm.kernel.g.agi().b(701, this);
      com.tencent.mm.kernel.g.agi().b(252, this);
      this.iRp.a(this.iUm, paramInt1, paramInt2, paramString, paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramn instanceof s)) {
          this.iUt = ((s)paramn).aHJ();
        }
        com.tencent.mm.kernel.g.agi().a(255, this);
        paramString = new t(1);
        com.tencent.mm.kernel.g.agi().a(paramString, 0);
        paramn = this.iUm;
        localObject1 = this.iUm;
        this.iUm.getString(2131755906);
        paramn.fts = h.b((Context)localObject1, this.iUm.getString(2131755804), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(128432);
            com.tencent.mm.kernel.g.agi().a(paramString);
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
      com.tencent.mm.kernel.g.agi().b(145, this);
      i = ((com.tencent.mm.modelfriend.a)paramn).Js();
      if (i != 15)
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 15)
        {
          if (this.iUm.iTZ == 1)
          {
            this.iUs = ((com.tencent.mm.modelfriend.a)paramn).aEr();
            com.tencent.mm.kernel.g.agi().a(126, this);
            paramString = new u("", this.iUm.iTR, this.iUm.bLs, 0, "", this.iUm.dnz, "", "", this.iUs, this.iUm.hSX, "", "", "", true, this.iUm.iUM.booleanValue());
            paramString.Di(this.iUm.iTi);
            paramString.Dj(this.iUm.iUT);
            com.tencent.mm.kernel.g.agi().a(paramString, 0);
            paramn = this.iUm;
            localObject1 = this.iUm;
            this.iUm.getString(2131755906);
            paramn.fts = h.b((Context)localObject1, this.iUm.getString(2131762385), true, new o.7(this, paramString));
            AppMethodBeat.o(128439);
            return;
          }
          paramString = new Intent();
          paramString.putExtra("regsetinfo_ticket", ((com.tencent.mm.modelfriend.a)paramn).aEr());
          paramString.putExtra("regsetinfo_user", this.iUm.dnz);
          paramString.putExtra("regsession_id", this.iUm.iTi);
          paramString.putExtra("reg_3d_app_ticket", this.iUm.iUT);
          paramString.putExtra("reg_3d_app_type", this.iUm.iUb);
          paramString.putExtra("regsetinfo_ismobile", 4);
          paramString.putExtra("regsetinfo_NextControl", ((com.tencent.mm.modelfriend.a)paramn).aEy());
          paramString.putExtra("key_reg_style", this.iUm.iTZ);
          paramString.setClass(this.iUm, RegSetInfoUI.class);
          paramn = this.iUm;
          paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
          com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.aeD(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramn.startActivity((Intent)paramString.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.account.model.l.a(l.a.iOA);
        }
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -35)
      {
        paramString = com.tencent.mm.h.a.rM(paramString);
        this.iQO.dXB = this.iUm.iUb;
        this.iQO.dCQ = 7L;
        this.iQO.aHZ();
        if (paramString != null)
        {
          paramString.a(this.iUm, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128433);
              com.tencent.mm.kernel.g.agi().a(701, o.this);
              com.tencent.mm.kernel.g.agi().a(252, o.this);
              o.this.iRp = new g(new g.a()
              {
                public final void a(ProgressDialog paramAnonymous2ProgressDialog)
                {
                  o.this.iUm.fts = paramAnonymous2ProgressDialog;
                }
              }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aEq(), o.this.iUm.dnz);
              o.this.iRp.a(o.this.iUm);
              o.this.iQO.dXB = o.this.iUm.iUb;
              o.this.iQO.dCQ = 8L;
              o.this.iQO.aHZ();
              AppMethodBeat.o(128433);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(128439);
          return;
        }
        h.a(this.iUm, this.iUm.getString(2131756444), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(128434);
            com.tencent.mm.kernel.g.agi().a(701, o.this);
            com.tencent.mm.kernel.g.agi().a(252, o.this);
            o.this.iRp = new g(new g.a()
            {
              public final void a(ProgressDialog paramAnonymous2ProgressDialog)
              {
                o.this.iUm.fts = paramAnonymous2ProgressDialog;
              }
            }, ((com.tencent.mm.modelfriend.a)paramn).getUsername(), ((com.tencent.mm.modelfriend.a)paramn).aEq(), o.this.iUm.dnz);
            o.this.iRp.a(o.this.iUm);
            o.this.iQO.dXB = o.this.iUm.iUb;
            o.this.iQO.dCQ = 8L;
            o.this.iQO.aHZ();
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
        paramString = new Intent(this.iUm, MobileLoginOrForceReg.class);
        paramString.putExtra("ticket", ((com.tencent.mm.modelfriend.a)paramn).aEr());
        paramString.putExtra("moble", this.iUm.dnz);
        paramString.putExtra("regsession_id", this.iUm.iTi);
        paramString.putExtra("reg_3d_app_ticket", this.iUm.iUT);
        paramString.putExtra("reg_3d_app_type", this.iUm.iUb);
        paramString.putExtra("next_controll", ((com.tencent.mm.modelfriend.a)paramn).aEy());
        paramString.putExtra("username", ((com.tencent.mm.modelfriend.a)paramn).getUsername());
        paramString.putExtra("password", ((com.tencent.mm.modelfriend.a)paramn).aEq());
        paramString.putExtra("nickname", ((com.tencent.mm.modelfriend.a)paramn).aEE());
        paramString.putExtra("avatar_url", ((com.tencent.mm.modelfriend.a)paramn).aED());
        paramString.putExtra("key_reg_style", this.iUm.iTZ);
        if (this.iUm.iTZ == 1)
        {
          paramString.putExtra("kintent_nickname", this.iUm.bLs);
          paramString.putExtra("kintent_password", this.iUm.iTR);
          paramString.putExtra("kintent_hasavatar", this.iUm.iUM);
        }
        paramn = this.iUm;
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(paramn, paramString.aeD(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramn.startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramn, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128439);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.rM(paramString);
        if (paramString != null)
        {
          paramString.a(this.iUm, null, null);
          AppMethodBeat.o(128439);
          return;
        }
        h.l(this.iUm, 2131756508, 2131756514);
        AppMethodBeat.o(128439);
      }
    }
    else if (paramn.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = this.iUm.iUM;
        localObject1 = this.iUm.iTR;
        localObject2 = this.iUm.bLs;
        if (this.iUm.iJk == null)
        {
          this.iUm.iJk = SecurityImage.a.a(this.iUm, 0, ((u)paramn).aHB(), ((u)paramn).aHA(), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(128424);
              com.tencent.mm.kernel.g.agi().a(126, o.this);
              paramAnonymousDialogInterface = new u("", this.iUd, this.iUe, 0, "", o.this.iUm.dnz, "", "", o.this.iUs, o.this.iUm.hSX, "", ((u)paramn).aHA(), o.this.iUm.iJk.getSecImgCode(), true, paramString.booleanValue());
              paramAnonymousDialogInterface.Di(o.this.iUm.iTi);
              paramAnonymousDialogInterface.Dj(o.this.iUm.iUT);
              com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
              MobileVerifyUI localMobileVerifyUI1 = o.this.iUm;
              MobileVerifyUI localMobileVerifyUI2 = o.this.iUm;
              o.this.iUm.getString(2131755906);
              localMobileVerifyUI1.fts = h.b(localMobileVerifyUI2, o.this.iUm.getString(2131762385), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(128423);
                  com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface);
                  com.tencent.mm.kernel.g.agi().b(126, o.this);
                  AppMethodBeat.o(128423);
                }
              });
              AppMethodBeat.o(128424);
            }
          }, null, new DialogInterface.OnDismissListener()new SecurityImage.b
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              o.this.iUm.iJk = null;
            }
          }, new SecurityImage.b()
          {
            public final void aPj()
            {
              AppMethodBeat.i(128425);
              o.this.iUm.hideVKB();
              com.tencent.mm.kernel.g.agi().a(126, o.this);
              u localu = new u("", this.iUd, this.iUe, 0, "", o.this.iUm.dnz, "", "", o.this.iUs, o.this.iUm.hSX, "", ((u)paramn).aHA(), "", true, paramString.booleanValue());
              localu.Di(o.this.iUm.iTi);
              localu.Dj(o.this.iUm.iUT);
              com.tencent.mm.kernel.g.agi().a(localu, 0);
              AppMethodBeat.o(128425);
            }
          });
          AppMethodBeat.o(128439);
          return;
        }
        this.iUm.iJk.b(0, ((u)paramn).aHB(), ((u)paramn).aHA(), "");
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        str2 = this.iUm.dnz;
        localObject4 = this.iUm.iUM;
        this.iQO.dXB = this.iUm.iUb;
        this.iQO.dCQ = 6L;
        this.iQO.aHZ();
        i = ((u)paramn).aHL();
        str1 = ((u)paramn).aHM();
        j = ((u)paramn).aHN();
        str3 = ((u)paramn).aHO();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = bv.L(str3, "wording");
        if (localMap == null) {
          break label2544;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!bs.isNullOrNil((String)localObject3)) {
          break label1978;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label2544;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!bs.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (bs.isNullOrNil((String)localObject3)) {
          break label2541;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", new Object[] { localObject4 });
      ac.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", new Object[] { Integer.valueOf(i) });
      ac.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", new Object[] { str1 });
      ac.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", new Object[] { Integer.valueOf(j) });
      ac.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.kernel.a.dz(true);
      if (((Boolean)localObject4).booleanValue())
      {
        localObject3 = b.apo() + "temp.avatar";
        localObject4 = b.apo() + "temp.avatar.hd";
        i.ma((String)localObject3, (String)localObject4);
        i.deleteFile((String)localObject3);
        f.c((String)localObject4, 156, 156, Bitmap.CompressFormat.JPEG, 90, (String)localObject3);
        new com.tencent.mm.aj.n(this.iUm, b.apo() + "temp.avatar").a(new Runnable()new Runnable
        {
          public final void run()
          {
            AppMethodBeat.i(128426);
            o.this.fwd = ((u)paramn).aHK();
            ay.hnA.aL("login_user_name", str2);
            i.deleteFile(b.apo() + "temp.avatar");
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.IL("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(o.this.iUm, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", o.this.fwd);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
                localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(o.this.iUm);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(o.this.iUm, (Intent)localObject1, (Intent)localObject2);
                o.this.iUm.finish();
                AppMethodBeat.o(128426);
                return;
                localObject1 = new Intent(o.this.iUm, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.iUy);
                ((Intent)localObject1).putExtra("alert_message", this.iUz);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(o.this.iUm);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = o.this.iUm;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$13", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.agP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.agc()).append(",").append(o.this.iUm.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.g.agP();
            com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_900_phone") + ",4");
            o.this.iUm.finish();
            AppMethodBeat.o(128426);
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(128427);
            o.this.fwd = ((u)paramn).aHK();
            ay.hnA.aL("login_user_name", str2);
            if ((str1 != null) && (str1.contains("0")))
            {
              com.tencent.mm.plugin.b.a.IL("R300_100_phone");
              if (!bool1) {
                localObject1 = new Intent(o.this.iUm, FindMContactIntroUI.class);
              }
              for (;;)
              {
                ((Intent)localObject1).addFlags(67108864);
                ((Intent)localObject1).putExtra("regsetinfo_ticket", o.this.fwd);
                ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
                ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
                localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(o.this.iUm);
                ((Intent)localObject2).addFlags(67108864);
                MMWizardActivity.b(o.this.iUm, (Intent)localObject1, (Intent)localObject2);
                o.this.iUm.finish();
                AppMethodBeat.o(128427);
                return;
                localObject1 = new Intent(o.this.iUm, FindMContactAlertUI.class);
                ((Intent)localObject1).putExtra("alert_title", this.iUy);
                ((Intent)localObject1).putExtra("alert_message", this.iUz);
              }
            }
            Object localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(o.this.iUm);
            ((Intent)localObject2).addFlags(67108864);
            Object localObject1 = o.this.iUm;
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic$14", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localObject1 = new StringBuilder();
            com.tencent.mm.kernel.g.agP();
            localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.agc()).append(",").append(o.this.iUm.getClass().getName()).append(",R200_900_phone,");
            com.tencent.mm.kernel.g.agP();
            com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_900_phone") + ",4");
            o.this.iUm.finish();
            AppMethodBeat.o(128427);
          }
        });
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.rM(paramString);
        if (localObject1 == null) {
          break label2419;
        }
        ((com.tencent.mm.h.a)localObject1).a(this.iUm, null, null);
        AppMethodBeat.o(128439);
        return;
        label1978:
        int k = bs.aLy((String)localObject3);
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
        this.fwd = ((u)paramn).aHK();
        ay.hnA.aL("login_user_name", str2);
        if ((str1 != null) && (str1.contains("0")))
        {
          com.tencent.mm.plugin.b.a.IL("R300_100_phone");
          if (!bool1) {}
          for (localObject1 = new Intent(this.iUm, FindMContactIntroUI.class);; localObject1 = localObject3)
          {
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("regsetinfo_ticket", this.fwd);
            ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
            ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
            localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(this.iUm);
            ((Intent)localObject2).addFlags(67108864);
            ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
            MMWizardActivity.b(this.iUm, (Intent)localObject1, (Intent)localObject2);
            this.iUm.finish();
            break;
            localObject3 = new Intent(this.iUm, FindMContactAlertUI.class);
            ((Intent)localObject3).putExtra("alert_title", (String)localObject1);
            ((Intent)localObject3).putExtra("alert_message", (String)localObject2);
          }
        }
        localObject2 = com.tencent.mm.plugin.account.a.a.iyx.bD(this.iUm);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
        localObject1 = this.iUm;
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MobileVerifyUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/account/ui/MobileVerifyRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.agc()).append(",").append(this.iUm.getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("R200_900_phone") + ",4");
        this.iUm.finish();
      }
      label2419:
      if (this.iUm.n(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(128439);
        return;
      }
      if ((paramn.getType() == 252) || (paramn.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.rM(paramString);
        if ((paramString != null) && (paramString.a(this.iUm, null, null)))
        {
          AppMethodBeat.o(128439);
          return;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this.iUm, this.iUm.getString(2131756507, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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
    com.tencent.mm.kernel.g.agi().a(126, this);
    AppMethodBeat.o(128436);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(128437);
    com.tencent.mm.kernel.g.agi().b(126, this);
    AppMethodBeat.o(128437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o
 * JD-Core Version:    0.7.0.1
 */