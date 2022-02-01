package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$SourceType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "ALBUM", "CAMERA", "Companion", "plugin-appbrand-integration_release"})
public enum q$d
  implements q.b
{
  public static final a kZr;
  private final int dEu;
  
  static
  {
    AppMethodBeat.i(50576);
    d locald1 = new d("ALBUM", 0, 1);
    kZo = locald1;
    d locald2 = new d("CAMERA", 1, 2);
    kZp = locald2;
    kZq = new d[] { locald1, locald2 };
    kZr = new a((byte)0);
    AppMethodBeat.o(50576);
  }
  
  private q$d(int paramInt)
  {
    this.dEu = paramInt;
  }
  
  public final int getFlag()
  {
    return this.dEu;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$SourceType$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.q.d
 * JD-Core Version:    0.7.0.1
 */