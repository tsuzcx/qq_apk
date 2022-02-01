package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aee;
import com.tencent.mm.protocal.protobuf.aef;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteMchInList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "marchantId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class d
  extends j<aef>
{
  private static final String TAG = "MicroMsg.CgiDeleteMchInList";
  public static final a oBf;
  
  static
  {
    AppMethodBeat.i(112388);
    oBf = new a((byte)0);
    TAG = "MicroMsg.CgiDeleteMchInList";
    AppMethodBeat.o(112388);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(112387);
    aee localaee = new aee();
    aef localaef = new aef();
    localaee.FQk = paramString;
    a((cvc)localaee, (cvp)localaef, 1768, "/cgi-bin/mmpay-bin/mktdeletemchinlist");
    ad.i(TAG, "delete mch: %s", new Object[] { paramString });
    AppMethodBeat.o(112387);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteMchInList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.d
 * JD-Core Version:    0.7.0.1
 */