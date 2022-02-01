package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class ea
  extends JsonComposer
{
  @Json(name="layerid")
  public String a;
  @Json(name="type")
  public int b;
  @Json(name="local_data_ver")
  public int c;
  @Json(name="local_cfg_ver")
  public int d;
  @Json(ignore=true)
  public String e;
  @Json(name="data_ver")
  private String f;
  @Json(name="cfg_ver")
  private String g;
  @Json(name="params")
  private String[] h;
  @Json(name="url")
  private String i;
  
  private void a(int paramInt)
  {
    if (paramInt != this.c) {
      this.e = null;
    }
    this.c = paramInt;
  }
  
  private String b()
  {
    return this.a;
  }
  
  private void b(int paramInt)
  {
    if (paramInt != this.d) {
      this.e = null;
    }
    this.d = paramInt;
  }
  
  private String c()
  {
    AppMethodBeat.i(221476);
    String str = this.c;
    AppMethodBeat.o(221476);
    return str;
  }
  
  private String d()
  {
    AppMethodBeat.i(221482);
    String str = this.d;
    AppMethodBeat.o(221482);
    return str;
  }
  
  private boolean e()
  {
    AppMethodBeat.i(221503);
    if ((!this.f.equals(this.c)) || (!this.g.equals(this.d)))
    {
      AppMethodBeat.o(221503);
      return true;
    }
    AppMethodBeat.o(221503);
    return false;
  }
  
  private dw f()
  {
    AppMethodBeat.i(221514);
    dw localdw = dw.a(this.b);
    AppMethodBeat.o(221514);
    return localdw;
  }
  
  public final String a()
  {
    AppMethodBeat.i(221526);
    int j;
    if ((!this.f.equals(this.c)) || (!this.g.equals(this.d))) {
      j = 1;
    }
    for (;;)
    {
      if (j != 0)
      {
        this.g = this.d;
        this.f = this.c;
        this.e = null;
      }
      Object localObject1;
      label154:
      String str;
      if ((this.h != null) && (this.e == null) && (!TextUtils.isEmpty(this.i)))
      {
        this.e = this.i;
        localObject1 = this.h;
        int k = localObject1.length;
        j = 0;
        if (j < k) {
          str = localObject1[j];
        }
      }
      try
      {
        Object localObject2 = getFieldValueByJsonName(str);
        if ((localObject2 instanceof String)) {
          this.e = this.e.replaceAll("\\{" + str + "\\}", (String)localObject2);
        }
        label218:
        j += 1;
        break label154;
        j = 0;
        continue;
        localObject1 = this.e;
        AppMethodBeat.o(221526);
        return localObject1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        break label218;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221534);
    String str = "DataLayer{layerId='" + this.a + '\'' + ", layerType='" + this.b + '\'' + ", remoteDataVersion='" + this.f + '\'' + ", dataVersion=" + this.c + ", remoteStyleVersion='" + this.g + '\'' + ", styleVersion=" + this.d + ", params=" + Arrays.toString(this.h) + ", dataUrl='" + this.i + '\'' + ", decodeDataUrl='" + this.e + '\'' + '}';
    AppMethodBeat.o(221534);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ea
 * JD-Core Version:    0.7.0.1
 */