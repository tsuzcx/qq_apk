package com.tencent.mm.plugin.datareport.g.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.datareport.a.b.a.a;
import com.tencent.mm.plugin.datareport.c.d;
import com.tencent.mm.plugin.datareport.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.c.i;

public final class b
  implements a
{
  private List<b.a> xhH;
  private Map<Integer, b.a> xhI;
  private Map<Integer, b.a> xhJ;
  private long xhK;
  
  public b()
  {
    AppMethodBeat.i(262932);
    this.xhH = new ArrayList();
    this.xhI = new HashMap();
    this.xhJ = new HashMap();
    AppMethodBeat.o(262932);
  }
  
  public final void a(c paramc, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(262999);
    if (paramc == null)
    {
      AppMethodBeat.o(262999);
      return;
    }
    if ((b.a)this.xhJ.get(Integer.valueOf(paramc.hIa)) != null)
    {
      AppMethodBeat.o(262999);
      return;
    }
    Log.i("StandardEventMonitor", "[onPageIn] page : " + paramc + ", isSubPageEvent : " + paramBoolean);
    d locald = com.tencent.mm.plugin.datareport.a.dtn().xge;
    if (locald != null)
    {
      if (!paramBoolean) {
        break label277;
      }
      if ((paramc != null) && (!locald.xgX.containsKey(paramc.xhm)))
      {
        if (com.tencent.mm.plugin.datareport.d.a.eM(paramc))
        {
          com.tencent.mm.plugin.datareport.d.a.q(paramc, locald.xgY);
          if (i.hm(com.tencent.mm.plugin.datareport.d.a.eN(paramc))) {
            com.tencent.mm.plugin.datareport.d.a.g(paramc, paramc.xhm);
          }
        }
        locald.xgX.put(paramc.xhm, paramc);
      }
    }
    for (;;)
    {
      Object localObject = new b.a(this);
      ((b.a)localObject).xhM = paramc;
      ((b.a)localObject).xhL = paramLong;
      ((b.a)localObject).hTS = 0L;
      this.xhJ.put(Integer.valueOf(paramc.hIa), localObject);
      com.tencent.mm.plugin.datareport.h.a.Jz(this.xhJ.size());
      localObject = new HashMap();
      ((Map)localObject).put("in_type", Integer.valueOf(1));
      ((Map)localObject).put("in_time", Long.valueOf(paramLong));
      com.tencent.mm.plugin.datareport.a.dtn().a(paramLong, "page_in", paramc, (Map)localObject);
      AppMethodBeat.o(262999);
      return;
      label277:
      if (paramc != null)
      {
        if (com.tencent.mm.plugin.datareport.d.a.eM(paramc))
        {
          com.tencent.mm.plugin.datareport.d.a.q(paramc, locald.xgY);
          if (i.hm(com.tencent.mm.plugin.datareport.d.a.eN(paramc))) {
            com.tencent.mm.plugin.datareport.d.a.g(paramc, paramc.xhm);
          }
          com.tencent.mm.plugin.datareport.d.a.a locala = com.tencent.mm.plugin.datareport.d.a.g(locald.xgW, false);
          localObject = locala;
          if (locala == null)
          {
            localObject = locala;
            if (locald.xgW != null)
            {
              localObject = new com.tencent.mm.plugin.datareport.d.a.a();
              ((com.tencent.mm.plugin.datareport.d.a.a)localObject).xhh = (locald.xgY - 1);
              ((com.tencent.mm.plugin.datareport.d.a.a)localObject).hJW = locald.xgW.xhm;
            }
          }
          if (localObject != null) {
            com.tencent.mm.plugin.datareport.d.a.a(paramc, (com.tencent.mm.plugin.datareport.d.a.a)localObject);
          }
        }
        locald.xgV = locald.xgW;
        locald.xgW = paramc;
        locald.xgY += 1;
      }
    }
  }
  
  public final void b(View paramView, long paramLong)
  {
    AppMethodBeat.i(263015);
    Log.i("StandardEventMonitor", "[onViewClk] time : %d", new Object[] { Long.valueOf(paramLong) });
    a.a locala = com.tencent.mm.plugin.datareport.a.b.a.dts();
    locala.mTarget = paramView;
    locala.xgD = "view_clk";
    paramView = locala.ac(null).dtt();
    com.tencent.mm.plugin.datareport.a.dtn().a(paramLong, paramView);
    AppMethodBeat.o(263015);
  }
  
  public final void b(c paramc, long paramLong)
  {
    AppMethodBeat.i(262976);
    if (paramc == null)
    {
      AppMethodBeat.o(262976);
      return;
    }
    if ((b.a)this.xhI.get(Integer.valueOf(paramc.hIa)) != null)
    {
      AppMethodBeat.o(262976);
      return;
    }
    Log.i("StandardEventMonitor", "[onSessionIn] page : ".concat(String.valueOf(paramc)));
    Object localObject = new b.a(this);
    ((b.a)localObject).xhM = paramc;
    ((b.a)localObject).xhL = paramLong;
    ((b.a)localObject).hTS = 0L;
    this.xhI.put(Integer.valueOf(paramc.hIa), localObject);
    this.xhH.add(localObject);
    com.tencent.mm.plugin.datareport.h.a.Jy(this.xhH.size());
    localObject = new HashMap();
    ((Map)localObject).put("in_type", Integer.valueOf(1));
    ((Map)localObject).put("in_time", Long.valueOf(paramLong));
    com.tencent.mm.plugin.datareport.a.dtn().a(paramLong, "session_in", paramc, (Map)localObject);
    AppMethodBeat.o(262976);
  }
  
  public final void b(c paramc, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(263008);
    if (paramc == null)
    {
      AppMethodBeat.o(263008);
      return;
    }
    b.a locala = (b.a)this.xhJ.get(Integer.valueOf(paramc.hIa));
    if (locala == null)
    {
      AppMethodBeat.o(263008);
      return;
    }
    Log.i("StandardEventMonitor", "[onPageOut] page : " + paramc + ", isSubPageEvent : " + paramBoolean);
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.datareport.a.dtn().xge;
      if ((localObject != null) && (paramc != null) && (((d)localObject).xgX.containsKey(paramc.xhm))) {
        ((d)localObject).xgX.remove(paramc.xhm);
      }
    }
    if ((paramLong > locala.xhL) && (locala.xhL > 0L)) {}
    for (long l = paramLong - locala.xhL;; l = 0L)
    {
      locala.hTS = l;
      this.xhJ.remove(Integer.valueOf(paramc.hIa));
      if (locala.hTS > 0L)
      {
        localObject = new HashMap();
        ((Map)localObject).put("out_type", Integer.valueOf(1));
        ((Map)localObject).put("in_time", Long.valueOf(locala.xhL));
        ((Map)localObject).put("out_time", Long.valueOf(paramLong));
        ((Map)localObject).put("stay_time", Long.valueOf(locala.hTS));
        com.tencent.mm.plugin.datareport.a.dtn().a(paramLong, "page_out", paramc, (Map)localObject);
      }
      AppMethodBeat.o(263008);
      return;
    }
  }
  
  public final void c(c paramc, long paramLong)
  {
    AppMethodBeat.i(262983);
    if (paramc == null)
    {
      AppMethodBeat.o(262983);
      return;
    }
    b.a locala = (b.a)this.xhI.get(Integer.valueOf(paramc.hIa));
    if (locala == null)
    {
      AppMethodBeat.o(262983);
      return;
    }
    Log.i("StandardEventMonitor", "[onSessionOut] page : ".concat(String.valueOf(paramc)));
    if ((paramLong > locala.xhL) && (locala.xhL > 0L)) {}
    for (long l = paramLong - locala.xhL;; l = 0L)
    {
      locala.hTS = l;
      this.xhI.remove(Integer.valueOf(paramc.hIa));
      this.xhH.remove(locala);
      if (locala.hTS > 0L)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("out_type", Integer.valueOf(1));
        localHashMap.put("in_time", Long.valueOf(locala.xhL));
        localHashMap.put("out_time", Long.valueOf(paramLong));
        localHashMap.put("stay_time", Long.valueOf(locala.hTS));
        com.tencent.mm.plugin.datareport.a.dtn().a(paramLong, "session_out", paramc, localHashMap);
      }
      AppMethodBeat.o(262983);
      return;
    }
  }
  
  public final void g(long paramLong, List<c> paramList)
  {
    AppMethodBeat.i(262948);
    Log.i("StandardEventMonitor", "[onAppIn] time : %d", new Object[] { Long.valueOf(paramLong) });
    Object localObject1;
    Object localObject2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (c)paramList.next();
        localObject2 = (b.a)this.xhI.remove(Integer.valueOf(((c)localObject1).hIa));
        if (localObject2 != null) {
          this.xhH.remove(localObject2);
        }
        this.xhJ.remove(Integer.valueOf(((c)localObject1).hIa));
      }
    }
    paramList = this.xhH.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (b.a)paramList.next();
      ((b.a)localObject1).xhL = paramLong;
      ((b.a)localObject1).hTS = 0L;
      localObject2 = new HashMap();
      ((Map)localObject2).put("in_type", Integer.valueOf(0));
      ((Map)localObject2).put("in_time", Long.valueOf(paramLong));
      com.tencent.mm.plugin.datareport.a.dtn().a(paramLong, "session_in", ((b.a)localObject1).xhM, (Map)localObject2);
    }
    paramList = com.tencent.mm.plugin.datareport.a.dtn().xge;
    if (paramList != null)
    {
      localObject1 = paramList.xgW;
      if (localObject1 != null)
      {
        localObject1 = (b.a)this.xhJ.get(Integer.valueOf(((c)localObject1).hIa));
        if (localObject1 != null)
        {
          ((b.a)localObject1).xhL = paramLong;
          ((b.a)localObject1).hTS = 0L;
          localObject2 = new HashMap();
          ((Map)localObject2).put("in_type", Integer.valueOf(0));
          ((Map)localObject2).put("in_time", Long.valueOf(paramLong));
          com.tencent.mm.plugin.datareport.a.dtn().a(paramLong, "page_in", ((b.a)localObject1).xhM, (Map)localObject2);
        }
      }
      paramList = paramList.dtu();
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject1 = (c)paramList.next();
          localObject1 = (b.a)this.xhJ.get(Integer.valueOf(((c)localObject1).hIa));
          if (localObject1 != null)
          {
            ((b.a)localObject1).xhL = paramLong;
            ((b.a)localObject1).hTS = 0L;
            localObject2 = new HashMap();
            ((Map)localObject2).put("in_type", Integer.valueOf(0));
            ((Map)localObject2).put("in_time", Long.valueOf(paramLong));
            com.tencent.mm.plugin.datareport.a.dtn().a(paramLong, "page_in", ((b.a)localObject1).xhM, (Map)localObject2);
          }
        }
      }
    }
    if (MMApplicationContext.isMainProcess())
    {
      paramList = new HashMap();
      paramList.put("in_time", Long.valueOf(paramLong));
      com.tencent.mm.plugin.datareport.a.dtn().a(paramLong, "app_in", null, paramList);
      this.xhK = paramLong;
    }
    AppMethodBeat.o(262948);
  }
  
  public final void kN(long paramLong)
  {
    long l2 = 0L;
    AppMethodBeat.i(262965);
    Log.i("StandardEventMonitor", "[onAppOut] time : %d", new Object[] { Long.valueOf(paramLong) });
    Object localObject1 = com.tencent.mm.plugin.datareport.a.dtn().xge;
    Object localObject2;
    long l1;
    HashMap localHashMap;
    if (localObject1 != null)
    {
      localObject2 = ((d)localObject1).xgW;
      if (localObject2 != null)
      {
        localObject2 = (b.a)this.xhJ.get(Integer.valueOf(((c)localObject2).hIa));
        if (localObject2 != null)
        {
          if ((paramLong <= ((b.a)localObject2).xhL) || (((b.a)localObject2).xhL <= 0L)) {
            break label437;
          }
          l1 = paramLong - ((b.a)localObject2).xhL;
          ((b.a)localObject2).hTS = l1;
          if (((b.a)localObject2).hTS > 0L)
          {
            localHashMap = new HashMap();
            localHashMap.put("out_type", Integer.valueOf(0));
            localHashMap.put("in_time", Long.valueOf(((b.a)localObject2).xhL));
            localHashMap.put("out_time", Long.valueOf(paramLong));
            localHashMap.put("stay_time", Long.valueOf(((b.a)localObject2).hTS));
            com.tencent.mm.plugin.datareport.a.dtn().a(paramLong, "page_out", ((b.a)localObject2).xhM, localHashMap);
          }
        }
      }
      localObject1 = ((d)localObject1).dtu();
      label437:
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        label248:
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (c)((Iterator)localObject1).next();
          localObject2 = (b.a)this.xhJ.get(Integer.valueOf(((c)localObject2).hIa));
          if (localObject2 != null)
          {
            if ((paramLong > ((b.a)localObject2).xhL) && (((b.a)localObject2).xhL > 0L)) {}
            for (l1 = paramLong - ((b.a)localObject2).xhL;; l1 = 0L)
            {
              ((b.a)localObject2).hTS = l1;
              if (((b.a)localObject2).hTS <= 0L) {
                break label248;
              }
              localHashMap = new HashMap();
              localHashMap.put("out_type", Integer.valueOf(0));
              localHashMap.put("in_time", Long.valueOf(((b.a)localObject2).xhL));
              localHashMap.put("out_time", Long.valueOf(paramLong));
              localHashMap.put("stay_time", Long.valueOf(((b.a)localObject2).hTS));
              com.tencent.mm.plugin.datareport.a.dtn().a(paramLong, "page_out", ((b.a)localObject2).xhM, localHashMap);
              break label248;
              l1 = 0L;
              break;
            }
          }
        }
      }
    }
    localObject1 = this.xhH.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (b.a)((Iterator)localObject1).next();
      if ((paramLong > ((b.a)localObject2).xhL) && (((b.a)localObject2).xhL > 0L)) {}
      for (l1 = paramLong - ((b.a)localObject2).xhL;; l1 = 0L)
      {
        ((b.a)localObject2).hTS = l1;
        if (((b.a)localObject2).hTS <= 0L) {
          break;
        }
        localHashMap = new HashMap();
        localHashMap.put("out_type", Integer.valueOf(0));
        localHashMap.put("in_time", Long.valueOf(((b.a)localObject2).xhL));
        localHashMap.put("out_time", Long.valueOf(paramLong));
        localHashMap.put("stay_time", Long.valueOf(((b.a)localObject2).hTS));
        com.tencent.mm.plugin.datareport.a.dtn().a(paramLong, "session_out", ((b.a)localObject2).xhM, localHashMap);
        break;
      }
    }
    if (MMApplicationContext.isMainProcess())
    {
      localObject1 = new HashMap();
      ((Map)localObject1).put("in_time", Long.valueOf(this.xhK));
      ((Map)localObject1).put("out_time", Long.valueOf(paramLong));
      l1 = l2;
      if (paramLong > this.xhK)
      {
        l1 = l2;
        if (this.xhK > 0L) {
          l1 = paramLong - this.xhK;
        }
      }
      ((Map)localObject1).put("stay_time", Long.valueOf(l1));
      com.tencent.mm.plugin.datareport.a.dtn().a(paramLong, "app_out", null, (Map)localObject1);
    }
    AppMethodBeat.o(262965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.g.b.b
 * JD-Core Version:    0.7.0.1
 */