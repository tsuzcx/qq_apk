package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.b.p;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class h
{
  public String gIA;
  public String gIB;
  public int gIu;
  public String gIv;
  public String gIw;
  public String gIx;
  public String gIy;
  public String gIz;
  public int ver;
  
  public static h d(k.b paramb)
  {
    AppMethodBeat.i(93329);
    paramb = paramb.gJV;
    h localh = new h();
    localh.gIv = bt.by((String)paramb.get(".msg.appmsg.giftcard_info.order_id"), "");
    localh.gIu = p.dG((String)paramb.get(".msg.appmsg.giftcard_info.biz_uin"));
    localh.gIw = bt.by((String)paramb.get(".msg.appmsg.giftcard_info.app_name"), "");
    localh.gIx = bt.by((String)paramb.get(".msg.appmsg.giftcard_info.recv_digest"), "");
    localh.gIy = bt.by((String)paramb.get(".msg.appmsg.giftcard_info.send_digest"), "");
    localh.gIz = bt.by((String)paramb.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
    localh.gIA = bt.by((String)paramb.get(".msg.appmsg.giftcard_info.title_color"), "");
    localh.gIB = bt.by((String)paramb.get(".msg.appmsg.giftcard_info.des_color"), "");
    localh.ver = p.dG((String)paramb.get(".msg.appmsg.giftcard_info.ver"));
    AppMethodBeat.o(93329);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.h
 * JD-Core Version:    0.7.0.1
 */