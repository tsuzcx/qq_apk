package com.tencent.mm.ae;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public class c
  extends d
{
  public String dQn;
  public String dQo;
  public String dQp;
  
  public final d Fk()
  {
    return new c();
  }
  
  public final void a(StringBuilder paramStringBuilder, g.a parama, String paramString, com.tencent.mm.j.d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, g.a parama)
  {
    if (parama.type == 2001)
    {
      this.dQn = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.locallogoicon"));
      this.dQo = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.localbubbleicon"));
      this.dQp = bk.pm((String)paramMap.get(".msg.appmsg.wcpayinfo.effectresource"));
      y.i("MicroMsg.AppContentC2cMsgPiece", "locallogoicon: %s, localbubbleicon: %s, effectResource: %s", new Object[] { this.dQn, this.dQo, this.dQp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ae.c
 * JD-Core Version:    0.7.0.1
 */