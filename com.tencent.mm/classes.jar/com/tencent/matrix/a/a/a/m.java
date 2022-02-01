package com.tencent.matrix.a.a.a;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

public abstract interface m
{
  public abstract void awI();
  
  public abstract void awJ();
  
  public abstract int awQ();
  
  public abstract void dE(long paramLong);
  
  public abstract void g(d paramd);
  
  public abstract void onForeground(boolean paramBoolean);
  
  public static abstract class a<RECORD extends a>
  {
    public boolean eSd = false;
    public boolean eSe = true;
    public final long time = SystemClock.uptimeMillis();
    
    public abstract a<RECORD> a(RECORD paramRECORD);
    
    public static abstract class a<RECORD extends m.a>
    {
      public final RECORD eSf;
      public final RECORD eSg;
      public final RECORD eSh;
      public final long eSi;
      
      public a(RECORD paramRECORD1, RECORD paramRECORD2)
      {
        this.eSf = paramRECORD1;
        this.eSg = paramRECORD2;
        this.eSi = (paramRECORD2.time - paramRECORD1.time);
        this.eSh = awP();
        this.eSh.eSd = true;
      }
      
      protected abstract RECORD awP();
      
      public final boolean isValid()
      {
        return (this.eSf.eSe) && (this.eSg.eSe);
      }
    }
    
    public static abstract interface b<ENTRY extends m.a.c>
    {
      public static final class a<BEAN>
        implements m.a.b<m.a.c.a<BEAN>>
      {
        static final a eSj = new a();
        
        public static <BEAN> m.a.c.a<BEAN> a(m.a.c.a<BEAN> parama1, m.a.c.a<BEAN> parama2)
        {
          Object localObject;
          if (parama2 != parama1)
          {
            localObject = parama2;
            if (!parama2.equals(parama1)) {}
          }
          else
          {
            localObject = m.a.c.a.eSm;
          }
          return localObject;
        }
      }
      
      public static final class b<DIGIT extends Number>
        implements m.a.b<m.a.c.b<DIGIT>>
      {
        static final b eSk = new b();
        
        public static <DIGIT extends Number> m.a.c.b<DIGIT> a(m.a.c.b<DIGIT> paramb1, m.a.c.b<DIGIT> paramb2)
        {
          return m.a.c.b.c(paramb2.b(paramb1.eSn));
        }
      }
      
      public static final class c<ENTRY extends m.a.c>
        implements m.a.b<m.a.c.c<ENTRY>>
      {
        static final c eSl = new c();
        
        public static <ENTRY extends m.a.c> m.a.c.c<ENTRY> a(m.a.c.c<ENTRY> paramc1, m.a.c.c<ENTRY> paramc2)
        {
          m.a.c.c localc = m.a.c.c.axk();
          int i = 0;
          Object localObject1;
          Object localObject2;
          if (i < paramc2.list.size())
          {
            localObject1 = (m.a.c)paramc2.list.get(i);
            if ((localObject1 instanceof m.a.c.b)) {
              if (paramc1.list.size() > i)
              {
                localObject2 = (m.a.c)paramc1.list.get(i);
                if ((localObject2 instanceof m.a.c.b)) {
                  localc.list.add(m.a.b.b.a((m.a.c.b)localObject2, (m.a.c.b)localObject1));
                }
              }
            }
          }
          label262:
          for (;;)
          {
            i += 1;
            break;
            localObject2 = localc.list;
            localObject1 = m.a.c.b.c(((m.a.c.b)localObject1).eSn);
            ((m.a.c)localObject1).eSe = false;
            ((List)localObject2).add((m.a.c)localObject1);
            continue;
            if (((localObject1 instanceof m.a.c.a)) && (!paramc1.list.contains(localObject1)))
            {
              localObject2 = paramc1.list.iterator();
              m.a.c localc1;
              do
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                localc1 = (m.a.c)((Iterator)localObject2).next();
              } while ((!(localc1 instanceof m.a.c.a)) || (m.a.b.a.a((m.a.c.a)localc1, (m.a.c.a)localObject1) != m.a.c.a.eSm));
              for (int j = 1;; j = 0)
              {
                if (j != 0) {
                  break label262;
                }
                localc.list.add(localObject1);
                break;
                return localc;
              }
            }
          }
        }
      }
    }
    
    public static abstract class c<ENTRY>
    {
      boolean eSe = true;
      
      public static class a<BEAN>
        extends m.a.c<a>
      {
        public static final a<?> eSm = new a() {};
        public BEAN value = null;
        
        public boolean equals(Object paramObject)
        {
          if (this == paramObject) {
            return true;
          }
          if ((paramObject == null) || (getClass() != paramObject.getClass())) {
            return false;
          }
          paramObject = (a)paramObject;
          return Objects.equals(String.valueOf(this.value), String.valueOf(paramObject.value));
        }
        
        public int hashCode()
        {
          return Objects.hash(new Object[] { this.value });
        }
        
        public String toString()
        {
          return String.valueOf(this.value);
        }
      }
      
      public static abstract class b<DIGIT extends Number>
        extends m.a.c<b>
      {
        public DIGIT eSn;
        
        public b(DIGIT paramDIGIT)
        {
          this.eSn = paramDIGIT;
        }
        
        public static <DIGIT extends Number> b<DIGIT> c(DIGIT paramDIGIT)
        {
          if ((paramDIGIT instanceof Integer)) {
            return new c((Integer)paramDIGIT);
          }
          if ((paramDIGIT instanceof Long)) {
            return new d((Long)paramDIGIT);
          }
          if ((paramDIGIT instanceof Float)) {
            return new b((Float)paramDIGIT);
          }
          if ((paramDIGIT instanceof Double)) {
            return new a((Double)paramDIGIT);
          }
          throw new RuntimeException("unsupported digit: " + paramDIGIT.getClass());
        }
        
        public abstract DIGIT b(DIGIT paramDIGIT);
        
        public boolean equals(Object paramObject)
        {
          if (this == paramObject) {
            return true;
          }
          if ((paramObject == null) || (getClass() != paramObject.getClass())) {
            return false;
          }
          paramObject = (b)paramObject;
          return this.eSn.equals(paramObject.eSn);
        }
        
        public int hashCode()
        {
          return Objects.hash(new Object[] { this.eSn });
        }
        
        public String toString()
        {
          return String.valueOf(this.eSn);
        }
        
        static final class a
          extends m.a.c.b<Double>
        {
          a(Double paramDouble)
          {
            super();
          }
        }
        
        static final class b
          extends m.a.c.b<Float>
        {
          b(Float paramFloat)
          {
            super();
          }
        }
        
        static final class c
          extends m.a.c.b<Integer>
        {
          c(Integer paramInteger)
          {
            super();
          }
        }
        
        static final class d
          extends m.a.c.b<Long>
        {
          d(Long paramLong)
          {
            super();
          }
        }
      }
      
      public static final class c<ITEM extends m.a.c>
        extends m.a.c<c>
      {
        public List<ITEM> list;
        
        public static <ITEM extends m.a.c> c<ITEM> axk()
        {
          c localc = new c();
          localc.list = new ArrayList();
          return localc;
        }
        
        public static c<m.a.c.b<Long>> b(long[] paramArrayOfLong)
        {
          ArrayList localArrayList = new ArrayList();
          int j = paramArrayOfLong.length;
          int i = 0;
          while (i < j)
          {
            localArrayList.add(m.a.c.b.c(Long.valueOf(paramArrayOfLong[i])));
            i += 1;
          }
          paramArrayOfLong = new c();
          paramArrayOfLong.list = localArrayList;
          return paramArrayOfLong;
        }
        
        public static <ITEM extends m.a.c> c<ITEM> bf(List<ITEM> paramList)
        {
          c localc = new c();
          localc.list = paramList;
          return localc;
        }
        
        public static c<m.a.c.b<Integer>> t(int[] paramArrayOfInt)
        {
          ArrayList localArrayList = new ArrayList();
          int j = paramArrayOfInt.length;
          int i = 0;
          while (i < j)
          {
            localArrayList.add(m.a.c.b.c(Integer.valueOf(paramArrayOfInt[i])));
            i += 1;
          }
          paramArrayOfInt = new c();
          paramArrayOfInt.list = localArrayList;
          return paramArrayOfInt;
        }
      }
    }
    
    public static final class d
    {
      boolean cgD = true;
      long eRe = 0L;
      final Callable<? extends Number> eSo;
      final Runnable eSp = new Runnable()
      {
        public final void run()
        {
          for (;;)
          {
            try
            {
              Object localObject1 = (Number)m.a.d.this.eSo.call();
              m.a.d.this.eSs = ((Number)localObject1).doubleValue();
              localObject1 = m.a.d.this;
              ((m.a.d)localObject1).mCount += 1;
              m.a.d.this.eSv = ((m.a.d.this.eSv * (m.a.d.this.mCount - 1) + m.a.d.this.eSs) / m.a.d.this.mCount);
              if (m.a.d.this.eSr == 4.9E-324D)
              {
                m.a.d.this.eSr = m.a.d.this.eSs;
                m.a.d.this.eSt = m.a.d.this.eSs;
                m.a.d.this.eSu = m.a.d.this.eSs;
                return;
              }
            }
            catch (Exception localException)
            {
              c.printErrStackTrace("Matrix.battery.Sampler", localException, "onSamplingFailed: ".concat(String.valueOf(localException)), new Object[0]);
              return;
            }
            finally
            {
              if (m.a.d.this.cgD) {
                continue;
              }
              m.a.d.this.mHandler.postDelayed(this, m.a.d.this.mInterval);
            }
            if (m.a.d.this.eSs > m.a.d.this.eSt) {
              m.a.d.this.eSt = m.a.d.this.eSs;
            }
            if (m.a.d.this.eSs < m.a.d.this.eSu) {
              m.a.d.this.eSu = m.a.d.this.eSs;
            }
          }
        }
      };
      long eSq = 0L;
      double eSr = 4.9E-324D;
      double eSs = 4.9E-324D;
      double eSt = 4.9E-324D;
      double eSu = 4.9E-324D;
      double eSv = 4.9E-324D;
      int mCount = 0;
      final Handler mHandler;
      long mInterval = 60000L;
      
      public d(Handler paramHandler, Callable<? extends Number> paramCallable)
      {
        this.mHandler = paramHandler;
        this.eSo = paramCallable;
      }
      
      public static final class a
      {
        public int count;
        public long eOb;
        public double eSA;
        public double eSB;
        public double eSx;
        public double eSy;
        public double eSz;
        public long interval;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.m
 * JD-Core Version:    0.7.0.1
 */