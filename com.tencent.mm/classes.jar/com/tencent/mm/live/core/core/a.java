package com.tencent.mm.live.core.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/CdnQualityTag;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "CDN_QUALITY_HD", "CDN_QUALITY_SD1", "CDN_QUALITY_SD2", "CDN_QUALITY_SM", "CDN_QUALITY_SB", "CDN_QUALITY_HEVC", "CDN_QUALITY_AUTO_CLIQOS", "CDN_QUALITY_AUTO_SVRML", "plugin-core_release"})
public enum a
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(196385);
    a locala1 = new a("CDN_QUALITY_HD", 0, 0);
    hwx = locala1;
    a locala2 = new a("CDN_QUALITY_SD1", 1, 1);
    hwy = locala2;
    a locala3 = new a("CDN_QUALITY_SD2", 2, 2);
    hwz = locala3;
    a locala4 = new a("CDN_QUALITY_SM", 3, 3);
    hwA = locala4;
    a locala5 = new a("CDN_QUALITY_SB", 4, 4);
    hwB = locala5;
    a locala6 = new a("CDN_QUALITY_HEVC", 5, 5);
    hwC = locala6;
    a locala7 = new a("CDN_QUALITY_AUTO_CLIQOS", 6, 101);
    hwD = locala7;
    a locala8 = new a("CDN_QUALITY_AUTO_SVRML", 7, 102);
    hwE = locala8;
    hwF = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8 };
    AppMethodBeat.o(196385);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a
 * JD-Core Version:    0.7.0.1
 */