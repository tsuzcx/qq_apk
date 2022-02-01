package com.tencent.mm.plugin.ax;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxConsole;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "tagName", "", "(Ljava/lang/String;)V", "error", "", "objects", "", "", "([Ljava/lang/Object;)V", "info", "log", "warn", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends a<b>
{
  private final String RWX;
  
  public h(String paramString)
  {
    super("console", (b)new b() {});
    AppMethodBeat.i(260785);
    this.RWX = paramString;
    AppMethodBeat.o(260785);
  }
  
  @JavascriptInterface
  public final void error(Object... paramVarArgs)
  {
    AppMethodBeat.i(260818);
    s.u(paramVarArgs, "objects");
    Log.e(getTAG(), "JsError[" + this.RWX + "]:" + k.a(paramVarArgs, (CharSequence)",", null, null, 0, null, null, 62));
    AppMethodBeat.o(260818);
  }
  
  @JavascriptInterface
  public final void info(Object... paramVarArgs)
  {
    AppMethodBeat.i(260805);
    s.u(paramVarArgs, "objects");
    Log.i(getTAG(), "JsInfo[" + this.RWX + "]:" + k.a(paramVarArgs, (CharSequence)",", null, null, 0, null, null, 62));
    AppMethodBeat.o(260805);
  }
  
  @JavascriptInterface
  public final void log(Object... paramVarArgs)
  {
    AppMethodBeat.i(260798);
    s.u(paramVarArgs, "objects");
    if (Log.getLogLevel() <= 0) {
      Log.v(getTAG(), "JsLog[" + this.RWX + "]:" + k.a(paramVarArgs, (CharSequence)",", null, null, 0, null, null, 62));
    }
    AppMethodBeat.o(260798);
  }
  
  @JavascriptInterface
  public final void warn(Object... paramVarArgs)
  {
    AppMethodBeat.i(260810);
    s.u(paramVarArgs, "objects");
    Log.w(getTAG(), "JsInfo[" + this.RWX + "]:" + k.a(paramVarArgs, (CharSequence)",", null, null, 0, null, null, 62));
    AppMethodBeat.o(260810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.h
 * JD-Core Version:    0.7.0.1
 */