package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.b.p;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class h
{
  public int hBe;
  public String hBf;
  public String hBg;
  public String hBh;
  public String hBi;
  public String hBj;
  public String hBk;
  public String titleColor;
  public int ver;
  
  public static h d(k.b paramb)
  {
    AppMethodBeat.i(93329);
    paramb = paramb.hCE;
    h localh = new h();
    localh.hBf = bt.bI((String)paramb.get(".msg.appmsg.giftcard_info.order_id"), "");
    localh.hBe = p.er((String)paramb.get(".msg.appmsg.giftcard_info.biz_uin"));
    localh.hBg = bt.bI((String)paramb.get(".msg.appmsg.giftcard_info.app_name"), "");
    localh.hBh = bt.bI((String)paramb.get(".msg.appmsg.giftcard_info.recv_digest"), "");
    localh.hBi = bt.bI((String)paramb.get(".msg.appmsg.giftcard_info.send_digest"), "");
    localh.hBj = bt.bI((String)paramb.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
    localh.titleColor = bt.bI((String)paramb.get(".msg.appmsg.giftcard_info.title_color"), "");
    localh.hBk = bt.bI((String)paramb.get(".msg.appmsg.giftcard_info.des_color"), "");
    localh.ver = p.er((String)paramb.get(".msg.appmsg.giftcard_info.ver"));
    AppMethodBeat.o(93329);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.h
 * JD-Core Version:    0.7.0.1
 */