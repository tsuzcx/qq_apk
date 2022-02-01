package com.tencent.mm.plugin.ac;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webjsengine/WebJsEngine$setup$1$2", "", "error", "", "objects", "", "([Ljava/lang/Object;)V", "info", "log", "webview-sdk_release"})
public final class c$f
{
  c$f(c paramc, String paramString1, h paramh, String paramString2, String paramString3) {}
  
  @JavascriptInterface
  public final void error(Object... paramVarArgs)
  {
    AppMethodBeat.i(214023);
    p.h(paramVarArgs, "objects");
    ae.e(c.access$getTAG$cp(), "JsError[" + this.DRZ + "]:" + e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
    AppMethodBeat.o(214023);
  }
  
  @JavascriptInterface
  public final void info(Object... paramVarArgs)
  {
    AppMethodBeat.i(214022);
    p.h(paramVarArgs, "objects");
    ae.i(c.access$getTAG$cp(), "JsInfo[" + this.DRZ + "]:" + e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
    AppMethodBeat.o(214022);
  }
  
  @JavascriptInterface
  public final void log(Object... paramVarArgs)
  {
    AppMethodBeat.i(214021);
    p.h(paramVarArgs, "objects");
    if (ae.getLogLevel() <= 1) {
      ae.d(c.access$getTAG$cp(), "JsLog[" + this.DRZ + "]:" + e.a(paramVarArgs, (CharSequence)",\n", null, null, 0, null, null, 62));
    }
    AppMethodBeat.o(214021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ac.c.f
 * JD-Core Version:    0.7.0.1
 */