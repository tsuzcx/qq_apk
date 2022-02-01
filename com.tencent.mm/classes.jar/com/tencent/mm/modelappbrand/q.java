package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.epv;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class q
  extends com.tencent.mm.an.q
  implements m
{
  private i jQg;
  private final d lyx;
  
  public q(LinkedList<epv> paramLinkedList)
  {
    AppMethodBeat.i(121053);
    d.a locala = new d.a();
    locala.lBU = new kv();
    locala.lBV = new kw();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
    locala.funcId = getType();
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.lyx = locala.bgN();
    ((kv)d.b.b(this.lyx.lBR)).RPY = paramLinkedList;
    AppMethodBeat.o(121053);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(121055);
    Log.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
    this.jQg = parami;
    int i = dispatch(paramg, this.lyx, this);
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
    if (this.jQg != null) {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.q
 * JD-Core Version:    0.7.0.1
 */