package com.tencent.ilink.tdi;

import com.google.b.aj.a;
import com.google.b.aj.f;
import com.google.b.aj.g;
import com.google.b.bb;
import com.google.b.bb.a;
import com.google.b.bb.b;
import com.google.b.bb.e;
import com.google.b.be;
import com.google.b.bt;
import com.google.b.ci;
import com.google.b.da;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class b
{
  private static aj.g bQR;
  private static final aj.a cmZ;
  private static final bb.e cnA;
  private static final aj.a cnB;
  private static final bb.e cnC;
  private static final aj.a cnD;
  private static final bb.e cnE;
  private static final aj.a cnF;
  private static final bb.e cnG;
  private static final aj.a cnH;
  private static final bb.e cnI;
  private static final aj.a cnJ;
  private static final bb.e cnK;
  private static final aj.a cnL;
  private static final bb.e cnM;
  private static final aj.a cnN;
  private static final bb.e cnO;
  private static final aj.a cnP;
  private static final bb.e cnQ;
  private static final aj.a cnR;
  private static final bb.e cnS;
  private static final bb.e cna;
  private static final aj.a cnb;
  private static final bb.e cnc;
  private static final aj.a cnd;
  private static final bb.e cne;
  private static final aj.a cnf;
  private static final bb.e cng;
  private static final aj.a cnh;
  private static final bb.e cni;
  private static final aj.a cnj;
  private static final bb.e cnk;
  private static final aj.a cnl;
  private static final bb.e cnm;
  private static final aj.a cnn;
  private static final bb.e cno;
  private static final aj.a cnp;
  private static final bb.e cnq;
  private static final aj.a cnr;
  private static final bb.e cns;
  private static final aj.a cnt;
  private static final bb.e cnu;
  private static final aj.a cnv;
  private static final bb.e cnw;
  private static final aj.a cnx;
  private static final bb.e cny;
  private static final aj.a cnz;
  
  static
  {
    AppMethodBeat.i(217822);
    aj.g localg = a.Ls();
    localg = aj.g.a(new String[] { "" }, new aj.g[] { localg });
    bQR = localg;
    cmZ = (aj.a)localg.Hw().get(0);
    cna = new bb.e(cmZ, new String[] { "EnableLog", "EnableConsole", "LogLevel" });
    cnb = (aj.a)bQR.Hw().get(1);
    cnc = new bb.e(cnb, new String[] { "AppDir", "IlinkProductId", "IlinkSn", "IlinkId", "IlinkToken", "LogConfig", "IosIdfa" });
    cnd = (aj.a)bQR.Hw().get(2);
    cne = new bb.e(cnd, new String[] { "TimeoutMs", "RecoType", "EnvData", "RetryCount" });
    cnf = (aj.a)bQR.Hw().get(3);
    cng = new bb.e(cnf, new String[] { "ConfigData" });
    cnh = (aj.a)bQR.Hw().get(4);
    cni = new bb.e(cnh, new String[] { "TimeoutMs", "RecgType", "DataType", "FaceData", "WxbaseReq", "WxpayReq", "RetryCount" });
    cnj = (aj.a)bQR.Hw().get(5);
    cnk = new bb.e(cnj, new String[] { "WxbaseResp", "WxpayResp", "PassType" });
    cnl = (aj.a)bQR.Hw().get(6);
    cnm = new bb.e(cnl, new String[] { "TimeoutMs", "Type", "BusinessType", "BusinessReq", "RetryCount" });
    cnn = (aj.a)bQR.Hw().get(7);
    cno = new bb.e(cnn, new String[] { "Type", "PassType", "BusinessResp" });
    cnp = (aj.a)bQR.Hw().get(8);
    cnq = new bb.e(cnp, new String[] { "TimeoutMs", "BusinessReq", "AuthCode", "RetryCount", "SessionType", "Vendorid", "Lkid", "SecurityInfo" });
    cnr = (aj.a)bQR.Hw().get(9);
    cns = new bb.e(cnr, new String[] { "LoginType", "VerifyBuffer", "DetailRet" });
    cnt = (aj.a)bQR.Hw().get(10);
    cnu = new bb.e(cnt, new String[] { "QrcodeVerifyScene", "ConfirmBusinessInfo" });
    cnv = (aj.a)bQR.Hw().get(11);
    cnw = new bb.e(cnv, new String[] { "Path" });
    cnx = (aj.a)bQR.Hw().get(12);
    cny = new bb.e(cnx, new String[] { "Status", "Uin", "Nickname", "AvatarUrl", "BusinessConfirmRespBuffer" });
    cnz = (aj.a)bQR.Hw().get(13);
    cnA = new bb.e(cnz, new String[] { "LoginStatus", "LoginType", "Uin", "Username", "LoginScene" });
    cnB = (aj.a)bQR.Hw().get(14);
    cnC = new bb.e(cnB, new String[] { "Cmdid", "CryptoAlgo", "TimeoutMs", "Url", "Body", "NetType", "RetryCount", "LimitFlow", "LimitFrequency" });
    cnD = (aj.a)bQR.Hw().get(15);
    cnE = new bb.e(cnD, new String[] { "Body" });
    cnF = (aj.a)bQR.Hw().get(16);
    cnG = new bb.e(cnF, new String[] { "Msgid", "CreateTime", "Body" });
    cnH = (aj.a)bQR.Hw().get(17);
    cnI = new bb.e(cnH, new String[] { "Token", "ExpireTimestamp" });
    cnJ = (aj.a)bQR.Hw().get(18);
    cnK = new bb.e(cnJ, new String[] { "IlinkAppid" });
    cnL = (aj.a)bQR.Hw().get(19);
    cnM = new bb.e(cnL, new String[] { "OauthCode" });
    cnN = (aj.a)bQR.Hw().get(20);
    cnO = new bb.e(cnN, new String[] { "IlinkAppidList" });
    cnP = (aj.a)bQR.Hw().get(21);
    cnQ = new bb.e(cnP, new String[] { "Body" });
    cnR = (aj.a)bQR.Hw().get(22);
    cnS = new bb.e(cnR, new String[] { "Body" });
    a.Ls();
    AppMethodBeat.o(217822);
  }
  
  public static final class a
    extends bb
    implements c
  {
    @Deprecated
    public static final ci<a> bRf;
    private static final a cnW;
    private int bQS;
    private byte bRd = -1;
    long cnT;
    long cnU;
    com.google.b.g cnV;
    
    static
    {
      AppMethodBeat.i(218132);
      cnW = new a();
      bRf = new com.google.b.c() {};
      AppMethodBeat.o(218132);
    }
    
    private a()
    {
      this.cnV = com.google.b.g.bPf;
    }
    
    private a(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private a(com.google.b.h paramh, com.google.b.ap paramap)
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
      //   28: invokestatic 81	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +189 -> 225
      //   39: aload_1
      //   40: invokevirtual 87	com/google/b/h:Av	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+197->244, 0:+200->247, 8:+59->106, 16:+114->161, 26:+157->204
      //   89: aload_1
      //   90: aload 5
      //   92: aload_2
      //   93: iload 4
      //   95: invokevirtual 90	com/tencent/ilink/tdi/b$a:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   98: ifne -63 -> 35
      //   101: iconst_1
      //   102: istore_3
      //   103: goto -68 -> 35
      //   106: aload_0
      //   107: aload_0
      //   108: getfield 92	com/tencent/ilink/tdi/b$a:bQS	I
      //   111: iconst_1
      //   112: ior
      //   113: putfield 92	com/tencent/ilink/tdi/b$a:bQS	I
      //   116: aload_0
      //   117: aload_1
      //   118: invokevirtual 96	com/google/b/h:Aw	()J
      //   121: putfield 98	com/tencent/ilink/tdi/b$a:cnT	J
      //   124: goto -89 -> 35
      //   127: astore_1
      //   128: aload_1
      //   129: aload_0
      //   130: putfield 102	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   133: ldc 72
      //   135: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   138: aload_1
      //   139: athrow
      //   140: astore_1
      //   141: aload_0
      //   142: aload 5
      //   144: invokevirtual 108	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   147: putfield 112	com/tencent/ilink/tdi/b$a:bVW	Lcom/google/b/da;
      //   150: aload_0
      //   151: invokevirtual 115	com/tencent/ilink/tdi/b$a:HZ	()V
      //   154: ldc 72
      //   156: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   159: aload_1
      //   160: athrow
      //   161: aload_0
      //   162: aload_0
      //   163: getfield 92	com/tencent/ilink/tdi/b$a:bQS	I
      //   166: iconst_2
      //   167: ior
      //   168: putfield 92	com/tencent/ilink/tdi/b$a:bQS	I
      //   171: aload_0
      //   172: aload_1
      //   173: invokevirtual 96	com/google/b/h:Aw	()J
      //   176: putfield 117	com/tencent/ilink/tdi/b$a:cnU	J
      //   179: goto -144 -> 35
      //   182: astore_1
      //   183: new 69	com/google/b/bf
      //   186: dup
      //   187: aload_1
      //   188: invokespecial 120	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   191: astore_1
      //   192: aload_1
      //   193: aload_0
      //   194: putfield 102	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   197: ldc 72
      //   199: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   202: aload_1
      //   203: athrow
      //   204: aload_0
      //   205: aload_0
      //   206: getfield 92	com/tencent/ilink/tdi/b$a:bQS	I
      //   209: iconst_4
      //   210: ior
      //   211: putfield 92	com/tencent/ilink/tdi/b$a:bQS	I
      //   214: aload_0
      //   215: aload_1
      //   216: invokevirtual 124	com/google/b/h:AD	()Lcom/google/b/g;
      //   219: putfield 59	com/tencent/ilink/tdi/b$a:cnV	Lcom/google/b/g;
      //   222: goto -187 -> 35
      //   225: aload_0
      //   226: aload 5
      //   228: invokevirtual 108	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   231: putfield 112	com/tencent/ilink/tdi/b$a:bVW	Lcom/google/b/da;
      //   234: aload_0
      //   235: invokevirtual 115	com/tencent/ilink/tdi/b$a:HZ	()V
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
      //   0	252	1	paramh	com.google.b.h
      //   0	252	2	paramap	com.google.b.ap
      //   34	215	3	i	int
      //   43	51	4	j	int
      //   31	196	5	locala	com.google.b.da.a
      // Exception table:
      //   from	to	target	type
      //   39	45	127	com/google/b/bf
      //   88	101	127	com/google/b/bf
      //   106	124	127	com/google/b/bf
      //   161	179	127	com/google/b/bf
      //   204	222	127	com/google/b/bf
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
    
    public static a K(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(218104);
      paramArrayOfByte = (a)bRf.w(paramArrayOfByte);
      AppMethodBeat.o(218104);
      return paramArrayOfByte;
    }
    
    private a LQ()
    {
      AppMethodBeat.i(218105);
      if (this == cnW)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(218105);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(218105);
      return locala;
    }
    
    public static a LR()
    {
      return cnW;
    }
    
    public final int Ad()
    {
      AppMethodBeat.i(218097);
      int i = this.bOZ;
      if (i != -1)
      {
        AppMethodBeat.o(218097);
        return i;
      }
      int j = 0;
      if ((this.bQS & 0x1) != 0) {
        j = com.google.b.i.q(1, this.cnT) + 0;
      }
      i = j;
      if ((this.bQS & 0x2) != 0) {
        i = j + com.google.b.i.q(2, this.cnU);
      }
      j = i;
      if ((this.bQS & 0x4) != 0) {
        j = i + com.google.b.i.c(3, this.cnV);
      }
      i = j + this.bVW.Ad();
      this.bOZ = i;
      AppMethodBeat.o(218097);
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(218085);
      bb.e locale = b.LI().b(a.class, a.class);
      AppMethodBeat.o(218085);
      return locale;
    }
    
    public final ci<a> Co()
    {
      return bRf;
    }
    
    public final boolean LN()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final boolean LO()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final boolean LP()
    {
      return (this.bQS & 0x4) != 0;
    }
    
    public final void a(com.google.b.i parami)
    {
      AppMethodBeat.i(218094);
      if ((this.bQS & 0x1) != 0) {
        parami.n(1, this.cnT);
      }
      if ((this.bQS & 0x2) != 0) {
        parami.n(2, this.cnU);
      }
      if ((this.bQS & 0x4) != 0) {
        parami.a(3, this.cnV);
      }
      this.bVW.a(parami);
      AppMethodBeat.o(218094);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(218101);
      if (paramObject == this)
      {
        AppMethodBeat.o(218101);
        return true;
      }
      if (!(paramObject instanceof a))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(218101);
        return bool;
      }
      paramObject = (a)paramObject;
      if (LN() != paramObject.LN())
      {
        AppMethodBeat.o(218101);
        return false;
      }
      if ((LN()) && (this.cnT != paramObject.cnT))
      {
        AppMethodBeat.o(218101);
        return false;
      }
      if (LO() != paramObject.LO())
      {
        AppMethodBeat.o(218101);
        return false;
      }
      if ((LO()) && (this.cnU != paramObject.cnU))
      {
        AppMethodBeat.o(218101);
        return false;
      }
      if (LP() != paramObject.LP())
      {
        AppMethodBeat.o(218101);
        return false;
      }
      if ((LP()) && (!this.cnV.equals(paramObject.cnV)))
      {
        AppMethodBeat.o(218101);
        return false;
      }
      if (!this.bVW.equals(paramObject.bVW))
      {
        AppMethodBeat.o(218101);
        return false;
      }
      AppMethodBeat.o(218101);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(218102);
      if (this.bPa != 0)
      {
        i = this.bPa;
        AppMethodBeat.o(218102);
        return i;
      }
      int j = b.LH().hashCode() + 779;
      int i = j;
      if (LN()) {
        i = (j * 37 + 1) * 53 + be.aJ(this.cnT);
      }
      j = i;
      if (LO()) {
        j = (i * 37 + 2) * 53 + be.aJ(this.cnU);
      }
      i = j;
      if (LP()) {
        i = (j * 37 + 3) * 53 + this.cnV.hashCode();
      }
      i = i * 29 + this.bVW.hashCode();
      this.bPa = i;
      AppMethodBeat.o(218102);
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
      implements c
    {
      private int bQS;
      private long cnT;
      private long cnU;
      private com.google.b.g cnV;
      
      private a()
      {
        AppMethodBeat.i(218225);
        this.cnV = com.google.b.g.bPf;
        b.a.LS();
        AppMethodBeat.o(218225);
      }
      
      private a(bb.b paramb)
      {
        super();
        AppMethodBeat.i(218229);
        this.cnV = com.google.b.g.bPf;
        b.a.LS();
        AppMethodBeat.o(218229);
      }
      
      private a C(bt parambt)
      {
        AppMethodBeat.i(218240);
        if ((parambt instanceof b.a))
        {
          parambt = b((b.a)parambt);
          AppMethodBeat.o(218240);
          return parambt;
        }
        super.a(parambt);
        AppMethodBeat.o(218240);
        return this;
      }
      
      /* Error */
      private a D(com.google.b.h paramh, com.google.b.ap paramap)
      {
        // Byte code:
        //   0: ldc 68
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 72	com/tencent/ilink/tdi/b$a:bRf	Lcom/google/b/ci;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 78 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$a
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 60	com/tencent/ilink/tdi/b$a$a:b	(Lcom/tencent/ilink/tdi/b$a;)Lcom/tencent/ilink/tdi/b$a$a;
        //   30: pop
        //   31: ldc 68
        //   33: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 82	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$a
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 86	com/google/b/bf:Im	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 68
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
        //   70: ldc 68
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
        //   0	83	1	paramh	com.google.b.h
        //   0	83	2	paramap	com.google.b.ap
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/b/bf
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private b.a LT()
      {
        AppMethodBeat.i(218232);
        Object localObject = LU();
        if (!((b.a)localObject).isInitialized())
        {
          localObject = b((bt)localObject);
          AppMethodBeat.o(218232);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(218232);
        return localObject;
      }
      
      private b.a LU()
      {
        int j = 0;
        AppMethodBeat.i(218234);
        b.a locala = new b.a(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0)
        {
          b.a.a(locala, this.cnT);
          j = 1;
        }
        int i = j;
        if ((k & 0x2) != 0)
        {
          b.a.b(locala, this.cnU);
          i = j | 0x2;
        }
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        b.a.a(locala, this.cnV);
        b.a.a(locala, j);
        Ib();
        AppMethodBeat.o(218234);
        return locala;
      }
      
      private a aZ(long paramLong)
      {
        AppMethodBeat.i(218246);
        this.bQS |= 0x1;
        this.cnT = paramLong;
        onChanged();
        AppMethodBeat.o(218246);
        return this;
      }
      
      private a ae(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(218236);
        paramf = (a)super.d(paramf, paramObject);
        AppMethodBeat.o(218236);
        return paramf;
      }
      
      private a af(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(218237);
        paramf = (a)super.c(paramf, paramObject);
        AppMethodBeat.o(218237);
        return paramf;
      }
      
      private a ag(da paramda)
      {
        AppMethodBeat.i(218252);
        paramda = (a)super.e(paramda);
        AppMethodBeat.o(218252);
        return paramda;
      }
      
      private a ah(da paramda)
      {
        AppMethodBeat.i(218254);
        paramda = (a)super.d(paramda);
        AppMethodBeat.o(218254);
        return paramda;
      }
      
      private a ba(long paramLong)
      {
        AppMethodBeat.i(218248);
        this.bQS |= 0x2;
        this.cnU = paramLong;
        onChanged();
        AppMethodBeat.o(218248);
        return this;
      }
      
      private a i(com.google.b.g paramg)
      {
        AppMethodBeat.i(218250);
        if (paramg == null)
        {
          paramg = new NullPointerException();
          AppMethodBeat.o(218250);
          throw paramg;
        }
        this.bQS |= 0x4;
        this.cnV = paramg;
        onChanged();
        AppMethodBeat.o(218250);
        return this;
      }
      
      public final bb.e Cb()
      {
        AppMethodBeat.i(218224);
        bb.e locale = b.LI().b(b.a.class, a.class);
        AppMethodBeat.o(218224);
        return locale;
      }
      
      public final aj.a Cv()
      {
        AppMethodBeat.i(218231);
        aj.a locala = b.LH();
        AppMethodBeat.o(218231);
        return locala;
      }
      
      public final a b(b.a parama)
      {
        AppMethodBeat.i(218241);
        if (parama == b.a.LR())
        {
          AppMethodBeat.o(218241);
          return this;
        }
        if (parama.LN()) {
          aZ(parama.cnT);
        }
        if (parama.LO()) {
          ba(parama.cnU);
        }
        if (parama.LP()) {
          i(parama.cnV);
        }
        ah(b.a.a(parama));
        onChanged();
        AppMethodBeat.o(218241);
        return this;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class b
    extends bb
    implements d
  {
    @Deprecated
    public static final ci<b> bRf;
    private static final b cnZ;
    private int bQS;
    private byte bRd = -1;
    com.google.b.g cnX;
    int cnY;
    
    static
    {
      AppMethodBeat.i(217497);
      cnZ = new b();
      bRf = new com.google.b.c() {};
      AppMethodBeat.o(217497);
    }
    
    private b()
    {
      this.cnX = com.google.b.g.bPf;
    }
    
    private b(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private b(com.google.b.h paramh, com.google.b.ap paramap)
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
      //   28: invokestatic 80	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +160 -> 196
      //   39: aload_1
      //   40: invokevirtual 86	com/google/b/h:Av	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+168->215, 0:+171->218, 10:+51->98, 16:+106->153
      //   81: aload_1
      //   82: aload 5
      //   84: aload_2
      //   85: iload 4
      //   87: invokevirtual 89	com/tencent/ilink/tdi/b$b:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   90: ifne -55 -> 35
      //   93: iconst_1
      //   94: istore_3
      //   95: goto -60 -> 35
      //   98: aload_0
      //   99: aload_0
      //   100: getfield 91	com/tencent/ilink/tdi/b$b:bQS	I
      //   103: iconst_1
      //   104: ior
      //   105: putfield 91	com/tencent/ilink/tdi/b$b:bQS	I
      //   108: aload_0
      //   109: aload_1
      //   110: invokevirtual 95	com/google/b/h:AD	()Lcom/google/b/g;
      //   113: putfield 58	com/tencent/ilink/tdi/b$b:cnX	Lcom/google/b/g;
      //   116: goto -81 -> 35
      //   119: astore_1
      //   120: aload_1
      //   121: aload_0
      //   122: putfield 99	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   125: ldc 71
      //   127: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   130: aload_1
      //   131: athrow
      //   132: astore_1
      //   133: aload_0
      //   134: aload 5
      //   136: invokevirtual 105	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   139: putfield 109	com/tencent/ilink/tdi/b$b:bVW	Lcom/google/b/da;
      //   142: aload_0
      //   143: invokevirtual 112	com/tencent/ilink/tdi/b$b:HZ	()V
      //   146: ldc 71
      //   148: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   151: aload_1
      //   152: athrow
      //   153: aload_0
      //   154: aload_0
      //   155: getfield 91	com/tencent/ilink/tdi/b$b:bQS	I
      //   158: iconst_2
      //   159: ior
      //   160: putfield 91	com/tencent/ilink/tdi/b$b:bQS	I
      //   163: aload_0
      //   164: aload_1
      //   165: invokevirtual 115	com/google/b/h:AE	()I
      //   168: putfield 117	com/tencent/ilink/tdi/b$b:cnY	I
      //   171: goto -136 -> 35
      //   174: astore_1
      //   175: new 68	com/google/b/bf
      //   178: dup
      //   179: aload_1
      //   180: invokespecial 120	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   183: astore_1
      //   184: aload_1
      //   185: aload_0
      //   186: putfield 99	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   189: ldc 71
      //   191: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   194: aload_1
      //   195: athrow
      //   196: aload_0
      //   197: aload 5
      //   199: invokevirtual 105	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   202: putfield 109	com/tencent/ilink/tdi/b$b:bVW	Lcom/google/b/da;
      //   205: aload_0
      //   206: invokevirtual 112	com/tencent/ilink/tdi/b$b:HZ	()V
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
      //   0	223	1	paramh	com.google.b.h
      //   0	223	2	paramap	com.google.b.ap
      //   34	186	3	i	int
      //   43	43	4	j	int
      //   31	167	5	locala	com.google.b.da.a
      // Exception table:
      //   from	to	target	type
      //   39	45	119	com/google/b/bf
      //   80	93	119	com/google/b/bf
      //   98	116	119	com/google/b/bf
      //   153	171	119	com/google/b/bf
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
    
    public static b L(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(217484);
      paramArrayOfByte = (b)bRf.w(paramArrayOfByte);
      AppMethodBeat.o(217484);
      return paramArrayOfByte;
    }
    
    private a LX()
    {
      AppMethodBeat.i(217485);
      if (this == cnZ)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(217485);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(217485);
      return locala;
    }
    
    public static b LY()
    {
      return cnZ;
    }
    
    public final int Ad()
    {
      AppMethodBeat.i(217478);
      int i = this.bOZ;
      if (i != -1)
      {
        AppMethodBeat.o(217478);
        return i;
      }
      i = 0;
      if ((this.bQS & 0x1) != 0) {
        i = com.google.b.i.c(1, this.cnX) + 0;
      }
      int j = i;
      if ((this.bQS & 0x2) != 0) {
        j = i + com.google.b.i.bN(2, this.cnY);
      }
      i = j + this.bVW.Ad();
      this.bOZ = i;
      AppMethodBeat.o(217478);
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(217475);
      bb.e locale = b.LK().b(b.class, a.class);
      AppMethodBeat.o(217475);
      return locale;
    }
    
    public final ci<b> Co()
    {
      return bRf;
    }
    
    public final boolean LV()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final boolean LW()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final void a(com.google.b.i parami)
    {
      AppMethodBeat.i(217477);
      if ((this.bQS & 0x1) != 0) {
        parami.a(1, this.cnX);
      }
      if ((this.bQS & 0x2) != 0) {
        parami.bK(2, this.cnY);
      }
      this.bVW.a(parami);
      AppMethodBeat.o(217477);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(217481);
      if (paramObject == this)
      {
        AppMethodBeat.o(217481);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(217481);
        return bool;
      }
      paramObject = (b)paramObject;
      if (LV() != paramObject.LV())
      {
        AppMethodBeat.o(217481);
        return false;
      }
      if ((LV()) && (!this.cnX.equals(paramObject.cnX)))
      {
        AppMethodBeat.o(217481);
        return false;
      }
      if (LW() != paramObject.LW())
      {
        AppMethodBeat.o(217481);
        return false;
      }
      if ((LW()) && (this.cnY != paramObject.cnY))
      {
        AppMethodBeat.o(217481);
        return false;
      }
      if (!this.bVW.equals(paramObject.bVW))
      {
        AppMethodBeat.o(217481);
        return false;
      }
      AppMethodBeat.o(217481);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(217482);
      if (this.bPa != 0)
      {
        i = this.bPa;
        AppMethodBeat.o(217482);
        return i;
      }
      int j = b.LJ().hashCode() + 779;
      int i = j;
      if (LV()) {
        i = (j * 37 + 1) * 53 + this.cnX.hashCode();
      }
      j = i;
      if (LW()) {
        j = (i * 37 + 2) * 53 + this.cnY;
      }
      i = j * 29 + this.bVW.hashCode();
      this.bPa = i;
      AppMethodBeat.o(217482);
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
      implements d
    {
      private int bQS;
      private com.google.b.g cnX;
      private int cnY;
      
      private a()
      {
        AppMethodBeat.i(217622);
        this.cnX = com.google.b.g.bPf;
        b.b.LZ();
        AppMethodBeat.o(217622);
      }
      
      private a(bb.b paramb)
      {
        super();
        AppMethodBeat.i(217624);
        this.cnX = com.google.b.g.bPf;
        b.b.LZ();
        AppMethodBeat.o(217624);
      }
      
      private a D(bt parambt)
      {
        AppMethodBeat.i(217631);
        if ((parambt instanceof b.b))
        {
          parambt = b((b.b)parambt);
          AppMethodBeat.o(217631);
          return parambt;
        }
        super.a(parambt);
        AppMethodBeat.o(217631);
        return this;
      }
      
      /* Error */
      private a E(com.google.b.h paramh, com.google.b.ap paramap)
      {
        // Byte code:
        //   0: ldc 66
        //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 70	com/tencent/ilink/tdi/b$b:bRf	Lcom/google/b/ci;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 76 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$b
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 58	com/tencent/ilink/tdi/b$b$a:b	(Lcom/tencent/ilink/tdi/b$b;)Lcom/tencent/ilink/tdi/b$b$a;
        //   30: pop
        //   31: ldc 66
        //   33: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 80	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$b
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 84	com/google/b/bf:Im	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 66
        //   54: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 58	com/tencent/ilink/tdi/b$b$a:b	(Lcom/tencent/ilink/tdi/b$b;)Lcom/tencent/ilink/tdi/b$b$a;
        //   69: pop
        //   70: ldc 66
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
        //   0	83	1	paramh	com.google.b.h
        //   0	83	2	paramap	com.google.b.ap
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/b/bf
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private b.b Ma()
      {
        AppMethodBeat.i(217626);
        Object localObject = Mb();
        if (!((b.b)localObject).isInitialized())
        {
          localObject = b((bt)localObject);
          AppMethodBeat.o(217626);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(217626);
        return localObject;
      }
      
      private b.b Mb()
      {
        int i = 0;
        AppMethodBeat.i(217627);
        b.b localb = new b.b(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0) {
          i = 1;
        }
        b.b.a(localb, this.cnX);
        int j = i;
        if ((k & 0x2) != 0)
        {
          b.b.a(localb, this.cnY);
          j = i | 0x2;
        }
        b.b.b(localb, j);
        Ib();
        AppMethodBeat.o(217627);
        return localb;
      }
      
      private a ag(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217628);
        paramf = (a)super.d(paramf, paramObject);
        AppMethodBeat.o(217628);
        return paramf;
      }
      
      private a ah(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217629);
        paramf = (a)super.c(paramf, paramObject);
        AppMethodBeat.o(217629);
        return paramf;
      }
      
      private a ai(da paramda)
      {
        AppMethodBeat.i(217642);
        paramda = (a)super.e(paramda);
        AppMethodBeat.o(217642);
        return paramda;
      }
      
      private a aj(da paramda)
      {
        AppMethodBeat.i(217645);
        paramda = (a)super.d(paramda);
        AppMethodBeat.o(217645);
        return paramda;
      }
      
      private a iA(int paramInt)
      {
        AppMethodBeat.i(217640);
        this.bQS |= 0x2;
        this.cnY = paramInt;
        onChanged();
        AppMethodBeat.o(217640);
        return this;
      }
      
      private a j(com.google.b.g paramg)
      {
        AppMethodBeat.i(217639);
        if (paramg == null)
        {
          paramg = new NullPointerException();
          AppMethodBeat.o(217639);
          throw paramg;
        }
        this.bQS |= 0x1;
        this.cnX = paramg;
        onChanged();
        AppMethodBeat.o(217639);
        return this;
      }
      
      public final bb.e Cb()
      {
        AppMethodBeat.i(217620);
        bb.e locale = b.LK().b(b.b.class, a.class);
        AppMethodBeat.o(217620);
        return locale;
      }
      
      public final aj.a Cv()
      {
        AppMethodBeat.i(217625);
        aj.a locala = b.LJ();
        AppMethodBeat.o(217625);
        return locala;
      }
      
      public final a b(b.b paramb)
      {
        AppMethodBeat.i(217633);
        if (paramb == b.b.LY())
        {
          AppMethodBeat.o(217633);
          return this;
        }
        if (paramb.LV()) {
          j(paramb.cnX);
        }
        if (paramb.LW()) {
          iA(paramb.cnY);
        }
        aj(b.b.a(paramb));
        onChanged();
        AppMethodBeat.o(217633);
        return this;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class c
    extends bb
    implements e
  {
    @Deprecated
    public static final ci<c> bRf;
    private static final c coa;
    private int bQS;
    private byte bRd = -1;
    com.google.b.g cnV;
    
    static
    {
      AppMethodBeat.i(218406);
      coa = new c();
      bRf = new com.google.b.c() {};
      AppMethodBeat.o(218406);
    }
    
    private c()
    {
      this.cnV = com.google.b.g.bPf;
    }
    
    private c(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private c(com.google.b.h paramh, com.google.b.ap paramap)
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
      //   28: invokestatic 79	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +109 -> 145
      //   39: aload_1
      //   40: invokevirtual 85	com/google/b/h:Av	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+139->186, 0:+142->189, 10:+43->90
      //   73: aload_1
      //   74: aload 5
      //   76: aload_2
      //   77: iload 4
      //   79: invokevirtual 88	com/tencent/ilink/tdi/b$c:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   82: ifne -47 -> 35
      //   85: iconst_1
      //   86: istore_3
      //   87: goto -52 -> 35
      //   90: aload_0
      //   91: aload_0
      //   92: getfield 90	com/tencent/ilink/tdi/b$c:bQS	I
      //   95: iconst_1
      //   96: ior
      //   97: putfield 90	com/tencent/ilink/tdi/b$c:bQS	I
      //   100: aload_0
      //   101: aload_1
      //   102: invokevirtual 94	com/google/b/h:AD	()Lcom/google/b/g;
      //   105: putfield 57	com/tencent/ilink/tdi/b$c:cnV	Lcom/google/b/g;
      //   108: goto -73 -> 35
      //   111: astore_1
      //   112: aload_1
      //   113: aload_0
      //   114: putfield 98	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   117: ldc 70
      //   119: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   122: aload_1
      //   123: athrow
      //   124: astore_1
      //   125: aload_0
      //   126: aload 5
      //   128: invokevirtual 104	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   131: putfield 108	com/tencent/ilink/tdi/b$c:bVW	Lcom/google/b/da;
      //   134: aload_0
      //   135: invokevirtual 111	com/tencent/ilink/tdi/b$c:HZ	()V
      //   138: ldc 70
      //   140: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   143: aload_1
      //   144: athrow
      //   145: aload_0
      //   146: aload 5
      //   148: invokevirtual 104	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   151: putfield 108	com/tencent/ilink/tdi/b$c:bVW	Lcom/google/b/da;
      //   154: aload_0
      //   155: invokevirtual 111	com/tencent/ilink/tdi/b$c:HZ	()V
      //   158: ldc 70
      //   160: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   163: return
      //   164: astore_1
      //   165: new 67	com/google/b/bf
      //   168: dup
      //   169: aload_1
      //   170: invokespecial 114	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   173: astore_1
      //   174: aload_1
      //   175: aload_0
      //   176: putfield 98	com/google/b/bf:bZj	Lcom/google/b/bw;
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
      //   0	194	1	paramh	com.google.b.h
      //   0	194	2	paramap	com.google.b.ap
      //   34	157	3	i	int
      //   43	35	4	j	int
      //   31	116	5	locala	com.google.b.da.a
      // Exception table:
      //   from	to	target	type
      //   39	45	111	com/google/b/bf
      //   72	85	111	com/google/b/bf
      //   90	108	111	com/google/b/bf
      //   39	45	124	finally
      //   72	85	124	finally
      //   90	108	124	finally
      //   112	124	124	finally
      //   165	186	124	finally
      //   39	45	164	java/io/IOException
      //   72	85	164	java/io/IOException
      //   90	108	164	java/io/IOException
    }
    
    public static c M(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(218397);
      paramArrayOfByte = (c)bRf.w(paramArrayOfByte);
      AppMethodBeat.o(218397);
      return paramArrayOfByte;
    }
    
    private a Mc()
    {
      AppMethodBeat.i(218398);
      if (this == coa)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(218398);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(218398);
      return locala;
    }
    
    public static c Md()
    {
      return coa;
    }
    
    public final int Ad()
    {
      AppMethodBeat.i(218394);
      int i = this.bOZ;
      if (i != -1)
      {
        AppMethodBeat.o(218394);
        return i;
      }
      i = 0;
      if ((this.bQS & 0x1) != 0) {
        i = com.google.b.i.c(1, this.cnV) + 0;
      }
      i += this.bVW.Ad();
      this.bOZ = i;
      AppMethodBeat.o(218394);
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(218392);
      bb.e locale = b.LG().b(c.class, a.class);
      AppMethodBeat.o(218392);
      return locale;
    }
    
    public final ci<c> Co()
    {
      return bRf;
    }
    
    public final boolean LP()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final void a(com.google.b.i parami)
    {
      AppMethodBeat.i(218393);
      if ((this.bQS & 0x1) != 0) {
        parami.a(1, this.cnV);
      }
      this.bVW.a(parami);
      AppMethodBeat.o(218393);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(218395);
      if (paramObject == this)
      {
        AppMethodBeat.o(218395);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(218395);
        return bool;
      }
      paramObject = (c)paramObject;
      if (LP() != paramObject.LP())
      {
        AppMethodBeat.o(218395);
        return false;
      }
      if ((LP()) && (!this.cnV.equals(paramObject.cnV)))
      {
        AppMethodBeat.o(218395);
        return false;
      }
      if (!this.bVW.equals(paramObject.bVW))
      {
        AppMethodBeat.o(218395);
        return false;
      }
      AppMethodBeat.o(218395);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(218396);
      if (this.bPa != 0)
      {
        i = this.bPa;
        AppMethodBeat.o(218396);
        return i;
      }
      int j = b.LF().hashCode() + 779;
      int i = j;
      if (LP()) {
        i = (j * 37 + 1) * 53 + this.cnV.hashCode();
      }
      i = i * 29 + this.bVW.hashCode();
      this.bPa = i;
      AppMethodBeat.o(218396);
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
      implements e
    {
      private int bQS;
      private com.google.b.g cnV;
      
      private a()
      {
        AppMethodBeat.i(217831);
        this.cnV = com.google.b.g.bPf;
        b.c.Me();
        AppMethodBeat.o(217831);
      }
      
      private a(bb.b paramb)
      {
        super();
        AppMethodBeat.i(217832);
        this.cnV = com.google.b.g.bPf;
        b.c.Me();
        AppMethodBeat.o(217832);
      }
      
      private a E(bt parambt)
      {
        AppMethodBeat.i(217839);
        if ((parambt instanceof b.c))
        {
          parambt = b((b.c)parambt);
          AppMethodBeat.o(217839);
          return parambt;
        }
        super.a(parambt);
        AppMethodBeat.o(217839);
        return this;
      }
      
      /* Error */
      private a F(com.google.b.h paramh, com.google.b.ap paramap)
      {
        // Byte code:
        //   0: ldc 66
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 70	com/tencent/ilink/tdi/b$c:bRf	Lcom/google/b/ci;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 76 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$c
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 58	com/tencent/ilink/tdi/b$c$a:b	(Lcom/tencent/ilink/tdi/b$c;)Lcom/tencent/ilink/tdi/b$c$a;
        //   30: pop
        //   31: ldc 66
        //   33: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 80	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$c
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 84	com/google/b/bf:Im	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 66
        //   54: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 58	com/tencent/ilink/tdi/b$c$a:b	(Lcom/tencent/ilink/tdi/b$c;)Lcom/tencent/ilink/tdi/b$c$a;
        //   69: pop
        //   70: ldc 66
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
        //   0	83	1	paramh	com.google.b.h
        //   0	83	2	paramap	com.google.b.ap
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/b/bf
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private b.c Mf()
      {
        AppMethodBeat.i(217834);
        Object localObject = Mg();
        if (!((b.c)localObject).isInitialized())
        {
          localObject = b((bt)localObject);
          AppMethodBeat.o(217834);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(217834);
        return localObject;
      }
      
      private b.c Mg()
      {
        int i = 0;
        AppMethodBeat.i(217835);
        b.c localc = new b.c(this, (byte)0);
        if ((this.bQS & 0x1) != 0) {
          i = 1;
        }
        b.c.a(localc, this.cnV);
        b.c.a(localc, i);
        Ib();
        AppMethodBeat.o(217835);
        return localc;
      }
      
      private a ai(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217836);
        paramf = (a)super.d(paramf, paramObject);
        AppMethodBeat.o(217836);
        return paramf;
      }
      
      private a aj(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217838);
        paramf = (a)super.c(paramf, paramObject);
        AppMethodBeat.o(217838);
        return paramf;
      }
      
      private a ak(da paramda)
      {
        AppMethodBeat.i(217849);
        paramda = (a)super.e(paramda);
        AppMethodBeat.o(217849);
        return paramda;
      }
      
      private a al(da paramda)
      {
        AppMethodBeat.i(217852);
        paramda = (a)super.d(paramda);
        AppMethodBeat.o(217852);
        return paramda;
      }
      
      private a k(com.google.b.g paramg)
      {
        AppMethodBeat.i(217846);
        if (paramg == null)
        {
          paramg = new NullPointerException();
          AppMethodBeat.o(217846);
          throw paramg;
        }
        this.bQS |= 0x1;
        this.cnV = paramg;
        onChanged();
        AppMethodBeat.o(217846);
        return this;
      }
      
      public final bb.e Cb()
      {
        AppMethodBeat.i(217830);
        bb.e locale = b.LG().b(b.c.class, a.class);
        AppMethodBeat.o(217830);
        return locale;
      }
      
      public final aj.a Cv()
      {
        AppMethodBeat.i(217833);
        aj.a locala = b.LF();
        AppMethodBeat.o(217833);
        return locala;
      }
      
      public final a b(b.c paramc)
      {
        AppMethodBeat.i(217840);
        if (paramc == b.c.Md())
        {
          AppMethodBeat.o(217840);
          return this;
        }
        if (paramc.LP()) {
          k(paramc.cnV);
        }
        al(b.c.a(paramc));
        onChanged();
        AppMethodBeat.o(217840);
        return this;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class d
    extends bb
    implements f
  {
    @Deprecated
    public static final ci<d> bRf;
    private static final d cof;
    private int bQS;
    private byte bRd = -1;
    private int cob;
    private volatile Object coc;
    private volatile Object cod;
    com.google.b.g coe;
    long uin_;
    
    static
    {
      AppMethodBeat.i(218375);
      cof = new d();
      bRf = new com.google.b.c() {};
      AppMethodBeat.o(218375);
    }
    
    private d()
    {
      this.cob = 0;
      this.coc = "";
      this.cod = "";
      this.coe = com.google.b.g.bPf;
    }
    
    private d(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private d(com.google.b.h paramh, com.google.b.ap paramap)
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
      //   28: invokestatic 93	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +281 -> 317
      //   39: aload_1
      //   40: invokevirtual 99	com/google/b/h:Av	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+289->336, 0:+292->339, 8:+75->122, 16:+176->223, 26:+197->244, 34:+222->269, 42:+248->295
      //   105: aload_1
      //   106: aload 5
      //   108: aload_2
      //   109: iload 4
      //   111: invokevirtual 102	com/tencent/ilink/tdi/b$d:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   114: ifne -79 -> 35
      //   117: iconst_1
      //   118: istore_3
      //   119: goto -84 -> 35
      //   122: aload_1
      //   123: invokevirtual 105	com/google/b/h:AF	()I
      //   126: istore 4
      //   128: iload 4
      //   130: invokestatic 111	com/tencent/ilink/tdi/a$c:iz	(I)Lcom/tencent/ilink/tdi/a$c;
      //   133: ifnonnull +49 -> 182
      //   136: aload 5
      //   138: iconst_1
      //   139: iload 4
      //   141: invokevirtual 117	com/google/b/da$a:bQ	(II)Lcom/google/b/da$a;
      //   144: pop
      //   145: goto -110 -> 35
      //   148: astore_1
      //   149: aload_1
      //   150: aload_0
      //   151: putfield 121	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   154: ldc 84
      //   156: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   159: aload_1
      //   160: athrow
      //   161: astore_1
      //   162: aload_0
      //   163: aload 5
      //   165: invokevirtual 125	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   168: putfield 129	com/tencent/ilink/tdi/b$d:bVW	Lcom/google/b/da;
      //   171: aload_0
      //   172: invokevirtual 132	com/tencent/ilink/tdi/b$d:HZ	()V
      //   175: ldc 84
      //   177: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   180: aload_1
      //   181: athrow
      //   182: aload_0
      //   183: aload_0
      //   184: getfield 134	com/tencent/ilink/tdi/b$d:bQS	I
      //   187: iconst_1
      //   188: ior
      //   189: putfield 134	com/tencent/ilink/tdi/b$d:bQS	I
      //   192: aload_0
      //   193: iload 4
      //   195: putfield 58	com/tencent/ilink/tdi/b$d:cob	I
      //   198: goto -163 -> 35
      //   201: astore_1
      //   202: new 81	com/google/b/bf
      //   205: dup
      //   206: aload_1
      //   207: invokespecial 137	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   210: astore_1
      //   211: aload_1
      //   212: aload_0
      //   213: putfield 121	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   216: ldc 84
      //   218: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   221: aload_1
      //   222: athrow
      //   223: aload_0
      //   224: aload_0
      //   225: getfield 134	com/tencent/ilink/tdi/b$d:bQS	I
      //   228: iconst_2
      //   229: ior
      //   230: putfield 134	com/tencent/ilink/tdi/b$d:bQS	I
      //   233: aload_0
      //   234: aload_1
      //   235: invokevirtual 141	com/google/b/h:Aw	()J
      //   238: putfield 143	com/tencent/ilink/tdi/b$d:uin_	J
      //   241: goto -206 -> 35
      //   244: aload_1
      //   245: invokevirtual 147	com/google/b/h:AD	()Lcom/google/b/g;
      //   248: astore 6
      //   250: aload_0
      //   251: aload_0
      //   252: getfield 134	com/tencent/ilink/tdi/b$d:bQS	I
      //   255: iconst_4
      //   256: ior
      //   257: putfield 134	com/tencent/ilink/tdi/b$d:bQS	I
      //   260: aload_0
      //   261: aload 6
      //   263: putfield 62	com/tencent/ilink/tdi/b$d:coc	Ljava/lang/Object;
      //   266: goto -231 -> 35
      //   269: aload_1
      //   270: invokevirtual 147	com/google/b/h:AD	()Lcom/google/b/g;
      //   273: astore 6
      //   275: aload_0
      //   276: aload_0
      //   277: getfield 134	com/tencent/ilink/tdi/b$d:bQS	I
      //   280: bipush 8
      //   282: ior
      //   283: putfield 134	com/tencent/ilink/tdi/b$d:bQS	I
      //   286: aload_0
      //   287: aload 6
      //   289: putfield 64	com/tencent/ilink/tdi/b$d:cod	Ljava/lang/Object;
      //   292: goto -257 -> 35
      //   295: aload_0
      //   296: aload_0
      //   297: getfield 134	com/tencent/ilink/tdi/b$d:bQS	I
      //   300: bipush 16
      //   302: ior
      //   303: putfield 134	com/tencent/ilink/tdi/b$d:bQS	I
      //   306: aload_0
      //   307: aload_1
      //   308: invokevirtual 147	com/google/b/h:AD	()Lcom/google/b/g;
      //   311: putfield 71	com/tencent/ilink/tdi/b$d:coe	Lcom/google/b/g;
      //   314: goto -279 -> 35
      //   317: aload_0
      //   318: aload 5
      //   320: invokevirtual 125	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   323: putfield 129	com/tencent/ilink/tdi/b$d:bVW	Lcom/google/b/da;
      //   326: aload_0
      //   327: invokevirtual 132	com/tencent/ilink/tdi/b$d:HZ	()V
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
      //   0	344	1	paramh	com.google.b.h
      //   0	344	2	paramap	com.google.b.ap
      //   34	307	3	i	int
      //   43	151	4	j	int
      //   31	288	5	locala	com.google.b.da.a
      //   248	40	6	localg	com.google.b.g
      // Exception table:
      //   from	to	target	type
      //   39	45	148	com/google/b/bf
      //   104	117	148	com/google/b/bf
      //   122	145	148	com/google/b/bf
      //   182	198	148	com/google/b/bf
      //   223	241	148	com/google/b/bf
      //   244	266	148	com/google/b/bf
      //   269	292	148	com/google/b/bf
      //   295	314	148	com/google/b/bf
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
    
    private String Mm()
    {
      AppMethodBeat.i(218351);
      Object localObject = this.cod;
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(218351);
        return localObject;
      }
      localObject = (com.google.b.g)localObject;
      String str = ((com.google.b.g)localObject).Ap();
      if (((com.google.b.g)localObject).Aq()) {
        this.cod = str;
      }
      AppMethodBeat.o(218351);
      return str;
    }
    
    private a Mo()
    {
      AppMethodBeat.i(218367);
      if (this == cof)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(218367);
        return locala;
      }
      a locala = new a((byte)0).d(this);
      AppMethodBeat.o(218367);
      return locala;
    }
    
    public static d Mp()
    {
      return cof;
    }
    
    public static d N(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(218364);
      paramArrayOfByte = (d)bRf.w(paramArrayOfByte);
      AppMethodBeat.o(218364);
      return paramArrayOfByte;
    }
    
    private String getNickname()
    {
      AppMethodBeat.i(218350);
      Object localObject = this.coc;
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(218350);
        return localObject;
      }
      localObject = (com.google.b.g)localObject;
      String str = ((com.google.b.g)localObject).Ap();
      if (((com.google.b.g)localObject).Aq()) {
        this.coc = str;
      }
      AppMethodBeat.o(218350);
      return str;
    }
    
    public final int Ad()
    {
      AppMethodBeat.i(218354);
      int i = this.bOZ;
      if (i != -1)
      {
        AppMethodBeat.o(218354);
        return i;
      }
      int j = 0;
      if ((this.bQS & 0x1) != 0) {
        j = com.google.b.i.bO(1, this.cob) + 0;
      }
      i = j;
      if ((this.bQS & 0x2) != 0) {
        i = j + com.google.b.i.q(2, this.uin_);
      }
      j = i;
      if ((this.bQS & 0x4) != 0) {
        j = i + bb.f(3, this.coc);
      }
      i = j;
      if ((this.bQS & 0x8) != 0) {
        i = j + bb.f(4, this.cod);
      }
      j = i;
      if ((this.bQS & 0x10) != 0) {
        j = i + com.google.b.i.c(5, this.coe);
      }
      i = j + this.bVW.Ad();
      this.bOZ = i;
      AppMethodBeat.o(218354);
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(218345);
      bb.e locale = b.LE().b(d.class, a.class);
      AppMethodBeat.o(218345);
      return locale;
    }
    
    public final ci<d> Co()
    {
      return bRf;
    }
    
    public final boolean Mh()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final a.c Mi()
    {
      AppMethodBeat.i(218348);
      a.c localc = a.c.iz(this.cob);
      if (localc == null)
      {
        localc = a.c.cmS;
        AppMethodBeat.o(218348);
        return localc;
      }
      AppMethodBeat.o(218348);
      return localc;
    }
    
    public final boolean Mj()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final boolean Mk()
    {
      return (this.bQS & 0x4) != 0;
    }
    
    public final boolean Ml()
    {
      return (this.bQS & 0x8) != 0;
    }
    
    public final boolean Mn()
    {
      return (this.bQS & 0x10) != 0;
    }
    
    public final void a(com.google.b.i parami)
    {
      AppMethodBeat.i(218353);
      if ((this.bQS & 0x1) != 0) {
        parami.bJ(1, this.cob);
      }
      if ((this.bQS & 0x2) != 0) {
        parami.n(2, this.uin_);
      }
      if ((this.bQS & 0x4) != 0) {
        bb.a(parami, 3, this.coc);
      }
      if ((this.bQS & 0x8) != 0) {
        bb.a(parami, 4, this.cod);
      }
      if ((this.bQS & 0x10) != 0) {
        parami.a(5, this.coe);
      }
      this.bVW.a(parami);
      AppMethodBeat.o(218353);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(218357);
      if (paramObject == this)
      {
        AppMethodBeat.o(218357);
        return true;
      }
      if (!(paramObject instanceof d))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(218357);
        return bool;
      }
      paramObject = (d)paramObject;
      if (Mh() != paramObject.Mh())
      {
        AppMethodBeat.o(218357);
        return false;
      }
      if ((Mh()) && (this.cob != paramObject.cob))
      {
        AppMethodBeat.o(218357);
        return false;
      }
      if (Mj() != paramObject.Mj())
      {
        AppMethodBeat.o(218357);
        return false;
      }
      if ((Mj()) && (this.uin_ != paramObject.uin_))
      {
        AppMethodBeat.o(218357);
        return false;
      }
      if (Mk() != paramObject.Mk())
      {
        AppMethodBeat.o(218357);
        return false;
      }
      if ((Mk()) && (!getNickname().equals(paramObject.getNickname())))
      {
        AppMethodBeat.o(218357);
        return false;
      }
      if (Ml() != paramObject.Ml())
      {
        AppMethodBeat.o(218357);
        return false;
      }
      if ((Ml()) && (!Mm().equals(paramObject.Mm())))
      {
        AppMethodBeat.o(218357);
        return false;
      }
      if (Mn() != paramObject.Mn())
      {
        AppMethodBeat.o(218357);
        return false;
      }
      if ((Mn()) && (!this.coe.equals(paramObject.coe)))
      {
        AppMethodBeat.o(218357);
        return false;
      }
      if (!this.bVW.equals(paramObject.bVW))
      {
        AppMethodBeat.o(218357);
        return false;
      }
      AppMethodBeat.o(218357);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(218362);
      if (this.bPa != 0)
      {
        i = this.bPa;
        AppMethodBeat.o(218362);
        return i;
      }
      int j = b.LD().hashCode() + 779;
      int i = j;
      if (Mh()) {
        i = (j * 37 + 1) * 53 + this.cob;
      }
      j = i;
      if (Mj()) {
        j = (i * 37 + 2) * 53 + be.aJ(this.uin_);
      }
      i = j;
      if (Mk()) {
        i = (j * 37 + 3) * 53 + getNickname().hashCode();
      }
      j = i;
      if (Ml()) {
        j = (i * 37 + 4) * 53 + Mm().hashCode();
      }
      i = j;
      if (Mn()) {
        i = (j * 37 + 5) * 53 + this.coe.hashCode();
      }
      i = i * 29 + this.bVW.hashCode();
      this.bPa = i;
      AppMethodBeat.o(218362);
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
      implements f
    {
      private int bQS;
      private int cob;
      private Object coc;
      private Object cod;
      private com.google.b.g coe;
      private long uin_;
      
      private a()
      {
        AppMethodBeat.i(217904);
        this.cob = 0;
        this.coc = "";
        this.cod = "";
        this.coe = com.google.b.g.bPf;
        b.d.Mq();
        AppMethodBeat.o(217904);
      }
      
      private a(bb.b paramb)
      {
        super();
        AppMethodBeat.i(217906);
        this.cob = 0;
        this.coc = "";
        this.cod = "";
        this.coe = com.google.b.g.bPf;
        b.d.Mq();
        AppMethodBeat.o(217906);
      }
      
      private a F(bt parambt)
      {
        AppMethodBeat.i(217918);
        if ((parambt instanceof b.d))
        {
          parambt = d((b.d)parambt);
          AppMethodBeat.o(217918);
          return parambt;
        }
        super.a(parambt);
        AppMethodBeat.o(217918);
        return this;
      }
      
      /* Error */
      private a G(com.google.b.h paramh, com.google.b.ap paramap)
      {
        // Byte code:
        //   0: ldc 79
        //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 83	com/tencent/ilink/tdi/b$d:bRf	Lcom/google/b/ci;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 88 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$d
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 71	com/tencent/ilink/tdi/b$d$a:d	(Lcom/tencent/ilink/tdi/b$d;)Lcom/tencent/ilink/tdi/b$d$a;
        //   30: pop
        //   31: ldc 79
        //   33: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 92	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$d
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 96	com/google/b/bf:Im	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 79
        //   54: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 71	com/tencent/ilink/tdi/b$d$a:d	(Lcom/tencent/ilink/tdi/b$d;)Lcom/tencent/ilink/tdi/b$d$a;
        //   69: pop
        //   70: ldc 79
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
        //   0	83	1	paramh	com.google.b.h
        //   0	83	2	paramap	com.google.b.ap
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/b/bf
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private b.d Mr()
      {
        AppMethodBeat.i(217910);
        Object localObject = Ms();
        if (!((b.d)localObject).isInitialized())
        {
          localObject = b((bt)localObject);
          AppMethodBeat.o(217910);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(217910);
        return localObject;
      }
      
      private b.d Ms()
      {
        int j = 0;
        AppMethodBeat.i(217914);
        b.d locald = new b.d(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        b.d.a(locald, this.cob);
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
        b.d.a(locald, this.coc);
        i = j;
        if ((k & 0x8) != 0) {
          i = j | 0x8;
        }
        b.d.b(locald, this.cod);
        j = i;
        if ((k & 0x10) != 0) {
          j = i | 0x10;
        }
        b.d.a(locald, this.coe);
        b.d.b(locald, j);
        Ib();
        AppMethodBeat.o(217914);
        return locald;
      }
      
      private a a(a.c paramc)
      {
        AppMethodBeat.i(217923);
        if (paramc == null)
        {
          paramc = new NullPointerException();
          AppMethodBeat.o(217923);
          throw paramc;
        }
        this.bQS |= 0x1;
        this.cob = paramc.value;
        onChanged();
        AppMethodBeat.o(217923);
        return this;
      }
      
      private a ak(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217916);
        paramf = (a)super.d(paramf, paramObject);
        AppMethodBeat.o(217916);
        return paramf;
      }
      
      private a al(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217917);
        paramf = (a)super.c(paramf, paramObject);
        AppMethodBeat.o(217917);
        return paramf;
      }
      
      private a am(da paramda)
      {
        AppMethodBeat.i(217928);
        paramda = (a)super.e(paramda);
        AppMethodBeat.o(217928);
        return paramda;
      }
      
      private a an(da paramda)
      {
        AppMethodBeat.i(217929);
        paramda = (a)super.d(paramda);
        AppMethodBeat.o(217929);
        return paramda;
      }
      
      private a bb(long paramLong)
      {
        AppMethodBeat.i(217924);
        this.bQS |= 0x2;
        this.uin_ = paramLong;
        onChanged();
        AppMethodBeat.o(217924);
        return this;
      }
      
      private a l(com.google.b.g paramg)
      {
        AppMethodBeat.i(217926);
        if (paramg == null)
        {
          paramg = new NullPointerException();
          AppMethodBeat.o(217926);
          throw paramg;
        }
        this.bQS |= 0x10;
        this.coe = paramg;
        onChanged();
        AppMethodBeat.o(217926);
        return this;
      }
      
      public final bb.e Cb()
      {
        AppMethodBeat.i(217902);
        bb.e locale = b.LE().b(b.d.class, a.class);
        AppMethodBeat.o(217902);
        return locale;
      }
      
      public final aj.a Cv()
      {
        AppMethodBeat.i(217908);
        aj.a locala = b.LD();
        AppMethodBeat.o(217908);
        return locala;
      }
      
      public final a d(b.d paramd)
      {
        AppMethodBeat.i(217919);
        if (paramd == b.d.Mp())
        {
          AppMethodBeat.o(217919);
          return this;
        }
        if (paramd.Mh()) {
          a(paramd.Mi());
        }
        if (paramd.Mj()) {
          bb(paramd.uin_);
        }
        if (paramd.Mk())
        {
          this.bQS |= 0x4;
          this.coc = b.d.a(paramd);
          onChanged();
        }
        if (paramd.Ml())
        {
          this.bQS |= 0x8;
          this.cod = b.d.b(paramd);
          onChanged();
        }
        if (paramd.Mn()) {
          l(paramd.coe);
        }
        an(b.d.c(paramd));
        onChanged();
        AppMethodBeat.o(217919);
        return this;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class e
    extends bb
    implements g
  {
    @Deprecated
    public static final ci<e> bRf;
    private static final e coi;
    private int bQS;
    private byte bRd = -1;
    private int cog;
    com.google.b.g coh;
    private int type_;
    
    static
    {
      AppMethodBeat.i(218211);
      coi = new e();
      bRf = new com.google.b.c() {};
      AppMethodBeat.o(218211);
    }
    
    private e()
    {
      this.type_ = 1;
      this.cog = 0;
      this.coh = com.google.b.g.bPf;
    }
    
    private e(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private e(com.google.b.h paramh, com.google.b.ap paramap)
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
      //   28: invokestatic 85	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +237 -> 273
      //   39: aload_1
      //   40: invokevirtual 91	com/google/b/h:Av	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+245->292, 0:+248->295, 8:+59->106, 16:+160->207, 26:+205->252
      //   89: aload_1
      //   90: aload 5
      //   92: aload_2
      //   93: iload 4
      //   95: invokevirtual 94	com/tencent/ilink/tdi/b$e:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   98: ifne -63 -> 35
      //   101: iconst_1
      //   102: istore_3
      //   103: goto -68 -> 35
      //   106: aload_1
      //   107: invokevirtual 97	com/google/b/h:AF	()I
      //   110: istore 4
      //   112: iload 4
      //   114: invokestatic 103	com/tencent/ilink/tdi/a$a:ix	(I)Lcom/tencent/ilink/tdi/a$a;
      //   117: ifnonnull +49 -> 166
      //   120: aload 5
      //   122: iconst_1
      //   123: iload 4
      //   125: invokevirtual 109	com/google/b/da$a:bQ	(II)Lcom/google/b/da$a;
      //   128: pop
      //   129: goto -94 -> 35
      //   132: astore_1
      //   133: aload_1
      //   134: aload_0
      //   135: putfield 113	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   138: ldc 76
      //   140: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   143: aload_1
      //   144: athrow
      //   145: astore_1
      //   146: aload_0
      //   147: aload 5
      //   149: invokevirtual 117	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   152: putfield 121	com/tencent/ilink/tdi/b$e:bVW	Lcom/google/b/da;
      //   155: aload_0
      //   156: invokevirtual 124	com/tencent/ilink/tdi/b$e:HZ	()V
      //   159: ldc 76
      //   161: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   164: aload_1
      //   165: athrow
      //   166: aload_0
      //   167: aload_0
      //   168: getfield 126	com/tencent/ilink/tdi/b$e:bQS	I
      //   171: iconst_1
      //   172: ior
      //   173: putfield 126	com/tencent/ilink/tdi/b$e:bQS	I
      //   176: aload_0
      //   177: iload 4
      //   179: putfield 54	com/tencent/ilink/tdi/b$e:type_	I
      //   182: goto -147 -> 35
      //   185: astore_1
      //   186: new 73	com/google/b/bf
      //   189: dup
      //   190: aload_1
      //   191: invokespecial 129	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   194: astore_1
      //   195: aload_1
      //   196: aload_0
      //   197: putfield 113	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   200: ldc 76
      //   202: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   205: aload_1
      //   206: athrow
      //   207: aload_1
      //   208: invokevirtual 97	com/google/b/h:AF	()I
      //   211: istore 4
      //   213: iload 4
      //   215: invokestatic 135	com/tencent/ilink/tdi/a$b:iy	(I)Lcom/tencent/ilink/tdi/a$b;
      //   218: ifnonnull +15 -> 233
      //   221: aload 5
      //   223: iconst_2
      //   224: iload 4
      //   226: invokevirtual 109	com/google/b/da$a:bQ	(II)Lcom/google/b/da$a;
      //   229: pop
      //   230: goto -195 -> 35
      //   233: aload_0
      //   234: aload_0
      //   235: getfield 126	com/tencent/ilink/tdi/b$e:bQS	I
      //   238: iconst_2
      //   239: ior
      //   240: putfield 126	com/tencent/ilink/tdi/b$e:bQS	I
      //   243: aload_0
      //   244: iload 4
      //   246: putfield 56	com/tencent/ilink/tdi/b$e:cog	I
      //   249: goto -214 -> 35
      //   252: aload_0
      //   253: aload_0
      //   254: getfield 126	com/tencent/ilink/tdi/b$e:bQS	I
      //   257: iconst_4
      //   258: ior
      //   259: putfield 126	com/tencent/ilink/tdi/b$e:bQS	I
      //   262: aload_0
      //   263: aload_1
      //   264: invokevirtual 139	com/google/b/h:AD	()Lcom/google/b/g;
      //   267: putfield 63	com/tencent/ilink/tdi/b$e:coh	Lcom/google/b/g;
      //   270: goto -235 -> 35
      //   273: aload_0
      //   274: aload 5
      //   276: invokevirtual 117	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   279: putfield 121	com/tencent/ilink/tdi/b$e:bVW	Lcom/google/b/da;
      //   282: aload_0
      //   283: invokevirtual 124	com/tencent/ilink/tdi/b$e:HZ	()V
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
      //   0	300	1	paramh	com.google.b.h
      //   0	300	2	paramap	com.google.b.ap
      //   34	263	3	i	int
      //   43	202	4	j	int
      //   31	244	5	locala	com.google.b.da.a
      // Exception table:
      //   from	to	target	type
      //   39	45	132	com/google/b/bf
      //   88	101	132	com/google/b/bf
      //   106	129	132	com/google/b/bf
      //   166	182	132	com/google/b/bf
      //   207	230	132	com/google/b/bf
      //   233	249	132	com/google/b/bf
      //   252	270	132	com/google/b/bf
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
    
    private a Mx()
    {
      AppMethodBeat.i(218183);
      if (this == coi)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(218183);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(218183);
      return locala;
    }
    
    public static e My()
    {
      return coi;
    }
    
    public static e O(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(218181);
      paramArrayOfByte = (e)bRf.w(paramArrayOfByte);
      AppMethodBeat.o(218181);
      return paramArrayOfByte;
    }
    
    public final int Ad()
    {
      AppMethodBeat.i(218174);
      int i = this.bOZ;
      if (i != -1)
      {
        AppMethodBeat.o(218174);
        return i;
      }
      int j = 0;
      if ((this.bQS & 0x1) != 0) {
        j = com.google.b.i.bO(1, this.type_) + 0;
      }
      i = j;
      if ((this.bQS & 0x2) != 0) {
        i = j + com.google.b.i.bO(2, this.cog);
      }
      j = i;
      if ((this.bQS & 0x4) != 0) {
        j = i + com.google.b.i.c(3, this.coh);
      }
      i = j + this.bVW.Ad();
      this.bOZ = i;
      AppMethodBeat.o(218174);
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(218161);
      bb.e locale = b.Ly().b(e.class, a.class);
      AppMethodBeat.o(218161);
      return locale;
    }
    
    public final ci<e> Co()
    {
      return bRf;
    }
    
    public final boolean DQ()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final a.a Mt()
    {
      AppMethodBeat.i(218164);
      a.a locala = a.a.ix(this.type_);
      if (locala == null)
      {
        locala = a.a.cmC;
        AppMethodBeat.o(218164);
        return locala;
      }
      AppMethodBeat.o(218164);
      return locala;
    }
    
    public final boolean Mu()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final a.b Mv()
    {
      AppMethodBeat.i(218166);
      a.b localb = a.b.iy(this.cog);
      if (localb == null)
      {
        localb = a.b.cmM;
        AppMethodBeat.o(218166);
        return localb;
      }
      AppMethodBeat.o(218166);
      return localb;
    }
    
    public final boolean Mw()
    {
      return (this.bQS & 0x4) != 0;
    }
    
    public final void a(com.google.b.i parami)
    {
      AppMethodBeat.i(218171);
      if ((this.bQS & 0x1) != 0) {
        parami.bJ(1, this.type_);
      }
      if ((this.bQS & 0x2) != 0) {
        parami.bJ(2, this.cog);
      }
      if ((this.bQS & 0x4) != 0) {
        parami.a(3, this.coh);
      }
      this.bVW.a(parami);
      AppMethodBeat.o(218171);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(218177);
      if (paramObject == this)
      {
        AppMethodBeat.o(218177);
        return true;
      }
      if (!(paramObject instanceof e))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(218177);
        return bool;
      }
      paramObject = (e)paramObject;
      if (DQ() != paramObject.DQ())
      {
        AppMethodBeat.o(218177);
        return false;
      }
      if ((DQ()) && (this.type_ != paramObject.type_))
      {
        AppMethodBeat.o(218177);
        return false;
      }
      if (Mu() != paramObject.Mu())
      {
        AppMethodBeat.o(218177);
        return false;
      }
      if ((Mu()) && (this.cog != paramObject.cog))
      {
        AppMethodBeat.o(218177);
        return false;
      }
      if (Mw() != paramObject.Mw())
      {
        AppMethodBeat.o(218177);
        return false;
      }
      if ((Mw()) && (!this.coh.equals(paramObject.coh)))
      {
        AppMethodBeat.o(218177);
        return false;
      }
      if (!this.bVW.equals(paramObject.bVW))
      {
        AppMethodBeat.o(218177);
        return false;
      }
      AppMethodBeat.o(218177);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(218179);
      if (this.bPa != 0)
      {
        i = this.bPa;
        AppMethodBeat.o(218179);
        return i;
      }
      int j = b.Lx().hashCode() + 779;
      int i = j;
      if (DQ()) {
        i = (j * 37 + 1) * 53 + this.type_;
      }
      j = i;
      if (Mu()) {
        j = (i * 37 + 2) * 53 + this.cog;
      }
      i = j;
      if (Mw()) {
        i = (j * 37 + 3) * 53 + this.coh.hashCode();
      }
      i = i * 29 + this.bVW.hashCode();
      this.bPa = i;
      AppMethodBeat.o(218179);
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
      implements g
    {
      private int bQS;
      private int cog;
      private com.google.b.g coh;
      private int type_;
      
      private a()
      {
        AppMethodBeat.i(217689);
        this.type_ = 1;
        this.cog = 0;
        this.coh = com.google.b.g.bPf;
        b.e.Mz();
        AppMethodBeat.o(217689);
      }
      
      private a(bb.b paramb)
      {
        super();
        AppMethodBeat.i(217691);
        this.type_ = 1;
        this.cog = 0;
        this.coh = com.google.b.g.bPf;
        b.e.Mz();
        AppMethodBeat.o(217691);
      }
      
      private a G(bt parambt)
      {
        AppMethodBeat.i(217703);
        if ((parambt instanceof b.e))
        {
          parambt = b((b.e)parambt);
          AppMethodBeat.o(217703);
          return parambt;
        }
        super.a(parambt);
        AppMethodBeat.o(217703);
        return this;
      }
      
      /* Error */
      private a H(com.google.b.h paramh, com.google.b.ap paramap)
      {
        // Byte code:
        //   0: ldc 72
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 76	com/tencent/ilink/tdi/b$e:bRf	Lcom/google/b/ci;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 82 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$e
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 64	com/tencent/ilink/tdi/b$e$a:b	(Lcom/tencent/ilink/tdi/b$e;)Lcom/tencent/ilink/tdi/b$e$a;
        //   30: pop
        //   31: ldc 72
        //   33: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 86	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$e
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 90	com/google/b/bf:Im	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 72
        //   54: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 64	com/tencent/ilink/tdi/b$e$a:b	(Lcom/tencent/ilink/tdi/b$e;)Lcom/tencent/ilink/tdi/b$e$a;
        //   69: pop
        //   70: ldc 72
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
        //   0	83	1	paramh	com.google.b.h
        //   0	83	2	paramap	com.google.b.ap
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/b/bf
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private b.e MA()
      {
        AppMethodBeat.i(217696);
        Object localObject = MB();
        if (!((b.e)localObject).isInitialized())
        {
          localObject = b((bt)localObject);
          AppMethodBeat.o(217696);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(217696);
        return localObject;
      }
      
      private b.e MB()
      {
        int j = 0;
        AppMethodBeat.i(217697);
        b.e locale = new b.e(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        b.e.a(locale, this.type_);
        int i = j;
        if ((k & 0x2) != 0) {
          i = j | 0x2;
        }
        b.e.b(locale, this.cog);
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        b.e.a(locale, this.coh);
        b.e.c(locale, j);
        Ib();
        AppMethodBeat.o(217697);
        return locale;
      }
      
      private a a(a.a parama)
      {
        AppMethodBeat.i(217711);
        if (parama == null)
        {
          parama = new NullPointerException();
          AppMethodBeat.o(217711);
          throw parama;
        }
        this.bQS |= 0x1;
        this.type_ = parama.value;
        onChanged();
        AppMethodBeat.o(217711);
        return this;
      }
      
      private a a(a.b paramb)
      {
        AppMethodBeat.i(217714);
        if (paramb == null)
        {
          paramb = new NullPointerException();
          AppMethodBeat.o(217714);
          throw paramb;
        }
        this.bQS |= 0x2;
        this.cog = paramb.value;
        onChanged();
        AppMethodBeat.o(217714);
        return this;
      }
      
      private a am(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217699);
        paramf = (a)super.d(paramf, paramObject);
        AppMethodBeat.o(217699);
        return paramf;
      }
      
      private a an(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217701);
        paramf = (a)super.c(paramf, paramObject);
        AppMethodBeat.o(217701);
        return paramf;
      }
      
      private a ao(da paramda)
      {
        AppMethodBeat.i(217717);
        paramda = (a)super.e(paramda);
        AppMethodBeat.o(217717);
        return paramda;
      }
      
      private a ap(da paramda)
      {
        AppMethodBeat.i(217718);
        paramda = (a)super.d(paramda);
        AppMethodBeat.o(217718);
        return paramda;
      }
      
      private a m(com.google.b.g paramg)
      {
        AppMethodBeat.i(217716);
        if (paramg == null)
        {
          paramg = new NullPointerException();
          AppMethodBeat.o(217716);
          throw paramg;
        }
        this.bQS |= 0x4;
        this.coh = paramg;
        onChanged();
        AppMethodBeat.o(217716);
        return this;
      }
      
      public final bb.e Cb()
      {
        AppMethodBeat.i(217687);
        bb.e locale = b.Ly().b(b.e.class, a.class);
        AppMethodBeat.o(217687);
        return locale;
      }
      
      public final aj.a Cv()
      {
        AppMethodBeat.i(217692);
        aj.a locala = b.Lx();
        AppMethodBeat.o(217692);
        return locala;
      }
      
      public final a b(b.e parame)
      {
        AppMethodBeat.i(217705);
        if (parame == b.e.My())
        {
          AppMethodBeat.o(217705);
          return this;
        }
        if (parame.DQ()) {
          a(parame.Mt());
        }
        if (parame.Mu()) {
          a(parame.Mv());
        }
        if (parame.Mw()) {
          m(parame.coh);
        }
        ap(b.e.a(parame));
        onChanged();
        AppMethodBeat.o(217705);
        return this;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class f
    extends bb
    implements h
  {
    @Deprecated
    public static final ci<f> bRf;
    private static final f cok;
    private int bQS;
    private byte bRd = -1;
    com.google.b.g coj;
    
    static
    {
      AppMethodBeat.i(217794);
      cok = new f();
      bRf = new com.google.b.c() {};
      AppMethodBeat.o(217794);
    }
    
    private f()
    {
      this.coj = com.google.b.g.bPf;
    }
    
    private f(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private f(com.google.b.h paramh, com.google.b.ap paramap)
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
      //   28: invokestatic 79	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +109 -> 145
      //   39: aload_1
      //   40: invokevirtual 85	com/google/b/h:Av	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+139->186, 0:+142->189, 10:+43->90
      //   73: aload_1
      //   74: aload 5
      //   76: aload_2
      //   77: iload 4
      //   79: invokevirtual 88	com/tencent/ilink/tdi/b$f:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   82: ifne -47 -> 35
      //   85: iconst_1
      //   86: istore_3
      //   87: goto -52 -> 35
      //   90: aload_0
      //   91: aload_0
      //   92: getfield 90	com/tencent/ilink/tdi/b$f:bQS	I
      //   95: iconst_1
      //   96: ior
      //   97: putfield 90	com/tencent/ilink/tdi/b$f:bQS	I
      //   100: aload_0
      //   101: aload_1
      //   102: invokevirtual 94	com/google/b/h:AD	()Lcom/google/b/g;
      //   105: putfield 57	com/tencent/ilink/tdi/b$f:coj	Lcom/google/b/g;
      //   108: goto -73 -> 35
      //   111: astore_1
      //   112: aload_1
      //   113: aload_0
      //   114: putfield 98	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   117: ldc 70
      //   119: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   122: aload_1
      //   123: athrow
      //   124: astore_1
      //   125: aload_0
      //   126: aload 5
      //   128: invokevirtual 104	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   131: putfield 108	com/tencent/ilink/tdi/b$f:bVW	Lcom/google/b/da;
      //   134: aload_0
      //   135: invokevirtual 111	com/tencent/ilink/tdi/b$f:HZ	()V
      //   138: ldc 70
      //   140: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   143: aload_1
      //   144: athrow
      //   145: aload_0
      //   146: aload 5
      //   148: invokevirtual 104	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   151: putfield 108	com/tencent/ilink/tdi/b$f:bVW	Lcom/google/b/da;
      //   154: aload_0
      //   155: invokevirtual 111	com/tencent/ilink/tdi/b$f:HZ	()V
      //   158: ldc 70
      //   160: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   163: return
      //   164: astore_1
      //   165: new 67	com/google/b/bf
      //   168: dup
      //   169: aload_1
      //   170: invokespecial 114	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   173: astore_1
      //   174: aload_1
      //   175: aload_0
      //   176: putfield 98	com/google/b/bf:bZj	Lcom/google/b/bw;
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
      //   0	194	1	paramh	com.google.b.h
      //   0	194	2	paramap	com.google.b.ap
      //   34	157	3	i	int
      //   43	35	4	j	int
      //   31	116	5	locala	com.google.b.da.a
      // Exception table:
      //   from	to	target	type
      //   39	45	111	com/google/b/bf
      //   72	85	111	com/google/b/bf
      //   90	108	111	com/google/b/bf
      //   39	45	124	finally
      //   72	85	124	finally
      //   90	108	124	finally
      //   112	124	124	finally
      //   165	186	124	finally
      //   39	45	164	java/io/IOException
      //   72	85	164	java/io/IOException
      //   90	108	164	java/io/IOException
    }
    
    private a MD()
    {
      AppMethodBeat.i(217777);
      if (this == cok)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(217777);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(217777);
      return locala;
    }
    
    public static f ME()
    {
      return cok;
    }
    
    public static f P(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(217774);
      paramArrayOfByte = (f)bRf.w(paramArrayOfByte);
      AppMethodBeat.o(217774);
      return paramArrayOfByte;
    }
    
    public final int Ad()
    {
      AppMethodBeat.i(217769);
      int i = this.bOZ;
      if (i != -1)
      {
        AppMethodBeat.o(217769);
        return i;
      }
      i = 0;
      if ((this.bQS & 0x1) != 0) {
        i = com.google.b.i.c(1, this.coj) + 0;
      }
      i += this.bVW.Ad();
      this.bOZ = i;
      AppMethodBeat.o(217769);
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(217767);
      bb.e locale = b.Lu().b(f.class, a.class);
      AppMethodBeat.o(217767);
      return locale;
    }
    
    public final ci<f> Co()
    {
      return bRf;
    }
    
    public final boolean MC()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final void a(com.google.b.i parami)
    {
      AppMethodBeat.i(217768);
      if ((this.bQS & 0x1) != 0) {
        parami.a(1, this.coj);
      }
      this.bVW.a(parami);
      AppMethodBeat.o(217768);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(217771);
      if (paramObject == this)
      {
        AppMethodBeat.o(217771);
        return true;
      }
      if (!(paramObject instanceof f))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(217771);
        return bool;
      }
      paramObject = (f)paramObject;
      if (MC() != paramObject.MC())
      {
        AppMethodBeat.o(217771);
        return false;
      }
      if ((MC()) && (!this.coj.equals(paramObject.coj)))
      {
        AppMethodBeat.o(217771);
        return false;
      }
      if (!this.bVW.equals(paramObject.bVW))
      {
        AppMethodBeat.o(217771);
        return false;
      }
      AppMethodBeat.o(217771);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(217773);
      if (this.bPa != 0)
      {
        i = this.bPa;
        AppMethodBeat.o(217773);
        return i;
      }
      int j = b.Lt().hashCode() + 779;
      int i = j;
      if (MC()) {
        i = (j * 37 + 1) * 53 + this.coj.hashCode();
      }
      i = i * 29 + this.bVW.hashCode();
      this.bPa = i;
      AppMethodBeat.o(217773);
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
      implements h
    {
      private int bQS;
      private com.google.b.g coj;
      
      private a()
      {
        AppMethodBeat.i(217970);
        this.coj = com.google.b.g.bPf;
        b.f.MF();
        AppMethodBeat.o(217970);
      }
      
      private a(bb.b paramb)
      {
        super();
        AppMethodBeat.i(217972);
        this.coj = com.google.b.g.bPf;
        b.f.MF();
        AppMethodBeat.o(217972);
      }
      
      private a H(bt parambt)
      {
        AppMethodBeat.i(217987);
        if ((parambt instanceof b.f))
        {
          parambt = b((b.f)parambt);
          AppMethodBeat.o(217987);
          return parambt;
        }
        super.a(parambt);
        AppMethodBeat.o(217987);
        return this;
      }
      
      /* Error */
      private a I(com.google.b.h paramh, com.google.b.ap paramap)
      {
        // Byte code:
        //   0: ldc 65
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 69	com/tencent/ilink/tdi/b$f:bRf	Lcom/google/b/ci;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 75 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$f
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 58	com/tencent/ilink/tdi/b$f$a:b	(Lcom/tencent/ilink/tdi/b$f;)Lcom/tencent/ilink/tdi/b$f$a;
        //   30: pop
        //   31: ldc 65
        //   33: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 79	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$f
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 83	com/google/b/bf:Im	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 65
        //   54: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 58	com/tencent/ilink/tdi/b$f$a:b	(Lcom/tencent/ilink/tdi/b$f;)Lcom/tencent/ilink/tdi/b$f$a;
        //   69: pop
        //   70: ldc 65
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
        //   0	83	1	paramh	com.google.b.h
        //   0	83	2	paramap	com.google.b.ap
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/b/bf
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private b.f MG()
      {
        AppMethodBeat.i(217977);
        Object localObject = MH();
        if (!((b.f)localObject).isInitialized())
        {
          localObject = b((bt)localObject);
          AppMethodBeat.o(217977);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(217977);
        return localObject;
      }
      
      private b.f MH()
      {
        int i = 0;
        AppMethodBeat.i(217981);
        b.f localf = new b.f(this, (byte)0);
        if ((this.bQS & 0x1) != 0) {
          i = 1;
        }
        b.f.a(localf, this.coj);
        b.f.a(localf, i);
        Ib();
        AppMethodBeat.o(217981);
        return localf;
      }
      
      private a ao(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217985);
        paramf = (a)super.d(paramf, paramObject);
        AppMethodBeat.o(217985);
        return paramf;
      }
      
      private a ap(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217986);
        paramf = (a)super.c(paramf, paramObject);
        AppMethodBeat.o(217986);
        return paramf;
      }
      
      private a aq(da paramda)
      {
        AppMethodBeat.i(217994);
        paramda = (a)super.e(paramda);
        AppMethodBeat.o(217994);
        return paramda;
      }
      
      private a ar(da paramda)
      {
        AppMethodBeat.i(217996);
        paramda = (a)super.d(paramda);
        AppMethodBeat.o(217996);
        return paramda;
      }
      
      private a n(com.google.b.g paramg)
      {
        AppMethodBeat.i(217993);
        if (paramg == null)
        {
          paramg = new NullPointerException();
          AppMethodBeat.o(217993);
          throw paramg;
        }
        this.bQS |= 0x1;
        this.coj = paramg;
        onChanged();
        AppMethodBeat.o(217993);
        return this;
      }
      
      public final bb.e Cb()
      {
        AppMethodBeat.i(217969);
        bb.e locale = b.Lu().b(b.f.class, a.class);
        AppMethodBeat.o(217969);
        return locale;
      }
      
      public final aj.a Cv()
      {
        AppMethodBeat.i(217975);
        aj.a locala = b.Lt();
        AppMethodBeat.o(217975);
        return locala;
      }
      
      public final a b(b.f paramf)
      {
        AppMethodBeat.i(217989);
        if (paramf == b.f.ME())
        {
          AppMethodBeat.o(217989);
          return this;
        }
        if (paramf.MC()) {
          n(paramf.coj);
        }
        ar(b.f.a(paramf));
        onChanged();
        AppMethodBeat.o(217989);
        return this;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class g
    extends bb
    implements i
  {
    @Deprecated
    public static final ci<g> bRf;
    private static final g con;
    private int bQS;
    private byte bRd = -1;
    private int cog;
    com.google.b.g col;
    com.google.b.g com;
    
    static
    {
      AppMethodBeat.i(218459);
      con = new g();
      bRf = new com.google.b.c() {};
      AppMethodBeat.o(218459);
    }
    
    private g()
    {
      this.col = com.google.b.g.bPf;
      this.com = com.google.b.g.bPf;
      this.cog = 0;
    }
    
    private g(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private g(com.google.b.h paramh, com.google.b.ap paramap)
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
      //   28: invokestatic 85	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +213 -> 249
      //   39: aload_1
      //   40: invokevirtual 91	com/google/b/h:Av	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+221->268, 0:+224->271, 10:+59->106, 18:+114->161, 24:+157->204
      //   89: aload_1
      //   90: aload 5
      //   92: aload_2
      //   93: iload 4
      //   95: invokevirtual 94	com/tencent/ilink/tdi/b$g:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   98: ifne -63 -> 35
      //   101: iconst_1
      //   102: istore_3
      //   103: goto -68 -> 35
      //   106: aload_0
      //   107: aload_0
      //   108: getfield 96	com/tencent/ilink/tdi/b$g:bQS	I
      //   111: iconst_1
      //   112: ior
      //   113: putfield 96	com/tencent/ilink/tdi/b$g:bQS	I
      //   116: aload_0
      //   117: aload_1
      //   118: invokevirtual 100	com/google/b/h:AD	()Lcom/google/b/g;
      //   121: putfield 59	com/tencent/ilink/tdi/b$g:col	Lcom/google/b/g;
      //   124: goto -89 -> 35
      //   127: astore_1
      //   128: aload_1
      //   129: aload_0
      //   130: putfield 104	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   133: ldc 76
      //   135: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   138: aload_1
      //   139: athrow
      //   140: astore_1
      //   141: aload_0
      //   142: aload 5
      //   144: invokevirtual 110	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   147: putfield 114	com/tencent/ilink/tdi/b$g:bVW	Lcom/google/b/da;
      //   150: aload_0
      //   151: invokevirtual 117	com/tencent/ilink/tdi/b$g:HZ	()V
      //   154: ldc 76
      //   156: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   159: aload_1
      //   160: athrow
      //   161: aload_0
      //   162: aload_0
      //   163: getfield 96	com/tencent/ilink/tdi/b$g:bQS	I
      //   166: iconst_2
      //   167: ior
      //   168: putfield 96	com/tencent/ilink/tdi/b$g:bQS	I
      //   171: aload_0
      //   172: aload_1
      //   173: invokevirtual 100	com/google/b/h:AD	()Lcom/google/b/g;
      //   176: putfield 61	com/tencent/ilink/tdi/b$g:com	Lcom/google/b/g;
      //   179: goto -144 -> 35
      //   182: astore_1
      //   183: new 73	com/google/b/bf
      //   186: dup
      //   187: aload_1
      //   188: invokespecial 120	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   191: astore_1
      //   192: aload_1
      //   193: aload_0
      //   194: putfield 104	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   197: ldc 76
      //   199: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   202: aload_1
      //   203: athrow
      //   204: aload_1
      //   205: invokevirtual 123	com/google/b/h:AF	()I
      //   208: istore 4
      //   210: iload 4
      //   212: invokestatic 129	com/tencent/ilink/tdi/a$b:iy	(I)Lcom/tencent/ilink/tdi/a$b;
      //   215: ifnonnull +15 -> 230
      //   218: aload 5
      //   220: iconst_3
      //   221: iload 4
      //   223: invokevirtual 133	com/google/b/da$a:bQ	(II)Lcom/google/b/da$a;
      //   226: pop
      //   227: goto -192 -> 35
      //   230: aload_0
      //   231: aload_0
      //   232: getfield 96	com/tencent/ilink/tdi/b$g:bQS	I
      //   235: iconst_4
      //   236: ior
      //   237: putfield 96	com/tencent/ilink/tdi/b$g:bQS	I
      //   240: aload_0
      //   241: iload 4
      //   243: putfield 63	com/tencent/ilink/tdi/b$g:cog	I
      //   246: goto -211 -> 35
      //   249: aload_0
      //   250: aload 5
      //   252: invokevirtual 110	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   255: putfield 114	com/tencent/ilink/tdi/b$g:bVW	Lcom/google/b/da;
      //   258: aload_0
      //   259: invokevirtual 117	com/tencent/ilink/tdi/b$g:HZ	()V
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
      //   0	276	1	paramh	com.google.b.h
      //   0	276	2	paramap	com.google.b.ap
      //   34	239	3	i	int
      //   43	199	4	j	int
      //   31	220	5	locala	com.google.b.da.a
      // Exception table:
      //   from	to	target	type
      //   39	45	127	com/google/b/bf
      //   88	101	127	com/google/b/bf
      //   106	124	127	com/google/b/bf
      //   161	179	127	com/google/b/bf
      //   204	227	127	com/google/b/bf
      //   230	246	127	com/google/b/bf
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
    
    private a MK()
    {
      AppMethodBeat.i(218440);
      if (this == con)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(218440);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(218440);
      return locala;
    }
    
    public static g ML()
    {
      return con;
    }
    
    public static g Q(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(218438);
      paramArrayOfByte = (g)bRf.w(paramArrayOfByte);
      AppMethodBeat.o(218438);
      return paramArrayOfByte;
    }
    
    public final int Ad()
    {
      AppMethodBeat.i(218434);
      int i = this.bOZ;
      if (i != -1)
      {
        AppMethodBeat.o(218434);
        return i;
      }
      int j = 0;
      if ((this.bQS & 0x1) != 0) {
        j = com.google.b.i.c(1, this.col) + 0;
      }
      i = j;
      if ((this.bQS & 0x2) != 0) {
        i = j + com.google.b.i.c(2, this.com);
      }
      j = i;
      if ((this.bQS & 0x4) != 0) {
        j = i + com.google.b.i.bO(3, this.cog);
      }
      i = j + this.bVW.Ad();
      this.bOZ = i;
      AppMethodBeat.o(218434);
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(218430);
      bb.e locale = b.Lw().b(g.class, a.class);
      AppMethodBeat.o(218430);
      return locale;
    }
    
    public final ci<g> Co()
    {
      return bRf;
    }
    
    public final boolean MI()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final boolean MJ()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final boolean Mu()
    {
      return (this.bQS & 0x4) != 0;
    }
    
    public final a.b Mv()
    {
      AppMethodBeat.i(218432);
      a.b localb = a.b.iy(this.cog);
      if (localb == null)
      {
        localb = a.b.cmM;
        AppMethodBeat.o(218432);
        return localb;
      }
      AppMethodBeat.o(218432);
      return localb;
    }
    
    public final void a(com.google.b.i parami)
    {
      AppMethodBeat.i(218433);
      if ((this.bQS & 0x1) != 0) {
        parami.a(1, this.col);
      }
      if ((this.bQS & 0x2) != 0) {
        parami.a(2, this.com);
      }
      if ((this.bQS & 0x4) != 0) {
        parami.bJ(3, this.cog);
      }
      this.bVW.a(parami);
      AppMethodBeat.o(218433);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(218436);
      if (paramObject == this)
      {
        AppMethodBeat.o(218436);
        return true;
      }
      if (!(paramObject instanceof g))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(218436);
        return bool;
      }
      paramObject = (g)paramObject;
      if (MI() != paramObject.MI())
      {
        AppMethodBeat.o(218436);
        return false;
      }
      if ((MI()) && (!this.col.equals(paramObject.col)))
      {
        AppMethodBeat.o(218436);
        return false;
      }
      if (MJ() != paramObject.MJ())
      {
        AppMethodBeat.o(218436);
        return false;
      }
      if ((MJ()) && (!this.com.equals(paramObject.com)))
      {
        AppMethodBeat.o(218436);
        return false;
      }
      if (Mu() != paramObject.Mu())
      {
        AppMethodBeat.o(218436);
        return false;
      }
      if ((Mu()) && (this.cog != paramObject.cog))
      {
        AppMethodBeat.o(218436);
        return false;
      }
      if (!this.bVW.equals(paramObject.bVW))
      {
        AppMethodBeat.o(218436);
        return false;
      }
      AppMethodBeat.o(218436);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(218437);
      if (this.bPa != 0)
      {
        i = this.bPa;
        AppMethodBeat.o(218437);
        return i;
      }
      int j = b.Lv().hashCode() + 779;
      int i = j;
      if (MI()) {
        i = (j * 37 + 1) * 53 + this.col.hashCode();
      }
      j = i;
      if (MJ()) {
        j = (i * 37 + 2) * 53 + this.com.hashCode();
      }
      i = j;
      if (Mu()) {
        i = (j * 37 + 3) * 53 + this.cog;
      }
      i = i * 29 + this.bVW.hashCode();
      this.bPa = i;
      AppMethodBeat.o(218437);
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
      implements i
    {
      private int bQS;
      private int cog;
      private com.google.b.g col;
      private com.google.b.g com;
      
      private a()
      {
        AppMethodBeat.i(217552);
        this.col = com.google.b.g.bPf;
        this.com = com.google.b.g.bPf;
        this.cog = 0;
        b.g.MM();
        AppMethodBeat.o(217552);
      }
      
      private a(bb.b paramb)
      {
        super();
        AppMethodBeat.i(217553);
        this.col = com.google.b.g.bPf;
        this.com = com.google.b.g.bPf;
        this.cog = 0;
        b.g.MM();
        AppMethodBeat.o(217553);
      }
      
      private a I(bt parambt)
      {
        AppMethodBeat.i(217561);
        if ((parambt instanceof b.g))
        {
          parambt = b((b.g)parambt);
          AppMethodBeat.o(217561);
          return parambt;
        }
        super.a(parambt);
        AppMethodBeat.o(217561);
        return this;
      }
      
      /* Error */
      private a J(com.google.b.h paramh, com.google.b.ap paramap)
      {
        // Byte code:
        //   0: ldc 71
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 75	com/tencent/ilink/tdi/b$g:bRf	Lcom/google/b/ci;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 81 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$g
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 63	com/tencent/ilink/tdi/b$g$a:b	(Lcom/tencent/ilink/tdi/b$g;)Lcom/tencent/ilink/tdi/b$g$a;
        //   30: pop
        //   31: ldc 71
        //   33: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 85	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$g
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 89	com/google/b/bf:Im	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 71
        //   54: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 63	com/tencent/ilink/tdi/b$g$a:b	(Lcom/tencent/ilink/tdi/b$g;)Lcom/tencent/ilink/tdi/b$g$a;
        //   69: pop
        //   70: ldc 71
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
        //   0	83	1	paramh	com.google.b.h
        //   0	83	2	paramap	com.google.b.ap
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/b/bf
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private b.g MN()
      {
        AppMethodBeat.i(217556);
        Object localObject = MO();
        if (!((b.g)localObject).isInitialized())
        {
          localObject = b((bt)localObject);
          AppMethodBeat.o(217556);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(217556);
        return localObject;
      }
      
      private b.g MO()
      {
        int j = 0;
        AppMethodBeat.i(217557);
        b.g localg = new b.g(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0) {
          j = 1;
        }
        b.g.a(localg, this.col);
        int i = j;
        if ((k & 0x2) != 0) {
          i = j | 0x2;
        }
        b.g.b(localg, this.com);
        j = i;
        if ((k & 0x4) != 0) {
          j = i | 0x4;
        }
        b.g.a(localg, this.cog);
        b.g.b(localg, j);
        Ib();
        AppMethodBeat.o(217557);
        return localg;
      }
      
      private a aq(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217558);
        paramf = (a)super.d(paramf, paramObject);
        AppMethodBeat.o(217558);
        return paramf;
      }
      
      private a ar(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217559);
        paramf = (a)super.c(paramf, paramObject);
        AppMethodBeat.o(217559);
        return paramf;
      }
      
      private a as(da paramda)
      {
        AppMethodBeat.i(217570);
        paramda = (a)super.e(paramda);
        AppMethodBeat.o(217570);
        return paramda;
      }
      
      private a at(da paramda)
      {
        AppMethodBeat.i(217571);
        paramda = (a)super.d(paramda);
        AppMethodBeat.o(217571);
        return paramda;
      }
      
      private a b(a.b paramb)
      {
        AppMethodBeat.i(217569);
        if (paramb == null)
        {
          paramb = new NullPointerException();
          AppMethodBeat.o(217569);
          throw paramb;
        }
        this.bQS |= 0x4;
        this.cog = paramb.value;
        onChanged();
        AppMethodBeat.o(217569);
        return this;
      }
      
      private a o(com.google.b.g paramg)
      {
        AppMethodBeat.i(217567);
        if (paramg == null)
        {
          paramg = new NullPointerException();
          AppMethodBeat.o(217567);
          throw paramg;
        }
        this.bQS |= 0x1;
        this.col = paramg;
        onChanged();
        AppMethodBeat.o(217567);
        return this;
      }
      
      private a p(com.google.b.g paramg)
      {
        AppMethodBeat.i(217568);
        if (paramg == null)
        {
          paramg = new NullPointerException();
          AppMethodBeat.o(217568);
          throw paramg;
        }
        this.bQS |= 0x2;
        this.com = paramg;
        onChanged();
        AppMethodBeat.o(217568);
        return this;
      }
      
      public final bb.e Cb()
      {
        AppMethodBeat.i(217551);
        bb.e locale = b.Lw().b(b.g.class, a.class);
        AppMethodBeat.o(217551);
        return locale;
      }
      
      public final aj.a Cv()
      {
        AppMethodBeat.i(217554);
        aj.a locala = b.Lv();
        AppMethodBeat.o(217554);
        return locala;
      }
      
      public final a b(b.g paramg)
      {
        AppMethodBeat.i(217563);
        if (paramg == b.g.ML())
        {
          AppMethodBeat.o(217563);
          return this;
        }
        if (paramg.MI()) {
          o(paramg.col);
        }
        if (paramg.MJ()) {
          p(paramg.com);
        }
        if (paramg.Mu()) {
          b(paramg.Mv());
        }
        at(b.g.a(paramg));
        onChanged();
        AppMethodBeat.o(217563);
        return this;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class h
    extends bb
    implements j
  {
    @Deprecated
    public static final ci<h> bRf;
    private static final h cop;
    private int bQS;
    private byte bRd = -1;
    private volatile Object coo;
    
    static
    {
      AppMethodBeat.i(218427);
      cop = new h();
      bRf = new com.google.b.c() {};
      AppMethodBeat.o(218427);
    }
    
    private h()
    {
      this.coo = "";
    }
    
    private h(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private h(com.google.b.h paramh, com.google.b.ap paramap)
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
      //   28: invokestatic 76	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +113 -> 149
      //   39: aload_1
      //   40: invokevirtual 82	com/google/b/h:Av	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+143->190, 0:+146->193, 10:+43->90
      //   73: aload_1
      //   74: aload 5
      //   76: aload_2
      //   77: iload 4
      //   79: invokevirtual 85	com/tencent/ilink/tdi/b$h:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   82: ifne -47 -> 35
      //   85: iconst_1
      //   86: istore_3
      //   87: goto -52 -> 35
      //   90: aload_1
      //   91: invokevirtual 89	com/google/b/h:AD	()Lcom/google/b/g;
      //   94: astore 6
      //   96: aload_0
      //   97: aload_0
      //   98: getfield 91	com/tencent/ilink/tdi/b$h:bQS	I
      //   101: iconst_1
      //   102: ior
      //   103: putfield 91	com/tencent/ilink/tdi/b$h:bQS	I
      //   106: aload_0
      //   107: aload 6
      //   109: putfield 54	com/tencent/ilink/tdi/b$h:coo	Ljava/lang/Object;
      //   112: goto -77 -> 35
      //   115: astore_1
      //   116: aload_1
      //   117: aload_0
      //   118: putfield 95	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   121: ldc 67
      //   123: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   126: aload_1
      //   127: athrow
      //   128: astore_1
      //   129: aload_0
      //   130: aload 5
      //   132: invokevirtual 101	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   135: putfield 105	com/tencent/ilink/tdi/b$h:bVW	Lcom/google/b/da;
      //   138: aload_0
      //   139: invokevirtual 108	com/tencent/ilink/tdi/b$h:HZ	()V
      //   142: ldc 67
      //   144: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   147: aload_1
      //   148: athrow
      //   149: aload_0
      //   150: aload 5
      //   152: invokevirtual 101	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   155: putfield 105	com/tencent/ilink/tdi/b$h:bVW	Lcom/google/b/da;
      //   158: aload_0
      //   159: invokevirtual 108	com/tencent/ilink/tdi/b$h:HZ	()V
      //   162: ldc 67
      //   164: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   167: return
      //   168: astore_1
      //   169: new 64	com/google/b/bf
      //   172: dup
      //   173: aload_1
      //   174: invokespecial 111	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   177: astore_1
      //   178: aload_1
      //   179: aload_0
      //   180: putfield 95	com/google/b/bf:bZj	Lcom/google/b/bw;
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
      //   0	198	1	paramh	com.google.b.h
      //   0	198	2	paramap	com.google.b.ap
      //   34	161	3	i	int
      //   43	35	4	j	int
      //   31	120	5	locala	com.google.b.da.a
      //   94	14	6	localg	com.google.b.g
      // Exception table:
      //   from	to	target	type
      //   39	45	115	com/google/b/bf
      //   72	85	115	com/google/b/bf
      //   90	112	115	com/google/b/bf
      //   39	45	128	finally
      //   72	85	128	finally
      //   90	112	128	finally
      //   116	128	128	finally
      //   169	190	128	finally
      //   39	45	168	java/io/IOException
      //   72	85	168	java/io/IOException
      //   90	112	168	java/io/IOException
    }
    
    private a MQ()
    {
      AppMethodBeat.i(218416);
      if (this == cop)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(218416);
        return locala;
      }
      a locala = new a((byte)0).c(this);
      AppMethodBeat.o(218416);
      return locala;
    }
    
    public static h MR()
    {
      return cop;
    }
    
    public static h R(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(218415);
      paramArrayOfByte = (h)bRf.w(paramArrayOfByte);
      AppMethodBeat.o(218415);
      return paramArrayOfByte;
    }
    
    private String getPath()
    {
      AppMethodBeat.i(218410);
      Object localObject = this.coo;
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        AppMethodBeat.o(218410);
        return localObject;
      }
      localObject = (com.google.b.g)localObject;
      String str = ((com.google.b.g)localObject).Ap();
      if (((com.google.b.g)localObject).Aq()) {
        this.coo = str;
      }
      AppMethodBeat.o(218410);
      return str;
    }
    
    public final int Ad()
    {
      AppMethodBeat.i(218412);
      int i = this.bOZ;
      if (i != -1)
      {
        AppMethodBeat.o(218412);
        return i;
      }
      i = 0;
      if ((this.bQS & 0x1) != 0) {
        i = bb.f(1, this.coo) + 0;
      }
      i += this.bVW.Ad();
      this.bOZ = i;
      AppMethodBeat.o(218412);
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(218409);
      bb.e locale = b.LC().b(h.class, a.class);
      AppMethodBeat.o(218409);
      return locale;
    }
    
    public final ci<h> Co()
    {
      return bRf;
    }
    
    public final boolean MP()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final void a(com.google.b.i parami)
    {
      AppMethodBeat.i(218411);
      if ((this.bQS & 0x1) != 0) {
        bb.a(parami, 1, this.coo);
      }
      this.bVW.a(parami);
      AppMethodBeat.o(218411);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(218413);
      if (paramObject == this)
      {
        AppMethodBeat.o(218413);
        return true;
      }
      if (!(paramObject instanceof h))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(218413);
        return bool;
      }
      paramObject = (h)paramObject;
      if (MP() != paramObject.MP())
      {
        AppMethodBeat.o(218413);
        return false;
      }
      if ((MP()) && (!getPath().equals(paramObject.getPath())))
      {
        AppMethodBeat.o(218413);
        return false;
      }
      if (!this.bVW.equals(paramObject.bVW))
      {
        AppMethodBeat.o(218413);
        return false;
      }
      AppMethodBeat.o(218413);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(218414);
      if (this.bPa != 0)
      {
        i = this.bPa;
        AppMethodBeat.o(218414);
        return i;
      }
      int j = b.LB().hashCode() + 779;
      int i = j;
      if (MP()) {
        i = (j * 37 + 1) * 53 + getPath().hashCode();
      }
      i = i * 29 + this.bVW.hashCode();
      this.bPa = i;
      AppMethodBeat.o(218414);
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
      implements j
    {
      private int bQS;
      private Object coo;
      
      private a()
      {
        AppMethodBeat.i(217500);
        this.coo = "";
        b.h.MS();
        AppMethodBeat.o(217500);
      }
      
      private a(bb.b paramb)
      {
        super();
        AppMethodBeat.i(217501);
        this.coo = "";
        b.h.MS();
        AppMethodBeat.o(217501);
      }
      
      private a J(bt parambt)
      {
        AppMethodBeat.i(217508);
        if ((parambt instanceof b.h))
        {
          parambt = c((b.h)parambt);
          AppMethodBeat.o(217508);
          return parambt;
        }
        super.a(parambt);
        AppMethodBeat.o(217508);
        return this;
      }
      
      /* Error */
      private a K(com.google.b.h paramh, com.google.b.ap paramap)
      {
        // Byte code:
        //   0: ldc 63
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 67	com/tencent/ilink/tdi/b$h:bRf	Lcom/google/b/ci;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 73 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$h
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 55	com/tencent/ilink/tdi/b$h$a:c	(Lcom/tencent/ilink/tdi/b$h;)Lcom/tencent/ilink/tdi/b$h$a;
        //   30: pop
        //   31: ldc 63
        //   33: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 77	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$h
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 81	com/google/b/bf:Im	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 63
        //   54: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 55	com/tencent/ilink/tdi/b$h$a:c	(Lcom/tencent/ilink/tdi/b$h;)Lcom/tencent/ilink/tdi/b$h$a;
        //   69: pop
        //   70: ldc 63
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
        //   0	83	1	paramh	com.google.b.h
        //   0	83	2	paramap	com.google.b.ap
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/b/bf
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private b.h MT()
      {
        AppMethodBeat.i(217504);
        Object localObject = MU();
        if (!((b.h)localObject).isInitialized())
        {
          localObject = b((bt)localObject);
          AppMethodBeat.o(217504);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(217504);
        return localObject;
      }
      
      private b.h MU()
      {
        int i = 0;
        AppMethodBeat.i(217505);
        b.h localh = new b.h(this, (byte)0);
        if ((this.bQS & 0x1) != 0) {
          i = 1;
        }
        b.h.a(localh, this.coo);
        b.h.a(localh, i);
        Ib();
        AppMethodBeat.o(217505);
        return localh;
      }
      
      private a as(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217506);
        paramf = (a)super.d(paramf, paramObject);
        AppMethodBeat.o(217506);
        return paramf;
      }
      
      private a at(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217507);
        paramf = (a)super.c(paramf, paramObject);
        AppMethodBeat.o(217507);
        return paramf;
      }
      
      private a au(da paramda)
      {
        AppMethodBeat.i(217513);
        paramda = (a)super.e(paramda);
        AppMethodBeat.o(217513);
        return paramda;
      }
      
      private a av(da paramda)
      {
        AppMethodBeat.i(217514);
        paramda = (a)super.d(paramda);
        AppMethodBeat.o(217514);
        return paramda;
      }
      
      public final bb.e Cb()
      {
        AppMethodBeat.i(217499);
        bb.e locale = b.LC().b(b.h.class, a.class);
        AppMethodBeat.o(217499);
        return locale;
      }
      
      public final aj.a Cv()
      {
        AppMethodBeat.i(217502);
        aj.a locala = b.LB();
        AppMethodBeat.o(217502);
        return locala;
      }
      
      public final a c(b.h paramh)
      {
        AppMethodBeat.i(217509);
        if (paramh == b.h.MR())
        {
          AppMethodBeat.o(217509);
          return this;
        }
        if (paramh.MP())
        {
          this.bQS |= 0x1;
          this.coo = b.h.a(paramh);
          onChanged();
        }
        av(b.h.b(paramh));
        onChanged();
        AppMethodBeat.o(217509);
        return this;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class i
    extends bb
    implements k
  {
    @Deprecated
    public static final ci<i> bRf;
    private static final i cor;
    private int bQS;
    private byte bRd = -1;
    com.google.b.g coq;
    
    static
    {
      AppMethodBeat.i(218069);
      cor = new i();
      bRf = new com.google.b.c() {};
      AppMethodBeat.o(218069);
    }
    
    private i()
    {
      this.coq = com.google.b.g.bPf;
    }
    
    private i(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private i(com.google.b.h paramh, com.google.b.ap paramap)
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
      //   28: invokestatic 78	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +109 -> 145
      //   39: aload_1
      //   40: invokevirtual 84	com/google/b/h:Av	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+139->186, 0:+142->189, 10:+43->90
      //   73: aload_1
      //   74: aload 5
      //   76: aload_2
      //   77: iload 4
      //   79: invokevirtual 87	com/tencent/ilink/tdi/b$i:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   82: ifne -47 -> 35
      //   85: iconst_1
      //   86: istore_3
      //   87: goto -52 -> 35
      //   90: aload_0
      //   91: aload_0
      //   92: getfield 89	com/tencent/ilink/tdi/b$i:bQS	I
      //   95: iconst_1
      //   96: ior
      //   97: putfield 89	com/tencent/ilink/tdi/b$i:bQS	I
      //   100: aload_0
      //   101: aload_1
      //   102: invokevirtual 93	com/google/b/h:AD	()Lcom/google/b/g;
      //   105: putfield 56	com/tencent/ilink/tdi/b$i:coq	Lcom/google/b/g;
      //   108: goto -73 -> 35
      //   111: astore_1
      //   112: aload_1
      //   113: aload_0
      //   114: putfield 97	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   117: ldc 69
      //   119: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   122: aload_1
      //   123: athrow
      //   124: astore_1
      //   125: aload_0
      //   126: aload 5
      //   128: invokevirtual 103	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   131: putfield 107	com/tencent/ilink/tdi/b$i:bVW	Lcom/google/b/da;
      //   134: aload_0
      //   135: invokevirtual 110	com/tencent/ilink/tdi/b$i:HZ	()V
      //   138: ldc 69
      //   140: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   143: aload_1
      //   144: athrow
      //   145: aload_0
      //   146: aload 5
      //   148: invokevirtual 103	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   151: putfield 107	com/tencent/ilink/tdi/b$i:bVW	Lcom/google/b/da;
      //   154: aload_0
      //   155: invokevirtual 110	com/tencent/ilink/tdi/b$i:HZ	()V
      //   158: ldc 69
      //   160: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   163: return
      //   164: astore_1
      //   165: new 66	com/google/b/bf
      //   168: dup
      //   169: aload_1
      //   170: invokespecial 113	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   173: astore_1
      //   174: aload_1
      //   175: aload_0
      //   176: putfield 97	com/google/b/bf:bZj	Lcom/google/b/bw;
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
      //   0	194	1	paramh	com.google.b.h
      //   0	194	2	paramap	com.google.b.ap
      //   34	157	3	i	int
      //   43	35	4	j	int
      //   31	116	5	locala	com.google.b.da.a
      // Exception table:
      //   from	to	target	type
      //   39	45	111	com/google/b/bf
      //   72	85	111	com/google/b/bf
      //   90	108	111	com/google/b/bf
      //   39	45	124	finally
      //   72	85	124	finally
      //   90	108	124	finally
      //   112	124	124	finally
      //   165	186	124	finally
      //   39	45	164	java/io/IOException
      //   72	85	164	java/io/IOException
      //   90	108	164	java/io/IOException
    }
    
    private a MW()
    {
      AppMethodBeat.i(218052);
      if (this == cor)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(218052);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(218052);
      return locala;
    }
    
    public static i MX()
    {
      return cor;
    }
    
    public static i S(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(218051);
      paramArrayOfByte = (i)bRf.w(paramArrayOfByte);
      AppMethodBeat.o(218051);
      return paramArrayOfByte;
    }
    
    public final int Ad()
    {
      AppMethodBeat.i(218046);
      int i = this.bOZ;
      if (i != -1)
      {
        AppMethodBeat.o(218046);
        return i;
      }
      i = 0;
      if ((this.bQS & 0x1) != 0) {
        i = com.google.b.i.c(1, this.coq) + 0;
      }
      i += this.bVW.Ad();
      this.bOZ = i;
      AppMethodBeat.o(218046);
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(218041);
      bb.e locale = b.LM().b(i.class, a.class);
      AppMethodBeat.o(218041);
      return locale;
    }
    
    public final ci<i> Co()
    {
      return bRf;
    }
    
    public final boolean MV()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final void a(com.google.b.i parami)
    {
      AppMethodBeat.i(218044);
      if ((this.bQS & 0x1) != 0) {
        parami.a(1, this.coq);
      }
      this.bVW.a(parami);
      AppMethodBeat.o(218044);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(218048);
      if (paramObject == this)
      {
        AppMethodBeat.o(218048);
        return true;
      }
      if (!(paramObject instanceof i))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(218048);
        return bool;
      }
      paramObject = (i)paramObject;
      if (MV() != paramObject.MV())
      {
        AppMethodBeat.o(218048);
        return false;
      }
      if ((MV()) && (!this.coq.equals(paramObject.coq)))
      {
        AppMethodBeat.o(218048);
        return false;
      }
      if (!this.bVW.equals(paramObject.bVW))
      {
        AppMethodBeat.o(218048);
        return false;
      }
      AppMethodBeat.o(218048);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(218049);
      if (this.bPa != 0)
      {
        i = this.bPa;
        AppMethodBeat.o(218049);
        return i;
      }
      int j = b.LL().hashCode() + 779;
      int i = j;
      if (MV()) {
        i = (j * 37 + 1) * 53 + this.coq.hashCode();
      }
      i = i * 29 + this.bVW.hashCode();
      this.bPa = i;
      AppMethodBeat.o(218049);
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
      implements k
    {
      private int bQS;
      private com.google.b.g coq;
      
      private a()
      {
        AppMethodBeat.i(217318);
        this.coq = com.google.b.g.bPf;
        b.i.MY();
        AppMethodBeat.o(217318);
      }
      
      private a(bb.b paramb)
      {
        super();
        AppMethodBeat.i(217320);
        this.coq = com.google.b.g.bPf;
        b.i.MY();
        AppMethodBeat.o(217320);
      }
      
      private a K(bt parambt)
      {
        AppMethodBeat.i(217330);
        if ((parambt instanceof b.i))
        {
          parambt = b((b.i)parambt);
          AppMethodBeat.o(217330);
          return parambt;
        }
        super.a(parambt);
        AppMethodBeat.o(217330);
        return this;
      }
      
      /* Error */
      private a L(com.google.b.h paramh, com.google.b.ap paramap)
      {
        // Byte code:
        //   0: ldc 65
        //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 69	com/tencent/ilink/tdi/b$i:bRf	Lcom/google/b/ci;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 75 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$i
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 57	com/tencent/ilink/tdi/b$i$a:b	(Lcom/tencent/ilink/tdi/b$i;)Lcom/tencent/ilink/tdi/b$i$a;
        //   30: pop
        //   31: ldc 65
        //   33: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 79	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$i
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 83	com/google/b/bf:Im	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 65
        //   54: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 57	com/tencent/ilink/tdi/b$i$a:b	(Lcom/tencent/ilink/tdi/b$i;)Lcom/tencent/ilink/tdi/b$i$a;
        //   69: pop
        //   70: ldc 65
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
        //   0	83	1	paramh	com.google.b.h
        //   0	83	2	paramap	com.google.b.ap
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/b/bf
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private b.i MZ()
      {
        AppMethodBeat.i(217323);
        Object localObject = Na();
        if (!((b.i)localObject).isInitialized())
        {
          localObject = b((bt)localObject);
          AppMethodBeat.o(217323);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(217323);
        return localObject;
      }
      
      private b.i Na()
      {
        int i = 0;
        AppMethodBeat.i(217325);
        b.i locali = new b.i(this, (byte)0);
        if ((this.bQS & 0x1) != 0) {
          i = 1;
        }
        b.i.a(locali, this.coq);
        b.i.a(locali, i);
        Ib();
        AppMethodBeat.o(217325);
        return locali;
      }
      
      private a au(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217327);
        paramf = (a)super.d(paramf, paramObject);
        AppMethodBeat.o(217327);
        return paramf;
      }
      
      private a av(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217328);
        paramf = (a)super.c(paramf, paramObject);
        AppMethodBeat.o(217328);
        return paramf;
      }
      
      private a aw(da paramda)
      {
        AppMethodBeat.i(217340);
        paramda = (a)super.e(paramda);
        AppMethodBeat.o(217340);
        return paramda;
      }
      
      private a ax(da paramda)
      {
        AppMethodBeat.i(217342);
        paramda = (a)super.d(paramda);
        AppMethodBeat.o(217342);
        return paramda;
      }
      
      private a q(com.google.b.g paramg)
      {
        AppMethodBeat.i(217339);
        if (paramg == null)
        {
          paramg = new NullPointerException();
          AppMethodBeat.o(217339);
          throw paramg;
        }
        this.bQS |= 0x1;
        this.coq = paramg;
        onChanged();
        AppMethodBeat.o(217339);
        return this;
      }
      
      public final bb.e Cb()
      {
        AppMethodBeat.i(217316);
        bb.e locale = b.LM().b(b.i.class, a.class);
        AppMethodBeat.o(217316);
        return locale;
      }
      
      public final aj.a Cv()
      {
        AppMethodBeat.i(217321);
        aj.a locala = b.LL();
        AppMethodBeat.o(217321);
        return locala;
      }
      
      public final a b(b.i parami)
      {
        AppMethodBeat.i(217332);
        if (parami == b.i.MX())
        {
          AppMethodBeat.o(217332);
          return this;
        }
        if (parami.MV()) {
          q(parami.coq);
        }
        ax(b.i.a(parami));
        onChanged();
        AppMethodBeat.o(217332);
        return this;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class j
    extends bb
    implements l
  {
    @Deprecated
    public static final ci<j> bRf;
    private static final j cov;
    private int bQS;
    private byte bRd = -1;
    int cos;
    com.google.b.g cot;
    int cou;
    
    static
    {
      AppMethodBeat.i(217396);
      cov = new j();
      bRf = new com.google.b.c() {};
      AppMethodBeat.o(217396);
    }
    
    private j()
    {
      this.cot = com.google.b.g.bPf;
    }
    
    private j(bb.a<?> parama)
    {
      super();
    }
    
    /* Error */
    private j(com.google.b.h paramh, com.google.b.ap paramap)
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
      //   28: invokestatic 81	com/google/b/da:Jj	()Lcom/google/b/da$a;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +189 -> 225
      //   39: aload_1
      //   40: invokevirtual 87	com/google/b/h:Av	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+197->244, 0:+200->247, 8:+59->106, 18:+114->161, 24:+157->204
      //   89: aload_1
      //   90: aload 5
      //   92: aload_2
      //   93: iload 4
      //   95: invokevirtual 90	com/tencent/ilink/tdi/b$j:a	(Lcom/google/b/h;Lcom/google/b/da$a;Lcom/google/b/ap;I)Z
      //   98: ifne -63 -> 35
      //   101: iconst_1
      //   102: istore_3
      //   103: goto -68 -> 35
      //   106: aload_0
      //   107: aload_0
      //   108: getfield 92	com/tencent/ilink/tdi/b$j:bQS	I
      //   111: iconst_1
      //   112: ior
      //   113: putfield 92	com/tencent/ilink/tdi/b$j:bQS	I
      //   116: aload_0
      //   117: aload_1
      //   118: invokevirtual 95	com/google/b/h:AE	()I
      //   121: putfield 97	com/tencent/ilink/tdi/b$j:cos	I
      //   124: goto -89 -> 35
      //   127: astore_1
      //   128: aload_1
      //   129: aload_0
      //   130: putfield 101	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   133: ldc 72
      //   135: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   138: aload_1
      //   139: athrow
      //   140: astore_1
      //   141: aload_0
      //   142: aload 5
      //   144: invokevirtual 107	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   147: putfield 111	com/tencent/ilink/tdi/b$j:bVW	Lcom/google/b/da;
      //   150: aload_0
      //   151: invokevirtual 114	com/tencent/ilink/tdi/b$j:HZ	()V
      //   154: ldc 72
      //   156: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   159: aload_1
      //   160: athrow
      //   161: aload_0
      //   162: aload_0
      //   163: getfield 92	com/tencent/ilink/tdi/b$j:bQS	I
      //   166: iconst_2
      //   167: ior
      //   168: putfield 92	com/tencent/ilink/tdi/b$j:bQS	I
      //   171: aload_0
      //   172: aload_1
      //   173: invokevirtual 118	com/google/b/h:AD	()Lcom/google/b/g;
      //   176: putfield 59	com/tencent/ilink/tdi/b$j:cot	Lcom/google/b/g;
      //   179: goto -144 -> 35
      //   182: astore_1
      //   183: new 69	com/google/b/bf
      //   186: dup
      //   187: aload_1
      //   188: invokespecial 121	com/google/b/bf:<init>	(Ljava/io/IOException;)V
      //   191: astore_1
      //   192: aload_1
      //   193: aload_0
      //   194: putfield 101	com/google/b/bf:bZj	Lcom/google/b/bw;
      //   197: ldc 72
      //   199: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   202: aload_1
      //   203: athrow
      //   204: aload_0
      //   205: aload_0
      //   206: getfield 92	com/tencent/ilink/tdi/b$j:bQS	I
      //   209: iconst_4
      //   210: ior
      //   211: putfield 92	com/tencent/ilink/tdi/b$j:bQS	I
      //   214: aload_0
      //   215: aload_1
      //   216: invokevirtual 124	com/google/b/h:Ay	()I
      //   219: putfield 126	com/tencent/ilink/tdi/b$j:cou	I
      //   222: goto -187 -> 35
      //   225: aload_0
      //   226: aload 5
      //   228: invokevirtual 107	com/google/b/da$a:Jm	()Lcom/google/b/da;
      //   231: putfield 111	com/tencent/ilink/tdi/b$j:bVW	Lcom/google/b/da;
      //   234: aload_0
      //   235: invokevirtual 114	com/tencent/ilink/tdi/b$j:HZ	()V
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
      //   0	252	1	paramh	com.google.b.h
      //   0	252	2	paramap	com.google.b.ap
      //   34	215	3	i	int
      //   43	51	4	j	int
      //   31	196	5	locala	com.google.b.da.a
      // Exception table:
      //   from	to	target	type
      //   39	45	127	com/google/b/bf
      //   88	101	127	com/google/b/bf
      //   106	124	127	com/google/b/bf
      //   161	179	127	com/google/b/bf
      //   204	222	127	com/google/b/bf
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
    
    private a Ne()
    {
      AppMethodBeat.i(217389);
      if (this == cov)
      {
        locala = new a((byte)0);
        AppMethodBeat.o(217389);
        return locala;
      }
      a locala = new a((byte)0).b(this);
      AppMethodBeat.o(217389);
      return locala;
    }
    
    public static j Nf()
    {
      return cov;
    }
    
    public static j T(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(217388);
      paramArrayOfByte = (j)bRf.w(paramArrayOfByte);
      AppMethodBeat.o(217388);
      return paramArrayOfByte;
    }
    
    public final int Ad()
    {
      AppMethodBeat.i(217383);
      int i = this.bOZ;
      if (i != -1)
      {
        AppMethodBeat.o(217383);
        return i;
      }
      int j = 0;
      if ((this.bQS & 0x1) != 0) {
        j = com.google.b.i.bN(1, this.cos) + 0;
      }
      i = j;
      if ((this.bQS & 0x2) != 0) {
        i = j + com.google.b.i.c(2, this.cot);
      }
      j = i;
      if ((this.bQS & 0x4) != 0) {
        j = i + com.google.b.i.bM(3, this.cou);
      }
      i = j + this.bVW.Ad();
      this.bOZ = i;
      AppMethodBeat.o(217383);
      return i;
    }
    
    public final da Ca()
    {
      return this.bVW;
    }
    
    public final bb.e Cb()
    {
      AppMethodBeat.i(217376);
      bb.e locale = b.LA().b(j.class, a.class);
      AppMethodBeat.o(217376);
      return locale;
    }
    
    public final ci<j> Co()
    {
      return bRf;
    }
    
    public final boolean Nb()
    {
      return (this.bQS & 0x1) != 0;
    }
    
    public final boolean Nc()
    {
      return (this.bQS & 0x2) != 0;
    }
    
    public final boolean Nd()
    {
      return (this.bQS & 0x4) != 0;
    }
    
    public final void a(com.google.b.i parami)
    {
      AppMethodBeat.i(217381);
      if ((this.bQS & 0x1) != 0) {
        parami.bK(1, this.cos);
      }
      if ((this.bQS & 0x2) != 0) {
        parami.a(2, this.cot);
      }
      if ((this.bQS & 0x4) != 0) {
        parami.bJ(3, this.cou);
      }
      this.bVW.a(parami);
      AppMethodBeat.o(217381);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(217385);
      if (paramObject == this)
      {
        AppMethodBeat.o(217385);
        return true;
      }
      if (!(paramObject instanceof j))
      {
        boolean bool = super.equals(paramObject);
        AppMethodBeat.o(217385);
        return bool;
      }
      paramObject = (j)paramObject;
      if (Nb() != paramObject.Nb())
      {
        AppMethodBeat.o(217385);
        return false;
      }
      if ((Nb()) && (this.cos != paramObject.cos))
      {
        AppMethodBeat.o(217385);
        return false;
      }
      if (Nc() != paramObject.Nc())
      {
        AppMethodBeat.o(217385);
        return false;
      }
      if ((Nc()) && (!this.cot.equals(paramObject.cot)))
      {
        AppMethodBeat.o(217385);
        return false;
      }
      if (Nd() != paramObject.Nd())
      {
        AppMethodBeat.o(217385);
        return false;
      }
      if ((Nd()) && (this.cou != paramObject.cou))
      {
        AppMethodBeat.o(217385);
        return false;
      }
      if (!this.bVW.equals(paramObject.bVW))
      {
        AppMethodBeat.o(217385);
        return false;
      }
      AppMethodBeat.o(217385);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(217387);
      if (this.bPa != 0)
      {
        i = this.bPa;
        AppMethodBeat.o(217387);
        return i;
      }
      int j = b.Lz().hashCode() + 779;
      int i = j;
      if (Nb()) {
        i = (j * 37 + 1) * 53 + this.cos;
      }
      j = i;
      if (Nc()) {
        j = (i * 37 + 2) * 53 + this.cot.hashCode();
      }
      i = j;
      if (Nd()) {
        i = (j * 37 + 3) * 53 + this.cou;
      }
      i = i * 29 + this.bVW.hashCode();
      this.bPa = i;
      AppMethodBeat.o(217387);
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
      implements l
    {
      private int bQS;
      private int cos;
      private com.google.b.g cot;
      private int cou;
      
      private a()
      {
        AppMethodBeat.i(217412);
        this.cot = com.google.b.g.bPf;
        b.j.Ng();
        AppMethodBeat.o(217412);
      }
      
      private a(bb.b paramb)
      {
        super();
        AppMethodBeat.i(217413);
        this.cot = com.google.b.g.bPf;
        b.j.Ng();
        AppMethodBeat.o(217413);
      }
      
      private a L(bt parambt)
      {
        AppMethodBeat.i(217421);
        if ((parambt instanceof b.j))
        {
          parambt = b((b.j)parambt);
          AppMethodBeat.o(217421);
          return parambt;
        }
        super.a(parambt);
        AppMethodBeat.o(217421);
        return this;
      }
      
      /* Error */
      private a M(com.google.b.h paramh, com.google.b.ap paramap)
      {
        // Byte code:
        //   0: ldc 68
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 72	com/tencent/ilink/tdi/b$j:bRf	Lcom/google/b/ci;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 78 3 0
        //   17: checkcast 9	com/tencent/ilink/tdi/b$j
        //   20: astore_1
        //   21: aload_1
        //   22: ifnull +9 -> 31
        //   25: aload_0
        //   26: aload_1
        //   27: invokevirtual 60	com/tencent/ilink/tdi/b$j$a:b	(Lcom/tencent/ilink/tdi/b$j;)Lcom/tencent/ilink/tdi/b$j$a;
        //   30: pop
        //   31: ldc 68
        //   33: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   36: aload_0
        //   37: areturn
        //   38: astore_1
        //   39: aload_1
        //   40: getfield 82	com/google/b/bf:bZj	Lcom/google/b/bw;
        //   43: checkcast 9	com/tencent/ilink/tdi/b$j
        //   46: astore_2
        //   47: aload_1
        //   48: invokevirtual 86	com/google/b/bf:Im	()Ljava/io/IOException;
        //   51: astore_1
        //   52: ldc 68
        //   54: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   57: aload_1
        //   58: athrow
        //   59: astore_1
        //   60: aload_2
        //   61: ifnull +9 -> 70
        //   64: aload_0
        //   65: aload_2
        //   66: invokevirtual 60	com/tencent/ilink/tdi/b$j$a:b	(Lcom/tencent/ilink/tdi/b$j;)Lcom/tencent/ilink/tdi/b$j$a;
        //   69: pop
        //   70: ldc 68
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
        //   0	83	1	paramh	com.google.b.h
        //   0	83	2	paramap	com.google.b.ap
        //   6	73	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	38	com/google/b/bf
        //   47	59	59	finally
        //   7	21	77	finally
        //   39	47	77	finally
      }
      
      private b.j Nh()
      {
        AppMethodBeat.i(217416);
        Object localObject = Ni();
        if (!((b.j)localObject).isInitialized())
        {
          localObject = b((bt)localObject);
          AppMethodBeat.o(217416);
          throw ((Throwable)localObject);
        }
        AppMethodBeat.o(217416);
        return localObject;
      }
      
      private b.j Ni()
      {
        int j = 0;
        AppMethodBeat.i(217418);
        b.j localj = new b.j(this, (byte)0);
        int k = this.bQS;
        if ((k & 0x1) != 0)
        {
          b.j.a(localj, this.cos);
          j = 1;
        }
        int i = j;
        if ((k & 0x2) != 0) {
          i = j | 0x2;
        }
        b.j.a(localj, this.cot);
        j = i;
        if ((k & 0x4) != 0)
        {
          b.j.b(localj, this.cou);
          j = i | 0x4;
        }
        b.j.c(localj, j);
        Ib();
        AppMethodBeat.o(217418);
        return localj;
      }
      
      private a aw(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217419);
        paramf = (a)super.d(paramf, paramObject);
        AppMethodBeat.o(217419);
        return paramf;
      }
      
      private a ax(aj.f paramf, Object paramObject)
      {
        AppMethodBeat.i(217420);
        paramf = (a)super.c(paramf, paramObject);
        AppMethodBeat.o(217420);
        return paramf;
      }
      
      private a ay(da paramda)
      {
        AppMethodBeat.i(217427);
        paramda = (a)super.e(paramda);
        AppMethodBeat.o(217427);
        return paramda;
      }
      
      private a az(da paramda)
      {
        AppMethodBeat.i(217428);
        paramda = (a)super.d(paramda);
        AppMethodBeat.o(217428);
        return paramda;
      }
      
      private a iB(int paramInt)
      {
        AppMethodBeat.i(217424);
        this.bQS |= 0x1;
        this.cos = paramInt;
        onChanged();
        AppMethodBeat.o(217424);
        return this;
      }
      
      private a iC(int paramInt)
      {
        AppMethodBeat.i(217426);
        this.bQS |= 0x4;
        this.cou = paramInt;
        onChanged();
        AppMethodBeat.o(217426);
        return this;
      }
      
      private a r(com.google.b.g paramg)
      {
        AppMethodBeat.i(217425);
        if (paramg == null)
        {
          paramg = new NullPointerException();
          AppMethodBeat.o(217425);
          throw paramg;
        }
        this.bQS |= 0x2;
        this.cot = paramg;
        onChanged();
        AppMethodBeat.o(217425);
        return this;
      }
      
      public final bb.e Cb()
      {
        AppMethodBeat.i(217411);
        bb.e locale = b.LA().b(b.j.class, a.class);
        AppMethodBeat.o(217411);
        return locale;
      }
      
      public final aj.a Cv()
      {
        AppMethodBeat.i(217414);
        aj.a locala = b.Lz();
        AppMethodBeat.o(217414);
        return locala;
      }
      
      public final a b(b.j paramj)
      {
        AppMethodBeat.i(217422);
        if (paramj == b.j.Nf())
        {
          AppMethodBeat.o(217422);
          return this;
        }
        if (paramj.Nb()) {
          iB(paramj.cos);
        }
        if (paramj.Nc()) {
          r(paramj.cot);
        }
        if (paramj.Nd()) {
          iC(paramj.cou);
        }
        az(b.j.a(paramj));
        onChanged();
        AppMethodBeat.o(217422);
        return this;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.ilink.tdi.b
 * JD-Core Version:    0.7.0.1
 */