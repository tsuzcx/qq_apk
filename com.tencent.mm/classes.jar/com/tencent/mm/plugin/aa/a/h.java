package com.tencent.mm.plugin.aa.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.af;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.aa.a.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h
{
  public static String Vs()
  {
    com.tencent.mm.kernel.g.DQ();
    return bk.pm((String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uwV, null));
  }
  
  public static double a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    try
    {
      if (bk.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim()) {
        return new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), paramInt1, paramInt2).doubleValue();
      }
      return 0.0D;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.AAUtil", paramString1, "", new Object[0]);
    }
  }
  
  private static void a(String paramString1, String paramString2, com.tencent.mm.plugin.aa.a.b.a parama, String paramString3)
  {
    try
    {
      bi localbi = new bi();
      localbi.fA(0);
      localbi.ec(paramString2);
      localbi.setStatus(3);
      localbi.setContent(paramString1);
      localbi.bg(bd.o(paramString2, System.currentTimeMillis() / 1000L));
      localbi.setType(10000);
      long l = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T(localbi);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "insertPaySysMsg, inserted msgId: %s", new Object[] { Long.valueOf(l) });
      paramString1 = parama;
      if (parama == null) {
        paramString1 = new com.tencent.mm.plugin.aa.a.b.a();
      }
      if (l > 0L)
      {
        paramString1.field_payMsgId = paramString3;
        paramString1.field_chatroom = paramString2;
        paramString1.field_insertmsg = true;
        paramString1.field_msgId = l;
        com.tencent.mm.plugin.aa.b.Vk().a(paramString1);
      }
      return;
    }
    finally {}
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong)
  {
    try
    {
      if (!bk.bl(paramString))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "insertOrUpdateAARecord, billNo: %s, insertMsg: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        com.tencent.mm.plugin.aa.a.b.c localc = new com.tencent.mm.plugin.aa.a.b.c();
        localc.field_billNo = paramString;
        localc.field_insertmsg = paramBoolean;
        localc.field_localMsgId = paramLong;
        com.tencent.mm.plugin.aa.b.Vj().b(localc);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean a(Activity paramActivity, com.tencent.mm.protocal.c.y paramy)
  {
    if (paramy.ssk == 1)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "need realname verify");
      Bundle localBundle = new Bundle();
      localBundle.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
      localBundle.putString("realname_verify_process_jump_plugin", "aa");
      String str = paramy.lRD;
      str = paramy.lRE;
      paramy = paramy.lRF;
      return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, localBundle, null, 0);
    }
    if (paramy.ssk == 2)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "need upload credit");
      return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramy.lRD, paramy.lRG, paramy.lRE, paramy.lRF, false, null);
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "realnameGuideFlag =  " + paramy.ssk);
    return false;
  }
  
  /* Error */
  private static void aP(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: invokestatic 182	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   9: ifne +122 -> 131
    //   12: aload_0
    //   13: invokestatic 276	com/tencent/mm/ae/g$a:gp	(Ljava/lang/String;)Lcom/tencent/mm/ae/g$a;
    //   16: astore 5
    //   18: aload 5
    //   20: ifnull +111 -> 131
    //   23: aload 5
    //   25: getfield 279	com/tencent/mm/ae/g$a:dSq	Ljava/lang/String;
    //   28: invokestatic 182	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   31: ifne +100 -> 131
    //   34: invokestatic 203	com/tencent/mm/plugin/aa/b:Vj	()Lcom/tencent/mm/plugin/aa/a/b/d;
    //   37: aload 5
    //   39: getfield 279	com/tencent/mm/ae/g$a:dSq	Ljava/lang/String;
    //   42: invokevirtual 283	com/tencent/mm/plugin/aa/a/b/d:pv	(Ljava/lang/String;)Lcom/tencent/mm/plugin/aa/a/b/c;
    //   45: astore 6
    //   47: aload 5
    //   49: getfield 279	com/tencent/mm/ae/g$a:dSq	Ljava/lang/String;
    //   52: astore 7
    //   54: aload 6
    //   56: ifnull +79 -> 135
    //   59: aload 6
    //   61: getfield 196	com/tencent/mm/plugin/aa/a/b/c:field_insertmsg	Z
    //   64: ifeq +71 -> 135
    //   67: aload 6
    //   69: ifnull +71 -> 140
    //   72: aload 6
    //   74: getfield 199	com/tencent/mm/plugin/aa/a/b/c:field_localMsgId	J
    //   77: lstore_3
    //   78: ldc 72
    //   80: ldc_w 285
    //   83: iconst_5
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: aload 7
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: aload_1
    //   95: aastore
    //   96: dup
    //   97: iconst_2
    //   98: aload 6
    //   100: aastore
    //   101: dup
    //   102: iconst_3
    //   103: iload_2
    //   104: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   107: aastore
    //   108: dup
    //   109: iconst_4
    //   110: lload_3
    //   111: invokestatic 144	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   114: aastore
    //   115: invokestatic 148	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload 6
    //   120: ifnonnull +25 -> 145
    //   123: ldc 72
    //   125: ldc_w 287
    //   128: invokestatic 290	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: ldc 2
    //   133: monitorexit
    //   134: return
    //   135: iconst_0
    //   136: istore_2
    //   137: goto -70 -> 67
    //   140: lconst_0
    //   141: lstore_3
    //   142: goto -64 -> 78
    //   145: aload 6
    //   147: getfield 196	com/tencent/mm/plugin/aa/a/b/c:field_insertmsg	Z
    //   150: ifeq +13 -> 163
    //   153: aload 6
    //   155: getfield 199	com/tencent/mm/plugin/aa/a/b/c:field_localMsgId	J
    //   158: lconst_0
    //   159: lcmp
    //   160: ifgt -29 -> 131
    //   163: new 83	com/tencent/mm/storage/bi
    //   166: dup
    //   167: invokespecial 86	com/tencent/mm/storage/bi:<init>	()V
    //   170: astore 6
    //   172: aload 6
    //   174: aload_1
    //   175: invokestatic 294	com/tencent/mm/model/bd:iK	(Ljava/lang/String;)J
    //   178: invokevirtual 117	com/tencent/mm/storage/bi:bg	(J)V
    //   181: aload 6
    //   183: ldc_w 295
    //   186: invokevirtual 120	com/tencent/mm/storage/bi:setType	(I)V
    //   189: invokestatic 300	com/tencent/mm/model/q:Gj	()Ljava/lang/String;
    //   192: astore 7
    //   194: aload 6
    //   196: new 259	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   203: aload 7
    //   205: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc_w 306
    //   211: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_0
    //   215: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokevirtual 99	com/tencent/mm/storage/bi:setContent	(Ljava/lang/String;)V
    //   224: new 259	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   231: invokestatic 309	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   234: invokevirtual 312	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   237: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokevirtual 316	java/lang/String:getBytes	()[B
    //   243: invokestatic 321	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   246: astore 7
    //   248: invokestatic 327	com/tencent/mm/as/o:OJ	()Lcom/tencent/mm/as/g;
    //   251: aload 7
    //   253: invokevirtual 332	com/tencent/mm/as/g:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   256: astore_0
    //   257: invokestatic 327	com/tencent/mm/as/o:OJ	()Lcom/tencent/mm/as/g;
    //   260: pop
    //   261: aload 7
    //   263: invokestatic 335	com/tencent/mm/as/g:md	(Ljava/lang/String;)Ljava/lang/String;
    //   266: astore 7
    //   268: invokestatic 339	com/tencent/mm/as/o:ON	()Lcom/tencent/mm/as/a/a;
    //   271: astore 8
    //   273: aload 5
    //   275: getfield 342	com/tencent/mm/ae/g$a:dSa	Ljava/lang/String;
    //   278: astore 9
    //   280: new 344	com/tencent/mm/as/a/a/c$a
    //   283: dup
    //   284: invokespecial 345	com/tencent/mm/as/a/a/c$a:<init>	()V
    //   287: astore 10
    //   289: aload 10
    //   291: aload_0
    //   292: putfield 348	com/tencent/mm/as/a/a/c$a:erh	Ljava/lang/String;
    //   295: aload 10
    //   297: iconst_1
    //   298: putfield 351	com/tencent/mm/as/a/a/c$a:erf	Z
    //   301: aload 8
    //   303: aload 9
    //   305: aconst_null
    //   306: aload 10
    //   308: invokevirtual 355	com/tencent/mm/as/a/a/c$a:OV	()Lcom/tencent/mm/as/a/a/c;
    //   311: invokevirtual 360	com/tencent/mm/as/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/as/a/a/c;)V
    //   314: aload 6
    //   316: aload 7
    //   318: invokevirtual 363	com/tencent/mm/storage/bi:ed	(Ljava/lang/String;)V
    //   321: aload 6
    //   323: iconst_1
    //   324: invokevirtual 90	com/tencent/mm/storage/bi:fA	(I)V
    //   327: aload 6
    //   329: aload_1
    //   330: invokevirtual 93	com/tencent/mm/storage/bi:ec	(Ljava/lang/String;)V
    //   333: aload 6
    //   335: iconst_3
    //   336: invokevirtual 96	com/tencent/mm/storage/bi:setStatus	(I)V
    //   339: aload 6
    //   341: aload 6
    //   343: invokestatic 366	com/tencent/mm/model/bd:h	(Lcom/tencent/mm/storage/bi;)J
    //   346: invokevirtual 369	com/tencent/mm/storage/bi:setMsgId	(J)V
    //   349: ldc 72
    //   351: ldc_w 371
    //   354: invokestatic 221	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 5
    //   359: getfield 279	com/tencent/mm/ae/g$a:dSq	Ljava/lang/String;
    //   362: iconst_1
    //   363: aload 6
    //   365: getfield 374	com/tencent/mm/h/c/cs:field_msgId	J
    //   368: invokestatic 376	com/tencent/mm/plugin/aa/a/h:a	(Ljava/lang/String;ZJ)V
    //   371: new 378	com/tencent/mm/ae/g
    //   374: dup
    //   375: invokespecial 379	com/tencent/mm/ae/g:<init>	()V
    //   378: astore_0
    //   379: aload 5
    //   381: aload_0
    //   382: invokevirtual 382	com/tencent/mm/ae/g$a:a	(Lcom/tencent/mm/ae/g;)V
    //   385: aload_0
    //   386: aload 6
    //   388: getfield 374	com/tencent/mm/h/c/cs:field_msgId	J
    //   391: putfield 383	com/tencent/mm/ae/g:field_msgId	J
    //   394: invokestatic 389	com/tencent/mm/plugin/z/a:bro	()Lcom/tencent/mm/pluginsdk/model/app/k;
    //   397: aload_0
    //   398: invokevirtual 393	com/tencent/mm/pluginsdk/model/app/k:b	(Lcom/tencent/mm/sdk/e/c;)Z
    //   401: pop
    //   402: goto -271 -> 131
    //   405: astore_0
    //   406: ldc 2
    //   408: monitorexit
    //   409: aload_0
    //   410: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	paramString1	String
    //   0	411	1	paramString2	String
    //   1	136	2	bool	boolean
    //   77	65	3	l	long
    //   16	364	5	locala	g.a
    //   45	342	6	localObject	Object
    //   52	265	7	str1	String
    //   271	31	8	locala1	com.tencent.mm.as.a.a
    //   278	26	9	str2	String
    //   287	20	10	locala2	com.tencent.mm.as.a.a.c.a
    // Exception table:
    //   from	to	target	type
    //   5	18	405	finally
    //   23	54	405	finally
    //   59	67	405	finally
    //   72	78	405	finally
    //   78	118	405	finally
    //   123	131	405	finally
    //   145	163	405	finally
    //   163	402	405	finally
  }
  
  public static void aQ(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    for (;;)
    {
      Object localObject;
      try
      {
        if (!bk.bl(paramString1))
        {
          localObject = g.a.gp(paramString1);
          if (localObject == null) {
            continue;
          }
          str = ((g.a)localObject).dSq;
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AAUtil", "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s", new Object[] { str, paramString1.trim().replace(" ", "") });
          if ((localObject != null) && (!bk.bl(((g.a)localObject).dSq)))
          {
            str = ((g.a)localObject).dSq;
            localObject = com.tencent.mm.plugin.aa.b.Vj().pv(str);
            if (localObject != null) {
              break label321;
            }
            bool1 = true;
            if ((localObject == null) || (!((com.tencent.mm.plugin.aa.a.b.c)localObject).field_insertmsg)) {
              break label326;
            }
            if (localObject == null) {
              break label331;
            }
            l = ((com.tencent.mm.plugin.aa.a.b.c)localObject).field_localMsgId;
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, record==null: %s, billNo: %s, insertMsg: %s, chatroom: %s, localMsgId: %s", new Object[] { Boolean.valueOf(bool1), str, Boolean.valueOf(bool2), paramString2, Long.valueOf(l) });
            if ((localObject == null) || (!((com.tencent.mm.plugin.aa.a.b.c)localObject).field_insertmsg) || (((com.tencent.mm.plugin.aa.a.b.c)localObject).field_localMsgId <= 0L) || (((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(((com.tencent.mm.plugin.aa.a.b.c)localObject).field_localMsgId).field_msgId > 0L)) {
              continue;
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
            com.tencent.mm.plugin.aa.b.Vj().a((com.tencent.mm.plugin.aa.a.b.c)localObject, new String[0]);
          }
        }
        return;
        String str = "";
        continue;
        if ((localObject == null) || (!((com.tencent.mm.plugin.aa.a.b.c)localObject).field_insertmsg) || (((com.tencent.mm.plugin.aa.a.b.c)localObject).field_localMsgId <= 0L))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
          aP(paramString1, paramString2);
          continue;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
      }
      finally {}
      i(((com.tencent.mm.plugin.aa.a.b.c)localObject).field_localMsgId, paramString1);
      continue;
      label321:
      boolean bool1 = false;
      continue;
      label326:
      bool2 = false;
      continue;
      label331:
      long l = 0L;
    }
  }
  
  public static long aR(String paramString1, String paramString2)
  {
    try
    {
      double d1 = bk.getDouble(paramString1, 0.0D);
      double d2 = bk.getDouble(paramString2, 0.0D);
      if (d1 == 0.0D) {
        paramString1 = "0";
      }
      paramString1 = new BigDecimal(paramString1);
      if (d2 == 0.0D) {
        paramString2 = "0";
      }
      long l = paramString1.multiply(new BigDecimal(paramString2)).longValue();
      return l;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.AAUtil", paramString1, "", new Object[0]);
    }
    return 0L;
  }
  
  /* Error */
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: ldc 2
    //   5: monitorenter
    //   6: ldc 72
    //   8: ldc_w 437
    //   11: iconst_3
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_0
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_2
    //   22: aastore
    //   23: dup
    //   24: iconst_2
    //   25: aload_3
    //   26: aastore
    //   27: invokestatic 405	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: invokestatic 182	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   34: ifne +171 -> 205
    //   37: aload_2
    //   38: invokestatic 182	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   41: ifne +164 -> 205
    //   44: aload_3
    //   45: invokestatic 182	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   48: ifne +157 -> 205
    //   51: invokestatic 172	com/tencent/mm/plugin/aa/b:Vk	()Lcom/tencent/mm/plugin/aa/a/b/b;
    //   54: aload_3
    //   55: invokevirtual 441	com/tencent/mm/plugin/aa/a/b/b:pu	(Ljava/lang/String;)Lcom/tencent/mm/plugin/aa/a/b/a;
    //   58: astore 6
    //   60: aload 6
    //   62: ifnull +147 -> 209
    //   65: aload 6
    //   67: getfield 162	com/tencent/mm/plugin/aa/a/b/a:field_insertmsg	Z
    //   70: ifeq +139 -> 209
    //   73: ldc 72
    //   75: ldc_w 443
    //   78: iconst_5
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_0
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload_1
    //   89: aastore
    //   90: dup
    //   91: iconst_2
    //   92: aload_3
    //   93: aastore
    //   94: dup
    //   95: iconst_3
    //   96: aload 6
    //   98: aastore
    //   99: dup
    //   100: iconst_4
    //   101: iload 5
    //   103: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   106: aastore
    //   107: invokestatic 148	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload 6
    //   112: ifnull +11 -> 123
    //   115: aload 6
    //   117: getfield 162	com/tencent/mm/plugin/aa/a/b/a:field_insertmsg	Z
    //   120: ifne +85 -> 205
    //   123: new 259	java/lang/StringBuilder
    //   126: dup
    //   127: ldc_w 445
    //   130: invokespecial 262	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload_2
    //   134: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 447
    //   140: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: astore_2
    //   151: aload 4
    //   153: invokestatic 182	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   156: ifeq +102 -> 258
    //   159: ldc 72
    //   161: ldc_w 449
    //   164: invokestatic 221	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload_0
    //   168: invokestatic 300	com/tencent/mm/model/q:Gj	()Ljava/lang/String;
    //   171: invokevirtual 453	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifeq +41 -> 215
    //   177: invokestatic 459	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   180: getstatic 464	com/tencent/mm/plugin/wxpay/a$i:pay_sys_msg_tmpl_launch_by_myself	I
    //   183: iconst_1
    //   184: anewarray 4	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_2
    //   190: aastore
    //   191: invokevirtual 470	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   194: astore 4
    //   196: aload 4
    //   198: aload_1
    //   199: aload 6
    //   201: aload_3
    //   202: invokestatic 472	com/tencent/mm/plugin/aa/a/h:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/aa/a/b/a;Ljava/lang/String;)V
    //   205: ldc 2
    //   207: monitorexit
    //   208: return
    //   209: iconst_0
    //   210: istore 5
    //   212: goto -139 -> 73
    //   215: ldc_w 474
    //   218: invokestatic 126	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   221: checkcast 474	com/tencent/mm/plugin/messenger/a/b
    //   224: aload_0
    //   225: aload_1
    //   226: invokeinterface 478 3 0
    //   231: astore_0
    //   232: invokestatic 459	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   235: getstatic 481	com/tencent/mm/plugin/wxpay/a$i:pay_sys_msg_tmpl_launch_by_other	I
    //   238: iconst_2
    //   239: anewarray 4	java/lang/Object
    //   242: dup
    //   243: iconst_0
    //   244: aload_0
    //   245: aastore
    //   246: dup
    //   247: iconst_1
    //   248: aload_2
    //   249: aastore
    //   250: invokevirtual 470	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   253: astore 4
    //   255: goto -59 -> 196
    //   258: ldc 72
    //   260: ldc_w 483
    //   263: iconst_1
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: aload 4
    //   271: aastore
    //   272: invokestatic 405	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: goto -79 -> 196
    //   278: astore_0
    //   279: ldc 2
    //   281: monitorexit
    //   282: aload_0
    //   283: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	paramString1	String
    //   0	284	1	paramString2	String
    //   0	284	2	paramString3	String
    //   0	284	3	paramString4	String
    //   0	284	4	paramString5	String
    //   1	210	5	bool	boolean
    //   58	142	6	locala	com.tencent.mm.plugin.aa.a.b.a
    // Exception table:
    //   from	to	target	type
    //   6	60	278	finally
    //   65	73	278	finally
    //   73	110	278	finally
    //   115	123	278	finally
    //   123	196	278	finally
    //   196	205	278	finally
    //   215	255	278	finally
    //   258	275	278	finally
  }
  
  public static void i(long paramLong, String paramString)
  {
    if (paramLong > 0L) {}
    for (;;)
    {
      Object localObject;
      try
      {
        if (bk.bl(paramString)) {
          break label357;
        }
        localObject = g.a.gp(paramString);
        if ((localObject == null) || (bk.bl(((g.a)localObject).dSq))) {
          break label335;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", new Object[] { Long.valueOf(paramLong), ((g.a)localObject).dSq });
        com.tencent.mm.plugin.aa.a.b.c localc = com.tencent.mm.plugin.aa.b.Vj().pv(((g.a)localObject).dSq);
        if (localc != null)
        {
          long l = localc.field_localMsgId;
          localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(l);
          if (((cs)localObject).field_msgId > 0L)
          {
            String str = bd.iI(((cs)localObject).field_content);
            ((bi)localObject).setContent(str + ":\n" + paramString);
            ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(l, (bi)localObject);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", new Object[] { Long.valueOf(l), localc.field_billNo });
            return;
          }
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", new Object[] { localc.field_billNo, Long.valueOf(localc.field_localMsgId), Long.valueOf(paramLong), Long.valueOf(((cs)localObject).field_msgId) });
          continue;
        }
        paramString = new com.tencent.mm.plugin.aa.a.b.c();
      }
      finally {}
      paramString.field_localMsgId = paramLong;
      paramString.field_billNo = ((g.a)localObject).dSq;
      paramString.field_insertmsg = true;
      com.tencent.mm.plugin.aa.b.Vj().a(paramString);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", new Object[] { Long.valueOf(paramLong), ((g.a)localObject).dSq });
      continue;
      label335:
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", new Object[] { Long.valueOf(paramLong) });
      continue;
      label357:
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bk.bl(paramString)) });
    }
  }
  
  public static void j(long paramLong, String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "do update sys msg, %s, %s", new Object[] { Long.valueOf(paramLong), paramString });
    bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramLong);
    paramString = pq(paramString);
    if (!bk.bl(paramString)) {
      localbi.setContent(paramString);
    }
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(paramLong, localbi);
  }
  
  private static String pq(String paramString)
  {
    paramString = bn.s(paramString, "sysmsg");
    if (paramString == null) {
      return "";
    }
    paramString = (String)paramString.get(".sysmsg.paymsg.appmsgcontent");
    if (bk.bl(paramString))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AAUtil", "empty appmsgcontent!");
      return "";
    }
    try
    {
      paramString = URLDecoder.decode(paramString, "UTF-8");
      try
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AAUtil", "msgContent: %s", new Object[] { paramString });
        return paramString;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1) {}
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      for (;;)
      {
        paramString = "";
      }
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AAUtil", localUnsupportedEncodingException1.getMessage());
    return paramString;
  }
  
  public static List<String> pr(String paramString)
  {
    if (bk.bl(paramString))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "illegal chatroomName");
      paramString = new ArrayList();
    }
    for (;;)
    {
      return paramString;
      Object localObject;
      if (!s.fn(paramString))
      {
        localObject = new ArrayList();
        ((List)localObject).add(q.Gj());
        ((List)localObject).add(paramString);
        return localObject;
      }
      try
      {
        localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.chatroom.a.c.class)).FF().ir(paramString);
        paramString = (String)localObject;
        if (localObject == null)
        {
          paramString = new ArrayList();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AAUtil", "getChatroomMemberList error! %s", new Object[] { paramString.getMessage() });
      }
    }
    return new ArrayList();
  }
  
  public static void pt(String paramString)
  {
    Object localObject = Vs();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(",");
    if (!bk.bl((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      int i = 0;
      int k;
      for (int j = 1; i < localObject.length; j = k)
      {
        String str = localObject[i];
        k = j;
        if (!str.equals(paramString))
        {
          k = j;
          if (j < 5)
          {
            localStringBuilder.append(str);
            localStringBuilder.append(",");
            k = j + 1;
          }
        }
        i += 1;
      }
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AAUtil", "recent group: %s", new Object[] { localStringBuilder.toString() });
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uwV, localStringBuilder.toString());
  }
  
  public static void t(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      com.tencent.mm.plugin.aa.a.b.c localc = com.tencent.mm.plugin.aa.b.Vj().pv(paramString1);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", new Object[] { paramString1, paramString2, Boolean.valueOf(bk.bl(paramString3)), localc });
      if (localc == null) {
        a(paramString1, false, 0L);
      }
      aQ(paramString3, paramString2);
      return;
    }
    finally {}
  }
  
  public static void u(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        if ((!bk.bl(paramString1)) && (!bk.bl(paramString2)) && (!bk.bl(paramString3)))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, chatroom: %s, payMsgId: %s", new Object[] { paramString2, paramString3 });
          locala = com.tencent.mm.plugin.aa.b.Vk().pu(paramString3);
          if ((locala != null) && (locala.field_insertmsg)) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, insert new msg");
          a(paramString1, paramString2, locala, paramString3);
        }
      }
      catch (Exception paramString1)
      {
        com.tencent.mm.plugin.aa.a.b.a locala;
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AAUtil", "checkIfInsertPaySysMsg error: %s", new Object[] { paramString1.getMessage() });
        continue;
      }
      finally {}
      return;
      paramString2 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(locala.field_msgId);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", new Object[] { Long.valueOf(locala.field_msgId), Long.valueOf(paramString2.field_msgId) });
      paramString2.setContent(paramString1);
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(locala.field_msgId, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.h
 * JD-Core Version:    0.7.0.1
 */