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
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.l;
import com.tencent.mm.plugin.fingerprint.d.b;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(3)
public class WalletFaceIdAuthUI
  extends WalletBaseUI
{
  int mScene;
  Button sjx;
  private c sjy;
  
  public final void aeU(String paramString)
  {
    AppMethodBeat.i(64256);
    com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131755793), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(64231);
        WalletFaceIdAuthUI.a(WalletFaceIdAuthUI.this).cGN();
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
    this.sjx = ((Button)findViewById(2131300105));
    this.sjx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64230);
        WalletFaceIdAuthUI.a(WalletFaceIdAuthUI.this).cGO();
        AppMethodBeat.o(64230);
      }
    });
    AppMethodBeat.o(64253);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(64254);
    boolean bool = this.sjy.isTransparent();
    AppMethodBeat.o(64254);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64252);
    this.mScene = getIntent().getIntExtra("key_scene", 1);
    ac.i("MicroMsg.WalletFaceIdAuthUI", "scene: %s", new Object[] { Integer.valueOf(this.mScene) });
    if (this.mScene == 0) {
      this.sjy = new b(this);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      setMMTitle(2131758812);
      this.sjy.onCreate();
      initView();
      AppMethodBeat.o(64252);
      return;
      if (this.mScene == 1) {
        this.sjy = new a(this);
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
    boolean bool = this.sjy.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
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
      com.tencent.mm.plugin.soter.d.a.Qi(0);
      AppMethodBeat.o(64234);
    }
    
    private void cGQ()
    {
      AppMethodBeat.i(64239);
      ac.i("MicroMsg.WalletFaceIdAuthUI", "do finish");
      this.sjE.finish();
      AppMethodBeat.o(64239);
    }
    
    protected final void cGM()
    {
      AppMethodBeat.i(64236);
      ac.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
      this.sjE.showProgress();
      this.sjD.a(this.sjE, new b()
      {
        public final void aZ(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64232);
          ac.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          WalletFaceIdAuthUI.a.this.sjE.hideProgress();
          if (paramAnonymousInt == 0)
          {
            WalletFaceIdAuthUI.a.this.cGS();
            AppMethodBeat.o(64232);
            return;
          }
          WalletFaceIdAuthUI.a.this.sjE.aeU(WalletFaceIdAuthUI.a.this.sjE.getString(2131756559));
          AppMethodBeat.o(64232);
        }
      }, this.iXf);
      AppMethodBeat.o(64236);
    }
    
    protected final void cGN()
    {
      AppMethodBeat.i(64238);
      cGQ();
      AppMethodBeat.o(64238);
    }
    
    protected final void cGO() {}
    
    protected final int cGP()
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
      this.sjE.getWindow().setDimAmount(0.0F);
      super.onCreate();
      this.sjE.hideTitleView();
      this.sjE.hideActionbarLine();
      this.sjE.setContentViewVisibility(8);
      AppMethodBeat.o(64235);
    }
    
    protected final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(64237);
      if (this.sjD.onSceneEnd(paramInt1, paramInt2, paramString, paramn))
      {
        AppMethodBeat.o(64237);
        return true;
      }
      if ((paramn instanceof ad))
      {
        this.sjE.hideProgress();
        com.tencent.mm.ui.base.h.a(this.sjE, this.sjE.getString(2131758811), this.sjE.getString(2131758810), this.sjE.getString(2131765649), false, new DialogInterface.OnClickListener()
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
      com.tencent.mm.plugin.soter.d.a.Qi(1);
      AppMethodBeat.o(64242);
    }
    
    private void cGR()
    {
      AppMethodBeat.i(64247);
      ac.i("MicroMsg.WalletFaceIdAuthUI", "do end process");
      com.tencent.mm.wallet_core.a.b(this.sjE, new Bundle(), 0);
      AppMethodBeat.o(64247);
    }
    
    protected final void cGM()
    {
      AppMethodBeat.i(64243);
      ac.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
      this.sjE.showProgress();
      this.sjD.a(this.sjE, new b()
      {
        public final void aZ(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64241);
          ac.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          WalletFaceIdAuthUI.b.this.sjE.hideProgress();
          if (paramAnonymousInt == 0)
          {
            WalletFaceIdAuthUI.b.this.sjE.sjx.setEnabled(true);
            AppMethodBeat.o(64241);
            return;
          }
          WalletFaceIdAuthUI.b.this.sjE.aeU(WalletFaceIdAuthUI.b.this.sjE.getString(2131756559));
          AppMethodBeat.o(64241);
        }
      }, this.iXf);
      AppMethodBeat.o(64243);
    }
    
    public final void cGN()
    {
      AppMethodBeat.i(64246);
      cGR();
      AppMethodBeat.o(64246);
    }
    
    public final void cGO()
    {
      AppMethodBeat.i(64245);
      ac.i("MicroMsg.WalletFaceIdAuthUI", "do verify face id");
      cGS();
      AppMethodBeat.o(64245);
    }
    
    protected final int cGP()
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
      if (this.sjD.onSceneEnd(paramInt1, paramInt2, paramString, paramn))
      {
        AppMethodBeat.o(64244);
        return true;
      }
      if ((paramn instanceof ad))
      {
        this.sjE.hideProgress();
        cGR();
        Toast.makeText(this.sjE, 2131759410, 0).show();
        AppMethodBeat.o(64244);
        return true;
      }
      AppMethodBeat.o(64244);
      return false;
    }
  }
  
  public static abstract class c
  {
    protected String iXf;
    protected Bundle kBP;
    protected com.tencent.mm.plugin.fingerprint.d.a sjC;
    protected l sjD;
    protected WalletFaceIdAuthUI sjE;
    
    public c(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
    {
      this.sjE = paramWalletFaceIdAuthUI;
      if (paramWalletFaceIdAuthUI.mScene == 0) {}
      for (paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getProcess().dmf;; paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getIntent().getExtras())
      {
        this.kBP = paramWalletFaceIdAuthUI;
        this.sjD = new l();
        this.sjC = ((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class));
        return;
      }
    }
    
    protected final void Fm(int paramInt)
    {
      paramInt = 1;
      this.sjE.showProgress();
      if (cGP() == 1) {
        paramInt = 2;
      }
      this.sjD.a(new b()
      {
        public final void aZ(int paramAnonymousInt, String paramAnonymousString)
        {
          int i = 2;
          AppMethodBeat.i(64248);
          if (paramAnonymousInt == 0)
          {
            ac.i("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay success");
            WalletFaceIdAuthUI.c.this.sjE.doSceneProgress(new ad(null, 19), false);
            paramAnonymousString = com.tencent.mm.plugin.report.service.h.wUl;
            paramAnonymousInt = i;
            if (WalletFaceIdAuthUI.c.this.cGP() == 1) {
              paramAnonymousInt = 1;
            }
            paramAnonymousString.f(15817, new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.h.wUl.dB(916, 1);
            AppMethodBeat.o(64248);
            return;
          }
          WalletFaceIdAuthUI.c.this.sjE.hideProgress();
          ac.e("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay failed");
          WalletFaceIdAuthUI.c.this.sjE.aeU(WalletFaceIdAuthUI.c.this.sjE.getString(2131758809));
          com.tencent.mm.plugin.report.service.h.wUl.dB(916, 2);
          AppMethodBeat.o(64248);
        }
      }, paramInt);
    }
    
    protected abstract void cGM();
    
    protected abstract void cGN();
    
    protected abstract void cGO();
    
    protected abstract int cGP();
    
    protected final void cGS()
    {
      ac.i("MicroMsg.WalletFaceIdAuthUI", "do face id auth");
      com.tencent.mm.plugin.fingerprint.b.h localh = (com.tencent.mm.plugin.fingerprint.b.h)g.ab(com.tencent.mm.plugin.fingerprint.b.h.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("face_auth_scene", 0);
      localh.a(this.sjE, new a()
      {
        public final void onAuthCancel()
        {
          AppMethodBeat.i(64251);
          WalletFaceIdAuthUI.c.this.sjE.finish();
          AppMethodBeat.o(64251);
        }
        
        public final void onAuthFail(int paramAnonymousInt)
        {
          AppMethodBeat.i(64250);
          WalletFaceIdAuthUI.c.this.sjE.aeU(WalletFaceIdAuthUI.c.this.sjE.getString(2131758809));
          AppMethodBeat.o(64250);
        }
        
        public final void onAuthSuccess(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(64249);
          WalletFaceIdAuthUI.c.this.Fm(paramAnonymousInt1);
          AppMethodBeat.o(64249);
        }
      }, localBundle);
    }
    
    protected abstract boolean isTransparent();
    
    public void onCreate()
    {
      boolean bool2 = true;
      if (this.sjC == null)
      {
        ac.w("MicroMsg.WalletFaceIdAuthUI", "no mgr");
        this.sjE.aeU(this.sjE.getString(2131758809));
        return;
      }
      boolean bool3 = this.sjC.cHm();
      boolean bool4 = this.sjC.cHn();
      boolean bool1;
      if (ae.fJh.fHy != 1)
      {
        bool1 = true;
        if ((bool3) && (bool4) && (!bool1) && (this.kBP != null)) {
          break label160;
        }
        if (this.kBP != null) {
          break label155;
        }
      }
      for (;;)
      {
        ac.w("MicroMsg.WalletFaceIdAuthUI", "support: %s, enrolled: %s, forceClose: %s, data: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        this.sjE.aeU(this.sjE.getString(2131758809));
        return;
        bool1 = false;
        break;
        label155:
        bool2 = false;
      }
      label160:
      this.iXf = this.kBP.getString("pwd");
      if (bs.isNullOrNil(this.iXf))
      {
        ac.w("MicroMsg.WalletFaceIdAuthUI", "no pwd");
        this.sjE.aeU(this.sjE.getString(2131758809));
        return;
      }
      f.fDM().fDN();
      cGM();
    }
    
    protected abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI
 * JD-Core Version:    0.7.0.1
 */