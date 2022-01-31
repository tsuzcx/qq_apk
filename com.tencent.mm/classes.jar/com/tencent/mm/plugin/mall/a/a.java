package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.protocal.protobuf.ib;
import com.tencent.mm.protocal.protobuf.ic;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.ai.a<ic>
{
  public List<bkw> oxE;
  
  public a(LinkedList<bkw> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(43092);
    ib localib = new ib();
    localib.wuA = paramLinkedList;
    localib.wuB = paramInt;
    localib.wuC = 0;
    b.a locala = new b.a();
    locala.fsX = localib;
    locala.fsY = new ic();
    locala.funcId = 2938;
    locala.uri = "/cgi-bin/micromsg-bin/batchfunctionoperate";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.oxE = paramLinkedList;
    ab.i("MicroMsg.CgiBatchFunctionOperate", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(43092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.a
 * JD-Core Version:    0.7.0.1
 */