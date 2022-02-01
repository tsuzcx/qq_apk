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
import com.tencent.mm.al.n;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.plugin.fingerprint.b.l;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(3)
public class WalletFaceIdAuthUI
  extends WalletBaseUI
{
  int mScene;
  Button tfZ;
  private c tga;
  
  public final void ajs(String paramString)
  {
    AppMethodBeat.i(64256);
    com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131755793), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(64231);
        WalletFaceIdAuthUI.a(WalletFaceIdAuthUI.this).cPc();
        AppMethodBeat.o(64231);
      }
    });
    AppMethodBeat.o(64256);
  }
  
  public int getLayoutId()
  {
    return 2131493934;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64253);
    this.tfZ = ((Button)findViewById(2131300105));
    this.tfZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64230);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletFaceIdAuthUI.a(WalletFaceIdAuthUI.this).cPd();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64230);
      }
    });
    AppMethodBeat.o(64253);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(64254);
    boolean bool = this.tga.isTransparent();
    AppMethodBeat.o(64254);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64252);
    this.mScene = getIntent().getIntExtra("key_scene", 1);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletFaceIdAuthUI", "scene: %s", new Object[] { Integer.valueOf(this.mScene) });
    if (this.mScene == 0) {
      this.tga = new b(this);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      setMMTitle(2131758812);
      this.tga.onCreate();
      initView();
      AppMethodBeat.o(64252);
      return;
      if (this.mScene == 1) {
        this.tga = new a(this);
      }
    }
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64255);
    boolean bool = this.tga.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
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
      com.tencent.mm.plugin.soter.d.a.RQ(0);
      AppMethodBeat.o(64234);
    }
    
    private void cPf()
    {
      AppMethodBeat.i(64239);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletFaceIdAuthUI", "do finish");
      this.tgg.finish();
      AppMethodBeat.o(64239);
    }
    
    protected final void cPb()
    {
      AppMethodBeat.i(64236);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
      this.tgg.showProgress();
      this.tgf.a(this.tgg, new com.tencent.mm.plugin.fingerprint.d.b()
      {
        public final void bc(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64232);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          WalletFaceIdAuthUI.a.this.tgg.hideProgress();
          if (paramAnonymousInt == 0)
          {
            WalletFaceIdAuthUI.a.this.cPh();
            AppMethodBeat.o(64232);
            return;
          }
          WalletFaceIdAuthUI.a.this.tgg.ajs(WalletFaceIdAuthUI.a.this.tgg.getString(2131756559));
          AppMethodBeat.o(64232);
        }
      }, this.jqo);
      AppMethodBeat.o(64236);
    }
    
    protected final void cPc()
    {
      AppMethodBeat.i(64238);
      cPf();
      AppMethodBeat.o(64238);
    }
    
    protected final void cPd() {}
    
    protected final int cPe()
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
      this.tgg.getWindow().setDimAmount(0.0F);
      super.onCreate();
      this.tgg.hideTitleView();
      this.tgg.hideActionbarLine();
      this.tgg.setContentViewVisibility(8);
      AppMethodBeat.o(64235);
    }
    
    protected final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(64237);
      if (this.tgf.onSceneEnd(paramInt1, paramInt2, paramString, paramn))
      {
        AppMethodBeat.o(64237);
        return true;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
      {
        this.tgg.hideProgress();
        com.tencent.mm.ui.base.h.a(this.tgg, this.tgg.getString(2131758811), this.tgg.getString(2131758810), this.tgg.getString(2131765649), false, new DialogInterface.OnClickListener()
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
      com.tencent.mm.plugin.soter.d.a.RQ(1);
      AppMethodBeat.o(64242);
    }
    
    private void cPg()
    {
      AppMethodBeat.i(64247);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletFaceIdAuthUI", "do end process");
      com.tencent.mm.wallet_core.a.b(this.tgg, new Bundle(), 0);
      AppMethodBeat.o(64247);
    }
    
    protected final void cPb()
    {
      AppMethodBeat.i(64243);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
      this.tgg.showProgress();
      this.tgf.a(this.tgg, new com.tencent.mm.plugin.fingerprint.d.b()
      {
        public final void bc(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64241);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          WalletFaceIdAuthUI.b.this.tgg.hideProgress();
          if (paramAnonymousInt == 0)
          {
            WalletFaceIdAuthUI.b.this.tgg.tfZ.setEnabled(true);
            AppMethodBeat.o(64241);
            return;
          }
          WalletFaceIdAuthUI.b.this.tgg.ajs(WalletFaceIdAuthUI.b.this.tgg.getString(2131756559));
          AppMethodBeat.o(64241);
        }
      }, this.jqo);
      AppMethodBeat.o(64243);
    }
    
    public final void cPc()
    {
      AppMethodBeat.i(64246);
      cPg();
      AppMethodBeat.o(64246);
    }
    
    public final void cPd()
    {
      AppMethodBeat.i(64245);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletFaceIdAuthUI", "do verify face id");
      cPh();
      AppMethodBeat.o(64245);
    }
    
    protected final int cPe()
    {
      return 0;
    }
    
    protected final boolean isTransparent()
    {
      return false;
    }
    
    public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(64244);
      if (this.tgf.onSceneEnd(paramInt1, paramInt2, paramString, paramn))
      {
        AppMethodBeat.o(64244);
        return true;
      }
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
      {
        this.tgg.hideProgress();
        cPg();
        Toast.makeText(this.tgg, 2131759410, 0).show();
        AppMethodBeat.o(64244);
        return true;
      }
      AppMethodBeat.o(64244);
      return false;
    }
  }
  
  public static abstract class c
  {
    protected String jqo;
    protected Bundle kXW;
    protected com.tencent.mm.plugin.fingerprint.d.a tge;
    protected l tgf;
    protected WalletFaceIdAuthUI tgg;
    
    public c(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
    {
      this.tgg = paramWalletFaceIdAuthUI;
      if (paramWalletFaceIdAuthUI.mScene == 0) {}
      for (paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getProcess().dxT;; paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getIntent().getExtras())
      {
        this.kXW = paramWalletFaceIdAuthUI;
        this.tgf = new l();
        this.tge = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
        return;
      }
    }
    
    protected final void GB(int paramInt)
    {
      paramInt = 1;
      this.tgg.showProgress();
      if (cPe() == 1) {
        paramInt = 2;
      }
      this.tgf.a(new com.tencent.mm.plugin.fingerprint.d.b()
      {
        public final void bc(int paramAnonymousInt, String paramAnonymousString)
        {
          int i = 2;
          AppMethodBeat.i(64248);
          if (paramAnonymousInt == 0)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay success");
            WalletFaceIdAuthUI.c.this.tgg.doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.ad(null, 19), false);
            paramAnonymousString = com.tencent.mm.plugin.report.service.g.yhR;
            paramAnonymousInt = i;
            if (WalletFaceIdAuthUI.c.this.cPe() == 1) {
              paramAnonymousInt = 1;
            }
            paramAnonymousString.f(15817, new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.g.yhR.dD(916, 1);
            AppMethodBeat.o(64248);
            return;
          }
          WalletFaceIdAuthUI.c.this.tgg.hideProgress();
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay failed");
          WalletFaceIdAuthUI.c.this.tgg.ajs(WalletFaceIdAuthUI.c.this.tgg.getString(2131758809));
          com.tencent.mm.plugin.report.service.g.yhR.dD(916, 2);
          AppMethodBeat.o(64248);
        }
      }, paramInt);
    }
    
    protected abstract void cPb();
    
    protected abstract void cPc();
    
    protected abstract void cPd();
    
    protected abstract int cPe();
    
    protected final void cPh()
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletFaceIdAuthUI", "do face id auth");
      com.tencent.mm.plugin.fingerprint.b.h localh = (com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.h.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("face_auth_scene", 0);
      localh.a(this.tgg, new a()
      {
        public final void onAuthCancel()
        {
          AppMethodBeat.i(64251);
          WalletFaceIdAuthUI.c.this.tgg.finish();
          AppMethodBeat.o(64251);
        }
        
        public final void onAuthFail(int paramAnonymousInt)
        {
          AppMethodBeat.i(64250);
          WalletFaceIdAuthUI.c.this.tgg.ajs(WalletFaceIdAuthUI.c.this.tgg.getString(2131758809));
          AppMethodBeat.o(64250);
        }
        
        public final void onAuthSuccess(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(64249);
          WalletFaceIdAuthUI.c.this.GB(paramAnonymousInt1);
          AppMethodBeat.o(64249);
        }
      }, localBundle);
    }
    
    protected abstract boolean isTransparent();
    
    public void onCreate()
    {
      boolean bool2 = true;
      if (this.tge == null)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletFaceIdAuthUI", "no mgr");
        this.tgg.ajs(this.tgg.getString(2131758809));
        return;
      }
      boolean bool3 = this.tge.cPB();
      boolean bool4 = this.tge.cPC();
      boolean bool1;
      if (ae.gcI.gaY != 1)
      {
        bool1 = true;
        if ((bool3) && (bool4) && (!bool1) && (this.kXW != null)) {
          break label160;
        }
        if (this.kXW != null) {
          break label155;
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletFaceIdAuthUI", "support: %s, enrolled: %s, forceClose: %s, data: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        this.tgg.ajs(this.tgg.getString(2131758809));
        return;
        bool1 = false;
        break;
        label155:
        bool2 = false;
      }
      label160:
      this.jqo = this.kXW.getString("pwd");
      if (bt.isNullOrNil(this.jqo))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.WalletFaceIdAuthUI", "no pwd");
        this.tgg.ajs(this.tgg.getString(2131758809));
        return;
      }
      f.fVe().fVf();
      cPb();
    }
    
    protected abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI
 * JD-Core Version:    0.7.0.1
 */