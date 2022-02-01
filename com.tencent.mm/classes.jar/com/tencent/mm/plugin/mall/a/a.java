package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.al.a<jo>
{
  public List<cir> vDa;
  
  public a(LinkedList<cir> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(65987);
    jn localjn = new jn();
    localjn.FCn = paramLinkedList;
    localjn.FCo = paramInt;
    localjn.FCp = 0;
    b.a locala = new b.a();
    locala.hNM = localjn;
    locala.hNN = new jo();
    locala.funcId = 2938;
    locala.uri = "/cgi-bin/micromsg-bin/batchfunctionoperate";
    locala.hNO = 0;
    locala.respCmdId = 0;
    c(locala.aDC());
    this.vDa = paramLinkedList;
    ad.i("MicroMsg.CgiBatchFunctionOperate", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(65987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.a
 * JD-Core Version:    0.7.0.1
 */