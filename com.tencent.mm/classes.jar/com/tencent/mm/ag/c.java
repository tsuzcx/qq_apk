package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class c
  extends f
{
  public String ivO;
  public String ivP;
  public String ivQ;
  public String ivR;
  public String ivS;
  public String ivT;
  public String ivU;
  public String ivV;
  public String ivW;
  public String ivX;
  public String ivY;
  public String ivZ;
  public String iwa;
  public g iwb;
  public int subType;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(20231);
    if (paramb.type == 2001)
    {
      this.iwb = new g();
      this.iwb.a(paramMap, paramb);
      this.ivO = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.locallogoicon"));
      this.ivP = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.localbubbleicon"));
      this.ivQ = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.effectresource"));
      Log.i("MicroMsg.AppContentC2cMsgPiece", "locallogoicon: %s, localbubbleicon: %s, effectResource: %s", new Object[] { this.ivO, this.ivP, this.ivQ });
      this.ivR = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.corpname"));
      if (Util.isNullOrNil(this.iwb.iwl)) {
        break label376;
      }
      this.ivS = this.iwb.iwl;
      if (Util.isNullOrNil(this.iwb.iwm)) {
        break label397;
      }
      this.ivT = this.iwb.iwm;
      label188:
      if (Util.isNullOrNil(this.iwb.iwn)) {
        break label418;
      }
      this.ivU = this.iwb.iwn;
      label212:
      if (Util.isNullOrNil(this.iwb.iwo)) {
        break label439;
      }
      this.ivV = this.iwb.iwo;
      label236:
      if (Util.isNullOrNil(this.iwb.iwp)) {
        break label460;
      }
      this.ivW = this.iwb.iwp;
      label260:
      if (Util.isNullOrNil(this.iwb.iwq)) {
        break label481;
      }
      this.ivX = this.iwb.iwq;
      label284:
      if (Util.isNullOrNil(this.iwb.iwr)) {
        break label502;
      }
      this.ivY = this.iwb.iwr;
      label308:
      if (Util.isNullOrNil(this.iwb.iws)) {
        break label523;
      }
    }
    label523:
    for (this.ivZ = this.iwb.iws;; this.ivZ = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourcemd5")))
    {
      this.subType = Util.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.subtype"), 0);
      this.iwa = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.exclusive_recv_username"));
      AppMethodBeat.o(20231);
      return;
      label376:
      this.ivS = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourceurl"));
      break;
      label397:
      this.ivT = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.senderc2cshowsourcemd5"));
      break label188;
      label418:
      this.ivU = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourceurl"));
      break label212;
      label439:
      this.ivV = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverc2cshowsourcemd5"));
      break label236;
      label460:
      this.ivW = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourceurl"));
      break label260;
      label481:
      this.ivX = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.recshowsourcemd5"));
      break label284;
      label502:
      this.ivY = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.detailshowsourceurl"));
      break label308;
    }
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(20230);
    c localc = new c();
    AppMethodBeat.o(20230);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.c
 * JD-Core Version:    0.7.0.1
 */