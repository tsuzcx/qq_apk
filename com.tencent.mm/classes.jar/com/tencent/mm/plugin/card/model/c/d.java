package com.tencent.mm.plugin.card.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.j;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetMemberCardHistoryRequest;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "pageNum", "", "pageSize", "(JJ)V", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends j<cnf>
{
  public static final a wwe;
  
  static
  {
    AppMethodBeat.i(294528);
    wwe = new a((byte)0);
    AppMethodBeat.o(294528);
  }
  
  public d(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(294524);
    cne localcne = new cne();
    cnf localcnf = new cnf();
    localcne.aaqC = paramLong1;
    localcne.aaqD = paramLong2;
    a((erp)localcne, (esc)localcnf, 4406, "/cgi-bin/mmpay-bin/mktgetmembercardhistory");
    Log.i("MicroMsg.CgiGetMemberCardHistoryRequest", "pageNum: " + paramLong1 + ", pageSize: " + paramLong2);
    AppMethodBeat.o(294524);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/model/v4/CgiGetMemberCardHistoryRequest$Companion;", "", "()V", "TAG", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.c.d
 * JD-Core Version:    0.7.0.1
 */