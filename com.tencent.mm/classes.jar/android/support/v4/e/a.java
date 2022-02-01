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
  i<K, V> Mz;
  
  public a() {}
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  public a(n paramn)
  {
    super(paramn);
  }
  
  private i<K, V> eU()
  {
    if (this.Mz == null) {
      this.Mz = new i()
      {
        protected final int D(Object paramAnonymousObject)
        {
          return a.this.indexOfKey(paramAnonymousObject);
        }
        
        protected final int E(Object paramAnonymousObject)
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
        
        protected final int eV()
        {
          return a.this.mSize;
        }
        
        protected final Map<K, V> eW()
        {
          return a.this;
        }
        
        protected final void eX()
        {
          a.this.clear();
        }
        
        protected final Object s(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return a.this.MK[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
      };
    }
    return this.Mz;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    i locali = eU();
    if (locali.MT == null) {
      locali.MT = new i.b(locali);
    }
    return locali.MT;
  }
  
  public Set<K> keySet()
  {
    return eU().getKeySet();
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
    i locali = eU();
    if (locali.MV == null) {
      locali.MV = new i.e(locali);
    }
    return locali.MV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.a
 * JD-Core Version:    0.7.0.1
 */