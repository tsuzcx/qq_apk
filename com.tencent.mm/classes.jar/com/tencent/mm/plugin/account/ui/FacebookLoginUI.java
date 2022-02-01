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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.fl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.g.a.c.a;
import com.tencent.mm.ui.g.a.d.a;
import com.tencent.mm.ui.g.a.d.b;
import org.json.JSONObject;

public class FacebookLoginUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  private static final String[] iPW = { "public_profile", "email", "user_location" };
  private String dxX;
  private String iHQ;
  private DialogInterface.OnCancelListener iPU;
  private com.tencent.mm.sdk.b.c iQA;
  private com.tencent.mm.ui.g.a.c iQL;
  private p iQM;
  private s iQN;
  private fl iQO;
  private b iQP;
  boolean iQQ;
  private com.tencent.mm.ui.g.a.d iQv;
  private String iQy;
  
  public FacebookLoginUI()
  {
    AppMethodBeat.i(127999);
    this.iQy = "";
    this.dxX = "";
    this.iQO = new fl();
    this.iQA = new FacebookLoginUI.1(this);
    this.iQQ = true;
    AppMethodBeat.o(127999);
  }
  
  private void aQC()
  {
    AppMethodBeat.i(128006);
    if (isFinishing())
    {
      AppMethodBeat.o(128006);
      return;
    }
    getString(2131755906);
    this.iQM = com.tencent.mm.ui.base.h.b(this, getString(2131760781), true, null);
    this.iQM.setOnCancelListener(this.iPU);
    ac.i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", new Object[] { "facebook@wechat_auth", Integer.valueOf(this.iQy.length()), this.iQy.substring(0, 4) });
    this.iQN = new s("facebook@wechat_auth", this.iQy, 0, "", "", "", 0, "", true, false);
    com.tencent.mm.kernel.g.agi().a(this.iQN, 0);
    AppMethodBeat.o(128006);
  }
  
  private void aQD()
  {
    AppMethodBeat.i(128007);
    if (r.t(this, "com.facebook.katana"))
    {
      if (this.iQv == null)
      {
        this.iQv = new com.tencent.mm.ui.g.a.d(getString(2131758773));
        this.iQv.fsQ();
      }
      if (!this.iQv.fsP())
      {
        this.iQv.logout();
        this.iQv.a(this, new d.b()
        {
          public final void onCancel()
          {
            AppMethodBeat.i(127984);
            ac.i("MicroMsg.FacebookLoginUI", "facebook-android login cancel!");
            AppMethodBeat.o(127984);
          }
          
          public final void onError(String paramAnonymousString)
          {
            AppMethodBeat.i(127985);
            ac.i("MicroMsg.FacebookLoginUI", "facebook-android login error! %s", new Object[] { paramAnonymousString });
            com.tencent.mm.ui.base.h.c(FacebookLoginUI.this, FacebookLoginUI.this.getString(2131758779), "", true);
            AppMethodBeat.o(127985);
          }
          
          public final void onSuccess()
          {
            AppMethodBeat.i(127983);
            ac.i("MicroMsg.FacebookLoginUI", "facebook-android login success!");
            FacebookLoginUI.a(FacebookLoginUI.this, FacebookLoginUI.a(FacebookLoginUI.this).IIV.getToken());
            FacebookLoginUI.b(FacebookLoginUI.this);
            AppMethodBeat.o(127983);
          }
        }, iPW);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(582L, 5L, 1L, false);
      AppMethodBeat.o(128007);
      return;
      aQC();
      continue;
      try
      {
        if (this.iQL != null) {
          this.iQL.kk(this);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L14,");
        com.tencent.mm.kernel.g.agP();
        com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("L14") + ",1");
        this.iQL = new com.tencent.mm.ui.g.a.c(getString(2131758773));
        this.iQL.a(this, iPW, new a((byte)0));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.FacebookLoginUI", localException, "", new Object[0]);
        }
      }
    }
  }
  
  private void aQE()
  {
    AppMethodBeat.i(128009);
    String str = getString(2131757964, new Object[] { "0x" + Integer.toHexString(com.tencent.mm.protocal.d.DIc), ab.eUO() });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", str);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
    com.tencent.mm.plugin.account.a.a.iyx.i(localIntent, this);
    AppMethodBeat.o(128009);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(128005);
    com.tencent.mm.plugin.b.a.IL(this.iHQ);
    finish();
    AppMethodBeat.o(128005);
  }
  
  public int getResourceId()
  {
    return 2131951674;
  }
  
  public void initView()
  {
    AppMethodBeat.i(128010);
    this.iQL = new com.tencent.mm.ui.g.a.c(getString(2131758773));
    this.iPU = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(127981);
        if (FacebookLoginUI.h(FacebookLoginUI.this) != null) {
          com.tencent.mm.kernel.g.agi().a(FacebookLoginUI.h(FacebookLoginUI.this));
        }
        AppMethodBeat.o(127981);
      }
    };
    aQD();
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
      ac.i("MicroMsg.FacebookLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label171;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      j = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bs.isNullOrNil(str);
      if (!bs.isNullOrNil(str)) {
        break label161;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.FacebookLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if (j != -217) {
        break label171;
      }
      aQD();
      AppMethodBeat.o(128011);
      return;
      bool = false;
      break;
      label161:
      i = str.length();
    }
    label171:
    if (this.iQL != null) {
      this.iQL.i(paramInt1, paramInt2, paramIntent);
    }
    if (this.iQv != null) {
      this.iQv.i(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(128011);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(128000);
    super.onCreate(paramBundle);
    setMMTitle(2131760751);
    com.tencent.mm.plugin.account.a.a.iyy.Lm();
    this.iHQ = com.tencent.mm.plugin.b.a.EL();
    initView();
    com.tencent.mm.kernel.g.agi().a(701, this);
    com.tencent.mm.kernel.g.agi().a(252, this);
    AppMethodBeat.o(128000);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(128001);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(701, this);
    com.tencent.mm.kernel.g.agi().b(252, this);
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
    com.tencent.mm.sdk.b.a.GpY.d(this.iQA);
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L100_200_FB,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(false, com.tencent.mm.kernel.a.uc("L100_200_FB") + ",2");
    AppMethodBeat.o(128003);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(128012);
    paramf = paramPreference.mKey;
    if (paramf == null)
    {
      ac.e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
      AppMethodBeat.o(128012);
      return true;
    }
    if (paramf.equals("facebook_auth_bind_btn"))
    {
      aQD();
      AppMethodBeat.o(128012);
      return true;
    }
    AppMethodBeat.o(128012);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(128002);
    com.tencent.mm.sdk.b.a.GpY.c(this.iQA);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.g.agP();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(getClass().getName()).append(",L100_200_FB,");
    com.tencent.mm.kernel.g.agP();
    com.tencent.mm.plugin.b.a.h(true, com.tencent.mm.kernel.a.uc("L100_200_FB") + ",1");
    com.tencent.mm.plugin.b.a.IK("L100_200_FB");
    AppMethodBeat.o(128002);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(128008);
    ac.i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", new Object[] { Integer.valueOf(paramn.hashCode()), Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.iQM != null)
    {
      this.iQM.dismiss();
      this.iQM = null;
    }
    if (!bs.iX(this))
    {
      AppMethodBeat.o(128008);
      return;
    }
    if (!(paramn instanceof s))
    {
      AppMethodBeat.o(128008);
      return;
    }
    this.dxX = ((s)paramn).aHz();
    int j = 0;
    int i;
    if (paramn.getType() != 252)
    {
      i = j;
      if (paramn.getType() != 701) {}
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
          com.tencent.mm.kernel.g.agi().a(new bn(new FacebookLoginUI.9(this)), 0);
        }
      }
    }
    if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.plugin.account.friend.a.l.aPH();
      this.iQO.dXB = 1L;
      this.iQO.dCQ = 12L;
      this.iQO.aHZ();
      y.FH(u.axw());
      t.cW(this);
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
      y.a(this, com.tencent.mm.platformtools.e.a((s)paramn), paramInt2);
      AppMethodBeat.o(128008);
      return;
    }
    if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
    {
      if (this.iQP == null) {
        this.iQP = new b()
        {
          public final n a(n paramAnonymousn, String paramAnonymousString)
          {
            AppMethodBeat.i(127994);
            paramAnonymousn = new s("facebook@wechat_auth", FacebookLoginUI.g(FacebookLoginUI.this), ((s)paramAnonymousn).getSecCodeType(), paramAnonymousString, ((s)paramAnonymousn).aHA(), ((s)paramAnonymousn).aHC(), 0, "", true, false);
            AppMethodBeat.o(127994);
            return paramAnonymousn;
          }
        };
      }
      paramString = this.iQP;
      byte[] arrayOfByte = ((s)paramn).aHB();
      paramString.iPK = paramn;
      if (paramString.iJk == null)
      {
        paramString.iJk = SecurityImage.a.a(this, 0, arrayOfByte, "", "", new b.1(paramString, this), null, new b.2(paramString), paramString);
        AppMethodBeat.o(128008);
        return;
      }
      paramString.iJk.b(0, arrayOfByte, "", "");
      AppMethodBeat.o(128008);
      return;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (com.tencent.mm.plugin.account.a.a.iyy.a(getContext(), paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      break;
    }
    while (i != 0)
    {
      AppMethodBeat.o(128008);
      return;
      if (com.tencent.mm.kernel.g.agi().aBK() == 5)
      {
        com.tencent.mm.ui.base.h.l(this, 2131761537, 2131761536);
        i = 1;
      }
      else
      {
        com.tencent.mm.ui.base.h.l(this, 2131758459, 2131760766);
        i = 1;
        continue;
        com.tencent.mm.ui.base.h.l(this, 2131760765, 2131760766);
        i = 1;
        continue;
        com.tencent.mm.ui.base.h.l(getContext(), 2131762374, 2131755906);
        i = 1;
        continue;
        y.de(getContext());
        i = 1;
        continue;
        this.iQO.dXB = 1L;
        this.iQO.dCQ = 11L;
        this.iQO.aHZ();
        com.tencent.mm.ui.base.h.d(this, getString(2131758803), "", getString(2131762395), getString(2131760795), new DialogInterface.OnClickListener()new FacebookLoginUI.8
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(127990);
            if (com.tencent.mm.protocal.d.DIf)
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
        if (com.tencent.mm.protocal.d.DIf) {
          aQE();
        }
        i = 1;
        continue;
        i = 0;
      }
    }
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.rM(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(128008);
        return;
      }
    }
    Toast.makeText(this, getString(2131759490, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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
    
    public final void a(com.tencent.mm.ui.g.a.b paramb)
    {
      AppMethodBeat.i(127997);
      ac.d("MicroMsg.FacebookLoginUI", "onError:" + paramb.getMessage());
      com.tencent.mm.ui.base.h.c(FacebookLoginUI.this, paramb.getMessage(), FacebookLoginUI.this.getString(2131758779), true);
      FacebookLoginUI.aQF();
      paramb = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      paramb = paramb.append(com.tencent.mm.kernel.a.agc()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("L14") + ",2");
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(582L, 8L, 1L, false);
      AppMethodBeat.o(127997);
    }
    
    public final void a(com.tencent.mm.ui.g.a.e parame)
    {
      AppMethodBeat.i(127996);
      ac.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + parame.getMessage());
      com.tencent.mm.ui.base.h.c(FacebookLoginUI.this, parame.getMessage(), FacebookLoginUI.this.getString(2131758779), true);
      FacebookLoginUI.aQF();
      parame = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      parame = parame.append(com.tencent.mm.kernel.a.agc()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("L14") + ",2");
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(582L, 7L, 1L, false);
      AppMethodBeat.o(127996);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(127998);
      ac.d("MicroMsg.FacebookLoginUI", "onCancel");
      FacebookLoginUI.aQF();
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.g.agP();
      localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.agc()).append(",").append(FacebookLoginUI.this.getClass().getName()).append(",L14,");
      com.tencent.mm.kernel.g.agP();
      com.tencent.mm.plugin.b.a.sv(com.tencent.mm.kernel.a.uc("L14") + ",2");
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(582L, 9L, 1L, false);
      AppMethodBeat.o(127998);
    }
    
    public final void w(Bundle paramBundle)
    {
      AppMethodBeat.i(127995);
      FacebookLoginUI.a(FacebookLoginUI.this, FacebookLoginUI.d(FacebookLoginUI.this).iFS);
      FacebookLoginUI.b(FacebookLoginUI.this);
      AppMethodBeat.o(127995);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI
 * JD-Core Version:    0.7.0.1
 */