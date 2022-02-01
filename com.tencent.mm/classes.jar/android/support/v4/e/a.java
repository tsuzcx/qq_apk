package android.support.v4.e;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V>
  extends n<K, V>
  implements Map<K, V>
{
  i<K, V> OD;
  
  public a() {}
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  public a(n paramn)
  {
    super(paramn);
  }
  
  private i<K, V> fr()
  {
    if (this.OD == null) {
      this.OD = new i()
      {
        protected final int E(Object paramAnonymousObject)
        {
          return a.this.indexOfKey(paramAnonymousObject);
        }
        
        protected final int F(Object paramAnonymousObject)
        {
          return a.this.indexOfValue(paramAnonymousObject);
        }
        
        protected final V a(int paramAnonymousInt, V paramAnonymousV)
        {
          return a.this.setValueAt(paramAnonymousInt, paramAnonymousV);
        }
        
        protected final void aG(int paramAnonymousInt)
        {
          a.this.removeAt(paramAnonymousInt);
        }
        
        protected final void b(K paramAnonymousK, V paramAnonymousV)
        {
          a.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected final int fs()
        {
          return a.this.mSize;
        }
        
        protected final Map<K, V> ft()
        {
          return a.this;
        }
        
        protected final void fu()
        {
          a.this.clear();
        }
        
        protected final Object z(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return a.this.OO[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
      };
    }
    return this.OD;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    i locali = fr();
    if (locali.OX == null) {
      locali.OX = new i.b(locali);
    }
    return locali.OX;
  }
  
  public Set<K> keySet()
  {
    return fr().getKeySet();
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
    i locali = fr();
    if (locali.OZ == null) {
      locali.OZ = new i.e(locali);
    }
    return locali.OZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.a
 * JD-Core Version:    0.7.0.1
 */