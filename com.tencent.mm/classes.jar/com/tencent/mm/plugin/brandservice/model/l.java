package com.tencent.mm.plugin.brandservice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.epu;
import com.tencent.mm.protocal.protobuf.epv;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class l
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public l(LinkedList<pw> paramLinkedList, int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, int paramInt5, long paramLong2)
  {
    AppMethodBeat.i(303460);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new epu();
    ((c.a)localObject).otF = new epv();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/reportshow";
    ((c.a)localObject).funcId = 2645;
    ((c.a)localObject).otG = 176;
    ((c.a)localObject).respCmdId = 1000000176;
    this.rr = ((c.a)localObject).bEF();
    localObject = (epu)c.b.b(this.rr.otB);
    ((epu)localObject).abtM = paramLinkedList;
    ((epu)localObject).abtN = paramInt1;
    ((epu)localObject).abtO = paramInt2;
    ((epu)localObject).YPI = paramInt3;
    ((epu)localObject).abtP = paramLong1;
    ((epu)localObject).scene = paramInt4;
    ((epu)localObject).abtQ = paramInt5;
    ((epu)localObject).abtR = paramLong2;
    Log.i("MicroMsg.NetSceneReportBizListShowInfo", "reportshow report_list size %d,enter_pos %d,exit_pos %d, scene=%d, actType=%d, exposeId=%d", new Object[] { Integer.valueOf(((epu)localObject).abtM.size()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Long.valueOf(paramLong2) });
    AppMethodBeat.o(303460);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(5586);
    this.callback = paramh;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.l
 * JD-Core Version:    0.7.0.1
 */