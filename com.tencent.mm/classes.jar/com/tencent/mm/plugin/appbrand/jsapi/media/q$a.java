package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$Capture;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "FRONT", "BACK", "Companion", "plugin-appbrand-integration_release"})
public enum q$a
  implements q.b
{
  public static final a kVz;
  private final int dDp;
  
  static
  {
    AppMethodBeat.i(50565);
    a locala1 = new a("FRONT", 0, 1);
    kVw = locala1;
    a locala2 = new a("BACK", 1, 2);
    kVx = locala2;
    kVy = new a[] { locala1, locala2 };
    kVz = new a((byte)0);
    AppMethodBeat.o(50565);
  }
  
  private q$a(int paramInt)
  {
    this.dDp = paramInt;
  }
  
  public final int getFlag()
  {
    return this.dDp;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$Capture$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.q.a
 * JD-Core Version:    0.7.0.1
 */