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
  private Map<Class<?>, f<Object>> mFk;
  private Class<?>[] mFl;
  private volatile Class<?>[] mFm;
  public Map<Class, Object> mFn;
  private int mFo;
  private Queue<f.a> mFp;
  private ConcurrentHashMap<Object, a> mFq;
  
  public g()
  {
    AppMethodBeat.i(158398);
    this.mFk = new ConcurrentHashMap();
    this.mFn = new ConcurrentHashMap();
    this.mFo = 0;
    this.mFp = new ConcurrentLinkedQueue();
    this.mFq = new ConcurrentHashMap();
    AppMethodBeat.o(158398);
  }
  
  private boolean aE(Class paramClass)
  {
    Class[] arrayOfClass;
    int j;
    int i;
    if (this.mFm != null)
    {
      arrayOfClass = this.mFm;
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
  
  private int aG(Class paramClass)
  {
    int i = 0;
    while (i < this.mFl.length)
    {
      if (this.mFl[i] == paramClass) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private f.a d(Class paramClass, Object paramObject)
  {
    AppMethodBeat.i(158411);
    f localf = aF(paramClass);
    f.a locala = (f.a)localf.cX(paramObject);
    Log.d("MicroMsg.ParallelsManagement", "makeDependency on IDependency of type %s for %s with %s", new Object[] { paramClass, paramObject, localf });
    Object localObject = locala;
    if (locala == null)
    {
      localObject = this.mFn.get(paramClass);
      paramClass = (Class)localObject;
      if (localObject == null) {
        paramClass = paramObject;
      }
      localf.D(paramObject, paramClass);
      localObject = (f.a)localf.cX(paramObject);
    }
    AppMethodBeat.o(158411);
    return localObject;
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(158406);
    Log.i("MicroMsg.ParallelsManagement", "ParallelsManagement resolvedOne %s for type %s then next %s", new Object[] { parama, parama.mFg.btN, parama.mFg.mFs });
    aF(parama.mFg.btN).a(parama);
    if (parama.mFg.mFs != null) {
      aF(parama.mFg.mFs).dd(parama);
    }
    AppMethodBeat.o(158406);
  }
  
  public final void a(Class paramClass, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(158408);
    if (aE(paramClass))
    {
      paramClass = aF(paramClass);
      if (paramClass != null) {
        paramClass.D(paramObject1, paramObject2);
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
    this.mFl = new Class[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.mFl, 0, paramVarArgs.length);
    while (i < this.mFl.length)
    {
      this.mFk.put(this.mFl[i], new f(this.mFl[i], this, this));
      i += 1;
    }
    AppMethodBeat.o(158399);
  }
  
  public final <T> f<T> aF(Class<T> paramClass)
  {
    AppMethodBeat.i(158401);
    paramClass = (f)this.mFk.get(paramClass);
    AppMethodBeat.o(158401);
    return paramClass;
  }
  
  public final void b(f.a<Object> parama)
  {
    AppMethodBeat.i(158407);
    synchronized (this.mFp)
    {
      this.mFp.offer(parama);
      Log.d("MicroMsg.ParallelsManagement", "ParallelsManagement provideOne %s %s", new Object[] { parama, parama.mFg.btN });
      AppMethodBeat.o(158407);
      return;
    }
  }
  
  public final void b(Class... paramVarArgs)
  {
    AppMethodBeat.i(235304);
    this.mFm = new Class[1];
    System.arraycopy(paramVarArgs, 0, this.mFm, 0, 1);
    AppMethodBeat.o(235304);
  }
  
  public final f.a bbh()
  {
    AppMethodBeat.i(158405);
    synchronized (this.mFp)
    {
      f.a locala = (f.a)this.mFp.poll();
      AppMethodBeat.o(158405);
      return locala;
    }
  }
  
  public final Map<f, List<com.tencent.mm.kernel.a.a.a.a>> bbu()
  {
    AppMethodBeat.i(158400);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.mFk.values().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      List localList = localf.bbo();
      if (localList.size() > 0) {
        localHashMap.put(localf, localList);
      }
    }
    AppMethodBeat.o(158400);
    return localHashMap;
  }
  
  public final void bbv()
  {
    AppMethodBeat.i(158404);
    synchronized (this.mFl)
    {
      if (this.mFl.length <= this.mFo)
      {
        AppMethodBeat.o(158404);
        return;
      }
      prepare();
    }
  }
  
  public final void c(Class paramClass, boolean paramBoolean)
  {
    AppMethodBeat.i(158402);
    int j = Math.min(aG(paramClass), this.mFl.length - 1);
    if ((j >= 0) && (this.mFo > j))
    {
      int i = j;
      while (i < this.mFo)
      {
        aF(this.mFl[i]).reset(paramBoolean);
        i += 1;
      }
      this.mFo = j;
    }
    AppMethodBeat.o(158402);
  }
  
  public final boolean de(Object paramObject)
  {
    AppMethodBeat.i(158409);
    paramObject = (a)this.mFq.get(paramObject);
    if ((paramObject != null) && (paramObject.bbw()))
    {
      AppMethodBeat.o(158409);
      return true;
    }
    AppMethodBeat.o(158409);
    return false;
  }
  
  public final void df(Object arg1)
  {
    int j = 0;
    AppMethodBeat.i(158410);
    if (!this.mFq.containsKey(???)) {
      this.mFq.putIfAbsent(???, new a((byte)0));
    }
    a locala = (a)this.mFq.get(???);
    for (;;)
    {
      int i;
      synchronized (locala.lock)
      {
        if (locala.lock[0] == 2)
        {
          if (locala.bbw())
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
          label123:
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
          ??? = a.bbg();
          if (((a.b)???).bIx != null)
          {
            ??? = ((a.b)???).bIx.values().iterator();
            while (((Iterator)???).hasNext())
            {
              localObject3 = (a.a)((Iterator)???).next();
              localObject4 = ((a.a)localObject3).mEK.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = ((Iterator)localObject4).next();
                if (aF(((a.a)localObject3).btN).cX(localObject5) == null)
                {
                  l.i("MicroMsg.ParallelsManagement", "Traversal make dependency for %s by subject(%s)", new Object[] { localObject5, ??? });
                  df(localObject5);
                }
                a(((a.a)localObject3).btN, ???, localObject5);
              }
            }
          }
        }
        ??? = new ArrayList();
        Object localObject3 = this.mFl;
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
            ((f.a)???).mFe = ((f.a)localObject4);
            ((f.a)???).mFf = ((f.a)localObject3);
            if (localObject4 != null) {
              ((f.a)???).mFg.mFr = ((f.a)localObject4).mFg.btN;
            }
            if (localObject3 != null) {
              ((f.a)???).mFg.mFs = ((f.a)localObject3).mFg.btN;
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
    l.d("MicroMsg.ParallelsManagement", "prepare()", new Object[0]);
    for (;;)
    {
      synchronized (this.mFl)
      {
        if (this.mFl.length > this.mFo)
        {
          i = this.mFo;
          this.mFo += 1;
          if (i != -1) {
            aF(this.mFl[i]).prepare();
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
    
    final boolean bbw()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kernel.a.b.g
 * JD-Core Version:    0.7.0.1
 */