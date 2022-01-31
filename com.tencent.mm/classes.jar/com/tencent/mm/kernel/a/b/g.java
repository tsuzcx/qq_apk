package com.tencent.mm.kernel.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ab;
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
  private Map<Class<?>, f<Object>> eKl;
  private Class<?>[] eKm;
  public volatile Class<?>[] eKn;
  public Map<Class, Object> eKo;
  private int eKp;
  private Queue<f.a> eKq;
  private ConcurrentHashMap<Object, a> eKr;
  
  public g()
  {
    AppMethodBeat.i(123345);
    this.eKl = new ConcurrentHashMap();
    this.eKo = new ConcurrentHashMap();
    this.eKp = 0;
    this.eKq = new ConcurrentLinkedQueue();
    this.eKr = new ConcurrentHashMap();
    AppMethodBeat.o(123345);
  }
  
  private boolean L(Class paramClass)
  {
    Class[] arrayOfClass;
    int j;
    int i;
    if (this.eKn != null)
    {
      arrayOfClass = this.eKn;
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
  
  private int N(Class paramClass)
  {
    int i = 0;
    while (i < this.eKm.length)
    {
      if (this.eKm[i] == paramClass) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private f.a d(Class paramClass, Object paramObject)
  {
    AppMethodBeat.i(123358);
    f localf = M(paramClass);
    f.a locala = (f.a)localf.av(paramObject);
    ab.d("MicroMsg.ParallelsManagement", "makeDependency on IDependency of type %s for %s with %s", new Object[] { paramClass, paramObject, localf });
    Object localObject = locala;
    if (locala == null)
    {
      localObject = this.eKo.get(paramClass);
      paramClass = (Class)localObject;
      if (localObject == null) {
        paramClass = paramObject;
      }
      localf.i(paramObject, paramClass);
      localObject = (f.a)localf.av(paramObject);
    }
    AppMethodBeat.o(123358);
    return localObject;
  }
  
  public final <T> f<T> M(Class<T> paramClass)
  {
    AppMethodBeat.i(123348);
    paramClass = (f)this.eKl.get(paramClass);
    AppMethodBeat.o(123348);
    return paramClass;
  }
  
  public final void SA()
  {
    AppMethodBeat.i(123351);
    synchronized (this.eKm)
    {
      if (this.eKm.length <= this.eKp)
      {
        AppMethodBeat.o(123351);
        return;
      }
      prepare();
    }
  }
  
  public final f.a Sm()
  {
    AppMethodBeat.i(123352);
    synchronized (this.eKq)
    {
      f.a locala = (f.a)this.eKq.poll();
      AppMethodBeat.o(123352);
      return locala;
    }
  }
  
  public final Map<f, List<com.tencent.mm.kernel.a.a.a.a>> Sz()
  {
    AppMethodBeat.i(123347);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.eKl.values().iterator();
    while (localIterator.hasNext())
    {
      f localf = (f)localIterator.next();
      List localList = localf.St();
      if (localList.size() > 0) {
        localHashMap.put(localf, localList);
      }
    }
    AppMethodBeat.o(123347);
    return localHashMap;
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(123353);
    ab.i("MicroMsg.ParallelsManagement", "ParallelsManagement resolvedOne %s for type %s then next %s", new Object[] { parama, parama.eKh.eJL, parama.eKh.eKu });
    M(parama.eKh.eJL).a(parama);
    if (parama.eKh.eKu != null) {
      M(parama.eKh.eKu).aB(parama);
    }
    AppMethodBeat.o(123353);
  }
  
  public final void a(Class paramClass, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(123355);
    if (L(paramClass))
    {
      paramClass = M(paramClass);
      if (paramClass != null) {
        paramClass.i(paramObject1, paramObject2);
      }
      AppMethodBeat.o(123355);
      return;
    }
    j.w("MicroMsg.ParallelsManagement", "Not allow phase(%s) has dependency", new Object[] { paramClass });
    AppMethodBeat.o(123355);
  }
  
  public final void a(Class... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(123346);
    this.eKm = new Class[paramVarArgs.length];
    System.arraycopy(paramVarArgs, 0, this.eKm, 0, paramVarArgs.length);
    while (i < this.eKm.length)
    {
      this.eKl.put(this.eKm[i], new f(this.eKm[i], this, this));
      i += 1;
    }
    AppMethodBeat.o(123346);
  }
  
  public final boolean aC(Object paramObject)
  {
    AppMethodBeat.i(123356);
    paramObject = (a)this.eKr.get(paramObject);
    if ((paramObject != null) && (paramObject.SB()))
    {
      AppMethodBeat.o(123356);
      return true;
    }
    AppMethodBeat.o(123356);
    return false;
  }
  
  public final void aD(Object arg1)
  {
    int j = 0;
    AppMethodBeat.i(123357);
    if (!this.eKr.containsKey(???)) {
      this.eKr.putIfAbsent(???, new a((byte)0));
    }
    a locala = (a)this.eKr.get(???);
    for (;;)
    {
      int i;
      synchronized (locala.eKs)
      {
        if (locala.eKs[0] == 2)
        {
          if (locala.SB())
          {
            j.i("MicroMsg.ParallelsManagement", "%s Has done. return.", new Object[] { ??? });
            AppMethodBeat.o(123357);
          }
        }
        else
        {
          i = locala.eKs[0];
          if (i != 1) {}
        }
      }
      try
      {
        locala.eKs.wait();
        for (;;)
        {
          label122:
          break;
          ??? = finally;
          AppMethodBeat.o(123357);
          throw ???;
          locala.eKs[0] = 1;
        }
        j.d("MicroMsg.ParallelsManagement", "Make dependency on subject(%s), hashcode(%s)", new Object[] { ???, Integer.valueOf(???.hashCode()) });
        if ((??? instanceof b))
        {
          a.start();
          ((b)???).parallelsDependency();
          ??? = a.Sl();
          if (((a.b)???).dw != null)
          {
            ??? = ((a.b)???).dw.values().iterator();
            while (((Iterator)???).hasNext())
            {
              localObject3 = (a.a)((Iterator)???).next();
              localObject4 = ((a.a)localObject3).eJM.iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject5 = ((Iterator)localObject4).next();
                if (M(((a.a)localObject3).eJL).av(localObject5) == null)
                {
                  j.i("MicroMsg.ParallelsManagement", "Traversal make dependency for %s by subject(%s)", new Object[] { localObject5, ??? });
                  aD(localObject5);
                }
                a(((a.a)localObject3).eJL, ???, localObject5);
              }
            }
          }
        }
        ??? = new ArrayList();
        Object localObject3 = this.eKm;
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
            ((f.a)???).eKf = ((f.a)localObject4);
            ((f.a)???).eKg = ((f.a)localObject3);
            if (localObject4 != null) {
              ((f.a)???).eKh.eKt = ((f.a)localObject4).eKh.eJL;
            }
            if (localObject3 != null) {
              ((f.a)???).eKh.eKu = ((f.a)localObject3).eKh.eJL;
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
        synchronized (locala.eKs)
        {
          if (locala.eKs[0] == 1)
          {
            locala.eKs[0] = 2;
            locala.eKs.notifyAll();
          }
          AppMethodBeat.o(123357);
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label122;
      }
    }
  }
  
  public final void b(f.a<Object> parama)
  {
    AppMethodBeat.i(123354);
    synchronized (this.eKq)
    {
      this.eKq.offer(parama);
      ab.d("MicroMsg.ParallelsManagement", "ParallelsManagement provideOne %s %s", new Object[] { parama, parama.eKh.eJL });
      AppMethodBeat.o(123354);
      return;
    }
  }
  
  public final void c(Class paramClass, boolean paramBoolean)
  {
    AppMethodBeat.i(123349);
    int j = Math.min(N(paramClass), this.eKm.length - 1);
    if ((j >= 0) && (this.eKp > j))
    {
      int i = j;
      while (i < this.eKp)
      {
        M(this.eKm[i]).reset(paramBoolean);
        i += 1;
      }
      this.eKp = j;
    }
    AppMethodBeat.o(123349);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(123350);
    j.i("MicroMsg.ParallelsManagement", "prepare()", new Object[0]);
    for (;;)
    {
      synchronized (this.eKm)
      {
        if (this.eKm.length > this.eKp)
        {
          i = this.eKp;
          this.eKp += 1;
          if (i != -1) {
            M(this.eKm[i]).prepare();
          }
          AppMethodBeat.o(123350);
          return;
        }
      }
      int i = -1;
    }
  }
  
  static final class a
  {
    byte[] eKs;
    
    private a()
    {
      AppMethodBeat.i(123344);
      this.eKs = new byte[1];
      AppMethodBeat.o(123344);
    }
    
    final boolean SB()
    {
      boolean bool = false;
      synchronized (this.eKs)
      {
        if (this.eKs[0] == 2) {
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