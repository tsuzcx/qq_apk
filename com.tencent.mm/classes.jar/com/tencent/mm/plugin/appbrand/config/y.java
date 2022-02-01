package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.bj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Locale;

public final class y
  extends r
{
  private static volatile y oas;
  
  public static AppBrandRecentTaskInfo a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44890);
    paramString1 = a(paramString1, paramString2, paramInt, paramLong, false, "");
    AppMethodBeat.o(44890);
    return paramString1;
  }
  
  public static AppBrandRecentTaskInfo a(String paramString1, String paramString2, int paramInt, long paramLong, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(279015);
    Object localObject = com.tencent.mm.plugin.appbrand.app.m.bFF();
    if ((localObject == null) || (!((x)localObject).bLz()))
    {
      Log.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo invalid storage with username(%s)", new Object[] { paramString2 });
      AppMethodBeat.o(279015);
      return null;
    }
    WxaAttributes localWxaAttributes = ((x)localObject).c(paramString2, new String[] { "appId", "nickname", "shortNickname", "smallHeadURL", "appInfo", "versionInfo", "dynamicInfo" });
    int j = 0;
    int i;
    if (localWxaAttributes == null)
    {
      i = 0;
      j = i;
      label109:
      i = 0;
      if (localWxaAttributes != null) {
        break label374;
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
        if (j.a.za(paramInt))
        {
          if (localWxaAttributes != null) {
            break label404;
          }
          l1 = 0L;
        }
        for (;;)
        {
          u localu = (u)com.tencent.mm.plugin.appbrand.app.m.W(u.class);
          if (localu == null) {
            Log.w("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo by username(%s) but NULL starAppStorage, maybe account released", new Object[] { paramString2 });
          }
          String str4 = String.valueOf(paramString1);
          label201:
          label210:
          String str2;
          label219:
          String str3;
          label228:
          boolean bool1;
          label246:
          boolean bool2;
          if (localWxaAttributes == null)
          {
            paramString1 = "";
            if (localWxaAttributes != null) {
              break label426;
            }
            localObject = "";
            if (localWxaAttributes != null) {
              break label436;
            }
            str2 = "";
            if (localWxaAttributes != null) {
              break label446;
            }
            str3 = "";
            if ((localu == null) || (!localu.bC(paramString2, paramInt))) {
              break label456;
            }
            bool1 = true;
            if ((localWxaAttributes == null) || (!com.tencent.luggage.sdk.config.e.iP(localWxaAttributes.bLG().obf.nYp))) {
              break label462;
            }
            bool2 = true;
            label271:
            if ((localWxaAttributes == null) || (!com.tencent.luggage.sdk.config.e.iO(localWxaAttributes.bLG().obf.nYq))) {
              break label468;
            }
          }
          for (boolean bool3 = true;; bool3 = false)
          {
            for (;;)
            {
              for (;;)
              {
                paramString1 = new AppBrandRecentTaskInfo(str4, paramString2, paramString1, (String)localObject, str2, str3, j, paramInt, i, l2, l1, bool1, paramLong, bool2, paramBoolean, paramString3, bool3);
                AppMethodBeat.o(279015);
                return paramString1;
                try
                {
                  i = localWxaAttributes.bLF().serviceType;
                }
                catch (NullPointerException localNullPointerException1)
                {
                  Log.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo, NULL appInfo, username = %s", new Object[] { paramString2 });
                }
              }
              break label109;
              for (;;)
              {
                for (;;)
                {
                  label374:
                  String str1;
                  label404:
                  label426:
                  label436:
                  label446:
                  label456:
                  label462:
                  label468:
                  try
                  {
                    int k = localWxaAttributes.bLH().appVersion;
                    i = k;
                  }
                  catch (NullPointerException localNullPointerException4) {}
                  try
                  {
                    l1 = localWxaAttributes.bLF().cxN;
                  }
                  catch (NullPointerException localNullPointerException3) {}
                }
                try
                {
                  l1 = localWxaAttributes.bLF().nQo;
                }
                catch (NullPointerException localNullPointerException2)
                {
                  l1 = l3;
                }
              }
            }
            paramString1 = localWxaAttributes.field_appId;
            break label201;
            str1 = localWxaAttributes.field_nickname;
            break label210;
            str2 = localWxaAttributes.field_shortNickname;
            break label219;
            str3 = localWxaAttributes.field_smallHeadURL;
            break label228;
            bool1 = false;
            break label246;
            bool2 = false;
            break label271;
          }
        }
      }
    }
  }
  
  /* Error */
  public static ae afd(String paramString)
  {
    // Byte code:
    //   0: ldc 181
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 187	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +9 -> 18
    //   12: invokestatic 192	com/tencent/mm/kernel/h:aHB	()Z
    //   15: ifne +10 -> 25
    //   18: ldc 181
    //   20: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: invokestatic 39	com/tencent/mm/plugin/appbrand/app/m:bFF	()Lcom/tencent/mm/plugin/appbrand/config/z;
    //   28: aload_0
    //   29: bipush 9
    //   31: anewarray 59	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc 61
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc 63
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: ldc 194
    //   48: aastore
    //   49: dup
    //   50: iconst_3
    //   51: ldc 196
    //   53: aastore
    //   54: dup
    //   55: iconst_4
    //   56: ldc 73
    //   58: aastore
    //   59: dup
    //   60: iconst_5
    //   61: ldc 71
    //   63: aastore
    //   64: dup
    //   65: bipush 6
    //   67: ldc 69
    //   69: aastore
    //   70: dup
    //   71: bipush 7
    //   73: ldc 198
    //   75: aastore
    //   76: dup
    //   77: bipush 8
    //   79: ldc 200
    //   81: aastore
    //   82: invokevirtual 203	com/tencent/mm/plugin/appbrand/config/z:c	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +222 -> 309
    //   90: new 205	com/tencent/mm/plugin/appbrand/config/ae
    //   93: dup
    //   94: invokespecial 206	com/tencent/mm/plugin/appbrand/config/ae:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: aload_0
    //   100: putfield 209	com/tencent/mm/plugin/appbrand/config/ae:username	Ljava/lang/String;
    //   103: aload_2
    //   104: aload_3
    //   105: getfield 167	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   108: putfield 211	com/tencent/mm/plugin/appbrand/config/ae:appId	Ljava/lang/String;
    //   111: aload_2
    //   112: aload_3
    //   113: getfield 170	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_nickname	Ljava/lang/String;
    //   116: putfield 213	com/tencent/mm/plugin/appbrand/config/ae:nickname	Ljava/lang/String;
    //   119: aload_2
    //   120: aload_3
    //   121: getfield 216	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_signature	Ljava/lang/String;
    //   124: putfield 218	com/tencent/mm/plugin/appbrand/config/ae:signature	Ljava/lang/String;
    //   127: aload_2
    //   128: aload_3
    //   129: getfield 221	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_brandIconURL	Ljava/lang/String;
    //   132: putfield 224	com/tencent/mm/plugin/appbrand/config/ae:fET	Ljava/lang/String;
    //   135: aload_2
    //   136: aload_3
    //   137: invokevirtual 108	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bLG	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   140: getfield 228	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:obg	Ljava/util/List;
    //   143: putfield 229	com/tencent/mm/plugin/appbrand/config/ae:obg	Ljava/util/List;
    //   146: aload_3
    //   147: invokevirtual 151	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bLH	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   150: ifnonnull +104 -> 254
    //   153: iconst_m1
    //   154: istore_1
    //   155: aload_2
    //   156: iload_1
    //   157: putfield 232	com/tencent/mm/plugin/appbrand/config/ae:cwX	I
    //   160: aload_2
    //   161: aload_3
    //   162: invokevirtual 236	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bLI	()Ljava/util/List;
    //   165: putfield 239	com/tencent/mm/plugin/appbrand/config/ae:oaR	Ljava/util/List;
    //   168: aload_2
    //   169: aload_3
    //   170: invokevirtual 108	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bLG	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   173: getfield 114	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:obf	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   176: getfield 120	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:nYp	I
    //   179: putfield 240	com/tencent/mm/plugin/appbrand/config/ae:nYp	I
    //   182: aload_2
    //   183: aload_3
    //   184: invokevirtual 108	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bLG	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   187: getfield 114	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:obf	Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a;
    //   190: getfield 128	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c$a:nYq	I
    //   193: putfield 241	com/tencent/mm/plugin/appbrand/config/ae:nYq	I
    //   196: aload_2
    //   197: aload_3
    //   198: invokevirtual 140	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bLF	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   201: getfield 145	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:serviceType	I
    //   204: putfield 244	com/tencent/mm/plugin/appbrand/config/ae:cwR	I
    //   207: aload_2
    //   208: aload_3
    //   209: invokevirtual 140	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bLF	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   212: getfield 247	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:originalFlag	I
    //   215: putfield 248	com/tencent/mm/plugin/appbrand/config/ae:originalFlag	I
    //   218: aload_2
    //   219: aload_3
    //   220: invokevirtual 140	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bLF	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   223: getfield 251	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:nXX	Ljava/lang/String;
    //   226: putfield 252	com/tencent/mm/plugin/appbrand/config/ae:nXX	Ljava/lang/String;
    //   229: aload_3
    //   230: getfield 255	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_registerSource	Ljava/lang/String;
    //   233: invokestatic 187	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   236: ifeq +50 -> 286
    //   239: ldc 24
    //   241: astore_0
    //   242: aload_2
    //   243: aload_0
    //   244: putfield 258	com/tencent/mm/plugin/appbrand/config/ae:fag	Ljava/lang/String;
    //   247: ldc 181
    //   249: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_2
    //   253: areturn
    //   254: aload_3
    //   255: invokevirtual 151	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bLH	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   258: getfield 259	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:cwX	I
    //   261: istore_1
    //   262: goto -107 -> 155
    //   265: astore 4
    //   267: ldc 47
    //   269: ldc_w 261
    //   272: iconst_1
    //   273: anewarray 51	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload_0
    //   279: aastore
    //   280: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   283: goto -54 -> 229
    //   286: new 263	org/json/JSONObject
    //   289: dup
    //   290: aload_3
    //   291: getfield 255	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_registerSource	Ljava/lang/String;
    //   294: invokespecial 266	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   297: ldc_w 268
    //   300: ldc 24
    //   302: invokevirtual 272	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   305: astore_0
    //   306: goto -64 -> 242
    //   309: ldc 181
    //   311: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: aconst_null
    //   315: areturn
    //   316: astore_0
    //   317: goto -70 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramString	String
    //   154	108	1	i	int
    //   97	156	2	localae	ae
    //   85	206	3	localWxaAttributes	WxaAttributes
    //   265	1	4	localNullPointerException	NullPointerException
    // Exception table:
    //   from	to	target	type
    //   196	229	265	java/lang/NullPointerException
    //   229	239	316	java/lang/Exception
    //   242	247	316	java/lang/Exception
    //   286	306	316	java/lang/Exception
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.a afe(String paramString)
  {
    AppMethodBeat.i(44891);
    if (com.tencent.mm.plugin.appbrand.app.m.bFF() != null)
    {
      paramString = com.tencent.mm.plugin.appbrand.app.m.bFF().c(paramString, new String[0]);
      if (paramString != null)
      {
        com.tencent.mm.plugin.appbrand.backgroundfetch.a locala = new com.tencent.mm.plugin.appbrand.backgroundfetch.a();
        locala.nRU = paramString.bLG().obf.nRU;
        locala.nRV = paramString.bLG().obf.nRV;
        locala.nRW = paramString.bLG().obf.nRW;
        locala.nRX = paramString.bLG().obf.nRX;
        AppMethodBeat.o(44891);
        return locala;
      }
    }
    AppMethodBeat.o(44891);
    return null;
  }
  
  public static boolean aff(String paramString)
  {
    AppMethodBeat.i(44893);
    if (com.tencent.mm.plugin.appbrand.app.m.bFF() != null)
    {
      paramString = com.tencent.mm.plugin.appbrand.app.m.bFF().c(paramString, new String[] { "appInfo" });
      if (paramString != null)
      {
        if ((paramString.bLF() != null) && (paramString.bLF().bLL()))
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
  
  public static AppBrandSysConfigWC afg(String paramString)
  {
    AppMethodBeat.i(44894);
    paramString = com.tencent.mm.plugin.appbrand.app.m.bFF().d(paramString, new String[0]);
    if (paramString != null)
    {
      paramString = e(paramString);
      AppMethodBeat.o(44894);
      return paramString;
    }
    AppMethodBeat.o(44894);
    return null;
  }
  
  public static String[] afh(String paramString)
  {
    AppMethodBeat.i(44897);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44897);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.app.m.bFF().c(paramString, new String[] { "roundedSquareIconURL", "bigHeadURL" });
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
  
  public static String afi(String paramString)
  {
    AppMethodBeat.i(44898);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44898);
      return null;
    }
    paramString = com.tencent.mm.plugin.appbrand.app.m.bFF().c(paramString, new String[] { "appId" });
    if (paramString == null)
    {
      AppMethodBeat.o(44898);
      return null;
    }
    paramString = paramString.field_appId;
    AppMethodBeat.o(44898);
    return paramString;
  }
  
  public static String afj(String paramString)
  {
    AppMethodBeat.i(44899);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44899);
      return null;
    }
    paramString = com.tencent.mm.plugin.appbrand.app.m.bFF().d(paramString, new String[] { "nickname" });
    if (paramString == null)
    {
      AppMethodBeat.o(44899);
      return null;
    }
    paramString = paramString.field_nickname;
    AppMethodBeat.o(44899);
    return paramString;
  }
  
  public static String afk(String paramString)
  {
    AppMethodBeat.i(44900);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44900);
      return null;
    }
    paramString = com.tencent.mm.plugin.appbrand.app.m.bFF().d(paramString, new String[] { "username" });
    if (paramString == null)
    {
      AppMethodBeat.o(44900);
      return null;
    }
    paramString = paramString.field_username;
    AppMethodBeat.o(44900);
    return paramString;
  }
  
  public static void afl(String paramString)
  {
    AppMethodBeat.i(44901);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44901);
      return;
    }
    z localz = com.tencent.mm.plugin.appbrand.app.m.bFF();
    if (!Util.isNullOrNil(paramString))
    {
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("syncVersion", "");
      localContentValues.put("syncTimeSecond", Long.valueOf(0L));
      localz.db.update(localz.getTableName(), localContentValues, String.format(Locale.US, "%s=?", new Object[] { "username" }), new String[] { paramString });
    }
    AppMethodBeat.o(44901);
  }
  
  public static void afm(String paramString)
  {
    AppMethodBeat.i(44902);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44902);
      return;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    com.tencent.mm.plugin.appbrand.app.m.bFF().delete(localWxaAttributes, new String[] { "username" });
    AppMethodBeat.o(44902);
  }
  
  public static y bLB()
  {
    AppMethodBeat.i(44883);
    Object localObject1;
    if (com.tencent.mm.plugin.appbrand.app.m.bFF() == null)
    {
      localObject1 = new com.tencent.mm.model.b();
      AppMethodBeat.o(44883);
      throw ((Throwable)localObject1);
    }
    if (oas == null) {}
    try
    {
      if (oas == null) {
        oas = new y();
      }
      localObject1 = oas;
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
        localObject = (AppBrandSysConfigLU)new bj.a() {}.bEA();
        ((AppBrandSysConfigLU)localObject).fzM = paramWxaAttributes.field_nickname;
        ((AppBrandSysConfigLU)localObject).mnM = paramWxaAttributes.field_smallHeadURL;
        ((AppBrandSysConfigLU)localObject).appId = paramWxaAttributes.field_appId;
        ((AppBrandSysConfigLU)localObject).nYK = paramWxaAttributes.bLG().obf.nYK;
        ((AppBrandSysConfigLU)localObject).cxo = paramWxaAttributes.bLG().obf.cxo;
        ((AppBrandSysConfigLU)localObject).cxr = paramWxaAttributes.bLG().obf.cxr;
        ((AppBrandSysConfigLU)localObject).cxs = paramWxaAttributes.bLG().obf.cxs;
        ((AppBrandSysConfigLU)localObject).cxt = paramWxaAttributes.bLG().obf.cxt;
        ((AppBrandSysConfigLU)localObject).cxu = paramWxaAttributes.bLG().obf.cxu;
        ((AppBrandSysConfigLU)localObject).cxv = paramWxaAttributes.bLG().obf.cxv;
        ((AppBrandSysConfigLU)localObject).cxq = paramWxaAttributes.bLG().obf.cxq;
        ((AppBrandSysConfigLU)localObject).cxp = paramWxaAttributes.bLG().obf.cxp;
        ((AppBrandSysConfigLU)localObject).cxy = paramWxaAttributes.bLG().obf.obk;
        ((AppBrandSysConfigLU)localObject).cxw = paramWxaAttributes.bLG().obf.obl;
        ((AppBrandSysConfigLU)localObject).cxx = paramWxaAttributes.bLG().obf.obm;
        ((AppBrandSysConfigLU)localObject).cxz = paramWxaAttributes.bLG().obf.obn;
        ((AppBrandSysConfigLU)localObject).cxA = ((ArrayList)com.tencent.luggage.k.b.c(new ArrayList(), paramWxaAttributes.bLF().oaW));
        ((AppBrandSysConfigLU)localObject).cxB = ((ArrayList)com.tencent.luggage.k.b.c(new ArrayList(), paramWxaAttributes.bLF().oaX));
        ((AppBrandSysConfigLU)localObject).cxD = ((ArrayList)com.tencent.luggage.k.b.c(new ArrayList(), paramWxaAttributes.bLF().oaZ));
        ((AppBrandSysConfigLU)localObject).cxC = ((ArrayList)com.tencent.luggage.k.b.c(new ArrayList(), paramWxaAttributes.bLF().oaY));
        ((AppBrandSysConfigLU)localObject).cxE = ((ArrayList)com.tencent.luggage.k.b.c(new ArrayList(), paramWxaAttributes.bLF().oba));
        ((AppBrandSysConfigLU)localObject).cxF = ((ArrayList)com.tencent.luggage.k.b.c(new ArrayList(), paramWxaAttributes.bLF().obb));
        ((AppBrandSysConfigLU)localObject).cxN = paramWxaAttributes.bLF().cxN;
        ((AppBrandSysConfigLU)localObject).nYP = paramWxaAttributes.bLG().obf.nYP;
        ((AppBrandSysConfigLU)localObject).nYQ = paramWxaAttributes.bLG().obf.nYQ;
        ((AppBrandSysConfigLU)localObject).cxG = paramWxaAttributes.bLG().obf.cxG;
        ((AppBrandSysConfigLU)localObject).cxM = new String[] { paramWxaAttributes.field_roundedSquareIconURL, paramWxaAttributes.field_brandIconURL, paramWxaAttributes.field_bigHeadURL };
        ((AppBrandSysConfigLU)localObject).cxI = paramWxaAttributes.bLG().obf.cxI;
        ((AppBrandSysConfigLU)localObject).cxJ = paramWxaAttributes.bLG().obf.obh;
        ((AppBrandSysConfigLU)localObject).cxh = m.aeO(((AppBrandSysConfigLU)localObject).appId);
        localObject = (AppBrandSysConfigWC)localObject;
        if (localObject != null)
        {
          ((AppBrandSysConfigWC)localObject).cxH = ((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("ClientBenchmarkLevel", -1);
          ((AppBrandSysConfigWC)localObject).cxi = "1".equals(com.tencent.mm.plugin.appbrand.app.m.QG().L(((AppBrandSysConfigWC)localObject).appId + "_PerformancePanelEnabled", "0"));
          ((AppBrandSysConfigWC)localObject).nYp = paramWxaAttributes.bLG().obf.nYp;
          ((AppBrandSysConfigWC)localObject).nYq = paramWxaAttributes.bLG().obf.nYq;
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
  
  public static boolean o(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44888);
    paramBoolean = com.tencent.mm.plugin.appbrand.app.m.bFF().o(paramString, paramInt, paramBoolean);
    AppMethodBeat.o(44888);
    return paramBoolean;
  }
  
  public static void release()
  {
    try
    {
      oas = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.y
 * JD-Core Version:    0.7.0.1
 */