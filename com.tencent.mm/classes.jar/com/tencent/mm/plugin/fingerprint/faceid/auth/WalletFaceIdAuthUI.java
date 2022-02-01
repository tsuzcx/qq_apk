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
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.l;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(3)
public class WalletFaceIdAuthUI
  extends WalletBaseUI
{
  int mScene;
  private c wEA;
  Button wEz;
  
  public final void axc(String paramString)
  {
    AppMethodBeat.i(64256);
    com.tencent.mm.ui.base.h.a(this, paramString, "", getString(2131755874), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(64231);
        WalletFaceIdAuthUI.a(WalletFaceIdAuthUI.this).dJC();
        AppMethodBeat.o(64231);
      }
    });
    AppMethodBeat.o(64256);
  }
  
  public int getLayoutId()
  {
    return 2131494102;
  }
  
  public void initView()
  {
    AppMethodBeat.i(64253);
    this.wEz = ((Button)findViewById(2131301544));
    this.wEz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64230);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletFaceIdAuthUI.a(WalletFaceIdAuthUI.this).dJD();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64230);
      }
    });
    AppMethodBeat.o(64253);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(64254);
    boolean bool = this.wEA.isTransparent();
    AppMethodBeat.o(64254);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64252);
    this.mScene = getIntent().getIntExtra("key_scene", 1);
    Log.i("MicroMsg.WalletFaceIdAuthUI", "scene: %s", new Object[] { Integer.valueOf(this.mScene) });
    if (this.mScene == 0) {
      this.wEA = new b(this);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      setMMTitle(2131759133);
      this.wEA.onCreate();
      initView();
      AppMethodBeat.o(64252);
      return;
      if (this.mScene == 1) {
        this.wEA = new a(this);
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
    boolean bool = this.wEA.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
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
      com.tencent.mm.plugin.soter.d.a.aat(0);
      AppMethodBeat.o(64234);
    }
    
    private void dJF()
    {
      AppMethodBeat.i(64239);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do finish");
      this.wEG.finish();
      AppMethodBeat.o(64239);
    }
    
    protected final void dJB()
    {
      AppMethodBeat.i(64236);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
      this.wEG.showProgress();
      this.wEF.a(this.wEG, new com.tencent.mm.plugin.fingerprint.d.b()
      {
        public final void bg(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64232);
          Log.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          WalletFaceIdAuthUI.a.this.wEG.hideProgress();
          if (paramAnonymousInt == 0)
          {
            WalletFaceIdAuthUI.a.this.dJH();
            AppMethodBeat.o(64232);
            return;
          }
          WalletFaceIdAuthUI.a.this.wEG.axc(WalletFaceIdAuthUI.a.this.wEG.getString(2131756695));
          AppMethodBeat.o(64232);
        }
      }, this.krw);
      AppMethodBeat.o(64236);
    }
    
    protected final void dJC()
    {
      AppMethodBeat.i(64238);
      dJF();
      AppMethodBeat.o(64238);
    }
    
    protected final void dJD() {}
    
    protected final int dJE()
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
      this.wEG.getWindow().setDimAmount(0.0F);
      super.onCreate();
      this.wEG.hideTitleView();
      this.wEG.hideActionbarLine();
      this.wEG.setContentViewVisibility(8);
      AppMethodBeat.o(64235);
    }
    
    protected final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(64237);
      if (this.wEF.onSceneEnd(paramInt1, paramInt2, paramString, paramq))
      {
        AppMethodBeat.o(64237);
        return true;
      }
      if ((paramq instanceof ad))
      {
        this.wEG.hideProgress();
        com.tencent.mm.ui.base.h.a(this.wEG, this.wEG.getString(2131759132), this.wEG.getString(2131759131), this.wEG.getString(2131768102), false, new DialogInterface.OnClickListener()
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
      com.tencent.mm.plugin.soter.d.a.aat(1);
      AppMethodBeat.o(64242);
    }
    
    private void dJG()
    {
      AppMethodBeat.i(64247);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do end process");
      com.tencent.mm.wallet_core.a.c(this.wEG, new Bundle(), 0);
      AppMethodBeat.o(64247);
    }
    
    protected final void dJB()
    {
      AppMethodBeat.i(64243);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
      this.wEG.showProgress();
      this.wEF.a(this.wEG, new com.tencent.mm.plugin.fingerprint.d.b()
      {
        public final void bg(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64241);
          Log.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          WalletFaceIdAuthUI.b.this.wEG.hideProgress();
          if (paramAnonymousInt == 0)
          {
            WalletFaceIdAuthUI.b.this.wEG.wEz.setEnabled(true);
            AppMethodBeat.o(64241);
            return;
          }
          WalletFaceIdAuthUI.b.this.wEG.axc(WalletFaceIdAuthUI.b.this.wEG.getString(2131756695));
          AppMethodBeat.o(64241);
        }
      }, this.krw);
      AppMethodBeat.o(64243);
    }
    
    public final void dJC()
    {
      AppMethodBeat.i(64246);
      dJG();
      AppMethodBeat.o(64246);
    }
    
    public final void dJD()
    {
      AppMethodBeat.i(64245);
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do verify face id");
      dJH();
      AppMethodBeat.o(64245);
    }
    
    protected final int dJE()
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
      if (this.wEF.onSceneEnd(paramInt1, paramInt2, paramString, paramq))
      {
        AppMethodBeat.o(64244);
        return true;
      }
      if ((paramq instanceof ad))
      {
        this.wEG.hideProgress();
        dJG();
        Toast.makeText(this.wEG, 2131760698, 0).show();
        AppMethodBeat.o(64244);
        return true;
      }
      AppMethodBeat.o(64244);
      return false;
    }
  }
  
  public static abstract class c
  {
    protected String krw;
    protected Bundle mgW;
    protected com.tencent.mm.plugin.fingerprint.d.a wEE;
    protected l wEF;
    protected WalletFaceIdAuthUI wEG;
    
    public c(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
    {
      this.wEG = paramWalletFaceIdAuthUI;
      if (paramWalletFaceIdAuthUI.mScene == 0) {}
      for (paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getProcess().dQL;; paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getIntent().getExtras())
      {
        this.mgW = paramWalletFaceIdAuthUI;
        this.wEF = new l();
        this.wEE = ((com.tencent.mm.plugin.fingerprint.d.a)g.af(com.tencent.mm.plugin.fingerprint.d.a.class));
        return;
      }
    }
    
    protected final void MN(int paramInt)
    {
      paramInt = 1;
      this.wEG.showProgress();
      if (dJE() == 1) {
        paramInt = 2;
      }
      this.wEF.a(new com.tencent.mm.plugin.fingerprint.d.b()
      {
        public final void bg(int paramAnonymousInt, String paramAnonymousString)
        {
          int i = 2;
          AppMethodBeat.i(64248);
          if (paramAnonymousInt == 0)
          {
            Log.i("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay success");
            WalletFaceIdAuthUI.c.this.wEG.doSceneProgress(new ad(null, 19), false);
            paramAnonymousString = com.tencent.mm.plugin.report.service.h.CyF;
            paramAnonymousInt = i;
            if (WalletFaceIdAuthUI.c.this.dJE() == 1) {
              paramAnonymousInt = 1;
            }
            paramAnonymousString.a(15817, new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.h.CyF.dN(916, 1);
            AppMethodBeat.o(64248);
            return;
          }
          WalletFaceIdAuthUI.c.this.wEG.hideProgress();
          Log.e("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay failed");
          WalletFaceIdAuthUI.c.this.wEG.axc(WalletFaceIdAuthUI.c.this.wEG.getString(2131759130));
          com.tencent.mm.plugin.report.service.h.CyF.dN(916, 2);
          AppMethodBeat.o(64248);
        }
      }, paramInt);
    }
    
    protected abstract void dJB();
    
    protected abstract void dJC();
    
    protected abstract void dJD();
    
    protected abstract int dJE();
    
    protected final void dJH()
    {
      Log.i("MicroMsg.WalletFaceIdAuthUI", "do face id auth");
      com.tencent.mm.plugin.fingerprint.b.h localh = (com.tencent.mm.plugin.fingerprint.b.h)g.af(com.tencent.mm.plugin.fingerprint.b.h.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("face_auth_scene", 0);
      localh.a(this.wEG, new a()
      {
        public final void onAuthCancel()
        {
          AppMethodBeat.i(64251);
          WalletFaceIdAuthUI.c.this.wEG.finish();
          AppMethodBeat.o(64251);
        }
        
        public final void onAuthFail(int paramAnonymousInt)
        {
          AppMethodBeat.i(64250);
          WalletFaceIdAuthUI.c.this.wEG.axc(WalletFaceIdAuthUI.c.this.wEG.getString(2131759130));
          AppMethodBeat.o(64250);
        }
        
        public final void onAuthSuccess(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(64249);
          WalletFaceIdAuthUI.c.this.MN(paramAnonymousInt1);
          AppMethodBeat.o(64249);
        }
      }, localBundle);
    }
    
    protected abstract boolean isTransparent();
    
    public void onCreate()
    {
      boolean bool2 = true;
      if (this.wEE == null)
      {
        Log.w("MicroMsg.WalletFaceIdAuthUI", "no mgr");
        this.wEG.axc(this.wEG.getString(2131759130));
        return;
      }
      boolean bool3 = this.wEE.dKb();
      boolean bool4 = this.wEE.dKc();
      boolean bool1;
      if (ae.gKx.gIE != 1)
      {
        bool1 = true;
        if ((bool3) && (bool4) && (!bool1) && (this.mgW != null)) {
          break label160;
        }
        if (this.mgW != null) {
          break label155;
        }
      }
      for (;;)
      {
        Log.w("MicroMsg.WalletFaceIdAuthUI", "support: %s, enrolled: %s, forceClose: %s, data: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        this.wEG.axc(this.wEG.getString(2131759130));
        return;
        bool1 = false;
        break;
        label155:
        bool2 = false;
      }
      label160:
      this.krw = this.mgW.getString("pwd");
      if (Util.isNullOrNil(this.krw))
      {
        Log.w("MicroMsg.WalletFaceIdAuthUI", "no pwd");
        this.wEG.axc(this.wEG.getString(2131759130));
        return;
      }
      f.hlO().hlP();
      dJB();
    }
    
    protected abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI
 * JD-Core Version:    0.7.0.1
 */