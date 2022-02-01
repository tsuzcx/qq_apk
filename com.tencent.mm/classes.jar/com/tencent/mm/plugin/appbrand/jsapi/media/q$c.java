package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "IMAGE", "VIDEO", "Companion", "plugin-appbrand-integration_release"})
public enum q$c
  implements q.b
{
  public static final a kZn;
  final int dEu;
  
  static
  {
    AppMethodBeat.i(50572);
    c localc1 = new c("IMAGE", 0, 1);
    kZk = localc1;
    c localc2 = new c("VIDEO", 1, 2);
    kZl = localc2;
    kZm = new c[] { localc1, localc2 };
    kZn = new a((byte)0);
    AppMethodBeat.o(50572);
  }
  
  private q$c(int paramInt)
  {
    this.dEu = paramInt;
  }
  
  public final int getFlag()
  {
    return this.dEu;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaType$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.q.c
 * JD-Core Version:    0.7.0.1
 */