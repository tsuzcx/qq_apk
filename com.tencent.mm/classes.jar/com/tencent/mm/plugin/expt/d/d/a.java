package com.tencent.mm.plugin.expt.d.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.b.g;

public final class a
{
  b qPZ;
  public ThreadPoolExecutor qPs;
  
  public a(b paramb)
  {
    AppMethodBeat.i(210257);
    this.qPs = com.tencent.mm.plugin.expt.d.b.cnh();
    this.qPZ = paramb;
    AppMethodBeat.o(210257);
  }
  
  public final void adk(String paramString)
  {
    AppMethodBeat.i(210258);
    if (!com.tencent.mm.plugin.expt.d.b.cni())
    {
      AppMethodBeat.o(210258);
      return;
    }
    if (g.ea(paramString))
    {
      ad.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageSingle data or sessionPageID isEmpty!");
      AppMethodBeat.o(210258);
      return;
    }
    final long l = System.currentTimeMillis();
    this.qPs.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210253);
        Object localObject = com.tencent.mm.plugin.expt.d.b.b.cnj().cnl();
        if (((List)localObject).size() <= 0)
        {
          AppMethodBeat.o(210253);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.d.e.a.b localb = (com.tencent.mm.plugin.expt.d.e.a.b)((Iterator)localObject).next();
          if ((localb.qQb == 5) && (a.this.qPZ != null)) {
            a.this.qPZ.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(210253);
      }
    });
    AppMethodBeat.o(210258);
  }
  
  public final void adl(String paramString)
  {
    AppMethodBeat.i(210259);
    if (!com.tencent.mm.plugin.expt.d.b.cni())
    {
      AppMethodBeat.o(210259);
      return;
    }
    if (g.ea(paramString))
    {
      ad.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageMerge data isEmpty!");
      AppMethodBeat.o(210259);
      return;
    }
    final long l = System.currentTimeMillis();
    this.qPs.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210254);
        Object localObject = com.tencent.mm.plugin.expt.d.b.b.cnj().cnl();
        if (((List)localObject).size() <= 0)
        {
          AppMethodBeat.o(210254);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.d.e.a.b localb = (com.tencent.mm.plugin.expt.d.e.a.b)((Iterator)localObject).next();
          if ((localb.qQb == 6) && (a.this.qPZ != null)) {
            a.this.qPZ.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(210254);
      }
    });
    AppMethodBeat.o(210259);
  }
  
  public final void adm(String paramString)
  {
    AppMethodBeat.i(210260);
    if (!com.tencent.mm.plugin.expt.d.b.cni())
    {
      AppMethodBeat.o(210260);
      return;
    }
    if (g.ea(paramString))
    {
      ad.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionUBAAll data isEmpty!");
      AppMethodBeat.o(210260);
      return;
    }
    final long l = System.currentTimeMillis();
    this.qPs.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210256);
        Object localObject = com.tencent.mm.plugin.expt.d.b.b.cnj().cnl();
        if (((List)localObject).size() <= 0)
        {
          AppMethodBeat.o(210256);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.d.e.a.b localb = (com.tencent.mm.plugin.expt.d.e.a.b)((Iterator)localObject).next();
          if ((localb.qQb == 9) && (a.this.qPZ != null)) {
            a.this.qPZ.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(210256);
      }
    });
    AppMethodBeat.o(210260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.d.a
 * JD-Core Version:    0.7.0.1
 */