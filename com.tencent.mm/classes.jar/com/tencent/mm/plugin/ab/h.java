package com.tencent.mm.plugin.ab;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsapi/WxConsole;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "tagName", "", "(Ljava/lang/String;)V", "error", "", "objects", "", "", "([Ljava/lang/Object;)V", "info", "log", "warn", "webview-sdk_release"})
public final class h
  extends a<b>
{
  private final String FeZ;
  
  public h(String paramString)
  {
    super("console", (b)new b() {});
    AppMethodBeat.i(224807);
    this.FeZ = paramString;
    AppMethodBeat.o(224807);
  }
  
  @JavascriptInterface
  public final void error(Object... paramVarArgs)
  {
    AppMethodBeat.i(224806);
    p.h(paramVarArgs, "objects");
    Log.e(this.TAG, "JsError[" + this.FeZ + "]:" + e.a(paramVarArgs, (CharSequence)",", null, null, 0, null, null, 62));
    AppMethodBeat.o(224806);
  }
  
  @JavascriptInterface
  public final void info(Object... paramVarArgs)
  {
    AppMethodBeat.i(224804);
    p.h(paramVarArgs, "objects");
    Log.i(this.TAG, "JsInfo[" + this.FeZ + "]:" + e.a(paramVarArgs, (CharSequence)",", null, null, 0, null, null, 62));
    AppMethodBeat.o(224804);
  }
  
  @JavascriptInterface
  public final void log(Object... paramVarArgs)
  {
    AppMethodBeat.i(224803);
    p.h(paramVarArgs, "objects");
    if (Log.getLogLevel() <= 0) {
      Log.v(this.TAG, "JsLog[" + this.FeZ + "]:" + e.a(paramVarArgs, (CharSequence)",", null, null, 0, null, null, 62));
    }
    AppMethodBeat.o(224803);
  }
  
  @JavascriptInterface
  public final void warn(Object... paramVarArgs)
  {
    AppMethodBeat.i(224805);
    p.h(paramVarArgs, "objects");
    Log.w(this.TAG, "JsInfo[" + this.FeZ + "]:" + e.a(paramVarArgs, (CharSequence)",", null, null, 0, null, null, 62));
    AppMethodBeat.o(224805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.h
 * JD-Core Version:    0.7.0.1
 */