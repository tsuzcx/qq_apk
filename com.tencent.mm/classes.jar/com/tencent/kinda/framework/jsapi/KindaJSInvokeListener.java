package com.tencent.kinda.framework.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ni;
import com.tencent.mm.autogen.a.ni.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaJSInvokeListener
  extends IListener<ni>
{
  private static final String TAG = "MicroMsg.KindaJSInvokeListener";
  
  public KindaJSInvokeListener()
  {
    super(f.hfK);
    AppMethodBeat.i(226321);
    this.__eventId = ni.class.getName().hashCode();
    AppMethodBeat.o(226321);
  }
  
  private JSHandler createHandler(ni paramni)
  {
    AppMethodBeat.i(226329);
    if (paramni.hPF.hPI.equals("phoneBindCardVerifySms"))
    {
      paramni = new PhoneBindCardVerifySmsJSHandler();
      AppMethodBeat.o(226329);
      return paramni;
    }
    if (paramni.hPF.hPI.equals("requestQueryCashier"))
    {
      paramni = new requestQueryCashierJsHandler();
      AppMethodBeat.o(226329);
      return paramni;
    }
    if (paramni.hPF.hPI.equals("fastBindCardGetResult"))
    {
      paramni = new FastBindCardGetResultHandler();
      AppMethodBeat.o(226329);
      return paramni;
    }
    if (paramni.hPF.hPI.equals("phoneBindCardEntry"))
    {
      paramni = new PhoneBindCardEntryHandler();
      AppMethodBeat.o(226329);
      return paramni;
    }
    if (paramni.hPF.hPI.equals("requestKidsPayRechargePayment"))
    {
      paramni = new RequestKidsPayRechargePaymentHandler();
      AppMethodBeat.o(226329);
      return paramni;
    }
    if (paramni.hPF.hPI.equals("requestSnsPayment"))
    {
      paramni = new RequestSnsPaymentHandler();
      AppMethodBeat.o(226329);
      return paramni;
    }
    AppMethodBeat.o(226329);
    return null;
  }
  
  public boolean callback(ni paramni)
  {
    AppMethodBeat.i(226336);
    Log.i("MicroMsg.KindaJSInvokeListener", "handle jsapi callback: %s, %s", new Object[] { paramni.hPF.hPI, Integer.valueOf(paramni.hPF.type) });
    JSHandler localJSHandler = createHandler(paramni);
    if (localJSHandler != null) {
      localJSHandler.handle(paramni);
    }
    AppMethodBeat.o(226336);
    return false;
  }
  
  public static abstract interface JSHandler
  {
    public abstract void handle(ni paramni);
    
    public abstract String handleJsApi();
    
    public abstract int handleType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.KindaJSInvokeListener
 * JD-Core Version:    0.7.0.1
 */