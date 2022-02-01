package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$SourceType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "ALBUM", "CAMERA", "Companion", "plugin-appbrand-integration_release"})
public enum p$d
  implements p.b
{
  public static final a jYN;
  private final int dtM;
  
  static
  {
    AppMethodBeat.i(50576);
    d locald1 = new d("ALBUM", 0, 1);
    jYK = locald1;
    d locald2 = new d("CAMERA", 1, 2);
    jYL = locald2;
    jYM = new d[] { locald1, locald2 };
    jYN = new a((byte)0);
    AppMethodBeat.o(50576);
  }
  
  private p$d(int paramInt)
  {
    this.dtM = paramInt;
  }
  
  public final int getFlag()
  {
    return this.dtM;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$SourceType$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.p.d
 * JD-Core Version:    0.7.0.1
 */