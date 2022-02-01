package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g
  implements com.tencent.mm.kernel.a.a.b, c<Object>, d<Object>
{
  private ConcurrentHashMap<Object, a> gfA;
  private Map<Class<?>, f<Object>> gfu;
  private Class<?>[] gfv;
  public volatile Class<?>[] gfw;
  public Map<Class, Object> gfx;
  private int gfy;
  private Queue<f.a> gfz;
  
  public g()
  {
    AppMethodBeat.i(158398);
    this.gfu = new ConcurrentHashMap();
    this.gfx = new ConcurrentHashMap();
    this.gfy = 0;
    this.gfz = new ConcurrentLinkedQueue();
    this.gfA = new ConcurrentHashMap();
    AppMethodBeat.o(158398);
  }
  
  private boolean ai(Class paramClass)
  {
    Class[] arrayOfClass;
    int j;
    int i;
    if (this.gfw != null)
    {
      arrayOfClass = this.gfw;
      j = arrayOfClass.length;
      i = 0;
    }
    while (i < j)
    {
      if (arrayOfClass[i] == paramClass) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private int ak(Class paramClass)
  {
    int i = 0;
    while (i < this.gfv.length)
    {
      if (this.gfv[i] == paramClass) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private f.a d(Class paramClass, Object paramObject)
  {
    AppMethodBeat.i(158411);
    f localf = aj(paramClass);
    f.a locala = (f.a)localf.bx(paramObject);
    ad.d("MicroMsg.ParallelsManagement", "makeDependency on IDependency of type %s for %s with %s", new Object[] { paramClass, paramObject, localf });
    Object localObject = locala;
    if (locala == null)
    {
      localObject = this.gfx.get(paramClass);
      paramClass = (Class)localObject;
      if (localObject == null) {
        paramClass = paramObject;
      }
      localf.q(paramObject, paramClass);
      localObject = (f.a)localf.bx(paramObject);
    }
    AppMethodBeat.o(158411);
    return localObject;
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(158406);
    ad.i("MicroMsg.ParallelsManagement", "ParallelsManagement resolvedOne %s for type %s then next %s", new Object[] { parama, parama.gfq.geU, parama.gfq.gfC });
    aj(parama.gfq.geU).a(parama);
    if (parama.gfq.gfC != null) {
      aj(parama.gfq.gfC).bD(parama);
    }
    AppMethodBeat.o(158406);
  }
  
  public final void a(Class paramClass, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(158408);
    if (ai(paramClass))
    {
      paramClass = aj(paramClass);
      if (paramClass != null) {
        paramClass.q(paramObject1, paramObject2);
      }
      AppMethodBeat.o(158408);
      return;
    }
    j.w("MicroMsg.ParallelsManagement", "Not allow phase(%s) has dependency", new Object[] { paramClass });
    AppMethodBeat.o(158408);
  }
  
  public final void a(Class... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(158399);
    this.gfv = new Class[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.gfv, 0, paramVarArgs.length);
    while (i < this.gfv.length)
    {
      this.gfu.put(this.gfv[i], new f(this.gfv[i], this, this));
      i += 1;
    }
    AppMethodBeat.o(158399);
  }
  
  public final f.a agd()
  {
    AppMethodBeat.i(158405);
    synchronized (this.gfz)
    {
      f.a locala = (f.a)this.gfz.poll();
      AppMethodBeat.o(158405);
      return locala;
    }
  }
  
  public final Map<f, List<com.tencent.mm.kernel.a.a.a.a>> agq()
  {
    AppMethodBeat.i(158400);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.gfu.values().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      List localList = localf.agk();
      if (localList.size() > 0) {
        localHashMap.put(localf, localList);
      }
    }
    AppMethodBeat.o(158400);
    return localHashMap;
  }
  
  public final void agr()
  {
    AppMethodBeat.i(158404);
    synchronized (this.gfv)
    {
      if (this.gfv.length <= this.gfy)
      {
        AppMethodBeat.o(158404);
        return;
      }
      prepare();
    }
  }
  
  public final <T> f<T> aj(Class<T> paramClass)
  {
    AppMethodBeat.i(158401);
    paramClass = (f)this.gfu.get(paramClass);
    AppMethodBeat.o(158401);
    return paramClass;
  }
  
  public final void b(f.a<Object> parama)
  {
    AppMethodBeat.i(158407);
    synchronized (this.gfz)
    {
      this.gfz.offer(parama);
      ad.d("MicroMsg.ParallelsManagement", "ParallelsManagement provideOne %s %s", new Object[] { parama, parama.gfq.geU });
      AppMethodBeat.o(158407);
      return;
    }
  }
  
  public final void b(Class paramClass, boolean paramBoolean)
  {
    AppMethodBeat.i(158402);
    int j = Math.min(ak(paramClass), this.gfv.length - 1);
    if ((j >= 0) && (this.gfy > j))
    {
      int i = j;
      while (i < this.gfy)
      {
        aj(this.gfv[i]).reset(paramBoolean);
        i += 1;
      }
      this.gfy = j;
    }
    AppMethodBeat.o(158402);
  }
  
  public final boolean bE(Object paramObject)
  {
    AppMethodBeat.i(158409);
    paramObject = (a)this.gfA.get(paramObject);
    if ((paramObject != null) && (paramObject.ags()))
    {
      AppMethodBeat.o(158409);
      return true;
    }
    AppMethodBeat.o(158409);
    return false;
  }
  
  public final void bF(Object arg1)
  {
    int j = 0;
    AppMethodBeat.i(158410);
    if (!this.gfA.containsKey(???)) {
      this.gfA.putIfAbsent(???, new a((byte)0));
    }
    a locala = (a)this.gfA.get(???);
    for (;;)
    {
      int i;
      synchronized (locala.lock)
      {
        if (locala.lock[0] == 2)
        {
          if (locala.ags())
          {
            j.i("MicroMsg.ParallelsManagement", "%s Has done. return.", new Object[] { ??? });
            AppMethodBeat.o(158410);
          }
        }
        else
        {
          i = locala.lock[0];
          if (i != 1) {}
        }
      }
      try
      {
        locala.lock.wait();
        for (;;)
        {
          label123:
          break;
          ??? = finally;
          AppMethodBeat.o(158410);
          throw ???;
          locala.lock[0] = 1;
        }
        j.d("MicroMsg.ParallelsManagement", "Make dependency on subject(%s), hashcode(%s)", new Object[] { ???, Integer.valueOf(???.hashCode()) });
        if ((??? instanceof b))
        {
          a.start();
          ((b)???).parallelsDependency();
          ??? = a.agc();
          if (((a.b)???).dz != null)
          {
            ??? = ((a.b)???).dz.values().iterator();
            while (((Iterator)???).hasNext())
            {
              localObject3 = (a.a)((Iterator)???).next();
              localObject4 = ((a.a)localObject3).geV.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = ((Iterator)localObject4).next();
                if (aj(((a.a)localObject3).geU).bx(localObject5) == null)
                {
                  j.i("MicroMsg.ParallelsManagement", "Traversal make dependency for %s by subject(%s)", new Object[] { localObject5, ??? });
                  bF(localObject5);
                }
                a(((a.a)localObject3).geU, ???, localObject5);
              }
            }
          }
        }
        ??? = new ArrayList();
        Object localObject3 = this.gfv;
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
            label446:
            if (??? == null) {
              break label542;
            }
            label451:
            if (localObject3 == null) {
              break label554;
            }
          }
          label542:
          label554:
          for (localObject3 = d((Class)localObject3, ???);; localObject3 = null)
          {
            ((f.a)???).gfo = ((f.a)localObject4);
            ((f.a)???).gfp = ((f.a)localObject3);
            if (localObject4 != null) {
              ((f.a)???).gfq.gfB = ((f.a)localObject4).gfq.geU;
            }
            if (localObject3 != null) {
              ((f.a)???).gfq.gfC = ((f.a)localObject3).gfq.geU;
            }
            i += 1;
            localObject4 = ???;
            ??? = localObject3;
            break;
            localObject3 = null;
            break label446;
            ??? = d(localClass, ???);
            break label451;
          }
        }
        synchronized (locala.lock)
        {
          if (locala.lock[0] == 1)
          {
            locala.lock[0] = 2;
            locala.lock.notifyAll();
          }
          AppMethodBeat.o(158410);
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label123;
      }
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(158403);
    j.i("MicroMsg.ParallelsManagement", "prepare()", new Object[0]);
    for (;;)
    {
      synchronized (this.gfv)
      {
        if (this.gfv.length > this.gfy)
        {
          i = this.gfy;
          this.gfy += 1;
          if (i != -1) {
            aj(this.gfv[i]).prepare();
          }
          AppMethodBeat.o(158403);
          return;
        }
      }
      int i = -1;
    }
  }
  
  static final class a
  {
    byte[] lock;
    
    private a()
    {
      AppMethodBeat.i(158397);
      this.lock = new byte[1];
      AppMethodBeat.o(158397);
    }
    
    final boolean ags()
    {
      boolean bool = false;
      synchronized (this.lock)
      {
        if (this.lock[0] == 2) {
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