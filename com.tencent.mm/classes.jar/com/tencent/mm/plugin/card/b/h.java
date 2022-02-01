package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.b.p;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public final class h
{
  public int hDS;
  public String hDT;
  public String hDU;
  public String hDV;
  public String hDW;
  public String hDX;
  public String hDY;
  public String titleColor;
  public int ver;
  
  public static h d(k.b paramb)
  {
    AppMethodBeat.i(93329);
    paramb = paramb.hFw;
    h localh = new h();
    localh.hDT = bu.bI((String)paramb.get(".msg.appmsg.giftcard_info.order_id"), "");
    localh.hDS = p.ew((String)paramb.get(".msg.appmsg.giftcard_info.biz_uin"));
    localh.hDU = bu.bI((String)paramb.get(".msg.appmsg.giftcard_info.app_name"), "");
    localh.hDV = bu.bI((String)paramb.get(".msg.appmsg.giftcard_info.recv_digest"), "");
    localh.hDW = bu.bI((String)paramb.get(".msg.appmsg.giftcard_info.send_digest"), "");
    localh.hDX = bu.bI((String)paramb.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
    localh.titleColor = bu.bI((String)paramb.get(".msg.appmsg.giftcard_info.title_color"), "");
    localh.hDY = bu.bI((String)paramb.get(".msg.appmsg.giftcard_info.des_color"), "");
    localh.ver = p.ew((String)paramb.get(".msg.appmsg.giftcard_info.ver"));
    AppMethodBeat.o(93329);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.h
 * JD-Core Version:    0.7.0.1
 */