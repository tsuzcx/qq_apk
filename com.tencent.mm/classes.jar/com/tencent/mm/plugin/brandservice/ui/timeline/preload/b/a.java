package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.wb;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.protocal.protobuf.wd;
import java.util.LinkedList;

public final class a
  extends c<wd>
{
  public a(LinkedList<wb> paramLinkedList, int paramInt, String paramString)
  {
    AppMethodBeat.i(6200);
    b.a locala = new b.a();
    locala.funcId = 2731;
    locala.uri = "/cgi-bin/mmbiz-bin/checktmplver";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    wc localwc = new wc();
    localwc.Scene = paramInt;
    localwc.nOG = paramString;
    localwc.Eqx = paramLinkedList;
    locala.hvt = localwc;
    locala.hvu = new wd();
    this.rr = locala.aAz();
    AppMethodBeat.o(6200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a
 * JD-Core Version:    0.7.0.1
 */