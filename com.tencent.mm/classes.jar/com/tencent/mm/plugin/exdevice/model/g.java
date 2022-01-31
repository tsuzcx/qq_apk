package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ei;
import com.tencent.mm.h.a.ia;
import com.tencent.mm.h.a.ia.b;
import com.tencent.mm.h.c.cc;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.c.apn;
import com.tencent.mm.protocal.c.apo;
import com.tencent.mm.protocal.c.app;
import com.tencent.mm.protocal.c.apq;
import com.tencent.mm.protocal.c.apr;
import com.tencent.mm.protocal.c.aps;
import com.tencent.mm.protocal.c.apt;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.byv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class g
  implements com.tencent.mm.ah.f
{
  String bRS;
  long dFT;
  long djE;
  String eoQ = "";
  public f.a epa = new g.2(this);
  boolean juN = false;
  boolean juO = false;
  boolean juP = false;
  String juQ;
  String juR;
  int juS;
  String juT = "send_data_sucess";
  String juU = "send_data_failed";
  private String juV = "send_data_sending";
  boolean juW = false;
  boolean juX = false;
  public HashMap<String, String> juY = new HashMap();
  apo juZ;
  long jva;
  List<com.tencent.mm.plugin.exdevice.h.b> jvb = null;
  List<com.tencent.mm.plugin.exdevice.h.b> jvc = new ArrayList();
  HashMap<String, String> jvd = new HashMap();
  HashMap<String, Integer> jve = new HashMap();
  HashMap<String, Boolean> jvf = new HashMap();
  j.a jvg;
  j.a jvh;
  j.a jvi;
  j.a jvj;
  Runnable jvk = new g.1(this);
  apo jvl;
  String jvm;
  String jvn;
  int jvo;
  HashMap<Integer, String> jvp = new HashMap();
  
  public g()
  {
    this.jvc.clear();
    this.jvd.clear();
    this.jvf.clear();
    this.jvb = ad.aLL().aMp();
    if ((this.jvb != null) && (this.jvb.size() > 0))
    {
      y.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Bind Device Size is %d", new Object[] { Integer.valueOf(this.jvb.size()) });
      int j = this.jvb.size();
      int i = 0;
      while (i < j)
      {
        if ((((com.tencent.mm.plugin.exdevice.h.b)this.jvb.get(i)).cMZ.contains("internet_to_device")) && (!((com.tencent.mm.plugin.exdevice.h.b)this.jvb.get(i)).cMZ.contains("wechat_to_device"))) {
          this.jvc.add(this.jvb.get(i));
        }
        i += 1;
      }
      this.jvj = new g.3(this);
      this.jvg = new g.4(this);
      this.jvh = new g.5(this);
      this.jvi = new g.6(this);
      au.Dk().a(1717, this);
      j.aLC().a(14, this.jvg);
      j.aLC().a(12, this.jvh);
      j.aLC().a(13, this.jvi);
      j.aLC().a(15, this.jvj);
      y.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "initWCLanDeviceLib...");
      Java2CExDevice.initWCLanDeviceLib();
    }
  }
  
  /* Error */
  public static byte[] Bs(String paramString)
  {
    // Byte code:
    //   0: ldc 141
    //   2: ldc 240
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_0
    //   11: aastore
    //   12: invokestatic 155	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: aconst_null
    //   17: invokestatic 245	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/u;
    //   20: astore_2
    //   21: aload_2
    //   22: ldc 247
    //   24: invokevirtual 253	com/tencent/mm/network/u:setRequestMethod	(Ljava/lang/String;)V
    //   27: aload_2
    //   28: sipush 25000
    //   31: invokevirtual 257	com/tencent/mm/network/u:setConnectTimeout	(I)V
    //   34: aload_2
    //   35: sipush 25000
    //   38: invokevirtual 260	com/tencent/mm/network/u:setReadTimeout	(I)V
    //   41: aload_2
    //   42: invokevirtual 264	com/tencent/mm/network/u:getInputStream	()Ljava/io/InputStream;
    //   45: astore_3
    //   46: aload_2
    //   47: invokevirtual 267	com/tencent/mm/network/u:getResponseCode	()I
    //   50: sipush 200
    //   53: if_icmpne +232 -> 285
    //   56: new 269	java/io/ByteArrayOutputStream
    //   59: dup
    //   60: invokespecial 270	java/io/ByteArrayOutputStream:<init>	()V
    //   63: astore_0
    //   64: aload_2
    //   65: astore 7
    //   67: aload_3
    //   68: astore 6
    //   70: aload_0
    //   71: astore 5
    //   73: sipush 1024
    //   76: newarray byte
    //   78: astore 4
    //   80: aload_2
    //   81: astore 7
    //   83: aload_3
    //   84: astore 6
    //   86: aload_0
    //   87: astore 5
    //   89: aload_3
    //   90: aload 4
    //   92: invokevirtual 276	java/io/InputStream:read	([B)I
    //   95: istore_1
    //   96: iload_1
    //   97: iconst_m1
    //   98: if_icmpeq +76 -> 174
    //   101: aload_2
    //   102: astore 7
    //   104: aload_3
    //   105: astore 6
    //   107: aload_0
    //   108: astore 5
    //   110: aload_0
    //   111: aload 4
    //   113: iconst_0
    //   114: iload_1
    //   115: invokevirtual 280	java/io/ByteArrayOutputStream:write	([BII)V
    //   118: goto -38 -> 80
    //   121: astore 4
    //   123: aload_2
    //   124: astore 7
    //   126: aload_3
    //   127: astore 6
    //   129: aload_0
    //   130: astore 5
    //   132: ldc 141
    //   134: aload 4
    //   136: ldc 88
    //   138: iconst_0
    //   139: anewarray 4	java/lang/Object
    //   142: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: ifnull +7 -> 153
    //   149: aload_0
    //   150: invokevirtual 287	java/io/ByteArrayOutputStream:close	()V
    //   153: aload_3
    //   154: ifnull +7 -> 161
    //   157: aload_3
    //   158: invokevirtual 288	java/io/InputStream:close	()V
    //   161: aload_2
    //   162: ifnull +10 -> 172
    //   165: aload_2
    //   166: getfield 292	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   169: invokevirtual 297	java/net/HttpURLConnection:disconnect	()V
    //   172: aconst_null
    //   173: areturn
    //   174: aload_2
    //   175: astore 7
    //   177: aload_3
    //   178: astore 6
    //   180: aload_0
    //   181: astore 5
    //   183: aload_0
    //   184: invokevirtual 287	java/io/ByteArrayOutputStream:close	()V
    //   187: aload_2
    //   188: astore 7
    //   190: aload_3
    //   191: astore 6
    //   193: aload_0
    //   194: astore 5
    //   196: aload_3
    //   197: invokevirtual 288	java/io/InputStream:close	()V
    //   200: aload_2
    //   201: astore 7
    //   203: aload_3
    //   204: astore 6
    //   206: aload_0
    //   207: astore 5
    //   209: aload_2
    //   210: getfield 292	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   213: invokevirtual 297	java/net/HttpURLConnection:disconnect	()V
    //   216: aload_2
    //   217: astore 7
    //   219: aload_3
    //   220: astore 6
    //   222: aload_0
    //   223: astore 5
    //   225: aload_0
    //   226: invokevirtual 301	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   229: astore 4
    //   231: aload_0
    //   232: invokevirtual 287	java/io/ByteArrayOutputStream:close	()V
    //   235: aload_3
    //   236: ifnull +7 -> 243
    //   239: aload_3
    //   240: invokevirtual 288	java/io/InputStream:close	()V
    //   243: aload_2
    //   244: getfield 292	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   247: invokevirtual 297	java/net/HttpURLConnection:disconnect	()V
    //   250: aload 4
    //   252: areturn
    //   253: astore_0
    //   254: ldc 141
    //   256: aload_0
    //   257: ldc 88
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: goto -31 -> 235
    //   269: astore_0
    //   270: ldc 141
    //   272: aload_0
    //   273: ldc 88
    //   275: iconst_0
    //   276: anewarray 4	java/lang/Object
    //   279: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: goto -39 -> 243
    //   285: aload_3
    //   286: ifnull +7 -> 293
    //   289: aload_3
    //   290: invokevirtual 288	java/io/InputStream:close	()V
    //   293: aload_2
    //   294: getfield 292	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   297: invokevirtual 297	java/net/HttpURLConnection:disconnect	()V
    //   300: aconst_null
    //   301: areturn
    //   302: astore_0
    //   303: ldc 141
    //   305: aload_0
    //   306: ldc 88
    //   308: iconst_0
    //   309: anewarray 4	java/lang/Object
    //   312: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: goto -22 -> 293
    //   318: astore_0
    //   319: ldc 141
    //   321: aload_0
    //   322: ldc 88
    //   324: iconst_0
    //   325: anewarray 4	java/lang/Object
    //   328: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   331: goto -178 -> 153
    //   334: astore_0
    //   335: ldc 141
    //   337: aload_0
    //   338: ldc 88
    //   340: iconst_0
    //   341: anewarray 4	java/lang/Object
    //   344: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   347: goto -186 -> 161
    //   350: astore_0
    //   351: aconst_null
    //   352: astore 7
    //   354: aconst_null
    //   355: astore_3
    //   356: aconst_null
    //   357: astore_2
    //   358: aload_2
    //   359: ifnull +7 -> 366
    //   362: aload_2
    //   363: invokevirtual 287	java/io/ByteArrayOutputStream:close	()V
    //   366: aload_3
    //   367: ifnull +7 -> 374
    //   370: aload_3
    //   371: invokevirtual 288	java/io/InputStream:close	()V
    //   374: aload 7
    //   376: ifnull +11 -> 387
    //   379: aload 7
    //   381: getfield 292	com/tencent/mm/network/u:aRG	Ljava/net/HttpURLConnection;
    //   384: invokevirtual 297	java/net/HttpURLConnection:disconnect	()V
    //   387: aload_0
    //   388: athrow
    //   389: astore_2
    //   390: ldc 141
    //   392: aload_2
    //   393: ldc 88
    //   395: iconst_0
    //   396: anewarray 4	java/lang/Object
    //   399: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   402: goto -36 -> 366
    //   405: astore_2
    //   406: ldc 141
    //   408: aload_2
    //   409: ldc 88
    //   411: iconst_0
    //   412: anewarray 4	java/lang/Object
    //   415: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   418: goto -44 -> 374
    //   421: astore_0
    //   422: aconst_null
    //   423: astore_3
    //   424: aconst_null
    //   425: astore 4
    //   427: aload_2
    //   428: astore 7
    //   430: aload 4
    //   432: astore_2
    //   433: goto -75 -> 358
    //   436: astore_0
    //   437: aconst_null
    //   438: astore 4
    //   440: aload_2
    //   441: astore 7
    //   443: aload 4
    //   445: astore_2
    //   446: goto -88 -> 358
    //   449: astore_0
    //   450: aload 6
    //   452: astore_3
    //   453: aload 5
    //   455: astore_2
    //   456: goto -98 -> 358
    //   459: astore 4
    //   461: aconst_null
    //   462: astore_2
    //   463: aconst_null
    //   464: astore_3
    //   465: aconst_null
    //   466: astore_0
    //   467: goto -344 -> 123
    //   470: astore 4
    //   472: aconst_null
    //   473: astore_3
    //   474: aconst_null
    //   475: astore_0
    //   476: goto -353 -> 123
    //   479: astore 4
    //   481: aconst_null
    //   482: astore_0
    //   483: goto -360 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	paramString	String
    //   95	20	1	i	int
    //   20	343	2	localu	com.tencent.mm.network.u
    //   389	4	2	localIOException1	java.io.IOException
    //   405	23	2	localIOException2	java.io.IOException
    //   432	31	2	localObject1	Object
    //   45	429	3	localObject2	Object
    //   78	34	4	arrayOfByte1	byte[]
    //   121	14	4	localException1	java.lang.Exception
    //   229	215	4	arrayOfByte2	byte[]
    //   459	1	4	localException2	java.lang.Exception
    //   470	1	4	localException3	java.lang.Exception
    //   479	1	4	localException4	java.lang.Exception
    //   71	383	5	str	String
    //   68	383	6	localObject3	Object
    //   65	377	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   73	80	121	java/lang/Exception
    //   89	96	121	java/lang/Exception
    //   110	118	121	java/lang/Exception
    //   183	187	121	java/lang/Exception
    //   196	200	121	java/lang/Exception
    //   209	216	121	java/lang/Exception
    //   225	231	121	java/lang/Exception
    //   231	235	253	java/io/IOException
    //   239	243	269	java/io/IOException
    //   289	293	302	java/io/IOException
    //   149	153	318	java/io/IOException
    //   157	161	334	java/io/IOException
    //   15	21	350	finally
    //   362	366	389	java/io/IOException
    //   370	374	405	java/io/IOException
    //   21	46	421	finally
    //   46	64	436	finally
    //   73	80	449	finally
    //   89	96	449	finally
    //   110	118	449	finally
    //   132	145	449	finally
    //   183	187	449	finally
    //   196	200	449	finally
    //   209	216	449	finally
    //   225	231	449	finally
    //   15	21	459	java/lang/Exception
    //   21	46	470	java/lang/Exception
    //   46	64	479	java/lang/Exception
  }
  
  static String c(com.tencent.mm.plugin.exdevice.h.b paramb)
  {
    if (paramb == null) {
      return "";
    }
    String str = null;
    if (!bk.bl(paramb.cMT)) {
      str = paramb.cMT;
    }
    for (;;)
    {
      return bk.pm(str);
      if (!bk.bl(paramb.cMU)) {
        str = paramb.cMU;
      } else if (paramb.field_mac != 0L) {
        str = com.tencent.mm.plugin.exdevice.j.b.ee(paramb.field_mac);
      } else if (!bk.bl(paramb.field_deviceID)) {
        str = paramb.field_deviceID;
      }
    }
  }
  
  static void cO(String paramString1, String paramString2)
  {
    ei localei = new ei();
    localei.bKR.bKT = paramString2;
    localei.bKR.bwK = paramString1;
    a.udP.m(localei);
  }
  
  static Boolean dI(long paramLong)
  {
    boolean bool2 = false;
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Fy().fd(paramLong);
    if (((cs)localObject).field_msgId == 0L) {
      return Boolean.valueOf(false);
    }
    String str = ((cs)localObject).field_content;
    boolean bool1 = bool2;
    if (((bi)localObject).getType() == 49)
    {
      localObject = g.a.gp(str);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((g.a)localObject).type == 6) {
          bool1 = true;
        }
      }
    }
    return Boolean.valueOf(bool1);
  }
  
  static Boolean dJ(long paramLong)
  {
    boolean bool = false;
    au.Hx();
    bi localbi = com.tencent.mm.model.c.Fy().fd(paramLong);
    if (localbi.field_msgId == 0L) {
      return Boolean.valueOf(false);
    }
    if (localbi.getType() == 3) {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  static Boolean dK(long paramLong)
  {
    boolean bool = false;
    au.Hx();
    bi localbi = com.tencent.mm.model.c.Fy().fd(paramLong);
    if (localbi.field_msgId == 0L) {
      return Boolean.valueOf(false);
    }
    if (localbi.cvr()) {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  static Boolean dL(long paramLong)
  {
    boolean bool = false;
    au.Hx();
    bi localbi = com.tencent.mm.model.c.Fy().fd(paramLong);
    if (localbi.field_msgId == 0L) {
      return Boolean.valueOf(false);
    }
    if (localbi.getType() == 62) {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  private String dM(long paramLong)
  {
    String str = "";
    au.Hx();
    Object localObject1 = com.tencent.mm.model.c.Fy().fd(paramLong);
    if (((cs)localObject1).field_msgId == 0L) {
      localObject1 = "";
    }
    int i;
    do
    {
      Object localObject2;
      do
      {
        do
        {
          do
          {
            do
            {
              return localObject1;
              i = ((bi)localObject1).getType();
              localObject2 = ((cs)localObject1).field_content;
              if (!((bi)localObject1).aVK()) {
                break;
              }
              localObject2 = g.a.gp((String)localObject2);
              if ((localObject2 != null) && ((((g.a)localObject2).type == 6) || (((g.a)localObject2).type == 2)))
              {
                localObject1 = ap.avh().VQ(((g.a)localObject2).bFE);
                if (localObject1 != null) {
                  return ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath;
                }
                y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
                return "";
              }
              localObject1 = str;
            } while (localObject2 == null);
            if (((g.a)localObject2).type == 3) {
              break;
            }
            localObject1 = str;
          } while (((g.a)localObject2).type != 5);
          this.juO = true;
          return "";
          if (i != 3) {
            break;
          }
          localObject2 = com.tencent.mm.as.o.OJ().q((bi)localObject1);
          localObject1 = str;
        } while (localObject2 == null);
        str = com.tencent.mm.as.o.OJ().me(((com.tencent.mm.as.e)localObject2).enq);
        localObject1 = str;
      } while (!bk.bl(str));
      return com.tencent.mm.as.o.OJ().me(((com.tencent.mm.as.e)localObject2).ens);
      if (i == 62)
      {
        com.tencent.mm.modelvideo.o.Sr();
        return t.nS(((cs)localObject1).field_imgPath);
      }
      localObject1 = str;
    } while (i != 48);
    this.juO = true;
    return "";
  }
  
  /* Error */
  static String z(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: iconst_0
    //   8: aload_0
    //   9: ldc_w 523
    //   12: invokevirtual 527	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   15: invokevirtual 531	java/lang/String:substring	(II)Ljava/lang/String;
    //   18: astore_3
    //   19: new 533	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 535
    //   26: invokespecial 537	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokevirtual 540	java/lang/String:hashCode	()I
    //   33: invokevirtual 544	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 548	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 4
    //   41: new 533	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 549	java/lang/StringBuilder:<init>	()V
    //   48: aload_3
    //   49: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 523
    //   55: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 4
    //   60: invokevirtual 552	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 548	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore 6
    //   68: new 554	com/tencent/mm/modelsfs/c
    //   71: dup
    //   72: new 556	com/tencent/mm/vfs/b
    //   75: dup
    //   76: aload 6
    //   78: invokespecial 557	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   81: lload_1
    //   82: invokespecial 560	com/tencent/mm/modelsfs/c:<init>	(Lcom/tencent/mm/vfs/b;J)V
    //   85: astore_3
    //   86: aload_0
    //   87: invokestatic 566	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   90: astore_0
    //   91: aload_0
    //   92: astore 5
    //   94: aload_3
    //   95: astore 4
    //   97: sipush 1024
    //   100: newarray byte
    //   102: astore 7
    //   104: aload_0
    //   105: astore 5
    //   107: aload_3
    //   108: astore 4
    //   110: aload_0
    //   111: aload 7
    //   113: invokevirtual 276	java/io/InputStream:read	([B)I
    //   116: iconst_m1
    //   117: if_icmpeq +83 -> 200
    //   120: aload_0
    //   121: astore 5
    //   123: aload_3
    //   124: astore 4
    //   126: aload_3
    //   127: aload 7
    //   129: invokevirtual 571	java/io/OutputStream:write	([B)V
    //   132: goto -28 -> 104
    //   135: astore 6
    //   137: aload_0
    //   138: astore 5
    //   140: aload_3
    //   141: astore 4
    //   143: ldc 141
    //   145: ldc_w 573
    //   148: iconst_1
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 6
    //   156: invokevirtual 576	java/io/IOException:getMessage	()Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 578	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload_3
    //   164: ifnull +11 -> 175
    //   167: aload_3
    //   168: invokevirtual 581	java/io/OutputStream:flush	()V
    //   171: aload_3
    //   172: invokevirtual 582	java/io/OutputStream:close	()V
    //   175: aload_0
    //   176: ifnull -172 -> 4
    //   179: aload_0
    //   180: invokevirtual 288	java/io/InputStream:close	()V
    //   183: aconst_null
    //   184: areturn
    //   185: astore_0
    //   186: ldc 141
    //   188: aload_0
    //   189: ldc 88
    //   191: iconst_0
    //   192: anewarray 4	java/lang/Object
    //   195: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: aconst_null
    //   199: areturn
    //   200: aload_3
    //   201: invokevirtual 581	java/io/OutputStream:flush	()V
    //   204: aload_3
    //   205: invokevirtual 582	java/io/OutputStream:close	()V
    //   208: aload_0
    //   209: ifnull +7 -> 216
    //   212: aload_0
    //   213: invokevirtual 288	java/io/InputStream:close	()V
    //   216: aload 6
    //   218: areturn
    //   219: astore_0
    //   220: ldc 141
    //   222: aload_0
    //   223: ldc 88
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: ldc 141
    //   237: aload_0
    //   238: ldc 88
    //   240: iconst_0
    //   241: anewarray 4	java/lang/Object
    //   244: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: aconst_null
    //   248: areturn
    //   249: astore_0
    //   250: ldc 141
    //   252: aload_0
    //   253: ldc 88
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: aconst_null
    //   263: areturn
    //   264: astore_0
    //   265: aconst_null
    //   266: astore 5
    //   268: aconst_null
    //   269: astore_3
    //   270: aload_3
    //   271: ifnull +11 -> 282
    //   274: aload_3
    //   275: invokevirtual 581	java/io/OutputStream:flush	()V
    //   278: aload_3
    //   279: invokevirtual 582	java/io/OutputStream:close	()V
    //   282: aload 5
    //   284: ifnull +8 -> 292
    //   287: aload 5
    //   289: invokevirtual 288	java/io/InputStream:close	()V
    //   292: aload_0
    //   293: athrow
    //   294: astore_0
    //   295: ldc 141
    //   297: aload_0
    //   298: ldc 88
    //   300: iconst_0
    //   301: anewarray 4	java/lang/Object
    //   304: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: aconst_null
    //   308: areturn
    //   309: astore_0
    //   310: ldc 141
    //   312: aload_0
    //   313: ldc 88
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 284	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   322: aconst_null
    //   323: areturn
    //   324: astore_0
    //   325: aconst_null
    //   326: astore 5
    //   328: goto -58 -> 270
    //   331: astore_0
    //   332: aload 4
    //   334: astore_3
    //   335: goto -65 -> 270
    //   338: astore 6
    //   340: aconst_null
    //   341: astore_0
    //   342: aconst_null
    //   343: astore_3
    //   344: goto -207 -> 137
    //   347: astore 6
    //   349: aconst_null
    //   350: astore_0
    //   351: goto -214 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramString	String
    //   0	354	1	paramLong	long
    //   18	326	3	localObject1	Object
    //   39	294	4	localObject2	Object
    //   92	235	5	str1	String
    //   66	11	6	str2	String
    //   135	82	6	localIOException1	java.io.IOException
    //   338	1	6	localIOException2	java.io.IOException
    //   347	1	6	localIOException3	java.io.IOException
    //   102	26	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   97	104	135	java/io/IOException
    //   110	120	135	java/io/IOException
    //   126	132	135	java/io/IOException
    //   179	183	185	java/io/IOException
    //   200	208	219	java/io/IOException
    //   212	216	234	java/io/IOException
    //   167	175	249	java/io/IOException
    //   68	86	264	finally
    //   274	282	294	java/io/IOException
    //   287	292	309	java/io/IOException
    //   86	91	324	finally
    //   97	104	331	finally
    //   110	120	331	finally
    //   126	132	331	finally
    //   143	163	331	finally
    //   68	86	338	java/io/IOException
    //   86	91	347	java/io/IOException
  }
  
  final boolean a(apo paramapo, long paramLong)
  {
    int j = -1;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    String str = dM(paramLong);
    Object localObject3 = localObject6;
    Object localObject2 = localObject5;
    Object localObject1 = localObject4;
    int i = j;
    if (str != null)
    {
      localObject3 = localObject6;
      localObject2 = localObject5;
      localObject1 = localObject4;
      i = j;
      if (str.length() > 0)
      {
        localObject1 = new com.tencent.mm.vfs.b(str);
        localObject2 = ((com.tencent.mm.vfs.b)localObject1).getName();
        i = (int)((com.tencent.mm.vfs.b)localObject1).length();
        localObject3 = ((String)localObject2).substring(((String)localObject2).lastIndexOf(".") + 1, ((String)localObject2).length());
        localObject1 = com.tencent.mm.vfs.e.aeY(str);
        y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "filePath %s", new Object[] { str });
        y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileSize %s", new Object[] { Integer.valueOf(i) });
        y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileMd5 %s", new Object[] { localObject1 });
      }
    }
    au.Hx();
    localObject4 = com.tencent.mm.model.c.Fy().fd(paramLong);
    if (((cs)localObject4).field_msgId == 0L)
    {
      y.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "msgInfo or msgInfo.getMsgId() = 0");
      return false;
    }
    switch (((bi)localObject4).getType())
    {
    }
    for (;;)
    {
      return true;
      localObject3 = g.a.gp(((cs)localObject4).field_content);
      if (localObject3 == null)
      {
        y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get content is null");
        return false;
      }
      if (((g.a)localObject3).type == 3)
      {
        localObject1 = new apr();
        ((apr)localObject1).bGw = ((g.a)localObject3).title;
        ((apr)localObject1).tlJ = ((g.a)localObject3).description;
        ((apr)localObject1).kSC = ((g.a)localObject3).url;
        ((apr)localObject1).tlK = ((g.a)localObject3).dQu;
        ((apr)localObject1).sNb = ((g.a)localObject3).dQU;
        ((apr)localObject1).tlL = ((g.a)localObject3).dQV;
        ((apr)localObject1).kVn = ((g.a)localObject3).appName;
        if (bk.bl(((apr)localObject1).kVn))
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.g.dh(((g.a)localObject3).appId, ((g.a)localObject3).cau);
          if (localObject2 != null) {
            ((apr)localObject1).kVn = ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appName;
          }
        }
        ((apr)localObject1).tlM = ((g.a)localObject3).dQL;
        ((apr)localObject1).tlN = ((g.a)localObject3).dQM;
        ((apr)localObject1).tlO = ((g.a)localObject3).dQS;
        paramapo.tlA = ((apr)localObject1);
        paramapo.tlz = 1;
      }
      else if (((g.a)localObject3).type == 6)
      {
        localObject2 = new apn();
        ((apn)localObject2).sSA = ((g.a)localObject3).dQw;
        ((apn)localObject2).kRZ = ((g.a)localObject3).title;
        ((apn)localObject2).hQL = i;
        ((apn)localObject2).jnU = ((String)localObject1);
        paramapo.tlD = ((apn)localObject2);
        paramapo.tlz = 4;
      }
      else if (((g.a)localObject3).type == 5)
      {
        localObject1 = new aps();
        ((aps)localObject1).kSC = ((g.a)localObject3).url;
        ((aps)localObject1).bGw = ((g.a)localObject3).title;
        ((aps)localObject1).tlJ = ((g.a)localObject3).description;
        ((aps)localObject1).kVn = ((g.a)localObject3).appName;
        if (bk.bl(((aps)localObject1).kVn))
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.g.dh(((g.a)localObject3).appId, ((g.a)localObject3).cau);
          if (localObject2 != null) {
            ((aps)localObject1).kVn = ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appName;
          }
        }
        paramapo.tlE = ((aps)localObject1);
        paramapo.tlz = 5;
      }
      else if (((g.a)localObject3).type == 2)
      {
        localObject3 = new app();
        ((app)localObject3).sSA = "jpg";
        ((app)localObject3).kRZ = ((String)localObject2);
        ((app)localObject3).hQL = i;
        ((app)localObject3).jnU = ((String)localObject1);
        paramapo.tlC = ((app)localObject3);
        paramapo.tlz = 3;
        continue;
        localObject4 = new app();
        ((app)localObject4).sSA = ((String)localObject3);
        ((app)localObject4).kRZ = ((String)localObject2);
        ((app)localObject4).hQL = i;
        ((app)localObject4).jnU = ((String)localObject1);
        paramapo.tlC = ((app)localObject4);
        paramapo.tlz = 3;
        continue;
        au.Hx();
        localObject1 = com.tencent.mm.model.c.Fy().HO(((cs)localObject4).field_content);
        localObject2 = new apq();
        ((apq)localObject2).sDX = ((float)((bi.b)localObject1).lCJ);
        ((apq)localObject2).sDY = ((float)((bi.b)localObject1).lCK);
        ((apq)localObject2).tlH = ((bi.b)localObject1).bRv;
        ((apq)localObject2).kVZ = ((bi.b)localObject1).label;
        ((apq)localObject2).tlI = ((bi.b)localObject1).lFn;
        paramapo.tlB = ((apq)localObject2);
        paramapo.tlz = 2;
        continue;
        localObject4 = new apt();
        ((apt)localObject4).sSA = ((String)localObject3);
        ((apt)localObject4).hQL = i;
        ((apt)localObject4).jnU = ((String)localObject1);
        ((apt)localObject4).kRZ = ((String)localObject2);
        paramapo.tlF = ((apt)localObject4);
        paramapo.tlz = 6;
      }
    }
  }
  
  public final bxk aLA()
  {
    ia localia = new ia();
    localia.bQa.bJQ = this.juQ;
    a.udP.m(localia);
    return localia.bQb.bQc;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null) {
      y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "scene is null.");
    }
    while (!(paramm instanceof n)) {
      return;
    }
    Object localObject = (n)paramm;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "NetSceneGetAppMsgInfo onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      cO(((n)localObject).bwK, this.juU);
      return;
    }
    if ((((n)localObject).dmK != null) && (((n)localObject).dmK.ecF.ecN != null)) {}
    for (paramString = (byv)((n)localObject).dmK.ecF.ecN;; paramString = null)
    {
      paramm = paramString.tOU;
      if (1 != ((n)localObject).jvW) {
        break;
      }
      cO(((n)localObject).bwK, this.juT);
      return;
    }
    localObject = ((n)localObject).bwK;
    String str = (String)this.jvd.get(localObject);
    cO((String)localObject, this.juV);
    if ((this.juP) && (this.juQ != null)) {}
    for (paramString = this.juR; (str == null) || (str.length() == 0); paramString = dM(this.djE))
    {
      y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mDeviceInfo error");
      cO((String)localObject, this.juU);
      return;
    }
    if (!this.juN)
    {
      y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onItemClick stop scan...");
      Java2CExDevice.stopScanWCLanDevice();
      this.juN = true;
    }
    if ((!this.jvf.containsKey(localObject)) || (!((Boolean)this.jvf.get(localObject)).booleanValue()))
    {
      y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice mDeviceInfo: " + str);
      if (Java2CExDevice.connectWCLanDevice(str.getBytes(), true) != 0)
      {
        cO((String)localObject, this.juU);
        y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice error!");
      }
    }
    if (this.juO)
    {
      paramInt1 = Java2CExDevice.useWCLanDeviceService(str.getBytes(), paramm.getBytes());
      if (paramInt1 != 0)
      {
        this.jvp.put(Integer.valueOf(paramInt1), localObject);
        this.jve.put(localObject, Integer.valueOf(paramInt1));
        y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get useWCLanDeviceService mCallBackCmdId: " + paramInt1);
        return;
      }
      cO((String)localObject, this.juU);
      y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "useWCLanDeviceService error!");
      return;
    }
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file path is error");
      cO((String)localObject, this.juU);
      return;
    }
    paramInt1 = Java2CExDevice.sendFileToWCLanDevice(str.getBytes(), paramm.getBytes(), paramString.getBytes());
    if (paramInt1 != 0)
    {
      this.jvp.put(Integer.valueOf(paramInt1), localObject);
      this.jve.put(localObject, Integer.valueOf(paramInt1));
      y.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get sendFileToWCLanDevice mCallBackCmdId =" + paramInt1);
      return;
    }
    cO((String)localObject, this.juU);
    y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendFileToWCLanDevice error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g
 * JD-Core Version:    0.7.0.1
 */