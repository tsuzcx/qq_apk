package com.tencent.mm.plugin.expt.d.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.b.g;

public final class a
{
  b qXT;
  public ThreadPoolExecutor qXo;
  
  public a(b paramb)
  {
    AppMethodBeat.i(195911);
    this.qXo = com.tencent.mm.plugin.expt.d.b.coy();
    this.qXT = paramb;
    AppMethodBeat.o(195911);
  }
  
  public final void aee(String paramString)
  {
    AppMethodBeat.i(195912);
    if (!com.tencent.mm.plugin.expt.d.b.coz())
    {
      AppMethodBeat.o(195912);
      return;
    }
    if (g.ef(paramString))
    {
      ae.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageSingle data or sessionPageID isEmpty!");
      AppMethodBeat.o(195912);
      return;
    }
    final long l = System.currentTimeMillis();
    this.qXo.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195907);
        Object localObject = com.tencent.mm.plugin.expt.d.b.b.coG().coI();
        if (((List)localObject).size() <= 0)
        {
          AppMethodBeat.o(195907);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.d.e.a.b localb = (com.tencent.mm.plugin.expt.d.e.a.b)((Iterator)localObject).next();
          if ((localb.qXZ == 5) && (a.this.qXT != null)) {
            a.this.qXT.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(195907);
      }
    });
    AppMethodBeat.o(195912);
  }
  
  public final void aef(String paramString)
  {
    AppMethodBeat.i(195913);
    if (!com.tencent.mm.plugin.expt.d.b.coz())
    {
      AppMethodBeat.o(195913);
      return;
    }
    if (g.ef(paramString))
    {
      ae.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageMerge data isEmpty!");
      AppMethodBeat.o(195913);
      return;
    }
    final long l = System.currentTimeMillis();
    this.qXo.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195908);
        Object localObject = com.tencent.mm.plugin.expt.d.b.b.coG().coI();
        if (((List)localObject).size() <= 0)
        {
          AppMethodBeat.o(195908);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.d.e.a.b localb = (com.tencent.mm.plugin.expt.d.e.a.b)((Iterator)localObject).next();
          if ((localb.qXZ == 6) && (a.this.qXT != null)) {
            a.this.qXT.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(195908);
      }
    });
    AppMethodBeat.o(195913);
  }
  
  public final void aeg(String paramString)
  {
    AppMethodBeat.i(195914);
    if (!com.tencent.mm.plugin.expt.d.b.coz())
    {
      AppMethodBeat.o(195914);
      return;
    }
    if (g.ef(paramString))
    {
      ae.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionUBAAll data isEmpty!");
      AppMethodBeat.o(195914);
      return;
    }
    final long l = System.currentTimeMillis();
    this.qXo.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195910);
        Object localObject = com.tencent.mm.plugin.expt.d.b.b.coG().coI();
        if (((List)localObject).size() <= 0)
        {
          AppMethodBeat.o(195910);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.d.e.a.b localb = (com.tencent.mm.plugin.expt.d.e.a.b)((Iterator)localObject).next();
          if ((localb.qXZ == 9) && (a.this.qXT != null)) {
            a.this.qXT.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(195910);
      }
    });
    AppMethodBeat.o(195914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.d.a
 * JD-Core Version:    0.7.0.1
 */