package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.ebr;
import com.tencent.mm.protocal.protobuf.ko;
import com.tencent.mm.protocal.protobuf.kp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends z<kp>
{
  public List<ebr> KIX;
  
  public a(LinkedList<ebr> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(65987);
    ko localko = new ko();
    localko.YMB = paramLinkedList;
    localko.YMC = paramInt;
    localko.YMD = 0;
    c.a locala = new c.a();
    locala.otE = localko;
    locala.otF = new kp();
    locala.funcId = 2938;
    locala.uri = "/cgi-bin/micromsg-bin/batchfunctionoperate";
    locala.otG = 0;
    locala.respCmdId = 0;
    c(locala.bEF());
    this.KIX = paramLinkedList;
    Log.i("MicroMsg.CgiBatchFunctionOperate", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(65987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.a
 * JD-Core Version:    0.7.0.1
 */