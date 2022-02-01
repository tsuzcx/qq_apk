package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenFaceContourInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "faceModel", "", "getFaceModel", "()I", "setFaceModel", "(I)V", "isValid", "", "()Z", "path", "", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "type", "getType", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  float alpha = -1.0F;
  int eAs;
  String path = "";
  private final String type = "FaceContour";
  
  public final com.tencent.mm.sticker.a G(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(317098);
    s.u(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.optJSONObject("params");
    if (localObject == null)
    {
      Log.w("MicroMsg.FlattenFaceContourInfo", "fromJson, paramsJsonObj is null");
      paramJSONObject = super.G(paramJSONObject);
      AppMethodBeat.o(317098);
      return paramJSONObject;
    }
    this.eAs = ((JSONObject)localObject).optInt("face_model", 0);
    this.alpha = ((float)((JSONObject)localObject).optDouble("alpha", -1.0D));
    localObject = ((JSONObject)localObject).optString("path", "");
    s.s(localObject, "paramsJsonObj.optString(JSON_KEY_PATH, \"\")");
    this.path = ((String)localObject);
    paramJSONObject = super.G(paramJSONObject);
    AppMethodBeat.o(317098);
    return paramJSONObject;
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(317085);
    if (-1.0F == this.alpha)
    {
      i = 1;
      if (i != 0) {
        break label59;
      }
      if (((CharSequence)this.path).length() <= 0) {
        break label54;
      }
    }
    label54:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label59;
      }
      AppMethodBeat.o(317085);
      return true;
      i = 0;
      break;
    }
    label59:
    AppMethodBeat.o(317085);
    return false;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(317106);
    JSONObject localJSONObject1 = super.toJson();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("face_model", this.eAs);
    localJSONObject2.put("alpha", Float.valueOf(this.alpha));
    localJSONObject2.put("path", this.path);
    localJSONObject1.put("params", localJSONObject2);
    AppMethodBeat.o(317106);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.f
 * JD-Core Version:    0.7.0.1
 */