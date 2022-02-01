package com.tencent.mm.plugin.expt.edge.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.c.i;

public final class a
{
  b zzO;
  public MMHandler zzP;
  
  public a(b paramb)
  {
    AppMethodBeat.i(299717);
    this.zzP = new MMHandler("EdgeComputingDataSourceService#mDataSourceHandler");
    this.zzO = paramb;
    AppMethodBeat.o(299717);
  }
  
  public final void aqo(String paramString)
  {
    AppMethodBeat.i(299722);
    if (!com.tencent.mm.plugin.expt.edge.b.dHV())
    {
      AppMethodBeat.o(299722);
      return;
    }
    if (i.hm(paramString))
    {
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageSingle data or sessionPageID isEmpty!");
      AppMethodBeat.o(299722);
      return;
    }
    com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageMerge data : ".concat(String.valueOf(paramString)));
    final long l = System.currentTimeMillis();
    this.zzP.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(299712);
        Object localObject = com.tencent.mm.plugin.expt.edge.config.b.dIg().dIh();
        if ((localObject == null) || (((List)localObject).size() <= 0))
        {
          AppMethodBeat.o(299712);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.edge.e.a.b localb = (com.tencent.mm.plugin.expt.edge.e.a.b)((Iterator)localObject).next();
          if ((localb.zzV == 5) && (a.this.zzO != null)) {
            a.this.zzO.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(299712);
      }
    });
    AppMethodBeat.o(299722);
  }
  
  public final void aqp(String paramString)
  {
    AppMethodBeat.i(299729);
    if (!com.tencent.mm.plugin.expt.edge.b.dHV())
    {
      AppMethodBeat.o(299729);
      return;
    }
    if (i.hm(paramString))
    {
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageMerge data isEmpty!");
      AppMethodBeat.o(299729);
      return;
    }
    com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionUBA data : ".concat(String.valueOf(paramString)));
    final long l = System.currentTimeMillis();
    this.zzP.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(299709);
        Object localObject = com.tencent.mm.plugin.expt.edge.config.b.dIg().dIh();
        if ((localObject == null) || (((List)localObject).size() <= 0))
        {
          AppMethodBeat.o(299709);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.edge.e.a.b localb = (com.tencent.mm.plugin.expt.edge.e.a.b)((Iterator)localObject).next();
          if ((localb.zzV == 6) && (a.this.zzO != null)) {
            a.this.zzO.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(299709);
      }
    });
    AppMethodBeat.o(299729);
  }
  
  public final void aqq(String paramString)
  {
    AppMethodBeat.i(299737);
    if (!com.tencent.mm.plugin.expt.edge.b.dHV())
    {
      AppMethodBeat.o(299737);
      return;
    }
    if (i.hm(paramString))
    {
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionUBAAll data isEmpty!");
      AppMethodBeat.o(299737);
      return;
    }
    com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionUBAAll data : ".concat(String.valueOf(paramString)));
    final long l = System.currentTimeMillis();
    this.zzP.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(299690);
        Object localObject = com.tencent.mm.plugin.expt.edge.config.b.dIg().dIh();
        if ((localObject == null) || (((List)localObject).size() <= 0))
        {
          AppMethodBeat.o(299690);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.edge.e.a.b localb = (com.tencent.mm.plugin.expt.edge.e.a.b)((Iterator)localObject).next();
          if ((localb.zzV == 9) && (a.this.zzO != null)) {
            a.this.zzO.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(299690);
      }
    });
    AppMethodBeat.o(299737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.d.a
 * JD-Core Version:    0.7.0.1
 */