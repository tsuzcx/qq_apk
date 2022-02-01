package com.tencent.kinda.framework.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.g.a.ku.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public class KindaJSInvokeListener
  extends c<ku>
{
  private static final String TAG = "MicroMsg.KindaJSInvokeListener";
  
  public KindaJSInvokeListener()
  {
    AppMethodBeat.i(199439);
    this.__eventId = ku.class.getName().hashCode();
    AppMethodBeat.o(199439);
  }
  
  private JSHandler createHandler(ku paramku)
  {
    AppMethodBeat.i(199441);
    if (paramku.dxR.dxU.equals("phoneBindCardVerifySms"))
    {
      paramku = new PhoneBindCardVerifySmsJSHandler();
      AppMethodBeat.o(199441);
      return paramku;
    }
    if (paramku.dxR.dxU.equals("requestQueryCashier"))
    {
      paramku = new requestQueryCashierJsHandler();
      AppMethodBeat.o(199441);
      return paramku;
    }
    AppMethodBeat.o(199441);
    return null;
  }
  
  public boolean callback(ku paramku)
  {
    AppMethodBeat.i(199440);
    ad.i("MicroMsg.KindaJSInvokeListener", "handle jsapi callback: %s, %s", new Object[] { paramku.dxR.dxU, Integer.valueOf(paramku.dxR.type) });
    JSHandler localJSHandler = createHandler(paramku);
    if (localJSHandler != null) {
      localJSHandler.handle(paramku);
    }
    AppMethodBeat.o(199440);
    return false;
  }
  
  public static abstract interface JSHandler
  {
    public abstract void handle(ku paramku);
    
    public abstract String handleJsApi();
    
    public abstract int handleType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.KindaJSInvokeListener
 * JD-Core Version:    0.7.0.1
 */