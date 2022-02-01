package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.js;
import com.tencent.mm.protocal.protobuf.jt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends c<jt>
{
  public List<djh> EOy;
  
  public a(LinkedList<djh> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(65987);
    js localjs = new js();
    localjs.RPo = paramLinkedList;
    localjs.RPp = paramInt;
    localjs.RPq = 0;
    d.a locala = new d.a();
    locala.lBU = localjs;
    locala.lBV = new jt();
    locala.funcId = 2938;
    locala.uri = "/cgi-bin/micromsg-bin/batchfunctionoperate";
    locala.lBW = 0;
    locala.respCmdId = 0;
    c(locala.bgN());
    this.EOy = paramLinkedList;
    Log.i("MicroMsg.CgiBatchFunctionOperate", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(65987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.a
 * JD-Core Version:    0.7.0.1
 */