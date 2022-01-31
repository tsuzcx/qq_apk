package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.at;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.platformtools.ag;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;

public class MobileLoginOrForceReg
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private String bJY;
  private String bSe;
  private String caS;
  protected ProgressDialog dnm = null;
  private ImageView doU;
  private TextView doV;
  private int eAa;
  private TextView fce;
  private SecurityImage fex = null;
  private com.tencent.mm.sdk.b.c flH = new MobileLoginOrForceReg.12(this);
  private f fmA = null;
  private com.tencent.mm.platformtools.c fmK;
  private Button foM;
  private Button foN;
  private LinearLayout foO;
  private LinearLayout foP;
  private int foQ;
  private String foR;
  private String foS;
  private int foT;
  private String foU;
  private boolean foV = true;
  private boolean foW;
  private String foX;
  private String foY;
  private int foZ;
  private g foc = null;
  private String fog;
  private ah handler = new MobileLoginOrForceReg.1(this);
  private String nickname;
  private String username;
  
  private void goBack()
  {
    com.tencent.mm.plugin.b.a.qj("R200_100");
    if (this.foZ == 1) {}
    for (Object localObject = new Intent(this, RegByMobileRegAIOUI.class);; localObject = new Intent(this, MobileInputUI.class))
    {
      ((Intent)localObject).putExtra("mobile_input_purpose", 2);
      ((Intent)localObject).addFlags(67108864);
      startActivity((Intent)localObject);
      com.tencent.mm.plugin.b.a.qi(this.foU);
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.DN();
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_600,");
      com.tencent.mm.kernel.g.DN();
      com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R200_600") + ",2");
      finish();
      return;
    }
  }
  
  protected final int getLayoutId()
  {
    return q.g.mobile_login_or_force_reg;
  }
  
  public final void initView()
  {
    this.foM = ((Button)findViewById(q.f.continue_login));
    this.foN = ((Button)findViewById(q.f.force_reg));
    this.foO = ((LinearLayout)findViewById(q.f.has_avatar));
    this.foP = ((LinearLayout)findViewById(q.f.no_avatar));
    this.doU = ((ImageView)findViewById(q.f.avatar_iv));
    this.doV = ((TextView)findViewById(q.f.nickname_tv));
    this.fce = ((TextView)findViewById(q.f.bind_mcontact_verify_hint));
    new ar();
    Object localObject;
    if (this.bSe.startsWith("+"))
    {
      localObject = ar.Ga(this.bSe);
      if (!bk.bl((String)localObject))
      {
        String str = this.bSe.substring(((String)localObject).length() + 1);
        localObject = "+" + (String)localObject + " " + ar.formatNumber((String)localObject, str);
      }
    }
    for (;;)
    {
      this.fce.setText((CharSequence)localObject);
      if ((!bk.bl(this.nickname)) || (!bk.bl(this.foS))) {
        break;
      }
      this.foP.setVisibility(0);
      this.foO.setVisibility(8);
      this.foM.setOnClickListener(new MobileLoginOrForceReg.14(this));
      this.foN.setOnClickListener(new MobileLoginOrForceReg.15(this));
      setMMTitle(q.j.mobile_input_already_bind_title_welcome_back);
      setBackBtn(new MobileLoginOrForceReg.16(this));
      return;
      localObject = this.bSe;
      continue;
      localObject = "+86 " + ar.formatNumber("86", this.bSe);
    }
    this.foP.setVisibility(8);
    this.foO.setVisibility(0);
    if (bk.bl(this.nickname)) {
      this.doV.setVisibility(8);
    }
    for (;;)
    {
      localObject = a.b.cmd().sG();
      if (localObject != null) {
        this.doU.setImageBitmap((Bitmap)localObject);
      }
      if (bk.bl(this.foS)) {
        break;
      }
      localObject = this.foS;
      com.tencent.mm.kernel.g.DS().O(new MobileLoginOrForceReg.13(this, (String)localObject));
      break;
      this.doV.setText(this.nickname);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.foU = com.tencent.mm.plugin.b.a.YA();
    com.tencent.mm.kernel.g.Dk().a(701, this);
    com.tencent.mm.kernel.g.Dk().a(126, this);
    com.tencent.mm.kernel.g.Dk().a(255, this);
    this.foZ = getIntent().getIntExtra("key_reg_style", 1);
    this.bJY = getIntent().getStringExtra("ticket");
    this.bSe = getIntent().getStringExtra("moble");
    this.foQ = getIntent().getIntExtra("next_controll", 0);
    this.username = getIntent().getStringExtra("username");
    this.foR = getIntent().getStringExtra("password");
    this.nickname = getIntent().getStringExtra("nickname");
    this.foS = getIntent().getStringExtra("avatar_url");
    this.fog = getIntent().getStringExtra("regsession_id");
    this.foT = getIntent().getIntExtra("mobile_check_type", 0);
    this.foW = getIntent().getBooleanExtra("kintent_hasavatar", false);
    this.foX = getIntent().getStringExtra("kintent_nickname");
    this.foY = getIntent().getStringExtra("kintent_password");
    if ((this.foY != null) && (this.foY.length() >= 8)) {}
    for (this.eAa = 1;; this.eAa = 4)
    {
      initView();
      this.fmK = new com.tencent.mm.platformtools.c();
      return;
    }
  }
  
  public void onDestroy()
  {
    com.tencent.mm.kernel.g.Dk().b(701, this);
    com.tencent.mm.kernel.g.Dk().b(126, this);
    com.tencent.mm.kernel.g.Dk().b(255, this);
    if (this.fmK != null) {
      this.fmK.close();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.b.a.udP.d(this.flH);
  }
  
  public void onResume()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.flH);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_600,");
    com.tencent.mm.kernel.g.DN();
    com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("R200_600") + ",1");
    com.tencent.mm.plugin.b.a.qi("R200_600");
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ah.m paramm)
  {
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (this.fmA == null) {
      this.fmA = new f();
    }
    boolean bool;
    if (paramm.getType() == 255) {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        bool = this.foV;
        paramString = new Intent(this, RegByMobileSetPwdUI.class);
        paramString.putExtra("kintent_hint", getString(q.j.settings_modify_password_tip));
        paramString.putExtra("kintent_cancelable", bool);
        startActivityForResult(paramString, 0);
      }
    }
    do
    {
      return;
      if ((paramm.getType() != 701) || (this.foc == null)) {
        break;
      }
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        this.fmA.account = this.username;
        this.fmA.fnr = this.foY;
        this.fmA.feA = ((q)paramm).Qz();
        this.fmA.fez = ((q)paramm).QA();
        this.fmA.feB = ((q)paramm).QB();
        this.fmA.fns = ((q)paramm).getSecCodeType();
        if (this.fex == null)
        {
          this.fex = SecurityImage.a.a(this, q.j.regbyqq_secimg_title, this.fmA.fns, this.fmA.fez, this.fmA.feA, this.fmA.feB, new MobileLoginOrForceReg.17(this), null, new MobileLoginOrForceReg.18(this), this.fmA);
          return;
        }
        this.fex.a(this.fmA.fns, this.fmA.fez, this.fmA.feA, this.fmA.feB);
        return;
      }
      this.caS = ((q)paramm).Qy();
      this.foc.a(this, paramInt1, paramInt2, paramString, paramm);
      if ((paramm instanceof q)) {
        this.foV = ((q)paramm).QH();
      }
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = new r(1);
    com.tencent.mm.kernel.g.Dk().a(paramString, 0);
    getString(q.j.app_tip);
    this.dnm = h.b(this, getString(q.j.app_loading), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        com.tencent.mm.kernel.g.Dk().c(paramString);
      }
    });
    return;
    Object localObject2;
    if (paramm.getType() == 126)
    {
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        paramString = Boolean.valueOf(this.foW);
        localObject1 = this.foY;
        localObject2 = this.foX;
        if (this.fex == null)
        {
          this.fex = SecurityImage.a.a(this, q.j.regbyqq_secimg_title, 0, ((com.tencent.mm.modelsimple.s)paramm).QA(), ((com.tencent.mm.modelsimple.s)paramm).Qz(), "", new MobileLoginOrForceReg.2(this, (String)localObject1, (String)localObject2, paramm, paramString), null, new MobileLoginOrForceReg.3(this), new MobileLoginOrForceReg.4(this, (String)localObject1, (String)localObject2, paramm, paramString));
          return;
        }
        this.fex.a(0, ((com.tencent.mm.modelsimple.s)paramm).QA(), ((com.tencent.mm.modelsimple.s)paramm).Qz(), "");
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject1 = this.bSe;
        bool = this.foW;
        com.tencent.mm.kernel.g.DN();
        com.tencent.mm.kernel.a.unhold();
        com.tencent.mm.kernel.a.bF(true);
        if (!Boolean.valueOf(bool).booleanValue()) {
          break label789;
        }
        localObject2 = com.tencent.mm.compatible.util.e.dzK + "temp.avatar";
        String str = com.tencent.mm.compatible.util.e.dzK + "temp.avatar.hd";
        com.tencent.mm.vfs.e.aA((String)localObject2, str);
        com.tencent.mm.vfs.e.deleteFile((String)localObject2);
        com.tencent.mm.sdk.platformtools.c.c(str, 96, 96, Bitmap.CompressFormat.JPEG, 90, (String)localObject2);
        new com.tencent.mm.ag.m(this, com.tencent.mm.compatible.util.e.dzK + "temp.avatar").a(new MobileLoginOrForceReg.5(this, paramm, (String)localObject1), new MobileLoginOrForceReg.6(this, paramm, (String)localObject1));
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.i.a.eI(paramString);
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.i.a)localObject1).a(this, null, null);
        return;
        label789:
        this.bJY = ((com.tencent.mm.modelsimple.s)paramm).QI();
        at.dVC.Y("login_user_name", (String)localObject1);
        localObject1 = com.tencent.mm.plugin.account.a.a.eUR.aN(this);
        ((Intent)localObject1).addFlags(67108864);
        ((Intent)localObject1).putExtra("LauncherUI.enter_from_reg", true);
        startActivity((Intent)localObject1);
        finish();
        com.tencent.mm.plugin.b.a.qj("RE900_100");
        localObject1 = new StringBuilder();
        com.tencent.mm.kernel.g.DN();
        localObject1 = ((StringBuilder)localObject1).append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",R200_600,");
        com.tencent.mm.kernel.g.DN();
        com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("R200_600") + ",4");
      }
    }
    Object localObject1 = new ag(paramInt1, paramInt2, paramString);
    int i;
    if (this.fmK.a(this, (ag)localObject1)) {
      i = 1;
    }
    for (;;)
    {
      label958:
      if (i == 0)
      {
        if (paramm.getType() == 701)
        {
          paramString = com.tencent.mm.i.a.eI(paramString);
          if ((paramString != null) && (paramString.a(this.mController.uMN, null, null))) {
            break;
          }
        }
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break;
        }
        Toast.makeText(this.mController.uMN, getString(q.j.bind_mcontact_verify_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        return;
        i = 0;
        switch (paramInt2)
        {
        default: 
          break;
        case -140: 
          if (!bk.bl(this.caS)) {
            z.l(this.mController.uMN, paramString, this.caS);
          }
          i = 1;
          break;
        case -34: 
          Toast.makeText(this, q.j.bind_mcontact_err_freq_limit, 0).show();
          i = 1;
          break;
        case -43: 
          Toast.makeText(this, q.j.bind_mcontact_err_binded, 0).show();
          i = 1;
          break;
        case -41: 
          Toast.makeText(this, q.j.bind_mcontact_err_format, 0).show();
          i = 1;
          break;
        case -36: 
          Toast.makeText(this, q.j.bind_mcontact_err_unbinded_notbinded, 0).show();
          i = 1;
          break;
        case -32: 
          h.a(this, getString(q.j.bind_mcontact_verify_error), "", new MobileLoginOrForceReg.7(this));
          i = 1;
          break;
        case -33: 
          h.a(this, q.j.bind_mcontact_verify_err_time_out_content, q.j.bind_mcontact_verify_tip, new MobileLoginOrForceReg.8(this));
          i = 1;
          break;
        case -75: 
          h.h(this, q.j.alpha_version_tip_reg, q.j.reg_username_exist_title);
          i = 1;
          break;
        case -100: 
          com.tencent.mm.kernel.g.DN();
          com.tencent.mm.kernel.a.hold();
          localObject2 = this.mController.uMN;
          com.tencent.mm.kernel.g.DN();
          if (!TextUtils.isEmpty(com.tencent.mm.kernel.a.CM())) {
            break label1391;
          }
        }
      }
    }
    for (localObject1 = com.tencent.mm.cb.a.ac(this.mController.uMN, q.j.main_err_another_place);; localObject1 = com.tencent.mm.kernel.a.CM())
    {
      h.a((Context)localObject2, (String)localObject1, this.mController.uMN.getString(q.j.app_tip), new MobileLoginOrForceReg.9(this), new MobileLoginOrForceReg.10(this));
      i = 1;
      break label958;
      break;
      label1391:
      com.tencent.mm.kernel.g.DN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileLoginOrForceReg
 * JD-Core Version:    0.7.0.1
 */