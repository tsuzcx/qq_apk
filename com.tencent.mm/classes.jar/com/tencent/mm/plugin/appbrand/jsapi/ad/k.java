package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.t;
import com.tencent.mm.plugin.appbrand.utils.t.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  static int stO;
  private t ssZ;
  final List<bc> stP;
  Runnable stQ;
  
  private k()
  {
    AppMethodBeat.i(137654);
    this.stP = new LinkedList();
    stO = i.stI.cuz();
    this.stQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137651);
        synchronized (k.this.stP)
        {
          if (k.this.stP.isEmpty())
          {
            AppMethodBeat.o(137651);
            return;
          }
          bc localbc = (bc)k.this.stP.remove(0);
          int i = k.this.stP.size();
          localbc.cpV();
          Log.v("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", new Object[] { localbc.getName(), Integer.valueOf(i) });
        }
        synchronized (k.this.stP)
        {
          boolean bool = k.this.stP.isEmpty();
          if (!bool) {
            o.cNm().j(this, k.stO);
          }
          AppMethodBeat.o(137651);
          return;
          localObject1 = finally;
          AppMethodBeat.o(137651);
          throw localObject1;
        }
      }
    };
    this.ssZ = new t(stO, new t.a()
    {
      public final boolean k(Object... arg1)
      {
        AppMethodBeat.i(137652);
        synchronized (k.this.stP)
        {
          if (k.this.stP.isEmpty())
          {
            AppMethodBeat.o(137652);
            return false;
          }
          k.this.stQ.run();
          AppMethodBeat.o(137652);
          return true;
        }
      }
    });
    AppMethodBeat.o(137654);
  }
  
  private static boolean b(bc parambc, f paramf)
  {
    AppMethodBeat.i(329494);
    if ((parambc == null) || (paramf == null))
    {
      AppMethodBeat.o(329494);
      return false;
    }
    if (!i.stI.a(paramf, parambc))
    {
      AppMethodBeat.o(329494);
      return false;
    }
    Log.v("MicroMsg.SensorJsEventPublisher", "post direct event(event : %s).", new Object[] { parambc.getName() });
    parambc.cpV();
    AppMethodBeat.o(329494);
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
    if (!i.stI.a(???, parambc))
    {
      AppMethodBeat.o(137655);
      return false;
    }
    for (;;)
    {
      synchronized (this.stP)
      {
        boolean bool = this.stP.isEmpty();
        if (!this.stP.isEmpty())
        {
          if (((bc)this.stP.get(0)).equals(parambc))
          {
            this.stP.add(0, parambc);
            this.stP.remove(1);
            if ((bool) && (!this.ssZ.m(new Object[0])))
            {
              Log.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[] { parambc.getName() });
              o.cNm().j(this.stQ, stO);
            }
            AppMethodBeat.o(137655);
            return true;
          }
          this.stP.remove(parambc);
          this.stP.add(parambc);
        }
      }
      this.stP.add(parambc);
    }
  }
  
  public final boolean a(bc parambc, f paramf)
  {
    AppMethodBeat.i(329508);
    if (i.stI.cuA())
    {
      bool = b(parambc, paramf);
      AppMethodBeat.o(329508);
      return bool;
    }
    boolean bool = c(parambc, paramf);
    AppMethodBeat.o(329508);
    return bool;
  }
  
  static final class a
  {
    static k stS;
    
    static
    {
      AppMethodBeat.i(137653);
      stS = new k((byte)0);
      AppMethodBeat.o(137653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.k
 * JD-Core Version:    0.7.0.1
 */