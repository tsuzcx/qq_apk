package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "", "detail", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "RAW_IMAGE", "THUMB_IMAGE", "V0_VIDEO", "V1_VIDEO", "V2_VIDEO", "V3_VIDEO", "V4_VIDEO", "V5_VIDEO", "V6_VIDEO", "V7_VIDEO", "V8_VIDEO", "V9_VIDEO", "V10_VIDEO", "V12_VIDEO", "V0_SDR_VIDEO", "H0_VIDEO", "H1_VIDEO", "H2_VIDEO", "H3_VIDEO", "H4_VIDEO", "H5_VIDEO", "H6_VIDEO", "H7_VIDEO", "H8_VIDEO", "H9_VIDEO", "H10_VIDEO", "H12_VIDEO", "V2_DOLBY_HDR", "V2_HDR_10", "V99_VIDEO", "FULL_PAG", "PREVIEW_PAG", "ORIGIN_AVATAR_IMAGE", "MEDIUM_AVATAR_IMAGE", "SMALL_AVATAR_IMAGE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum v
{
  public final String detail;
  
  static
  {
    AppMethodBeat.i(167027);
    FKY = new v("RAW_IMAGE", 0, "full_image");
    FKZ = new v("THUMB_IMAGE", 1, "thumb_image");
    FLa = new v("V0_VIDEO", 2, "xV0");
    FLb = new v("V1_VIDEO", 3, "xV1");
    FLc = new v("V2_VIDEO", 4, "xV2");
    FLd = new v("V3_VIDEO", 5, "xV3");
    FLe = new v("V4_VIDEO", 6, "xV4");
    FLf = new v("V5_VIDEO", 7, "xV5");
    FLg = new v("V6_VIDEO", 8, "xV6");
    FLh = new v("V7_VIDEO", 9, "xV7");
    FLi = new v("V8_VIDEO", 10, "xV8");
    FLj = new v("V9_VIDEO", 11, "xV9");
    FLk = new v("V10_VIDEO", 12, "xV10");
    FLl = new v("V12_VIDEO", 13, "xV12");
    FLm = new v("V0_SDR_VIDEO", 14, "xV0-Sdr");
    FLn = new v("H0_VIDEO", 15, "H0");
    FLo = new v("H1_VIDEO", 16, "H1");
    FLp = new v("H2_VIDEO", 17, "H2");
    FLq = new v("H3_VIDEO", 18, "H3");
    FLr = new v("H4_VIDEO", 19, "H4");
    FLs = new v("H5_VIDEO", 20, "H5");
    FLt = new v("H6_VIDEO", 21, "H6");
    FLu = new v("H7_VIDEO", 22, "H7");
    FLv = new v("H8_VIDEO", 23, "H8");
    FLw = new v("H9_VIDEO", 24, "H9");
    FLx = new v("H10_VIDEO", 25, "H10");
    FLy = new v("H12_VIDEO", 26, "H12");
    FLz = new v("V2_DOLBY_HDR", 27, "V2-DolbyHdr");
    FLA = new v("V2_HDR_10", 28, "V2-Hdr10");
    FLB = new v("V99_VIDEO", 29, "xV99");
    FLC = new v("FULL_PAG", 30, "full_pag");
    FLD = new v("PREVIEW_PAG", 31, "preview_pag");
    FLE = new v("ORIGIN_AVATAR_IMAGE", 32, "/0");
    FLF = new v("MEDIUM_AVATAR_IMAGE", 33, "/132");
    FLG = new v("SMALL_AVATAR_IMAGE", 34, "/64");
    FLH = new v[] { FKY, FKZ, FLa, FLb, FLc, FLd, FLe, FLf, FLg, FLh, FLi, FLj, FLk, FLl, FLm, FLn, FLo, FLp, FLq, FLr, FLs, FLt, FLu, FLv, FLw, FLx, FLy, FLz, FLA, FLB, FLC, FLD, FLE, FLF, FLG };
    AppMethodBeat.o(167027);
  }
  
  private v(String paramString)
  {
    this.detail = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.v
 * JD-Core Version:    0.7.0.1
 */