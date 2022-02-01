package com.huawei.a.a.b.a;

import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static final Object chu;
  private static final Object chv;
  private static final Object chw;
  private static final Object chx;
  private static b chy;
  e chz = null;
  
  static
  {
    AppMethodBeat.i(213644);
    chu = new Object();
    chv = new Object();
    chw = new Object();
    chx = new Object();
    chy = null;
    AppMethodBeat.o(213644);
  }
  
  protected static b Kf()
  {
    AppMethodBeat.i(213637);
    synchronized (chv)
    {
      if (chy == null) {
        chy = new b();
      }
      b localb = chy;
      AppMethodBeat.o(213637);
      return localb;
    }
  }
  
  protected static <T extends a> T a(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(213639);
    TXCLog.i("HwAudioKit.FeatureKitManager", "createFeatureKit, type = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramContext == null)
    {
      AppMethodBeat.o(213639);
      return null;
    }
    switch (paramInt)
    {
    default: 
      TXCLog.i("HwAudioKit.FeatureKitManager", "createFeatureKit, type error");
      AppMethodBeat.o(213639);
      return null;
    }
    c localc = new c(paramContext);
    localc.initialize(paramContext);
    AppMethodBeat.o(213639);
    return localc;
  }
  
  /* Error */
  protected static void a(Context paramContext, ServiceConnection paramServiceConnection, java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 82
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 31	com/huawei/a/a/b/a/b:chw	Ljava/lang/Object;
    //   8: astore_3
    //   9: aload_3
    //   10: monitorenter
    //   11: aload_0
    //   12: ifnonnull +11 -> 23
    //   15: aload_3
    //   16: monitorexit
    //   17: ldc 82
    //   19: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: return
    //   23: new 84	android/content/Intent
    //   26: dup
    //   27: invokespecial 85	android/content/Intent:<init>	()V
    //   30: astore 4
    //   32: aload 4
    //   34: ldc 87
    //   36: aload_2
    //   37: invokevirtual 91	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   40: pop
    //   41: ldc 50
    //   43: ldc 93
    //   45: invokestatic 68	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_0
    //   49: aload 4
    //   51: aload_1
    //   52: iconst_1
    //   53: invokevirtual 98	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   56: pop
    //   57: aload_3
    //   58: monitorexit
    //   59: ldc 82
    //   61: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: return
    //   65: astore_0
    //   66: ldc 50
    //   68: ldc 100
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: invokevirtual 104	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   80: aastore
    //   81: invokestatic 107	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: goto -27 -> 57
    //   87: astore_0
    //   88: aload_3
    //   89: monitorexit
    //   90: ldc 82
    //   92: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramContext	Context
    //   0	97	1	paramServiceConnection	ServiceConnection
    //   0	97	2	paramString	java.lang.String
    //   8	81	3	localObject	Object
    //   30	20	4	localIntent	android.content.Intent
    // Exception table:
    //   from	to	target	type
    //   41	57	65	java/lang/SecurityException
    //   23	41	87	finally
    //   41	57	87	finally
    //   57	59	87	finally
    //   66	84	87	finally
  }
  
  protected static boolean aq(Context paramContext)
  {
    AppMethodBeat.i(213642);
    if (paramContext == null)
    {
      AppMethodBeat.o(213642);
      return false;
    }
    paramContext = paramContext.getPackageManager();
    if (paramContext != null) {
      try
      {
        if (paramContext.getPackageInfo("com.huawei.multimedia.audioengine", 0) == null)
        {
          TXCLog.i("HwAudioKit.FeatureKitManager", "packageInfo is null");
          AppMethodBeat.o(213642);
          return false;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        TXCLog.e("HwAudioKit.FeatureKitManager", "isAudioKitSupport ,NameNotFoundException");
        AppMethodBeat.o(213642);
        return false;
      }
    }
    AppMethodBeat.o(213642);
    return true;
  }
  
  protected static void unbindService(Context paramContext, ServiceConnection paramServiceConnection)
  {
    AppMethodBeat.i(213641);
    TXCLog.i("HwAudioKit.FeatureKitManager", "unbindService");
    Object localObject = chx;
    if (paramContext != null) {}
    try
    {
      paramContext.unbindService(paramServiceConnection);
      return;
    }
    finally
    {
      AppMethodBeat.o(213641);
    }
  }
  
  protected final void jdMethod_if(int paramInt)
  {
    AppMethodBeat.i(213643);
    TXCLog.i("HwAudioKit.FeatureKitManager", "onCallBack, result = %d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (chu)
    {
      if (this.chz != null) {
        this.chz.onResult(paramInt);
      }
      AppMethodBeat.o(213643);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.huawei.a.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */