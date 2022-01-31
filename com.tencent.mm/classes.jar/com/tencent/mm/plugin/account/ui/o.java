package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.model.av;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.plugin.account.model.j.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class o
  implements f, MobileVerifyUI.b
{
  String eiu;
  bj gDn;
  g gFw;
  MobileVerifyUI gGG;
  String gGM;
  private boolean gGN;
  
  public o()
  {
    AppMethodBeat.i(125263);
    this.gFw = null;
    this.gGN = true;
    this.gDn = new bj();
    AppMethodBeat.o(125263);
  }
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.gGG = paramMobileVerifyUI;
  }
  
  public final boolean a(final MobileVerifyUI.a parama)
  {
    AppMethodBeat.i(125266);
    switch (o.8.gGK[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125266);
      return false;
      h.d(this.gGG, this.gGG.getString(2131301597), "", this.gGG.getString(2131301598), this.gGG.getString(2131301599), new o.9(this), new o.10(this));
      AppMethodBeat.o(125266);
      return true;
      com.tencent.mm.kernel.g.Rc().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.gGG.czF, 15, this.gGG.gtO.getText().toString().trim(), 0, "");
      parama.sQ(this.gGG.gFA);
      com.tencent.mm.kernel.g.Rc().a(parama, 0);
      MobileVerifyUI localMobileVerifyUI1 = this.gGG;
      MobileVerifyUI localMobileVerifyUI2 = this.gGG;
      this.gGG.getString(2131297087);
      localMobileVerifyUI1.eeN = h.b(localMobileVerifyUI2, this.gGG.getString(2131297610), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(125259);
          com.tencent.mm.kernel.g.Rc().a(parama);
          com.tencent.mm.kernel.g.Rc().b(145, o.this);
          AppMethodBeat.o(125259);
        }
      });
      continue;
      com.tencent.mm.kernel.g.Rc().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.gGG.czF, 14, "", 0, "");
      parama.sQ(this.gGG.gFA);
      com.tencent.mm.kernel.g.Rc().a(parama, 0);
      j.a(j.a.gAZ);
      continue;
      parama = new StringBuilder();
      com.tencent.mm.kernel.g.RJ();
      parama = parama.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",R200_350_auto,");
      com.tencent.mm.kernel.g.RJ();
      com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R200_350_auto") + ",1");
      com.tencent.mm.kernel.g.Rc().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.gGG.czF, 15, this.gGG.gtO.getText().toString().trim(), 0, "");
      parama.sQ(this.gGG.gFA);
      com.tencent.mm.kernel.g.Rc().a(parama, 0);
      localMobileVerifyUI1 = this.gGG;
      localMobileVerifyUI2 = this.gGG;
      this.gGG.getString(2131297087);
      localMobileVerifyUI1.eeN = h.b(localMobileVerifyUI2, this.gGG.getString(2131297610), true, new o.1(this, parama));
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(125267);
    ab.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.gGG.eeN != null)
    {
      this.gGG.eeN.dismiss();
      this.gGG.eeN = null;
    }
    if (paramm.getType() == 255)
    {
      com.tencent.mm.kernel.g.Rc().b(255, this);
      if ((paramInt2 == -3) && (paramInt1 == 4)) {
        this.gGG.dC(this.gGN);
      }
      AppMethodBeat.o(125267);
      return;
    }
    Object localObject1;
    if (((paramm.getType() == 701) || (paramm.getType() == 701)) && (this.gFw != null))
    {
      com.tencent.mm.kernel.g.Rc().b(701, this);
      com.tencent.mm.kernel.g.Rc().b(252, this);
      this.gFw.a(this.gGG, paramInt1, paramInt2, paramString, paramm);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramm instanceof s)) {
          this.gGN = ((s)paramm).ajP();
        }
        com.tencent.mm.kernel.g.Rc().a(255, this);
        paramString = new t(1);
        com.tencent.mm.kernel.g.Rc().a(paramString, 0);
        paramm = this.gGG;
        localObject1 = this.gGG;
        this.gGG.getString(2131297087);
        paramm.eeN = h.b((Context)localObject1, this.gGG.getString(2131296987), true, new o.12(this, paramString));
      }
      AppMethodBeat.o(125267);
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
    if (paramm.getType() == 145)
    {
      com.tencent.mm.kernel.g.Rc().b(145, this);
      i = ((com.tencent.mm.modelfriend.a)paramm).Ac();
      if (i != 15)
      {
        AppMethodBeat.o(125267);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 15)
        {
          if (this.gGG.gGt == 1)
          {
            this.gGM = ((com.tencent.mm.modelfriend.a)paramm).agx();
            com.tencent.mm.kernel.g.Rc().a(126, this);
            paramString = new u("", this.gGG.gGl, this.gGG.blZ, 0, "", this.gGG.czF, "", "", this.gGM, this.gGG.fPQ, "", "", "", true, this.gGG.gHh.booleanValue());
            paramString.uq(this.gGG.gFA);
            paramString.ur(this.gGG.gHo);
            com.tencent.mm.kernel.g.Rc().a(paramString, 0);
            paramm = this.gGG;
            localObject1 = this.gGG;
            this.gGG.getString(2131297087);
            paramm.eeN = h.b((Context)localObject1, this.gGG.getString(2131302482), true, new o.7(this, paramString));
            AppMethodBeat.o(125267);
            return;
          }
          paramString = new Intent();
          paramString.putExtra("regsetinfo_ticket", ((com.tencent.mm.modelfriend.a)paramm).agx());
          paramString.putExtra("regsetinfo_user", this.gGG.czF);
          paramString.putExtra("regsession_id", this.gGG.gFA);
          paramString.putExtra("reg_3d_app_ticket", this.gGG.gHo);
          paramString.putExtra("reg_3d_app_type", this.gGG.gGv);
          paramString.putExtra("regsetinfo_ismobile", 4);
          paramString.putExtra("regsetinfo_NextControl", ((com.tencent.mm.modelfriend.a)paramm).agD());
          paramString.putExtra("key_reg_style", this.gGG.gGt);
          paramString.setClass(this.gGG, RegSetInfoUI.class);
          this.gGG.startActivity(paramString);
          j.a(j.a.gBa);
        }
        AppMethodBeat.o(125267);
        return;
      }
      if (paramInt2 == -35)
      {
        paramString = com.tencent.mm.h.a.kO(paramString);
        this.gDn.cXw = this.gGG.gGv;
        this.gDn.cRH = 7L;
        this.gDn.ake();
        if (paramString != null)
        {
          paramString.a(this.gGG, new o.13(this, paramm), new o.14(this));
          AppMethodBeat.o(125267);
          return;
        }
        h.a(this.gGG, this.gGG.getString(2131297552), null, new o.15(this, paramm), new o.16(this));
        AppMethodBeat.o(125267);
        return;
      }
      if (paramInt2 == -212)
      {
        paramString = new Intent(this.gGG, MobileLoginOrForceReg.class);
        paramString.putExtra("ticket", ((com.tencent.mm.modelfriend.a)paramm).agx());
        paramString.putExtra("moble", this.gGG.czF);
        paramString.putExtra("regsession_id", this.gGG.gFA);
        paramString.putExtra("reg_3d_app_ticket", this.gGG.gHo);
        paramString.putExtra("reg_3d_app_type", this.gGG.gGv);
        paramString.putExtra("next_controll", ((com.tencent.mm.modelfriend.a)paramm).agD());
        paramString.putExtra("username", ((com.tencent.mm.modelfriend.a)paramm).getUsername());
        paramString.putExtra("password", ((com.tencent.mm.modelfriend.a)paramm).agw());
        paramString.putExtra("nickname", ((com.tencent.mm.modelfriend.a)paramm).agJ());
        paramString.putExtra("avatar_url", ((com.tencent.mm.modelfriend.a)paramm).agI());
        paramString.putExtra("key_reg_style", this.gGG.gGt);
        if (this.gGG.gGt == 1)
        {
          paramString.putExtra("kintent_nickname", this.gGG.blZ);
          paramString.putExtra("kintent_password", this.gGG.gGl);
          paramString.putExtra("kintent_hasavatar", this.gGG.gHh);
        }
        this.gGG.startActivity(paramString);
        AppMethodBeat.o(125267);
        return;
      }
      if (paramInt2 == -51)
      {
        paramString = com.tencent.mm.h.a.kO(paramString);
        if (paramString != null)
        {
          paramString.a(this.gGG, null, null);
          AppMethodBeat.o(125267);
          return;
        }
        h.h(this.gGG, 2131297615, 2131297621);
        AppMethodBeat.o(125267);
      }
    }
    else if (paramm.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = this.gGG.gHh;
        localObject1 = this.gGG.gGl;
        localObject2 = this.gGG.blZ;
        if (this.gGG.gwg == null)
        {
          this.gGG.gwg = SecurityImage.a.a(this.gGG, 0, ((u)paramm).ajH(), ((u)paramm).ajG(), "", new o.2(this, (String)localObject1, (String)localObject2, paramm, paramString), null, new o.3(this), new o.4(this, (String)localObject1, (String)localObject2, paramm, paramString));
          AppMethodBeat.o(125267);
          return;
        }
        this.gGG.gwg.b(0, ((u)paramm).ajH(), ((u)paramm).ajG(), "");
        AppMethodBeat.o(125267);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        str2 = this.gGG.czF;
        localObject4 = this.gGG.gHh;
        this.gDn.cXw = this.gGG.gGv;
        this.gDn.cRH = 6L;
        this.gDn.ake();
        i = ((u)paramm).ajR();
        str1 = ((u)paramm).ajS();
        j = ((u)paramm).ajT();
        str3 = ((u)paramm).ajU();
        localObject1 = null;
        localObject2 = null;
        bool2 = false;
        bool1 = false;
        Map localMap = br.F(str3, "wording");
        if (localMap == null) {
          break label2320;
        }
        localObject3 = (String)localMap.get(".wording.switch");
        if (!bo.isNullOrNil((String)localObject3)) {
          break label1830;
        }
        bool1 = true;
        bool2 = bool1;
        if (!bool1) {
          break label2320;
        }
        localObject3 = (String)localMap.get(".wording.title");
        if (!bo.isNullOrNil((String)localObject3)) {
          localObject1 = localObject3;
        }
        localObject3 = (String)localMap.get(".wording.desc");
        if (bo.isNullOrNil((String)localObject3)) {
          break label2317;
        }
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", new Object[] { localObject4 });
      ab.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", new Object[] { Integer.valueOf(i) });
      ab.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", new Object[] { str1 });
      ab.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", new Object[] { Integer.valueOf(j) });
      ab.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.kernel.a.cv(true);
      if (((Boolean)localObject4).booleanValue())
      {
        localObject3 = com.tencent.mm.compatible.util.e.esy + "temp.avatar";
        localObject4 = com.tencent.mm.compatible.util.e.esy + "temp.avatar.hd";
        com.tencent.mm.vfs.e.aT((String)localObject3, (String)localObject4);
        com.tencent.mm.vfs.e.deleteFile((String)localObject3);
        d.c((String)localObject4, 96, 96, Bitmap.CompressFormat.JPEG, 90, (String)localObject3);
        new com.tencent.mm.ah.m(this.gGG, com.tencent.mm.compatible.util.e.esy + "temp.avatar").a(new o.5(this, paramm, str2, str1, bool1, (String)localObject1, (String)localObject2, j), new o.6(this, paramm, str2, str1, bool1, (String)localObject1, (String)localObject2, j));
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.h.a.kO(paramString);
        if (localObject1 == null) {
          break label2195;
        }
        ((com.tencent.mm.h.a)localObject1).a(this.gGG, null, null);
        AppMethodBeat.o(125267);
        return;
        label1830:
        int k = bo.apV((String)localObject3);
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
        this.eiu = ((u)paramm).ajQ();
        av.flM.ao("login_user_name", str2);
        if ((str1 != null) && (str1.contains("0")))
        {
          com.tencent.mm.plugin.b.a.xD("R300_100_phone");
          if (!bool1) {}
          for (localObject1 = new Intent(this.gGG, FindMContactIntroUI.class);; localObject1 = localObject3)
          {
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("regsetinfo_ticket", this.eiu);
            ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
            ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
            localObject2 = com.tencent.mm.plugin.account.a.a.gmO.bm(this.gGG);
            ((Intent)localObject2).addFlags(67108864);
            ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
            MMWizardActivity.b(this.gGG, (Intent)localObject1, (Intent)localObject2);
            this.gGG.finish();
            break;
            localObject3 = new Intent(this.gGG, FindMContactAlertUI.class);
            ((Intent)localObject3).putExtra("alert_title", (String)localObject1);
            ((Intent)localObject3).putExtra("alert_message", (String)localObject2);
          }
        }
        localObject1 = com.tencent.mm.plugin.account.a.a.gmO.bm(this.gGG);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
        this.gGG.startActivity((Intent)localObject1);
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.RJ();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.QX()).append(",").append(this.gGG.getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.g.RJ();
        com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("R200_900_phone") + ",4");
        this.gGG.finish();
      }
      label2195:
      if (this.gGG.l(paramInt1, paramInt2, paramString))
      {
        AppMethodBeat.o(125267);
        return;
      }
      if ((paramm.getType() == 252) || (paramm.getType() == 701))
      {
        paramString = com.tencent.mm.h.a.kO(paramString);
        if ((paramString != null) && (paramString.a(this.gGG, null, null)))
        {
          AppMethodBeat.o(125267);
          return;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText(this.gGG, this.gGG.getString(2131297614, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      AppMethodBeat.o(125267);
      return;
      label2317:
      continue;
      label2320:
      localObject1 = null;
      bool1 = bool2;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(125264);
    com.tencent.mm.kernel.g.Rc().a(126, this);
    AppMethodBeat.o(125264);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(125265);
    com.tencent.mm.kernel.g.Rc().b(126, this);
    AppMethodBeat.o(125265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o
 * JD-Core Version:    0.7.0.1
 */