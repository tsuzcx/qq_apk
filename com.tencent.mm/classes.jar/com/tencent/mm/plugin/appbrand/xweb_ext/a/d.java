package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenEyeBrowInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "blendMode", "", "getBlendMode", "()I", "setBlendMode", "(I)V", "faceModel", "getFaceModel", "setFaceModel", "isValid", "", "()Z", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "shrinkRate", "getShrinkRate", "setShrinkRate", "type", "getType", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  float alpha = -1.0F;
  int eAs;
  float eAv = -1.0F;
  String path = "";
  private final String type = "EyeBrow";
  int uTR = -1;
  
  public final com.tencent.mm.sticker.a G(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(317083);
    s.u(paramJSONObject, "jsonObj");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
    if (localJSONObject == null)
    {
      Log.w("MicroMsg.FlattenEyeBrowInfo", "fromJson, paramsJsonObj is null");
      paramJSONObject = super.G(paramJSONObject);
      AppMethodBeat.o(317083);
      return paramJSONObject;
    }
    this.alpha = ((float)localJSONObject.optDouble("alpha", -1.0D));
    this.eAs = localJSONObject.optInt("face_model", 0);
    this.uTR = localJSONObject.optInt("blend_mode", -1);
    String str = localJSONObject.optString("path", "");
    s.s(str, "paramsJsonObj.optString(JSON_KEY_PATH, \"\")");
    this.path = str;
    this.eAv = ((float)localJSONObject.optDouble("shrink_rate", -1.0D));
    paramJSONObject = super.G(paramJSONObject);
    AppMethodBeat.o(317083);
    return paramJSONObject;
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(317075);
    if (-1.0F == this.alpha)
    {
      i = 1;
      if ((i != 0) || (-1 == this.uTR)) {
        break label88;
      }
      if (((CharSequence)this.path).length() <= 0) {
        break label78;
      }
      i = 1;
      label46:
      if (i == 0) {
        break label88;
      }
      if (-1.0F != this.eAv) {
        break label83;
      }
    }
    label78:
    label83:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label88;
      }
      AppMethodBeat.o(317075);
      return true;
      i = 0;
      break;
      i = 0;
      break label46;
    }
    label88:
    AppMethodBeat.o(317075);
    return false;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(317094);
    JSONObject localJSONObject1 = super.toJson();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("alpha", Float.valueOf(this.alpha));
    localJSONObject2.put("face_model", this.eAs);
    localJSONObject2.put("blend_mode", this.uTR);
    localJSONObject2.put("path", this.path);
    localJSONObject2.put("shrink_rate", Float.valueOf(this.eAv));
    localJSONObject1.put("params", localJSONObject2);
    AppMethodBeat.o(317094);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.d
 * JD-Core Version:    0.7.0.1
 */