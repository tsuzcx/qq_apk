package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class p
{
  private final LinkedHashMap<String, ArrayList<n>> kqG;
  
  p()
  {
    AppMethodBeat.i(193971);
    this.kqG = new LinkedHashMap(8, 0.75F);
    AppMethodBeat.o(193971);
  }
  
  public final void a(n paramn)
  {
    try
    {
      AppMethodBeat.i(193973);
      Object localObject = (ArrayList)this.kqG.get(paramn.kqB);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramn.equals((n)((Iterator)localObject).next()))
          {
            if (a.bcR().cxf) {
              h.log(3, "RequestManager", "remove videoRequest:".concat(String.valueOf(paramn)));
            }
            ((Iterator)localObject).remove();
          }
        }
      }
      AppMethodBeat.o(193973);
    }
    finally {}
  }
  
  public final void a(String paramString, n paramn)
  {
    try
    {
      AppMethodBeat.i(193972);
      ArrayList localArrayList2 = (ArrayList)this.kqG.get(paramString);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.kqG.put(paramString, localArrayList1);
        h.log(3, "RequestManager", "add videoRequest:".concat(String.valueOf(paramn)));
      }
      localArrayList1.add(paramn);
      AppMethodBeat.o(193972);
      return;
    }
    finally {}
  }
  
  public final void b(String paramString, n paramn)
  {
    AppMethodBeat.i(193974);
    Object localObject2 = bA(paramString, 10);
    Object localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (n)((Iterator)localObject2).next();
      if (((n)localObject3).sg(0)) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    paramn = "VideoProxy/" + paramn.kqv + "/RequestManager";
    h.log(4, paramn, "cancelPreloadRequestsSync, videoKey:" + paramString + ", count:" + ((ArrayList)localObject1).size());
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject2 = new CountDownLatch(((ArrayList)localObject1).size());
      h.log(5, paramn, "start auto cancel preload requests, request count=" + ((CountDownLatch)localObject2).getCount());
      localObject3 = new o()
      {
        public final void bdf()
        {
          AppMethodBeat.i(193970);
          this.kqH.countDown();
          AppMethodBeat.o(193970);
        }
      };
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        n localn = (n)((Iterator)localObject1).next();
        localn.kqt = ((o)localObject3);
        if (localn.kqn != null)
        {
          if ((localn.dR(0, 1)) && (a.bcR().cxf)) {
            h.log(3, localn.EE(), "cancel start, seq=" + localn.kqv);
          }
          localn.sf(1);
          localn.kqn.cancel(true);
        }
      }
      try
      {
        ((CountDownLatch)localObject2).await(2000L, TimeUnit.MILLISECONDS);
        if (bA(paramString, 10).size() == 0)
        {
          h.log(5, paramn, "auto cancel preload requests success");
          AppMethodBeat.o(193974);
          return;
        }
        h.log(5, paramn, "auto cancel preload requests timeout, max wait time is 2000 seconds");
        AppMethodBeat.o(193974);
        return;
      }
      catch (InterruptedException paramString)
      {
        h.log(5, paramn, "auto cancel preload requests interrupted " + paramString.toString());
      }
    }
    AppMethodBeat.o(193974);
  }
  
  public final ArrayList<n> bA(String paramString, int paramInt)
  {
    ArrayList localArrayList1;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(193975);
        localArrayList1 = new ArrayList();
        Iterator localIterator = this.kqG.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        ArrayList localArrayList2 = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localArrayList2.size() > 0)
        {
          n localn = (n)localArrayList2.get(0);
          if (paramString.equals(localn.kqA)) {
            if (paramInt != -1)
            {
              if (paramInt == localn.priority) {
                localArrayList1.addAll(localArrayList2);
              }
            }
            else {
              localArrayList1.addAll(localArrayList2);
            }
          }
        }
      }
      finally {}
    }
    AppMethodBeat.o(193975);
    return localArrayList1;
  }
  
  public final String toString()
  {
    try
    {
      AppMethodBeat.i(193976);
      Object localObject1 = super.toString();
      Object localObject3 = (String)localObject1 + "[";
      Iterator localIterator1 = this.kqG.entrySet().iterator();
      if (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
        for (localObject1 = localObject3;; localObject1 = (String)localObject1 + ",\n")
        {
          localObject3 = localObject1;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject3 = (n)localIterator2.next();
          localObject1 = (String)localObject1 + ((n)localObject3).toString();
        }
      }
      localObject1 = (String)localObject3 + "]";
      AppMethodBeat.o(193976);
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.p
 * JD-Core Version:    0.7.0.1
 */