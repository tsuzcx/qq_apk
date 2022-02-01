package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public class c
  extends f
{
  public String hgL;
  public String hgM;
  public String hgN;
  public String hgO;
  public String hgP;
  public String hgQ;
  public String hgR;
  public String hgS;
  public String hgT;
  public String hgU;
  public String hgV;
  public String hgW;
  public g hgX;
  public int subType;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20231);
    if (paramb.type == 2001)
    {
      this.hgX = new g();
      this.hgX.a(paramMap, paramb);
      this.hgL = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.locallogoicon"));
      this.hgM = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.localbubbleicon"));
      this.hgN = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.effectresource"));
      ac.i("MicroMsg.AppContentC2cMsgPiece", "locallogoicon: %s, localbubbleicon: %s, effectResource: %s", new Object[] { this.hgL, this.hgM, this.hgN });
      this.hgO = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.corpname"));
      if (bs.isNullOrNil(this.hgX.hhi)) {
        break label358;
      }
      this.hgP = this.hgX.hhi;
      if (bs.isNullOrNil(this.hgX.hhj)) {
        break label379;
      }
      this.hgQ = this.hgX.hhj;
      label188:
      if (bs.isNullOrNil(this.hgX.hhk)) {
        break label400;
      }
      this.hgR = this.hgX.hhk;
      label212:
      if (bs.isNullOrNil(this.hgX.hhl)) {
        break label421;
      }
      this.hgS = this.hgX.hhl;
      label236:
      if (bs.isNullOrNil(this.hgX.hhm)) {
        break label442;
      }
      this.hgT = this.hgX.hhm;
      label260:
      if (bs.isNullOrNil(this.hgX.hhn)) {
        break label463;
      }
      this.hgU = this.hgX.hhn;
      label284:
      if (bs.isNullOrNil(this.hgX.hho)) {
        break label484;
      }
      this.hgV = this.hgX.hho;
      label308:
      if (bs.isNullOrNil(this.hgX.hhp)) {
        break label505;
      }
    }
    label358:
    label505:
    for (this.hgW = this.hgX.hhp;; this.hgW = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourcemd5")))
    {
      this.subType = bs.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.subtype"), 0);
      AppMethodBeat.o(20231);
      return;
      this.hgP = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourceurl"));
      break;
      label379:
      this.hgQ = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourcemd5"));
      break label188;
      this.hgR = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourceurl"));
      break label212;
      this.hgS = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourcemd5"));
      break label236;
      this.hgT = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourceurl"));
      break label260;
      this.hgU = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourcemd5"));
      break label284;
      this.hgV = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourceurl"));
      break label308;
    }
  }
  
  public final f alG()
  {
    AppMethodBeat.i(20230);
    c localc = new c();
    AppMethodBeat.o(20230);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.c
 * JD-Core Version:    0.7.0.1
 */