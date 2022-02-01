package com.tencent.mm.plugin.expt.d.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.b.g;

public final class a
{
  public ThreadPoolExecutor sxy;
  b syd;
  
  public a(b paramb)
  {
    AppMethodBeat.i(220333);
    this.sxy = com.tencent.mm.plugin.expt.d.b.cMK();
    this.syd = paramb;
    AppMethodBeat.o(220333);
  }
  
  public final void aoo(String paramString)
  {
    AppMethodBeat.i(220334);
    if (!com.tencent.mm.plugin.expt.d.b.cML())
    {
      AppMethodBeat.o(220334);
      return;
    }
    if (g.eP(paramString))
    {
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageSingle data or sessionPageID isEmpty!");
      AppMethodBeat.o(220334);
      return;
    }
    final long l = System.currentTimeMillis();
    this.sxy.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220329);
        Object localObject = com.tencent.mm.plugin.expt.d.b.b.cMS().cMU();
        if (((List)localObject).size() <= 0)
        {
          AppMethodBeat.o(220329);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.d.e.a.b localb = (com.tencent.mm.plugin.expt.d.e.a.b)((Iterator)localObject).next();
          if ((localb.syj == 5) && (a.this.syd != null)) {
            a.this.syd.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(220329);
      }
    });
    AppMethodBeat.o(220334);
  }
  
  public final void aop(String paramString)
  {
    AppMethodBeat.i(220335);
    if (!com.tencent.mm.plugin.expt.d.b.cML())
    {
      AppMethodBeat.o(220335);
      return;
    }
    if (g.eP(paramString))
    {
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageMerge data isEmpty!");
      AppMethodBeat.o(220335);
      return;
    }
    final long l = System.currentTimeMillis();
    this.sxy.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220330);
        Object localObject = com.tencent.mm.plugin.expt.d.b.b.cMS().cMU();
        if (((List)localObject).size() <= 0)
        {
          AppMethodBeat.o(220330);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.d.e.a.b localb = (com.tencent.mm.plugin.expt.d.e.a.b)((Iterator)localObject).next();
          if ((localb.syj == 6) && (a.this.syd != null)) {
            a.this.syd.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(220330);
      }
    });
    AppMethodBeat.o(220335);
  }
  
  public final void aoq(String paramString)
  {
    AppMethodBeat.i(220336);
    if (!com.tencent.mm.plugin.expt.d.b.cML())
    {
      AppMethodBeat.o(220336);
      return;
    }
    if (g.eP(paramString))
    {
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionUBAAll data isEmpty!");
      AppMethodBeat.o(220336);
      return;
    }
    final long l = System.currentTimeMillis();
    this.sxy.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220332);
        Object localObject = com.tencent.mm.plugin.expt.d.b.b.cMS().cMU();
        if (((List)localObject).size() <= 0)
        {
          AppMethodBeat.o(220332);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.d.e.a.b localb = (com.tencent.mm.plugin.expt.d.e.a.b)((Iterator)localObject).next();
          if ((localb.syj == 9) && (a.this.syd != null)) {
            a.this.syd.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(220332);
      }
    });
    AppMethodBeat.o(220336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.d.a
 * JD-Core Version:    0.7.0.1
 */