package com.tencent.luggage.d;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.luggage.bridge.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import org.a.a;

public class f
  extends n
{
  private o cqI;
  private g crk;
  private final Context mContext;
  
  static
  {
    AppMethodBeat.i(207610);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(207610);
      return;
    }
  }
  
  public f(Context paramContext, Class<? extends g> paramClass)
  {
    AppMethodBeat.i(207605);
    this.mContext = paramContext;
    if ((!$assertionsDisabled) && (paramClass == null))
    {
      paramContext = new AssertionError();
      AppMethodBeat.o(207605);
      throw paramContext;
    }
    this.crk = ((g)a.ce(paramClass).ao(new Object[] { paramContext }).object);
    evaluateJavascript("var self = this;", null);
    evaluateJavascript("let require = process.mainModule.require;", null);
    this.cqI = new o(this.crk);
    evaluateJavascript(d.anc("LuggageBridge.js"), null);
    this.crk.NV();
    AppMethodBeat.o(207605);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(207609);
    this.crk.destroy();
    AppMethodBeat.o(207609);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(207606);
    this.crk.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(207606);
  }
  
  public final o getBridge()
  {
    return this.cqI;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(207608);
    String str = this.crk.getUserAgent();
    AppMethodBeat.o(207608);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.f
 * JD-Core Version:    0.7.0.1
 */