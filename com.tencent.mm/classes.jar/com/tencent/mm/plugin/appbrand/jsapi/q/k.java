package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  static int hZb;
  private com.tencent.mm.plugin.appbrand.t.k hYw;
  final List<ai> hZc;
  Runnable hZd;
  
  private k()
  {
    AppMethodBeat.i(126400);
    this.hZc = new LinkedList();
    hZb = i.hYY.aEC();
    this.hZd = new k.1(this);
    this.hYw = new com.tencent.mm.plugin.appbrand.t.k(hZb, new k.2(this));
    AppMethodBeat.o(126400);
  }
  
  public final boolean a(ai paramai, c arg2)
  {
    AppMethodBeat.i(126401);
    if (paramai == null)
    {
      AppMethodBeat.o(126401);
      return false;
    }
    if (!i.hYY.a(???, paramai))
    {
      AppMethodBeat.o(126401);
      return false;
    }
    for (;;)
    {
      synchronized (this.hZc)
      {
        boolean bool = this.hZc.isEmpty();
        if (!this.hZc.isEmpty())
        {
          if (((ai)this.hZc.get(0)).equals(paramai))
          {
            this.hZc.add(0, paramai);
            this.hZc.remove(1);
            if ((bool) && (!this.hYw.l(new Object[0])))
            {
              ab.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[] { paramai.getName() });
              m.aNS().o(this.hZd, hZb);
            }
            AppMethodBeat.o(126401);
            return true;
          }
          this.hZc.remove(paramai);
          this.hZc.add(paramai);
        }
      }
      this.hZc.add(paramai);
    }
  }
  
  static final class a
  {
    static k hZf;
    
    static
    {
      AppMethodBeat.i(126399);
      hZf = new k((byte)0);
      AppMethodBeat.o(126399);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.k
 * JD-Core Version:    0.7.0.1
 */