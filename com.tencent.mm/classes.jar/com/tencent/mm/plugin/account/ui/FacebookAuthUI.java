package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashMap;
import java.util.Map;

public class FacebookAuthUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  public static final String[] flD = { "publish_actions", "email" };
  private com.tencent.mm.ui.base.preference.f dnn;
  private com.tencent.mm.ui.f.a.c fjx;
  private boolean flE = false;
  private boolean flF = false;
  private final Map<String, Preference> flG = new HashMap();
  private com.tencent.mm.sdk.b.c flH = new FacebookAuthUI.1(this);
  private ProgressDialog flc;
  private DialogInterface.OnCancelListener fld;
  private v fle;
  
  private void XF()
  {
    this.dnn.removeAll();
    boolean bool;
    int i;
    if (this.flE)
    {
      bool = false;
      if (this.flG.containsKey("facebook_auth_tip"))
      {
        localPreference = (Preference)this.flG.get("facebook_auth_tip");
        if (!bool) {
          break label160;
        }
        i = q.j.facebook_auth_unbind_tip;
        label55:
        localPreference.setTitle(i);
        this.dnn.a(localPreference);
      }
      if (this.flG.containsKey("facebook_auth_cat"))
      {
        localPreference = (Preference)this.flG.get("facebook_auth_cat");
        this.dnn.a(localPreference);
      }
      if (bool) {
        break label167;
      }
      if (this.flG.containsKey("facebook_auth_bind_btn"))
      {
        localPreference = (Preference)this.flG.get("facebook_auth_bind_btn");
        this.dnn.a(localPreference);
      }
    }
    label160:
    label167:
    do
    {
      return;
      bool = com.tencent.mm.model.q.GL();
      break;
      i = q.j.facebook_auth_bind_tip;
      break label55;
      if (this.flG.containsKey("facebook_auth_account"))
      {
        localPreference = (Preference)this.flG.get("facebook_auth_account");
        localPreference.setTitle(getString(q.j.facebook_auth_bound_account) + com.tencent.mm.kernel.g.DP().Dz().get(65826, null));
        this.dnn.a(localPreference);
      }
      if (this.flG.containsKey("facebook_auth_cat2"))
      {
        localPreference = (Preference)this.flG.get("facebook_auth_cat2");
        this.dnn.a(localPreference);
      }
    } while (!this.flG.containsKey("facebook_auth_unbind_btn"));
    Preference localPreference = (Preference)this.flG.get("facebook_auth_unbind_btn");
    this.dnn.a(localPreference);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if (paramf == null)
    {
      y.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
      return true;
    }
    if (paramf.equals("facebook_auth_bind_btn")) {
      try
      {
        this.fjx.hc(this);
        this.fjx = new com.tencent.mm.ui.f.a.c("290293790992170");
        this.fjx.a(this, flD, new FacebookAuthUI.a(this, (byte)0));
        return true;
      }
      catch (Exception paramf)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.FacebookAuthUI", paramf, "", new Object[0]);
        }
      }
    }
    if (paramf.equals("facebook_auth_unbind_btn"))
    {
      h.a(this, q.j.facebook_auth_unbind_alert_tip, q.j.app_tip, new FacebookAuthUI.5(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      return true;
    }
    return false;
  }
  
  protected final void initView()
  {
    this.flE = getIntent().getBooleanExtra("is_force_unbind", false);
    this.fjx = new com.tencent.mm.ui.f.a.c("290293790992170");
    this.fld = new FacebookAuthUI.3(this);
    this.dnn.addPreferencesFromResource(q.k.facebook_auth);
    Preference localPreference = this.dnn.add("facebook_auth_tip");
    if (localPreference != null) {
      this.flG.put("facebook_auth_tip", localPreference);
    }
    localPreference = this.dnn.add("facebook_auth_cat");
    if (localPreference != null) {
      this.flG.put("facebook_auth_cat", localPreference);
    }
    localPreference = this.dnn.add("facebook_auth_bind_btn");
    if (localPreference != null) {
      this.flG.put("facebook_auth_bind_btn", localPreference);
    }
    localPreference = this.dnn.add("facebook_auth_account");
    if (localPreference != null) {
      this.flG.put("facebook_auth_account", localPreference);
    }
    localPreference = this.dnn.add("facebook_auth_cat2");
    if (localPreference != null) {
      this.flG.put("facebook_auth_cat2", localPreference);
    }
    localPreference = this.dnn.add("facebook_auth_unbind_btn");
    if (localPreference != null) {
      this.flG.put("facebook_auth_unbind_btn", localPreference);
    }
    setBackBtn(new FacebookAuthUI.4(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool;
    if (paramIntent == null) {
      bool = true;
    }
    for (;;)
    {
      y.i("MicroMsg.FacebookAuthUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 == -1) && (paramInt1 == 1024) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
        int j = paramIntent.getIntExtra("KVoiceHelpCode", 0);
        bool = bk.bl(str);
        int i;
        if (bk.bl(str))
        {
          i = 0;
          y.i("MicroMsg.FacebookAuthUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
          if (j != -217) {}
        }
        else
        {
          try
          {
            this.fjx.hc(this);
            this.fjx = new com.tencent.mm.ui.f.a.c("290293790992170");
            this.fjx.a(this, flD, new FacebookAuthUI.a(this, (byte)0));
            return;
            bool = false;
            continue;
            i = str.length();
          }
          catch (Exception paramIntent)
          {
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.FacebookAuthUI", paramIntent, "", new Object[0]);
            }
          }
        }
      }
    }
    this.fjx.h(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dnn = this.vdd;
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Intent localIntent = getIntent();
      localIntent.putExtra("bind_facebook_succ", this.flF);
      setResult(-1, localIntent);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.b.a.udP.d(this.flH);
    com.tencent.mm.kernel.g.Dk().b(183, this);
    com.tencent.mm.kernel.g.Dk().b(254, this);
  }
  
  protected void onResume()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.flH);
    super.onResume();
    com.tencent.mm.kernel.g.Dk().a(183, this);
    com.tencent.mm.kernel.g.Dk().a(254, this);
    XF();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (paramm.getType() == 254) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.fle = new v(0, "");
        com.tencent.mm.kernel.g.Dk().a(this.fle, 0);
      }
    }
    while (paramm.getType() != 183)
    {
      do
      {
        return;
        if (this.flc != null) {
          this.flc.dismiss();
        }
        if (paramInt2 == -82)
        {
          h.a(this, q.j.setting_unbind_qq_err_one_left, q.j.app_tip, new FacebookAuthUI.7(this));
          return;
        }
        if (paramInt2 == -83)
        {
          h.a(this, q.j.setting_unbind_qq_err_has_unbind, q.j.app_tip, new FacebookAuthUI.8(this));
          return;
        }
        if (paramInt2 == -84)
        {
          h.a(this, q.j.setting_unbind_qq_err_hasbinded, q.j.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          return;
        }
        if (paramInt2 == -85)
        {
          h.a(this, q.j.setting_unbind_qq_err_bindedbyother, q.j.app_tip, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          return;
        }
        if (paramInt2 == -86)
        {
          h.a(this, q.j.setting_unbind_qq_err_qmail, q.j.app_tip, new FacebookAuthUI.2(this));
          return;
        }
        if (paramInt2 == -106)
        {
          com.tencent.mm.platformtools.z.e(this, paramString, 0);
          return;
        }
        if (paramInt2 == -217)
        {
          com.tencent.mm.platformtools.z.a(this, com.tencent.mm.platformtools.e.a((com.tencent.mm.modelsimple.q)paramm), paramInt2);
          return;
        }
        paramString = com.tencent.mm.i.a.eI(paramString);
      } while (paramString == null);
      paramString.a(this, null, null);
      return;
    }
    if (this.flc != null) {
      this.flc.dismiss();
    }
    int i = ((v)paramm).opType;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (i == 0) {}
      for (paramInt1 = q.j.contact_info_facebookapp_unbind_success;; paramInt1 = q.j.contact_info_facebookapp_bind_success)
      {
        Toast.makeText(this, paramInt1, 1).show();
        this.flE = false;
        XF();
        if (i != 1) {
          break;
        }
        ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abu("facebookapp");
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HG("facebookapp");
        this.flF = true;
        return;
      }
    }
    if ((paramInt1 == 4) && (paramInt2 == -67))
    {
      Toast.makeText(this, q.j.facebook_auth_have_bind_facebook, 1).show();
      return;
    }
    if ((paramInt1 == 4) && (paramInt2 == -5))
    {
      if (i == 1) {}
      for (paramInt1 = q.j.facebook_auth_bind_access_denied;; paramInt1 = q.j.facebook_auth_unbind_access_denied)
      {
        Toast.makeText(this, paramInt1, 1).show();
        return;
      }
    }
    if (paramInt2 == -106)
    {
      com.tencent.mm.platformtools.z.e(this, paramString, 0);
      return;
    }
    paramString = com.tencent.mm.i.a.eI(paramString);
    if (paramString != null)
    {
      paramString.a(this, null, null);
      return;
    }
    if (i == 0) {}
    for (paramInt1 = q.j.contact_info_facebookapp_unbind_fail;; paramInt1 = q.j.contact_info_facebookapp_bind_fail)
    {
      Toast.makeText(this, paramInt1, 1).show();
      return;
    }
  }
  
  public final int xj()
  {
    return q.k.facebook_auth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookAuthUI
 * JD-Core Version:    0.7.0.1
 */