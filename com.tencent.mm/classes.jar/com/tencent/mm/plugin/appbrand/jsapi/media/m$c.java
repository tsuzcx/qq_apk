package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "IMAGE", "VIDEO", "Companion", "plugin-appbrand-integration_release"})
public enum m$c
  implements m.b
{
  public static final m.c.a hSJ;
  final int bsY;
  
  static
  {
    AppMethodBeat.i(143835);
    c localc1 = new c("IMAGE", 0, 1);
    hSG = localc1;
    c localc2 = new c("VIDEO", 1, 2);
    hSH = localc2;
    hSI = new c[] { localc1, localc2 };
    hSJ = new m.c.a((byte)0);
    AppMethodBeat.o(143835);
  }
  
  private m$c(int paramInt)
  {
    this.bsY = paramInt;
  }
  
  public final int aDR()
  {
    return this.bsY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.m.c
 * JD-Core Version:    0.7.0.1
 */