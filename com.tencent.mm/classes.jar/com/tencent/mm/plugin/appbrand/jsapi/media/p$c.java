package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "IMAGE", "VIDEO", "Companion", "plugin-appbrand-integration_release"})
public enum p$c
  implements p.b
{
  public static final a kzv;
  final int drx;
  
  static
  {
    AppMethodBeat.i(50572);
    c localc1 = new c("IMAGE", 0, 1);
    kzs = localc1;
    c localc2 = new c("VIDEO", 1, 2);
    kzt = localc2;
    kzu = new c[] { localc1, localc2 };
    kzv = new a((byte)0);
    AppMethodBeat.o(50572);
  }
  
  private p$c(int paramInt)
  {
    this.drx = paramInt;
  }
  
  public final int getFlag()
  {
    return this.drx;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaType$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.p.c
 * JD-Core Version:    0.7.0.1
 */