package com.tencent.mm.plugin.game.luggage.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public class a
  extends f
{
  public String bVF;
  public String desc;
  public String iconUrl;
  public String jumpUrl;
  public String ufC;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193049);
    paramStringBuilder.append("<gamecenter><namecard><iconUrl>").append(bu.aSz(this.iconUrl)).append("</iconUrl><name>").append(bu.aSz(this.bVF)).append("</name><desc>").append(bu.aSz(this.desc)).append("</desc><tail>").append(bu.aSz(this.ufC)).append("</tail><jumpUrl>").append(bu.aSz(this.jumpUrl)).append("</jumpUrl></namecard></gamecenter>");
    AppMethodBeat.o(193049);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(193050);
    if (paramMap.get(".msg.appmsg.gamecenter.namecard") != null)
    {
      this.iconUrl = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.iconUrl"));
      this.bVF = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.name"));
      this.desc = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.desc"));
      this.ufC = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.tail"));
      this.jumpUrl = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.jumpUrl"));
    }
    AppMethodBeat.o(193050);
  }
  
  public final f aoI()
  {
    AppMethodBeat.i(193048);
    a locala = new a();
    locala.iconUrl = this.iconUrl;
    locala.bVF = this.bVF;
    locala.desc = this.desc;
    locala.ufC = this.ufC;
    locala.jumpUrl = this.jumpUrl;
    AppMethodBeat.o(193048);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a
 * JD-Core Version:    0.7.0.1
 */