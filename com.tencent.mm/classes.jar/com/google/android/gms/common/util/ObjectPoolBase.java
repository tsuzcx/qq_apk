package com.google.android.gms.common.util;

import java.util.ArrayList;

public abstract class ObjectPoolBase<T>
{
  private final ArrayList<T> zzaag;
  private final int zzaah;
  
  public ObjectPoolBase(int paramInt)
  {
    this.zzaag = new ArrayList(paramInt);
    this.zzaah = paramInt;
  }
  
  public final T aquire()
  {
    synchronized (this.zzaag)
    {
      int i = this.zzaag.size();
      if (i > 0)
      {
        localObject1 = this.zzaag.remove(i - 1);
        return localObject1;
      }
      Object localObject1 = newObject();
      return localObject1;
    }
  }
  
  protected boolean cleanUpObject(T paramT)
  {
    return true;
  }
  
  protected abstract T newObject();
  
  public final boolean release(T paramT)
  {
    int j;
    for (;;)
    {
      int i;
      synchronized (this.zzaag)
      {
        j = this.zzaag.size();
        i = 0;
        if (i >= j) {
          break;
        }
        if (this.zzaag.get(i) == paramT)
        {
          paramT = String.valueOf(paramT);
          throw new IllegalArgumentException(String.valueOf(paramT).length() + 25 + "Object released already: " + paramT);
        }
      }
      i += 1;
    }
    if ((j < this.zzaah) && (cleanUpObject(paramT)))
    {
      this.zzaag.add(paramT);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.util.ObjectPoolBase
 * JD-Core Version:    0.7.0.1
 */