package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "", "detail", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "RAW_IMAGE", "THUMB_IMAGE", "V0_VIDEO", "V1_VIDEO", "V2_VIDEO", "V3_VIDEO", "V4_VIDEO", "V5_VIDEO", "V6_VIDEO", "V7_VIDEO", "V8_VIDEO", "V9_VIDEO", "V10_VIDEO", "V99_VIDEO", "FULL_PAG", "PREVIEW_PAG", "ORIGIN_AVATAR_IMAGE", "MEDIUM_AVATAR_IMAGE", "SMALL_AVATAR_IMAGE", "plugin-finder-base_release"})
public enum u
{
  public final String detail;
  
  static
  {
    AppMethodBeat.i(167027);
    u localu1 = new u("RAW_IMAGE", 0, "full_image");
    Aly = localu1;
    u localu2 = new u("THUMB_IMAGE", 1, "thumb_image");
    Alz = localu2;
    u localu3 = new u("V0_VIDEO", 2, "xV0");
    AlA = localu3;
    u localu4 = new u("V1_VIDEO", 3, "xV1");
    AlB = localu4;
    u localu5 = new u("V2_VIDEO", 4, "xV2");
    AlC = localu5;
    u localu6 = new u("V3_VIDEO", 5, "xV3");
    AlD = localu6;
    u localu7 = new u("V4_VIDEO", 6, "xV4");
    AlE = localu7;
    u localu8 = new u("V5_VIDEO", 7, "xV5");
    AlF = localu8;
    u localu9 = new u("V6_VIDEO", 8, "xV6");
    AlG = localu9;
    u localu10 = new u("V7_VIDEO", 9, "xV7");
    AlH = localu10;
    u localu11 = new u("V8_VIDEO", 10, "xV8");
    AlI = localu11;
    u localu12 = new u("V9_VIDEO", 11, "xV9");
    AlJ = localu12;
    u localu13 = new u("V10_VIDEO", 12, "xV10");
    AlK = localu13;
    u localu14 = new u("V99_VIDEO", 13, "xV99");
    AlL = localu14;
    u localu15 = new u("FULL_PAG", 14, "full_pag");
    AlM = localu15;
    u localu16 = new u("PREVIEW_PAG", 15, "preview_pag");
    AlN = localu16;
    u localu17 = new u("ORIGIN_AVATAR_IMAGE", 16, "/0");
    AlO = localu17;
    u localu18 = new u("MEDIUM_AVATAR_IMAGE", 17, "/132");
    AlP = localu18;
    u localu19 = new u("SMALL_AVATAR_IMAGE", 18, "/64");
    AlQ = localu19;
    AlR = new u[] { localu1, localu2, localu3, localu4, localu5, localu6, localu7, localu8, localu9, localu10, localu11, localu12, localu13, localu14, localu15, localu16, localu17, localu18, localu19 };
    AppMethodBeat.o(167027);
  }
  
  private u(String paramString)
  {
    this.detail = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.u
 * JD-Core Version:    0.7.0.1
 */