package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class c
  extends f
{
  public String nPQ;
  public String nPR;
  public String nPS;
  public String nPT;
  public String nPU;
  public String nPV;
  public String nPW;
  public String nPX;
  public String nPY;
  public String nPZ;
  public String nQa;
  public String nQb;
  public String nQc;
  public String nQd;
  public String nQe;
  public String nQf;
  public String nQg;
  public String nQh;
  public String nQi;
  public int nQj;
  public String nQk;
  public g nQl;
  public int subType;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20231);
    if (paramb.type == 2001)
    {
      this.nQl = new g();
      this.nQl.a(paramMap, paramb);
      this.nPQ = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.locallogoicon"));
      this.nPR = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.localbubbleicon"));
      this.nPS = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.effectresource"));
      Log.i("MicroMsg.AppContentC2cMsgPiece", "locallogoicon: %s, localbubbleicon: %s, effectResource: %s", new Object[] { this.nPQ, this.nPR, this.nPS });
      this.nPT = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.corpname"));
      if (Util.isNullOrNil(this.nQl.nQv)) {
        break label555;
      }
      this.nPU = this.nQl.nQv;
      if (Util.isNullOrNil(this.nQl.nQw)) {
        break label576;
      }
      this.nPV = this.nQl.nQw;
      label188:
      if (Util.isNullOrNil(this.nQl.nQx)) {
        break label597;
      }
      this.nPW = this.nQl.nQx;
      label212:
      if (Util.isNullOrNil(this.nQl.nQy)) {
        break label618;
      }
      this.nPX = this.nQl.nQy;
      label236:
      if (Util.isNullOrNil(this.nQl.nQz)) {
        break label639;
      }
      this.nPY = this.nQl.nQz;
      label260:
      if (Util.isNullOrNil(this.nQl.nQA)) {
        break label660;
      }
      this.nPZ = this.nQl.nQA;
      label284:
      if (Util.isNullOrNil(this.nQl.nQB)) {
        break label681;
      }
      this.nQa = this.nQl.nQB;
      label308:
      if (Util.isNullOrNil(this.nQl.nQC)) {
        break label702;
      }
    }
    label555:
    label702:
    for (this.nQb = this.nQl.nQC;; this.nQb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourcemd5")))
    {
      this.subType = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.subtype"), 0);
      this.nQc = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.exclusive_recv_username"));
      if (!Util.isNullOrNil(this.nQl.nQK)) {
        this.nQd = this.nQl.nQK;
      }
      if (!Util.isNullOrNil(this.nQl.nQL)) {
        this.nQe = this.nQl.nQL;
      }
      if (!Util.isNullOrNil(this.nQl.nQM)) {
        this.nQf = this.nQl.nQM;
      }
      if (!Util.isNullOrNil(this.nQl.nQN)) {
        this.nQg = this.nQl.nQN;
      }
      if (!Util.isNullOrNil(this.nQl.nQO)) {
        this.nQh = this.nQl.nQO;
      }
      if (!Util.isNullOrNil(this.nQl.nQP)) {
        this.nQi = this.nQl.nQP;
      }
      this.nQj = this.nQl.nQQ;
      if (!Util.isNullOrNil(this.nQl.nQR)) {
        this.nQk = this.nQl.nQR;
      }
      AppMethodBeat.o(20231);
      return;
      this.nPU = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourceurl"));
      break;
      label576:
      this.nPV = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourcemd5"));
      break label188;
      label597:
      this.nPW = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourceurl"));
      break label212;
      label618:
      this.nPX = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourcemd5"));
      break label236;
      label639:
      this.nPY = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourceurl"));
      break label260;
      this.nPZ = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourcemd5"));
      break label284;
      this.nQa = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourceurl"));
      break label308;
    }
  }
  
  public final f biW()
  {
    AppMethodBeat.i(20230);
    c localc = new c();
    AppMethodBeat.o(20230);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.message.c
 * JD-Core Version:    0.7.0.1
 */