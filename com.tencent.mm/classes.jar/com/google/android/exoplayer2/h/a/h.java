package com.google.android.exoplayer2.h.a;

import android.net.Uri;
import com.google.android.exoplayer2.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  /* Error */
  private static long a(j paramj, long paramLong1, long paramLong2, com.google.android.exoplayer2.h.g paramg, byte[] paramArrayOfByte, a parama)
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
    //   47: getfield 47	com/google/android/exoplayer2/h/j:bor	[B
    //   50: lload_1
    //   51: aload_0
    //   52: getfield 51	com/google/android/exoplayer2/h/j:position	J
    //   55: lload_1
    //   56: ladd
    //   57: aload_0
    //   58: getfield 54	com/google/android/exoplayer2/h/j:bos	J
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
    //   100: ifne +182 -> 282
    //   103: lload 9
    //   105: ldc2_w 55
    //   108: lcmp
    //   109: ifeq +173 -> 282
    //   112: aload 7
    //   114: lload 9
    //   116: aload 11
    //   118: getfield 54	com/google/android/exoplayer2/h/j:bos	J
    //   121: ladd
    //   122: putfield 75	com/google/android/exoplayer2/h/a/h$a:contentLength	J
    //   125: goto +157 -> 282
    //   128: lload 9
    //   130: lload_3
    //   131: lcmp
    //   132: ifeq +91 -> 223
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
    //   161: ifeq +75 -> 236
    //   164: aload 6
    //   166: arraylength
    //   167: i2l
    //   168: lload_3
    //   169: lload 9
    //   171: lsub
    //   172: invokestatic 81	java/lang/Math:min	(JJ)J
    //   175: l2i
    //   176: istore 8
    //   178: aload 5
    //   180: aload 6
    //   182: iconst_0
    //   183: iload 8
    //   185: invokeinterface 85 4 0
    //   190: istore 8
    //   192: iload 8
    //   194: iconst_m1
    //   195: if_icmpne +49 -> 244
    //   198: aload 7
    //   200: getfield 75	com/google/android/exoplayer2/h/a/h$a:contentLength	J
    //   203: ldc2_w 55
    //   206: lcmp
    //   207: ifne +16 -> 223
    //   210: aload 7
    //   212: aload 11
    //   214: getfield 54	com/google/android/exoplayer2/h/j:bos	J
    //   217: lload 9
    //   219: ladd
    //   220: putfield 75	com/google/android/exoplayer2/h/a/h$a:contentLength	J
    //   223: aload 5
    //   225: invokestatic 37	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   228: ldc 11
    //   230: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: lload 9
    //   235: lreturn
    //   236: aload 6
    //   238: arraylength
    //   239: istore 8
    //   241: goto -63 -> 178
    //   244: lload 9
    //   246: iload 8
    //   248: i2l
    //   249: ladd
    //   250: lstore 9
    //   252: aload 7
    //   254: aload 7
    //   256: getfield 88	com/google/android/exoplayer2/h/a/h$a:bpX	J
    //   259: iload 8
    //   261: i2l
    //   262: ladd
    //   263: putfield 88	com/google/android/exoplayer2/h/a/h$a:bpX	J
    //   266: goto -138 -> 128
    //   269: astore_0
    //   270: aload 5
    //   272: invokestatic 37	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   275: ldc 11
    //   277: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload_0
    //   281: athrow
    //   282: lconst_0
    //   283: lstore 9
    //   285: goto -157 -> 128
    //   288: astore_0
    //   289: aload 11
    //   291: astore_0
    //   292: goto -262 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	paramj	j
    //   0	295	1	paramLong1	long
    //   0	295	3	paramLong2	long
    //   0	295	5	paramg	com.google.android.exoplayer2.h.g
    //   0	295	6	paramArrayOfByte	byte[]
    //   0	295	7	parama	a
    //   176	84	8	i	int
    //   89	195	9	l	long
    //   18	8	11	localInterruptedException	java.lang.InterruptedException
    //   28	1	11	locala	com.google.android.exoplayer2.i.p.a
    //   78	212	11	localj	j
    // Exception table:
    //   from	to	target	type
    //   5	28	28	com/google/android/exoplayer2/i/p$a
    //   38	80	28	com/google/android/exoplayer2/i/p$a
    //   5	28	269	finally
    //   38	80	269	finally
    //   80	103	269	finally
    //   112	125	269	finally
    //   135	156	269	finally
    //   164	178	269	finally
    //   178	192	269	finally
    //   198	223	269	finally
    //   236	241	269	finally
    //   252	266	269	finally
    //   80	103	288	com/google/android/exoplayer2/i/p$a
    //   112	125	288	com/google/android/exoplayer2/i/p$a
    //   135	156	288	com/google/android/exoplayer2/i/p$a
    //   164	178	288	com/google/android/exoplayer2/i/p$a
    //   178	192	288	com/google/android/exoplayer2/i/p$a
    //   198	223	288	com/google/android/exoplayer2/i/p$a
    //   236	241	288	com/google/android/exoplayer2/i/p$a
    //   252	266	288	com/google/android/exoplayer2/i/p$a
  }
  
  public static void a(j paramj, a parama, d paramd, byte[] paramArrayOfByte, a parama1)
  {
    AppMethodBeat.i(199193);
    com.google.android.exoplayer2.i.a.checkNotNull(paramd);
    com.google.android.exoplayer2.i.a.checkNotNull(paramArrayOfByte);
    String str = c(paramj);
    long l3 = paramj.bos;
    long l1;
    label63:
    long l2;
    if (paramj.aFL != -1L)
    {
      l1 = paramj.aFL;
      parama1.contentLength = l1;
      parama1.bpW = 0L;
      parama1.bpX = 0L;
      if (l1 == 0L) {
        break label185;
      }
      if (l1 == -1L) {
        break label159;
      }
      l2 = l1;
      label83:
      l2 = parama.f(str, l3, l2);
      if (l2 <= 0L) {
        break label167;
      }
      parama1.bpW += l2;
    }
    label159:
    label167:
    do
    {
      if (l1 != -1L) {
        break label311;
      }
      l4 = 0L;
      l1 -= l4;
      l3 += l2;
      break label63;
      l1 = parama.bA(str);
      break;
      l2 = 9223372036854775807L;
      break label83;
      l4 = -l2;
      l2 = l4;
    } while (l4 != 9223372036854775807L);
    label185:
    str = c(paramj);
    l3 = paramj.bos;
    if (paramj.aFL != -1L)
    {
      l1 = paramj.aFL;
      label214:
      if (l1 == 0L) {
        break label346;
      }
      if (l1 == -1L) {
        break label331;
      }
      l2 = l1;
      label234:
      l4 = parama.f(str, l3, l2);
      l2 = l4;
      if (l4 <= 0L)
      {
        l2 = -l4;
        if (a(paramj, l3, l2, paramd, paramArrayOfByte, parama1) < l2) {
          break label346;
        }
      }
      if (l1 != -1L) {
        break label339;
      }
    }
    label311:
    label331:
    label339:
    for (long l4 = 0L;; l4 = l2)
    {
      l1 -= l4;
      l3 += l2;
      break label214;
      l4 = l2;
      break;
      l1 = parama.bA(str);
      break label214;
      l2 = 9223372036854775807L;
      break label234;
    }
    label346:
    AppMethodBeat.o(199193);
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
    public volatile long bpW;
    public volatile long bpX;
    public volatile long contentLength = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.h
 * JD-Core Version:    0.7.0.1
 */