package com.tencent.mm.plugin.fingerprint.b;

import android.text.TextUtils;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class d$2
  implements Runnable
{
  d$2(d paramd, ah paramah) {}
  
  public final void run()
  {
    if (!e.aSZ()) {}
    try
    {
      d.di(ae.getContext());
      if (e.aTa()) {}
    }
    catch (Exception localException1)
    {
      try
      {
        ClassLoader localClassLoader = a.class.getClassLoader();
        if (!TextUtils.isEmpty(k.fe("teec")))
        {
          y.i("MicroMsg.FingerPrintMgrImpl", "LoadLibrary fingerprintauth.so, find the libteec so");
          k.b("fingerprintauth", localClassLoader);
          e.gj(true);
        }
        for (;;)
        {
          this.hZR.post(new Runnable()
          {
            public final void run()
            {
              try
              {
                d.aSI();
                return;
              }
              catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
              {
                y.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + localUnsatisfiedLinkError.getMessage());
                return;
              }
              catch (Exception localException)
              {
                y.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", localException, "", new Object[0]);
                y.e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + localException.getMessage());
              }
            }
          });
          return;
          localException1 = localException1;
          y.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", localException1, "", new Object[0]);
          y.e("MicroMsg.FingerPrintMgrImpl", "init wechat ta secure world is occur exception e=" + localException1.getMessage());
          e.gi(false);
          break;
          y.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so, because can not find the libteec");
          e.gj(false);
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          y.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + localUnsatisfiedLinkError.getMessage());
          e.gj(false);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", localException2, "", new Object[0]);
          y.e("MicroMsg.FingerPrintMgrImpl", "init rsa key is occur exception e=" + localException2.getMessage());
          e.gj(false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.d.2
 * JD-Core Version:    0.7.0.1
 */