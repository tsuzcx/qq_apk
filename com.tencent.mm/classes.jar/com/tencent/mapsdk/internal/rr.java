package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rr
  extends JsonComposer
{
  @Json(name="name")
  public String a;
  @Json(name="style")
  public int b;
  @Json(name="scene")
  public int c;
  @Json(name="version")
  public int d;
  @Json(name="url")
  public String e;
  @Json(name="range")
  public int[] f;
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 % paramInt2;
    paramInt1 = i;
    if (i * paramInt2 < 0) {
      paramInt1 = i + paramInt2;
    }
    return paramInt1;
  }
  
  private String a()
  {
    return this.a;
  }
  
  private String a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(223116);
    String str = this.e;
    int[] arrayOfInt = this.f;
    if (arrayOfInt.length == 0) {}
    for (str = str.replaceFirst("\\{range\\}", "");; str = str.replaceFirst("\\{range\\}", Integer.toString(a(paramInt1 + paramInt2, arrayOfInt.length))))
    {
      paramString = str.replaceFirst("\\{z\\}", Integer.toString(paramInt3)).replaceFirst("\\{x\\}", Integer.toString(paramInt1)).replaceFirst("\\{y\\}", Integer.toString(paramInt2)).replaceFirst("\\{style\\}", Integer.toString(this.b)).replaceFirst("\\{scene\\}", Integer.toString(this.c)).replaceFirst("\\{version\\}", Integer.toString(this.d)).replaceFirst("\\{ch\\}", paramString);
      AppMethodBeat.o(223116);
      return paramString;
    }
  }
  
  private void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  private void a(String paramString)
  {
    this.a = paramString;
  }
  
  private void a(int[] paramArrayOfInt)
  {
    this.f = paramArrayOfInt;
  }
  
  private int b()
  {
    return this.b;
  }
  
  private void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  private void b(String paramString)
  {
    this.e = paramString;
  }
  
  private int c()
  {
    return this.c;
  }
  
  private void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  private int d()
  {
    return this.d;
  }
  
  private String e()
  {
    return this.e;
  }
  
  private int[] f()
  {
    return this.f;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(223127);
    StringBuffer localStringBuffer = new StringBuffer("WorldMapTileSrc{");
    localStringBuffer.append("mName='").append(this.a).append('\'');
    localStringBuffer.append(", mStyle=").append(this.b);
    localStringBuffer.append(", mScene=").append(this.c);
    localStringBuffer.append(", mVersion=").append(this.d);
    localStringBuffer.append(", mUrl='").append(this.e).append('\'');
    localStringBuffer.append(", mRanges=");
    if (this.f == null) {
      localStringBuffer.append("null");
    }
    for (;;)
    {
      localStringBuffer.append('}');
      String str = localStringBuffer.toString();
      AppMethodBeat.o(223127);
      return str;
      localStringBuffer.append('[');
      int i = 0;
      if (i < this.f.length)
      {
        if (i == 0) {}
        for (str = "";; str = ", ")
        {
          localStringBuffer.append(str).append(this.f[i]);
          i += 1;
          break;
        }
      }
      localStringBuffer.append(']');
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rr
 * JD-Core Version:    0.7.0.1
 */