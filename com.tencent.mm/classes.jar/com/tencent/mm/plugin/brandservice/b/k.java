package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dmy;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class k
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public k(LinkedList<ot> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(194855);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dmy();
    ((d.a)localObject).iLO = new dmz();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/reportshow";
    ((d.a)localObject).funcId = 2645;
    ((d.a)localObject).iLP = 176;
    ((d.a)localObject).respCmdId = 1000000176;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dmy)this.rr.iLK.iLR;
    ((dmy)localObject).MQm = paramLinkedList;
    ((dmy)localObject).MQn = paramInt1;
    ((dmy)localObject).MQo = paramInt2;
    ((dmy)localObject).KRg = paramInt3;
    ((dmy)localObject).MQp = paramLong;
    ((dmy)localObject).scene = paramInt4;
    ((dmy)localObject).MQq = paramInt5;
    Log.i("MicroMsg.NetSceneReportBizListShowInfo", "reportshow report_list size %d,enter_pos %d,exit_pos %d, scene=%d, actType=%d", new Object[] { Integer.valueOf(((dmy)localObject).MQm.size()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
    AppMethodBeat.o(194855);
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
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.k
 * JD-Core Version:    0.7.0.1
 */