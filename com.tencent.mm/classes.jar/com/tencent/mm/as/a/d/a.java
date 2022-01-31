package com.tencent.mm.as.a.d;

import com.tencent.mm.a.f;
import java.util.Map;

public final class a<K, V>
{
  private f<K, V> erO;
  
  public a(int paramInt)
  {
    this.erO = new f(paramInt);
  }
  
  public final boolean aC(K paramK)
  {
    try
    {
      if (this.erO == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    boolean bool = this.erO.aC(paramK);
    return bool;
  }
  
  public final void clear()
  {
    if (this.erO == null) {
      throw new NullPointerException("mData == null");
    }
    this.erO.trimToSize(-1);
  }
  
  public final V get(K paramK)
  {
    if (this.erO == null) {
      throw new NullPointerException("mData == null");
    }
    return this.erO.get(paramK);
  }
  
  public final V put(K paramK, V paramV)
  {
    if (this.erO == null) {
      throw new NullPointerException("mData == null");
    }
    return this.erO.put(paramK, paramV);
  }
  
  public final Map<K, V> snapshot()
  {
    try
    {
      if (this.erO == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    Map localMap = this.erO.snapshot();
    return localMap;
  }
  
  public final String toString()
  {
    try
    {
      if (this.erO == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    String str = this.erO.toString();
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.as.a.d.a
 * JD-Core Version:    0.7.0.1
 */