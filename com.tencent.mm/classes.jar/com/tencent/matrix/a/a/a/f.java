package com.tencent.matrix.a.a.a;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.matrix.a.a.a;
import com.tencent.matrix.a.b.b;
import java.lang.Class<+Lcom.tencent.matrix.a.a.a.m.a<*>;>;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

public class f
{
  protected com.tencent.matrix.a.a.d eOp;
  protected final List<Class<? extends m.a<?>>> eQX = new ArrayList();
  protected final Map<Class<? extends m.a<?>>, m.a<?>> eQY = new HashMap();
  protected final Map<Class<? extends m.a<?>>, m.a.a<?>> eQZ = new HashMap();
  protected final Map<Class<? extends m.a<?>>, Long> eRa = new HashMap();
  protected final Map<Class<? extends m.a<?>>, m.a.d> eRb = new HashMap();
  protected final Map<Class<? extends m.a<?>>, m.a.d.a> eRc = new HashMap();
  protected a eRd;
  protected long eRe = SystemClock.uptimeMillis();
  
  public f(com.tencent.matrix.a.a.d paramd)
  {
    this.eOp = paramd;
  }
  
  public final void a(a parama)
  {
    this.eRd = parama;
  }
  
  public final void a(com.tencent.matrix.a.b.d<a> paramd)
  {
    a locala = this.eRd;
    if (locala != null) {
      paramd.accept(locala);
    }
  }
  
  public final void a(Class<? extends m.a<?>> paramClass, m.a.a<? extends m.a<?>> parama)
  {
    this.eQZ.put(paramClass, parama);
  }
  
  public final <T extends m> void a(Class<T> paramClass, com.tencent.matrix.a.b.d<T> paramd)
  {
    paramClass = al(paramClass);
    if (paramClass != null) {
      paramd.accept(paramClass);
    }
  }
  
  public final <T extends m> T al(Class<T> paramClass)
  {
    if (this.eOp == null) {
      return null;
    }
    Iterator localIterator = this.eOp.ePD.ePA.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (paramClass.isAssignableFrom(localm.getClass())) {
        return localm;
      }
    }
    return null;
  }
  
  public final <T extends m.a<T>> m.a.a<T> am(Class<T> paramClass)
  {
    return (m.a.a)this.eQZ.get(paramClass);
  }
  
  public final m.a.d.a an(Class<? extends m.a<?>> paramClass)
  {
    return (m.a.d.a)this.eRc.get(paramClass);
  }
  
  public final f ao(Class<? extends m.a<?>> paramClass)
  {
    if (!this.eQX.contains(paramClass)) {
      this.eQX.add(paramClass);
    }
    return this;
  }
  
  public final f ap(Class<? extends m.a<?>> paramClass)
  {
    this.eRa.put(paramClass, Long.valueOf(30000L));
    return this;
  }
  
  protected m.a<?> aq(Class<? extends m.a<?>> paramClass)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramClass == c.b.class)
    {
      localObject1 = (c)al(c.class);
      if (localObject1 == null) {
        break label525;
      }
      localObject1 = ((c)localObject1).eQj.awR();
      this.eQY.put(paramClass, localObject1);
    }
    label525:
    for (paramClass = (Class<? extends m.a<?>>)localObject1;; paramClass = null)
    {
      localObject1 = paramClass;
      Object localObject3;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  return localObject1;
                                  if (paramClass != e.a.class) {
                                    break;
                                  }
                                  localObject3 = (e)al(e.class);
                                  localObject1 = localObject2;
                                } while (localObject3 == null);
                                localObject1 = ((e)localObject3).eQM.awX();
                                this.eQY.put(paramClass, localObject1);
                                return localObject1;
                                if (paramClass != h.b.class) {
                                  break;
                                }
                                localObject1 = localObject2;
                              } while ((h)al(h.class) == null);
                              localObject1 = h.axe();
                              this.eQY.put(paramClass, localObject1);
                              return localObject1;
                              if (paramClass != h.a.class) {
                                break;
                              }
                              localObject1 = localObject2;
                            } while ((h)al(h.class) == null);
                            localObject1 = localObject2;
                          } while (this.eOp == null);
                          localObject1 = h.bS(com.tencent.matrix.a.a.d.getContext());
                          this.eQY.put(paramClass, localObject1);
                          return localObject1;
                          if (paramClass != j.b.class) {
                            break;
                          }
                          localObject3 = (j)al(j.class);
                          localObject1 = localObject2;
                        } while (localObject3 == null);
                        localObject1 = ((j)localObject3).axh();
                        this.eQY.put(paramClass, localObject1);
                        return localObject1;
                        if (paramClass != k.a.class) {
                          break;
                        }
                        localObject3 = (k)al(k.class);
                        localObject1 = localObject2;
                      } while (localObject3 == null);
                      localObject1 = ((k)localObject3).eRU.axi();
                      this.eQY.put(paramClass, localObject1);
                      return localObject1;
                      if (paramClass != o.a.class) {
                        break;
                      }
                      localObject1 = localObject2;
                    } while ((o)al(o.class) == null);
                    localObject1 = localObject2;
                  } while (this.eOp == null);
                  localObject1 = o.bT(com.tencent.matrix.a.a.d.getContext());
                  this.eQY.put(paramClass, localObject1);
                  return localObject1;
                  if (paramClass != p.b.class) {
                    break;
                  }
                  localObject3 = (p)al(p.class);
                  localObject1 = localObject2;
                } while (localObject3 == null);
                localObject1 = ((p)localObject3).eSR.axm();
                this.eQY.put(paramClass, localObject1);
                return localObject1;
                if (paramClass != q.a.class) {
                  break;
                }
                localObject3 = (q)al(q.class);
                localObject1 = localObject2;
              } while (localObject3 == null);
              localObject1 = ((q)localObject3).eTm.axo();
              this.eQY.put(paramClass, localObject1);
              return localObject1;
              if (paramClass != g.a.class) {
                break;
              }
              localObject3 = (g)al(g.class);
              localObject1 = localObject2;
            } while (localObject3 == null);
            localObject1 = localObject2;
          } while (!((g)localObject3).isSupported());
          localObject1 = ((g)localObject3).axc();
          this.eQY.put(paramClass, localObject1);
          return localObject1;
          localObject1 = localObject2;
        } while (paramClass != d.b.class);
        localObject3 = (d)al(d.class);
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = ((d)localObject3).dF(0L);
      this.eQY.put(paramClass, localObject1);
      return localObject1;
    }
  }
  
  public final com.tencent.matrix.a.a.d awB()
  {
    return this.eOp;
  }
  
  public final a awY()
  {
    return this.eRd;
  }
  
  public final int awZ()
  {
    if (this.eRd == null)
    {
      com.tencent.matrix.e.c.w("Matrix.battery.CompositeMonitors", "AppStats should not be null to get CpuLoad", new Object[0]);
      return -1;
    }
    m.a.a locala1 = am(j.b.class);
    m.a.a locala2 = am(g.a.class);
    if (locala1 == null)
    {
      com.tencent.matrix.e.c.w("Matrix.battery.CompositeMonitors", j.b.class + " should be metrics to get CpuLoad", new Object[0]);
      return -1;
    }
    if (locala2 == null)
    {
      com.tencent.matrix.e.c.w("Matrix.battery.CompositeMonitors", g.a.class + "should be metrics to get CpuLoad", new Object[0]);
      return -1;
    }
    long l1 = ((Long)((j.b)locala1.eSh).eRI.eSn).longValue();
    long l2 = ((g.a)locala2.eSh).axd();
    if (l2 > 0L) {}
    for (float f = (float)l1 / (float)l2;; f = 0.0F) {
      return (int)(f * b.axr() * 100.0F);
    }
  }
  
  public f axa()
  {
    ao(j.b.class);
    ao(c.b.class);
    ao(p.b.class);
    ao(g.a.class);
    ao(d.b.class);
    ao(h.b.class);
    ao(h.a.class);
    ao(o.a.class);
    ao(e.a.class);
    ao(q.a.class);
    ao(k.a.class);
    return this;
  }
  
  public final <T extends m.a<T>> void b(Class<T> paramClass, com.tencent.matrix.a.b.d<m.a.a<T>> paramd)
  {
    paramClass = am(paramClass);
    if (paramClass != null) {
      paramd.accept(paramClass);
    }
  }
  
  public final void c(Class<? extends m.a<?>> paramClass, com.tencent.matrix.a.b.d<m.a.a<?>> paramd)
  {
    paramClass = (m.a.a)this.eQZ.get(paramClass);
    if (paramClass != null) {
      paramd.accept(paramClass);
    }
  }
  
  public void clear()
  {
    this.eQY.clear();
    this.eQZ.clear();
    this.eRb.clear();
    this.eRc.clear();
  }
  
  public final void d(Class<? extends m.a<?>> paramClass, com.tencent.matrix.a.b.d<m.a.d.a> paramd)
  {
    paramClass = an(paramClass);
    if (paramClass != null) {
      paramd.accept(paramClass);
    }
  }
  
  public final void finish()
  {
    Object localObject1 = this.eQY.entrySet().iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = (m.a)((Map.Entry)localObject3).getValue();
      if (localObject2 != null)
      {
        localObject3 = (Class)((Map.Entry)localObject3).getKey();
        localObject4 = aq((Class)localObject3);
        if ((localObject4 != null) && (localObject4.getClass() == localObject2.getClass())) {
          a((Class)localObject3, ((m.a)localObject4).a((m.a)localObject2));
        }
      }
    }
    Object localObject2 = this.eRb.entrySet().iterator();
    label410:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject1 = (m.a.d)((Map.Entry)localObject3).getValue();
      ((m.a.d)localObject1).cgD = true;
      ((m.a.d)localObject1).eSq = SystemClock.uptimeMillis();
      ((m.a.d)localObject1).mHandler.removeCallbacks(((m.a.d)localObject1).eSp);
      localObject4 = (m.a.d)((Map.Entry)localObject3).getValue();
      if (((m.a.d)localObject4).mCount <= 0)
      {
        com.tencent.matrix.e.c.w("Matrix.battery.Sampler", "Sampling count is invalid: " + ((m.a.d)localObject4).mCount, new Object[0]);
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label410;
        }
        this.eRc.put(((Map.Entry)localObject3).getKey(), localObject1);
        break;
        if ((((m.a.d)localObject4).eRe <= 0L) || (((m.a.d)localObject4).eSq <= 0L) || (((m.a.d)localObject4).eRe > ((m.a.d)localObject4).eSq))
        {
          com.tencent.matrix.e.c.w("Matrix.battery.Sampler", "Sampling bgn/end millis is invalid: " + ((m.a.d)localObject4).eRe + " - " + ((m.a.d)localObject4).eSq, new Object[0]);
          localObject1 = null;
        }
        else
        {
          localObject1 = new m.a.d.a();
          ((m.a.d.a)localObject1).interval = ((m.a.d)localObject4).mInterval;
          ((m.a.d.a)localObject1).count = ((m.a.d)localObject4).mCount;
          ((m.a.d.a)localObject1).eOb = (((m.a.d)localObject4).eSq - ((m.a.d)localObject4).eRe);
          ((m.a.d.a)localObject1).eSx = ((m.a.d)localObject4).eSr;
          ((m.a.d.a)localObject1).eSy = ((m.a.d)localObject4).eSs;
          ((m.a.d.a)localObject1).eSz = ((m.a.d)localObject4).eSt;
          ((m.a.d.a)localObject1).eSA = ((m.a.d)localObject4).eSu;
          ((m.a.d.a)localObject1).eSB = ((m.a.d)localObject4).eSv;
        }
      }
    }
    this.eRd = a.dD(SystemClock.uptimeMillis() - this.eRe);
  }
  
  public final void start()
  {
    this.eRd = null;
    this.eRe = SystemClock.uptimeMillis();
    Object localObject = this.eQX.iterator();
    while (((Iterator)localObject).hasNext()) {
      aq((Class)((Iterator)localObject).next());
    }
    Iterator localIterator = this.eRa.entrySet().iterator();
    label302:
    label305:
    for (;;)
    {
      Map.Entry localEntry;
      Class localClass;
      if (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        localClass = (Class)localEntry.getKey();
        if (localClass == h.b.class)
        {
          localObject = (h)al(h.class);
          if ((localObject == null) || (this.eOp == null)) {
            break label302;
          }
          localObject = new m.a.d(this.eOp.mHandler, new Callable() {});
          this.eRb.put(localClass, localObject);
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label305;
        }
        long l = ((Long)localEntry.getValue()).longValue();
        if (l > 0L) {
          ((m.a.d)localObject).mInterval = l;
        }
        ((m.a.d)localObject).cgD = false;
        ((m.a.d)localObject).eRe = SystemClock.uptimeMillis();
        ((m.a.d)localObject).mHandler.postDelayed(((m.a.d)localObject).eSp, ((m.a.d)localObject).mInterval);
        break;
        if (localClass == h.a.class)
        {
          localObject = (h)al(h.class);
          if ((localObject != null) && (this.eOp != null))
          {
            localObject = new m.a.d(this.eOp.mHandler, new Callable() {});
            this.eRb.put(localClass, localObject);
          }
        }
        else
        {
          localObject = null;
          continue;
          return;
        }
        localObject = null;
        continue;
        localObject = null;
      }
    }
  }
  
  public String toString()
  {
    return "CompositeMonitors{\nMetrics=" + this.eQX + "\n, BgnSnapshots=" + this.eQY + "\n, Deltas=" + this.eQZ + "\n, SampleRegs=" + this.eRa + "\n, Samplers=" + this.eRb + "\n, SampleResults=" + this.eRc + "\n, AppStats=" + this.eRd + "\n}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */