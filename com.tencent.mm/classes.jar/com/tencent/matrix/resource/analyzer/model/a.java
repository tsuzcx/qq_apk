package com.tencent.matrix.resource.analyzer.model;

import java.util.Iterator;
import java.util.List;

public final class a
  extends b
{
  public final boolean daT;
  public final boolean daU;
  public final h daV;
  public final Throwable daW;
  public final long daX;
  public final String mClassName;
  
  private a(boolean paramBoolean, String paramString, h paramh, Throwable paramThrowable, long paramLong)
  {
    this.daT = paramBoolean;
    this.daU = false;
    this.mClassName = paramString;
    this.daV = paramh;
    this.daW = paramThrowable;
    this.daX = paramLong;
  }
  
  public static a a(String paramString, h paramh, long paramLong)
  {
    return new a(true, paramString, paramh, null, paramLong);
  }
  
  public static a a(Throwable paramThrowable, long paramLong)
  {
    return new a(false, null, null, paramThrowable, paramLong);
  }
  
  public static a br(long paramLong)
  {
    return new a(false, null, null, null, paramLong);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Leak Reference:");
    if (this.daV != null)
    {
      Iterator localIterator = this.daV.elements.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((j)localIterator.next()).toString()).append(";");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.a
 * JD-Core Version:    0.7.0.1
 */