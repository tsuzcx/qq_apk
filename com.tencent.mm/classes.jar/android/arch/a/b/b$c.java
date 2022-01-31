package android.arch.a.b;

import java.util.Map.Entry;

public final class b$c<K, V>
  implements Map.Entry<K, V>
{
  final K bM;
  c<K, V> bN;
  public c<K, V> bO;
  final V mValue;
  
  b$c(K paramK, V paramV)
  {
    this.bM = paramK;
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
    } while ((this.bM.equals(paramObject.bM)) && (this.mValue.equals(paramObject.mValue)));
    return false;
  }
  
  public final K getKey()
  {
    return this.bM;
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
    return this.bM + "=" + this.mValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.arch.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */