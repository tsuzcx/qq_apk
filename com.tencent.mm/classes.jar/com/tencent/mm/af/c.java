package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public class c
  extends f
{
  public String ffV;
  public String ffW;
  public String ffX;
  public String ffY;
  public String ffZ;
  public String fga;
  public String fgb;
  public String fgc;
  public String fgd;
  public String fge;
  public String fgf;
  public String fgg;
  public int subType;
  
  public final f Yk()
  {
    AppMethodBeat.i(16187);
    c localc = new c();
    AppMethodBeat.o(16187);
    return localc;
  }
  
  public final void a(Map<String, String> paramMap, j.b paramb)
  {
    AppMethodBeat.i(16188);
    if (paramb.type == 2001)
    {
      this.ffV = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.locallogoicon"));
      this.ffW = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.localbubbleicon"));
      this.ffX = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.effectresource"));
      ab.i("MicroMsg.AppContentC2cMsgPiece", "locallogoicon: %s, localbubbleicon: %s, effectResource: %s", new Object[] { this.ffV, this.ffW, this.ffX });
      this.ffY = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.corpname"));
      this.ffZ = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourceurl"));
      this.fga = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourcemd5"));
      this.fgb = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourceurl"));
      this.fgc = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourcemd5"));
      this.fgd = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourceurl"));
      this.fge = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourcemd5"));
      this.fgf = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourceurl"));
      this.fgg = bo.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourcemd5"));
      this.subType = bo.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.subtype"), 0);
    }
    AppMethodBeat.o(16188);
  }
  
  public final void b(StringBuilder paramStringBuilder, j.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.af.c
 * JD-Core Version:    0.7.0.1
 */