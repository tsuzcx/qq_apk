package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.plugin.appbrand.utils.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  static int mqS;
  final List<bc> mqT;
  Runnable mqU;
  private o mqi;
  
  private k()
  {
    AppMethodBeat.i(137654);
    this.mqT = new LinkedList();
    mqS = i.mqN.bIE();
    this.mqU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137651);
        synchronized (k.this.mqT)
        {
          if (k.this.mqT.isEmpty())
          {
            AppMethodBeat.o(137651);
            return;
          }
          bc localbc = (bc)k.this.mqT.remove(0);
          int i = k.this.mqT.size();
          localbc.bEo();
          Log.v("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", new Object[] { localbc.getName(), Integer.valueOf(i) });
        }
        synchronized (k.this.mqT)
        {
          boolean bool = k.this.mqT.isEmpty();
          if (!bool) {
            m.bZn().j(this, k.mqS);
          }
          AppMethodBeat.o(137651);
          return;
          localObject1 = finally;
          AppMethodBeat.o(137651);
          throw localObject1;
        }
      }
    };
    this.mqi = new o(mqS, new o.a()
    {
      public final boolean j(Object... arg1)
      {
        AppMethodBeat.i(137652);
        synchronized (k.this.mqT)
        {
          if (k.this.mqT.isEmpty())
          {
            AppMethodBeat.o(137652);
            return false;
          }
          k.this.mqU.run();
          AppMethodBeat.o(137652);
          return true;
        }
      }
    });
    AppMethodBeat.o(137654);
  }
  
  private static boolean b(bc parambc, f paramf)
  {
    AppMethodBeat.i(193700);
    if ((parambc == null) || (paramf == null))
    {
      AppMethodBeat.o(193700);
      return false;
    }
    if (!i.mqN.a(paramf, parambc))
    {
      AppMethodBeat.o(193700);
      return false;
    }
    Log.v("MicroMsg.SensorJsEventPublisher", "post direct event(event : %s).", new Object[] { parambc.getName() });
    parambc.bEo();
    AppMethodBeat.o(193700);
    return true;
  }
  
  private boolean c(bc parambc, f arg2)
  {
    AppMethodBeat.i(137655);
    if ((parambc == null) || (??? == null))
    {
      AppMethodBeat.o(137655);
      return false;
    }
    if (!i.mqN.a(???, parambc))
    {
      AppMethodBeat.o(137655);
      return false;
    }
    for (;;)
    {
      synchronized (this.mqT)
      {
        boolean bool = this.mqT.isEmpty();
        if (!this.mqT.isEmpty())
        {
          if (((bc)this.mqT.get(0)).equals(parambc))
          {
            this.mqT.add(0, parambc);
            this.mqT.remove(1);
            if ((bool) && (!this.mqi.l(new Object[0])))
            {
              Log.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[] { parambc.getName() });
              m.bZn().j(this.mqU, mqS);
            }
            AppMethodBeat.o(137655);
            return true;
          }
          this.mqT.remove(parambc);
          this.mqT.add(parambc);
        }
      }
      this.mqT.add(parambc);
    }
  }
  
  public final boolean a(bc parambc, f paramf)
  {
    AppMethodBeat.i(193699);
    if (i.mqN.bIF())
    {
      bool = b(parambc, paramf);
      AppMethodBeat.o(193699);
      return bool;
    }
    boolean bool = c(parambc, paramf);
    AppMethodBeat.o(193699);
    return bool;
  }
  
  static final class a
  {
    static k mqW;
    
    static
    {
      AppMethodBeat.i(137653);
      mqW = new k((byte)0);
      AppMethodBeat.o(137653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.k
 * JD-Core Version:    0.7.0.1
 */