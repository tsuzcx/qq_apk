package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.protocal.protobuf.iw;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class o
  extends m
  implements k
{
  private f eGj;
  private final b fpW;
  
  public o(LinkedList<ciy> paramLinkedList)
  {
    AppMethodBeat.i(93730);
    b.a locala = new b.a();
    locala.fsX = new iw();
    locala.fsY = new ix();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
    locala.funcId = getType();
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.fpW = locala.ado();
    ((iw)this.fpW.fsV.fta).wvb = paramLinkedList;
    AppMethodBeat.o(93730);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(93732);
    ab.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
    this.eGj = paramf;
    int i = dispatch(parame, this.fpW, this);
    AppMethodBeat.o(93732);
    return i;
  }
  
  public final int getType()
  {
    return 1176;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93731);
    ab.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.eGj != null) {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(93731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.o
 * JD-Core Version:    0.7.0.1
 */