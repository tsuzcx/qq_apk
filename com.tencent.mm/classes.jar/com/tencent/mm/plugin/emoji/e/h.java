package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.az.f;
import com.tencent.mm.h.a.be;
import com.tencent.mm.h.a.be.a;
import com.tencent.mm.h.a.cq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.j;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class h
{
  private static String iWK = "";
  private static String iWL = "temp";
  static String iWM = "newemoji";
  private static String iWN = "panel";
  public static String iWO = "suggest";
  public static String iWP = "egg";
  private static String iWQ = "search";
  private static String iWR = "config.conf";
  private static String iWS = "emojipanel.zip";
  private static String iWT = "newemoji.zip";
  private static String iWU = "emoji_template.zip";
  private static String iWV = "emojisuggest.zip";
  private static String iWW = "egg.zip";
  private static String iWX = "newemoji-config.xml";
  private static String iWY = "emojipanel-config.xml";
  public static String iWZ = "emojisuggest-config.xml";
  public static String iXa = "egg.xml";
  private static int iXb = 0;
  private static int iXc = 0;
  private static int iXd = 0;
  private static int iXe = 0;
  private static h iXf;
  public f iXg;
  
  public static void a(be parambe, boolean paramBoolean)
  {
    if ((paramBoolean) || (a(parambe, h.a.iXi)))
    {
      if ((a(parambe, h.a.iXi, iWM)) || (paramBoolean))
      {
        parambe = new com.tencent.mm.vfs.b(new com.tencent.mm.vfs.b(getDataEmojiPath(), iWM), iWX);
        if (parambe.exists())
        {
          parambe = com.tencent.mm.u.b.a.a(parambe);
          if ((!parambe.isEmpty()) && (((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().r(parambe)))
          {
            parambe = new cq();
            parambe.bIP.brC = 1;
            com.tencent.mm.sdk.b.a.udP.m(parambe);
            iXb = f(new com.tencent.mm.vfs.b(getDataEmojiPath() + "/" + iWM, iWR));
            g.DP().Dz().c(ac.a.uon, Integer.valueOf(iXb));
          }
          return;
        }
        y.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji config don't exist.");
        return;
      }
      y.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji unzip file failed.");
      return;
    }
    y.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji need no update.");
  }
  
  public static boolean a(be parambe, h.a parama)
  {
    int j;
    int i;
    if (a(parambe, parama, iWL))
    {
      parambe = new com.tencent.mm.vfs.b(getDataEmojiPath(), iWL);
      y.d("MicroMsg.emoji.EmojiResUpdateMgr", "readVersionCode unzip file done.");
      j = f(new com.tencent.mm.vfs.b(parambe, iWR));
      switch (h.1.iXh[parama.ordinal()])
      {
      default: 
        i = -1;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.emoji.EmojiResUpdateMgr", "file version:%d, current version:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      if ((j == -1) || (i >= j)) {
        break label279;
      }
      return true;
      y.i("MicroMsg.emoji.EmojiResUpdateMgr", "unzip file failed. type:%s", new Object[] { String.valueOf(parama) });
      j = -1;
      break;
      i = ((Integer)g.DP().Dz().get(ac.a.uon, Integer.valueOf(0))).intValue();
      iXb = i;
      continue;
      i = ((Integer)g.DP().Dz().get(ac.a.uoo, Integer.valueOf(0))).intValue();
      iXc = i;
      continue;
      i = com.tencent.mm.an.a.ekB;
      continue;
      i = ((Integer)g.DP().Dz().get(ac.a.uop, Integer.valueOf(0))).intValue();
      iXd = i;
      continue;
      i = ((Integer)g.DP().Dz().get(ac.a.uoq, Integer.valueOf(0))).intValue();
      iXe = i;
    }
    label279:
    return false;
  }
  
  public static boolean a(be parambe, h.a parama, String paramString)
  {
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(parambe.bHu.filePath);
    if ((localb.exists()) && (localb.length() > 0L))
    {
      long l = System.currentTimeMillis();
      y.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile start. type:%s filePath:%s", new Object[] { String.valueOf(parama), j.n(localb.cLr()) });
      paramString = new com.tencent.mm.vfs.b(getDataEmojiPath(), paramString);
      if (paramString.exists()) {
        com.tencent.mm.vfs.e.K(j.n(paramString.mUri), true);
      }
      switch (h.1.iXh[parama.ordinal()])
      {
      default: 
        y.w("MicroMsg.emoji.EmojiResUpdateMgr", "unknown type. type:%s", new Object[] { String.valueOf(parama) });
        parambe = "";
      }
      for (;;)
      {
        parambe = new com.tencent.mm.vfs.b(paramString, parambe);
        paramString.mkdirs();
        com.tencent.mm.vfs.e.r(j.n(localb.cLr()), j.n(parambe.cLr()));
        int i = bk.gh(j.n(parambe.cLr()), j.n(paramString.cLr()));
        com.tencent.mm.vfs.e.deleteFile(j.n(parambe.mUri));
        y.d("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile done. user time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        if (i < 0) {
          break;
        }
        return true;
        parambe = iWT;
        continue;
        parambe = iWS;
        continue;
        parambe = iWU;
        continue;
        parambe = iWV;
        continue;
        parambe = iWW;
      }
      return false;
    }
    y.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile update file don't exist.");
    return false;
  }
  
  public static String aHk()
  {
    String str2 = l.aHE();
    String str1 = str2;
    if (bk.bl(str2)) {
      str1 = (String)g.DP().Dz().get(ac.a.uor, iWY);
    }
    return str1;
  }
  
  public static h aHx()
  {
    if (iXf == null) {}
    try
    {
      iXf = new h();
      return iXf;
    }
    finally {}
  }
  
  public static void b(be parambe, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if ((!paramBoolean) && (!a(parambe, h.a.iXj)))
    {
      localObject1 = (String)g.DP().Dz().get(ac.a.uor, iWY);
      localObject2 = l.aHE();
      if ((!bk.bl((String)localObject2)) && (!((String)localObject1).equalsIgnoreCase((String)localObject2)))
      {
        i = 1;
        if (i == 0) {
          break label342;
        }
      }
    }
    else
    {
      if ((!a(parambe, h.a.iXj, iWN)) && (!paramBoolean)) {
        break label333;
      }
      localObject2 = new com.tencent.mm.vfs.b(getDataEmojiPath(), iWN);
      localObject1 = l.aHE();
      if (!bk.bl((String)localObject1)) {
        break label272;
      }
      parambe = iWY;
      y.i("MicroMsg.emoji.EmojiResUpdateMgr", "no dynamic config panel file name. use default.");
      label116:
      localObject1 = new com.tencent.mm.vfs.b((com.tencent.mm.vfs.b)localObject2, parambe);
      if (!((com.tencent.mm.vfs.b)localObject1).exists()) {
        break label324;
      }
      localObject1 = com.tencent.mm.u.b.a.b((com.tencent.mm.vfs.b)localObject1);
      if (((ArrayList)localObject1).isEmpty()) {
        break label313;
      }
      if (((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().s((ArrayList)localObject1))
      {
        localObject1 = new cq();
        ((cq)localObject1).bIP.brC = 2;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        iXc = f(new com.tencent.mm.vfs.b(getDataEmojiPath() + "/" + iWN, iWR));
        g.DP().Dz().c(ac.a.uoo, Integer.valueOf(iXc));
      }
    }
    for (;;)
    {
      g.DP().Dz().c(ac.a.uor, parambe);
      return;
      i = 0;
      break;
      label272:
      parambe = (be)localObject1;
      if (!new com.tencent.mm.vfs.b((com.tencent.mm.vfs.b)localObject2, (String)localObject1).exists()) {
        parambe = iWY;
      }
      y.i("MicroMsg.emoji.EmojiResUpdateMgr", "dynamic config panel file name :%s", new Object[] { parambe });
      break label116;
      label313:
      y.i("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiPanelConfigFromFile smiley panel list is null.");
    }
    label324:
    y.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel config don't exist.");
    return;
    label333:
    y.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel unzip file failed.");
    return;
    label342:
    y.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel need no update.");
  }
  
  public static boolean b(be parambe)
  {
    long l1 = System.currentTimeMillis();
    com.tencent.mm.cd.b.csC();
    com.tencent.mm.cd.b.csF();
    long l2 = com.tencent.mm.cd.b.csC().ukJ;
    com.tencent.mm.cd.b.csC();
    int i = com.tencent.mm.cd.b.aar(parambe.bHu.filePath);
    com.tencent.mm.cd.b.csC();
    long l3 = com.tencent.mm.cd.b.aaq(parambe.bHu.filePath);
    y.i("MicroMsg.emoji.EmojiResUpdateMgr", "currentSupportVersion:%d current version:%d supportVersion:%d file version:%d use time:%d", new Object[] { Integer.valueOf(1), Long.valueOf(l2), Integer.valueOf(i), Long.valueOf(l3), Long.valueOf(System.currentTimeMillis() - l1) });
    if ((i == 1) && (l3 > l2)) {
      return true;
    }
    y.i("MicroMsg.emoji.EmojiResUpdateMgr", "need not update color emoji");
    return false;
  }
  
  /* Error */
  private static int f(com.tencent.mm.vfs.b paramb)
  {
    // Byte code:
    //   0: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: iconst_m1
    //   5: istore_2
    //   6: aload_0
    //   7: invokevirtual 143	com/tencent/mm/vfs/b:exists	()Z
    //   10: ifeq +284 -> 294
    //   13: new 446	com/tencent/mm/vfs/d
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 449	com/tencent/mm/vfs/d:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   21: astore 7
    //   23: new 451	java/io/InputStreamReader
    //   26: dup
    //   27: aload 7
    //   29: invokespecial 454	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   32: astore 6
    //   34: new 456	java/io/BufferedReader
    //   37: dup
    //   38: aload 6
    //   40: invokespecial 459	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_0
    //   44: ldc 37
    //   46: astore 5
    //   48: aload_0
    //   49: astore 10
    //   51: aload 6
    //   53: astore 9
    //   55: aload 7
    //   57: astore 8
    //   59: iload_2
    //   60: istore_1
    //   61: aload_0
    //   62: invokevirtual 462	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore 11
    //   67: aload 11
    //   69: ifnull +41 -> 110
    //   72: aload_0
    //   73: astore 10
    //   75: aload 6
    //   77: astore 9
    //   79: aload 7
    //   81: astore 8
    //   83: iload_2
    //   84: istore_1
    //   85: new 195	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   92: aload 5
    //   94: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload 11
    //   99: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore 5
    //   107: goto -59 -> 48
    //   110: aload_0
    //   111: astore 10
    //   113: aload 6
    //   115: astore 9
    //   117: aload 7
    //   119: astore 8
    //   121: iload_2
    //   122: istore_1
    //   123: new 464	org/json/JSONObject
    //   126: dup
    //   127: aload 5
    //   129: invokespecial 465	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   132: ldc_w 467
    //   135: invokevirtual 470	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   138: istore_2
    //   139: aload_0
    //   140: astore 10
    //   142: aload 6
    //   144: astore 9
    //   146: aload 7
    //   148: astore 8
    //   150: iload_2
    //   151: istore_1
    //   152: ldc 239
    //   154: ldc_w 472
    //   157: iconst_2
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload 5
    //   165: aastore
    //   166: dup
    //   167: iconst_1
    //   168: iload_2
    //   169: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: aastore
    //   173: invokestatic 373	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload 7
    //   178: invokestatic 475	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   181: aload 6
    //   183: invokestatic 475	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   186: aload_0
    //   187: invokestatic 475	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   190: ldc 239
    //   192: ldc_w 477
    //   195: iconst_1
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   204: lload_3
    //   205: lsub
    //   206: invokestatic 371	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   209: aastore
    //   210: invokestatic 270	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: iload_2
    //   214: ireturn
    //   215: astore 5
    //   217: aconst_null
    //   218: astore_0
    //   219: aconst_null
    //   220: astore 6
    //   222: aconst_null
    //   223: astore 7
    //   225: iload_2
    //   226: istore_1
    //   227: aload_0
    //   228: astore 10
    //   230: aload 6
    //   232: astore 9
    //   234: aload 7
    //   236: astore 8
    //   238: ldc 239
    //   240: aload 5
    //   242: invokestatic 481	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   245: invokestatic 484	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload 7
    //   250: invokestatic 475	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   253: aload 6
    //   255: invokestatic 475	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   258: aload_0
    //   259: invokestatic 475	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   262: iload_1
    //   263: istore_2
    //   264: goto -74 -> 190
    //   267: astore_0
    //   268: aconst_null
    //   269: astore 5
    //   271: aconst_null
    //   272: astore 6
    //   274: aconst_null
    //   275: astore 7
    //   277: aload 7
    //   279: invokestatic 475	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   282: aload 6
    //   284: invokestatic 475	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   287: aload 5
    //   289: invokestatic 475	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   292: aload_0
    //   293: athrow
    //   294: ldc 239
    //   296: ldc_w 486
    //   299: iconst_1
    //   300: anewarray 4	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: aload_0
    //   306: invokevirtual 327	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   309: invokestatic 333	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   312: aastore
    //   313: invokestatic 270	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: goto -126 -> 190
    //   319: astore_0
    //   320: aconst_null
    //   321: astore 5
    //   323: aconst_null
    //   324: astore 6
    //   326: goto -49 -> 277
    //   329: astore_0
    //   330: aconst_null
    //   331: astore 5
    //   333: goto -56 -> 277
    //   336: astore_0
    //   337: aload 10
    //   339: astore 5
    //   341: aload 9
    //   343: astore 6
    //   345: aload 8
    //   347: astore 7
    //   349: goto -72 -> 277
    //   352: astore 5
    //   354: aconst_null
    //   355: astore_0
    //   356: aconst_null
    //   357: astore 6
    //   359: iload_2
    //   360: istore_1
    //   361: goto -134 -> 227
    //   364: astore 5
    //   366: aconst_null
    //   367: astore_0
    //   368: iload_2
    //   369: istore_1
    //   370: goto -143 -> 227
    //   373: astore 5
    //   375: goto -148 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramb	com.tencent.mm.vfs.b
    //   60	310	1	i	int
    //   5	364	2	j	int
    //   3	202	3	l	long
    //   46	118	5	str1	String
    //   215	26	5	localException1	Exception
    //   269	71	5	localObject1	Object
    //   352	1	5	localException2	Exception
    //   364	1	5	localException3	Exception
    //   373	1	5	localException4	Exception
    //   32	326	6	localObject2	Object
    //   21	327	7	localObject3	Object
    //   57	289	8	localObject4	Object
    //   53	289	9	localObject5	Object
    //   49	289	10	localb	com.tencent.mm.vfs.b
    //   65	33	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   13	23	215	java/lang/Exception
    //   13	23	267	finally
    //   23	34	319	finally
    //   34	44	329	finally
    //   61	67	336	finally
    //   85	107	336	finally
    //   123	139	336	finally
    //   152	176	336	finally
    //   238	248	336	finally
    //   23	34	352	java/lang/Exception
    //   34	44	364	java/lang/Exception
    //   61	67	373	java/lang/Exception
    //   85	107	373	java/lang/Exception
    //   123	139	373	java/lang/Exception
    //   152	176	373	java/lang/Exception
  }
  
  /* Error */
  public static void g(com.tencent.mm.vfs.b paramb)
  {
    // Byte code:
    //   0: invokestatic 495	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   3: astore 7
    //   5: aload_0
    //   6: invokestatic 499	com/tencent/mm/vfs/e:o	(Lcom/tencent/mm/vfs/b;)Ljava/io/InputStream;
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 5
    //   14: aload 7
    //   16: invokevirtual 503	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   19: aload 6
    //   21: invokevirtual 509	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   24: astore_0
    //   25: aload_0
    //   26: invokeinterface 514 1 0
    //   31: aload_0
    //   32: invokeinterface 518 1 0
    //   37: ldc_w 520
    //   40: invokeinterface 526 2 0
    //   45: astore_0
    //   46: aload_0
    //   47: ifnull +248 -> 295
    //   50: aload_0
    //   51: invokeinterface 531 1 0
    //   56: ifle +239 -> 295
    //   59: aload_0
    //   60: invokeinterface 531 1 0
    //   65: istore_3
    //   66: new 150	java/util/ArrayList
    //   69: dup
    //   70: invokespecial 532	java/util/ArrayList:<init>	()V
    //   73: astore 7
    //   75: iconst_0
    //   76: istore_1
    //   77: iload_1
    //   78: iload_3
    //   79: if_icmpge +143 -> 222
    //   82: aload_0
    //   83: iload_1
    //   84: invokeinterface 536 2 0
    //   89: invokeinterface 542 1 0
    //   94: astore 8
    //   96: aload 8
    //   98: ifnull +283 -> 381
    //   101: aload 8
    //   103: invokeinterface 531 1 0
    //   108: ifle +273 -> 381
    //   111: aload 8
    //   113: invokeinterface 531 1 0
    //   118: istore 4
    //   120: new 150	java/util/ArrayList
    //   123: dup
    //   124: invokespecial 532	java/util/ArrayList:<init>	()V
    //   127: astore 9
    //   129: iconst_0
    //   130: istore_2
    //   131: iload_2
    //   132: iload 4
    //   134: if_icmpge +77 -> 211
    //   137: aload 8
    //   139: iload_2
    //   140: invokeinterface 536 2 0
    //   145: astore 10
    //   147: aload 10
    //   149: invokeinterface 545 1 0
    //   154: ldc_w 547
    //   157: invokevirtual 551	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifeq +214 -> 374
    //   163: aload 10
    //   165: invokeinterface 554 1 0
    //   170: astore 10
    //   172: aload 10
    //   174: invokestatic 384	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   177: ifne +197 -> 374
    //   180: ldc 239
    //   182: ldc_w 556
    //   185: iconst_1
    //   186: anewarray 4	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: aload 10
    //   193: aastore
    //   194: invokestatic 373	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload 9
    //   199: aload 10
    //   201: invokevirtual 559	java/lang/String:trim	()Ljava/lang/String;
    //   204: invokevirtual 562	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   207: pop
    //   208: goto +166 -> 374
    //   211: aload 7
    //   213: aload 9
    //   215: invokevirtual 562	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   218: pop
    //   219: goto +162 -> 381
    //   222: invokestatic 568	com/tencent/mm/plugin/emoji/model/i:getEmojiStorageMgr	()Lcom/tencent/mm/storage/at;
    //   225: getfield 574	com/tencent/mm/storage/at:uBl	Lcom/tencent/mm/storage/emotion/f;
    //   228: aload 7
    //   230: invokevirtual 579	com/tencent/mm/storage/emotion/f:af	(Ljava/util/ArrayList;)Z
    //   233: pop
    //   234: new 129	com/tencent/mm/vfs/b
    //   237: dup
    //   238: new 195	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   245: invokestatic 133	com/tencent/mm/plugin/emoji/e/h:getDataEmojiPath	()Ljava/lang/String;
    //   248: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc 202
    //   253: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: getstatic 55	com/tencent/mm/plugin/emoji/e/h:iWO	Ljava/lang/String;
    //   259: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: getstatic 67	com/tencent/mm/plugin/emoji/e/h:iWR	Ljava/lang/String;
    //   268: invokespecial 136	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: invokestatic 209	com/tencent/mm/plugin/emoji/e/h:f	(Lcom/tencent/mm/vfs/b;)I
    //   274: putstatic 109	com/tencent/mm/plugin/emoji/e/h:iXd	I
    //   277: invokestatic 213	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   280: invokevirtual 219	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   283: getstatic 295	com/tencent/mm/storage/ac$a:uop	Lcom/tencent/mm/storage/ac$a;
    //   286: getstatic 109	com/tencent/mm/plugin/emoji/e/h:iXd	I
    //   289: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   292: invokevirtual 237	com/tencent/mm/storage/z:c	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)V
    //   295: aload 6
    //   297: ifnull +8 -> 305
    //   300: aload 6
    //   302: invokevirtual 584	java/io/InputStream:close	()V
    //   305: return
    //   306: astore 5
    //   308: aload 5
    //   310: athrow
    //   311: astore_0
    //   312: aload 6
    //   314: ifnull +13 -> 327
    //   317: aload 5
    //   319: ifnull +43 -> 362
    //   322: aload 6
    //   324: invokevirtual 584	java/io/InputStream:close	()V
    //   327: aload_0
    //   328: athrow
    //   329: astore_0
    //   330: ldc 239
    //   332: ldc_w 586
    //   335: iconst_1
    //   336: anewarray 4	java/lang/Object
    //   339: dup
    //   340: iconst_0
    //   341: aload_0
    //   342: invokevirtual 587	java/lang/Exception:toString	()Ljava/lang/String;
    //   345: aastore
    //   346: invokestatic 589	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: return
    //   350: astore 6
    //   352: aload 5
    //   354: aload 6
    //   356: invokevirtual 593	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   359: goto -32 -> 327
    //   362: aload 6
    //   364: invokevirtual 584	java/io/InputStream:close	()V
    //   367: goto -40 -> 327
    //   370: astore_0
    //   371: goto -59 -> 312
    //   374: iload_2
    //   375: iconst_1
    //   376: iadd
    //   377: istore_2
    //   378: goto -247 -> 131
    //   381: iload_1
    //   382: iconst_1
    //   383: iadd
    //   384: istore_1
    //   385: goto -308 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	paramb	com.tencent.mm.vfs.b
    //   76	309	1	i	int
    //   130	248	2	j	int
    //   65	15	3	k	int
    //   118	17	4	m	int
    //   12	1	5	localObject1	Object
    //   306	47	5	localThrowable1	java.lang.Throwable
    //   9	314	6	localInputStream	java.io.InputStream
    //   350	13	6	localThrowable2	java.lang.Throwable
    //   3	226	7	localObject2	Object
    //   94	44	8	localNodeList	org.w3c.dom.NodeList
    //   127	87	9	localArrayList	ArrayList
    //   145	55	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	46	306	java/lang/Throwable
    //   50	75	306	java/lang/Throwable
    //   82	96	306	java/lang/Throwable
    //   101	129	306	java/lang/Throwable
    //   137	208	306	java/lang/Throwable
    //   211	219	306	java/lang/Throwable
    //   222	295	306	java/lang/Throwable
    //   308	311	311	finally
    //   5	11	329	java/lang/Exception
    //   300	305	329	java/lang/Exception
    //   322	327	329	java/lang/Exception
    //   327	329	329	java/lang/Exception
    //   352	359	329	java/lang/Exception
    //   362	367	329	java/lang/Exception
    //   322	327	350	java/lang/Throwable
    //   14	46	370	finally
    //   50	75	370	finally
    //   82	96	370	finally
    //   101	129	370	finally
    //   137	208	370	finally
    //   211	219	370	finally
    //   222	295	370	finally
  }
  
  public static String getDataEmojiPath()
  {
    if (bk.bl(iWK))
    {
      iWK = com.tencent.mm.compatible.util.e.dOQ.replace("/data/user/0", "/data/data");
      iWK += "/emoji";
    }
    return iWK;
  }
  
  public static void h(com.tencent.mm.vfs.b paramb)
  {
    try
    {
      paramb = com.tencent.mm.vfs.e.bP(j.n(paramb.cLr()));
      Map localMap = bn.s(paramb, "EasterEgg");
      y.i("MicroMsg.emoji.EmojiResUpdateMgr", "eggXml:" + paramb);
      if (localMap == null)
      {
        y.e("MicroMsg.emoji.EmojiResUpdateMgr", "Exception in parseXml EasterEgg, please check the xml");
        return;
      }
      f localf = new f();
      localf.ewJ = bk.ZR((String)localMap.get(".EasterEgg.$version"));
      int i = 0;
      for (;;)
      {
        Object localObject1 = new StringBuilder(".EasterEgg.Item");
        com.tencent.mm.az.d locald;
        int j;
        label537:
        Object localObject2;
        if (i == 0)
        {
          paramb = "";
          localObject1 = paramb;
          if (localMap.get((String)localObject1 + ".$name") == null) {
            break;
          }
          locald = new com.tencent.mm.az.d();
          locald.name = bk.pm((String)localMap.get((String)localObject1 + ".$name"));
          locald.ewC = bk.pm((String)localMap.get((String)localObject1 + ".$langs"));
          locald.ewz = bk.ZR((String)localMap.get((String)localObject1 + ".$reportType"));
          locald.ewA = bk.ZI((String)localMap.get((String)localObject1 + ".$BeginDate"));
          locald.ewB = bk.ZI((String)localMap.get((String)localObject1 + ".$EndDate"));
          locald.ewD = bk.pm((String)localMap.get((String)localObject1 + ".FileName"));
          locald.ewE = bk.ZR((String)localMap.get((String)localObject1 + ".AnimType"));
          locald.ewF = bk.ZR((String)localMap.get((String)localObject1 + ".AnimType.$viewcount"));
          locald.ewG = bk.ZR((String)localMap.get((String)localObject1 + ".AnimType.$minSize"));
          locald.maxSize = bk.ZR((String)localMap.get((String)localObject1 + ".AnimType.$maxSize"));
          j = 0;
          localObject2 = new StringBuilder().append((String)localObject1).append(".KeyWord");
          if (j != 0) {
            break label678;
          }
        }
        label678:
        for (paramb = "";; paramb = Integer.valueOf(j))
        {
          paramb = paramb;
          localObject2 = paramb + ".$lang";
          if (localMap.get(paramb) == null) {
            break label686;
          }
          com.tencent.mm.az.e locale = new com.tencent.mm.az.e();
          locale.ewH = bk.pm((String)localMap.get(paramb));
          locale.lang = bk.pm((String)localMap.get(localObject2));
          locald.ewx.add(locale);
          j += 1;
          break label537;
          paramb = Integer.valueOf(i);
          break;
        }
        label686:
        localf.ewI.add(locald);
        i += 1;
      }
      paramb = localf.toByteArray();
      com.tencent.mm.vfs.e.b(g.DP().cachePath + "eggingfo.ini", paramb, paramb.length);
      iXe = f(new com.tencent.mm.vfs.b(getDataEmojiPath() + "/" + iWP, iWR));
      g.DP().Dz().c(ac.a.uoq, Integer.valueOf(iXe));
      return;
    }
    catch (Exception paramb)
    {
      y.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", paramb, "", new Object[0]);
    }
  }
  
  public final f aHj()
  {
    for (;;)
    {
      try
      {
        if (this.iXg == null)
        {
          arrayOfByte = com.tencent.mm.vfs.e.c(g.DP().cachePath + "eggingfo.ini", 0, -1);
          if (arrayOfByte != null) {
            continue;
          }
          y.d("MicroMsg.emoji.EmojiResUpdateMgr", "data is null, parse EggList from config file fail");
        }
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte;
        y.w("MicroMsg.emoji.EmojiResUpdateMgr", "init crash : %s, try delete egg file", new Object[] { localException.getLocalizedMessage() });
        y.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", localException, "", new Object[0]);
        continue;
      }
      return this.iXg;
      this.iXg = ((f)new f().aH(arrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.h
 * JD-Core Version:    0.7.0.1
 */