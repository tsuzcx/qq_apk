package com.huawei.a.a.b.a;

import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static final Object dXC;
  private static final Object dXD;
  private static final Object dXE;
  private static final Object dXF;
  private static b dXG;
  e dXH = null;
  
  static
  {
    AppMethodBeat.i(208278);
    dXC = new Object();
    dXD = new Object();
    dXE = new Object();
    dXF = new Object();
    dXG = null;
    AppMethodBeat.o(208278);
  }
  
  protected static <T extends a> T a(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(208257);
    TXCLog.i("HwAudioKit.FeatureKitManager", "createFeatureKit, type = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramContext == null)
    {
      AppMethodBeat.o(208257);
      return null;
    }
    switch (paramInt)
    {
    default: 
      TXCLog.i("HwAudioKit.FeatureKitManager", "createFeatureKit, type error");
      AppMethodBeat.o(208257);
      return null;
    }
    c localc = new c(paramContext);
    localc.initialize(paramContext);
    AppMethodBeat.o(208257);
    return localc;
  }
  
  /* Error */
  protected static void a(Context paramContext, ServiceConnection paramServiceConnection, java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 78
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 31	com/huawei/a/a/b/a/b:dXE	Ljava/lang/Object;
    //   8: astore_3
    //   9: aload_3
    //   10: monitorenter
    //   11: aload_0
    //   12: ifnonnull +11 -> 23
    //   15: aload_3
    //   16: monitorexit
    //   17: ldc 78
    //   19: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: return
    //   23: new 80	android/content/Intent
    //   26: dup
    //   27: invokespecial 81	android/content/Intent:<init>	()V
    //   30: astore 4
    //   32: aload 4
    //   34: ldc 83
    //   36: aload_2
    //   37: invokevirtual 87	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   40: pop
    //   41: ldc 46
    //   43: ldc 89
    //   45: invokestatic 64	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_0
    //   49: aload 4
    //   51: aload_1
    //   52: iconst_1
    //   53: invokevirtual 94	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   56: pop
    //   57: aload_3
    //   58: monitorexit
    //   59: ldc 78
    //   61: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: return
    //   65: astore_0
    //   66: ldc 46
    //   68: ldc 96
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: invokevirtual 100	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   80: aastore
    //   81: invokestatic 103	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: goto -27 -> 57
    //   87: astore_0
    //   88: aload_3
    //   89: monitorexit
    //   90: ldc 78
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
  
  protected static b akg()
  {
    AppMethodBeat.i(208253);
    synchronized (dXD)
    {
      if (dXG == null) {
        dXG = new b();
      }
      b localb = dXG;
      AppMethodBeat.o(208253);
      return localb;
    }
  }
  
  protected static boolean bb(Context paramContext)
  {
    AppMethodBeat.i(208274);
    if (paramContext == null)
    {
      AppMethodBeat.o(208274);
      return false;
    }
    paramContext = paramContext.getPackageManager();
    if (paramContext != null) {
      try
      {
        if (paramContext.getPackageInfo("com.huawei.multimedia.audioengine", 0) == null)
        {
          TXCLog.i("HwAudioKit.FeatureKitManager", "packageInfo is null");
          AppMethodBeat.o(208274);
          return false;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        TXCLog.e("HwAudioKit.FeatureKitManager", "isAudioKitSupport ,NameNotFoundException");
        AppMethodBeat.o(208274);
        return false;
      }
    }
    AppMethodBeat.o(208274);
    return true;
  }
  
  protected static void unbindService(Context paramContext, ServiceConnection paramServiceConnection)
  {
    AppMethodBeat.i(208269);
    TXCLog.i("HwAudioKit.FeatureKitManager", "unbindService");
    Object localObject = dXF;
    if (paramContext != null) {}
    try
    {
      paramContext.unbindService(paramServiceConnection);
      return;
    }
    finally
    {
      AppMethodBeat.o(208269);
    }
  }
  
  protected final void lK(int paramInt)
  {
    AppMethodBeat.i(208284);
    TXCLog.i("HwAudioKit.FeatureKitManager", "onCallBack, result = %d", new Object[] { Integer.valueOf(paramInt) });
    synchronized (dXC)
    {
      if (this.dXH != null) {
        this.dXH.onResult(paramInt);
      }
      AppMethodBeat.o(208284);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.huawei.a.a.b.a.b
 * JD-Core Version:    0.7.0.1
 */