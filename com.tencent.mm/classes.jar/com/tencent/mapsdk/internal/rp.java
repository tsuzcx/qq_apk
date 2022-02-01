package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.List;

public final class rp
  extends JsonComposer
{
  public static int a = 0;
  public static final int b = 1000;
  public static int c = 100;
  public static final int d = 0;
  public static final int e = 0;
  public static final int f = 7;
  @Json(name="version")
  public int g;
  @Json(name="frontier")
  public ro h;
  @Json(name="ver_data")
  public List<rl> i;
  @Json(name="detail")
  public List<rm> j;
  
  private int a()
  {
    return this.g;
  }
  
  private void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  private void a(ro paramro)
  {
    this.h = paramro;
  }
  
  private void a(List<rl> paramList)
  {
    this.i = paramList;
  }
  
  private ro b()
  {
    return this.h;
  }
  
  private void b(List<rm> paramList)
  {
    this.j = paramList;
  }
  
  private List<rl> c()
  {
    return this.i;
  }
  
  private List<rm> d()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rp
 * JD-Core Version:    0.7.0.1
 */