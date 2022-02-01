package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.config.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.aw.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Locale;

public final class v
  extends q
{
  private static volatile v kcn;
  
  /* Error */
  public static ab Og(String paramString)
  {
    // Byte code:
    //   0: ldc 20
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 32	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +9 -> 18
    //   12: invokestatic 38	com/tencent/mm/kernel/g:ajM	()Z
    //   15: ifne +10 -> 25
    //   18: ldc 20
    //   20: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: invokestatic 47	com/tencent/mm/plugin/appbrand/app/j:aZl	()Lcom/tencent/mm/plugin/appbrand/config/w;
    //   28: aload_0
    //   29: bipush 9
    //   31: anewarray 49	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc 51
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc 53
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: ldc 55
    //   48: aastore
    //   49: dup
    //   50: iconst_3
    //   51: ldc 57
    //   53: aastore
    //   54: dup
    //   55: iconst_4
    //   56: ldc 59
    //   58: aastore
    //   59: dup
    //   60: iconst_5
    //   61: ldc 61
    //   63: aastore
    //   64: dup
    //   65: bipush 6
    //   67: ldc 63
    //   69: aastore
    //   70: dup
    //   71: bipush 7
    //   73: ldc 65
    //   75: aastore
    //   76: dup
    //   77: bipush 8
    //   79: ldc 67
    //   81: aastore
    //   82: invokevirtual 73	com/tencent/mm/plugin/appbrand/config/w:d	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +220 -> 307
    //   90: new 75	com/tencent/mm/plugin/appbrand/config/ab
    //   93: dup
    //   94: invokespecial 76	com/tencent/mm/plugin/appbrand/config/ab:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: aload_0
    //   100: putfield 80	com/tencent/mm/plugin/appbrand/config/ab:username	Ljava/lang/String;
    //   103: aload_2
    //   104: aload_3
    //   105: getfield 85	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   108: putfield 87	com/tencent/mm/plugin/appbrand/config/ab:appId	Ljava/lang/String;
    //   111: aload_2
    //   112: aload_3
    //   113: getfield 90	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_nickname	Ljava/lang/String;
    //   116: putfield 92	com/tencent/mm/plugin/appbrand/config/ab:nickname	Ljava/lang/String;
    //   119: aload_2
    //   120: aload_3
    //   121: getfield 95	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_signature	Ljava/lang/String;
    //   124: putfield 97	com/tencent/mm/plugin/appbrand/config/ab:signature	Ljava/lang/String;
    //   127: aload_2
    //   128: aload_3
    //   129: getfield 100	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_brandIconURL	Ljava/lang/String;
    //   132: putfield 103	com/tencent/mm/plugin/appbrand/config/ab:duL	Ljava/lang/String;
    //   135: aload_2
    //   136: aload_3
    //   137: invokevirtual 107	com/tencent/mm/plugin/appbrand/config/WxaAttributes:beU	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   140: getfield 113	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:kcZ	Ljava/util/List;
    //   143: putfield 114	com/tencent/mm/plugin/appbrand/config/ab:kcZ	Ljava/util/List;
    //   146: aload_3
    //   147: invokevirtual 118	com/tencent/mm/plugin/appbrand/config/WxaAttributes:beV	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   150: ifnonnull +104 -> 254
    //   153: iconst_m1
    //   154: istore_1
    //   155: aload_2
    //   156: iload_1
    //   157: putfield 122	com/tencent/mm/plugin/appbrand/config/ab:cmz	I
    //   160: aload_2
    //   161: aload_3
    //   162: invokevirtual 126	com/tencent/mm/plugin/appbrand/config/WxaAttributes:beW	()Ljava/util/List;
    //   165: putfield 129	com/tencent/mm/plugin/appbrand/config/ab:kcM	Ljava/util/List;
    //   168: aload_2
    //   169: aload_3
    //   170: invokevirtual 107	com/tencent/mm/plugin/appbrand/config/WxaAttributes:beU	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   173: getfield 133	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:kcY	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   176: getfield 138	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:kaX	I
    //   179: putfield 139	com/tencent/mm/plugin/appbrand/config/ab:kaX	I
    //   182: aload_2
    //   183: aload_3
    //   184: invokevirtual 107	com/tencent/mm/plugin/appbrand/config/WxaAttributes:beU	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   187: getfield 133	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:kcY	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   190: getfield 142	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:kaY	I
    //   193: putfield 143	com/tencent/mm/plugin/appbrand/config/ab:kaY	I
    //   196: aload_2
    //   197: aload_3
    //   198: invokevirtual 147	com/tencent/mm/plugin/appbrand/config/WxaAttributes:beT	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   201: getfield 152	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:cRx	I
    //   204: putfield 155	com/tencent/mm/plugin/appbrand/config/ab:cmt	I
    //   207: aload_2
    //   208: aload_3
    //   209: invokevirtual 147	com/tencent/mm/plugin/appbrand/config/WxaAttributes:beT	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   212: getfield 158	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:originalFlag	I
    //   215: putfield 159	com/tencent/mm/plugin/appbrand/config/ab:originalFlag	I
    //   218: aload_2
    //   219: aload_3
    //   220: invokevirtual 147	com/tencent/mm/plugin/appbrand/config/WxaAttributes:beT	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   223: getfield 162	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:kaF	Ljava/lang/String;
    //   226: putfield 163	com/tencent/mm/plugin/appbrand/config/ab:kaF	Ljava/lang/String;
    //   229: aload_3
    //   230: getfield 166	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_registerSource	Ljava/lang/String;
    //   233: invokestatic 32	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   236: ifeq +49 -> 285
    //   239: ldc 168
    //   241: astore_0
    //   242: aload_2
    //   243: aload_0
    //   244: putfield 171	com/tencent/mm/plugin/appbrand/config/ab:cSg	Ljava/lang/String;
    //   247: ldc 20
    //   249: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_2
    //   253: areturn
    //   254: aload_3
    //   255: invokevirtual 118	com/tencent/mm/plugin/appbrand/config/WxaAttributes:beV	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   258: getfield 174	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:cmz	I
    //   261: istore_1
    //   262: goto -107 -> 155
    //   265: astore 4
    //   267: ldc 176
    //   269: ldc 178
    //   271: iconst_1
    //   272: anewarray 180	java/lang/Object
    //   275: dup
    //   276: iconst_0
    //   277: aload_0
    //   278: aastore
    //   279: invokestatic 186	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: goto -53 -> 229
    //   285: new 188	org/json/JSONObject
    //   288: dup
    //   289: aload_3
    //   290: getfield 166	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_registerSource	Ljava/lang/String;
    //   293: invokespecial 191	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   296: ldc 193
    //   298: ldc 168
    //   300: invokevirtual 197	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   303: astore_0
    //   304: goto -62 -> 242
    //   307: ldc 20
    //   309: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: aconst_null
    //   313: areturn
    //   314: astore_0
    //   315: goto -68 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	paramString	String
    //   154	108	1	i	int
    //   97	156	2	localab	ab
    //   85	205	3	localWxaAttributes	WxaAttributes
    //   265	1	4	localNullPointerException	NullPointerException
    // Exception table:
    //   from	to	target	type
    //   196	229	265	java/lang/NullPointerException
    //   229	239	314	java/lang/Exception
    //   242	247	314	java/lang/Exception
    //   285	304	314	java/lang/Exception
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.a Oh(String paramString)
  {
    AppMethodBeat.i(44891);
    if (j.aZl() != null)
    {
      paramString = j.aZl().d(paramString, new String[0]);
      if (paramString != null)
      {
        com.tencent.mm.plugin.appbrand.backgroundfetch.a locala = new com.tencent.mm.plugin.appbrand.backgroundfetch.a();
        locala.jUM = paramString.beU().kcY.jUM;
        locala.jUN = paramString.beU().kcY.jUN;
        locala.jUO = paramString.beU().kcY.jUO;
        locala.jUP = paramString.beU().kcY.jUP;
        AppMethodBeat.o(44891);
        return locala;
      }
    }
    AppMethodBeat.o(44891);
    return null;
  }
  
  public static boolean Oi(String paramString)
  {
    AppMethodBeat.i(44893);
    if (j.aZl() != null)
    {
      paramString = j.aZl().d(paramString, new String[] { "appInfo" });
      if (paramString != null)
      {
        if ((paramString.beT() != null) && (paramString.beT().beZ()))
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
  
  public static AppBrandSysConfigWC Oj(String paramString)
  {
    AppMethodBeat.i(44894);
    paramString = j.aZl().e(paramString, new String[0]);
    if (paramString != null)
    {
      paramString = e(paramString);
      AppMethodBeat.o(44894);
      return paramString;
    }
    AppMethodBeat.o(44894);
    return null;
  }
  
  public static long Ok(String paramString)
  {
    AppMethodBeat.i(44896);
    paramString = j.aZl().d(paramString, new String[] { "appInfo" });
    if ((paramString == null) || (paramString.beT() == null))
    {
      AppMethodBeat.o(44896);
      return 0L;
    }
    long l = paramString.beT().cnj;
    AppMethodBeat.o(44896);
    return l;
  }
  
  public static String[] Ol(String paramString)
  {
    AppMethodBeat.i(44897);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44897);
      return null;
    }
    Object localObject = j.aZl().d(paramString, new String[] { "roundedSquareIconURL", "bigHeadURL" });
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
  
  public static String Om(String paramString)
  {
    AppMethodBeat.i(44898);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44898);
      return null;
    }
    paramString = j.aZl().d(paramString, new String[] { "appId" });
    if (paramString == null)
    {
      AppMethodBeat.o(44898);
      return null;
    }
    paramString = paramString.field_appId;
    AppMethodBeat.o(44898);
    return paramString;
  }
  
  public static String On(String paramString)
  {
    AppMethodBeat.i(44899);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44899);
      return null;
    }
    paramString = j.aZl().e(paramString, new String[] { "nickname" });
    if (paramString == null)
    {
      AppMethodBeat.o(44899);
      return null;
    }
    paramString = paramString.field_nickname;
    AppMethodBeat.o(44899);
    return paramString;
  }
  
  public static String Oo(String paramString)
  {
    AppMethodBeat.i(44900);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44900);
      return null;
    }
    paramString = j.aZl().e(paramString, new String[] { "username" });
    if (paramString == null)
    {
      AppMethodBeat.o(44900);
      return null;
    }
    paramString = paramString.field_username;
    AppMethodBeat.o(44900);
    return paramString;
  }
  
  public static void Op(String paramString)
  {
    AppMethodBeat.i(44901);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44901);
      return;
    }
    w localw = j.aZl();
    if (!bu.isNullOrNil(paramString))
    {
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("syncVersion", "");
      localContentValues.put("syncTimeSecond", Long.valueOf(0L));
      localw.db.update(localw.getTableName(), localContentValues, String.format(Locale.US, "%s=?", new Object[] { "username" }), new String[] { paramString });
    }
    AppMethodBeat.o(44901);
  }
  
  public static void Oq(String paramString)
  {
    AppMethodBeat.i(44902);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44902);
      return;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    j.aZl().delete(localWxaAttributes, new String[] { "username" });
    AppMethodBeat.o(44902);
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
    AppMethodBeat.i(222227);
    Object localObject = j.aZl();
    if ((localObject == null) || (!((u)localObject).beO()))
    {
      ae.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo invalid storage with username(%s)", new Object[] { paramString2 });
      AppMethodBeat.o(222227);
      return null;
    }
    WxaAttributes localWxaAttributes = ((u)localObject).d(paramString2, new String[] { "appId", "nickname", "shortNickname", "smallHeadURL", "appInfo", "versionInfo", "dynamicInfo" });
    int j = 0;
    int i;
    if (localWxaAttributes == null)
    {
      i = 0;
      j = i;
      label114:
      i = 0;
      if (localWxaAttributes != null) {
        break label383;
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
        if (j.a.rT(paramInt))
        {
          if (localWxaAttributes != null) {
            break label413;
          }
          l1 = 0L;
        }
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.appusage.u localu = (com.tencent.mm.plugin.appbrand.appusage.u)j.T(com.tencent.mm.plugin.appbrand.appusage.u.class);
          if (localu == null) {
            ae.w("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo by username(%s) but NULL starAppStorage, maybe account released", new Object[] { paramString2 });
          }
          String str4 = String.valueOf(paramString1);
          label208:
          label217:
          String str2;
          label226:
          String str3;
          label235:
          boolean bool1;
          label253:
          boolean bool2;
          if (localWxaAttributes == null)
          {
            paramString1 = "";
            if (localWxaAttributes != null) {
              break label435;
            }
            localObject = "";
            if (localWxaAttributes != null) {
              break label445;
            }
            str2 = "";
            if (localWxaAttributes != null) {
              break label455;
            }
            str3 = "";
            if ((localu == null) || (!localu.be(paramString2, paramInt))) {
              break label465;
            }
            bool1 = true;
            if ((localWxaAttributes == null) || (!c.gA(localWxaAttributes.beU().kcY.kaX))) {
              break label471;
            }
            bool2 = true;
            label278:
            if ((localWxaAttributes == null) || (!c.gz(localWxaAttributes.beU().kcY.kaY))) {
              break label477;
            }
          }
          for (boolean bool3 = true;; bool3 = false)
          {
            for (;;)
            {
              for (;;)
              {
                paramString1 = new AppBrandRecentTaskInfo(str4, paramString2, paramString1, (String)localObject, str2, str3, j, paramInt, i, l2, l1, bool1, paramLong, bool2, paramBoolean, paramString3, bool3);
                AppMethodBeat.o(222227);
                return paramString1;
                try
                {
                  i = localWxaAttributes.beT().cRx;
                }
                catch (NullPointerException localNullPointerException1)
                {
                  ae.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo, NULL appInfo, username = %s", new Object[] { paramString2 });
                }
              }
              break label114;
              for (;;)
              {
                for (;;)
                {
                  label383:
                  String str1;
                  label413:
                  label435:
                  label445:
                  label455:
                  label465:
                  label471:
                  label477:
                  try
                  {
                    int k = localWxaAttributes.beV().aDD;
                    i = k;
                  }
                  catch (NullPointerException localNullPointerException4) {}
                  try
                  {
                    l1 = localWxaAttributes.beT().cnj;
                  }
                  catch (NullPointerException localNullPointerException3) {}
                }
                try
                {
                  l1 = localWxaAttributes.beT().jTt;
                }
                catch (NullPointerException localNullPointerException2)
                {
                  l1 = l3;
                }
              }
            }
            paramString1 = localWxaAttributes.field_appId;
            break label208;
            str1 = localWxaAttributes.field_nickname;
            break label217;
            str2 = localWxaAttributes.field_shortNickname;
            break label226;
            str3 = localWxaAttributes.field_smallHeadURL;
            break label235;
            bool1 = false;
            break label253;
            bool2 = false;
            break label278;
          }
        }
      }
    }
  }
  
  public static v beQ()
  {
    AppMethodBeat.i(44883);
    Object localObject1;
    if (j.aZl() == null)
    {
      localObject1 = new com.tencent.mm.model.b();
      AppMethodBeat.o(44883);
      throw ((Throwable)localObject1);
    }
    if (kcn == null) {}
    try
    {
      if (kcn == null) {
        kcn = new v();
      }
      localObject1 = kcn;
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
        localObject = (AppBrandSysConfigLU)new aw.a() {}.newInstance();
        ((AppBrandSysConfigLU)localObject).dpI = paramWxaAttributes.field_nickname;
        ((AppBrandSysConfigLU)localObject).iCT = paramWxaAttributes.field_smallHeadURL;
        ((AppBrandSysConfigLU)localObject).appId = paramWxaAttributes.field_appId;
        ((AppBrandSysConfigLU)localObject).kbp = paramWxaAttributes.beU().kcY.kbp;
        ((AppBrandSysConfigLU)localObject).cmN = paramWxaAttributes.beU().kcY.cmN;
        ((AppBrandSysConfigLU)localObject).cmQ = paramWxaAttributes.beU().kcY.cmQ;
        ((AppBrandSysConfigLU)localObject).cmR = paramWxaAttributes.beU().kcY.cmR;
        ((AppBrandSysConfigLU)localObject).cmS = paramWxaAttributes.beU().kcY.cmS;
        ((AppBrandSysConfigLU)localObject).cmT = paramWxaAttributes.beU().kcY.cmT;
        ((AppBrandSysConfigLU)localObject).cmU = paramWxaAttributes.beU().kcY.cmU;
        ((AppBrandSysConfigLU)localObject).cmP = paramWxaAttributes.beU().kcY.cmP;
        ((AppBrandSysConfigLU)localObject).cmO = paramWxaAttributes.beU().kcY.cmO;
        ((AppBrandSysConfigLU)localObject).cmV = paramWxaAttributes.beU().kcY.kdc;
        ((AppBrandSysConfigLU)localObject).cmW = paramWxaAttributes.beU().kcY.kdd;
        ((AppBrandSysConfigLU)localObject).cmX = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.beT().kcQ));
        ((AppBrandSysConfigLU)localObject).cmY = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.beT().kcR));
        ((AppBrandSysConfigLU)localObject).cna = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.beT().kcT));
        ((AppBrandSysConfigLU)localObject).cmZ = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.beT().kcS));
        ((AppBrandSysConfigLU)localObject).cnb = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.beT().kcU));
        ((AppBrandSysConfigLU)localObject).cnj = paramWxaAttributes.beT().cnj;
        ((AppBrandSysConfigLU)localObject).kbu = paramWxaAttributes.beU().kcY.kbu;
        ((AppBrandSysConfigLU)localObject).kbv = paramWxaAttributes.beU().kcY.kbv;
        ((AppBrandSysConfigLU)localObject).cnc = paramWxaAttributes.beU().kcY.cnc;
        ((AppBrandSysConfigLU)localObject).cni = new String[] { paramWxaAttributes.field_roundedSquareIconURL, paramWxaAttributes.field_brandIconURL, paramWxaAttributes.field_bigHeadURL };
        ((AppBrandSysConfigLU)localObject).cne = paramWxaAttributes.beU().kcY.cne;
        ((AppBrandSysConfigLU)localObject).cnf = paramWxaAttributes.beU().kcY.kda;
        ((AppBrandSysConfigLU)localObject).cmG = l.NU(((AppBrandSysConfigLU)localObject).appId);
        localObject = (AppBrandSysConfigWC)localObject;
        if (localObject != null)
        {
          ((AppBrandSysConfigWC)localObject).cnd = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("ClientBenchmarkLevel", -1);
          ((AppBrandSysConfigWC)localObject).cmH = "1".equals(j.Em().get(((AppBrandSysConfigWC)localObject).appId + "_PerformancePanelEnabled", "0"));
          ((AppBrandSysConfigWC)localObject).kaX = paramWxaAttributes.beU().kcY.kaX;
          ((AppBrandSysConfigWC)localObject).kaY = paramWxaAttributes.beU().kcY.kaY;
        }
        AppMethodBeat.o(44895);
        return localObject;
      }
      catch (Exception paramWxaAttributes)
      {
        ae.e("MicroMsg.WxaAttrStorageHelper", "assembleSysConfig, <init> e = %s", new Object[] { paramWxaAttributes });
        AppMethodBeat.o(44895);
        return null;
      }
      Object localObject = null;
    }
  }
  
  public static boolean j(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44888);
    paramBoolean = j.aZl().j(paramString, paramInt, paramBoolean);
    AppMethodBeat.o(44888);
    return paramBoolean;
  }
  
  public static void release()
  {
    try
    {
      kcn = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.v
 * JD-Core Version:    0.7.0.1
 */