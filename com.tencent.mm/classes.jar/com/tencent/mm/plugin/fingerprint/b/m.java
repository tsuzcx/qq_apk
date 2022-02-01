package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.plugin.fingerprint.d.d;
import com.tencent.mm.plugin.soter.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public final class m
  implements d
{
  int dvd;
  private String jmZ = "";
  private com.tencent.mm.plugin.fingerprint.d.b tgM = null;
  private com.tencent.mm.plugin.fingerprint.d.b tgN = null;
  WeakReference<WalletBaseUI> tha = null;
  private com.tencent.mm.plugin.soter.a thd;
  private String thf;
  String thg;
  String thh;
  
  private void bg(int paramInt, String paramString)
  {
    AppMethodBeat.i(64384);
    ad.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
    clear();
    this.tgN.bc(paramInt, paramString);
    this.tgN = null;
    AppMethodBeat.o(64384);
  }
  
  public final void a(Context paramContext, final com.tencent.mm.plugin.fingerprint.d.b paramb)
  {
    AppMethodBeat.i(64381);
    ad.i("MicroMsg.SoterFingerprintOpenDelegate", "request authentication");
    if (bt.isNullOrNil(this.thf))
    {
      ad.w("MicroMsg.SoterFingerprintOpenDelegate", "no challenge!!");
      AppMethodBeat.o(64381);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 41);
    ((i)com.tencent.mm.kernel.g.ab(i.class)).a(paramContext, new f(this.thf), new com.tencent.mm.plugin.fingerprint.b.a.b()
    {
      public final void a(com.tencent.mm.plugin.fingerprint.b.a.c paramAnonymousc)
      {
        AppMethodBeat.i(64375);
        ad.i("MicroMsg.SoterFingerprintOpenDelegate", "authentication result: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
        Object localObject = "";
        switch (paramAnonymousc.errCode)
        {
        default: 
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
        }
        for (;;)
        {
          paramb.bc(-2, paramAnonymousc);
          AppMethodBeat.o(64375);
          return;
          ad.i("MicroMsg.SoterFingerprintOpenDelegate", "identify success");
          m.this.dvd = paramAnonymousc.dvd;
          m.this.thg = paramAnonymousc.thg;
          m.this.thh = paramAnonymousc.thh;
          com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 40);
          paramb.bc(0, "");
          AppMethodBeat.o(64375);
          return;
          ad.i("MicroMsg.SoterFingerprintOpenDelegate", "identify FingerPrintConst.RESULT_NO_MATCH");
          paramb.bc(-1, "");
          AppMethodBeat.o(64375);
          return;
          ad.i("MicroMsg.SoterFingerprintOpenDelegate", "identify timeout");
          AppMethodBeat.o(64375);
          return;
          localObject = aj.getContext().getString(2131764097);
          com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
          com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 39);
          paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
          continue;
          ad.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
          String str = aj.getContext().getString(2131764095);
          if (paramAnonymousc.errCode == 10308)
          {
            paramAnonymousc = aj.getContext().getString(2131764096);
            com.tencent.mm.plugin.soter.d.a.d(6, -1000223, -1, "too many trial");
          }
          else
          {
            localObject = str;
            if (Build.VERSION.SDK_INT == 27)
            {
              localObject = str;
              if ("Xiaomi".equals(Build.MANUFACTURER)) {
                localObject = aj.getContext().getString(2131756561);
              }
            }
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
            com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 39);
            paramAnonymousc = (com.tencent.mm.plugin.fingerprint.b.a.c)localObject;
            continue;
            ad.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: on error: %d", new Object[] { Integer.valueOf(paramAnonymousc.errCode) });
            localObject = aj.getContext().getString(2131764095);
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, "fingerprint error");
            com.tencent.mm.plugin.soter.d.a.RT(2);
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
    ad.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
    this.thd = new com.tencent.mm.plugin.soter.a();
    this.tha = new WeakReference((WalletBaseUI)paramContext);
    this.tgM = paramb;
    this.jmZ = paramString;
    ((WalletBaseUI)this.tha.get()).addSceneEndListener(1586);
    ((WalletBaseUI)this.tha.get()).addSceneEndListener(1638);
    com.tencent.mm.plugin.soter.d.a.efA();
    ((i)com.tencent.mm.kernel.g.ab(i.class)).r(null);
    ad.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
    com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 35);
    this.thd.a(new a.c()new com.tencent.mm.plugin.fingerprint.c.c
    {
      public final void a(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64376);
        if ((m.this.tha != null) && (m.this.tha.get() != null))
        {
          ((WalletBaseUI)m.this.tha.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.a(1), false);
          AppMethodBeat.o(64376);
          return;
        }
        m.this.bf(-1, "base ui is null");
        AppMethodBeat.o(64376);
      }
      
      public final void b(com.tencent.soter.a.b.c paramAnonymousc)
      {
        AppMethodBeat.i(64377);
        if (paramAnonymousc.errCode == 1006)
        {
          ad.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
          com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.g.yhR.dD(1104, 34);
          m.this.bf(-1, aj.getContext().getString(2131756561));
          AppMethodBeat.o(64377);
          return;
          if (paramAnonymousc.errCode == 6)
          {
            com.tencent.mm.plugin.soter.d.a.d(4, -1000223, -1, "gen auth key failed");
            if ((!bt.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.startsWith("java.security.ProviderException")))
            {
              m.this.bf(-2, aj.getContext().getString(2131756562));
              AppMethodBeat.o(64377);
              return;
            }
            if ((com.tencent.soter.core.a.fUv() == 1) && (!bt.isNullOrNil(paramAnonymousc.errMsg)) && (paramAnonymousc.errMsg.equals("errmsg not specified")))
            {
              m.this.bf(-2, aj.getContext().getString(2131756563));
              AppMethodBeat.o(64377);
            }
          }
          else if (paramAnonymousc.errCode == 1004)
          {
            ad.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove");
            com.tencent.mm.plugin.soter.d.a.d(5, 4, paramAnonymousc.errCode, "upload auth key failed");
          }
          else if ((paramAnonymousc.errCode == 4) || (paramAnonymousc.errCode == 3))
          {
            ad.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
            com.tencent.mm.plugin.soter.d.a.d(2, -1000223, -1, "gen ask failed");
          }
          else if (paramAnonymousc.errCode == 1003)
          {
            ad.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo upload ask failed");
            com.tencent.mm.plugin.soter.d.a.d(3, 4, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
          else
          {
            ad.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo unknown error when prepare auth key");
            com.tencent.mm.plugin.soter.d.a.d(1000, -1000223, paramAnonymousc.errCode, paramAnonymousc.errMsg);
          }
        }
      }
    }, new com.tencent.mm.plugin.fingerprint.c.c(this.jmZ, 1));
    AppMethodBeat.o(64379);
  }
  
  public final void a(com.tencent.mm.plugin.fingerprint.d.b paramb, int paramInt)
  {
    AppMethodBeat.i(64385);
    ad.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
    this.tgN = paramb;
    if (!bt.isNullOrNil(this.thg))
    {
      if ((this.tha != null) && (this.tha.get() != null))
      {
        ((WalletBaseUI)this.tha.get()).doSceneProgress(new com.tencent.mm.plugin.fingerprint.c.b(this.thg, this.thh, this.jmZ, 1));
        AppMethodBeat.o(64385);
      }
    }
    else
    {
      ad.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
      com.tencent.mm.plugin.soter.d.a.d(9, -1000223, -1, "signature is null");
      bf(-1, aj.getContext().getString(2131759409));
    }
    AppMethodBeat.o(64385);
  }
  
  final void bf(int paramInt, String paramString)
  {
    AppMethodBeat.i(64382);
    if (this.tgM != null) {
      this.tgM.bc(paramInt, paramString);
    }
    AppMethodBeat.o(64382);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(64380);
    ad.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
    if ((this.tha != null) && (this.tha.get() != null))
    {
      ((WalletBaseUI)this.tha.get()).removeSceneEndListener(1586);
      ((WalletBaseUI)this.tha.get()).removeSceneEndListener(1638);
    }
    this.tgM = null;
    p.thl.reset();
    if ((this.tha != null) && (this.tha.get() != null)) {
      this.tha.clear();
    }
    AppMethodBeat.o(64380);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64383);
    ad.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    String str = paramString;
    if (bt.isNullOrNil(paramString)) {
      str = aj.getContext().getString(2131759409);
    }
    if ((paramn instanceof com.tencent.mm.plugin.fingerprint.c.a))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ad.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
        paramString = (com.tencent.mm.plugin.fingerprint.c.a)paramn;
        if (bt.isNullOrNil(paramString.thf))
        {
          bf(-1, str);
          AppMethodBeat.o(64383);
          return true;
        }
        this.thf = paramString.thf;
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(64378);
            m.this.bf(0, "");
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
      ad.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
      com.tencent.mm.plugin.soter.d.a.efB();
      com.tencent.mm.plugin.soter.d.a.d(0, 0, 0, "OK");
      bg(0, str);
    }
    for (;;)
    {
      AppMethodBeat.o(64383);
      return true;
      ad.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
      bf(paramInt2, str);
      com.tencent.mm.plugin.soter.d.a.d(7, paramInt1, paramInt2, "get challenge failed");
      AppMethodBeat.o(64383);
      return true;
      label207:
      ad.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
      com.tencent.mm.plugin.soter.d.a.d(8, paramInt1, paramInt2, "open fp pay failed");
      bg(-1, str);
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