package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.bsr;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "", "()V", "acceptRedPocketCoverUrl", "", "getAcceptRedPocketCoverUrl", "()Ljava/lang/String;", "setAcceptRedPocketCoverUrl", "(Ljava/lang/String;)V", "aid", "", "getAid", "()I", "setAid", "(I)V", "appId", "getAppId", "setAppId", "blessingMediaShowType", "getBlessingMediaShowType", "setBlessingMediaShowType", "blessingMediaType", "getBlessingMediaType", "setBlessingMediaType", "blessingWordImgUrl", "getBlessingWordImgUrl", "setBlessingWordImgUrl", "brandCardType", "getBrandCardType", "setBrandCardType", "clickableTxt", "getClickableTxt", "setClickableTxt", "couponInfo", "Lcom/tencent/mm/protobuf/ByteString;", "getCouponInfo", "()Lcom/tencent/mm/protobuf/ByteString;", "setCouponInfo", "(Lcom/tencent/mm/protobuf/ByteString;)V", "jumpInfo", "Lcom/tencent/mm/protocal/protobuf/JumpInfo;", "getJumpInfo", "()Lcom/tencent/mm/protocal/protobuf/JumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/protocal/protobuf/JumpInfo;)V", "mainMediaUrl", "getMainMediaUrl", "setMainMediaUrl", "manWording", "getManWording", "setManWording", "subWording", "getSubWording", "setSubWording", "traceId", "getTraceId", "setTraceId", "toString", "plugin-eggspring_release"})
public final class a
{
  public String appId;
  public String jWi;
  public String pFA;
  public String pFB;
  public bsr pFC;
  public String pFD;
  public String pFE;
  public String pFF;
  public b pFG;
  public String pFH;
  public int pFI = 1;
  public int pFJ = 1;
  public int pFK;
  public int pFz = 4;
  
  public final String toString()
  {
    AppMethodBeat.i(108150);
    String str = "BrandCardContent(brandCardType=" + this.pFz + ", clickableTxt=" + this.pFA + ", mainMediaUrl=" + this.pFB + ", jumpInfo=" + this.pFC + ", manWording=" + this.pFD + ", subWording=" + this.pFE + ", acceptRedPocketCoverUrl=" + this.pFF + ", couponInfo=" + this.pFG + ", blessingWordImgUrl=" + this.pFH + ", blessingMediaType=" + this.pFI + ", blessingMediaShowType=" + this.pFJ + ", appId=" + this.appId + ", aid=" + this.pFK + ", traceId=" + this.jWi + ')';
    AppMethodBeat.o(108150);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.a
 * JD-Core Version:    0.7.0.1
 */