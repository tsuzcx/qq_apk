package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "", "detail", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "FULL_IMAGE", "THUMB_IMAGE", "V0_VIDEO", "V1_VIDEO", "V2_VIDEO", "V3_VIDEO", "V4_VIDEO", "V5_VIDEO", "V6_VIDEO", "V7_VIDEO", "V8_VIDEO", "V9_VIDEO", "V10_VIDEO", "V99_VIDEO", "FULL_PAG", "PREVIEW_PAG", "plugin-finder_release"})
public enum x
{
  public final String detail;
  
  static
  {
    AppMethodBeat.i(167027);
    x localx1 = new x("FULL_IMAGE", 0, "full_image");
    vEn = localx1;
    x localx2 = new x("THUMB_IMAGE", 1, "thumb_image");
    vEo = localx2;
    x localx3 = new x("V0_VIDEO", 2, "xV0");
    vEp = localx3;
    x localx4 = new x("V1_VIDEO", 3, "xV1");
    vEq = localx4;
    x localx5 = new x("V2_VIDEO", 4, "xV2");
    vEr = localx5;
    x localx6 = new x("V3_VIDEO", 5, "xV3");
    vEs = localx6;
    x localx7 = new x("V4_VIDEO", 6, "xV4");
    vEt = localx7;
    x localx8 = new x("V5_VIDEO", 7, "xV5");
    vEu = localx8;
    x localx9 = new x("V6_VIDEO", 8, "xV6");
    vEv = localx9;
    x localx10 = new x("V7_VIDEO", 9, "xV7");
    vEw = localx10;
    x localx11 = new x("V8_VIDEO", 10, "xV8");
    vEx = localx11;
    x localx12 = new x("V9_VIDEO", 11, "xV9");
    vEy = localx12;
    x localx13 = new x("V10_VIDEO", 12, "xV10");
    vEz = localx13;
    x localx14 = new x("V99_VIDEO", 13, "xV99");
    vEA = localx14;
    x localx15 = new x("FULL_PAG", 14, "full_pag");
    vEB = localx15;
    x localx16 = new x("PREVIEW_PAG", 15, "preview_pag");
    vEC = localx16;
    vED = new x[] { localx1, localx2, localx3, localx4, localx5, localx6, localx7, localx8, localx9, localx10, localx11, localx12, localx13, localx14, localx15, localx16 };
    AppMethodBeat.o(167027);
  }
  
  private x(String paramString)
  {
    this.detail = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.x
 * JD-Core Version:    0.7.0.1
 */