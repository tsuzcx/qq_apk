package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.n;
import com.tencent.mm.plugin.appbrand.utils.n.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  static int kjD;
  private n kiY;
  final List<ar> kjE;
  Runnable kjF;
  
  private k()
  {
    AppMethodBeat.i(137654);
    this.kjE = new LinkedList();
    kjD = i.kjA.bbP();
    this.kjF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137651);
        synchronized (k.this.kjE)
        {
          if (k.this.kjE.isEmpty())
          {
            AppMethodBeat.o(137651);
            return;
          }
          ar localar = (ar)k.this.kjE.remove(0);
          int i = k.this.kjE.size();
          localar.aXQ();
          ad.v("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", new Object[] { localar.getName(), Integer.valueOf(i) });
        }
        synchronized (k.this.kjE)
        {
          boolean bool = k.this.kjE.isEmpty();
          if (!bool) {
            l.bqm().j(this, k.kjD);
          }
          AppMethodBeat.o(137651);
          return;
          localObject1 = finally;
          AppMethodBeat.o(137651);
          throw localObject1;
        }
      }
    };
    this.kiY = new n(kjD, new n.a()
    {
      public final boolean j(Object... arg1)
      {
        AppMethodBeat.i(137652);
        synchronized (k.this.kjE)
        {
          if (k.this.kjE.isEmpty())
          {
            AppMethodBeat.o(137652);
            return false;
          }
          k.this.kjF.run();
          AppMethodBeat.o(137652);
          return true;
        }
      }
    });
    AppMethodBeat.o(137654);
  }
  
  public final boolean a(ar paramar, c arg2)
  {
    AppMethodBeat.i(137655);
    if (paramar == null)
    {
      AppMethodBeat.o(137655);
      return false;
    }
    if (!i.kjA.a(???, paramar))
    {
      AppMethodBeat.o(137655);
      return false;
    }
    for (;;)
    {
      synchronized (this.kjE)
      {
        boolean bool = this.kjE.isEmpty();
        if (!this.kjE.isEmpty())
        {
          if (((ar)this.kjE.get(0)).equals(paramar))
          {
            this.kjE.add(0, paramar);
            this.kjE.remove(1);
            if ((bool) && (!this.kiY.l(new Object[0])))
            {
              ad.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[] { paramar.getName() });
              l.bqm().j(this.kjF, kjD);
            }
            AppMethodBeat.o(137655);
            return true;
          }
          this.kjE.remove(paramar);
          this.kjE.add(paramar);
        }
      }
      this.kjE.add(paramar);
    }
  }
  
  static final class a
  {
    static k kjH;
    
    static
    {
      AppMethodBeat.i(137653);
      kjH = new k((byte)0);
      AppMethodBeat.o(137653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.k
 * JD-Core Version:    0.7.0.1
 */