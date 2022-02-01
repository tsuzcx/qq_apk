package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenFaceContourInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "faceModel", "", "getFaceModel", "()I", "setFaceModel", "(I)V", "highLightAlpha", "", "getHighLightAlpha", "()F", "setHighLightAlpha", "(F)V", "highLightContourPath", "", "getHighLightContourPath", "()Ljava/lang/String;", "setHighLightContourPath", "(Ljava/lang/String;)V", "isValid", "", "()Z", "shadowAlpha", "getShadowAlpha", "setShadowAlpha", "shadowContourPath", "getShadowContourPath", "setShadowContourPath", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"})
public final class f
  extends a
{
  int cGc;
  @SuppressLint({"Range"})
  float cGt = -1.0F;
  @SuppressLint({"Range"})
  float cGu = -1.0F;
  String cGv = "";
  String cGx = "";
  
  public final com.tencent.mm.sticker.a au(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(229721);
    p.h(paramJSONObject, "jsonObj");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
    if (localJSONObject == null)
    {
      Log.w("MicroMsg.FlattenFaceContourInfo", "fromJson, paramsJsonObj is null");
      paramJSONObject = super.au(paramJSONObject);
      AppMethodBeat.o(229721);
      return paramJSONObject;
    }
    this.cGt = ((float)localJSONObject.optDouble("highlight_alpha", -1.0D));
    this.cGu = ((float)localJSONObject.optDouble("shadow_alpha", -1.0D));
    String str = localJSONObject.optString("highlight_path", "");
    p.g(str, "paramsJsonObj.optString(…H_LIGHT_CONTOUR_PATH, \"\")");
    this.cGv = str;
    str = localJSONObject.optString("shadow_path", "");
    p.g(str, "paramsJsonObj.optString(…_SHADOW_CONTOUR_PATH, \"\")");
    this.cGx = str;
    this.cGc = localJSONObject.optInt("face_model", 0);
    paramJSONObject = super.au(paramJSONObject);
    AppMethodBeat.o(229721);
    return paramJSONObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(229720);
    if ((-1.0F != this.cGt) && (-1.0F != this.cGu))
    {
      if (((CharSequence)this.cGv).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label84;
        }
        if (((CharSequence)this.cGx).length() <= 0) {
          break label79;
        }
      }
      label79:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label84;
        }
        AppMethodBeat.o(229720);
        return true;
        i = 0;
        break;
      }
    }
    label84:
    AppMethodBeat.o(229720);
    return false;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(229722);
    JSONObject localJSONObject1 = super.toJson();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("highlight_alpha", Float.valueOf(this.cGt));
    localJSONObject2.put("shadow_alpha", Float.valueOf(this.cGu));
    localJSONObject2.put("highlight_path", this.cGv);
    localJSONObject2.put("shadow_path", this.cGx);
    localJSONObject2.put("face_model", this.cGc);
    localJSONObject1.put("params", localJSONObject2);
    AppMethodBeat.o(229722);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.f
 * JD-Core Version:    0.7.0.1
 */