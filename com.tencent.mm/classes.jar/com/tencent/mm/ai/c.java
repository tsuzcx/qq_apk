package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class c
  extends f
{
  public String gGk;
  public String gGl;
  public String gGm;
  public String gGn;
  public String gGo;
  public String gGp;
  public String gGq;
  public String gGr;
  public String gGs;
  public String gGt;
  public String gGu;
  public String gGv;
  public g gGw;
  public int subType;
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20231);
    if (paramb.type == 2001)
    {
      this.gGw = new g();
      this.gGw.a(paramMap, paramb);
      this.gGk = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.locallogoicon"));
      this.gGl = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.localbubbleicon"));
      this.gGm = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.effectresource"));
      ad.i("MicroMsg.AppContentC2cMsgPiece", "locallogoicon: %s, localbubbleicon: %s, effectResource: %s", new Object[] { this.gGk, this.gGl, this.gGm });
      this.gGn = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.corpname"));
      if (bt.isNullOrNil(this.gGw.gGH)) {
        break label358;
      }
      this.gGo = this.gGw.gGH;
      if (bt.isNullOrNil(this.gGw.gGI)) {
        break label379;
      }
      this.gGp = this.gGw.gGI;
      label188:
      if (bt.isNullOrNil(this.gGw.gGJ)) {
        break label400;
      }
      this.gGq = this.gGw.gGJ;
      label212:
      if (bt.isNullOrNil(this.gGw.gGK)) {
        break label421;
      }
      this.gGr = this.gGw.gGK;
      label236:
      if (bt.isNullOrNil(this.gGw.gGL)) {
        break label442;
      }
      this.gGs = this.gGw.gGL;
      label260:
      if (bt.isNullOrNil(this.gGw.gGM)) {
        break label463;
      }
      this.gGt = this.gGw.gGM;
      label284:
      if (bt.isNullOrNil(this.gGw.gGN)) {
        break label484;
      }
      this.gGu = this.gGw.gGN;
      label308:
      if (bt.isNullOrNil(this.gGw.gGO)) {
        break label505;
      }
    }
    label358:
    label505:
    for (this.gGv = this.gGw.gGO;; this.gGv = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourcemd5")))
    {
      this.subType = bt.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.subtype"), 0);
      AppMethodBeat.o(20231);
      return;
      this.gGo = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourceurl"));
      break;
      label379:
      this.gGp = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourcemd5"));
      break label188;
      this.gGq = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourceurl"));
      break label212;
      this.gGr = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourcemd5"));
      break label236;
      this.gGs = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourceurl"));
      break label260;
      this.gGt = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourcemd5"));
      break label284;
      this.gGu = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourceurl"));
      break label308;
    }
  }
  
  public final f apu()
  {
    AppMethodBeat.i(20230);
    c localc = new c();
    AppMethodBeat.o(20230);
    return localc;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.c
 * JD-Core Version:    0.7.0.1
 */