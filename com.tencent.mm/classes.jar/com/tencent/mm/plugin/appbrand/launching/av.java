package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gu;
import com.tencent.mm.g.b.a.gv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c.a;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.m;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils;", "", "()V", "MissedAppPkgFailureTimestampsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "", "TAG", "", "UpdateNewWxaAttrsFailureTimestampMap", "WxaAttributesStore", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "checkGetWxaAttrsTimeoutStrategy", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "wxaAttributes", "checkIfUseBackupWxaAttrsForLaunchDirectly", "", "username", "appId", "checkLaunchTimeoutStrategy", "getCachedWxaAttributes", "getDynamicSettings", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaDynamicInfo$Setting;", "key", "reason", "allowReadDB", "isSwitchOn", "isUnderWeakNetwork", "markLaunchFailedByMissedAppPkg", "", "markLaunchFailedByUpdateWxaAttrs", "markLaunchSucceed", "removeWxaAttributesCache", "setWxaAttributesCache", "printFields", "KEY", "Reporter", "Strategy", "plugin-appbrand-integration_release"})
public final class av
{
  private static final ConcurrentHashMap<av.a, WxaAttributes> lKl;
  private static final ConcurrentHashMap<av.a, Long> lKm;
  private static final ConcurrentHashMap<av.a, Long> lKn;
  public static final av lKo;
  
  static
  {
    AppMethodBeat.i(189324);
    lKo = new av();
    lKl = new ConcurrentHashMap();
    lKm = new ConcurrentHashMap();
    lKn = new ConcurrentHashMap();
    AppMethodBeat.o(189324);
  }
  
  public static final WxaAttributes RR(String paramString)
  {
    AppMethodBeat.i(189314);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(189314);
      return null;
    }
    paramString = (WxaAttributes)lKl.get(new av.a.b(paramString));
    AppMethodBeat.o(189314);
    return paramString;
  }
  
  public static final c RS(String paramString)
  {
    AppMethodBeat.i(189318);
    if (!bry())
    {
      paramString = (c)av.c.b.lKs;
      AppMethodBeat.o(189318);
      return paramString;
    }
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = (c)av.c.b.lKs;
      AppMethodBeat.o(189318);
      return paramString;
    }
    paramString = a((av.a)new av.a.a(paramString), "checkLaunchTimeoutStrategy", false);
    if (paramString == null)
    {
      paramString = (c)av.c.b.lKs;
      AppMethodBeat.o(189318);
      return paramString;
    }
    long l = paramString.jZO;
    if (l <= 0L)
    {
      paramString = (c)av.c.b.lKs;
      AppMethodBeat.o(189318);
      return paramString;
    }
    paramString = (c)new av.c.a(l);
    AppMethodBeat.o(189318);
    return paramString;
  }
  
  private static WxaAttributes.c.a a(av.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189315);
    Object localObject = (WxaAttributes)lKl.get(parama);
    if (localObject != null)
    {
      localObject = ((WxaAttributes)localObject).bem();
      if (localObject != null)
      {
        WxaAttributes.c.a locala = ((WxaAttributes.c)localObject).jZH;
        localObject = locala;
        if (locala != null) {
          break label57;
        }
      }
    }
    if (paramBoolean)
    {
      localObject = j.aYP();
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
      ad.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "getDynamicSettings with key:" + parama + ", reason:" + paramString + ", get settings:" + a((WxaAttributes.c.a)localObject));
      AppMethodBeat.o(189315);
      return localObject;
      label110:
      if ((parama instanceof av.a.b)) {}
      for (localObject = ((w)localObject).d(((av.a.b)parama).value, new String[] { "dynamicInfo" });; localObject = ((w)localObject).e(((av.a.a)parama).value, new String[] { "dynamicInfo" }))
      {
        if (localObject == null) {
          break label188;
        }
        localObject = ((WxaAttributes)localObject).bem();
        if (localObject == null) {
          break;
        }
        localObject = ((WxaAttributes.c)localObject).jZH;
        break label57;
        if (!(parama instanceof av.a.a)) {
          break label190;
        }
      }
    }
    label190:
    parama = new m();
    AppMethodBeat.o(189315);
    throw parama;
    label205:
    AppMethodBeat.o(189315);
    return null;
  }
  
  private static String a(WxaAttributes.c.a parama)
  {
    AppMethodBeat.i(189316);
    parama = "{OpenWxaWaitUpdateMaxMicSec:" + parama.jZO + ", OpenWxaWaitUpdateMaxMicSecForWeakNet:" + parama.jZP + ", NextTryOpenWxaDisMicSec:" + parama.jZR + '}';
    AppMethodBeat.o(189316);
    return parama;
  }
  
  public static final boolean bry()
  {
    AppMethodBeat.i(189317);
    boolean bool = ((b)g.ab(b.class)).a(b.a.qxE, false);
    AppMethodBeat.o(189317);
    return bool;
  }
  
  public static final void dL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189313);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        lKl.remove(new av.a.b(paramString1));
      }
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label94;
      }
    }
    label94:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        lKl.remove(new av.a.a(paramString2));
      }
      AppMethodBeat.o(189313);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void dM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189319);
    long l = bt.flT();
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        ((Map)lKm).put(new av.a.b(paramString1), Long.valueOf(l));
      }
      paramString1 = (CharSequence)paramString2;
      if ((paramString1 != null) && (paramString1.length() != 0)) {
        break label119;
      }
    }
    label119:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((Map)lKm).put(new av.a.a(paramString2), Long.valueOf(l));
      }
      AppMethodBeat.o(189319);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void dN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189320);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        lKm.remove(new av.a.b(paramString1));
        lKn.remove(new av.a.b(paramString1));
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
        lKm.remove(new av.a.a(paramString2));
        lKn.remove(new av.a.a(paramString2));
      }
      AppMethodBeat.o(189320);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void dO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189321);
    ad.e("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "markLaunchFailedByUpdateWxaAttrs, username:" + paramString1 + " appId:" + paramString2);
    long l = bt.flT();
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        ((Map)lKn).put(new av.a.b(paramString1), Long.valueOf(l));
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
        ((Map)lKn).put(new av.a.a(paramString2), Long.valueOf(l));
      }
      AppMethodBeat.o(189321);
      return;
      i = 0;
      break;
    }
  }
  
  public static final boolean dP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189323);
    if (!bry())
    {
      AppMethodBeat.o(189323);
      return false;
    }
    Object localObject = (CharSequence)paramString2;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString1 = (av.a)new av.a.a(paramString2);
      if (!lKn.contains(paramString1)) {
        break label257;
      }
      paramString2 = a(paramString1, "[UpdateNewWxaAttrsFailure]", true);
      if (paramString2 != null) {
        break label147;
      }
      AppMethodBeat.o(189323);
      return false;
    }
    paramString2 = (CharSequence)paramString1;
    if ((paramString2 == null) || (paramString2.length() == 0)) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label139;
      }
      paramString1 = (av.a)new av.a.b(paramString1);
      break;
    }
    label139:
    AppMethodBeat.o(189323);
    return false;
    label147:
    long l1 = paramString2.jZR;
    localObject = (Long)lKn.remove(paramString1);
    paramString2 = (String)localObject;
    if (localObject == null) {
      paramString2 = Long.valueOf(0L);
    }
    p.g(paramString2, "UpdateNewWxaAttrsFailure…stampMap.remove(key) ?: 0");
    long l2 = paramString2.longValue();
    if (bt.flT() - l2 <= l1)
    {
      ad.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkIfUseBackupWxaAttrsForLaunchDirectly by [UpdateNewWxaAttrsFailure] interval[" + l1 + "ms] lastFailureTimestamp[" + l2 + "] key[" + paramString1 + ']');
      AppMethodBeat.o(189323);
      return true;
    }
    label257:
    paramString2 = a(paramString1, "[MissedAppPkgFailure]", false);
    if (paramString2 == null)
    {
      AppMethodBeat.o(189323);
      return false;
    }
    l1 = paramString2.jZR;
    localObject = (Long)lKm.remove(paramString1);
    paramString2 = (String)localObject;
    if (localObject == null) {
      paramString2 = Long.valueOf(0L);
    }
    p.g(paramString2, "MissedAppPkgFailureTimestampsMap.remove(key) ?: 0");
    l2 = paramString2.longValue();
    ad.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkIfUseBackupWxaAttrsForLaunchDirectly by [MissedAppPkgFailure] interval[" + l1 + "ms] lastFailureTimestamp[" + l2 + "] key[" + paramString1 + ']');
    if (bt.flT() - l2 <= l1)
    {
      AppMethodBeat.o(189323);
      return true;
    }
    AppMethodBeat.o(189323);
    return false;
  }
  
  public static final void h(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(189312);
    p.h(paramWxaAttributes, "wxaAttributes");
    Map localMap = (Map)lKl;
    String str = paramWxaAttributes.field_username;
    p.g(str, "wxaAttributes.field_username");
    localMap.put(new av.a.b(str), paramWxaAttributes);
    localMap = (Map)lKl;
    str = paramWxaAttributes.field_appId;
    p.g(str, "wxaAttributes.field_appId");
    localMap.put(new av.a.a(str), paramWxaAttributes);
    AppMethodBeat.o(189312);
  }
  
  public static final c i(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(189322);
    if (!bry())
    {
      paramWxaAttributes = (c)av.c.b.lKs;
      AppMethodBeat.o(189322);
      return paramWxaAttributes;
    }
    if (paramWxaAttributes != null)
    {
      localObject = paramWxaAttributes.bem();
      if (localObject == null) {}
    }
    for (Object localObject = ((WxaAttributes.c)localObject).jZH;; localObject = null)
    {
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("checkGetWxaAttrsTimeoutStrategy, username:");
        if (paramWxaAttributes == null) {
          p.gfZ();
        }
        ad.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", paramWxaAttributes.field_username + ", appId:" + paramWxaAttributes.field_appId + ", settings:" + a((WxaAttributes.c.a)localObject));
        if (localObject != null) {
          break;
        }
      }
      paramWxaAttributes = (c)av.c.b.lKs;
      AppMethodBeat.o(189322);
      return paramWxaAttributes;
    }
    long l = ((WxaAttributes.c.a)localObject).jZO;
    if (l <= 0L)
    {
      paramWxaAttributes = (c)av.c.b.lKs;
      AppMethodBeat.o(189322);
      return paramWxaAttributes;
    }
    paramWxaAttributes = (c)new av.c.a(l);
    AppMethodBeat.o(189322);
    return paramWxaAttributes;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Reporter;", "", "()V", "FallbackActionReportStructStore", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/autogen/mmdata/rpt/WAAppTaskVersionFallBackActionStruct;", "attachFallbackActionReportStruct", "", "instanceId", "reportStruct", "reportUpdateResultAfterVersionFallbackIfNeed", "updateSucceed", "", "updateCostTimeInMs", "", "plugin-appbrand-integration_release"})
  public static final class b
  {
    private static final ConcurrentHashMap<String, gv> lKp;
    public static final b lKq;
    
    static
    {
      AppMethodBeat.i(189309);
      lKq = new b();
      lKp = new ConcurrentHashMap();
      AppMethodBeat.o(189309);
    }
    
    public static final void a(String paramString, gv paramgv)
    {
      AppMethodBeat.i(189307);
      p.h(paramString, "instanceId");
      p.h(paramgv, "reportStruct");
      ((Map)lKp).put(paramString, paramgv);
      AppMethodBeat.o(189307);
    }
    
    public static final void b(String paramString, boolean paramBoolean, long paramLong)
    {
      AppMethodBeat.i(189308);
      p.h(paramString, "instanceId");
      paramString = (gv)lKp.remove(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(189308);
        return;
      }
      p.g(paramString, "FallbackActionReportStru…ove(instanceId) ?: return");
      gu localgu = new gu();
      localgu.pD(paramString.getAppid());
      localgu.pE(paramString.getUsername());
      localgu.pF(paramString.Uz());
      localgu.lY(paramString.Ut());
      localgu.lZ(paramString.Uu());
      localgu.ma(paramString.Uv());
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localgu.mb(i);
        localgu.mc(paramLong);
        localgu.md(paramString.Uw());
        localgu.pG(paramString.Ux());
        localgu.me(paramString.Uy());
        localgu.aLk();
        AppMethodBeat.o(189308);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "", "()V", "FallbackIfTimeout", "NoFallback", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$NoFallback;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$FallbackIfTimeout;", "plugin-appbrand-integration_release"})
  public static abstract class c
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$FallbackIfTimeout;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "timeoutMs", "", "(J)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
    public static final class a
      extends av.c
    {
      public final long lKr;
      
      public a(long paramLong)
      {
        super();
        this.lKr = paramLong;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if (this.lKr != paramObject.lKr) {}
          }
        }
        else {
          return true;
        }
        return false;
      }
      
      public final int hashCode()
      {
        long l = this.lKr;
        return (int)(l ^ l >>> 32);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(189310);
        String str = "FallbackIfTimeout[" + this.lKr + "ms]";
        AppMethodBeat.o(189310);
        return str;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$NoFallback;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "()V", "toString", "", "plugin-appbrand-integration_release"})
    public static final class b
      extends av.c
    {
      public static final b lKs;
      
      static
      {
        AppMethodBeat.i(189311);
        lKs = new b();
        AppMethodBeat.o(189311);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.av
 * JD-Core Version:    0.7.0.1
 */