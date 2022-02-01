package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

public final class ro
  extends JsonComposer
{
  @Json(name="version")
  public int a = 0;
  @Json(name="path")
  public String b;
  
  private String a()
  {
    return this.b;
  }
  
  private void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  private void a(String paramString)
  {
    this.b = paramString;
  }
  
  private int b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ro
 * JD-Core Version:    0.7.0.1
 */