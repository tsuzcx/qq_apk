package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.az.h.a;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.g.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacebookAuthUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private static final String[] gCv = { "public_profile", "email", "user_location" };
  private com.tencent.mm.ui.g.a.c gAP;
  private d gCU;
  private boolean gCV;
  private boolean gCW;
  private String gCX;
  private final Map<String, Preference> gCY;
  private com.tencent.mm.sdk.b.c gCZ;
  private ProgressDialog gCs;
  private DialogInterface.OnCancelListener gCt;
  private v gCu;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public FacebookAuthUI()
  {
    AppMethodBeat.i(124787);
    this.gCV = false;
    this.gCW = false;
    this.gCX = "";
    this.gCY = new HashMap();
    this.gCZ = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(124787);
  }
  
  private void ari()
  {
    AppMethodBeat.i(124793);
    this.gCs = ProgressDialog.show(this, getString(2131297087), getString(2131299619), true);
    this.gCs.setOnCancelListener(this.gCt);
    this.gCu = new v(1, this.gCX);
    g.Rc().a(this.gCu, 0);
    dB(true);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(582L, 1L, 1L, false);
    AppMethodBeat.o(124793);
  }
  
  private void arj()
  {
    AppMethodBeat.i(124794);
    this.screen.removeAll();
    boolean bool;
    Preference localPreference;
    if (this.gCV)
    {
      bool = false;
      if (this.gCY.containsKey("facebook_auth_tip"))
      {
        localPreference = (Preference)this.gCY.get("facebook_auth_tip");
        if (!bool) {
          break label169;
        }
      }
    }
    label169:
    for (int i = 2131299628;; i = 2131299618)
    {
      localPreference.setTitle(i);
      this.screen.b(localPreference);
      if (this.gCY.containsKey("facebook_auth_cat"))
      {
        localPreference = (Preference)this.gCY.get("facebook_auth_cat");
        this.screen.b(localPreference);
      }
      if (bool) {
        break label175;
      }
      if (!this.gCY.containsKey("facebook_auth_bind_btn")) {
        break label330;
      }
      localPreference = (Preference)this.gCY.get("facebook_auth_bind_btn");
      this.screen.b(localPreference);
      AppMethodBeat.o(124794);
      return;
      bool = r.ZP();
      break;
    }
    label175:
    if (this.gCY.containsKey("facebook_auth_account"))
    {
      localPreference = (Preference)this.gCY.get("facebook_auth_account");
      localPreference.setTitle(getString(2131299620) + g.RL().Ru().get(65826, null));
      this.screen.b(localPreference);
    }
    if (this.gCY.containsKey("facebook_auth_cat2"))
    {
      localPreference = (Preference)this.gCY.get("facebook_auth_cat2");
      this.screen.b(localPreference);
    }
    if (this.gCY.containsKey("facebook_auth_unbind_btn"))
    {
      localPreference = (Preference)this.gCY.get("facebook_auth_unbind_btn");
      this.screen.b(localPreference);
    }
    label330:
    AppMethodBeat.o(124794);
  }
  
  private static void dB(boolean paramBoolean)
  {
    AppMethodBeat.i(124796);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      localArrayList.add(new h.a(32, str));
      ((j)g.E(j.class)).Yz().c(new com.tencent.mm.az.h(localArrayList));
      AppMethodBeat.o(124796);
      return;
    }
  }
  
  public int getResourceId()
  {
    return 2131165237;
  }
  
  public void initView()
  {
    AppMethodBeat.i(124791);
    this.gCV = getIntent().getBooleanExtra("is_force_unbind", false);
    this.gCt = new FacebookAuthUI.4(this);
    setMMTitle(2131297546);
    this.screen.addPreferencesFromResource(2131165237);
    Preference localPreference = this.screen.atx("facebook_auth_tip");
    if (localPreference != null) {
      this.gCY.put("facebook_auth_tip", localPreference);
    }
    localPreference = this.screen.atx("facebook_auth_cat");
    if (localPreference != null) {
      this.gCY.put("facebook_auth_cat", localPreference);
    }
    localPreference = this.screen.atx("facebook_auth_bind_btn");
    if (localPreference != null) {
      this.gCY.put("facebook_auth_bind_btn", localPreference);
    }
    localPreference = this.screen.atx("facebook_auth_account");
    if (localPreference != null) {
      this.gCY.put("facebook_auth_account", localPreference);
    }
    localPreference = this.screen.atx("facebook_auth_cat2");
    if (localPreference != null) {
      this.gCY.put("facebook_auth_cat2", localPreference);
    }
    localPreference = this.screen.atx("facebook_auth_unbind_btn");
    if (localPreference != null) {
      this.gCY.put("facebook_auth_unbind_btn", localPreference);
    }
    setBackBtn(new FacebookAuthUI.5(this));
    AppMethodBeat.o(124791);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(124795);
    boolean bool;
    String str;
    int j;
    if (paramIntent == null)
    {
      bool = true;
      ab.i("MicroMsg.FacebookAuthUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label173;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      j = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bo.isNullOrNil(str);
      if (!bo.isNullOrNil(str)) {
        break label163;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.FacebookAuthUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if (j != -217) {
        break label173;
      }
      ari();
      AppMethodBeat.o(124795);
      return;
      bool = false;
      break;
      label163:
      i = str.length();
    }
    label173:
    if (this.gAP != null) {
      this.gAP.h(paramInt1, paramInt2, paramIntent);
    }
    if (this.gCU != null) {
      this.gCU.h(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(124795);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(124788);
    super.onCreate(paramBundle);
    this.screen = getPreferenceScreen();
    initView();
    AppMethodBeat.o(124788);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(124798);
    if (paramInt == 4)
    {
      Intent localIntent = getIntent();
      localIntent.putExtra("bind_facebook_succ", this.gCW);
      setResult(-1, localIntent);
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(124798);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(124790);
    super.onPause();
    com.tencent.mm.sdk.b.a.ymk.d(this.gCZ);
    g.Rc().b(183, this);
    g.Rc().b(254, this);
    AppMethodBeat.o(124790);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(124792);
    paramf = paramPreference.mKey;
    if (paramf == null)
    {
      ab.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
      AppMethodBeat.o(124792);
      return true;
    }
    if (paramf.equals("facebook_auth_bind_btn"))
    {
      if (q.u(this, "com.facebook.katana"))
      {
        if (this.gCU == null)
        {
          this.gCU = new d(getString(2131306163));
          this.gCU.dNg();
        }
        if (!this.gCU.dNf())
        {
          this.gCU.logout();
          this.gCU.a(this, new FacebookAuthUI.6(this), gCv);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(124792);
        return true;
        ari();
        continue;
        try
        {
          this.gAP.ix(this);
          this.gAP = new com.tencent.mm.ui.g.a.c(getString(2131306163));
          this.gAP.a(this, gCv, new FacebookAuthUI.a(this, (byte)0));
        }
        catch (Exception paramf)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.FacebookAuthUI", paramf, "", new Object[0]);
          }
        }
      }
    }
    if (paramf.equals("facebook_auth_unbind_btn"))
    {
      com.tencent.mm.ui.base.h.a(this, 2131299626, 2131297087, new FacebookAuthUI.7(this), new FacebookAuthUI.8(this));
      AppMethodBeat.o(124792);
      return true;
    }
    AppMethodBeat.o(124792);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(124789);
    com.tencent.mm.sdk.b.a.ymk.c(this.gCZ);
    super.onResume();
    g.Rc().a(183, this);
    g.Rc().a(254, this);
    arj();
    AppMethodBeat.o(124789);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(124797);
    if (paramm.getType() == 254)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.gCu = new v(0, "");
        g.Rc().a(this.gCu, 0);
        AppMethodBeat.o(124797);
        return;
      }
      if (this.gCs != null) {
        this.gCs.dismiss();
      }
      if (paramInt2 == -82)
      {
        com.tencent.mm.ui.base.h.a(this, 2131303172, 2131297087, new FacebookAuthUI.9(this));
        AppMethodBeat.o(124797);
        return;
      }
      if (paramInt2 == -83)
      {
        com.tencent.mm.ui.base.h.a(this, 2131303169, 2131297087, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(124797);
        return;
      }
      if (paramInt2 == -84)
      {
        com.tencent.mm.ui.base.h.a(this, 2131303170, 2131297087, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(124797);
        return;
      }
      if (paramInt2 == -85)
      {
        com.tencent.mm.ui.base.h.a(this, 2131303168, 2131297087, new FacebookAuthUI.2(this));
        AppMethodBeat.o(124797);
        return;
      }
      if (paramInt2 == -86)
      {
        com.tencent.mm.ui.base.h.a(this, 2131303174, 2131297087, new FacebookAuthUI.3(this));
        AppMethodBeat.o(124797);
        return;
      }
      if (paramInt2 == -106)
      {
        com.tencent.mm.platformtools.z.f(this, paramString, 0);
        AppMethodBeat.o(124797);
        return;
      }
      if (paramInt2 == -217)
      {
        com.tencent.mm.platformtools.z.a(this, com.tencent.mm.platformtools.e.a((s)paramm), paramInt2);
        AppMethodBeat.o(124797);
        return;
      }
      paramString = com.tencent.mm.h.a.kO(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        AppMethodBeat.o(124797);
        return;
      }
      AppMethodBeat.o(124797);
      return;
    }
    if (paramm.getType() == 183)
    {
      if (this.gCs != null) {
        this.gCs.dismiss();
      }
      int i = ((v)paramm).opType;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (i == 0) {}
        for (paramInt1 = 2131298603;; paramInt1 = 2131298598)
        {
          Toast.makeText(this, paramInt1, 1).show();
          this.gCV = false;
          arj();
          if (i == 1)
          {
            ((j)g.E(j.class)).YF().arF("facebookapp");
            ((j)g.E(j.class)).bPQ().Ts("facebookapp");
            this.gCW = true;
          }
          AppMethodBeat.o(124797);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -67))
      {
        Toast.makeText(this, 2131299622, 1).show();
        AppMethodBeat.o(124797);
        return;
      }
      if ((paramInt1 == 4) && (paramInt2 == -5))
      {
        if (i == 1) {}
        for (paramInt1 = 2131299616;; paramInt1 = 2131299625)
        {
          Toast.makeText(this, paramInt1, 1).show();
          AppMethodBeat.o(124797);
          return;
        }
      }
      if (paramInt2 == -106)
      {
        com.tencent.mm.platformtools.z.f(this, paramString, 0);
        AppMethodBeat.o(124797);
        return;
      }
      paramString = com.tencent.mm.h.a.kO(paramString);
      if (paramString != null)
      {
        paramString.a(this, null, null);
        AppMethodBeat.o(124797);
        return;
      }
      if (i != 0) {
        break label583;
      }
    }
    label583:
    for (paramInt1 = 2131298602;; paramInt1 = 2131298597)
    {
      Toast.makeText(this, paramInt1, 1).show();
      AppMethodBeat.o(124797);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI
 * JD-Core Version:    0.7.0.1
 */