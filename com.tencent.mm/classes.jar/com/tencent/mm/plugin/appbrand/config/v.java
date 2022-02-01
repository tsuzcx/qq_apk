package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.config.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.av.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Locale;

public final class v
  extends q
{
  private static volatile v jYW;
  
  public static boolean NA(String paramString)
  {
    AppMethodBeat.i(44893);
    if (j.aYP() != null)
    {
      paramString = j.aYP().d(paramString, new String[] { "appInfo" });
      if (paramString != null)
      {
        if ((paramString.bel() != null) && (paramString.bel().ber()))
        {
          AppMethodBeat.o(44893);
          return true;
        }
        AppMethodBeat.o(44893);
        return false;
      }
    }
    AppMethodBeat.o(44893);
    return false;
  }
  
  public static AppBrandSysConfigWC NB(String paramString)
  {
    AppMethodBeat.i(44894);
    paramString = j.aYP().e(paramString, new String[0]);
    if (paramString != null)
    {
      paramString = e(paramString);
      AppMethodBeat.o(44894);
      return paramString;
    }
    AppMethodBeat.o(44894);
    return null;
  }
  
  public static long NC(String paramString)
  {
    AppMethodBeat.i(44896);
    paramString = j.aYP().d(paramString, new String[] { "appInfo" });
    if ((paramString == null) || (paramString.bel() == null))
    {
      AppMethodBeat.o(44896);
      return 0L;
    }
    long l = paramString.bel().cnh;
    AppMethodBeat.o(44896);
    return l;
  }
  
  public static String[] ND(String paramString)
  {
    AppMethodBeat.i(44897);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44897);
      return null;
    }
    Object localObject = j.aYP().d(paramString, new String[] { "roundedSquareIconURL", "bigHeadURL" });
    if (localObject == null)
    {
      AppMethodBeat.o(44897);
      return null;
    }
    paramString = ((WxaAttributes)localObject).field_roundedSquareIconURL;
    localObject = ((WxaAttributes)localObject).field_bigHeadURL;
    AppMethodBeat.o(44897);
    return new String[] { paramString, localObject };
  }
  
  public static String NE(String paramString)
  {
    AppMethodBeat.i(44898);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44898);
      return null;
    }
    paramString = j.aYP().d(paramString, new String[] { "appId" });
    if (paramString == null)
    {
      AppMethodBeat.o(44898);
      return null;
    }
    paramString = paramString.field_appId;
    AppMethodBeat.o(44898);
    return paramString;
  }
  
  public static String NF(String paramString)
  {
    AppMethodBeat.i(44899);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44899);
      return null;
    }
    paramString = j.aYP().e(paramString, new String[] { "nickname" });
    if (paramString == null)
    {
      AppMethodBeat.o(44899);
      return null;
    }
    paramString = paramString.field_nickname;
    AppMethodBeat.o(44899);
    return paramString;
  }
  
  public static String NG(String paramString)
  {
    AppMethodBeat.i(44900);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44900);
      return null;
    }
    paramString = j.aYP().e(paramString, new String[] { "username" });
    if (paramString == null)
    {
      AppMethodBeat.o(44900);
      return null;
    }
    paramString = paramString.field_username;
    AppMethodBeat.o(44900);
    return paramString;
  }
  
  public static void NH(String paramString)
  {
    AppMethodBeat.i(44901);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44901);
      return;
    }
    w localw = j.aYP();
    if (!bt.isNullOrNil(paramString))
    {
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("syncVersion", "");
      localContentValues.put("syncTimeSecond", Long.valueOf(0L));
      localw.db.update(localw.getTableName(), localContentValues, String.format(Locale.US, "%s=?", new Object[] { "username" }), new String[] { paramString });
    }
    AppMethodBeat.o(44901);
  }
  
  public static void NI(String paramString)
  {
    AppMethodBeat.i(44902);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44902);
      return;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    j.aYP().delete(localWxaAttributes, new String[] { "username" });
    AppMethodBeat.o(44902);
  }
  
  /* Error */
  public static ab Ny(String paramString)
  {
    // Byte code:
    //   0: ldc 181
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 80	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +9 -> 18
    //   12: invokestatic 186	com/tencent/mm/kernel/g:ajx	()Z
    //   15: ifne +10 -> 25
    //   18: ldc 181
    //   20: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: invokestatic 28	com/tencent/mm/plugin/appbrand/app/j:aYP	()Lcom/tencent/mm/plugin/appbrand/config/w;
    //   28: aload_0
    //   29: bipush 9
    //   31: anewarray 30	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc 96
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc 103
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: ldc 188
    //   48: aastore
    //   49: dup
    //   50: iconst_3
    //   51: ldc 190
    //   53: aastore
    //   54: dup
    //   55: iconst_4
    //   56: ldc 192
    //   58: aastore
    //   59: dup
    //   60: iconst_5
    //   61: ldc 194
    //   63: aastore
    //   64: dup
    //   65: bipush 6
    //   67: ldc 32
    //   69: aastore
    //   70: dup
    //   71: bipush 7
    //   73: ldc 196
    //   75: aastore
    //   76: dup
    //   77: bipush 8
    //   79: ldc 198
    //   81: aastore
    //   82: invokevirtual 38	com/tencent/mm/plugin/appbrand/config/w:d	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +223 -> 310
    //   90: new 200	com/tencent/mm/plugin/appbrand/config/ab
    //   93: dup
    //   94: invokespecial 201	com/tencent/mm/plugin/appbrand/config/ab:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: aload_0
    //   100: putfield 203	com/tencent/mm/plugin/appbrand/config/ab:username	Ljava/lang/String;
    //   103: aload_2
    //   104: aload_3
    //   105: getfield 99	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   108: putfield 205	com/tencent/mm/plugin/appbrand/config/ab:appId	Ljava/lang/String;
    //   111: aload_2
    //   112: aload_3
    //   113: getfield 106	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_nickname	Ljava/lang/String;
    //   116: putfield 207	com/tencent/mm/plugin/appbrand/config/ab:nickname	Ljava/lang/String;
    //   119: aload_2
    //   120: aload_3
    //   121: getfield 210	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_signature	Ljava/lang/String;
    //   124: putfield 212	com/tencent/mm/plugin/appbrand/config/ab:signature	Ljava/lang/String;
    //   127: aload_2
    //   128: aload_3
    //   129: getfield 215	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_brandIconURL	Ljava/lang/String;
    //   132: putfield 218	com/tencent/mm/plugin/appbrand/config/ab:dtG	Ljava/lang/String;
    //   135: aload_2
    //   136: aload_3
    //   137: invokevirtual 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bem	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   140: getfield 228	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:jZI	Ljava/util/List;
    //   143: putfield 229	com/tencent/mm/plugin/appbrand/config/ab:jZI	Ljava/util/List;
    //   146: aload_3
    //   147: invokevirtual 233	com/tencent/mm/plugin/appbrand/config/WxaAttributes:ben	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   150: ifnonnull +104 -> 254
    //   153: iconst_m1
    //   154: istore_1
    //   155: aload_2
    //   156: iload_1
    //   157: putfield 237	com/tencent/mm/plugin/appbrand/config/ab:cmx	I
    //   160: aload_2
    //   161: aload_3
    //   162: invokevirtual 241	com/tencent/mm/plugin/appbrand/config/WxaAttributes:beo	()Ljava/util/List;
    //   165: putfield 244	com/tencent/mm/plugin/appbrand/config/ab:jZv	Ljava/util/List;
    //   168: aload_2
    //   169: aload_3
    //   170: invokevirtual 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bem	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   173: getfield 248	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:jZH	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   176: getfield 253	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:jXI	I
    //   179: putfield 254	com/tencent/mm/plugin/appbrand/config/ab:jXI	I
    //   182: aload_2
    //   183: aload_3
    //   184: invokevirtual 222	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bem	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   187: getfield 248	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:jZH	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   190: getfield 257	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:jXJ	I
    //   193: putfield 258	com/tencent/mm/plugin/appbrand/config/ab:jXJ	I
    //   196: aload_2
    //   197: aload_3
    //   198: invokevirtual 44	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bel	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   201: getfield 261	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:cQN	I
    //   204: putfield 264	com/tencent/mm/plugin/appbrand/config/ab:cmr	I
    //   207: aload_2
    //   208: aload_3
    //   209: invokevirtual 44	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bel	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   212: getfield 267	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:originalFlag	I
    //   215: putfield 268	com/tencent/mm/plugin/appbrand/config/ab:originalFlag	I
    //   218: aload_2
    //   219: aload_3
    //   220: invokevirtual 44	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bel	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   223: getfield 271	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:jXq	Ljava/lang/String;
    //   226: putfield 272	com/tencent/mm/plugin/appbrand/config/ab:jXq	Ljava/lang/String;
    //   229: aload_3
    //   230: getfield 275	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_registerSource	Ljava/lang/String;
    //   233: invokestatic 80	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   236: ifeq +51 -> 287
    //   239: ldc 124
    //   241: astore_0
    //   242: aload_2
    //   243: aload_0
    //   244: putfield 278	com/tencent/mm/plugin/appbrand/config/ab:cRw	Ljava/lang/String;
    //   247: ldc 181
    //   249: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_2
    //   253: areturn
    //   254: aload_3
    //   255: invokevirtual 233	com/tencent/mm/plugin/appbrand/config/WxaAttributes:ben	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   258: getfield 281	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:cmx	I
    //   261: istore_1
    //   262: goto -107 -> 155
    //   265: astore 4
    //   267: ldc_w 283
    //   270: ldc_w 285
    //   273: iconst_1
    //   274: anewarray 157	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: aload_0
    //   280: aastore
    //   281: invokestatic 290	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   284: goto -55 -> 229
    //   287: new 292	org/json/JSONObject
    //   290: dup
    //   291: aload_3
    //   292: getfield 275	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_registerSource	Ljava/lang/String;
    //   295: invokespecial 294	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   298: ldc_w 296
    //   301: ldc 124
    //   303: invokevirtual 300	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   306: astore_0
    //   307: goto -65 -> 242
    //   310: ldc 181
    //   312: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: aconst_null
    //   316: areturn
    //   317: astore_0
    //   318: goto -71 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	paramString	String
    //   154	108	1	i	int
    //   97	156	2	localab	ab
    //   85	207	3	localWxaAttributes	WxaAttributes
    //   265	1	4	localNullPointerException	NullPointerException
    // Exception table:
    //   from	to	target	type
    //   196	229	265	java/lang/NullPointerException
    //   229	239	317	java/lang/Exception
    //   242	247	317	java/lang/Exception
    //   287	307	317	java/lang/Exception
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.a Nz(String paramString)
  {
    AppMethodBeat.i(44891);
    if (j.aYP() != null)
    {
      paramString = j.aYP().d(paramString, new String[0]);
      if (paramString != null)
      {
        com.tencent.mm.plugin.appbrand.backgroundfetch.a locala = new com.tencent.mm.plugin.appbrand.backgroundfetch.a();
        locala.jRu = paramString.bem().jZH.jRu;
        locala.jRv = paramString.bem().jZH.jRv;
        locala.jRw = paramString.bem().jZH.jRw;
        locala.jRx = paramString.bem().jZH.jRx;
        AppMethodBeat.o(44891);
        return locala;
      }
    }
    AppMethodBeat.o(44891);
    return null;
  }
  
  public static AppBrandRecentTaskInfo a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44890);
    paramString1 = a(paramString1, paramString2, paramInt, paramLong, false, "");
    AppMethodBeat.o(44890);
    return paramString1;
  }
  
  public static AppBrandRecentTaskInfo a(String paramString1, String paramString2, int paramInt, long paramLong, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(188103);
    Object localObject = j.aYP();
    if ((localObject == null) || (!((u)localObject).beh()))
    {
      ad.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo invalid storage with username(%s)", new Object[] { paramString2 });
      AppMethodBeat.o(188103);
      return null;
    }
    WxaAttributes localWxaAttributes = ((u)localObject).d(paramString2, new String[] { "appId", "nickname", "shortNickname", "smallHeadURL", "appInfo", "versionInfo", "dynamicInfo" });
    int j = 0;
    int i;
    if (localWxaAttributes == null)
    {
      i = 0;
      j = i;
      label115:
      i = 0;
      if (localWxaAttributes != null) {
        break label386;
      }
      i = 0;
    }
    for (;;)
    {
      long l2 = 0L;
      long l1;
      if (localWxaAttributes == null)
      {
        l1 = 0L;
        l2 = l1;
      }
      for (;;)
      {
        long l3 = 0L;
        l1 = l3;
        if (j.a.rQ(paramInt))
        {
          if (localWxaAttributes != null) {
            break label416;
          }
          l1 = 0L;
        }
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.appusage.u localu = (com.tencent.mm.plugin.appbrand.appusage.u)j.T(com.tencent.mm.plugin.appbrand.appusage.u.class);
          if (localu == null) {
            ad.w("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo by username(%s) but NULL starAppStorage, maybe account released", new Object[] { paramString2 });
          }
          String str4 = String.valueOf(paramString1);
          label210:
          label219:
          String str2;
          label228:
          String str3;
          label237:
          boolean bool1;
          label255:
          boolean bool2;
          if (localWxaAttributes == null)
          {
            paramString1 = "";
            if (localWxaAttributes != null) {
              break label438;
            }
            localObject = "";
            if (localWxaAttributes != null) {
              break label448;
            }
            str2 = "";
            if (localWxaAttributes != null) {
              break label458;
            }
            str3 = "";
            if ((localu == null) || (!localu.bb(paramString2, paramInt))) {
              break label468;
            }
            bool1 = true;
            if ((localWxaAttributes == null) || (!c.gA(localWxaAttributes.bem().jZH.jXI))) {
              break label474;
            }
            bool2 = true;
            label280:
            if ((localWxaAttributes == null) || (!c.gz(localWxaAttributes.bem().jZH.jXJ))) {
              break label480;
            }
          }
          for (boolean bool3 = true;; bool3 = false)
          {
            for (;;)
            {
              for (;;)
              {
                paramString1 = new AppBrandRecentTaskInfo(str4, paramString2, paramString1, (String)localObject, str2, str3, j, paramInt, i, l2, l1, bool1, paramLong, bool2, paramBoolean, paramString3, bool3);
                AppMethodBeat.o(188103);
                return paramString1;
                try
                {
                  i = localWxaAttributes.bel().cQN;
                }
                catch (NullPointerException localNullPointerException1)
                {
                  ad.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo, NULL appInfo, username = %s", new Object[] { paramString2 });
                }
              }
              break label115;
              for (;;)
              {
                for (;;)
                {
                  label386:
                  label416:
                  label438:
                  String str1;
                  label448:
                  label458:
                  label468:
                  label474:
                  label480:
                  try
                  {
                    int k = localWxaAttributes.ben().aDD;
                    i = k;
                  }
                  catch (NullPointerException localNullPointerException4) {}
                  try
                  {
                    l1 = localWxaAttributes.bel().cnh;
                  }
                  catch (NullPointerException localNullPointerException3) {}
                }
                try
                {
                  l1 = localWxaAttributes.bel().jQb;
                }
                catch (NullPointerException localNullPointerException2)
                {
                  l1 = l3;
                }
              }
            }
            paramString1 = localWxaAttributes.field_appId;
            break label210;
            str1 = localWxaAttributes.field_nickname;
            break label219;
            str2 = localWxaAttributes.field_shortNickname;
            break label228;
            str3 = localWxaAttributes.field_smallHeadURL;
            break label237;
            bool1 = false;
            break label255;
            bool2 = false;
            break label280;
          }
        }
      }
    }
  }
  
  public static v bej()
  {
    AppMethodBeat.i(44883);
    Object localObject1;
    if (j.aYP() == null)
    {
      localObject1 = new com.tencent.mm.model.b();
      AppMethodBeat.o(44883);
      throw ((Throwable)localObject1);
    }
    if (jYW == null) {}
    try
    {
      if (jYW == null) {
        jYW = new v();
      }
      localObject1 = jYW;
      AppMethodBeat.o(44883);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(44883);
    }
  }
  
  private static AppBrandSysConfigWC e(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(44895);
    if (paramWxaAttributes != null) {}
    for (;;)
    {
      try
      {
        localObject = (AppBrandSysConfigLU)new av.a() {}.newInstance();
        ((AppBrandSysConfigLU)localObject).doD = paramWxaAttributes.field_nickname;
        ((AppBrandSysConfigLU)localObject).iAa = paramWxaAttributes.field_smallHeadURL;
        ((AppBrandSysConfigLU)localObject).appId = paramWxaAttributes.field_appId;
        ((AppBrandSysConfigLU)localObject).jYa = paramWxaAttributes.bem().jZH.jYa;
        ((AppBrandSysConfigLU)localObject).cmL = paramWxaAttributes.bem().jZH.cmL;
        ((AppBrandSysConfigLU)localObject).cmO = paramWxaAttributes.bem().jZH.cmO;
        ((AppBrandSysConfigLU)localObject).cmP = paramWxaAttributes.bem().jZH.cmP;
        ((AppBrandSysConfigLU)localObject).cmQ = paramWxaAttributes.bem().jZH.cmQ;
        ((AppBrandSysConfigLU)localObject).cmR = paramWxaAttributes.bem().jZH.cmR;
        ((AppBrandSysConfigLU)localObject).cmS = paramWxaAttributes.bem().jZH.cmS;
        ((AppBrandSysConfigLU)localObject).cmN = paramWxaAttributes.bem().jZH.cmN;
        ((AppBrandSysConfigLU)localObject).cmM = paramWxaAttributes.bem().jZH.cmM;
        ((AppBrandSysConfigLU)localObject).cmT = paramWxaAttributes.bem().jZH.jZL;
        ((AppBrandSysConfigLU)localObject).cmU = paramWxaAttributes.bem().jZH.jZM;
        ((AppBrandSysConfigLU)localObject).cmV = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.bel().jZz));
        ((AppBrandSysConfigLU)localObject).cmW = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.bel().jZA));
        ((AppBrandSysConfigLU)localObject).cmY = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.bel().jZC));
        ((AppBrandSysConfigLU)localObject).cmX = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.bel().jZB));
        ((AppBrandSysConfigLU)localObject).cmZ = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.bel().jZD));
        ((AppBrandSysConfigLU)localObject).cnh = paramWxaAttributes.bel().cnh;
        ((AppBrandSysConfigLU)localObject).jYf = paramWxaAttributes.bem().jZH.jYf;
        ((AppBrandSysConfigLU)localObject).jYg = paramWxaAttributes.bem().jZH.jYg;
        ((AppBrandSysConfigLU)localObject).cna = paramWxaAttributes.bem().jZH.cna;
        ((AppBrandSysConfigLU)localObject).cng = new String[] { paramWxaAttributes.field_roundedSquareIconURL, paramWxaAttributes.field_brandIconURL, paramWxaAttributes.field_bigHeadURL };
        ((AppBrandSysConfigLU)localObject).cnc = paramWxaAttributes.bem().jZH.cnc;
        ((AppBrandSysConfigLU)localObject).cnd = paramWxaAttributes.bem().jZH.jZJ;
        ((AppBrandSysConfigLU)localObject).cmE = l.Nn(((AppBrandSysConfigLU)localObject).appId);
        localObject = (AppBrandSysConfigWC)localObject;
        if (localObject != null)
        {
          ((AppBrandSysConfigWC)localObject).cnb = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getInt("ClientBenchmarkLevel", -1);
          ((AppBrandSysConfigWC)localObject).cmF = "1".equals(j.Ej().get(((AppBrandSysConfigWC)localObject).appId + "_PerformancePanelEnabled", "0"));
          ((AppBrandSysConfigWC)localObject).jXI = paramWxaAttributes.bem().jZH.jXI;
          ((AppBrandSysConfigWC)localObject).jXJ = paramWxaAttributes.bem().jZH.jXJ;
        }
        AppMethodBeat.o(44895);
        return localObject;
      }
      catch (Exception paramWxaAttributes)
      {
        ad.e("MicroMsg.WxaAttrStorageHelper", "assembleSysConfig, <init> e = %s", new Object[] { paramWxaAttributes });
        AppMethodBeat.o(44895);
        return null;
      }
      Object localObject = null;
    }
  }
  
  public static boolean j(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44888);
    paramBoolean = j.aYP().j(paramString, paramInt, paramBoolean);
    AppMethodBeat.o(44888);
    return paramBoolean;
  }
  
  public static void release()
  {
    try
    {
      jYW = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.v
 * JD-Core Version:    0.7.0.1
 */