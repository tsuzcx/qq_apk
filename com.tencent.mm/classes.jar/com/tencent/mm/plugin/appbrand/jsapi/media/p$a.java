package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$Capture;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "FRONT", "BACK", "Companion", "plugin-appbrand-integration_release"})
public enum p$a
  implements p.b
{
  public static final a jYD;
  private final int dtM;
  
  static
  {
    AppMethodBeat.i(50565);
    a locala1 = new a("FRONT", 0, 1);
    jYA = locala1;
    a locala2 = new a("BACK", 1, 2);
    jYB = locala2;
    jYC = new a[] { locala1, locala2 };
    jYD = new a((byte)0);
    AppMethodBeat.o(50565);
  }
  
  private p$a(int paramInt)
  {
    this.dtM = paramInt;
  }
  
  public final int getFlag()
  {
    return this.dtM;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$Capture$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.p.a
 * JD-Core Version:    0.7.0.1
 */