package com.tencent.mm.loader.h;

import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;

public final class d<K, V>
{
  private f<K, V> icd;
  
  public d(int paramInt)
  {
    this.icd = new c(paramInt);
  }
  
  public final V aT(K paramK)
  {
    if (this.icd == null) {
      throw new NullPointerException("mData == null");
    }
    return this.icd.aT(paramK);
  }
  
  public final boolean check(K paramK)
  {
    try
    {
      if (this.icd == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    boolean bool = this.icd.check(paramK);
    return bool;
  }
  
  public final void clear()
  {
    if (this.icd == null) {
      throw new NullPointerException("mData == null");
    }
    this.icd.trimToSize(-1);
  }
  
  public final V get(K paramK)
  {
    if (this.icd == null) {
      throw new NullPointerException("mData == null");
    }
    return this.icd.get(paramK);
  }
  
  public final V put(K paramK, V paramV)
  {
    if (this.icd == null) {
      throw new NullPointerException("mData == null");
    }
    return this.icd.put(paramK, paramV);
  }
  
  public final V remove(K paramK)
  {
    if (this.icd == null) {
      throw new NullPointerException("mData == null");
    }
    return this.icd.remove(paramK);
  }
  
  public final String toString()
  {
    try
    {
      if (this.icd == null) {
        throw new NullPointerException("mData == null");
      }
    }
    finally {}
    String str = this.icd.toString();
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.loader.h.d
 * JD-Core Version:    0.7.0.1
 */