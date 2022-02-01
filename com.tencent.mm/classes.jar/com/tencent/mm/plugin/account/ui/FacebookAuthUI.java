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
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.i.a;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.h.a.b;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.h.a.c.a;
import com.tencent.mm.ui.h.a.d;
import com.tencent.mm.ui.h.a.d.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacebookAuthUI
  extends MMPreference
  implements com.tencent.mm.ak.i
{
  private static final String[] kkg = { "public_profile", "email", "user_location" };
  private c kiu;
  private d kkF;
  private boolean kkG;
  private boolean kkH;
  private String kkI;
  private final Map<String, Preference> kkJ;
  private IListener kkK;
  private ProgressDialog kkd;
  private DialogInterface.OnCancelListener kke;
  private w kkf;
  private f screen;
  
  public FacebookAuthUI()
  {
    AppMethodBeat.i(127938);
    this.kkG = false;
    this.kkH = false;
    this.kkI = "";
    this.kkJ = new HashMap();
    this.kkK = new FacebookAuthUI.1(this);
    AppMethodBeat.o(127938);
  }
  
  private void boX()
  {
    AppMethodBeat.i(127944);
    this.kkd = ProgressDialog.show(this, getString(2131755998), getString(2131759098), true);
    this.kkd.setOnCancelListener(this.kke);
    this.kkf = new w(1, this.kkI);
    g.azz().a(this.kkf, 0);
    gp(true);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(582L, 1L, 1L, false);
    AppMethodBeat.o(127944);
  }
  
  private void boY()
  {
    AppMethodBeat.i(127945);
    this.screen.removeAll();
    boolean bool;
    Preference localPreference;
    if (this.kkG)
    {
      bool = false;
      if (this.kkJ.containsKey("facebook_auth_tip"))
      {
        localPreference = (Preference)this.kkJ.get("facebook_auth_tip");
        if (!bool) {
          break label169;
        }
      }
    }
    label169:
    for (int i = 2131759107;; i = 2131759097)
    {
      localPreference.setTitle(i);
      this.screen.c(localPreference);
      if (this.kkJ.containsKey("facebook_auth_cat"))
      {
        localPreference = (Preference)this.kkJ.get("facebook_auth_cat");
        this.screen.c(localPreference);
      }
      if (bool) {
        break label175;
      }
      if (!this.kkJ.containsKey("facebook_auth_bind_btn")) {
        break label330;
      }
      localPreference = (Preference)this.kkJ.get("facebook_auth_bind_btn");
      this.screen.c(localPreference);
      AppMethodBeat.o(127945);
      return;
      bool = z.aUF();
      break;
    }
    label175:
    if (this.kkJ.containsKey("facebook_auth_account"))
    {
      localPreference = (Preference)this.kkJ.get("facebook_auth_account");
      localPreference.setTitle(getString(2131759099) + g.aAh().azQ().get(65826, null));
      this.screen.c(localPreference);
    }
    if (this.kkJ.containsKey("facebook_auth_cat2"))
    {
      localPreference = (Preference)this.kkJ.get("facebook_auth_cat2");
      this.screen.c(localPreference);
    }
    if (this.kkJ.containsKey("facebook_auth_unbind_btn"))
    {
      localPreference = (Preference)this.kkJ.get("facebook_auth_unbind_btn");
      this.screen.c(localPreference);
    }
    label330:
    AppMethodBeat.o(127945);
  }
  
  private static void gp(boolean paramBoolean)
  {
    AppMethodBeat.i(127947);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      localArrayList.add(new i.a(32, str));
      ((l)g.af(l.class)).aSM().d(new com.tencent.mm.ba.i(localArrayList));
      AppMethodBeat.o(127947);
      return;
    }
  }
  
  public int getResourceId()
  {
    return 2132017211;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127942);
    this.kkG = getIntent().getBooleanExtra("is_force_unbind", false);
    this.kke = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(127928);
        if (FacebookAuthUI.a(FacebookAuthUI.this) != null) {
          g.azz().a(FacebookAuthUI.a(FacebookAuthUI.this));
        }
        AppMethodBeat.o(127928);
      }
    };
    setMMTitle(2131756574);
    this.screen.addPreferencesFromResource(2132017211);
    Preference localPreference = this.screen.bmg("facebook_auth_tip");
    if (localPreference != null) {
      this.kkJ.put("facebook_auth_tip", localPreference);
    }
    localPreference = this.screen.bmg("facebook_auth_cat");
    if (localPreference != null) {
      this.kkJ.put("facebook_auth_cat", localPreference);
    }
    localPreference = this.screen.bmg("facebook_auth_bind_btn");
    if (localPreference != null) {
      this.kkJ.put("facebook_auth_bind_btn", localPreference);
    }
    localPreference = this.screen.bmg("facebook_auth_account");
    if (localPreference != null) {
      this.kkJ.put("facebook_auth_account", localPreference);
    }
    localPreference = this.screen.bmg("facebook_auth_cat2");
    if (localPreference != null) {
      this.kkJ.put("facebook_auth_cat2", localPreference);
    }
    localPreference = this.screen.bmg("facebook_auth_unbind_btn");
    if (localPreference != null) {
      this.kkJ.put("facebook_auth_unbind_btn", localPreference);
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
      boX();
      AppMethodBeat.o(127946);
      return;
      bool = false;
      break;
      label163:
      i = str.length();
    }
    label173:
    if (this.kiu != null) {
      this.kiu.j(paramInt1, paramInt2, paramIntent);
    }
    if (this.kkF != null) {
      this.kkF.j(paramInt1, paramInt2, paramIntent);
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
      localIntent.putExtra("bind_facebook_succ", this.kkH);
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
    EventCenter.instance.removeListener(this.kkK);
    g.azz().b(183, this);
    g.azz().b(254, this);
    AppMethodBeat.o(127941);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
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
      if (r.s(this, "com.facebook.katana"))
      {
        if (this.kkF == null)
        {
          this.kkF = new d(getString(2131759094));
          this.kkF.gWp();
        }
        if (!this.kkF.gWo())
        {
          this.kkF.logout();
          this.kkF.a(this, new d.b()
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
              com.tencent.mm.ui.base.h.c(FacebookAuthUI.this, FacebookAuthUI.this.getString(2131759100), "", true);
              AppMethodBeat.o(127932);
            }
            
            public final void onSuccess()
            {
              AppMethodBeat.i(127930);
              Log.i("MicroMsg.FacebookAuthUI", "facebook-android login success!");
              FacebookAuthUI.a(FacebookAuthUI.this, FacebookAuthUI.c(FacebookAuthUI.this).QjM.getToken());
              FacebookAuthUI.d(FacebookAuthUI.this);
              AppMethodBeat.o(127930);
            }
          }, kkg);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(127943);
        return true;
        boX();
        continue;
        try
        {
          this.kiu.kx(this);
          this.kiu = new c(getString(2131759094));
          this.kiu.a(this, kkg, new a((byte)0));
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
      com.tencent.mm.ui.base.h.a(this, 2131759105, 2131755998, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(127933);
          paramAnonymousDialogInterface = FacebookAuthUI.this.getString(2131755998);
          String str = FacebookAuthUI.this.getString(2131759108);
          FacebookAuthUI.a(FacebookAuthUI.this, ProgressDialog.show(FacebookAuthUI.this, paramAnonymousDialogInterface, str, true));
          FacebookAuthUI.f(FacebookAuthUI.this).setOnCancelListener(FacebookAuthUI.e(FacebookAuthUI.this));
          paramAnonymousDialogInterface = new aa(aa.kfj);
          g.azz().a(paramAnonymousDialogInterface, 0);
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
    EventCenter.instance.addListener(this.kkK);
    super.onResume();
    g.azz().a(183, this);
    g.azz().a(254, this);
    boY();
    AppMethodBeat.o(127940);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127948);
    if (paramq.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.kkf = new w(0, "");
        g.azz().a(this.kkf, 0);
        AppMethodBeat.o(127948);
        return;
      }
      if (this.kkd != null) {
        this.kkd.dismiss();
      }
      if (paramInt2 == -82)
      {
        com.tencent.mm.ui.base.h.a(this, 2131765304, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -83)
      {
        com.tencent.mm.ui.base.h.a(this, 2131765301, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -84)
      {
        com.tencent.mm.ui.base.h.a(this, 2131765302, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -85)
      {
        com.tencent.mm.ui.base.h.a(this, 2131765300, 2131755998, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -86)
      {
        com.tencent.mm.ui.base.h.a(this, 2131765306, 2131755998, new DialogInterface.OnClickListener()
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
        y.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.t)paramq), paramInt2);
        AppMethodBeat.o(127948);
        return;
      }
      paramString = a.Dk(paramString);
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
      if (this.kkd != null) {
        this.kkd.dismiss();
      }
      int i = ((w)paramq).opType;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 0) {}
        for (paramInt1 = 2131757891;; paramInt1 = 2131757886)
        {
          Toast.makeText(this, paramInt1, 1).show();
          this.kkG = false;
          boY();
          if (i == 1)
          {
            ((l)g.af(l.class)).aST().bjW("facebookapp");
            ((l)g.af(l.class)).eiy().aEE("facebookapp");
            this.kkH = true;
          }
          AppMethodBeat.o(127948);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -67))
      {
        Toast.makeText(this, 2131759101, 1).show();
        AppMethodBeat.o(127948);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == -5))
      {
        if (i == 1) {}
        for (paramInt1 = 2131759095;; paramInt1 = 2131759104)
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
      paramString = a.Dk(paramString);
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
    for (paramInt1 = 2131757890;; paramInt1 = 2131757885)
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
    
    public final void E(Bundle paramBundle)
    {
      AppMethodBeat.i(127934);
      FacebookAuthUI.a(FacebookAuthUI.this, FacebookAuthUI.g(FacebookAuthUI.this).jZX);
      g.aAh().azQ().set(65830, FacebookAuthUI.h(FacebookAuthUI.this));
      if (FacebookAuthUI.g(FacebookAuthUI.this).QjF != 0L) {
        g.aAh().azQ().set(65832, Long.valueOf(FacebookAuthUI.g(FacebookAuthUI.this).QjF));
      }
      FacebookAuthUI.d(FacebookAuthUI.this);
      AppMethodBeat.o(127934);
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(127936);
      Log.d("MicroMsg.FacebookAuthUI", "onError:" + paramb.getMessage());
      com.tencent.mm.ui.base.h.c(FacebookAuthUI.this, paramb.getMessage(), FacebookAuthUI.this.getString(2131757885), true);
      FacebookAuthUI.boZ();
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(582L, 3L, 1L, false);
      AppMethodBeat.o(127936);
    }
    
    public final void a(com.tencent.mm.ui.h.a.e parame)
    {
      AppMethodBeat.i(127935);
      Log.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + parame.QjS);
      com.tencent.mm.ui.base.h.c(FacebookAuthUI.this, parame.getMessage(), FacebookAuthUI.this.getString(2131757885), true);
      FacebookAuthUI.boZ();
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(582L, 2L, 1L, false);
      AppMethodBeat.o(127935);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(127937);
      Log.d("MicroMsg.FacebookAuthUI", "onCancel");
      FacebookAuthUI.boZ();
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(582L, 4L, 1L, false);
      AppMethodBeat.o(127937);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI
 * JD-Core Version:    0.7.0.1
 */