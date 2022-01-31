package com.tencent.mm.kernel.a.b;

import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g
  implements com.tencent.mm.kernel.a.a.b, c<Object>, d<Object>
{
  public Map<Class<?>, f<Object>> dMJ = new ConcurrentHashMap();
  private Class<?>[] dMK;
  public volatile Class<?>[] dML;
  public Map<Class, Object> dMM = new ConcurrentHashMap();
  private int dMN = 0;
  private Queue<f.a> dMO = new ConcurrentLinkedQueue();
  public ConcurrentHashMap<Object, a> dMP = new ConcurrentHashMap();
  
  private f.a a(Class paramClass, Object paramObject)
  {
    f localf = y(paramClass);
    f.a locala = (f.a)localf.al(paramObject);
    y.d("MicroMsg.ParallelsManagement", "makeDependency on IDependency of type %s for %s with %s", new Object[] { paramClass, paramObject, localf });
    Object localObject = locala;
    if (locala == null)
    {
      localObject = this.dMM.get(paramClass);
      paramClass = (Class)localObject;
      if (localObject == null) {
        paramClass = paramObject;
      }
      localf.i(paramObject, paramClass);
      localObject = (f.a)localf.al(paramObject);
    }
    return localObject;
  }
  
  public final f.a Ei()
  {
    synchronized (this.dMO)
    {
      f.a locala = (f.a)this.dMO.poll();
      return locala;
    }
  }
  
  public final void Ev()
  {
    synchronized (this.dMK)
    {
      if (this.dMK.length <= this.dMN) {
        return;
      }
      prepare();
    }
  }
  
  public final void a(f.a parama)
  {
    y.i("MicroMsg.ParallelsManagement", "ParallelsManagement resolvedOne %s for type %s then next %s", new Object[] { parama, parama.dMF.dMk, parama.dMF.dMS });
    y(parama.dMF.dMk).a(parama);
    if (parama.dMF.dMS != null)
    {
      f localf = y(parama.dMF.dMS);
      f.a locala = (f.a)localf.dMd.get(parama);
      if (locala.dMg != ((f.a)parama).dMg) {
        y.e("MMSkeleton.ParallelsDependencies", "not same!!!! %s, %s, %s, %s", new Object[] { locala, locala.dMg, parama, localf.dMd.get(parama) });
      }
      if ((localf.mTriggered) && (locala.Er())) {
        localf.dMy.b(locala);
      }
    }
  }
  
  public final void a(Class paramClass, Object paramObject1, Object paramObject2)
  {
    if (this.dML != null)
    {
      Class[] arrayOfClass = this.dML;
      int j = arrayOfClass.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfClass[i] == paramClass) {
          break label71;
        }
        i += 1;
      }
    }
    label71:
    for (int i = 0; i != 0; i = 1)
    {
      paramClass = y(paramClass);
      if (paramClass != null) {
        paramClass.i(paramObject1, paramObject2);
      }
      return;
    }
    k.w("MicroMsg.ParallelsManagement", "Not allow phase(%s) has dependency", new Object[] { paramClass });
  }
  
  public final void a(Class... paramVarArgs)
  {
    int i = 0;
    this.dMK = new Class[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.dMK, 0, paramVarArgs.length);
    while (i < this.dMK.length)
    {
      this.dMJ.put(this.dMK[i], new f(this.dMK[i], this, this));
      i += 1;
    }
  }
  
  public final void aq(Object arg1)
  {
    int j = 0;
    if (!this.dMP.containsKey(???)) {
      this.dMP.putIfAbsent(???, new a((byte)0));
    }
    a locala = (a)this.dMP.get(???);
    for (;;)
    {
      int i;
      synchronized (locala.dMQ)
      {
        if (locala.dMQ[0] == 2)
        {
          if (locala.Ew()) {
            k.i("MicroMsg.ParallelsManagement", "%s Has done. return.", new Object[] { ??? });
          }
        }
        else
        {
          i = locala.dMQ[0];
          if (i != 1) {}
        }
      }
      try
      {
        locala.dMQ.wait();
        for (;;)
        {
          label112:
          break;
          ??? = finally;
          throw ???;
          locala.dMQ[0] = 1;
        }
        k.d("MicroMsg.ParallelsManagement", "Make dependency on subject(%s), hashcode(%s)", new Object[] { ???, Integer.valueOf(???.hashCode()) });
        if ((??? instanceof b))
        {
          a.start();
          ((b)???).parallelsDependency();
          ??? = a.Eh();
          if (((a.b)???).cJ != null)
          {
            ??? = ((a.b)???).cJ.values().iterator();
            while (((Iterator)???).hasNext())
            {
              localObject3 = (a.a)((Iterator)???).next();
              localObject4 = ((a.a)localObject3).dMl.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = ((Iterator)localObject4).next();
                if (y(((a.a)localObject3).dMk).al(localObject5) == null)
                {
                  k.i("MicroMsg.ParallelsManagement", "Traversal make dependency for %s by subject(%s)", new Object[] { localObject5, ??? });
                  aq(localObject5);
                }
                a(((a.a)localObject3).dMk, ???, localObject5);
              }
            }
          }
        }
        ??? = new ArrayList();
        Object localObject3 = this.dMK;
        int k = localObject3.length;
        i = 0;
        while (i < k)
        {
          localObject4 = localObject3[i];
          if (((Class)localObject4).isInstance(???)) {
            ((ArrayList)???).add(localObject4);
          }
          i += 1;
        }
        Object localObject5 = (Class[])((ArrayList)???).toArray(new Class[0]);
        ??? = null;
        Object localObject4 = null;
        i = j;
        if (i < localObject5.length)
        {
          Class localClass = localObject5[i];
          if (i < localObject5.length - 1)
          {
            localObject3 = localObject5[(i + 1)];
            label429:
            if (??? == null) {
              break label525;
            }
            label434:
            if (localObject3 == null) {
              break label537;
            }
          }
          label525:
          label537:
          for (localObject3 = a((Class)localObject3, ???);; localObject3 = null)
          {
            ((f.a)???).dMD = ((f.a)localObject4);
            ((f.a)???).dME = ((f.a)localObject3);
            if (localObject4 != null) {
              ((f.a)???).dMF.dMR = ((f.a)localObject4).dMF.dMk;
            }
            if (localObject3 != null) {
              ((f.a)???).dMF.dMS = ((f.a)localObject3).dMF.dMk;
            }
            i += 1;
            localObject4 = ???;
            ??? = localObject3;
            break;
            localObject3 = null;
            break label429;
            ??? = a(localClass, ???);
            break label434;
          }
        }
        synchronized (locala.dMQ)
        {
          if (locala.dMQ[0] == 1)
          {
            locala.dMQ[0] = 2;
            locala.dMQ.notifyAll();
          }
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label112;
      }
    }
  }
  
  public final void b(f.a<Object> parama)
  {
    synchronized (this.dMO)
    {
      this.dMO.offer(parama);
      y.d("MicroMsg.ParallelsManagement", "ParallelsManagement provideOne %s %s", new Object[] { parama, parama.dMF.dMk });
      return;
    }
  }
  
  public final void b(Class paramClass, boolean paramBoolean)
  {
    int i = 0;
    label21:
    int j;
    if (i < this.dMK.length) {
      if (this.dMK[i] == paramClass)
      {
        j = Math.min(i, this.dMK.length - 1);
        if ((j < 0) || (this.dMN <= j)) {
          return;
        }
        i = j;
      }
    }
    for (;;)
    {
      if (i >= this.dMN) {
        break label161;
      }
      Iterator localIterator = y(this.dMK[i]).dMd.values().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label154;
        }
        paramClass = (f.a)localIterator.next();
        if (paramBoolean) {
          paramClass.dMh = false;
        }
        try
        {
          paramClass.dMA = paramClass.Ed();
          paramClass.dMC = false;
        }
        finally {}
      }
      i += 1;
      break;
      i = -1;
      break label21;
      label154:
      i += 1;
    }
    label161:
    this.dMN = j;
  }
  
  public final void prepare()
  {
    k.i("MicroMsg.ParallelsManagement", "prepare()", new Object[0]);
    for (;;)
    {
      synchronized (this.dMK)
      {
        if (this.dMK.length > this.dMN)
        {
          i = this.dMN;
          this.dMN += 1;
          if (i != -1) {
            y(this.dMK[i]).prepare();
          }
          return;
        }
      }
      int i = -1;
    }
  }
  
  public final <T> f<T> y(Class<T> paramClass)
  {
    return (f)this.dMJ.get(paramClass);
  }
  
  private static final class a
  {
    byte[] dMQ = new byte[1];
    
    public final boolean Ew()
    {
      boolean bool = false;
      synchronized (this.dMQ)
      {
        if (this.dMQ[0] == 2) {
          bool = true;
        }
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.g
 * JD-Core Version:    0.7.0.1
 */