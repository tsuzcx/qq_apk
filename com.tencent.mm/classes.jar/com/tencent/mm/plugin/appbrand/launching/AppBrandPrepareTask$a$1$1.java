package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandPrepareTask$a$1$1
  implements f.a
{
  AppBrandPrepareTask$a$1$1(AppBrandPrepareTask.a.1 param1) {}
  
  public final void b(a parama)
  {
    y.i("MicroMsg.AppBrandPrepareTask", "[appversion] dispatch %s, %s", new Object[] { AppBrandPrepareTask.PrepareParams.a(this.gJv.gJt), parama });
    AppBrandPrepareTask.PrepareResult localPrepareResult = new AppBrandPrepareTask.PrepareResult();
    AppBrandPrepareTask.PrepareResult.a(localPrepareResult, 5);
    AppBrandPrepareTask.PrepareResult.a(localPrepareResult, parama);
    this.gJv.gJs.U(localPrepareResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.1.1
 * JD-Core Version:    0.7.0.1
 */