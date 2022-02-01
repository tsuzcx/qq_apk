package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

public class rq
  extends JsonComposer
{
  @Json(name="error")
  public int a = -2147483648;
  @Json(name="info")
  public rp b;
  
  private int a()
  {
    return this.a;
  }
  
  private void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  private void a(rp paramrp)
  {
    this.b = paramrp;
  }
  
  private rp b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rq
 * JD-Core Version:    0.7.0.1
 */