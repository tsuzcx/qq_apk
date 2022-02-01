package com.tencent.mm.model;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.d;
import com.tencent.mm.api.y;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.nv;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.platformtools.ag.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.cgc;
import com.tencent.mm.protocal.protobuf.cvd;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.protocal.protobuf.cvf;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public final class f
  implements com.tencent.mm.plugin.messenger.foundation.a.p
{
  private long iBJ;
  public a iBK;
  private final LinkedHashMap<String, b> iBL;
  
  public f()
  {
    AppMethodBeat.i(20310);
    this.iBJ = -1L;
    this.iBL = new LinkedHashMap();
    h localh = new h();
    this.iBL.put(localh.getSubType(), localh);
    AppMethodBeat.o(20310);
  }
  
  /* Error */
  private static long HN(String paramString)
  {
    // Byte code:
    //   0: sipush 20314
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 65
    //   9: invokevirtual 71	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifeq +131 -> 143
    //   15: new 73	java/util/zip/ZipFile
    //   18: dup
    //   19: invokestatic 79	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   22: invokevirtual 85	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   25: getfield 91	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   28: invokespecial 94	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: aload 4
    //   38: aload_0
    //   39: iconst_1
    //   40: invokevirtual 98	java/lang/String:substring	(I)Ljava/lang/String;
    //   43: invokevirtual 102	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnonnull +18 -> 66
    //   51: aload 4
    //   53: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   56: sipush 20314
    //   59: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: ldc2_w 36
    //   65: lreturn
    //   66: aload 4
    //   68: astore_3
    //   69: aload_0
    //   70: invokevirtual 111	java/util/zip/ZipEntry:getSize	()J
    //   73: lstore_1
    //   74: aload 4
    //   76: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   79: sipush 20314
    //   82: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: lload_1
    //   86: lreturn
    //   87: astore 5
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: astore_3
    //   93: ldc 113
    //   95: aload 5
    //   97: ldc 115
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: ifnull +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   114: sipush 20314
    //   117: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: ldc2_w 36
    //   123: lreturn
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_3
    //   127: aload_3
    //   128: ifnull +7 -> 135
    //   131: aload_3
    //   132: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   135: sipush 20314
    //   138: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_0
    //   142: athrow
    //   143: aload_0
    //   144: invokestatic 126	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   147: lstore_1
    //   148: sipush 20314
    //   151: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: lload_1
    //   155: lreturn
    //   156: astore_0
    //   157: goto -101 -> 56
    //   160: astore_0
    //   161: goto -82 -> 79
    //   164: astore_0
    //   165: goto -51 -> 114
    //   168: astore_3
    //   169: goto -34 -> 135
    //   172: astore_0
    //   173: goto -46 -> 127
    //   176: astore 5
    //   178: aload 4
    //   180: astore_0
    //   181: goto -90 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramString	String
    //   73	82	1	l	long
    //   35	97	3	localObject	Object
    //   168	1	3	localIOException1	java.io.IOException
    //   31	148	4	localZipFile	java.util.zip.ZipFile
    //   87	9	5	localIOException2	java.io.IOException
    //   176	1	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   15	33	87	java/io/IOException
    //   15	33	124	finally
    //   51	56	156	java/io/IOException
    //   74	79	160	java/io/IOException
    //   110	114	164	java/io/IOException
    //   131	135	168	java/io/IOException
    //   36	47	172	finally
    //   69	74	172	finally
    //   93	106	172	finally
    //   36	47	176	java/io/IOException
    //   69	74	176	java/io/IOException
  }
  
  private static String g(Object... paramVarArgs)
  {
    AppMethodBeat.i(20315);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        int m = paramVarArgs.length;
        i = 0;
        if (i >= m) {
          break label236;
        }
        localObject = paramVarArgs[i];
        if ((localObject instanceof String))
        {
          localByteArrayOutputStream.write(((String)localObject).getBytes());
        }
        else if ((localObject instanceof Integer))
        {
          int k = ((Integer)localObject).intValue();
          j = 0;
          if (j < 4)
          {
            localByteArrayOutputStream.write(k & 0xFF);
            k >>= 8;
            j += 1;
            continue;
          }
        }
        else if ((localObject instanceof Long))
        {
          long l = ((Long)localObject).longValue();
          j = 0;
          if (j < 8)
          {
            localByteArrayOutputStream.write((int)(0xFF & l));
            l >>= 8;
            j += 1;
            continue;
          }
        }
        else if ((localObject instanceof Boolean))
        {
          if (((Boolean)localObject).booleanValue())
          {
            j = 1;
            localByteArrayOutputStream.write(j);
          }
        }
      }
      catch (Exception paramVarArgs)
      {
        Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramVarArgs, "", new Object[0]);
        AppMethodBeat.o(20315);
        return "";
      }
      int j = 0;
      continue;
      Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", new Object[] { localObject });
      AppMethodBeat.o(20315);
      return "";
      label236:
      paramVarArgs = Util.encodeHexString(MessageDigest.getInstance("MD5").digest(localByteArrayOutputStream.toByteArray()));
      AppMethodBeat.o(20315);
      return paramVarArgs;
      i += 1;
    }
  }
  
  /* Error */
  private static String k(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: sipush 20313
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 65
    //   9: invokevirtual 71	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifeq +70 -> 82
    //   15: new 73	java/util/zip/ZipFile
    //   18: dup
    //   19: invokestatic 79	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   22: invokevirtual 85	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   25: getfield 91	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   28: invokespecial 94	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   31: astore 9
    //   33: aload 9
    //   35: aload 9
    //   37: aload_0
    //   38: iconst_1
    //   39: invokevirtual 98	java/lang/String:substring	(I)Ljava/lang/String;
    //   42: invokevirtual 102	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   45: invokevirtual 195	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   48: astore 8
    //   50: aload 9
    //   52: astore_0
    //   53: lload_1
    //   54: lconst_0
    //   55: lcmp
    //   56: ifle +37 -> 93
    //   59: aload_0
    //   60: astore 10
    //   62: aload 8
    //   64: astore 9
    //   66: aload 8
    //   68: lload_1
    //   69: invokevirtual 201	java/io/InputStream:skip	(J)J
    //   72: lstore 6
    //   74: lload_1
    //   75: lload 6
    //   77: lsub
    //   78: lstore_1
    //   79: goto -26 -> 53
    //   82: aload_0
    //   83: invokestatic 205	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   86: astore 8
    //   88: aconst_null
    //   89: astore_0
    //   90: goto -37 -> 53
    //   93: aload_0
    //   94: astore 10
    //   96: aload 8
    //   98: astore 9
    //   100: ldc 170
    //   102: invokestatic 176	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   105: astore 11
    //   107: aload_0
    //   108: astore 10
    //   110: aload 8
    //   112: astore 9
    //   114: sipush 2048
    //   117: newarray byte
    //   119: astore 12
    //   121: lload_3
    //   122: lconst_0
    //   123: lcmp
    //   124: ifle +60 -> 184
    //   127: aload_0
    //   128: astore 10
    //   130: aload 8
    //   132: astore 9
    //   134: aload 8
    //   136: aload 12
    //   138: iconst_0
    //   139: ldc2_w 206
    //   142: lload_3
    //   143: invokestatic 213	java/lang/Math:min	(JJ)J
    //   146: l2i
    //   147: invokevirtual 217	java/io/InputStream:read	([BII)I
    //   150: istore 5
    //   152: iload 5
    //   154: iconst_m1
    //   155: if_icmpeq +29 -> 184
    //   158: aload_0
    //   159: astore 10
    //   161: aload 8
    //   163: astore 9
    //   165: aload 11
    //   167: aload 12
    //   169: iconst_0
    //   170: iload 5
    //   172: invokevirtual 221	java/security/MessageDigest:update	([BII)V
    //   175: lload_3
    //   176: iload 5
    //   178: i2l
    //   179: lsub
    //   180: lstore_3
    //   181: goto -60 -> 121
    //   184: aload_0
    //   185: astore 10
    //   187: aload 8
    //   189: astore 9
    //   191: aload 11
    //   193: invokevirtual 223	java/security/MessageDigest:digest	()[B
    //   196: invokestatic 189	com/tencent/mm/sdk/platformtools/Util:encodeHexString	([B)Ljava/lang/String;
    //   199: astore 11
    //   201: aload 8
    //   203: ifnull +8 -> 211
    //   206: aload 8
    //   208: invokevirtual 224	java/io/InputStream:close	()V
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   219: sipush 20313
    //   222: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aload 11
    //   227: areturn
    //   228: astore 11
    //   230: aconst_null
    //   231: astore_0
    //   232: aconst_null
    //   233: astore 8
    //   235: aload_0
    //   236: astore 10
    //   238: aload 8
    //   240: astore 9
    //   242: ldc 113
    //   244: aload 11
    //   246: ldc 115
    //   248: iconst_0
    //   249: anewarray 4	java/lang/Object
    //   252: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: aload 8
    //   257: ifnull +8 -> 265
    //   260: aload 8
    //   262: invokevirtual 224	java/io/InputStream:close	()V
    //   265: aload_0
    //   266: ifnull +7 -> 273
    //   269: aload_0
    //   270: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   273: sipush 20313
    //   276: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: ldc 115
    //   281: areturn
    //   282: astore_0
    //   283: aconst_null
    //   284: astore 10
    //   286: aconst_null
    //   287: astore 9
    //   289: aload 9
    //   291: ifnull +8 -> 299
    //   294: aload 9
    //   296: invokevirtual 224	java/io/InputStream:close	()V
    //   299: aload 10
    //   301: ifnull +8 -> 309
    //   304: aload 10
    //   306: invokevirtual 105	java/util/zip/ZipFile:close	()V
    //   309: sipush 20313
    //   312: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aload_0
    //   316: athrow
    //   317: astore 8
    //   319: goto -108 -> 211
    //   322: astore_0
    //   323: goto -104 -> 219
    //   326: astore 8
    //   328: goto -63 -> 265
    //   331: astore_0
    //   332: goto -59 -> 273
    //   335: astore 8
    //   337: goto -38 -> 299
    //   340: astore 8
    //   342: goto -33 -> 309
    //   345: astore_0
    //   346: aconst_null
    //   347: astore 8
    //   349: aload 9
    //   351: astore 10
    //   353: aload 8
    //   355: astore 9
    //   357: goto -68 -> 289
    //   360: astore_0
    //   361: goto -72 -> 289
    //   364: astore 11
    //   366: aconst_null
    //   367: astore 8
    //   369: aload 9
    //   371: astore_0
    //   372: goto -137 -> 235
    //   375: astore 11
    //   377: goto -142 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramString	String
    //   0	380	1	paramLong1	long
    //   0	380	3	paramLong2	long
    //   150	27	5	i	int
    //   72	4	6	l	long
    //   48	213	8	localInputStream	java.io.InputStream
    //   317	1	8	localIOException1	java.io.IOException
    //   326	1	8	localIOException2	java.io.IOException
    //   335	1	8	localIOException3	java.io.IOException
    //   340	1	8	localIOException4	java.io.IOException
    //   347	21	8	localObject1	Object
    //   31	339	9	localObject2	Object
    //   60	292	10	localObject3	Object
    //   105	121	11	localObject4	Object
    //   228	17	11	localException1	Exception
    //   364	1	11	localException2	Exception
    //   375	1	11	localException3	Exception
    //   119	49	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   6	33	228	java/lang/Exception
    //   82	88	228	java/lang/Exception
    //   6	33	282	finally
    //   82	88	282	finally
    //   206	211	317	java/io/IOException
    //   215	219	322	java/io/IOException
    //   260	265	326	java/io/IOException
    //   269	273	331	java/io/IOException
    //   294	299	335	java/io/IOException
    //   304	309	340	java/io/IOException
    //   33	50	345	finally
    //   66	74	360	finally
    //   100	107	360	finally
    //   114	121	360	finally
    //   134	152	360	finally
    //   165	175	360	finally
    //   191	201	360	finally
    //   242	255	360	finally
    //   33	50	364	java/lang/Exception
    //   66	74	375	java/lang/Exception
    //   100	107	375	java/lang/Exception
    //   114	121	375	java/lang/Exception
    //   134	152	375	java/lang/Exception
    //   165	175	375	java/lang/Exception
    //   191	201	375	java/lang/Exception
  }
  
  public final h.b a(String paramString, final Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(20312);
    localObject7 = parama.heO;
    localObject6 = z.a(((de)localObject7).KHn);
    Object localObject3 = null;
    if (paramString != null)
    {
      Object localObject1 = (b)this.iBL.get(paramString);
      if (localObject1 != null) {
        try
        {
          localObject1 = ((b)localObject1).a(paramString, paramMap, parama);
          AppMethodBeat.o(20312);
          return localObject1;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", localThrowable, "consumeNewXml dispatch handle subType [%s] error", new Object[] { paramString });
        }
      }
    }
    localObject2 = localObject3;
    if (paramString != null)
    {
      localObject2 = localObject3;
      if (paramString.equals("addcontact"))
      {
        ((de)localObject7).KHn = z.Su((String)paramMap.get(".sysmsg.addcontact.content"));
        ((de)localObject7).xKb = 1;
        localObject2 = h.d.ck(Integer.valueOf(1));
        if (localObject2 != null) {
          break label1129;
        }
        localObject2 = null;
      }
    }
    for (;;)
    {
      if ((paramString != null) && (paramString.equals("dynacfg")))
      {
        com.tencent.mm.n.h.aqJ().a((String)localObject6, paramMap, false);
        com.tencent.mm.n.h.aqK();
        if (com.tencent.mm.n.d.aqw() == 2) {
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10879, "");
        }
        i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("MuteRoomDisable"), 0);
        Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(i));
      }
      if ((paramString != null) && (paramString.equals("dynacfg_split"))) {
        com.tencent.mm.n.h.aqJ().a((String)localObject6, paramMap, true);
      }
      if ((paramString != null) && (paramString.equals("banner")))
      {
        localObject3 = (String)paramMap.get(".sysmsg.mainframebanner.$type");
        localObject8 = (String)paramMap.get(".sysmsg.mainframebanner.showtype");
        localObject9 = (String)paramMap.get(".sysmsg.mainframebanner.data");
        if ((localObject3 == null) || (((String)localObject3).length() <= 0)) {}
      }
      try
      {
        bo.aVL().a(new bn(Util.getInt((String)localObject3, 0), Util.getInt((String)localObject8, 0), (String)localObject9));
        localObject3 = (String)paramMap.get(".sysmsg.friendrecommand.fromuser");
        localObject8 = (String)paramMap.get(".sysmsg.friendrecommand.touser");
        if ((localObject3 == null) || (localObject8 == null)) {}
      }
      catch (Exception localException1)
      {
        try
        {
          bg.aVF().aTm().a((String)localObject8, true, null);
          localObject3 = (String)paramMap.get(".sysmsg.banner.securitybanner.chatname");
          localObject8 = (String)paramMap.get(".sysmsg.banner.securitybanner.wording");
          localObject9 = (String)paramMap.get(".sysmsg.banner.securitybanner.linkname");
          localObject10 = (String)paramMap.get(".sysmsg.banner.securitybanner.linksrc");
          localObject11 = (String)paramMap.get(".sysmsg.banner.securitybanner.showtype");
          if ((!Util.isNullOrNil((String)localObject3)) && (!Util.isNullOrNil((String)localObject11))) {}
          try
          {
            if (!((String)localObject11).equals("1")) {
              break label7341;
            }
            bool1 = true;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + localException3.toString());
              continue;
              long l1 = l2;
              Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and has done delete info, originSvrId[%d]", new Object[] { Long.valueOf(l2) });
              l1 = l2;
              com.tencent.mm.modelmulti.p.bdT();
              l1 = l2;
              com.tencent.mm.modelmulti.p.bdR().delete((IAutoDBItem)localObject9, true, new String[0]);
              if (localObject6 != null)
              {
                l1 = l2;
                if (parama.heO != null)
                {
                  l1 = l2;
                  if (((bb)localObject6).field_lastSeq == parama.heO.KHs)
                  {
                    l1 = l2;
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", new Object[] { Long.valueOf(((bb)localObject6).field_lastSeq), Long.valueOf(((bb)localObject6).field_firstUnDeliverSeq) });
                    l1 = l2;
                    bg.aVF();
                    l1 = l2;
                    localObject7 = c.aSQ().aEz(((bb)localObject6).field_username);
                    if (localObject7 != null)
                    {
                      l1 = l2;
                      ((az)localObject6).yC(((eo)localObject7).field_msgSeq);
                      l1 = l2;
                      bg.aVF();
                      l1 = l2;
                      i = c.aST().a((az)localObject6, ((bb)localObject6).field_username);
                      l1 = l2;
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", new Object[] { Long.valueOf(((eo)localObject7).field_msgSvrId), Long.valueOf(((eo)localObject7).field_msgSeq), Long.valueOf(((bb)localObject6).field_lastSeq), Long.valueOf(((bb)localObject6).field_firstUnDeliverSeq), Integer.valueOf(i) });
                    }
                  }
                }
              }
              l1 = l2;
              if (localException3.field_msgId == 0L)
              {
                l1 = l2;
                if (((PluginPatMsg)com.tencent.mm.kernel.g.ah(PluginPatMsg.class)).getRecvRecord(l2) != null)
                {
                  l1 = l2;
                  ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.patmsg.a.b.class)).bd(paramString, l2);
                  continue;
                }
              }
              int j;
              if ((paramString != null) && (paramString.equals("clouddelmsg")))
              {
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
                localObject4 = (String)paramMap.get(".sysmsg.clouddelmsg.delcommand");
                localObject2 = (String)paramMap.get(".sysmsg.clouddelmsg.msgid");
                paramMap = (String)paramMap.get(".sysmsg.clouddelmsg.fromuser");
                i = ((String)localObject6).indexOf("<msg>");
                j = ((String)localObject6).indexOf("</msg>");
                if ((i == -1) || (j == -1))
                {
                  paramString = "";
                  Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", new Object[] { localObject4, localObject2, paramMap, paramString });
                }
                for (;;)
                {
                  try
                  {
                    bg.aVF();
                    paramMap = c.aSQ().iJ(paramMap, (String)localObject2);
                    if ((paramMap == null) || (paramMap.size() <= 0))
                    {
                      Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
                      AppMethodBeat.o(20312);
                      return null;
                      paramString = SemiXml.encode(XmlParser.parseXml(((String)localObject6).substring(i, j + 6), "msg", null));
                      break;
                    }
                    paramMap = paramMap.iterator();
                    if (paramMap.hasNext())
                    {
                      localObject7 = (ca)paramMap.next();
                      if (localObject7 != null) {
                        break label2286;
                      }
                      Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
                    }
                    if (((ca)localObject7).ajM() >= 0L) {
                      break label2333;
                    }
                  }
                  catch (Exception paramString)
                  {
                    Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", new Object[] { localObject2, paramString.toString() });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((ca)localObject7).ajL()), Long.valueOf(((ca)localObject7).ajM()) });
                }
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((ca)localObject7).ajL()), Long.valueOf(((ca)localObject7).ajM()) });
                localObject6 = ca.aZ((ca)localObject7);
                i = Util.getInt((String)localObject4, 0);
                if (i == 1)
                {
                  bg.aVF();
                  c.aSQ().aT(((ca)localObject7).ajO(), ((ca)localObject7).ajM());
                }
                for (;;)
                {
                  localObject8 = new sw();
                  ((sw)localObject8).dZp.msgId = ((ca)localObject7).ajL();
                  ((sw)localObject8).dZp.dZq = paramString;
                  ((sw)localObject8).dZp.dTX = ((ca)localObject7);
                  EventCenter.instance.publish((IEvent)localObject8);
                  if (!aa.i((ca)localObject6)) {
                    break;
                  }
                  localObject7 = new nv();
                  ((nv)localObject7).dTW.dTX = ((ca)localObject6);
                  EventCenter.instance.publish((IEvent)localObject7);
                  break;
                  if ((i == 2) && (((ca)localObject7).gAt()))
                  {
                    ((ca)localObject7).setContent(paramString);
                    bp.a((ca)localObject7, parama);
                    bg.aVF();
                    c.aSQ().b(((ca)localObject7).ajM(), (ca)localObject7);
                    bg.aVF();
                    localObject8 = c.aST().bjY(((ca)localObject7).ajO());
                    if ((localObject8 != null) && (((az)localObject8).ajG() > 0))
                    {
                      bg.aVF();
                      i = c.aSQ().aB((ca)localObject7);
                      if (((az)localObject8).ajG() >= i)
                      {
                        ((az)localObject8).nt(((az)localObject8).ajG() - 1);
                        bg.aVF();
                        c.aST().a((az)localObject8, ((az)localObject8).getUsername());
                      }
                    }
                  }
                }
              }
              if ((paramString != null) && (paramString.equals("updatepackage")))
              {
                localObject2 = h.d.ck(Integer.valueOf(-1879048175));
                if (localObject2 != null) {}
              }
              Object localObject5;
              for (Object localObject4 = null;; localObject5 = localObject2)
              {
                for (;;)
                {
                  localObject2 = localObject4;
                  if (paramString != null)
                  {
                    localObject2 = localObject4;
                    if (paramString.equals("deletepackage"))
                    {
                      localObject2 = h.d.ck(Integer.valueOf(-1879048174));
                      if (localObject2 != null) {
                        break label3431;
                      }
                      localObject2 = null;
                    }
                  }
                  String[] arrayOfString;
                  if ((paramString != null) && (paramString.equals("delchatroommember")))
                  {
                    localObject4 = z.a(((de)localObject7).KHl);
                    bg.aVF();
                    localObject8 = c.aSQ().aJ((String)localObject4, ((de)localObject7).Brn);
                    i = 0;
                    if (((ca)localObject8).ajL() > 0L) {
                      i = 1;
                    }
                    ((ca)localObject8).yF(((de)localObject7).Brn);
                    if ((parama == null) || (!parama.iLV) || (!parama.iLX)) {
                      ((ca)localObject8).setCreateTime(bp.C((String)localObject4, ((de)localObject7).CreateTime));
                    }
                    ((ca)localObject8).setType(10002);
                    ((ca)localObject8).setContent((String)localObject6);
                    ((ca)localObject8).nv(0);
                    ((ca)localObject8).Cy((String)localObject4);
                    ((ca)localObject8).BB(((de)localObject7).KHq);
                    bp.a((ca)localObject8, parama);
                    if (i == 0) {
                      bp.x((ca)localObject8);
                    }
                  }
                  else
                  {
                    localObject4 = localObject2;
                    if (paramString != null)
                    {
                      localObject4 = localObject2;
                      if (paramString.equals("WakenPush"))
                      {
                        localObject4 = localObject2;
                        if (this.iBJ != ((de)localObject7).Brn)
                        {
                          this.iBJ = ((de)localObject7).Brn;
                          Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                          localObject2 = new cq(paramMap);
                          localObject4 = (String)((cq)localObject2).izF.get(".sysmsg.WakenPush.PushContent");
                          localObject6 = (String)((cq)localObject2).izF.get(".sysmsg.WakenPush.Jump");
                          localObject9 = (String)((cq)localObject2).izF.get(".sysmsg.WakenPush.ExpiredTime");
                          localObject8 = (String)((cq)localObject2).izF.get(".sysmsg.WakenPush.Username");
                          Log.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", new Object[] { localObject4, localObject6, localObject9 });
                          localObject9 = com.tencent.mm.n.h.aqJ().getValue("WakenPushDeepLinkBitSet");
                          Log.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", new Object[] { localObject9 });
                          if (Util.isNullOrNil((String)localObject9)) {
                            break label3466;
                          }
                          l1 = Util.getLong((String)localObject9, 0L);
                          localObject9 = com.tencent.mm.aj.c.a((String)localObject8, false, -1, null);
                          localObject2 = bg.getNotification().a(((cq)localObject2).F((String)localObject6, l1), MMApplicationContext.getContext().getString(2131755908), (String)localObject4, (String)localObject4, (Bitmap)localObject9, (String)localObject8);
                          ((Notification)localObject2).flags |= 0x10;
                          bg.getNotification().a((Notification)localObject2, false);
                          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 31L, 1L, true);
                          localObject4 = null;
                        }
                      }
                    }
                    localObject2 = localObject4;
                    if (paramString == null) {
                      break label3644;
                    }
                    localObject2 = localObject4;
                    if (!paramString.equals("DisasterNotice")) {
                      break label3644;
                    }
                    localObject8 = (String)paramMap.get(".sysmsg.NoticeId");
                    localObject9 = (String)paramMap.get(".sysmsg.Content");
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", new Object[] { localObject8, localObject9 });
                    localObject10 = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.g.aps());
                    localObject6 = ((SharedPreferences)localObject10).getString("disaster_noticeid_list_key", "");
                    if (((String)localObject6).contains((CharSequence)localObject8)) {
                      break label3587;
                    }
                    localObject11 = ((String)localObject6).split(";");
                    if ((localObject11 == null) || (localObject11.length <= 10)) {
                      break label3498;
                    }
                    localObject2 = "";
                    j = localObject11.length;
                    i = 0;
                    localObject4 = localObject2;
                    if (i >= j) {
                      break label3502;
                    }
                    arrayOfString = localObject11[i].split(",");
                    localObject4 = localObject2;
                  }
                  try
                  {
                    if (Util.secondsToNow(Util.getLong(arrayOfString[0], 0L)) < 1296000L) {
                      localObject4 = (String)localObject2 + arrayOfString[0] + "," + arrayOfString[1] + ";";
                    }
                    i += 1;
                    localObject2 = localObject4;
                    break label3316;
                    localObject4 = ((com.tencent.mm.ak.h)localObject2).b(parama);
                    continue;
                    localObject2 = ((com.tencent.mm.ak.h)localObject2).b(parama);
                    break label2712;
                    bg.aVF();
                    c.aSQ().b(((de)localObject7).Brn, (ca)localObject8);
                    break label2872;
                    l1 = 0L;
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", new Object[] { localException4 });
                      localObject5 = localObject2;
                    }
                  }
                }
                localObject5 = localObject6;
                localObject2 = (String)localObject5 + Util.nowSecond() + "," + (String)localObject8 + ";";
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", new Object[] { localObject6, localObject2 });
                ((SharedPreferences)localObject10).edit().putString("disaster_noticeid_list_key", (String)localObject2).commit();
                new MMHandler(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(20306);
                    if (f.this.iBK != null) {
                      f.this.iBK.gt(this.iBM);
                    }
                    AppMethodBeat.o(20306);
                  }
                });
                ((de)localObject7).KHn = z.Su((String)localObject9);
                ((de)localObject7).xKb = 1;
                localObject2 = h.d.ck(Integer.valueOf(1));
                if (localObject2 == null)
                {
                  localObject2 = null;
                  if ((paramString == null) || (!paramString.equals("EmotionKv"))) {
                    break label4192;
                  }
                  paramString = (String)paramMap.get(".sysmsg.EmotionKv.K");
                  localObject2 = (String)paramMap.get(".sysmsg.EmotionKv.I");
                  if (paramString != null) {
                    break label7331;
                  }
                  paramString = "";
                }
                for (;;)
                {
                  Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", new Object[] { Integer.valueOf(paramString.length()), paramString, localObject2 });
                  localObject5 = ac.gtR().KAw.getBytes();
                  localObject6 = ac.gtR().KAx.getBytes();
                  paramMap = null;
                  try
                  {
                    parama = bg.azz().azD().aZh().aZc();
                    paramMap = parama;
                  }
                  catch (Exception parama)
                  {
                    for (;;)
                    {
                      Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", new Object[] { Util.stackTraceToString(parama) });
                    }
                    localObject7 = com.tencent.mm.protocal.f.gtA();
                    if (!Util.isNullOrNil((byte[])localObject7)) {
                      break label3854;
                    }
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  newECDH  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                    parama = new PByteArray();
                    if (Util.isNullOrNil(paramString)) {
                      break label3900;
                    }
                  }
                  if (Util.isNullOrNil(paramMap))
                  {
                    Log.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                    localObject2 = ((com.tencent.mm.ak.h)localObject2).b(parama);
                    break;
                  }
                  int k;
                  int m;
                  int n;
                  if ((Util.isNullOrNil((byte[])localObject6)) || (Util.isNullOrNil((byte[])localObject5)) || (Util.isNullOrNil(paramMap)) || (Util.isNullOrNil((byte[])localObject7))) {
                    if (paramString == null)
                    {
                      i = -1;
                      if (localObject6 != null) {
                        break label4123;
                      }
                      j = -1;
                      if (localObject5 != null) {
                        break label4131;
                      }
                      k = -1;
                      if (paramMap != null) {
                        break label4139;
                      }
                      m = -1;
                      if (localObject7 != null) {
                        break label4146;
                      }
                      n = -1;
                      Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d newECDH:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
                      paramString = parama.value;
                      paramMap = new cgc();
                      if (parama.value == null) {
                        break label4176;
                      }
                      paramMap.Cyk = new String(parama.value);
                      if (paramString != null) {
                        break label4185;
                      }
                    }
                  }
                  for (i = -1;; i = paramString.length)
                  {
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv res len:%d val len:%d, content[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramMap.Cyk.length()), com.tencent.mm.b.g.getMessageDigest(paramMap.Cyk.getBytes()) });
                    paramMap.MlO = ((String)localObject2);
                    bg.aVF();
                    c.aSM().d(new k.a(59, paramMap));
                    AppMethodBeat.o(20312);
                    return null;
                    i = paramString.length();
                    break;
                    j = localObject6.length;
                    break label3915;
                    k = localObject5.length;
                    break label3923;
                    m = paramMap.length;
                    break label3930;
                    n = localObject7.length;
                    break label3938;
                    bg.aVF();
                    MMProtocalJni.genClientCheckKVRes(c.getUin(), paramString, (byte[])localObject5, (byte[])localObject6, paramMap, (byte[])localObject7, parama);
                    break label3990;
                    paramMap.Cyk = "";
                    break label4025;
                  }
                  if ((paramString != null) && (paramString.equals("globalalert")))
                  {
                    paramString = (String)paramMap.get(".sysmsg.uuid");
                    i = Util.getInt((String)paramMap.get(".sysmsg.id"), -1);
                    j = Util.getInt((String)paramMap.get(".sysmsg.important"), -1);
                    if ((Util.isNullOrNil(paramString)) || (i < 0) || (j < 0))
                    {
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    parama = (String)paramMap.get(".sysmsg.title");
                    localObject2 = (String)paramMap.get(".sysmsg.msg");
                    if ((Util.isNullOrNil(parama)) && (Util.isNullOrNil((String)localObject2)))
                    {
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", new Object[] { parama, localObject2 });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject6 = (String)paramMap.get(".sysmsg.btnlist.btn.$title");
                    k = Util.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$id"), -1);
                    m = Util.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                    localObject7 = (String)paramMap.get(".sysmsg.btnlist.btn");
                    if ((Util.isNullOrNil((String)localObject6)) || (k < 0) || (m < 0))
                    {
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", new Object[] { localObject6, Integer.valueOf(k), Integer.valueOf(m) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject5 = (String)paramMap.get(".sysmsg.btnlist.btn1.$title");
                    n = Util.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$id"), -1);
                    int i1 = Util.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                    paramMap = (String)paramMap.get(".sysmsg.btnlist.btn1");
                    bool1 = true;
                    if ((Util.isNullOrNil((String)localObject5)) || (n < 0) || (i1 < 0))
                    {
                      bool1 = false;
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", new Object[] { localObject6, Integer.valueOf(k), Integer.valueOf(m) });
                    }
                    localObject8 = new kk();
                    localObject9 = new com.tencent.mm.protocal.b.a.b();
                    ((kk)localObject8).dPw.dPx = ((com.tencent.mm.protocal.b.a.b)localObject9);
                    ((com.tencent.mm.protocal.b.a.b)localObject9).id = i;
                    ((com.tencent.mm.protocal.b.a.b)localObject9).title = parama;
                    ((com.tencent.mm.protocal.b.a.b)localObject9).msg = ((String)localObject2);
                    ((com.tencent.mm.protocal.b.a.b)localObject9).KBq = new LinkedList();
                    localObject10 = new com.tencent.mm.protocal.b.a.a();
                    ((com.tencent.mm.protocal.b.a.a)localObject10).id = k;
                    ((com.tencent.mm.protocal.b.a.a)localObject10).actionType = m;
                    ((com.tencent.mm.protocal.b.a.a)localObject10).KBo = ((String)localObject6);
                    ((com.tencent.mm.protocal.b.a.a)localObject10).KBp = ((String)localObject7);
                    ((com.tencent.mm.protocal.b.a.b)localObject9).KBq.add(localObject10);
                    if (bool1)
                    {
                      localObject6 = new com.tencent.mm.protocal.b.a.a();
                      ((com.tencent.mm.protocal.b.a.a)localObject6).id = n;
                      ((com.tencent.mm.protocal.b.a.a)localObject6).actionType = i1;
                      ((com.tencent.mm.protocal.b.a.a)localObject6).KBo = ((String)localObject5);
                      ((com.tencent.mm.protocal.b.a.a)localObject6).KBp = paramMap;
                      ((com.tencent.mm.protocal.b.a.b)localObject9).KBq.add(localObject6);
                    }
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), parama, localObject2, Boolean.valueOf(bool1), Boolean.valueOf(EventCenter.instance.publish((IEvent)localObject8)) });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  if ((paramString != null) && (paramString.equals("yybsigcheck")))
                  {
                    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 14L, 1L, false);
                    l1 = System.currentTimeMillis();
                    paramString = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                    parama = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.wording");
                    paramMap = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.url");
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", new Object[] { paramString, parama, paramMap });
                    com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4014), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    if (Util.isNullOrNil(paramString))
                    {
                      Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 15L, 1L, false);
                      com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4015), String.format("%s|%s", new Object[] { parama, paramMap }) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject2 = paramString.split(";");
                    if (localObject2 == null) {}
                    for (i = -1;; i = localObject2.length)
                    {
                      Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStrs len is %d", new Object[] { Integer.valueOf(i) });
                      if ((localObject2 != null) && (localObject2.length != 0)) {
                        break;
                      }
                      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 16L, 1L, false);
                      com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4016), paramString });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject5 = new ArrayList();
                    i = 0;
                    if (i < localObject2.length)
                    {
                      localObject6 = localObject2[i];
                      if (Util.isNullOrNil((String)localObject6)) {
                        Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", new Object[] { Integer.valueOf(i) });
                      }
                      for (;;)
                      {
                        i += 1;
                        break;
                        localObject7 = ((String)localObject6).split(",");
                        if (localObject7 == null) {}
                        for (j = -1;; j = localObject7.length)
                        {
                          Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is %d", new Object[] { Integer.valueOf(j) });
                          if ((localObject7 != null) && (localObject7.length == 3)) {
                            break label5331;
                          }
                          Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", new Object[] { Integer.valueOf(i) });
                          break;
                        }
                        try
                        {
                          ((ArrayList)localObject5).add(new ag.c(localObject7[0], Util.getInt(localObject7[1], 0), localObject7[2]));
                        }
                        catch (Exception localException5)
                        {
                          Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", new Object[] { Integer.valueOf(i), localException5.getMessage() });
                          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 17L, 1L, false);
                          com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4017), localObject6 });
                        }
                      }
                    }
                    if (((ArrayList)localObject5).size() == 0)
                    {
                      Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 18L, 1L, false);
                      com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4018), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)
                    {
                      bool1 = true;
                      boolean bool2 = com.tencent.mm.platformtools.ag.a(MMApplicationContext.getContext(), (ArrayList)localObject5, bool1);
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", new Object[] { Integer.valueOf(((ArrayList)localObject5).size()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l1) });
                      if (bool2) {
                        break label5729;
                      }
                      bg.aVD().setInt(46, 4);
                      localObject2 = new lg();
                      ((lg)localObject2).dQw.dQx = parama;
                      ((lg)localObject2).dQw.url = paramMap;
                      EventCenter.instance.publish((IEvent)localObject2);
                      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 20L, 1L, true);
                      com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4020), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(20312);
                      return null;
                      bool1 = false;
                      break;
                      bg.aVD().setInt(46, 0);
                      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 19L, 1L, true);
                      com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4019), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    }
                  }
                  if ((paramString != null) && (paramString.equals("qy_status_notify")))
                  {
                    parama = (String)paramMap.get(".sysmsg.chat_id");
                    paramMap.get(".sysmsg.last_create_time");
                    paramString = (String)paramMap.get(".sysmsg.brand_username");
                    l1 = com.tencent.mm.al.a.e.NM(parama);
                    if (l1 == -1L)
                    {
                      Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", new Object[] { parama });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    i = com.tencent.mm.al.ag.bak().Al(l1).field_newUnReadCount;
                    com.tencent.mm.al.ag.bak().An(l1);
                    paramMap = com.tencent.mm.al.ag.baj().bs(l1);
                    bg.aVF();
                    parama = c.aST().bjY(paramString);
                    if (parama == null)
                    {
                      Log.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", new Object[] { paramString });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    if (paramMap.iE(1))
                    {
                      if (parama.ajH() <= i)
                      {
                        parama.nz(0);
                        bg.aVF();
                        c.aST().a(parama, paramString);
                        bg.getNotification().cancelNotification(paramString);
                      }
                      for (;;)
                      {
                        AppMethodBeat.o(20312);
                        return null;
                        parama.nz(parama.ajH() - i);
                        bg.aVF();
                        c.aST().a(parama, paramString);
                      }
                    }
                    if (parama.ajG() <= i)
                    {
                      bg.aVF();
                      c.aST().bka(paramString);
                      bg.getNotification().cancelNotification(paramString);
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(20312);
                      return null;
                      parama.ny(0);
                      parama.nB(0);
                      parama.nt(parama.ajG() - i);
                      bg.aVF();
                      c.aST().a(parama, paramString);
                    }
                  }
                  if ((paramString != null) && (paramString.equals("qy_chat_update")))
                  {
                    parama = (String)paramMap.get(".sysmsg.chat_id");
                    localObject5 = (String)paramMap.get(".sysmsg.ver");
                    com.tencent.mm.al.a.e.n((String)paramMap.get(".sysmsg.brand_username"), parama, (String)localObject5);
                  }
                  if ((paramString != null) && (paramString.equals("bindmobiletip")))
                  {
                    i = Util.getInt((String)paramMap.get(".sysmsg.bindmobiletip.forcebind"), 0);
                    parama = Util.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.deviceid"));
                    paramString = Util.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.wording"));
                    paramMap = new String(Base64.decode(parama.getBytes(), 0));
                    parama = new String(com.tencent.mm.bw.b.cD(q.aoG().getBytes()).aiU(16).zy);
                    Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", new Object[] { Integer.valueOf(i), paramMap, parama, paramString });
                    if ((Util.isNullOrNil(paramMap)) || (paramMap.equals(parama)))
                    {
                      bg.aVF();
                      c.azQ().set(ar.a.NUL, Boolean.TRUE);
                      bg.aVF();
                      paramMap = c.azQ();
                      parama = ar.a.NUN;
                      if (i != 1) {
                        break label6406;
                      }
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramMap.set(parama, Boolean.valueOf(bool1));
                      bg.aVF();
                      c.azQ().set(ar.a.NUO, paramString);
                      AppMethodBeat.o(20312);
                      return null;
                    }
                  }
                  if ((paramString != null) && (paramString.equals("ClientCheckConsistency")))
                  {
                    parama = new cvd();
                    parama.xuz = ((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename"));
                    parama.MAA = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                    parama.MAB = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                    parama.KXP = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                    parama.MAC = k(parama.xuz, parama.MAA, parama.MAB);
                    parama.FileSize = ((int)HN(parama.xuz));
                    if (!com.tencent.mm.plugin.normsg.a.d.AEF.exH()) {
                      break label7278;
                    }
                    i = 1;
                  }
                  for (;;)
                  {
                    parama.MAD = i;
                    parama.Llx = ab.ape();
                    parama.MAE = g(new Object[] { parama.xuz, Integer.valueOf(parama.MAA), Integer.valueOf(parama.MAB), Integer.valueOf(parama.KXP), parama.MAC, Integer.valueOf(parama.FileSize), Integer.valueOf(parama.MAD), Integer.valueOf(parama.Llx) });
                    bg.aVF();
                    c.aSM().d(new k.a(61, parama));
                    if ((paramString != null) && (paramString.equals("ClientCheckHook")))
                    {
                      parama = new cvf();
                      parama.KXP = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                      parama.MAG = com.tencent.mm.plugin.normsg.a.d.AEF.sv(false);
                      if (com.tencent.mm.plugin.normsg.a.d.AEF.exH())
                      {
                        i = 1;
                        parama.MAD = i;
                        parama.Llx = ab.ape();
                        parama.MAE = g(new Object[] { Integer.valueOf(parama.KXP), parama.MAG, Integer.valueOf(parama.MAD), Integer.valueOf(parama.Llx) });
                        bg.aVF();
                        c.aSM().d(new k.a(62, parama));
                      }
                    }
                    else
                    {
                      if ((paramString != null) && (paramString.equals("ClientCheckGetAppList")))
                      {
                        parama = new cve();
                        parama.KXP = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                        parama.MAF = com.tencent.mm.plugin.normsg.a.d.AEF.exG();
                        if (!com.tencent.mm.plugin.normsg.a.d.AEF.exH()) {
                          break label7290;
                        }
                        i = 1;
                        parama.MAD = i;
                        parama.Llx = ab.ape();
                        parama.MAE = g(new Object[] { Integer.valueOf(parama.KXP), parama.MAF, Integer.valueOf(parama.MAD), Integer.valueOf(parama.Llx) });
                        bg.aVF();
                        c.aSM().d(new k.a(63, parama));
                      }
                      if ((paramString != null) && (paramString.equals("ClientCheckGetExtInfo"))) {
                        ThreadPool.postAtFront(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(20307);
                            int i = Util.getInt((String)paramMap.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0);
                            if (Util.getInt((String)paramMap.get(".sysmsg.ClientCheckGetExtInfo.Basic"), 0) != 0)
                            {
                              com.tencent.mm.plugin.secinforeport.a.d.CWG.ik(i, 0);
                              AppMethodBeat.o(20307);
                              return;
                            }
                            com.tencent.mm.plugin.secinforeport.a.d.CWG.ik(i, 63);
                            AppMethodBeat.o(20307);
                          }
                        }, "syscmd_rpt_cc");
                      }
                      if ((!Util.isNullOrNil(paramString)) && (paramString.equals("functionmsg")))
                      {
                        Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                        ((y)com.tencent.mm.kernel.g.ah(y.class)).getReceiver().a(localException5, paramMap);
                      }
                      if ((!Util.isNullOrNil(paramString)) && (paramString.equals("paymsg")))
                      {
                        i = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0);
                        localObject5 = (String)paramMap.get(".sysmsg.paymsg.appmsgcontent");
                        paramString = (String)paramMap.get(".sysmsg.paymsg.fromusername");
                        parama = (String)paramMap.get(".sysmsg.paymsg.tousername");
                        paramMap = (String)paramMap.get(".sysmsg.paymsg.paymsgid");
                        Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", new Object[] { Integer.valueOf(i), Long.valueOf(localException5.Brn), paramString, parama, paramMap, localObject5 });
                      }
                    }
                    try
                    {
                      localObject5 = URLDecoder.decode((String)localObject5, "UTF-8");
                      if (!Util.isNullOrNil((String)localObject5))
                      {
                        localObject6 = new qq();
                        ((qq)localObject6).dXe.type = i;
                        ((qq)localObject6).dXe.content = ((String)localObject5);
                        ((qq)localObject6).dXe.dRL = paramString;
                        ((qq)localObject6).dXe.toUser = parama;
                        ((qq)localObject6).dXe.dXf = paramMap;
                        EventCenter.instance.publish((IEvent)localObject6);
                      }
                      AppMethodBeat.o(20312);
                      return localObject2;
                      i = 0;
                      continue;
                      i = 0;
                      break label6743;
                      i = 0;
                    }
                    catch (Exception paramString)
                    {
                      for (;;)
                      {
                        Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "", new Object[0]);
                        Log.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", new Object[] { paramString.getMessage() });
                      }
                    }
                  }
                }
              }
              boolean bool1 = false;
            }
          }
          bg.aVF().aTn().a((String)localObject3, bool1, new String[] { localObject8, localObject9, localObject10 });
          bg.aVF().aTo().C(paramMap);
          if ((!Util.isNullOrNil(paramString)) && (paramString.equals("midinfo")))
          {
            localObject3 = (String)paramMap.get(".sysmsg.midinfo.json_buffer");
            localObject8 = (String)paramMap.get(".sysmsg.midinfo.time_interval");
            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", new Object[] { localObject8, localObject3, localObject6 });
            i = Util.getInt((String)localObject8, 0);
            if ((i > 86400L) && (i < 864000L))
            {
              bg.aVF();
              c.azQ().set(331777, Long.valueOf(Util.nowSecond() + i));
            }
            if (!Util.isNullOrNil((String)localObject3)) {
              com.tencent.mm.plugin.report.b.d.aMs((String)localObject3);
            }
          }
          if ((paramString != null) && (paramString.equals("revokemsg")))
          {
            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
            paramString = (String)paramMap.get(".sysmsg.revokemsg.session");
            localObject2 = (String)paramMap.get(".sysmsg.revokemsg.newmsgid");
            paramMap = (String)paramMap.get(".sysmsg.revokemsg.replacemsg");
            Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject2, paramMap });
            l1 = 0L;
            try
            {
              l2 = Util.getLong((String)localObject2, 0L);
              l1 = l2;
              Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "xmlSrvMsgId=%d talker=%s isGet=%s", new Object[] { Long.valueOf(l2), paramString, Boolean.valueOf(parama.iLV) });
              l1 = l2;
              localObject3 = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aJ(paramString, l2);
              l1 = l2;
              localObject2 = ca.aZ((ca)localObject3);
              l1 = l2;
              bg.aVF();
              l1 = l2;
              localObject6 = c.aST().bjY(paramString);
              if (parama == null) {
                break label1473;
              }
              l1 = l2;
              if (!parama.iLV) {
                break label1473;
              }
              l1 = l2;
              localObject7 = parama.heO;
              l1 = l2;
              localObject8 = z.a(((de)localObject7).KHn);
              l1 = l2;
              localObject9 = new bt();
              l1 = l2;
              ((bt)localObject9).field_originSvrId = l2;
              l1 = l2;
              if (((eo)localObject3).field_msgId != 0L) {
                break label1203;
              }
              l1 = l2;
              Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", new Object[] { Long.valueOf(l2) });
              l1 = l2;
              ((bt)localObject9).field_content = ((String)localObject8);
              l1 = l2;
              ((bt)localObject9).field_createTime = ((de)localObject7).CreateTime;
              l1 = l2;
              ((bt)localObject9).field_flag = bp.d(parama);
              l1 = l2;
              ((bt)localObject9).field_fromUserName = z.a(((de)localObject7).KHl);
              l1 = l2;
              ((bt)localObject9).field_toUserName = z.a(((de)localObject7).KHm);
              l1 = l2;
              ((bt)localObject9).field_newMsgId = ((de)localObject7).Brn;
              l1 = l2;
              com.tencent.mm.modelmulti.p.bdT();
              l1 = l2;
              Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr insert ret[%b], systemRowid[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelmulti.p.bdR().insert((IAutoDBItem)localObject9)), Long.valueOf(((bt)localObject9).systemRowid) });
            }
            catch (Exception paramString)
            {
              for (;;)
              {
                long l2;
                label1129:
                Log.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[oneliang][revokeMsg] msgId:%d,error:%s", new Object[] { Long.valueOf(l1), paramString.toString() });
                continue;
                l1 = l2;
                Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke newxml, but original msg has not been found, originSvrId[%d]", new Object[] { Long.valueOf(l2) });
                l1 = l2;
                bg.aVF();
                l1 = l2;
                c.aSQ().Hf(l2);
                continue;
                l1 = l2;
                if (localException3.getType() == 922746929)
                {
                  l1 = l2;
                  ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.patmsg.a.b.class)).bd(paramString, l2);
                }
                else
                {
                  l1 = l2;
                  paramString = new sw();
                  l1 = l2;
                  paramString.dZp.msgId = localException3.field_msgId;
                  l1 = l2;
                  paramString.dZp.dZq = paramMap;
                  l1 = l2;
                  paramString.dZp.dTX = localException3;
                  l1 = l2;
                  paramString.dZp.dZr = ((ca)localObject2);
                  l1 = l2;
                  paramString.dZp.dZs = l2;
                  l1 = l2;
                  EventCenter.instance.publish(paramString);
                  if (localObject2 != null)
                  {
                    l1 = l2;
                    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(20308);
                        Log.i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s", new Object[] { Long.valueOf(this.iBP.field_msgId), Integer.valueOf(this.iBP.getType()) });
                        switch (this.iBP.getType())
                        {
                        }
                        for (;;)
                        {
                          AppMethodBeat.o(20308);
                          return;
                          bp.z(this.iBP);
                        }
                      }
                    });
                  }
                  l1 = l2;
                  if ((localException3.fqJ & 0x4) != 4)
                  {
                    l1 = l2;
                    localException3.setContent(paramMap);
                    l1 = l2;
                    localException3.setType(10000);
                    l1 = l2;
                    bp.a(localException3, parama);
                    l1 = l2;
                    bg.aVF();
                    l1 = l2;
                    c.aSQ().a(localException3.field_msgId, localException3);
                  }
                  l1 = l2;
                  ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.msgquote.a.class)).handleRevokeMsgBySvrId(l2);
                  if (localObject6 != null)
                  {
                    l1 = l2;
                    if (((bb)localObject6).field_unReadCount > 0)
                    {
                      l1 = l2;
                      bg.aVF();
                      l1 = l2;
                      i = c.aSQ().aB(localException3);
                      l1 = l2;
                      if (((bb)localObject6).field_unReadCount >= i)
                      {
                        l1 = l2;
                        ((az)localObject6).nt(((bb)localObject6).field_unReadCount - 1);
                        l1 = l2;
                        bg.aVF();
                        l1 = l2;
                        c.aST().a((az)localObject6, ((az)localObject6).getUsername());
                      }
                    }
                  }
                  l1 = l2;
                  if (aa.i((ca)localObject2))
                  {
                    l1 = l2;
                    paramString = new nv();
                    l1 = l2;
                    paramString.dTW.dTX = ((ca)localObject2);
                    l1 = l2;
                    EventCenter.instance.publish(paramString);
                  }
                }
              }
            }
            AppMethodBeat.o(20312);
            return null;
            localObject2 = ((com.tencent.mm.ak.h)localObject2).b(parama);
            continue;
            localException1 = localException1;
            Log.e("MicroMsg.BigBallSysCmdMsgConsumer", localException1.toString());
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.e("MicroMsg.BigBallSysCmdMsgConsumer", localException2.toString());
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void gt(String paramString);
  }
  
  public static abstract interface b
    extends com.tencent.mm.plugin.messenger.foundation.a.p
  {
    public abstract String getSubType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.f
 * JD-Core Version:    0.7.0.1
 */