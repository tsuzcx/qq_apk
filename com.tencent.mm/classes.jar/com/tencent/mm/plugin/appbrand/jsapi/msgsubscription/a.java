package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.util.a.c;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.g.b.p;
import d.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/CompatNetSceneDispatcherDefaultAdapter;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "()V", "TAG", "", "mapWxaUsername2Appid", "Ljava/util/concurrent/ConcurrentHashMap;", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "setWxaUsername2Appid", "", "wxaUsername", "appid", "luggage-wechat-full-sdk_release"})
public final class a
  implements com.tencent.mm.msgsubscription.util.a.a
{
  private static final ConcurrentHashMap<String, String> lai;
  public static final a laj;
  
  static
  {
    AppMethodBeat.i(169632);
    laj = new a();
    lai = new ConcurrentHashMap();
    AppMethodBeat.o(169632);
  }
  
  public static void dm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169631);
    p.h(paramString1, "wxaUsername");
    p.h(paramString2, "appid");
    ((Map)lai).put(paramString1, paramString2);
    AppMethodBeat.o(169631);
  }
  
  public final int a(a.c paramc, final com.tencent.mm.msgsubscription.util.a.b paramb, final com.tencent.mm.msgsubscription.util.a parama)
  {
    AppMethodBeat.i(169630);
    p.h(paramc, "rr");
    p.h(parama, "scene");
    com.tencent.mm.plugin.appbrand.networking.c localc = (com.tencent.mm.plugin.appbrand.networking.c)e.K(com.tencent.mm.plugin.appbrand.networking.c.class);
    if (localc == null)
    {
      AppMethodBeat.o(169630);
      return -1;
    }
    lai.get(((b)parama).username);
    localc.a(paramc.getUri(), (com.tencent.mm.bw.a)paramc.aOV(), paramc.aOW().getClass()).a((d.b)new a(paramc, paramb, parama)).a((d.a)new b(paramb, parama));
    AppMethodBeat.o(169630);
    return 0;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "kotlin.jvm.PlatformType", "onTerminate"})
  static final class a<T>
    implements d.b
  {
    a(a.c paramc, com.tencent.mm.msgsubscription.util.a.b paramb, com.tencent.mm.msgsubscription.util.a parama) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "err", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class b<T>
    implements d.a<Object>
  {
    b(com.tencent.mm.msgsubscription.util.a.b paramb, com.tencent.mm.msgsubscription.util.a parama) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(169629);
      if (paramObject != null) {}
      for (paramObject = paramObject.toString();; paramObject = null)
      {
        com.tencent.mm.msgsubscription.util.a.b localb = this.iDG;
        if (localb == null) {
          break;
        }
        localb.k(1, -1, paramObject);
        AppMethodBeat.o(169629);
        return;
      }
      AppMethodBeat.o(169629);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.a
 * JD-Core Version:    0.7.0.1
 */