package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fku;
import com.tencent.mm.protocal.protobuf.lr;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class q
  extends p
  implements m
{
  private h mAY;
  private final c opY;
  
  public q(LinkedList<fku> paramLinkedList)
  {
    AppMethodBeat.i(121053);
    c.a locala = new c.a();
    locala.otE = new lr();
    locala.otF = new ls();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
    locala.funcId = getType();
    locala.otG = 0;
    locala.respCmdId = 0;
    this.opY = locala.bEF();
    ((lr)c.b.b(this.opY.otB)).YNm = paramLinkedList;
    AppMethodBeat.o(121053);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(121055);
    Log.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
    this.mAY = paramh;
    int i = dispatch(paramg, this.opY, this);
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
    if (this.mAY != null) {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(121054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.q
 * JD-Core Version:    0.7.0.1
 */