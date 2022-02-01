package androidx.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V>
  extends g<K, V>
  implements Map<K, V>
{
  f<K, V> RH;
  
  public a() {}
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  public a(g paramg)
  {
    super(paramg);
  }
  
  private f<K, V> lg()
  {
    AppMethodBeat.i(194544);
    if (this.RH == null) {
      this.RH = new f()
      {
        protected final Object B(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return a.this.RQ[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
        
        protected final V b(int paramAnonymousInt, V paramAnonymousV)
        {
          AppMethodBeat.i(194574);
          paramAnonymousV = a.this.c(paramAnonymousInt, paramAnonymousV);
          AppMethodBeat.o(194574);
          return paramAnonymousV;
        }
        
        protected final void bf(int paramAnonymousInt)
        {
          AppMethodBeat.i(194585);
          a.this.removeAt(paramAnonymousInt);
          AppMethodBeat.o(194585);
        }
        
        protected final void d(K paramAnonymousK, V paramAnonymousV)
        {
          AppMethodBeat.i(194565);
          a.this.put(paramAnonymousK, paramAnonymousV);
          AppMethodBeat.o(194565);
        }
        
        protected final int lh()
        {
          return a.this.mSize;
        }
        
        protected final Map<K, V> li()
        {
          return a.this;
        }
        
        protected final void lj()
        {
          AppMethodBeat.i(194593);
          a.this.clear();
          AppMethodBeat.o(194593);
        }
        
        protected final int w(Object paramAnonymousObject)
        {
          AppMethodBeat.i(194538);
          int i = a.this.y(paramAnonymousObject);
          AppMethodBeat.o(194538);
          return i;
        }
        
        protected final int x(Object paramAnonymousObject)
        {
          AppMethodBeat.i(194546);
          int i = a.this.z(paramAnonymousObject);
          AppMethodBeat.o(194546);
          return i;
        }
      };
    }
    f localf = this.RH;
    AppMethodBeat.o(194544);
    return localf;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    AppMethodBeat.i(194571);
    Object localObject = lg();
    if (((f)localObject).RZ == null) {
      ((f)localObject).RZ = new f.b((f)localObject);
    }
    localObject = ((f)localObject).RZ;
    AppMethodBeat.o(194571);
    return localObject;
  }
  
  public Set<K> keySet()
  {
    AppMethodBeat.i(194580);
    Set localSet = lg().ln();
    AppMethodBeat.o(194580);
    return localSet;
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    AppMethodBeat.i(194555);
    ensureCapacity(this.mSize + paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
    AppMethodBeat.o(194555);
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    AppMethodBeat.i(194562);
    boolean bool = f.a(this, paramCollection);
    AppMethodBeat.o(194562);
    return bool;
  }
  
  public Collection<V> values()
  {
    AppMethodBeat.i(194589);
    Object localObject = lg();
    if (((f)localObject).Sb == null) {
      ((f)localObject).Sb = new f.e((f)localObject);
    }
    localObject = ((f)localObject).Sb;
    AppMethodBeat.o(194589);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.b.a
 * JD-Core Version:    0.7.0.1
 */