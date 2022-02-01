package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.a.a.a.b;
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
  private com.a.a.a rcC;
  
  private com.a.a.a cuw()
  {
    AppMethodBeat.i(64415);
    this.rcC = com.a.a.a.yC();
    com.a.a.a locala = this.rcC;
    AppMethodBeat.o(64415);
    return locala;
  }
  
  public final void a(Context paramContext, final f paramf, final b paramb)
  {
    AppMethodBeat.i(64418);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "request fingerprint authorize: %s", new Object[] { paramf.dcE });
    if (this.rcC == null)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.HuaweiBiometricPayManagerImpl", "open auth once");
      cuw();
    }
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64409);
        com.a.a.a locala = h.a(h.this);
        if (locala == null)
        {
          if (paramb != null) {
            paramb.a(c.ac(paramf.dcE, -1, -1));
          }
          AppMethodBeat.o(64409);
          return;
        }
        int[] arrayOfInt = locala.yD();
        if ((locala.a(new a.b()
        {
          public final void D(int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(64408);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "on result: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(-1) });
            if (h.3.this.rcG != null) {
              h.3.this.rcG.a(c.ac(h.3.this.rcH.dcE, paramAnonymous2Int1, paramAnonymous2Int2));
            }
            AppMethodBeat.o(64408);
          }
          
          public final void bR(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(64407);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "on status: %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(-1) });
            AppMethodBeat.o(64407);
          }
        }, arrayOfInt) != 0) && (paramb != null)) {
          paramb.a(c.ac(paramf.dcE, -1, -1));
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
      private int rcE;
      
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
        int j = i - this.rcE;
        if (j > 0)
        {
          paramAnonymousc.retryCount += 1;
          this.rcE = i;
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
  
  public final void cancel()
  {
    AppMethodBeat.i(64419);
    if (this.rcC != null) {
      try
      {
        this.rcC.abort();
        this.rcC.release();
        AppMethodBeat.o(64419);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(64419);
  }
  
  public final boolean ctP()
  {
    return false;
  }
  
  public final Map<String, String> ctX()
  {
    return null;
  }
  
  public final boolean cuo()
  {
    AppMethodBeat.i(64411);
    boolean bool1;
    boolean bool3;
    int i;
    if (ae.fFA.fDR == 1)
    {
      bool1 = true;
      bool3 = ae.fFC.dAy;
      int[] arrayOfInt = com.a.a.a.yE();
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
  
  public final boolean cup()
  {
    AppMethodBeat.i(64412);
    if ((cuo()) && (com.tencent.mm.plugin.fingerprint.b.d.cuh()) && (com.tencent.mm.plugin.fingerprint.b.d.cui()))
    {
      AppMethodBeat.o(64412);
      return true;
    }
    AppMethodBeat.o(64412);
    return false;
  }
  
  public final boolean cuq()
  {
    AppMethodBeat.i(64414);
    cuw();
    if (this.rcC == null)
    {
      AppMethodBeat.o(64414);
      return false;
    }
    int[] arrayOfInt = this.rcC.yD();
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0)) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HuaweiBiometricPayManagerImpl", "ids is null");
    }
    try
    {
      this.rcC.release();
      label58:
      this.rcC = null;
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
      break label58;
    }
  }
  
  public final boolean cur()
  {
    return false;
  }
  
  public final boolean cus()
  {
    return false;
  }
  
  public final int cut()
  {
    return 1;
  }
  
  public final com.tencent.mm.plugin.fingerprint.d.d cuu()
  {
    AppMethodBeat.i(64420);
    com.tencent.mm.plugin.fingerprint.b.g localg = new com.tencent.mm.plugin.fingerprint.b.g();
    AppMethodBeat.o(64420);
    return localg;
  }
  
  public final boolean cuv()
  {
    return true;
  }
  
  public final boolean eO(Context paramContext)
  {
    AppMethodBeat.i(64413);
    boolean bool = cup();
    AppMethodBeat.o(64413);
    return bool;
  }
  
  public final boolean eP(Context paramContext)
  {
    return false;
  }
  
  public final void p(Object... paramVarArgs)
  {
    AppMethodBeat.i(64416);
    String str = com.tencent.mm.plugin.fingerprint.b.d.getUserId();
    if (com.tencent.mm.plugin.fingerprint.b.d.ctW()) {
      FingerPrintAuth.clearData(com.tencent.mm.plugin.fingerprint.b.d.eM(aj.getContext()), str, ((Integer)paramVarArgs[0]).intValue());
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "clear fingerprint data id:" + str + " clear_rsa_key_level:" + paramVarArgs[0]);
      AppMethodBeat.o(64416);
      return;
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HuaweiBiometricPayManagerImpl", "device is not support FingerPrintAuth");
    }
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
        if (!com.tencent.mm.plugin.fingerprint.b.d.cuh()) {}
        try
        {
          h.a(h.this, aj.getContext());
          if (com.tencent.mm.plugin.fingerprint.b.d.cui()) {}
        }
        catch (Exception localException)
        {
          try
          {
            com.tencent.mm.plugin.fingerprint.a.class.getClassLoader();
            if (!TextUtils.isEmpty(j.pp("teec")))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HuaweiBiometricPayManagerImpl", "LoadLibrary fingerprintauth.so, find the libteec so");
              j.pq("fingerprintauth");
              com.tencent.mm.plugin.fingerprint.b.d.lt(true);
            }
            for (;;)
            {
              h.cux();
              AppMethodBeat.o(64405);
              return;
              localException = localException;
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.HuaweiBiometricPayManagerImpl", localException, "", new Object[0]);
              com.tencent.mm.plugin.fingerprint.b.d.ls(false);
              break;
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HuaweiBiometricPayManagerImpl", "can not LoadLibrary fingerprintauth.so, because can not find the libteec");
              com.tencent.mm.plugin.fingerprint.b.d.lt(false);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.HuaweiBiometricPayManagerImpl", localThrowable, "", new Object[0]);
              com.tencent.mm.plugin.fingerprint.b.d.lt(false);
            }
          }
        }
      }
    }, getClass().getName());
    AppMethodBeat.o(64410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.h
 * JD-Core Version:    0.7.0.1
 */