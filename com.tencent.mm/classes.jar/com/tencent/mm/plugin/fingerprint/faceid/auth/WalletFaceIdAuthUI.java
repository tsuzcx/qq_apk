package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.plugin.fingerprint.c.b;
import com.tencent.mm.plugin.fingerprint.mgr.g;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(3)
public class WalletFaceIdAuthUI
  extends WalletBaseUI
{
  Button HeZ;
  private c Hfa;
  int mScene;
  
  public final void aDo(String paramString)
  {
    AppMethodBeat.i(64256);
    com.tencent.mm.ui.base.k.a(this, paramString, "", getString(a.i.app_i_known), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(64231);
        WalletFaceIdAuthUI.a(WalletFaceIdAuthUI.this).ftf();
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
    this.HeZ = ((Button)findViewById(a.f.fiou_verify_btn));
    this.HeZ.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(275252);
        WalletFaceIdAuthUI.a(WalletFaceIdAuthUI.this).ftg();
        AppMethodBeat.o(275252);
      }
    });
    AppMethodBeat.o(64253);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(64254);
    boolean bool = this.Hfa.isTransparent();
    AppMethodBeat.o(64254);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64252);
    this.mScene = getIntent().getIntExtra("key_scene", 1);
    Log.i("MicroMsg.WalletFaceIdAuthUI", "scene: %s", new Object[] { Integer.valueOf(this.mScene) });
    if (this.mScene == 0) {
      this.Hfa = new b(this);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      setMMTitle(a.i.faceid_open_title);
      this.Hfa.onCreate();
      initView();
      AppMethodBeat.o(64252);
      return;
      if (this.mScene == 1) {
        this.Hfa = new a(this);
      }
    }
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(64255);
    boolean bool = this.Hfa.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
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
      com.tencent.mm.plugin.soter.model.a.amO(0);
      AppMethodBeat.o(64234);
    }
    
    private void fti()
    {
      AppMethodBeat.i(64239);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do finish");
      this.Hfg.finish();
      AppMethodBeat.o(64239);
    }
    
    protected final void fte()
    {
      AppMethodBeat.i(64236);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
      this.Hfg.showProgress();
      this.Hff.a(this.Hfg, new b()
      {
        public final void bL(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64232);
          Log.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          WalletFaceIdAuthUI.a.this.Hfg.hideProgress();
          if (paramAnonymousInt == 0)
          {
            WalletFaceIdAuthUI.a.this.ftk();
            AppMethodBeat.o(64232);
            return;
          }
          WalletFaceIdAuthUI.a.this.Hfg.aDo(WalletFaceIdAuthUI.a.this.Hfg.getString(a.i.biometric_pay_faceid_manufacturer_errmsg));
          AppMethodBeat.o(64232);
        }
      }, this.qgt);
      AppMethodBeat.o(64236);
    }
    
    protected final void ftf()
    {
      AppMethodBeat.i(64238);
      fti();
      AppMethodBeat.o(64238);
    }
    
    protected final void ftg() {}
    
    protected final int fth()
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
      this.Hfg.getWindow().setDimAmount(0.0F);
      super.onCreate();
      this.Hfg.hideTitleView();
      this.Hfg.hideActionbarLine();
      this.Hfg.setContentViewVisibility(8);
      AppMethodBeat.o(64235);
    }
    
    protected final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(64237);
      if (this.Hff.onSceneEnd(paramInt1, paramInt2, paramString, paramp))
      {
        AppMethodBeat.o(64237);
        return true;
      }
      if ((paramp instanceof ae))
      {
        this.Hfg.hideProgress();
        com.tencent.mm.ui.base.k.a(this.Hfg, this.Hfg.getString(a.i.faceid_open_success_msg_text), this.Hfg.getString(a.i.faceid_open_success), this.Hfg.getString(a.i.wallet_password_setting_ui_set_sys_faceid_guide_known_btn), false, new DialogInterface.OnClickListener()
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
      com.tencent.mm.plugin.soter.model.a.amO(1);
      AppMethodBeat.o(64242);
    }
    
    private void ftj()
    {
      AppMethodBeat.i(64247);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do end process");
      com.tencent.mm.wallet_core.a.b(this.Hfg, new Bundle(), 0);
      AppMethodBeat.o(64247);
    }
    
    protected final void fte()
    {
      AppMethodBeat.i(64243);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
      this.Hfg.showProgress();
      this.Hff.a(this.Hfg, new b()
      {
        public final void bL(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64241);
          Log.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          WalletFaceIdAuthUI.b.this.Hfg.hideProgress();
          if (paramAnonymousInt == 0)
          {
            WalletFaceIdAuthUI.b.this.Hfg.HeZ.setEnabled(true);
            AppMethodBeat.o(64241);
            return;
          }
          WalletFaceIdAuthUI.b.this.Hfg.aDo(WalletFaceIdAuthUI.b.this.Hfg.getString(a.i.biometric_pay_faceid_manufacturer_errmsg));
          AppMethodBeat.o(64241);
        }
      }, this.qgt);
      AppMethodBeat.o(64243);
    }
    
    public final void ftf()
    {
      AppMethodBeat.i(64246);
      ftj();
      AppMethodBeat.o(64246);
    }
    
    public final void ftg()
    {
      AppMethodBeat.i(64245);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do verify face id");
      ftk();
      AppMethodBeat.o(64245);
    }
    
    protected final int fth()
    {
      return 0;
    }
    
    protected final boolean isTransparent()
    {
      return false;
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(64244);
      if (this.Hff.onSceneEnd(paramInt1, paramInt2, paramString, paramp))
      {
        AppMethodBeat.o(64244);
        return true;
      }
      if ((paramp instanceof ae))
      {
        this.Hfg.hideProgress();
        ftj();
        Toast.makeText(this.Hfg, a.i.fingerprint_open_success, 0).show();
        AppMethodBeat.o(64244);
        return true;
      }
      AppMethodBeat.o(64244);
      return false;
    }
  }
  
  public static abstract class c
  {
    protected com.tencent.mm.plugin.fingerprint.c.a Hfe;
    protected g Hff;
    protected WalletFaceIdAuthUI Hfg;
    protected String qgt;
    protected Bundle skv;
    
    public c(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
    {
      this.Hfg = paramWalletFaceIdAuthUI;
      if (paramWalletFaceIdAuthUI.mScene == 0) {}
      for (paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getProcess().hPH;; paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getIntent().getExtras())
      {
        this.skv = paramWalletFaceIdAuthUI;
        this.Hff = new g();
        this.Hfe = ((com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class));
        return;
      }
    }
    
    protected final void VD(int paramInt)
    {
      paramInt = 1;
      this.Hfg.showProgress();
      if (fth() == 1) {
        paramInt = 2;
      }
      this.Hff.a(new b()
      {
        public final void bL(int paramAnonymousInt, String paramAnonymousString)
        {
          int i = 2;
          AppMethodBeat.i(64248);
          if (paramAnonymousInt == 0)
          {
            Log.i("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay success");
            WalletFaceIdAuthUI.c.this.Hfg.doSceneProgress(new ae(null, 19), false);
            paramAnonymousString = com.tencent.mm.plugin.report.service.h.OAn;
            paramAnonymousInt = i;
            if (WalletFaceIdAuthUI.c.this.fth() == 1) {
              paramAnonymousInt = 1;
            }
            paramAnonymousString.b(15817, new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.h.OAn.kJ(916, 1);
            AppMethodBeat.o(64248);
            return;
          }
          WalletFaceIdAuthUI.c.this.Hfg.hideProgress();
          Log.e("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay failed");
          WalletFaceIdAuthUI.c.this.Hfg.aDo(WalletFaceIdAuthUI.c.this.Hfg.getString(a.i.faceid_open_fail));
          com.tencent.mm.plugin.report.service.h.OAn.kJ(916, 2);
          AppMethodBeat.o(64248);
        }
      }, paramInt);
    }
    
    protected abstract void fte();
    
    protected abstract void ftf();
    
    protected abstract void ftg();
    
    protected abstract int fth();
    
    protected final void ftk()
    {
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do face id auth");
      com.tencent.mm.plugin.fingerprint.mgr.e locale = (com.tencent.mm.plugin.fingerprint.mgr.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.mgr.e.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("face_auth_scene", 0);
      locale.a(this.Hfg, new a()
      {
        public final void onAuthCancel()
        {
          AppMethodBeat.i(64251);
          WalletFaceIdAuthUI.c.this.Hfg.finish();
          AppMethodBeat.o(64251);
        }
        
        public final void onAuthFail(int paramAnonymousInt)
        {
          AppMethodBeat.i(64250);
          WalletFaceIdAuthUI.c.this.Hfg.aDo(WalletFaceIdAuthUI.c.this.Hfg.getString(a.i.faceid_open_fail));
          AppMethodBeat.o(64250);
        }
        
        public final void onAuthSuccess(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(64249);
          WalletFaceIdAuthUI.c.this.VD(paramAnonymousInt1);
          AppMethodBeat.o(64249);
        }
      }, localBundle);
    }
    
    protected abstract boolean isTransparent();
    
    public void onCreate()
    {
      boolean bool2 = true;
      if (this.Hfe == null)
      {
        Log.w("MicroMsg.WalletFaceIdAuthUI", "no mgr");
        this.Hfg.aDo(this.Hfg.getString(a.i.faceid_open_fail));
        return;
      }
      boolean bool3 = this.Hfe.ftD();
      boolean bool4 = this.Hfe.ftE();
      boolean bool1;
      if (af.lYc.lWo != 1)
      {
        bool1 = true;
        if ((bool3) && (bool4) && (!bool1) && (this.skv != null)) {
          break label162;
        }
        if (this.skv != null) {
          break label157;
        }
      }
      for (;;)
      {
        Log.w("MicroMsg.WalletFaceIdAuthUI", "support: %s, enrolled: %s, forceClose: %s, data: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        this.Hfg.aDo(this.Hfg.getString(a.i.faceid_open_fail));
        return;
        bool1 = false;
        break;
        label157:
        bool2 = false;
      }
      label162:
      this.qgt = this.skv.getString("pwd");
      if (Util.isNullOrNil(this.qgt))
      {
        Log.w("MicroMsg.WalletFaceIdAuthUI", "no pwd");
        this.Hfg.aDo(this.Hfg.getString(a.i.faceid_open_fail));
        return;
      }
      f.jYD().jYE();
      fte();
    }
    
    protected abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI
 * JD-Core Version:    0.7.0.1
 */