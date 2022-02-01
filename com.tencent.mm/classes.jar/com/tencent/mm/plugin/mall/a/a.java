package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.kc;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends c<kd>
{
  public List<czt> zji;
  
  public a(LinkedList<czt> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(65987);
    kc localkc = new kc();
    localkc.KOq = paramLinkedList;
    localkc.KOr = paramInt;
    localkc.KOs = 0;
    d.a locala = new d.a();
    locala.iLN = localkc;
    locala.iLO = new kd();
    locala.funcId = 2938;
    locala.uri = "/cgi-bin/micromsg-bin/batchfunctionoperate";
    locala.iLP = 0;
    locala.respCmdId = 0;
    c(locala.aXF());
    this.zji = paramLinkedList;
    Log.i("MicroMsg.CgiBatchFunctionOperate", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(65987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.a
 * JD-Core Version:    0.7.0.1
 */