package com.tencent.matrix.a;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.c.a.a.a;
import com.tencent.matrix.a.b.c.3;
import com.tencent.matrix.a.b.c.4;
import com.tencent.matrix.a.b.e;
import com.tencent.matrix.a.b.f;

public final class a
  extends com.tencent.matrix.e.b
{
  public final com.tencent.matrix.a.a.a cqC;
  private com.tencent.matrix.a.b.c cqD;
  private boolean cqE;
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final String getTag()
  {
    return "battery";
  }
  
  public final void init(Application paramApplication, com.tencent.matrix.e.c paramc)
  {
    super.init(paramApplication, paramc);
    com.tencent.matrix.a.d.a.setPackageName(paramApplication);
    com.tencent.matrix.a.d.a.setProcessName(com.tencent.matrix.g.d.getProcessName(paramApplication));
    this.cqD = new com.tencent.matrix.a.b.c(this);
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    try
    {
      com.tencent.matrix.g.c.i("Matrix.BatteryCanaryPlugin", "onForeground:".concat(String.valueOf(paramBoolean)), new Object[0]);
      super.onForeground(paramBoolean);
      com.tencent.matrix.a.b.c localc = this.cqD;
      if (localc.crl != null) {
        localc.crl.cqM = paramBoolean;
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
      if ((isPluginStarted()) || (this.cqE)) {
        break label178;
      }
      super.start();
      com.tencent.matrix.a.b.c localc1 = this.cqD;
      localObject1 = localc1.cri;
      if (!((com.tencent.matrix.a.b.d)localObject1).started)
      {
        ((com.tencent.matrix.a.b.d)localObject1).crA = new Handler(com.tencent.matrix.g.b.HY().getLooper());
        ((com.tencent.matrix.a.b.d)localObject1).started = true;
      }
      localObject1 = localc1.cqC;
      if (localObject1 == null) {
        throw new RuntimeException("batteryConfig is null");
      }
    }
    finally {}
    if (((com.tencent.matrix.a.a.a)localObject1).Gy())
    {
      localc2.crk = new f(localc2, (com.tencent.matrix.a.a.a)localObject1, new c.3(localc2));
      e.a(localc2);
    }
    if (((com.tencent.matrix.a.a.a)localObject1).cqF.get(a.a.JJf.name(), true))
    {
      localc2.crl = new com.tencent.matrix.a.b.a(localc2, localc2.cqC);
      localc2.cri.q(new c.4(localc2));
      com.tencent.matrix.a.b.b.a(localc2);
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
      com.tencent.matrix.g.c.i("Matrix.BatteryCanaryCore", "isDetectAlarm == false", new Object[0]);
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
    //   4: putfield 89	com/tencent/matrix/a/a:cqE	Z
    //   7: aload_0
    //   8: invokevirtual 87	com/tencent/matrix/a/a:isPluginStarted	()Z
    //   11: ifeq +59 -> 70
    //   14: aload_0
    //   15: invokespecial 198	com/tencent/matrix/e/b:stop	()V
    //   18: aload_0
    //   19: getfield 47	com/tencent/matrix/a/a:cqD	Lcom/tencent/matrix/a/b/c;
    //   22: astore_1
    //   23: aload_1
    //   24: monitorenter
    //   25: aload_1
    //   26: iconst_0
    //   27: putfield 191	com/tencent/matrix/a/b/c:mIsStart	Z
    //   30: aload_1
    //   31: monitorexit
    //   32: aload_1
    //   33: invokestatic 201	com/tencent/matrix/a/b/e:b	(Lcom/tencent/matrix/a/b/e$b;)V
    //   36: aload_1
    //   37: invokestatic 203	com/tencent/matrix/a/b/b:b	(Lcom/tencent/matrix/a/b/b$b;)V
    //   40: aload_1
    //   41: getfield 95	com/tencent/matrix/a/b/c:cri	Lcom/tencent/matrix/a/b/d;
    //   44: astore_2
    //   45: aload_2
    //   46: getfield 100	com/tencent/matrix/a/b/d:started	Z
    //   49: ifeq +16 -> 65
    //   52: aload_2
    //   53: getfield 121	com/tencent/matrix/a/b/d:crA	Landroid/os/Handler;
    //   56: aconst_null
    //   57: invokevirtual 207	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   60: aload_2
    //   61: iconst_0
    //   62: putfield 100	com/tencent/matrix/a/b/d:started	Z
    //   65: aload_1
    //   66: aconst_null
    //   67: putfield 148	com/tencent/matrix/a/b/c:crk	Lcom/tencent/matrix/a/b/f;
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
    //   44	17	2	locald	com.tencent.matrix.a.b.d
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a
 * JD-Core Version:    0.7.0.1
 */