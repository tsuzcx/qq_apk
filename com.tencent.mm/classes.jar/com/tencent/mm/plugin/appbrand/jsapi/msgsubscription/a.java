package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.util.a.c;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/CompatNetSceneDispatcherDefaultAdapter;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "()V", "TAG", "", "mapWxaUsername2Appid", "Ljava/util/concurrent/ConcurrentHashMap;", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "setWxaUsername2Appid", "", "wxaUsername", "appid", "luggage-wechat-full-sdk_release"})
public final class a
  implements com.tencent.mm.msgsubscription.util.a.a
{
  private static final ConcurrentHashMap<String, String> mfv;
  public static final a mfw;
  
  static
  {
    AppMethodBeat.i(169632);
    mfw = new a();
    mfv = new ConcurrentHashMap();
    AppMethodBeat.o(169632);
  }
  
  public static void dB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169631);
    p.h(paramString1, "wxaUsername");
    p.h(paramString2, "appid");
    ((Map)mfv).put(paramString1, paramString2);
    AppMethodBeat.o(169631);
  }
  
  public final int a(a.c paramc, final com.tencent.mm.msgsubscription.util.a.b paramb, final com.tencent.mm.msgsubscription.util.a parama)
  {
    AppMethodBeat.i(169630);
    p.h(paramc, "rr");
    p.h(parama, "scene");
    com.tencent.mm.plugin.appbrand.networking.c localc = (com.tencent.mm.plugin.appbrand.networking.c)e.M(com.tencent.mm.plugin.appbrand.networking.c.class);
    if (localc == null)
    {
      AppMethodBeat.o(169630);
      return -1;
    }
    mfv.get(((b)parama).username);
    localc.a(paramc.getUri(), (com.tencent.mm.bw.a)paramc.bjh(), paramc.bji().getClass()).a((d.b)new a(paramc, paramb, parama)).a((d.a)new b(paramb, parama));
    AppMethodBeat.o(169630);
    return 0;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "kotlin.jvm.PlatformType", "onTerminate"})
  static final class a<T>
    implements d.b
  {
    a(a.c paramc, com.tencent.mm.msgsubscription.util.a.b paramb, com.tencent.mm.msgsubscription.util.a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "err", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class b<T>
    implements d.a<Object>
  {
    b(com.tencent.mm.msgsubscription.util.a.b paramb, com.tencent.mm.msgsubscription.util.a parama) {}
    
    public final void cn(Object paramObject)
    {
      AppMethodBeat.i(169629);
      if (paramObject != null) {}
      for (paramObject = paramObject.toString();; paramObject = null)
      {
        com.tencent.mm.msgsubscription.util.a.b localb = this.jzk;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.a
 * JD-Core Version:    0.7.0.1
 */