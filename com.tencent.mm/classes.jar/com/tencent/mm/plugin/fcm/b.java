package com.tencent.mm.plugin.fcm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class b
  implements com.tencent.mm.am.h
{
  private static b AqC;
  private static volatile boolean AqD = false;
  private int AqE;
  private final Context context;
  
  private b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static b dTd()
  {
    AppMethodBeat.i(127566);
    Object localObject1;
    if (AqC != null)
    {
      localObject1 = AqC;
      AppMethodBeat.o(127566);
      return localObject1;
    }
    try
    {
      if (AqC != null)
      {
        localObject1 = AqC;
        return localObject1;
      }
      localObject1 = MMApplicationContext.getContext();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.FCM.FcmRegister", "FCM appcontext null");
        return null;
      }
      localObject1 = new b((Context)localObject1);
      AqC = (b)localObject1;
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(127566);
    }
  }
  
  private SharedPreferences dTi()
  {
    AppMethodBeat.i(127573);
    SharedPreferences localSharedPreferences = this.context.getSharedPreferences(b.class.getSimpleName(), 0);
    AppMethodBeat.o(127573);
    return localSharedPreferences;
  }
  
  private void pz(boolean paramBoolean)
  {
    AppMethodBeat.i(127572);
    Object localObject = dTi();
    Log.i("MicroMsg.FCM.FcmRegister", "Saving regSvrResult: ".concat(String.valueOf(paramBoolean)));
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("isRegToSvr", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    if (paramBoolean)
    {
      this.AqE = com.tencent.mm.kernel.b.aZP();
      AppMethodBeat.o(127572);
      return;
    }
    this.AqE = 0;
    AppMethodBeat.o(127572);
  }
  
  public final void auM(String paramString)
  {
    AppMethodBeat.i(127570);
    Log.i("MicroMsg.FCM.FcmRegister", "register token to svr: %s", new Object[] { paramString });
    f.Ozc.idkeyStat(901L, 11L, 1L, false);
    if (Util.isNullOrNil(paramString))
    {
      f.Ozc.idkeyStat(901L, 13L, 1L, false);
      Log.e("MicroMsg.FCM.FcmRegister", "token is null, fail reg");
      AppMethodBeat.o(127570);
      return;
    }
    if (this.AqE == com.tencent.mm.kernel.b.aZP())
    {
      f.Ozc.idkeyStat(901L, 12L, 1L, false);
      Log.w("MicroMsg.FCM.FcmRegister", "have registered yet.");
      AppMethodBeat.o(127570);
      return;
    }
    paramString = new c(paramString);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString.getType(), this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    f.Ozc.idkeyStat(901L, 14L, 1L, false);
    AppMethodBeat.o(127570);
  }
  
  /* Error */
  final boolean dTe()
  {
    // Byte code:
    //   0: ldc 192
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 18	com/tencent/mm/plugin/fcm/b:AqD	Z
    //   8: ifne +36 -> 44
    //   11: aload_0
    //   12: monitorenter
    //   13: getstatic 18	com/tencent/mm/plugin/fcm/b:AqD	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +24 -> 42
    //   21: aload_0
    //   22: getfield 25	com/tencent/mm/plugin/fcm/b:context	Landroid/content/Context;
    //   25: invokestatic 198	com/google/firebase/a:aS	(Landroid/content/Context;)Lcom/google/firebase/a;
    //   28: pop
    //   29: invokestatic 204	com/google/firebase/messaging/a:YE	()Lcom/google/firebase/messaging/a;
    //   32: getfield 208	com/google/firebase/messaging/a:dDl	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   35: invokevirtual 213	com/google/firebase/iid/FirebaseInstanceId:Yq	()V
    //   38: iconst_1
    //   39: putstatic 18	com/tencent/mm/plugin/fcm/b:AqD	Z
    //   42: aload_0
    //   43: monitorexit
    //   44: ldc 192
    //   46: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iconst_1
    //   50: ireturn
    //   51: astore_2
    //   52: ldc 47
    //   54: aload_2
    //   55: ldc 215
    //   57: iconst_0
    //   58: anewarray 4	java/lang/Object
    //   61: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_0
    //   65: monitorexit
    //   66: ldc 192
    //   68: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: iconst_0
    //   72: ireturn
    //   73: astore_2
    //   74: aload_0
    //   75: monitorexit
    //   76: ldc 192
    //   78: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_2
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	b
    //   16	2	1	bool	boolean
    //   51	4	2	localThrowable	Throwable
    //   73	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	42	51	finally
    //   13	17	73	finally
    //   52	66	73	finally
  }
  
  final boolean dTf()
  {
    AppMethodBeat.i(127568);
    try
    {
      if (Build.VERSION.SDK_INT < 14)
      {
        Log.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = version < 14");
        AppMethodBeat.o(127568);
        return false;
      }
      int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.context);
      if (i != 0)
      {
        Log.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = ".concat(String.valueOf(i)));
        AppMethodBeat.o(127568);
        return false;
      }
    }
    finally
    {
      Log.e("MicroMsg.FCM.FcmRegister", localObject.toString());
      AppMethodBeat.o(127568);
      return false;
    }
    AppMethodBeat.o(127568);
    return true;
  }
  
  final void dTg()
  {
    AppMethodBeat.i(127569);
    f.Ozc.idkeyStat(901L, 18L, 1L, false);
    Object localObject = null;
    if (dTe()) {
      localObject = FirebaseInstanceId.Yh().getToken();
    }
    if (Util.isNullOrNil((String)localObject))
    {
      f.Ozc.idkeyStat(901L, 19L, 1L, false);
      Log.w("MicroMsg.FCM.FcmRegister", "unreg fail, token is null");
      AppMethodBeat.o(127569);
      return;
    }
    pz(false);
    localObject = new d((String)localObject);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(((d)localObject).getType(), this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a((p)localObject, 0);
    f.Ozc.idkeyStat(901L, 21L, 1L, false);
    AppMethodBeat.o(127569);
  }
  
  public final boolean dTh()
  {
    AppMethodBeat.i(127571);
    boolean bool = dTi().getBoolean("isRegToSvr", false);
    AppMethodBeat.o(127571);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    boolean bool = false;
    AppMethodBeat.i(127574);
    if (paramp == null)
    {
      AppMethodBeat.o(127574);
      return;
    }
    if ((paramp instanceof c))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(((c)paramp).getType(), this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg success.");
        f.Ozc.idkeyStat(901L, 16L, 1L, false);
        bool = true;
      }
      for (;;)
      {
        pz(bool);
        AppMethodBeat.o(127574);
        return;
        Log.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg faild.");
        f.Ozc.idkeyStat(901L, 17L, 1L, false);
      }
    }
    if ((paramp instanceof d))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(((d)paramp).getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label194;
      }
      Log.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg success.");
      f.Ozc.idkeyStat(901L, 23L, 1L, false);
    }
    for (;;)
    {
      pz(false);
      AppMethodBeat.o(127574);
      return;
      label194:
      Log.e("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg faild.");
      f.Ozc.idkeyStat(901L, 24L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.b
 * JD-Core Version:    0.7.0.1
 */