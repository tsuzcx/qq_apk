package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.a.le;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.u.f;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.protocal.c.dv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class r
  extends j
{
  private static volatile r fQN;
  
  public static AppBrandRecentTaskInfo a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    Object localObject = com.tencent.mm.plugin.appbrand.app.e.aaT().d(paramString2, new String[] { "appId", "nickname", "shortNickname", "smallHeadURL", "appInfo", "versionInfo" });
    int j = 0;
    int i;
    if (localObject == null)
    {
      i = 0;
      j = i;
      label59:
      i = 0;
      if (localObject != null) {
        break label194;
      }
      i = 0;
    }
    for (;;)
    {
      long l1 = 0L;
      if (localObject == null) {
        l1 = 0L;
      }
      for (;;)
      {
        String str4 = String.valueOf(paramString1);
        label95:
        String str1;
        label104:
        String str3;
        if (localObject == null)
        {
          paramString1 = "";
          if (localObject != null) {
            break label237;
          }
          str1 = "";
          if (localObject != null) {
            break label247;
          }
          str3 = "";
          label113:
          if (localObject != null) {
            break label257;
          }
        }
        for (localObject = "";; localObject = ((WxaAttributes)localObject).field_smallHeadURL)
        {
          for (;;)
          {
            for (;;)
            {
              return new AppBrandRecentTaskInfo(str4, paramString2, paramString1, str1, str3, (String)localObject, j, paramInt, i, l1, ((s)com.tencent.mm.plugin.appbrand.app.e.G(s.class)).at(paramString2, paramInt), paramLong);
              try
              {
                i = ((WxaAttributes)localObject).aen().dWx;
              }
              catch (NullPointerException localNullPointerException1)
              {
                y.e("MicroMsg.WxaAttrStorageHelper", "assembleRecentInfo, NULL appInfo, username = %s", new Object[] { paramString2 });
              }
            }
            break label59;
            for (;;)
            {
              label194:
              long l2;
              label237:
              String str2;
              label247:
              try
              {
                int k = ((WxaAttributes)localObject).aep().cau;
                i = k;
              }
              catch (NullPointerException localNullPointerException3) {}
              label257:
              try
              {
                l2 = ((WxaAttributes)localObject).aen().fKa;
                l1 = l2;
              }
              catch (NullPointerException localNullPointerException2) {}
            }
          }
          paramString1 = ((WxaAttributes)localObject).field_appId;
          break label95;
          str2 = ((WxaAttributes)localObject).field_nickname;
          break label104;
          str3 = ((WxaAttributes)localObject).field_shortNickname;
          break label113;
        }
      }
    }
  }
  
  public static r aem()
  {
    if (fQN == null) {}
    try
    {
      if (fQN == null) {
        fQN = new r();
      }
      return fQN;
    }
    finally {}
  }
  
  public static boolean k(String paramString, int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    Object localObject1 = com.tencent.mm.plugin.appbrand.app.e.aaT();
    if (bk.bl(paramString)) {
      return false;
    }
    Object localObject2 = ((q)localObject1).d(paramString, new String[] { "appOpt" });
    if (localObject2 == null) {
      return false;
    }
    int i = ((WxaAttributes)localObject2).field_appOpt;
    if (!paramBoolean) {}
    for (paramInt = i & (paramInt ^ 0xFFFFFFFF);; paramInt = i | paramInt)
    {
      localObject2 = new ContentValues(1);
      ((ContentValues)localObject2).put("appOpt", Integer.valueOf(paramInt));
      paramBoolean = bool;
      if (((q)localObject1).dXo.update("WxaAttributesTable", (ContentValues)localObject2, String.format("%s=?", new Object[] { "username" }), new String[] { paramString }) > 0) {
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        localObject1 = new le();
        ((le)localObject1).bUf.bFn = paramString;
        ((le)localObject1).bUf.bUg = paramInt;
        com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
      }
      return paramBoolean;
    }
  }
  
  public static void release()
  {
    try
    {
      fQN = null;
      return;
    }
    finally {}
  }
  
  public static u sq(String paramString)
  {
    if ((bk.bl(paramString)) || (!g.DK())) {}
    WxaAttributes localWxaAttributes;
    do
    {
      return null;
      localWxaAttributes = com.tencent.mm.plugin.appbrand.app.e.aaT().d(paramString, new String[] { "appId", "nickname", "signature", "brandIconURL", "dynamicInfo", "versionInfo", "appInfo", "registerSource", "bindWxaInfo" });
    } while (localWxaAttributes == null);
    u localu = new u();
    localu.username = paramString;
    localu.appId = localWxaAttributes.field_appId;
    localu.nickname = localWxaAttributes.field_nickname;
    localu.signature = localWxaAttributes.field_signature;
    localu.fRz = localWxaAttributes.field_brandIconURL;
    localu.fRl = localWxaAttributes.aeo().fRl;
    int i;
    if (localWxaAttributes.aep() == null) {
      i = -1;
    }
    for (;;)
    {
      localu.fPB = i;
      localu.fQZ = localWxaAttributes.aeq();
      try
      {
        localu.bFB = localWxaAttributes.aen().dWx;
        try
        {
          if (!bk.bl(localWxaAttributes.field_registerSource)) {
            break label221;
          }
          paramString = "";
          localu.efZ = paramString;
        }
        catch (Exception paramString)
        {
          label187:
          break label187;
        }
        return localu;
        i = localWxaAttributes.aep().fPB;
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          y.e("MicroMsg.WxaAttrStorageHelper", "assembleProfileAttrs, NULL appInfo, username = %s", new Object[] { paramString });
          continue;
          label221:
          paramString = new JSONObject(localWxaAttributes.field_registerSource).optString("RegisterBody", "");
        }
      }
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.a sr(String paramString)
  {
    if (com.tencent.mm.plugin.appbrand.app.e.aaT() != null)
    {
      paramString = com.tencent.mm.plugin.appbrand.app.e.aaT().d(paramString, new String[0]);
      if (paramString != null)
      {
        com.tencent.mm.plugin.appbrand.backgroundfetch.a locala = new com.tencent.mm.plugin.appbrand.backgroundfetch.a();
        locala.fKF = paramString.aeo().fRk.fKF;
        locala.fKG = paramString.aeo().fRk.fKG;
        locala.fKH = paramString.aeo().fRk.fKH;
        return locala;
      }
    }
    return null;
  }
  
  public static AppBrandSysConfigWC ss(String paramString)
  {
    Object localObject = null;
    boolean bool2 = false;
    WxaAttributes localWxaAttributes = com.tencent.mm.plugin.appbrand.app.e.aaT().e(paramString, new String[0]);
    paramString = (String)localObject;
    if (localWxaAttributes != null)
    {
      if (localWxaAttributes == null) {
        break label593;
      }
      paramString = new AppBrandSysConfigWC();
      paramString.bFn = localWxaAttributes.field_username;
      paramString.bJw = localWxaAttributes.field_nickname;
      paramString.fPM = localWxaAttributes.field_smallHeadURL;
      paramString.appId = localWxaAttributes.field_appId;
      paramString.fPO = localWxaAttributes.aeo().fRk.fPO;
      paramString.fPY = localWxaAttributes.aeo().fRk.fPY;
      paramString.fQb = localWxaAttributes.aeo().fRk.fQb;
      paramString.fQc = localWxaAttributes.aeo().fRk.fQc;
      paramString.fQd = localWxaAttributes.aeo().fRk.fQd;
      paramString.fQe = localWxaAttributes.aeo().fRk.fQe;
      paramString.fQa = localWxaAttributes.aeo().fRk.fQa;
      paramString.fPZ = localWxaAttributes.aeo().fRk.fPZ;
      paramString.fQf = localWxaAttributes.aeo().fRk.fRo;
      paramString.fQg = localWxaAttributes.aeo().fRk.fRp;
      paramString.fQj = ((ArrayList)f.c(new ArrayList(), localWxaAttributes.aen().fRd));
      paramString.fQk = ((ArrayList)f.c(new ArrayList(), localWxaAttributes.aen().fRe));
      paramString.fQm = ((ArrayList)f.c(new ArrayList(), localWxaAttributes.aen().fRg));
      paramString.fQl = ((ArrayList)f.c(new ArrayList(), localWxaAttributes.aen().fRf));
      paramString.fQs = new dv();
      paramString.fQs.sxr = localWxaAttributes.aen().fKa;
      paramString.fQs.sxy = localWxaAttributes.aen().fRb;
      paramString.fPQ = localWxaAttributes.aeo().fRk.fPQ;
      paramString.fPR = localWxaAttributes.aeo().fRk.fPR;
      paramString.fQn = localWxaAttributes.aeo().fRk.fQn;
      paramString.fQo = ((com.tencent.mm.plugin.zero.b.a)g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getInt("ClientBenchmarkLevel", -1);
    }
    for (;;)
    {
      if (paramString != null)
      {
        localObject = paramString.appId;
        if ((!bk.bl((String)localObject)) && (com.tencent.mm.plugin.appbrand.app.e.aaY() != null)) {
          break label557;
        }
      }
      label557:
      for (boolean bool1 = false;; bool1 = Boolean.parseBoolean(com.tencent.mm.plugin.appbrand.app.e.aaY().get((String)localObject + "_AppDebugEnabled", "false")))
      {
        paramString.fPN = bool1;
        localObject = com.tencent.mm.model.c.c.IX().fJ("100216");
        bool1 = bool2;
        if (((com.tencent.mm.storage.c)localObject).isValid())
        {
          bool1 = bool2;
          if ("1".equals(((com.tencent.mm.storage.c)localObject).ctr().get("isOpenJSCore"))) {
            bool1 = true;
          }
        }
        paramString.fQh = bool1;
        paramString.fPT = "1".equals(com.tencent.mm.plugin.appbrand.app.e.aaY().get(paramString.appId + "_PerformancePanelEnabled", "0"));
        return paramString;
      }
      label593:
      paramString = null;
    }
  }
  
  public static long st(String paramString)
  {
    paramString = com.tencent.mm.plugin.appbrand.app.e.aaT().d(paramString, new String[] { "appInfo" });
    if ((paramString == null) || (paramString.aen() == null)) {
      return 0L;
    }
    return paramString.aen().fKa;
  }
  
  public static String[] su(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return null;
      paramString = com.tencent.mm.plugin.appbrand.app.e.aaT().d(paramString, new String[] { "roundedSquareIconURL", "bigHeadURL" });
    } while (paramString == null);
    return new String[] { paramString.field_roundedSquareIconURL, paramString.field_bigHeadURL };
  }
  
  public static String sv(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return null;
      paramString = com.tencent.mm.plugin.appbrand.app.e.aaT().d(paramString, new String[] { "appId" });
    } while (paramString == null);
    return paramString.field_appId;
  }
  
  public static String sw(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return null;
      paramString = com.tencent.mm.plugin.appbrand.app.e.aaT().e(paramString, new String[] { "nickname" });
    } while (paramString == null);
    return paramString.field_nickname;
  }
  
  public static String sx(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return null;
      paramString = com.tencent.mm.plugin.appbrand.app.e.aaT().e(paramString, new String[] { "username" });
    } while (paramString == null);
    return paramString.field_username;
  }
  
  public static void sy(String paramString)
  {
    if (bk.bl(paramString)) {}
    q localq;
    do
    {
      return;
      localq = com.tencent.mm.plugin.appbrand.app.e.aaT();
    } while (bk.bl(paramString));
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("syncVersion", "");
    localContentValues.put("syncTimeSecond", Long.valueOf(0L));
    localq.dXo.update("WxaAttributesTable", localContentValues, String.format(Locale.US, "%s=?", new Object[] { "username" }), new String[] { paramString });
  }
  
  public static void sz(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    WxaAttributes localWxaAttributes = new WxaAttributes();
    localWxaAttributes.field_username = paramString;
    com.tencent.mm.plugin.appbrand.app.e.aaT().a(localWxaAttributes, new String[] { "username" });
  }
  
  public final void a(j.a parama, Looper paramLooper)
  {
    if (parama == null) {
      return;
    }
    com.tencent.mm.plugin.appbrand.app.e.aaT().a(parama, paramLooper);
  }
  
  public final void b(String paramString, int paramInt, Object paramObject)
  {
    com.tencent.mm.plugin.appbrand.app.e.aaT().b(paramString, paramInt, paramObject);
  }
  
  public final void c(j.a parama)
  {
    a(parama, n.DS().mnU.getLooper());
  }
  
  public final void d(j.a parama)
  {
    if (parama == null) {
      return;
    }
    com.tencent.mm.plugin.appbrand.app.e.aaT().d(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.r
 * JD-Core Version:    0.7.0.1
 */