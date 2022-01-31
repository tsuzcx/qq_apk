package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.protocal.protobuf.sz;
import com.tencent.mm.protocal.protobuf.ta;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.ai.a<ta>
{
  public a(LinkedList<sy> paramLinkedList, int paramInt, String paramString)
  {
    AppMethodBeat.i(14407);
    b.a locala = new b.a();
    locala.funcId = 2731;
    locala.uri = "/cgi-bin/mmbiz-bin/checktmplver";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    sz localsz = new sz();
    localsz.Scene = paramInt;
    localsz.wuH = paramString;
    localsz.wLw = paramLinkedList;
    locala.fsX = localsz;
    locala.fsY = new ta();
    this.rr = locala.ado();
    AppMethodBeat.o(14407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a
 * JD-Core Version:    0.7.0.1
 */