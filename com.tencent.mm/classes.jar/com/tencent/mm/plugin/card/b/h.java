package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.b.p;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public final class h
{
  public int hiV;
  public String hiW;
  public String hiX;
  public String hiY;
  public String hiZ;
  public String hja;
  public String hjb;
  public String titleColor;
  public int ver;
  
  public static h d(k.b paramb)
  {
    AppMethodBeat.i(93329);
    paramb = paramb.hkv;
    h localh = new h();
    localh.hiW = bs.bG((String)paramb.get(".msg.appmsg.giftcard_info.order_id"), "");
    localh.hiV = p.dv((String)paramb.get(".msg.appmsg.giftcard_info.biz_uin"));
    localh.hiX = bs.bG((String)paramb.get(".msg.appmsg.giftcard_info.app_name"), "");
    localh.hiY = bs.bG((String)paramb.get(".msg.appmsg.giftcard_info.recv_digest"), "");
    localh.hiZ = bs.bG((String)paramb.get(".msg.appmsg.giftcard_info.send_digest"), "");
    localh.hja = bs.bG((String)paramb.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
    localh.titleColor = bs.bG((String)paramb.get(".msg.appmsg.giftcard_info.title_color"), "");
    localh.hjb = bs.bG((String)paramb.get(".msg.appmsg.giftcard_info.des_color"), "");
    localh.ver = p.dv((String)paramb.get(".msg.appmsg.giftcard_info.ver"));
    AppMethodBeat.o(93329);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.h
 * JD-Core Version:    0.7.0.1
 */