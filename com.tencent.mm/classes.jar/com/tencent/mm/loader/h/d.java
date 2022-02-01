package com.tencent.mm.loader.h;

import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;

public final class d<K, V>
{
  private f<K, V> kQK;
  
  public d(int paramInt)
  {
    this.kQK = new c(paramInt);
  }
  
  public final V aX(K paramK)
  {
    if (this.kQK == null) {
      throw new NullPointerException("mData == null");
    }
    return this.kQK.aX(paramK);
  }
  
  public final boolean check(K paramK)
  {
    try
    {
      if (this.kQK == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    boolean bool = this.kQK.check(paramK);
    return bool;
  }
  
  public final void clear()
  {
    if (this.kQK == null) {
      throw new NullPointerException("mData == null");
    }
    this.kQK.trimToSize(-1);
  }
  
  public final V get(K paramK)
  {
    if (this.kQK == null) {
      throw new NullPointerException("mData == null");
    }
    return this.kQK.get(paramK);
  }
  
  public final V put(K paramK, V paramV)
  {
    if (this.kQK == null) {
      throw new NullPointerException("mData == null");
    }
    return this.kQK.put(paramK, paramV);
  }
  
  public final V remove(K paramK)
  {
    if (this.kQK == null) {
      throw new NullPointerException("mData == null");
    }
    return this.kQK.remove(paramK);
  }
  
  public final String toString()
  {
    try
    {
      if (this.kQK == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    String str = this.kQK.toString();
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.d
 * JD-Core Version:    0.7.0.1
 */