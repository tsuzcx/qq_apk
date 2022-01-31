package com.tencent.mm.plugin.fingerprint.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

final class d$2
  implements Runnable
{
  d$2(d paramd, ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(41439);
    if (!e.bzu()) {}
    try
    {
      this.mFO.dT(ah.getContext());
      if (e.bzv()) {}
    }
    catch (Exception localException)
    {
      try
      {
        ClassLoader localClassLoader = a.class.getClassLoader();
        if (!TextUtils.isEmpty(k.lq("teec")))
        {
          ab.i("MicroMsg.FingerPrintMgrImpl", "LoadLibrary fingerprintauth.so, find the libteec so");
          k.a("fingerprintauth", localClassLoader);
          e.hL(true);
        }
        for (;;)
        {
          this.mFP.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41438);
              try
              {
                d.bzd();
                AppMethodBeat.o(41438);
                return;
              }
              catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
              {
                ab.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + localUnsatisfiedLinkError.getMessage());
                AppMethodBeat.o(41438);
                return;
              }
              catch (Exception localException)
              {
                ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", localException, "", new Object[0]);
                ab.e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + localException.getMessage());
                AppMethodBeat.o(41438);
              }
            }
          });
          AppMethodBeat.o(41439);
          return;
          localException = localException;
          ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", localException, "", new Object[0]);
          ab.e("MicroMsg.FingerPrintMgrImpl", "init wechat ta secure world is occur exception e=" + localException.getMessage());
          e.hK(false);
          break;
          ab.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so, because can not find the libteec");
          e.hL(false);
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          ab.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + localUnsatisfiedLinkError.getMessage());
          e.hL(false);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", localThrowable, "", new Object[0]);
          ab.e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + localThrowable.getMessage());
          e.hL(false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.d.2
 * JD-Core Version:    0.7.0.1
 */