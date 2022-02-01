package com.tencent.mm.media.widget.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "", "()V", "KEY_CAMERAID", "", "getKEY_CAMERAID", "()Ljava/lang/String;", "KEY_PARENT", "getKEY_PARENT", "KEY_STREAM", "getKEY_STREAM", "KEY_VALUETYPE", "getKEY_VALUETYPE", "KEY_VENDORTAG", "getKEY_VENDORTAG", "TAG", "getTAG", "cameraId", "", "getCameraId", "()Ljava/lang/Integer;", "setCameraId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "parentKey", "getParentKey", "setParentKey", "(Ljava/lang/String;)V", "stream", "getStream", "setStream", "valueType", "getValueType", "setValueType", "vendorTag", "getVendorTag", "setVendorTag", "initEffectResultTag", "", "params", "Lorg/json/JSONObject;", "parseData", "plugin-mediaeditor_release"})
public final class a
{
  private final String TAG = "MicroMsg.WCCameraEffectResultTag";
  private final String ioC = "cameraId";
  private final String ioD = "parentKey";
  private final String ioF = "vendorTag";
  private final String ioH = "stream";
  public String ioJ;
  public Integer ioK;
  public String ioN;
  public Integer ioO;
  private final String ipe = "valueType";
  public String ipf;
  
  public final void t(JSONObject paramJSONObject)
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
      if (p.j(str, this.ioC)) {
        this.ioK = Integer.valueOf(paramJSONObject.optInt(str));
      } else if (p.j(str, this.ioD)) {
        this.ioJ = paramJSONObject.optString(str);
      } else if (p.j(str, this.ioF)) {
        this.ioN = paramJSONObject.optString(str);
      } else if (p.j(str, this.ioH)) {
        this.ioO = Integer.valueOf(paramJSONObject.optInt(str));
      } else if (p.j(str, this.ipe)) {
        this.ipf = paramJSONObject.optString(str);
      }
    }
    AppMethodBeat.o(94205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */