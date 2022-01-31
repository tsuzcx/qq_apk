package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.va;
import com.tencent.mm.protocal.protobuf.vb;

public final class a
  extends com.tencent.mm.ai.a<vb>
{
  public a(String paramString)
  {
    AppMethodBeat.i(42270);
    va localva = new va();
    localva.materialId = paramString;
    paramString = new b.a();
    paramString.fsX = localva;
    paramString.fsY = new vb();
    paramString.funcId = 2968;
    paramString.uri = "/cgi-bin/mmpay-bin/ftfhb/confirmshowsource";
    this.rr = paramString.ado();
    AppMethodBeat.o(42270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.a
 * JD-Core Version:    0.7.0.1
 */