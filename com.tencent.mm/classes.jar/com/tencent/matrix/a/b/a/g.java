package com.tencent.matrix.a.b.a;

import android.os.SystemClock;
import com.tencent.matrix.a.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public abstract interface g
{
  public abstract void Se();
  
  public abstract void Sf();
  
  public abstract int Sg();
  
  public abstract void ba(long paramLong);
  
  public abstract void d(c paramc);
  
  public abstract void onForeground(boolean paramBoolean);
  
  public static abstract class a<RECORD extends a>
  {
    public boolean cTp = false;
    public boolean cTq = true;
    public final long time = SystemClock.uptimeMillis();
    
    public static abstract class a<RECORD extends g.a>
    {
      public final RECORD cTr;
      public final RECORD cTs;
      public final RECORD cTt;
      public final long cTu;
      
      public a(RECORD paramRECORD1, RECORD paramRECORD2)
      {
        this.cTr = paramRECORD1;
        this.cTs = paramRECORD2;
        this.cTu = (paramRECORD2.time - paramRECORD1.time);
        this.cTt = Si();
        this.cTt.cTp = true;
      }
      
      protected abstract RECORD Si();
      
      public final boolean isValid()
      {
        return (this.cTr.cTq) && (this.cTs.cTq);
      }
    }
    
    public static abstract interface b<ENTRY extends g.a.c>
    {
      public static final class a<BEAN>
        implements g.a.b<g.a.c.a<BEAN>>
      {
        static final a cTv = new a();
        
        public static <BEAN> g.a.c.a<BEAN> a(g.a.c.a<BEAN> parama1, g.a.c.a<BEAN> parama2)
        {
          Object localObject;
          if (parama2 != parama1)
          {
            localObject = parama2;
            if (!parama2.equals(parama1)) {}
          }
          else
          {
            localObject = g.a.c.a.cTy;
          }
          return localObject;
        }
      }
      
      public static final class b<DIGIT extends Number>
        implements g.a.b<g.a.c.b<DIGIT>>
      {
        static final b cTw = new b();
        
        public static <DIGIT extends Number> g.a.c.b<DIGIT> a(g.a.c.b<DIGIT> paramb1, g.a.c.b<DIGIT> paramb2)
        {
          return g.a.c.b.b(paramb2.a(paramb1.cTz));
        }
      }
      
      public static final class c<ENTRY extends g.a.c>
        implements g.a.b<g.a.c.c<ENTRY>>
      {
        static final c cTx = new c();
        
        public static <ENTRY extends g.a.c> g.a.c.c<ENTRY> a(g.a.c.c<ENTRY> paramc1, g.a.c.c<ENTRY> paramc2)
        {
          g.a.c.c localc = g.a.c.c.Sn();
          int i = 0;
          Object localObject1;
          Object localObject2;
          if (i < paramc2.list.size())
          {
            localObject1 = (g.a.c)paramc2.list.get(i);
            if ((localObject1 instanceof g.a.c.b)) {
              if (paramc1.list.size() > i)
              {
                localObject2 = (g.a.c)paramc1.list.get(i);
                if ((localObject2 instanceof g.a.c.b)) {
                  localc.list.add(g.a.b.b.a((g.a.c.b)localObject2, (g.a.c.b)localObject1));
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
            localObject1 = g.a.c.b.b(((g.a.c.b)localObject1).cTz);
            ((g.a.c)localObject1).cTq = false;
            ((List)localObject2).add((g.a.c)localObject1);
            continue;
            if (((localObject1 instanceof g.a.c.a)) && (!paramc1.list.contains(localObject1)))
            {
              localObject2 = paramc1.list.iterator();
              g.a.c localc1;
              do
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                localc1 = (g.a.c)((Iterator)localObject2).next();
              } while ((!(localc1 instanceof g.a.c.a)) || (g.a.b.a.a((g.a.c.a)localc1, (g.a.c.a)localObject1) != g.a.c.a.cTy));
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
      boolean cTq = true;
      
      public static class a<BEAN>
        extends g.a.c<a>
      {
        public static final a<?> cTy = new a() {};
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
        extends g.a.c<b>
      {
        public DIGIT cTz;
        
        public b(DIGIT paramDIGIT)
        {
          this.cTz = paramDIGIT;
        }
        
        public static <DIGIT extends Number> b<DIGIT> b(DIGIT paramDIGIT)
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
        
        public abstract DIGIT a(DIGIT paramDIGIT);
        
        public boolean equals(Object paramObject)
        {
          if (this == paramObject) {
            return true;
          }
          if ((paramObject == null) || (getClass() != paramObject.getClass())) {
            return false;
          }
          paramObject = (b)paramObject;
          return this.cTz.equals(paramObject.cTz);
        }
        
        public int hashCode()
        {
          return Objects.hash(new Object[] { this.cTz });
        }
        
        public String toString()
        {
          return String.valueOf(this.cTz);
        }
        
        static final class a
          extends g.a.c.b<Double>
        {
          public a(Double paramDouble)
          {
            super();
          }
        }
        
        static final class b
          extends g.a.c.b<Float>
        {
          public b(Float paramFloat)
          {
            super();
          }
        }
        
        static final class c
          extends g.a.c.b<Integer>
        {
          public c(Integer paramInteger)
          {
            super();
          }
        }
        
        static final class d
          extends g.a.c.b<Long>
        {
          public d(Long paramLong)
          {
            super();
          }
        }
      }
      
      public static final class c<ITEM extends g.a.c>
        extends g.a.c<c>
      {
        public List<ITEM> list;
        
        public static <ITEM extends g.a.c> c<ITEM> J(List<ITEM> paramList)
        {
          c localc = new c();
          localc.list = paramList;
          return localc;
        }
        
        public static <ITEM extends g.a.c> c<ITEM> Sn()
        {
          c localc = new c();
          localc.list = new ArrayList();
          return localc;
        }
        
        public static c<g.a.c.b<Integer>> r(int[] paramArrayOfInt)
        {
          ArrayList localArrayList = new ArrayList();
          int j = paramArrayOfInt.length;
          int i = 0;
          while (i < j)
          {
            localArrayList.add(g.a.c.b.b(Integer.valueOf(paramArrayOfInt[i])));
            i += 1;
          }
          paramArrayOfInt = new c();
          paramArrayOfInt.list = localArrayList;
          return paramArrayOfInt;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */