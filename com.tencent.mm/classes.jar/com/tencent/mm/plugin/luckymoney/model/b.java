package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.protocal.protobuf.vb;

public final class b
  extends a<vb>
{
  public b(String paramString)
  {
    AppMethodBeat.i(42271);
    va localva = new va();
    localva.materialId = paramString;
    paramString = new b.a();
    paramString.fsX = localva;
    paramString.fsY = new vb();
    paramString.funcId = 2665;
    paramString.uri = "/cgi-bin/mmpay-bin/ftfhb/deleteshowsource";
    this.rr = paramString.ado();
    AppMethodBeat.o(42271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.b
 * JD-Core Version:    0.7.0.1
 */