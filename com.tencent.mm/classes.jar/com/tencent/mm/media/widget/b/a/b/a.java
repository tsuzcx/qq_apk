package com.tencent.mm.media.widget.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "", "()V", "KEY_CAMERAID", "", "getKEY_CAMERAID", "()Ljava/lang/String;", "KEY_PARENT", "getKEY_PARENT", "KEY_STREAM", "getKEY_STREAM", "KEY_VALUETYPE", "getKEY_VALUETYPE", "KEY_VENDORTAG", "getKEY_VENDORTAG", "TAG", "getTAG", "cameraId", "", "getCameraId", "()Ljava/lang/Integer;", "setCameraId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "parentKey", "getParentKey", "setParentKey", "(Ljava/lang/String;)V", "stream", "getStream", "setStream", "valueType", "getValueType", "setValueType", "vendorTag", "getVendorTag", "setVendorTag", "initEffectResultTag", "", "params", "Lorg/json/JSONObject;", "parseData", "plugin-mediaeditor_release"})
public final class a
{
  private final String TAG = "MicroMsg.WCCameraEffectResultTag";
  private final String hvD = "valueType";
  public String hvE;
  private final String hvb = "cameraId";
  private final String hvc = "parentKey";
  private final String hve = "vendorTag";
  private final String hvg = "stream";
  public String hvi;
  public Integer hvj;
  public String hvm;
  public Integer hvn;
  
  public final void p(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(94205);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(94205);
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    p.g(localIterator, "params.keys()");
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (p.i(str, this.hvb)) {
        this.hvj = Integer.valueOf(paramJSONObject.optInt(str));
      } else if (p.i(str, this.hvc)) {
        this.hvi = paramJSONObject.optString(str);
      } else if (p.i(str, this.hve)) {
        this.hvm = paramJSONObject.optString(str);
      } else if (p.i(str, this.hvg)) {
        this.hvn = Integer.valueOf(paramJSONObject.optInt(str));
      } else if (p.i(str, this.hvD)) {
        this.hvE = paramJSONObject.optString(str);
      }
    }
    AppMethodBeat.o(94205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */