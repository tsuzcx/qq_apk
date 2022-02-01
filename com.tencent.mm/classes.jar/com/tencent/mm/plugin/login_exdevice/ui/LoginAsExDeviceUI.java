package com.tencent.mm.plugin.login_exdevice.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.network.d;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.frg;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.bd;

public class LoginAsExDeviceUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private ImageView KkY;
  private ImageView KkZ;
  private Button Kla;
  private View Klb;
  private View Klc;
  private View Kld;
  private ImageView Kle;
  private TextView Klf;
  private ImageView Klg;
  private TextView Klh;
  private Button Kli;
  private Button Klj;
  private TextView Klk;
  private byte[] Kll;
  private int Klm;
  private String UUID;
  private ProgressDialog qaH;
  private com.tencent.mm.platformtools.u qbk;
  
  public LoginAsExDeviceUI()
  {
    AppMethodBeat.i(262356);
    this.Klm = 200;
    this.qbk = new com.tencent.mm.platformtools.u();
    AppMethodBeat.o(262356);
  }
  
  private void fWb()
  {
    AppMethodBeat.i(262357);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262331);
        com.tencent.mm.plugin.login_exdevice.a.b localb = new com.tencent.mm.plugin.login_exdevice.a.b();
        com.tencent.mm.kernel.h.aZW().a(localb, 0);
        if (LoginAsExDeviceUI.b(LoginAsExDeviceUI.this) != null) {
          LoginAsExDeviceUI.b(LoginAsExDeviceUI.this).dismiss();
        }
        LoginAsExDeviceUI.a(LoginAsExDeviceUI.this, k.a(LoginAsExDeviceUI.this, LoginAsExDeviceUI.this.getString(R.l.loading_tips), true, null));
        AppMethodBeat.o(262331);
      }
    }, 0L);
    AppMethodBeat.o(262357);
  }
  
  private void fWc()
  {
    AppMethodBeat.i(262361);
    this.UUID = null;
    this.Kll = null;
    this.KkY.setImageResource(R.g.card_qrcode_disable);
    this.KkY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(262328);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        LoginAsExDeviceUI.e(LoginAsExDeviceUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(262328);
      }
    });
    fWe();
    AppMethodBeat.o(262361);
  }
  
  private void fWd()
  {
    AppMethodBeat.i(262365);
    Log.i("MicroMsg.LoginAsExDeviceUI", "doCheckLogin %s", new Object[] { Util.getStack() });
    Runnable local8 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262343);
        com.tencent.mm.plugin.login_exdevice.a.a locala = new com.tencent.mm.plugin.login_exdevice.a.a(LoginAsExDeviceUI.g(LoginAsExDeviceUI.this), LoginAsExDeviceUI.h(LoginAsExDeviceUI.this));
        com.tencent.mm.kernel.h.aZW().a(locala, 0);
        AppMethodBeat.o(262343);
      }
    };
    if (this.Klm > 2000) {}
    int i;
    for (long l = 2000L;; l = i)
    {
      MMHandlerThread.postToMainThreadDelayed(local8, l);
      AppMethodBeat.o(262365);
      return;
      i = this.Klm + 200;
      this.Klm = i;
    }
  }
  
  private void fWe()
  {
    AppMethodBeat.i(262370);
    if ((!Util.isNullOrNil(this.UUID)) && (this.Kll != null))
    {
      this.Kla.setText(R.l.login_by_scan_qrcode);
      if (this.Klk != null) {
        this.Klk.setVisibility(0);
      }
      if (this.KkZ != null)
      {
        this.KkZ.setVisibility(8);
        AppMethodBeat.o(262370);
      }
    }
    else
    {
      this.Kla.setVisibility(0);
      if (this.Klk != null) {
        this.Klk.setVisibility(8);
      }
      if (this.KkZ != null) {
        this.KkZ.setVisibility(0);
      }
      this.Kla.setText(R.l.login_as_other_qrcode_expired_tip);
      this.Kla.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(262340);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          LoginAsExDeviceUI.e(LoginAsExDeviceUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(262340);
        }
      });
    }
    AppMethodBeat.o(262370);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(262373);
    WorkerProfile.aDG();
    finish();
    overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
    AppMethodBeat.o(262373);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(262405);
    int i = getResources().getConfiguration().orientation;
    if (BuildInfo.EX_DEVICE_LOGIN)
    {
      i = R.i.login_as_other_device;
      AppMethodBeat.o(262405);
      return i;
    }
    if (i == 2)
    {
      i = R.i.gln;
      AppMethodBeat.o(262405);
      return i;
    }
    i = R.i.glm;
    AppMethodBeat.o(262405);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(262391);
    this.Klb = findViewById(R.h.fNw);
    this.KkY = ((ImageView)this.Klb.findViewById(R.h.fNo));
    this.Kla = ((Button)this.Klb.findViewById(R.h.fNn));
    this.Klk = ((TextView)this.Klb.findViewById(R.h.fNm));
    this.KkZ = ((ImageView)this.Klb.findViewById(R.h.fTW));
    this.Klc = findViewById(R.h.fNs);
    this.Klg = ((ImageView)this.Klc.findViewById(R.h.fNu));
    this.Klh = ((TextView)this.Klc.findViewById(R.h.fNv));
    this.Kli = ((Button)this.Klc.findViewById(R.h.fNt));
    this.Klj = ((Button)this.Klc.findViewById(R.h.fYw));
    this.Kld = findViewById(R.h.fNl);
    this.Kle = ((ImageView)this.Kld.findViewById(R.h.fNp));
    this.Klf = ((TextView)this.Kld.findViewById(R.h.fNq));
    setActionbarColor(getResources().getColor(R.e.BG_2));
    hideActionbarLine();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(262345);
        LoginAsExDeviceUI.a(LoginAsExDeviceUI.this);
        AppMethodBeat.o(262345);
        return true;
      }
    }, R.k.actionbar_icon_close_black);
    if (!Util.isNullOrNil(new String[] { null, null, null, null })) {
      throw new NullPointerException();
    }
    setMMTitle(getResources().getString(R.l.login_as_qrcode));
    fWb();
    AppMethodBeat.o(262391);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(262389);
    super.onCreate(paramBundle);
    WorkerProfile.nL(0);
    initView();
    AppMethodBeat.o(262389);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(262394);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(262394);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(262394);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(262418);
    this.qbk.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(262418);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(262396);
    super.onResume();
    com.tencent.mm.kernel.h.aZW().a(502, this);
    com.tencent.mm.kernel.h.aZW().a(503, this);
    com.tencent.mm.kernel.h.aZW().a(701, this);
    com.tencent.mm.kernel.h.aZW().a(252, this);
    com.tencent.mm.kernel.h.aZW().a(654, this);
    AppMethodBeat.o(262396);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(262414);
    Log.i("MicroMsg.LoginAsExDeviceUI", "errType %d, errCode %d, errMsg %s, sceneType:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramp.getType()) });
    if (this.qaH != null) {
      this.qaH.dismiss();
    }
    if (paramp.getType() == 502)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = BitmapUtil.decodeByteArray(w.a(((cmv)c.c.b(((com.tencent.mm.plugin.login_exdevice.a.b)paramp).nao.otC)).aauw));
        this.KkY.setImageBitmap(paramString);
        this.Kll = w.a(((cmv)c.c.b(((com.tencent.mm.plugin.login_exdevice.a.b)paramp).nao.otC)).aauy);
        this.UUID = ((cmv)c.c.b(((com.tencent.mm.plugin.login_exdevice.a.b)paramp).nao.otC)).UUID;
        Log.i("MicroMsg.LoginAsExDeviceUI", "get UUID %s", new Object[] { this.UUID });
        fWe();
        this.Klm = 200;
        fWd();
        AppMethodBeat.o(262414);
        return;
      }
      Log.i("MicroMsg.LoginAsExDeviceUI", "get login qrcode failed!");
      fWc();
      com.tencent.mm.plugin.report.service.h.OAn.tJ(5L);
      AppMethodBeat.o(262414);
      return;
    }
    Object localObject;
    if (paramp.getType() == 503)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.login_exdevice.a.a)paramp).fWa();
        if (paramString != null)
        {
          Log.i("MicroMsg.LoginAsExDeviceUI", "uuid %s, UUID %s, imgurl:%s, nickName:%s, status:%s, expire %d", new Object[] { paramString.UUID, this.UUID, paramString.aaPV, paramString.vhX, Integer.valueOf(paramString.vhk), Integer.valueOf(paramString.aaiS) });
          if ((!Util.isNullOrNil(new String[] { paramString.UUID, this.UUID })) && (this.UUID.equals(paramString.UUID)))
          {
            switch (paramString.vhk)
            {
            default: 
              fWd();
              AppMethodBeat.o(262414);
              return;
            case 2: 
              paramp = paramString.UserName;
              localObject = paramString.YOy;
              if (!Util.isNullOrNil(new String[] { paramString.UserName, paramString.YOy }))
              {
                this.Kld.setVisibility(0);
                this.Klb.setVisibility(8);
                this.Klc.setVisibility(8);
                paramString = new com.tencent.mm.modelsimple.u(paramp, (String)localObject, 0, "", "", "", 0, "", true, false);
                com.tencent.mm.kernel.h.aZW().a(paramString, 0);
                if (this.qaH != null) {
                  this.qaH.dismiss();
                }
                this.qaH = k.a(this, getString(R.l.login_logining), true, null);
                AppMethodBeat.o(262414);
                return;
              }
              Log.e("MicroMsg.LoginAsExDeviceUI", "login error when confirm, usename and pwd is empty or null");
              AppMethodBeat.o(262414);
              return;
            case 1: 
              this.Kld.setVisibility(0);
              this.Klb.setVisibility(8);
              this.Klc.setVisibility(8);
              paramp = paramString.vhX;
              this.Klf.setText(paramp);
              if (!Util.isNullOrNil(paramString.aaPV))
              {
                paramString = paramString.aaPV;
                com.tencent.threadpool.h.ahAA.bm(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(262348);
                    try
                    {
                      Bitmap localBitmap = BackwardSupportUtil.BitmapFactory.decodeStream(d.A(paramString, 10000, 20000));
                      if (localBitmap != null) {
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(262344);
                            LoginAsExDeviceUI.f(LoginAsExDeviceUI.this).setImageBitmap(this.Klr);
                            AppMethodBeat.o(262344);
                          }
                        });
                      }
                      AppMethodBeat.o(262348);
                      return;
                    }
                    catch (Exception localException)
                    {
                      Log.e("MicroMsg.LoginAsExDeviceUI", "download avatar failed");
                      Log.printErrStackTrace("MicroMsg.LoginAsExDeviceUI", localException, "", new Object[0]);
                      AppMethodBeat.o(262348);
                    }
                  }
                });
              }
              fWd();
              AppMethodBeat.o(262414);
              return;
            }
            fWc();
            com.tencent.mm.plugin.report.service.h.OAn.tJ(6L);
            AppMethodBeat.o(262414);
            return;
          }
          Log.i("MicroMsg.LoginAsExDeviceUI", "check login qrcode failed! uuid invalid");
          fWc();
          com.tencent.mm.plugin.report.service.h.OAn.tJ(6L);
          AppMethodBeat.o(262414);
          return;
        }
        Log.i("MicroMsg.LoginAsExDeviceUI", "check login qrcode failed! loginnotify invalid");
        fWc();
        com.tencent.mm.plugin.report.service.h.OAn.tJ(6L);
        AppMethodBeat.o(262414);
        return;
      }
      Log.i("MicroMsg.LoginAsExDeviceUI", "check login qrcode failed!");
      fWc();
      com.tencent.mm.plugin.report.service.h.OAn.tJ(6L);
      AppMethodBeat.o(262414);
      return;
    }
    if ((paramp.getType() == 252) || (paramp.getType() == 701))
    {
      int j = 0;
      int i = j;
      if (paramInt1 == 4) {
        if (paramInt2 != -16)
        {
          i = j;
          if (paramInt2 != -17) {}
        }
        else
        {
          i = 1;
          bh.aZW().a(new bw(new bw.a()
          {
            public final void b(g paramAnonymousg)
            {
              AppMethodBeat.i(262350);
              if (paramAnonymousg == null)
              {
                AppMethodBeat.o(262350);
                return;
              }
              paramAnonymousg = paramAnonymousg.bGg();
              bh.bCz();
              int i = com.tencent.mm.model.c.getUin();
              paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
              AppMethodBeat.o(262350);
            }
          }), 0);
        }
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        bh.aZI();
        com.tencent.mm.plugin.account.friend.model.i.bXa();
        paramString = ((com.tencent.mm.modelsimple.u)paramp).account;
        bg.okT.bc("last_login_exdevice_weixin_username", paramString);
        localObject = w.a(((j.g)((com.tencent.mm.modelsimple.u)paramp).ouH.getRespObj()).YxP.abQQ.YJj);
        if ((localObject != null) && (localObject.length > 0)) {
          bg.okT.bc("last_login_exdevice_auth_key", Base64.encodeToString((byte[])localObject, 0));
        }
        if ((!au.bxb(paramString)) || (Util.isNullOrNil(((com.tencent.mm.modelsimple.u)paramp).aJs()))) {
          break label1158;
        }
        paramString = ((com.tencent.mm.modelsimple.u)paramp).aJs();
      }
    }
    label1158:
    for (;;)
    {
      v.Sj(paramString);
      this.qbk.b(this, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(262349);
          Object localObject = com.tencent.mm.plugin.login_exdevice.a.pFn.cJ(LoginAsExDeviceUI.this);
          ((Intent)localObject).addFlags(67108864);
          LoginAsExDeviceUI localLoginAsExDeviceUI = LoginAsExDeviceUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localLoginAsExDeviceUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$10", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localLoginAsExDeviceUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localLoginAsExDeviceUI, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$10", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          LoginAsExDeviceUI.this.finish();
          localLoginAsExDeviceUI = LoginAsExDeviceUI.this;
          int i = R.a.anim_not_change;
          localLoginAsExDeviceUI.overridePendingTransition(i, i);
          com.tencent.mm.plugin.report.service.h.OAn.tJ(7L);
          AppMethodBeat.o(262349);
        }
      });
      AppMethodBeat.o(262414);
      return;
      Log.i("MicroMsg.LoginAsExDeviceUI", "login failed!");
      paramString = com.tencent.mm.broadcast.a.CH(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(262414);
        return;
      }
      fWc();
      AppMethodBeat.o(262414);
      return;
      if (paramp.getType() == 654)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.UUID = ((eit)c.c.b(((com.tencent.mm.plugin.login_exdevice.a.c)paramp).nao.otC)).UUID;
          this.Kll = w.a(((eit)c.c.b(((com.tencent.mm.plugin.login_exdevice.a.c)paramp).nao.otC)).aauy);
          this.Klm = 200;
          fWd();
          AppMethodBeat.o(262414);
          return;
        }
        Log.i("MicroMsg.LoginAsExDeviceUI", "push loginurl failed");
        setMMTitle(getResources().getString(R.l.login_as_qrcode));
        this.Klb.setVisibility(0);
        this.Klc.setVisibility(8);
        fWc();
      }
      AppMethodBeat.o(262414);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(262400);
    com.tencent.mm.kernel.h.aZW().b(502, this);
    com.tencent.mm.kernel.h.aZW().b(503, this);
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    com.tencent.mm.kernel.h.aZW().b(654, this);
    super.onStop();
    AppMethodBeat.o(262400);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI
 * JD-Core Version:    0.7.0.1
 */