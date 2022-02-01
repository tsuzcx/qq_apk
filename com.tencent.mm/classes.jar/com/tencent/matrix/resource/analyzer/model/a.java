package com.tencent.matrix.resource.analyzer.model;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends b
{
  public final boolean cxI;
  public final boolean cxJ;
  public final h cxK;
  public final Throwable cxL;
  public final long cxM;
  public final String mClassName;
  
  private a(boolean paramBoolean, String paramString, h paramh, Throwable paramThrowable, long paramLong)
  {
    this.cxI = paramBoolean;
    this.cxJ = false;
    this.mClassName = paramString;
    this.cxK = paramh;
    this.cxL = paramThrowable;
    this.cxM = paramLong;
  }
  
  public static a a(String paramString, h paramh, long paramLong)
  {
    return new a(true, paramString, paramh, null, paramLong);
  }
  
  public static a a(Throwable paramThrowable, long paramLong)
  {
    return new a(false, null, null, paramThrowable, paramLong);
  }
  
  public static a aU(long paramLong)
  {
    return new a(false, null, null, null, paramLong);
  }
  
  public final void m(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = new JSONArray();
    if (this.cxK != null)
    {
      Iterator localIterator = this.cxK.elements.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((j)localIterator.next()).toString());
      }
    }
    paramJSONObject.put("leakFound", this.cxI).put("excludedLeak", this.cxJ).put("className", this.mClassName).put("failure", String.valueOf(this.cxL)).put("analysisDurationMs", this.cxM).put("referenceChain", localJSONArray);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Leak Reference:");
    if (this.cxK != null)
    {
      Iterator localIterator = this.cxK.elements.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((j)localIterator.next()).toString()).append(";");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.a
 * JD-Core Version:    0.7.0.1
 */