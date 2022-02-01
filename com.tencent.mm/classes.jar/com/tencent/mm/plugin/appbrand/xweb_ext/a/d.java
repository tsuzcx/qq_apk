package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenEyeBrowInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "faceModel", "", "getFaceModel", "()I", "setFaceModel", "(I)V", "isValid", "", "()Z", "leftEyeBrowPath", "", "getLeftEyeBrowPath", "()Ljava/lang/String;", "setLeftEyeBrowPath", "(Ljava/lang/String;)V", "rightEyeBrowPath", "getRightEyeBrowPath", "setRightEyeBrowPath", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"})
public final class d
  extends a
{
  @SuppressLint({"Range"})
  float alpha = -1.0F;
  int cGI;
  String cGL = "";
  String cGN = "";
  
  public final com.tencent.mm.sticker.a ay(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(278739);
    p.k(paramJSONObject, "jsonObj");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
    if (localJSONObject == null)
    {
      Log.w("MicroMsg.FlattenEyeBrowInfo", "fromJson, paramsJsonObj is null");
      paramJSONObject = super.ay(paramJSONObject);
      AppMethodBeat.o(278739);
      return paramJSONObject;
    }
    this.alpha = ((float)localJSONObject.optDouble("alpha", -1.0D));
    String str = localJSONObject.optString("left_path", "");
    p.j(str, "paramsJsonObj.optString(…Y_LEFT_EYE_BROW_PATH, \"\")");
    this.cGL = str;
    str = localJSONObject.optString("right_path", "");
    p.j(str, "paramsJsonObj.optString(…_RIGHT_EYE_BROW_PATH, \"\")");
    this.cGN = str;
    this.cGI = localJSONObject.optInt("face_model", 0);
    paramJSONObject = super.ay(paramJSONObject);
    AppMethodBeat.o(278739);
    return paramJSONObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(278738);
    if (-1.0F != this.alpha)
    {
      if (((CharSequence)this.cGL).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label74;
        }
        if (((CharSequence)this.cGN).length() <= 0) {
          break label69;
        }
      }
      label69:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label74;
        }
        AppMethodBeat.o(278738);
        return true;
        i = 0;
        break;
      }
    }
    label74:
    AppMethodBeat.o(278738);
    return false;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(278741);
    JSONObject localJSONObject1 = super.toJson();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("alpha", Float.valueOf(this.alpha));
    localJSONObject2.put("left_path", this.cGL);
    localJSONObject2.put("right_path", this.cGN);
    localJSONObject2.put("face_model", this.cGI);
    localJSONObject1.put("params", localJSONObject2);
    AppMethodBeat.o(278741);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.d
 * JD-Core Version:    0.7.0.1
 */