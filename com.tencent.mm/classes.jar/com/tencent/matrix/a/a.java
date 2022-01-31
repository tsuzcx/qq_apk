package com.tencent.matrix.a;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.a.b.c.3;
import com.tencent.matrix.a.b.c.4;
import com.tencent.matrix.a.b.d;
import com.tencent.matrix.a.b.e;
import com.tencent.matrix.a.b.f;

public final class a
  extends com.tencent.matrix.b.b
{
  public final com.tencent.matrix.a.a.a bmq;
  private com.tencent.matrix.a.b.c bmr;
  private boolean bms = false;
  
  public a()
  {
    this.bmq = com.tencent.matrix.a.a.a.bmt;
  }
  
  public a(com.tencent.matrix.a.a.a parama)
  {
    this.bmq = parama;
  }
  
  public final void a(Application paramApplication, com.tencent.matrix.b.c paramc)
  {
    super.a(paramApplication, paramc);
    com.tencent.matrix.a.c.a.ag(paramApplication);
    com.tencent.matrix.a.c.a.bw(com.tencent.matrix.d.c.ak(paramApplication));
    this.bmr = new com.tencent.matrix.a.b.c(this);
  }
  
  public final String getTag()
  {
    return "battery";
  }
  
  public final void start()
  {
    Object localObject1;
    try
    {
      if ((re()) || (this.bms)) {
        break label168;
      }
      super.start();
      com.tencent.matrix.a.b.c localc1 = this.bmr;
      localObject1 = localc1.bnf;
      if (!((d)localObject1).started)
      {
        ((d)localObject1).bny = new Handler(com.tencent.matrix.d.a.rt().getLooper());
        ((d)localObject1).started = true;
      }
      localObject1 = localc1.bmq;
      if (localObject1 == null) {
        throw new RuntimeException("batteryConfig is null");
      }
    }
    finally {}
    if (((com.tencent.matrix.a.a.a)localObject1).ed(1))
    {
      localc2.bni = new f(localc2, (com.tencent.matrix.a.a.a)localObject1, new c.3(localc2));
      e.a(localc2);
    }
    if (((com.tencent.matrix.a.a.a)localObject1).ed(4))
    {
      localc2.bnj = new com.tencent.matrix.a.b.a(localc2, localc2.bmq);
      localc2.bnf.h(new c.4(localc2));
      com.tencent.matrix.a.b.b.a(localc2);
    }
    try
    {
      localc2.bnh = true;
      label168:
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield 16	com/tencent/matrix/a/a:bms	Z
    //   7: aload_0
    //   8: invokevirtual 61	com/tencent/matrix/a/a:re	()Z
    //   11: ifeq +59 -> 70
    //   14: aload_0
    //   15: invokespecial 150	com/tencent/matrix/b/b:stop	()V
    //   18: aload_0
    //   19: getfield 52	com/tencent/matrix/a/a:bmr	Lcom/tencent/matrix/a/b/c;
    //   22: astore_1
    //   23: aload_1
    //   24: monitorenter
    //   25: aload_1
    //   26: iconst_0
    //   27: putfield 147	com/tencent/matrix/a/b/c:bnh	Z
    //   30: aload_1
    //   31: monitorexit
    //   32: aload_1
    //   33: invokestatic 153	com/tencent/matrix/a/b/e:b	(Lcom/tencent/matrix/a/b/e$b;)V
    //   36: aload_1
    //   37: invokestatic 155	com/tencent/matrix/a/b/b:b	(Lcom/tencent/matrix/a/b/b$c;)V
    //   40: aload_1
    //   41: getfield 67	com/tencent/matrix/a/b/c:bnf	Lcom/tencent/matrix/a/b/d;
    //   44: astore_2
    //   45: aload_2
    //   46: getfield 72	com/tencent/matrix/a/b/d:started	Z
    //   49: ifeq +16 -> 65
    //   52: aload_2
    //   53: getfield 93	com/tencent/matrix/a/b/d:bny	Landroid/os/Handler;
    //   56: aconst_null
    //   57: invokevirtual 159	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   60: aload_2
    //   61: iconst_0
    //   62: putfield 72	com/tencent/matrix/a/b/d:started	Z
    //   65: aload_1
    //   66: aconst_null
    //   67: putfield 118	com/tencent/matrix/a/b/c:bni	Lcom/tencent/matrix/a/b/f;
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
    //   44	17	2	locald	d
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.a
 * JD-Core Version:    0.7.0.1
 */