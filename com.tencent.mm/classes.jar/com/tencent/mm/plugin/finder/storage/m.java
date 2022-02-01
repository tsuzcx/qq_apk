package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "", "detail", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "FULL_IMAGE", "THUMB_IMAGE", "V0_VIDEO", "V1_VIDEO", "V2_VIDEO", "V3_VIDEO", "V4_VIDEO", "V5_VIDEO", "V6_VIDEO", "V7_VIDEO", "V8_VIDEO", "V9_VIDEO", "V10_VIDEO", "V99_VIDEO", "plugin-finder_release"})
public enum m
{
  public final String detail;
  
  static
  {
    AppMethodBeat.i(167027);
    m localm1 = new m("FULL_IMAGE", 0, "full_image");
    rDQ = localm1;
    m localm2 = new m("THUMB_IMAGE", 1, "thumb_image");
    rDR = localm2;
    m localm3 = new m("V0_VIDEO", 2, "xV0");
    rDS = localm3;
    m localm4 = new m("V1_VIDEO", 3, "xV1");
    rDT = localm4;
    m localm5 = new m("V2_VIDEO", 4, "xV2");
    rDU = localm5;
    m localm6 = new m("V3_VIDEO", 5, "xV3");
    rDV = localm6;
    m localm7 = new m("V4_VIDEO", 6, "xV4");
    rDW = localm7;
    m localm8 = new m("V5_VIDEO", 7, "xV5");
    rDX = localm8;
    m localm9 = new m("V6_VIDEO", 8, "xV6");
    rDY = localm9;
    m localm10 = new m("V7_VIDEO", 9, "xV7");
    rDZ = localm10;
    m localm11 = new m("V8_VIDEO", 10, "xV8");
    rEa = localm11;
    m localm12 = new m("V9_VIDEO", 11, "xV9");
    rEb = localm12;
    m localm13 = new m("V10_VIDEO", 12, "xV10");
    rEc = localm13;
    m localm14 = new m("V99_VIDEO", 13, "xV99");
    rEd = localm14;
    rEe = new m[] { localm1, localm2, localm3, localm4, localm5, localm6, localm7, localm8, localm9, localm10, localm11, localm12, localm13, localm14 };
    AppMethodBeat.o(167027);
  }
  
  private m(String paramString)
  {
    this.detail = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.m
 * JD-Core Version:    0.7.0.1
 */