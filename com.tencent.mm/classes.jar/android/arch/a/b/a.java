package android.arch.a.b;

import java.util.HashMap;

public final class a<K, V>
  extends b<K, V>
{
  public HashMap<K, b.c<K, V>> bI = new HashMap();
  
  public final boolean contains(K paramK)
  {
    return this.bI.containsKey(paramK);
  }
  
  protected final b.c<K, V> d(K paramK)
  {
    return (b.c)this.bI.get(paramK);
  }
  
  public final V putIfAbsent(K paramK, V paramV)
  {
    b.c localc = d(paramK);
    if (localc != null) {
      return localc.mValue;
    }
    this.bI.put(paramK, b(paramK, paramV));
    return null;
  }
  
  public final V remove(K paramK)
  {
    Object localObject = super.remove(paramK);
    this.bI.remove(paramK);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.arch.a.b.a
 * JD-Core Version:    0.7.0.1
 */