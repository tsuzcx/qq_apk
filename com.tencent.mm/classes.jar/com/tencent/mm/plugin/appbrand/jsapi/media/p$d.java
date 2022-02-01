package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$SourceType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "ALBUM", "CAMERA", "Companion", "plugin-appbrand-integration_release"})
public enum p$d
  implements p.b
{
  public static final a kzz;
  private final int drx;
  
  static
  {
    AppMethodBeat.i(50576);
    d locald1 = new d("ALBUM", 0, 1);
    kzw = locald1;
    d locald2 = new d("CAMERA", 1, 2);
    kzx = locald2;
    kzy = new d[] { locald1, locald2 };
    kzz = new a((byte)0);
    AppMethodBeat.o(50576);
  }
  
  private p$d(int paramInt)
  {
    this.drx = paramInt;
  }
  
  public final int getFlag()
  {
    return this.drx;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$SourceType$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.p.d
 * JD-Core Version:    0.7.0.1
 */