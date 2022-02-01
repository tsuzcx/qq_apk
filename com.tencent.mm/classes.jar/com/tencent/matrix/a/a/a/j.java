package com.tencent.matrix.a.a.a;

import android.os.SystemClock;
import com.tencent.matrix.a.a.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public abstract interface j
{
  public abstract void VZ();
  
  public abstract void Wa();
  
  public abstract int Wh();
  
  public abstract void bm(long paramLong);
  
  public abstract void f(d paramd);
  
  public abstract void onForeground(boolean paramBoolean);
  
  public static abstract class a<RECORD extends a>
  {
    public boolean cWk = false;
    public boolean cWl = true;
    public final long time = SystemClock.uptimeMillis();
    
    public static abstract class a<RECORD extends j.a>
    {
      public final RECORD cWm;
      public final RECORD cWn;
      public final RECORD cWo;
      public final long cWp;
      
      public a(RECORD paramRECORD1, RECORD paramRECORD2)
      {
        this.cWm = paramRECORD1;
        this.cWn = paramRECORD2;
        this.cWp = (paramRECORD2.time - paramRECORD1.time);
        this.cWo = Wg();
        this.cWo.cWk = true;
      }
      
      protected abstract RECORD Wg();
      
      public final boolean isValid()
      {
        return (this.cWm.cWl) && (this.cWn.cWl);
      }
    }
    
    public static abstract interface b<ENTRY extends j.a.c>
    {
      public static final class a<BEAN>
        implements j.a.b<j.a.c.a<BEAN>>
      {
        static final a cWq = new a();
        
        public static <BEAN> j.a.c.a<BEAN> a(j.a.c.a<BEAN> parama1, j.a.c.a<BEAN> parama2)
        {
          Object localObject;
          if (parama2 != parama1)
          {
            localObject = parama2;
            if (!parama2.equals(parama1)) {}
          }
          else
          {
            localObject = j.a.c.a.cWt;
          }
          return localObject;
        }
      }
      
      public static final class b<DIGIT extends Number>
        implements j.a.b<j.a.c.b<DIGIT>>
      {
        static final b cWr = new b();
        
        public static <DIGIT extends Number> j.a.c.b<DIGIT> a(j.a.c.b<DIGIT> paramb1, j.a.c.b<DIGIT> paramb2)
        {
          return j.a.c.b.c(paramb2.b(paramb1.cWu));
        }
      }
      
      public static final class c<ENTRY extends j.a.c>
        implements j.a.b<j.a.c.c<ENTRY>>
      {
        static final c cWs = new c();
        
        public static <ENTRY extends j.a.c> j.a.c.c<ENTRY> a(j.a.c.c<ENTRY> paramc1, j.a.c.c<ENTRY> paramc2)
        {
          j.a.c.c localc = j.a.c.c.Wu();
          int i = 0;
          Object localObject1;
          Object localObject2;
          if (i < paramc2.list.size())
          {
            localObject1 = (j.a.c)paramc2.list.get(i);
            if ((localObject1 instanceof j.a.c.b)) {
              if (paramc1.list.size() > i)
              {
                localObject2 = (j.a.c)paramc1.list.get(i);
                if ((localObject2 instanceof j.a.c.b)) {
                  localc.list.add(j.a.b.b.a((j.a.c.b)localObject2, (j.a.c.b)localObject1));
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
            localObject1 = j.a.c.b.c(((j.a.c.b)localObject1).cWu);
            ((j.a.c)localObject1).cWl = false;
            ((List)localObject2).add((j.a.c)localObject1);
            continue;
            if (((localObject1 instanceof j.a.c.a)) && (!paramc1.list.contains(localObject1)))
            {
              localObject2 = paramc1.list.iterator();
              j.a.c localc1;
              do
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                localc1 = (j.a.c)((Iterator)localObject2).next();
              } while ((!(localc1 instanceof j.a.c.a)) || (j.a.b.a.a((j.a.c.a)localc1, (j.a.c.a)localObject1) != j.a.c.a.cWt));
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
      boolean cWl = true;
      
      public static class a<BEAN>
        extends j.a.c<a>
      {
        public static final a<?> cWt = new a() {};
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
        extends j.a.c<b>
      {
        public DIGIT cWu;
        
        public b(DIGIT paramDIGIT)
        {
          this.cWu = paramDIGIT;
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
          return this.cWu.equals(paramObject.cWu);
        }
        
        public int hashCode()
        {
          return Objects.hash(new Object[] { this.cWu });
        }
        
        public String toString()
        {
          return String.valueOf(this.cWu);
        }
        
        static final class a
          extends j.a.c.b<Double>
        {
          a(Double paramDouble)
          {
            super();
          }
        }
        
        static final class b
          extends j.a.c.b<Float>
        {
          b(Float paramFloat)
          {
            super();
          }
        }
        
        static final class c
          extends j.a.c.b<Integer>
        {
          c(Integer paramInteger)
          {
            super();
          }
        }
        
        static final class d
          extends j.a.c.b<Long>
        {
          d(Long paramLong)
          {
            super();
          }
        }
      }
      
      public static final class c<ITEM extends j.a.c>
        extends j.a.c<c>
      {
        public List<ITEM> list;
        
        public static <ITEM extends j.a.c> c<ITEM> H(List<ITEM> paramList)
        {
          c localc = new c();
          localc.list = paramList;
          return localc;
        }
        
        public static <ITEM extends j.a.c> c<ITEM> Wu()
        {
          c localc = new c();
          localc.list = new ArrayList();
          return localc;
        }
        
        public static c<j.a.c.b<Integer>> r(int[] paramArrayOfInt)
        {
          ArrayList localArrayList = new ArrayList();
          int j = paramArrayOfInt.length;
          int i = 0;
          while (i < j)
          {
            localArrayList.add(j.a.c.b.c(Integer.valueOf(paramArrayOfInt[i])));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.j
 * JD-Core Version:    0.7.0.1
 */