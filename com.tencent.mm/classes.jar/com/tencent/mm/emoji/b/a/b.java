package com.tencent.mm.emoji.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.akx;
import com.tencent.mm.protocal.protobuf.aky;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/cgi/CgiExchangeEmotionPack;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ExchangeEmotionPackResponse;", "groupId", "", "scene", "", "(Ljava/lang/String;I)V", "Companion", "plugin-emojisdk_release"})
public final class b
  extends c<aky>
{
  public static final a jIU;
  
  static
  {
    AppMethodBeat.i(237118);
    jIU = new a((byte)0);
    AppMethodBeat.o(237118);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(237114);
    akx localakx = new akx();
    aky localaky = new aky();
    localakx.VHS = 1;
    localakx.ProductID = paramString;
    localakx.CPw = 1;
    localakx.SvE = null;
    paramString = new d.a();
    paramString.c((a)localakx);
    paramString.d((a)localaky);
    paramString.TW("/cgi-bin/micromsg-bin/exchangeemotionpack");
    paramString.vD(423);
    paramString.vF(213);
    paramString.vG(1000000213);
    c(paramString.bgN());
    AppMethodBeat.o(237114);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/cgi/CgiExchangeEmotionPack$Companion;", "", "()V", "MM_EXCHANGE_EMOTION_PACK", "", "MM_EXCHANGE_EMOTION_PIECE", "NOT_PAY_PRODUCT", "NOT_VALID_AREA", "NOT_VALID_WEAR", "NO_SUCH_PRODUCT", "PRODUCT_EXPIRED", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.a.b
 * JD-Core Version:    0.7.0.1
 */