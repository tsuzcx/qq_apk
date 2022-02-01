package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.plugin.fingerprint.b.l;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(3)
public class WalletFaceIdAuthUI
  extends WalletBaseUI
{
  Button Bxw;
  private c Bxx;
  int mScene;
  
  public final void aGW(String paramString)
  {
    AppMethodBeat.i(64256);
    com.tencent.mm.ui.base.h.a(this, paramString, "", getString(a.i.app_i_known), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(64231);
        WalletFaceIdAuthUI.a(WalletFaceIdAuthUI.this).eoc();
        AppMethodBeat.o(64231);
      }
    });
    AppMethodBeat.o(64256);
  }
  
  public int getLayoutId()
  {
    return a.g.faceid_open_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64253);
    this.Bxw = ((Button)findViewById(a.f.fiou_verify_btn));
    this.Bxw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64230);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletFaceIdAuthUI.a(WalletFaceIdAuthUI.this).eod();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64230);
      }
    });
    AppMethodBeat.o(64253);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(64254);
    boolean bool = this.Bxx.isTransparent();
    AppMethodBeat.o(64254);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64252);
    this.mScene = getIntent().getIntExtra("key_scene", 1);
    Log.i("MicroMsg.WalletFaceIdAuthUI", "scene: %s", new Object[] { Integer.valueOf(this.mScene) });
    if (this.mScene == 0) {
      this.Bxx = new b(this);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      setMMTitle(a.i.faceid_open_title);
      this.Bxx.onCreate();
      initView();
      AppMethodBeat.o(64252);
      return;
      if (this.mScene == 1) {
        this.Bxx = new a(this);
      }
    }
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64255);
    boolean bool = this.Bxx.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
    AppMethodBeat.o(64255);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends WalletFaceIdAuthUI.c
  {
    public a(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
    {
      super();
      AppMethodBeat.i(64234);
      com.tencent.mm.plugin.soter.d.a.ahN(0);
      AppMethodBeat.o(64234);
    }
    
    private void eof()
    {
      AppMethodBeat.i(64239);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do finish");
      this.BxD.finish();
      AppMethodBeat.o(64239);
    }
    
    protected final void eob()
    {
      AppMethodBeat.i(64236);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
      this.BxD.showProgress();
      this.BxC.a(this.BxD, new com.tencent.mm.plugin.fingerprint.d.b()
      {
        public final void bh(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64232);
          Log.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          WalletFaceIdAuthUI.a.this.BxD.hideProgress();
          if (paramAnonymousInt == 0)
          {
            WalletFaceIdAuthUI.a.this.eoh();
            AppMethodBeat.o(64232);
            return;
          }
          WalletFaceIdAuthUI.a.this.BxD.aGW(WalletFaceIdAuthUI.a.this.BxD.getString(a.i.biometric_pay_faceid_manufacturer_errmsg));
          AppMethodBeat.o(64232);
        }
      }, this.njf);
      AppMethodBeat.o(64236);
    }
    
    protected final void eoc()
    {
      AppMethodBeat.i(64238);
      eof();
      AppMethodBeat.o(64238);
    }
    
    protected final void eod() {}
    
    protected final int eoe()
    {
      return 1;
    }
    
    protected final boolean isTransparent()
    {
      return true;
    }
    
    public final void onCreate()
    {
      AppMethodBeat.i(64235);
      this.BxD.getWindow().setDimAmount(0.0F);
      super.onCreate();
      this.BxD.hideTitleView();
      this.BxD.hideActionbarLine();
      this.BxD.setContentViewVisibility(8);
      AppMethodBeat.o(64235);
    }
    
    protected final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(64237);
      if (this.BxC.onSceneEnd(paramInt1, paramInt2, paramString, paramq))
      {
        AppMethodBeat.o(64237);
        return true;
      }
      if ((paramq instanceof ae))
      {
        this.BxD.hideProgress();
        com.tencent.mm.ui.base.h.a(this.BxD, this.BxD.getString(a.i.faceid_open_success_msg_text), this.BxD.getString(a.i.faceid_open_success), this.BxD.getString(a.i.wallet_password_setting_ui_set_sys_faceid_guide_known_btn), false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(64233);
            WalletFaceIdAuthUI.a.a(WalletFaceIdAuthUI.a.this);
            AppMethodBeat.o(64233);
          }
        });
        AppMethodBeat.o(64237);
        return true;
      }
      AppMethodBeat.o(64237);
      return false;
    }
  }
  
  public static final class b
    extends WalletFaceIdAuthUI.c
  {
    public b(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
    {
      super();
      AppMethodBeat.i(64242);
      com.tencent.mm.plugin.soter.d.a.ahN(1);
      AppMethodBeat.o(64242);
    }
    
    private void eog()
    {
      AppMethodBeat.i(64247);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do end process");
      com.tencent.mm.wallet_core.a.b(this.BxD, new Bundle(), 0);
      AppMethodBeat.o(64247);
    }
    
    protected final void eob()
    {
      AppMethodBeat.i(64243);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
      this.BxD.showProgress();
      this.BxC.a(this.BxD, new com.tencent.mm.plugin.fingerprint.d.b()
      {
        public final void bh(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64241);
          Log.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          WalletFaceIdAuthUI.b.this.BxD.hideProgress();
          if (paramAnonymousInt == 0)
          {
            WalletFaceIdAuthUI.b.this.BxD.Bxw.setEnabled(true);
            AppMethodBeat.o(64241);
            return;
          }
          WalletFaceIdAuthUI.b.this.BxD.aGW(WalletFaceIdAuthUI.b.this.BxD.getString(a.i.biometric_pay_faceid_manufacturer_errmsg));
          AppMethodBeat.o(64241);
        }
      }, this.njf);
      AppMethodBeat.o(64243);
    }
    
    public final void eoc()
    {
      AppMethodBeat.i(64246);
      eog();
      AppMethodBeat.o(64246);
    }
    
    public final void eod()
    {
      AppMethodBeat.i(64245);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do verify face id");
      eoh();
      AppMethodBeat.o(64245);
    }
    
    protected final int eoe()
    {
      return 0;
    }
    
    protected final boolean isTransparent()
    {
      return false;
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(64244);
      if (this.BxC.onSceneEnd(paramInt1, paramInt2, paramString, paramq))
      {
        AppMethodBeat.o(64244);
        return true;
      }
      if ((paramq instanceof ae))
      {
        this.BxD.hideProgress();
        eog();
        Toast.makeText(this.BxD, a.i.fingerprint_open_success, 0).show();
        AppMethodBeat.o(64244);
        return true;
      }
      AppMethodBeat.o(64244);
      return false;
    }
  }
  
  public static abstract class c
  {
    protected com.tencent.mm.plugin.fingerprint.d.a BxB;
    protected l BxC;
    protected WalletFaceIdAuthUI BxD;
    protected String njf;
    protected Bundle pfc;
    
    public c(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
    {
      this.BxD = paramWalletFaceIdAuthUI;
      if (paramWalletFaceIdAuthUI.mScene == 0) {}
      for (paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getProcess().fKb;; paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getIntent().getExtras())
      {
        this.pfc = paramWalletFaceIdAuthUI;
        this.BxC = new l();
        this.BxB = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class));
        return;
      }
    }
    
    protected final void Sk(int paramInt)
    {
      paramInt = 1;
      this.BxD.showProgress();
      if (eoe() == 1) {
        paramInt = 2;
      }
      this.BxC.a(new com.tencent.mm.plugin.fingerprint.d.b()
      {
        public final void bh(int paramAnonymousInt, String paramAnonymousString)
        {
          int i = 2;
          AppMethodBeat.i(64248);
          if (paramAnonymousInt == 0)
          {
            Log.i("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay success");
            WalletFaceIdAuthUI.c.this.BxD.doSceneProgress(new ae(null, 19), false);
            paramAnonymousString = com.tencent.mm.plugin.report.service.h.IzE;
            paramAnonymousInt = i;
            if (WalletFaceIdAuthUI.c.this.eoe() == 1) {
              paramAnonymousInt = 1;
            }
            paramAnonymousString.a(15817, new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.h.IzE.el(916, 1);
            AppMethodBeat.o(64248);
            return;
          }
          WalletFaceIdAuthUI.c.this.BxD.hideProgress();
          Log.e("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay failed");
          WalletFaceIdAuthUI.c.this.BxD.aGW(WalletFaceIdAuthUI.c.this.BxD.getString(a.i.faceid_open_fail));
          com.tencent.mm.plugin.report.service.h.IzE.el(916, 2);
          AppMethodBeat.o(64248);
        }
      }, paramInt);
    }
    
    protected abstract void eob();
    
    protected abstract void eoc();
    
    protected abstract void eod();
    
    protected abstract int eoe();
    
    protected final void eoh()
    {
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do face id auth");
      com.tencent.mm.plugin.fingerprint.b.h localh = (com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.b.h.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("face_auth_scene", 0);
      localh.a(this.BxD, new a()
      {
        public final void onAuthCancel()
        {
          AppMethodBeat.i(64251);
          WalletFaceIdAuthUI.c.this.BxD.finish();
          AppMethodBeat.o(64251);
        }
        
        public final void onAuthFail(int paramAnonymousInt)
        {
          AppMethodBeat.i(64250);
          WalletFaceIdAuthUI.c.this.BxD.aGW(WalletFaceIdAuthUI.c.this.BxD.getString(a.i.faceid_open_fail));
          AppMethodBeat.o(64250);
        }
        
        public final void onAuthSuccess(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(64249);
          WalletFaceIdAuthUI.c.this.Sk(paramAnonymousInt1);
          AppMethodBeat.o(64249);
        }
      }, localBundle);
    }
    
    protected abstract boolean isTransparent();
    
    public void onCreate()
    {
      boolean bool2 = true;
      if (this.BxB == null)
      {
        Log.w("MicroMsg.WalletFaceIdAuthUI", "no mgr");
        this.BxD.aGW(this.BxD.getString(a.i.faceid_open_fail));
        return;
      }
      boolean bool3 = this.BxB.eoA();
      boolean bool4 = this.BxB.eoB();
      boolean bool1;
      if (af.juL.jsW != 1)
      {
        bool1 = true;
        if ((bool3) && (bool4) && (!bool1) && (this.pfc != null)) {
          break label162;
        }
        if (this.pfc != null) {
          break label157;
        }
      }
      for (;;)
      {
        Log.w("MicroMsg.WalletFaceIdAuthUI", "support: %s, enrolled: %s, forceClose: %s, data: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        this.BxD.aGW(this.BxD.getString(a.i.faceid_open_fail));
        return;
        bool1 = false;
        break;
        label157:
        bool2 = false;
      }
      label162:
      this.njf = this.pfc.getString("pwd");
      if (Util.isNullOrNil(this.njf))
      {
        Log.w("MicroMsg.WalletFaceIdAuthUI", "no pwd");
        this.BxD.aGW(this.BxD.getString(a.i.faceid_open_fail));
        return;
      }
      f.ipn().ipo();
      eob();
    }
    
    protected abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI
 * JD-Core Version:    0.7.0.1
 */