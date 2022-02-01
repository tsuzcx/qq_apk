package com.google.b;

public final class k$b$b
  extends bb
  implements o
{
  @Deprecated
  public static final ci<b> bRf = new c() {};
  private static final b bRx = new b();
  private int bQS;
  private byte bRd = -1;
  int bRo;
  int bRp;
  
  private k$b$b() {}
  
  private k$b$b(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private k$b$b(h paramh, ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 31	com/google/b/k$b$b:<init>	()V
    //   4: aload_2
    //   5: ifnonnull +11 -> 16
    //   8: new 54	java/lang/NullPointerException
    //   11: dup
    //   12: invokespecial 55	java/lang/NullPointerException:<init>	()V
    //   15: athrow
    //   16: invokestatic 61	com/google/b/da:Jj	()Lcom/google/b/da$a;
    //   19: astore 5
    //   21: iconst_0
    //   22: istore_3
    //   23: iload_3
    //   24: ifne +145 -> 169
    //   27: aload_1
    //   28: invokevirtual 67	com/google/b/h:Av	()I
    //   31: istore 4
    //   33: iload 4
    //   35: lookupswitch	default:+148->183, 0:+151->186, 8:+51->86, 16:+96->131
    //   69: aload_1
    //   70: aload 5
    //   72: aload_2
    //   73: iload 4
    //   75: invokevirtual 70	com/google/b/k$b$b:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   78: ifne -55 -> 23
    //   81: iconst_1
    //   82: istore_3
    //   83: goto -60 -> 23
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 72	com/google/b/k$b$b:bQS	I
    //   91: iconst_1
    //   92: ior
    //   93: putfield 72	com/google/b/k$b$b:bQS	I
    //   96: aload_0
    //   97: aload_1
    //   98: invokevirtual 75	com/google/b/h:Ay	()I
    //   101: putfield 77	com/google/b/k$b$b:bRo	I
    //   104: goto -81 -> 23
    //   107: astore_1
    //   108: aload_1
    //   109: aload_0
    //   110: putfield 81	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: aload_0
    //   117: aload 5
    //   119: invokevirtual 87	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   122: putfield 91	com/google/b/k$b$b:bVW	Lcom/google/b/da;
    //   125: aload_0
    //   126: invokevirtual 94	com/google/b/k$b$b:HZ	()V
    //   129: aload_1
    //   130: athrow
    //   131: aload_0
    //   132: aload_0
    //   133: getfield 72	com/google/b/k$b$b:bQS	I
    //   136: iconst_2
    //   137: ior
    //   138: putfield 72	com/google/b/k$b$b:bQS	I
    //   141: aload_0
    //   142: aload_1
    //   143: invokevirtual 75	com/google/b/h:Ay	()I
    //   146: putfield 96	com/google/b/k$b$b:bRp	I
    //   149: goto -126 -> 23
    //   152: astore_1
    //   153: new 50	com/google/b/bf
    //   156: dup
    //   157: aload_1
    //   158: invokespecial 99	com/google/b/bf:<init>	(Ljava/io/IOException;)V
    //   161: astore_1
    //   162: aload_1
    //   163: aload_0
    //   164: putfield 81	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   167: aload_1
    //   168: athrow
    //   169: aload_0
    //   170: aload 5
    //   172: invokevirtual 87	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   175: putfield 91	com/google/b/k$b$b:bVW	Lcom/google/b/da;
    //   178: aload_0
    //   179: invokevirtual 94	com/google/b/k$b$b:HZ	()V
    //   182: return
    //   183: goto -115 -> 68
    //   186: iconst_1
    //   187: istore_3
    //   188: goto -165 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	b
    //   0	191	1	paramh	h
    //   0	191	2	paramap	ap
    //   22	166	3	i	int
    //   31	43	4	j	int
    //   19	152	5	locala	da.a
    // Exception table:
    //   from	to	target	type
    //   27	33	107	com/google/b/bf
    //   68	81	107	com/google/b/bf
    //   86	104	107	com/google/b/bf
    //   131	149	107	com/google/b/bf
    //   27	33	115	finally
    //   68	81	115	finally
    //   86	104	115	finally
    //   108	115	115	finally
    //   131	149	115	finally
    //   153	169	115	finally
    //   27	33	152	java/io/IOException
    //   68	81	152	java/io/IOException
    //   86	104	152	java/io/IOException
    //   131	149	152	java/io/IOException
  }
  
  private a Dm()
  {
    if (this == bRx) {
      return new a((byte)0);
    }
    return new a((byte)0).a(this);
  }
  
  public static b Dn()
  {
    return bRx;
  }
  
  public final int Ad()
  {
    int i = this.bOZ;
    if (i != -1) {
      return i;
    }
    i = 0;
    if ((this.bQS & 0x1) != 0) {
      i = i.bM(1, this.bRo) + 0;
    }
    int j = i;
    if ((this.bQS & 0x2) != 0) {
      j = i + i.bM(2, this.bRp);
    }
    i = j + this.bVW.Ad();
    this.bOZ = i;
    return i;
  }
  
  public final boolean CT()
  {
    return (this.bQS & 0x1) != 0;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  protected final bb.e Cb()
  {
    return k.Bv().b(b.class, a.class);
  }
  
  public final ci<b> Co()
  {
    return bRf;
  }
  
  public final void a(i parami)
  {
    if ((this.bQS & 0x1) != 0) {
      parami.bJ(1, this.bRo);
    }
    if ((this.bQS & 0x2) != 0) {
      parami.bJ(2, this.bRp);
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
      if (CT() != paramObject.CT()) {
        return false;
      }
      if ((CT()) && (this.bRo != paramObject.bRo)) {
        return false;
      }
      if (hasEnd() != paramObject.hasEnd()) {
        return false;
      }
      if ((hasEnd()) && (this.bRp != paramObject.bRp)) {
        return false;
      }
    } while (this.bVW.equals(paramObject.bVW));
    return false;
  }
  
  public final boolean hasEnd()
  {
    return (this.bQS & 0x2) != 0;
  }
  
  public final int hashCode()
  {
    if (this.bPa != 0) {
      return this.bPa;
    }
    int j = k.Bu().hashCode() + 779;
    int i = j;
    if (CT()) {
      i = (j * 37 + 1) * 53 + this.bRo;
    }
    j = i;
    if (hasEnd()) {
      j = (i * 37 + 2) * 53 + this.bRp;
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
    this.bRd = 1;
    return true;
  }
  
  public static final class a
    extends bb.a<a>
    implements o
  {
    private int bQS;
    private int bRo;
    private int bRp;
    
    private a()
    {
      boolean bool = bb.bXS;
    }
    
    private a(bb.b paramb)
    {
      super();
      boolean bool = bb.bXS;
    }
    
    private k.b.b Do()
    {
      k.b.b localb = Dp();
      if (!localb.isInitialized()) {
        throw b(localb);
      }
      return localb;
    }
    
    private k.b.b Dp()
    {
      int i = 0;
      k.b.b localb = new k.b.b(this, (byte)0);
      int k = this.bQS;
      if ((k & 0x1) != 0)
      {
        k.b.b.a(localb, this.bRo);
        i = 1;
      }
      int j = i;
      if ((k & 0x2) != 0)
      {
        k.b.b.b(localb, this.bRp);
        j = i | 0x2;
      }
      k.b.b.c(localb, j);
      Ib();
      return localb;
    }
    
    private a h(bt parambt)
    {
      if ((parambt instanceof k.b.b)) {
        return a((k.b.b)parambt);
      }
      super.a(parambt);
      return this;
    }
    
    private a hc(int paramInt)
    {
      this.bQS |= 0x1;
      this.bRo = paramInt;
      onChanged();
      return this;
    }
    
    private a hd(int paramInt)
    {
      this.bQS |= 0x2;
      this.bRp = paramInt;
      onChanged();
      return this;
    }
    
    /* Error */
    private a i(h paramh, ap paramap)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: getstatic 89	com/google/b/k$b$b:bRf	Lcom/google/b/ci;
      //   5: aload_1
      //   6: aload_2
      //   7: invokeinterface 95 3 0
      //   12: checkcast 9	com/google/b/k$b$b
      //   15: astore_1
      //   16: aload_1
      //   17: ifnull +9 -> 26
      //   20: aload_0
      //   21: aload_1
      //   22: invokevirtual 72	com/google/b/k$b$b$a:a	(Lcom/google/b/k$b$b;)Lcom/google/b/k$b$b$a;
      //   25: pop
      //   26: aload_0
      //   27: areturn
      //   28: astore_1
      //   29: aload_1
      //   30: getfield 99	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   33: checkcast 9	com/google/b/k$b$b
      //   36: astore_2
      //   37: aload_1
      //   38: invokevirtual 103	com/google/b/bf:Im	()Ljava/io/IOException;
      //   41: athrow
      //   42: astore_1
      //   43: aload_2
      //   44: ifnull +9 -> 53
      //   47: aload_0
      //   48: aload_2
      //   49: invokevirtual 72	com/google/b/k$b$b$a:a	(Lcom/google/b/k$b$b;)Lcom/google/b/k$b$b$a;
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
    
    private a m(aj.f paramf, Object paramObject)
    {
      return (a)super.d(paramf, paramObject);
    }
    
    private a m(da paramda)
    {
      return (a)super.e(paramda);
    }
    
    private a n(aj.f paramf, Object paramObject)
    {
      return (a)super.c(paramf, paramObject);
    }
    
    private a n(da paramda)
    {
      return (a)super.d(paramda);
    }
    
    protected final bb.e Cb()
    {
      return k.Bv().b(k.b.b.class, a.class);
    }
    
    public final aj.a Cv()
    {
      return k.Bu();
    }
    
    public final a a(k.b.b paramb)
    {
      if (paramb == k.b.b.Dn()) {
        return this;
      }
      if (paramb.CT()) {
        hc(paramb.bRo);
      }
      if (paramb.hasEnd()) {
        hd(paramb.bRp);
      }
      n(paramb.bVW);
      onChanged();
      return this;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.b.k.b.b
 * JD-Core Version:    0.7.0.1
 */