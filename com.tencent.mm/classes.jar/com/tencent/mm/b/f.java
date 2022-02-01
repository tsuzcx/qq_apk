package com.tencent.mm.b;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract interface f<K, O>
{
  public abstract void B(K paramK, O paramO);
  
  public abstract void a(f.a<K, O> parama);
  
  public abstract boolean check(K paramK);
  
  public abstract boolean checkAndUpTime(K paramK);
  
  public abstract void clear();
  
  public abstract int createCount();
  
  public abstract O ct(K paramK);
  
  public abstract int evictionCount();
  
  public abstract O get(K paramK);
  
  public abstract int hitCount();
  
  public abstract Set<K> keySet();
  
  public abstract int maxSize();
  
  public abstract int missCount();
  
  public abstract O put(K paramK, O paramO);
  
  public abstract int putCount();
  
  public abstract O remove(K paramK);
  
  public abstract int size();
  
  public abstract int sizeOf(K paramK, O paramO);
  
  public abstract Map<K, O> snapshot();
  
  public abstract void trimToSize(int paramInt);
  
  public abstract Collection<O> values();
  
  public static abstract interface b<K, O>
  {
    public abstract void preRemoveCallback(K paramK, O paramO1, O paramO2);
  }
  
  public static abstract interface c<K, O>
  {
    public abstract int C(K paramK, O paramO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.b.f
 * JD-Core Version:    0.7.0.1
 */