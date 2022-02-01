package com.tencent.mm.plugin.aa.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.b.a.fv;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.a.c;
import com.tencent.mm.plugin.aa.model.a.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ac;
import com.tencent.mm.protocal.protobuf.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
{
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
    AppMethodBeat.i(193370);
    Log.d("MicroMsg.AAUtil", "startAAPay, reqKey: %s, isFromChatting: %s", new Object[] { paramString1, Boolean.valueOf(paramBoolean) });
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.fwv = paramString1;
    localPayInfo.fOY = 42;
    if (paramBoolean) {}
    for (localPayInfo.channel = 14;; localPayInfo.channel = 1)
    {
      paramString1 = new Bundle();
      paramString1.putString("extinfo_key_1", paramString3);
      localPayInfo.lfu = paramString1;
      com.tencent.mm.wallet_core.b.iie();
      if (!com.tencent.mm.wallet_core.b.b(b.a.vCG, true)) {
        break;
      }
      localPayInfo.lfu.putString("extinfo_key_2", paramString2);
      ((com.tencent.mm.pluginsdk.wallet.a)h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(paramContext, localPayInfo);
      AppMethodBeat.o(193370);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(paramContext, false, "", localPayInfo, paramString2, new Intent(), 233);
    AppMethodBeat.o(193370);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.plugin.aa.model.a.a parama, String paramString3, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(63344);
      ca localca = new ca();
      localca.pJ(0);
      localca.Jm(paramString2);
      localca.setStatus(3);
      localca.setContent(paramString1);
      localca.setCreateTime(bq.z(paramString2, System.currentTimeMillis() / 1000L));
      localca.setType(10000);
      if (paramBoolean) {
        localca.setFlag(localca.field_flag | 0x8);
      }
      long l = ((n)h.ae(n.class)).eSe().aM(localca);
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
        com.tencent.mm.plugin.aa.b.bwi().replace(paramString1);
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
        c localc = new c();
        localc.field_billNo = paramString;
        localc.field_insertmsg = paramBoolean;
        localc.field_localMsgId = paramLong;
        com.tencent.mm.plugin.aa.b.bwh().b(localc);
      }
      AppMethodBeat.o(63339);
      return;
    }
    finally {}
  }
  
  public static boolean a(Activity paramActivity, ac paramac)
  {
    AppMethodBeat.i(63348);
    boolean bool;
    if (paramac.REc == 1)
    {
      Log.i("MicroMsg.AAUtil", "need realname verify");
      paramac = new Bundle();
      paramac.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
      paramac.putString("realname_verify_process_jump_plugin", "aa");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramac, null, 0);
      AppMethodBeat.o(63348);
      return bool;
    }
    if (paramac.REc == 2)
    {
      Log.i("MicroMsg.AAUtil", "need upload credit");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramac.EBN, paramac.EBO, paramac.oDJ, paramac.oDK, false, null);
      AppMethodBeat.o(63348);
      return bool;
    }
    Log.i("MicroMsg.AAUtil", "realnameGuideFlag =  " + paramac.REc);
    AppMethodBeat.o(63348);
    return false;
  }
  
  public static x aO(List<x> paramList)
  {
    AppMethodBeat.i(193357);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      x localx = (x)paramList.next();
      if (localx.llP.equals(z.bcZ()))
      {
        AppMethodBeat.o(193357);
        return localx;
      }
    }
    Log.i("MicroMsg.AAUtil", "not contains self");
    AppMethodBeat.o(193357);
    return null;
  }
  
  /* Error */
  private static String aaf(String paramString)
  {
    // Byte code:
    //   0: ldc_w 356
    //   3: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 358
    //   10: aconst_null
    //   11: invokestatic 364	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnonnull +12 -> 28
    //   19: ldc_w 356
    //   22: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: ldc 50
    //   27: areturn
    //   28: aload_0
    //   29: ldc_w 366
    //   32: invokeinterface 372 2 0
    //   37: checkcast 17	java/lang/String
    //   40: astore_0
    //   41: aload_0
    //   42: invokestatic 240	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   45: ifeq +20 -> 65
    //   48: ldc 48
    //   50: ldc_w 374
    //   53: invokestatic 377	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: ldc_w 356
    //   59: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: ldc 50
    //   64: areturn
    //   65: aload_0
    //   66: ldc_w 379
    //   69: invokestatic 385	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_0
    //   73: ldc 48
    //   75: ldc_w 387
    //   78: iconst_1
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_0
    //   85: aastore
    //   86: invokestatic 71	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: ldc_w 356
    //   92: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: areturn
    //   97: astore_1
    //   98: ldc 50
    //   100: astore_0
    //   101: ldc 48
    //   103: aload_1
    //   104: invokevirtual 390	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   107: invokestatic 377	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: goto -21 -> 89
    //   113: astore_1
    //   114: goto -13 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString	String
    //   97	7	1	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   113	1	1	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   65	73	97	java/io/UnsupportedEncodingException
    //   73	89	113	java/io/UnsupportedEncodingException
  }
  
  public static List<String> aag(String paramString)
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
    if (!ab.Lj(paramString))
    {
      localObject = new ArrayList();
      ((List)localObject).add(z.bcZ());
      ((List)localObject).add(paramString);
      AppMethodBeat.o(63352);
      return localObject;
    }
    try
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().RA(paramString);
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
  
  public static void aah(String paramString)
  {
    AppMethodBeat.i(63354);
    Object localObject = bwt();
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
    h.aHH();
    h.aHG().aHp().set(ar.a.VqM, localStringBuilder.toString());
    AppMethodBeat.o(63354);
  }
  
  public static String bwt()
  {
    AppMethodBeat.i(63353);
    h.aHH();
    String str = Util.nullAsNil((String)h.aHG().aHp().get(ar.a.VqM, null));
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
          com.tencent.mm.plugin.aa.model.a.a locala = com.tencent.mm.plugin.aa.b.bwi().aai(paramString4);
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
            if (!ar.isDarkMode()) {
              continue;
            }
            paramString3 = "#7D90A9";
            if (!paramString1.equals(z.bcZ())) {
              continue;
            }
            paramString1 = MMApplicationContext.getContext().getString(a.i.pay_sys_msg_tmpl_launch_by_myself, new Object[] { str, paramString3 });
            a(paramString1, paramString2, locala, paramString4, false);
          }
        }
        AppMethodBeat.o(63342);
        return;
        bool = false;
        continue;
        paramString3 = "#576B95";
        continue;
        paramString1 = ((com.tencent.mm.plugin.messenger.a.b)h.ae(com.tencent.mm.plugin.messenger.a.b.class)).aL(paramString1, paramString2);
        paramString1 = MMApplicationContext.getContext().getString(a.i.pay_sys_msg_tmpl_launch_by_other, new Object[] { paramString1, paramString3, str });
        continue;
        if (ar.isDarkMode())
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
  
  /* Error */
  private static void cb(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 544
    //   8: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokestatic 240	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   15: ifne +399 -> 414
    //   18: aload_0
    //   19: invokestatic 550	com/tencent/mm/aj/k$b:OQ	(Ljava/lang/String;)Lcom/tencent/mm/aj/k$b;
    //   22: astore 5
    //   24: aload 5
    //   26: ifnull +388 -> 414
    //   29: aload 5
    //   31: getfield 553	com/tencent/mm/aj/k$b:lnP	Ljava/lang/String;
    //   34: invokestatic 240	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +377 -> 414
    //   40: invokestatic 256	com/tencent/mm/plugin/aa/b:bwh	()Lcom/tencent/mm/plugin/aa/model/a/d;
    //   43: aload 5
    //   45: getfield 553	com/tencent/mm/aj/k$b:lnP	Ljava/lang/String;
    //   48: invokevirtual 557	com/tencent/mm/plugin/aa/model/a/d:aaj	(Ljava/lang/String;)Lcom/tencent/mm/plugin/aa/model/a/c;
    //   51: astore 6
    //   53: aload 5
    //   55: getfield 553	com/tencent/mm/aj/k$b:lnP	Ljava/lang/String;
    //   58: astore 7
    //   60: aload 6
    //   62: ifnull +85 -> 147
    //   65: aload 6
    //   67: getfield 249	com/tencent/mm/plugin/aa/model/a/c:field_insertmsg	Z
    //   70: ifeq +77 -> 147
    //   73: aload 6
    //   75: ifnull +77 -> 152
    //   78: aload 6
    //   80: getfield 252	com/tencent/mm/plugin/aa/model/a/c:field_localMsgId	J
    //   83: lstore_3
    //   84: ldc 48
    //   86: ldc_w 559
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
    //   110: invokestatic 67	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   113: aastore
    //   114: dup
    //   115: iconst_4
    //   116: lload_3
    //   117: invokestatic 203	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: aastore
    //   121: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload 6
    //   126: ifnonnull +31 -> 157
    //   129: ldc 48
    //   131: ldc_w 561
    //   134: invokestatic 377	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: ldc_w 544
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
    //   159: getfield 249	com/tencent/mm/plugin/aa/model/a/c:field_insertmsg	Z
    //   162: ifeq +13 -> 175
    //   165: aload 6
    //   167: getfield 252	com/tencent/mm/plugin/aa/model/a/c:field_localMsgId	J
    //   170: lconst_0
    //   171: lcmp
    //   172: ifgt +242 -> 414
    //   175: new 142	com/tencent/mm/storage/ca
    //   178: dup
    //   179: invokespecial 143	com/tencent/mm/storage/ca:<init>	()V
    //   182: astore 6
    //   184: aload 6
    //   186: aload_1
    //   187: invokestatic 565	com/tencent/mm/model/bq:RP	(Ljava/lang/String;)J
    //   190: invokevirtual 173	com/tencent/mm/storage/ca:setCreateTime	(J)V
    //   193: aload 6
    //   195: ldc_w 566
    //   198: invokevirtual 176	com/tencent/mm/storage/ca:setType	(I)V
    //   201: invokestatic 343	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
    //   204: astore 7
    //   206: aload 6
    //   208: new 304	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 429	java/lang/StringBuilder:<init>	()V
    //   215: aload 7
    //   217: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc_w 568
    //   223: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_0
    //   227: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokevirtual 155	com/tencent/mm/storage/ca:setContent	(Ljava/lang/String;)V
    //   236: new 304	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 429	java/lang/StringBuilder:<init>	()V
    //   243: invokestatic 571	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   246: invokevirtual 574	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: invokevirtual 314	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokevirtual 578	java/lang/String:getBytes	()[B
    //   255: invokestatic 584	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   258: astore 7
    //   260: invokestatic 590	com/tencent/mm/ay/q:bmh	()Lcom/tencent/mm/ay/i;
    //   263: aload 7
    //   265: invokevirtual 595	com/tencent/mm/ay/i:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   268: astore_0
    //   269: invokestatic 590	com/tencent/mm/ay/q:bmh	()Lcom/tencent/mm/ay/i;
    //   272: pop
    //   273: aload 7
    //   275: invokestatic 598	com/tencent/mm/ay/i:LQ	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 7
    //   280: invokestatic 602	com/tencent/mm/ay/q:bml	()Lcom/tencent/mm/ay/a/a;
    //   283: astore 8
    //   285: aload 5
    //   287: getfield 605	com/tencent/mm/aj/k$b:lnz	Ljava/lang/String;
    //   290: astore 9
    //   292: new 607	com/tencent/mm/ay/a/a/c$a
    //   295: dup
    //   296: invokespecial 608	com/tencent/mm/ay/a/a/c$a:<init>	()V
    //   299: astore 10
    //   301: aload 10
    //   303: aload_0
    //   304: putfield 611	com/tencent/mm/ay/a/a/c$a:fullPath	Ljava/lang/String;
    //   307: aload 10
    //   309: iconst_1
    //   310: putfield 614	com/tencent/mm/ay/a/a/c$a:lRD	Z
    //   313: aload 8
    //   315: aload 9
    //   317: aconst_null
    //   318: aload 10
    //   320: invokevirtual 618	com/tencent/mm/ay/a/a/c$a:bmL	()Lcom/tencent/mm/ay/a/a/c;
    //   323: invokevirtual 623	com/tencent/mm/ay/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/ay/a/a/c;)V
    //   326: aload 6
    //   328: aload 7
    //   330: invokevirtual 626	com/tencent/mm/storage/ca:Jn	(Ljava/lang/String;)V
    //   333: aload 6
    //   335: iconst_1
    //   336: invokevirtual 146	com/tencent/mm/storage/ca:pJ	(I)V
    //   339: aload 6
    //   341: aload_1
    //   342: invokevirtual 149	com/tencent/mm/storage/ca:Jm	(Ljava/lang/String;)V
    //   345: aload 6
    //   347: iconst_3
    //   348: invokevirtual 152	com/tencent/mm/storage/ca:setStatus	(I)V
    //   351: aload 6
    //   353: aload 6
    //   355: invokestatic 628	com/tencent/mm/model/bq:z	(Lcom/tencent/mm/storage/ca;)J
    //   358: invokevirtual 631	com/tencent/mm/storage/ca:setMsgId	(J)V
    //   361: ldc 48
    //   363: ldc_w 633
    //   366: invokestatic 272	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 5
    //   371: getfield 553	com/tencent/mm/aj/k$b:lnP	Ljava/lang/String;
    //   374: iconst_1
    //   375: aload 6
    //   377: getfield 634	com/tencent/mm/f/c/et:field_msgId	J
    //   380: invokestatic 636	com/tencent/mm/plugin/aa/model/i:a	(Ljava/lang/String;ZJ)V
    //   383: new 638	com/tencent/mm/aj/k
    //   386: dup
    //   387: invokespecial 639	com/tencent/mm/aj/k:<init>	()V
    //   390: astore_0
    //   391: aload 5
    //   393: aload_0
    //   394: invokevirtual 642	com/tencent/mm/aj/k$b:a	(Lcom/tencent/mm/aj/k;)V
    //   397: aload_0
    //   398: aload 6
    //   400: getfield 634	com/tencent/mm/f/c/et:field_msgId	J
    //   403: putfield 643	com/tencent/mm/aj/k:field_msgId	J
    //   406: invokestatic 649	com/tencent/mm/plugin/ab/a:fmA	()Lcom/tencent/mm/pluginsdk/model/app/l;
    //   409: aload_0
    //   410: invokevirtual 654	com/tencent/mm/pluginsdk/model/app/l:insert	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;)Z
    //   413: pop
    //   414: ldc_w 544
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
    //   22	370	5	localb	k.b
    //   51	348	6	localObject	Object
    //   58	271	7	str1	String
    //   283	31	8	locala	com.tencent.mm.ay.a.a
    //   290	26	9	str2	String
    //   299	20	10	locala1	com.tencent.mm.ay.a.a.c.a
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
  
  public static void cc(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(63340);
        if (Util.isNullOrNil(paramString1)) {
          break label356;
        }
        localObject = k.b.OQ(paramString1);
        String str;
        if (localObject != null)
        {
          str = ((k.b)localObject).lnP;
          Log.d("MicroMsg.AAUtil", "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s", new Object[] { str, paramString1.trim().replace(" ", "") });
          if ((localObject == null) || (Util.isNullOrNil(((k.b)localObject).lnP))) {
            break label356;
          }
          str = ((k.b)localObject).lnP;
          localObject = com.tencent.mm.plugin.aa.b.bwh().aaj(str);
          if (localObject != null) {
            break label365;
          }
          bool1 = true;
          if ((localObject == null) || (!((c)localObject).field_insertmsg)) {
            break label370;
          }
          if (localObject == null) {
            break label375;
          }
          l = ((c)localObject).field_localMsgId;
          Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, record==null: %s, billNo: %s, insertMsg: %s, chatroom: %s, localMsgId: %s", new Object[] { Boolean.valueOf(bool1), str, Boolean.valueOf(bool2), paramString2, Long.valueOf(l) });
          if (localObject == null)
          {
            Log.e("MicroMsg.AAUtil", "checkIfInsertAAMsg, record is null, ignore");
            a(str, false, 0L);
          }
          if ((localObject != null) && (((c)localObject).field_insertmsg) && (((c)localObject).field_localMsgId > 0L) && (((n)h.ae(n.class)).eSe().Oq(((c)localObject).field_localMsgId).field_msgId <= 0L))
          {
            Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
            com.tencent.mm.plugin.aa.b.bwh().a((c)localObject, new String[0]);
            AppMethodBeat.o(63340);
          }
        }
        else
        {
          str = "";
          continue;
        }
        if ((localObject == null) || (!((c)localObject).field_insertmsg) || (((c)localObject).field_localMsgId <= 0L))
        {
          Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
          cb(paramString1, paramString2);
          AppMethodBeat.o(63340);
          continue;
        }
        Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
      }
      finally {}
      j(((c)localObject).field_localMsgId, paramString1);
      label356:
      AppMethodBeat.o(63340);
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
  
  public static long cd(String paramString1, String paramString2)
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
  
  public static void j(long paramLong, String paramString)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(63345);
        if ((paramLong <= 0L) || (Util.isNullOrNil(paramString))) {
          break label387;
        }
        localObject = k.b.OQ(paramString);
        if ((localObject == null) || (Util.isNullOrNil(((k.b)localObject).lnP))) {
          break label359;
        }
        Log.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", new Object[] { Long.valueOf(paramLong), ((k.b)localObject).lnP });
        c localc = com.tencent.mm.plugin.aa.b.bwh().aaj(((k.b)localObject).lnP);
        if (localc != null)
        {
          long l = localc.field_localMsgId;
          localObject = ((n)h.ae(n.class)).eSe().Oq(l);
          if (((et)localObject).field_msgId > 0L)
          {
            String str = bq.RL(((et)localObject).field_content);
            ((ca)localObject).setContent(str + ":\n" + paramString);
            ((n)h.ae(n.class)).eSe().a(l, (ca)localObject);
            Log.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", new Object[] { Long.valueOf(l), localc.field_billNo });
            AppMethodBeat.o(63345);
            return;
          }
          Log.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", new Object[] { localc.field_billNo, Long.valueOf(localc.field_localMsgId), Long.valueOf(paramLong), Long.valueOf(((et)localObject).field_msgId) });
          AppMethodBeat.o(63345);
          continue;
        }
        paramString = new c();
      }
      finally {}
      paramString.field_localMsgId = paramLong;
      paramString.field_billNo = ((k.b)localObject).lnP;
      paramString.field_insertmsg = true;
      com.tencent.mm.plugin.aa.b.bwh().a(paramString);
      Log.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", new Object[] { Long.valueOf(paramLong), ((k.b)localObject).lnP });
      AppMethodBeat.o(63345);
      continue;
      label359:
      Log.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(63345);
      continue;
      label387:
      Log.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(Util.isNullOrNil(paramString)) });
      AppMethodBeat.o(63345);
    }
  }
  
  public static void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(63346);
    Log.i("MicroMsg.AAUtil", "do update sys msg, %s, %s", new Object[] { Long.valueOf(paramLong), paramString });
    ca localca = ((n)h.ae(n.class)).eSe().Oq(paramLong);
    paramString = aaf(paramString);
    if (!Util.isNullOrNil(paramString)) {
      localca.setContent(paramString);
    }
    ((n)h.ae(n.class)).eSe().a(paramLong, localca);
    AppMethodBeat.o(63346);
  }
  
  public static double o(double paramDouble)
  {
    AppMethodBeat.i(63347);
    paramDouble = a(String.valueOf(paramDouble), "100", 2, 4);
    AppMethodBeat.o(63347);
    return paramDouble;
  }
  
  public static void x(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      AppMethodBeat.i(63341);
      c localc = com.tencent.mm.plugin.aa.b.bwh().aaj(paramString1);
      Log.i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", new Object[] { paramString1, paramString2, Boolean.valueOf(Util.isNullOrNil(paramString3)), localc });
      if (localc == null) {
        a(paramString1, false, 0L);
      }
      cc(paramString3, paramString2);
      AppMethodBeat.o(63341);
      return;
    }
    finally {}
  }
  
  public static void y(String paramString1, String paramString2, String paramString3)
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
        if (!ar.isDarkMode()) {
          continue;
        }
        localObject = "#7D90A9";
        paramString1 = paramString1.replace("\"#037AFF\"", "\"" + (String)localObject + "\"");
        localObject = com.tencent.mm.plugin.aa.b.bwi().aai(paramString3);
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
      paramString2 = ((n)h.ae(n.class)).eSe().Oq(((com.tencent.mm.plugin.aa.model.a.a)localObject).field_msgId);
      Log.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", new Object[] { Long.valueOf(((com.tencent.mm.plugin.aa.model.a.a)localObject).field_msgId), Long.valueOf(paramString2.field_msgId) });
      paramString2.setContent(paramString1);
      ((n)h.ae(n.class)).eSe().a(((com.tencent.mm.plugin.aa.model.a.a)localObject).field_msgId, paramString2);
      AppMethodBeat.o(63343);
    }
  }
  
  public static void yd(int paramInt)
  {
    AppMethodBeat.i(63355);
    fv localfv = new fv();
    localfv.gBN = paramInt;
    localfv.bpa();
    AppMethodBeat.o(63355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.i
 * JD-Core Version:    0.7.0.1
 */