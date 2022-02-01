package com.tencent.matrix.resource.analyzer.model;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends b
{
  public final boolean cGv;
  public final boolean cGw;
  public final h cGx;
  public final Throwable cGy;
  public final long cGz;
  public final String mClassName;
  
  private a(boolean paramBoolean, String paramString, h paramh, Throwable paramThrowable, long paramLong)
  {
    this.cGv = paramBoolean;
    this.cGw = false;
    this.mClassName = paramString;
    this.cGx = paramh;
    this.cGy = paramThrowable;
    this.cGz = paramLong;
  }
  
  public static a a(String paramString, h paramh, long paramLong)
  {
    return new a(true, paramString, paramh, null, paramLong);
  }
  
  public static a a(Throwable paramThrowable, long paramLong)
  {
    return new a(false, null, null, paramThrowable, paramLong);
  }
  
  public static a aQ(long paramLong)
  {
    return new a(false, null, null, null, paramLong);
  }
  
  public final void m(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = new JSONArray();
    if (this.cGx != null)
    {
      Iterator localIterator = this.cGx.elements.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((j)localIterator.next()).toString());
      }
    }
    paramJSONObject.put("leakFound", this.cGv).put("excludedLeak", this.cGw).put("className", this.mClassName).put("failure", String.valueOf(this.cGy)).put("analysisDurationMs", this.cGz).put("referenceChain", localJSONArray);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Leak Reference:");
    if (this.cGx != null)
    {
      Iterator localIterator = this.cGx.elements.iterator();
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