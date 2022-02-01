package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.protobuf.byc;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetMemberCardHistoryRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "pageNum", "", "pageSize", "(JJ)V", "Companion", "plugin-card_release"})
public final class d
  extends j<byc>
{
  public static final a trG;
  
  static
  {
    AppMethodBeat.i(246677);
    trG = new a((byte)0);
    AppMethodBeat.o(246677);
  }
  
  public d(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(246676);
    byb localbyb = new byb();
    byc localbyc = new byc();
    localbyb.Tdn = paramLong1;
    localbyb.Tdo = paramLong2;
    a((dyl)localbyb, (dyy)localbyc, 4406, "/cgi-bin/mmpay-bin/mktgetmembercardhistory");
    Log.i("MicroMsg.CgiGetMemberCardHistoryRequest", "pageNum: " + paramLong1 + ", pageSize: " + paramLong2);
    AppMethodBeat.o(246676);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetMemberCardHistoryRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.d
 * JD-Core Version:    0.7.0.1
 */