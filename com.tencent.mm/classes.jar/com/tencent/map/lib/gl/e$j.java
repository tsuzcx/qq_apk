package com.tencent.map.lib.gl;

class e$j
{
  private static String a = "GLThreadManager";
  private boolean b;
  private int c;
  private boolean d;
  private boolean e;
  private boolean f;
  private e.i g;
  
  private void c()
  {
    if (!this.b)
    {
      this.c = 131072;
      if (this.c >= 131072) {
        this.e = true;
      }
      this.b = true;
    }
  }
  
  public void a(e.i parami)
  {
    try
    {
      e.i.a(parami, true);
      if (this.g == parami) {
        this.g = null;
      }
      notifyAll();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(javax.microedition.khronos.opengles.GL10 paramGL10)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 51	com/tencent/map/lib/gl/e$j:d	Z
    //   8: ifne +65 -> 73
    //   11: aload_0
    //   12: invokespecial 53	com/tencent/map/lib/gl/e$j:c	()V
    //   15: aload_1
    //   16: sipush 7937
    //   19: invokeinterface 59 2 0
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 35	com/tencent/map/lib/gl/e$j:c	I
    //   29: ldc 33
    //   31: if_icmpge +23 -> 54
    //   34: aload_1
    //   35: ldc 61
    //   37: invokevirtual 67	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   40: ifne +36 -> 76
    //   43: iconst_1
    //   44: istore_2
    //   45: aload_0
    //   46: iload_2
    //   47: putfield 37	com/tencent/map/lib/gl/e$j:e	Z
    //   50: aload_0
    //   51: invokevirtual 48	java/lang/Object:notifyAll	()V
    //   54: aload_0
    //   55: getfield 37	com/tencent/map/lib/gl/e$j:e	Z
    //   58: ifne +23 -> 81
    //   61: iload_3
    //   62: istore_2
    //   63: aload_0
    //   64: iload_2
    //   65: putfield 69	com/tencent/map/lib/gl/e$j:f	Z
    //   68: aload_0
    //   69: iconst_1
    //   70: putfield 51	com/tencent/map/lib/gl/e$j:d	Z
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: iconst_0
    //   77: istore_2
    //   78: goto -33 -> 45
    //   81: iconst_0
    //   82: istore_2
    //   83: goto -20 -> 63
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	j
    //   0	91	1	paramGL10	javax.microedition.khronos.opengles.GL10
    //   44	39	2	bool1	boolean
    //   1	61	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	43	86	finally
    //   45	54	86	finally
    //   54	61	86	finally
    //   63	73	86	finally
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 53	com/tencent/map/lib/gl/e$j:c	()V
    //   6: aload_0
    //   7: getfield 37	com/tencent/map/lib/gl/e$j:e	Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifne +9 -> 21
    //   15: iconst_1
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	j
    //   10	13	1	bool	boolean
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	26	finally
  }
  
  public boolean b(e.i parami)
  {
    if ((this.g == parami) || (this.g == null))
    {
      this.g = parami;
      notifyAll();
    }
    do
    {
      return true;
      c();
    } while (this.e);
    if (this.g != null) {
      this.g.i();
    }
    return false;
  }
  
  public void c(e.i parami)
  {
    if (this.g == parami) {
      this.g = null;
    }
    notifyAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.lib.gl.e.j
 * JD-Core Version:    0.7.0.1
 */