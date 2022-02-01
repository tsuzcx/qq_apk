package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.b.p;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class h
{
  public int lnn;
  public String lno;
  public String lnp;
  public String lnq;
  public String lnr;
  public String lns;
  public String lnt;
  public String lnu;
  public int ver;
  
  public static h d(k.b paramb)
  {
    AppMethodBeat.i(93329);
    paramb = paramb.lpa;
    h localh = new h();
    localh.lno = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.order_id"), "");
    localh.lnn = p.fT((String)paramb.get(".msg.appmsg.giftcard_info.biz_uin"));
    localh.lnp = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.app_name"), "");
    localh.lnq = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.recv_digest"), "");
    localh.lnr = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.send_digest"), "");
    localh.lns = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
    localh.lnt = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.title_color"), "");
    localh.lnu = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.des_color"), "");
    localh.ver = p.fT((String)paramb.get(".msg.appmsg.giftcard_info.ver"));
    AppMethodBeat.o(93329);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.h
 * JD-Core Version:    0.7.0.1
 */