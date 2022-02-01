package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gw;
import com.tencent.mm.g.b.a.gx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c.a;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.m;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils;", "", "()V", "MissedAppPkgFailureTimestampsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$KEY;", "", "TAG", "", "UpdateNewWxaAttrsFailureTimestampMap", "WxaAttributesStore", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "checkGetWxaAttrsTimeoutStrategy", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "wxaAttributes", "checkIfUseBackupWxaAttrsForLaunchDirectly", "", "username", "appId", "checkLaunchTimeoutStrategy", "getCachedWxaAttributes", "getDynamicSettings", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaDynamicInfo$Setting;", "key", "reason", "allowReadDB", "isSwitchOn", "isUnderWeakNetwork", "markLaunchFailedByMissedAppPkg", "", "markLaunchFailedByUpdateWxaAttrs", "markLaunchSucceed", "removeWxaAttributesCache", "setWxaAttributesCache", "printFields", "KEY", "Reporter", "Strategy", "plugin-appbrand-integration_release"})
public final class av
{
  private static final ConcurrentHashMap<av.a, WxaAttributes> lOL;
  private static final ConcurrentHashMap<av.a, Long> lOM;
  private static final ConcurrentHashMap<av.a, Long> lON;
  public static final av lOO;
  
  static
  {
    AppMethodBeat.i(223583);
    lOO = new av();
    lOL = new ConcurrentHashMap();
    lOM = new ConcurrentHashMap();
    lON = new ConcurrentHashMap();
    AppMethodBeat.o(223583);
  }
  
  public static final WxaAttributes SA(String paramString)
  {
    AppMethodBeat.i(223573);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(223573);
      return null;
    }
    paramString = (WxaAttributes)lOL.get(new av.a.b(paramString));
    AppMethodBeat.o(223573);
    return paramString;
  }
  
  public static final c SB(String paramString)
  {
    AppMethodBeat.i(223577);
    if (!bsj())
    {
      paramString = (c)av.c.b.lOT;
      AppMethodBeat.o(223577);
      return paramString;
    }
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = (c)av.c.b.lOT;
      AppMethodBeat.o(223577);
      return paramString;
    }
    paramString = a((av.a)new av.a.a(paramString), "checkLaunchTimeoutStrategy", false);
    if (paramString == null)
    {
      paramString = (c)av.c.b.lOT;
      AppMethodBeat.o(223577);
      return paramString;
    }
    long l = paramString.kdf;
    if (l <= 0L)
    {
      paramString = (c)av.c.b.lOT;
      AppMethodBeat.o(223577);
      return paramString;
    }
    paramString = (c)new av.c.a(l);
    AppMethodBeat.o(223577);
    return paramString;
  }
  
  private static WxaAttributes.c.a a(av.a parama, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(223574);
    Object localObject = (WxaAttributes)lOL.get(parama);
    if (localObject != null)
    {
      localObject = ((WxaAttributes)localObject).beU();
      if (localObject != null)
      {
        WxaAttributes.c.a locala = ((WxaAttributes.c)localObject).kcY;
        localObject = locala;
        if (locala != null) {
          break label57;
        }
      }
    }
    if (paramBoolean)
    {
      localObject = j.aZl();
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
      ae.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "getDynamicSettings with key:" + parama + ", reason:" + paramString + ", get settings:" + a((WxaAttributes.c.a)localObject));
      AppMethodBeat.o(223574);
      return localObject;
      label110:
      if ((parama instanceof av.a.b)) {}
      for (localObject = ((w)localObject).d(((av.a.b)parama).value, new String[] { "dynamicInfo" });; localObject = ((w)localObject).e(((av.a.a)parama).value, new String[] { "dynamicInfo" }))
      {
        if (localObject == null) {
          break label188;
        }
        localObject = ((WxaAttributes)localObject).beU();
        if (localObject == null) {
          break;
        }
        localObject = ((WxaAttributes.c)localObject).kcY;
        break label57;
        if (!(parama instanceof av.a.a)) {
          break label190;
        }
      }
    }
    label190:
    parama = new m();
    AppMethodBeat.o(223574);
    throw parama;
    label205:
    AppMethodBeat.o(223574);
    return null;
  }
  
  private static String a(WxaAttributes.c.a parama)
  {
    AppMethodBeat.i(223575);
    parama = "{OpenWxaWaitUpdateMaxMicSec:" + parama.kdf + ", OpenWxaWaitUpdateMaxMicSecForWeakNet:" + parama.kdg + ", NextTryOpenWxaDisMicSec:" + parama.kdi + '}';
    AppMethodBeat.o(223575);
    return parama;
  }
  
  public static final boolean bsj()
  {
    AppMethodBeat.i(223576);
    boolean bool = ((b)g.ab(b.class)).a(b.a.qEK, false);
    AppMethodBeat.o(223576);
    return bool;
  }
  
  public static final void dN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223572);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        lOL.remove(new av.a.b(paramString1));
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
        lOL.remove(new av.a.a(paramString2));
      }
      AppMethodBeat.o(223572);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void dO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223578);
    long l = bu.fpO();
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        ((Map)lOM).put(new av.a.b(paramString1), Long.valueOf(l));
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
        ((Map)lOM).put(new av.a.a(paramString2), Long.valueOf(l));
      }
      AppMethodBeat.o(223578);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void dP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223579);
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        lOM.remove(new av.a.b(paramString1));
        lON.remove(new av.a.b(paramString1));
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
        lOM.remove(new av.a.a(paramString2));
        lON.remove(new av.a.a(paramString2));
      }
      AppMethodBeat.o(223579);
      return;
      i = 0;
      break;
    }
  }
  
  public static final void dQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223580);
    ae.e("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "markLaunchFailedByUpdateWxaAttrs, username:" + paramString1 + " appId:" + paramString2);
    long l = bu.fpO();
    CharSequence localCharSequence = (CharSequence)paramString1;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        ((Map)lON).put(new av.a.b(paramString1), Long.valueOf(l));
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
        ((Map)lON).put(new av.a.a(paramString2), Long.valueOf(l));
      }
      AppMethodBeat.o(223580);
      return;
      i = 0;
      break;
    }
  }
  
  public static final boolean dR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(223582);
    if (!bsj())
    {
      AppMethodBeat.o(223582);
      return false;
    }
    Object localObject = (CharSequence)paramString2;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString1 = (av.a)new av.a.a(paramString2);
      if (!lON.contains(paramString1)) {
        break label257;
      }
      paramString2 = a(paramString1, "[UpdateNewWxaAttrsFailure]", true);
      if (paramString2 != null) {
        break label147;
      }
      AppMethodBeat.o(223582);
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
    AppMethodBeat.o(223582);
    return false;
    label147:
    long l1 = paramString2.kdi;
    localObject = (Long)lON.remove(paramString1);
    paramString2 = (String)localObject;
    if (localObject == null) {
      paramString2 = Long.valueOf(0L);
    }
    p.g(paramString2, "UpdateNewWxaAttrsFailure…stampMap.remove(key) ?: 0");
    long l2 = paramString2.longValue();
    if (bu.fpO() - l2 <= l1)
    {
      ae.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkIfUseBackupWxaAttrsForLaunchDirectly by [UpdateNewWxaAttrsFailure] interval[" + l1 + "ms] lastFailureTimestamp[" + l2 + "] key[" + paramString1 + ']');
      AppMethodBeat.o(223582);
      return true;
    }
    label257:
    paramString2 = a(paramString1, "[MissedAppPkgFailure]", false);
    if (paramString2 == null)
    {
      AppMethodBeat.o(223582);
      return false;
    }
    l1 = paramString2.kdi;
    localObject = (Long)lOM.remove(paramString1);
    paramString2 = (String)localObject;
    if (localObject == null) {
      paramString2 = Long.valueOf(0L);
    }
    p.g(paramString2, "MissedAppPkgFailureTimestampsMap.remove(key) ?: 0");
    l2 = paramString2.longValue();
    ae.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", "checkIfUseBackupWxaAttrsForLaunchDirectly by [MissedAppPkgFailure] interval[" + l1 + "ms] lastFailureTimestamp[" + l2 + "] key[" + paramString1 + ']');
    if (bu.fpO() - l2 <= l1)
    {
      AppMethodBeat.o(223582);
      return true;
    }
    AppMethodBeat.o(223582);
    return false;
  }
  
  public static final void h(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(223571);
    p.h(paramWxaAttributes, "wxaAttributes");
    Map localMap = (Map)lOL;
    String str = paramWxaAttributes.field_username;
    p.g(str, "wxaAttributes.field_username");
    localMap.put(new av.a.b(str), paramWxaAttributes);
    localMap = (Map)lOL;
    str = paramWxaAttributes.field_appId;
    p.g(str, "wxaAttributes.field_appId");
    localMap.put(new av.a.a(str), paramWxaAttributes);
    AppMethodBeat.o(223571);
  }
  
  public static final c i(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(223581);
    if (!bsj())
    {
      paramWxaAttributes = (c)av.c.b.lOT;
      AppMethodBeat.o(223581);
      return paramWxaAttributes;
    }
    if (paramWxaAttributes != null)
    {
      localObject = paramWxaAttributes.beU();
      if (localObject == null) {}
    }
    for (Object localObject = ((WxaAttributes.c)localObject).kcY;; localObject = null)
    {
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder("checkGetWxaAttrsTimeoutStrategy, username:");
        if (paramWxaAttributes == null) {
          p.gkB();
        }
        ae.i("MicroMsg.AppBrand.LaunchTimeoutFallbackBackupWxaAttrUtils", paramWxaAttributes.field_username + ", appId:" + paramWxaAttributes.field_appId + ", settings:" + a((WxaAttributes.c.a)localObject));
        if (localObject != null) {
          break;
        }
      }
      paramWxaAttributes = (c)av.c.b.lOT;
      AppMethodBeat.o(223581);
      return paramWxaAttributes;
    }
    long l = ((WxaAttributes.c.a)localObject).kdf;
    if (l <= 0L)
    {
      paramWxaAttributes = (c)av.c.b.lOT;
      AppMethodBeat.o(223581);
      return paramWxaAttributes;
    }
    paramWxaAttributes = (c)new av.c.a(l);
    AppMethodBeat.o(223581);
    return paramWxaAttributes;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Reporter;", "", "()V", "FallbackActionReportFallbackSceneStore", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "FallbackActionReportStructStore", "Lcom/tencent/mm/autogen/mmdata/rpt/WAAppTaskVersionFallBackActionStruct;", "attachFallbackActionReportStruct", "", "instanceId", "reportStruct", "reportUpdateResultAfterVersionFallbackIfNeed", "updateSucceed", "", "updateCostTimeInMs", "", "setFallbackScene", "scene", "FallbackScene", "plugin-appbrand-integration_release"})
  public static final class b
  {
    private static final ConcurrentHashMap<String, gx> lOP;
    private static final ConcurrentHashMap<String, Integer> lOQ;
    public static final b lOR;
    
    static
    {
      AppMethodBeat.i(223568);
      lOR = new b();
      lOP = new ConcurrentHashMap();
      lOQ = new ConcurrentHashMap();
      AppMethodBeat.o(223568);
    }
    
    public static final void a(String paramString, gx paramgx)
    {
      AppMethodBeat.i(223565);
      p.h(paramString, "instanceId");
      p.h(paramgx, "reportStruct");
      ((Map)lOP).put(paramString, paramgx);
      AppMethodBeat.o(223565);
    }
    
    public static final void b(String paramString, boolean paramBoolean, long paramLong)
    {
      AppMethodBeat.i(223567);
      p.h(paramString, "instanceId");
      Object localObject = (gx)lOP.remove(paramString);
      if (localObject == null)
      {
        AppMethodBeat.o(223567);
        return;
      }
      p.g(localObject, "FallbackActionReportStru…ove(instanceId) ?: return");
      gw localgw = new gw();
      localgw.pY(((gx)localObject).getAppid());
      localgw.pZ(((gx)localObject).getUsername());
      localgw.qa(((gx)localObject).UF());
      localgw.mj(((gx)localObject).Uz());
      localgw.mk(((gx)localObject).UA());
      localgw.ml(((gx)localObject).UB());
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localgw.mm(i);
        localgw.mn(paramLong);
        localgw.mo(((gx)localObject).UC());
        localgw.qb(((gx)localObject).UD());
        localgw.mp(((gx)localObject).UE());
        localObject = (Integer)lOQ.remove(paramString);
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = Integer.valueOf(10000);
        }
        localgw.mq(paramString.intValue());
        localgw.aLH();
        AppMethodBeat.o(223567);
        return;
      }
    }
    
    public static final void bS(String paramString, int paramInt)
    {
      AppMethodBeat.i(223566);
      p.h(paramString, "instanceId");
      ((Map)lOQ).put(paramString, Integer.valueOf(paramInt));
      AppMethodBeat.o(223566);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "", "()V", "FallbackIfTimeout", "NoFallback", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$NoFallback;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$FallbackIfTimeout;", "plugin-appbrand-integration_release"})
  public static abstract class c
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$FallbackIfTimeout;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "timeoutMs", "", "(J)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "plugin-appbrand-integration_release"})
    public static final class a
      extends av.c
    {
      public final long lOS;
      
      public a(long paramLong)
      {
        super();
        this.lOS = paramLong;
      }
      
      public final boolean equals(Object paramObject)
      {
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if (this.lOS != paramObject.lOS) {}
          }
        }
        else {
          return true;
        }
        return false;
      }
      
      public final int hashCode()
      {
        long l = this.lOS;
        return (int)(l ^ l >>> 32);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(223569);
        String str = "FallbackIfTimeout[" + this.lOS + "ms]";
        AppMethodBeat.o(223569);
        return str;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy$NoFallback;", "Lcom/tencent/mm/plugin/appbrand/launching/LaunchTimeoutFallbackBackupWxaAttrUtils$Strategy;", "()V", "toString", "", "plugin-appbrand-integration_release"})
    public static final class b
      extends av.c
    {
      public static final b lOT;
      
      static
      {
        AppMethodBeat.i(223570);
        lOT = new b();
        AppMethodBeat.o(223570);
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