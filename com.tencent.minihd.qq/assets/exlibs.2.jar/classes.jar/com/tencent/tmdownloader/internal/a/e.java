package com.tencent.tmdownloader.internal.a;

import java.util.ArrayList;
import java.util.Iterator;

public class e
{
  protected static e a = null;
  protected final ArrayList b = new ArrayList();
  
  public static e a()
  {
    if (a == null) {
      a = new e();
    }
    return a;
  }
  
  public void a(l paraml)
  {
    try
    {
      if (!this.b.contains(paraml)) {
        this.b.add(paraml);
      }
      return;
    }
    finally
    {
      paraml = finally;
      throw paraml;
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((l)localIterator.next()).a(paramString1, paramInt1, paramInt2, paramString2);
      }
    }
    finally {}
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((l)localIterator.next()).a(paramString, paramLong1, paramLong2);
      }
    }
    finally {}
  }
  
  public void b(l paraml)
  {
    try
    {
      this.b.remove(paraml);
      return;
    }
    finally
    {
      paraml = finally;
      throw paraml;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.a.e
 * JD-Core Version:    0.7.0.1
 */