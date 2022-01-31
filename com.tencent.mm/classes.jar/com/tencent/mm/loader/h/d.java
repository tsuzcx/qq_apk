package com.tencent.mm.loader.h;

import com.tencent.mm.a.f;
import com.tencent.mm.memory.a.c;

public final class d<K, V>
{
  private f<K, V> eQf;
  
  public d(int paramInt)
  {
    this.eQf = new c(paramInt);
  }
  
  public final V Y(K paramK)
  {
    if (this.eQf == null) {
      throw new NullPointerException("mData == null");
    }
    return this.eQf.Y(paramK);
  }
  
  public final boolean Z(K paramK)
  {
    try
    {
      if (this.eQf == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    boolean bool = this.eQf.Z(paramK);
    return bool;
  }
  
  public final V get(K paramK)
  {
    if (this.eQf == null) {
      throw new NullPointerException("mData == null");
    }
    return this.eQf.get(paramK);
  }
  
  public final V put(K paramK, V paramV)
  {
    if (this.eQf == null) {
      throw new NullPointerException("mData == null");
    }
    return this.eQf.put(paramK, paramV);
  }
  
  public final String toString()
  {
    try
    {
      if (this.eQf == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    String str = this.eQf.toString();
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.loader.h.d
 * JD-Core Version:    0.7.0.1
 */