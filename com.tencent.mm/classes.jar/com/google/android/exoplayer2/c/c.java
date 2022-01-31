package com.google.android.exoplayer2.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class c
  implements h
{
  private static final Constructor<? extends e> aBt;
  private int aBu;
  private int aBv;
  private int aBw;
  private int aBx;
  private int aBy = 1;
  private int aBz;
  
  static
  {
    AppMethodBeat.i(94858);
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
    aBt = localObject;
    AppMethodBeat.o(94858);
  }
  
  /* Error */
  public final e[] nY()
  {
    // Byte code:
    //   0: bipush 11
    //   2: istore_1
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 63
    //   7: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: getstatic 49	com/google/android/exoplayer2/c/c:aBt	Ljava/lang/reflect/Constructor;
    //   13: ifnonnull +181 -> 194
    //   16: iload_1
    //   17: anewarray 39	com/google/android/exoplayer2/c/e
    //   20: astore_2
    //   21: aload_2
    //   22: iconst_0
    //   23: new 65	com/google/android/exoplayer2/c/b/d
    //   26: dup
    //   27: aload_0
    //   28: getfield 67	com/google/android/exoplayer2/c/c:aBu	I
    //   31: invokespecial 69	com/google/android/exoplayer2/c/b/d:<init>	(I)V
    //   34: aastore
    //   35: aload_2
    //   36: iconst_1
    //   37: new 71	com/google/android/exoplayer2/c/d/e
    //   40: dup
    //   41: aload_0
    //   42: getfield 73	com/google/android/exoplayer2/c/c:aBw	I
    //   45: invokespecial 74	com/google/android/exoplayer2/c/d/e:<init>	(I)V
    //   48: aastore
    //   49: aload_2
    //   50: iconst_2
    //   51: new 76	com/google/android/exoplayer2/c/d/g
    //   54: dup
    //   55: aload_0
    //   56: getfield 78	com/google/android/exoplayer2/c/c:aBv	I
    //   59: invokespecial 79	com/google/android/exoplayer2/c/d/g:<init>	(I)V
    //   62: aastore
    //   63: aload_2
    //   64: iconst_3
    //   65: new 81	com/google/android/exoplayer2/c/c/b
    //   68: dup
    //   69: aload_0
    //   70: getfield 83	com/google/android/exoplayer2/c/c:aBx	I
    //   73: invokespecial 84	com/google/android/exoplayer2/c/c/b:<init>	(I)V
    //   76: aastore
    //   77: aload_2
    //   78: iconst_4
    //   79: new 86	com/google/android/exoplayer2/c/f/c
    //   82: dup
    //   83: invokespecial 87	com/google/android/exoplayer2/c/f/c:<init>	()V
    //   86: aastore
    //   87: aload_2
    //   88: iconst_5
    //   89: new 89	com/google/android/exoplayer2/c/f/a
    //   92: dup
    //   93: invokespecial 90	com/google/android/exoplayer2/c/f/a:<init>	()V
    //   96: aastore
    //   97: aload_2
    //   98: bipush 6
    //   100: new 92	com/google/android/exoplayer2/c/f/u
    //   103: dup
    //   104: aload_0
    //   105: getfield 58	com/google/android/exoplayer2/c/c:aBy	I
    //   108: aload_0
    //   109: getfield 94	com/google/android/exoplayer2/c/c:aBz	I
    //   112: invokespecial 97	com/google/android/exoplayer2/c/f/u:<init>	(II)V
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
    //   160: getstatic 49	com/google/android/exoplayer2/c/c:aBt	Ljava/lang/reflect/Constructor;
    //   163: astore_3
    //   164: aload_3
    //   165: ifnull +20 -> 185
    //   168: aload_2
    //   169: bipush 11
    //   171: getstatic 49	com/google/android/exoplayer2/c/c:aBt	Ljava/lang/reflect/Constructor;
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
    //   0	224	0	this	c
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c
 * JD-Core Version:    0.7.0.1
 */