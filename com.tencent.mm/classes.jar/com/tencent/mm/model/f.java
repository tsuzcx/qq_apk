package com.tencent.mm.model;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.ak.e.d;
import com.tencent.mm.api.r;
import com.tencent.mm.api.v;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
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
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.protocal.protobuf.cex;
import com.tencent.mm.protocal.protobuf.cey;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
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
  public a hHA;
  private final LinkedHashMap<String, b> hHB;
  private long hHz;
  
  public f()
  {
    AppMethodBeat.i(20310);
    this.hHz = -1L;
    this.hHB = new LinkedHashMap();
    h localh = new h();
    this.hHB.put(localh.getSubType(), localh);
    AppMethodBeat.o(20310);
  }
  
  private static String h(Object... paramVarArgs)
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
        ae.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramVarArgs, "", new Object[0]);
        AppMethodBeat.o(20315);
        return "";
      }
      int j = 0;
      continue;
      ae.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", new Object[] { localObject });
      AppMethodBeat.o(20315);
      return "";
      label236:
      paramVarArgs = bu.cH(MessageDigest.getInstance("MD5").digest(localByteArrayOutputStream.toByteArray()));
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
    //   7: ldc 141
    //   9: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifeq +70 -> 82
    //   15: new 147	java/util/zip/ZipFile
    //   18: dup
    //   19: invokestatic 153	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   22: invokevirtual 159	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   25: getfield 165	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   28: invokespecial 168	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   31: astore 9
    //   33: aload 9
    //   35: aload 9
    //   37: aload_0
    //   38: iconst_1
    //   39: invokevirtual 172	java/lang/String:substring	(I)Ljava/lang/String;
    //   42: invokevirtual 176	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   45: invokevirtual 180	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
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
    //   69: invokevirtual 186	java/io/InputStream:skip	(J)J
    //   72: lstore 6
    //   74: lload_1
    //   75: lload 6
    //   77: lsub
    //   78: lstore_1
    //   79: goto -26 -> 53
    //   82: aload_0
    //   83: invokestatic 192	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   86: astore 8
    //   88: aconst_null
    //   89: astore_0
    //   90: goto -37 -> 53
    //   93: aload_0
    //   94: astore 10
    //   96: aload 8
    //   98: astore 9
    //   100: ldc 116
    //   102: invokestatic 122	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
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
    //   139: ldc2_w 193
    //   142: lload_3
    //   143: invokestatic 200	java/lang/Math:min	(JJ)J
    //   146: l2i
    //   147: invokevirtual 204	java/io/InputStream:read	([BII)I
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
    //   172: invokevirtual 208	java/security/MessageDigest:update	([BII)V
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
    //   193: invokevirtual 210	java/security/MessageDigest:digest	()[B
    //   196: invokestatic 135	com/tencent/mm/sdk/platformtools/bu:cH	([B)Ljava/lang/String;
    //   199: astore 11
    //   201: aload 8
    //   203: ifnull +8 -> 211
    //   206: aload 8
    //   208: invokevirtual 213	java/io/InputStream:close	()V
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 214	java/util/zip/ZipFile:close	()V
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
    //   242: ldc 100
    //   244: aload 11
    //   246: ldc 102
    //   248: iconst_0
    //   249: anewarray 4	java/lang/Object
    //   252: invokestatic 108	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: aload 8
    //   257: ifnull +8 -> 265
    //   260: aload 8
    //   262: invokevirtual 213	java/io/InputStream:close	()V
    //   265: aload_0
    //   266: ifnull +7 -> 273
    //   269: aload_0
    //   270: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   273: sipush 20313
    //   276: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: ldc 102
    //   281: areturn
    //   282: astore_0
    //   283: aconst_null
    //   284: astore 10
    //   286: aconst_null
    //   287: astore 9
    //   289: aload 9
    //   291: ifnull +8 -> 299
    //   294: aload 9
    //   296: invokevirtual 213	java/io/InputStream:close	()V
    //   299: aload 10
    //   301: ifnull +8 -> 309
    //   304: aload 10
    //   306: invokevirtual 214	java/util/zip/ZipFile:close	()V
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
  
  /* Error */
  private static long zl(String paramString)
  {
    // Byte code:
    //   0: sipush 20314
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 141
    //   9: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifeq +131 -> 143
    //   15: new 147	java/util/zip/ZipFile
    //   18: dup
    //   19: invokestatic 153	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   22: invokevirtual 159	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   25: getfield 165	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   28: invokespecial 168	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: aload 4
    //   38: aload_0
    //   39: iconst_1
    //   40: invokevirtual 172	java/lang/String:substring	(I)Ljava/lang/String;
    //   43: invokevirtual 176	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnonnull +18 -> 66
    //   51: aload 4
    //   53: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   56: sipush 20314
    //   59: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: ldc2_w 36
    //   65: lreturn
    //   66: aload 4
    //   68: astore_3
    //   69: aload_0
    //   70: invokevirtual 221	java/util/zip/ZipEntry:getSize	()J
    //   73: lstore_1
    //   74: aload 4
    //   76: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   79: sipush 20314
    //   82: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: lload_1
    //   86: lreturn
    //   87: astore 5
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: astore_3
    //   93: ldc 100
    //   95: aload 5
    //   97: ldc 102
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 108	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: ifnull +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 214	java/util/zip/ZipFile:close	()V
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
    //   132: invokevirtual 214	java/util/zip/ZipFile:close	()V
    //   135: sipush 20314
    //   138: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_0
    //   142: athrow
    //   143: aload_0
    //   144: invokestatic 224	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
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
  
  public final e.b a(String paramString, final Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(20312);
    localObject7 = parama.gte;
    localObject6 = z.a(((cv)localObject7).FNI);
    Object localObject3 = null;
    if (paramString != null)
    {
      Object localObject1 = (b)this.hHB.get(paramString);
      if (localObject1 != null) {
        try
        {
          localObject1 = ((b)localObject1).a(paramString, paramMap, parama);
          AppMethodBeat.o(20312);
          return localObject1;
        }
        catch (Throwable localThrowable)
        {
          ae.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", localThrowable, "consumeNewXml dispatch handle subType [%s] error", new Object[] { paramString });
        }
      }
    }
    localObject2 = localObject3;
    if (paramString != null)
    {
      localObject2 = localObject3;
      if (paramString.equals("addcontact"))
      {
        ((cv)localObject7).FNI = z.Jw((String)paramMap.get(".sysmsg.addcontact.content"));
        ((cv)localObject7).urJ = 1;
        localObject2 = e.d.ca(Integer.valueOf(1));
        if (localObject2 != null) {
          break label1130;
        }
        localObject2 = null;
      }
    }
    for (;;)
    {
      if ((paramString != null) && (paramString.equals("dynacfg")))
      {
        com.tencent.mm.n.g.acL().a((String)localObject6, paramMap, false);
        com.tencent.mm.n.g.acM();
        if (com.tencent.mm.n.c.acx() == 2) {
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10879, "");
        }
        i = bu.getInt(com.tencent.mm.n.g.acL().getValue("MuteRoomDisable"), 0);
        ae.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(i));
      }
      if ((paramString != null) && (paramString.equals("dynacfg_split"))) {
        com.tencent.mm.n.g.acL().a((String)localObject6, paramMap, true);
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
        bk.aCm().a(new bj(bu.getInt((String)localObject3, 0), bu.getInt((String)localObject8, 0), (String)localObject9));
        localObject3 = (String)paramMap.get(".sysmsg.friendrecommand.fromuser");
        localObject8 = (String)paramMap.get(".sysmsg.friendrecommand.touser");
        if ((localObject3 == null) || (localObject8 == null)) {}
      }
      catch (Exception localException1)
      {
        try
        {
          bc.aCg().aAe().a((String)localObject8, true, null);
          localObject3 = (String)paramMap.get(".sysmsg.banner.securitybanner.chatname");
          localObject8 = (String)paramMap.get(".sysmsg.banner.securitybanner.wording");
          localObject9 = (String)paramMap.get(".sysmsg.banner.securitybanner.linkname");
          localObject10 = (String)paramMap.get(".sysmsg.banner.securitybanner.linksrc");
          localObject11 = (String)paramMap.get(".sysmsg.banner.securitybanner.showtype");
          if ((!bu.isNullOrNil((String)localObject3)) && (!bu.isNullOrNil((String)localObject11))) {}
          try
          {
            if (!((String)localObject11).equals("1")) {
              break label7332;
            }
            bool1 = true;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              ae.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + localException3.toString());
              continue;
              long l1 = l2;
              ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and has done delete info, originSvrId[%d]", new Object[] { Long.valueOf(l2) });
              l1 = l2;
              com.tencent.mm.modelmulti.p.aJR();
              l1 = l2;
              com.tencent.mm.modelmulti.p.aJP().delete((com.tencent.mm.sdk.e.c)localObject9, true, new String[0]);
              if (localObject6 != null)
              {
                l1 = l2;
                if (parama.gte != null)
                {
                  l1 = l2;
                  if (((ba)localObject6).field_lastSeq == parama.gte.FNN)
                  {
                    l1 = l2;
                    ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", new Object[] { Long.valueOf(((ba)localObject6).field_lastSeq), Long.valueOf(((ba)localObject6).field_firstUnDeliverSeq) });
                    l1 = l2;
                    bc.aCg();
                    l1 = l2;
                    localObject7 = c.azI().are(((ba)localObject6).field_username);
                    if (localObject7 != null)
                    {
                      l1 = l2;
                      ((au)localObject6).qJ(((ei)localObject7).field_msgSeq);
                      l1 = l2;
                      bc.aCg();
                      l1 = l2;
                      i = c.azL().a((au)localObject6, ((ba)localObject6).field_username);
                      l1 = l2;
                      ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", new Object[] { Long.valueOf(((ei)localObject7).field_msgSvrId), Long.valueOf(((ei)localObject7).field_msgSeq), Long.valueOf(((ba)localObject6).field_lastSeq), Long.valueOf(((ba)localObject6).field_firstUnDeliverSeq), Integer.valueOf(i) });
                    }
                  }
                }
              }
              l1 = l2;
              if (paramMap.field_msgId == 0L)
              {
                l1 = l2;
                if (((PluginPatMsg)com.tencent.mm.kernel.g.ad(PluginPatMsg.class)).getRecvRecord(l2) != null)
                {
                  l1 = l2;
                  ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).bb((String)localObject2, l2);
                  continue;
                }
              }
              int j;
              if ((paramString != null) && (paramString.equals("clouddelmsg")))
              {
                ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
                localObject4 = (String)paramMap.get(".sysmsg.clouddelmsg.delcommand");
                localObject2 = (String)paramMap.get(".sysmsg.clouddelmsg.msgid");
                paramMap = (String)paramMap.get(".sysmsg.clouddelmsg.fromuser");
                i = ((String)localObject6).indexOf("<msg>");
                j = ((String)localObject6).indexOf("</msg>");
                if ((i == -1) || (j == -1))
                {
                  paramString = "";
                  ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", new Object[] { localObject4, localObject2, paramMap, paramString });
                }
                for (;;)
                {
                  try
                  {
                    bc.aCg();
                    paramMap = c.azI().ia(paramMap, (String)localObject2);
                    if ((paramMap == null) || (paramMap.size() <= 0))
                    {
                      ae.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
                      AppMethodBeat.o(20312);
                      return null;
                      paramString = com.tencent.mm.sdk.platformtools.bk.bO(bx.M(((String)localObject6).substring(i, j + 6), "msg"));
                      break;
                    }
                    paramMap = paramMap.iterator();
                    if (paramMap.hasNext())
                    {
                      localObject7 = (bv)paramMap.next();
                      if (localObject7 != null) {
                        break label2277;
                      }
                      ae.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
                    }
                    if (((ei)localObject7).field_msgSvrId >= 0L) {
                      break label2324;
                    }
                  }
                  catch (Exception paramString)
                  {
                    ae.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", new Object[] { localObject2, paramString.toString() });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  ae.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((bv)localObject7).VX()), Long.valueOf(((bv)localObject7).VY()) });
                }
                ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((bv)localObject7).VX()), Long.valueOf(((bv)localObject7).VY()) });
                localObject6 = bv.aM((bv)localObject7);
                i = bu.getInt((String)localObject4, 0);
                if (i == 1)
                {
                  bc.aCg();
                  c.azI().aT(((bv)localObject7).Wa(), ((bv)localObject7).VY());
                }
                for (;;)
                {
                  localObject8 = new sa();
                  ((sa)localObject8).dHE.msgId = ((bv)localObject7).VX();
                  ((sa)localObject8).dHE.dHF = paramString;
                  ((sa)localObject8).dHE.dCi = ((bv)localObject7);
                  com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject8);
                  if (!aa.i((bv)localObject6)) {
                    break;
                  }
                  localObject7 = new ne();
                  ((ne)localObject7).dCh.dCi = ((bv)localObject6);
                  com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject7);
                  break;
                  if ((i == 2) && (((bv)localObject7).fta()))
                  {
                    ((bv)localObject7).setContent(paramString);
                    bl.a((bv)localObject7, parama);
                    bc.aCg();
                    c.azI().b(((bv)localObject7).VY(), (bv)localObject7);
                    bc.aCg();
                    localObject8 = c.azL().aVa(((bv)localObject7).Wa());
                    if ((localObject8 != null) && (((au)localObject8).VS() > 0))
                    {
                      bc.aCg();
                      i = c.azI().aq((bv)localObject7);
                      if (((au)localObject8).VS() >= i)
                      {
                        ((au)localObject8).kr(((au)localObject8).VS() - 1);
                        bc.aCg();
                        c.azL().a((au)localObject8, ((au)localObject8).getUsername());
                      }
                    }
                  }
                }
              }
              if ((paramString != null) && (paramString.equals("updatepackage")))
              {
                localObject2 = e.d.ca(Integer.valueOf(-1879048175));
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
                      localObject2 = e.d.ca(Integer.valueOf(-1879048174));
                      if (localObject2 != null) {
                        break label3422;
                      }
                      localObject2 = null;
                    }
                  }
                  String[] arrayOfString;
                  if ((paramString != null) && (paramString.equals("delchatroommember")))
                  {
                    localObject4 = z.a(((cv)localObject7).FNG);
                    bc.aCg();
                    localObject8 = c.azI().aJ((String)localObject4, ((cv)localObject7).xrk);
                    i = 0;
                    if (((bv)localObject8).VX() > 0L) {
                      i = 1;
                    }
                    ((bv)localObject8).qM(((cv)localObject7).xrk);
                    if ((parama == null) || (!parama.hQN) || (!parama.hQP)) {
                      ((bv)localObject8).qN(bl.B((String)localObject4, ((cv)localObject7).CreateTime));
                    }
                    ((bv)localObject8).setType(10002);
                    ((bv)localObject8).setContent((String)localObject6);
                    ((bv)localObject8).kt(0);
                    ((bv)localObject8).ui((String)localObject4);
                    ((bv)localObject8).tk(((cv)localObject7).FNL);
                    bl.a((bv)localObject8, parama);
                    if (i == 0) {
                      bl.v((bv)localObject8);
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
                        if (this.hHz != ((cv)localObject7).xrk)
                        {
                          this.hHz = ((cv)localObject7).xrk;
                          ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                          localObject2 = new cm(paramMap);
                          localObject4 = (String)((cm)localObject2).hFw.get(".sysmsg.WakenPush.PushContent");
                          localObject6 = (String)((cm)localObject2).hFw.get(".sysmsg.WakenPush.Jump");
                          localObject9 = (String)((cm)localObject2).hFw.get(".sysmsg.WakenPush.ExpiredTime");
                          localObject8 = (String)((cm)localObject2).hFw.get(".sysmsg.WakenPush.Username");
                          ae.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", new Object[] { localObject4, localObject6, localObject9 });
                          localObject9 = com.tencent.mm.n.g.acL().getValue("WakenPushDeepLinkBitSet");
                          ae.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", new Object[] { localObject9 });
                          if (bu.isNullOrNil((String)localObject9)) {
                            break label3457;
                          }
                          l1 = bu.getLong((String)localObject9, 0L);
                          localObject9 = com.tencent.mm.aj.c.a((String)localObject8, false, -1, null);
                          localObject2 = bc.getNotification().a(((cm)localObject2).E((String)localObject6, l1), ak.getContext().getString(2131755822), (String)localObject4, (String)localObject4, (Bitmap)localObject9, (String)localObject8);
                          ((Notification)localObject2).flags |= 0x10;
                          bc.getNotification().a((Notification)localObject2, false);
                          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 31L, 1L, true);
                          localObject4 = null;
                        }
                      }
                    }
                    localObject2 = localObject4;
                    if (paramString == null) {
                      break label3635;
                    }
                    localObject2 = localObject4;
                    if (!paramString.equals("DisasterNotice")) {
                      break label3635;
                    }
                    localObject8 = (String)paramMap.get(".sysmsg.NoticeId");
                    localObject9 = (String)paramMap.get(".sysmsg.Content");
                    ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", new Object[] { localObject8, localObject9 });
                    localObject10 = ak.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.g.abv());
                    localObject6 = ((SharedPreferences)localObject10).getString("disaster_noticeid_list_key", "");
                    if (((String)localObject6).contains((CharSequence)localObject8)) {
                      break label3578;
                    }
                    localObject11 = ((String)localObject6).split(";");
                    if ((localObject11 == null) || (localObject11.length <= 10)) {
                      break label3489;
                    }
                    localObject2 = "";
                    j = localObject11.length;
                    i = 0;
                    localObject4 = localObject2;
                    if (i >= j) {
                      break label3493;
                    }
                    arrayOfString = localObject11[i].split(",");
                    localObject4 = localObject2;
                  }
                  try
                  {
                    if (bu.rZ(bu.getLong(arrayOfString[0], 0L)) < 1296000L) {
                      localObject4 = (String)localObject2 + arrayOfString[0] + "," + arrayOfString[1] + ";";
                    }
                    i += 1;
                    localObject2 = localObject4;
                    break label3307;
                    localObject4 = ((com.tencent.mm.ak.e)localObject2).b(parama);
                    continue;
                    localObject2 = ((com.tencent.mm.ak.e)localObject2).b(parama);
                    break label2703;
                    bc.aCg();
                    c.azI().b(((cv)localObject7).xrk, (bv)localObject8);
                    break label2863;
                    l1 = 0L;
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      ae.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", new Object[] { localException4 });
                      localObject5 = localObject2;
                    }
                  }
                }
                localObject5 = localObject6;
                localObject2 = (String)localObject5 + bu.aRi() + "," + (String)localObject8 + ";";
                ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", new Object[] { localObject6, localObject2 });
                ((SharedPreferences)localObject10).edit().putString("disaster_noticeid_list_key", (String)localObject2).commit();
                new aq(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(20306);
                    if (f.this.hHA != null) {
                      f.this.hHA.fH(this.hHC);
                    }
                    AppMethodBeat.o(20306);
                  }
                });
                ((cv)localObject7).FNI = z.Jw((String)localObject9);
                ((cv)localObject7).urJ = 1;
                localObject2 = e.d.ca(Integer.valueOf(1));
                if (localObject2 == null)
                {
                  localObject2 = null;
                  if ((paramString == null) || (!paramString.equals("EmotionKv"))) {
                    break label4183;
                  }
                  paramString = (String)paramMap.get(".sysmsg.EmotionKv.K");
                  localObject2 = (String)paramMap.get(".sysmsg.EmotionKv.I");
                  if (paramString != null) {
                    break label7322;
                  }
                  paramString = "";
                }
                for (;;)
                {
                  ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", new Object[] { Integer.valueOf(paramString.length()), paramString, localObject2 });
                  localObject5 = ac.fkn().FHi.getBytes();
                  localObject6 = ac.fkn().FHj.getBytes();
                  paramMap = null;
                  try
                  {
                    parama = bc.ajj().ajn().aFs().aFn();
                    paramMap = parama;
                  }
                  catch (Exception parama)
                  {
                    for (;;)
                    {
                      ae.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", new Object[] { bu.o(parama) });
                    }
                    localObject7 = com.tencent.mm.protocal.f.fjZ();
                    if (!bu.cF((byte[])localObject7)) {
                      break label3845;
                    }
                    ae.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  newECDH  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                    parama = new PByteArray();
                    if (bu.isNullOrNil(paramString)) {
                      break label3891;
                    }
                  }
                  if (bu.cF(paramMap))
                  {
                    ae.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                    localObject2 = ((com.tencent.mm.ak.e)localObject2).b(parama);
                    break;
                  }
                  int k;
                  int m;
                  int n;
                  if ((bu.cF((byte[])localObject6)) || (bu.cF((byte[])localObject5)) || (bu.cF(paramMap)) || (bu.cF((byte[])localObject7))) {
                    if (paramString == null)
                    {
                      i = -1;
                      if (localObject6 != null) {
                        break label4114;
                      }
                      j = -1;
                      if (localObject5 != null) {
                        break label4122;
                      }
                      k = -1;
                      if (paramMap != null) {
                        break label4130;
                      }
                      m = -1;
                      if (localObject7 != null) {
                        break label4137;
                      }
                      n = -1;
                      ae.w("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d newECDH:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
                      paramString = parama.value;
                      paramMap = new btj();
                      if (parama.value == null) {
                        break label4167;
                      }
                      paramMap.yxn = new String(parama.value);
                      if (paramString != null) {
                        break label4176;
                      }
                    }
                  }
                  for (i = -1;; i = paramString.length)
                  {
                    ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv res len:%d val len:%d, content[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramMap.yxn.length()), com.tencent.mm.b.g.getMessageDigest(paramMap.yxn.getBytes()) });
                    paramMap.HgJ = ((String)localObject2);
                    bc.aCg();
                    c.azE().d(new k.a(59, paramMap));
                    AppMethodBeat.o(20312);
                    return null;
                    i = paramString.length();
                    break;
                    j = localObject6.length;
                    break label3906;
                    k = localObject5.length;
                    break label3914;
                    m = paramMap.length;
                    break label3921;
                    n = localObject7.length;
                    break label3929;
                    bc.aCg();
                    MMProtocalJni.genClientCheckKVRes(c.getUin(), paramString, (byte[])localObject5, (byte[])localObject6, paramMap, (byte[])localObject7, parama);
                    break label3981;
                    paramMap.yxn = "";
                    break label4016;
                  }
                  if ((paramString != null) && (paramString.equals("globalalert")))
                  {
                    paramString = (String)paramMap.get(".sysmsg.uuid");
                    i = bu.getInt((String)paramMap.get(".sysmsg.id"), -1);
                    j = bu.getInt((String)paramMap.get(".sysmsg.important"), -1);
                    if ((bu.isNullOrNil(paramString)) || (i < 0) || (j < 0))
                    {
                      ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    parama = (String)paramMap.get(".sysmsg.title");
                    localObject2 = (String)paramMap.get(".sysmsg.msg");
                    if ((bu.isNullOrNil(parama)) && (bu.isNullOrNil((String)localObject2)))
                    {
                      ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", new Object[] { parama, localObject2 });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject6 = (String)paramMap.get(".sysmsg.btnlist.btn.$title");
                    k = bu.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$id"), -1);
                    m = bu.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                    localObject7 = (String)paramMap.get(".sysmsg.btnlist.btn");
                    if ((bu.isNullOrNil((String)localObject6)) || (k < 0) || (m < 0))
                    {
                      ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", new Object[] { localObject6, Integer.valueOf(k), Integer.valueOf(m) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject5 = (String)paramMap.get(".sysmsg.btnlist.btn1.$title");
                    n = bu.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$id"), -1);
                    int i1 = bu.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                    paramMap = (String)paramMap.get(".sysmsg.btnlist.btn1");
                    bool1 = true;
                    if ((bu.isNullOrNil((String)localObject5)) || (n < 0) || (i1 < 0))
                    {
                      bool1 = false;
                      ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", new Object[] { localObject6, Integer.valueOf(k), Integer.valueOf(m) });
                    }
                    localObject8 = new jv();
                    localObject9 = new com.tencent.mm.protocal.b.a.b();
                    ((jv)localObject8).dxP.dxQ = ((com.tencent.mm.protocal.b.a.b)localObject9);
                    ((com.tencent.mm.protocal.b.a.b)localObject9).id = i;
                    ((com.tencent.mm.protocal.b.a.b)localObject9).title = parama;
                    ((com.tencent.mm.protocal.b.a.b)localObject9).msg = ((String)localObject2);
                    ((com.tencent.mm.protocal.b.a.b)localObject9).FIc = new LinkedList();
                    localObject10 = new com.tencent.mm.protocal.b.a.a();
                    ((com.tencent.mm.protocal.b.a.a)localObject10).id = k;
                    ((com.tencent.mm.protocal.b.a.a)localObject10).actionType = m;
                    ((com.tencent.mm.protocal.b.a.a)localObject10).FIa = ((String)localObject6);
                    ((com.tencent.mm.protocal.b.a.a)localObject10).FIb = ((String)localObject7);
                    ((com.tencent.mm.protocal.b.a.b)localObject9).FIc.add(localObject10);
                    if (bool1)
                    {
                      localObject6 = new com.tencent.mm.protocal.b.a.a();
                      ((com.tencent.mm.protocal.b.a.a)localObject6).id = n;
                      ((com.tencent.mm.protocal.b.a.a)localObject6).actionType = i1;
                      ((com.tencent.mm.protocal.b.a.a)localObject6).FIa = ((String)localObject5);
                      ((com.tencent.mm.protocal.b.a.a)localObject6).FIb = paramMap;
                      ((com.tencent.mm.protocal.b.a.b)localObject9).FIc.add(localObject6);
                    }
                    ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), parama, localObject2, Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject8)) });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  if ((paramString != null) && (paramString.equals("yybsigcheck")))
                  {
                    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 14L, 1L, false);
                    l1 = System.currentTimeMillis();
                    paramString = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                    parama = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.wording");
                    paramMap = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.url");
                    ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", new Object[] { paramString, parama, paramMap });
                    com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4014), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    if (bu.isNullOrNil(paramString))
                    {
                      ae.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 15L, 1L, false);
                      com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4015), String.format("%s|%s", new Object[] { parama, paramMap }) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject2 = paramString.split(";");
                    if (localObject2 == null) {}
                    for (i = -1;; i = localObject2.length)
                    {
                      ae.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStrs len is %d", new Object[] { Integer.valueOf(i) });
                      if ((localObject2 != null) && (localObject2.length != 0)) {
                        break;
                      }
                      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 16L, 1L, false);
                      com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4016), paramString });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject5 = new ArrayList();
                    i = 0;
                    if (i < localObject2.length)
                    {
                      localObject6 = localObject2[i];
                      if (bu.isNullOrNil((String)localObject6)) {
                        ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", new Object[] { Integer.valueOf(i) });
                      }
                      for (;;)
                      {
                        i += 1;
                        break;
                        localObject7 = ((String)localObject6).split(",");
                        if (localObject7 == null) {}
                        for (j = -1;; j = localObject7.length)
                        {
                          ae.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is %d", new Object[] { Integer.valueOf(j) });
                          if ((localObject7 != null) && (localObject7.length == 3)) {
                            break label5322;
                          }
                          ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", new Object[] { Integer.valueOf(i) });
                          break;
                        }
                        try
                        {
                          ((ArrayList)localObject5).add(new ag.c(localObject7[0], bu.getInt(localObject7[1], 0), localObject7[2]));
                        }
                        catch (Exception localException5)
                        {
                          ae.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", new Object[] { Integer.valueOf(i), localException5.getMessage() });
                          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 17L, 1L, false);
                          com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4017), localObject6 });
                        }
                      }
                    }
                    if (((ArrayList)localObject5).size() == 0)
                    {
                      ae.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 18L, 1L, false);
                      com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4018), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    if (bu.getInt(com.tencent.mm.n.g.acL().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)
                    {
                      bool1 = true;
                      boolean bool2 = com.tencent.mm.platformtools.ag.a(ak.getContext(), (ArrayList)localObject5, bool1);
                      ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", new Object[] { Integer.valueOf(((ArrayList)localObject5).size()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l1) });
                      if (bool2) {
                        break label5720;
                      }
                      bc.aCe().setInt(46, 4);
                      localObject2 = new kq();
                      ((kq)localObject2).dyH.dyI = parama;
                      ((kq)localObject2).dyH.url = paramMap;
                      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
                      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 20L, 1L, true);
                      com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4020), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(20312);
                      return null;
                      bool1 = false;
                      break;
                      bc.aCe().setInt(46, 0);
                      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(322L, 19L, 1L, true);
                      com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(4019), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    }
                  }
                  if ((paramString != null) && (paramString.equals("qy_status_notify")))
                  {
                    parama = (String)paramMap.get(".sysmsg.chat_id");
                    paramMap.get(".sysmsg.last_create_time");
                    paramString = (String)paramMap.get(".sysmsg.brand_username");
                    l1 = com.tencent.mm.al.a.e.EY(parama);
                    if (l1 == -1L)
                    {
                      ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", new Object[] { parama });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    i = com.tencent.mm.al.ag.aGs().sf(l1).field_newUnReadCount;
                    com.tencent.mm.al.ag.aGs().sh(l1);
                    paramMap = com.tencent.mm.al.ag.aGr().bd(l1);
                    bc.aCg();
                    parama = c.azL().aVa(paramString);
                    if (parama == null)
                    {
                      ae.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", new Object[] { paramString });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    if (paramMap.hk(1))
                    {
                      if (parama.VT() <= i)
                      {
                        parama.kx(0);
                        bc.aCg();
                        c.azL().a(parama, paramString);
                        bc.getNotification().cancelNotification(paramString);
                      }
                      for (;;)
                      {
                        AppMethodBeat.o(20312);
                        return null;
                        parama.kx(parama.VT() - i);
                        bc.aCg();
                        c.azL().a(parama, paramString);
                      }
                    }
                    if (parama.VS() <= i)
                    {
                      bc.aCg();
                      c.azL().aVc(paramString);
                      bc.getNotification().cancelNotification(paramString);
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(20312);
                      return null;
                      parama.kw(0);
                      parama.kz(0);
                      parama.kr(parama.VS() - i);
                      bc.aCg();
                      c.azL().a(parama, paramString);
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
                    i = bu.getInt((String)paramMap.get(".sysmsg.bindmobiletip.forcebind"), 0);
                    parama = bu.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.deviceid"));
                    paramString = bu.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.wording"));
                    paramMap = new String(Base64.decode(parama.getBytes(), 0));
                    parama = new String(com.tencent.mm.bw.b.cm(com.tencent.mm.compatible.deviceinfo.q.aaH().getBytes()).aaf(16).getBytes());
                    ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", new Object[] { Integer.valueOf(i), paramMap, parama, paramString });
                    if ((bu.isNullOrNil(paramMap)) || (paramMap.equals(parama)))
                    {
                      bc.aCg();
                      c.ajA().set(am.a.IMJ, Boolean.TRUE);
                      bc.aCg();
                      paramMap = c.ajA();
                      parama = am.a.IMK;
                      if (i != 1) {
                        break label6397;
                      }
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramMap.set(parama, Boolean.valueOf(bool1));
                      bc.aCg();
                      c.ajA().set(am.a.IML, paramString);
                      AppMethodBeat.o(20312);
                      return null;
                    }
                  }
                  if ((paramString != null) && (paramString.equals("ClientCheckConsistency")))
                  {
                    parama = new cew();
                    parama.Gof = ((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename"));
                    parama.HrE = bu.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                    parama.HrF = bu.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                    parama.Gdy = bu.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                    parama.HrG = k(parama.Gof, parama.HrE, parama.HrF);
                    parama.FileSize = ((int)zl(parama.Gof));
                    if (!com.tencent.mm.plugin.normsg.a.b.wJt.dxZ()) {
                      break label7269;
                    }
                    i = 1;
                  }
                  for (;;)
                  {
                    parama.HrH = i;
                    parama.GqB = ab.abf();
                    parama.HrI = h(new Object[] { parama.Gof, Integer.valueOf(parama.HrE), Integer.valueOf(parama.HrF), Integer.valueOf(parama.Gdy), parama.HrG, Integer.valueOf(parama.FileSize), Integer.valueOf(parama.HrH), Integer.valueOf(parama.GqB) });
                    bc.aCg();
                    c.azE().d(new k.a(61, parama));
                    if ((paramString != null) && (paramString.equals("ClientCheckHook")))
                    {
                      parama = new cey();
                      parama.Gdy = bu.getInt((String)paramMap.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                      parama.HrK = com.tencent.mm.plugin.normsg.a.b.wJt.pq(false);
                      if (com.tencent.mm.plugin.normsg.a.b.wJt.dxZ())
                      {
                        i = 1;
                        parama.HrH = i;
                        parama.GqB = ab.abf();
                        parama.HrI = h(new Object[] { Integer.valueOf(parama.Gdy), parama.HrK, Integer.valueOf(parama.HrH), Integer.valueOf(parama.GqB) });
                        bc.aCg();
                        c.azE().d(new k.a(62, parama));
                      }
                    }
                    else
                    {
                      if ((paramString != null) && (paramString.equals("ClientCheckGetAppList")))
                      {
                        parama = new cex();
                        parama.Gdy = bu.getInt((String)paramMap.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                        parama.HrJ = com.tencent.mm.plugin.normsg.a.b.wJt.dxY();
                        if (!com.tencent.mm.plugin.normsg.a.b.wJt.dxZ()) {
                          break label7281;
                        }
                        i = 1;
                        parama.HrH = i;
                        parama.GqB = ab.abf();
                        parama.HrI = h(new Object[] { Integer.valueOf(parama.Gdy), parama.HrJ, Integer.valueOf(parama.HrH), Integer.valueOf(parama.GqB) });
                        bc.aCg();
                        c.azE().d(new k.a(63, parama));
                      }
                      if ((paramString != null) && (paramString.equals("ClientCheckGetExtInfo"))) {
                        com.tencent.mm.sdk.g.b.e(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(20307);
                            int i = bu.getInt((String)paramMap.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0);
                            if (bu.getInt((String)paramMap.get(".sysmsg.ClientCheckGetExtInfo.Basic"), 0) != 0)
                            {
                              com.tencent.mm.plugin.secinforeport.a.d.yRQ.hw(i, 0);
                              AppMethodBeat.o(20307);
                              return;
                            }
                            com.tencent.mm.plugin.secinforeport.a.d.yRQ.hw(i, 31);
                            AppMethodBeat.o(20307);
                          }
                        }, "syscmd_rpt_cc");
                      }
                      if ((!bu.isNullOrNil(paramString)) && (paramString.equals("functionmsg")))
                      {
                        ae.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                        ((v)com.tencent.mm.kernel.g.ad(v.class)).getReceiver().a(localException5, paramMap);
                      }
                      if ((!bu.isNullOrNil(paramString)) && (paramString.equals("paymsg")))
                      {
                        i = bu.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0);
                        localObject5 = (String)paramMap.get(".sysmsg.paymsg.appmsgcontent");
                        paramString = (String)paramMap.get(".sysmsg.paymsg.fromusername");
                        parama = (String)paramMap.get(".sysmsg.paymsg.tousername");
                        paramMap = (String)paramMap.get(".sysmsg.paymsg.paymsgid");
                        ae.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", new Object[] { Integer.valueOf(i), Long.valueOf(localException5.xrk), paramString, parama, paramMap, localObject5 });
                      }
                    }
                    try
                    {
                      localObject5 = URLDecoder.decode((String)localObject5, "UTF-8");
                      if (!bu.isNullOrNil((String)localObject5))
                      {
                        localObject6 = new pw();
                        ((pw)localObject6).dFr.type = i;
                        ((pw)localObject6).dFr.content = ((String)localObject5);
                        ((pw)localObject6).dFr.dzZ = paramString;
                        ((pw)localObject6).dFr.toUser = parama;
                        ((pw)localObject6).dFr.dFs = paramMap;
                        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject6);
                      }
                      AppMethodBeat.o(20312);
                      return localObject2;
                      i = 0;
                      continue;
                      i = 0;
                      break label6734;
                      i = 0;
                    }
                    catch (Exception paramString)
                    {
                      for (;;)
                      {
                        ae.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "", new Object[0]);
                        ae.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", new Object[] { paramString.getMessage() });
                      }
                    }
                  }
                }
              }
              boolean bool1 = false;
            }
          }
          bc.aCg().aAf().a((String)localObject3, bool1, new String[] { localObject8, localObject9, localObject10 });
          bc.aCg().aAg().A(paramMap);
          if ((!bu.isNullOrNil(paramString)) && (paramString.equals("midinfo")))
          {
            localObject3 = (String)paramMap.get(".sysmsg.midinfo.json_buffer");
            localObject8 = (String)paramMap.get(".sysmsg.midinfo.time_interval");
            ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", new Object[] { localObject8, localObject3, localObject6 });
            i = bu.getInt((String)localObject8, 0);
            if ((i > 86400L) && (i < 864000L))
            {
              bc.aCg();
              c.ajA().set(331777, Long.valueOf(bu.aRi() + i));
            }
            if (!bu.isNullOrNil((String)localObject3)) {
              com.tencent.mm.plugin.report.b.d.axQ((String)localObject3);
            }
          }
          if ((paramString != null) && (paramString.equals("revokemsg")))
          {
            ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
            localObject2 = (String)paramMap.get(".sysmsg.revokemsg.session");
            localObject3 = (String)paramMap.get(".sysmsg.revokemsg.newmsgid");
            paramString = (String)paramMap.get(".sysmsg.revokemsg.replacemsg");
            ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject3, paramString });
            l1 = 0L;
            try
            {
              l2 = bu.getLong((String)localObject3, 0L);
              l1 = l2;
              ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "xmlSrvMsgId=%d talker=%s isGet=%s", new Object[] { Long.valueOf(l2), localObject2, Boolean.valueOf(parama.hQN) });
              l1 = l2;
              paramMap = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aJ((String)localObject2, l2);
              l1 = l2;
              localObject3 = bv.aM(paramMap);
              l1 = l2;
              bc.aCg();
              l1 = l2;
              localObject6 = c.azL().aVa((String)localObject2);
              if (parama == null) {
                break label1474;
              }
              l1 = l2;
              if (!parama.hQN) {
                break label1474;
              }
              l1 = l2;
              localObject7 = parama.gte;
              l1 = l2;
              localObject8 = z.a(((cv)localObject7).FNI);
              l1 = l2;
              localObject9 = new bo();
              l1 = l2;
              ((bo)localObject9).field_originSvrId = l2;
              l1 = l2;
              if (paramMap.field_msgId != 0L) {
                break label1204;
              }
              l1 = l2;
              ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", new Object[] { Long.valueOf(l2) });
              l1 = l2;
              ((bo)localObject9).field_content = ((String)localObject8);
              l1 = l2;
              ((bo)localObject9).field_createTime = ((cv)localObject7).CreateTime;
              l1 = l2;
              ((bo)localObject9).field_flag = bl.d(parama);
              l1 = l2;
              ((bo)localObject9).field_fromUserName = z.a(((cv)localObject7).FNG);
              l1 = l2;
              ((bo)localObject9).field_toUserName = z.a(((cv)localObject7).FNH);
              l1 = l2;
              ((bo)localObject9).field_newMsgId = ((cv)localObject7).xrk;
              l1 = l2;
              com.tencent.mm.modelmulti.p.aJR();
              l1 = l2;
              ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr insert ret[%b], systemRowid[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelmulti.p.aJP().insert((com.tencent.mm.sdk.e.c)localObject9)), Long.valueOf(((bo)localObject9).systemRowid) });
            }
            catch (Exception paramString)
            {
              for (;;)
              {
                long l2;
                label1130:
                ae.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[oneliang][revokeMsg] msgId:%d,error:%s", new Object[] { Long.valueOf(l1), paramString.toString() });
                continue;
                l1 = l2;
                ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke newxml, but original msg has not been found, originSvrId[%d]", new Object[] { Long.valueOf(l2) });
                l1 = l2;
                bc.aCg();
                l1 = l2;
                c.azI().yw(l2);
                continue;
                l1 = l2;
                if (paramMap.getType() == 922746929)
                {
                  l1 = l2;
                  ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).bb((String)localObject2, l2);
                }
                else
                {
                  l1 = l2;
                  if ((paramMap.eNc & 0x4) != 4)
                  {
                    l1 = l2;
                    paramMap.setContent(paramString);
                    l1 = l2;
                    paramMap.setType(10000);
                    l1 = l2;
                    bl.a(paramMap, parama);
                    l1 = l2;
                    bc.aCg();
                    l1 = l2;
                    c.azI().a(paramMap.field_msgId, paramMap);
                  }
                  l1 = l2;
                  ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleRevokeMsgBySvrId(l2);
                  if (localObject6 != null)
                  {
                    l1 = l2;
                    if (((ba)localObject6).field_unReadCount > 0)
                    {
                      l1 = l2;
                      bc.aCg();
                      l1 = l2;
                      i = c.azI().aq(paramMap);
                      l1 = l2;
                      if (((ba)localObject6).field_unReadCount >= i)
                      {
                        l1 = l2;
                        ((au)localObject6).kr(((ba)localObject6).field_unReadCount - 1);
                        l1 = l2;
                        bc.aCg();
                        l1 = l2;
                        c.azL().a((au)localObject6, ((ba)localObject6).field_username);
                      }
                    }
                  }
                  l1 = l2;
                  if (aa.i(localException3))
                  {
                    l1 = l2;
                    parama = new ne();
                    l1 = l2;
                    parama.dCh.dCi = localException3;
                    l1 = l2;
                    com.tencent.mm.sdk.b.a.IvT.l(parama);
                  }
                  l1 = l2;
                  parama = new sa();
                  l1 = l2;
                  parama.dHE.msgId = paramMap.field_msgId;
                  l1 = l2;
                  parama.dHE.dHF = paramString;
                  l1 = l2;
                  parama.dHE.dCi = paramMap;
                  l1 = l2;
                  parama.dHE.dHG = localException3;
                  l1 = l2;
                  parama.dHE.dHH = l2;
                  l1 = l2;
                  com.tencent.mm.sdk.b.a.IvT.l(parama);
                  if (localException3 != null)
                  {
                    l1 = l2;
                    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(20308);
                        ae.i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s", new Object[] { Long.valueOf(localException3.field_msgId), Integer.valueOf(localException3.getType()) });
                        switch (localException3.getType())
                        {
                        }
                        for (;;)
                        {
                          AppMethodBeat.o(20308);
                          return;
                          bl.x(localException3);
                        }
                      }
                    });
                  }
                }
              }
            }
            AppMethodBeat.o(20312);
            return null;
            localObject2 = ((com.tencent.mm.ak.e)localObject2).b(parama);
            continue;
            localException1 = localException1;
            ae.e("MicroMsg.BigBallSysCmdMsgConsumer", localException1.toString());
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ae.e("MicroMsg.BigBallSysCmdMsgConsumer", localException2.toString());
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void fH(String paramString);
  }
  
  public static abstract interface b
    extends com.tencent.mm.plugin.messenger.foundation.a.p
  {
    public abstract String getSubType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.f
 * JD-Core Version:    0.7.0.1
 */