package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.config.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.bq.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

public final class ad
  extends u
{
  private static volatile ad rbe;
  
  public static al XE(String paramString)
  {
    AppMethodBeat.i(44889);
    if ((Util.isNullOrNil(paramString)) || (!h.baz()))
    {
      AppMethodBeat.o(44889);
      return null;
    }
    WxaAttributes localWxaAttributes = n.cfc().d(paramString, new String[] { "appId", "nickname", "signature", "brandIconURL", "dynamicInfo", "versionInfo", "appInfo", "registerSource", "bindWxaInfo" });
    if (localWxaAttributes != null)
    {
      al localal = new al();
      localal.username = paramString;
      localal.appId = localWxaAttributes.field_appId;
      localal.nickname = localWxaAttributes.field_nickname;
      localal.signature = localWxaAttributes.field_signature;
      localal.hJL = localWxaAttributes.field_brandIconURL;
      localal.rbS = localWxaAttributes.cle().rbS;
      int i;
      if (localWxaAttributes.clf() == null) {
        i = -1;
      }
      for (;;)
      {
        localal.eoZ = i;
        localal.rbD = localWxaAttributes.clg();
        if (localWxaAttributes.cld() != null)
        {
          i = localWxaAttributes.cld().nOX;
          localal.nOX = i;
          localal.qYr = localWxaAttributes.cle().rbR.qYr;
        }
        try
        {
          localal.appServiceType = localWxaAttributes.cld().serviceType;
          localal.originalFlag = localWxaAttributes.cld().originalFlag;
          localal.qXZ = localWxaAttributes.cld().qXZ;
          try
          {
            if (!Util.isNullOrNil(localWxaAttributes.field_registerSource)) {
              break label296;
            }
            paramString = "";
            localal.hdH = paramString;
          }
          catch (Exception paramString)
          {
            label253:
            break label253;
          }
          AppMethodBeat.o(44889);
          return localal;
          i = localWxaAttributes.clf().eoZ;
          continue;
          i = 0;
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            Log.e("MicroMsg.WxaAttrStorageHelper", "assembleProfileAttrs, NULL appInfo, username = %s", new Object[] { paramString });
            continue;
            label296:
            paramString = new JSONObject(localWxaAttributes.field_registerSource).optString("RegisterBody", "");
          }
        }
      }
    }
    AppMethodBeat.o(44889);
    return null;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.a XF(String paramString)
  {
    AppMethodBeat.i(44891);
    if (n.cfc() != null)
    {
      paramString = n.cfc().d(paramString, new String[0]);
      if (paramString != null)
      {
        com.tencent.mm.plugin.appbrand.backgroundfetch.a locala = new com.tencent.mm.plugin.appbrand.backgroundfetch.a();
        locala.qRE = paramString.cle().rbR.qRE;
        locala.qRF = paramString.cle().rbR.qRF;
        locala.qRG = paramString.cle().rbR.qRG;
        locala.qRH = paramString.cle().rbR.qRH;
        AppMethodBeat.o(44891);
        return locala;
      }
    }
    AppMethodBeat.o(44891);
    return null;
  }
  
  public static boolean XG(String paramString)
  {
    AppMethodBeat.i(44893);
    if (n.cfc() != null)
    {
      paramString = n.cfc().d(paramString, new String[] { "appInfo" });
      if (paramString != null)
      {
        if ((paramString.cld() != null) && (paramString.cld().clj()))
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
  
  public static AppBrandSysConfigWC XH(String paramString)
  {
    AppMethodBeat.i(44894);
    paramString = n.cfc().e(paramString, new String[0]);
    if (paramString != null)
    {
      paramString = e(paramString);
      AppMethodBeat.o(44894);
      return paramString;
    }
    AppMethodBeat.o(44894);
    return null;
  }
  
  public static String[] XI(String paramString)
  {
    AppMethodBeat.i(44897);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44897);
      return null;
    }
    Object localObject = n.cfc().d(paramString, new String[] { "roundedSquareIconURL", "bigHeadURL" });
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
  
  public static String XJ(String paramString)
  {
    AppMethodBeat.i(44898);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44898);
      return null;
    }
    paramString = n.cfc().d(paramString, new String[] { "appId" });
    if (paramString == null)
    {
      AppMethodBeat.o(44898);
      return null;
    }
    paramString = paramString.field_appId;
    AppMethodBeat.o(44898);
    return paramString;
  }
  
  public static String XK(String paramString)
  {
    AppMethodBeat.i(44899);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44899);
      return null;
    }
    paramString = n.cfc().e(paramString, new String[] { "nickname" });
    if (paramString == null)
    {
      AppMethodBeat.o(44899);
      return null;
    }
    paramString = paramString.field_nickname;
    AppMethodBeat.o(44899);
    return paramString;
  }
  
  public static String XL(String paramString)
  {
    AppMethodBeat.i(44900);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44900);
      return null;
    }
    paramString = n.cfc().e(paramString, new String[] { "username" });
    if (paramString == null)
    {
      AppMethodBeat.o(44900);
      return null;
    }
    paramString = paramString.field_username;
    AppMethodBeat.o(44900);
    return paramString;
  }
  
  public static void XM(String paramString)
  {
    AppMethodBeat.i(44901);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44901);
      return;
    }
    af localaf = n.cfc();
    if (!Util.isNullOrNil(paramString))
    {
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("syncVersion", "");
      localContentValues.put("syncTimeSecond", Long.valueOf(0L));
      localaf.db.update(localaf.getTableName(), localContentValues, String.format(Locale.US, "%s=?", new Object[] { "username" }), new String[] { paramString });
    }
    AppMethodBeat.o(44901);
  }
  
  public static void XN(String paramString)
  {
    AppMethodBeat.i(44902);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44902);
      return;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    n.cfc().delete(localWxaAttributes, new String[] { "username" });
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
    AppMethodBeat.i(323338);
    Object localObject = n.cfc();
    if ((localObject == null) || (!((ac)localObject).ckW()))
    {
      Log.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo invalid storage with username(%s)", new Object[] { paramString2 });
      AppMethodBeat.o(323338);
      return null;
    }
    WxaAttributes localWxaAttributes = ((ac)localObject).d(paramString2, new String[] { "appId", "nickname", "shortNickname", "smallHeadURL", "appInfo", "versionInfo", "dynamicInfo" });
    int j = 0;
    int i;
    if (localWxaAttributes == null)
    {
      i = 0;
      j = i;
      label114:
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
        if (k.a.zn(paramInt))
        {
          if (localWxaAttributes != null) {
            break label404;
          }
          l1 = 0L;
        }
        for (;;)
        {
          t localt = (t)n.ag(t.class);
          if (localt == null) {
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
          int k;
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
            if ((localt == null) || (!localt.bU(paramString2, paramInt))) {
              break label456;
            }
            bool1 = true;
            if ((localWxaAttributes != null) && (localWxaAttributes.cld() != null)) {
              break label462;
            }
            k = 0;
            label269:
            if ((localWxaAttributes == null) || (!g.mq(localWxaAttributes.cle().rbR.qYr))) {
              break label475;
            }
          }
          for (boolean bool2 = true;; bool2 = false)
          {
            for (;;)
            {
              for (;;)
              {
                paramString1 = new AppBrandRecentTaskInfo(str4, paramString2, paramString1, (String)localObject, str2, str3, j, paramInt, i, l2, l1, bool1, paramLong, k, paramBoolean, paramString3, bool2);
                AppMethodBeat.o(323338);
                return paramString1;
                try
                {
                  i = localWxaAttributes.cld().serviceType;
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
                  label374:
                  String str1;
                  label404:
                  label426:
                  label436:
                  label446:
                  label456:
                  label462:
                  label475:
                  try
                  {
                    k = localWxaAttributes.clf().appVersion;
                    i = k;
                  }
                  catch (NullPointerException localNullPointerException4) {}
                  try
                  {
                    l1 = localWxaAttributes.cld().eqh;
                  }
                  catch (NullPointerException localNullPointerException3) {}
                }
                try
                {
                  l1 = localWxaAttributes.cld().qQd;
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
            k = localWxaAttributes.cld().nOX;
            break label269;
          }
        }
      }
    }
  }
  
  public static ad ckY()
  {
    AppMethodBeat.i(44883);
    Object localObject1;
    if (n.cfc() == null)
    {
      localObject1 = new com.tencent.mm.model.b();
      AppMethodBeat.o(44883);
      throw ((Throwable)localObject1);
    }
    if (rbe == null) {}
    try
    {
      if (rbe == null) {
        rbe = new ad();
      }
      localObject1 = rbe;
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
    int j = 0;
    AppMethodBeat.i(44895);
    if (paramWxaAttributes != null) {}
    for (;;)
    {
      try
      {
        localObject = (AppBrandSysConfigLU)new bq.a() {}.aiW();
        ((AppBrandSysConfigLU)localObject).hEy = paramWxaAttributes.field_nickname;
        ((AppBrandSysConfigLU)localObject).phA = paramWxaAttributes.field_smallHeadURL;
        ((AppBrandSysConfigLU)localObject).appId = paramWxaAttributes.field_appId;
        ((AppBrandSysConfigLU)localObject).qYQ = paramWxaAttributes.cle().rbR.qYQ;
        ((AppBrandSysConfigLU)localObject).epG = paramWxaAttributes.cle().rbR.epG;
        ((AppBrandSysConfigLU)localObject).epJ = paramWxaAttributes.cle().rbR.epJ;
        ((AppBrandSysConfigLU)localObject).epK = paramWxaAttributes.cle().rbR.epK;
        ((AppBrandSysConfigLU)localObject).epL = paramWxaAttributes.cle().rbR.epL;
        ((AppBrandSysConfigLU)localObject).epM = paramWxaAttributes.cle().rbR.epM;
        ((AppBrandSysConfigLU)localObject).epN = paramWxaAttributes.cle().rbR.epN;
        ((AppBrandSysConfigLU)localObject).epI = paramWxaAttributes.cle().rbR.epI;
        ((AppBrandSysConfigLU)localObject).epH = paramWxaAttributes.cle().rbR.epH;
        ((AppBrandSysConfigLU)localObject).epQ = paramWxaAttributes.cle().rbR.rbV;
        ((AppBrandSysConfigLU)localObject).epO = paramWxaAttributes.cle().rbR.rbW;
        ((AppBrandSysConfigLU)localObject).epP = paramWxaAttributes.cle().rbR.rbX;
        ((AppBrandSysConfigLU)localObject).epR = paramWxaAttributes.cle().rbR.rbY;
        ((AppBrandSysConfigLU)localObject).epT = paramWxaAttributes.cle().rbR.rcf.length;
        ((AppBrandSysConfigLU)localObject).epS = paramWxaAttributes.cle().rbR.rcf;
        ((AppBrandSysConfigLU)localObject).epU = ((ArrayList)com.tencent.luggage.l.b.h(new ArrayList(), paramWxaAttributes.cld().rbI));
        ((AppBrandSysConfigLU)localObject).epV = ((ArrayList)com.tencent.luggage.l.b.h(new ArrayList(), paramWxaAttributes.cld().rbJ));
        ((AppBrandSysConfigLU)localObject).epX = ((ArrayList)com.tencent.luggage.l.b.h(new ArrayList(), paramWxaAttributes.cld().rbL));
        ((AppBrandSysConfigLU)localObject).epW = ((ArrayList)com.tencent.luggage.l.b.h(new ArrayList(), paramWxaAttributes.cld().rbK));
        ((AppBrandSysConfigLU)localObject).epY = ((ArrayList)com.tencent.luggage.l.b.h(new ArrayList(), paramWxaAttributes.cld().rbM));
        ((AppBrandSysConfigLU)localObject).epZ = ((ArrayList)com.tencent.luggage.l.b.h(new ArrayList(), paramWxaAttributes.cld().rbN));
        ((AppBrandSysConfigLU)localObject).eqh = paramWxaAttributes.cld().eqh;
        ((AppBrandSysConfigLU)localObject).qYW = paramWxaAttributes.cle().rbR.qYW;
        ((AppBrandSysConfigLU)localObject).qYX = paramWxaAttributes.cle().rbR.qYX;
        ((AppBrandSysConfigLU)localObject).eqa = paramWxaAttributes.cle().rbR.eqa;
        ((AppBrandSysConfigLU)localObject).eqg = new String[] { paramWxaAttributes.field_roundedSquareIconURL, paramWxaAttributes.field_brandIconURL, paramWxaAttributes.field_bigHeadURL };
        ((AppBrandSysConfigLU)localObject).eqc = paramWxaAttributes.cle().rbR.eqc;
        ((AppBrandSysConfigLU)localObject).eqd = paramWxaAttributes.cle().rbR.rbT;
        ((AppBrandSysConfigLU)localObject).epz = o.N(((AppBrandSysConfigLU)localObject).appId);
        localObject = (AppBrandSysConfigWC)localObject;
        if (localObject != null)
        {
          ((AppBrandSysConfigWC)localObject).eqb = ((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("ClientBenchmarkLevel", -1);
          ((AppBrandSysConfigWC)localObject).epA = "1".equals(n.aqS().O(((AppBrandSysConfigWC)localObject).appId + "_PerformancePanelEnabled", "0"));
          if (paramWxaAttributes.cld() != null)
          {
            i = paramWxaAttributes.cld().nOX;
            ((AppBrandSysConfigWC)localObject).nOX = i;
            if (paramWxaAttributes.cld() == null) {
              break label721;
            }
            i = paramWxaAttributes.cld().qZg;
            ((AppBrandSysConfigWC)localObject).qZg = i;
            i = j;
            if (paramWxaAttributes.cld() != null) {
              i = paramWxaAttributes.cld().qZh;
            }
            ((AppBrandSysConfigWC)localObject).qZh = i;
            ((AppBrandSysConfigWC)localObject).qYr = paramWxaAttributes.cle().rbR.qYr;
          }
        }
        else
        {
          AppMethodBeat.o(44895);
          return localObject;
        }
      }
      catch (Exception paramWxaAttributes)
      {
        Log.e("MicroMsg.WxaAttrStorageHelper", "assembleSysConfig, <init> e = %s", new Object[] { paramWxaAttributes });
        AppMethodBeat.o(44895);
        return null;
      }
      int i = 0;
      continue;
      label721:
      i = 0;
      continue;
      Object localObject = null;
    }
  }
  
  public static boolean p(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44888);
    paramBoolean = n.cfc().p(paramString, paramInt, paramBoolean);
    AppMethodBeat.o(44888);
    return paramBoolean;
  }
  
  public static void release()
  {
    try
    {
      rbe = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.ad
 * JD-Core Version:    0.7.0.1
 */