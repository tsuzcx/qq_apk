package com.tencent.mm.loader.h;

import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;

public final class d<K, V>
{
  private f<K, V> hjg;
  
  public d(int paramInt)
  {
    this.hjg = new c(paramInt);
  }
  
  public final V aL(K paramK)
  {
    if (this.hjg == null) {
      throw new NullPointerException("mData == null");
    }
    return this.hjg.aL(paramK);
  }
  
  public final boolean aM(K paramK)
  {
    try
    {
      if (this.hjg == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    boolean bool = this.hjg.aM(paramK);
    return bool;
  }
  
  public final void clear()
  {
    if (this.hjg == null) {
      throw new NullPointerException("mData == null");
    }
    this.hjg.trimToSize(-1);
  }
  
  public final V get(K paramK)
  {
    if (this.hjg == null) {
      throw new NullPointerException("mData == null");
    }
    return this.hjg.get(paramK);
  }
  
  public final V put(K paramK, V paramV)
  {
    if (this.hjg == null) {
      throw new NullPointerException("mData == null");
    }
    return this.hjg.put(paramK, paramV);
  }
  
  public final String toString()
  {
    try
    {
      if (this.hjg == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    String str = this.hjg.toString();
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.h.d
 * JD-Core Version:    0.7.0.1
 */