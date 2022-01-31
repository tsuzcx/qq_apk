package com.tencent.mm.plugin.appbrand.game;

final class GameGLSurfaceView$k
{
  private static String TAG = "GLThreadManager";
  
  /* Error */
  public final void f(GameGLSurfaceView.j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 25
    //   4: new 27	java/lang/StringBuilder
    //   7: dup
    //   8: ldc 29
    //   10: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_1
    //   14: invokevirtual 38	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:getId	()J
    //   17: invokevirtual 42	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: iconst_0
    //   24: anewarray 4	java/lang/Object
    //   27: invokestatic 52	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_1
    //   31: invokestatic 56	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:a	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j;)Ljava/lang/ref/WeakReference;
    //   34: invokevirtual 62	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   37: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull +180 -> 222
    //   45: aload_2
    //   46: invokestatic 66	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:g	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$n;
    //   49: invokeinterface 71 1 0
    //   54: aload_1
    //   55: invokestatic 75	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:b	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i;
    //   58: astore_2
    //   59: ldc 25
    //   61: new 27	java/lang/StringBuilder
    //   64: dup
    //   65: ldc 77
    //   67: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: invokestatic 83	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   73: invokevirtual 84	java/lang/Thread:getId	()J
    //   76: invokevirtual 42	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   79: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 87	com/tencent/magicbrush/a/d$f:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: aload_2
    //   90: invokevirtual 92	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:afQ	()V
    //   93: aload_1
    //   94: invokestatic 95	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:c	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j;)V
    //   97: aload_1
    //   98: invokestatic 98	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:d	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j;)V
    //   101: aload_1
    //   102: invokestatic 75	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:b	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i;
    //   105: astore_2
    //   106: ldc 25
    //   108: new 27	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 100
    //   114: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: invokestatic 83	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   120: invokevirtual 84	java/lang/Thread:getId	()J
    //   123: invokevirtual 42	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   126: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: iconst_0
    //   130: anewarray 4	java/lang/Object
    //   133: invokestatic 87	com/tencent/magicbrush/a/d$f:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload_2
    //   137: getfield 104	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwJ	Ljavax/microedition/khronos/egl/EGLContext;
    //   140: ifnull +44 -> 184
    //   143: aload_2
    //   144: getfield 108	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fZa	Ljava/lang/ref/WeakReference;
    //   147: invokevirtual 62	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   150: checkcast 6	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView
    //   153: astore_3
    //   154: aload_3
    //   155: ifnull +24 -> 179
    //   158: aload_3
    //   159: invokestatic 111	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView:c	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView;)Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$f;
    //   162: aload_2
    //   163: getfield 115	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   166: aload_2
    //   167: getfield 119	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   170: aload_2
    //   171: getfield 104	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwJ	Ljavax/microedition/khronos/egl/EGLContext;
    //   174: invokeinterface 125 4 0
    //   179: aload_2
    //   180: aconst_null
    //   181: putfield 104	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwJ	Ljavax/microedition/khronos/egl/EGLContext;
    //   184: aload_2
    //   185: getfield 119	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   188: ifnull +22 -> 210
    //   191: aload_2
    //   192: getfield 115	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwH	Ljavax/microedition/khronos/egl/EGL10;
    //   195: aload_2
    //   196: getfield 119	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   199: invokeinterface 131 2 0
    //   204: pop
    //   205: aload_2
    //   206: aconst_null
    //   207: putfield 119	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$i:fwI	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   210: aload_1
    //   211: invokestatic 135	com/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j:e	(Lcom/tencent/mm/plugin/appbrand/game/GameGLSurfaceView$j;)Z
    //   214: pop
    //   215: aload_0
    //   216: invokevirtual 138	java/lang/Object:notifyAll	()V
    //   219: aload_0
    //   220: monitorexit
    //   221: return
    //   222: ldc 25
    //   224: ldc 140
    //   226: iconst_0
    //   227: anewarray 4	java/lang/Object
    //   230: invokestatic 52	com/tencent/magicbrush/a/d$f:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   233: goto -179 -> 54
    //   236: astore_1
    //   237: aload_0
    //   238: monitorexit
    //   239: aload_1
    //   240: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	k
    //   0	241	1	paramj	GameGLSurfaceView.j
    //   40	166	2	localObject	Object
    //   153	6	3	localGameGLSurfaceView	GameGLSurfaceView
    // Exception table:
    //   from	to	target	type
    //   2	41	236	finally
    //   45	54	236	finally
    //   54	154	236	finally
    //   158	179	236	finally
    //   179	184	236	finally
    //   184	210	236	finally
    //   210	219	236	finally
    //   222	233	236	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.k
 * JD-Core Version:    0.7.0.1
 */