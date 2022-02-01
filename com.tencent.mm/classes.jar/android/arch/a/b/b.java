package android.arch.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class b<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  public c<K, V> bQ;
  public c<K, V> bR;
  public WeakHashMap<f<K, V>, Boolean> bS = new WeakHashMap();
  public int mSize = 0;
  
  public final b<K, V>.d R()
  {
    d locald = new d((byte)0);
    this.bS.put(locald, Boolean.FALSE);
    return locald;
  }
  
  protected final c<K, V> a(K paramK, V paramV)
  {
    paramK = new c(paramK, paramV);
    this.mSize += 1;
    if (this.bR == null)
    {
      this.bQ = paramK;
      this.bR = this.bQ;
      return paramK;
    }
    this.bR.bU = paramK;
    paramK.bV = this.bR;
    this.bR = paramK;
    return paramK;
  }
  
  protected c<K, V> c(K paramK)
  {
    for (c localc = this.bQ; (localc != null) && (!localc.bT.equals(paramK)); localc = localc.bU) {}
    return localc;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof b)) {
      return false;
    }
    Object localObject1 = (b)paramObject;
    if (this.mSize != ((b)localObject1).mSize) {
      return false;
    }
    paramObject = iterator();
    localObject1 = ((b)localObject1).iterator();
    while ((paramObject.hasNext()) && (((Iterator)localObject1).hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)paramObject.next();
      Object localObject2 = ((Iterator)localObject1).next();
      if (((localEntry == null) && (localObject2 != null)) || ((localEntry != null) && (!localEntry.equals(localObject2)))) {
        return false;
      }
    }
    return (!paramObject.hasNext()) && (!((Iterator)localObject1).hasNext());
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    a locala = new a(this.bQ, this.bR);
    this.bS.put(locala, Boolean.FALSE);
    return locala;
  }
  
  public V putIfAbsent(K paramK, V paramV)
  {
    c localc = c(paramK);
    if (localc != null) {
      return localc.mValue;
    }
    a(paramK, paramV);
    return null;
  }
  
  public V remove(K paramK)
  {
    paramK = c(paramK);
    if (paramK == null) {
      return null;
    }
    this.mSize -= 1;
    if (!this.bS.isEmpty())
    {
      Iterator localIterator = this.bS.keySet().iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).c(paramK);
      }
    }
    if (paramK.bV != null)
    {
      paramK.bV.bU = paramK.bU;
      if (paramK.bU == null) {
        break label134;
      }
      paramK.bU.bV = paramK.bV;
    }
    for (;;)
    {
      paramK.bU = null;
      paramK.bV = null;
      return paramK.mValue;
      this.bQ = paramK.bU;
      break;
      label134:
      this.bR = paramK.bV;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((Map.Entry)localIterator.next()).toString());
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
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
      return paramc.bU;
    }
    
    final b.c<K, V> b(b.c<K, V> paramc)
    {
      return paramc.bV;
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
      return paramc.bV;
    }
    
    final b.c<K, V> b(b.c<K, V> paramc)
    {
      return paramc.bU;
    }
  }
  
  public static final class c<K, V>
    implements Map.Entry<K, V>
  {
    final K bT;
    c<K, V> bU;
    public c<K, V> bV;
    final V mValue;
    
    c(K paramK, V paramV)
    {
      this.bT = paramK;
      this.mValue = paramV;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof c)) {
          return false;
        }
        paramObject = (c)paramObject;
      } while ((this.bT.equals(paramObject.bT)) && (this.mValue.equals(paramObject.mValue)));
      return false;
    }
    
    public final K getKey()
    {
      return this.bT;
    }
    
    public final V getValue()
    {
      return this.mValue;
    }
    
    public final V setValue(V paramV)
    {
      throw new UnsupportedOperationException("An entry modification is not supported");
    }
    
    public final String toString()
    {
      return this.bT + "=" + this.mValue;
    }
  }
  
  public final class d
    implements b.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    private b.c<K, V> bW;
    private boolean bX = true;
    
    private d() {}
    
    public final void c(b.c<K, V> paramc)
    {
      if (paramc == this.bW)
      {
        this.bW = this.bW.bV;
        if (this.bW != null) {
          break label34;
        }
      }
      label34:
      for (boolean bool = true;; bool = false)
      {
        this.bX = bool;
        return;
      }
    }
    
    public final boolean hasNext()
    {
      if (this.bX) {
        if (b.a(b.this) == null) {}
      }
      while ((this.bW != null) && (this.bW.bU != null))
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
    b.c<K, V> bU;
    b.c<K, V> bZ;
    
    e(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      this.bZ = paramc2;
      this.bU = paramc1;
    }
    
    private b.c<K, V> S()
    {
      if ((this.bU == this.bZ) || (this.bZ == null)) {
        return null;
      }
      return a(this.bU);
    }
    
    abstract b.c<K, V> a(b.c<K, V> paramc);
    
    abstract b.c<K, V> b(b.c<K, V> paramc);
    
    public final void c(b.c<K, V> paramc)
    {
      if ((this.bZ == paramc) && (paramc == this.bU))
      {
        this.bU = null;
        this.bZ = null;
      }
      if (this.bZ == paramc) {
        this.bZ = b(this.bZ);
      }
      if (this.bU == paramc) {
        this.bU = S();
      }
    }
    
    public boolean hasNext()
    {
      return this.bU != null;
    }
  }
  
  static abstract interface f<K, V>
  {
    public abstract void c(b.c<K, V> paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.a.b.b
 * JD-Core Version:    0.7.0.1
 */