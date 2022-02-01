package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.au.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Locale;

public final class u
  extends q
{
  private static volatile u jeD;
  
  /* Error */
  public static aa Gb(String paramString)
  {
    // Byte code:
    //   0: ldc 20
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 32	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +9 -> 18
    //   12: invokestatic 38	com/tencent/mm/kernel/g:afw	()Z
    //   15: ifne +10 -> 25
    //   18: ldc 20
    //   20: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: invokestatic 47	com/tencent/mm/plugin/appbrand/app/j:aOC	()Lcom/tencent/mm/plugin/appbrand/config/v;
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
    //   82: invokevirtual 73	com/tencent/mm/plugin/appbrand/config/v:d	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +206 -> 293
    //   90: new 75	com/tencent/mm/plugin/appbrand/config/aa
    //   93: dup
    //   94: invokespecial 76	com/tencent/mm/plugin/appbrand/config/aa:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: aload_0
    //   100: putfield 80	com/tencent/mm/plugin/appbrand/config/aa:username	Ljava/lang/String;
    //   103: aload_2
    //   104: aload_3
    //   105: getfield 85	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   108: putfield 87	com/tencent/mm/plugin/appbrand/config/aa:appId	Ljava/lang/String;
    //   111: aload_2
    //   112: aload_3
    //   113: getfield 90	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_nickname	Ljava/lang/String;
    //   116: putfield 92	com/tencent/mm/plugin/appbrand/config/aa:nickname	Ljava/lang/String;
    //   119: aload_2
    //   120: aload_3
    //   121: getfield 95	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_signature	Ljava/lang/String;
    //   124: putfield 97	com/tencent/mm/plugin/appbrand/config/aa:signature	Ljava/lang/String;
    //   127: aload_2
    //   128: aload_3
    //   129: getfield 100	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_brandIconURL	Ljava/lang/String;
    //   132: putfield 103	com/tencent/mm/plugin/appbrand/config/aa:dkD	Ljava/lang/String;
    //   135: aload_2
    //   136: aload_3
    //   137: invokevirtual 107	com/tencent/mm/plugin/appbrand/config/WxaAttributes:aTO	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   140: getfield 113	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:jfo	Ljava/util/List;
    //   143: putfield 114	com/tencent/mm/plugin/appbrand/config/aa:jfo	Ljava/util/List;
    //   146: aload_3
    //   147: invokevirtual 118	com/tencent/mm/plugin/appbrand/config/WxaAttributes:aTP	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   150: ifnonnull +90 -> 240
    //   153: iconst_m1
    //   154: istore_1
    //   155: aload_2
    //   156: iload_1
    //   157: putfield 122	com/tencent/mm/plugin/appbrand/config/aa:cfk	I
    //   160: aload_2
    //   161: aload_3
    //   162: invokevirtual 126	com/tencent/mm/plugin/appbrand/config/WxaAttributes:aTQ	()Ljava/util/List;
    //   165: putfield 129	com/tencent/mm/plugin/appbrand/config/aa:jfb	Ljava/util/List;
    //   168: aload_2
    //   169: aload_3
    //   170: invokevirtual 107	com/tencent/mm/plugin/appbrand/config/WxaAttributes:aTO	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   173: getfield 133	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:jfn	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   176: getfield 138	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:cfU	I
    //   179: putfield 139	com/tencent/mm/plugin/appbrand/config/aa:cfU	I
    //   182: aload_2
    //   183: aload_3
    //   184: invokevirtual 143	com/tencent/mm/plugin/appbrand/config/WxaAttributes:aTN	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   187: getfield 148	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:cIB	I
    //   190: putfield 151	com/tencent/mm/plugin/appbrand/config/aa:cfd	I
    //   193: aload_2
    //   194: aload_3
    //   195: invokevirtual 143	com/tencent/mm/plugin/appbrand/config/WxaAttributes:aTN	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   198: getfield 154	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:originalFlag	I
    //   201: putfield 155	com/tencent/mm/plugin/appbrand/config/aa:originalFlag	I
    //   204: aload_2
    //   205: aload_3
    //   206: invokevirtual 143	com/tencent/mm/plugin/appbrand/config/WxaAttributes:aTN	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   209: getfield 158	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:jdh	Ljava/lang/String;
    //   212: putfield 159	com/tencent/mm/plugin/appbrand/config/aa:jdh	Ljava/lang/String;
    //   215: aload_3
    //   216: getfield 162	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_registerSource	Ljava/lang/String;
    //   219: invokestatic 32	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   222: ifeq +49 -> 271
    //   225: ldc 164
    //   227: astore_0
    //   228: aload_2
    //   229: aload_0
    //   230: putfield 167	com/tencent/mm/plugin/appbrand/config/aa:cJl	Ljava/lang/String;
    //   233: ldc 20
    //   235: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_2
    //   239: areturn
    //   240: aload_3
    //   241: invokevirtual 118	com/tencent/mm/plugin/appbrand/config/WxaAttributes:aTP	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   244: getfield 170	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:cfk	I
    //   247: istore_1
    //   248: goto -93 -> 155
    //   251: astore 4
    //   253: ldc 172
    //   255: ldc 174
    //   257: iconst_1
    //   258: anewarray 176	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: aload_0
    //   264: aastore
    //   265: invokestatic 182	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: goto -53 -> 215
    //   271: new 184	org/json/JSONObject
    //   274: dup
    //   275: aload_3
    //   276: getfield 162	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_registerSource	Ljava/lang/String;
    //   279: invokespecial 187	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   282: ldc 189
    //   284: ldc 164
    //   286: invokevirtual 193	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   289: astore_0
    //   290: goto -62 -> 228
    //   293: ldc 20
    //   295: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aconst_null
    //   299: areturn
    //   300: astore_0
    //   301: goto -68 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramString	String
    //   154	94	1	i	int
    //   97	142	2	localaa	aa
    //   85	191	3	localWxaAttributes	WxaAttributes
    //   251	1	4	localNullPointerException	NullPointerException
    // Exception table:
    //   from	to	target	type
    //   182	215	251	java/lang/NullPointerException
    //   215	225	300	java/lang/Exception
    //   228	233	300	java/lang/Exception
    //   271	290	300	java/lang/Exception
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.a Gc(String paramString)
  {
    AppMethodBeat.i(44891);
    if (j.aOC() != null)
    {
      paramString = j.aOC().d(paramString, new String[0]);
      if (paramString != null)
      {
        com.tencent.mm.plugin.appbrand.backgroundfetch.a locala = new com.tencent.mm.plugin.appbrand.backgroundfetch.a();
        locala.iXi = paramString.aTO().jfn.iXi;
        locala.iXj = paramString.aTO().jfn.iXj;
        locala.iXk = paramString.aTO().jfn.iXk;
        locala.iXl = paramString.aTO().jfn.iXl;
        AppMethodBeat.o(44891);
        return locala;
      }
    }
    AppMethodBeat.o(44891);
    return null;
  }
  
  public static boolean Gd(String paramString)
  {
    AppMethodBeat.i(44893);
    if (j.aOC() != null)
    {
      paramString = j.aOC().d(paramString, new String[] { "appInfo" });
      if (paramString != null)
      {
        if ((paramString.aTN() != null) && (paramString.aTN().aTT()))
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
  
  public static AppBrandSysConfigWC Ge(String paramString)
  {
    AppMethodBeat.i(44894);
    paramString = j.aOC().e(paramString, new String[0]);
    if (paramString != null)
    {
      paramString = d(paramString);
      AppMethodBeat.o(44894);
      return paramString;
    }
    AppMethodBeat.o(44894);
    return null;
  }
  
  public static long Gf(String paramString)
  {
    AppMethodBeat.i(44896);
    paramString = j.aOC().d(paramString, new String[] { "appInfo" });
    if ((paramString == null) || (paramString.aTN() == null))
    {
      AppMethodBeat.o(44896);
      return 0L;
    }
    long l = paramString.aTN().cfT;
    AppMethodBeat.o(44896);
    return l;
  }
  
  public static String[] Gg(String paramString)
  {
    AppMethodBeat.i(44897);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44897);
      return null;
    }
    Object localObject = j.aOC().d(paramString, new String[] { "roundedSquareIconURL", "bigHeadURL" });
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
  
  public static String Gh(String paramString)
  {
    AppMethodBeat.i(44898);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44898);
      return null;
    }
    paramString = j.aOC().d(paramString, new String[] { "appId" });
    if (paramString == null)
    {
      AppMethodBeat.o(44898);
      return null;
    }
    paramString = paramString.field_appId;
    AppMethodBeat.o(44898);
    return paramString;
  }
  
  public static String Gi(String paramString)
  {
    AppMethodBeat.i(44899);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44899);
      return null;
    }
    paramString = j.aOC().e(paramString, new String[] { "nickname" });
    if (paramString == null)
    {
      AppMethodBeat.o(44899);
      return null;
    }
    paramString = paramString.field_nickname;
    AppMethodBeat.o(44899);
    return paramString;
  }
  
  public static String Gj(String paramString)
  {
    AppMethodBeat.i(44900);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44900);
      return null;
    }
    paramString = j.aOC().e(paramString, new String[] { "username" });
    if (paramString == null)
    {
      AppMethodBeat.o(44900);
      return null;
    }
    paramString = paramString.field_username;
    AppMethodBeat.o(44900);
    return paramString;
  }
  
  public static void Gk(String paramString)
  {
    AppMethodBeat.i(44901);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44901);
      return;
    }
    v localv = j.aOC();
    if (!bt.isNullOrNil(paramString))
    {
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("syncVersion", "");
      localContentValues.put("syncTimeSecond", Long.valueOf(0L));
      localv.db.update("WxaAttributesTable", localContentValues, String.format(Locale.US, "%s=?", new Object[] { "username" }), new String[] { paramString });
    }
    AppMethodBeat.o(44901);
  }
  
  public static void Gl(String paramString)
  {
    AppMethodBeat.i(44902);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44902);
      return;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    j.aOC().delete(localWxaAttributes, new String[] { "username" });
    AppMethodBeat.o(44902);
  }
  
  public static AppBrandRecentTaskInfo a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44890);
    WxaAttributes localWxaAttributes = j.aOC().d(paramString2, new String[] { "appId", "nickname", "shortNickname", "smallHeadURL", "appInfo", "versionInfo", "dynamicInfo" });
    int j = 0;
    int i;
    if (localWxaAttributes == null)
    {
      i = 0;
      j = i;
      label73:
      i = 0;
      if (localWxaAttributes != null) {
        break label309;
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
        if (j.a.qD(paramInt))
        {
          if (localWxaAttributes != null) {
            break label339;
          }
          l1 = 0L;
        }
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.appusage.u localu = (com.tencent.mm.plugin.appbrand.appusage.u)j.T(com.tencent.mm.plugin.appbrand.appusage.u.class);
          if (localu == null) {
            ad.w("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo by username(%s) but NULL starAppStorage, maybe account released", new Object[] { paramString2 });
          }
          String str5 = String.valueOf(paramString1);
          label167:
          String str1;
          label176:
          String str3;
          label185:
          String str4;
          label194:
          boolean bool1;
          if (localWxaAttributes == null)
          {
            paramString1 = "";
            if (localWxaAttributes != null) {
              break label361;
            }
            str1 = "";
            if (localWxaAttributes != null) {
              break label371;
            }
            str3 = "";
            if (localWxaAttributes != null) {
              break label381;
            }
            str4 = "";
            if ((localu == null) || (!localu.aV(paramString2, paramInt))) {
              break label391;
            }
            bool1 = true;
            label212:
            if ((localWxaAttributes == null) || (localWxaAttributes.aTO().jfn.cfU != 1)) {
              break label397;
            }
          }
          for (boolean bool2 = true;; bool2 = false)
          {
            for (;;)
            {
              for (;;)
              {
                paramString1 = new AppBrandRecentTaskInfo(str5, paramString2, paramString1, str1, str3, str4, j, paramInt, i, l2, l1, bool1, paramLong, bool2);
                AppMethodBeat.o(44890);
                return paramString1;
                try
                {
                  i = localWxaAttributes.aTN().cIB;
                }
                catch (NullPointerException localNullPointerException1)
                {
                  ad.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo, NULL appInfo, username = %s", new Object[] { paramString2 });
                }
              }
              break label73;
              for (;;)
              {
                for (;;)
                {
                  label309:
                  label339:
                  label361:
                  String str2;
                  label371:
                  label381:
                  try
                  {
                    int k = localWxaAttributes.aTP().aAS;
                    i = k;
                  }
                  catch (NullPointerException localNullPointerException4) {}
                  label391:
                  label397:
                  try
                  {
                    l1 = localWxaAttributes.aTN().cfT;
                  }
                  catch (NullPointerException localNullPointerException3) {}
                }
                try
                {
                  l1 = localWxaAttributes.aTN().iVR;
                }
                catch (NullPointerException localNullPointerException2)
                {
                  l1 = l3;
                }
              }
            }
            paramString1 = localWxaAttributes.field_appId;
            break label167;
            str2 = localWxaAttributes.field_nickname;
            break label176;
            str3 = localWxaAttributes.field_shortNickname;
            break label185;
            str4 = localWxaAttributes.field_smallHeadURL;
            break label194;
            bool1 = false;
            break label212;
          }
        }
      }
    }
  }
  
  public static u aTL()
  {
    AppMethodBeat.i(44883);
    Object localObject1;
    if (j.aOC() == null)
    {
      localObject1 = new com.tencent.mm.model.b();
      AppMethodBeat.o(44883);
      throw ((Throwable)localObject1);
    }
    if (jeD == null) {}
    try
    {
      if (jeD == null) {
        jeD = new u();
      }
      localObject1 = jeD;
      AppMethodBeat.o(44883);
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(44883);
    }
  }
  
  private static AppBrandSysConfigWC d(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(44895);
    if (paramWxaAttributes != null) {}
    for (;;)
    {
      try
      {
        AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)new au.a() {}.newInstance();
        localAppBrandSysConfigLU.dfM = paramWxaAttributes.field_nickname;
        localAppBrandSysConfigLU.hGe = paramWxaAttributes.field_smallHeadURL;
        localAppBrandSysConfigLU.appId = paramWxaAttributes.field_appId;
        localAppBrandSysConfigLU.jdL = paramWxaAttributes.aTO().jfn.jdL;
        localAppBrandSysConfigLU.cfx = paramWxaAttributes.aTO().jfn.cfx;
        localAppBrandSysConfigLU.cfA = paramWxaAttributes.aTO().jfn.cfA;
        localAppBrandSysConfigLU.cfB = paramWxaAttributes.aTO().jfn.cfB;
        localAppBrandSysConfigLU.cfC = paramWxaAttributes.aTO().jfn.cfC;
        localAppBrandSysConfigLU.cfD = paramWxaAttributes.aTO().jfn.cfD;
        localAppBrandSysConfigLU.cfE = paramWxaAttributes.aTO().jfn.cfE;
        localAppBrandSysConfigLU.cfz = paramWxaAttributes.aTO().jfn.cfz;
        localAppBrandSysConfigLU.cfy = paramWxaAttributes.aTO().jfn.cfy;
        localAppBrandSysConfigLU.cfF = paramWxaAttributes.aTO().jfn.jfr;
        localAppBrandSysConfigLU.cfG = paramWxaAttributes.aTO().jfn.jfs;
        localAppBrandSysConfigLU.cfH = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.aTN().jff));
        localAppBrandSysConfigLU.cfI = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.aTN().jfg));
        localAppBrandSysConfigLU.cfK = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.aTN().jfi));
        localAppBrandSysConfigLU.cfJ = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.aTN().jfh));
        localAppBrandSysConfigLU.cfL = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.aTN().jfj));
        localAppBrandSysConfigLU.cfT = paramWxaAttributes.aTN().cfT;
        localAppBrandSysConfigLU.jdQ = paramWxaAttributes.aTO().jfn.jdQ;
        localAppBrandSysConfigLU.jdR = paramWxaAttributes.aTO().jfn.jdR;
        localAppBrandSysConfigLU.cfM = paramWxaAttributes.aTO().jfn.cfM;
        localAppBrandSysConfigLU.cfS = new String[] { paramWxaAttributes.field_roundedSquareIconURL, paramWxaAttributes.field_brandIconURL, paramWxaAttributes.field_bigHeadURL };
        localAppBrandSysConfigLU.cfO = paramWxaAttributes.aTO().jfn.cfO;
        localAppBrandSysConfigLU.cfP = paramWxaAttributes.aTO().jfn.jfp;
        localAppBrandSysConfigLU.cfq = l.FQ(localAppBrandSysConfigLU.appId);
        localAppBrandSysConfigLU.cfU = paramWxaAttributes.aTO().jfn.cfU;
        paramWxaAttributes = (AppBrandSysConfigWC)localAppBrandSysConfigLU;
        if (paramWxaAttributes != null)
        {
          paramWxaAttributes.cfN = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("ClientBenchmarkLevel", -1);
          paramWxaAttributes.cfr = "1".equals(j.Dh().get(paramWxaAttributes.appId + "_PerformancePanelEnabled", "0"));
        }
        AppMethodBeat.o(44895);
        return paramWxaAttributes;
      }
      catch (Exception paramWxaAttributes)
      {
        ad.e("MicroMsg.WxaAttrStorageHelper", "assembleSysConfig, <init> e = %s", new Object[] { paramWxaAttributes });
        AppMethodBeat.o(44895);
        return null;
      }
      paramWxaAttributes = null;
    }
  }
  
  public static boolean j(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44888);
    paramBoolean = j.aOC().j(paramString, paramInt, paramBoolean);
    AppMethodBeat.o(44888);
    return paramBoolean;
  }
  
  public static void release()
  {
    try
    {
      jeD = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.u
 * JD-Core Version:    0.7.0.1
 */