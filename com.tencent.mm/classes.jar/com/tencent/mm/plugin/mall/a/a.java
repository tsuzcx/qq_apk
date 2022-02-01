package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.byw;
import com.tencent.mm.protocal.protobuf.iy;
import com.tencent.mm.protocal.protobuf.iz;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends c<iz>
{
  public List<byw> tse;
  
  public a(LinkedList<byw> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(65987);
    iy localiy = new iy();
    localiy.CEr = paramLinkedList;
    localiy.CEs = paramInt;
    localiy.CEt = 0;
    b.a locala = new b.a();
    locala.gUU = localiy;
    locala.gUV = new iz();
    locala.funcId = 2938;
    locala.uri = "/cgi-bin/micromsg-bin/batchfunctionoperate";
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.tse = paramLinkedList;
    ad.i("MicroMsg.CgiBatchFunctionOperate", "TpaCountry: %s", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(65987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.a
 * JD-Core Version:    0.7.0.1
 */