package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.god;
import com.tencent.mm.protocal.protobuf.goe;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/CgiGetEmotionDetail;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionDetailResponse;", "productId", "", "(Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b<goe>
{
  private final String productId;
  
  public d(String paramString)
  {
    AppMethodBeat.i(183954);
    this.productId = paramString;
    paramString = new god();
    goe localgoe = new goe();
    paramString.ProductID = this.productId;
    paramString.crz = -1;
    paramString.IJG = 3;
    c.a locala = new c.a();
    locala.otE = ((a)paramString);
    locala.otF = ((a)localgoe);
    locala.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
    locala.funcId = 412;
    c(locala.bEF());
    AppMethodBeat.o(183954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.c.d
 * JD-Core Version:    0.7.0.1
 */