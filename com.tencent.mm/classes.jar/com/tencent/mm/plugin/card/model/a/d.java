package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteMchInList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "marchantId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class d
  extends j<aeo>
{
  private static final String TAG = "MicroMsg.CgiDeleteMchInList";
  public static final a oHH;
  
  static
  {
    AppMethodBeat.i(112388);
    oHH = new a((byte)0);
    TAG = "MicroMsg.CgiDeleteMchInList";
    AppMethodBeat.o(112388);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(112387);
    aen localaen = new aen();
    aeo localaeo = new aeo();
    localaen.GiJ = paramString;
    a((cvw)localaen, (cwj)localaeo, 1768, "/cgi-bin/mmpay-bin/mktdeletemchinlist");
    ae.i(TAG, "delete mch: %s", new Object[] { paramString });
    AppMethodBeat.o(112387);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteMchInList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.d
 * JD-Core Version:    0.7.0.1
 */