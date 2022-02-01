package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qy;
import com.tencent.mm.autogen.mmdata.rpt.qz;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bv;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c.a;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.af;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils;", "", "()V", "MissedAppPkgFailureTimestampsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "", "TAG", "", "UpdateNewWxaAttrsFailureTimestampMap", "WxaAttributesStore", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "checkGetWxaAttrsTimeoutStrategy", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "wxaAttributes", "checkIfUseBackupWxaAttrsForLaunchDirectly", "", "username", "appId", "checkLaunchTimeoutStrategy", "enterPath", "clearLaunchFailedTimestamp", "", "getCachedWxaAttributes", "getDynamicSettings", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaDynamicInfo$Setting;", "key", "reason", "allowReadDB", "isSwitchOn", "isUnderWeakNetwork", "markLaunchFailedByMissedAppPkg", "markLaunchFailedByUpdateWxaAttrs", "removeWxaAttributesCache", "setWxaAttributesCache", "printFields", "KEY", "Reporter", "Strategy", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
{
  public static final ai tbl;
  private static final ConcurrentHashMap<ai.a, WxaAttributes> tbm;
  private static final ConcurrentHashMap<ai.a, Long> tbn;
  private static final ConcurrentHashMap<ai.a, Long> tbo;
  
  static
  {
    AppMethodBeat.i(320804);
    tbl = new ai();
    tbm = new ConcurrentHashMap();
    tbn = new ConcurrentHashMap();
    tbo = new ConcurrentHashMap();
    AppMethodBeat.o(320804);
  }
  
  private static WxaAttributes.c.a a(ai.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(320741);
    Object localObject1 = (WxaAttributes)tbm.get(parama);
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (!paramBoolean) {
          break label168;
        }
        localObject1 = n.cfc();
        if (localObject1 == null) {
          break label168;
        }
        if (!(parama instanceof ai.a.b)) {
          break label122;
        }
        localObject1 = ((af)localObject1).d(((ai.a.b)parama).value, new String[] { "dynamicInfo" });
        label69:
        if (localObject1 == null) {
          break label168;
        }
        localObject1 = ((WxaAttributes)localObject1).cle();
        if (localObject1 == null) {
          break label168;
        }
      }
    }
    label168:
    for (Object localObject2 = ((WxaAttributes.c)localObject1).rbR;; localObject2 = null)
    {
      if (localObject2 != null) {
        break label174;
      }
      AppMethodBeat.o(320741);
      return null;
      localObject1 = ((WxaAttributes)localObject1).cle();
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((WxaAttributes.c)localObject1).rbR;
      break;
      label122:
      if ((parama instanceof ai.a.a))
      {
        localObject1 = ((af)localObject1).e(((ai.a.a)parama).value, new String[] { "dynamicInfo" });
        break label69;
      }
      parama = new p();
      AppMethodBeat.o(320741);
      throw parama;
    }
    label174:
    Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "getDynamicSettings with key:" + parama + ", reason:" + paramString + ", get settings:" + a((WxaAttributes.c.a)localObject2));
    AppMethodBeat.o(320741);
    return localObject2;
  }
  
  private static String a(WxaAttributes.c.a parama)
  {
    AppMethodBeat.i(320751);
    parama = "{OpenWxaWaitUpdateMaxMicSec:" + parama.rcb + ", OpenWxaWaitUpdateMaxMicSecForWeakNet:" + parama.rcc + ", NextTryOpenWxaDisMicSec:" + parama.rce + '}';
    AppMethodBeat.o(320751);
    return parama;
  }
  
  public static final WxaAttributes ade(String paramString)
  {
    AppMethodBeat.i(320732);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320732);
      return null;
    }
    paramString = (WxaAttributes)tbm.get(new ai.a.b(paramString));
    AppMethodBeat.o(320732);
    return paramString;
  }
  
  public static final boolean cAo()
  {
    AppMethodBeat.i(320756);
    boolean bool = ((c)h.ax(c.class)).a(c.a.yTZ, false);
    AppMethodBeat.o(320756);
    return bool;
  }
  
  public static final void eH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(320720);
    Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "removeWxaAttributesCache(username:" + paramString1 + ", appId:" + paramString2 + ')');
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        tbm.remove(new ai.a.b(paramString1));
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
        tbm.remove(new ai.a.a(paramString2));
      }
      AppMethodBeat.o(320720);
      return;
      i = 0;
      break;
    }
  }
  
  public static final ai.c eI(String paramString1, String paramString2)
  {
    int j = 1;
    boolean bool1 = true;
    AppMethodBeat.i(320764);
    if (!cAo())
    {
      paramString1 = (ai.c)ai.c.b.tbt;
      AppMethodBeat.o(320764);
      return paramString1;
    }
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString1 = (ai.c)ai.c.b.tbt;
      AppMethodBeat.o(320764);
      return paramString1;
    }
    localObject = ((aa)n.ag(aa.class)).e(paramString1, new String[] { "versionInfo", "appInfo" });
    if (localObject != null) {}
    for (boolean bool2 = true; localObject == null; bool2 = false)
    {
      bool1 = false;
      Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkLaunchTimeoutStrategy appId:" + paramString1 + " isBackupExisted:" + bool2 + " isBackupCodePkgExisted:" + bool1);
      if ((bool2) && (bool1)) {
        break label361;
      }
      paramString1 = (ai.c)ai.c.b.tbt;
      AppMethodBeat.o(320764);
      return paramString1;
    }
    for (;;)
    {
      try
      {
        if (((WxaAttributes)localObject).cld().aqJ()) {
          break;
        }
        CharSequence localCharSequence = (CharSequence)paramString2;
        i = j;
        if (localCharSequence != null)
        {
          if (localCharSequence.length() != 0) {
            break label445;
          }
          i = j;
        }
        if (i != 0)
        {
          bool1 = ((bv)h.ax(bv.class)).bz(paramString1, ((WxaAttributes)localObject).clf().appVersion);
          break;
        }
        bool1 = ((bv)h.ax(bv.class)).r(paramString1, ((WxaAttributes)localObject).clf().appVersion, paramString2);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder("checkLaunchTimeoutStrategy, appId:").append(paramString1).append(", enterPath:");
        localObject = paramString2;
        if (paramString2 == null) {
          localObject = "";
        }
        Log.e("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", (String)localObject + ", check PageIndex get failed by " + localException);
        bool1 = false;
      }
      break;
      label361:
      paramString1 = a((ai.a)new ai.a.a(paramString1), "checkLaunchTimeoutStrategy", false);
      if (paramString1 == null)
      {
        paramString1 = (ai.c)ai.c.b.tbt;
        AppMethodBeat.o(320764);
        return paramString1;
      }
      long l = paramString1.rcb;
      if (l <= 0L)
      {
        paramString1 = (ai.c)ai.c.b.tbt;
        AppMethodBeat.o(320764);
        return paramString1;
      }
      paramString1 = (ai.c)new ai.c.a(l);
      AppMethodBeat.o(320764);
      return paramString1;
      label445:
      i = 0;
    }
  }
  
  public static final void eJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(320769);
    long l = Util.nowMilliSecond();
    Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "markLaunchFailedByMissedAppPkg(username:" + paramString1 + ", appId:" + paramString2 + ") ts:" + l);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        ((Map)tbn).put(new ai.a.b(paramString1), Long.valueOf(l));
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
        ((Map)tbn).put(new ai.a.a(paramString2), Long.valueOf(l));
      }
      AppMethodBeat.o(320769);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void eK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(320778);
    Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "clearLaunchFailedTimestamp(username:" + paramString1 + ", appId:" + paramString2 + ')');
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        tbn.remove(new ai.a.b(paramString1));
        tbo.remove(new ai.a.b(paramString1));
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
        tbn.remove(new ai.a.a(paramString2));
        tbo.remove(new ai.a.a(paramString2));
      }
      AppMethodBeat.o(320778);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void eL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(320784);
    Log.e("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "markLaunchFailedByUpdateWxaAttrs, username:" + paramString1 + " appId:" + paramString2);
    long l = Util.nowMilliSecond();
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        ((Map)tbo).put(new ai.a.b(paramString1), Long.valueOf(l));
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
        ((Map)tbo).put(new ai.a.a(paramString2), Long.valueOf(l));
      }
      AppMethodBeat.o(320784);
      return;
      i = 0;
      break;
    }
  }
  
  public static final boolean eM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(320800);
    if (!cAo())
    {
      AppMethodBeat.o(320800);
      return false;
    }
    Object localObject = (CharSequence)paramString2;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString1 = (ai.a)new ai.a.a(paramString2);
      if (!tbo.contains(paramString1)) {
        break label253;
      }
      paramString2 = a(paramString1, "[UpdateNewWxaAttrsFailure]", true);
      if (paramString2 != null) {
        break label147;
      }
      AppMethodBeat.o(320800);
      return false;
    }
    paramString2 = (CharSequence)paramString1;
    if ((paramString2 == null) || (paramString2.length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label139;
      }
      paramString1 = (ai.a)new ai.a.b(paramString1);
      break;
    }
    label139:
    AppMethodBeat.o(320800);
    return false;
    label147:
    long l1 = paramString2.rce;
    localObject = (Long)tbo.remove(paramString1);
    paramString2 = (String)localObject;
    if (localObject == null) {
      paramString2 = Long.valueOf(0L);
    }
    long l2 = ((Number)paramString2).longValue();
    if (Util.nowMilliSecond() - l2 <= l1)
    {
      Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkIfUseBackupWxaAttrsForLaunchDirectly by [UpdateNewWxaAttrsFailure] interval[" + l1 + "ms] lastFailureTimestamp[" + l2 + "] key[" + paramString1 + ']');
      AppMethodBeat.o(320800);
      return true;
    }
    label253:
    paramString2 = a(paramString1, "[MissedAppPkgFailure]", false);
    if (paramString2 == null)
    {
      AppMethodBeat.o(320800);
      return false;
    }
    l1 = paramString2.rce;
    localObject = (Long)tbn.remove(paramString1);
    paramString2 = (String)localObject;
    if (localObject == null) {
      paramString2 = Long.valueOf(0L);
    }
    l2 = ((Number)paramString2).longValue();
    Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkIfUseBackupWxaAttrsForLaunchDirectly by [MissedAppPkgFailure] interval[" + l1 + "ms] lastFailureTimestamp[" + l2 + "] key[" + paramString1 + ']');
    if (Util.nowMilliSecond() - l2 <= l1)
    {
      AppMethodBeat.o(320800);
      return true;
    }
    AppMethodBeat.o(320800);
    return false;
  }
  
  public static final void j(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(320711);
    s.u(paramWxaAttributes, "wxaAttributes");
    Map localMap = (Map)tbm;
    String str = paramWxaAttributes.field_username;
    s.s(str, "wxaAttributes.field_username");
    localMap.put(new ai.a.b(str), paramWxaAttributes);
    localMap = (Map)tbm;
    str = paramWxaAttributes.field_appId;
    s.s(str, "wxaAttributes.field_appId");
    localMap.put(new ai.a.a(str), paramWxaAttributes);
    AppMethodBeat.o(320711);
  }
  
  public static final ai.c k(WxaAttributes paramWxaAttributes)
  {
    StringBuilder localStringBuilder = null;
    AppMethodBeat.i(320790);
    if (!cAo())
    {
      paramWxaAttributes = (ai.c)ai.c.b.tbt;
      AppMethodBeat.o(320790);
      return paramWxaAttributes;
    }
    Object localObject;
    if (paramWxaAttributes == null)
    {
      localObject = null;
      if (localObject != null) {
        break label84;
      }
    }
    for (paramWxaAttributes = localStringBuilder;; paramWxaAttributes = (WxaAttributes)localObject)
    {
      if (paramWxaAttributes != null) {
        break label147;
      }
      paramWxaAttributes = (ai.c)ai.c.b.tbt;
      AppMethodBeat.o(320790);
      return paramWxaAttributes;
      localObject = paramWxaAttributes.cle();
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = ((WxaAttributes.c)localObject).rbR;
      break;
      label84:
      localStringBuilder = new StringBuilder("checkGetWxaAttrsTimeoutStrategy, username:");
      s.checkNotNull(paramWxaAttributes);
      Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", paramWxaAttributes.field_username + ", appId:" + paramWxaAttributes.field_appId + ", settings:" + a((WxaAttributes.c.a)localObject));
    }
    label147:
    long l = paramWxaAttributes.rcb;
    if (l <= 0L)
    {
      paramWxaAttributes = (ai.c)ai.c.b.tbt;
      AppMethodBeat.o(320790);
      return paramWxaAttributes;
    }
    paramWxaAttributes = (ai.c)new ai.c.a(l);
    AppMethodBeat.o(320790);
    return paramWxaAttributes;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Reporter;", "", "()V", "FallbackActionReportFallbackSceneStore", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "FallbackActionReportStructStore", "Lcom/tencent/mm/autogen/mmdata/rpt/WAAppTaskVersionFallBackActionStruct;", "attachFallbackActionReportStruct", "", "instanceId", "reportStruct", "reportUpdateResultAfterVersionFallbackIfNeed", "updateSucceed", "", "updateCostTimeInMs", "", "setFallbackScene", "scene", "FallbackScene", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final b tbp;
    private static final ConcurrentHashMap<String, qz> tbq;
    private static final ConcurrentHashMap<String, Integer> tbr;
    
    static
    {
      AppMethodBeat.i(320906);
      tbp = new b();
      tbq = new ConcurrentHashMap();
      tbr = new ConcurrentHashMap();
      AppMethodBeat.o(320906);
    }
    
    public static final void a(String paramString, qz paramqz)
    {
      AppMethodBeat.i(320886);
      s.u(paramString, "instanceId");
      s.u(paramqz, "reportStruct");
      ((Map)tbq).put(paramString, paramqz);
      AppMethodBeat.o(320886);
    }
    
    public static final void b(String paramString, boolean paramBoolean, long paramLong)
    {
      AppMethodBeat.i(320904);
      s.u(paramString, "instanceId");
      Object localObject = (qz)tbq.remove(paramString);
      if (localObject == null)
      {
        AppMethodBeat.o(320904);
        return;
      }
      qy localqy = new qy();
      localqy.ilL = localqy.F("Appid", ((qz)localObject).ilL, true);
      localqy.imU = localqy.F("Username", ((qz)localObject).imU, true);
      localqy.ilM = localqy.F("InstanceId", ((qz)localObject).ilM, true);
      localqy.juq = ((qz)localObject).juq;
      localqy.jur = ((qz)localObject).jur;
      localqy.jus = ((qz)localObject).jus;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localqy.jut = i;
        localqy.juu = paramLong;
        localqy.juv = ((qz)localObject).juy;
        localqy.ijV = localqy.F("NetType", ((qz)localObject).ijV, true);
        localqy.juw = ((qz)localObject).juw;
        localObject = (Integer)tbr.remove(paramString);
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = Integer.valueOf(10000);
        }
        localqy.jux = paramString.intValue();
        localqy.bMH();
        AppMethodBeat.o(320904);
        return;
      }
    }
    
    public static final void cS(String paramString, int paramInt)
    {
      AppMethodBeat.i(320891);
      s.u(paramString, "instanceId");
      ((Map)tbr).put(paramString, Integer.valueOf(paramInt));
      AppMethodBeat.o(320891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ai
 * JD-Core Version:    0.7.0.1
 */