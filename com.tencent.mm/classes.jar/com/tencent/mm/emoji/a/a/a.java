package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackRequest;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackResponse;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/cgi/CgiExchangeEmotionPack;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ExchangeEmotionPackResponse;", "groupId", "", "scene", "", "(Ljava/lang/String;I)V", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.ak.a<ExchangeEmotionPackResponse>
{
  public static final a gnc;
  
  static
  {
    AppMethodBeat.i(188559);
    gnc = new a((byte)0);
    AppMethodBeat.o(188559);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(188558);
    ExchangeEmotionPackRequest localExchangeEmotionPackRequest = new ExchangeEmotionPackRequest();
    ExchangeEmotionPackResponse localExchangeEmotionPackResponse = new ExchangeEmotionPackResponse();
    localExchangeEmotionPackRequest.IsAutomatic = 1;
    localExchangeEmotionPackRequest.ProductID = paramString;
    localExchangeEmotionPackRequest.Scene = 1;
    localExchangeEmotionPackRequest.SeriesID = null;
    paramString = new b.a();
    paramString.c((com.tencent.mm.bw.a)localExchangeEmotionPackRequest);
    paramString.d((com.tencent.mm.bw.a)localExchangeEmotionPackResponse);
    paramString.DN("/cgi-bin/micromsg-bin/exchangeemotionpack");
    paramString.oS(423);
    paramString.oU(213);
    paramString.oV(1000000213);
    c(paramString.aDS());
    AppMethodBeat.o(188558);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/cgi/CgiExchangeEmotionPack$Companion;", "", "()V", "MM_EXCHANGE_EMOTION_PACK", "", "MM_EXCHANGE_EMOTION_PIECE", "NOT_PAY_PRODUCT", "NOT_VALID_AREA", "NOT_VALID_WEAR", "NO_SUCH_PRODUCT", "PRODUCT_EXPIRED", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */