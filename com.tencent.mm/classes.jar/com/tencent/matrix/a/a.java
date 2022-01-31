package com.tencent.matrix.a;

import android.app.Application;
import com.tencent.matrix.d.b;
import com.tencent.matrix.g.d;

public final class a
  extends b
{
  public final com.tencent.matrix.a.a.a bLZ;
  private com.tencent.matrix.a.b.c bMa;
  private boolean bMb;
  
  public final void destroy()
  {
    super.destroy();
  }
  
  public final String getTag()
  {
    return "battery";
  }
  
  public final void init(Application paramApplication, com.tencent.matrix.d.c paramc)
  {
    super.init(paramApplication, paramc);
    com.tencent.matrix.a.c.a.setPackageName(paramApplication);
    com.tencent.matrix.a.c.a.setProcessName(d.aI(paramApplication));
    this.bMa = new com.tencent.matrix.a.b.c(this);
  }
  
  /* Error */
  public final void onForeground(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 51
    //   4: ldc 53
    //   6: iload_1
    //   7: invokestatic 59	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   10: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   13: iconst_0
    //   14: anewarray 65	java/lang/Object
    //   17: invokestatic 71	com/tencent/matrix/g/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: iload_1
    //   22: invokespecial 73	com/tencent/matrix/d/b:onForeground	(Z)V
    //   25: iload_1
    //   26: ifeq +29 -> 55
    //   29: aload_0
    //   30: invokevirtual 77	com/tencent/matrix/a/a:isPluginStarted	()Z
    //   33: ifeq +22 -> 55
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 79	com/tencent/matrix/a/a:bMb	Z
    //   41: aload_0
    //   42: invokespecial 82	com/tencent/matrix/d/b:stop	()V
    //   45: aload_0
    //   46: getfield 47	com/tencent/matrix/a/a:bMa	Lcom/tencent/matrix/a/b/c;
    //   49: invokevirtual 83	com/tencent/matrix/a/b/c:stop	()V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: iload_1
    //   56: ifne -4 -> 52
    //   59: aload_0
    //   60: invokevirtual 86	com/tencent/matrix/a/a:isPluginStopped	()Z
    //   63: ifeq -11 -> 52
    //   66: aload_0
    //   67: getfield 79	com/tencent/matrix/a/a:bMb	Z
    //   70: ifeq -18 -> 52
    //   73: aload_0
    //   74: invokespecial 89	com/tencent/matrix/d/b:start	()V
    //   77: aload_0
    //   78: getfield 47	com/tencent/matrix/a/a:bMa	Lcom/tencent/matrix/a/b/c;
    //   81: invokevirtual 90	com/tencent/matrix/a/b/c:start	()V
    //   84: goto -32 -> 52
    //   87: astore_2
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	a
    //   0	92	1	paramBoolean	boolean
    //   87	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	87	finally
    //   29	52	87	finally
    //   59	84	87	finally
  }
  
  public final void start()
  {
    try
    {
      if ((!isPluginStarted()) && (!this.bMb))
      {
        super.start();
        this.bMa.start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void stop()
  {
    try
    {
      this.bMb = false;
      if (isPluginStarted())
      {
        super.stop();
        this.bMa.stop();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.a
 * JD-Core Version:    0.7.0.1
 */