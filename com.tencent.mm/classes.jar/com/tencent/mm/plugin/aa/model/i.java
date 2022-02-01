package com.tencent.mm.plugin.aa.model;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.b.a.ch;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.aa.model.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.al;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class i
{
  /* Error */
  private static String Jc(String paramString)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 17
    //   8: invokestatic 23	com/tencent/mm/sdk/platformtools/bw:M	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   11: astore_0
    //   12: aload_0
    //   13: ifnonnull +11 -> 24
    //   16: ldc 9
    //   18: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: ldc 28
    //   23: areturn
    //   24: aload_0
    //   25: ldc 30
    //   27: invokeinterface 36 2 0
    //   32: checkcast 38	java/lang/String
    //   35: astore_0
    //   36: aload_0
    //   37: invokestatic 44	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   40: ifeq +18 -> 58
    //   43: ldc 46
    //   45: ldc 48
    //   47: invokestatic 54	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: ldc 9
    //   52: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: ldc 28
    //   57: areturn
    //   58: aload_0
    //   59: ldc 56
    //   61: invokestatic 62	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_0
    //   65: ldc 46
    //   67: ldc 64
    //   69: iconst_1
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_0
    //   76: aastore
    //   77: invokestatic 68	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: ldc 9
    //   82: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: areturn
    //   87: astore_1
    //   88: ldc 28
    //   90: astore_0
    //   91: ldc 46
    //   93: aload_1
    //   94: invokevirtual 72	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   97: invokestatic 54	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: goto -20 -> 80
    //   103: astore_1
    //   104: goto -13 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramString	String
    //   87	7	1	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   103	1	1	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   58	65	87	java/io/UnsupportedEncodingException
    //   65	80	103	java/io/UnsupportedEncodingException
  }
  
  public static List<String> Jd(String paramString)
  {
    AppMethodBeat.i(63352);
    if (bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.AAUtil", "illegal chatroomName");
      paramString = new ArrayList();
      AppMethodBeat.o(63352);
      return paramString;
    }
    Object localObject;
    if (!w.vF(paramString))
    {
      localObject = new ArrayList();
      ((List)localObject).add(u.aAm());
      ((List)localObject).add(paramString);
      AppMethodBeat.o(63352);
      return localObject;
    }
    try
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AR(paramString);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = new ArrayList();
      }
      AppMethodBeat.o(63352);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.AAUtil", "getChatroomMemberList error! %s", new Object[] { paramString.getMessage() });
      paramString = new ArrayList();
      AppMethodBeat.o(63352);
    }
    return paramString;
  }
  
  public static void Je(String paramString)
  {
    AppMethodBeat.i(63354);
    Object localObject = aRh();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(",");
    if (!bt.isNullOrNil((String)localObject))
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
    ad.d("MicroMsg.AAUtil", "recent group: %s", new Object[] { localStringBuilder.toString() });
    g.ajD();
    g.ajC().ajl().set(al.a.IzW, localStringBuilder.toString());
    AppMethodBeat.o(63354);
  }
  
  public static double a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63350);
    try
    {
      if (bt.getDouble(paramString1.trim(), 0.0D) == 0.0D) {}
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
      ad.printErrStackTrace("MicroMsg.AAUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(63350);
    }
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.plugin.aa.model.a.a parama, String paramString3, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(63344);
      bu localbu = new bu();
      localbu.kr(0);
      localbu.tN(paramString2);
      localbu.setStatus(3);
      localbu.setContent(paramString1);
      localbu.qA(bj.B(paramString2, System.currentTimeMillis() / 1000L));
      localbu.setType(10000);
      if (paramBoolean) {
        localbu.setFlag(localbu.field_flag | 0x8);
      }
      long l = ((l)g.ab(l.class)).dlK().as(localbu);
      ad.i("MicroMsg.AAUtil", "insertPaySysMsg, inserted msgId: %s", new Object[] { Long.valueOf(l) });
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
        com.tencent.mm.plugin.aa.b.aQX().replace(paramString1);
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
      if (!bt.isNullOrNil(paramString))
      {
        ad.i("MicroMsg.AAUtil", "insertOrUpdateAARecord, billNo: %s, insertMsg: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        com.tencent.mm.plugin.aa.model.a.c localc = new com.tencent.mm.plugin.aa.model.a.c();
        localc.field_billNo = paramString;
        localc.field_insertmsg = paramBoolean;
        localc.field_localMsgId = paramLong;
        com.tencent.mm.plugin.aa.b.aQW().b(localc);
      }
      AppMethodBeat.o(63339);
      return;
    }
    finally {}
  }
  
  public static boolean a(Activity paramActivity, z paramz)
  {
    AppMethodBeat.i(63348);
    boolean bool;
    if (paramz.Fqw == 1)
    {
      ad.i("MicroMsg.AAUtil", "need realname verify");
      paramz = new Bundle();
      paramz.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
      paramz.putString("realname_verify_process_jump_plugin", "aa");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramz, null, 0);
      AppMethodBeat.o(63348);
      return bool;
    }
    if (paramz.Fqw == 2)
    {
      ad.i("MicroMsg.AAUtil", "need upload credit");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramz.vqB, paramz.vqC, paramz.kzK, paramz.kzL, false, null);
      AppMethodBeat.o(63348);
      return bool;
    }
    ad.i("MicroMsg.AAUtil", "realnameGuideFlag =  " + paramz.Fqw);
    AppMethodBeat.o(63348);
    return false;
  }
  
  public static String aRh()
  {
    AppMethodBeat.i(63353);
    g.ajD();
    String str = bt.nullAsNil((String)g.ajC().ajl().get(al.a.IzW, null));
    AppMethodBeat.o(63353);
    return str;
  }
  
  /* Error */
  private static void bM(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 404
    //   8: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokestatic 44	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   15: ifne +399 -> 414
    //   18: aload_0
    //   19: invokestatic 410	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   22: astore 5
    //   24: aload 5
    //   26: ifnull +388 -> 414
    //   29: aload 5
    //   31: getfield 413	com/tencent/mm/ai/k$b:hBF	Ljava/lang/String;
    //   34: invokestatic 44	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +377 -> 414
    //   40: invokestatic 339	com/tencent/mm/plugin/aa/b:aQW	()Lcom/tencent/mm/plugin/aa/model/a/d;
    //   43: aload 5
    //   45: getfield 413	com/tencent/mm/ai/k$b:hBF	Ljava/lang/String;
    //   48: invokevirtual 417	com/tencent/mm/plugin/aa/model/a/d:Jg	(Ljava/lang/String;)Lcom/tencent/mm/plugin/aa/model/a/c;
    //   51: astore 6
    //   53: aload 5
    //   55: getfield 413	com/tencent/mm/ai/k$b:hBF	Ljava/lang/String;
    //   58: astore 7
    //   60: aload 6
    //   62: ifnull +85 -> 147
    //   65: aload 6
    //   67: getfield 332	com/tencent/mm/plugin/aa/model/a/c:field_insertmsg	Z
    //   70: ifeq +77 -> 147
    //   73: aload 6
    //   75: ifnull +77 -> 152
    //   78: aload 6
    //   80: getfield 335	com/tencent/mm/plugin/aa/model/a/c:field_localMsgId	J
    //   83: lstore_3
    //   84: ldc 46
    //   86: ldc_w 419
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
    //   110: invokestatic 325	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   113: aastore
    //   114: dup
    //   115: iconst_4
    //   116: lload_3
    //   117: invokestatic 284	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: aastore
    //   121: invokestatic 286	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload 6
    //   126: ifnonnull +31 -> 157
    //   129: ldc 46
    //   131: ldc_w 421
    //   134: invokestatic 54	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: ldc_w 404
    //   140: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   159: getfield 332	com/tencent/mm/plugin/aa/model/a/c:field_insertmsg	Z
    //   162: ifeq +13 -> 175
    //   165: aload 6
    //   167: getfield 335	com/tencent/mm/plugin/aa/model/a/c:field_localMsgId	J
    //   170: lconst_0
    //   171: lcmp
    //   172: ifgt +242 -> 414
    //   175: new 221	com/tencent/mm/storage/bu
    //   178: dup
    //   179: invokespecial 222	com/tencent/mm/storage/bu:<init>	()V
    //   182: astore 6
    //   184: aload 6
    //   186: aload_1
    //   187: invokestatic 425	com/tencent/mm/model/bj:Bo	(Ljava/lang/String;)J
    //   190: invokevirtual 252	com/tencent/mm/storage/bu:qA	(J)V
    //   193: aload 6
    //   195: ldc_w 426
    //   198: invokevirtual 255	com/tencent/mm/storage/bu:setType	(I)V
    //   201: invokestatic 98	com/tencent/mm/model/u:aAm	()Ljava/lang/String;
    //   204: astore 7
    //   206: aload 6
    //   208: new 136	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   215: aload 7
    //   217: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc_w 428
    //   223: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_0
    //   227: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokevirtual 234	com/tencent/mm/storage/bu:setContent	(Ljava/lang/String;)V
    //   236: new 136	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   243: invokestatic 431	com/tencent/mm/sdk/platformtools/bt:flT	()J
    //   246: invokevirtual 434	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokevirtual 438	java/lang/String:getBytes	()[B
    //   255: invokestatic 444	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   258: astore 7
    //   260: invokestatic 450	com/tencent/mm/aw/q:aIF	()Lcom/tencent/mm/aw/i;
    //   263: aload 7
    //   265: invokevirtual 455	com/tencent/mm/aw/i:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   268: astore_0
    //   269: invokestatic 450	com/tencent/mm/aw/q:aIF	()Lcom/tencent/mm/aw/i;
    //   272: pop
    //   273: aload 7
    //   275: invokestatic 458	com/tencent/mm/aw/i:wb	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 7
    //   280: invokestatic 462	com/tencent/mm/aw/q:aIJ	()Lcom/tencent/mm/aw/a/a;
    //   283: astore 8
    //   285: aload 5
    //   287: getfield 465	com/tencent/mm/ai/k$b:hBp	Ljava/lang/String;
    //   290: astore 9
    //   292: new 467	com/tencent/mm/aw/a/a/c$a
    //   295: dup
    //   296: invokespecial 468	com/tencent/mm/aw/a/a/c$a:<init>	()V
    //   299: astore 10
    //   301: aload 10
    //   303: aload_0
    //   304: putfield 471	com/tencent/mm/aw/a/a/c$a:hdP	Ljava/lang/String;
    //   307: aload 10
    //   309: iconst_1
    //   310: putfield 474	com/tencent/mm/aw/a/a/c$a:idr	Z
    //   313: aload 8
    //   315: aload 9
    //   317: aconst_null
    //   318: aload 10
    //   320: invokevirtual 478	com/tencent/mm/aw/a/a/c$a:aJc	()Lcom/tencent/mm/aw/a/a/c;
    //   323: invokevirtual 483	com/tencent/mm/aw/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/aw/a/a/c;)V
    //   326: aload 6
    //   328: aload 7
    //   330: invokevirtual 486	com/tencent/mm/storage/bu:tO	(Ljava/lang/String;)V
    //   333: aload 6
    //   335: iconst_1
    //   336: invokevirtual 225	com/tencent/mm/storage/bu:kr	(I)V
    //   339: aload 6
    //   341: aload_1
    //   342: invokevirtual 228	com/tencent/mm/storage/bu:tN	(Ljava/lang/String;)V
    //   345: aload 6
    //   347: iconst_3
    //   348: invokevirtual 231	com/tencent/mm/storage/bu:setStatus	(I)V
    //   351: aload 6
    //   353: aload 6
    //   355: invokestatic 489	com/tencent/mm/model/bj:v	(Lcom/tencent/mm/storage/bu;)J
    //   358: invokevirtual 492	com/tencent/mm/storage/bu:setMsgId	(J)V
    //   361: ldc 46
    //   363: ldc_w 494
    //   366: invokestatic 82	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 5
    //   371: getfield 413	com/tencent/mm/ai/k$b:hBF	Ljava/lang/String;
    //   374: iconst_1
    //   375: aload 6
    //   377: getfield 495	com/tencent/mm/g/c/ei:field_msgId	J
    //   380: invokestatic 497	com/tencent/mm/plugin/aa/model/i:a	(Ljava/lang/String;ZJ)V
    //   383: new 499	com/tencent/mm/ai/k
    //   386: dup
    //   387: invokespecial 500	com/tencent/mm/ai/k:<init>	()V
    //   390: astore_0
    //   391: aload 5
    //   393: aload_0
    //   394: invokevirtual 503	com/tencent/mm/ai/k$b:a	(Lcom/tencent/mm/ai/k;)V
    //   397: aload_0
    //   398: aload 6
    //   400: getfield 495	com/tencent/mm/g/c/ei:field_msgId	J
    //   403: putfield 504	com/tencent/mm/ai/k:field_msgId	J
    //   406: invokestatic 510	com/tencent/mm/plugin/s/a:dxR	()Lcom/tencent/mm/pluginsdk/model/app/l;
    //   409: aload_0
    //   410: invokevirtual 515	com/tencent/mm/pluginsdk/model/app/l:insert	(Lcom/tencent/mm/sdk/e/c;)Z
    //   413: pop
    //   414: ldc_w 404
    //   417: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   283	31	8	locala	com.tencent.mm.aw.a.a
    //   290	26	9	str2	String
    //   299	20	10	locala1	com.tencent.mm.aw.a.a.c.a
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
  
  public static void bN(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(63340);
        if (bt.isNullOrNil(paramString1)) {
          break label357;
        }
        localObject = k.b.yr(paramString1);
        String str;
        if (localObject != null)
        {
          str = ((k.b)localObject).hBF;
          ad.d("MicroMsg.AAUtil", "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s", new Object[] { str, paramString1.trim().replace(" ", "") });
          if ((localObject == null) || (bt.isNullOrNil(((k.b)localObject).hBF))) {
            break label357;
          }
          str = ((k.b)localObject).hBF;
          localObject = com.tencent.mm.plugin.aa.b.aQW().Jg(str);
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
          ad.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, record==null: %s, billNo: %s, insertMsg: %s, chatroom: %s, localMsgId: %s", new Object[] { Boolean.valueOf(bool1), str, Boolean.valueOf(bool2), paramString2, Long.valueOf(l) });
          if (localObject == null)
          {
            ad.e("MicroMsg.AAUtil", "checkIfInsertAAMsg, record is null, ignore");
            a(str, false, 0L);
          }
          if ((localObject != null) && (((com.tencent.mm.plugin.aa.model.a.c)localObject).field_insertmsg) && (((com.tencent.mm.plugin.aa.model.a.c)localObject).field_localMsgId > 0L) && (((l)g.ab(l.class)).dlK().xY(((com.tencent.mm.plugin.aa.model.a.c)localObject).field_localMsgId).field_msgId <= 0L))
          {
            ad.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
            com.tencent.mm.plugin.aa.b.aQW().a((com.tencent.mm.plugin.aa.model.a.c)localObject, new String[0]);
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
          ad.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
          bM(paramString1, paramString2);
          AppMethodBeat.o(63340);
          continue;
        }
        ad.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
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
  
  public static long bO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63351);
    try
    {
      double d1 = bt.getDouble(paramString1, 0.0D);
      double d2 = bt.getDouble(paramString2, 0.0D);
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
      ad.printErrStackTrace("MicroMsg.AAUtil", paramString1, "", new Object[0]);
      AppMethodBeat.o(63351);
    }
    return 0L;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(63342);
        ad.d("MicroMsg.AAUtil", "insertPayMsgAfterPaySucc, launcherUsername: %s, billNo: %s, payMsgId: %s", new Object[] { paramString1, paramString3, paramString4 });
        String str;
        if ((!bt.isNullOrNil(paramString1)) && (!bt.isNullOrNil(paramString3)) && (!bt.isNullOrNil(paramString4)))
        {
          com.tencent.mm.plugin.aa.model.a.a locala = com.tencent.mm.plugin.aa.b.aQX().Jf(paramString4);
          if ((locala == null) || (!locala.field_insertmsg)) {
            continue;
          }
          ad.i("MicroMsg.AAUtil", "insertPayMsgAfterPaySucc, launcherUsername: %s, chatroom: %s, payMsgId: %s, record: %s, insertmsg: %s", new Object[] { paramString1, paramString2, paramString4, locala, Boolean.valueOf(bool) });
          if ((locala == null) || (!locala.field_insertmsg))
          {
            str = "weixin://weixinnewaa/opendetail?billno=" + paramString3 + "&launcherusername=" + paramString1;
            if (!bt.isNullOrNil(paramString5)) {
              continue;
            }
            ad.i("MicroMsg.AAUtil", "empty msgxml, insert local msgcontent");
            if (!al.isDarkMode()) {
              continue;
            }
            paramString3 = "#7D90A9";
            if (!paramString1.equals(u.aAm())) {
              continue;
            }
            paramString1 = aj.getContext().getString(2131761839, new Object[] { str, paramString3 });
            a(paramString1, paramString2, locala, paramString4, false);
          }
        }
        AppMethodBeat.o(63342);
        return;
        bool = false;
        continue;
        paramString3 = "#576B95";
        continue;
        paramString1 = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramString1, paramString2);
        paramString1 = aj.getContext().getString(2131761840, new Object[] { paramString1, paramString3, str });
        continue;
        if (al.isDarkMode())
        {
          paramString1 = "#7D90A9";
          paramString1 = paramString5.replace("\"#037AFF\"", "\"" + paramString1 + "\"");
          ad.d("MicroMsg.AAUtil", "insert msgxml: %s", new Object[] { paramString1 });
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
        if ((paramLong <= 0L) || (bt.isNullOrNil(paramString))) {
          break label389;
        }
        localObject = k.b.yr(paramString);
        if ((localObject == null) || (bt.isNullOrNil(((k.b)localObject).hBF))) {
          break label361;
        }
        ad.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", new Object[] { Long.valueOf(paramLong), ((k.b)localObject).hBF });
        com.tencent.mm.plugin.aa.model.a.c localc = com.tencent.mm.plugin.aa.b.aQW().Jg(((k.b)localObject).hBF);
        if (localc != null)
        {
          long l = localc.field_localMsgId;
          localObject = ((l)g.ab(l.class)).dlK().xY(l);
          if (((ei)localObject).field_msgId > 0L)
          {
            String str = bj.Bk(((ei)localObject).field_content);
            ((bu)localObject).setContent(str + ":\n" + paramString);
            ((l)g.ab(l.class)).dlK().a(l, (bu)localObject);
            ad.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", new Object[] { Long.valueOf(l), localc.field_billNo });
            AppMethodBeat.o(63345);
            return;
          }
          ad.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", new Object[] { localc.field_billNo, Long.valueOf(localc.field_localMsgId), Long.valueOf(paramLong), Long.valueOf(((ei)localObject).field_msgId) });
          AppMethodBeat.o(63345);
          continue;
        }
        paramString = new com.tencent.mm.plugin.aa.model.a.c();
      }
      finally {}
      paramString.field_localMsgId = paramLong;
      paramString.field_billNo = ((k.b)localObject).hBF;
      paramString.field_insertmsg = true;
      com.tencent.mm.plugin.aa.b.aQW().a(paramString);
      ad.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", new Object[] { Long.valueOf(paramLong), ((k.b)localObject).hBF });
      AppMethodBeat.o(63345);
      continue;
      label361:
      ad.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(63345);
      continue;
      label389:
      ad.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bt.isNullOrNil(paramString)) });
      AppMethodBeat.o(63345);
    }
  }
  
  public static void i(long paramLong, String paramString)
  {
    AppMethodBeat.i(63346);
    ad.i("MicroMsg.AAUtil", "do update sys msg, %s, %s", new Object[] { Long.valueOf(paramLong), paramString });
    bu localbu = ((l)g.ab(l.class)).dlK().xY(paramLong);
    paramString = Jc(paramString);
    if (!bt.isNullOrNil(paramString)) {
      localbu.setContent(paramString);
    }
    ((l)g.ab(l.class)).dlK().a(paramLong, localbu);
    AppMethodBeat.o(63346);
  }
  
  public static double n(double paramDouble)
  {
    AppMethodBeat.i(63347);
    paramDouble = a(String.valueOf(paramDouble), "100", 2, 4);
    AppMethodBeat.o(63347);
    return paramDouble;
  }
  
  public static void rf(int paramInt)
  {
    AppMethodBeat.i(63355);
    ch localch = new ch();
    localch.ecv = paramInt;
    localch.aLk();
    AppMethodBeat.o(63355);
  }
  
  public static void u(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      AppMethodBeat.i(63341);
      com.tencent.mm.plugin.aa.model.a.c localc = com.tencent.mm.plugin.aa.b.aQW().Jg(paramString1);
      ad.i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", new Object[] { paramString1, paramString2, Boolean.valueOf(bt.isNullOrNil(paramString3)), localc });
      if (localc == null) {
        a(paramString1, false, 0L);
      }
      bN(paramString3, paramString2);
      AppMethodBeat.o(63341);
      return;
    }
    finally {}
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
        if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString3))) {
          continue;
        }
        ad.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, chatroom: %s, payMsgId: %s", new Object[] { paramString2, paramString3 });
        if (!al.isDarkMode()) {
          continue;
        }
        localObject = "#7D90A9";
        paramString1 = paramString1.replace("\"#037AFF\"", "\"" + (String)localObject + "\"");
        localObject = com.tencent.mm.plugin.aa.b.aQX().Jf(paramString3);
        if ((localObject != null) && (((com.tencent.mm.plugin.aa.model.a.a)localObject).field_insertmsg)) {
          continue;
        }
        ad.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, insert new msg");
        a(paramString1, paramString2, (com.tencent.mm.plugin.aa.model.a.a)localObject, paramString3, false);
        AppMethodBeat.o(63343);
      }
      catch (Exception paramString1)
      {
        ad.e("MicroMsg.AAUtil", "checkIfInsertPaySysMsg error: %s", new Object[] { paramString1.getMessage() });
        AppMethodBeat.o(63343);
        continue;
      }
      return;
      Object localObject = "#576B95";
      continue;
      paramString2 = ((l)g.ab(l.class)).dlK().xY(((com.tencent.mm.plugin.aa.model.a.a)localObject).field_msgId);
      ad.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", new Object[] { Long.valueOf(((com.tencent.mm.plugin.aa.model.a.a)localObject).field_msgId), Long.valueOf(paramString2.field_msgId) });
      paramString2.setContent(paramString1);
      ((l)g.ab(l.class)).dlK().a(((com.tencent.mm.plugin.aa.model.a.a)localObject).field_msgId, paramString2);
      AppMethodBeat.o(63343);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.i
 * JD-Core Version:    0.7.0.1
 */