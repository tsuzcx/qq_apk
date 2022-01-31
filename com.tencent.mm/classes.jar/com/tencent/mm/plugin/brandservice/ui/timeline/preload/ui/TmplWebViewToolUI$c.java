package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class TmplWebViewToolUI$c
  implements Runnable
{
  TmplWebViewToolUI$c(TmplWebViewToolUI paramTmplWebViewToolUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(15072);
    if (TmplWebViewToolUI.h(this.keI))
    {
      AppMethodBeat.o(15072);
      return;
    }
    ab.i(TmplWebViewToolUI.c(this.keI), "forceUseOriWebViewUI() isA8KeyDone:" + TmplWebViewToolUI.n(this.keI));
    Object localObject;
    if (!(this.keI.aYK() instanceof a.a))
    {
      com.tencent.mm.plugin.webview.preload.a.gK(TmplWebViewToolUI.d(this.keI).uYL, 137);
      this.keI.a((a)new a.a());
      localObject = TmplWebViewToolUI.o(this.keI);
      if (localObject != null) {
        ((f)localObject).dgr();
      }
      String str = this.keM;
      localObject = str;
      if (str == null)
      {
        TmplWebViewToolUI localTmplWebViewToolUI = this.keI;
        str = TmplWebViewToolUI.p(this.keI);
        localObject = str;
        if (str == null) {
          localObject = TmplWebViewToolUI.q(this.keI);
        }
        localObject = localTmplWebViewToolUI.Hh((String)localObject);
      }
      ab.i(TmplWebViewToolUI.c(this.keI), "forceUseOriWebViewUI :".concat(String.valueOf(localObject)));
      if (TmplWebViewToolUI.r(this.keI) == null) {
        break label226;
      }
      TmplWebViewToolUI.b(this.keI).loadUrl((String)localObject, TmplWebViewToolUI.r(this.keI));
    }
    for (;;)
    {
      TmplWebViewToolUI.b(this.keI).setNeedClearHistory(true);
      AppMethodBeat.o(15072);
      return;
      label226:
      TmplWebViewToolUI.b(this.keI).loadUrl((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.c
 * JD-Core Version:    0.7.0.1
 */