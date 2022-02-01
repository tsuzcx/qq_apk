package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.eqw;
import com.tencent.mm.protocal.protobuf.eqx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class i
  extends b<eqx>
{
  public i(long paramLong, LinkedList<aot> paramLinkedList, LinkedList<acu> paramLinkedList1, int paramInt1, int paramInt2, int paramInt3, acz paramacz)
  {
    AppMethodBeat.i(44689);
    Log.i("MicroMsg.Recommend.CgiReportRecommendWxa", "sessionId:%d, action_scene:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    c.a locala = new c.a();
    eqw localeqw = new eqw();
    localeqw.aaxM = paramLong;
    localeqw.abuu = paramLinkedList;
    localeqw.abux = paramLinkedList1;
    localeqw.abuv = paramInt1;
    localeqw.abuw = paramInt2;
    localeqw.start_time = paramInt3;
    localeqw.aaxN = paramacz;
    locala.otE = localeqw;
    locala.otF = new eqx();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportrecommendwxa";
    locala.funcId = 2564;
    c(locala.bEF());
    AppMethodBeat.o(44689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.i
 * JD-Core Version:    0.7.0.1
 */