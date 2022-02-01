package com.tencent.mm.booter.notification.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.ce.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.lang.ref.WeakReference;

public final class h
{
  private static WeakReference<TextPaint> goY;
  private static int goZ = 0;
  private static int gpa = 0;
  public String goX = "";
  public String mDesc = "";
  public String mTitle = "";
  
  private static String Dg(String paramString)
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
  
  private static String Dh(String paramString)
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
  
  private static boolean Di(String paramString)
  {
    AppMethodBeat.i(20083);
    if ((ab.IY(paramString)) && (!z.aUv()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    if ((ab.Ja(paramString)) && (!z.aUm()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    if ((ab.Je(paramString)) && (!z.aUy()))
    {
      AppMethodBeat.o(20083);
      return true;
    }
    AppMethodBeat.o(20083);
    return false;
  }
  
  public static String Dj(String paramString)
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
  
  private static int G(String paramString, int paramInt)
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
  
  private static CharSequence a(String paramString, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(20086);
    paramString = TextUtils.ellipsize(com.tencent.mm.pluginsdk.ui.span.l.e(MMApplicationContext.getContext(), paramString, alx()), paramTextPaint, aly(), TextUtils.TruncateAt.END);
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
    int j = 2131760873;
    AppMethodBeat.i(20077);
    String str3 = "";
    String str2;
    String str1;
    int i;
    if ((ab.IY(paramString1)) || (ab.Ja(paramString1)))
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
            if (!as.bjm(paramString1))
            {
              str2 = str3;
              str1 = paramString2;
              if (!as.bjo(paramString1)) {}
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
      if (!as.bjm(paramString1))
      {
        str2 = str3;
        str1 = paramString2;
        if (!as.bjo(paramString1)) {
          break;
        }
      }
      aa.getDisplayName(paramString1);
      paramPString2.value = paramString1;
      if (paramInt == 1)
      {
        paramContext = new StringBuilder().append(paramContext.getString(2131760873, new Object[] { "" }));
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
      i = 2131760873;
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
      i = 2131760883;
      break;
      label430:
      paramString1 = paramString3;
      break label352;
      label436:
      paramInt = 2131760883;
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
      String str = b.gxI().bib(paramString);
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
    paramContext = com.tencent.mm.pluginsdk.ui.span.l.bfh(b.gxI().bib(paramContext));
    AppMethodBeat.o(20071);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt, ca paramca)
  {
    AppMethodBeat.i(20073);
    if (TextUtils.isEmpty(paramString2)) {
      paramca = null;
    }
    for (;;)
    {
      paramString1 = paramca;
      if (Util.isNullOrNil(paramca))
      {
        if (!com.tencent.mm.n.g.Eq(paramString2)) {
          break;
        }
        paramString1 = paramContext.getString(2131757507);
      }
      paramContext = b.gxI().bib(paramString1);
      AppMethodBeat.o(20073);
      return paramContext;
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (!b(paramString2, paramca)) {
              continue;
            }
            if (paramca == null) {
              continue;
            }
            localObject1 = ag.baj().bs(paramca.field_bizChatId);
            if (((com.tencent.mm.al.a.c)localObject1).isGroup()) {
              if (Util.isNullOrNil(((com.tencent.mm.al.a.c)localObject1).field_chatName)) {
                localObject1 = MMApplicationContext.getContext().getString(2131764705);
              }
            }
          }
          catch (Throwable paramca)
          {
            boolean bool;
            as localas;
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
            paramca = (ca)localObject1;
            if (!bool) {
              break;
            }
          }
          catch (Throwable paramca) {}
        }
        bg.aVF();
        localas = com.tencent.mm.model.c.aSN().Kn(paramString2);
        if (localas != null) {
          continue;
        }
        paramca = null;
        break;
        localObject1 = ((com.tencent.mm.al.a.c)localObject1).field_chatName;
        continue;
        paramca = ag.bal().fB(paramca.field_bizChatUserId);
        if (paramca == null) {
          continue;
        }
        localObject1 = paramca.field_userName;
      }
      localObject2 = localObject1;
      if (paramInt == 318767153)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject2 = ((a)com.tencent.mm.kernel.g.af(a.class)).aE(paramString1, paramString2);
          paramca = (ca)localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
        }
      }
      if (ab.Jz(paramString2))
      {
        paramca = localas.arI();
      }
      else
      {
        if (as.IG(paramString2))
        {
          localObject1 = MMApplicationContext.getContext();
          if (localas != null) {
            if (RegionCodeDecoder.bkO(localas.getCountryCode()))
            {
              paramString1 = localas.getCity();
              if (Util.isNullOrNil(paramString1)) {}
            }
          }
          for (;;)
          {
            paramca = paramContext.getString(2131756856, new Object[] { paramString1 }).trim();
            break;
            paramca = aa.It(localas.getProvince());
            paramString1 = paramca;
            if (Util.isNullOrNil(paramca))
            {
              RegionCodeDecoder.gEm();
              paramString1 = RegionCodeDecoder.getLocName(localas.getCountryCode());
              continue;
              paramca = aa.It(localas.getProvince());
              paramString1 = paramca;
              if (Util.isNullOrNil(paramca)) {
                paramString1 = ((Context)localObject1).getString(2131756885);
              }
            }
          }
        }
        if ((com.tencent.mm.n.g.Eq(paramString2)) && (Util.isNullOrNil(localas.field_nickname)) && (Util.isNullOrNil(localas.field_conRemark)))
        {
          bg.aVF();
          paramString1 = com.tencent.mm.model.c.aSX().getDisplayName(paramString2);
          paramca = (ca)localObject2;
          if (!Util.isNullOrNil(paramString1)) {
            paramca = paramString1;
          }
        }
        else
        {
          paramca = (ca)localObject2;
          if (localas.arJ() != null)
          {
            paramca = (ca)localObject2;
            if (localas.arJ().length() > 0) {
              paramca = localas.arJ();
            }
          }
        }
      }
    }
    paramContext = paramContext.getString(2131761792);
    AppMethodBeat.o(20073);
    return paramContext;
  }
  
  /* Error */
  private static String a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, Context paramContext, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean1, boolean paramBoolean2, String paramString4, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 379
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload 5
    //   8: ifnull +65 -> 73
    //   11: iconst_1
    //   12: istore 17
    //   14: ldc_w 381
    //   17: iload 17
    //   19: invokestatic 387	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   22: aload_2
    //   23: ifnull +56 -> 79
    //   26: aload_2
    //   27: invokevirtual 84	java/lang/String:length	()I
    //   30: ifle +49 -> 79
    //   33: iconst_1
    //   34: istore 17
    //   36: ldc_w 389
    //   39: iload 17
    //   41: invokestatic 387	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   44: iload 9
    //   46: ifne +39 -> 85
    //   49: aload_2
    //   50: invokestatic 391	com/tencent/mm/booter/notification/a/h:Di	(Ljava/lang/String;)Z
    //   53: ifeq +32 -> 85
    //   56: aload 5
    //   58: ldc_w 392
    //   61: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   64: astore_0
    //   65: ldc_w 379
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
    //   86: invokestatic 76	com/tencent/mm/model/ab:Je	(Ljava/lang/String;)Z
    //   89: ifeq +31 -> 120
    //   92: iload 9
    //   94: ifeq +12 -> 106
    //   97: ldc_w 379
    //   100: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: ldc 26
    //   105: areturn
    //   106: aload 5
    //   108: invokestatic 396	com/tencent/mm/booter/notification/a/h:cp	(Landroid/content/Context;)Ljava/lang/String;
    //   111: astore_0
    //   112: ldc_w 379
    //   115: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_0
    //   119: areturn
    //   120: ldc 26
    //   122: astore 22
    //   124: aload_3
    //   125: ifnull +11199 -> 11324
    //   128: iload 9
    //   130: ifeq +11194 -> 11324
    //   133: aload_3
    //   134: invokestatic 398	com/tencent/mm/booter/notification/a/h:Dg	(Ljava/lang/String;)Ljava/lang/String;
    //   137: astore_3
    //   138: iconst_1
    //   139: istore 15
    //   141: aload 6
    //   143: aload_3
    //   144: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   147: iload_1
    //   148: ifne +11162 -> 11310
    //   151: aload_2
    //   152: invokestatic 399	com/tencent/mm/model/ab:Eq	(Ljava/lang/String;)Z
    //   155: ifne +10 -> 165
    //   158: aload_2
    //   159: invokestatic 402	com/tencent/mm/model/ab:Iy	(Ljava/lang/String;)Z
    //   162: ifeq +11148 -> 11310
    //   165: aload_3
    //   166: invokestatic 407	com/tencent/mm/model/bp:Kp	(Ljava/lang/String;)I
    //   169: istore 13
    //   171: iload 13
    //   173: ifle +11137 -> 11310
    //   176: aload_3
    //   177: iconst_0
    //   178: iload 13
    //   180: invokevirtual 91	java/lang/String:substring	(II)Ljava/lang/String;
    //   183: invokevirtual 343	java/lang/String:trim	()Ljava/lang/String;
    //   186: astore 19
    //   188: aload 19
    //   190: aload_2
    //   191: invokestatic 409	com/tencent/mm/model/aa:getDisplayName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   194: astore 20
    //   196: new 86	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   203: aload_3
    //   204: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 411
    //   210: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: iload 13
    //   218: iconst_1
    //   219: iadd
    //   220: invokevirtual 181	java/lang/String:substring	(I)Ljava/lang/String;
    //   223: astore 21
    //   225: iconst_0
    //   226: istore 14
    //   228: aload_2
    //   229: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   232: ifne +10 -> 242
    //   235: aload_2
    //   236: invokestatic 417	com/tencent/mm/model/ab:JB	(Ljava/lang/String;)Z
    //   239: ifeq +724 -> 963
    //   242: aload_3
    //   243: ldc 158
    //   245: invokevirtual 162	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   248: istore 13
    //   250: aload_3
    //   251: astore 18
    //   253: iload 13
    //   255: iconst_m1
    //   256: if_icmpeq +25 -> 281
    //   259: aload 7
    //   261: aload_3
    //   262: iconst_0
    //   263: iload 13
    //   265: invokevirtual 91	java/lang/String:substring	(II)Ljava/lang/String;
    //   268: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   271: aload_3
    //   272: iload 13
    //   274: iconst_1
    //   275: iadd
    //   276: invokevirtual 181	java/lang/String:substring	(I)Ljava/lang/String;
    //   279: astore 18
    //   281: iconst_0
    //   282: istore 14
    //   284: aload 18
    //   286: astore_3
    //   287: iload 4
    //   289: lookupswitch	default:+627->916, -1879048191:+1361->1650, -1879048190:+1361->1650, -1879048189:+1361->1650, -1879048188:+1467->1756, -1879048186:+4276->4565, -1879048185:+4426->4715, -1879048183:+4426->4715, -1879048176:+4426->4715, 3:+781->1070, 11:+982->1271, 13:+949->1238, 23:+781->1070, 33:+781->1070, 34:+1008->1297, 35:+1826->2115, 36:+982->1271, 37:+1488->1777, 39:+949->1238, 40:+1743->2032, 42:+1897->2186, 43:+1174->1463, 47:+859->1148, 48:+2153->2442, 49:+6491->6780, 50:+1382->1671, 52:+1446->1735, 53:+1382->1671, 55:+9262->9551, 57:+9262->9551, 62:+1174->1463, 66:+1897->2186, 1048625:+859->1148, 12299999:+1340->1629, 16777265:+6491->6780, 268435505:+6491->6780, 285212721:+9134->9423, 318767153:+9197->9486, 335544369:+2276->2565, 369098801:+3723->4012, 402653233:+2395->2684, 419430449:+2474->2763, 436207665:+3278->3567, 452984881:+3871->4160, 469762097:+3278->3567, 486539313:+1174->1463, 503316529:+9288->9577, 520093745:+4077->4366, 536870961:+3501->3790, 553648177:+6491->6780, 570425393:+9372->9661, 587202609:+6491->6780, 603979825:+9503->9792, 671088689:+3625->3914, 687865905:+6491->6780, 704643121:+4523->4812, 721420337:+9526->9815, 738197553:+6491->6780, 754974769:+4654->4943, 771751985:+5576->5865, 788529201:+5747->6036, 805306417:+6491->6780, 822083633:+6491->6780, 838860849:+5213->5502, 855638065:+6052->6341, 872415281:+9538->9827, 889192497:+5969->6258, 922746929:+5969->6258, 939524145:+5798->6087, 956301361:+5422->5711, 973078577:+5044->5333, 989855793:+6130->6419, 1006633009:+5213->5502, 1023410225:+4849->5138, 1023475761:+9600->9889, 1023541297:+9809->10098, 1040187441:+6491->6780, 1057030193:+6299->6588
    //   917: astore_0
    //   918: ldc 26
    //   920: astore 18
    //   922: aconst_null
    //   923: astore_3
    //   924: iconst_0
    //   925: istore 13
    //   927: aload_2
    //   928: invokestatic 420	com/tencent/mm/model/ab:IZ	(Ljava/lang/String;)Z
    //   931: ifeq +9680 -> 10611
    //   934: iconst_1
    //   935: iload_1
    //   936: if_icmpne +9403 -> 10339
    //   939: aload 18
    //   941: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   944: ifne +9346 -> 10290
    //   947: aload 6
    //   949: aload 18
    //   951: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   954: ldc_w 379
    //   957: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   960: aload 18
    //   962: areturn
    //   963: iload 14
    //   965: istore 13
    //   967: aload_2
    //   968: invokestatic 423	com/tencent/mm/model/ab:JD	(Ljava/lang/String;)Z
    //   971: ifne +10332 -> 11303
    //   974: invokestatic 277	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   977: pop
    //   978: invokestatic 427	com/tencent/mm/model/c:aST	()Lcom/tencent/mm/storage/bw;
    //   981: aload_2
    //   982: invokeinterface 433 2 0
    //   987: astore 18
    //   989: aload 18
    //   991: ifnull +14 -> 1005
    //   994: aload 18
    //   996: ldc_w 434
    //   999: invokevirtual 440	com/tencent/mm/storage/az:oV	(I)Z
    //   1002: ifne +12 -> 1014
    //   1005: iload 14
    //   1007: istore 13
    //   1009: iload 10
    //   1011: ifeq +10292 -> 11303
    //   1014: iconst_1
    //   1015: istore 14
    //   1017: iload 14
    //   1019: istore 13
    //   1021: aload_3
    //   1022: ifnull +10281 -> 11303
    //   1025: aload_3
    //   1026: ldc 158
    //   1028: invokevirtual 162	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1031: istore 16
    //   1033: iload 14
    //   1035: istore 13
    //   1037: iload 16
    //   1039: iconst_m1
    //   1040: if_icmpeq +10263 -> 11303
    //   1043: aload 7
    //   1045: aload_3
    //   1046: iconst_0
    //   1047: iload 16
    //   1049: invokevirtual 91	java/lang/String:substring	(II)Ljava/lang/String;
    //   1052: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1055: aload_3
    //   1056: iload 16
    //   1058: iconst_1
    //   1059: iadd
    //   1060: invokevirtual 181	java/lang/String:substring	(I)Ljava/lang/String;
    //   1063: astore_3
    //   1064: iconst_1
    //   1065: istore 14
    //   1067: goto -780 -> 287
    //   1070: aload 5
    //   1072: ldc_w 441
    //   1075: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   1078: astore 18
    //   1080: aload 19
    //   1082: invokevirtual 84	java/lang/String:length	()I
    //   1085: ifle +51 -> 1136
    //   1088: new 86	java/lang/StringBuilder
    //   1091: dup
    //   1092: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   1095: aload 19
    //   1097: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: ldc_w 443
    //   1103: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1109: astore_0
    //   1110: aload 19
    //   1112: invokevirtual 84	java/lang/String:length	()I
    //   1115: ifle +27 -> 1142
    //   1118: ldc_w 445
    //   1121: astore_3
    //   1122: aload 6
    //   1124: aload_3
    //   1125: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1128: aconst_null
    //   1129: astore_3
    //   1130: iconst_0
    //   1131: istore 13
    //   1133: goto -206 -> 927
    //   1136: ldc 26
    //   1138: astore_0
    //   1139: goto -29 -> 1110
    //   1142: ldc 26
    //   1144: astore_3
    //   1145: goto -23 -> 1122
    //   1148: aload_3
    //   1149: invokestatic 451	com/tencent/mm/storage/be:bkr	(Ljava/lang/String;)Lcom/tencent/mm/storage/be;
    //   1152: astore 18
    //   1154: new 86	java/lang/StringBuilder
    //   1157: dup
    //   1158: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   1161: aload 18
    //   1163: invokevirtual 454	com/tencent/mm/storage/be:bhs	()Ljava/lang/String;
    //   1166: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1169: ldc_w 443
    //   1172: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1178: astore_3
    //   1179: aload_0
    //   1180: ifnull +46 -> 1226
    //   1183: aload_0
    //   1184: invokevirtual 84	java/lang/String:length	()I
    //   1187: bipush 32
    //   1189: if_icmpne +37 -> 1226
    //   1192: aload 6
    //   1194: ldc 26
    //   1196: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1199: aload 7
    //   1201: aload 18
    //   1203: invokevirtual 454	com/tencent/mm/storage/be:bhs	()Ljava/lang/String;
    //   1206: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1209: aload_0
    //   1210: astore 18
    //   1212: aconst_null
    //   1213: astore 21
    //   1215: iconst_0
    //   1216: istore 13
    //   1218: aload_3
    //   1219: astore_0
    //   1220: aload 21
    //   1222: astore_3
    //   1223: goto -296 -> 927
    //   1226: aload 5
    //   1228: ldc_w 455
    //   1231: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   1234: astore_0
    //   1235: goto -43 -> 1192
    //   1238: aload 5
    //   1240: iload_1
    //   1241: aload_2
    //   1242: aload_3
    //   1243: aload 5
    //   1245: ldc_w 441
    //   1248: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   1251: aload 6
    //   1253: aload 7
    //   1255: invokestatic 457	com/tencent/mm/booter/notification/a/h:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;)Ljava/lang/String;
    //   1258: astore_0
    //   1259: aconst_null
    //   1260: astore_3
    //   1261: iconst_0
    //   1262: istore 13
    //   1264: aload 22
    //   1266: astore 18
    //   1268: goto -341 -> 927
    //   1271: aload 5
    //   1273: iload_1
    //   1274: aload_2
    //   1275: aload_3
    //   1276: aconst_null
    //   1277: aload 6
    //   1279: aload 7
    //   1281: invokestatic 457	com/tencent/mm/booter/notification/a/h:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;)Ljava/lang/String;
    //   1284: astore_0
    //   1285: aconst_null
    //   1286: astore_3
    //   1287: iconst_0
    //   1288: istore 13
    //   1290: aload 22
    //   1292: astore 18
    //   1294: goto -367 -> 927
    //   1297: aload_2
    //   1298: invokestatic 167	com/tencent/mm/storage/as:bjm	(Ljava/lang/String;)Z
    //   1301: ifne +24 -> 1325
    //   1304: aload_2
    //   1305: invokestatic 170	com/tencent/mm/storage/as:bjo	(Ljava/lang/String;)Z
    //   1308: ifne +17 -> 1325
    //   1311: aload_2
    //   1312: invokestatic 61	com/tencent/mm/model/ab:IY	(Ljava/lang/String;)Z
    //   1315: ifne +10 -> 1325
    //   1318: aload_2
    //   1319: invokestatic 70	com/tencent/mm/model/ab:Ja	(Ljava/lang/String;)Z
    //   1322: ifeq +36 -> 1358
    //   1325: aload 5
    //   1327: iload_1
    //   1328: aload_2
    //   1329: aload_3
    //   1330: aload 5
    //   1332: ldc_w 458
    //   1335: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   1338: aload 6
    //   1340: aload 7
    //   1342: invokestatic 457	com/tencent/mm/booter/notification/a/h:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;)Ljava/lang/String;
    //   1345: astore_0
    //   1346: aconst_null
    //   1347: astore_3
    //   1348: iconst_0
    //   1349: istore 13
    //   1351: aload 22
    //   1353: astore 18
    //   1355: goto -428 -> 927
    //   1358: aload_3
    //   1359: astore_0
    //   1360: aload_3
    //   1361: ifnull +78 -> 1439
    //   1364: aload_3
    //   1365: astore_0
    //   1366: aload_3
    //   1367: invokevirtual 84	java/lang/String:length	()I
    //   1370: ifle +69 -> 1439
    //   1373: aload_3
    //   1374: astore_0
    //   1375: aload_2
    //   1376: invokestatic 420	com/tencent/mm/model/ab:IZ	(Ljava/lang/String;)Z
    //   1379: ifne +60 -> 1439
    //   1382: aload_2
    //   1383: invokestatic 399	com/tencent/mm/model/ab:Eq	(Ljava/lang/String;)Z
    //   1386: ifeq +71 -> 1457
    //   1389: new 460	com/tencent/mm/modelvoice/p
    //   1392: dup
    //   1393: aload_3
    //   1394: invokespecial 463	com/tencent/mm/modelvoice/p:<init>	(Ljava/lang/String;)V
    //   1397: astore_3
    //   1398: new 86	java/lang/StringBuilder
    //   1401: dup
    //   1402: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   1405: aload_3
    //   1406: invokevirtual 464	com/tencent/mm/modelvoice/p:bhs	()Ljava/lang/String;
    //   1409: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: ldc_w 443
    //   1415: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1421: astore_0
    //   1422: aload 6
    //   1424: ldc_w 466
    //   1427: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1430: aload 7
    //   1432: aload_3
    //   1433: invokevirtual 464	com/tencent/mm/modelvoice/p:bhs	()Ljava/lang/String;
    //   1436: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1439: aload 5
    //   1441: ldc_w 458
    //   1444: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   1447: astore 18
    //   1449: aconst_null
    //   1450: astore_3
    //   1451: iconst_0
    //   1452: istore 13
    //   1454: goto -527 -> 927
    //   1457: ldc 26
    //   1459: astore_0
    //   1460: goto -21 -> 1439
    //   1463: aload_2
    //   1464: invokestatic 167	com/tencent/mm/storage/as:bjm	(Ljava/lang/String;)Z
    //   1467: ifne +24 -> 1491
    //   1470: aload_2
    //   1471: invokestatic 170	com/tencent/mm/storage/as:bjo	(Ljava/lang/String;)Z
    //   1474: ifne +17 -> 1491
    //   1477: aload_2
    //   1478: invokestatic 61	com/tencent/mm/model/ab:IY	(Ljava/lang/String;)Z
    //   1481: ifne +10 -> 1491
    //   1484: aload_2
    //   1485: invokestatic 70	com/tencent/mm/model/ab:Ja	(Ljava/lang/String;)Z
    //   1488: ifeq +36 -> 1524
    //   1491: aload 5
    //   1493: iload_1
    //   1494: aload_2
    //   1495: aload_3
    //   1496: aload 5
    //   1498: ldc_w 467
    //   1501: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   1504: aload 6
    //   1506: aload 7
    //   1508: invokestatic 457	com/tencent/mm/booter/notification/a/h:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;)Ljava/lang/String;
    //   1511: astore_0
    //   1512: aconst_null
    //   1513: astore_3
    //   1514: iconst_0
    //   1515: istore 13
    //   1517: aload 22
    //   1519: astore 18
    //   1521: goto -594 -> 927
    //   1524: aload_3
    //   1525: astore_0
    //   1526: aload_3
    //   1527: ifnull +78 -> 1605
    //   1530: aload_3
    //   1531: astore_0
    //   1532: aload_3
    //   1533: invokevirtual 84	java/lang/String:length	()I
    //   1536: ifle +69 -> 1605
    //   1539: aload_3
    //   1540: astore_0
    //   1541: aload_2
    //   1542: invokestatic 420	com/tencent/mm/model/ab:IZ	(Ljava/lang/String;)Z
    //   1545: ifne +60 -> 1605
    //   1548: aload_2
    //   1549: invokestatic 399	com/tencent/mm/model/ab:Eq	(Ljava/lang/String;)Z
    //   1552: ifeq +71 -> 1623
    //   1555: new 469	com/tencent/mm/modelvideo/q
    //   1558: dup
    //   1559: aload_3
    //   1560: invokespecial 470	com/tencent/mm/modelvideo/q:<init>	(Ljava/lang/String;)V
    //   1563: astore_3
    //   1564: new 86	java/lang/StringBuilder
    //   1567: dup
    //   1568: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   1571: aload_3
    //   1572: invokevirtual 471	com/tencent/mm/modelvideo/q:bhs	()Ljava/lang/String;
    //   1575: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1578: ldc_w 443
    //   1581: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1587: astore_0
    //   1588: aload 6
    //   1590: ldc_w 466
    //   1593: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1596: aload 7
    //   1598: aload_3
    //   1599: invokevirtual 471	com/tencent/mm/modelvideo/q:bhs	()Ljava/lang/String;
    //   1602: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1605: aload 5
    //   1607: ldc_w 467
    //   1610: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   1613: astore 18
    //   1615: aconst_null
    //   1616: astore_3
    //   1617: iconst_0
    //   1618: istore 13
    //   1620: goto -693 -> 927
    //   1623: ldc 26
    //   1625: astore_0
    //   1626: goto -21 -> 1605
    //   1629: aload 5
    //   1631: ldc_w 472
    //   1634: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   1637: astore 18
    //   1639: aconst_null
    //   1640: astore_3
    //   1641: iconst_0
    //   1642: istore 13
    //   1644: ldc 26
    //   1646: astore_0
    //   1647: goto -720 -> 927
    //   1650: aload 5
    //   1652: ldc_w 473
    //   1655: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   1658: astore 18
    //   1660: aconst_null
    //   1661: astore_3
    //   1662: iconst_0
    //   1663: istore 13
    //   1665: ldc 26
    //   1667: astore_0
    //   1668: goto -741 -> 927
    //   1671: aload_3
    //   1672: getstatic 478	com/tencent/mm/storage/ca:OqC	Ljava/lang/String;
    //   1675: invokevirtual 482	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1678: ifeq +24 -> 1702
    //   1681: aload 5
    //   1683: ldc_w 472
    //   1686: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   1689: astore 18
    //   1691: aconst_null
    //   1692: astore_3
    //   1693: iconst_0
    //   1694: istore 13
    //   1696: ldc 26
    //   1698: astore_0
    //   1699: goto -772 -> 927
    //   1702: aload_3
    //   1703: astore_0
    //   1704: aload_3
    //   1705: getstatic 485	com/tencent/mm/storage/ca:OqB	Ljava/lang/String;
    //   1708: invokevirtual 482	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1711: ifeq -793 -> 918
    //   1714: aload 5
    //   1716: ldc_w 486
    //   1719: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   1722: astore 18
    //   1724: aconst_null
    //   1725: astore_3
    //   1726: iconst_0
    //   1727: istore 13
    //   1729: ldc 26
    //   1731: astore_0
    //   1732: goto -805 -> 927
    //   1735: aload 5
    //   1737: ldc_w 472
    //   1740: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   1743: astore 18
    //   1745: aconst_null
    //   1746: astore_3
    //   1747: iconst_0
    //   1748: istore 13
    //   1750: ldc 26
    //   1752: astore_0
    //   1753: goto -826 -> 927
    //   1756: aload 5
    //   1758: ldc_w 486
    //   1761: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   1764: astore 18
    //   1766: aconst_null
    //   1767: astore_3
    //   1768: iconst_0
    //   1769: istore 13
    //   1771: ldc 26
    //   1773: astore_0
    //   1774: goto -847 -> 927
    //   1777: aload_3
    //   1778: astore_0
    //   1779: aload_3
    //   1780: ifnull -862 -> 918
    //   1783: aload_3
    //   1784: astore_0
    //   1785: aload_3
    //   1786: invokevirtual 84	java/lang/String:length	()I
    //   1789: ifle -871 -> 918
    //   1792: aload_3
    //   1793: invokestatic 492	com/tencent/mm/storage/ca$d:bkD	(Ljava/lang/String;)Lcom/tencent/mm/storage/ca$d;
    //   1796: astore 18
    //   1798: aload_3
    //   1799: astore_0
    //   1800: aload 18
    //   1802: invokevirtual 495	com/tencent/mm/storage/ca$d:gDY	()Ljava/lang/String;
    //   1805: ifnull +110 -> 1915
    //   1808: aload_3
    //   1809: astore_0
    //   1810: aload 18
    //   1812: invokevirtual 495	com/tencent/mm/storage/ca$d:gDY	()Ljava/lang/String;
    //   1815: invokevirtual 84	java/lang/String:length	()I
    //   1818: ifle +97 -> 1915
    //   1821: aload 18
    //   1823: invokevirtual 498	com/tencent/mm/storage/ca$d:getScene	()I
    //   1826: tableswitch	default:+62 -> 1888, 18:+101->1927, 19:+62->1888, 20:+62->1888, 21:+62->1888, 22:+134->1960, 23:+134->1960, 24:+134->1960, 25:+167->1993, 26:+134->1960, 27:+134->1960, 28:+134->1960, 29:+134->1960
    //   1889: iconst_2
    //   1890: ldc_w 499
    //   1893: iconst_1
    //   1894: anewarray 4	java/lang/Object
    //   1897: dup
    //   1898: iconst_0
    //   1899: aload 18
    //   1901: invokevirtual 501	com/tencent/mm/storage/ca$d:getDisplayName	()Ljava/lang/String;
    //   1904: aastore
    //   1905: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1908: astore_0
    //   1909: aload 6
    //   1911: aload_0
    //   1912: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1915: aconst_null
    //   1916: astore_3
    //   1917: iconst_0
    //   1918: istore 13
    //   1920: aload 22
    //   1922: astore 18
    //   1924: goto -997 -> 927
    //   1927: aload 5
    //   1929: ldc_w 502
    //   1932: iconst_1
    //   1933: anewarray 4	java/lang/Object
    //   1936: dup
    //   1937: iconst_0
    //   1938: aload 18
    //   1940: invokevirtual 501	com/tencent/mm/storage/ca$d:getDisplayName	()Ljava/lang/String;
    //   1943: aastore
    //   1944: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1947: astore_0
    //   1948: aconst_null
    //   1949: astore_3
    //   1950: iconst_0
    //   1951: istore 13
    //   1953: aload 22
    //   1955: astore 18
    //   1957: goto -1030 -> 927
    //   1960: aload 5
    //   1962: ldc_w 503
    //   1965: iconst_1
    //   1966: anewarray 4	java/lang/Object
    //   1969: dup
    //   1970: iconst_0
    //   1971: aload 18
    //   1973: invokevirtual 501	com/tencent/mm/storage/ca$d:getDisplayName	()Ljava/lang/String;
    //   1976: aastore
    //   1977: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1980: astore_0
    //   1981: aconst_null
    //   1982: astore_3
    //   1983: iconst_0
    //   1984: istore 13
    //   1986: aload 22
    //   1988: astore 18
    //   1990: goto -1063 -> 927
    //   1993: aload 5
    //   1995: ldc_w 504
    //   1998: iconst_1
    //   1999: anewarray 4	java/lang/Object
    //   2002: dup
    //   2003: iconst_0
    //   2004: aload 18
    //   2006: invokevirtual 501	com/tencent/mm/storage/ca$d:getDisplayName	()Ljava/lang/String;
    //   2009: aastore
    //   2010: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2013: astore_0
    //   2014: aload 6
    //   2016: aload_0
    //   2017: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2020: aconst_null
    //   2021: astore_3
    //   2022: iconst_0
    //   2023: istore 13
    //   2025: aload 22
    //   2027: astore 18
    //   2029: goto -1102 -> 927
    //   2032: aload_3
    //   2033: astore_0
    //   2034: aload_3
    //   2035: ifnull -1117 -> 918
    //   2038: aload_3
    //   2039: astore_0
    //   2040: aload_3
    //   2041: invokevirtual 84	java/lang/String:length	()I
    //   2044: ifle -1126 -> 918
    //   2047: aload_3
    //   2048: invokestatic 510	com/tencent/mm/storage/ca$a:bkA	(Ljava/lang/String;)Lcom/tencent/mm/storage/ca$a;
    //   2051: astore 18
    //   2053: aload_3
    //   2054: astore_0
    //   2055: aload 18
    //   2057: invokevirtual 511	com/tencent/mm/storage/ca$a:gDY	()Ljava/lang/String;
    //   2060: ifnull +43 -> 2103
    //   2063: aload_3
    //   2064: astore_0
    //   2065: aload 18
    //   2067: invokevirtual 511	com/tencent/mm/storage/ca$a:gDY	()Ljava/lang/String;
    //   2070: invokevirtual 84	java/lang/String:length	()I
    //   2073: ifle +30 -> 2103
    //   2076: aload 5
    //   2078: ldc_w 512
    //   2081: iconst_1
    //   2082: anewarray 4	java/lang/Object
    //   2085: dup
    //   2086: iconst_0
    //   2087: aload 18
    //   2089: invokevirtual 513	com/tencent/mm/storage/ca$a:getDisplayName	()Ljava/lang/String;
    //   2092: aastore
    //   2093: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2096: astore_0
    //   2097: aload 6
    //   2099: aload_0
    //   2100: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2103: aconst_null
    //   2104: astore_3
    //   2105: iconst_0
    //   2106: istore 13
    //   2108: aload 22
    //   2110: astore 18
    //   2112: goto -1185 -> 927
    //   2115: aload_3
    //   2116: astore_0
    //   2117: aload_3
    //   2118: invokestatic 154	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2121: invokevirtual 84	java/lang/String:length	()I
    //   2124: ifle -1206 -> 918
    //   2127: invokestatic 277	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   2130: pop
    //   2131: invokestatic 517	com/tencent/mm/model/c:aSQ	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
    //   2134: aload_3
    //   2135: invokeinterface 523 2 0
    //   2140: astore_0
    //   2141: aload 5
    //   2143: ldc_w 524
    //   2146: iconst_2
    //   2147: anewarray 4	java/lang/Object
    //   2150: dup
    //   2151: iconst_0
    //   2152: aload_0
    //   2153: invokevirtual 529	com/tencent/mm/storage/ca$c:getSender	()Ljava/lang/String;
    //   2156: aastore
    //   2157: dup
    //   2158: iconst_1
    //   2159: aload_0
    //   2160: invokevirtual 532	com/tencent/mm/storage/ca$c:getTitle	()Ljava/lang/String;
    //   2163: aastore
    //   2164: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2167: astore_0
    //   2168: aload 6
    //   2170: aload_0
    //   2171: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2174: aconst_null
    //   2175: astore_3
    //   2176: iconst_0
    //   2177: istore 13
    //   2179: aload 22
    //   2181: astore 18
    //   2183: goto -1256 -> 927
    //   2186: aload_3
    //   2187: astore_0
    //   2188: aload_3
    //   2189: invokestatic 154	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2192: invokevirtual 84	java/lang/String:length	()I
    //   2195: ifle -1277 -> 918
    //   2198: aload_2
    //   2199: invokestatic 399	com/tencent/mm/model/ab:Eq	(Ljava/lang/String;)Z
    //   2202: ifeq +20 -> 2222
    //   2205: aload_3
    //   2206: invokestatic 535	com/tencent/mm/model/bp:Ks	(Ljava/lang/String;)Ljava/lang/String;
    //   2209: astore 18
    //   2211: aload 18
    //   2213: astore_0
    //   2214: aload 18
    //   2216: invokestatic 231	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2219: ifeq +5 -> 2224
    //   2222: aload_2
    //   2223: astore_0
    //   2224: invokestatic 277	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   2227: pop
    //   2228: invokestatic 517	com/tencent/mm/model/c:aSQ	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
    //   2231: aload_3
    //   2232: invokeinterface 538 2 0
    //   2237: astore 21
    //   2239: invokestatic 277	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   2242: pop
    //   2243: invokestatic 283	com/tencent/mm/model/c:aSN	()Lcom/tencent/mm/storage/bv;
    //   2246: aload_0
    //   2247: invokeinterface 289 2 0
    //   2252: invokevirtual 375	com/tencent/mm/storage/as:arJ	()Ljava/lang/String;
    //   2255: astore 18
    //   2257: aload 18
    //   2259: astore_3
    //   2260: aload 18
    //   2262: invokestatic 399	com/tencent/mm/model/ab:Eq	(Ljava/lang/String;)Z
    //   2265: ifeq +12 -> 2277
    //   2268: aload 18
    //   2270: invokestatic 544	com/tencent/mm/model/v:If	(Ljava/lang/String;)Ljava/util/List;
    //   2273: invokestatic 548	com/tencent/mm/model/v:an	(Ljava/util/List;)Ljava/lang/String;
    //   2276: astore_3
    //   2277: iload_1
    //   2278: iconst_1
    //   2279: if_icmpne +83 -> 2362
    //   2282: aload 5
    //   2284: ldc_w 549
    //   2287: iconst_2
    //   2288: anewarray 4	java/lang/Object
    //   2291: dup
    //   2292: iconst_0
    //   2293: aload_3
    //   2294: aastore
    //   2295: dup
    //   2296: iconst_1
    //   2297: aload 21
    //   2299: invokevirtual 513	com/tencent/mm/storage/ca$a:getDisplayName	()Ljava/lang/String;
    //   2302: aastore
    //   2303: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2306: astore_3
    //   2307: aload 6
    //   2309: aload 5
    //   2311: ldc_w 549
    //   2314: iconst_2
    //   2315: anewarray 4	java/lang/Object
    //   2318: dup
    //   2319: iconst_0
    //   2320: ldc_w 551
    //   2323: aastore
    //   2324: dup
    //   2325: iconst_1
    //   2326: aload 21
    //   2328: invokevirtual 513	com/tencent/mm/storage/ca$a:getDisplayName	()Ljava/lang/String;
    //   2331: aastore
    //   2332: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2335: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2338: aload 7
    //   2340: aload_0
    //   2341: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2344: aconst_null
    //   2345: astore 18
    //   2347: iconst_0
    //   2348: istore 13
    //   2350: aload_3
    //   2351: astore_0
    //   2352: aload 18
    //   2354: astore_3
    //   2355: aload 22
    //   2357: astore 18
    //   2359: goto -1432 -> 927
    //   2362: aload 5
    //   2364: ldc_w 552
    //   2367: iconst_2
    //   2368: anewarray 4	java/lang/Object
    //   2371: dup
    //   2372: iconst_0
    //   2373: aload_3
    //   2374: aastore
    //   2375: dup
    //   2376: iconst_1
    //   2377: aload 21
    //   2379: invokevirtual 513	com/tencent/mm/storage/ca$a:getDisplayName	()Ljava/lang/String;
    //   2382: aastore
    //   2383: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2386: astore_3
    //   2387: aload 6
    //   2389: aload 5
    //   2391: ldc_w 552
    //   2394: iconst_2
    //   2395: anewarray 4	java/lang/Object
    //   2398: dup
    //   2399: iconst_0
    //   2400: ldc_w 551
    //   2403: aastore
    //   2404: dup
    //   2405: iconst_1
    //   2406: aload 21
    //   2408: invokevirtual 513	com/tencent/mm/storage/ca$a:getDisplayName	()Ljava/lang/String;
    //   2411: aastore
    //   2412: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2415: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2418: aload 7
    //   2420: aload_0
    //   2421: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2424: aconst_null
    //   2425: astore 18
    //   2427: iconst_0
    //   2428: istore 13
    //   2430: aload_3
    //   2431: astore_0
    //   2432: aload 18
    //   2434: astore_3
    //   2435: aload 22
    //   2437: astore 18
    //   2439: goto -1512 -> 927
    //   2442: aload_3
    //   2443: astore_0
    //   2444: aload_3
    //   2445: invokestatic 154	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2448: invokevirtual 84	java/lang/String:length	()I
    //   2451: ifle -1533 -> 918
    //   2454: aload_2
    //   2455: invokestatic 399	com/tencent/mm/model/ab:Eq	(Ljava/lang/String;)Z
    //   2458: ifeq +8840 -> 11298
    //   2461: aload_3
    //   2462: invokestatic 407	com/tencent/mm/model/bp:Kp	(Ljava/lang/String;)I
    //   2465: istore 13
    //   2467: iload 13
    //   2469: iconst_m1
    //   2470: if_icmpeq +8823 -> 11293
    //   2473: aload_3
    //   2474: iconst_0
    //   2475: iload 13
    //   2477: invokevirtual 91	java/lang/String:substring	(II)Ljava/lang/String;
    //   2480: invokevirtual 343	java/lang/String:trim	()Ljava/lang/String;
    //   2483: astore_0
    //   2484: aload_3
    //   2485: invokestatic 555	com/tencent/mm/model/bp:Kt	(Ljava/lang/String;)Ljava/lang/String;
    //   2488: pop
    //   2489: iload_1
    //   2490: iconst_1
    //   2491: if_icmpne +30 -> 2521
    //   2494: aload 5
    //   2496: ldc_w 556
    //   2499: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   2502: astore_0
    //   2503: aload 6
    //   2505: aload_0
    //   2506: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2509: aconst_null
    //   2510: astore_3
    //   2511: iconst_0
    //   2512: istore 13
    //   2514: aload 22
    //   2516: astore 18
    //   2518: goto -1591 -> 927
    //   2521: aload 5
    //   2523: ldc_w 556
    //   2526: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   2529: astore 18
    //   2531: aload 6
    //   2533: aload 5
    //   2535: ldc_w 556
    //   2538: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   2541: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2544: aload 7
    //   2546: aload_0
    //   2547: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2550: aconst_null
    //   2551: astore_3
    //   2552: iconst_0
    //   2553: istore 13
    //   2555: aload 18
    //   2557: astore_0
    //   2558: aload 22
    //   2560: astore 18
    //   2562: goto -1635 -> 927
    //   2565: aload 21
    //   2567: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   2570: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   2573: astore_0
    //   2574: aload_0
    //   2575: getfield 568	com/tencent/mm/ag/k$b:ixg	I
    //   2578: ifeq +94 -> 2672
    //   2581: aload_0
    //   2582: getfield 568	com/tencent/mm/ag/k$b:ixg	I
    //   2585: iconst_1
    //   2586: if_icmpne +46 -> 2632
    //   2589: aload 5
    //   2591: ldc_w 569
    //   2594: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   2597: astore_0
    //   2598: ldc 26
    //   2600: astore_3
    //   2601: aload 7
    //   2603: aload 19
    //   2605: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2608: aload 6
    //   2610: ldc 26
    //   2612: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2615: aload_0
    //   2616: astore 18
    //   2618: aconst_null
    //   2619: astore 21
    //   2621: iconst_0
    //   2622: istore 13
    //   2624: aload_3
    //   2625: astore_0
    //   2626: aload 21
    //   2628: astore_3
    //   2629: goto -1702 -> 927
    //   2632: aload_0
    //   2633: getfield 568	com/tencent/mm/ag/k$b:ixg	I
    //   2636: iconst_2
    //   2637: if_icmpne +15 -> 2652
    //   2640: aload 5
    //   2642: ldc_w 570
    //   2645: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   2648: astore_0
    //   2649: goto -51 -> 2598
    //   2652: aload_0
    //   2653: getfield 568	com/tencent/mm/ag/k$b:ixg	I
    //   2656: iconst_3
    //   2657: if_icmpne +15 -> 2672
    //   2660: aload 5
    //   2662: ldc_w 571
    //   2665: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   2668: astore_0
    //   2669: goto -71 -> 2598
    //   2672: aload 5
    //   2674: ldc_w 572
    //   2677: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   2680: astore_0
    //   2681: goto -83 -> 2598
    //   2684: aload 21
    //   2686: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   2689: astore_3
    //   2690: ldc 26
    //   2692: astore 18
    //   2694: ldc 26
    //   2696: astore_0
    //   2697: aload_3
    //   2698: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   2701: astore_3
    //   2702: aload_3
    //   2703: ifnull +45 -> 2748
    //   2706: aload 6
    //   2708: new 86	java/lang/StringBuilder
    //   2711: dup
    //   2712: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   2715: aload 5
    //   2717: ldc_w 573
    //   2720: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   2723: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2726: aload_3
    //   2727: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   2730: invokestatic 154	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2733: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2736: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2739: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2742: aload 6
    //   2744: getfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2747: astore_0
    //   2748: aload 7
    //   2750: aload 19
    //   2752: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2755: aconst_null
    //   2756: astore_3
    //   2757: iconst_0
    //   2758: istore 13
    //   2760: goto -1833 -> 927
    //   2763: aload 21
    //   2765: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   2768: astore_3
    //   2769: ldc 26
    //   2771: astore 18
    //   2773: ldc 26
    //   2775: astore_0
    //   2776: aload_3
    //   2777: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   2780: astore_3
    //   2781: aload_3
    //   2782: ifnull +92 -> 2874
    //   2785: iload_1
    //   2786: iconst_1
    //   2787: if_icmpne +102 -> 2889
    //   2790: iconst_1
    //   2791: istore 13
    //   2793: aload_2
    //   2794: invokestatic 399	com/tencent/mm/model/ab:Eq	(Ljava/lang/String;)Z
    //   2797: ifne +10 -> 2807
    //   2800: aload_2
    //   2801: invokestatic 402	com/tencent/mm/model/ab:Iy	(Ljava/lang/String;)Z
    //   2804: ifeq +91 -> 2895
    //   2807: iconst_1
    //   2808: istore 16
    //   2810: aload_3
    //   2811: getfield 579	com/tencent/mm/ag/k$b:ixN	I
    //   2814: tableswitch	default:+42 -> 2856, 1:+87->2901, 2:+642->3456, 3:+198->3012, 4:+309->3123, 5:+420->3234, 6:+531->3345, 7:+87->2901
    //   2857: iconst_3
    //   2858: aload_3
    //   2859: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   2862: invokestatic 154	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   2865: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2868: aload 6
    //   2870: getfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2873: astore_0
    //   2874: aload 7
    //   2876: aload 19
    //   2878: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2881: aconst_null
    //   2882: astore_3
    //   2883: iconst_0
    //   2884: istore 13
    //   2886: goto -1959 -> 927
    //   2889: iconst_0
    //   2890: istore 13
    //   2892: goto -99 -> 2793
    //   2895: iconst_0
    //   2896: istore 16
    //   2898: goto -88 -> 2810
    //   2901: iload 16
    //   2903: ifeq +72 -> 2975
    //   2906: iload_1
    //   2907: ifne +52 -> 2959
    //   2910: aload 20
    //   2912: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   2915: ifne +44 -> 2959
    //   2918: aload 6
    //   2920: ldc_w 581
    //   2923: iconst_2
    //   2924: anewarray 4	java/lang/Object
    //   2927: dup
    //   2928: iconst_0
    //   2929: aload 20
    //   2931: aastore
    //   2932: dup
    //   2933: iconst_1
    //   2934: aload 5
    //   2936: ldc_w 582
    //   2939: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   2942: aastore
    //   2943: invokestatic 586	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   2946: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2949: aload 7
    //   2951: aload 20
    //   2953: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2956: goto -88 -> 2868
    //   2959: aload 6
    //   2961: aload 5
    //   2963: ldc_w 582
    //   2966: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   2969: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2972: goto -23 -> 2949
    //   2975: iload 13
    //   2977: ifeq +19 -> 2996
    //   2980: aload 6
    //   2982: aload 5
    //   2984: ldc_w 587
    //   2987: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   2990: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   2993: goto -125 -> 2868
    //   2996: aload 6
    //   2998: aload 5
    //   3000: ldc_w 588
    //   3003: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3006: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3009: goto -141 -> 2868
    //   3012: iload 16
    //   3014: ifeq +72 -> 3086
    //   3017: iload_1
    //   3018: ifne +52 -> 3070
    //   3021: aload 20
    //   3023: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   3026: ifne +44 -> 3070
    //   3029: aload 6
    //   3031: ldc_w 581
    //   3034: iconst_2
    //   3035: anewarray 4	java/lang/Object
    //   3038: dup
    //   3039: iconst_0
    //   3040: aload 20
    //   3042: aastore
    //   3043: dup
    //   3044: iconst_1
    //   3045: aload 5
    //   3047: ldc_w 589
    //   3050: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3053: aastore
    //   3054: invokestatic 586	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3057: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3060: aload 7
    //   3062: aload 20
    //   3064: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3067: goto -199 -> 2868
    //   3070: aload 6
    //   3072: aload 5
    //   3074: ldc_w 589
    //   3077: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3080: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3083: goto -23 -> 3060
    //   3086: iload 13
    //   3088: ifeq +19 -> 3107
    //   3091: aload 6
    //   3093: aload 5
    //   3095: ldc_w 590
    //   3098: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3101: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3104: goto -236 -> 2868
    //   3107: aload 6
    //   3109: aload 5
    //   3111: ldc_w 591
    //   3114: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3117: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3120: goto -252 -> 2868
    //   3123: iload 16
    //   3125: ifeq +72 -> 3197
    //   3128: iload_1
    //   3129: ifne +52 -> 3181
    //   3132: aload 20
    //   3134: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   3137: ifne +44 -> 3181
    //   3140: aload 6
    //   3142: ldc_w 581
    //   3145: iconst_2
    //   3146: anewarray 4	java/lang/Object
    //   3149: dup
    //   3150: iconst_0
    //   3151: aload 20
    //   3153: aastore
    //   3154: dup
    //   3155: iconst_1
    //   3156: aload 5
    //   3158: ldc_w 592
    //   3161: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3164: aastore
    //   3165: invokestatic 586	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3168: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3171: aload 7
    //   3173: aload 20
    //   3175: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3178: goto -310 -> 2868
    //   3181: aload 6
    //   3183: aload 5
    //   3185: ldc_w 592
    //   3188: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3191: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3194: goto -23 -> 3171
    //   3197: iload 13
    //   3199: ifeq +19 -> 3218
    //   3202: aload 6
    //   3204: aload 5
    //   3206: ldc_w 593
    //   3209: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3212: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3215: goto -347 -> 2868
    //   3218: aload 6
    //   3220: aload 5
    //   3222: ldc_w 594
    //   3225: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3228: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3231: goto -363 -> 2868
    //   3234: iload 16
    //   3236: ifeq +72 -> 3308
    //   3239: iload_1
    //   3240: ifne +52 -> 3292
    //   3243: aload 20
    //   3245: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   3248: ifne +44 -> 3292
    //   3251: aload 6
    //   3253: ldc_w 581
    //   3256: iconst_2
    //   3257: anewarray 4	java/lang/Object
    //   3260: dup
    //   3261: iconst_0
    //   3262: aload 20
    //   3264: aastore
    //   3265: dup
    //   3266: iconst_1
    //   3267: aload 5
    //   3269: ldc_w 595
    //   3272: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3275: aastore
    //   3276: invokestatic 586	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3279: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3282: aload 7
    //   3284: aload 20
    //   3286: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3289: goto -421 -> 2868
    //   3292: aload 6
    //   3294: aload 5
    //   3296: ldc_w 595
    //   3299: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3302: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3305: goto -23 -> 3282
    //   3308: iload 13
    //   3310: ifeq +19 -> 3329
    //   3313: aload 6
    //   3315: aload 5
    //   3317: ldc_w 596
    //   3320: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3323: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3326: goto -458 -> 2868
    //   3329: aload 6
    //   3331: aload 5
    //   3333: ldc_w 591
    //   3336: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3339: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3342: goto -474 -> 2868
    //   3345: iload 16
    //   3347: ifeq +72 -> 3419
    //   3350: iload_1
    //   3351: ifne +52 -> 3403
    //   3354: aload 20
    //   3356: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   3359: ifne +44 -> 3403
    //   3362: aload 6
    //   3364: ldc_w 581
    //   3367: iconst_2
    //   3368: anewarray 4	java/lang/Object
    //   3371: dup
    //   3372: iconst_0
    //   3373: aload 20
    //   3375: aastore
    //   3376: dup
    //   3377: iconst_1
    //   3378: aload 5
    //   3380: ldc_w 597
    //   3383: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3386: aastore
    //   3387: invokestatic 586	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3390: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3393: aload 7
    //   3395: aload 20
    //   3397: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3400: goto -532 -> 2868
    //   3403: aload 6
    //   3405: aload 5
    //   3407: ldc_w 597
    //   3410: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3413: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3416: goto -23 -> 3393
    //   3419: iload 13
    //   3421: ifeq +19 -> 3440
    //   3424: aload 6
    //   3426: aload 5
    //   3428: ldc_w 598
    //   3431: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3434: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3437: goto -569 -> 2868
    //   3440: aload 6
    //   3442: aload 5
    //   3444: ldc_w 598
    //   3447: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3450: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3453: goto -585 -> 2868
    //   3456: iload 16
    //   3458: ifeq +72 -> 3530
    //   3461: iload_1
    //   3462: ifne +52 -> 3514
    //   3465: aload 20
    //   3467: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   3470: ifne +44 -> 3514
    //   3473: aload 6
    //   3475: ldc_w 581
    //   3478: iconst_2
    //   3479: anewarray 4	java/lang/Object
    //   3482: dup
    //   3483: iconst_0
    //   3484: aload 20
    //   3486: aastore
    //   3487: dup
    //   3488: iconst_1
    //   3489: aload 5
    //   3491: ldc_w 599
    //   3494: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3497: aastore
    //   3498: invokestatic 586	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3501: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3504: aload 7
    //   3506: aload 20
    //   3508: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3511: goto -643 -> 2868
    //   3514: aload 6
    //   3516: aload 5
    //   3518: ldc_w 599
    //   3521: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3524: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3527: goto -23 -> 3504
    //   3530: iload 13
    //   3532: ifeq +19 -> 3551
    //   3535: aload 6
    //   3537: aload 5
    //   3539: ldc_w 600
    //   3542: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3545: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3548: goto -680 -> 2868
    //   3551: aload 6
    //   3553: aload 5
    //   3555: ldc_w 600
    //   3558: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   3561: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3564: goto -696 -> 2868
    //   3567: aload 21
    //   3569: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   3572: astore_0
    //   3573: ldc 26
    //   3575: astore 18
    //   3577: ldc 26
    //   3579: astore_3
    //   3580: aload_0
    //   3581: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   3584: astore_0
    //   3585: aload_0
    //   3586: ifnull +60 -> 3646
    //   3589: iload_1
    //   3590: iconst_1
    //   3591: if_icmpne +92 -> 3683
    //   3594: iconst_1
    //   3595: istore 13
    //   3597: iload 13
    //   3599: ifeq +90 -> 3689
    //   3602: aload 6
    //   3604: new 86	java/lang/StringBuilder
    //   3607: dup
    //   3608: ldc_w 602
    //   3611: invokespecial 603	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3614: aload_0
    //   3615: getfield 606	com/tencent/mm/ag/k$b:iyo	Ljava/lang/String;
    //   3618: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3621: ldc_w 608
    //   3624: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3627: aload_0
    //   3628: getfield 611	com/tencent/mm/ag/k$b:iyl	Ljava/lang/String;
    //   3631: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3634: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3637: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3640: aload 6
    //   3642: getfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3645: astore_3
    //   3646: aload_3
    //   3647: astore_0
    //   3648: aload_2
    //   3649: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   3652: ifne +7595 -> 11247
    //   3655: aload_3
    //   3656: astore_0
    //   3657: iload 14
    //   3659: ifne +7588 -> 11247
    //   3662: aload 7
    //   3664: aload 19
    //   3666: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3669: aconst_null
    //   3670: astore 21
    //   3672: iconst_0
    //   3673: istore 13
    //   3675: aload_3
    //   3676: astore_0
    //   3677: aload 21
    //   3679: astore_3
    //   3680: goto -2753 -> 927
    //   3683: iconst_0
    //   3684: istore 13
    //   3686: goto -89 -> 3597
    //   3689: aload 20
    //   3691: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   3694: ifne +55 -> 3749
    //   3697: aload 6
    //   3699: new 86	java/lang/StringBuilder
    //   3702: dup
    //   3703: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   3706: aload 20
    //   3708: invokestatic 154	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   3711: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3714: ldc_w 613
    //   3717: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3720: aload_0
    //   3721: getfield 606	com/tencent/mm/ag/k$b:iyo	Ljava/lang/String;
    //   3724: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3727: ldc_w 608
    //   3730: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3733: aload_0
    //   3734: getfield 616	com/tencent/mm/ag/k$b:iyk	Ljava/lang/String;
    //   3737: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3740: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3743: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3746: goto -106 -> 3640
    //   3749: aload 6
    //   3751: new 86	java/lang/StringBuilder
    //   3754: dup
    //   3755: ldc_w 602
    //   3758: invokespecial 603	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3761: aload_0
    //   3762: getfield 606	com/tencent/mm/ag/k$b:iyo	Ljava/lang/String;
    //   3765: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3768: ldc_w 608
    //   3771: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3774: aload_0
    //   3775: getfield 616	com/tencent/mm/ag/k$b:iyk	Ljava/lang/String;
    //   3778: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3781: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3784: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3787: goto -147 -> 3640
    //   3790: aload 21
    //   3792: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   3795: astore_3
    //   3796: ldc 26
    //   3798: astore 18
    //   3800: ldc 26
    //   3802: astore_0
    //   3803: aload_3
    //   3804: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   3807: astore_3
    //   3808: aload_3
    //   3809: ifnull +7438 -> 11247
    //   3812: aload_3
    //   3813: ldc_w 618
    //   3816: invokevirtual 622	com/tencent/mm/ag/k$b:as	(Ljava/lang/Class;)Lcom/tencent/mm/ag/f;
    //   3819: checkcast 618	com/tencent/mm/ag/b
    //   3822: astore_0
    //   3823: iload_1
    //   3824: iconst_1
    //   3825: if_icmpne +56 -> 3881
    //   3828: iconst_1
    //   3829: istore 13
    //   3831: iload 13
    //   3833: ifeq +54 -> 3887
    //   3836: aload 6
    //   3838: aload 5
    //   3840: ldc_w 623
    //   3843: iconst_1
    //   3844: anewarray 4	java/lang/Object
    //   3847: dup
    //   3848: iconst_0
    //   3849: aload_0
    //   3850: getfield 626	com/tencent/mm/ag/b:ivG	Ljava/lang/String;
    //   3853: aastore
    //   3854: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3857: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3860: aload 6
    //   3862: getfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3865: astore_0
    //   3866: aload 7
    //   3868: aload 19
    //   3870: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3873: aconst_null
    //   3874: astore_3
    //   3875: iconst_0
    //   3876: istore 13
    //   3878: goto -2951 -> 927
    //   3881: iconst_0
    //   3882: istore 13
    //   3884: goto -53 -> 3831
    //   3887: aload 6
    //   3889: aload 5
    //   3891: ldc_w 623
    //   3894: iconst_1
    //   3895: anewarray 4	java/lang/Object
    //   3898: dup
    //   3899: iconst_0
    //   3900: aload_0
    //   3901: getfield 629	com/tencent/mm/ag/b:ivH	Ljava/lang/String;
    //   3904: aastore
    //   3905: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3908: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3911: goto -51 -> 3860
    //   3914: aload 21
    //   3916: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   3919: astore_3
    //   3920: ldc 26
    //   3922: astore_0
    //   3923: aload_3
    //   3924: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   3927: astore_3
    //   3928: aload_3
    //   3929: ifnull +42 -> 3971
    //   3932: aload_3
    //   3933: ldc_w 631
    //   3936: invokevirtual 622	com/tencent/mm/ag/k$b:as	(Ljava/lang/Class;)Lcom/tencent/mm/ag/f;
    //   3939: checkcast 631	com/tencent/mm/ui/chatting/viewitems/k$a
    //   3942: astore_0
    //   3943: aload_0
    //   3944: getfield 634	com/tencent/mm/ui/chatting/viewitems/k$a:state	I
    //   3947: iconst_1
    //   3948: if_icmpne +41 -> 3989
    //   3951: aload 5
    //   3953: ldc_w 635
    //   3956: iconst_1
    //   3957: anewarray 4	java/lang/Object
    //   3960: dup
    //   3961: iconst_0
    //   3962: aload_0
    //   3963: getfield 638	com/tencent/mm/ui/chatting/viewitems/k$a:appName	Ljava/lang/String;
    //   3966: aastore
    //   3967: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3970: astore_0
    //   3971: aload 6
    //   3973: aload_0
    //   3974: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   3977: aconst_null
    //   3978: astore_3
    //   3979: iconst_0
    //   3980: istore 13
    //   3982: aload 22
    //   3984: astore 18
    //   3986: goto -3059 -> 927
    //   3989: aload 5
    //   3991: ldc_w 639
    //   3994: iconst_1
    //   3995: anewarray 4	java/lang/Object
    //   3998: dup
    //   3999: iconst_0
    //   4000: aload_0
    //   4001: getfield 638	com/tencent/mm/ui/chatting/viewitems/k$a:appName	Ljava/lang/String;
    //   4004: aastore
    //   4005: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   4008: astore_0
    //   4009: goto -38 -> 3971
    //   4012: aload 21
    //   4014: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   4017: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   4020: getfield 568	com/tencent/mm/ag/k$b:ixg	I
    //   4023: lookupswitch	default:+25->4048, 10000:+107->4130, 20000:+119->4142
    //   4049: iconst_2
    //   4050: ldc_w 640
    //   4053: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   4056: astore_0
    //   4057: aload 19
    //   4059: invokevirtual 84	java/lang/String:length	()I
    //   4062: ifle +92 -> 4154
    //   4065: new 86	java/lang/StringBuilder
    //   4068: dup
    //   4069: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   4072: aload 19
    //   4074: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4077: ldc_w 443
    //   4080: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4083: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4086: astore_3
    //   4087: aload_2
    //   4088: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   4091: ifne +15 -> 4106
    //   4094: iload 14
    //   4096: ifne +10 -> 4106
    //   4099: aload 7
    //   4101: aload 19
    //   4103: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4106: aload 6
    //   4108: ldc 26
    //   4110: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4113: aload_0
    //   4114: astore 18
    //   4116: aconst_null
    //   4117: astore 21
    //   4119: iconst_0
    //   4120: istore 13
    //   4122: aload_3
    //   4123: astore_0
    //   4124: aload 21
    //   4126: astore_3
    //   4127: goto -3200 -> 927
    //   4130: aload 5
    //   4132: ldc_w 641
    //   4135: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   4138: astore_0
    //   4139: goto -82 -> 4057
    //   4142: aload 5
    //   4144: ldc_w 642
    //   4147: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   4150: astore_0
    //   4151: goto -94 -> 4057
    //   4154: ldc 26
    //   4156: astore_3
    //   4157: goto -70 -> 4087
    //   4160: aload 21
    //   4162: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   4165: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   4168: astore_3
    //   4169: aload_3
    //   4170: ifnonnull +21 -> 4191
    //   4173: ldc_w 644
    //   4176: ldc_w 646
    //   4179: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4182: ldc_w 379
    //   4185: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4188: ldc 26
    //   4190: areturn
    //   4191: ldc 26
    //   4193: astore 18
    //   4195: aload 5
    //   4197: ldc_w 652
    //   4200: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   4203: astore 21
    //   4205: aload 19
    //   4207: invokevirtual 84	java/lang/String:length	()I
    //   4210: ifle +104 -> 4314
    //   4213: new 86	java/lang/StringBuilder
    //   4216: dup
    //   4217: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   4220: aload 19
    //   4222: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4225: ldc_w 443
    //   4228: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4231: aload 21
    //   4233: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4236: aload_3
    //   4237: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   4240: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4243: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4246: astore_0
    //   4247: aload_2
    //   4248: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   4251: ifne +15 -> 4266
    //   4254: iload 14
    //   4256: ifne +10 -> 4266
    //   4259: aload 7
    //   4261: aload 19
    //   4263: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4266: aload 19
    //   4268: invokevirtual 84	java/lang/String:length	()I
    //   4271: ifle +69 -> 4340
    //   4274: new 86	java/lang/StringBuilder
    //   4277: dup
    //   4278: ldc_w 445
    //   4281: invokespecial 603	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4284: aload 21
    //   4286: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4289: aload_3
    //   4290: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   4293: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4296: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4299: astore_3
    //   4300: aload 6
    //   4302: aload_3
    //   4303: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4306: aconst_null
    //   4307: astore_3
    //   4308: iconst_0
    //   4309: istore 13
    //   4311: goto -3384 -> 927
    //   4314: new 86	java/lang/StringBuilder
    //   4317: dup
    //   4318: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   4321: aload 21
    //   4323: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4326: aload_3
    //   4327: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   4330: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4333: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4336: astore_0
    //   4337: goto -90 -> 4247
    //   4340: new 86	java/lang/StringBuilder
    //   4343: dup
    //   4344: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   4347: aload 21
    //   4349: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4352: aload_3
    //   4353: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   4356: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4359: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4362: astore_3
    //   4363: goto -63 -> 4300
    //   4366: aload 21
    //   4368: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   4371: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   4374: astore_0
    //   4375: aload_0
    //   4376: ifnonnull +21 -> 4397
    //   4379: ldc_w 644
    //   4382: ldc_w 646
    //   4385: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4388: ldc_w 379
    //   4391: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4394: ldc 26
    //   4396: areturn
    //   4397: ldc 26
    //   4399: astore 18
    //   4401: aload 5
    //   4403: ldc_w 652
    //   4406: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   4409: astore_3
    //   4410: iload_1
    //   4411: iconst_1
    //   4412: if_icmpne +95 -> 4507
    //   4415: new 86	java/lang/StringBuilder
    //   4418: dup
    //   4419: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   4422: aload_3
    //   4423: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4426: aload_0
    //   4427: getfield 655	com/tencent/mm/ag/k$b:iyb	Ljava/lang/String;
    //   4430: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4433: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4436: astore_3
    //   4437: aload 19
    //   4439: invokevirtual 84	java/lang/String:length	()I
    //   4442: ifle +57 -> 4499
    //   4445: ldc_w 445
    //   4448: aload_3
    //   4449: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4452: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4455: astore_0
    //   4456: aload 6
    //   4458: aload_0
    //   4459: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4462: aload_3
    //   4463: astore_0
    //   4464: aload_2
    //   4465: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   4468: ifne +6779 -> 11247
    //   4471: aload_3
    //   4472: astore_0
    //   4473: iload 14
    //   4475: ifne +6772 -> 11247
    //   4478: aload 7
    //   4480: aload 19
    //   4482: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4485: aconst_null
    //   4486: astore 21
    //   4488: iconst_0
    //   4489: istore 13
    //   4491: aload_3
    //   4492: astore_0
    //   4493: aload 21
    //   4495: astore_3
    //   4496: goto -3569 -> 927
    //   4499: aload_3
    //   4500: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4503: astore_0
    //   4504: goto -48 -> 4456
    //   4507: new 86	java/lang/StringBuilder
    //   4510: dup
    //   4511: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   4514: aload_3
    //   4515: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4518: aload_0
    //   4519: getfield 664	com/tencent/mm/ag/k$b:iya	Ljava/lang/String;
    //   4522: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4525: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4528: astore_3
    //   4529: aload 19
    //   4531: invokevirtual 84	java/lang/String:length	()I
    //   4534: ifle +23 -> 4557
    //   4537: ldc_w 445
    //   4540: aload_3
    //   4541: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4544: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4547: astore_0
    //   4548: aload 6
    //   4550: aload_0
    //   4551: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4554: goto -92 -> 4462
    //   4557: aload_3
    //   4558: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4561: astore_0
    //   4562: goto -14 -> 4548
    //   4565: aload 21
    //   4567: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   4570: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   4573: astore_3
    //   4574: aload_3
    //   4575: ifnonnull +21 -> 4596
    //   4578: ldc_w 644
    //   4581: ldc_w 646
    //   4584: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4587: ldc_w 379
    //   4590: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4593: ldc 26
    //   4595: areturn
    //   4596: ldc 26
    //   4598: astore 18
    //   4600: aload 19
    //   4602: invokevirtual 84	java/lang/String:length	()I
    //   4605: ifle +94 -> 4699
    //   4608: new 86	java/lang/StringBuilder
    //   4611: dup
    //   4612: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   4615: aload 19
    //   4617: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4620: ldc_w 443
    //   4623: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4626: aload_3
    //   4627: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   4630: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4633: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4636: astore_0
    //   4637: aload_2
    //   4638: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   4641: ifne +15 -> 4656
    //   4644: iload 14
    //   4646: ifne +10 -> 4656
    //   4649: aload 7
    //   4651: aload 19
    //   4653: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4656: aload 19
    //   4658: invokevirtual 84	java/lang/String:length	()I
    //   4661: ifle +46 -> 4707
    //   4664: new 86	java/lang/StringBuilder
    //   4667: dup
    //   4668: ldc_w 445
    //   4671: invokespecial 603	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4674: aload_3
    //   4675: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   4678: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4681: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4684: astore_3
    //   4685: aload 6
    //   4687: aload_3
    //   4688: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4691: aconst_null
    //   4692: astore_3
    //   4693: iconst_0
    //   4694: istore 13
    //   4696: goto -3769 -> 927
    //   4699: aload_3
    //   4700: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   4703: astore_0
    //   4704: goto -67 -> 4637
    //   4707: aload_3
    //   4708: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   4711: astore_3
    //   4712: goto -27 -> 4685
    //   4715: aload 5
    //   4717: ldc_w 665
    //   4720: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   4723: astore 18
    //   4725: aload 19
    //   4727: invokevirtual 84	java/lang/String:length	()I
    //   4730: ifle +70 -> 4800
    //   4733: new 86	java/lang/StringBuilder
    //   4736: dup
    //   4737: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   4740: aload 19
    //   4742: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4745: ldc_w 443
    //   4748: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4751: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4754: astore_0
    //   4755: aload_2
    //   4756: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   4759: ifne +15 -> 4774
    //   4762: iload 14
    //   4764: ifne +10 -> 4774
    //   4767: aload 7
    //   4769: aload 19
    //   4771: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4774: aload 19
    //   4776: invokevirtual 84	java/lang/String:length	()I
    //   4779: ifle +27 -> 4806
    //   4782: ldc_w 445
    //   4785: astore_3
    //   4786: aload 6
    //   4788: aload_3
    //   4789: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4792: aconst_null
    //   4793: astore_3
    //   4794: iconst_0
    //   4795: istore 13
    //   4797: goto -3870 -> 927
    //   4800: ldc 26
    //   4802: astore_0
    //   4803: goto -48 -> 4755
    //   4806: ldc 26
    //   4808: astore_3
    //   4809: goto -23 -> 4786
    //   4812: aload 21
    //   4814: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   4817: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   4820: astore_0
    //   4821: aload_0
    //   4822: ifnonnull +21 -> 4843
    //   4825: ldc_w 644
    //   4828: ldc_w 646
    //   4831: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4834: ldc_w 379
    //   4837: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4840: ldc 26
    //   4842: areturn
    //   4843: ldc 26
    //   4845: astore 18
    //   4847: aload_0
    //   4848: getfield 668	com/tencent/mm/ag/k$b:content	Ljava/lang/String;
    //   4851: ldc_w 670
    //   4854: invokestatic 675	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4857: astore_0
    //   4858: aload_0
    //   4859: astore_3
    //   4860: aload_0
    //   4861: invokestatic 224	com/tencent/mm/pluginsdk/ui/span/l:bfh	(Ljava/lang/String;)Ljava/lang/String;
    //   4864: astore_0
    //   4865: aload_2
    //   4866: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   4869: ifne +15 -> 4884
    //   4872: iload 14
    //   4874: ifne +10 -> 4884
    //   4877: aload 7
    //   4879: aload 19
    //   4881: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4884: aload 19
    //   4886: invokevirtual 84	java/lang/String:length	()I
    //   4889: ifle +49 -> 4938
    //   4892: ldc_w 445
    //   4895: aload_0
    //   4896: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4899: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   4902: astore_3
    //   4903: aload 6
    //   4905: aload_3
    //   4906: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4909: aconst_null
    //   4910: astore_3
    //   4911: iconst_0
    //   4912: istore 13
    //   4914: goto -3987 -> 927
    //   4917: astore 21
    //   4919: aload_3
    //   4920: astore_0
    //   4921: ldc_w 644
    //   4924: aload 21
    //   4926: ldc 26
    //   4928: iconst_0
    //   4929: anewarray 4	java/lang/Object
    //   4932: invokestatic 679	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4935: goto -70 -> 4865
    //   4938: aload_0
    //   4939: astore_3
    //   4940: goto -37 -> 4903
    //   4943: ldc 26
    //   4945: astore 18
    //   4947: aload 21
    //   4949: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   4952: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   4955: astore_0
    //   4956: aload_0
    //   4957: ifnonnull +21 -> 4978
    //   4960: ldc_w 644
    //   4963: ldc_w 646
    //   4966: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   4969: ldc_w 379
    //   4972: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4975: ldc 26
    //   4977: areturn
    //   4978: aload_2
    //   4979: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   4982: ifne +15 -> 4997
    //   4985: iload 14
    //   4987: ifne +10 -> 4997
    //   4990: aload 7
    //   4992: aload 19
    //   4994: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   4997: aload 5
    //   4999: ldc_w 680
    //   5002: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   5005: astore_3
    //   5006: aload_0
    //   5007: ldc_w 682
    //   5010: invokevirtual 622	com/tencent/mm/ag/k$b:as	(Ljava/lang/Class;)Lcom/tencent/mm/ag/f;
    //   5013: checkcast 682	com/tencent/mm/plugin/i/a/f
    //   5016: astore_0
    //   5017: aload_0
    //   5018: ifnull +6270 -> 11288
    //   5021: aload_0
    //   5022: invokevirtual 686	com/tencent/mm/plugin/i/a/f:dJx	()Lcom/tencent/mm/protocal/protobuf/bcj;
    //   5025: getfield 691	com/tencent/mm/protocal/protobuf/bcj:nickname	Ljava/lang/String;
    //   5028: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5031: ifne +6257 -> 11288
    //   5034: aload_0
    //   5035: invokevirtual 686	com/tencent/mm/plugin/i/a/f:dJx	()Lcom/tencent/mm/protocal/protobuf/bcj;
    //   5038: getfield 694	com/tencent/mm/protocal/protobuf/bcj:desc	Ljava/lang/String;
    //   5041: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5044: ifeq +78 -> 5122
    //   5047: aload 5
    //   5049: ldc_w 695
    //   5052: iconst_1
    //   5053: anewarray 4	java/lang/Object
    //   5056: dup
    //   5057: iconst_0
    //   5058: aload_0
    //   5059: invokevirtual 686	com/tencent/mm/plugin/i/a/f:dJx	()Lcom/tencent/mm/protocal/protobuf/bcj;
    //   5062: getfield 691	com/tencent/mm/protocal/protobuf/bcj:nickname	Ljava/lang/String;
    //   5065: aastore
    //   5066: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   5069: astore_0
    //   5070: new 86	java/lang/StringBuilder
    //   5073: dup
    //   5074: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   5077: aload_3
    //   5078: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5081: aload_0
    //   5082: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5085: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5088: astore_0
    //   5089: aload 19
    //   5091: invokevirtual 84	java/lang/String:length	()I
    //   5094: ifle +39 -> 5133
    //   5097: ldc_w 445
    //   5100: aload_0
    //   5101: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5104: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   5107: astore_3
    //   5108: aload 6
    //   5110: aload_3
    //   5111: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5114: aconst_null
    //   5115: astore_3
    //   5116: iconst_0
    //   5117: istore 13
    //   5119: goto -4192 -> 927
    //   5122: aload_0
    //   5123: invokevirtual 686	com/tencent/mm/plugin/i/a/f:dJx	()Lcom/tencent/mm/protocal/protobuf/bcj;
    //   5126: getfield 694	com/tencent/mm/protocal/protobuf/bcj:desc	Ljava/lang/String;
    //   5129: astore_0
    //   5130: goto -60 -> 5070
    //   5133: aload_0
    //   5134: astore_3
    //   5135: goto -27 -> 5108
    //   5138: ldc 26
    //   5140: astore 18
    //   5142: aload 21
    //   5144: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   5147: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   5150: astore_0
    //   5151: aload_0
    //   5152: ifnonnull +21 -> 5173
    //   5155: ldc_w 644
    //   5158: ldc_w 646
    //   5161: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5164: ldc_w 379
    //   5167: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5170: ldc 26
    //   5172: areturn
    //   5173: aload_2
    //   5174: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   5177: ifne +15 -> 5192
    //   5180: iload 14
    //   5182: ifne +10 -> 5192
    //   5185: aload 7
    //   5187: aload 19
    //   5189: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5192: aload 5
    //   5194: ldc_w 680
    //   5197: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   5200: astore_3
    //   5201: aload_0
    //   5202: ldc_w 697
    //   5205: invokevirtual 622	com/tencent/mm/ag/k$b:as	(Ljava/lang/Class;)Lcom/tencent/mm/ag/f;
    //   5208: checkcast 697	com/tencent/mm/plugin/i/a/i
    //   5211: astore_0
    //   5212: aload_0
    //   5213: ifnull +6070 -> 11283
    //   5216: aload_0
    //   5217: invokevirtual 701	com/tencent/mm/plugin/i/a/i:dJz	()Lcom/tencent/mm/protocal/protobuf/col;
    //   5220: getfield 704	com/tencent/mm/protocal/protobuf/col:nickname	Ljava/lang/String;
    //   5223: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5226: ifne +6057 -> 11283
    //   5229: aload_0
    //   5230: invokevirtual 701	com/tencent/mm/plugin/i/a/i:dJz	()Lcom/tencent/mm/protocal/protobuf/col;
    //   5233: getfield 705	com/tencent/mm/protocal/protobuf/col:desc	Ljava/lang/String;
    //   5236: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5239: ifeq +78 -> 5317
    //   5242: aload 5
    //   5244: ldc_w 695
    //   5247: iconst_1
    //   5248: anewarray 4	java/lang/Object
    //   5251: dup
    //   5252: iconst_0
    //   5253: aload_0
    //   5254: invokevirtual 701	com/tencent/mm/plugin/i/a/i:dJz	()Lcom/tencent/mm/protocal/protobuf/col;
    //   5257: getfield 704	com/tencent/mm/protocal/protobuf/col:nickname	Ljava/lang/String;
    //   5260: aastore
    //   5261: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   5264: astore_0
    //   5265: new 86	java/lang/StringBuilder
    //   5268: dup
    //   5269: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   5272: aload_3
    //   5273: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5276: aload_0
    //   5277: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5280: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5283: astore_0
    //   5284: aload 19
    //   5286: invokevirtual 84	java/lang/String:length	()I
    //   5289: ifle +39 -> 5328
    //   5292: ldc_w 445
    //   5295: aload_0
    //   5296: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5299: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   5302: astore_3
    //   5303: aload 6
    //   5305: aload_3
    //   5306: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5309: aconst_null
    //   5310: astore_3
    //   5311: iconst_0
    //   5312: istore 13
    //   5314: goto -4387 -> 927
    //   5317: aload_0
    //   5318: invokevirtual 701	com/tencent/mm/plugin/i/a/i:dJz	()Lcom/tencent/mm/protocal/protobuf/col;
    //   5321: getfield 705	com/tencent/mm/protocal/protobuf/col:desc	Ljava/lang/String;
    //   5324: astore_0
    //   5325: goto -60 -> 5265
    //   5328: aload_0
    //   5329: astore_3
    //   5330: goto -27 -> 5303
    //   5333: ldc 26
    //   5335: astore 18
    //   5337: aload 21
    //   5339: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   5342: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   5345: astore_3
    //   5346: aload_3
    //   5347: ifnonnull +21 -> 5368
    //   5350: ldc_w 644
    //   5353: ldc_w 646
    //   5356: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5359: ldc_w 379
    //   5362: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5365: ldc 26
    //   5367: areturn
    //   5368: aload_2
    //   5369: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   5372: ifne +15 -> 5387
    //   5375: iload 14
    //   5377: ifne +10 -> 5387
    //   5380: aload 7
    //   5382: aload 19
    //   5384: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5387: aload 5
    //   5389: ldc_w 680
    //   5392: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   5395: astore_0
    //   5396: aload_3
    //   5397: ldc_w 707
    //   5400: invokevirtual 622	com/tencent/mm/ag/k$b:as	(Ljava/lang/Class;)Lcom/tencent/mm/ag/f;
    //   5403: checkcast 707	com/tencent/mm/plugin/i/a/b
    //   5406: astore_3
    //   5407: aload_3
    //   5408: ifnull +5872 -> 11280
    //   5411: aload_3
    //   5412: invokevirtual 711	com/tencent/mm/plugin/i/a/b:dJu	()Lcom/tencent/mm/protocal/protobuf/axf;
    //   5415: getfield 716	com/tencent/mm/protocal/protobuf/axf:nickName	Ljava/lang/String;
    //   5418: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5421: ifne +5859 -> 11280
    //   5424: new 86	java/lang/StringBuilder
    //   5427: dup
    //   5428: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   5431: aload_0
    //   5432: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5435: aload 5
    //   5437: ldc_w 717
    //   5440: iconst_1
    //   5441: anewarray 4	java/lang/Object
    //   5444: dup
    //   5445: iconst_0
    //   5446: aload_3
    //   5447: invokevirtual 711	com/tencent/mm/plugin/i/a/b:dJu	()Lcom/tencent/mm/protocal/protobuf/axf;
    //   5450: getfield 716	com/tencent/mm/protocal/protobuf/axf:nickName	Ljava/lang/String;
    //   5453: aastore
    //   5454: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   5457: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5460: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5463: astore_0
    //   5464: aload 19
    //   5466: invokevirtual 84	java/lang/String:length	()I
    //   5469: ifle +28 -> 5497
    //   5472: ldc_w 445
    //   5475: aload_0
    //   5476: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5479: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   5482: astore_3
    //   5483: aload 6
    //   5485: aload_3
    //   5486: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5489: aconst_null
    //   5490: astore_3
    //   5491: iconst_0
    //   5492: istore 13
    //   5494: goto -4567 -> 927
    //   5497: aload_0
    //   5498: astore_3
    //   5499: goto -16 -> 5483
    //   5502: ldc 26
    //   5504: astore 18
    //   5506: aload 21
    //   5508: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   5511: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   5514: astore_3
    //   5515: aload_3
    //   5516: ifnonnull +21 -> 5537
    //   5519: ldc_w 644
    //   5522: ldc_w 646
    //   5525: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5528: ldc_w 379
    //   5531: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5534: ldc 26
    //   5536: areturn
    //   5537: aload_2
    //   5538: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   5541: ifne +15 -> 5556
    //   5544: iload 14
    //   5546: ifne +10 -> 5556
    //   5549: aload 7
    //   5551: aload 19
    //   5553: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5556: aload 5
    //   5558: ldc_w 680
    //   5561: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   5564: astore_0
    //   5565: aload_3
    //   5566: ldc_w 719
    //   5569: invokevirtual 622	com/tencent/mm/ag/k$b:as	(Ljava/lang/Class;)Lcom/tencent/mm/ag/f;
    //   5572: checkcast 719	com/tencent/mm/plugin/i/a/h
    //   5575: astore_3
    //   5576: aload_3
    //   5577: ifnull +5700 -> 11277
    //   5580: aload_3
    //   5581: invokevirtual 723	com/tencent/mm/plugin/i/a/h:dJv	()Lcom/tencent/mm/protocal/protobuf/bcl;
    //   5584: getfield 728	com/tencent/mm/protocal/protobuf/bcl:dST	Ljava/lang/String;
    //   5587: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5590: ifne +5687 -> 11277
    //   5593: aload_3
    //   5594: invokevirtual 723	com/tencent/mm/plugin/i/a/h:dJv	()Lcom/tencent/mm/protocal/protobuf/bcl;
    //   5597: getfield 731	com/tencent/mm/protocal/protobuf/bcl:tvC	I
    //   5600: iconst_1
    //   5601: if_icmpne +77 -> 5678
    //   5604: new 86	java/lang/StringBuilder
    //   5607: dup
    //   5608: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   5611: aload_0
    //   5612: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5615: invokestatic 115	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   5618: ldc_w 732
    //   5621: iconst_1
    //   5622: anewarray 4	java/lang/Object
    //   5625: dup
    //   5626: iconst_0
    //   5627: aload_3
    //   5628: invokevirtual 723	com/tencent/mm/plugin/i/a/h:dJv	()Lcom/tencent/mm/protocal/protobuf/bcl;
    //   5631: getfield 728	com/tencent/mm/protocal/protobuf/bcl:dST	Ljava/lang/String;
    //   5634: aastore
    //   5635: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   5638: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5641: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5644: astore_0
    //   5645: aload 19
    //   5647: invokevirtual 84	java/lang/String:length	()I
    //   5650: ifle +56 -> 5706
    //   5653: ldc_w 445
    //   5656: aload_0
    //   5657: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5660: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   5663: astore_3
    //   5664: aload 6
    //   5666: aload_3
    //   5667: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5670: aconst_null
    //   5671: astore_3
    //   5672: iconst_0
    //   5673: istore 13
    //   5675: goto -4748 -> 927
    //   5678: new 86	java/lang/StringBuilder
    //   5681: dup
    //   5682: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   5685: aload_0
    //   5686: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5689: aload_3
    //   5690: invokevirtual 723	com/tencent/mm/plugin/i/a/h:dJv	()Lcom/tencent/mm/protocal/protobuf/bcl;
    //   5693: getfield 728	com/tencent/mm/protocal/protobuf/bcl:dST	Ljava/lang/String;
    //   5696: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5699: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5702: astore_0
    //   5703: goto -58 -> 5645
    //   5706: aload_0
    //   5707: astore_3
    //   5708: goto -44 -> 5664
    //   5711: ldc 26
    //   5713: astore 18
    //   5715: aload 21
    //   5717: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   5720: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   5723: astore_3
    //   5724: aload_3
    //   5725: ifnonnull +21 -> 5746
    //   5728: ldc_w 644
    //   5731: ldc_w 646
    //   5734: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5737: ldc_w 379
    //   5740: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5743: ldc 26
    //   5745: areturn
    //   5746: aload_2
    //   5747: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   5750: ifne +15 -> 5765
    //   5753: iload 14
    //   5755: ifne +10 -> 5765
    //   5758: aload 7
    //   5760: aload 19
    //   5762: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5765: aload 5
    //   5767: ldc_w 680
    //   5770: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   5773: astore_0
    //   5774: aload_3
    //   5775: ldc_w 734
    //   5778: invokevirtual 622	com/tencent/mm/ag/k$b:as	(Ljava/lang/Class;)Lcom/tencent/mm/ag/f;
    //   5781: checkcast 734	com/tencent/mm/plugin/i/a/d
    //   5784: astore_3
    //   5785: aload_3
    //   5786: ifnull +5488 -> 11274
    //   5789: aload_3
    //   5790: invokevirtual 738	com/tencent/mm/plugin/i/a/d:dJw	()Lcom/tencent/mm/protocal/protobuf/bcf;
    //   5793: getfield 741	com/tencent/mm/protocal/protobuf/bcf:title	Ljava/lang/String;
    //   5796: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5799: ifne +5475 -> 11274
    //   5802: new 86	java/lang/StringBuilder
    //   5805: dup
    //   5806: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   5809: aload_0
    //   5810: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5813: aload_3
    //   5814: invokevirtual 738	com/tencent/mm/plugin/i/a/d:dJw	()Lcom/tencent/mm/protocal/protobuf/bcf;
    //   5817: getfield 741	com/tencent/mm/protocal/protobuf/bcf:title	Ljava/lang/String;
    //   5820: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5823: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5826: astore_0
    //   5827: aload 19
    //   5829: invokevirtual 84	java/lang/String:length	()I
    //   5832: ifle +28 -> 5860
    //   5835: ldc_w 445
    //   5838: aload_0
    //   5839: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5842: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   5845: astore_3
    //   5846: aload 6
    //   5848: aload_3
    //   5849: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5852: aconst_null
    //   5853: astore_3
    //   5854: iconst_0
    //   5855: istore 13
    //   5857: goto -4930 -> 927
    //   5860: aload_0
    //   5861: astore_3
    //   5862: goto -16 -> 5846
    //   5865: ldc 26
    //   5867: astore 18
    //   5869: aload 21
    //   5871: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   5874: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   5877: astore_0
    //   5878: aload_0
    //   5879: ifnonnull +21 -> 5900
    //   5882: ldc_w 644
    //   5885: ldc_w 646
    //   5888: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5891: ldc_w 379
    //   5894: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5897: ldc 26
    //   5899: areturn
    //   5900: aload_0
    //   5901: ldc_w 743
    //   5904: invokevirtual 622	com/tencent/mm/ag/k$b:as	(Ljava/lang/Class;)Lcom/tencent/mm/ag/f;
    //   5907: checkcast 743	com/tencent/mm/plugin/i/a/e
    //   5910: astore_0
    //   5911: aload_0
    //   5912: ifnull +5356 -> 11268
    //   5915: aload_0
    //   5916: invokevirtual 746	com/tencent/mm/plugin/i/a/e:getNickname	()Ljava/lang/String;
    //   5919: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5922: ifne +5346 -> 11268
    //   5925: iload_1
    //   5926: iconst_1
    //   5927: if_icmpne +56 -> 5983
    //   5930: aload 5
    //   5932: ldc_w 747
    //   5935: iconst_1
    //   5936: anewarray 4	java/lang/Object
    //   5939: dup
    //   5940: iconst_0
    //   5941: aload_0
    //   5942: invokevirtual 746	com/tencent/mm/plugin/i/a/e:getNickname	()Ljava/lang/String;
    //   5945: aastore
    //   5946: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   5949: astore_0
    //   5950: aload 19
    //   5952: invokevirtual 84	java/lang/String:length	()I
    //   5955: ifle +76 -> 6031
    //   5958: ldc_w 445
    //   5961: aload_0
    //   5962: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   5965: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   5968: astore_3
    //   5969: aload 6
    //   5971: aload_3
    //   5972: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   5975: aconst_null
    //   5976: astore_3
    //   5977: iconst_0
    //   5978: istore 13
    //   5980: goto -5053 -> 927
    //   5983: aload 5
    //   5985: ldc_w 748
    //   5988: iconst_1
    //   5989: anewarray 4	java/lang/Object
    //   5992: dup
    //   5993: iconst_0
    //   5994: aload_0
    //   5995: invokevirtual 746	com/tencent/mm/plugin/i/a/e:getNickname	()Ljava/lang/String;
    //   5998: aastore
    //   5999: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   6002: astore_3
    //   6003: aload_3
    //   6004: astore_0
    //   6005: aload_2
    //   6006: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   6009: ifne -59 -> 5950
    //   6012: aload_3
    //   6013: astore_0
    //   6014: iload 14
    //   6016: ifne -66 -> 5950
    //   6019: aload 7
    //   6021: aload 19
    //   6023: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6026: aload_3
    //   6027: astore_0
    //   6028: goto -78 -> 5950
    //   6031: aload_0
    //   6032: astore_3
    //   6033: goto -64 -> 5969
    //   6036: ldc 26
    //   6038: astore 18
    //   6040: new 86	java/lang/StringBuilder
    //   6043: dup
    //   6044: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   6047: aload 5
    //   6049: ldc_w 749
    //   6052: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   6055: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6058: aload 5
    //   6060: ldc_w 750
    //   6063: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   6066: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6069: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6072: astore_0
    //   6073: aload 6
    //   6075: aload_0
    //   6076: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6079: aconst_null
    //   6080: astore_3
    //   6081: iconst_0
    //   6082: istore 13
    //   6084: goto -5157 -> 927
    //   6087: ldc 26
    //   6089: astore 18
    //   6091: aload 21
    //   6093: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   6096: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   6099: astore_0
    //   6100: aload_0
    //   6101: ifnonnull +21 -> 6122
    //   6104: ldc_w 644
    //   6107: ldc_w 646
    //   6110: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6113: ldc_w 379
    //   6116: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6119: ldc 26
    //   6121: areturn
    //   6122: aload_0
    //   6123: ldc_w 752
    //   6126: invokevirtual 622	com/tencent/mm/ag/k$b:as	(Ljava/lang/Class;)Lcom/tencent/mm/ag/f;
    //   6129: checkcast 752	com/tencent/mm/plugin/game/luggage/f/a
    //   6132: astore_0
    //   6133: aload_0
    //   6134: ifnull +5128 -> 11262
    //   6137: aload_0
    //   6138: getfield 753	com/tencent/mm/plugin/game/luggage/f/a:nickName	Ljava/lang/String;
    //   6141: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   6144: ifne +5118 -> 11262
    //   6147: iload_1
    //   6148: iconst_1
    //   6149: if_icmpne +56 -> 6205
    //   6152: aload 5
    //   6154: ldc_w 754
    //   6157: iconst_1
    //   6158: anewarray 4	java/lang/Object
    //   6161: dup
    //   6162: iconst_0
    //   6163: aload_0
    //   6164: getfield 753	com/tencent/mm/plugin/game/luggage/f/a:nickName	Ljava/lang/String;
    //   6167: aastore
    //   6168: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   6171: astore_0
    //   6172: aload 19
    //   6174: invokevirtual 84	java/lang/String:length	()I
    //   6177: ifle +76 -> 6253
    //   6180: ldc_w 445
    //   6183: aload_0
    //   6184: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   6187: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   6190: astore_3
    //   6191: aload 6
    //   6193: aload_3
    //   6194: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6197: aconst_null
    //   6198: astore_3
    //   6199: iconst_0
    //   6200: istore 13
    //   6202: goto -5275 -> 927
    //   6205: aload 5
    //   6207: ldc_w 755
    //   6210: iconst_1
    //   6211: anewarray 4	java/lang/Object
    //   6214: dup
    //   6215: iconst_0
    //   6216: aload_0
    //   6217: getfield 753	com/tencent/mm/plugin/game/luggage/f/a:nickName	Ljava/lang/String;
    //   6220: aastore
    //   6221: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   6224: astore_3
    //   6225: aload_3
    //   6226: astore_0
    //   6227: aload_2
    //   6228: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   6231: ifne -59 -> 6172
    //   6234: aload_3
    //   6235: astore_0
    //   6236: iload 14
    //   6238: ifne -66 -> 6172
    //   6241: aload 7
    //   6243: aload 19
    //   6245: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6248: aload_3
    //   6249: astore_0
    //   6250: goto -78 -> 6172
    //   6253: aload_0
    //   6254: astore_3
    //   6255: goto -64 -> 6191
    //   6258: ldc 26
    //   6260: astore 18
    //   6262: ldc_w 757
    //   6265: invokestatic 316	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   6268: checkcast 757	com/tencent/mm/plugin/patmsg/a/b
    //   6271: aload_3
    //   6272: invokeinterface 761 2 0
    //   6277: astore 21
    //   6279: aload_3
    //   6280: astore_0
    //   6281: aload 21
    //   6283: getfield 767	com/tencent/mm/protocal/protobuf/czg:yVw	Ljava/util/LinkedList;
    //   6286: invokevirtual 772	java/util/LinkedList:size	()I
    //   6289: ifle -5371 -> 918
    //   6292: aload 6
    //   6294: ldc_w 774
    //   6297: invokestatic 778	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   6300: checkcast 774	com/tencent/mm/plugin/patmsg/PluginPatMsg
    //   6303: aload 21
    //   6305: getfield 767	com/tencent/mm/protocal/protobuf/czg:yVw	Ljava/util/LinkedList;
    //   6308: invokevirtual 782	java/util/LinkedList:getLast	()Ljava/lang/Object;
    //   6311: checkcast 784	com/tencent/mm/protocal/protobuf/czh
    //   6314: getfield 787	com/tencent/mm/protocal/protobuf/czh:iBd	Ljava/lang/String;
    //   6317: aload_2
    //   6318: invokevirtual 791	com/tencent/mm/plugin/patmsg/PluginPatMsg:parseDisplayTemplate	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mm/plugin/patmsg/a/f;
    //   6321: getfield 796	com/tencent/mm/plugin/patmsg/a/f:result	Ljava/lang/String;
    //   6324: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6327: aconst_null
    //   6328: astore 21
    //   6330: iconst_0
    //   6331: istore 13
    //   6333: aload_3
    //   6334: astore_0
    //   6335: aload 21
    //   6337: astore_3
    //   6338: goto -5411 -> 927
    //   6341: aload 21
    //   6343: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   6346: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   6349: astore_0
    //   6350: aload_0
    //   6351: ifnonnull +21 -> 6372
    //   6354: ldc_w 644
    //   6357: ldc_w 646
    //   6360: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6363: ldc_w 379
    //   6366: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6369: ldc 26
    //   6371: areturn
    //   6372: new 86	java/lang/StringBuilder
    //   6375: dup
    //   6376: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   6379: aload 5
    //   6381: ldc_w 797
    //   6384: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   6387: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6390: aload_0
    //   6391: invokevirtual 798	com/tencent/mm/ag/k$b:getTitle	()Ljava/lang/String;
    //   6394: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6397: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6400: astore_0
    //   6401: aload 6
    //   6403: aload_0
    //   6404: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6407: aconst_null
    //   6408: astore_3
    //   6409: iconst_0
    //   6410: istore 13
    //   6412: aload 22
    //   6414: astore 18
    //   6416: goto -5489 -> 927
    //   6419: ldc 26
    //   6421: astore 18
    //   6423: aload 21
    //   6425: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   6428: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   6431: astore_3
    //   6432: aload_3
    //   6433: ifnonnull +21 -> 6454
    //   6436: ldc_w 644
    //   6439: ldc_w 646
    //   6442: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6445: ldc_w 379
    //   6448: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6451: ldc 26
    //   6453: areturn
    //   6454: aload_2
    //   6455: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   6458: ifne +15 -> 6473
    //   6461: iload 14
    //   6463: ifne +10 -> 6473
    //   6466: aload 7
    //   6468: aload 19
    //   6470: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6473: aload 5
    //   6475: ldc_w 799
    //   6478: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   6481: astore_0
    //   6482: aload_3
    //   6483: ldc_w 707
    //   6486: invokevirtual 622	com/tencent/mm/ag/k$b:as	(Ljava/lang/Class;)Lcom/tencent/mm/ag/f;
    //   6489: checkcast 707	com/tencent/mm/plugin/i/a/b
    //   6492: astore_3
    //   6493: aload_3
    //   6494: ifnull +4765 -> 11259
    //   6497: aload_3
    //   6498: invokevirtual 711	com/tencent/mm/plugin/i/a/b:dJu	()Lcom/tencent/mm/protocal/protobuf/axf;
    //   6501: getfield 716	com/tencent/mm/protocal/protobuf/axf:nickName	Ljava/lang/String;
    //   6504: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   6507: ifne +4752 -> 11259
    //   6510: new 86	java/lang/StringBuilder
    //   6513: dup
    //   6514: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   6517: aload_0
    //   6518: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6521: aload 5
    //   6523: ldc_w 800
    //   6526: iconst_1
    //   6527: anewarray 4	java/lang/Object
    //   6530: dup
    //   6531: iconst_0
    //   6532: aload_3
    //   6533: invokevirtual 711	com/tencent/mm/plugin/i/a/b:dJu	()Lcom/tencent/mm/protocal/protobuf/axf;
    //   6536: getfield 716	com/tencent/mm/protocal/protobuf/axf:nickName	Ljava/lang/String;
    //   6539: aastore
    //   6540: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   6543: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6546: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6549: astore_0
    //   6550: aload 19
    //   6552: invokevirtual 84	java/lang/String:length	()I
    //   6555: ifle +28 -> 6583
    //   6558: ldc_w 445
    //   6561: aload_0
    //   6562: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   6565: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   6568: astore_3
    //   6569: aload 6
    //   6571: aload_3
    //   6572: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6575: aconst_null
    //   6576: astore_3
    //   6577: iconst_0
    //   6578: istore 13
    //   6580: goto -5653 -> 927
    //   6583: aload_0
    //   6584: astore_3
    //   6585: goto -16 -> 6569
    //   6588: ldc 26
    //   6590: astore 18
    //   6592: aload 21
    //   6594: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   6597: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   6600: astore_0
    //   6601: aload_0
    //   6602: ifnonnull +21 -> 6623
    //   6605: ldc_w 644
    //   6608: ldc_w 646
    //   6611: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6614: ldc_w 379
    //   6617: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6620: ldc 26
    //   6622: areturn
    //   6623: aload_2
    //   6624: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   6627: ifne +15 -> 6642
    //   6630: iload 14
    //   6632: ifne +10 -> 6642
    //   6635: aload 7
    //   6637: aload 19
    //   6639: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6642: aload_0
    //   6643: ldc_w 802
    //   6646: invokevirtual 622	com/tencent/mm/ag/k$b:as	(Ljava/lang/Class;)Lcom/tencent/mm/ag/f;
    //   6649: checkcast 802	com/tencent/mm/plugin/i/a/g
    //   6652: astore_0
    //   6653: aload_0
    //   6654: ifnull +91 -> 6745
    //   6657: aload_0
    //   6658: invokevirtual 806	com/tencent/mm/plugin/i/a/g:dJy	()Lcom/tencent/mm/protocal/protobuf/bck;
    //   6661: getfield 811	com/tencent/mm/protocal/protobuf/bck:kHV	Ljava/lang/String;
    //   6664: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   6667: ifne +78 -> 6745
    //   6670: new 86	java/lang/StringBuilder
    //   6673: dup
    //   6674: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   6677: ldc 26
    //   6679: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6682: invokestatic 115	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6685: ldc_w 812
    //   6688: iconst_1
    //   6689: anewarray 4	java/lang/Object
    //   6692: dup
    //   6693: iconst_0
    //   6694: aload_0
    //   6695: invokevirtual 806	com/tencent/mm/plugin/i/a/g:dJy	()Lcom/tencent/mm/protocal/protobuf/bck;
    //   6698: getfield 811	com/tencent/mm/protocal/protobuf/bck:kHV	Ljava/lang/String;
    //   6701: aastore
    //   6702: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   6705: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6708: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6711: astore_0
    //   6712: aload 19
    //   6714: invokevirtual 84	java/lang/String:length	()I
    //   6717: ifle +58 -> 6775
    //   6720: ldc_w 445
    //   6723: aload_0
    //   6724: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   6727: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   6730: astore_3
    //   6731: aload 6
    //   6733: aload_3
    //   6734: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   6737: aconst_null
    //   6738: astore_3
    //   6739: iconst_0
    //   6740: istore 13
    //   6742: goto -5815 -> 927
    //   6745: new 86	java/lang/StringBuilder
    //   6748: dup
    //   6749: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   6752: ldc 26
    //   6754: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6757: aload 5
    //   6759: ldc_w 813
    //   6762: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   6765: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6768: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6771: astore_0
    //   6772: goto -60 -> 6712
    //   6775: aload_0
    //   6776: astore_3
    //   6777: goto -46 -> 6731
    //   6780: aload 21
    //   6782: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   6785: astore_0
    //   6786: aload_0
    //   6787: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   6790: astore 21
    //   6792: aload 21
    //   6794: ifnonnull +21 -> 6815
    //   6797: ldc_w 644
    //   6800: ldc_w 646
    //   6803: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   6806: ldc_w 379
    //   6809: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6812: ldc 26
    //   6814: areturn
    //   6815: aload 21
    //   6817: getfield 816	com/tencent/mm/ag/k$b:type	I
    //   6820: lookupswitch	default:+220->7040, 1:+241->7061, 2:+364->7184, 3:+461->7281, 4:+589->7409, 5:+888->7708, 6:+690->7510, 7:+791->7611, 8:+1418->8238, 15:+1498->8318, 16:+2051->8871, 17:+1658->8478, 19:+1781->8601, 24:+1878->8698, 25:+1578->8398, 26:+1498->8318, 27:+1498->8318, 33:+1017->7837, 34:+2192->9012, 36:+1017->7837, 40:+2362->9182, 44:+1198->8018, 46:+996->7816, 53:+241->7061, 57:+241->7061, 68:+2422->9242, 76:+461->7281
    //   7041: iconst_2
    //   7042: ldc_w 665
    //   7045: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   7048: astore 18
    //   7050: aconst_null
    //   7051: astore_3
    //   7052: iconst_0
    //   7053: istore 13
    //   7055: ldc 26
    //   7057: astore_0
    //   7058: goto -6131 -> 927
    //   7061: ldc 26
    //   7063: astore 18
    //   7065: aload 19
    //   7067: invokevirtual 84	java/lang/String:length	()I
    //   7070: ifle +96 -> 7166
    //   7073: new 86	java/lang/StringBuilder
    //   7076: dup
    //   7077: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   7080: aload 19
    //   7082: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7085: ldc_w 443
    //   7088: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7091: aload 21
    //   7093: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   7096: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7099: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7102: astore_0
    //   7103: aload_2
    //   7104: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   7107: ifne +15 -> 7122
    //   7110: iload 14
    //   7112: ifne +10 -> 7122
    //   7115: aload 7
    //   7117: aload 19
    //   7119: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7122: aload 19
    //   7124: invokevirtual 84	java/lang/String:length	()I
    //   7127: ifle +48 -> 7175
    //   7130: new 86	java/lang/StringBuilder
    //   7133: dup
    //   7134: ldc_w 445
    //   7137: invokespecial 603	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   7140: aload 21
    //   7142: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   7145: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7148: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7151: astore_3
    //   7152: aload 6
    //   7154: aload_3
    //   7155: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7158: aconst_null
    //   7159: astore_3
    //   7160: iconst_0
    //   7161: istore 13
    //   7163: goto -6236 -> 927
    //   7166: aload 21
    //   7168: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   7171: astore_0
    //   7172: goto -69 -> 7103
    //   7175: aload 21
    //   7177: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   7180: astore_3
    //   7181: goto -29 -> 7152
    //   7184: aload 5
    //   7186: ldc_w 441
    //   7189: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   7192: astore 18
    //   7194: aload 19
    //   7196: invokevirtual 84	java/lang/String:length	()I
    //   7199: ifle +70 -> 7269
    //   7202: new 86	java/lang/StringBuilder
    //   7205: dup
    //   7206: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   7209: aload 19
    //   7211: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7214: ldc_w 443
    //   7217: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7220: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7223: astore_0
    //   7224: aload_2
    //   7225: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   7228: ifne +15 -> 7243
    //   7231: iload 14
    //   7233: ifne +10 -> 7243
    //   7236: aload 7
    //   7238: aload 19
    //   7240: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7243: aload 19
    //   7245: invokevirtual 84	java/lang/String:length	()I
    //   7248: ifle +27 -> 7275
    //   7251: ldc_w 445
    //   7254: astore_3
    //   7255: aload 6
    //   7257: aload_3
    //   7258: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7261: aconst_null
    //   7262: astore_3
    //   7263: iconst_0
    //   7264: istore 13
    //   7266: goto -6339 -> 927
    //   7269: ldc 26
    //   7271: astore_0
    //   7272: goto -48 -> 7224
    //   7275: ldc 26
    //   7277: astore_3
    //   7278: goto -23 -> 7255
    //   7281: new 86	java/lang/StringBuilder
    //   7284: dup
    //   7285: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   7288: aload 5
    //   7290: ldc_w 817
    //   7293: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   7296: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7299: ldc_w 411
    //   7302: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7305: aload 21
    //   7307: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   7310: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7313: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7316: astore 18
    //   7318: aload 19
    //   7320: invokevirtual 84	java/lang/String:length	()I
    //   7323: ifle +74 -> 7397
    //   7326: new 86	java/lang/StringBuilder
    //   7329: dup
    //   7330: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   7333: aload 19
    //   7335: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7338: ldc_w 443
    //   7341: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7344: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7347: astore_0
    //   7348: aload_2
    //   7349: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   7352: ifne +15 -> 7367
    //   7355: iload 14
    //   7357: ifne +10 -> 7367
    //   7360: aload 7
    //   7362: aload 19
    //   7364: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7367: aload 19
    //   7369: invokevirtual 84	java/lang/String:length	()I
    //   7372: ifle +31 -> 7403
    //   7375: ldc_w 445
    //   7378: astore_3
    //   7379: aload 6
    //   7381: aload_3
    //   7382: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7385: aload 21
    //   7387: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   7390: astore_3
    //   7391: iconst_1
    //   7392: istore 13
    //   7394: goto -6467 -> 927
    //   7397: ldc 26
    //   7399: astore_0
    //   7400: goto -52 -> 7348
    //   7403: ldc 26
    //   7405: astore_3
    //   7406: goto -27 -> 7379
    //   7409: aload 5
    //   7411: ldc_w 467
    //   7414: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   7417: astore 18
    //   7419: aload 19
    //   7421: invokevirtual 84	java/lang/String:length	()I
    //   7424: ifle +74 -> 7498
    //   7427: new 86	java/lang/StringBuilder
    //   7430: dup
    //   7431: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   7434: aload 19
    //   7436: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7439: ldc_w 443
    //   7442: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7445: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7448: astore_0
    //   7449: aload_2
    //   7450: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   7453: ifne +15 -> 7468
    //   7456: iload 14
    //   7458: ifne +10 -> 7468
    //   7461: aload 7
    //   7463: aload 19
    //   7465: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7468: aload 19
    //   7470: invokevirtual 84	java/lang/String:length	()I
    //   7473: ifle +31 -> 7504
    //   7476: ldc_w 445
    //   7479: astore_3
    //   7480: aload 6
    //   7482: aload_3
    //   7483: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7486: aload 21
    //   7488: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   7491: astore_3
    //   7492: iconst_1
    //   7493: istore 13
    //   7495: goto -6568 -> 927
    //   7498: ldc 26
    //   7500: astore_0
    //   7501: goto -52 -> 7449
    //   7504: ldc 26
    //   7506: astore_3
    //   7507: goto -27 -> 7480
    //   7510: aload 5
    //   7512: ldc_w 818
    //   7515: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   7518: astore 18
    //   7520: aload 19
    //   7522: invokevirtual 84	java/lang/String:length	()I
    //   7525: ifle +74 -> 7599
    //   7528: new 86	java/lang/StringBuilder
    //   7531: dup
    //   7532: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   7535: aload 19
    //   7537: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7540: ldc_w 443
    //   7543: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7546: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7549: astore_0
    //   7550: aload_2
    //   7551: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   7554: ifne +15 -> 7569
    //   7557: iload 14
    //   7559: ifne +10 -> 7569
    //   7562: aload 7
    //   7564: aload 19
    //   7566: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7569: aload 19
    //   7571: invokevirtual 84	java/lang/String:length	()I
    //   7574: ifle +31 -> 7605
    //   7577: ldc_w 445
    //   7580: astore_3
    //   7581: aload 6
    //   7583: aload_3
    //   7584: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7587: aload 21
    //   7589: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   7592: astore_3
    //   7593: iconst_1
    //   7594: istore 13
    //   7596: goto -6669 -> 927
    //   7599: ldc 26
    //   7601: astore_0
    //   7602: goto -52 -> 7550
    //   7605: ldc 26
    //   7607: astore_3
    //   7608: goto -27 -> 7581
    //   7611: aload 5
    //   7613: ldc_w 665
    //   7616: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   7619: astore 18
    //   7621: aload 19
    //   7623: invokevirtual 84	java/lang/String:length	()I
    //   7626: ifle +70 -> 7696
    //   7629: new 86	java/lang/StringBuilder
    //   7632: dup
    //   7633: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   7636: aload 19
    //   7638: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7641: ldc_w 443
    //   7644: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7647: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7650: astore_0
    //   7651: aload_2
    //   7652: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   7655: ifne +15 -> 7670
    //   7658: iload 14
    //   7660: ifne +10 -> 7670
    //   7663: aload 7
    //   7665: aload 19
    //   7667: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7670: aload 19
    //   7672: invokevirtual 84	java/lang/String:length	()I
    //   7675: ifle +27 -> 7702
    //   7678: ldc_w 445
    //   7681: astore_3
    //   7682: aload 6
    //   7684: aload_3
    //   7685: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7688: aconst_null
    //   7689: astore_3
    //   7690: iconst_0
    //   7691: istore 13
    //   7693: goto -6766 -> 927
    //   7696: ldc 26
    //   7698: astore_0
    //   7699: goto -48 -> 7651
    //   7702: ldc 26
    //   7704: astore_3
    //   7705: goto -23 -> 7682
    //   7708: aload 5
    //   7710: ldc_w 819
    //   7713: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   7716: astore 18
    //   7718: aload 19
    //   7720: invokevirtual 84	java/lang/String:length	()I
    //   7723: ifle +81 -> 7804
    //   7726: new 86	java/lang/StringBuilder
    //   7729: dup
    //   7730: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   7733: aload 19
    //   7735: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7738: ldc_w 443
    //   7741: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7744: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7747: astore_0
    //   7748: aload_2
    //   7749: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   7752: ifne +22 -> 7774
    //   7755: iload 14
    //   7757: ifne +17 -> 7774
    //   7760: aload_2
    //   7761: invokestatic 417	com/tencent/mm/model/ab:JB	(Ljava/lang/String;)Z
    //   7764: ifne +10 -> 7774
    //   7767: aload 7
    //   7769: aload 19
    //   7771: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7774: aload 19
    //   7776: invokevirtual 84	java/lang/String:length	()I
    //   7779: ifle +31 -> 7810
    //   7782: ldc_w 445
    //   7785: astore_3
    //   7786: aload 6
    //   7788: aload_3
    //   7789: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7792: aload 21
    //   7794: invokevirtual 798	com/tencent/mm/ag/k$b:getTitle	()Ljava/lang/String;
    //   7797: astore_3
    //   7798: iconst_1
    //   7799: istore 13
    //   7801: goto -6874 -> 927
    //   7804: ldc 26
    //   7806: astore_0
    //   7807: goto -59 -> 7748
    //   7810: ldc 26
    //   7812: astore_3
    //   7813: goto -27 -> 7786
    //   7816: aload 5
    //   7818: ldc_w 665
    //   7821: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   7824: astore 18
    //   7826: aconst_null
    //   7827: astore_3
    //   7828: iconst_0
    //   7829: istore 13
    //   7831: ldc 26
    //   7833: astore_0
    //   7834: goto -6907 -> 927
    //   7837: ldc 26
    //   7839: astore 18
    //   7841: aload 5
    //   7843: ldc_w 820
    //   7846: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   7849: astore_3
    //   7850: aload 19
    //   7852: invokevirtual 84	java/lang/String:length	()I
    //   7855: ifle +111 -> 7966
    //   7858: new 86	java/lang/StringBuilder
    //   7861: dup
    //   7862: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   7865: aload 19
    //   7867: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7870: ldc_w 443
    //   7873: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7876: aload_3
    //   7877: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7880: aload 21
    //   7882: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   7885: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7888: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7891: astore_0
    //   7892: aload_2
    //   7893: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   7896: ifne +22 -> 7918
    //   7899: iload 14
    //   7901: ifne +17 -> 7918
    //   7904: aload_2
    //   7905: invokestatic 417	com/tencent/mm/model/ab:JB	(Ljava/lang/String;)Z
    //   7908: ifne +10 -> 7918
    //   7911: aload 7
    //   7913: aload 19
    //   7915: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7918: aload 19
    //   7920: invokevirtual 84	java/lang/String:length	()I
    //   7923: ifle +69 -> 7992
    //   7926: new 86	java/lang/StringBuilder
    //   7929: dup
    //   7930: ldc_w 445
    //   7933: invokespecial 603	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   7936: aload_3
    //   7937: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7940: aload 21
    //   7942: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   7945: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7948: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7951: astore_3
    //   7952: aload 6
    //   7954: aload_3
    //   7955: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   7958: aconst_null
    //   7959: astore_3
    //   7960: iconst_0
    //   7961: istore 13
    //   7963: goto -7036 -> 927
    //   7966: new 86	java/lang/StringBuilder
    //   7969: dup
    //   7970: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   7973: aload_3
    //   7974: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7977: aload 21
    //   7979: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   7982: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7985: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7988: astore_0
    //   7989: goto -97 -> 7892
    //   7992: new 86	java/lang/StringBuilder
    //   7995: dup
    //   7996: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   7999: aload_3
    //   8000: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8003: aload 21
    //   8005: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   8008: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8011: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8014: astore_3
    //   8015: goto -63 -> 7952
    //   8018: aload 21
    //   8020: iconst_0
    //   8021: invokevirtual 824	com/tencent/mm/ag/k$b:fn	(Z)Z
    //   8024: ifeq +193 -> 8217
    //   8027: ldc 26
    //   8029: astore 18
    //   8031: aload 21
    //   8033: aload 5
    //   8035: iconst_1
    //   8036: invokevirtual 828	com/tencent/mm/ag/k$b:w	(Landroid/content/Context;Z)Ljava/lang/String;
    //   8039: astore_3
    //   8040: aload_3
    //   8041: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   8044: ifne +152 -> 8196
    //   8047: aload 19
    //   8049: invokevirtual 84	java/lang/String:length	()I
    //   8052: ifle +92 -> 8144
    //   8055: new 86	java/lang/StringBuilder
    //   8058: dup
    //   8059: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   8062: aload 19
    //   8064: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8067: ldc_w 443
    //   8070: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8073: aload_3
    //   8074: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8077: aload 21
    //   8079: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   8082: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8085: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8088: astore_0
    //   8089: aload 7
    //   8091: aload 19
    //   8093: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8096: aload 19
    //   8098: invokevirtual 84	java/lang/String:length	()I
    //   8101: ifle +69 -> 8170
    //   8104: new 86	java/lang/StringBuilder
    //   8107: dup
    //   8108: ldc_w 445
    //   8111: invokespecial 603	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   8114: aload_3
    //   8115: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8118: aload 21
    //   8120: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   8123: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8126: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8129: astore_3
    //   8130: aload 6
    //   8132: aload_3
    //   8133: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8136: aconst_null
    //   8137: astore_3
    //   8138: iconst_0
    //   8139: istore 13
    //   8141: goto -7214 -> 927
    //   8144: new 86	java/lang/StringBuilder
    //   8147: dup
    //   8148: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   8151: aload_3
    //   8152: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8155: aload 21
    //   8157: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   8160: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8163: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8166: astore_0
    //   8167: goto -78 -> 8089
    //   8170: new 86	java/lang/StringBuilder
    //   8173: dup
    //   8174: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   8177: aload_3
    //   8178: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8181: aload 21
    //   8183: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   8186: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8189: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8192: astore_3
    //   8193: goto -63 -> 8130
    //   8196: aload 5
    //   8198: ldc_w 665
    //   8201: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   8204: astore 18
    //   8206: aconst_null
    //   8207: astore_3
    //   8208: iconst_0
    //   8209: istore 13
    //   8211: ldc 26
    //   8213: astore_0
    //   8214: goto -7287 -> 927
    //   8217: aload 5
    //   8219: ldc_w 665
    //   8222: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   8225: astore 18
    //   8227: aconst_null
    //   8228: astore_3
    //   8229: iconst_0
    //   8230: istore 13
    //   8232: ldc 26
    //   8234: astore_0
    //   8235: goto -7308 -> 927
    //   8238: aload 5
    //   8240: ldc_w 829
    //   8243: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   8246: astore 18
    //   8248: aload 19
    //   8250: invokevirtual 84	java/lang/String:length	()I
    //   8253: ifle +59 -> 8312
    //   8256: new 86	java/lang/StringBuilder
    //   8259: dup
    //   8260: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   8263: aload 19
    //   8265: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8268: ldc_w 443
    //   8271: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8274: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8277: astore_0
    //   8278: aload_2
    //   8279: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   8282: ifne +15 -> 8297
    //   8285: iload 14
    //   8287: ifne +10 -> 8297
    //   8290: aload 7
    //   8292: aload 19
    //   8294: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8297: aload 6
    //   8299: ldc 26
    //   8301: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8304: aconst_null
    //   8305: astore_3
    //   8306: iconst_0
    //   8307: istore 13
    //   8309: goto -7382 -> 927
    //   8312: ldc 26
    //   8314: astore_0
    //   8315: goto -37 -> 8278
    //   8318: aload 5
    //   8320: ldc_w 830
    //   8323: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   8326: astore 18
    //   8328: aload 19
    //   8330: invokevirtual 84	java/lang/String:length	()I
    //   8333: ifle +59 -> 8392
    //   8336: new 86	java/lang/StringBuilder
    //   8339: dup
    //   8340: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   8343: aload 19
    //   8345: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8348: ldc_w 443
    //   8351: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8354: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8357: astore_0
    //   8358: aload_2
    //   8359: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   8362: ifne +15 -> 8377
    //   8365: iload 14
    //   8367: ifne +10 -> 8377
    //   8370: aload 7
    //   8372: aload 19
    //   8374: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8377: aload 6
    //   8379: ldc 26
    //   8381: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8384: aconst_null
    //   8385: astore_3
    //   8386: iconst_0
    //   8387: istore 13
    //   8389: goto -7462 -> 927
    //   8392: ldc 26
    //   8394: astore_0
    //   8395: goto -37 -> 8358
    //   8398: aload 5
    //   8400: ldc_w 831
    //   8403: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   8406: astore 18
    //   8408: aload 19
    //   8410: invokevirtual 84	java/lang/String:length	()I
    //   8413: ifle +59 -> 8472
    //   8416: new 86	java/lang/StringBuilder
    //   8419: dup
    //   8420: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   8423: aload 19
    //   8425: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8428: ldc_w 443
    //   8431: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8434: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8437: astore_0
    //   8438: aload_2
    //   8439: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   8442: ifne +15 -> 8457
    //   8445: iload 14
    //   8447: ifne +10 -> 8457
    //   8450: aload 7
    //   8452: aload 19
    //   8454: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8457: aload 6
    //   8459: ldc 26
    //   8461: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8464: aconst_null
    //   8465: astore_3
    //   8466: iconst_0
    //   8467: istore 13
    //   8469: goto -7542 -> 927
    //   8472: ldc 26
    //   8474: astore_0
    //   8475: goto -37 -> 8438
    //   8478: ldc 26
    //   8480: astore 18
    //   8482: aload 19
    //   8484: invokevirtual 84	java/lang/String:length	()I
    //   8487: ifle +96 -> 8583
    //   8490: new 86	java/lang/StringBuilder
    //   8493: dup
    //   8494: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   8497: aload 19
    //   8499: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8502: ldc_w 443
    //   8505: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8508: aload 21
    //   8510: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   8513: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8516: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8519: astore_0
    //   8520: aload_2
    //   8521: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   8524: ifne +15 -> 8539
    //   8527: iload 14
    //   8529: ifne +10 -> 8539
    //   8532: aload 7
    //   8534: aload 19
    //   8536: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8539: aload 19
    //   8541: invokevirtual 84	java/lang/String:length	()I
    //   8544: ifle +48 -> 8592
    //   8547: new 86	java/lang/StringBuilder
    //   8550: dup
    //   8551: ldc_w 445
    //   8554: invokespecial 603	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   8557: aload 21
    //   8559: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   8562: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8565: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8568: astore_3
    //   8569: aload 6
    //   8571: aload_3
    //   8572: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8575: aconst_null
    //   8576: astore_3
    //   8577: iconst_0
    //   8578: istore 13
    //   8580: goto -7653 -> 927
    //   8583: aload 21
    //   8585: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   8588: astore_0
    //   8589: goto -69 -> 8520
    //   8592: aload 21
    //   8594: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   8597: astore_3
    //   8598: goto -29 -> 8569
    //   8601: aload 5
    //   8603: ldc_w 832
    //   8606: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   8609: astore 18
    //   8611: aload 19
    //   8613: invokevirtual 84	java/lang/String:length	()I
    //   8616: ifle +70 -> 8686
    //   8619: new 86	java/lang/StringBuilder
    //   8622: dup
    //   8623: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   8626: aload 19
    //   8628: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8631: ldc_w 443
    //   8634: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8637: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8640: astore_0
    //   8641: aload_2
    //   8642: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   8645: ifne +15 -> 8660
    //   8648: iload 14
    //   8650: ifne +10 -> 8660
    //   8653: aload 7
    //   8655: aload 19
    //   8657: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8660: aload 19
    //   8662: invokevirtual 84	java/lang/String:length	()I
    //   8665: ifle +27 -> 8692
    //   8668: ldc_w 445
    //   8671: astore_3
    //   8672: aload 6
    //   8674: aload_3
    //   8675: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8678: aconst_null
    //   8679: astore_3
    //   8680: iconst_0
    //   8681: istore 13
    //   8683: goto -7756 -> 927
    //   8686: ldc 26
    //   8688: astore_0
    //   8689: goto -48 -> 8641
    //   8692: ldc 26
    //   8694: astore_3
    //   8695: goto -23 -> 8672
    //   8698: ldc 26
    //   8700: astore_0
    //   8701: aload 21
    //   8703: getfield 835	com/tencent/mm/ag/k$b:description	Ljava/lang/String;
    //   8706: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   8709: ifne +35 -> 8744
    //   8712: aload 21
    //   8714: getfield 835	com/tencent/mm/ag/k$b:description	Ljava/lang/String;
    //   8717: ldc_w 837
    //   8720: invokevirtual 162	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   8723: istore 13
    //   8725: aload 21
    //   8727: getfield 835	com/tencent/mm/ag/k$b:description	Ljava/lang/String;
    //   8730: astore_0
    //   8731: iload 13
    //   8733: ifle +113 -> 8846
    //   8736: aload_0
    //   8737: iconst_0
    //   8738: iload 13
    //   8740: invokevirtual 91	java/lang/String:substring	(II)Ljava/lang/String;
    //   8743: astore_0
    //   8744: new 86	java/lang/StringBuilder
    //   8747: dup
    //   8748: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   8751: aload 5
    //   8753: ldc_w 838
    //   8756: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   8759: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8762: aload_0
    //   8763: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8766: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8769: astore 18
    //   8771: aload 19
    //   8773: invokevirtual 84	java/lang/String:length	()I
    //   8776: ifle +83 -> 8859
    //   8779: new 86	java/lang/StringBuilder
    //   8782: dup
    //   8783: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   8786: aload 19
    //   8788: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8791: ldc_w 443
    //   8794: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8797: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8800: astore_0
    //   8801: aload_2
    //   8802: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   8805: ifne +15 -> 8820
    //   8808: iload 14
    //   8810: ifne +10 -> 8820
    //   8813: aload 7
    //   8815: aload 19
    //   8817: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8820: aload 19
    //   8822: invokevirtual 84	java/lang/String:length	()I
    //   8825: ifle +40 -> 8865
    //   8828: ldc_w 445
    //   8831: astore_3
    //   8832: aload 6
    //   8834: aload_3
    //   8835: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8838: aconst_null
    //   8839: astore_3
    //   8840: iconst_0
    //   8841: istore 13
    //   8843: goto -7916 -> 927
    //   8846: aload 21
    //   8848: getfield 835	com/tencent/mm/ag/k$b:description	Ljava/lang/String;
    //   8851: invokevirtual 84	java/lang/String:length	()I
    //   8854: istore 13
    //   8856: goto -120 -> 8736
    //   8859: ldc 26
    //   8861: astore_0
    //   8862: goto -61 -> 8801
    //   8865: ldc 26
    //   8867: astore_3
    //   8868: goto -36 -> 8832
    //   8871: ldc 26
    //   8873: astore 18
    //   8875: aload 5
    //   8877: ldc_w 652
    //   8880: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   8883: astore_3
    //   8884: aload 19
    //   8886: invokevirtual 84	java/lang/String:length	()I
    //   8889: ifle +89 -> 8978
    //   8892: new 86	java/lang/StringBuilder
    //   8895: dup
    //   8896: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   8899: aload 19
    //   8901: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8904: ldc_w 443
    //   8907: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8910: aload_3
    //   8911: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8914: aload 21
    //   8916: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   8919: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8922: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8925: astore_0
    //   8926: aload_2
    //   8927: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   8930: ifne +15 -> 8945
    //   8933: iload 14
    //   8935: ifne +10 -> 8945
    //   8938: aload 7
    //   8940: aload 19
    //   8942: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8945: aload 19
    //   8947: invokevirtual 84	java/lang/String:length	()I
    //   8950: ifle +54 -> 9004
    //   8953: ldc_w 445
    //   8956: aload_3
    //   8957: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   8960: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   8963: astore_3
    //   8964: aload 6
    //   8966: aload_3
    //   8967: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   8970: aconst_null
    //   8971: astore_3
    //   8972: iconst_0
    //   8973: istore 13
    //   8975: goto -8048 -> 927
    //   8978: new 86	java/lang/StringBuilder
    //   8981: dup
    //   8982: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   8985: aload_3
    //   8986: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8989: aload 21
    //   8991: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   8994: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8997: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9000: astore_0
    //   9001: goto -75 -> 8926
    //   9004: aload_3
    //   9005: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9008: astore_3
    //   9009: goto -45 -> 8964
    //   9012: ldc 26
    //   9014: astore 18
    //   9016: aload 5
    //   9018: ldc_w 652
    //   9021: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   9024: astore_0
    //   9025: iload_1
    //   9026: iconst_1
    //   9027: if_icmpne +96 -> 9123
    //   9030: new 86	java/lang/StringBuilder
    //   9033: dup
    //   9034: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9037: aload_0
    //   9038: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9041: aload 21
    //   9043: getfield 655	com/tencent/mm/ag/k$b:iyb	Ljava/lang/String;
    //   9046: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9049: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9052: astore_3
    //   9053: aload 19
    //   9055: invokevirtual 84	java/lang/String:length	()I
    //   9058: ifle +57 -> 9115
    //   9061: ldc_w 445
    //   9064: aload_3
    //   9065: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9068: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   9071: astore_0
    //   9072: aload 6
    //   9074: aload_0
    //   9075: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9078: aload_3
    //   9079: astore_0
    //   9080: aload_2
    //   9081: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   9084: ifne +2163 -> 11247
    //   9087: aload_3
    //   9088: astore_0
    //   9089: iload 14
    //   9091: ifne +2156 -> 11247
    //   9094: aload 7
    //   9096: aload 19
    //   9098: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9101: aconst_null
    //   9102: astore 21
    //   9104: iconst_0
    //   9105: istore 13
    //   9107: aload_3
    //   9108: astore_0
    //   9109: aload 21
    //   9111: astore_3
    //   9112: goto -8185 -> 927
    //   9115: aload_3
    //   9116: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9119: astore_0
    //   9120: goto -48 -> 9072
    //   9123: new 86	java/lang/StringBuilder
    //   9126: dup
    //   9127: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9130: aload_0
    //   9131: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9134: aload 21
    //   9136: getfield 664	com/tencent/mm/ag/k$b:iya	Ljava/lang/String;
    //   9139: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9142: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9145: astore_3
    //   9146: aload 19
    //   9148: invokevirtual 84	java/lang/String:length	()I
    //   9151: ifle +23 -> 9174
    //   9154: ldc_w 445
    //   9157: aload_3
    //   9158: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9161: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   9164: astore_0
    //   9165: aload 6
    //   9167: aload_0
    //   9168: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9171: goto -93 -> 9078
    //   9174: aload_3
    //   9175: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   9178: astore_0
    //   9179: goto -14 -> 9165
    //   9182: aload_0
    //   9183: invokestatic 844	com/tencent/mm/ag/t:HI	(Ljava/lang/String;)Lcom/tencent/mm/ag/t;
    //   9186: getfield 847	com/tencent/mm/ag/t:iAl	I
    //   9189: bipush 19
    //   9191: if_icmpne +27 -> 9218
    //   9194: aload 5
    //   9196: ldc_w 832
    //   9199: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   9202: astore 18
    //   9204: aconst_null
    //   9205: astore 21
    //   9207: iconst_0
    //   9208: istore 13
    //   9210: aload_3
    //   9211: astore_0
    //   9212: aload 21
    //   9214: astore_3
    //   9215: goto -8288 -> 927
    //   9218: aload 5
    //   9220: ldc_w 665
    //   9223: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   9226: astore 18
    //   9228: aconst_null
    //   9229: astore 21
    //   9231: iconst_0
    //   9232: istore 13
    //   9234: aload_3
    //   9235: astore_0
    //   9236: aload 21
    //   9238: astore_3
    //   9239: goto -8312 -> 927
    //   9242: ldc 26
    //   9244: astore 18
    //   9246: aload 5
    //   9248: ldc_w 665
    //   9251: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   9254: astore_3
    //   9255: aload 19
    //   9257: invokevirtual 84	java/lang/String:length	()I
    //   9260: ifle +111 -> 9371
    //   9263: new 86	java/lang/StringBuilder
    //   9266: dup
    //   9267: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9270: aload 19
    //   9272: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9275: ldc_w 443
    //   9278: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9281: aload_3
    //   9282: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9285: aload 21
    //   9287: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   9290: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9293: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9296: astore_0
    //   9297: aload_2
    //   9298: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   9301: ifne +22 -> 9323
    //   9304: iload 14
    //   9306: ifne +17 -> 9323
    //   9309: aload_2
    //   9310: invokestatic 417	com/tencent/mm/model/ab:JB	(Ljava/lang/String;)Z
    //   9313: ifne +10 -> 9323
    //   9316: aload 7
    //   9318: aload 19
    //   9320: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9323: aload 19
    //   9325: invokevirtual 84	java/lang/String:length	()I
    //   9328: ifle +69 -> 9397
    //   9331: new 86	java/lang/StringBuilder
    //   9334: dup
    //   9335: ldc_w 445
    //   9338: invokespecial 603	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9341: aload_3
    //   9342: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9345: aload 21
    //   9347: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   9350: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9353: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9356: astore_3
    //   9357: aload 6
    //   9359: aload_3
    //   9360: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9363: aconst_null
    //   9364: astore_3
    //   9365: iconst_0
    //   9366: istore 13
    //   9368: goto -8441 -> 927
    //   9371: new 86	java/lang/StringBuilder
    //   9374: dup
    //   9375: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9378: aload_3
    //   9379: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9382: aload 21
    //   9384: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   9387: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9390: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9393: astore_0
    //   9394: goto -97 -> 9297
    //   9397: new 86	java/lang/StringBuilder
    //   9400: dup
    //   9401: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9404: aload_3
    //   9405: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9408: aload 21
    //   9410: getfield 576	com/tencent/mm/ag/k$b:title	Ljava/lang/String;
    //   9413: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9416: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9419: astore_3
    //   9420: goto -63 -> 9357
    //   9423: aload_3
    //   9424: astore_0
    //   9425: iload 15
    //   9427: ifeq +8 -> 9435
    //   9430: aload_3
    //   9431: invokestatic 849	com/tencent/mm/booter/notification/a/h:Dh	(Ljava/lang/String;)Ljava/lang/String;
    //   9434: astore_0
    //   9435: ldc_w 310
    //   9438: invokestatic 316	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   9441: checkcast 310	com/tencent/mm/plugin/biz/a/a
    //   9444: aload_0
    //   9445: invokeinterface 852 2 0
    //   9450: astore_3
    //   9451: aload_3
    //   9452: astore_0
    //   9453: iload 15
    //   9455: ifeq +8 -> 9463
    //   9458: aload_3
    //   9459: invokestatic 398	com/tencent/mm/booter/notification/a/h:Dg	(Ljava/lang/String;)Ljava/lang/String;
    //   9462: astore_0
    //   9463: aload_0
    //   9464: invokestatic 224	com/tencent/mm/pluginsdk/ui/span/l:bfh	(Ljava/lang/String;)Ljava/lang/String;
    //   9467: astore_0
    //   9468: aload 6
    //   9470: aload_0
    //   9471: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9474: aconst_null
    //   9475: astore_3
    //   9476: iconst_0
    //   9477: istore 13
    //   9479: aload 22
    //   9481: astore 18
    //   9483: goto -8556 -> 927
    //   9486: aload 6
    //   9488: ldc_w 310
    //   9491: invokestatic 316	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   9494: checkcast 310	com/tencent/mm/plugin/biz/a/a
    //   9497: aload_3
    //   9498: invokeinterface 855 2 0
    //   9503: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9506: aload 6
    //   9508: getfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9511: astore 18
    //   9513: ldc_w 644
    //   9516: ldc_w 857
    //   9519: iconst_2
    //   9520: anewarray 4	java/lang/Object
    //   9523: dup
    //   9524: iconst_0
    //   9525: ldc_w 308
    //   9528: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   9531: aastore
    //   9532: dup
    //   9533: iconst_1
    //   9534: aload 18
    //   9536: aastore
    //   9537: invokestatic 860	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9540: aconst_null
    //   9541: astore_3
    //   9542: iconst_0
    //   9543: istore 13
    //   9545: ldc 26
    //   9547: astore_0
    //   9548: goto -8621 -> 927
    //   9551: aload_3
    //   9552: invokestatic 866	com/tencent/mm/am/a$a:NS	(Ljava/lang/String;)Lcom/tencent/mm/am/a$a;
    //   9555: invokestatic 871	com/tencent/mm/am/a:b	(Lcom/tencent/mm/am/a$a;)Ljava/lang/String;
    //   9558: astore_0
    //   9559: aload 6
    //   9561: aload_0
    //   9562: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9565: aconst_null
    //   9566: astore_3
    //   9567: iconst_0
    //   9568: istore 13
    //   9570: aload 22
    //   9572: astore 18
    //   9574: goto -8647 -> 927
    //   9577: ldc 26
    //   9579: astore_3
    //   9580: aload 21
    //   9582: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   9585: astore 18
    //   9587: aload_3
    //   9588: astore_0
    //   9589: aload 18
    //   9591: ifnull -8673 -> 918
    //   9594: aload_3
    //   9595: astore_0
    //   9596: aload 18
    //   9598: getfield 668	com/tencent/mm/ag/k$b:content	Ljava/lang/String;
    //   9601: ldc_w 670
    //   9604: invokestatic 675	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   9607: astore_3
    //   9608: aload_3
    //   9609: astore_0
    //   9610: aload_3
    //   9611: invokestatic 224	com/tencent/mm/pluginsdk/ui/span/l:bfh	(Ljava/lang/String;)Ljava/lang/String;
    //   9614: astore_3
    //   9615: aload_3
    //   9616: astore_0
    //   9617: aload 6
    //   9619: aload_0
    //   9620: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9623: aconst_null
    //   9624: astore_3
    //   9625: iconst_0
    //   9626: istore 13
    //   9628: aload 22
    //   9630: astore 18
    //   9632: goto -8705 -> 927
    //   9635: astore_3
    //   9636: ldc_w 644
    //   9639: aload_3
    //   9640: ldc 26
    //   9642: iconst_0
    //   9643: anewarray 4	java/lang/Object
    //   9646: invokestatic 679	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9649: aconst_null
    //   9650: astore_3
    //   9651: iconst_0
    //   9652: istore 13
    //   9654: aload 22
    //   9656: astore 18
    //   9658: goto -8731 -> 927
    //   9661: ldc_w 873
    //   9664: invokestatic 316	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   9667: checkcast 873	com/tencent/mm/plugin/messenger/a/e
    //   9670: aload_3
    //   9671: invokeinterface 877 2 0
    //   9676: astore_0
    //   9677: aload_0
    //   9678: ifnull +108 -> 9786
    //   9681: aload_0
    //   9682: invokeinterface 880 1 0
    //   9687: astore_0
    //   9688: aload_0
    //   9689: astore_3
    //   9690: iload 9
    //   9692: ifeq +68 -> 9760
    //   9695: aload_0
    //   9696: astore_3
    //   9697: aload_2
    //   9698: invokestatic 399	com/tencent/mm/model/ab:Eq	(Ljava/lang/String;)Z
    //   9701: ifeq +59 -> 9760
    //   9704: aload_0
    //   9705: astore_3
    //   9706: aload_0
    //   9707: aload 5
    //   9709: ldc_w 881
    //   9712: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   9715: invokevirtual 884	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   9718: ifeq +42 -> 9760
    //   9721: ldc_w 644
    //   9724: ldc_w 886
    //   9727: iconst_1
    //   9728: anewarray 4	java/lang/Object
    //   9731: dup
    //   9732: iconst_0
    //   9733: aload_0
    //   9734: aastore
    //   9735: invokestatic 860	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9738: aload_0
    //   9739: iconst_0
    //   9740: aload_0
    //   9741: invokevirtual 84	java/lang/String:length	()I
    //   9744: aload 5
    //   9746: ldc_w 881
    //   9749: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   9752: invokevirtual 84	java/lang/String:length	()I
    //   9755: isub
    //   9756: invokevirtual 91	java/lang/String:substring	(II)Ljava/lang/String;
    //   9759: astore_3
    //   9760: aload_3
    //   9761: astore_0
    //   9762: aload_0
    //   9763: astore_3
    //   9764: aload 6
    //   9766: astore 18
    //   9768: aload 18
    //   9770: aload_3
    //   9771: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9774: ldc 26
    //   9776: astore 18
    //   9778: aconst_null
    //   9779: astore_3
    //   9780: iconst_0
    //   9781: istore 13
    //   9783: goto -8856 -> 927
    //   9786: ldc 26
    //   9788: astore_0
    //   9789: goto -101 -> 9688
    //   9792: aload_3
    //   9793: invokestatic 892	com/tencent/mm/ag/a/b:HM	(Ljava/lang/String;)Lcom/tencent/mm/ag/a/b;
    //   9796: getfield 893	com/tencent/mm/ag/a/b:content	Ljava/lang/String;
    //   9799: astore_3
    //   9800: aload_3
    //   9801: astore_0
    //   9802: aload_3
    //   9803: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9806: ifeq +6 -> 9812
    //   9809: ldc 26
    //   9811: astore_0
    //   9812: goto -50 -> 9762
    //   9815: aload 5
    //   9817: ldc_w 894
    //   9820: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   9823: astore_0
    //   9824: goto -62 -> 9762
    //   9827: aload_3
    //   9828: invokestatic 900	com/tencent/mm/ag/a/a:HK	(Ljava/lang/String;)Lcom/tencent/mm/ag/a/a;
    //   9831: astore_0
    //   9832: aload_0
    //   9833: getfield 901	com/tencent/mm/ag/a/a:nickname	Ljava/lang/String;
    //   9836: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9839: ifne +13 -> 9852
    //   9842: aload_0
    //   9843: getfield 902	com/tencent/mm/ag/a/a:title	Ljava/lang/String;
    //   9846: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9849: ifeq +9 -> 9858
    //   9852: ldc 26
    //   9854: astore_0
    //   9855: goto -93 -> 9762
    //   9858: getstatic 908	java/util/Locale:US	Ljava/util/Locale;
    //   9861: ldc_w 581
    //   9864: iconst_2
    //   9865: anewarray 4	java/lang/Object
    //   9868: dup
    //   9869: iconst_0
    //   9870: aload_0
    //   9871: getfield 901	com/tencent/mm/ag/a/a:nickname	Ljava/lang/String;
    //   9874: aastore
    //   9875: dup
    //   9876: iconst_1
    //   9877: aload_0
    //   9878: getfield 902	com/tencent/mm/ag/a/a:title	Ljava/lang/String;
    //   9881: aastore
    //   9882: invokestatic 911	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   9885: astore_0
    //   9886: goto -31 -> 9855
    //   9889: ldc 26
    //   9891: astore 18
    //   9893: aload 21
    //   9895: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   9898: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   9901: astore_3
    //   9902: aload_3
    //   9903: ifnonnull +21 -> 9924
    //   9906: ldc_w 644
    //   9909: ldc_w 646
    //   9912: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   9915: ldc_w 379
    //   9918: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   9921: ldc 26
    //   9923: areturn
    //   9924: aload_2
    //   9925: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   9928: ifne +15 -> 9943
    //   9931: iload 14
    //   9933: ifne +10 -> 9943
    //   9936: aload 7
    //   9938: aload 19
    //   9940: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   9943: aload 5
    //   9945: ldc_w 680
    //   9948: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   9951: astore_0
    //   9952: aload_3
    //   9953: ldc_w 719
    //   9956: invokevirtual 622	com/tencent/mm/ag/k$b:as	(Ljava/lang/Class;)Lcom/tencent/mm/ag/f;
    //   9959: checkcast 719	com/tencent/mm/plugin/i/a/h
    //   9962: astore_3
    //   9963: aload_3
    //   9964: ifnull +1280 -> 11244
    //   9967: aload_3
    //   9968: invokevirtual 723	com/tencent/mm/plugin/i/a/h:dJv	()Lcom/tencent/mm/protocal/protobuf/bcl;
    //   9971: getfield 728	com/tencent/mm/protocal/protobuf/bcl:dST	Ljava/lang/String;
    //   9974: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9977: ifne +1267 -> 11244
    //   9980: aload_3
    //   9981: invokevirtual 723	com/tencent/mm/plugin/i/a/h:dJv	()Lcom/tencent/mm/protocal/protobuf/bcl;
    //   9984: getfield 731	com/tencent/mm/protocal/protobuf/bcl:tvC	I
    //   9987: iconst_1
    //   9988: if_icmpne +77 -> 10065
    //   9991: new 86	java/lang/StringBuilder
    //   9994: dup
    //   9995: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   9998: aload_0
    //   9999: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10002: invokestatic 115	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   10005: ldc_w 732
    //   10008: iconst_1
    //   10009: anewarray 4	java/lang/Object
    //   10012: dup
    //   10013: iconst_0
    //   10014: aload_3
    //   10015: invokevirtual 723	com/tencent/mm/plugin/i/a/h:dJv	()Lcom/tencent/mm/protocal/protobuf/bcl;
    //   10018: getfield 728	com/tencent/mm/protocal/protobuf/bcl:dST	Ljava/lang/String;
    //   10021: aastore
    //   10022: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   10025: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10028: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10031: astore_0
    //   10032: aload 19
    //   10034: invokevirtual 84	java/lang/String:length	()I
    //   10037: ifle +56 -> 10093
    //   10040: ldc_w 445
    //   10043: aload_0
    //   10044: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   10047: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   10050: astore_3
    //   10051: aload 6
    //   10053: aload_3
    //   10054: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10057: aconst_null
    //   10058: astore_3
    //   10059: iconst_0
    //   10060: istore 13
    //   10062: goto -9135 -> 927
    //   10065: new 86	java/lang/StringBuilder
    //   10068: dup
    //   10069: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   10072: aload_0
    //   10073: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10076: aload_3
    //   10077: invokevirtual 723	com/tencent/mm/plugin/i/a/h:dJv	()Lcom/tencent/mm/protocal/protobuf/bcl;
    //   10080: getfield 728	com/tencent/mm/protocal/protobuf/bcl:dST	Ljava/lang/String;
    //   10083: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10086: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10089: astore_0
    //   10090: goto -58 -> 10032
    //   10093: aload_0
    //   10094: astore_3
    //   10095: goto -44 -> 10051
    //   10098: aload 21
    //   10100: invokestatic 559	com/tencent/mm/sdk/platformtools/Util:processXml	(Ljava/lang/String;)Ljava/lang/String;
    //   10103: invokestatic 565	com/tencent/mm/ag/k$b:HD	(Ljava/lang/String;)Lcom/tencent/mm/ag/k$b;
    //   10106: astore_3
    //   10107: aload_3
    //   10108: ifnonnull +21 -> 10129
    //   10111: ldc_w 644
    //   10114: ldc_w 913
    //   10117: invokestatic 651	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   10120: ldc_w 379
    //   10123: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   10126: ldc 26
    //   10128: areturn
    //   10129: aload_2
    //   10130: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   10133: ifne +15 -> 10148
    //   10136: iload 14
    //   10138: ifne +10 -> 10148
    //   10141: aload 7
    //   10143: aload 19
    //   10145: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10148: aload 5
    //   10150: ldc_w 680
    //   10153: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   10156: astore_0
    //   10157: aload_3
    //   10158: ldc_w 915
    //   10161: invokevirtual 622	com/tencent/mm/ag/k$b:as	(Ljava/lang/Class;)Lcom/tencent/mm/ag/f;
    //   10164: checkcast 915	com/tencent/mm/plugin/i/a/c
    //   10167: astore_3
    //   10168: aload_3
    //   10169: ifnull +1072 -> 11241
    //   10172: aload_3
    //   10173: invokevirtual 916	com/tencent/mm/plugin/i/a/c:dJv	()Lcom/tencent/mm/protocal/protobuf/bcl;
    //   10176: getfield 728	com/tencent/mm/protocal/protobuf/bcl:dST	Ljava/lang/String;
    //   10179: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10182: ifne +1059 -> 11241
    //   10185: aload_3
    //   10186: invokevirtual 916	com/tencent/mm/plugin/i/a/c:dJv	()Lcom/tencent/mm/protocal/protobuf/bcl;
    //   10189: getfield 731	com/tencent/mm/protocal/protobuf/bcl:tvC	I
    //   10192: bipush 7
    //   10194: if_icmpne +1047 -> 11241
    //   10197: aload_3
    //   10198: invokevirtual 916	com/tencent/mm/plugin/i/a/c:dJv	()Lcom/tencent/mm/protocal/protobuf/bcl;
    //   10201: getfield 920	com/tencent/mm/protocal/protobuf/bcl:LLD	Lcom/tencent/mm/protocal/protobuf/aoi;
    //   10204: ifnull +1037 -> 11241
    //   10207: new 86	java/lang/StringBuilder
    //   10210: dup
    //   10211: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   10214: aload_0
    //   10215: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10218: invokestatic 115	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   10221: ldc_w 921
    //   10224: iconst_2
    //   10225: anewarray 4	java/lang/Object
    //   10228: dup
    //   10229: iconst_0
    //   10230: aload_3
    //   10231: invokevirtual 916	com/tencent/mm/plugin/i/a/c:dJv	()Lcom/tencent/mm/protocal/protobuf/bcl;
    //   10234: getfield 920	com/tencent/mm/protocal/protobuf/bcl:LLD	Lcom/tencent/mm/protocal/protobuf/aoi;
    //   10237: getfield 926	com/tencent/mm/protocal/protobuf/aoi:LAr	Ljava/lang/String;
    //   10240: aastore
    //   10241: dup
    //   10242: iconst_1
    //   10243: aload_3
    //   10244: invokevirtual 916	com/tencent/mm/plugin/i/a/c:dJv	()Lcom/tencent/mm/protocal/protobuf/bcl;
    //   10247: getfield 920	com/tencent/mm/protocal/protobuf/bcl:LLD	Lcom/tencent/mm/protocal/protobuf/aoi;
    //   10250: getfield 929	com/tencent/mm/protocal/protobuf/aoi:LAq	Ljava/lang/String;
    //   10253: aastore
    //   10254: invokevirtual 187	android/content/Context:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   10257: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10260: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10263: astore_0
    //   10264: aload 19
    //   10266: invokevirtual 84	java/lang/String:length	()I
    //   10269: ifle +969 -> 11238
    //   10272: ldc_w 445
    //   10275: aload_0
    //   10276: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   10279: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   10282: astore_3
    //   10283: aload 6
    //   10285: astore 18
    //   10287: goto -519 -> 9768
    //   10290: aload_0
    //   10291: ldc_w 931
    //   10294: invokevirtual 935	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   10297: astore_0
    //   10298: aload_0
    //   10299: arraylength
    //   10300: iconst_1
    //   10301: if_icmple +23 -> 10324
    //   10304: aload 6
    //   10306: aload_0
    //   10307: iconst_1
    //   10308: aaload
    //   10309: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10312: aload_0
    //   10313: iconst_1
    //   10314: aaload
    //   10315: astore_0
    //   10316: ldc_w 379
    //   10319: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   10322: aload_0
    //   10323: areturn
    //   10324: aload 6
    //   10326: ldc 26
    //   10328: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10331: ldc_w 379
    //   10334: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   10337: aconst_null
    //   10338: areturn
    //   10339: aconst_null
    //   10340: astore_2
    //   10341: aconst_null
    //   10342: astore 5
    //   10344: aload_0
    //   10345: ldc 158
    //   10347: invokevirtual 935	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   10350: astore_3
    //   10351: aload_3
    //   10352: ifnull +8 -> 10360
    //   10355: aload_3
    //   10356: arraylength
    //   10357: ifgt +18 -> 10375
    //   10360: aload 6
    //   10362: ldc 26
    //   10364: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10367: ldc_w 379
    //   10370: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   10373: aconst_null
    //   10374: areturn
    //   10375: aload_3
    //   10376: iconst_0
    //   10377: aaload
    //   10378: astore_3
    //   10379: aload_3
    //   10380: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10383: ifne +62 -> 10445
    //   10386: invokestatic 277	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   10389: pop
    //   10390: invokestatic 283	com/tencent/mm/model/c:aSN	()Lcom/tencent/mm/storage/bv;
    //   10393: aload_3
    //   10394: invokeinterface 289 2 0
    //   10399: astore 7
    //   10401: aload 5
    //   10403: astore_3
    //   10404: aload 7
    //   10406: ifnull +20 -> 10426
    //   10409: aload 5
    //   10411: astore_3
    //   10412: aload 7
    //   10414: invokevirtual 339	com/tencent/mm/storage/as:getCity	()Ljava/lang/String;
    //   10417: ifnull +9 -> 10426
    //   10420: aload 7
    //   10422: invokevirtual 339	com/tencent/mm/storage/as:getCity	()Ljava/lang/String;
    //   10425: astore_3
    //   10426: aload_3
    //   10427: ifnull +12 -> 10439
    //   10430: aload_3
    //   10431: astore_2
    //   10432: aload_3
    //   10433: invokevirtual 84	java/lang/String:length	()I
    //   10436: ifgt +9 -> 10445
    //   10439: aload 7
    //   10441: invokevirtual 346	com/tencent/mm/storage/as:getProvince	()Ljava/lang/String;
    //   10444: astore_2
    //   10445: aload 18
    //   10447: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10450: ifne +67 -> 10517
    //   10453: aload 6
    //   10455: new 86	java/lang/StringBuilder
    //   10458: dup
    //   10459: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   10462: aload_2
    //   10463: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10466: ldc_w 443
    //   10469: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10472: aload 18
    //   10474: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10477: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10480: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10483: new 86	java/lang/StringBuilder
    //   10486: dup
    //   10487: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   10490: aload_2
    //   10491: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10494: ldc_w 443
    //   10497: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10500: aload 18
    //   10502: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10505: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10508: astore_0
    //   10509: ldc_w 379
    //   10512: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   10515: aload_0
    //   10516: areturn
    //   10517: aload_0
    //   10518: ldc_w 931
    //   10521: invokevirtual 935	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   10524: astore_0
    //   10525: aload_0
    //   10526: arraylength
    //   10527: iconst_1
    //   10528: if_icmple +69 -> 10597
    //   10531: aload 6
    //   10533: new 86	java/lang/StringBuilder
    //   10536: dup
    //   10537: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   10540: aload_2
    //   10541: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10544: ldc_w 443
    //   10547: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10550: aload_0
    //   10551: iconst_1
    //   10552: aaload
    //   10553: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10556: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10559: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10562: new 86	java/lang/StringBuilder
    //   10565: dup
    //   10566: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   10569: aload_2
    //   10570: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10573: ldc_w 443
    //   10576: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10579: aload_0
    //   10580: iconst_1
    //   10581: aaload
    //   10582: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10585: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10588: astore_0
    //   10589: ldc_w 379
    //   10592: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   10595: aload_0
    //   10596: areturn
    //   10597: aload 6
    //   10599: aload_2
    //   10600: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10603: ldc_w 379
    //   10606: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   10609: aload_2
    //   10610: areturn
    //   10611: aload_0
    //   10612: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10615: ifeq +10 -> 10625
    //   10618: aload 6
    //   10620: ldc 26
    //   10622: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10625: aload 19
    //   10627: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10630: ifne +203 -> 10833
    //   10633: aload_0
    //   10634: astore_2
    //   10635: aload 20
    //   10637: ifnull +22 -> 10659
    //   10640: aload_0
    //   10641: astore_2
    //   10642: aload 20
    //   10644: invokevirtual 84	java/lang/String:length	()I
    //   10647: ifle +12 -> 10659
    //   10650: aload_0
    //   10651: aload 19
    //   10653: aload 20
    //   10655: invokestatic 939	com/tencent/mm/booter/notification/a/h:f	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10658: astore_2
    //   10659: aload 7
    //   10661: getfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10664: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10667: ifeq +28 -> 10695
    //   10670: aload 6
    //   10672: aload 6
    //   10674: getfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10677: aload 19
    //   10679: ldc_w 551
    //   10682: invokestatic 939	com/tencent/mm/booter/notification/a/h:f	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   10685: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10688: aload 7
    //   10690: aload 19
    //   10692: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10695: aload_2
    //   10696: invokestatic 944	com/tencent/mm/compatible/util/o:Eh	(Ljava/lang/String;)Ljava/lang/String;
    //   10699: astore_0
    //   10700: aload 6
    //   10702: aload 6
    //   10704: getfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10707: invokestatic 944	com/tencent/mm/compatible/util/o:Eh	(Ljava/lang/String;)Ljava/lang/String;
    //   10710: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10713: new 86	java/lang/StringBuilder
    //   10716: dup
    //   10717: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   10720: aload_0
    //   10721: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10724: aload 18
    //   10726: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10729: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10732: astore_2
    //   10733: aload 6
    //   10735: new 86	java/lang/StringBuilder
    //   10738: dup
    //   10739: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   10742: aload 6
    //   10744: getfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10747: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10750: aload 18
    //   10752: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10755: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10758: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10761: iload 9
    //   10763: ifeq +25 -> 10788
    //   10766: iload 4
    //   10768: aload 6
    //   10770: aload_2
    //   10771: invokestatic 947	com/tencent/mm/booter/notification/a/h:a	(ILcom/tencent/mm/pointers/PString;Ljava/lang/String;)Z
    //   10774: ifne +14 -> 10788
    //   10777: iload 4
    //   10779: aload 6
    //   10781: aload 7
    //   10783: aload 8
    //   10785: invokestatic 950	com/tencent/mm/booter/notification/a/h:a	(ILcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PInt;)V
    //   10788: aload_2
    //   10789: astore_0
    //   10790: iload 13
    //   10792: ifeq +28 -> 10820
    //   10795: aload_2
    //   10796: new 86	java/lang/StringBuilder
    //   10799: dup
    //   10800: ldc_w 411
    //   10803: invokespecial 603	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10806: aload_3
    //   10807: invokestatic 154	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   10810: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10813: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10816: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   10819: astore_0
    //   10820: aload_0
    //   10821: invokestatic 154	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   10824: astore_0
    //   10825: ldc_w 379
    //   10828: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   10831: aload_0
    //   10832: areturn
    //   10833: aload_2
    //   10834: invokestatic 414	com/tencent/mm/model/ab:Js	(Ljava/lang/String;)Z
    //   10837: ifne +15 -> 10852
    //   10840: iload 14
    //   10842: ifne +10 -> 10852
    //   10845: aload_2
    //   10846: invokestatic 417	com/tencent/mm/model/ab:JB	(Ljava/lang/String;)Z
    //   10849: ifeq +330 -> 11179
    //   10852: aload_0
    //   10853: astore 19
    //   10855: aload 18
    //   10857: ifnull +18 -> 10875
    //   10860: aload_0
    //   10861: astore 19
    //   10863: aload 18
    //   10865: invokevirtual 84	java/lang/String:length	()I
    //   10868: ifle +7 -> 10875
    //   10871: aload 18
    //   10873: astore 19
    //   10875: aload 19
    //   10877: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10880: ifeq +26 -> 10906
    //   10883: aload 6
    //   10885: ldc 26
    //   10887: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10890: aload 7
    //   10892: ldc 26
    //   10894: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10897: ldc_w 379
    //   10900: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   10903: ldc 26
    //   10905: areturn
    //   10906: iload_1
    //   10907: ifne +193 -> 11100
    //   10910: aload 6
    //   10912: ldc_w 466
    //   10915: aload 19
    //   10917: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   10920: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   10923: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   10926: iload 9
    //   10928: ifeq +211 -> 11139
    //   10931: iload 4
    //   10933: aload 6
    //   10935: aload 7
    //   10937: aload 8
    //   10939: invokestatic 950	com/tencent/mm/booter/notification/a/h:a	(ILcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PInt;)V
    //   10942: aload 19
    //   10944: astore_0
    //   10945: aload_0
    //   10946: astore 5
    //   10948: iload 13
    //   10950: ifeq +26 -> 10976
    //   10953: aload_0
    //   10954: astore 5
    //   10956: aload_3
    //   10957: ifnull +19 -> 10976
    //   10960: aload_0
    //   10961: ldc_w 411
    //   10964: aload_3
    //   10965: invokestatic 658	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   10968: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   10971: invokevirtual 661	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   10974: astore 5
    //   10976: aload 5
    //   10978: astore_0
    //   10979: iload 15
    //   10981: ifeq +9 -> 10990
    //   10984: aload 5
    //   10986: invokestatic 849	com/tencent/mm/booter/notification/a/h:Dh	(Ljava/lang/String;)Ljava/lang/String;
    //   10989: astore_0
    //   10990: aload 11
    //   10992: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10995: ifne +92 -> 11087
    //   10998: aload_2
    //   10999: invokestatic 955	com/tencent/mm/al/g:Nb	(Ljava/lang/String;)Z
    //   11002: ifeq +85 -> 11087
    //   11005: invokestatic 959	com/tencent/mm/al/ag:bag	()Lcom/tencent/mm/al/j;
    //   11008: aload 11
    //   11010: invokevirtual 965	com/tencent/mm/al/j:Nm	(Ljava/lang/String;)Lcom/tencent/mm/al/h;
    //   11013: astore_2
    //   11014: aload_2
    //   11015: ifnull +72 -> 11087
    //   11018: aload_2
    //   11019: getfield 970	com/tencent/mm/al/h:field_openId	Ljava/lang/String;
    //   11022: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   11025: ifne +62 -> 11087
    //   11028: aload_2
    //   11029: getfield 971	com/tencent/mm/al/h:field_nickname	Ljava/lang/String;
    //   11032: invokestatic 234	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   11035: ifne +52 -> 11087
    //   11038: iload 12
    //   11040: iconst_2
    //   11041: if_icmpeq +11 -> 11052
    //   11044: aload_2
    //   11045: getfield 974	com/tencent/mm/al/h:field_kfType	I
    //   11048: iconst_2
    //   11049: if_icmpne +38 -> 11087
    //   11052: aload 6
    //   11054: new 86	java/lang/StringBuilder
    //   11057: dup
    //   11058: ldc_w 466
    //   11061: invokespecial 603	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11064: aload 6
    //   11066: getfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   11069: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11072: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11075: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   11078: aload 7
    //   11080: aload_2
    //   11081: getfield 971	com/tencent/mm/al/h:field_nickname	Ljava/lang/String;
    //   11084: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   11087: aload_0
    //   11088: invokestatic 154	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   11091: astore_0
    //   11092: ldc_w 379
    //   11095: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   11098: aload_0
    //   11099: areturn
    //   11100: aload 6
    //   11102: new 86	java/lang/StringBuilder
    //   11105: dup
    //   11106: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   11109: aload 5
    //   11111: ldc_w 975
    //   11114: invokevirtual 189	android/content/Context:getString	(I)Ljava/lang/String;
    //   11117: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11120: ldc 158
    //   11122: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11125: aload 19
    //   11127: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11130: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11133: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   11136: goto -210 -> 10926
    //   11139: new 86	java/lang/StringBuilder
    //   11142: dup
    //   11143: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   11146: aload 7
    //   11148: getfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   11151: invokestatic 175	com/tencent/mm/model/aa:getDisplayName	(Ljava/lang/String;)Ljava/lang/String;
    //   11154: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11157: ldc 158
    //   11159: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11162: aload 19
    //   11164: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11167: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11170: astore_0
    //   11171: ldc_w 379
    //   11174: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   11177: aload_0
    //   11178: areturn
    //   11179: aload 18
    //   11181: ifnull +51 -> 11232
    //   11184: aload 18
    //   11186: invokevirtual 84	java/lang/String:length	()I
    //   11189: ifle +43 -> 11232
    //   11192: aload 6
    //   11194: aload 18
    //   11196: putfield 178	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   11199: aload 18
    //   11201: astore 5
    //   11203: aload 5
    //   11205: astore_0
    //   11206: iload 9
    //   11208: ifeq -263 -> 10945
    //   11211: iload 4
    //   11213: aload 6
    //   11215: aload 7
    //   11217: aload 8
    //   11219: invokestatic 950	com/tencent/mm/booter/notification/a/h:a	(ILcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PInt;)V
    //   11222: aload 5
    //   11224: astore_0
    //   11225: goto -280 -> 10945
    //   11228: astore_3
    //   11229: goto -1593 -> 9636
    //   11232: aload_0
    //   11233: astore 5
    //   11235: goto -32 -> 11203
    //   11238: goto -1476 -> 9762
    //   11241: goto -977 -> 10264
    //   11244: goto -1212 -> 10032
    //   11247: ldc 26
    //   11249: astore 18
    //   11251: aconst_null
    //   11252: astore_3
    //   11253: iconst_0
    //   11254: istore 13
    //   11256: goto -10329 -> 927
    //   11259: goto -4709 -> 6550
    //   11262: ldc 26
    //   11264: astore_0
    //   11265: goto -5093 -> 6172
    //   11268: ldc 26
    //   11270: astore_0
    //   11271: goto -5321 -> 5950
    //   11274: goto -5447 -> 5827
    //   11277: goto -5632 -> 5645
    //   11280: goto -5816 -> 5464
    //   11283: aload_3
    //   11284: astore_0
    //   11285: goto -6001 -> 5284
    //   11288: aload_3
    //   11289: astore_0
    //   11290: goto -6201 -> 5089
    //   11293: aload_2
    //   11294: astore_0
    //   11295: goto -8811 -> 2484
    //   11298: aload_2
    //   11299: astore_0
    //   11300: goto -8811 -> 2489
    //   11303: iload 13
    //   11305: istore 14
    //   11307: goto -11020 -> 287
    //   11310: aload_3
    //   11311: astore 21
    //   11313: ldc 26
    //   11315: astore 20
    //   11317: ldc 26
    //   11319: astore 19
    //   11321: goto -11096 -> 225
    //   11324: iconst_0
    //   11325: istore 15
    //   11327: goto -11186 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	11330	0	paramString1	String
    //   0	11330	1	paramInt1	int
    //   0	11330	2	paramString2	String
    //   0	11330	3	paramString3	String
    //   0	11330	4	paramInt2	int
    //   0	11330	5	paramContext	Context
    //   0	11330	6	paramPString1	PString
    //   0	11330	7	paramPString2	PString
    //   0	11330	8	paramPInt	PInt
    //   0	11330	9	paramBoolean1	boolean
    //   0	11330	10	paramBoolean2	boolean
    //   0	11330	11	paramString4	String
    //   0	11330	12	paramInt3	int
    //   169	11135	13	i	int
    //   226	11080	14	j	int
    //   139	11187	15	k	int
    //   1031	2426	16	m	int
    //   12	69	17	bool	boolean
    //   251	10999	18	localObject1	Object
    //   186	11134	19	localObject2	Object
    //   194	11122	20	str1	String
    //   223	4590	21	localObject3	Object
    //   4917	1175	21	localException	Exception
    //   6277	5035	21	localObject4	Object
    //   122	9533	22	str2	String
    // Exception table:
    //   from	to	target	type
    //   4847	4858	4917	java/lang/Exception
    //   4860	4865	4917	java/lang/Exception
    //   9596	9608	9635	java/lang/Exception
    //   9610	9615	9635	java/lang/Exception
    //   9617	9623	11228	java/lang/Exception
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
      paramPString1.value = paramPString1.value.substring(0, G(paramPString1.value, 150));
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
  
  private static int alx()
  {
    AppMethodBeat.i(169682);
    if (gpa > 0)
    {
      i = gpa;
      AppMethodBeat.o(169682);
      return i;
    }
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(MMApplicationContext.getContext(), 14.0F);
    AppMethodBeat.o(169682);
    return i;
  }
  
  private static int aly()
  {
    AppMethodBeat.i(20087);
    if (goZ > 0)
    {
      i = goZ;
      AppMethodBeat.o(20087);
      return i;
    }
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(MMApplicationContext.getContext(), 200.0F);
    AppMethodBeat.o(20087);
    return i;
  }
  
  public static String b(ca paramca, PString paramPString1, PString paramPString2, PInt paramPInt, boolean paramBoolean)
  {
    AppMethodBeat.i(20074);
    String str;
    if (paramca.gDk())
    {
      str = paramca.gDW();
      if (!paramca.gAt()) {
        break label90;
      }
    }
    for (paramca = com.tencent.mm.pluginsdk.ui.span.l.bfh(a(paramca.field_imgPath, paramca.field_isSend, paramca.field_talker, str, paramca.getType(), MMApplicationContext.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean, paramca.fQZ, paramca.fRf));; paramca = a(paramca.field_imgPath, paramca.field_isSend, paramca.field_talker, str, paramca.getType(), MMApplicationContext.getContext(), paramPString1, paramPString2, paramPInt, true, paramBoolean, paramca.fQZ, paramca.fRf))
    {
      paramca = Util.nullAsNil(paramca);
      AppMethodBeat.o(20074);
      return paramca;
      str = paramca.field_content;
      break;
      label90:
      str = com.tencent.mm.pluginsdk.ui.span.l.bfh(str);
    }
  }
  
  public static void b(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(20090);
    if ((goY == null) || (goY.get() == null)) {
      goY = new WeakReference(paramTextPaint);
    }
    AppMethodBeat.o(20090);
  }
  
  public static boolean b(String paramString, ca paramca)
  {
    AppMethodBeat.i(20070);
    if ((paramca != null) && (paramca.field_bizChatId != -1L) && (com.tencent.mm.al.g.DQ(paramString)))
    {
      AppMethodBeat.o(20070);
      return true;
    }
    AppMethodBeat.o(20070);
    return false;
  }
  
  private static String cp(Context paramContext)
  {
    AppMethodBeat.i(20078);
    boolean bool = z.aUy();
    bg.aVF();
    long l = Util.nullAs((Long)com.tencent.mm.model.c.azQ().get(65793, null), 0L);
    if (!bool)
    {
      paramContext = paramContext.getString(2131765538);
      AppMethodBeat.o(20078);
      return paramContext;
    }
    if (l == 0L)
    {
      paramContext = paramContext.getString(2131760871);
      AppMethodBeat.o(20078);
      return paramContext;
    }
    if (Util.secondsToNow(l) * 1000L > 1209600000L)
    {
      paramContext = paramContext.getString(2131760870, new Object[] { Long.valueOf(Util.secondsToNow(l) * 1000L / 86400000L) });
      AppMethodBeat.o(20078);
      return paramContext;
    }
    AppMethodBeat.o(20078);
    return "";
  }
  
  public static String d(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20091);
    paramString = b.gxI().bib(paramString);
    if (paramBoolean)
    {
      AppMethodBeat.o(20091);
      return paramString;
    }
    paramContext = paramContext.getString(2131761792);
    AppMethodBeat.o(20091);
    return paramContext;
  }
  
  public static String e(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(20093);
    if (paramBoolean)
    {
      paramContext = b.gxI().bib(paramString);
      AppMethodBeat.o(20093);
      return paramContext;
    }
    paramContext = paramContext.getString(2131763686);
    AppMethodBeat.o(20093);
    return paramContext;
  }
  
  public static String f(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(20072);
    if (ab.Eq(paramString1))
    {
      paramString2 = bp.Ks(paramString2);
      if (paramString2 != null) {
        paramString2 = aa.getDisplayName(paramString2.trim());
      }
    }
    while (paramString1.contains("@bottle"))
    {
      paramContext = paramContext.getResources().getQuantityString(2131623959, 1, new Object[] { Integer.valueOf(1) });
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
      if (ab.Eq(paramString1)) {
        str = paramContext.getString(2131757507);
      }
    }
    paramContext = b.gxI().bib(str);
    AppMethodBeat.o(20072);
    return paramContext;
  }
  
  private static String f(String paramString1, String paramString2, String paramString3)
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
  
  private static TextPaint getTextPaint()
  {
    AppMethodBeat.i(20089);
    if (goY == null)
    {
      AppMethodBeat.o(20089);
      return null;
    }
    TextPaint localTextPaint = (TextPaint)goY.get();
    AppMethodBeat.o(20089);
    return localTextPaint;
  }
  
  public static void oc(int paramInt)
  {
    goZ = paramInt;
  }
  
  public static void od(int paramInt)
  {
    gpa = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.a.h
 * JD-Core Version:    0.7.0.1
 */