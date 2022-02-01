package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.facebook.AccessToken;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.ms;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.i.a.c.a;
import com.tencent.mm.ui.i.a.d.a;
import com.tencent.mm.ui.i.a.d.b;
import org.json.JSONObject;

public class FacebookLoginUI
  extends MMPreference
  implements i
{
  private static final String[] nbW = { "public_profile", "email", "user_location" };
  private String fXu;
  private String mTu;
  private DialogInterface.OnCancelListener nbU;
  private IListener ncA;
  private com.tencent.mm.ui.i.a.c ncL;
  private s ncM;
  private com.tencent.mm.modelsimple.t ncN;
  private ms ncO;
  private c ncP;
  boolean ncQ;
  private com.tencent.mm.ui.i.a.d ncv;
  private String ncy;
  
  public FacebookLoginUI()
  {
    AppMethodBeat.i(127999);
    this.ncy = "";
    this.fXu = "";
    this.ncO = new ms();
    this.ncA = new FacebookLoginUI.1(this);
    this.ncQ = true;
    AppMethodBeat.o(127999);
  }
  
  private void bzm()
  {
    AppMethodBeat.i(128006);
    if (isFinishing())
    {
      AppMethodBeat.o(128006);
      return;
    }
    getString(r.j.app_tip);
    this.ncM = com.tencent.mm.ui.base.h.a(this, getString(r.j.login_logining), true, null);
    this.ncM.setOnCancelListener(this.nbU);
    Log.i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", new Object[] { "facebook@wechat_auth", Integer.valueOf(this.ncy.length()), this.ncy.substring(0, 4) });
    this.ncN = new com.tencent.mm.modelsimple.t("facebook@wechat_auth", this.ncy, 0, "", "", "", 0, "", true, false);
    com.tencent.mm.kernel.h.aGY().a(this.ncN, 0);
    AppMethodBeat.o(128006);
  }
  
  private void bzn()
  {
    AppMethodBeat.i(128007);
    if (r.u(this, "com.facebook.katana"))
    {
      if (this.ncv == null)
      {
        this.ncv = new com.tencent.mm.ui.i.a.d(getString(r.j.facebook_app_id));
        this.ncv.hWT();
      }
      if (!this.ncv.hWS())
      {
        this.ncv.dbv();
        this.ncv.a(this, new d.b()
        {
          public final void onCancel()
          {
            AppMethodBeat.i(127984);
            Log.i("MicroMsg.FacebookLoginUI", "facebook-android login cancel!");
            AppMethodBeat.o(127984);
          }
          
          public final void onError(String paramAnonymousString)
          {
            AppMethodBeat.i(127985);
            Log.i("MicroMsg.FacebookLoginUI", "facebook-android login error! %s", new Object[] { paramAnonymousString });
            com.tencent.mm.ui.base.h.c(FacebookLoginUI.this, FacebookLoginUI.this.getString(r.j.facebook_auth_failed), "", true);
            AppMethodBeat.o(127985);
          }
          
          public final void onSuccess()
          {
            AppMethodBeat.i(127983);
            Log.i("MicroMsg.FacebookLoginUI", "facebook-android login success!");
            FacebookLoginUI.a(FacebookLoginUI.this, FacebookLoginUI.a(FacebookLoginUI.this).XGX.getToken());
            FacebookLoginUI.b(FacebookLoginUI.this);
            AppMethodBeat.o(127983);
          }
        }, nbW);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(582L, 5L, 1L, false);
      AppMethodBeat.o(128007);
      return;
      bzm();
      continue;
      try
      {
        if (this.ncL != null) {
          this.ncL.lv(this);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L14,");
        com.tencent.mm.kernel.h.aHE();
        com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("L14") + ",1");
        this.ncL = new com.tencent.mm.ui.i.a.c(getString(r.j.facebook_app_id));
        this.ncL.a(this, nbW, new a((byte)0));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FacebookLoginUI", localException, "", new Object[0]);
        }
      }
    }
  }
  
  private void bzo()
  {
    AppMethodBeat.i(128009);
    String str = getString(r.j.create_forbiden_uri, new Object[] { "0x" + Integer.toHexString(com.tencent.mm.protocal.d.RAD), LocaleUtil.getApplicationLanguage() });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", str);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
    com.tencent.mm.plugin.account.sdk.a.mIG.h(localIntent, this);
    AppMethodBeat.o(128009);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128005);
    com.tencent.mm.plugin.b.a.bkD(this.mTu);
    finish();
    AppMethodBeat.o(128005);
  }
  
  public int getResourceId()
  {
    return r.k.facebook_login;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128010);
    this.ncL = new com.tencent.mm.ui.i.a.c(getString(r.j.facebook_app_id));
    this.nbU = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(127981);
        if (FacebookLoginUI.h(FacebookLoginUI.this) != null) {
          com.tencent.mm.kernel.h.aGY().a(FacebookLoginUI.h(FacebookLoginUI.this));
        }
        AppMethodBeat.o(127981);
      }
    };
    bzn();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(127982);
        FacebookLoginUI.i(FacebookLoginUI.this);
        AppMethodBeat.o(127982);
        return true;
      }
    });
    AppMethodBeat.o(128010);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(128011);
    boolean bool;
    String str;
    int j;
    if (paramIntent == null)
    {
      bool = true;
      Log.i("MicroMsg.FacebookLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label171;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      j = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = Util.isNullOrNil(str);
      if (!Util.isNullOrNil(str)) {
        break label161;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.FacebookLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if (j != -217) {
        break label171;
      }
      bzn();
      AppMethodBeat.o(128011);
      return;
      bool = false;
      break;
      label161:
      i = str.length();
    }
    label171:
    if (this.ncL != null) {
      this.ncL.j(paramInt1, paramInt2, paramIntent);
    }
    if (this.ncv != null) {
      this.ncv.j(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(128011);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128000);
    super.onCreate(paramBundle);
    setMMTitle(r.j.login_by_facebook);
    com.tencent.mm.plugin.account.sdk.a.mIH.abF();
    this.mTu = com.tencent.mm.plugin.b.a.bAt();
    initView();
    com.tencent.mm.kernel.h.aGY().a(701, this);
    com.tencent.mm.kernel.h.aGY().a(252, this);
    AppMethodBeat.o(128000);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128001);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    AppMethodBeat.o(128001);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(128004);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(128004);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(128004);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(128003);
    super.onPause();
    EventCenter.instance.removeListener(this.ncA);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L100_200_FB,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(false, com.tencent.mm.kernel.b.MN("L100_200_FB") + ",2");
    AppMethodBeat.o(128003);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(128012);
    paramf = paramPreference.mKey;
    if (paramf == null)
    {
      Log.e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
      AppMethodBeat.o(128012);
      return true;
    }
    if (paramf.equals("facebook_auth_bind_btn"))
    {
      bzn();
      AppMethodBeat.o(128012);
      return true;
    }
    AppMethodBeat.o(128012);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128002);
    EventCenter.instance.addListener(this.ncA);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.aHE();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(getClass().getName()).append(",L100_200_FB,");
    com.tencent.mm.kernel.h.aHE();
    com.tencent.mm.plugin.b.a.m(true, com.tencent.mm.kernel.b.MN("L100_200_FB") + ",1");
    com.tencent.mm.plugin.b.a.bgi("L100_200_FB");
    AppMethodBeat.o(128002);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(128008);
    Log.i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", new Object[] { Integer.valueOf(paramq.hashCode()), Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.ncM != null)
    {
      this.ncM.dismiss();
      this.ncM = null;
    }
    if (!Util.isTopActivity(this))
    {
      AppMethodBeat.o(128008);
      return;
    }
    if (!(paramq instanceof com.tencent.mm.modelsimple.t))
    {
      AppMethodBeat.o(128008);
      return;
    }
    this.fXu = ((com.tencent.mm.modelsimple.t)paramq).boA();
    int j = 0;
    int i;
    if (paramq.getType() != 252)
    {
      i = j;
      if (paramq.getType() != 701) {}
    }
    else
    {
      i = j;
      if (paramInt1 == 4) {
        if (paramInt2 != -16)
        {
          i = j;
          if (paramInt2 != -17) {}
        }
        else
        {
          i = 1;
          com.tencent.mm.kernel.h.aGY().a(new bv(new bv.a()
          {
            public final void a(g paramAnonymousg)
            {
              AppMethodBeat.i(127992);
              if (paramAnonymousg == null)
              {
                AppMethodBeat.o(127992);
                return;
              }
              paramAnonymousg = paramAnonymousg.biw();
              com.tencent.mm.kernel.h.aHE();
              int i = com.tencent.mm.kernel.b.getUin();
              paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
              AppMethodBeat.o(127992);
            }
          }), 0);
        }
      }
    }
    if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      com.tencent.mm.kernel.b.aGG();
      com.tencent.mm.plugin.account.friend.a.l.byn();
      this.ncO.gVr = 1L;
      this.ncO.gef = 12L;
      this.ncO.bpa();
      y.ZV(z.bcZ());
      com.tencent.mm.platformtools.t.jdMethod_do(this);
      y.showAddrBookUploadConfirm(this, new FacebookLoginUI.10(this), false, 2);
      AppMethodBeat.o(128008);
      return;
    }
    if (paramInt2 == -106)
    {
      y.f(this, paramString, 0);
      AppMethodBeat.o(128008);
      return;
    }
    if (paramInt2 == -217)
    {
      y.a(this, com.tencent.mm.platformtools.e.d((com.tencent.mm.modelsimple.t)paramq), paramInt2);
      AppMethodBeat.o(128008);
      return;
    }
    if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
    {
      if (this.ncP == null) {
        this.ncP = new c()
        {
          public final q a(q paramAnonymousq, String paramAnonymousString)
          {
            AppMethodBeat.i(127994);
            paramAnonymousq = new com.tencent.mm.modelsimple.t("facebook@wechat_auth", FacebookLoginUI.g(FacebookLoginUI.this), ((com.tencent.mm.modelsimple.t)paramAnonymousq).getSecCodeType(), paramAnonymousString, ((com.tencent.mm.modelsimple.t)paramAnonymousq).boB(), ((com.tencent.mm.modelsimple.t)paramAnonymousq).boD(), 0, "", true, false);
            AppMethodBeat.o(127994);
            return paramAnonymousq;
          }
        };
      }
      paramString = this.ncP;
      byte[] arrayOfByte = ((com.tencent.mm.modelsimple.t)paramq).boC();
      paramString.nbK = paramq;
      if (paramString.mUP == null)
      {
        paramString.mUP = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, 0, arrayOfByte, "", "", new c.1(paramString, this), null, new c.2(paramString), paramString);
        AppMethodBeat.o(128008);
        return;
      }
      paramString.mUP.b(0, arrayOfByte, "", "");
      AppMethodBeat.o(128008);
      return;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (com.tencent.mm.plugin.account.sdk.a.mIH.a(getContext(), paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      break;
    }
    while (i != 0)
    {
      AppMethodBeat.o(128008);
      return;
      if (com.tencent.mm.kernel.h.aGY().bih() == 5)
      {
        com.tencent.mm.ui.base.h.p(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
        i = 1;
      }
      else
      {
        com.tencent.mm.ui.base.h.p(this, r.j.errcode_password, r.j.login_err_title);
        i = 1;
        continue;
        com.tencent.mm.ui.base.h.p(this, r.j.login_err_mailnotverify, r.j.login_err_title);
        i = 1;
        continue;
        com.tencent.mm.ui.base.h.p(getContext(), r.j.regbyqq_auth_err_failed_niceqq, r.j.app_tip);
        i = 1;
        continue;
        y.dw(getContext());
        i = 1;
        continue;
        this.ncO.gVr = 1L;
        this.ncO.gef = 11L;
        this.ncO.bpa();
        com.tencent.mm.ui.base.h.c(this, getString(r.j.facebooklogin_user_not_bind), "", getString(r.j.regsetinfo_register), getString(r.j.loginby_mobile_other_login), new DialogInterface.OnClickListener()new FacebookLoginUI.8
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(127990);
            if (com.tencent.mm.protocal.d.RAG)
            {
              FacebookLoginUI.e(FacebookLoginUI.this);
              AppMethodBeat.o(127990);
              return;
            }
            FacebookLoginUI.f(FacebookLoginUI.this);
            AppMethodBeat.o(127990);
          }
        }, new FacebookLoginUI.8(this));
        i = 1;
        continue;
        if (com.tencent.mm.protocal.d.RAG) {
          bzo();
        }
        i = 1;
        continue;
        i = 0;
      }
    }
    if ((paramq.getType() == 252) || (paramq.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.Kb(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128008);
        return;
      }
    }
    Toast.makeText(this, getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(128008);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements c.a
  {
    private a() {}
    
    public final void K(Bundle paramBundle)
    {
      AppMethodBeat.i(127995);
      FacebookLoginUI.a(FacebookLoginUI.this, FacebookLoginUI.d(FacebookLoginUI.this).mRq);
      FacebookLoginUI.b(FacebookLoginUI.this);
      AppMethodBeat.o(127995);
    }
    
    public final void a(com.tencent.mm.ui.i.a.b paramb)
    {
      AppMethodBeat.i(127997);
      Log.d("MicroMsg.FacebookLoginUI", "onError:" + paramb.getMessage());
      com.tencent.mm.ui.base.h.c(FacebookLoginUI.this, paramb.getMessage(), FacebookLoginUI.this.getString(r.j.facebook_auth_failed), true);
      FacebookLoginUI.bzp();
      paramb = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      paramb = paramb.append(com.tencent.mm.kernel.b.aGR()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("L14") + ",2");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(582L, 8L, 1L, false);
      AppMethodBeat.o(127997);
    }
    
    public final void a(com.tencent.mm.ui.i.a.e parame)
    {
      AppMethodBeat.i(127996);
      Log.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + parame.getMessage());
      com.tencent.mm.ui.base.h.c(FacebookLoginUI.this, parame.getMessage(), FacebookLoginUI.this.getString(r.j.facebook_auth_failed), true);
      FacebookLoginUI.bzp();
      parame = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      parame = parame.append(com.tencent.mm.kernel.b.aGR()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("L14") + ",2");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(582L, 7L, 1L, false);
      AppMethodBeat.o(127996);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(127998);
      Log.d("MicroMsg.FacebookLoginUI", "onCancel");
      FacebookLoginUI.bzp();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.aHE();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.b.aGR()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
      com.tencent.mm.kernel.h.aHE();
      com.tencent.mm.plugin.b.a.KP(com.tencent.mm.kernel.b.MN("L14") + ",2");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(582L, 9L, 1L, false);
      AppMethodBeat.o(127998);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI
 * JD-Core Version:    0.7.0.1
 */