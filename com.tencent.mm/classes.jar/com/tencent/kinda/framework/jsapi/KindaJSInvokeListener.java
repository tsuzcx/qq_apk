package com.tencent.kinda.framework.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.kl.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;

public class KindaJSInvokeListener
  extends c<kl>
{
  private static final String TAG = "MicroMsg.KindaJSInvokeListener";
  
  public KindaJSInvokeListener()
  {
    AppMethodBeat.i(207386);
    this.__eventId = kl.class.getName().hashCode();
    AppMethodBeat.o(207386);
  }
  
  private JSHandler createHandler(kl paramkl)
  {
    AppMethodBeat.i(207388);
    if (paramkl.dmd.dmg.equals("phoneBindCardVerifySms"))
    {
      paramkl = new PhoneBindCardVerifySmsJSHandler();
      AppMethodBeat.o(207388);
      return paramkl;
    }
    AppMethodBeat.o(207388);
    return null;
  }
  
  public boolean callback(kl paramkl)
  {
    AppMethodBeat.i(207387);
    ac.i("MicroMsg.KindaJSInvokeListener", "handle jsapi callback: %s, %s", new Object[] { paramkl.dmd.dmg, Integer.valueOf(paramkl.dmd.type) });
    JSHandler localJSHandler = createHandler(paramkl);
    if (localJSHandler != null) {
      localJSHandler.handle(paramkl);
    }
    AppMethodBeat.o(207387);
    return false;
  }
  
  public static abstract interface JSHandler
  {
    public abstract void handle(kl paramkl);
    
    public abstract String handleJsApi();
    
    public abstract int handleType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.KindaJSInvokeListener
 * JD-Core Version:    0.7.0.1
 */