package com.tencent.mm.msgsubscription.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.msgsubscription.util.a.b;
import com.tencent.mm.msgsubscription.util.a.c;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import g.a.a.b;
import java.io.IOException;
import java.util.WeakHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/cgi/MMCompatNetworkDispatcher;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "()V", "TAG", "", "mapCompat2MMNetScene", "Ljava/util/WeakHashMap;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "cancel", "", "scene", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "checkIsValid", "", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toMMRepRespWrapper", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "plugin-comm_release"})
public final class a
  implements com.tencent.mm.msgsubscription.util.a.a
{
  private static final WeakHashMap<com.tencent.mm.msgsubscription.util.a, q> jzh;
  public static final a jzi;
  
  static
  {
    AppMethodBeat.i(177282);
    jzi = new a();
    jzh = new WeakHashMap();
    AppMethodBeat.o(177282);
  }
  
  public static void a(com.tencent.mm.msgsubscription.util.a parama)
  {
    AppMethodBeat.i(177281);
    if (parama == null)
    {
      AppMethodBeat.o(177281);
      return;
    }
    synchronized (jzh)
    {
      parama = (q)jzh.get(parama);
      if (parama != null) {
        aa.a(parama);
      }
      AppMethodBeat.o(177281);
      return;
    }
  }
  
  public final int a(a.c arg1, final a.b paramb, final com.tencent.mm.msgsubscription.util.a parama)
  {
    AppMethodBeat.i(177280);
    p.h(???, "rr");
    p.h(parama, "scene");
    d.a locala = new d.a();
    locala.c((com.tencent.mm.bw.a)???.bjh());
    locala.d((com.tencent.mm.bw.a)???.bji());
    locala.MB(???.getUri());
    locala.sG(???.getType());
    paramb = IPCRunCgi.a(locala.aXF(), (IPCRunCgi.a)new a(???, paramb, parama));
    if (paramb != null) {}
    synchronized (jzh)
    {
      jzh.put(parama, paramb);
      AppMethodBeat.o(177280);
      return 0;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "mmrr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(a.c paramc, a.b paramb, com.tencent.mm.msgsubscription.util.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
    {
      AppMethodBeat.i(177279);
      a locala = a.jzi;
      p.g(paramd, "mmrr");
      if (a.f(paramd.aYK())) {}
      try
      {
        this.jzj.bji().parseFrom(paramd.aYK().toByteArray());
        paramd = paramb;
        if (paramd != null)
        {
          paramd.k(paramInt1, paramInt2, paramString);
          AppMethodBeat.o(177279);
          return;
        }
      }
      catch (IOException paramd)
      {
        Log.e("MicroMsg.MMCompatNetworkDispatcher", "parseFrom mmrr uri=" + this.jzj.getUri() + ", e=" + paramd);
        paramd = paramb;
        if (paramd != null)
        {
          paramd.k(5, paramInt2, paramString);
          AppMethodBeat.o(177279);
          return;
        }
        AppMethodBeat.o(177279);
        return;
      }
      catch (b paramd)
      {
        Log.e("MicroMsg.MMCompatNetworkDispatcher", "parseFrom mmrr uri=" + this.jzj.getUri() + ", e=" + paramd);
        paramd = paramb;
        if (paramd != null)
        {
          paramd.k(paramInt1, paramInt2, paramString);
          AppMethodBeat.o(177279);
          return;
        }
        AppMethodBeat.o(177279);
        return;
      }
      AppMethodBeat.o(177279);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.a.a
 * JD-Core Version:    0.7.0.1
 */