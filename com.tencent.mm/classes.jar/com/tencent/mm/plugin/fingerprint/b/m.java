package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public final class m
  implements d
{
  int dNP;
  private String kof = "";
  private com.tencent.mm.plugin.soter.a wFC;
  private String wFE;
  String wFF;
  String wFG;
  private com.tencent.mm.plugin.fingerprint.d.b wFm = null;
  private com.tencent.mm.plugin.fingerprint.d.b wFn = null;
  WeakReference<WalletBaseUI> wFz = null;
  
  private void bk(int paramInt, String paramString)
  {
    AppMethodBeat.i(64384);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
    clear();
    this.wFn.bg(paramInt, paramString);
    this.wFn = null;
    AppMethodBeat.o(64384);
  }
  
  public final void a(Context paramContext, final com.tencent.mm.plugin.fingerprint.d.b paramb)
  {
    AppMethodBeat.i(64381);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "request authentication");
    if (Util.isNullOrNil(this.wFE))
    {
      Log.w("MicroMsg.SoterFingerprintOpenDelegate", "no challenge!!");
      AppMethodBeat.o(64381);
      return;
    }
    h.CyF.dN(1104, 41);
    ((i)g.af(i.class)).a(paramContext, new f(this.wFE), new com.tencent.mm.plugin.fingerprint.b.a.b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64375);
        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "authentication result: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
        Object localObject = "";
        switch (paramAnonymousc.errCode)
        {
        default: 
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
        }
        for (;;)
        {
          paramb.bg(-2, paramAnonymousc);
          AppMethodBeat.o(64375);
          return;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "identify success");
          m.this.dNP = paramAnonymousc.dNP;
          m.this.wFF = paramAnonymousc.wFF;
          m.this.wFG = paramAnonymousc.wFG;
          h.CyF.dN(1104, 40);
          paramb.bg(0, "");
          AppMethodBeat.o(64375);
          return;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
          paramb.bg(-1, "");
          AppMethodBeat.o(64375);
          return;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "identify timeout");
          AppMethodBeat.o(64375);
          return;
          localObject = MMApplicationContext.getContext().getString(2131766339);
          com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
          h.CyF.dN(1104, 39);
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
          continue;
          Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
          String str = MMApplicationContext.getContext().getString(2131766337);
          if (paramAnonymousc.errCode == 10308)
          {
            paramAnonymousc = MMApplicationContext.getContext().getString(2131766338);
            com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
          }
          else
          {
            localObject = str;
            if (Build.VERSION.SDK_INT == 27)
            {
              localObject = str;
              if ("Xiaomi".equals(Build.MANUFACTURER)) {
                localObject = MMApplicationContext.getContext().getString(2131756697);
              }
            }
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
            h.CyF.dN(1104, 39);
            paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
            continue;
            Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
            localObject = MMApplicationContext.getContext().getString(2131766337);
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
            com.tencent.mm.plugin.soter.d.a.aaw(2);
            paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
          }
        }
      }
    });
    AppMethodBeat.o(64381);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fingerprint.d.b paramb, String paramString)
  {
    AppMethodBeat.i(64379);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
    this.wFC = new com.tencent.mm.plugin.soter.a();
    this.wFz = new WeakReference((WalletBaseUI)paramContext);
    this.wFm = paramb;
    this.kof = paramString;
    ((WalletBaseUI)this.wFz.get()).addSceneEndListener(1586);
    ((WalletBaseUI)this.wFz.get()).addSceneEndListener(1638);
    com.tencent.mm.plugin.soter.d.a.flI();
    ((i)g.af(i.class)).q(new Object[0]);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
    h.CyF.dN(1104, 35);
    this.wFC.a(new a.c()new com.tencent.mm.plugin.fingerprint.c.c
    {
      public final void a(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64376);
        if ((m.this.wFz != null) && (m.this.wFz.get() != null))
        {
          ((WalletBaseUI)m.this.wFz.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.a(1), false);
          AppMethodBeat.o(64376);
          return;
        }
        m.this.bj(-1, "base ui is null");
        AppMethodBeat.o(64376);
      }
      
      public final void b(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64377);
        if (paramAnonymousc.errCode == 1006)
        {
          Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
          com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
        }
        for (;;)
        {
          h.CyF.dN(1104, 34);
          m.this.bj(-1, MMApplicationContext.getContext().getString(2131756697));
          AppMethodBeat.o(64377);
          return;
          if (paramAnonymousc.errCode == 6)
          {
            com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed");
            if ((!Util.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.startsWith("java.security.ProviderException")))
            {
              m.this.bj(-2, MMApplicationContext.getContext().getString(2131756698));
              AppMethodBeat.o(64377);
              return;
            }
            if ((com.tencent.soter.core.a.hlf() == 1) && (!Util.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.equals("errmsg not specified")))
            {
              m.this.bj(-2, MMApplicationContext.getContext().getString(2131756699));
              AppMethodBeat.o(64377);
            }
          }
          else if (paramAnonymousc.errCode == 1004)
          {
            Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove");
            com.tencent.mm.plugin.soter.d.a.d(5, 4, paramAnonymousc.errCode, "upload auth key failed");
          }
          else if ((paramAnonymousc.errCode == 4) || (paramAnonymousc.errCode == 3))
          {
            Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
            com.tencent.mm.plugin.soter.d.a.d(2, -1000223, -1, "gen ask failed");
          }
          else if (paramAnonymousc.errCode == 1003)
          {
            Log.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo upload ask failed");
            com.tencent.mm.plugin.soter.d.a.d(3, 4, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
          else
          {
            Log.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo unknown error when prepare auth key");
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
        }
      }
    }, new com.tencent.mm.plugin.fingerprint.c.c(this.kof, 1));
    AppMethodBeat.o(64379);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64385);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
    this.wFn = paramb;
    if (!Util.isNullOrNil(this.wFF))
    {
      if ((this.wFz != null) && (this.wFz.get() != null))
      {
        ((WalletBaseUI)this.wFz.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.b(this.wFF, this.wFG, this.kof, 1));
        AppMethodBeat.o(64385);
      }
    }
    else
    {
      Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
      com.tencent.mm.plugin.soter.d.a.d(9, -1000223, -1, "signature is null");
      bj(-1, MMApplicationContext.getContext().getString(2131760697));
    }
    AppMethodBeat.o(64385);
  }
  
  final void bj(int paramInt, String paramString)
  {
    AppMethodBeat.i(64382);
    if (this.wFm != null) {
      this.wFm.bg(paramInt, paramString);
    }
    AppMethodBeat.o(64382);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(64380);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
    if ((this.wFz != null) && (this.wFz.get() != null))
    {
      ((WalletBaseUI)this.wFz.get()).removeSceneEndListener(1586);
      ((WalletBaseUI)this.wFz.get()).removeSceneEndListener(1638);
    }
    this.wFm = null;
    p.wFK.reset();
    if ((this.wFz != null) && (this.wFz.get() != null)) {
      this.wFz.clear();
    }
    AppMethodBeat.o(64380);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(64383);
    Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    String str = paramString;
    if (Util.isNullOrNil(paramString)) {
      str = MMApplicationContext.getContext().getString(2131760697);
    }
    if ((paramq instanceof com.tencent.mm.plugin.fingerprint.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
        paramString = (com.tencent.mm.plugin.fingerprint.c.a)paramq;
        if (Util.isNullOrNil(paramString.wFE))
        {
          bj(-1, str);
          AppMethodBeat.o(64383);
          return true;
        }
        this.wFE = paramString.wFE;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64378);
            m.this.bj(0, "");
            AppMethodBeat.o(64378);
          }
        });
      }
    }
    else
    {
      if (!(paramq instanceof com.tencent.mm.plugin.fingerprint.c.b)) {
        break label235;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label207;
      }
      Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.d.a.flJ();
      com.tencent.mm.plugin.soter.d.a.d(0, 0, 0, "OK");
      bk(0, str);
    }
    for (;;)
    {
      AppMethodBeat.o(64383);
      return true;
      Log.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
      bj(paramInt2, str);
      com.tencent.mm.plugin.soter.d.a.d(7, paramInt1, paramInt2, "get challenge failed");
      AppMethodBeat.o(64383);
      return true;
      label207:
      Log.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.d.a.d(8, paramInt1, paramInt2, "open fp pay failed");
      bk(-1, str);
    }
    label235:
    AppMethodBeat.o(64383);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.m
 * JD-Core Version:    0.7.0.1
 */