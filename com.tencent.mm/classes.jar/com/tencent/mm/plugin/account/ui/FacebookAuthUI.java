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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.i.a;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.friend.a.aa;
import com.tencent.mm.plugin.account.friend.a.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
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
  implements com.tencent.mm.ak.g
{
  private static final String[] iPW = { "public_profile", "email", "user_location" };
  private com.tencent.mm.ui.g.a.c iOp;
  private ProgressDialog iPT;
  private DialogInterface.OnCancelListener iPU;
  private w iPV;
  private com.tencent.mm.sdk.b.c iQA;
  private d iQv;
  private boolean iQw;
  private boolean iQx;
  private String iQy;
  private final Map<String, Preference> iQz;
  private f screen;
  
  public FacebookAuthUI()
  {
    AppMethodBeat.i(127938);
    this.iQw = false;
    this.iQx = false;
    this.iQy = "";
    this.iQz = new HashMap();
    this.iQA = new FacebookAuthUI.1(this);
    AppMethodBeat.o(127938);
  }
  
  private void aQA()
  {
    AppMethodBeat.i(127945);
    this.screen.removeAll();
    boolean bool;
    Preference localPreference;
    if (this.iQw)
    {
      bool = false;
      if (this.iQz.containsKey("facebook_auth_tip"))
      {
        localPreference = (Preference)this.iQz.get("facebook_auth_tip");
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
      if (this.iQz.containsKey("facebook_auth_cat"))
      {
        localPreference = (Preference)this.iQz.get("facebook_auth_cat");
        this.screen.b(localPreference);
      }
      if (bool) {
        break label175;
      }
      if (!this.iQz.containsKey("facebook_auth_bind_btn")) {
        break label330;
      }
      localPreference = (Preference)this.iQz.get("facebook_auth_bind_btn");
      this.screen.b(localPreference);
      AppMethodBeat.o(127945);
      return;
      bool = u.axZ();
      break;
    }
    label175:
    if (this.iQz.containsKey("facebook_auth_account"))
    {
      localPreference = (Preference)this.iQz.get("facebook_auth_account");
      localPreference.setTitle(getString(2131758778) + com.tencent.mm.kernel.g.agR().agA().get(65826, null));
      this.screen.b(localPreference);
    }
    if (this.iQz.containsKey("facebook_auth_cat2"))
    {
      localPreference = (Preference)this.iQz.get("facebook_auth_cat2");
      this.screen.b(localPreference);
    }
    if (this.iQz.containsKey("facebook_auth_unbind_btn"))
    {
      localPreference = (Preference)this.iQz.get("facebook_auth_unbind_btn");
      this.screen.b(localPreference);
    }
    label330:
    AppMethodBeat.o(127945);
  }
  
  private void aQz()
  {
    AppMethodBeat.i(127944);
    this.iPT = ProgressDialog.show(this, getString(2131755906), getString(2131758777), true);
    this.iPT.setOnCancelListener(this.iPU);
    this.iPV = new w(1, this.iQy);
    com.tencent.mm.kernel.g.agi().a(this.iPV, 0);
    fr(true);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(582L, 1L, 1L, false);
    AppMethodBeat.o(127944);
  }
  
  private static void fr(boolean paramBoolean)
  {
    AppMethodBeat.i(127947);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      localArrayList.add(new i.a(32, str));
      ((k)com.tencent.mm.kernel.g.ab(k.class)).awA().c(new com.tencent.mm.ba.i(localArrayList));
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
    this.iQw = getIntent().getBooleanExtra("is_force_unbind", false);
    this.iPU = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(127928);
        if (FacebookAuthUI.a(FacebookAuthUI.this) != null) {
          com.tencent.mm.kernel.g.agi().a(FacebookAuthUI.a(FacebookAuthUI.this));
        }
        AppMethodBeat.o(127928);
      }
    };
    setMMTitle(2131756438);
    this.screen.addPreferencesFromResource(2131951673);
    Preference localPreference = this.screen.aPN("facebook_auth_tip");
    if (localPreference != null) {
      this.iQz.put("facebook_auth_tip", localPreference);
    }
    localPreference = this.screen.aPN("facebook_auth_cat");
    if (localPreference != null) {
      this.iQz.put("facebook_auth_cat", localPreference);
    }
    localPreference = this.screen.aPN("facebook_auth_bind_btn");
    if (localPreference != null) {
      this.iQz.put("facebook_auth_bind_btn", localPreference);
    }
    localPreference = this.screen.aPN("facebook_auth_account");
    if (localPreference != null) {
      this.iQz.put("facebook_auth_account", localPreference);
    }
    localPreference = this.screen.aPN("facebook_auth_cat2");
    if (localPreference != null) {
      this.iQz.put("facebook_auth_cat2", localPreference);
    }
    localPreference = this.screen.aPN("facebook_auth_unbind_btn");
    if (localPreference != null) {
      this.iQz.put("facebook_auth_unbind_btn", localPreference);
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
      ac.i("MicroMsg.FacebookAuthUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label173;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      j = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bs.isNullOrNil(str);
      if (!bs.isNullOrNil(str)) {
        break label163;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.FacebookAuthUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if (j != -217) {
        break label173;
      }
      aQz();
      AppMethodBeat.o(127946);
      return;
      bool = false;
      break;
      label163:
      i = str.length();
    }
    label173:
    if (this.iOp != null) {
      this.iOp.i(paramInt1, paramInt2, paramIntent);
    }
    if (this.iQv != null) {
      this.iQv.i(paramInt1, paramInt2, paramIntent);
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
      localIntent.putExtra("bind_facebook_succ", this.iQx);
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
    com.tencent.mm.sdk.b.a.GpY.d(this.iQA);
    com.tencent.mm.kernel.g.agi().b(183, this);
    com.tencent.mm.kernel.g.agi().b(254, this);
    AppMethodBeat.o(127941);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127943);
    paramf = paramPreference.mKey;
    if (paramf == null)
    {
      ac.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
      AppMethodBeat.o(127943);
      return true;
    }
    if (paramf.equals("facebook_auth_bind_btn"))
    {
      if (r.t(this, "com.facebook.katana"))
      {
        if (this.iQv == null)
        {
          this.iQv = new d(getString(2131758773));
          this.iQv.fsQ();
        }
        if (!this.iQv.fsP())
        {
          this.iQv.logout();
          this.iQv.a(this, new d.b()
          {
            public final void onCancel()
            {
              AppMethodBeat.i(127931);
              ac.i("MicroMsg.FacebookAuthUI", "facebook-android login cancel!");
              AppMethodBeat.o(127931);
            }
            
            public final void onError(String paramAnonymousString)
            {
              AppMethodBeat.i(127932);
              ac.i("MicroMsg.FacebookAuthUI", "facebook-android login error! %s", new Object[] { paramAnonymousString });
              com.tencent.mm.ui.base.h.c(FacebookAuthUI.this, FacebookAuthUI.this.getString(2131758779), "", true);
              AppMethodBeat.o(127932);
            }
            
            public final void onSuccess()
            {
              AppMethodBeat.i(127930);
              ac.i("MicroMsg.FacebookAuthUI", "facebook-android login success!");
              FacebookAuthUI.a(FacebookAuthUI.this, FacebookAuthUI.c(FacebookAuthUI.this).IIV.getToken());
              FacebookAuthUI.d(FacebookAuthUI.this);
              AppMethodBeat.o(127930);
            }
          }, iPW);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(127943);
        return true;
        aQz();
        continue;
        try
        {
          this.iOp.kk(this);
          this.iOp = new com.tencent.mm.ui.g.a.c(getString(2131758773));
          this.iOp.a(this, iPW, new a((byte)0));
        }
        catch (Exception paramf)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.FacebookAuthUI", paramf, "", new Object[0]);
          }
        }
      }
    }
    if (paramf.equals("facebook_auth_unbind_btn"))
    {
      com.tencent.mm.ui.base.h.a(this, 2131758784, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(127933);
          paramAnonymousDialogInterface = FacebookAuthUI.this.getString(2131755906);
          String str = FacebookAuthUI.this.getString(2131758787);
          FacebookAuthUI.a(FacebookAuthUI.this, ProgressDialog.show(FacebookAuthUI.this, paramAnonymousDialogInterface, str, true));
          FacebookAuthUI.f(FacebookAuthUI.this).setOnCancelListener(FacebookAuthUI.e(FacebookAuthUI.this));
          paramAnonymousDialogInterface = new aa(aa.iLd);
          com.tencent.mm.kernel.g.agi().a(paramAnonymousDialogInterface, 0);
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
    com.tencent.mm.sdk.b.a.GpY.c(this.iQA);
    super.onResume();
    com.tencent.mm.kernel.g.agi().a(183, this);
    com.tencent.mm.kernel.g.agi().a(254, this);
    aQA();
    AppMethodBeat.o(127940);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127948);
    if (paramn.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.iPV = new w(0, "");
        com.tencent.mm.kernel.g.agi().a(this.iPV, 0);
        AppMethodBeat.o(127948);
        return;
      }
      if (this.iPT != null) {
        this.iPT.dismiss();
      }
      if (paramInt2 == -82)
      {
        com.tencent.mm.ui.base.h.a(this, 2131763138, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -83)
      {
        com.tencent.mm.ui.base.h.a(this, 2131763135, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -84)
      {
        com.tencent.mm.ui.base.h.a(this, 2131763136, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -85)
      {
        com.tencent.mm.ui.base.h.a(this, 2131763134, 2131755906, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(127948);
        return;
      }
      if (paramInt2 == -86)
      {
        com.tencent.mm.ui.base.h.a(this, 2131763140, 2131755906, new DialogInterface.OnClickListener()
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
      paramString = com.tencent.mm.h.a.rM(paramString);
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
      if (this.iPT != null) {
        this.iPT.dismiss();
      }
      int i = ((w)paramn).opType;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 0) {}
        for (paramInt1 = 2131757663;; paramInt1 = 2131757658)
        {
          Toast.makeText(this, paramInt1, 1).show();
          this.iQw = false;
          aQA();
          if (i == 1)
          {
            ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNG("facebookapp");
            ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().alq("facebookapp");
            this.iQx = true;
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
      paramString = com.tencent.mm.h.a.rM(paramString);
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
      ac.d("MicroMsg.FacebookAuthUI", "onError:" + paramb.getMessage());
      com.tencent.mm.ui.base.h.c(FacebookAuthUI.this, paramb.getMessage(), FacebookAuthUI.this.getString(2131757657), true);
      FacebookAuthUI.aQB();
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(582L, 3L, 1L, false);
      AppMethodBeat.o(127936);
    }
    
    public final void a(com.tencent.mm.ui.g.a.e parame)
    {
      AppMethodBeat.i(127935);
      ac.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + parame.IJb);
      com.tencent.mm.ui.base.h.c(FacebookAuthUI.this, parame.getMessage(), FacebookAuthUI.this.getString(2131757657), true);
      FacebookAuthUI.aQB();
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(582L, 2L, 1L, false);
      AppMethodBeat.o(127935);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(127937);
      ac.d("MicroMsg.FacebookAuthUI", "onCancel");
      FacebookAuthUI.aQB();
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(582L, 4L, 1L, false);
      AppMethodBeat.o(127937);
    }
    
    public final void w(Bundle paramBundle)
    {
      AppMethodBeat.i(127934);
      FacebookAuthUI.a(FacebookAuthUI.this, FacebookAuthUI.g(FacebookAuthUI.this).iFS);
      com.tencent.mm.kernel.g.agR().agA().set(65830, FacebookAuthUI.h(FacebookAuthUI.this));
      if (FacebookAuthUI.g(FacebookAuthUI.this).IIO != 0L) {
        com.tencent.mm.kernel.g.agR().agA().set(65832, Long.valueOf(FacebookAuthUI.g(FacebookAuthUI.this).IIO));
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