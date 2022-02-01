package com.tencent.mm.plugin.av;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxConsole;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "tagName", "", "(Ljava/lang/String;)V", "error", "", "objects", "", "", "([Ljava/lang/Object;)V", "info", "log", "warn", "webview-sdk_release"})
public final class h
  extends a<b>
{
  private final String LtE;
  
  public h(String paramString)
  {
    super("console", (b)new b() {});
    AppMethodBeat.i(206963);
    this.LtE = paramString;
    AppMethodBeat.o(206963);
  }
  
  @JavascriptInterface
  public final void error(Object... paramVarArgs)
  {
    AppMethodBeat.i(206961);
    p.k(paramVarArgs, "objects");
    Log.e(this.TAG, "JsError[" + this.LtE + "]:" + e.a(paramVarArgs, (CharSequence)",", null, null, 0, null, null, 62));
    AppMethodBeat.o(206961);
  }
  
  @JavascriptInterface
  public final void info(Object... paramVarArgs)
  {
    AppMethodBeat.i(206959);
    p.k(paramVarArgs, "objects");
    Log.i(this.TAG, "JsInfo[" + this.LtE + "]:" + e.a(paramVarArgs, (CharSequence)",", null, null, 0, null, null, 62));
    AppMethodBeat.o(206959);
  }
  
  @JavascriptInterface
  public final void log(Object... paramVarArgs)
  {
    AppMethodBeat.i(206958);
    p.k(paramVarArgs, "objects");
    if (Log.getLogLevel() <= 0) {
      Log.v(this.TAG, "JsLog[" + this.LtE + "]:" + e.a(paramVarArgs, (CharSequence)",", null, null, 0, null, null, 62));
    }
    AppMethodBeat.o(206958);
  }
  
  @JavascriptInterface
  public final void warn(Object... paramVarArgs)
  {
    AppMethodBeat.i(206960);
    p.k(paramVarArgs, "objects");
    Log.w(this.TAG, "JsInfo[" + this.LtE + "]:" + e.a(paramVarArgs, (CharSequence)",", null, null, 0, null, null, 62));
    AppMethodBeat.o(206960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.av.h
 * JD-Core Version:    0.7.0.1
 */