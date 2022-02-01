package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.bu;

public final class x$a
  implements cf.a
{
  private static final a jSQ;
  
  static
  {
    AppMethodBeat.i(44605);
    jSQ = new a();
    AppMethodBeat.o(44605);
  }
  
  public static void CA()
  {
    AppMethodBeat.i(44601);
    ((s)g.ad(s.class)).getSysCmdMsgExtension().a("UpdateWxaUsageListNotify", jSQ, true);
    AppMethodBeat.o(44601);
  }
  
  public static void unregister()
  {
    AppMethodBeat.i(44602);
    ((s)g.ad(s.class)).getSysCmdMsgExtension().b("UpdateWxaUsageListNotify", jSQ, true);
    AppMethodBeat.o(44602);
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(44603);
    parama = z.a(parama.gte.FNI);
    if (bu.isNullOrNil(parama))
    {
      AppMethodBeat.o(44603);
      return;
    }
    f.bCj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44600);
        x.a.No(parama);
        AppMethodBeat.o(44600);
      }
    });
    AppMethodBeat.o(44603);
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.x.a
 * JD-Core Version:    0.7.0.1
 */