package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.af.j.b;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class h
{
  public int fhN;
  public String fhO;
  public String fhP;
  public String fhQ;
  public String fhR;
  public String fhS;
  public String fhT;
  public String fhU;
  public int ver;
  
  public static h b(j.b paramb)
  {
    AppMethodBeat.i(114431);
    paramb = paramb.fjm;
    h localh = new h();
    localh.fhO = bo.bf((String)paramb.get(".msg.appmsg.giftcard_info.order_id"), "");
    localh.fhN = p.cU((String)paramb.get(".msg.appmsg.giftcard_info.biz_uin"));
    localh.fhP = bo.bf((String)paramb.get(".msg.appmsg.giftcard_info.app_name"), "");
    localh.fhQ = bo.bf((String)paramb.get(".msg.appmsg.giftcard_info.recv_digest"), "");
    localh.fhR = bo.bf((String)paramb.get(".msg.appmsg.giftcard_info.send_digest"), "");
    localh.fhS = bo.bf((String)paramb.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
    localh.fhT = bo.bf((String)paramb.get(".msg.appmsg.giftcard_info.title_color"), "");
    localh.fhU = bo.bf((String)paramb.get(".msg.appmsg.giftcard_info.des_color"), "");
    localh.ver = p.cU((String)paramb.get(".msg.appmsg.giftcard_info.ver"));
    AppMethodBeat.o(114431);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.h
 * JD-Core Version:    0.7.0.1
 */