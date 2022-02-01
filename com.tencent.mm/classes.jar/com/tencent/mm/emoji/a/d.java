package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/CgiGetEmotionDetail;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionDetailResponse;", "productId", "", "(Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "plugin-emojisdk_release"})
public final class d
  extends com.tencent.mm.al.a<GetEmotionDetailResponse>
{
  private final String dok;
  
  public d(String paramString)
  {
    AppMethodBeat.i(183954);
    this.dok = paramString;
    paramString = new GetEmotionDetailRequest();
    GetEmotionDetailResponse localGetEmotionDetailResponse = new GetEmotionDetailResponse();
    paramString.ProductID = this.dok;
    paramString.Version = -1;
    paramString.Scene = 3;
    b.a locala = new b.a();
    locala.c((com.tencent.mm.bx.a)paramString);
    locala.d((com.tencent.mm.bx.a)localGetEmotionDetailResponse);
    locala.Dl("/cgi-bin/micromsg-bin/getemotiondetail");
    locala.oP(412);
    c(locala.aDC());
    AppMethodBeat.o(183954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */