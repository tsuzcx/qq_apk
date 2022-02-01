package com.tencent.mm.loader.h;

import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;

public final class d<K, V>
{
  private f<K, V> gMv;
  
  public d(int paramInt)
  {
    this.gMv = new c(paramInt);
  }
  
  public final V aJ(K paramK)
  {
    if (this.gMv == null) {
      throw new NullPointerException("mData == null");
    }
    return this.gMv.aJ(paramK);
  }
  
  public final boolean aK(K paramK)
  {
    try
    {
      if (this.gMv == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    boolean bool = this.gMv.aK(paramK);
    return bool;
  }
  
  public final void clear()
  {
    if (this.gMv == null) {
      throw new NullPointerException("mData == null");
    }
    this.gMv.trimToSize(-1);
  }
  
  public final V get(K paramK)
  {
    if (this.gMv == null) {
      throw new NullPointerException("mData == null");
    }
    return this.gMv.get(paramK);
  }
  
  public final V put(K paramK, V paramV)
  {
    if (this.gMv == null) {
      throw new NullPointerException("mData == null");
    }
    return this.gMv.put(paramK, paramV);
  }
  
  public final String toString()
  {
    try
    {
      if (this.gMv == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    String str = this.gMv.toString();
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.h.d
 * JD-Core Version:    0.7.0.1
 */