package com.tencent.mm.plugin.fingerprint.mgr;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.plugin.fingerprint.mgr.a.i;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public final class g
  implements d
{
  WeakReference<WalletBaseUI> HfY;
  private com.tencent.mm.plugin.fingerprint.c.b HfZ;
  private com.tencent.mm.plugin.fingerprint.c.b Hga;
  private com.tencent.mm.plugin.soter.b Hgb;
  private String qdg;
  
  private void bN(int paramInt, String paramString)
  {
    AppMethodBeat.i(64374);
    if (this.Hga != null) {
      this.Hga.bL(paramInt, paramString);
    }
    AppMethodBeat.o(64374);
  }
  
  private void ftO()
  {
    AppMethodBeat.i(64372);
    this.Hgb.a(new b.d()new com.tencent.mm.plugin.fingerprint.b.c
    {
      public final void a(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64366);
        Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key success");
        if ((g.this.HfY != null) && (g.this.HfY.get() != null))
        {
          ((WalletBaseUI)g.this.HfY.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.b.a(2), false);
          AppMethodBeat.o(64366);
          return;
        }
        g.this.bM(-1, "base ui is null");
        AppMethodBeat.o(64366);
      }
      
      public final void b(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64367);
        if (paramAnonymousc.errCode == 1006)
        {
          Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed upload: model is null or necessary elements null");
          com.tencent.mm.plugin.soter.model.a.f(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
        }
        for (;;)
        {
          g.this.bM(-1, MMApplicationContext.getContext().getString(a.i.biometric_pay_fingerprint_manufacturer_errmsg));
          AppMethodBeat.o(64367);
          return;
          if (paramAnonymousc.errCode == 6)
          {
            com.tencent.mm.plugin.soter.model.a.f(4, -1000223, -1, "gen auth key failed");
            if ((!Util.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.startsWith("java.security.ProviderException")))
            {
              g.this.bM(-2, MMApplicationContext.getContext().getString(a.i.biometric_pay_fingerprint_manufacturer_errmsg2));
              AppMethodBeat.o(64367);
              return;
            }
            if ((com.tencent.soter.core.a.jXR() == 1) && (!Util.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.equals("errmsg not specified")))
            {
              g.this.bM(-2, MMApplicationContext.getContext().getString(a.i.biometric_pay_fingerprint_manufacturer_errmsg3));
              AppMethodBeat.o(64367);
            }
          }
          else if (paramAnonymousc.errCode == 1004)
          {
            Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key failed. remove");
            com.tencent.mm.plugin.soter.model.a.f(5, 4, paramAnonymousc.errCode, "upload auth key failed");
          }
          else if ((paramAnonymousc.errCode == 4) || (paramAnonymousc.errCode == 3))
          {
            Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: gen auth key failed");
            com.tencent.mm.plugin.soter.model.a.f(2, -1000223, -1, "gen ask failed");
          }
          else if (paramAnonymousc.errCode == 1003)
          {
            Log.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo upload ask failed");
            com.tencent.mm.plugin.soter.model.a.f(3, 4, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
          else
          {
            Log.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo unknown error when prepare auth key");
            com.tencent.mm.plugin.soter.model.a.f(1000, -1000223, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
        }
      }
    }, new com.tencent.mm.plugin.fingerprint.b.c(this.qdg, 2));
    AppMethodBeat.o(64372);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.c.b paramb) {}
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.c.b paramb, String paramString)
  {
    AppMethodBeat.i(64368);
    Log.i("MicroMsg.SoterFaceIdOpenDelegate", "do prepare");
    this.HfZ = paramb;
    this.qdg = paramString;
    this.HfY = new WeakReference((WalletBaseUI)paramContext);
    this.Hgb = new com.tencent.mm.plugin.soter.b();
    ((WalletBaseUI)this.HfY.get()).addSceneEndListener(1586);
    ((WalletBaseUI)this.HfY.get()).addSceneEndListener(1638);
    ((i)h.ax(i.class)).s(new Object[0]);
    ftO();
    AppMethodBeat.o(64368);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.c.b paramb, int paramInt)
  {
    AppMethodBeat.i(64371);
    Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: doOpenFP");
    this.Hga = paramb;
    paramb = j.Hgj.Hgn;
    if (paramb != null)
    {
      if ((this.HfY != null) && (this.HfY.get() != null))
      {
        ((WalletBaseUI)this.HfY.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.b.b(paramb.ahxs, paramb.signature, this.qdg, 2));
        AppMethodBeat.o(64371);
      }
    }
    else
    {
      Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: signature is null");
      com.tencent.mm.plugin.soter.model.a.f(9, -1000223, -1, "signature is null");
      bN(-1, MMApplicationContext.getContext().getString(a.i.faceid_open_fail));
    }
    AppMethodBeat.o(64371);
  }
  
  final void bM(int paramInt, String paramString)
  {
    AppMethodBeat.i(64373);
    if (this.HfZ != null) {
      this.HfZ.bL(paramInt, paramString);
    }
    AppMethodBeat.o(64373);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(64369);
    Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: clear");
    if ((this.HfY != null) && (this.HfY.get() != null))
    {
      ((WalletBaseUI)this.HfY.get()).removeSceneEndListener(1586);
      ((WalletBaseUI)this.HfY.get()).removeSceneEndListener(1638);
    }
    j.Hgj.reset();
    if ((this.HfY != null) && (this.HfY.get() != null)) {
      this.HfY.clear();
    }
    AppMethodBeat.o(64369);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(64370);
    Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramp });
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = MMApplicationContext.getContext().getString(a.i.faceid_open_fail);
    }
    if ((paramp instanceof com.tencent.mm.plugin.fingerprint.b.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.SoterFaceIdOpenDelegate", "get challenge success");
        if (Util.isNullOrNil(((com.tencent.mm.plugin.fingerprint.b.a)paramp).Hgd))
        {
          bM(-1, str);
          AppMethodBeat.o(64370);
          return true;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64365);
            g.this.bM(0, "");
            AppMethodBeat.o(64365);
          }
        });
      }
    }
    else
    {
      if (!(paramp instanceof com.tencent.mm.plugin.fingerprint.b.b)) {
        break label226;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label200;
      }
      Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.model.a.htw();
      com.tencent.mm.plugin.soter.model.a.f(0, 0, 0, "OK");
      bN(0, str);
    }
    for (;;)
    {
      AppMethodBeat.o(64370);
      return true;
      Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed get challenge");
      bM(paramInt2, str);
      com.tencent.mm.plugin.soter.model.a.f(7, paramInt1, paramInt2, "get challenge failed");
      AppMethodBeat.o(64370);
      return true;
      label200:
      Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.model.a.f(8, paramInt1, paramInt2, "open fp pay failed");
      bN(-1, str);
    }
    label226:
    AppMethodBeat.o(64370);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.g
 * JD-Core Version:    0.7.0.1
 */