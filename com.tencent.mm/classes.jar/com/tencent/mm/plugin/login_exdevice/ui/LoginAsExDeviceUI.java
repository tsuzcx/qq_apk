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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.bu.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.protocal.protobuf.ckg;
import com.tencent.mm.protocal.protobuf.dge;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;

public class LoginAsExDeviceUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private String UUID;
  private ProgressDialog klA;
  private x kmF;
  private ImageView yOA;
  private TextView yOB;
  private ImageView yOC;
  private TextView yOD;
  private Button yOE;
  private Button yOF;
  private TextView yOG;
  private byte[] yOH;
  private int yOI;
  private ImageView yOu;
  private ImageView yOv;
  private Button yOw;
  private View yOx;
  private View yOy;
  private View yOz;
  
  public LoginAsExDeviceUI()
  {
    AppMethodBeat.i(231749);
    this.yOI = 200;
    this.kmF = new x();
    AppMethodBeat.o(231749);
  }
  
  private void eeo()
  {
    AppMethodBeat.i(231752);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231742);
        com.tencent.mm.plugin.login_exdevice.a.b localb = new com.tencent.mm.plugin.login_exdevice.a.b();
        com.tencent.mm.kernel.g.azz().a(localb, 0);
        if (LoginAsExDeviceUI.b(LoginAsExDeviceUI.this) != null) {
          LoginAsExDeviceUI.b(LoginAsExDeviceUI.this).dismiss();
        }
        LoginAsExDeviceUI.a(LoginAsExDeviceUI.this, com.tencent.mm.ui.base.h.a(LoginAsExDeviceUI.this, LoginAsExDeviceUI.this.getString(2131762446), true, null));
        AppMethodBeat.o(231742);
      }
    }, 0L);
    AppMethodBeat.o(231752);
  }
  
  private void eep()
  {
    AppMethodBeat.i(231753);
    this.UUID = null;
    this.yOH = null;
    this.yOu.setImageResource(2131231560);
    this.yOu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(231743);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        LoginAsExDeviceUI.e(LoginAsExDeviceUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231743);
      }
    });
    eer();
    AppMethodBeat.o(231753);
  }
  
  private void eeq()
  {
    AppMethodBeat.i(231754);
    Log.i("MicroMsg.LoginAsExDeviceUI", "doCheckLogin %s", new Object[] { Util.getStack() });
    Runnable local8 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231746);
        com.tencent.mm.plugin.login_exdevice.a.a locala = new com.tencent.mm.plugin.login_exdevice.a.a(LoginAsExDeviceUI.g(LoginAsExDeviceUI.this), LoginAsExDeviceUI.h(LoginAsExDeviceUI.this));
        com.tencent.mm.kernel.g.azz().a(locala, 0);
        AppMethodBeat.o(231746);
      }
    };
    if (this.yOI > 2000) {}
    int i;
    for (long l = 2000L;; l = i)
    {
      MMHandlerThread.postToMainThreadDelayed(local8, l);
      AppMethodBeat.o(231754);
      return;
      i = this.yOI + 200;
      this.yOI = i;
    }
  }
  
  private void eer()
  {
    AppMethodBeat.i(231755);
    if ((!Util.isNullOrNil(this.UUID)) && (this.yOH != null))
    {
      this.yOw.setText(2131762510);
      if (this.yOG != null) {
        this.yOG.setVisibility(0);
      }
      if (this.yOv != null)
      {
        this.yOv.setVisibility(8);
        AppMethodBeat.o(231755);
      }
    }
    else
    {
      this.yOw.setVisibility(0);
      if (this.yOG != null) {
        this.yOG.setVisibility(8);
      }
      if (this.yOv != null) {
        this.yOv.setVisibility(0);
      }
      this.yOw.setText(2131762488);
      this.yOw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(231747);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          LoginAsExDeviceUI.e(LoginAsExDeviceUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(231747);
        }
      });
    }
    AppMethodBeat.o(231755);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(231759);
    finish();
    overridePendingTransition(2130771986, 2130772130);
    AppMethodBeat.o(231759);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(231760);
    int i = getResources().getConfiguration().orientation;
    if (BuildInfo.EX_DEVICE_LOGIN)
    {
      AppMethodBeat.o(231760);
      return 2131495314;
    }
    if (i == 2)
    {
      AppMethodBeat.o(231760);
      return 2131495316;
    }
    AppMethodBeat.o(231760);
    return 2131495315;
  }
  
  public void initView()
  {
    AppMethodBeat.i(231751);
    this.yOx = findViewById(2131303809);
    this.yOu = ((ImageView)this.yOx.findViewById(2131303781));
    this.yOw = ((Button)this.yOx.findViewById(2131303780));
    this.yOG = ((TextView)this.yOx.findViewById(2131303778));
    this.yOv = ((ImageView)this.yOx.findViewById(2131306404));
    this.yOy = findViewById(2131303799);
    this.yOC = ((ImageView)this.yOy.findViewById(2131303801));
    this.yOD = ((TextView)this.yOy.findViewById(2131303802));
    this.yOE = ((Button)this.yOy.findViewById(2131303800));
    this.yOF = ((Button)this.yOy.findViewById(2131308789));
    this.yOz = findViewById(2131303777);
    this.yOA = ((ImageView)this.yOz.findViewById(2131303793));
    this.yOB = ((TextView)this.yOz.findViewById(2131303794));
    setActionbarColor(getResources().getColor(2131099650));
    hideActionbarLine();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(231738);
        LoginAsExDeviceUI.a(LoginAsExDeviceUI.this);
        AppMethodBeat.o(231738);
        return true;
      }
    }, 2131689490);
    if (!Util.isNullOrNil(new String[] { null, null, null, null })) {
      throw new NullPointerException();
    }
    setMMTitle(getResources().getString(2131762492));
    eeo();
    AppMethodBeat.o(231751);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(231750);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(231750);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(231756);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(231756);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(231756);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(231762);
    this.kmF.a(this, paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(231762);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(231757);
    super.onResume();
    com.tencent.mm.kernel.g.azz().a(502, this);
    com.tencent.mm.kernel.g.azz().a(503, this);
    com.tencent.mm.kernel.g.azz().a(701, this);
    com.tencent.mm.kernel.g.azz().a(252, this);
    com.tencent.mm.kernel.g.azz().a(654, this);
    AppMethodBeat.o(231757);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(231761);
    Log.i("MicroMsg.LoginAsExDeviceUI", "errType %d, errCode %d, errMsg %s, sceneType:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    if (this.klA != null) {
      this.klA.dismiss();
    }
    if (paramq.getType() == 502)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = BitmapUtil.decodeByteArray(z.a(((bpy)((com.tencent.mm.plugin.login_exdevice.a.b)paramq).hJu.iLL.iLR).LXP));
        this.yOu.setImageBitmap(paramString);
        this.yOH = z.a(((bpy)((com.tencent.mm.plugin.login_exdevice.a.b)paramq).hJu.iLL.iLR).LXR);
        this.UUID = ((bpy)((com.tencent.mm.plugin.login_exdevice.a.b)paramq).hJu.iLL.iLR).UUID;
        Log.i("MicroMsg.LoginAsExDeviceUI", "get UUID %s", new Object[] { this.UUID });
        eer();
        this.yOI = 200;
        eeq();
        AppMethodBeat.o(231761);
        return;
      }
      Log.i("MicroMsg.LoginAsExDeviceUI", "get login qrcode failed!");
      eep();
      com.tencent.mm.plugin.report.service.h.CyF.Ip(5L);
      AppMethodBeat.o(231761);
      return;
    }
    Object localObject;
    if (paramq.getType() == 503)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.login_exdevice.a.a)paramq).een();
        if (paramString != null)
        {
          Log.i("MicroMsg.LoginAsExDeviceUI", "uuid %s, UUID %s, imgurl:%s, nickName:%s, status:%s, expire %d", new Object[] { paramString.UUID, this.UUID, paramString.MpD, paramString.oUJ, Integer.valueOf(paramString.oTW), Integer.valueOf(paramString.KCC) });
          if ((!Util.isNullOrNil(new String[] { paramString.UUID, this.UUID })) && (this.UUID.equals(paramString.UUID)))
          {
            switch (paramString.oTW)
            {
            default: 
              eeq();
              AppMethodBeat.o(231761);
              return;
            case 2: 
              paramq = paramString.UserName;
              localObject = paramString.KQi;
              if (!Util.isNullOrNil(new String[] { paramString.UserName, paramString.KQi }))
              {
                this.yOz.setVisibility(0);
                this.yOx.setVisibility(8);
                this.yOy.setVisibility(8);
                paramString = new com.tencent.mm.modelsimple.t(paramq, (String)localObject, 0, "", "", "", 0, "", true, false);
                com.tencent.mm.kernel.g.azz().a(paramString, 0);
                if (this.klA != null) {
                  this.klA.dismiss();
                }
                this.klA = com.tencent.mm.ui.base.h.a(this, getString(2131762532), true, null);
                AppMethodBeat.o(231761);
                return;
              }
              Log.e("MicroMsg.LoginAsExDeviceUI", "login error when confirm, usename and pwd is empty or null");
              AppMethodBeat.o(231761);
              return;
            case 1: 
              this.yOz.setVisibility(0);
              this.yOx.setVisibility(8);
              this.yOy.setVisibility(8);
              paramq = paramString.oUJ;
              this.yOB.setText(paramq);
              if (!Util.isNullOrNil(paramString.MpD))
              {
                paramString = paramString.MpD;
                com.tencent.f.h.RTc.aX(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(231745);
                    try
                    {
                      Bitmap localBitmap = BackwardSupportUtil.BitmapFactory.decodeStream(com.tencent.mm.network.d.w(paramString, 10000, 20000));
                      if (localBitmap != null) {
                        MMHandlerThread.postToMainThread(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(231744);
                            LoginAsExDeviceUI.f(LoginAsExDeviceUI.this).setImageBitmap(this.yON);
                            AppMethodBeat.o(231744);
                          }
                        });
                      }
                      AppMethodBeat.o(231745);
                      return;
                    }
                    catch (Exception localException)
                    {
                      Log.e("MicroMsg.LoginAsExDeviceUI", "download avatar failed");
                      Log.printErrStackTrace("MicroMsg.LoginAsExDeviceUI", localException, "", new Object[0]);
                      AppMethodBeat.o(231745);
                    }
                  }
                });
              }
              eeq();
              AppMethodBeat.o(231761);
              return;
            }
            eep();
            com.tencent.mm.plugin.report.service.h.CyF.Ip(6L);
            AppMethodBeat.o(231761);
            return;
          }
          Log.i("MicroMsg.LoginAsExDeviceUI", "check login qrcode failed! uuid invalid");
          eep();
          com.tencent.mm.plugin.report.service.h.CyF.Ip(6L);
          AppMethodBeat.o(231761);
          return;
        }
        Log.i("MicroMsg.LoginAsExDeviceUI", "check login qrcode failed! loginnotify invalid");
        eep();
        com.tencent.mm.plugin.report.service.h.CyF.Ip(6L);
        AppMethodBeat.o(231761);
        return;
      }
      Log.i("MicroMsg.LoginAsExDeviceUI", "check login qrcode failed!");
      eep();
      com.tencent.mm.plugin.report.service.h.CyF.Ip(6L);
      AppMethodBeat.o(231761);
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
          bg.azz().a(new bu(new bu.a()
          {
            public final void a(com.tencent.mm.network.g paramAnonymousg)
            {
              AppMethodBeat.i(231748);
              if (paramAnonymousg == null)
              {
                AppMethodBeat.o(231748);
                return;
              }
              paramAnonymousg = paramAnonymousg.aZh();
              bg.aVF();
              int i = com.tencent.mm.model.c.getUin();
              paramAnonymousg.a(new byte[0], new byte[0], new byte[0], i);
              AppMethodBeat.o(231748);
            }
          }), 0);
        }
      }
      if ((i != 0) || ((paramInt1 == 0) && (paramInt2 == 0)))
      {
        bg.unhold();
        l.boe();
        paramString = ((com.tencent.mm.modelsimple.t)paramq).account;
        bf.iDu.aO("last_login_exdevice_weixin_username", paramString);
        localObject = z.a(((j.g)((com.tencent.mm.modelsimple.t)paramq).iMO.getRespObj()).Kzw.Nky.KKZ);
        if ((localObject != null) && (localObject.length > 0)) {
          bf.iDu.aO("last_login_exdevice_auth_key", Base64.encodeToString((byte[])localObject, 0));
        }
        if ((!as.bjx(paramString)) || (Util.isNullOrNil(((com.tencent.mm.modelsimple.t)paramq).ajx()))) {
          break label1162;
        }
        paramString = ((com.tencent.mm.modelsimple.t)paramq).ajx();
      }
    }
    label1162:
    for (;;)
    {
      y.St(paramString);
      com.tencent.mm.platformtools.t.dr(this);
      this.kmF.b(this, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231739);
          Object localObject = com.tencent.mm.plugin.login_exdevice.a.jRt.bZ(LoginAsExDeviceUI.this);
          ((Intent)localObject).addFlags(67108864);
          LoginAsExDeviceUI localLoginAsExDeviceUI = LoginAsExDeviceUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localLoginAsExDeviceUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$10", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localLoginAsExDeviceUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localLoginAsExDeviceUI, "com/tencent/mm/plugin/login_exdevice/ui/LoginAsExDeviceUI$10", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          LoginAsExDeviceUI.this.finish();
          LoginAsExDeviceUI.this.overridePendingTransition(2130771986, 2130771986);
          com.tencent.mm.plugin.report.service.h.CyF.Ip(7L);
          AppMethodBeat.o(231739);
        }
      });
      AppMethodBeat.o(231761);
      return;
      Log.i("MicroMsg.LoginAsExDeviceUI", "login failed!");
      paramString = com.tencent.mm.h.a.Dk(paramString);
      if ((paramString != null) && (paramString.a(this, null, null)))
      {
        AppMethodBeat.o(231761);
        return;
      }
      eep();
      AppMethodBeat.o(231761);
      return;
      if (paramq.getType() == 654)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.UUID = ((dge)((com.tencent.mm.plugin.login_exdevice.a.c)paramq).hJu.iLL.iLR).UUID;
          this.yOH = z.a(((dge)((com.tencent.mm.plugin.login_exdevice.a.c)paramq).hJu.iLL.iLR).LXR);
          this.yOI = 200;
          eeq();
          AppMethodBeat.o(231761);
          return;
        }
        Log.i("MicroMsg.LoginAsExDeviceUI", "push loginurl failed");
        setMMTitle(getResources().getString(2131762492));
        this.yOx.setVisibility(0);
        this.yOy.setVisibility(8);
        eep();
      }
      AppMethodBeat.o(231761);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(231758);
    com.tencent.mm.kernel.g.azz().b(502, this);
    com.tencent.mm.kernel.g.azz().b(503, this);
    com.tencent.mm.kernel.g.azz().b(701, this);
    com.tencent.mm.kernel.g.azz().b(252, this);
    com.tencent.mm.kernel.g.azz().b(654, this);
    super.onStop();
    AppMethodBeat.o(231758);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.login_exdevice.ui.LoginAsExDeviceUI
 * JD-Core Version:    0.7.0.1
 */