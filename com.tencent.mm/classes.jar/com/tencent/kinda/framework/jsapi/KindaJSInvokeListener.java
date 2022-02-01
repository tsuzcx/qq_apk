package com.tencent.kinda.framework.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.kd.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public class KindaJSInvokeListener
  extends c<kd>
{
  private static final String TAG = "MicroMsg.KindaJSInvokeListener";
  
  public KindaJSInvokeListener()
  {
    AppMethodBeat.i(186424);
    this.__eventId = kd.class.getName().hashCode();
    AppMethodBeat.o(186424);
  }
  
  private JSHandler createHandler(kd paramkd)
  {
    AppMethodBeat.i(186426);
    if (paramkd.dou.dox.equals("phoneBindCardVerifySms"))
    {
      paramkd = new PhoneBindCardVerifySmsJSHandler();
      AppMethodBeat.o(186426);
      return paramkd;
    }
    AppMethodBeat.o(186426);
    return null;
  }
  
  public boolean callback(kd paramkd)
  {
    AppMethodBeat.i(186425);
    ad.i("MicroMsg.KindaJSInvokeListener", "handle jsapi callback: %s, %s", new Object[] { paramkd.dou.dox, Integer.valueOf(paramkd.dou.type) });
    JSHandler localJSHandler = createHandler(paramkd);
    if (localJSHandler != null) {
      localJSHandler.handle(paramkd);
    }
    AppMethodBeat.o(186425);
    return false;
  }
  
  public static abstract interface JSHandler
  {
    public abstract void handle(kd paramkd);
    
    public abstract String handleJsApi();
    
    public abstract int handleType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.KindaJSInvokeListener
 * JD-Core Version:    0.7.0.1
 */