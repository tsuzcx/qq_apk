package com.google.b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class k$s
  extends bb
  implements ai
{
  @Deprecated
  public static final ci<s> bRf = new c() {};
  private static final s bUj = new s();
  private int bQS;
  private byte bRd = -1;
  private List<b> bUc;
  private volatile Object bUd;
  long bUe;
  long bUf;
  double bUg;
  g bUh;
  private volatile Object bUi;
  
  private k$s()
  {
    this.bUc = Collections.emptyList();
    this.bUd = "";
    this.bUh = g.bPf;
    this.bUi = "";
  }
  
  private k$s(bb.a<?> parama)
  {
    super(parama);
  }
  
  private k$s(h paramh, ap paramap)
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
          int j = paramh.Av();
          switch (j)
          {
          case 18: 
            n = i;
            i1 = i;
            k = i;
            if (a(paramh, locala, paramap, j)) {
              break label26;
            }
            m = 1;
            break label26;
            j = i;
            if ((i & 0x1) == 0)
            {
              n = i;
              i1 = i;
              k = i;
              this.bUc = new ArrayList();
              j = i | 0x1;
            }
            n = j;
            i1 = j;
            k = j;
            this.bUc.add(paramh.a(b.bRf, paramap));
            i = j;
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
            k = n;
            if ((k & 0x1) != 0) {
              this.bUc = Collections.unmodifiableList(this.bUc);
            }
            this.bVW = locala.Jm();
            HZ();
          }
          n = i;
          i1 = i;
          k = i;
          localg = paramh.AD();
          n = i;
          i1 = i;
          k = i;
          this.bQS |= 0x1;
          n = i;
          i1 = i;
          k = i;
          this.bUd = localg;
          break;
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
          n = i;
          i1 = i;
          k = i;
          this.bQS |= 0x2;
          n = i;
          i1 = i;
          k = i;
          this.bUe = paramh.Aw();
        }
        break;
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x4;
        n = i;
        i1 = i;
        k = i;
        this.bUf = paramh.Ax();
        break;
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x8;
        n = i;
        i1 = i;
        k = i;
        this.bUg = paramh.readDouble();
        break;
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x10;
        n = i;
        i1 = i;
        k = i;
        this.bUh = paramh.AD();
        break;
        n = i;
        i1 = i;
        k = i;
        g localg = paramh.AD();
        n = i;
        i1 = i;
        k = i;
        this.bQS |= 0x20;
        n = i;
        i1 = i;
        k = i;
        this.bUi = localg;
        break;
        if ((i & 0x1) != 0) {
          this.bUc = Collections.unmodifiableList(this.bUc);
        }
        this.bVW = locala.Jm();
        HZ();
        return;
      }
      m = 1;
    }
  }
  
  private int GF()
  {
    return this.bUc.size();
  }
  
  private String GH()
  {
    Object localObject = this.bUd;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bUd = str;
    }
    return str;
  }
  
  private String GN()
  {
    Object localObject = this.bUi;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bUi = str;
    }
    return str;
  }
  
  private a GO()
  {
    if (this == bUj) {
      return new a((byte)0);
    }
    return new a((byte)0).d(this);
  }
  
  public static s GP()
  {
    return bUj;
  }
  
  public final int Ad()
  {
    int i = this.bOZ;
    if (i != -1) {
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.bUc.size())
    {
      i += i.c(2, (bw)this.bUc.get(j));
      j += 1;
    }
    j = i;
    if ((this.bQS & 0x1) != 0) {
      j = i + bb.f(3, this.bUd);
    }
    i = j;
    if ((this.bQS & 0x2) != 0) {
      i = j + i.q(4, this.bUe);
    }
    j = i;
    if ((this.bQS & 0x4) != 0) {
      j = i + i.p(5, this.bUf);
    }
    i = j;
    if ((this.bQS & 0x8) != 0) {
      i = j + i.AT();
    }
    j = i;
    if ((this.bQS & 0x10) != 0) {
      j = i + i.c(7, this.bUh);
    }
    i = j;
    if ((this.bQS & 0x20) != 0) {
      i = j + bb.f(8, this.bUi);
    }
    i = this.bVW.Ad() + i;
    this.bOZ = i;
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  protected final bb.e Cb()
  {
    return k.BT().b(s.class, a.class);
  }
  
  public final ci<s> Co()
  {
    return bRf;
  }
  
  public final boolean GG()
  {
    return (this.bQS & 0x1) != 0;
  }
  
  public final boolean GI()
  {
    return (this.bQS & 0x2) != 0;
  }
  
  public final boolean GJ()
  {
    return (this.bQS & 0x4) != 0;
  }
  
  public final boolean GK()
  {
    return (this.bQS & 0x8) != 0;
  }
  
  public final boolean GL()
  {
    return (this.bQS & 0x10) != 0;
  }
  
  public final boolean GM()
  {
    return (this.bQS & 0x20) != 0;
  }
  
  public final void a(i parami)
  {
    int i = 0;
    while (i < this.bUc.size())
    {
      parami.a(2, (bw)this.bUc.get(i));
      i += 1;
    }
    if ((this.bQS & 0x1) != 0) {
      bb.a(parami, 3, this.bUd);
    }
    if ((this.bQS & 0x2) != 0) {
      parami.n(4, this.bUe);
    }
    if ((this.bQS & 0x4) != 0) {
      parami.n(5, this.bUf);
    }
    if ((this.bQS & 0x8) != 0) {
      parami.o(6, Double.doubleToRawLongBits(this.bUg));
    }
    if ((this.bQS & 0x10) != 0) {
      parami.a(7, this.bUh);
    }
    if ((this.bQS & 0x20) != 0) {
      bb.a(parami, 8, this.bUi);
    }
    this.bVW.a(parami);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof s)) {
        return super.equals(paramObject);
      }
      paramObject = (s)paramObject;
      if (!this.bUc.equals(paramObject.bUc)) {
        return false;
      }
      if (GG() != paramObject.GG()) {
        return false;
      }
      if ((GG()) && (!GH().equals(paramObject.GH()))) {
        return false;
      }
      if (GI() != paramObject.GI()) {
        return false;
      }
      if ((GI()) && (this.bUe != paramObject.bUe)) {
        return false;
      }
      if (GJ() != paramObject.GJ()) {
        return false;
      }
      if ((GJ()) && (this.bUf != paramObject.bUf)) {
        return false;
      }
      if (GK() != paramObject.GK()) {
        return false;
      }
      if ((GK()) && (Double.doubleToLongBits(this.bUg) != Double.doubleToLongBits(paramObject.bUg))) {
        return false;
      }
      if (GL() != paramObject.GL()) {
        return false;
      }
      if ((GL()) && (!this.bUh.equals(paramObject.bUh))) {
        return false;
      }
      if (GM() != paramObject.GM()) {
        return false;
      }
      if ((GM()) && (!GN().equals(paramObject.GN()))) {
        return false;
      }
    } while (this.bVW.equals(paramObject.bVW));
    return false;
  }
  
  public final int hashCode()
  {
    if (this.bPa != 0) {
      return this.bPa;
    }
    int j = k.BS().hashCode() + 779;
    int i = j;
    if (GF() > 0) {
      i = (j * 37 + 2) * 53 + this.bUc.hashCode();
    }
    j = i;
    if (GG()) {
      j = (i * 37 + 3) * 53 + GH().hashCode();
    }
    i = j;
    if (GI()) {
      i = (j * 37 + 4) * 53 + be.aJ(this.bUe);
    }
    j = i;
    if (GJ()) {
      j = (i * 37 + 5) * 53 + be.aJ(this.bUf);
    }
    i = j;
    if (GK()) {
      i = (j * 37 + 6) * 53 + be.aJ(Double.doubleToLongBits(this.bUg));
    }
    j = i;
    if (GL()) {
      j = (i * 37 + 7) * 53 + this.bUh.hashCode();
    }
    i = j;
    if (GM()) {
      i = (j * 37 + 8) * 53 + GN().hashCode();
    }
    i = i * 29 + this.bVW.hashCode();
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
    while (i < GF())
    {
      if (!((b)this.bUc.get(i)).isInitialized())
      {
        this.bRd = 0;
        return false;
      }
      i += 1;
    }
    this.bRd = 1;
    return true;
  }
  
  public static final class a
    extends bb.a<a>
    implements ai
  {
    private int bQS;
    private List<k.s.b> bUc = Collections.emptyList();
    private Object bUd = "";
    private long bUe;
    private long bUf;
    private double bUg;
    private g bUh = g.bPf;
    private Object bUi = "";
    private co<k.s.b, k.s.b.a, ah> bUk;
    
    private a()
    {
      Cu();
    }
    
    private a(bb.b paramb)
    {
      super();
      Cu();
    }
    
    /* Error */
    private a A(h paramh, ap paramap)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: getstatic 75	com/google/b/k$s:bRf	Lcom/google/b/ci;
      //   5: aload_1
      //   6: aload_2
      //   7: invokeinterface 81 3 0
      //   12: checkcast 9	com/google/b/k$s
      //   15: astore_1
      //   16: aload_1
      //   17: ifnull +9 -> 26
      //   20: aload_0
      //   21: aload_1
      //   22: invokevirtual 84	com/google/b/k$s$a:d	(Lcom/google/b/k$s;)Lcom/google/b/k$s$a;
      //   25: pop
      //   26: aload_0
      //   27: areturn
      //   28: astore_1
      //   29: aload_1
      //   30: getfield 88	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   33: checkcast 9	com/google/b/k$s
      //   36: astore_2
      //   37: aload_1
      //   38: invokevirtual 92	com/google/b/bf:Im	()Ljava/io/IOException;
      //   41: athrow
      //   42: astore_1
      //   43: aload_2
      //   44: ifnull +9 -> 53
      //   47: aload_0
      //   48: aload_2
      //   49: invokevirtual 84	com/google/b/k$s$a:d	(Lcom/google/b/k$s;)Lcom/google/b/k$s$a;
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
    
    private void Cu()
    {
      if (bb.bXS) {
        GT();
      }
    }
    
    private k.s GQ()
    {
      k.s locals = GR();
      if (!locals.isInitialized()) {
        throw b(locals);
      }
      return locals;
    }
    
    private k.s GR()
    {
      int j = 0;
      k.s locals = new k.s(this, (byte)0);
      int k = this.bQS;
      if (this.bUk == null)
      {
        if ((this.bQS & 0x1) != 0)
        {
          this.bUc = Collections.unmodifiableList(this.bUc);
          this.bQS &= 0xFFFFFFFE;
        }
        k.s.a(locals, this.bUc);
      }
      for (;;)
      {
        if ((k & 0x2) != 0) {
          j = 1;
        }
        k.s.a(locals, this.bUd);
        int i = j;
        if ((k & 0x4) != 0)
        {
          k.s.a(locals, this.bUe);
          i = j | 0x2;
        }
        j = i;
        if ((k & 0x8) != 0)
        {
          k.s.b(locals, this.bUf);
          j = i | 0x4;
        }
        i = j;
        if ((k & 0x10) != 0)
        {
          k.s.a(locals, this.bUg);
          i = j | 0x8;
        }
        j = i;
        if ((k & 0x20) != 0) {
          j = i | 0x10;
        }
        k.s.a(locals, this.bUh);
        i = j;
        if ((k & 0x40) != 0) {
          i = j | 0x20;
        }
        k.s.b(locals, this.bUi);
        k.s.a(locals, i);
        Ib();
        return locals;
        k.s.a(locals, this.bUk.build());
      }
    }
    
    private void GS()
    {
      if ((this.bQS & 0x1) == 0)
      {
        this.bUc = new ArrayList(this.bUc);
        this.bQS |= 0x1;
      }
    }
    
    private co<k.s.b, k.s.b.a, ah> GT()
    {
      List localList;
      if (this.bUk == null)
      {
        localList = this.bUc;
        if ((this.bQS & 0x1) == 0) {
          break label54;
        }
      }
      label54:
      for (boolean bool = true;; bool = false)
      {
        this.bUk = new co(localList, bool, Ie(), Ic());
        this.bUc = null;
        return this.bUk;
      }
    }
    
    private a W(da paramda)
    {
      return (a)super.e(paramda);
    }
    
    private a X(da paramda)
    {
      return (a)super.d(paramda);
    }
    
    private a Y(aj.f paramf, Object paramObject)
    {
      return (a)super.d(paramf, paramObject);
    }
    
    private a Z(aj.f paramf, Object paramObject)
    {
      return (a)super.c(paramf, paramObject);
    }
    
    private a aH(long paramLong)
    {
      this.bQS |= 0x4;
      this.bUe = paramLong;
      onChanged();
      return this;
    }
    
    private a aI(long paramLong)
    {
      this.bQS |= 0x8;
      this.bUf = paramLong;
      onChanged();
      return this;
    }
    
    private a c(g paramg)
    {
      if (paramg == null) {
        throw new NullPointerException();
      }
      this.bQS |= 0x20;
      this.bUh = paramg;
      onChanged();
      return this;
    }
    
    private a g(double paramDouble)
    {
      this.bQS |= 0x10;
      this.bUg = paramDouble;
      onChanged();
      return this;
    }
    
    private a z(bt parambt)
    {
      if ((parambt instanceof k.s)) {
        return d((k.s)parambt);
      }
      super.a(parambt);
      return this;
    }
    
    protected final bb.e Cb()
    {
      return k.BT().b(k.s.class, a.class);
    }
    
    public final aj.a Cv()
    {
      return k.BS();
    }
    
    public final a d(k.s params)
    {
      co localco = null;
      if (params == k.s.GP()) {
        return this;
      }
      if (this.bUk == null) {
        if (!k.s.a(params).isEmpty())
        {
          if (!this.bUc.isEmpty()) {
            break label203;
          }
          this.bUc = k.s.a(params);
          this.bQS &= 0xFFFFFFFE;
          onChanged();
        }
      }
      for (;;)
      {
        if (params.GG())
        {
          this.bQS |= 0x2;
          this.bUd = k.s.b(params);
          onChanged();
        }
        if (params.GI()) {
          aH(params.bUe);
        }
        if (params.GJ()) {
          aI(params.bUf);
        }
        if (params.GK()) {
          g(params.bUg);
        }
        if (params.GL()) {
          c(params.bUh);
        }
        if (params.GM())
        {
          this.bQS |= 0x40;
          this.bUi = k.s.c(params);
          onChanged();
        }
        X(params.bVW);
        onChanged();
        return this;
        label203:
        GS();
        this.bUc.addAll(k.s.a(params));
        break;
        if (!k.s.a(params).isEmpty()) {
          if (this.bUk.isEmpty())
          {
            this.bUk.cat = null;
            this.bUk = null;
            this.bUc = k.s.a(params);
            this.bQS &= 0xFFFFFFFE;
            if (bb.bXS) {
              localco = GT();
            }
            this.bUk = localco;
          }
          else
          {
            this.bUk.a(k.s.a(params));
          }
        }
      }
    }
    
    public final boolean isInitialized()
    {
      int i = 0;
      for (;;)
      {
        int j;
        if (this.bUk == null)
        {
          j = this.bUc.size();
          if (i >= j) {
            break;
          }
          if (this.bUk != null) {
            break label65;
          }
        }
        label65:
        for (k.s.b localb = (k.s.b)this.bUc.get(i);; localb = (k.s.b)this.bUk.u(i, false))
        {
          if (localb.isInitialized()) {
            break label81;
          }
          return false;
          j = this.bUk.getCount();
          break;
        }
        label81:
        i += 1;
      }
      return true;
    }
  }
  
  public static final class b
    extends bb
    implements ah
  {
    @Deprecated
    public static final ci<b> bRf = new c() {};
    private static final b bUn = new b();
    private int bQS;
    private byte bRd = -1;
    private volatile Object bUl;
    boolean bUm;
    
    private b()
    {
      this.bUl = "";
    }
    
    private b(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private b(h paramh, ap paramap)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 36	com/google/b/k$s$b:<init>	()V
      //   4: aload_2
      //   5: ifnonnull +11 -> 16
      //   8: new 63	java/lang/NullPointerException
      //   11: dup
      //   12: invokespecial 64	java/lang/NullPointerException:<init>	()V
      //   15: athrow
      //   16: invokestatic 70	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   19: astore 5
      //   21: iconst_0
      //   22: istore_3
      //   23: iload_3
      //   24: ifne +149 -> 173
      //   27: aload_1
      //   28: invokevirtual 76	com/google/b/h:Av	()I
      //   31: istore 4
      //   33: iload 4
      //   35: lookupswitch	default:+152->187, 0:+155->190, 10:+51->86, 16:+100->135
      //   69: aload_1
      //   70: aload 5
      //   72: aload_2
      //   73: iload 4
      //   75: invokevirtual 79	com/google/b/k$s$b:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   78: ifne -55 -> 23
      //   81: iconst_1
      //   82: istore_3
      //   83: goto -60 -> 23
      //   86: aload_1
      //   87: invokevirtual 83	com/google/b/h:AD	()Lcom/google/b/g;
      //   90: astore 6
      //   92: aload_0
      //   93: aload_0
      //   94: getfield 85	com/google/b/k$s$b:bQS	I
      //   97: iconst_1
      //   98: ior
      //   99: putfield 85	com/google/b/k$s$b:bQS	I
      //   102: aload_0
      //   103: aload 6
      //   105: putfield 49	com/google/b/k$s$b:bUl	Ljava/lang/Object;
      //   108: goto -85 -> 23
      //   111: astore_1
      //   112: aload_1
      //   113: aload_0
      //   114: putfield 89	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   117: aload_1
      //   118: athrow
      //   119: astore_1
      //   120: aload_0
      //   121: aload 5
      //   123: invokevirtual 95	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   126: putfield 99	com/google/b/k$s$b:bVW	Lcom/google/b/da;
      //   129: aload_0
      //   130: invokevirtual 102	com/google/b/k$s$b:HZ	()V
      //   133: aload_1
      //   134: athrow
      //   135: aload_0
      //   136: aload_0
      //   137: getfield 85	com/google/b/k$s$b:bQS	I
      //   140: iconst_2
      //   141: ior
      //   142: putfield 85	com/google/b/k$s$b:bQS	I
      //   145: aload_0
      //   146: aload_1
      //   147: invokevirtual 106	com/google/b/h:AB	()Z
      //   150: putfield 108	com/google/b/k$s$b:bUm	Z
      //   153: goto -130 -> 23
      //   156: astore_1
      //   157: new 59	com/google/b/bf
      //   160: dup
      //   161: aload_1
      //   162: invokespecial 111	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   165: astore_1
      //   166: aload_1
      //   167: aload_0
      //   168: putfield 89	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   171: aload_1
      //   172: athrow
      //   173: aload_0
      //   174: aload 5
      //   176: invokevirtual 95	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   179: putfield 99	com/google/b/k$s$b:bVW	Lcom/google/b/da;
      //   182: aload_0
      //   183: invokevirtual 102	com/google/b/k$s$b:HZ	()V
      //   186: return
      //   187: goto -119 -> 68
      //   190: iconst_1
      //   191: istore_3
      //   192: goto -169 -> 23
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	195	0	this	b
      //   0	195	1	paramh	h
      //   0	195	2	paramap	ap
      //   22	170	3	i	int
      //   31	43	4	j	int
      //   19	156	5	locala	da.a
      //   90	14	6	localg	g
      // Exception table:
      //   from	to	target	type
      //   27	33	111	com/google/b/bf
      //   68	81	111	com/google/b/bf
      //   86	108	111	com/google/b/bf
      //   135	153	111	com/google/b/bf
      //   27	33	119	finally
      //   68	81	119	finally
      //   86	108	119	finally
      //   112	119	119	finally
      //   135	153	119	finally
      //   157	173	119	finally
      //   27	33	156	java/io/IOException
      //   68	81	156	java/io/IOException
      //   86	108	156	java/io/IOException
      //   135	153	156	java/io/IOException
    }
    
    private String GV()
    {
      Object localObject = this.bUl;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (g)localObject;
      String str = ((g)localObject).Ap();
      if (((g)localObject).Aq()) {
        this.bUl = str;
      }
      return str;
    }
    
    private a GX()
    {
      if (this == bUn) {
        return new a((byte)0);
      }
      return new a((byte)0).b(this);
    }
    
    public static b GY()
    {
      return bUn;
    }
    
    public final int Ad()
    {
      int i = this.bOZ;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.bQS & 0x1) != 0) {
        i = bb.f(1, this.bUl) + 0;
      }
      int j = i;
      if ((this.bQS & 0x2) != 0) {
        j = i + i.gK(2);
      }
      i = j + this.bVW.Ad();
      this.bOZ = i;
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    protected final bb.e Cb()
    {
      return k.BV().b(b.class, a.class);
    }
    
    public final ci<b> Co()
    {
      return bRf;
    }
    
    public final boolean GU()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final boolean GW()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final void a(i parami)
    {
      if ((this.bQS & 0x1) != 0) {
        bb.a(parami, 1, this.bUl);
      }
      if ((this.bQS & 0x2) != 0) {
        parami.t(2, this.bUm);
      }
      this.bVW.a(parami);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof b)) {
          return super.equals(paramObject);
        }
        paramObject = (b)paramObject;
        if (GU() != paramObject.GU()) {
          return false;
        }
        if ((GU()) && (!GV().equals(paramObject.GV()))) {
          return false;
        }
        if (GW() != paramObject.GW()) {
          return false;
        }
        if ((GW()) && (this.bUm != paramObject.bUm)) {
          return false;
        }
      } while (this.bVW.equals(paramObject.bVW));
      return false;
    }
    
    public final int hashCode()
    {
      if (this.bPa != 0) {
        return this.bPa;
      }
      int j = k.BU().hashCode() + 779;
      int i = j;
      if (GU()) {
        i = (j * 37 + 1) * 53 + GV().hashCode();
      }
      j = i;
      if (GW()) {
        j = (i * 37 + 2) * 53 + be.bS(this.bUm);
      }
      i = j * 29 + this.bVW.hashCode();
      this.bPa = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      int i = this.bRd;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      if (!GU())
      {
        this.bRd = 0;
        return false;
      }
      if (!GW())
      {
        this.bRd = 0;
        return false;
      }
      this.bRd = 1;
      return true;
    }
    
    public static final class a
      extends bb.a<a>
      implements ah
    {
      private int bQS;
      private Object bUl = "";
      private boolean bUm;
      
      private a()
      {
        boolean bool = bb.bXS;
      }
      
      private a(bb.b paramb)
      {
        super();
        boolean bool = bb.bXS;
      }
      
      private a A(bt parambt)
      {
        if ((parambt instanceof k.s.b)) {
          return b((k.s.b)parambt);
        }
        super.a(parambt);
        return this;
      }
      
      /* Error */
      private a B(h paramh, ap paramap)
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: getstatic 59	com/google/b/k$s$b:bRf	Lcom/google/b/ci;
        //   5: aload_1
        //   6: aload_2
        //   7: invokeinterface 65 3 0
        //   12: checkcast 14	com/google/b/k$s$b
        //   15: astore_1
        //   16: aload_1
        //   17: ifnull +9 -> 26
        //   20: aload_0
        //   21: aload_1
        //   22: invokevirtual 48	com/google/b/k$s$b$a:b	(Lcom/google/b/k$s$b;)Lcom/google/b/k$s$b$a;
        //   25: pop
        //   26: aload_0
        //   27: areturn
        //   28: astore_1
        //   29: aload_1
        //   30: getfield 69	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   33: checkcast 14	com/google/b/k$s$b
        //   36: astore_2
        //   37: aload_1
        //   38: invokevirtual 73	com/google/b/bf:Im	()Ljava/io/IOException;
        //   41: athrow
        //   42: astore_1
        //   43: aload_2
        //   44: ifnull +9 -> 53
        //   47: aload_0
        //   48: aload_2
        //   49: invokevirtual 48	com/google/b/k$s$b$a:b	(Lcom/google/b/k$s$b;)Lcom/google/b/k$s$b$a;
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
      
      private k.s.b GZ()
      {
        k.s.b localb = Ha();
        if (!localb.isInitialized()) {
          throw b(localb);
        }
        return localb;
      }
      
      private k.s.b Ha()
      {
        int i = 0;
        k.s.b localb = new k.s.b(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0) {
          i = 1;
        }
        k.s.b.a(localb, this.bUl);
        int j = i;
        if ((k & 0x2) != 0)
        {
          k.s.b.a(localb, this.bUm);
          j = i | 0x2;
        }
        k.s.b.a(localb, j);
        Ib();
        return localb;
      }
      
      private a Y(da paramda)
      {
        return (a)super.e(paramda);
      }
      
      private a Z(da paramda)
      {
        return (a)super.d(paramda);
      }
      
      private a aa(aj.f paramf, Object paramObject)
      {
        return (a)super.d(paramf, paramObject);
      }
      
      private a ab(aj.f paramf, Object paramObject)
      {
        return (a)super.c(paramf, paramObject);
      }
      
      private a bQ(boolean paramBoolean)
      {
        this.bQS |= 0x2;
        this.bUm = paramBoolean;
        onChanged();
        return this;
      }
      
      protected final bb.e Cb()
      {
        return k.BV().b(k.s.b.class, a.class);
      }
      
      public final aj.a Cv()
      {
        return k.BU();
      }
      
      public final a b(k.s.b paramb)
      {
        if (paramb == k.s.b.GY()) {
          return this;
        }
        if (paramb.GU())
        {
          this.bQS |= 0x1;
          this.bUl = k.s.b.a(paramb);
          onChanged();
        }
        if (paramb.GW()) {
          bQ(paramb.bUm);
        }
        Z(paramb.bVW);
        onChanged();
        return this;
      }
      
      public final boolean isInitialized()
      {
        int i;
        if ((this.bQS & 0x1) != 0)
        {
          i = 1;
          if (i != 0) {
            break label22;
          }
        }
        for (;;)
        {
          return false;
          i = 0;
          break;
          label22:
          if ((this.bQS & 0x2) != 0) {}
          for (i = 1; i != 0; i = 0) {
            return true;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.b.k.s
 * JD-Core Version:    0.7.0.1
 */