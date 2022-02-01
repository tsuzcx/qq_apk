package com.tencent.luggage.d;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.luggage.bridge.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.d;
import org.a.a;

public class f
  extends n
{
  private o cgI;
  private g chk;
  private final Context mContext;
  
  static
  {
    AppMethodBeat.i(201146);
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(201146);
      return;
    }
  }
  
  public f(Context paramContext, Class<? extends g> paramClass)
  {
    AppMethodBeat.i(201143);
    this.mContext = paramContext;
    if ((!$assertionsDisabled) && (paramClass == null))
    {
      paramContext = new AssertionError();
      AppMethodBeat.o(201143);
      throw paramContext;
    }
    this.chk = ((g)a.bF(paramClass).ai(new Object[] { paramContext }).object);
    evaluateJavascript("var self = this;", null);
    evaluateJavascript("let require = process.mainModule.require;", null);
    this.cgI = new o(this.chk);
    evaluateJavascript(d.VE("LuggageBridge.js"), null);
    this.chk.BQ();
    AppMethodBeat.o(201143);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(201145);
    this.chk.destroy();
    AppMethodBeat.o(201145);
  }
  
  public final void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(201144);
    this.chk.evaluateJavascript(paramString, paramValueCallback);
    AppMethodBeat.o(201144);
  }
  
  final o getBridge()
  {
    return this.cgI;
  }
  
  public final String getUserAgent()
  {
    return "v8";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.f
 * JD-Core Version:    0.7.0.1
 */