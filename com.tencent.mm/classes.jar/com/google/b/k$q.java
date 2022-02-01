package com.google.b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class k$q
  extends bb.d<q>
  implements ae
{
  @Deprecated
  public static final ci<q> bRf = new c() {};
  private static final q bTQ = new q();
  private int bQS;
  private List<k.s> bRA;
  private byte bRd = -1;
  boolean bRz;
  
  private k$q()
  {
    this.bRA = Collections.emptyList();
  }
  
  private k$q(bb.c<q, ?> paramc)
  {
    super(paramc);
  }
  
  private k$q(h paramh, ap paramap)
  {
    this();
    if (paramap == null) {
      throw new NullPointerException();
    }
    da.a locala = da.Jj();
    int m = 0;
    int i = 0;
    for (;;)
    {
      label26:
      int n;
      int i1;
      int k;
      if (m == 0)
      {
        n = i;
        i1 = i;
        k = i;
      }
      for (;;)
      {
        try
        {
          j = paramh.Av();
          switch (j)
          {
          case 264: 
            n = i;
            i1 = i;
            k = i;
            if (a(paramh, locala, paramap, j)) {
              break label26;
            }
            m = 1;
            break label26;
            n = i;
            i1 = i;
            k = i;
            this.bQS |= 0x1;
            n = i;
            i1 = i;
            k = i;
            this.bRz = paramh.AB();
          }
        }
        catch (bf paramh)
        {
          try
          {
            paramh.bZj = this;
            throw paramh;
          }
          finally {}
          if ((k & 0x2) != 0) {
            this.bRA = Collections.unmodifiableList(this.bRA);
          }
          this.bVW = locala.Jm();
          this.bXY.Al();
          throw paramh;
          int j = i;
          if ((i & 0x2) == 0)
          {
            n = i;
            i1 = i;
            k = i;
            this.bRA = new ArrayList();
            j = i | 0x2;
          }
          n = j;
          i1 = j;
          k = j;
          this.bRA.add(paramh.a(k.s.bRf, paramap));
          i = j;
        }
        catch (IOException paramh)
        {
          k = i1;
          paramh = new bf(paramh);
          k = i1;
          paramh.bZj = this;
          k = i1;
          throw paramh;
        }
        finally
        {
          continue;
        }
        if ((i & 0x2) != 0) {
          this.bRA = Collections.unmodifiableList(this.bRA);
        }
        this.bVW = locala.Jm();
        this.bXY.Al();
        return;
      }
      m = 1;
    }
  }
  
  private int Ds()
  {
    return this.bRA.size();
  }
  
  public static q Gl()
  {
    return bTQ;
  }
  
  public static a b(q paramq)
  {
    return bTQ.Gk().d(paramq);
  }
  
  public final int Ad()
  {
    int j = 0;
    int i = this.bOZ;
    if (i != -1) {
      return i;
    }
    if ((this.bQS & 0x1) != 0) {
      i = i.gK(33) + 0;
    }
    for (;;)
    {
      if (j < this.bRA.size())
      {
        int k = i.c(999, (bw)this.bRA.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        i = Ii() + i + this.bVW.Ad();
        this.bOZ = i;
        return i;
        i = 0;
      }
    }
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  protected final bb.e Cb()
  {
    return k.BP().b(q.class, a.class);
  }
  
  public final ci<q> Co()
  {
    return bRf;
  }
  
  public final boolean Dr()
  {
    return (this.bQS & 0x1) != 0;
  }
  
  public final a Gk()
  {
    if (this == bTQ) {
      return new a((byte)0);
    }
    return new a((byte)0).d(this);
  }
  
  public final void a(i parami)
  {
    bb.d.a locala = Ih();
    if ((this.bQS & 0x1) != 0) {
      parami.t(33, this.bRz);
    }
    int i = 0;
    while (i < this.bRA.size())
    {
      parami.a(999, (bw)this.bRA.get(i));
      i += 1;
    }
    locala.b(parami);
    this.bVW.a(parami);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof q)) {
        return super.equals(paramObject);
      }
      paramObject = (q)paramObject;
      if (Dr() != paramObject.Dr()) {
        return false;
      }
      if ((Dr()) && (this.bRz != paramObject.bRz)) {
        return false;
      }
      if (!this.bRA.equals(paramObject.bRA)) {
        return false;
      }
      if (!this.bVW.equals(paramObject.bVW)) {
        return false;
      }
    } while (Ij().equals(paramObject.Ij()));
    return false;
  }
  
  public final int hashCode()
  {
    if (this.bPa != 0) {
      return this.bPa;
    }
    int j = k.BO().hashCode() + 779;
    int i = j;
    if (Dr()) {
      i = (j * 37 + 33) * 53 + be.bS(this.bRz);
    }
    j = i;
    if (Ds() > 0) {
      j = (i * 37 + 999) * 53 + this.bRA.hashCode();
    }
    i = a(j, Ij()) * 29 + this.bVW.hashCode();
    this.bPa = i;
    return i;
  }
  
  public final boolean isInitialized()
  {
    boolean bool = false;
    int i = this.bRd;
    if (i == 1) {
      bool = true;
    }
    while (i == 0) {
      return bool;
    }
    i = 0;
    while (i < Ds())
    {
      if (!((k.s)this.bRA.get(i)).isInitialized())
      {
        this.bRd = 0;
        return false;
      }
      i += 1;
    }
    if (!Ig())
    {
      this.bRd = 0;
      return false;
    }
    this.bRd = 1;
    return true;
  }
  
  public static final class a
    extends bb.c<k.q, a>
    implements ae
  {
    private int bQS;
    private List<k.s> bRA = Collections.emptyList();
    private co<k.s, k.s.a, ai> bRC;
    private boolean bRz;
    
    private a()
    {
      Cu();
    }
    
    private a(bb.b paramb)
    {
      super();
      Cu();
    }
    
    private void Cu()
    {
      if (bb.bXS) {
        Dy();
      }
    }
    
    private void Dx()
    {
      if ((this.bQS & 0x2) == 0)
      {
        this.bRA = new ArrayList(this.bRA);
        this.bQS |= 0x2;
      }
    }
    
    private co<k.s, k.s.a, ai> Dy()
    {
      List localList;
      if (this.bRC == null)
      {
        localList = this.bRA;
        if ((this.bQS & 0x2) == 0) {
          break label54;
        }
      }
      label54:
      for (boolean bool = true;; bool = false)
      {
        this.bRC = new co(localList, bool, Ie(), Ic());
        this.bRA = null;
        return this.bRC;
      }
    }
    
    private k.q Gm()
    {
      k.q localq = Gn();
      if (!localq.isInitialized()) {
        throw b(localq);
      }
      return localq;
    }
    
    private a Q(da paramda)
    {
      return (a)super.e(paramda);
    }
    
    private a R(da paramda)
    {
      return (a)super.d(paramda);
    }
    
    private a S(aj.f paramf, Object paramObject)
    {
      return (a)super.r(paramf, paramObject);
    }
    
    private a T(aj.f paramf, Object paramObject)
    {
      return (a)super.q(paramf, paramObject);
    }
    
    private a bP(boolean paramBoolean)
    {
      this.bQS |= 0x1;
      this.bRz = paramBoolean;
      onChanged();
      return this;
    }
    
    private a w(bt parambt)
    {
      if ((parambt instanceof k.q)) {
        return d((k.q)parambt);
      }
      super.a(parambt);
      return this;
    }
    
    /* Error */
    private a x(h paramh, ap paramap)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: getstatic 134	com/google/b/k$q:bRf	Lcom/google/b/ci;
      //   5: aload_1
      //   6: aload_2
      //   7: invokeinterface 139 3 0
      //   12: checkcast 9	com/google/b/k$q
      //   15: astore_1
      //   16: aload_1
      //   17: ifnull +9 -> 26
      //   20: aload_0
      //   21: aload_1
      //   22: invokevirtual 123	com/google/b/k$q$a:d	(Lcom/google/b/k$q;)Lcom/google/b/k$q$a;
      //   25: pop
      //   26: aload_0
      //   27: areturn
      //   28: astore_1
      //   29: aload_1
      //   30: getfield 143	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   33: checkcast 9	com/google/b/k$q
      //   36: astore_2
      //   37: aload_1
      //   38: invokevirtual 147	com/google/b/bf:Im	()Ljava/io/IOException;
      //   41: athrow
      //   42: astore_1
      //   43: aload_2
      //   44: ifnull +9 -> 53
      //   47: aload_0
      //   48: aload_2
      //   49: invokevirtual 123	com/google/b/k$q$a:d	(Lcom/google/b/k$q;)Lcom/google/b/k$q$a;
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
      return k.BP().b(k.q.class, a.class);
    }
    
    public final aj.a Cv()
    {
      return k.BO();
    }
    
    public final k.q Gn()
    {
      int i = 0;
      k.q localq = new k.q(this, (byte)0);
      if ((this.bQS & 0x1) != 0)
      {
        k.q.a(localq, this.bRz);
        i = 1;
      }
      if (this.bRC == null)
      {
        if ((this.bQS & 0x2) != 0)
        {
          this.bRA = Collections.unmodifiableList(this.bRA);
          this.bQS &= 0xFFFFFFFD;
        }
        k.q.a(localq, this.bRA);
      }
      for (;;)
      {
        k.q.a(localq, i);
        Ib();
        return localq;
        k.q.a(localq, this.bRC.build());
      }
    }
    
    public final a d(k.q paramq)
    {
      co localco = null;
      if (paramq == k.q.Gl()) {
        return this;
      }
      if (paramq.Dr()) {
        bP(paramq.bRz);
      }
      if (this.bRC == null) {
        if (!k.q.c(paramq).isEmpty())
        {
          if (!this.bRA.isEmpty()) {
            break label101;
          }
          this.bRA = k.q.c(paramq);
          this.bQS &= 0xFFFFFFFD;
          onChanged();
        }
      }
      for (;;)
      {
        a(paramq);
        R(paramq.bVW);
        onChanged();
        return this;
        label101:
        Dx();
        this.bRA.addAll(k.q.c(paramq));
        break;
        if (!k.q.c(paramq).isEmpty()) {
          if (this.bRC.isEmpty())
          {
            this.bRC.cat = null;
            this.bRC = null;
            this.bRA = k.q.c(paramq);
            this.bQS &= 0xFFFFFFFD;
            if (bb.bXS) {
              localco = Dy();
            }
            this.bRC = localco;
          }
          else
          {
            this.bRC.a(k.q.c(paramq));
          }
        }
      }
    }
    
    public final boolean isInitialized()
    {
      int i = 0;
      int j;
      if (this.bRC == null)
      {
        j = this.bRA.size();
        if (i >= j) {
          break label88;
        }
        if (this.bRC != null) {
          break label65;
        }
        locals = (k.s)this.bRA.get(i);
        if (locals.isInitialized()) {
          break label81;
        }
      }
      label65:
      label81:
      label88:
      while (!Ig())
      {
        for (;;)
        {
          return false;
          j = this.bRC.getCount();
          break;
          k.s locals = (k.s)this.bRC.u(i, false);
        }
        i += 1;
        break;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.b.k.q
 * JD-Core Version:    0.7.0.1
 */