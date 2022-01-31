package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandPrepareTask$a$1$1
  implements i.a
{
  AppBrandPrepareTask$a$1$1(AppBrandPrepareTask.a.1 param1) {}
  
  public final void b(a parama)
  {
    AppMethodBeat.i(131736);
    ab.i("MicroMsg.AppBrandPrepareTask", "[appversion] dispatch %s, %s", new Object[] { AppBrandPrepareTask.PrepareParams.a(this.ikd.ikb), parama });
    AppBrandPrepareTask.PrepareResult localPrepareResult = new AppBrandPrepareTask.PrepareResult();
    AppBrandPrepareTask.PrepareResult.a(localPrepareResult, 5);
    AppBrandPrepareTask.PrepareResult.a(localPrepareResult, parama);
    this.ikd.ika.ad(localPrepareResult);
    AppMethodBeat.o(131736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.1.1
 * JD-Core Version:    0.7.0.1
 */