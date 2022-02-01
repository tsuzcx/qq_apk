package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "IMAGE", "VIDEO", "Companion", "plugin-appbrand-integration_release"})
public enum q$c
  implements q.b
{
  public static final a kVF;
  final int dDp;
  
  static
  {
    AppMethodBeat.i(50572);
    c localc1 = new c("IMAGE", 0, 1);
    kVC = localc1;
    c localc2 = new c("VIDEO", 1, 2);
    kVD = localc2;
    kVE = new c[] { localc1, localc2 };
    kVF = new a((byte)0);
    AppMethodBeat.o(50572);
  }
  
  private q$c(int paramInt)
  {
    this.dDp = paramInt;
  }
  
  public final int getFlag()
  {
    return this.dDp;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaType$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.q.c
 * JD-Core Version:    0.7.0.1
 */