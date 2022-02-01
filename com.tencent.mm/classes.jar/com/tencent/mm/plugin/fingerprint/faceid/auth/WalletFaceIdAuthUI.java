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
import com.tencent.mm.ak.n;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.plugin.fingerprint.b.l;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(3)
public class WalletFaceIdAuthUI
  extends WalletBaseUI
{
  int mScene;
  Button tqS;
  private c tqT;
  
  public final void akq(String paramString)
  {
    AppMethodBeat.i(64256);
    com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131755793), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(64231);
        WalletFaceIdAuthUI.a(WalletFaceIdAuthUI.this).cRH();
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
    this.tqS = ((Button)findViewById(2131300105));
    this.tqS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64230);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletFaceIdAuthUI.a(WalletFaceIdAuthUI.this).cRI();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64230);
      }
    });
    AppMethodBeat.o(64253);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(64254);
    boolean bool = this.tqT.isTransparent();
    AppMethodBeat.o(64254);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64252);
    this.mScene = getIntent().getIntExtra("key_scene", 1);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletFaceIdAuthUI", "scene: %s", new Object[] { Integer.valueOf(this.mScene) });
    if (this.mScene == 0) {
      this.tqT = new b(this);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      setMMTitle(2131758812);
      this.tqT.onCreate();
      initView();
      AppMethodBeat.o(64252);
      return;
      if (this.mScene == 1) {
        this.tqT = new a(this);
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
    boolean bool = this.tqT.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
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
      com.tencent.mm.plugin.soter.d.a.Sx(0);
      AppMethodBeat.o(64234);
    }
    
    private void cRK()
    {
      AppMethodBeat.i(64239);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletFaceIdAuthUI", "do finish");
      this.tqZ.finish();
      AppMethodBeat.o(64239);
    }
    
    protected final void cRG()
    {
      AppMethodBeat.i(64236);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
      this.tqZ.showProgress();
      this.tqY.a(this.tqZ, new com.tencent.mm.plugin.fingerprint.d.b()
      {
        public final void bb(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64232);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          WalletFaceIdAuthUI.a.this.tqZ.hideProgress();
          if (paramAnonymousInt == 0)
          {
            WalletFaceIdAuthUI.a.this.cRM();
            AppMethodBeat.o(64232);
            return;
          }
          WalletFaceIdAuthUI.a.this.tqZ.akq(WalletFaceIdAuthUI.a.this.tqZ.getString(2131756559));
          AppMethodBeat.o(64232);
        }
      }, this.jth);
      AppMethodBeat.o(64236);
    }
    
    protected final void cRH()
    {
      AppMethodBeat.i(64238);
      cRK();
      AppMethodBeat.o(64238);
    }
    
    protected final void cRI() {}
    
    protected final int cRJ()
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
      this.tqZ.getWindow().setDimAmount(0.0F);
      super.onCreate();
      this.tqZ.hideTitleView();
      this.tqZ.hideActionbarLine();
      this.tqZ.setContentViewVisibility(8);
      AppMethodBeat.o(64235);
    }
    
    protected final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(64237);
      if (this.tqY.onSceneEnd(paramInt1, paramInt2, paramString, paramn))
      {
        AppMethodBeat.o(64237);
        return true;
      }
      if ((paramn instanceof ad))
      {
        this.tqZ.hideProgress();
        com.tencent.mm.ui.base.h.a(this.tqZ, this.tqZ.getString(2131758811), this.tqZ.getString(2131758810), this.tqZ.getString(2131765649), false, new DialogInterface.OnClickListener()
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
      com.tencent.mm.plugin.soter.d.a.Sx(1);
      AppMethodBeat.o(64242);
    }
    
    private void cRL()
    {
      AppMethodBeat.i(64247);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletFaceIdAuthUI", "do end process");
      com.tencent.mm.wallet_core.a.b(this.tqZ, new Bundle(), 0);
      AppMethodBeat.o(64247);
    }
    
    protected final void cRG()
    {
      AppMethodBeat.i(64243);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
      this.tqZ.showProgress();
      this.tqY.a(this.tqZ, new com.tencent.mm.plugin.fingerprint.d.b()
      {
        public final void bb(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64241);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          WalletFaceIdAuthUI.b.this.tqZ.hideProgress();
          if (paramAnonymousInt == 0)
          {
            WalletFaceIdAuthUI.b.this.tqZ.tqS.setEnabled(true);
            AppMethodBeat.o(64241);
            return;
          }
          WalletFaceIdAuthUI.b.this.tqZ.akq(WalletFaceIdAuthUI.b.this.tqZ.getString(2131756559));
          AppMethodBeat.o(64241);
        }
      }, this.jth);
      AppMethodBeat.o(64243);
    }
    
    public final void cRH()
    {
      AppMethodBeat.i(64246);
      cRL();
      AppMethodBeat.o(64246);
    }
    
    public final void cRI()
    {
      AppMethodBeat.i(64245);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletFaceIdAuthUI", "do verify face id");
      cRM();
      AppMethodBeat.o(64245);
    }
    
    protected final int cRJ()
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
      if (this.tqY.onSceneEnd(paramInt1, paramInt2, paramString, paramn))
      {
        AppMethodBeat.o(64244);
        return true;
      }
      if ((paramn instanceof ad))
      {
        this.tqZ.hideProgress();
        cRL();
        Toast.makeText(this.tqZ, 2131759410, 0).show();
        AppMethodBeat.o(64244);
        return true;
      }
      AppMethodBeat.o(64244);
      return false;
    }
  }
  
  public static abstract class c
  {
    protected String jth;
    protected Bundle lbF;
    protected com.tencent.mm.plugin.fingerprint.d.a tqX;
    protected l tqY;
    protected WalletFaceIdAuthUI tqZ;
    
    public c(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
    {
      this.tqZ = paramWalletFaceIdAuthUI;
      if (paramWalletFaceIdAuthUI.mScene == 0) {}
      for (paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getProcess().dyY;; paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getIntent().getExtras())
      {
        this.lbF = paramWalletFaceIdAuthUI;
        this.tqY = new l();
        this.tqX = ((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
        return;
      }
    }
    
    protected final void GY(int paramInt)
    {
      paramInt = 1;
      this.tqZ.showProgress();
      if (cRJ() == 1) {
        paramInt = 2;
      }
      this.tqY.a(new com.tencent.mm.plugin.fingerprint.d.b()
      {
        public final void bb(int paramAnonymousInt, String paramAnonymousString)
        {
          int i = 2;
          AppMethodBeat.i(64248);
          if (paramAnonymousInt == 0)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay success");
            WalletFaceIdAuthUI.c.this.tqZ.doSceneProgress(new ad(null, 19), false);
            paramAnonymousString = com.tencent.mm.plugin.report.service.g.yxI;
            paramAnonymousInt = i;
            if (WalletFaceIdAuthUI.c.this.cRJ() == 1) {
              paramAnonymousInt = 1;
            }
            paramAnonymousString.f(15817, new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.g.yxI.dD(916, 1);
            AppMethodBeat.o(64248);
            return;
          }
          WalletFaceIdAuthUI.c.this.tqZ.hideProgress();
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay failed");
          WalletFaceIdAuthUI.c.this.tqZ.akq(WalletFaceIdAuthUI.c.this.tqZ.getString(2131758809));
          com.tencent.mm.plugin.report.service.g.yxI.dD(916, 2);
          AppMethodBeat.o(64248);
        }
      }, paramInt);
    }
    
    protected abstract void cRG();
    
    protected abstract void cRH();
    
    protected abstract void cRI();
    
    protected abstract int cRJ();
    
    protected final void cRM()
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WalletFaceIdAuthUI", "do face id auth");
      com.tencent.mm.plugin.fingerprint.b.h localh = (com.tencent.mm.plugin.fingerprint.b.h)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.b.h.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("face_auth_scene", 0);
      localh.a(this.tqZ, new a()
      {
        public final void onAuthCancel()
        {
          AppMethodBeat.i(64251);
          WalletFaceIdAuthUI.c.this.tqZ.finish();
          AppMethodBeat.o(64251);
        }
        
        public final void onAuthFail(int paramAnonymousInt)
        {
          AppMethodBeat.i(64250);
          WalletFaceIdAuthUI.c.this.tqZ.akq(WalletFaceIdAuthUI.c.this.tqZ.getString(2131758809));
          AppMethodBeat.o(64250);
        }
        
        public final void onAuthSuccess(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(64249);
          WalletFaceIdAuthUI.c.this.GY(paramAnonymousInt1);
          AppMethodBeat.o(64249);
        }
      }, localBundle);
    }
    
    protected abstract boolean isTransparent();
    
    public void onCreate()
    {
      boolean bool2 = true;
      if (this.tqX == null)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WalletFaceIdAuthUI", "no mgr");
        this.tqZ.akq(this.tqZ.getString(2131758809));
        return;
      }
      boolean bool3 = this.tqX.cSg();
      boolean bool4 = this.tqX.cSh();
      boolean bool1;
      if (com.tencent.mm.compatible.deviceinfo.ae.geQ.gdg != 1)
      {
        bool1 = true;
        if ((bool3) && (bool4) && (!bool1) && (this.lbF != null)) {
          break label160;
        }
        if (this.lbF != null) {
          break label155;
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WalletFaceIdAuthUI", "support: %s, enrolled: %s, forceClose: %s, data: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        this.tqZ.akq(this.tqZ.getString(2131758809));
        return;
        bool1 = false;
        break;
        label155:
        bool2 = false;
      }
      label160:
      this.jth = this.lbF.getString("pwd");
      if (bu.isNullOrNil(this.jth))
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.WalletFaceIdAuthUI", "no pwd");
        this.tqZ.akq(this.tqZ.getString(2131758809));
        return;
      }
      f.fZD().fZE();
      cRG();
    }
    
    protected abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI
 * JD-Core Version:    0.7.0.1
 */