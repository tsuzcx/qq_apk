package com.tencent.mm.plugin.expt.d.e;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.b.g;

public final class a
{
  public ThreadPoolExecutor KHV;
  b wdV;
  
  public a(b paramb)
  {
    AppMethodBeat.i(293149);
    this.wdV = paramb;
    this.KHV = new ThreadPoolExecutor(0, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    AppMethodBeat.o(293149);
  }
  
  public final void awn(String paramString)
  {
    AppMethodBeat.i(256987);
    if (!com.tencent.mm.plugin.expt.d.b.dby())
    {
      AppMethodBeat.o(256987);
      return;
    }
    if (g.fK(paramString))
    {
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageSingle data or sessionPageID isEmpty!");
      AppMethodBeat.o(256987);
      return;
    }
    final long l = System.currentTimeMillis();
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(255806);
        Object localObject = com.tencent.mm.plugin.expt.d.c.b.dbG().dbI();
        if (((List)localObject).size() <= 0)
        {
          AppMethodBeat.o(255806);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.d.f.a.b localb = (com.tencent.mm.plugin.expt.d.f.a.b)((Iterator)localObject).next();
          if ((localb.web == 5) && (a.this.wdV != null)) {
            a.this.wdV.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(255806);
      }
    });
    AppMethodBeat.o(256987);
  }
  
  public final void awo(String paramString)
  {
    AppMethodBeat.i(256988);
    if (!com.tencent.mm.plugin.expt.d.b.dby())
    {
      AppMethodBeat.o(256988);
      return;
    }
    if (g.fK(paramString))
    {
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionPageMerge data isEmpty!");
      AppMethodBeat.o(256988);
      return;
    }
    final long l = System.currentTimeMillis();
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252044);
        Object localObject = com.tencent.mm.plugin.expt.d.c.b.dbG().dbI();
        if (((List)localObject).size() <= 0)
        {
          AppMethodBeat.o(252044);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.d.f.a.b localb = (com.tencent.mm.plugin.expt.d.f.a.b)((Iterator)localObject).next();
          if ((localb.web == 6) && (a.this.wdV != null)) {
            a.this.wdV.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(252044);
      }
    });
    AppMethodBeat.o(256988);
  }
  
  public final void awp(String paramString)
  {
    AppMethodBeat.i(256990);
    if (!com.tencent.mm.plugin.expt.d.b.dby())
    {
      AppMethodBeat.o(256990);
      return;
    }
    if (g.fK(paramString))
    {
      Log.e("EdgeComputingDataSourceService", "[EdgeComputingDataSourceService] sendSessionUBAAll data isEmpty!");
      AppMethodBeat.o(256990);
      return;
    }
    final long l = System.currentTimeMillis();
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(255488);
        Object localObject = com.tencent.mm.plugin.expt.d.c.b.dbG().dbI();
        if (((List)localObject).size() <= 0)
        {
          AppMethodBeat.o(255488);
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.expt.d.f.a.b localb = (com.tencent.mm.plugin.expt.d.f.a.b)((Iterator)localObject).next();
          if ((localb.web == 9) && (a.this.wdV != null)) {
            a.this.wdV.a(l, localb, this.val$data);
          }
        }
        AppMethodBeat.o(255488);
      }
    });
    AppMethodBeat.o(256990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.e.a
 * JD-Core Version:    0.7.0.1
 */