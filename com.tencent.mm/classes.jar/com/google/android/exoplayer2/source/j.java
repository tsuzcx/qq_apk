package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.m.a;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  private int[] aXo;
  private long[] aXq;
  private int[] bcI;
  private int bme;
  public int[] bmf;
  private m.a[] bmg;
  private Format[] bmh;
  private int bmi;
  private int bmj;
  public int bmk;
  private long bml;
  private long bmm;
  private boolean bmn;
  private boolean bmo;
  private Format bmp;
  public int bmq;
  private int length;
  private long[] offsets;
  
  public j()
  {
    AppMethodBeat.i(92681);
    this.bme = 1000;
    this.bmf = new int[this.bme];
    this.offsets = new long[this.bme];
    this.aXq = new long[this.bme];
    this.bcI = new int[this.bme];
    this.aXo = new int[this.bme];
    this.bmg = new m.a[this.bme];
    this.bmh = new Format[this.bme];
    this.bml = -9223372036854775808L;
    this.bmm = -9223372036854775808L;
    this.bmo = true;
    this.bmn = true;
    AppMethodBeat.o(92681);
  }
  
  private int a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    int j = -1;
    int k = 0;
    int i = paramInt1;
    paramInt1 = k;
    while ((paramInt1 < paramInt2) && (this.aXq[i] <= paramLong))
    {
      if ((!paramBoolean) || ((this.bcI[i] & 0x1) != 0)) {
        j = paramInt1;
      }
      k = i + 1;
      i = k;
      if (k == this.bme) {
        i = 0;
      }
      paramInt1 += 1;
    }
    return j;
  }
  
  private void aa(long paramLong)
  {
    try
    {
      AppMethodBeat.i(92691);
      this.bmm = Math.max(this.bmm, paramLong);
      AppMethodBeat.o(92691);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private long ey(int paramInt)
  {
    AppMethodBeat.i(92693);
    this.bml = Math.max(this.bml, ez(paramInt));
    this.length -= paramInt;
    this.bmi += paramInt;
    this.bmj += paramInt;
    if (this.bmj >= this.bme) {
      this.bmj -= this.bme;
    }
    this.bmk -= paramInt;
    if (this.bmk < 0) {
      this.bmk = 0;
    }
    if (this.length == 0)
    {
      if (this.bmj == 0) {}
      for (paramInt = this.bme;; paramInt = this.bmj)
      {
        paramInt -= 1;
        l1 = this.offsets[paramInt];
        long l2 = this.aXo[paramInt];
        AppMethodBeat.o(92693);
        return l2 + l1;
      }
    }
    long l1 = this.offsets[this.bmj];
    AppMethodBeat.o(92693);
    return l1;
  }
  
  private long ez(int paramInt)
  {
    AppMethodBeat.i(92694);
    if (paramInt == 0)
    {
      AppMethodBeat.o(92694);
      return -9223372036854775808L;
    }
    int i = eA(paramInt - 1);
    int j = 0;
    long l1 = -9223372036854775808L;
    long l2;
    for (;;)
    {
      l2 = l1;
      if (j >= paramInt) {
        break;
      }
      l1 = Math.max(l1, this.aXq[i]);
      l2 = l1;
      if ((this.bcI[i] & 0x1) != 0) {
        break;
      }
      int k = i - 1;
      i = k;
      if (k == -1) {
        i = this.bme - 1;
      }
      j += 1;
    }
    AppMethodBeat.o(92694);
    return l2;
  }
  
  public final int a(k paramk, e parame, boolean paramBoolean1, boolean paramBoolean2, Format paramFormat, a parama)
  {
    int j = -4;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(92683);
        int i;
        if (!ub())
        {
          if (paramBoolean2)
          {
            parame.flags = 4;
            AppMethodBeat.o(92683);
            i = j;
            return i;
          }
          if ((this.bmp != null) && ((paramBoolean1) || (this.bmp != paramFormat)))
          {
            paramk.aTo = this.bmp;
            AppMethodBeat.o(92683);
            i = -5;
            continue;
          }
          AppMethodBeat.o(92683);
          i = -3;
          continue;
        }
        int k = eA(this.bmk);
        if ((paramBoolean1) || (this.bmh[k] != paramFormat))
        {
          paramk.aTo = this.bmh[k];
          AppMethodBeat.o(92683);
          i = -5;
        }
        else if ((parame.aJg == null) && (parame.aWY == 0))
        {
          i = 1;
          if (i != 0)
          {
            AppMethodBeat.o(92683);
            i = -3;
          }
          else
          {
            parame.timeUs = this.aXq[k];
            parame.flags = this.bcI[k];
            parama.size = this.aXo[k];
            parama.offset = this.offsets[k];
            parama.aZA = this.bmg[k];
            this.bmk += 1;
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
  
  public final void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, m.a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(92690);
        if (this.bmn)
        {
          if ((paramInt1 & 0x1) == 0)
          {
            AppMethodBeat.o(92690);
            return;
          }
          this.bmn = false;
        }
        boolean bool;
        if (!this.bmo)
        {
          bool = true;
          a.checkState(bool);
          aa(paramLong1);
          int i = eA(this.length);
          this.aXq[i] = paramLong1;
          this.offsets[i] = paramLong2;
          this.aXo[i] = paramInt2;
          this.bcI[i] = paramInt1;
          this.bmg[i] = parama;
          this.bmh[i] = this.bmp;
          this.bmf[i] = this.bmq;
          this.length += 1;
          if (this.length == this.bme)
          {
            paramInt1 = this.bme + 1000;
            parama = new int[paramInt1];
            long[] arrayOfLong1 = new long[paramInt1];
            long[] arrayOfLong2 = new long[paramInt1];
            int[] arrayOfInt1 = new int[paramInt1];
            int[] arrayOfInt2 = new int[paramInt1];
            m.a[] arrayOfa = new m.a[paramInt1];
            Format[] arrayOfFormat = new Format[paramInt1];
            paramInt2 = this.bme - this.bmj;
            System.arraycopy(this.offsets, this.bmj, arrayOfLong1, 0, paramInt2);
            System.arraycopy(this.aXq, this.bmj, arrayOfLong2, 0, paramInt2);
            System.arraycopy(this.bcI, this.bmj, arrayOfInt1, 0, paramInt2);
            System.arraycopy(this.aXo, this.bmj, arrayOfInt2, 0, paramInt2);
            System.arraycopy(this.bmg, this.bmj, arrayOfa, 0, paramInt2);
            System.arraycopy(this.bmh, this.bmj, arrayOfFormat, 0, paramInt2);
            System.arraycopy(this.bmf, this.bmj, parama, 0, paramInt2);
            i = this.bmj;
            System.arraycopy(this.offsets, 0, arrayOfLong1, paramInt2, i);
            System.arraycopy(this.aXq, 0, arrayOfLong2, paramInt2, i);
            System.arraycopy(this.bcI, 0, arrayOfInt1, paramInt2, i);
            System.arraycopy(this.aXo, 0, arrayOfInt2, paramInt2, i);
            System.arraycopy(this.bmg, 0, arrayOfa, paramInt2, i);
            System.arraycopy(this.bmh, 0, arrayOfFormat, paramInt2, i);
            System.arraycopy(this.bmf, 0, parama, paramInt2, i);
            this.offsets = arrayOfLong1;
            this.aXq = arrayOfLong2;
            this.bcI = arrayOfInt1;
            this.aXo = arrayOfInt2;
            this.bmg = arrayOfa;
            this.bmh = arrayOfFormat;
            this.bmf = parama;
            this.bmj = 0;
            this.length = this.bme;
            this.bme = paramInt1;
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
  public final boolean ab(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: iconst_0
    //   4: istore 9
    //   6: aload_0
    //   7: monitorenter
    //   8: ldc 168
    //   10: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   13: aload_0
    //   14: getfield 96	com/google/android/exoplayer2/source/j:length	I
    //   17: ifne +37 -> 54
    //   20: lload_1
    //   21: aload_0
    //   22: getfield 68	com/google/android/exoplayer2/source/j:bml	J
    //   25: lcmp
    //   26: ifle +17 -> 43
    //   29: ldc 168
    //   31: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: iload 8
    //   36: istore 7
    //   38: aload_0
    //   39: monitorexit
    //   40: iload 7
    //   42: ireturn
    //   43: ldc 168
    //   45: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: iconst_0
    //   49: istore 7
    //   51: goto -13 -> 38
    //   54: aload_0
    //   55: getfield 68	com/google/android/exoplayer2/source/j:bml	J
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 102	com/google/android/exoplayer2/source/j:bmk	I
    //   63: invokespecial 94	com/google/android/exoplayer2/source/j:ez	(I)J
    //   66: invokestatic 88	java/lang/Math:max	(JJ)J
    //   69: lload_1
    //   70: lcmp
    //   71: iflt +14 -> 85
    //   74: ldc 168
    //   76: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: iconst_0
    //   80: istore 7
    //   82: goto -44 -> 38
    //   85: aload_0
    //   86: getfield 96	com/google/android/exoplayer2/source/j:length	I
    //   89: istore 4
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 96	com/google/android/exoplayer2/source/j:length	I
    //   96: iconst_1
    //   97: isub
    //   98: invokevirtual 107	com/google/android/exoplayer2/source/j:eA	(I)I
    //   101: istore_3
    //   102: iload 4
    //   104: aload_0
    //   105: getfield 102	com/google/android/exoplayer2/source/j:bmk	I
    //   108: if_icmple +52 -> 160
    //   111: aload_0
    //   112: getfield 52	com/google/android/exoplayer2/source/j:aXq	[J
    //   115: iload_3
    //   116: laload
    //   117: lload_1
    //   118: lcmp
    //   119: iflt +41 -> 160
    //   122: iload 4
    //   124: iconst_1
    //   125: isub
    //   126: istore 5
    //   128: iload_3
    //   129: iconst_1
    //   130: isub
    //   131: istore 6
    //   133: iload 6
    //   135: istore_3
    //   136: iload 5
    //   138: istore 4
    //   140: iload 6
    //   142: iconst_m1
    //   143: if_icmpne -41 -> 102
    //   146: aload_0
    //   147: getfield 46	com/google/android/exoplayer2/source/j:bme	I
    //   150: iconst_1
    //   151: isub
    //   152: istore_3
    //   153: iload 5
    //   155: istore 4
    //   157: goto -55 -> 102
    //   160: aload_0
    //   161: getfield 98	com/google/android/exoplayer2/source/j:bmi	I
    //   164: istore_3
    //   165: aload_0
    //   166: invokevirtual 172	com/google/android/exoplayer2/source/j:tZ	()I
    //   169: iload_3
    //   170: iload 4
    //   172: iadd
    //   173: isub
    //   174: istore_3
    //   175: iload 9
    //   177: istore 7
    //   179: iload_3
    //   180: iflt +23 -> 203
    //   183: iload 9
    //   185: istore 7
    //   187: iload_3
    //   188: aload_0
    //   189: getfield 96	com/google/android/exoplayer2/source/j:length	I
    //   192: aload_0
    //   193: getfield 102	com/google/android/exoplayer2/source/j:bmk	I
    //   196: isub
    //   197: if_icmpgt +6 -> 203
    //   200: iconst_1
    //   201: istore 7
    //   203: iload 7
    //   205: invokestatic 175	com/google/android/exoplayer2/i/a:checkArgument	(Z)V
    //   208: aload_0
    //   209: aload_0
    //   210: getfield 96	com/google/android/exoplayer2/source/j:length	I
    //   213: iload_3
    //   214: isub
    //   215: putfield 96	com/google/android/exoplayer2/source/j:length	I
    //   218: aload_0
    //   219: aload_0
    //   220: getfield 68	com/google/android/exoplayer2/source/j:bml	J
    //   223: aload_0
    //   224: aload_0
    //   225: getfield 96	com/google/android/exoplayer2/source/j:length	I
    //   228: invokespecial 94	com/google/android/exoplayer2/source/j:ez	(I)J
    //   231: invokestatic 88	java/lang/Math:max	(JJ)J
    //   234: putfield 70	com/google/android/exoplayer2/source/j:bmm	J
    //   237: ldc 168
    //   239: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: iload 8
    //   244: istore 7
    //   246: goto -208 -> 38
    //   249: astore 10
    //   251: aload_0
    //   252: monitorexit
    //   253: aload 10
    //   255: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	j
    //   0	256	1	paramLong	long
    //   101	114	3	i	int
    //   89	84	4	j	int
    //   126	28	5	k	int
    //   131	13	6	m	int
    //   36	209	7	bool1	boolean
    //   1	242	8	bool2	boolean
    //   4	180	9	bool3	boolean
    //   249	5	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	34	249	finally
    //   43	48	249	finally
    //   54	79	249	finally
    //   85	102	249	finally
    //   102	122	249	finally
    //   146	153	249	finally
    //   160	175	249	finally
    //   187	200	249	finally
    //   203	242	249	finally
  }
  
  public final int eA(int paramInt)
  {
    paramInt = this.bmj + paramInt;
    if (paramInt < this.bme) {
      return paramInt;
    }
    return paramInt - this.bme;
  }
  
  public final boolean f(long paramLong, boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(92684);
        int i = eA(this.bmk);
        if ((!ub()) || (paramLong < this.aXq[i]) || ((paramLong > this.bmm) && (!paramBoolean)))
        {
          AppMethodBeat.o(92684);
          paramBoolean = bool;
          return paramBoolean;
        }
        i = a(i, this.length - this.bmk, paramLong, true);
        if (i == -1)
        {
          AppMethodBeat.o(92684);
          paramBoolean = bool;
          continue;
        }
        this.bmk += i;
      }
      finally {}
      AppMethodBeat.o(92684);
      paramBoolean = true;
    }
  }
  
  /* Error */
  public final long g(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 183
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 96	com/google/android/exoplayer2/source/j:length	I
    //   11: ifeq +17 -> 28
    //   14: lload_1
    //   15: aload_0
    //   16: getfield 52	com/google/android/exoplayer2/source/j:aXq	[J
    //   19: aload_0
    //   20: getfield 100	com/google/android/exoplayer2/source/j:bmj	I
    //   23: laload
    //   24: lcmp
    //   25: ifge +16 -> 41
    //   28: ldc 183
    //   30: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: ldc2_w 184
    //   36: lstore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: lload_1
    //   40: lreturn
    //   41: iload_3
    //   42: ifeq +54 -> 96
    //   45: aload_0
    //   46: getfield 102	com/google/android/exoplayer2/source/j:bmk	I
    //   49: aload_0
    //   50: getfield 96	com/google/android/exoplayer2/source/j:length	I
    //   53: if_icmpeq +43 -> 96
    //   56: aload_0
    //   57: getfield 102	com/google/android/exoplayer2/source/j:bmk	I
    //   60: iconst_1
    //   61: iadd
    //   62: istore 4
    //   64: aload_0
    //   65: aload_0
    //   66: getfield 100	com/google/android/exoplayer2/source/j:bmj	I
    //   69: iload 4
    //   71: lload_1
    //   72: iconst_0
    //   73: invokespecial 180	com/google/android/exoplayer2/source/j:a	(IIJZ)I
    //   76: istore 4
    //   78: iload 4
    //   80: iconst_m1
    //   81: if_icmpne +24 -> 105
    //   84: ldc 183
    //   86: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: ldc2_w 184
    //   92: lstore_1
    //   93: goto -56 -> 37
    //   96: aload_0
    //   97: getfield 96	com/google/android/exoplayer2/source/j:length	I
    //   100: istore 4
    //   102: goto -38 -> 64
    //   105: aload_0
    //   106: iload 4
    //   108: invokespecial 187	com/google/android/exoplayer2/source/j:ey	(I)J
    //   111: lstore_1
    //   112: ldc 183
    //   114: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: goto -80 -> 37
    //   120: astore 5
    //   122: aload_0
    //   123: monitorexit
    //   124: aload 5
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	j
    //   0	127	1	paramLong	long
    //   0	127	3	paramBoolean	boolean
    //   62	45	4	i	int
    //   120	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	28	120	finally
    //   28	33	120	finally
    //   45	64	120	finally
    //   64	78	120	finally
    //   84	89	120	finally
    //   96	102	120	finally
    //   105	117	120	finally
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
          this.bmo = true;
          AppMethodBeat.o(92689);
          return bool;
        }
        this.bmo = false;
        if (x.g(paramFormat, this.bmp))
        {
          AppMethodBeat.o(92689);
          continue;
        }
        this.bmp = paramFormat;
      }
      finally {}
      AppMethodBeat.o(92689);
      bool = true;
    }
  }
  
  public final void reset(boolean paramBoolean)
  {
    this.length = 0;
    this.bmi = 0;
    this.bmj = 0;
    this.bmk = 0;
    this.bmn = true;
    this.bml = -9223372036854775808L;
    this.bmm = -9223372036854775808L;
    if (paramBoolean)
    {
      this.bmp = null;
      this.bmo = true;
    }
  }
  
  public final void rewind()
  {
    try
    {
      this.bmk = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long tT()
  {
    try
    {
      long l = this.bmm;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int tZ()
  {
    return this.bmi + this.length;
  }
  
  public final int ua()
  {
    return this.bmi + this.bmk;
  }
  
  /* Error */
  public final boolean ub()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 102	com/google/android/exoplayer2/source/j:bmk	I
    //   6: istore_1
    //   7: aload_0
    //   8: getfield 96	com/google/android/exoplayer2/source/j:length	I
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
    //   0	35	0	this	j
    //   6	9	1	i	int
    //   11	4	2	j	int
    //   18	7	3	bool	boolean
    //   28	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	28	finally
  }
  
  /* Error */
  public final Format uc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 72	com/google/android/exoplayer2/source/j:bmo	Z
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
    //   18: getfield 120	com/google/android/exoplayer2/source/j:bmp	Lcom/google/android/exoplayer2/Format;
    //   21: astore_2
    //   22: goto -9 -> 13
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	j
    //   6	2	1	bool	boolean
    //   12	10	2	localFormat	Format
    //   25	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  /* Error */
  public final void ud()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 203
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 113	com/google/android/exoplayer2/source/j:ub	()Z
    //   11: ifne +11 -> 22
    //   14: ldc 203
    //   16: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 96	com/google/android/exoplayer2/source/j:length	I
    //   27: putfield 102	com/google/android/exoplayer2/source/j:bmk	I
    //   30: ldc 203
    //   32: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: goto -16 -> 19
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	j
    //   38	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	38	finally
    //   22	35	38	finally
  }
  
  /* Error */
  public final long ue()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 205
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 102	com/google/android/exoplayer2/source/j:bmk	I
    //   11: ifne +16 -> 27
    //   14: ldc2_w 184
    //   17: lstore_1
    //   18: ldc 205
    //   20: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: lload_1
    //   26: lreturn
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 102	com/google/android/exoplayer2/source/j:bmk	I
    //   32: invokespecial 187	com/google/android/exoplayer2/source/j:ey	(I)J
    //   35: lstore_1
    //   36: ldc 205
    //   38: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -18 -> 23
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	j
    //   17	19	1	l	long
    //   44	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   18	23	44	finally
    //   27	41	44	finally
  }
  
  /* Error */
  public final long uf()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 207
    //   4: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 96	com/google/android/exoplayer2/source/j:length	I
    //   11: ifne +16 -> 27
    //   14: ldc2_w 184
    //   17: lstore_1
    //   18: ldc 207
    //   20: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: lload_1
    //   26: lreturn
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 96	com/google/android/exoplayer2/source/j:length	I
    //   32: invokespecial 187	com/google/android/exoplayer2/source/j:ey	(I)J
    //   35: lstore_1
    //   36: ldc 207
    //   38: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -18 -> 23
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	j
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
    public m.a aZA;
    public long offset;
    public int size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.j
 * JD-Core Version:    0.7.0.1
 */