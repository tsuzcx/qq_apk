package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.util.a.b;
import com.tencent.mm.msgsubscription.util.a.c;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.vending.g.d;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/CompatNetSceneDispatcherDefaultAdapter;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "()V", "TAG", "", "mapWxaUsername2Appid", "Ljava/util/concurrent/ConcurrentHashMap;", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "setWxaUsername2Appid", "", "wxaUsername", "appid", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.msgsubscription.util.a.a
{
  public static final a siO;
  private static final ConcurrentHashMap<String, String> siP;
  
  static
  {
    AppMethodBeat.i(169632);
    siO = new a();
    siP = new ConcurrentHashMap();
    AppMethodBeat.o(169632);
  }
  
  private static final void a(a.b paramb, com.tencent.mm.msgsubscription.util.a parama, Object paramObject)
  {
    AppMethodBeat.i(326309);
    s.u(parama, "$scene");
    if (paramObject == null) {}
    for (parama = null;; parama = paramObject.toString())
    {
      if (paramb != null) {
        paramb.l(1, -1, parama);
      }
      AppMethodBeat.o(326309);
      return;
    }
  }
  
  private static final void e(kotlin.g.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(326306);
    s.u(paramb, "$tmp0");
    paramb.invoke(paramObject);
    AppMethodBeat.o(326306);
  }
  
  public static void ef(String paramString1, String paramString2)
  {
    AppMethodBeat.i(169631);
    s.u(paramString1, "wxaUsername");
    s.u(paramString2, "appid");
    ((Map)siP).put(paramString1, paramString2);
    AppMethodBeat.o(169631);
  }
  
  public final int a(a.c paramc, final a.b paramb, final com.tencent.mm.msgsubscription.util.a parama)
  {
    AppMethodBeat.i(169630);
    s.u(paramc, "rr");
    s.u(parama, "scene");
    com.tencent.mm.plugin.appbrand.networking.c localc = (com.tencent.mm.plugin.appbrand.networking.c)e.T(com.tencent.mm.plugin.appbrand.networking.c.class);
    if (localc == null)
    {
      AppMethodBeat.o(169630);
      return -1;
    }
    siP.get(((com.tencent.mm.msgsubscription.a.b)parama).username);
    localc.a(paramc.getUri(), (com.tencent.mm.bx.a)paramc.bQp(), paramc.bQq().getClass()).a(new a..ExternalSyntheticLambda1((kotlin.g.a.b)new a(paramc, paramb, parama))).a(new a..ExternalSyntheticLambda0(paramb, parama));
    AppMethodBeat.o(169630);
    return 0;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<esc, ah>
  {
    a(a.c paramc, a.b paramb, com.tencent.mm.msgsubscription.util.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.a
 * JD-Core Version:    0.7.0.1
 */