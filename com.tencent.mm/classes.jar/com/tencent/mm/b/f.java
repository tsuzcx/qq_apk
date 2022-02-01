package com.tencent.mm.b;

import java.util.Map;
import java.util.Set;

public abstract interface f<K, O>
{
  public abstract void a(a<K, O> parama);
  
  public abstract O aJ(K paramK);
  
  public abstract boolean aK(K paramK);
  
  public abstract boolean aL(K paramK);
  
  public abstract void clear();
  
  public abstract int createCount();
  
  public abstract int evictionCount();
  
  public abstract O get(K paramK);
  
  public abstract int hitCount();
  
  public abstract Set<K> keySet();
  
  public abstract int maxSize();
  
  public abstract int missCount();
  
  public abstract void o(K paramK, O paramO);
  
  public abstract O put(K paramK, O paramO);
  
  public abstract int putCount();
  
  public abstract O remove(K paramK);
  
  public abstract int size();
  
  public abstract int sizeOf(K paramK, O paramO);
  
  public abstract Map<K, O> snapshot();
  
  public abstract void trimToSize(int paramInt);
  
  public static abstract interface a<K, O> {}
  
  public static abstract interface b<K, O>
  {
    public abstract void c(K paramK, O paramO1, O paramO2);
  }
  
  public static abstract interface c<K, O>
  {
    public abstract int p(K paramK, O paramO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.b.f
 * JD-Core Version:    0.7.0.1
 */