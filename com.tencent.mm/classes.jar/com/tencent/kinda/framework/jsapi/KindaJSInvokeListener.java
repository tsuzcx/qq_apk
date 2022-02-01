package com.tencent.kinda.framework.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.kv.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;

public class KindaJSInvokeListener
  extends c<kv>
{
  private static final String TAG = "MicroMsg.KindaJSInvokeListener";
  
  public KindaJSInvokeListener()
  {
    AppMethodBeat.i(193149);
    this.__eventId = kv.class.getName().hashCode();
    AppMethodBeat.o(193149);
  }
  
  private JSHandler createHandler(kv paramkv)
  {
    AppMethodBeat.i(193151);
    if (paramkv.dyW.dyZ.equals("phoneBindCardVerifySms"))
    {
      paramkv = new PhoneBindCardVerifySmsJSHandler();
      AppMethodBeat.o(193151);
      return paramkv;
    }
    if (paramkv.dyW.dyZ.equals("requestQueryCashier"))
    {
      paramkv = new requestQueryCashierJsHandler();
      AppMethodBeat.o(193151);
      return paramkv;
    }
    AppMethodBeat.o(193151);
    return null;
  }
  
  public boolean callback(kv paramkv)
  {
    AppMethodBeat.i(193150);
    ae.i("MicroMsg.KindaJSInvokeListener", "handle jsapi callback: %s, %s", new Object[] { paramkv.dyW.dyZ, Integer.valueOf(paramkv.dyW.type) });
    JSHandler localJSHandler = createHandler(paramkv);
    if (localJSHandler != null) {
      localJSHandler.handle(paramkv);
    }
    AppMethodBeat.o(193150);
    return false;
  }
  
  public static abstract interface JSHandler
  {
    public abstract void handle(kv paramkv);
    
    public abstract String handleJsApi();
    
    public abstract int handleType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.KindaJSInvokeListener
 * JD-Core Version:    0.7.0.1
 */