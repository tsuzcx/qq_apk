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
  f<K, V> zu;
  
  public a() {}
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  public a(g paramg)
  {
    super(paramg);
  }
  
  private f<K, V> eX()
  {
    AppMethodBeat.i(210145);
    if (this.zu == null) {
      this.zu = new f()
      {
        protected final V a(int paramAnonymousInt, V paramAnonymousV)
        {
          a locala = a.this;
          paramAnonymousInt = (paramAnonymousInt << 1) + 1;
          Object localObject = locala.zD[paramAnonymousInt];
          locala.zD[paramAnonymousInt] = paramAnonymousV;
          return localObject;
        }
        
        protected final void aG(int paramAnonymousInt)
        {
          AppMethodBeat.i(210127);
          a.this.removeAt(paramAnonymousInt);
          AppMethodBeat.o(210127);
        }
        
        protected final void b(K paramAnonymousK, V paramAnonymousV)
        {
          AppMethodBeat.i(210123);
          a.this.put(paramAnonymousK, paramAnonymousV);
          AppMethodBeat.o(210123);
        }
        
        protected final int eY()
        {
          return a.this.mSize;
        }
        
        protected final Map<K, V> eZ()
        {
          return a.this;
        }
        
        protected final void fa()
        {
          AppMethodBeat.i(210129);
          a.this.clear();
          AppMethodBeat.o(210129);
        }
        
        protected final int o(Object paramAnonymousObject)
        {
          AppMethodBeat.i(210116);
          int i = a.this.q(paramAnonymousObject);
          AppMethodBeat.o(210116);
          return i;
        }
        
        protected final int p(Object paramAnonymousObject)
        {
          AppMethodBeat.i(210119);
          int i = a.this.r(paramAnonymousObject);
          AppMethodBeat.o(210119);
          return i;
        }
        
        protected final Object t(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return a.this.zD[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
      };
    }
    f localf = this.zu;
    AppMethodBeat.o(210145);
    return localf;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    AppMethodBeat.i(210152);
    Object localObject = eX();
    if (((f)localObject).zM == null) {
      ((f)localObject).zM = new f.b((f)localObject);
    }
    localObject = ((f)localObject).zM;
    AppMethodBeat.o(210152);
    return localObject;
  }
  
  public Set<K> keySet()
  {
    AppMethodBeat.i(210154);
    Set localSet = eX().getKeySet();
    AppMethodBeat.o(210154);
    return localSet;
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    AppMethodBeat.i(210149);
    ensureCapacity(this.mSize + paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
    AppMethodBeat.o(210149);
  }
  
  public Collection<V> values()
  {
    AppMethodBeat.i(210156);
    Object localObject = eX();
    if (((f)localObject).zO == null) {
      ((f)localObject).zO = new f.e((f)localObject);
    }
    localObject = ((f)localObject).zO;
    AppMethodBeat.o(210156);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.b.a
 * JD-Core Version:    0.7.0.1
 */