package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ak.a;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Locale;

public final class q
  extends k
{
  private static volatile q hjz;
  
  /* Error */
  public static v Ak(String paramString)
  {
    // Byte code:
    //   0: ldc 18
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 30	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +9 -> 18
    //   12: invokestatic 36	com/tencent/mm/kernel/g:RG	()Z
    //   15: ifne +10 -> 25
    //   18: ldc 18
    //   20: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: invokestatic 45	com/tencent/mm/plugin/appbrand/app/g:auF	()Lcom/tencent/mm/plugin/appbrand/config/r;
    //   28: aload_0
    //   29: bipush 9
    //   31: anewarray 47	java/lang/String
    //   34: dup
    //   35: iconst_0
    //   36: ldc 49
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc 51
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: ldc 53
    //   48: aastore
    //   49: dup
    //   50: iconst_3
    //   51: ldc 55
    //   53: aastore
    //   54: dup
    //   55: iconst_4
    //   56: ldc 57
    //   58: aastore
    //   59: dup
    //   60: iconst_5
    //   61: ldc 59
    //   63: aastore
    //   64: dup
    //   65: bipush 6
    //   67: ldc 61
    //   69: aastore
    //   70: dup
    //   71: bipush 7
    //   73: ldc 63
    //   75: aastore
    //   76: dup
    //   77: bipush 8
    //   79: ldc 65
    //   81: aastore
    //   82: invokevirtual 71	com/tencent/mm/plugin/appbrand/config/r:d	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +192 -> 279
    //   90: new 73	com/tencent/mm/plugin/appbrand/config/v
    //   93: dup
    //   94: invokespecial 74	com/tencent/mm/plugin/appbrand/config/v:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: aload_0
    //   100: putfield 78	com/tencent/mm/plugin/appbrand/config/v:username	Ljava/lang/String;
    //   103: aload_2
    //   104: aload_3
    //   105: getfield 83	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   108: putfield 85	com/tencent/mm/plugin/appbrand/config/v:appId	Ljava/lang/String;
    //   111: aload_2
    //   112: aload_3
    //   113: getfield 88	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_nickname	Ljava/lang/String;
    //   116: putfield 90	com/tencent/mm/plugin/appbrand/config/v:nickname	Ljava/lang/String;
    //   119: aload_2
    //   120: aload_3
    //   121: getfield 93	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_signature	Ljava/lang/String;
    //   124: putfield 95	com/tencent/mm/plugin/appbrand/config/v:signature	Ljava/lang/String;
    //   127: aload_2
    //   128: aload_3
    //   129: getfield 98	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_brandIconURL	Ljava/lang/String;
    //   132: putfield 101	com/tencent/mm/plugin/appbrand/config/v:hkq	Ljava/lang/String;
    //   135: aload_2
    //   136: aload_3
    //   137: invokevirtual 105	com/tencent/mm/plugin/appbrand/config/WxaAttributes:ayD	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$c;
    //   140: getfield 111	com/tencent/mm/plugin/appbrand/config/WxaAttributes$c:hjX	Ljava/util/List;
    //   143: putfield 112	com/tencent/mm/plugin/appbrand/config/v:hjX	Ljava/util/List;
    //   146: aload_3
    //   147: invokevirtual 116	com/tencent/mm/plugin/appbrand/config/WxaAttributes:ayE	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   150: ifnonnull +76 -> 226
    //   153: iconst_m1
    //   154: istore_1
    //   155: aload_2
    //   156: iload_1
    //   157: putfield 120	com/tencent/mm/plugin/appbrand/config/v:bDd	I
    //   160: aload_2
    //   161: aload_3
    //   162: invokevirtual 124	com/tencent/mm/plugin/appbrand/config/WxaAttributes:ayF	()Ljava/util/List;
    //   165: putfield 127	com/tencent/mm/plugin/appbrand/config/v:hjK	Ljava/util/List;
    //   168: aload_2
    //   169: aload_3
    //   170: invokevirtual 131	com/tencent/mm/plugin/appbrand/config/WxaAttributes:ayC	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   173: getfield 136	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:fmF	I
    //   176: putfield 139	com/tencent/mm/plugin/appbrand/config/v:bCV	I
    //   179: aload_2
    //   180: aload_3
    //   181: invokevirtual 131	com/tencent/mm/plugin/appbrand/config/WxaAttributes:ayC	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   184: getfield 142	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:hix	I
    //   187: putfield 143	com/tencent/mm/plugin/appbrand/config/v:hix	I
    //   190: aload_2
    //   191: aload_3
    //   192: invokevirtual 131	com/tencent/mm/plugin/appbrand/config/WxaAttributes:ayC	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   195: getfield 146	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:hiy	Ljava/lang/String;
    //   198: putfield 147	com/tencent/mm/plugin/appbrand/config/v:hiy	Ljava/lang/String;
    //   201: aload_3
    //   202: getfield 150	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_registerSource	Ljava/lang/String;
    //   205: invokestatic 30	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   208: ifeq +49 -> 257
    //   211: ldc 152
    //   213: astore_0
    //   214: aload_2
    //   215: aload_0
    //   216: putfield 155	com/tencent/mm/plugin/appbrand/config/v:fwb	Ljava/lang/String;
    //   219: ldc 18
    //   221: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload_2
    //   225: areturn
    //   226: aload_3
    //   227: invokevirtual 116	com/tencent/mm/plugin/appbrand/config/WxaAttributes:ayE	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo;
    //   230: getfield 158	com/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaVersionInfo:bDd	I
    //   233: istore_1
    //   234: goto -79 -> 155
    //   237: astore 4
    //   239: ldc 160
    //   241: ldc 162
    //   243: iconst_1
    //   244: anewarray 164	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: aload_0
    //   250: aastore
    //   251: invokestatic 170	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: goto -53 -> 201
    //   257: new 172	org/json/JSONObject
    //   260: dup
    //   261: aload_3
    //   262: getfield 150	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_registerSource	Ljava/lang/String;
    //   265: invokespecial 175	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   268: ldc 177
    //   270: ldc 152
    //   272: invokevirtual 181	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   275: astore_0
    //   276: goto -62 -> 214
    //   279: ldc 18
    //   281: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   284: aconst_null
    //   285: areturn
    //   286: astore_0
    //   287: goto -68 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	paramString	String
    //   154	80	1	i	int
    //   97	128	2	localv	v
    //   85	177	3	localWxaAttributes	WxaAttributes
    //   237	1	4	localNullPointerException	NullPointerException
    // Exception table:
    //   from	to	target	type
    //   168	201	237	java/lang/NullPointerException
    //   201	211	286	java/lang/Exception
    //   214	219	286	java/lang/Exception
    //   257	276	286	java/lang/Exception
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.a Al(String paramString)
  {
    AppMethodBeat.i(129891);
    if (com.tencent.mm.plugin.appbrand.app.g.auF() != null)
    {
      paramString = com.tencent.mm.plugin.appbrand.app.g.auF().d(paramString, new String[0]);
      if (paramString != null)
      {
        com.tencent.mm.plugin.appbrand.backgroundfetch.a locala = new com.tencent.mm.plugin.appbrand.backgroundfetch.a();
        locala.hdS = paramString.ayD().hjW.hdS;
        locala.hdT = paramString.ayD().hjW.hdT;
        locala.hdU = paramString.ayD().hjW.hdU;
        AppMethodBeat.o(129891);
        return locala;
      }
    }
    AppMethodBeat.o(129891);
    return null;
  }
  
  public static boolean Am(String paramString)
  {
    AppMethodBeat.i(143087);
    if (com.tencent.mm.plugin.appbrand.app.g.auF() != null)
    {
      paramString = com.tencent.mm.plugin.appbrand.app.g.auF().d(paramString, new String[0]);
      if (paramString != null)
      {
        if ((paramString.ayC().ayH()) || (paramString.ayC().fmF == 7))
        {
          AppMethodBeat.o(143087);
          return true;
        }
        AppMethodBeat.o(143087);
        return false;
      }
    }
    AppMethodBeat.o(143087);
    return false;
  }
  
  public static AppBrandSysConfigWC An(String paramString)
  {
    AppMethodBeat.i(129892);
    paramString = com.tencent.mm.plugin.appbrand.app.g.auF().e(paramString, new String[0]);
    if (paramString != null)
    {
      paramString = c(paramString);
      AppMethodBeat.o(129892);
      return paramString;
    }
    AppMethodBeat.o(129892);
    return null;
  }
  
  public static long Ao(String paramString)
  {
    AppMethodBeat.i(129894);
    paramString = com.tencent.mm.plugin.appbrand.app.g.auF().d(paramString, new String[] { "appInfo" });
    if ((paramString == null) || (paramString.ayC() == null))
    {
      AppMethodBeat.o(129894);
      return 0L;
    }
    long l = paramString.ayC().bDL;
    AppMethodBeat.o(129894);
    return l;
  }
  
  public static String[] Ap(String paramString)
  {
    AppMethodBeat.i(129895);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129895);
      return null;
    }
    Object localObject = com.tencent.mm.plugin.appbrand.app.g.auF().d(paramString, new String[] { "roundedSquareIconURL", "bigHeadURL" });
    if (localObject == null)
    {
      AppMethodBeat.o(129895);
      return null;
    }
    paramString = ((WxaAttributes)localObject).field_roundedSquareIconURL;
    localObject = ((WxaAttributes)localObject).field_bigHeadURL;
    AppMethodBeat.o(129895);
    return new String[] { paramString, localObject };
  }
  
  public static String Aq(String paramString)
  {
    AppMethodBeat.i(129896);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129896);
      return null;
    }
    paramString = com.tencent.mm.plugin.appbrand.app.g.auF().d(paramString, new String[] { "appId" });
    if (paramString == null)
    {
      AppMethodBeat.o(129896);
      return null;
    }
    paramString = paramString.field_appId;
    AppMethodBeat.o(129896);
    return paramString;
  }
  
  public static String Ar(String paramString)
  {
    AppMethodBeat.i(129897);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129897);
      return null;
    }
    paramString = com.tencent.mm.plugin.appbrand.app.g.auF().e(paramString, new String[] { "nickname" });
    if (paramString == null)
    {
      AppMethodBeat.o(129897);
      return null;
    }
    paramString = paramString.field_nickname;
    AppMethodBeat.o(129897);
    return paramString;
  }
  
  public static String As(String paramString)
  {
    AppMethodBeat.i(129898);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129898);
      return null;
    }
    paramString = com.tencent.mm.plugin.appbrand.app.g.auF().e(paramString, new String[] { "username" });
    if (paramString == null)
    {
      AppMethodBeat.o(129898);
      return null;
    }
    paramString = paramString.field_username;
    AppMethodBeat.o(129898);
    return paramString;
  }
  
  public static void At(String paramString)
  {
    AppMethodBeat.i(129899);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129899);
      return;
    }
    r localr = com.tencent.mm.plugin.appbrand.app.g.auF();
    if (!bo.isNullOrNil(paramString))
    {
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("syncVersion", "");
      localContentValues.put("syncTimeSecond", Long.valueOf(0L));
      localr.db.update("WxaAttributesTable", localContentValues, String.format(Locale.US, "%s=?", new Object[] { "username" }), new String[] { paramString });
    }
    AppMethodBeat.o(129899);
  }
  
  public static void Au(String paramString)
  {
    AppMethodBeat.i(129900);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129900);
      return;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    com.tencent.mm.plugin.appbrand.app.g.auF().delete(localWxaAttributes, new String[] { "username" });
    AppMethodBeat.o(129900);
  }
  
  public static AppBrandRecentTaskInfo a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(129890);
    Object localObject = com.tencent.mm.plugin.appbrand.app.g.auF().d(paramString2, new String[] { "appId", "nickname", "shortNickname", "smallHeadURL", "appInfo", "versionInfo" });
    int j = 0;
    int i;
    if (localObject == null)
    {
      i = 0;
      j = i;
      label67:
      i = 0;
      if (localObject != null) {
        break label240;
      }
      i = 0;
    }
    for (;;)
    {
      long l2 = 0L;
      long l1;
      if (localObject == null)
      {
        l1 = 0L;
        l2 = l1;
      }
      for (;;)
      {
        long l3 = 0L;
        l1 = l3;
        if (j.a.nk(paramInt))
        {
          if (localObject != null) {
            break label270;
          }
          l1 = 0L;
        }
        for (;;)
        {
          String str4 = String.valueOf(paramString1);
          label129:
          String str1;
          label138:
          String str3;
          if (localObject == null)
          {
            paramString1 = "";
            if (localObject != null) {
              break label292;
            }
            str1 = "";
            if (localObject != null) {
              break label302;
            }
            str3 = "";
            label147:
            if (localObject != null) {
              break label312;
            }
          }
          for (localObject = "";; localObject = ((WxaAttributes)localObject).field_smallHeadURL)
          {
            for (;;)
            {
              for (;;)
              {
                paramString1 = new AppBrandRecentTaskInfo(str4, paramString2, paramString1, str1, str3, (String)localObject, j, paramInt, i, l2, l1, ((s)com.tencent.mm.plugin.appbrand.app.g.w(s.class)).aG(paramString2, paramInt), paramLong);
                AppMethodBeat.o(129890);
                return paramString1;
                try
                {
                  i = ((WxaAttributes)localObject).ayC().fmF;
                }
                catch (NullPointerException localNullPointerException1)
                {
                  ab.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo, NULL appInfo, username = %s", new Object[] { paramString2 });
                }
              }
              break label67;
              for (;;)
              {
                for (;;)
                {
                  label240:
                  String str2;
                  label270:
                  label292:
                  label302:
                  label312:
                  try
                  {
                    int k = ((WxaAttributes)localObject).ayE().bDc;
                    i = k;
                  }
                  catch (NullPointerException localNullPointerException4) {}
                  try
                  {
                    l1 = ((WxaAttributes)localObject).ayC().bDL;
                  }
                  catch (NullPointerException localNullPointerException3) {}
                }
                try
                {
                  l1 = ((WxaAttributes)localObject).ayC().hcP;
                }
                catch (NullPointerException localNullPointerException2)
                {
                  l1 = l3;
                }
              }
            }
            paramString1 = ((WxaAttributes)localObject).field_appId;
            break label129;
            str2 = ((WxaAttributes)localObject).field_nickname;
            break label138;
            str3 = ((WxaAttributes)localObject).field_shortNickname;
            break label147;
          }
        }
      }
    }
  }
  
  public static q ayA()
  {
    AppMethodBeat.i(129883);
    if (hjz == null) {}
    try
    {
      if (hjz == null) {
        hjz = new q();
      }
      q localq = hjz;
      AppMethodBeat.o(129883);
      return localq;
    }
    finally
    {
      AppMethodBeat.o(129883);
    }
  }
  
  private static AppBrandSysConfigWC c(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(129893);
    if (paramWxaAttributes != null) {}
    for (;;)
    {
      try
      {
        AppBrandSysConfigLU localAppBrandSysConfigLU = (AppBrandSysConfigLU)new q.1().newInstance();
        localAppBrandSysConfigLU.cqQ = paramWxaAttributes.field_nickname;
        localAppBrandSysConfigLU.hiQ = paramWxaAttributes.field_smallHeadURL;
        localAppBrandSysConfigLU.appId = paramWxaAttributes.field_appId;
        localAppBrandSysConfigLU.hiR = paramWxaAttributes.ayD().hjW.hiR;
        localAppBrandSysConfigLU.bDp = paramWxaAttributes.ayD().hjW.bDp;
        localAppBrandSysConfigLU.bDs = paramWxaAttributes.ayD().hjW.bDs;
        localAppBrandSysConfigLU.bDt = paramWxaAttributes.ayD().hjW.bDt;
        localAppBrandSysConfigLU.bDu = paramWxaAttributes.ayD().hjW.bDu;
        localAppBrandSysConfigLU.bDv = paramWxaAttributes.ayD().hjW.bDv;
        localAppBrandSysConfigLU.bDw = paramWxaAttributes.ayD().hjW.bDw;
        localAppBrandSysConfigLU.bDr = paramWxaAttributes.ayD().hjW.bDr;
        localAppBrandSysConfigLU.bDq = paramWxaAttributes.ayD().hjW.bDq;
        localAppBrandSysConfigLU.bDx = paramWxaAttributes.ayD().hjW.hka;
        localAppBrandSysConfigLU.bDy = paramWxaAttributes.ayD().hjW.hkb;
        localAppBrandSysConfigLU.bDz = ((ArrayList)com.tencent.luggage.g.c.c(new ArrayList(), paramWxaAttributes.ayC().hjO));
        localAppBrandSysConfigLU.bDA = ((ArrayList)com.tencent.luggage.g.c.c(new ArrayList(), paramWxaAttributes.ayC().hjP));
        localAppBrandSysConfigLU.bDC = ((ArrayList)com.tencent.luggage.g.c.c(new ArrayList(), paramWxaAttributes.ayC().hjR));
        localAppBrandSysConfigLU.bDB = ((ArrayList)com.tencent.luggage.g.c.c(new ArrayList(), paramWxaAttributes.ayC().hjQ));
        localAppBrandSysConfigLU.bDD = ((ArrayList)com.tencent.luggage.g.c.c(new ArrayList(), paramWxaAttributes.ayC().hjS));
        localAppBrandSysConfigLU.bDL = paramWxaAttributes.ayC().bDL;
        localAppBrandSysConfigLU.hiV = paramWxaAttributes.ayD().hjW.hiV;
        localAppBrandSysConfigLU.hiW = paramWxaAttributes.ayD().hjW.hiW;
        localAppBrandSysConfigLU.bDE = paramWxaAttributes.ayD().hjW.bDE;
        localAppBrandSysConfigLU.bDK = new String[] { paramWxaAttributes.field_roundedSquareIconURL, paramWxaAttributes.field_brandIconURL, paramWxaAttributes.field_bigHeadURL };
        localAppBrandSysConfigLU.nickname = paramWxaAttributes.field_nickname;
        localAppBrandSysConfigLU.bDG = paramWxaAttributes.ayD().hjW.bDG;
        localAppBrandSysConfigLU.bDj = i.Ab(localAppBrandSysConfigLU.appId);
        paramWxaAttributes = (AppBrandSysConfigWC)localAppBrandSysConfigLU;
        if (paramWxaAttributes != null)
        {
          paramWxaAttributes.bDF = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getInt("ClientBenchmarkLevel", -1);
          paramWxaAttributes.bDk = "1".equals(com.tencent.mm.plugin.appbrand.app.g.wg().get(paramWxaAttributes.appId + "_PerformancePanelEnabled", "0"));
        }
        AppMethodBeat.o(129893);
        return paramWxaAttributes;
      }
      catch (Exception paramWxaAttributes)
      {
        ab.e("MicroMsg.WxaAttrStorageHelper", "assembleSysConfig, <init> e = %s", new Object[] { paramWxaAttributes });
        AppMethodBeat.o(129893);
        return null;
      }
      paramWxaAttributes = null;
    }
  }
  
  public static boolean k(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(129888);
    paramBoolean = com.tencent.mm.plugin.appbrand.app.g.auF().k(paramString, paramInt, paramBoolean);
    AppMethodBeat.o(129888);
    return paramBoolean;
  }
  
  public static void release()
  {
    try
    {
      hjz = null;
      return;
    }
    finally {}
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(129885);
    add(parama, m.aNS().oNc.getLooper());
    AppMethodBeat.o(129885);
  }
  
  public final void add(k.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(129886);
    if (parama == null)
    {
      AppMethodBeat.o(129886);
      return;
    }
    com.tencent.mm.plugin.appbrand.app.g.auF().add(parama, paramLooper);
    AppMethodBeat.o(129886);
  }
  
  public final void doNotify(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(129884);
    com.tencent.mm.plugin.appbrand.app.g.auF().doNotify(paramString, paramInt, paramObject);
    AppMethodBeat.o(129884);
  }
  
  public final void remove(k.a parama)
  {
    AppMethodBeat.i(129887);
    if (parama == null)
    {
      AppMethodBeat.o(129887);
      return;
    }
    com.tencent.mm.plugin.appbrand.app.g.auF().remove(parama);
    AppMethodBeat.o(129887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.q
 * JD-Core Version:    0.7.0.1
 */