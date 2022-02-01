package com.tencent.luggage.d;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.luggage.bridge.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.d;
import org.a.a;

public class f
  extends n
{
  private o eiB;
  private g ejc;
  private final Context mContext;
  
  static
  {
    AppMethodBeat.i(219931);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(219931);
      return;
    }
  }
  
  public f(Context paramContext, Class<? extends g> paramClass)
  {
    AppMethodBeat.i(219930);
    this.mContext = paramContext;
    if ((!$assertionsDisabled) && (paramClass == null))
    {
      paramContext = new AssertionError();
      AppMethodBeat.o(219930);
      throw paramContext;
    }
    this.ejc = ((g)a.cQ(paramClass).av(new Object[] { paramContext }).object);
    evaluateJavascript("var self = this;", null);
    evaluateJavascript("let require = process.mainModule.require;", null);
    this.eiB = new o(this.ejc);
    evaluateJavascript(d.ags("LuggageBridge.js"), null);
    this.ejc.aof();
    AppMethodBeat.o(219930);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(219937);
    this.ejc.destroy();
    AppMethodBeat.o(219937);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(219933);
    this.ejc.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(219933);
  }
  
  public final o getBridge()
  {
    return this.eiB;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(219934);
    String str = this.ejc.getUserAgent();
    AppMethodBeat.o(219934);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.f
 * JD-Core Version:    0.7.0.1
 */