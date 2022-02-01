package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.bnm;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "", "()V", "acceptRedPocketCoverUrl", "", "getAcceptRedPocketCoverUrl", "()Ljava/lang/String;", "setAcceptRedPocketCoverUrl", "(Ljava/lang/String;)V", "aid", "", "getAid", "()I", "setAid", "(I)V", "appId", "getAppId", "setAppId", "blessingMediaShowType", "getBlessingMediaShowType", "setBlessingMediaShowType", "blessingMediaType", "getBlessingMediaType", "setBlessingMediaType", "blessingWordImgUrl", "getBlessingWordImgUrl", "setBlessingWordImgUrl", "brandCardType", "getBrandCardType", "setBrandCardType", "clickableTxt", "getClickableTxt", "setClickableTxt", "couponInfo", "Lcom/tencent/mm/protobuf/ByteString;", "getCouponInfo", "()Lcom/tencent/mm/protobuf/ByteString;", "setCouponInfo", "(Lcom/tencent/mm/protobuf/ByteString;)V", "jumpInfo", "Lcom/tencent/mm/protocal/protobuf/JumpInfo;", "getJumpInfo", "()Lcom/tencent/mm/protocal/protobuf/JumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/protocal/protobuf/JumpInfo;)V", "mainMediaUrl", "getMainMediaUrl", "setMainMediaUrl", "manWording", "getManWording", "setManWording", "subWording", "getSubWording", "setSubWording", "traceId", "getTraceId", "setTraceId", "toString", "plugin-eggspring_release"})
public final class a
{
  public String appId;
  public String jyU;
  public int oVl = 4;
  public String oVm;
  public String oVn;
  public bnm oVo;
  public String oVp;
  public String oVq;
  public String oVr;
  public b oVs;
  public String oVt;
  public int oVu = 1;
  public int oVv = 1;
  public int oVw;
  
  public final String toString()
  {
    AppMethodBeat.i(108150);
    String str = "BrandCardContent(brandCardType=" + this.oVl + ", clickableTxt=" + this.oVm + ", mainMediaUrl=" + this.oVn + ", jumpInfo=" + this.oVo + ", manWording=" + this.oVp + ", subWording=" + this.oVq + ", acceptRedPocketCoverUrl=" + this.oVr + ", couponInfo=" + this.oVs + ", blessingWordImgUrl=" + this.oVt + ", blessingMediaType=" + this.oVu + ", blessingMediaShowType=" + this.oVv + ", appId=" + this.appId + ", aid=" + this.oVw + ", traceId=" + this.jyU + ')';
    AppMethodBeat.o(108150);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.a
 * JD-Core Version:    0.7.0.1
 */