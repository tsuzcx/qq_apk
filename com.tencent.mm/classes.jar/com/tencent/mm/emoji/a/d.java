package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/CgiGetEmotionDetail;", "Lcom/tencent/mm/modelbase/DeprecatedCgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionDetailResponse;", "productId", "", "(Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "plugin-emojisdk_release"})
public final class d
  extends c<GetEmotionDetailResponse>
{
  private final String dcO;
  
  public d(String paramString)
  {
    AppMethodBeat.i(183954);
    this.dcO = paramString;
    paramString = new GetEmotionDetailRequest();
    GetEmotionDetailResponse localGetEmotionDetailResponse = new GetEmotionDetailResponse();
    paramString.ProductID = this.dcO;
    paramString.Version = -1;
    paramString.Scene = 3;
    b.a locala = new b.a();
    locala.c((a)paramString);
    locala.d((a)localGetEmotionDetailResponse);
    locala.Am("/cgi-bin/micromsg-bin/getemotiondetail");
    locala.op(412);
    c(locala.aAz());
    AppMethodBeat.o(183954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */