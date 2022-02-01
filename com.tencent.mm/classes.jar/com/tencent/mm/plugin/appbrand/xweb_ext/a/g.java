package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenLipStickInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "colorB", "", "getColorB", "()I", "setColorB", "(I)V", "colorG", "getColorG", "setColorG", "colorR", "getColorR", "setColorR", "faceModel", "getFaceModel", "setFaceModel", "isValid", "", "()Z", "mouthShape", "getMouthShape", "setMouthShape", "type", "getType", "setType", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"})
public final class g
  extends a
{
  @SuppressLint({"Range"})
  float alpha = -1.0F;
  @SuppressLint({"Range"})
  int cGX = -1;
  @SuppressLint({"Range"})
  int cGY = -1;
  @SuppressLint({"Range"})
  int cGZ = -1;
  int cGc;
  int oGM;
  int type;
  
  public final com.tencent.mm.sticker.a au(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(229723);
    p.h(paramJSONObject, "jsonObj");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
    if (localJSONObject == null)
    {
      Log.w("MicroMsg.FlattenLipStickInfo", "fromJson, paramsJsonObj is null");
      paramJSONObject = super.au(paramJSONObject);
      AppMethodBeat.o(229723);
      return paramJSONObject;
    }
    this.alpha = ((float)localJSONObject.optDouble("alpha", -1.0D));
    JSONArray localJSONArray1 = localJSONObject.optJSONArray("color");
    if ((localJSONArray1 != null) && (1 <= localJSONArray1.length()))
    {
      JSONArray localJSONArray2 = localJSONArray1.getJSONArray(0);
      if ((localJSONArray2 != null) && (3 == localJSONArray1.length()))
      {
        this.cGX = localJSONArray2.optInt(0, -1);
        this.cGY = localJSONArray2.optInt(1, -1);
        this.cGZ = localJSONArray2.optInt(2, -1);
      }
    }
    for (;;)
    {
      this.type = localJSONObject.optInt("lipstick_type", 0);
      this.cGc = localJSONObject.optInt("face_model", 0);
      this.oGM = localJSONObject.optInt("mouth_shape", 0);
      paramJSONObject = super.au(paramJSONObject);
      AppMethodBeat.o(229723);
      return paramJSONObject;
      Log.w("MicroMsg.FlattenLipStickInfo", "fromJson, colorJsonArr is illegal");
      continue;
      Log.w("MicroMsg.FlattenLipStickInfo", "fromJson, colorJsonArr2d is illegal");
    }
  }
  
  public final boolean isValid()
  {
    return (-1.0F != this.alpha) && (-1 != this.cGX) && (-1 != this.cGY) && (-1 != this.cGZ);
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(229724);
    JSONObject localJSONObject1 = super.toJson();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("alpha", Float.valueOf(this.alpha));
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    localJSONArray2.put(this.cGX);
    localJSONArray2.put(this.cGY);
    localJSONArray2.put(this.cGZ);
    localJSONArray1.put(localJSONArray2);
    localJSONObject2.put("color", localJSONArray1);
    localJSONObject2.put("lipstick_type", this.type);
    localJSONObject2.put("face_model", this.cGc);
    localJSONObject2.put("mouth_shape", this.oGM);
    localJSONObject1.put("params", localJSONObject2);
    AppMethodBeat.o(229724);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.g
 * JD-Core Version:    0.7.0.1
 */