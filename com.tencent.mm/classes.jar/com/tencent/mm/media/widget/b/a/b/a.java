package com.tencent.mm.media.widget.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "", "()V", "KEY_CAMERAID", "", "getKEY_CAMERAID", "()Ljava/lang/String;", "KEY_PARENT", "getKEY_PARENT", "KEY_STREAM", "getKEY_STREAM", "KEY_VALUETYPE", "getKEY_VALUETYPE", "KEY_VENDORTAG", "getKEY_VENDORTAG", "TAG", "getTAG", "cameraId", "", "getCameraId", "()Ljava/lang/Integer;", "setCameraId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "parentKey", "getParentKey", "setParentKey", "(Ljava/lang/String;)V", "stream", "getStream", "setStream", "valueType", "getValueType", "setValueType", "vendorTag", "getVendorTag", "setVendorTag", "initEffectResultTag", "", "params", "Lorg/json/JSONObject;", "parseData", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private final String TAG = "MicroMsg.WCCameraEffectResultTag";
  public String nIC;
  public Integer nID;
  private final String nIT = "valueType";
  public String nIU;
  private final String nIr = "cameraId";
  private final String nIs = "parentKey";
  private final String nIu = "vendorTag";
  private final String nIw = "stream";
  public String nIy;
  public Integer nIz;
  
  public final void E(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(94205);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(94205);
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    s.s(localIterator, "params.keys()");
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (s.p(str, this.nIr)) {
        this.nIz = Integer.valueOf(paramJSONObject.optInt(str));
      } else if (s.p(str, this.nIs)) {
        this.nIy = paramJSONObject.optString(str);
      } else if (s.p(str, this.nIu)) {
        this.nIC = paramJSONObject.optString(str);
      } else if (s.p(str, this.nIw)) {
        this.nID = Integer.valueOf(paramJSONObject.optInt(str));
      } else if (s.p(str, this.nIT)) {
        this.nIU = paramJSONObject.optString(str);
      }
    }
    AppMethodBeat.o(94205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */