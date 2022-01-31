package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$SourceType;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/MediaConstants$MediaEnum;", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "ALBUM", "CAMERA", "Companion", "plugin-appbrand-integration_release"})
public enum m$d
  implements m.b
{
  public static final m.d.a hSN;
  private final int bsY;
  
  static
  {
    AppMethodBeat.i(143839);
    d locald1 = new d("ALBUM", 0, 1);
    hSK = locald1;
    d locald2 = new d("CAMERA", 1, 2);
    hSL = locald2;
    hSM = new d[] { locald1, locald2 };
    hSN = new m.d.a((byte)0);
    AppMethodBeat.o(143839);
  }
  
  private m$d(int paramInt)
  {
    this.bsY = paramInt;
  }
  
  public final int aDR()
  {
    return this.bsY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.m.d
 * JD-Core Version:    0.7.0.1
 */