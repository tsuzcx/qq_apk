package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.bh.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Locale;

public final class y
  extends r
{
  private static volatile y lfS;
  
  public static void XA(String paramString)
  {
    AppMethodBeat.i(44902);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44902);
      return;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    n.buC().delete(localWxaAttributes, new String[] { "username" });
    AppMethodBeat.o(44902);
  }
  
  /* Error */
  public static ae Xr(String paramString)
  {
    // Byte code:
    //   0: ldc 61
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 28	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +9 -> 18
    //   12: invokestatic 67	com/tencent/mm/kernel/g:aAc	()Z
    //   15: ifne +10 -> 25
    //   18: ldc 61
    //   20: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: invokestatic 44	com/tencent/mm/plugin/appbrand/app/n:buC	()Lcom/tencent/mm/plugin/appbrand/config/z;
    //   28: aload_0
    //   29: bipush 9
    //   31: anewarray 46	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc 69
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc 71
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: ldc 73
    //   48: aastore
    //   49: dup
    //   50: iconst_3
    //   51: ldc 75
    //   53: aastore
    //   54: dup
    //   55: iconst_4
    //   56: ldc 77
    //   58: aastore
    //   59: dup
    //   60: iconst_5
    //   61: ldc 79
    //   63: aastore
    //   64: dup
    //   65: bipush 6
    //   67: ldc 81
    //   69: aastore
    //   70: dup
    //   71: bipush 7
    //   73: ldc 83
    //   75: aastore
    //   76: dup
    //   77: bipush 8
    //   79: ldc 85
    //   81: aastore
    //   82: invokevirtual 89	com/tencent/mm/plugin/appbrand/config/z:d	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +220 -> 307
    //   90: new 91	com/tencent/mm/plugin/appbrand/config/ae
    //   93: dup
    //   94: invokespecial 92	com/tencent/mm/plugin/appbrand/config/ae:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: aload_0
    //   100: putfield 94	com/tencent/mm/plugin/appbrand/config/ae:username	Ljava/lang/String;
    //   103: aload_2
    //   104: aload_3
    //   105: getfield 97	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   108: putfield 99	com/tencent/mm/plugin/appbrand/config/ae:appId	Ljava/lang/String;
    //   111: aload_2
    //   112: aload_3
    //   113: getfield 102	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_nickname	Ljava/lang/String;
    //   116: putfield 104	com/tencent/mm/plugin/appbrand/config/ae:nickname	Ljava/lang/String;
    //   119: aload_2
    //   120: aload_3
    //   121: getfield 107	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_signature	Ljava/lang/String;
    //   124: putfield 109	com/tencent/mm/plugin/appbrand/config/ae:signature	Ljava/lang/String;
    //   127: aload_2
    //   128: aload_3
    //   129: getfield 112	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_brandIconURL	Ljava/lang/String;
    //   132: putfield 115	com/tencent/mm/plugin/appbrand/config/ae:dMf	Ljava/lang/String;
    //   135: aload_2
    //   136: aload_3
    //   137: invokevirtual 119	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bAo	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   140: getfield 125	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:lgE	Ljava/util/List;
    //   143: putfield 126	com/tencent/mm/plugin/appbrand/config/ae:lgE	Ljava/util/List;
    //   146: aload_3
    //   147: invokevirtual 130	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bAp	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   150: ifnonnull +104 -> 254
    //   153: iconst_m1
    //   154: istore_1
    //   155: aload_2
    //   156: iload_1
    //   157: putfield 134	com/tencent/mm/plugin/appbrand/config/ae:cyu	I
    //   160: aload_2
    //   161: aload_3
    //   162: invokevirtual 138	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bAq	()Ljava/util/List;
    //   165: putfield 141	com/tencent/mm/plugin/appbrand/config/ae:lgr	Ljava/util/List;
    //   168: aload_2
    //   169: aload_3
    //   170: invokevirtual 119	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bAo	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   173: getfield 145	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:lgD	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   176: getfield 150	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:leb	I
    //   179: putfield 151	com/tencent/mm/plugin/appbrand/config/ae:leb	I
    //   182: aload_2
    //   183: aload_3
    //   184: invokevirtual 119	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bAo	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   187: getfield 145	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:lgD	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   190: getfield 154	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:lec	I
    //   193: putfield 155	com/tencent/mm/plugin/appbrand/config/ae:lec	I
    //   196: aload_2
    //   197: aload_3
    //   198: invokevirtual 159	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bAn	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   201: getfield 164	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:serviceType	I
    //   204: putfield 167	com/tencent/mm/plugin/appbrand/config/ae:cyo	I
    //   207: aload_2
    //   208: aload_3
    //   209: invokevirtual 159	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bAn	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   212: getfield 170	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:originalFlag	I
    //   215: putfield 171	com/tencent/mm/plugin/appbrand/config/ae:originalFlag	I
    //   218: aload_2
    //   219: aload_3
    //   220: invokevirtual 159	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bAn	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   223: getfield 174	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:ldJ	Ljava/lang/String;
    //   226: putfield 175	com/tencent/mm/plugin/appbrand/config/ae:ldJ	Ljava/lang/String;
    //   229: aload_3
    //   230: getfield 178	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_registerSource	Ljava/lang/String;
    //   233: invokestatic 28	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   236: ifeq +49 -> 285
    //   239: ldc 180
    //   241: astore_0
    //   242: aload_2
    //   243: aload_0
    //   244: putfield 183	com/tencent/mm/plugin/appbrand/config/ae:diA	Ljava/lang/String;
    //   247: ldc 61
    //   249: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_2
    //   253: areturn
    //   254: aload_3
    //   255: invokevirtual 130	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bAp	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   258: getfield 186	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:cyu	I
    //   261: istore_1
    //   262: goto -107 -> 155
    //   265: astore 4
    //   267: ldc 188
    //   269: ldc 190
    //   271: iconst_1
    //   272: anewarray 192	java/lang/Object
    //   275: dup
    //   276: iconst_0
    //   277: aload_0
    //   278: aastore
    //   279: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: goto -53 -> 229
    //   285: new 200	org/json/JSONObject
    //   288: dup
    //   289: aload_3
    //   290: getfield 178	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_registerSource	Ljava/lang/String;
    //   293: invokespecial 202	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   296: ldc 204
    //   298: ldc 180
    //   300: invokevirtual 208	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   303: astore_0
    //   304: goto -62 -> 242
    //   307: ldc 61
    //   309: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: aconst_null
    //   313: areturn
    //   314: astore_0
    //   315: goto -68 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	paramString	String
    //   154	108	1	i	int
    //   97	156	2	localae	ae
    //   85	205	3	localWxaAttributes	WxaAttributes
    //   265	1	4	localNullPointerException	NullPointerException
    // Exception table:
    //   from	to	target	type
    //   196	229	265	java/lang/NullPointerException
    //   229	239	314	java/lang/Exception
    //   242	247	314	java/lang/Exception
    //   285	304	314	java/lang/Exception
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.a Xs(String paramString)
  {
    AppMethodBeat.i(44891);
    if (n.buC() != null)
    {
      paramString = n.buC().d(paramString, new String[0]);
      if (paramString != null)
      {
        com.tencent.mm.plugin.appbrand.backgroundfetch.a locala = new com.tencent.mm.plugin.appbrand.backgroundfetch.a();
        locala.kXI = paramString.bAo().lgD.kXI;
        locala.kXJ = paramString.bAo().lgD.kXJ;
        locala.kXK = paramString.bAo().lgD.kXK;
        locala.kXL = paramString.bAo().lgD.kXL;
        AppMethodBeat.o(44891);
        return locala;
      }
    }
    AppMethodBeat.o(44891);
    return null;
  }
  
  public static boolean Xt(String paramString)
  {
    AppMethodBeat.i(44893);
    if (n.buC() != null)
    {
      paramString = n.buC().d(paramString, new String[] { "appInfo" });
      if (paramString != null)
      {
        if ((paramString.bAn() != null) && (paramString.bAn().bAt()))
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
  
  public static AppBrandSysConfigWC Xu(String paramString)
  {
    AppMethodBeat.i(44894);
    paramString = n.buC().e(paramString, new String[0]);
    if (paramString != null)
    {
      paramString = e(paramString);
      AppMethodBeat.o(44894);
      return paramString;
    }
    AppMethodBeat.o(44894);
    return null;
  }
  
  public static String[] Xv(String paramString)
  {
    AppMethodBeat.i(44897);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44897);
      return null;
    }
    Object localObject = n.buC().d(paramString, new String[] { "roundedSquareIconURL", "bigHeadURL" });
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
  
  public static String Xw(String paramString)
  {
    AppMethodBeat.i(44898);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44898);
      return null;
    }
    paramString = n.buC().d(paramString, new String[] { "appId" });
    if (paramString == null)
    {
      AppMethodBeat.o(44898);
      return null;
    }
    paramString = paramString.field_appId;
    AppMethodBeat.o(44898);
    return paramString;
  }
  
  public static String Xx(String paramString)
  {
    AppMethodBeat.i(44899);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44899);
      return null;
    }
    paramString = n.buC().e(paramString, new String[] { "nickname" });
    if (paramString == null)
    {
      AppMethodBeat.o(44899);
      return null;
    }
    paramString = paramString.field_nickname;
    AppMethodBeat.o(44899);
    return paramString;
  }
  
  public static String Xy(String paramString)
  {
    AppMethodBeat.i(44900);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44900);
      return null;
    }
    paramString = n.buC().e(paramString, new String[] { "username" });
    if (paramString == null)
    {
      AppMethodBeat.o(44900);
      return null;
    }
    paramString = paramString.field_username;
    AppMethodBeat.o(44900);
    return paramString;
  }
  
  public static void Xz(String paramString)
  {
    AppMethodBeat.i(44901);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44901);
      return;
    }
    z localz = n.buC();
    if (!Util.isNullOrNil(paramString))
    {
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("syncVersion", "");
      localContentValues.put("syncTimeSecond", Long.valueOf(0L));
      localz.db.update(localz.getTableName(), localContentValues, String.format(Locale.US, "%s=?", new Object[] { "username" }), new String[] { paramString });
    }
    AppMethodBeat.o(44901);
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
    AppMethodBeat.i(226474);
    Object localObject = n.buC();
    if ((localObject == null) || (!((x)localObject).bAh()))
    {
      Log.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo invalid storage with username(%s)", new Object[] { paramString2 });
      AppMethodBeat.o(226474);
      return null;
    }
    WxaAttributes localWxaAttributes = ((x)localObject).d(paramString2, new String[] { "appId", "nickname", "shortNickname", "smallHeadURL", "appInfo", "versionInfo", "dynamicInfo" });
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
        if (j.a.vP(paramInt))
        {
          if (localWxaAttributes != null) {
            break label413;
          }
          l1 = 0L;
        }
        for (;;)
        {
          u localu = (u)n.W(u.class);
          if (localu == null) {
            Log.w("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo by username(%s) but NULL starAppStorage, maybe account released", new Object[] { paramString2 });
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
            if ((localu == null) || (!localu.bj(paramString2, paramInt))) {
              break label465;
            }
            bool1 = true;
            if ((localWxaAttributes == null) || (!com.tencent.luggage.sdk.config.e.hP(localWxaAttributes.bAo().lgD.leb))) {
              break label471;
            }
            bool2 = true;
            label278:
            if ((localWxaAttributes == null) || (!com.tencent.luggage.sdk.config.e.hO(localWxaAttributes.bAo().lgD.lec))) {
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
                AppMethodBeat.o(226474);
                return paramString1;
                try
                {
                  i = localWxaAttributes.bAn().serviceType;
                }
                catch (NullPointerException localNullPointerException1)
                {
                  Log.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo, NULL appInfo, username = %s", new Object[] { paramString2 });
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
                    int k = localWxaAttributes.bAp().appVersion;
                    i = k;
                  }
                  catch (NullPointerException localNullPointerException4) {}
                  try
                  {
                    l1 = localWxaAttributes.bAn().czf;
                  }
                  catch (NullPointerException localNullPointerException3) {}
                }
                try
                {
                  l1 = localWxaAttributes.bAn().kWb;
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
  
  public static y bAj()
  {
    AppMethodBeat.i(44883);
    Object localObject1;
    if (n.buC() == null)
    {
      localObject1 = new com.tencent.mm.model.b();
      AppMethodBeat.o(44883);
      throw ((Throwable)localObject1);
    }
    if (lfS == null) {}
    try
    {
      if (lfS == null) {
        lfS = new y();
      }
      localObject1 = lfS;
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
        localObject = (AppBrandSysConfigLU)new bh.a() {}.newInstance();
        ((AppBrandSysConfigLU)localObject).brandName = paramWxaAttributes.field_nickname;
        ((AppBrandSysConfigLU)localObject).jyi = paramWxaAttributes.field_smallHeadURL;
        ((AppBrandSysConfigLU)localObject).appId = paramWxaAttributes.field_appId;
        ((AppBrandSysConfigLU)localObject).lex = paramWxaAttributes.bAo().lgD.lex;
        ((AppBrandSysConfigLU)localObject).cyJ = paramWxaAttributes.bAo().lgD.cyJ;
        ((AppBrandSysConfigLU)localObject).cyM = paramWxaAttributes.bAo().lgD.cyM;
        ((AppBrandSysConfigLU)localObject).cyN = paramWxaAttributes.bAo().lgD.cyN;
        ((AppBrandSysConfigLU)localObject).cyO = paramWxaAttributes.bAo().lgD.cyO;
        ((AppBrandSysConfigLU)localObject).cyP = paramWxaAttributes.bAo().lgD.cyP;
        ((AppBrandSysConfigLU)localObject).cyQ = paramWxaAttributes.bAo().lgD.cyQ;
        ((AppBrandSysConfigLU)localObject).cyL = paramWxaAttributes.bAo().lgD.cyL;
        ((AppBrandSysConfigLU)localObject).cyK = paramWxaAttributes.bAo().lgD.cyK;
        ((AppBrandSysConfigLU)localObject).cyR = paramWxaAttributes.bAo().lgD.lgH;
        ((AppBrandSysConfigLU)localObject).cyS = paramWxaAttributes.bAo().lgD.lgI;
        ((AppBrandSysConfigLU)localObject).cyT = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.bAn().lgv));
        ((AppBrandSysConfigLU)localObject).cyU = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.bAn().lgw));
        ((AppBrandSysConfigLU)localObject).cyW = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.bAn().lgy));
        ((AppBrandSysConfigLU)localObject).cyV = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.bAn().lgx));
        ((AppBrandSysConfigLU)localObject).cyX = ((ArrayList)com.tencent.luggage.h.b.c(new ArrayList(), paramWxaAttributes.bAn().lgz));
        ((AppBrandSysConfigLU)localObject).czf = paramWxaAttributes.bAn().czf;
        ((AppBrandSysConfigLU)localObject).leC = paramWxaAttributes.bAo().lgD.leC;
        ((AppBrandSysConfigLU)localObject).leD = paramWxaAttributes.bAo().lgD.leD;
        ((AppBrandSysConfigLU)localObject).cyY = paramWxaAttributes.bAo().lgD.cyY;
        ((AppBrandSysConfigLU)localObject).cze = new String[] { paramWxaAttributes.field_roundedSquareIconURL, paramWxaAttributes.field_brandIconURL, paramWxaAttributes.field_bigHeadURL };
        ((AppBrandSysConfigLU)localObject).cza = paramWxaAttributes.bAo().lgD.cza;
        ((AppBrandSysConfigLU)localObject).czb = paramWxaAttributes.bAo().lgD.lgF;
        ((AppBrandSysConfigLU)localObject).cyC = m.Xc(((AppBrandSysConfigLU)localObject).appId);
        localObject = (AppBrandSysConfigWC)localObject;
        if (localObject != null)
        {
          ((AppBrandSysConfigWC)localObject).cyZ = ((com.tencent.mm.plugin.zero.b.a)g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("ClientBenchmarkLevel", -1);
          ((AppBrandSysConfigWC)localObject).cyD = "1".equals(n.NL().get(((AppBrandSysConfigWC)localObject).appId + "_PerformancePanelEnabled", "0"));
          ((AppBrandSysConfigWC)localObject).leb = paramWxaAttributes.bAo().lgD.leb;
          ((AppBrandSysConfigWC)localObject).lec = paramWxaAttributes.bAo().lgD.lec;
        }
        AppMethodBeat.o(44895);
        return localObject;
      }
      catch (Exception paramWxaAttributes)
      {
        Log.e("MicroMsg.WxaAttrStorageHelper", "assembleSysConfig, <init> e = %s", new Object[] { paramWxaAttributes });
        AppMethodBeat.o(44895);
        return null;
      }
      Object localObject = null;
    }
  }
  
  public static boolean k(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44888);
    paramBoolean = n.buC().k(paramString, paramInt, paramBoolean);
    AppMethodBeat.o(44888);
    return paramBoolean;
  }
  
  public static void release()
  {
    try
    {
      lfS = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.y
 * JD-Core Version:    0.7.0.1
 */