package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.o;
import com.tencent.mm.plugin.appbrand.utils.o.a;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  static int llf;
  private o lkA;
  final List<at> llg;
  Runnable llh;
  
  private k()
  {
    AppMethodBeat.i(137654);
    this.llg = new LinkedList();
    llf = i.llc.bnf();
    this.llh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137651);
        synchronized (k.this.llg)
        {
          if (k.this.llg.isEmpty())
          {
            AppMethodBeat.o(137651);
            return;
          }
          at localat = (at)k.this.llg.remove(0);
          int i = k.this.llg.size();
          localat.bja();
          ae.v("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", new Object[] { localat.getName(), Integer.valueOf(i) });
        }
        synchronized (k.this.llg)
        {
          boolean bool = k.this.llg.isEmpty();
          if (!bool) {
            m.bCj().k(this, k.llf);
          }
          AppMethodBeat.o(137651);
          return;
          localObject1 = finally;
          AppMethodBeat.o(137651);
          throw localObject1;
        }
      }
    };
    this.lkA = new o(llf, new o.a()
    {
      public final boolean j(Object... arg1)
      {
        AppMethodBeat.i(137652);
        synchronized (k.this.llg)
        {
          if (k.this.llg.isEmpty())
          {
            AppMethodBeat.o(137652);
            return false;
          }
          k.this.llh.run();
          AppMethodBeat.o(137652);
          return true;
        }
      }
    });
    AppMethodBeat.o(137654);
  }
  
  public final boolean a(at paramat, c arg2)
  {
    AppMethodBeat.i(137655);
    if ((paramat == null) || (??? == null))
    {
      AppMethodBeat.o(137655);
      return false;
    }
    if (!i.llc.a(???, paramat))
    {
      AppMethodBeat.o(137655);
      return false;
    }
    for (;;)
    {
      synchronized (this.llg)
      {
        boolean bool = this.llg.isEmpty();
        if (!this.llg.isEmpty())
        {
          if (((at)this.llg.get(0)).equals(paramat))
          {
            this.llg.add(0, paramat);
            this.llg.remove(1);
            if ((bool) && (!this.lkA.l(new Object[0])))
            {
              ae.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[] { paramat.getName() });
              m.bCj().k(this.llh, llf);
            }
            AppMethodBeat.o(137655);
            return true;
          }
          this.llg.remove(paramat);
          this.llg.add(paramat);
        }
      }
      this.llg.add(paramat);
    }
  }
  
  static final class a
  {
    static k llj;
    
    static
    {
      AppMethodBeat.i(137653);
      llj = new k((byte)0);
      AppMethodBeat.o(137653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.k
 * JD-Core Version:    0.7.0.1
 */