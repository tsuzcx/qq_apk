package com.tencent.mm.loader.h;

import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;

public final class d<K, V>
{
  private f<K, V> hgs;
  
  public d(int paramInt)
  {
    this.hgs = new c(paramInt);
  }
  
  public final V aL(K paramK)
  {
    if (this.hgs == null) {
      throw new NullPointerException("mData == null");
    }
    return this.hgs.aL(paramK);
  }
  
  public final boolean aM(K paramK)
  {
    try
    {
      if (this.hgs == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    boolean bool = this.hgs.aM(paramK);
    return bool;
  }
  
  public final void clear()
  {
    if (this.hgs == null) {
      throw new NullPointerException("mData == null");
    }
    this.hgs.trimToSize(-1);
  }
  
  public final V get(K paramK)
  {
    if (this.hgs == null) {
      throw new NullPointerException("mData == null");
    }
    return this.hgs.get(paramK);
  }
  
  public final V put(K paramK, V paramV)
  {
    if (this.hgs == null) {
      throw new NullPointerException("mData == null");
    }
    return this.hgs.put(paramK, paramV);
  }
  
  public final String toString()
  {
    try
    {
      if (this.hgs == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    String str = this.hgs.toString();
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.h.d
 * JD-Core Version:    0.7.0.1
 */