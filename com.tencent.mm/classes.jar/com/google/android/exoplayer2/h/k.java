package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class k
  implements b
{
  private int aRB;
  private int buA;
  private int buB;
  private a[] buC;
  private final boolean buw;
  private final int bux;
  private final byte[] buy;
  private final a[] buz;
  
  public k()
  {
    this((byte)0);
  }
  
  private k(byte paramByte)
  {
    AppMethodBeat.i(93049);
    com.google.android.exoplayer2.i.a.checkArgument(true);
    com.google.android.exoplayer2.i.a.checkArgument(true);
    this.buw = true;
    this.bux = 65536;
    this.buB = 0;
    this.buC = new a[100];
    this.buy = null;
    this.buz = new a[1];
    AppMethodBeat.o(93049);
  }
  
  public final void a(a parama)
  {
    try
    {
      AppMethodBeat.i(93053);
      this.buz[0] = parama;
      a(this.buz);
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
        if (this.buB + paramArrayOfa.length >= this.buC.length) {
          this.buC = ((a[])Arrays.copyOf(this.buC, Math.max(this.buC.length * 2, this.buB + paramArrayOfa.length)));
        }
        int j = paramArrayOfa.length;
        int i = 0;
        if (i < j)
        {
          a locala = paramArrayOfa[i];
          if (locala.data != this.buy)
          {
            if (locala.data.length != this.bux) {
              break label169;
            }
            break label163;
            com.google.android.exoplayer2.i.a.checkArgument(bool);
            a[] arrayOfa = this.buC;
            int k = this.buB;
            this.buB = (k + 1);
            arrayOfa[k] = locala;
            i += 1;
          }
        }
        else
        {
          this.buA -= paramArrayOfa.length;
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
  public final void eU(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 87
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: aload_0
    //   9: getfield 89	com/google/android/exoplayer2/h/k:aRB	I
    //   12: if_icmpge +26 -> 38
    //   15: iconst_1
    //   16: istore_2
    //   17: aload_0
    //   18: iload_1
    //   19: putfield 89	com/google/android/exoplayer2/h/k:aRB	I
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
      if (this.buw) {
        eU(0);
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
        int k = Math.max(0, x.bm(this.aRB, this.bux) - this.buA);
        if (k >= this.buB)
        {
          AppMethodBeat.o(93055);
          return;
        }
        i = k;
        if (this.buy != null)
        {
          int j = this.buB - 1;
          i = 0;
          if (i <= j)
          {
            a locala1 = this.buC[i];
            if (locala1.data == this.buy)
            {
              i += 1;
              continue;
            }
            a locala2 = this.buC[j];
            if (locala2.data != this.buy)
            {
              j -= 1;
              continue;
            }
            this.buC[i] = locala2;
            this.buC[j] = locala1;
            j -= 1;
            i += 1;
            continue;
          }
          j = Math.max(k, i);
          i = j;
          if (j >= this.buB)
          {
            AppMethodBeat.o(93055);
            continue;
          }
        }
        Arrays.fill(this.buC, i, this.buB, null);
      }
      finally {}
      this.buB = i;
      AppMethodBeat.o(93055);
    }
  }
  
  /* Error */
  public final a uY()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 109
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 82	com/google/android/exoplayer2/h/k:buA	I
    //   12: iconst_1
    //   13: iadd
    //   14: putfield 82	com/google/android/exoplayer2/h/k:buA	I
    //   17: aload_0
    //   18: getfield 46	com/google/android/exoplayer2/h/k:buB	I
    //   21: ifle +43 -> 64
    //   24: aload_0
    //   25: getfield 50	com/google/android/exoplayer2/h/k:buC	[Lcom/google/android/exoplayer2/h/a;
    //   28: astore_2
    //   29: aload_0
    //   30: getfield 46	com/google/android/exoplayer2/h/k:buB	I
    //   33: iconst_1
    //   34: isub
    //   35: istore_1
    //   36: aload_0
    //   37: iload_1
    //   38: putfield 46	com/google/android/exoplayer2/h/k:buB	I
    //   41: aload_2
    //   42: iload_1
    //   43: aaload
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 50	com/google/android/exoplayer2/h/k:buC	[Lcom/google/android/exoplayer2/h/a;
    //   49: aload_0
    //   50: getfield 46	com/google/android/exoplayer2/h/k:buB	I
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
    //   69: getfield 44	com/google/android/exoplayer2/h/k:bux	I
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
  
  public final int uZ()
  {
    return this.bux;
  }
  
  public final int vd()
  {
    try
    {
      int i = this.buA;
      int j = this.bux;
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