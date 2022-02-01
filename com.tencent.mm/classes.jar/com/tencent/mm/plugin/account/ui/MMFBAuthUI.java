package com.tencent.mm.plugin.account.ui;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.ay.i.a;
import com.tencent.mm.broadcast.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.account.friend.model.t;
import com.tencent.mm.plugin.account.friend.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MMFBAuthUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private static final String[] qbG = { "public_profile", "email", "user_location" };
  private com.tencent.mm.ui.mmfb.sdk.f pWC;
  private IListener pZz;
  private ProgressDialog qbH;
  private DialogInterface.OnCancelListener qbI;
  private t qbJ;
  private boolean qbK;
  private boolean qbL;
  private String qbM;
  private final Map<String, Preference> qbN;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public MMFBAuthUI()
  {
    AppMethodBeat.i(305170);
    this.qbK = false;
    this.qbL = false;
    this.qbM = "";
    this.qbN = new HashMap();
    this.pZz = new MMFBAuthUI.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(305170);
  }
  
  private void bYf()
  {
    AppMethodBeat.i(305174);
    this.qbH = ProgressDialog.show(this, getString(r.j.app_tip), getString(r.j.facebook_auth_binding), true);
    this.qbH.setOnCancelListener(this.qbI);
    this.qbJ = new t(1, this.qbM);
    com.tencent.mm.kernel.h.aZW().a(this.qbJ, 0);
    hQ(true);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(582L, 1L, 1L, false);
    AppMethodBeat.o(305174);
  }
  
  private void bYg()
  {
    AppMethodBeat.i(305175);
    this.screen.removeAll();
    boolean bool;
    Preference localPreference;
    if (this.qbK)
    {
      bool = false;
      if (this.qbN.containsKey("facebook_auth_tip"))
      {
        localPreference = (Preference)this.qbN.get("facebook_auth_tip");
        if (!bool) {
          break label170;
        }
      }
    }
    label170:
    for (int i = r.j.facebook_auth_unbind_tip;; i = r.j.facebook_auth_bind_tip)
    {
      localPreference.setTitle(i);
      this.screen.c(localPreference);
      if (this.qbN.containsKey("facebook_auth_cat"))
      {
        localPreference = (Preference)this.qbN.get("facebook_auth_cat");
        this.screen.c(localPreference);
      }
      if (bool) {
        break label177;
      }
      if (!this.qbN.containsKey("facebook_auth_bind_btn")) {
        break label337;
      }
      localPreference = (Preference)this.qbN.get("facebook_auth_bind_btn");
      this.screen.c(localPreference);
      AppMethodBeat.o(305175);
      return;
      bool = z.bBz();
      break;
    }
    label177:
    if (this.qbN.containsKey("facebook_auth_account"))
    {
      localPreference = (Preference)this.qbN.get("facebook_auth_account");
      localPreference.setTitle(getString(r.j.facebook_auth_bound_account) + com.tencent.mm.kernel.h.baE().ban().d(65826, null));
      this.screen.c(localPreference);
    }
    if (this.qbN.containsKey("facebook_auth_cat2"))
    {
      localPreference = (Preference)this.qbN.get("facebook_auth_cat2");
      this.screen.c(localPreference);
    }
    if (this.qbN.containsKey("facebook_auth_unbind_btn"))
    {
      localPreference = (Preference)this.qbN.get("facebook_auth_unbind_btn");
      this.screen.c(localPreference);
    }
    label337:
    AppMethodBeat.o(305175);
  }
  
  private static void hQ(boolean paramBoolean)
  {
    AppMethodBeat.i(305178);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      localArrayList.add(new i.a(32, str));
      ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new com.tencent.mm.ay.i(localArrayList));
      AppMethodBeat.o(305178);
      return;
    }
  }
  
  public int getResourceId()
  {
    return r.k.facebook_auth;
  }
  
  public void initView()
  {
    AppMethodBeat.i(305214);
    this.qbK = getIntent().getBooleanExtra("is_force_unbind", false);
    this.qbI = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(305005);
        if (MMFBAuthUI.a(MMFBAuthUI.this) != null) {
          com.tencent.mm.kernel.h.aZW().a(MMFBAuthUI.a(MMFBAuthUI.this));
        }
        AppMethodBeat.o(305005);
      }
    };
    setMMTitle(r.j.bind_facebook_start_title);
    this.screen.aBe(r.k.facebook_auth);
    Preference localPreference = this.screen.bAi("facebook_auth_tip");
    if (localPreference != null) {
      this.qbN.put("facebook_auth_tip", localPreference);
    }
    localPreference = this.screen.bAi("facebook_auth_cat");
    if (localPreference != null) {
      this.qbN.put("facebook_auth_cat", localPreference);
    }
    localPreference = this.screen.bAi("facebook_auth_bind_btn");
    if (localPreference != null) {
      this.qbN.put("facebook_auth_bind_btn", localPreference);
    }
    localPreference = this.screen.bAi("facebook_auth_account");
    if (localPreference != null) {
      this.qbN.put("facebook_auth_account", localPreference);
    }
    localPreference = this.screen.bAi("facebook_auth_cat2");
    if (localPreference != null) {
      this.qbN.put("facebook_auth_cat2", localPreference);
    }
    localPreference = this.screen.bAi("facebook_auth_unbind_btn");
    if (localPreference != null) {
      this.qbN.put("facebook_auth_unbind_btn", localPreference);
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(304996);
        paramAnonymousMenuItem = MMFBAuthUI.this.getIntent();
        paramAnonymousMenuItem.putExtra("bind_facebook_succ", MMFBAuthUI.b(MMFBAuthUI.this));
        MMFBAuthUI.this.setResult(-1, paramAnonymousMenuItem);
        MMFBAuthUI.this.finish();
        AppMethodBeat.o(304996);
        return true;
      }
    });
    AppMethodBeat.o(305214);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(305219);
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
      bYf();
      AppMethodBeat.o(305219);
      return;
      bool = false;
      break;
      label163:
      i = str.length();
    }
    label173:
    if (this.pWC != null) {
      this.pWC.m(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(305219);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305206);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(305206);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(305220);
    super.onDestroy();
    if (this.pWC != null) {
      this.pWC.cf(this);
    }
    AppMethodBeat.o(305220);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(305227);
    if (paramInt == 4)
    {
      Intent localIntent = getIntent();
      localIntent.putExtra("bind_facebook_succ", this.qbL);
      setResult(-1, localIntent);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(305227);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(305210);
    super.onPause();
    this.pZz.dead();
    com.tencent.mm.kernel.h.aZW().b(183, this);
    com.tencent.mm.kernel.h.aZW().b(254, this);
    AppMethodBeat.o(305210);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(305216);
    paramf = paramPreference.mKey;
    if (paramf == null)
    {
      Log.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
      AppMethodBeat.o(305216);
      return true;
    }
    if (paramf.equals("facebook_auth_bind_btn")) {
      try
      {
        this.pWC.nB(this);
        this.pWC = new com.tencent.mm.ui.mmfb.sdk.f();
        this.pWC.a(this, qbG, new MMFBAuthUI.a(this, (byte)0));
        AppMethodBeat.o(305216);
        return true;
      }
      catch (Exception paramf)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FacebookAuthUI", paramf, "", new Object[0]);
        }
      }
    }
    if (paramf.equals("facebook_auth_unbind_btn"))
    {
      k.a(this, r.j.facebook_auth_unbind_alert_tip, r.j.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(304992);
          paramAnonymousDialogInterface = MMFBAuthUI.this.getString(r.j.app_tip);
          String str = MMFBAuthUI.this.getString(r.j.facebook_auth_unbinding);
          MMFBAuthUI.a(MMFBAuthUI.this, ProgressDialog.show(MMFBAuthUI.this, paramAnonymousDialogInterface, str, true));
          MMFBAuthUI.d(MMFBAuthUI.this).setOnCancelListener(MMFBAuthUI.c(MMFBAuthUI.this));
          paramAnonymousDialogInterface = new x(x.pTp);
          com.tencent.mm.kernel.h.aZW().a(paramAnonymousDialogInterface, 0);
          AppMethodBeat.o(304992);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(305216);
      return true;
    }
    AppMethodBeat.o(305216);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(305208);
    this.pZz.alive();
    super.onResume();
    com.tencent.mm.kernel.h.aZW().a(183, this);
    com.tencent.mm.kernel.h.aZW().a(254, this);
    bYg();
    AppMethodBeat.o(305208);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(305226);
    if (paramp.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.qbJ = new t(0, "");
        com.tencent.mm.kernel.h.aZW().a(this.qbJ, 0);
        AppMethodBeat.o(305226);
        return;
      }
      if (this.qbH != null) {
        this.qbH.dismiss();
      }
      if (paramInt2 == -82)
      {
        k.a(this, r.j.setting_unbind_qq_err_one_left, r.j.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(305226);
        return;
      }
      if (paramInt2 == -83)
      {
        k.a(this, r.j.setting_unbind_qq_err_has_unbind, r.j.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(305226);
        return;
      }
      if (paramInt2 == -84)
      {
        k.a(this, r.j.setting_unbind_qq_err_hasbinded, r.j.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(305226);
        return;
      }
      if (paramInt2 == -85)
      {
        k.a(this, r.j.setting_unbind_qq_err_bindedbyother, r.j.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(305226);
        return;
      }
      if (paramInt2 == -86)
      {
        k.a(this, r.j.setting_unbind_qq_err_qmail, r.j.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(305226);
        return;
      }
      if (paramInt2 == -106)
      {
        v.f(this, paramString, 0);
        AppMethodBeat.o(305226);
        return;
      }
      if (paramInt2 == -217)
      {
        v.a(this, e.d((u)paramp), paramInt2);
        AppMethodBeat.o(305226);
        return;
      }
      paramString = a.CH(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        AppMethodBeat.o(305226);
        return;
      }
      AppMethodBeat.o(305226);
      return;
    }
    if (paramp.getType() == 183)
    {
      if (this.qbH != null) {
        this.qbH.dismiss();
      }
      int i = ((t)paramp).opType;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 0) {}
        for (paramInt1 = r.j.contact_info_facebookapp_unbind_success;; paramInt1 = r.j.contact_info_facebookapp_bind_success)
        {
          Toast.makeText(this, paramInt1, 1).show();
          this.qbK = false;
          bYg();
          if (i == 1)
          {
            ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxK("facebookapp");
            ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aLO("facebookapp");
            this.qbL = true;
          }
          AppMethodBeat.o(305226);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -67))
      {
        Toast.makeText(this, r.j.facebook_auth_have_bind_facebook, 1).show();
        AppMethodBeat.o(305226);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == -5))
      {
        if (i == 1) {}
        for (paramInt1 = r.j.facebook_auth_bind_access_denied;; paramInt1 = r.j.facebook_auth_unbind_access_denied)
        {
          Toast.makeText(this, paramInt1, 1).show();
          AppMethodBeat.o(305226);
          return;
        }
      }
      if (paramInt2 == -106)
      {
        v.f(this, paramString, 0);
        AppMethodBeat.o(305226);
        return;
      }
      paramString = a.CH(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        AppMethodBeat.o(305226);
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
      AppMethodBeat.o(305226);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MMFBAuthUI
 * JD-Core Version:    0.7.0.1
 */