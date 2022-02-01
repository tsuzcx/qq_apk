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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bb.i.a;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.g.a.b;
import com.tencent.mm.ui.g.a.c.a;
import com.tencent.mm.ui.g.a.d;
import com.tencent.mm.ui.g.a.d.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacebookAuthUI
  extends MMPreference
  implements com.tencent.mm.al.f
{
  private static final String[] jje = { "public_profile", "email", "user_location" };
  private com.tencent.mm.ui.g.a.c jhy;
  private d jjD;
  private boolean jjE;
  private boolean jjF;
  private String jjG;
  private final Map<String, Preference> jjH;
  private com.tencent.mm.sdk.b.c jjI;
  private ProgressDialog jjb;
  private DialogInterface.OnCancelListener jjc;
  private w jjd;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public FacebookAuthUI()
  {
    AppMethodBeat.i(127938);
    this.jjE = false;
    this.jjF = false;
    this.jjG = "";
    this.jjH = new HashMap();
    this.jjI = new FacebookAuthUI.1(this);
    AppMethodBeat.o(127938);
  }
  
  private void aTL()
  {
    AppMethodBeat.i(127944);
    this.jjb = ProgressDialog.show(this, getString(2131755906), getString(2131758777), true);
    this.jjb.setOnCancelListener(this.jjc);
    this.jjd = new w(1, this.jjG);
    com.tencent.mm.kernel.g.aiU().a(this.jjd, 0);
    fv(true);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(582L, 1L, 1L, false);
    AppMethodBeat.o(127944);
  }
  
  private void aTM()
  {
    AppMethodBeat.i(127945);
    this.screen.removeAll();
    boolean bool;
    Preference localPreference;
    if (this.jjE)
    {
      bool = false;
      if (this.jjH.containsKey("facebook_auth_tip"))
      {
        localPreference = (Preference)this.jjH.get("facebook_auth_tip");
        if (!bool) {
          break label169;
        }
      }
    }
    label169:
    for (int i = 2131758786;; i = 2131758776)
    {
      localPreference.setTitle(i);
      this.screen.b(localPreference);
      if (this.jjH.containsKey("facebook_auth_cat"))
      {
        localPreference = (Preference)this.jjH.get("facebook_auth_cat");
        this.screen.b(localPreference);
      }
      if (bool) {
        break label175;
      }
      if (!this.jjH.containsKey("facebook_auth_bind_btn")) {
        break label330;
      }
      localPreference = (Preference)this.jjH.get("facebook_auth_bind_btn");
      this.screen.b(localPreference);
      AppMethodBeat.o(127945);
      return;
      bool = u.aAS();
      break;
    }
    label175:
    if (this.jjH.containsKey("facebook_auth_account"))
    {
      localPreference = (Preference)this.jjH.get("facebook_auth_account");
      localPreference.setTitle(getString(2131758778) + com.tencent.mm.kernel.g.ajC().ajl().get(65826, null));
      this.screen.b(localPreference);
    }
    if (this.jjH.containsKey("facebook_auth_cat2"))
    {
      localPreference = (Preference)this.jjH.get("facebook_auth_cat2");
      this.screen.b(localPreference);
    }
    if (this.jjH.containsKey("facebook_auth_unbind_btn"))
    {
      localPreference = (Preference)this.jjH.get("facebook_auth_unbind_btn");
      this.screen.b(localPreference);
    }
    label330:
    AppMethodBeat.o(127945);
  }
  
  private static void fv(boolean paramBoolean)
  {
    AppMethodBeat.i(127947);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      localArrayList.add(new i.a(32, str));
      ((l)com.tencent.mm.kernel.g.ab(l.class)).azo().c(new com.tencent.mm.bb.i(localArrayList));
      AppMethodBeat.o(127947);
      return;
    }
  }
  
  public int getResourceId()
  {
    return 2131951673;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127942);
    this.jjE = getIntent().getBooleanExtra("is_force_unbind", false);
    this.jjc = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(127928);
        if (FacebookAuthUI.a(FacebookAuthUI.this) != null) {
          com.tencent.mm.kernel.g.aiU().a(FacebookAuthUI.a(FacebookAuthUI.this));
        }
        AppMethodBeat.o(127928);
      }
    };
    setMMTitle(2131756438);
    this.screen.addPreferencesFromResource(2131951673);
    Preference localPreference = this.screen.aVD("facebook_auth_tip");
    if (localPreference != null) {
      this.jjH.put("facebook_auth_tip", localPreference);
    }
    localPreference = this.screen.aVD("facebook_auth_cat");
    if (localPreference != null) {
      this.jjH.put("facebook_auth_cat", localPreference);
    }
    localPreference = this.screen.aVD("facebook_auth_bind_btn");
    if (localPreference != null) {
      this.jjH.put("facebook_auth_bind_btn", localPreference);
    }
    localPreference = this.screen.aVD("facebook_auth_account");
    if (localPreference != null) {
      this.jjH.put("facebook_auth_account", localPreference);
    }
    localPreference = this.screen.aVD("facebook_auth_cat2");
    if (localPreference != null) {
      this.jjH.put("facebook_auth_cat2", localPreference);
    }
    localPreference = this.screen.aVD("facebook_auth_unbind_btn");
    if (localPreference != null) {
      this.jjH.put("facebook_auth_unbind_btn", localPreference);
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
      ad.i("MicroMsg.FacebookAuthUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label173;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      j = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bt.isNullOrNil(str);
      if (!bt.isNullOrNil(str)) {
        break label163;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.FacebookAuthUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if (j != -217) {
        break label173;
      }
      aTL();
      AppMethodBeat.o(127946);
      return;
      bool = false;
      break;
      label163:
      i = str.length();
    }
    label173:
    if (this.jhy != null) {
      this.jhy.i(paramInt1, paramInt2, paramIntent);
    }
    if (this.jjD != null) {
      this.jjD.i(paramInt1, paramInt2, paramIntent);
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
      localIntent.putExtra("bind_facebook_succ", this.jjF);
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
    com.tencent.mm.sdk.b.a.IbL.d(this.jjI);
    com.tencent.mm.kernel.g.aiU().b(183, this);
    com.tencent.mm.kernel.g.aiU().b(254, this);
    AppMethodBeat.o(127941);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127943);
    paramf = paramPreference.mKey;
    if (paramf == null)
    {
      ad.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
      AppMethodBeat.o(127943);
      return true;
    }
    if (paramf.equals("facebook_auth_bind_btn"))
    {
      if (r.s(this, "com.facebook.katana"))
      {
        if (this.jjD == null)
        {
          this.jjD = new d(getString(2131758773));
          this.jjD.fJE();
        }
        if (!this.jjD.fJD())
        {
          this.jjD.logout();
          this.jjD.a(this, new d.b()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(127931);
              ad.i("MicroMsg.FacebookAuthUI", "facebook-android login cancel!");
              AppMethodBeat.o(127931);
            }
            
            public final void onError(String paramAnonymousString)
            {
              AppMethodBeat.i(127932);
              ad.i("MicroMsg.FacebookAuthUI", "facebook-android login error! %s", new Object[] { paramAnonymousString });
              h.c(FacebookAuthUI.this, FacebookAuthUI.this.getString(2131758779), "", true);
              AppMethodBeat.o(127932);
            }
            
            public final void onSuccess()
            {
              AppMethodBeat.i(127930);
              ad.i("MicroMsg.FacebookAuthUI", "facebook-android login success!");
              FacebookAuthUI.a(FacebookAuthUI.this, FacebookAuthUI.c(FacebookAuthUI.this).KAc.getToken());
              FacebookAuthUI.d(FacebookAuthUI.this);
              AppMethodBeat.o(127930);
            }
          }, jje);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(127943);
        return true;
        aTL();
        continue;
        try
        {
          this.jhy.kw(this);
          this.jhy = new com.tencent.mm.ui.g.a.c(getString(2131758773));
          this.jhy.a(this, jje, new a((byte)0));
        }
        catch (Exception paramf)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.FacebookAuthUI", paramf, "", new Object[0]);
          }
        }
      }
    }
    if (paramf.equals("facebook_auth_unbind_btn"))
    {
      h.a(this, 2131758784, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(127933);
          paramAnonymousDialogInterface = FacebookAuthUI.this.getString(2131755906);
          String str = FacebookAuthUI.this.getString(2131758787);
          FacebookAuthUI.a(FacebookAuthUI.this, ProgressDialog.show(FacebookAuthUI.this, paramAnonymousDialogInterface, str, true));
          FacebookAuthUI.f(FacebookAuthUI.this).setOnCancelListener(FacebookAuthUI.e(FacebookAuthUI.this));
          paramAnonymousDialogInterface = new aa(aa.jem);
          com.tencent.mm.kernel.g.aiU().a(paramAnonymousDialogInterface, 0);
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
    com.tencent.mm.sdk.b.a.IbL.c(this.jjI);
    super.onResume();
    com.tencent.mm.kernel.g.aiU().a(183, this);
    com.tencent.mm.kernel.g.aiU().a(254, this);
    aTM();
    AppMethodBeat.o(127940);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127948);
    if (paramn.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.jjd = new w(0, "");
        com.tencent.mm.kernel.g.aiU().a(this.jjd, 0);
        AppMethodBeat.o(127948);
        return;
      }
      if (this.jjb != null) {
        this.jjb.dismiss();
      }
      if (paramInt2 == -82)
      {
        h.a(this, 2131763138, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -83)
      {
        h.a(this, 2131763135, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -84)
      {
        h.a(this, 2131763136, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -85)
      {
        h.a(this, 2131763134, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -86)
      {
        h.a(this, 2131763140, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -106)
      {
        y.g(this, paramString, 0);
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -217)
      {
        y.a(this, com.tencent.mm.platformtools.e.a((s)paramn), paramInt2);
        AppMethodBeat.o(127948);
        return;
      }
      paramString = com.tencent.mm.h.a.uz(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        AppMethodBeat.o(127948);
        return;
      }
      AppMethodBeat.o(127948);
      return;
    }
    if (paramn.getType() == 183)
    {
      if (this.jjb != null) {
        this.jjb.dismiss();
      }
      int i = ((w)paramn).opType;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 0) {}
        for (paramInt1 = 2131757663;; paramInt1 = 2131757658)
        {
          Toast.makeText(this, paramInt1, 1).show();
          this.jjE = false;
          aTM();
          if (i == 1)
          {
            ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTx("facebookapp");
            ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aqe("facebookapp");
            this.jjF = true;
          }
          AppMethodBeat.o(127948);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -67))
      {
        Toast.makeText(this, 2131758780, 1).show();
        AppMethodBeat.o(127948);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == -5))
      {
        if (i == 1) {}
        for (paramInt1 = 2131758774;; paramInt1 = 2131758783)
        {
          Toast.makeText(this, paramInt1, 1).show();
          AppMethodBeat.o(127948);
          return;
        }
      }
      if (paramInt2 == -106)
      {
        y.g(this, paramString, 0);
        AppMethodBeat.o(127948);
        return;
      }
      paramString = com.tencent.mm.h.a.uz(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        AppMethodBeat.o(127948);
        return;
      }
      if (i != 0) {
        break label585;
      }
    }
    label585:
    for (paramInt1 = 2131757662;; paramInt1 = 2131757657)
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
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(127936);
      ad.d("MicroMsg.FacebookAuthUI", "onError:" + paramb.getMessage());
      h.c(FacebookAuthUI.this, paramb.getMessage(), FacebookAuthUI.this.getString(2131757657), true);
      FacebookAuthUI.aTN();
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(582L, 3L, 1L, false);
      AppMethodBeat.o(127936);
    }
    
    public final void a(com.tencent.mm.ui.g.a.e parame)
    {
      AppMethodBeat.i(127935);
      ad.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + parame.KAi);
      h.c(FacebookAuthUI.this, parame.getMessage(), FacebookAuthUI.this.getString(2131757657), true);
      FacebookAuthUI.aTN();
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(582L, 2L, 1L, false);
      AppMethodBeat.o(127935);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(127937);
      ad.d("MicroMsg.FacebookAuthUI", "onCancel");
      FacebookAuthUI.aTN();
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(582L, 4L, 1L, false);
      AppMethodBeat.o(127937);
    }
    
    public final void x(Bundle paramBundle)
    {
      AppMethodBeat.i(127934);
      FacebookAuthUI.a(FacebookAuthUI.this, FacebookAuthUI.g(FacebookAuthUI.this).iZb);
      com.tencent.mm.kernel.g.ajC().ajl().set(65830, FacebookAuthUI.h(FacebookAuthUI.this));
      if (FacebookAuthUI.g(FacebookAuthUI.this).KzV != 0L) {
        com.tencent.mm.kernel.g.ajC().ajl().set(65832, Long.valueOf(FacebookAuthUI.g(FacebookAuthUI.this).KzV));
      }
      FacebookAuthUI.d(FacebookAuthUI.this);
      AppMethodBeat.o(127934);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI
 * JD-Core Version:    0.7.0.1
 */