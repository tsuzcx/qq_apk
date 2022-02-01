package com.tencent.mm.plugin.brandservice.ui.timeline.preload.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.protocal.protobuf.zw;
import com.tencent.mm.protocal.protobuf.zx;
import java.util.LinkedList;

public final class a
  extends c<zx>
{
  public a(LinkedList<zv> paramLinkedList, int paramInt, String paramString)
  {
    AppMethodBeat.i(6200);
    d.a locala = new d.a();
    locala.funcId = 2731;
    locala.uri = "/cgi-bin/mmbiz-bin/checktmplver";
    locala.lBW = 0;
    locala.respCmdId = 0;
    zw localzw = new zw();
    localzw.CPw = paramInt;
    localzw.sSU = paramString;
    localzw.Smi = paramLinkedList;
    locala.lBU = localzw;
    locala.lBV = new zx();
    c(locala.bgN());
    AppMethodBeat.o(6200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.a
 * JD-Core Version:    0.7.0.1
 */