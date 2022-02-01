package com.tencent.mm.plugin.login_exdevice.ui;

import android.app.Activity;
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
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.protocal.protobuf.dpy;
import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;

public class LoginAsExDeviceUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private ImageView EsA;
  private TextView EsB;
  private Button EsC;
  private Button EsD;
  private TextView EsE;
  private byte[] EsF;
  private int EsG;
  private ImageView Ess;
  private ImageView Est;
  private Button Esu;
  private View Esv;
  private View Esw;
  private View Esx;
  private ImageView Esy;
  private TextView Esz;
  private String UUID;
  private ProgressDialog ndq;
  private x nex;
  
  public LoginAsExDeviceUI()
  {
    AppMethodBeat.i(230286);
    this.EsG = 200;
    this.nex = new x();
    AppMethodBeat.o(230286);
  }
  
  private void eNI()
  {
    AppMethodBeat.i(230293);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(276723);
        com.tencent.mm.plugin.login_exdevice.a.b localb = new com.tencent.mm.plugin.login_exdevice.a.b();
        com.tencent.mm.kernel.h.aGY().a(localb, 0);
        if (LoginAsExDeviceUI.b(LoginAsExDeviceUI.this) != null) {
          LoginAsExDeviceUI.b(LoginAsExDeviceUI.this).dismiss();
        }
        LoginAsExDeviceUI.a(LoginAsExDeviceUI.this, com.tencent.mm.ui.base.h.a(LoginAsExDeviceUI.this, LoginAsExDeviceUI.this.getString(R.l.loading_tips), true, null));
        AppMethodBeat.o(276723);
      }
    }, 0L);
    AppMethodBeat.o(230293);
  }
  
  private void eNJ()
  {
    AppMethodBeat.i(230296);
    this.UUID = null;
    this.EsF = null;
    this.Ess.setImageResource(R.g.card_qrcode_disable);
    this.Ess.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(279730);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        LoginAsExDeviceUI.e(LoginAsExDeviceUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279730);
      }
    });
    eNL();
    AppMethodBeat.o(230296);
  }
  
  private void eNK()
  {
    AppMethodBeat.i(230298);
    Log.i("MicroMsg.LoginAsExDeviceUI", "doCheckLogin %s", new Object[] { Util.getStack() });
    Runnable local8 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(287983);
        com.tencent.mm.plugin.login_exdevice.a.a locala = new com.tencent.mm.plugin.login_exdevice.a.a(LoginAsExDeviceUI.g(LoginAsExDeviceUI.this), LoginAsExDeviceUI.h(LoginAsExDeviceUI.this));
        com.tencent.mm.kernel.h.aGY().a(locala, 0);
        AppMethodBeat.o(287983);
      }
    };
    if (this.EsG > 2000) {}
    int i;
    for (long l = 2000L;; l = i)
    {
      MMHandlerThread.postToMainThreadDelayed(local8, l);
      AppMethodBeat.o(230298);
      return;
      i = this.EsG + 200;
      this.EsG = i;
    }
  }
  
  private void eNL()
  {
    AppMethodBeat.i(230301);
    if ((!Util.isNullOrNil(this.UUID)) && (this.EsF != null))
    {
      this.Esu.setText(R.l.login_by_scan_qrcode);
      if (this.EsE != null) {
        this.EsE.setVisibility(0);
      }
      if (this.Est != null)
      {
        this.Est.setVisibility(8);
        AppMethodBeat.o(230301);
      }
    }
    else
    {
      this.Esu.setVisibility(0);
      if (this.EsE != null) {
        this.EsE.setVisibility(8);
      }
      if (this.Est != null) {
        this.Est.setVisibility(0);
      }
      this.Esu.setText(R.l.login_as_other_qrcode_expired_tip);
      this.Esu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(275995);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          LoginAsExDeviceUI.e(LoginAsExDeviceUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(275995);
        }
      });
    }
    AppMethodBeat.o(230301);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(230309);
    finish();
    overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
    AppMethodBeat.o(230309);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(230310);
    int i = getResources().getConfiguration().orientation;
    if (BuildInfo.EX_DEVICE_LOGIN)
    {
      i = R.i.login_as_other_device;
      AppMethodBeat.o(230310);
      return i;
    }
    if (i == 2)
    {
      i = R.i.eip;
      AppMethodBeat.o(230310);
      return i;
    }
    i = R.i.eio;
    AppMethodBeat.o(230310);
    return i;
  }
  
  public void initView()
  {
    AppMethodBeat.i(230292);
    this.Esv = findViewById(R.h.dLO);
    this.Ess = ((ImageView)this.Esv.findViewById(R.h.dLH));
    this.Esu = ((Button)this.Esv.findViewById(R.h.dLG));
    this.EsE = ((TextView)this.Esv.findViewById(R.h.dLF));
    this.Est = ((ImageView)this.Esv.findViewById(R.h.dRW));
    this.Esw = findViewById(R.h.dLK);
    this.EsA = ((ImageView)this.Esw.findViewById(R.h.dLM));
    this.EsB = ((TextView)this.Esw.findViewById(R.h.dLN));
    this.EsC = ((Button)this.Esw.findViewById(R.h.dLL));
    this.EsD = ((Button)this.Esw.findViewById(R.h.dVV));
    this.Esx = findViewById(R.h.dLE);
    this.Esy = ((ImageView)this.Esx.findViewById(R.h.dLI));
    this.Esz = ((TextView)this.Esx.findViewById(R.h.dLJ));
    setActionbarColor(getResources().getColor(R.e.BG_2));
    hideActionbarLine();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(244310);
        LoginAsExDeviceUI.a(LoginAsExDeviceUI.this);
        AppMethodBeat.o(244310);
        return true;
      }
    }, R.k.actionbar_icon_close_black);
    if (!Util.isNullOrNil(new String[] { null, null, null, null })) {
      throw new NullPointerException();
    }
    setMMTitle(getResources().getString(R.l.login_as_qrcode));
    eNI();
    AppMethodBeat.o(230292);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(230289);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(230289);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(230303);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(230303);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(230303);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(230325);
    this.nex.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(230325);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(230304);
    super.onResume();
    com.tencent.mm.kernel.h.aGY().a(502, this);
    com.tencent.mm.kernel.h.aGY().a(503, this);
    com.tencent.mm.kernel.h.aGY().a(701, this);
    com.tencent.mm.kernel.h.aGY().a(252, this);
    com.tencent.mm.kernel.h.aGY().a(654, this);
    AppMethodBeat.o(230304);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(230322);
    Log.i("MicroMsg.LoginAsExDeviceUI", "errType %d, errCode %d, errMsg %s, sceneType:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    if (this.ndq != null) {
      this.ndq.dismiss();
    }
    if (paramq.getType() == 502)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = BitmapUtil.decodeByteArray(z.a(((bxs)d.c.b(((com.tencent.mm.plugin.login_exdevice.a.b)paramq).kwO.lBS)).Thg));
        this.Ess.setImageBitmap(paramString);
        this.EsF = z.a(((bxs)d.c.b(((com.tencent.mm.plugin.login_exdevice.a.b)paramq).kwO.lBS)).Thi);
        this.UUID = ((bxs)d.c.b(((com.tencent.mm.plugin.login_exdevice.a.b)paramq).kwO.lBS)).UUID;
        Log.i("MicroMsg.LoginAsExDeviceUI", "get UUID %s", new Object[] { this.UUID });
        eNL();
        this.EsG = 200;
        eNK();
        AppMethodBeat.o(230322);
        return;
      }
      Log.i("MicroMsg.LoginAsExDeviceUI", "get login qrcode failed!");
      eNJ();
      com.tencent.mm.plugin.report.service.h.IzE.PJ(5L);
      AppMethodBeat.o(230322);
      return;
    }
    Object localObject;
    if (paramq.getType() == 503)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.login_exdevice.a.a)paramq).eNH();
        if (paramString != null)
        {
          Log.i("MicroMsg.LoginAsExDeviceUI", "uuid %s, UUID %s, imgurl:%s, nickName:%s, status:%s, expire %d", new Object[] { paramString.UUID, this.UUID, paramString.TAF, paramString.rWI, Integer.valueOf(paramString.rVU), Integer.valueOf(paramString.SXb) });
          if ((!Util.isNullOrNil(new String[] { paramString.UUID, this.UUID })) && (this.UUID.equals(paramString.UUID)))
          {
            switch (paramString.rVU)
            {
            default: 
              eNK();
              AppMethodBeat.o(230322);
              return;
            case 2: 
              paramq = paramString.UserName;
              localObject = paramString.RRg;
              if (!Util.isNullOrNil(new String[] { paramString.UserName, paramString.RRg }))
              {
                this.Esx.setVisibility(0);
                this.Esv.setVisibility(8);
                this.Esw.setVisibility(8);
                paramString = new com.tencent.mm.modelsimple.t(paramq, (String)localObject, 0, "", "", "", 0, "", true, false);
                com.tencent.mm.kernel.h.aGY().a(paramString, 0);
                if (this.ndq != null) {
                  this.ndq.dismiss();
                }
                this.ndq = com.tencent.mm.ui.base.h.a(this, getString(R.l.login_logining), true, null);
                AppMethodBeat.o(230322);
                return;
              }
              Log.e("MicroMsg.LoginAsExDeviceUI", "login error when confirm, usename and pwd is empty or null");
              AppMethodBeat.o(230322);
              return;
            case 1: 
              this.Esx.setVisibility(0);
              this.Esv.setVisibility(8);
              this.Esw.setVisibility(8);
              paramq = paramString.rWI;
              this.Esz.setText(paramq);
              if (!Util.isNullOrNil(paramString.TAF))
              {
                paramString = paramString.TAF;
                com.tencent.e.h.ZvG.be(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(290966);
                    try
                    {
                      Bitmap localBitmap = BackwardSupportUtil.BitmapFactory.decodeStream(com.tencent.mm.network.d.x(paramString, 10000, 20000));
                      if (localBitmap != null) {
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(272247);
                            LoginAsExDeviceUI.f(LoginAsExDeviceUI.this).setImageBitmap(this.EsL);
                            AppMethodBeat.o(272247);
                          }
                        });
                      }
                      AppMethodBeat.o(290966);
                      return;
                    }
                    catch (Exception localException)
                    {
                      Log.e("MicroMsg.LoginAsExDeviceUI", "download avatar failed");
                      Log.printErrStackTrace("MicroMsg.LoginAsExDeviceUI", localException, "", new Object[0]);
                      AppMethodBeat.o(290966);
                    }
                  }
                });
              }
              eNK();
              AppMethodBeat.o(230322);
              return;
            }
            eNJ();
            com.tencent.mm.plugin.report.service.h.IzE.PJ(6L);
            AppMethodBeat.o(230322);
            return;
          }
          Log.i("MicroMsg.LoginAsExDeviceUI", "check login qrcode failed! uuid invalid");
          eNJ();
          com.tencent.mm.plugin.report.service.h.IzE.PJ(6L);
          AppMethodBeat.o(230322);
          return;
        }
        Log.i("MicroMsg.LoginAsExDeviceUI", "check login qrcode failed! loginnotify invalid");
        eNJ();
        com.tencent.mm.plugin.report.service.h.IzE.PJ(6L);
        AppMethodBeat.o(230322);
        return;
      }
      Log.i("MicroMsg.LoginAsExDeviceUI", "check login qrcode failed!");
      eNJ();
      com.tencent.mm.plugin.report.service.h.IzE.PJ(6L);
      AppMethodBeat.o(230322);
      return;
    }
    if ((paramq.getType() == 252) || (paramq.getType() == 701))
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
          bh.aGY().a(new bv(new bv.a()
          {
            public final void a(g paramAnonymousg)
            {
              AppMethodBeat.i(264109);
              if (paramAnonymousg == null)
              {
                AppMethodBeat.o(264109);
                return;
              }
              paramAnonymousg = paramAnonymousg.biw();
              bh.beI();
              int i = com.tencent.mm.model.c.getUin();
              paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
              AppMethodBeat.o(264109);
            }
          }), 0);
        }
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        bh.aGG();
        l.byn();
        paramString = ((com.tencent.mm.modelsimple.t)paramq).account;
        bg.ltv.aS("last_login_exdevice_weixin_username", paramString);
        localObject = z.a(((j.g)((com.tencent.mm.modelsimple.t)paramq).lCW.getRespObj()).RBm.Uxi.RLV);
        if ((localObject != null) && (localObject.length > 0)) {
          bg.ltv.aS("last_login_exdevice_auth_key", Base64.encodeToString((byte[])localObject, 0));
        }
        if ((!as.bvU(paramString)) || (Util.isNullOrNil(((com.tencent.mm.modelsimple.t)paramq).apf()))) {
          break label1162;
        }
        paramString = ((com.tencent.mm.modelsimple.t)paramq).apf();
      }
    }
    label1162:
    for (;;)
    {
      y.ZV(paramString);
      com.tencent.mm.platformtools.t.jdMethod_do(this);
      this.nex.b(this, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(273369);
          Object localObject = com.tencent.mm.plugin.login_exdevice.a.mIG.bX(LoginAsExDeviceUI.this);
          ((Intent)localObject).addFlags(67108864);
          LoginAsExDeviceUI localLoginAsExDeviceUI = LoginAsExDeviceUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localLoginAsExDeviceUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$10", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localLoginAsExDeviceUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localLoginAsExDeviceUI, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$10", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          LoginAsExDeviceUI.this.finish();
          localLoginAsExDeviceUI = LoginAsExDeviceUI.this;
          int i = R.a.anim_not_change;
          localLoginAsExDeviceUI.overridePendingTransition(i, i);
          com.tencent.mm.plugin.report.service.h.IzE.PJ(7L);
          AppMethodBeat.o(273369);
        }
      });
      AppMethodBeat.o(230322);
      return;
      Log.i("MicroMsg.LoginAsExDeviceUI", "login failed!");
      paramString = com.tencent.mm.h.a.Kb(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(230322);
        return;
      }
      eNJ();
      AppMethodBeat.o(230322);
      return;
      if (paramq.getType() == 654)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.UUID = ((dpy)d.c.b(((com.tencent.mm.plugin.login_exdevice.a.c)paramq).kwO.lBS)).UUID;
          this.EsF = z.a(((dpy)d.c.b(((com.tencent.mm.plugin.login_exdevice.a.c)paramq).kwO.lBS)).Thi);
          this.EsG = 200;
          eNK();
          AppMethodBeat.o(230322);
          return;
        }
        Log.i("MicroMsg.LoginAsExDeviceUI", "push loginurl failed");
        setMMTitle(getResources().getString(R.l.login_as_qrcode));
        this.Esv.setVisibility(0);
        this.Esw.setVisibility(8);
        eNJ();
      }
      AppMethodBeat.o(230322);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(230306);
    com.tencent.mm.kernel.h.aGY().b(502, this);
    com.tencent.mm.kernel.h.aGY().b(503, this);
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    com.tencent.mm.kernel.h.aGY().b(654, this);
    super.onStop();
    AppMethodBeat.o(230306);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI
 * JD-Core Version:    0.7.0.1
 */