package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kl;
import com.tencent.mm.g.b.a.km;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
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
import kotlin.m;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils;", "", "()V", "MissedAppPkgFailureTimestampsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "", "TAG", "", "UpdateNewWxaAttrsFailureTimestampMap", "WxaAttributesStore", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "checkGetWxaAttrsTimeoutStrategy", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "wxaAttributes", "checkIfUseBackupWxaAttrsForLaunchDirectly", "", "username", "appId", "checkLaunchTimeoutStrategy", "getCachedWxaAttributes", "getDynamicSettings", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaDynamicInfo$Setting;", "key", "reason", "allowReadDB", "isSwitchOn", "isUnderWeakNetwork", "markLaunchFailedByMissedAppPkg", "", "markLaunchFailedByUpdateWxaAttrs", "markLaunchSucceed", "removeWxaAttributesCache", "setWxaAttributesCache", "printFields", "KEY", "Reporter", "Strategy", "plugin-appbrand-integration_release"})
public final class an
{
  private static final ConcurrentHashMap<an.a, WxaAttributes> mVT;
  private static final ConcurrentHashMap<an.a, Long> mVU;
  private static final ConcurrentHashMap<an.a, Long> mVV;
  public static final an mVW;
  
  static
  {
    AppMethodBeat.i(228724);
    mVW = new an();
    mVT = new ConcurrentHashMap();
    mVU = new ConcurrentHashMap();
    mVV = new ConcurrentHashMap();
    AppMethodBeat.o(228724);
  }
  
  private static WxaAttributes.c.a a(an.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(228715);
    Object localObject = (WxaAttributes)mVT.get(parama);
    if (localObject != null)
    {
      localObject = ((WxaAttributes)localObject).bAo();
      if (localObject != null)
      {
        WxaAttributes.c.a locala = ((WxaAttributes.c)localObject).lgD;
        localObject = locala;
        if (locala != null) {
          break label57;
        }
      }
    }
    if (paramBoolean)
    {
      localObject = n.buC();
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
      AppMethodBeat.o(228715);
      return localObject;
      label110:
      if ((parama instanceof an.a.b)) {}
      for (localObject = ((z)localObject).d(((an.a.b)parama).value, new String[] { "dynamicInfo" });; localObject = ((z)localObject).e(((an.a.a)parama).value, new String[] { "dynamicInfo" }))
      {
        if (localObject == null) {
          break label188;
        }
        localObject = ((WxaAttributes)localObject).bAo();
        if (localObject == null) {
          break;
        }
        localObject = ((WxaAttributes.c)localObject).lgD;
        break label57;
        if (!(parama instanceof an.a.a)) {
          break label190;
        }
      }
    }
    label190:
    parama = new m();
    AppMethodBeat.o(228715);
    throw parama;
    label205:
    AppMethodBeat.o(228715);
    return null;
  }
  
  private static String a(WxaAttributes.c.a parama)
  {
    AppMethodBeat.i(228716);
    parama = "{OpenWxaWaitUpdateMaxMicSec:" + parama.lgK + ", OpenWxaWaitUpdateMaxMicSecForWeakNet:" + parama.lgL + ", NextTryOpenWxaDisMicSec:" + parama.lgN + '}';
    AppMethodBeat.o(228716);
    return parama;
  }
  
  public static final WxaAttributes ace(String paramString)
  {
    AppMethodBeat.i(228714);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228714);
      return null;
    }
    paramString = (WxaAttributes)mVT.get(new an.a.b(paramString));
    AppMethodBeat.o(228714);
    return paramString;
  }
  
  public static final c acf(String paramString)
  {
    AppMethodBeat.i(228718);
    if (!bNJ())
    {
      paramString = (c)an.c.b.mWb;
      AppMethodBeat.o(228718);
      return paramString;
    }
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = (c)an.c.b.mWb;
      AppMethodBeat.o(228718);
      return paramString;
    }
    if (((v)n.W(v.class)).e(paramString, new String[] { "nickname" }) != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkLaunchTimeoutStrategy appId:" + paramString + " isBackupExisted:" + bool);
      if (bool) {
        break;
      }
      paramString = (c)an.c.b.mWb;
      AppMethodBeat.o(228718);
      return paramString;
    }
    paramString = a((an.a)new an.a.a(paramString), "checkLaunchTimeoutStrategy", false);
    if (paramString == null)
    {
      paramString = (c)an.c.b.mWb;
      AppMethodBeat.o(228718);
      return paramString;
    }
    long l = paramString.lgK;
    if (l <= 0L)
    {
      paramString = (c)an.c.b.mWb;
      AppMethodBeat.o(228718);
      return paramString;
    }
    paramString = (c)new an.c.a(l);
    AppMethodBeat.o(228718);
    return paramString;
  }
  
  public static final boolean bNJ()
  {
    AppMethodBeat.i(228717);
    boolean bool = ((b)g.af(b.class)).a(b.a.rXT, false);
    AppMethodBeat.o(228717);
    return bool;
  }
  
  public static final void ee(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228713);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        mVT.remove(new an.a.b(paramString1));
      }
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label96;
      }
    }
    label96:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        mVT.remove(new an.a.a(paramString2));
      }
      AppMethodBeat.o(228713);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void ef(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228719);
    long l = Util.nowMilliSecond();
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        ((Map)mVU).put(new an.a.b(paramString1), Long.valueOf(l));
      }
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label121;
      }
    }
    label121:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((Map)mVU).put(new an.a.a(paramString2), Long.valueOf(l));
      }
      AppMethodBeat.o(228719);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void eg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228720);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        mVU.remove(new an.a.b(paramString1));
        mVV.remove(new an.a.b(paramString1));
      }
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label126;
      }
    }
    label126:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        mVU.remove(new an.a.a(paramString2));
        mVV.remove(new an.a.a(paramString2));
      }
      AppMethodBeat.o(228720);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void eh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228721);
    Log.e("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "markLaunchFailedByUpdateWxaAttrs, username:" + paramString1 + " appId:" + paramString2);
    long l = Util.nowMilliSecond();
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        ((Map)mVV).put(new an.a.b(paramString1), Long.valueOf(l));
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
        ((Map)mVV).put(new an.a.a(paramString2), Long.valueOf(l));
      }
      AppMethodBeat.o(228721);
      return;
      i = 0;
      break;
    }
  }
  
  public static final boolean ei(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228723);
    if (!bNJ())
    {
      AppMethodBeat.o(228723);
      return false;
    }
    Object localObject = (CharSequence)paramString2;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString1 = (an.a)new an.a.a(paramString2);
      if (!mVV.contains(paramString1)) {
        break label257;
      }
      paramString2 = a(paramString1, "[UpdateNewWxaAttrsFailure]", true);
      if (paramString2 != null) {
        break label147;
      }
      AppMethodBeat.o(228723);
      return false;
    }
    paramString2 = (CharSequence)paramString1;
    if ((paramString2 == null) || (paramString2.length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label139;
      }
      paramString1 = (an.a)new an.a.b(paramString1);
      break;
    }
    label139:
    AppMethodBeat.o(228723);
    return false;
    label147:
    long l1 = paramString2.lgN;
    localObject = (Long)mVV.remove(paramString1);
    paramString2 = (String)localObject;
    if (localObject == null) {
      paramString2 = Long.valueOf(0L);
    }
    p.g(paramString2, "UpdateNewWxaAttrsFailure…stampMap.remove(key) ?: 0");
    long l2 = paramString2.longValue();
    if (Util.nowMilliSecond() - l2 <= l1)
    {
      Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkIfUseBackupWxaAttrsForLaunchDirectly by [UpdateNewWxaAttrsFailure] interval[" + l1 + "ms] lastFailureTimestamp[" + l2 + "] key[" + paramString1 + ']');
      AppMethodBeat.o(228723);
      return true;
    }
    label257:
    paramString2 = a(paramString1, "[MissedAppPkgFailure]", false);
    if (paramString2 == null)
    {
      AppMethodBeat.o(228723);
      return false;
    }
    l1 = paramString2.lgN;
    localObject = (Long)mVU.remove(paramString1);
    paramString2 = (String)localObject;
    if (localObject == null) {
      paramString2 = Long.valueOf(0L);
    }
    p.g(paramString2, "MissedAppPkgFailureTimestampsMap.remove(key) ?: 0");
    l2 = paramString2.longValue();
    Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkIfUseBackupWxaAttrsForLaunchDirectly by [MissedAppPkgFailure] interval[" + l1 + "ms] lastFailureTimestamp[" + l2 + "] key[" + paramString1 + ']');
    if (Util.nowMilliSecond() - l2 <= l1)
    {
      AppMethodBeat.o(228723);
      return true;
    }
    AppMethodBeat.o(228723);
    return false;
  }
  
  public static final void h(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(228712);
    p.h(paramWxaAttributes, "wxaAttributes");
    Map localMap = (Map)mVT;
    String str = paramWxaAttributes.field_username;
    p.g(str, "wxaAttributes.field_username");
    localMap.put(new an.a.b(str), paramWxaAttributes);
    localMap = (Map)mVT;
    str = paramWxaAttributes.field_appId;
    p.g(str, "wxaAttributes.field_appId");
    localMap.put(new an.a.a(str), paramWxaAttributes);
    AppMethodBeat.o(228712);
  }
  
  public static final c i(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(228722);
    if (!bNJ())
    {
      paramWxaAttributes = (c)an.c.b.mWb;
      AppMethodBeat.o(228722);
      return paramWxaAttributes;
    }
    if (paramWxaAttributes != null)
    {
      localObject = paramWxaAttributes.bAo();
      if (localObject == null) {}
    }
    for (Object localObject = ((WxaAttributes.c)localObject).lgD;; localObject = null)
    {
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("checkGetWxaAttrsTimeoutStrategy, username:");
        if (paramWxaAttributes == null) {
          p.hyc();
        }
        Log.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", paramWxaAttributes.field_username + ", appId:" + paramWxaAttributes.field_appId + ", settings:" + a((WxaAttributes.c.a)localObject));
        if (localObject != null) {
          break;
        }
      }
      paramWxaAttributes = (c)an.c.b.mWb;
      AppMethodBeat.o(228722);
      return paramWxaAttributes;
    }
    long l = ((WxaAttributes.c.a)localObject).lgK;
    if (l <= 0L)
    {
      paramWxaAttributes = (c)an.c.b.mWb;
      AppMethodBeat.o(228722);
      return paramWxaAttributes;
    }
    paramWxaAttributes = (c)new an.c.a(l);
    AppMethodBeat.o(228722);
    return paramWxaAttributes;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Reporter;", "", "()V", "FallbackActionReportFallbackSceneStore", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "FallbackActionReportStructStore", "Lcom/tencent/mm/autogen/mmdata/rpt/WAAppTaskVersionFallBackActionStruct;", "attachFallbackActionReportStruct", "", "instanceId", "reportStruct", "reportUpdateResultAfterVersionFallbackIfNeed", "updateSucceed", "", "updateCostTimeInMs", "", "setFallbackScene", "scene", "FallbackScene", "plugin-appbrand-integration_release"})
  public static final class b
  {
    private static final ConcurrentHashMap<String, km> mVX;
    private static final ConcurrentHashMap<String, Integer> mVY;
    public static final b mVZ;
    
    static
    {
      AppMethodBeat.i(228709);
      mVZ = new b();
      mVX = new ConcurrentHashMap();
      mVY = new ConcurrentHashMap();
      AppMethodBeat.o(228709);
    }
    
    public static final void a(String paramString, km paramkm)
    {
      AppMethodBeat.i(228706);
      p.h(paramString, "instanceId");
      p.h(paramkm, "reportStruct");
      ((Map)mVX).put(paramString, paramkm);
      AppMethodBeat.o(228706);
    }
    
    public static final void b(String paramString, boolean paramBoolean, long paramLong)
    {
      AppMethodBeat.i(228708);
      p.h(paramString, "instanceId");
      Object localObject = (km)mVX.remove(paramString);
      if (localObject == null)
      {
        AppMethodBeat.o(228708);
        return;
      }
      p.g(localObject, "FallbackActionReportStru…ove(instanceId) ?: return");
      kl localkl = new kl();
      localkl.xK(((km)localObject).getAppid());
      localkl.xL(((km)localObject).getUsername());
      localkl.xM(((km)localObject).aiv());
      localkl.tC(((km)localObject).aip());
      localkl.tD(((km)localObject).aiq());
      localkl.tE(((km)localObject).air());
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localkl.tF(i);
        localkl.tG(paramLong);
        localkl.tH(((km)localObject).ais());
        localkl.xN(((km)localObject).ait());
        localkl.tI(((km)localObject).aiu());
        localObject = (Integer)mVY.remove(paramString);
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = Integer.valueOf(10000);
        }
        localkl.tJ(paramString.intValue());
        localkl.bfK();
        AppMethodBeat.o(228708);
        return;
      }
    }
    
    public static final void bV(String paramString, int paramInt)
    {
      AppMethodBeat.i(228707);
      p.h(paramString, "instanceId");
      ((Map)mVY).put(paramString, Integer.valueOf(paramInt));
      AppMethodBeat.o(228707);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "", "()V", "FallbackIfTimeout", "NoFallback", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$NoFallback;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$FallbackIfTimeout;", "plugin-appbrand-integration_release"})
  public static abstract class c
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$FallbackIfTimeout;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "timeoutMs", "", "(J)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
    public static final class a
      extends an.c
    {
      public final long mWa;
      
      public a(long paramLong)
      {
        super();
        this.mWa = paramLong;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if (this.mWa != paramObject.mWa) {}
          }
        }
        else {
          return true;
        }
        return false;
      }
      
      public final int hashCode()
      {
        long l = this.mWa;
        return (int)(l ^ l >>> 32);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(228710);
        String str = "FallbackIfTimeout[" + this.mWa + "ms]";
        AppMethodBeat.o(228710);
        return str;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$NoFallback;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "()V", "toString", "", "plugin-appbrand-integration_release"})
    public static final class b
      extends an.c
    {
      public static final b mWb;
      
      static
      {
        AppMethodBeat.i(228711);
        mWb = new b();
        AppMethodBeat.o(228711);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.an
 * JD-Core Version:    0.7.0.1
 */