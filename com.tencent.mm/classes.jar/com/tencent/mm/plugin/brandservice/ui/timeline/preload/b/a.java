package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.protocal.protobuf.vt;
import java.util.LinkedList;

public final class a
  extends c<vt>
{
  public a(LinkedList<vr> paramLinkedList, int paramInt, String paramString)
  {
    AppMethodBeat.i(6200);
    b.a locala = new b.a();
    locala.funcId = 2731;
    locala.uri = "/cgi-bin/mmbiz-bin/checktmplver";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    vs localvs = new vs();
    localvs.Scene = paramInt;
    localvs.nlG = paramString;
    localvs.CXO = paramLinkedList;
    locala.gUU = localvs;
    locala.gUV = new vt();
    this.rr = locala.atI();
    AppMethodBeat.o(6200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a
 * JD-Core Version:    0.7.0.1
 */