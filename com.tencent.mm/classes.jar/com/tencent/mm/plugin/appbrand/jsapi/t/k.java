package com.tencent.mm.plugin.appbrand.jsapi.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.n;
import com.tencent.mm.plugin.appbrand.utils.n.a;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  static int kKU;
  final List<ar> kKV;
  Runnable kKW;
  private n kKp;
  
  private k()
  {
    AppMethodBeat.i(137654);
    this.kKV = new LinkedList();
    kKU = i.kKR.biK();
    this.kKW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137651);
        synchronized (k.this.kKV)
        {
          if (k.this.kKV.isEmpty())
          {
            AppMethodBeat.o(137651);
            return;
          }
          ar localar = (ar)k.this.kKV.remove(0);
          int i = k.this.kKV.size();
          localar.beN();
          ac.v("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", new Object[] { localar.getName(), Integer.valueOf(i) });
        }
        synchronized (k.this.kKV)
        {
          boolean bool = k.this.kKV.isEmpty();
          if (!bool) {
            l.bxj().j(this, k.kKU);
          }
          AppMethodBeat.o(137651);
          return;
          localObject1 = finally;
          AppMethodBeat.o(137651);
          throw localObject1;
        }
      }
    };
    this.kKp = new n(kKU, new n.a()
    {
      public final boolean k(Object... arg1)
      {
        AppMethodBeat.i(137652);
        synchronized (k.this.kKV)
        {
          if (k.this.kKV.isEmpty())
          {
            AppMethodBeat.o(137652);
            return false;
          }
          k.this.kKW.run();
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
    if (!i.kKR.a(???, paramar))
    {
      AppMethodBeat.o(137655);
      return false;
    }
    for (;;)
    {
      synchronized (this.kKV)
      {
        boolean bool = this.kKV.isEmpty();
        if (!this.kKV.isEmpty())
        {
          if (((ar)this.kKV.get(0)).equals(paramar))
          {
            this.kKV.add(0, paramar);
            this.kKV.remove(1);
            if ((bool) && (!this.kKp.m(new Object[0])))
            {
              ac.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[] { paramar.getName() });
              l.bxj().j(this.kKW, kKU);
            }
            AppMethodBeat.o(137655);
            return true;
          }
          this.kKV.remove(paramar);
          this.kKV.add(paramar);
        }
      }
      this.kKV.add(paramar);
    }
  }
  
  static final class a
  {
    static k kKY;
    
    static
    {
      AppMethodBeat.i(137653);
      kKY = new k((byte)0);
      AppMethodBeat.o(137653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.k
 * JD-Core Version:    0.7.0.1
 */