package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/CgiGetEmotionDetail;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionDetailResponse;", "productId", "", "(Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "plugin-emojisdk_release"})
public final class d
  extends c<GetEmotionDetailResponse>
{
  private final String productId;
  
  public d(String paramString)
  {
    AppMethodBeat.i(183954);
    this.productId = paramString;
    paramString = new GetEmotionDetailRequest();
    GetEmotionDetailResponse localGetEmotionDetailResponse = new GetEmotionDetailResponse();
    paramString.ProductID = this.productId;
    paramString.Version = -1;
    paramString.Scene = 3;
    d.a locala = new d.a();
    locala.c((a)paramString);
    locala.d((a)localGetEmotionDetailResponse);
    locala.MB("/cgi-bin/micromsg-bin/getemotiondetail");
    locala.sG(412);
    c(locala.aXF());
    AppMethodBeat.o(183954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.d
 * JD-Core Version:    0.7.0.1
 */