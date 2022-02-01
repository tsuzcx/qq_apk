package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.Log;
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
  private Map<Class<?>, f<Object>> htf;
  private Class<?>[] htg;
  public volatile Class<?>[] hth;
  public Map<Class, Object> hti;
  private int htj;
  private Queue<f.a> htk;
  private ConcurrentHashMap<Object, a> htl;
  
  public g()
  {
    AppMethodBeat.i(158398);
    this.htf = new ConcurrentHashMap();
    this.hti = new ConcurrentHashMap();
    this.htj = 0;
    this.htk = new ConcurrentLinkedQueue();
    this.htl = new ConcurrentHashMap();
    AppMethodBeat.o(158398);
  }
  
  private boolean am(Class paramClass)
  {
    Class[] arrayOfClass;
    int j;
    int i;
    if (this.hth != null)
    {
      arrayOfClass = this.hth;
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
  
  private int ao(Class paramClass)
  {
    int i = 0;
    while (i < this.htg.length)
    {
      if (this.htg[i] == paramClass) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private f.a d(Class paramClass, Object paramObject)
  {
    AppMethodBeat.i(158411);
    f localf = an(paramClass);
    f.a locala = (f.a)localf.bE(paramObject);
    Log.d("MicroMsg.ParallelsManagement", "makeDependency on IDependency of type %s for %s with %s", new Object[] { paramClass, paramObject, localf });
    Object localObject = locala;
    if (locala == null)
    {
      localObject = this.hti.get(paramClass);
      paramClass = (Class)localObject;
      if (localObject == null) {
        paramClass = paramObject;
      }
      localf.z(paramObject, paramClass);
      localObject = (f.a)localf.bE(paramObject);
    }
    AppMethodBeat.o(158411);
    return localObject;
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(158406);
    Log.i("MicroMsg.ParallelsManagement", "ParallelsManagement resolvedOne %s for type %s then next %s", new Object[] { parama, parama.htb.hsF, parama.htb.htn });
    an(parama.htb.hsF).a(parama);
    if (parama.htb.htn != null) {
      an(parama.htb.htn).bK(parama);
    }
    AppMethodBeat.o(158406);
  }
  
  public final void a(Class paramClass, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(158408);
    if (am(paramClass))
    {
      paramClass = an(paramClass);
      if (paramClass != null) {
        paramClass.z(paramObject1, paramObject2);
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
    this.htg = new Class[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.htg, 0, paramVarArgs.length);
    while (i < this.htg.length)
    {
      this.htf.put(this.htg[i], new f(this.htg[i], this, this));
      i += 1;
    }
    AppMethodBeat.o(158399);
  }
  
  public final f.a aAJ()
  {
    AppMethodBeat.i(158405);
    synchronized (this.htk)
    {
      f.a locala = (f.a)this.htk.poll();
      AppMethodBeat.o(158405);
      return locala;
    }
  }
  
  public final Map<f, List<com.tencent.mm.kernel.a.a.a.a>> aAW()
  {
    AppMethodBeat.i(158400);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.htf.values().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      List localList = localf.aAQ();
      if (localList.size() > 0) {
        localHashMap.put(localf, localList);
      }
    }
    AppMethodBeat.o(158400);
    return localHashMap;
  }
  
  public final void aAX()
  {
    AppMethodBeat.i(158404);
    synchronized (this.htg)
    {
      if (this.htg.length <= this.htj)
      {
        AppMethodBeat.o(158404);
        return;
      }
      prepare();
    }
  }
  
  public final <T> f<T> an(Class<T> paramClass)
  {
    AppMethodBeat.i(158401);
    paramClass = (f)this.htf.get(paramClass);
    AppMethodBeat.o(158401);
    return paramClass;
  }
  
  public final void b(f.a<Object> parama)
  {
    AppMethodBeat.i(158407);
    synchronized (this.htk)
    {
      this.htk.offer(parama);
      Log.d("MicroMsg.ParallelsManagement", "ParallelsManagement provideOne %s %s", new Object[] { parama, parama.htb.hsF });
      AppMethodBeat.o(158407);
      return;
    }
  }
  
  public final boolean bL(Object paramObject)
  {
    AppMethodBeat.i(158409);
    paramObject = (a)this.htl.get(paramObject);
    if ((paramObject != null) && (paramObject.aAY()))
    {
      AppMethodBeat.o(158409);
      return true;
    }
    AppMethodBeat.o(158409);
    return false;
  }
  
  public final void bM(Object arg1)
  {
    int j = 0;
    AppMethodBeat.i(158410);
    if (!this.htl.containsKey(???)) {
      this.htl.putIfAbsent(???, new a((byte)0));
    }
    a locala = (a)this.htl.get(???);
    for (;;)
    {
      int i;
      synchronized (locala.lock)
      {
        if (locala.lock[0] == 2)
        {
          if (locala.aAY())
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
          label122:
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
          ??? = a.aAI();
          if (((a.b)???).mMap != null)
          {
            ??? = ((a.b)???).mMap.values().iterator();
            while (((Iterator)???).hasNext())
            {
              localObject3 = (a.a)((Iterator)???).next();
              localObject4 = ((a.a)localObject3).hsG.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = ((Iterator)localObject4).next();
                if (an(((a.a)localObject3).hsF).bE(localObject5) == null)
                {
                  j.i("MicroMsg.ParallelsManagement", "Traversal make dependency for %s by subject(%s)", new Object[] { localObject5, ??? });
                  bM(localObject5);
                }
                a(((a.a)localObject3).hsF, ???, localObject5);
              }
            }
          }
        }
        ??? = new ArrayList();
        Object localObject3 = this.htg;
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
            label444:
            if (??? == null) {
              break label540;
            }
            label449:
            if (localObject3 == null) {
              break label552;
            }
          }
          label540:
          label552:
          for (localObject3 = d((Class)localObject3, ???);; localObject3 = null)
          {
            ((f.a)???).hsZ = ((f.a)localObject4);
            ((f.a)???).hta = ((f.a)localObject3);
            if (localObject4 != null) {
              ((f.a)???).htb.htm = ((f.a)localObject4).htb.hsF;
            }
            if (localObject3 != null) {
              ((f.a)???).htb.htn = ((f.a)localObject3).htb.hsF;
            }
            i += 1;
            localObject4 = ???;
            ??? = localObject3;
            break;
            localObject3 = null;
            break label444;
            ??? = d(localClass, ???);
            break label449;
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
        break label122;
      }
    }
  }
  
  public final void c(Class paramClass, boolean paramBoolean)
  {
    AppMethodBeat.i(158402);
    int j = Math.min(ao(paramClass), this.htg.length - 1);
    if ((j >= 0) && (this.htj > j))
    {
      int i = j;
      while (i < this.htj)
      {
        an(this.htg[i]).reset(paramBoolean);
        i += 1;
      }
      this.htj = j;
    }
    AppMethodBeat.o(158402);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(158403);
    j.i("MicroMsg.ParallelsManagement", "prepare()", new Object[0]);
    for (;;)
    {
      synchronized (this.htg)
      {
        if (this.htg.length > this.htj)
        {
          i = this.htj;
          this.htj += 1;
          if (i != -1) {
            an(this.htg[i]).prepare();
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
    
    final boolean aAY()
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