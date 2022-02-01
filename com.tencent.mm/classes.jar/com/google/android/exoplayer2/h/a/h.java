package com.google.android.exoplayer2.h.a;

import android.net.Uri;
import com.google.android.exoplayer2.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  /* Error */
  public static long a(j paramj, long paramLong1, long paramLong2, com.google.android.exoplayer2.h.g paramg, byte[] paramArrayOfByte, a parama)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 23	java/lang/Thread:interrupted	()Z
    //   8: ifeq +30 -> 38
    //   11: new 25	java/lang/InterruptedException
    //   14: dup
    //   15: invokespecial 29	java/lang/InterruptedException:<init>	()V
    //   18: astore 11
    //   20: ldc 11
    //   22: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload 11
    //   27: athrow
    //   28: astore 11
    //   30: aload 5
    //   32: invokestatic 37	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   35: goto -30 -> 5
    //   38: new 39	com/google/android/exoplayer2/h/j
    //   41: dup
    //   42: aload_0
    //   43: getfield 43	com/google/android/exoplayer2/h/j:uri	Landroid/net/Uri;
    //   46: aload_0
    //   47: getfield 47	com/google/android/exoplayer2/h/j:dih	[B
    //   50: lload_1
    //   51: aload_0
    //   52: getfield 51	com/google/android/exoplayer2/h/j:position	J
    //   55: lload_1
    //   56: ladd
    //   57: aload_0
    //   58: getfield 54	com/google/android/exoplayer2/h/j:absoluteStreamPosition	J
    //   61: lsub
    //   62: ldc2_w 55
    //   65: aload_0
    //   66: getfield 60	com/google/android/exoplayer2/h/j:key	Ljava/lang/String;
    //   69: aload_0
    //   70: getfield 64	com/google/android/exoplayer2/h/j:flags	I
    //   73: iconst_2
    //   74: ior
    //   75: invokespecial 67	com/google/android/exoplayer2/h/j:<init>	(Landroid/net/Uri;[BJJJLjava/lang/String;I)V
    //   78: astore 11
    //   80: aload 5
    //   82: aload 11
    //   84: invokeinterface 72 2 0
    //   89: lstore 9
    //   91: aload 7
    //   93: getfield 75	com/google/android/exoplayer2/h/a/h$a:contentLength	J
    //   96: ldc2_w 55
    //   99: lcmp
    //   100: ifne +180 -> 280
    //   103: lload 9
    //   105: ldc2_w 55
    //   108: lcmp
    //   109: ifeq +171 -> 280
    //   112: aload 7
    //   114: lload 9
    //   116: aload 11
    //   118: getfield 54	com/google/android/exoplayer2/h/j:absoluteStreamPosition	J
    //   121: ladd
    //   122: putfield 75	com/google/android/exoplayer2/h/a/h$a:contentLength	J
    //   125: goto +155 -> 280
    //   128: lload 9
    //   130: lload_3
    //   131: lcmp
    //   132: ifeq +90 -> 222
    //   135: invokestatic 23	java/lang/Thread:interrupted	()Z
    //   138: ifeq +18 -> 156
    //   141: new 25	java/lang/InterruptedException
    //   144: dup
    //   145: invokespecial 29	java/lang/InterruptedException:<init>	()V
    //   148: astore_0
    //   149: ldc 11
    //   151: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: aload_0
    //   155: athrow
    //   156: lload_3
    //   157: ldc2_w 55
    //   160: lcmp
    //   161: ifeq +74 -> 235
    //   164: ldc2_w 76
    //   167: lload_3
    //   168: lload 9
    //   170: lsub
    //   171: invokestatic 83	java/lang/Math:min	(JJ)J
    //   174: l2i
    //   175: istore 8
    //   177: aload 5
    //   179: aload 6
    //   181: iconst_0
    //   182: iload 8
    //   184: invokeinterface 87 4 0
    //   189: istore 8
    //   191: iload 8
    //   193: iconst_m1
    //   194: if_icmpne +48 -> 242
    //   197: aload 7
    //   199: getfield 75	com/google/android/exoplayer2/h/a/h$a:contentLength	J
    //   202: ldc2_w 55
    //   205: lcmp
    //   206: ifne +16 -> 222
    //   209: aload 7
    //   211: aload 11
    //   213: getfield 54	com/google/android/exoplayer2/h/j:absoluteStreamPosition	J
    //   216: lload 9
    //   218: ladd
    //   219: putfield 75	com/google/android/exoplayer2/h/a/h$a:contentLength	J
    //   222: aload 5
    //   224: invokestatic 37	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   227: ldc 11
    //   229: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: lload 9
    //   234: lreturn
    //   235: ldc 88
    //   237: istore 8
    //   239: goto -62 -> 177
    //   242: lload 9
    //   244: iload 8
    //   246: i2l
    //   247: ladd
    //   248: lstore 9
    //   250: aload 7
    //   252: aload 7
    //   254: getfield 91	com/google/android/exoplayer2/h/a/h$a:djB	J
    //   257: iload 8
    //   259: i2l
    //   260: ladd
    //   261: putfield 91	com/google/android/exoplayer2/h/a/h$a:djB	J
    //   264: goto -136 -> 128
    //   267: astore_0
    //   268: aload 5
    //   270: invokestatic 37	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   273: ldc 11
    //   275: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aload_0
    //   279: athrow
    //   280: lconst_0
    //   281: lstore 9
    //   283: goto -155 -> 128
    //   286: astore_0
    //   287: aload 11
    //   289: astore_0
    //   290: goto -260 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramj	j
    //   0	293	1	paramLong1	long
    //   0	293	3	paramLong2	long
    //   0	293	5	paramg	com.google.android.exoplayer2.h.g
    //   0	293	6	paramArrayOfByte	byte[]
    //   0	293	7	parama	a
    //   175	83	8	i	int
    //   89	193	9	l	long
    //   18	8	11	localInterruptedException	java.lang.InterruptedException
    //   28	1	11	locala	com.google.android.exoplayer2.i.p.a
    //   78	210	11	localj	j
    // Exception table:
    //   from	to	target	type
    //   5	28	28	com/google/android/exoplayer2/i/p$a
    //   38	80	28	com/google/android/exoplayer2/i/p$a
    //   5	28	267	finally
    //   38	80	267	finally
    //   80	103	267	finally
    //   112	125	267	finally
    //   135	156	267	finally
    //   164	177	267	finally
    //   177	191	267	finally
    //   197	222	267	finally
    //   250	264	267	finally
    //   80	103	286	com/google/android/exoplayer2/i/p$a
    //   112	125	286	com/google/android/exoplayer2/i/p$a
    //   135	156	286	com/google/android/exoplayer2/i/p$a
    //   164	177	286	com/google/android/exoplayer2/i/p$a
    //   177	191	286	com/google/android/exoplayer2/i/p$a
    //   197	222	286	com/google/android/exoplayer2/i/p$a
    //   250	264	286	com/google/android/exoplayer2/i/p$a
  }
  
  public static String c(j paramj)
  {
    AppMethodBeat.i(92996);
    if (paramj.key != null)
    {
      paramj = paramj.key;
      AppMethodBeat.o(92996);
      return paramj;
    }
    paramj = paramj.uri.toString();
    AppMethodBeat.o(92996);
    return paramj;
  }
  
  public static final class a
  {
    public volatile long contentLength = -1L;
    public volatile long djA;
    public volatile long djB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.h
 * JD-Core Version:    0.7.0.1
 */