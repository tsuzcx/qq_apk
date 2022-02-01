package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.protocal.protobuf.yf;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.ak.a<yf>
{
  public a(LinkedList<yd> paramLinkedList, int paramInt, String paramString)
  {
    AppMethodBeat.i(6200);
    b.a locala = new b.a();
    locala.funcId = 2731;
    locala.uri = "/cgi-bin/mmbiz-bin/checktmplver";
    locala.hQH = 0;
    locala.respCmdId = 0;
    ye localye = new ye();
    localye.Scene = paramInt;
    localye.oxI = paramString;
    localye.Gqh = paramLinkedList;
    locala.hQF = localye;
    locala.hQG = new yf();
    c(locala.aDS());
    AppMethodBeat.o(6200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a
 * JD-Core Version:    0.7.0.1
 */