package com.tencent.mm.plugin.fcm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class b
  implements i
{
  @SuppressLint({"StaticFieldLeak"})
  private static b tnB;
  private static volatile boolean tnC = false;
  private final Context context;
  private int tnD;
  
  private b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static b cXf()
  {
    AppMethodBeat.i(127566);
    Object localObject1;
    if (tnB != null)
    {
      localObject1 = tnB;
      AppMethodBeat.o(127566);
      return localObject1;
    }
    try
    {
      if (tnB != null)
      {
        localObject1 = tnB;
        return localObject1;
      }
      localObject1 = MMApplicationContext.getContext();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.FCM.FcmRegister", "FCM appcontext null");
        return null;
      }
      localObject1 = new b((Context)localObject1);
      tnB = (b)localObject1;
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(127566);
    }
  }
  
  private SharedPreferences cXk()
  {
    AppMethodBeat.i(127573);
    SharedPreferences localSharedPreferences = this.context.getSharedPreferences(b.class.getSimpleName(), 0);
    AppMethodBeat.o(127573);
    return localSharedPreferences;
  }
  
  private void mL(boolean paramBoolean)
  {
    AppMethodBeat.i(127572);
    Object localObject = cXk();
    Log.i("MicroMsg.FCM.FcmRegister", "Saving regSvrResult: ".concat(String.valueOf(paramBoolean)));
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("isRegToSvr", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    if (paramBoolean)
    {
      this.tnD = a.azs();
      AppMethodBeat.o(127572);
      return;
    }
    this.tnD = 0;
    AppMethodBeat.o(127572);
  }
  
  public final void asA(String paramString)
  {
    AppMethodBeat.i(127570);
    Log.i("MicroMsg.FCM.FcmRegister", "register token to svr: %s", new Object[] { paramString });
    e.Cxv.idkeyStat(901L, 11L, 1L, false);
    if (Util.isNullOrNil(paramString))
    {
      e.Cxv.idkeyStat(901L, 13L, 1L, false);
      Log.e("MicroMsg.FCM.FcmRegister", "token is null, fail reg");
      AppMethodBeat.o(127570);
      return;
    }
    if (this.tnD == a.azs())
    {
      e.Cxv.idkeyStat(901L, 12L, 1L, false);
      Log.w("MicroMsg.FCM.FcmRegister", "have registered yet.");
      AppMethodBeat.o(127570);
      return;
    }
    paramString = new c(paramString);
    g.aAi();
    g.aAg().hqi.a(paramString.getType(), this);
    g.aAi();
    g.aAg().hqi.a(paramString, 0);
    e.Cxv.idkeyStat(901L, 14L, 1L, false);
    AppMethodBeat.o(127570);
  }
  
  /* Error */
  final boolean cXg()
  {
    // Byte code:
    //   0: ldc 197
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 21	com/tencent/mm/plugin/fcm/b:tnC	Z
    //   8: ifne +36 -> 44
    //   11: aload_0
    //   12: monitorenter
    //   13: getstatic 21	com/tencent/mm/plugin/fcm/b:tnC	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +24 -> 42
    //   21: aload_0
    //   22: getfield 28	com/tencent/mm/plugin/fcm/b:context	Landroid/content/Context;
    //   25: invokestatic 203	com/google/firebase/a:al	(Landroid/content/Context;)Lcom/google/firebase/a;
    //   28: pop
    //   29: invokestatic 209	com/google/firebase/messaging/a:yz	()Lcom/google/firebase/messaging/a;
    //   32: getfield 213	com/google/firebase/messaging/a:bLY	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   35: invokevirtual 218	com/google/firebase/iid/FirebaseInstanceId:yl	()V
    //   38: iconst_1
    //   39: putstatic 21	com/tencent/mm/plugin/fcm/b:tnC	Z
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
    //   61: invokestatic 224	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   0	83	0	this	b
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
  
  final boolean cXh()
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
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.FCM.FcmRegister", localThrowable.toString());
      AppMethodBeat.o(127568);
      return false;
    }
    AppMethodBeat.o(127568);
    return true;
  }
  
  final void cXi()
  {
    AppMethodBeat.i(127569);
    e.Cxv.idkeyStat(901L, 18L, 1L, false);
    Object localObject = null;
    if (cXg()) {
      localObject = FirebaseInstanceId.yc().getToken();
    }
    if (Util.isNullOrNil((String)localObject))
    {
      e.Cxv.idkeyStat(901L, 19L, 1L, false);
      Log.w("MicroMsg.FCM.FcmRegister", "unreg fail, token is null");
      AppMethodBeat.o(127569);
      return;
    }
    mL(false);
    localObject = new d((String)localObject);
    g.aAi();
    g.aAg().hqi.a(((d)localObject).getType(), this);
    g.aAi();
    g.aAg().hqi.a((q)localObject, 0);
    e.Cxv.idkeyStat(901L, 21L, 1L, false);
    AppMethodBeat.o(127569);
  }
  
  public final boolean cXj()
  {
    AppMethodBeat.i(127571);
    boolean bool = cXk().getBoolean("isRegToSvr", false);
    AppMethodBeat.o(127571);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool = false;
    AppMethodBeat.i(127574);
    if (paramq == null)
    {
      AppMethodBeat.o(127574);
      return;
    }
    if ((paramq instanceof c))
    {
      g.aAi();
      g.aAg().hqi.a(((c)paramq).getType(), this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg success.");
        e.Cxv.idkeyStat(901L, 16L, 1L, false);
        bool = true;
      }
      for (;;)
      {
        mL(bool);
        AppMethodBeat.o(127574);
        return;
        Log.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg faild.");
        e.Cxv.idkeyStat(901L, 17L, 1L, false);
      }
    }
    if ((paramq instanceof d))
    {
      g.aAi();
      g.aAg().hqi.a(((d)paramq).getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label194;
      }
      Log.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg success.");
      e.Cxv.idkeyStat(901L, 23L, 1L, false);
    }
    for (;;)
    {
      mL(false);
      AppMethodBeat.o(127574);
      return;
      label194:
      Log.e("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg faild.");
      e.Cxv.idkeyStat(901L, 24L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.b
 * JD-Core Version:    0.7.0.1
 */