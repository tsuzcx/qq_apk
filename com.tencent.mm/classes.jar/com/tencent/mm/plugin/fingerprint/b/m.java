package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public final class m
  implements d
{
  int djq;
  private String iTR = "";
  private com.tencent.mm.plugin.soter.a skB;
  private String skD;
  String skE;
  String skF;
  private com.tencent.mm.plugin.fingerprint.d.b skk = null;
  private com.tencent.mm.plugin.fingerprint.d.b skl = null;
  WeakReference<WalletBaseUI> sky = null;
  
  private void bd(int paramInt, String paramString)
  {
    AppMethodBeat.i(64384);
    ac.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
    clear();
    this.skl.aZ(paramInt, paramString);
    this.skl = null;
    AppMethodBeat.o(64384);
  }
  
  public final void a(Context paramContext, final com.tencent.mm.plugin.fingerprint.d.b paramb)
  {
    AppMethodBeat.i(64381);
    ac.i("MicroMsg.SoterFingerprintOpenDelegate", "request authentication");
    if (bs.isNullOrNil(this.skD))
    {
      ac.w("MicroMsg.SoterFingerprintOpenDelegate", "no challenge!!");
      AppMethodBeat.o(64381);
      return;
    }
    h.wUl.dB(1104, 41);
    ((i)g.ab(i.class)).a(paramContext, new f(this.skD), new com.tencent.mm.plugin.fingerprint.b.a.b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64375);
        ac.i("MicroMsg.SoterFingerprintOpenDelegate", "authentication result: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
        Object localObject = "";
        switch (paramAnonymousc.errCode)
        {
        default: 
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
        }
        for (;;)
        {
          paramb.aZ(-2, paramAnonymousc);
          AppMethodBeat.o(64375);
          return;
          ac.i("MicroMsg.SoterFingerprintOpenDelegate", "identify success");
          m.this.djq = paramAnonymousc.djq;
          m.this.skE = paramAnonymousc.skE;
          m.this.skF = paramAnonymousc.skF;
          h.wUl.dB(1104, 40);
          paramb.aZ(0, "");
          AppMethodBeat.o(64375);
          return;
          ac.i("MicroMsg.SoterFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
          paramb.aZ(-1, "");
          AppMethodBeat.o(64375);
          return;
          ac.i("MicroMsg.SoterFingerprintOpenDelegate", "identify timeout");
          AppMethodBeat.o(64375);
          return;
          localObject = ai.getContext().getString(2131764097);
          com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
          h.wUl.dB(1104, 39);
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
          continue;
          ac.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
          String str = ai.getContext().getString(2131764095);
          if (paramAnonymousc.errCode == 10308)
          {
            paramAnonymousc = ai.getContext().getString(2131764096);
            com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
          }
          else
          {
            localObject = str;
            if (Build.VERSION.SDK_INT == 27)
            {
              localObject = str;
              if ("Xiaomi".equals(Build.MANUFACTURER)) {
                localObject = ai.getContext().getString(2131756561);
              }
            }
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
            h.wUl.dB(1104, 39);
            paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
            continue;
            ac.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
            localObject = ai.getContext().getString(2131764095);
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
            com.tencent.mm.plugin.soter.d.a.Ql(2);
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
    ac.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
    this.skB = new com.tencent.mm.plugin.soter.a();
    this.sky = new WeakReference((WalletBaseUI)paramContext);
    this.skk = paramb;
    this.iTR = paramString;
    ((WalletBaseUI)this.sky.get()).addSceneEndListener(1586);
    ((WalletBaseUI)this.sky.get()).addSceneEndListener(1638);
    com.tencent.mm.plugin.soter.d.a.dTm();
    ((i)g.ab(i.class)).r(null);
    ac.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
    h.wUl.dB(1104, 35);
    this.skB.a(new a.c()new com.tencent.mm.plugin.fingerprint.c.c
    {
      public final void a(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64376);
        if ((m.this.sky != null) && (m.this.sky.get() != null))
        {
          ((WalletBaseUI)m.this.sky.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.a(1), false);
          AppMethodBeat.o(64376);
          return;
        }
        m.this.bc(-1, "base ui is null");
        AppMethodBeat.o(64376);
      }
      
      public final void b(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64377);
        if (paramAnonymousc.errCode == 1006)
        {
          ac.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
          com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
        }
        for (;;)
        {
          h.wUl.dB(1104, 34);
          m.this.bc(-1, ai.getContext().getString(2131756561));
          AppMethodBeat.o(64377);
          return;
          if (paramAnonymousc.errCode == 6)
          {
            com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed");
            if ((!bs.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.startsWith("java.security.ProviderException")))
            {
              m.this.bc(-2, ai.getContext().getString(2131756562));
              AppMethodBeat.o(64377);
              return;
            }
            if ((com.tencent.soter.core.a.fDd() == 1) && (!bs.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.equals("errmsg not specified")))
            {
              m.this.bc(-2, ai.getContext().getString(2131756563));
              AppMethodBeat.o(64377);
            }
          }
          else if (paramAnonymousc.errCode == 1004)
          {
            ac.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove");
            com.tencent.mm.plugin.soter.d.a.d(5, 4, paramAnonymousc.errCode, "upload auth key failed");
          }
          else if ((paramAnonymousc.errCode == 4) || (paramAnonymousc.errCode == 3))
          {
            ac.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
            com.tencent.mm.plugin.soter.d.a.d(2, -1000223, -1, "gen ask failed");
          }
          else if (paramAnonymousc.errCode == 1003)
          {
            ac.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo upload ask failed");
            com.tencent.mm.plugin.soter.d.a.d(3, 4, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
          else
          {
            ac.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo unknown error when prepare auth key");
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
        }
      }
    }, new com.tencent.mm.plugin.fingerprint.c.c(this.iTR, 1));
    AppMethodBeat.o(64379);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64385);
    ac.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
    this.skl = paramb;
    if (!bs.isNullOrNil(this.skE))
    {
      if ((this.sky != null) && (this.sky.get() != null))
      {
        ((WalletBaseUI)this.sky.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.b(this.skE, this.skF, this.iTR, 1));
        AppMethodBeat.o(64385);
      }
    }
    else
    {
      ac.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
      com.tencent.mm.plugin.soter.d.a.d(9, -1000223, -1, "signature is null");
      bc(-1, ai.getContext().getString(2131759409));
    }
    AppMethodBeat.o(64385);
  }
  
  final void bc(int paramInt, String paramString)
  {
    AppMethodBeat.i(64382);
    if (this.skk != null) {
      this.skk.aZ(paramInt, paramString);
    }
    AppMethodBeat.o(64382);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(64380);
    ac.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
    if ((this.sky != null) && (this.sky.get() != null))
    {
      ((WalletBaseUI)this.sky.get()).removeSceneEndListener(1586);
      ((WalletBaseUI)this.sky.get()).removeSceneEndListener(1638);
    }
    this.skk = null;
    p.skJ.reset();
    if ((this.sky != null) && (this.sky.get() != null)) {
      this.sky.clear();
    }
    AppMethodBeat.o(64380);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64383);
    ac.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    String str = paramString;
    if (bs.isNullOrNil(paramString)) {
      str = ai.getContext().getString(2131759409);
    }
    if ((paramn instanceof com.tencent.mm.plugin.fingerprint.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ac.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
        paramString = (com.tencent.mm.plugin.fingerprint.c.a)paramn;
        if (bs.isNullOrNil(paramString.skD))
        {
          bc(-1, str);
          AppMethodBeat.o(64383);
          return true;
        }
        this.skD = paramString.skD;
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64378);
            m.this.bc(0, "");
            AppMethodBeat.o(64378);
          }
        });
      }
    }
    else
    {
      if (!(paramn instanceof com.tencent.mm.plugin.fingerprint.c.b)) {
        break label235;
      }
      if ((paramInt2 != 0) || (paramInt1 != 0)) {
        break label207;
      }
      ac.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.d.a.dTn();
      com.tencent.mm.plugin.soter.d.a.d(0, 0, 0, "OK");
      bd(0, str);
    }
    for (;;)
    {
      AppMethodBeat.o(64383);
      return true;
      ac.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
      bc(paramInt2, str);
      com.tencent.mm.plugin.soter.d.a.d(7, paramInt1, paramInt2, "get challenge failed");
      AppMethodBeat.o(64383);
      return true;
      label207:
      ac.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.d.a.d(8, paramInt1, paramInt2, "open fp pay failed");
      bd(-1, str);
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