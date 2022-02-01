package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.utils.e;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.bt;

public final class x$a
  implements cd.a
{
  private static final a jPy;
  
  static
  {
    AppMethodBeat.i(44605);
    jPy = new a();
    AppMethodBeat.o(44605);
  }
  
  public static void Cx()
  {
    AppMethodBeat.i(44601);
    ((r)g.ad(r.class)).getSysCmdMsgExtension().a("UpdateWxaUsageListNotify", jPy, true);
    AppMethodBeat.o(44601);
  }
  
  public static void unregister()
  {
    AppMethodBeat.i(44602);
    ((r)g.ad(r.class)).getSysCmdMsgExtension().b("UpdateWxaUsageListNotify", jPy, true);
    AppMethodBeat.o(44602);
  }
  
  public final void a(final e.a parama)
  {
    AppMethodBeat.i(44603);
    parama = z.a(parama.gqE.Fvk);
    if (bt.isNullOrNil(parama))
    {
      AppMethodBeat.o(44603);
      return;
    }
    e.bBp().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(44600);
        x.a.MH(parama);
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