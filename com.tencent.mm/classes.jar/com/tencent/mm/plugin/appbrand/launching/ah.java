package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appcache.bw;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c.a;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils;", "", "()V", "MissedAppPkgFailureTimestampsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "", "TAG", "", "UpdateNewWxaAttrsFailureTimestampMap", "WxaAttributesStore", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "checkGetWxaAttrsTimeoutStrategy", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "wxaAttributes", "checkIfUseBackupWxaAttrsForLaunchDirectly", "", "username", "appId", "checkLaunchTimeoutStrategy", "enterPath", "clearLaunchFailedTimestamp", "", "getCachedWxaAttributes", "getDynamicSettings", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaDynamicInfo$Setting;", "key", "reason", "allowReadDB", "isSwitchOn", "isUnderWeakNetwork", "markLaunchFailedByMissedAppPkg", "markLaunchFailedByUpdateWxaAttrs", "removeWxaAttributesCache", "setWxaAttributesCache", "printFields", "KEY", "Reporter", "Strategy", "plugin-appbrand-integration_release"})
public final class ah
{
  private static final ConcurrentHashMap<ah.a, WxaAttributes> pWw;
  private static final ConcurrentHashMap<ah.a, Long> pWx;
  private static final ConcurrentHashMap<ah.a, Long> pWy;
  public static final ah pWz;
  
  static
  {
    AppMethodBeat.i(275458);
    pWz = new ah();
    pWw = new ConcurrentHashMap();
    pWx = new ConcurrentHashMap();
    pWy = new ConcurrentHashMap();
    AppMethodBeat.o(275458);
  }
  
  private static WxaAttributes.c.a a(ah.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(275447);
    Object localObject = (WxaAttributes)pWw.get(parama);
    if (localObject != null)
    {
      localObject = ((WxaAttributes)localObject).bLG();
      if (localObject != null)
      {
        WxaAttributes.c.a locala = ((WxaAttributes.c)localObject).obf;
        localObject = locala;
        if (locala != null) {
          break label57;
        }
      }
    }
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.appbrand.app.m.bFF();
      if (localObject != null) {
        break label110;
      }
    }
    label57:
    label188:
    for (;;)
    {
      localObject = null;
      if (localObject == null) {
        break label205;
      }
      Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "getDynamicSettings with key:" + parama + ", reason:" + paramString + ", get settings:" + a((WxaAttributes.c.a)localObject));
      AppMethodBeat.o(275447);
      return localObject;
      label110:
      if ((parama instanceof ah.a.b)) {}
      for (localObject = ((z)localObject).c(((ah.a.b)parama).value, new String[] { "dynamicInfo" });; localObject = ((z)localObject).d(((ah.a.a)parama).value, new String[] { "dynamicInfo" }))
      {
        if (localObject == null) {
          break label188;
        }
        localObject = ((WxaAttributes)localObject).bLG();
        if (localObject == null) {
          break;
        }
        localObject = ((WxaAttributes.c)localObject).obf;
        break label57;
        if (!(parama instanceof ah.a.a)) {
          break label190;
        }
      }
    }
    label190:
    parama = new kotlin.m();
    AppMethodBeat.o(275447);
    throw parama;
    label205:
    AppMethodBeat.o(275447);
    return null;
  }
  
  private static String a(WxaAttributes.c.a parama)
  {
    AppMethodBeat.i(275449);
    parama = "{OpenWxaWaitUpdateMaxMicSec:" + parama.obp + ", OpenWxaWaitUpdateMaxMicSecForWeakNet:" + parama.obq + ", NextTryOpenWxaDisMicSec:" + parama.obs + '}';
    AppMethodBeat.o(275449);
    return parama;
  }
  
  public static final WxaAttributes ajZ(String paramString)
  {
    AppMethodBeat.i(275445);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(275445);
      return null;
    }
    paramString = (WxaAttributes)pWw.get(new ah.a.b(paramString));
    AppMethodBeat.o(275445);
    return paramString;
  }
  
  public static final boolean cab()
  {
    AppMethodBeat.i(275451);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vEJ, false);
    AppMethodBeat.o(275451);
    return bool;
  }
  
  public static final void ep(String paramString1, String paramString2)
  {
    AppMethodBeat.i(275443);
    Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "removeWxaAttributesCache(username:" + paramString1 + ", appId:" + paramString2 + ')');
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        pWw.remove(new ah.a.b(paramString1));
      }
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label129;
      }
    }
    label129:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        pWw.remove(new ah.a.a(paramString2));
      }
      AppMethodBeat.o(275443);
      return;
      i = 0;
      break;
    }
  }
  
  public static final c eq(String paramString1, String paramString2)
  {
    int j = 1;
    boolean bool1 = true;
    AppMethodBeat.i(275452);
    if (!cab())
    {
      paramString1 = (c)ah.c.b.pWE;
      AppMethodBeat.o(275452);
      return paramString1;
    }
    Object localObject1 = (CharSequence)paramString1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString1 = (c)ah.c.b.pWE;
      AppMethodBeat.o(275452);
      return paramString1;
    }
    localObject1 = ((v)com.tencent.mm.plugin.appbrand.app.m.W(v.class)).d(paramString1, new String[] { "versionInfo", "appInfo" });
    if (localObject1 != null) {}
    for (boolean bool2 = true; localObject1 == null; bool2 = false)
    {
      bool1 = false;
      Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkLaunchTimeoutStrategy appId:" + paramString1 + " isBackupExisted:" + bool2 + " isBackupCodePkgExisted:" + bool1);
      if ((bool2) && (bool1)) {
        break label373;
      }
      paramString1 = (c)ah.c.b.pWE;
      AppMethodBeat.o(275452);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        Object localObject2 = ((WxaAttributes)localObject1).bLF();
        p.j(localObject2, "backupWxaAttrs.appInfo");
        if (((WxaAttributes.a)localObject2).Qv()) {
          break;
        }
        localObject2 = (CharSequence)paramString2;
        i = j;
        if (localObject2 != null)
        {
          if (((CharSequence)localObject2).length() != 0) {
            break label457;
          }
          i = j;
        }
        if (i != 0)
        {
          bool1 = ((bw)h.ae(bw.class)).bi(paramString1, ((WxaAttributes)localObject1).bLH().appVersion);
          break;
        }
        bool1 = ((bw)h.ae(bw.class)).p(paramString1, ((WxaAttributes)localObject1).bLH().appVersion, paramString2);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder("checkLaunchTimeoutStrategy, appId:").append(paramString1).append(", enterPath:");
        localObject1 = paramString2;
        if (paramString2 == null) {
          localObject1 = "";
        }
        Log.e("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", (String)localObject1 + ", check PageIndex get failed by " + localException);
        bool1 = false;
      }
      break;
      label373:
      paramString1 = a((ah.a)new ah.a.a(paramString1), "checkLaunchTimeoutStrategy", false);
      if (paramString1 == null)
      {
        paramString1 = (c)ah.c.b.pWE;
        AppMethodBeat.o(275452);
        return paramString1;
      }
      long l = paramString1.obp;
      if (l <= 0L)
      {
        paramString1 = (c)ah.c.b.pWE;
        AppMethodBeat.o(275452);
        return paramString1;
      }
      paramString1 = (c)new ah.c.a(l);
      AppMethodBeat.o(275452);
      return paramString1;
      label457:
      i = 0;
    }
  }
  
  public static final void er(String paramString1, String paramString2)
  {
    AppMethodBeat.i(275453);
    long l = Util.nowMilliSecond();
    Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "markLaunchFailedByMissedAppPkg(username:" + paramString1 + ", appId:" + paramString2 + ") ts:" + l);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        ((Map)pWx).put(new ah.a.b(paramString1), Long.valueOf(l));
      }
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label162;
      }
    }
    label162:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((Map)pWx).put(new ah.a.a(paramString2), Long.valueOf(l));
      }
      AppMethodBeat.o(275453);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void es(String paramString1, String paramString2)
  {
    AppMethodBeat.i(275454);
    Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "clearLaunchFailedTimestamp(username:" + paramString1 + ", appId:" + paramString2 + ')');
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        pWx.remove(new ah.a.b(paramString1));
        pWy.remove(new ah.a.b(paramString1));
      }
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label162;
      }
    }
    label162:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        pWx.remove(new ah.a.a(paramString2));
        pWy.remove(new ah.a.a(paramString2));
      }
      AppMethodBeat.o(275454);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void et(String paramString1, String paramString2)
  {
    AppMethodBeat.i(275455);
    Log.e("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "markLaunchFailedByUpdateWxaAttrs, username:" + paramString1 + " appId:" + paramString2);
    long l = Util.nowMilliSecond();
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        ((Map)pWy).put(new ah.a.b(paramString1), Long.valueOf(l));
      }
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label153;
      }
    }
    label153:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((Map)pWy).put(new ah.a.a(paramString2), Long.valueOf(l));
      }
      AppMethodBeat.o(275455);
      return;
      i = 0;
      break;
    }
  }
  
  public static final boolean eu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(275457);
    if (!cab())
    {
      AppMethodBeat.o(275457);
      return false;
    }
    Object localObject = (CharSequence)paramString2;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString1 = (ah.a)new ah.a.a(paramString2);
      if (!pWy.contains(paramString1)) {
        break label257;
      }
      paramString2 = a(paramString1, "[UpdateNewWxaAttrsFailure]", true);
      if (paramString2 != null) {
        break label147;
      }
      AppMethodBeat.o(275457);
      return false;
    }
    paramString2 = (CharSequence)paramString1;
    if ((paramString2 == null) || (paramString2.length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label139;
      }
      paramString1 = (ah.a)new ah.a.b(paramString1);
      break;
    }
    label139:
    AppMethodBeat.o(275457);
    return false;
    label147:
    long l1 = paramString2.obs;
    localObject = (Long)pWy.remove(paramString1);
    paramString2 = (String)localObject;
    if (localObject == null) {
      paramString2 = Long.valueOf(0L);
    }
    p.j(paramString2, "UpdateNewWxaAttrsFailure…stampMap.remove(key) ?: 0");
    long l2 = paramString2.longValue();
    if (Util.nowMilliSecond() - l2 <= l1)
    {
      Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkIfUseBackupWxaAttrsForLaunchDirectly by [UpdateNewWxaAttrsFailure] interval[" + l1 + "ms] lastFailureTimestamp[" + l2 + "] key[" + paramString1 + ']');
      AppMethodBeat.o(275457);
      return true;
    }
    label257:
    paramString2 = a(paramString1, "[MissedAppPkgFailure]", false);
    if (paramString2 == null)
    {
      AppMethodBeat.o(275457);
      return false;
    }
    l1 = paramString2.obs;
    localObject = (Long)pWx.remove(paramString1);
    paramString2 = (String)localObject;
    if (localObject == null) {
      paramString2 = Long.valueOf(0L);
    }
    p.j(paramString2, "MissedAppPkgFailureTimestampsMap.remove(key) ?: 0");
    l2 = paramString2.longValue();
    Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkIfUseBackupWxaAttrsForLaunchDirectly by [MissedAppPkgFailure] interval[" + l1 + "ms] lastFailureTimestamp[" + l2 + "] key[" + paramString1 + ']');
    if (Util.nowMilliSecond() - l2 <= l1)
    {
      AppMethodBeat.o(275457);
      return true;
    }
    AppMethodBeat.o(275457);
    return false;
  }
  
  public static final void h(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(275442);
    p.k(paramWxaAttributes, "wxaAttributes");
    Map localMap = (Map)pWw;
    String str = paramWxaAttributes.field_username;
    p.j(str, "wxaAttributes.field_username");
    localMap.put(new ah.a.b(str), paramWxaAttributes);
    localMap = (Map)pWw;
    str = paramWxaAttributes.field_appId;
    p.j(str, "wxaAttributes.field_appId");
    localMap.put(new ah.a.a(str), paramWxaAttributes);
    AppMethodBeat.o(275442);
  }
  
  public static final c i(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(275456);
    if (!cab())
    {
      paramWxaAttributes = (c)ah.c.b.pWE;
      AppMethodBeat.o(275456);
      return paramWxaAttributes;
    }
    if (paramWxaAttributes != null)
    {
      localObject = paramWxaAttributes.bLG();
      if (localObject == null) {}
    }
    for (Object localObject = ((WxaAttributes.c)localObject).obf;; localObject = null)
    {
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("checkGetWxaAttrsTimeoutStrategy, username:");
        if (paramWxaAttributes == null) {
          p.iCn();
        }
        Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", paramWxaAttributes.field_username + ", appId:" + paramWxaAttributes.field_appId + ", settings:" + a((WxaAttributes.c.a)localObject));
        if (localObject != null) {
          break;
        }
      }
      paramWxaAttributes = (c)ah.c.b.pWE;
      AppMethodBeat.o(275456);
      return paramWxaAttributes;
    }
    long l = ((WxaAttributes.c.a)localObject).obp;
    if (l <= 0L)
    {
      paramWxaAttributes = (c)ah.c.b.pWE;
      AppMethodBeat.o(275456);
      return paramWxaAttributes;
    }
    paramWxaAttributes = (c)new ah.c.a(l);
    AppMethodBeat.o(275456);
    return paramWxaAttributes;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "", "()V", "FallbackIfTimeout", "NoFallback", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$NoFallback;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$FallbackIfTimeout;", "plugin-appbrand-integration_release"})
  public static abstract class c
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$FallbackIfTimeout;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "timeoutMs", "", "(J)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
    public static final class a
      extends ah.c
    {
      public final long pWD;
      
      public a(long paramLong)
      {
        super();
        this.pWD = paramLong;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if (this.pWD != paramObject.pWD) {}
          }
        }
        else {
          return true;
        }
        return false;
      }
      
      public final int hashCode()
      {
        long l = this.pWD;
        return (int)(l ^ l >>> 32);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(277132);
        String str = "FallbackIfTimeout[" + this.pWD + "ms]";
        AppMethodBeat.o(277132);
        return str;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$NoFallback;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "()V", "toString", "", "plugin-appbrand-integration_release"})
    public static final class b
      extends ah.c
    {
      public static final b pWE;
      
      static
      {
        AppMethodBeat.i(282226);
        pWE = new b();
        AppMethodBeat.o(282226);
      }
      
      private b()
      {
        super();
      }
      
      public final String toString()
      {
        return "NoFallback";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ah
 * JD-Core Version:    0.7.0.1
 */