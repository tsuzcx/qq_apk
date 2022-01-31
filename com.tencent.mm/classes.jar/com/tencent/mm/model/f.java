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
import com.tencent.mm.R.l;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.d;
import com.tencent.mm.ah.p;
import com.tencent.mm.api.l;
import com.tencent.mm.api.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.h.a.ig;
import com.tencent.mm.h.a.iu;
import com.tencent.mm.h.a.mt;
import com.tencent.mm.h.a.ok;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ai.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.asz;
import com.tencent.mm.protocal.c.bah;
import com.tencent.mm.protocal.c.bai;
import com.tencent.mm.protocal.c.baj;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

public final class f
  implements com.tencent.mm.plugin.messenger.foundation.a.n
{
  private long dUC = -1L;
  public f.a dUD;
  
  /* Error */
  private static String f(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 29
    //   3: invokevirtual 35	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6: ifeq +70 -> 76
    //   9: new 37	java/util/zip/ZipFile
    //   12: dup
    //   13: invokestatic 43	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   16: invokevirtual 49	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   19: getfield 55	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   22: invokespecial 58	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   25: astore 9
    //   27: aload 9
    //   29: aload 9
    //   31: aload_0
    //   32: iconst_1
    //   33: invokevirtual 62	java/lang/String:substring	(I)Ljava/lang/String;
    //   36: invokevirtual 66	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   39: invokevirtual 70	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   42: astore 8
    //   44: aload 9
    //   46: astore_0
    //   47: lload_1
    //   48: lconst_0
    //   49: lcmp
    //   50: ifle +37 -> 87
    //   53: aload_0
    //   54: astore 10
    //   56: aload 8
    //   58: astore 9
    //   60: aload 8
    //   62: lload_1
    //   63: invokevirtual 76	java/io/InputStream:skip	(J)J
    //   66: lstore 6
    //   68: lload_1
    //   69: lload 6
    //   71: lsub
    //   72: lstore_1
    //   73: goto -26 -> 47
    //   76: aload_0
    //   77: invokestatic 82	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   80: astore 8
    //   82: aconst_null
    //   83: astore_0
    //   84: goto -37 -> 47
    //   87: aload_0
    //   88: astore 10
    //   90: aload 8
    //   92: astore 9
    //   94: ldc 84
    //   96: invokestatic 90	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   99: astore 11
    //   101: aload_0
    //   102: astore 10
    //   104: aload 8
    //   106: astore 9
    //   108: sipush 2048
    //   111: newarray byte
    //   113: astore 12
    //   115: lload_3
    //   116: lconst_0
    //   117: lcmp
    //   118: ifle +60 -> 178
    //   121: aload_0
    //   122: astore 10
    //   124: aload 8
    //   126: astore 9
    //   128: aload 8
    //   130: aload 12
    //   132: iconst_0
    //   133: ldc2_w 91
    //   136: lload_3
    //   137: invokestatic 98	java/lang/Math:min	(JJ)J
    //   140: l2i
    //   141: invokevirtual 102	java/io/InputStream:read	([BII)I
    //   144: istore 5
    //   146: iload 5
    //   148: iconst_m1
    //   149: if_icmpeq +29 -> 178
    //   152: aload_0
    //   153: astore 10
    //   155: aload 8
    //   157: astore 9
    //   159: aload 11
    //   161: aload 12
    //   163: iconst_0
    //   164: iload 5
    //   166: invokevirtual 106	java/security/MessageDigest:update	([BII)V
    //   169: lload_3
    //   170: iload 5
    //   172: i2l
    //   173: lsub
    //   174: lstore_3
    //   175: goto -60 -> 115
    //   178: aload_0
    //   179: astore 10
    //   181: aload 8
    //   183: astore 9
    //   185: aload 11
    //   187: invokevirtual 110	java/security/MessageDigest:digest	()[B
    //   190: invokestatic 116	com/tencent/mm/sdk/platformtools/bk:bG	([B)Ljava/lang/String;
    //   193: astore 11
    //   195: aload 11
    //   197: astore 9
    //   199: aload 8
    //   201: ifnull +8 -> 209
    //   204: aload 8
    //   206: invokevirtual 119	java/io/InputStream:close	()V
    //   209: aload 9
    //   211: astore 8
    //   213: aload_0
    //   214: ifnull +11 -> 225
    //   217: aload_0
    //   218: invokevirtual 120	java/util/zip/ZipFile:close	()V
    //   221: aload 9
    //   223: astore 8
    //   225: aload 8
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
    //   242: ldc 122
    //   244: aload 11
    //   246: ldc 124
    //   248: iconst_0
    //   249: anewarray 4	java/lang/Object
    //   252: invokestatic 130	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: ldc 124
    //   257: astore 9
    //   259: aload 8
    //   261: ifnull +8 -> 269
    //   264: aload 8
    //   266: invokevirtual 119	java/io/InputStream:close	()V
    //   269: aload 9
    //   271: astore 8
    //   273: aload_0
    //   274: ifnull -49 -> 225
    //   277: aload_0
    //   278: invokevirtual 120	java/util/zip/ZipFile:close	()V
    //   281: ldc 124
    //   283: areturn
    //   284: astore_0
    //   285: ldc 124
    //   287: areturn
    //   288: astore_0
    //   289: aconst_null
    //   290: astore 10
    //   292: aconst_null
    //   293: astore 9
    //   295: aload 9
    //   297: ifnull +8 -> 305
    //   300: aload 9
    //   302: invokevirtual 119	java/io/InputStream:close	()V
    //   305: aload 10
    //   307: ifnull +8 -> 315
    //   310: aload 10
    //   312: invokevirtual 120	java/util/zip/ZipFile:close	()V
    //   315: aload_0
    //   316: athrow
    //   317: astore 8
    //   319: goto -110 -> 209
    //   322: astore_0
    //   323: aload 9
    //   325: areturn
    //   326: astore 8
    //   328: goto -59 -> 269
    //   331: astore 8
    //   333: goto -28 -> 305
    //   336: astore 8
    //   338: goto -23 -> 315
    //   341: astore_0
    //   342: aconst_null
    //   343: astore 8
    //   345: aload 9
    //   347: astore 10
    //   349: aload 8
    //   351: astore 9
    //   353: goto -58 -> 295
    //   356: astore_0
    //   357: goto -62 -> 295
    //   360: astore 11
    //   362: aconst_null
    //   363: astore 8
    //   365: aload 9
    //   367: astore_0
    //   368: goto -133 -> 235
    //   371: astore 11
    //   373: goto -138 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	paramString	String
    //   0	376	1	paramLong1	long
    //   0	376	3	paramLong2	long
    //   144	27	5	i	int
    //   66	4	6	l	long
    //   42	230	8	localObject1	Object
    //   317	1	8	localIOException1	java.io.IOException
    //   326	1	8	localIOException2	java.io.IOException
    //   331	1	8	localIOException3	java.io.IOException
    //   336	1	8	localIOException4	java.io.IOException
    //   343	21	8	localObject2	Object
    //   25	341	9	localObject3	Object
    //   54	294	10	localObject4	Object
    //   99	97	11	localObject5	Object
    //   228	17	11	localException1	Exception
    //   360	1	11	localException2	Exception
    //   371	1	11	localException3	Exception
    //   113	49	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	27	228	java/lang/Exception
    //   76	82	228	java/lang/Exception
    //   277	281	284	java/io/IOException
    //   0	27	288	finally
    //   76	82	288	finally
    //   204	209	317	java/io/IOException
    //   217	221	322	java/io/IOException
    //   264	269	326	java/io/IOException
    //   300	305	331	java/io/IOException
    //   310	315	336	java/io/IOException
    //   27	44	341	finally
    //   60	68	356	finally
    //   94	101	356	finally
    //   108	115	356	finally
    //   128	146	356	finally
    //   159	169	356	finally
    //   185	195	356	finally
    //   242	255	356	finally
    //   27	44	360	java/lang/Exception
    //   60	68	371	java/lang/Exception
    //   94	101	371	java/lang/Exception
    //   108	115	371	java/lang/Exception
    //   128	146	371	java/lang/Exception
    //   159	169	371	java/lang/Exception
    //   185	195	371	java/lang/Exception
  }
  
  private static String f(Object... paramVarArgs)
  {
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
          break label218;
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
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramVarArgs, "", new Object[0]);
        return "";
      }
      int j = 0;
      continue;
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", new Object[] { localObject });
      return "";
      label218:
      paramVarArgs = bk.bG(MessageDigest.getInstance("MD5").digest(localByteArrayOutputStream.toByteArray()));
      return paramVarArgs;
      i += 1;
    }
  }
  
  /* Error */
  private static long gy(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 29
    //   3: invokevirtual 35	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   6: ifeq +115 -> 121
    //   9: new 37	java/util/zip/ZipFile
    //   12: dup
    //   13: invokestatic 43	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   16: invokevirtual 49	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   19: getfield 55	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   22: invokespecial 58	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: aload_0
    //   33: iconst_1
    //   34: invokevirtual 62	java/lang/String:substring	(I)Ljava/lang/String;
    //   37: invokevirtual 66	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnonnull +12 -> 54
    //   45: aload 4
    //   47: invokevirtual 120	java/util/zip/ZipFile:close	()V
    //   50: ldc2_w 17
    //   53: lreturn
    //   54: aload 4
    //   56: astore_3
    //   57: aload_0
    //   58: invokevirtual 183	java/util/zip/ZipEntry:getSize	()J
    //   61: lstore_1
    //   62: aload 4
    //   64: invokevirtual 120	java/util/zip/ZipFile:close	()V
    //   67: lload_1
    //   68: lreturn
    //   69: astore_0
    //   70: lload_1
    //   71: lreturn
    //   72: astore 5
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: astore_3
    //   78: ldc 122
    //   80: aload 5
    //   82: ldc 124
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokestatic 130	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: aload_0
    //   92: ifnull -42 -> 50
    //   95: aload_0
    //   96: invokevirtual 120	java/util/zip/ZipFile:close	()V
    //   99: ldc2_w 17
    //   102: lreturn
    //   103: astore_0
    //   104: ldc2_w 17
    //   107: lreturn
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_3
    //   111: aload_3
    //   112: ifnull +7 -> 119
    //   115: aload_3
    //   116: invokevirtual 120	java/util/zip/ZipFile:close	()V
    //   119: aload_0
    //   120: athrow
    //   121: aload_0
    //   122: invokestatic 186	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   125: lreturn
    //   126: astore_0
    //   127: ldc2_w 17
    //   130: lreturn
    //   131: astore_3
    //   132: goto -13 -> 119
    //   135: astore_0
    //   136: goto -25 -> 111
    //   139: astore 5
    //   141: aload 4
    //   143: astore_0
    //   144: goto -68 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramString	String
    //   61	10	1	l	long
    //   29	87	3	localObject	Object
    //   131	1	3	localIOException1	java.io.IOException
    //   25	117	4	localZipFile	java.util.zip.ZipFile
    //   72	9	5	localIOException2	java.io.IOException
    //   139	1	5	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   62	67	69	java/io/IOException
    //   9	27	72	java/io/IOException
    //   95	99	103	java/io/IOException
    //   9	27	108	finally
    //   45	50	126	java/io/IOException
    //   115	119	131	java/io/IOException
    //   30	41	135	finally
    //   57	62	135	finally
    //   78	91	135	finally
    //   30	41	139	java/io/IOException
    //   57	62	139	java/io/IOException
  }
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    Object localObject6 = parama.dBs;
    Object localObject5 = aa.a(((cd)localObject6).svH);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (paramString.equals("addcontact"))
      {
        ((cd)localObject6).svH = aa.pj((String)paramMap.get(".sysmsg.addcontact.content"));
        ((cd)localObject6).kSW = 1;
        localObject1 = e.d.aB(Integer.valueOf(1));
        if (localObject1 != null) {
          break label1160;
        }
        localObject1 = null;
      }
    }
    int i;
    if ((paramString != null) && (paramString.equals("dynacfg")))
    {
      com.tencent.mm.m.g.AA().a((String)localObject5, paramMap, false);
      com.tencent.mm.m.g.AB();
      if (com.tencent.mm.m.c.Am() == 2) {
        com.tencent.mm.plugin.report.service.h.nFQ.aC(10879, "");
      }
      i = bk.getInt(com.tencent.mm.m.g.AA().getValue("MuteRoomDisable"), 0);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(i));
    }
    if ((paramString != null) && (paramString.equals("dynacfg_split"))) {
      com.tencent.mm.m.g.AA().a((String)localObject5, paramMap, true);
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
    for (;;)
    {
      Object localObject9;
      Object localObject10;
      long l1;
      try
      {
        bc.HI().a(new bb(Integer.valueOf((String)localObject2).intValue(), Integer.valueOf((String)localObject7).intValue(), (String)localObject8));
        localObject2 = (String)paramMap.get(".sysmsg.friendrecommand.fromuser");
        localObject7 = (String)paramMap.get(".sysmsg.friendrecommand.touser");
        if ((localObject2 == null) || (localObject7 == null)) {}
      }
      catch (Exception localException3)
      {
        try
        {
          au.Hx().FX().a((String)localObject7, true, null);
          localObject2 = (String)paramMap.get(".sysmsg.banner.securitybanner.chatname");
          localObject7 = (String)paramMap.get(".sysmsg.banner.securitybanner.wording");
          localObject8 = (String)paramMap.get(".sysmsg.banner.securitybanner.linkname");
          localObject9 = (String)paramMap.get(".sysmsg.banner.securitybanner.linksrc");
          localObject10 = (String)paramMap.get(".sysmsg.banner.securitybanner.showtype");
          if ((bk.bl((String)localObject2)) || (bk.bl((String)localObject10))) {}
        }
        catch (Exception localException3)
        {
          try
          {
            if (!((String)localObject10).equals("1")) {
              break label7089;
            }
            bool1 = true;
            au.Hx().FY().a((String)localObject2, bool1, new String[] { localObject7, localObject8, localObject9 });
            au.Hx().FZ().k(paramMap);
            if ((!bk.bl(paramString)) && (paramString.equals("midinfo")))
            {
              localObject2 = (String)paramMap.get(".sysmsg.midinfo.json_buffer");
              localObject7 = (String)paramMap.get(".sysmsg.midinfo.time_interval");
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", new Object[] { localObject7, localObject2, localObject5 });
              i = bk.getInt((String)localObject7, 0);
              if ((i > 86400L) && (i < 864000L))
              {
                au.Hx();
                c.Dz().o(331777, Long.valueOf(bk.UX() + i));
              }
              if (!bk.bl((String)localObject2)) {
                com.tencent.mm.plugin.report.b.d.LU((String)localObject2);
              }
            }
            if ((paramString != null) && (paramString.equals("revokemsg")))
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
              localObject1 = (String)paramMap.get(".sysmsg.revokemsg.session");
              localObject2 = (String)paramMap.get(".sysmsg.revokemsg.newmsgid");
              paramString = (String)paramMap.get(".sysmsg.revokemsg.replacemsg");
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[] { localObject2, paramString });
              l1 = 0L;
            }
          }
          catch (Exception localException3)
          {
            try
            {
              long l2 = bk.getLong((String)localObject2, 0L);
              l1 = l2;
              au.Hx();
              l1 = l2;
              paramMap = c.Fy().O((String)localObject1, l2);
              l1 = l2;
              localObject1 = bi.ak(paramMap);
              l1 = l2;
              if ((paramMap.czq & 0x4) != 4)
              {
                l1 = l2;
                paramMap.setContent(paramString);
                l1 = l2;
                paramMap.setType(10000);
                l1 = l2;
                bd.a(paramMap, parama);
                l1 = l2;
                au.Hx();
                l1 = l2;
                c.Fy().a(paramMap.field_msgId, paramMap);
              }
              l1 = l2;
              au.Hx();
              l1 = l2;
              localObject2 = c.FB().abv(paramMap.field_talker);
              if (localObject2 != null)
              {
                l1 = l2;
                if (((as)localObject2).field_unReadCount > 0)
                {
                  l1 = l2;
                  au.Hx();
                  l1 = l2;
                  i = c.Fy().S(paramMap);
                  l1 = l2;
                  if (((as)localObject2).field_unReadCount >= i)
                  {
                    l1 = l2;
                    ((ak)localObject2).fy(((as)localObject2).field_unReadCount - 1);
                    l1 = l2;
                    au.Hx();
                    l1 = l2;
                    c.FB().a((ak)localObject2, ((as)localObject2).field_username);
                  }
                }
              }
              if (parama != null)
              {
                l1 = l2;
                if (parama.ecS)
                {
                  l1 = l2;
                  localObject7 = new com.tencent.mm.storage.bb();
                  l1 = l2;
                  ((com.tencent.mm.storage.bb)localObject7).field_originSvrId = l2;
                  l1 = l2;
                  if (paramMap.field_msgId == 0L)
                  {
                    l1 = l2;
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", new Object[] { Long.valueOf(l2) });
                    l1 = l2;
                    ((com.tencent.mm.storage.bb)localObject7).field_content = ((String)localObject5);
                    l1 = l2;
                    ((com.tencent.mm.storage.bb)localObject7).field_createTime = ((cd)localObject6).mPL;
                    l1 = l2;
                    ((com.tencent.mm.storage.bb)localObject7).field_flag = bd.c(parama);
                    l1 = l2;
                    ((com.tencent.mm.storage.bb)localObject7).field_fromUserName = aa.a(((cd)localObject6).svF);
                    l1 = l2;
                    ((com.tencent.mm.storage.bb)localObject7).field_toUserName = aa.a(((cd)localObject6).svG);
                    l1 = l2;
                    ((com.tencent.mm.storage.bb)localObject7).field_newMsgId = ((cd)localObject6).ndp;
                    l1 = l2;
                    com.tencent.mm.modelmulti.n.Pn();
                    l1 = l2;
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr insert ret[%b], systemRowid[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelmulti.n.Pl().b((com.tencent.mm.sdk.e.c)localObject7)), Long.valueOf(((com.tencent.mm.storage.bb)localObject7).ujK) });
                    return null;
                    label1160:
                    localObject1 = ((com.tencent.mm.ah.e)localObject1).b(parama);
                    break;
                    localException1 = localException1;
                    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BigBallSysCmdMsgConsumer", localException1.toString());
                    continue;
                    localException2 = localException2;
                    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BigBallSysCmdMsgConsumer", localException2.toString());
                    continue;
                    localException3 = localException3;
                    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + localException3.toString());
                    continue;
                  }
                  l1 = l2;
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and has done delete info, originSvrId[%d]", new Object[] { Long.valueOf(l2) });
                  l1 = l2;
                  com.tencent.mm.modelmulti.n.Pn();
                  l1 = l2;
                  com.tencent.mm.modelmulti.n.Pl().a((com.tencent.mm.sdk.e.c)localObject7, true, new String[0]);
                  l1 = l2;
                  au.Hx();
                  l1 = l2;
                  c.Fy().fh(l2);
                  if (localException3 != null)
                  {
                    l1 = l2;
                    if (parama.dBs != null)
                    {
                      l1 = l2;
                      if (localException3.field_lastSeq == parama.dBs.svM)
                      {
                        l1 = l2;
                        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", new Object[] { Long.valueOf(localException3.field_lastSeq), Long.valueOf(localException3.field_firstUnDeliverSeq) });
                        l1 = l2;
                        au.Hx();
                        l1 = l2;
                        localObject5 = c.Fy().HB(localException3.field_username);
                        if (localObject5 != null)
                        {
                          l1 = l2;
                          localException3.bc(((cs)localObject5).field_msgSeq);
                          l1 = l2;
                          au.Hx();
                          l1 = l2;
                          i = c.FB().a(localException3, localException3.field_username);
                          l1 = l2;
                          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", new Object[] { Long.valueOf(((cs)localObject5).field_msgSvrId), Long.valueOf(((cs)localObject5).field_msgSeq), Long.valueOf(localException3.field_lastSeq), Long.valueOf(localException3.field_firstUnDeliverSeq), Integer.valueOf(i) });
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
                  if (parama.ecS) {}
                }
                else
                {
                  l1 = l2;
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summer revoke msg id is 0 and svrid[%d]", new Object[] { Long.valueOf(l2) });
                  l1 = l2;
                  au.Hx();
                  l1 = l2;
                  c.Fy().fh(l2);
                }
              }
              l1 = l2;
              parama = new ok();
              l1 = l2;
              parama.bXY.bIt = paramMap.field_msgId;
              l1 = l2;
              parama.bXY.bXZ = paramString;
              l1 = l2;
              parama.bXY.bWO = paramMap;
              l1 = l2;
              parama.bXY.bYa = ((bi)localObject1);
              l1 = l2;
              parama.bXY.bYb = l2;
              l1 = l2;
              com.tencent.mm.sdk.b.a.udP.m(parama);
              if (localObject1 != null)
              {
                l1 = l2;
                com.tencent.mm.kernel.g.DS().O(new f.3(this, (bi)localObject1));
              }
            }
            catch (Exception paramString)
            {
              com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[oneliang][revokeMsg] msgId:%d,error:%s", new Object[] { Long.valueOf(l1), paramString.toString() });
              continue;
            }
            return null;
          }
        }
      }
      int j;
      if ((paramString != null) && (paramString.equals("clouddelmsg")))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
        localObject3 = (String)paramMap.get(".sysmsg.clouddelmsg.delcommand");
        localObject1 = (String)paramMap.get(".sysmsg.clouddelmsg.msgid");
        paramMap = (String)paramMap.get(".sysmsg.clouddelmsg.fromuser");
        i = ((String)localObject5).indexOf("<msg>");
        j = ((String)localObject5).indexOf("</msg>");
        if ((i == -1) || (j == -1))
        {
          paramString = "";
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", new Object[] { localObject3, localObject1, paramMap, paramString });
        }
        for (;;)
        {
          try
          {
            au.Hx();
            paramMap = c.Fy().dS(paramMap, (String)localObject1);
            if ((paramMap == null) || (paramMap.size() <= 0))
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
              return null;
              paramString = ba.au(bn.s(((String)localObject5).substring(i, j + 6), "msg"));
              break;
            }
            paramMap = paramMap.iterator();
            if (paramMap.hasNext())
            {
              localObject5 = (bi)paramMap.next();
              if (localObject5 == null) {
                com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
              }
            }
            else
            {
              return null;
            }
          }
          catch (Exception paramString)
          {
            com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", new Object[] { localObject1, paramString.toString() });
          }
          if (((cs)localObject5).field_msgSvrId >= 0L) {
            break label2055;
          }
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((cs)localObject5).field_msgId), Long.valueOf(((cs)localObject5).field_msgSvrId) });
        }
        label2055:
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", new Object[] { Long.valueOf(((cs)localObject5).field_msgId), Long.valueOf(((cs)localObject5).field_msgSvrId) });
        i = bk.getInt((String)localObject3, 0);
        if (i == 1)
        {
          au.Hx();
          c.Fy().Y(((cs)localObject5).field_talker, ((cs)localObject5).field_msgSvrId);
        }
        for (;;)
        {
          localObject6 = new ok();
          ((ok)localObject6).bXY.bIt = ((cs)localObject5).field_msgId;
          ((ok)localObject6).bXY.bXZ = paramString;
          ((ok)localObject6).bXY.bWO = ((bi)localObject5);
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject6);
          break;
          if ((i == 2) && (((bi)localObject5).ctz()))
          {
            ((bi)localObject5).setContent(paramString);
            bd.a((bi)localObject5, parama);
            au.Hx();
            c.Fy().b(((cs)localObject5).field_msgSvrId, (bi)localObject5);
            au.Hx();
            localObject6 = c.FB().abv(((cs)localObject5).field_talker);
            if ((localObject6 != null) && (((as)localObject6).field_unReadCount > 0))
            {
              au.Hx();
              i = c.Fy().S((bi)localObject5);
              if (((as)localObject6).field_unReadCount >= i)
              {
                ((ak)localObject6).fy(((as)localObject6).field_unReadCount - 1);
                au.Hx();
                c.FB().a((ak)localObject6, ((as)localObject6).field_username);
              }
            }
          }
        }
      }
      if ((paramString != null) && (paramString.equals("updatepackage")))
      {
        localObject1 = e.d.aB(Integer.valueOf(-1879048175));
        if (localObject1 != null) {}
      }
      label2391:
      label2551:
      Object localObject4;
      label3970:
      label3978:
      label6160:
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
              localObject1 = e.d.aB(Integer.valueOf(-1879048174));
              if (localObject1 != null) {
                break label3245;
              }
              localObject1 = null;
            }
          }
          label2762:
          label2798:
          Object localObject11;
          if ((paramString != null) && (paramString.equals("delchatroommember")))
          {
            localObject3 = aa.a(((cd)localObject6).svF);
            au.Hx();
            localObject7 = c.Fy().O((String)localObject3, ((cd)localObject6).ndp);
            i = 0;
            if (((cs)localObject7).field_msgId > 0L) {
              i = 1;
            }
            ((bi)localObject7).bf(((cd)localObject6).ndp);
            if ((parama == null) || (!parama.ecS) || (!parama.ecU)) {
              ((bi)localObject7).bg(bd.o((String)localObject3, ((cd)localObject6).mPL));
            }
            ((bi)localObject7).setType(10002);
            ((bi)localObject7).setContent((String)localObject5);
            ((bi)localObject7).fA(0);
            ((bi)localObject7).ec((String)localObject3);
            ((bi)localObject7).cY(((cd)localObject6).svK);
            bd.a((bi)localObject7, parama);
            if (i == 0) {
              bd.h((bi)localObject7);
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
                if (this.dUC != ((cd)localObject6).ndp)
                {
                  this.dUC = ((cd)localObject6).ndp;
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                  localObject3 = new ce(paramMap);
                  localObject5 = (String)((ce)localObject3).dTl.get(".sysmsg.WakenPush.PushContent");
                  localObject7 = (String)((ce)localObject3).dTl.get(".sysmsg.WakenPush.Jump");
                  localObject1 = (String)((ce)localObject3).dTl.get(".sysmsg.WakenPush.ExpiredTime");
                  localObject8 = (String)((ce)localObject3).dTl.get(".sysmsg.WakenPush.Username");
                  com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", new Object[] { localObject5, localObject7, localObject1 });
                  localObject1 = com.tencent.mm.m.g.AA().getValue("WakenPushDeepLinkBitSet");
                  com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", new Object[] { localObject1 });
                  if (bk.bl((String)localObject1)) {
                    break label3280;
                  }
                  l1 = bk.getLong((String)localObject1, 0L);
                  localObject9 = com.tencent.mm.ag.b.a((String)localObject8, false, -1);
                  localObject10 = au.getNotification();
                  if (!bk.bl((String)localObject7)) {
                    break label3286;
                  }
                  com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
                  localObject1 = "com.tencent.mm.ui.LauncherUI";
                  localObject11 = new Intent();
                  ((Intent)localObject11).setClassName(ae.getContext(), (String)localObject1);
                  ((Intent)localObject11).setFlags(536870912);
                  ((Intent)localObject11).putExtra("LauncherUI.Show.Update.DialogMsg", (String)((ce)localObject3).dTl.get(".sysmsg.WakenPush.PushContent"));
                  if (!((String)localObject7).equals("weixin://dl/update_newest_version")) {
                    ((Intent)localObject11).putExtra("LauncherUI.Show.Update.Url", (String)((ce)localObject3).dTl.get(".sysmsg.WakenPush.Jump"));
                  }
                  com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 32L, 1L, true);
                  localObject1 = ((al)localObject10).a(PendingIntent.getActivity(ae.getContext(), UUID.randomUUID().hashCode(), (Intent)localObject11, 134217728), ae.getContext().getString(R.l.app_name), (String)localObject5, (String)localObject5, (Bitmap)localObject9, (String)localObject8);
                  ((Notification)localObject1).flags |= 0x10;
                  au.getNotification().a((Notification)localObject1, false);
                  com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 31L, 1L, true);
                  localObject3 = null;
                }
              }
            }
            localObject1 = localObject3;
            if (paramString == null) {
              break label3548;
            }
            localObject1 = localObject3;
            if (!paramString.equals("DisasterNotice")) {
              break label3548;
            }
            localObject7 = (String)paramMap.get(".sysmsg.NoticeId");
            localObject8 = (String)paramMap.get(".sysmsg.Content");
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", new Object[] { localObject7, localObject8 });
            localObject9 = ae.getContext().getSharedPreferences("disaster_pref", 4);
            localObject5 = ((SharedPreferences)localObject9).getString("disaster_noticeid_list_key", "");
            if (((String)localObject5).contains((CharSequence)localObject7)) {
              break label3491;
            }
            localObject10 = ((String)localObject5).split(";");
            if ((localObject10 == null) || (localObject10.length <= 10)) {
              break label3402;
            }
            localObject1 = "";
            j = localObject10.length;
            i = 0;
            label3130:
            localObject3 = localObject1;
            if (i >= j) {
              break label3406;
            }
            localObject11 = localObject10[i].split(",");
            localObject3 = localObject1;
          }
          try
          {
            if (bk.cn(bk.getLong(localObject11[0], 0L)) < 1296000L) {
              localObject3 = (String)localObject1 + localObject11[0] + "," + localObject11[1] + ";";
            }
            i += 1;
            localObject1 = localObject3;
            break label3130;
            localObject3 = ((com.tencent.mm.ah.e)localObject1).b(parama);
            continue;
            label3245:
            localObject1 = ((com.tencent.mm.ah.e)localObject1).b(parama);
            break label2391;
            au.Hx();
            c.Fy().b(((cd)localObject6).ndp, (bi)localObject7);
            break label2551;
            label3280:
            l1 = 0L;
            break label2762;
            label3286:
            if (((0x4 & l1) == 4L) && (((String)localObject7).startsWith("weixin://dl/moments")))
            {
              localObject1 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
              break label2798;
            }
            if (((l1 & 0x40000) == 262144L) && (((String)localObject7).startsWith("weixin://dl/recommendation")))
            {
              localObject1 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
              break label2798;
            }
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", new Object[] { localObject7 });
            localObject1 = "com.tencent.mm.ui.LauncherUI";
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", new Object[] { localException4 });
              localObject4 = localObject1;
            }
          }
        }
        label3402:
        localObject4 = localObject5;
        label3406:
        localObject1 = (String)localObject4 + bk.UX() + "," + (String)localObject7 + ";";
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", new Object[] { localObject5, localObject1 });
        ((SharedPreferences)localObject9).edit().putString("disaster_noticeid_list_key", (String)localObject1).commit();
        label3491:
        new ah(Looper.getMainLooper()).post(new f.1(this, (String)localObject7));
        ((cd)localObject6).svH = aa.pj((String)localObject8);
        ((cd)localObject6).kSW = 1;
        localObject1 = e.d.aB(Integer.valueOf(1));
        if (localObject1 == null)
        {
          localObject1 = null;
          label3548:
          if ((paramString == null) || (!paramString.equals("EmotionKv"))) {
            break label4021;
          }
          paramString = (String)paramMap.get(".sysmsg.EmotionKv.K");
          localObject1 = (String)paramMap.get(".sysmsg.EmotionKv.I");
          if (paramString != null) {
            break label7079;
          }
          paramString = "";
        }
        label3870:
        label4005:
        label7079:
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", new Object[] { Integer.valueOf(paramString.length()), paramString, localObject1 });
          localObject4 = com.tencent.mm.protocal.y.cph().sqr.getBytes();
          localObject5 = com.tencent.mm.protocal.y.cph().sqs.getBytes();
          paramMap = null;
          try
          {
            parama = au.Dk().edx.KR().KO();
            paramMap = parama;
          }
          catch (Exception parama)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", new Object[] { bk.j(parama) });
            }
            parama = new PByteArray();
            if (bk.bl(paramString)) {
              break label3761;
            }
          }
          if (bk.bE(paramMap))
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
            return null;
            localObject1 = ((com.tencent.mm.ah.e)localObject1).b(parama);
            break;
          }
          label3761:
          label3776:
          int k;
          label3784:
          int m;
          if ((bk.bE((byte[])localObject5)) || (bk.bE((byte[])localObject4)) || (bk.bE(paramMap))) {
            if (paramString == null)
            {
              i = -1;
              if (localObject5 != null) {
                break label3962;
              }
              j = -1;
              if (localObject4 != null) {
                break label3970;
              }
              k = -1;
              if (paramMap != null) {
                break label3978;
              }
              m = -1;
              label3791:
              com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
              label3835:
              paramString = parama.value;
              paramMap = new asz();
              if (parama.value == null) {
                break label4005;
              }
              paramMap.nFs = new String(parama.value);
              if (paramString != null) {
                break label4014;
              }
            }
          }
          label4014:
          for (i = -1;; i = paramString.length)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv res len:%d val len:%d, content[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramMap.nFs.length()), com.tencent.mm.a.g.o(paramMap.nFs.getBytes()) });
            paramMap.toE = ((String)localObject1);
            au.Hx();
            c.Fv().b(new i.a(59, paramMap));
            return null;
            i = paramString.length();
            break;
            label3962:
            j = localObject5.length;
            break label3776;
            k = localObject4.length;
            break label3784;
            m = paramMap.length;
            break label3791;
            au.Hx();
            MMProtocalJni.genClientCheckKVRes(c.CK(), paramString, (byte[])localObject4, (byte[])localObject5, paramMap, parama);
            break label3835;
            paramMap.nFs = "";
            break label3870;
          }
          label4021:
          if ((paramString != null) && (paramString.equals("globalalert")))
          {
            paramString = (String)paramMap.get(".sysmsg.uuid");
            i = bk.getInt((String)paramMap.get(".sysmsg.id"), -1);
            j = bk.getInt((String)paramMap.get(".sysmsg.important"), -1);
            if ((bk.bl(paramString)) || (i < 0) || (j < 0))
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j) });
              return null;
            }
            parama = (String)paramMap.get(".sysmsg.title");
            localObject1 = (String)paramMap.get(".sysmsg.msg");
            if ((bk.bl(parama)) && (bk.bl((String)localObject1)))
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", new Object[] { parama, localObject1 });
              return null;
            }
            localObject5 = (String)paramMap.get(".sysmsg.btnlist.btn.$title");
            k = bk.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$id"), -1);
            m = bk.getInt((String)paramMap.get(".sysmsg.btnlist.btn.$actiontype"), -1);
            localObject6 = (String)paramMap.get(".sysmsg.btnlist.btn");
            if ((bk.bl((String)localObject5)) || (k < 0) || (m < 0))
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", new Object[] { localObject5, Integer.valueOf(k), Integer.valueOf(m) });
              return null;
            }
            localObject4 = (String)paramMap.get(".sysmsg.btnlist.btn1.$title");
            int n = bk.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$id"), -1);
            int i1 = bk.getInt((String)paramMap.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
            paramMap = (String)paramMap.get(".sysmsg.btnlist.btn1");
            bool1 = true;
            if ((bk.bl((String)localObject4)) || (n < 0) || (i1 < 0))
            {
              bool1 = false;
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", new Object[] { localObject5, Integer.valueOf(k), Integer.valueOf(m) });
            }
            localObject7 = new ig();
            localObject8 = new com.tencent.mm.protocal.b.a.b();
            ((ig)localObject7).bQt.bQu = ((com.tencent.mm.protocal.b.a.b)localObject8);
            ((com.tencent.mm.protocal.b.a.b)localObject8).id = i;
            ((com.tencent.mm.protocal.b.a.b)localObject8).title = parama;
            ((com.tencent.mm.protocal.b.a.b)localObject8).bHk = ((String)localObject1);
            ((com.tencent.mm.protocal.b.a.b)localObject8).srm = new LinkedList();
            localObject9 = new com.tencent.mm.protocal.b.a.a();
            ((com.tencent.mm.protocal.b.a.a)localObject9).id = k;
            ((com.tencent.mm.protocal.b.a.a)localObject9).actionType = m;
            ((com.tencent.mm.protocal.b.a.a)localObject9).srk = ((String)localObject5);
            ((com.tencent.mm.protocal.b.a.a)localObject9).srl = ((String)localObject6);
            ((com.tencent.mm.protocal.b.a.b)localObject8).srm.add(localObject9);
            if (bool1)
            {
              localObject5 = new com.tencent.mm.protocal.b.a.a();
              ((com.tencent.mm.protocal.b.a.a)localObject5).id = n;
              ((com.tencent.mm.protocal.b.a.a)localObject5).actionType = i1;
              ((com.tencent.mm.protocal.b.a.a)localObject5).srk = ((String)localObject4);
              ((com.tencent.mm.protocal.b.a.a)localObject5).srl = paramMap;
              ((com.tencent.mm.protocal.b.a.b)localObject8).srm.add(localObject5);
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", new Object[] { paramString, Integer.valueOf(i), Integer.valueOf(j), parama, localObject1, Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject7)) });
            return null;
          }
          if ((paramString != null) && (paramString.equals("yybsigcheck")))
          {
            com.tencent.mm.plugin.report.service.h.nFQ.a(322L, 14L, 1L, false);
            l1 = System.currentTimeMillis();
            paramString = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
            parama = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.wording");
            paramMap = (String)paramMap.get(".sysmsg.yybsigcheck.yybsig.url");
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", new Object[] { paramString, parama, paramMap });
            com.tencent.mm.plugin.report.service.h.nFQ.f(11098, new Object[] { Integer.valueOf(4014), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
            if (bk.bl(paramString))
            {
              com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
              com.tencent.mm.plugin.report.service.h.nFQ.a(322L, 15L, 1L, false);
              com.tencent.mm.plugin.report.service.h.nFQ.f(11098, new Object[] { Integer.valueOf(4015), String.format("%s|%s", new Object[] { parama, paramMap }) });
              return null;
            }
            localObject1 = paramString.split(";");
            if (localObject1 == null) {}
            for (i = -1;; i = localObject1.length)
            {
              com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStrs len is %d", new Object[] { Integer.valueOf(i) });
              if ((localObject1 != null) && (localObject1.length != 0)) {
                break;
              }
              com.tencent.mm.plugin.report.service.h.nFQ.a(322L, 16L, 1L, false);
              com.tencent.mm.plugin.report.service.h.nFQ.f(11098, new Object[] { Integer.valueOf(4016), paramString });
              return null;
            }
            localObject4 = new ArrayList();
            i = 0;
            if (i < localObject1.length)
            {
              localObject5 = localObject1[i];
              if (bk.bl((String)localObject5)) {
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", new Object[] { Integer.valueOf(i) });
              }
              for (;;)
              {
                i += 1;
                break;
                localObject6 = ((String)localObject5).split(",");
                if (localObject6 == null) {}
                for (j = -1;; j = localObject6.length)
                {
                  com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is %d", new Object[] { Integer.valueOf(j) });
                  if ((localObject6 != null) && (localObject6.length == 3)) {
                    break label5124;
                  }
                  com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", new Object[] { Integer.valueOf(i) });
                  break;
                }
                try
                {
                  ((ArrayList)localObject4).add(new ai.c(localObject6[0], Integer.valueOf(localObject6[1]).intValue(), localObject6[2]));
                }
                catch (Exception localException5)
                {
                  com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", new Object[] { Integer.valueOf(i), localException5.getMessage() });
                  com.tencent.mm.plugin.report.service.h.nFQ.a(322L, 17L, 1L, false);
                  com.tencent.mm.plugin.report.service.h.nFQ.f(11098, new Object[] { Integer.valueOf(4017), localObject5 });
                }
              }
            }
            if (((ArrayList)localObject4).size() == 0)
            {
              com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
              com.tencent.mm.plugin.report.service.h.nFQ.a(322L, 18L, 1L, false);
              com.tencent.mm.plugin.report.service.h.nFQ.f(11098, new Object[] { Integer.valueOf(4018), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
              return null;
            }
            if (bk.getInt(com.tencent.mm.m.g.AA().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)
            {
              bool1 = true;
              boolean bool2 = com.tencent.mm.platformtools.ai.a(ae.getContext(), (ArrayList)localObject4, bool1);
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", new Object[] { Integer.valueOf(((ArrayList)localObject4).size()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l1) });
              if (bool2) {
                break label5512;
              }
              au.Hv().setInt(46, 4);
              localObject1 = new iu();
              ((iu)localObject1).bQY.bQZ = parama;
              ((iu)localObject1).bQY.url = paramMap;
              com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
              com.tencent.mm.plugin.report.service.h.nFQ.a(322L, 20L, 1L, true);
              com.tencent.mm.plugin.report.service.h.nFQ.f(11098, new Object[] { Integer.valueOf(4020), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
            }
            for (;;)
            {
              return null;
              bool1 = false;
              break;
              au.Hv().setInt(46, 0);
              com.tencent.mm.plugin.report.service.h.nFQ.a(322L, 19L, 1L, true);
              com.tencent.mm.plugin.report.service.h.nFQ.f(11098, new Object[] { Integer.valueOf(4019), String.format("%s|%s|%s", new Object[] { paramString, parama, paramMap }) });
            }
          }
          if ((paramString != null) && (paramString.equals("qy_status_notify")))
          {
            parama = (String)paramMap.get(".sysmsg.chat_id");
            paramMap.get(".sysmsg.last_create_time");
            paramString = (String)paramMap.get(".sysmsg.brand_username");
            l1 = com.tencent.mm.ai.a.e.lx(parama);
            if (l1 == -1L)
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", new Object[] { parama });
              return null;
            }
            i = com.tencent.mm.ai.z.MB().bK(l1).field_newUnReadCount;
            com.tencent.mm.ai.z.MB().bM(l1);
            paramMap = com.tencent.mm.ai.z.MA().aj(l1);
            au.Hx();
            parama = c.FB().abv(paramString);
            if (parama == null)
            {
              com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", new Object[] { paramString });
              return null;
            }
            if (paramMap.il(1))
            {
              if (parama.field_unReadMuteCount <= i)
              {
                parama.fE(0);
                au.Hx();
                c.FB().a(parama, paramString);
                au.getNotification().cancelNotification(paramString);
              }
              for (;;)
              {
                return null;
                parama.fE(parama.field_unReadMuteCount - i);
                au.Hx();
                c.FB().a(parama, paramString);
              }
            }
            if (parama.field_unReadCount <= i)
            {
              au.Hx();
              c.FB().abx(paramString);
              au.getNotification().cancelNotification(paramString);
            }
            for (;;)
            {
              return null;
              parama.fD(0);
              parama.fG(0);
              parama.fy(parama.field_unReadCount - i);
              au.Hx();
              c.FB().a(parama, paramString);
            }
          }
          if ((paramString != null) && (paramString.equals("qy_chat_update")))
          {
            parama = (String)paramMap.get(".sysmsg.chat_id");
            localObject4 = (String)paramMap.get(".sysmsg.ver");
            com.tencent.mm.ai.a.e.n((String)paramMap.get(".sysmsg.brand_username"), parama, (String)localObject4);
          }
          if ((paramString != null) && (paramString.equals("bindmobiletip")))
          {
            i = bk.getInt((String)paramMap.get(".sysmsg.bindmobiletip.forcebind"), 0);
            parama = bk.pm((String)paramMap.get(".sysmsg.bindmobiletip.deviceid"));
            paramString = bk.pm((String)paramMap.get(".sysmsg.bindmobiletip.wording"));
            paramMap = new String(Base64.decode(parama.getBytes(), 0));
            parama = new String(com.tencent.mm.bv.b.bk(q.zg().getBytes()).EB(16).oY);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", new Object[] { Integer.valueOf(i), paramMap, parama, paramString });
            if ((bk.bl(paramMap)) || (paramMap.equals(parama)))
            {
              au.Hx();
              c.Dz().c(ac.a.upL, Boolean.valueOf(true));
              au.Hx();
              paramMap = c.Dz();
              parama = ac.a.upM;
              if (i != 1) {
                break label6160;
              }
            }
            for (bool1 = true;; bool1 = false)
            {
              paramMap.c(parama, Boolean.valueOf(bool1));
              au.Hx();
              c.Dz().c(ac.a.upN, paramString);
              return null;
            }
          }
          if ((paramString != null) && (paramString.equals("ClientCheckConsistency")))
          {
            parama = new bah();
            parama.ewD = ((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename"));
            parama.twk = bk.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
            parama.twl = bk.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
            parama.sEE = bk.getInt((String)paramMap.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
            parama.twm = f(parama.ewD, parama.twk, parama.twl);
            parama.ndo = ((int)gy(parama.ewD));
            if (!com.tencent.mm.plugin.normsg.a.b.mGK.boG()) {
              break label7026;
            }
            i = 1;
          }
          for (;;)
          {
            parama.twn = i;
            parama.sNU = w.zx();
            parama.two = f(new Object[] { parama.ewD, Integer.valueOf(parama.twk), Integer.valueOf(parama.twl), Integer.valueOf(parama.sEE), parama.twm, Integer.valueOf(parama.ndo), Integer.valueOf(parama.twn), Integer.valueOf(parama.sNU) });
            au.Hx();
            c.Fv().b(new i.a(61, parama));
            if ((paramString != null) && (paramString.equals("ClientCheckHook")))
            {
              parama = new baj();
              parama.sEE = bk.getInt((String)paramMap.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
              parama.twq = com.tencent.mm.plugin.normsg.a.b.mGK.hY(false);
              if (com.tencent.mm.plugin.normsg.a.b.mGK.boG())
              {
                i = 1;
                label6497:
                parama.twn = i;
                parama.sNU = w.zx();
                parama.two = f(new Object[] { Integer.valueOf(parama.sEE), parama.twq, Integer.valueOf(parama.twn), Integer.valueOf(parama.sNU) });
                au.Hx();
                c.Fv().b(new i.a(62, parama));
              }
            }
            else
            {
              if ((paramString != null) && (paramString.equals("ClientCheckGetAppList")))
              {
                parama = new bai();
                parama.sEE = bk.getInt((String)paramMap.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                parama.twp = com.tencent.mm.plugin.normsg.a.b.mGK.boN();
                if (!com.tencent.mm.plugin.normsg.a.b.mGK.boG()) {
                  break label7038;
                }
                i = 1;
                parama.twn = i;
                parama.sNU = w.zx();
                parama.two = f(new Object[] { Integer.valueOf(parama.sEE), parama.twp, Integer.valueOf(parama.twn), Integer.valueOf(parama.sNU) });
                au.Hx();
                c.Fv().b(new i.a(63, parama));
              }
              if ((paramString != null) && (paramString.equals("ClientCheckGetExtInfo"))) {
                com.tencent.mm.sdk.f.e.a(new f.2(this, paramMap), "syscmd_rpt_cc");
              }
              if ((!bk.bl(paramString)) && (paramString.equals("functionmsg")))
              {
                com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                ((o)com.tencent.mm.kernel.g.t(o.class)).getReceiver().a(localException5, paramMap);
              }
              if ((!bk.bl(paramString)) && (paramString.equals("paymsg")))
              {
                i = bk.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0);
                localObject4 = (String)paramMap.get(".sysmsg.paymsg.appmsgcontent");
                paramString = (String)paramMap.get(".sysmsg.paymsg.fromusername");
                parama = (String)paramMap.get(".sysmsg.paymsg.tousername");
                paramMap = (String)paramMap.get(".sysmsg.paymsg.paymsgid");
                com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", new Object[] { Integer.valueOf(i), Long.valueOf(localException5.ndp), paramString, parama, paramMap, localObject4 });
              }
            }
            try
            {
              localObject4 = URLDecoder.decode((String)localObject4, "UTF-8");
              if (!bk.bl((String)localObject4))
              {
                localObject5 = new mt();
                ((mt)localObject5).bWs.type = i;
                ((mt)localObject5).bWs.content = ((String)localObject4);
                ((mt)localObject5).bWs.bRO = paramString;
                ((mt)localObject5).bWs.toUser = parama;
                ((mt)localObject5).bWs.bWt = paramMap;
                com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject5);
              }
              return localObject1;
              label7026:
              i = 0;
              continue;
              i = 0;
              break label6497;
              label7038:
              i = 0;
            }
            catch (Exception paramString)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", paramString, "", new Object[0]);
                com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", new Object[] { paramString.getMessage() });
              }
            }
          }
        }
      }
      label5124:
      label5512:
      label7089:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.f
 * JD-Core Version:    0.7.0.1
 */