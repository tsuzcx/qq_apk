package com.tencent.mm.plugin.fingerprint.mgr.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.c.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.deviceinfo.t;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Map;

public final class h
  extends a
{
  private com.huawei.c.a Hgz;
  
  private com.huawei.c.a ftY()
  {
    AppMethodBeat.i(64415);
    this.Hgz = com.huawei.c.a.aki();
    com.huawei.c.a locala = this.Hgz;
    AppMethodBeat.o(64415);
    return locala;
  }
  
  public final void a(Context paramContext, final f paramf, final b paramb)
  {
    AppMethodBeat.i(64418);
    Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "request fingerprint authorize: %s", new Object[] { paramf.hAT });
    if (this.Hgz == null)
    {
      Log.d("MicroMsg.HuaweiBiometricPayManagerImpl", "open auth once");
      ftY();
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
            paramb.a(c.ar(paramf.hAT, -1, -1));
          }
          AppMethodBeat.o(64409);
          return;
        }
        int[] arrayOfInt = locala.akj();
        if ((locala.a(new a.b()
        {
          public final void V(int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
          {
            AppMethodBeat.i(64408);
            Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "on result: %s, %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3), Integer.valueOf(-1) });
            if (h.3.this.HgD != null) {
              h.3.this.HgD.a(c.ar(h.3.this.HgE.hAT, paramAnonymous2Int1, paramAnonymous2Int2));
            }
            AppMethodBeat.o(64408);
          }
          
          public final void cV(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(64407);
            Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "on status: %s, %s, %s", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(-1) });
            AppMethodBeat.o(64407);
          }
        }, arrayOfInt) != 0) && (paramb != null)) {
          paramb.a(c.ar(paramf.hAT, -1, -1));
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
      private int HgB;
      
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
        int j = i - this.HgB;
        if (j > 0)
        {
          paramAnonymousc.retryCount += 1;
          this.HgB = i;
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
    if (this.Hgz != null) {
      try
      {
        this.Hgz.Fw();
        this.Hgz.release();
        AppMethodBeat.o(64419);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(64419);
  }
  
  public final Map<String, String> ftA()
  {
    return null;
  }
  
  public final boolean ftR()
  {
    AppMethodBeat.i(64412);
    if ((isSupport()) && (com.tencent.mm.plugin.fingerprint.mgr.c.ftK()) && (com.tencent.mm.plugin.fingerprint.mgr.c.ftL()))
    {
      AppMethodBeat.o(64412);
      return true;
    }
    AppMethodBeat.o(64412);
    return false;
  }
  
  public final boolean ftS()
  {
    AppMethodBeat.i(64414);
    ftY();
    if (this.Hgz == null)
    {
      AppMethodBeat.o(64414);
      return false;
    }
    int[] arrayOfInt = this.Hgz.akj();
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0)) {
      Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "ids is null");
    }
    try
    {
      this.Hgz.release();
      label55:
      this.Hgz = null;
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
  
  public final boolean ftT()
  {
    return false;
  }
  
  public final boolean ftU()
  {
    return false;
  }
  
  public final int ftV()
  {
    return 1;
  }
  
  public final com.tencent.mm.plugin.fingerprint.c.d ftW()
  {
    AppMethodBeat.i(64420);
    com.tencent.mm.plugin.fingerprint.mgr.d locald = new com.tencent.mm.plugin.fingerprint.mgr.d();
    AppMethodBeat.o(64420);
    return locald;
  }
  
  public final boolean ftX()
  {
    return true;
  }
  
  public final boolean fts()
  {
    return false;
  }
  
  public final boolean hC(Context paramContext)
  {
    AppMethodBeat.i(64413);
    boolean bool = ftR();
    AppMethodBeat.o(64413);
    return bool;
  }
  
  public final boolean hD(Context paramContext)
  {
    return false;
  }
  
  public final boolean isSupport()
  {
    AppMethodBeat.i(64411);
    boolean bool1;
    boolean bool3;
    int i;
    if (af.lYc.lWo == 1)
    {
      bool1 = true;
      bool3 = af.lYe.idL;
      int[] arrayOfInt = com.huawei.c.a.akk();
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
    if (((com.tencent.mm.plugin.fingerprint.c.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.fingerprint.c.a.class)).type() != 1)
    {
      Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "set soter manager");
      com.tencent.mm.plugin.fingerprint.mgr.b localb = new com.tencent.mm.plugin.fingerprint.mgr.b();
      localb.a(this);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.fingerprint.c.a.class, localb);
    }
    if (q.awm())
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
        if (!com.tencent.mm.plugin.fingerprint.mgr.c.ftK()) {}
        try
        {
          h.a(h.this, MMApplicationContext.getContext());
          if (com.tencent.mm.plugin.fingerprint.mgr.c.ftL()) {}
        }
        catch (Exception localException)
        {
          try
          {
            com.tencent.mm.plugin.fingerprint.a.class.getClassLoader();
            if (!TextUtils.isEmpty(k.fX("teec")))
            {
              Log.i("MicroMsg.HuaweiBiometricPayManagerImpl", "LoadLibrary fingerprintauth.so, find the libteec so");
              k.DA("fingerprintauth");
              com.tencent.mm.plugin.fingerprint.mgr.c.vy(true);
            }
            for (;;)
            {
              h.ftZ();
              AppMethodBeat.o(64405);
              return;
              localException = localException;
              Log.printErrStackTrace("MicroMsg.HuaweiBiometricPayManagerImpl", localException, "", new Object[0]);
              com.tencent.mm.plugin.fingerprint.mgr.c.vx(false);
              break;
              Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "can not LoadLibrary fingerprintauth.so, because can not find the libteec");
              com.tencent.mm.plugin.fingerprint.mgr.c.vy(false);
            }
          }
          finally
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.HuaweiBiometricPayManagerImpl", localThrowable, "", new Object[0]);
              com.tencent.mm.plugin.fingerprint.mgr.c.vy(false);
            }
          }
        }
      }
    }, getClass().getName());
    AppMethodBeat.o(64410);
  }
  
  public final void s(Object... paramVarArgs)
  {
    AppMethodBeat.i(64416);
    if (paramVarArgs.length <= 0)
    {
      Log.e("MicroMsg.HuaweiBiometricPayManagerImpl", "hy: param incorrect");
      AppMethodBeat.o(64416);
      return;
    }
    String str = com.tencent.mm.plugin.fingerprint.mgr.c.getUserId();
    if (com.tencent.mm.plugin.fingerprint.mgr.c.ftz()) {
      FingerPrintAuth.clearData(com.tencent.mm.plugin.fingerprint.mgr.c.hA(MMApplicationContext.getContext()), str, ((Integer)paramVarArgs[0]).intValue());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.mgr.a.h
 * JD-Core Version:    0.7.0.1
 */