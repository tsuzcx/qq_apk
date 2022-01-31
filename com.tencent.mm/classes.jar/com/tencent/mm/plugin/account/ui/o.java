package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.bind.ui.FindMContactAlertUI;
import com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI;
import com.tencent.mm.plugin.account.model.i;
import com.tencent.mm.plugin.account.model.i.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class o
  implements f, MobileVerifyUI.b
{
  String dqS;
  g foc = null;
  MobileVerifyUI fpj;
  String fpp;
  private boolean fpq = true;
  
  public final void a(MobileVerifyUI paramMobileVerifyUI)
  {
    this.fpj = paramMobileVerifyUI;
  }
  
  public final boolean a(final MobileVerifyUI.a parama)
  {
    switch (o.8.fpn[parama.ordinal()])
    {
    default: 
      return false;
    case 1: 
      h.a(this.fpj, this.fpj.getString(q.j.mobile_verify_cancel_tip), "", this.fpj.getString(q.j.mobile_verify_cancel_tip_back), this.fpj.getString(q.j.mobile_verify_cancel_tip_wait), new o.9(this), new o.10(this));
      return true;
    case 2: 
      com.tencent.mm.kernel.g.Dk().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.fpj.bSe, 15, this.fpj.fcd.getText().toString().trim(), 0, "");
      parama.lS(this.fpj.fog);
      com.tencent.mm.kernel.g.Dk().a(parama, 0);
      localMobileVerifyUI1 = this.fpj;
      localMobileVerifyUI2 = this.fpj;
      this.fpj.getString(q.j.app_tip);
      localMobileVerifyUI1.dnm = h.b(localMobileVerifyUI2, this.fpj.getString(q.j.bind_mcontact_verifing), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          com.tencent.mm.kernel.g.Dk().c(parama);
          com.tencent.mm.kernel.g.Dk().b(145, o.this);
        }
      });
      return false;
    case 3: 
      com.tencent.mm.kernel.g.Dk().a(145, this);
      parama = new com.tencent.mm.modelfriend.a(this.fpj.bSe, 14, "", 0, "");
      parama.lS(this.fpj.fog);
      com.tencent.mm.kernel.g.Dk().a(parama, 0);
      i.a(i.a.fjI);
      return false;
    }
    parama = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    parama = parama.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_350_auto,");
    com.tencent.mm.kernel.g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R200_350_auto") + ",1");
    com.tencent.mm.kernel.g.Dk().a(145, this);
    parama = new com.tencent.mm.modelfriend.a(this.fpj.bSe, 15, this.fpj.fcd.getText().toString().trim(), 0, "");
    parama.lS(this.fpj.fog);
    com.tencent.mm.kernel.g.Dk().a(parama, 0);
    MobileVerifyUI localMobileVerifyUI1 = this.fpj;
    MobileVerifyUI localMobileVerifyUI2 = this.fpj;
    this.fpj.getString(q.j.app_tip);
    localMobileVerifyUI1.dnm = h.b(localMobileVerifyUI2, this.fpj.getString(q.j.bind_mcontact_verifing), true, new o.1(this, parama));
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, final com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.MobileVerifyRegLogic", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fpj.dnm != null)
    {
      this.fpj.dnm.dismiss();
      this.fpj.dnm = null;
    }
    if (paramm.getType() == 255)
    {
      com.tencent.mm.kernel.g.Dk().b(255, this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        this.fpj.cA(this.fpq);
      }
    }
    Object localObject1;
    int i;
    do
    {
      do
      {
        do
        {
          return;
          if ((paramm.getType() != 701) || (this.foc == null)) {
            break;
          }
          com.tencent.mm.kernel.g.Dk().b(701, this);
          this.foc.a(this.fpj, paramInt1, paramInt2, paramString, paramm);
        } while ((paramInt1 != 0) || (paramInt2 != 0));
        if ((paramm instanceof q)) {
          this.fpq = ((q)paramm).QH();
        }
        com.tencent.mm.kernel.g.Dk().a(255, this);
        paramString = new r(1);
        com.tencent.mm.kernel.g.Dk().a(paramString, 0);
        paramm = this.fpj;
        localObject1 = this.fpj;
        this.fpj.getString(q.j.app_tip);
        paramm.dnm = h.b((Context)localObject1, this.fpj.getString(q.j.app_loading), true, new o.12(this, paramString));
        return;
        if (paramm.getType() != 145) {
          break;
        }
        com.tencent.mm.kernel.g.Dk().b(145, this);
        i = ((com.tencent.mm.modelfriend.a)paramm).rN();
      } while (i != 15);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break;
      }
    } while (i != 15);
    if (this.fpj.foZ == 1)
    {
      this.fpp = ((com.tencent.mm.modelfriend.a)paramm).NJ();
      com.tencent.mm.kernel.g.Dk().a(126, this);
      paramString = new s("", this.fpj.foR, this.fpj.aVr, 0, "", this.fpj.bSe, "", "", this.fpp, this.fpj.eAa, "", "", "", true, this.fpj.fpL.booleanValue());
      paramString.ne(this.fpj.fog);
      com.tencent.mm.kernel.g.Dk().a(paramString, 0);
      paramm = this.fpj;
      localObject1 = this.fpj;
      this.fpj.getString(q.j.app_tip);
      paramm.dnm = h.b((Context)localObject1, this.fpj.getString(q.j.regbyqq_reg_waiting), true, new o.7(this, paramString));
      return;
    }
    paramString = new Intent();
    paramString.putExtra("regsetinfo_ticket", ((com.tencent.mm.modelfriend.a)paramm).NJ());
    paramString.putExtra("regsetinfo_user", this.fpj.bSe);
    paramString.putExtra("regsession_id", this.fpj.fog);
    paramString.putExtra("regsetinfo_ismobile", 4);
    paramString.putExtra("regsetinfo_NextControl", ((com.tencent.mm.modelfriend.a)paramm).NP());
    paramString.putExtra("key_reg_style", this.fpj.foZ);
    paramString.setClass(this.fpj, RegSetInfoUI.class);
    this.fpj.startActivity(paramString);
    i.a(i.a.fjJ);
    return;
    if (paramInt2 == -35)
    {
      paramString = com.tencent.mm.i.a.eI(paramString);
      if (paramString != null)
      {
        paramString.a(this.fpj, new o.13(this, paramm), new o.14(this));
        return;
      }
      h.a(this.fpj, this.fpj.getString(q.j.bind_mcontact_already_bind_relogin), null, new o.15(this, paramm), new o.16(this));
      return;
    }
    if (paramInt2 == -212)
    {
      paramString = new Intent(this.fpj, MobileLoginOrForceReg.class);
      paramString.putExtra("ticket", ((com.tencent.mm.modelfriend.a)paramm).NJ());
      paramString.putExtra("moble", this.fpj.bSe);
      paramString.putExtra("regsession_id", this.fpj.fog);
      paramString.putExtra("next_controll", ((com.tencent.mm.modelfriend.a)paramm).NP());
      paramString.putExtra("username", ((com.tencent.mm.modelfriend.a)paramm).getUsername());
      paramString.putExtra("password", ((com.tencent.mm.modelfriend.a)paramm).NI());
      paramString.putExtra("nickname", ((com.tencent.mm.modelfriend.a)paramm).NV());
      paramString.putExtra("avatar_url", ((com.tencent.mm.modelfriend.a)paramm).NU());
      paramString.putExtra("key_reg_style", this.fpj.foZ);
      if (this.fpj.foZ == 1)
      {
        paramString.putExtra("kintent_nickname", this.fpj.aVr);
        paramString.putExtra("kintent_password", this.fpj.foR);
        paramString.putExtra("kintent_hasavatar", this.fpj.fpL);
      }
      this.fpj.startActivity(paramString);
      return;
    }
    Object localObject2;
    String str2;
    Object localObject4;
    String str1;
    int j;
    String str3;
    boolean bool2;
    boolean bool1;
    Object localObject3;
    if (paramInt2 == -51)
    {
      paramString = com.tencent.mm.i.a.eI(paramString);
      if (paramString != null)
      {
        paramString.a(this.fpj, null, null);
        return;
      }
      h.h(this.fpj, q.j.bind_mcontact_verify_err_time_out_content, q.j.bind_mcontact_verify_tip);
      return;
      if (paramm.getType() == 126)
      {
        if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
        {
          paramString = this.fpj.bSe;
          paramString = this.fpj.fpL;
          localObject1 = this.fpj.foR;
          localObject2 = this.fpj.aVr;
          if (this.fpj.fex == null)
          {
            this.fpj.fex = SecurityImage.a.a(this.fpj, q.j.regbyqq_secimg_title, 0, ((s)paramm).QA(), ((s)paramm).Qz(), "", new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                com.tencent.mm.kernel.g.Dk().a(126, o.this);
                paramAnonymousDialogInterface = new s("", this.fpb, this.fpc, 0, "", o.this.fpj.bSe, "", "", o.this.fpp, o.this.fpj.eAa, "", ((s)paramm).Qz(), o.this.fpj.fex.getSecImgCode(), true, paramString.booleanValue());
                paramAnonymousDialogInterface.ne(o.this.fpj.fog);
                com.tencent.mm.kernel.g.Dk().a(paramAnonymousDialogInterface, 0);
                MobileVerifyUI localMobileVerifyUI1 = o.this.fpj;
                MobileVerifyUI localMobileVerifyUI2 = o.this.fpj;
                o.this.fpj.getString(q.j.app_tip);
                localMobileVerifyUI1.dnm = h.b(localMobileVerifyUI2, o.this.fpj.getString(q.j.regbyqq_reg_waiting), true, new o.2.1(this, paramAnonymousDialogInterface));
              }
            }, null, new o.3(this), new o.4(this, (String)localObject1, (String)localObject2, paramm, paramString));
            return;
          }
          this.fpj.fex.a(0, ((s)paramm).QA(), ((s)paramm).Qz(), "");
          return;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          str2 = this.fpj.bSe;
          localObject4 = this.fpj.fpL;
          localObject1 = this.fpj.foR;
          localObject1 = this.fpj.aVr;
          i = ((s)paramm).QJ();
          str1 = ((s)paramm).QK();
          j = ((s)paramm).QL();
          str3 = ((s)paramm).QM();
          localObject1 = null;
          localObject2 = null;
          bool2 = false;
          bool1 = false;
          Map localMap = bn.s(str3, "wording");
          if (localMap == null) {
            break label2091;
          }
          localObject3 = (String)localMap.get(".wording.switch");
          if (!bk.bl((String)localObject3)) {
            break label1629;
          }
          bool1 = true;
          bool2 = bool1;
          if (!bool1) {
            break label2091;
          }
          localObject3 = (String)localMap.get(".wording.title");
          if (!bk.bl((String)localObject3)) {
            localObject1 = localObject3;
          }
          localObject3 = (String)localMap.get(".wording.desc");
          if (bk.bl((String)localObject3)) {
            break label2088;
          }
          localObject2 = localObject3;
        }
      }
    }
    for (;;)
    {
      y.i("MicroMsg.MobileVerifyRegLogic", "hasSetAvatar , %s", new Object[] { localObject4 });
      y.i("MicroMsg.MobileVerifyRegLogic", "styleId , %s", new Object[] { Integer.valueOf(i) });
      y.i("MicroMsg.MobileVerifyRegLogic", "nextStep , %s", new Object[] { str1 });
      y.i("MicroMsg.MobileVerifyRegLogic", "nextStyle , %s", new Object[] { Integer.valueOf(j) });
      y.i("MicroMsg.MobileVerifyRegLogic", "mShowStyleContactUploadWordings , %s", new Object[] { str3 });
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.kernel.a.bF(true);
      if (((Boolean)localObject4).booleanValue())
      {
        localObject3 = com.tencent.mm.compatible.util.e.dzK + "temp.avatar";
        localObject4 = com.tencent.mm.compatible.util.e.dzK + "temp.avatar.hd";
        com.tencent.mm.vfs.e.aA((String)localObject3, (String)localObject4);
        com.tencent.mm.vfs.e.deleteFile((String)localObject3);
        c.c((String)localObject4, 96, 96, Bitmap.CompressFormat.JPEG, 90, (String)localObject3);
        new com.tencent.mm.ag.m(this.fpj, com.tencent.mm.compatible.util.e.dzK + "temp.avatar").a(new o.5(this, paramm, str2, str1, bool1, (String)localObject1, (String)localObject2, j), new o.6(this, paramm, str2, str1, bool1, (String)localObject1, (String)localObject2, j));
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.i.a.eI(paramString);
        if (localObject1 == null) {
          break label1994;
        }
        ((com.tencent.mm.i.a)localObject1).a(this.fpj, null, null);
        return;
        label1629:
        int k = bk.ZR((String)localObject3);
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
        this.dqS = ((s)paramm).QI();
        at.dVC.Y("login_user_name", str2);
        if ((str1 != null) && (str1.contains("0")))
        {
          com.tencent.mm.plugin.b.a.qj("R300_100_phone");
          if (!bool1) {}
          for (localObject1 = new Intent(this.fpj, FindMContactIntroUI.class);; localObject1 = localObject3)
          {
            ((Intent)localObject1).addFlags(67108864);
            ((Intent)localObject1).putExtra("regsetinfo_ticket", this.dqS);
            ((Intent)localObject1).putExtra("regsetinfo_NextStep", str1);
            ((Intent)localObject1).putExtra("regsetinfo_NextStyle", j);
            localObject2 = com.tencent.mm.plugin.account.a.a.eUR.aN(this.fpj);
            ((Intent)localObject2).addFlags(67108864);
            ((Intent)localObject2).putExtra("LauncherUI.enter_from_reg", true);
            MMWizardActivity.b(this.fpj, (Intent)localObject1, (Intent)localObject2);
            this.fpj.finish();
            break;
            localObject3 = new Intent(this.fpj, FindMContactAlertUI.class);
            ((Intent)localObject3).putExtra("alert_title", (String)localObject1);
            ((Intent)localObject3).putExtra("alert_message", (String)localObject2);
          }
        }
        localObject1 = com.tencent.mm.plugin.account.a.a.eUR.aN(this.fpj);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
        this.fpj.startActivity((Intent)localObject1);
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.DN();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.Df()).append(",").append(this.fpj.getClass().getName()).append(",R200_900_phone,");
        com.tencent.mm.kernel.g.DN();
        com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R200_900_phone") + ",4");
        this.fpj.finish();
      }
      label1994:
      if (this.fpj.h(paramInt1, paramInt2, paramString)) {
        break;
      }
      if (paramm.getType() == 701)
      {
        paramString = com.tencent.mm.i.a.eI(paramString);
        if ((paramString != null) && (paramString.a(this.fpj, null, null))) {
          break;
        }
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break;
      }
      Toast.makeText(this.fpj, this.fpj.getString(q.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      return;
      label2088:
      continue;
      label2091:
      localObject1 = null;
      bool1 = bool2;
    }
  }
  
  public final void start() {}
  
  public final void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.o
 * JD-Core Version:    0.7.0.1
 */