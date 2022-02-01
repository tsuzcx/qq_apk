package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.m.a;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  private int[] aWC;
  private long[] aWE;
  private int[] bbW;
  public int[] blA;
  private m.a[] blB;
  private Format[] blC;
  private int blD;
  private int blE;
  public int blF;
  private long blG;
  private long blH;
  private boolean blI;
  private boolean blJ;
  private Format blK;
  public int blL;
  private int blz;
  private int length;
  private long[] offsets;
  
  public k()
  {
    AppMethodBeat.i(92681);
    this.blz = 1000;
    this.blA = new int[this.blz];
    this.offsets = new long[this.blz];
    this.aWE = new long[this.blz];
    this.bbW = new int[this.blz];
    this.aWC = new int[this.blz];
    this.blB = new m.a[this.blz];
    this.blC = new Format[this.blz];
    this.blG = -9223372036854775808L;
    this.blH = -9223372036854775808L;
    this.blJ = true;
    this.blI = true;
    AppMethodBeat.o(92681);
  }
  
  private void Z(long paramLong)
  {
    try
    {
      AppMethodBeat.i(92691);
      this.blH = Math.max(this.blH, paramLong);
      AppMethodBeat.o(92691);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private int a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    int j = -1;
    int k = 0;
    int i = paramInt1;
    paramInt1 = k;
    while ((paramInt1 < paramInt2) && (this.aWE[i] <= paramLong))
    {
      if ((!paramBoolean) || ((this.bbW[i] & 0x1) != 0)) {
        j = paramInt1;
      }
      k = i + 1;
      i = k;
      if (k == this.blz) {
        i = 0;
      }
      paramInt1 += 1;
    }
    return j;
  }
  
  private long eA(int paramInt)
  {
    AppMethodBeat.i(92694);
    if (paramInt == 0)
    {
      AppMethodBeat.o(92694);
      return -9223372036854775808L;
    }
    int i = eB(paramInt - 1);
    int j = 0;
    long l1 = -9223372036854775808L;
    long l2;
    for (;;)
    {
      l2 = l1;
      if (j >= paramInt) {
        break;
      }
      l1 = Math.max(l1, this.aWE[i]);
      l2 = l1;
      if ((this.bbW[i] & 0x1) != 0) {
        break;
      }
      int k = i - 1;
      i = k;
      if (k == -1) {
        i = this.blz - 1;
      }
      j += 1;
    }
    AppMethodBeat.o(92694);
    return l2;
  }
  
  private long ez(int paramInt)
  {
    AppMethodBeat.i(92693);
    this.blG = Math.max(this.blG, eA(paramInt));
    this.length -= paramInt;
    this.blD += paramInt;
    this.blE += paramInt;
    if (this.blE >= this.blz) {
      this.blE -= this.blz;
    }
    this.blF -= paramInt;
    if (this.blF < 0) {
      this.blF = 0;
    }
    if (this.length == 0)
    {
      if (this.blE == 0) {}
      for (paramInt = this.blz;; paramInt = this.blE)
      {
        paramInt -= 1;
        l1 = this.offsets[paramInt];
        long l2 = this.aWC[paramInt];
        AppMethodBeat.o(92693);
        return l2 + l1;
      }
    }
    long l1 = this.offsets[this.blE];
    AppMethodBeat.o(92693);
    return l1;
  }
  
  public final int a(com.google.android.exoplayer2.k paramk, e parame, boolean paramBoolean1, boolean paramBoolean2, Format paramFormat, a parama)
  {
    int j = -4;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(92683);
        int i;
        if (!tT())
        {
          if (paramBoolean2)
          {
            parame.flags = 4;
            AppMethodBeat.o(92683);
            i = j;
            return i;
          }
          if ((this.blK != null) && ((paramBoolean1) || (this.blK != paramFormat)))
          {
            paramk.aSv = this.blK;
            AppMethodBeat.o(92683);
            i = -5;
            continue;
          }
          AppMethodBeat.o(92683);
          i = -3;
          continue;
        }
        int k = eB(this.blF);
        if ((paramBoolean1) || (this.blC[k] != paramFormat))
        {
          paramk.aSv = this.blC[k];
          AppMethodBeat.o(92683);
          i = -5;
        }
        else if ((parame.aIq == null) && (parame.aWm == 0))
        {
          i = 1;
          if (i != 0)
          {
            AppMethodBeat.o(92683);
            i = -3;
          }
          else
          {
            parame.timeUs = this.aWE[k];
            parame.flags = this.bbW[k];
            parama.size = this.aWC[k];
            parama.offset = this.offsets[k];
            parama.aYO = this.blB[k];
            this.blF += 1;
            AppMethodBeat.o(92683);
            i = j;
          }
        }
        else
        {
          i = 0;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public final long a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 148
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 100	com/google/android/exoplayer2/source/k:length	I
    //   11: ifeq +17 -> 28
    //   14: lload_1
    //   15: aload_0
    //   16: getfield 52	com/google/android/exoplayer2/source/k:aWE	[J
    //   19: aload_0
    //   20: getfield 104	com/google/android/exoplayer2/source/k:blE	I
    //   23: laload
    //   24: lcmp
    //   25: ifge +16 -> 41
    //   28: ldc 148
    //   30: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: ldc2_w 149
    //   36: lstore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: lload_1
    //   40: lreturn
    //   41: iload 4
    //   43: ifeq +54 -> 97
    //   46: aload_0
    //   47: getfield 106	com/google/android/exoplayer2/source/k:blF	I
    //   50: aload_0
    //   51: getfield 100	com/google/android/exoplayer2/source/k:length	I
    //   54: if_icmpeq +43 -> 97
    //   57: aload_0
    //   58: getfield 106	com/google/android/exoplayer2/source/k:blF	I
    //   61: iconst_1
    //   62: iadd
    //   63: istore 5
    //   65: aload_0
    //   66: aload_0
    //   67: getfield 104	com/google/android/exoplayer2/source/k:blE	I
    //   70: iload 5
    //   72: lload_1
    //   73: iload_3
    //   74: invokespecial 152	com/google/android/exoplayer2/source/k:a	(IIJZ)I
    //   77: istore 5
    //   79: iload 5
    //   81: iconst_m1
    //   82: if_icmpne +24 -> 106
    //   85: ldc 148
    //   87: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: ldc2_w 149
    //   93: lstore_1
    //   94: goto -57 -> 37
    //   97: aload_0
    //   98: getfield 100	com/google/android/exoplayer2/source/k:length	I
    //   101: istore 5
    //   103: goto -38 -> 65
    //   106: aload_0
    //   107: iload 5
    //   109: invokespecial 154	com/google/android/exoplayer2/source/k:ez	(I)J
    //   112: lstore_1
    //   113: ldc 148
    //   115: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: goto -81 -> 37
    //   121: astore 6
    //   123: aload_0
    //   124: monitorexit
    //   125: aload 6
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	k
    //   0	128	1	paramLong	long
    //   0	128	3	paramBoolean1	boolean
    //   0	128	4	paramBoolean2	boolean
    //   63	45	5	i	int
    //   121	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	28	121	finally
    //   28	33	121	finally
    //   46	65	121	finally
    //   65	79	121	finally
    //   85	90	121	finally
    //   97	103	121	finally
    //   106	118	121	finally
  }
  
  public final void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, m.a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(92690);
        if (this.blI)
        {
          if ((paramInt1 & 0x1) == 0)
          {
            AppMethodBeat.o(92690);
            return;
          }
          this.blI = false;
        }
        boolean bool;
        if (!this.blJ)
        {
          bool = true;
          a.checkState(bool);
          Z(paramLong1);
          int i = eB(this.length);
          this.aWE[i] = paramLong1;
          this.offsets[i] = paramLong2;
          this.aWC[i] = paramInt2;
          this.bbW[i] = paramInt1;
          this.blB[i] = parama;
          this.blC[i] = this.blK;
          this.blA[i] = this.blL;
          this.length += 1;
          if (this.length == this.blz)
          {
            paramInt1 = this.blz + 1000;
            parama = new int[paramInt1];
            long[] arrayOfLong1 = new long[paramInt1];
            long[] arrayOfLong2 = new long[paramInt1];
            int[] arrayOfInt1 = new int[paramInt1];
            int[] arrayOfInt2 = new int[paramInt1];
            m.a[] arrayOfa = new m.a[paramInt1];
            Format[] arrayOfFormat = new Format[paramInt1];
            paramInt2 = this.blz - this.blE;
            System.arraycopy(this.offsets, this.blE, arrayOfLong1, 0, paramInt2);
            System.arraycopy(this.aWE, this.blE, arrayOfLong2, 0, paramInt2);
            System.arraycopy(this.bbW, this.blE, arrayOfInt1, 0, paramInt2);
            System.arraycopy(this.aWC, this.blE, arrayOfInt2, 0, paramInt2);
            System.arraycopy(this.blB, this.blE, arrayOfa, 0, paramInt2);
            System.arraycopy(this.blC, this.blE, arrayOfFormat, 0, paramInt2);
            System.arraycopy(this.blA, this.blE, parama, 0, paramInt2);
            i = this.blE;
            System.arraycopy(this.offsets, 0, arrayOfLong1, paramInt2, i);
            System.arraycopy(this.aWE, 0, arrayOfLong2, paramInt2, i);
            System.arraycopy(this.bbW, 0, arrayOfInt1, paramInt2, i);
            System.arraycopy(this.aWC, 0, arrayOfInt2, paramInt2, i);
            System.arraycopy(this.blB, 0, arrayOfa, paramInt2, i);
            System.arraycopy(this.blC, 0, arrayOfFormat, paramInt2, i);
            System.arraycopy(this.blA, 0, parama, paramInt2, i);
            this.offsets = arrayOfLong1;
            this.aWE = arrayOfLong2;
            this.bbW = arrayOfInt1;
            this.aWC = arrayOfInt2;
            this.blB = arrayOfa;
            this.blC = arrayOfFormat;
            this.blA = parama;
            this.blE = 0;
            this.length = this.blz;
            this.blz = paramInt1;
          }
          AppMethodBeat.o(92690);
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public final boolean aa(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 175
    //   7: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 100	com/google/android/exoplayer2/source/k:length	I
    //   14: ifne +33 -> 47
    //   17: lload_1
    //   18: aload_0
    //   19: getfield 68	com/google/android/exoplayer2/source/k:blG	J
    //   22: lcmp
    //   23: ifle +13 -> 36
    //   26: ldc 175
    //   28: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: iload 7
    //   35: ireturn
    //   36: ldc 175
    //   38: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: iconst_0
    //   42: istore 7
    //   44: goto -13 -> 31
    //   47: aload_0
    //   48: getfield 68	com/google/android/exoplayer2/source/k:blG	J
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 106	com/google/android/exoplayer2/source/k:blF	I
    //   56: invokespecial 98	com/google/android/exoplayer2/source/k:eA	(I)J
    //   59: invokestatic 86	java/lang/Math:max	(JJ)J
    //   62: lload_1
    //   63: lcmp
    //   64: iflt +14 -> 78
    //   67: ldc 175
    //   69: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: iconst_0
    //   73: istore 7
    //   75: goto -44 -> 31
    //   78: aload_0
    //   79: getfield 100	com/google/android/exoplayer2/source/k:length	I
    //   82: istore 4
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 100	com/google/android/exoplayer2/source/k:length	I
    //   89: iconst_1
    //   90: isub
    //   91: invokevirtual 94	com/google/android/exoplayer2/source/k:eB	(I)I
    //   94: istore_3
    //   95: iload 4
    //   97: aload_0
    //   98: getfield 106	com/google/android/exoplayer2/source/k:blF	I
    //   101: if_icmple +52 -> 153
    //   104: aload_0
    //   105: getfield 52	com/google/android/exoplayer2/source/k:aWE	[J
    //   108: iload_3
    //   109: laload
    //   110: lload_1
    //   111: lcmp
    //   112: iflt +41 -> 153
    //   115: iload 4
    //   117: iconst_1
    //   118: isub
    //   119: istore 5
    //   121: iload_3
    //   122: iconst_1
    //   123: isub
    //   124: istore 6
    //   126: iload 6
    //   128: istore_3
    //   129: iload 5
    //   131: istore 4
    //   133: iload 6
    //   135: iconst_m1
    //   136: if_icmpne -41 -> 95
    //   139: aload_0
    //   140: getfield 46	com/google/android/exoplayer2/source/k:blz	I
    //   143: iconst_1
    //   144: isub
    //   145: istore_3
    //   146: iload 5
    //   148: istore 4
    //   150: goto -55 -> 95
    //   153: aload_0
    //   154: aload_0
    //   155: getfield 102	com/google/android/exoplayer2/source/k:blD	I
    //   158: iload 4
    //   160: iadd
    //   161: invokevirtual 178	com/google/android/exoplayer2/source/k:ey	(I)J
    //   164: pop2
    //   165: ldc 175
    //   167: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: goto -139 -> 31
    //   173: astore 8
    //   175: aload_0
    //   176: monitorexit
    //   177: aload 8
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	k
    //   0	180	1	paramLong	long
    //   94	52	3	i	int
    //   82	79	4	j	int
    //   119	28	5	k	int
    //   124	13	6	m	int
    //   1	73	7	bool	boolean
    //   173	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	31	173	finally
    //   36	41	173	finally
    //   47	72	173	finally
    //   78	95	173	finally
    //   95	115	173	finally
    //   139	146	173	finally
    //   153	170	173	finally
  }
  
  public final int eB(int paramInt)
  {
    paramInt = this.blE + paramInt;
    if (paramInt < this.blz) {
      return paramInt;
    }
    return paramInt - this.blz;
  }
  
  public final long ey(int paramInt)
  {
    AppMethodBeat.i(92682);
    paramInt = tR() - paramInt;
    if ((paramInt >= 0) && (paramInt <= this.length - this.blF)) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      this.length -= paramInt;
      this.blH = Math.max(this.blG, eA(this.length));
      if (this.length != 0) {
        break;
      }
      AppMethodBeat.o(92682);
      return 0L;
    }
    paramInt = eB(this.length - 1);
    long l1 = this.offsets[paramInt];
    long l2 = this.aWC[paramInt];
    AppMethodBeat.o(92682);
    return l2 + l1;
  }
  
  public final boolean f(long paramLong, boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(92684);
        int i = eB(this.blF);
        if ((!tT()) || (paramLong < this.aWE[i]) || ((paramLong > this.blH) && (!paramBoolean)))
        {
          AppMethodBeat.o(92684);
          paramBoolean = bool;
          return paramBoolean;
        }
        i = a(i, this.length - this.blF, paramLong, true);
        if (i == -1)
        {
          AppMethodBeat.o(92684);
          paramBoolean = bool;
          continue;
        }
        this.blF += i;
      }
      finally {}
      AppMethodBeat.o(92684);
      paramBoolean = true;
    }
  }
  
  public final boolean i(Format paramFormat)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(92689);
        if (paramFormat == null)
        {
          this.blJ = true;
          AppMethodBeat.o(92689);
          return bool;
        }
        this.blJ = false;
        if (x.g(paramFormat, this.blK))
        {
          AppMethodBeat.o(92689);
          continue;
        }
        this.blK = paramFormat;
      }
      finally {}
      AppMethodBeat.o(92689);
      bool = true;
    }
  }
  
  public final void reset(boolean paramBoolean)
  {
    this.length = 0;
    this.blD = 0;
    this.blE = 0;
    this.blF = 0;
    this.blI = true;
    this.blG = -9223372036854775808L;
    this.blH = -9223372036854775808L;
    if (paramBoolean)
    {
      this.blK = null;
      this.blJ = true;
    }
  }
  
  public final void rewind()
  {
    try
    {
      this.blF = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long tL()
  {
    try
    {
      long l = this.blH;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int tR()
  {
    return this.blD + this.length;
  }
  
  public final int tS()
  {
    return this.blD + this.blF;
  }
  
  /* Error */
  public final boolean tT()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 106	com/google/android/exoplayer2/source/k:blF	I
    //   6: istore_1
    //   7: aload_0
    //   8: getfield 100	com/google/android/exoplayer2/source/k:length	I
    //   11: istore_2
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmpeq +9 -> 23
    //   17: iconst_1
    //   18: istore_3
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_3
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_3
    //   25: goto -6 -> 19
    //   28: astore 4
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	k
    //   6	9	1	i	int
    //   11	4	2	j	int
    //   18	7	3	bool	boolean
    //   28	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	28	finally
  }
  
  /* Error */
  public final Format tU()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 72	com/google/android/exoplayer2/source/k:blJ	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_2
    //   16: areturn
    //   17: aload_0
    //   18: getfield 119	com/google/android/exoplayer2/source/k:blK	Lcom/google/android/exoplayer2/Format;
    //   21: astore_2
    //   22: goto -9 -> 13
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	k
    //   6	2	1	bool	boolean
    //   12	10	2	localFormat	Format
    //   25	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  /* Error */
  public final void tV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 206
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 112	com/google/android/exoplayer2/source/k:tT	()Z
    //   11: ifne +11 -> 22
    //   14: ldc 206
    //   16: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 100	com/google/android/exoplayer2/source/k:length	I
    //   27: putfield 106	com/google/android/exoplayer2/source/k:blF	I
    //   30: ldc 206
    //   32: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: goto -16 -> 19
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	k
    //   38	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	38	finally
    //   22	35	38	finally
  }
  
  /* Error */
  public final long tW()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 208
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 106	com/google/android/exoplayer2/source/k:blF	I
    //   11: ifne +16 -> 27
    //   14: ldc2_w 149
    //   17: lstore_1
    //   18: ldc 208
    //   20: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: lload_1
    //   26: lreturn
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 106	com/google/android/exoplayer2/source/k:blF	I
    //   32: invokespecial 154	com/google/android/exoplayer2/source/k:ez	(I)J
    //   35: lstore_1
    //   36: ldc 208
    //   38: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -18 -> 23
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	k
    //   17	19	1	l	long
    //   44	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   18	23	44	finally
    //   27	41	44	finally
  }
  
  /* Error */
  public final long tX()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 210
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 100	com/google/android/exoplayer2/source/k:length	I
    //   11: ifne +16 -> 27
    //   14: ldc2_w 149
    //   17: lstore_1
    //   18: ldc 210
    //   20: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: lload_1
    //   26: lreturn
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 100	com/google/android/exoplayer2/source/k:length	I
    //   32: invokespecial 154	com/google/android/exoplayer2/source/k:ez	(I)J
    //   35: lstore_1
    //   36: ldc 210
    //   38: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -18 -> 23
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	k
    //   17	19	1	l	long
    //   44	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   18	23	44	finally
    //   27	41	44	finally
  }
  
  public static final class a
  {
    public m.a aYO;
    public long offset;
    public int size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.k
 * JD-Core Version:    0.7.0.1
 */