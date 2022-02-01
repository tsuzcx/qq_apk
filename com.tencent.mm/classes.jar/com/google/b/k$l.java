package com.google.b;

public final class k$l
  extends bb
  implements z
{
  @Deprecated
  public static final ci<l> bRf = new c() {};
  private static final l bTB = new l();
  private int bQS;
  private volatile Object bQT;
  private byte bRd = -1;
  boolean bTA;
  private volatile Object bTw;
  private volatile Object bTx;
  private k.m bTy;
  boolean bTz;
  
  private k$l()
  {
    this.bQT = "";
    this.bTw = "";
    this.bTx = "";
  }
  
  private k$l(bb.a<?> parama)
  {
    super(parama);
  }
  
  /* Error */
  private k$l(h paramh, ap paramap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 38	com/google/b/k$l:<init>	()V
    //   4: aload_2
    //   5: ifnonnull +11 -> 16
    //   8: new 69	java/lang/NullPointerException
    //   11: dup
    //   12: invokespecial 70	java/lang/NullPointerException:<init>	()V
    //   15: athrow
    //   16: invokestatic 76	com/google/b/da:Jj	()Lcom/google/b/da$a;
    //   19: astore 6
    //   21: iconst_0
    //   22: istore_3
    //   23: iload_3
    //   24: ifne +326 -> 350
    //   27: aload_1
    //   28: invokevirtual 82	com/google/b/h:Av	()I
    //   31: istore 4
    //   33: iload 4
    //   35: lookupswitch	default:+338->373, 0:+344->379, 10:+83->118, 18:+132->167, 26:+174->209, 34:+199->234, 40:+271->306, 48:+293->328
    //   101: aload_1
    //   102: aload 6
    //   104: aload_2
    //   105: iload 4
    //   107: invokevirtual 85	com/google/b/k$l:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
    //   110: ifne +254 -> 364
    //   113: iconst_1
    //   114: istore_3
    //   115: goto +261 -> 376
    //   118: aload_1
    //   119: invokevirtual 89	com/google/b/h:AD	()Lcom/google/b/g;
    //   122: astore 5
    //   124: aload_0
    //   125: aload_0
    //   126: getfield 91	com/google/b/k$l:bQS	I
    //   129: iconst_1
    //   130: ior
    //   131: putfield 91	com/google/b/k$l:bQS	I
    //   134: aload_0
    //   135: aload 5
    //   137: putfield 51	com/google/b/k$l:bQT	Ljava/lang/Object;
    //   140: goto -117 -> 23
    //   143: astore_1
    //   144: aload_1
    //   145: aload_0
    //   146: putfield 95	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   149: aload_1
    //   150: athrow
    //   151: astore_1
    //   152: aload_0
    //   153: aload 6
    //   155: invokevirtual 101	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   158: putfield 105	com/google/b/k$l:bVW	Lcom/google/b/da;
    //   161: aload_0
    //   162: invokevirtual 108	com/google/b/k$l:HZ	()V
    //   165: aload_1
    //   166: athrow
    //   167: aload_1
    //   168: invokevirtual 89	com/google/b/h:AD	()Lcom/google/b/g;
    //   171: astore 5
    //   173: aload_0
    //   174: aload_0
    //   175: getfield 91	com/google/b/k$l:bQS	I
    //   178: iconst_2
    //   179: ior
    //   180: putfield 91	com/google/b/k$l:bQS	I
    //   183: aload_0
    //   184: aload 5
    //   186: putfield 53	com/google/b/k$l:bTw	Ljava/lang/Object;
    //   189: goto -166 -> 23
    //   192: astore_1
    //   193: new 65	com/google/b/bf
    //   196: dup
    //   197: aload_1
    //   198: invokespecial 111	com/google/b/bf:<init>	(Ljava/io/IOException;)V
    //   201: astore_1
    //   202: aload_1
    //   203: aload_0
    //   204: putfield 95	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   207: aload_1
    //   208: athrow
    //   209: aload_1
    //   210: invokevirtual 89	com/google/b/h:AD	()Lcom/google/b/g;
    //   213: astore 5
    //   215: aload_0
    //   216: aload_0
    //   217: getfield 91	com/google/b/k$l:bQS	I
    //   220: iconst_4
    //   221: ior
    //   222: putfield 91	com/google/b/k$l:bQS	I
    //   225: aload_0
    //   226: aload 5
    //   228: putfield 55	com/google/b/k$l:bTx	Ljava/lang/Object;
    //   231: goto -208 -> 23
    //   234: aload_0
    //   235: getfield 91	com/google/b/k$l:bQS	I
    //   238: bipush 8
    //   240: iand
    //   241: ifeq +126 -> 367
    //   244: aload_0
    //   245: getfield 113	com/google/b/k$l:bTy	Lcom/google/b/k$m;
    //   248: invokevirtual 119	com/google/b/k$m:FP	()Lcom/google/b/k$m$a;
    //   251: astore 5
    //   253: aload_0
    //   254: aload_1
    //   255: getstatic 120	com/google/b/k$m:bRf	Lcom/google/b/ci;
    //   258: aload_2
    //   259: invokevirtual 123	com/google/b/h:a	(Lcom/google/b/ci;Lcom/google/b/ap;)Lcom/google/b/bw;
    //   262: checkcast 115	com/google/b/k$m
    //   265: putfield 113	com/google/b/k$l:bTy	Lcom/google/b/k$m;
    //   268: aload 5
    //   270: ifnull +22 -> 292
    //   273: aload 5
    //   275: aload_0
    //   276: getfield 113	com/google/b/k$l:bTy	Lcom/google/b/k$m;
    //   279: invokevirtual 129	com/google/b/k$m$a:d	(Lcom/google/b/k$m;)Lcom/google/b/k$m$a;
    //   282: pop
    //   283: aload_0
    //   284: aload 5
    //   286: invokevirtual 133	com/google/b/k$m$a:FS	()Lcom/google/b/k$m;
    //   289: putfield 113	com/google/b/k$l:bTy	Lcom/google/b/k$m;
    //   292: aload_0
    //   293: aload_0
    //   294: getfield 91	com/google/b/k$l:bQS	I
    //   297: bipush 8
    //   299: ior
    //   300: putfield 91	com/google/b/k$l:bQS	I
    //   303: goto -280 -> 23
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 91	com/google/b/k$l:bQS	I
    //   311: bipush 16
    //   313: ior
    //   314: putfield 91	com/google/b/k$l:bQS	I
    //   317: aload_0
    //   318: aload_1
    //   319: invokevirtual 137	com/google/b/h:AB	()Z
    //   322: putfield 139	com/google/b/k$l:bTz	Z
    //   325: goto -302 -> 23
    //   328: aload_0
    //   329: aload_0
    //   330: getfield 91	com/google/b/k$l:bQS	I
    //   333: bipush 32
    //   335: ior
    //   336: putfield 91	com/google/b/k$l:bQS	I
    //   339: aload_0
    //   340: aload_1
    //   341: invokevirtual 137	com/google/b/h:AB	()Z
    //   344: putfield 141	com/google/b/k$l:bTA	Z
    //   347: goto -324 -> 23
    //   350: aload_0
    //   351: aload 6
    //   353: invokevirtual 101	com/google/b/da$a:Jm	()Lcom/google/b/da;
    //   356: putfield 105	com/google/b/k$l:bVW	Lcom/google/b/da;
    //   359: aload_0
    //   360: invokevirtual 108	com/google/b/k$l:HZ	()V
    //   363: return
    //   364: goto +12 -> 376
    //   367: aconst_null
    //   368: astore 5
    //   370: goto -117 -> 253
    //   373: goto -273 -> 100
    //   376: goto -353 -> 23
    //   379: iconst_1
    //   380: istore_3
    //   381: goto -358 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	l
    //   0	384	1	paramh	h
    //   0	384	2	paramap	ap
    //   22	359	3	i	int
    //   31	75	4	j	int
    //   122	247	5	localObject	Object
    //   19	333	6	locala	da.a
    // Exception table:
    //   from	to	target	type
    //   27	33	143	com/google/b/bf
    //   100	113	143	com/google/b/bf
    //   118	140	143	com/google/b/bf
    //   167	189	143	com/google/b/bf
    //   209	231	143	com/google/b/bf
    //   234	253	143	com/google/b/bf
    //   253	268	143	com/google/b/bf
    //   273	292	143	com/google/b/bf
    //   292	303	143	com/google/b/bf
    //   306	325	143	com/google/b/bf
    //   328	347	143	com/google/b/bf
    //   27	33	151	finally
    //   100	113	151	finally
    //   118	140	151	finally
    //   144	151	151	finally
    //   167	189	151	finally
    //   193	209	151	finally
    //   209	231	151	finally
    //   234	253	151	finally
    //   253	268	151	finally
    //   273	292	151	finally
    //   292	303	151	finally
    //   306	325	151	finally
    //   328	347	151	finally
    //   27	33	192	java/io/IOException
    //   100	113	192	java/io/IOException
    //   118	140	192	java/io/IOException
    //   167	189	192	java/io/IOException
    //   209	231	192	java/io/IOException
    //   234	253	192	java/io/IOException
    //   253	268	192	java/io/IOException
    //   273	292	192	java/io/IOException
    //   292	303	192	java/io/IOException
    //   306	325	192	java/io/IOException
    //   328	347	192	java/io/IOException
  }
  
  private a FJ()
  {
    if (this == bTB) {
      return new a((byte)0);
    }
    return new a((byte)0).d(this);
  }
  
  public static l FK()
  {
    return bTB;
  }
  
  public final int Ad()
  {
    int i = this.bOZ;
    if (i != -1) {
      return i;
    }
    int j = 0;
    if ((this.bQS & 0x1) != 0) {
      j = bb.f(1, this.bQT) + 0;
    }
    i = j;
    if ((this.bQS & 0x2) != 0) {
      i = j + bb.f(2, this.bTw);
    }
    j = i;
    if ((this.bQS & 0x4) != 0) {
      j = i + bb.f(3, this.bTx);
    }
    i = j;
    if ((this.bQS & 0x8) != 0) {
      i = j + i.c(4, FG());
    }
    j = i;
    if ((this.bQS & 0x10) != 0) {
      j = i + i.gK(5);
    }
    i = j;
    if ((this.bQS & 0x20) != 0) {
      i = j + i.gK(6);
    }
    i += this.bVW.Ad();
    this.bOZ = i;
    return i;
  }
  
  public final da Ca()
  {
    return this.bVW;
  }
  
  protected final bb.e Cb()
  {
    return k.BB().b(l.class, a.class);
  }
  
  public final boolean Cc()
  {
    return (this.bQS & 0x1) != 0;
  }
  
  public final boolean Cj()
  {
    return (this.bQS & 0x8) != 0;
  }
  
  public final ci<l> Co()
  {
    return bRf;
  }
  
  public final boolean FC()
  {
    return (this.bQS & 0x2) != 0;
  }
  
  public final String FD()
  {
    Object localObject = this.bTw;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bTw = str;
    }
    return str;
  }
  
  public final boolean FE()
  {
    return (this.bQS & 0x4) != 0;
  }
  
  public final String FF()
  {
    Object localObject = this.bTx;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (g)localObject;
    String str = ((g)localObject).Ap();
    if (((g)localObject).Aq()) {
      this.bTx = str;
    }
    return str;
  }
  
  public final k.m FG()
  {
    if (this.bTy == null) {
      return k.m.FQ();
    }
    return this.bTy;
  }
  
  public final boolean FH()
  {
    return (this.bQS & 0x10) != 0;
  }
  
  public final boolean FI()
  {
    return (this.bQS & 0x20) != 0;
  }
  
  public final void a(i parami)
  {
    if ((this.bQS & 0x1) != 0) {
      bb.a(parami, 1, this.bQT);
    }
    if ((this.bQS & 0x2) != 0) {
      bb.a(parami, 2, this.bTw);
    }
    if ((this.bQS & 0x4) != 0) {
      bb.a(parami, 3, this.bTx);
    }
    if ((this.bQS & 0x8) != 0) {
      parami.a(4, FG());
    }
    if ((this.bQS & 0x10) != 0) {
      parami.t(5, this.bTz);
    }
    if ((this.bQS & 0x20) != 0) {
      parami.t(6, this.bTA);
    }
    this.bVW.a(parami);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof l)) {
        return super.equals(paramObject);
      }
      paramObject = (l)paramObject;
      if (Cc() != paramObject.Cc()) {
        return false;
      }
      if ((Cc()) && (!getName().equals(paramObject.getName()))) {
        return false;
      }
      if (FC() != paramObject.FC()) {
        return false;
      }
      if ((FC()) && (!FD().equals(paramObject.FD()))) {
        return false;
      }
      if (FE() != paramObject.FE()) {
        return false;
      }
      if ((FE()) && (!FF().equals(paramObject.FF()))) {
        return false;
      }
      if (Cj() != paramObject.Cj()) {
        return false;
      }
      if ((Cj()) && (!FG().equals(paramObject.FG()))) {
        return false;
      }
      if (FH() != paramObject.FH()) {
        return false;
      }
      if ((FH()) && (this.bTz != paramObject.bTz)) {
        return false;
      }
      if (FI() != paramObject.FI()) {
        return false;
      }
      if ((FI()) && (this.bTA != paramObject.bTA)) {
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
    int j = k.BA().hashCode() + 779;
    int i = j;
    if (Cc()) {
      i = (j * 37 + 1) * 53 + getName().hashCode();
    }
    j = i;
    if (FC()) {
      j = (i * 37 + 2) * 53 + FD().hashCode();
    }
    i = j;
    if (FE()) {
      i = (j * 37 + 3) * 53 + FF().hashCode();
    }
    j = i;
    if (Cj()) {
      j = (i * 37 + 4) * 53 + FG().hashCode();
    }
    i = j;
    if (FH()) {
      i = (j * 37 + 5) * 53 + be.bS(this.bTz);
    }
    j = i;
    if (FI()) {
      j = (i * 37 + 6) * 53 + be.bS(this.bTA);
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
    if ((Cj()) && (!FG().isInitialized()))
    {
      this.bRd = 0;
      return false;
    }
    this.bRd = 1;
    return true;
  }
  
  public static final class a
    extends bb.a<a>
    implements z
  {
    private int bQS;
    private Object bQT = "";
    private cs<k.m, k.m.a, aa> bRm;
    private boolean bTA;
    private Object bTw = "";
    private Object bTx = "";
    private k.m bTy;
    private boolean bTz;
    
    private a()
    {
      Cu();
    }
    
    private a(bb.b paramb)
    {
      super();
      Cu();
    }
    
    private cs<k.m, k.m.a, aa> CK()
    {
      if (this.bRm == null)
      {
        this.bRm = new cs(FG(), Ie(), Ic());
        this.bTy = null;
      }
      return this.bRm;
    }
    
    private void Cu()
    {
      if (bb.bXS) {
        CK();
      }
    }
    
    private k.m FG()
    {
      if (this.bRm == null)
      {
        if (this.bTy == null) {
          return k.m.FQ();
        }
        return this.bTy;
      }
      return (k.m)this.bRm.IU();
    }
    
    private k.l FL()
    {
      k.l locall = FM();
      if (!locall.isInitialized()) {
        throw b(locall);
      }
      return locall;
    }
    
    private k.l FM()
    {
      int i = 0;
      k.l locall = new k.l(this, (byte)0);
      int k = this.bQS;
      if ((k & 0x1) != 0) {
        i = 1;
      }
      k.l.a(locall, this.bQT);
      int j = i;
      if ((k & 0x2) != 0) {
        j = i | 0x2;
      }
      k.l.b(locall, this.bTw);
      if ((k & 0x4) != 0) {}
      for (i = j | 0x4;; i = j)
      {
        k.l.c(locall, this.bTx);
        if ((k & 0x8) != 0) {
          if (this.bRm == null) {
            k.l.a(locall, this.bTy);
          }
        }
        for (j = i | 0x8;; j = i)
        {
          i = j;
          if ((k & 0x10) != 0)
          {
            k.l.a(locall, this.bTz);
            i = j | 0x10;
          }
          j = i;
          if ((k & 0x20) != 0)
          {
            k.l.b(locall, this.bTA);
            j = i | 0x20;
          }
          k.l.a(locall, j);
          Ib();
          return locall;
          k.l.a(locall, (k.m)this.bRm.IV());
          break;
        }
      }
    }
    
    private a G(da paramda)
    {
      return (a)super.e(paramda);
    }
    
    private a H(da paramda)
    {
      return (a)super.d(paramda);
    }
    
    private a I(aj.f paramf, Object paramObject)
    {
      return (a)super.d(paramf, paramObject);
    }
    
    private a J(aj.f paramf, Object paramObject)
    {
      return (a)super.c(paramf, paramObject);
    }
    
    private a a(k.m paramm)
    {
      if (this.bRm == null) {
        if (((this.bQS & 0x8) != 0) && (this.bTy != null) && (this.bTy != k.m.FQ()))
        {
          this.bTy = k.m.b(this.bTy).d(paramm).FS();
          onChanged();
        }
      }
      for (;;)
      {
        this.bQS |= 0x8;
        return this;
        this.bTy = paramm;
        break;
        this.bRm.c(paramm);
      }
    }
    
    private a bM(boolean paramBoolean)
    {
      this.bQS |= 0x10;
      this.bTz = paramBoolean;
      onChanged();
      return this;
    }
    
    private a bN(boolean paramBoolean)
    {
      this.bQS |= 0x20;
      this.bTA = paramBoolean;
      onChanged();
      return this;
    }
    
    private a r(bt parambt)
    {
      if ((parambt instanceof k.l)) {
        return d((k.l)parambt);
      }
      super.a(parambt);
      return this;
    }
    
    /* Error */
    private a s(h paramh, ap paramap)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: getstatic 190	com/google/b/k$l:bRf	Lcom/google/b/ci;
      //   5: aload_1
      //   6: aload_2
      //   7: invokeinterface 195 3 0
      //   12: checkcast 9	com/google/b/k$l
      //   15: astore_1
      //   16: aload_1
      //   17: ifnull +9 -> 26
      //   20: aload_0
      //   21: aload_1
      //   22: invokevirtual 179	com/google/b/k$l$a:d	(Lcom/google/b/k$l;)Lcom/google/b/k$l$a;
      //   25: pop
      //   26: aload_0
      //   27: areturn
      //   28: astore_1
      //   29: aload_1
      //   30: getfield 199	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   33: checkcast 9	com/google/b/k$l
      //   36: astore_2
      //   37: aload_1
      //   38: invokevirtual 203	com/google/b/bf:Im	()Ljava/io/IOException;
      //   41: athrow
      //   42: astore_1
      //   43: aload_2
      //   44: ifnull +9 -> 53
      //   47: aload_0
      //   48: aload_2
      //   49: invokevirtual 179	com/google/b/k$l$a:d	(Lcom/google/b/k$l;)Lcom/google/b/k$l$a;
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
      return k.BB().b(k.l.class, a.class);
    }
    
    public final aj.a Cv()
    {
      return k.BA();
    }
    
    public final a d(k.l paraml)
    {
      if (paraml == k.l.FK()) {
        return this;
      }
      if (paraml.Cc())
      {
        this.bQS |= 0x1;
        this.bQT = k.l.a(paraml);
        onChanged();
      }
      if (paraml.FC())
      {
        this.bQS |= 0x2;
        this.bTw = k.l.b(paraml);
        onChanged();
      }
      if (paraml.FE())
      {
        this.bQS |= 0x4;
        this.bTx = k.l.c(paraml);
        onChanged();
      }
      if (paraml.Cj()) {
        a(paraml.FG());
      }
      if (paraml.FH()) {
        bM(paraml.bTz);
      }
      if (paraml.FI()) {
        bN(paraml.bTA);
      }
      H(paraml.bVW);
      onChanged();
      return this;
    }
    
    public final boolean isInitialized()
    {
      if ((this.bQS & 0x8) != 0) {}
      for (int i = 1; (i != 0) && (!FG().isInitialized()); i = 0) {
        return false;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.b.k.l
 * JD-Core Version:    0.7.0.1
 */