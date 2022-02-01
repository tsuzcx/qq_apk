package com.tencent.mm.plugin.aa.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.b.a.es;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.a.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
{
  public static List<String> SA(String paramString)
  {
    AppMethodBeat.i(63352);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.AAUtil", "illegal chatroomName");
      paramString = new ArrayList();
      AppMethodBeat.o(63352);
      return paramString;
    }
    Object localObject;
    if (!com.tencent.mm.model.ab.Eq(paramString))
    {
      localObject = new ArrayList();
      ((List)localObject).add(z.aTY());
      ((List)localObject).add(paramString);
      AppMethodBeat.o(63352);
      return localObject;
    }
    try
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kh(paramString);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = new ArrayList();
      }
      AppMethodBeat.o(63352);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.AAUtil", "getChatroomMemberList error! %s", new Object[] { paramString.getMessage() });
      paramString = new ArrayList();
      AppMethodBeat.o(63352);
    }
    return paramString;
  }
  
  public static void SB(String paramString)
  {
    AppMethodBeat.i(63354);
    Object localObject = bml();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(",");
    if (!Util.isNullOrNil((String)localObject))
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
    Log.d("MicroMsg.AAUtil", "recent group: %s", new Object[] { localStringBuilder.toString() });
    g.aAi();
    g.aAh().azQ().set(ar.a.OcJ, localStringBuilder.toString());
    AppMethodBeat.o(63354);
  }
  
  /* Error */
  private static String Sz(String paramString)
  {
    // Byte code:
    //   0: ldc 156
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 158
    //   8: aconst_null
    //   9: invokestatic 164	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +11 -> 25
    //   17: ldc 156
    //   19: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: ldc 166
    //   24: areturn
    //   25: aload_0
    //   26: ldc 168
    //   28: invokeinterface 174 2 0
    //   33: checkcast 102	java/lang/String
    //   36: astore_0
    //   37: aload_0
    //   38: invokestatic 21	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   41: ifeq +18 -> 59
    //   44: ldc 23
    //   46: ldc 176
    //   48: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: ldc 156
    //   53: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: ldc 166
    //   58: areturn
    //   59: aload_0
    //   60: ldc 180
    //   62: invokestatic 186	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   65: astore_0
    //   66: ldc 23
    //   68: ldc 188
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: invokestatic 125	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: ldc 156
    //   83: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload_0
    //   87: areturn
    //   88: astore_1
    //   89: ldc 166
    //   91: astore_0
    //   92: ldc 23
    //   94: aload_1
    //   95: invokevirtual 189	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   98: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: goto -20 -> 81
    //   104: astore_1
    //   105: goto -13 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramString	String
    //   88	7	1	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   104	1	1	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   59	66	88	java/io/UnsupportedEncodingException
    //   66	81	104	java/io/UnsupportedEncodingException
  }
  
  public static double a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63350);
    try
    {
      if (Util.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
      for (paramString1 = "0";; paramString1 = paramString1.trim())
      {
        double d = new BigDecimal(paramString1).divide(new BigDecimal(paramString2.trim()), paramInt1, paramInt2).doubleValue();
        AppMethodBeat.o(63350);
        return d;
      }
      return 0.0D;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.AAUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(63350);
    }
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(212942);
    Log.d("MicroMsg.AAUtil", "startAAPay, reqKey: %s, isFromChatting: %s", new Object[] { paramString1, Boolean.valueOf(paramBoolean) });
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.dDL = paramString1;
    localPayInfo.dVv = 42;
    if (paramBoolean) {}
    for (localPayInfo.channel = 14;; localPayInfo.channel = 1)
    {
      paramString1 = new Bundle();
      paramString1.putString("extinfo_key_1", paramString3);
      localPayInfo.iqp = paramString1;
      com.tencent.mm.wallet_core.b.hgC();
      if (!com.tencent.mm.wallet_core.b.b(b.a.rWd, true)) {
        break;
      }
      localPayInfo.iqp.putString("extinfo_key_2", paramString2);
      ((com.tencent.mm.pluginsdk.wallet.a)g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(paramContext, localPayInfo);
      AppMethodBeat.o(212942);
      return;
    }
    f.a(paramContext, false, "", localPayInfo, paramString2, new Intent(), 233);
    AppMethodBeat.o(212942);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.plugin.aa.model.a.a parama, String paramString3, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(63344);
      ca localca = new ca();
      localca.nv(0);
      localca.Cy(paramString2);
      localca.setStatus(3);
      localca.setContent(paramString1);
      localca.setCreateTime(bp.C(paramString2, System.currentTimeMillis() / 1000L));
      localca.setType(10000);
      if (paramBoolean) {
        localca.setFlag(localca.field_flag | 0x8);
      }
      long l = ((l)g.af(l.class)).eiy().aC(localca);
      Log.i("MicroMsg.AAUtil", "insertPaySysMsg, inserted msgId: %s", new Object[] { Long.valueOf(l) });
      paramString1 = parama;
      if (parama == null) {
        paramString1 = new com.tencent.mm.plugin.aa.model.a.a();
      }
      if (l > 0L)
      {
        paramString1.field_payMsgId = paramString3;
        paramString1.field_chatroom = paramString2;
        paramString1.field_insertmsg = true;
        paramString1.field_msgId = l;
        com.tencent.mm.plugin.aa.b.bma().replace(paramString1);
      }
      AppMethodBeat.o(63344);
      return;
    }
    finally {}
  }
  
  public static void a(String paramString, boolean paramBoolean, long paramLong)
  {
    try
    {
      AppMethodBeat.i(63339);
      if (!Util.isNullOrNil(paramString))
      {
        Log.i("MicroMsg.AAUtil", "insertOrUpdateAARecord, billNo: %s, insertMsg: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        com.tencent.mm.plugin.aa.model.a.c localc = new com.tencent.mm.plugin.aa.model.a.c();
        localc.field_billNo = paramString;
        localc.field_insertmsg = paramBoolean;
        localc.field_localMsgId = paramLong;
        com.tencent.mm.plugin.aa.b.blZ().b(localc);
      }
      AppMethodBeat.o(63339);
      return;
    }
    finally {}
  }
  
  public static boolean a(Activity paramActivity, com.tencent.mm.protocal.protobuf.ab paramab)
  {
    AppMethodBeat.i(63348);
    boolean bool;
    if (paramab.KCl == 1)
    {
      Log.i("MicroMsg.AAUtil", "need realname verify");
      paramab = new Bundle();
      paramab.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
      paramab.putString("realname_verify_process_jump_plugin", "aa");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramab, null, 0);
      AppMethodBeat.o(63348);
      return bool;
    }
    if (paramab.KCl == 2)
    {
      Log.i("MicroMsg.AAUtil", "need upload credit");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramab.yXJ, paramab.yXK, paramab.lHA, paramab.lHB, false, null);
      AppMethodBeat.o(63348);
      return bool;
    }
    Log.i("MicroMsg.AAUtil", "realnameGuideFlag =  " + paramab.KCl);
    AppMethodBeat.o(63348);
    return false;
  }
  
  public static w aQ(List<w> paramList)
  {
    AppMethodBeat.i(212941);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      w localw = (w)paramList.next();
      if (localw.KBN.equals(z.aTY()))
      {
        AppMethodBeat.o(212941);
        return localw;
      }
    }
    Log.i("MicroMsg.AAUtil", "not contains self");
    AppMethodBeat.o(212941);
    return null;
  }
  
  /* Error */
  private static void bV(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 475
    //   8: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokestatic 21	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   15: ifne +399 -> 414
    //   18: aload_0
    //   19: invokestatic 481	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   22: astore 5
    //   24: aload 5
    //   26: ifnull +388 -> 414
    //   29: aload 5
    //   31: getfield 484	com/tencent/mm/ag/k$b:iyz	Ljava/lang/String;
    //   34: invokestatic 21	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +377 -> 414
    //   40: invokestatic 399	com/tencent/mm/plugin/aa/b:blZ	()Lcom/tencent/mm/plugin/aa/model/a/d;
    //   43: aload 5
    //   45: getfield 484	com/tencent/mm/ag/k$b:iyz	Ljava/lang/String;
    //   48: invokevirtual 488	com/tencent/mm/plugin/aa/model/a/d:SD	(Ljava/lang/String;)Lcom/tencent/mm/plugin/aa/model/a/c;
    //   51: astore 6
    //   53: aload 5
    //   55: getfield 484	com/tencent/mm/ag/k$b:iyz	Ljava/lang/String;
    //   58: astore 7
    //   60: aload 6
    //   62: ifnull +85 -> 147
    //   65: aload 6
    //   67: getfield 392	com/tencent/mm/plugin/aa/model/a/c:field_insertmsg	Z
    //   70: ifeq +77 -> 147
    //   73: aload 6
    //   75: ifnull +77 -> 152
    //   78: aload 6
    //   80: getfield 395	com/tencent/mm/plugin/aa/model/a/c:field_localMsgId	J
    //   83: lstore_3
    //   84: ldc 23
    //   86: ldc_w 490
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
    //   110: invokestatic 227	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   113: aastore
    //   114: dup
    //   115: iconst_4
    //   116: lload_3
    //   117: invokestatic 350	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: aastore
    //   121: invokestatic 352	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload 6
    //   126: ifnonnull +31 -> 157
    //   129: ldc 23
    //   131: ldc_w 492
    //   134: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: ldc_w 475
    //   140: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   159: getfield 392	com/tencent/mm/plugin/aa/model/a/c:field_insertmsg	Z
    //   162: ifeq +13 -> 175
    //   165: aload 6
    //   167: getfield 395	com/tencent/mm/plugin/aa/model/a/c:field_localMsgId	J
    //   170: lconst_0
    //   171: lcmp
    //   172: ifgt +242 -> 414
    //   175: new 289	com/tencent/mm/storage/ca
    //   178: dup
    //   179: invokespecial 290	com/tencent/mm/storage/ca:<init>	()V
    //   182: astore 6
    //   184: aload 6
    //   186: aload_1
    //   187: invokestatic 496	com/tencent/mm/model/bp:Kw	(Ljava/lang/String;)J
    //   190: invokevirtual 320	com/tencent/mm/storage/ca:setCreateTime	(J)V
    //   193: aload 6
    //   195: ldc_w 497
    //   198: invokevirtual 323	com/tencent/mm/storage/ca:setType	(I)V
    //   201: invokestatic 50	com/tencent/mm/model/z:aTY	()Ljava/lang/String;
    //   204: astore 7
    //   206: aload 6
    //   208: new 93	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   215: aload 7
    //   217: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc_w 499
    //   223: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_0
    //   227: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokevirtual 302	com/tencent/mm/storage/ca:setContent	(Ljava/lang/String;)V
    //   236: new 93	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   243: invokestatic 502	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   246: invokevirtual 505	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokevirtual 509	java/lang/String:getBytes	()[B
    //   255: invokestatic 515	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   258: astore 7
    //   260: invokestatic 521	com/tencent/mm/av/q:bcR	()Lcom/tencent/mm/av/i;
    //   263: aload 7
    //   265: invokevirtual 526	com/tencent/mm/av/i:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   268: astore_0
    //   269: invokestatic 521	com/tencent/mm/av/q:bcR	()Lcom/tencent/mm/av/i;
    //   272: pop
    //   273: aload 7
    //   275: invokestatic 529	com/tencent/mm/av/i:EX	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 7
    //   280: invokestatic 533	com/tencent/mm/av/q:bcV	()Lcom/tencent/mm/av/a/a;
    //   283: astore 8
    //   285: aload 5
    //   287: getfield 536	com/tencent/mm/ag/k$b:iyj	Ljava/lang/String;
    //   290: astore 9
    //   292: new 538	com/tencent/mm/av/a/a/c$a
    //   295: dup
    //   296: invokespecial 539	com/tencent/mm/av/a/a/c$a:<init>	()V
    //   299: astore 10
    //   301: aload 10
    //   303: aload_0
    //   304: putfield 542	com/tencent/mm/av/a/a/c$a:fullPath	Ljava/lang/String;
    //   307: aload 10
    //   309: iconst_1
    //   310: putfield 545	com/tencent/mm/av/a/a/c$a:jbf	Z
    //   313: aload 8
    //   315: aload 9
    //   317: aconst_null
    //   318: aload 10
    //   320: invokevirtual 549	com/tencent/mm/av/a/a/c$a:bdv	()Lcom/tencent/mm/av/a/a/c;
    //   323: invokevirtual 554	com/tencent/mm/av/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/av/a/a/c;)V
    //   326: aload 6
    //   328: aload 7
    //   330: invokevirtual 557	com/tencent/mm/storage/ca:Cz	(Ljava/lang/String;)V
    //   333: aload 6
    //   335: iconst_1
    //   336: invokevirtual 293	com/tencent/mm/storage/ca:nv	(I)V
    //   339: aload 6
    //   341: aload_1
    //   342: invokevirtual 296	com/tencent/mm/storage/ca:Cy	(Ljava/lang/String;)V
    //   345: aload 6
    //   347: iconst_3
    //   348: invokevirtual 299	com/tencent/mm/storage/ca:setStatus	(I)V
    //   351: aload 6
    //   353: aload 6
    //   355: invokestatic 560	com/tencent/mm/model/bp:x	(Lcom/tencent/mm/storage/ca;)J
    //   358: invokevirtual 563	com/tencent/mm/storage/ca:setMsgId	(J)V
    //   361: ldc 23
    //   363: ldc_w 565
    //   366: invokestatic 30	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 5
    //   371: getfield 484	com/tencent/mm/ag/k$b:iyz	Ljava/lang/String;
    //   374: iconst_1
    //   375: aload 6
    //   377: getfield 566	com/tencent/mm/g/c/eo:field_msgId	J
    //   380: invokestatic 568	com/tencent/mm/plugin/aa/model/i:a	(Ljava/lang/String;ZJ)V
    //   383: new 570	com/tencent/mm/ag/k
    //   386: dup
    //   387: invokespecial 571	com/tencent/mm/ag/k:<init>	()V
    //   390: astore_0
    //   391: aload 5
    //   393: aload_0
    //   394: invokevirtual 574	com/tencent/mm/ag/k$b:a	(Lcom/tencent/mm/ag/k;)V
    //   397: aload_0
    //   398: aload 6
    //   400: getfield 566	com/tencent/mm/g/c/eo:field_msgId	J
    //   403: putfield 575	com/tencent/mm/ag/k:field_msgId	J
    //   406: invokestatic 581	com/tencent/mm/plugin/r/a:eAT	()Lcom/tencent/mm/pluginsdk/model/app/l;
    //   409: aload_0
    //   410: invokevirtual 586	com/tencent/mm/pluginsdk/model/app/l:insert	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;)Z
    //   413: pop
    //   414: ldc_w 475
    //   417: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   22	370	5	localb	k.b
    //   51	348	6	localObject	Object
    //   58	271	7	str1	String
    //   283	31	8	locala	com.tencent.mm.av.a.a
    //   290	26	9	str2	String
    //   299	20	10	locala1	com.tencent.mm.av.a.a.c.a
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
  
  public static void bW(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(63340);
        if (Util.isNullOrNil(paramString1)) {
          break label357;
        }
        localObject = k.b.HD(paramString1);
        String str;
        if (localObject != null)
        {
          str = ((k.b)localObject).iyz;
          Log.d("MicroMsg.AAUtil", "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s", new Object[] { str, paramString1.trim().replace(" ", "") });
          if ((localObject == null) || (Util.isNullOrNil(((k.b)localObject).iyz))) {
            break label357;
          }
          str = ((k.b)localObject).iyz;
          localObject = com.tencent.mm.plugin.aa.b.blZ().SD(str);
          if (localObject != null) {
            break label366;
          }
          bool1 = true;
          if ((localObject == null) || (!((com.tencent.mm.plugin.aa.model.a.c)localObject).field_insertmsg)) {
            break label371;
          }
          if (localObject == null) {
            break label376;
          }
          l = ((com.tencent.mm.plugin.aa.model.a.c)localObject).field_localMsgId;
          Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, record==null: %s, billNo: %s, insertMsg: %s, chatroom: %s, localMsgId: %s", new Object[] { Boolean.valueOf(bool1), str, Boolean.valueOf(bool2), paramString2, Long.valueOf(l) });
          if (localObject == null)
          {
            Log.e("MicroMsg.AAUtil", "checkIfInsertAAMsg, record is null, ignore");
            a(str, false, 0L);
          }
          if ((localObject != null) && (((com.tencent.mm.plugin.aa.model.a.c)localObject).field_insertmsg) && (((com.tencent.mm.plugin.aa.model.a.c)localObject).field_localMsgId > 0L) && (((l)g.af(l.class)).eiy().Hb(((com.tencent.mm.plugin.aa.model.a.c)localObject).field_localMsgId).field_msgId <= 0L))
          {
            Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
            com.tencent.mm.plugin.aa.b.blZ().a((com.tencent.mm.plugin.aa.model.a.c)localObject, new String[0]);
            AppMethodBeat.o(63340);
          }
        }
        else
        {
          str = "";
          continue;
        }
        if ((localObject == null) || (!((com.tencent.mm.plugin.aa.model.a.c)localObject).field_insertmsg) || (((com.tencent.mm.plugin.aa.model.a.c)localObject).field_localMsgId <= 0L))
        {
          Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
          bV(paramString1, paramString2);
          AppMethodBeat.o(63340);
          continue;
        }
        Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
      }
      finally {}
      h(((com.tencent.mm.plugin.aa.model.a.c)localObject).field_localMsgId, paramString1);
      label357:
      AppMethodBeat.o(63340);
      continue;
      label366:
      boolean bool1 = false;
      continue;
      label371:
      bool2 = false;
      continue;
      label376:
      long l = 0L;
    }
  }
  
  public static long bX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63351);
    try
    {
      double d1 = Util.getDouble(paramString1, 0.0D);
      double d2 = Util.getDouble(paramString2, 0.0D);
      if (d1 == 0.0D) {
        paramString1 = "0";
      }
      paramString1 = new BigDecimal(paramString1);
      if (d2 == 0.0D) {
        paramString2 = "0";
      }
      long l = paramString1.multiply(new BigDecimal(paramString2)).longValue();
      AppMethodBeat.o(63351);
      return l;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.AAUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(63351);
    }
    return 0L;
  }
  
  public static String bml()
  {
    AppMethodBeat.i(63353);
    g.aAi();
    String str = Util.nullAsNil((String)g.aAh().azQ().get(ar.a.OcJ, null));
    AppMethodBeat.o(63353);
    return str;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(63342);
        Log.d("MicroMsg.AAUtil", "insertPayMsgAfterPaySucc, launcherUsername: %s, billNo: %s, payMsgId: %s", new Object[] { paramString1, paramString3, paramString4 });
        String str;
        if ((!Util.isNullOrNil(paramString1)) && (!Util.isNullOrNil(paramString3)) && (!Util.isNullOrNil(paramString4)))
        {
          com.tencent.mm.plugin.aa.model.a.a locala = com.tencent.mm.plugin.aa.b.bma().SC(paramString4);
          if ((locala == null) || (!locala.field_insertmsg)) {
            continue;
          }
          Log.i("MicroMsg.AAUtil", "insertPayMsgAfterPaySucc, launcherUsername: %s, chatroom: %s, payMsgId: %s, record: %s, insertmsg: %s", new Object[] { paramString1, paramString2, paramString4, locala, Boolean.valueOf(bool) });
          if ((locala == null) || (!locala.field_insertmsg))
          {
            str = "weixin://weixinnewaa/opendetail?billno=" + paramString3 + "&launcherusername=" + paramString1;
            if (!Util.isNullOrNil(paramString5)) {
              continue;
            }
            Log.i("MicroMsg.AAUtil", "empty msgxml, insert local msgcontent");
            if (!com.tencent.mm.ui.ao.isDarkMode()) {
              continue;
            }
            paramString3 = "#7D90A9";
            if (!paramString1.equals(z.aTY())) {
              continue;
            }
            paramString1 = MMApplicationContext.getContext().getString(2131763827, new Object[] { str, paramString3 });
            a(paramString1, paramString2, locala, paramString4, false);
          }
        }
        AppMethodBeat.o(63342);
        return;
        bool = false;
        continue;
        paramString3 = "#576B95";
        continue;
        paramString1 = ((com.tencent.mm.plugin.messenger.a.b)g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString1, paramString2);
        paramString1 = MMApplicationContext.getContext().getString(2131763828, new Object[] { paramString1, paramString3, str });
        continue;
        if (com.tencent.mm.ui.ao.isDarkMode())
        {
          paramString1 = "#7D90A9";
          paramString1 = paramString5.replace("\"#037AFF\"", "\"" + paramString1 + "\"");
          Log.d("MicroMsg.AAUtil", "insert msgxml: %s", new Object[] { paramString1 });
        }
        else
        {
          paramString1 = "#576B95";
        }
      }
      finally {}
    }
  }
  
  public static void h(long paramLong, String paramString)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(63345);
        if ((paramLong <= 0L) || (Util.isNullOrNil(paramString))) {
          break label389;
        }
        localObject = k.b.HD(paramString);
        if ((localObject == null) || (Util.isNullOrNil(((k.b)localObject).iyz))) {
          break label361;
        }
        Log.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", new Object[] { Long.valueOf(paramLong), ((k.b)localObject).iyz });
        com.tencent.mm.plugin.aa.model.a.c localc = com.tencent.mm.plugin.aa.b.blZ().SD(((k.b)localObject).iyz);
        if (localc != null)
        {
          long l = localc.field_localMsgId;
          localObject = ((l)g.af(l.class)).eiy().Hb(l);
          if (((eo)localObject).field_msgId > 0L)
          {
            String str = bp.Ks(((eo)localObject).field_content);
            ((ca)localObject).setContent(str + ":\n" + paramString);
            ((l)g.af(l.class)).eiy().a(l, (ca)localObject);
            Log.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", new Object[] { Long.valueOf(l), localc.field_billNo });
            AppMethodBeat.o(63345);
            return;
          }
          Log.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", new Object[] { localc.field_billNo, Long.valueOf(localc.field_localMsgId), Long.valueOf(paramLong), Long.valueOf(((eo)localObject).field_msgId) });
          AppMethodBeat.o(63345);
          continue;
        }
        paramString = new com.tencent.mm.plugin.aa.model.a.c();
      }
      finally {}
      paramString.field_localMsgId = paramLong;
      paramString.field_billNo = ((k.b)localObject).iyz;
      paramString.field_insertmsg = true;
      com.tencent.mm.plugin.aa.b.blZ().a(paramString);
      Log.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", new Object[] { Long.valueOf(paramLong), ((k.b)localObject).iyz });
      AppMethodBeat.o(63345);
      continue;
      label361:
      Log.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(63345);
      continue;
      label389:
      Log.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(Util.isNullOrNil(paramString)) });
      AppMethodBeat.o(63345);
    }
  }
  
  public static void i(long paramLong, String paramString)
  {
    AppMethodBeat.i(63346);
    Log.i("MicroMsg.AAUtil", "do update sys msg, %s, %s", new Object[] { Long.valueOf(paramLong), paramString });
    ca localca = ((l)g.af(l.class)).eiy().Hb(paramLong);
    paramString = Sz(paramString);
    if (!Util.isNullOrNil(paramString)) {
      localca.setContent(paramString);
    }
    ((l)g.af(l.class)).eiy().a(paramLong, localca);
    AppMethodBeat.o(63346);
  }
  
  public static double o(double paramDouble)
  {
    AppMethodBeat.i(63347);
    paramDouble = a(String.valueOf(paramDouble), "100", 2, 4);
    AppMethodBeat.o(63347);
    return paramDouble;
  }
  
  public static void u(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      AppMethodBeat.i(63341);
      com.tencent.mm.plugin.aa.model.a.c localc = com.tencent.mm.plugin.aa.b.blZ().SD(paramString1);
      Log.i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", new Object[] { paramString1, paramString2, Boolean.valueOf(Util.isNullOrNil(paramString3)), localc });
      if (localc == null) {
        a(paramString1, false, 0L);
      }
      bW(paramString3, paramString2);
      AppMethodBeat.o(63341);
      return;
    }
    finally {}
  }
  
  public static void uZ(int paramInt)
  {
    AppMethodBeat.i(63355);
    es locales = new es();
    locales.eEr = paramInt;
    locales.bfK();
    AppMethodBeat.o(63355);
  }
  
  public static void v(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(63343);
      }
      finally {}
      try
      {
        if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3))) {
          continue;
        }
        Log.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, chatroom: %s, payMsgId: %s", new Object[] { paramString2, paramString3 });
        if (!com.tencent.mm.ui.ao.isDarkMode()) {
          continue;
        }
        localObject = "#7D90A9";
        paramString1 = paramString1.replace("\"#037AFF\"", "\"" + (String)localObject + "\"");
        localObject = com.tencent.mm.plugin.aa.b.bma().SC(paramString3);
        if ((localObject != null) && (((com.tencent.mm.plugin.aa.model.a.a)localObject).field_insertmsg)) {
          continue;
        }
        Log.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, insert new msg");
        a(paramString1, paramString2, (com.tencent.mm.plugin.aa.model.a.a)localObject, paramString3, false);
        AppMethodBeat.o(63343);
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.AAUtil", "checkIfInsertPaySysMsg error: %s", new Object[] { paramString1.getMessage() });
        AppMethodBeat.o(63343);
        continue;
      }
      return;
      Object localObject = "#576B95";
      continue;
      paramString2 = ((l)g.af(l.class)).eiy().Hb(((com.tencent.mm.plugin.aa.model.a.a)localObject).field_msgId);
      Log.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", new Object[] { Long.valueOf(((com.tencent.mm.plugin.aa.model.a.a)localObject).field_msgId), Long.valueOf(paramString2.field_msgId) });
      paramString2.setContent(paramString1);
      ((l)g.af(l.class)).eiy().a(((com.tencent.mm.plugin.aa.model.a.a)localObject).field_msgId, paramString2);
      AppMethodBeat.o(63343);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.i
 * JD-Core Version:    0.7.0.1
 */