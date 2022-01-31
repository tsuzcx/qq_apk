package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.g;

final class f$b
{
  private final g aBV;
  private final e[] aPP;
  e aPQ;
  
  public f$b(e[] paramArrayOfe, g paramg)
  {
    this.aPP = paramArrayOfe;
    this.aBV = paramg;
  }
  
  /* Error */
  public final e a(com.google.android.exoplayer2.c.f paramf, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: ldc 28
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 36	com/google/android/exoplayer2/source/f$b:aPQ	Lcom/google/android/exoplayer2/c/e;
    //   9: ifnull +15 -> 24
    //   12: aload_0
    //   13: getfield 36	com/google/android/exoplayer2/source/f$b:aPQ	Lcom/google/android/exoplayer2/c/e;
    //   16: astore_1
    //   17: ldc 28
    //   19: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: aload_1
    //   23: areturn
    //   24: aload_0
    //   25: getfield 20	com/google/android/exoplayer2/source/f$b:aPP	[Lcom/google/android/exoplayer2/c/e;
    //   28: astore 5
    //   30: aload 5
    //   32: arraylength
    //   33: istore 4
    //   35: iconst_0
    //   36: istore_3
    //   37: iload_3
    //   38: iload 4
    //   40: if_icmpge +32 -> 72
    //   43: aload 5
    //   45: iload_3
    //   46: aaload
    //   47: astore 6
    //   49: aload 6
    //   51: aload_1
    //   52: invokeinterface 44 2 0
    //   57: ifeq +65 -> 122
    //   60: aload_0
    //   61: aload 6
    //   63: putfield 36	com/google/android/exoplayer2/source/f$b:aPQ	Lcom/google/android/exoplayer2/c/e;
    //   66: aload_1
    //   67: invokeinterface 49 1 0
    //   72: aload_0
    //   73: getfield 36	com/google/android/exoplayer2/source/f$b:aPQ	Lcom/google/android/exoplayer2/c/e;
    //   76: ifnonnull +84 -> 160
    //   79: new 51	com/google/android/exoplayer2/source/q
    //   82: dup
    //   83: new 53	java/lang/StringBuilder
    //   86: dup
    //   87: ldc 55
    //   89: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: getfield 20	com/google/android/exoplayer2/source/f$b:aPP	[Lcom/google/android/exoplayer2/c/e;
    //   96: invokestatic 64	com/google/android/exoplayer2/i/x:d	([Ljava/lang/Object;)Ljava/lang/String;
    //   99: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc 70
    //   104: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: aload_2
    //   111: invokespecial 77	com/google/android/exoplayer2/source/q:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   114: astore_1
    //   115: ldc 28
    //   117: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: aload_1
    //   123: invokeinterface 49 1 0
    //   128: iload_3
    //   129: iconst_1
    //   130: iadd
    //   131: istore_3
    //   132: goto -95 -> 37
    //   135: astore 6
    //   137: aload_1
    //   138: invokeinterface 49 1 0
    //   143: goto -15 -> 128
    //   146: astore_2
    //   147: aload_1
    //   148: invokeinterface 49 1 0
    //   153: ldc 28
    //   155: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_2
    //   159: athrow
    //   160: aload_0
    //   161: getfield 36	com/google/android/exoplayer2/source/f$b:aPQ	Lcom/google/android/exoplayer2/c/e;
    //   164: aload_0
    //   165: getfield 22	com/google/android/exoplayer2/source/f$b:aBV	Lcom/google/android/exoplayer2/c/g;
    //   168: invokeinterface 80 2 0
    //   173: aload_0
    //   174: getfield 36	com/google/android/exoplayer2/source/f$b:aPQ	Lcom/google/android/exoplayer2/c/e;
    //   177: astore_1
    //   178: ldc 28
    //   180: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_1
    //   184: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	b
    //   0	185	1	paramf	com.google.android.exoplayer2.c.f
    //   0	185	2	paramUri	android.net.Uri
    //   36	96	3	i	int
    //   33	8	4	j	int
    //   28	16	5	arrayOfe	e[]
    //   47	15	6	locale	e
    //   135	1	6	localEOFException	java.io.EOFException
    // Exception table:
    //   from	to	target	type
    //   49	66	135	java/io/EOFException
    //   49	66	146	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.f.b
 * JD-Core Version:    0.7.0.1
 */