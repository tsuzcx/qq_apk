package com.tencent.matrix.resource.analyzer.model;

import java.util.Iterator;
import java.util.List;

public final class a
  extends b
{
  public final boolean eZt;
  public final boolean eZu;
  public final h eZv;
  public final Throwable eZw;
  public final long eZx;
  public final String mClassName;
  
  private a(boolean paramBoolean, String paramString, h paramh, Throwable paramThrowable, long paramLong)
  {
    this.eZt = paramBoolean;
    this.eZu = false;
    this.mClassName = paramString;
    this.eZv = paramh;
    this.eZw = paramThrowable;
    this.eZx = paramLong;
  }
  
  public static a a(String paramString, h paramh, long paramLong)
  {
    return new a(true, paramString, paramh, null, paramLong);
  }
  
  public static a a(Throwable paramThrowable, long paramLong)
  {
    return new a(false, null, null, paramThrowable, paramLong);
  }
  
  public static a dM(long paramLong)
  {
    return new a(false, null, null, null, paramLong);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Leak Reference:");
    if (this.eZv != null)
    {
      Iterator localIterator = this.eZv.elements.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((j)localIterator.next()).toString()).append(";");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.a
 * JD-Core Version:    0.7.0.1
 */