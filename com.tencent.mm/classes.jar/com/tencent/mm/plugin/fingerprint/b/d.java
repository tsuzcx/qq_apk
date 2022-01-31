package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.s;
import com.tencent.mm.compatible.e.x;
import com.tencent.mm.h.a.ll;
import com.tencent.mm.h.a.ll.a;
import com.tencent.mm.h.a.ll.b;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.soter.e.b;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.pluginsdk.wallet.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.u;
import java.util.Map;

public final class d
  extends a
{
  private com.c.a.a kkY = null;
  private d.a kkZ = new d.a(this, (byte)0);
  private com.tencent.mm.pluginsdk.wallet.c kla = null;
  
  public static void aSI()
  {
    y.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey");
    if (!e.aSK())
    {
      y.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
      return;
    }
    if ((o.bVs().bVK()) || (o.bVs().bVO()))
    {
      y.e("MicroMsg.FingerPrintMgrImpl", "user had not reg wxpay or is isSimpleReg");
      return;
    }
    try
    {
      Object localObject = e.getUserId();
      y.i("MicroMsg.FingerPrintMgrImpl", "initRsaKey userId:" + (String)localObject);
      String str = q.zg();
      str = FingerPrintAuth.getRsaKey(e.dj(com.tencent.mm.sdk.platformtools.ae.getContext()), (String)localObject, str);
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        y.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.getRsaKey() is null");
        localObject = FingerPrintAuth.genRsaKey(e.dj(com.tencent.mm.sdk.platformtools.ae.getContext()), e.getUserId(), q.zg());
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        y.e("MicroMsg.FingerPrintMgrImpl", "FingerPrintAuth.genRsaKey() return null");
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      y.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + localUnsatisfiedLinkError.getMessage());
      return;
      y.e("MicroMsg.FingerPrintMgrImpl", "initRsaKey success!");
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", localException, "", new Object[0]);
      y.e("MicroMsg.FingerPrintMgrImpl", "can not LoadLibrary fingerprintauth.so e:=" + localException.getMessage());
    }
  }
  
  public static void di(Context paramContext)
  {
    y.i("MicroMsg.FingerPrintMgrImpl", "initTASecureWorld");
    if (!c.aSB())
    {
      y.e("MicroMsg.FingerPrintMgrImpl", "device is not support");
      return;
    }
    if (e.dk(paramContext) != 0)
    {
      e.gi(false);
      y.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets failed!");
      return;
    }
    e.gi(true);
    y.e("MicroMsg.FingerPrintMgrImpl", "copyTAFromAssets success!");
  }
  
  private int[] oS()
  {
    if (this.kkY != null) {
      return this.kkY.oS();
    }
    y.i("MicroMsg.FingerPrintMgrImpl", "getIds auth == null");
    return null;
  }
  
  public final int a(com.tencent.mm.pluginsdk.wallet.c paramc)
  {
    return 0;
  }
  
  public final int a(com.tencent.mm.pluginsdk.wallet.c paramc, boolean paramBoolean)
  {
    if (this.kkY == null) {
      this.kkY = com.c.a.a.oR();
    }
    if (this.kkY != null)
    {
      this.kla = paramc;
      this.kkY = com.c.a.a.oR();
      paramc = oS();
      return this.kkY.a(this.kkZ, paramc);
    }
    return -1;
  }
  
  public final void a(ll paramll, int paramInt)
  {
    String str1;
    String str2;
    Object localObject;
    if (paramll != null)
    {
      str1 = paramll.bUv.bOT;
      str2 = e.getUserId();
      localObject = q.zg();
      String str3 = u.cMz();
      str1 = FingerPrintAuth.genPayFPEncrypt(e.dj(com.tencent.mm.sdk.platformtools.ae.getContext()), str2, (String)localObject, String.valueOf(paramInt), str3, str1, Build.MODEL);
      str2 = FingerPrintAuth.genOpenFPSign(e.dj(com.tencent.mm.sdk.platformtools.ae.getContext()), e.getUserId(), q.zg(), str1);
      if (TextUtils.isEmpty(str1)) {
        break label184;
      }
      y.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
      label83:
      if (TextUtils.isEmpty(str2)) {
        break label194;
      }
      y.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
    }
    for (;;)
    {
      y.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
      if ((paramll != null) && (paramll.bUv.bUz != null))
      {
        localObject = new ll.b();
        ((ll.b)localObject).bUB = 1;
        ((ll.b)localObject).errCode = 0;
        ((ll.b)localObject).bOU = str1;
        ((ll.b)localObject).bOV = str2;
        ((ll.b)localObject).bOS = paramInt;
        paramll.bUw = ((ll.b)localObject);
        paramll.bUv.bUz.run();
      }
      return;
      str1 = "";
      break;
      label184:
      y.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_info!");
      break label83;
      label194:
      y.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_sign!");
    }
  }
  
  public final boolean a(boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    return false;
  }
  
  public final void aSC()
  {
    aSM();
    aSL();
  }
  
  public final j aSE()
  {
    return new h();
  }
  
  public final boolean aSF()
  {
    int[] arrayOfInt = com.c.a.a.oT();
    boolean bool1;
    label29:
    boolean bool2;
    if (arrayOfInt != null)
    {
      i = 0;
      if (i < arrayOfInt.length) {
        if (1 == arrayOfInt[i])
        {
          bool1 = true;
          if (q.dyh.dyq != 1) {
            break label112;
          }
          bool2 = true;
          label41:
          if ((q.dyj == null) || (q.dyj.dyQ != 11)) {
            break label117;
          }
        }
      }
    }
    label112:
    label117:
    for (int i = 1;; i = 0)
    {
      y.i("MicroMsg.FingerPrintMgrImpl", "hy: is hardware support: %b, is config support : %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((!bool1) || (!bool2) || (i != 0)) {
        break label122;
      }
      return true;
      i += 1;
      break;
      bool1 = false;
      break label29;
      bool2 = false;
      break label41;
    }
    label122:
    return false;
  }
  
  public final boolean aSG()
  {
    this.kkY = com.c.a.a.oR();
    int[] arrayOfInt = oS();
    if ((arrayOfInt == null) || (arrayOfInt.length <= 0)) {
      y.e("MicroMsg.FingerPrintMgrImpl", "ids is null");
    }
    aSL();
    return (arrayOfInt != null) && (arrayOfInt.length > 0);
  }
  
  public final void aSH()
  {
    y.i("MicroMsg.FingerPrintMgrImpl", "initFP");
    if (q.dyj.cbb)
    {
      y.i("MicroMsg.FingerPrintMgrImpl", "IFingerPrintMgr is not SoterAuthMgrImp but the device is in white list of SOTER, recheck it!");
      b.a(false, false, new d.1(this));
    }
    if (!aSF())
    {
      y.e("MicroMsg.FingerPrintMgrImpl", "device is not support fingerprintAuth");
      return;
    }
    Object localObject = o.bVs().bVR();
    if ((localObject != null) && (!((com.tencent.mm.plugin.wallet_core.model.ae)localObject).bVH()))
    {
      y.e("MicroMsg.FingerPrintMgrImpl", "isSupportTouchPay is false");
      return;
    }
    localObject = new ah(Looper.myLooper());
    y.i("MicroMsg.FingerPrintMgrImpl", "device is support fingerprintAuth");
    com.tencent.mm.sdk.f.e.post(new d.2(this, (ah)localObject), getClass().getName());
  }
  
  public final boolean aSJ()
  {
    return true;
  }
  
  public final boolean aSK()
  {
    return e.aSK();
  }
  
  /* Error */
  public final void aSL()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 25	com/tencent/mm/plugin/fingerprint/b/d:kla	Lcom/tencent/mm/pluginsdk/wallet/c;
    //   5: aload_0
    //   6: getfield 18	com/tencent/mm/plugin/fingerprint/b/d:kkY	Lcom/c/a/a;
    //   9: ifnull +104 -> 113
    //   12: aload_0
    //   13: getfield 18	com/tencent/mm/plugin/fingerprint/b/d:kkY	Lcom/c/a/a;
    //   16: astore_1
    //   17: aload_1
    //   18: getfield 378	com/c/a/a:aUS	Lcom/c/a/a$a;
    //   21: ifnull +12 -> 33
    //   24: aload_1
    //   25: getfield 378	com/c/a/a:aUS	Lcom/c/a/a$a;
    //   28: bipush 8
    //   30: invokevirtual 384	com/c/a/a$a:removeMessages	(I)V
    //   33: aload_1
    //   34: getfield 388	com/c/a/a:aUQ	Lcom/c/a/c;
    //   37: aload_1
    //   38: getfield 392	com/c/a/a:aUR	Lcom/c/a/b;
    //   41: invokeinterface 398 2 0
    //   46: aload_1
    //   47: getfield 388	com/c/a/a:aUQ	Lcom/c/a/c;
    //   50: invokeinterface 402 1 0
    //   55: aload_1
    //   56: getfield 406	com/c/a/a:aUW	Landroid/os/IBinder$DeathRecipient;
    //   59: iconst_0
    //   60: invokeinterface 412 3 0
    //   65: pop
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 18	com/tencent/mm/plugin/fingerprint/b/d:kkY	Lcom/c/a/a;
    //   71: return
    //   72: astore_1
    //   73: ldc 35
    //   75: aload_1
    //   76: ldc 131
    //   78: iconst_0
    //   79: anewarray 133	java/lang/Object
    //   82: invokestatic 137	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: ldc 35
    //   87: new 76	java/lang/StringBuilder
    //   90: dup
    //   91: ldc_w 414
    //   94: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: aload_1
    //   98: invokevirtual 138	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   101: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 43	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: goto -44 -> 66
    //   113: ldc 35
    //   115: ldc_w 416
    //   118: invokestatic 43	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: return
    //   122: astore_1
    //   123: goto -57 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	d
    //   16	40	1	locala	com.c.a.a
    //   72	26	1	localException	Exception
    //   122	1	1	localRemoteException	android.os.RemoteException
    // Exception table:
    //   from	to	target	type
    //   12	33	72	java/lang/Exception
    //   33	66	72	java/lang/Exception
    //   33	66	122	android/os/RemoteException
  }
  
  public final void aSM()
  {
    if (this.kkY != null) {}
    try
    {
      this.kkY.abort();
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.FingerPrintMgrImpl", localException, "", new Object[0]);
      y.i("MicroMsg.FingerPrintMgrImpl", "auth systemAbort occur exception e:" + localException.getMessage());
    }
  }
  
  public final void aSN()
  {
    y.e("MicroMsg.FingerPrintMgrImpl", "hy: param incorrect");
  }
  
  public final Map<String, String> aSO()
  {
    return null;
  }
  
  public final k aSP()
  {
    return null;
  }
  
  public final Map<String, String> aSQ()
  {
    return null;
  }
  
  public final boolean aSR()
  {
    return true;
  }
  
  public final boolean aSS()
  {
    return false;
  }
  
  public final boolean aST()
  {
    return false;
  }
  
  public final void dh(Context paramContext)
  {
    if (paramContext != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.android.settings.fingerprint.FingerprintSettings");
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.setFlags(268435456);
      paramContext.startActivity(localIntent);
    }
  }
  
  public final int type()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.b.d
 * JD-Core Version:    0.7.0.1
 */