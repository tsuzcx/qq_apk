package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.ak.a<jo>
{
  public List<cjl> vPe;
  
  public a(LinkedList<cjl> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(65987);
    jn localjn = new jn();
    localjn.FUI = paramLinkedList;
    localjn.FUJ = paramInt;
    localjn.FUK = 0;
    b.a locala = new b.a();
    locala.hQF = localjn;
    locala.hQG = new jo();
    locala.funcId = 2938;
    locala.uri = "/cgi-bin/micromsg-bin/batchfunctionoperate";
    locala.hQH = 0;
    locala.respCmdId = 0;
    c(locala.aDS());
    this.vPe = paramLinkedList;
    ae.i("MicroMsg.CgiBatchFunctionOperate", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(65987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.a
 * JD-Core Version:    0.7.0.1
 */