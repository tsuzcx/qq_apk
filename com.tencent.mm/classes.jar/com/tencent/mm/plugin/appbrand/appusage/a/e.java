package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"runOnWorkThread", "", "action", "Lkotlin/Function0;", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final void am(a<ah> parama)
  {
    AppMethodBeat.i(50331);
    s.u(parama, "action");
    o.cNm().postToWorker(new e..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(50331);
  }
  
  private static final void an(a parama)
  {
    AppMethodBeat.i(319358);
    s.u(parama, "$action");
    parama.invoke();
    AppMethodBeat.o(319358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.e
 * JD-Core Version:    0.7.0.1
 */