package androidx.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class b<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  public int mSize;
  public c<K, V> yZ;
  public c<K, V> za;
  public WeakHashMap<f<K, V>, Boolean> zb;
  
  public b()
  {
    AppMethodBeat.i(201101);
    this.zb = new WeakHashMap();
    this.mSize = 0;
    AppMethodBeat.o(201101);
  }
  
  protected final c<K, V> c(K paramK, V paramV)
  {
    AppMethodBeat.i(201134);
    paramK = new c(paramK, paramV);
    this.mSize += 1;
    if (this.za == null)
    {
      this.yZ = paramK;
      this.za = this.yZ;
      AppMethodBeat.o(201134);
      return paramK;
    }
    this.za.zc = paramK;
    paramK.zd = this.za;
    this.za = paramK;
    AppMethodBeat.o(201134);
    return paramK;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201173);
    if (paramObject == this)
    {
      AppMethodBeat.o(201173);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(201173);
      return false;
    }
    Object localObject1 = (b)paramObject;
    if (this.mSize != ((b)localObject1).mSize)
    {
      AppMethodBeat.o(201173);
      return false;
    }
    paramObject = iterator();
    localObject1 = ((b)localObject1).iterator();
    while ((paramObject.hasNext()) && (((Iterator)localObject1).hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)paramObject.next();
      Object localObject2 = ((Iterator)localObject1).next();
      if (((localEntry == null) && (localObject2 != null)) || ((localEntry != null) && (!localEntry.equals(localObject2))))
      {
        AppMethodBeat.o(201173);
        return false;
      }
    }
    if ((!paramObject.hasNext()) && (!((Iterator)localObject1).hasNext()))
    {
      AppMethodBeat.o(201173);
      return true;
    }
    AppMethodBeat.o(201173);
    return false;
  }
  
  public final b<K, V>.d fJ()
  {
    AppMethodBeat.i(201161);
    d locald = new d();
    this.zb.put(locald, Boolean.FALSE);
    AppMethodBeat.o(201161);
    return locald;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(201180);
    Iterator localIterator = iterator();
    for (int i = 0; localIterator.hasNext(); i = ((Map.Entry)localIterator.next()).hashCode() + i) {}
    AppMethodBeat.o(201180);
    return i;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    AppMethodBeat.i(201153);
    a locala = new a(this.yZ, this.za);
    this.zb.put(locala, Boolean.FALSE);
    AppMethodBeat.o(201153);
    return locala;
  }
  
  public V putIfAbsent(K paramK, V paramV)
  {
    AppMethodBeat.i(201121);
    c localc = q(paramK);
    if (localc != null)
    {
      paramK = localc.mValue;
      AppMethodBeat.o(201121);
      return paramK;
    }
    c(paramK, paramV);
    AppMethodBeat.o(201121);
    return null;
  }
  
  protected c<K, V> q(K paramK)
  {
    AppMethodBeat.i(201111);
    for (c localc = this.yZ; (localc != null) && (!localc.mKey.equals(paramK)); localc = localc.zc) {}
    AppMethodBeat.o(201111);
    return localc;
  }
  
  public V remove(K paramK)
  {
    AppMethodBeat.i(201145);
    paramK = q(paramK);
    if (paramK == null)
    {
      AppMethodBeat.o(201145);
      return null;
    }
    this.mSize -= 1;
    if (!this.zb.isEmpty())
    {
      Iterator localIterator = this.zb.keySet().iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).c(paramK);
      }
    }
    if (paramK.zd != null)
    {
      paramK.zd.zc = paramK.zc;
      if (paramK.zc == null) {
        break label151;
      }
      paramK.zc.zd = paramK.zd;
    }
    for (;;)
    {
      paramK.zc = null;
      paramK.zd = null;
      paramK = paramK.mValue;
      AppMethodBeat.o(201145);
      return paramK;
      this.yZ = paramK.zc;
      break;
      label151:
      this.za = paramK.zd;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(201192);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      ((StringBuilder)localObject).append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        ((StringBuilder)localObject).append(", ");
      }
    }
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(201192);
    return localObject;
  }
  
  static final class a<K, V>
    extends b.e<K, V>
  {
    a(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    final b.c<K, V> a(b.c<K, V> paramc)
    {
      return paramc.zc;
    }
    
    final b.c<K, V> b(b.c<K, V> paramc)
    {
      return paramc.zd;
    }
  }
  
  public static final class b<K, V>
    extends b.e<K, V>
  {
    public b(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      super(paramc2);
    }
    
    final b.c<K, V> a(b.c<K, V> paramc)
    {
      return paramc.zd;
    }
    
    final b.c<K, V> b(b.c<K, V> paramc)
    {
      return paramc.zc;
    }
  }
  
  public static final class c<K, V>
    implements Map.Entry<K, V>
  {
    final K mKey;
    final V mValue;
    c<K, V> zc;
    public c<K, V> zd;
    
    c(K paramK, V paramV)
    {
      this.mKey = paramK;
      this.mValue = paramV;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(201118);
      if (paramObject == this)
      {
        AppMethodBeat.o(201118);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(201118);
        return false;
      }
      paramObject = (c)paramObject;
      if ((this.mKey.equals(paramObject.mKey)) && (this.mValue.equals(paramObject.mValue)))
      {
        AppMethodBeat.o(201118);
        return true;
      }
      AppMethodBeat.o(201118);
      return false;
    }
    
    public final K getKey()
    {
      return this.mKey;
    }
    
    public final V getValue()
    {
      return this.mValue;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(201128);
      int i = this.mKey.hashCode();
      int j = this.mValue.hashCode();
      AppMethodBeat.o(201128);
      return i ^ j;
    }
    
    public final V setValue(V paramV)
    {
      AppMethodBeat.i(201103);
      paramV = new UnsupportedOperationException("An entry modification is not supported");
      AppMethodBeat.o(201103);
      throw paramV;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201110);
      String str = this.mKey + "=" + this.mValue;
      AppMethodBeat.o(201110);
      return str;
    }
  }
  
  public final class d
    implements b.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    private b.c<K, V> ze;
    private boolean zf = true;
    
    d() {}
    
    public final void c(b.c<K, V> paramc)
    {
      if (paramc == this.ze)
      {
        this.ze = this.ze.zd;
        if (this.ze != null) {
          break label34;
        }
      }
      label34:
      for (boolean bool = true;; bool = false)
      {
        this.zf = bool;
        return;
      }
    }
    
    public final boolean hasNext()
    {
      if (this.zf) {
        if (b.this.yZ == null) {}
      }
      while ((this.ze != null) && (this.ze.zc != null))
      {
        return true;
        return false;
      }
      return false;
    }
  }
  
  static abstract class e<K, V>
    implements b.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    b.c<K, V> zc;
    b.c<K, V> zi;
    
    e(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      this.zi = paramc2;
      this.zc = paramc1;
    }
    
    private b.c<K, V> fK()
    {
      if ((this.zc == this.zi) || (this.zi == null)) {
        return null;
      }
      return a(this.zc);
    }
    
    abstract b.c<K, V> a(b.c<K, V> paramc);
    
    abstract b.c<K, V> b(b.c<K, V> paramc);
    
    public final void c(b.c<K, V> paramc)
    {
      if ((this.zi == paramc) && (paramc == this.zc))
      {
        this.zc = null;
        this.zi = null;
      }
      if (this.zi == paramc) {
        this.zi = b(this.zi);
      }
      if (this.zc == paramc) {
        this.zc = fK();
      }
    }
    
    public boolean hasNext()
    {
      return this.zc != null;
    }
  }
  
  static abstract interface f<K, V>
  {
    public abstract void c(b.c<K, V> paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */