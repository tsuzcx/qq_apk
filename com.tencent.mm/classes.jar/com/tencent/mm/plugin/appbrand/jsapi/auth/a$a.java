package com.tencent.mm.plugin.appbrand.jsapi.auth;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import java.util.HashMap;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion;", "", "()V", "DUMMY_IMPL", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIExecutorService;", "TAG", "", "gAppIdToQueueMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "Lkotlin/collections/HashMap;", "obtainByRuntime", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "plugin-appbrand-integration_release"})
final class a$a
{
  public static b x(i parami)
  {
    AppMethodBeat.i(134647);
    if (parami == null)
    {
      parami = a.aBS();
      AppMethodBeat.o(134647);
      return parami;
    }
    synchronized (a.aBT())
    {
      a.aBU();
      a locala = (a)a.aBT().get(parami.getAppId());
      if (locala != null)
      {
        parami = (b)locala;
        AppMethodBeat.o(134647);
        return parami;
      }
      parami = (b)((a.f.a.a)new a.a.a(parami)).invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.a.a
 * JD-Core Version:    0.7.0.1
 */