package com.tencent.kinda.framework;

import com.tencent.kinda.framework.boot.KindaApp;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.k.a;
import com.tencent.mm.sdk.b.c;

class WxCrossServices$8
  extends c<k>
{
  WxCrossServices$8(WxCrossServices paramWxCrossServices)
  {
    AppMethodBeat.i(144245);
    this.__eventId = k.class.getName().hashCode();
    AppMethodBeat.o(144245);
  }
  
  public boolean callback(k paramk)
  {
    AppMethodBeat.i(144246);
    if ((paramk != null) && (paramk.cmu != null))
    {
      if (!paramk.cmu.isActive) {
        break label39;
      }
      KindaApp.appKinda().applicationEnterForeground();
    }
    for (;;)
    {
      AppMethodBeat.o(144246);
      return false;
      label39:
      KindaApp.appKinda().applicationEnterBackground();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.WxCrossServices.8
 * JD-Core Version:    0.7.0.1
 */