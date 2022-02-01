package com.tencent.mm.plugin.fingerprint.b.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Map;

public final class h
  extends a
{
  private com.huawei.c.a ByU;
  
  private com.huawei.c.a eoW()
  {
    AppMethodBeat.i(64415);
    this.ByU = com.huawei.c.a.Kh();
    com.huawei.c.a locala = this.ByU;
    AppMethodBeat.o(64415);
    return locala;
  }
  
  public final void a(Context paramContext, final f paramf, final b paramb)
  {
    AppMethodBeat.i(64418);
    Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "request fingerprint authorize: %s", new Object[] { paramf.fwv });
    if (this.ByU == null)
    {
      Log.d("MicroMsg.HuaweiBiometricPayManagerImpl", "open auth once");
      eoW();
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64409);
        com.huawei.c.a locala = h.a(h.this);
        if (locala == null)
        {
          if (paramb != null) {
            paramb.a(c.ak(paramf.fwv, -1, -1));
          }
          AppMethodBeat.o(64409);
          return;
        }
        int[] arrayOfInt = locala.Ki();
        if ((locala.a(new a.b()
        {
          public final void G(int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(64408);
            Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "on result: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(-1) });
            if (h.3.this.ByY != null) {
              h.3.this.ByY.a(c.ak(h.3.this.ByZ.fwv, paramAnonymous2Int1, paramAnonymous2Int2));
            }
            AppMethodBeat.o(64408);
          }
          
          public final void ci(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(64407);
            Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "on status: %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(-1) });
            AppMethodBeat.o(64407);
          }
        }, arrayOfInt) != 0) && (paramb != null)) {
          paramb.a(c.ak(paramf.fwv, -1, -1));
        }
        AppMethodBeat.o(64409);
      }
    }, 300L);
    AppMethodBeat.o(64418);
  }
  
  public final void a(Context paramContext, f paramf, final d paramd)
  {
    AppMethodBeat.i(64417);
    Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "request fingerprint authorize for pay");
    a(paramContext, paramf, new b()
    {
      private int ByW;
      
      public final void a(c paramAnonymousc)
      {
        AppMethodBeat.i(64406);
        Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "authorize pay result: %s, %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
        paramAnonymousc = e.b(paramAnonymousc);
        if (paramAnonymousc.isSuccess())
        {
          paramAnonymousc.retryCount += 1;
          paramd.onSuccess(paramAnonymousc);
          AppMethodBeat.o(64406);
          return;
        }
        int i = (int)(System.currentTimeMillis() / 1000L);
        int j = i - this.ByW;
        if (j > 0)
        {
          paramAnonymousc.retryCount += 1;
          this.ByW = i;
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
    if (this.ByU != null) {
      try
      {
        this.ByU.hL();
        this.ByU.release();
        AppMethodBeat.o(64419);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(64419);
  }
  
  public final boolean eoP()
  {
    AppMethodBeat.i(64412);
    if ((isSupport()) && (com.tencent.mm.plugin.fingerprint.b.d.eoH()) && (com.tencent.mm.plugin.fingerprint.b.d.eoI()))
    {
      AppMethodBeat.o(64412);
      return true;
    }
    AppMethodBeat.o(64412);
    return false;
  }
  
  public final boolean eoQ()
  {
    AppMethodBeat.i(64414);
    eoW();
    if (this.ByU == null)
    {
      AppMethodBeat.o(64414);
      return false;
    }
    int[] arrayOfInt = this.ByU.Ki();
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0)) {
      Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "ids is null");
    }
    try
    {
      this.ByU.release();
      label55:
      this.ByU = null;
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
  
  public final boolean eoR()
  {
    return false;
  }
  
  public final boolean eoS()
  {
    return false;
  }
  
  public final int eoT()
  {
    return 1;
  }
  
  public final com.tencent.mm.plugin.fingerprint.d.d eoU()
  {
    AppMethodBeat.i(64420);
    g localg = new g();
    AppMethodBeat.o(64420);
    return localg;
  }
  
  public final boolean eoV()
  {
    return true;
  }
  
  public final boolean eop()
  {
    return false;
  }
  
  public final Map<String, String> eox()
  {
    return null;
  }
  
  public final boolean gh(Context paramContext)
  {
    AppMethodBeat.i(64413);
    boolean bool = eoP();
    AppMethodBeat.o(64413);
    return bool;
  }
  
  public final boolean gi(Context paramContext)
  {
    return false;
  }
  
  public final boolean isSupport()
  {
    AppMethodBeat.i(64411);
    boolean bool1;
    boolean bool3;
    int i;
    if (af.juL.jsW == 1)
    {
      bool1 = true;
      bool3 = af.juN.fXK;
      int[] arrayOfInt = com.huawei.c.a.Kj();
      if (arrayOfInt == null) {
        break label120;
      }
      i = 0;
      label37:
      if (i >= arrayOfInt.length) {
        break label120;
      }
      if (1 != arrayOfInt[i]) {
        break label113;
      }
    }
    label113:
    label120:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "is support: %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!bool1) || (!bool2) || (bool3)) {
        break label125;
      }
      AppMethodBeat.o(64411);
      return true;
      bool1 = false;
      break;
      i += 1;
      break label37;
    }
    label125:
    AppMethodBeat.o(64411);
    return false;
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(64410);
    if (((com.tencent.mm.plugin.fingerprint.d.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.fingerprint.d.a.class)).type() != 1)
    {
      Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "set soter manager");
      com.tencent.mm.plugin.fingerprint.b.c localc = new com.tencent.mm.plugin.fingerprint.b.c();
      localc.a(this);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.fingerprint.d.a.class, localc);
    }
    if (q.is64BitRuntime())
    {
      Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "not support 64bit");
      AppMethodBeat.o(64410);
      return;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(64405);
        if (!com.tencent.mm.plugin.fingerprint.b.d.eoH()) {}
        try
        {
          h.a(h.this, MMApplicationContext.getContext());
          if (com.tencent.mm.plugin.fingerprint.b.d.eoI()) {}
        }
        catch (Exception localException)
        {
          try
          {
            com.tencent.mm.plugin.fingerprint.a.class.getClassLoader();
            if (!TextUtils.isEmpty(j.eA("teec")))
            {
              Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "LoadLibrary fingerprintauth.so, find the libteec so");
              j.KW("fingerprintauth");
              com.tencent.mm.plugin.fingerprint.b.d.rH(true);
            }
            for (;;)
            {
              h.eoX();
              AppMethodBeat.o(64405);
              return;
              localException = localException;
              Log.printErrStackTrace("MicroMsg.HuaweiBiometricPayManagerImpl", localException, "", new Object[0]);
              com.tencent.mm.plugin.fingerprint.b.d.rG(false);
              break;
              Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "can not LoadLibrary fingerprintauth.so, because can not find the libteec");
              com.tencent.mm.plugin.fingerprint.b.d.rH(false);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.HuaweiBiometricPayManagerImpl", localThrowable, "", new Object[0]);
              com.tencent.mm.plugin.fingerprint.b.d.rH(false);
            }
          }
        }
      }
    }, getClass().getName());
    AppMethodBeat.o(64410);
  }
  
  public final void q(Object... paramVarArgs)
  {
    AppMethodBeat.i(64416);
    if (paramVarArgs.length <= 0)
    {
      Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "hy: param incorrect");
      AppMethodBeat.o(64416);
      return;
    }
    String str = com.tencent.mm.plugin.fingerprint.b.d.getUserId();
    if (com.tencent.mm.plugin.fingerprint.b.d.eow()) {
      FingerPrintAuth.clearData(com.tencent.mm.plugin.fingerprint.b.d.gf(MMApplicationContext.getContext()), str, ((Integer)paramVarArgs[0]).intValue());
    }
    for (;;)
    {
      Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "clear fingerprint data id:" + str + " clear_rsa_key_level:" + paramVarArgs[0]);
      AppMethodBeat.o(64416);
      return;
      Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "device is not support FingerPrintAuth");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.a.h
 * JD-Core Version:    0.7.0.1
 */