package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.bqh;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetMemberCardHistoryRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "pageNum", "", "pageSize", "(JJ)V", "Companion", "plugin-card_release"})
public final class d
  extends j<bqi>
{
  public static final a pVF;
  
  static
  {
    AppMethodBeat.i(201387);
    pVF = new a((byte)0);
    AppMethodBeat.o(201387);
  }
  
  public d(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(201386);
    bqh localbqh = new bqh();
    bqi localbqi = new bqi();
    localbqh.LUF = paramLong1;
    localbqh.LUG = paramLong2;
    a((dop)localbqh, (dpc)localbqi, 4406, "/cgi-bin/mmpay-bin/mktgetmembercardhistory");
    Log.i("MicroMsg.CgiGetMemberCardHistoryRequest", "pageNum: " + paramLong1 + ", pageSize: " + paramLong2);
    AppMethodBeat.o(201386);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetMemberCardHistoryRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.d
 * JD-Core Version:    0.7.0.1
 */