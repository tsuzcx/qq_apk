package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ace;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteMchInList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "marchantId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class d
  extends j<acf>
{
  private static final String TAG = "MicroMsg.CgiDeleteMchInList";
  public static final a nXL;
  
  static
  {
    AppMethodBeat.i(112388);
    nXL = new a((byte)0);
    TAG = "MicroMsg.CgiDeleteMchInList";
    AppMethodBeat.o(112388);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(112387);
    ace localace = new ace();
    acf localacf = new acf();
    localace.Eja = paramString;
    a((cpx)localace, (cqk)localacf, 1768, "/cgi-bin/mmpay-bin/mktdeletemchinlist");
    ac.i(TAG, "delete mch: %s", new Object[] { paramString });
    AppMethodBeat.o(112387);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteMchInList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.d
 * JD-Core Version:    0.7.0.1
 */