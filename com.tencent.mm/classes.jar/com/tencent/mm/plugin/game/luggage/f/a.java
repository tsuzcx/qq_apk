package com.tencent.mm.plugin.game.luggage.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class a
  extends f
{
  public String CBX;
  public String desc;
  public String iconUrl;
  public String jumpUrl;
  public String nickName;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(232107);
    paramStringBuilder.append("<gamecenter><namecard><iconUrl>").append(Util.escapeStringForXml(this.iconUrl)).append("</iconUrl><name>").append(Util.escapeStringForXml(this.nickName)).append("</name><desc>").append(Util.escapeStringForXml(this.desc)).append("</desc><tail>").append(Util.escapeStringForXml(this.CBX)).append("</tail><jumpUrl>").append(Util.escapeStringForXml(this.jumpUrl)).append("</jumpUrl></namecard></gamecenter>");
    AppMethodBeat.o(232107);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(232110);
    if (paramMap.get(".msg.appmsg.gamecenter.namecard") != null)
    {
      this.iconUrl = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.iconUrl"));
      this.nickName = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.name"));
      this.desc = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.desc"));
      this.CBX = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.tail"));
      this.jumpUrl = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.jumpUrl"));
    }
    AppMethodBeat.o(232110);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(232104);
    a locala = new a();
    locala.iconUrl = this.iconUrl;
    locala.nickName = this.nickName;
    locala.desc = this.desc;
    locala.CBX = this.CBX;
    locala.jumpUrl = this.jumpUrl;
    AppMethodBeat.o(232104);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f.a
 * JD-Core Version:    0.7.0.1
 */