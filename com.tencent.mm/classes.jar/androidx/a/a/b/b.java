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
  public c<K, V> ye;
  public c<K, V> yf;
  public WeakHashMap<f<K, V>, Boolean> yg;
  
  public b()
  {
    AppMethodBeat.i(186290);
    this.yg = new WeakHashMap();
    this.mSize = 0;
    AppMethodBeat.o(186290);
  }
  
  protected final c<K, V> a(K paramK, V paramV)
  {
    AppMethodBeat.i(186300);
    paramK = new c(paramK, paramV);
    this.mSize += 1;
    if (this.yf == null)
    {
      this.ye = paramK;
      this.yf = this.ye;
      AppMethodBeat.o(186300);
      return paramK;
    }
    this.yf.yi = paramK;
    paramK.yj = this.yf;
    this.yf = paramK;
    AppMethodBeat.o(186300);
    return paramK;
  }
  
  public final b<K, V>.d eM()
  {
    AppMethodBeat.i(186313);
    d locald = new d();
    this.yg.put(locald, Boolean.FALSE);
    AppMethodBeat.o(186313);
    return locald;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186317);
    if (paramObject == this)
    {
      AppMethodBeat.o(186317);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(186317);
      return false;
    }
    Object localObject1 = (b)paramObject;
    if (this.mSize != ((b)localObject1).mSize)
    {
      AppMethodBeat.o(186317);
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
        AppMethodBeat.o(186317);
        return false;
      }
    }
    if ((!paramObject.hasNext()) && (!((Iterator)localObject1).hasNext()))
    {
      AppMethodBeat.o(186317);
      return true;
    }
    AppMethodBeat.o(186317);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(186319);
    Iterator localIterator = iterator();
    for (int i = 0; localIterator.hasNext(); i = ((Map.Entry)localIterator.next()).hashCode() + i) {}
    AppMethodBeat.o(186319);
    return i;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    AppMethodBeat.i(186311);
    a locala = new a(this.ye, this.yf);
    this.yg.put(locala, Boolean.FALSE);
    AppMethodBeat.o(186311);
    return locala;
  }
  
  protected c<K, V> n(K paramK)
  {
    AppMethodBeat.i(186293);
    for (c localc = this.ye; (localc != null) && (!localc.yh.equals(paramK)); localc = localc.yi) {}
    AppMethodBeat.o(186293);
    return localc;
  }
  
  public V putIfAbsent(K paramK, V paramV)
  {
    AppMethodBeat.i(186298);
    c localc = n(paramK);
    if (localc != null)
    {
      paramK = localc.mValue;
      AppMethodBeat.o(186298);
      return paramK;
    }
    a(paramK, paramV);
    AppMethodBeat.o(186298);
    return null;
  }
  
  public V remove(K paramK)
  {
    AppMethodBeat.i(186305);
    paramK = n(paramK);
    if (paramK == null)
    {
      AppMethodBeat.o(186305);
      return null;
    }
    this.mSize -= 1;
    if (!this.yg.isEmpty())
    {
      Iterator localIterator = this.yg.keySet().iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).c(paramK);
      }
    }
    if (paramK.yj != null)
    {
      paramK.yj.yi = paramK.yi;
      if (paramK.yi == null) {
        break label151;
      }
      paramK.yi.yj = paramK.yj;
    }
    for (;;)
    {
      paramK.yi = null;
      paramK.yj = null;
      paramK = paramK.mValue;
      AppMethodBeat.o(186305);
      return paramK;
      this.ye = paramK.yi;
      break;
      label151:
      this.yf = paramK.yj;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(186322);
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
    AppMethodBeat.o(186322);
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
      return paramc.yi;
    }
    
    final b.c<K, V> b(b.c<K, V> paramc)
    {
      return paramc.yj;
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
      return paramc.yj;
    }
    
    final b.c<K, V> b(b.c<K, V> paramc)
    {
      return paramc.yi;
    }
  }
  
  public static final class c<K, V>
    implements Map.Entry<K, V>
  {
    final V mValue;
    final K yh;
    c<K, V> yi;
    public c<K, V> yj;
    
    c(K paramK, V paramV)
    {
      this.yh = paramK;
      this.mValue = paramV;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(186268);
      if (paramObject == this)
      {
        AppMethodBeat.o(186268);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(186268);
        return false;
      }
      paramObject = (c)paramObject;
      if ((this.yh.equals(paramObject.yh)) && (this.mValue.equals(paramObject.mValue)))
      {
        AppMethodBeat.o(186268);
        return true;
      }
      AppMethodBeat.o(186268);
      return false;
    }
    
    public final K getKey()
    {
      return this.yh;
    }
    
    public final V getValue()
    {
      return this.mValue;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(186271);
      int i = this.yh.hashCode();
      int j = this.mValue.hashCode();
      AppMethodBeat.o(186271);
      return i ^ j;
    }
    
    public final V setValue(V paramV)
    {
      AppMethodBeat.i(186243);
      paramV = new UnsupportedOperationException("An entry modification is not supported");
      AppMethodBeat.o(186243);
      throw paramV;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(186244);
      String str = this.yh + "=" + this.mValue;
      AppMethodBeat.o(186244);
      return str;
    }
  }
  
  public final class d
    implements b.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    private b.c<K, V> yk;
    private boolean yl = true;
    
    d() {}
    
    public final void c(b.c<K, V> paramc)
    {
      if (paramc == this.yk)
      {
        this.yk = this.yk.yj;
        if (this.yk != null) {
          break label34;
        }
      }
      label34:
      for (boolean bool = true;; bool = false)
      {
        this.yl = bool;
        return;
      }
    }
    
    public final boolean hasNext()
    {
      if (this.yl) {
        if (b.this.ye == null) {}
      }
      while ((this.yk != null) && (this.yk.yi != null))
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
    b.c<K, V> yi;
    b.c<K, V> yn;
    
    e(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      this.yn = paramc2;
      this.yi = paramc1;
    }
    
    private b.c<K, V> eN()
    {
      if ((this.yi == this.yn) || (this.yn == null)) {
        return null;
      }
      return a(this.yi);
    }
    
    abstract b.c<K, V> a(b.c<K, V> paramc);
    
    abstract b.c<K, V> b(b.c<K, V> paramc);
    
    public final void c(b.c<K, V> paramc)
    {
      if ((this.yn == paramc) && (paramc == this.yi))
      {
        this.yi = null;
        this.yn = null;
      }
      if (this.yn == paramc) {
        this.yn = b(this.yn);
      }
      if (this.yi == paramc) {
        this.yi = eN();
      }
    }
    
    public boolean hasNext()
    {
      return this.yi != null;
    }
  }
  
  static abstract interface f<K, V>
  {
    public abstract void c(b.c<K, V> paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */