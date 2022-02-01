package com.google.b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class k$p
  extends bb
  implements ad
{
  @Deprecated
  public static final ci<p> bRf = new c() {};
  private static final p bTO = new p();
  private int bQS;
  private volatile Object bQT;
  private byte bRd = -1;
  private List<k.l> bTM;
  private k.q bTN;
  
  private k$p()
  {
    this.bQT = "";
    this.bTM = Collections.emptyList();
  }
  
  private k$p(bb.a<?> parama)
  {
    super(parama);
  }
  
  private k$p(h paramh, ap paramap)
  {
    this();
    if (paramap == null) {
      throw new NullPointerException();
    }
    da.a locala = da.Jj();
    int k = 0;
    int i = 0;
    for (;;)
    {
      label26:
      int n;
      int i1;
      int m;
      if (k == 0)
      {
        n = i;
        i1 = i;
        m = i;
      }
      int j;
      for (;;)
      {
        try
        {
          j = paramh.Av();
          switch (j)
          {
          case 10: 
            n = i;
            i1 = i;
            m = i;
            if (a(paramh, locala, paramap, j)) {
              break label476;
            }
            j = 1;
            break label492;
            n = i;
            i1 = i;
            m = i;
            localObject = paramh.AD();
            n = i;
            i1 = i;
            m = i;
            this.bQS |= 0x1;
            n = i;
            i1 = i;
            m = i;
            this.bQT = localObject;
            break label26;
          }
        }
        catch (bf paramh)
        {
          try
          {
            paramh.bZj = this;
            throw paramh;
          }
          finally
          {
            m = n;
            if ((m & 0x2) != 0) {
              this.bTM = Collections.unmodifiableList(this.bTM);
            }
            this.bVW = locala.Jm();
            HZ();
          }
          j = i;
          if ((i & 0x2) == 0)
          {
            n = i;
            i1 = i;
            m = i;
            this.bTM = new ArrayList();
            j = i | 0x2;
          }
          n = j;
          i1 = j;
          m = j;
          this.bTM.add(paramh.a(k.l.bRf, paramap));
          i = j;
          break;
        }
        catch (IOException paramh)
        {
          m = i1;
          paramh = new bf(paramh);
          m = i1;
          paramh.bZj = this;
          m = i1;
          throw paramh;
        }
        finally
        {
          continue;
          n = i;
          i1 = i;
          m = i;
          if ((this.bQS & 0x2) == 0) {
            break label483;
          }
        }
        n = i;
        i1 = i;
        m = i;
        label476:
        label483:
        for (Object localObject = this.bTN.Gk();; localObject = null)
        {
          n = i;
          i1 = i;
          m = i;
          this.bTN = ((k.q)paramh.a(k.q.bRf, paramap));
          if (localObject != null)
          {
            n = i;
            i1 = i;
            m = i;
            ((k.q.a)localObject).d(this.bTN);
            n = i;
            i1 = i;
            m = i;
            this.bTN = ((k.q.a)localObject).Gn();
          }
          n = i;
          i1 = i;
          m = i;
          this.bQS |= 0x2;
          break;
          if ((i & 0x2) != 0) {
            this.bTM = Collections.unmodifiableList(this.bTM);
          }
          this.bVW = locala.Jm();
          HZ();
          return;
          j = k;
          break label492;
        }
      }
      label492:
      k = j;
      continue;
      k = 1;
    }
  }
  
  private a Ge()
  {
    if (this == bTO) {
      return new a((byte)0);
    }
    return new a((byte)0).c(this);
  }
  
  public static p Gf()
  {
    return bTO;
  }
  
  public final int Ad()
  {
    int j = 0;
    int i = this.bOZ;
    if (i != -1) {
      return i;
    }
    if ((this.bQS & 0x1) != 0) {
      i = bb.f(1, this.bQT) + 0;
    }
    for (;;)
    {
      if (j < this.bTM.size())
      {
        int k = i.c(2, (bw)this.bTM.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        j = i;
        if ((this.bQS & 0x2) != 0) {
          j = i + i.c(3, Gd());
        }
        i = this.bVW.Ad() + j;
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
    return k.Bz().b(p.class, a.class);
  }
  
  public final boolean Cc()
  {
    return (this.bQS & 0x1) != 0;
  }
  
  public final boolean Cj()
  {
    return (this.bQS & 0x2) != 0;
  }
  
  public final ci<p> Co()
  {
    return bRf;
  }
  
  public final int Gc()
  {
    return this.bTM.size();
  }
  
  public final k.q Gd()
  {
    if (this.bTN == null) {
      return k.q.Gl();
    }
    return this.bTN;
  }
  
  public final void a(i parami)
  {
    if ((this.bQS & 0x1) != 0) {
      bb.a(parami, 1, this.bQT);
    }
    int i = 0;
    while (i < this.bTM.size())
    {
      parami.a(2, (bw)this.bTM.get(i));
      i += 1;
    }
    if ((this.bQS & 0x2) != 0) {
      parami.a(3, Gd());
    }
    this.bVW.a(parami);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof p)) {
        return super.equals(paramObject);
      }
      paramObject = (p)paramObject;
      if (Cc() != paramObject.Cc()) {
        return false;
      }
      if ((Cc()) && (!getName().equals(paramObject.getName()))) {
        return false;
      }
      if (!this.bTM.equals(paramObject.bTM)) {
        return false;
      }
      if (Cj() != paramObject.Cj()) {
        return false;
      }
      if ((Cj()) && (!Gd().equals(paramObject.Gd()))) {
        return false;
      }
    } while (this.bVW.equals(paramObject.bVW));
    return false;
  }
  
  public final String getName()
  {
    Object localObject = this.bQT;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bQT = str;
    }
    return str;
  }
  
  public final int hashCode()
  {
    if (this.bPa != 0) {
      return this.bPa;
    }
    int j = k.By().hashCode() + 779;
    int i = j;
    if (Cc()) {
      i = (j * 37 + 1) * 53 + getName().hashCode();
    }
    j = i;
    if (Gc() > 0) {
      j = (i * 37 + 2) * 53 + this.bTM.hashCode();
    }
    i = j;
    if (Cj()) {
      i = (j * 37 + 3) * 53 + Gd().hashCode();
    }
    i = i * 29 + this.bVW.hashCode();
    this.bPa = i;
    return i;
  }
  
  public final k.l hp(int paramInt)
  {
    return (k.l)this.bTM.get(paramInt);
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
    while (i < Gc())
    {
      if (!hp(i).isInitialized())
      {
        this.bRd = 0;
        return false;
      }
      i += 1;
    }
    if ((Cj()) && (!Gd().isInitialized()))
    {
      this.bRd = 0;
      return false;
    }
    this.bRd = 1;
    return true;
  }
  
  public static final class a
    extends bb.a<a>
    implements ad
  {
    private int bQS;
    private Object bQT = "";
    private cs<k.q, k.q.a, ae> bRm;
    private List<k.l> bTM = Collections.emptyList();
    private k.q bTN;
    private co<k.l, k.l.a, z> bTP;
    
    private a()
    {
      Cu();
    }
    
    private a(bb.b paramb)
    {
      super();
      Cu();
    }
    
    private cs<k.q, k.q.a, ae> CK()
    {
      if (this.bRm == null)
      {
        this.bRm = new cs(Gd(), Ie(), Ic());
        this.bTN = null;
      }
      return this.bRm;
    }
    
    private void Cu()
    {
      if (bb.bXS)
      {
        Gj();
        CK();
      }
    }
    
    private k.q Gd()
    {
      if (this.bRm == null)
      {
        if (this.bTN == null) {
          return k.q.Gl();
        }
        return this.bTN;
      }
      return (k.q)this.bRm.IU();
    }
    
    private k.p Gg()
    {
      k.p localp = Gh();
      if (!localp.isInitialized()) {
        throw b(localp);
      }
      return localp;
    }
    
    private k.p Gh()
    {
      k.p localp = new k.p(this, (byte)0);
      int k = this.bQS;
      if ((k & 0x1) != 0) {}
      for (int i = 1;; i = 0)
      {
        k.p.a(localp, this.bQT);
        int j;
        if (this.bTP == null)
        {
          if ((this.bQS & 0x2) != 0)
          {
            this.bTM = Collections.unmodifiableList(this.bTM);
            this.bQS &= 0xFFFFFFFD;
          }
          k.p.a(localp, this.bTM);
          j = i;
          if ((k & 0x4) != 0)
          {
            if (this.bRm != null) {
              break label141;
            }
            k.p.a(localp, this.bTN);
          }
        }
        for (;;)
        {
          j = i | 0x2;
          k.p.a(localp, j);
          Ib();
          return localp;
          k.p.a(localp, this.bTP.build());
          break;
          label141:
          k.p.a(localp, (k.q)this.bRm.IV());
        }
      }
    }
    
    private void Gi()
    {
      if ((this.bQS & 0x2) == 0)
      {
        this.bTM = new ArrayList(this.bTM);
        this.bQS |= 0x2;
      }
    }
    
    private co<k.l, k.l.a, z> Gj()
    {
      List localList;
      if (this.bTP == null)
      {
        localList = this.bTM;
        if ((this.bQS & 0x2) == 0) {
          break label54;
        }
      }
      label54:
      for (boolean bool = true;; bool = false)
      {
        this.bTP = new co(localList, bool, Ie(), Ic());
        this.bTM = null;
        return this.bTP;
      }
    }
    
    private a O(da paramda)
    {
      return (a)super.e(paramda);
    }
    
    private a P(da paramda)
    {
      return (a)super.d(paramda);
    }
    
    private a Q(aj.f paramf, Object paramObject)
    {
      return (a)super.d(paramf, paramObject);
    }
    
    private a R(aj.f paramf, Object paramObject)
    {
      return (a)super.c(paramf, paramObject);
    }
    
    private a a(k.q paramq)
    {
      if (this.bRm == null) {
        if (((this.bQS & 0x4) != 0) && (this.bTN != null) && (this.bTN != k.q.Gl()))
        {
          this.bTN = k.q.b(this.bTN).d(paramq).Gn();
          onChanged();
        }
      }
      for (;;)
      {
        this.bQS |= 0x4;
        return this;
        this.bTN = paramq;
        break;
        this.bRm.c(paramq);
      }
    }
    
    private a v(bt parambt)
    {
      if ((parambt instanceof k.p)) {
        return c((k.p)parambt);
      }
      super.a(parambt);
      return this;
    }
    
    /* Error */
    private a w(h paramh, ap paramap)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: getstatic 209	com/google/b/k$p:bRf	Lcom/google/b/ci;
      //   5: aload_1
      //   6: aload_2
      //   7: invokeinterface 214 3 0
      //   12: checkcast 9	com/google/b/k$p
      //   15: astore_1
      //   16: aload_1
      //   17: ifnull +9 -> 26
      //   20: aload_0
      //   21: aload_1
      //   22: invokevirtual 198	com/google/b/k$p$a:c	(Lcom/google/b/k$p;)Lcom/google/b/k$p$a;
      //   25: pop
      //   26: aload_0
      //   27: areturn
      //   28: astore_1
      //   29: aload_1
      //   30: getfield 218	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   33: checkcast 9	com/google/b/k$p
      //   36: astore_2
      //   37: aload_1
      //   38: invokevirtual 222	com/google/b/bf:Im	()Ljava/io/IOException;
      //   41: athrow
      //   42: astore_1
      //   43: aload_2
      //   44: ifnull +9 -> 53
      //   47: aload_0
      //   48: aload_2
      //   49: invokevirtual 198	com/google/b/k$p$a:c	(Lcom/google/b/k$p;)Lcom/google/b/k$p$a;
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
      return k.Bz().b(k.p.class, a.class);
    }
    
    public final aj.a Cv()
    {
      return k.By();
    }
    
    public final a c(k.p paramp)
    {
      co localco = null;
      if (paramp == k.p.Gf()) {
        return this;
      }
      if (paramp.Cc())
      {
        this.bQS |= 0x1;
        this.bQT = k.p.a(paramp);
        onChanged();
      }
      if (this.bTP == null) {
        if (!k.p.b(paramp).isEmpty())
        {
          if (!this.bTM.isEmpty()) {
            break label125;
          }
          this.bTM = k.p.b(paramp);
          this.bQS &= 0xFFFFFFFD;
          onChanged();
        }
      }
      for (;;)
      {
        if (paramp.Cj()) {
          a(paramp.Gd());
        }
        P(paramp.bVW);
        onChanged();
        return this;
        label125:
        Gi();
        this.bTM.addAll(k.p.b(paramp));
        break;
        if (!k.p.b(paramp).isEmpty()) {
          if (this.bTP.isEmpty())
          {
            this.bTP.cat = null;
            this.bTP = null;
            this.bTM = k.p.b(paramp);
            this.bQS &= 0xFFFFFFFD;
            if (bb.bXS) {
              localco = Gj();
            }
            this.bTP = localco;
          }
          else
          {
            this.bTP.a(k.p.b(paramp));
          }
        }
      }
    }
    
    public final boolean isInitialized()
    {
      int i = 0;
      int j;
      label19:
      k.l locall;
      if (this.bTP == null)
      {
        j = this.bTM.size();
        if (i >= j) {
          break label88;
        }
        if (this.bTP != null) {
          break label65;
        }
        locall = (k.l)this.bTM.get(i);
        label45:
        if (locall.isInitialized()) {
          break label81;
        }
      }
      for (;;)
      {
        return false;
        j = this.bTP.getCount();
        break label19;
        label65:
        locall = (k.l)this.bTP.u(i, false);
        break label45;
        label81:
        i += 1;
        break;
        label88:
        if ((this.bQS & 0x4) != 0) {}
        for (i = 1; (i == 0) || (Gd().isInitialized()); i = 0) {
          return true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.b.k.p
 * JD-Core Version:    0.7.0.1
 */