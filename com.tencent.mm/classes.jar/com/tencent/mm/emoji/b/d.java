package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.bud;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/CgiGetEmotionDetail;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionDetailResponse;", "productId", "", "(Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "plugin-emojisdk_release"})
public final class d
  extends c<bud>
{
  private final String productId;
  
  public d(String paramString)
  {
    AppMethodBeat.i(183954);
    this.productId = paramString;
    paramString = new buc();
    bud localbud = new bud();
    paramString.ProductID = this.productId;
    paramString.rWt = -1;
    paramString.CPw = 3;
    d.a locala = new d.a();
    locala.c((a)paramString);
    locala.d((a)localbud);
    locala.TW("/cgi-bin/micromsg-bin/getemotiondetail");
    locala.vD(412);
    c(locala.bgN());
    AppMethodBeat.o(183954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.b.d
 * JD-Core Version:    0.7.0.1
 */