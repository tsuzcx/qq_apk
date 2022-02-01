package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  static int ppa;
  private q poo;
  final List<az> ppb;
  Runnable ppc;
  
  private k()
  {
    AppMethodBeat.i(137654);
    this.ppb = new LinkedList();
    ppa = i.poU.bUm();
    this.ppc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137651);
        synchronized (k.this.ppb)
        {
          if (k.this.ppb.isEmpty())
          {
            AppMethodBeat.o(137651);
            return;
          }
          az localaz = (az)k.this.ppb.remove(0);
          int i = k.this.ppb.size();
          localaz.bPO();
          Log.v("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", new Object[] { localaz.getName(), Integer.valueOf(i) });
        }
        synchronized (k.this.ppb)
        {
          boolean bool = k.this.ppb.isEmpty();
          if (!bool) {
            m.clV().i(this, k.ppa);
          }
          AppMethodBeat.o(137651);
          return;
          localObject1 = finally;
          AppMethodBeat.o(137651);
          throw localObject1;
        }
      }
    };
    this.poo = new q(ppa, new q.a()
    {
      public final boolean i(Object... arg1)
      {
        AppMethodBeat.i(137652);
        synchronized (k.this.ppb)
        {
          if (k.this.ppb.isEmpty())
          {
            AppMethodBeat.o(137652);
            return false;
          }
          k.this.ppc.run();
          AppMethodBeat.o(137652);
          return true;
        }
      }
    });
    AppMethodBeat.o(137654);
  }
  
  private static boolean b(az paramaz, e parame)
  {
    AppMethodBeat.i(206298);
    if ((paramaz == null) || (parame == null))
    {
      AppMethodBeat.o(206298);
      return false;
    }
    if (!i.poU.a(parame, paramaz))
    {
      AppMethodBeat.o(206298);
      return false;
    }
    Log.v("MicroMsg.SensorJsEventPublisher", "post direct event(event : %s).", new Object[] { paramaz.getName() });
    paramaz.bPO();
    AppMethodBeat.o(206298);
    return true;
  }
  
  private boolean c(az paramaz, e arg2)
  {
    AppMethodBeat.i(137655);
    if ((paramaz == null) || (??? == null))
    {
      AppMethodBeat.o(137655);
      return false;
    }
    if (!i.poU.a(???, paramaz))
    {
      AppMethodBeat.o(137655);
      return false;
    }
    for (;;)
    {
      synchronized (this.ppb)
      {
        boolean bool = this.ppb.isEmpty();
        if (!this.ppb.isEmpty())
        {
          if (((az)this.ppb.get(0)).equals(paramaz))
          {
            this.ppb.add(0, paramaz);
            this.ppb.remove(1);
            if ((bool) && (!this.poo.k(new Object[0])))
            {
              Log.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[] { paramaz.getName() });
              m.clV().i(this.ppc, ppa);
            }
            AppMethodBeat.o(137655);
            return true;
          }
          this.ppb.remove(paramaz);
          this.ppb.add(paramaz);
        }
      }
      this.ppb.add(paramaz);
    }
  }
  
  public final boolean a(az paramaz, e parame)
  {
    AppMethodBeat.i(206296);
    if (i.poU.bUn())
    {
      bool = b(paramaz, parame);
      AppMethodBeat.o(206296);
      return bool;
    }
    boolean bool = c(paramaz, parame);
    AppMethodBeat.o(206296);
    return bool;
  }
  
  static final class a
  {
    static k ppe;
    
    static
    {
      AppMethodBeat.i(137653);
      ppe = new k((byte)0);
      AppMethodBeat.o(137653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.k
 * JD-Core Version:    0.7.0.1
 */