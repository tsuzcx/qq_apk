package com.google.b;

public final class k$n$a
  extends bb.a<a>
  implements ab
{
  private int bQS;
  private Object bQT = "";
  private cs<k.o, k.o.a, ac> bRm;
  private k.o bTJ;
  
  private k$n$a()
  {
    Cu();
  }
  
  private k$n$a(bb.b paramb)
  {
    super(paramb);
    Cu();
  }
  
  private cs<k.o, k.o.a, ac> CK()
  {
    if (this.bRm == null)
    {
      this.bRm = new cs(FT(), Ie(), Ic());
      this.bTJ = null;
    }
    return this.bRm;
  }
  
  private void Cu()
  {
    if (bb.bXS) {
      CK();
    }
  }
  
  private k.o FT()
  {
    if (this.bRm == null)
    {
      if (this.bTJ == null) {
        return k.o.FZ();
      }
      return this.bTJ;
    }
    return (k.o)this.bRm.IU();
  }
  
  private k.n FW()
  {
    k.n localn = FX();
    if (!localn.isInitialized()) {
      throw b(localn);
    }
    return localn;
  }
  
  private k.n FX()
  {
    k.n localn = new k.n(this, (byte)0);
    int k = this.bQS;
    if ((k & 0x1) != 0) {}
    for (int i = 1;; i = 0)
    {
      k.n.a(localn, this.bQT);
      int j = i;
      if ((k & 0x2) != 0)
      {
        if (this.bRm != null) {
          break label77;
        }
        k.n.a(localn, this.bTJ);
      }
      for (;;)
      {
        j = i | 0x2;
        k.n.a(localn, j);
        Ib();
        return localn;
        label77:
        k.n.a(localn, (k.o)this.bRm.IV());
      }
    }
  }
  
  private a K(da paramda)
  {
    return (a)super.e(paramda);
  }
  
  private a L(da paramda)
  {
    return (a)super.d(paramda);
  }
  
  private a M(aj.f paramf, Object paramObject)
  {
    return (a)super.d(paramf, paramObject);
  }
  
  private a N(aj.f paramf, Object paramObject)
  {
    return (a)super.c(paramf, paramObject);
  }
  
  private a a(k.o paramo)
  {
    if (this.bRm == null) {
      if (((this.bQS & 0x2) != 0) && (this.bTJ != null) && (this.bTJ != k.o.FZ()))
      {
        this.bTJ = k.o.b(this.bTJ).d(paramo).Gb();
        onChanged();
      }
    }
    for (;;)
    {
      this.bQS |= 0x2;
      return this;
      this.bTJ = paramo;
      break;
      this.bRm.c(paramo);
    }
  }
  
  private a t(bt parambt)
  {
    if ((parambt instanceof k.n)) {
      return b((k.n)parambt);
    }
    super.a(parambt);
    return this;
  }
  
  /* Error */
  private a u(h paramh, ap paramap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 164	com/google/b/k$n:bRf	Lcom/google/b/ci;
    //   5: aload_1
    //   6: aload_2
    //   7: invokeinterface 169 3 0
    //   12: checkcast 9	com/google/b/k$n
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +9 -> 26
    //   20: aload_0
    //   21: aload_1
    //   22: invokevirtual 153	com/google/b/k$n$a:b	(Lcom/google/b/k$n;)Lcom/google/b/k$n$a;
    //   25: pop
    //   26: aload_0
    //   27: areturn
    //   28: astore_1
    //   29: aload_1
    //   30: getfield 173	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   33: checkcast 9	com/google/b/k$n
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 177	com/google/b/bf:Im	()Ljava/io/IOException;
    //   41: athrow
    //   42: astore_1
    //   43: aload_2
    //   44: ifnull +9 -> 53
    //   47: aload_0
    //   48: aload_2
    //   49: invokevirtual 153	com/google/b/k$n$a:b	(Lcom/google/b/k$n;)Lcom/google/b/k$n$a;
    //   52: pop
    //   53: aload_1
    //   54: athrow
    //   55: astore_1
    //   56: aload_3
    //   57: astore_2
    //   58: goto -15 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	a
    //   0	61	1	paramh	h
    //   0	61	2	paramap	ap
    //   1	56	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	com/google/b/bf
    //   37	42	42	finally
    //   2	16	55	finally
    //   29	37	55	finally
  }
  
  protected final bb.e Cb()
  {
    return k.Br().b(k.n.class, a.class);
  }
  
  public final aj.a Cv()
  {
    return k.Bq();
  }
  
  public final a b(k.n paramn)
  {
    if (paramn == k.n.FV()) {
      return this;
    }
    if (paramn.Cc())
    {
      this.bQS |= 0x1;
      this.bQT = k.n.a(paramn);
      onChanged();
    }
    if (paramn.Cj()) {
      a(paramn.FT());
    }
    L(paramn.bVW);
    onChanged();
    return this;
  }
  
  public final boolean isInitialized()
  {
    if ((this.bQS & 0x2) != 0) {}
    for (int i = 1; (i != 0) && (!FT().isInitialized()); i = 0) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.b.k.n.a
 * JD-Core Version:    0.7.0.1
 */