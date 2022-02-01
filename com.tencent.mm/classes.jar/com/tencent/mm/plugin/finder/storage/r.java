package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "", "detail", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "FULL_IMAGE", "THUMB_IMAGE", "V0_VIDEO", "V1_VIDEO", "V2_VIDEO", "V3_VIDEO", "V4_VIDEO", "V5_VIDEO", "V6_VIDEO", "V7_VIDEO", "V8_VIDEO", "V9_VIDEO", "V10_VIDEO", "V99_VIDEO", "plugin-finder_release"})
public enum r
{
  public final String detail;
  
  static
  {
    AppMethodBeat.i(167027);
    r localr1 = new r("FULL_IMAGE", 0, "full_image");
    syD = localr1;
    r localr2 = new r("THUMB_IMAGE", 1, "thumb_image");
    syE = localr2;
    r localr3 = new r("V0_VIDEO", 2, "xV0");
    syF = localr3;
    r localr4 = new r("V1_VIDEO", 3, "xV1");
    syG = localr4;
    r localr5 = new r("V2_VIDEO", 4, "xV2");
    syH = localr5;
    r localr6 = new r("V3_VIDEO", 5, "xV3");
    syI = localr6;
    r localr7 = new r("V4_VIDEO", 6, "xV4");
    syJ = localr7;
    r localr8 = new r("V5_VIDEO", 7, "xV5");
    syK = localr8;
    r localr9 = new r("V6_VIDEO", 8, "xV6");
    syL = localr9;
    r localr10 = new r("V7_VIDEO", 9, "xV7");
    syM = localr10;
    r localr11 = new r("V8_VIDEO", 10, "xV8");
    syN = localr11;
    r localr12 = new r("V9_VIDEO", 11, "xV9");
    syO = localr12;
    r localr13 = new r("V10_VIDEO", 12, "xV10");
    syP = localr13;
    r localr14 = new r("V99_VIDEO", 13, "xV99");
    syQ = localr14;
    syR = new r[] { localr1, localr2, localr3, localr4, localr5, localr6, localr7, localr8, localr9, localr10, localr11, localr12, localr13, localr14 };
    AppMethodBeat.o(167027);
  }
  
  private r(String paramString)
  {
    this.detail = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.r
 * JD-Core Version:    0.7.0.1
 */