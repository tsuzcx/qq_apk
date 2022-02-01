package com.tencent.mm.loader.h;

import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;

public final class d<K, V>
{
  private f<K, V> glI;
  
  public d(int paramInt)
  {
    this.glI = new c(paramInt);
  }
  
  public final V aM(K paramK)
  {
    if (this.glI == null) {
      throw new NullPointerException("mData == null");
    }
    return this.glI.aM(paramK);
  }
  
  public final boolean aN(K paramK)
  {
    try
    {
      if (this.glI == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    boolean bool = this.glI.aN(paramK);
    return bool;
  }
  
  public final void clear()
  {
    if (this.glI == null) {
      throw new NullPointerException("mData == null");
    }
    this.glI.trimToSize(-1);
  }
  
  public final V get(K paramK)
  {
    if (this.glI == null) {
      throw new NullPointerException("mData == null");
    }
    return this.glI.get(paramK);
  }
  
  public final V put(K paramK, V paramV)
  {
    if (this.glI == null) {
      throw new NullPointerException("mData == null");
    }
    return this.glI.put(paramK, paramV);
  }
  
  public final String toString()
  {
    try
    {
      if (this.glI == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    String str = this.glI.toString();
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.loader.h.d
 * JD-Core Version:    0.7.0.1
 */