package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.t.c;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$a
  implements t.c
{
  private final g aBo;
  long aPF;
  private final k aPL;
  private volatile boolean aPM;
  private boolean aPN;
  private long aPO;
  private final f.b aPq;
  private final com.google.android.exoplayer2.i.f aPr;
  private final Uri uri;
  
  public f$a(f paramf, Uri paramUri, g paramg, f.b paramb, com.google.android.exoplayer2.i.f paramf1)
  {
    AppMethodBeat.i(95480);
    this.uri = ((Uri)a.checkNotNull(paramUri));
    this.aBo = ((g)a.checkNotNull(paramg));
    this.aPq = ((f.b)a.checkNotNull(paramb));
    this.aPr = paramf1;
    this.aPL = new k();
    this.aPN = true;
    this.aPF = -1L;
    AppMethodBeat.o(95480);
  }
  
  public final void j(long paramLong1, long paramLong2)
  {
    this.aPL.position = paramLong1;
    this.aPO = paramLong2;
    this.aPN = true;
  }
  
  public final void pf()
  {
    this.aPM = true;
  }
  
  public final boolean pg()
  {
    return this.aPM;
  }
  
  /* Error */
  public final void ph()
  {
    // Byte code:
    //   0: ldc 90
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_0
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +305 -> 313
    //   11: aload_0
    //   12: getfield 86	com/google/android/exoplayer2/source/f$a:aPM	Z
    //   15: ifne +298 -> 313
    //   18: aload_0
    //   19: getfield 66	com/google/android/exoplayer2/source/f$a:aPL	Lcom/google/android/exoplayer2/c/k;
    //   22: getfield 81	com/google/android/exoplayer2/c/k:position	J
    //   25: lstore_3
    //   26: aload_0
    //   27: aload_0
    //   28: getfield 55	com/google/android/exoplayer2/source/f$a:aBo	Lcom/google/android/exoplayer2/h/g;
    //   31: new 92	com/google/android/exoplayer2/h/j
    //   34: dup
    //   35: aload_0
    //   36: getfield 51	com/google/android/exoplayer2/source/f$a:uri	Landroid/net/Uri;
    //   39: lload_3
    //   40: ldc2_w 69
    //   43: aload_0
    //   44: getfield 31	com/google/android/exoplayer2/source/f$a:aPK	Lcom/google/android/exoplayer2/source/f;
    //   47: getfield 96	com/google/android/exoplayer2/source/f:aPn	Ljava/lang/String;
    //   50: invokespecial 99	com/google/android/exoplayer2/h/j:<init>	(Landroid/net/Uri;JJLjava/lang/String;)V
    //   53: invokeinterface 102 2 0
    //   58: putfield 72	com/google/android/exoplayer2/source/f$a:aPF	J
    //   61: aload_0
    //   62: getfield 72	com/google/android/exoplayer2/source/f$a:aPF	J
    //   65: ldc2_w 69
    //   68: lcmp
    //   69: ifeq +13 -> 82
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 72	com/google/android/exoplayer2/source/f$a:aPF	J
    //   77: lload_3
    //   78: ladd
    //   79: putfield 72	com/google/android/exoplayer2/source/f$a:aPF	J
    //   82: new 104	com/google/android/exoplayer2/c/b
    //   85: dup
    //   86: aload_0
    //   87: getfield 55	com/google/android/exoplayer2/source/f$a:aBo	Lcom/google/android/exoplayer2/h/g;
    //   90: lload_3
    //   91: aload_0
    //   92: getfield 72	com/google/android/exoplayer2/source/f$a:aPF	J
    //   95: invokespecial 107	com/google/android/exoplayer2/c/b:<init>	(Lcom/google/android/exoplayer2/h/g;JJ)V
    //   98: astore 5
    //   100: aload_0
    //   101: getfield 59	com/google/android/exoplayer2/source/f$a:aPq	Lcom/google/android/exoplayer2/source/f$b;
    //   104: aload 5
    //   106: aload_0
    //   107: getfield 55	com/google/android/exoplayer2/source/f$a:aBo	Lcom/google/android/exoplayer2/h/g;
    //   110: invokeinterface 111 1 0
    //   115: invokevirtual 114	com/google/android/exoplayer2/source/f$b:a	(Lcom/google/android/exoplayer2/c/f;Landroid/net/Uri;)Lcom/google/android/exoplayer2/c/e;
    //   118: astore 6
    //   120: aload_0
    //   121: getfield 68	com/google/android/exoplayer2/source/f$a:aPN	Z
    //   124: ifeq +20 -> 144
    //   127: aload 6
    //   129: lload_3
    //   130: aload_0
    //   131: getfield 83	com/google/android/exoplayer2/source/f$a:aPO	J
    //   134: invokeinterface 119 5 0
    //   139: aload_0
    //   140: iconst_0
    //   141: putfield 68	com/google/android/exoplayer2/source/f$a:aPN	Z
    //   144: iload_1
    //   145: ifne +90 -> 235
    //   148: aload_0
    //   149: getfield 86	com/google/android/exoplayer2/source/f$a:aPM	Z
    //   152: ifne +83 -> 235
    //   155: aload_0
    //   156: getfield 61	com/google/android/exoplayer2/source/f$a:aPr	Lcom/google/android/exoplayer2/i/f;
    //   159: invokevirtual 124	com/google/android/exoplayer2/i/f:block	()V
    //   162: aload 6
    //   164: aload 5
    //   166: aload_0
    //   167: getfield 66	com/google/android/exoplayer2/source/f$a:aPL	Lcom/google/android/exoplayer2/c/k;
    //   170: invokeinterface 127 3 0
    //   175: istore_2
    //   176: iload_2
    //   177: istore_1
    //   178: aload 5
    //   180: invokeinterface 133 1 0
    //   185: aload_0
    //   186: getfield 31	com/google/android/exoplayer2/source/f$a:aPK	Lcom/google/android/exoplayer2/source/f;
    //   189: getfield 136	com/google/android/exoplayer2/source/f:aPo	J
    //   192: lload_3
    //   193: ladd
    //   194: lcmp
    //   195: ifle +171 -> 366
    //   198: aload 5
    //   200: invokeinterface 133 1 0
    //   205: lstore_3
    //   206: aload_0
    //   207: getfield 61	com/google/android/exoplayer2/source/f$a:aPr	Lcom/google/android/exoplayer2/i/f;
    //   210: invokevirtual 139	com/google/android/exoplayer2/i/f:qH	()Z
    //   213: pop
    //   214: aload_0
    //   215: getfield 31	com/google/android/exoplayer2/source/f$a:aPK	Lcom/google/android/exoplayer2/source/f;
    //   218: getfield 143	com/google/android/exoplayer2/source/f:handler	Landroid/os/Handler;
    //   221: aload_0
    //   222: getfield 31	com/google/android/exoplayer2/source/f$a:aPK	Lcom/google/android/exoplayer2/source/f;
    //   225: getfield 147	com/google/android/exoplayer2/source/f:aPt	Ljava/lang/Runnable;
    //   228: invokevirtual 153	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   231: pop
    //   232: goto -88 -> 144
    //   235: iload_1
    //   236: iconst_1
    //   237: if_icmpne +15 -> 252
    //   240: iconst_0
    //   241: istore_1
    //   242: aload_0
    //   243: getfield 55	com/google/android/exoplayer2/source/f$a:aBo	Lcom/google/android/exoplayer2/h/g;
    //   246: invokestatic 158	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   249: goto -242 -> 7
    //   252: aload_0
    //   253: getfield 66	com/google/android/exoplayer2/source/f$a:aPL	Lcom/google/android/exoplayer2/c/k;
    //   256: aload 5
    //   258: invokeinterface 133 1 0
    //   263: putfield 81	com/google/android/exoplayer2/c/k:position	J
    //   266: goto -24 -> 242
    //   269: astore 5
    //   271: aconst_null
    //   272: astore 6
    //   274: iload_1
    //   275: iconst_1
    //   276: if_icmpeq +22 -> 298
    //   279: aload 6
    //   281: ifnull +17 -> 298
    //   284: aload_0
    //   285: getfield 66	com/google/android/exoplayer2/source/f$a:aPL	Lcom/google/android/exoplayer2/c/k;
    //   288: aload 6
    //   290: invokeinterface 133 1 0
    //   295: putfield 81	com/google/android/exoplayer2/c/k:position	J
    //   298: aload_0
    //   299: getfield 55	com/google/android/exoplayer2/source/f$a:aBo	Lcom/google/android/exoplayer2/h/g;
    //   302: invokestatic 158	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   305: ldc 90
    //   307: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: aload 5
    //   312: athrow
    //   313: ldc 90
    //   315: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: return
    //   319: astore 6
    //   321: aload 5
    //   323: astore 7
    //   325: aload 6
    //   327: astore 5
    //   329: aload 7
    //   331: astore 6
    //   333: goto -59 -> 274
    //   336: astore 7
    //   338: aload 5
    //   340: astore 6
    //   342: aload 7
    //   344: astore 5
    //   346: goto -72 -> 274
    //   349: astore 6
    //   351: aload 5
    //   353: astore 7
    //   355: aload 6
    //   357: astore 5
    //   359: aload 7
    //   361: astore 6
    //   363: goto -89 -> 274
    //   366: goto -222 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	a
    //   6	271	1	i	int
    //   175	2	2	j	int
    //   25	181	3	l	long
    //   98	159	5	localb	com.google.android.exoplayer2.c.b
    //   269	53	5	localObject1	Object
    //   327	31	5	localObject2	Object
    //   118	171	6	locale	com.google.android.exoplayer2.c.e
    //   319	7	6	localObject3	Object
    //   331	10	6	localObject4	Object
    //   349	7	6	localObject5	Object
    //   361	1	6	localObject6	Object
    //   323	7	7	localObject7	Object
    //   336	7	7	localObject8	Object
    //   353	7	7	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   18	82	269	finally
    //   82	100	269	finally
    //   100	144	319	finally
    //   148	176	336	finally
    //   178	232	349	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.source.f.a
 * JD-Core Version:    0.7.0.1
 */