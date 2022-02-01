package com.tencent.mm.emoji.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackRequest;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackResponse;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/cgi/CgiExchangeEmotionPack;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ExchangeEmotionPackResponse;", "groupId", "", "scene", "", "(Ljava/lang/String;I)V", "Companion", "plugin-emojisdk_release"})
public final class a
  extends c<ExchangeEmotionPackResponse>
{
  public static final a gXU;
  
  static
  {
    AppMethodBeat.i(199915);
    gXU = new a((byte)0);
    AppMethodBeat.o(199915);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(199914);
    ExchangeEmotionPackRequest localExchangeEmotionPackRequest = new ExchangeEmotionPackRequest();
    ExchangeEmotionPackResponse localExchangeEmotionPackResponse = new ExchangeEmotionPackResponse();
    localExchangeEmotionPackRequest.IsAutomatic = 1;
    localExchangeEmotionPackRequest.ProductID = paramString;
    localExchangeEmotionPackRequest.Scene = 1;
    localExchangeEmotionPackRequest.SeriesID = null;
    paramString = new d.a();
    paramString.c((com.tencent.mm.bw.a)localExchangeEmotionPackRequest);
    paramString.d((com.tencent.mm.bw.a)localExchangeEmotionPackResponse);
    paramString.MB("/cgi-bin/micromsg-bin/exchangeemotionpack");
    paramString.sG(423);
    paramString.sI(213);
    paramString.sJ(1000000213);
    c(paramString.aXF());
    AppMethodBeat.o(199914);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/cgi/CgiExchangeEmotionPack$Companion;", "", "()V", "MM_EXCHANGE_EMOTION_PACK", "", "MM_EXCHANGE_EMOTION_PIECE", "NOT_PAY_PRODUCT", "NOT_VALID_AREA", "NOT_VALID_WEAR", "NO_SUCH_PRODUCT", "PRODUCT_EXPIRED", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.a.a
 * JD-Core Version:    0.7.0.1
 */