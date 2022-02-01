package com.tencent.mm.plugin.card.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class g
{
  public int nSr;
  public String nSs;
  public String nSt;
  public String nSu;
  public String nSv;
  public String nSw;
  public String nSx;
  public String nSy;
  public int ver;
  
  public static g d(k.b paramb)
  {
    AppMethodBeat.i(93329);
    paramb = paramb.nUd;
    g localg = new g();
    localg.nSs = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.order_id"), "");
    localg.nSr = p.hw((String)paramb.get(".msg.appmsg.giftcard_info.biz_uin"));
    localg.nSt = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.app_name"), "");
    localg.nSu = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.recv_digest"), "");
    localg.nSv = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.send_digest"), "");
    localg.nSw = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
    localg.nSx = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.title_color"), "");
    localg.nSy = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.des_color"), "");
    localg.ver = p.hw((String)paramb.get(".msg.appmsg.giftcard_info.ver"));
    AppMethodBeat.o(93329);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.g
 * JD-Core Version:    0.7.0.1
 */