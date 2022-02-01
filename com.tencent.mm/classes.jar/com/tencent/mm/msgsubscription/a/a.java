package com.tencent.mm.msgsubscription.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.msgsubscription.util.a.a;
import com.tencent.mm.msgsubscription.util.a.b;
import com.tencent.mm.msgsubscription.util.a.c;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import i.a.a.b;
import java.io.IOException;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/cgi/MMCompatNetworkDispatcher;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "()V", "TAG", "", "mapCompat2MMNetScene", "Ljava/util/WeakHashMap;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "cancel", "", "scene", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "checkIsValid", "", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toMMRepRespWrapper", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements a.a
{
  public static final a piE;
  private static final WeakHashMap<com.tencent.mm.msgsubscription.util.a, p> piF;
  
  static
  {
    AppMethodBeat.i(177282);
    piE = new a();
    piF = new WeakHashMap();
    AppMethodBeat.o(177282);
  }
  
  private static final void a(a.c paramc, a.b paramb, com.tencent.mm.msgsubscription.util.a parama, int paramInt1, int paramInt2, String paramString, c paramc1)
  {
    AppMethodBeat.i(236501);
    s.u(paramc, "$rr");
    s.u(parama, "$scene");
    parama = c.c.b(paramc1.otC);
    int i;
    if (parama == null) {
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {}
      try
      {
        paramc.bQq().parseFrom(c.c.b(paramc1.otC).toByteArray());
        if (paramb != null) {
          paramb.l(paramInt1, paramInt2, paramString);
        }
        AppMethodBeat.o(236501);
        return;
      }
      catch (IOException parama)
      {
        Log.e("MicroMsg.MMCompatNetworkDispatcher", "parseFrom mmrr uri=" + paramc.getUri() + ", e=" + parama);
        if (paramb == null) {
          break;
        }
        paramb.l(5, paramInt2, paramString);
        AppMethodBeat.o(236501);
        return;
      }
      catch (b parama)
      {
        Log.e("MicroMsg.MMCompatNetworkDispatcher", "parseFrom mmrr uri=" + paramc.getUri() + ", e=" + parama);
        if (paramb == null) {
          break label217;
        }
        paramb.l(paramInt1, paramInt2, paramString);
        AppMethodBeat.o(236501);
      }
      if (((parama instanceof esc)) && (((esc)parama).getBaseResponse() == null)) {
        i = 0;
      } else {
        i = 1;
      }
    }
    label217:
  }
  
  public static void a(com.tencent.mm.msgsubscription.util.a parama)
  {
    AppMethodBeat.i(177281);
    if (parama == null)
    {
      AppMethodBeat.o(177281);
      return;
    }
    synchronized (piF)
    {
      parama = (p)piF.get(parama);
      if (parama != null) {
        z.a(parama);
      }
      AppMethodBeat.o(177281);
      return;
    }
  }
  
  public final int a(a.c arg1, a.b paramb, com.tencent.mm.msgsubscription.util.a parama)
  {
    AppMethodBeat.i(177280);
    s.u(???, "rr");
    s.u(parama, "scene");
    c.a locala = new c.a();
    locala.otE = ((com.tencent.mm.bx.a)???.bQp());
    locala.otF = ((com.tencent.mm.bx.a)???.bQq());
    locala.uri = ???.getUri();
    locala.funcId = ???.getType();
    paramb = IPCRunCgi.a(locala.bEF(), new a..ExternalSyntheticLambda0(???, paramb, parama));
    if (paramb != null) {}
    synchronized (piF)
    {
      piF.put(parama, paramb);
      AppMethodBeat.o(177280);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.a.a
 * JD-Core Version:    0.7.0.1
 */