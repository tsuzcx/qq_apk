package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "", "detail", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "FULL_IMAGE", "THUMB_IMAGE", "V0_VIDEO", "V1_VIDEO", "V2_VIDEO", "V3_VIDEO", "V4_VIDEO", "V5_VIDEO", "V6_VIDEO", "V7_VIDEO", "V8_VIDEO", "V9_VIDEO", "V10_VIDEO", "V99_VIDEO", "plugin-finder_release"})
public enum h
{
  public final String detail;
  
  static
  {
    AppMethodBeat.i(167027);
    h localh1 = new h("FULL_IMAGE", 0, "full_image");
    qJY = localh1;
    h localh2 = new h("THUMB_IMAGE", 1, "thumb_image");
    qJZ = localh2;
    h localh3 = new h("V0_VIDEO", 2, "xV0");
    KWP = localh3;
    h localh4 = new h("V1_VIDEO", 3, "xV1");
    KWQ = localh4;
    h localh5 = new h("V2_VIDEO", 4, "xV2");
    KWR = localh5;
    h localh6 = new h("V3_VIDEO", 5, "xV3");
    KWS = localh6;
    h localh7 = new h("V4_VIDEO", 6, "xV4");
    KWT = localh7;
    h localh8 = new h("V5_VIDEO", 7, "xV5");
    KWU = localh8;
    h localh9 = new h("V6_VIDEO", 8, "xV6");
    KWV = localh9;
    h localh10 = new h("V7_VIDEO", 9, "xV7");
    KWW = localh10;
    h localh11 = new h("V8_VIDEO", 10, "xV8");
    KWX = localh11;
    h localh12 = new h("V9_VIDEO", 11, "xV9");
    KWY = localh12;
    h localh13 = new h("V10_VIDEO", 12, "xV10");
    KWZ = localh13;
    h localh14 = new h("V99_VIDEO", 13, "xV99");
    KXa = localh14;
    qKb = new h[] { localh1, localh2, localh3, localh4, localh5, localh6, localh7, localh8, localh9, localh10, localh11, localh12, localh13, localh14 };
    AppMethodBeat.o(167027);
  }
  
  private h(String paramString)
  {
    this.detail = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.h
 * JD-Core Version:    0.7.0.1
 */