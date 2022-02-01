package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public class c
  extends f
{
  public String hBI;
  public String hBJ;
  public String hBK;
  public String hBL;
  public String hBM;
  public String hBN;
  public String hBO;
  public String hBP;
  public String hBQ;
  public String hBR;
  public String hBS;
  public String hBT;
  public g hBU;
  public int subType;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20231);
    if (paramb.type == 2001)
    {
      this.hBU = new g();
      this.hBU.a(paramMap, paramb);
      this.hBI = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.locallogoicon"));
      this.hBJ = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.localbubbleicon"));
      this.hBK = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.effectresource"));
      ae.i("MicroMsg.AppContentC2cMsgPiece", "locallogoicon: %s, localbubbleicon: %s, effectResource: %s", new Object[] { this.hBI, this.hBJ, this.hBK });
      this.hBL = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.corpname"));
      if (bu.isNullOrNil(this.hBU.hCf)) {
        break label358;
      }
      this.hBM = this.hBU.hCf;
      if (bu.isNullOrNil(this.hBU.hCg)) {
        break label379;
      }
      this.hBN = this.hBU.hCg;
      label188:
      if (bu.isNullOrNil(this.hBU.hCh)) {
        break label400;
      }
      this.hBO = this.hBU.hCh;
      label212:
      if (bu.isNullOrNil(this.hBU.hCi)) {
        break label421;
      }
      this.hBP = this.hBU.hCi;
      label236:
      if (bu.isNullOrNil(this.hBU.hCj)) {
        break label442;
      }
      this.hBQ = this.hBU.hCj;
      label260:
      if (bu.isNullOrNil(this.hBU.hCk)) {
        break label463;
      }
      this.hBR = this.hBU.hCk;
      label284:
      if (bu.isNullOrNil(this.hBU.hCl)) {
        break label484;
      }
      this.hBS = this.hBU.hCl;
      label308:
      if (bu.isNullOrNil(this.hBU.hCm)) {
        break label505;
      }
    }
    label358:
    label505:
    for (this.hBT = this.hBU.hCm;; this.hBT = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourcemd5")))
    {
      this.subType = bu.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.subtype"), 0);
      AppMethodBeat.o(20231);
      return;
      this.hBM = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourceurl"));
      break;
      label379:
      this.hBN = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourcemd5"));
      break label188;
      this.hBO = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourceurl"));
      break label212;
      this.hBP = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourcemd5"));
      break label236;
      this.hBQ = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourceurl"));
      break label260;
      this.hBR = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourcemd5"));
      break label284;
      this.hBS = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourceurl"));
      break label308;
    }
  }
  
  public final f aoI()
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