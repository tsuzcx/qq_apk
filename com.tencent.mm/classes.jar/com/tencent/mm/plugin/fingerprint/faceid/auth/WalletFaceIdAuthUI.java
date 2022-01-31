package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.s;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(3)
public class WalletFaceIdAuthUI
  extends WalletBaseUI
{
  int fzn;
  Button kkw;
  private c kkx;
  
  public final void Dg(String paramString)
  {
    h.a(this, paramString, "", false, new WalletFaceIdAuthUI.2(this));
  }
  
  public final boolean aSk()
  {
    return this.kkx.aSk();
  }
  
  protected final boolean aSl()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    return this.kkx.c(paramInt1, paramInt2, paramString, paramm);
  }
  
  protected final int getLayoutId()
  {
    return a.g.faceid_open_ui;
  }
  
  protected final void initView()
  {
    this.kkw = ((Button)findViewById(a.f.fiou_verify_btn));
    this.kkw.setOnClickListener(new WalletFaceIdAuthUI.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.fzn = getIntent().getIntExtra("key_scene", 1);
    y.i("MicroMsg.WalletFaceIdAuthUI", "scene: %s", new Object[] { Integer.valueOf(this.fzn) });
    if (this.fzn == 0) {
      this.kkx = new WalletFaceIdAuthUI.b(this);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      setMMTitle(a.i.faceid_open_title);
      this.kkx.onCreate();
      initView();
      return;
      if (this.fzn == 1) {
        this.kkx = new WalletFaceIdAuthUI.a(this);
      }
    }
  }
  
  public static abstract class c
  {
    protected String frT;
    protected Bundle gxQ;
    protected k kkB;
    protected com.tencent.mm.plugin.fingerprint.b.m kkC;
    protected WalletFaceIdAuthUI kkD;
    
    public c(WalletFaceIdAuthUI paramWalletFaceIdAuthUI)
    {
      this.kkD = paramWalletFaceIdAuthUI;
      if (paramWalletFaceIdAuthUI.fzn == 0) {}
      for (paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.cNj().kke;; paramWalletFaceIdAuthUI = paramWalletFaceIdAuthUI.getIntent().getExtras())
      {
        this.gxQ = paramWalletFaceIdAuthUI;
        this.kkC = new com.tencent.mm.plugin.fingerprint.b.m();
        this.kkB = ((k)g.r(k.class));
        return;
      }
    }
    
    protected abstract boolean aSk();
    
    protected abstract void aSm();
    
    protected abstract void aSn();
    
    protected abstract void aSo();
    
    protected abstract int aSp();
    
    protected final void aSs()
    {
      y.i("MicroMsg.WalletFaceIdAuthUI", "do face id auth");
      i locali = (i)g.r(i.class);
      Bundle localBundle = new Bundle();
      localBundle.putInt("face_auth_scene", 0);
      locali.a(this.kkD, new a()
      {
        public final void aSj()
        {
          WalletFaceIdAuthUI.c.this.kkD.finish();
        }
        
        public final void ri(int paramAnonymousInt)
        {
          WalletFaceIdAuthUI.c.this.rk(paramAnonymousInt);
        }
        
        public final void rj(int paramAnonymousInt)
        {
          WalletFaceIdAuthUI.c.this.kkD.Dg(WalletFaceIdAuthUI.c.this.kkD.getString(a.i.faceid_open_fail));
        }
      }, localBundle);
    }
    
    protected abstract boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm);
    
    public void onCreate()
    {
      boolean bool2 = true;
      if (this.kkB == null)
      {
        y.w("MicroMsg.WalletFaceIdAuthUI", "no mgr");
        this.kkD.Dg(this.kkD.getString(a.i.faceid_open_fail));
        return;
      }
      boolean bool3 = this.kkB.aSS();
      boolean bool4 = this.kkB.aST();
      boolean bool1;
      if (q.dyh.dyq != 1)
      {
        bool1 = true;
        if ((bool3) && (bool4) && (!bool1) && (this.gxQ != null)) {
          break label162;
        }
        if (this.gxQ != null) {
          break label157;
        }
      }
      for (;;)
      {
        y.w("MicroMsg.WalletFaceIdAuthUI", "support: %s, enrolled: %s, forceClose: %s, data: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        this.kkD.Dg(this.kkD.getString(a.i.faceid_open_fail));
        return;
        bool1 = false;
        break;
        label157:
        bool2 = false;
      }
      label162:
      this.frT = this.gxQ.getString("pwd");
      if (bk.bl(this.frT))
      {
        y.w("MicroMsg.WalletFaceIdAuthUI", "no pwd");
        this.kkD.Dg(this.kkD.getString(a.i.faceid_open_fail));
        return;
      }
      f.cPH().cPI();
      aSm();
    }
    
    protected final void rk(int paramInt)
    {
      int i = 1;
      this.kkD.aEg();
      if (aSp() == 1) {
        i = 2;
      }
      this.kkC.a(new WalletFaceIdAuthUI.c.1(this), String.valueOf(paramInt), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI
 * JD-Core Version:    0.7.0.1
 */