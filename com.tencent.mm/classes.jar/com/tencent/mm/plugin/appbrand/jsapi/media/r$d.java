package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$SourceType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "ALBUM", "CAMERA", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum r$d
  implements r.b
{
  public static final a shH;
  private final int eQp;
  
  static
  {
    AppMethodBeat.i(50576);
    shI = new d("ALBUM", 0, 1);
    shJ = new d("CAMERA", 1, 2);
    shK = new d[] { shI, shJ };
    shH = new a((byte)0);
    AppMethodBeat.o(50576);
  }
  
  private r$d(int paramInt)
  {
    this.eQp = paramInt;
  }
  
  public final int getFlag()
  {
    return this.eQp;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$SourceType$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.r.d
 * JD-Core Version:    0.7.0.1
 */