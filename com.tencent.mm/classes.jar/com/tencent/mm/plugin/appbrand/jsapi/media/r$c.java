package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "IMAGE", "VIDEO", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum r$c
  implements r.b
{
  public static final a shD;
  final int eQp;
  
  static
  {
    AppMethodBeat.i(50572);
    shE = new c("IMAGE", 0, 1);
    shF = new c("VIDEO", 1, 2);
    shG = new c[] { shE, shF };
    shD = new a((byte)0);
    AppMethodBeat.o(50572);
  }
  
  private r$c(int paramInt)
  {
    this.eQp = paramInt;
  }
  
  public final int getFlag()
  {
    return this.eQp;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaType$Companion;", "", "()V", "parse", "", "json", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.r.c
 * JD-Core Version:    0.7.0.1
 */