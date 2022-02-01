package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class k
  implements b
{
  private int cFp;
  private final boolean dii;
  private final int dij;
  private final byte[] dik;
  private final a[] dil;
  private int dim;
  private int din;
  private a[] dio;
  
  public k()
  {
    this((byte)0);
  }
  
  private k(byte paramByte)
  {
    AppMethodBeat.i(93049);
    com.google.android.exoplayer2.i.a.checkArgument(true);
    com.google.android.exoplayer2.i.a.checkArgument(true);
    this.dii = true;
    this.dij = 65536;
    this.din = 0;
    this.dio = new a[100];
    this.dik = null;
    this.dil = new a[1];
    AppMethodBeat.o(93049);
  }
  
  /* Error */
  public final a Ug()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 60
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 62	com/google/android/exoplayer2/h/k:dim	I
    //   12: iconst_1
    //   13: iadd
    //   14: putfield 62	com/google/android/exoplayer2/h/k:dim	I
    //   17: aload_0
    //   18: getfield 46	com/google/android/exoplayer2/h/k:din	I
    //   21: ifle +43 -> 64
    //   24: aload_0
    //   25: getfield 50	com/google/android/exoplayer2/h/k:dio	[Lcom/google/android/exoplayer2/h/a;
    //   28: astore_2
    //   29: aload_0
    //   30: getfield 46	com/google/android/exoplayer2/h/k:din	I
    //   33: iconst_1
    //   34: isub
    //   35: istore_1
    //   36: aload_0
    //   37: iload_1
    //   38: putfield 46	com/google/android/exoplayer2/h/k:din	I
    //   41: aload_2
    //   42: iload_1
    //   43: aaload
    //   44: astore_2
    //   45: aload_0
    //   46: getfield 50	com/google/android/exoplayer2/h/k:dio	[Lcom/google/android/exoplayer2/h/a;
    //   49: aload_0
    //   50: getfield 46	com/google/android/exoplayer2/h/k:din	I
    //   53: aconst_null
    //   54: aastore
    //   55: ldc 60
    //   57: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: areturn
    //   64: new 48	com/google/android/exoplayer2/h/a
    //   67: dup
    //   68: aload_0
    //   69: getfield 44	com/google/android/exoplayer2/h/k:dij	I
    //   72: newarray byte
    //   74: invokespecial 65	com/google/android/exoplayer2/h/a:<init>	([B)V
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
  
  public final int Uh()
  {
    return this.dij;
  }
  
  public final int Uk()
  {
    try
    {
      int i = this.dim;
      int j = this.dij;
      return i * j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(a parama)
  {
    try
    {
      AppMethodBeat.i(93053);
      this.dil[0] = parama;
      a(this.dil);
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
        if (this.din + paramArrayOfa.length >= this.dio.length) {
          this.dio = ((a[])Arrays.copyOf(this.dio, Math.max(this.dio.length * 2, this.din + paramArrayOfa.length)));
        }
        int j = paramArrayOfa.length;
        int i = 0;
        if (i < j)
        {
          a locala = paramArrayOfa[i];
          if (locala.data != this.dik)
          {
            if (locala.data.length != this.dij) {
              break label169;
            }
            break label163;
            com.google.android.exoplayer2.i.a.checkArgument(bool);
            a[] arrayOfa = this.dio;
            int k = this.din;
            this.din = (k + 1);
            arrayOfa[k] = locala;
            i += 1;
          }
        }
        else
        {
          this.dim -= paramArrayOfa.length;
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
  public final void iD(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 96
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: aload_0
    //   9: getfield 98	com/google/android/exoplayer2/h/k:cFp	I
    //   12: if_icmpge +26 -> 38
    //   15: iconst_1
    //   16: istore_2
    //   17: aload_0
    //   18: iload_1
    //   19: putfield 98	com/google/android/exoplayer2/h/k:cFp	I
    //   22: iload_2
    //   23: ifeq +7 -> 30
    //   26: aload_0
    //   27: invokevirtual 101	com/google/android/exoplayer2/h/k:trim	()V
    //   30: ldc 96
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
      if (this.dii) {
        iD(0);
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
        int k = Math.max(0, x.cl(this.cFp, this.dij) - this.dim);
        if (k >= this.din)
        {
          AppMethodBeat.o(93055);
          return;
        }
        i = k;
        if (this.dik != null)
        {
          int j = this.din - 1;
          i = 0;
          if (i <= j)
          {
            a locala1 = this.dio[i];
            if (locala1.data == this.dik)
            {
              i += 1;
              continue;
            }
            a locala2 = this.dio[j];
            if (locala2.data != this.dik)
            {
              j -= 1;
              continue;
            }
            this.dio[i] = locala2;
            this.dio[j] = locala1;
            j -= 1;
            i += 1;
            continue;
          }
          j = Math.max(k, i);
          i = j;
          if (j >= this.din)
          {
            AppMethodBeat.o(93055);
            continue;
          }
        }
        Arrays.fill(this.dio, i, this.din, null);
      }
      finally {}
      this.din = i;
      AppMethodBeat.o(93055);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.k
 * JD-Core Version:    0.7.0.1
 */