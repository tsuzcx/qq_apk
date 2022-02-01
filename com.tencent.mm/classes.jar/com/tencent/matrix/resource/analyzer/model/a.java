package com.tencent.matrix.resource.analyzer.model;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends b
{
  public final boolean cWT;
  public final boolean cWU;
  public final h cWV;
  public final Throwable cWW;
  public final long cWX;
  public final String mClassName;
  
  private a(boolean paramBoolean, String paramString, h paramh, Throwable paramThrowable, long paramLong)
  {
    this.cWT = paramBoolean;
    this.cWU = false;
    this.mClassName = paramString;
    this.cWV = paramh;
    this.cWW = paramThrowable;
    this.cWX = paramLong;
  }
  
  public static a a(String paramString, h paramh, long paramLong)
  {
    return new a(true, paramString, paramh, null, paramLong);
  }
  
  public static a a(Throwable paramThrowable, long paramLong)
  {
    return new a(false, null, null, paramThrowable, paramLong);
  }
  
  public static a bf(long paramLong)
  {
    return new a(false, null, null, null, paramLong);
  }
  
  public final void q(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = new JSONArray();
    if (this.cWV != null)
    {
      Iterator localIterator = this.cWV.elements.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((j)localIterator.next()).toString());
      }
    }
    paramJSONObject.put("leakFound", this.cWT).put("excludedLeak", this.cWU).put("className", this.mClassName).put("failure", String.valueOf(this.cWW)).put("analysisDurationMs", this.cWX).put("referenceChain", localJSONArray);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Leak Reference:");
    if (this.cWV != null)
    {
      Iterator localIterator = this.cWV.elements.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((j)localIterator.next()).toString()).append(";");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.a
 * JD-Core Version:    0.7.0.1
 */