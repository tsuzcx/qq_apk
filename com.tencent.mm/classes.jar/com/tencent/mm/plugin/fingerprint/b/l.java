package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.soter.b.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.core.c.j;
import java.lang.ref.WeakReference;

public final class l
  implements d
{
  WeakReference<WalletBaseUI> Byw;
  private com.tencent.mm.plugin.fingerprint.d.b Byx;
  private com.tencent.mm.plugin.fingerprint.d.b Byy;
  private com.tencent.mm.plugin.soter.b Byz;
  private String nfX;
  
  private void bj(int paramInt, String paramString)
  {
    AppMethodBeat.i(64374);
    if (this.Byy != null) {
      this.Byy.bh(paramInt, paramString);
    }
    AppMethodBeat.o(64374);
  }
  
  private void eoL()
  {
    AppMethodBeat.i(64372);
    this.Byz.a(new b.c()new com.tencent.mm.plugin.fingerprint.c.c
    {
      public final void a(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64366);
        Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key success");
        if ((l.this.Byw != null) && (l.this.Byw.get() != null))
        {
          ((WalletBaseUI)l.this.Byw.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.a(2), false);
          AppMethodBeat.o(64366);
          return;
        }
        l.this.bi(-1, "base ui is null");
        AppMethodBeat.o(64366);
      }
      
      public final void b(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64367);
        if (paramAnonymousc.errCode == 1006)
        {
          Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed upload: model is null or necessary elements null");
          com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
        }
        for (;;)
        {
          l.this.bi(-1, MMApplicationContext.getContext().getString(a.i.biometric_pay_fingerprint_manufacturer_errmsg));
          AppMethodBeat.o(64367);
          return;
          if (paramAnonymousc.errCode == 6)
          {
            com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed");
            if ((!Util.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.startsWith("java.security.ProviderException")))
            {
              l.this.bi(-2, MMApplicationContext.getContext().getString(a.i.biometric_pay_fingerprint_manufacturer_errmsg2));
              AppMethodBeat.o(64367);
              return;
            }
            if ((com.tencent.soter.core.a.ioE() == 1) && (!Util.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.equals("errmsg not specified")))
            {
              l.this.bi(-2, MMApplicationContext.getContext().getString(a.i.biometric_pay_fingerprint_manufacturer_errmsg3));
              AppMethodBeat.o(64367);
            }
          }
          else if (paramAnonymousc.errCode == 1004)
          {
            Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: update pay auth key failed. remove");
            com.tencent.mm.plugin.soter.d.a.d(5, 4, paramAnonymousc.errCode, "upload auth key failed");
          }
          else if ((paramAnonymousc.errCode == 4) || (paramAnonymousc.errCode == 3))
          {
            Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: gen auth key failed");
            com.tencent.mm.plugin.soter.d.a.d(2, -1000223, -1, "gen ask failed");
          }
          else if (paramAnonymousc.errCode == 1003)
          {
            Log.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo upload ask failed");
            com.tencent.mm.plugin.soter.d.a.d(3, 4, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
          else
          {
            Log.e("MicroMsg.SoterFaceIdOpenDelegate", "alvinluo unknown error when prepare auth key");
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
        }
      }
    }, new com.tencent.mm.plugin.fingerprint.c.c(this.nfX, 2));
    AppMethodBeat.o(64372);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb) {}
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb, String paramString)
  {
    AppMethodBeat.i(64368);
    Log.i("MicroMsg.SoterFaceIdOpenDelegate", "do prepare");
    this.Byx = paramb;
    this.nfX = paramString;
    this.Byw = new WeakReference((WalletBaseUI)paramContext);
    this.Byz = new com.tencent.mm.plugin.soter.b();
    ((WalletBaseUI)this.Byw.get()).addSceneEndListener(1586);
    ((WalletBaseUI)this.Byw.get()).addSceneEndListener(1638);
    ((i)h.ae(i.class)).q(new Object[0]);
    eoL();
    AppMethodBeat.o(64368);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64371);
    Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: doOpenFP");
    this.Byy = paramb;
    paramb = p.ByH.ByL;
    if (paramb != null)
    {
      if ((this.Byw != null) && (this.Byw.get() != null))
      {
        ((WalletBaseUI)this.Byw.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.b(paramb.ZsE, paramb.signature, this.nfX, 2));
        AppMethodBeat.o(64371);
      }
    }
    else
    {
      Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: signature is null");
      com.tencent.mm.plugin.soter.d.a.d(9, -1000223, -1, "signature is null");
      bj(-1, MMApplicationContext.getContext().getString(a.i.faceid_open_fail));
    }
    AppMethodBeat.o(64371);
  }
  
  final void bi(int paramInt, String paramString)
  {
    AppMethodBeat.i(64373);
    if (this.Byx != null) {
      this.Byx.bh(paramInt, paramString);
    }
    AppMethodBeat.o(64373);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(64369);
    Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: clear");
    if ((this.Byw != null) && (this.Byw.get() != null))
    {
      ((WalletBaseUI)this.Byw.get()).removeSceneEndListener(1586);
      ((WalletBaseUI)this.Byw.get()).removeSceneEndListener(1638);
    }
    p.ByH.reset();
    if ((this.Byw != null) && (this.Byw.get() != null)) {
      this.Byw.clear();
    }
    AppMethodBeat.o(64369);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64370);
    Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s, scene: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, paramq });
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = MMApplicationContext.getContext().getString(a.i.faceid_open_fail);
    }
    if ((paramq instanceof com.tencent.mm.plugin.fingerprint.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.SoterFaceIdOpenDelegate", "get challenge success");
        if (Util.isNullOrNil(((com.tencent.mm.plugin.fingerprint.c.a)paramq).ByB))
        {
          bi(-1, str);
          AppMethodBeat.o(64370);
          return true;
        }
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64365);
            l.this.bi(0, "");
            AppMethodBeat.o(64365);
          }
        });
      }
    }
    else
    {
      if (!(paramq instanceof com.tencent.mm.plugin.fingerprint.c.b)) {
        break label226;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label200;
      }
      Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.d.a.gaf();
      com.tencent.mm.plugin.soter.d.a.d(0, 0, 0, "OK");
      bj(0, str);
    }
    for (;;)
    {
      AppMethodBeat.o(64370);
      return true;
      Log.e("MicroMsg.SoterFaceIdOpenDelegate", "hy: failed get challenge");
      bi(paramInt2, str);
      com.tencent.mm.plugin.soter.d.a.d(7, paramInt1, paramInt2, "get challenge failed");
      AppMethodBeat.o(64370);
      return true;
      label200:
      Log.i("MicroMsg.SoterFaceIdOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.d.a.d(8, paramInt1, paramInt2, "open fp pay failed");
      bj(-1, str);
    }
    label226:
    AppMethodBeat.o(64370);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.l
 * JD-Core Version:    0.7.0.1
 */