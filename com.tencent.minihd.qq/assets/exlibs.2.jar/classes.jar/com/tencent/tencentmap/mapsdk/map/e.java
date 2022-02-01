package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Bitmap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class e
{
  private b<String, a> a;
  
  public e(int paramInt)
  {
    this.a = new b(paramInt);
  }
  
  public a a(String paramString)
  {
    return (a)this.a.a(paramString);
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(String paramString, a parama)
  {
    this.a.a(paramString, parama);
  }
  
  public a b(String paramString)
  {
    return (a)this.a.b(paramString);
  }
  
  static class a
  {
    Bitmap a = null;
    long b = 0L;
  }
  
  static class b<K, V>
  {
    byte[] a = new byte[0];
    private LinkedHashMap<K, V> b;
    private int c;
    
    public b(int paramInt)
    {
      this.c = paramInt;
      this.b = new LinkedHashMap((int)Math.ceil(paramInt / 0.75F) + 1, 0.75F, true)
      {
        protected boolean removeEldestEntry(Map.Entry<K, V> paramAnonymousEntry)
        {
          return size() > e.b.a(e.b.this);
        }
      };
    }
    
    public V a(K paramK)
    {
      synchronized (this.a)
      {
        paramK = this.b.get(paramK);
        return paramK;
      }
    }
    
    public void a()
    {
      synchronized (this.a)
      {
        this.b.clear();
        return;
      }
    }
    
    public void a(K paramK, V paramV)
    {
      synchronized (this.a)
      {
        this.b.put(paramK, paramV);
        return;
      }
    }
    
    public V b(K paramK)
    {
      synchronized (this.a)
      {
        paramK = this.b.remove(paramK);
        return paramK;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.e
 * JD-Core Version:    0.7.0.1
 */