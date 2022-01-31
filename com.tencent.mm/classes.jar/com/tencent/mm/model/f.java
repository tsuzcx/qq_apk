package com.tencent.mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.ai.p;
import com.tencent.mm.api.m;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.g.a.jb;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.pm;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.platformtools.ai.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.bhk;
import com.tencent.mm.protocal.protobuf.bhl;
import com.tencent.mm.protocal.protobuf.bhm;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.y;
import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class f
  implements com.tencent.mm.plugin.messenger.foundation.a.n
{
  private long fkL = -1L;
  public f.a fkM;
  
  private static void Zg()
  {
    AppMethodBeat.i(16266);
    List localList = com.tencent.mm.m.g.Nq().lv("^JDEntranceConfigName$");
    ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "jd config name %s", new Object[] { localList });
    if (localList.isEmpty()) {
      com.tencent.mm.plugin.report.service.h.qsU.cT(931, 6);
    }
    for (;;)
    {
      localList = com.tencent.mm.m.g.Nq().lv("^JDEntranceConfigJumpUrl$");
      ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "jd jump url %s", new Object[] { localList });
      if (!localList.isEmpty()) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.qsU.cT(931, 8);
      AppMethodBeat.o(16266);
      return;
      if (bo.isNullOrNil((String)localList.get(0))) {
        com.tencent.mm.plugin.report.service.h.qsU.cT(931, 9);
      }
    }
    if (bo.isNullOrNil((String)localList.get(0))) {
      com.tencent.mm.plugin.report.service.h.qsU.cT(931, 11);
    }
    AppMethodBeat.o(16266);
  }
  
  private static String h(Object... paramVarArgs)
  {
    AppMethodBeat.i(16270);
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
        ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramVarArgs, "", new Object[0]);
        AppMethodBeat.o(16270);
        return "";
      }
      int j = 0;
      continue;
      ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", new Object[] { localObject });
      AppMethodBeat.o(16270);
      return "";
      label236:
      paramVarArgs = bo.cg(MessageDigest.getInstance("MD5").digest(localByteArrayOutputStream.toByteArray()));
      AppMethodBeat.o(16270);
      return paramVarArgs;
      i += 1;
    }
  }
  
  /* Error */
  private static String m(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: sipush 16268
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 160
    //   9: invokevirtual 163	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifeq +70 -> 82
    //   15: new 165	java/util/zip/ZipFile
    //   18: dup
    //   19: invokestatic 171	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   22: invokevirtual 177	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   25: getfield 183	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   28: invokespecial 186	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   31: astore 9
    //   33: aload 9
    //   35: aload 9
    //   37: aload_0
    //   38: iconst_1
    //   39: invokevirtual 190	java/lang/String:substring	(I)Ljava/lang/String;
    //   42: invokevirtual 194	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   45: invokevirtual 198	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
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
    //   69: invokevirtual 204	java/io/InputStream:skip	(J)J
    //   72: lstore 6
    //   74: lload_1
    //   75: lload 6
    //   77: lsub
    //   78: lstore_1
    //   79: goto -26 -> 53
    //   82: aload_0
    //   83: invokestatic 210	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   86: astore 8
    //   88: aconst_null
    //   89: astore_0
    //   90: goto -37 -> 53
    //   93: aload_0
    //   94: astore 10
    //   96: aload 8
    //   98: astore 9
    //   100: ldc 137
    //   102: invokestatic 143	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
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
    //   139: ldc2_w 211
    //   142: lload_3
    //   143: invokestatic 218	java/lang/Math:min	(JJ)J
    //   146: l2i
    //   147: invokevirtual 222	java/io/InputStream:read	([BII)I
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
    //   172: invokevirtual 226	java/security/MessageDigest:update	([BII)V
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
    //   193: invokevirtual 228	java/security/MessageDigest:digest	()[B
    //   196: invokestatic 154	com/tencent/mm/sdk/platformtools/bo:cg	([B)Ljava/lang/String;
    //   199: astore 11
    //   201: aload 8
    //   203: ifnull +8 -> 211
    //   206: aload 8
    //   208: invokevirtual 231	java/io/InputStream:close	()V
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 232	java/util/zip/ZipFile:close	()V
    //   219: sipush 16268
    //   222: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   242: ldc 46
    //   244: aload 11
    //   246: ldc 126
    //   248: iconst_0
    //   249: anewarray 4	java/lang/Object
    //   252: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: aload 8
    //   257: ifnull +8 -> 265
    //   260: aload 8
    //   262: invokevirtual 231	java/io/InputStream:close	()V
    //   265: aload_0
    //   266: ifnull +7 -> 273
    //   269: aload_0
    //   270: invokevirtual 232	java/util/zip/ZipFile:close	()V
    //   273: sipush 16268
    //   276: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: ldc 126
    //   281: areturn
    //   282: astore_0
    //   283: aconst_null
    //   284: astore 10
    //   286: aconst_null
    //   287: astore 9
    //   289: aload 9
    //   291: ifnull +8 -> 299
    //   294: aload 9
    //   296: invokevirtual 231	java/io/InputStream:close	()V
    //   299: aload 10
    //   301: ifnull +8 -> 309
    //   304: aload 10
    //   306: invokevirtual 232	java/util/zip/ZipFile:close	()V
    //   309: sipush 16268
    //   312: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  private static long ng(String paramString)
  {
    // Byte code:
    //   0: sipush 16269
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 160
    //   9: invokevirtual 163	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   12: ifeq +131 -> 143
    //   15: new 165	java/util/zip/ZipFile
    //   18: dup
    //   19: invokestatic 171	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   22: invokevirtual 177	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   25: getfield 183	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   28: invokespecial 186	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: aload 4
    //   38: aload_0
    //   39: iconst_1
    //   40: invokevirtual 190	java/lang/String:substring	(I)Ljava/lang/String;
    //   43: invokevirtual 194	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnonnull +18 -> 66
    //   51: aload 4
    //   53: invokevirtual 232	java/util/zip/ZipFile:close	()V
    //   56: sipush 16269
    //   59: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: ldc2_w 19
    //   65: lreturn
    //   66: aload 4
    //   68: astore_3
    //   69: aload_0
    //   70: invokevirtual 239	java/util/zip/ZipEntry:getSize	()J
    //   73: lstore_1
    //   74: aload 4
    //   76: invokevirtual 232	java/util/zip/ZipFile:close	()V
    //   79: sipush 16269
    //   82: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: lload_1
    //   86: lreturn
    //   87: astore 5
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: astore_3
    //   93: ldc 46
    //   95: aload 5
    //   97: ldc 126
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_0
    //   107: ifnull +7 -> 114
    //   110: aload_0
    //   111: invokevirtual 232	java/util/zip/ZipFile:close	()V
    //   114: sipush 16269
    //   117: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: ldc2_w 19
    //   123: lreturn
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_3
    //   127: aload_3
    //   128: ifnull +7 -> 135
    //   131: aload_3
    //   132: invokevirtual 232	java/util/zip/ZipFile:close	()V
    //   135: sipush 16269
    //   138: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_0
    //   142: athrow
    //   143: aload_0
    //   144: invokestatic 242	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   147: lstore_1
    //   148: sipush 16269
    //   151: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(16267);
    Object localObject6 = parama.eyJ;
    Object localObject5 = com.tencent.mm.platformtools.aa.a(((cm)localObject6).woR);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.equals("addcontact"))
      {
        ((cm)localObject6).woR = com.tencent.mm.platformtools.aa.wA((String)paramMap.get(".sysmsg.addcontact.content"));
        ((cm)localObject6).nqW = 1;
        localObject1 = e.d.aV(Integer.valueOf(1));
        if (localObject1 != null) {
          break label1193;
        }
        localObject1 = null;
      }
    }
    int i;
    if ((paramString != null) && (paramString.equals("dynacfg")))
    {
      com.tencent.mm.m.g.Nq().a((String)localObject5, paramMap, false);
      com.tencent.mm.m.g.Nr();
      if (com.tencent.mm.m.c.Nb() == 2) {
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10879, "");
      }
      i = bo.getInt(com.tencent.mm.m.g.Nq().getValue("MuteRoomDisable"), 0);
      ab.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(i));
      if (com.tencent.mm.sdk.platformtools.aa.dsD()) {
        Zg();
      }
    }
    if ((paramString != null) && (paramString.equals("dynacfg_split")))
    {
      com.tencent.mm.m.g.Nq().a((String)localObject5, paramMap, true);
      if (com.tencent.mm.sdk.platformtools.aa.dsD()) {
        Zg();
      }
    }
    Object localObject7;
    Object localObject8;
    if ((paramString != null) && (paramString.equals("banner")))
    {
      localObject2 = (String)paramMap.get(".sysmsg.mainframebanner.$type");
      localObject7 = (String)paramMap.get(".sysmsg.mainframebanner.showtype");
      localObject8 = (String)paramMap.get(".sysmsg.mainframebanner.data");
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {}
    }
    label1193:
    label2602:
    label3887:
    label4149:
    for (;;)
    {
      Object localObject9;
      Object localObject10;
      long l1;
      try
      {
        be.aaG().a(new bd(Integer.valueOf((String)localObject2).intValue(), Integer.valueOf((String)localObject7).intValue(), (String)localObject8));
        localObject2 = (String)paramMap.get(".sysmsg.friendrecommand.fromuser");
        localObject7 = (String)paramMap.get(".sysmsg.friendrecommand.touser");
        if ((localObject2 == null) || (localObject7 == null)) {}
      }
      catch (Exception localException3)
      {
        try
        {
          aw.aaz().YY().a((String)localObject7, true, null);
          localObject2 = (String)paramMap.get(".sysmsg.banner.securitybanner.chatname");
          localObject7 = (String)paramMap.get(".sysmsg.banner.securitybanner.wording");
          localObject8 = (String)paramMap.get(".sysmsg.banner.securitybanner.linkname");
          localObject9 = (String)paramMap.get(".sysmsg.banner.securitybanner.linksrc");
          localObject10 = (String)paramMap.get(".sysmsg.banner.securitybanner.showtype");
          if ((bo.isNullOrNil((String)localObject2)) || (bo.isNullOrNil((String)localObject10))) {}
        }
        catch (Exception localException3)
        {
          try
          {
            if (!((String)localObject10).equals("1")) {
              break label7300;
            }
            bool1 = true;
            aw.aaz().YZ().a((String)localObject2, bool1, new String[] { localObject7, localObject8, localObject9 });
            aw.aaz().Za().o(paramMap);
            if ((!bo.isNullOrNil(paramString)) && (paramString.equals("midinfo")))
            {
              localObject2 = (String)paramMap.get(".sysmsg.midinfo.json_buffer");
              localObject7 = (String)paramMap.get(".sysmsg.midinfo.time_interval");
              ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", new Object[] { localObject7, localObject2, localObject5 });
              i = bo.getInt((String)localObject7, 0);
              if ((i > 86400L) && (i < 864000L))
              {
                aw.aaz();
                c.Ru().set(331777, Long.valueOf(bo.aox() + i));
              }
              if (!bo.isNullOrNil((String)localObject2)) {
                com.tencent.mm.plugin.report.b.d.Yr((String)localObject2);
              }
            }
            if ((paramString != null) && (paramString.equals("revokemsg")))
            {
              ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
              localObject1 = (String)paramMap.get(".sysmsg.revokemsg.session");
              localObject2 = (String)paramMap.get(".sysmsg.revokemsg.newmsgid");
              paramString = (String)paramMap.get(".sysmsg.revokemsg.replacemsg");
              ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject2, paramString });
              l1 = 0L;
            }
          }
          catch (Exception localException3)
          {
            try
            {
              long l2 = bo.getLong((String)localObject2, 0L);
              l1 = l2;
              aw.aaz();
              l1 = l2;
              paramMap = c.YC().ag((String)localObject1, l2);
              l1 = l2;
              localObject1 = bi.as(paramMap);
              l1 = l2;
              if ((paramMap.dnr & 0x4) != 4)
              {
                l1 = l2;
                paramMap.setContent(paramString);
                l1 = l2;
                paramMap.setType(10000);
                l1 = l2;
                bf.a(paramMap, parama);
                l1 = l2;
                aw.aaz();
                l1 = l2;
                c.YC().a(paramMap.field_msgId, paramMap);
              }
              l1 = l2;
              aw.aaz();
              l1 = l2;
              localObject2 = c.YF().arH(paramMap.field_talker);
              if (localObject2 != null)
              {
                l1 = l2;
                if (((au)localObject2).field_unReadCount > 0)
                {
                  l1 = l2;
                  aw.aaz();
                  l1 = l2;
                  i = c.YC().Y(paramMap);
                  l1 = l2;
                  if (((au)localObject2).field_unReadCount >= i)
                  {
                    l1 = l2;
                    ((com.tencent.mm.storage.ak)localObject2).hJ(((au)localObject2).field_unReadCount - 1);
                    l1 = l2;
                    aw.aaz();
                    l1 = l2;
                    c.YF().a((com.tencent.mm.storage.ak)localObject2, ((au)localObject2).field_username);
                  }
                }
              }
              if (parama != null)
              {
                l1 = l2;
                if (parama.fte)
                {
                  l1 = l2;
                  localObject7 = new bb();
                  l1 = l2;
                  ((bb)localObject7).field_originSvrId = l2;
                  l1 = l2;
                  if (paramMap.field_msgId == 0L)
                  {
                    l1 = l2;
                    ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", new Object[] { Long.valueOf(l2) });
                    l1 = l2;
                    ((bb)localObject7).field_content = ((String)localObject5);
                    l1 = l2;
                    ((bb)localObject7).field_createTime = ((cm)localObject6).CreateTime;
                    l1 = l2;
                    ((bb)localObject7).field_flag = bf.d(parama);
                    l1 = l2;
                    ((bb)localObject7).field_fromUserName = com.tencent.mm.platformtools.aa.a(((cm)localObject6).woP);
                    l1 = l2;
                    ((bb)localObject7).field_toUserName = com.tencent.mm.platformtools.aa.a(((cm)localObject6).woQ);
                    l1 = l2;
                    ((bb)localObject7).field_newMsgId = ((cm)localObject6).pIG;
                    l1 = l2;
                    com.tencent.mm.modelmulti.n.aip();
                    l1 = l2;
                    ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr insert ret[%b], systemRowid[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelmulti.n.ain().insert((com.tencent.mm.sdk.e.c)localObject7)), Long.valueOf(((bb)localObject7).systemRowid) });
                    AppMethodBeat.o(16267);
                    return null;
                    localObject1 = ((com.tencent.mm.ai.e)localObject1).b(parama);
                    break;
                    localException1 = localException1;
                    ab.e("MicroMsg.BigBallSysCmdMsgConsumer", localException1.toString());
                    continue;
                    localException2 = localException2;
                    ab.e("MicroMsg.BigBallSysCmdMsgConsumer", localException2.toString());
                    continue;
                    localException3 = localException3;
                    ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + localException3.toString());
                    continue;
                  }
                  l1 = l2;
                  ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and has done delete info, originSvrId[%d]", new Object[] { Long.valueOf(l2) });
                  l1 = l2;
                  com.tencent.mm.modelmulti.n.aip();
                  l1 = l2;
                  com.tencent.mm.modelmulti.n.ain().delete((com.tencent.mm.sdk.e.c)localObject7, true, new String[0]);
                  l1 = l2;
                  aw.aaz();
                  l1 = l2;
                  c.YC().kF(l2);
                  if (localException3 != null)
                  {
                    l1 = l2;
                    if (parama.eyJ != null)
                    {
                      l1 = l2;
                      if (localException3.field_lastSeq == parama.eyJ.woW)
                      {
                        l1 = l2;
                        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", new Object[] { Long.valueOf(localException3.field_lastSeq), Long.valueOf(localException3.field_firstUnDeliverSeq) });
                        l1 = l2;
                        aw.aaz();
                        l1 = l2;
                        localObject5 = c.YC().Tn(localException3.field_username);
                        if (localObject5 != null)
                        {
                          l1 = l2;
                          localException3.fM(((dd)localObject5).field_msgSeq);
                          l1 = l2;
                          aw.aaz();
                          l1 = l2;
                          i = c.YF().a(localException3, localException3.field_username);
                          l1 = l2;
                          ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", new Object[] { Long.valueOf(((dd)localObject5).field_msgSvrId), Long.valueOf(((dd)localObject5).field_msgSeq), Long.valueOf(localException3.field_lastSeq), Long.valueOf(localException3.field_firstUnDeliverSeq), Integer.valueOf(i) });
                        }
                      }
                    }
                  }
                }
              }
              l1 = l2;
              if (paramMap.field_msgId == 0L) {
                if (parama != null)
                {
                  l1 = l2;
                  if (parama.fte) {}
                }
                else
                {
                  l1 = l2;
                  ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summer revoke msg id is 0 and svrid[%d]", new Object[] { Long.valueOf(l2) });
                  l1 = l2;
                  aw.aaz();
                  l1 = l2;
                  c.YC().kF(l2);
                }
              }
              l1 = l2;
              parama = new pm();
              l1 = l2;
              parama.cFZ.cpO = paramMap.field_msgId;
              l1 = l2;
              parama.cFZ.cGa = paramString;
              l1 = l2;
              parama.cFZ.cEE = paramMap;
              l1 = l2;
              parama.cFZ.cGb = ((bi)localObject1);
              l1 = l2;
              parama.cFZ.cGc = l2;
              l1 = l2;
              com.tencent.mm.sdk.b.a.ymk.l(parama);
              if (localObject1 != null)
              {
                l1 = l2;
                com.tencent.mm.kernel.g.RO().ac(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(16265);
                    ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "[deleteLocalFile] id:%s type:%s", new Object[] { Long.valueOf(this.fkQ.field_msgId), Integer.valueOf(this.fkQ.getType()) });
                    switch (this.fkQ.getType())
                    {
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(16265);
                      return;
                      bf.m(this.fkQ);
                    }
                  }
                });
              }
            }
            catch (Exception paramString)
            {
              ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[oneliang][revokeMsg] msgId:%d,error:%s", new Object[] { Long.valueOf(l1), paramString.toString() });
              continue;
            }
            AppMethodBeat.o(16267);
            return null;
          }
        }
      }
      int j;
      if ((paramString != null) && (paramString.equals("clouddelmsg")))
      {
        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
        localObject3 = (String)paramMap.get(".sysmsg.clouddelmsg.delcommand");
        localObject1 = (String)paramMap.get(".sysmsg.clouddelmsg.msgid");
        paramMap = (String)paramMap.get(".sysmsg.clouddelmsg.fromuser");
        i = ((String)localObject5).indexOf("<msg>");
        j = ((String)localObject5).indexOf("</msg>");
        if ((i == -1) || (j == -1))
        {
          paramString = "";
          ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", new Object[] { localObject3, localObject1, paramMap, paramString });
        }
        for (;;)
        {
          try
          {
            aw.aaz();
            paramMap = c.YC().fl(paramMap, (String)localObject1);
            if ((paramMap == null) || (paramMap.size() <= 0))
            {
              ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
              AppMethodBeat.o(16267);
              return null;
              paramString = com.tencent.mm.sdk.platformtools.be.aT(br.F(((String)localObject5).substring(i, j + 6), "msg"));
              break;
            }
            paramMap = paramMap.iterator();
            if (paramMap.hasNext())
            {
              localObject5 = (bi)paramMap.next();
              if (localObject5 != null) {
                break label2059;
              }
              ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
            }
            if (((dd)localObject5).field_msgSvrId >= 0L) {
              break label2106;
            }
          }
          catch (Exception paramString)
          {
            ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", new Object[] { localObject1, paramString.toString() });
            AppMethodBeat.o(16267);
            return null;
          }
          ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((dd)localObject5).field_msgId), Long.valueOf(((dd)localObject5).field_msgSvrId) });
        }
        label2106:
        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((dd)localObject5).field_msgId), Long.valueOf(((dd)localObject5).field_msgSvrId) });
        i = bo.getInt((String)localObject3, 0);
        if (i == 1)
        {
          aw.aaz();
          c.YC().aq(((dd)localObject5).field_talker, ((dd)localObject5).field_msgSvrId);
        }
        for (;;)
        {
          localObject6 = new pm();
          ((pm)localObject6).cFZ.cpO = ((dd)localObject5).field_msgId;
          ((pm)localObject6).cFZ.cGa = paramString;
          ((pm)localObject6).cFZ.cEE = ((bi)localObject5);
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject6);
          break;
          if ((i == 2) && (((bi)localObject5).dvV()))
          {
            ((bi)localObject5).setContent(paramString);
            bf.a((bi)localObject5, parama);
            aw.aaz();
            c.YC().b(((dd)localObject5).field_msgSvrId, (bi)localObject5);
            aw.aaz();
            localObject6 = c.YF().arH(((dd)localObject5).field_talker);
            if ((localObject6 != null) && (((au)localObject6).field_unReadCount > 0))
            {
              aw.aaz();
              i = c.YC().Y((bi)localObject5);
              if (((au)localObject6).field_unReadCount >= i)
              {
                ((com.tencent.mm.storage.ak)localObject6).hJ(((au)localObject6).field_unReadCount - 1);
                aw.aaz();
                c.YF().a((com.tencent.mm.storage.ak)localObject6, ((au)localObject6).field_username);
              }
            }
          }
        }
      }
      if ((paramString != null) && (paramString.equals("updatepackage")))
      {
        localObject1 = e.d.aV(Integer.valueOf(-1879048175));
        if (localObject1 != null) {}
      }
      label2813:
      Object localObject4;
      label3544:
      label6365:
      for (Object localObject3 = null;; localObject4 = localObject1)
      {
        for (;;)
        {
          localObject1 = localObject3;
          if (paramString != null)
          {
            localObject1 = localObject3;
            if (paramString.equals("deletepackage"))
            {
              localObject1 = e.d.aV(Integer.valueOf(-1879048174));
              if (localObject1 != null) {
                break label3298;
              }
              localObject1 = null;
            }
          }
          Object localObject11;
          if ((paramString != null) && (paramString.equals("delchatroommember")))
          {
            localObject3 = com.tencent.mm.platformtools.aa.a(((cm)localObject6).woP);
            aw.aaz();
            localObject7 = c.YC().ag((String)localObject3, ((cm)localObject6).pIG);
            i = 0;
            if (((dd)localObject7).field_msgId > 0L) {
              i = 1;
            }
            ((bi)localObject7).fP(((cm)localObject6).pIG);
            if ((parama == null) || (!parama.fte) || (!parama.ftg)) {
              ((bi)localObject7).fQ(bf.x((String)localObject3, ((cm)localObject6).CreateTime));
            }
            ((bi)localObject7).setType(10002);
            ((bi)localObject7).setContent((String)localObject5);
            ((bi)localObject7).hL(0);
            ((bi)localObject7).kj((String)localObject3);
            ((bi)localObject7).jl(((cm)localObject6).woU);
            bf.a((bi)localObject7, parama);
            if (i == 0) {
              bf.l((bi)localObject7);
            }
          }
          else
          {
            localObject3 = localObject1;
            if (paramString != null)
            {
              localObject3 = localObject1;
              if (paramString.equals("WakenPush"))
              {
                localObject3 = localObject1;
                if (this.fkL != ((cm)localObject6).pIG)
                {
                  this.fkL = ((cm)localObject6).pIG;
                  ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                  localObject3 = new cg(paramMap);
                  localObject5 = (String)((cg)localObject3).fjm.get(".sysmsg.WakenPush.PushContent");
                  localObject7 = (String)((cg)localObject3).fjm.get(".sysmsg.WakenPush.Jump");
                  localObject1 = (String)((cg)localObject3).fjm.get(".sysmsg.WakenPush.ExpiredTime");
                  localObject8 = (String)((cg)localObject3).fjm.get(".sysmsg.WakenPush.Username");
                  ab.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", new Object[] { localObject5, localObject7, localObject1 });
                  localObject1 = com.tencent.mm.m.g.Nq().getValue("WakenPushDeepLinkBitSet");
                  ab.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", new Object[] { localObject1 });
                  if (bo.isNullOrNil((String)localObject1)) {
                    break label3333;
                  }
                  l1 = bo.getLong((String)localObject1, 0L);
                  localObject9 = com.tencent.mm.ah.b.b((String)localObject8, false, -1);
                  localObject10 = aw.getNotification();
                  if (!bo.isNullOrNil((String)localObject7)) {
                    break label3339;
                  }
                  ab.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
                  localObject1 = "com.tencent.mm.ui.LauncherUI";
                  localObject11 = new Intent();
                  ((Intent)localObject11).setClassName(ah.getContext(), (String)localObject1);
                  ((Intent)localObject11).setFlags(536870912);
                  ((Intent)localObject11).putExtra("LauncherUI.Show.Update.DialogMsg", (String)((cg)localObject3).fjm.get(".sysmsg.WakenPush.PushContent"));
                  if (!((String)localObject7).equals("weixin://dl/update_newest_version")) {
                    ((Intent)localObject11).putExtra("LauncherUI.Show.Update.Url", (String)((cg)localObject3).fjm.get(".sysmsg.WakenPush.Jump"));
                  }
                  com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 32L, 1L, true);
                  localObject1 = ((an)localObject10).a(PendingIntent.getActivity(ah.getContext(), UUID.randomUUID().hashCode(), (Intent)localObject11, 134217728), ah.getContext().getString(2131297005), (String)localObject5, (String)localObject5, (Bitmap)localObject9, (String)localObject8);
                  ((Notification)localObject1).flags |= 0x10;
                  aw.getNotification().a((Notification)localObject1, false);
                  com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 31L, 1L, true);
                  localObject3 = null;
                }
              }
            }
            localObject1 = localObject3;
            if (paramString == null) {
              break label3601;
            }
            localObject1 = localObject3;
            if (!paramString.equals("DisasterNotice")) {
              break label3601;
            }
            localObject7 = (String)paramMap.get(".sysmsg.NoticeId");
            localObject8 = (String)paramMap.get(".sysmsg.Content");
            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", new Object[] { localObject7, localObject8 });
            localObject9 = ah.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.h.Mp());
            localObject5 = ((SharedPreferences)localObject9).getString("disaster_noticeid_list_key", "");
            if (((String)localObject5).contains((CharSequence)localObject7)) {
              break label3544;
            }
            localObject10 = ((String)localObject5).split(";");
            if ((localObject10 == null) || (localObject10.length <= 10)) {
              break label3455;
            }
            localObject1 = "";
            j = localObject10.length;
            i = 0;
            label3183:
            localObject3 = localObject1;
            if (i >= j) {
              break label3459;
            }
            localObject11 = localObject10[i].split(",");
            localObject3 = localObject1;
          }
          try
          {
            if (bo.gz(bo.getLong(localObject11[0], 0L)) < 1296000L) {
              localObject3 = (String)localObject1 + localObject11[0] + "," + localObject11[1] + ";";
            }
            i += 1;
            localObject1 = localObject3;
            break label3183;
            localObject3 = ((com.tencent.mm.ai.e)localObject1).b(parama);
            continue;
            label3298:
            localObject1 = ((com.tencent.mm.ai.e)localObject1).b(parama);
            break label2442;
            aw.aaz();
            c.YC().b(((cm)localObject6).pIG, (bi)localObject7);
            break label2602;
            l1 = 0L;
            break label2813;
            if (((0x4 & l1) == 4L) && (((String)localObject7).startsWith("weixin://dl/moments")))
            {
              localObject1 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
              break label2849;
            }
            if (((l1 & 0x40000) == 262144L) && (((String)localObject7).startsWith("weixin://dl/recommendation")))
            {
              localObject1 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
              break label2849;
            }
            ab.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", new Object[] { localObject7 });
            localObject1 = "com.tencent.mm.ui.LauncherUI";
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", new Object[] { localException4 });
              localObject4 = localObject1;
            }
          }
        }
        label3455:
        localObject4 = localObject5;
        localObject1 = (String)localObject4 + bo.aox() + "," + (String)localObject7 + ";";
        ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", new Object[] { localObject5, localObject1 });
        ((SharedPreferences)localObject9).edit().putString("disaster_noticeid_list_key", (String)localObject1).commit();
        new com.tencent.mm.sdk.platformtools.ak(Looper.getMainLooper()).post(new f.1(this, (String)localObject7));
        ((cm)localObject6).woR = com.tencent.mm.platformtools.aa.wA((String)localObject8);
        ((cm)localObject6).nqW = 1;
        localObject1 = e.d.aV(Integer.valueOf(1));
        if (localObject1 == null)
        {
          localObject1 = null;
          if ((paramString == null) || (!paramString.equals("EmotionKv"))) {
            break label4149;
          }
          paramString = (String)paramMap.get(".sysmsg.EmotionKv.K");
          localObject1 = (String)paramMap.get(".sysmsg.EmotionKv.I");
          if (paramString != null) {
            break label7290;
          }
          paramString = "";
        }
        label3811:
        label3947:
        label4080:
        label4088:
        label7290:
        for (;;)
        {
          ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", new Object[] { Integer.valueOf(paramString.length()), paramString, localObject1 });
          localObject4 = com.tencent.mm.protocal.aa.dqE().wiZ.getBytes();
          localObject5 = com.tencent.mm.protocal.aa.dqE().wja.getBytes();
          paramMap = null;
          try
          {
            parama = aw.Rc().ftA.adI().adD();
            paramMap = parama;
          }
          catch (Exception parama)
          {
            for (;;)
            {
              ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", new Object[] { bo.l(parama) });
            }
            localObject6 = com.tencent.mm.protocal.f.dqt();
            if (!bo.ce((byte[])localObject6)) {
              break label3811;
            }
            ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  newECDH  is null .");
            AppMethodBeat.o(16267);
            return null;
            parama = new PByteArray();
            if (bo.isNullOrNil(paramString)) {
              break label3857;
            }
          }
          if (bo.ce(paramMap))
          {
            ab.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
            AppMethodBeat.o(16267);
            return null;
            localObject1 = ((com.tencent.mm.ai.e)localObject1).b(parama);
            break;
          }
          int k;
          int m;
          int n;
          if ((bo.ce((byte[])localObject5)) || (bo.ce((byte[])localObject4)) || (bo.ce(paramMap)) || (bo.ce((byte[])localObject6))) {
            if (paramString == null)
            {
              i = -1;
              if (localObject5 != null) {
                break label4080;
              }
              j = -1;
              if (localObject4 != null) {
                break label4088;
              }
              k = -1;
              if (paramMap != null) {
                break label4096;
              }
              m = -1;
              if (localObject6 != null) {
                break label4103;
              }
              n = -1;
              ab.w("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d newECDH:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
              paramString = parama.value;
              paramMap = new aza();
              if (parama.value == null) {
                break label4133;
              }
              paramMap.qsu = new String(parama.value);
              if (paramString != null) {
                break label4142;
              }
            }
          }
          for (i = -1;; i = paramString.length)
          {
            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv res len:%d val len:%d, content[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramMap.qsu.length()), com.tencent.mm.a.g.w(paramMap.qsu.getBytes()) });
            paramMap.xox = ((String)localObject1);
            aw.aaz();
            c.Yz().c(new j.a(59, paramMap));
            AppMethodBeat.o(16267);
            return null;
            i = paramString.length();
            break;
            j = localObject5.length;
            break label3872;
            k = localObject4.length;
            break label3880;
            m = paramMap.length;
            break label3887;
            n = localObject6.length;
            break label3895;
            aw.aaz();
            MMProtocalJni.genClientCheckKVRes(c.getUin(), paramString, (byte[])localObject4, (byte[])localObject5, paramMap, (byte[])localObject6, parama);
            break label3947;
            paramMap.qsu = "";
            break label3982;
          }
          if ((paramString != null) && (paramString.equals("globalalert")))
          {
            paramString = (String)paramMap.get(".sysmsg.uuid");
            i = bo.getInt((String)paramMap.get(".sysmsg.id"), -1);
            j = bo.getInt((String)paramMap.get(".sysmsg.important"), -1);
            if ((bo.isNullOrNil(paramString)) || (i < 0) || (j < 0))
            {
              ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
              AppMethodBeat.o(16267);
              return null;
            }
            parama = (String)paramMap.get(".sysmsg.title");
            localObject1 = (String)paramMap.get(".sysmsg.msg");
            if ((bo.isNullOrNil(parama)) && (bo.isNullOrNil((String)localObject1)))
            {
              ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", new Object[] { parama, localObject1 });
              AppMethodBeat.o(16267);
              return null;
            }
            localObject5 = (String)paramMap.get(".sysmsg.btnlist.btn.$title");
            k = bo.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$id"), -1);
            m = bo.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$actiontype"), -1);
            localObject6 = (String)paramMap.get(".sysmsg.btnlist.btn");
            if ((bo.isNullOrNil((String)localObject5)) || (k < 0) || (m < 0))
            {
              ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", new Object[] { localObject5, Integer.valueOf(k), Integer.valueOf(m) });
              AppMethodBeat.o(16267);
              return null;
            }
            localObject4 = (String)paramMap.get(".sysmsg.btnlist.btn1.$title");
            n = bo.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$id"), -1);
            int i1 = bo.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
            paramMap = (String)paramMap.get(".sysmsg.btnlist.btn1");
            bool1 = true;
            if ((bo.isNullOrNil((String)localObject4)) || (n < 0) || (i1 < 0))
            {
              bool1 = false;
              ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", new Object[] { localObject5, Integer.valueOf(k), Integer.valueOf(m) });
            }
            localObject7 = new ik();
            localObject8 = new com.tencent.mm.protocal.b.a.b();
            ((ik)localObject7).cxM.cxN = ((com.tencent.mm.protocal.b.a.b)localObject8);
            ((com.tencent.mm.protocal.b.a.b)localObject8).id = i;
            ((com.tencent.mm.protocal.b.a.b)localObject8).title = parama;
            ((com.tencent.mm.protocal.b.a.b)localObject8).bjm = ((String)localObject1);
            ((com.tencent.mm.protocal.b.a.b)localObject8).wjT = new LinkedList();
            localObject9 = new com.tencent.mm.protocal.b.a.a();
            ((com.tencent.mm.protocal.b.a.a)localObject9).id = k;
            ((com.tencent.mm.protocal.b.a.a)localObject9).actionType = m;
            ((com.tencent.mm.protocal.b.a.a)localObject9).wjR = ((String)localObject5);
            ((com.tencent.mm.protocal.b.a.a)localObject9).wjS = ((String)localObject6);
            ((com.tencent.mm.protocal.b.a.b)localObject8).wjT.add(localObject9);
            if (bool1)
            {
              localObject5 = new com.tencent.mm.protocal.b.a.a();
              ((com.tencent.mm.protocal.b.a.a)localObject5).id = n;
              ((com.tencent.mm.protocal.b.a.a)localObject5).actionType = i1;
              ((com.tencent.mm.protocal.b.a.a)localObject5).wjR = ((String)localObject4);
              ((com.tencent.mm.protocal.b.a.a)localObject5).wjS = paramMap;
              ((com.tencent.mm.protocal.b.a.b)localObject8).wjT.add(localObject5);
            }
            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), parama, localObject1, Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject7)) });
            AppMethodBeat.o(16267);
            return null;
          }
          if ((paramString != null) && (paramString.equals("yybsigcheck")))
          {
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 14L, 1L, false);
            l1 = System.currentTimeMillis();
            paramString = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
            parama = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.wording");
            paramMap = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.url");
            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", new Object[] { paramString, parama, paramMap });
            com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4014), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
            if (bo.isNullOrNil(paramString))
            {
              ab.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 15L, 1L, false);
              com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4015), String.format("%s|%s", new Object[] { parama, paramMap }) });
              AppMethodBeat.o(16267);
              return null;
            }
            localObject1 = paramString.split(";");
            if (localObject1 == null) {}
            for (i = -1;; i = localObject1.length)
            {
              ab.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStrs len is %d", new Object[] { Integer.valueOf(i) });
              if ((localObject1 != null) && (localObject1.length != 0)) {
                break;
              }
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 16L, 1L, false);
              com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4016), paramString });
              AppMethodBeat.o(16267);
              return null;
            }
            localObject4 = new ArrayList();
            i = 0;
            if (i < localObject1.length)
            {
              localObject5 = localObject1[i];
              if (bo.isNullOrNil((String)localObject5)) {
                ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", new Object[] { Integer.valueOf(i) });
              }
              for (;;)
              {
                i += 1;
                break;
                localObject6 = ((String)localObject5).split(",");
                if (localObject6 == null) {}
                for (j = -1;; j = localObject6.length)
                {
                  ab.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is %d", new Object[] { Integer.valueOf(j) });
                  if ((localObject6 != null) && (localObject6.length == 3)) {
                    break label5288;
                  }
                  ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", new Object[] { Integer.valueOf(i) });
                  break;
                }
                try
                {
                  ((ArrayList)localObject4).add(new ai.c(localObject6[0], Integer.valueOf(localObject6[1]).intValue(), localObject6[2]));
                }
                catch (Exception localException5)
                {
                  ab.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", new Object[] { Integer.valueOf(i), localException5.getMessage() });
                  com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 17L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4017), localObject5 });
                }
              }
            }
            if (((ArrayList)localObject4).size() == 0)
            {
              ab.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 18L, 1L, false);
              com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4018), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
              AppMethodBeat.o(16267);
              return null;
            }
            if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)
            {
              bool1 = true;
              boolean bool2 = ai.a(ah.getContext(), (ArrayList)localObject4, bool1);
              ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", new Object[] { Integer.valueOf(((ArrayList)localObject4).size()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l1) });
              if (bool2) {
                break label5688;
              }
              aw.aax().setInt(46, 4);
              localObject1 = new jb();
              ((jb)localObject1).cyz.cyA = parama;
              ((jb)localObject1).cyz.url = paramMap;
              com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 20L, 1L, true);
              com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4020), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
            }
            for (;;)
            {
              AppMethodBeat.o(16267);
              return null;
              bool1 = false;
              break;
              aw.aax().setInt(46, 0);
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 19L, 1L, true);
              com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4019), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
            }
          }
          if ((paramString != null) && (paramString.equals("qy_status_notify")))
          {
            parama = (String)paramMap.get(".sysmsg.chat_id");
            paramMap.get(".sysmsg.last_create_time");
            paramString = (String)paramMap.get(".sysmsg.brand_username");
            l1 = com.tencent.mm.aj.a.e.st(parama);
            if (l1 == -1L)
            {
              ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", new Object[] { parama });
              AppMethodBeat.o(16267);
              return null;
            }
            i = com.tencent.mm.aj.z.afl().gF(l1).field_newUnReadCount;
            com.tencent.mm.aj.z.afl().gH(l1);
            paramMap = com.tencent.mm.aj.z.afk().aG(l1);
            aw.aaz();
            parama = c.YF().arH(paramString);
            if (parama == null)
            {
              ab.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", new Object[] { paramString });
              AppMethodBeat.o(16267);
              return null;
            }
            if (paramMap.kY(1))
            {
              if (parama.field_unReadMuteCount <= i)
              {
                parama.hP(0);
                aw.aaz();
                c.YF().a(parama, paramString);
                aw.getNotification().cancelNotification(paramString);
              }
              for (;;)
              {
                AppMethodBeat.o(16267);
                return null;
                parama.hP(parama.field_unReadMuteCount - i);
                aw.aaz();
                c.YF().a(parama, paramString);
              }
            }
            if (parama.field_unReadCount <= i)
            {
              aw.aaz();
              c.YF().arJ(paramString);
              aw.getNotification().cancelNotification(paramString);
            }
            for (;;)
            {
              AppMethodBeat.o(16267);
              return null;
              parama.hO(0);
              parama.hR(0);
              parama.hJ(parama.field_unReadCount - i);
              aw.aaz();
              c.YF().a(parama, paramString);
            }
          }
          if ((paramString != null) && (paramString.equals("qy_chat_update")))
          {
            parama = (String)paramMap.get(".sysmsg.chat_id");
            localObject4 = (String)paramMap.get(".sysmsg.ver");
            com.tencent.mm.aj.a.e.p((String)paramMap.get(".sysmsg.brand_username"), parama, (String)localObject4);
          }
          if ((paramString != null) && (paramString.equals("bindmobiletip")))
          {
            i = bo.getInt((String)paramMap.get(".sysmsg.bindmobiletip.forcebind"), 0);
            parama = bo.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.deviceid"));
            paramString = bo.nullAsNil((String)paramMap.get(".sysmsg.bindmobiletip.wording"));
            paramMap = new String(Base64.decode(parama.getBytes(), 0));
            parama = new String(com.tencent.mm.bv.b.bL(com.tencent.mm.compatible.e.q.LK().getBytes()).Mz(16).pW);
            ab.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", new Object[] { Integer.valueOf(i), paramMap, parama, paramString });
            if ((bo.isNullOrNil(paramMap)) || (paramMap.equals(parama)))
            {
              aw.aaz();
              c.Ru().set(ac.a.yzL, Boolean.TRUE);
              aw.aaz();
              paramMap = c.Ru();
              parama = ac.a.yzM;
              if (i != 1) {
                break label6365;
              }
            }
            for (bool1 = true;; bool1 = false)
            {
              paramMap.set(parama, Boolean.valueOf(bool1));
              aw.aaz();
              c.Ru().set(ac.a.yzN, paramString);
              AppMethodBeat.o(16267);
              return null;
            }
          }
          if ((paramString != null) && (paramString.equals("ClientCheckConsistency")))
          {
            parama = new bhk();
            parama.fMs = ((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename"));
            parama.xwy = bo.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
            parama.xwz = bo.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
            parama.wAK = bo.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
            parama.xwA = m(parama.fMs, parama.xwy, parama.xwz);
            parama.FileSize = ((int)ng(parama.fMs));
            if (!com.tencent.mm.plugin.normsg.a.b.pgQ.bXh()) {
              break label7237;
            }
            i = 1;
          }
          for (;;)
          {
            parama.xwB = i;
            parama.wLO = com.tencent.mm.compatible.e.z.LZ();
            parama.xwC = h(new Object[] { parama.fMs, Integer.valueOf(parama.xwy), Integer.valueOf(parama.xwz), Integer.valueOf(parama.wAK), parama.xwA, Integer.valueOf(parama.FileSize), Integer.valueOf(parama.xwB), Integer.valueOf(parama.wLO) });
            aw.aaz();
            c.Yz().c(new j.a(61, parama));
            if ((paramString != null) && (paramString.equals("ClientCheckHook")))
            {
              parama = new bhm();
              parama.wAK = bo.getInt((String)paramMap.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
              parama.xwE = com.tencent.mm.plugin.normsg.a.b.pgQ.jU(false);
              if (com.tencent.mm.plugin.normsg.a.b.pgQ.bXh())
              {
                i = 1;
                parama.xwB = i;
                parama.wLO = com.tencent.mm.compatible.e.z.LZ();
                parama.xwC = h(new Object[] { Integer.valueOf(parama.wAK), parama.xwE, Integer.valueOf(parama.xwB), Integer.valueOf(parama.wLO) });
                aw.aaz();
                c.Yz().c(new j.a(62, parama));
              }
            }
            else
            {
              if ((paramString != null) && (paramString.equals("ClientCheckGetAppList")))
              {
                parama = new bhl();
                parama.wAK = bo.getInt((String)paramMap.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                parama.xwD = com.tencent.mm.plugin.normsg.a.b.pgQ.bXo();
                if (!com.tencent.mm.plugin.normsg.a.b.pgQ.bXh()) {
                  break label7249;
                }
                i = 1;
                parama.xwB = i;
                parama.wLO = com.tencent.mm.compatible.e.z.LZ();
                parama.xwC = h(new Object[] { Integer.valueOf(parama.wAK), parama.xwD, Integer.valueOf(parama.xwB), Integer.valueOf(parama.wLO) });
                aw.aaz();
                c.Yz().c(new j.a(63, parama));
              }
              if ((paramString != null) && (paramString.equals("ClientCheckGetExtInfo"))) {
                com.tencent.mm.sdk.g.d.g(new f.2(this, paramMap), "syscmd_rpt_cc");
              }
              if ((!bo.isNullOrNil(paramString)) && (paramString.equals("functionmsg")))
              {
                ab.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                ((com.tencent.mm.api.q)com.tencent.mm.kernel.g.G(com.tencent.mm.api.q.class)).getReceiver().a(localException5, paramMap);
              }
              if ((!bo.isNullOrNil(paramString)) && (paramString.equals("paymsg")))
              {
                i = bo.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0);
                localObject4 = (String)paramMap.get(".sysmsg.paymsg.appmsgcontent");
                paramString = (String)paramMap.get(".sysmsg.paymsg.fromusername");
                parama = (String)paramMap.get(".sysmsg.paymsg.tousername");
                paramMap = (String)paramMap.get(".sysmsg.paymsg.paymsgid");
                ab.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", new Object[] { Integer.valueOf(i), Long.valueOf(localException5.pIG), paramString, parama, paramMap, localObject4 });
              }
            }
            try
            {
              localObject4 = URLDecoder.decode((String)localObject4, "UTF-8");
              if (!bo.isNullOrNil((String)localObject4))
              {
                localObject5 = new np();
                ((np)localObject5).cEf.type = i;
                ((np)localObject5).cEf.content = ((String)localObject4);
                ((np)localObject5).cEf.czp = paramString;
                ((np)localObject5).cEf.toUser = parama;
                ((np)localObject5).cEf.cEg = paramMap;
                com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject5);
              }
              AppMethodBeat.o(16267);
              return localObject1;
              i = 0;
              continue;
              i = 0;
              break label6702;
              i = 0;
            }
            catch (Exception paramString)
            {
              for (;;)
              {
                ab.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "", new Object[0]);
                ab.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", new Object[] { paramString.getMessage() });
              }
            }
          }
        }
      }
      label3895:
      label5688:
      label7237:
      label7249:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.f
 * JD-Core Version:    0.7.0.1
 */