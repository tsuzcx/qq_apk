package com.tencent.mm.plugin.game.luggage.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class a
  extends f
{
  public String bVF;
  public String desc;
  public String iconUrl;
  public String jumpUrl;
  public String tUK;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211660);
    paramStringBuilder.append("<gamecenter><namecard><iconUrl>").append(bt.aRc(this.iconUrl)).append("</iconUrl><name>").append(bt.aRc(this.bVF)).append("</name><desc>").append(bt.aRc(this.desc)).append("</desc><tail>").append(bt.aRc(this.tUK)).append("</tail><jumpUrl>").append(bt.aRc(this.jumpUrl)).append("</jumpUrl></namecard></gamecenter>");
    AppMethodBeat.o(211660);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(211661);
    if (paramMap.get(".msg.appmsg.gamecenter.namecard") != null)
    {
      this.iconUrl = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.iconUrl"));
      this.bVF = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.name"));
      this.desc = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.desc"));
      this.tUK = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.tail"));
      this.jumpUrl = ((String)paramMap.get(".msg.appmsg.gamecenter.namecard.jumpUrl"));
    }
    AppMethodBeat.o(211661);
  }
  
  public final f aot()
  {
    AppMethodBeat.i(211659);
    a locala = new a();
    locala.iconUrl = this.iconUrl;
    locala.bVF = this.bVF;
    locala.desc = this.desc;
    locala.tUK = this.tUK;
    locala.jumpUrl = this.jumpUrl;
    AppMethodBeat.o(211659);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a
 * JD-Core Version:    0.7.0.1
 */