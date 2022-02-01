package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenEyeBrowInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "faceModel", "", "getFaceModel", "()I", "setFaceModel", "(I)V", "isValid", "", "()Z", "leftEyeBrowPath", "", "getLeftEyeBrowPath", "()Ljava/lang/String;", "setLeftEyeBrowPath", "(Ljava/lang/String;)V", "rightEyeBrowPath", "getRightEyeBrowPath", "setRightEyeBrowPath", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"})
public final class d
  extends a
{
  @SuppressLint({"Range"})
  float alpha = -1.0F;
  int cGc;
  String cGf = "";
  String cGh = "";
  
  public final com.tencent.mm.sticker.a au(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(229715);
    p.h(paramJSONObject, "jsonObj");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
    if (localJSONObject == null)
    {
      Log.w("MicroMsg.FlattenEyeBrowInfo", "fromJson, paramsJsonObj is null");
      paramJSONObject = super.au(paramJSONObject);
      AppMethodBeat.o(229715);
      return paramJSONObject;
    }
    this.alpha = ((float)localJSONObject.optDouble("alpha", -1.0D));
    String str = localJSONObject.optString("left_path", "");
    p.g(str, "paramsJsonObj.optString(…Y_LEFT_EYE_BROW_PATH, \"\")");
    this.cGf = str;
    str = localJSONObject.optString("right_path", "");
    p.g(str, "paramsJsonObj.optString(…_RIGHT_EYE_BROW_PATH, \"\")");
    this.cGh = str;
    this.cGc = localJSONObject.optInt("face_model", 0);
    paramJSONObject = super.au(paramJSONObject);
    AppMethodBeat.o(229715);
    return paramJSONObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(229714);
    if (-1.0F != this.alpha)
    {
      if (((CharSequence)this.cGf).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label74;
        }
        if (((CharSequence)this.cGh).length() <= 0) {
          break label69;
        }
      }
      label69:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label74;
        }
        AppMethodBeat.o(229714);
        return true;
        i = 0;
        break;
      }
    }
    label74:
    AppMethodBeat.o(229714);
    return false;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(229716);
    JSONObject localJSONObject1 = super.toJson();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("alpha", Float.valueOf(this.alpha));
    localJSONObject2.put("left_path", this.cGf);
    localJSONObject2.put("right_path", this.cGh);
    localJSONObject2.put("face_model", this.cGc);
    localJSONObject1.put("params", localJSONObject2);
    AppMethodBeat.o(229716);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.d
 * JD-Core Version:    0.7.0.1
 */