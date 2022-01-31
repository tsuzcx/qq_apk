package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.protocal.protobuf.bul;
import com.tencent.mm.protocal.protobuf.tr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public class j
  extends a<bul>
{
  public j(long paramLong, LinkedList<aam> paramLinkedList, LinkedList<tr> paramLinkedList1, int paramInt1, int paramInt2, int paramInt3, ts paramts)
  {
    AppMethodBeat.i(129758);
    ab.i("MicroMsg.Recommend.CgiReportRecommendWxa", "sessionId:%d, action_scene:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    b.a locala = new b.a();
    buk localbuk = new buk();
    localbuk.bqN = paramLong;
    localbuk.xHC = paramLinkedList;
    localbuk.xHF = paramLinkedList1;
    localbuk.xHD = paramInt1;
    localbuk.xHE = paramInt2;
    localbuk.xHG = paramInt3;
    localbuk.xfd = paramts;
    locala.fsX = localbuk;
    locala.fsY = new bul();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportrecommendwxa";
    locala.funcId = 2564;
    this.rr = locala.ado();
    AppMethodBeat.o(129758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.j
 * JD-Core Version:    0.7.0.1
 */