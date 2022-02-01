package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.l;
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
  private Map<Class<?>, f<Object>> kfa;
  private Class<?>[] kfb;
  private volatile Class<?>[] kfc;
  public Map<Class, Object> kfd;
  private int kfe;
  private Queue<f.a> kff;
  private ConcurrentHashMap<Object, a> kfg;
  
  public g()
  {
    AppMethodBeat.i(158398);
    this.kfa = new ConcurrentHashMap();
    this.kfd = new ConcurrentHashMap();
    this.kfe = 0;
    this.kff = new ConcurrentLinkedQueue();
    this.kfg = new ConcurrentHashMap();
    AppMethodBeat.o(158398);
  }
  
  private boolean al(Class paramClass)
  {
    Class[] arrayOfClass;
    int j;
    int i;
    if (this.kfc != null)
    {
      arrayOfClass = this.kfc;
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
  
  private int an(Class paramClass)
  {
    int i = 0;
    while (i < this.kfb.length)
    {
      if (this.kfb[i] == paramClass) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private f.a d(Class paramClass, Object paramObject)
  {
    AppMethodBeat.i(158411);
    f localf = am(paramClass);
    f.a locala = (f.a)localf.bE(paramObject);
    Log.d("MicroMsg.ParallelsManagement", "makeDependency on IDependency of type %s for %s with %s", new Object[] { paramClass, paramObject, localf });
    Object localObject = locala;
    if (locala == null)
    {
      localObject = this.kfd.get(paramClass);
      paramClass = (Class)localObject;
      if (localObject == null) {
        paramClass = paramObject;
      }
      localf.s(paramObject, paramClass);
      localObject = (f.a)localf.bE(paramObject);
    }
    AppMethodBeat.o(158411);
    return localObject;
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(158406);
    Log.i("MicroMsg.ParallelsManagement", "ParallelsManagement resolvedOne %s for type %s then next %s", new Object[] { parama, parama.keW.NJ, parama.keW.kfi });
    am(parama.keW.NJ).a(parama);
    if (parama.keW.kfi != null) {
      am(parama.keW.kfi).bK(parama);
    }
    AppMethodBeat.o(158406);
  }
  
  public final void a(Class paramClass, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(158408);
    if (al(paramClass))
    {
      paramClass = am(paramClass);
      if (paramClass != null) {
        paramClass.s(paramObject1, paramObject2);
      }
      AppMethodBeat.o(158408);
      return;
    }
    l.w("MicroMsg.ParallelsManagement", "Not allow phase(%s) has dependency", new Object[] { paramClass });
    AppMethodBeat.o(158408);
  }
  
  public final void a(Class... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(158399);
    this.kfb = new Class[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.kfb, 0, paramVarArgs.length);
    while (i < this.kfb.length)
    {
      this.kfa.put(this.kfb[i], new f(this.kfb[i], this, this));
      i += 1;
    }
    AppMethodBeat.o(158399);
  }
  
  public final void aIA()
  {
    AppMethodBeat.i(158404);
    synchronized (this.kfb)
    {
      if (this.kfb.length <= this.kfe)
      {
        AppMethodBeat.o(158404);
        return;
      }
      prepare();
    }
  }
  
  public final f.a aIm()
  {
    AppMethodBeat.i(158405);
    synchronized (this.kff)
    {
      f.a locala = (f.a)this.kff.poll();
      AppMethodBeat.o(158405);
      return locala;
    }
  }
  
  public final Map<f, List<com.tencent.mm.kernel.a.a.a.a>> aIz()
  {
    AppMethodBeat.i(158400);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.kfa.values().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      List localList = localf.aIt();
      if (localList.size() > 0) {
        localHashMap.put(localf, localList);
      }
    }
    AppMethodBeat.o(158400);
    return localHashMap;
  }
  
  public final <T> f<T> am(Class<T> paramClass)
  {
    AppMethodBeat.i(158401);
    paramClass = (f)this.kfa.get(paramClass);
    AppMethodBeat.o(158401);
    return paramClass;
  }
  
  public final void b(f.a<Object> parama)
  {
    AppMethodBeat.i(158407);
    synchronized (this.kff)
    {
      this.kff.offer(parama);
      Log.d("MicroMsg.ParallelsManagement", "ParallelsManagement provideOne %s %s", new Object[] { parama, parama.keW.NJ });
      AppMethodBeat.o(158407);
      return;
    }
  }
  
  public final void b(Class... paramVarArgs)
  {
    AppMethodBeat.i(199517);
    this.kfc = new Class[1];
    System.arraycopy(paramVarArgs, 0, this.kfc, 0, 1);
    AppMethodBeat.o(199517);
  }
  
  public final boolean bL(Object paramObject)
  {
    AppMethodBeat.i(158409);
    paramObject = (a)this.kfg.get(paramObject);
    if ((paramObject != null) && (paramObject.aIB()))
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
    if (!this.kfg.containsKey(???)) {
      this.kfg.putIfAbsent(???, new a((byte)0));
    }
    a locala = (a)this.kfg.get(???);
    for (;;)
    {
      int i;
      synchronized (locala.lock)
      {
        if (locala.lock[0] == 2)
        {
          if (locala.aIB())
          {
            l.d("MicroMsg.ParallelsManagement", "%s Has done. return.", new Object[] { ??? });
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
        l.d("MicroMsg.ParallelsManagement", "Make dependency on subject(%s), hashcode(%s)", new Object[] { ???, Integer.valueOf(???.hashCode()) });
        if ((??? instanceof b))
        {
          a.start();
          ((b)???).parallelsDependency();
          ??? = a.aIl();
          if (((a.b)???).aaP != null)
          {
            ??? = ((a.b)???).aaP.values().iterator();
            while (((Iterator)???).hasNext())
            {
              localObject3 = (a.a)((Iterator)???).next();
              localObject4 = ((a.a)localObject3).keB.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = ((Iterator)localObject4).next();
                if (am(((a.a)localObject3).NJ).bE(localObject5) == null)
                {
                  l.i("MicroMsg.ParallelsManagement", "Traversal make dependency for %s by subject(%s)", new Object[] { localObject5, ??? });
                  bM(localObject5);
                }
                a(((a.a)localObject3).NJ, ???, localObject5);
              }
            }
          }
        }
        ??? = new ArrayList();
        Object localObject3 = this.kfb;
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
            ((f.a)???).keU = ((f.a)localObject4);
            ((f.a)???).keV = ((f.a)localObject3);
            if (localObject4 != null) {
              ((f.a)???).keW.kfh = ((f.a)localObject4).keW.NJ;
            }
            if (localObject3 != null) {
              ((f.a)???).keW.kfi = ((f.a)localObject3).keW.NJ;
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
    int j = Math.min(an(paramClass), this.kfb.length - 1);
    if ((j >= 0) && (this.kfe > j))
    {
      int i = j;
      while (i < this.kfe)
      {
        am(this.kfb[i]).reset(paramBoolean);
        i += 1;
      }
      this.kfe = j;
    }
    AppMethodBeat.o(158402);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(158403);
    l.d("MicroMsg.ParallelsManagement", "prepare()", new Object[0]);
    for (;;)
    {
      synchronized (this.kfb)
      {
        if (this.kfb.length > this.kfe)
        {
          i = this.kfe;
          this.kfe += 1;
          if (i != -1) {
            am(this.kfb[i]).prepare();
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
    
    final boolean aIB()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.g
 * JD-Core Version:    0.7.0.1
 */