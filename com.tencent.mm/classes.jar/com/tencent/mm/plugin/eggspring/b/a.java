package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.brx;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "", "()V", "acceptRedPocketCoverUrl", "", "getAcceptRedPocketCoverUrl", "()Ljava/lang/String;", "setAcceptRedPocketCoverUrl", "(Ljava/lang/String;)V", "aid", "", "getAid", "()I", "setAid", "(I)V", "appId", "getAppId", "setAppId", "blessingMediaShowType", "getBlessingMediaShowType", "setBlessingMediaShowType", "blessingMediaType", "getBlessingMediaType", "setBlessingMediaType", "blessingWordImgUrl", "getBlessingWordImgUrl", "setBlessingWordImgUrl", "brandCardType", "getBrandCardType", "setBrandCardType", "clickableTxt", "getClickableTxt", "setClickableTxt", "couponInfo", "Lcom/tencent/mm/protobuf/ByteString;", "getCouponInfo", "()Lcom/tencent/mm/protobuf/ByteString;", "setCouponInfo", "(Lcom/tencent/mm/protobuf/ByteString;)V", "jumpInfo", "Lcom/tencent/mm/protocal/protobuf/JumpInfo;", "getJumpInfo", "()Lcom/tencent/mm/protocal/protobuf/JumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/protocal/protobuf/JumpInfo;)V", "mainMediaUrl", "getMainMediaUrl", "setMainMediaUrl", "manWording", "getManWording", "setManWording", "subWording", "getSubWording", "setSubWording", "traceId", "getTraceId", "setTraceId", "toString", "plugin-eggspring_release"})
public final class a
{
  public String appId;
  public String jSR;
  public int pyV = 4;
  public String pyW;
  public String pyX;
  public brx pyY;
  public String pyZ;
  public String pza;
  public String pzb;
  public b pzc;
  public String pzd;
  public int pze = 1;
  public int pzf = 1;
  public int pzg;
  
  public final String toString()
  {
    AppMethodBeat.i(108150);
    String str = "BrandCardContent(brandCardType=" + this.pyV + ", clickableTxt=" + this.pyW + ", mainMediaUrl=" + this.pyX + ", jumpInfo=" + this.pyY + ", manWording=" + this.pyZ + ", subWording=" + this.pza + ", acceptRedPocketCoverUrl=" + this.pzb + ", couponInfo=" + this.pzc + ", blessingWordImgUrl=" + this.pzd + ", blessingMediaType=" + this.pze + ", blessingMediaShowType=" + this.pzf + ", appId=" + this.appId + ", aid=" + this.pzg + ", traceId=" + this.jSR + ')';
    AppMethodBeat.o(108150);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.a
 * JD-Core Version:    0.7.0.1
 */