package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class q
  extends com.tencent.mm.ak.q
  implements m
{
  private i heq;
  private final d iIu;
  
  public q(LinkedList<eft> paramLinkedList)
  {
    AppMethodBeat.i(121053);
    d.a locala = new d.a();
    locala.iLN = new lf();
    locala.iLO = new lg();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
    locala.funcId = getType();
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.iIu = locala.aXF();
    ((lf)this.iIu.iLK.iLR).KPa = paramLinkedList;
    AppMethodBeat.o(121053);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(121055);
    Log.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
    this.heq = parami;
    int i = dispatch(paramg, this.iIu, this);
    AppMethodBeat.o(121055);
    return i;
  }
  
  public final int getType()
  {
    return 1176;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(121054);
    Log.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.heq != null) {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.q
 * JD-Core Version:    0.7.0.1
 */