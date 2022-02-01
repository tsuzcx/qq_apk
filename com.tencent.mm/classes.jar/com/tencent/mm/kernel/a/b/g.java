package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ac;
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
  private Map<Class<?>, f<Object>> gka;
  private Class<?>[] gkb;
  public volatile Class<?>[] gkc;
  public Map<Class, Object> gkd;
  private int gke;
  private Queue<f.a> gkf;
  private ConcurrentHashMap<Object, a> gkg;
  
  public g()
  {
    AppMethodBeat.i(158398);
    this.gka = new ConcurrentHashMap();
    this.gkd = new ConcurrentHashMap();
    this.gke = 0;
    this.gkf = new ConcurrentLinkedQueue();
    this.gkg = new ConcurrentHashMap();
    AppMethodBeat.o(158398);
  }
  
  private boolean ai(Class paramClass)
  {
    Class[] arrayOfClass;
    int j;
    int i;
    if (this.gkc != null)
    {
      arrayOfClass = this.gkc;
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
    while (i < this.gkb.length)
    {
      if (this.gkb[i] == paramClass) {
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
    f.a locala = (f.a)localf.bu(paramObject);
    ac.d("MicroMsg.ParallelsManagement", "makeDependency on IDependency of type %s for %s with %s", new Object[] { paramClass, paramObject, localf });
    Object localObject = locala;
    if (locala == null)
    {
      localObject = this.gkd.get(paramClass);
      paramClass = (Class)localObject;
      if (localObject == null) {
        paramClass = paramObject;
      }
      localf.q(paramObject, paramClass);
      localObject = (f.a)localf.bu(paramObject);
    }
    AppMethodBeat.o(158411);
    return localObject;
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(158406);
    ac.i("MicroMsg.ParallelsManagement", "ParallelsManagement resolvedOne %s for type %s then next %s", new Object[] { parama, parama.gjW.gjA, parama.gjW.gki });
    aj(parama.gjW.gjA).a(parama);
    if (parama.gjW.gki != null) {
      aj(parama.gjW.gki).bA(parama);
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
    this.gkb = new Class[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.gkb, 0, paramVarArgs.length);
    while (i < this.gkb.length)
    {
      this.gka.put(this.gkb[i], new f(this.gkb[i], this, this));
      i += 1;
    }
    AppMethodBeat.o(158399);
  }
  
  public final Map<f, List<com.tencent.mm.kernel.a.a.a.a>> ahG()
  {
    AppMethodBeat.i(158400);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.gka.values().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      List localList = localf.ahA();
      if (localList.size() > 0) {
        localHashMap.put(localf, localList);
      }
    }
    AppMethodBeat.o(158400);
    return localHashMap;
  }
  
  public final void ahH()
  {
    AppMethodBeat.i(158404);
    synchronized (this.gkb)
    {
      if (this.gkb.length <= this.gke)
      {
        AppMethodBeat.o(158404);
        return;
      }
      prepare();
    }
  }
  
  public final f.a aht()
  {
    AppMethodBeat.i(158405);
    synchronized (this.gkf)
    {
      f.a locala = (f.a)this.gkf.poll();
      AppMethodBeat.o(158405);
      return locala;
    }
  }
  
  public final <T> f<T> aj(Class<T> paramClass)
  {
    AppMethodBeat.i(158401);
    paramClass = (f)this.gka.get(paramClass);
    AppMethodBeat.o(158401);
    return paramClass;
  }
  
  public final void b(f.a<Object> parama)
  {
    AppMethodBeat.i(158407);
    synchronized (this.gkf)
    {
      this.gkf.offer(parama);
      ac.d("MicroMsg.ParallelsManagement", "ParallelsManagement provideOne %s %s", new Object[] { parama, parama.gjW.gjA });
      AppMethodBeat.o(158407);
      return;
    }
  }
  
  public final void b(Class paramClass, boolean paramBoolean)
  {
    AppMethodBeat.i(158402);
    int j = Math.min(ak(paramClass), this.gkb.length - 1);
    if ((j >= 0) && (this.gke > j))
    {
      int i = j;
      while (i < this.gke)
      {
        aj(this.gkb[i]).reset(paramBoolean);
        i += 1;
      }
      this.gke = j;
    }
    AppMethodBeat.o(158402);
  }
  
  public final boolean bB(Object paramObject)
  {
    AppMethodBeat.i(158409);
    paramObject = (a)this.gkg.get(paramObject);
    if ((paramObject != null) && (paramObject.ahI()))
    {
      AppMethodBeat.o(158409);
      return true;
    }
    AppMethodBeat.o(158409);
    return false;
  }
  
  public final void bC(Object arg1)
  {
    int j = 0;
    AppMethodBeat.i(158410);
    if (!this.gkg.containsKey(???)) {
      this.gkg.putIfAbsent(???, new a((byte)0));
    }
    a locala = (a)this.gkg.get(???);
    for (;;)
    {
      int i;
      synchronized (locala.lock)
      {
        if (locala.lock[0] == 2)
        {
          if (locala.ahI())
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
          ??? = a.ahs();
          if (((a.b)???).dz != null)
          {
            ??? = ((a.b)???).dz.values().iterator();
            while (((Iterator)???).hasNext())
            {
              localObject3 = (a.a)((Iterator)???).next();
              localObject4 = ((a.a)localObject3).gjB.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = ((Iterator)localObject4).next();
                if (aj(((a.a)localObject3).gjA).bu(localObject5) == null)
                {
                  j.i("MicroMsg.ParallelsManagement", "Traversal make dependency for %s by subject(%s)", new Object[] { localObject5, ??? });
                  bC(localObject5);
                }
                a(((a.a)localObject3).gjA, ???, localObject5);
              }
            }
          }
        }
        ??? = new ArrayList();
        Object localObject3 = this.gkb;
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
            ((f.a)???).gjU = ((f.a)localObject4);
            ((f.a)???).gjV = ((f.a)localObject3);
            if (localObject4 != null) {
              ((f.a)???).gjW.gkh = ((f.a)localObject4).gjW.gjA;
            }
            if (localObject3 != null) {
              ((f.a)???).gjW.gki = ((f.a)localObject3).gjW.gjA;
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
      synchronized (this.gkb)
      {
        if (this.gkb.length > this.gke)
        {
          i = this.gke;
          this.gke += 1;
          if (i != -1) {
            aj(this.gkb[i]).prepare();
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
    
    final boolean ahI()
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