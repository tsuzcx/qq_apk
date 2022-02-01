package com.tencent.mm.plugin.appbrand.openmaterial.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialNativeExtraData;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "mimeType", "", "materialPath", "materialName", "materialSize", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getMaterialName", "()Ljava/lang/String;", "getMaterialPath", "getMaterialSize", "()I", "getMimeType", "toJsonString", "Companion", "plugin-appbrand-integration_release"})
public final class a
  implements d
{
  public static final a qno;
  public final String mimeType;
  public final String qnl;
  private final String qnm;
  private final int qnn;
  
  static
  {
    AppMethodBeat.i(273269);
    qno = new a((byte)0);
    AppMethodBeat.o(273269);
  }
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(273267);
    this.mimeType = paramString1;
    this.qnl = paramString2;
    this.qnm = paramString3;
    this.qnn = paramInt;
    AppMethodBeat.o(273267);
  }
  
  public static final a ali(String paramString)
  {
    AppMethodBeat.i(273270);
    paramString = a.ali(paramString);
    AppMethodBeat.o(273270);
    return paramString;
  }
  
  public static final String alj(String paramString)
  {
    AppMethodBeat.i(273271);
    if (paramString != null)
    {
      paramString = a.ali(paramString);
      if (paramString != null)
      {
        paramString = paramString.mimeType;
        AppMethodBeat.o(273271);
        return paramString;
      }
      AppMethodBeat.o(273271);
      return null;
    }
    AppMethodBeat.o(273271);
    return null;
  }
  
  public final String bFa()
  {
    AppMethodBeat.i(273265);
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("mimeType", this.mimeType);
      ((JSONObject)localObject).put("materialPath", this.qnl);
      ((JSONObject)localObject).put("materialName", this.qnm);
      ((JSONObject)localObject).put("materialSize", this.qnn);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(273265);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialNativeExtraData", "toJsonString fail since ".concat(String.valueOf(localException)));
        String str = "{}";
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialNativeExtraData$Companion;", "", "()V", "fromJsonString", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialNativeExtraData;", "jsonStr", "", "parseMimeType", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static a ali(String paramString)
    {
      AppMethodBeat.i(262467);
      p.k(paramString, "jsonStr");
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("mimeType");
        String str2 = paramString.getString("materialPath");
        String str3 = paramString.optString("materialName", "");
        int i = paramString.optInt("materialSize", 0);
        p.j(str1, "mimeType");
        p.j(str2, "materialPath");
        p.j(str3, "materialName");
        paramString = new a(str1, str2, str3, i);
        AppMethodBeat.o(262467);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialNativeExtraData", "fromJsonString fail since ".concat(String.valueOf(paramString)));
          paramString = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.model.a
 * JD-Core Version:    0.7.0.1
 */