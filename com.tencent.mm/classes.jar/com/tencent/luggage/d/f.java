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
  private o csD;
  private g cte;
  private final Context mContext;
  
  static
  {
    AppMethodBeat.i(221183);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(221183);
      return;
    }
  }
  
  public f(Context paramContext, Class<? extends g> paramClass)
  {
    AppMethodBeat.i(221179);
    this.mContext = paramContext;
    if ((!$assertionsDisabled) && (paramClass == null))
    {
      paramContext = new AssertionError();
      AppMethodBeat.o(221179);
      throw paramContext;
    }
    this.cte = ((g)a.bF(paramClass).ak(new Object[] { paramContext }).object);
    evaluateJavascript("var self = this;", null);
    evaluateJavascript("let require = process.mainModule.require;", null);
    this.csD = new o(this.cte);
    evaluateJavascript(d.afA("LuggageBridge.js"), null);
    this.cte.Le();
    AppMethodBeat.o(221179);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(221182);
    this.cte.destroy();
    AppMethodBeat.o(221182);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(221180);
    this.cte.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(221180);
  }
  
  final o getBridge()
  {
    return this.csD;
  }
  
  public final String getUserAgent()
  {
    AppMethodBeat.i(221181);
    String str = this.cte.getUserAgent();
    AppMethodBeat.o(221181);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.f
 * JD-Core Version:    0.7.0.1
 */