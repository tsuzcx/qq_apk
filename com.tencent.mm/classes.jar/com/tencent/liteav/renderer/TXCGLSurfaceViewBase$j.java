package com.tencent.liteav.renderer;

import com.tencent.matrix.trace.core.AppMethodBeat;

class TXCGLSurfaceViewBase$j
{
  private static String a = "GLThreadManager";
  private boolean b;
  private int c;
  private boolean d;
  private boolean e;
  private boolean f;
  private TXCGLSurfaceViewBase.i g;
  
  private void c()
  {
    this.c = 131072;
    this.e = true;
    this.b = true;
  }
  
  public void a(TXCGLSurfaceViewBase.i parami)
  {
    try
    {
      AppMethodBeat.i(67300);
      TXCGLSurfaceViewBase.i.a(parami, true);
      if (this.g == parami) {
        this.g = null;
      }
      notifyAll();
      AppMethodBeat.o(67300);
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
    //   4: ldc 60
    //   6: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 62	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:d	Z
    //   13: ifne +65 -> 78
    //   16: aload_0
    //   17: invokespecial 64	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:c	()V
    //   20: aload_1
    //   21: sipush 7937
    //   24: invokeinterface 70 2 0
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 33	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:c	I
    //   34: ldc 31
    //   36: if_icmpge +23 -> 59
    //   39: aload_1
    //   40: ldc 72
    //   42: invokevirtual 78	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   45: ifne +41 -> 86
    //   48: iconst_1
    //   49: istore_2
    //   50: aload_0
    //   51: iload_2
    //   52: putfield 35	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:e	Z
    //   55: aload_0
    //   56: invokevirtual 55	java/lang/Object:notifyAll	()V
    //   59: aload_0
    //   60: getfield 35	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:e	Z
    //   63: ifne +28 -> 91
    //   66: iload_3
    //   67: istore_2
    //   68: aload_0
    //   69: iload_2
    //   70: putfield 80	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:f	Z
    //   73: aload_0
    //   74: iconst_1
    //   75: putfield 62	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:d	Z
    //   78: ldc 60
    //   80: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: iconst_0
    //   87: istore_2
    //   88: goto -38 -> 50
    //   91: iconst_0
    //   92: istore_2
    //   93: goto -25 -> 68
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	j
    //   0	101	1	paramGL10	javax.microedition.khronos.opengles.GL10
    //   49	44	2	bool1	boolean
    //   1	66	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	48	96	finally
    //   50	59	96	finally
    //   59	66	96	finally
    //   68	78	96	finally
    //   78	83	96	finally
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
    //   2: ldc 82
    //   4: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokespecial 64	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:c	()V
    //   11: aload_0
    //   12: getfield 35	com/tencent/liteav/renderer/TXCGLSurfaceViewBase$j:e	Z
    //   15: ifne +14 -> 29
    //   18: iconst_1
    //   19: istore_1
    //   20: ldc 82
    //   22: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: iload_1
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_1
    //   31: ldc 82
    //   33: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: goto -11 -> 25
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	j
    //   19	12	1	bool	boolean
    //   39	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	39	finally
    //   20	25	39	finally
    //   31	36	39	finally
  }
  
  public boolean b(TXCGLSurfaceViewBase.i parami)
  {
    AppMethodBeat.i(67301);
    if ((this.g == parami) || (this.g == null))
    {
      this.g = parami;
      notifyAll();
      AppMethodBeat.o(67301);
      return true;
    }
    c();
    if (this.e)
    {
      AppMethodBeat.o(67301);
      return true;
    }
    if (this.g != null) {
      this.g.h();
    }
    AppMethodBeat.o(67301);
    return false;
  }
  
  public void c(TXCGLSurfaceViewBase.i parami)
  {
    AppMethodBeat.i(67302);
    if (this.g == parami) {
      this.g = null;
    }
    notifyAll();
    AppMethodBeat.o(67302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.renderer.TXCGLSurfaceViewBase.j
 * JD-Core Version:    0.7.0.1
 */