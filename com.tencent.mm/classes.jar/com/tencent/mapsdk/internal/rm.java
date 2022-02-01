package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.List;

public class rm
  extends JsonComposer
{
  @Json(name="level")
  public int[] a;
  @Json(name="districts")
  public List<rn> b;
  
  private void a(List<rn> paramList)
  {
    this.b = paramList;
  }
  
  private void a(int[] paramArrayOfInt)
  {
    this.a = paramArrayOfInt;
  }
  
  private int[] a()
  {
    return this.a;
  }
  
  private List<rn> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rm
 * JD-Core Version:    0.7.0.1
 */