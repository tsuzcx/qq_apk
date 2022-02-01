package com.tencent.mm.model;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.d;
import com.tencent.mm.api.r;
import com.tencent.mm.api.v;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.g.a.rz;
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
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.protocal.protobuf.cec;
import com.tencent.mm.protocal.protobuf.ced;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
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
  private long hEH;
  public a hEI;
  private final LinkedHashMap<String, b> hEJ;
  
  public f()
  {
    AppMethodBeat.i(20310);
    this.hEH = -1L;
    this.hEJ = new LinkedHashMap();
    h localh = new h();
    this.hEJ.put(localh.getSubType(), localh);
    AppMethodBeat.o(20310);
  }
  
  private static String i(Object... paramVarArgs)
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
        ad.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramVarArgs, "", new Object[0]);
        AppMethodBeat.o(20315);
        return "";
      }
      int j = 0;
      continue;
      ad.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", new Object[] { localObject });
      AppMethodBeat.o(20315);
      return "";
      label236:
      paramVarArgs = bt.cE(MessageDigest.getInstance("MD5").digest(localByteArrayOutputStream.toByteArray()));
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
    //   7: ldc 140
    //   9: invokevirtual 144	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifeq +70 -> 82
    //   15: new 146	java/util/zip/ZipFile
    //   18: dup
    //   19: invokestatic 152	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   22: invokevirtual 158	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   25: getfield 164	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   28: invokespecial 167	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   31: astore 9
    //   33: aload 9
    //   35: aload 9
    //   37: aload_0
    //   38: iconst_1
    //   39: invokevirtual 171	java/lang/String:substring	(I)Ljava/lang/String;
    //   42: invokevirtual 175	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   45: invokevirtual 179	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
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
    //   69: invokevirtual 185	java/io/InputStream:skip	(J)J
    //   72: lstore 6
    //   74: lload_1
    //   75: lload 6
    //   77: lsub
    //   78: lstore_1
    //   79: goto -26 -> 53
    //   82: aload_0
    //   83: invokestatic 191	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   86: astore 8
    //   88: aconst_null
    //   89: astore_0
    //   90: goto -37 -> 53
    //   93: aload_0
    //   94: astore 10
    //   96: aload 8
    //   98: astore 9
    //   100: ldc 115
    //   102: invokestatic 121	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
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
    //   139: ldc2_w 192
    //   142: lload_3
    //   143: invokestatic 199	java/lang/Math:min	(JJ)J
    //   146: l2i
    //   147: invokevirtual 203	java/io/InputStream:read	([BII)I
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
    //   172: invokevirtual 207	java/security/MessageDigest:update	([BII)V
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
    //   193: invokevirtual 209	java/security/MessageDigest:digest	()[B
    //   196: invokestatic 134	com/tencent/mm/sdk/platformtools/bt:cE	([B)Ljava/lang/String;
    //   199: astore 11
    //   201: aload 8
    //   203: ifnull +8 -> 211
    //   206: aload 8
    //   208: invokevirtual 212	java/io/InputStream:close	()V
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 213	java/util/zip/ZipFile:close	()V
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
    //   242: ldc 99
    //   244: aload 11
    //   246: ldc 101
    //   248: iconst_0
    //   249: anewarray 4	java/lang/Object
    //   252: invokestatic 107	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: aload 8
    //   257: ifnull +8 -> 265
    //   260: aload 8
    //   262: invokevirtual 212	java/io/InputStream:close	()V
    //   265: aload_0
    //   266: ifnull +7 -> 273
    //   269: aload_0
    //   270: invokevirtual 213	java/util/zip/ZipFile:close	()V
    //   273: sipush 20313
    //   276: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: ldc 101
    //   281: areturn
    //   282: astore_0
    //   283: aconst_null
    //   284: astore 10
    //   286: aconst_null
    //   287: astore 9
    //   289: aload 9
    //   291: ifnull +8 -> 299
    //   294: aload 9
    //   296: invokevirtual 212	java/io/InputStream:close	()V
    //   299: aload 10
    //   301: ifnull +8 -> 309
    //   304: aload 10
    //   306: invokevirtual 213	java/util/zip/ZipFile:close	()V
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
  private static long yB(String paramString)
  {
    // Byte code:
    //   0: sipush 20314
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 140
    //   9: invokevirtual 144	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifeq +131 -> 143
    //   15: new 146	java/util/zip/ZipFile
    //   18: dup
    //   19: invokestatic 152	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   22: invokevirtual 158	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   25: getfield 164	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   28: invokespecial 167	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: aload 4
    //   38: aload_0
    //   39: iconst_1
    //   40: invokevirtual 171	java/lang/String:substring	(I)Ljava/lang/String;
    //   43: invokevirtual 175	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnonnull +18 -> 66
    //   51: aload 4
    //   53: invokevirtual 213	java/util/zip/ZipFile:close	()V
    //   56: sipush 20314
    //   59: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: ldc2_w 36
    //   65: lreturn
    //   66: aload 4
    //   68: astore_3
    //   69: aload_0
    //   70: invokevirtual 220	java/util/zip/ZipEntry:getSize	()J
    //   73: lstore_1
    //   74: aload 4
    //   76: invokevirtual 213	java/util/zip/ZipFile:close	()V
    //   79: sipush 20314
    //   82: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: lload_1
    //   86: lreturn
    //   87: astore 5
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: astore_3
    //   93: ldc 99
    //   95: aload 5
    //   97: ldc 101
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 107	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: ifnull +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 213	java/util/zip/ZipFile:close	()V
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
    //   132: invokevirtual 213	java/util/zip/ZipFile:close	()V
    //   135: sipush 20314
    //   138: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_0
    //   142: athrow
    //   143: aload_0
    //   144: invokestatic 223	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
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
    localObject7 = parama.gqE;
    localObject6 = z.a(((cv)localObject7).Fvk);
    Object localObject3 = null;
    if (paramString != null)
    {
      Object localObject1 = (b)this.hEJ.get(paramString);
      if (localObject1 != null) {
        try
        {
          localObject1 = ((b)localObject1).a(paramString, paramMap, parama);
          AppMethodBeat.o(20312);
          return localObject1;
        }
        catch (Throwable localThrowable)
        {
          ad.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", localThrowable, "consumeNewXml dispatch handle subType [%s] error", new Object[] { paramString });
        }
      }
    }
    localObject2 = localObject3;
    if (paramString != null)
    {
      localObject2 = localObject3;
      if (paramString.equals("addcontact"))
      {
        ((cv)localObject7).Fvk = z.IX((String)paramMap.get(".sysmsg.addcontact.content"));
        ((cv)localObject7).ugm = 1;
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
        com.tencent.mm.n.g.acA().a((String)localObject6, paramMap, false);
        com.tencent.mm.n.g.acB();
        if (com.tencent.mm.n.c.acm() == 2) {
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10879, "");
        }
        i = bt.getInt(com.tencent.mm.n.g.acA().getValue("MuteRoomDisable"), 0);
        ad.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(i));
      }
      if ((paramString != null) && (paramString.equals("dynacfg_split"))) {
        com.tencent.mm.n.g.acA().a((String)localObject6, paramMap, true);
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
        bi.aBW().a(new bh(bt.getInt((String)localObject3, 0), bt.getInt((String)localObject8, 0), (String)localObject9));
        localObject3 = (String)paramMap.get(".sysmsg.friendrecommand.fromuser");
        localObject8 = (String)paramMap.get(".sysmsg.friendrecommand.touser");
        if ((localObject3 == null) || (localObject8 == null)) {}
      }
      catch (Exception localException1)
      {
        try
        {
          ba.aBQ().azO().a((String)localObject8, true, null);
          localObject3 = (String)paramMap.get(".sysmsg.banner.securitybanner.chatname");
          localObject8 = (String)paramMap.get(".sysmsg.banner.securitybanner.wording");
          localObject9 = (String)paramMap.get(".sysmsg.banner.securitybanner.linkname");
          localObject10 = (String)paramMap.get(".sysmsg.banner.securitybanner.linksrc");
          localObject11 = (String)paramMap.get(".sysmsg.banner.securitybanner.showtype");
          if ((!bt.isNullOrNil((String)localObject3)) && (!bt.isNullOrNil((String)localObject11))) {}
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
              ad.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + localException3.toString());
              continue;
              long l1 = l2;
              ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and has done delete info, originSvrId[%d]", new Object[] { Long.valueOf(l2) });
              l1 = l2;
              com.tencent.mm.modelmulti.p.aJy();
              l1 = l2;
              com.tencent.mm.modelmulti.p.aJw().delete((com.tencent.mm.sdk.e.c)localObject9, true, new String[0]);
              if (localObject6 != null)
              {
                l1 = l2;
                if (parama.gqE != null)
                {
                  l1 = l2;
                  if (((com.tencent.mm.g.c.ba)localObject6).field_lastSeq == parama.gqE.Fvp)
                  {
                    l1 = l2;
                    ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", new Object[] { Long.valueOf(((com.tencent.mm.g.c.ba)localObject6).field_lastSeq), Long.valueOf(((com.tencent.mm.g.c.ba)localObject6).field_firstUnDeliverSeq) });
                    l1 = l2;
                    ba.aBQ();
                    l1 = l2;
                    localObject7 = c.azs().apZ(((com.tencent.mm.g.c.ba)localObject6).field_username);
                    if (localObject7 != null)
                    {
                      l1 = l2;
                      ((at)localObject6).qw(((ei)localObject7).field_msgSeq);
                      l1 = l2;
                      ba.aBQ();
                      l1 = l2;
                      i = c.azv().a((at)localObject6, ((com.tencent.mm.g.c.ba)localObject6).field_username);
                      l1 = l2;
                      ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", new Object[] { Long.valueOf(((ei)localObject7).field_msgSvrId), Long.valueOf(((ei)localObject7).field_msgSeq), Long.valueOf(((com.tencent.mm.g.c.ba)localObject6).field_lastSeq), Long.valueOf(((com.tencent.mm.g.c.ba)localObject6).field_firstUnDeliverSeq), Integer.valueOf(i) });
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
                  ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).ba((String)localObject2, l2);
                  continue;
                }
              }
              int j;
              if ((paramString != null) && (paramString.equals("clouddelmsg")))
              {
                ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
                localObject4 = (String)paramMap.get(".sysmsg.clouddelmsg.delcommand");
                localObject2 = (String)paramMap.get(".sysmsg.clouddelmsg.msgid");
                paramMap = (String)paramMap.get(".sysmsg.clouddelmsg.fromuser");
                i = ((String)localObject6).indexOf("<msg>");
                j = ((String)localObject6).indexOf("</msg>");
                if ((i == -1) || (j == -1))
                {
                  paramString = "";
                  ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", new Object[] { localObject4, localObject2, paramMap, paramString });
                }
                for (;;)
                {
                  try
                  {
                    ba.aBQ();
                    paramMap = c.azs().hT(paramMap, (String)localObject2);
                    if ((paramMap == null) || (paramMap.size() <= 0))
                    {
                      ad.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
                      AppMethodBeat.o(20312);
                      return null;
                      paramString = com.tencent.mm.sdk.platformtools.bj.bI(bw.M(((String)localObject6).substring(i, j + 6), "msg"));
                      break;
                    }
                    paramMap = paramMap.iterator();
                    if (paramMap.hasNext())
                    {
                      localObject7 = (bu)paramMap.next();
                      if (localObject7 != null) {
                        break label2277;
                      }
                      ad.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
                    }
                    if (((ei)localObject7).field_msgSvrId >= 0L) {
                      break label2324;
                    }
                  }
                  catch (Exception paramString)
                  {
                    ad.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", new Object[] { localObject2, paramString.toString() });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  ad.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((bu)localObject7).VP()), Long.valueOf(((bu)localObject7).VQ()) });
                }
                ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((bu)localObject7).VP()), Long.valueOf(((bu)localObject7).VQ()) });
                localObject6 = bu.aN((bu)localObject7);
                i = bt.getInt((String)localObject4, 0);
                if (i == 1)
                {
                  ba.aBQ();
                  c.azs().aS(((bu)localObject7).VS(), ((bu)localObject7).VQ());
                }
                for (;;)
                {
                  localObject8 = new rz();
                  ((rz)localObject8).dGy.msgId = ((bu)localObject7).VP();
                  ((rz)localObject8).dGy.dGz = paramString;
                  ((rz)localObject8).dGy.dBd = ((bu)localObject7);
                  com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject8);
                  if (!aa.i((bu)localObject6)) {
                    break;
                  }
                  localObject7 = new nd();
                  ((nd)localObject7).dBc.dBd = ((bu)localObject6);
                  com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject7);
                  break;
                  if ((i == 2) && (((bu)localObject7).fpd()))
                  {
                    ((bu)localObject7).setContent(paramString);
                    bj.a((bu)localObject7, parama);
                    ba.aBQ();
                    c.azs().b(((bu)localObject7).VQ(), (bu)localObject7);
                    ba.aBQ();
                    localObject8 = c.azv().aTz(((bu)localObject7).VS());
                    if ((localObject8 != null) && (((at)localObject8).VK() > 0))
                    {
                      ba.aBQ();
                      i = c.azs().ar((bu)localObject7);
                      if (((at)localObject8).VK() >= i)
                      {
                        ((at)localObject8).kp(((at)localObject8).VK() - 1);
                        ba.aBQ();
                        c.azv().a((at)localObject8, ((at)localObject8).getUsername());
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
                    localObject4 = z.a(((cv)localObject7).Fvi);
                    ba.aBQ();
                    localObject8 = c.azs().aI((String)localObject4, ((cv)localObject7).xbt);
                    i = 0;
                    if (((bu)localObject8).VP() > 0L) {
                      i = 1;
                    }
                    ((bu)localObject8).qz(((cv)localObject7).xbt);
                    if ((parama == null) || (!parama.hNU) || (!parama.hNW)) {
                      ((bu)localObject8).qA(bj.B((String)localObject4, ((cv)localObject7).CreateTime));
                    }
                    ((bu)localObject8).setType(10002);
                    ((bu)localObject8).setContent((String)localObject6);
                    ((bu)localObject8).kr(0);
                    ((bu)localObject8).tN((String)localObject4);
                    ((bu)localObject8).sP(((cv)localObject7).Fvn);
                    bj.a((bu)localObject8, parama);
                    if (i == 0) {
                      bj.v((bu)localObject8);
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
                        if (this.hEH != ((cv)localObject7).xbt)
                        {
                          this.hEH = ((cv)localObject7).xbt;
                          ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                          localObject2 = new ck(paramMap);
                          localObject4 = (String)((ck)localObject2).hCE.get(".sysmsg.WakenPush.PushContent");
                          localObject6 = (String)((ck)localObject2).hCE.get(".sysmsg.WakenPush.Jump");
                          localObject9 = (String)((ck)localObject2).hCE.get(".sysmsg.WakenPush.ExpiredTime");
                          localObject8 = (String)((ck)localObject2).hCE.get(".sysmsg.WakenPush.Username");
                          ad.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", new Object[] { localObject4, localObject6, localObject9 });
                          localObject9 = com.tencent.mm.n.g.acA().getValue("WakenPushDeepLinkBitSet");
                          ad.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", new Object[] { localObject9 });
                          if (bt.isNullOrNil((String)localObject9)) {
                            break label3457;
                          }
                          l1 = bt.getLong((String)localObject9, 0L);
                          localObject9 = com.tencent.mm.ak.c.a((String)localObject8, false, -1, null);
                          localObject2 = ba.getNotification().a(((ck)localObject2).E((String)localObject6, l1), aj.getContext().getString(2131755822), (String)localObject4, (String)localObject4, (Bitmap)localObject9, (String)localObject8);
                          ((Notification)localObject2).flags |= 0x10;
                          ba.getNotification().a((Notification)localObject2, false);
                          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 31L, 1L, true);
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
                    ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", new Object[] { localObject8, localObject9 });
                    localObject10 = aj.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.g.abm());
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
                    if (bt.rM(bt.getLong(arrayOfString[0], 0L)) < 1296000L) {
                      localObject4 = (String)localObject2 + arrayOfString[0] + "," + arrayOfString[1] + ";";
                    }
                    i += 1;
                    localObject2 = localObject4;
                    break label3307;
                    localObject4 = ((com.tencent.mm.al.e)localObject2).b(parama);
                    continue;
                    localObject2 = ((com.tencent.mm.al.e)localObject2).b(parama);
                    break label2703;
                    ba.aBQ();
                    c.azs().b(((cv)localObject7).xbt, (bu)localObject8);
                    break label2863;
                    l1 = 0L;
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      ad.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", new Object[] { localException4 });
                      localObject5 = localObject2;
                    }
                  }
                }
                localObject5 = localObject6;
                localObject2 = (String)localObject5 + bt.aQJ() + "," + (String)localObject8 + ";";
                ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", new Object[] { localObject6, localObject2 });
                ((SharedPreferences)localObject10).edit().putString("disaster_noticeid_list_key", (String)localObject2).commit();
                new ap(Looper.getMainLooper()).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(20306);
                    if (f.this.hEI != null) {
                      f.this.hEI.fB(this.hEK);
                    }
                    AppMethodBeat.o(20306);
                  }
                });
                ((cv)localObject7).Fvk = z.IX((String)localObject9);
                ((cv)localObject7).ugm = 1;
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
                  ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", new Object[] { Integer.valueOf(paramString.length()), paramString, localObject2 });
                  localObject5 = ac.fgx().FoK.getBytes();
                  localObject6 = ac.fgx().FoL.getBytes();
                  paramMap = null;
                  try
                  {
                    parama = ba.aiU().aiY().aFc().aEX();
                    paramMap = parama;
                  }
                  catch (Exception parama)
                  {
                    for (;;)
                    {
                      ad.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", new Object[] { bt.n(parama) });
                    }
                    localObject7 = com.tencent.mm.protocal.f.fgj();
                    if (!bt.cC((byte[])localObject7)) {
                      break label3845;
                    }
                    ad.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  newECDH  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                    parama = new PByteArray();
                    if (bt.isNullOrNil(paramString)) {
                      break label3891;
                    }
                  }
                  if (bt.cC(paramMap))
                  {
                    ad.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                    AppMethodBeat.o(20312);
                    return null;
                    localObject2 = ((com.tencent.mm.al.e)localObject2).b(parama);
                    break;
                  }
                  int k;
                  int m;
                  int n;
                  if ((bt.cC((byte[])localObject6)) || (bt.cC((byte[])localObject5)) || (bt.cC(paramMap)) || (bt.cC((byte[])localObject7))) {
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
                      ad.w("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d newECDH:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
                      paramString = parama.value;
                      paramMap = new bsp();
                      if (parama.value == null) {
                        break label4167;
                      }
                      paramMap.yhw = new String(parama.value);
                      if (paramString != null) {
                        break label4176;
                      }
                    }
                  }
                  for (i = -1;; i = paramString.length)
                  {
                    ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv res len:%d val len:%d, content[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramMap.yhw.length()), com.tencent.mm.b.g.getMessageDigest(paramMap.yhw.getBytes()) });
                    paramMap.GNj = ((String)localObject2);
                    ba.aBQ();
                    c.azo().c(new k.a(59, paramMap));
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
                    ba.aBQ();
                    MMProtocalJni.genClientCheckKVRes(c.getUin(), paramString, (byte[])localObject5, (byte[])localObject6, paramMap, (byte[])localObject7, parama);
                    break label3981;
                    paramMap.yhw = "";
                    break label4016;
                  }
                  if ((paramString != null) && (paramString.equals("globalalert")))
                  {
                    paramString = (String)paramMap.get(".sysmsg.uuid");
                    i = bt.getInt((String)paramMap.get(".sysmsg.id"), -1);
                    j = bt.getInt((String)paramMap.get(".sysmsg.important"), -1);
                    if ((bt.isNullOrNil(paramString)) || (i < 0) || (j < 0))
                    {
                      ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    parama = (String)paramMap.get(".sysmsg.title");
                    localObject2 = (String)paramMap.get(".sysmsg.msg");
                    if ((bt.isNullOrNil(parama)) && (bt.isNullOrNil((String)localObject2)))
                    {
                      ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", new Object[] { parama, localObject2 });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject6 = (String)paramMap.get(".sysmsg.btnlist.btn.$title");
                    k = bt.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$id"), -1);
                    m = bt.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                    localObject7 = (String)paramMap.get(".sysmsg.btnlist.btn");
                    if ((bt.isNullOrNil((String)localObject6)) || (k < 0) || (m < 0))
                    {
                      ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", new Object[] { localObject6, Integer.valueOf(k), Integer.valueOf(m) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject5 = (String)paramMap.get(".sysmsg.btnlist.btn1.$title");
                    n = bt.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$id"), -1);
                    int i1 = bt.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                    paramMap = (String)paramMap.get(".sysmsg.btnlist.btn1");
                    bool1 = true;
                    if ((bt.isNullOrNil((String)localObject5)) || (n < 0) || (i1 < 0))
                    {
                      bool1 = false;
                      ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", new Object[] { localObject6, Integer.valueOf(k), Integer.valueOf(m) });
                    }
                    localObject8 = new ju();
                    localObject9 = new com.tencent.mm.protocal.b.a.b();
                    ((ju)localObject8).dwK.dwL = ((com.tencent.mm.protocal.b.a.b)localObject9);
                    ((com.tencent.mm.protocal.b.a.b)localObject9).id = i;
                    ((com.tencent.mm.protocal.b.a.b)localObject9).title = parama;
                    ((com.tencent.mm.protocal.b.a.b)localObject9).msg = ((String)localObject2);
                    ((com.tencent.mm.protocal.b.a.b)localObject9).FpE = new LinkedList();
                    localObject10 = new com.tencent.mm.protocal.b.a.a();
                    ((com.tencent.mm.protocal.b.a.a)localObject10).id = k;
                    ((com.tencent.mm.protocal.b.a.a)localObject10).actionType = m;
                    ((com.tencent.mm.protocal.b.a.a)localObject10).FpC = ((String)localObject6);
                    ((com.tencent.mm.protocal.b.a.a)localObject10).FpD = ((String)localObject7);
                    ((com.tencent.mm.protocal.b.a.b)localObject9).FpE.add(localObject10);
                    if (bool1)
                    {
                      localObject6 = new com.tencent.mm.protocal.b.a.a();
                      ((com.tencent.mm.protocal.b.a.a)localObject6).id = n;
                      ((com.tencent.mm.protocal.b.a.a)localObject6).actionType = i1;
                      ((com.tencent.mm.protocal.b.a.a)localObject6).FpC = ((String)localObject5);
                      ((com.tencent.mm.protocal.b.a.a)localObject6).FpD = paramMap;
                      ((com.tencent.mm.protocal.b.a.b)localObject9).FpE.add(localObject6);
                    }
                    ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), parama, localObject2, Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject8)) });
                    AppMethodBeat.o(20312);
                    return null;
                  }
                  if ((paramString != null) && (paramString.equals("yybsigcheck")))
                  {
                    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 14L, 1L, false);
                    l1 = System.currentTimeMillis();
                    paramString = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                    parama = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.wording");
                    paramMap = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.url");
                    ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", new Object[] { paramString, parama, paramMap });
                    com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4014), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    if (bt.isNullOrNil(paramString))
                    {
                      ad.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 15L, 1L, false);
                      com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4015), String.format("%s|%s", new Object[] { parama, paramMap }) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject2 = paramString.split(";");
                    if (localObject2 == null) {}
                    for (i = -1;; i = localObject2.length)
                    {
                      ad.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStrs len is %d", new Object[] { Integer.valueOf(i) });
                      if ((localObject2 != null) && (localObject2.length != 0)) {
                        break;
                      }
                      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 16L, 1L, false);
                      com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4016), paramString });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    localObject5 = new ArrayList();
                    i = 0;
                    if (i < localObject2.length)
                    {
                      localObject6 = localObject2[i];
                      if (bt.isNullOrNil((String)localObject6)) {
                        ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", new Object[] { Integer.valueOf(i) });
                      }
                      for (;;)
                      {
                        i += 1;
                        break;
                        localObject7 = ((String)localObject6).split(",");
                        if (localObject7 == null) {}
                        for (j = -1;; j = localObject7.length)
                        {
                          ad.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is %d", new Object[] { Integer.valueOf(j) });
                          if ((localObject7 != null) && (localObject7.length == 3)) {
                            break label5322;
                          }
                          ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", new Object[] { Integer.valueOf(i) });
                          break;
                        }
                        try
                        {
                          ((ArrayList)localObject5).add(new ag.c(localObject7[0], bt.getInt(localObject7[1], 0), localObject7[2]));
                        }
                        catch (Exception localException5)
                        {
                          ad.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", new Object[] { Integer.valueOf(i), localException5.getMessage() });
                          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 17L, 1L, false);
                          com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4017), localObject6 });
                        }
                      }
                    }
                    if (((ArrayList)localObject5).size() == 0)
                    {
                      ad.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 18L, 1L, false);
                      com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4018), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    if (bt.getInt(com.tencent.mm.n.g.acA().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)
                    {
                      bool1 = true;
                      boolean bool2 = com.tencent.mm.platformtools.ag.a(aj.getContext(), (ArrayList)localObject5, bool1);
                      ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", new Object[] { Integer.valueOf(((ArrayList)localObject5).size()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l1) });
                      if (bool2) {
                        break label5720;
                      }
                      ba.aBO().setInt(46, 4);
                      localObject2 = new kp();
                      ((kp)localObject2).dxC.dxD = parama;
                      ((kp)localObject2).dxC.url = paramMap;
                      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
                      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 20L, 1L, true);
                      com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4020), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(20312);
                      return null;
                      bool1 = false;
                      break;
                      ba.aBO().setInt(46, 0);
                      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(322L, 19L, 1L, true);
                      com.tencent.mm.plugin.report.service.g.yhR.f(11098, new Object[] { Integer.valueOf(4019), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
                    }
                  }
                  if ((paramString != null) && (paramString.equals("qy_status_notify")))
                  {
                    parama = (String)paramMap.get(".sysmsg.chat_id");
                    paramMap.get(".sysmsg.last_create_time");
                    paramString = (String)paramMap.get(".sysmsg.brand_username");
                    l1 = com.tencent.mm.am.a.e.Ew(parama);
                    if (l1 == -1L)
                    {
                      ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", new Object[] { parama });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    i = com.tencent.mm.am.ag.aGc().rS(l1).field_newUnReadCount;
                    com.tencent.mm.am.ag.aGc().rU(l1);
                    paramMap = com.tencent.mm.am.ag.aGb().bd(l1);
                    ba.aBQ();
                    parama = c.azv().aTz(paramString);
                    if (parama == null)
                    {
                      ad.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", new Object[] { paramString });
                      AppMethodBeat.o(20312);
                      return null;
                    }
                    if (paramMap.hj(1))
                    {
                      if (parama.VL() <= i)
                      {
                        parama.kv(0);
                        ba.aBQ();
                        c.azv().a(parama, paramString);
                        ba.getNotification().cancelNotification(paramString);
                      }
                      for (;;)
                      {
                        AppMethodBeat.o(20312);
                        return null;
                        parama.kv(parama.VL() - i);
                        ba.aBQ();
                        c.azv().a(parama, paramString);
                      }
                    }
                    if (parama.VK() <= i)
                    {
                      ba.aBQ();
                      c.azv().aTB(paramString);
                      ba.getNotification().cancelNotification(paramString);
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(20312);
                      return null;
                      parama.ku(0);
                      parama.kx(0);
                      parama.kp(parama.VK() - i);
                      ba.aBQ();
                      c.azv().a(parama, paramString);
                    }
                  }
                  if ((paramString != null) && (paramString.equals("qy_chat_update")))
                  {
                    parama = (String)paramMap.get(".sysmsg.chat_id");
                    localObject5 = (String)paramMap.get(".sysmsg.ver");
                    com.tencent.mm.am.a.e.n((String)paramMap.get(".sysmsg.brand_username"), parama, (String)localObject5);
                  }
                  if ((paramString != null) && (paramString.equals("bindmobiletip")))
                  {
                    i = bt.getInt((String)paramMap.get(".sysmsg.bindmobiletip.forcebind"), 0);
                    parama = bt.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.deviceid"));
                    paramString = bt.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.wording"));
                    paramMap = new String(Base64.decode(parama.getBytes(), 0));
                    parama = new String(com.tencent.mm.bx.b.cj(com.tencent.mm.compatible.deviceinfo.q.aay().getBytes()).Zz(16).getBytes());
                    ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", new Object[] { Integer.valueOf(i), paramMap, parama, paramString });
                    if ((bt.isNullOrNil(paramMap)) || (paramMap.equals(parama)))
                    {
                      ba.aBQ();
                      c.ajl().set(al.a.Isn, Boolean.TRUE);
                      ba.aBQ();
                      paramMap = c.ajl();
                      parama = al.a.Iso;
                      if (i != 1) {
                        break label6397;
                      }
                    }
                    for (bool1 = true;; bool1 = false)
                    {
                      paramMap.set(parama, Boolean.valueOf(bool1));
                      ba.aBQ();
                      c.ajl().set(al.a.Isp, paramString);
                      AppMethodBeat.o(20312);
                      return null;
                    }
                  }
                  if ((paramString != null) && (paramString.equals("ClientCheckConsistency")))
                  {
                    parama = new cec();
                    parama.FVG = ((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename"));
                    parama.GYd = bt.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                    parama.GYe = bt.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                    parama.FKZ = bt.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                    parama.GYf = k(parama.FVG, parama.GYd, parama.GYe);
                    parama.FileSize = ((int)yB(parama.FVG));
                    if (!com.tencent.mm.plugin.normsg.a.b.wtJ.duJ()) {
                      break label7269;
                    }
                    i = 1;
                  }
                  for (;;)
                  {
                    parama.GYg = i;
                    parama.FYc = ab.aaW();
                    parama.GYh = i(new Object[] { parama.FVG, Integer.valueOf(parama.GYd), Integer.valueOf(parama.GYe), Integer.valueOf(parama.FKZ), parama.GYf, Integer.valueOf(parama.FileSize), Integer.valueOf(parama.GYg), Integer.valueOf(parama.FYc) });
                    ba.aBQ();
                    c.azo().c(new k.a(61, parama));
                    if ((paramString != null) && (paramString.equals("ClientCheckHook")))
                    {
                      parama = new cee();
                      parama.FKZ = bt.getInt((String)paramMap.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                      parama.GYj = com.tencent.mm.plugin.normsg.a.b.wtJ.pi(false);
                      if (com.tencent.mm.plugin.normsg.a.b.wtJ.duJ())
                      {
                        i = 1;
                        parama.GYg = i;
                        parama.FYc = ab.aaW();
                        parama.GYh = i(new Object[] { Integer.valueOf(parama.FKZ), parama.GYj, Integer.valueOf(parama.GYg), Integer.valueOf(parama.FYc) });
                        ba.aBQ();
                        c.azo().c(new k.a(62, parama));
                      }
                    }
                    else
                    {
                      if ((paramString != null) && (paramString.equals("ClientCheckGetAppList")))
                      {
                        parama = new ced();
                        parama.FKZ = bt.getInt((String)paramMap.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                        parama.GYi = com.tencent.mm.plugin.normsg.a.b.wtJ.duI();
                        if (!com.tencent.mm.plugin.normsg.a.b.wtJ.duJ()) {
                          break label7281;
                        }
                        i = 1;
                        parama.GYg = i;
                        parama.FYc = ab.aaW();
                        parama.GYh = i(new Object[] { Integer.valueOf(parama.FKZ), parama.GYi, Integer.valueOf(parama.GYg), Integer.valueOf(parama.FYc) });
                        ba.aBQ();
                        c.azo().c(new k.a(63, parama));
                      }
                      if ((paramString != null) && (paramString.equals("ClientCheckGetExtInfo"))) {
                        com.tencent.mm.sdk.g.b.e(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(20307);
                            int i = bt.getInt((String)paramMap.get(".sysmsg.ClientCheckGetExtInfo.ReportContext"), 0);
                            if (bt.getInt((String)paramMap.get(".sysmsg.ClientCheckGetExtInfo.Basic"), 0) != 0)
                            {
                              com.tencent.mm.plugin.secinforeport.a.d.yBQ.hu(i, 0);
                              AppMethodBeat.o(20307);
                              return;
                            }
                            com.tencent.mm.plugin.secinforeport.a.d.yBQ.hu(i, 31);
                            AppMethodBeat.o(20307);
                          }
                        }, "syscmd_rpt_cc");
                      }
                      if ((!bt.isNullOrNil(paramString)) && (paramString.equals("functionmsg")))
                      {
                        ad.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                        ((v)com.tencent.mm.kernel.g.ad(v.class)).getReceiver().a(localException5, paramMap);
                      }
                      if ((!bt.isNullOrNil(paramString)) && (paramString.equals("paymsg")))
                      {
                        i = bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0);
                        localObject5 = (String)paramMap.get(".sysmsg.paymsg.appmsgcontent");
                        paramString = (String)paramMap.get(".sysmsg.paymsg.fromusername");
                        parama = (String)paramMap.get(".sysmsg.paymsg.tousername");
                        paramMap = (String)paramMap.get(".sysmsg.paymsg.paymsgid");
                        ad.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", new Object[] { Integer.valueOf(i), Long.valueOf(localException5.xbt), paramString, parama, paramMap, localObject5 });
                      }
                    }
                    try
                    {
                      localObject5 = URLDecoder.decode((String)localObject5, "UTF-8");
                      if (!bt.isNullOrNil((String)localObject5))
                      {
                        localObject6 = new pv();
                        ((pv)localObject6).dEm.type = i;
                        ((pv)localObject6).dEm.content = ((String)localObject5);
                        ((pv)localObject6).dEm.dyU = paramString;
                        ((pv)localObject6).dEm.toUser = parama;
                        ((pv)localObject6).dEm.dEn = paramMap;
                        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject6);
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
                        ad.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "", new Object[0]);
                        ad.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", new Object[] { paramString.getMessage() });
                      }
                    }
                  }
                }
              }
              boolean bool1 = false;
            }
          }
          ba.aBQ().azP().a((String)localObject3, bool1, new String[] { localObject8, localObject9, localObject10 });
          ba.aBQ().azQ().t(paramMap);
          if ((!bt.isNullOrNil(paramString)) && (paramString.equals("midinfo")))
          {
            localObject3 = (String)paramMap.get(".sysmsg.midinfo.json_buffer");
            localObject8 = (String)paramMap.get(".sysmsg.midinfo.time_interval");
            ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", new Object[] { localObject8, localObject3, localObject6 });
            i = bt.getInt((String)localObject8, 0);
            if ((i > 86400L) && (i < 864000L))
            {
              ba.aBQ();
              c.ajl().set(331777, Long.valueOf(bt.aQJ() + i));
            }
            if (!bt.isNullOrNil((String)localObject3)) {
              com.tencent.mm.plugin.report.b.d.awB((String)localObject3);
            }
          }
          if ((paramString != null) && (paramString.equals("revokemsg")))
          {
            ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
            localObject2 = (String)paramMap.get(".sysmsg.revokemsg.session");
            localObject3 = (String)paramMap.get(".sysmsg.revokemsg.newmsgid");
            paramString = (String)paramMap.get(".sysmsg.revokemsg.replacemsg");
            ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject3, paramString });
            l1 = 0L;
            try
            {
              l2 = bt.getLong((String)localObject3, 0L);
              l1 = l2;
              ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "xmlSrvMsgId=%d talker=%s isGet=%s", new Object[] { Long.valueOf(l2), localObject2, Boolean.valueOf(parama.hNU) });
              l1 = l2;
              paramMap = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aI((String)localObject2, l2);
              l1 = l2;
              localObject3 = bu.aN(paramMap);
              l1 = l2;
              ba.aBQ();
              l1 = l2;
              localObject6 = c.azv().aTz((String)localObject2);
              if (parama == null) {
                break label1474;
              }
              l1 = l2;
              if (!parama.hNU) {
                break label1474;
              }
              l1 = l2;
              localObject7 = parama.gqE;
              l1 = l2;
              localObject8 = z.a(((cv)localObject7).Fvk);
              l1 = l2;
              localObject9 = new bn();
              l1 = l2;
              ((bn)localObject9).field_originSvrId = l2;
              l1 = l2;
              if (paramMap.field_msgId != 0L) {
                break label1204;
              }
              l1 = l2;
              ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", new Object[] { Long.valueOf(l2) });
              l1 = l2;
              ((bn)localObject9).field_content = ((String)localObject8);
              l1 = l2;
              ((bn)localObject9).field_createTime = ((cv)localObject7).CreateTime;
              l1 = l2;
              ((bn)localObject9).field_flag = bj.d(parama);
              l1 = l2;
              ((bn)localObject9).field_fromUserName = z.a(((cv)localObject7).Fvi);
              l1 = l2;
              ((bn)localObject9).field_toUserName = z.a(((cv)localObject7).Fvj);
              l1 = l2;
              ((bn)localObject9).field_newMsgId = ((cv)localObject7).xbt;
              l1 = l2;
              com.tencent.mm.modelmulti.p.aJy();
              l1 = l2;
              ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr insert ret[%b], systemRowid[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelmulti.p.aJw().insert((com.tencent.mm.sdk.e.c)localObject9)), Long.valueOf(((bn)localObject9).systemRowid) });
            }
            catch (Exception paramString)
            {
              for (;;)
              {
                long l2;
                label1130:
                ad.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[oneliang][revokeMsg] msgId:%d,error:%s", new Object[] { Long.valueOf(l1), paramString.toString() });
                continue;
                l1 = l2;
                ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke newxml, but original msg has not been found, originSvrId[%d]", new Object[] { Long.valueOf(l2) });
                l1 = l2;
                ba.aBQ();
                l1 = l2;
                c.azs().yc(l2);
                continue;
                l1 = l2;
                if (paramMap.getType() == 922746929)
                {
                  l1 = l2;
                  ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.patmsg.a.b.class)).ba((String)localObject2, l2);
                }
                else
                {
                  l1 = l2;
                  if ((paramMap.eLr & 0x4) != 4)
                  {
                    l1 = l2;
                    paramMap.setContent(paramString);
                    l1 = l2;
                    paramMap.setType(10000);
                    l1 = l2;
                    bj.a(paramMap, parama);
                    l1 = l2;
                    ba.aBQ();
                    l1 = l2;
                    c.azs().a(paramMap.field_msgId, paramMap);
                  }
                  l1 = l2;
                  ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleRevokeMsgBySvrId(l2);
                  if (localObject6 != null)
                  {
                    l1 = l2;
                    if (((com.tencent.mm.g.c.ba)localObject6).field_unReadCount > 0)
                    {
                      l1 = l2;
                      ba.aBQ();
                      l1 = l2;
                      i = c.azs().ar(paramMap);
                      l1 = l2;
                      if (((com.tencent.mm.g.c.ba)localObject6).field_unReadCount >= i)
                      {
                        l1 = l2;
                        ((at)localObject6).kp(((com.tencent.mm.g.c.ba)localObject6).field_unReadCount - 1);
                        l1 = l2;
                        ba.aBQ();
                        l1 = l2;
                        c.azv().a((at)localObject6, ((com.tencent.mm.g.c.ba)localObject6).field_username);
                      }
                    }
                  }
                  l1 = l2;
                  if (aa.i(localException3))
                  {
                    l1 = l2;
                    parama = new nd();
                    l1 = l2;
                    parama.dBc.dBd = localException3;
                    l1 = l2;
                    com.tencent.mm.sdk.b.a.IbL.l(parama);
                  }
                  l1 = l2;
                  parama = new rz();
                  l1 = l2;
                  parama.dGy.msgId = paramMap.field_msgId;
                  l1 = l2;
                  parama.dGy.dGz = paramString;
                  l1 = l2;
                  parama.dGy.dBd = paramMap;
                  l1 = l2;
                  parama.dGy.dGA = localException3;
                  l1 = l2;
                  parama.dGy.dGB = l2;
                  l1 = l2;
                  com.tencent.mm.sdk.b.a.IbL.l(parama);
                  if (localException3 != null)
                  {
                    l1 = l2;
                    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(20308);
                        ad.i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s", new Object[] { Long.valueOf(localException3.field_msgId), Integer.valueOf(localException3.getType()) });
                        switch (localException3.getType())
                        {
                        }
                        for (;;)
                        {
                          AppMethodBeat.o(20308);
                          return;
                          bj.x(localException3);
                        }
                      }
                    });
                  }
                }
              }
            }
            AppMethodBeat.o(20312);
            return null;
            localObject2 = ((com.tencent.mm.al.e)localObject2).b(parama);
            continue;
            localException1 = localException1;
            ad.e("MicroMsg.BigBallSysCmdMsgConsumer", localException1.toString());
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ad.e("MicroMsg.BigBallSysCmdMsgConsumer", localException2.toString());
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void fB(String paramString);
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