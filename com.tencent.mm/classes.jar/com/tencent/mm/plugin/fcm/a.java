package com.tencent.mm.plugin.fcm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public class a
  implements f
{
  @SuppressLint({"StaticFieldLeak"})
  private static a rNM;
  private static volatile boolean rNN = false;
  private final Context context;
  private int rNO;
  
  private a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static a czb()
  {
    AppMethodBeat.i(127566);
    Object localObject1;
    if (rNM != null)
    {
      localObject1 = rNM;
      AppMethodBeat.o(127566);
      return localObject1;
    }
    try
    {
      if (rNM != null)
      {
        localObject1 = rNM;
        return localObject1;
      }
      localObject1 = ak.getContext();
      if (localObject1 == null)
      {
        ae.e("MicroMsg.FCM.FcmRegister", "FCM appcontext null");
        return null;
      }
      localObject1 = new a((Context)localObject1);
      rNM = (a)localObject1;
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(127566);
    }
  }
  
  private SharedPreferences czg()
  {
    AppMethodBeat.i(127573);
    SharedPreferences localSharedPreferences = this.context.getSharedPreferences(a.class.getSimpleName(), 0);
    AppMethodBeat.o(127573);
    return localSharedPreferences;
  }
  
  private void lJ(boolean paramBoolean)
  {
    AppMethodBeat.i(127572);
    Object localObject = czg();
    ae.i("MicroMsg.FCM.FcmRegister", "Saving regSvrResult: ".concat(String.valueOf(paramBoolean)));
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("isRegToSvr", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    if (paramBoolean)
    {
      this.rNO = com.tencent.mm.kernel.a.ajc();
      AppMethodBeat.o(127572);
      return;
    }
    this.rNO = 0;
    AppMethodBeat.o(127572);
  }
  
  public final void ahR(String paramString)
  {
    AppMethodBeat.i(127570);
    ae.i("MicroMsg.FCM.FcmRegister", "register token to svr: %s", new Object[] { paramString });
    e.ywz.idkeyStat(901L, 11L, 1L, false);
    if (bu.isNullOrNil(paramString))
    {
      e.ywz.idkeyStat(901L, 13L, 1L, false);
      ae.e("MicroMsg.FCM.FcmRegister", "token is null, fail reg");
      AppMethodBeat.o(127570);
      return;
    }
    if (this.rNO == com.tencent.mm.kernel.a.ajc())
    {
      e.ywz.idkeyStat(901L, 12L, 1L, false);
      ae.w("MicroMsg.FCM.FcmRegister", "have registered yet.");
      AppMethodBeat.o(127570);
      return;
    }
    paramString = new b(paramString);
    g.ajS();
    g.ajQ().gDv.a(paramString.getType(), this);
    g.ajS();
    g.ajQ().gDv.a(paramString, 0);
    e.ywz.idkeyStat(901L, 14L, 1L, false);
    AppMethodBeat.o(127570);
  }
  
  /* Error */
  final boolean czc()
  {
    // Byte code:
    //   0: ldc 197
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 21	com/tencent/mm/plugin/fcm/a:rNN	Z
    //   8: ifne +36 -> 44
    //   11: aload_0
    //   12: monitorenter
    //   13: getstatic 21	com/tencent/mm/plugin/fcm/a:rNN	Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +24 -> 42
    //   21: aload_0
    //   22: getfield 28	com/tencent/mm/plugin/fcm/a:context	Landroid/content/Context;
    //   25: invokestatic 203	com/google/firebase/a:ak	(Landroid/content/Context;)Lcom/google/firebase/a;
    //   28: pop
    //   29: invokestatic 209	com/google/firebase/messaging/a:yr	()Lcom/google/firebase/messaging/a;
    //   32: getfield 213	com/google/firebase/messaging/a:bLI	Lcom/google/firebase/iid/FirebaseInstanceId;
    //   35: invokevirtual 218	com/google/firebase/iid/FirebaseInstanceId:yd	()V
    //   38: iconst_1
    //   39: putstatic 21	com/tencent/mm/plugin/fcm/a:rNN	Z
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
    //   61: invokestatic 224	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  final boolean czd()
  {
    AppMethodBeat.i(127568);
    try
    {
      if (Build.VERSION.SDK_INT < 14)
      {
        ae.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = version < 14");
        AppMethodBeat.o(127568);
        return false;
      }
      int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.context);
      if (i != 0)
      {
        ae.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = ".concat(String.valueOf(i)));
        AppMethodBeat.o(127568);
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.FCM.FcmRegister", localThrowable.toString());
      AppMethodBeat.o(127568);
      return false;
    }
    AppMethodBeat.o(127568);
    return true;
  }
  
  final void cze()
  {
    AppMethodBeat.i(127569);
    e.ywz.idkeyStat(901L, 18L, 1L, false);
    Object localObject = null;
    if (czc()) {
      localObject = FirebaseInstanceId.xU().getToken();
    }
    if (bu.isNullOrNil((String)localObject))
    {
      e.ywz.idkeyStat(901L, 19L, 1L, false);
      ae.w("MicroMsg.FCM.FcmRegister", "unreg fail, token is null");
      AppMethodBeat.o(127569);
      return;
    }
    lJ(false);
    localObject = new c((String)localObject);
    g.ajS();
    g.ajQ().gDv.a(((c)localObject).getType(), this);
    g.ajS();
    g.ajQ().gDv.a((n)localObject, 0);
    e.ywz.idkeyStat(901L, 21L, 1L, false);
    AppMethodBeat.o(127569);
  }
  
  public final boolean czf()
  {
    AppMethodBeat.i(127571);
    boolean bool = czg().getBoolean("isRegToSvr", false);
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
      g.ajS();
      g.ajQ().gDv.a(((b)paramn).getType(), this);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ae.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg success.");
        e.ywz.idkeyStat(901L, 16L, 1L, false);
        bool = true;
      }
      for (;;)
      {
        lJ(bool);
        AppMethodBeat.o(127574);
        return;
        ae.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg faild.");
        e.ywz.idkeyStat(901L, 17L, 1L, false);
      }
    }
    if ((paramn instanceof c))
    {
      g.ajS();
      g.ajQ().gDv.a(((c)paramn).getType(), this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label194;
      }
      ae.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg success.");
      e.ywz.idkeyStat(901L, 23L, 1L, false);
    }
    for (;;)
    {
      lJ(false);
      AppMethodBeat.o(127574);
      return;
      label194:
      ae.e("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg faild.");
      e.ywz.idkeyStat(901L, 24L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fcm.a
 * JD-Core Version:    0.7.0.1
 */