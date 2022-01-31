package android.support.v4.f;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V>
  extends m<K, V>
  implements Map<K, V>
{
  h<K, V> DQ;
  
  public a() {}
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  public a(m paramm)
  {
    super(paramm);
  }
  
  private h<K, V> cW()
  {
    if (this.DQ == null) {
      this.DQ = new h()
      {
        protected final int B(Object paramAnonymousObject)
        {
          return a.this.indexOfKey(paramAnonymousObject);
        }
        
        protected final int C(Object paramAnonymousObject)
        {
          return a.this.indexOfValue(paramAnonymousObject);
        }
        
        protected final void aq(int paramAnonymousInt)
        {
          a.this.removeAt(paramAnonymousInt);
        }
        
        protected final V b(int paramAnonymousInt, V paramAnonymousV)
        {
          a locala = a.this;
          paramAnonymousInt = (paramAnonymousInt << 1) + 1;
          Object localObject = locala.DZ[paramAnonymousInt];
          locala.DZ[paramAnonymousInt] = paramAnonymousV;
          return localObject;
        }
        
        protected final void c(K paramAnonymousK, V paramAnonymousV)
        {
          a.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected final int cX()
        {
          return a.this.mSize;
        }
        
        protected final Map<K, V> cY()
        {
          return a.this;
        }
        
        protected final void cZ()
        {
          a.this.clear();
        }
        
        protected final Object q(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return a.this.DZ[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
      };
    }
    return this.DQ;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    h localh = cW();
    if (localh.Ei == null) {
      localh.Ei = new h.b(localh);
    }
    return localh.Ei;
  }
  
  public Set<K> keySet()
  {
    return cW().dd();
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
    h localh = cW();
    if (localh.Ek == null) {
      localh.Ek = new h.e(localh);
    }
    return localh.Ek;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.f.a
 * JD-Core Version:    0.7.0.1
 */