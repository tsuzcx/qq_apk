package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class c
  extends f
{
  public String hyU;
  public String hyV;
  public String hyW;
  public String hyX;
  public String hyY;
  public String hyZ;
  public String hza;
  public String hzb;
  public String hzc;
  public String hzd;
  public String hze;
  public String hzf;
  public g hzg;
  public int subType;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20231);
    if (paramb.type == 2001)
    {
      this.hzg = new g();
      this.hzg.a(paramMap, paramb);
      this.hyU = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.locallogoicon"));
      this.hyV = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.localbubbleicon"));
      this.hyW = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.effectresource"));
      ad.i("MicroMsg.AppContentC2cMsgPiece", "locallogoicon: %s, localbubbleicon: %s, effectResource: %s", new Object[] { this.hyU, this.hyV, this.hyW });
      this.hyX = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.corpname"));
      if (bt.isNullOrNil(this.hzg.hzr)) {
        break label358;
      }
      this.hyY = this.hzg.hzr;
      if (bt.isNullOrNil(this.hzg.hzs)) {
        break label379;
      }
      this.hyZ = this.hzg.hzs;
      label188:
      if (bt.isNullOrNil(this.hzg.hzt)) {
        break label400;
      }
      this.hza = this.hzg.hzt;
      label212:
      if (bt.isNullOrNil(this.hzg.hzu)) {
        break label421;
      }
      this.hzb = this.hzg.hzu;
      label236:
      if (bt.isNullOrNil(this.hzg.hzv)) {
        break label442;
      }
      this.hzc = this.hzg.hzv;
      label260:
      if (bt.isNullOrNil(this.hzg.hzw)) {
        break label463;
      }
      this.hzd = this.hzg.hzw;
      label284:
      if (bt.isNullOrNil(this.hzg.hzx)) {
        break label484;
      }
      this.hze = this.hzg.hzx;
      label308:
      if (bt.isNullOrNil(this.hzg.hzy)) {
        break label505;
      }
    }
    label358:
    label505:
    for (this.hzf = this.hzg.hzy;; this.hzf = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourcemd5")))
    {
      this.subType = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.subtype"), 0);
      AppMethodBeat.o(20231);
      return;
      this.hyY = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourceurl"));
      break;
      label379:
      this.hyZ = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourcemd5"));
      break label188;
      this.hza = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourceurl"));
      break label212;
      this.hzb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourcemd5"));
      break label236;
      this.hzc = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourceurl"));
      break label260;
      this.hzd = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourcemd5"));
      break label284;
      this.hze = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourceurl"));
      break label308;
    }
  }
  
  public final f aot()
  {
    AppMethodBeat.i(20230);
    c localc = new c();
    AppMethodBeat.o(20230);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.c
 * JD-Core Version:    0.7.0.1
 */