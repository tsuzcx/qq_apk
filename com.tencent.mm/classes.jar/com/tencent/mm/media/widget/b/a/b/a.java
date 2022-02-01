package com.tencent.mm.media.widget.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "", "()V", "KEY_CAMERAID", "", "getKEY_CAMERAID", "()Ljava/lang/String;", "KEY_PARENT", "getKEY_PARENT", "KEY_STREAM", "getKEY_STREAM", "KEY_VALUETYPE", "getKEY_VALUETYPE", "KEY_VENDORTAG", "getKEY_VENDORTAG", "TAG", "getTAG", "cameraId", "", "getCameraId", "()Ljava/lang/Integer;", "setCameraId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "parentKey", "getParentKey", "setParentKey", "(Ljava/lang/String;)V", "stream", "getStream", "setStream", "valueType", "getValueType", "setValueType", "vendorTag", "getVendorTag", "setVendorTag", "initEffectResultTag", "", "params", "Lorg/json/JSONObject;", "parseData", "plugin-mediaeditor_release"})
public final class a
{
  private final String TAG = "MicroMsg.WCCameraEffectResultTag";
  private final String gAm = "valueType";
  public String gAn;
  private final String gzK = "cameraId";
  private final String gzL = "parentKey";
  private final String gzN = "vendorTag";
  private final String gzP = "stream";
  public String gzR;
  public Integer gzS;
  public String gzV;
  public Integer gzW;
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(94205);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(94205);
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    k.g(localIterator, "params.keys()");
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (k.g(str, this.gzK)) {
        this.gzS = Integer.valueOf(paramJSONObject.optInt(str));
      } else if (k.g(str, this.gzL)) {
        this.gzR = paramJSONObject.optString(str);
      } else if (k.g(str, this.gzN)) {
        this.gzV = paramJSONObject.optString(str);
      } else if (k.g(str, this.gzP)) {
        this.gzW = Integer.valueOf(paramJSONObject.optInt(str));
      } else if (k.g(str, this.gAm)) {
        this.gAn = paramJSONObject.optString(str);
      }
    }
    AppMethodBeat.o(94205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */