package android.arch.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class b<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  public b.c<K, V> bJ;
  public b.c<K, V> bK;
  public WeakHashMap<f<K, V>, Boolean> bL = new WeakHashMap();
  public int mSize = 0;
  
  public final b<K, V>.d N()
  {
    b.d locald = new b.d(this, (byte)0);
    this.bL.put(locald, Boolean.valueOf(false));
    return locald;
  }
  
  protected final b.c<K, V> b(K paramK, V paramV)
  {
    paramK = new b.c(paramK, paramV);
    this.mSize += 1;
    if (this.bK == null)
    {
      this.bJ = paramK;
      this.bK = this.bJ;
      return paramK;
    }
    this.bK.bN = paramK;
    paramK.bO = this.bK;
    this.bK = paramK;
    return paramK;
  }
  
  protected b.c<K, V> d(K paramK)
  {
    for (b.c localc = this.bJ; (localc != null) && (!localc.bM.equals(paramK)); localc = localc.bN) {}
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
    b.a locala = new b.a(this.bJ, this.bK);
    this.bL.put(locala, Boolean.valueOf(false));
    return locala;
  }
  
  public V putIfAbsent(K paramK, V paramV)
  {
    b.c localc = d(paramK);
    if (localc != null) {
      return localc.mValue;
    }
    b(paramK, paramV);
    return null;
  }
  
  public V remove(K paramK)
  {
    paramK = d(paramK);
    if (paramK == null) {
      return null;
    }
    this.mSize -= 1;
    if (!this.bL.isEmpty())
    {
      Iterator localIterator = this.bL.keySet().iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).c(paramK);
      }
    }
    if (paramK.bO != null)
    {
      paramK.bO.bN = paramK.bN;
      if (paramK.bN == null) {
        break label134;
      }
      paramK.bN.bO = paramK.bO;
    }
    for (;;)
    {
      paramK.bN = null;
      paramK.bO = null;
      return paramK.mValue;
      this.bJ = paramK.bN;
      break;
      label134:
      this.bK = paramK.bO;
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
  
  private static abstract class e<K, V>
    implements b.f<K, V>, Iterator<Map.Entry<K, V>>
  {
    b.c<K, V> bN;
    b.c<K, V> bS;
    
    e(b.c<K, V> paramc1, b.c<K, V> paramc2)
    {
      this.bS = paramc2;
      this.bN = paramc1;
    }
    
    private b.c<K, V> O()
    {
      if ((this.bN == this.bS) || (this.bS == null)) {
        return null;
      }
      return a(this.bN);
    }
    
    abstract b.c<K, V> a(b.c<K, V> paramc);
    
    abstract b.c<K, V> b(b.c<K, V> paramc);
    
    public final void c(b.c<K, V> paramc)
    {
      if ((this.bS == paramc) && (paramc == this.bN))
      {
        this.bN = null;
        this.bS = null;
      }
      if (this.bS == paramc) {
        this.bS = b(this.bS);
      }
      if (this.bN == paramc) {
        this.bN = O();
      }
    }
    
    public boolean hasNext()
    {
      return this.bN != null;
    }
  }
  
  static abstract interface f<K, V>
  {
    public abstract void c(b.c<K, V> paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.a.b.b
 * JD-Core Version:    0.7.0.1
 */