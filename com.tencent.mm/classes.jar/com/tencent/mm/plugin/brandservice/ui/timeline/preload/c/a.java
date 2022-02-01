package com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.protocal.protobuf.abx;
import java.util.LinkedList;

public final class a
  extends b<abx>
{
  public a(LinkedList<abv> paramLinkedList, int paramInt, String paramString)
  {
    AppMethodBeat.i(6200);
    c.a locala = new c.a();
    locala.funcId = 2731;
    locala.uri = "/cgi-bin/mmbiz-bin/checktmplver";
    locala.otG = 0;
    locala.respCmdId = 0;
    abw localabw = new abw();
    localabw.IJG = paramInt;
    localabw.vYk = paramString;
    localabw.YML = paramLinkedList;
    locala.otE = localabw;
    locala.otF = new abx();
    c(locala.bEF());
    AppMethodBeat.o(6200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.a
 * JD-Core Version:    0.7.0.1
 */