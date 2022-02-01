package com.tencent.ilink.tdi;

import com.google.d.am.a;
import com.google.d.am.f;
import com.google.d.am.g;
import com.google.d.am.j;
import com.google.d.bg;
import com.google.d.bg.a;
import com.google.d.bg.b;
import com.google.d.bg.e;
import com.google.d.bg.f;
import com.google.d.bj;
import com.google.d.cb;
import com.google.d.cs;
import com.google.d.dn;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class b
{
  private static am.g descriptor;
  private static final bg.e eeA;
  private static final am.a eeB;
  private static final bg.e eeC;
  private static final am.a eeD;
  private static final bg.e eeE;
  private static final am.a eeF;
  private static final bg.e eeG;
  private static final am.a eeH;
  private static final bg.e eeI;
  private static final am.a eeJ;
  private static final bg.e eeK;
  private static final am.a eeL;
  private static final bg.e eeM;
  private static final am.a eeN;
  private static final bg.e eeO;
  private static final am.a eeP;
  private static final bg.e eeQ;
  private static final am.a eeR;
  private static final bg.e eeS;
  private static final am.a eeT;
  private static final bg.e eeU;
  private static final am.a eeV;
  private static final bg.e eeW;
  private static final am.a eeX;
  private static final bg.e eeY;
  private static final am.a eef;
  private static final bg.e eeg;
  private static final am.a eeh;
  private static final bg.e eei;
  private static final am.a eej;
  private static final bg.e eek;
  private static final am.a eel;
  private static final bg.e eem;
  private static final am.a een;
  private static final bg.e eeo;
  private static final am.a eep;
  private static final bg.e eeq;
  private static final am.a eer;
  private static final bg.e ees;
  private static final am.a eet;
  private static final bg.e eeu;
  private static final am.a eev;
  private static final bg.e eew;
  private static final am.a eex;
  private static final bg.e eey;
  private static final am.a eez;
  
  static
  {
    AppMethodBeat.i(214229);
    am.g localg = a.getDescriptor();
    localg = am.g.a(new String[] { "" }, new am.g[] { localg });
    descriptor = localg;
    eef = (am.a)localg.ahs().get(0);
    eeg = new bg.e(eef, new String[] { "EnableLog", "EnableConsole", "LogLevel" });
    eeh = (am.a)descriptor.ahs().get(1);
    eei = new bg.e(eeh, new String[] { "AppDir", "IlinkProductId", "IlinkSn", "IlinkId", "IlinkToken", "LogConfig", "IosIdfa" });
    eej = (am.a)descriptor.ahs().get(2);
    eek = new bg.e(eej, new String[] { "TimeoutMs", "RecoType", "EnvData", "RetryCount" });
    eel = (am.a)descriptor.ahs().get(3);
    eem = new bg.e(eel, new String[] { "ConfigData" });
    een = (am.a)descriptor.ahs().get(4);
    eeo = new bg.e(een, new String[] { "TimeoutMs", "RecgType", "DataType", "FaceData", "WxbaseReq", "WxpayReq", "RetryCount" });
    eep = (am.a)descriptor.ahs().get(5);
    eeq = new bg.e(eep, new String[] { "WxbaseResp", "WxpayResp", "PassType" });
    eer = (am.a)descriptor.ahs().get(6);
    ees = new bg.e(eer, new String[] { "TimeoutMs", "Type", "BusinessType", "BusinessReq", "RetryCount" });
    eet = (am.a)descriptor.ahs().get(7);
    eeu = new bg.e(eet, new String[] { "Type", "PassType", "BusinessResp" });
    eev = (am.a)descriptor.ahs().get(8);
    eew = new bg.e(eev, new String[] { "TimeoutMs", "BusinessReq", "AuthCode", "RetryCount", "SessionType", "Vendorid", "Lkid", "SecurityInfo" });
    eex = (am.a)descriptor.ahs().get(9);
    eey = new bg.e(eex, new String[] { "LoginType", "VerifyBuffer", "DetailRet" });
    eez = (am.a)descriptor.ahs().get(10);
    eeA = new bg.e(eez, new String[] { "QrcodeVerifyScene", "ConfirmBusinessInfo" });
    eeB = (am.a)descriptor.ahs().get(11);
    eeC = new bg.e(eeB, new String[] { "Path" });
    eeD = (am.a)descriptor.ahs().get(12);
    eeE = new bg.e(eeD, new String[] { "Status", "Uin", "Nickname", "AvatarUrl", "BusinessConfirmRespBuffer" });
    eeF = (am.a)descriptor.ahs().get(13);
    eeG = new bg.e(eeF, new String[] { "LoginStatus", "LoginType", "Uin", "Username", "LoginScene" });
    eeH = (am.a)descriptor.ahs().get(14);
    eeI = new bg.e(eeH, new String[] { "Cmdid", "CryptoAlgo", "TimeoutMs", "Url", "Body", "NetType", "RetryCount", "LimitFlow", "LimitFrequency" });
    eeJ = (am.a)descriptor.ahs().get(15);
    eeK = new bg.e(eeJ, new String[] { "Body" });
    eeL = (am.a)descriptor.ahs().get(16);
    eeM = new bg.e(eeL, new String[] { "Msgid", "CreateTime", "Body" });
    eeN = (am.a)descriptor.ahs().get(17);
    eeO = new bg.e(eeN, new String[] { "Token", "ExpireTimestamp" });
    eeP = (am.a)descriptor.ahs().get(18);
    eeQ = new bg.e(eeP, new String[] { "IlinkAppid" });
    eeR = (am.a)descriptor.ahs().get(19);
    eeS = new bg.e(eeR, new String[] { "OauthCode" });
    eeT = (am.a)descriptor.ahs().get(20);
    eeU = new bg.e(eeT, new String[] { "IlinkAppidList" });
    eeV = (am.a)descriptor.ahs().get(21);
    eeW = new bg.e(eeV, new String[] { "Body" });
    eeX = (am.a)descriptor.ahs().get(22);
    eeY = new bg.e(eeX, new String[] { "Body" });
    a.getDescriptor();
    AppMethodBeat.o(214229);
  }
  
  public static final class a
    extends bg
    implements c
  {
    @Deprecated
    public static final cs<a> PARSER;
    private static final a efc;
    private int bitField0_;
    long eeZ;
    long efa;
    com.google.d.h efb;
    private byte memoizedIsInitialized = -1;
    
    static
    {
      AppMethodBeat.i(214755);
      efc = new a();
      PARSER = new com.google.d.c() {};
      AppMethodBeat.o(214755);
    }
    
    private a()
    {
      this.efb = com.google.d.h.dIJ;
    }
    
    private a(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private a(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 40	com/tencent/ilink/tdi/b$a:<init>	()V
      //   4: ldc 72
      //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_2
      //   10: ifnonnull +18 -> 28
      //   13: new 74	java/lang/NullPointerException
      //   16: dup
      //   17: invokespecial 75	java/lang/NullPointerException:<init>	()V
      //   20: astore_1
      //   21: ldc 72
      //   23: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: aload_1
      //   27: athrow
      //   28: invokestatic 81	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +189 -> 225
      //   39: aload_1
      //   40: invokevirtual 87	com/google/d/i:aac	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+197->244, 0:+200->247, 8:+59->106, 16:+114->161, 26:+157->204
      //   89: aload_1
      //   90: aload 5
      //   92: aload_2
      //   93: iload 4
      //   95: invokevirtual 91	com/tencent/ilink/tdi/b$a:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   98: ifne -63 -> 35
      //   101: iconst_1
      //   102: istore_3
      //   103: goto -68 -> 35
      //   106: aload_0
      //   107: aload_0
      //   108: getfield 93	com/tencent/ilink/tdi/b$a:bitField0_	I
      //   111: iconst_1
      //   112: ior
      //   113: putfield 93	com/tencent/ilink/tdi/b$a:bitField0_	I
      //   116: aload_0
      //   117: aload_1
      //   118: invokevirtual 97	com/google/d/i:aad	()J
      //   121: putfield 99	com/tencent/ilink/tdi/b$a:eeZ	J
      //   124: goto -89 -> 35
      //   127: astore_1
      //   128: aload_1
      //   129: aload_0
      //   130: putfield 103	com/google/d/bk:dST	Lcom/google/d/ce;
      //   133: ldc 72
      //   135: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   138: aload_1
      //   139: athrow
      //   140: astore_1
      //   141: aload_0
      //   142: aload 5
      //   144: invokevirtual 109	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   147: putfield 113	com/tencent/ilink/tdi/b$a:unknownFields	Lcom/google/d/dn;
      //   150: aload_0
      //   151: invokevirtual 116	com/tencent/ilink/tdi/b$a:makeExtensionsImmutable	()V
      //   154: ldc 72
      //   156: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   159: aload_1
      //   160: athrow
      //   161: aload_0
      //   162: aload_0
      //   163: getfield 93	com/tencent/ilink/tdi/b$a:bitField0_	I
      //   166: iconst_2
      //   167: ior
      //   168: putfield 93	com/tencent/ilink/tdi/b$a:bitField0_	I
      //   171: aload_0
      //   172: aload_1
      //   173: invokevirtual 97	com/google/d/i:aad	()J
      //   176: putfield 118	com/tencent/ilink/tdi/b$a:efa	J
      //   179: goto -144 -> 35
      //   182: astore_1
      //   183: new 69	com/google/d/bk
      //   186: dup
      //   187: aload_1
      //   188: invokespecial 121	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   191: astore_1
      //   192: aload_1
      //   193: aload_0
      //   194: putfield 103	com/google/d/bk:dST	Lcom/google/d/ce;
      //   197: ldc 72
      //   199: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   202: aload_1
      //   203: athrow
      //   204: aload_0
      //   205: aload_0
      //   206: getfield 93	com/tencent/ilink/tdi/b$a:bitField0_	I
      //   209: iconst_4
      //   210: ior
      //   211: putfield 93	com/tencent/ilink/tdi/b$a:bitField0_	I
      //   214: aload_0
      //   215: aload_1
      //   216: invokevirtual 125	com/google/d/i:aak	()Lcom/google/d/h;
      //   219: putfield 59	com/tencent/ilink/tdi/b$a:efb	Lcom/google/d/h;
      //   222: goto -187 -> 35
      //   225: aload_0
      //   226: aload 5
      //   228: invokevirtual 109	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   231: putfield 113	com/tencent/ilink/tdi/b$a:unknownFields	Lcom/google/d/dn;
      //   234: aload_0
      //   235: invokevirtual 116	com/tencent/ilink/tdi/b$a:makeExtensionsImmutable	()V
      //   238: ldc 72
      //   240: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   243: return
      //   244: goto -156 -> 88
      //   247: iconst_1
      //   248: istore_3
      //   249: goto -214 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	252	0	this	a
      //   0	252	1	parami	com.google.d.i
      //   0	252	2	paramat	com.google.d.at
      //   34	215	3	i	int
      //   43	51	4	j	int
      //   31	196	5	locala	com.google.d.dn.a
      // Exception table:
      //   from	to	target	type
      //   39	45	127	com/google/d/bk
      //   88	101	127	com/google/d/bk
      //   106	124	127	com/google/d/bk
      //   161	179	127	com/google/d/bk
      //   204	222	127	com/google/d/bk
      //   39	45	140	finally
      //   88	101	140	finally
      //   106	124	140	finally
      //   128	140	140	finally
      //   161	179	140	finally
      //   183	204	140	finally
      //   204	222	140	finally
      //   39	45	182	java/io/IOException
      //   88	101	182	java/io/IOException
      //   106	124	182	java/io/IOException
      //   161	179	182	java/io/IOException
      //   204	222	182	java/io/IOException
    }
    
    public static a J(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(214672);
      paramArrayOfByte = (a)PARSER.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(214672);
      return paramArrayOfByte;
    }
    
    private a alZ()
    {
      AppMethodBeat.i(214679);
      if (this == efc)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(214679);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(214679);
      return locala;
    }
    
    public static a ama()
    {
      return efc;
    }
    
    public final boolean alW()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final boolean alX()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final boolean alY()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214874);
      if (paramObject == this)
      {
        AppMethodBeat.o(214874);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(214874);
        return bool;
      }
      paramObject = (a)paramObject;
      if (alW() != paramObject.alW())
      {
        AppMethodBeat.o(214874);
        return false;
      }
      if ((alW()) && (this.eeZ != paramObject.eeZ))
      {
        AppMethodBeat.o(214874);
        return false;
      }
      if (alX() != paramObject.alX())
      {
        AppMethodBeat.o(214874);
        return false;
      }
      if ((alX()) && (this.efa != paramObject.efa))
      {
        AppMethodBeat.o(214874);
        return false;
      }
      if (alY() != paramObject.alY())
      {
        AppMethodBeat.o(214874);
        return false;
      }
      if ((alY()) && (!this.efb.equals(paramObject.efb)))
      {
        AppMethodBeat.o(214874);
        return false;
      }
      if (!this.unknownFields.equals(paramObject.unknownFields))
      {
        AppMethodBeat.o(214874);
        return false;
      }
      AppMethodBeat.o(214874);
      return true;
    }
    
    public final cs<a> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(214858);
      int i = this.memoizedSize;
      if (i != -1)
      {
        AppMethodBeat.o(214858);
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        j = com.google.d.k.r(1, this.eeZ) + 0;
      }
      i = j;
      if ((this.bitField0_ & 0x2) != 0) {
        i = j + com.google.d.k.r(2, this.efa);
      }
      j = i;
      if ((this.bitField0_ & 0x4) != 0) {
        j = i + com.google.d.k.c(3, this.efb);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      AppMethodBeat.o(214858);
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(214887);
      if (this.memoizedHashCode != 0)
      {
        i = this.memoizedHashCode;
        AppMethodBeat.o(214887);
        return i;
      }
      int j = b.alQ().hashCode() + 779;
      int i = j;
      if (alW()) {
        i = (j * 37 + 1) * 53 + bj.hashLong(this.eeZ);
      }
      j = i;
      if (alX()) {
        j = (i * 37 + 2) * 53 + bj.hashLong(this.efa);
      }
      i = j;
      if (alY()) {
        i = (j * 37 + 3) * 53 + this.efb.hashCode();
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      AppMethodBeat.o(214887);
      return i;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(214785);
      bg.e locale = b.alR().b(a.class, a.class);
      AppMethodBeat.o(214785);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final Object newInstance(bg.f paramf)
    {
      AppMethodBeat.i(214766);
      paramf = new a();
      AppMethodBeat.o(214766);
      return paramf;
    }
    
    public final void writeTo(com.google.d.k paramk)
    {
      AppMethodBeat.i(214844);
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.n(1, this.eeZ);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.n(2, this.efa);
      }
      if ((this.bitField0_ & 0x4) != 0) {
        paramk.a(3, this.efb);
      }
      this.unknownFields.writeTo(paramk);
      AppMethodBeat.o(214844);
    }
    
    public static final class a
      extends bg.a<a>
      implements c
    {
      private int bitField0_;
      private long eeZ;
      private long efa;
      private com.google.d.h efb;
      
      private a()
      {
        AppMethodBeat.i(214025);
        this.efb = com.google.d.h.dIJ;
        b.a.amb();
        AppMethodBeat.o(214025);
      }
      
      private a(bg.b paramb)
      {
        super();
        AppMethodBeat.i(214033);
        this.efb = com.google.d.h.dIJ;
        b.a.amb();
        AppMethodBeat.o(214033);
      }
      
      private a A(cb paramcb)
      {
        AppMethodBeat.i(214121);
        if ((paramcb instanceof b.a))
        {
          paramcb = b((b.a)paramcb);
          AppMethodBeat.o(214121);
          return paramcb;
        }
        super.mergeFrom(paramcb);
        AppMethodBeat.o(214121);
        return this;
      }
      
      private a D(am.j paramj)
      {
        AppMethodBeat.i(214092);
        paramj = (a)super.clearOneof(paramj);
        AppMethodBeat.o(214092);
        return paramj;
      }
      
      private a H(am.f paramf)
      {
        AppMethodBeat.i(214083);
        paramf = (a)super.clearField(paramf);
        AppMethodBeat.o(214083);
        return paramf;
      }
      
      private a aa(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214073);
        paramf = (a)super.setField(paramf, paramObject);
        AppMethodBeat.o(214073);
        return paramf;
      }
      
      private a ab(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214112);
        paramf = (a)super.addRepeatedField(paramf, paramObject);
        AppMethodBeat.o(214112);
        return paramf;
      }
      
      private a ac(dn paramdn)
      {
        AppMethodBeat.i(214172);
        paramdn = (a)super.setUnknownFields(paramdn);
        AppMethodBeat.o(214172);
        return paramdn;
      }
      
      private a ad(dn paramdn)
      {
        AppMethodBeat.i(214184);
        paramdn = (a)super.mergeUnknownFields(paramdn);
        AppMethodBeat.o(214184);
        return paramdn;
      }
      
      private a amc()
      {
        AppMethodBeat.i(214043);
        super.clear();
        this.eeZ = 0L;
        this.bitField0_ &= 0xFFFFFFFE;
        this.efa = 0L;
        this.bitField0_ &= 0xFFFFFFFD;
        this.efb = com.google.d.h.dIJ;
        this.bitField0_ &= 0xFFFFFFFB;
        AppMethodBeat.o(214043);
        return this;
      }
      
      private b.a amd()
      {
        AppMethodBeat.i(214054);
        Object localObject = ame();
        if (!((b.a)localObject).isInitialized())
        {
          localObject = newUninitializedMessageException((cb)localObject);
          AppMethodBeat.o(214054);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(214054);
        return localObject;
      }
      
      private b.a ame()
      {
        int j = 0;
        AppMethodBeat.i(214064);
        b.a locala = new b.a(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0)
        {
          b.a.a(locala, this.eeZ);
          j = 1;
        }
        int i = j;
        if ((k & 0x2) != 0)
        {
          b.a.b(locala, this.efa);
          i = j | 0x2;
        }
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        b.a.a(locala, this.efb);
        b.a.a(locala, j);
        onBuilt();
        AppMethodBeat.o(214064);
        return locala;
      }
      
      private a dr(long paramLong)
      {
        AppMethodBeat.i(214140);
        this.bitField0_ |= 0x1;
        this.eeZ = paramLong;
        onChanged();
        AppMethodBeat.o(214140);
        return this;
      }
      
      private a ds(long paramLong)
      {
        AppMethodBeat.i(214148);
        this.bitField0_ |= 0x2;
        this.efa = paramLong;
        onChanged();
        AppMethodBeat.o(214148);
        return this;
      }
      
      private a j(com.google.d.h paramh)
      {
        AppMethodBeat.i(214160);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(214160);
          throw paramh;
        }
        this.bitField0_ |= 0x4;
        this.efb = paramh;
        onChanged();
        AppMethodBeat.o(214160);
        return this;
      }
      
      private a z(am.f paramf, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(214102);
        paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
        AppMethodBeat.o(214102);
        return paramf;
      }
      
      /* Error */
      private a z(com.google.d.i parami, com.google.d.at paramat)
      {
        // Byte code:
        //   0: ldc 171
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 175	com/tencent/ilink/tdi/b$a:PARSER	Lcom/google/d/cs;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 181 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$a
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 60	com/tencent/ilink/tdi/b$a$a:b	(Lcom/tencent/ilink/tdi/b$a;)Lcom/tencent/ilink/tdi/b$a$a;
        //   30: pop
        //   31: ldc 171
        //   33: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 185	com/google/d/bk:dST	Lcom/google/d/ce;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$a
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 189	com/google/d/bk:aii	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 171
        //   54: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 60	com/tencent/ilink/tdi/b$a$a:b	(Lcom/tencent/ilink/tdi/b$a;)Lcom/tencent/ilink/tdi/b$a$a;
        //   69: pop
        //   70: ldc 171
        //   72: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: aload_1
        //   76: athrow
        //   77: astore_1
        //   78: aload_3
        //   79: astore_2
        //   80: goto -20 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	parami	com.google.d.i
        //   0	83	2	paramat	com.google.d.at
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/d/bk
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      public final a b(b.a parama)
      {
        AppMethodBeat.i(214238);
        if (parama == b.a.ama())
        {
          AppMethodBeat.o(214238);
          return this;
        }
        if (parama.alW()) {
          dr(parama.eeZ);
        }
        if (parama.alX()) {
          ds(parama.efa);
        }
        if (parama.alY()) {
          j(parama.efb);
        }
        ad(b.a.a(parama));
        onChanged();
        AppMethodBeat.o(214238);
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        AppMethodBeat.i(214230);
        am.a locala = b.alQ();
        AppMethodBeat.o(214230);
        return locala;
      }
      
      public final bg.e internalGetFieldAccessorTable()
      {
        AppMethodBeat.i(214217);
        bg.e locale = b.alR().b(b.a.class, a.class);
        AppMethodBeat.o(214217);
        return locale;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class b
    extends bg
    implements d
  {
    @Deprecated
    public static final cs<b> PARSER;
    private static final b eff;
    private int bitField0_;
    com.google.d.h efd;
    int efe;
    private byte memoizedIsInitialized = -1;
    
    static
    {
      AppMethodBeat.i(214717);
      eff = new b();
      PARSER = new com.google.d.c() {};
      AppMethodBeat.o(214717);
    }
    
    private b()
    {
      this.efd = com.google.d.h.dIJ;
    }
    
    private b(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private b(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 39	com/tencent/ilink/tdi/b$b:<init>	()V
      //   4: ldc 71
      //   6: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_2
      //   10: ifnonnull +18 -> 28
      //   13: new 73	java/lang/NullPointerException
      //   16: dup
      //   17: invokespecial 74	java/lang/NullPointerException:<init>	()V
      //   20: astore_1
      //   21: ldc 71
      //   23: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: aload_1
      //   27: athrow
      //   28: invokestatic 80	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +160 -> 196
      //   39: aload_1
      //   40: invokevirtual 86	com/google/d/i:aac	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+168->215, 0:+171->218, 10:+51->98, 16:+106->153
      //   81: aload_1
      //   82: aload 5
      //   84: aload_2
      //   85: iload 4
      //   87: invokevirtual 90	com/tencent/ilink/tdi/b$b:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   90: ifne -55 -> 35
      //   93: iconst_1
      //   94: istore_3
      //   95: goto -60 -> 35
      //   98: aload_0
      //   99: aload_0
      //   100: getfield 92	com/tencent/ilink/tdi/b$b:bitField0_	I
      //   103: iconst_1
      //   104: ior
      //   105: putfield 92	com/tencent/ilink/tdi/b$b:bitField0_	I
      //   108: aload_0
      //   109: aload_1
      //   110: invokevirtual 96	com/google/d/i:aak	()Lcom/google/d/h;
      //   113: putfield 58	com/tencent/ilink/tdi/b$b:efd	Lcom/google/d/h;
      //   116: goto -81 -> 35
      //   119: astore_1
      //   120: aload_1
      //   121: aload_0
      //   122: putfield 100	com/google/d/bk:dST	Lcom/google/d/ce;
      //   125: ldc 71
      //   127: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   130: aload_1
      //   131: athrow
      //   132: astore_1
      //   133: aload_0
      //   134: aload 5
      //   136: invokevirtual 106	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   139: putfield 110	com/tencent/ilink/tdi/b$b:unknownFields	Lcom/google/d/dn;
      //   142: aload_0
      //   143: invokevirtual 113	com/tencent/ilink/tdi/b$b:makeExtensionsImmutable	()V
      //   146: ldc 71
      //   148: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   151: aload_1
      //   152: athrow
      //   153: aload_0
      //   154: aload_0
      //   155: getfield 92	com/tencent/ilink/tdi/b$b:bitField0_	I
      //   158: iconst_2
      //   159: ior
      //   160: putfield 92	com/tencent/ilink/tdi/b$b:bitField0_	I
      //   163: aload_0
      //   164: aload_1
      //   165: invokevirtual 116	com/google/d/i:aal	()I
      //   168: putfield 118	com/tencent/ilink/tdi/b$b:efe	I
      //   171: goto -136 -> 35
      //   174: astore_1
      //   175: new 68	com/google/d/bk
      //   178: dup
      //   179: aload_1
      //   180: invokespecial 121	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   183: astore_1
      //   184: aload_1
      //   185: aload_0
      //   186: putfield 100	com/google/d/bk:dST	Lcom/google/d/ce;
      //   189: ldc 71
      //   191: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   194: aload_1
      //   195: athrow
      //   196: aload_0
      //   197: aload 5
      //   199: invokevirtual 106	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   202: putfield 110	com/tencent/ilink/tdi/b$b:unknownFields	Lcom/google/d/dn;
      //   205: aload_0
      //   206: invokevirtual 113	com/tencent/ilink/tdi/b$b:makeExtensionsImmutable	()V
      //   209: ldc 71
      //   211: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   214: return
      //   215: goto -135 -> 80
      //   218: iconst_1
      //   219: istore_3
      //   220: goto -185 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	223	0	this	b
      //   0	223	1	parami	com.google.d.i
      //   0	223	2	paramat	com.google.d.at
      //   34	186	3	i	int
      //   43	43	4	j	int
      //   31	167	5	locala	com.google.d.dn.a
      // Exception table:
      //   from	to	target	type
      //   39	45	119	com/google/d/bk
      //   80	93	119	com/google/d/bk
      //   98	116	119	com/google/d/bk
      //   153	171	119	com/google/d/bk
      //   39	45	132	finally
      //   80	93	132	finally
      //   98	116	132	finally
      //   120	132	132	finally
      //   153	171	132	finally
      //   175	196	132	finally
      //   39	45	174	java/io/IOException
      //   80	93	174	java/io/IOException
      //   98	116	174	java/io/IOException
      //   153	171	174	java/io/IOException
    }
    
    public static b K(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(214643);
      paramArrayOfByte = (b)PARSER.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(214643);
      return paramArrayOfByte;
    }
    
    private a amh()
    {
      AppMethodBeat.i(214653);
      if (this == eff)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(214653);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(214653);
      return locala;
    }
    
    public static b ami()
    {
      return eff;
    }
    
    public final boolean amf()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final boolean amg()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214800);
      if (paramObject == this)
      {
        AppMethodBeat.o(214800);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(214800);
        return bool;
      }
      paramObject = (b)paramObject;
      if (amf() != paramObject.amf())
      {
        AppMethodBeat.o(214800);
        return false;
      }
      if ((amf()) && (!this.efd.equals(paramObject.efd)))
      {
        AppMethodBeat.o(214800);
        return false;
      }
      if (amg() != paramObject.amg())
      {
        AppMethodBeat.o(214800);
        return false;
      }
      if ((amg()) && (this.efe != paramObject.efe))
      {
        AppMethodBeat.o(214800);
        return false;
      }
      if (!this.unknownFields.equals(paramObject.unknownFields))
      {
        AppMethodBeat.o(214800);
        return false;
      }
      AppMethodBeat.o(214800);
      return true;
    }
    
    public final cs<b> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(214790);
      int i = this.memoizedSize;
      if (i != -1)
      {
        AppMethodBeat.o(214790);
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        i = com.google.d.k.c(1, this.efd) + 0;
      }
      int j = i;
      if ((this.bitField0_ & 0x2) != 0) {
        j = i + com.google.d.k.cK(2, this.efe);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      AppMethodBeat.o(214790);
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(214814);
      if (this.memoizedHashCode != 0)
      {
        i = this.memoizedHashCode;
        AppMethodBeat.o(214814);
        return i;
      }
      int j = b.alS().hashCode() + 779;
      int i = j;
      if (amf()) {
        i = (j * 37 + 1) * 53 + this.efd.hashCode();
      }
      j = i;
      if (amg()) {
        j = (i * 37 + 2) * 53 + this.efe;
      }
      i = j * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      AppMethodBeat.o(214814);
      return i;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(214740);
      bg.e locale = b.alT().b(b.class, a.class);
      AppMethodBeat.o(214740);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final Object newInstance(bg.f paramf)
    {
      AppMethodBeat.i(214722);
      paramf = new b();
      AppMethodBeat.o(214722);
      return paramf;
    }
    
    public final void writeTo(com.google.d.k paramk)
    {
      AppMethodBeat.i(214776);
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.a(1, this.efd);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.cG(2, this.efe);
      }
      this.unknownFields.writeTo(paramk);
      AppMethodBeat.o(214776);
    }
    
    public static final class a
      extends bg.a<a>
      implements d
    {
      private int bitField0_;
      private com.google.d.h efd;
      private int efe;
      
      private a()
      {
        AppMethodBeat.i(214694);
        this.efd = com.google.d.h.dIJ;
        b.b.amj();
        AppMethodBeat.o(214694);
      }
      
      private a(bg.b paramb)
      {
        super();
        AppMethodBeat.i(214704);
        this.efd = com.google.d.h.dIJ;
        b.b.amj();
        AppMethodBeat.o(214704);
      }
      
      private a A(am.f paramf, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(214803);
        paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
        AppMethodBeat.o(214803);
        return paramf;
      }
      
      /* Error */
      private a A(com.google.d.i parami, com.google.d.at paramat)
      {
        // Byte code:
        //   0: ldc 63
        //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 67	com/tencent/ilink/tdi/b$b:PARSER	Lcom/google/d/cs;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 73 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$b
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 76	com/tencent/ilink/tdi/b$b$a:b	(Lcom/tencent/ilink/tdi/b$b;)Lcom/tencent/ilink/tdi/b$b$a;
        //   30: pop
        //   31: ldc 63
        //   33: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 80	com/google/d/bk:dST	Lcom/google/d/ce;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$b
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 84	com/google/d/bk:aii	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 63
        //   54: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 76	com/tencent/ilink/tdi/b$b$a:b	(Lcom/tencent/ilink/tdi/b$b;)Lcom/tencent/ilink/tdi/b$b$a;
        //   69: pop
        //   70: ldc 63
        //   72: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: aload_1
        //   76: athrow
        //   77: astore_1
        //   78: aload_3
        //   79: astore_2
        //   80: goto -20 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	parami	com.google.d.i
        //   0	83	2	paramat	com.google.d.at
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/d/bk
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private a B(cb paramcb)
      {
        AppMethodBeat.i(214835);
        if ((paramcb instanceof b.b))
        {
          paramcb = b((b.b)paramcb);
          AppMethodBeat.o(214835);
          return paramcb;
        }
        super.mergeFrom(paramcb);
        AppMethodBeat.o(214835);
        return this;
      }
      
      private a E(am.j paramj)
      {
        AppMethodBeat.i(214786);
        paramj = (a)super.clearOneof(paramj);
        AppMethodBeat.o(214786);
        return paramj;
      }
      
      private a I(am.f paramf)
      {
        AppMethodBeat.i(214772);
        paramf = (a)super.clearField(paramf);
        AppMethodBeat.o(214772);
        return paramf;
      }
      
      private a ac(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214758);
        paramf = (a)super.setField(paramf, paramObject);
        AppMethodBeat.o(214758);
        return paramf;
      }
      
      private a ad(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214817);
        paramf = (a)super.addRepeatedField(paramf, paramObject);
        AppMethodBeat.o(214817);
        return paramf;
      }
      
      private a ae(dn paramdn)
      {
        AppMethodBeat.i(214903);
        paramdn = (a)super.setUnknownFields(paramdn);
        AppMethodBeat.o(214903);
        return paramdn;
      }
      
      private a af(dn paramdn)
      {
        AppMethodBeat.i(214917);
        paramdn = (a)super.mergeUnknownFields(paramdn);
        AppMethodBeat.o(214917);
        return paramdn;
      }
      
      private a amk()
      {
        AppMethodBeat.i(214718);
        super.clear();
        this.efd = com.google.d.h.dIJ;
        this.bitField0_ &= 0xFFFFFFFE;
        this.efe = 0;
        this.bitField0_ &= 0xFFFFFFFD;
        AppMethodBeat.o(214718);
        return this;
      }
      
      private b.b aml()
      {
        AppMethodBeat.i(214730);
        Object localObject = amm();
        if (!((b.b)localObject).isInitialized())
        {
          localObject = newUninitializedMessageException((cb)localObject);
          AppMethodBeat.o(214730);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(214730);
        return localObject;
      }
      
      private b.b amm()
      {
        int i = 0;
        AppMethodBeat.i(214742);
        b.b localb = new b.b(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {
          i = 1;
        }
        b.b.a(localb, this.efd);
        int j = i;
        if ((k & 0x2) != 0)
        {
          b.b.a(localb, this.efe);
          j = i | 0x2;
        }
        b.b.b(localb, j);
        onBuilt();
        AppMethodBeat.o(214742);
        return localb;
      }
      
      private a k(com.google.d.h paramh)
      {
        AppMethodBeat.i(214877);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(214877);
          throw paramh;
        }
        this.bitField0_ |= 0x1;
        this.efd = paramh;
        onChanged();
        AppMethodBeat.o(214877);
        return this;
      }
      
      private a mf(int paramInt)
      {
        AppMethodBeat.i(214894);
        this.bitField0_ |= 0x2;
        this.efe = paramInt;
        onChanged();
        AppMethodBeat.o(214894);
        return this;
      }
      
      public final a b(b.b paramb)
      {
        AppMethodBeat.i(214989);
        if (paramb == b.b.ami())
        {
          AppMethodBeat.o(214989);
          return this;
        }
        if (paramb.amf()) {
          k(paramb.efd);
        }
        if (paramb.amg()) {
          mf(paramb.efe);
        }
        af(b.b.a(paramb));
        onChanged();
        AppMethodBeat.o(214989);
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        AppMethodBeat.i(214974);
        am.a locala = b.alS();
        AppMethodBeat.o(214974);
        return locala;
      }
      
      public final bg.e internalGetFieldAccessorTable()
      {
        AppMethodBeat.i(214964);
        bg.e locale = b.alT().b(b.b.class, a.class);
        AppMethodBeat.o(214964);
        return locale;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class c
    extends bg
    implements e
  {
    @Deprecated
    public static final cs<c> PARSER;
    private static final c efg;
    private int bitField0_;
    com.google.d.h efb;
    private byte memoizedIsInitialized = -1;
    
    static
    {
      AppMethodBeat.i(214721);
      efg = new c();
      PARSER = new com.google.d.c() {};
      AppMethodBeat.o(214721);
    }
    
    private c()
    {
      this.efb = com.google.d.h.dIJ;
    }
    
    private c(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private c(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 38	com/tencent/ilink/tdi/b$c:<init>	()V
      //   4: ldc 70
      //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_2
      //   10: ifnonnull +18 -> 28
      //   13: new 72	java/lang/NullPointerException
      //   16: dup
      //   17: invokespecial 73	java/lang/NullPointerException:<init>	()V
      //   20: astore_1
      //   21: ldc 70
      //   23: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: aload_1
      //   27: athrow
      //   28: invokestatic 79	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +109 -> 145
      //   39: aload_1
      //   40: invokevirtual 85	com/google/d/i:aac	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+139->186, 0:+142->189, 10:+43->90
      //   73: aload_1
      //   74: aload 5
      //   76: aload_2
      //   77: iload 4
      //   79: invokevirtual 89	com/tencent/ilink/tdi/b$c:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   82: ifne -47 -> 35
      //   85: iconst_1
      //   86: istore_3
      //   87: goto -52 -> 35
      //   90: aload_0
      //   91: aload_0
      //   92: getfield 91	com/tencent/ilink/tdi/b$c:bitField0_	I
      //   95: iconst_1
      //   96: ior
      //   97: putfield 91	com/tencent/ilink/tdi/b$c:bitField0_	I
      //   100: aload_0
      //   101: aload_1
      //   102: invokevirtual 95	com/google/d/i:aak	()Lcom/google/d/h;
      //   105: putfield 57	com/tencent/ilink/tdi/b$c:efb	Lcom/google/d/h;
      //   108: goto -73 -> 35
      //   111: astore_1
      //   112: aload_1
      //   113: aload_0
      //   114: putfield 99	com/google/d/bk:dST	Lcom/google/d/ce;
      //   117: ldc 70
      //   119: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   122: aload_1
      //   123: athrow
      //   124: astore_1
      //   125: aload_0
      //   126: aload 5
      //   128: invokevirtual 105	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   131: putfield 109	com/tencent/ilink/tdi/b$c:unknownFields	Lcom/google/d/dn;
      //   134: aload_0
      //   135: invokevirtual 112	com/tencent/ilink/tdi/b$c:makeExtensionsImmutable	()V
      //   138: ldc 70
      //   140: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   143: aload_1
      //   144: athrow
      //   145: aload_0
      //   146: aload 5
      //   148: invokevirtual 105	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   151: putfield 109	com/tencent/ilink/tdi/b$c:unknownFields	Lcom/google/d/dn;
      //   154: aload_0
      //   155: invokevirtual 112	com/tencent/ilink/tdi/b$c:makeExtensionsImmutable	()V
      //   158: ldc 70
      //   160: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   163: return
      //   164: astore_1
      //   165: new 67	com/google/d/bk
      //   168: dup
      //   169: aload_1
      //   170: invokespecial 115	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   173: astore_1
      //   174: aload_1
      //   175: aload_0
      //   176: putfield 99	com/google/d/bk:dST	Lcom/google/d/ce;
      //   179: ldc 70
      //   181: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   184: aload_1
      //   185: athrow
      //   186: goto -114 -> 72
      //   189: iconst_1
      //   190: istore_3
      //   191: goto -156 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	194	0	this	c
      //   0	194	1	parami	com.google.d.i
      //   0	194	2	paramat	com.google.d.at
      //   34	157	3	i	int
      //   43	35	4	j	int
      //   31	116	5	locala	com.google.d.dn.a
      // Exception table:
      //   from	to	target	type
      //   39	45	111	com/google/d/bk
      //   72	85	111	com/google/d/bk
      //   90	108	111	com/google/d/bk
      //   39	45	124	finally
      //   72	85	124	finally
      //   90	108	124	finally
      //   112	124	124	finally
      //   165	186	124	finally
      //   39	45	164	java/io/IOException
      //   72	85	164	java/io/IOException
      //   90	108	164	java/io/IOException
    }
    
    public static c L(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(214649);
      paramArrayOfByte = (c)PARSER.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(214649);
      return paramArrayOfByte;
    }
    
    private a amn()
    {
      AppMethodBeat.i(214661);
      if (this == efg)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(214661);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(214661);
      return locala;
    }
    
    public static c amo()
    {
      return efg;
    }
    
    public final boolean alY()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214802);
      if (paramObject == this)
      {
        AppMethodBeat.o(214802);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(214802);
        return bool;
      }
      paramObject = (c)paramObject;
      if (alY() != paramObject.alY())
      {
        AppMethodBeat.o(214802);
        return false;
      }
      if ((alY()) && (!this.efb.equals(paramObject.efb)))
      {
        AppMethodBeat.o(214802);
        return false;
      }
      if (!this.unknownFields.equals(paramObject.unknownFields))
      {
        AppMethodBeat.o(214802);
        return false;
      }
      AppMethodBeat.o(214802);
      return true;
    }
    
    public final cs<c> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(214789);
      int i = this.memoizedSize;
      if (i != -1)
      {
        AppMethodBeat.o(214789);
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        i = com.google.d.k.c(1, this.efb) + 0;
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      AppMethodBeat.o(214789);
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(214813);
      if (this.memoizedHashCode != 0)
      {
        i = this.memoizedHashCode;
        AppMethodBeat.o(214813);
        return i;
      }
      int j = b.alO().hashCode() + 779;
      int i = j;
      if (alY()) {
        i = (j * 37 + 1) * 53 + this.efb.hashCode();
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      AppMethodBeat.o(214813);
      return i;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(214747);
      bg.e locale = b.alP().b(c.class, a.class);
      AppMethodBeat.o(214747);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final Object newInstance(bg.f paramf)
    {
      AppMethodBeat.i(214731);
      paramf = new c();
      AppMethodBeat.o(214731);
      return paramf;
    }
    
    public final void writeTo(com.google.d.k paramk)
    {
      AppMethodBeat.i(214775);
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.a(1, this.efb);
      }
      this.unknownFields.writeTo(paramk);
      AppMethodBeat.o(214775);
    }
    
    public static final class a
      extends bg.a<a>
      implements e
    {
      private int bitField0_;
      private com.google.d.h efb;
      
      private a()
      {
        AppMethodBeat.i(214042);
        this.efb = com.google.d.h.dIJ;
        b.c.amp();
        AppMethodBeat.o(214042);
      }
      
      private a(bg.b paramb)
      {
        super();
        AppMethodBeat.i(214053);
        this.efb = com.google.d.h.dIJ;
        b.c.amp();
        AppMethodBeat.o(214053);
      }
      
      private a B(am.f paramf, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(214128);
        paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
        AppMethodBeat.o(214128);
        return paramf;
      }
      
      /* Error */
      private a B(com.google.d.i parami, com.google.d.at paramat)
      {
        // Byte code:
        //   0: ldc 62
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 66	com/tencent/ilink/tdi/b$c:PARSER	Lcom/google/d/cs;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 72 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$c
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 76	com/tencent/ilink/tdi/b$c$a:b	(Lcom/tencent/ilink/tdi/b$c;)Lcom/tencent/ilink/tdi/b$c$a;
        //   30: pop
        //   31: ldc 62
        //   33: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 80	com/google/d/bk:dST	Lcom/google/d/ce;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$c
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 84	com/google/d/bk:aii	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 62
        //   54: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 76	com/tencent/ilink/tdi/b$c$a:b	(Lcom/tencent/ilink/tdi/b$c;)Lcom/tencent/ilink/tdi/b$c$a;
        //   69: pop
        //   70: ldc 62
        //   72: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: aload_1
        //   76: athrow
        //   77: astore_1
        //   78: aload_3
        //   79: astore_2
        //   80: goto -20 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	parami	com.google.d.i
        //   0	83	2	paramat	com.google.d.at
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/d/bk
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private a C(cb paramcb)
      {
        AppMethodBeat.i(214147);
        if ((paramcb instanceof b.c))
        {
          paramcb = b((b.c)paramcb);
          AppMethodBeat.o(214147);
          return paramcb;
        }
        super.mergeFrom(paramcb);
        AppMethodBeat.o(214147);
        return this;
      }
      
      private a F(am.j paramj)
      {
        AppMethodBeat.i(214117);
        paramj = (a)super.clearOneof(paramj);
        AppMethodBeat.o(214117);
        return paramj;
      }
      
      private a J(am.f paramf)
      {
        AppMethodBeat.i(214107);
        paramf = (a)super.clearField(paramf);
        AppMethodBeat.o(214107);
        return paramf;
      }
      
      private a ae(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214095);
        paramf = (a)super.setField(paramf, paramObject);
        AppMethodBeat.o(214095);
        return paramf;
      }
      
      private a af(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214136);
        paramf = (a)super.addRepeatedField(paramf, paramObject);
        AppMethodBeat.o(214136);
        return paramf;
      }
      
      private a ag(dn paramdn)
      {
        AppMethodBeat.i(214186);
        paramdn = (a)super.setUnknownFields(paramdn);
        AppMethodBeat.o(214186);
        return paramdn;
      }
      
      private a ah(dn paramdn)
      {
        AppMethodBeat.i(214199);
        paramdn = (a)super.mergeUnknownFields(paramdn);
        AppMethodBeat.o(214199);
        return paramdn;
      }
      
      private a amq()
      {
        AppMethodBeat.i(214067);
        super.clear();
        this.efb = com.google.d.h.dIJ;
        this.bitField0_ &= 0xFFFFFFFE;
        AppMethodBeat.o(214067);
        return this;
      }
      
      private b.c amr()
      {
        AppMethodBeat.i(214075);
        Object localObject = ams();
        if (!((b.c)localObject).isInitialized())
        {
          localObject = newUninitializedMessageException((cb)localObject);
          AppMethodBeat.o(214075);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(214075);
        return localObject;
      }
      
      private b.c ams()
      {
        int i = 0;
        AppMethodBeat.i(214086);
        b.c localc = new b.c(this, (byte)0);
        if ((this.bitField0_ & 0x1) != 0) {
          i = 1;
        }
        b.c.a(localc, this.efb);
        b.c.a(localc, i);
        onBuilt();
        AppMethodBeat.o(214086);
        return localc;
      }
      
      private a l(com.google.d.h paramh)
      {
        AppMethodBeat.i(214173);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(214173);
          throw paramh;
        }
        this.bitField0_ |= 0x1;
        this.efb = paramh;
        onChanged();
        AppMethodBeat.o(214173);
        return this;
      }
      
      public final a b(b.c paramc)
      {
        AppMethodBeat.i(214254);
        if (paramc == b.c.amo())
        {
          AppMethodBeat.o(214254);
          return this;
        }
        if (paramc.alY()) {
          l(paramc.efb);
        }
        ah(b.c.a(paramc));
        onChanged();
        AppMethodBeat.o(214254);
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        AppMethodBeat.i(214245);
        am.a locala = b.alO();
        AppMethodBeat.o(214245);
        return locala;
      }
      
      public final bg.e internalGetFieldAccessorTable()
      {
        AppMethodBeat.i(214235);
        bg.e locale = b.alP().b(b.c.class, a.class);
        AppMethodBeat.o(214235);
        return locale;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class d
    extends bg
    implements f
  {
    @Deprecated
    public static final cs<d> PARSER;
    private static final d efl;
    private int bitField0_;
    private int efh;
    private volatile Object efi;
    private volatile Object efj;
    com.google.d.h efk;
    private byte memoizedIsInitialized = -1;
    long uin_;
    
    static
    {
      AppMethodBeat.i(214753);
      efl = new d();
      PARSER = new com.google.d.c() {};
      AppMethodBeat.o(214753);
    }
    
    private d()
    {
      this.efh = 0;
      this.efi = "";
      this.efj = "";
      this.efk = com.google.d.h.dIJ;
    }
    
    private d(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private d(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 44	com/tencent/ilink/tdi/b$d:<init>	()V
      //   4: ldc 84
      //   6: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_2
      //   10: ifnonnull +18 -> 28
      //   13: new 86	java/lang/NullPointerException
      //   16: dup
      //   17: invokespecial 87	java/lang/NullPointerException:<init>	()V
      //   20: astore_1
      //   21: ldc 84
      //   23: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: aload_1
      //   27: athrow
      //   28: invokestatic 93	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +281 -> 317
      //   39: aload_1
      //   40: invokevirtual 99	com/google/d/i:aac	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+289->336, 0:+292->339, 8:+75->122, 16:+176->223, 26:+197->244, 34:+222->269, 42:+248->295
      //   105: aload_1
      //   106: aload 5
      //   108: aload_2
      //   109: iload 4
      //   111: invokevirtual 103	com/tencent/ilink/tdi/b$d:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   114: ifne -79 -> 35
      //   117: iconst_1
      //   118: istore_3
      //   119: goto -84 -> 35
      //   122: aload_1
      //   123: invokevirtual 106	com/google/d/i:aam	()I
      //   126: istore 4
      //   128: iload 4
      //   130: invokestatic 112	com/tencent/ilink/tdi/a$c:me	(I)Lcom/tencent/ilink/tdi/a$c;
      //   133: ifnonnull +49 -> 182
      //   136: aload 5
      //   138: iconst_1
      //   139: iload 4
      //   141: invokevirtual 118	com/google/d/dn$a:cR	(II)Lcom/google/d/dn$a;
      //   144: pop
      //   145: goto -110 -> 35
      //   148: astore_1
      //   149: aload_1
      //   150: aload_0
      //   151: putfield 122	com/google/d/bk:dST	Lcom/google/d/ce;
      //   154: ldc 84
      //   156: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   159: aload_1
      //   160: athrow
      //   161: astore_1
      //   162: aload_0
      //   163: aload 5
      //   165: invokevirtual 126	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   168: putfield 130	com/tencent/ilink/tdi/b$d:unknownFields	Lcom/google/d/dn;
      //   171: aload_0
      //   172: invokevirtual 133	com/tencent/ilink/tdi/b$d:makeExtensionsImmutable	()V
      //   175: ldc 84
      //   177: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   180: aload_1
      //   181: athrow
      //   182: aload_0
      //   183: aload_0
      //   184: getfield 135	com/tencent/ilink/tdi/b$d:bitField0_	I
      //   187: iconst_1
      //   188: ior
      //   189: putfield 135	com/tencent/ilink/tdi/b$d:bitField0_	I
      //   192: aload_0
      //   193: iload 4
      //   195: putfield 58	com/tencent/ilink/tdi/b$d:efh	I
      //   198: goto -163 -> 35
      //   201: astore_1
      //   202: new 81	com/google/d/bk
      //   205: dup
      //   206: aload_1
      //   207: invokespecial 138	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   210: astore_1
      //   211: aload_1
      //   212: aload_0
      //   213: putfield 122	com/google/d/bk:dST	Lcom/google/d/ce;
      //   216: ldc 84
      //   218: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   221: aload_1
      //   222: athrow
      //   223: aload_0
      //   224: aload_0
      //   225: getfield 135	com/tencent/ilink/tdi/b$d:bitField0_	I
      //   228: iconst_2
      //   229: ior
      //   230: putfield 135	com/tencent/ilink/tdi/b$d:bitField0_	I
      //   233: aload_0
      //   234: aload_1
      //   235: invokevirtual 142	com/google/d/i:aad	()J
      //   238: putfield 144	com/tencent/ilink/tdi/b$d:uin_	J
      //   241: goto -206 -> 35
      //   244: aload_1
      //   245: invokevirtual 148	com/google/d/i:aak	()Lcom/google/d/h;
      //   248: astore 6
      //   250: aload_0
      //   251: aload_0
      //   252: getfield 135	com/tencent/ilink/tdi/b$d:bitField0_	I
      //   255: iconst_4
      //   256: ior
      //   257: putfield 135	com/tencent/ilink/tdi/b$d:bitField0_	I
      //   260: aload_0
      //   261: aload 6
      //   263: putfield 62	com/tencent/ilink/tdi/b$d:efi	Ljava/lang/Object;
      //   266: goto -231 -> 35
      //   269: aload_1
      //   270: invokevirtual 148	com/google/d/i:aak	()Lcom/google/d/h;
      //   273: astore 6
      //   275: aload_0
      //   276: aload_0
      //   277: getfield 135	com/tencent/ilink/tdi/b$d:bitField0_	I
      //   280: bipush 8
      //   282: ior
      //   283: putfield 135	com/tencent/ilink/tdi/b$d:bitField0_	I
      //   286: aload_0
      //   287: aload 6
      //   289: putfield 64	com/tencent/ilink/tdi/b$d:efj	Ljava/lang/Object;
      //   292: goto -257 -> 35
      //   295: aload_0
      //   296: aload_0
      //   297: getfield 135	com/tencent/ilink/tdi/b$d:bitField0_	I
      //   300: bipush 16
      //   302: ior
      //   303: putfield 135	com/tencent/ilink/tdi/b$d:bitField0_	I
      //   306: aload_0
      //   307: aload_1
      //   308: invokevirtual 148	com/google/d/i:aak	()Lcom/google/d/h;
      //   311: putfield 71	com/tencent/ilink/tdi/b$d:efk	Lcom/google/d/h;
      //   314: goto -279 -> 35
      //   317: aload_0
      //   318: aload 5
      //   320: invokevirtual 126	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   323: putfield 130	com/tencent/ilink/tdi/b$d:unknownFields	Lcom/google/d/dn;
      //   326: aload_0
      //   327: invokevirtual 133	com/tencent/ilink/tdi/b$d:makeExtensionsImmutable	()V
      //   330: ldc 84
      //   332: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   335: return
      //   336: goto -232 -> 104
      //   339: iconst_1
      //   340: istore_3
      //   341: goto -306 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	344	0	this	d
      //   0	344	1	parami	com.google.d.i
      //   0	344	2	paramat	com.google.d.at
      //   34	307	3	i	int
      //   43	151	4	j	int
      //   31	288	5	locala	com.google.d.dn.a
      //   248	40	6	localh	com.google.d.h
      // Exception table:
      //   from	to	target	type
      //   39	45	148	com/google/d/bk
      //   104	117	148	com/google/d/bk
      //   122	145	148	com/google/d/bk
      //   182	198	148	com/google/d/bk
      //   223	241	148	com/google/d/bk
      //   244	266	148	com/google/d/bk
      //   269	292	148	com/google/d/bk
      //   295	314	148	com/google/d/bk
      //   39	45	161	finally
      //   104	117	161	finally
      //   122	145	161	finally
      //   149	161	161	finally
      //   182	198	161	finally
      //   202	223	161	finally
      //   223	241	161	finally
      //   244	266	161	finally
      //   269	292	161	finally
      //   295	314	161	finally
      //   39	45	201	java/io/IOException
      //   104	117	201	java/io/IOException
      //   122	145	201	java/io/IOException
      //   182	198	201	java/io/IOException
      //   223	241	201	java/io/IOException
      //   244	266	201	java/io/IOException
      //   269	292	201	java/io/IOException
      //   295	314	201	java/io/IOException
    }
    
    public static d M(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(214639);
      paramArrayOfByte = (d)PARSER.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(214639);
      return paramArrayOfByte;
    }
    
    public static d amA()
    {
      return efl;
    }
    
    private String amx()
    {
      AppMethodBeat.i(214625);
      Object localObject = this.efj;
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(214625);
        return localObject;
      }
      localObject = (com.google.d.h)localObject;
      String str = ((com.google.d.h)localObject).ZV();
      if (((com.google.d.h)localObject).ZW()) {
        this.efj = str;
      }
      AppMethodBeat.o(214625);
      return str;
    }
    
    private a amz()
    {
      AppMethodBeat.i(214646);
      if (this == efl)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(214646);
        return locala;
      }
      a locala = new a((byte)0).d(this);
      AppMethodBeat.o(214646);
      return locala;
    }
    
    private String getNickname()
    {
      AppMethodBeat.i(214611);
      Object localObject = this.efi;
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(214611);
        return localObject;
      }
      localObject = (com.google.d.h)localObject;
      String str = ((com.google.d.h)localObject).ZV();
      if (((com.google.d.h)localObject).ZW()) {
        this.efi = str;
      }
      AppMethodBeat.o(214611);
      return str;
    }
    
    public final boolean amt()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final a.c amu()
    {
      AppMethodBeat.i(214801);
      a.c localc = a.c.me(this.efh);
      if (localc == null)
      {
        localc = a.c.edY;
        AppMethodBeat.o(214801);
        return localc;
      }
      AppMethodBeat.o(214801);
      return localc;
    }
    
    public final boolean amv()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    public final boolean amw()
    {
      return (this.bitField0_ & 0x8) != 0;
    }
    
    public final boolean amy()
    {
      return (this.bitField0_ & 0x10) != 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214892);
      if (paramObject == this)
      {
        AppMethodBeat.o(214892);
        return true;
      }
      if (!(paramObject instanceof d))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(214892);
        return bool;
      }
      paramObject = (d)paramObject;
      if (amt() != paramObject.amt())
      {
        AppMethodBeat.o(214892);
        return false;
      }
      if ((amt()) && (this.efh != paramObject.efh))
      {
        AppMethodBeat.o(214892);
        return false;
      }
      if (hasUin() != paramObject.hasUin())
      {
        AppMethodBeat.o(214892);
        return false;
      }
      if ((hasUin()) && (this.uin_ != paramObject.uin_))
      {
        AppMethodBeat.o(214892);
        return false;
      }
      if (amv() != paramObject.amv())
      {
        AppMethodBeat.o(214892);
        return false;
      }
      if ((amv()) && (!getNickname().equals(paramObject.getNickname())))
      {
        AppMethodBeat.o(214892);
        return false;
      }
      if (amw() != paramObject.amw())
      {
        AppMethodBeat.o(214892);
        return false;
      }
      if ((amw()) && (!amx().equals(paramObject.amx())))
      {
        AppMethodBeat.o(214892);
        return false;
      }
      if (amy() != paramObject.amy())
      {
        AppMethodBeat.o(214892);
        return false;
      }
      if ((amy()) && (!this.efk.equals(paramObject.efk)))
      {
        AppMethodBeat.o(214892);
        return false;
      }
      if (!this.unknownFields.equals(paramObject.unknownFields))
      {
        AppMethodBeat.o(214892);
        return false;
      }
      AppMethodBeat.o(214892);
      return true;
    }
    
    public final cs<d> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(214876);
      int i = this.memoizedSize;
      if (i != -1)
      {
        AppMethodBeat.o(214876);
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        j = com.google.d.k.cM(1, this.efh) + 0;
      }
      i = j;
      if ((this.bitField0_ & 0x2) != 0) {
        i = j + com.google.d.k.r(2, this.uin_);
      }
      j = i;
      if ((this.bitField0_ & 0x4) != 0) {
        j = i + bg.computeStringSize(3, this.efi);
      }
      i = j;
      if ((this.bitField0_ & 0x8) != 0) {
        i = j + bg.computeStringSize(4, this.efj);
      }
      j = i;
      if ((this.bitField0_ & 0x10) != 0) {
        j = i + com.google.d.k.c(5, this.efk);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      AppMethodBeat.o(214876);
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final boolean hasUin()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(214901);
      if (this.memoizedHashCode != 0)
      {
        i = this.memoizedHashCode;
        AppMethodBeat.o(214901);
        return i;
      }
      int j = b.alM().hashCode() + 779;
      int i = j;
      if (amt()) {
        i = (j * 37 + 1) * 53 + this.efh;
      }
      j = i;
      if (hasUin()) {
        j = (i * 37 + 2) * 53 + bj.hashLong(this.uin_);
      }
      i = j;
      if (amv()) {
        i = (j * 37 + 3) * 53 + getNickname().hashCode();
      }
      j = i;
      if (amw()) {
        j = (i * 37 + 4) * 53 + amx().hashCode();
      }
      i = j;
      if (amy()) {
        i = (j * 37 + 5) * 53 + this.efk.hashCode();
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      AppMethodBeat.o(214901);
      return i;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(214781);
      bg.e locale = b.alN().b(d.class, a.class);
      AppMethodBeat.o(214781);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final Object newInstance(bg.f paramf)
    {
      AppMethodBeat.i(214760);
      paramf = new d();
      AppMethodBeat.o(214760);
      return paramf;
    }
    
    public final void writeTo(com.google.d.k paramk)
    {
      AppMethodBeat.i(214859);
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.cF(1, this.efh);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.n(2, this.uin_);
      }
      if ((this.bitField0_ & 0x4) != 0) {
        bg.writeString(paramk, 3, this.efi);
      }
      if ((this.bitField0_ & 0x8) != 0) {
        bg.writeString(paramk, 4, this.efj);
      }
      if ((this.bitField0_ & 0x10) != 0) {
        paramk.a(5, this.efk);
      }
      this.unknownFields.writeTo(paramk);
      AppMethodBeat.o(214859);
    }
    
    public static final class a
      extends bg.a<a>
      implements f
    {
      private int bitField0_;
      private int efh;
      private Object efi;
      private Object efj;
      private com.google.d.h efk;
      private long uin_;
      
      private a()
      {
        AppMethodBeat.i(214686);
        this.efh = 0;
        this.efi = "";
        this.efj = "";
        this.efk = com.google.d.h.dIJ;
        b.d.amB();
        AppMethodBeat.o(214686);
      }
      
      private a(bg.b paramb)
      {
        super();
        AppMethodBeat.i(214695);
        this.efh = 0;
        this.efi = "";
        this.efj = "";
        this.efk = com.google.d.h.dIJ;
        b.d.amB();
        AppMethodBeat.o(214695);
      }
      
      private a C(am.f paramf, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(214750);
        paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
        AppMethodBeat.o(214750);
        return paramf;
      }
      
      /* Error */
      private a C(com.google.d.i parami, com.google.d.at paramat)
      {
        // Byte code:
        //   0: ldc 76
        //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 80	com/tencent/ilink/tdi/b$d:PARSER	Lcom/google/d/cs;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 86 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$d
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 89	com/tencent/ilink/tdi/b$d$a:d	(Lcom/tencent/ilink/tdi/b$d;)Lcom/tencent/ilink/tdi/b$d$a;
        //   30: pop
        //   31: ldc 76
        //   33: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 93	com/google/d/bk:dST	Lcom/google/d/ce;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$d
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 97	com/google/d/bk:aii	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 76
        //   54: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 89	com/tencent/ilink/tdi/b$d$a:d	(Lcom/tencent/ilink/tdi/b$d;)Lcom/tencent/ilink/tdi/b$d$a;
        //   69: pop
        //   70: ldc 76
        //   72: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: aload_1
        //   76: athrow
        //   77: astore_1
        //   78: aload_3
        //   79: astore_2
        //   80: goto -20 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	parami	com.google.d.i
        //   0	83	2	paramat	com.google.d.at
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/d/bk
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private a D(cb paramcb)
      {
        AppMethodBeat.i(214773);
        if ((paramcb instanceof b.d))
        {
          paramcb = d((b.d)paramcb);
          AppMethodBeat.o(214773);
          return paramcb;
        }
        super.mergeFrom(paramcb);
        AppMethodBeat.o(214773);
        return this;
      }
      
      private a G(am.j paramj)
      {
        AppMethodBeat.i(214745);
        paramj = (a)super.clearOneof(paramj);
        AppMethodBeat.o(214745);
        return paramj;
      }
      
      private a K(am.f paramf)
      {
        AppMethodBeat.i(214734);
        paramf = (a)super.clearField(paramf);
        AppMethodBeat.o(214734);
        return paramf;
      }
      
      private a a(a.c paramc)
      {
        AppMethodBeat.i(214795);
        if (paramc == null)
        {
          paramc = new NullPointerException();
          AppMethodBeat.o(214795);
          throw paramc;
        }
        this.bitField0_ |= 0x1;
        this.efh = paramc.value;
        onChanged();
        AppMethodBeat.o(214795);
        return this;
      }
      
      private a ag(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214726);
        paramf = (a)super.setField(paramf, paramObject);
        AppMethodBeat.o(214726);
        return paramf;
      }
      
      private a ah(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214761);
        paramf = (a)super.addRepeatedField(paramf, paramObject);
        AppMethodBeat.o(214761);
        return paramf;
      }
      
      private a ai(dn paramdn)
      {
        AppMethodBeat.i(214827);
        paramdn = (a)super.setUnknownFields(paramdn);
        AppMethodBeat.o(214827);
        return paramdn;
      }
      
      private a aj(dn paramdn)
      {
        AppMethodBeat.i(214840);
        paramdn = (a)super.mergeUnknownFields(paramdn);
        AppMethodBeat.o(214840);
        return paramdn;
      }
      
      private a amC()
      {
        AppMethodBeat.i(214702);
        super.clear();
        this.efh = 0;
        this.bitField0_ &= 0xFFFFFFFE;
        this.uin_ = 0L;
        this.bitField0_ &= 0xFFFFFFFD;
        this.efi = "";
        this.bitField0_ &= 0xFFFFFFFB;
        this.efj = "";
        this.bitField0_ &= 0xFFFFFFF7;
        this.efk = com.google.d.h.dIJ;
        this.bitField0_ &= 0xFFFFFFEF;
        AppMethodBeat.o(214702);
        return this;
      }
      
      private b.d amD()
      {
        AppMethodBeat.i(214711);
        Object localObject = amE();
        if (!((b.d)localObject).isInitialized())
        {
          localObject = newUninitializedMessageException((cb)localObject);
          AppMethodBeat.o(214711);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(214711);
        return localObject;
      }
      
      private b.d amE()
      {
        int j = 0;
        AppMethodBeat.i(214720);
        b.d locald = new b.d(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        b.d.a(locald, this.efh);
        int i = j;
        if ((k & 0x2) != 0)
        {
          b.d.a(locald, this.uin_);
          i = j | 0x2;
        }
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        b.d.a(locald, this.efi);
        i = j;
        if ((k & 0x8) != 0) {
          i = j | 0x8;
        }
        b.d.b(locald, this.efj);
        j = i;
        if ((k & 0x10) != 0) {
          j = i | 0x10;
        }
        b.d.a(locald, this.efk);
        b.d.b(locald, j);
        onBuilt();
        AppMethodBeat.o(214720);
        return locald;
      }
      
      private a dt(long paramLong)
      {
        AppMethodBeat.i(214807);
        this.bitField0_ |= 0x2;
        this.uin_ = paramLong;
        onChanged();
        AppMethodBeat.o(214807);
        return this;
      }
      
      private a m(com.google.d.h paramh)
      {
        AppMethodBeat.i(214818);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(214818);
          throw paramh;
        }
        this.bitField0_ |= 0x10;
        this.efk = paramh;
        onChanged();
        AppMethodBeat.o(214818);
        return this;
      }
      
      public final a d(b.d paramd)
      {
        AppMethodBeat.i(214895);
        if (paramd == b.d.amA())
        {
          AppMethodBeat.o(214895);
          return this;
        }
        if (paramd.amt()) {
          a(paramd.amu());
        }
        if (paramd.hasUin()) {
          dt(paramd.uin_);
        }
        if (paramd.amv())
        {
          this.bitField0_ |= 0x4;
          this.efi = b.d.a(paramd);
          onChanged();
        }
        if (paramd.amw())
        {
          this.bitField0_ |= 0x8;
          this.efj = b.d.b(paramd);
          onChanged();
        }
        if (paramd.amy()) {
          m(paramd.efk);
        }
        aj(b.d.c(paramd));
        onChanged();
        AppMethodBeat.o(214895);
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        AppMethodBeat.i(214880);
        am.a locala = b.alM();
        AppMethodBeat.o(214880);
        return locala;
      }
      
      public final bg.e internalGetFieldAccessorTable()
      {
        AppMethodBeat.i(214866);
        bg.e locale = b.alN().b(b.d.class, a.class);
        AppMethodBeat.o(214866);
        return locale;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class e
    extends bg
    implements g
  {
    @Deprecated
    public static final cs<e> PARSER;
    private static final e efo;
    private int bitField0_;
    private int efm;
    com.google.d.h efn;
    private byte memoizedIsInitialized = -1;
    private int type_;
    
    static
    {
      AppMethodBeat.i(214401);
      efo = new e();
      PARSER = new com.google.d.c() {};
      AppMethodBeat.o(214401);
    }
    
    private e()
    {
      this.type_ = 1;
      this.efm = 0;
      this.efn = com.google.d.h.dIJ;
    }
    
    private e(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private e(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 40	com/tencent/ilink/tdi/b$e:<init>	()V
      //   4: ldc 76
      //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_2
      //   10: ifnonnull +18 -> 28
      //   13: new 78	java/lang/NullPointerException
      //   16: dup
      //   17: invokespecial 79	java/lang/NullPointerException:<init>	()V
      //   20: astore_1
      //   21: ldc 76
      //   23: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: aload_1
      //   27: athrow
      //   28: invokestatic 85	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +237 -> 273
      //   39: aload_1
      //   40: invokevirtual 91	com/google/d/i:aac	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+245->292, 0:+248->295, 8:+59->106, 16:+160->207, 26:+205->252
      //   89: aload_1
      //   90: aload 5
      //   92: aload_2
      //   93: iload 4
      //   95: invokevirtual 95	com/tencent/ilink/tdi/b$e:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   98: ifne -63 -> 35
      //   101: iconst_1
      //   102: istore_3
      //   103: goto -68 -> 35
      //   106: aload_1
      //   107: invokevirtual 98	com/google/d/i:aam	()I
      //   110: istore 4
      //   112: iload 4
      //   114: invokestatic 104	com/tencent/ilink/tdi/a$a:mc	(I)Lcom/tencent/ilink/tdi/a$a;
      //   117: ifnonnull +49 -> 166
      //   120: aload 5
      //   122: iconst_1
      //   123: iload 4
      //   125: invokevirtual 110	com/google/d/dn$a:cR	(II)Lcom/google/d/dn$a;
      //   128: pop
      //   129: goto -94 -> 35
      //   132: astore_1
      //   133: aload_1
      //   134: aload_0
      //   135: putfield 114	com/google/d/bk:dST	Lcom/google/d/ce;
      //   138: ldc 76
      //   140: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   143: aload_1
      //   144: athrow
      //   145: astore_1
      //   146: aload_0
      //   147: aload 5
      //   149: invokevirtual 118	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   152: putfield 122	com/tencent/ilink/tdi/b$e:unknownFields	Lcom/google/d/dn;
      //   155: aload_0
      //   156: invokevirtual 125	com/tencent/ilink/tdi/b$e:makeExtensionsImmutable	()V
      //   159: ldc 76
      //   161: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   164: aload_1
      //   165: athrow
      //   166: aload_0
      //   167: aload_0
      //   168: getfield 127	com/tencent/ilink/tdi/b$e:bitField0_	I
      //   171: iconst_1
      //   172: ior
      //   173: putfield 127	com/tencent/ilink/tdi/b$e:bitField0_	I
      //   176: aload_0
      //   177: iload 4
      //   179: putfield 54	com/tencent/ilink/tdi/b$e:type_	I
      //   182: goto -147 -> 35
      //   185: astore_1
      //   186: new 73	com/google/d/bk
      //   189: dup
      //   190: aload_1
      //   191: invokespecial 130	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   194: astore_1
      //   195: aload_1
      //   196: aload_0
      //   197: putfield 114	com/google/d/bk:dST	Lcom/google/d/ce;
      //   200: ldc 76
      //   202: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   205: aload_1
      //   206: athrow
      //   207: aload_1
      //   208: invokevirtual 98	com/google/d/i:aam	()I
      //   211: istore 4
      //   213: iload 4
      //   215: invokestatic 136	com/tencent/ilink/tdi/a$b:md	(I)Lcom/tencent/ilink/tdi/a$b;
      //   218: ifnonnull +15 -> 233
      //   221: aload 5
      //   223: iconst_2
      //   224: iload 4
      //   226: invokevirtual 110	com/google/d/dn$a:cR	(II)Lcom/google/d/dn$a;
      //   229: pop
      //   230: goto -195 -> 35
      //   233: aload_0
      //   234: aload_0
      //   235: getfield 127	com/tencent/ilink/tdi/b$e:bitField0_	I
      //   238: iconst_2
      //   239: ior
      //   240: putfield 127	com/tencent/ilink/tdi/b$e:bitField0_	I
      //   243: aload_0
      //   244: iload 4
      //   246: putfield 56	com/tencent/ilink/tdi/b$e:efm	I
      //   249: goto -214 -> 35
      //   252: aload_0
      //   253: aload_0
      //   254: getfield 127	com/tencent/ilink/tdi/b$e:bitField0_	I
      //   257: iconst_4
      //   258: ior
      //   259: putfield 127	com/tencent/ilink/tdi/b$e:bitField0_	I
      //   262: aload_0
      //   263: aload_1
      //   264: invokevirtual 140	com/google/d/i:aak	()Lcom/google/d/h;
      //   267: putfield 63	com/tencent/ilink/tdi/b$e:efn	Lcom/google/d/h;
      //   270: goto -235 -> 35
      //   273: aload_0
      //   274: aload 5
      //   276: invokevirtual 118	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   279: putfield 122	com/tencent/ilink/tdi/b$e:unknownFields	Lcom/google/d/dn;
      //   282: aload_0
      //   283: invokevirtual 125	com/tencent/ilink/tdi/b$e:makeExtensionsImmutable	()V
      //   286: ldc 76
      //   288: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   291: return
      //   292: goto -204 -> 88
      //   295: iconst_1
      //   296: istore_3
      //   297: goto -262 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	300	0	this	e
      //   0	300	1	parami	com.google.d.i
      //   0	300	2	paramat	com.google.d.at
      //   34	263	3	i	int
      //   43	202	4	j	int
      //   31	244	5	locala	com.google.d.dn.a
      // Exception table:
      //   from	to	target	type
      //   39	45	132	com/google/d/bk
      //   88	101	132	com/google/d/bk
      //   106	129	132	com/google/d/bk
      //   166	182	132	com/google/d/bk
      //   207	230	132	com/google/d/bk
      //   233	249	132	com/google/d/bk
      //   252	270	132	com/google/d/bk
      //   39	45	145	finally
      //   88	101	145	finally
      //   106	129	145	finally
      //   133	145	145	finally
      //   166	182	145	finally
      //   186	207	145	finally
      //   207	230	145	finally
      //   233	249	145	finally
      //   252	270	145	finally
      //   39	45	185	java/io/IOException
      //   88	101	185	java/io/IOException
      //   106	129	185	java/io/IOException
      //   166	182	185	java/io/IOException
      //   207	230	185	java/io/IOException
      //   233	249	185	java/io/IOException
      //   252	270	185	java/io/IOException
    }
    
    public static e N(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(214298);
      paramArrayOfByte = (e)PARSER.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(214298);
      return paramArrayOfByte;
    }
    
    private a amJ()
    {
      AppMethodBeat.i(214309);
      if (this == efo)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(214309);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(214309);
      return locala;
    }
    
    public static e amK()
    {
      return efo;
    }
    
    public final boolean ady()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final a.a amF()
    {
      AppMethodBeat.i(214459);
      a.a locala = a.a.mc(this.type_);
      if (locala == null)
      {
        locala = a.a.edI;
        AppMethodBeat.o(214459);
        return locala;
      }
      AppMethodBeat.o(214459);
      return locala;
    }
    
    public final boolean amG()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final a.b amH()
    {
      AppMethodBeat.i(214483);
      a.b localb = a.b.md(this.efm);
      if (localb == null)
      {
        localb = a.b.edS;
        AppMethodBeat.o(214483);
        return localb;
      }
      AppMethodBeat.o(214483);
      return localb;
    }
    
    public final boolean amI()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214541);
      if (paramObject == this)
      {
        AppMethodBeat.o(214541);
        return true;
      }
      if (!(paramObject instanceof e))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(214541);
        return bool;
      }
      paramObject = (e)paramObject;
      if (ady() != paramObject.ady())
      {
        AppMethodBeat.o(214541);
        return false;
      }
      if ((ady()) && (this.type_ != paramObject.type_))
      {
        AppMethodBeat.o(214541);
        return false;
      }
      if (amG() != paramObject.amG())
      {
        AppMethodBeat.o(214541);
        return false;
      }
      if ((amG()) && (this.efm != paramObject.efm))
      {
        AppMethodBeat.o(214541);
        return false;
      }
      if (amI() != paramObject.amI())
      {
        AppMethodBeat.o(214541);
        return false;
      }
      if ((amI()) && (!this.efn.equals(paramObject.efn)))
      {
        AppMethodBeat.o(214541);
        return false;
      }
      if (!this.unknownFields.equals(paramObject.unknownFields))
      {
        AppMethodBeat.o(214541);
        return false;
      }
      AppMethodBeat.o(214541);
      return true;
    }
    
    public final cs<e> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(214528);
      int i = this.memoizedSize;
      if (i != -1)
      {
        AppMethodBeat.o(214528);
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        j = com.google.d.k.cM(1, this.type_) + 0;
      }
      i = j;
      if ((this.bitField0_ & 0x2) != 0) {
        i = j + com.google.d.k.cM(2, this.efm);
      }
      j = i;
      if ((this.bitField0_ & 0x4) != 0) {
        j = i + com.google.d.k.c(3, this.efn);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      AppMethodBeat.o(214528);
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(214553);
      if (this.memoizedHashCode != 0)
      {
        i = this.memoizedHashCode;
        AppMethodBeat.o(214553);
        return i;
      }
      int j = b.alG().hashCode() + 779;
      int i = j;
      if (ady()) {
        i = (j * 37 + 1) * 53 + this.type_;
      }
      j = i;
      if (amG()) {
        j = (i * 37 + 2) * 53 + this.efm;
      }
      i = j;
      if (amI()) {
        i = (j * 37 + 3) * 53 + this.efn.hashCode();
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      AppMethodBeat.o(214553);
      return i;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(214434);
      bg.e locale = b.alH().b(e.class, a.class);
      AppMethodBeat.o(214434);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final Object newInstance(bg.f paramf)
    {
      AppMethodBeat.i(214410);
      paramf = new e();
      AppMethodBeat.o(214410);
      return paramf;
    }
    
    public final void writeTo(com.google.d.k paramk)
    {
      AppMethodBeat.i(214516);
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.cF(1, this.type_);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.cF(2, this.efm);
      }
      if ((this.bitField0_ & 0x4) != 0) {
        paramk.a(3, this.efn);
      }
      this.unknownFields.writeTo(paramk);
      AppMethodBeat.o(214516);
    }
    
    public static final class a
      extends bg.a<a>
      implements g
    {
      private int bitField0_;
      private int efm;
      private com.google.d.h efn;
      private int type_;
      
      private a()
      {
        AppMethodBeat.i(214044);
        this.type_ = 1;
        this.efm = 0;
        this.efn = com.google.d.h.dIJ;
        b.e.amL();
        AppMethodBeat.o(214044);
      }
      
      private a(bg.b paramb)
      {
        super();
        AppMethodBeat.i(214055);
        this.type_ = 1;
        this.efm = 0;
        this.efn = com.google.d.h.dIJ;
        b.e.amL();
        AppMethodBeat.o(214055);
      }
      
      private a D(am.f paramf, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(214129);
        paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
        AppMethodBeat.o(214129);
        return paramf;
      }
      
      /* Error */
      private a D(com.google.d.i parami, com.google.d.at paramat)
      {
        // Byte code:
        //   0: ldc 68
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 72	com/tencent/ilink/tdi/b$e:PARSER	Lcom/google/d/cs;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 78 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$e
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 82	com/tencent/ilink/tdi/b$e$a:b	(Lcom/tencent/ilink/tdi/b$e;)Lcom/tencent/ilink/tdi/b$e$a;
        //   30: pop
        //   31: ldc 68
        //   33: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 86	com/google/d/bk:dST	Lcom/google/d/ce;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$e
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 90	com/google/d/bk:aii	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 68
        //   54: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 82	com/tencent/ilink/tdi/b$e$a:b	(Lcom/tencent/ilink/tdi/b$e;)Lcom/tencent/ilink/tdi/b$e$a;
        //   69: pop
        //   70: ldc 68
        //   72: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: aload_1
        //   76: athrow
        //   77: astore_1
        //   78: aload_3
        //   79: astore_2
        //   80: goto -20 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	parami	com.google.d.i
        //   0	83	2	paramat	com.google.d.at
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/d/bk
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private a E(cb paramcb)
      {
        AppMethodBeat.i(214150);
        if ((paramcb instanceof b.e))
        {
          paramcb = b((b.e)paramcb);
          AppMethodBeat.o(214150);
          return paramcb;
        }
        super.mergeFrom(paramcb);
        AppMethodBeat.o(214150);
        return this;
      }
      
      private a H(am.j paramj)
      {
        AppMethodBeat.i(214119);
        paramj = (a)super.clearOneof(paramj);
        AppMethodBeat.o(214119);
        return paramj;
      }
      
      private a L(am.f paramf)
      {
        AppMethodBeat.i(214109);
        paramf = (a)super.clearField(paramf);
        AppMethodBeat.o(214109);
        return paramf;
      }
      
      private a a(a.a parama)
      {
        AppMethodBeat.i(214174);
        if (parama == null)
        {
          parama = new NullPointerException();
          AppMethodBeat.o(214174);
          throw parama;
        }
        this.bitField0_ |= 0x1;
        this.type_ = parama.value;
        onChanged();
        AppMethodBeat.o(214174);
        return this;
      }
      
      private a a(a.b paramb)
      {
        AppMethodBeat.i(214187);
        if (paramb == null)
        {
          paramb = new NullPointerException();
          AppMethodBeat.o(214187);
          throw paramb;
        }
        this.bitField0_ |= 0x2;
        this.efm = paramb.value;
        onChanged();
        AppMethodBeat.o(214187);
        return this;
      }
      
      private a ai(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214099);
        paramf = (a)super.setField(paramf, paramObject);
        AppMethodBeat.o(214099);
        return paramf;
      }
      
      private a aj(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214138);
        paramf = (a)super.addRepeatedField(paramf, paramObject);
        AppMethodBeat.o(214138);
        return paramf;
      }
      
      private a ak(dn paramdn)
      {
        AppMethodBeat.i(214210);
        paramdn = (a)super.setUnknownFields(paramdn);
        AppMethodBeat.o(214210);
        return paramdn;
      }
      
      private a al(dn paramdn)
      {
        AppMethodBeat.i(214221);
        paramdn = (a)super.mergeUnknownFields(paramdn);
        AppMethodBeat.o(214221);
        return paramdn;
      }
      
      private a amM()
      {
        AppMethodBeat.i(214066);
        super.clear();
        this.type_ = 1;
        this.bitField0_ &= 0xFFFFFFFE;
        this.efm = 0;
        this.bitField0_ &= 0xFFFFFFFD;
        this.efn = com.google.d.h.dIJ;
        this.bitField0_ &= 0xFFFFFFFB;
        AppMethodBeat.o(214066);
        return this;
      }
      
      private b.e amN()
      {
        AppMethodBeat.i(214077);
        Object localObject = amO();
        if (!((b.e)localObject).isInitialized())
        {
          localObject = newUninitializedMessageException((cb)localObject);
          AppMethodBeat.o(214077);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(214077);
        return localObject;
      }
      
      private b.e amO()
      {
        int j = 0;
        AppMethodBeat.i(214088);
        b.e locale = new b.e(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        b.e.a(locale, this.type_);
        int i = j;
        if ((k & 0x2) != 0) {
          i = j | 0x2;
        }
        b.e.b(locale, this.efm);
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        b.e.a(locale, this.efn);
        b.e.c(locale, j);
        onBuilt();
        AppMethodBeat.o(214088);
        return locale;
      }
      
      private a n(com.google.d.h paramh)
      {
        AppMethodBeat.i(214200);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(214200);
          throw paramh;
        }
        this.bitField0_ |= 0x4;
        this.efn = paramh;
        onChanged();
        AppMethodBeat.o(214200);
        return this;
      }
      
      public final a b(b.e parame)
      {
        AppMethodBeat.i(214274);
        if (parame == b.e.amK())
        {
          AppMethodBeat.o(214274);
          return this;
        }
        if (parame.ady()) {
          a(parame.amF());
        }
        if (parame.amG()) {
          a(parame.amH());
        }
        if (parame.amI()) {
          n(parame.efn);
        }
        al(b.e.a(parame));
        onChanged();
        AppMethodBeat.o(214274);
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        AppMethodBeat.i(214262);
        am.a locala = b.alG();
        AppMethodBeat.o(214262);
        return locala;
      }
      
      public final bg.e internalGetFieldAccessorTable()
      {
        AppMethodBeat.i(214252);
        bg.e locale = b.alH().b(b.e.class, a.class);
        AppMethodBeat.o(214252);
        return locale;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class f
    extends bg
    implements h
  {
    @Deprecated
    public static final cs<f> PARSER;
    private static final f efq;
    private int bitField0_;
    com.google.d.h efp;
    private byte memoizedIsInitialized = -1;
    
    static
    {
      AppMethodBeat.i(214465);
      efq = new f();
      PARSER = new com.google.d.c() {};
      AppMethodBeat.o(214465);
    }
    
    private f()
    {
      this.efp = com.google.d.h.dIJ;
    }
    
    private f(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private f(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 38	com/tencent/ilink/tdi/b$f:<init>	()V
      //   4: ldc 70
      //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_2
      //   10: ifnonnull +18 -> 28
      //   13: new 72	java/lang/NullPointerException
      //   16: dup
      //   17: invokespecial 73	java/lang/NullPointerException:<init>	()V
      //   20: astore_1
      //   21: ldc 70
      //   23: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: aload_1
      //   27: athrow
      //   28: invokestatic 79	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +109 -> 145
      //   39: aload_1
      //   40: invokevirtual 85	com/google/d/i:aac	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+139->186, 0:+142->189, 10:+43->90
      //   73: aload_1
      //   74: aload 5
      //   76: aload_2
      //   77: iload 4
      //   79: invokevirtual 89	com/tencent/ilink/tdi/b$f:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   82: ifne -47 -> 35
      //   85: iconst_1
      //   86: istore_3
      //   87: goto -52 -> 35
      //   90: aload_0
      //   91: aload_0
      //   92: getfield 91	com/tencent/ilink/tdi/b$f:bitField0_	I
      //   95: iconst_1
      //   96: ior
      //   97: putfield 91	com/tencent/ilink/tdi/b$f:bitField0_	I
      //   100: aload_0
      //   101: aload_1
      //   102: invokevirtual 95	com/google/d/i:aak	()Lcom/google/d/h;
      //   105: putfield 57	com/tencent/ilink/tdi/b$f:efp	Lcom/google/d/h;
      //   108: goto -73 -> 35
      //   111: astore_1
      //   112: aload_1
      //   113: aload_0
      //   114: putfield 99	com/google/d/bk:dST	Lcom/google/d/ce;
      //   117: ldc 70
      //   119: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   122: aload_1
      //   123: athrow
      //   124: astore_1
      //   125: aload_0
      //   126: aload 5
      //   128: invokevirtual 105	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   131: putfield 109	com/tencent/ilink/tdi/b$f:unknownFields	Lcom/google/d/dn;
      //   134: aload_0
      //   135: invokevirtual 112	com/tencent/ilink/tdi/b$f:makeExtensionsImmutable	()V
      //   138: ldc 70
      //   140: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   143: aload_1
      //   144: athrow
      //   145: aload_0
      //   146: aload 5
      //   148: invokevirtual 105	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   151: putfield 109	com/tencent/ilink/tdi/b$f:unknownFields	Lcom/google/d/dn;
      //   154: aload_0
      //   155: invokevirtual 112	com/tencent/ilink/tdi/b$f:makeExtensionsImmutable	()V
      //   158: ldc 70
      //   160: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   163: return
      //   164: astore_1
      //   165: new 67	com/google/d/bk
      //   168: dup
      //   169: aload_1
      //   170: invokespecial 115	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   173: astore_1
      //   174: aload_1
      //   175: aload_0
      //   176: putfield 99	com/google/d/bk:dST	Lcom/google/d/ce;
      //   179: ldc 70
      //   181: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   184: aload_1
      //   185: athrow
      //   186: goto -114 -> 72
      //   189: iconst_1
      //   190: istore_3
      //   191: goto -156 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	194	0	this	f
      //   0	194	1	parami	com.google.d.i
      //   0	194	2	paramat	com.google.d.at
      //   34	157	3	i	int
      //   43	35	4	j	int
      //   31	116	5	locala	com.google.d.dn.a
      // Exception table:
      //   from	to	target	type
      //   39	45	111	com/google/d/bk
      //   72	85	111	com/google/d/bk
      //   90	108	111	com/google/d/bk
      //   39	45	124	finally
      //   72	85	124	finally
      //   90	108	124	finally
      //   112	124	124	finally
      //   165	186	124	finally
      //   39	45	164	java/io/IOException
      //   72	85	164	java/io/IOException
      //   90	108	164	java/io/IOException
    }
    
    public static f O(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(214327);
      paramArrayOfByte = (f)PARSER.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(214327);
      return paramArrayOfByte;
    }
    
    private a amQ()
    {
      AppMethodBeat.i(214346);
      if (this == efq)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(214346);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(214346);
      return locala;
    }
    
    public static f amR()
    {
      return efq;
    }
    
    public final boolean amP()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214617);
      if (paramObject == this)
      {
        AppMethodBeat.o(214617);
        return true;
      }
      if (!(paramObject instanceof f))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(214617);
        return bool;
      }
      paramObject = (f)paramObject;
      if (amP() != paramObject.amP())
      {
        AppMethodBeat.o(214617);
        return false;
      }
      if ((amP()) && (!this.efp.equals(paramObject.efp)))
      {
        AppMethodBeat.o(214617);
        return false;
      }
      if (!this.unknownFields.equals(paramObject.unknownFields))
      {
        AppMethodBeat.o(214617);
        return false;
      }
      AppMethodBeat.o(214617);
      return true;
    }
    
    public final cs<f> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(214600);
      int i = this.memoizedSize;
      if (i != -1)
      {
        AppMethodBeat.o(214600);
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        i = com.google.d.k.c(1, this.efp) + 0;
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      AppMethodBeat.o(214600);
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(214633);
      if (this.memoizedHashCode != 0)
      {
        i = this.memoizedHashCode;
        AppMethodBeat.o(214633);
        return i;
      }
      int j = b.alC().hashCode() + 779;
      int i = j;
      if (amP()) {
        i = (j * 37 + 1) * 53 + this.efp.hashCode();
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      AppMethodBeat.o(214633);
      return i;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(214525);
      bg.e locale = b.alD().b(f.class, a.class);
      AppMethodBeat.o(214525);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final Object newInstance(bg.f paramf)
    {
      AppMethodBeat.i(214485);
      paramf = new f();
      AppMethodBeat.o(214485);
      return paramf;
    }
    
    public final void writeTo(com.google.d.k paramk)
    {
      AppMethodBeat.i(214579);
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.a(1, this.efp);
      }
      this.unknownFields.writeTo(paramk);
      AppMethodBeat.o(214579);
    }
    
    public static final class a
      extends bg.a<a>
      implements h
    {
      private int bitField0_;
      private com.google.d.h efp;
      
      private a()
      {
        AppMethodBeat.i(214689);
        this.efp = com.google.d.h.dIJ;
        b.f.amS();
        AppMethodBeat.o(214689);
      }
      
      private a(bg.b paramb)
      {
        super();
        AppMethodBeat.i(214701);
        this.efp = com.google.d.h.dIJ;
        b.f.amS();
        AppMethodBeat.o(214701);
      }
      
      private a E(am.f paramf, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(214763);
        paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
        AppMethodBeat.o(214763);
        return paramf;
      }
      
      /* Error */
      private a E(com.google.d.i parami, com.google.d.at paramat)
      {
        // Byte code:
        //   0: ldc 62
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 66	com/tencent/ilink/tdi/b$f:PARSER	Lcom/google/d/cs;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 72 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$f
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 76	com/tencent/ilink/tdi/b$f$a:b	(Lcom/tencent/ilink/tdi/b$f;)Lcom/tencent/ilink/tdi/b$f$a;
        //   30: pop
        //   31: ldc 62
        //   33: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 80	com/google/d/bk:dST	Lcom/google/d/ce;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$f
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 84	com/google/d/bk:aii	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 62
        //   54: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 76	com/tencent/ilink/tdi/b$f$a:b	(Lcom/tencent/ilink/tdi/b$f;)Lcom/tencent/ilink/tdi/b$f$a;
        //   69: pop
        //   70: ldc 62
        //   72: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: aload_1
        //   76: athrow
        //   77: astore_1
        //   78: aload_3
        //   79: astore_2
        //   80: goto -20 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	parami	com.google.d.i
        //   0	83	2	paramat	com.google.d.at
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/d/bk
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private a F(cb paramcb)
      {
        AppMethodBeat.i(214784);
        if ((paramcb instanceof b.f))
        {
          paramcb = b((b.f)paramcb);
          AppMethodBeat.o(214784);
          return paramcb;
        }
        super.mergeFrom(paramcb);
        AppMethodBeat.o(214784);
        return this;
      }
      
      private a I(am.j paramj)
      {
        AppMethodBeat.i(214752);
        paramj = (a)super.clearOneof(paramj);
        AppMethodBeat.o(214752);
        return paramj;
      }
      
      private a M(am.f paramf)
      {
        AppMethodBeat.i(214743);
        paramf = (a)super.clearField(paramf);
        AppMethodBeat.o(214743);
        return paramf;
      }
      
      private a ak(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214733);
        paramf = (a)super.setField(paramf, paramObject);
        AppMethodBeat.o(214733);
        return paramf;
      }
      
      private a al(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214771);
        paramf = (a)super.addRepeatedField(paramf, paramObject);
        AppMethodBeat.o(214771);
        return paramf;
      }
      
      private a am(dn paramdn)
      {
        AppMethodBeat.i(214820);
        paramdn = (a)super.setUnknownFields(paramdn);
        AppMethodBeat.o(214820);
        return paramdn;
      }
      
      private a amT()
      {
        AppMethodBeat.i(214710);
        super.clear();
        this.efp = com.google.d.h.dIJ;
        this.bitField0_ &= 0xFFFFFFFE;
        AppMethodBeat.o(214710);
        return this;
      }
      
      private b.f amU()
      {
        AppMethodBeat.i(214716);
        Object localObject = amV();
        if (!((b.f)localObject).isInitialized())
        {
          localObject = newUninitializedMessageException((cb)localObject);
          AppMethodBeat.o(214716);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(214716);
        return localObject;
      }
      
      private b.f amV()
      {
        int i = 0;
        AppMethodBeat.i(214725);
        b.f localf = new b.f(this, (byte)0);
        if ((this.bitField0_ & 0x1) != 0) {
          i = 1;
        }
        b.f.a(localf, this.efp);
        b.f.a(localf, i);
        onBuilt();
        AppMethodBeat.o(214725);
        return localf;
      }
      
      private a an(dn paramdn)
      {
        AppMethodBeat.i(214831);
        paramdn = (a)super.mergeUnknownFields(paramdn);
        AppMethodBeat.o(214831);
        return paramdn;
      }
      
      private a o(com.google.d.h paramh)
      {
        AppMethodBeat.i(214810);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(214810);
          throw paramh;
        }
        this.bitField0_ |= 0x1;
        this.efp = paramh;
        onChanged();
        AppMethodBeat.o(214810);
        return this;
      }
      
      public final a b(b.f paramf)
      {
        AppMethodBeat.i(214888);
        if (paramf == b.f.amR())
        {
          AppMethodBeat.o(214888);
          return this;
        }
        if (paramf.amP()) {
          o(paramf.efp);
        }
        an(b.f.a(paramf));
        onChanged();
        AppMethodBeat.o(214888);
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        AppMethodBeat.i(214875);
        am.a locala = b.alC();
        AppMethodBeat.o(214875);
        return locala;
      }
      
      public final bg.e internalGetFieldAccessorTable()
      {
        AppMethodBeat.i(214862);
        bg.e locale = b.alD().b(b.f.class, a.class);
        AppMethodBeat.o(214862);
        return locale;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class g
    extends bg
    implements i
  {
    @Deprecated
    public static final cs<g> PARSER;
    private static final g eft;
    private int bitField0_;
    private int efm;
    com.google.d.h efr;
    com.google.d.h efs;
    private byte memoizedIsInitialized = -1;
    
    static
    {
      AppMethodBeat.i(214312);
      eft = new g();
      PARSER = new com.google.d.c() {};
      AppMethodBeat.o(214312);
    }
    
    private g()
    {
      this.efr = com.google.d.h.dIJ;
      this.efs = com.google.d.h.dIJ;
      this.efm = 0;
    }
    
    private g(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private g(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 40	com/tencent/ilink/tdi/b$g:<init>	()V
      //   4: ldc 76
      //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_2
      //   10: ifnonnull +18 -> 28
      //   13: new 78	java/lang/NullPointerException
      //   16: dup
      //   17: invokespecial 79	java/lang/NullPointerException:<init>	()V
      //   20: astore_1
      //   21: ldc 76
      //   23: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: aload_1
      //   27: athrow
      //   28: invokestatic 85	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +213 -> 249
      //   39: aload_1
      //   40: invokevirtual 91	com/google/d/i:aac	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+221->268, 0:+224->271, 10:+59->106, 18:+114->161, 24:+157->204
      //   89: aload_1
      //   90: aload 5
      //   92: aload_2
      //   93: iload 4
      //   95: invokevirtual 95	com/tencent/ilink/tdi/b$g:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   98: ifne -63 -> 35
      //   101: iconst_1
      //   102: istore_3
      //   103: goto -68 -> 35
      //   106: aload_0
      //   107: aload_0
      //   108: getfield 97	com/tencent/ilink/tdi/b$g:bitField0_	I
      //   111: iconst_1
      //   112: ior
      //   113: putfield 97	com/tencent/ilink/tdi/b$g:bitField0_	I
      //   116: aload_0
      //   117: aload_1
      //   118: invokevirtual 101	com/google/d/i:aak	()Lcom/google/d/h;
      //   121: putfield 59	com/tencent/ilink/tdi/b$g:efr	Lcom/google/d/h;
      //   124: goto -89 -> 35
      //   127: astore_1
      //   128: aload_1
      //   129: aload_0
      //   130: putfield 105	com/google/d/bk:dST	Lcom/google/d/ce;
      //   133: ldc 76
      //   135: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   138: aload_1
      //   139: athrow
      //   140: astore_1
      //   141: aload_0
      //   142: aload 5
      //   144: invokevirtual 111	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   147: putfield 115	com/tencent/ilink/tdi/b$g:unknownFields	Lcom/google/d/dn;
      //   150: aload_0
      //   151: invokevirtual 118	com/tencent/ilink/tdi/b$g:makeExtensionsImmutable	()V
      //   154: ldc 76
      //   156: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   159: aload_1
      //   160: athrow
      //   161: aload_0
      //   162: aload_0
      //   163: getfield 97	com/tencent/ilink/tdi/b$g:bitField0_	I
      //   166: iconst_2
      //   167: ior
      //   168: putfield 97	com/tencent/ilink/tdi/b$g:bitField0_	I
      //   171: aload_0
      //   172: aload_1
      //   173: invokevirtual 101	com/google/d/i:aak	()Lcom/google/d/h;
      //   176: putfield 61	com/tencent/ilink/tdi/b$g:efs	Lcom/google/d/h;
      //   179: goto -144 -> 35
      //   182: astore_1
      //   183: new 73	com/google/d/bk
      //   186: dup
      //   187: aload_1
      //   188: invokespecial 121	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   191: astore_1
      //   192: aload_1
      //   193: aload_0
      //   194: putfield 105	com/google/d/bk:dST	Lcom/google/d/ce;
      //   197: ldc 76
      //   199: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   202: aload_1
      //   203: athrow
      //   204: aload_1
      //   205: invokevirtual 124	com/google/d/i:aam	()I
      //   208: istore 4
      //   210: iload 4
      //   212: invokestatic 130	com/tencent/ilink/tdi/a$b:md	(I)Lcom/tencent/ilink/tdi/a$b;
      //   215: ifnonnull +15 -> 230
      //   218: aload 5
      //   220: iconst_3
      //   221: iload 4
      //   223: invokevirtual 134	com/google/d/dn$a:cR	(II)Lcom/google/d/dn$a;
      //   226: pop
      //   227: goto -192 -> 35
      //   230: aload_0
      //   231: aload_0
      //   232: getfield 97	com/tencent/ilink/tdi/b$g:bitField0_	I
      //   235: iconst_4
      //   236: ior
      //   237: putfield 97	com/tencent/ilink/tdi/b$g:bitField0_	I
      //   240: aload_0
      //   241: iload 4
      //   243: putfield 63	com/tencent/ilink/tdi/b$g:efm	I
      //   246: goto -211 -> 35
      //   249: aload_0
      //   250: aload 5
      //   252: invokevirtual 111	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   255: putfield 115	com/tencent/ilink/tdi/b$g:unknownFields	Lcom/google/d/dn;
      //   258: aload_0
      //   259: invokevirtual 118	com/tencent/ilink/tdi/b$g:makeExtensionsImmutable	()V
      //   262: ldc 76
      //   264: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   267: return
      //   268: goto -180 -> 88
      //   271: iconst_1
      //   272: istore_3
      //   273: goto -238 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	276	0	this	g
      //   0	276	1	parami	com.google.d.i
      //   0	276	2	paramat	com.google.d.at
      //   34	239	3	i	int
      //   43	199	4	j	int
      //   31	220	5	locala	com.google.d.dn.a
      // Exception table:
      //   from	to	target	type
      //   39	45	127	com/google/d/bk
      //   88	101	127	com/google/d/bk
      //   106	124	127	com/google/d/bk
      //   161	179	127	com/google/d/bk
      //   204	227	127	com/google/d/bk
      //   230	246	127	com/google/d/bk
      //   39	45	140	finally
      //   88	101	140	finally
      //   106	124	140	finally
      //   128	140	140	finally
      //   161	179	140	finally
      //   183	204	140	finally
      //   204	227	140	finally
      //   230	246	140	finally
      //   39	45	182	java/io/IOException
      //   88	101	182	java/io/IOException
      //   106	124	182	java/io/IOException
      //   161	179	182	java/io/IOException
      //   204	227	182	java/io/IOException
      //   230	246	182	java/io/IOException
    }
    
    public static g P(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(214206);
      paramArrayOfByte = (g)PARSER.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(214206);
      return paramArrayOfByte;
    }
    
    private a amY()
    {
      AppMethodBeat.i(214219);
      if (this == eft)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(214219);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(214219);
      return locala;
    }
    
    public static g amZ()
    {
      return eft;
    }
    
    public final boolean amG()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    public final a.b amH()
    {
      AppMethodBeat.i(214392);
      a.b localb = a.b.md(this.efm);
      if (localb == null)
      {
        localb = a.b.edS;
        AppMethodBeat.o(214392);
        return localb;
      }
      AppMethodBeat.o(214392);
      return localb;
    }
    
    public final boolean amW()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final boolean amX()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214440);
      if (paramObject == this)
      {
        AppMethodBeat.o(214440);
        return true;
      }
      if (!(paramObject instanceof g))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(214440);
        return bool;
      }
      paramObject = (g)paramObject;
      if (amW() != paramObject.amW())
      {
        AppMethodBeat.o(214440);
        return false;
      }
      if ((amW()) && (!this.efr.equals(paramObject.efr)))
      {
        AppMethodBeat.o(214440);
        return false;
      }
      if (amX() != paramObject.amX())
      {
        AppMethodBeat.o(214440);
        return false;
      }
      if ((amX()) && (!this.efs.equals(paramObject.efs)))
      {
        AppMethodBeat.o(214440);
        return false;
      }
      if (amG() != paramObject.amG())
      {
        AppMethodBeat.o(214440);
        return false;
      }
      if ((amG()) && (this.efm != paramObject.efm))
      {
        AppMethodBeat.o(214440);
        return false;
      }
      if (!this.unknownFields.equals(paramObject.unknownFields))
      {
        AppMethodBeat.o(214440);
        return false;
      }
      AppMethodBeat.o(214440);
      return true;
    }
    
    public final cs<g> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(214427);
      int i = this.memoizedSize;
      if (i != -1)
      {
        AppMethodBeat.o(214427);
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        j = com.google.d.k.c(1, this.efr) + 0;
      }
      i = j;
      if ((this.bitField0_ & 0x2) != 0) {
        i = j + com.google.d.k.c(2, this.efs);
      }
      j = i;
      if ((this.bitField0_ & 0x4) != 0) {
        j = i + com.google.d.k.cM(3, this.efm);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      AppMethodBeat.o(214427);
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(214455);
      if (this.memoizedHashCode != 0)
      {
        i = this.memoizedHashCode;
        AppMethodBeat.o(214455);
        return i;
      }
      int j = b.alE().hashCode() + 779;
      int i = j;
      if (amW()) {
        i = (j * 37 + 1) * 53 + this.efr.hashCode();
      }
      j = i;
      if (amX()) {
        j = (i * 37 + 2) * 53 + this.efs.hashCode();
      }
      i = j;
      if (amG()) {
        i = (j * 37 + 3) * 53 + this.efm;
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      AppMethodBeat.o(214455);
      return i;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(214354);
      bg.e locale = b.alF().b(g.class, a.class);
      AppMethodBeat.o(214354);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final Object newInstance(bg.f paramf)
    {
      AppMethodBeat.i(214330);
      paramf = new g();
      AppMethodBeat.o(214330);
      return paramf;
    }
    
    public final void writeTo(com.google.d.k paramk)
    {
      AppMethodBeat.i(214413);
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.a(1, this.efr);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.a(2, this.efs);
      }
      if ((this.bitField0_ & 0x4) != 0) {
        paramk.cF(3, this.efm);
      }
      this.unknownFields.writeTo(paramk);
      AppMethodBeat.o(214413);
    }
    
    public static final class a
      extends bg.a<a>
      implements i
    {
      private int bitField0_;
      private int efm;
      private com.google.d.h efr;
      private com.google.d.h efs;
      
      private a()
      {
        AppMethodBeat.i(213929);
        this.efr = com.google.d.h.dIJ;
        this.efs = com.google.d.h.dIJ;
        this.efm = 0;
        b.g.ana();
        AppMethodBeat.o(213929);
      }
      
      private a(bg.b paramb)
      {
        super();
        AppMethodBeat.i(213938);
        this.efr = com.google.d.h.dIJ;
        this.efs = com.google.d.h.dIJ;
        this.efm = 0;
        b.g.ana();
        AppMethodBeat.o(213938);
      }
      
      private a F(am.f paramf, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(213995);
        paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
        AppMethodBeat.o(213995);
        return paramf;
      }
      
      /* Error */
      private a F(com.google.d.i parami, com.google.d.at paramat)
      {
        // Byte code:
        //   0: ldc 68
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 72	com/tencent/ilink/tdi/b$g:PARSER	Lcom/google/d/cs;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 78 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$g
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 82	com/tencent/ilink/tdi/b$g$a:b	(Lcom/tencent/ilink/tdi/b$g;)Lcom/tencent/ilink/tdi/b$g$a;
        //   30: pop
        //   31: ldc 68
        //   33: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 86	com/google/d/bk:dST	Lcom/google/d/ce;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$g
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 90	com/google/d/bk:aii	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 68
        //   54: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 82	com/tencent/ilink/tdi/b$g$a:b	(Lcom/tencent/ilink/tdi/b$g;)Lcom/tencent/ilink/tdi/b$g$a;
        //   69: pop
        //   70: ldc 68
        //   72: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: aload_1
        //   76: athrow
        //   77: astore_1
        //   78: aload_3
        //   79: astore_2
        //   80: goto -20 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	parami	com.google.d.i
        //   0	83	2	paramat	com.google.d.at
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/d/bk
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private a G(cb paramcb)
      {
        AppMethodBeat.i(214011);
        if ((paramcb instanceof b.g))
        {
          paramcb = b((b.g)paramcb);
          AppMethodBeat.o(214011);
          return paramcb;
        }
        super.mergeFrom(paramcb);
        AppMethodBeat.o(214011);
        return this;
      }
      
      private a J(am.j paramj)
      {
        AppMethodBeat.i(213985);
        paramj = (a)super.clearOneof(paramj);
        AppMethodBeat.o(213985);
        return paramj;
      }
      
      private a N(am.f paramf)
      {
        AppMethodBeat.i(213977);
        paramf = (a)super.clearField(paramf);
        AppMethodBeat.o(213977);
        return paramf;
      }
      
      private a am(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(213970);
        paramf = (a)super.setField(paramf, paramObject);
        AppMethodBeat.o(213970);
        return paramf;
      }
      
      private a an(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214003);
        paramf = (a)super.addRepeatedField(paramf, paramObject);
        AppMethodBeat.o(214003);
        return paramf;
      }
      
      private a anb()
      {
        AppMethodBeat.i(213945);
        super.clear();
        this.efr = com.google.d.h.dIJ;
        this.bitField0_ &= 0xFFFFFFFE;
        this.efs = com.google.d.h.dIJ;
        this.bitField0_ &= 0xFFFFFFFD;
        this.efm = 0;
        this.bitField0_ &= 0xFFFFFFFB;
        AppMethodBeat.o(213945);
        return this;
      }
      
      private b.g anc()
      {
        AppMethodBeat.i(213953);
        Object localObject = and();
        if (!((b.g)localObject).isInitialized())
        {
          localObject = newUninitializedMessageException((cb)localObject);
          AppMethodBeat.o(213953);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(213953);
        return localObject;
      }
      
      private b.g and()
      {
        int j = 0;
        AppMethodBeat.i(213959);
        b.g localg = new b.g(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        b.g.a(localg, this.efr);
        int i = j;
        if ((k & 0x2) != 0) {
          i = j | 0x2;
        }
        b.g.b(localg, this.efs);
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        b.g.a(localg, this.efm);
        b.g.b(localg, j);
        onBuilt();
        AppMethodBeat.o(213959);
        return localg;
      }
      
      private a ao(dn paramdn)
      {
        AppMethodBeat.i(214059);
        paramdn = (a)super.setUnknownFields(paramdn);
        AppMethodBeat.o(214059);
        return paramdn;
      }
      
      private a ap(dn paramdn)
      {
        AppMethodBeat.i(214071);
        paramdn = (a)super.mergeUnknownFields(paramdn);
        AppMethodBeat.o(214071);
        return paramdn;
      }
      
      private a b(a.b paramb)
      {
        AppMethodBeat.i(214050);
        if (paramb == null)
        {
          paramb = new NullPointerException();
          AppMethodBeat.o(214050);
          throw paramb;
        }
        this.bitField0_ |= 0x4;
        this.efm = paramb.value;
        onChanged();
        AppMethodBeat.o(214050);
        return this;
      }
      
      private a p(com.google.d.h paramh)
      {
        AppMethodBeat.i(214032);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(214032);
          throw paramh;
        }
        this.bitField0_ |= 0x1;
        this.efr = paramh;
        onChanged();
        AppMethodBeat.o(214032);
        return this;
      }
      
      private a q(com.google.d.h paramh)
      {
        AppMethodBeat.i(214040);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(214040);
          throw paramh;
        }
        this.bitField0_ |= 0x2;
        this.efs = paramh;
        onChanged();
        AppMethodBeat.o(214040);
        return this;
      }
      
      public final a b(b.g paramg)
      {
        AppMethodBeat.i(214120);
        if (paramg == b.g.amZ())
        {
          AppMethodBeat.o(214120);
          return this;
        }
        if (paramg.amW()) {
          p(paramg.efr);
        }
        if (paramg.amX()) {
          q(paramg.efs);
        }
        if (paramg.amG()) {
          b(paramg.amH());
        }
        ap(b.g.a(paramg));
        onChanged();
        AppMethodBeat.o(214120);
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        AppMethodBeat.i(214108);
        am.a locala = b.alE();
        AppMethodBeat.o(214108);
        return locala;
      }
      
      public final bg.e internalGetFieldAccessorTable()
      {
        AppMethodBeat.i(214098);
        bg.e locale = b.alF().b(b.g.class, a.class);
        AppMethodBeat.o(214098);
        return locale;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class h
    extends bg
    implements j
  {
    @Deprecated
    public static final cs<h> PARSER;
    private static final h efv;
    private int bitField0_;
    private volatile Object efu;
    private byte memoizedIsInitialized = -1;
    
    static
    {
      AppMethodBeat.i(214370);
      efv = new h();
      PARSER = new com.google.d.c() {};
      AppMethodBeat.o(214370);
    }
    
    private h()
    {
      this.efu = "";
    }
    
    private h(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private h(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 38	com/tencent/ilink/tdi/b$h:<init>	()V
      //   4: ldc 67
      //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_2
      //   10: ifnonnull +18 -> 28
      //   13: new 69	java/lang/NullPointerException
      //   16: dup
      //   17: invokespecial 70	java/lang/NullPointerException:<init>	()V
      //   20: astore_1
      //   21: ldc 67
      //   23: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: aload_1
      //   27: athrow
      //   28: invokestatic 76	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +113 -> 149
      //   39: aload_1
      //   40: invokevirtual 82	com/google/d/i:aac	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+143->190, 0:+146->193, 10:+43->90
      //   73: aload_1
      //   74: aload 5
      //   76: aload_2
      //   77: iload 4
      //   79: invokevirtual 86	com/tencent/ilink/tdi/b$h:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   82: ifne -47 -> 35
      //   85: iconst_1
      //   86: istore_3
      //   87: goto -52 -> 35
      //   90: aload_1
      //   91: invokevirtual 90	com/google/d/i:aak	()Lcom/google/d/h;
      //   94: astore 6
      //   96: aload_0
      //   97: aload_0
      //   98: getfield 92	com/tencent/ilink/tdi/b$h:bitField0_	I
      //   101: iconst_1
      //   102: ior
      //   103: putfield 92	com/tencent/ilink/tdi/b$h:bitField0_	I
      //   106: aload_0
      //   107: aload 6
      //   109: putfield 54	com/tencent/ilink/tdi/b$h:efu	Ljava/lang/Object;
      //   112: goto -77 -> 35
      //   115: astore_1
      //   116: aload_1
      //   117: aload_0
      //   118: putfield 96	com/google/d/bk:dST	Lcom/google/d/ce;
      //   121: ldc 67
      //   123: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   126: aload_1
      //   127: athrow
      //   128: astore_1
      //   129: aload_0
      //   130: aload 5
      //   132: invokevirtual 102	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   135: putfield 106	com/tencent/ilink/tdi/b$h:unknownFields	Lcom/google/d/dn;
      //   138: aload_0
      //   139: invokevirtual 109	com/tencent/ilink/tdi/b$h:makeExtensionsImmutable	()V
      //   142: ldc 67
      //   144: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   147: aload_1
      //   148: athrow
      //   149: aload_0
      //   150: aload 5
      //   152: invokevirtual 102	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   155: putfield 106	com/tencent/ilink/tdi/b$h:unknownFields	Lcom/google/d/dn;
      //   158: aload_0
      //   159: invokevirtual 109	com/tencent/ilink/tdi/b$h:makeExtensionsImmutable	()V
      //   162: ldc 67
      //   164: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   167: return
      //   168: astore_1
      //   169: new 64	com/google/d/bk
      //   172: dup
      //   173: aload_1
      //   174: invokespecial 112	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   177: astore_1
      //   178: aload_1
      //   179: aload_0
      //   180: putfield 96	com/google/d/bk:dST	Lcom/google/d/ce;
      //   183: ldc 67
      //   185: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   188: aload_1
      //   189: athrow
      //   190: goto -118 -> 72
      //   193: iconst_1
      //   194: istore_3
      //   195: goto -160 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	198	0	this	h
      //   0	198	1	parami	com.google.d.i
      //   0	198	2	paramat	com.google.d.at
      //   34	161	3	i	int
      //   43	35	4	j	int
      //   31	120	5	locala	com.google.d.dn.a
      //   94	14	6	localh	com.google.d.h
      // Exception table:
      //   from	to	target	type
      //   39	45	115	com/google/d/bk
      //   72	85	115	com/google/d/bk
      //   90	112	115	com/google/d/bk
      //   39	45	128	finally
      //   72	85	128	finally
      //   90	112	128	finally
      //   116	128	128	finally
      //   169	190	128	finally
      //   39	45	168	java/io/IOException
      //   72	85	168	java/io/IOException
      //   90	112	168	java/io/IOException
    }
    
    public static h Q(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(214197);
      paramArrayOfByte = (h)PARSER.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(214197);
      return paramArrayOfByte;
    }
    
    private a anf()
    {
      AppMethodBeat.i(214215);
      if (this == efv)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(214215);
        return locala;
      }
      a locala = new a((byte)0).c(this);
      AppMethodBeat.o(214215);
      return locala;
    }
    
    public static h ang()
    {
      return efv;
    }
    
    private String getPath()
    {
      AppMethodBeat.i(214182);
      Object localObject = this.efu;
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(214182);
        return localObject;
      }
      localObject = (com.google.d.h)localObject;
      String str = ((com.google.d.h)localObject).ZV();
      if (((com.google.d.h)localObject).ZW()) {
        this.efu = str;
      }
      AppMethodBeat.o(214182);
      return str;
    }
    
    public final boolean ane()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214510);
      if (paramObject == this)
      {
        AppMethodBeat.o(214510);
        return true;
      }
      if (!(paramObject instanceof h))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(214510);
        return bool;
      }
      paramObject = (h)paramObject;
      if (ane() != paramObject.ane())
      {
        AppMethodBeat.o(214510);
        return false;
      }
      if ((ane()) && (!getPath().equals(paramObject.getPath())))
      {
        AppMethodBeat.o(214510);
        return false;
      }
      if (!this.unknownFields.equals(paramObject.unknownFields))
      {
        AppMethodBeat.o(214510);
        return false;
      }
      AppMethodBeat.o(214510);
      return true;
    }
    
    public final cs<h> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(214486);
      int i = this.memoizedSize;
      if (i != -1)
      {
        AppMethodBeat.o(214486);
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        i = bg.computeStringSize(1, this.efu) + 0;
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      AppMethodBeat.o(214486);
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(214533);
      if (this.memoizedHashCode != 0)
      {
        i = this.memoizedHashCode;
        AppMethodBeat.o(214533);
        return i;
      }
      int j = b.alK().hashCode() + 779;
      int i = j;
      if (ane()) {
        i = (j * 37 + 1) * 53 + getPath().hashCode();
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      AppMethodBeat.o(214533);
      return i;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(214415);
      bg.e locale = b.alL().b(h.class, a.class);
      AppMethodBeat.o(214415);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final Object newInstance(bg.f paramf)
    {
      AppMethodBeat.i(214384);
      paramf = new h();
      AppMethodBeat.o(214384);
      return paramf;
    }
    
    public final void writeTo(com.google.d.k paramk)
    {
      AppMethodBeat.i(214467);
      if ((this.bitField0_ & 0x1) != 0) {
        bg.writeString(paramk, 1, this.efu);
      }
      this.unknownFields.writeTo(paramk);
      AppMethodBeat.o(214467);
    }
    
    public static final class a
      extends bg.a<a>
      implements j
    {
      private int bitField0_;
      private Object efu;
      
      private a()
      {
        AppMethodBeat.i(214062);
        this.efu = "";
        b.h.anh();
        AppMethodBeat.o(214062);
      }
      
      private a(bg.b paramb)
      {
        super();
        AppMethodBeat.i(214078);
        this.efu = "";
        b.h.anh();
        AppMethodBeat.o(214078);
      }
      
      private a G(am.f paramf, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(214244);
        paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
        AppMethodBeat.o(214244);
        return paramf;
      }
      
      /* Error */
      private a G(com.google.d.i parami, com.google.d.at paramat)
      {
        // Byte code:
        //   0: ldc 59
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 63	com/tencent/ilink/tdi/b$h:PARSER	Lcom/google/d/cs;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 69 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$h
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 73	com/tencent/ilink/tdi/b$h$a:c	(Lcom/tencent/ilink/tdi/b$h;)Lcom/tencent/ilink/tdi/b$h$a;
        //   30: pop
        //   31: ldc 59
        //   33: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 77	com/google/d/bk:dST	Lcom/google/d/ce;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$h
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 81	com/google/d/bk:aii	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 59
        //   54: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 73	com/tencent/ilink/tdi/b$h$a:c	(Lcom/tencent/ilink/tdi/b$h;)Lcom/tencent/ilink/tdi/b$h$a;
        //   69: pop
        //   70: ldc 59
        //   72: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: aload_1
        //   76: athrow
        //   77: astore_1
        //   78: aload_3
        //   79: astore_2
        //   80: goto -20 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	parami	com.google.d.i
        //   0	83	2	paramat	com.google.d.at
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/d/bk
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private a H(cb paramcb)
      {
        AppMethodBeat.i(214269);
        if ((paramcb instanceof b.h))
        {
          paramcb = c((b.h)paramcb);
          AppMethodBeat.o(214269);
          return paramcb;
        }
        super.mergeFrom(paramcb);
        AppMethodBeat.o(214269);
        return this;
      }
      
      private a K(am.j paramj)
      {
        AppMethodBeat.i(214228);
        paramj = (a)super.clearOneof(paramj);
        AppMethodBeat.o(214228);
        return paramj;
      }
      
      private a O(am.f paramf)
      {
        AppMethodBeat.i(214207);
        paramf = (a)super.clearField(paramf);
        AppMethodBeat.o(214207);
        return paramf;
      }
      
      private a ani()
      {
        AppMethodBeat.i(214093);
        super.clear();
        this.efu = "";
        this.bitField0_ &= 0xFFFFFFFE;
        AppMethodBeat.o(214093);
        return this;
      }
      
      private b.h anj()
      {
        AppMethodBeat.i(214156);
        Object localObject = ank();
        if (!((b.h)localObject).isInitialized())
        {
          localObject = newUninitializedMessageException((cb)localObject);
          AppMethodBeat.o(214156);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(214156);
        return localObject;
      }
      
      private b.h ank()
      {
        int i = 0;
        AppMethodBeat.i(214177);
        b.h localh = new b.h(this, (byte)0);
        if ((this.bitField0_ & 0x1) != 0) {
          i = 1;
        }
        b.h.a(localh, this.efu);
        b.h.a(localh, i);
        onBuilt();
        AppMethodBeat.o(214177);
        return localh;
      }
      
      private a ao(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214193);
        paramf = (a)super.setField(paramf, paramObject);
        AppMethodBeat.o(214193);
        return paramf;
      }
      
      private a ap(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214257);
        paramf = (a)super.addRepeatedField(paramf, paramObject);
        AppMethodBeat.o(214257);
        return paramf;
      }
      
      private a aq(dn paramdn)
      {
        AppMethodBeat.i(214305);
        paramdn = (a)super.setUnknownFields(paramdn);
        AppMethodBeat.o(214305);
        return paramdn;
      }
      
      private a ar(dn paramdn)
      {
        AppMethodBeat.i(214322);
        paramdn = (a)super.mergeUnknownFields(paramdn);
        AppMethodBeat.o(214322);
        return paramdn;
      }
      
      public final a c(b.h paramh)
      {
        AppMethodBeat.i(214402);
        if (paramh == b.h.ang())
        {
          AppMethodBeat.o(214402);
          return this;
        }
        if (paramh.ane())
        {
          this.bitField0_ |= 0x1;
          this.efu = b.h.a(paramh);
          onChanged();
        }
        ar(b.h.b(paramh));
        onChanged();
        AppMethodBeat.o(214402);
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        AppMethodBeat.i(214382);
        am.a locala = b.alK();
        AppMethodBeat.o(214382);
        return locala;
      }
      
      public final bg.e internalGetFieldAccessorTable()
      {
        AppMethodBeat.i(214369);
        bg.e locale = b.alL().b(b.h.class, a.class);
        AppMethodBeat.o(214369);
        return locale;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class i
    extends bg
    implements k
  {
    @Deprecated
    public static final cs<i> PARSER;
    private static final i efx;
    private int bitField0_;
    com.google.d.h efw;
    private byte memoizedIsInitialized = -1;
    
    static
    {
      AppMethodBeat.i(214438);
      efx = new i();
      PARSER = new com.google.d.c() {};
      AppMethodBeat.o(214438);
    }
    
    private i()
    {
      this.efw = com.google.d.h.dIJ;
    }
    
    private i(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private i(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 37	com/tencent/ilink/tdi/b$i:<init>	()V
      //   4: ldc 69
      //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_2
      //   10: ifnonnull +18 -> 28
      //   13: new 71	java/lang/NullPointerException
      //   16: dup
      //   17: invokespecial 72	java/lang/NullPointerException:<init>	()V
      //   20: astore_1
      //   21: ldc 69
      //   23: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: aload_1
      //   27: athrow
      //   28: invokestatic 78	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +109 -> 145
      //   39: aload_1
      //   40: invokevirtual 84	com/google/d/i:aac	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+139->186, 0:+142->189, 10:+43->90
      //   73: aload_1
      //   74: aload 5
      //   76: aload_2
      //   77: iload 4
      //   79: invokevirtual 88	com/tencent/ilink/tdi/b$i:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   82: ifne -47 -> 35
      //   85: iconst_1
      //   86: istore_3
      //   87: goto -52 -> 35
      //   90: aload_0
      //   91: aload_0
      //   92: getfield 90	com/tencent/ilink/tdi/b$i:bitField0_	I
      //   95: iconst_1
      //   96: ior
      //   97: putfield 90	com/tencent/ilink/tdi/b$i:bitField0_	I
      //   100: aload_0
      //   101: aload_1
      //   102: invokevirtual 94	com/google/d/i:aak	()Lcom/google/d/h;
      //   105: putfield 56	com/tencent/ilink/tdi/b$i:efw	Lcom/google/d/h;
      //   108: goto -73 -> 35
      //   111: astore_1
      //   112: aload_1
      //   113: aload_0
      //   114: putfield 98	com/google/d/bk:dST	Lcom/google/d/ce;
      //   117: ldc 69
      //   119: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   122: aload_1
      //   123: athrow
      //   124: astore_1
      //   125: aload_0
      //   126: aload 5
      //   128: invokevirtual 104	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   131: putfield 108	com/tencent/ilink/tdi/b$i:unknownFields	Lcom/google/d/dn;
      //   134: aload_0
      //   135: invokevirtual 111	com/tencent/ilink/tdi/b$i:makeExtensionsImmutable	()V
      //   138: ldc 69
      //   140: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   143: aload_1
      //   144: athrow
      //   145: aload_0
      //   146: aload 5
      //   148: invokevirtual 104	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   151: putfield 108	com/tencent/ilink/tdi/b$i:unknownFields	Lcom/google/d/dn;
      //   154: aload_0
      //   155: invokevirtual 111	com/tencent/ilink/tdi/b$i:makeExtensionsImmutable	()V
      //   158: ldc 69
      //   160: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   163: return
      //   164: astore_1
      //   165: new 66	com/google/d/bk
      //   168: dup
      //   169: aload_1
      //   170: invokespecial 114	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   173: astore_1
      //   174: aload_1
      //   175: aload_0
      //   176: putfield 98	com/google/d/bk:dST	Lcom/google/d/ce;
      //   179: ldc 69
      //   181: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   184: aload_1
      //   185: athrow
      //   186: goto -114 -> 72
      //   189: iconst_1
      //   190: istore_3
      //   191: goto -156 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	194	0	this	i
      //   0	194	1	parami	com.google.d.i
      //   0	194	2	paramat	com.google.d.at
      //   34	157	3	i	int
      //   43	35	4	j	int
      //   31	116	5	locala	com.google.d.dn.a
      // Exception table:
      //   from	to	target	type
      //   39	45	111	com/google/d/bk
      //   72	85	111	com/google/d/bk
      //   90	108	111	com/google/d/bk
      //   39	45	124	finally
      //   72	85	124	finally
      //   90	108	124	finally
      //   112	124	124	finally
      //   165	186	124	finally
      //   39	45	164	java/io/IOException
      //   72	85	164	java/io/IOException
      //   90	108	164	java/io/IOException
    }
    
    public static i R(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(214355);
      paramArrayOfByte = (i)PARSER.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(214355);
      return paramArrayOfByte;
    }
    
    private a anm()
    {
      AppMethodBeat.i(214364);
      if (this == efx)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(214364);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(214364);
      return locala;
    }
    
    public static i ann()
    {
      return efx;
    }
    
    public final boolean anl()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214539);
      if (paramObject == this)
      {
        AppMethodBeat.o(214539);
        return true;
      }
      if (!(paramObject instanceof i))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(214539);
        return bool;
      }
      paramObject = (i)paramObject;
      if (anl() != paramObject.anl())
      {
        AppMethodBeat.o(214539);
        return false;
      }
      if ((anl()) && (!this.efw.equals(paramObject.efw)))
      {
        AppMethodBeat.o(214539);
        return false;
      }
      if (!this.unknownFields.equals(paramObject.unknownFields))
      {
        AppMethodBeat.o(214539);
        return false;
      }
      AppMethodBeat.o(214539);
      return true;
    }
    
    public final cs<i> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(214523);
      int i = this.memoizedSize;
      if (i != -1)
      {
        AppMethodBeat.o(214523);
        return i;
      }
      i = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        i = com.google.d.k.c(1, this.efw) + 0;
      }
      i += this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      AppMethodBeat.o(214523);
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(214549);
      if (this.memoizedHashCode != 0)
      {
        i = this.memoizedHashCode;
        AppMethodBeat.o(214549);
        return i;
      }
      int j = b.alU().hashCode() + 779;
      int i = j;
      if (anl()) {
        i = (j * 37 + 1) * 53 + this.efw.hashCode();
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      AppMethodBeat.o(214549);
      return i;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(214474);
      bg.e locale = b.alV().b(i.class, a.class);
      AppMethodBeat.o(214474);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final Object newInstance(bg.f paramf)
    {
      AppMethodBeat.i(214449);
      paramf = new i();
      AppMethodBeat.o(214449);
      return paramf;
    }
    
    public final void writeTo(com.google.d.k paramk)
    {
      AppMethodBeat.i(214508);
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.a(1, this.efw);
      }
      this.unknownFields.writeTo(paramk);
      AppMethodBeat.o(214508);
    }
    
    public static final class a
      extends bg.a<a>
      implements k
    {
      private int bitField0_;
      private com.google.d.h efw;
      
      private a()
      {
        AppMethodBeat.i(213930);
        this.efw = com.google.d.h.dIJ;
        b.i.ano();
        AppMethodBeat.o(213930);
      }
      
      private a(bg.b paramb)
      {
        super();
        AppMethodBeat.i(213939);
        this.efw = com.google.d.h.dIJ;
        b.i.ano();
        AppMethodBeat.o(213939);
      }
      
      private a H(am.f paramf, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(213997);
        paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
        AppMethodBeat.o(213997);
        return paramf;
      }
      
      /* Error */
      private a H(com.google.d.i parami, com.google.d.at paramat)
      {
        // Byte code:
        //   0: ldc 61
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 65	com/tencent/ilink/tdi/b$i:PARSER	Lcom/google/d/cs;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 71 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$i
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 75	com/tencent/ilink/tdi/b$i$a:b	(Lcom/tencent/ilink/tdi/b$i;)Lcom/tencent/ilink/tdi/b$i$a;
        //   30: pop
        //   31: ldc 61
        //   33: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 79	com/google/d/bk:dST	Lcom/google/d/ce;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$i
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 83	com/google/d/bk:aii	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 61
        //   54: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 75	com/tencent/ilink/tdi/b$i$a:b	(Lcom/tencent/ilink/tdi/b$i;)Lcom/tencent/ilink/tdi/b$i$a;
        //   69: pop
        //   70: ldc 61
        //   72: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: aload_1
        //   76: athrow
        //   77: astore_1
        //   78: aload_3
        //   79: astore_2
        //   80: goto -20 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	parami	com.google.d.i
        //   0	83	2	paramat	com.google.d.at
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/d/bk
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private a I(cb paramcb)
      {
        AppMethodBeat.i(214010);
        if ((paramcb instanceof b.i))
        {
          paramcb = b((b.i)paramcb);
          AppMethodBeat.o(214010);
          return paramcb;
        }
        super.mergeFrom(paramcb);
        AppMethodBeat.o(214010);
        return this;
      }
      
      private a L(am.j paramj)
      {
        AppMethodBeat.i(213989);
        paramj = (a)super.clearOneof(paramj);
        AppMethodBeat.o(213989);
        return paramj;
      }
      
      private a P(am.f paramf)
      {
        AppMethodBeat.i(213982);
        paramf = (a)super.clearField(paramf);
        AppMethodBeat.o(213982);
        return paramf;
      }
      
      private a anp()
      {
        AppMethodBeat.i(213947);
        super.clear();
        this.efw = com.google.d.h.dIJ;
        this.bitField0_ &= 0xFFFFFFFE;
        AppMethodBeat.o(213947);
        return this;
      }
      
      private b.i anq()
      {
        AppMethodBeat.i(213954);
        Object localObject = ans();
        if (!((b.i)localObject).isInitialized())
        {
          localObject = newUninitializedMessageException((cb)localObject);
          AppMethodBeat.o(213954);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(213954);
        return localObject;
      }
      
      private b.i ans()
      {
        int i = 0;
        AppMethodBeat.i(213966);
        b.i locali = new b.i(this, (byte)0);
        if ((this.bitField0_ & 0x1) != 0) {
          i = 1;
        }
        b.i.a(locali, this.efw);
        b.i.a(locali, i);
        onBuilt();
        AppMethodBeat.o(213966);
        return locali;
      }
      
      private a aq(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(213973);
        paramf = (a)super.setField(paramf, paramObject);
        AppMethodBeat.o(213973);
        return paramf;
      }
      
      private a ar(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214002);
        paramf = (a)super.addRepeatedField(paramf, paramObject);
        AppMethodBeat.o(214002);
        return paramf;
      }
      
      private a as(dn paramdn)
      {
        AppMethodBeat.i(214045);
        paramdn = (a)super.setUnknownFields(paramdn);
        AppMethodBeat.o(214045);
        return paramdn;
      }
      
      private a at(dn paramdn)
      {
        AppMethodBeat.i(214056);
        paramdn = (a)super.mergeUnknownFields(paramdn);
        AppMethodBeat.o(214056);
        return paramdn;
      }
      
      private a r(com.google.d.h paramh)
      {
        AppMethodBeat.i(214035);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(214035);
          throw paramh;
        }
        this.bitField0_ |= 0x1;
        this.efw = paramh;
        onChanged();
        AppMethodBeat.o(214035);
        return this;
      }
      
      public final a b(b.i parami)
      {
        AppMethodBeat.i(214104);
        if (parami == b.i.ann())
        {
          AppMethodBeat.o(214104);
          return this;
        }
        if (parami.anl()) {
          r(parami.efw);
        }
        at(b.i.a(parami));
        onChanged();
        AppMethodBeat.o(214104);
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        AppMethodBeat.i(214091);
        am.a locala = b.alU();
        AppMethodBeat.o(214091);
        return locala;
      }
      
      public final bg.e internalGetFieldAccessorTable()
      {
        AppMethodBeat.i(214085);
        bg.e locale = b.alV().b(b.i.class, a.class);
        AppMethodBeat.o(214085);
        return locale;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class j
    extends bg
    implements l
  {
    @Deprecated
    public static final cs<j> PARSER;
    private static final j efB;
    private int bitField0_;
    int efA;
    int efy;
    com.google.d.h efz;
    private byte memoizedIsInitialized = -1;
    
    static
    {
      AppMethodBeat.i(214450);
      efB = new j();
      PARSER = new com.google.d.c() {};
      AppMethodBeat.o(214450);
    }
    
    private j()
    {
      this.efz = com.google.d.h.dIJ;
    }
    
    private j(bg.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private j(com.google.d.i parami, com.google.d.at paramat)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 40	com/tencent/ilink/tdi/b$j:<init>	()V
      //   4: ldc 72
      //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_2
      //   10: ifnonnull +18 -> 28
      //   13: new 74	java/lang/NullPointerException
      //   16: dup
      //   17: invokespecial 75	java/lang/NullPointerException:<init>	()V
      //   20: astore_1
      //   21: ldc 72
      //   23: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   26: aload_1
      //   27: athrow
      //   28: invokestatic 81	com/google/d/dn:ajE	()Lcom/google/d/dn$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +189 -> 225
      //   39: aload_1
      //   40: invokevirtual 87	com/google/d/i:aac	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+197->244, 0:+200->247, 8:+59->106, 18:+114->161, 24:+157->204
      //   89: aload_1
      //   90: aload 5
      //   92: aload_2
      //   93: iload 4
      //   95: invokevirtual 91	com/tencent/ilink/tdi/b$j:parseUnknownField	(Lcom/google/d/i;Lcom/google/d/dn$a;Lcom/google/d/at;I)Z
      //   98: ifne -63 -> 35
      //   101: iconst_1
      //   102: istore_3
      //   103: goto -68 -> 35
      //   106: aload_0
      //   107: aload_0
      //   108: getfield 93	com/tencent/ilink/tdi/b$j:bitField0_	I
      //   111: iconst_1
      //   112: ior
      //   113: putfield 93	com/tencent/ilink/tdi/b$j:bitField0_	I
      //   116: aload_0
      //   117: aload_1
      //   118: invokevirtual 96	com/google/d/i:aal	()I
      //   121: putfield 98	com/tencent/ilink/tdi/b$j:efy	I
      //   124: goto -89 -> 35
      //   127: astore_1
      //   128: aload_1
      //   129: aload_0
      //   130: putfield 102	com/google/d/bk:dST	Lcom/google/d/ce;
      //   133: ldc 72
      //   135: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   138: aload_1
      //   139: athrow
      //   140: astore_1
      //   141: aload_0
      //   142: aload 5
      //   144: invokevirtual 108	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   147: putfield 112	com/tencent/ilink/tdi/b$j:unknownFields	Lcom/google/d/dn;
      //   150: aload_0
      //   151: invokevirtual 115	com/tencent/ilink/tdi/b$j:makeExtensionsImmutable	()V
      //   154: ldc 72
      //   156: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   159: aload_1
      //   160: athrow
      //   161: aload_0
      //   162: aload_0
      //   163: getfield 93	com/tencent/ilink/tdi/b$j:bitField0_	I
      //   166: iconst_2
      //   167: ior
      //   168: putfield 93	com/tencent/ilink/tdi/b$j:bitField0_	I
      //   171: aload_0
      //   172: aload_1
      //   173: invokevirtual 119	com/google/d/i:aak	()Lcom/google/d/h;
      //   176: putfield 59	com/tencent/ilink/tdi/b$j:efz	Lcom/google/d/h;
      //   179: goto -144 -> 35
      //   182: astore_1
      //   183: new 69	com/google/d/bk
      //   186: dup
      //   187: aload_1
      //   188: invokespecial 122	com/google/d/bk:<init>	(Ljava/io/IOException;)V
      //   191: astore_1
      //   192: aload_1
      //   193: aload_0
      //   194: putfield 102	com/google/d/bk:dST	Lcom/google/d/ce;
      //   197: ldc 72
      //   199: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   202: aload_1
      //   203: athrow
      //   204: aload_0
      //   205: aload_0
      //   206: getfield 93	com/tencent/ilink/tdi/b$j:bitField0_	I
      //   209: iconst_4
      //   210: ior
      //   211: putfield 93	com/tencent/ilink/tdi/b$j:bitField0_	I
      //   214: aload_0
      //   215: aload_1
      //   216: invokevirtual 125	com/google/d/i:aaf	()I
      //   219: putfield 127	com/tencent/ilink/tdi/b$j:efA	I
      //   222: goto -187 -> 35
      //   225: aload_0
      //   226: aload 5
      //   228: invokevirtual 108	com/google/d/dn$a:ajH	()Lcom/google/d/dn;
      //   231: putfield 112	com/tencent/ilink/tdi/b$j:unknownFields	Lcom/google/d/dn;
      //   234: aload_0
      //   235: invokevirtual 115	com/tencent/ilink/tdi/b$j:makeExtensionsImmutable	()V
      //   238: ldc 72
      //   240: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   243: return
      //   244: goto -156 -> 88
      //   247: iconst_1
      //   248: istore_3
      //   249: goto -214 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	252	0	this	j
      //   0	252	1	parami	com.google.d.i
      //   0	252	2	paramat	com.google.d.at
      //   34	215	3	i	int
      //   43	51	4	j	int
      //   31	196	5	locala	com.google.d.dn.a
      // Exception table:
      //   from	to	target	type
      //   39	45	127	com/google/d/bk
      //   88	101	127	com/google/d/bk
      //   106	124	127	com/google/d/bk
      //   161	179	127	com/google/d/bk
      //   204	222	127	com/google/d/bk
      //   39	45	140	finally
      //   88	101	140	finally
      //   106	124	140	finally
      //   128	140	140	finally
      //   161	179	140	finally
      //   183	204	140	finally
      //   204	222	140	finally
      //   39	45	182	java/io/IOException
      //   88	101	182	java/io/IOException
      //   106	124	182	java/io/IOException
      //   161	179	182	java/io/IOException
      //   204	222	182	java/io/IOException
    }
    
    public static j S(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(214337);
      paramArrayOfByte = (j)PARSER.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(214337);
      return paramArrayOfByte;
    }
    
    private a anw()
    {
      AppMethodBeat.i(214352);
      if (this == efB)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(214352);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(214352);
      return locala;
    }
    
    public static j anx()
    {
      return efB;
    }
    
    public final boolean ant()
    {
      return (this.bitField0_ & 0x1) != 0;
    }
    
    public final boolean anu()
    {
      return (this.bitField0_ & 0x2) != 0;
    }
    
    public final boolean anv()
    {
      return (this.bitField0_ & 0x4) != 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214608);
      if (paramObject == this)
      {
        AppMethodBeat.o(214608);
        return true;
      }
      if (!(paramObject instanceof j))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(214608);
        return bool;
      }
      paramObject = (j)paramObject;
      if (ant() != paramObject.ant())
      {
        AppMethodBeat.o(214608);
        return false;
      }
      if ((ant()) && (this.efy != paramObject.efy))
      {
        AppMethodBeat.o(214608);
        return false;
      }
      if (anu() != paramObject.anu())
      {
        AppMethodBeat.o(214608);
        return false;
      }
      if ((anu()) && (!this.efz.equals(paramObject.efz)))
      {
        AppMethodBeat.o(214608);
        return false;
      }
      if (anv() != paramObject.anv())
      {
        AppMethodBeat.o(214608);
        return false;
      }
      if ((anv()) && (this.efA != paramObject.efA))
      {
        AppMethodBeat.o(214608);
        return false;
      }
      if (!this.unknownFields.equals(paramObject.unknownFields))
      {
        AppMethodBeat.o(214608);
        return false;
      }
      AppMethodBeat.o(214608);
      return true;
    }
    
    public final cs<j> getParserForType()
    {
      return PARSER;
    }
    
    public final int getSerializedSize()
    {
      AppMethodBeat.i(214574);
      int i = this.memoizedSize;
      if (i != -1)
      {
        AppMethodBeat.o(214574);
        return i;
      }
      int j = 0;
      if ((this.bitField0_ & 0x1) != 0) {
        j = com.google.d.k.cK(1, this.efy) + 0;
      }
      i = j;
      if ((this.bitField0_ & 0x2) != 0) {
        i = j + com.google.d.k.c(2, this.efz);
      }
      j = i;
      if ((this.bitField0_ & 0x4) != 0) {
        j = i + com.google.d.k.cJ(3, this.efA);
      }
      i = j + this.unknownFields.getSerializedSize();
      this.memoizedSize = i;
      AppMethodBeat.o(214574);
      return i;
    }
    
    public final dn getUnknownFields()
    {
      return this.unknownFields;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(214624);
      if (this.memoizedHashCode != 0)
      {
        i = this.memoizedHashCode;
        AppMethodBeat.o(214624);
        return i;
      }
      int j = b.alI().hashCode() + 779;
      int i = j;
      if (ant()) {
        i = (j * 37 + 1) * 53 + this.efy;
      }
      j = i;
      if (anu()) {
        j = (i * 37 + 2) * 53 + this.efz.hashCode();
      }
      i = j;
      if (anv()) {
        i = (j * 37 + 3) * 53 + this.efA;
      }
      i = i * 29 + this.unknownFields.hashCode();
      this.memoizedHashCode = i;
      AppMethodBeat.o(214624);
      return i;
    }
    
    public final bg.e internalGetFieldAccessorTable()
    {
      AppMethodBeat.i(214505);
      bg.e locale = b.alJ().b(j.class, a.class);
      AppMethodBeat.o(214505);
      return locale;
    }
    
    public final boolean isInitialized()
    {
      int i = this.memoizedIsInitialized;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.memoizedIsInitialized = 1;
      return true;
    }
    
    public final Object newInstance(bg.f paramf)
    {
      AppMethodBeat.i(214461);
      paramf = new j();
      AppMethodBeat.o(214461);
      return paramf;
    }
    
    public final void writeTo(com.google.d.k paramk)
    {
      AppMethodBeat.i(214562);
      if ((this.bitField0_ & 0x1) != 0) {
        paramk.cG(1, this.efy);
      }
      if ((this.bitField0_ & 0x2) != 0) {
        paramk.a(2, this.efz);
      }
      if ((this.bitField0_ & 0x4) != 0) {
        paramk.cF(3, this.efA);
      }
      this.unknownFields.writeTo(paramk);
      AppMethodBeat.o(214562);
    }
    
    public static final class a
      extends bg.a<a>
      implements l
    {
      private int bitField0_;
      private int efA;
      private int efy;
      private com.google.d.h efz;
      
      private a()
      {
        AppMethodBeat.i(214084);
        this.efz = com.google.d.h.dIJ;
        b.j.any();
        AppMethodBeat.o(214084);
      }
      
      private a(bg.b paramb)
      {
        super();
        AppMethodBeat.i(214100);
        this.efz = com.google.d.h.dIJ;
        b.j.any();
        AppMethodBeat.o(214100);
      }
      
      private a I(am.f paramf, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(214208);
        paramf = (a)super.setRepeatedField(paramf, paramInt, paramObject);
        AppMethodBeat.o(214208);
        return paramf;
      }
      
      /* Error */
      private a I(com.google.d.i parami, com.google.d.at paramat)
      {
        // Byte code:
        //   0: ldc 63
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 67	com/tencent/ilink/tdi/b$j:PARSER	Lcom/google/d/cs;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 73 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$j
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 77	com/tencent/ilink/tdi/b$j$a:b	(Lcom/tencent/ilink/tdi/b$j;)Lcom/tencent/ilink/tdi/b$j$a;
        //   30: pop
        //   31: ldc 63
        //   33: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 81	com/google/d/bk:dST	Lcom/google/d/ce;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$j
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 85	com/google/d/bk:aii	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 63
        //   54: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 77	com/tencent/ilink/tdi/b$j$a:b	(Lcom/tencent/ilink/tdi/b$j;)Lcom/tencent/ilink/tdi/b$j$a;
        //   69: pop
        //   70: ldc 63
        //   72: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   75: aload_1
        //   76: athrow
        //   77: astore_1
        //   78: aload_3
        //   79: astore_2
        //   80: goto -20 -> 60
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	parami	com.google.d.i
        //   0	83	2	paramat	com.google.d.at
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/d/bk
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private a J(cb paramcb)
      {
        AppMethodBeat.i(214243);
        if ((paramcb instanceof b.j))
        {
          paramcb = b((b.j)paramcb);
          AppMethodBeat.o(214243);
          return paramcb;
        }
        super.mergeFrom(paramcb);
        AppMethodBeat.o(214243);
        return this;
      }
      
      private a M(am.j paramj)
      {
        AppMethodBeat.i(214194);
        paramj = (a)super.clearOneof(paramj);
        AppMethodBeat.o(214194);
        return paramj;
      }
      
      private a Q(am.f paramf)
      {
        AppMethodBeat.i(214176);
        paramf = (a)super.clearField(paramf);
        AppMethodBeat.o(214176);
        return paramf;
      }
      
      private b.j anA()
      {
        AppMethodBeat.i(214127);
        Object localObject = anB();
        if (!((b.j)localObject).isInitialized())
        {
          localObject = newUninitializedMessageException((cb)localObject);
          AppMethodBeat.o(214127);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(214127);
        return localObject;
      }
      
      private b.j anB()
      {
        int j = 0;
        AppMethodBeat.i(214143);
        b.j localj = new b.j(this, (byte)0);
        int k = this.bitField0_;
        if ((k & 0x1) != 0)
        {
          b.j.a(localj, this.efy);
          j = 1;
        }
        int i = j;
        if ((k & 0x2) != 0) {
          i = j | 0x2;
        }
        b.j.a(localj, this.efz);
        j = i;
        if ((k & 0x4) != 0)
        {
          b.j.b(localj, this.efA);
          j = i | 0x4;
        }
        b.j.c(localj, j);
        onBuilt();
        AppMethodBeat.o(214143);
        return localj;
      }
      
      private a anz()
      {
        AppMethodBeat.i(214114);
        super.clear();
        this.efy = 0;
        this.bitField0_ &= 0xFFFFFFFE;
        this.efz = com.google.d.h.dIJ;
        this.bitField0_ &= 0xFFFFFFFD;
        this.efA = 0;
        this.bitField0_ &= 0xFFFFFFFB;
        AppMethodBeat.o(214114);
        return this;
      }
      
      private a as(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214158);
        paramf = (a)super.setField(paramf, paramObject);
        AppMethodBeat.o(214158);
        return paramf;
      }
      
      private a at(am.f paramf, Object paramObject)
      {
        AppMethodBeat.i(214226);
        paramf = (a)super.addRepeatedField(paramf, paramObject);
        AppMethodBeat.o(214226);
        return paramf;
      }
      
      private a au(dn paramdn)
      {
        AppMethodBeat.i(214321);
        paramdn = (a)super.setUnknownFields(paramdn);
        AppMethodBeat.o(214321);
        return paramdn;
      }
      
      private a av(dn paramdn)
      {
        AppMethodBeat.i(214339);
        paramdn = (a)super.mergeUnknownFields(paramdn);
        AppMethodBeat.o(214339);
        return paramdn;
      }
      
      private a mg(int paramInt)
      {
        AppMethodBeat.i(214276);
        this.bitField0_ |= 0x1;
        this.efy = paramInt;
        onChanged();
        AppMethodBeat.o(214276);
        return this;
      }
      
      private a mh(int paramInt)
      {
        AppMethodBeat.i(214304);
        this.bitField0_ |= 0x4;
        this.efA = paramInt;
        onChanged();
        AppMethodBeat.o(214304);
        return this;
      }
      
      private a s(com.google.d.h paramh)
      {
        AppMethodBeat.i(214286);
        if (paramh == null)
        {
          paramh = new NullPointerException();
          AppMethodBeat.o(214286);
          throw paramh;
        }
        this.bitField0_ |= 0x2;
        this.efz = paramh;
        onChanged();
        AppMethodBeat.o(214286);
        return this;
      }
      
      public final a b(b.j paramj)
      {
        AppMethodBeat.i(214419);
        if (paramj == b.j.anx())
        {
          AppMethodBeat.o(214419);
          return this;
        }
        if (paramj.ant()) {
          mg(paramj.efy);
        }
        if (paramj.anu()) {
          s(paramj.efz);
        }
        if (paramj.anv()) {
          mh(paramj.efA);
        }
        av(b.j.a(paramj));
        onChanged();
        AppMethodBeat.o(214419);
        return this;
      }
      
      public final am.a getDescriptorForType()
      {
        AppMethodBeat.i(214399);
        am.a locala = b.alI();
        AppMethodBeat.o(214399);
        return locala;
      }
      
      public final bg.e internalGetFieldAccessorTable()
      {
        AppMethodBeat.i(214381);
        bg.e locale = b.alJ().b(b.j.class, a.class);
        AppMethodBeat.o(214381);
        return locale;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.ilink.tdi.b
 * JD-Core Version:    0.7.0.1
 */