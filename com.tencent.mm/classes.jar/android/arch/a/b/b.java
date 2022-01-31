package android.arch.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class b<K, V>
  implements Iterable<Map.Entry<K, V>>
{
  public b.c<K, V> bN;
  public b.c<K, V> bO;
  public WeakHashMap<b.f<K, V>, Boolean> bP = new WeakHashMap();
  public int mSize = 0;
  
  public final b<K, V>.d af()
  {
    b.d locald = new b.d(this, (byte)0);
    this.bP.put(locald, Boolean.FALSE);
    return locald;
  }
  
  protected final b.c<K, V> b(K paramK, V paramV)
  {
    paramK = new b.c(paramK, paramV);
    this.mSize += 1;
    if (this.bO == null)
    {
      this.bN = paramK;
      this.bO = this.bN;
      return paramK;
    }
    this.bO.bR = paramK;
    paramK.bS = this.bO;
    this.bO = paramK;
    return paramK;
  }
  
  protected b.c<K, V> d(K paramK)
  {
    for (b.c localc = this.bN; (localc != null) && (!localc.bQ.equals(paramK)); localc = localc.bR) {}
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
    b.a locala = new b.a(this.bN, this.bO);
    this.bP.put(locala, Boolean.FALSE);
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
    if (!this.bP.isEmpty())
    {
      Iterator localIterator = this.bP.keySet().iterator();
      while (localIterator.hasNext()) {
        ((b.f)localIterator.next()).c(paramK);
      }
    }
    if (paramK.bS != null)
    {
      paramK.bS.bR = paramK.bR;
      if (paramK.bR == null) {
        break label134;
      }
      paramK.bR.bS = paramK.bS;
    }
    for (;;)
    {
      paramK.bR = null;
      paramK.bS = null;
      return paramK.mValue;
      this.bN = paramK.bR;
      break;
      label134:
      this.bO = paramK.bS;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.arch.a.b.b
 * JD-Core Version:    0.7.0.1
 */