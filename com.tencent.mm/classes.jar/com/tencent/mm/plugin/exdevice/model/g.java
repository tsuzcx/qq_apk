package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.el;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.ie.b;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.avo;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.avq;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.clo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class g
  implements com.tencent.mm.ai.f
{
  String czt;
  long eDv;
  long eaY;
  String fFo;
  public g.a fFy;
  List<com.tencent.mm.plugin.exdevice.h.b> lEA;
  List<com.tencent.mm.plugin.exdevice.h.b> lEB;
  HashMap<String, String> lEC;
  HashMap<String, Integer> lED;
  HashMap<String, Boolean> lEE;
  j.a lEF;
  j.a lEG;
  j.a lEH;
  j.a lEI;
  Runnable lEJ;
  avn lEK;
  String lEL;
  String lEM;
  int lEN;
  HashMap<Integer, String> lEO;
  boolean lEm;
  boolean lEn;
  boolean lEo;
  String lEp;
  String lEq;
  int lEr;
  String lEs;
  String lEt;
  private String lEu;
  boolean lEv;
  boolean lEw;
  public HashMap<String, String> lEx;
  avn lEy;
  long lEz;
  
  public g()
  {
    AppMethodBeat.i(19259);
    this.lEm = false;
    this.lEn = false;
    this.lEo = false;
    this.lEs = "send_data_sucess";
    this.lEt = "send_data_failed";
    this.lEu = "send_data_sending";
    this.lEv = false;
    this.lEw = false;
    this.lEx = new HashMap();
    this.fFo = "";
    this.lEA = null;
    this.lEB = new ArrayList();
    this.lEC = new HashMap();
    this.lED = new HashMap();
    this.lEE = new HashMap();
    this.lEJ = new g.1(this);
    this.fFy = new g.2(this);
    this.lEO = new HashMap();
    this.lEB.clear();
    this.lEC.clear();
    this.lEE.clear();
    this.lEA = ad.bpY().bqC();
    if ((this.lEA != null) && (this.lEA.size() > 0))
    {
      ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "Bind Device Size is %d", new Object[] { Integer.valueOf(this.lEA.size()) });
      int j = this.lEA.size();
      int i = 0;
      while (i < j)
      {
        if ((((com.tencent.mm.plugin.exdevice.h.b)this.lEA.get(i)).dCP.contains("internet_to_device")) && (!((com.tencent.mm.plugin.exdevice.h.b)this.lEA.get(i)).dCP.contains("wechat_to_device"))) {
          this.lEB.add(this.lEA.get(i));
        }
        i += 1;
      }
      this.lEI = new g.3(this);
      this.lEF = new g.4(this);
      this.lEG = new g.5(this);
      this.lEH = new g.6(this);
      aw.Rc().a(1717, this);
      j.bpP().a(14, this.lEF);
      j.bpP().a(12, this.lEG);
      j.bpP().a(13, this.lEH);
      j.bpP().a(15, this.lEI);
      ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "initWCLanDeviceLib...");
      Java2CExDevice.initWCLanDeviceLib();
    }
    AppMethodBeat.o(19259);
  }
  
  /* Error */
  static String J(String paramString, long paramLong)
  {
    // Byte code:
    //   0: sipush 19267
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: sipush 19267
    //   13: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: iconst_0
    //   20: aload_0
    //   21: ldc 246
    //   23: invokevirtual 250	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   26: invokevirtual 254	java/lang/String:substring	(II)Ljava/lang/String;
    //   29: astore_3
    //   30: new 256	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 258
    //   37: invokespecial 261	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: invokevirtual 264	java/lang/String:hashCode	()I
    //   44: invokevirtual 268	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 4
    //   52: new 256	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 273	java/lang/StringBuilder:<init>	()V
    //   59: aload_3
    //   60: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc 246
    //   65: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload 4
    //   70: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore 6
    //   78: new 278	com/tencent/mm/modelsfs/c
    //   81: dup
    //   82: new 280	com/tencent/mm/vfs/b
    //   85: dup
    //   86: aload 6
    //   88: invokespecial 281	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   91: lload_1
    //   92: invokespecial 284	com/tencent/mm/modelsfs/c:<init>	(Lcom/tencent/mm/vfs/b;J)V
    //   95: astore_3
    //   96: aload_0
    //   97: invokestatic 290	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   100: astore_0
    //   101: aload_0
    //   102: astore 5
    //   104: aload_3
    //   105: astore 4
    //   107: sipush 1024
    //   110: newarray byte
    //   112: astore 7
    //   114: aload_0
    //   115: astore 5
    //   117: aload_3
    //   118: astore 4
    //   120: aload_0
    //   121: aload 7
    //   123: invokevirtual 296	java/io/InputStream:read	([B)I
    //   126: iconst_m1
    //   127: if_icmpeq +74 -> 201
    //   130: aload_0
    //   131: astore 5
    //   133: aload_3
    //   134: astore 4
    //   136: aload_3
    //   137: aload 7
    //   139: invokevirtual 302	java/io/OutputStream:write	([B)V
    //   142: goto -28 -> 114
    //   145: astore 6
    //   147: aload_0
    //   148: astore 5
    //   150: aload_3
    //   151: astore 4
    //   153: ldc 147
    //   155: ldc_w 304
    //   158: iconst_1
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload 6
    //   166: invokevirtual 307	java/io/IOException:getMessage	()Ljava/lang/String;
    //   169: aastore
    //   170: invokestatic 310	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aload_3
    //   174: ifnull +11 -> 185
    //   177: aload_3
    //   178: invokevirtual 313	java/io/OutputStream:flush	()V
    //   181: aload_3
    //   182: invokevirtual 316	java/io/OutputStream:close	()V
    //   185: aload_0
    //   186: ifnull +7 -> 193
    //   189: aload_0
    //   190: invokevirtual 317	java/io/InputStream:close	()V
    //   193: sipush 19267
    //   196: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aconst_null
    //   200: areturn
    //   201: aload_3
    //   202: invokevirtual 313	java/io/OutputStream:flush	()V
    //   205: aload_3
    //   206: invokevirtual 316	java/io/OutputStream:close	()V
    //   209: aload_0
    //   210: ifnull +7 -> 217
    //   213: aload_0
    //   214: invokevirtual 317	java/io/InputStream:close	()V
    //   217: sipush 19267
    //   220: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: aload 6
    //   225: areturn
    //   226: astore_0
    //   227: ldc 147
    //   229: aload_0
    //   230: ldc 94
    //   232: iconst_0
    //   233: anewarray 4	java/lang/Object
    //   236: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: sipush 19267
    //   242: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aconst_null
    //   246: areturn
    //   247: astore_0
    //   248: ldc 147
    //   250: aload_0
    //   251: ldc 94
    //   253: iconst_0
    //   254: anewarray 4	java/lang/Object
    //   257: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: sipush 19267
    //   263: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aconst_null
    //   267: areturn
    //   268: astore_0
    //   269: ldc 147
    //   271: aload_0
    //   272: ldc 94
    //   274: iconst_0
    //   275: anewarray 4	java/lang/Object
    //   278: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: sipush 19267
    //   284: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: aconst_null
    //   288: areturn
    //   289: astore_0
    //   290: ldc 147
    //   292: aload_0
    //   293: ldc 94
    //   295: iconst_0
    //   296: anewarray 4	java/lang/Object
    //   299: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: sipush 19267
    //   305: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aconst_null
    //   309: areturn
    //   310: astore_0
    //   311: aconst_null
    //   312: astore 5
    //   314: aconst_null
    //   315: astore_3
    //   316: aload_3
    //   317: ifnull +11 -> 328
    //   320: aload_3
    //   321: invokevirtual 313	java/io/OutputStream:flush	()V
    //   324: aload_3
    //   325: invokevirtual 316	java/io/OutputStream:close	()V
    //   328: aload 5
    //   330: ifnull +8 -> 338
    //   333: aload 5
    //   335: invokevirtual 317	java/io/InputStream:close	()V
    //   338: sipush 19267
    //   341: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: aload_0
    //   345: athrow
    //   346: astore_0
    //   347: ldc 147
    //   349: aload_0
    //   350: ldc 94
    //   352: iconst_0
    //   353: anewarray 4	java/lang/Object
    //   356: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   359: sipush 19267
    //   362: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   365: aconst_null
    //   366: areturn
    //   367: astore_0
    //   368: ldc 147
    //   370: aload_0
    //   371: ldc 94
    //   373: iconst_0
    //   374: anewarray 4	java/lang/Object
    //   377: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   380: sipush 19267
    //   383: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: aconst_null
    //   387: areturn
    //   388: astore_0
    //   389: aconst_null
    //   390: astore 5
    //   392: goto -76 -> 316
    //   395: astore_0
    //   396: aload 4
    //   398: astore_3
    //   399: goto -83 -> 316
    //   402: astore 6
    //   404: aconst_null
    //   405: astore_0
    //   406: aconst_null
    //   407: astore_3
    //   408: goto -261 -> 147
    //   411: astore 6
    //   413: aconst_null
    //   414: astore_0
    //   415: goto -268 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramString	String
    //   0	418	1	paramLong	long
    //   29	379	3	localObject1	Object
    //   50	347	4	localObject2	Object
    //   102	289	5	str1	String
    //   76	11	6	str2	String
    //   145	79	6	localIOException1	java.io.IOException
    //   402	1	6	localIOException2	java.io.IOException
    //   411	1	6	localIOException3	java.io.IOException
    //   112	26	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   107	114	145	java/io/IOException
    //   120	130	145	java/io/IOException
    //   136	142	145	java/io/IOException
    //   201	209	226	java/io/IOException
    //   213	217	247	java/io/IOException
    //   177	185	268	java/io/IOException
    //   189	193	289	java/io/IOException
    //   78	96	310	finally
    //   320	328	346	java/io/IOException
    //   333	338	367	java/io/IOException
    //   96	101	388	finally
    //   107	114	395	finally
    //   120	130	395	finally
    //   136	142	395	finally
    //   153	173	395	finally
    //   78	96	402	java/io/IOException
    //   96	101	411	java/io/IOException
  }
  
  /* Error */
  public static byte[] Lu(String paramString)
  {
    // Byte code:
    //   0: sipush 19264
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 147
    //   8: ldc_w 327
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: aastore
    //   19: invokestatic 161	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aload_0
    //   23: aconst_null
    //   24: invokestatic 332	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
    //   27: astore_2
    //   28: aload_2
    //   29: ldc_w 334
    //   32: invokevirtual 339	com/tencent/mm/network/v:setRequestMethod	(Ljava/lang/String;)V
    //   35: aload_2
    //   36: sipush 25000
    //   39: invokevirtual 342	com/tencent/mm/network/v:setConnectTimeout	(I)V
    //   42: aload_2
    //   43: sipush 25000
    //   46: invokevirtual 345	com/tencent/mm/network/v:setReadTimeout	(I)V
    //   49: aload_2
    //   50: invokevirtual 349	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 352	com/tencent/mm/network/v:getResponseCode	()I
    //   58: sipush 200
    //   61: if_icmpne +235 -> 296
    //   64: new 354	java/io/ByteArrayOutputStream
    //   67: dup
    //   68: invokespecial 355	java/io/ByteArrayOutputStream:<init>	()V
    //   71: astore_0
    //   72: aload_2
    //   73: astore 7
    //   75: aload_3
    //   76: astore 6
    //   78: aload_0
    //   79: astore 5
    //   81: sipush 1024
    //   84: newarray byte
    //   86: astore 4
    //   88: aload_2
    //   89: astore 7
    //   91: aload_3
    //   92: astore 6
    //   94: aload_0
    //   95: astore 5
    //   97: aload_3
    //   98: aload 4
    //   100: invokevirtual 296	java/io/InputStream:read	([B)I
    //   103: istore_1
    //   104: iload_1
    //   105: iconst_m1
    //   106: if_icmpeq +79 -> 185
    //   109: aload_2
    //   110: astore 7
    //   112: aload_3
    //   113: astore 6
    //   115: aload_0
    //   116: astore 5
    //   118: aload_0
    //   119: aload 4
    //   121: iconst_0
    //   122: iload_1
    //   123: invokevirtual 358	java/io/ByteArrayOutputStream:write	([BII)V
    //   126: goto -38 -> 88
    //   129: astore 4
    //   131: aload_2
    //   132: astore 7
    //   134: aload_3
    //   135: astore 6
    //   137: aload_0
    //   138: astore 5
    //   140: ldc 147
    //   142: aload 4
    //   144: ldc 94
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_0
    //   154: ifnull +7 -> 161
    //   157: aload_0
    //   158: invokevirtual 359	java/io/ByteArrayOutputStream:close	()V
    //   161: aload_3
    //   162: ifnull +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 317	java/io/InputStream:close	()V
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 362	com/tencent/mm/network/v:disconnect	()V
    //   177: sipush 19264
    //   180: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aconst_null
    //   184: areturn
    //   185: aload_2
    //   186: astore 7
    //   188: aload_3
    //   189: astore 6
    //   191: aload_0
    //   192: astore 5
    //   194: aload_0
    //   195: invokevirtual 359	java/io/ByteArrayOutputStream:close	()V
    //   198: aload_2
    //   199: astore 7
    //   201: aload_3
    //   202: astore 6
    //   204: aload_0
    //   205: astore 5
    //   207: aload_3
    //   208: invokevirtual 317	java/io/InputStream:close	()V
    //   211: aload_2
    //   212: astore 7
    //   214: aload_3
    //   215: astore 6
    //   217: aload_0
    //   218: astore 5
    //   220: aload_2
    //   221: invokevirtual 362	com/tencent/mm/network/v:disconnect	()V
    //   224: aload_2
    //   225: astore 7
    //   227: aload_3
    //   228: astore 6
    //   230: aload_0
    //   231: astore 5
    //   233: aload_0
    //   234: invokevirtual 366	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   237: astore 4
    //   239: aload_0
    //   240: invokevirtual 359	java/io/ByteArrayOutputStream:close	()V
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 317	java/io/InputStream:close	()V
    //   251: aload_2
    //   252: invokevirtual 362	com/tencent/mm/network/v:disconnect	()V
    //   255: sipush 19264
    //   258: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: aload 4
    //   263: areturn
    //   264: astore_0
    //   265: ldc 147
    //   267: aload_0
    //   268: ldc 94
    //   270: iconst_0
    //   271: anewarray 4	java/lang/Object
    //   274: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: goto -34 -> 243
    //   280: astore_0
    //   281: ldc 147
    //   283: aload_0
    //   284: ldc 94
    //   286: iconst_0
    //   287: anewarray 4	java/lang/Object
    //   290: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: goto -42 -> 251
    //   296: aload_3
    //   297: ifnull +7 -> 304
    //   300: aload_3
    //   301: invokevirtual 317	java/io/InputStream:close	()V
    //   304: aload_2
    //   305: invokevirtual 362	com/tencent/mm/network/v:disconnect	()V
    //   308: goto -131 -> 177
    //   311: astore_0
    //   312: ldc 147
    //   314: aload_0
    //   315: ldc 94
    //   317: iconst_0
    //   318: anewarray 4	java/lang/Object
    //   321: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   324: goto -20 -> 304
    //   327: astore_0
    //   328: ldc 147
    //   330: aload_0
    //   331: ldc 94
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: goto -179 -> 161
    //   343: astore_0
    //   344: ldc 147
    //   346: aload_0
    //   347: ldc 94
    //   349: iconst_0
    //   350: anewarray 4	java/lang/Object
    //   353: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   356: goto -187 -> 169
    //   359: astore_0
    //   360: aconst_null
    //   361: astore 7
    //   363: aconst_null
    //   364: astore_3
    //   365: aconst_null
    //   366: astore_2
    //   367: aload_2
    //   368: ifnull +7 -> 375
    //   371: aload_2
    //   372: invokevirtual 359	java/io/ByteArrayOutputStream:close	()V
    //   375: aload_3
    //   376: ifnull +7 -> 383
    //   379: aload_3
    //   380: invokevirtual 317	java/io/InputStream:close	()V
    //   383: aload 7
    //   385: ifnull +8 -> 393
    //   388: aload 7
    //   390: invokevirtual 362	com/tencent/mm/network/v:disconnect	()V
    //   393: sipush 19264
    //   396: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   399: aload_0
    //   400: athrow
    //   401: astore_2
    //   402: ldc 147
    //   404: aload_2
    //   405: ldc 94
    //   407: iconst_0
    //   408: anewarray 4	java/lang/Object
    //   411: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: goto -39 -> 375
    //   417: astore_2
    //   418: ldc 147
    //   420: aload_2
    //   421: ldc 94
    //   423: iconst_0
    //   424: anewarray 4	java/lang/Object
    //   427: invokestatic 321	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   430: goto -47 -> 383
    //   433: astore_0
    //   434: aconst_null
    //   435: astore_3
    //   436: aconst_null
    //   437: astore 4
    //   439: aload_2
    //   440: astore 7
    //   442: aload 4
    //   444: astore_2
    //   445: goto -78 -> 367
    //   448: astore_0
    //   449: aconst_null
    //   450: astore 4
    //   452: aload_2
    //   453: astore 7
    //   455: aload 4
    //   457: astore_2
    //   458: goto -91 -> 367
    //   461: astore_0
    //   462: aload 6
    //   464: astore_3
    //   465: aload 5
    //   467: astore_2
    //   468: goto -101 -> 367
    //   471: astore 4
    //   473: aconst_null
    //   474: astore_2
    //   475: aconst_null
    //   476: astore_3
    //   477: aconst_null
    //   478: astore_0
    //   479: goto -348 -> 131
    //   482: astore 4
    //   484: aconst_null
    //   485: astore_3
    //   486: aconst_null
    //   487: astore_0
    //   488: goto -357 -> 131
    //   491: astore 4
    //   493: aconst_null
    //   494: astore_0
    //   495: goto -364 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	498	0	paramString	String
    //   103	20	1	i	int
    //   27	345	2	localv	com.tencent.mm.network.v
    //   401	4	2	localIOException1	java.io.IOException
    //   417	23	2	localIOException2	java.io.IOException
    //   444	31	2	localObject1	Object
    //   53	433	3	localObject2	Object
    //   86	34	4	arrayOfByte1	byte[]
    //   129	14	4	localException1	java.lang.Exception
    //   237	219	4	arrayOfByte2	byte[]
    //   471	1	4	localException2	java.lang.Exception
    //   482	1	4	localException3	java.lang.Exception
    //   491	1	4	localException4	java.lang.Exception
    //   79	387	5	str	String
    //   76	387	6	localObject3	Object
    //   73	381	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   81	88	129	java/lang/Exception
    //   97	104	129	java/lang/Exception
    //   118	126	129	java/lang/Exception
    //   194	198	129	java/lang/Exception
    //   207	211	129	java/lang/Exception
    //   220	224	129	java/lang/Exception
    //   233	239	129	java/lang/Exception
    //   239	243	264	java/io/IOException
    //   247	251	280	java/io/IOException
    //   300	304	311	java/io/IOException
    //   157	161	327	java/io/IOException
    //   165	169	343	java/io/IOException
    //   22	28	359	finally
    //   371	375	401	java/io/IOException
    //   379	383	417	java/io/IOException
    //   28	54	433	finally
    //   54	72	448	finally
    //   81	88	461	finally
    //   97	104	461	finally
    //   118	126	461	finally
    //   140	153	461	finally
    //   194	198	461	finally
    //   207	211	461	finally
    //   220	224	461	finally
    //   233	239	461	finally
    //   22	28	471	java/lang/Exception
    //   28	54	482	java/lang/Exception
    //   54	72	491	java/lang/Exception
  }
  
  static String c(com.tencent.mm.plugin.exdevice.h.b paramb)
  {
    AppMethodBeat.i(19271);
    if (paramb == null)
    {
      AppMethodBeat.o(19271);
      return "";
    }
    String str = null;
    if (!bo.isNullOrNil(paramb.dCJ)) {
      str = paramb.dCJ;
    }
    for (;;)
    {
      paramb = bo.nullAsNil(str);
      AppMethodBeat.o(19271);
      return paramb;
      if (!bo.isNullOrNil(paramb.dCK)) {
        str = paramb.dCK;
      } else if (paramb.field_mac != 0L) {
        str = com.tencent.mm.plugin.exdevice.j.b.jw(paramb.field_mac);
      } else if (!bo.isNullOrNil(paramb.field_deviceID)) {
        str = paramb.field_deviceID;
      }
    }
  }
  
  static void dS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(19269);
    el localel = new el();
    localel.csl.csn = paramString2;
    localel.csl.bYu = paramString1;
    a.ymk.l(localel);
    AppMethodBeat.o(19269);
  }
  
  static Boolean ja(long paramLong)
  {
    AppMethodBeat.i(19260);
    boolean bool2 = false;
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.YC().kB(paramLong);
    if (((dd)localObject).field_msgId == 0L)
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(19260);
      return localObject;
    }
    String str = ((dd)localObject).field_content;
    boolean bool1 = bool2;
    if (((bi)localObject).getType() == 49)
    {
      localObject = j.b.mY(str);
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((j.b)localObject).type == 6) {
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(19260);
    return Boolean.valueOf(bool1);
  }
  
  static Boolean jb(long paramLong)
  {
    AppMethodBeat.i(19261);
    boolean bool = false;
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.YC().kB(paramLong);
    if (((dd)localObject).field_msgId == 0L)
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(19261);
      return localObject;
    }
    if (((bi)localObject).getType() == 3) {
      bool = true;
    }
    AppMethodBeat.o(19261);
    return Boolean.valueOf(bool);
  }
  
  static Boolean jc(long paramLong)
  {
    AppMethodBeat.i(19262);
    boolean bool = false;
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.YC().kB(paramLong);
    if (((dd)localObject).field_msgId == 0L)
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(19262);
      return localObject;
    }
    if (((bi)localObject).dxV()) {
      bool = true;
    }
    AppMethodBeat.o(19262);
    return Boolean.valueOf(bool);
  }
  
  static Boolean jd(long paramLong)
  {
    AppMethodBeat.i(19263);
    boolean bool = false;
    aw.aaz();
    Object localObject = com.tencent.mm.model.c.YC().kB(paramLong);
    if (((dd)localObject).field_msgId == 0L)
    {
      localObject = Boolean.FALSE;
      AppMethodBeat.o(19263);
      return localObject;
    }
    if (((bi)localObject).getType() == 62) {
      bool = true;
    }
    AppMethodBeat.o(19263);
    return Boolean.valueOf(bool);
  }
  
  private String je(long paramLong)
  {
    AppMethodBeat.i(19268);
    String str = "";
    aw.aaz();
    Object localObject1 = com.tencent.mm.model.c.YC().kB(paramLong);
    if (((dd)localObject1).field_msgId == 0L)
    {
      AppMethodBeat.o(19268);
      return "";
    }
    int i = ((bi)localObject1).getType();
    Object localObject2 = ((dd)localObject1).field_content;
    if (((bi)localObject1).bCn())
    {
      localObject2 = j.b.mY((String)localObject2);
      if ((localObject2 != null) && ((((j.b)localObject2).type == 6) || (((j.b)localObject2).type == 2)))
      {
        localObject1 = al.aUJ().alo(((j.b)localObject2).cmN);
        if (localObject1 != null) {
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(19268);
      return localObject1;
      ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getFilePath attInfo is null");
      localObject1 = str;
      continue;
      localObject1 = str;
      if (localObject2 != null) {
        if (((j.b)localObject2).type != 3)
        {
          localObject1 = str;
          if (((j.b)localObject2).type != 5) {}
        }
        else
        {
          this.lEn = true;
          localObject1 = str;
          continue;
          if (i == 3)
          {
            localObject2 = com.tencent.mm.at.o.ahC().w((bi)localObject1);
            localObject1 = str;
            if (localObject2 != null)
            {
              str = com.tencent.mm.at.o.ahC().te(((com.tencent.mm.at.e)localObject2).fDM);
              localObject1 = str;
              if (bo.isNullOrNil(str)) {
                localObject1 = com.tencent.mm.at.o.ahC().te(((com.tencent.mm.at.e)localObject2).fDO);
              }
            }
          }
          else if (i == 62)
          {
            com.tencent.mm.modelvideo.o.alE();
            localObject1 = t.vf(((dd)localObject1).field_imgPath);
          }
          else
          {
            localObject1 = str;
            if (i == 48)
            {
              this.lEn = true;
              localObject1 = str;
            }
          }
        }
      }
    }
  }
  
  final boolean a(avn paramavn, long paramLong)
  {
    AppMethodBeat.i(19266);
    int j = -1;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    String str = je(paramLong);
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
        localObject1 = com.tencent.mm.vfs.e.avP(str);
        ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "filePath %s", new Object[] { str });
        ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileSize %s", new Object[] { Integer.valueOf(i) });
        ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "fileMd5 %s", new Object[] { localObject1 });
      }
    }
    aw.aaz();
    localObject4 = com.tencent.mm.model.c.YC().kB(paramLong);
    if (((dd)localObject4).field_msgId == 0L)
    {
      ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "msgInfo or msgInfo.getMsgId() = 0");
      AppMethodBeat.o(19266);
      return false;
    }
    switch (((bi)localObject4).getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(19266);
      return true;
      localObject3 = j.b.mY(((dd)localObject4).field_content);
      if (localObject3 == null)
      {
        ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get content is null");
        AppMethodBeat.o(19266);
        return false;
      }
      if (((j.b)localObject3).type == 3)
      {
        localObject1 = new avq();
        ((avq)localObject1).Title = ((j.b)localObject3).title;
        ((avq)localObject1).xlc = ((j.b)localObject3).description;
        ((avq)localObject1).Url = ((j.b)localObject3).url;
        ((avq)localObject1).xld = ((j.b)localObject3).fgv;
        ((avq)localObject1).wKR = ((j.b)localObject3).fgU;
        ((avq)localObject1).xle = ((j.b)localObject3).fgV;
        ((avq)localObject1).ntp = ((j.b)localObject3).appName;
        if (bo.isNullOrNil(((avq)localObject1).ntp))
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.g.em(((j.b)localObject3).appId, ((j.b)localObject3).bDc);
          if (localObject2 != null) {
            ((avq)localObject1).ntp = ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appName;
          }
        }
        ((avq)localObject1).xlf = ((j.b)localObject3).fgM;
        ((avq)localObject1).xlg = ((j.b)localObject3).fgN;
        ((avq)localObject1).xlh = ((j.b)localObject3).fgS;
        paramavn.xkT = ((avq)localObject1);
        paramavn.xkS = 1;
      }
      else if (((j.b)localObject3).type == 6)
      {
        localObject2 = new avm();
        ((avm)localObject2).Type = ((j.b)localObject3).fgx;
        ((avm)localObject2).Name = ((j.b)localObject3).title;
        ((avm)localObject2).jKn = i;
        ((avm)localObject2).Md5 = ((String)localObject1);
        paramavn.xkW = ((avm)localObject2);
        paramavn.xkS = 4;
      }
      else if (((j.b)localObject3).type == 5)
      {
        localObject1 = new avr();
        ((avr)localObject1).Url = ((j.b)localObject3).url;
        ((avr)localObject1).Title = ((j.b)localObject3).title;
        ((avr)localObject1).xlc = ((j.b)localObject3).description;
        ((avr)localObject1).ntp = ((j.b)localObject3).appName;
        if (bo.isNullOrNil(((avr)localObject1).ntp))
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.g.em(((j.b)localObject3).appId, ((j.b)localObject3).bDc);
          if (localObject2 != null) {
            ((avr)localObject1).ntp = ((com.tencent.mm.pluginsdk.model.app.f)localObject2).field_appName;
          }
        }
        paramavn.xkX = ((avr)localObject1);
        paramavn.xkS = 5;
      }
      else if (((j.b)localObject3).type == 2)
      {
        localObject3 = new avo();
        ((avo)localObject3).Type = "jpg";
        ((avo)localObject3).Name = ((String)localObject2);
        ((avo)localObject3).jKn = i;
        ((avo)localObject3).Md5 = ((String)localObject1);
        paramavn.xkV = ((avo)localObject3);
        paramavn.xkS = 3;
        continue;
        localObject4 = new avo();
        ((avo)localObject4).Type = ((String)localObject3);
        ((avo)localObject4).Name = ((String)localObject2);
        ((avo)localObject4).jKn = i;
        ((avo)localObject4).Md5 = ((String)localObject1);
        paramavn.xkV = ((avo)localObject4);
        paramavn.xkS = 3;
        continue;
        aw.aaz();
        localObject1 = com.tencent.mm.model.c.YC().Tz(((dd)localObject4).field_content);
        localObject2 = new avp();
        ((avp)localObject2).wzW = ((float)((bi.b)localObject1).nZV);
        ((avp)localObject2).wzX = ((float)((bi.b)localObject1).nZW);
        ((avp)localObject2).xla = ((bi.b)localObject1).cyX;
        ((avp)localObject2).Label = ((bi.b)localObject1).label;
        ((avp)localObject2).xlb = ((bi.b)localObject1).eSM;
        paramavn.xkU = ((avp)localObject2);
        paramavn.xkS = 2;
        continue;
        localObject4 = new avs();
        ((avs)localObject4).Type = ((String)localObject3);
        ((avs)localObject4).jKn = i;
        ((avs)localObject4).Md5 = ((String)localObject1);
        ((avs)localObject4).Name = ((String)localObject2);
        paramavn.xkY = ((avs)localObject4);
        paramavn.xkS = 6;
      }
    }
  }
  
  public final TimeLineObject bpO()
  {
    AppMethodBeat.i(19265);
    Object localObject = new ie();
    ((ie)localObject).cxt.crk = this.lEp;
    a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = ((ie)localObject).cxu.cxv;
    AppMethodBeat.o(19265);
    return localObject;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(19270);
    ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm == null)
    {
      ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "scene is null.");
      AppMethodBeat.o(19270);
      return;
    }
    if ((paramm instanceof n))
    {
      Object localObject = (n)paramm;
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "NetSceneGetAppMsgInfo onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        dS(((n)localObject).bYu, this.lEt);
        AppMethodBeat.o(19270);
        return;
      }
      if ((((n)localObject).rr != null) && (((n)localObject).rr.fsW.fta != null)) {}
      for (paramString = (clo)((n)localObject).rr.fsW.fta;; paramString = null)
      {
        paramm = paramString.xVD;
        if (1 != ((n)localObject).lFv) {
          break;
        }
        dS(((n)localObject).bYu, this.lEs);
        AppMethodBeat.o(19270);
        return;
      }
      localObject = ((n)localObject).bYu;
      String str = (String)this.lEC.get(localObject);
      dS((String)localObject, this.lEu);
      if ((this.lEo) && (this.lEp != null)) {}
      for (paramString = this.lEq; (str == null) || (str.length() == 0); paramString = je(this.eaY))
      {
        ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "mDeviceInfo error");
        dS((String)localObject, this.lEt);
        AppMethodBeat.o(19270);
        return;
      }
      if (!this.lEm)
      {
        ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "onItemClick stop scan...");
        Java2CExDevice.stopScanWCLanDevice();
        this.lEm = true;
      }
      if ((!this.lEE.containsKey(localObject)) || (!((Boolean)this.lEE.get(localObject)).booleanValue()))
      {
        ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice mDeviceInfo: ".concat(String.valueOf(str)));
        if (Java2CExDevice.connectWCLanDevice(str.getBytes(), true) != 0)
        {
          dS((String)localObject, this.lEt);
          ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "connectWCLanDevice error!");
        }
      }
      if (this.lEn)
      {
        paramInt1 = Java2CExDevice.useWCLanDeviceService(str.getBytes(), paramm.getBytes());
        if (paramInt1 != 0)
        {
          this.lEO.put(Integer.valueOf(paramInt1), localObject);
          this.lED.put(localObject, Integer.valueOf(paramInt1));
          ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get useWCLanDeviceService mCallBackCmdId: ".concat(String.valueOf(paramInt1)));
          AppMethodBeat.o(19270);
          return;
        }
        dS((String)localObject, this.lEt);
        ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "useWCLanDeviceService error!");
        AppMethodBeat.o(19270);
        return;
      }
      if ((paramString == null) || (paramString.length() == 0))
      {
        ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file path is error");
        dS((String)localObject, this.lEt);
        AppMethodBeat.o(19270);
        return;
      }
      paramInt1 = Java2CExDevice.sendFileToWCLanDevice(str.getBytes(), paramm.getBytes(), paramString.getBytes());
      if (paramInt1 != 0)
      {
        this.lEO.put(Integer.valueOf(paramInt1), localObject);
        this.lED.put(localObject, Integer.valueOf(paramInt1));
        ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "get sendFileToWCLanDevice mCallBackCmdId =".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(19270);
        return;
      }
      dS((String)localObject, this.lEt);
      ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sendFileToWCLanDevice error!");
    }
    AppMethodBeat.o(19270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g
 * JD-Core Version:    0.7.0.1
 */