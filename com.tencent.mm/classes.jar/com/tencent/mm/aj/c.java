package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class c
  extends f
{
  public String llb;
  public String llc;
  public String lld;
  public String lle;
  public String llf;
  public String llg;
  public String llh;
  public String lli;
  public String llj;
  public String llk;
  public String lll;
  public String llm;
  public String lln;
  public g llo;
  public int subType;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20231);
    if (paramb.type == 2001)
    {
      this.llo = new g();
      this.llo.a(paramMap, paramb);
      this.llb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.locallogoicon"));
      this.llc = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.localbubbleicon"));
      this.lld = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.effectresource"));
      Log.i("MicroMsg.AppContentC2cMsgPiece", "locallogoicon: %s, localbubbleicon: %s, effectResource: %s", new Object[] { this.llb, this.llc, this.lld });
      this.lle = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.corpname"));
      if (Util.isNullOrNil(this.llo.lly)) {
        break label376;
      }
      this.llf = this.llo.lly;
      if (Util.isNullOrNil(this.llo.llz)) {
        break label397;
      }
      this.llg = this.llo.llz;
      label188:
      if (Util.isNullOrNil(this.llo.llA)) {
        break label418;
      }
      this.llh = this.llo.llA;
      label212:
      if (Util.isNullOrNil(this.llo.llB)) {
        break label439;
      }
      this.lli = this.llo.llB;
      label236:
      if (Util.isNullOrNil(this.llo.llC)) {
        break label460;
      }
      this.llj = this.llo.llC;
      label260:
      if (Util.isNullOrNil(this.llo.llD)) {
        break label481;
      }
      this.llk = this.llo.llD;
      label284:
      if (Util.isNullOrNil(this.llo.llE)) {
        break label502;
      }
      this.lll = this.llo.llE;
      label308:
      if (Util.isNullOrNil(this.llo.llF)) {
        break label523;
      }
    }
    label523:
    for (this.llm = this.llo.llF;; this.llm = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourcemd5")))
    {
      this.subType = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.subtype"), 0);
      this.lln = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.exclusive_recv_username"));
      AppMethodBeat.o(20231);
      return;
      label376:
      this.llf = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourceurl"));
      break;
      label397:
      this.llg = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourcemd5"));
      break label188;
      label418:
      this.llh = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourceurl"));
      break label212;
      label439:
      this.lli = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourcemd5"));
      break label236;
      label460:
      this.llj = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourceurl"));
      break label260;
      label481:
      this.llk = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourcemd5"));
      break label284;
      label502:
      this.lll = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourceurl"));
      break label308;
    }
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(20230);
    c localc = new c();
    AppMethodBeat.o(20230);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.c
 * JD-Core Version:    0.7.0.1
 */