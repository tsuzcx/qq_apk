package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "IMAGE", "VIDEO", "Companion", "plugin-appbrand-integration_release"})
public enum p$c
  implements p.b
{
  public static final a jYJ;
  final int dtM;
  
  static
  {
    AppMethodBeat.i(50572);
    c localc1 = new c("IMAGE", 0, 1);
    jYG = localc1;
    c localc2 = new c("VIDEO", 1, 2);
    jYH = localc2;
    jYI = new c[] { localc1, localc2 };
    jYJ = new a((byte)0);
    AppMethodBeat.o(50572);
  }
  
  private p$c(int paramInt)
  {
    this.dtM = paramInt;
  }
  
  public final int getFlag()
  {
    return this.dtM;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaType$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.p.c
 * JD-Core Version:    0.7.0.1
 */