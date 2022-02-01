package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.agr;
import com.tencent.mm.protocal.protobuf.ags;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteMchInList;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/DeleteMchInListResponse;", "marchantId", "", "(Ljava/lang/String;)V", "Companion", "plugin-card_release"})
public final class d
  extends j<ags>
{
  private static final String TAG = "MicroMsg.CgiDeleteMchInList";
  public static final a pVq;
  
  static
  {
    AppMethodBeat.i(112388);
    pVq = new a((byte)0);
    TAG = "MicroMsg.CgiDeleteMchInList";
    AppMethodBeat.o(112388);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(112387);
    agr localagr = new agr();
    ags localags = new ags();
    localagr.Ldn = paramString;
    a((dop)localagr, (dpc)localags, 1768, "/cgi-bin/mmpay-bin/mktdeletemchinlist");
    Log.i(TAG, "delete mch: %s", new Object[] { paramString });
    AppMethodBeat.o(112387);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CgiDeleteMchInList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.d
 * JD-Core Version:    0.7.0.1
 */