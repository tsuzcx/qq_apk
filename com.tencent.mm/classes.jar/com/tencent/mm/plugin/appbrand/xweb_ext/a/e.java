package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenEyeShadowInfoV2;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "blendMode", "", "getBlendMode", "()I", "setBlendMode", "(I)V", "eyeShadowType", "getEyeShadowType", "isValid", "", "()Z", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "shimmerPosPath", "getShimmerPosPath", "setShimmerPosPath", "type", "getType", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  float alpha = -1.0F;
  String eAw;
  String path = "";
  private final String type = "EyeShadowV2";
  int uTR = -1;
  
  public final com.tencent.mm.sticker.a G(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(317099);
    s.u(paramJSONObject, "jsonObj");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
    if (localJSONObject == null)
    {
      Log.w("MicroMsg.FlattenEyeShadowInfo", "fromJson, paramsJsonObj is null");
      paramJSONObject = super.G(paramJSONObject);
      AppMethodBeat.o(317099);
      return paramJSONObject;
    }
    this.alpha = ((float)localJSONObject.optDouble("alpha", -1.0D));
    this.uTR = localJSONObject.optInt("blend_mode", -1);
    String str = localJSONObject.optString("path", "");
    s.s(str, "paramsJsonObj.optString(JSON_KEY_PATH, \"\")");
    this.path = str;
    this.eAw = localJSONObject.optString("shimmer_position", null);
    paramJSONObject = super.G(paramJSONObject);
    AppMethodBeat.o(317099);
    return paramJSONObject;
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(317087);
    if (-1.0F == this.alpha)
    {
      i = 1;
      if ((i != 0) || (-1 == this.uTR)) {
        break label67;
      }
      if (((CharSequence)this.path).length() <= 0) {
        break label62;
      }
    }
    label62:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label67;
      }
      AppMethodBeat.o(317087);
      return true;
      i = 0;
      break;
    }
    label67:
    AppMethodBeat.o(317087);
    return false;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(317107);
    JSONObject localJSONObject1 = super.toJson();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("alpha", Float.valueOf(this.alpha));
    localJSONObject2.put("blend_mode", this.uTR);
    localJSONObject2.put("path", this.path);
    if (this.eAw != null) {
      localJSONObject2.put("shimmer_position", this.eAw);
    }
    if (this.eAw != null) {}
    for (int i = 1;; i = 0)
    {
      localJSONObject2.put("eyeshadow_type", i);
      localJSONObject1.put("params", localJSONObject2);
      AppMethodBeat.o(317107);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.e
 * JD-Core Version:    0.7.0.1
 */