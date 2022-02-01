package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.SecureRandom;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

public class pj
  implements JsonParser
{
  public String a;
  public String b;
  public int c;
  public int d;
  public boolean e;
  private String f;
  private String[] g;
  private JSONObject h;
  
  public final String a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(225383);
    if ((this.g == null) || (this.g.length == 0))
    {
      str1 = this.f;
      AppMethodBeat.o(225383);
      return str1;
    }
    String str1 = this.f.replace("{x}", String.valueOf(paramInt1)).replace("{y}", String.valueOf(paramInt2)).replace("{z}", String.valueOf(paramInt3));
    String[] arrayOfString = this.g;
    paramInt3 = arrayOfString.length;
    paramInt1 = 0;
    String str2;
    Object localObject;
    if (paramInt1 < paramInt3)
    {
      str2 = arrayOfString[paramInt1];
      localObject = this.h.opt(str2);
      if ((localObject instanceof JSONArray))
      {
        paramInt2 = ((JSONArray)localObject).length();
        localObject = (JSONArray)localObject;
        if (paramInt2 + 0 > 0)
        {
          paramInt2 = new SecureRandom().nextInt(paramInt2 + 0) + 0;
          label147:
          localObject = ((JSONArray)localObject).optString(paramInt2, "");
          str1 = str1.replace("{" + str2 + "}", (CharSequence)localObject);
        }
      }
    }
    for (;;)
    {
      paramInt1 += 1;
      break;
      paramInt2 = 0;
      break label147;
      if (((localObject instanceof String)) || ((localObject instanceof Number)))
      {
        str1 = str1.replace("{" + str2 + "}", String.valueOf(localObject));
        continue;
        AppMethodBeat.o(225383);
        return str1;
      }
    }
  }
  
  public void parse(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(225369);
    this.h = paramJSONObject;
    if (paramJSONObject != null)
    {
      this.a = paramJSONObject.optString("layerid");
      this.b = paramJSONObject.optString("version");
      this.f = paramJSONObject.optString("url");
      this.c = paramJSONObject.optInt("zoom_max", 20);
      this.d = paramJSONObject.optInt("zoom_min", 1);
      paramJSONObject = paramJSONObject.optJSONArray("params");
      if (paramJSONObject != null)
      {
        this.g = new String[paramJSONObject.length()];
        int i = 0;
        while (i < paramJSONObject.length())
        {
          this.g[i] = paramJSONObject.optString(i);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(225369);
  }
  
  public String toString()
  {
    AppMethodBeat.i(225395);
    StringBuffer localStringBuffer1 = new StringBuffer("CustomLayerModel{");
    localStringBuffer1.append("mLayerId='").append(this.a).append('\'');
    localStringBuffer1.append(", mVersion='").append(this.b).append('\'');
    localStringBuffer1.append(", mMaxZoomLevel=").append(this.c);
    localStringBuffer1.append(", mMinZoomLevel=").append(this.d);
    localStringBuffer1.append(", mUrl='").append(this.f).append('\'');
    StringBuffer localStringBuffer2 = localStringBuffer1.append(", mParamsHolders=");
    if (this.g == null) {}
    for (String str = "null";; str = Arrays.asList(this.g).toString())
    {
      localStringBuffer2.append(str);
      localStringBuffer1.append(", mVersionUpdated=").append(this.e);
      localStringBuffer1.append('}');
      str = localStringBuffer1.toString();
      AppMethodBeat.o(225395);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pj
 * JD-Core Version:    0.7.0.1
 */