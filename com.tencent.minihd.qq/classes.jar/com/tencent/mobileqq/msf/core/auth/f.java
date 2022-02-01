package com.tencent.mobileqq.msf.core.auth;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.s;
import com.tencent.mobileqq.msf.core.u;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.msf.service.protocol.security.c;
import com.tencent.msf.service.protocol.security.d;
import com.tencent.msf.service.protocol.security.g;
import com.tencent.msf.service.protocol.security.i;
import com.tencent.msf.service.protocol.security.k;
import com.tencent.msf.service.protocol.security.m;
import com.tencent.msf.service.protocol.security.n;
import com.tencent.msf.service.protocol.security.o;
import com.tencent.msf.service.protocol.security.p;
import com.tencent.msf.service.protocol.security.q;
import com.tencent.msf.service.protocol.security.r;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class f
{
  public static final String a = "test";
  public static final String b = "cmdstr";
  public static final String c = "123";
  public static final String d = "RequestHeader";
  public static final String e = "RequestVerifyPic";
  public static final String f = "RespondVerifyPic";
  public static final String g = "RequestRefreshVPic";
  public static final String h = "RespondRefreshVPic";
  public static final String i = "RespondAuth";
  public static final String j = "RespondHeader";
  public static final String k = "RequestCustomSig";
  public static final String l = "RespondCustomSig";
  public static final int m = 0;
  private static final String o = "MSF.C.AuthCoder";
  b n;
  
  public f(b paramb)
  {
    this.n = paramb;
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  public static void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt1, paramInt2);
  }
  
  public static void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt1, paramInt3);
  }
  
  /* Error */
  private static boolean a(ToServiceMsg paramToServiceMsg, k paramk, a parama)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 73	com/tencent/qphone/base/util/Cryptor
    //   6: dup
    //   7: invokespecial 74	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   10: astore 5
    //   12: aload_2
    //   13: ifnull +250 -> 263
    //   16: aload_2
    //   17: aload_1
    //   18: getfield 79	com/tencent/msf/service/protocol/security/k:h	[B
    //   21: invokevirtual 84	com/tencent/mobileqq/msf/core/auth/a:g	([B)V
    //   24: aload_2
    //   25: aload_1
    //   26: getfield 86	com/tencent/msf/service/protocol/security/k:g	[B
    //   29: invokevirtual 88	com/tencent/mobileqq/msf/core/auth/a:f	([B)V
    //   32: aload_2
    //   33: invokevirtual 91	com/tencent/mobileqq/msf/core/auth/a:j	()[B
    //   36: astore 6
    //   38: aload 5
    //   40: aload_1
    //   41: getfield 79	com/tencent/msf/service/protocol/security/k:h	[B
    //   44: aload 6
    //   46: invokevirtual 95	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   49: astore 6
    //   51: bipush 16
    //   53: newarray byte
    //   55: astore 7
    //   57: aload 6
    //   59: arraylength
    //   60: bipush 16
    //   62: isub
    //   63: newarray byte
    //   65: astore 8
    //   67: aload 7
    //   69: iconst_0
    //   70: aload 6
    //   72: bipush 16
    //   74: invokestatic 97	com/tencent/mobileqq/msf/core/auth/f:a	([BI[BI)V
    //   77: aload 8
    //   79: iconst_0
    //   80: aload 6
    //   82: bipush 16
    //   84: aload 6
    //   86: arraylength
    //   87: bipush 16
    //   89: isub
    //   90: invokestatic 99	com/tencent/mobileqq/msf/core/auth/f:a	([BI[BII)V
    //   93: aload_2
    //   94: aload 8
    //   96: invokevirtual 101	com/tencent/mobileqq/msf/core/auth/a:e	([B)V
    //   99: aload 5
    //   101: aload_1
    //   102: getfield 86	com/tencent/msf/service/protocol/security/k:g	[B
    //   105: aload 7
    //   107: invokevirtual 95	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   110: astore 8
    //   112: new 103	java/io/ByteArrayInputStream
    //   115: dup
    //   116: aload 8
    //   118: invokespecial 105	java/io/ByteArrayInputStream:<init>	([B)V
    //   121: astore 5
    //   123: new 107	java/io/DataInputStream
    //   126: dup
    //   127: aload 5
    //   129: invokespecial 110	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   132: astore 6
    //   134: aload 6
    //   136: invokevirtual 114	java/io/DataInputStream:readInt	()I
    //   139: iconst_4
    //   140: isub
    //   141: istore_3
    //   142: iload_3
    //   143: newarray byte
    //   145: astore 7
    //   147: aload 6
    //   149: aload 7
    //   151: invokevirtual 118	java/io/DataInputStream:read	([B)I
    //   154: pop
    //   155: aload_2
    //   156: aload 7
    //   158: invokevirtual 120	com/tencent/mobileqq/msf/core/auth/a:h	([B)V
    //   161: iconst_4
    //   162: newarray byte
    //   164: astore 7
    //   166: aload 6
    //   168: aload 7
    //   170: invokevirtual 118	java/io/DataInputStream:read	([B)I
    //   173: pop
    //   174: aload_1
    //   175: getfield 122	com/tencent/msf/service/protocol/security/k:f	I
    //   178: bipush 10
    //   180: if_icmpeq +92 -> 272
    //   183: aload 8
    //   185: arraylength
    //   186: istore_3
    //   187: aload_1
    //   188: getfield 124	com/tencent/msf/service/protocol/security/k:j	I
    //   191: ifeq +75 -> 266
    //   194: aload_1
    //   195: getfield 124	com/tencent/msf/service/protocol/security/k:j	I
    //   198: istore_3
    //   199: iload_3
    //   200: newarray byte
    //   202: astore_1
    //   203: aload 6
    //   205: aload_1
    //   206: invokevirtual 118	java/io/DataInputStream:read	([B)I
    //   209: pop
    //   210: aload_2
    //   211: new 126	java/lang/String
    //   214: dup
    //   215: aload_1
    //   216: invokespecial 127	java/lang/String:<init>	([B)V
    //   219: invokevirtual 130	com/tencent/mobileqq/msf/core/auth/a:b	(Ljava/lang/String;)V
    //   222: bipush 16
    //   224: newarray byte
    //   226: astore_1
    //   227: aload_1
    //   228: iconst_0
    //   229: aload 7
    //   231: aload 7
    //   233: arraylength
    //   234: invokestatic 97	com/tencent/mobileqq/msf/core/auth/f:a	([BI[BI)V
    //   237: aload_2
    //   238: aload_1
    //   239: invokevirtual 132	com/tencent/mobileqq/msf/core/auth/a:j	([B)V
    //   242: aload_2
    //   243: aload_0
    //   244: invokestatic 137	com/tencent/mobileqq/msf/service/h:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Ljava/lang/String;
    //   247: invokevirtual 139	com/tencent/mobileqq/msf/core/auth/a:d	(Ljava/lang/String;)V
    //   250: aload 5
    //   252: invokevirtual 142	java/io/ByteArrayInputStream:close	()V
    //   255: aload 6
    //   257: invokevirtual 143	java/io/DataInputStream:close	()V
    //   260: iconst_1
    //   261: istore 4
    //   263: iload 4
    //   265: ireturn
    //   266: bipush 24
    //   268: istore_3
    //   269: goto -70 -> 199
    //   272: aload_2
    //   273: ldc 145
    //   275: invokevirtual 130	com/tencent/mobileqq/msf/core/auth/a:b	(Ljava/lang/String;)V
    //   278: goto -56 -> 222
    //   281: astore_0
    //   282: aload 5
    //   284: invokevirtual 142	java/io/ByteArrayInputStream:close	()V
    //   287: aload 6
    //   289: invokevirtual 143	java/io/DataInputStream:close	()V
    //   292: goto -32 -> 260
    //   295: astore_0
    //   296: goto -36 -> 260
    //   299: astore_0
    //   300: aload 5
    //   302: invokevirtual 142	java/io/ByteArrayInputStream:close	()V
    //   305: aload 6
    //   307: invokevirtual 143	java/io/DataInputStream:close	()V
    //   310: aload_0
    //   311: athrow
    //   312: astore_1
    //   313: goto -3 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramToServiceMsg	ToServiceMsg
    //   0	316	1	paramk	k
    //   0	316	2	parama	a
    //   141	128	3	i1	int
    //   1	263	4	bool	boolean
    //   10	291	5	localObject1	Object
    //   36	270	6	localObject2	Object
    //   55	177	7	arrayOfByte1	byte[]
    //   65	119	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   134	199	281	java/io/IOException
    //   199	222	281	java/io/IOException
    //   222	250	281	java/io/IOException
    //   272	278	281	java/io/IOException
    //   250	260	295	java/lang/Exception
    //   282	292	295	java/lang/Exception
    //   134	199	299	finally
    //   199	222	299	finally
    //   222	250	299	finally
    //   272	278	299	finally
    //   300	310	312	java/lang/Exception
  }
  
  private byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[24];
    int i2 = (short)paramArrayOfByte.length;
    int i1 = i2;
    if (i2 > 16) {
      i1 = 16;
    }
    long l1 = Long.valueOf(paramString).longValue();
    paramString = new byte[8];
    a(paramString, 4, l1);
    a(arrayOfByte, 0, paramArrayOfByte, i1);
    a(arrayOfByte, 16, paramString, paramString.length);
    return MD5.toMD5Byte(arrayOfByte);
  }
  
  /* Error */
  private byte[] a(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2, int paramInt)
  {
    // Byte code:
    //   0: new 167	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 168	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: new 170	java/io/DataOutputStream
    //   12: dup
    //   13: aload 5
    //   15: invokespecial 173	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 6
    //   20: aload 6
    //   22: iconst_1
    //   23: invokevirtual 177	java/io/DataOutputStream:writeShort	(I)V
    //   26: aload 6
    //   28: new 179	java/util/Random
    //   31: dup
    //   32: invokespecial 180	java/util/Random:<init>	()V
    //   35: invokevirtual 183	java/util/Random:nextInt	()I
    //   38: iconst_1
    //   39: iushr
    //   40: invokevirtual 186	java/io/DataOutputStream:writeInt	(I)V
    //   43: aload 6
    //   45: iconst_1
    //   46: invokevirtual 186	java/io/DataOutputStream:writeInt	(I)V
    //   49: aload 6
    //   51: iload 4
    //   53: invokevirtual 186	java/io/DataOutputStream:writeInt	(I)V
    //   56: aload 6
    //   58: iconst_1
    //   59: invokevirtual 186	java/io/DataOutputStream:writeInt	(I)V
    //   62: aload 6
    //   64: aload_2
    //   65: invokestatic 190	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   68: invokevirtual 194	java/io/DataOutputStream:writeLong	(J)V
    //   71: aload 6
    //   73: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   76: ldc2_w 198
    //   79: ldiv
    //   80: l2i
    //   81: aload_0
    //   82: getfield 56	com/tencent/mobileqq/msf/core/auth/f:n	Lcom/tencent/mobileqq/msf/core/auth/b;
    //   85: invokevirtual 203	com/tencent/mobileqq/msf/core/auth/b:e	()I
    //   88: iadd
    //   89: invokevirtual 186	java/io/DataOutputStream:writeInt	(I)V
    //   92: aload 6
    //   94: iconst_0
    //   95: invokevirtual 186	java/io/DataOutputStream:writeInt	(I)V
    //   98: aload 6
    //   100: iconst_0
    //   101: invokevirtual 206	java/io/DataOutputStream:writeByte	(I)V
    //   104: aload 6
    //   106: aload_3
    //   107: invokevirtual 209	java/io/DataOutputStream:write	([B)V
    //   110: aload 6
    //   112: bipush 16
    //   114: newarray byte
    //   116: invokevirtual 209	java/io/DataOutputStream:write	([B)V
    //   119: aload 6
    //   121: iconst_0
    //   122: invokevirtual 177	java/io/DataOutputStream:writeShort	(I)V
    //   125: aload 6
    //   127: invokevirtual 212	java/io/DataOutputStream:flush	()V
    //   130: aload 5
    //   132: invokevirtual 215	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   135: astore_2
    //   136: new 73	com/tencent/qphone/base/util/Cryptor
    //   139: dup
    //   140: invokespecial 74	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   143: aload_2
    //   144: aload_1
    //   145: invokevirtual 218	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   148: astore_1
    //   149: aload_1
    //   150: astore_2
    //   151: aload 5
    //   153: invokevirtual 219	java/io/ByteArrayOutputStream:close	()V
    //   156: aload_1
    //   157: astore_2
    //   158: aload 6
    //   160: invokevirtual 220	java/io/DataOutputStream:close	()V
    //   163: aload_1
    //   164: areturn
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_1
    //   168: invokestatic 226	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +29 -> 200
    //   174: ldc 47
    //   176: iconst_2
    //   177: new 228	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   184: ldc 231
    //   186: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_2
    //   190: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: aload_2
    //   197: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   200: aload_1
    //   201: astore_2
    //   202: aload 5
    //   204: invokevirtual 219	java/io/ByteArrayOutputStream:close	()V
    //   207: aload_1
    //   208: astore_2
    //   209: aload 6
    //   211: invokevirtual 220	java/io/DataOutputStream:close	()V
    //   214: aload_1
    //   215: areturn
    //   216: astore_1
    //   217: aload_2
    //   218: areturn
    //   219: astore_1
    //   220: aload 5
    //   222: invokevirtual 219	java/io/ByteArrayOutputStream:close	()V
    //   225: aload 6
    //   227: invokevirtual 220	java/io/DataOutputStream:close	()V
    //   230: aload_1
    //   231: athrow
    //   232: astore_2
    //   233: goto -3 -> 230
    //   236: astore_3
    //   237: aload_2
    //   238: astore_1
    //   239: aload_3
    //   240: astore_2
    //   241: goto -73 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	f
    //   0	244	1	paramArrayOfByte1	byte[]
    //   0	244	2	paramString	String
    //   0	244	3	paramArrayOfByte2	byte[]
    //   0	244	4	paramInt	int
    //   7	214	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   18	208	6	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   20	136	165	java/lang/Exception
    //   151	156	216	java/lang/Exception
    //   158	163	216	java/lang/Exception
    //   202	207	216	java/lang/Exception
    //   209	214	216	java/lang/Exception
    //   20	136	219	finally
    //   136	149	219	finally
    //   168	200	219	finally
    //   220	230	232	java/lang/Exception
    //   136	149	236	java/lang/Exception
  }
  
  public void a(UniPacket paramUniPacket, a parama)
  {
    if ((paramUniPacket == null) || (parama == null)) {
      return;
    }
    Object localObject = (RespondCustomSig)paramUniPacket.getByClass("RespondCustomSig", new RespondCustomSig());
    if (localObject != null)
    {
      int i1 = 0;
      if (i1 < ((RespondCustomSig)localObject).SigList.size())
      {
        CustomSigContent localCustomSigContent = (CustomSigContent)((RespondCustomSig)localObject).SigList.get(i1);
        if (localCustomSigContent.ulSigType == 1L) {
          parama.l(localCustomSigContent.SigContent);
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((localCustomSigContent.ulSigType == 3L) || (localCustomSigContent.ulSigType != 8L)) {}
        }
      }
    }
    localObject = (q)paramUniPacket.getByClass("UserMainAccount", new q());
    if (localObject != null)
    {
      if (((q)localObject).a != 2L) {
        break label213;
      }
      parama.m(((q)localObject).c);
    }
    for (;;)
    {
      paramUniPacket = (r)paramUniPacket.getByClass("UserSimpleInfo", new r());
      if (paramUniPacket == null) {
        break;
      }
      parama.a(paramUniPacket.a);
      parama.b(paramUniPacket.b);
      parama.c(paramUniPacket.c);
      parama.n(paramUniPacket.d);
      return;
      label213:
      parama.m(parama.d().getBytes());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, UniPacket paramUniPacket, k paramk)
  {
    u.a(paramFromServiceMsg);
    VerifyCodeInfo localVerifyCodeInfo = new VerifyCodeInfo();
    localVerifyCodeInfo.ssoSeq = paramFromServiceMsg.getRequestSsoSeq();
    localVerifyCodeInfo.wupSeq = paramUniPacket.getRequestId();
    if (paramk.b == 0)
    {
      paramUniPacket = (i)paramUniPacket.getByClass("RespondAuth", new i());
      localVerifyCodeInfo.vpicSid = paramUniPacket.c;
      localVerifyCodeInfo.svrSeqNo = paramk.e;
      localVerifyCodeInfo.verifyimage = paramUniPacket.a;
      localVerifyCodeInfo.verifyNote = paramUniPacket.b;
    }
    for (;;)
    {
      VerifyCodeInfo.putVerifyCodeInfo(paramFromServiceMsg, localVerifyCodeInfo);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.AuthCoder", 2, "rece loginVerifyCode seq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + paramFromServiceMsg.getUin() + " cmd:" + paramFromServiceMsg.getServiceCmd() + " svrseqNo:" + localVerifyCodeInfo.svrSeqNo + " vipsid:" + localVerifyCodeInfo.vpicSid + " wupSeq:" + localVerifyCodeInfo.wupSeq);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.AuthCoder", 2, "add " + paramToServiceMsg + " to mutilActionQueue.");
      }
      return;
      if (paramk.b == 12)
      {
        paramUniPacket = (i)paramUniPacket.getByClass("RespondAuth", new i());
        localVerifyCodeInfo.vpicSid = paramUniPacket.c;
        localVerifyCodeInfo.svrSeqNo = paramk.e;
        localVerifyCodeInfo.verifyimage = paramUniPacket.a;
        localVerifyCodeInfo.verifyNote = paramUniPacket.b;
      }
      else if (paramk.b == 1)
      {
        paramUniPacket = (n)paramUniPacket.getByClass("RespondVerifyPic", new n());
        localVerifyCodeInfo.vpicSid = paramUniPacket.b;
        localVerifyCodeInfo.svrSeqNo = paramk.e;
        localVerifyCodeInfo.verifyimage = paramUniPacket.a;
        localVerifyCodeInfo.verifyNote = "";
      }
      else if (paramk.b == 2)
      {
        paramUniPacket = (m)paramUniPacket.getByClass("RespondRefreshVPic", new m());
        localVerifyCodeInfo.vpicSid = paramUniPacket.c;
        localVerifyCodeInfo.svrSeqNo = paramk.e;
        localVerifyCodeInfo.verifyimage = paramUniPacket.a;
        localVerifyCodeInfo.verifyNote = paramUniPacket.b;
      }
      else if (paramk.b == 13)
      {
        paramUniPacket = (p)paramUniPacket.getByClass("ResponseNameExchangeUin", new p());
        localVerifyCodeInfo.vpicSid = paramUniPacket.c;
        localVerifyCodeInfo.svrSeqNo = paramk.e;
        localVerifyCodeInfo.verifyimage = paramUniPacket.a;
        localVerifyCodeInfo.verifyNote = paramUniPacket.b;
      }
      else if (paramk.b == 14)
      {
        paramUniPacket = (o)paramUniPacket.getByClass("ResponseAuthWlogin", new o());
        byte[] arrayOfByte = paramUniPacket.d;
        if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {}
        localVerifyCodeInfo.vpicSid = paramUniPacket.c;
        localVerifyCodeInfo.svrSeqNo = paramk.e;
        localVerifyCodeInfo.verifyimage = paramUniPacket.a;
        localVerifyCodeInfo.verifyNote = paramUniPacket.b;
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, k paramk)
  {
    if (paramk == null) {}
    a locala;
    do
    {
      return;
      locala = (a)this.n.b.remove(paramk.d);
      if (locala != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MSF.C.AuthCoder", 2, "can not find account " + paramFromServiceMsg.getUin() + " info.");
    return;
    QLog.d("MSF.C.AuthCoder", 1, MD5.toMD5(paramFromServiceMsg.getUin()) + " login succ.");
    locala.d(com.tencent.mobileqq.msf.service.h.b(paramToServiceMsg));
    this.n.a(locala);
    if (a(paramToServiceMsg, paramk, locala))
    {
      long l1 = System.currentTimeMillis();
      locala.a(true);
      locala.a(l1);
      paramk = locala.d();
      byte[] arrayOfByte1 = locala.f();
      byte[] arrayOfByte2 = locala.g();
      byte[] arrayOfByte3 = locala.h();
      byte[] arrayOfByte4 = locala.i();
      byte[] arrayOfByte5 = locala.j();
      byte[] arrayOfByte6 = locala.k();
      String str = locala.l();
      CodecWarpper.setAccountKey(paramk, new byte[0], arrayOfByte1, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6, new byte[0], str);
      this.n.o(locala.d());
      s.a(locala.d(), false);
    }
    for (;;)
    {
      try
      {
        this.n.a.getWtLoginCenter().a(locala, true);
        this.n.a.sender.a(paramFromServiceMsg.getAppId(), paramFromServiceMsg.getUin());
        paramFromServiceMsg.addAttribute("resp_simpleAccount", locala.p().toStoreString());
        this.n.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      catch (Throwable paramk)
      {
        QLog.d("MSF.C.AuthCoder", 1, MD5.toMD5(paramFromServiceMsg.getUin()) + " set key to wt error " + paramk, paramk);
        continue;
      }
      QLog.d("MSF.C.AuthCoder", 1, MD5.toMD5(paramFromServiceMsg.getUin()) + "decode login failed.");
    }
  }
  
  public byte[] a(int paramInt1, String paramString, int paramInt2, HashMap paramHashMap)
  {
    this.n.b(paramString);
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("test");
    localUniPacket.setFuncName("cmdstr");
    localUniPacket.put("RequestHeader", new d(1, paramInt2, MsfCore.getNextSeq(), 1, paramString, paramInt1, String.valueOf(paramInt1), "123", 0));
    if (paramHashMap != null)
    {
      paramString = paramHashMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramHashMap = (Map.Entry)paramString.next();
        localUniPacket.put((String)paramHashMap.getKey(), paramHashMap.getValue());
      }
    }
    return localUniPacket.encode();
  }
  
  public byte[] a(int paramInt, String paramString, VerifyCodeInfo paramVerifyCodeInfo)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("test");
    localUniPacket.setFuncName("cmdstr");
    String str2 = this.n.k(paramString);
    int i1 = paramVerifyCodeInfo.wupSeq;
    int i2 = paramVerifyCodeInfo.svrSeqNo;
    String str1 = str2;
    if (str2 == null) {
      str1 = paramString;
    }
    localUniPacket.put("RequestHeader", new d(1, 2, i1, i2, str1, paramInt, String.valueOf(paramInt), "123", 0));
    localUniPacket.put("RequestRefreshVPic", new g(1, 1));
    localUniPacket.setRequestId(paramVerifyCodeInfo.wupSeq);
    return localUniPacket.encode();
  }
  
  public byte[] a(int paramInt, String paramString1, String paramString2, VerifyCodeInfo paramVerifyCodeInfo)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("test");
    localUniPacket.setFuncName("cmdstr");
    String str2 = this.n.k(paramString1);
    int i1 = paramVerifyCodeInfo.wupSeq;
    int i2 = paramVerifyCodeInfo.svrSeqNo;
    String str1 = str2;
    if (str2 == null) {
      str1 = paramString1;
    }
    localUniPacket.put("RequestHeader", new d(1, 1, i1, i2, str1, paramInt, String.valueOf(paramInt), "123", 0));
    localUniPacket.put("RequestVerifyPic", new com.tencent.msf.service.protocol.security.h(paramVerifyCodeInfo.vpicSid, paramString2));
    localUniPacket.setRequestId(paramVerifyCodeInfo.wupSeq);
    return localUniPacket.encode();
  }
  
  public byte[] a(int paramInt1, String paramString, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("test");
    localUniPacket.setFuncName("cmdstr");
    this.n.b(paramString);
    a locala = (a)this.n.b.get(paramString);
    localUniPacket.put("RequestHeader", new d(1, 14, MsfCore.getNextSeq(), locala.x(), paramString, paramInt1, String.valueOf(paramInt1), "123", 0));
    byte[] arrayOfByte2 = a(paramString, paramArrayOfByte1);
    byte[] arrayOfByte1 = a(arrayOfByte2, paramString, paramArrayOfByte1, paramInt2);
    locala.i(arrayOfByte2);
    paramArrayOfByte1 = this.n.f();
    paramString = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      paramString = new byte[0];
    }
    localUniPacket.put("RequestAuthWlogin", new com.tencent.msf.service.protocol.security.b(arrayOfByte1, 1, 0, paramString, paramInt3, paramArrayOfByte2));
    paramString = new c();
    paramString.a = ((int)(System.currentTimeMillis() / 1000L) + this.n.e());
    localUniPacket.put("RequestGetServerTime", paramString);
    return localUniPacket.encode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.f
 * JD-Core Version:    0.7.0.1
 */