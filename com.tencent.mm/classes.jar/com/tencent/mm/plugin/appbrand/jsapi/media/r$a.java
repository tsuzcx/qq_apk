package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$Capture;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "FRONT", "BACK", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum r$a
  implements r.b
{
  public static final a shx;
  private final int eQp;
  
  static
  {
    AppMethodBeat.i(50565);
    shy = new a("FRONT", 0, 1);
    shz = new a("BACK", 1, 2);
    shA = new a[] { shy, shz };
    shx = new a((byte)0);
    AppMethodBeat.o(50565);
  }
  
  private r$a(int paramInt)
  {
    this.eQp = paramInt;
  }
  
  public final int getFlag()
  {
    return this.eQp;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$Capture$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.r.a
 * JD-Core Version:    0.7.0.1
 */