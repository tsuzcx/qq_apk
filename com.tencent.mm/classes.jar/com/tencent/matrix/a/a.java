package com.tencent.matrix.a;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.c.a.a.a;
import com.tencent.matrix.a.a.c.3;
import com.tencent.matrix.a.a.c.4;

public final class a
  extends com.tencent.matrix.e.b
{
  private final com.tencent.matrix.a.a.c cQf;
  private boolean cQg;
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final String getTag()
  {
    return "BatteryDetectorPlugin";
  }
  
  public final void init(Application paramApplication, com.tencent.matrix.e.c paramc)
  {
    super.init(paramApplication, paramc);
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    try
    {
      com.tencent.matrix.g.c.i("Matrix.battery.BatteryDetectorPlugin", "onForeground:".concat(String.valueOf(paramBoolean)), new Object[0]);
      super.onForeground(paramBoolean);
      com.tencent.matrix.a.a.c localc = this.cQf;
      if (localc.cQK != null) {
        localc.cQK.cQp = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void start()
  {
    Object localObject1;
    try
    {
      if ((isPluginStarted()) || (this.cQg)) {
        break label178;
      }
      super.start();
      com.tencent.matrix.a.a.c localc1 = this.cQf;
      localObject1 = localc1.cQH;
      if (!((com.tencent.matrix.a.c.b)localObject1).started)
      {
        ((com.tencent.matrix.a.c.b)localObject1).cUa = new Handler(com.tencent.matrix.g.b.TP().getLooper());
        ((com.tencent.matrix.a.c.b)localObject1).started = true;
      }
      localObject1 = localc1.cQG;
      if (localObject1 == null) {
        throw new RuntimeException("batteryConfig is null");
      }
    }
    finally {}
    if (((com.tencent.matrix.a.a.b)localObject1).RR())
    {
      localc2.cQJ = new com.tencent.matrix.a.a.d(localc2, (com.tencent.matrix.a.a.b)localObject1, new c.3(localc2));
      com.tencent.matrix.a.c.d.a(localc2);
    }
    if (((com.tencent.matrix.a.a.b)localObject1).cQF.get(a.a.RAk.name(), true))
    {
      localc2.cQK = new com.tencent.matrix.a.a.a(localc2, localc2.cQG);
      localc2.cQH.q(new c.4(localc2));
      com.tencent.matrix.a.c.a.a(localc2);
    }
    for (;;)
    {
      try
      {
        localc2.mIsStart = true;
        label178:
        return;
      }
      finally {}
      com.tencent.matrix.g.c.i("Matrix.battery.detector", "isDetectAlarm == false", new Object[0]);
    }
  }
  
  /* Error */
  public final void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield 67	com/tencent/matrix/a/a:cQg	Z
    //   7: aload_0
    //   8: invokevirtual 65	com/tencent/matrix/a/a:isPluginStarted	()Z
    //   11: ifeq +59 -> 70
    //   14: aload_0
    //   15: invokespecial 180	com/tencent/matrix/e/b:stop	()V
    //   18: aload_0
    //   19: getfield 49	com/tencent/matrix/a/a:cQf	Lcom/tencent/matrix/a/a/c;
    //   22: astore_1
    //   23: aload_1
    //   24: monitorenter
    //   25: aload_1
    //   26: iconst_0
    //   27: putfield 173	com/tencent/matrix/a/a/c:mIsStart	Z
    //   30: aload_1
    //   31: monitorexit
    //   32: aload_1
    //   33: invokestatic 183	com/tencent/matrix/a/c/d:b	(Lcom/tencent/matrix/a/c/d$b;)V
    //   36: aload_1
    //   37: invokestatic 185	com/tencent/matrix/a/c/a:b	(Lcom/tencent/matrix/a/c/a$b;)V
    //   40: aload_1
    //   41: getfield 73	com/tencent/matrix/a/a/c:cQH	Lcom/tencent/matrix/a/c/b;
    //   44: astore_2
    //   45: aload_2
    //   46: getfield 78	com/tencent/matrix/a/c/b:started	Z
    //   49: ifeq +16 -> 65
    //   52: aload_2
    //   53: getfield 100	com/tencent/matrix/a/c/b:cUa	Landroid/os/Handler;
    //   56: aconst_null
    //   57: invokevirtual 189	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   60: aload_2
    //   61: iconst_0
    //   62: putfield 78	com/tencent/matrix/a/c/b:started	Z
    //   65: aload_1
    //   66: aconst_null
    //   67: putfield 130	com/tencent/matrix/a/a/c:cQJ	Lcom/tencent/matrix/a/a/d;
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: astore_2
    //   74: aload_1
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	a
    //   78	4	1	localObject1	Object
    //   44	17	2	localb	com.tencent.matrix.a.c.b
    //   73	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   25	32	73	finally
    //   74	76	73	finally
    //   2	25	78	finally
    //   32	65	78	finally
    //   65	70	78	finally
    //   76	78	78	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.a
 * JD-Core Version:    0.7.0.1
 */