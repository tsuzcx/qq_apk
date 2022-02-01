package com.tencent.mm.plugin.appbrand.openmaterial.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialNativeExtraData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "mimeType", "", "materialPath", "materialName", "materialSize", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getMaterialName", "()Ljava/lang/String;", "getMaterialPath", "getMaterialSize", "()I", "getMimeType", "toJsonString", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements d
{
  public static final a trS;
  public final String mimeType;
  public final String trT;
  private final String trU;
  private final int trV;
  
  static
  {
    AppMethodBeat.i(323617);
    trS = new a((byte)0);
    AppMethodBeat.o(323617);
  }
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(323583);
    this.mimeType = paramString1;
    this.trT = paramString2;
    this.trU = paramString3;
    this.trV = paramInt;
    AppMethodBeat.o(323583);
  }
  
  public static final a aep(String paramString)
  {
    AppMethodBeat.i(323599);
    paramString = a.aep(paramString);
    AppMethodBeat.o(323599);
    return paramString;
  }
  
  public static final String aeq(String paramString)
  {
    AppMethodBeat.i(323609);
    if (paramString == null)
    {
      AppMethodBeat.o(323609);
      return null;
    }
    paramString = a.aep(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(323609);
      return null;
    }
    paramString = paramString.mimeType;
    AppMethodBeat.o(323609);
    return paramString;
  }
  
  public final String toJsonString()
  {
    AppMethodBeat.i(323625);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("mimeType", this.mimeType);
      ((JSONObject)localObject).put("materialPath", this.trT);
      ((JSONObject)localObject).put("materialName", this.trU);
      ((JSONObject)localObject).put("materialSize", this.trV);
      localObject = ((JSONObject)localObject).toString();
      s.s(localObject, "try {\n            val js…     EMPTY_JSON\n        }");
      AppMethodBeat.o(323625);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialNativeExtraData", s.X("toJsonString fail since ", localException));
        String str = "{}";
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialNativeExtraData$Companion;", "", "()V", "fromJsonString", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialNativeExtraData;", "jsonStr", "", "parseMimeType", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a aep(String paramString)
    {
      AppMethodBeat.i(323616);
      s.u(paramString, "jsonStr");
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("mimeType");
        String str2 = paramString.getString("materialPath");
        String str3 = paramString.optString("materialName", "");
        int i = paramString.optInt("materialSize", 0);
        s.s(str1, "mimeType");
        s.s(str2, "materialPath");
        s.s(str3, "materialName");
        paramString = new a(str1, str2, str3, i);
        AppMethodBeat.o(323616);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialNativeExtraData", s.X("fromJsonString fail since ", paramString));
          paramString = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.a
 * JD-Core Version:    0.7.0.1
 */