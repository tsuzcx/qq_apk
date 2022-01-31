package android.support.v4.e;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V>
  extends m<K, V>
  implements Map<K, V>
{
  h<K, V> EF;
  
  public a() {}
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  public a(m paramm)
  {
    super(paramm);
  }
  
  private h<K, V> dv()
  {
    if (this.EF == null) {
      this.EF = new h()
      {
        protected final int C(Object paramAnonymousObject)
        {
          return a.this.indexOfKey(paramAnonymousObject);
        }
        
        protected final int D(Object paramAnonymousObject)
        {
          return a.this.indexOfValue(paramAnonymousObject);
        }
        
        protected final void ao(int paramAnonymousInt)
        {
          a.this.removeAt(paramAnonymousInt);
        }
        
        protected final V b(int paramAnonymousInt, V paramAnonymousV)
        {
          a locala = a.this;
          paramAnonymousInt = (paramAnonymousInt << 1) + 1;
          Object localObject = locala.EO[paramAnonymousInt];
          locala.EO[paramAnonymousInt] = paramAnonymousV;
          return localObject;
        }
        
        protected final void c(K paramAnonymousK, V paramAnonymousV)
        {
          a.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected final int dw()
        {
          return a.this.mSize;
        }
        
        protected final Map<K, V> dx()
        {
          return a.this;
        }
        
        protected final void dy()
        {
          a.this.clear();
        }
        
        protected final Object q(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return a.this.EO[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
      };
    }
    return this.EF;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    h localh = dv();
    if (localh.EY == null) {
      localh.EY = new h.b(localh);
    }
    return localh.EY;
  }
  
  public Set<K> keySet()
  {
    return dv().getKeySet();
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    ensureCapacity(this.mSize + paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public Collection<V> values()
  {
    h localh = dv();
    if (localh.Fa == null) {
      localh.Fa = new h.e(localh);
    }
    return localh.Fa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.a
 * JD-Core Version:    0.7.0.1
 */