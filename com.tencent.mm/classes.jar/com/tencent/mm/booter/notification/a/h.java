package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.j;
import com.tencent.mm.R.l;
import com.tencent.mm.an.af;
import com.tencent.mm.ao.a.a;
import com.tencent.mm.autogen.a.adk;
import com.tencent.mm.autogen.a.adk.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.t;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.d;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.smiley.EmojiHelper;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.storage.cc.d;
import com.tencent.mm.storage.cc.f;
import com.tencent.mm.ui.chatting.viewitems.l.a;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class h
{
  private static WeakReference<TextPaint> lvf;
  private static int lvg = 0;
  private static int lvh = 0;
  public String lve = "";
  public String mDesc = "";
  public String mTitle = "";
  
  private static String CC(String paramString)
  {
    AppMethodBeat.i(20079);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("%", "%%");
      AppMethodBeat.o(20079);
      return paramString;
    }
    AppMethodBeat.o(20079);
    return paramString;
  }
  
  private static String CD(String paramString)
  {
    AppMethodBeat.i(20082);
    if (paramString != null)
    {
      paramString = paramString.replaceAll("%%", "%");
      AppMethodBeat.o(20082);
      return paramString;
    }
    AppMethodBeat.o(20082);
    return paramString;
  }
  
  private static boolean CE(String paramString)
  {
    AppMethodBeat.i(20083);
    if ((au.bvV(paramString)) && (!z.bBp()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    if ((au.bvX(paramString)) && (!z.bBg()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    if ((au.bwb(paramString)) && (!z.bBs()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    AppMethodBeat.o(20083);
    return false;
  }
  
  public static String CF(String paramString)
  {
    AppMethodBeat.i(20084);
    if (paramString == null)
    {
      AppMethodBeat.o(20084);
      return "";
    }
    if (paramString.length() < 150)
    {
      AppMethodBeat.o(20084);
      return paramString;
    }
    paramString = paramString.substring(0, 150) + "...";
    AppMethodBeat.o(20084);
    return paramString;
  }
  
  private static boolean CG(String paramString)
  {
    AppMethodBeat.i(238959);
    try
    {
      paramString = XmlParser.parseXml(paramString, "msg", null);
      if (paramString != null)
      {
        paramString = (String)paramString.get(".msg.appmsg.mmreadershare.itemshowtype");
        if (paramString != null)
        {
          boolean bool = paramString.equals("16");
          if (bool)
          {
            AppMethodBeat.o(238959);
            return true;
          }
        }
      }
      AppMethodBeat.o(238959);
      return false;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(238959);
    }
    return false;
  }
  
  private static CharSequence a(String paramString, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(20086);
    paramString = TextUtils.ellipsize(com.tencent.mm.pluginsdk.ui.span.p.d(MMApplicationContext.getContext(), paramString, aLr()), paramTextPaint, aLs(), TextUtils.TruncateAt.END);
    AppMethodBeat.o(20086);
    return paramString;
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext)
  {
    AppMethodBeat.i(20075);
    paramString1 = Util.nullAsNil(a(null, paramInt1, paramString1, paramString2, paramInt2, paramContext, new PString(), new PString(), new PInt(), false, false, "", 0));
    AppMethodBeat.o(20075);
    return paramString1;
  }
  
  private static String a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, PString paramPString1, PString paramPString2)
  {
    AppMethodBeat.i(20077);
    String str3 = "";
    String str2;
    String str1;
    int i;
    if ((au.bvV(paramString1)) || (au.bvX(paramString1)))
    {
      str2 = str3;
      str1 = paramString2;
      if (paramString2 != null)
      {
        i = paramString2.indexOf(":");
        str2 = str3;
        str1 = paramString2;
        if (i >= 0)
        {
          str2 = str3;
          str1 = paramString2;
          if (i < paramString2.length())
          {
            paramString1 = paramString2.substring(0, i);
            if (!au.bwL(paramString1))
            {
              str2 = str3;
              str1 = paramString2;
              if (!au.bwN(paramString1)) {}
            }
            else
            {
              str2 = aa.getDisplayName(paramString1);
              paramPString2.value = paramString1;
              str1 = paramString2.substring(i + 1);
            }
          }
        }
      }
      if (Util.nullAsNil(str2).length() > 0) {
        break label313;
      }
      if (paramString3 != null) {
        break label306;
      }
    }
    for (;;)
    {
      paramPString1.value = str1;
      paramContext = paramPString1.value;
      AppMethodBeat.o(20077);
      return paramContext;
      if (!au.bwL(paramString1))
      {
        str2 = str3;
        str1 = paramString2;
        if (!au.bwN(paramString1)) {
          break;
        }
      }
      aa.getDisplayName(paramString1);
      paramPString2.value = paramString1;
      if (paramInt == 1)
      {
        paramContext = new StringBuilder().append(paramContext.getString(R.l.gIF, new Object[] { "" }));
        if (paramString3 == null) {}
        for (;;)
        {
          paramPString1.value = paramString2;
          paramPString2.value = "";
          paramContext = paramPString1.value;
          AppMethodBeat.o(20077);
          return paramContext;
          paramString2 = paramString3;
        }
      }
      if (paramString3 == null) {}
      for (;;)
      {
        paramPString1.value = paramString2;
        paramPString2.value = "";
        paramContext = paramPString1.value;
        AppMethodBeat.o(20077);
        return paramContext;
        paramString2 = paramString3;
      }
      label306:
      str1 = paramString3;
    }
    label313:
    paramString1 = new StringBuilder();
    if (paramInt == 1)
    {
      i = R.l.gIF;
      paramString2 = paramString1.append(paramContext.getString(i));
      if (paramString3 != null) {
        break label430;
      }
      paramString1 = str1;
      label350:
      paramPString1.value = paramString1;
      paramString1 = new StringBuilder();
      if (paramInt != 1) {
        break label436;
      }
      paramInt = R.l.gIF;
      label380:
      paramContext = paramString1.append(paramContext.getString(paramInt, new Object[] { str2 }));
      if (paramString3 != null) {
        break label443;
      }
    }
    for (;;)
    {
      paramContext = str1;
      AppMethodBeat.o(20077);
      return paramContext;
      i = R.l.gIK;
      break;
      label430:
      paramString1 = paramString3;
      break label350;
      label436:
      paramInt = R.l.gIK;
      break label380;
      label443:
      str1 = paramString3;
    }
  }
  
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(20092);
    if (paramBoolean)
    {
      EmojiHelper.iUM();
      String str = EmojiHelper.buv(paramString);
      paramString = str;
      if (paramInt3 > 1) {
        paramString = paramContext.getResources().getQuantityString(R.j.gpq, paramInt3, new Object[] { Integer.valueOf(paramInt3) }) + str;
      }
      AppMethodBeat.o(20092);
      return paramString;
    }
    paramContext = paramContext.getResources().getQuantityString(R.j.gpr, paramInt1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(20092);
    return paramContext;
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt, cc paramcc)
  {
    // Byte code:
    //   0: sipush 20073
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +49 -> 59
    //   13: aconst_null
    //   14: astore 4
    //   16: aload 4
    //   18: astore_1
    //   19: aload 4
    //   21: invokestatic 256	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   24: ifeq +18 -> 42
    //   27: aload_2
    //   28: invokestatic 261	com/tencent/mm/k/h:DQ	(Ljava/lang/String;)Z
    //   31: ifeq +472 -> 503
    //   34: aload_0
    //   35: getstatic 264	com/tencent/mm/R$l:gzv	I
    //   38: invokevirtual 211	android/content/Context:getString	(I)Ljava/lang/String;
    //   41: astore_1
    //   42: invokestatic 221	com/tencent/mm/smiley/EmojiHelper:iUM	()Lcom/tencent/mm/smiley/EmojiHelper;
    //   45: pop
    //   46: aload_1
    //   47: invokestatic 224	com/tencent/mm/smiley/EmojiHelper:buv	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_0
    //   51: sipush 20073
    //   54: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: areturn
    //   59: aload_2
    //   60: aload 4
    //   62: invokestatic 268	com/tencent/mm/booter/notification/a/h:b	(Ljava/lang/String;Lcom/tencent/mm/storage/cc;)Z
    //   65: ifeq +473 -> 538
    //   68: aload 4
    //   70: ifnull +462 -> 532
    //   73: invokestatic 274	com/tencent/mm/an/af:bHh	()Lcom/tencent/mm/an/a/d;
    //   76: aload 4
    //   78: getfield 280	com/tencent/mm/autogen/b/fi:field_bizChatId	J
    //   81: invokevirtual 286	com/tencent/mm/an/a/d:dW	(J)Lcom/tencent/mm/an/a/c;
    //   84: astore 6
    //   86: aload 6
    //   88: ifnull +444 -> 532
    //   91: aload 6
    //   93: invokevirtual 291	com/tencent/mm/an/a/c:bHx	()Z
    //   96: ifeq +77 -> 173
    //   99: aload 6
    //   101: getfield 294	com/tencent/mm/an/a/c:field_chatName	Ljava/lang/String;
    //   104: invokestatic 256	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   107: ifeq +56 -> 163
    //   110: invokestatic 135	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   113: getstatic 297	com/tencent/mm/R$l:gTN	I
    //   116: invokevirtual 211	android/content/Context:getString	(I)Ljava/lang/String;
    //   119: astore 6
    //   121: aload 6
    //   123: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   126: istore 5
    //   128: aload 6
    //   130: astore 4
    //   132: iload 5
    //   134: ifeq -118 -> 16
    //   137: invokestatic 303	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   140: pop
    //   141: invokestatic 309	com/tencent/mm/model/c:bzA	()Lcom/tencent/mm/storage/bx;
    //   144: aload_2
    //   145: invokeinterface 315 2 0
    //   150: astore 8
    //   152: aload 8
    //   154: ifnonnull +47 -> 201
    //   157: aconst_null
    //   158: astore 4
    //   160: goto -144 -> 16
    //   163: aload 6
    //   165: getfield 294	com/tencent/mm/an/a/c:field_chatName	Ljava/lang/String;
    //   168: astore 6
    //   170: goto -49 -> 121
    //   173: invokestatic 319	com/tencent/mm/an/af:bHj	()Lcom/tencent/mm/an/a/l;
    //   176: aload 4
    //   178: getfield 322	com/tencent/mm/autogen/b/fi:field_bizChatUserId	Ljava/lang/String;
    //   181: invokevirtual 328	com/tencent/mm/an/a/l:hM	(Ljava/lang/String;)Lcom/tencent/mm/an/a/k;
    //   184: astore 4
    //   186: aload 4
    //   188: ifnull +344 -> 532
    //   191: aload 4
    //   193: getfield 333	com/tencent/mm/an/a/k:field_userName	Ljava/lang/String;
    //   196: astore 6
    //   198: goto -77 -> 121
    //   201: aload 6
    //   203: astore 7
    //   205: iload_3
    //   206: ldc_w 334
    //   209: if_icmpne +44 -> 253
    //   212: aload 6
    //   214: astore 7
    //   216: aload_1
    //   217: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifne +33 -> 253
    //   223: ldc_w 336
    //   226: invokestatic 342	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   229: checkcast 336	com/tencent/mm/plugin/biz/a/a
    //   232: aload_1
    //   233: aload_2
    //   234: invokeinterface 345 3 0
    //   239: astore 7
    //   241: aload 7
    //   243: astore 4
    //   245: aload 7
    //   247: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   250: ifeq -234 -> 16
    //   253: aload_2
    //   254: invokestatic 348	com/tencent/mm/storage/au:bww	(Ljava/lang/String;)Z
    //   257: ifeq +13 -> 270
    //   260: aload 8
    //   262: invokevirtual 351	com/tencent/mm/storage/au:aSU	()Ljava/lang/String;
    //   265: astore 4
    //   267: goto -251 -> 16
    //   270: aload_2
    //   271: invokestatic 354	com/tencent/mm/storage/au:bwS	(Ljava/lang/String;)Z
    //   274: ifeq +132 -> 406
    //   277: getstatic 357	com/tencent/mm/R$l:gvM	I
    //   280: istore_3
    //   281: invokestatic 135	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   284: astore 6
    //   286: aload 8
    //   288: ifnull +106 -> 394
    //   291: aload 8
    //   293: invokevirtual 360	com/tencent/mm/storage/au:getCountryCode	()Ljava/lang/String;
    //   296: invokestatic 365	com/tencent/mm/storage/RegionCodeDecoder:byG	(Ljava/lang/String;)Z
    //   299: ifeq +74 -> 373
    //   302: aload 8
    //   304: invokevirtual 368	com/tencent/mm/storage/au:getCity	()Ljava/lang/String;
    //   307: astore_1
    //   308: aload_1
    //   309: invokestatic 256	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   312: ifne +24 -> 336
    //   315: aload_0
    //   316: iload_3
    //   317: iconst_1
    //   318: anewarray 4	java/lang/Object
    //   321: dup
    //   322: iconst_0
    //   323: aload_1
    //   324: aastore
    //   325: invokevirtual 209	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   328: invokevirtual 371	java/lang/String:trim	()Ljava/lang/String;
    //   331: astore 4
    //   333: goto -317 -> 16
    //   336: aload 8
    //   338: invokevirtual 374	com/tencent/mm/storage/au:getProvince	()Ljava/lang/String;
    //   341: invokestatic 377	com/tencent/mm/model/aa:IF	(Ljava/lang/String;)Ljava/lang/String;
    //   344: astore 4
    //   346: aload 4
    //   348: astore_1
    //   349: aload 4
    //   351: invokestatic 256	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   354: ifeq -39 -> 315
    //   357: invokestatic 381	com/tencent/mm/storage/RegionCodeDecoder:jcF	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   360: pop
    //   361: aload 8
    //   363: invokevirtual 360	com/tencent/mm/storage/au:getCountryCode	()Ljava/lang/String;
    //   366: invokestatic 384	com/tencent/mm/storage/RegionCodeDecoder:getLocName	(Ljava/lang/String;)Ljava/lang/String;
    //   369: astore_1
    //   370: goto -55 -> 315
    //   373: aload 8
    //   375: invokevirtual 374	com/tencent/mm/storage/au:getProvince	()Ljava/lang/String;
    //   378: invokestatic 377	com/tencent/mm/model/aa:IF	(Ljava/lang/String;)Ljava/lang/String;
    //   381: astore 4
    //   383: aload 4
    //   385: astore_1
    //   386: aload 4
    //   388: invokestatic 256	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   391: ifeq -76 -> 315
    //   394: aload 6
    //   396: getstatic 387	com/tencent/mm/R$l:gvS	I
    //   399: invokevirtual 211	android/content/Context:getString	(I)Ljava/lang/String;
    //   402: astore_1
    //   403: goto -88 -> 315
    //   406: aload_2
    //   407: invokestatic 261	com/tencent/mm/k/h:DQ	(Ljava/lang/String;)Z
    //   410: ifeq +56 -> 466
    //   413: aload 8
    //   415: getfield 392	com/tencent/mm/autogen/b/az:field_nickname	Ljava/lang/String;
    //   418: invokestatic 256	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   421: ifeq +45 -> 466
    //   424: aload 8
    //   426: getfield 395	com/tencent/mm/autogen/b/az:field_conRemark	Ljava/lang/String;
    //   429: invokestatic 256	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   432: ifeq +34 -> 466
    //   435: invokestatic 303	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   438: pop
    //   439: invokestatic 399	com/tencent/mm/model/c:bzK	()Lcom/tencent/mm/model/ar;
    //   442: aload_2
    //   443: invokeinterface 402 2 0
    //   448: astore_1
    //   449: aload 7
    //   451: astore 4
    //   453: aload_1
    //   454: invokestatic 256	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   457: ifne -441 -> 16
    //   460: aload_1
    //   461: astore 4
    //   463: goto -447 -> 16
    //   466: aload 7
    //   468: astore 4
    //   470: aload 8
    //   472: invokevirtual 405	com/tencent/mm/storage/au:aSV	()Ljava/lang/String;
    //   475: ifnull -459 -> 16
    //   478: aload 7
    //   480: astore 4
    //   482: aload 8
    //   484: invokevirtual 405	com/tencent/mm/storage/au:aSV	()Ljava/lang/String;
    //   487: invokevirtual 84	java/lang/String:length	()I
    //   490: ifle -474 -> 16
    //   493: aload 8
    //   495: invokevirtual 405	com/tencent/mm/storage/au:aSV	()Ljava/lang/String;
    //   498: astore 4
    //   500: goto -484 -> 16
    //   503: aload_0
    //   504: getstatic 408	com/tencent/mm/R$l:intro_title	I
    //   507: invokevirtual 211	android/content/Context:getString	(I)Ljava/lang/String;
    //   510: astore_0
    //   511: sipush 20073
    //   514: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   517: aload_0
    //   518: areturn
    //   519: astore 4
    //   521: aconst_null
    //   522: astore 6
    //   524: goto -387 -> 137
    //   527: astore 4
    //   529: goto -392 -> 137
    //   532: aconst_null
    //   533: astore 6
    //   535: goto -414 -> 121
    //   538: aconst_null
    //   539: astore 6
    //   541: goto -404 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	paramContext	Context
    //   0	544	1	paramString1	String
    //   0	544	2	paramString2	String
    //   0	544	3	paramInt	int
    //   0	544	4	paramcc	cc
    //   126	7	5	bool	boolean
    //   84	456	6	localObject1	Object
    //   203	276	7	localObject2	Object
    //   150	344	8	localau	au
    // Exception table:
    //   from	to	target	type
    //   59	68	519	finally
    //   73	86	519	finally
    //   91	121	519	finally
    //   163	170	519	finally
    //   173	186	519	finally
    //   191	198	519	finally
    //   121	128	527	finally
  }
  
  private static String a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, Context paramContext, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean1, boolean paramBoolean2, String paramString4, int paramInt3)
  {
    AppMethodBeat.i(238939);
    if (paramContext != null)
    {
      bool = true;
      Assert.assertTrue("context is null", bool);
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        break label79;
      }
    }
    label79:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username is null", bool);
      if ((paramBoolean1) || (!CE(paramString2))) {
        break label85;
      }
      paramString1 = paramContext.getString(R.l.settings_plugins_disable);
      AppMethodBeat.o(238939);
      return paramString1;
      bool = false;
      break;
    }
    label85:
    if (au.bwb(paramString2))
    {
      if (paramBoolean1)
      {
        AppMethodBeat.o(238939);
        return "";
      }
      paramString1 = cX(paramContext);
      AppMethodBeat.o(238939);
      return paramString1;
    }
    if ((paramString3 != null) && (paramBoolean1)) {
      paramString3 = CC(paramString3);
    }
    label1186:
    label1705:
    label2985:
    label3383:
    label4670:
    label4799:
    label6080:
    label7488:
    for (int k = 1;; k = 0)
    {
      paramPString1.value = paramString3;
      int i;
      String str1;
      String str2;
      Object localObject3;
      if ((paramInt1 == 0) && ((au.bwE(paramString2)) || (au.bwF(paramString2))))
      {
        i = br.JG(paramString3);
        if (i > 0)
        {
          str1 = paramString3.substring(0, i).trim();
          str2 = aa.aV(str1, paramString2);
          localObject3 = (paramString3 + " ").substring(i + 1);
        }
      }
      label5057:
      label10051:
      label12868:
      for (;;)
      {
        int j = 0;
        Object localObject1;
        if ((au.bwp(paramString2)) || (au.bwy(paramString2)) || (au.bwD(paramString2)))
        {
          i = paramString3.indexOf(":");
          localObject1 = paramString3;
          if (i != -1)
          {
            paramPString2.value = paramString3.substring(0, i);
            localObject1 = paramString3.substring(i + 1);
          }
          j = 0;
          paramString3 = (String)localObject1;
        }
        label1222:
        label4432:
        label10961:
        for (;;)
        {
          label986:
          label995:
          int m;
          switch (paramInt2)
          {
          default: 
            paramString1 = paramString3;
          case 3: 
          case 23: 
          case 33: 
          case 47: 
          case 1048625: 
          case 13: 
          case 39: 
          case 11: 
          case 36: 
          case 34: 
          case 43: 
          case 62: 
          case 486539313: 
          case 12299999: 
          case -1879048191: 
          case -1879048190: 
          case -1879048189: 
          case 50: 
          case 53: 
          case 52: 
          case -1879048188: 
          case 37: 
          case 40: 
          case 35: 
          case 42: 
          case 66: 
          case 67: 
            do
            {
              paramString3 = "";
              localObject1 = null;
              i = 0;
              for (;;)
              {
                if (!au.bvW(paramString2)) {
                  break label12240;
                }
                if (1 != paramInt1) {
                  break label11958;
                }
                if (Util.isNullOrNil(paramString3)) {
                  break label11909;
                }
                paramPString1.value = paramString3;
                AppMethodBeat.o(238939);
                return paramString3;
                i = j;
                if (au.bwC(paramString2)) {
                  break label12941;
                }
                i = j;
                if (au.bwQ(paramString2)) {
                  break label12941;
                }
                bh.bCz();
                localObject1 = com.tencent.mm.model.c.bzG().bxM(paramString2);
                if ((localObject1 == null) || (!((bb)localObject1).rx(2097152)))
                {
                  i = j;
                  if (!paramBoolean2) {
                    break label12941;
                  }
                }
                j = 1;
                i = j;
                if (paramString3 == null) {
                  break label12941;
                }
                m = paramString3.indexOf(":");
                i = j;
                if (m == -1) {
                  break label12941;
                }
                paramPString2.value = paramString3.substring(0, m);
                paramString3 = paramString3.substring(m + 1);
                j = 1;
                break;
                localObject3 = paramContext.getString(R.l.app_pic);
                if (str1.length() > 0)
                {
                  paramString1 = str1 + ": ";
                  if (str1.length() <= 0) {
                    break label1222;
                  }
                }
                for (paramString3 = "%s: ";; paramString3 = "")
                {
                  paramPString1.value = paramString3;
                  localObject1 = null;
                  i = 0;
                  paramString3 = (String)localObject3;
                  break;
                  paramString1 = "";
                  break label1186;
                }
                localObject3 = bg.byj(paramString3);
                localObject1 = ((bg)localObject3).bOq() + ": ";
                if ((paramString1 != null) && (paramString1.length() == 32)) {}
                for (paramString3 = paramString1;; paramString3 = paramContext.getString(R.l.app_emoji))
                {
                  paramPString1.value = "";
                  paramPString2.value = ((bg)localObject3).bOq();
                  localObject3 = null;
                  i = 0;
                  paramString1 = (String)localObject1;
                  localObject1 = localObject3;
                  break;
                }
                paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(R.l.app_pic), paramPString1, paramPString2);
                paramString3 = "";
                localObject1 = null;
                i = 0;
                continue;
                paramString1 = a(paramContext, paramInt1, paramString2, paramString3, null, paramPString1, paramPString2);
                paramString3 = "";
                localObject1 = null;
                i = 0;
                continue;
                if ((au.bwL(paramString2)) || (au.bwN(paramString2)) || (au.bvV(paramString2)) || (au.bvX(paramString2)))
                {
                  paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(R.l.app_voice), paramPString1, paramPString2);
                  paramString3 = "";
                  localObject1 = null;
                  i = 0;
                }
                else
                {
                  paramString1 = paramString3;
                  if (paramString3 != null)
                  {
                    paramString1 = paramString3;
                    if (paramString3.length() > 0)
                    {
                      paramString1 = paramString3;
                      if (!au.bvW(paramString2))
                      {
                        if (!au.bwE(paramString2)) {
                          break label1539;
                        }
                        paramString3 = new com.tencent.mm.modelvoice.p(paramString3);
                        paramString1 = paramString3.bOq() + ": ";
                        paramPString1.value = "%s:";
                        paramPString2.value = paramString3.bOq();
                      }
                    }
                  }
                  for (;;)
                  {
                    paramString3 = paramContext.getString(R.l.app_voice);
                    localObject1 = null;
                    i = 0;
                    break;
                    paramString1 = "";
                  }
                  if ((au.bwL(paramString2)) || (au.bwN(paramString2)) || (au.bvV(paramString2)) || (au.bvX(paramString2)))
                  {
                    paramString1 = a(paramContext, paramInt1, paramString2, paramString3, paramContext.getString(R.l.app_video), paramPString1, paramPString2);
                    paramString3 = "";
                    localObject1 = null;
                    i = 0;
                  }
                  else
                  {
                    paramString1 = paramString3;
                    if (paramString3 != null)
                    {
                      paramString1 = paramString3;
                      if (paramString3.length() > 0)
                      {
                        paramString1 = paramString3;
                        if (!au.bvW(paramString2))
                        {
                          if (!au.bwE(paramString2)) {
                            break label1705;
                          }
                          paramString3 = new x(paramString3);
                          paramString1 = paramString3.bOq() + ": ";
                          paramPString1.value = "%s:";
                          paramPString2.value = paramString3.bOq();
                        }
                      }
                    }
                    for (;;)
                    {
                      paramString3 = paramContext.getString(R.l.app_video);
                      localObject1 = null;
                      i = 0;
                      break;
                      paramString1 = "";
                    }
                    paramString3 = paramContext.getString(R.l.app_voip);
                    localObject1 = null;
                    i = 0;
                    paramString1 = "";
                    continue;
                    paramString3 = paramContext.getString(R.l.app_voice_remind);
                    localObject1 = null;
                    i = 0;
                    paramString1 = "";
                    continue;
                    if (paramString3.equals(cc.adkp))
                    {
                      paramString3 = paramContext.getString(R.l.app_voip);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                    }
                    else
                    {
                      paramString1 = paramString3;
                      if (!paramString3.equals(cc.adko)) {
                        break label986;
                      }
                      paramString3 = paramContext.getString(R.l.app_voip_voice);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                      continue;
                      paramString3 = paramContext.getString(R.l.app_voip);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                      continue;
                      paramString3 = paramContext.getString(R.l.app_voip_voice);
                      localObject1 = null;
                      i = 0;
                      paramString1 = "";
                      continue;
                      paramString1 = paramString3;
                      if (paramString3 == null) {
                        break label986;
                      }
                      paramString1 = paramString3;
                      if (paramString3.length() <= 0) {
                        break label986;
                      }
                      localObject1 = cc.f.byv(paramString3);
                      paramString1 = paramString3;
                      if (localObject1 != null)
                      {
                        paramString1 = paramString3;
                        if (((cc.f)localObject1).aJO() != null)
                        {
                          paramString1 = paramString3;
                          if (((cc.f)localObject1).aJO().length() <= 0) {}
                        }
                      }
                      switch (((cc.f)localObject1).getScene())
                      {
                      case 19: 
                      case 20: 
                      case 21: 
                      default: 
                        paramString1 = paramContext.getString(R.l.gIN, new Object[] { ((cc.f)localObject1).getDisplayName() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        break;
                      case 18: 
                        paramString1 = paramContext.getString(R.l.gII, new Object[] { ((cc.f)localObject1).getDisplayName() });
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        break;
                      case 22: 
                      case 23: 
                      case 24: 
                      case 26: 
                      case 27: 
                      case 28: 
                      case 29: 
                        paramString1 = paramContext.getString(R.l.gIL, new Object[] { ((cc.f)localObject1).getDisplayName() });
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        break;
                      case 25: 
                        paramString1 = paramContext.getString(R.l.gIm, new Object[] { ((cc.f)localObject1).getDisplayName() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (paramString3 == null) {
                          break label986;
                        }
                        paramString1 = paramString3;
                        if (paramString3.length() <= 0) {
                          break label986;
                        }
                        localObject1 = cc.a.bys(paramString3);
                        paramString1 = paramString3;
                        if (localObject1 != null)
                        {
                          paramString1 = paramString3;
                          if (((cc.a)localObject1).aJO() != null)
                          {
                            paramString1 = paramString3;
                            if (((cc.a)localObject1).aJO().length() > 0)
                            {
                              paramString1 = paramContext.getString(R.l.gIy, new Object[] { ((cc.a)localObject1).getDisplayName() });
                              paramPString1.value = paramString1;
                            }
                          }
                        }
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (Util.nullAsNil(paramString3).length() <= 0) {
                          break label986;
                        }
                        bh.bCz();
                        paramString1 = com.tencent.mm.model.c.bzD().aLS(paramString3);
                        paramString1 = paramContext.getString(R.l.gIC, new Object[] { paramString1.getSender(), paramString1.getTitle() });
                        paramPString1.value = paramString1;
                        paramString3 = "";
                        localObject1 = null;
                        i = 0;
                        continue;
                        paramString1 = paramString3;
                        if (Util.nullAsNil(paramString3).length() <= 0) {
                          break label986;
                        }
                        if (au.bwE(paramString2))
                        {
                          localObject1 = br.JJ(paramString3);
                          paramString1 = (String)localObject1;
                          if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
                        }
                        else
                        {
                          paramString1 = paramString2;
                        }
                        bh.bCz();
                        localObject3 = com.tencent.mm.model.c.bzD().aLU(paramString3);
                        bh.bCz();
                        localObject1 = com.tencent.mm.model.c.bzA().JE(paramString1).aSV();
                        paramString3 = (String)localObject1;
                        if (au.bwE((String)localObject1)) {
                          paramString3 = v.e(v.Io((String)localObject1), (String)localObject1);
                        }
                        if (paramInt1 == 1)
                        {
                          localObject1 = paramContext.getString(R.l.gIn, new Object[] { paramString3, ((cc.a)localObject3).getDisplayName() });
                          paramPString1.value = paramContext.getString(R.l.gIn, new Object[] { "%s", ((cc.a)localObject3).getDisplayName() });
                          paramPString2.value = paramString1;
                          paramString3 = "";
                          localObject3 = null;
                          i = 0;
                          paramString1 = (String)localObject1;
                          localObject1 = localObject3;
                        }
                        else
                        {
                          localObject1 = paramContext.getString(R.l.gIo, new Object[] { paramString3, ((cc.a)localObject3).getDisplayName() });
                          paramPString1.value = paramContext.getString(R.l.gIo, new Object[] { "%s", ((cc.a)localObject3).getDisplayName() });
                          paramPString2.value = paramString1;
                          paramString3 = "";
                          localObject3 = null;
                          i = 0;
                          paramString1 = (String)localObject1;
                          localObject1 = localObject3;
                        }
                        break;
                      }
                    }
                  }
                }
              }
              paramString1 = paramString3;
            } while (Util.nullAsNil(paramString3).length() <= 0);
            if (au.bwD(paramString2))
            {
              bh.bCz();
              paramString1 = com.tencent.mm.model.c.bzG().bxM(paramString2);
              paramPString2.value = "";
              if (paramString1 != null) {}
              for (paramString1 = paramString1.getDigest();; paramString1 = "")
              {
                paramPString1.value = paramString1;
                paramString1 = paramPString1.value;
                paramString3 = "";
                localObject1 = null;
                i = 0;
                break;
              }
            }
            if (au.bwE(paramString2))
            {
              paramString1 = br.JJ(paramString3);
              if (!TextUtils.isEmpty(paramString1)) {
                break;
              }
            }
            else
            {
              paramString1 = paramString2;
            }
            break;
          }
          label5344:
          label12769:
          for (;;)
          {
            localObject3 = ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).RD(paramString3);
            bh.bCz();
            localObject1 = com.tencent.mm.model.c.bzA().JE(paramString1).aSV();
            paramString3 = (String)localObject1;
            if (au.bwE((String)localObject1)) {
              paramString3 = v.e(v.Io((String)localObject1), (String)localObject1);
            }
            if (paramInt1 == 1)
            {
              i = R.l.gIn;
              if (localObject3 != null)
              {
                localObject1 = ((com.tencent.mm.openim.a.e)localObject3).getDisplayName();
                localObject1 = paramContext.getString(i, new Object[] { paramString3, localObject1 });
                i = R.l.gIn;
                if (localObject3 == null) {
                  break label2818;
                }
              }
              for (paramString3 = ((com.tencent.mm.openim.a.e)localObject3).getDisplayName();; paramString3 = "")
              {
                paramPString1.value = paramContext.getString(i, new Object[] { "%s", paramString3 });
                paramPString2.value = paramString1;
                paramString3 = "";
                localObject3 = null;
                i = 0;
                paramString1 = (String)localObject1;
                localObject1 = localObject3;
                break;
                localObject1 = "";
                break label2722;
              }
            }
            i = R.l.gIo;
            if (localObject3 != null)
            {
              localObject1 = ((com.tencent.mm.openim.a.e)localObject3).getDisplayName();
              localObject1 = paramContext.getString(i, new Object[] { paramString3, localObject1 });
              i = R.l.gIo;
              if (localObject3 == null) {
                break label2937;
              }
            }
            label2937:
            for (paramString3 = ((com.tencent.mm.openim.a.e)localObject3).getDisplayName();; paramString3 = "")
            {
              paramPString1.value = paramContext.getString(i, new Object[] { "%s", paramString3 });
              paramPString2.value = paramString1;
              paramString3 = "";
              localObject3 = null;
              i = 0;
              paramString1 = (String)localObject1;
              localObject1 = localObject3;
              break;
              localObject1 = "";
              break label2841;
            }
            paramString1 = paramString3;
            if (Util.nullAsNil(paramString3).length() <= 0) {
              break;
            }
            if (au.bwE(paramString2))
            {
              i = br.JG(paramString3);
              if (i != -1)
              {
                paramString1 = paramString3.substring(0, i).trim();
                br.JK(paramString3);
              }
            }
            label8805:
            label10725:
            for (;;)
            {
              if (paramInt1 == 1)
              {
                paramString1 = paramContext.getString(R.l.location_conversation);
                paramPString1.value = paramString1;
                paramString3 = "";
                localObject1 = null;
                i = 0;
                break label995;
              }
              localObject1 = paramContext.getString(R.l.location_conversation);
              paramPString1.value = paramContext.getString(R.l.location_conversation);
              paramPString2.value = paramString1;
              paramString3 = "";
              localObject3 = null;
              i = 0;
              paramString1 = (String)localObject1;
              localObject1 = localObject3;
              break label995;
              paramString1 = k.b.Hf(Util.processXml((String)localObject3));
              if (paramString1.nRA != 0) {
                if (paramString1.nRA == 1) {
                  paramString1 = paramContext.getString(R.l.gUh);
                }
              }
              for (;;)
              {
                paramPString2.value = str1;
                paramPString1.value = "";
                paramString3 = paramString1;
                localObject1 = null;
                i = 0;
                paramString1 = "";
                break;
                if (paramString1.nRA == 2) {
                  paramString1 = paramContext.getString(R.l.gUj);
                } else if (paramString1.nRA == 3) {
                  paramString1 = paramContext.getString(R.l.gUi);
                } else {
                  paramString1 = paramContext.getString(R.l.gUk);
                }
              }
              localObject1 = Util.processXml((String)localObject3);
              paramString3 = "";
              paramString1 = "";
              localObject1 = k.b.Hf((String)localObject1);
              if (localObject1 != null)
              {
                paramPString1.value = (paramContext.getString(R.l.gUn) + Util.nullAsNil(((k.b)localObject1).title));
                paramString1 = paramPString1.value;
              }
              paramPString2.value = str1;
              localObject1 = null;
              i = 0;
              break label995;
              localObject1 = Util.processXml((String)localObject3);
              paramString3 = "";
              paramString1 = "";
              localObject1 = k.b.Hf((String)localObject1);
              label3325:
              int n;
              int i1;
              if (localObject1 != null)
              {
                paramString1 = new adk();
                paramString1.ihB.hPj = ((k.b)localObject1).nSk;
                paramString1.publish();
                if (paramInt1 != 1) {
                  break label3487;
                }
                m = 1;
                if ((!au.bwE(paramString2)) && (!au.bwF(paramString2))) {
                  break label3493;
                }
                n = 1;
                localObject3 = ((com.tencent.mm.message.j)((k.b)localObject1).aK(com.tencent.mm.message.j.class)).nQU;
                i1 = 1;
                if ((((k.b)localObject1).nSh != 1) && (((k.b)localObject1).nSh != 7)) {
                  break label3499;
                }
                i = 1;
                int i2 = paramString1.ihC.status;
                i1 = i2;
                if (i2 <= 0) {
                  i1 = ((k.b)localObject1).nSh;
                }
                switch (i1)
                {
                default: 
                  paramPString1.value = Util.nullAsNil(((k.b)localObject1).title);
                }
              }
              for (;;)
              {
                paramString1 = paramPString1.value;
                paramPString2.value = str1;
                localObject1 = null;
                i = 0;
                break;
                m = 0;
                break label3325;
                n = 0;
                break label3342;
                if ((n != 0) && ((str1.equals(localObject3)) || ((m != 0) && (z.bAM().equals(localObject3)))))
                {
                  i = 0;
                  break label3383;
                }
                i = i1;
                if (n != 0) {
                  break label3383;
                }
                i = i1;
                if (!paramString2.equals(localObject3)) {
                  break label3383;
                }
                i = 0;
                break label3383;
                if (n != 0)
                {
                  if (paramInt1 == 1) {
                    paramPString1.value = paramContext.getString(R.l.gsc);
                  }
                  for (;;)
                  {
                    paramPString2.value = str2;
                    break;
                    if (z.bAM().equals(localObject3)) {
                      paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.gsd) });
                    } else {
                      paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.grZ) });
                    }
                  }
                }
                if (m != 0)
                {
                  paramPString1.value = paramContext.getString(R.l.gsc);
                }
                else
                {
                  paramPString1.value = paramContext.getString(R.l.gsd);
                  continue;
                  if (n != 0)
                  {
                    if (i != 0) {
                      if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {
                        paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.gsa) });
                      }
                    }
                    for (;;)
                    {
                      paramPString2.value = str2;
                      break;
                      paramPString1.value = paramContext.getString(R.l.gsa);
                      continue;
                      if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {
                        paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.grW) });
                      } else {
                        paramPString1.value = paramContext.getString(R.l.grW);
                      }
                    }
                  }
                  if (i != 0)
                  {
                    paramPString1.value = paramContext.getString(R.l.gsa);
                  }
                  else
                  {
                    paramPString1.value = paramContext.getString(R.l.grW);
                    continue;
                    if (n != 0)
                    {
                      if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {}
                      for (paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.gse) });; paramPString1.value = paramContext.getString(R.l.gsb))
                      {
                        paramPString2.value = str2;
                        break;
                      }
                    }
                    if (m != 0)
                    {
                      paramPString1.value = paramContext.getString(R.l.gsb);
                    }
                    else
                    {
                      paramPString1.value = paramContext.getString(R.l.gse);
                      continue;
                      if (n != 0)
                      {
                        if (i != 0) {
                          if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {
                            paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.grY) });
                          }
                        }
                        for (;;)
                        {
                          paramPString2.value = str2;
                          break;
                          paramPString1.value = paramContext.getString(R.l.grY);
                          continue;
                          if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {
                            paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.grX) });
                          } else {
                            paramPString1.value = paramContext.getString(R.l.grX);
                          }
                        }
                      }
                      if (i != 0)
                      {
                        paramPString1.value = paramContext.getString(R.l.grY);
                      }
                      else
                      {
                        paramPString1.value = paramContext.getString(R.l.grX);
                        continue;
                        if (n != 0)
                        {
                          if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {}
                          for (paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.grV) });; paramPString1.value = paramContext.getString(R.l.grV))
                          {
                            paramPString2.value = str2;
                            break;
                          }
                        }
                        if (m != 0)
                        {
                          paramPString1.value = paramContext.getString(R.l.gsg);
                        }
                        else
                        {
                          paramPString1.value = paramContext.getString(R.l.gsg);
                          continue;
                          if (n != 0)
                          {
                            if ((paramInt1 == 0) && (!Util.isNullOrNil(str2))) {}
                            for (paramPString1.value = String.format("%s: %s", new Object[] { str2, paramContext.getString(R.l.gsf) });; paramPString1.value = paramContext.getString(R.l.gsf))
                            {
                              paramPString2.value = str2;
                              break;
                            }
                          }
                          if (m != 0) {
                            paramPString1.value = paramContext.getString(R.l.gsh);
                          } else {
                            paramPString1.value = paramContext.getString(R.l.gsh);
                          }
                        }
                      }
                    }
                  }
                }
              }
              paramString1 = Util.processXml((String)localObject3);
              localObject3 = "";
              paramString3 = "";
              paramString1 = k.b.Hf(paramString1);
              if (paramString1 != null)
              {
                if (paramInt1 != 1) {
                  break label4518;
                }
                i = 1;
                if (i == 0) {
                  break label4524;
                }
                paramPString1.value = ("[" + paramString1.nSI + "]" + paramString1.nSF);
              }
              for (;;)
              {
                paramString3 = paramPString1.value;
                paramString1 = paramString3;
                if (au.bwp(paramString2)) {
                  break label12868;
                }
                paramString1 = paramString3;
                if (j != 0) {
                  break label12868;
                }
                paramPString2.value = str1;
                localObject1 = null;
                i = 0;
                paramString1 = paramString3;
                paramString3 = (String)localObject3;
                break;
                i = 0;
                break label4432;
                if (!Util.isNullOrNil(str2)) {
                  paramPString1.value = (Util.nullAsNil(str2) + ": [" + paramString1.nSI + "]" + paramString1.nSE);
                } else {
                  paramPString1.value = ("[" + paramString1.nSI + "]" + paramString1.nSE);
                }
              }
              localObject1 = Util.processXml((String)localObject3);
              paramString3 = "";
              paramString1 = "";
              localObject1 = k.b.Hf((String)localObject1);
              label4727:
              label4988:
              label5247:
              Object localObject4;
              if (localObject1 != null)
              {
                paramString1 = (com.tencent.mm.message.b)((k.b)localObject1).aK(com.tencent.mm.message.b.class);
                if (paramInt1 == 1)
                {
                  i = 1;
                  if (i == 0) {
                    break label4727;
                  }
                }
                for (paramPString1.value = paramContext.getString(R.l.gJB, new Object[] { paramString1.nPC });; paramPString1.value = paramContext.getString(R.l.gJB, new Object[] { paramString1.nPD }))
                {
                  paramString1 = paramPString1.value;
                  paramPString2.value = str1;
                  localObject1 = null;
                  i = 0;
                  break;
                  i = 0;
                  break label4670;
                }
                localObject1 = Util.processXml((String)localObject3);
                paramString3 = "";
                paramString1 = "";
                localObject1 = k.b.Hf((String)localObject1);
                if (localObject1 != null)
                {
                  paramString1 = (com.tencent.mm.message.b)((k.b)localObject1).aK(com.tencent.mm.message.b.class);
                  if (paramInt1 == 1)
                  {
                    i = 1;
                    if (i == 0) {
                      break label4871;
                    }
                  }
                  for (paramPString1.value = ("[" + paramString1.nPA + "]" + ((k.b)localObject1).description);; paramPString1.value = ("[" + paramString1.nPB + "]" + ((k.b)localObject1).description))
                  {
                    paramString1 = paramPString1.value;
                    paramPString2.value = str1;
                    localObject1 = null;
                    i = 0;
                    break;
                    i = 0;
                    break label4799;
                  }
                  paramString3 = Util.processXml((String)localObject3);
                  paramString1 = "";
                  paramString3 = k.b.Hf(paramString3);
                  if (paramString3 != null)
                  {
                    paramString1 = (l.a)paramString3.aK(l.a.class);
                    if (paramString1.state != 1) {
                      break label4988;
                    }
                  }
                  for (paramString1 = paramContext.getString(R.l.gEV, new Object[] { paramString1.appName });; paramString1 = paramContext.getString(R.l.gFb, new Object[] { paramString1.appName }))
                  {
                    paramPString1.value = paramString1;
                    paramString3 = "";
                    localObject1 = null;
                    i = 0;
                    break;
                  }
                  switch (k.b.Hf(Util.processXml((String)localObject3)).nRA)
                  {
                  default: 
                    paramString1 = paramContext.getString(R.l.app_product);
                    if (str1.length() <= 0) {
                      break;
                    }
                  }
                  for (paramString3 = str1 + ": ";; paramString3 = "")
                  {
                    if ((!au.bwp(paramString2)) && (j == 0)) {
                      paramPString2.value = str1;
                    }
                    paramPString1.value = "";
                    localObject3 = paramString1;
                    localObject1 = null;
                    i = 0;
                    paramString1 = paramString3;
                    paramString3 = (String)localObject3;
                    break;
                    paramString1 = paramContext.getString(R.l.app_product_card);
                    break label5057;
                    paramString1 = paramContext.getString(R.l.app_product_ticket);
                    break label5057;
                  }
                  paramString3 = k.b.Hf(Util.processXml((String)localObject3));
                  if (paramString3 == null)
                  {
                    Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                    AppMethodBeat.o(238939);
                    return "";
                  }
                  localObject3 = "";
                  localObject1 = paramContext.getString(R.l.card_msg_item_digest);
                  if (str1.length() > 0)
                  {
                    paramString1 = str1 + ": " + (String)localObject1 + paramString3.title;
                    if ((!au.bwp(paramString2)) && (j == 0)) {
                      paramPString2.value = str1;
                    }
                    if (str1.length() <= 0) {
                      break label5344;
                    }
                  }
                  for (paramString3 = "%s: " + (String)localObject1 + paramString3.title;; paramString3 = (String)localObject1 + paramString3.title)
                  {
                    paramPString1.value = paramString3;
                    localObject1 = null;
                    i = 0;
                    paramString3 = (String)localObject3;
                    break;
                    paramString1 = (String)localObject1 + paramString3.title;
                    break label5247;
                  }
                  paramString1 = k.b.Hf(Util.processXml((String)localObject3));
                  if (paramString1 == null)
                  {
                    Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                    AppMethodBeat.o(238939);
                    return "";
                  }
                  localObject3 = "";
                  paramString3 = paramContext.getString(R.l.card_msg_item_digest);
                  if (paramInt1 == 1)
                  {
                    paramString3 = paramString3 + paramString1.nSv;
                    if (str1.length() > 0) {}
                    for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                    {
                      paramPString1.value = paramString1;
                      paramString1 = paramString3;
                      if (au.bwp(paramString2)) {
                        break label12868;
                      }
                      paramString1 = paramString3;
                      if (j != 0) {
                        break label12868;
                      }
                      paramPString2.value = str1;
                      localObject1 = null;
                      i = 0;
                      paramString1 = paramString3;
                      paramString3 = (String)localObject3;
                      break;
                    }
                  }
                  paramString3 = paramString3 + paramString1.nSu;
                  if (str1.length() > 0) {}
                  for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                  {
                    paramPString1.value = paramString1;
                    break;
                  }
                  paramString3 = k.b.Hf(Util.processXml((String)localObject3));
                  if (paramString3 == null)
                  {
                    Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                    AppMethodBeat.o(238939);
                    return "";
                  }
                  localObject3 = "";
                  if (str1.length() > 0)
                  {
                    paramString1 = str1 + ": " + paramString3.title;
                    if ((!au.bwp(paramString2)) && (j == 0)) {
                      paramPString2.value = str1;
                    }
                    if (str1.length() <= 0) {
                      break label5715;
                    }
                  }
                  for (paramString3 = "%s: " + paramString3.title;; paramString3 = paramString3.title)
                  {
                    paramPString1.value = paramString3;
                    localObject1 = null;
                    i = 0;
                    paramString3 = (String)localObject3;
                    break;
                    paramString1 = paramString3.title;
                    break label5641;
                  }
                  localObject3 = paramContext.getString(R.l.app_app);
                  if (str1.length() > 0)
                  {
                    paramString1 = str1 + ": ";
                    if ((!au.bwp(paramString2)) && (j == 0)) {
                      paramPString2.value = str1;
                    }
                    if (str1.length() <= 0) {
                      break label5818;
                    }
                  }
                  for (paramString3 = "%s: ";; paramString3 = "")
                  {
                    paramPString1.value = paramString3;
                    localObject1 = null;
                    i = 0;
                    paramString3 = (String)localObject3;
                    break;
                    paramString1 = "";
                    break label5763;
                  }
                  paramString1 = k.b.Hf(Util.processXml((String)localObject3));
                  if (paramString1 == null)
                  {
                    Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                    AppMethodBeat.o(238939);
                    return "";
                  }
                  localObject3 = "";
                  try
                  {
                    paramString1 = URLDecoder.decode(paramString1.content, "UTF-8");
                    paramString3 = paramString1;
                    paramString1 = com.tencent.mm.pluginsdk.ui.span.p.brr(paramString1);
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      paramString1 = paramString3;
                      Log.printErrStackTrace("MicroMsg.Notification.Wording", localException, "", new Object[0]);
                      continue;
                      paramString3 = paramString1;
                    }
                  }
                  if ((!au.bwp(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  if (str1.length() > 0)
                  {
                    paramString3 = "%s: ".concat(String.valueOf(paramString1));
                    paramPString1.value = paramString3;
                    localObject1 = null;
                    i = 0;
                    paramString3 = (String)localObject3;
                    break label995;
                  }
                  localObject4 = "";
                  paramString1 = k.b.Hf(Util.processXml((String)localObject3));
                  if (paramString1 == null)
                  {
                    Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                    AppMethodBeat.o(238939);
                    return "";
                  }
                  if ((!au.bwp(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  paramString3 = paramContext.getString(R.l.app_finder);
                  paramString1 = (com.tencent.mm.plugin.findersdk.a.f)paramString1.aK(com.tencent.mm.plugin.findersdk.a.f.class);
                  if ((paramString1 == null) || (Util.isNullOrNil(paramString1.getNickname()))) {
                    break label12923;
                  }
                  if (Util.isNullOrNil(paramString1.frt().desc)) {
                    paramString1 = paramContext.getString(R.l.finder_feed_of_user, new Object[] { paramString1.getNickname() });
                  }
                }
              }
              label6898:
              label9207:
              label10106:
              label12923:
              for (paramString1 = paramString3 + paramString1;; paramString1 = paramString3)
              {
                if (str1.length() > 0) {}
                Object localObject2;
                for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                {
                  paramPString1.value = paramString3;
                  localObject2 = null;
                  i = 0;
                  paramString3 = (String)localObject4;
                  break;
                  paramString1 = paramString1.frt().desc;
                  break label6080;
                }
                localObject4 = "";
                paramString1 = k.b.Hf(Util.processXml((String)localObject3));
                if (paramString1 == null)
                {
                  Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                  AppMethodBeat.o(238939);
                  return "";
                }
                if ((!au.bwp(paramString2)) && (j == 0)) {
                  paramPString2.value = str1;
                }
                paramString3 = paramContext.getString(R.l.app_finder);
                paramString1 = (com.tencent.mm.plugin.findersdk.a.j)paramString1.aK(com.tencent.mm.plugin.findersdk.a.j.class);
                if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.frw().nickname))) {
                  if (Util.isNullOrNil(paramString1.frw().desc)) {
                    paramString1 = paramContext.getString(R.l.finder_feed_of_user, new Object[] { paramString1.frw().nickname });
                  }
                }
                for (paramString1 = paramString3 + paramString1;; paramString1 = paramString3)
                {
                  if (str1.length() > 0) {}
                  for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                  {
                    paramPString1.value = paramString3;
                    localObject2 = null;
                    i = 0;
                    paramString3 = (String)localObject4;
                    break;
                    paramString1 = paramString1.frw().desc;
                    break label6279;
                  }
                  localObject4 = "";
                  paramString3 = k.b.Hf(Util.processXml((String)localObject3));
                  if (paramString3 == null)
                  {
                    Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                    AppMethodBeat.o(238939);
                    return "";
                  }
                  if ((!au.bwp(paramString2)) && (j == 0)) {
                    paramPString2.value = str1;
                  }
                  paramString1 = paramContext.getString(R.l.app_finder);
                  paramString3 = (com.tencent.mm.plugin.findersdk.a.b)paramString3.aK(com.tencent.mm.plugin.findersdk.a.b.class);
                  if ((paramString3 != null) && (!Util.isNullOrNil(paramString3.frq().nickName))) {
                    paramString1 = paramString1 + paramContext.getString(R.l.finder_live_feed_of_user, new Object[] { paramString3.frq().nickName });
                  }
                  for (;;)
                  {
                    for (;;)
                    {
                      if (str1.length() > 0) {}
                      for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                      {
                        paramPString1.value = paramString3;
                        localObject2 = null;
                        i = 0;
                        paramString3 = (String)localObject4;
                        break;
                      }
                      localObject4 = "";
                      localObject2 = paramString3;
                      try
                      {
                        paramString1 = k.b.Hf(Util.processXml((String)localObject3));
                        if (paramString1 == null)
                        {
                          localObject2 = paramString3;
                          Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                          AppMethodBeat.o(238939);
                          return "";
                        }
                        localObject2 = paramString3;
                        if ((!au.bwp(paramString2)) && (j == 0))
                        {
                          localObject2 = paramString3;
                          paramPString2.value = str1;
                        }
                        localObject2 = paramString3;
                        paramString3 = paramContext.getString(R.l.app_url);
                        localObject2 = paramString3;
                        localObject3 = (com.tencent.mm.plugin.findersdk.a.h)paramString1.aK(com.tencent.mm.plugin.findersdk.a.h.class);
                        paramString1 = paramString3;
                        if (localObject3 != null)
                        {
                          paramString1 = paramString3;
                          localObject2 = paramString3;
                          if (!Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.h)localObject3).frv().aabi))
                          {
                            localObject2 = paramString3;
                            paramString1 = paramString3 + ((com.tencent.mm.plugin.findersdk.a.h)localObject3).frv().aabi;
                          }
                        }
                        localObject2 = paramString1;
                        if (str1.length() > 0) {
                          localObject2 = paramString1;
                        }
                        for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                        {
                          localObject2 = paramString1;
                          paramPString1.value = paramString3;
                          localObject2 = null;
                          i = 0;
                          paramString3 = (String)localObject4;
                          break;
                        }
                      }
                      finally
                      {
                        for (;;)
                        {
                          label8447:
                          continue;
                          label8572:
                          label8700:
                          paramString3 = paramString1;
                          continue;
                        }
                      }
                    }
                    Log.printErrStackTrace("MicroMsg.Notification.Wording", paramString1, "", new Object[0]);
                    paramString3 = "";
                    localObject3 = null;
                    i = 0;
                    paramString1 = (String)localObject2;
                    localObject2 = localObject3;
                    break label995;
                    localObject4 = "";
                    paramString3 = k.b.Hf(Util.processXml((String)localObject3));
                    if (paramString3 == null)
                    {
                      Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                      AppMethodBeat.o(238939);
                      return "";
                    }
                    if ((!au.bwp(paramString2)) && (j == 0)) {
                      paramPString2.value = str1;
                    }
                    paramString1 = paramContext.getString(R.l.app_finder);
                    paramString3 = (com.tencent.mm.plugin.findersdk.a.i)paramString3.aK(com.tencent.mm.plugin.findersdk.a.i.class);
                    if ((paramString3 != null) && (!Util.isNullOrNil(paramString3.frr().topic))) {
                      if (paramString3.frr().Auy == 1) {
                        paramString1 = paramString1 + MMApplicationContext.getContext().getString(R.l.finder_topic_card_prefix, new Object[] { paramString3.frr().topic });
                      }
                    }
                    for (;;)
                    {
                      if (str1.length() > 0) {}
                      for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                      {
                        paramPString1.value = paramString3;
                        localObject2 = null;
                        i = 0;
                        paramString3 = (String)localObject4;
                        break;
                        paramString1 = paramString1 + paramString3.frr().topic;
                        break label6898;
                      }
                      localObject4 = "";
                      paramString3 = k.b.Hf(Util.processXml((String)localObject3));
                      if (paramString3 == null)
                      {
                        Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                        AppMethodBeat.o(238939);
                        return "";
                      }
                      if ((!au.bwp(paramString2)) && (j == 0)) {
                        paramPString2.value = str1;
                      }
                      paramString1 = paramContext.getString(R.l.app_finder);
                      paramString3 = (d)paramString3.aK(d.class);
                      if ((paramString3 != null) && (!Util.isNullOrNil(paramString3.frs().title))) {
                        paramString1 = paramString1 + paramString3.frs().title;
                      }
                      for (;;)
                      {
                        if (str1.length() > 0) {}
                        for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                        {
                          paramPString1.value = paramString3;
                          localObject2 = null;
                          i = 0;
                          paramString3 = (String)localObject4;
                          break;
                        }
                        localObject4 = "";
                        paramString1 = k.b.Hf(Util.processXml((String)localObject3));
                        if (paramString1 == null)
                        {
                          Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                          AppMethodBeat.o(238939);
                          return "";
                        }
                        paramString1 = (com.tencent.mm.plugin.findersdk.a.e)paramString1.aK(com.tencent.mm.plugin.findersdk.a.e.class);
                        if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.getNickname()))) {
                          if (paramInt1 == 1) {
                            paramString1 = paramContext.getString(R.l.finder_msg_name_card_by_me, new Object[] { paramString1.getNickname() });
                          }
                        }
                        for (;;)
                        {
                          if (str1.length() > 0) {}
                          for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                          {
                            paramPString1.value = paramString3;
                            localObject2 = null;
                            i = 0;
                            paramString3 = (String)localObject4;
                            break;
                            paramString3 = paramContext.getString(R.l.finder_msg_name_card_by_other, new Object[] { paramString1.getNickname() });
                            paramString1 = paramString3;
                            if (au.bwp(paramString2)) {
                              break label7211;
                            }
                            paramString1 = paramString3;
                            if (j != 0) {
                              break label7211;
                            }
                            paramPString2.value = str1;
                            paramString1 = paramString3;
                            break label7211;
                          }
                          paramString1 = paramContext.getString(R.l.app_finder_endorsement) + paramContext.getString(R.l.finder_endorsement_desc);
                          paramPString1.value = paramString1;
                          paramString3 = "";
                          localObject2 = null;
                          i = 0;
                          break label995;
                          paramString1 = paramContext.getString(R.l.app_finder_endorsement) + paramContext.getString(R.l.finder_endorsement_desc);
                          paramPString1.value = paramString1;
                          paramString3 = "";
                          localObject2 = null;
                          i = 0;
                          break label995;
                          localObject4 = "";
                          paramString1 = k.b.Hf(Util.processXml((String)localObject3));
                          if (paramString1 == null)
                          {
                            Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                            AppMethodBeat.o(238939);
                            return "";
                          }
                          paramString1 = (com.tencent.mm.plugin.game.luggage.f.a)paramString1.aK(com.tencent.mm.plugin.game.luggage.f.a.class);
                          if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.nickName))) {
                            if (paramInt1 == 1) {
                              paramString1 = paramContext.getString(R.l.gIY, new Object[] { paramString1.nickName });
                            }
                          }
                          for (;;)
                          {
                            if (str1.length() > 0) {}
                            for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                            {
                              paramPString1.value = paramString3;
                              localObject2 = null;
                              i = 0;
                              paramString3 = (String)localObject4;
                              break;
                              paramString3 = paramContext.getString(R.l.gIZ, new Object[] { paramString1.nickName });
                              paramString1 = paramString3;
                              if (au.bwp(paramString2)) {
                                break label7488;
                              }
                              paramString1 = paramString3;
                              if (j != 0) {
                                break label7488;
                              }
                              paramPString2.value = str1;
                              paramString1 = paramString3;
                              break label7488;
                            }
                            localObject3 = "";
                            paramString1 = ((com.tencent.mm.plugin.patmsg.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.patmsg.a.b.class)).aRl(paramString3);
                            if (paramString1.Ksg.size() > 0)
                            {
                              paramPString1.value = ((PluginPatMsg)com.tencent.mm.kernel.h.az(PluginPatMsg.class)).parseDisplayTemplate((ebe)paramString1.Ksg.getLast(), paramString2).result;
                              localObject2 = null;
                              i = 0;
                              paramString1 = paramString3;
                              paramString3 = (String)localObject3;
                              break label995;
                              paramString1 = k.b.Hf(Util.processXml((String)localObject3));
                              if (paramString1 == null)
                              {
                                Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                                AppMethodBeat.o(238939);
                                return "";
                              }
                              paramString1 = paramContext.getString(R.l.app_live) + paramString1.getTitle();
                              paramPString1.value = paramString1;
                              paramString3 = "";
                              localObject2 = null;
                              i = 0;
                              break label995;
                              localObject4 = "";
                              paramString3 = k.b.Hf(Util.processXml((String)localObject3));
                              if (paramString3 == null)
                              {
                                Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                                AppMethodBeat.o(238939);
                                return "";
                              }
                              if ((!au.bwp(paramString2)) && (j == 0)) {
                                paramPString2.value = str1;
                              }
                              paramString1 = paramContext.getString(R.l.app_finder_live);
                              paramString3 = (com.tencent.mm.plugin.findersdk.a.b)paramString3.aK(com.tencent.mm.plugin.findersdk.a.b.class);
                              if ((paramString3 != null) && (!Util.isNullOrNil(paramString3.frq().nickName))) {
                                paramString1 = paramString1 + paramContext.getString(R.l.finder_live_invite_feed_of_user, new Object[] { paramString3.frq().nickName });
                              }
                              for (;;)
                              {
                                for (;;)
                                {
                                  if (str1.length() > 0) {}
                                  for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                                  {
                                    paramPString1.value = paramString3;
                                    localObject2 = null;
                                    i = 0;
                                    paramString3 = (String)localObject4;
                                    break;
                                  }
                                  localObject4 = "";
                                  paramString1 = k.b.Hf(Util.processXml((String)localObject3));
                                  if (paramString1 == null)
                                  {
                                    Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                                    AppMethodBeat.o(238939);
                                    return "";
                                  }
                                  if ((!au.bwp(paramString2)) && (j == 0)) {
                                    paramPString2.value = str1;
                                  }
                                  paramString1 = (com.tencent.mm.plugin.findersdk.a.g)paramString1.aK(com.tencent.mm.plugin.findersdk.a.g.class);
                                  if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.fru().poiName)))
                                  {
                                    paramString1 = "" + MMApplicationContext.getContext().getString(R.l.finder_poi_share_notification, new Object[] { paramString1.fru().poiName });
                                    if (str1.length() <= 0) {
                                      break label8095;
                                    }
                                  }
                                  for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                                  {
                                    paramPString1.value = paramString3;
                                    localObject2 = null;
                                    i = 0;
                                    paramString3 = (String)localObject4;
                                    break;
                                    paramString1 = "" + paramContext.getString(R.l.finder_poi_share_notification_fallback);
                                    break label8028;
                                  }
                                  paramString1 = Util.processXml((String)localObject3);
                                  localObject4 = k.b.Hf(paramString1);
                                  if (localObject4 == null)
                                  {
                                    Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                                    AppMethodBeat.o(238939);
                                    return "";
                                  }
                                  switch (((k.b)localObject4).type)
                                  {
                                  default: 
                                    paramString3 = paramContext.getString(R.l.app_app);
                                    localObject2 = null;
                                    i = 0;
                                    paramString1 = "";
                                    break;
                                  case 1: 
                                  case 53: 
                                  case 57: 
                                    localObject3 = "";
                                    if (str1.length() > 0)
                                    {
                                      paramString1 = str1 + ": " + ((k.b)localObject4).title;
                                      if ((!au.bwp(paramString2)) && (j == 0)) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label8523;
                                      }
                                    }
                                    for (paramString3 = "%s: " + ((k.b)localObject4).title;; paramString3 = ((k.b)localObject4).title)
                                    {
                                      paramPString1.value = paramString3;
                                      localObject2 = null;
                                      i = 0;
                                      paramString3 = (String)localObject3;
                                      break;
                                      paramString1 = ((k.b)localObject4).title;
                                      break label8447;
                                    }
                                  case 2: 
                                    localObject3 = paramContext.getString(R.l.app_pic);
                                    if (str1.length() > 0)
                                    {
                                      paramString1 = str1 + ": ";
                                      if ((!au.bwp(paramString2)) && (j == 0)) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label8627;
                                      }
                                    }
                                    for (paramString3 = "%s: ";; paramString3 = "")
                                    {
                                      paramPString1.value = paramString3;
                                      localObject2 = null;
                                      i = 0;
                                      paramString3 = (String)localObject3;
                                      break;
                                      paramString1 = "";
                                      break label8572;
                                    }
                                  case 3: 
                                  case 76: 
                                    localObject3 = paramContext.getString(R.l.app_music) + " " + ((k.b)localObject4).title;
                                    if (str1.length() > 0)
                                    {
                                      paramString1 = str1 + ": ";
                                      if ((!au.bwp(paramString2)) && (j == 0)) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label8759;
                                      }
                                    }
                                    for (paramString3 = "%s: ";; paramString3 = "")
                                    {
                                      paramPString1.value = paramString3;
                                      localObject2 = ((k.b)localObject4).title;
                                      i = 1;
                                      paramString3 = (String)localObject3;
                                      break;
                                      paramString1 = "";
                                      break label8700;
                                    }
                                  case 4: 
                                    localObject3 = paramContext.getString(R.l.app_video);
                                    if (str1.length() > 0)
                                    {
                                      paramString1 = str1 + ": ";
                                      if ((!au.bwp(paramString2)) && (j == 0)) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label8864;
                                      }
                                    }
                                    for (paramString3 = "%s: ";; paramString3 = "")
                                    {
                                      paramPString1.value = paramString3;
                                      localObject2 = ((k.b)localObject4).title;
                                      i = 1;
                                      paramString3 = (String)localObject3;
                                      break;
                                      paramString1 = "";
                                      break label8805;
                                    }
                                  case 6: 
                                  case 74: 
                                    localObject3 = paramContext.getString(R.l.app_file);
                                    if (str1.length() > 0)
                                    {
                                      paramString1 = str1 + ": ";
                                      if ((!au.bwp(paramString2)) && (j == 0)) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label8969;
                                      }
                                    }
                                    for (paramString3 = "%s: ";; paramString3 = "")
                                    {
                                      paramPString1.value = paramString3;
                                      localObject2 = ((k.b)localObject4).title;
                                      i = 1;
                                      paramString3 = (String)localObject3;
                                      break;
                                      paramString1 = "";
                                      break label8910;
                                    }
                                  case 7: 
                                    localObject3 = paramContext.getString(R.l.app_app);
                                    if (str1.length() > 0)
                                    {
                                      paramString1 = str1 + ": ";
                                      if ((!au.bwp(paramString2)) && (j == 0)) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label9070;
                                      }
                                    }
                                    for (paramString3 = "%s: ";; paramString3 = "")
                                    {
                                      paramPString1.value = paramString3;
                                      localObject2 = null;
                                      i = 0;
                                      paramString3 = (String)localObject3;
                                      break;
                                      paramString1 = "";
                                      break label9015;
                                    }
                                  case 5: 
                                    if (CG(paramString1))
                                    {
                                      paramString1 = paramContext.getString(R.l.app_video);
                                      if (str1.length() <= 0) {
                                        break label9201;
                                      }
                                      paramString3 = str1 + ": ";
                                      if ((!au.bwp(paramString2)) && (j == 0) && (!au.bwy(paramString2))) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label9207;
                                      }
                                    }
                                    for (localObject2 = "%s: ";; localObject2 = "")
                                    {
                                      paramPString1.value = ((String)localObject2);
                                      localObject2 = ((k.b)localObject4).getTitle();
                                      localObject3 = paramString1;
                                      i = 1;
                                      paramString1 = paramString3;
                                      paramString3 = (String)localObject3;
                                      break;
                                      paramString1 = paramContext.getString(R.l.app_url);
                                      break label9092;
                                      paramString3 = "";
                                      break label9122;
                                    }
                                  case 46: 
                                    paramString3 = paramContext.getString(R.l.app_app);
                                    localObject2 = null;
                                    i = 0;
                                    paramString1 = "";
                                    break;
                                  case 33: 
                                  case 36: 
                                    localObject3 = "";
                                    paramString3 = paramContext.getString(R.l.app_brand_default_name_with_brackets);
                                    if (str1.length() > 0)
                                    {
                                      paramString1 = str1 + ": " + paramString3 + ((k.b)localObject4).title;
                                      if ((!au.bwp(paramString2)) && (j == 0) && (!au.bwy(paramString2))) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label9394;
                                      }
                                    }
                                    for (paramString3 = "%s: " + paramString3 + ((k.b)localObject4).title;; paramString3 = paramString3 + ((k.b)localObject4).title)
                                    {
                                      paramPString1.value = paramString3;
                                      localObject2 = null;
                                      i = 0;
                                      paramString3 = (String)localObject3;
                                      break;
                                      paramString1 = paramString3 + ((k.b)localObject4).title;
                                      break label9290;
                                    }
                                  case 44: 
                                    if (((k.b)localObject4).gK(false))
                                    {
                                      localObject3 = "";
                                      paramString3 = ((k.b)localObject4).B(paramContext, true);
                                      if (!Util.isNullOrNil(paramString3))
                                      {
                                        if (str1.length() > 0)
                                        {
                                          paramString1 = str1 + ": " + paramString3 + ((k.b)localObject4).title;
                                          paramPString2.value = str1;
                                          if (str1.length() <= 0) {
                                            break label9576;
                                          }
                                        }
                                        for (paramString3 = "%s: " + paramString3 + ((k.b)localObject4).title;; paramString3 = paramString3 + ((k.b)localObject4).title)
                                        {
                                          paramPString1.value = paramString3;
                                          localObject2 = null;
                                          i = 0;
                                          paramString3 = (String)localObject3;
                                          break;
                                          paramString1 = paramString3 + ((k.b)localObject4).title;
                                          break label9491;
                                        }
                                      }
                                      paramString3 = paramContext.getString(R.l.app_app);
                                      localObject2 = null;
                                      i = 0;
                                      paramString1 = "";
                                      break;
                                    }
                                    paramString3 = paramContext.getString(R.l.app_app);
                                    localObject2 = null;
                                    i = 0;
                                    paramString1 = "";
                                    break;
                                  case 8: 
                                    paramString3 = paramContext.getString(R.l.app_emoji2);
                                    if (str1.length() > 0) {}
                                    for (paramString1 = str1 + ": ";; paramString1 = "")
                                    {
                                      if ((!au.bwp(paramString2)) && (j == 0)) {
                                        paramPString2.value = str1;
                                      }
                                      paramPString1.value = "";
                                      localObject2 = null;
                                      i = 0;
                                      break;
                                    }
                                  case 15: 
                                  case 26: 
                                  case 27: 
                                    paramString3 = paramContext.getString(R.l.app_emoji_share);
                                    if (str1.length() > 0) {}
                                    for (paramString1 = str1 + ": ";; paramString1 = "")
                                    {
                                      if ((!au.bwp(paramString2)) && (j == 0)) {
                                        paramPString2.value = str1;
                                      }
                                      paramPString1.value = "";
                                      localObject2 = null;
                                      i = 0;
                                      break;
                                    }
                                  case 25: 
                                    paramString3 = paramContext.getString(R.l.app_designer_share);
                                    if (str1.length() > 0) {}
                                    for (paramString1 = str1 + ": ";; paramString1 = "")
                                    {
                                      if ((!au.bwp(paramString2)) && (j == 0)) {
                                        paramPString2.value = str1;
                                      }
                                      paramPString1.value = "";
                                      localObject2 = null;
                                      i = 0;
                                      break;
                                    }
                                  case 17: 
                                    localObject3 = "";
                                    if (str1.length() > 0)
                                    {
                                      paramString1 = str1 + ": " + ((k.b)localObject4).title;
                                      if ((!au.bwp(paramString2)) && (j == 0)) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label10002;
                                      }
                                    }
                                    for (paramString3 = "%s: " + ((k.b)localObject4).title;; paramString3 = ((k.b)localObject4).title)
                                    {
                                      paramPString1.value = paramString3;
                                      localObject2 = null;
                                      i = 0;
                                      paramString3 = (String)localObject3;
                                      break;
                                      paramString1 = ((k.b)localObject4).title;
                                      break label9926;
                                    }
                                  case 19: 
                                    localObject3 = paramContext.getString(R.l.app_record);
                                    if (str1.length() > 0)
                                    {
                                      paramString1 = str1 + ": ";
                                      if ((!au.bwp(paramString2)) && (j == 0)) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label10106;
                                      }
                                    }
                                    for (paramString3 = "%s: ";; paramString3 = "")
                                    {
                                      paramPString1.value = paramString3;
                                      localObject2 = null;
                                      i = 0;
                                      paramString3 = (String)localObject3;
                                      break;
                                      paramString1 = "";
                                      break label10051;
                                    }
                                  case 24: 
                                    paramString1 = "";
                                    if (!Util.isNullOrNil(((k.b)localObject4).description))
                                    {
                                      i = ((k.b)localObject4).description.indexOf("\n");
                                      paramString1 = ((k.b)localObject4).description;
                                      if (i > 0) {
                                        paramString1 = paramString1.substring(0, i);
                                      }
                                    }
                                    else
                                    {
                                      localObject3 = paramContext.getString(R.l.favorite_wenote_msg) + paramString1;
                                      if (str1.length() <= 0) {
                                        break label10277;
                                      }
                                      paramString1 = str1 + ": ";
                                      if ((!au.bwp(paramString2)) && (j == 0)) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label10283;
                                      }
                                    }
                                    for (paramString3 = "%s: ";; paramString3 = "")
                                    {
                                      paramPString1.value = paramString3;
                                      localObject2 = null;
                                      i = 0;
                                      paramString3 = (String)localObject3;
                                      break;
                                      i = ((k.b)localObject4).description.length();
                                      break label10150;
                                      paramString1 = "";
                                      break label10215;
                                    }
                                  case 16: 
                                    localObject3 = "";
                                    paramString3 = paramContext.getString(R.l.card_msg_item_digest);
                                    if (str1.length() > 0)
                                    {
                                      paramString1 = str1 + ": " + paramString3 + ((k.b)localObject4).title;
                                      if ((!au.bwp(paramString2)) && (j == 0)) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label10426;
                                      }
                                    }
                                    for (paramString3 = "%s: ".concat(String.valueOf(paramString3));; paramString3 = String.valueOf(paramString3))
                                    {
                                      paramPString1.value = paramString3;
                                      localObject2 = null;
                                      i = 0;
                                      paramString3 = (String)localObject3;
                                      break;
                                      paramString1 = paramString3 + ((k.b)localObject4).title;
                                      break label10344;
                                    }
                                  case 34: 
                                    localObject3 = "";
                                    paramString1 = paramContext.getString(R.l.card_msg_item_digest);
                                    if (paramInt1 == 1)
                                    {
                                      paramString3 = paramString1 + ((k.b)localObject4).nSv;
                                      if (str1.length() > 0) {}
                                      for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                                      {
                                        paramPString1.value = paramString1;
                                        paramString1 = paramString3;
                                        if (au.bwp(paramString2)) {
                                          break label12868;
                                        }
                                        paramString1 = paramString3;
                                        if (j != 0) {
                                          break label12868;
                                        }
                                        paramPString2.value = str1;
                                        localObject2 = null;
                                        i = 0;
                                        paramString1 = paramString3;
                                        paramString3 = (String)localObject3;
                                        break;
                                      }
                                    }
                                    paramString3 = paramString1 + ((k.b)localObject4).nSu;
                                    if (str1.length() > 0) {}
                                    for (paramString1 = "%s: ".concat(String.valueOf(paramString3));; paramString1 = String.valueOf(paramString3))
                                    {
                                      paramPString1.value = paramString1;
                                      break;
                                    }
                                  case 40: 
                                    paramString1 = t.Hk(paramString1);
                                    if ((paramString1 != null) && (paramString1.nUJ == 19))
                                    {
                                      localObject3 = paramContext.getString(R.l.app_record);
                                      localObject2 = null;
                                      i = 0;
                                      paramString1 = paramString3;
                                      paramString3 = (String)localObject3;
                                      break;
                                    }
                                    localObject3 = paramContext.getString(R.l.app_app);
                                    localObject2 = null;
                                    i = 0;
                                    paramString1 = paramString3;
                                    paramString3 = (String)localObject3;
                                    break;
                                  case 68: 
                                    localObject3 = "";
                                    paramString3 = paramContext.getString(R.l.app_app);
                                    if (str1.length() > 0)
                                    {
                                      paramString1 = str1 + ": " + paramString3 + ((k.b)localObject4).title;
                                      if ((!au.bwp(paramString2)) && (j == 0) && (!au.bwy(paramString2))) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label10829;
                                      }
                                    }
                                    for (paramString3 = "%s: " + paramString3 + ((k.b)localObject4).title;; paramString3 = paramString3 + ((k.b)localObject4).title)
                                    {
                                      paramPString1.value = paramString3;
                                      localObject2 = null;
                                      i = 0;
                                      paramString3 = (String)localObject3;
                                      break;
                                      paramString1 = paramString3 + ((k.b)localObject4).title;
                                      break label10725;
                                    }
                                  case 83: 
                                  case 84: 
                                    localObject3 = paramContext.getString(R.l.teen_mode_authorization_prefix);
                                    localObject2 = ((k.b)localObject4).getTitle();
                                    if (str1.length() > 0)
                                    {
                                      paramString1 = str1 + ": ";
                                      if ((!au.bwp(paramString2)) && (j == 0) && (!au.bwy(paramString2))) {
                                        paramPString2.value = str1;
                                      }
                                      if (str1.length() <= 0) {
                                        break label10961;
                                      }
                                    }
                                    for (paramString3 = "%s: ";; paramString3 = "")
                                    {
                                      paramPString1.value = paramString3;
                                      i = 1;
                                      paramString3 = (String)localObject3;
                                      break;
                                      paramString1 = "";
                                      break label10902;
                                    }
                                    paramString1 = paramString3;
                                    if (k != 0) {
                                      paramString1 = CD(paramString3);
                                    }
                                    paramString3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hj(paramString1);
                                    paramString1 = paramString3;
                                    if (k != 0) {
                                      paramString1 = CC(paramString3);
                                    }
                                    paramString1 = com.tencent.mm.pluginsdk.ui.span.p.brr(paramString1);
                                    paramPString1.value = paramString1;
                                    paramString3 = "";
                                    localObject2 = null;
                                    i = 0;
                                    break;
                                    paramPString1.value = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hi(paramString3);
                                    paramString3 = paramPString1.value;
                                    Log.i("MicroMsg.Notification.Wording", "[parseMsgContentToShow] type:%s suffix:%s", new Object[] { Integer.valueOf(318767153), paramString3 });
                                    localObject2 = null;
                                    i = 0;
                                    paramString1 = "";
                                    break;
                                    paramString1 = com.tencent.mm.ao.a.b(a.a.No(paramString3));
                                    paramPString1.value = paramString1;
                                    paramString3 = "";
                                    localObject2 = null;
                                    i = 0;
                                    break;
                                    paramString3 = "";
                                    localObject2 = k.b.Hf((String)localObject3);
                                    paramString1 = paramString3;
                                    if (localObject2 == null) {
                                      break label986;
                                    }
                                    paramString1 = paramString3;
                                    try
                                    {
                                      paramString3 = URLDecoder.decode(((k.b)localObject2).content, "UTF-8");
                                      paramString1 = paramString3;
                                      paramString3 = com.tencent.mm.pluginsdk.ui.span.p.brr(paramString3);
                                      paramString1 = paramString3;
                                    }
                                    catch (Exception paramString3)
                                    {
                                      try
                                      {
                                        paramPString1.value = paramString1;
                                        paramString3 = "";
                                        localObject2 = null;
                                        i = 0;
                                      }
                                      catch (Exception paramString3)
                                      {
                                        break label11179;
                                      }
                                      paramString3 = paramString3;
                                    }
                                  }
                                }
                                Log.printErrStackTrace("MicroMsg.Notification.Wording", paramString3, "", new Object[0]);
                                paramString3 = "";
                                localObject2 = null;
                                i = 0;
                                break label995;
                                paramString1 = ((com.tencent.mm.plugin.messenger.a.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.e.class)).aLe(paramString3);
                                if (paramString1 != null) {}
                                for (paramString3 = paramString1.toString();; paramString3 = "")
                                {
                                  paramString1 = paramString3;
                                  if (paramBoolean1)
                                  {
                                    paramString1 = paramString3;
                                    if (au.bwE(paramString2))
                                    {
                                      paramString1 = paramString3;
                                      if (paramString3.endsWith(paramContext.getString(R.l.gwK)))
                                      {
                                        Log.i("MicroMsg.Notification.Wording", "conv.getDigest() : %s", new Object[] { paramString3 });
                                        paramString1 = paramString3.substring(0, paramString3.length() - paramContext.getString(R.l.gwK).length());
                                      }
                                    }
                                  }
                                  paramPString1.value = paramString1;
                                  paramString3 = "";
                                  localObject2 = null;
                                  i = 0;
                                  break;
                                }
                                paramString3 = com.tencent.mm.message.c.c.Hu(paramString3).content;
                                paramString1 = paramString3;
                                if (Util.isNullOrNil(paramString3)) {
                                  paramString1 = "";
                                }
                                paramPString1.value = paramString1;
                                paramString3 = "";
                                localObject2 = null;
                                i = 0;
                                break label995;
                                paramString1 = paramContext.getString(R.l.gQW);
                                paramPString1.value = paramString1;
                                paramString3 = "";
                                localObject2 = null;
                                i = 0;
                                break label995;
                                paramString1 = com.tencent.mm.message.c.a.Hr(paramString3);
                                if ((Util.isNullOrNil(paramString1.nickname)) || (Util.isNullOrNil(paramString1.title))) {}
                                for (paramString1 = "";; paramString1 = String.format(Locale.US, "%s: %s", new Object[] { paramString1.nickname, paramString1.title }))
                                {
                                  paramPString1.value = paramString1;
                                  paramString3 = "";
                                  localObject2 = null;
                                  i = 0;
                                  break;
                                }
                                localObject4 = "";
                                paramString3 = k.b.Hf(Util.processXml((String)localObject3));
                                if (paramString3 == null)
                                {
                                  Log.e("MicroMsg.Notification.Wording", "decode msg content failed");
                                  AppMethodBeat.o(238939);
                                  return "";
                                }
                                if ((!au.bwp(paramString2)) && (j == 0)) {
                                  paramPString2.value = str1;
                                }
                                paramString1 = paramContext.getString(R.l.app_finder);
                                paramString3 = (com.tencent.mm.plugin.findersdk.a.i)paramString3.aK(com.tencent.mm.plugin.findersdk.a.i.class);
                                if ((paramString3 != null) && (!Util.isNullOrNil(paramString3.frr().topic)))
                                {
                                  if (paramString3.frr().Auy == 1)
                                  {
                                    paramString1 = paramString1 + MMApplicationContext.getContext().getString(R.l.finder_topic_card_prefix, new Object[] { paramString3.frr().topic });
                                    if (str1.length() <= 0) {
                                      break label11677;
                                    }
                                  }
                                  for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                                  {
                                    paramPString1.value = paramString3;
                                    localObject2 = null;
                                    i = 0;
                                    paramString3 = (String)localObject4;
                                    break;
                                    paramString1 = paramString1 + paramString3.frr().topic;
                                    break label11612;
                                  }
                                  localObject4 = "";
                                  paramString3 = k.b.Hf(Util.processXml((String)localObject3));
                                  if (paramString3 == null)
                                  {
                                    Log.e("MicroMsg.Notification.Wording", "decode MM_DATA_APPMSG_FINDER_AGGREATE_ACTIVITY msg content failed");
                                    AppMethodBeat.o(238939);
                                    return "";
                                  }
                                  if ((!au.bwp(paramString2)) && (j == 0)) {
                                    paramPString2.value = str1;
                                  }
                                  paramString1 = paramContext.getString(R.l.app_finder);
                                  paramString3 = (com.tencent.mm.plugin.findersdk.a.c)paramString3.aK(com.tencent.mm.plugin.findersdk.a.c.class);
                                  if ((paramString3 != null) && (!Util.isNullOrNil(paramString3.frr().topic)) && (paramString3.frr().Auy == 7) && (paramString3.frr().aade != null))
                                  {
                                    paramString1 = new StringBuilder().append(paramString1);
                                    localObject2 = av.GiL;
                                    paramString1 = av.a(paramString3.frr().aade);
                                    if (str1.length() > 0) {}
                                    for (paramString3 = "%s: ".concat(String.valueOf(paramString1));; paramString3 = paramString1)
                                    {
                                      paramPString1.value = paramString3;
                                      localObject2 = null;
                                      i = 0;
                                      paramString3 = (String)localObject4;
                                      break;
                                    }
                                    paramString1 = Util.nullAsNil((String)XmlParser.parseXml((String)localObject3, "msg", null).get(".msg.appmsg.extinfo.notifymsg.preview.content"));
                                    paramPString1.value = paramString1;
                                    AppMethodBeat.o(238939);
                                    return paramString1;
                                    paramString1 = paramString1.split("@bottle:");
                                    if (paramString1.length > 1)
                                    {
                                      paramPString1.value = paramString1[1];
                                      paramString1 = paramString1[1];
                                      AppMethodBeat.o(238939);
                                      return paramString1;
                                    }
                                    paramPString1.value = "";
                                    AppMethodBeat.o(238939);
                                    return null;
                                    paramString2 = null;
                                    paramPString2 = null;
                                    paramContext = paramString1.split(":");
                                    if ((paramContext == null) || (paramContext.length <= 0))
                                    {
                                      paramPString1.value = "";
                                      AppMethodBeat.o(238939);
                                      return null;
                                    }
                                    paramContext = paramContext[0];
                                    if (!Util.isNullOrNil(paramContext))
                                    {
                                      bh.bCz();
                                      paramPInt = com.tencent.mm.model.c.bzA().JE(paramContext);
                                      paramContext = paramPString2;
                                      if (paramPInt != null)
                                      {
                                        paramContext = paramPString2;
                                        if (paramPInt.getCity() != null) {
                                          paramContext = paramPInt.getCity();
                                        }
                                      }
                                      if (paramContext != null)
                                      {
                                        paramString2 = paramContext;
                                        if (paramContext.length() > 0) {}
                                      }
                                      else
                                      {
                                        paramString2 = paramPInt.getProvince();
                                      }
                                    }
                                    if (!Util.isNullOrNil(paramString3))
                                    {
                                      paramPString1.value = (paramString2 + ": " + paramString3);
                                      paramString1 = paramString2 + ": " + paramString3;
                                      AppMethodBeat.o(238939);
                                      return paramString1;
                                    }
                                    paramString1 = paramString1.split("@bottle:");
                                    if (paramString1.length > 1)
                                    {
                                      paramPString1.value = (paramString2 + ": " + paramString1[1]);
                                      paramString1 = paramString2 + ": " + paramString1[1];
                                      AppMethodBeat.o(238939);
                                      return paramString1;
                                    }
                                    paramPString1.value = paramString2;
                                    AppMethodBeat.o(238939);
                                    return paramString2;
                                    if (Util.isNullOrNil(paramString1)) {
                                      paramPString1.value = "";
                                    }
                                    if (!Util.isNullOrNil(str1))
                                    {
                                      paramString2 = paramString1;
                                      if (str2 != null)
                                      {
                                        paramString2 = paramString1;
                                        if (str2.length() > 0) {
                                          paramString2 = k(paramString1, str1, str2);
                                        }
                                      }
                                      if (Util.isNullOrNil(paramPString2.value))
                                      {
                                        paramPString1.value = k(paramPString1.value, str1, "%s");
                                        paramPString2.value = str1;
                                      }
                                      paramString1 = com.tencent.mm.compatible.util.p.DE(paramString2);
                                      paramPString1.value = com.tencent.mm.compatible.util.p.DE(paramPString1.value);
                                      paramString2 = paramString1 + paramString3;
                                      paramPString1.value += paramString3;
                                      if ((paramBoolean1) && (!a(paramInt2, paramPString1, paramString2, paramString3))) {
                                        a(paramInt2, paramPString1, paramPString2, paramPInt);
                                      }
                                      paramString1 = paramString2;
                                      if (i != 0) {
                                        paramString1 = paramString2.concat(" " + Util.nullAsNil((String)localObject2));
                                      }
                                      paramString1 = Util.nullAsNil(paramString1);
                                      AppMethodBeat.o(238939);
                                      return paramString1;
                                    }
                                    if ((au.bwp(paramString2)) || (j != 0) || (au.bwy(paramString2)) || (au.bwD(paramString2)))
                                    {
                                      str1 = paramString1;
                                      if (paramString3 != null)
                                      {
                                        str1 = paramString1;
                                        if (paramString3.length() > 0) {
                                          str1 = paramString3;
                                        }
                                      }
                                      if (Util.isNullOrNil(str1))
                                      {
                                        paramPString1.value = "";
                                        paramPString2.value = "";
                                        AppMethodBeat.o(238939);
                                        return "";
                                      }
                                      if (paramInt1 == 0)
                                      {
                                        paramPString1.value = "%s:".concat(String.valueOf(str1));
                                        if (!paramBoolean1) {
                                          break label12769;
                                        }
                                        a(paramInt2, paramPString1, paramPString2, paramPInt);
                                        paramString1 = str1;
                                      }
                                    }
                                    for (;;)
                                    {
                                      paramString3 = paramString1;
                                      if (i != 0)
                                      {
                                        paramString3 = paramString1;
                                        if (localObject2 != null) {
                                          paramString3 = paramString1.concat(" ".concat(String.valueOf(localObject2)));
                                        }
                                      }
                                      paramString1 = paramString3;
                                      if (k != 0) {
                                        paramString1 = CD(paramString3);
                                      }
                                      if ((!Util.isNullOrNil(paramString4)) && (com.tencent.mm.an.g.Mw(paramString2)))
                                      {
                                        paramString2 = af.bHe().MH(paramString4);
                                        if ((paramString2 != null) && (!Util.isNullOrNil(paramString2.field_openId)) && (!Util.isNullOrNil(paramString2.field_nickname)) && ((paramInt3 == 2) || (paramString2.field_kfType == 2)))
                                        {
                                          paramPString1.value = ("%s:" + paramPString1.value);
                                          paramPString2.value = paramString2.field_nickname;
                                        }
                                      }
                                      paramString1 = Util.nullAsNil(paramString1);
                                      AppMethodBeat.o(238939);
                                      return paramString1;
                                      paramPString1.value = (paramContext.getString(R.l.app_me) + ":" + str1);
                                      break;
                                      paramString1 = aa.getDisplayName(paramPString2.value) + ":" + str1;
                                      AppMethodBeat.o(238939);
                                      return paramString1;
                                      if ((paramString3 == null) || (paramString3.length() <= 0)) {
                                        break label12857;
                                      }
                                      paramPString1.value = paramString3;
                                      paramString1 = paramString3;
                                      if (paramBoolean1)
                                      {
                                        a(paramInt2, paramPString1, paramPString2, paramPInt);
                                        paramString1 = paramString3;
                                      }
                                    }
                                  }
                                }
                                paramString3 = "";
                                localObject2 = null;
                                i = 0;
                                break label995;
                              }
                            }
                            localObject2 = null;
                            i = 0;
                            paramString1 = paramString3;
                            paramString3 = (String)localObject3;
                            break label995;
                            paramString1 = "";
                          }
                          paramString1 = "";
                        }
                      }
                    }
                  }
                }
              }
              label9070:
              label9201:
              paramString1 = paramString2;
              label9576:
              label10344:
              break label2985;
              label10215:
              paramString1 = paramString2;
            }
          }
          label5715:
          label8028:
          label11612:
          j = i;
        }
        label8523:
        label8910:
        label12240:
        localObject3 = paramString3;
        label9290:
        label10829:
        str2 = "";
        label9926:
        str1 = "";
      }
    }
  }
  
  private static void a(int paramInt, PString paramPString1, PString paramPString2, PInt paramPInt)
  {
    AppMethodBeat.i(20085);
    if ((paramPString1.value.length() == 32) && ((paramInt == 47) || (paramInt == 1048625)))
    {
      AppMethodBeat.o(20085);
      return;
    }
    if (paramPString1.value.length() >= 200)
    {
      com.tencent.mm.smiley.j.iVg();
      paramInt = com.tencent.mm.smiley.j.iE(paramPString1.value, 200);
      paramPString1.value = paramPString1.value.substring(0, ah(paramPString1.value, paramInt));
    }
    TextPaint localTextPaint = aLt();
    if ((paramPString1.value.replace("%%", "").contains("%s")) || (localTextPaint == null))
    {
      paramPInt.value = 0;
      AppMethodBeat.o(20085);
      return;
    }
    try
    {
      paramPString2 = String.format(paramPString1.value, new Object[] { paramPString2.value });
      paramPString1.value = a(paramPString2, localTextPaint).toString();
      paramPInt.value = 1;
      AppMethodBeat.o(20085);
      return;
    }
    catch (Exception paramPString2)
    {
      for (;;)
      {
        paramPString2 = paramPString1.value;
      }
    }
  }
  
  private static boolean a(int paramInt, PString paramPString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(238941);
    if (((paramPString.value.length() == 32) || (Util.isEqual(paramPString.value, paramString2))) && ((paramInt == 47) || (paramInt == 1048625)))
    {
      paramPString.value = paramString1;
      AppMethodBeat.o(238941);
      return true;
    }
    AppMethodBeat.o(238941);
    return false;
  }
  
  private static int aLr()
  {
    AppMethodBeat.i(169682);
    if (lvh > 0)
    {
      i = lvh;
      AppMethodBeat.o(169682);
      return i;
    }
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(MMApplicationContext.getContext(), 14.0F);
    AppMethodBeat.o(169682);
    return i;
  }
  
  private static int aLs()
  {
    AppMethodBeat.i(20087);
    if (lvg > 0)
    {
      i = lvg;
      AppMethodBeat.o(20087);
      return i;
    }
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(MMApplicationContext.getContext(), 200.0F);
    AppMethodBeat.o(20087);
    return i;
  }
  
  private static TextPaint aLt()
  {
    AppMethodBeat.i(20089);
    if (lvf == null)
    {
      AppMethodBeat.o(20089);
      return null;
    }
    TextPaint localTextPaint = (TextPaint)lvf.get();
    AppMethodBeat.o(20089);
    return localTextPaint;
  }
  
  private static int ah(String paramString, int paramInt)
  {
    AppMethodBeat.i(20088);
    while (paramInt < paramString.length())
    {
      if (paramString.charAt(paramInt) != '%')
      {
        AppMethodBeat.o(20088);
        return paramInt;
      }
      paramInt += 1;
    }
    paramInt = paramString.length();
    AppMethodBeat.o(20088);
    return paramInt;
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20071);
    paramContext = a(0, paramString2, paramString1, paramInt, paramContext);
    EmojiHelper.iUM();
    paramContext = com.tencent.mm.pluginsdk.ui.span.p.brr(EmojiHelper.buv(paramContext));
    AppMethodBeat.o(20071);
    return paramContext;
  }
  
  public static String b(cc paramcc, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20074);
    String str;
    if (paramcc.jbA())
    {
      str = paramcc.jct();
      if (!paramcc.iYe()) {
        break label90;
      }
    }
    for (paramcc = com.tencent.mm.pluginsdk.ui.span.p.brr(a(paramcc.field_imgPath, paramcc.field_isSend, paramcc.field_talker, str, paramcc.getType(), MMApplicationContext.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean, paramcc.kLo, paramcc.kLu));; paramcc = a(paramcc.field_imgPath, paramcc.field_isSend, paramcc.field_talker, str, paramcc.getType(), MMApplicationContext.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean, paramcc.kLo, paramcc.kLu))
    {
      paramcc = Util.nullAsNil(paramcc);
      AppMethodBeat.o(20074);
      return paramcc;
      str = paramcc.field_content;
      break;
      label90:
      str = com.tencent.mm.pluginsdk.ui.span.p.brr(str);
    }
  }
  
  public static boolean b(String paramString, cc paramcc)
  {
    AppMethodBeat.i(20070);
    if ((paramcc != null) && (paramcc.field_bizChatId != -1L) && (com.tencent.mm.an.g.Dn(paramString)))
    {
      AppMethodBeat.o(20070);
      return true;
    }
    AppMethodBeat.o(20070);
    return false;
  }
  
  public static void c(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(20090);
    if ((lvf == null) || (lvf.get() == null)) {
      lvf = new WeakReference(paramTextPaint);
    }
    AppMethodBeat.o(20090);
  }
  
  private static String cX(Context paramContext)
  {
    AppMethodBeat.i(20078);
    boolean bool = z.bBs();
    bh.bCz();
    long l = Util.nullAs((Long)com.tencent.mm.model.c.ban().d(65793, null), 0L);
    if (!bool)
    {
      paramContext = paramContext.getString(R.l.settings_plugins_disable);
      AppMethodBeat.o(20078);
      return paramContext;
    }
    if (l == 0L)
    {
      paramContext = paramContext.getString(R.l.gIE);
      AppMethodBeat.o(20078);
      return paramContext;
    }
    if (Util.secondsToNow(l) * 1000L > 1209600000L)
    {
      paramContext = paramContext.getString(R.l.gID, new Object[] { Long.valueOf(Util.secondsToNow(l) * 1000L / 86400000L) });
      AppMethodBeat.o(20078);
      return paramContext;
    }
    AppMethodBeat.o(20078);
    return "";
  }
  
  public static String d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20091);
    EmojiHelper.iUM();
    paramString = EmojiHelper.buv(paramString);
    if (paramBoolean)
    {
      AppMethodBeat.o(20091);
      return paramString;
    }
    paramContext = paramContext.getString(R.l.intro_title);
    AppMethodBeat.o(20091);
    return paramContext;
  }
  
  public static String e(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20093);
    if (paramBoolean)
    {
      EmojiHelper.iUM();
      paramContext = EmojiHelper.buv(paramString);
      AppMethodBeat.o(20093);
      return paramContext;
    }
    paramContext = paramContext.getString(R.l.gPU);
    AppMethodBeat.o(20093);
    return paramContext;
  }
  
  public static String j(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(20072);
    if (au.bwE(paramString1))
    {
      paramString2 = br.JJ(paramString2);
      if (paramString2 != null) {
        paramString2 = aa.getDisplayName(paramString2.trim());
      }
    }
    while (paramString1.contains("@bottle"))
    {
      paramContext = paramContext.getResources().getQuantityString(R.j.gpp, 1, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(20072);
      return paramContext;
      paramString2 = aa.getDisplayName(paramString1);
      continue;
      paramString2 = aa.getDisplayName(paramString1);
    }
    String str = paramString2;
    if (Util.isNullOrNil(paramString2))
    {
      str = paramString2;
      if (au.bwE(paramString1)) {
        str = paramContext.getString(R.l.gzv);
      }
    }
    EmojiHelper.iUM();
    paramContext = EmojiHelper.buv(str);
    AppMethodBeat.o(20072);
    return paramContext;
  }
  
  private static String k(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(20080);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)) || (Util.isNullOrNil(paramString3)))
    {
      AppMethodBeat.o(20080);
      return paramString1;
    }
    int i = paramString1.indexOf(paramString2);
    if (i < 0)
    {
      AppMethodBeat.o(20080);
      return paramString1;
    }
    paramString1 = paramString1.substring(0, i) + paramString3 + paramString1.substring(i + paramString2.length());
    AppMethodBeat.o(20080);
    return paramString1;
  }
  
  public static void qr(int paramInt)
  {
    lvg = paramInt;
  }
  
  public static void qs(int paramInt)
  {
    lvh = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.h
 * JD-Core Version:    0.7.0.1
 */