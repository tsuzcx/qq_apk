package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AntiReentrantAuthListenerImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "listener", "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;)V", "mCalled", "", "onAuthResult", "", "luggage-wechat-full-sdk_release"})
public final class a
  implements e
{
  private boolean mCalled;
  private final e oAE;
  
  public a(e parame)
  {
    this.oAE = parame;
  }
  
  public final void bQe()
  {
    AppMethodBeat.i(169556);
    if (this.mCalled)
    {
      AppMethodBeat.o(169556);
      return;
    }
    e locale = this.oAE;
    if (locale != null) {
      locale.bQe();
    }
    this.mCalled = true;
    AppMethodBeat.o(169556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.a
 * JD-Core Version:    0.7.0.1
 */