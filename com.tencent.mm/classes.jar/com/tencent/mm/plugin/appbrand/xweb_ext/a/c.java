package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/FlattenBlusherStickInfo;", "Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/BaseFlattenMakeupInfo;", "()V", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "faceModel", "", "getFaceModel", "()I", "setFaceModel", "(I)V", "isValid", "", "()Z", "leftBlusherPath", "", "getLeftBlusherPath", "()Ljava/lang/String;", "setLeftBlusherPath", "(Ljava/lang/String;)V", "rightBlusherPath", "getRightBlusherPath", "setRightBlusherPath", "type", "getType", "setType", "fromJson", "Lcom/tencent/mm/sticker/BaseJsonObject;", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-appbrand-integration_release"})
public final class c
  extends a
{
  @SuppressLint({"Range"})
  float alpha = -1.0F;
  String cFY = "";
  String cGa = "";
  int cGc;
  int type;
  
  public final com.tencent.mm.sticker.a au(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(229712);
    p.h(paramJSONObject, "jsonObj");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("params");
    if (localJSONObject == null)
    {
      Log.w("MicroMsg.FlattenBlusherStickInfo", "fromJson, paramsJsonObj is null");
      paramJSONObject = super.au(paramJSONObject);
      AppMethodBeat.o(229712);
      return paramJSONObject;
    }
    this.alpha = ((float)localJSONObject.optDouble("alpha", -1.0D));
    this.type = localJSONObject.optInt("blusher_type", 0);
    String str = localJSONObject.optString("left_path", "");
    p.g(str, "paramsJsonObj.optString(…EY_LEFT_BLUSHER_PATH, \"\")");
    this.cFY = str;
    str = localJSONObject.optString("right_path", "");
    p.g(str, "paramsJsonObj.optString(…Y_RIGHT_BLUSHER_PATH, \"\")");
    this.cGa = str;
    this.cGc = localJSONObject.optInt("face_model", 0);
    paramJSONObject = super.au(paramJSONObject);
    AppMethodBeat.o(229712);
    return paramJSONObject;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(229711);
    if (-1.0F != this.alpha)
    {
      if (((CharSequence)this.cFY).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label74;
        }
        if (((CharSequence)this.cGa).length() <= 0) {
          break label69;
        }
      }
      label69:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label74;
        }
        AppMethodBeat.o(229711);
        return true;
        i = 0;
        break;
      }
    }
    label74:
    AppMethodBeat.o(229711);
    return false;
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(229713);
    JSONObject localJSONObject1 = super.toJson();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("alpha", Float.valueOf(this.alpha));
    localJSONObject2.put("blusher_type", this.type);
    localJSONObject2.put("left_path", this.cFY);
    localJSONObject2.put("right_path", this.cGa);
    localJSONObject2.put("face_model", this.cGc);
    localJSONObject1.put("params", localJSONObject2);
    AppMethodBeat.o(229713);
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.a.c
 * JD-Core Version:    0.7.0.1
 */