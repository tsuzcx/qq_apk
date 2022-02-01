package com.tencent.mapsdk.internal;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public abstract class jo<D extends jh>
  implements jg<D>, jn<D>
{
  private ReentrantReadWriteLock a = new ReentrantReadWriteLock();
  
  public final D b(String paramString, Class<D> paramClass)
  {
    try
    {
      this.a.readLock().lock();
      paramString = a(paramString, paramClass);
      return paramString;
    }
    finally
    {
      this.a.readLock().unlock();
    }
  }
  
  public final void b(String paramString, D paramD)
  {
    try
    {
      this.a.writeLock().lock();
      a(paramString, paramD);
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  public final boolean b(String paramString)
  {
    try
    {
      this.a.writeLock().lock();
      boolean bool = a(paramString);
      return bool;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  public final void j()
  {
    try
    {
      this.a.writeLock().lock();
      b();
      return;
    }
    finally
    {
      this.a.writeLock().unlock();
    }
  }
  
  public final long k()
  {
    try
    {
      this.a.readLock().lock();
      long l = c();
      return l;
    }
    finally
    {
      this.a.readLock().unlock();
    }
  }
  
  public final long l()
  {
    try
    {
      this.a.readLock().lock();
      long l = d();
      return l;
    }
    finally
    {
      this.a.readLock().unlock();
    }
  }
  
  public final jn<D> m()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jo
 * JD-Core Version:    0.7.0.1
 */