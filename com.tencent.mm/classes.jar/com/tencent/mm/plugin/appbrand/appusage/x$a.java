package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.bs;

public final class x$a
  implements cc.a
{
  private static final a jvE;
  
  static
  {
    AppMethodBeat.i(44605);
    jvE = new a();
    AppMethodBeat.o(44605);
  }
  
  public static void AY()
  {
    AppMethodBeat.i(44601);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("UpdateWxaUsageListNotify", jvE, true);
    AppMethodBeat.o(44601);
  }
  
  public static void unregister()
  {
    AppMethodBeat.i(44602);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("UpdateWxaUsageListNotify", jvE, true);
    AppMethodBeat.o(44602);
  }
  
  public final void a(final f.a parama)
  {
    AppMethodBeat.i(44603);
    parama = z.a(parama.fXi.DPV);
    if (bs.isNullOrNil(parama))
    {
      AppMethodBeat.o(44603);
      return;
    }
    e.bxj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44600);
        x.a.Jo(parama);
        AppMethodBeat.o(44600);
      }
    });
    AppMethodBeat.o(44603);
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.x.a
 * JD-Core Version:    0.7.0.1
 */