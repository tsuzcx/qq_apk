package com.google.android.exoplayer2.h;

import java.util.Arrays;

public final class j
  implements b
{
  private final boolean aQX;
  private final int aQY;
  private final byte[] aQZ;
  private final a[] aRa;
  private int aRb;
  private int aRc;
  private a[] aRd;
  private int asW;
  
  public j()
  {
    this((byte)0);
  }
  
  private j(byte paramByte)
  {
    com.google.android.exoplayer2.i.a.aB(true);
    com.google.android.exoplayer2.i.a.aB(true);
    this.aQX = true;
    this.aQY = 65536;
    this.aRc = 0;
    this.aRd = new a[100];
    this.aQZ = null;
    this.aRa = new a[1];
  }
  
  public final void a(a parama)
  {
    try
    {
      this.aRa[0] = parama;
      a(this.aRa);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public final void a(a[] paramArrayOfa)
  {
    for (;;)
    {
      try
      {
        if (this.aRc + paramArrayOfa.length >= this.aRd.length) {
          this.aRd = ((a[])Arrays.copyOf(this.aRd, Math.max(this.aRd.length * 2, this.aRc + paramArrayOfa.length)));
        }
        int j = paramArrayOfa.length;
        int i = 0;
        if (i < j)
        {
          a locala = paramArrayOfa[i];
          if (locala.data != this.aQZ)
          {
            if (locala.data.length != this.aQY) {
              break label159;
            }
            break label153;
            com.google.android.exoplayer2.i.a.aB(bool);
            a[] arrayOfa = this.aRd;
            int k = this.aRc;
            this.aRc = (k + 1);
            arrayOfa[k] = locala;
            i += 1;
          }
        }
        else
        {
          this.aRb -= paramArrayOfa.length;
          notifyAll();
          return;
        }
      }
      finally {}
      label153:
      boolean bool = true;
      continue;
      label159:
      bool = false;
    }
  }
  
  /* Error */
  public final void dw(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: aload_0
    //   4: getfield 77	com/google/android/exoplayer2/h/j:asW	I
    //   7: if_icmpge +21 -> 28
    //   10: iconst_1
    //   11: istore_2
    //   12: aload_0
    //   13: iload_1
    //   14: putfield 77	com/google/android/exoplayer2/h/j:asW	I
    //   17: iload_2
    //   18: ifeq +7 -> 25
    //   21: aload_0
    //   22: invokevirtual 80	com/google/android/exoplayer2/h/j:nN	()V
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: iconst_0
    //   29: istore_2
    //   30: goto -18 -> 12
    //   33: astore_3
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_3
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	j
    //   0	38	1	paramInt	int
    //   11	19	2	i	int
    //   33	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	33	finally
    //   12	17	33	finally
    //   21	25	33	finally
  }
  
  /* Error */
  public final a nM()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 70	com/google/android/exoplayer2/h/j:aRb	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 70	com/google/android/exoplayer2/h/j:aRb	I
    //   12: aload_0
    //   13: getfield 39	com/google/android/exoplayer2/h/j:aRc	I
    //   16: ifle +38 -> 54
    //   19: aload_0
    //   20: getfield 43	com/google/android/exoplayer2/h/j:aRd	[Lcom/google/android/exoplayer2/h/a;
    //   23: astore_2
    //   24: aload_0
    //   25: getfield 39	com/google/android/exoplayer2/h/j:aRc	I
    //   28: iconst_1
    //   29: isub
    //   30: istore_1
    //   31: aload_0
    //   32: iload_1
    //   33: putfield 39	com/google/android/exoplayer2/h/j:aRc	I
    //   36: aload_2
    //   37: iload_1
    //   38: aaload
    //   39: astore_2
    //   40: aload_0
    //   41: getfield 43	com/google/android/exoplayer2/h/j:aRd	[Lcom/google/android/exoplayer2/h/a;
    //   44: aload_0
    //   45: getfield 39	com/google/android/exoplayer2/h/j:aRc	I
    //   48: aconst_null
    //   49: aastore
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: areturn
    //   54: new 41	com/google/android/exoplayer2/h/a
    //   57: dup
    //   58: aload_0
    //   59: getfield 37	com/google/android/exoplayer2/h/j:aQY	I
    //   62: newarray byte
    //   64: invokespecial 85	com/google/android/exoplayer2/h/a:<init>	([B)V
    //   67: astore_2
    //   68: goto -18 -> 50
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	j
    //   30	8	1	i	int
    //   23	45	2	localObject1	Object
    //   71	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	36	71	finally
    //   40	50	71	finally
    //   54	68	71	finally
  }
  
  /* Error */
  public final void nN()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: aload_0
    //   4: getfield 77	com/google/android/exoplayer2/h/j:asW	I
    //   7: aload_0
    //   8: getfield 37	com/google/android/exoplayer2/h/j:aQY	I
    //   11: invokestatic 90	com/google/android/exoplayer2/i/t:aJ	(II)I
    //   14: aload_0
    //   15: getfield 70	com/google/android/exoplayer2/h/j:aRb	I
    //   18: isub
    //   19: invokestatic 58	java/lang/Math:max	(II)I
    //   22: istore_3
    //   23: aload_0
    //   24: getfield 39	com/google/android/exoplayer2/h/j:aRc	I
    //   27: istore_1
    //   28: iload_3
    //   29: iload_1
    //   30: if_icmplt +6 -> 36
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: iload_3
    //   37: istore_1
    //   38: aload_0
    //   39: getfield 45	com/google/android/exoplayer2/h/j:aQZ	[B
    //   42: ifnull +112 -> 154
    //   45: aload_0
    //   46: getfield 39	com/google/android/exoplayer2/h/j:aRc	I
    //   49: iconst_1
    //   50: isub
    //   51: istore_2
    //   52: iconst_0
    //   53: istore_1
    //   54: iload_1
    //   55: iload_2
    //   56: if_icmpgt +84 -> 140
    //   59: aload_0
    //   60: getfield 43	com/google/android/exoplayer2/h/j:aRd	[Lcom/google/android/exoplayer2/h/a;
    //   63: iload_1
    //   64: aaload
    //   65: astore 4
    //   67: aload 4
    //   69: getfield 68	com/google/android/exoplayer2/h/a:data	[B
    //   72: aload_0
    //   73: getfield 45	com/google/android/exoplayer2/h/j:aQZ	[B
    //   76: if_acmpne +10 -> 86
    //   79: iload_1
    //   80: iconst_1
    //   81: iadd
    //   82: istore_1
    //   83: goto -29 -> 54
    //   86: aload_0
    //   87: getfield 43	com/google/android/exoplayer2/h/j:aRd	[Lcom/google/android/exoplayer2/h/a;
    //   90: iload_2
    //   91: aaload
    //   92: astore 5
    //   94: aload 5
    //   96: getfield 68	com/google/android/exoplayer2/h/a:data	[B
    //   99: aload_0
    //   100: getfield 45	com/google/android/exoplayer2/h/j:aQZ	[B
    //   103: if_acmpeq +10 -> 113
    //   106: iload_2
    //   107: iconst_1
    //   108: isub
    //   109: istore_2
    //   110: goto -56 -> 54
    //   113: aload_0
    //   114: getfield 43	com/google/android/exoplayer2/h/j:aRd	[Lcom/google/android/exoplayer2/h/a;
    //   117: iload_1
    //   118: aload 5
    //   120: aastore
    //   121: aload_0
    //   122: getfield 43	com/google/android/exoplayer2/h/j:aRd	[Lcom/google/android/exoplayer2/h/a;
    //   125: iload_2
    //   126: aload 4
    //   128: aastore
    //   129: iload_2
    //   130: iconst_1
    //   131: isub
    //   132: istore_2
    //   133: iload_1
    //   134: iconst_1
    //   135: iadd
    //   136: istore_1
    //   137: goto -83 -> 54
    //   140: iload_3
    //   141: iload_1
    //   142: invokestatic 58	java/lang/Math:max	(II)I
    //   145: istore_1
    //   146: iload_1
    //   147: aload_0
    //   148: getfield 39	com/google/android/exoplayer2/h/j:aRc	I
    //   151: if_icmpge -118 -> 33
    //   154: aload_0
    //   155: getfield 43	com/google/android/exoplayer2/h/j:aRd	[Lcom/google/android/exoplayer2/h/a;
    //   158: iload_1
    //   159: aload_0
    //   160: getfield 39	com/google/android/exoplayer2/h/j:aRc	I
    //   163: aconst_null
    //   164: invokestatic 94	java/util/Arrays:fill	([Ljava/lang/Object;IILjava/lang/Object;)V
    //   167: aload_0
    //   168: iload_1
    //   169: putfield 39	com/google/android/exoplayer2/h/j:aRc	I
    //   172: goto -139 -> 33
    //   175: astore 4
    //   177: aload_0
    //   178: monitorexit
    //   179: aload 4
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	j
    //   27	142	1	i	int
    //   51	82	2	j	int
    //   22	119	3	k	int
    //   65	62	4	locala1	a
    //   175	5	4	localObject	Object
    //   92	27	5	locala2	a
    // Exception table:
    //   from	to	target	type
    //   2	28	175	finally
    //   38	52	175	finally
    //   59	79	175	finally
    //   86	106	175	finally
    //   113	129	175	finally
    //   140	154	175	finally
    //   154	172	175	finally
  }
  
  public final int nO()
  {
    return this.aQY;
  }
  
  public final int nS()
  {
    try
    {
      int i = this.aRb;
      int j = this.aQY;
      return i * j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void reset()
  {
    try
    {
      if (this.aQX) {
        dw(0);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.j
 * JD-Core Version:    0.7.0.1
 */