package android.arch.a.b;

import java.util.HashMap;

public final class a<K, V>
  extends b<K, V>
{
  public HashMap<K, b.c<K, V>> bP = new HashMap();
  
  protected final b.c<K, V> c(K paramK)
  {
    return (b.c)this.bP.get(paramK);
  }
  
  public final boolean contains(K paramK)
  {
    return this.bP.containsKey(paramK);
  }
  
  public final V putIfAbsent(K paramK, V paramV)
  {
    b.c localc = c(paramK);
    if (localc != null) {
      return localc.mValue;
    }
    this.bP.put(paramK, a(paramK, paramV));
    return null;
  }
  
  public final V remove(K paramK)
  {
    Object localObject = super.remove(paramK);
    this.bP.remove(paramK);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.a.b.a
 * JD-Core Version:    0.7.0.1
 */