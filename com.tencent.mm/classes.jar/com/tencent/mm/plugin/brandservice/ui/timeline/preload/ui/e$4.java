package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class e$4
{
  e$4(e parame1, e parame2) {}
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final String __getString()
  {
    AppMethodBeat.i(154564);
    String str = this.keU.getPageString();
    AppMethodBeat.o(154564);
    return str;
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void __log(String paramString)
  {
    AppMethodBeat.i(154563);
    this.keU.Hi(paramString);
    AppMethodBeat.o(154563);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void __onFirstScreenCompleted()
  {
    AppMethodBeat.i(154566);
    al.d(new e.4.1(this));
    AppMethodBeat.o(154566);
  }
  
  @android.webkit.JavascriptInterface
  @org.xwalk.core.JavascriptInterface
  public final void __setInjectReady()
  {
    AppMethodBeat.i(154565);
    this.keU.aYD();
    AppMethodBeat.o(154565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.e.4
 * JD-Core Version:    0.7.0.1
 */