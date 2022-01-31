package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.c.k.a;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.k;

public final class g
{
  public Format aIA;
  public int aIB;
  public int[] aIp = new int[this.capacity];
  private int[] aIq = new int[this.capacity];
  private k.a[] aIr = new k.a[this.capacity];
  private Format[] aIs = new Format[this.capacity];
  public int aIt;
  public int aIu;
  public int aIv;
  public long aIw = -9223372036854775808L;
  public long aIx = -9223372036854775808L;
  public boolean aIy = true;
  public boolean aIz = true;
  private int[] ayV = new int[this.capacity];
  private long[] ayX = new long[this.capacity];
  private int capacity = 1000;
  public int length;
  private long[] offsets = new long[this.capacity];
  
  private void L(long paramLong)
  {
    try
    {
      this.aIx = Math.max(this.aIx, paramLong);
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
    while ((paramInt1 < paramInt2) && (this.ayX[i] <= paramLong))
    {
      if ((!paramBoolean) || ((this.aIq[i] & 0x1) != 0)) {
        j = paramInt1;
      }
      k = i + 1;
      i = k;
      if (k == this.capacity) {
        i = 0;
      }
      paramInt1 += 1;
    }
    return j;
  }
  
  private long dh(int paramInt)
  {
    this.aIw = Math.max(this.aIw, di(paramInt));
    this.length -= paramInt;
    this.aIt += paramInt;
    this.aIu += paramInt;
    if (this.aIu >= this.capacity) {
      this.aIu -= this.capacity;
    }
    this.aIv -= paramInt;
    if (this.aIv < 0) {
      this.aIv = 0;
    }
    if (this.length == 0)
    {
      if (this.aIu == 0) {}
      for (paramInt = this.capacity;; paramInt = this.aIu)
      {
        paramInt -= 1;
        long l = this.offsets[paramInt];
        return this.ayV[paramInt] + l;
      }
    }
    return this.offsets[this.aIu];
  }
  
  private long di(int paramInt)
  {
    if (paramInt == 0) {
      return -9223372036854775808L;
    }
    int i = dj(paramInt - 1);
    int j = 0;
    long l1 = -9223372036854775808L;
    long l2;
    for (;;)
    {
      l2 = l1;
      if (j >= paramInt) {
        break;
      }
      l1 = Math.max(l1, this.ayX[i]);
      l2 = l1;
      if ((this.aIq[i] & 0x1) != 0) {
        break;
      }
      int k = i - 1;
      i = k;
      if (k == -1) {
        i = this.capacity - 1;
      }
      j += 1;
    }
    return l2;
  }
  
  /* Error */
  public final boolean M(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 11
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   12: ifne +31 -> 43
    //   15: aload_0
    //   16: getfield 60	com/google/android/exoplayer2/source/g:aIw	J
    //   19: lstore 7
    //   21: lload_1
    //   22: lload 7
    //   24: lcmp
    //   25: ifle +12 -> 37
    //   28: iload 10
    //   30: istore 9
    //   32: aload_0
    //   33: monitorexit
    //   34: iload 9
    //   36: ireturn
    //   37: iconst_0
    //   38: istore 9
    //   40: goto -8 -> 32
    //   43: aload_0
    //   44: getfield 60	com/google/android/exoplayer2/source/g:aIw	J
    //   47: aload_0
    //   48: aload_0
    //   49: getfield 90	com/google/android/exoplayer2/source/g:aIv	I
    //   52: invokespecial 82	com/google/android/exoplayer2/source/g:di	(I)J
    //   55: invokestatic 75	java/lang/Math:max	(JJ)J
    //   58: lload_1
    //   59: lcmp
    //   60: iflt +9 -> 69
    //   63: iconst_0
    //   64: istore 9
    //   66: goto -34 -> 32
    //   69: aload_0
    //   70: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   73: istore 4
    //   75: aload_0
    //   76: aload_0
    //   77: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   80: iconst_1
    //   81: isub
    //   82: invokevirtual 94	com/google/android/exoplayer2/source/g:dj	(I)I
    //   85: istore_3
    //   86: iload 4
    //   88: aload_0
    //   89: getfield 90	com/google/android/exoplayer2/source/g:aIv	I
    //   92: if_icmple +52 -> 144
    //   95: aload_0
    //   96: getfield 44	com/google/android/exoplayer2/source/g:ayX	[J
    //   99: iload_3
    //   100: laload
    //   101: lload_1
    //   102: lcmp
    //   103: iflt +41 -> 144
    //   106: iload 4
    //   108: iconst_1
    //   109: isub
    //   110: istore 5
    //   112: iload_3
    //   113: iconst_1
    //   114: isub
    //   115: istore 6
    //   117: iload 6
    //   119: istore_3
    //   120: iload 5
    //   122: istore 4
    //   124: iload 6
    //   126: iconst_m1
    //   127: if_icmpne -41 -> 86
    //   130: aload_0
    //   131: getfield 38	com/google/android/exoplayer2/source/g:capacity	I
    //   134: iconst_1
    //   135: isub
    //   136: istore_3
    //   137: iload 5
    //   139: istore 4
    //   141: goto -55 -> 86
    //   144: aload_0
    //   145: getfield 86	com/google/android/exoplayer2/source/g:aIt	I
    //   148: istore_3
    //   149: aload_0
    //   150: getfield 86	com/google/android/exoplayer2/source/g:aIt	I
    //   153: aload_0
    //   154: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   157: iadd
    //   158: iload_3
    //   159: iload 4
    //   161: iadd
    //   162: isub
    //   163: istore_3
    //   164: iload 11
    //   166: istore 9
    //   168: iload_3
    //   169: iflt +23 -> 192
    //   172: iload 11
    //   174: istore 9
    //   176: iload_3
    //   177: aload_0
    //   178: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   181: aload_0
    //   182: getfield 90	com/google/android/exoplayer2/source/g:aIv	I
    //   185: isub
    //   186: if_icmpgt +6 -> 192
    //   189: iconst_1
    //   190: istore 9
    //   192: iload 9
    //   194: invokestatic 102	com/google/android/exoplayer2/i/a:aB	(Z)V
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   202: iload_3
    //   203: isub
    //   204: putfield 84	com/google/android/exoplayer2/source/g:length	I
    //   207: aload_0
    //   208: aload_0
    //   209: getfield 60	com/google/android/exoplayer2/source/g:aIw	J
    //   212: aload_0
    //   213: aload_0
    //   214: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   217: invokespecial 82	com/google/android/exoplayer2/source/g:di	(I)J
    //   220: invokestatic 75	java/lang/Math:max	(JJ)J
    //   223: putfield 62	com/google/android/exoplayer2/source/g:aIx	J
    //   226: iload 10
    //   228: istore 9
    //   230: goto -198 -> 32
    //   233: astore 12
    //   235: aload_0
    //   236: monitorexit
    //   237: aload 12
    //   239: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	g
    //   0	240	1	paramLong	long
    //   85	119	3	i	int
    //   73	89	4	j	int
    //   110	28	5	k	int
    //   115	13	6	m	int
    //   19	4	7	l	long
    //   30	199	9	bool1	boolean
    //   1	226	10	bool2	boolean
    //   4	169	11	bool3	boolean
    //   233	5	12	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	21	233	finally
    //   43	63	233	finally
    //   69	86	233	finally
    //   86	106	233	finally
    //   130	137	233	finally
    //   144	164	233	finally
    //   176	189	233	finally
    //   192	226	233	finally
  }
  
  public final int a(k paramk, e parame, boolean paramBoolean1, boolean paramBoolean2, Format paramFormat, g.a parama)
  {
    int j = -4;
    label211:
    label230:
    label234:
    for (;;)
    {
      int k;
      try
      {
        if (!mH())
        {
          if (paramBoolean2)
          {
            parame.flags = 4;
            i = j;
            return i;
          }
          if ((this.aIA == null) || ((!paramBoolean1) && (this.aIA == paramFormat))) {
            break label211;
          }
          paramk.auL = this.aIA;
          i = -5;
          continue;
        }
        k = dj(this.aIv);
        if ((paramBoolean1) || (this.aIs[k] != paramFormat))
        {
          paramk.auL = this.aIs[k];
          i = -5;
          continue;
        }
        if ((parame.ayD != null) || (parame.ayF != 0)) {
          break label230;
        }
        i = 1;
      }
      finally {}
      parame.ayE = this.ayX[k];
      parame.flags = this.aIq[k];
      parama.size = this.ayV[k];
      parama.pj = this.offsets[k];
      parama.aCH = this.aIr[k];
      this.aIv += 1;
      int i = j;
      continue;
      i = -3;
      continue;
      for (;;)
      {
        if (i == 0) {
          break label234;
        }
        i = -3;
        break;
        i = 0;
      }
    }
  }
  
  public final void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, k.a parama)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.aIy;
        if (bool)
        {
          if ((paramInt1 & 0x1) == 0) {
            return;
          }
          this.aIy = false;
        }
        if (!this.aIz)
        {
          bool = true;
          a.aC(bool);
          L(paramLong1);
          int i = dj(this.length);
          this.ayX[i] = paramLong1;
          this.offsets[i] = paramLong2;
          this.ayV[i] = paramInt2;
          this.aIq[i] = paramInt1;
          this.aIr[i] = parama;
          this.aIs[i] = this.aIA;
          this.aIp[i] = this.aIB;
          this.length += 1;
          if (this.length == this.capacity)
          {
            paramInt1 = this.capacity + 1000;
            parama = new int[paramInt1];
            long[] arrayOfLong1 = new long[paramInt1];
            long[] arrayOfLong2 = new long[paramInt1];
            int[] arrayOfInt1 = new int[paramInt1];
            int[] arrayOfInt2 = new int[paramInt1];
            k.a[] arrayOfa = new k.a[paramInt1];
            Format[] arrayOfFormat = new Format[paramInt1];
            paramInt2 = this.capacity - this.aIu;
            System.arraycopy(this.offsets, this.aIu, arrayOfLong1, 0, paramInt2);
            System.arraycopy(this.ayX, this.aIu, arrayOfLong2, 0, paramInt2);
            System.arraycopy(this.aIq, this.aIu, arrayOfInt1, 0, paramInt2);
            System.arraycopy(this.ayV, this.aIu, arrayOfInt2, 0, paramInt2);
            System.arraycopy(this.aIr, this.aIu, arrayOfa, 0, paramInt2);
            System.arraycopy(this.aIs, this.aIu, arrayOfFormat, 0, paramInt2);
            System.arraycopy(this.aIp, this.aIu, parama, 0, paramInt2);
            i = this.aIu;
            System.arraycopy(this.offsets, 0, arrayOfLong1, paramInt2, i);
            System.arraycopy(this.ayX, 0, arrayOfLong2, paramInt2, i);
            System.arraycopy(this.aIq, 0, arrayOfInt1, paramInt2, i);
            System.arraycopy(this.ayV, 0, arrayOfInt2, paramInt2, i);
            System.arraycopy(this.aIr, 0, arrayOfa, paramInt2, i);
            System.arraycopy(this.aIs, 0, arrayOfFormat, paramInt2, i);
            System.arraycopy(this.aIp, 0, parama, paramInt2, i);
            this.offsets = arrayOfLong1;
            this.ayX = arrayOfLong2;
            this.aIq = arrayOfInt1;
            this.ayV = arrayOfInt2;
            this.aIr = arrayOfa;
            this.aIs = arrayOfFormat;
            this.aIp = parama;
            this.aIu = 0;
            this.length = this.capacity;
            this.capacity = paramInt1;
          }
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  public final int dj(int paramInt)
  {
    paramInt = this.aIu + paramInt;
    if (paramInt < this.capacity) {
      return paramInt;
    }
    return paramInt - this.capacity;
  }
  
  /* Error */
  public final boolean e(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: aload_0
    //   7: getfield 90	com/google/android/exoplayer2/source/g:aIv	I
    //   10: invokevirtual 94	com/google/android/exoplayer2/source/g:dj	(I)I
    //   13: istore 4
    //   15: iload 8
    //   17: istore 7
    //   19: aload_0
    //   20: invokevirtual 107	com/google/android/exoplayer2/source/g:mH	()Z
    //   23: ifeq +40 -> 63
    //   26: iload 8
    //   28: istore 7
    //   30: lload_1
    //   31: aload_0
    //   32: getfield 44	com/google/android/exoplayer2/source/g:ayX	[J
    //   35: iload 4
    //   37: laload
    //   38: lcmp
    //   39: iflt +24 -> 63
    //   42: aload_0
    //   43: getfield 62	com/google/android/exoplayer2/source/g:aIx	J
    //   46: lstore 5
    //   48: lload_1
    //   49: lload 5
    //   51: lcmp
    //   52: ifle +16 -> 68
    //   55: iload_3
    //   56: ifne +12 -> 68
    //   59: iload 8
    //   61: istore 7
    //   63: aload_0
    //   64: monitorexit
    //   65: iload 7
    //   67: ireturn
    //   68: aload_0
    //   69: iload 4
    //   71: aload_0
    //   72: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   75: aload_0
    //   76: getfield 90	com/google/android/exoplayer2/source/g:aIv	I
    //   79: isub
    //   80: lload_1
    //   81: iconst_1
    //   82: invokespecial 159	com/google/android/exoplayer2/source/g:a	(IIJZ)I
    //   85: istore 4
    //   87: iload 8
    //   89: istore 7
    //   91: iload 4
    //   93: iconst_m1
    //   94: if_icmpeq -31 -> 63
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 90	com/google/android/exoplayer2/source/g:aIv	I
    //   102: iload 4
    //   104: iadd
    //   105: putfield 90	com/google/android/exoplayer2/source/g:aIv	I
    //   108: iconst_1
    //   109: istore 7
    //   111: goto -48 -> 63
    //   114: astore 9
    //   116: aload_0
    //   117: monitorexit
    //   118: aload 9
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	g
    //   0	121	1	paramLong	long
    //   0	121	3	paramBoolean	boolean
    //   13	92	4	i	int
    //   46	4	5	l	long
    //   17	93	7	bool1	boolean
    //   1	87	8	bool2	boolean
    //   114	5	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	15	114	finally
    //   19	26	114	finally
    //   30	48	114	finally
    //   68	87	114	finally
    //   97	108	114	finally
  }
  
  /* Error */
  public final long f(long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   6: ifeq +21 -> 27
    //   9: aload_0
    //   10: getfield 44	com/google/android/exoplayer2/source/g:ayX	[J
    //   13: aload_0
    //   14: getfield 88	com/google/android/exoplayer2/source/g:aIu	I
    //   17: laload
    //   18: lstore 5
    //   20: lload_1
    //   21: lload 5
    //   23: lcmp
    //   24: ifge +11 -> 35
    //   27: ldc2_w 162
    //   30: lstore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: lload_1
    //   34: lreturn
    //   35: iload_3
    //   36: ifeq +49 -> 85
    //   39: aload_0
    //   40: getfield 90	com/google/android/exoplayer2/source/g:aIv	I
    //   43: aload_0
    //   44: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   47: if_icmpeq +38 -> 85
    //   50: aload_0
    //   51: getfield 90	com/google/android/exoplayer2/source/g:aIv	I
    //   54: iconst_1
    //   55: iadd
    //   56: istore 4
    //   58: aload_0
    //   59: aload_0
    //   60: getfield 88	com/google/android/exoplayer2/source/g:aIu	I
    //   63: iload 4
    //   65: lload_1
    //   66: iconst_0
    //   67: invokespecial 159	com/google/android/exoplayer2/source/g:a	(IIJZ)I
    //   70: istore 4
    //   72: iload 4
    //   74: iconst_m1
    //   75: if_icmpne +19 -> 94
    //   78: ldc2_w 162
    //   81: lstore_1
    //   82: goto -51 -> 31
    //   85: aload_0
    //   86: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   89: istore 4
    //   91: goto -33 -> 58
    //   94: aload_0
    //   95: iload 4
    //   97: invokespecial 165	com/google/android/exoplayer2/source/g:dh	(I)J
    //   100: lstore_1
    //   101: goto -70 -> 31
    //   104: astore 7
    //   106: aload_0
    //   107: monitorexit
    //   108: aload 7
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	g
    //   0	111	1	paramLong	long
    //   0	111	3	paramBoolean	boolean
    //   56	40	4	i	int
    //   18	4	5	l	long
    //   104	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	104	finally
    //   39	58	104	finally
    //   58	72	104	finally
    //   85	91	104	finally
    //   94	101	104	finally
  }
  
  public final boolean i(Format paramFormat)
  {
    boolean bool = false;
    if (paramFormat == null) {}
    for (;;)
    {
      try
      {
        this.aIz = true;
        return bool;
      }
      finally {}
      this.aIz = false;
      if (!t.e(paramFormat, this.aIA))
      {
        this.aIA = paramFormat;
        bool = true;
      }
    }
  }
  
  /* Error */
  public final boolean mH()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 90	com/google/android/exoplayer2/source/g:aIv	I
    //   6: istore_1
    //   7: aload_0
    //   8: getfield 84	com/google/android/exoplayer2/source/g:length	I
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
    //   0	35	0	this	g
    //   6	9	1	i	int
    //   11	4	2	j	int
    //   18	7	3	bool	boolean
    //   28	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	28	finally
  }
  
  /* Error */
  public final Format mI()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 64	com/google/android/exoplayer2/source/g:aIz	Z
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
    //   18: getfield 114	com/google/android/exoplayer2/source/g:aIA	Lcom/google/android/exoplayer2/Format;
    //   21: astore_2
    //   22: goto -9 -> 13
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	g
    //   6	2	1	bool	boolean
    //   12	10	2	localFormat	Format
    //   25	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  public final long mJ()
  {
    try
    {
      long l = this.aIx;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void mK()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 107	com/google/android/exoplayer2/source/g:mH	()Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_0
    //   16: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   19: putfield 90	com/google/android/exoplayer2/source/g:aIv	I
    //   22: goto -11 -> 11
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	g
    //   6	2	1	bool	boolean
    //   25	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   14	22	25	finally
  }
  
  /* Error */
  public final long mL()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 90	com/google/android/exoplayer2/source/g:aIv	I
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +11 -> 19
    //   11: ldc2_w 162
    //   14: lstore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: lload_2
    //   18: lreturn
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 90	com/google/android/exoplayer2/source/g:aIv	I
    //   24: invokespecial 165	com/google/android/exoplayer2/source/g:dh	(I)J
    //   27: lstore_2
    //   28: goto -13 -> 15
    //   31: astore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: aload 4
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	g
    //   6	2	1	i	int
    //   14	14	2	l	long
    //   31	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   19	28	31	finally
  }
  
  /* Error */
  public final long mM()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +11 -> 19
    //   11: ldc2_w 162
    //   14: lstore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: lload_2
    //   18: lreturn
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 84	com/google/android/exoplayer2/source/g:length	I
    //   24: invokespecial 165	com/google/android/exoplayer2/source/g:dh	(I)J
    //   27: lstore_2
    //   28: goto -13 -> 15
    //   31: astore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: aload 4
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	g
    //   6	2	1	i	int
    //   14	14	2	l	long
    //   31	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   19	28	31	finally
  }
  
  public final void rewind()
  {
    try
    {
      this.aIv = 0;
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
 * Qualified Name:     com.google.android.exoplayer2.source.g
 * JD-Core Version:    0.7.0.1
 */