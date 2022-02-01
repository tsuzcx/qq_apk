package com.tencent.mm.msgsubscription.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.msgsubscription.util.a.b;
import com.tencent.mm.msgsubscription.util.a.c;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.io.IOException;
import java.util.WeakHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/cgi/MMCompatNetworkDispatcher;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "()V", "TAG", "", "mapCompat2MMNetScene", "Ljava/util/WeakHashMap;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "cancel", "", "scene", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "checkIsValid", "", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toMMRepRespWrapper", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "plugin-comm_release"})
public final class a
  implements com.tencent.mm.msgsubscription.util.a.a
{
  private static final WeakHashMap<com.tencent.mm.msgsubscription.util.a, n> ihq;
  public static final a ihr;
  
  static
  {
    AppMethodBeat.i(177282);
    ihr = new a();
    ihq = new WeakHashMap();
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
    synchronized (ihq)
    {
      parama = (n)ihq.get(parama);
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
    k.h(???, "rr");
    k.h(parama, "scene");
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bw.a)???.aLo());
    locala.d((com.tencent.mm.bw.a)???.aLp());
    locala.Am(???.getUri());
    locala.op(???.getType());
    paramb = IPCRunCgi.a(locala.aAz(), (IPCRunCgi.a)new a(???, paramb, parama));
    if (paramb != null) {}
    synchronized (ihq)
    {
      ihq.put(parama, paramb);
      AppMethodBeat.o(177280);
      return 0;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "mmrr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    a(a.c paramc, a.b paramb, com.tencent.mm.msgsubscription.util.a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(177279);
      a locala = a.ihr;
      k.g(paramb, "mmrr");
      if (a.f(paramb.aBD())) {}
      try
      {
        this.ihs.aLp().parseFrom(paramb.aBD().toByteArray());
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
        ac.e("MicroMsg.MMCompatNetworkDispatcher", "parseFrom mmrr uri=" + this.ihs.getUri() + ", e=" + paramb);
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
        ac.e("MicroMsg.MMCompatNetworkDispatcher", "parseFrom mmrr uri=" + this.ihs.getUri() + ", e=" + paramb);
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