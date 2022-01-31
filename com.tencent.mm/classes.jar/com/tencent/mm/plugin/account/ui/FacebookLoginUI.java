package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;

public class FacebookLoginUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private String caS = "";
  private String fcX;
  private com.tencent.mm.sdk.b.c flH = new FacebookLoginUI.1(this);
  private com.tencent.mm.ui.f.a.c flS;
  private String flT = "";
  private q flU;
  private b flV;
  boolean flW = true;
  private ProgressDialog flc;
  private DialogInterface.OnCancelListener fld;
  
  private void XG()
  {
    try
    {
      if (this.flS != null) {
        this.flS.hc(this);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      g.DN();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L14,");
      g.DN();
      com.tencent.mm.plugin.b.a.qk(com.tencent.mm.kernel.a.gd("L14") + ",1");
      this.flS = new com.tencent.mm.ui.f.a.c("290293790992170");
      this.flS.a(this, FacebookAuthUI.flD, new FacebookLoginUI.a(this, (byte)0));
      com.tencent.mm.plugin.report.service.h.nFQ.a(582L, 5L, 1L, false);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.FacebookLoginUI", localException, "", new Object[0]);
      }
    }
  }
  
  private void goBack()
  {
    com.tencent.mm.plugin.b.a.qj(this.fcX);
    finish();
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if (paramf == null)
    {
      y.e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
      return true;
    }
    if (paramf.equals("facebook_auth_bind_btn"))
    {
      XG();
      return true;
    }
    return false;
  }
  
  protected final void initView()
  {
    this.flS = new com.tencent.mm.ui.f.a.c("290293790992170");
    this.fld = new FacebookLoginUI.5(this);
    XG();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        FacebookLoginUI.c(FacebookLoginUI.this);
        return true;
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    boolean bool;
    String str;
    int j;
    if (paramIntent == null)
    {
      bool = true;
      y.i("MicroMsg.FacebookLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label158;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      j = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bk.bl(str);
      if (!bk.bl(str)) {
        break label148;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.FacebookLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if (j != -217) {
        break label158;
      }
      XG();
      return;
      bool = false;
      break;
      label148:
      i = str.length();
    }
    label158:
    this.flS.h(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(q.j.app_name);
    com.tencent.mm.plugin.account.a.a.eUS.tn();
    this.fcX = com.tencent.mm.plugin.b.a.YA();
    initView();
    g.Dk().a(701, this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    g.Dk().b(701, this);
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
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L100_200_FB,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(false, com.tencent.mm.kernel.a.gd("L100_200_FB") + ",2");
  }
  
  protected void onResume()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.flH);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    g.DN();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.Df()).append(",").append(getClass().getName()).append(",L100_200_FB,");
    g.DN();
    com.tencent.mm.plugin.b.a.d(true, com.tencent.mm.kernel.a.gd("L100_200_FB") + ",1");
    com.tencent.mm.plugin.b.a.qi("L100_200_FB");
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", new Object[] { Integer.valueOf(paramm.hashCode()), Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.flc != null)
    {
      this.flc.dismiss();
      this.flc = null;
    }
    if (!bk.bU(this)) {}
    while (!(paramm instanceof q)) {
      return;
    }
    this.caS = ((q)paramm).Qy();
    if ((paramm.getType() == 701) && (paramInt1 == 4) && ((paramInt2 == -16) || (paramInt2 == -17))) {
      g.Dk().a(new bi(new FacebookLoginUI.2(this)), 0);
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        com.tencent.mm.kernel.a.unhold();
        z.pi("");
        w.bL(this);
        z.showAddrBookUploadConfirm(this, new FacebookLoginUI.3(this), false, 2);
        return;
      }
      if (paramInt2 == -106)
      {
        z.e(this, paramString, 0);
        return;
      }
      if (paramInt2 == -217)
      {
        z.a(this, e.a((q)paramm), paramInt2);
        return;
      }
      Object localObject;
      if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
      {
        if (this.flV == null) {
          this.flV = new b()
          {
            public final com.tencent.mm.ah.m a(com.tencent.mm.ah.m paramAnonymousm, String paramAnonymousString)
            {
              return new q("facebook@wechat_auth", FacebookLoginUI.a(FacebookLoginUI.this), ((q)paramAnonymousm).getSecCodeType(), paramAnonymousString, ((q)paramAnonymousm).Qz(), ((q)paramAnonymousm).QB(), 0, "", true, false);
            }
          };
        }
        paramString = this.flV;
        localObject = ((q)paramm).QA();
        paramString.fkS = paramm;
        if (paramString.fex == null)
        {
          paramString.fex = SecurityImage.a.a(this, q.j.regbyqq_secimg_title, 0, (byte[])localObject, "", "", new b.1(paramString, this), null, new b.2(paramString), paramString);
          return;
        }
        paramString.fex.a(0, (byte[])localObject, "", "");
        return;
      }
      if (paramInt1 == 4) {}
      switch (paramInt2)
      {
      default: 
        if (com.tencent.mm.plugin.account.a.a.eUS.a(this.mController.uMN, paramInt1, paramInt2, paramString)) {
          i = 1;
        }
        break;
      }
      while (i == 0)
      {
        if (paramm.getType() == 701)
        {
          paramString = com.tencent.mm.i.a.eI(paramString);
          if ((paramString != null) && (paramString.a(this, null, null))) {
            break;
          }
        }
        Toast.makeText(this, getString(q.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
        return;
        if (g.Dk().KG() == 5)
        {
          com.tencent.mm.ui.base.h.h(this, q.j.net_warn_server_down_tip, q.j.net_warn_server_down);
          i = 1;
        }
        else
        {
          com.tencent.mm.ui.base.h.h(this, q.j.errcode_password, q.j.login_err_title);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.h(this, q.j.login_err_mailnotverify, q.j.login_err_title);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.h(this.mController.uMN, q.j.regbyqq_auth_err_failed_niceqq, q.j.app_tip);
          i = 1;
          continue;
          z.bT(this.mController.uMN);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.h(this.mController.uMN, q.j.facebooklogin_user_exist, q.j.app_tip);
          i = 1;
          continue;
          com.tencent.mm.ui.base.h.h(this.mController.uMN, q.j.facebooklogin_user_forbiden_reg, q.j.app_tip);
          i = 1;
          continue;
          if (d.spd)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", this.caS);
            ((Intent)localObject).putExtra("showShare", false);
            ((Intent)localObject).putExtra("show_bottom", false);
            ((Intent)localObject).putExtra("needRedirect", false);
            ((Intent)localObject).putExtra("neverGetA8Key", true);
            ((Intent)localObject).putExtra("hardcode_jspermission", JsapiPermissionWrapper.spm);
            ((Intent)localObject).putExtra("hardcode_general_ctrl", GeneralControlWrapper.spj);
            com.tencent.mm.plugin.account.a.a.eUR.j((Intent)localObject, this);
          }
          i = 1;
          continue;
          i = 0;
        }
      }
    }
  }
  
  public final int xj()
  {
    return q.k.facebook_login;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI
 * JD-Core Version:    0.7.0.1
 */