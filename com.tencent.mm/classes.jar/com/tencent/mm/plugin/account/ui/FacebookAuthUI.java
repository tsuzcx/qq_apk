package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
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
import com.tencent.mm.an.q;
import com.tencent.mm.bd.i.a;
import com.tencent.mm.h.a;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.i.a.b;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.ui.i.a.c.a;
import com.tencent.mm.ui.i.a.d;
import com.tencent.mm.ui.i.a.d.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacebookAuthUI
  extends MMPreference
  implements com.tencent.mm.an.i
{
  private static final String[] nbW = { "public_profile", "email", "user_location" };
  private c mZT;
  private ProgressDialog nbT;
  private DialogInterface.OnCancelListener nbU;
  private w nbV;
  private IListener ncA;
  private d ncv;
  private boolean ncw;
  private boolean ncx;
  private String ncy;
  private final Map<String, Preference> ncz;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public FacebookAuthUI()
  {
    AppMethodBeat.i(127938);
    this.ncw = false;
    this.ncx = false;
    this.ncy = "";
    this.ncz = new HashMap();
    this.ncA = new FacebookAuthUI.1(this);
    AppMethodBeat.o(127938);
  }
  
  private void bzj()
  {
    AppMethodBeat.i(127944);
    this.nbT = ProgressDialog.show(this, getString(r.j.app_tip), getString(r.j.facebook_auth_binding), true);
    this.nbT.setOnCancelListener(this.nbU);
    this.nbV = new w(1, this.ncy);
    com.tencent.mm.kernel.h.aGY().a(this.nbV, 0);
    hb(true);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(582L, 1L, 1L, false);
    AppMethodBeat.o(127944);
  }
  
  private void bzk()
  {
    AppMethodBeat.i(127945);
    this.screen.removeAll();
    boolean bool;
    Preference localPreference;
    if (this.ncw)
    {
      bool = false;
      if (this.ncz.containsKey("facebook_auth_tip"))
      {
        localPreference = (Preference)this.ncz.get("facebook_auth_tip");
        if (!bool) {
          break label170;
        }
      }
    }
    label170:
    for (int i = r.j.facebook_auth_unbind_tip;; i = r.j.facebook_auth_bind_tip)
    {
      localPreference.setTitle(i);
      this.screen.b(localPreference);
      if (this.ncz.containsKey("facebook_auth_cat"))
      {
        localPreference = (Preference)this.ncz.get("facebook_auth_cat");
        this.screen.b(localPreference);
      }
      if (bool) {
        break label177;
      }
      if (!this.ncz.containsKey("facebook_auth_bind_btn")) {
        break label333;
      }
      localPreference = (Preference)this.ncz.get("facebook_auth_bind_btn");
      this.screen.b(localPreference);
      AppMethodBeat.o(127945);
      return;
      bool = z.bdH();
      break;
    }
    label177:
    if (this.ncz.containsKey("facebook_auth_account"))
    {
      localPreference = (Preference)this.ncz.get("facebook_auth_account");
      localPreference.setTitle(getString(r.j.facebook_auth_bound_account) + com.tencent.mm.kernel.h.aHG().aHp().b(65826, null));
      this.screen.b(localPreference);
    }
    if (this.ncz.containsKey("facebook_auth_cat2"))
    {
      localPreference = (Preference)this.ncz.get("facebook_auth_cat2");
      this.screen.b(localPreference);
    }
    if (this.ncz.containsKey("facebook_auth_unbind_btn"))
    {
      localPreference = (Preference)this.ncz.get("facebook_auth_unbind_btn");
      this.screen.b(localPreference);
    }
    label333:
    AppMethodBeat.o(127945);
  }
  
  private static void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(127947);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      localArrayList.add(new i.a(32, str));
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new com.tencent.mm.bd.i(localArrayList));
      AppMethodBeat.o(127947);
      return;
    }
  }
  
  public int getResourceId()
  {
    return r.k.facebook_auth;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127942);
    this.ncw = getIntent().getBooleanExtra("is_force_unbind", false);
    this.nbU = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(127928);
        if (FacebookAuthUI.a(FacebookAuthUI.this) != null) {
          com.tencent.mm.kernel.h.aGY().a(FacebookAuthUI.a(FacebookAuthUI.this));
        }
        AppMethodBeat.o(127928);
      }
    };
    setMMTitle(r.j.bind_facebook_start_title);
    this.screen.auC(r.k.facebook_auth);
    Preference localPreference = this.screen.byG("facebook_auth_tip");
    if (localPreference != null) {
      this.ncz.put("facebook_auth_tip", localPreference);
    }
    localPreference = this.screen.byG("facebook_auth_cat");
    if (localPreference != null) {
      this.ncz.put("facebook_auth_cat", localPreference);
    }
    localPreference = this.screen.byG("facebook_auth_bind_btn");
    if (localPreference != null) {
      this.ncz.put("facebook_auth_bind_btn", localPreference);
    }
    localPreference = this.screen.byG("facebook_auth_account");
    if (localPreference != null) {
      this.ncz.put("facebook_auth_account", localPreference);
    }
    localPreference = this.screen.byG("facebook_auth_cat2");
    if (localPreference != null) {
      this.ncz.put("facebook_auth_cat2", localPreference);
    }
    localPreference = this.screen.byG("facebook_auth_unbind_btn");
    if (localPreference != null) {
      this.ncz.put("facebook_auth_unbind_btn", localPreference);
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(127929);
        paramAnonymousMenuItem = FacebookAuthUI.this.getIntent();
        paramAnonymousMenuItem.putExtra("bind_facebook_succ", FacebookAuthUI.b(FacebookAuthUI.this));
        FacebookAuthUI.this.setResult(-1, paramAnonymousMenuItem);
        FacebookAuthUI.this.finish();
        AppMethodBeat.o(127929);
        return true;
      }
    });
    AppMethodBeat.o(127942);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(127946);
    boolean bool;
    String str;
    int j;
    if (paramIntent == null)
    {
      bool = true;
      Log.i("MicroMsg.FacebookAuthUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label173;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      j = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = Util.isNullOrNil(str);
      if (!Util.isNullOrNil(str)) {
        break label163;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.FacebookAuthUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if (j != -217) {
        break label173;
      }
      bzj();
      AppMethodBeat.o(127946);
      return;
      bool = false;
      break;
      label163:
      i = str.length();
    }
    label173:
    if (this.mZT != null) {
      this.mZT.j(paramInt1, paramInt2, paramIntent);
    }
    if (this.ncv != null) {
      this.ncv.j(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(127946);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127939);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(127939);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(127949);
    if (paramInt == 4)
    {
      Intent localIntent = getIntent();
      localIntent.putExtra("bind_facebook_succ", this.ncx);
      setResult(-1, localIntent);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(127949);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127941);
    super.onPause();
    EventCenter.instance.removeListener(this.ncA);
    com.tencent.mm.kernel.h.aGY().b(183, this);
    com.tencent.mm.kernel.h.aGY().b(254, this);
    AppMethodBeat.o(127941);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127943);
    paramf = paramPreference.mKey;
    if (paramf == null)
    {
      Log.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
      AppMethodBeat.o(127943);
      return true;
    }
    if (paramf.equals("facebook_auth_bind_btn"))
    {
      if (r.u(this, "com.facebook.katana"))
      {
        if (this.ncv == null)
        {
          this.ncv = new d(getString(r.j.facebook_app_id));
          this.ncv.hWT();
        }
        if (!this.ncv.hWS())
        {
          this.ncv.dbv();
          this.ncv.a(this, new d.b()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(127931);
              Log.i("MicroMsg.FacebookAuthUI", "facebook-android login cancel!");
              AppMethodBeat.o(127931);
            }
            
            public final void onError(String paramAnonymousString)
            {
              AppMethodBeat.i(127932);
              Log.i("MicroMsg.FacebookAuthUI", "facebook-android login error! %s", new Object[] { paramAnonymousString });
              com.tencent.mm.ui.base.h.c(FacebookAuthUI.this, FacebookAuthUI.this.getString(r.j.facebook_auth_failed), "", true);
              AppMethodBeat.o(127932);
            }
            
            public final void onSuccess()
            {
              AppMethodBeat.i(127930);
              Log.i("MicroMsg.FacebookAuthUI", "facebook-android login success!");
              FacebookAuthUI.a(FacebookAuthUI.this, FacebookAuthUI.c(FacebookAuthUI.this).XGX.getToken());
              FacebookAuthUI.d(FacebookAuthUI.this);
              AppMethodBeat.o(127930);
            }
          }, nbW);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(127943);
        return true;
        bzj();
        continue;
        try
        {
          this.mZT.lv(this);
          this.mZT = new c(getString(r.j.facebook_app_id));
          this.mZT.a(this, nbW, new a((byte)0));
        }
        catch (Exception paramf)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.FacebookAuthUI", paramf, "", new Object[0]);
          }
        }
      }
    }
    if (paramf.equals("facebook_auth_unbind_btn"))
    {
      com.tencent.mm.ui.base.h.a(this, r.j.facebook_auth_unbind_alert_tip, r.j.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(127933);
          paramAnonymousDialogInterface = FacebookAuthUI.this.getString(r.j.app_tip);
          String str = FacebookAuthUI.this.getString(r.j.facebook_auth_unbinding);
          FacebookAuthUI.a(FacebookAuthUI.this, ProgressDialog.show(FacebookAuthUI.this, paramAnonymousDialogInterface, str, true));
          FacebookAuthUI.f(FacebookAuthUI.this).setOnCancelListener(FacebookAuthUI.e(FacebookAuthUI.this));
          paramAnonymousDialogInterface = new aa(aa.mWI);
          com.tencent.mm.kernel.h.aGY().a(paramAnonymousDialogInterface, 0);
          AppMethodBeat.o(127933);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(127943);
      return true;
    }
    AppMethodBeat.o(127943);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127940);
    EventCenter.instance.addListener(this.ncA);
    super.onResume();
    com.tencent.mm.kernel.h.aGY().a(183, this);
    com.tencent.mm.kernel.h.aGY().a(254, this);
    bzk();
    AppMethodBeat.o(127940);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127948);
    if (paramq.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.nbV = new w(0, "");
        com.tencent.mm.kernel.h.aGY().a(this.nbV, 0);
        AppMethodBeat.o(127948);
        return;
      }
      if (this.nbT != null) {
        this.nbT.dismiss();
      }
      if (paramInt2 == -82)
      {
        com.tencent.mm.ui.base.h.a(this, r.j.setting_unbind_qq_err_one_left, r.j.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -83)
      {
        com.tencent.mm.ui.base.h.a(this, r.j.setting_unbind_qq_err_has_unbind, r.j.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -84)
      {
        com.tencent.mm.ui.base.h.a(this, r.j.setting_unbind_qq_err_hasbinded, r.j.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -85)
      {
        com.tencent.mm.ui.base.h.a(this, r.j.setting_unbind_qq_err_bindedbyother, r.j.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -86)
      {
        com.tencent.mm.ui.base.h.a(this, r.j.setting_unbind_qq_err_qmail, r.j.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -106)
      {
        y.f(this, paramString, 0);
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, com.tencent.mm.platformtools.e.d((com.tencent.mm.modelsimple.t)paramq), paramInt2);
        AppMethodBeat.o(127948);
        return;
      }
      paramString = a.Kb(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        AppMethodBeat.o(127948);
        return;
      }
      AppMethodBeat.o(127948);
      return;
    }
    if (paramq.getType() == 183)
    {
      if (this.nbT != null) {
        this.nbT.dismiss();
      }
      int i = ((w)paramq).opType;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 0) {}
        for (paramInt1 = r.j.contact_info_facebookapp_unbind_success;; paramInt1 = r.j.contact_info_facebookapp_bind_success)
        {
          Toast.makeText(this, paramInt1, 1).show();
          this.ncw = false;
          bzk();
          if (i == 1)
          {
            ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwv("facebookapp");
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOO("facebookapp");
            this.ncx = true;
          }
          AppMethodBeat.o(127948);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -67))
      {
        Toast.makeText(this, r.j.facebook_auth_have_bind_facebook, 1).show();
        AppMethodBeat.o(127948);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == -5))
      {
        if (i == 1) {}
        for (paramInt1 = r.j.facebook_auth_bind_access_denied;; paramInt1 = r.j.facebook_auth_unbind_access_denied)
        {
          Toast.makeText(this, paramInt1, 1).show();
          AppMethodBeat.o(127948);
          return;
        }
      }
      if (paramInt2 == -106)
      {
        y.f(this, paramString, 0);
        AppMethodBeat.o(127948);
        return;
      }
      paramString = a.Kb(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        AppMethodBeat.o(127948);
        return;
      }
      if (i != 0) {
        break label590;
      }
    }
    label590:
    for (paramInt1 = r.j.contact_info_facebookapp_unbind_fail;; paramInt1 = r.j.contact_info_facebookapp_bind_fail)
    {
      Toast.makeText(this, paramInt1, 1).show();
      AppMethodBeat.o(127948);
      return;
    }
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
      AppMethodBeat.i(127934);
      FacebookAuthUI.a(FacebookAuthUI.this, FacebookAuthUI.g(FacebookAuthUI.this).mRq);
      com.tencent.mm.kernel.h.aHG().aHp().i(65830, FacebookAuthUI.h(FacebookAuthUI.this));
      if (FacebookAuthUI.g(FacebookAuthUI.this).XGQ != 0L) {
        com.tencent.mm.kernel.h.aHG().aHp().i(65832, Long.valueOf(FacebookAuthUI.g(FacebookAuthUI.this).XGQ));
      }
      FacebookAuthUI.d(FacebookAuthUI.this);
      AppMethodBeat.o(127934);
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(127936);
      Log.d("MicroMsg.FacebookAuthUI", "onError:" + paramb.getMessage());
      com.tencent.mm.ui.base.h.c(FacebookAuthUI.this, paramb.getMessage(), FacebookAuthUI.this.getString(r.j.contact_info_facebookapp_bind_fail), true);
      FacebookAuthUI.bzl();
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(582L, 3L, 1L, false);
      AppMethodBeat.o(127936);
    }
    
    public final void a(com.tencent.mm.ui.i.a.e parame)
    {
      AppMethodBeat.i(127935);
      Log.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + parame.XHd);
      com.tencent.mm.ui.base.h.c(FacebookAuthUI.this, parame.getMessage(), FacebookAuthUI.this.getString(r.j.contact_info_facebookapp_bind_fail), true);
      FacebookAuthUI.bzl();
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(582L, 2L, 1L, false);
      AppMethodBeat.o(127935);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(127937);
      Log.d("MicroMsg.FacebookAuthUI", "onCancel");
      FacebookAuthUI.bzl();
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(582L, 4L, 1L, false);
      AppMethodBeat.o(127937);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI
 * JD-Core Version:    0.7.0.1
 */