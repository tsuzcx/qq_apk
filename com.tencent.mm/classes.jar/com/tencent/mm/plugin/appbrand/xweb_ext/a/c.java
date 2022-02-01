package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenBlusherStickInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "faceModel", "", "getFaceModel", "()I", "setFaceModel", "(I)V", "isValid", "", "()Z", "leftBlusherPath", "", "getLeftBlusherPath", "()Ljava/lang/String;", "setLeftBlusherPath", "(Ljava/lang/String;)V", "rightBlusherPath", "getRightBlusherPath", "setRightBlusherPath", "type", "getType", "setType", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"})
public final class c
  extends a
{
  @SuppressLint({"Range"})
  float alpha = -1.0F;
  String cGE = "";
  String cGG = "";
  int cGI;
  int type;
  
  public final com.tencent.mm.sticker.a ay(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(282900);
    p.k(paramJSONObject, "jsonObj");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
    if (localJSONObject == null)
    {
      Log.w("MicroMsg.FlattenBlusherStickInfo", "fromJson, paramsJsonObj is null");
      paramJSONObject = super.ay(paramJSONObject);
      AppMethodBeat.o(282900);
      return paramJSONObject;
    }
    this.alpha = ((float)localJSONObject.optDouble("alpha", -1.0D));
    this.type = localJSONObject.optInt("blusher_type", 0);
    String str = localJSONObject.optString("left_path", "");
    p.j(str, "paramsJsonObj.optString(…EY_LEFT_BLUSHER_PATH, \"\")");
    this.cGE = str;
    str = localJSONObject.optString("right_path", "");
    p.j(str, "paramsJsonObj.optString(…Y_RIGHT_BLUSHER_PATH, \"\")");
    this.cGG = str;
    this.cGI = localJSONObject.optInt("face_model", 0);
    paramJSONObject = super.ay(paramJSONObject);
    AppMethodBeat.o(282900);
    return paramJSONObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(282899);
    if (-1.0F != this.alpha)
    {
      if (((CharSequence)this.cGE).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label74;
        }
        if (((CharSequence)this.cGG).length() <= 0) {
          break label69;
        }
      }
      label69:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label74;
        }
        AppMethodBeat.o(282899);
        return true;
        i = 0;
        break;
      }
    }
    label74:
    AppMethodBeat.o(282899);
    return false;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(282901);
    JSONObject localJSONObject1 = super.toJson();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("alpha", Float.valueOf(this.alpha));
    localJSONObject2.put("blusher_type", this.type);
    localJSONObject2.put("left_path", this.cGE);
    localJSONObject2.put("right_path", this.cGG);
    localJSONObject2.put("face_model", this.cGI);
    localJSONObject1.put("params", localJSONObject2);
    AppMethodBeat.o(282901);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.c
 * JD-Core Version:    0.7.0.1
 */