package com.tencent.mm.plugin.card.b;

import com.tencent.mm.a.o;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

public final class h
{
  public int dRO;
  public String dRP;
  public String dRQ;
  public String dRR;
  public String dRS;
  public String dRT;
  public String dRU;
  public String dRV;
  public int ver;
  
  public static h b(g.a parama)
  {
    parama = parama.dTl;
    h localh = new h();
    localh.dRP = bk.aM((String)parama.get(".msg.appmsg.giftcard_info.order_id"), "");
    localh.dRO = o.bS((String)parama.get(".msg.appmsg.giftcard_info.biz_uin"));
    localh.dRQ = bk.aM((String)parama.get(".msg.appmsg.giftcard_info.app_name"), "");
    localh.dRR = bk.aM((String)parama.get(".msg.appmsg.giftcard_info.recv_digest"), "");
    localh.dRS = bk.aM((String)parama.get(".msg.appmsg.giftcard_info.send_digest"), "");
    localh.dRT = bk.aM((String)parama.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
    localh.dRU = bk.aM((String)parama.get(".msg.appmsg.giftcard_info.title_color"), "");
    localh.dRV = bk.aM((String)parama.get(".msg.appmsg.giftcard_info.des_color"), "");
    localh.ver = o.bS((String)parama.get(".msg.appmsg.giftcard_info.ver"));
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.h
 * JD-Core Version:    0.7.0.1
 */