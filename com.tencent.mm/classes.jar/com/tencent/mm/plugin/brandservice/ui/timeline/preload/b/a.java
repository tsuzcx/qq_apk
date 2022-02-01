package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.ya;
import com.tencent.mm.protocal.protobuf.yb;
import com.tencent.mm.protocal.protobuf.yc;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.al.a<yc>
{
  public a(LinkedList<ya> paramLinkedList, int paramInt, String paramString)
  {
    AppMethodBeat.i(6200);
    b.a locala = new b.a();
    locala.funcId = 2731;
    locala.uri = "/cgi-bin/mmbiz-bin/checktmplver";
    locala.hNO = 0;
    locala.respCmdId = 0;
    yb localyb = new yb();
    localyb.Scene = paramInt;
    localyb.orm = paramString;
    localyb.FXI = paramLinkedList;
    locala.hNM = localyb;
    locala.hNN = new yc();
    c(locala.aDC());
    AppMethodBeat.o(6200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a
 * JD-Core Version:    0.7.0.1
 */