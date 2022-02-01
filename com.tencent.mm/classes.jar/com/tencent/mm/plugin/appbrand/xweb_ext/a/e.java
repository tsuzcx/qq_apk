package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenEyeShadowInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "isValid", "", "()Z", "leftMaskPath", "", "getLeftMaskPath", "()Ljava/lang/String;", "setLeftMaskPath", "(Ljava/lang/String;)V", "rightMaskPath", "getRightMaskPath", "setRightMaskPath", "shimmerPosPath", "getShimmerPosPath", "setShimmerPosPath", "type", "", "getType", "()I", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"})
public final class e
  extends a
{
  @SuppressLint({"Range"})
  float alpha = -1.0F;
  String cGQ = "";
  String cGS = "";
  String cGU;
  
  public final com.tencent.mm.sticker.a ay(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(284483);
    p.k(paramJSONObject, "jsonObj");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
    if (localJSONObject == null)
    {
      Log.w("MicroMsg.FlattenEyeShadowInfo", "fromJson, paramsJsonObj is null");
      paramJSONObject = super.ay(paramJSONObject);
      AppMethodBeat.o(284483);
      return paramJSONObject;
    }
    this.alpha = ((float)localJSONObject.optDouble("alpha", -1.0D));
    String str = localJSONObject.optString("left_mask", "");
    p.j(str, "paramsJsonObj.optString(…N_KEY_LEFT_MASK_PATH, \"\")");
    this.cGQ = str;
    str = localJSONObject.optString("right_mask", "");
    p.j(str, "paramsJsonObj.optString(…_KEY_RIGHT_MASK_PATH, \"\")");
    this.cGS = str;
    this.cGU = localJSONObject.optString("shimmer_position", null);
    paramJSONObject = super.ay(paramJSONObject);
    AppMethodBeat.o(284483);
    return paramJSONObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(284480);
    if (-1.0F != this.alpha)
    {
      if (((CharSequence)this.cGQ).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label74;
        }
        if (((CharSequence)this.cGS).length() <= 0) {
          break label69;
        }
      }
      label69:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label74;
        }
        AppMethodBeat.o(284480);
        return true;
        i = 0;
        break;
      }
    }
    label74:
    AppMethodBeat.o(284480);
    return false;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(284486);
    JSONObject localJSONObject1 = super.toJson();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("alpha", Float.valueOf(this.alpha));
    localJSONObject2.put("left_mask", this.cGQ);
    localJSONObject2.put("right_mask", this.cGS);
    if (this.cGU != null) {
      localJSONObject2.put("shimmer_position", this.cGU);
    }
    if (this.cGU != null) {}
    for (int i = 1;; i = 0)
    {
      localJSONObject2.put("eyeshadow_type", i);
      localJSONObject1.put("params", localJSONObject2);
      AppMethodBeat.o(284486);
      return localJSONObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.e
 * JD-Core Version:    0.7.0.1
 */