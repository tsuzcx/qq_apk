package com.tencent.matrix.resource.analyzer.model;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends b
{
  public final boolean cuR;
  public final boolean cuS;
  public final h cuT;
  public final Throwable cuU;
  public final long cuV;
  public final String mClassName;
  
  private a(boolean paramBoolean, String paramString, h paramh, Throwable paramThrowable, long paramLong)
  {
    this.cuR = paramBoolean;
    this.cuS = false;
    this.mClassName = paramString;
    this.cuT = paramh;
    this.cuU = paramThrowable;
    this.cuV = paramLong;
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
    if (this.cuT != null)
    {
      Iterator localIterator = this.cuT.elements.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((j)localIterator.next()).toString());
      }
    }
    paramJSONObject.put("leakFound", this.cuR).put("excludedLeak", this.cuS).put("className", this.mClassName).put("failure", String.valueOf(this.cuU)).put("analysisDurationMs", this.cuV).put("referenceChain", localJSONArray);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Leak Reference:");
    if (this.cuT != null)
    {
      Iterator localIterator = this.cuT.elements.iterator();
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