package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.d;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.ag;
import com.tencent.mm.cf.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.lang.ref.WeakReference;

public final class h
{
  private static WeakReference<TextPaint> fHF;
  private static int fHG = 0;
  private static int fHH = 0;
  public String fHE = "";
  public String mDesc = "";
  public String mTitle = "";
  
  private static int E(String paramString, int paramInt)
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
  
  private static int XA()
  {
    AppMethodBeat.i(169682);
    if (fHH > 0)
    {
      i = fHH;
      AppMethodBeat.o(169682);
      return i;
    }
    int i = BackwardSupportUtil.b.g(aj.getContext(), 14.0F);
    AppMethodBeat.o(169682);
    return i;
  }
  
  private static int XB()
  {
    AppMethodBeat.i(20087);
    if (fHG > 0)
    {
      i = fHG;
      AppMethodBeat.o(20087);
      return i;
    }
    int i = BackwardSupportUtil.b.g(aj.getContext(), 200.0F);
    AppMethodBeat.o(20087);
    return i;
  }
  
  private static CharSequence a(String paramString, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(20086);
    paramString = TextUtils.ellipsize(com.tencent.mm.pluginsdk.ui.span.k.b(aj.getContext(), paramString, XA()), paramTextPaint, XB(), TextUtils.TruncateAt.END);
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
    if ((w.zJ(paramString1)) || (w.zL(paramString1)))
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
            if (!am.aSN(paramString1))
            {
              str2 = str3;
              str1 = paramString2;
              if (!am.aSP(paramString1)) {}
            }
            else
            {
              str2 = v.zf(paramString1);
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
      if (!am.aSN(paramString1))
      {
        str2 = str3;
        str1 = paramString2;
        if (!am.aSP(paramString1)) {
          break;
        }
      }
      v.zf(paramString1);
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
      String str = b.fmR().aRK(paramString);
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
    paramContext = com.tencent.mm.pluginsdk.ui.span.k.aNi(b.fmR().aRK(paramContext));
    AppMethodBeat.o(20071);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt, bu parambu)
  {
    AppMethodBeat.i(20073);
    if (TextUtils.isEmpty(paramString2)) {
      parambu = null;
    }
    for (;;)
    {
      paramString1 = parambu;
      if (bt.isNullOrNil(parambu))
      {
        if (!f.vF(paramString2)) {
          break;
        }
        paramString1 = paramContext.getString(2131757293);
      }
      paramContext = b.fmR().aRK(paramString1);
      AppMethodBeat.o(20073);
      return paramContext;
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (!b(paramString2, parambu)) {
              continue;
            }
            if (parambu == null) {
              continue;
            }
            localObject1 = ag.aGb().bd(parambu.field_bizChatId);
            if (((com.tencent.mm.am.a.c)localObject1).isGroup()) {
              if (bt.isNullOrNil(((com.tencent.mm.am.a.c)localObject1).field_chatName)) {
                localObject1 = aj.getContext().getString(2131762623);
              }
            }
          }
          catch (Throwable parambu)
          {
            boolean bool;
            am localam;
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
            parambu = (bu)localObject1;
            if (!bool) {
              break;
            }
          }
          catch (Throwable parambu) {}
        }
        ba.aBQ();
        localam = com.tencent.mm.model.c.azp().Bf(paramString2);
        if (localam != null) {
          continue;
        }
        parambu = null;
        break;
        localObject1 = ((com.tencent.mm.am.a.c)localObject1).field_chatName;
        continue;
        parambu = ag.aGd().eK(parambu.field_bizChatUserId);
        if (parambu == null) {
          continue;
        }
        localObject1 = parambu.field_userName;
      }
      localObject2 = localObject1;
      if (paramInt == 318767153)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject2 = ((a)com.tencent.mm.kernel.g.ab(a.class)).aB(paramString1, paramString2);
          parambu = (bu)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
        }
      }
      if (w.Ak(paramString2))
      {
        parambu = localam.adu();
      }
      else
      {
        if (am.zs(paramString2))
        {
          localObject1 = aj.getContext();
          if (localam != null) {
            if (RegionCodeDecoder.aUp(localam.getCountryCode()))
            {
              paramString1 = localam.getCity();
              if (bt.isNullOrNil(paramString1)) {}
            }
          }
          for (;;)
          {
            parambu = paramContext.getString(2131756698, new Object[] { paramString1 }).trim();
            break;
            parambu = v.zh(localam.getProvince());
            paramString1 = parambu;
            if (bt.isNullOrNil(parambu))
            {
              RegionCodeDecoder.fsz();
              paramString1 = RegionCodeDecoder.getLocName(localam.getCountryCode());
              continue;
              parambu = v.zh(localam.getProvince());
              paramString1 = parambu;
              if (bt.isNullOrNil(parambu)) {
                paramString1 = ((Context)localObject1).getString(2131756727);
              }
            }
          }
        }
        if ((f.vF(paramString2)) && (bt.isNullOrNil(localam.field_nickname)) && (bt.isNullOrNil(localam.field_conRemark)))
        {
          ba.aBQ();
          paramString1 = com.tencent.mm.model.c.azz().zf(paramString2);
          parambu = (bu)localObject2;
          if (!bt.isNullOrNil(paramString1)) {
            parambu = paramString1;
          }
        }
        else
        {
          parambu = (bu)localObject2;
          if (localam.adv() != null)
          {
            parambu = (bu)localObject2;
            if (localam.adv().length() > 0) {
              parambu = localam.adv();
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
    //   50: invokestatic 373	com/tencent/mm/booter/notification/a/h:ux	(Ljava/lang/String;)Z
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
    //   86: invokestatic 377	com/tencent/mm/model/w:zP	(Ljava/lang/String;)Z
    //   89: ifeq +31 -> 120
    //   92: iload 9
    //   94: ifeq +12 -> 106
    //   97: ldc_w 360
    //   100: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: ldc 26
    //   105: areturn
    //   106: aload 5
    //   108: invokestatic 381	com/tencent/mm/booter/notification/a/h:bS	(Landroid/content/Context;)Ljava/lang/String;
    //   111: astore_0
    //   112: ldc_w 360
    //   115: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_0
    //   119: areturn
    //   120: aload_3
    //   121: ifnull +9277 -> 9398
    //   124: iload 9
    //   126: ifeq +9272 -> 9398
    //   129: aload_3
    //   130: invokestatic 384	com/tencent/mm/booter/notification/a/h:uv	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_3
    //   134: iconst_1
    //   135: istore 15
    //   137: aload 6
    //   139: aload_3
    //   140: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   143: iload_1
    //   144: ifne +9240 -> 9384
    //   147: aload_2
    //   148: invokestatic 385	com/tencent/mm/model/w:vF	(Ljava/lang/String;)Z
    //   151: ifne +10 -> 161
    //   154: aload_2
    //   155: invokestatic 388	com/tencent/mm/model/w:zl	(Ljava/lang/String;)Z
    //   158: ifeq +9226 -> 9384
    //   161: aload_3
    //   162: invokestatic 393	com/tencent/mm/model/bj:Bh	(Ljava/lang/String;)I
    //   165: istore 13
    //   167: iload 13
    //   169: ifle +9215 -> 9384
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
    //   222: istore 14
    //   224: aload_2
    //   225: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   228: ifne +10 -> 238
    //   231: aload_2
    //   232: invokestatic 404	com/tencent/mm/model/w:Am	(Ljava/lang/String;)Z
    //   235: ifeq +649 -> 884
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
    //   285: lookupswitch	default:+555->840, -1879048191:+1292->1577, -1879048190:+1292->1577, -1879048189:+1292->1577, -1879048188:+1398->1683, -1879048186:+3768->4053, -1879048185:+3922->4207, -1879048183:+3922->4207, -1879048176:+3922->4207, 3:+706->991, 11:+913->1198, 13:+880->1165, 23:+706->991, 33:+706->991, 34:+939->1224, 35:+1758->2043, 36:+913->1198, 37:+1419->1704, 39:+880->1165, 40:+1675->1960, 42:+1829->2114, 43:+1105->1390, 47:+788->1073, 48:+2089->2374, 49:+5101->5386, 50:+1313->1598, 52:+1377->1662, 53:+1313->1598, 55:+7737->8022, 57:+7737->8022, 62:+1105->1390, 66:+1829->2114, 1048625:+788->1073, 12299999:+1271->1556, 16777265:+5101->5386, 268435505:+5101->5386, 285212721:+7610->7895, 318767153:+7673->7958, 335544369:+2216->2501, 369098801:+3208->3493, 402653233:+2329->2614, 419430449:+2413->2698, 436207665:+2758->3043, 452984881:+3359->3644, 469762097:+2758->3043, 486539313:+1105->1390, 503316529:+7763->8048, 520093745:+3569->3854, 536870961:+2981->3266, 553648177:+5101->5386, 570425393:+7847->8132, 587202609:+5101->5386, 603979825:+7970->8255, 671088689:+3110->3395, 687865905:+5101->5386, 704643121:+4023->4308, 721420337:+8008->8293, 738197553:+5101->5386, 754974769:+4158->4443, 771751985:+4544->4829, 788529201:+4719->5004, 805306417:+5101->5386, 822083633:+5101->5386, 838860849:+4331->4616, 855638065:+5023->5308, 872415281:+8035->8320, 889192497:+4945->5230, 922746929:+4945->5230, 939524145:+4770->5055
    //   841: astore_0
    //   842: ldc 26
    //   844: astore_3
    //   845: aconst_null
    //   846: astore 18
    //   848: iconst_0
    //   849: istore 13
    //   851: aload_2
    //   852: invokestatic 407	com/tencent/mm/model/w:zK	(Ljava/lang/String;)Z
    //   855: ifeq +7858 -> 8713
    //   858: iconst_1
    //   859: iload_1
    //   860: if_icmpne +7571 -> 8431
    //   863: aload_3
    //   864: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   867: ifne +7515 -> 8382
    //   870: aload 6
    //   872: aload_3
    //   873: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   876: ldc_w 360
    //   879: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   882: aload_3
    //   883: areturn
    //   884: iload 14
    //   886: istore 13
    //   888: aload_2
    //   889: invokestatic 410	com/tencent/mm/model/w:Ao	(Ljava/lang/String;)Z
    //   892: ifne +8485 -> 9377
    //   895: invokestatic 257	com/tencent/mm/model/ba:aBQ	()Lcom/tencent/mm/model/c;
    //   898: pop
    //   899: invokestatic 414	com/tencent/mm/model/c:azv	()Lcom/tencent/mm/storage/bq;
    //   902: aload_2
    //   903: invokeinterface 420 2 0
    //   908: astore 18
    //   910: aload 18
    //   912: ifnull +14 -> 926
    //   915: aload 18
    //   917: ldc_w 421
    //   920: invokevirtual 427	com/tencent/mm/storage/at:lQ	(I)Z
    //   923: ifne +12 -> 935
    //   926: iload 14
    //   928: istore 13
    //   930: iload 10
    //   932: ifeq +8445 -> 9377
    //   935: iconst_1
    //   936: istore 14
    //   938: iload 14
    //   940: istore 13
    //   942: aload_3
    //   943: ifnull +8434 -> 9377
    //   946: aload_3
    //   947: ldc 123
    //   949: invokevirtual 127	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   952: istore 16
    //   954: iload 14
    //   956: istore 13
    //   958: iload 16
    //   960: iconst_m1
    //   961: if_icmpeq +8416 -> 9377
    //   964: aload 7
    //   966: aload_3
    //   967: iconst_0
    //   968: iload 16
    //   970: invokevirtual 131	java/lang/String:substring	(II)Ljava/lang/String;
    //   973: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   976: aload_3
    //   977: iload 16
    //   979: iconst_1
    //   980: iadd
    //   981: invokevirtual 150	java/lang/String:substring	(I)Ljava/lang/String;
    //   984: astore_3
    //   985: iconst_1
    //   986: istore 14
    //   988: goto -705 -> 283
    //   991: aload 5
    //   993: ldc_w 428
    //   996: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   999: astore 21
    //   1001: aload 19
    //   1003: invokevirtual 46	java/lang/String:length	()I
    //   1006: ifle +55 -> 1061
    //   1009: new 152	java/lang/StringBuilder
    //   1012: dup
    //   1013: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1016: aload 19
    //   1018: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: ldc_w 430
    //   1024: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1030: astore_0
    //   1031: aload 19
    //   1033: invokevirtual 46	java/lang/String:length	()I
    //   1036: ifle +31 -> 1067
    //   1039: ldc_w 432
    //   1042: astore_3
    //   1043: aload 6
    //   1045: aload_3
    //   1046: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1049: aconst_null
    //   1050: astore 18
    //   1052: iconst_0
    //   1053: istore 13
    //   1055: aload 21
    //   1057: astore_3
    //   1058: goto -207 -> 851
    //   1061: ldc 26
    //   1063: astore_0
    //   1064: goto -33 -> 1031
    //   1067: ldc 26
    //   1069: astore_3
    //   1070: goto -27 -> 1043
    //   1073: aload_3
    //   1074: invokestatic 438	com/tencent/mm/storage/ay:aTS	(Ljava/lang/String;)Lcom/tencent/mm/storage/ay;
    //   1077: astore 21
    //   1079: new 152	java/lang/StringBuilder
    //   1082: dup
    //   1083: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1086: aload 21
    //   1088: invokevirtual 441	com/tencent/mm/storage/ay:aMS	()Ljava/lang/String;
    //   1091: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: ldc_w 430
    //   1097: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1103: astore 18
    //   1105: aload_0
    //   1106: ifnull +47 -> 1153
    //   1109: aload_0
    //   1110: invokevirtual 46	java/lang/String:length	()I
    //   1113: bipush 32
    //   1115: if_icmpne +38 -> 1153
    //   1118: aload_0
    //   1119: astore_3
    //   1120: aload 6
    //   1122: ldc 26
    //   1124: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1127: aload 7
    //   1129: aload 21
    //   1131: invokevirtual 441	com/tencent/mm/storage/ay:aMS	()Ljava/lang/String;
    //   1134: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1137: aconst_null
    //   1138: astore 21
    //   1140: iconst_0
    //   1141: istore 13
    //   1143: aload 18
    //   1145: astore_0
    //   1146: aload 21
    //   1148: astore 18
    //   1150: goto -299 -> 851
    //   1153: aload 5
    //   1155: ldc_w 442
    //   1158: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1161: astore_3
    //   1162: goto -42 -> 1120
    //   1165: aload 5
    //   1167: iload_1
    //   1168: aload_2
    //   1169: aload_3
    //   1170: aload 5
    //   1172: ldc_w 428
    //   1175: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1178: aload 6
    //   1180: aload 7
    //   1182: invokestatic 444	com/tencent/mm/booter/notification/a/h:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;)Ljava/lang/String;
    //   1185: astore_0
    //   1186: ldc 26
    //   1188: astore_3
    //   1189: aconst_null
    //   1190: astore 18
    //   1192: iconst_0
    //   1193: istore 13
    //   1195: goto -344 -> 851
    //   1198: aload 5
    //   1200: iload_1
    //   1201: aload_2
    //   1202: aload_3
    //   1203: aconst_null
    //   1204: aload 6
    //   1206: aload 7
    //   1208: invokestatic 444	com/tencent/mm/booter/notification/a/h:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;)Ljava/lang/String;
    //   1211: astore_0
    //   1212: ldc 26
    //   1214: astore_3
    //   1215: aconst_null
    //   1216: astore 18
    //   1218: iconst_0
    //   1219: istore 13
    //   1221: goto -370 -> 851
    //   1224: aload_2
    //   1225: invokestatic 136	com/tencent/mm/storage/am:aSN	(Ljava/lang/String;)Z
    //   1228: ifne +24 -> 1252
    //   1231: aload_2
    //   1232: invokestatic 139	com/tencent/mm/storage/am:aSP	(Ljava/lang/String;)Z
    //   1235: ifne +17 -> 1252
    //   1238: aload_2
    //   1239: invokestatic 118	com/tencent/mm/model/w:zJ	(Ljava/lang/String;)Z
    //   1242: ifne +10 -> 1252
    //   1245: aload_2
    //   1246: invokestatic 121	com/tencent/mm/model/w:zL	(Ljava/lang/String;)Z
    //   1249: ifeq +36 -> 1285
    //   1252: aload 5
    //   1254: iload_1
    //   1255: aload_2
    //   1256: aload_3
    //   1257: aload 5
    //   1259: ldc_w 445
    //   1262: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1265: aload 6
    //   1267: aload 7
    //   1269: invokestatic 444	com/tencent/mm/booter/notification/a/h:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;)Ljava/lang/String;
    //   1272: astore_0
    //   1273: ldc 26
    //   1275: astore_3
    //   1276: aconst_null
    //   1277: astore 18
    //   1279: iconst_0
    //   1280: istore 13
    //   1282: goto -431 -> 851
    //   1285: aload_3
    //   1286: astore_0
    //   1287: aload_3
    //   1288: ifnull +78 -> 1366
    //   1291: aload_3
    //   1292: astore_0
    //   1293: aload_3
    //   1294: invokevirtual 46	java/lang/String:length	()I
    //   1297: ifle +69 -> 1366
    //   1300: aload_3
    //   1301: astore_0
    //   1302: aload_2
    //   1303: invokestatic 407	com/tencent/mm/model/w:zK	(Ljava/lang/String;)Z
    //   1306: ifne +60 -> 1366
    //   1309: aload_2
    //   1310: invokestatic 385	com/tencent/mm/model/w:vF	(Ljava/lang/String;)Z
    //   1313: ifeq +71 -> 1384
    //   1316: new 447	com/tencent/mm/modelvoice/p
    //   1319: dup
    //   1320: aload_3
    //   1321: invokespecial 450	com/tencent/mm/modelvoice/p:<init>	(Ljava/lang/String;)V
    //   1324: astore_3
    //   1325: new 152	java/lang/StringBuilder
    //   1328: dup
    //   1329: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1332: aload_3
    //   1333: invokevirtual 451	com/tencent/mm/modelvoice/p:aMS	()Ljava/lang/String;
    //   1336: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: ldc_w 430
    //   1342: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1348: astore_0
    //   1349: aload 6
    //   1351: ldc_w 453
    //   1354: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1357: aload 7
    //   1359: aload_3
    //   1360: invokevirtual 451	com/tencent/mm/modelvoice/p:aMS	()Ljava/lang/String;
    //   1363: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1366: aload 5
    //   1368: ldc_w 445
    //   1371: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1374: astore_3
    //   1375: aconst_null
    //   1376: astore 18
    //   1378: iconst_0
    //   1379: istore 13
    //   1381: goto -530 -> 851
    //   1384: ldc 26
    //   1386: astore_0
    //   1387: goto -21 -> 1366
    //   1390: aload_2
    //   1391: invokestatic 136	com/tencent/mm/storage/am:aSN	(Ljava/lang/String;)Z
    //   1394: ifne +24 -> 1418
    //   1397: aload_2
    //   1398: invokestatic 139	com/tencent/mm/storage/am:aSP	(Ljava/lang/String;)Z
    //   1401: ifne +17 -> 1418
    //   1404: aload_2
    //   1405: invokestatic 118	com/tencent/mm/model/w:zJ	(Ljava/lang/String;)Z
    //   1408: ifne +10 -> 1418
    //   1411: aload_2
    //   1412: invokestatic 121	com/tencent/mm/model/w:zL	(Ljava/lang/String;)Z
    //   1415: ifeq +36 -> 1451
    //   1418: aload 5
    //   1420: iload_1
    //   1421: aload_2
    //   1422: aload_3
    //   1423: aload 5
    //   1425: ldc_w 454
    //   1428: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1431: aload 6
    //   1433: aload 7
    //   1435: invokestatic 444	com/tencent/mm/booter/notification/a/h:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;)Ljava/lang/String;
    //   1438: astore_0
    //   1439: ldc 26
    //   1441: astore_3
    //   1442: aconst_null
    //   1443: astore 18
    //   1445: iconst_0
    //   1446: istore 13
    //   1448: goto -597 -> 851
    //   1451: aload_3
    //   1452: astore_0
    //   1453: aload_3
    //   1454: ifnull +78 -> 1532
    //   1457: aload_3
    //   1458: astore_0
    //   1459: aload_3
    //   1460: invokevirtual 46	java/lang/String:length	()I
    //   1463: ifle +69 -> 1532
    //   1466: aload_3
    //   1467: astore_0
    //   1468: aload_2
    //   1469: invokestatic 407	com/tencent/mm/model/w:zK	(Ljava/lang/String;)Z
    //   1472: ifne +60 -> 1532
    //   1475: aload_2
    //   1476: invokestatic 385	com/tencent/mm/model/w:vF	(Ljava/lang/String;)Z
    //   1479: ifeq +71 -> 1550
    //   1482: new 456	com/tencent/mm/modelvideo/q
    //   1485: dup
    //   1486: aload_3
    //   1487: invokespecial 457	com/tencent/mm/modelvideo/q:<init>	(Ljava/lang/String;)V
    //   1490: astore_3
    //   1491: new 152	java/lang/StringBuilder
    //   1494: dup
    //   1495: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1498: aload_3
    //   1499: invokevirtual 458	com/tencent/mm/modelvideo/q:aMS	()Ljava/lang/String;
    //   1502: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1505: ldc_w 430
    //   1508: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1511: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1514: astore_0
    //   1515: aload 6
    //   1517: ldc_w 453
    //   1520: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1523: aload 7
    //   1525: aload_3
    //   1526: invokevirtual 458	com/tencent/mm/modelvideo/q:aMS	()Ljava/lang/String;
    //   1529: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1532: aload 5
    //   1534: ldc_w 454
    //   1537: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1540: astore_3
    //   1541: aconst_null
    //   1542: astore 18
    //   1544: iconst_0
    //   1545: istore 13
    //   1547: goto -696 -> 851
    //   1550: ldc 26
    //   1552: astore_0
    //   1553: goto -21 -> 1532
    //   1556: aload 5
    //   1558: ldc_w 459
    //   1561: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1564: astore_3
    //   1565: aconst_null
    //   1566: astore 18
    //   1568: iconst_0
    //   1569: istore 13
    //   1571: ldc 26
    //   1573: astore_0
    //   1574: goto -723 -> 851
    //   1577: aload 5
    //   1579: ldc_w 460
    //   1582: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1585: astore_3
    //   1586: aconst_null
    //   1587: astore 18
    //   1589: iconst_0
    //   1590: istore 13
    //   1592: ldc 26
    //   1594: astore_0
    //   1595: goto -744 -> 851
    //   1598: aload_3
    //   1599: getstatic 465	com/tencent/mm/storage/bu:IMe	Ljava/lang/String;
    //   1602: invokevirtual 469	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1605: ifeq +24 -> 1629
    //   1608: aload 5
    //   1610: ldc_w 459
    //   1613: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1616: astore_3
    //   1617: aconst_null
    //   1618: astore 18
    //   1620: iconst_0
    //   1621: istore 13
    //   1623: ldc 26
    //   1625: astore_0
    //   1626: goto -775 -> 851
    //   1629: aload_3
    //   1630: astore_0
    //   1631: aload_3
    //   1632: getstatic 472	com/tencent/mm/storage/bu:IMd	Ljava/lang/String;
    //   1635: invokevirtual 469	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1638: ifeq -796 -> 842
    //   1641: aload 5
    //   1643: ldc_w 473
    //   1646: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1649: astore_3
    //   1650: aconst_null
    //   1651: astore 18
    //   1653: iconst_0
    //   1654: istore 13
    //   1656: ldc 26
    //   1658: astore_0
    //   1659: goto -808 -> 851
    //   1662: aload 5
    //   1664: ldc_w 459
    //   1667: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1670: astore_3
    //   1671: aconst_null
    //   1672: astore 18
    //   1674: iconst_0
    //   1675: istore 13
    //   1677: ldc 26
    //   1679: astore_0
    //   1680: goto -829 -> 851
    //   1683: aload 5
    //   1685: ldc_w 473
    //   1688: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   1691: astore_3
    //   1692: aconst_null
    //   1693: astore 18
    //   1695: iconst_0
    //   1696: istore 13
    //   1698: ldc 26
    //   1700: astore_0
    //   1701: goto -850 -> 851
    //   1704: aload_3
    //   1705: astore_0
    //   1706: aload_3
    //   1707: ifnull -865 -> 842
    //   1710: aload_3
    //   1711: astore_0
    //   1712: aload_3
    //   1713: invokevirtual 46	java/lang/String:length	()I
    //   1716: ifle -874 -> 842
    //   1719: aload_3
    //   1720: invokestatic 479	com/tencent/mm/storage/bu$d:aUe	(Ljava/lang/String;)Lcom/tencent/mm/storage/bu$d;
    //   1723: astore 18
    //   1725: aload_3
    //   1726: astore_0
    //   1727: aload 18
    //   1729: invokevirtual 482	com/tencent/mm/storage/bu$d:fsr	()Ljava/lang/String;
    //   1732: ifnull +111 -> 1843
    //   1735: aload_3
    //   1736: astore_0
    //   1737: aload 18
    //   1739: invokevirtual 482	com/tencent/mm/storage/bu$d:fsr	()Ljava/lang/String;
    //   1742: invokevirtual 46	java/lang/String:length	()I
    //   1745: ifle +98 -> 1843
    //   1748: aload 18
    //   1750: invokevirtual 485	com/tencent/mm/storage/bu$d:getScene	()I
    //   1753: tableswitch	default:+63 -> 1816, 18:+102->1855, 19:+63->1816, 20:+63->1816, 21:+63->1816, 22:+135->1888, 23:+135->1888, 24:+135->1888, 25:+168->1921, 26:+135->1888, 27:+135->1888, 28:+135->1888, 29:+135->1888
    //   1817: iconst_2
    //   1818: ldc_w 486
    //   1821: iconst_1
    //   1822: anewarray 4	java/lang/Object
    //   1825: dup
    //   1826: iconst_0
    //   1827: aload 18
    //   1829: invokevirtual 488	com/tencent/mm/storage/bu$d:getDisplayName	()Ljava/lang/String;
    //   1832: aastore
    //   1833: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1836: astore_0
    //   1837: aload 6
    //   1839: aload_0
    //   1840: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1843: ldc 26
    //   1845: astore_3
    //   1846: aconst_null
    //   1847: astore 18
    //   1849: iconst_0
    //   1850: istore 13
    //   1852: goto -1001 -> 851
    //   1855: aload 5
    //   1857: ldc_w 489
    //   1860: iconst_1
    //   1861: anewarray 4	java/lang/Object
    //   1864: dup
    //   1865: iconst_0
    //   1866: aload 18
    //   1868: invokevirtual 488	com/tencent/mm/storage/bu$d:getDisplayName	()Ljava/lang/String;
    //   1871: aastore
    //   1872: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1875: astore_0
    //   1876: ldc 26
    //   1878: astore_3
    //   1879: aconst_null
    //   1880: astore 18
    //   1882: iconst_0
    //   1883: istore 13
    //   1885: goto -1034 -> 851
    //   1888: aload 5
    //   1890: ldc_w 490
    //   1893: iconst_1
    //   1894: anewarray 4	java/lang/Object
    //   1897: dup
    //   1898: iconst_0
    //   1899: aload 18
    //   1901: invokevirtual 488	com/tencent/mm/storage/bu$d:getDisplayName	()Ljava/lang/String;
    //   1904: aastore
    //   1905: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1908: astore_0
    //   1909: ldc 26
    //   1911: astore_3
    //   1912: aconst_null
    //   1913: astore 18
    //   1915: iconst_0
    //   1916: istore 13
    //   1918: goto -1067 -> 851
    //   1921: aload 5
    //   1923: ldc_w 491
    //   1926: iconst_1
    //   1927: anewarray 4	java/lang/Object
    //   1930: dup
    //   1931: iconst_0
    //   1932: aload 18
    //   1934: invokevirtual 488	com/tencent/mm/storage/bu$d:getDisplayName	()Ljava/lang/String;
    //   1937: aastore
    //   1938: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1941: astore_0
    //   1942: aload 6
    //   1944: aload_0
    //   1945: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1948: ldc 26
    //   1950: astore_3
    //   1951: aconst_null
    //   1952: astore 18
    //   1954: iconst_0
    //   1955: istore 13
    //   1957: goto -1106 -> 851
    //   1960: aload_3
    //   1961: astore_0
    //   1962: aload_3
    //   1963: ifnull -1121 -> 842
    //   1966: aload_3
    //   1967: astore_0
    //   1968: aload_3
    //   1969: invokevirtual 46	java/lang/String:length	()I
    //   1972: ifle -1130 -> 842
    //   1975: aload_3
    //   1976: invokestatic 497	com/tencent/mm/storage/bu$a:aUb	(Ljava/lang/String;)Lcom/tencent/mm/storage/bu$a;
    //   1979: astore 18
    //   1981: aload_3
    //   1982: astore_0
    //   1983: aload 18
    //   1985: invokevirtual 498	com/tencent/mm/storage/bu$a:fsr	()Ljava/lang/String;
    //   1988: ifnull +43 -> 2031
    //   1991: aload_3
    //   1992: astore_0
    //   1993: aload 18
    //   1995: invokevirtual 498	com/tencent/mm/storage/bu$a:fsr	()Ljava/lang/String;
    //   1998: invokevirtual 46	java/lang/String:length	()I
    //   2001: ifle +30 -> 2031
    //   2004: aload 5
    //   2006: ldc_w 499
    //   2009: iconst_1
    //   2010: anewarray 4	java/lang/Object
    //   2013: dup
    //   2014: iconst_0
    //   2015: aload 18
    //   2017: invokevirtual 500	com/tencent/mm/storage/bu$a:getDisplayName	()Ljava/lang/String;
    //   2020: aastore
    //   2021: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2024: astore_0
    //   2025: aload 6
    //   2027: aload_0
    //   2028: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2031: ldc 26
    //   2033: astore_3
    //   2034: aconst_null
    //   2035: astore 18
    //   2037: iconst_0
    //   2038: istore 13
    //   2040: goto -1189 -> 851
    //   2043: aload_3
    //   2044: astore_0
    //   2045: aload_3
    //   2046: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2049: invokevirtual 46	java/lang/String:length	()I
    //   2052: ifle -1210 -> 842
    //   2055: invokestatic 257	com/tencent/mm/model/ba:aBQ	()Lcom/tencent/mm/model/c;
    //   2058: pop
    //   2059: invokestatic 504	com/tencent/mm/model/c:azs	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
    //   2062: aload_3
    //   2063: invokeinterface 510 2 0
    //   2068: astore_0
    //   2069: aload 5
    //   2071: ldc_w 511
    //   2074: iconst_2
    //   2075: anewarray 4	java/lang/Object
    //   2078: dup
    //   2079: iconst_0
    //   2080: aload_0
    //   2081: invokevirtual 516	com/tencent/mm/storage/bu$c:getSender	()Ljava/lang/String;
    //   2084: aastore
    //   2085: dup
    //   2086: iconst_1
    //   2087: aload_0
    //   2088: invokevirtual 519	com/tencent/mm/storage/bu$c:getTitle	()Ljava/lang/String;
    //   2091: aastore
    //   2092: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2095: astore_0
    //   2096: aload 6
    //   2098: aload_0
    //   2099: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2102: ldc 26
    //   2104: astore_3
    //   2105: aconst_null
    //   2106: astore 18
    //   2108: iconst_0
    //   2109: istore 13
    //   2111: goto -1260 -> 851
    //   2114: aload_3
    //   2115: astore_0
    //   2116: aload_3
    //   2117: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2120: invokevirtual 46	java/lang/String:length	()I
    //   2123: ifle -1281 -> 842
    //   2126: aload_2
    //   2127: invokestatic 385	com/tencent/mm/model/w:vF	(Ljava/lang/String;)Z
    //   2130: ifeq +20 -> 2150
    //   2133: aload_3
    //   2134: invokestatic 522	com/tencent/mm/model/bj:Bk	(Ljava/lang/String;)Ljava/lang/String;
    //   2137: astore 18
    //   2139: aload 18
    //   2141: astore_0
    //   2142: aload 18
    //   2144: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2147: ifeq +5 -> 2152
    //   2150: aload_2
    //   2151: astore_0
    //   2152: invokestatic 257	com/tencent/mm/model/ba:aBQ	()Lcom/tencent/mm/model/c;
    //   2155: pop
    //   2156: invokestatic 504	com/tencent/mm/model/c:azs	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
    //   2159: aload_3
    //   2160: invokeinterface 525 2 0
    //   2165: astore 21
    //   2167: invokestatic 257	com/tencent/mm/model/ba:aBQ	()Lcom/tencent/mm/model/c;
    //   2170: pop
    //   2171: invokestatic 263	com/tencent/mm/model/c:azp	()Lcom/tencent/mm/storage/bp;
    //   2174: aload_0
    //   2175: invokeinterface 269 2 0
    //   2180: invokevirtual 356	com/tencent/mm/storage/am:adv	()Ljava/lang/String;
    //   2183: astore 18
    //   2185: aload 18
    //   2187: astore_3
    //   2188: aload 18
    //   2190: invokestatic 385	com/tencent/mm/model/w:vF	(Ljava/lang/String;)Z
    //   2193: ifeq +12 -> 2205
    //   2196: aload 18
    //   2198: invokestatic 531	com/tencent/mm/model/q:yT	(Ljava/lang/String;)Ljava/util/List;
    //   2201: invokestatic 535	com/tencent/mm/model/q:ae	(Ljava/util/List;)Ljava/lang/String;
    //   2204: astore_3
    //   2205: iload_1
    //   2206: iconst_1
    //   2207: if_icmpne +85 -> 2292
    //   2210: aload 5
    //   2212: ldc_w 536
    //   2215: iconst_2
    //   2216: anewarray 4	java/lang/Object
    //   2219: dup
    //   2220: iconst_0
    //   2221: aload_3
    //   2222: aastore
    //   2223: dup
    //   2224: iconst_1
    //   2225: aload 21
    //   2227: invokevirtual 500	com/tencent/mm/storage/bu$a:getDisplayName	()Ljava/lang/String;
    //   2230: aastore
    //   2231: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2234: astore 18
    //   2236: aload 6
    //   2238: aload 5
    //   2240: ldc_w 536
    //   2243: iconst_2
    //   2244: anewarray 4	java/lang/Object
    //   2247: dup
    //   2248: iconst_0
    //   2249: ldc_w 538
    //   2252: aastore
    //   2253: dup
    //   2254: iconst_1
    //   2255: aload 21
    //   2257: invokevirtual 500	com/tencent/mm/storage/bu$a:getDisplayName	()Ljava/lang/String;
    //   2260: aastore
    //   2261: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2264: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2267: aload 7
    //   2269: aload_0
    //   2270: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2273: ldc 26
    //   2275: astore_3
    //   2276: aconst_null
    //   2277: astore 21
    //   2279: iconst_0
    //   2280: istore 13
    //   2282: aload 18
    //   2284: astore_0
    //   2285: aload 21
    //   2287: astore 18
    //   2289: goto -1438 -> 851
    //   2292: aload 5
    //   2294: ldc_w 539
    //   2297: iconst_2
    //   2298: anewarray 4	java/lang/Object
    //   2301: dup
    //   2302: iconst_0
    //   2303: aload_3
    //   2304: aastore
    //   2305: dup
    //   2306: iconst_1
    //   2307: aload 21
    //   2309: invokevirtual 500	com/tencent/mm/storage/bu$a:getDisplayName	()Ljava/lang/String;
    //   2312: aastore
    //   2313: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2316: astore 18
    //   2318: aload 6
    //   2320: aload 5
    //   2322: ldc_w 539
    //   2325: iconst_2
    //   2326: anewarray 4	java/lang/Object
    //   2329: dup
    //   2330: iconst_0
    //   2331: ldc_w 538
    //   2334: aastore
    //   2335: dup
    //   2336: iconst_1
    //   2337: aload 21
    //   2339: invokevirtual 500	com/tencent/mm/storage/bu$a:getDisplayName	()Ljava/lang/String;
    //   2342: aastore
    //   2343: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2346: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2349: aload 7
    //   2351: aload_0
    //   2352: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2355: ldc 26
    //   2357: astore_3
    //   2358: aconst_null
    //   2359: astore 21
    //   2361: iconst_0
    //   2362: istore 13
    //   2364: aload 18
    //   2366: astore_0
    //   2367: aload 21
    //   2369: astore 18
    //   2371: goto -1520 -> 851
    //   2374: aload_3
    //   2375: astore_0
    //   2376: aload_3
    //   2377: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2380: invokevirtual 46	java/lang/String:length	()I
    //   2383: ifle -1541 -> 842
    //   2386: aload_2
    //   2387: invokestatic 385	com/tencent/mm/model/w:vF	(Ljava/lang/String;)Z
    //   2390: ifeq +6982 -> 9372
    //   2393: aload_3
    //   2394: invokestatic 393	com/tencent/mm/model/bj:Bh	(Ljava/lang/String;)I
    //   2397: istore 13
    //   2399: iload 13
    //   2401: iconst_m1
    //   2402: if_icmpeq +6965 -> 9367
    //   2405: aload_3
    //   2406: iconst_0
    //   2407: iload 13
    //   2409: invokevirtual 131	java/lang/String:substring	(II)Ljava/lang/String;
    //   2412: invokevirtual 324	java/lang/String:trim	()Ljava/lang/String;
    //   2415: astore_0
    //   2416: aload_3
    //   2417: invokestatic 542	com/tencent/mm/model/bj:Bl	(Ljava/lang/String;)Ljava/lang/String;
    //   2420: pop
    //   2421: iload_1
    //   2422: iconst_1
    //   2423: if_icmpne +30 -> 2453
    //   2426: aload 5
    //   2428: ldc_w 543
    //   2431: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2434: astore_0
    //   2435: aload 6
    //   2437: aload_0
    //   2438: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2441: ldc 26
    //   2443: astore_3
    //   2444: aconst_null
    //   2445: astore 18
    //   2447: iconst_0
    //   2448: istore 13
    //   2450: goto -1599 -> 851
    //   2453: aload 5
    //   2455: ldc_w 543
    //   2458: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2461: astore 18
    //   2463: aload 6
    //   2465: aload 5
    //   2467: ldc_w 543
    //   2470: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2473: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2476: aload 7
    //   2478: aload_0
    //   2479: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2482: ldc 26
    //   2484: astore_3
    //   2485: aconst_null
    //   2486: astore 21
    //   2488: iconst_0
    //   2489: istore 13
    //   2491: aload 18
    //   2493: astore_0
    //   2494: aload 21
    //   2496: astore 18
    //   2498: goto -1647 -> 851
    //   2501: aload 21
    //   2503: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   2506: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   2509: astore_0
    //   2510: aload_0
    //   2511: getfield 555	com/tencent/mm/ai/k$b:hAn	I
    //   2514: ifeq +88 -> 2602
    //   2517: aload_0
    //   2518: getfield 555	com/tencent/mm/ai/k$b:hAn	I
    //   2521: iconst_1
    //   2522: if_icmpne +40 -> 2562
    //   2525: aload 5
    //   2527: ldc_w 556
    //   2530: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2533: astore_0
    //   2534: aload 7
    //   2536: aload 19
    //   2538: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2541: aload 6
    //   2543: ldc 26
    //   2545: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2548: aload_0
    //   2549: astore_3
    //   2550: aconst_null
    //   2551: astore 18
    //   2553: iconst_0
    //   2554: istore 13
    //   2556: ldc 26
    //   2558: astore_0
    //   2559: goto -1708 -> 851
    //   2562: aload_0
    //   2563: getfield 555	com/tencent/mm/ai/k$b:hAn	I
    //   2566: iconst_2
    //   2567: if_icmpne +15 -> 2582
    //   2570: aload 5
    //   2572: ldc_w 557
    //   2575: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2578: astore_0
    //   2579: goto -45 -> 2534
    //   2582: aload_0
    //   2583: getfield 555	com/tencent/mm/ai/k$b:hAn	I
    //   2586: iconst_3
    //   2587: if_icmpne +15 -> 2602
    //   2590: aload 5
    //   2592: ldc_w 558
    //   2595: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2598: astore_0
    //   2599: goto -65 -> 2534
    //   2602: aload 5
    //   2604: ldc_w 559
    //   2607: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2610: astore_0
    //   2611: goto -77 -> 2534
    //   2614: aload 21
    //   2616: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   2619: astore 18
    //   2621: ldc 26
    //   2623: astore_3
    //   2624: ldc 26
    //   2626: astore_0
    //   2627: aload 18
    //   2629: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   2632: astore 18
    //   2634: aload 18
    //   2636: ifnull +46 -> 2682
    //   2639: aload 6
    //   2641: new 152	java/lang/StringBuilder
    //   2644: dup
    //   2645: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   2648: aload 5
    //   2650: ldc_w 560
    //   2653: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2656: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2659: aload 18
    //   2661: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   2664: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2667: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2670: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2673: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2676: aload 6
    //   2678: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2681: astore_0
    //   2682: aload 7
    //   2684: aload 19
    //   2686: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2689: aconst_null
    //   2690: astore 18
    //   2692: iconst_0
    //   2693: istore 13
    //   2695: goto -1844 -> 851
    //   2698: aload 21
    //   2700: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   2703: astore 18
    //   2705: ldc 26
    //   2707: astore_3
    //   2708: ldc 26
    //   2710: astore_0
    //   2711: aload 18
    //   2713: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   2716: astore 18
    //   2718: aload 18
    //   2720: ifnull +79 -> 2799
    //   2723: iload_1
    //   2724: iconst_1
    //   2725: if_icmpne +90 -> 2815
    //   2728: iconst_1
    //   2729: istore 13
    //   2731: aload 18
    //   2733: getfield 566	com/tencent/mm/ai/k$b:hAU	I
    //   2736: tableswitch	default:+44 -> 2780, 1:+85->2821, 2:+270->3006, 3:+122->2858, 4:+159->2895, 5:+196->2932, 6:+233->2969, 7:+85->2821
    //   2781: iconst_3
    //   2782: aload 18
    //   2784: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   2787: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2790: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2793: aload 6
    //   2795: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2798: astore_0
    //   2799: aload 7
    //   2801: aload 19
    //   2803: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2806: aconst_null
    //   2807: astore 18
    //   2809: iconst_0
    //   2810: istore 13
    //   2812: goto -1961 -> 851
    //   2815: iconst_0
    //   2816: istore 13
    //   2818: goto -87 -> 2731
    //   2821: iload 13
    //   2823: ifeq +19 -> 2842
    //   2826: aload 6
    //   2828: aload 5
    //   2830: ldc_w 567
    //   2833: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2836: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2839: goto -46 -> 2793
    //   2842: aload 6
    //   2844: aload 5
    //   2846: ldc_w 568
    //   2849: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2852: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2855: goto -62 -> 2793
    //   2858: iload 13
    //   2860: ifeq +19 -> 2879
    //   2863: aload 6
    //   2865: aload 5
    //   2867: ldc_w 569
    //   2870: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2873: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2876: goto -83 -> 2793
    //   2879: aload 6
    //   2881: aload 5
    //   2883: ldc_w 570
    //   2886: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2889: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2892: goto -99 -> 2793
    //   2895: iload 13
    //   2897: ifeq +19 -> 2916
    //   2900: aload 6
    //   2902: aload 5
    //   2904: ldc_w 571
    //   2907: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2910: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2913: goto -120 -> 2793
    //   2916: aload 6
    //   2918: aload 5
    //   2920: ldc_w 572
    //   2923: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2926: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2929: goto -136 -> 2793
    //   2932: iload 13
    //   2934: ifeq +19 -> 2953
    //   2937: aload 6
    //   2939: aload 5
    //   2941: ldc_w 573
    //   2944: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2947: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2950: goto -157 -> 2793
    //   2953: aload 6
    //   2955: aload 5
    //   2957: ldc_w 570
    //   2960: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2963: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2966: goto -173 -> 2793
    //   2969: iload 13
    //   2971: ifeq +19 -> 2990
    //   2974: aload 6
    //   2976: aload 5
    //   2978: ldc_w 574
    //   2981: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   2984: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2987: goto -194 -> 2793
    //   2990: aload 6
    //   2992: aload 5
    //   2994: ldc_w 574
    //   2997: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   3000: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3003: goto -210 -> 2793
    //   3006: iload 13
    //   3008: ifeq +19 -> 3027
    //   3011: aload 6
    //   3013: aload 5
    //   3015: ldc_w 575
    //   3018: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   3021: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3024: goto -231 -> 2793
    //   3027: aload 6
    //   3029: aload 5
    //   3031: ldc_w 575
    //   3034: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   3037: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3040: goto -247 -> 2793
    //   3043: aload 21
    //   3045: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   3048: astore_0
    //   3049: ldc 26
    //   3051: astore 21
    //   3053: ldc 26
    //   3055: astore_3
    //   3056: aload_0
    //   3057: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   3060: astore_0
    //   3061: aload_0
    //   3062: ifnull +60 -> 3122
    //   3065: iload_1
    //   3066: iconst_1
    //   3067: if_icmpne +92 -> 3159
    //   3070: iconst_1
    //   3071: istore 13
    //   3073: iload 13
    //   3075: ifeq +90 -> 3165
    //   3078: aload 6
    //   3080: new 152	java/lang/StringBuilder
    //   3083: dup
    //   3084: ldc_w 577
    //   3087: invokespecial 578	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3090: aload_0
    //   3091: getfield 581	com/tencent/mm/ai/k$b:hBu	Ljava/lang/String;
    //   3094: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3097: ldc_w 583
    //   3100: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3103: aload_0
    //   3104: getfield 586	com/tencent/mm/ai/k$b:hBr	Ljava/lang/String;
    //   3107: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3110: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3113: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3116: aload 6
    //   3118: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3121: astore_3
    //   3122: aload_3
    //   3123: astore_0
    //   3124: aload_2
    //   3125: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   3128: ifne +6195 -> 9323
    //   3131: aload_3
    //   3132: astore_0
    //   3133: iload 14
    //   3135: ifne +6188 -> 9323
    //   3138: aload 7
    //   3140: aload 19
    //   3142: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3145: aconst_null
    //   3146: astore 18
    //   3148: iconst_0
    //   3149: istore 13
    //   3151: aload_3
    //   3152: astore_0
    //   3153: aload 21
    //   3155: astore_3
    //   3156: goto -2305 -> 851
    //   3159: iconst_0
    //   3160: istore 13
    //   3162: goto -89 -> 3073
    //   3165: aload 20
    //   3167: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   3170: ifne +55 -> 3225
    //   3173: aload 6
    //   3175: new 152	java/lang/StringBuilder
    //   3178: dup
    //   3179: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3182: aload 20
    //   3184: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   3187: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3190: ldc_w 588
    //   3193: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3196: aload_0
    //   3197: getfield 581	com/tencent/mm/ai/k$b:hBu	Ljava/lang/String;
    //   3200: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3203: ldc_w 583
    //   3206: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3209: aload_0
    //   3210: getfield 591	com/tencent/mm/ai/k$b:hBq	Ljava/lang/String;
    //   3213: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3216: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3219: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3222: goto -106 -> 3116
    //   3225: aload 6
    //   3227: new 152	java/lang/StringBuilder
    //   3230: dup
    //   3231: ldc_w 577
    //   3234: invokespecial 578	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3237: aload_0
    //   3238: getfield 581	com/tencent/mm/ai/k$b:hBu	Ljava/lang/String;
    //   3241: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3244: ldc_w 583
    //   3247: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3250: aload_0
    //   3251: getfield 591	com/tencent/mm/ai/k$b:hBq	Ljava/lang/String;
    //   3254: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3257: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3260: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3263: goto -147 -> 3116
    //   3266: aload 21
    //   3268: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   3271: astore 18
    //   3273: ldc 26
    //   3275: astore_3
    //   3276: ldc 26
    //   3278: astore_0
    //   3279: aload 18
    //   3281: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   3284: astore 18
    //   3286: aload 18
    //   3288: ifnull +6035 -> 9323
    //   3291: aload 18
    //   3293: ldc_w 593
    //   3296: invokevirtual 597	com/tencent/mm/ai/k$b:ao	(Ljava/lang/Class;)Lcom/tencent/mm/ai/f;
    //   3299: checkcast 593	com/tencent/mm/ai/b
    //   3302: astore_0
    //   3303: iload_1
    //   3304: iconst_1
    //   3305: if_icmpne +57 -> 3362
    //   3308: iconst_1
    //   3309: istore 13
    //   3311: iload 13
    //   3313: ifeq +55 -> 3368
    //   3316: aload 6
    //   3318: aload 5
    //   3320: ldc_w 598
    //   3323: iconst_1
    //   3324: anewarray 4	java/lang/Object
    //   3327: dup
    //   3328: iconst_0
    //   3329: aload_0
    //   3330: getfield 601	com/tencent/mm/ai/b:hyM	Ljava/lang/String;
    //   3333: aastore
    //   3334: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3337: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3340: aload 6
    //   3342: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3345: astore_0
    //   3346: aload 7
    //   3348: aload 19
    //   3350: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3353: aconst_null
    //   3354: astore 18
    //   3356: iconst_0
    //   3357: istore 13
    //   3359: goto -2508 -> 851
    //   3362: iconst_0
    //   3363: istore 13
    //   3365: goto -54 -> 3311
    //   3368: aload 6
    //   3370: aload 5
    //   3372: ldc_w 598
    //   3375: iconst_1
    //   3376: anewarray 4	java/lang/Object
    //   3379: dup
    //   3380: iconst_0
    //   3381: aload_0
    //   3382: getfield 604	com/tencent/mm/ai/b:hyN	Ljava/lang/String;
    //   3385: aastore
    //   3386: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3389: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3392: goto -52 -> 3340
    //   3395: aload 21
    //   3397: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   3400: astore_3
    //   3401: ldc 26
    //   3403: astore_0
    //   3404: aload_3
    //   3405: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   3408: astore_3
    //   3409: aload_3
    //   3410: ifnull +42 -> 3452
    //   3413: aload_3
    //   3414: ldc_w 606
    //   3417: invokevirtual 597	com/tencent/mm/ai/k$b:ao	(Ljava/lang/Class;)Lcom/tencent/mm/ai/f;
    //   3420: checkcast 606	com/tencent/mm/ui/chatting/viewitems/k$a
    //   3423: astore_0
    //   3424: aload_0
    //   3425: getfield 609	com/tencent/mm/ui/chatting/viewitems/k$a:state	I
    //   3428: iconst_1
    //   3429: if_icmpne +41 -> 3470
    //   3432: aload 5
    //   3434: ldc_w 610
    //   3437: iconst_1
    //   3438: anewarray 4	java/lang/Object
    //   3441: dup
    //   3442: iconst_0
    //   3443: aload_0
    //   3444: getfield 613	com/tencent/mm/ui/chatting/viewitems/k$a:appName	Ljava/lang/String;
    //   3447: aastore
    //   3448: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3451: astore_0
    //   3452: aload 6
    //   3454: aload_0
    //   3455: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3458: ldc 26
    //   3460: astore_3
    //   3461: aconst_null
    //   3462: astore 18
    //   3464: iconst_0
    //   3465: istore 13
    //   3467: goto -2616 -> 851
    //   3470: aload 5
    //   3472: ldc_w 614
    //   3475: iconst_1
    //   3476: anewarray 4	java/lang/Object
    //   3479: dup
    //   3480: iconst_0
    //   3481: aload_0
    //   3482: getfield 613	com/tencent/mm/ui/chatting/viewitems/k$a:appName	Ljava/lang/String;
    //   3485: aastore
    //   3486: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3489: astore_0
    //   3490: goto -38 -> 3452
    //   3493: aload 21
    //   3495: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   3498: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   3501: getfield 555	com/tencent/mm/ai/k$b:hAn	I
    //   3504: lookupswitch	default:+28->3532, 10000:+110->3614, 20000:+122->3626
    //   3533: iconst_2
    //   3534: ldc_w 615
    //   3537: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   3540: astore_0
    //   3541: aload 19
    //   3543: invokevirtual 46	java/lang/String:length	()I
    //   3546: ifle +92 -> 3638
    //   3549: new 152	java/lang/StringBuilder
    //   3552: dup
    //   3553: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3556: aload 19
    //   3558: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3561: ldc_w 430
    //   3564: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3567: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3570: astore_3
    //   3571: aload_2
    //   3572: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   3575: ifne +15 -> 3590
    //   3578: iload 14
    //   3580: ifne +10 -> 3590
    //   3583: aload 7
    //   3585: aload 19
    //   3587: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3590: aload 6
    //   3592: ldc 26
    //   3594: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3597: aload_0
    //   3598: astore 21
    //   3600: aconst_null
    //   3601: astore 18
    //   3603: iconst_0
    //   3604: istore 13
    //   3606: aload_3
    //   3607: astore_0
    //   3608: aload 21
    //   3610: astore_3
    //   3611: goto -2760 -> 851
    //   3614: aload 5
    //   3616: ldc_w 616
    //   3619: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   3622: astore_0
    //   3623: goto -82 -> 3541
    //   3626: aload 5
    //   3628: ldc_w 617
    //   3631: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   3634: astore_0
    //   3635: goto -94 -> 3541
    //   3638: ldc 26
    //   3640: astore_3
    //   3641: goto -70 -> 3571
    //   3644: aload 21
    //   3646: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   3649: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   3652: astore_3
    //   3653: aload_3
    //   3654: ifnonnull +21 -> 3675
    //   3657: ldc_w 619
    //   3660: ldc_w 621
    //   3663: invokestatic 627	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3666: ldc_w 360
    //   3669: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3672: ldc 26
    //   3674: areturn
    //   3675: ldc 26
    //   3677: astore 21
    //   3679: aload 5
    //   3681: ldc_w 628
    //   3684: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   3687: astore 18
    //   3689: aload 19
    //   3691: invokevirtual 46	java/lang/String:length	()I
    //   3694: ifle +108 -> 3802
    //   3697: new 152	java/lang/StringBuilder
    //   3700: dup
    //   3701: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3704: aload 19
    //   3706: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3709: ldc_w 430
    //   3712: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3715: aload 18
    //   3717: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3720: aload_3
    //   3721: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   3724: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3727: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3730: astore_0
    //   3731: aload_2
    //   3732: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   3735: ifne +15 -> 3750
    //   3738: iload 14
    //   3740: ifne +10 -> 3750
    //   3743: aload 7
    //   3745: aload 19
    //   3747: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3750: aload 19
    //   3752: invokevirtual 46	java/lang/String:length	()I
    //   3755: ifle +73 -> 3828
    //   3758: new 152	java/lang/StringBuilder
    //   3761: dup
    //   3762: ldc_w 432
    //   3765: invokespecial 578	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3768: aload 18
    //   3770: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3773: aload_3
    //   3774: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   3777: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3780: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3783: astore_3
    //   3784: aload 6
    //   3786: aload_3
    //   3787: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3790: aconst_null
    //   3791: astore 18
    //   3793: iconst_0
    //   3794: istore 13
    //   3796: aload 21
    //   3798: astore_3
    //   3799: goto -2948 -> 851
    //   3802: new 152	java/lang/StringBuilder
    //   3805: dup
    //   3806: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3809: aload 18
    //   3811: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3814: aload_3
    //   3815: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   3818: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3821: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3824: astore_0
    //   3825: goto -94 -> 3731
    //   3828: new 152	java/lang/StringBuilder
    //   3831: dup
    //   3832: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3835: aload 18
    //   3837: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3840: aload_3
    //   3841: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   3844: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3847: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3850: astore_3
    //   3851: goto -67 -> 3784
    //   3854: aload 21
    //   3856: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   3859: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   3862: astore_0
    //   3863: aload_0
    //   3864: ifnonnull +21 -> 3885
    //   3867: ldc_w 619
    //   3870: ldc_w 621
    //   3873: invokestatic 627	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   3876: ldc_w 360
    //   3879: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3882: ldc 26
    //   3884: areturn
    //   3885: ldc 26
    //   3887: astore 21
    //   3889: aload 5
    //   3891: ldc_w 628
    //   3894: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   3897: astore_3
    //   3898: iload_1
    //   3899: iconst_1
    //   3900: if_icmpne +95 -> 3995
    //   3903: new 152	java/lang/StringBuilder
    //   3906: dup
    //   3907: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   3910: aload_3
    //   3911: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3914: aload_0
    //   3915: getfield 631	com/tencent/mm/ai/k$b:hBi	Ljava/lang/String;
    //   3918: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3921: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3924: astore_3
    //   3925: aload 19
    //   3927: invokevirtual 46	java/lang/String:length	()I
    //   3930: ifle +57 -> 3987
    //   3933: ldc_w 432
    //   3936: aload_3
    //   3937: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3940: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   3943: astore_0
    //   3944: aload 6
    //   3946: aload_0
    //   3947: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3950: aload_3
    //   3951: astore_0
    //   3952: aload_2
    //   3953: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   3956: ifne +5367 -> 9323
    //   3959: aload_3
    //   3960: astore_0
    //   3961: iload 14
    //   3963: ifne +5360 -> 9323
    //   3966: aload 7
    //   3968: aload 19
    //   3970: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3973: aconst_null
    //   3974: astore 18
    //   3976: iconst_0
    //   3977: istore 13
    //   3979: aload_3
    //   3980: astore_0
    //   3981: aload 21
    //   3983: astore_3
    //   3984: goto -3133 -> 851
    //   3987: aload_3
    //   3988: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3991: astore_0
    //   3992: goto -48 -> 3944
    //   3995: new 152	java/lang/StringBuilder
    //   3998: dup
    //   3999: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   4002: aload_3
    //   4003: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4006: aload_0
    //   4007: getfield 640	com/tencent/mm/ai/k$b:hBh	Ljava/lang/String;
    //   4010: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4013: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4016: astore_3
    //   4017: aload 19
    //   4019: invokevirtual 46	java/lang/String:length	()I
    //   4022: ifle +23 -> 4045
    //   4025: ldc_w 432
    //   4028: aload_3
    //   4029: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4032: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4035: astore_0
    //   4036: aload 6
    //   4038: aload_0
    //   4039: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4042: goto -92 -> 3950
    //   4045: aload_3
    //   4046: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4049: astore_0
    //   4050: goto -14 -> 4036
    //   4053: aload 21
    //   4055: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   4058: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   4061: astore_3
    //   4062: aload_3
    //   4063: ifnonnull +21 -> 4084
    //   4066: ldc_w 619
    //   4069: ldc_w 621
    //   4072: invokestatic 627	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4075: ldc_w 360
    //   4078: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4081: ldc 26
    //   4083: areturn
    //   4084: ldc 26
    //   4086: astore 21
    //   4088: aload 19
    //   4090: invokevirtual 46	java/lang/String:length	()I
    //   4093: ifle +98 -> 4191
    //   4096: new 152	java/lang/StringBuilder
    //   4099: dup
    //   4100: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   4103: aload 19
    //   4105: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4108: ldc_w 430
    //   4111: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4114: aload_3
    //   4115: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   4118: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4121: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4124: astore_0
    //   4125: aload_2
    //   4126: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   4129: ifne +15 -> 4144
    //   4132: iload 14
    //   4134: ifne +10 -> 4144
    //   4137: aload 7
    //   4139: aload 19
    //   4141: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4144: aload 19
    //   4146: invokevirtual 46	java/lang/String:length	()I
    //   4149: ifle +50 -> 4199
    //   4152: new 152	java/lang/StringBuilder
    //   4155: dup
    //   4156: ldc_w 432
    //   4159: invokespecial 578	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4162: aload_3
    //   4163: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   4166: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4169: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4172: astore_3
    //   4173: aload 6
    //   4175: aload_3
    //   4176: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4179: aconst_null
    //   4180: astore 18
    //   4182: iconst_0
    //   4183: istore 13
    //   4185: aload 21
    //   4187: astore_3
    //   4188: goto -3337 -> 851
    //   4191: aload_3
    //   4192: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   4195: astore_0
    //   4196: goto -71 -> 4125
    //   4199: aload_3
    //   4200: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   4203: astore_3
    //   4204: goto -31 -> 4173
    //   4207: aload 5
    //   4209: ldc_w 641
    //   4212: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   4215: astore 21
    //   4217: aload 19
    //   4219: invokevirtual 46	java/lang/String:length	()I
    //   4222: ifle +74 -> 4296
    //   4225: new 152	java/lang/StringBuilder
    //   4228: dup
    //   4229: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   4232: aload 19
    //   4234: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4237: ldc_w 430
    //   4240: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4243: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4246: astore_0
    //   4247: aload_2
    //   4248: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   4251: ifne +15 -> 4266
    //   4254: iload 14
    //   4256: ifne +10 -> 4266
    //   4259: aload 7
    //   4261: aload 19
    //   4263: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4266: aload 19
    //   4268: invokevirtual 46	java/lang/String:length	()I
    //   4271: ifle +31 -> 4302
    //   4274: ldc_w 432
    //   4277: astore_3
    //   4278: aload 6
    //   4280: aload_3
    //   4281: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4284: aconst_null
    //   4285: astore 18
    //   4287: iconst_0
    //   4288: istore 13
    //   4290: aload 21
    //   4292: astore_3
    //   4293: goto -3442 -> 851
    //   4296: ldc 26
    //   4298: astore_0
    //   4299: goto -52 -> 4247
    //   4302: ldc 26
    //   4304: astore_3
    //   4305: goto -27 -> 4278
    //   4308: aload 21
    //   4310: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   4313: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   4316: astore_0
    //   4317: aload_0
    //   4318: ifnonnull +21 -> 4339
    //   4321: ldc_w 619
    //   4324: ldc_w 621
    //   4327: invokestatic 627	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4330: ldc_w 360
    //   4333: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4336: ldc 26
    //   4338: areturn
    //   4339: ldc 26
    //   4341: astore 21
    //   4343: aload_0
    //   4344: getfield 644	com/tencent/mm/ai/k$b:content	Ljava/lang/String;
    //   4347: ldc_w 646
    //   4350: invokestatic 651	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4353: astore_0
    //   4354: aload_0
    //   4355: astore_3
    //   4356: aload_0
    //   4357: invokestatic 204	com/tencent/mm/pluginsdk/ui/span/k:aNi	(Ljava/lang/String;)Ljava/lang/String;
    //   4360: astore_0
    //   4361: aload_2
    //   4362: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   4365: ifne +15 -> 4380
    //   4368: iload 14
    //   4370: ifne +10 -> 4380
    //   4373: aload 7
    //   4375: aload 19
    //   4377: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4380: aload 19
    //   4382: invokevirtual 46	java/lang/String:length	()I
    //   4385: ifle +53 -> 4438
    //   4388: ldc_w 432
    //   4391: aload_0
    //   4392: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4395: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4398: astore_3
    //   4399: aload 6
    //   4401: aload_3
    //   4402: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4405: aconst_null
    //   4406: astore 18
    //   4408: iconst_0
    //   4409: istore 13
    //   4411: aload 21
    //   4413: astore_3
    //   4414: goto -3563 -> 851
    //   4417: astore 18
    //   4419: aload_3
    //   4420: astore_0
    //   4421: ldc_w 619
    //   4424: aload 18
    //   4426: ldc 26
    //   4428: iconst_0
    //   4429: anewarray 4	java/lang/Object
    //   4432: invokestatic 655	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4435: goto -74 -> 4361
    //   4438: aload_0
    //   4439: astore_3
    //   4440: goto -41 -> 4399
    //   4443: ldc 26
    //   4445: astore 22
    //   4447: aload 21
    //   4449: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   4452: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   4455: astore_3
    //   4456: aload_3
    //   4457: ifnonnull +21 -> 4478
    //   4460: ldc_w 619
    //   4463: ldc_w 621
    //   4466: invokestatic 627	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4469: ldc_w 360
    //   4472: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4475: ldc 26
    //   4477: areturn
    //   4478: aload_2
    //   4479: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   4482: ifne +15 -> 4497
    //   4485: iload 14
    //   4487: ifne +10 -> 4497
    //   4490: aload 7
    //   4492: aload 19
    //   4494: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4497: aload 5
    //   4499: ldc_w 656
    //   4502: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   4505: astore_0
    //   4506: aload_3
    //   4507: ldc_w 658
    //   4510: invokevirtual 597	com/tencent/mm/ai/k$b:ao	(Ljava/lang/Class;)Lcom/tencent/mm/ai/f;
    //   4513: checkcast 658	com/tencent/mm/plugin/i/a/b
    //   4516: astore_3
    //   4517: aload_3
    //   4518: ifnull +4846 -> 9364
    //   4521: aload_3
    //   4522: invokevirtual 662	com/tencent/mm/plugin/i/a/b:cOZ	()Lcom/tencent/mm/protocal/protobuf/arj;
    //   4525: getfield 667	com/tencent/mm/protocal/protobuf/arj:nickname	Ljava/lang/String;
    //   4528: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   4531: ifne +4833 -> 9364
    //   4534: new 152	java/lang/StringBuilder
    //   4537: dup
    //   4538: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   4541: aload_0
    //   4542: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4545: aload 5
    //   4547: ldc_w 668
    //   4550: iconst_1
    //   4551: anewarray 4	java/lang/Object
    //   4554: dup
    //   4555: iconst_0
    //   4556: aload_3
    //   4557: invokevirtual 662	com/tencent/mm/plugin/i/a/b:cOZ	()Lcom/tencent/mm/protocal/protobuf/arj;
    //   4560: getfield 667	com/tencent/mm/protocal/protobuf/arj:nickname	Ljava/lang/String;
    //   4563: aastore
    //   4564: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   4567: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4570: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4573: astore_0
    //   4574: aload 19
    //   4576: invokevirtual 46	java/lang/String:length	()I
    //   4579: ifle +32 -> 4611
    //   4582: ldc_w 432
    //   4585: aload_0
    //   4586: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4589: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4592: astore_3
    //   4593: aload 6
    //   4595: aload_3
    //   4596: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4599: aconst_null
    //   4600: astore 18
    //   4602: iconst_0
    //   4603: istore 13
    //   4605: aload 22
    //   4607: astore_3
    //   4608: goto -3757 -> 851
    //   4611: aload_0
    //   4612: astore_3
    //   4613: goto -20 -> 4593
    //   4616: ldc 26
    //   4618: astore 22
    //   4620: aload 21
    //   4622: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   4625: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   4628: astore_3
    //   4629: aload_3
    //   4630: ifnonnull +21 -> 4651
    //   4633: ldc_w 619
    //   4636: ldc_w 621
    //   4639: invokestatic 627	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4642: ldc_w 360
    //   4645: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4648: ldc 26
    //   4650: areturn
    //   4651: aload_2
    //   4652: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   4655: ifne +15 -> 4670
    //   4658: iload 14
    //   4660: ifne +10 -> 4670
    //   4663: aload 7
    //   4665: aload 19
    //   4667: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4670: aload 5
    //   4672: ldc_w 656
    //   4675: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   4678: astore_0
    //   4679: aload_3
    //   4680: ldc_w 670
    //   4683: invokevirtual 597	com/tencent/mm/ai/k$b:ao	(Ljava/lang/Class;)Lcom/tencent/mm/ai/f;
    //   4686: checkcast 670	com/tencent/mm/plugin/i/a/c
    //   4689: astore_3
    //   4690: aload_3
    //   4691: ifnull +4670 -> 9361
    //   4694: aload_3
    //   4695: invokevirtual 674	com/tencent/mm/plugin/i/a/c:cPa	()Lcom/tencent/mm/protocal/protobuf/ark;
    //   4698: getfield 679	com/tencent/mm/protocal/protobuf/ark:dzZ	Ljava/lang/String;
    //   4701: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   4704: ifne +4657 -> 9361
    //   4707: aload_3
    //   4708: invokevirtual 674	com/tencent/mm/plugin/i/a/c:cPa	()Lcom/tencent/mm/protocal/protobuf/ark;
    //   4711: getfield 682	com/tencent/mm/protocal/protobuf/ark:sMj	I
    //   4714: iconst_1
    //   4715: if_icmpne +81 -> 4796
    //   4718: new 152	java/lang/StringBuilder
    //   4721: dup
    //   4722: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   4725: aload_0
    //   4726: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4729: invokestatic 61	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   4732: ldc_w 683
    //   4735: iconst_1
    //   4736: anewarray 4	java/lang/Object
    //   4739: dup
    //   4740: iconst_0
    //   4741: aload_3
    //   4742: invokevirtual 674	com/tencent/mm/plugin/i/a/c:cPa	()Lcom/tencent/mm/protocal/protobuf/ark;
    //   4745: getfield 679	com/tencent/mm/protocal/protobuf/ark:dzZ	Ljava/lang/String;
    //   4748: aastore
    //   4749: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   4752: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4755: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4758: astore_0
    //   4759: aload 19
    //   4761: invokevirtual 46	java/lang/String:length	()I
    //   4764: ifle +60 -> 4824
    //   4767: ldc_w 432
    //   4770: aload_0
    //   4771: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4774: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4777: astore_3
    //   4778: aload 6
    //   4780: aload_3
    //   4781: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4784: aconst_null
    //   4785: astore 18
    //   4787: iconst_0
    //   4788: istore 13
    //   4790: aload 22
    //   4792: astore_3
    //   4793: goto -3942 -> 851
    //   4796: new 152	java/lang/StringBuilder
    //   4799: dup
    //   4800: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   4803: aload_0
    //   4804: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4807: aload_3
    //   4808: invokevirtual 674	com/tencent/mm/plugin/i/a/c:cPa	()Lcom/tencent/mm/protocal/protobuf/ark;
    //   4811: getfield 679	com/tencent/mm/protocal/protobuf/ark:dzZ	Ljava/lang/String;
    //   4814: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4817: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4820: astore_0
    //   4821: goto -62 -> 4759
    //   4824: aload_0
    //   4825: astore_3
    //   4826: goto -48 -> 4778
    //   4829: ldc 26
    //   4831: astore 22
    //   4833: aload 21
    //   4835: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   4838: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   4841: astore_0
    //   4842: aload_0
    //   4843: ifnonnull +21 -> 4864
    //   4846: ldc_w 619
    //   4849: ldc_w 621
    //   4852: invokestatic 627	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4855: ldc_w 360
    //   4858: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4861: ldc 26
    //   4863: areturn
    //   4864: aload_0
    //   4865: ldc_w 685
    //   4868: invokevirtual 597	com/tencent/mm/ai/k$b:ao	(Ljava/lang/Class;)Lcom/tencent/mm/ai/f;
    //   4871: checkcast 685	com/tencent/mm/plugin/i/a/a
    //   4874: astore_0
    //   4875: aload_0
    //   4876: ifnull +4479 -> 9355
    //   4879: aload_0
    //   4880: invokevirtual 688	com/tencent/mm/plugin/i/a/a:VC	()Ljava/lang/String;
    //   4883: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   4886: ifne +4469 -> 9355
    //   4889: iload_1
    //   4890: iconst_1
    //   4891: if_icmpne +60 -> 4951
    //   4894: aload 5
    //   4896: ldc_w 689
    //   4899: iconst_1
    //   4900: anewarray 4	java/lang/Object
    //   4903: dup
    //   4904: iconst_0
    //   4905: aload_0
    //   4906: invokevirtual 688	com/tencent/mm/plugin/i/a/a:VC	()Ljava/lang/String;
    //   4909: aastore
    //   4910: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   4913: astore_0
    //   4914: aload 19
    //   4916: invokevirtual 46	java/lang/String:length	()I
    //   4919: ifle +80 -> 4999
    //   4922: ldc_w 432
    //   4925: aload_0
    //   4926: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4929: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4932: astore_3
    //   4933: aload 6
    //   4935: aload_3
    //   4936: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4939: aconst_null
    //   4940: astore 18
    //   4942: iconst_0
    //   4943: istore 13
    //   4945: aload 22
    //   4947: astore_3
    //   4948: goto -4097 -> 851
    //   4951: aload 5
    //   4953: ldc_w 690
    //   4956: iconst_1
    //   4957: anewarray 4	java/lang/Object
    //   4960: dup
    //   4961: iconst_0
    //   4962: aload_0
    //   4963: invokevirtual 688	com/tencent/mm/plugin/i/a/a:VC	()Ljava/lang/String;
    //   4966: aastore
    //   4967: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   4970: astore_3
    //   4971: aload_3
    //   4972: astore_0
    //   4973: aload_2
    //   4974: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   4977: ifne -63 -> 4914
    //   4980: aload_3
    //   4981: astore_0
    //   4982: iload 14
    //   4984: ifne -70 -> 4914
    //   4987: aload 7
    //   4989: aload 19
    //   4991: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4994: aload_3
    //   4995: astore_0
    //   4996: goto -82 -> 4914
    //   4999: aload_0
    //   5000: astore_3
    //   5001: goto -68 -> 4933
    //   5004: new 152	java/lang/StringBuilder
    //   5007: dup
    //   5008: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   5011: aload 5
    //   5013: ldc_w 691
    //   5016: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   5019: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5022: aload 5
    //   5024: ldc_w 692
    //   5027: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   5030: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5033: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5036: astore_0
    //   5037: aload 6
    //   5039: aload_0
    //   5040: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5043: ldc 26
    //   5045: astore_3
    //   5046: aconst_null
    //   5047: astore 18
    //   5049: iconst_0
    //   5050: istore 13
    //   5052: goto -4201 -> 851
    //   5055: ldc 26
    //   5057: astore 22
    //   5059: aload 21
    //   5061: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   5064: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   5067: astore_0
    //   5068: aload_0
    //   5069: ifnonnull +21 -> 5090
    //   5072: ldc_w 619
    //   5075: ldc_w 621
    //   5078: invokestatic 627	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5081: ldc_w 360
    //   5084: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5087: ldc 26
    //   5089: areturn
    //   5090: aload_0
    //   5091: ldc_w 694
    //   5094: invokevirtual 597	com/tencent/mm/ai/k$b:ao	(Ljava/lang/Class;)Lcom/tencent/mm/ai/f;
    //   5097: checkcast 694	com/tencent/mm/plugin/game/luggage/e/a
    //   5100: astore_0
    //   5101: aload_0
    //   5102: ifnull +4247 -> 9349
    //   5105: aload_0
    //   5106: getfield 697	com/tencent/mm/plugin/game/luggage/e/a:bVF	Ljava/lang/String;
    //   5109: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   5112: ifne +4237 -> 9349
    //   5115: iload_1
    //   5116: iconst_1
    //   5117: if_icmpne +60 -> 5177
    //   5120: aload 5
    //   5122: ldc_w 698
    //   5125: iconst_1
    //   5126: anewarray 4	java/lang/Object
    //   5129: dup
    //   5130: iconst_0
    //   5131: aload_0
    //   5132: getfield 697	com/tencent/mm/plugin/game/luggage/e/a:bVF	Ljava/lang/String;
    //   5135: aastore
    //   5136: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   5139: astore_0
    //   5140: aload 19
    //   5142: invokevirtual 46	java/lang/String:length	()I
    //   5145: ifle +80 -> 5225
    //   5148: ldc_w 432
    //   5151: aload_0
    //   5152: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5155: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   5158: astore_3
    //   5159: aload 6
    //   5161: aload_3
    //   5162: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5165: aconst_null
    //   5166: astore 18
    //   5168: iconst_0
    //   5169: istore 13
    //   5171: aload 22
    //   5173: astore_3
    //   5174: goto -4323 -> 851
    //   5177: aload 5
    //   5179: ldc_w 699
    //   5182: iconst_1
    //   5183: anewarray 4	java/lang/Object
    //   5186: dup
    //   5187: iconst_0
    //   5188: aload_0
    //   5189: getfield 697	com/tencent/mm/plugin/game/luggage/e/a:bVF	Ljava/lang/String;
    //   5192: aastore
    //   5193: invokevirtual 159	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   5196: astore_3
    //   5197: aload_3
    //   5198: astore_0
    //   5199: aload_2
    //   5200: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   5203: ifne -63 -> 5140
    //   5206: aload_3
    //   5207: astore_0
    //   5208: iload 14
    //   5210: ifne -70 -> 5140
    //   5213: aload 7
    //   5215: aload 19
    //   5217: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5220: aload_3
    //   5221: astore_0
    //   5222: goto -82 -> 5140
    //   5225: aload_0
    //   5226: astore_3
    //   5227: goto -68 -> 5159
    //   5230: ldc 26
    //   5232: astore 21
    //   5234: ldc_w 701
    //   5237: invokestatic 296	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   5240: checkcast 701	com/tencent/mm/plugin/patmsg/a/b
    //   5243: aload_3
    //   5244: invokeinterface 705 2 0
    //   5249: astore_0
    //   5250: aload_0
    //   5251: getfield 711	com/tencent/mm/protocal/protobuf/cif:vox	Ljava/util/LinkedList;
    //   5254: invokevirtual 716	java/util/LinkedList:size	()I
    //   5257: ifle +4078 -> 9335
    //   5260: aload 6
    //   5262: ldc_w 718
    //   5265: invokestatic 722	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   5268: checkcast 718	com/tencent/mm/plugin/patmsg/PluginPatMsg
    //   5271: aload_0
    //   5272: getfield 711	com/tencent/mm/protocal/protobuf/cif:vox	Ljava/util/LinkedList;
    //   5275: invokevirtual 726	java/util/LinkedList:getLast	()Ljava/lang/Object;
    //   5278: checkcast 728	com/tencent/mm/protocal/protobuf/cig
    //   5281: getfield 731	com/tencent/mm/protocal/protobuf/cig:hEb	Ljava/lang/String;
    //   5284: aload_2
    //   5285: invokevirtual 735	com/tencent/mm/plugin/patmsg/PluginPatMsg:parseDisplayTemplate	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/plugin/patmsg/a/f;
    //   5288: getfield 740	com/tencent/mm/plugin/patmsg/a/f:result	Ljava/lang/String;
    //   5291: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5294: aconst_null
    //   5295: astore 18
    //   5297: iconst_0
    //   5298: istore 13
    //   5300: aload_3
    //   5301: astore_0
    //   5302: aload 21
    //   5304: astore_3
    //   5305: goto -4454 -> 851
    //   5308: aload 21
    //   5310: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   5313: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   5316: astore_0
    //   5317: aload_0
    //   5318: ifnonnull +21 -> 5339
    //   5321: ldc_w 619
    //   5324: ldc_w 621
    //   5327: invokestatic 627	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5330: ldc_w 360
    //   5333: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5336: ldc 26
    //   5338: areturn
    //   5339: new 152	java/lang/StringBuilder
    //   5342: dup
    //   5343: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   5346: aload 5
    //   5348: ldc_w 741
    //   5351: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   5354: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5357: aload_0
    //   5358: invokevirtual 742	com/tencent/mm/ai/k$b:getTitle	()Ljava/lang/String;
    //   5361: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5364: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5367: astore_0
    //   5368: aload 6
    //   5370: aload_0
    //   5371: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5374: ldc 26
    //   5376: astore_3
    //   5377: aconst_null
    //   5378: astore 18
    //   5380: iconst_0
    //   5381: istore 13
    //   5383: goto -4532 -> 851
    //   5386: aload 21
    //   5388: invokestatic 546	com/tencent/mm/sdk/platformtools/bt:aRd	(Ljava/lang/String;)Ljava/lang/String;
    //   5391: astore_0
    //   5392: aload_0
    //   5393: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   5396: astore 18
    //   5398: aload 18
    //   5400: ifnonnull +21 -> 5421
    //   5403: ldc_w 619
    //   5406: ldc_w 621
    //   5409: invokestatic 627	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5412: ldc_w 360
    //   5415: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5418: ldc 26
    //   5420: areturn
    //   5421: aload 18
    //   5423: getfield 745	com/tencent/mm/ai/k$b:type	I
    //   5426: tableswitch	default:+242 -> 5668, 1:+263->5689, 2:+390->5816, 3:+491->5917, 4:+596->6022, 5:+907->6333, 6:+701->6127, 7:+806->6232, 8:+1449->6875, 9:+242->5668, 10:+242->5668, 11:+242->5668, 12:+242->5668, 13:+242->5668, 14:+242->5668, 15:+1529->6955, 16:+2094->7520, 17:+1689->7115, 18:+242->5668, 19:+1816->7242, 20:+242->5668, 21:+242->5668, 22:+242->5668, 23:+242->5668, 24:+1917->7343, 25:+1609->7035, 26:+1529->6955, 27:+1529->6955, 28:+242->5668, 29:+242->5668, 30:+242->5668, 31:+242->5668, 32:+242->5668, 33:+1040->6466, 34:+2239->7665, 35:+242->5668, 36:+1040->6466, 37:+242->5668, 38:+242->5668, 39:+242->5668, 40:+2409->7835, 41:+242->5668, 42:+242->5668, 43:+242->5668, 44:+1225->6651, 45:+242->5668, 46:+1019->6445, 47:+242->5668, 48:+242->5668, 49:+242->5668, 50:+242->5668, 51:+242->5668, 52:+242->5668, 53:+263->5689, 54:+242->5668, 55:+242->5668, 56:+242->5668, 57:+263->5689
    //   5669: iconst_2
    //   5670: ldc_w 641
    //   5673: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   5676: astore_3
    //   5677: aconst_null
    //   5678: astore 18
    //   5680: iconst_0
    //   5681: istore 13
    //   5683: ldc 26
    //   5685: astore_0
    //   5686: goto -4835 -> 851
    //   5689: ldc 26
    //   5691: astore 21
    //   5693: aload 19
    //   5695: invokevirtual 46	java/lang/String:length	()I
    //   5698: ifle +100 -> 5798
    //   5701: new 152	java/lang/StringBuilder
    //   5704: dup
    //   5705: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   5708: aload 19
    //   5710: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5713: ldc_w 430
    //   5716: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5719: aload 18
    //   5721: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   5724: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5727: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5730: astore_0
    //   5731: aload_2
    //   5732: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   5735: ifne +15 -> 5750
    //   5738: iload 14
    //   5740: ifne +10 -> 5750
    //   5743: aload 7
    //   5745: aload 19
    //   5747: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5750: aload 19
    //   5752: invokevirtual 46	java/lang/String:length	()I
    //   5755: ifle +52 -> 5807
    //   5758: new 152	java/lang/StringBuilder
    //   5761: dup
    //   5762: ldc_w 432
    //   5765: invokespecial 578	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5768: aload 18
    //   5770: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   5773: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5776: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5779: astore_3
    //   5780: aload 6
    //   5782: aload_3
    //   5783: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5786: aconst_null
    //   5787: astore 18
    //   5789: iconst_0
    //   5790: istore 13
    //   5792: aload 21
    //   5794: astore_3
    //   5795: goto -4944 -> 851
    //   5798: aload 18
    //   5800: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   5803: astore_0
    //   5804: goto -73 -> 5731
    //   5807: aload 18
    //   5809: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   5812: astore_3
    //   5813: goto -33 -> 5780
    //   5816: aload 5
    //   5818: ldc_w 428
    //   5821: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   5824: astore 21
    //   5826: aload 19
    //   5828: invokevirtual 46	java/lang/String:length	()I
    //   5831: ifle +74 -> 5905
    //   5834: new 152	java/lang/StringBuilder
    //   5837: dup
    //   5838: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   5841: aload 19
    //   5843: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5846: ldc_w 430
    //   5849: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5852: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5855: astore_0
    //   5856: aload_2
    //   5857: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   5860: ifne +15 -> 5875
    //   5863: iload 14
    //   5865: ifne +10 -> 5875
    //   5868: aload 7
    //   5870: aload 19
    //   5872: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5875: aload 19
    //   5877: invokevirtual 46	java/lang/String:length	()I
    //   5880: ifle +31 -> 5911
    //   5883: ldc_w 432
    //   5886: astore_3
    //   5887: aload 6
    //   5889: aload_3
    //   5890: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5893: aconst_null
    //   5894: astore 18
    //   5896: iconst_0
    //   5897: istore 13
    //   5899: aload 21
    //   5901: astore_3
    //   5902: goto -5051 -> 851
    //   5905: ldc 26
    //   5907: astore_0
    //   5908: goto -52 -> 5856
    //   5911: ldc 26
    //   5913: astore_3
    //   5914: goto -27 -> 5887
    //   5917: aload 5
    //   5919: ldc_w 746
    //   5922: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   5925: astore 21
    //   5927: aload 19
    //   5929: invokevirtual 46	java/lang/String:length	()I
    //   5932: ifle +78 -> 6010
    //   5935: new 152	java/lang/StringBuilder
    //   5938: dup
    //   5939: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   5942: aload 19
    //   5944: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5947: ldc_w 430
    //   5950: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5953: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5956: astore_0
    //   5957: aload_2
    //   5958: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   5961: ifne +15 -> 5976
    //   5964: iload 14
    //   5966: ifne +10 -> 5976
    //   5969: aload 7
    //   5971: aload 19
    //   5973: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5976: aload 19
    //   5978: invokevirtual 46	java/lang/String:length	()I
    //   5981: ifle +35 -> 6016
    //   5984: ldc_w 432
    //   5987: astore_3
    //   5988: aload 6
    //   5990: aload_3
    //   5991: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5994: aload 18
    //   5996: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   5999: astore 18
    //   6001: iconst_1
    //   6002: istore 13
    //   6004: aload 21
    //   6006: astore_3
    //   6007: goto -5156 -> 851
    //   6010: ldc 26
    //   6012: astore_0
    //   6013: goto -56 -> 5957
    //   6016: ldc 26
    //   6018: astore_3
    //   6019: goto -31 -> 5988
    //   6022: aload 5
    //   6024: ldc_w 454
    //   6027: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6030: astore 21
    //   6032: aload 19
    //   6034: invokevirtual 46	java/lang/String:length	()I
    //   6037: ifle +78 -> 6115
    //   6040: new 152	java/lang/StringBuilder
    //   6043: dup
    //   6044: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6047: aload 19
    //   6049: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6052: ldc_w 430
    //   6055: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6058: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6061: astore_0
    //   6062: aload_2
    //   6063: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   6066: ifne +15 -> 6081
    //   6069: iload 14
    //   6071: ifne +10 -> 6081
    //   6074: aload 7
    //   6076: aload 19
    //   6078: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6081: aload 19
    //   6083: invokevirtual 46	java/lang/String:length	()I
    //   6086: ifle +35 -> 6121
    //   6089: ldc_w 432
    //   6092: astore_3
    //   6093: aload 6
    //   6095: aload_3
    //   6096: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6099: aload 18
    //   6101: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6104: astore 18
    //   6106: iconst_1
    //   6107: istore 13
    //   6109: aload 21
    //   6111: astore_3
    //   6112: goto -5261 -> 851
    //   6115: ldc 26
    //   6117: astore_0
    //   6118: goto -56 -> 6062
    //   6121: ldc 26
    //   6123: astore_3
    //   6124: goto -31 -> 6093
    //   6127: aload 5
    //   6129: ldc_w 747
    //   6132: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6135: astore 21
    //   6137: aload 19
    //   6139: invokevirtual 46	java/lang/String:length	()I
    //   6142: ifle +78 -> 6220
    //   6145: new 152	java/lang/StringBuilder
    //   6148: dup
    //   6149: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6152: aload 19
    //   6154: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6157: ldc_w 430
    //   6160: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6163: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6166: astore_0
    //   6167: aload_2
    //   6168: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   6171: ifne +15 -> 6186
    //   6174: iload 14
    //   6176: ifne +10 -> 6186
    //   6179: aload 7
    //   6181: aload 19
    //   6183: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6186: aload 19
    //   6188: invokevirtual 46	java/lang/String:length	()I
    //   6191: ifle +35 -> 6226
    //   6194: ldc_w 432
    //   6197: astore_3
    //   6198: aload 6
    //   6200: aload_3
    //   6201: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6204: aload 18
    //   6206: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6209: astore 18
    //   6211: iconst_1
    //   6212: istore 13
    //   6214: aload 21
    //   6216: astore_3
    //   6217: goto -5366 -> 851
    //   6220: ldc 26
    //   6222: astore_0
    //   6223: goto -56 -> 6167
    //   6226: ldc 26
    //   6228: astore_3
    //   6229: goto -31 -> 6198
    //   6232: aload 5
    //   6234: ldc_w 641
    //   6237: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6240: astore 21
    //   6242: aload 19
    //   6244: invokevirtual 46	java/lang/String:length	()I
    //   6247: ifle +74 -> 6321
    //   6250: new 152	java/lang/StringBuilder
    //   6253: dup
    //   6254: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6257: aload 19
    //   6259: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6262: ldc_w 430
    //   6265: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6268: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6271: astore_0
    //   6272: aload_2
    //   6273: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   6276: ifne +15 -> 6291
    //   6279: iload 14
    //   6281: ifne +10 -> 6291
    //   6284: aload 7
    //   6286: aload 19
    //   6288: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6291: aload 19
    //   6293: invokevirtual 46	java/lang/String:length	()I
    //   6296: ifle +31 -> 6327
    //   6299: ldc_w 432
    //   6302: astore_3
    //   6303: aload 6
    //   6305: aload_3
    //   6306: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6309: aconst_null
    //   6310: astore 18
    //   6312: iconst_0
    //   6313: istore 13
    //   6315: aload 21
    //   6317: astore_3
    //   6318: goto -5467 -> 851
    //   6321: ldc 26
    //   6323: astore_0
    //   6324: goto -52 -> 6272
    //   6327: ldc 26
    //   6329: astore_3
    //   6330: goto -27 -> 6303
    //   6333: aload 5
    //   6335: ldc_w 748
    //   6338: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6341: astore 21
    //   6343: aload 19
    //   6345: invokevirtual 46	java/lang/String:length	()I
    //   6348: ifle +85 -> 6433
    //   6351: new 152	java/lang/StringBuilder
    //   6354: dup
    //   6355: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6358: aload 19
    //   6360: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6363: ldc_w 430
    //   6366: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6369: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6372: astore_0
    //   6373: aload_2
    //   6374: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   6377: ifne +22 -> 6399
    //   6380: iload 14
    //   6382: ifne +17 -> 6399
    //   6385: aload_2
    //   6386: invokestatic 404	com/tencent/mm/model/w:Am	(Ljava/lang/String;)Z
    //   6389: ifne +10 -> 6399
    //   6392: aload 7
    //   6394: aload 19
    //   6396: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6399: aload 19
    //   6401: invokevirtual 46	java/lang/String:length	()I
    //   6404: ifle +35 -> 6439
    //   6407: ldc_w 432
    //   6410: astore_3
    //   6411: aload 6
    //   6413: aload_3
    //   6414: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6417: aload 18
    //   6419: invokevirtual 742	com/tencent/mm/ai/k$b:getTitle	()Ljava/lang/String;
    //   6422: astore 18
    //   6424: iconst_1
    //   6425: istore 13
    //   6427: aload 21
    //   6429: astore_3
    //   6430: goto -5579 -> 851
    //   6433: ldc 26
    //   6435: astore_0
    //   6436: goto -63 -> 6373
    //   6439: ldc 26
    //   6441: astore_3
    //   6442: goto -31 -> 6411
    //   6445: aload 5
    //   6447: ldc_w 641
    //   6450: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6453: astore_3
    //   6454: aconst_null
    //   6455: astore 18
    //   6457: iconst_0
    //   6458: istore 13
    //   6460: ldc 26
    //   6462: astore_0
    //   6463: goto -5612 -> 851
    //   6466: ldc 26
    //   6468: astore 21
    //   6470: aload 5
    //   6472: ldc_w 749
    //   6475: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6478: astore_3
    //   6479: aload 19
    //   6481: invokevirtual 46	java/lang/String:length	()I
    //   6484: ifle +115 -> 6599
    //   6487: new 152	java/lang/StringBuilder
    //   6490: dup
    //   6491: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6494: aload 19
    //   6496: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6499: ldc_w 430
    //   6502: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6505: aload_3
    //   6506: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6509: aload 18
    //   6511: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6514: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6517: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6520: astore_0
    //   6521: aload_2
    //   6522: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   6525: ifne +22 -> 6547
    //   6528: iload 14
    //   6530: ifne +17 -> 6547
    //   6533: aload_2
    //   6534: invokestatic 404	com/tencent/mm/model/w:Am	(Ljava/lang/String;)Z
    //   6537: ifne +10 -> 6547
    //   6540: aload 7
    //   6542: aload 19
    //   6544: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6547: aload 19
    //   6549: invokevirtual 46	java/lang/String:length	()I
    //   6552: ifle +73 -> 6625
    //   6555: new 152	java/lang/StringBuilder
    //   6558: dup
    //   6559: ldc_w 432
    //   6562: invokespecial 578	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   6565: aload_3
    //   6566: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6569: aload 18
    //   6571: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6574: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6577: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6580: astore_3
    //   6581: aload 6
    //   6583: aload_3
    //   6584: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6587: aconst_null
    //   6588: astore 18
    //   6590: iconst_0
    //   6591: istore 13
    //   6593: aload 21
    //   6595: astore_3
    //   6596: goto -5745 -> 851
    //   6599: new 152	java/lang/StringBuilder
    //   6602: dup
    //   6603: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6606: aload_3
    //   6607: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6610: aload 18
    //   6612: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6615: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6618: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6621: astore_0
    //   6622: goto -101 -> 6521
    //   6625: new 152	java/lang/StringBuilder
    //   6628: dup
    //   6629: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6632: aload_3
    //   6633: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6636: aload 18
    //   6638: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6641: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6644: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6647: astore_3
    //   6648: goto -67 -> 6581
    //   6651: aload 18
    //   6653: iconst_0
    //   6654: invokevirtual 753	com/tencent/mm/ai/k$b:ev	(Z)Z
    //   6657: ifeq +197 -> 6854
    //   6660: ldc 26
    //   6662: astore 21
    //   6664: aload 18
    //   6666: aload 5
    //   6668: iconst_1
    //   6669: invokevirtual 757	com/tencent/mm/ai/k$b:t	(Landroid/content/Context;Z)Ljava/lang/String;
    //   6672: astore_3
    //   6673: aload_3
    //   6674: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   6677: ifne +156 -> 6833
    //   6680: aload 19
    //   6682: invokevirtual 46	java/lang/String:length	()I
    //   6685: ifle +96 -> 6781
    //   6688: new 152	java/lang/StringBuilder
    //   6691: dup
    //   6692: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6695: aload 19
    //   6697: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6700: ldc_w 430
    //   6703: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6706: aload_3
    //   6707: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6710: aload 18
    //   6712: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6715: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6718: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6721: astore_0
    //   6722: aload 7
    //   6724: aload 19
    //   6726: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6729: aload 19
    //   6731: invokevirtual 46	java/lang/String:length	()I
    //   6734: ifle +73 -> 6807
    //   6737: new 152	java/lang/StringBuilder
    //   6740: dup
    //   6741: ldc_w 432
    //   6744: invokespecial 578	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   6747: aload_3
    //   6748: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6751: aload 18
    //   6753: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6756: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6759: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6762: astore_3
    //   6763: aload 6
    //   6765: aload_3
    //   6766: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6769: aconst_null
    //   6770: astore 18
    //   6772: iconst_0
    //   6773: istore 13
    //   6775: aload 21
    //   6777: astore_3
    //   6778: goto -5927 -> 851
    //   6781: new 152	java/lang/StringBuilder
    //   6784: dup
    //   6785: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6788: aload_3
    //   6789: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6792: aload 18
    //   6794: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6797: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6800: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6803: astore_0
    //   6804: goto -82 -> 6722
    //   6807: new 152	java/lang/StringBuilder
    //   6810: dup
    //   6811: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6814: aload_3
    //   6815: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6818: aload 18
    //   6820: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   6823: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6826: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6829: astore_3
    //   6830: goto -67 -> 6763
    //   6833: aload 5
    //   6835: ldc_w 641
    //   6838: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6841: astore_3
    //   6842: aconst_null
    //   6843: astore 18
    //   6845: iconst_0
    //   6846: istore 13
    //   6848: ldc 26
    //   6850: astore_0
    //   6851: goto -6000 -> 851
    //   6854: aload 5
    //   6856: ldc_w 641
    //   6859: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6862: astore_3
    //   6863: aconst_null
    //   6864: astore 18
    //   6866: iconst_0
    //   6867: istore 13
    //   6869: ldc 26
    //   6871: astore_0
    //   6872: goto -6021 -> 851
    //   6875: aload 5
    //   6877: ldc_w 758
    //   6880: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6883: astore_3
    //   6884: aload 19
    //   6886: invokevirtual 46	java/lang/String:length	()I
    //   6889: ifle +60 -> 6949
    //   6892: new 152	java/lang/StringBuilder
    //   6895: dup
    //   6896: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6899: aload 19
    //   6901: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6904: ldc_w 430
    //   6907: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6910: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6913: astore_0
    //   6914: aload_2
    //   6915: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   6918: ifne +15 -> 6933
    //   6921: iload 14
    //   6923: ifne +10 -> 6933
    //   6926: aload 7
    //   6928: aload 19
    //   6930: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6933: aload 6
    //   6935: ldc 26
    //   6937: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6940: aconst_null
    //   6941: astore 18
    //   6943: iconst_0
    //   6944: istore 13
    //   6946: goto -6095 -> 851
    //   6949: ldc 26
    //   6951: astore_0
    //   6952: goto -38 -> 6914
    //   6955: aload 5
    //   6957: ldc_w 759
    //   6960: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   6963: astore_3
    //   6964: aload 19
    //   6966: invokevirtual 46	java/lang/String:length	()I
    //   6969: ifle +60 -> 7029
    //   6972: new 152	java/lang/StringBuilder
    //   6975: dup
    //   6976: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   6979: aload 19
    //   6981: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6984: ldc_w 430
    //   6987: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6990: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6993: astore_0
    //   6994: aload_2
    //   6995: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   6998: ifne +15 -> 7013
    //   7001: iload 14
    //   7003: ifne +10 -> 7013
    //   7006: aload 7
    //   7008: aload 19
    //   7010: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7013: aload 6
    //   7015: ldc 26
    //   7017: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7020: aconst_null
    //   7021: astore 18
    //   7023: iconst_0
    //   7024: istore 13
    //   7026: goto -6175 -> 851
    //   7029: ldc 26
    //   7031: astore_0
    //   7032: goto -38 -> 6994
    //   7035: aload 5
    //   7037: ldc_w 760
    //   7040: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7043: astore_3
    //   7044: aload 19
    //   7046: invokevirtual 46	java/lang/String:length	()I
    //   7049: ifle +60 -> 7109
    //   7052: new 152	java/lang/StringBuilder
    //   7055: dup
    //   7056: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7059: aload 19
    //   7061: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7064: ldc_w 430
    //   7067: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7070: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7073: astore_0
    //   7074: aload_2
    //   7075: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   7078: ifne +15 -> 7093
    //   7081: iload 14
    //   7083: ifne +10 -> 7093
    //   7086: aload 7
    //   7088: aload 19
    //   7090: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7093: aload 6
    //   7095: ldc 26
    //   7097: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7100: aconst_null
    //   7101: astore 18
    //   7103: iconst_0
    //   7104: istore 13
    //   7106: goto -6255 -> 851
    //   7109: ldc 26
    //   7111: astore_0
    //   7112: goto -38 -> 7074
    //   7115: ldc 26
    //   7117: astore 21
    //   7119: aload 19
    //   7121: invokevirtual 46	java/lang/String:length	()I
    //   7124: ifle +100 -> 7224
    //   7127: new 152	java/lang/StringBuilder
    //   7130: dup
    //   7131: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7134: aload 19
    //   7136: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7139: ldc_w 430
    //   7142: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7145: aload 18
    //   7147: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   7150: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7153: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7156: astore_0
    //   7157: aload_2
    //   7158: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   7161: ifne +15 -> 7176
    //   7164: iload 14
    //   7166: ifne +10 -> 7176
    //   7169: aload 7
    //   7171: aload 19
    //   7173: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7176: aload 19
    //   7178: invokevirtual 46	java/lang/String:length	()I
    //   7181: ifle +52 -> 7233
    //   7184: new 152	java/lang/StringBuilder
    //   7187: dup
    //   7188: ldc_w 432
    //   7191: invokespecial 578	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   7194: aload 18
    //   7196: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   7199: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7202: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7205: astore_3
    //   7206: aload 6
    //   7208: aload_3
    //   7209: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7212: aconst_null
    //   7213: astore 18
    //   7215: iconst_0
    //   7216: istore 13
    //   7218: aload 21
    //   7220: astore_3
    //   7221: goto -6370 -> 851
    //   7224: aload 18
    //   7226: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   7229: astore_0
    //   7230: goto -73 -> 7157
    //   7233: aload 18
    //   7235: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   7238: astore_3
    //   7239: goto -33 -> 7206
    //   7242: aload 5
    //   7244: ldc_w 761
    //   7247: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7250: astore 21
    //   7252: aload 19
    //   7254: invokevirtual 46	java/lang/String:length	()I
    //   7257: ifle +74 -> 7331
    //   7260: new 152	java/lang/StringBuilder
    //   7263: dup
    //   7264: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7267: aload 19
    //   7269: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7272: ldc_w 430
    //   7275: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7278: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7281: astore_0
    //   7282: aload_2
    //   7283: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   7286: ifne +15 -> 7301
    //   7289: iload 14
    //   7291: ifne +10 -> 7301
    //   7294: aload 7
    //   7296: aload 19
    //   7298: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7301: aload 19
    //   7303: invokevirtual 46	java/lang/String:length	()I
    //   7306: ifle +31 -> 7337
    //   7309: ldc_w 432
    //   7312: astore_3
    //   7313: aload 6
    //   7315: aload_3
    //   7316: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7319: aconst_null
    //   7320: astore 18
    //   7322: iconst_0
    //   7323: istore 13
    //   7325: aload 21
    //   7327: astore_3
    //   7328: goto -6477 -> 851
    //   7331: ldc 26
    //   7333: astore_0
    //   7334: goto -52 -> 7282
    //   7337: ldc 26
    //   7339: astore_3
    //   7340: goto -27 -> 7313
    //   7343: ldc 26
    //   7345: astore_0
    //   7346: aload 18
    //   7348: getfield 764	com/tencent/mm/ai/k$b:description	Ljava/lang/String;
    //   7351: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   7354: ifne +35 -> 7389
    //   7357: aload 18
    //   7359: getfield 764	com/tencent/mm/ai/k$b:description	Ljava/lang/String;
    //   7362: ldc_w 766
    //   7365: invokevirtual 127	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   7368: istore 13
    //   7370: aload 18
    //   7372: getfield 764	com/tencent/mm/ai/k$b:description	Ljava/lang/String;
    //   7375: astore_0
    //   7376: iload 13
    //   7378: ifle +117 -> 7495
    //   7381: aload_0
    //   7382: iconst_0
    //   7383: iload 13
    //   7385: invokevirtual 131	java/lang/String:substring	(II)Ljava/lang/String;
    //   7388: astore_0
    //   7389: new 152	java/lang/StringBuilder
    //   7392: dup
    //   7393: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7396: aload 5
    //   7398: ldc_w 767
    //   7401: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7404: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7407: aload_0
    //   7408: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7411: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7414: astore 21
    //   7416: aload 19
    //   7418: invokevirtual 46	java/lang/String:length	()I
    //   7421: ifle +87 -> 7508
    //   7424: new 152	java/lang/StringBuilder
    //   7427: dup
    //   7428: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7431: aload 19
    //   7433: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7436: ldc_w 430
    //   7439: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7442: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7445: astore_0
    //   7446: aload_2
    //   7447: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   7450: ifne +15 -> 7465
    //   7453: iload 14
    //   7455: ifne +10 -> 7465
    //   7458: aload 7
    //   7460: aload 19
    //   7462: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7465: aload 19
    //   7467: invokevirtual 46	java/lang/String:length	()I
    //   7470: ifle +44 -> 7514
    //   7473: ldc_w 432
    //   7476: astore_3
    //   7477: aload 6
    //   7479: aload_3
    //   7480: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7483: aconst_null
    //   7484: astore 18
    //   7486: iconst_0
    //   7487: istore 13
    //   7489: aload 21
    //   7491: astore_3
    //   7492: goto -6641 -> 851
    //   7495: aload 18
    //   7497: getfield 764	com/tencent/mm/ai/k$b:description	Ljava/lang/String;
    //   7500: invokevirtual 46	java/lang/String:length	()I
    //   7503: istore 13
    //   7505: goto -124 -> 7381
    //   7508: ldc 26
    //   7510: astore_0
    //   7511: goto -65 -> 7446
    //   7514: ldc 26
    //   7516: astore_3
    //   7517: goto -40 -> 7477
    //   7520: ldc 26
    //   7522: astore 21
    //   7524: aload 5
    //   7526: ldc_w 628
    //   7529: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7532: astore_3
    //   7533: aload 19
    //   7535: invokevirtual 46	java/lang/String:length	()I
    //   7538: ifle +93 -> 7631
    //   7541: new 152	java/lang/StringBuilder
    //   7544: dup
    //   7545: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7548: aload 19
    //   7550: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7553: ldc_w 430
    //   7556: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7559: aload_3
    //   7560: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7563: aload 18
    //   7565: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   7568: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7571: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7574: astore_0
    //   7575: aload_2
    //   7576: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   7579: ifne +15 -> 7594
    //   7582: iload 14
    //   7584: ifne +10 -> 7594
    //   7587: aload 7
    //   7589: aload 19
    //   7591: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7594: aload 19
    //   7596: invokevirtual 46	java/lang/String:length	()I
    //   7599: ifle +58 -> 7657
    //   7602: ldc_w 432
    //   7605: aload_3
    //   7606: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7609: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   7612: astore_3
    //   7613: aload 6
    //   7615: aload_3
    //   7616: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7619: aconst_null
    //   7620: astore 18
    //   7622: iconst_0
    //   7623: istore 13
    //   7625: aload 21
    //   7627: astore_3
    //   7628: goto -6777 -> 851
    //   7631: new 152	java/lang/StringBuilder
    //   7634: dup
    //   7635: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7638: aload_3
    //   7639: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7642: aload 18
    //   7644: getfield 563	com/tencent/mm/ai/k$b:title	Ljava/lang/String;
    //   7647: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7650: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7653: astore_0
    //   7654: goto -79 -> 7575
    //   7657: aload_3
    //   7658: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7661: astore_3
    //   7662: goto -49 -> 7613
    //   7665: ldc 26
    //   7667: astore 21
    //   7669: aload 5
    //   7671: ldc_w 628
    //   7674: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7677: astore_0
    //   7678: iload_1
    //   7679: iconst_1
    //   7680: if_icmpne +96 -> 7776
    //   7683: new 152	java/lang/StringBuilder
    //   7686: dup
    //   7687: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7690: aload_0
    //   7691: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7694: aload 18
    //   7696: getfield 631	com/tencent/mm/ai/k$b:hBi	Ljava/lang/String;
    //   7699: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7702: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7705: astore_3
    //   7706: aload 19
    //   7708: invokevirtual 46	java/lang/String:length	()I
    //   7711: ifle +57 -> 7768
    //   7714: ldc_w 432
    //   7717: aload_3
    //   7718: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7721: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   7724: astore_0
    //   7725: aload 6
    //   7727: aload_0
    //   7728: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7731: aload_3
    //   7732: astore_0
    //   7733: aload_2
    //   7734: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   7737: ifne +1586 -> 9323
    //   7740: aload_3
    //   7741: astore_0
    //   7742: iload 14
    //   7744: ifne +1579 -> 9323
    //   7747: aload 7
    //   7749: aload 19
    //   7751: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7754: aconst_null
    //   7755: astore 18
    //   7757: iconst_0
    //   7758: istore 13
    //   7760: aload_3
    //   7761: astore_0
    //   7762: aload 21
    //   7764: astore_3
    //   7765: goto -6914 -> 851
    //   7768: aload_3
    //   7769: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7772: astore_0
    //   7773: goto -48 -> 7725
    //   7776: new 152	java/lang/StringBuilder
    //   7779: dup
    //   7780: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   7783: aload_0
    //   7784: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7787: aload 18
    //   7789: getfield 640	com/tencent/mm/ai/k$b:hBh	Ljava/lang/String;
    //   7792: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7795: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7798: astore_3
    //   7799: aload 19
    //   7801: invokevirtual 46	java/lang/String:length	()I
    //   7804: ifle +23 -> 7827
    //   7807: ldc_w 432
    //   7810: aload_3
    //   7811: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7814: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   7817: astore_0
    //   7818: aload 6
    //   7820: aload_0
    //   7821: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7824: goto -93 -> 7731
    //   7827: aload_3
    //   7828: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7831: astore_0
    //   7832: goto -14 -> 7818
    //   7835: aload_0
    //   7836: invokestatic 773	com/tencent/mm/ai/t:yw	(Ljava/lang/String;)Lcom/tencent/mm/ai/t;
    //   7839: getfield 776	com/tencent/mm/ai/t:hDj	I
    //   7842: bipush 19
    //   7844: if_icmpne +27 -> 7871
    //   7847: aload 5
    //   7849: ldc_w 761
    //   7852: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7855: astore 21
    //   7857: aconst_null
    //   7858: astore 18
    //   7860: iconst_0
    //   7861: istore 13
    //   7863: aload_3
    //   7864: astore_0
    //   7865: aload 21
    //   7867: astore_3
    //   7868: goto -7017 -> 851
    //   7871: aload 5
    //   7873: ldc_w 641
    //   7876: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   7879: astore 21
    //   7881: aconst_null
    //   7882: astore 18
    //   7884: iconst_0
    //   7885: istore 13
    //   7887: aload_3
    //   7888: astore_0
    //   7889: aload 21
    //   7891: astore_3
    //   7892: goto -7041 -> 851
    //   7895: aload_3
    //   7896: astore_0
    //   7897: iload 15
    //   7899: ifeq +8 -> 7907
    //   7902: aload_3
    //   7903: invokestatic 779	com/tencent/mm/booter/notification/a/h:uw	(Ljava/lang/String;)Ljava/lang/String;
    //   7906: astore_0
    //   7907: ldc_w 290
    //   7910: invokestatic 296	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   7913: checkcast 290	com/tencent/mm/plugin/biz/a/a
    //   7916: aload_0
    //   7917: invokeinterface 782 2 0
    //   7922: astore_3
    //   7923: aload_3
    //   7924: astore_0
    //   7925: iload 15
    //   7927: ifeq +8 -> 7935
    //   7930: aload_3
    //   7931: invokestatic 384	com/tencent/mm/booter/notification/a/h:uv	(Ljava/lang/String;)Ljava/lang/String;
    //   7934: astore_0
    //   7935: aload_0
    //   7936: invokestatic 204	com/tencent/mm/pluginsdk/ui/span/k:aNi	(Ljava/lang/String;)Ljava/lang/String;
    //   7939: astore_0
    //   7940: aload 6
    //   7942: aload_0
    //   7943: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7946: ldc 26
    //   7948: astore_3
    //   7949: aconst_null
    //   7950: astore 18
    //   7952: iconst_0
    //   7953: istore 13
    //   7955: goto -7104 -> 851
    //   7958: aload 6
    //   7960: ldc_w 290
    //   7963: invokestatic 296	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   7966: checkcast 290	com/tencent/mm/plugin/biz/a/a
    //   7969: aload_3
    //   7970: invokeinterface 785 2 0
    //   7975: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7978: aload 6
    //   7980: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7983: astore_3
    //   7984: ldc_w 619
    //   7987: ldc_w 787
    //   7990: iconst_2
    //   7991: anewarray 4	java/lang/Object
    //   7994: dup
    //   7995: iconst_0
    //   7996: ldc_w 288
    //   7999: invokestatic 191	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   8002: aastore
    //   8003: dup
    //   8004: iconst_1
    //   8005: aload_3
    //   8006: aastore
    //   8007: invokestatic 790	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8010: aconst_null
    //   8011: astore 18
    //   8013: iconst_0
    //   8014: istore 13
    //   8016: ldc 26
    //   8018: astore_0
    //   8019: goto -7168 -> 851
    //   8022: aload_3
    //   8023: invokestatic 796	com/tencent/mm/an/a$a:EG	(Ljava/lang/String;)Lcom/tencent/mm/an/a$a;
    //   8026: invokestatic 801	com/tencent/mm/an/a:b	(Lcom/tencent/mm/an/a$a;)Ljava/lang/String;
    //   8029: astore_0
    //   8030: aload 6
    //   8032: aload_0
    //   8033: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8036: ldc 26
    //   8038: astore_3
    //   8039: aconst_null
    //   8040: astore 18
    //   8042: iconst_0
    //   8043: istore 13
    //   8045: goto -7194 -> 851
    //   8048: ldc 26
    //   8050: astore_3
    //   8051: aload 21
    //   8053: invokestatic 552	com/tencent/mm/ai/k$b:yr	(Ljava/lang/String;)Lcom/tencent/mm/ai/k$b;
    //   8056: astore 18
    //   8058: aload_3
    //   8059: astore_0
    //   8060: aload 18
    //   8062: ifnull -7220 -> 842
    //   8065: aload_3
    //   8066: astore_0
    //   8067: aload 18
    //   8069: getfield 644	com/tencent/mm/ai/k$b:content	Ljava/lang/String;
    //   8072: ldc_w 646
    //   8075: invokestatic 651	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8078: astore_3
    //   8079: aload_3
    //   8080: astore_0
    //   8081: aload_3
    //   8082: invokestatic 204	com/tencent/mm/pluginsdk/ui/span/k:aNi	(Ljava/lang/String;)Ljava/lang/String;
    //   8085: astore_3
    //   8086: aload_3
    //   8087: astore_0
    //   8088: aload 6
    //   8090: aload_0
    //   8091: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8094: ldc 26
    //   8096: astore_3
    //   8097: aconst_null
    //   8098: astore 18
    //   8100: iconst_0
    //   8101: istore 13
    //   8103: goto -7252 -> 851
    //   8106: astore_3
    //   8107: ldc_w 619
    //   8110: aload_3
    //   8111: ldc 26
    //   8113: iconst_0
    //   8114: anewarray 4	java/lang/Object
    //   8117: invokestatic 655	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8120: ldc 26
    //   8122: astore_3
    //   8123: aconst_null
    //   8124: astore 18
    //   8126: iconst_0
    //   8127: istore 13
    //   8129: goto -7278 -> 851
    //   8132: ldc_w 803
    //   8135: invokestatic 296	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   8138: checkcast 803	com/tencent/mm/plugin/messenger/a/e
    //   8141: aload_3
    //   8142: invokeinterface 807 2 0
    //   8147: astore_0
    //   8148: aload_0
    //   8149: ifnull +100 -> 8249
    //   8152: aload_0
    //   8153: invokeinterface 810 1 0
    //   8158: astore_3
    //   8159: aload_3
    //   8160: astore_0
    //   8161: iload 9
    //   8163: ifeq +68 -> 8231
    //   8166: aload_3
    //   8167: astore_0
    //   8168: aload_2
    //   8169: invokestatic 385	com/tencent/mm/model/w:vF	(Ljava/lang/String;)Z
    //   8172: ifeq +59 -> 8231
    //   8175: aload_3
    //   8176: astore_0
    //   8177: aload_3
    //   8178: aload 5
    //   8180: ldc_w 811
    //   8183: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   8186: invokevirtual 814	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   8189: ifeq +42 -> 8231
    //   8192: ldc_w 619
    //   8195: ldc_w 816
    //   8198: iconst_1
    //   8199: anewarray 4	java/lang/Object
    //   8202: dup
    //   8203: iconst_0
    //   8204: aload_3
    //   8205: aastore
    //   8206: invokestatic 790	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8209: aload_3
    //   8210: iconst_0
    //   8211: aload_3
    //   8212: invokevirtual 46	java/lang/String:length	()I
    //   8215: aload 5
    //   8217: ldc_w 811
    //   8220: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   8223: invokevirtual 46	java/lang/String:length	()I
    //   8226: isub
    //   8227: invokevirtual 131	java/lang/String:substring	(II)Ljava/lang/String;
    //   8230: astore_0
    //   8231: aload 6
    //   8233: aload_0
    //   8234: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8237: ldc 26
    //   8239: astore_3
    //   8240: aconst_null
    //   8241: astore 18
    //   8243: iconst_0
    //   8244: istore 13
    //   8246: goto -7395 -> 851
    //   8249: ldc 26
    //   8251: astore_3
    //   8252: goto -93 -> 8159
    //   8255: aload_3
    //   8256: invokestatic 822	com/tencent/mm/ai/a/b:yA	(Ljava/lang/String;)Lcom/tencent/mm/ai/a/b;
    //   8259: getfield 823	com/tencent/mm/ai/a/b:content	Ljava/lang/String;
    //   8262: astore_3
    //   8263: aload_3
    //   8264: astore_0
    //   8265: aload_3
    //   8266: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8269: ifeq +6 -> 8275
    //   8272: ldc 26
    //   8274: astore_0
    //   8275: aload 6
    //   8277: aload_0
    //   8278: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8281: ldc 26
    //   8283: astore_3
    //   8284: aconst_null
    //   8285: astore 18
    //   8287: iconst_0
    //   8288: istore 13
    //   8290: goto -7439 -> 851
    //   8293: aload 5
    //   8295: ldc_w 824
    //   8298: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   8301: astore_0
    //   8302: aload 6
    //   8304: aload_0
    //   8305: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8308: ldc 26
    //   8310: astore_3
    //   8311: aconst_null
    //   8312: astore 18
    //   8314: iconst_0
    //   8315: istore 13
    //   8317: goto -7466 -> 851
    //   8320: aload_3
    //   8321: invokestatic 830	com/tencent/mm/ai/a/a:yy	(Ljava/lang/String;)Lcom/tencent/mm/ai/a/a;
    //   8324: astore_0
    //   8325: aload_0
    //   8326: getfield 831	com/tencent/mm/ai/a/a:nickname	Ljava/lang/String;
    //   8329: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8332: ifne +13 -> 8345
    //   8335: aload_0
    //   8336: getfield 832	com/tencent/mm/ai/a/a:title	Ljava/lang/String;
    //   8339: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8342: ifeq +9 -> 8351
    //   8345: ldc 26
    //   8347: astore_0
    //   8348: goto -46 -> 8302
    //   8351: getstatic 838	java/util/Locale:US	Ljava/util/Locale;
    //   8354: ldc_w 840
    //   8357: iconst_2
    //   8358: anewarray 4	java/lang/Object
    //   8361: dup
    //   8362: iconst_0
    //   8363: aload_0
    //   8364: getfield 831	com/tencent/mm/ai/a/a:nickname	Ljava/lang/String;
    //   8367: aastore
    //   8368: dup
    //   8369: iconst_1
    //   8370: aload_0
    //   8371: getfield 832	com/tencent/mm/ai/a/a:title	Ljava/lang/String;
    //   8374: aastore
    //   8375: invokestatic 844	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   8378: astore_0
    //   8379: goto -77 -> 8302
    //   8382: aload_0
    //   8383: ldc_w 846
    //   8386: invokevirtual 850	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8389: astore_0
    //   8390: aload_0
    //   8391: arraylength
    //   8392: iconst_1
    //   8393: if_icmple +23 -> 8416
    //   8396: aload 6
    //   8398: aload_0
    //   8399: iconst_1
    //   8400: aaload
    //   8401: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8404: aload_0
    //   8405: iconst_1
    //   8406: aaload
    //   8407: astore_0
    //   8408: ldc_w 360
    //   8411: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8414: aload_0
    //   8415: areturn
    //   8416: aload 6
    //   8418: ldc 26
    //   8420: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8423: ldc_w 360
    //   8426: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8429: aconst_null
    //   8430: areturn
    //   8431: aconst_null
    //   8432: astore_2
    //   8433: aconst_null
    //   8434: astore 7
    //   8436: aload_0
    //   8437: ldc 123
    //   8439: invokevirtual 850	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8442: astore 5
    //   8444: aload 5
    //   8446: ifnull +9 -> 8455
    //   8449: aload 5
    //   8451: arraylength
    //   8452: ifgt +18 -> 8470
    //   8455: aload 6
    //   8457: ldc 26
    //   8459: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8462: ldc_w 360
    //   8465: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8468: aconst_null
    //   8469: areturn
    //   8470: aload 5
    //   8472: iconst_0
    //   8473: aaload
    //   8474: astore 5
    //   8476: aload 5
    //   8478: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8481: ifne +69 -> 8550
    //   8484: invokestatic 257	com/tencent/mm/model/ba:aBQ	()Lcom/tencent/mm/model/c;
    //   8487: pop
    //   8488: invokestatic 263	com/tencent/mm/model/c:azp	()Lcom/tencent/mm/storage/bp;
    //   8491: aload 5
    //   8493: invokeinterface 269 2 0
    //   8498: astore 8
    //   8500: aload 7
    //   8502: astore 5
    //   8504: aload 8
    //   8506: ifnull +22 -> 8528
    //   8509: aload 7
    //   8511: astore 5
    //   8513: aload 8
    //   8515: invokevirtual 320	com/tencent/mm/storage/am:getCity	()Ljava/lang/String;
    //   8518: ifnull +10 -> 8528
    //   8521: aload 8
    //   8523: invokevirtual 320	com/tencent/mm/storage/am:getCity	()Ljava/lang/String;
    //   8526: astore 5
    //   8528: aload 5
    //   8530: ifnull +14 -> 8544
    //   8533: aload 5
    //   8535: astore_2
    //   8536: aload 5
    //   8538: invokevirtual 46	java/lang/String:length	()I
    //   8541: ifgt +9 -> 8550
    //   8544: aload 8
    //   8546: invokevirtual 327	com/tencent/mm/storage/am:getProvince	()Ljava/lang/String;
    //   8549: astore_2
    //   8550: aload_3
    //   8551: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8554: ifne +65 -> 8619
    //   8557: aload 6
    //   8559: new 152	java/lang/StringBuilder
    //   8562: dup
    //   8563: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8566: aload_2
    //   8567: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8570: ldc_w 430
    //   8573: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8576: aload_3
    //   8577: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8580: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8583: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8586: new 152	java/lang/StringBuilder
    //   8589: dup
    //   8590: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8593: aload_2
    //   8594: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8597: ldc_w 430
    //   8600: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8603: aload_3
    //   8604: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8607: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8610: astore_0
    //   8611: ldc_w 360
    //   8614: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8617: aload_0
    //   8618: areturn
    //   8619: aload_0
    //   8620: ldc_w 846
    //   8623: invokevirtual 850	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8626: astore_0
    //   8627: aload_0
    //   8628: arraylength
    //   8629: iconst_1
    //   8630: if_icmple +69 -> 8699
    //   8633: aload 6
    //   8635: new 152	java/lang/StringBuilder
    //   8638: dup
    //   8639: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8642: aload_2
    //   8643: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8646: ldc_w 430
    //   8649: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8652: aload_0
    //   8653: iconst_1
    //   8654: aaload
    //   8655: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8658: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8661: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8664: new 152	java/lang/StringBuilder
    //   8667: dup
    //   8668: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8671: aload_2
    //   8672: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8675: ldc_w 430
    //   8678: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8681: aload_0
    //   8682: iconst_1
    //   8683: aaload
    //   8684: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8687: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8690: astore_0
    //   8691: ldc_w 360
    //   8694: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8697: aload_0
    //   8698: areturn
    //   8699: aload 6
    //   8701: aload_2
    //   8702: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8705: ldc_w 360
    //   8708: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8711: aload_2
    //   8712: areturn
    //   8713: aload_0
    //   8714: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8717: ifeq +10 -> 8727
    //   8720: aload 6
    //   8722: ldc 26
    //   8724: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8727: aload 19
    //   8729: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8732: ifne +202 -> 8934
    //   8735: aload_0
    //   8736: astore_2
    //   8737: aload 20
    //   8739: ifnull +22 -> 8761
    //   8742: aload_0
    //   8743: astore_2
    //   8744: aload 20
    //   8746: invokevirtual 46	java/lang/String:length	()I
    //   8749: ifle +12 -> 8761
    //   8752: aload_0
    //   8753: aload 19
    //   8755: aload 20
    //   8757: invokestatic 854	com/tencent/mm/booter/notification/a/h:f	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8760: astore_2
    //   8761: aload 7
    //   8763: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8766: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8769: ifeq +28 -> 8797
    //   8772: aload 6
    //   8774: aload 6
    //   8776: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8779: aload 19
    //   8781: ldc_w 538
    //   8784: invokestatic 854	com/tencent/mm/booter/notification/a/h:f	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   8787: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8790: aload 7
    //   8792: aload 19
    //   8794: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8797: aload_2
    //   8798: invokestatic 859	com/tencent/mm/compatible/util/o:vv	(Ljava/lang/String;)Ljava/lang/String;
    //   8801: astore_0
    //   8802: aload 6
    //   8804: aload 6
    //   8806: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8809: invokestatic 859	com/tencent/mm/compatible/util/o:vv	(Ljava/lang/String;)Ljava/lang/String;
    //   8812: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8815: new 152	java/lang/StringBuilder
    //   8818: dup
    //   8819: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8822: aload_0
    //   8823: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8826: aload_3
    //   8827: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8830: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8833: astore_2
    //   8834: aload 6
    //   8836: new 152	java/lang/StringBuilder
    //   8839: dup
    //   8840: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   8843: aload 6
    //   8845: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8848: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8851: aload_3
    //   8852: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8855: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8858: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8861: iload 9
    //   8863: ifeq +25 -> 8888
    //   8866: iload 4
    //   8868: aload 6
    //   8870: aload_2
    //   8871: invokestatic 862	com/tencent/mm/booter/notification/a/h:a	(ILcom/tencent/mm/pointers/PString;Ljava/lang/String;)Z
    //   8874: ifne +14 -> 8888
    //   8877: iload 4
    //   8879: aload 6
    //   8881: aload 7
    //   8883: aload 8
    //   8885: invokestatic 865	com/tencent/mm/booter/notification/a/h:a	(ILcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PInt;)V
    //   8888: aload_2
    //   8889: astore_0
    //   8890: iload 13
    //   8892: ifeq +29 -> 8921
    //   8895: aload_2
    //   8896: new 152	java/lang/StringBuilder
    //   8899: dup
    //   8900: ldc_w 398
    //   8903: invokespecial 578	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   8906: aload 18
    //   8908: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   8911: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8914: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8917: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   8920: astore_0
    //   8921: aload_0
    //   8922: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   8925: astore_0
    //   8926: ldc_w 360
    //   8929: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8932: aload_0
    //   8933: areturn
    //   8934: aload_2
    //   8935: invokestatic 401	com/tencent/mm/model/w:Ad	(Ljava/lang/String;)Z
    //   8938: ifne +15 -> 8953
    //   8941: iload 14
    //   8943: ifne +10 -> 8953
    //   8946: aload_2
    //   8947: invokestatic 404	com/tencent/mm/model/w:Am	(Ljava/lang/String;)Z
    //   8950: ifeq +324 -> 9274
    //   8953: aload_0
    //   8954: astore 19
    //   8956: aload_3
    //   8957: ifnull +16 -> 8973
    //   8960: aload_0
    //   8961: astore 19
    //   8963: aload_3
    //   8964: invokevirtual 46	java/lang/String:length	()I
    //   8967: ifle +6 -> 8973
    //   8970: aload_3
    //   8971: astore 19
    //   8973: aload 19
    //   8975: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8978: ifeq +26 -> 9004
    //   8981: aload 6
    //   8983: ldc 26
    //   8985: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8988: aload 7
    //   8990: ldc 26
    //   8992: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8995: ldc_w 360
    //   8998: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   9001: ldc 26
    //   9003: areturn
    //   9004: iload_1
    //   9005: ifne +190 -> 9195
    //   9008: aload 6
    //   9010: ldc_w 453
    //   9013: aload 19
    //   9015: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9018: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   9021: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9024: iload 9
    //   9026: ifeq +208 -> 9234
    //   9029: iload 4
    //   9031: aload 6
    //   9033: aload 7
    //   9035: aload 8
    //   9037: invokestatic 865	com/tencent/mm/booter/notification/a/h:a	(ILcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PInt;)V
    //   9040: aload 19
    //   9042: astore_0
    //   9043: aload_0
    //   9044: astore_3
    //   9045: iload 13
    //   9047: ifeq +26 -> 9073
    //   9050: aload_0
    //   9051: astore_3
    //   9052: aload 18
    //   9054: ifnull +19 -> 9073
    //   9057: aload_0
    //   9058: ldc_w 398
    //   9061: aload 18
    //   9063: invokestatic 634	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9066: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   9069: invokevirtual 637	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   9072: astore_3
    //   9073: aload_3
    //   9074: astore_0
    //   9075: iload 15
    //   9077: ifeq +8 -> 9085
    //   9080: aload_3
    //   9081: invokestatic 779	com/tencent/mm/booter/notification/a/h:uw	(Ljava/lang/String;)Ljava/lang/String;
    //   9084: astore_0
    //   9085: aload 11
    //   9087: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   9090: ifne +92 -> 9182
    //   9093: aload_2
    //   9094: invokestatic 870	com/tencent/mm/am/g:DL	(Ljava/lang/String;)Z
    //   9097: ifeq +85 -> 9182
    //   9100: invokestatic 874	com/tencent/mm/am/ag:aFY	()Lcom/tencent/mm/am/j;
    //   9103: aload 11
    //   9105: invokevirtual 880	com/tencent/mm/am/j:DW	(Ljava/lang/String;)Lcom/tencent/mm/am/h;
    //   9108: astore_2
    //   9109: aload_2
    //   9110: ifnull +72 -> 9182
    //   9113: aload_2
    //   9114: getfield 885	com/tencent/mm/am/h:field_openId	Ljava/lang/String;
    //   9117: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   9120: ifne +62 -> 9182
    //   9123: aload_2
    //   9124: getfield 886	com/tencent/mm/am/h:field_nickname	Ljava/lang/String;
    //   9127: invokestatic 214	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   9130: ifne +52 -> 9182
    //   9133: iload 12
    //   9135: iconst_2
    //   9136: if_icmpeq +11 -> 9147
    //   9139: aload_2
    //   9140: getfield 889	com/tencent/mm/am/h:field_kfType	I
    //   9143: iconst_2
    //   9144: if_icmpne +38 -> 9182
    //   9147: aload 6
    //   9149: new 152	java/lang/StringBuilder
    //   9152: dup
    //   9153: ldc_w 453
    //   9156: invokespecial 578	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9159: aload 6
    //   9161: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9164: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9167: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9170: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9173: aload 7
    //   9175: aload_2
    //   9176: getfield 886	com/tencent/mm/am/h:field_nickname	Ljava/lang/String;
    //   9179: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9182: aload_0
    //   9183: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   9186: astore_0
    //   9187: ldc_w 360
    //   9190: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   9193: aload_0
    //   9194: areturn
    //   9195: aload 6
    //   9197: new 152	java/lang/StringBuilder
    //   9200: dup
    //   9201: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   9204: aload 5
    //   9206: ldc_w 890
    //   9209: invokevirtual 169	android/content/Context:getString	(I)Ljava/lang/String;
    //   9212: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9215: ldc 123
    //   9217: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9220: aload 19
    //   9222: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9225: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9228: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9231: goto -207 -> 9024
    //   9234: new 152	java/lang/StringBuilder
    //   9237: dup
    //   9238: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   9241: aload 7
    //   9243: getfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9246: invokestatic 144	com/tencent/mm/model/v:zf	(Ljava/lang/String;)Ljava/lang/String;
    //   9249: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9252: ldc 123
    //   9254: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9257: aload 19
    //   9259: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9262: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9265: astore_0
    //   9266: ldc_w 360
    //   9269: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   9272: aload_0
    //   9273: areturn
    //   9274: aload_3
    //   9275: ifnull +43 -> 9318
    //   9278: aload_3
    //   9279: invokevirtual 46	java/lang/String:length	()I
    //   9282: ifle +36 -> 9318
    //   9285: aload 6
    //   9287: aload_3
    //   9288: putfield 147	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9291: aload_3
    //   9292: astore_0
    //   9293: iload 9
    //   9295: ifeq -252 -> 9043
    //   9298: iload 4
    //   9300: aload 6
    //   9302: aload 7
    //   9304: aload 8
    //   9306: invokestatic 865	com/tencent/mm/booter/notification/a/h:a	(ILcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PInt;)V
    //   9309: aload_3
    //   9310: astore_0
    //   9311: goto -268 -> 9043
    //   9314: astore_3
    //   9315: goto -1208 -> 8107
    //   9318: aload_0
    //   9319: astore_3
    //   9320: goto -29 -> 9291
    //   9323: ldc 26
    //   9325: astore_3
    //   9326: aconst_null
    //   9327: astore 18
    //   9329: iconst_0
    //   9330: istore 13
    //   9332: goto -8481 -> 851
    //   9335: aconst_null
    //   9336: astore 18
    //   9338: iconst_0
    //   9339: istore 13
    //   9341: aload_3
    //   9342: astore_0
    //   9343: aload 21
    //   9345: astore_3
    //   9346: goto -8495 -> 851
    //   9349: ldc 26
    //   9351: astore_0
    //   9352: goto -4212 -> 5140
    //   9355: ldc 26
    //   9357: astore_0
    //   9358: goto -4444 -> 4914
    //   9361: goto -4602 -> 4759
    //   9364: goto -4790 -> 4574
    //   9367: aload_2
    //   9368: astore_0
    //   9369: goto -6953 -> 2416
    //   9372: aload_2
    //   9373: astore_0
    //   9374: goto -6953 -> 2421
    //   9377: iload 13
    //   9379: istore 14
    //   9381: goto -9098 -> 283
    //   9384: aload_3
    //   9385: astore 21
    //   9387: ldc 26
    //   9389: astore 20
    //   9391: ldc 26
    //   9393: astore 19
    //   9395: goto -9174 -> 221
    //   9398: iconst_0
    //   9399: istore 15
    //   9401: goto -9264 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	9404	0	paramString1	String
    //   0	9404	1	paramInt1	int
    //   0	9404	2	paramString2	String
    //   0	9404	3	paramString3	String
    //   0	9404	4	paramInt2	int
    //   0	9404	5	paramContext	Context
    //   0	9404	6	paramPString1	PString
    //   0	9404	7	paramPString2	PString
    //   0	9404	8	paramPInt	PInt
    //   0	9404	9	paramBoolean1	boolean
    //   0	9404	10	paramBoolean2	boolean
    //   0	9404	11	paramString4	String
    //   0	9404	12	paramInt3	int
    //   165	9213	13	i	int
    //   222	9158	14	j	int
    //   135	9265	15	k	int
    //   952	29	16	m	int
    //   12	69	17	bool	boolean
    //   247	4160	18	localObject1	Object
    //   4417	8	18	localException	Exception
    //   4600	4737	18	localObject2	Object
    //   182	9212	19	str1	String
    //   190	9200	20	str2	String
    //   219	9167	21	localObject3	Object
    //   4445	727	22	str3	String
    // Exception table:
    //   from	to	target	type
    //   4343	4354	4417	java/lang/Exception
    //   4356	4361	4417	java/lang/Exception
    //   8067	8079	8106	java/lang/Exception
    //   8081	8086	8106	java/lang/Exception
    //   8088	8094	9314	java/lang/Exception
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
      paramPString1.value = paramPString1.value.substring(0, E(paramPString1.value, 150));
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
  
  public static String b(bu parambu, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20074);
    String str;
    if (parambu.frD())
    {
      str = parambu.fsp();
      if (!parambu.fpd()) {
        break label90;
      }
    }
    for (parambu = com.tencent.mm.pluginsdk.ui.span.k.aNi(a(parambu.field_imgPath, parambu.field_isSend, parambu.field_talker, str, parambu.getType(), aj.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean, parambu.fky, parambu.fkE));; parambu = a(parambu.field_imgPath, parambu.field_isSend, parambu.field_talker, str, parambu.getType(), aj.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean, parambu.fky, parambu.fkE))
    {
      parambu = bt.nullAsNil(parambu);
      AppMethodBeat.o(20074);
      return parambu;
      str = parambu.field_content;
      break;
      label90:
      str = com.tencent.mm.pluginsdk.ui.span.k.aNi(str);
    }
  }
  
  public static void b(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(20090);
    if ((fHF == null) || (fHF.get() == null)) {
      fHF = new WeakReference(paramTextPaint);
    }
    AppMethodBeat.o(20090);
  }
  
  public static boolean b(String paramString, bu parambu)
  {
    AppMethodBeat.i(20070);
    if ((parambu != null) && (parambu.field_bizChatId != -1L) && (com.tencent.mm.am.g.vd(paramString)))
    {
      AppMethodBeat.o(20070);
      return true;
    }
    AppMethodBeat.o(20070);
    return false;
  }
  
  private static String bS(Context paramContext)
  {
    AppMethodBeat.i(20078);
    boolean bool = u.aAL();
    ba.aBQ();
    long l = bt.a((Long)com.tencent.mm.model.c.ajl().get(65793, null), 0L);
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
    if (bt.rM(l) * 1000L > 1209600000L)
    {
      paramContext = paramContext.getString(2131759553, new Object[] { Long.valueOf(bt.rM(l) * 1000L / 86400000L) });
      AppMethodBeat.o(20078);
      return paramContext;
    }
    AppMethodBeat.o(20078);
    return "";
  }
  
  public static String d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20091);
    paramString = b.fmR().aRK(paramString);
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
      paramContext = b.fmR().aRK(paramString);
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
    if (w.vF(paramString1))
    {
      paramString2 = bj.Bk(paramString2);
      if (paramString2 != null) {
        paramString2 = v.zf(paramString2.trim());
      }
    }
    while (paramString1.contains("@bottle"))
    {
      paramContext = paramContext.getResources().getQuantityString(2131623959, 1, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(20072);
      return paramContext;
      paramString2 = v.zf(paramString1);
      continue;
      paramString2 = v.zf(paramString1);
    }
    String str = paramString2;
    if (bt.isNullOrNil(paramString2))
    {
      str = paramString2;
      if (w.vF(paramString1)) {
        str = paramContext.getString(2131757293);
      }
    }
    paramContext = b.fmR().aRK(str);
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
    if (fHF == null)
    {
      AppMethodBeat.o(20089);
      return null;
    }
    TextPaint localTextPaint = (TextPaint)fHF.get();
    AppMethodBeat.o(20089);
    return localTextPaint;
  }
  
  public static void kY(int paramInt)
  {
    fHG = paramInt;
  }
  
  public static void kZ(int paramInt)
  {
    fHH = paramInt;
  }
  
  private static String uv(String paramString)
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
  
  private static String uw(String paramString)
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
  
  private static boolean ux(String paramString)
  {
    AppMethodBeat.i(20083);
    if ((w.zJ(paramString)) && (!u.aAI()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    if ((w.zL(paramString)) && (!u.aAz()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    if ((w.zP(paramString)) && (!u.aAL()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    AppMethodBeat.o(20083);
    return false;
  }
  
  public static String uy(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.h
 * JD-Core Version:    0.7.0.1
 */