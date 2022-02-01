package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenLipStickInfoV2;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "colorB", "", "getColorB", "()I", "setColorB", "(I)V", "colorG", "getColorG", "setColorG", "colorR", "getColorR", "setColorR", "faceModel", "getFaceModel", "setFaceModel", "isValid", "", "()Z", "lipStickType", "getLipStickType", "setLipStickType", "mouthShape", "getMouthShape", "setMouthShape", "type", "", "getType", "()Ljava/lang/String;", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  float alpha = -1.0F;
  int eAs;
  int eBa = -1;
  int eBb = -1;
  int eBc = -1;
  private final String type = "LipStickV2";
  int uTS;
  int uTT;
  
  public final com.tencent.mm.sticker.a G(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(317113);
    s.u(paramJSONObject, "jsonObj");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
    if (localJSONObject == null)
    {
      Log.w("MicroMsg.FlattenLipStickInfo", "fromJson, paramsJsonObj is null");
      paramJSONObject = super.G(paramJSONObject);
      AppMethodBeat.o(317113);
      return paramJSONObject;
    }
    this.alpha = ((float)localJSONObject.optDouble("alpha", -1.0D));
    JSONArray localJSONArray1 = localJSONObject.optJSONArray("color");
    if ((localJSONArray1 != null) && (1 <= localJSONArray1.length()))
    {
      JSONArray localJSONArray2 = localJSONArray1.getJSONArray(0);
      if ((localJSONArray2 != null) && (3 == localJSONArray1.length()))
      {
        this.eBa = localJSONArray2.optInt(0, -1);
        this.eBb = localJSONArray2.optInt(1, -1);
        this.eBc = localJSONArray2.optInt(2, -1);
      }
    }
    for (;;)
    {
      this.uTS = localJSONObject.optInt("lipstick_type", 0);
      this.eAs = localJSONObject.optInt("face_model", 0);
      this.uTT = localJSONObject.optInt("mouth_shape", 0);
      paramJSONObject = super.G(paramJSONObject);
      AppMethodBeat.o(317113);
      return paramJSONObject;
      Log.w("MicroMsg.FlattenLipStickInfo", "fromJson, colorJsonArr is illegal");
      continue;
      Log.w("MicroMsg.FlattenLipStickInfo", "fromJson, colorJsonArr2d is illegal");
    }
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public final boolean isValid()
  {
    if (-1.0F == this.alpha) {}
    for (int i = 1; (i == 0) && (-1 != this.eBa) && (-1 != this.eBb) && (-1 != this.eBc); i = 0) {
      return true;
    }
    return false;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(317128);
    JSONObject localJSONObject1 = super.toJson();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("alpha", Float.valueOf(this.alpha));
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    localJSONArray2.put(this.eBa);
    localJSONArray2.put(this.eBb);
    localJSONArray2.put(this.eBc);
    ah localah = ah.aiuX;
    localJSONArray1.put(localJSONArray2);
    localJSONObject2.put("color", localJSONArray1);
    localJSONObject2.put("lipstick_type", this.uTS);
    localJSONObject2.put("face_model", this.eAs);
    localJSONObject2.put("mouth_shape", this.uTT);
    localJSONObject1.put("params", localJSONObject2);
    AppMethodBeat.o(317128);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.g
 * JD-Core Version:    0.7.0.1
 */