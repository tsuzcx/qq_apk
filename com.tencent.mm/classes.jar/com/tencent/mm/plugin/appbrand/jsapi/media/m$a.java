package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$Capture;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "FRONT", "BACK", "Companion", "plugin-appbrand-integration_release"})
public enum m$a
  implements m.b
{
  public static final a hSD;
  private final int bsY;
  
  static
  {
    AppMethodBeat.i(143828);
    a locala1 = new a("FRONT", 0, 1);
    hSA = locala1;
    a locala2 = new a("BACK", 1, 2);
    hSB = locala2;
    hSC = new a[] { locala1, locala2 };
    hSD = new a((byte)0);
    AppMethodBeat.o(143828);
  }
  
  private m$a(int paramInt)
  {
    this.bsY = paramInt;
  }
  
  public final int aDR()
  {
    return this.bsY;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$Capture$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.m.a
 * JD-Core Version:    0.7.0.1
 */