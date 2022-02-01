package com.tencent.mm.plugin.fcm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public class a
  implements f
{
  @SuppressLint({"StaticFieldLeak"})
  private static a rFB;
  private static volatile boolean rFC = false;
  private final Context context;
  private int rFD;
  
  private a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static a cxA()
  {
    AppMethodBeat.i(127566);
    Object localObject1;
    if (rFB != null)
    {
      localObject1 = rFB;
      AppMethodBeat.o(127566);
      return localObject1;
    }
    try
    {
      if (rFB != null)
      {
        localObject1 = rFB;
        return localObject1;
      }
      localObject1 = aj.getContext();
      if (localObject1 == null)
      {
        ad.e("MicroMsg.FCM.FcmRegister", "FCM appcontext null");
        return null;
      }
      localObject1 = new a((Context)localObject1);
      rFB = (a)localObject1;
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(127566);
    }
  }
  
  private SharedPreferences cxF()
  {
    AppMethodBeat.i(127573);
    SharedPreferences localSharedPreferences = this.context.getSharedPreferences(a.class.getSimpleName(), 0);
    AppMethodBeat.o(127573);
    return localSharedPreferences;
  }
  
  private void lJ(boolean paramBoolean)
  {
    AppMethodBeat.i(127572);
    Object localObject = cxF();
    ad.i("MicroMsg.FCM.FcmRegister", "Saving regSvrResult: ".concat(String.valueOf(paramBoolean)));
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("isRegToSvr", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    if (paramBoolean)
    {
      this.rFD = com.tencent.mm.kernel.a.aiN();
      AppMethodBeat.o(127572);
      return;
    }
    this.rFD = 0;
    AppMethodBeat.o(127572);
  }
  
  public final void agU(String paramString)
  {
    AppMethodBeat.i(127570);
    ad.i("MicroMsg.FCM.FcmRegister", "register token to svr: %s", new Object[] { paramString });
    e.ygI.idkeyStat(901L, 11L, 1L, false);
    if (bt.isNullOrNil(paramString))
    {
      e.ygI.idkeyStat(901L, 13L, 1L, false);
      ad.e("MicroMsg.FCM.FcmRegister", "token is null, fail reg");
      AppMethodBeat.o(127570);
      return;
    }
    if (this.rFD == com.tencent.mm.kernel.a.aiN())
    {
      e.ygI.idkeyStat(901L, 12L, 1L, false);
      ad.w("MicroMsg.FCM.FcmRegister", "have registered yet.");
      AppMethodBeat.o(127570);
      return;
    }
    paramString = new b(paramString);
    g.ajD();
    g.ajB().gAO.a(paramString.getType(), this);
    g.ajD();
    g.ajB().gAO.a(paramString, 0);
    e.ygI.idkeyStat(901L, 14L, 1L, false);
    AppMethodBeat.o(127570);
  }
  
  /* Error */
  final boolean cxB()
  {
    // Byte code:
    //   0: ldc 197
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 21	com/tencent/mm/plugin/fcm/a:rFC	Z
    //   8: ifne +36 -> 44
    //   11: aload_0
    //   12: monitorenter
    //   13: getstatic 21	com/tencent/mm/plugin/fcm/a:rFC	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +24 -> 42
    //   21: aload_0
    //   22: getfield 28	com/tencent/mm/plugin/fcm/a:context	Landroid/content/Context;
    //   25: invokestatic 203	com/google/firebase/a:aj	(Landroid/content/Context;)Lcom/google/firebase/a;
    //   28: pop
    //   29: invokestatic 209	com/google/firebase/messaging/a:yr	()Lcom/google/firebase/messaging/a;
    //   32: getfield 213	com/google/firebase/messaging/a:bLI	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   35: invokevirtual 218	com/google/firebase/iid/FirebaseInstanceId:yd	()V
    //   38: iconst_1
    //   39: putstatic 21	com/tencent/mm/plugin/fcm/a:rFC	Z
    //   42: aload_0
    //   43: monitorexit
    //   44: ldc 197
    //   46: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iconst_1
    //   50: ireturn
    //   51: astore_2
    //   52: ldc 50
    //   54: aload_2
    //   55: ldc 220
    //   57: iconst_0
    //   58: anewarray 4	java/lang/Object
    //   61: invokestatic 224	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_0
    //   65: monitorexit
    //   66: ldc 197
    //   68: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: iconst_0
    //   72: ireturn
    //   73: astore_2
    //   74: aload_0
    //   75: monitorexit
    //   76: ldc 197
    //   78: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	a
    //   16	2	1	bool	boolean
    //   51	4	2	localThrowable	Throwable
    //   73	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	42	51	java/lang/Throwable
    //   13	17	73	finally
    //   21	42	73	finally
    //   42	44	73	finally
    //   52	66	73	finally
    //   74	76	73	finally
  }
  
  final boolean cxC()
  {
    AppMethodBeat.i(127568);
    try
    {
      if (Build.VERSION.SDK_INT < 14)
      {
        ad.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = version < 14");
        AppMethodBeat.o(127568);
        return false;
      }
      int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.context);
      if (i != 0)
      {
        ad.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = ".concat(String.valueOf(i)));
        AppMethodBeat.o(127568);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.FCM.FcmRegister", localThrowable.toString());
      AppMethodBeat.o(127568);
      return false;
    }
    AppMethodBeat.o(127568);
    return true;
  }
  
  final void cxD()
  {
    AppMethodBeat.i(127569);
    e.ygI.idkeyStat(901L, 18L, 1L, false);
    Object localObject = null;
    if (cxB()) {
      localObject = FirebaseInstanceId.xU().getToken();
    }
    if (bt.isNullOrNil((String)localObject))
    {
      e.ygI.idkeyStat(901L, 19L, 1L, false);
      ad.w("MicroMsg.FCM.FcmRegister", "unreg fail, token is null");
      AppMethodBeat.o(127569);
      return;
    }
    lJ(false);
    localObject = new c((String)localObject);
    g.ajD();
    g.ajB().gAO.a(((c)localObject).getType(), this);
    g.ajD();
    g.ajB().gAO.a((n)localObject, 0);
    e.ygI.idkeyStat(901L, 21L, 1L, false);
    AppMethodBeat.o(127569);
  }
  
  public final boolean cxE()
  {
    AppMethodBeat.i(127571);
    boolean bool = cxF().getBoolean("isRegToSvr", false);
    AppMethodBeat.o(127571);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = false;
    AppMethodBeat.i(127574);
    if (paramn == null)
    {
      AppMethodBeat.o(127574);
      return;
    }
    if ((paramn instanceof b))
    {
      g.ajD();
      g.ajB().gAO.a(((b)paramn).getType(), this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ad.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg success.");
        e.ygI.idkeyStat(901L, 16L, 1L, false);
        bool = true;
      }
      for (;;)
      {
        lJ(bool);
        AppMethodBeat.o(127574);
        return;
        ad.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg faild.");
        e.ygI.idkeyStat(901L, 17L, 1L, false);
      }
    }
    if ((paramn instanceof c))
    {
      g.ajD();
      g.ajB().gAO.a(((c)paramn).getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label194;
      }
      ad.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg success.");
      e.ygI.idkeyStat(901L, 23L, 1L, false);
    }
    for (;;)
    {
      lJ(false);
      AppMethodBeat.o(127574);
      return;
      label194:
      ad.e("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg faild.");
      e.ygI.idkeyStat(901L, 24L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.a
 * JD-Core Version:    0.7.0.1
 */