package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dqg;
import com.tencent.mm.protocal.protobuf.eum;
import com.tencent.mm.protocal.protobuf.gjz;
import com.tencent.mm.protocal.protobuf.gnd;
import com.tencent.mm.protocal.protobuf.gne;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d<-Lcom.tencent.mm.protocal.protobuf.gnd;>;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoRevokeRepository;", "", "()V", "TAG", "", "appId2CachedUsageInfoMap", "", "Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfo;", "getUsageInfo", "appId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectCachedUsageInfo", "", "usageInfo", "invalidateCachedUsageInfo", "revokeAppUseUserInfo", "scope", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revokePluginUseUserInfo", "pluginAppId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isValid", "", "Lcom/tencent/mm/protocal/protobuf/ScopeItem;", "Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfoItem;", "isValidState", "", "trimInvalidPart", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j ukr;
  private static final Map<String, gnd> uks;
  
  static
  {
    AppMethodBeat.i(322944);
    ukr = new j();
    uks = (Map)new HashMap();
    AppMethodBeat.o(322944);
  }
  
  private static boolean Ds(int paramInt)
  {
    return (paramInt == 0) || (1 == paramInt) || (7 == paramInt);
  }
  
  public static Object a(String paramString1, String paramString2, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(322932);
    Log.i("MicroMsg.AppBrand.UserInfoRevokeRepository", "revokeAppUseUserInfo, appId: " + paramString1 + ", scope: " + paramString2);
    if ((paramString1 == null) || (paramString2 == null))
    {
      paramString1 = ah.aiuX;
      AppMethodBeat.o(322932);
      return paramString1;
    }
    if (com.tencent.mm.plugin.appbrand.ui.privacy.b.uiA.cMs())
    {
      paramString1 = h.ukh.V(paramd);
      if (paramString1 == a.aiwj)
      {
        AppMethodBeat.o(322932);
        return paramString1;
      }
      paramString1 = ah.aiuX;
      AppMethodBeat.o(322932);
      return paramString1;
    }
    Object localObject = c.ujO;
    localObject = new dqg();
    ((dqg)localObject).appid = paramString1;
    ((dqg)localObject).aaWC = ((String)c.ujP);
    ((dqg)localObject).scope = paramString2;
    ((dqg)localObject).state = 7;
    paramString1 = ah.aiuX;
    paramString2 = c.a((dqg)localObject, paramd);
    paramString1 = paramString2;
    if (paramString2 != a.aiwj) {
      paramString1 = ah.aiuX;
    }
    if (paramString1 == a.aiwj)
    {
      AppMethodBeat.o(322932);
      return paramString1;
    }
    paramString1 = ah.aiuX;
    AppMethodBeat.o(322932);
    return paramString1;
  }
  
  public static void a(String paramString, gnd paramgnd)
  {
    AppMethodBeat.i(322884);
    Object localObject = com.tencent.mm.plugin.appbrand.ui.privacy.b.uiA;
    if (com.tencent.mm.plugin.appbrand.ui.privacy.b.getDEBUG())
    {
      StringBuilder localStringBuilder = new StringBuilder("injectCachedUsageInfo, appId: ").append(paramString).append(", usageInfo: ");
      if (paramgnd == null)
      {
        localObject = null;
        Log.d("MicroMsg.AppBrand.UserInfoRevokeRepository", localObject);
      }
    }
    for (;;)
    {
      if ((paramString != null) && (paramgnd != null)) {
        break label89;
      }
      AppMethodBeat.o(322884);
      return;
      localObject = paramgnd.toJSON();
      break;
      Log.i("MicroMsg.AppBrand.UserInfoRevokeRepository", s.X("injectCachedUsageInfo, appId: ", paramString));
    }
    label89:
    uks.put(paramString, paramgnd);
    AppMethodBeat.o(322884);
  }
  
  private static boolean a(eum parameum)
  {
    AppMethodBeat.i(322917);
    if (parameum == null)
    {
      AppMethodBeat.o(322917);
      return false;
    }
    CharSequence localCharSequence = (CharSequence)parameum.scope;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i == 0) && (Ds(parameum.state)); i = 0)
    {
      AppMethodBeat.o(322917);
      return true;
    }
    AppMethodBeat.o(322917);
    return false;
  }
  
  public static boolean a(gnd paramgnd)
  {
    AppMethodBeat.i(322907);
    if (paramgnd == null)
    {
      AppMethodBeat.o(322907);
      return false;
    }
    if (!a(paramgnd.acin))
    {
      AppMethodBeat.o(322907);
      return false;
    }
    Object localObject1 = paramgnd.acin;
    Object localObject3;
    Object localObject2;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject1 = ((gne)localObject1).acip;
      if (localObject1 != null)
      {
        localObject3 = (Iterable)localObject1;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          if (a((eum)localObject4)) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        localObject2 = (List)localObject2;
        ((LinkedList)localObject1).clear();
        ((LinkedList)localObject1).addAll((Collection)localObject2);
      }
    }
    localObject1 = paramgnd.acin;
    int i;
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((gne)localObject1).acip;
      if (localObject1 != null) {
        if (((Collection)localObject1).isEmpty())
        {
          i = 1;
          if (i != 0) {
            break label314;
          }
          k = 1;
          label194:
          localObject1 = paramgnd.acio;
          if (localObject1 == null) {
            break label324;
          }
          if (!((Collection)localObject1).isEmpty()) {
            break label319;
          }
          i = 1;
          label220:
          if (i != 0) {
            break label324;
          }
          i = 1;
        }
      }
    }
    label314:
    label319:
    label324:
    for (;;)
    {
      label226:
      if (i != 0)
      {
        paramgnd = paramgnd.acio;
        if (paramgnd == null) {
          break label579;
        }
        localObject2 = (Iterable)paramgnd;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (a((gne)localObject3))
            {
              ((Collection)localObject1).add(localObject3);
              continue;
              i = 0;
              break;
              k = 0;
              break label194;
              i = 0;
              break label220;
              i = 0;
              break label226;
            }
          }
        }
        localObject1 = (List)localObject1;
        paramgnd.clear();
        paramgnd.addAll((Collection)localObject1);
        paramgnd = ((Iterable)paramgnd).iterator();
        i = 0;
        j = i;
        if (!paramgnd.hasNext()) {
          break label554;
        }
        localObject1 = (gne)paramgnd.next();
        if (localObject1 != null)
        {
          localObject2 = ((gne)localObject1).acip;
          if (localObject2 != null)
          {
            localObject4 = (Iterable)localObject2;
            localObject3 = (Collection)new ArrayList();
            localObject4 = ((Iterable)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              Object localObject5 = ((Iterator)localObject4).next();
              if (a((eum)localObject5)) {
                ((Collection)localObject3).add(localObject5);
              }
            }
            localObject3 = (List)localObject3;
            ((LinkedList)localObject2).clear();
            ((LinkedList)localObject2).addAll((Collection)localObject3);
          }
        }
        if (localObject1 != null)
        {
          localObject1 = ((gne)localObject1).acip;
          if (localObject1 != null) {
            if (((Collection)localObject1).isEmpty())
            {
              j = 1;
              if (j != 0) {
                break label547;
              }
            }
          }
        }
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label576;
          }
          i = 1;
          break;
          j = 0;
          break label527;
        }
      }
    }
    label527:
    label547:
    label554:
    label576:
    label579:
    for (int j = 0;; j = 0)
    {
      if ((k != 0) || (j != 0))
      {
        AppMethodBeat.o(322907);
        return true;
      }
      AppMethodBeat.o(322907);
      return false;
      break;
    }
  }
  
  private static boolean a(gne paramgne)
  {
    AppMethodBeat.i(322914);
    if (paramgne == null)
    {
      AppMethodBeat.o(322914);
      return false;
    }
    paramgne = (CharSequence)paramgne.appid;
    if ((paramgne == null) || (paramgne.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(322914);
      return true;
    }
    AppMethodBeat.o(322914);
    return false;
  }
  
  public static void agn(String paramString)
  {
    AppMethodBeat.i(322890);
    Log.i("MicroMsg.AppBrand.UserInfoRevokeRepository", s.X("invalidateCachedUsageInfo, appId: ", paramString));
    if (paramString == null)
    {
      AppMethodBeat.o(322890);
      return;
    }
    uks.remove(paramString);
    AppMethodBeat.o(322890);
  }
  
  public static Object c(String paramString1, String paramString2, String paramString3, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(322937);
    Log.i("MicroMsg.AppBrand.UserInfoRevokeRepository", "revokePluginUseUserInfo, appId: " + paramString1 + ", pluginAppId: " + paramString2 + ", scope: " + paramString3);
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null))
    {
      paramString1 = ah.aiuX;
      AppMethodBeat.o(322937);
      return paramString1;
    }
    if (com.tencent.mm.plugin.appbrand.ui.privacy.b.uiA.cMs())
    {
      paramString1 = h.ukh.V(paramd);
      if (paramString1 == a.aiwj)
      {
        AppMethodBeat.o(322937);
        return paramString1;
      }
      paramString1 = ah.aiuX;
      AppMethodBeat.o(322937);
      return paramString1;
    }
    Object localObject = c.ujO;
    localObject = new dqg();
    ((dqg)localObject).appid = paramString1;
    ((dqg)localObject).aaWC = paramString2;
    ((dqg)localObject).scope = paramString3;
    ((dqg)localObject).state = 7;
    paramString1 = ah.aiuX;
    paramString2 = c.a((dqg)localObject, paramd);
    paramString1 = paramString2;
    if (paramString2 != a.aiwj) {
      paramString1 = ah.aiuX;
    }
    if (paramString1 == a.aiwj)
    {
      AppMethodBeat.o(322937);
      return paramString1;
    }
    paramString1 = ah.aiuX;
    AppMethodBeat.o(322937);
    return paramString1;
  }
  
  public final Object i(String paramString, kotlin.d.d<? super gnd> paramd)
  {
    AppMethodBeat.i(322953);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super gnd>)localObject1;; paramd = new a(this, paramd))
    {
      localObject1 = paramd.result;
      localObject2 = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(322953);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Log.i("MicroMsg.AppBrand.UserInfoRevokeRepository", s.X("getUsageInfo, appId: ", paramString));
    Object localObject1 = (gnd)uks.get(paramString);
    if (localObject1 != null)
    {
      Log.i("MicroMsg.AppBrand.UserInfoRevokeRepository", "getUsageInfo, cache hit");
      AppMethodBeat.o(322953);
      return localObject1;
    }
    localObject1 = b.ujN;
    paramd.L$0 = paramString;
    paramd.label = 1;
    localObject1 = b.h(paramString, paramd);
    paramd = (kotlin.d.d<? super gnd>)localObject1;
    if (localObject1 == localObject2)
    {
      AppMethodBeat.o(322953);
      return localObject2;
      paramString = (String)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
      paramd = (kotlin.d.d<? super gnd>)localObject1;
    }
    localObject1 = (gjz)paramd;
    if (com.tencent.mm.plugin.appbrand.ui.privacy.b.uiA.cMs())
    {
      localObject2 = h.ukh;
      h.a(null, (gjz)localObject1);
    }
    paramd = ((gjz)paramd).acfV;
    if (paramd == null) {}
    for (paramString = null; paramString == null; paramString = paramd)
    {
      paramString = new IOException("use_user_info is null");
      AppMethodBeat.o(322953);
      throw paramString;
      uks.put(paramString, paramd);
    }
    AppMethodBeat.o(322953);
    return paramString;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(j paramj, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(322903);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ukt.i(null, (kotlin.d.d)this);
      AppMethodBeat.o(322903);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.j
 * JD-Core Version:    0.7.0.1
 */