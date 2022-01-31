package com.tencent.mm.plugin.account.ui;

import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import org.json.JSONObject;

public class FacebookLoginUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private static final String[] gCv = { "public_profile", "email", "user_location" };
  private String cJr;
  private com.tencent.mm.ui.g.a.d gCU;
  private String gCX;
  private com.tencent.mm.sdk.b.c gCZ;
  private DialogInterface.OnCancelListener gCt;
  private com.tencent.mm.ui.g.a.c gDk;
  private com.tencent.mm.ui.base.p gDl;
  private s gDm;
  private bj gDn;
  private b gDo;
  boolean gDp;
  private String guI;
  
  public FacebookLoginUI()
  {
    AppMethodBeat.i(124849);
    this.gCX = "";
    this.cJr = "";
    this.gDn = new bj();
    this.gCZ = new FacebookLoginUI.1(this);
    this.gDp = true;
    AppMethodBeat.o(124849);
  }
  
  private void arl()
  {
    AppMethodBeat.i(124856);
    if (isFinishing())
    {
      AppMethodBeat.o(124856);
      return;
    }
    getString(2131297087);
    this.gDl = com.tencent.mm.ui.base.h.b(this, getString(2131301149), true, null);
    this.gDl.setOnCancelListener(this.gCt);
    ab.i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", new Object[] { "facebook@wechat_auth", Integer.valueOf(this.gCX.length()), this.gCX.substring(0, 4) });
    this.gDm = new s("facebook@wechat_auth", this.gCX, 0, "", "", "", 0, "", true, false);
    g.Rc().a(this.gDm, 0);
    AppMethodBeat.o(124856);
  }
  
  private void arm()
  {
    AppMethodBeat.i(124857);
    if (q.u(this, "com.facebook.katana"))
    {
      if (this.gCU == null)
      {
        this.gCU = new com.tencent.mm.ui.g.a.d(getString(2131306163));
        this.gCU.dNg();
      }
      if (!this.gCU.dNf())
      {
        this.gCU.logout();
        this.gCU.a(this, new FacebookLoginUI.4(this), gCv);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(582L, 5L, 1L, false);
      AppMethodBeat.o(124857);
      return;
      arl();
      continue;
      try
      {
        if (this.gDk != null) {
          this.gDk.ix(this);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        g.RJ();
        localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L14,");
        g.RJ();
        com.tencent.mm.plugin.b.a.xE(com.tencent.mm.kernel.a.mx("L14") + ",1");
        this.gDk = new com.tencent.mm.ui.g.a.c(getString(2131306163));
        this.gDk.a(this, gCv, new FacebookLoginUI.a(this, (byte)0));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.FacebookLoginUI", localException, "", new Object[0]);
        }
      }
    }
  }
  
  private void arn()
  {
    AppMethodBeat.i(124859);
    String str = getString(2131298884, new Object[] { "0x" + Integer.toHexString(com.tencent.mm.protocal.d.whH), aa.dsG() });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", str);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("needRedirect", false);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.wib);
    localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.whX);
    com.tencent.mm.plugin.account.a.a.gmO.i(localIntent, this);
    AppMethodBeat.o(124859);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(124855);
    com.tencent.mm.plugin.b.a.xD(this.guI);
    finish();
    AppMethodBeat.o(124855);
  }
  
  public int getResourceId()
  {
    return 2131165238;
  }
  
  public void initView()
  {
    AppMethodBeat.i(124860);
    this.gDk = new com.tencent.mm.ui.g.a.c(getString(2131306163));
    this.gCt = new FacebookLoginUI.2(this);
    arm();
    setBackBtn(new FacebookLoginUI.3(this));
    AppMethodBeat.o(124860);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(124861);
    boolean bool;
    String str;
    int j;
    if (paramIntent == null)
    {
      bool = true;
      ab.i("MicroMsg.FacebookLoginUI", "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if ((paramInt2 != -1) || (paramInt1 != 1024) || (paramIntent == null)) {
        break label171;
      }
      str = paramIntent.getStringExtra("VoiceLoginAuthPwd");
      j = paramIntent.getIntExtra("KVoiceHelpCode", 0);
      bool = bo.isNullOrNil(str);
      if (!bo.isNullOrNil(str)) {
        break label161;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.FacebookLoginUI", "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      if (j != -217) {
        break label171;
      }
      arm();
      AppMethodBeat.o(124861);
      return;
      bool = false;
      break;
      label161:
      i = str.length();
    }
    label171:
    if (this.gDk != null) {
      this.gDk.h(paramInt1, paramInt2, paramIntent);
    }
    if (this.gCU != null) {
      this.gCU.h(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(124861);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(124850);
    super.onCreate(paramBundle);
    setMMTitle(2131301121);
    com.tencent.mm.plugin.account.a.a.gmP.BR();
    this.guI = com.tencent.mm.plugin.b.a.awy();
    initView();
    g.Rc().a(701, this);
    g.Rc().a(252, this);
    AppMethodBeat.o(124850);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(124851);
    super.onDestroy();
    g.Rc().b(701, this);
    g.Rc().b(252, this);
    AppMethodBeat.o(124851);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(124854);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(124854);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(124854);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(124853);
    super.onPause();
    com.tencent.mm.sdk.b.a.ymk.d(this.gCZ);
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L100_200_FB,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(false, com.tencent.mm.kernel.a.mx("L100_200_FB") + ",2");
    AppMethodBeat.o(124853);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(124862);
    paramf = paramPreference.mKey;
    if (paramf == null)
    {
      ab.e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
      AppMethodBeat.o(124862);
      return true;
    }
    if (paramf.equals("facebook_auth_bind_btn"))
    {
      arm();
      AppMethodBeat.o(124862);
      return true;
    }
    AppMethodBeat.o(124862);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(124852);
    com.tencent.mm.sdk.b.a.ymk.c(this.gCZ);
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    g.RJ();
    localStringBuilder = localStringBuilder.append(com.tencent.mm.kernel.a.QX()).append(",").append(getClass().getName()).append(",L100_200_FB,");
    g.RJ();
    com.tencent.mm.plugin.b.a.g(true, com.tencent.mm.kernel.a.mx("L100_200_FB") + ",1");
    com.tencent.mm.plugin.b.a.xC("L100_200_FB");
    AppMethodBeat.o(124852);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(124858);
    ab.i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", new Object[] { Integer.valueOf(paramm.hashCode()), Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.gDl != null)
    {
      this.gDl.dismiss();
      this.gDl = null;
    }
    if (!bo.cB(this))
    {
      AppMethodBeat.o(124858);
      return;
    }
    if (!(paramm instanceof s))
    {
      AppMethodBeat.o(124858);
      return;
    }
    this.cJr = ((s)paramm).ajF();
    int j = 0;
    int i;
    if (paramm.getType() != 252)
    {
      i = j;
      if (paramm.getType() != 701) {}
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
          g.Rc().a(new bk(new FacebookLoginUI.9(this)), 0);
        }
      }
    }
    if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      com.tencent.mm.kernel.a.unhold();
      l.aqv();
      this.gDn.cXw = 1L;
      this.gDn.cRH = 12L;
      this.gDn.ake();
      z.wz(r.Zn());
      w.cs(this);
      z.showAddrBookUploadConfirm(this, new FacebookLoginUI.10(this), false, 2);
      AppMethodBeat.o(124858);
      return;
    }
    if (paramInt2 == -106)
    {
      z.f(this, paramString, 0);
      AppMethodBeat.o(124858);
      return;
    }
    if (paramInt2 == -217)
    {
      z.a(this, e.a((s)paramm), paramInt2);
      AppMethodBeat.o(124858);
      return;
    }
    if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
    {
      if (this.gDo == null) {
        this.gDo = new FacebookLoginUI.11(this);
      }
      paramString = this.gDo;
      byte[] arrayOfByte = ((s)paramm).ajH();
      paramString.gCj = paramm;
      if (paramString.gwg == null)
      {
        paramString.gwg = SecurityImage.a.a(this, 0, arrayOfByte, "", "", new b.1(paramString, this), null, new b.2(paramString), paramString);
        AppMethodBeat.o(124858);
        return;
      }
      paramString.gwg.b(0, arrayOfByte, "", "");
      AppMethodBeat.o(124858);
      return;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (com.tencent.mm.plugin.account.a.a.gmP.a(getContext(), paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      break;
    }
    while (i != 0)
    {
      AppMethodBeat.o(124858);
      return;
      if (g.Rc().adt() == 5)
      {
        com.tencent.mm.ui.base.h.h(this, 2131301790, 2131301789);
        i = 1;
      }
      else
      {
        com.tencent.mm.ui.base.h.h(this, 2131299331, 2131301135);
        i = 1;
        continue;
        com.tencent.mm.ui.base.h.h(this, 2131301134, 2131301135);
        i = 1;
        continue;
        com.tencent.mm.ui.base.h.h(getContext(), 2131302471, 2131297087);
        i = 1;
        continue;
        z.cA(getContext());
        i = 1;
        continue;
        this.gDn.cXw = 1L;
        this.gDn.cRH = 11L;
        this.gDn.ake();
        com.tencent.mm.ui.base.h.d(this, getString(2131299644), "", getString(2131302492), getString(2131301163), new FacebookLoginUI.7(this), new FacebookLoginUI.8(this));
        i = 1;
        continue;
        if (com.tencent.mm.protocal.d.whK) {
          arn();
        }
        i = 1;
        continue;
        i = 0;
      }
    }
    if ((paramm.getType() == 252) || (paramm.getType() == 701))
    {
      paramString = com.tencent.mm.h.a.kO(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(124858);
        return;
      }
    }
    Toast.makeText(this, getString(2131300023, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(124858);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.FacebookLoginUI
 * JD-Core Version:    0.7.0.1
 */