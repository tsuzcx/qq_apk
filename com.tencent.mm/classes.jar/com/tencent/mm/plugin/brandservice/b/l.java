package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwq;
import com.tencent.mm.protocal.protobuf.dwr;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class l
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public l(LinkedList<on> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, int paramInt5, long paramLong2)
  {
    AppMethodBeat.i(265103);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dwq();
    ((d.a)localObject).lBV = new dwr();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/reportshow";
    ((d.a)localObject).funcId = 2645;
    ((d.a)localObject).lBW = 176;
    ((d.a)localObject).respCmdId = 1000000176;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dwq)d.b.b(this.rr.lBR);
    ((dwq)localObject).Ucs = paramLinkedList;
    ((dwq)localObject).Uct = paramInt1;
    ((dwq)localObject).Ucu = paramInt2;
    ((dwq)localObject).RSi = paramInt3;
    ((dwq)localObject).Ucv = paramLong1;
    ((dwq)localObject).scene = paramInt4;
    ((dwq)localObject).Ucw = paramInt5;
    ((dwq)localObject).Ucx = paramLong2;
    Log.i("MicroMsg.NetSceneReportBizListShowInfo", "reportshow report_list size %d,enter_pos %d,exit_pos %d, scene=%d, actType=%d, exposeId=%d", new Object[] { Integer.valueOf(((dwq)localObject).Ucs.size()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Long.valueOf(paramLong2) });
    AppMethodBeat.o(265103);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(5586);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(5586);
    return i;
  }
  
  public final int getType()
  {
    return 2645;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5585);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(5585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.l
 * JD-Core Version:    0.7.0.1
 */