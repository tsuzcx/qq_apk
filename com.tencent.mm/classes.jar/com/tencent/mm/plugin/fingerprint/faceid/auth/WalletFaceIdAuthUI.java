package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(3)
public class WalletFaceIdAuthUI
  extends WalletBaseUI
{
  Button mFl;
  private c mFm;
  int mScene;
  
  public final void Oj(String paramString)
  {
    AppMethodBeat.i(41392);
    h.a(this, paramString, "", getString(2131296977), false, new WalletFaceIdAuthUI.2(this));
    AppMethodBeat.o(41392);
  }
  
  public int getLayoutId()
  {
    return 2130969521;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41389);
    this.mFl = ((Button)findViewById(2131823978));
    this.mFl.setOnClickListener(new WalletFaceIdAuthUI.1(this));
    AppMethodBeat.o(41389);
  }
  
  public boolean isTransparent()
  {
    AppMethodBeat.i(41390);
    boolean bool = this.mFm.isTransparent();
    AppMethodBeat.o(41390);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41388);
    this.mScene = getIntent().getIntExtra("key_scene", 1);
    ab.i("MicroMsg.WalletFaceIdAuthUI", "scene: %s", new Object[] { Integer.valueOf(this.mScene) });
    if (this.mScene == 0) {
      this.mFm = new WalletFaceIdAuthUI.b(this);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      setMMTitle(2131299653);
      this.mFm.onCreate();
      initView();
      AppMethodBeat.o(41388);
      return;
      if (this.mScene == 1) {
        this.mFm = new WalletFaceIdAuthUI.a(this);
      }
    }
  }
  
  public boolean onProgressFinish()
  {
    return true;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(41391);
    boolean bool = this.mFm.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
    AppMethodBeat.o(41391);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract class c
  {
    protected String gJv;
    protected Bundle hUq;
    protected l mFq;
    protected com.tencent.mm.plugin.fingerprint.b.m mFr;
    protected WalletFaceIdAuthUI mFs;
    
    public c(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
    {
      this.mFs = paramWalletFaceIdAuthUI;
      if (paramWalletFaceIdAuthUI.mScene == 0) {}
      for (paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getProcess().mEJ;; paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getIntent().getExtras())
      {
        this.hUq = paramWalletFaceIdAuthUI;
        this.mFr = new com.tencent.mm.plugin.fingerprint.b.m();
        this.mFq = ((l)g.E(l.class));
        return;
      }
    }
    
    protected abstract void byF();
    
    protected abstract void byG();
    
    protected abstract void byH();
    
    protected abstract int byI();
    
    protected final void byL()
    {
      ab.i("MicroMsg.WalletFaceIdAuthUI", "do face id auth");
      i locali = (i)g.E(i.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("face_auth_scene", 0);
      locali.a(this.mFs, new a()
      {
        public final void onAuthCancel()
        {
          AppMethodBeat.i(41387);
          WalletFaceIdAuthUI.c.this.mFs.finish();
          AppMethodBeat.o(41387);
        }
        
        public final void onAuthFail(int paramAnonymousInt)
        {
          AppMethodBeat.i(41386);
          WalletFaceIdAuthUI.c.this.mFs.Oj(WalletFaceIdAuthUI.c.this.mFs.getString(2131299650));
          AppMethodBeat.o(41386);
        }
        
        public final void onAuthSuccess(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(41385);
          WalletFaceIdAuthUI.c.this.we(paramAnonymousInt1);
          AppMethodBeat.o(41385);
        }
      }, localBundle);
    }
    
    protected abstract boolean isTransparent();
    
    public void onCreate()
    {
      boolean bool2 = true;
      if (this.mFq == null)
      {
        ab.w("MicroMsg.WalletFaceIdAuthUI", "no mgr");
        this.mFs.Oj(this.mFs.getString(2131299650));
        return;
      }
      boolean bool3 = this.mFq.bzn();
      boolean bool4 = this.mFq.bzo();
      boolean bool1;
      if (ac.ery.eqB != 1)
      {
        bool1 = true;
        if ((bool3) && (bool4) && (!bool1) && (this.hUq != null)) {
          break label160;
        }
        if (this.hUq != null) {
          break label155;
        }
      }
      for (;;)
      {
        ab.w("MicroMsg.WalletFaceIdAuthUI", "support: %s, enrolled: %s, forceClose: %s, data: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        this.mFs.Oj(this.mFs.getString(2131299650));
        return;
        bool1 = false;
        break;
        label155:
        bool2 = false;
      }
      label160:
      this.gJv = this.hUq.getString("pwd");
      if (bo.isNullOrNil(this.gJv))
      {
        ab.w("MicroMsg.WalletFaceIdAuthUI", "no pwd");
        this.mFs.Oj(this.mFs.getString(2131299650));
        return;
      }
      f.dVD().dVE();
      byF();
    }
    
    protected abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm);
    
    protected final void we(int paramInt)
    {
      int i = 1;
      this.mFs.showProgress();
      if (byI() == 1) {
        i = 2;
      }
      this.mFr.a(new WalletFaceIdAuthUI.c.1(this), String.valueOf(paramInt), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI
 * JD-Core Version:    0.7.0.1
 */