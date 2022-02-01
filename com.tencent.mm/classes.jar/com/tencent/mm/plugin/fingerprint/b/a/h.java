package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.b.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Map;

public final class h
  extends a
{
  private com.b.a.a thy;
  
  private com.b.a.a cPX()
  {
    AppMethodBeat.i(64415);
    this.thy = com.b.a.a.zM();
    com.b.a.a locala = this.thy;
    AppMethodBeat.o(64415);
    return locala;
  }
  
  public final void a(Context paramContext, final f paramf, final b paramb)
  {
    AppMethodBeat.i(64418);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "request fingerprint authorize: %s", new Object[] { paramf.dlu });
    if (this.thy == null)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.HuaweiBiometricPayManagerImpl", "open auth once");
      cPX();
    }
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64409);
        com.b.a.a locala = h.a(h.this);
        if (locala == null)
        {
          if (paramb != null) {
            paramb.a(c.af(paramf.dlu, -1, -1));
          }
          AppMethodBeat.o(64409);
          return;
        }
        int[] arrayOfInt = locala.zN();
        if ((locala.a(new a.b()
        {
          public final void D(int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(64408);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "on result: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(-1) });
            if (h.3.this.thC != null) {
              h.3.this.thC.a(c.af(h.3.this.thD.dlu, paramAnonymous2Int1, paramAnonymous2Int2));
            }
            AppMethodBeat.o(64408);
          }
          
          public final void bQ(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(64407);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "on status: %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(-1) });
            AppMethodBeat.o(64407);
          }
        }, arrayOfInt) != 0) && (paramb != null)) {
          paramb.a(c.af(paramf.dlu, -1, -1));
        }
        AppMethodBeat.o(64409);
      }
    }, 300L);
    AppMethodBeat.o(64418);
  }
  
  public final void a(Context paramContext, f paramf, final d paramd)
  {
    AppMethodBeat.i(64417);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "request fingerprint authorize for pay");
    a(paramContext, paramf, new b()
    {
      private int thA;
      
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(64406);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "authorize pay result: %s, %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
        paramAnonymousc = e.b(paramAnonymousc);
        if (paramAnonymousc.isSuccess())
        {
          paramAnonymousc.retryCount += 1;
          paramd.onSuccess(paramAnonymousc);
          AppMethodBeat.o(64406);
          return;
        }
        int i = (int)(System.currentTimeMillis() / 1000L);
        int j = i - this.thA;
        if (j > 0)
        {
          paramAnonymousc.retryCount += 1;
          this.thA = i;
        }
        if ((paramAnonymousc.canRetry()) && (paramAnonymousc.retryCount < 3) && (j > 0))
        {
          paramd.onRetry(paramAnonymousc);
          AppMethodBeat.o(64406);
          return;
        }
        paramd.onFail(paramAnonymousc);
        AppMethodBeat.o(64406);
      }
    });
    AppMethodBeat.o(64417);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Bundle paramBundle) {}
  
  public final void b(Context paramContext, f paramf, b paramb) {}
  
  public final boolean cPP()
  {
    AppMethodBeat.i(64411);
    boolean bool1;
    boolean bool3;
    int i;
    if (ae.gcI.gaY == 1)
    {
      bool1 = true;
      bool3 = ae.gcK.dKx;
      int[] arrayOfInt = com.b.a.a.zO();
      if (arrayOfInt == null) {
        break label119;
      }
      i = 0;
      label37:
      if (i >= arrayOfInt.length) {
        break label119;
      }
      if (1 != arrayOfInt[i]) {
        break label112;
      }
    }
    label112:
    label119:
    for (boolean bool2 = true;; bool2 = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "is support: %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!bool1) || (!bool2) || (bool3)) {
        break label124;
      }
      AppMethodBeat.o(64411);
      return true;
      bool1 = false;
      break;
      i += 1;
      break label37;
    }
    label124:
    AppMethodBeat.o(64411);
    return false;
  }
  
  public final boolean cPQ()
  {
    AppMethodBeat.i(64412);
    if ((cPP()) && (com.tencent.mm.plugin.fingerprint.b.d.cPI()) && (com.tencent.mm.plugin.fingerprint.b.d.cPJ()))
    {
      AppMethodBeat.o(64412);
      return true;
    }
    AppMethodBeat.o(64412);
    return false;
  }
  
  public final boolean cPR()
  {
    AppMethodBeat.i(64414);
    cPX();
    if (this.thy == null)
    {
      AppMethodBeat.o(64414);
      return false;
    }
    int[] arrayOfInt = this.thy.zN();
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0)) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HuaweiBiometricPayManagerImpl", "ids is null");
    }
    try
    {
      this.thy.release();
      label55:
      this.thy = null;
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        AppMethodBeat.o(64414);
        return true;
      }
      AppMethodBeat.o(64414);
      return false;
    }
    catch (Exception localException)
    {
      break label55;
    }
  }
  
  public final boolean cPS()
  {
    return false;
  }
  
  public final boolean cPT()
  {
    return false;
  }
  
  public final int cPU()
  {
    return 1;
  }
  
  public final com.tencent.mm.plugin.fingerprint.d.d cPV()
  {
    AppMethodBeat.i(64420);
    com.tencent.mm.plugin.fingerprint.b.g localg = new com.tencent.mm.plugin.fingerprint.b.g();
    AppMethodBeat.o(64420);
    return localg;
  }
  
  public final boolean cPW()
  {
    return true;
  }
  
  public final boolean cPq()
  {
    return false;
  }
  
  public final Map<String, String> cPy()
  {
    return null;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(64419);
    if (this.thy != null) {
      try
      {
        this.thy.abort();
        this.thy.release();
        AppMethodBeat.o(64419);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(64419);
  }
  
  public final boolean fe(Context paramContext)
  {
    AppMethodBeat.i(64413);
    boolean bool = cPQ();
    AppMethodBeat.o(64413);
    return bool;
  }
  
  public final boolean ff(Context paramContext)
  {
    return false;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(64410);
    if (((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.fingerprint.d.a.class)).type() != 1)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "set soter manager");
      com.tencent.mm.plugin.fingerprint.b.c localc = new com.tencent.mm.plugin.fingerprint.b.c();
      localc.a(this);
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.fingerprint.d.a.class, localc);
    }
    if (q.is64BitRuntime())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "not support 64bit");
      AppMethodBeat.o(64410);
      return;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64405);
        if (!com.tencent.mm.plugin.fingerprint.b.d.cPI()) {}
        try
        {
          h.a(h.this, aj.getContext());
          if (com.tencent.mm.plugin.fingerprint.b.d.cPJ()) {}
        }
        catch (Exception localException)
        {
          try
          {
            com.tencent.mm.plugin.fingerprint.a.class.getClassLoader();
            if (!TextUtils.isEmpty(j.vq("teec")))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "LoadLibrary fingerprintauth.so, find the libteec so");
              j.vr("fingerprintauth");
              com.tencent.mm.plugin.fingerprint.b.d.mC(true);
            }
            for (;;)
            {
              h.cPY();
              AppMethodBeat.o(64405);
              return;
              localException = localException;
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.HuaweiBiometricPayManagerImpl", localException, "", new Object[0]);
              com.tencent.mm.plugin.fingerprint.b.d.mB(false);
              break;
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HuaweiBiometricPayManagerImpl", "can not LoadLibrary fingerprintauth.so, because can not find the libteec");
              com.tencent.mm.plugin.fingerprint.b.d.mC(false);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.HuaweiBiometricPayManagerImpl", localThrowable, "", new Object[0]);
              com.tencent.mm.plugin.fingerprint.b.d.mC(false);
            }
          }
        }
      }
    }, getClass().getName());
    AppMethodBeat.o(64410);
  }
  
  public final void r(Object... paramVarArgs)
  {
    AppMethodBeat.i(64416);
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HuaweiBiometricPayManagerImpl", "hy: param incorrect");
      AppMethodBeat.o(64416);
      return;
    }
    String str = com.tencent.mm.plugin.fingerprint.b.d.getUserId();
    if (com.tencent.mm.plugin.fingerprint.b.d.cPx()) {
      FingerPrintAuth.clearData(com.tencent.mm.plugin.fingerprint.b.d.fc(aj.getContext()), str, ((Integer)paramVarArgs[0]).intValue());
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "clear fingerprint data id:" + str + " clear_rsa_key_level:" + paramVarArgs[0]);
      AppMethodBeat.o(64416);
      return;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HuaweiBiometricPayManagerImpl", "device is not support FingerPrintAuth");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.h
 * JD-Core Version:    0.7.0.1
 */