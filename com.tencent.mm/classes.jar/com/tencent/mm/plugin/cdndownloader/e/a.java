package com.tencent.mm.plugin.cdndownloader.e;

import java.util.HashSet;

public final class a<E>
  extends HashSet<E>
{
  private b iAO;
  
  public a(b paramb)
  {
    this.iAO = paramb;
  }
  
  private void aDA()
  {
    try
    {
      this.iAO.remove();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void aDB()
  {
    try
    {
      this.iAO.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void aDz()
  {
    try
    {
      this.iAO.aDy();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean add(E paramE)
  {
    try
    {
      boolean bool = super.add(paramE);
      aDz();
      return bool;
    }
    finally
    {
      paramE = finally;
      throw paramE;
    }
  }
  
  public final void clear()
  {
    super.clear();
    aDB();
  }
  
  public final boolean remove(Object paramObject)
  {
    try
    {
      boolean bool = super.remove(paramObject);
      aDA();
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.e.a
 * JD-Core Version:    0.7.0.1
 */