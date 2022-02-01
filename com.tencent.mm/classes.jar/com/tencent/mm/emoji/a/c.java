package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/CgiGetEmotionDetail;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionDetailResponse;", "productId", "", "(Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.al.c<GetEmotionDetailResponse>
{
  private final String dft;
  
  public c(String paramString)
  {
    AppMethodBeat.i(183954);
    this.dft = paramString;
    paramString = new GetEmotionDetailRequest();
    GetEmotionDetailResponse localGetEmotionDetailResponse = new GetEmotionDetailResponse();
    paramString.ProductID = this.dft;
    paramString.Version = -1;
    paramString.Scene = 3;
    b.a locala = new b.a();
    locala.c((a)paramString);
    locala.d((a)localGetEmotionDetailResponse);
    locala.wg("/cgi-bin/micromsg-bin/getemotiondetail");
    locala.nB(412);
    c(locala.atI());
    AppMethodBeat.o(183954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */