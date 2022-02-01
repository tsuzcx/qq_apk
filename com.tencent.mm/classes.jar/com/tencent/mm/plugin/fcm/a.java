package com.tencent.mm.plugin.fcm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public class a
  implements com.tencent.mm.ak.g
{
  @SuppressLint({"StaticFieldLeak"})
  private static a qVn;
  private static volatile boolean qVo = false;
  private final Context context;
  private int qVp;
  
  private a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static a crO()
  {
    AppMethodBeat.i(127566);
    Object localObject1;
    if (qVn != null)
    {
      localObject1 = qVn;
      AppMethodBeat.o(127566);
      return localObject1;
    }
    try
    {
      if (qVn != null)
      {
        localObject1 = qVn;
        return localObject1;
      }
      localObject1 = ai.getContext();
      if (localObject1 == null)
      {
        ac.e("MicroMsg.FCM.FcmRegister", "FCM appcontext null");
        return null;
      }
      localObject1 = new a((Context)localObject1);
      qVn = (a)localObject1;
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(127566);
    }
  }
  
  private SharedPreferences crT()
  {
    AppMethodBeat.i(127573);
    SharedPreferences localSharedPreferences = this.context.getSharedPreferences(a.class.getSimpleName(), 0);
    AppMethodBeat.o(127573);
    return localSharedPreferences;
  }
  
  private void lq(boolean paramBoolean)
  {
    AppMethodBeat.i(127572);
    Object localObject = crT();
    ac.i("MicroMsg.FCM.FcmRegister", "Saving regSvrResult: ".concat(String.valueOf(paramBoolean)));
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("isRegToSvr", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    if (paramBoolean)
    {
      this.qVp = com.tencent.mm.kernel.a.agb();
      AppMethodBeat.o(127572);
      return;
    }
    this.qVp = 0;
    AppMethodBeat.o(127572);
  }
  
  public final void adf(String paramString)
  {
    AppMethodBeat.i(127570);
    ac.i("MicroMsg.FCM.FcmRegister", "register token to svr: %s", new Object[] { paramString });
    e.wTc.idkeyStat(901L, 11L, 1L, false);
    if (bs.isNullOrNil(paramString))
    {
      e.wTc.idkeyStat(901L, 13L, 1L, false);
      ac.e("MicroMsg.FCM.FcmRegister", "token is null, fail reg");
      AppMethodBeat.o(127570);
      return;
    }
    if (this.qVp == com.tencent.mm.kernel.a.agb())
    {
      e.wTc.idkeyStat(901L, 12L, 1L, false);
      ac.w("MicroMsg.FCM.FcmRegister", "have registered yet.");
      AppMethodBeat.o(127570);
      return;
    }
    paramString = new b(paramString);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString.getType(), this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
    e.wTc.idkeyStat(901L, 14L, 1L, false);
    AppMethodBeat.o(127570);
  }
  
  /* Error */
  final boolean crP()
  {
    // Byte code:
    //   0: ldc 197
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 21	com/tencent/mm/plugin/fcm/a:qVo	Z
    //   8: ifne +36 -> 44
    //   11: aload_0
    //   12: monitorenter
    //   13: getstatic 21	com/tencent/mm/plugin/fcm/a:qVo	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +24 -> 42
    //   21: aload_0
    //   22: getfield 28	com/tencent/mm/plugin/fcm/a:context	Landroid/content/Context;
    //   25: invokestatic 203	com/google/firebase/a:aj	(Landroid/content/Context;)Lcom/google/firebase/a;
    //   28: pop
    //   29: invokestatic 209	com/google/firebase/messaging/a:wU	()Lcom/google/firebase/messaging/a;
    //   32: getfield 213	com/google/firebase/messaging/a:bBu	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   35: invokevirtual 218	com/google/firebase/iid/FirebaseInstanceId:wG	()V
    //   38: iconst_1
    //   39: putstatic 21	com/tencent/mm/plugin/fcm/a:qVo	Z
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
    //   61: invokestatic 224	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  final boolean crQ()
  {
    AppMethodBeat.i(127568);
    try
    {
      if (Build.VERSION.SDK_INT < 14)
      {
        ac.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = version < 14");
        AppMethodBeat.o(127568);
        return false;
      }
      int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.context);
      if (i != 0)
      {
        ac.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = ".concat(String.valueOf(i)));
        AppMethodBeat.o(127568);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.FCM.FcmRegister", localThrowable.toString());
      AppMethodBeat.o(127568);
      return false;
    }
    AppMethodBeat.o(127568);
    return true;
  }
  
  final void crR()
  {
    AppMethodBeat.i(127569);
    e.wTc.idkeyStat(901L, 18L, 1L, false);
    Object localObject = null;
    if (crP()) {
      localObject = FirebaseInstanceId.wx().getToken();
    }
    if (bs.isNullOrNil((String)localObject))
    {
      e.wTc.idkeyStat(901L, 19L, 1L, false);
      ac.w("MicroMsg.FCM.FcmRegister", "unreg fail, token is null");
      AppMethodBeat.o(127569);
      return;
    }
    lq(false);
    localObject = new c((String)localObject);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(((c)localObject).getType(), this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
    e.wTc.idkeyStat(901L, 21L, 1L, false);
    AppMethodBeat.o(127569);
  }
  
  public final boolean crS()
  {
    AppMethodBeat.i(127571);
    boolean bool = crT().getBoolean("isRegToSvr", false);
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
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(((b)paramn).getType(), this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ac.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg success.");
        e.wTc.idkeyStat(901L, 16L, 1L, false);
        bool = true;
      }
      for (;;)
      {
        lq(bool);
        AppMethodBeat.o(127574);
        return;
        ac.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg faild.");
        e.wTc.idkeyStat(901L, 17L, 1L, false);
      }
    }
    if ((paramn instanceof c))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(((c)paramn).getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label194;
      }
      ac.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg success.");
      e.wTc.idkeyStat(901L, 23L, 1L, false);
    }
    for (;;)
    {
      lq(false);
      AppMethodBeat.o(127574);
      return;
      label194:
      ac.e("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg faild.");
      e.wTc.idkeyStat(901L, 24L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.a
 * JD-Core Version:    0.7.0.1
 */