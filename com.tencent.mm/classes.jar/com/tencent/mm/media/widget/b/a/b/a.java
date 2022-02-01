package com.tencent.mm.media.widget.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "", "()V", "KEY_CAMERAID", "", "getKEY_CAMERAID", "()Ljava/lang/String;", "KEY_PARENT", "getKEY_PARENT", "KEY_STREAM", "getKEY_STREAM", "KEY_VALUETYPE", "getKEY_VALUETYPE", "KEY_VENDORTAG", "getKEY_VENDORTAG", "TAG", "getTAG", "cameraId", "", "getCameraId", "()Ljava/lang/Integer;", "setCameraId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "parentKey", "getParentKey", "setParentKey", "(Ljava/lang/String;)V", "stream", "getStream", "setStream", "valueType", "getValueType", "setValueType", "vendorTag", "getVendorTag", "setVendorTag", "initEffectResultTag", "", "params", "Lorg/json/JSONObject;", "parseData", "plugin-mediaeditor_release"})
public final class a
{
  private final String TAG = "MicroMsg.WCCameraEffectResultTag";
  private final String haJ = "valueType";
  public String haK;
  private final String hah = "cameraId";
  private final String hai = "parentKey";
  private final String hak = "vendorTag";
  private final String ham = "stream";
  public String hao;
  public Integer hap;
  public String has;
  public Integer hat;
  
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
      if (k.g(str, this.hah)) {
        this.hap = Integer.valueOf(paramJSONObject.optInt(str));
      } else if (k.g(str, this.hai)) {
        this.hao = paramJSONObject.optString(str);
      } else if (k.g(str, this.hak)) {
        this.has = paramJSONObject.optString(str);
      } else if (k.g(str, this.ham)) {
        this.hat = Integer.valueOf(paramJSONObject.optInt(str));
      } else if (k.g(str, this.haJ)) {
        this.haK = paramJSONObject.optString(str);
      }
    }
    AppMethodBeat.o(94205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */