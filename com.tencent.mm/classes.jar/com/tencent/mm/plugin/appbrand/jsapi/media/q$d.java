package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$SourceType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "ALBUM", "CAMERA", "Companion", "plugin-appbrand-integration_release"})
public enum q$d
  implements q.b
{
  public static final a meE;
  private final int cSx;
  
  static
  {
    AppMethodBeat.i(50576);
    d locald1 = new d("ALBUM", 0, 1);
    meB = locald1;
    d locald2 = new d("CAMERA", 1, 2);
    meC = locald2;
    meD = new d[] { locald1, locald2 };
    meE = new a((byte)0);
    AppMethodBeat.o(50576);
  }
  
  private q$d(int paramInt)
  {
    this.cSx = paramInt;
  }
  
  public final int getFlag()
  {
    return this.cSx;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$SourceType$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.q.d
 * JD-Core Version:    0.7.0.1
 */