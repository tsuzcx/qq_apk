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
import com.tencent.mm.ak.i;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.model.z;
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
import com.tencent.mm.ui.h.a.b;
import com.tencent.mm.ui.h.a.c.a;
import com.tencent.mm.ui.h.a.d.a;
import com.tencent.mm.ui.h.a.d.b;
import org.json.JSONObject;

public class FacebookLoginUI
  extends MMPreference
  implements i
{
  private static final String[] kkg = { "public_profile", "email", "user_location" };
  private String edo;
  private String kbV;
  private com.tencent.mm.ui.h.a.d kkF;
  private String kkI;
  private IListener kkK;
  private com.tencent.mm.ui.h.a.c kkV;
  private com.tencent.mm.ui.base.q kkW;
  private com.tencent.mm.modelsimple.t kkX;
  private ka kkY;
  private c kkZ;
  private DialogInterface.OnCancelListener kke;
  boolean kla;
  
  public FacebookLoginUI()
  {
    AppMethodBeat.i(127999);
    this.kkI = "";
    this.edo = "";
    this.kkY = new ka();
    this.kkK = new FacebookLoginUI.1(this);
    this.kla = true;
    AppMethodBeat.o(127999);
  }
  
  private void bpa()
  {
    AppMethodBeat.i(128006);
    if (isFinishing())
    {
      AppMethodBeat.o(128006);
      return;
    }
    getString(2131755998);
    this.kkW = com.tencent.mm.ui.base.h.a(this, getString(2131762532), true, null);
    this.kkW.setOnCancelListener(this.kke);
    Log.i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", new Object[] { "facebook@wechat_auth", Integer.valueOf(this.kkI.length()), this.kkI.substring(0, 4) });
    this.kkX = new com.tencent.mm.modelsimple.t("facebook@wechat_auth", this.kkI, 0, "", "", "", 0, "", true, false);
    com.tencent.mm.kernel.g.azz().a(this.kkX, 0);
    AppMethodBeat.o(128006);
  }
  
  private void bpb()
  {
    AppMethodBeat.i(128007);
    if (r.s(this, "com.facebook.katana"))
    {
      if (this.kkF == null)
      {
        this.kkF = new com.tencent.mm.ui.h.a.d(getString(2131759094));
        this.kkF.gWp();
      }
      if (!this.kkF.gWo())
      {
        this.kkF.logout();
        this.kkF.a(this, new d.b()
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
            com.tencent.mm.ui.base.h.c(FacebookLoginUI.this, FacebookLoginUI.this.getString(2131759100), "", true);
            AppMethodBeat.o(127985);
          }
          
          public final void onSuccess()
          {
            AppMethodBeat.i(127983);
            Log.i("MicroMsg.FacebookLoginUI", "facebook-android login success!");
            FacebookLoginUI.a(FacebookLoginUI.this, FacebookLoginUI.a(FacebookLoginUI.this).QjM.getToken());
            FacebookLoginUI.b(FacebookLoginUI.this);
            AppMethodBeat.o(127983);
          }
        }, kkg);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(582L, 5L, 1L, false);
      AppMethodBeat.o(128007);
      return;
      bpa();
      continue;
      try
      {
        if (this.kkV != null) {
          this.kkV.kx(this);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.aAf();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L14,");
        com.tencent.mm.kernel.g.aAf();
        com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("L14") + ",1");
        this.kkV = new com.tencent.mm.ui.h.a.c(getString(2131759094));
        this.kkV.a(this, kkg, new a((byte)0));
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
  
  private void bpc()
  {
    AppMethodBeat.i(128009);
    String str = getString(2131758213, new Object[] { "0x" + Integer.toHexString(com.tencent.mm.protocal.d.KyO), LocaleUtil.getApplicationLanguage() });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", str);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
    com.tencent.mm.plugin.account.a.a.jRt.i(localIntent, this);
    AppMethodBeat.o(128009);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128005);
    com.tencent.mm.plugin.b.a.bwV(this.kbV);
    finish();
    AppMethodBeat.o(128005);
  }
  
  public int getResourceId()
  {
    return 2132017212;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128010);
    this.kkV = new com.tencent.mm.ui.h.a.c(getString(2131759094));
    this.kke = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(127981);
        if (FacebookLoginUI.h(FacebookLoginUI.this) != null) {
          com.tencent.mm.kernel.g.azz().a(FacebookLoginUI.h(FacebookLoginUI.this));
        }
        AppMethodBeat.o(127981);
      }
    };
    bpb();
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
      bpb();
      AppMethodBeat.o(128011);
      return;
      bool = false;
      break;
      label161:
      i = str.length();
    }
    label171:
    if (this.kkV != null) {
      this.kkV.j(paramInt1, paramInt2, paramIntent);
    }
    if (this.kkF != null) {
      this.kkF.j(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(128011);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128000);
    super.onCreate(paramBundle);
    setMMTitle(2131762497);
    com.tencent.mm.plugin.account.a.a.jRu.Xc();
    this.kbV = com.tencent.mm.plugin.b.a.bpZ();
    initView();
    com.tencent.mm.kernel.g.azz().a(701, this);
    com.tencent.mm.kernel.g.azz().a(252, this);
    AppMethodBeat.o(128000);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128001);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(701, this);
    com.tencent.mm.kernel.g.azz().b(252, this);
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
    EventCenter.instance.removeListener(this.kkK);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L100_200_FB,");
    com.tencent.mm.kernel.g.aAf();
    com.tencent.mm.plugin.b.a.j(false, com.tencent.mm.kernel.a.FN("L100_200_FB") + ",2");
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
      bpb();
      AppMethodBeat.o(128012);
      return true;
    }
    AppMethodBeat.o(128012);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128002);
    EventCenter.instance.addListener(this.kkK);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.aAf();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L100_200_FB,");
    com.tencent.mm.kernel.g.aAf();
    com.tencent.mm.plugin.b.a.j(true, com.tencent.mm.kernel.a.FN("L100_200_FB") + ",1");
    com.tencent.mm.plugin.b.a.bwU("L100_200_FB");
    AppMethodBeat.o(128002);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(128008);
    Log.i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", new Object[] { Integer.valueOf(paramq.hashCode()), Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.kkW != null)
    {
      this.kkW.dismiss();
      this.kkW = null;
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
    this.edo = ((com.tencent.mm.modelsimple.t)paramq).bfk();
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
          com.tencent.mm.kernel.g.azz().a(new bu(new bu.a()
          {
            public final void a(com.tencent.mm.network.g paramAnonymousg)
            {
              AppMethodBeat.i(127992);
              if (paramAnonymousg == null)
              {
                AppMethodBeat.o(127992);
                return;
              }
              paramAnonymousg = paramAnonymousg.aZh();
              com.tencent.mm.kernel.g.aAf();
              int i = com.tencent.mm.kernel.a.getUin();
              paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
              AppMethodBeat.o(127992);
            }
          }), 0);
        }
      }
    }
    if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.plugin.account.friend.a.l.boe();
      this.kkY.eTd = 1L;
      this.kkY.ejA = 12L;
      this.kkY.bfK();
      y.St(z.aTY());
      com.tencent.mm.platformtools.t.dr(this);
      y.showAddrBookUploadConfirm(this, new FacebookLoginUI.10(this), false, 2);
      AppMethodBeat.o(128008);
      return;
    }
    if (paramInt2 == -106)
    {
      y.g(this, paramString, 0);
      AppMethodBeat.o(128008);
      return;
    }
    if (paramInt2 == -217)
    {
      y.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramq), paramInt2);
      AppMethodBeat.o(128008);
      return;
    }
    if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
    {
      if (this.kkZ == null) {
        this.kkZ = new c()
        {
          public final com.tencent.mm.ak.q a(com.tencent.mm.ak.q paramAnonymousq, String paramAnonymousString)
          {
            AppMethodBeat.i(127994);
            paramAnonymousq = new com.tencent.mm.modelsimple.t("facebook@wechat_auth", FacebookLoginUI.g(FacebookLoginUI.this), ((com.tencent.mm.modelsimple.t)paramAnonymousq).getSecCodeType(), paramAnonymousString, ((com.tencent.mm.modelsimple.t)paramAnonymousq).bfl(), ((com.tencent.mm.modelsimple.t)paramAnonymousq).bfn(), 0, "", true, false);
            AppMethodBeat.o(127994);
            return paramAnonymousq;
          }
        };
      }
      paramString = this.kkZ;
      byte[] arrayOfByte = ((com.tencent.mm.modelsimple.t)paramq).bfm();
      paramString.kjU = paramq;
      if (paramString.kdp == null)
      {
        paramString.kdp = SecurityImage.a.a(this, 0, arrayOfByte, "", "", new c.1(paramString, this), null, new c.2(paramString), paramString);
        AppMethodBeat.o(128008);
        return;
      }
      paramString.kdp.b(0, arrayOfByte, "", "");
      AppMethodBeat.o(128008);
      return;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      break;
    }
    while (i != 0)
    {
      AppMethodBeat.o(128008);
      return;
      if (com.tencent.mm.kernel.g.azz().aYS() == 5)
      {
        com.tencent.mm.ui.base.h.n(this, 2131763503, 2131763502);
        i = 1;
      }
      else
      {
        com.tencent.mm.ui.base.h.n(this, 2131758757, 2131762516);
        i = 1;
        continue;
        com.tencent.mm.ui.base.h.n(this, 2131762515, 2131762516);
        i = 1;
        continue;
        com.tencent.mm.ui.base.h.n(getContext(), 2131764440, 2131755998);
        i = 1;
        continue;
        y.dz(getContext());
        i = 1;
        continue;
        this.kkY.eTd = 1L;
        this.kkY.ejA = 11L;
        this.kkY.bfK();
        com.tencent.mm.ui.base.h.c(this, getString(2131759124), "", getString(2131764461), getString(2131762548), new DialogInterface.OnClickListener()new FacebookLoginUI.8
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(127990);
            if (com.tencent.mm.protocal.d.KyR)
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
        if (com.tencent.mm.protocal.d.KyR) {
          bpc();
        }
        i = 1;
        continue;
        i = 0;
      }
    }
    if ((paramq.getType() == 252) || (paramq.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.Dk(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128008);
        return;
      }
    }
    Toast.makeText(this, getString(2131760805, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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
    
    public final void E(Bundle paramBundle)
    {
      AppMethodBeat.i(127995);
      FacebookLoginUI.a(FacebookLoginUI.this, FacebookLoginUI.d(FacebookLoginUI.this).jZX);
      FacebookLoginUI.b(FacebookLoginUI.this);
      AppMethodBeat.o(127995);
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(127997);
      Log.d("MicroMsg.FacebookLoginUI", "onError:" + paramb.getMessage());
      com.tencent.mm.ui.base.h.c(FacebookLoginUI.this, paramb.getMessage(), FacebookLoginUI.this.getString(2131759100), true);
      FacebookLoginUI.bpd();
      paramb = new StringBuilder();
      com.tencent.mm.kernel.g.aAf();
      paramb = paramb.append(com.tencent.mm.kernel.a.azt()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
      com.tencent.mm.kernel.g.aAf();
      com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("L14") + ",2");
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(582L, 8L, 1L, false);
      AppMethodBeat.o(127997);
    }
    
    public final void a(com.tencent.mm.ui.h.a.e parame)
    {
      AppMethodBeat.i(127996);
      Log.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + parame.getMessage());
      com.tencent.mm.ui.base.h.c(FacebookLoginUI.this, parame.getMessage(), FacebookLoginUI.this.getString(2131759100), true);
      FacebookLoginUI.bpd();
      parame = new StringBuilder();
      com.tencent.mm.kernel.g.aAf();
      parame = parame.append(com.tencent.mm.kernel.a.azt()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
      com.tencent.mm.kernel.g.aAf();
      com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("L14") + ",2");
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(582L, 7L, 1L, false);
      AppMethodBeat.o(127996);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(127998);
      Log.d("MicroMsg.FacebookLoginUI", "onCancel");
      FacebookLoginUI.bpd();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.aAf();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.azt()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
      com.tencent.mm.kernel.g.aAf();
      com.tencent.mm.plugin.b.a.DX(com.tencent.mm.kernel.a.FN("L14") + ",2");
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(582L, 9L, 1L, false);
      AppMethodBeat.o(127998);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI
 * JD-Core Version:    0.7.0.1
 */