package com.tencent.mm.msgsubscription.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.msgsubscription.util.a.b;
import com.tencent.mm.msgsubscription.util.a.c;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.WeakHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/cgi/MMCompatNetworkDispatcher;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "()V", "TAG", "", "mapCompat2MMNetScene", "Ljava/util/WeakHashMap;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "cancel", "", "scene", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "checkIsValid", "", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toMMRepRespWrapper", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "plugin-comm_release"})
public final class a
  implements com.tencent.mm.msgsubscription.util.a.a
{
  private static final WeakHashMap<com.tencent.mm.msgsubscription.util.a, n> iDD;
  public static final a iDE;
  
  static
  {
    AppMethodBeat.i(177282);
    iDE = new a();
    iDD = new WeakHashMap();
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
    synchronized (iDD)
    {
      parama = (n)iDD.get(parama);
      if (parama != null) {
        x.a(parama);
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
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bw.a)???.aOV());
    locala.d((com.tencent.mm.bw.a)???.aOW());
    locala.DN(???.getUri());
    locala.oS(???.getType());
    paramb = IPCRunCgi.a(locala.aDS(), (IPCRunCgi.a)new a(???, paramb, parama));
    if (paramb != null) {}
    synchronized (iDD)
    {
      iDD.put(parama, paramb);
      AppMethodBeat.o(177280);
      return 0;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "mmrr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(a.c paramc, a.b paramb, com.tencent.mm.msgsubscription.util.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(177279);
      a locala = a.iDE;
      p.g(paramb, "mmrr");
      if (a.f(paramb.aEV())) {}
      try
      {
        this.iDF.aOW().parseFrom(paramb.aEV().toByteArray());
        paramb = paramb;
        if (paramb != null)
        {
          paramb.k(paramInt1, paramInt2, paramString);
          AppMethodBeat.o(177279);
          return;
        }
      }
      catch (IOException paramb)
      {
        ae.e("MicroMsg.MMCompatNetworkDispatcher", "parseFrom mmrr uri=" + this.iDF.getUri() + ", e=" + paramb);
        paramb = paramb;
        if (paramb != null)
        {
          paramb.k(5, paramInt2, paramString);
          AppMethodBeat.o(177279);
          return;
        }
        AppMethodBeat.o(177279);
        return;
      }
      catch (f.a.a.b paramb)
      {
        ae.e("MicroMsg.MMCompatNetworkDispatcher", "parseFrom mmrr uri=" + this.iDF.getUri() + ", e=" + paramb);
        paramb = paramb;
        if (paramb != null)
        {
          paramb.k(paramInt1, paramInt2, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.a.a
 * JD-Core Version:    0.7.0.1
 */