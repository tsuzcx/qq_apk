package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.d;
import com.tencent.mm.am.a.l;
import com.tencent.mm.cg.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.lang.ref.WeakReference;

public final class h
{
  private static WeakReference<TextPaint> fmd;
  private static int fme = 0;
  private static int fmf = 0;
  public String fmc = "";
  public String mDesc = "";
  public String mTitle = "";
  
  private static int C(String paramString, int paramInt)
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
  
  private static int Uo()
  {
    AppMethodBeat.i(169682);
    if (fmf > 0)
    {
      i = fmf;
      AppMethodBeat.o(169682);
      return i;
    }
    int i = BackwardSupportUtil.b.g(com.tencent.mm.sdk.platformtools.aj.getContext(), 14.0F);
    AppMethodBeat.o(169682);
    return i;
  }
  
  private static int Up()
  {
    AppMethodBeat.i(20087);
    if (fme > 0)
    {
      i = fme;
      AppMethodBeat.o(20087);
      return i;
    }
    int i = BackwardSupportUtil.b.g(com.tencent.mm.sdk.platformtools.aj.getContext(), 200.0F);
    AppMethodBeat.o(20087);
    return i;
  }
  
  private static CharSequence a(String paramString, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(20086);
    paramString = TextUtils.ellipsize(com.tencent.mm.pluginsdk.ui.span.k.b(com.tencent.mm.sdk.platformtools.aj.getContext(), paramString, Uo()), paramTextPaint, Up(), TextUtils.TruncateAt.END);
    AppMethodBeat.o(20086);
    return paramString;
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, int paramInt2, Context paramContext)
  {
    AppMethodBeat.i(20075);
    paramString1 = bt.nullAsNil(a(null, paramInt1, paramString1, paramString2, paramInt2, paramContext, new PString(), new PString(), new PInt(), false, false, "", 0));
    AppMethodBeat.o(20075);
    return paramString1;
  }
  
  private static String a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, PString paramPString1, PString paramPString2)
  {
    int j = 2131759556;
    AppMethodBeat.i(20077);
    String str3 = "";
    String str2;
    String str1;
    int i;
    if ((w.sJ(paramString1)) || (w.sL(paramString1)))
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
            if (!com.tencent.mm.storage.af.aHE(paramString1))
            {
              str2 = str3;
              str1 = paramString2;
              if (!com.tencent.mm.storage.af.aHG(paramString1)) {}
            }
            else
            {
              str2 = v.sh(paramString1);
              paramPString2.value = paramString1;
              str1 = paramString2.substring(i + 1);
            }
          }
        }
      }
      if (bt.nullAsNil(str2).length() > 0) {
        break label316;
      }
      if (paramString3 != null) {
        break label309;
      }
    }
    for (;;)
    {
      paramPString1.value = str1;
      paramContext = paramPString1.value;
      AppMethodBeat.o(20077);
      return paramContext;
      if (!com.tencent.mm.storage.af.aHE(paramString1))
      {
        str2 = str3;
        str1 = paramString2;
        if (!com.tencent.mm.storage.af.aHG(paramString1)) {
          break;
        }
      }
      v.sh(paramString1);
      paramPString2.value = paramString1;
      if (paramInt == 1)
      {
        paramContext = new StringBuilder().append(paramContext.getString(2131759556, new Object[] { "" }));
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
      label309:
      str1 = paramString3;
    }
    label316:
    paramString1 = new StringBuilder();
    if (paramInt == 1)
    {
      i = 2131759556;
      paramString2 = paramString1.append(paramContext.getString(i));
      if (paramString3 != null) {
        break label430;
      }
      paramString1 = str1;
      label352:
      paramPString1.value = paramString1;
      paramString1 = new StringBuilder();
      if (paramInt != 1) {
        break label436;
      }
      paramInt = j;
      label381:
      paramContext = paramString1.append(paramContext.getString(paramInt, new Object[] { str2 }));
      if (paramString3 != null) {
        break label442;
      }
    }
    for (;;)
    {
      paramContext = str1;
      AppMethodBeat.o(20077);
      return paramContext;
      i = 2131759566;
      break;
      label430:
      paramString1 = paramString3;
      break label352;
      label436:
      paramInt = 2131759566;
      break label381;
      label442:
      str1 = paramString3;
    }
  }
  
  public static String a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(20092);
    if (paramBoolean)
    {
      String str = b.eHL().aGL(paramString);
      paramString = str;
      if (paramInt3 > 1) {
        paramString = paramContext.getResources().getQuantityString(2131623960, paramInt3, new Object[] { Integer.valueOf(paramInt3) }) + str;
      }
      AppMethodBeat.o(20092);
      return paramString;
    }
    paramContext = paramContext.getResources().getQuantityString(2131623961, paramInt1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(20092);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20071);
    paramContext = a(0, paramString2, paramString1, paramInt, paramContext);
    paramContext = com.tencent.mm.pluginsdk.ui.span.k.aCn(b.eHL().aGL(paramContext));
    AppMethodBeat.o(20071);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt, bl parambl)
  {
    AppMethodBeat.i(20073);
    if (TextUtils.isEmpty(paramString2)) {
      parambl = null;
    }
    for (;;)
    {
      paramString1 = parambl;
      if (bt.isNullOrNil(parambl))
      {
        if (!com.tencent.mm.m.f.pF(paramString2)) {
          break;
        }
        paramString1 = paramContext.getString(2131757293);
      }
      paramContext = b.eHL().aGL(paramString1);
      AppMethodBeat.o(20073);
      return paramContext;
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (!b(paramString2, parambl)) {
              continue;
            }
            if (parambl == null) {
              continue;
            }
            localObject1 = com.tencent.mm.am.af.awg().bg(parambl.field_bizChatId);
            if (((com.tencent.mm.am.a.c)localObject1).isGroup()) {
              if (bt.isNullOrNil(((com.tencent.mm.am.a.c)localObject1).field_chatName)) {
                localObject1 = com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131762623);
              }
            }
          }
          catch (Throwable parambl)
          {
            boolean bool;
            com.tencent.mm.storage.af localaf;
            Object localObject2;
            Object localObject1 = null;
            continue;
            localObject1 = null;
            continue;
            localObject1 = null;
            continue;
          }
          try
          {
            bool = TextUtils.isEmpty((CharSequence)localObject1);
            parambl = (bl)localObject1;
            if (!bool) {
              break;
            }
          }
          catch (Throwable parambl) {}
        }
        az.arV();
        localaf = com.tencent.mm.model.c.apM().aHY(paramString2);
        if (localaf != null) {
          continue;
        }
        parambl = null;
        break;
        localObject1 = ((com.tencent.mm.am.a.c)localObject1).field_chatName;
        continue;
        parambl = com.tencent.mm.am.af.awi().ea(parambl.field_bizChatUserId);
        if (parambl == null) {
          continue;
        }
        localObject1 = parambl.field_userName;
      }
      localObject2 = localObject1;
      if (paramInt == 318767153)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject2 = ((a)g.ab(a.class)).as(paramString1, paramString2);
          parambl = (bl)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
        }
      }
      if (w.tk(paramString2))
      {
        parambl = localaf.ZW();
      }
      else
      {
        if (com.tencent.mm.storage.af.st(paramString2))
        {
          localObject1 = com.tencent.mm.sdk.platformtools.aj.getContext();
          if (localaf != null) {
            if (RegionCodeDecoder.aJc(localaf.getCountryCode()))
            {
              paramString1 = localaf.getCity();
              if (bt.isNullOrNil(paramString1)) {}
            }
          }
          for (;;)
          {
            parambl = paramContext.getString(2131756698, new Object[] { paramString1 }).trim();
            break;
            parambl = v.sj(localaf.getProvince());
            paramString1 = parambl;
            if (bt.isNullOrNil(parambl))
            {
              RegionCodeDecoder.eMO();
              paramString1 = RegionCodeDecoder.getLocName(localaf.getCountryCode());
              continue;
              parambl = v.sj(localaf.getProvince());
              paramString1 = parambl;
              if (bt.isNullOrNil(parambl)) {
                paramString1 = ((Context)localObject1).getString(2131756727);
              }
            }
          }
        }
        if ((com.tencent.mm.m.f.pF(paramString2)) && (bt.isNullOrNil(localaf.field_nickname)) && (bt.isNullOrNil(localaf.field_conRemark)))
        {
          az.arV();
          paramString1 = com.tencent.mm.model.c.apV().sh(paramString2);
          parambl = (bl)localObject2;
          if (!bt.isNullOrNil(paramString1)) {
            parambl = paramString1;
          }
        }
        else
        {
          parambl = (bl)localObject2;
          if (localaf.ZX() != null)
          {
            parambl = (bl)localObject2;
            if (localaf.ZX().length() > 0) {
              parambl = localaf.ZX();
            }
          }
        }
      }
    }
    paramContext = paramContext.getString(2131760347);
    AppMethodBeat.o(20073);
    return paramContext;
  }
  
  /* Error */
  private static String a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, Context paramContext, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean1, boolean paramBoolean2, String paramString4, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 360
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload 5
    //   8: ifnull +65 -> 73
    //   11: iconst_1
    //   12: istore 17
    //   14: ldc_w 362
    //   17: iload 17
    //   19: invokestatic 368	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   22: aload_2
    //   23: ifnull +56 -> 79
    //   26: aload_2
    //   27: invokevirtual 46	java/lang/String:length	()I
    //   30: ifle +49 -> 79
    //   33: iconst_1
    //   34: istore 17
    //   36: ldc_w 370
    //   39: iload 17
    //   41: invokestatic 368	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   44: iload 9
    //   46: ifne +39 -> 85
    //   49: aload_2
    //   50: invokestatic 373	com/tencent/mm/booter/notification/a/h:oE	(Ljava/lang/String;)Z
    //   53: ifeq +32 -> 85
    //   56: aload 5
    //   58: ldc_w 374
    //   61: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   64: astore_0
    //   65: ldc_w 360
    //   68: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_0
    //   72: areturn
    //   73: iconst_0
    //   74: istore 17
    //   76: goto -62 -> 14
    //   79: iconst_0
    //   80: istore 17
    //   82: goto -46 -> 36
    //   85: aload_2
    //   86: invokestatic 377	com/tencent/mm/model/w:sP	(Ljava/lang/String;)Z
    //   89: ifeq +31 -> 120
    //   92: iload 9
    //   94: ifeq +12 -> 106
    //   97: ldc_w 360
    //   100: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: ldc 26
    //   105: areturn
    //   106: aload 5
    //   108: invokestatic 381	com/tencent/mm/booter/notification/a/h:bQ	(Landroid/content/Context;)Ljava/lang/String;
    //   111: astore_0
    //   112: ldc_w 360
    //   115: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_0
    //   119: areturn
    //   120: aload_3
    //   121: ifnull +8939 -> 9060
    //   124: iload 9
    //   126: ifeq +8934 -> 9060
    //   129: aload_3
    //   130: invokestatic 384	com/tencent/mm/booter/notification/a/h:oC	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_3
    //   134: iconst_1
    //   135: istore 15
    //   137: aload 6
    //   139: aload_3
    //   140: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   143: iload_1
    //   144: ifne +8902 -> 9046
    //   147: aload_2
    //   148: invokestatic 385	com/tencent/mm/model/w:pF	(Ljava/lang/String;)Z
    //   151: ifne +10 -> 161
    //   154: aload_2
    //   155: invokestatic 388	com/tencent/mm/model/w:sn	(Ljava/lang/String;)Z
    //   158: ifeq +8888 -> 9046
    //   161: aload_3
    //   162: invokestatic 393	com/tencent/mm/model/bi:uc	(Ljava/lang/String;)I
    //   165: istore 13
    //   167: iload 13
    //   169: ifle +8877 -> 9046
    //   172: aload_3
    //   173: iconst_0
    //   174: iload 13
    //   176: invokevirtual 131	java/lang/String:substring	(II)Ljava/lang/String;
    //   179: invokevirtual 324	java/lang/String:trim	()Ljava/lang/String;
    //   182: astore 19
    //   184: aload 19
    //   186: aload_2
    //   187: invokestatic 396	com/tencent/mm/model/v:getDisplayName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 20
    //   192: new 152	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   199: aload_3
    //   200: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc_w 398
    //   206: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: iload 13
    //   214: iconst_1
    //   215: iadd
    //   216: invokevirtual 150	java/lang/String:substring	(I)Ljava/lang/String;
    //   219: astore 21
    //   221: iconst_0
    //   222: istore 13
    //   224: aload_2
    //   225: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   228: ifne +10 -> 238
    //   231: aload_2
    //   232: invokestatic 404	com/tencent/mm/model/w:tm	(Ljava/lang/String;)Z
    //   235: ifeq +633 -> 868
    //   238: aload_3
    //   239: ldc 123
    //   241: invokevirtual 127	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   244: istore 13
    //   246: aload_3
    //   247: astore 18
    //   249: iload 13
    //   251: iconst_m1
    //   252: if_icmpeq +25 -> 277
    //   255: aload 7
    //   257: aload_3
    //   258: iconst_0
    //   259: iload 13
    //   261: invokevirtual 131	java/lang/String:substring	(II)Ljava/lang/String;
    //   264: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   267: aload_3
    //   268: iload 13
    //   270: iconst_1
    //   271: iadd
    //   272: invokevirtual 150	java/lang/String:substring	(I)Ljava/lang/String;
    //   275: astore 18
    //   277: iconst_0
    //   278: istore 14
    //   280: aload 18
    //   282: astore_3
    //   283: iload 4
    //   285: lookupswitch	default:+539->824, -1879048191:+1261->1546, -1879048190:+1261->1546, -1879048189:+1261->1546, -1879048188:+1367->1652, -1879048186:+3612->3897, -1879048185:+3766->4051, -1879048183:+3766->4051, -1879048176:+3766->4051, 3:+675->960, 11:+882->1167, 13:+849->1134, 23:+675->960, 33:+675->960, 34:+908->1193, 35:+1726->2011, 36:+882->1167, 37:+1388->1673, 39:+849->1134, 40:+1643->1928, 42:+1797->2082, 43:+1074->1359, 47:+757->1042, 48:+2057->2342, 49:+4769->5054, 50:+1282->1567, 52:+1346->1631, 53:+1282->1567, 55:+7405->7690, 57:+7405->7690, 62:+1074->1359, 66:+1797->2082, 1048625:+757->1042, 12299999:+1240->1525, 16777265:+4769->5054, 268435505:+4769->5054, 285212721:+7278->7563, 318767153:+7341->7626, 335544369:+2184->2469, 369098801:+3053->3338, 402653233:+2297->2582, 419430449:+2381->2666, 436207665:+2603->2888, 452984881:+3203->3488, 469762097:+2603->2888, 486539313:+1074->1359, 503316529:+7431->7716, 520093745:+3413->3698, 536870961:+2826->3111, 553648177:+4769->5054, 570425393:+7515->7800, 587202609:+4769->5054, 603979825:+7638->7923, 671088689:+2955->3240, 687865905:+4769->5054, 704643121:+3867->4152, 721420337:+7676->7961, 738197553:+4769->5054, 754974769:+4002->4287, 771751985:+4388->4673, 788529201:+4563->4848, 805306417:+4769->5054, 822083633:+4769->5054, 838860849:+4175->4460, 855638065:+4691->4976, 872415281:+7703->7988, 889192497:+4614->4899
    //   825: astore_0
    //   826: ldc 26
    //   828: astore_3
    //   829: aconst_null
    //   830: astore 18
    //   832: iconst_0
    //   833: istore 13
    //   835: aload_2
    //   836: invokestatic 407	com/tencent/mm/model/w:sK	(Ljava/lang/String;)Z
    //   839: ifeq +7542 -> 8381
    //   842: iconst_1
    //   843: iload_1
    //   844: if_icmpne +7255 -> 8099
    //   847: aload_3
    //   848: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   851: ifne +7199 -> 8050
    //   854: aload 6
    //   856: aload_3
    //   857: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   860: ldc_w 360
    //   863: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   866: aload_3
    //   867: areturn
    //   868: invokestatic 257	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
    //   871: pop
    //   872: invokestatic 411	com/tencent/mm/model/c:apR	()Lcom/tencent/mm/storage/bh;
    //   875: aload_2
    //   876: invokeinterface 417 2 0
    //   881: astore 18
    //   883: aload 18
    //   885: ifnull +14 -> 899
    //   888: aload 18
    //   890: ldc_w 418
    //   893: invokevirtual 424	com/tencent/mm/storage/am:lw	(I)Z
    //   896: ifne +8 -> 904
    //   899: iload 10
    //   901: ifeq +8138 -> 9039
    //   904: iconst_1
    //   905: istore 14
    //   907: iload 14
    //   909: istore 13
    //   911: aload_3
    //   912: ifnull +8127 -> 9039
    //   915: aload_3
    //   916: ldc 123
    //   918: invokevirtual 127	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   921: istore 16
    //   923: iload 14
    //   925: istore 13
    //   927: iload 16
    //   929: iconst_m1
    //   930: if_icmpeq +8109 -> 9039
    //   933: aload 7
    //   935: aload_3
    //   936: iconst_0
    //   937: iload 16
    //   939: invokevirtual 131	java/lang/String:substring	(II)Ljava/lang/String;
    //   942: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   945: aload_3
    //   946: iload 16
    //   948: iconst_1
    //   949: iadd
    //   950: invokevirtual 150	java/lang/String:substring	(I)Ljava/lang/String;
    //   953: astore_3
    //   954: iconst_1
    //   955: istore 14
    //   957: goto -674 -> 283
    //   960: aload 5
    //   962: ldc_w 425
    //   965: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   968: astore 21
    //   970: aload 19
    //   972: invokevirtual 46	java/lang/String:length	()I
    //   975: ifle +55 -> 1030
    //   978: new 152	java/lang/StringBuilder
    //   981: dup
    //   982: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   985: aload 19
    //   987: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   990: ldc_w 427
    //   993: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   999: astore_0
    //   1000: aload 19
    //   1002: invokevirtual 46	java/lang/String:length	()I
    //   1005: ifle +31 -> 1036
    //   1008: ldc_w 429
    //   1011: astore_3
    //   1012: aload 6
    //   1014: aload_3
    //   1015: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1018: aconst_null
    //   1019: astore 18
    //   1021: iconst_0
    //   1022: istore 13
    //   1024: aload 21
    //   1026: astore_3
    //   1027: goto -192 -> 835
    //   1030: ldc 26
    //   1032: astore_0
    //   1033: goto -33 -> 1000
    //   1036: ldc 26
    //   1038: astore_3
    //   1039: goto -27 -> 1012
    //   1042: aload_3
    //   1043: invokestatic 435	com/tencent/mm/storage/ar:aIF	(Ljava/lang/String;)Lcom/tencent/mm/storage/ar;
    //   1046: astore 21
    //   1048: new 152	java/lang/StringBuilder
    //   1051: dup
    //   1052: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1055: aload 21
    //   1057: invokevirtual 438	com/tencent/mm/storage/ar:aCQ	()Ljava/lang/String;
    //   1060: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: ldc_w 427
    //   1066: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1072: astore 18
    //   1074: aload_0
    //   1075: ifnull +47 -> 1122
    //   1078: aload_0
    //   1079: invokevirtual 46	java/lang/String:length	()I
    //   1082: bipush 32
    //   1084: if_icmpne +38 -> 1122
    //   1087: aload_0
    //   1088: astore_3
    //   1089: aload 6
    //   1091: ldc 26
    //   1093: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1096: aload 7
    //   1098: aload 21
    //   1100: invokevirtual 438	com/tencent/mm/storage/ar:aCQ	()Ljava/lang/String;
    //   1103: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1106: aconst_null
    //   1107: astore 21
    //   1109: iconst_0
    //   1110: istore 13
    //   1112: aload 18
    //   1114: astore_0
    //   1115: aload 21
    //   1117: astore 18
    //   1119: goto -284 -> 835
    //   1122: aload 5
    //   1124: ldc_w 439
    //   1127: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1130: astore_3
    //   1131: goto -42 -> 1089
    //   1134: aload 5
    //   1136: iload_1
    //   1137: aload_2
    //   1138: aload_3
    //   1139: aload 5
    //   1141: ldc_w 425
    //   1144: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1147: aload 6
    //   1149: aload 7
    //   1151: invokestatic 441	com/tencent/mm/booter/notification/a/h:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;)Ljava/lang/String;
    //   1154: astore_0
    //   1155: ldc 26
    //   1157: astore_3
    //   1158: aconst_null
    //   1159: astore 18
    //   1161: iconst_0
    //   1162: istore 13
    //   1164: goto -329 -> 835
    //   1167: aload 5
    //   1169: iload_1
    //   1170: aload_2
    //   1171: aload_3
    //   1172: aconst_null
    //   1173: aload 6
    //   1175: aload 7
    //   1177: invokestatic 441	com/tencent/mm/booter/notification/a/h:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;)Ljava/lang/String;
    //   1180: astore_0
    //   1181: ldc 26
    //   1183: astore_3
    //   1184: aconst_null
    //   1185: astore 18
    //   1187: iconst_0
    //   1188: istore 13
    //   1190: goto -355 -> 835
    //   1193: aload_2
    //   1194: invokestatic 136	com/tencent/mm/storage/af:aHE	(Ljava/lang/String;)Z
    //   1197: ifne +24 -> 1221
    //   1200: aload_2
    //   1201: invokestatic 139	com/tencent/mm/storage/af:aHG	(Ljava/lang/String;)Z
    //   1204: ifne +17 -> 1221
    //   1207: aload_2
    //   1208: invokestatic 118	com/tencent/mm/model/w:sJ	(Ljava/lang/String;)Z
    //   1211: ifne +10 -> 1221
    //   1214: aload_2
    //   1215: invokestatic 121	com/tencent/mm/model/w:sL	(Ljava/lang/String;)Z
    //   1218: ifeq +36 -> 1254
    //   1221: aload 5
    //   1223: iload_1
    //   1224: aload_2
    //   1225: aload_3
    //   1226: aload 5
    //   1228: ldc_w 442
    //   1231: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1234: aload 6
    //   1236: aload 7
    //   1238: invokestatic 441	com/tencent/mm/booter/notification/a/h:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;)Ljava/lang/String;
    //   1241: astore_0
    //   1242: ldc 26
    //   1244: astore_3
    //   1245: aconst_null
    //   1246: astore 18
    //   1248: iconst_0
    //   1249: istore 13
    //   1251: goto -416 -> 835
    //   1254: aload_3
    //   1255: astore_0
    //   1256: aload_3
    //   1257: ifnull +78 -> 1335
    //   1260: aload_3
    //   1261: astore_0
    //   1262: aload_3
    //   1263: invokevirtual 46	java/lang/String:length	()I
    //   1266: ifle +69 -> 1335
    //   1269: aload_3
    //   1270: astore_0
    //   1271: aload_2
    //   1272: invokestatic 407	com/tencent/mm/model/w:sK	(Ljava/lang/String;)Z
    //   1275: ifne +60 -> 1335
    //   1278: aload_2
    //   1279: invokestatic 385	com/tencent/mm/model/w:pF	(Ljava/lang/String;)Z
    //   1282: ifeq +71 -> 1353
    //   1285: new 444	com/tencent/mm/modelvoice/p
    //   1288: dup
    //   1289: aload_3
    //   1290: invokespecial 447	com/tencent/mm/modelvoice/p:<init>	(Ljava/lang/String;)V
    //   1293: astore_3
    //   1294: new 152	java/lang/StringBuilder
    //   1297: dup
    //   1298: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1301: aload_3
    //   1302: invokevirtual 448	com/tencent/mm/modelvoice/p:aCQ	()Ljava/lang/String;
    //   1305: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1308: ldc_w 427
    //   1311: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1317: astore_0
    //   1318: aload 6
    //   1320: ldc_w 450
    //   1323: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1326: aload 7
    //   1328: aload_3
    //   1329: invokevirtual 448	com/tencent/mm/modelvoice/p:aCQ	()Ljava/lang/String;
    //   1332: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1335: aload 5
    //   1337: ldc_w 442
    //   1340: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1343: astore_3
    //   1344: aconst_null
    //   1345: astore 18
    //   1347: iconst_0
    //   1348: istore 13
    //   1350: goto -515 -> 835
    //   1353: ldc 26
    //   1355: astore_0
    //   1356: goto -21 -> 1335
    //   1359: aload_2
    //   1360: invokestatic 136	com/tencent/mm/storage/af:aHE	(Ljava/lang/String;)Z
    //   1363: ifne +24 -> 1387
    //   1366: aload_2
    //   1367: invokestatic 139	com/tencent/mm/storage/af:aHG	(Ljava/lang/String;)Z
    //   1370: ifne +17 -> 1387
    //   1373: aload_2
    //   1374: invokestatic 118	com/tencent/mm/model/w:sJ	(Ljava/lang/String;)Z
    //   1377: ifne +10 -> 1387
    //   1380: aload_2
    //   1381: invokestatic 121	com/tencent/mm/model/w:sL	(Ljava/lang/String;)Z
    //   1384: ifeq +36 -> 1420
    //   1387: aload 5
    //   1389: iload_1
    //   1390: aload_2
    //   1391: aload_3
    //   1392: aload 5
    //   1394: ldc_w 451
    //   1397: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1400: aload 6
    //   1402: aload 7
    //   1404: invokestatic 441	com/tencent/mm/booter/notification/a/h:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;)Ljava/lang/String;
    //   1407: astore_0
    //   1408: ldc 26
    //   1410: astore_3
    //   1411: aconst_null
    //   1412: astore 18
    //   1414: iconst_0
    //   1415: istore 13
    //   1417: goto -582 -> 835
    //   1420: aload_3
    //   1421: astore_0
    //   1422: aload_3
    //   1423: ifnull +78 -> 1501
    //   1426: aload_3
    //   1427: astore_0
    //   1428: aload_3
    //   1429: invokevirtual 46	java/lang/String:length	()I
    //   1432: ifle +69 -> 1501
    //   1435: aload_3
    //   1436: astore_0
    //   1437: aload_2
    //   1438: invokestatic 407	com/tencent/mm/model/w:sK	(Ljava/lang/String;)Z
    //   1441: ifne +60 -> 1501
    //   1444: aload_2
    //   1445: invokestatic 385	com/tencent/mm/model/w:pF	(Ljava/lang/String;)Z
    //   1448: ifeq +71 -> 1519
    //   1451: new 453	com/tencent/mm/modelvideo/q
    //   1454: dup
    //   1455: aload_3
    //   1456: invokespecial 454	com/tencent/mm/modelvideo/q:<init>	(Ljava/lang/String;)V
    //   1459: astore_3
    //   1460: new 152	java/lang/StringBuilder
    //   1463: dup
    //   1464: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1467: aload_3
    //   1468: invokevirtual 455	com/tencent/mm/modelvideo/q:aCQ	()Ljava/lang/String;
    //   1471: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: ldc_w 427
    //   1477: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1480: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1483: astore_0
    //   1484: aload 6
    //   1486: ldc_w 450
    //   1489: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1492: aload 7
    //   1494: aload_3
    //   1495: invokevirtual 455	com/tencent/mm/modelvideo/q:aCQ	()Ljava/lang/String;
    //   1498: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1501: aload 5
    //   1503: ldc_w 451
    //   1506: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1509: astore_3
    //   1510: aconst_null
    //   1511: astore 18
    //   1513: iconst_0
    //   1514: istore 13
    //   1516: goto -681 -> 835
    //   1519: ldc 26
    //   1521: astore_0
    //   1522: goto -21 -> 1501
    //   1525: aload 5
    //   1527: ldc_w 456
    //   1530: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1533: astore_3
    //   1534: aconst_null
    //   1535: astore 18
    //   1537: iconst_0
    //   1538: istore 13
    //   1540: ldc 26
    //   1542: astore_0
    //   1543: goto -708 -> 835
    //   1546: aload 5
    //   1548: ldc_w 457
    //   1551: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1554: astore_3
    //   1555: aconst_null
    //   1556: astore 18
    //   1558: iconst_0
    //   1559: istore 13
    //   1561: ldc 26
    //   1563: astore_0
    //   1564: goto -729 -> 835
    //   1567: aload_3
    //   1568: getstatic 462	com/tencent/mm/storage/bl:FzN	Ljava/lang/String;
    //   1571: invokevirtual 466	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1574: ifeq +24 -> 1598
    //   1577: aload 5
    //   1579: ldc_w 456
    //   1582: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1585: astore_3
    //   1586: aconst_null
    //   1587: astore 18
    //   1589: iconst_0
    //   1590: istore 13
    //   1592: ldc 26
    //   1594: astore_0
    //   1595: goto -760 -> 835
    //   1598: aload_3
    //   1599: astore_0
    //   1600: aload_3
    //   1601: getstatic 469	com/tencent/mm/storage/bl:FzM	Ljava/lang/String;
    //   1604: invokevirtual 466	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1607: ifeq -781 -> 826
    //   1610: aload 5
    //   1612: ldc_w 470
    //   1615: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1618: astore_3
    //   1619: aconst_null
    //   1620: astore 18
    //   1622: iconst_0
    //   1623: istore 13
    //   1625: ldc 26
    //   1627: astore_0
    //   1628: goto -793 -> 835
    //   1631: aload 5
    //   1633: ldc_w 456
    //   1636: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1639: astore_3
    //   1640: aconst_null
    //   1641: astore 18
    //   1643: iconst_0
    //   1644: istore 13
    //   1646: ldc 26
    //   1648: astore_0
    //   1649: goto -814 -> 835
    //   1652: aload 5
    //   1654: ldc_w 470
    //   1657: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1660: astore_3
    //   1661: aconst_null
    //   1662: astore 18
    //   1664: iconst_0
    //   1665: istore 13
    //   1667: ldc 26
    //   1669: astore_0
    //   1670: goto -835 -> 835
    //   1673: aload_3
    //   1674: astore_0
    //   1675: aload_3
    //   1676: ifnull -850 -> 826
    //   1679: aload_3
    //   1680: astore_0
    //   1681: aload_3
    //   1682: invokevirtual 46	java/lang/String:length	()I
    //   1685: ifle -859 -> 826
    //   1688: aload_3
    //   1689: invokestatic 476	com/tencent/mm/storage/bl$d:aIR	(Ljava/lang/String;)Lcom/tencent/mm/storage/bl$d;
    //   1692: astore 18
    //   1694: aload_3
    //   1695: astore_0
    //   1696: aload 18
    //   1698: invokevirtual 479	com/tencent/mm/storage/bl$d:eMF	()Ljava/lang/String;
    //   1701: ifnull +110 -> 1811
    //   1704: aload_3
    //   1705: astore_0
    //   1706: aload 18
    //   1708: invokevirtual 479	com/tencent/mm/storage/bl$d:eMF	()Ljava/lang/String;
    //   1711: invokevirtual 46	java/lang/String:length	()I
    //   1714: ifle +97 -> 1811
    //   1717: aload 18
    //   1719: invokevirtual 482	com/tencent/mm/storage/bl$d:getScene	()I
    //   1722: tableswitch	default:+62 -> 1784, 18:+101->1823, 19:+62->1784, 20:+62->1784, 21:+62->1784, 22:+134->1856, 23:+134->1856, 24:+134->1856, 25:+167->1889, 26:+134->1856, 27:+134->1856, 28:+134->1856, 29:+134->1856
    //   1785: iconst_2
    //   1786: ldc_w 483
    //   1789: iconst_1
    //   1790: anewarray 4	java/lang/Object
    //   1793: dup
    //   1794: iconst_0
    //   1795: aload 18
    //   1797: invokevirtual 485	com/tencent/mm/storage/bl$d:getDisplayName	()Ljava/lang/String;
    //   1800: aastore
    //   1801: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1804: astore_0
    //   1805: aload 6
    //   1807: aload_0
    //   1808: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1811: ldc 26
    //   1813: astore_3
    //   1814: aconst_null
    //   1815: astore 18
    //   1817: iconst_0
    //   1818: istore 13
    //   1820: goto -985 -> 835
    //   1823: aload 5
    //   1825: ldc_w 486
    //   1828: iconst_1
    //   1829: anewarray 4	java/lang/Object
    //   1832: dup
    //   1833: iconst_0
    //   1834: aload 18
    //   1836: invokevirtual 485	com/tencent/mm/storage/bl$d:getDisplayName	()Ljava/lang/String;
    //   1839: aastore
    //   1840: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1843: astore_0
    //   1844: ldc 26
    //   1846: astore_3
    //   1847: aconst_null
    //   1848: astore 18
    //   1850: iconst_0
    //   1851: istore 13
    //   1853: goto -1018 -> 835
    //   1856: aload 5
    //   1858: ldc_w 487
    //   1861: iconst_1
    //   1862: anewarray 4	java/lang/Object
    //   1865: dup
    //   1866: iconst_0
    //   1867: aload 18
    //   1869: invokevirtual 485	com/tencent/mm/storage/bl$d:getDisplayName	()Ljava/lang/String;
    //   1872: aastore
    //   1873: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1876: astore_0
    //   1877: ldc 26
    //   1879: astore_3
    //   1880: aconst_null
    //   1881: astore 18
    //   1883: iconst_0
    //   1884: istore 13
    //   1886: goto -1051 -> 835
    //   1889: aload 5
    //   1891: ldc_w 488
    //   1894: iconst_1
    //   1895: anewarray 4	java/lang/Object
    //   1898: dup
    //   1899: iconst_0
    //   1900: aload 18
    //   1902: invokevirtual 485	com/tencent/mm/storage/bl$d:getDisplayName	()Ljava/lang/String;
    //   1905: aastore
    //   1906: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1909: astore_0
    //   1910: aload 6
    //   1912: aload_0
    //   1913: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1916: ldc 26
    //   1918: astore_3
    //   1919: aconst_null
    //   1920: astore 18
    //   1922: iconst_0
    //   1923: istore 13
    //   1925: goto -1090 -> 835
    //   1928: aload_3
    //   1929: astore_0
    //   1930: aload_3
    //   1931: ifnull -1105 -> 826
    //   1934: aload_3
    //   1935: astore_0
    //   1936: aload_3
    //   1937: invokevirtual 46	java/lang/String:length	()I
    //   1940: ifle -1114 -> 826
    //   1943: aload_3
    //   1944: invokestatic 494	com/tencent/mm/storage/bl$a:aIO	(Ljava/lang/String;)Lcom/tencent/mm/storage/bl$a;
    //   1947: astore 18
    //   1949: aload_3
    //   1950: astore_0
    //   1951: aload 18
    //   1953: invokevirtual 495	com/tencent/mm/storage/bl$a:eMF	()Ljava/lang/String;
    //   1956: ifnull +43 -> 1999
    //   1959: aload_3
    //   1960: astore_0
    //   1961: aload 18
    //   1963: invokevirtual 495	com/tencent/mm/storage/bl$a:eMF	()Ljava/lang/String;
    //   1966: invokevirtual 46	java/lang/String:length	()I
    //   1969: ifle +30 -> 1999
    //   1972: aload 5
    //   1974: ldc_w 496
    //   1977: iconst_1
    //   1978: anewarray 4	java/lang/Object
    //   1981: dup
    //   1982: iconst_0
    //   1983: aload 18
    //   1985: invokevirtual 497	com/tencent/mm/storage/bl$a:getDisplayName	()Ljava/lang/String;
    //   1988: aastore
    //   1989: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1992: astore_0
    //   1993: aload 6
    //   1995: aload_0
    //   1996: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1999: ldc 26
    //   2001: astore_3
    //   2002: aconst_null
    //   2003: astore 18
    //   2005: iconst_0
    //   2006: istore 13
    //   2008: goto -1173 -> 835
    //   2011: aload_3
    //   2012: astore_0
    //   2013: aload_3
    //   2014: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2017: invokevirtual 46	java/lang/String:length	()I
    //   2020: ifle -1194 -> 826
    //   2023: invokestatic 257	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
    //   2026: pop
    //   2027: invokestatic 501	com/tencent/mm/model/c:apO	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/h;
    //   2030: aload_3
    //   2031: invokeinterface 507 2 0
    //   2036: astore_0
    //   2037: aload 5
    //   2039: ldc_w 508
    //   2042: iconst_2
    //   2043: anewarray 4	java/lang/Object
    //   2046: dup
    //   2047: iconst_0
    //   2048: aload_0
    //   2049: invokevirtual 513	com/tencent/mm/storage/bl$c:getSender	()Ljava/lang/String;
    //   2052: aastore
    //   2053: dup
    //   2054: iconst_1
    //   2055: aload_0
    //   2056: invokevirtual 516	com/tencent/mm/storage/bl$c:getTitle	()Ljava/lang/String;
    //   2059: aastore
    //   2060: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2063: astore_0
    //   2064: aload 6
    //   2066: aload_0
    //   2067: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2070: ldc 26
    //   2072: astore_3
    //   2073: aconst_null
    //   2074: astore 18
    //   2076: iconst_0
    //   2077: istore 13
    //   2079: goto -1244 -> 835
    //   2082: aload_3
    //   2083: astore_0
    //   2084: aload_3
    //   2085: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2088: invokevirtual 46	java/lang/String:length	()I
    //   2091: ifle -1265 -> 826
    //   2094: aload_2
    //   2095: invokestatic 385	com/tencent/mm/model/w:pF	(Ljava/lang/String;)Z
    //   2098: ifeq +20 -> 2118
    //   2101: aload_3
    //   2102: invokestatic 519	com/tencent/mm/model/bi:uf	(Ljava/lang/String;)Ljava/lang/String;
    //   2105: astore 18
    //   2107: aload 18
    //   2109: astore_0
    //   2110: aload 18
    //   2112: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2115: ifeq +5 -> 2120
    //   2118: aload_2
    //   2119: astore_0
    //   2120: invokestatic 257	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
    //   2123: pop
    //   2124: invokestatic 501	com/tencent/mm/model/c:apO	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/h;
    //   2127: aload_3
    //   2128: invokeinterface 522 2 0
    //   2133: astore 21
    //   2135: invokestatic 257	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
    //   2138: pop
    //   2139: invokestatic 263	com/tencent/mm/model/c:apM	()Lcom/tencent/mm/storage/bg;
    //   2142: aload_0
    //   2143: invokeinterface 269 2 0
    //   2148: invokevirtual 356	com/tencent/mm/storage/af:ZX	()Ljava/lang/String;
    //   2151: astore 18
    //   2153: aload 18
    //   2155: astore_3
    //   2156: aload 18
    //   2158: invokestatic 385	com/tencent/mm/model/w:pF	(Ljava/lang/String;)Z
    //   2161: ifeq +12 -> 2173
    //   2164: aload 18
    //   2166: invokestatic 528	com/tencent/mm/model/q:rZ	(Ljava/lang/String;)Ljava/util/List;
    //   2169: invokestatic 532	com/tencent/mm/model/q:ag	(Ljava/util/List;)Ljava/lang/String;
    //   2172: astore_3
    //   2173: iload_1
    //   2174: iconst_1
    //   2175: if_icmpne +85 -> 2260
    //   2178: aload 5
    //   2180: ldc_w 533
    //   2183: iconst_2
    //   2184: anewarray 4	java/lang/Object
    //   2187: dup
    //   2188: iconst_0
    //   2189: aload_3
    //   2190: aastore
    //   2191: dup
    //   2192: iconst_1
    //   2193: aload 21
    //   2195: invokevirtual 497	com/tencent/mm/storage/bl$a:getDisplayName	()Ljava/lang/String;
    //   2198: aastore
    //   2199: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2202: astore 18
    //   2204: aload 6
    //   2206: aload 5
    //   2208: ldc_w 533
    //   2211: iconst_2
    //   2212: anewarray 4	java/lang/Object
    //   2215: dup
    //   2216: iconst_0
    //   2217: ldc_w 535
    //   2220: aastore
    //   2221: dup
    //   2222: iconst_1
    //   2223: aload 21
    //   2225: invokevirtual 497	com/tencent/mm/storage/bl$a:getDisplayName	()Ljava/lang/String;
    //   2228: aastore
    //   2229: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2232: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2235: aload 7
    //   2237: aload_0
    //   2238: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2241: ldc 26
    //   2243: astore_3
    //   2244: aconst_null
    //   2245: astore 21
    //   2247: iconst_0
    //   2248: istore 13
    //   2250: aload 18
    //   2252: astore_0
    //   2253: aload 21
    //   2255: astore 18
    //   2257: goto -1422 -> 835
    //   2260: aload 5
    //   2262: ldc_w 536
    //   2265: iconst_2
    //   2266: anewarray 4	java/lang/Object
    //   2269: dup
    //   2270: iconst_0
    //   2271: aload_3
    //   2272: aastore
    //   2273: dup
    //   2274: iconst_1
    //   2275: aload 21
    //   2277: invokevirtual 497	com/tencent/mm/storage/bl$a:getDisplayName	()Ljava/lang/String;
    //   2280: aastore
    //   2281: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2284: astore 18
    //   2286: aload 6
    //   2288: aload 5
    //   2290: ldc_w 536
    //   2293: iconst_2
    //   2294: anewarray 4	java/lang/Object
    //   2297: dup
    //   2298: iconst_0
    //   2299: ldc_w 535
    //   2302: aastore
    //   2303: dup
    //   2304: iconst_1
    //   2305: aload 21
    //   2307: invokevirtual 497	com/tencent/mm/storage/bl$a:getDisplayName	()Ljava/lang/String;
    //   2310: aastore
    //   2311: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2314: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2317: aload 7
    //   2319: aload_0
    //   2320: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2323: ldc 26
    //   2325: astore_3
    //   2326: aconst_null
    //   2327: astore 21
    //   2329: iconst_0
    //   2330: istore 13
    //   2332: aload 18
    //   2334: astore_0
    //   2335: aload 21
    //   2337: astore 18
    //   2339: goto -1504 -> 835
    //   2342: aload_3
    //   2343: astore_0
    //   2344: aload_3
    //   2345: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2348: invokevirtual 46	java/lang/String:length	()I
    //   2351: ifle -1525 -> 826
    //   2354: aload_2
    //   2355: invokestatic 385	com/tencent/mm/model/w:pF	(Ljava/lang/String;)Z
    //   2358: ifeq +6676 -> 9034
    //   2361: aload_3
    //   2362: invokestatic 393	com/tencent/mm/model/bi:uc	(Ljava/lang/String;)I
    //   2365: istore 13
    //   2367: iload 13
    //   2369: iconst_m1
    //   2370: if_icmpeq +6659 -> 9029
    //   2373: aload_3
    //   2374: iconst_0
    //   2375: iload 13
    //   2377: invokevirtual 131	java/lang/String:substring	(II)Ljava/lang/String;
    //   2380: invokevirtual 324	java/lang/String:trim	()Ljava/lang/String;
    //   2383: astore_0
    //   2384: aload_3
    //   2385: invokestatic 539	com/tencent/mm/model/bi:ug	(Ljava/lang/String;)Ljava/lang/String;
    //   2388: pop
    //   2389: iload_1
    //   2390: iconst_1
    //   2391: if_icmpne +30 -> 2421
    //   2394: aload 5
    //   2396: ldc_w 540
    //   2399: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2402: astore_0
    //   2403: aload 6
    //   2405: aload_0
    //   2406: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2409: ldc 26
    //   2411: astore_3
    //   2412: aconst_null
    //   2413: astore 18
    //   2415: iconst_0
    //   2416: istore 13
    //   2418: goto -1583 -> 835
    //   2421: aload 5
    //   2423: ldc_w 540
    //   2426: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2429: astore 18
    //   2431: aload 6
    //   2433: aload 5
    //   2435: ldc_w 540
    //   2438: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2441: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2444: aload 7
    //   2446: aload_0
    //   2447: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2450: ldc 26
    //   2452: astore_3
    //   2453: aconst_null
    //   2454: astore 21
    //   2456: iconst_0
    //   2457: istore 13
    //   2459: aload 18
    //   2461: astore_0
    //   2462: aload 21
    //   2464: astore 18
    //   2466: goto -1631 -> 835
    //   2469: aload 21
    //   2471: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   2474: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   2477: astore_0
    //   2478: aload_0
    //   2479: getfield 552	com/tencent/mm/ai/k$b:gHD	I
    //   2482: ifeq +88 -> 2570
    //   2485: aload_0
    //   2486: getfield 552	com/tencent/mm/ai/k$b:gHD	I
    //   2489: iconst_1
    //   2490: if_icmpne +40 -> 2530
    //   2493: aload 5
    //   2495: ldc_w 553
    //   2498: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2501: astore_0
    //   2502: aload 7
    //   2504: aload 19
    //   2506: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2509: aload 6
    //   2511: ldc 26
    //   2513: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2516: aload_0
    //   2517: astore_3
    //   2518: aconst_null
    //   2519: astore 18
    //   2521: iconst_0
    //   2522: istore 13
    //   2524: ldc 26
    //   2526: astore_0
    //   2527: goto -1692 -> 835
    //   2530: aload_0
    //   2531: getfield 552	com/tencent/mm/ai/k$b:gHD	I
    //   2534: iconst_2
    //   2535: if_icmpne +15 -> 2550
    //   2538: aload 5
    //   2540: ldc_w 554
    //   2543: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2546: astore_0
    //   2547: goto -45 -> 2502
    //   2550: aload_0
    //   2551: getfield 552	com/tencent/mm/ai/k$b:gHD	I
    //   2554: iconst_3
    //   2555: if_icmpne +15 -> 2570
    //   2558: aload 5
    //   2560: ldc_w 555
    //   2563: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2566: astore_0
    //   2567: goto -65 -> 2502
    //   2570: aload 5
    //   2572: ldc_w 556
    //   2575: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2578: astore_0
    //   2579: goto -77 -> 2502
    //   2582: aload 21
    //   2584: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   2587: astore 18
    //   2589: ldc 26
    //   2591: astore_3
    //   2592: ldc 26
    //   2594: astore_0
    //   2595: aload 18
    //   2597: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   2600: astore 18
    //   2602: aload 18
    //   2604: ifnull +46 -> 2650
    //   2607: aload 6
    //   2609: new 152	java/lang/StringBuilder
    //   2612: dup
    //   2613: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   2616: aload 5
    //   2618: ldc_w 557
    //   2621: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2624: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2627: aload 18
    //   2629: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   2632: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2635: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2638: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2641: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2644: aload 6
    //   2646: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2649: astore_0
    //   2650: aload 7
    //   2652: aload 19
    //   2654: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2657: aconst_null
    //   2658: astore 18
    //   2660: iconst_0
    //   2661: istore 13
    //   2663: goto -1828 -> 835
    //   2666: aload 21
    //   2668: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   2671: astore 18
    //   2673: ldc 26
    //   2675: astore_3
    //   2676: ldc 26
    //   2678: astore_0
    //   2679: aload 18
    //   2681: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   2684: astore 18
    //   2686: aload 18
    //   2688: ifnull +67 -> 2755
    //   2691: iload_1
    //   2692: iconst_1
    //   2693: if_icmpne +78 -> 2771
    //   2696: iconst_1
    //   2697: istore 13
    //   2699: aload 18
    //   2701: getfield 563	com/tencent/mm/ai/k$b:gIk	I
    //   2704: tableswitch	default:+32 -> 2736, 1:+73->2777, 2:+32->2736, 3:+110->2814, 4:+147->2851
    //   2737: iconst_3
    //   2738: aload 18
    //   2740: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   2743: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2746: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2749: aload 6
    //   2751: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2754: astore_0
    //   2755: aload 7
    //   2757: aload 19
    //   2759: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2762: aconst_null
    //   2763: astore 18
    //   2765: iconst_0
    //   2766: istore 13
    //   2768: goto -1933 -> 835
    //   2771: iconst_0
    //   2772: istore 13
    //   2774: goto -75 -> 2699
    //   2777: iload 13
    //   2779: ifeq +19 -> 2798
    //   2782: aload 6
    //   2784: aload 5
    //   2786: ldc_w 564
    //   2789: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2792: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2795: goto -46 -> 2749
    //   2798: aload 6
    //   2800: aload 5
    //   2802: ldc_w 565
    //   2805: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2808: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2811: goto -62 -> 2749
    //   2814: iload 13
    //   2816: ifeq +19 -> 2835
    //   2819: aload 6
    //   2821: aload 5
    //   2823: ldc_w 566
    //   2826: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2829: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2832: goto -83 -> 2749
    //   2835: aload 6
    //   2837: aload 5
    //   2839: ldc_w 567
    //   2842: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2845: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2848: goto -99 -> 2749
    //   2851: iload 13
    //   2853: ifeq +19 -> 2872
    //   2856: aload 6
    //   2858: aload 5
    //   2860: ldc_w 568
    //   2863: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2866: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2869: goto -120 -> 2749
    //   2872: aload 6
    //   2874: aload 5
    //   2876: ldc_w 569
    //   2879: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2882: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2885: goto -136 -> 2749
    //   2888: aload 21
    //   2890: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   2893: astore_0
    //   2894: ldc 26
    //   2896: astore 21
    //   2898: ldc 26
    //   2900: astore_3
    //   2901: aload_0
    //   2902: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   2905: astore_0
    //   2906: aload_0
    //   2907: ifnull +60 -> 2967
    //   2910: iload_1
    //   2911: iconst_1
    //   2912: if_icmpne +92 -> 3004
    //   2915: iconst_1
    //   2916: istore 13
    //   2918: iload 13
    //   2920: ifeq +90 -> 3010
    //   2923: aload 6
    //   2925: new 152	java/lang/StringBuilder
    //   2928: dup
    //   2929: ldc_w 571
    //   2932: invokespecial 572	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2935: aload_0
    //   2936: getfield 575	com/tencent/mm/ai/k$b:gIL	Ljava/lang/String;
    //   2939: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2942: ldc_w 577
    //   2945: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2948: aload_0
    //   2949: getfield 580	com/tencent/mm/ai/k$b:gII	Ljava/lang/String;
    //   2952: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2955: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2958: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2961: aload 6
    //   2963: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2966: astore_3
    //   2967: aload_3
    //   2968: astore_0
    //   2969: aload_2
    //   2970: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   2973: ifne +6018 -> 8991
    //   2976: aload_3
    //   2977: astore_0
    //   2978: iload 14
    //   2980: ifne +6011 -> 8991
    //   2983: aload 7
    //   2985: aload 19
    //   2987: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2990: aconst_null
    //   2991: astore 18
    //   2993: iconst_0
    //   2994: istore 13
    //   2996: aload_3
    //   2997: astore_0
    //   2998: aload 21
    //   3000: astore_3
    //   3001: goto -2166 -> 835
    //   3004: iconst_0
    //   3005: istore 13
    //   3007: goto -89 -> 2918
    //   3010: aload 20
    //   3012: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   3015: ifne +55 -> 3070
    //   3018: aload 6
    //   3020: new 152	java/lang/StringBuilder
    //   3023: dup
    //   3024: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3027: aload 20
    //   3029: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   3032: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3035: ldc_w 582
    //   3038: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3041: aload_0
    //   3042: getfield 575	com/tencent/mm/ai/k$b:gIL	Ljava/lang/String;
    //   3045: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3048: ldc_w 577
    //   3051: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3054: aload_0
    //   3055: getfield 585	com/tencent/mm/ai/k$b:gIH	Ljava/lang/String;
    //   3058: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3061: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3064: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3067: goto -106 -> 2961
    //   3070: aload 6
    //   3072: new 152	java/lang/StringBuilder
    //   3075: dup
    //   3076: ldc_w 571
    //   3079: invokespecial 572	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3082: aload_0
    //   3083: getfield 575	com/tencent/mm/ai/k$b:gIL	Ljava/lang/String;
    //   3086: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3089: ldc_w 577
    //   3092: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3095: aload_0
    //   3096: getfield 585	com/tencent/mm/ai/k$b:gIH	Ljava/lang/String;
    //   3099: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3102: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3105: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3108: goto -147 -> 2961
    //   3111: aload 21
    //   3113: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   3116: astore 18
    //   3118: ldc 26
    //   3120: astore_3
    //   3121: ldc 26
    //   3123: astore_0
    //   3124: aload 18
    //   3126: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   3129: astore 18
    //   3131: aload 18
    //   3133: ifnull +5858 -> 8991
    //   3136: aload 18
    //   3138: ldc_w 587
    //   3141: invokevirtual 591	com/tencent/mm/ai/k$b:ao	(Ljava/lang/Class;)Lcom/tencent/mm/ai/f;
    //   3144: checkcast 587	com/tencent/mm/ai/b
    //   3147: astore_0
    //   3148: iload_1
    //   3149: iconst_1
    //   3150: if_icmpne +57 -> 3207
    //   3153: iconst_1
    //   3154: istore 13
    //   3156: iload 13
    //   3158: ifeq +55 -> 3213
    //   3161: aload 6
    //   3163: aload 5
    //   3165: ldc_w 592
    //   3168: iconst_1
    //   3169: anewarray 4	java/lang/Object
    //   3172: dup
    //   3173: iconst_0
    //   3174: aload_0
    //   3175: getfield 595	com/tencent/mm/ai/b:gGc	Ljava/lang/String;
    //   3178: aastore
    //   3179: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3182: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3185: aload 6
    //   3187: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3190: astore_0
    //   3191: aload 7
    //   3193: aload 19
    //   3195: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3198: aconst_null
    //   3199: astore 18
    //   3201: iconst_0
    //   3202: istore 13
    //   3204: goto -2369 -> 835
    //   3207: iconst_0
    //   3208: istore 13
    //   3210: goto -54 -> 3156
    //   3213: aload 6
    //   3215: aload 5
    //   3217: ldc_w 592
    //   3220: iconst_1
    //   3221: anewarray 4	java/lang/Object
    //   3224: dup
    //   3225: iconst_0
    //   3226: aload_0
    //   3227: getfield 598	com/tencent/mm/ai/b:gGd	Ljava/lang/String;
    //   3230: aastore
    //   3231: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3234: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3237: goto -52 -> 3185
    //   3240: aload 21
    //   3242: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   3245: astore_3
    //   3246: ldc 26
    //   3248: astore_0
    //   3249: aload_3
    //   3250: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   3253: astore_3
    //   3254: aload_3
    //   3255: ifnull +42 -> 3297
    //   3258: aload_3
    //   3259: ldc_w 600
    //   3262: invokevirtual 591	com/tencent/mm/ai/k$b:ao	(Ljava/lang/Class;)Lcom/tencent/mm/ai/f;
    //   3265: checkcast 600	com/tencent/mm/ui/chatting/viewitems/k$a
    //   3268: astore_0
    //   3269: aload_0
    //   3270: getfield 603	com/tencent/mm/ui/chatting/viewitems/k$a:state	I
    //   3273: iconst_1
    //   3274: if_icmpne +41 -> 3315
    //   3277: aload 5
    //   3279: ldc_w 604
    //   3282: iconst_1
    //   3283: anewarray 4	java/lang/Object
    //   3286: dup
    //   3287: iconst_0
    //   3288: aload_0
    //   3289: getfield 607	com/tencent/mm/ui/chatting/viewitems/k$a:appName	Ljava/lang/String;
    //   3292: aastore
    //   3293: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3296: astore_0
    //   3297: aload 6
    //   3299: aload_0
    //   3300: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3303: ldc 26
    //   3305: astore_3
    //   3306: aconst_null
    //   3307: astore 18
    //   3309: iconst_0
    //   3310: istore 13
    //   3312: goto -2477 -> 835
    //   3315: aload 5
    //   3317: ldc_w 608
    //   3320: iconst_1
    //   3321: anewarray 4	java/lang/Object
    //   3324: dup
    //   3325: iconst_0
    //   3326: aload_0
    //   3327: getfield 607	com/tencent/mm/ui/chatting/viewitems/k$a:appName	Ljava/lang/String;
    //   3330: aastore
    //   3331: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3334: astore_0
    //   3335: goto -38 -> 3297
    //   3338: aload 21
    //   3340: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   3343: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   3346: getfield 552	com/tencent/mm/ai/k$b:gHD	I
    //   3349: lookupswitch	default:+27->3376, 10000:+109->3458, 20000:+121->3470
    //   3377: iconst_2
    //   3378: ldc_w 609
    //   3381: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   3384: astore_0
    //   3385: aload 19
    //   3387: invokevirtual 46	java/lang/String:length	()I
    //   3390: ifle +92 -> 3482
    //   3393: new 152	java/lang/StringBuilder
    //   3396: dup
    //   3397: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3400: aload 19
    //   3402: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3405: ldc_w 427
    //   3408: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3411: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3414: astore_3
    //   3415: aload_2
    //   3416: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   3419: ifne +15 -> 3434
    //   3422: iload 14
    //   3424: ifne +10 -> 3434
    //   3427: aload 7
    //   3429: aload 19
    //   3431: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3434: aload 6
    //   3436: ldc 26
    //   3438: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3441: aload_0
    //   3442: astore 21
    //   3444: aconst_null
    //   3445: astore 18
    //   3447: iconst_0
    //   3448: istore 13
    //   3450: aload_3
    //   3451: astore_0
    //   3452: aload 21
    //   3454: astore_3
    //   3455: goto -2620 -> 835
    //   3458: aload 5
    //   3460: ldc_w 610
    //   3463: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   3466: astore_0
    //   3467: goto -82 -> 3385
    //   3470: aload 5
    //   3472: ldc_w 611
    //   3475: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   3478: astore_0
    //   3479: goto -94 -> 3385
    //   3482: ldc 26
    //   3484: astore_3
    //   3485: goto -70 -> 3415
    //   3488: aload 21
    //   3490: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   3493: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   3496: astore_3
    //   3497: aload_3
    //   3498: ifnonnull +21 -> 3519
    //   3501: ldc_w 613
    //   3504: ldc_w 615
    //   3507: invokestatic 621	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3510: ldc_w 360
    //   3513: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3516: ldc 26
    //   3518: areturn
    //   3519: ldc 26
    //   3521: astore 21
    //   3523: aload 5
    //   3525: ldc_w 622
    //   3528: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   3531: astore 18
    //   3533: aload 19
    //   3535: invokevirtual 46	java/lang/String:length	()I
    //   3538: ifle +108 -> 3646
    //   3541: new 152	java/lang/StringBuilder
    //   3544: dup
    //   3545: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3548: aload 19
    //   3550: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3553: ldc_w 427
    //   3556: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3559: aload 18
    //   3561: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3564: aload_3
    //   3565: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   3568: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3571: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3574: astore_0
    //   3575: aload_2
    //   3576: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   3579: ifne +15 -> 3594
    //   3582: iload 14
    //   3584: ifne +10 -> 3594
    //   3587: aload 7
    //   3589: aload 19
    //   3591: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3594: aload 19
    //   3596: invokevirtual 46	java/lang/String:length	()I
    //   3599: ifle +73 -> 3672
    //   3602: new 152	java/lang/StringBuilder
    //   3605: dup
    //   3606: ldc_w 429
    //   3609: invokespecial 572	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3612: aload 18
    //   3614: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3617: aload_3
    //   3618: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   3621: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3624: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3627: astore_3
    //   3628: aload 6
    //   3630: aload_3
    //   3631: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3634: aconst_null
    //   3635: astore 18
    //   3637: iconst_0
    //   3638: istore 13
    //   3640: aload 21
    //   3642: astore_3
    //   3643: goto -2808 -> 835
    //   3646: new 152	java/lang/StringBuilder
    //   3649: dup
    //   3650: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3653: aload 18
    //   3655: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3658: aload_3
    //   3659: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   3662: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3665: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3668: astore_0
    //   3669: goto -94 -> 3575
    //   3672: new 152	java/lang/StringBuilder
    //   3675: dup
    //   3676: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3679: aload 18
    //   3681: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3684: aload_3
    //   3685: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   3688: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3691: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3694: astore_3
    //   3695: goto -67 -> 3628
    //   3698: aload 21
    //   3700: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   3703: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   3706: astore_0
    //   3707: aload_0
    //   3708: ifnonnull +21 -> 3729
    //   3711: ldc_w 613
    //   3714: ldc_w 615
    //   3717: invokestatic 621	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3720: ldc_w 360
    //   3723: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3726: ldc 26
    //   3728: areturn
    //   3729: ldc 26
    //   3731: astore 21
    //   3733: aload 5
    //   3735: ldc_w 622
    //   3738: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   3741: astore_3
    //   3742: iload_1
    //   3743: iconst_1
    //   3744: if_icmpne +95 -> 3839
    //   3747: new 152	java/lang/StringBuilder
    //   3750: dup
    //   3751: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3754: aload_3
    //   3755: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3758: aload_0
    //   3759: getfield 625	com/tencent/mm/ai/k$b:gIy	Ljava/lang/String;
    //   3762: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3765: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3768: astore_3
    //   3769: aload 19
    //   3771: invokevirtual 46	java/lang/String:length	()I
    //   3774: ifle +57 -> 3831
    //   3777: ldc_w 429
    //   3780: aload_3
    //   3781: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3784: invokevirtual 631	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   3787: astore_0
    //   3788: aload 6
    //   3790: aload_0
    //   3791: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3794: aload_3
    //   3795: astore_0
    //   3796: aload_2
    //   3797: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   3800: ifne +5191 -> 8991
    //   3803: aload_3
    //   3804: astore_0
    //   3805: iload 14
    //   3807: ifne +5184 -> 8991
    //   3810: aload 7
    //   3812: aload 19
    //   3814: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3817: aconst_null
    //   3818: astore 18
    //   3820: iconst_0
    //   3821: istore 13
    //   3823: aload_3
    //   3824: astore_0
    //   3825: aload 21
    //   3827: astore_3
    //   3828: goto -2993 -> 835
    //   3831: aload_3
    //   3832: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3835: astore_0
    //   3836: goto -48 -> 3788
    //   3839: new 152	java/lang/StringBuilder
    //   3842: dup
    //   3843: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3846: aload_3
    //   3847: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3850: aload_0
    //   3851: getfield 634	com/tencent/mm/ai/k$b:gIx	Ljava/lang/String;
    //   3854: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3857: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3860: astore_3
    //   3861: aload 19
    //   3863: invokevirtual 46	java/lang/String:length	()I
    //   3866: ifle +23 -> 3889
    //   3869: ldc_w 429
    //   3872: aload_3
    //   3873: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3876: invokevirtual 631	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   3879: astore_0
    //   3880: aload 6
    //   3882: aload_0
    //   3883: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3886: goto -92 -> 3794
    //   3889: aload_3
    //   3890: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3893: astore_0
    //   3894: goto -14 -> 3880
    //   3897: aload 21
    //   3899: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   3902: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   3905: astore_3
    //   3906: aload_3
    //   3907: ifnonnull +21 -> 3928
    //   3910: ldc_w 613
    //   3913: ldc_w 615
    //   3916: invokestatic 621	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3919: ldc_w 360
    //   3922: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3925: ldc 26
    //   3927: areturn
    //   3928: ldc 26
    //   3930: astore 21
    //   3932: aload 19
    //   3934: invokevirtual 46	java/lang/String:length	()I
    //   3937: ifle +98 -> 4035
    //   3940: new 152	java/lang/StringBuilder
    //   3943: dup
    //   3944: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3947: aload 19
    //   3949: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3952: ldc_w 427
    //   3955: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3958: aload_3
    //   3959: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   3962: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3965: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3968: astore_0
    //   3969: aload_2
    //   3970: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   3973: ifne +15 -> 3988
    //   3976: iload 14
    //   3978: ifne +10 -> 3988
    //   3981: aload 7
    //   3983: aload 19
    //   3985: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3988: aload 19
    //   3990: invokevirtual 46	java/lang/String:length	()I
    //   3993: ifle +50 -> 4043
    //   3996: new 152	java/lang/StringBuilder
    //   3999: dup
    //   4000: ldc_w 429
    //   4003: invokespecial 572	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4006: aload_3
    //   4007: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   4010: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4013: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4016: astore_3
    //   4017: aload 6
    //   4019: aload_3
    //   4020: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4023: aconst_null
    //   4024: astore 18
    //   4026: iconst_0
    //   4027: istore 13
    //   4029: aload 21
    //   4031: astore_3
    //   4032: goto -3197 -> 835
    //   4035: aload_3
    //   4036: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   4039: astore_0
    //   4040: goto -71 -> 3969
    //   4043: aload_3
    //   4044: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   4047: astore_3
    //   4048: goto -31 -> 4017
    //   4051: aload 5
    //   4053: ldc_w 635
    //   4056: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   4059: astore 21
    //   4061: aload 19
    //   4063: invokevirtual 46	java/lang/String:length	()I
    //   4066: ifle +74 -> 4140
    //   4069: new 152	java/lang/StringBuilder
    //   4072: dup
    //   4073: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   4076: aload 19
    //   4078: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4081: ldc_w 427
    //   4084: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4087: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4090: astore_0
    //   4091: aload_2
    //   4092: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   4095: ifne +15 -> 4110
    //   4098: iload 14
    //   4100: ifne +10 -> 4110
    //   4103: aload 7
    //   4105: aload 19
    //   4107: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4110: aload 19
    //   4112: invokevirtual 46	java/lang/String:length	()I
    //   4115: ifle +31 -> 4146
    //   4118: ldc_w 429
    //   4121: astore_3
    //   4122: aload 6
    //   4124: aload_3
    //   4125: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4128: aconst_null
    //   4129: astore 18
    //   4131: iconst_0
    //   4132: istore 13
    //   4134: aload 21
    //   4136: astore_3
    //   4137: goto -3302 -> 835
    //   4140: ldc 26
    //   4142: astore_0
    //   4143: goto -52 -> 4091
    //   4146: ldc 26
    //   4148: astore_3
    //   4149: goto -27 -> 4122
    //   4152: aload 21
    //   4154: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   4157: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   4160: astore_0
    //   4161: aload_0
    //   4162: ifnonnull +21 -> 4183
    //   4165: ldc_w 613
    //   4168: ldc_w 615
    //   4171: invokestatic 621	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4174: ldc_w 360
    //   4177: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4180: ldc 26
    //   4182: areturn
    //   4183: ldc 26
    //   4185: astore 21
    //   4187: aload_0
    //   4188: getfield 638	com/tencent/mm/ai/k$b:content	Ljava/lang/String;
    //   4191: ldc_w 640
    //   4194: invokestatic 645	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4197: astore_0
    //   4198: aload_0
    //   4199: astore_3
    //   4200: aload_0
    //   4201: invokestatic 204	com/tencent/mm/pluginsdk/ui/span/k:aCn	(Ljava/lang/String;)Ljava/lang/String;
    //   4204: astore_0
    //   4205: aload_2
    //   4206: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   4209: ifne +15 -> 4224
    //   4212: iload 14
    //   4214: ifne +10 -> 4224
    //   4217: aload 7
    //   4219: aload 19
    //   4221: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4224: aload 19
    //   4226: invokevirtual 46	java/lang/String:length	()I
    //   4229: ifle +53 -> 4282
    //   4232: ldc_w 429
    //   4235: aload_0
    //   4236: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4239: invokevirtual 631	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4242: astore_3
    //   4243: aload 6
    //   4245: aload_3
    //   4246: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4249: aconst_null
    //   4250: astore 18
    //   4252: iconst_0
    //   4253: istore 13
    //   4255: aload 21
    //   4257: astore_3
    //   4258: goto -3423 -> 835
    //   4261: astore 18
    //   4263: aload_3
    //   4264: astore_0
    //   4265: ldc_w 613
    //   4268: aload 18
    //   4270: ldc 26
    //   4272: iconst_0
    //   4273: anewarray 4	java/lang/Object
    //   4276: invokestatic 649	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4279: goto -74 -> 4205
    //   4282: aload_0
    //   4283: astore_3
    //   4284: goto -41 -> 4243
    //   4287: ldc 26
    //   4289: astore 22
    //   4291: aload 21
    //   4293: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   4296: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   4299: astore_3
    //   4300: aload_3
    //   4301: ifnonnull +21 -> 4322
    //   4304: ldc_w 613
    //   4307: ldc_w 615
    //   4310: invokestatic 621	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4313: ldc_w 360
    //   4316: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4319: ldc 26
    //   4321: areturn
    //   4322: aload_2
    //   4323: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   4326: ifne +15 -> 4341
    //   4329: iload 14
    //   4331: ifne +10 -> 4341
    //   4334: aload 7
    //   4336: aload 19
    //   4338: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4341: aload 5
    //   4343: ldc_w 650
    //   4346: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   4349: astore_0
    //   4350: aload_3
    //   4351: ldc_w 652
    //   4354: invokevirtual 591	com/tencent/mm/ai/k$b:ao	(Ljava/lang/Class;)Lcom/tencent/mm/ai/f;
    //   4357: checkcast 652	com/tencent/mm/plugin/i/a/b
    //   4360: astore_3
    //   4361: aload_3
    //   4362: ifnull +4664 -> 9026
    //   4365: aload_3
    //   4366: invokevirtual 656	com/tencent/mm/plugin/i/a/b:cty	()Lcom/tencent/mm/protocal/protobuf/ald;
    //   4369: getfield 661	com/tencent/mm/protocal/protobuf/ald:nickname	Ljava/lang/String;
    //   4372: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   4375: ifne +4651 -> 9026
    //   4378: new 152	java/lang/StringBuilder
    //   4381: dup
    //   4382: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   4385: aload_0
    //   4386: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4389: aload 5
    //   4391: ldc_w 662
    //   4394: iconst_1
    //   4395: anewarray 4	java/lang/Object
    //   4398: dup
    //   4399: iconst_0
    //   4400: aload_3
    //   4401: invokevirtual 656	com/tencent/mm/plugin/i/a/b:cty	()Lcom/tencent/mm/protocal/protobuf/ald;
    //   4404: getfield 661	com/tencent/mm/protocal/protobuf/ald:nickname	Ljava/lang/String;
    //   4407: aastore
    //   4408: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   4411: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4414: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4417: astore_0
    //   4418: aload 19
    //   4420: invokevirtual 46	java/lang/String:length	()I
    //   4423: ifle +32 -> 4455
    //   4426: ldc_w 429
    //   4429: aload_0
    //   4430: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4433: invokevirtual 631	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4436: astore_3
    //   4437: aload 6
    //   4439: aload_3
    //   4440: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4443: aconst_null
    //   4444: astore 18
    //   4446: iconst_0
    //   4447: istore 13
    //   4449: aload 22
    //   4451: astore_3
    //   4452: goto -3617 -> 835
    //   4455: aload_0
    //   4456: astore_3
    //   4457: goto -20 -> 4437
    //   4460: ldc 26
    //   4462: astore 22
    //   4464: aload 21
    //   4466: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   4469: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   4472: astore_3
    //   4473: aload_3
    //   4474: ifnonnull +21 -> 4495
    //   4477: ldc_w 613
    //   4480: ldc_w 615
    //   4483: invokestatic 621	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4486: ldc_w 360
    //   4489: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4492: ldc 26
    //   4494: areturn
    //   4495: aload_2
    //   4496: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   4499: ifne +15 -> 4514
    //   4502: iload 14
    //   4504: ifne +10 -> 4514
    //   4507: aload 7
    //   4509: aload 19
    //   4511: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4514: aload 5
    //   4516: ldc_w 650
    //   4519: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   4522: astore_0
    //   4523: aload_3
    //   4524: ldc_w 664
    //   4527: invokevirtual 591	com/tencent/mm/ai/k$b:ao	(Ljava/lang/Class;)Lcom/tencent/mm/ai/f;
    //   4530: checkcast 664	com/tencent/mm/plugin/i/a/c
    //   4533: astore_3
    //   4534: aload_3
    //   4535: ifnull +4488 -> 9023
    //   4538: aload_3
    //   4539: invokevirtual 668	com/tencent/mm/plugin/i/a/c:ctz	()Lcom/tencent/mm/protocal/protobuf/ale;
    //   4542: getfield 673	com/tencent/mm/protocal/protobuf/ale:dqA	Ljava/lang/String;
    //   4545: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   4548: ifne +4475 -> 9023
    //   4551: aload_3
    //   4552: invokevirtual 668	com/tencent/mm/plugin/i/a/c:ctz	()Lcom/tencent/mm/protocal/protobuf/ale;
    //   4555: getfield 676	com/tencent/mm/protocal/protobuf/ale:qSS	I
    //   4558: iconst_1
    //   4559: if_icmpne +81 -> 4640
    //   4562: new 152	java/lang/StringBuilder
    //   4565: dup
    //   4566: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   4569: aload_0
    //   4570: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4573: invokestatic 61	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   4576: ldc_w 677
    //   4579: iconst_1
    //   4580: anewarray 4	java/lang/Object
    //   4583: dup
    //   4584: iconst_0
    //   4585: aload_3
    //   4586: invokevirtual 668	com/tencent/mm/plugin/i/a/c:ctz	()Lcom/tencent/mm/protocal/protobuf/ale;
    //   4589: getfield 673	com/tencent/mm/protocal/protobuf/ale:dqA	Ljava/lang/String;
    //   4592: aastore
    //   4593: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   4596: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4599: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4602: astore_0
    //   4603: aload 19
    //   4605: invokevirtual 46	java/lang/String:length	()I
    //   4608: ifle +60 -> 4668
    //   4611: ldc_w 429
    //   4614: aload_0
    //   4615: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4618: invokevirtual 631	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4621: astore_3
    //   4622: aload 6
    //   4624: aload_3
    //   4625: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4628: aconst_null
    //   4629: astore 18
    //   4631: iconst_0
    //   4632: istore 13
    //   4634: aload 22
    //   4636: astore_3
    //   4637: goto -3802 -> 835
    //   4640: new 152	java/lang/StringBuilder
    //   4643: dup
    //   4644: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   4647: aload_0
    //   4648: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4651: aload_3
    //   4652: invokevirtual 668	com/tencent/mm/plugin/i/a/c:ctz	()Lcom/tencent/mm/protocal/protobuf/ale;
    //   4655: getfield 673	com/tencent/mm/protocal/protobuf/ale:dqA	Ljava/lang/String;
    //   4658: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4661: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4664: astore_0
    //   4665: goto -62 -> 4603
    //   4668: aload_0
    //   4669: astore_3
    //   4670: goto -48 -> 4622
    //   4673: ldc 26
    //   4675: astore 22
    //   4677: aload 21
    //   4679: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   4682: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   4685: astore_0
    //   4686: aload_0
    //   4687: ifnonnull +21 -> 4708
    //   4690: ldc_w 613
    //   4693: ldc_w 615
    //   4696: invokestatic 621	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4699: ldc_w 360
    //   4702: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4705: ldc 26
    //   4707: areturn
    //   4708: aload_0
    //   4709: ldc_w 679
    //   4712: invokevirtual 591	com/tencent/mm/ai/k$b:ao	(Ljava/lang/Class;)Lcom/tencent/mm/ai/f;
    //   4715: checkcast 679	com/tencent/mm/plugin/i/a/a
    //   4718: astore_0
    //   4719: aload_0
    //   4720: ifnull +4297 -> 9017
    //   4723: aload_0
    //   4724: invokevirtual 682	com/tencent/mm/plugin/i/a/a:Su	()Ljava/lang/String;
    //   4727: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   4730: ifne +4287 -> 9017
    //   4733: iload_1
    //   4734: iconst_1
    //   4735: if_icmpne +60 -> 4795
    //   4738: aload 5
    //   4740: ldc_w 683
    //   4743: iconst_1
    //   4744: anewarray 4	java/lang/Object
    //   4747: dup
    //   4748: iconst_0
    //   4749: aload_0
    //   4750: invokevirtual 682	com/tencent/mm/plugin/i/a/a:Su	()Ljava/lang/String;
    //   4753: aastore
    //   4754: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   4757: astore_0
    //   4758: aload 19
    //   4760: invokevirtual 46	java/lang/String:length	()I
    //   4763: ifle +80 -> 4843
    //   4766: ldc_w 429
    //   4769: aload_0
    //   4770: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4773: invokevirtual 631	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4776: astore_3
    //   4777: aload 6
    //   4779: aload_3
    //   4780: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4783: aconst_null
    //   4784: astore 18
    //   4786: iconst_0
    //   4787: istore 13
    //   4789: aload 22
    //   4791: astore_3
    //   4792: goto -3957 -> 835
    //   4795: aload 5
    //   4797: ldc_w 684
    //   4800: iconst_1
    //   4801: anewarray 4	java/lang/Object
    //   4804: dup
    //   4805: iconst_0
    //   4806: aload_0
    //   4807: invokevirtual 682	com/tencent/mm/plugin/i/a/a:Su	()Ljava/lang/String;
    //   4810: aastore
    //   4811: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   4814: astore_3
    //   4815: aload_3
    //   4816: astore_0
    //   4817: aload_2
    //   4818: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   4821: ifne -63 -> 4758
    //   4824: aload_3
    //   4825: astore_0
    //   4826: iload 14
    //   4828: ifne -70 -> 4758
    //   4831: aload 7
    //   4833: aload 19
    //   4835: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4838: aload_3
    //   4839: astore_0
    //   4840: goto -82 -> 4758
    //   4843: aload_0
    //   4844: astore_3
    //   4845: goto -68 -> 4777
    //   4848: new 152	java/lang/StringBuilder
    //   4851: dup
    //   4852: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   4855: aload 5
    //   4857: ldc_w 685
    //   4860: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   4863: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4866: aload 5
    //   4868: ldc_w 686
    //   4871: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   4874: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4877: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4880: astore_0
    //   4881: aload 6
    //   4883: aload_0
    //   4884: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4887: ldc 26
    //   4889: astore_3
    //   4890: aconst_null
    //   4891: astore 18
    //   4893: iconst_0
    //   4894: istore 13
    //   4896: goto -4061 -> 835
    //   4899: ldc 26
    //   4901: astore 21
    //   4903: ldc_w 688
    //   4906: invokestatic 296	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   4909: checkcast 688	com/tencent/mm/plugin/messenger/a/c
    //   4912: aload_3
    //   4913: invokeinterface 692 2 0
    //   4918: astore_0
    //   4919: aload_0
    //   4920: getfield 698	com/tencent/mm/protocal/protobuf/byl:tdC	Ljava/util/LinkedList;
    //   4923: invokevirtual 703	java/util/LinkedList:size	()I
    //   4926: ifle +4077 -> 9003
    //   4929: aload 6
    //   4931: ldc_w 688
    //   4934: invokestatic 296	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   4937: checkcast 688	com/tencent/mm/plugin/messenger/a/c
    //   4940: aload_0
    //   4941: getfield 698	com/tencent/mm/protocal/protobuf/byl:tdC	Ljava/util/LinkedList;
    //   4944: invokevirtual 707	java/util/LinkedList:getLast	()Ljava/lang/Object;
    //   4947: checkcast 709	com/tencent/mm/protocal/protobuf/bym
    //   4950: getfield 712	com/tencent/mm/protocal/protobuf/bym:gLo	Ljava/lang/String;
    //   4953: aload_2
    //   4954: invokeinterface 715 3 0
    //   4959: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4962: aconst_null
    //   4963: astore 18
    //   4965: iconst_0
    //   4966: istore 13
    //   4968: aload_3
    //   4969: astore_0
    //   4970: aload 21
    //   4972: astore_3
    //   4973: goto -4138 -> 835
    //   4976: aload 21
    //   4978: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   4981: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   4984: astore_0
    //   4985: aload_0
    //   4986: ifnonnull +21 -> 5007
    //   4989: ldc_w 613
    //   4992: ldc_w 615
    //   4995: invokestatic 621	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4998: ldc_w 360
    //   5001: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5004: ldc 26
    //   5006: areturn
    //   5007: new 152	java/lang/StringBuilder
    //   5010: dup
    //   5011: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   5014: aload 5
    //   5016: ldc_w 716
    //   5019: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   5022: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5025: aload_0
    //   5026: invokevirtual 717	com/tencent/mm/ai/k$b:getTitle	()Ljava/lang/String;
    //   5029: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5032: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5035: astore_0
    //   5036: aload 6
    //   5038: aload_0
    //   5039: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5042: ldc 26
    //   5044: astore_3
    //   5045: aconst_null
    //   5046: astore 18
    //   5048: iconst_0
    //   5049: istore 13
    //   5051: goto -4216 -> 835
    //   5054: aload 21
    //   5056: invokestatic 543	com/tencent/mm/sdk/platformtools/bt:aGg	(Ljava/lang/String;)Ljava/lang/String;
    //   5059: astore_0
    //   5060: aload_0
    //   5061: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   5064: astore 18
    //   5066: aload 18
    //   5068: ifnonnull +21 -> 5089
    //   5071: ldc_w 613
    //   5074: ldc_w 615
    //   5077: invokestatic 621	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5080: ldc_w 360
    //   5083: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5086: ldc 26
    //   5088: areturn
    //   5089: aload 18
    //   5091: getfield 720	com/tencent/mm/ai/k$b:type	I
    //   5094: tableswitch	default:+242 -> 5336, 1:+263->5357, 2:+390->5484, 3:+491->5585, 4:+596->5690, 5:+907->6001, 6:+701->5795, 7:+806->5900, 8:+1449->6543, 9:+242->5336, 10:+242->5336, 11:+242->5336, 12:+242->5336, 13:+242->5336, 14:+242->5336, 15:+1529->6623, 16:+2094->7188, 17:+1689->6783, 18:+242->5336, 19:+1816->6910, 20:+242->5336, 21:+242->5336, 22:+242->5336, 23:+242->5336, 24:+1917->7011, 25:+1609->6703, 26:+1529->6623, 27:+1529->6623, 28:+242->5336, 29:+242->5336, 30:+242->5336, 31:+242->5336, 32:+242->5336, 33:+1040->6134, 34:+2239->7333, 35:+242->5336, 36:+1040->6134, 37:+242->5336, 38:+242->5336, 39:+242->5336, 40:+2409->7503, 41:+242->5336, 42:+242->5336, 43:+242->5336, 44:+1225->6319, 45:+242->5336, 46:+1019->6113, 47:+242->5336, 48:+242->5336, 49:+242->5336, 50:+242->5336, 51:+242->5336, 52:+242->5336, 53:+263->5357, 54:+242->5336, 55:+242->5336, 56:+242->5336, 57:+263->5357
    //   5337: iconst_2
    //   5338: ldc_w 635
    //   5341: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   5344: astore_3
    //   5345: aconst_null
    //   5346: astore 18
    //   5348: iconst_0
    //   5349: istore 13
    //   5351: ldc 26
    //   5353: astore_0
    //   5354: goto -4519 -> 835
    //   5357: ldc 26
    //   5359: astore 21
    //   5361: aload 19
    //   5363: invokevirtual 46	java/lang/String:length	()I
    //   5366: ifle +100 -> 5466
    //   5369: new 152	java/lang/StringBuilder
    //   5372: dup
    //   5373: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   5376: aload 19
    //   5378: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5381: ldc_w 427
    //   5384: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5387: aload 18
    //   5389: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   5392: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5395: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5398: astore_0
    //   5399: aload_2
    //   5400: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   5403: ifne +15 -> 5418
    //   5406: iload 14
    //   5408: ifne +10 -> 5418
    //   5411: aload 7
    //   5413: aload 19
    //   5415: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5418: aload 19
    //   5420: invokevirtual 46	java/lang/String:length	()I
    //   5423: ifle +52 -> 5475
    //   5426: new 152	java/lang/StringBuilder
    //   5429: dup
    //   5430: ldc_w 429
    //   5433: invokespecial 572	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5436: aload 18
    //   5438: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   5441: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5444: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5447: astore_3
    //   5448: aload 6
    //   5450: aload_3
    //   5451: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5454: aconst_null
    //   5455: astore 18
    //   5457: iconst_0
    //   5458: istore 13
    //   5460: aload 21
    //   5462: astore_3
    //   5463: goto -4628 -> 835
    //   5466: aload 18
    //   5468: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   5471: astore_0
    //   5472: goto -73 -> 5399
    //   5475: aload 18
    //   5477: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   5480: astore_3
    //   5481: goto -33 -> 5448
    //   5484: aload 5
    //   5486: ldc_w 425
    //   5489: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   5492: astore 21
    //   5494: aload 19
    //   5496: invokevirtual 46	java/lang/String:length	()I
    //   5499: ifle +74 -> 5573
    //   5502: new 152	java/lang/StringBuilder
    //   5505: dup
    //   5506: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   5509: aload 19
    //   5511: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5514: ldc_w 427
    //   5517: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5520: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5523: astore_0
    //   5524: aload_2
    //   5525: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   5528: ifne +15 -> 5543
    //   5531: iload 14
    //   5533: ifne +10 -> 5543
    //   5536: aload 7
    //   5538: aload 19
    //   5540: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5543: aload 19
    //   5545: invokevirtual 46	java/lang/String:length	()I
    //   5548: ifle +31 -> 5579
    //   5551: ldc_w 429
    //   5554: astore_3
    //   5555: aload 6
    //   5557: aload_3
    //   5558: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5561: aconst_null
    //   5562: astore 18
    //   5564: iconst_0
    //   5565: istore 13
    //   5567: aload 21
    //   5569: astore_3
    //   5570: goto -4735 -> 835
    //   5573: ldc 26
    //   5575: astore_0
    //   5576: goto -52 -> 5524
    //   5579: ldc 26
    //   5581: astore_3
    //   5582: goto -27 -> 5555
    //   5585: aload 5
    //   5587: ldc_w 721
    //   5590: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   5593: astore 21
    //   5595: aload 19
    //   5597: invokevirtual 46	java/lang/String:length	()I
    //   5600: ifle +78 -> 5678
    //   5603: new 152	java/lang/StringBuilder
    //   5606: dup
    //   5607: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   5610: aload 19
    //   5612: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5615: ldc_w 427
    //   5618: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5621: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5624: astore_0
    //   5625: aload_2
    //   5626: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   5629: ifne +15 -> 5644
    //   5632: iload 14
    //   5634: ifne +10 -> 5644
    //   5637: aload 7
    //   5639: aload 19
    //   5641: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5644: aload 19
    //   5646: invokevirtual 46	java/lang/String:length	()I
    //   5649: ifle +35 -> 5684
    //   5652: ldc_w 429
    //   5655: astore_3
    //   5656: aload 6
    //   5658: aload_3
    //   5659: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5662: aload 18
    //   5664: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   5667: astore 18
    //   5669: iconst_1
    //   5670: istore 13
    //   5672: aload 21
    //   5674: astore_3
    //   5675: goto -4840 -> 835
    //   5678: ldc 26
    //   5680: astore_0
    //   5681: goto -56 -> 5625
    //   5684: ldc 26
    //   5686: astore_3
    //   5687: goto -31 -> 5656
    //   5690: aload 5
    //   5692: ldc_w 451
    //   5695: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   5698: astore 21
    //   5700: aload 19
    //   5702: invokevirtual 46	java/lang/String:length	()I
    //   5705: ifle +78 -> 5783
    //   5708: new 152	java/lang/StringBuilder
    //   5711: dup
    //   5712: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   5715: aload 19
    //   5717: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5720: ldc_w 427
    //   5723: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5726: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5729: astore_0
    //   5730: aload_2
    //   5731: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   5734: ifne +15 -> 5749
    //   5737: iload 14
    //   5739: ifne +10 -> 5749
    //   5742: aload 7
    //   5744: aload 19
    //   5746: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5749: aload 19
    //   5751: invokevirtual 46	java/lang/String:length	()I
    //   5754: ifle +35 -> 5789
    //   5757: ldc_w 429
    //   5760: astore_3
    //   5761: aload 6
    //   5763: aload_3
    //   5764: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5767: aload 18
    //   5769: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   5772: astore 18
    //   5774: iconst_1
    //   5775: istore 13
    //   5777: aload 21
    //   5779: astore_3
    //   5780: goto -4945 -> 835
    //   5783: ldc 26
    //   5785: astore_0
    //   5786: goto -56 -> 5730
    //   5789: ldc 26
    //   5791: astore_3
    //   5792: goto -31 -> 5761
    //   5795: aload 5
    //   5797: ldc_w 722
    //   5800: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   5803: astore 21
    //   5805: aload 19
    //   5807: invokevirtual 46	java/lang/String:length	()I
    //   5810: ifle +78 -> 5888
    //   5813: new 152	java/lang/StringBuilder
    //   5816: dup
    //   5817: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   5820: aload 19
    //   5822: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5825: ldc_w 427
    //   5828: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5831: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5834: astore_0
    //   5835: aload_2
    //   5836: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   5839: ifne +15 -> 5854
    //   5842: iload 14
    //   5844: ifne +10 -> 5854
    //   5847: aload 7
    //   5849: aload 19
    //   5851: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5854: aload 19
    //   5856: invokevirtual 46	java/lang/String:length	()I
    //   5859: ifle +35 -> 5894
    //   5862: ldc_w 429
    //   5865: astore_3
    //   5866: aload 6
    //   5868: aload_3
    //   5869: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5872: aload 18
    //   5874: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   5877: astore 18
    //   5879: iconst_1
    //   5880: istore 13
    //   5882: aload 21
    //   5884: astore_3
    //   5885: goto -5050 -> 835
    //   5888: ldc 26
    //   5890: astore_0
    //   5891: goto -56 -> 5835
    //   5894: ldc 26
    //   5896: astore_3
    //   5897: goto -31 -> 5866
    //   5900: aload 5
    //   5902: ldc_w 635
    //   5905: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   5908: astore 21
    //   5910: aload 19
    //   5912: invokevirtual 46	java/lang/String:length	()I
    //   5915: ifle +74 -> 5989
    //   5918: new 152	java/lang/StringBuilder
    //   5921: dup
    //   5922: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   5925: aload 19
    //   5927: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5930: ldc_w 427
    //   5933: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5936: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5939: astore_0
    //   5940: aload_2
    //   5941: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   5944: ifne +15 -> 5959
    //   5947: iload 14
    //   5949: ifne +10 -> 5959
    //   5952: aload 7
    //   5954: aload 19
    //   5956: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5959: aload 19
    //   5961: invokevirtual 46	java/lang/String:length	()I
    //   5964: ifle +31 -> 5995
    //   5967: ldc_w 429
    //   5970: astore_3
    //   5971: aload 6
    //   5973: aload_3
    //   5974: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5977: aconst_null
    //   5978: astore 18
    //   5980: iconst_0
    //   5981: istore 13
    //   5983: aload 21
    //   5985: astore_3
    //   5986: goto -5151 -> 835
    //   5989: ldc 26
    //   5991: astore_0
    //   5992: goto -52 -> 5940
    //   5995: ldc 26
    //   5997: astore_3
    //   5998: goto -27 -> 5971
    //   6001: aload 5
    //   6003: ldc_w 723
    //   6006: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6009: astore 21
    //   6011: aload 19
    //   6013: invokevirtual 46	java/lang/String:length	()I
    //   6016: ifle +85 -> 6101
    //   6019: new 152	java/lang/StringBuilder
    //   6022: dup
    //   6023: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6026: aload 19
    //   6028: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6031: ldc_w 427
    //   6034: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6037: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6040: astore_0
    //   6041: aload_2
    //   6042: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   6045: ifne +22 -> 6067
    //   6048: iload 14
    //   6050: ifne +17 -> 6067
    //   6053: aload_2
    //   6054: invokestatic 404	com/tencent/mm/model/w:tm	(Ljava/lang/String;)Z
    //   6057: ifne +10 -> 6067
    //   6060: aload 7
    //   6062: aload 19
    //   6064: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6067: aload 19
    //   6069: invokevirtual 46	java/lang/String:length	()I
    //   6072: ifle +35 -> 6107
    //   6075: ldc_w 429
    //   6078: astore_3
    //   6079: aload 6
    //   6081: aload_3
    //   6082: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6085: aload 18
    //   6087: invokevirtual 717	com/tencent/mm/ai/k$b:getTitle	()Ljava/lang/String;
    //   6090: astore 18
    //   6092: iconst_1
    //   6093: istore 13
    //   6095: aload 21
    //   6097: astore_3
    //   6098: goto -5263 -> 835
    //   6101: ldc 26
    //   6103: astore_0
    //   6104: goto -63 -> 6041
    //   6107: ldc 26
    //   6109: astore_3
    //   6110: goto -31 -> 6079
    //   6113: aload 5
    //   6115: ldc_w 635
    //   6118: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6121: astore_3
    //   6122: aconst_null
    //   6123: astore 18
    //   6125: iconst_0
    //   6126: istore 13
    //   6128: ldc 26
    //   6130: astore_0
    //   6131: goto -5296 -> 835
    //   6134: ldc 26
    //   6136: astore 21
    //   6138: aload 5
    //   6140: ldc_w 724
    //   6143: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6146: astore_3
    //   6147: aload 19
    //   6149: invokevirtual 46	java/lang/String:length	()I
    //   6152: ifle +115 -> 6267
    //   6155: new 152	java/lang/StringBuilder
    //   6158: dup
    //   6159: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6162: aload 19
    //   6164: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6167: ldc_w 427
    //   6170: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6173: aload_3
    //   6174: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6177: aload 18
    //   6179: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6182: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6185: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6188: astore_0
    //   6189: aload_2
    //   6190: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   6193: ifne +22 -> 6215
    //   6196: iload 14
    //   6198: ifne +17 -> 6215
    //   6201: aload_2
    //   6202: invokestatic 404	com/tencent/mm/model/w:tm	(Ljava/lang/String;)Z
    //   6205: ifne +10 -> 6215
    //   6208: aload 7
    //   6210: aload 19
    //   6212: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6215: aload 19
    //   6217: invokevirtual 46	java/lang/String:length	()I
    //   6220: ifle +73 -> 6293
    //   6223: new 152	java/lang/StringBuilder
    //   6226: dup
    //   6227: ldc_w 429
    //   6230: invokespecial 572	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   6233: aload_3
    //   6234: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6237: aload 18
    //   6239: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6242: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6245: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6248: astore_3
    //   6249: aload 6
    //   6251: aload_3
    //   6252: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6255: aconst_null
    //   6256: astore 18
    //   6258: iconst_0
    //   6259: istore 13
    //   6261: aload 21
    //   6263: astore_3
    //   6264: goto -5429 -> 835
    //   6267: new 152	java/lang/StringBuilder
    //   6270: dup
    //   6271: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6274: aload_3
    //   6275: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6278: aload 18
    //   6280: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6283: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6286: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6289: astore_0
    //   6290: goto -101 -> 6189
    //   6293: new 152	java/lang/StringBuilder
    //   6296: dup
    //   6297: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6300: aload_3
    //   6301: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6304: aload 18
    //   6306: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6309: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6312: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6315: astore_3
    //   6316: goto -67 -> 6249
    //   6319: aload 18
    //   6321: iconst_0
    //   6322: invokevirtual 728	com/tencent/mm/ai/k$b:dY	(Z)Z
    //   6325: ifeq +197 -> 6522
    //   6328: ldc 26
    //   6330: astore 21
    //   6332: aload 18
    //   6334: aload 5
    //   6336: iconst_1
    //   6337: invokevirtual 732	com/tencent/mm/ai/k$b:r	(Landroid/content/Context;Z)Ljava/lang/String;
    //   6340: astore_3
    //   6341: aload_3
    //   6342: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   6345: ifne +156 -> 6501
    //   6348: aload 19
    //   6350: invokevirtual 46	java/lang/String:length	()I
    //   6353: ifle +96 -> 6449
    //   6356: new 152	java/lang/StringBuilder
    //   6359: dup
    //   6360: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6363: aload 19
    //   6365: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6368: ldc_w 427
    //   6371: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6374: aload_3
    //   6375: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6378: aload 18
    //   6380: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6383: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6386: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6389: astore_0
    //   6390: aload 7
    //   6392: aload 19
    //   6394: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6397: aload 19
    //   6399: invokevirtual 46	java/lang/String:length	()I
    //   6402: ifle +73 -> 6475
    //   6405: new 152	java/lang/StringBuilder
    //   6408: dup
    //   6409: ldc_w 429
    //   6412: invokespecial 572	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   6415: aload_3
    //   6416: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6419: aload 18
    //   6421: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6424: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6427: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6430: astore_3
    //   6431: aload 6
    //   6433: aload_3
    //   6434: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6437: aconst_null
    //   6438: astore 18
    //   6440: iconst_0
    //   6441: istore 13
    //   6443: aload 21
    //   6445: astore_3
    //   6446: goto -5611 -> 835
    //   6449: new 152	java/lang/StringBuilder
    //   6452: dup
    //   6453: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6456: aload_3
    //   6457: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6460: aload 18
    //   6462: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6465: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6468: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6471: astore_0
    //   6472: goto -82 -> 6390
    //   6475: new 152	java/lang/StringBuilder
    //   6478: dup
    //   6479: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6482: aload_3
    //   6483: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6486: aload 18
    //   6488: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6491: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6494: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6497: astore_3
    //   6498: goto -67 -> 6431
    //   6501: aload 5
    //   6503: ldc_w 635
    //   6506: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6509: astore_3
    //   6510: aconst_null
    //   6511: astore 18
    //   6513: iconst_0
    //   6514: istore 13
    //   6516: ldc 26
    //   6518: astore_0
    //   6519: goto -5684 -> 835
    //   6522: aload 5
    //   6524: ldc_w 635
    //   6527: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6530: astore_3
    //   6531: aconst_null
    //   6532: astore 18
    //   6534: iconst_0
    //   6535: istore 13
    //   6537: ldc 26
    //   6539: astore_0
    //   6540: goto -5705 -> 835
    //   6543: aload 5
    //   6545: ldc_w 733
    //   6548: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6551: astore_3
    //   6552: aload 19
    //   6554: invokevirtual 46	java/lang/String:length	()I
    //   6557: ifle +60 -> 6617
    //   6560: new 152	java/lang/StringBuilder
    //   6563: dup
    //   6564: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6567: aload 19
    //   6569: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6572: ldc_w 427
    //   6575: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6578: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6581: astore_0
    //   6582: aload_2
    //   6583: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   6586: ifne +15 -> 6601
    //   6589: iload 14
    //   6591: ifne +10 -> 6601
    //   6594: aload 7
    //   6596: aload 19
    //   6598: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6601: aload 6
    //   6603: ldc 26
    //   6605: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6608: aconst_null
    //   6609: astore 18
    //   6611: iconst_0
    //   6612: istore 13
    //   6614: goto -5779 -> 835
    //   6617: ldc 26
    //   6619: astore_0
    //   6620: goto -38 -> 6582
    //   6623: aload 5
    //   6625: ldc_w 734
    //   6628: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6631: astore_3
    //   6632: aload 19
    //   6634: invokevirtual 46	java/lang/String:length	()I
    //   6637: ifle +60 -> 6697
    //   6640: new 152	java/lang/StringBuilder
    //   6643: dup
    //   6644: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6647: aload 19
    //   6649: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6652: ldc_w 427
    //   6655: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6658: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6661: astore_0
    //   6662: aload_2
    //   6663: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   6666: ifne +15 -> 6681
    //   6669: iload 14
    //   6671: ifne +10 -> 6681
    //   6674: aload 7
    //   6676: aload 19
    //   6678: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6681: aload 6
    //   6683: ldc 26
    //   6685: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6688: aconst_null
    //   6689: astore 18
    //   6691: iconst_0
    //   6692: istore 13
    //   6694: goto -5859 -> 835
    //   6697: ldc 26
    //   6699: astore_0
    //   6700: goto -38 -> 6662
    //   6703: aload 5
    //   6705: ldc_w 735
    //   6708: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6711: astore_3
    //   6712: aload 19
    //   6714: invokevirtual 46	java/lang/String:length	()I
    //   6717: ifle +60 -> 6777
    //   6720: new 152	java/lang/StringBuilder
    //   6723: dup
    //   6724: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6727: aload 19
    //   6729: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6732: ldc_w 427
    //   6735: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6738: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6741: astore_0
    //   6742: aload_2
    //   6743: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   6746: ifne +15 -> 6761
    //   6749: iload 14
    //   6751: ifne +10 -> 6761
    //   6754: aload 7
    //   6756: aload 19
    //   6758: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6761: aload 6
    //   6763: ldc 26
    //   6765: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6768: aconst_null
    //   6769: astore 18
    //   6771: iconst_0
    //   6772: istore 13
    //   6774: goto -5939 -> 835
    //   6777: ldc 26
    //   6779: astore_0
    //   6780: goto -38 -> 6742
    //   6783: ldc 26
    //   6785: astore 21
    //   6787: aload 19
    //   6789: invokevirtual 46	java/lang/String:length	()I
    //   6792: ifle +100 -> 6892
    //   6795: new 152	java/lang/StringBuilder
    //   6798: dup
    //   6799: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6802: aload 19
    //   6804: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6807: ldc_w 427
    //   6810: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6813: aload 18
    //   6815: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6818: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6821: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6824: astore_0
    //   6825: aload_2
    //   6826: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   6829: ifne +15 -> 6844
    //   6832: iload 14
    //   6834: ifne +10 -> 6844
    //   6837: aload 7
    //   6839: aload 19
    //   6841: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6844: aload 19
    //   6846: invokevirtual 46	java/lang/String:length	()I
    //   6849: ifle +52 -> 6901
    //   6852: new 152	java/lang/StringBuilder
    //   6855: dup
    //   6856: ldc_w 429
    //   6859: invokespecial 572	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   6862: aload 18
    //   6864: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6867: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6870: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6873: astore_3
    //   6874: aload 6
    //   6876: aload_3
    //   6877: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6880: aconst_null
    //   6881: astore 18
    //   6883: iconst_0
    //   6884: istore 13
    //   6886: aload 21
    //   6888: astore_3
    //   6889: goto -6054 -> 835
    //   6892: aload 18
    //   6894: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6897: astore_0
    //   6898: goto -73 -> 6825
    //   6901: aload 18
    //   6903: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6906: astore_3
    //   6907: goto -33 -> 6874
    //   6910: aload 5
    //   6912: ldc_w 736
    //   6915: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6918: astore 21
    //   6920: aload 19
    //   6922: invokevirtual 46	java/lang/String:length	()I
    //   6925: ifle +74 -> 6999
    //   6928: new 152	java/lang/StringBuilder
    //   6931: dup
    //   6932: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6935: aload 19
    //   6937: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6940: ldc_w 427
    //   6943: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6946: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6949: astore_0
    //   6950: aload_2
    //   6951: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   6954: ifne +15 -> 6969
    //   6957: iload 14
    //   6959: ifne +10 -> 6969
    //   6962: aload 7
    //   6964: aload 19
    //   6966: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6969: aload 19
    //   6971: invokevirtual 46	java/lang/String:length	()I
    //   6974: ifle +31 -> 7005
    //   6977: ldc_w 429
    //   6980: astore_3
    //   6981: aload 6
    //   6983: aload_3
    //   6984: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6987: aconst_null
    //   6988: astore 18
    //   6990: iconst_0
    //   6991: istore 13
    //   6993: aload 21
    //   6995: astore_3
    //   6996: goto -6161 -> 835
    //   6999: ldc 26
    //   7001: astore_0
    //   7002: goto -52 -> 6950
    //   7005: ldc 26
    //   7007: astore_3
    //   7008: goto -27 -> 6981
    //   7011: ldc 26
    //   7013: astore_0
    //   7014: aload 18
    //   7016: getfield 739	com/tencent/mm/ai/k$b:description	Ljava/lang/String;
    //   7019: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   7022: ifne +35 -> 7057
    //   7025: aload 18
    //   7027: getfield 739	com/tencent/mm/ai/k$b:description	Ljava/lang/String;
    //   7030: ldc_w 741
    //   7033: invokevirtual 127	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   7036: istore 13
    //   7038: aload 18
    //   7040: getfield 739	com/tencent/mm/ai/k$b:description	Ljava/lang/String;
    //   7043: astore_0
    //   7044: iload 13
    //   7046: ifle +117 -> 7163
    //   7049: aload_0
    //   7050: iconst_0
    //   7051: iload 13
    //   7053: invokevirtual 131	java/lang/String:substring	(II)Ljava/lang/String;
    //   7056: astore_0
    //   7057: new 152	java/lang/StringBuilder
    //   7060: dup
    //   7061: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7064: aload 5
    //   7066: ldc_w 742
    //   7069: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7072: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7075: aload_0
    //   7076: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7079: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7082: astore 21
    //   7084: aload 19
    //   7086: invokevirtual 46	java/lang/String:length	()I
    //   7089: ifle +87 -> 7176
    //   7092: new 152	java/lang/StringBuilder
    //   7095: dup
    //   7096: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7099: aload 19
    //   7101: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7104: ldc_w 427
    //   7107: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7110: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7113: astore_0
    //   7114: aload_2
    //   7115: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   7118: ifne +15 -> 7133
    //   7121: iload 14
    //   7123: ifne +10 -> 7133
    //   7126: aload 7
    //   7128: aload 19
    //   7130: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7133: aload 19
    //   7135: invokevirtual 46	java/lang/String:length	()I
    //   7138: ifle +44 -> 7182
    //   7141: ldc_w 429
    //   7144: astore_3
    //   7145: aload 6
    //   7147: aload_3
    //   7148: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7151: aconst_null
    //   7152: astore 18
    //   7154: iconst_0
    //   7155: istore 13
    //   7157: aload 21
    //   7159: astore_3
    //   7160: goto -6325 -> 835
    //   7163: aload 18
    //   7165: getfield 739	com/tencent/mm/ai/k$b:description	Ljava/lang/String;
    //   7168: invokevirtual 46	java/lang/String:length	()I
    //   7171: istore 13
    //   7173: goto -124 -> 7049
    //   7176: ldc 26
    //   7178: astore_0
    //   7179: goto -65 -> 7114
    //   7182: ldc 26
    //   7184: astore_3
    //   7185: goto -40 -> 7145
    //   7188: ldc 26
    //   7190: astore 21
    //   7192: aload 5
    //   7194: ldc_w 622
    //   7197: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7200: astore_3
    //   7201: aload 19
    //   7203: invokevirtual 46	java/lang/String:length	()I
    //   7206: ifle +93 -> 7299
    //   7209: new 152	java/lang/StringBuilder
    //   7212: dup
    //   7213: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7216: aload 19
    //   7218: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7221: ldc_w 427
    //   7224: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7227: aload_3
    //   7228: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7231: aload 18
    //   7233: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   7236: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7239: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7242: astore_0
    //   7243: aload_2
    //   7244: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   7247: ifne +15 -> 7262
    //   7250: iload 14
    //   7252: ifne +10 -> 7262
    //   7255: aload 7
    //   7257: aload 19
    //   7259: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7262: aload 19
    //   7264: invokevirtual 46	java/lang/String:length	()I
    //   7267: ifle +58 -> 7325
    //   7270: ldc_w 429
    //   7273: aload_3
    //   7274: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7277: invokevirtual 631	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   7280: astore_3
    //   7281: aload 6
    //   7283: aload_3
    //   7284: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7287: aconst_null
    //   7288: astore 18
    //   7290: iconst_0
    //   7291: istore 13
    //   7293: aload 21
    //   7295: astore_3
    //   7296: goto -6461 -> 835
    //   7299: new 152	java/lang/StringBuilder
    //   7302: dup
    //   7303: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7306: aload_3
    //   7307: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7310: aload 18
    //   7312: getfield 560	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   7315: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7318: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7321: astore_0
    //   7322: goto -79 -> 7243
    //   7325: aload_3
    //   7326: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7329: astore_3
    //   7330: goto -49 -> 7281
    //   7333: ldc 26
    //   7335: astore 21
    //   7337: aload 5
    //   7339: ldc_w 622
    //   7342: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7345: astore_0
    //   7346: iload_1
    //   7347: iconst_1
    //   7348: if_icmpne +96 -> 7444
    //   7351: new 152	java/lang/StringBuilder
    //   7354: dup
    //   7355: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7358: aload_0
    //   7359: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7362: aload 18
    //   7364: getfield 625	com/tencent/mm/ai/k$b:gIy	Ljava/lang/String;
    //   7367: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7370: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7373: astore_3
    //   7374: aload 19
    //   7376: invokevirtual 46	java/lang/String:length	()I
    //   7379: ifle +57 -> 7436
    //   7382: ldc_w 429
    //   7385: aload_3
    //   7386: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7389: invokevirtual 631	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   7392: astore_0
    //   7393: aload 6
    //   7395: aload_0
    //   7396: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7399: aload_3
    //   7400: astore_0
    //   7401: aload_2
    //   7402: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   7405: ifne +1586 -> 8991
    //   7408: aload_3
    //   7409: astore_0
    //   7410: iload 14
    //   7412: ifne +1579 -> 8991
    //   7415: aload 7
    //   7417: aload 19
    //   7419: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7422: aconst_null
    //   7423: astore 18
    //   7425: iconst_0
    //   7426: istore 13
    //   7428: aload_3
    //   7429: astore_0
    //   7430: aload 21
    //   7432: astore_3
    //   7433: goto -6598 -> 835
    //   7436: aload_3
    //   7437: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7440: astore_0
    //   7441: goto -48 -> 7393
    //   7444: new 152	java/lang/StringBuilder
    //   7447: dup
    //   7448: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7451: aload_0
    //   7452: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7455: aload 18
    //   7457: getfield 634	com/tencent/mm/ai/k$b:gIx	Ljava/lang/String;
    //   7460: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7463: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7466: astore_3
    //   7467: aload 19
    //   7469: invokevirtual 46	java/lang/String:length	()I
    //   7472: ifle +23 -> 7495
    //   7475: ldc_w 429
    //   7478: aload_3
    //   7479: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7482: invokevirtual 631	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   7485: astore_0
    //   7486: aload 6
    //   7488: aload_0
    //   7489: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7492: goto -93 -> 7399
    //   7495: aload_3
    //   7496: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7499: astore_0
    //   7500: goto -14 -> 7486
    //   7503: aload_0
    //   7504: invokestatic 748	com/tencent/mm/ai/t:rC	(Ljava/lang/String;)Lcom/tencent/mm/ai/t;
    //   7507: getfield 751	com/tencent/mm/ai/t:gKA	I
    //   7510: bipush 19
    //   7512: if_icmpne +27 -> 7539
    //   7515: aload 5
    //   7517: ldc_w 736
    //   7520: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7523: astore 21
    //   7525: aconst_null
    //   7526: astore 18
    //   7528: iconst_0
    //   7529: istore 13
    //   7531: aload_3
    //   7532: astore_0
    //   7533: aload 21
    //   7535: astore_3
    //   7536: goto -6701 -> 835
    //   7539: aload 5
    //   7541: ldc_w 635
    //   7544: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7547: astore 21
    //   7549: aconst_null
    //   7550: astore 18
    //   7552: iconst_0
    //   7553: istore 13
    //   7555: aload_3
    //   7556: astore_0
    //   7557: aload 21
    //   7559: astore_3
    //   7560: goto -6725 -> 835
    //   7563: aload_3
    //   7564: astore_0
    //   7565: iload 15
    //   7567: ifeq +8 -> 7575
    //   7570: aload_3
    //   7571: invokestatic 754	com/tencent/mm/booter/notification/a/h:oD	(Ljava/lang/String;)Ljava/lang/String;
    //   7574: astore_0
    //   7575: ldc_w 290
    //   7578: invokestatic 296	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   7581: checkcast 290	com/tencent/mm/plugin/biz/a/a
    //   7584: aload_0
    //   7585: invokeinterface 757 2 0
    //   7590: astore_3
    //   7591: aload_3
    //   7592: astore_0
    //   7593: iload 15
    //   7595: ifeq +8 -> 7603
    //   7598: aload_3
    //   7599: invokestatic 384	com/tencent/mm/booter/notification/a/h:oC	(Ljava/lang/String;)Ljava/lang/String;
    //   7602: astore_0
    //   7603: aload_0
    //   7604: invokestatic 204	com/tencent/mm/pluginsdk/ui/span/k:aCn	(Ljava/lang/String;)Ljava/lang/String;
    //   7607: astore_0
    //   7608: aload 6
    //   7610: aload_0
    //   7611: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7614: ldc 26
    //   7616: astore_3
    //   7617: aconst_null
    //   7618: astore 18
    //   7620: iconst_0
    //   7621: istore 13
    //   7623: goto -6788 -> 835
    //   7626: aload 6
    //   7628: ldc_w 290
    //   7631: invokestatic 296	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   7634: checkcast 290	com/tencent/mm/plugin/biz/a/a
    //   7637: aload_3
    //   7638: invokeinterface 760 2 0
    //   7643: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7646: aload 6
    //   7648: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7651: astore_3
    //   7652: ldc_w 613
    //   7655: ldc_w 762
    //   7658: iconst_2
    //   7659: anewarray 4	java/lang/Object
    //   7662: dup
    //   7663: iconst_0
    //   7664: ldc_w 288
    //   7667: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7670: aastore
    //   7671: dup
    //   7672: iconst_1
    //   7673: aload_3
    //   7674: aastore
    //   7675: invokestatic 765	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7678: aconst_null
    //   7679: astore 18
    //   7681: iconst_0
    //   7682: istore 13
    //   7684: ldc 26
    //   7686: astore_0
    //   7687: goto -6852 -> 835
    //   7690: aload_3
    //   7691: invokestatic 771	com/tencent/mm/an/a$a:xB	(Ljava/lang/String;)Lcom/tencent/mm/an/a$a;
    //   7694: invokestatic 776	com/tencent/mm/an/a:b	(Lcom/tencent/mm/an/a$a;)Ljava/lang/String;
    //   7697: astore_0
    //   7698: aload 6
    //   7700: aload_0
    //   7701: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7704: ldc 26
    //   7706: astore_3
    //   7707: aconst_null
    //   7708: astore 18
    //   7710: iconst_0
    //   7711: istore 13
    //   7713: goto -6878 -> 835
    //   7716: ldc 26
    //   7718: astore_3
    //   7719: aload 21
    //   7721: invokestatic 549	com/tencent/mm/ai/k$b:rx	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   7724: astore 18
    //   7726: aload_3
    //   7727: astore_0
    //   7728: aload 18
    //   7730: ifnull -6904 -> 826
    //   7733: aload_3
    //   7734: astore_0
    //   7735: aload 18
    //   7737: getfield 638	com/tencent/mm/ai/k$b:content	Ljava/lang/String;
    //   7740: ldc_w 640
    //   7743: invokestatic 645	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7746: astore_3
    //   7747: aload_3
    //   7748: astore_0
    //   7749: aload_3
    //   7750: invokestatic 204	com/tencent/mm/pluginsdk/ui/span/k:aCn	(Ljava/lang/String;)Ljava/lang/String;
    //   7753: astore_3
    //   7754: aload_3
    //   7755: astore_0
    //   7756: aload 6
    //   7758: aload_0
    //   7759: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7762: ldc 26
    //   7764: astore_3
    //   7765: aconst_null
    //   7766: astore 18
    //   7768: iconst_0
    //   7769: istore 13
    //   7771: goto -6936 -> 835
    //   7774: astore_3
    //   7775: ldc_w 613
    //   7778: aload_3
    //   7779: ldc 26
    //   7781: iconst_0
    //   7782: anewarray 4	java/lang/Object
    //   7785: invokestatic 649	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7788: ldc 26
    //   7790: astore_3
    //   7791: aconst_null
    //   7792: astore 18
    //   7794: iconst_0
    //   7795: istore 13
    //   7797: goto -6962 -> 835
    //   7800: ldc_w 778
    //   7803: invokestatic 296	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   7806: checkcast 778	com/tencent/mm/plugin/messenger/a/f
    //   7809: aload_3
    //   7810: invokeinterface 782 2 0
    //   7815: astore_0
    //   7816: aload_0
    //   7817: ifnull +100 -> 7917
    //   7820: aload_0
    //   7821: invokeinterface 785 1 0
    //   7826: astore_3
    //   7827: aload_3
    //   7828: astore_0
    //   7829: iload 9
    //   7831: ifeq +68 -> 7899
    //   7834: aload_3
    //   7835: astore_0
    //   7836: aload_2
    //   7837: invokestatic 385	com/tencent/mm/model/w:pF	(Ljava/lang/String;)Z
    //   7840: ifeq +59 -> 7899
    //   7843: aload_3
    //   7844: astore_0
    //   7845: aload_3
    //   7846: aload 5
    //   7848: ldc_w 786
    //   7851: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7854: invokevirtual 789	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   7857: ifeq +42 -> 7899
    //   7860: ldc_w 613
    //   7863: ldc_w 791
    //   7866: iconst_1
    //   7867: anewarray 4	java/lang/Object
    //   7870: dup
    //   7871: iconst_0
    //   7872: aload_3
    //   7873: aastore
    //   7874: invokestatic 765	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7877: aload_3
    //   7878: iconst_0
    //   7879: aload_3
    //   7880: invokevirtual 46	java/lang/String:length	()I
    //   7883: aload 5
    //   7885: ldc_w 786
    //   7888: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7891: invokevirtual 46	java/lang/String:length	()I
    //   7894: isub
    //   7895: invokevirtual 131	java/lang/String:substring	(II)Ljava/lang/String;
    //   7898: astore_0
    //   7899: aload 6
    //   7901: aload_0
    //   7902: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7905: ldc 26
    //   7907: astore_3
    //   7908: aconst_null
    //   7909: astore 18
    //   7911: iconst_0
    //   7912: istore 13
    //   7914: goto -7079 -> 835
    //   7917: ldc 26
    //   7919: astore_3
    //   7920: goto -93 -> 7827
    //   7923: aload_3
    //   7924: invokestatic 797	com/tencent/mm/ai/a/b:rG	(Ljava/lang/String;)Lcom/tencent/mm/ai/a/b;
    //   7927: getfield 798	com/tencent/mm/ai/a/b:content	Ljava/lang/String;
    //   7930: astore_3
    //   7931: aload_3
    //   7932: astore_0
    //   7933: aload_3
    //   7934: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   7937: ifeq +6 -> 7943
    //   7940: ldc 26
    //   7942: astore_0
    //   7943: aload 6
    //   7945: aload_0
    //   7946: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7949: ldc 26
    //   7951: astore_3
    //   7952: aconst_null
    //   7953: astore 18
    //   7955: iconst_0
    //   7956: istore 13
    //   7958: goto -7123 -> 835
    //   7961: aload 5
    //   7963: ldc_w 799
    //   7966: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7969: astore_0
    //   7970: aload 6
    //   7972: aload_0
    //   7973: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7976: ldc 26
    //   7978: astore_3
    //   7979: aconst_null
    //   7980: astore 18
    //   7982: iconst_0
    //   7983: istore 13
    //   7985: goto -7150 -> 835
    //   7988: aload_3
    //   7989: invokestatic 805	com/tencent/mm/ai/a/a:rE	(Ljava/lang/String;)Lcom/tencent/mm/ai/a/a;
    //   7992: astore_0
    //   7993: aload_0
    //   7994: getfield 806	com/tencent/mm/ai/a/a:nickname	Ljava/lang/String;
    //   7997: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8000: ifne +13 -> 8013
    //   8003: aload_0
    //   8004: getfield 807	com/tencent/mm/ai/a/a:title	Ljava/lang/String;
    //   8007: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8010: ifeq +9 -> 8019
    //   8013: ldc 26
    //   8015: astore_0
    //   8016: goto -46 -> 7970
    //   8019: getstatic 813	java/util/Locale:US	Ljava/util/Locale;
    //   8022: ldc_w 815
    //   8025: iconst_2
    //   8026: anewarray 4	java/lang/Object
    //   8029: dup
    //   8030: iconst_0
    //   8031: aload_0
    //   8032: getfield 806	com/tencent/mm/ai/a/a:nickname	Ljava/lang/String;
    //   8035: aastore
    //   8036: dup
    //   8037: iconst_1
    //   8038: aload_0
    //   8039: getfield 807	com/tencent/mm/ai/a/a:title	Ljava/lang/String;
    //   8042: aastore
    //   8043: invokestatic 819	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   8046: astore_0
    //   8047: goto -77 -> 7970
    //   8050: aload_0
    //   8051: ldc_w 821
    //   8054: invokevirtual 825	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8057: astore_0
    //   8058: aload_0
    //   8059: arraylength
    //   8060: iconst_1
    //   8061: if_icmple +23 -> 8084
    //   8064: aload 6
    //   8066: aload_0
    //   8067: iconst_1
    //   8068: aaload
    //   8069: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8072: aload_0
    //   8073: iconst_1
    //   8074: aaload
    //   8075: astore_0
    //   8076: ldc_w 360
    //   8079: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8082: aload_0
    //   8083: areturn
    //   8084: aload 6
    //   8086: ldc 26
    //   8088: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8091: ldc_w 360
    //   8094: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8097: aconst_null
    //   8098: areturn
    //   8099: aconst_null
    //   8100: astore_2
    //   8101: aconst_null
    //   8102: astore 7
    //   8104: aload_0
    //   8105: ldc 123
    //   8107: invokevirtual 825	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8110: astore 5
    //   8112: aload 5
    //   8114: ifnull +9 -> 8123
    //   8117: aload 5
    //   8119: arraylength
    //   8120: ifgt +18 -> 8138
    //   8123: aload 6
    //   8125: ldc 26
    //   8127: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8130: ldc_w 360
    //   8133: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8136: aconst_null
    //   8137: areturn
    //   8138: aload 5
    //   8140: iconst_0
    //   8141: aaload
    //   8142: astore 5
    //   8144: aload 5
    //   8146: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8149: ifne +69 -> 8218
    //   8152: invokestatic 257	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
    //   8155: pop
    //   8156: invokestatic 263	com/tencent/mm/model/c:apM	()Lcom/tencent/mm/storage/bg;
    //   8159: aload 5
    //   8161: invokeinterface 269 2 0
    //   8166: astore 8
    //   8168: aload 7
    //   8170: astore 5
    //   8172: aload 8
    //   8174: ifnull +22 -> 8196
    //   8177: aload 7
    //   8179: astore 5
    //   8181: aload 8
    //   8183: invokevirtual 320	com/tencent/mm/storage/af:getCity	()Ljava/lang/String;
    //   8186: ifnull +10 -> 8196
    //   8189: aload 8
    //   8191: invokevirtual 320	com/tencent/mm/storage/af:getCity	()Ljava/lang/String;
    //   8194: astore 5
    //   8196: aload 5
    //   8198: ifnull +14 -> 8212
    //   8201: aload 5
    //   8203: astore_2
    //   8204: aload 5
    //   8206: invokevirtual 46	java/lang/String:length	()I
    //   8209: ifgt +9 -> 8218
    //   8212: aload 8
    //   8214: invokevirtual 327	com/tencent/mm/storage/af:getProvince	()Ljava/lang/String;
    //   8217: astore_2
    //   8218: aload_3
    //   8219: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8222: ifne +65 -> 8287
    //   8225: aload 6
    //   8227: new 152	java/lang/StringBuilder
    //   8230: dup
    //   8231: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8234: aload_2
    //   8235: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8238: ldc_w 427
    //   8241: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8244: aload_3
    //   8245: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8248: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8251: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8254: new 152	java/lang/StringBuilder
    //   8257: dup
    //   8258: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8261: aload_2
    //   8262: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8265: ldc_w 427
    //   8268: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8271: aload_3
    //   8272: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8275: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8278: astore_0
    //   8279: ldc_w 360
    //   8282: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8285: aload_0
    //   8286: areturn
    //   8287: aload_0
    //   8288: ldc_w 821
    //   8291: invokevirtual 825	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8294: astore_0
    //   8295: aload_0
    //   8296: arraylength
    //   8297: iconst_1
    //   8298: if_icmple +69 -> 8367
    //   8301: aload 6
    //   8303: new 152	java/lang/StringBuilder
    //   8306: dup
    //   8307: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8310: aload_2
    //   8311: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8314: ldc_w 427
    //   8317: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8320: aload_0
    //   8321: iconst_1
    //   8322: aaload
    //   8323: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8326: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8329: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8332: new 152	java/lang/StringBuilder
    //   8335: dup
    //   8336: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8339: aload_2
    //   8340: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8343: ldc_w 427
    //   8346: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8349: aload_0
    //   8350: iconst_1
    //   8351: aaload
    //   8352: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8355: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8358: astore_0
    //   8359: ldc_w 360
    //   8362: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8365: aload_0
    //   8366: areturn
    //   8367: aload 6
    //   8369: aload_2
    //   8370: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8373: ldc_w 360
    //   8376: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8379: aload_2
    //   8380: areturn
    //   8381: aload_0
    //   8382: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8385: ifeq +10 -> 8395
    //   8388: aload 6
    //   8390: ldc 26
    //   8392: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8395: aload 19
    //   8397: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8400: ifne +202 -> 8602
    //   8403: aload_0
    //   8404: astore_2
    //   8405: aload 20
    //   8407: ifnull +22 -> 8429
    //   8410: aload_0
    //   8411: astore_2
    //   8412: aload 20
    //   8414: invokevirtual 46	java/lang/String:length	()I
    //   8417: ifle +12 -> 8429
    //   8420: aload_0
    //   8421: aload 19
    //   8423: aload 20
    //   8425: invokestatic 829	com/tencent/mm/booter/notification/a/h:f	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8428: astore_2
    //   8429: aload 7
    //   8431: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8434: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8437: ifeq +28 -> 8465
    //   8440: aload 6
    //   8442: aload 6
    //   8444: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8447: aload 19
    //   8449: ldc_w 535
    //   8452: invokestatic 829	com/tencent/mm/booter/notification/a/h:f	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8455: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8458: aload 7
    //   8460: aload 19
    //   8462: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8465: aload_2
    //   8466: invokestatic 834	com/tencent/mm/compatible/util/n:pv	(Ljava/lang/String;)Ljava/lang/String;
    //   8469: astore_0
    //   8470: aload 6
    //   8472: aload 6
    //   8474: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8477: invokestatic 834	com/tencent/mm/compatible/util/n:pv	(Ljava/lang/String;)Ljava/lang/String;
    //   8480: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8483: new 152	java/lang/StringBuilder
    //   8486: dup
    //   8487: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8490: aload_0
    //   8491: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8494: aload_3
    //   8495: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8498: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8501: astore_2
    //   8502: aload 6
    //   8504: new 152	java/lang/StringBuilder
    //   8507: dup
    //   8508: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8511: aload 6
    //   8513: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8516: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8519: aload_3
    //   8520: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8523: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8526: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8529: iload 9
    //   8531: ifeq +25 -> 8556
    //   8534: iload 4
    //   8536: aload 6
    //   8538: aload_2
    //   8539: invokestatic 837	com/tencent/mm/booter/notification/a/h:a	(ILcom/tencent/mm/pointers/PString;Ljava/lang/String;)Z
    //   8542: ifne +14 -> 8556
    //   8545: iload 4
    //   8547: aload 6
    //   8549: aload 7
    //   8551: aload 8
    //   8553: invokestatic 840	com/tencent/mm/booter/notification/a/h:a	(ILcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PInt;)V
    //   8556: aload_2
    //   8557: astore_0
    //   8558: iload 13
    //   8560: ifeq +29 -> 8589
    //   8563: aload_2
    //   8564: new 152	java/lang/StringBuilder
    //   8567: dup
    //   8568: ldc_w 398
    //   8571: invokespecial 572	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   8574: aload 18
    //   8576: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   8579: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8582: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8585: invokevirtual 631	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   8588: astore_0
    //   8589: aload_0
    //   8590: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   8593: astore_0
    //   8594: ldc_w 360
    //   8597: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8600: aload_0
    //   8601: areturn
    //   8602: aload_2
    //   8603: invokestatic 401	com/tencent/mm/model/w:td	(Ljava/lang/String;)Z
    //   8606: ifne +15 -> 8621
    //   8609: iload 14
    //   8611: ifne +10 -> 8621
    //   8614: aload_2
    //   8615: invokestatic 404	com/tencent/mm/model/w:tm	(Ljava/lang/String;)Z
    //   8618: ifeq +324 -> 8942
    //   8621: aload_0
    //   8622: astore 19
    //   8624: aload_3
    //   8625: ifnull +16 -> 8641
    //   8628: aload_0
    //   8629: astore 19
    //   8631: aload_3
    //   8632: invokevirtual 46	java/lang/String:length	()I
    //   8635: ifle +6 -> 8641
    //   8638: aload_3
    //   8639: astore 19
    //   8641: aload 19
    //   8643: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8646: ifeq +26 -> 8672
    //   8649: aload 6
    //   8651: ldc 26
    //   8653: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8656: aload 7
    //   8658: ldc 26
    //   8660: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8663: ldc_w 360
    //   8666: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8669: ldc 26
    //   8671: areturn
    //   8672: iload_1
    //   8673: ifne +190 -> 8863
    //   8676: aload 6
    //   8678: ldc_w 450
    //   8681: aload 19
    //   8683: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   8686: invokevirtual 631	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   8689: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8692: iload 9
    //   8694: ifeq +208 -> 8902
    //   8697: iload 4
    //   8699: aload 6
    //   8701: aload 7
    //   8703: aload 8
    //   8705: invokestatic 840	com/tencent/mm/booter/notification/a/h:a	(ILcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PInt;)V
    //   8708: aload 19
    //   8710: astore_0
    //   8711: aload_0
    //   8712: astore_3
    //   8713: iload 13
    //   8715: ifeq +26 -> 8741
    //   8718: aload_0
    //   8719: astore_3
    //   8720: aload 18
    //   8722: ifnull +19 -> 8741
    //   8725: aload_0
    //   8726: ldc_w 398
    //   8729: aload 18
    //   8731: invokestatic 628	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   8734: invokevirtual 631	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   8737: invokevirtual 631	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   8740: astore_3
    //   8741: aload_3
    //   8742: astore_0
    //   8743: iload 15
    //   8745: ifeq +8 -> 8753
    //   8748: aload_3
    //   8749: invokestatic 754	com/tencent/mm/booter/notification/a/h:oD	(Ljava/lang/String;)Ljava/lang/String;
    //   8752: astore_0
    //   8753: aload 11
    //   8755: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8758: ifne +92 -> 8850
    //   8761: aload_2
    //   8762: invokestatic 845	com/tencent/mm/am/f:wG	(Ljava/lang/String;)Z
    //   8765: ifeq +85 -> 8850
    //   8768: invokestatic 849	com/tencent/mm/am/af:awd	()Lcom/tencent/mm/am/i;
    //   8771: aload 11
    //   8773: invokevirtual 855	com/tencent/mm/am/i:wR	(Ljava/lang/String;)Lcom/tencent/mm/am/g;
    //   8776: astore_2
    //   8777: aload_2
    //   8778: ifnull +72 -> 8850
    //   8781: aload_2
    //   8782: getfield 860	com/tencent/mm/am/g:field_openId	Ljava/lang/String;
    //   8785: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8788: ifne +62 -> 8850
    //   8791: aload_2
    //   8792: getfield 861	com/tencent/mm/am/g:field_nickname	Ljava/lang/String;
    //   8795: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8798: ifne +52 -> 8850
    //   8801: iload 12
    //   8803: iconst_2
    //   8804: if_icmpeq +11 -> 8815
    //   8807: aload_2
    //   8808: getfield 864	com/tencent/mm/am/g:field_kfType	I
    //   8811: iconst_2
    //   8812: if_icmpne +38 -> 8850
    //   8815: aload 6
    //   8817: new 152	java/lang/StringBuilder
    //   8820: dup
    //   8821: ldc_w 450
    //   8824: invokespecial 572	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   8827: aload 6
    //   8829: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8832: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8835: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8838: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8841: aload 7
    //   8843: aload_2
    //   8844: getfield 861	com/tencent/mm/am/g:field_nickname	Ljava/lang/String;
    //   8847: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8850: aload_0
    //   8851: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   8854: astore_0
    //   8855: ldc_w 360
    //   8858: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8861: aload_0
    //   8862: areturn
    //   8863: aload 6
    //   8865: new 152	java/lang/StringBuilder
    //   8868: dup
    //   8869: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8872: aload 5
    //   8874: ldc_w 865
    //   8877: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   8880: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8883: ldc 123
    //   8885: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8888: aload 19
    //   8890: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8893: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8896: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8899: goto -207 -> 8692
    //   8902: new 152	java/lang/StringBuilder
    //   8905: dup
    //   8906: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8909: aload 7
    //   8911: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8914: invokestatic 144	com/tencent/mm/model/v:sh	(Ljava/lang/String;)Ljava/lang/String;
    //   8917: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8920: ldc 123
    //   8922: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8925: aload 19
    //   8927: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8930: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8933: astore_0
    //   8934: ldc_w 360
    //   8937: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8940: aload_0
    //   8941: areturn
    //   8942: aload_3
    //   8943: ifnull +43 -> 8986
    //   8946: aload_3
    //   8947: invokevirtual 46	java/lang/String:length	()I
    //   8950: ifle +36 -> 8986
    //   8953: aload 6
    //   8955: aload_3
    //   8956: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8959: aload_3
    //   8960: astore_0
    //   8961: iload 9
    //   8963: ifeq -252 -> 8711
    //   8966: iload 4
    //   8968: aload 6
    //   8970: aload 7
    //   8972: aload 8
    //   8974: invokestatic 840	com/tencent/mm/booter/notification/a/h:a	(ILcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PInt;)V
    //   8977: aload_3
    //   8978: astore_0
    //   8979: goto -268 -> 8711
    //   8982: astore_3
    //   8983: goto -1208 -> 7775
    //   8986: aload_0
    //   8987: astore_3
    //   8988: goto -29 -> 8959
    //   8991: ldc 26
    //   8993: astore_3
    //   8994: aconst_null
    //   8995: astore 18
    //   8997: iconst_0
    //   8998: istore 13
    //   9000: goto -8165 -> 835
    //   9003: aconst_null
    //   9004: astore 18
    //   9006: iconst_0
    //   9007: istore 13
    //   9009: aload_3
    //   9010: astore_0
    //   9011: aload 21
    //   9013: astore_3
    //   9014: goto -8179 -> 835
    //   9017: ldc 26
    //   9019: astore_0
    //   9020: goto -4262 -> 4758
    //   9023: goto -4420 -> 4603
    //   9026: goto -4608 -> 4418
    //   9029: aload_2
    //   9030: astore_0
    //   9031: goto -6647 -> 2384
    //   9034: aload_2
    //   9035: astore_0
    //   9036: goto -6647 -> 2389
    //   9039: iload 13
    //   9041: istore 14
    //   9043: goto -8760 -> 283
    //   9046: aload_3
    //   9047: astore 21
    //   9049: ldc 26
    //   9051: astore 20
    //   9053: ldc 26
    //   9055: astore 19
    //   9057: goto -8836 -> 221
    //   9060: iconst_0
    //   9061: istore 15
    //   9063: goto -8926 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	9066	0	paramString1	String
    //   0	9066	1	paramInt1	int
    //   0	9066	2	paramString2	String
    //   0	9066	3	paramString3	String
    //   0	9066	4	paramInt2	int
    //   0	9066	5	paramContext	Context
    //   0	9066	6	paramPString1	PString
    //   0	9066	7	paramPString2	PString
    //   0	9066	8	paramPInt	PInt
    //   0	9066	9	paramBoolean1	boolean
    //   0	9066	10	paramBoolean2	boolean
    //   0	9066	11	paramString4	String
    //   0	9066	12	paramInt3	int
    //   165	8875	13	i	int
    //   278	8764	14	j	int
    //   135	8927	15	k	int
    //   921	29	16	m	int
    //   12	69	17	bool	boolean
    //   247	4004	18	localObject1	Object
    //   4261	8	18	localException	Exception
    //   4444	4561	18	localObject2	Object
    //   182	8874	19	str1	String
    //   190	8862	20	str2	String
    //   219	8829	21	localObject3	Object
    //   4289	501	22	str3	String
    // Exception table:
    //   from	to	target	type
    //   4187	4198	4261	java/lang/Exception
    //   4200	4205	4261	java/lang/Exception
    //   7735	7747	7774	java/lang/Exception
    //   7749	7754	7774	java/lang/Exception
    //   7756	7762	8982	java/lang/Exception
  }
  
  private static void a(int paramInt, PString paramPString1, PString paramPString2, PInt paramPInt)
  {
    AppMethodBeat.i(20085);
    if ((paramPString1.value.length() == 32) && ((paramInt == 47) || (paramInt == 1048625)))
    {
      AppMethodBeat.o(20085);
      return;
    }
    if (paramPString1.value.length() >= 150) {
      paramPString1.value = paramPString1.value.substring(0, C(paramPString1.value, 150));
    }
    TextPaint localTextPaint = getTextPaint();
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
  
  private static boolean a(int paramInt, PString paramPString, String paramString)
  {
    AppMethodBeat.i(20081);
    if ((paramPString.value.length() == 32) && ((paramInt == 47) || (paramInt == 1048625)))
    {
      paramPString.value = paramString;
      AppMethodBeat.o(20081);
      return true;
    }
    AppMethodBeat.o(20081);
    return false;
  }
  
  public static String b(bl parambl, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20074);
    String str;
    if (parambl.eLW())
    {
      str = parambl.eMD();
      if (!parambl.eJL()) {
        break label90;
      }
    }
    for (parambl = com.tencent.mm.pluginsdk.ui.span.k.aCn(a(parambl.field_imgPath, parambl.field_isSend, parambl.field_talker, str, parambl.getType(), com.tencent.mm.sdk.platformtools.aj.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean, parambl.ePb, parambl.ePh));; parambl = a(parambl.field_imgPath, parambl.field_isSend, parambl.field_talker, str, parambl.getType(), com.tencent.mm.sdk.platformtools.aj.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean, parambl.ePb, parambl.ePh))
    {
      parambl = bt.nullAsNil(parambl);
      AppMethodBeat.o(20074);
      return parambl;
      str = parambl.field_content;
      break;
      label90:
      str = com.tencent.mm.pluginsdk.ui.span.k.aCn(str);
    }
  }
  
  public static void b(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(20090);
    if ((fmd == null) || (fmd.get() == null)) {
      fmd = new WeakReference(paramTextPaint);
    }
    AppMethodBeat.o(20090);
  }
  
  public static boolean b(String paramString, bl parambl)
  {
    AppMethodBeat.i(20070);
    if ((parambl != null) && (parambl.field_bizChatId != -1L) && (com.tencent.mm.am.f.pc(paramString)))
    {
      AppMethodBeat.o(20070);
      return true;
    }
    AppMethodBeat.o(20070);
    return false;
  }
  
  private static String bQ(Context paramContext)
  {
    AppMethodBeat.i(20078);
    boolean bool = u.ard();
    az.arV();
    long l = bt.a((Long)com.tencent.mm.model.c.afk().get(65793, null), 0L);
    if (!bool)
    {
      paramContext = paramContext.getString(2131763356);
      AppMethodBeat.o(20078);
      return paramContext;
    }
    if (l == 0L)
    {
      paramContext = paramContext.getString(2131759554);
      AppMethodBeat.o(20078);
      return paramContext;
    }
    if (bt.lZ(l) * 1000L > 1209600000L)
    {
      paramContext = paramContext.getString(2131759553, new Object[] { Long.valueOf(bt.lZ(l) * 1000L / 86400000L) });
      AppMethodBeat.o(20078);
      return paramContext;
    }
    AppMethodBeat.o(20078);
    return "";
  }
  
  public static String d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20091);
    paramString = b.eHL().aGL(paramString);
    if (paramBoolean)
    {
      AppMethodBeat.o(20091);
      return paramString;
    }
    paramContext = paramContext.getString(2131760347);
    AppMethodBeat.o(20091);
    return paramContext;
  }
  
  public static String e(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20093);
    if (paramBoolean)
    {
      paramContext = b.eHL().aGL(paramString);
      AppMethodBeat.o(20093);
      return paramContext;
    }
    paramContext = paramContext.getString(2131761718);
    AppMethodBeat.o(20093);
    return paramContext;
  }
  
  public static String f(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(20072);
    if (w.pF(paramString1))
    {
      paramString2 = bi.uf(paramString2);
      if (paramString2 != null) {
        paramString2 = v.sh(paramString2.trim());
      }
    }
    while (paramString1.contains("@bottle"))
    {
      paramContext = paramContext.getResources().getQuantityString(2131623959, 1, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(20072);
      return paramContext;
      paramString2 = v.sh(paramString1);
      continue;
      paramString2 = v.sh(paramString1);
    }
    String str = paramString2;
    if (bt.isNullOrNil(paramString2))
    {
      str = paramString2;
      if (w.pF(paramString1)) {
        str = paramContext.getString(2131757293);
      }
    }
    paramContext = b.eHL().aGL(str);
    AppMethodBeat.o(20072);
    return paramContext;
  }
  
  private static String f(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(20080);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)) || (bt.isNullOrNil(paramString3)))
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
  
  private static TextPaint getTextPaint()
  {
    AppMethodBeat.i(20089);
    if (fmd == null)
    {
      AppMethodBeat.o(20089);
      return null;
    }
    TextPaint localTextPaint = (TextPaint)fmd.get();
    AppMethodBeat.o(20089);
    return localTextPaint;
  }
  
  public static void kE(int paramInt)
  {
    fme = paramInt;
  }
  
  public static void kF(int paramInt)
  {
    fmf = paramInt;
  }
  
  private static String oC(String paramString)
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
  
  private static String oD(String paramString)
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
  
  private static boolean oE(String paramString)
  {
    AppMethodBeat.i(20083);
    if ((w.sJ(paramString)) && (!u.ara()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    if ((w.sL(paramString)) && (!u.aqT()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    if ((w.sP(paramString)) && (!u.ard()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    AppMethodBeat.o(20083);
    return false;
  }
  
  public static String oF(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.h
 * JD-Core Version:    0.7.0.1
 */