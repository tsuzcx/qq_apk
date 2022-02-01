package com.tencent.kinda.framework.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.mc;
import com.tencent.mm.f.a.mc.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaJSInvokeListener
  extends IListener<mc>
{
  private static final String TAG = "MicroMsg.KindaJSInvokeListener";
  
  public KindaJSInvokeListener()
  {
    AppMethodBeat.i(264178);
    this.__eventId = mc.class.getName().hashCode();
    AppMethodBeat.o(264178);
  }
  
  private JSHandler createHandler(mc parammc)
  {
    AppMethodBeat.i(264180);
    if (parammc.fJZ.fKc.equals("phoneBindCardVerifySms"))
    {
      parammc = new PhoneBindCardVerifySmsJSHandler();
      AppMethodBeat.o(264180);
      return parammc;
    }
    if (parammc.fJZ.fKc.equals("requestQueryCashier"))
    {
      parammc = new requestQueryCashierJsHandler();
      AppMethodBeat.o(264180);
      return parammc;
    }
    if (parammc.fJZ.fKc.equals("fastBindCardGetResult"))
    {
      parammc = new FastBindCardGetResultHandler();
      AppMethodBeat.o(264180);
      return parammc;
    }
    AppMethodBeat.o(264180);
    return null;
  }
  
  public boolean callback(mc parammc)
  {
    AppMethodBeat.i(264179);
    Log.i("MicroMsg.KindaJSInvokeListener", "handle jsapi callback: %s, %s", new Object[] { parammc.fJZ.fKc, Integer.valueOf(parammc.fJZ.type) });
    JSHandler localJSHandler = createHandler(parammc);
    if (localJSHandler != null) {
      localJSHandler.handle(parammc);
    }
    AppMethodBeat.o(264179);
    return false;
  }
  
  public static abstract interface JSHandler
  {
    public abstract void handle(mc parammc);
    
    public abstract String handleJsApi();
    
    public abstract int handleType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.KindaJSInvokeListener
 * JD-Core Version:    0.7.0.1
 */