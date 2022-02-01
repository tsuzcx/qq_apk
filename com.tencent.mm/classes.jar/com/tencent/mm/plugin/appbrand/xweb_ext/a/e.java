package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenEyeShadowInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "isValid", "", "()Z", "leftMaskPath", "", "getLeftMaskPath", "()Ljava/lang/String;", "setLeftMaskPath", "(Ljava/lang/String;)V", "rightMaskPath", "getRightMaskPath", "setRightMaskPath", "shimmerPosPath", "getShimmerPosPath", "setShimmerPosPath", "type", "", "getType", "()I", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"})
public final class e
  extends a
{
  @SuppressLint({"Range"})
  float alpha = -1.0F;
  String cGk = "";
  String cGm = "";
  String cGo;
  
  public final com.tencent.mm.sticker.a au(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(229718);
    p.h(paramJSONObject, "jsonObj");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
    if (localJSONObject == null)
    {
      Log.w("MicroMsg.FlattenEyeShadowInfo", "fromJson, paramsJsonObj is null");
      paramJSONObject = super.au(paramJSONObject);
      AppMethodBeat.o(229718);
      return paramJSONObject;
    }
    this.alpha = ((float)localJSONObject.optDouble("alpha", -1.0D));
    String str = localJSONObject.optString("left_mask", "");
    p.g(str, "paramsJsonObj.optString(…N_KEY_LEFT_MASK_PATH, \"\")");
    this.cGk = str;
    str = localJSONObject.optString("right_mask", "");
    p.g(str, "paramsJsonObj.optString(…_KEY_RIGHT_MASK_PATH, \"\")");
    this.cGm = str;
    this.cGo = localJSONObject.optString("shimmer_position", null);
    paramJSONObject = super.au(paramJSONObject);
    AppMethodBeat.o(229718);
    return paramJSONObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(229717);
    if (-1.0F != this.alpha)
    {
      if (((CharSequence)this.cGk).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label74;
        }
        if (((CharSequence)this.cGm).length() <= 0) {
          break label69;
        }
      }
      label69:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label74;
        }
        AppMethodBeat.o(229717);
        return true;
        i = 0;
        break;
      }
    }
    label74:
    AppMethodBeat.o(229717);
    return false;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(229719);
    JSONObject localJSONObject1 = super.toJson();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("alpha", Float.valueOf(this.alpha));
    localJSONObject2.put("left_mask", this.cGk);
    localJSONObject2.put("right_mask", this.cGm);
    if (this.cGo != null) {
      localJSONObject2.put("shimmer_position", this.cGo);
    }
    if (this.cGo != null) {}
    for (int i = 1;; i = 0)
    {
      localJSONObject2.put("eyeshadow_type", i);
      localJSONObject1.put("params", localJSONObject2);
      AppMethodBeat.o(229719);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.e
 * JD-Core Version:    0.7.0.1
 */