package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenFaceContourInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "faceModel", "", "getFaceModel", "()I", "setFaceModel", "(I)V", "highLightAlpha", "", "getHighLightAlpha", "()F", "setHighLightAlpha", "(F)V", "highLightContourPath", "", "getHighLightContourPath", "()Ljava/lang/String;", "setHighLightContourPath", "(Ljava/lang/String;)V", "isValid", "", "()Z", "shadowAlpha", "getShadowAlpha", "setShadowAlpha", "shadowContourPath", "getShadowContourPath", "setShadowContourPath", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"})
public final class f
  extends a
{
  int cGI;
  @SuppressLint({"Range"})
  float cGZ = -1.0F;
  @SuppressLint({"Range"})
  float cHa = -1.0F;
  String cHb = "";
  String cHd = "";
  
  public final com.tencent.mm.sticker.a ay(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(264816);
    p.k(paramJSONObject, "jsonObj");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
    if (localJSONObject == null)
    {
      Log.w("MicroMsg.FlattenFaceContourInfo", "fromJson, paramsJsonObj is null");
      paramJSONObject = super.ay(paramJSONObject);
      AppMethodBeat.o(264816);
      return paramJSONObject;
    }
    this.cGZ = ((float)localJSONObject.optDouble("highlight_alpha", -1.0D));
    this.cHa = ((float)localJSONObject.optDouble("shadow_alpha", -1.0D));
    String str = localJSONObject.optString("highlight_path", "");
    p.j(str, "paramsJsonObj.optString(…H_LIGHT_CONTOUR_PATH, \"\")");
    this.cHb = str;
    str = localJSONObject.optString("shadow_path", "");
    p.j(str, "paramsJsonObj.optString(…_SHADOW_CONTOUR_PATH, \"\")");
    this.cHd = str;
    this.cGI = localJSONObject.optInt("face_model", 0);
    paramJSONObject = super.ay(paramJSONObject);
    AppMethodBeat.o(264816);
    return paramJSONObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(264815);
    if ((-1.0F != this.cGZ) && (-1.0F != this.cHa))
    {
      if (((CharSequence)this.cHb).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label84;
        }
        if (((CharSequence)this.cHd).length() <= 0) {
          break label79;
        }
      }
      label79:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label84;
        }
        AppMethodBeat.o(264815);
        return true;
        i = 0;
        break;
      }
    }
    label84:
    AppMethodBeat.o(264815);
    return false;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(264817);
    JSONObject localJSONObject1 = super.toJson();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("highlight_alpha", Float.valueOf(this.cGZ));
    localJSONObject2.put("shadow_alpha", Float.valueOf(this.cHa));
    localJSONObject2.put("highlight_path", this.cHb);
    localJSONObject2.put("shadow_path", this.cHd);
    localJSONObject2.put("face_model", this.cGI);
    localJSONObject1.put("params", localJSONObject2);
    AppMethodBeat.o(264817);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.f
 * JD-Core Version:    0.7.0.1
 */