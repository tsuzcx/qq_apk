package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/CgiGetEmotionDetail;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionDetailResponse;", "productId", "", "(Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "plugin-emojisdk_release"})
public final class d
  extends com.tencent.mm.ak.a<GetEmotionDetailResponse>
{
  private final String dpp;
  
  public d(String paramString)
  {
    AppMethodBeat.i(183954);
    this.dpp = paramString;
    paramString = new GetEmotionDetailRequest();
    GetEmotionDetailResponse localGetEmotionDetailResponse = new GetEmotionDetailResponse();
    paramString.ProductID = this.dpp;
    paramString.Version = -1;
    paramString.Scene = 3;
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bw.a)paramString);
    locala.d((com.tencent.mm.bw.a)localGetEmotionDetailResponse);
    locala.DN("/cgi-bin/micromsg-bin/getemotiondetail");
    locala.oS(412);
    c(locala.aDS());
    AppMethodBeat.o(183954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */