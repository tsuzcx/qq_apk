package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.protocal.protobuf.zs;
import com.tencent.mm.protocal.protobuf.zt;
import java.util.LinkedList;

public final class a
  extends c<zt>
{
  public a(LinkedList<zr> paramLinkedList, int paramInt, String paramString)
  {
    AppMethodBeat.i(6200);
    d.a locala = new d.a();
    locala.funcId = 2731;
    locala.uri = "/cgi-bin/mmbiz-bin/checktmplver";
    locala.iLP = 0;
    locala.respCmdId = 0;
    zs localzs = new zs();
    localzs.Scene = paramInt;
    localzs.pLm = paramString;
    localzs.LkZ = paramLinkedList;
    locala.iLN = localzs;
    locala.iLO = new zt();
    c(locala.aXF());
    AppMethodBeat.o(6200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a
 * JD-Core Version:    0.7.0.1
 */