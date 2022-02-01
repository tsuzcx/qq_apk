package com.tencent.kinda.framework.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.g.a.ll.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaJSInvokeListener
  extends IListener<ll>
{
  private static final String TAG = "MicroMsg.KindaJSInvokeListener";
  
  public KindaJSInvokeListener()
  {
    AppMethodBeat.i(214440);
    this.__eventId = ll.class.getName().hashCode();
    AppMethodBeat.o(214440);
  }
  
  private JSHandler createHandler(ll paramll)
  {
    AppMethodBeat.i(214442);
    if (paramll.dQJ.dQM.equals("phoneBindCardVerifySms"))
    {
      paramll = new PhoneBindCardVerifySmsJSHandler();
      AppMethodBeat.o(214442);
      return paramll;
    }
    if (paramll.dQJ.dQM.equals("requestQueryCashier"))
    {
      paramll = new requestQueryCashierJsHandler();
      AppMethodBeat.o(214442);
      return paramll;
    }
    AppMethodBeat.o(214442);
    return null;
  }
  
  public boolean callback(ll paramll)
  {
    AppMethodBeat.i(214441);
    Log.i("MicroMsg.KindaJSInvokeListener", "handle jsapi callback: %s, %s", new Object[] { paramll.dQJ.dQM, Integer.valueOf(paramll.dQJ.type) });
    JSHandler localJSHandler = createHandler(paramll);
    if (localJSHandler != null) {
      localJSHandler.handle(paramll);
    }
    AppMethodBeat.o(214441);
    return false;
  }
  
  public static abstract interface JSHandler
  {
    public abstract void handle(ll paramll);
    
    public abstract String handleJsApi();
    
    public abstract int handleType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.KindaJSInvokeListener
 * JD-Core Version:    0.7.0.1
 */