package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class k
  implements b
{
  private int aQG;
  private final boolean bwA;
  private final int bwB;
  private final byte[] bwC;
  private final a[] bwD;
  private int bwE;
  private int bwF;
  private a[] bwG;
  
  public k()
  {
    this((byte)0);
  }
  
  private k(byte paramByte)
  {
    AppMethodBeat.i(93049);
    com.google.android.exoplayer2.i.a.checkArgument(true);
    com.google.android.exoplayer2.i.a.checkArgument(true);
    this.bwA = true;
    this.bwB = 65536;
    this.bwF = 0;
    this.bwG = new a[100];
    this.bwC = null;
    this.bwD = new a[1];
    AppMethodBeat.o(93049);
  }
  
  public final void a(a parama)
  {
    try
    {
      AppMethodBeat.i(93053);
      this.bwD[0] = parama;
      a(this.bwD);
      AppMethodBeat.o(93053);
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
        AppMethodBeat.i(93054);
        if (this.bwF + paramArrayOfa.length >= this.bwG.length) {
          this.bwG = ((a[])Arrays.copyOf(this.bwG, Math.max(this.bwG.length * 2, this.bwF + paramArrayOfa.length)));
        }
        int j = paramArrayOfa.length;
        int i = 0;
        if (i < j)
        {
          a locala = paramArrayOfa[i];
          if (locala.data != this.bwC)
          {
            if (locala.data.length != this.bwB) {
              break label169;
            }
            break label163;
            com.google.android.exoplayer2.i.a.checkArgument(bool);
            a[] arrayOfa = this.bwG;
            int k = this.bwF;
            this.bwF = (k + 1);
            arrayOfa[k] = locala;
            i += 1;
          }
        }
        else
        {
          this.bwE -= paramArrayOfa.length;
          notifyAll();
          AppMethodBeat.o(93054);
          return;
        }
      }
      finally {}
      label163:
      boolean bool = true;
      continue;
      label169:
      bool = false;
    }
  }
  
  /* Error */
  public final void fi(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 87
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: aload_0
    //   9: getfield 89	com/google/android/exoplayer2/h/k:aQG	I
    //   12: if_icmpge +26 -> 38
    //   15: iconst_1
    //   16: istore_2
    //   17: aload_0
    //   18: iload_1
    //   19: putfield 89	com/google/android/exoplayer2/h/k:aQG	I
    //   22: iload_2
    //   23: ifeq +7 -> 30
    //   26: aload_0
    //   27: invokevirtual 92	com/google/android/exoplayer2/h/k:trim	()V
    //   30: ldc 87
    //   32: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: iconst_0
    //   39: istore_2
    //   40: goto -23 -> 17
    //   43: astore_3
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_3
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	k
    //   0	48	1	paramInt	int
    //   16	24	2	i	int
    //   43	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	43	finally
    //   17	22	43	finally
    //   26	30	43	finally
    //   30	35	43	finally
  }
  
  public final void reset()
  {
    try
    {
      AppMethodBeat.i(93050);
      if (this.bwA) {
        fi(0);
      }
      AppMethodBeat.o(93050);
      return;
    }
    finally {}
  }
  
  public final void trim()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(93055);
        int k = Math.max(0, x.bp(this.aQG, this.bwB) - this.bwE);
        if (k >= this.bwF)
        {
          AppMethodBeat.o(93055);
          return;
        }
        i = k;
        if (this.bwC != null)
        {
          int j = this.bwF - 1;
          i = 0;
          if (i <= j)
          {
            a locala1 = this.bwG[i];
            if (locala1.data == this.bwC)
            {
              i += 1;
              continue;
            }
            a locala2 = this.bwG[j];
            if (locala2.data != this.bwC)
            {
              j -= 1;
              continue;
            }
            this.bwG[i] = locala2;
            this.bwG[j] = locala1;
            j -= 1;
            i += 1;
            continue;
          }
          j = Math.max(k, i);
          i = j;
          if (j >= this.bwF)
          {
            AppMethodBeat.o(93055);
            continue;
          }
        }
        Arrays.fill(this.bwG, i, this.bwF, null);
      }
      finally {}
      this.bwF = i;
      AppMethodBeat.o(93055);
    }
  }
  
  /* Error */
  public final a ve()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 109
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 82	com/google/android/exoplayer2/h/k:bwE	I
    //   12: iconst_1
    //   13: iadd
    //   14: putfield 82	com/google/android/exoplayer2/h/k:bwE	I
    //   17: aload_0
    //   18: getfield 46	com/google/android/exoplayer2/h/k:bwF	I
    //   21: ifle +43 -> 64
    //   24: aload_0
    //   25: getfield 50	com/google/android/exoplayer2/h/k:bwG	[Lcom/google/android/exoplayer2/h/a;
    //   28: astore_2
    //   29: aload_0
    //   30: getfield 46	com/google/android/exoplayer2/h/k:bwF	I
    //   33: iconst_1
    //   34: isub
    //   35: istore_1
    //   36: aload_0
    //   37: iload_1
    //   38: putfield 46	com/google/android/exoplayer2/h/k:bwF	I
    //   41: aload_2
    //   42: iload_1
    //   43: aaload
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 50	com/google/android/exoplayer2/h/k:bwG	[Lcom/google/android/exoplayer2/h/a;
    //   49: aload_0
    //   50: getfield 46	com/google/android/exoplayer2/h/k:bwF	I
    //   53: aconst_null
    //   54: aastore
    //   55: ldc 109
    //   57: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: areturn
    //   64: new 48	com/google/android/exoplayer2/h/a
    //   67: dup
    //   68: aload_0
    //   69: getfield 44	com/google/android/exoplayer2/h/k:bwB	I
    //   72: newarray byte
    //   74: invokespecial 112	com/google/android/exoplayer2/h/a:<init>	([B)V
    //   77: astore_2
    //   78: goto -23 -> 55
    //   81: astore_2
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_2
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	k
    //   35	8	1	i	int
    //   28	50	2	localObject1	Object
    //   81	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	41	81	finally
    //   45	55	81	finally
    //   55	60	81	finally
    //   64	78	81	finally
  }
  
  public final int vf()
  {
    return this.bwB;
  }
  
  public final int vk()
  {
    try
    {
      int i = this.bwE;
      int j = this.bwB;
      return i * j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.k
 * JD-Core Version:    0.7.0.1
 */