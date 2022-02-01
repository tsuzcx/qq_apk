package com.tencent.mm.plugin.gamelive.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static short JeO = 40;
  private long JeP = 0L;
  private int JeQ = 0;
  private short JeR = 0;
  private int JeS = 0;
  private byte[] JeT = null;
  private boolean mInited = false;
  
  public static int b(short paramShort, int paramInt)
  {
    AppMethodBeat.i(277503);
    paramInt = c(paramShort, paramInt);
    AppMethodBeat.o(277503);
    return paramInt * 2;
  }
  
  private static int c(short paramShort, int paramInt)
  {
    return paramShort * paramInt * JeO / 1000;
  }
  
  /* Error */
  public final boolean a(short paramShort1, short paramShort2, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 58
    //   4: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 26	com/tencent/mm/plugin/gamelive/a/b:mInited	Z
    //   11: ifne +16 -> 27
    //   14: iconst_0
    //   15: istore 6
    //   17: ldc 58
    //   19: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_0
    //   23: monitorexit
    //   24: iload 6
    //   26: ireturn
    //   27: getstatic 20	com/tencent/mm/plugin/gamelive/a/b:JeO	S
    //   30: iload_3
    //   31: imul
    //   32: sipush 1000
    //   35: idiv
    //   36: istore 5
    //   38: aload_0
    //   39: getfield 28	com/tencent/mm/plugin/gamelive/a/b:JeP	J
    //   42: iload 5
    //   44: iconst_1
    //   45: ishl
    //   46: i2s
    //   47: iload_1
    //   48: iload_2
    //   49: iload_3
    //   50: aload 4
    //   52: invokestatic 64	com/tencent/mm/plugin/ap/WVAPJNI:nativeMixerInsertRawPCM	(JSSSI[B)I
    //   55: pop
    //   56: iconst_1
    //   57: istore 6
    //   59: ldc 58
    //   61: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: goto -42 -> 22
    //   67: astore 4
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 4
    //   73: athrow
    //   74: astore 4
    //   76: ldc 66
    //   78: new 68	java/lang/StringBuilder
    //   81: dup
    //   82: ldc 70
    //   84: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: aload 4
    //   89: invokevirtual 77	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   92: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: goto -45 -> 56
    //   104: astore 4
    //   106: ldc 66
    //   108: new 68	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 92
    //   114: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload 4
    //   119: invokevirtual 93	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   122: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: goto -75 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	b
    //   0	134	1	paramShort1	short
    //   0	134	2	paramShort2	short
    //   0	134	3	paramInt	int
    //   0	134	4	paramArrayOfByte	byte[]
    //   36	10	5	i	int
    //   15	43	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	67	finally
    //   17	22	67	finally
    //   27	56	67	finally
    //   59	64	67	finally
    //   76	101	67	finally
    //   106	131	67	finally
    //   27	56	74	java/lang/Exception
    //   27	56	104	java/lang/UnsatisfiedLinkError
  }
  
  /* Error */
  public final boolean fIT()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 96
    //   4: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iconst_0
    //   8: istore_1
    //   9: aload_0
    //   10: getfield 26	com/tencent/mm/plugin/gamelive/a/b:mInited	Z
    //   13: ifne +62 -> 75
    //   16: ldc 98
    //   18: invokestatic 102	com/tencent/mm/plugin/ap/WVAPJNI:nativeInitMixerFunc	(Ljava/lang/String;)I
    //   21: istore_1
    //   22: aload_0
    //   23: sipush 128
    //   26: ldc 103
    //   28: getstatic 20	com/tencent/mm/plugin/gamelive/a/b:JeO	S
    //   31: invokestatic 107	com/tencent/mm/plugin/ap/WVAPJNI:nativeMixerInit	(III)J
    //   34: putfield 28	com/tencent/mm/plugin/gamelive/a/b:JeP	J
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 26	com/tencent/mm/plugin/gamelive/a/b:mInited	Z
    //   42: aload_0
    //   43: ldc 103
    //   45: putfield 30	com/tencent/mm/plugin/gamelive/a/b:JeQ	I
    //   48: aload_0
    //   49: iconst_2
    //   50: putfield 32	com/tencent/mm/plugin/gamelive/a/b:JeR	S
    //   53: aload_0
    //   54: iconst_2
    //   55: ldc 103
    //   57: invokestatic 48	com/tencent/mm/plugin/gamelive/a/b:c	(SI)I
    //   60: iconst_2
    //   61: imul
    //   62: putfield 34	com/tencent/mm/plugin/gamelive/a/b:JeS	I
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 34	com/tencent/mm/plugin/gamelive/a/b:JeS	I
    //   70: newarray byte
    //   72: putfield 36	com/tencent/mm/plugin/gamelive/a/b:JeT	[B
    //   75: ldc 66
    //   77: new 68	java/lang/StringBuilder
    //   80: dup
    //   81: ldc 109
    //   83: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   86: aload_0
    //   87: getfield 34	com/tencent/mm/plugin/gamelive/a/b:JeS	I
    //   90: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: ldc 114
    //   95: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_0
    //   99: getfield 28	com/tencent/mm/plugin/gamelive/a/b:JeP	J
    //   102: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   105: ldc 119
    //   107: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload_1
    //   111: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: getfield 26	com/tencent/mm/plugin/gamelive/a/b:mInited	Z
    //   124: istore_2
    //   125: ldc 96
    //   127: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: aload_0
    //   131: monitorexit
    //   132: iload_2
    //   133: ireturn
    //   134: astore_3
    //   135: ldc 66
    //   137: aload_3
    //   138: invokevirtual 77	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   141: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 26	com/tencent/mm/plugin/gamelive/a/b:mInited	Z
    //   148: istore_2
    //   149: ldc 96
    //   151: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: goto -24 -> 130
    //   157: astore_3
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_3
    //   161: athrow
    //   162: astore_3
    //   163: ldc 66
    //   165: aload_3
    //   166: invokevirtual 93	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   169: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_0
    //   173: getfield 26	com/tencent/mm/plugin/gamelive/a/b:mInited	Z
    //   176: istore_2
    //   177: ldc 96
    //   179: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: goto -52 -> 130
    //   185: astore_3
    //   186: aload_0
    //   187: getfield 26	com/tencent/mm/plugin/gamelive/a/b:mInited	Z
    //   190: istore_2
    //   191: ldc 96
    //   193: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: goto -66 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	b
    //   8	103	1	i	int
    //   124	67	2	bool	boolean
    //   134	4	3	localException	java.lang.Exception
    //   157	4	3	localObject1	Object
    //   162	4	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   185	1	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	75	134	java/lang/Exception
    //   75	120	134	java/lang/Exception
    //   2	7	157	finally
    //   120	130	157	finally
    //   144	154	157	finally
    //   172	182	157	finally
    //   186	196	157	finally
    //   9	75	162	java/lang/UnsatisfiedLinkError
    //   75	120	162	java/lang/UnsatisfiedLinkError
    //   9	75	185	finally
    //   75	120	185	finally
    //   135	144	185	finally
    //   163	172	185	finally
  }
  
  /* Error */
  public final byte[] getData()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 124
    //   6: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 26	com/tencent/mm/plugin/gamelive/a/b:mInited	Z
    //   13: ifne +12 -> 25
    //   16: ldc 124
    //   18: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_2
    //   24: areturn
    //   25: aload_0
    //   26: getfield 28	com/tencent/mm/plugin/gamelive/a/b:JeP	J
    //   29: aload_0
    //   30: getfield 36	com/tencent/mm/plugin/gamelive/a/b:JeT	[B
    //   33: aload_0
    //   34: getfield 32	com/tencent/mm/plugin/gamelive/a/b:JeR	S
    //   37: invokestatic 128	com/tencent/mm/plugin/ap/WVAPJNI:nativeMixerGetMixedPCM	(J[BS)I
    //   40: istore_1
    //   41: iload_1
    //   42: ifgt +17 -> 59
    //   45: ldc 66
    //   47: ldc 130
    //   49: iload_1
    //   50: invokestatic 136	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   53: invokevirtual 140	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 36	com/tencent/mm/plugin/gamelive/a/b:JeT	[B
    //   63: astore_3
    //   64: ldc 124
    //   66: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_3
    //   70: astore_2
    //   71: goto -50 -> 21
    //   74: astore_2
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    //   79: astore_3
    //   80: ldc 66
    //   82: new 68	java/lang/StringBuilder
    //   85: dup
    //   86: ldc 142
    //   88: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_3
    //   92: invokevirtual 77	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   95: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: ldc 124
    //   106: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: goto -88 -> 21
    //   112: astore_3
    //   113: ldc 66
    //   115: new 68	java/lang/StringBuilder
    //   118: dup
    //   119: ldc 144
    //   121: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload_3
    //   125: invokevirtual 93	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: goto -33 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	b
    //   40	10	1	i	int
    //   1	70	2	localObject1	Object
    //   74	4	2	localObject2	Object
    //   63	7	3	arrayOfByte	byte[]
    //   79	13	3	localException	java.lang.Exception
    //   112	13	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   4	21	74	finally
    //   25	41	74	finally
    //   45	59	74	finally
    //   59	64	74	finally
    //   64	69	74	finally
    //   80	104	74	finally
    //   104	109	74	finally
    //   113	137	74	finally
    //   25	41	79	java/lang/Exception
    //   45	59	79	java/lang/Exception
    //   59	64	79	java/lang/Exception
    //   25	41	112	java/lang/UnsatisfiedLinkError
    //   45	59	112	java/lang/UnsatisfiedLinkError
    //   59	64	112	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.a.b
 * JD-Core Version:    0.7.0.1
 */