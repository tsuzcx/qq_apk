package com.tencent.mm.plugin.aa.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.aa.a.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  public static double a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40620);
    try
    {
      if (bo.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim())
      {
        double d = new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), paramInt1, paramInt2).doubleValue();
        AppMethodBeat.o(40620);
        return d;
      }
      return 0.0D;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.AAUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(40620);
    }
  }
  
  private static void a(String paramString1, String paramString2, com.tencent.mm.plugin.aa.a.b.a parama, String paramString3)
  {
    try
    {
      AppMethodBeat.i(40615);
      bi localbi = new bi();
      localbi.hL(0);
      localbi.kj(paramString2);
      localbi.setStatus(3);
      localbi.setContent(paramString1);
      localbi.fQ(bf.x(paramString2, System.currentTimeMillis() / 1000L));
      localbi.setType(10000);
      long l = ((j)g.E(j.class)).bPQ().Z(localbi);
      ab.i("MicroMsg.AAUtil", "insertPaySysMsg, inserted msgId: %s", new Object[] { Long.valueOf(l) });
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
        com.tencent.mm.plugin.aa.b.aoI().replace(paramString1);
      }
      AppMethodBeat.o(40615);
      return;
    }
    finally {}
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong)
  {
    try
    {
      AppMethodBeat.i(40610);
      if (!bo.isNullOrNil(paramString))
      {
        ab.i("MicroMsg.AAUtil", "insertOrUpdateAARecord, billNo: %s, insertMsg: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        com.tencent.mm.plugin.aa.a.b.c localc = new com.tencent.mm.plugin.aa.a.b.c();
        localc.field_billNo = paramString;
        localc.field_insertmsg = paramBoolean;
        localc.field_localMsgId = paramLong;
        com.tencent.mm.plugin.aa.b.aoH().b(localc);
      }
      AppMethodBeat.o(40610);
      return;
    }
    finally {}
  }
  
  public static boolean a(Activity paramActivity, y paramy)
  {
    AppMethodBeat.i(40618);
    boolean bool;
    if (paramy.wkQ == 1)
    {
      ab.i("MicroMsg.AAUtil", "need realname verify");
      paramy = new Bundle();
      paramy.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
      paramy.putString("realname_verify_process_jump_plugin", "aa");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramy, null, 0);
      AppMethodBeat.o(40618);
      return bool;
    }
    if (paramy.wkQ == 2)
    {
      ab.i("MicroMsg.AAUtil", "need upload credit");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramy.opB, paramy.opE, paramy.opC, paramy.opD, false, null);
      AppMethodBeat.o(40618);
      return bool;
    }
    ab.i("MicroMsg.AAUtil", "realnameGuideFlag =  " + paramy.wkQ);
    AppMethodBeat.o(40618);
    return false;
  }
  
  public static String aoQ()
  {
    AppMethodBeat.i(40623);
    g.RM();
    String str = bo.nullAsNil((String)g.RL().Ru().get(ac.a.yHe, null));
    AppMethodBeat.o(40623);
    return str;
  }
  
  /* Error */
  private static void bi(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 283
    //   8: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokestatic 161	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   15: ifne +399 -> 414
    //   18: aload_0
    //   19: invokestatic 289	com/tencent/mm/af/j$b:mY	(Ljava/lang/String;)Lcom/tencent/mm/af/j$b;
    //   22: astore 5
    //   24: aload 5
    //   26: ifnull +388 -> 414
    //   29: aload 5
    //   31: getfield 292	com/tencent/mm/af/j$b:fip	Ljava/lang/String;
    //   34: invokestatic 161	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +377 -> 414
    //   40: invokestatic 182	com/tencent/mm/plugin/aa/b:aoH	()Lcom/tencent/mm/plugin/aa/a/b/d;
    //   43: aload 5
    //   45: getfield 292	com/tencent/mm/af/j$b:fip	Ljava/lang/String;
    //   48: invokevirtual 296	com/tencent/mm/plugin/aa/a/b/d:wJ	(Ljava/lang/String;)Lcom/tencent/mm/plugin/aa/a/b/c;
    //   51: astore 6
    //   53: aload 5
    //   55: getfield 292	com/tencent/mm/af/j$b:fip	Ljava/lang/String;
    //   58: astore 7
    //   60: aload 6
    //   62: ifnull +85 -> 147
    //   65: aload 6
    //   67: getfield 175	com/tencent/mm/plugin/aa/a/b/c:field_insertmsg	Z
    //   70: ifeq +77 -> 147
    //   73: aload 6
    //   75: ifnull +77 -> 152
    //   78: aload 6
    //   80: getfield 178	com/tencent/mm/plugin/aa/a/b/c:field_localMsgId	J
    //   83: lstore_3
    //   84: ldc 48
    //   86: ldc_w 298
    //   89: iconst_5
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload 7
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: aload_1
    //   101: aastore
    //   102: dup
    //   103: iconst_2
    //   104: aload 6
    //   106: aastore
    //   107: dup
    //   108: iconst_3
    //   109: iload_2
    //   110: invokestatic 168	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   113: aastore
    //   114: dup
    //   115: iconst_4
    //   116: lload_3
    //   117: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: aastore
    //   121: invokestatic 126	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload 6
    //   126: ifnonnull +31 -> 157
    //   129: ldc 48
    //   131: ldc_w 300
    //   134: invokestatic 303	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: ldc_w 283
    //   140: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: ldc 2
    //   145: monitorexit
    //   146: return
    //   147: iconst_0
    //   148: istore_2
    //   149: goto -76 -> 73
    //   152: lconst_0
    //   153: lstore_3
    //   154: goto -70 -> 84
    //   157: aload 6
    //   159: getfield 175	com/tencent/mm/plugin/aa/a/b/c:field_insertmsg	Z
    //   162: ifeq +13 -> 175
    //   165: aload 6
    //   167: getfield 178	com/tencent/mm/plugin/aa/a/b/c:field_localMsgId	J
    //   170: lconst_0
    //   171: lcmp
    //   172: ifgt +242 -> 414
    //   175: new 61	com/tencent/mm/storage/bi
    //   178: dup
    //   179: invokespecial 64	com/tencent/mm/storage/bi:<init>	()V
    //   182: astore 6
    //   184: aload 6
    //   186: aload_1
    //   187: invokestatic 307	com/tencent/mm/model/bf:py	(Ljava/lang/String;)J
    //   190: invokevirtual 94	com/tencent/mm/storage/bi:fQ	(J)V
    //   193: aload 6
    //   195: ldc_w 308
    //   198: invokevirtual 97	com/tencent/mm/storage/bi:setType	(I)V
    //   201: invokestatic 313	com/tencent/mm/model/r:Zn	()Ljava/lang/String;
    //   204: astore 7
    //   206: aload 6
    //   208: new 239	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   215: aload 7
    //   217: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc_w 319
    //   223: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_0
    //   227: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokevirtual 76	com/tencent/mm/storage/bi:setContent	(Ljava/lang/String;)V
    //   236: new 239	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   243: invokestatic 322	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   246: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokevirtual 329	java/lang/String:getBytes	()[B
    //   255: invokestatic 335	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   258: astore 7
    //   260: invokestatic 341	com/tencent/mm/at/o:ahC	()Lcom/tencent/mm/at/g;
    //   263: aload 7
    //   265: invokevirtual 346	com/tencent/mm/at/g:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   268: astore_0
    //   269: invokestatic 341	com/tencent/mm/at/o:ahC	()Lcom/tencent/mm/at/g;
    //   272: pop
    //   273: aload 7
    //   275: invokestatic 349	com/tencent/mm/at/g:td	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 7
    //   280: invokestatic 353	com/tencent/mm/at/o:ahG	()Lcom/tencent/mm/at/a/a;
    //   283: astore 8
    //   285: aload 5
    //   287: getfield 356	com/tencent/mm/af/j$b:fhZ	Ljava/lang/String;
    //   290: astore 9
    //   292: new 358	com/tencent/mm/at/a/a/c$a
    //   295: dup
    //   296: invokespecial 359	com/tencent/mm/at/a/a/c$a:<init>	()V
    //   299: astore 10
    //   301: aload 10
    //   303: aload_0
    //   304: putfield 362	com/tencent/mm/at/a/a/c$a:eNO	Ljava/lang/String;
    //   307: aload 10
    //   309: iconst_1
    //   310: putfield 365	com/tencent/mm/at/a/a/c$a:eNM	Z
    //   313: aload 8
    //   315: aload 9
    //   317: aconst_null
    //   318: aload 10
    //   320: invokevirtual 369	com/tencent/mm/at/a/a/c$a:ahY	()Lcom/tencent/mm/at/a/a/c;
    //   323: invokevirtual 374	com/tencent/mm/at/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/at/a/a/c;)V
    //   326: aload 6
    //   328: aload 7
    //   330: invokevirtual 377	com/tencent/mm/storage/bi:kk	(Ljava/lang/String;)V
    //   333: aload 6
    //   335: iconst_1
    //   336: invokevirtual 67	com/tencent/mm/storage/bi:hL	(I)V
    //   339: aload 6
    //   341: aload_1
    //   342: invokevirtual 70	com/tencent/mm/storage/bi:kj	(Ljava/lang/String;)V
    //   345: aload 6
    //   347: iconst_3
    //   348: invokevirtual 73	com/tencent/mm/storage/bi:setStatus	(I)V
    //   351: aload 6
    //   353: aload 6
    //   355: invokestatic 380	com/tencent/mm/model/bf:l	(Lcom/tencent/mm/storage/bi;)J
    //   358: invokevirtual 383	com/tencent/mm/storage/bi:setMsgId	(J)V
    //   361: ldc 48
    //   363: ldc_w 385
    //   366: invokestatic 201	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 5
    //   371: getfield 292	com/tencent/mm/af/j$b:fip	Ljava/lang/String;
    //   374: iconst_1
    //   375: aload 6
    //   377: getfield 388	com/tencent/mm/g/c/dd:field_msgId	J
    //   380: invokestatic 390	com/tencent/mm/plugin/aa/a/h:a	(Ljava/lang/String;ZJ)V
    //   383: new 392	com/tencent/mm/af/j
    //   386: dup
    //   387: invokespecial 393	com/tencent/mm/af/j:<init>	()V
    //   390: astore_0
    //   391: aload 5
    //   393: aload_0
    //   394: invokevirtual 396	com/tencent/mm/af/j$b:a	(Lcom/tencent/mm/af/j;)V
    //   397: aload_0
    //   398: aload 6
    //   400: getfield 388	com/tencent/mm/g/c/dd:field_msgId	J
    //   403: putfield 397	com/tencent/mm/af/j:field_msgId	J
    //   406: invokestatic 403	com/tencent/mm/plugin/s/a:cad	()Lcom/tencent/mm/pluginsdk/model/app/k;
    //   409: aload_0
    //   410: invokevirtual 408	com/tencent/mm/pluginsdk/model/app/k:insert	(Lcom/tencent/mm/sdk/e/c;)Z
    //   413: pop
    //   414: ldc_w 283
    //   417: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   420: goto -277 -> 143
    //   423: astore_0
    //   424: ldc 2
    //   426: monitorexit
    //   427: aload_0
    //   428: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramString1	String
    //   0	429	1	paramString2	String
    //   1	148	2	bool	boolean
    //   83	71	3	l	long
    //   22	370	5	localb	j.b
    //   51	348	6	localObject	Object
    //   58	271	7	str1	String
    //   283	31	8	locala	com.tencent.mm.at.a.a
    //   290	26	9	str2	String
    //   299	20	10	locala1	com.tencent.mm.at.a.a.c.a
    // Exception table:
    //   from	to	target	type
    //   5	24	423	finally
    //   29	60	423	finally
    //   65	73	423	finally
    //   78	84	423	finally
    //   84	124	423	finally
    //   129	143	423	finally
    //   157	175	423	finally
    //   175	414	423	finally
    //   414	420	423	finally
  }
  
  public static void bj(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(40611);
        if (bo.isNullOrNil(paramString1)) {
          break label356;
        }
        localObject = j.b.mY(paramString1);
        String str;
        if (localObject != null)
        {
          str = ((j.b)localObject).fip;
          ab.d("MicroMsg.AAUtil", "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s", new Object[] { str, paramString1.trim().replace(" ", "") });
          if ((localObject == null) || (bo.isNullOrNil(((j.b)localObject).fip))) {
            break label356;
          }
          str = ((j.b)localObject).fip;
          localObject = com.tencent.mm.plugin.aa.b.aoH().wJ(str);
          if (localObject != null) {
            break label365;
          }
          bool1 = true;
          if ((localObject == null) || (!((com.tencent.mm.plugin.aa.a.b.c)localObject).field_insertmsg)) {
            break label370;
          }
          if (localObject == null) {
            break label375;
          }
          l = ((com.tencent.mm.plugin.aa.a.b.c)localObject).field_localMsgId;
          ab.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, record==null: %s, billNo: %s, insertMsg: %s, chatroom: %s, localMsgId: %s", new Object[] { Boolean.valueOf(bool1), str, Boolean.valueOf(bool2), paramString2, Long.valueOf(l) });
          if (localObject == null)
          {
            ab.e("MicroMsg.AAUtil", "checkIfInsertAAMsg, record is null, ignore");
            a(str, false, 0L);
          }
          if ((localObject != null) && (((com.tencent.mm.plugin.aa.a.b.c)localObject).field_insertmsg) && (((com.tencent.mm.plugin.aa.a.b.c)localObject).field_localMsgId > 0L) && (((j)g.E(j.class)).bPQ().kB(((com.tencent.mm.plugin.aa.a.b.c)localObject).field_localMsgId).field_msgId <= 0L))
          {
            ab.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
            com.tencent.mm.plugin.aa.b.aoH().a((com.tencent.mm.plugin.aa.a.b.c)localObject, new String[0]);
            AppMethodBeat.o(40611);
          }
        }
        else
        {
          str = "";
          continue;
        }
        if ((localObject == null) || (!((com.tencent.mm.plugin.aa.a.b.c)localObject).field_insertmsg) || (((com.tencent.mm.plugin.aa.a.b.c)localObject).field_localMsgId <= 0L))
        {
          ab.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
          bi(paramString1, paramString2);
          AppMethodBeat.o(40611);
          continue;
        }
        ab.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
      }
      finally {}
      g(((com.tencent.mm.plugin.aa.a.b.c)localObject).field_localMsgId, paramString1);
      label356:
      AppMethodBeat.o(40611);
      continue;
      label365:
      boolean bool1 = false;
      continue;
      label370:
      bool2 = false;
      continue;
      label375:
      long l = 0L;
    }
  }
  
  public static long bk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(40621);
    try
    {
      double d1 = bo.getDouble(paramString1, 0.0D);
      double d2 = bo.getDouble(paramString2, 0.0D);
      if (d1 == 0.0D) {
        paramString1 = "0";
      }
      paramString1 = new BigDecimal(paramString1);
      if (d2 == 0.0D) {
        paramString2 = "0";
      }
      long l = paramString1.multiply(new BigDecimal(paramString2)).longValue();
      AppMethodBeat.o(40621);
      return l;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.AAUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(40621);
    }
    return 0L;
  }
  
  /* Error */
  public static void c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: ldc 2
    //   5: monitorenter
    //   6: ldc_w 456
    //   9: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: ldc 48
    //   14: ldc_w 458
    //   17: iconst_3
    //   18: anewarray 4	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: aload_0
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: aload_2
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: aload_3
    //   32: aastore
    //   33: invokestatic 420	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: aload_0
    //   37: invokestatic 161	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   40: ifne +171 -> 211
    //   43: aload_2
    //   44: invokestatic 161	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   47: ifne +164 -> 211
    //   50: aload_3
    //   51: invokestatic 161	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   54: ifne +157 -> 211
    //   57: invokestatic 149	com/tencent/mm/plugin/aa/b:aoI	()Lcom/tencent/mm/plugin/aa/a/b/b;
    //   60: aload_3
    //   61: invokevirtual 462	com/tencent/mm/plugin/aa/a/b/b:wI	(Ljava/lang/String;)Lcom/tencent/mm/plugin/aa/a/b/a;
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull +153 -> 221
    //   71: aload 6
    //   73: getfield 139	com/tencent/mm/plugin/aa/a/b/a:field_insertmsg	Z
    //   76: ifeq +145 -> 221
    //   79: ldc 48
    //   81: ldc_w 464
    //   84: iconst_5
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_0
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: aload_1
    //   95: aastore
    //   96: dup
    //   97: iconst_2
    //   98: aload_3
    //   99: aastore
    //   100: dup
    //   101: iconst_3
    //   102: aload 6
    //   104: aastore
    //   105: dup
    //   106: iconst_4
    //   107: iload 5
    //   109: invokestatic 168	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   112: aastore
    //   113: invokestatic 126	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload 6
    //   118: ifnull +11 -> 129
    //   121: aload 6
    //   123: getfield 139	com/tencent/mm/plugin/aa/a/b/a:field_insertmsg	Z
    //   126: ifne +85 -> 211
    //   129: new 239	java/lang/StringBuilder
    //   132: dup
    //   133: ldc_w 466
    //   136: invokespecial 242	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: aload_2
    //   140: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 468
    //   146: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_0
    //   150: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: astore_2
    //   157: aload 4
    //   159: invokestatic 161	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   162: ifeq +108 -> 270
    //   165: ldc 48
    //   167: ldc_w 470
    //   170: invokestatic 201	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_0
    //   174: invokestatic 313	com/tencent/mm/model/r:Zn	()Ljava/lang/String;
    //   177: invokevirtual 474	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   180: ifeq +47 -> 227
    //   183: invokestatic 480	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   186: ldc_w 481
    //   189: iconst_1
    //   190: anewarray 4	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload_2
    //   196: aastore
    //   197: invokevirtual 487	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   200: astore 4
    //   202: aload 4
    //   204: aload_1
    //   205: aload 6
    //   207: aload_3
    //   208: invokestatic 489	com/tencent/mm/plugin/aa/a/h:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/aa/a/b/a;Ljava/lang/String;)V
    //   211: ldc_w 456
    //   214: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: ldc 2
    //   219: monitorexit
    //   220: return
    //   221: iconst_0
    //   222: istore 5
    //   224: goto -145 -> 79
    //   227: ldc_w 491
    //   230: invokestatic 105	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   233: checkcast 491	com/tencent/mm/plugin/messenger/a/b
    //   236: aload_0
    //   237: aload_1
    //   238: invokeinterface 495 3 0
    //   243: astore_0
    //   244: invokestatic 480	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   247: ldc_w 496
    //   250: iconst_2
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload_0
    //   257: aastore
    //   258: dup
    //   259: iconst_1
    //   260: aload_2
    //   261: aastore
    //   262: invokevirtual 487	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   265: astore 4
    //   267: goto -65 -> 202
    //   270: ldc 48
    //   272: ldc_w 498
    //   275: iconst_1
    //   276: anewarray 4	java/lang/Object
    //   279: dup
    //   280: iconst_0
    //   281: aload 4
    //   283: aastore
    //   284: invokestatic 420	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: goto -85 -> 202
    //   290: astore_0
    //   291: ldc 2
    //   293: monitorexit
    //   294: aload_0
    //   295: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramString1	String
    //   0	296	1	paramString2	String
    //   0	296	2	paramString3	String
    //   0	296	3	paramString4	String
    //   0	296	4	paramString5	String
    //   1	222	5	bool	boolean
    //   64	142	6	locala	com.tencent.mm.plugin.aa.a.b.a
    // Exception table:
    //   from	to	target	type
    //   6	66	290	finally
    //   71	79	290	finally
    //   79	116	290	finally
    //   121	129	290	finally
    //   129	202	290	finally
    //   202	211	290	finally
    //   211	217	290	finally
    //   227	267	290	finally
    //   270	287	290	finally
  }
  
  public static void g(long paramLong, String paramString)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(40616);
        if ((paramLong <= 0L) || (bo.isNullOrNil(paramString))) {
          break label387;
        }
        localObject = j.b.mY(paramString);
        if ((localObject == null) || (bo.isNullOrNil(((j.b)localObject).fip))) {
          break label359;
        }
        ab.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", new Object[] { Long.valueOf(paramLong), ((j.b)localObject).fip });
        com.tencent.mm.plugin.aa.a.b.c localc = com.tencent.mm.plugin.aa.b.aoH().wJ(((j.b)localObject).fip);
        if (localc != null)
        {
          long l = localc.field_localMsgId;
          localObject = ((j)g.E(j.class)).bPQ().kB(l);
          if (((dd)localObject).field_msgId > 0L)
          {
            String str = bf.pu(((dd)localObject).field_content);
            ((bi)localObject).setContent(str + ":\n" + paramString);
            ((j)g.E(j.class)).bPQ().a(l, (bi)localObject);
            ab.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", new Object[] { Long.valueOf(l), localc.field_billNo });
            AppMethodBeat.o(40616);
            return;
          }
          ab.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", new Object[] { localc.field_billNo, Long.valueOf(localc.field_localMsgId), Long.valueOf(paramLong), Long.valueOf(((dd)localObject).field_msgId) });
          AppMethodBeat.o(40616);
          continue;
        }
        paramString = new com.tencent.mm.plugin.aa.a.b.c();
      }
      finally {}
      paramString.field_localMsgId = paramLong;
      paramString.field_billNo = ((j.b)localObject).fip;
      paramString.field_insertmsg = true;
      com.tencent.mm.plugin.aa.b.aoH().a(paramString);
      ab.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", new Object[] { Long.valueOf(paramLong), ((j.b)localObject).fip });
      AppMethodBeat.o(40616);
      continue;
      label359:
      ab.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(40616);
      continue;
      label387:
      ab.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bo.isNullOrNil(paramString)) });
      AppMethodBeat.o(40616);
    }
  }
  
  public static void h(long paramLong, String paramString)
  {
    AppMethodBeat.i(40617);
    ab.i("MicroMsg.AAUtil", "do update sys msg, %s, %s", new Object[] { Long.valueOf(paramLong), paramString });
    bi localbi = ((j)g.E(j.class)).bPQ().kB(paramLong);
    paramString = wF(paramString);
    if (!bo.isNullOrNil(paramString)) {
      localbi.setContent(paramString);
    }
    ((j)g.E(j.class)).bPQ().a(paramLong, localbi);
    AppMethodBeat.o(40617);
  }
  
  public static void w(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      AppMethodBeat.i(40612);
      com.tencent.mm.plugin.aa.a.b.c localc = com.tencent.mm.plugin.aa.b.aoH().wJ(paramString1);
      ab.i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", new Object[] { paramString1, paramString2, Boolean.valueOf(bo.isNullOrNil(paramString3)), localc });
      if (localc == null) {
        a(paramString1, false, 0L);
      }
      bj(paramString3, paramString2);
      AppMethodBeat.o(40612);
      return;
    }
    finally {}
  }
  
  /* Error */
  private static String wF(String paramString)
  {
    // Byte code:
    //   0: ldc_w 540
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 542
    //   10: invokestatic 548	com/tencent/mm/sdk/platformtools/br:F	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnonnull +12 -> 27
    //   18: ldc_w 540
    //   21: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 50
    //   26: areturn
    //   27: aload_0
    //   28: ldc_w 550
    //   31: invokeinterface 555 2 0
    //   36: checkcast 17	java/lang/String
    //   39: astore_0
    //   40: aload_0
    //   41: invokestatic 161	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   44: ifeq +20 -> 64
    //   47: ldc 48
    //   49: ldc_w 557
    //   52: invokestatic 303	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: ldc_w 540
    //   58: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: ldc 50
    //   63: areturn
    //   64: aload_0
    //   65: ldc_w 559
    //   68: invokestatic 564	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: astore_0
    //   72: ldc 48
    //   74: ldc_w 566
    //   77: iconst_1
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload_0
    //   84: aastore
    //   85: invokestatic 420	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: ldc_w 540
    //   91: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_0
    //   95: areturn
    //   96: astore_1
    //   97: ldc 50
    //   99: astore_0
    //   100: ldc 48
    //   102: aload_1
    //   103: invokevirtual 569	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   106: invokestatic 303	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: goto -21 -> 88
    //   112: astore_1
    //   113: goto -13 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramString	String
    //   96	7	1	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   112	1	1	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   64	72	96	java/io/UnsupportedEncodingException
    //   72	88	112	java/io/UnsupportedEncodingException
  }
  
  public static List<String> wG(String paramString)
  {
    AppMethodBeat.i(40622);
    if (bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.AAUtil", "illegal chatroomName");
      paramString = new ArrayList();
      AppMethodBeat.o(40622);
      return paramString;
    }
    Object localObject;
    if (!t.lA(paramString))
    {
      localObject = new ArrayList();
      ((List)localObject).add(r.Zn());
      ((List)localObject).add(paramString);
      AppMethodBeat.o(40622);
      return localObject;
    }
    try
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ().oY(paramString);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = new ArrayList();
      }
      AppMethodBeat.o(40622);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.AAUtil", "getChatroomMemberList error! %s", new Object[] { paramString.getMessage() });
      paramString = new ArrayList();
      AppMethodBeat.o(40622);
    }
    return paramString;
  }
  
  public static void wH(String paramString)
  {
    AppMethodBeat.i(40624);
    Object localObject = aoQ();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(",");
    if (!bo.isNullOrNil((String)localObject))
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
    ab.d("MicroMsg.AAUtil", "recent group: %s", new Object[] { localStringBuilder.toString() });
    g.RM();
    g.RL().Ru().set(ac.a.yHe, localStringBuilder.toString());
    AppMethodBeat.o(40624);
  }
  
  public static void x(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      com.tencent.mm.plugin.aa.a.b.a locala;
      try
      {
        AppMethodBeat.i(40614);
      }
      finally {}
      try
      {
        if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)) || (bo.isNullOrNil(paramString3))) {
          continue;
        }
        ab.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, chatroom: %s, payMsgId: %s", new Object[] { paramString2, paramString3 });
        locala = com.tencent.mm.plugin.aa.b.aoI().wI(paramString3);
        if ((locala != null) && (locala.field_insertmsg)) {
          continue;
        }
        ab.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, insert new msg");
        a(paramString1, paramString2, locala, paramString3);
        AppMethodBeat.o(40614);
      }
      catch (Exception paramString1)
      {
        ab.e("MicroMsg.AAUtil", "checkIfInsertPaySysMsg error: %s", new Object[] { paramString1.getMessage() });
        AppMethodBeat.o(40614);
        continue;
      }
      return;
      paramString2 = ((j)g.E(j.class)).bPQ().kB(locala.field_msgId);
      ab.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", new Object[] { Long.valueOf(locala.field_msgId), Long.valueOf(paramString2.field_msgId) });
      paramString2.setContent(paramString1);
      ((j)g.E(j.class)).bPQ().a(locala.field_msgId, paramString2);
      AppMethodBeat.o(40614);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.a.h
 * JD-Core Version:    0.7.0.1
 */