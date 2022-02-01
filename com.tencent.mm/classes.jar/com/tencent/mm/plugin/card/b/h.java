package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.b.p;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class h
{
  public int ixX;
  public String ixY;
  public String ixZ;
  public String iya;
  public String iyb;
  public String iyc;
  public String iyd;
  public String iye;
  public int ver;
  
  public static h d(k.b paramb)
  {
    AppMethodBeat.i(93329);
    paramb = paramb.izF;
    h localh = new h();
    localh.ixY = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.order_id"), "");
    localh.ixX = p.fd((String)paramb.get(".msg.appmsg.giftcard_info.biz_uin"));
    localh.ixZ = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.app_name"), "");
    localh.iya = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.recv_digest"), "");
    localh.iyb = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.send_digest"), "");
    localh.iyc = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
    localh.iyd = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.title_color"), "");
    localh.iye = Util.nullAs((String)paramb.get(".msg.appmsg.giftcard_info.des_color"), "");
    localh.ver = p.fd((String)paramb.get(".msg.appmsg.giftcard_info.ver"));
    AppMethodBeat.o(93329);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.h
 * JD-Core Version:    0.7.0.1
 */