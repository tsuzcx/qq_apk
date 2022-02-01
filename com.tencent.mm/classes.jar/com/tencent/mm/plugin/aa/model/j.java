package com.tencent.mm.plugin.aa.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.hq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.aa.model.a.c;
import com.tencent.mm.plugin.aa.model.a.d;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.ac;
import com.tencent.mm.protocal.protobuf.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
{
  public static void A(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      AppMethodBeat.i(63341);
      c localc = com.tencent.mm.plugin.aa.b.bVa().SD(paramString1);
      Log.i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", new Object[] { paramString1, paramString2, Boolean.valueOf(Util.isNullOrNil(paramString3)), localc });
      if (localc == null) {
        a(paramString1, false, 0L);
      }
      cr(paramString3, paramString2);
      AppMethodBeat.o(63341);
      return;
    }
    finally {}
  }
  
  public static void B(String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    long l2;
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
        if (!aw.isDarkMode()) {
          continue;
        }
        localObject = "#7D90A9";
        paramString1 = paramString1.replace("\"#037AFF\"", "\"" + (String)localObject + "\"");
        localObject = com.tencent.mm.plugin.aa.b.bVb().SC(paramString3);
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
      localObject = "#576B95";
      continue;
      paramString2 = ((n)h.ax(n.class)).gaZ().sl(((com.tencent.mm.plugin.aa.model.a.a)localObject).field_msgId);
      l2 = ((com.tencent.mm.plugin.aa.model.a.a)localObject).field_msgId;
      if (paramString2 == null) {}
    }
    for (long l1 = paramString2.field_msgId;; l1 = -1L)
    {
      Log.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
      if (paramString2 != null)
      {
        paramString2.setContent(paramString1);
        ((n)h.ax(n.class)).gaZ().a(((com.tencent.mm.plugin.aa.model.a.a)localObject).field_msgId, paramString2);
      }
      AppMethodBeat.o(63343);
      break;
    }
  }
  
  public static double E(double paramDouble)
  {
    AppMethodBeat.i(63347);
    paramDouble = b(String.valueOf(paramDouble), "100", 2, 4);
    AppMethodBeat.o(63347);
    return paramDouble;
  }
  
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
    if (!au.bwE(paramString))
    {
      localObject = new ArrayList();
      ((List)localObject).add(z.bAM());
      ((List)localObject).add(paramString);
      AppMethodBeat.o(63352);
      return localObject;
    }
    try
    {
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jy(paramString);
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
    Object localObject = bVl();
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
    h.baF();
    h.baE().ban().set(at.a.acSo, localStringBuilder.toString());
    AppMethodBeat.o(63354);
  }
  
  /* Error */
  private static String Sz(String paramString)
  {
    // Byte code:
    //   0: ldc_w 283
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 285
    //   10: aconst_null
    //   11: invokestatic 291	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   14: astore_0
    //   15: aload_0
    //   16: ifnonnull +13 -> 29
    //   19: ldc_w 283
    //   22: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: ldc_w 293
    //   28: areturn
    //   29: aload_0
    //   30: ldc_w 295
    //   33: invokeinterface 301 2 0
    //   38: checkcast 92	java/lang/String
    //   41: astore_0
    //   42: aload_0
    //   43: invokestatic 35	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   46: ifeq +21 -> 67
    //   49: ldc 27
    //   51: ldc_w 303
    //   54: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: ldc_w 283
    //   60: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: ldc_w 293
    //   66: areturn
    //   67: aload_0
    //   68: ldc_w 307
    //   71: invokestatic 313	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_0
    //   75: ldc 27
    //   77: ldc_w 315
    //   80: iconst_1
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_0
    //   87: aastore
    //   88: invokestatic 252	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: ldc_w 283
    //   94: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: areturn
    //   99: astore_1
    //   100: ldc_w 293
    //   103: astore_0
    //   104: ldc 27
    //   106: aload_1
    //   107: invokevirtual 316	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   110: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: goto -22 -> 91
    //   116: astore_1
    //   117: goto -13 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramString	String
    //   99	8	1	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   116	1	1	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   67	75	99	java/io/UnsupportedEncodingException
    //   75	91	116	java/io/UnsupportedEncodingException
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(268393);
    Log.d("MicroMsg.AAUtil", "startAAPay, reqKey: %s, isFromChatting: %s", new Object[] { paramString1, Boolean.valueOf(paramBoolean) });
    PayInfo localPayInfo = new PayInfo();
    localPayInfo.hAT = paramString1;
    localPayInfo.hUR = 42;
    if (paramBoolean) {}
    for (localPayInfo.channel = 14;; localPayInfo.channel = 1)
    {
      paramString1 = new Bundle();
      paramString1.putString("extinfo_key_1", paramString3);
      localPayInfo.nKf = paramString1;
      com.tencent.mm.wallet_core.b.jNX();
      if (!com.tencent.mm.wallet_core.b.b(c.a.yRc, true)) {
        break;
      }
      localPayInfo.nKf.putString("extinfo_key_2", paramString2);
      ((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startSNSPay(paramContext, localPayInfo);
      AppMethodBeat.o(268393);
      return;
    }
    com.tencent.mm.pluginsdk.wallet.f.a(paramContext, false, "", localPayInfo, paramString2, new Intent(), 233);
    AppMethodBeat.o(268393);
  }
  
  public static void a(String paramString1, String paramString2, com.tencent.mm.plugin.aa.model.a.a parama, String paramString3, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(63344);
      cc localcc = new cc();
      localcc.pI(0);
      localcc.BS(paramString2);
      localcc.setStatus(3);
      localcc.setContent(paramString1);
      localcc.setCreateTime(br.D(paramString2, System.currentTimeMillis() / 1000L));
      localcc.setType(10000);
      if (paramBoolean) {
        localcc.setFlag(localcc.field_flag | 0x8);
      }
      long l = ((n)h.ax(n.class)).gaZ().ba(localcc);
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
        com.tencent.mm.plugin.aa.b.bVb().replace(paramString1);
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
        com.tencent.mm.plugin.aa.b.bVa().b(localc);
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
    if (paramac.YAF == 1)
    {
      Log.i("MicroMsg.AAUtil", "need realname verify");
      paramac = new Bundle();
      paramac.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
      paramac.putString("realname_verify_process_jump_plugin", "aa");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramac, null, 0);
      AppMethodBeat.o(63348);
      return bool;
    }
    if (paramac.YAF == 2)
    {
      Log.i("MicroMsg.AAUtil", "need upload credit");
      bool = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(paramActivity, paramac.KuO, paramac.KuP, paramac.rGU, paramac.right_button_wording, false, null);
      AppMethodBeat.o(63348);
      return bool;
    }
    Log.i("MicroMsg.AAUtil", "realnameGuideFlag =  " + paramac.YAF);
    AppMethodBeat.o(63348);
    return false;
  }
  
  public static double b(String paramString1, String paramString2, int paramInt1, int paramInt2)
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
  
  public static String bVl()
  {
    AppMethodBeat.i(63353);
    h.baF();
    String str = Util.nullAsNil((String)h.baE().ban().get(at.a.acSo, null));
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
          com.tencent.mm.plugin.aa.model.a.a locala = com.tencent.mm.plugin.aa.b.bVb().SC(paramString4);
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
            if (!aw.isDarkMode()) {
              continue;
            }
            paramString3 = "#7D90A9";
            if (!paramString1.equals(z.bAM())) {
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
        paramString1 = ((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).aV(paramString1, paramString2);
        paramString1 = MMApplicationContext.getContext().getString(a.i.pay_sys_msg_tmpl_launch_by_other, new Object[] { paramString1, paramString3, str });
        continue;
        if (aw.isDarkMode())
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
  private static void cq(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 564
    //   8: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: invokestatic 35	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   15: ifne +399 -> 414
    //   18: aload_0
    //   19: invokestatic 570	com/tencent/mm/message/k$b:Hf	(Ljava/lang/String;)Lcom/tencent/mm/message/k$b;
    //   22: astore 5
    //   24: aload 5
    //   26: ifnull +388 -> 414
    //   29: aload 5
    //   31: getfield 573	com/tencent/mm/message/k$b:nST	Ljava/lang/String;
    //   34: invokestatic 35	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +377 -> 414
    //   40: invokestatic 19	com/tencent/mm/plugin/aa/b:bVa	()Lcom/tencent/mm/plugin/aa/model/a/d;
    //   43: aload 5
    //   45: getfield 573	com/tencent/mm/message/k$b:nST	Ljava/lang/String;
    //   48: invokevirtual 25	com/tencent/mm/plugin/aa/model/a/d:SD	(Ljava/lang/String;)Lcom/tencent/mm/plugin/aa/model/a/c;
    //   51: astore 6
    //   53: aload 5
    //   55: getfield 573	com/tencent/mm/message/k$b:nST	Ljava/lang/String;
    //   58: astore 7
    //   60: aload 6
    //   62: ifnull +85 -> 147
    //   65: aload 6
    //   67: getfield 441	com/tencent/mm/plugin/aa/model/a/c:field_insertmsg	Z
    //   70: ifeq +77 -> 147
    //   73: aload 6
    //   75: ifnull +77 -> 152
    //   78: aload 6
    //   80: getfield 444	com/tencent/mm/plugin/aa/model/a/c:field_localMsgId	J
    //   83: lstore_3
    //   84: ldc 27
    //   86: ldc_w 575
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
    //   110: invokestatic 41	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   113: aastore
    //   114: dup
    //   115: iconst_4
    //   116: lload_3
    //   117: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: aastore
    //   121: invokestatic 46	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload 6
    //   126: ifnonnull +31 -> 157
    //   129: ldc 27
    //   131: ldc_w 577
    //   134: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: ldc_w 564
    //   140: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   159: getfield 441	com/tencent/mm/plugin/aa/model/a/c:field_insertmsg	Z
    //   162: ifeq +13 -> 175
    //   165: aload 6
    //   167: getfield 444	com/tencent/mm/plugin/aa/model/a/c:field_localMsgId	J
    //   170: lconst_0
    //   171: lcmp
    //   172: ifgt +242 -> 414
    //   175: new 155	com/tencent/mm/storage/cc
    //   178: dup
    //   179: invokespecial 379	com/tencent/mm/storage/cc:<init>	()V
    //   182: astore 6
    //   184: aload 6
    //   186: aload_1
    //   187: invokestatic 581	com/tencent/mm/model/br:JN	(Ljava/lang/String;)J
    //   190: invokevirtual 406	com/tencent/mm/storage/cc:setCreateTime	(J)V
    //   193: aload 6
    //   195: ldc_w 582
    //   198: invokevirtual 409	com/tencent/mm/storage/cc:setType	(I)V
    //   201: invokestatic 203	com/tencent/mm/model/z:bAM	()Ljava/lang/String;
    //   204: astore 7
    //   206: aload 6
    //   208: new 76	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   215: aload 7
    //   217: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc_w 584
    //   223: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_0
    //   227: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokevirtual 158	com/tencent/mm/storage/cc:setContent	(Ljava/lang/String;)V
    //   236: new 76	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   243: invokestatic 587	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   246: invokevirtual 590	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokevirtual 594	java/lang/String:getBytes	()[B
    //   255: invokestatic 600	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   258: astore 7
    //   260: invokestatic 606	com/tencent/mm/modelimage/r:bKa	()Lcom/tencent/mm/modelimage/j;
    //   263: aload 7
    //   265: invokevirtual 611	com/tencent/mm/modelimage/j:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   268: astore_0
    //   269: invokestatic 606	com/tencent/mm/modelimage/r:bKa	()Lcom/tencent/mm/modelimage/j;
    //   272: pop
    //   273: aload 7
    //   275: invokestatic 614	com/tencent/mm/modelimage/j:Ew	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 7
    //   280: invokestatic 618	com/tencent/mm/modelimage/r:bKe	()Lcom/tencent/mm/modelimage/loader/a;
    //   283: astore 8
    //   285: aload 5
    //   287: getfield 621	com/tencent/mm/message/k$b:nSD	Ljava/lang/String;
    //   290: astore 9
    //   292: new 623	com/tencent/mm/modelimage/loader/a/c$a
    //   295: dup
    //   296: invokespecial 624	com/tencent/mm/modelimage/loader/a/c$a:<init>	()V
    //   299: astore 10
    //   301: aload 10
    //   303: aload_0
    //   304: putfield 627	com/tencent/mm/modelimage/loader/a/c$a:fullPath	Ljava/lang/String;
    //   307: aload 10
    //   309: iconst_1
    //   310: putfield 630	com/tencent/mm/modelimage/loader/a/c$a:oKp	Z
    //   313: aload 8
    //   315: aload 9
    //   317: aconst_null
    //   318: aload 10
    //   320: invokevirtual 634	com/tencent/mm/modelimage/loader/a/c$a:bKx	()Lcom/tencent/mm/modelimage/loader/a/c;
    //   323: invokevirtual 639	com/tencent/mm/modelimage/loader/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/modelimage/loader/a/c;)V
    //   326: aload 6
    //   328: aload 7
    //   330: invokevirtual 642	com/tencent/mm/storage/cc:BT	(Ljava/lang/String;)V
    //   333: aload 6
    //   335: iconst_1
    //   336: invokevirtual 382	com/tencent/mm/storage/cc:pI	(I)V
    //   339: aload 6
    //   341: aload_1
    //   342: invokevirtual 385	com/tencent/mm/storage/cc:BS	(Ljava/lang/String;)V
    //   345: aload 6
    //   347: iconst_3
    //   348: invokevirtual 388	com/tencent/mm/storage/cc:setStatus	(I)V
    //   351: aload 6
    //   353: aload 6
    //   355: invokestatic 644	com/tencent/mm/model/br:B	(Lcom/tencent/mm/storage/cc;)J
    //   358: invokevirtual 647	com/tencent/mm/storage/cc:setMsgId	(J)V
    //   361: ldc 27
    //   363: ldc_w 649
    //   366: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 5
    //   371: getfield 573	com/tencent/mm/message/k$b:nST	Ljava/lang/String;
    //   374: iconst_1
    //   375: aload 6
    //   377: getfield 146	com/tencent/mm/autogen/b/fi:field_msgId	J
    //   380: invokestatic 50	com/tencent/mm/plugin/aa/model/j:a	(Ljava/lang/String;ZJ)V
    //   383: new 651	com/tencent/mm/message/k
    //   386: dup
    //   387: invokespecial 652	com/tencent/mm/message/k:<init>	()V
    //   390: astore_0
    //   391: aload 5
    //   393: aload_0
    //   394: invokevirtual 655	com/tencent/mm/message/k$b:a	(Lcom/tencent/mm/message/k;)V
    //   397: aload_0
    //   398: aload 6
    //   400: getfield 146	com/tencent/mm/autogen/b/fi:field_msgId	J
    //   403: putfield 656	com/tencent/mm/message/k:field_msgId	J
    //   406: invokestatic 662	com/tencent/mm/plugin/openapi/a:gxo	()Lcom/tencent/mm/pluginsdk/model/app/l;
    //   409: aload_0
    //   410: invokevirtual 667	com/tencent/mm/pluginsdk/model/app/l:insert	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;)Z
    //   413: pop
    //   414: ldc_w 564
    //   417: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   283	31	8	locala	com.tencent.mm.modelimage.loader.a
    //   290	26	9	str2	String
    //   299	20	10	locala1	com.tencent.mm.modelimage.loader.a.c.a
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
  
  public static void cr(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    for (;;)
    {
      Object localObject1;
      try
      {
        AppMethodBeat.i(63340);
        if (Util.isNullOrNil(paramString1)) {
          break label367;
        }
        Object localObject2 = k.b.Hf(paramString1);
        if (localObject2 != null)
        {
          localObject1 = ((k.b)localObject2).nST;
          Log.d("MicroMsg.AAUtil", "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s", new Object[] { localObject1, paramString1.trim().replace(" ", "") });
          if ((localObject2 == null) || (Util.isNullOrNil(((k.b)localObject2).nST))) {
            break label367;
          }
          localObject2 = ((k.b)localObject2).nST;
          localObject1 = com.tencent.mm.plugin.aa.b.bVa().SD((String)localObject2);
          if (localObject1 != null) {
            break label376;
          }
          bool1 = true;
          if ((localObject1 == null) || (!((c)localObject1).field_insertmsg)) {
            break label381;
          }
          if (localObject1 == null) {
            break label386;
          }
          l = ((c)localObject1).field_localMsgId;
          Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, record==null: %s, billNo: %s, insertMsg: %s, chatroom: %s, localMsgId: %s", new Object[] { Boolean.valueOf(bool1), localObject2, Boolean.valueOf(bool2), paramString2, Long.valueOf(l) });
          if (localObject1 == null)
          {
            Log.e("MicroMsg.AAUtil", "checkIfInsertAAMsg, record is null, ignore");
            a((String)localObject2, false, 0L);
          }
          if ((localObject1 != null) && (((c)localObject1).field_insertmsg) && (((c)localObject1).field_localMsgId > 0L))
          {
            localObject2 = ((n)h.ax(n.class)).gaZ().sl(((c)localObject1).field_localMsgId);
            if ((localObject2 == null) || (((fi)localObject2).field_msgId <= 0L))
            {
              Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
              com.tencent.mm.plugin.aa.b.bVa().a((c)localObject1, new String[0]);
              AppMethodBeat.o(63340);
            }
          }
        }
        else
        {
          localObject1 = "";
          continue;
        }
        if ((localObject1 == null) || (!((c)localObject1).field_insertmsg) || (((c)localObject1).field_localMsgId <= 0L))
        {
          Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
          cq(paramString1, paramString2);
          AppMethodBeat.o(63340);
          continue;
        }
        Log.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
      }
      finally {}
      l(((c)localObject1).field_localMsgId, paramString1);
      label367:
      AppMethodBeat.o(63340);
      continue;
      label376:
      boolean bool1 = false;
      continue;
      label381:
      bool2 = false;
      continue;
      label386:
      long l = 0L;
    }
  }
  
  public static long cs(String paramString1, String paramString2)
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
  
  public static x ct(List<x> paramList)
  {
    AppMethodBeat.i(268391);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      x localx = (x)paramList.next();
      if (localx.nQV.equals(z.bAM()))
      {
        AppMethodBeat.o(268391);
        return localx;
      }
    }
    Log.i("MicroMsg.AAUtil", "not contains self");
    AppMethodBeat.o(268391);
    return null;
  }
  
  public static void l(long paramLong, String paramString)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        AppMethodBeat.i(63345);
        if ((paramLong <= 0L) || (Util.isNullOrNil(paramString))) {
          break label410;
        }
        localObject = k.b.Hf(paramString);
        if ((localObject == null) || (Util.isNullOrNil(((k.b)localObject).nST))) {
          break label382;
        }
        Log.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", new Object[] { Long.valueOf(paramLong), ((k.b)localObject).nST });
        c localc = com.tencent.mm.plugin.aa.b.bVa().SD(((k.b)localObject).nST);
        if (localc == null) {
          break label311;
        }
        long l1 = localc.field_localMsgId;
        localObject = ((n)h.ax(n.class)).gaZ().sl(l1);
        if ((localObject != null) && (((fi)localObject).field_msgId > 0L))
        {
          String str = br.JJ(((fi)localObject).field_content);
          ((cc)localObject).setContent(str + ":\n" + paramString);
          ((n)h.ax(n.class)).gaZ().a(l1, (cc)localObject);
          Log.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", new Object[] { Long.valueOf(l1), localc.field_billNo });
          AppMethodBeat.o(63345);
          return;
        }
        paramString = localc.field_billNo;
        long l2 = localc.field_localMsgId;
        if (localObject != null)
        {
          l1 = ((fi)localObject).field_msgId;
          Log.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", new Object[] { paramString, Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(l1) });
          AppMethodBeat.o(63345);
          continue;
        }
        l1 = 0L;
      }
      finally {}
      continue;
      label311:
      paramString = new c();
      paramString.field_localMsgId = paramLong;
      paramString.field_billNo = ((k.b)localObject).nST;
      paramString.field_insertmsg = true;
      com.tencent.mm.plugin.aa.b.bVa().a(paramString);
      Log.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", new Object[] { Long.valueOf(paramLong), ((k.b)localObject).nST });
      AppMethodBeat.o(63345);
      continue;
      label382:
      Log.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", new Object[] { Long.valueOf(paramLong) });
      AppMethodBeat.o(63345);
      continue;
      label410:
      Log.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(Util.isNullOrNil(paramString)) });
      AppMethodBeat.o(63345);
    }
  }
  
  public static void m(long paramLong, String paramString)
  {
    AppMethodBeat.i(63346);
    Log.i("MicroMsg.AAUtil", "do update sys msg, %s, %s", new Object[] { Long.valueOf(paramLong), paramString });
    cc localcc = ((n)h.ax(n.class)).gaZ().sl(paramLong);
    if (localcc == null) {
      Log.e("MicroMsg.AAUtil", "incorrect msgid");
    }
    paramString = Sz(paramString);
    if (!Util.isNullOrNil(paramString)) {
      localcc.setContent(paramString);
    }
    ((n)h.ax(n.class)).gaZ().a(paramLong, localcc);
    AppMethodBeat.o(63346);
  }
  
  public static void yj(int paramInt)
  {
    AppMethodBeat.i(63355);
    hq localhq = new hq();
    localhq.iOO = paramInt;
    localhq.bMH();
    AppMethodBeat.o(63355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.j
 * JD-Core Version:    0.7.0.1
 */