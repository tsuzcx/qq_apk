package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.bjs;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "", "()V", "acceptRedPocketCoverUrl", "", "getAcceptRedPocketCoverUrl", "()Ljava/lang/String;", "setAcceptRedPocketCoverUrl", "(Ljava/lang/String;)V", "aid", "", "getAid", "()I", "setAid", "(I)V", "appId", "getAppId", "setAppId", "blessingMediaShowType", "getBlessingMediaShowType", "setBlessingMediaShowType", "blessingMediaType", "getBlessingMediaType", "setBlessingMediaType", "blessingWordImgUrl", "getBlessingWordImgUrl", "setBlessingWordImgUrl", "brandCardType", "getBrandCardType", "setBrandCardType", "clickableTxt", "getClickableTxt", "setClickableTxt", "couponInfo", "Lcom/tencent/mm/protobuf/ByteString;", "getCouponInfo", "()Lcom/tencent/mm/protobuf/ByteString;", "setCouponInfo", "(Lcom/tencent/mm/protobuf/ByteString;)V", "jumpInfo", "Lcom/tencent/mm/protocal/protobuf/JumpInfo;", "getJumpInfo", "()Lcom/tencent/mm/protocal/protobuf/JumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/protocal/protobuf/JumpInfo;)V", "mainMediaUrl", "getMainMediaUrl", "setMainMediaUrl", "manWording", "getManWording", "setManWording", "subWording", "getSubWording", "setSubWording", "traceId", "getTraceId", "setTraceId", "toString", "plugin-eggspring_release"})
public final class a
{
  public String appId;
  public String iYE;
  public int orL = 4;
  public String orM;
  public String orN;
  public bjs orO;
  public String orP;
  public String orQ;
  public String orR;
  public b orS;
  public String orT;
  public int orU = 1;
  public int orV = 1;
  public int orW;
  
  public final String toString()
  {
    AppMethodBeat.i(108150);
    String str = "BrandCardContent(brandCardType=" + this.orL + ", clickableTxt=" + this.orM + ", mainMediaUrl=" + this.orN + ", jumpInfo=" + this.orO + ", manWording=" + this.orP + ", subWording=" + this.orQ + ", acceptRedPocketCoverUrl=" + this.orR + ", couponInfo=" + this.orS + ", blessingWordImgUrl=" + this.orT + ", blessingMediaType=" + this.orU + ", blessingMediaShowType=" + this.orV + ", appId=" + this.appId + ", aid=" + this.orW + ", traceId=" + this.iYE + ')';
    AppMethodBeat.o(108150);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.a
 * JD-Core Version:    0.7.0.1
 */