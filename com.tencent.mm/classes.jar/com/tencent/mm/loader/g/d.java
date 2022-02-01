package com.tencent.mm.loader.g;

import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;

public final class d<K, V>
{
  public f<K, V> nsn;
  
  public d(int paramInt)
  {
    this.nsn = new c(paramInt);
  }
  
  public final boolean check(K paramK)
  {
    try
    {
      if (this.nsn == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    boolean bool = this.nsn.check(paramK);
    return bool;
  }
  
  public final V get(K paramK)
  {
    if (this.nsn == null) {
      throw new NullPointerException("mData == null");
    }
    return this.nsn.get(paramK);
  }
  
  public final V put(K paramK, V paramV)
  {
    if (this.nsn == null) {
      throw new NullPointerException("mData == null");
    }
    return this.nsn.put(paramK, paramV);
  }
  
  public final String toString()
  {
    try
    {
      if (this.nsn == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    String str = this.nsn.toString();
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.g.d
 * JD-Core Version:    0.7.0.1
 */