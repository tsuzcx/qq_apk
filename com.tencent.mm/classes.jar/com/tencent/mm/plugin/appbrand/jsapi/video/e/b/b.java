package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class b
  implements h
{
  private static final Constructor<? extends e> bhS;
  private int bhT;
  private int bhU;
  private int bhV;
  private int bhW;
  private int bhX = 1;
  private int bhY;
  
  static
  {
    AppMethodBeat.i(206268);
    Object localObject = null;
    try
    {
      Constructor localConstructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
      localObject = localConstructor;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label27;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label27:
      break label27;
    }
    bhS = localObject;
    AppMethodBeat.o(206268);
  }
  
  /* Error */
  public final e[] us()
  {
    // Byte code:
    //   0: bipush 11
    //   2: istore_1
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 63
    //   7: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 49	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:bhS	Ljava/lang/reflect/Constructor;
    //   13: ifnonnull +181 -> 194
    //   16: iload_1
    //   17: anewarray 39	com/google/android/exoplayer2/c/e
    //   20: astore_2
    //   21: aload_2
    //   22: iconst_0
    //   23: new 65	com/google/android/exoplayer2/c/d/g
    //   26: dup
    //   27: aload_0
    //   28: getfield 67	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:bhU	I
    //   31: invokespecial 69	com/google/android/exoplayer2/c/d/g:<init>	(I)V
    //   34: aastore
    //   35: aload_2
    //   36: iconst_1
    //   37: new 71	com/google/android/exoplayer2/c/f/u
    //   40: dup
    //   41: aload_0
    //   42: getfield 58	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:bhX	I
    //   45: aload_0
    //   46: getfield 73	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:bhY	I
    //   49: invokespecial 76	com/google/android/exoplayer2/c/f/u:<init>	(II)V
    //   52: aastore
    //   53: aload_2
    //   54: iconst_2
    //   55: new 78	com/google/android/exoplayer2/c/d/e
    //   58: dup
    //   59: aload_0
    //   60: getfield 80	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:bhV	I
    //   63: invokespecial 81	com/google/android/exoplayer2/c/d/e:<init>	(I)V
    //   66: aastore
    //   67: aload_2
    //   68: iconst_3
    //   69: new 83	com/google/android/exoplayer2/c/c/b
    //   72: dup
    //   73: aload_0
    //   74: getfield 85	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:bhW	I
    //   77: invokespecial 86	com/google/android/exoplayer2/c/c/b:<init>	(I)V
    //   80: aastore
    //   81: aload_2
    //   82: iconst_4
    //   83: new 88	com/google/android/exoplayer2/c/b/d
    //   86: dup
    //   87: aload_0
    //   88: getfield 90	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:bhT	I
    //   91: invokespecial 91	com/google/android/exoplayer2/c/b/d:<init>	(I)V
    //   94: aastore
    //   95: aload_2
    //   96: iconst_5
    //   97: new 93	com/google/android/exoplayer2/c/f/c
    //   100: dup
    //   101: invokespecial 94	com/google/android/exoplayer2/c/f/c:<init>	()V
    //   104: aastore
    //   105: aload_2
    //   106: bipush 6
    //   108: new 96	com/google/android/exoplayer2/c/f/a
    //   111: dup
    //   112: invokespecial 97	com/google/android/exoplayer2/c/f/a:<init>	()V
    //   115: aastore
    //   116: aload_2
    //   117: bipush 7
    //   119: new 99	com/google/android/exoplayer2/c/a/b
    //   122: dup
    //   123: invokespecial 100	com/google/android/exoplayer2/c/a/b:<init>	()V
    //   126: aastore
    //   127: aload_2
    //   128: bipush 8
    //   130: new 102	com/google/android/exoplayer2/c/e/c
    //   133: dup
    //   134: invokespecial 103	com/google/android/exoplayer2/c/e/c:<init>	()V
    //   137: aastore
    //   138: aload_2
    //   139: bipush 9
    //   141: new 105	com/google/android/exoplayer2/c/f/p
    //   144: dup
    //   145: invokespecial 106	com/google/android/exoplayer2/c/f/p:<init>	()V
    //   148: aastore
    //   149: aload_2
    //   150: bipush 10
    //   152: new 108	com/google/android/exoplayer2/c/g/a
    //   155: dup
    //   156: invokespecial 109	com/google/android/exoplayer2/c/g/a:<init>	()V
    //   159: aastore
    //   160: getstatic 49	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:bhS	Ljava/lang/reflect/Constructor;
    //   163: astore_3
    //   164: aload_3
    //   165: ifnull +20 -> 185
    //   168: aload_2
    //   169: bipush 11
    //   171: getstatic 49	com/tencent/mm/plugin/appbrand/jsapi/video/e/b/b:bhS	Ljava/lang/reflect/Constructor;
    //   174: iconst_0
    //   175: anewarray 4	java/lang/Object
    //   178: invokevirtual 115	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   181: checkcast 39	com/google/android/exoplayer2/c/e
    //   184: aastore
    //   185: ldc 63
    //   187: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_2
    //   193: areturn
    //   194: bipush 12
    //   196: istore_1
    //   197: goto -181 -> 16
    //   200: astore_2
    //   201: new 117	java/lang/IllegalStateException
    //   204: dup
    //   205: ldc 119
    //   207: aload_2
    //   208: invokespecial 122	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   211: astore_2
    //   212: ldc 63
    //   214: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aload_2
    //   218: athrow
    //   219: astore_2
    //   220: aload_0
    //   221: monitorexit
    //   222: aload_2
    //   223: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	b
    //   2	195	1	i	int
    //   20	173	2	arrayOfe	e[]
    //   200	8	2	localException	java.lang.Exception
    //   211	7	2	localIllegalStateException	java.lang.IllegalStateException
    //   219	4	2	localObject	Object
    //   163	2	3	localConstructor	Constructor
    // Exception table:
    //   from	to	target	type
    //   168	185	200	java/lang/Exception
    //   5	16	219	finally
    //   16	164	219	finally
    //   168	185	219	finally
    //   185	190	219	finally
    //   201	219	219	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.b.b
 * JD-Core Version:    0.7.0.1
 */