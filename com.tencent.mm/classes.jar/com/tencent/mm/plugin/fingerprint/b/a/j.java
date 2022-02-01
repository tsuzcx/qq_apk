package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.plugin.fingerprint.b.k;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.a.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class j
  extends a
{
  private com.tencent.mm.plugin.soter.a trW;
  
  private com.tencent.mm.plugin.soter.a cSE()
  {
    AppMethodBeat.i(64434);
    if (this.trW == null) {
      this.trW = new com.tencent.mm.plugin.soter.a();
    }
    com.tencent.mm.plugin.soter.a locala = this.trW;
    AppMethodBeat.o(64434);
    return locala;
  }
  
  public final void a(Context paramContext, f paramf, final b paramb)
  {
    AppMethodBeat.i(64447);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "request fingerprint authorize: %s, %s", new Object[] { Integer.valueOf(paramf.scene), paramf.trY });
    cSE().a(new a.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.soter.a.b.a paramAnonymousa)
      {
        AppMethodBeat.i(64427);
        com.tencent.mm.plugin.soter.d.a.n(3, paramAnonymousa.errCode, 1L);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "authentication failed: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 1)
        {
          if (paramb != null)
          {
            paramAnonymousa = new c();
            paramAnonymousa.errCode = 2002;
            paramb.a(paramAnonymousa);
            AppMethodBeat.o(64427);
          }
        }
        else
        {
          if (paramAnonymousa.errCode == 1021) {
            j.a(j.this).cancel();
          }
          if (paramb != null) {
            paramb.a(c.a(paramAnonymousa));
          }
        }
        AppMethodBeat.o(64427);
      }
      
      public final void b(com.tencent.soter.a.b.a paramAnonymousa)
      {
        AppMethodBeat.i(64426);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "authentication success");
        j.cSF();
        if (paramb != null) {
          paramb.a(c.a(paramAnonymousa));
        }
        AppMethodBeat.o(64426);
      }
    }, paramContext, paramf.scene, 1, paramf.trY);
    AppMethodBeat.o(64447);
  }
  
  public final void a(Context paramContext, f paramf, final d paramd)
  {
    AppMethodBeat.i(64444);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "request fingerprint authorize for pay");
    a(paramContext, paramf, new b()
    {
      private int tst;
      
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(64425);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "authorize pay result: %s, %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
        paramAnonymousc = e.b(paramAnonymousc);
        if (paramAnonymousc.isSuccess())
        {
          paramAnonymousc.retryCount += 1;
          paramd.onSuccess(paramAnonymousc);
          AppMethodBeat.o(64425);
          return;
        }
        int i = (int)(System.currentTimeMillis() / 1000L);
        int j = i - this.tst;
        if (j > 0)
        {
          paramAnonymousc.retryCount += 1;
          this.tst = i;
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SoterBiometricPayManager", "retryCount: %s", new Object[] { Integer.valueOf(paramAnonymousc.retryCount) });
        if ((paramAnonymousc.canRetry()) && (j > 0))
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SoterBiometricPayManager", "do retry: %s", new Object[] { Integer.valueOf(paramAnonymousc.retryCount) });
          paramd.onRetry(paramAnonymousc);
          AppMethodBeat.o(64425);
          return;
        }
        if (!paramAnonymousc.canRetry())
        {
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SoterBiometricPayManager", "do fail: %s", new Object[] { Integer.valueOf(paramAnonymousc.retryCount) });
          paramd.onFail(paramAnonymousc);
          AppMethodBeat.o(64425);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "do fast, do nothing");
        AppMethodBeat.o(64425);
      }
    });
    AppMethodBeat.o(64444);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle)
  {
    final int i = 0;
    AppMethodBeat.i(64449);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "on post pay: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    if ((!paramBoolean1) && (paramBoolean3))
    {
      if (paramBundle != null) {}
      for (final String str = paramBundle.getString("pwd");; str = "")
      {
        if (paramBundle != null) {
          i = paramBundle.getInt("key_open_biometric_type");
        }
        if (!bu.isNullOrNil(str)) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SoterBiometricPayManager", "no pwd. can not change auth key");
        AppMethodBeat.o(64449);
        return;
      }
      h.MqF.r(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(64432);
          j.this.q(new Object[0]);
          j.b(j.this).a(new a.c()new com.tencent.mm.plugin.fingerprint.c.c
          {
            public final void a(com.tencent.soter.a.b.c paramAnonymous2c)
            {
              AppMethodBeat.i(64430);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "hy: gen auth key onResult: errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymous2c.errCode), paramAnonymous2c.errMsg });
              j.cSF();
              p.tse.reset();
              AppMethodBeat.o(64430);
            }
            
            public final void b(com.tencent.soter.a.b.c paramAnonymous2c)
            {
              AppMethodBeat.i(64431);
              j.cSF();
              com.tencent.mm.plugin.soter.d.a.n(2, paramAnonymous2c.errCode, 1L);
              AppMethodBeat.o(64431);
            }
          }, new com.tencent.mm.plugin.fingerprint.c.c(str, i));
          AppMethodBeat.o(64432);
        }
      }, 500L);
    }
    AppMethodBeat.o(64449);
  }
  
  public final void b(Context paramContext, f paramf, final b paramb)
  {
    AppMethodBeat.i(64448);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "request faceid authorize: %s, %s", new Object[] { Integer.valueOf(paramf.scene), paramf.trY });
    cSE().a(new a.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.soter.a.b.a paramAnonymousa)
      {
        AppMethodBeat.i(64429);
        com.tencent.mm.plugin.soter.d.a.n(3, paramAnonymousa.errCode, 1L);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "authentication failed: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 1)
        {
          if (paramb != null)
          {
            paramAnonymousa = new c();
            paramAnonymousa.errCode = 2002;
            paramb.a(paramAnonymousa);
            AppMethodBeat.o(64429);
          }
        }
        else
        {
          if (paramAnonymousa.errCode == 1022) {
            j.a(j.this).cancel();
          }
          if (paramb != null) {
            paramb.a(c.a(paramAnonymousa));
          }
        }
        AppMethodBeat.o(64429);
      }
      
      public final void b(com.tencent.soter.a.b.a paramAnonymousa)
      {
        AppMethodBeat.i(64428);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "authentication success");
        j.cSF();
        if (paramb != null) {
          paramb.a(c.a(paramAnonymousa));
        }
        AppMethodBeat.o(64428);
      }
    }, paramContext, paramf.scene, 2, paramf.trY);
    AppMethodBeat.o(64448);
  }
  
  public final boolean cRV()
  {
    AppMethodBeat.i(64442);
    boolean bool = com.tencent.soter.core.a.aV(ak.getContext(), 2);
    AppMethodBeat.o(64442);
    return bool;
  }
  
  public final com.tencent.mm.plugin.fingerprint.d.d cSA()
  {
    AppMethodBeat.i(64451);
    com.tencent.mm.plugin.fingerprint.b.m localm = new com.tencent.mm.plugin.fingerprint.b.m();
    AppMethodBeat.o(64451);
    return localm;
  }
  
  public final boolean cSB()
  {
    AppMethodBeat.i(64445);
    boolean bool = com.tencent.soter.core.a.baV(com.tencent.mm.plugin.fingerprint.b.d.cSi());
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "py: hasAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(64445);
    return bool;
  }
  
  public final Map<String, String> cSd()
  {
    AppMethodBeat.i(64435);
    HashMap localHashMap = new HashMap();
    Object localObject = com.tencent.mm.plugin.soter.d.d.ejm();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject).AXb;
    localObject = ((com.tencent.mm.plugin.soter.d.e)localObject).AXc;
    localHashMap.put("cpu_id", str);
    localHashMap.put("uid", localObject);
    AppMethodBeat.o(64435);
    return localHashMap;
  }
  
  public final boolean cSu()
  {
    AppMethodBeat.i(64437);
    if (com.tencent.mm.compatible.deviceinfo.ae.geQ.gdg == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.compatible.deviceinfo.ae.geS.dLM;
      boolean bool3 = com.tencent.soter.a.a.fZr();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "is support: %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if (((!bool1) && (!bool2)) || (!bool3)) {
        break;
      }
      AppMethodBeat.o(64437);
      return true;
    }
    AppMethodBeat.o(64437);
    return false;
  }
  
  public final boolean cSv()
  {
    AppMethodBeat.i(64436);
    boolean bool = cSu();
    AppMethodBeat.o(64436);
    return bool;
  }
  
  public final boolean cSw()
  {
    AppMethodBeat.i(64441);
    boolean bool = com.tencent.soter.core.a.aU(ak.getContext(), 1);
    AppMethodBeat.o(64441);
    return bool;
  }
  
  public final boolean cSx()
  {
    AppMethodBeat.i(64440);
    boolean bool = com.tencent.soter.core.a.aU(ak.getContext(), 2);
    AppMethodBeat.o(64440);
    return bool;
  }
  
  public final boolean cSy()
  {
    AppMethodBeat.i(64443);
    boolean bool = com.tencent.soter.core.a.aV(ak.getContext(), 1);
    AppMethodBeat.o(64443);
    return bool;
  }
  
  public final int cSz()
  {
    return 2;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(64450);
    if (this.trW != null) {
      this.trW.cancel();
    }
    AppMethodBeat.o(64450);
  }
  
  public final boolean fi(Context paramContext)
  {
    AppMethodBeat.i(64438);
    if ((com.tencent.mm.compatible.deviceinfo.ae.geS.geJ & 0x1) > 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.soter.core.a.aT(paramContext, 1);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "is support fp: %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break;
      }
      AppMethodBeat.o(64438);
      return true;
    }
    AppMethodBeat.o(64438);
    return false;
  }
  
  public final boolean fj(Context paramContext)
  {
    AppMethodBeat.i(64439);
    if ((com.tencent.mm.compatible.deviceinfo.ae.geS.geJ & 0x2) > 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.soter.core.a.aT(paramContext, 2);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "is support fp: %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break;
      }
      AppMethodBeat.o(64439);
      return true;
    }
    AppMethodBeat.o(64439);
    return false;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(64433);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "prepare");
    if (((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).type() != 2)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "set soter manager");
      k localk = new k();
      localk.a(this);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.fingerprint.d.a.class, localk);
    }
    if (((String)com.tencent.soter.a.c.b.fZv().fZx().get(1)).equals("WechatAuthKeyPay&null"))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "init error, reinit");
      com.tencent.soter.a.c.b.fZv().zG(false);
      com.tencent.mm.plugin.report.service.g.yxI.dD(1104, 46);
      com.tencent.mm.plugin.soter.e.b.a(true, new com.tencent.mm.plugin.soter.d.g()
      {
        public final void bb(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(64424);
          if ((paramAnonymousInt == 0) && (com.tencent.soter.a.a.fZr()))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "init success: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
            AppMethodBeat.o(64424);
            return;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "init failed: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          AppMethodBeat.o(64424);
        }
      });
    }
    AppMethodBeat.o(64433);
  }
  
  public final void q(Object... paramVarArgs)
  {
    AppMethodBeat.i(64446);
    if (com.tencent.soter.core.a.baV(com.tencent.mm.plugin.fingerprint.b.d.cSi()))
    {
      com.tencent.soter.core.a.dj(com.tencent.mm.plugin.fingerprint.b.d.cSi(), false);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SoterBiometricPayManager", "change to new authkey name");
      com.tencent.soter.a.c.b.fZv().fZx().put(1, com.tencent.mm.plugin.soter.d.m.SC(1));
    }
    AppMethodBeat.o(64446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.j
 * JD-Core Version:    0.7.0.1
 */