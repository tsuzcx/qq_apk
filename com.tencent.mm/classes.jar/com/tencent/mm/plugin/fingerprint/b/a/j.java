package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.k;
import com.tencent.mm.plugin.fingerprint.b.m;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.a.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class j
  extends a
{
  private com.tencent.mm.plugin.soter.a rch;
  
  private com.tencent.mm.plugin.soter.a cuy()
  {
    AppMethodBeat.i(64434);
    if (this.rch == null) {
      this.rch = new com.tencent.mm.plugin.soter.a();
    }
    com.tencent.mm.plugin.soter.a locala = this.rch;
    AppMethodBeat.o(64434);
    return locala;
  }
  
  public final void a(Context paramContext, f paramf, final b paramb)
  {
    AppMethodBeat.i(64447);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "request fingerprint authorize: %s, %s", new Object[] { Integer.valueOf(paramf.scene), paramf.rcj });
    cuy().a(new a.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.soter.a.b.a paramAnonymousa)
      {
        AppMethodBeat.i(64427);
        com.tencent.mm.plugin.soter.d.a.m(3, paramAnonymousa.errCode, 1L);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "authentication failed: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "authentication success");
        j.cuz();
        if (paramb != null) {
          paramb.a(c.a(paramAnonymousa));
        }
        AppMethodBeat.o(64426);
      }
    }, paramContext, paramf.scene, 1, paramf.rcj);
    AppMethodBeat.o(64447);
  }
  
  public final void a(Context paramContext, f paramf, final d paramd)
  {
    AppMethodBeat.i(64444);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "request fingerprint authorize for pay");
    a(paramContext, paramf, new b()
    {
      private int rcE;
      
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(64425);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "authorize pay result: %s, %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
        paramAnonymousc = e.b(paramAnonymousc);
        if (paramAnonymousc.isSuccess())
        {
          paramAnonymousc.retryCount += 1;
          paramd.onSuccess(paramAnonymousc);
          AppMethodBeat.o(64425);
          return;
        }
        int i = (int)(System.currentTimeMillis() / 1000L);
        int j = i - this.rcE;
        if (j > 0)
        {
          paramAnonymousc.retryCount += 1;
          this.rcE = i;
        }
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SoterBiometricPayManager", "retryCount: %s", new Object[] { Integer.valueOf(paramAnonymousc.retryCount) });
        if ((paramAnonymousc.canRetry()) && (j > 0))
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SoterBiometricPayManager", "do retry: %s", new Object[] { Integer.valueOf(paramAnonymousc.retryCount) });
          paramd.onRetry(paramAnonymousc);
          AppMethodBeat.o(64425);
          return;
        }
        if (!paramAnonymousc.canRetry())
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SoterBiometricPayManager", "do fail: %s", new Object[] { Integer.valueOf(paramAnonymousc.retryCount) });
          paramd.onFail(paramAnonymousc);
          AppMethodBeat.o(64425);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "do fast, do nothing");
        AppMethodBeat.o(64425);
      }
    });
    AppMethodBeat.o(64444);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle)
  {
    final int i = 0;
    AppMethodBeat.i(64449);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "on post pay: %s, %s, %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    if ((!paramBoolean1) && (paramBoolean3))
    {
      if (paramBundle != null) {}
      for (final String str = paramBundle.getString("pwd");; str = "")
      {
        if (paramBundle != null) {
          i = paramBundle.getInt("key_open_biometric_type");
        }
        if (!bt.isNullOrNil(str)) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SoterBiometricPayManager", "no pwd. can not change auth key");
        AppMethodBeat.o(64449);
        return;
      }
      com.tencent.e.h.Iye.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(64432);
          j.b(j.this).a(new a.c()new com.tencent.mm.plugin.fingerprint.c.c
          {
            public final void a(com.tencent.soter.a.b.c paramAnonymous2c)
            {
              AppMethodBeat.i(64430);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "hy: gen auth key onResult: errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymous2c.errCode), paramAnonymous2c.errMsg });
              j.cuz();
              p.rcp.reset();
              AppMethodBeat.o(64430);
            }
            
            public final void b(com.tencent.soter.a.b.c paramAnonymous2c)
            {
              AppMethodBeat.i(64431);
              j.cuz();
              com.tencent.mm.plugin.soter.d.a.m(2, paramAnonymous2c.errCode, 1L);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "request faceid authorize: %s, %s", new Object[] { Integer.valueOf(paramf.scene), paramf.rcj });
    cuy().a(new a.a()
    {
      public final void a(int paramAnonymousInt, com.tencent.soter.a.b.a paramAnonymousa)
      {
        AppMethodBeat.i(64429);
        com.tencent.mm.plugin.soter.d.a.m(3, paramAnonymousa.errCode, 1L);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "authentication failed: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "authentication success");
        j.cuz();
        if (paramb != null) {
          paramb.a(c.a(paramAnonymousa));
        }
        AppMethodBeat.o(64428);
      }
    }, paramContext, paramf.scene, 2, paramf.rcj);
    AppMethodBeat.o(64448);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(64450);
    if (this.rch != null) {
      this.rch.cancel();
    }
    AppMethodBeat.o(64450);
  }
  
  public final boolean ctP()
  {
    AppMethodBeat.i(64442);
    boolean bool = com.tencent.soter.core.a.aM(aj.getContext(), 2);
    AppMethodBeat.o(64442);
    return bool;
  }
  
  public final Map<String, String> ctX()
  {
    AppMethodBeat.i(64435);
    HashMap localHashMap = new HashMap();
    Object localObject = com.tencent.mm.plugin.soter.d.d.dEQ();
    String str = ((com.tencent.mm.plugin.soter.d.e)localObject).yaF;
    localObject = ((com.tencent.mm.plugin.soter.d.e)localObject).yaG;
    localHashMap.put("cpu_id", str);
    localHashMap.put("uid", localObject);
    AppMethodBeat.o(64435);
    return localHashMap;
  }
  
  public final boolean cuo()
  {
    AppMethodBeat.i(64437);
    if (ae.fFA.fDR == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = ae.fFC.dAy;
      boolean bool3 = com.tencent.soter.a.a.fnk();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "is support: %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if (((!bool1) && (!bool2)) || (!bool3)) {
        break;
      }
      AppMethodBeat.o(64437);
      return true;
    }
    AppMethodBeat.o(64437);
    return false;
  }
  
  public final boolean cup()
  {
    AppMethodBeat.i(64436);
    boolean bool = cuo();
    AppMethodBeat.o(64436);
    return bool;
  }
  
  public final boolean cuq()
  {
    AppMethodBeat.i(64441);
    boolean bool = com.tencent.soter.core.a.aL(aj.getContext(), 1);
    AppMethodBeat.o(64441);
    return bool;
  }
  
  public final boolean cur()
  {
    AppMethodBeat.i(64440);
    boolean bool = com.tencent.soter.core.a.aL(aj.getContext(), 2);
    AppMethodBeat.o(64440);
    return bool;
  }
  
  public final boolean cus()
  {
    AppMethodBeat.i(64443);
    boolean bool = com.tencent.soter.core.a.aM(aj.getContext(), 1);
    AppMethodBeat.o(64443);
    return bool;
  }
  
  public final int cut()
  {
    return 2;
  }
  
  public final com.tencent.mm.plugin.fingerprint.d.d cuu()
  {
    AppMethodBeat.i(64451);
    m localm = new m();
    AppMethodBeat.o(64451);
    return localm;
  }
  
  public final boolean cuv()
  {
    AppMethodBeat.i(64445);
    boolean bool = com.tencent.soter.core.a.aNP(com.tencent.mm.plugin.fingerprint.b.d.cuc());
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "py: hasAuthKey: %b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(64445);
    return bool;
  }
  
  public final boolean eO(Context paramContext)
  {
    AppMethodBeat.i(64438);
    if ((ae.fFC.fFt & 0x1) > 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.soter.core.a.aK(paramContext, 1);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "is support fp: %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break;
      }
      AppMethodBeat.o(64438);
      return true;
    }
    AppMethodBeat.o(64438);
    return false;
  }
  
  public final boolean eP(Context paramContext)
  {
    AppMethodBeat.i(64439);
    if ((ae.fFC.fFt & 0x2) > 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.soter.core.a.aK(paramContext, 2);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "is support fp: %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2)) {
        break;
      }
      AppMethodBeat.o(64439);
      return true;
    }
    AppMethodBeat.o(64439);
    return false;
  }
  
  public final void p(Object... paramVarArgs)
  {
    AppMethodBeat.i(64446);
    if (com.tencent.soter.core.a.aNP(com.tencent.mm.plugin.fingerprint.b.d.cuc())) {
      com.tencent.soter.core.a.cU(com.tencent.mm.plugin.fingerprint.b.d.cuc(), false);
    }
    AppMethodBeat.o(64446);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(64433);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "prepare");
    if (((com.tencent.mm.plugin.fingerprint.d.a)g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).type() != 2)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "set soter manager");
      k localk = new k();
      localk.a(this);
      g.b(com.tencent.mm.plugin.fingerprint.d.a.class, localk);
    }
    if (((String)com.tencent.soter.a.c.b.fno().fnq().get(1)).equals("WechatAuthKeyPay&null"))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SoterBiometricPayManager", "init error, reinit");
      com.tencent.soter.a.c.b.fno().xv(false);
      com.tencent.mm.plugin.report.service.h.vKh.dB(1104, 46);
      com.tencent.mm.plugin.soter.e.b.a(true, new j.1(this));
    }
    AppMethodBeat.o(64433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.j
 * JD-Core Version:    0.7.0.1
 */