package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AntiReentrantAuthListenerImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "listener", "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;)V", "mCalled", "", "onAuthResult", "", "luggage-wechat-full-sdk_release"})
public final class a
  implements e
{
  private final e kcV;
  private boolean mCalled;
  
  public a(e parame)
  {
    this.kcV = parame;
  }
  
  public final void bfe()
  {
    AppMethodBeat.i(169556);
    if (this.mCalled)
    {
      AppMethodBeat.o(169556);
      return;
    }
    e locale = this.kcV;
    if (locale != null) {
      locale.bfe();
    }
    this.mCalled = true;
    AppMethodBeat.o(169556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.a
 * JD-Core Version:    0.7.0.1
 */