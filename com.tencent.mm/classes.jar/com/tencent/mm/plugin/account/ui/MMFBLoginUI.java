package com.tencent.mm.plugin.account.ui;

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
import com.tencent.mm.autogen.mmdata.rpt.pu;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.w;

public class MMFBLoginUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private static final String[] qbG = { "public_profile", "email", "user_location" };
  private String idu;
  private String pQb;
  private IListener pZz;
  private DialogInterface.OnCancelListener qbI;
  private String qbM;
  private com.tencent.mm.ui.mmfb.sdk.f qbV;
  private w qbW;
  private u qbX;
  private pu qbY;
  private c qbZ;
  boolean qca;
  
  public MMFBLoginUI()
  {
    AppMethodBeat.i(304918);
    this.qbM = "";
    this.idu = "";
    this.qbY = new pu();
    this.pZz = new MMFBLoginUI.1(this, com.tencent.mm.app.f.hfK);
    this.qca = true;
    AppMethodBeat.o(304918);
  }
  
  private void bYi()
  {
    AppMethodBeat.i(304922);
    try
    {
      if (this.qbV != null) {
        this.qbV.nB(this);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localStringBuilder = localStringBuilder.append(b.aZR()).append(",").append(getClass().getName()).append(",L14,");
      com.tencent.mm.kernel.h.baC();
      com.tencent.mm.plugin.b.a.Du(b.Fw("L14") + ",1");
      this.qbV = new com.tencent.mm.ui.mmfb.sdk.f();
      this.qbV.a(this, qbG, new MMFBLoginUI.a(this, (byte)0));
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(582L, 5L, 1L, false);
      AppMethodBeat.o(304922);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.FacebookLoginUI", localException, "", new Object[0]);
      }
    }
  }
  
  private void goBack()
  {
    AppMethodBeat.i(304919);
    com.tencent.mm.plugin.b.a.TA(this.pQb);
    finish();
    AppMethodBeat.o(304919);
  }
  
  public int getResourceId()
  {
    return r.k.facebook_login;
  }
  
  public void initView()
  {
    AppMethodBeat.i(304960);
    this.qbV = new com.tencent.mm.ui.mmfb.sdk.f();
    this.qbI = new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(305247);
        if (MMFBLoginUI.e(MMFBLoginUI.this) != null) {
          com.tencent.mm.kernel.h.aZW().a(MMFBLoginUI.e(MMFBLoginUI.this));
        }
        AppMethodBeat.o(305247);
      }
    };
    bYi();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(305241);
        MMFBLoginUI.f(MMFBLoginUI.this);
        AppMethodBeat.o(305241);
        return true;
      }
    });
    AppMethodBeat.o(304960);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(304962);
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
      bYi();
      AppMethodBeat.o(304962);
      return;
      bool = false;
      break;
      label161:
      i = str.length();
    }
    label171:
    if (this.qbV != null) {
      this.qbV.m(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(304962);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(304939);
    super.onCreate(paramBundle);
    setMMTitle(r.j.login_by_facebook);
    com.tencent.mm.plugin.account.sdk.a.pFo.aDA();
    this.pQb = com.tencent.mm.plugin.b.a.chY();
    initView();
    com.tencent.mm.kernel.h.aZW().a(701, this);
    com.tencent.mm.kernel.h.aZW().a(252, this);
    AppMethodBeat.o(304939);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(304941);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    if (this.qbV != null) {
      this.qbV.cf(this);
    }
    AppMethodBeat.o(304941);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(304953);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      goBack();
      AppMethodBeat.o(304953);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(304953);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(304950);
    super.onPause();
    this.pZz.dead();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(b.aZR()).append(",").append(getClass().getName()).append(",L100_200_FB,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(false, b.Fw("L100_200_FB") + ",2");
    AppMethodBeat.o(304950);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(304966);
    paramf = paramPreference.mKey;
    if (paramf == null)
    {
      Log.e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
      AppMethodBeat.o(304966);
      return true;
    }
    if (paramf.equals("facebook_auth_bind_btn"))
    {
      bYi();
      AppMethodBeat.o(304966);
      return true;
    }
    AppMethodBeat.o(304966);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(304945);
    this.pZz.alive();
    super.onResume();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    localStringBuilder = localStringBuilder.append(b.aZR()).append(",").append(getClass().getName()).append(",L100_200_FB,");
    com.tencent.mm.kernel.h.baC();
    com.tencent.mm.plugin.b.a.z(true, b.Fw("L100_200_FB") + ",1");
    com.tencent.mm.plugin.b.a.Tz("L100_200_FB");
    AppMethodBeat.o(304945);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(304959);
    Log.i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", new Object[] { Integer.valueOf(paramp.hashCode()), Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.qbW != null)
    {
      this.qbW.dismiss();
      this.qbW = null;
    }
    if (!Util.isTopActivity(this))
    {
      AppMethodBeat.o(304959);
      return;
    }
    if (!(paramp instanceof u))
    {
      AppMethodBeat.o(304959);
      return;
    }
    this.idu = ((u)paramp).bMh();
    int j = 0;
    int i;
    if (paramp.getType() != 252)
    {
      i = j;
      if (paramp.getType() != 701) {}
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
          com.tencent.mm.kernel.h.aZW().a(new bw(new bw.a()
          {
            public final void b(g paramAnonymousg)
            {
              AppMethodBeat.i(305252);
              if (paramAnonymousg == null)
              {
                AppMethodBeat.o(305252);
                return;
              }
              paramAnonymousg = paramAnonymousg.bGg();
              com.tencent.mm.kernel.h.baC();
              int i = b.getUin();
              paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
              AppMethodBeat.o(305252);
            }
          }), 0);
        }
      }
    }
    if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
    {
      b.aZI();
      i.bXa();
      this.qbY.joN = 1L;
      this.qbY.ikE = 12L;
      this.qbY.bMH();
      v.Sj(z.bAM());
      v.showAddrBookUploadConfirm(this, new MMFBLoginUI.6(this), false, 2);
      AppMethodBeat.o(304959);
      return;
    }
    if (paramInt2 == -106)
    {
      v.f(this, paramString, 0);
      AppMethodBeat.o(304959);
      return;
    }
    if (paramInt2 == -217)
    {
      v.a(this, com.tencent.mm.platformtools.e.d((u)paramp), paramInt2);
      AppMethodBeat.o(304959);
      return;
    }
    if ((paramInt2 == -6) || (paramInt2 == -311) || (paramInt2 == -310))
    {
      if (this.qbZ == null) {
        this.qbZ = new c()
        {
          public final p a(p paramAnonymousp, String paramAnonymousString)
          {
            AppMethodBeat.i(305243);
            paramAnonymousp = new u("facebook@wechat_auth", MMFBLoginUI.d(MMFBLoginUI.this), ((u)paramAnonymousp).getSecCodeType(), paramAnonymousString, ((u)paramAnonymousp).bMi(), ((u)paramAnonymousp).bMk(), 0, "", true, false);
            AppMethodBeat.o(305243);
            return paramAnonymousp;
          }
        };
      }
      paramString = this.qbZ;
      byte[] arrayOfByte = ((u)paramp).bMj();
      paramString.pYR = paramp;
      if (paramString.pRw == null)
      {
        paramString.pRw = SecurityImage.a.a(this, r.j.regbyqq_secimg_title, 0, arrayOfByte, "", "", new c.1(paramString, this), null, new c.2(paramString), paramString);
        AppMethodBeat.o(304959);
        return;
      }
      paramString.pRw.b(0, arrayOfByte, "", "");
      AppMethodBeat.o(304959);
      return;
    }
    if (paramInt1 == 4) {}
    switch (paramInt2)
    {
    default: 
      if (com.tencent.mm.plugin.account.sdk.a.pFo.a(getContext(), paramInt1, paramInt2, paramString)) {
        i = 1;
      }
      break;
    }
    while (i != 0)
    {
      AppMethodBeat.o(304959);
      return;
      if (com.tencent.mm.kernel.h.aZW().bFQ() == 5)
      {
        k.s(this, r.j.net_warn_server_down_tip, r.j.net_warn_server_down);
        i = 1;
      }
      else
      {
        k.s(this, r.j.errcode_password, r.j.login_err_title);
        i = 1;
        continue;
        k.s(this, r.j.login_err_mailnotverify, r.j.login_err_title);
        i = 1;
        continue;
        k.s(getContext(), r.j.regbyqq_auth_err_failed_niceqq, r.j.app_tip);
        i = 1;
        continue;
        v.ei(getContext());
        i = 1;
        continue;
        this.qbY.joN = 1L;
        this.qbY.ikE = 11L;
        this.qbY.bMH();
        k.b(this, getString(r.j.facebooklogin_user_not_bind), "", getString(r.j.regsetinfo_register), getString(r.j.loginby_mobile_other_login), new DialogInterface.OnClickListener()new MMFBLoginUI.4
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(305256);
            MMFBLoginUI.c(MMFBLoginUI.this);
            AppMethodBeat.o(305256);
          }
        }, new MMFBLoginUI.4(this));
        i = 1;
        continue;
        i = 0;
      }
    }
    if ((paramp.getType() == 252) || (paramp.getType() == 701))
    {
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(304959);
        return;
      }
    }
    Toast.makeText(this, getString(r.j.fmt_auth_err, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(304959);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MMFBLoginUI
 * JD-Core Version:    0.7.0.1
 */