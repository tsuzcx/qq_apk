package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.doa;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class j
  extends c<dob>
{
  public j(long paramLong, LinkedList<akf> paramLinkedList, LinkedList<aap> paramLinkedList1, int paramInt1, int paramInt2, int paramInt3, aat paramaat)
  {
    AppMethodBeat.i(44689);
    Log.i("MicroMsg.Recommend.CgiReportRecommendWxa", "sessionId:%d, action_scene:%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1) });
    d.a locala = new d.a();
    doa localdoa = new doa();
    localdoa.clK = paramLong;
    localdoa.MQT = paramLinkedList;
    localdoa.MQW = paramLinkedList1;
    localdoa.MQU = paramInt1;
    localdoa.MQV = paramInt2;
    localdoa.MQX = paramInt3;
    localdoa.MaO = paramaat;
    locala.iLN = localdoa;
    locala.iLO = new dob();
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/reportrecommendwxa";
    locala.funcId = 2564;
    c(locala.aXF());
    AppMethodBeat.o(44689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.j
 * JD-Core Version:    0.7.0.1
 */