package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.utils.n;
import com.tencent.mm.plugin.appbrand.utils.n.a;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class k
{
  static int lht;
  private n lgO;
  final List<at> lhu;
  Runnable lhv;
  
  private k()
  {
    AppMethodBeat.i(137654);
    this.lhu = new LinkedList();
    lht = i.lhq.bmw();
    this.lhv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(137651);
        synchronized (k.this.lhu)
        {
          if (k.this.lhu.isEmpty())
          {
            AppMethodBeat.o(137651);
            return;
          }
          at localat = (at)k.this.lhu.remove(0);
          int i = k.this.lhu.size();
          localat.bir();
          ad.v("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", new Object[] { localat.getName(), Integer.valueOf(i) });
        }
        synchronized (k.this.lhu)
        {
          boolean bool = k.this.lhu.isEmpty();
          if (!bool) {
            m.bBp().k(this, k.lht);
          }
          AppMethodBeat.o(137651);
          return;
          localObject1 = finally;
          AppMethodBeat.o(137651);
          throw localObject1;
        }
      }
    };
    this.lgO = new n(lht, new n.a()
    {
      public final boolean k(Object... arg1)
      {
        AppMethodBeat.i(137652);
        synchronized (k.this.lhu)
        {
          if (k.this.lhu.isEmpty())
          {
            AppMethodBeat.o(137652);
            return false;
          }
          k.this.lhv.run();
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
    if (!i.lhq.a(???, paramat))
    {
      AppMethodBeat.o(137655);
      return false;
    }
    for (;;)
    {
      synchronized (this.lhu)
      {
        boolean bool = this.lhu.isEmpty();
        if (!this.lhu.isEmpty())
        {
          if (((at)this.lhu.get(0)).equals(paramat))
          {
            this.lhu.add(0, paramat);
            this.lhu.remove(1);
            if ((bool) && (!this.lgO.m(new Object[0])))
            {
              ad.v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", new Object[] { paramat.getName() });
              m.bBp().k(this.lhv, lht);
            }
            AppMethodBeat.o(137655);
            return true;
          }
          this.lhu.remove(paramat);
          this.lhu.add(paramat);
        }
      }
      this.lhu.add(paramat);
    }
  }
  
  static final class a
  {
    static k lhx;
    
    static
    {
      AppMethodBeat.i(137653);
      lhx = new k((byte)0);
      AppMethodBeat.o(137653);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.k
 * JD-Core Version:    0.7.0.1
 */